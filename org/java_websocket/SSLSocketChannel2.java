package org.java_websocket;

import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* compiled from: P */
/* loaded from: classes38.dex */
public class SSLSocketChannel2 implements ByteChannel, WrappedByteChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected int bufferallocations = 0;
    protected ExecutorService exec;
    protected ByteBuffer inCrypt;
    protected ByteBuffer inData;
    protected ByteBuffer outCrypt;
    protected SSLEngineResult readEngineResult;
    protected SelectionKey selectionKey;
    protected SocketChannel socketChannel;
    protected SSLEngine sslEngine;
    protected List<Future<?>> tasks;
    protected SSLEngineResult writeEngineResult;
    private static final Logger log = LoggerFactory.getLogger((Class<?>) SSLSocketChannel2.class);
    protected static ByteBuffer emptybuffer = ByteBuffer.allocate(0);

    public SSLSocketChannel2(SocketChannel socketChannel, SSLEngine sSLEngine, ExecutorService executorService, SelectionKey selectionKey) throws IOException {
        if (socketChannel != null && sSLEngine != null && executorService != null) {
            this.socketChannel = socketChannel;
            this.sslEngine = sSLEngine;
            this.exec = executorService;
            SSLEngineResult sSLEngineResult = new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW, sSLEngine.getHandshakeStatus(), 0, 0);
            this.writeEngineResult = sSLEngineResult;
            this.readEngineResult = sSLEngineResult;
            this.tasks = new ArrayList(3);
            if (selectionKey != null) {
                selectionKey.interestOps(selectionKey.interestOps() | 4);
                this.selectionKey = selectionKey;
            }
            createBuffers(sSLEngine.getSession());
            this.socketChannel.write(wrap(emptybuffer));
            processHandshake();
            return;
        }
        throw new IllegalArgumentException("parameter must not be null");
    }

    private void consumeFutureUninterruptible(Future<?> future) {
        while (true) {
            try {
                try {
                    future.get();
                    return;
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            } catch (ExecutionException e16) {
                throw new RuntimeException(e16);
            }
        }
    }

    private boolean isHandShakeComplete() {
        SSLEngineResult.HandshakeStatus handshakeStatus = this.sslEngine.getHandshakeStatus();
        return handshakeStatus == SSLEngineResult.HandshakeStatus.FINISHED || handshakeStatus == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
    }

    private synchronized void processHandshake() throws IOException {
        if (this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
            return;
        }
        if (!this.tasks.isEmpty()) {
            Iterator<Future<?>> it = this.tasks.iterator();
            while (it.hasNext()) {
                Future<?> next = it.next();
                if (next.isDone()) {
                    it.remove();
                } else {
                    if (isBlocking()) {
                        consumeFutureUninterruptible(next);
                    }
                    return;
                }
            }
        }
        if (this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
            if (!isBlocking() || this.readEngineResult.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW) {
                this.inCrypt.compact();
                if (this.socketChannel.read(this.inCrypt) != -1) {
                    this.inCrypt.flip();
                } else {
                    throw new IOException("connection closed unexpectedly by peer");
                }
            }
            this.inData.compact();
            unwrap();
            if (this.readEngineResult.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
                createBuffers(this.sslEngine.getSession());
                return;
            }
        }
        consumeDelegatedTasks();
        if (this.tasks.isEmpty() || this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_WRAP) {
            this.socketChannel.write(wrap(emptybuffer));
            if (this.writeEngineResult.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
                createBuffers(this.sslEngine.getSession());
                return;
            }
        }
        this.bufferallocations = 1;
    }

    private int readRemaining(ByteBuffer byteBuffer) throws SSLException {
        if (this.inData.hasRemaining()) {
            return transfereTo(this.inData, byteBuffer);
        }
        if (!this.inData.hasRemaining()) {
            this.inData.clear();
        }
        if (!this.inCrypt.hasRemaining()) {
            return 0;
        }
        unwrap();
        int transfereTo = transfereTo(this.inData, byteBuffer);
        if (this.readEngineResult.getStatus() == SSLEngineResult.Status.CLOSED) {
            return -1;
        }
        if (transfereTo > 0) {
            return transfereTo;
        }
        return 0;
    }

    private int transfereTo(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int remaining = byteBuffer.remaining();
        int remaining2 = byteBuffer2.remaining();
        if (remaining > remaining2) {
            int min = Math.min(remaining, remaining2);
            for (int i3 = 0; i3 < min; i3++) {
                byteBuffer2.put(byteBuffer.get());
            }
            return min;
        }
        byteBuffer2.put(byteBuffer);
        return remaining;
    }

    private synchronized ByteBuffer unwrap() throws SSLException {
        if (this.readEngineResult.getStatus() == SSLEngineResult.Status.CLOSED && this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
            try {
                close();
            } catch (IOException unused) {
            }
        }
        while (true) {
            int remaining = this.inData.remaining();
            SSLEngineResult unwrap = this.sslEngine.unwrap(this.inCrypt, this.inData);
            this.readEngineResult = unwrap;
            if (unwrap.getStatus() != SSLEngineResult.Status.OK || (remaining == this.inData.remaining() && this.sslEngine.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.NEED_UNWRAP)) {
                break;
            }
        }
        this.inData.flip();
        return this.inData;
    }

    private synchronized ByteBuffer wrap(ByteBuffer byteBuffer) throws SSLException {
        this.outCrypt.compact();
        this.writeEngineResult = this.sslEngine.wrap(byteBuffer, this.outCrypt);
        this.outCrypt.flip();
        return this.outCrypt;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.sslEngine.closeOutbound();
        this.sslEngine.getSession().invalidate();
        if (this.socketChannel.isOpen()) {
            this.socketChannel.write(wrap(emptybuffer));
        }
        this.socketChannel.close();
    }

    public SelectableChannel configureBlocking(boolean z16) throws IOException {
        return this.socketChannel.configureBlocking(z16);
    }

    public boolean connect(SocketAddress socketAddress) throws IOException {
        return this.socketChannel.connect(socketAddress);
    }

    protected void consumeDelegatedTasks() {
        while (true) {
            Runnable delegatedTask = this.sslEngine.getDelegatedTask();
            if (delegatedTask == null) {
                return;
            } else {
                this.tasks.add(this.exec.submit(delegatedTask));
            }
        }
    }

    protected void createBuffers(SSLSession sSLSession) {
        int packetBufferSize = sSLSession.getPacketBufferSize();
        int max = Math.max(sSLSession.getApplicationBufferSize(), packetBufferSize);
        ByteBuffer byteBuffer = this.inData;
        if (byteBuffer == null) {
            this.inData = ByteBuffer.allocate(max);
            this.outCrypt = ByteBuffer.allocate(packetBufferSize);
            this.inCrypt = ByteBuffer.allocate(packetBufferSize);
        } else {
            if (byteBuffer.capacity() != max) {
                this.inData = ByteBuffer.allocate(max);
            }
            if (this.outCrypt.capacity() != packetBufferSize) {
                this.outCrypt = ByteBuffer.allocate(packetBufferSize);
            }
            if (this.inCrypt.capacity() != packetBufferSize) {
                this.inCrypt = ByteBuffer.allocate(packetBufferSize);
            }
        }
        if (this.inData.remaining() != 0) {
            Logger logger = log;
            if (logger.isTraceEnabled()) {
                logger.trace(new String(this.inData.array(), this.inData.position(), this.inData.remaining()));
            }
        }
        this.inData.rewind();
        this.inData.flip();
        if (this.inCrypt.remaining() != 0) {
            Logger logger2 = log;
            if (logger2.isTraceEnabled()) {
                logger2.trace(new String(this.inCrypt.array(), this.inCrypt.position(), this.inCrypt.remaining()));
            }
        }
        this.inCrypt.rewind();
        this.inCrypt.flip();
        this.outCrypt.rewind();
        this.outCrypt.flip();
        this.bufferallocations++;
    }

    public boolean finishConnect() throws IOException {
        return this.socketChannel.finishConnect();
    }

    @Override // org.java_websocket.WrappedByteChannel
    public boolean isBlocking() {
        return this.socketChannel.isBlocking();
    }

    public boolean isConnected() {
        return this.socketChannel.isConnected();
    }

    public boolean isInboundDone() {
        return this.sslEngine.isInboundDone();
    }

    @Override // org.java_websocket.WrappedByteChannel
    public boolean isNeedRead() {
        return this.inData.hasRemaining() || !(!this.inCrypt.hasRemaining() || this.readEngineResult.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW || this.readEngineResult.getStatus() == SSLEngineResult.Status.CLOSED);
    }

    @Override // org.java_websocket.WrappedByteChannel
    public boolean isNeedWrite() {
        return this.outCrypt.hasRemaining() || !isHandShakeComplete();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.socketChannel.isOpen();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        while (byteBuffer.hasRemaining()) {
            if (!isHandShakeComplete()) {
                if (isBlocking()) {
                    while (!isHandShakeComplete()) {
                        processHandshake();
                    }
                } else {
                    processHandshake();
                    if (!isHandShakeComplete()) {
                        return 0;
                    }
                }
            }
            int readRemaining = readRemaining(byteBuffer);
            if (readRemaining != 0) {
                return readRemaining;
            }
            this.inData.clear();
            if (!this.inCrypt.hasRemaining()) {
                this.inCrypt.clear();
            } else {
                this.inCrypt.compact();
            }
            if ((isBlocking() || this.readEngineResult.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW) && this.socketChannel.read(this.inCrypt) == -1) {
                return -1;
            }
            this.inCrypt.flip();
            unwrap();
            int transfereTo = transfereTo(this.inData, byteBuffer);
            if (transfereTo != 0 || !isBlocking()) {
                return transfereTo;
            }
        }
        return 0;
    }

    @Override // org.java_websocket.WrappedByteChannel
    public int readMore(ByteBuffer byteBuffer) throws SSLException {
        return readRemaining(byteBuffer);
    }

    public Socket socket() {
        return this.socketChannel.socket();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!isHandShakeComplete()) {
            processHandshake();
            return 0;
        }
        int write = this.socketChannel.write(wrap(byteBuffer));
        if (this.writeEngineResult.getStatus() != SSLEngineResult.Status.CLOSED) {
            return write;
        }
        throw new EOFException("Connection is closed");
    }

    @Override // org.java_websocket.WrappedByteChannel
    public void writeMore() throws IOException {
        write(this.outCrypt);
    }
}
