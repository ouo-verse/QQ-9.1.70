package org.apache.httpcore.impl;

import com.tencent.mobileqq.msf.core.x.q;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.httpcore.ConnectionClosedException;
import org.apache.httpcore.Header;
import org.apache.httpcore.HttpConnectionMetrics;
import org.apache.httpcore.HttpEntity;
import org.apache.httpcore.HttpException;
import org.apache.httpcore.HttpInetConnection;
import org.apache.httpcore.HttpMessage;
import org.apache.httpcore.config.MessageConstraints;
import org.apache.httpcore.entity.BasicHttpEntity;
import org.apache.httpcore.entity.ContentLengthStrategy;
import org.apache.httpcore.impl.entity.LaxContentLengthStrategy;
import org.apache.httpcore.impl.entity.StrictContentLengthStrategy;
import org.apache.httpcore.impl.io.ChunkedInputStream;
import org.apache.httpcore.impl.io.ChunkedOutputStream;
import org.apache.httpcore.impl.io.ContentLengthInputStream;
import org.apache.httpcore.impl.io.ContentLengthOutputStream;
import org.apache.httpcore.impl.io.EmptyInputStream;
import org.apache.httpcore.impl.io.HttpTransportMetricsImpl;
import org.apache.httpcore.impl.io.IdentityInputStream;
import org.apache.httpcore.impl.io.IdentityOutputStream;
import org.apache.httpcore.impl.io.SessionInputBufferImpl;
import org.apache.httpcore.impl.io.SessionOutputBufferImpl;
import org.apache.httpcore.io.SessionInputBuffer;
import org.apache.httpcore.io.SessionOutputBuffer;
import org.apache.httpcore.util.Args;
import org.apache.httpcore.util.NetUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BHttpConnectionBase implements HttpInetConnection {
    private final HttpConnectionMetricsImpl connMetrics;
    private final SessionInputBufferImpl inBuffer;
    private final ContentLengthStrategy incomingContentStrategy;
    private final MessageConstraints messageConstraints;
    private final SessionOutputBufferImpl outbuffer;
    private final ContentLengthStrategy outgoingContentStrategy;
    private final AtomicReference<Socket> socketHolder;

    /* JADX INFO: Access modifiers changed from: protected */
    public BHttpConnectionBase(int i3, int i16, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2) {
        MessageConstraints messageConstraints2;
        ContentLengthStrategy contentLengthStrategy3;
        ContentLengthStrategy contentLengthStrategy4;
        Args.positive(i3, "Buffer size");
        HttpTransportMetricsImpl httpTransportMetricsImpl = new HttpTransportMetricsImpl();
        HttpTransportMetricsImpl httpTransportMetricsImpl2 = new HttpTransportMetricsImpl();
        if (messageConstraints != null) {
            messageConstraints2 = messageConstraints;
        } else {
            messageConstraints2 = MessageConstraints.DEFAULT;
        }
        this.inBuffer = new SessionInputBufferImpl(httpTransportMetricsImpl, i3, -1, messageConstraints2, charsetDecoder);
        this.outbuffer = new SessionOutputBufferImpl(httpTransportMetricsImpl2, i3, i16, charsetEncoder);
        this.messageConstraints = messageConstraints;
        this.connMetrics = new HttpConnectionMetricsImpl(httpTransportMetricsImpl, httpTransportMetricsImpl2);
        if (contentLengthStrategy != null) {
            contentLengthStrategy3 = contentLengthStrategy;
        } else {
            contentLengthStrategy3 = LaxContentLengthStrategy.INSTANCE;
        }
        this.incomingContentStrategy = contentLengthStrategy3;
        if (contentLengthStrategy2 != null) {
            contentLengthStrategy4 = contentLengthStrategy2;
        } else {
            contentLengthStrategy4 = StrictContentLengthStrategy.INSTANCE;
        }
        this.outgoingContentStrategy = contentLengthStrategy4;
        this.socketHolder = new AtomicReference<>();
    }

    private int fillInputBuffer(int i3) throws IOException {
        Socket socket = this.socketHolder.get();
        int soTimeout = socket.getSoTimeout();
        try {
            socket.setSoTimeout(i3);
            return this.inBuffer.fillBuffer();
        } finally {
            socket.setSoTimeout(soTimeout);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean awaitInput(int i3) throws IOException {
        if (this.inBuffer.hasBufferedData()) {
            return true;
        }
        fillInputBuffer(i3);
        return this.inBuffer.hasBufferedData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bind(Socket socket) throws IOException {
        Args.notNull(socket, q.f250388t);
        this.socketHolder.set(socket);
        this.inBuffer.bind(null);
        this.outbuffer.bind(null);
    }

    @Override // org.apache.httpcore.HttpConnection, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Socket andSet = this.socketHolder.getAndSet(null);
        if (andSet != null) {
            try {
                this.inBuffer.clear();
                this.outbuffer.flush();
            } finally {
                andSet.close();
            }
        }
    }

    protected InputStream createInputStream(long j3, SessionInputBuffer sessionInputBuffer) {
        if (j3 == -2) {
            return new ChunkedInputStream(sessionInputBuffer, this.messageConstraints);
        }
        if (j3 == -1) {
            return new IdentityInputStream(sessionInputBuffer);
        }
        if (j3 == 0) {
            return EmptyInputStream.INSTANCE;
        }
        return new ContentLengthInputStream(sessionInputBuffer, j3);
    }

    protected OutputStream createOutputStream(long j3, SessionOutputBuffer sessionOutputBuffer) {
        if (j3 == -2) {
            return new ChunkedOutputStream(2048, sessionOutputBuffer);
        }
        if (j3 == -1) {
            return new IdentityOutputStream(sessionOutputBuffer);
        }
        return new ContentLengthOutputStream(sessionOutputBuffer, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doFlush() throws IOException {
        this.outbuffer.flush();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ensureOpen() throws IOException {
        Socket socket = this.socketHolder.get();
        if (socket != null) {
            if (!this.inBuffer.isBound()) {
                this.inBuffer.bind(getSocketInputStream(socket));
            }
            if (!this.outbuffer.isBound()) {
                this.outbuffer.bind(getSocketOutputStream(socket));
                return;
            }
            return;
        }
        throw new ConnectionClosedException();
    }

    @Override // org.apache.httpcore.HttpInetConnection
    public InetAddress getLocalAddress() {
        Socket socket = this.socketHolder.get();
        if (socket != null) {
            return socket.getLocalAddress();
        }
        return null;
    }

    @Override // org.apache.httpcore.HttpInetConnection
    public int getLocalPort() {
        Socket socket = this.socketHolder.get();
        if (socket != null) {
            return socket.getLocalPort();
        }
        return -1;
    }

    @Override // org.apache.httpcore.HttpConnection
    public HttpConnectionMetrics getMetrics() {
        return this.connMetrics;
    }

    @Override // org.apache.httpcore.HttpInetConnection
    public InetAddress getRemoteAddress() {
        Socket socket = this.socketHolder.get();
        if (socket != null) {
            return socket.getInetAddress();
        }
        return null;
    }

    @Override // org.apache.httpcore.HttpInetConnection
    public int getRemotePort() {
        Socket socket = this.socketHolder.get();
        if (socket != null) {
            return socket.getPort();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SessionInputBuffer getSessionInputBuffer() {
        return this.inBuffer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SessionOutputBuffer getSessionOutputBuffer() {
        return this.outbuffer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Socket getSocket() {
        return this.socketHolder.get();
    }

    protected InputStream getSocketInputStream(Socket socket) throws IOException {
        return socket.getInputStream();
    }

    protected OutputStream getSocketOutputStream(Socket socket) throws IOException {
        return socket.getOutputStream();
    }

    @Override // org.apache.httpcore.HttpConnection
    public int getSocketTimeout() {
        Socket socket = this.socketHolder.get();
        if (socket != null) {
            try {
                return socket.getSoTimeout();
            } catch (SocketException unused) {
                return -1;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void incrementRequestCount() {
        this.connMetrics.incrementRequestCount();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void incrementResponseCount() {
        this.connMetrics.incrementResponseCount();
    }

    @Override // org.apache.httpcore.HttpConnection
    public boolean isOpen() {
        if (this.socketHolder.get() != null) {
            return true;
        }
        return false;
    }

    @Override // org.apache.httpcore.HttpConnection
    public boolean isStale() {
        if (!isOpen()) {
            return true;
        }
        try {
            if (fillInputBuffer(1) < 0) {
                return true;
            }
            return false;
        } catch (SocketTimeoutException unused) {
            return false;
        } catch (IOException unused2) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HttpEntity prepareInput(HttpMessage httpMessage) throws HttpException {
        BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
        long determineLength = this.incomingContentStrategy.determineLength(httpMessage);
        InputStream createInputStream = createInputStream(determineLength, this.inBuffer);
        if (determineLength == -2) {
            basicHttpEntity.setChunked(true);
            basicHttpEntity.setContentLength(-1L);
            basicHttpEntity.setContent(createInputStream);
        } else if (determineLength == -1) {
            basicHttpEntity.setChunked(false);
            basicHttpEntity.setContentLength(-1L);
            basicHttpEntity.setContent(createInputStream);
        } else {
            basicHttpEntity.setChunked(false);
            basicHttpEntity.setContentLength(determineLength);
            basicHttpEntity.setContent(createInputStream);
        }
        Header firstHeader = httpMessage.getFirstHeader("Content-Type");
        if (firstHeader != null) {
            basicHttpEntity.setContentType(firstHeader);
        }
        Header firstHeader2 = httpMessage.getFirstHeader("Content-Encoding");
        if (firstHeader2 != null) {
            basicHttpEntity.setContentEncoding(firstHeader2);
        }
        return basicHttpEntity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public OutputStream prepareOutput(HttpMessage httpMessage) throws HttpException {
        return createOutputStream(this.outgoingContentStrategy.determineLength(httpMessage), this.outbuffer);
    }

    @Override // org.apache.httpcore.HttpConnection
    public void setSocketTimeout(int i3) {
        Socket socket = this.socketHolder.get();
        if (socket != null) {
            try {
                socket.setSoTimeout(i3);
            } catch (SocketException unused) {
            }
        }
    }

    @Override // org.apache.httpcore.HttpConnection
    public void shutdown() throws IOException {
        Socket andSet = this.socketHolder.getAndSet(null);
        if (andSet != null) {
            try {
                andSet.setSoLinger(true, 0);
            } catch (IOException unused) {
            } catch (Throwable th5) {
                andSet.close();
                throw th5;
            }
            andSet.close();
        }
    }

    public String toString() {
        Socket socket = this.socketHolder.get();
        if (socket != null) {
            StringBuilder sb5 = new StringBuilder();
            SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
            SocketAddress localSocketAddress = socket.getLocalSocketAddress();
            if (remoteSocketAddress != null && localSocketAddress != null) {
                NetUtils.formatAddress(sb5, localSocketAddress);
                sb5.append("<->");
                NetUtils.formatAddress(sb5, remoteSocketAddress);
            }
            return sb5.toString();
        }
        return "[Not bound]";
    }
}
