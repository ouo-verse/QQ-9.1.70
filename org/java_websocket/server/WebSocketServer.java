package org.java_websocket.server;

import java.io.IOException;
import java.lang.Thread;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.java_websocket.AbstractWebSocket;
import org.java_websocket.SocketChannelIOHelper;
import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketAdapter;
import org.java_websocket.WebSocketFactory;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.WebSocketServerFactory;
import org.java_websocket.WrappedByteChannel;
import org.java_websocket.drafts.Draft;
import org.java_websocket.exceptions.WebsocketNotConnectedException;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.Handshakedata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class WebSocketServer extends AbstractWebSocket implements Runnable {
    private final InetSocketAddress address;
    private BlockingQueue<ByteBuffer> buffers;
    private final Collection<WebSocket> connections;
    protected List<WebSocketWorker> decoders;
    private List<Draft> drafts;
    private List<WebSocketImpl> iqueue;
    private final AtomicBoolean isclosed;
    private int queueinvokes;
    private final AtomicInteger queuesize;
    private Selector selector;
    private Thread selectorthread;
    private ServerSocketChannel server;
    private WebSocketServerFactory wsf;
    private static final Logger log = LoggerFactory.getLogger((Class<?>) WebSocketServer.class);
    private static final int AVAILABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class WebSocketWorker extends Thread {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private BlockingQueue<WebSocketImpl> iqueue = new LinkedBlockingQueue();

        public WebSocketWorker() {
            setName("WebSocketWorker-" + getId());
            setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: org.java_websocket.server.WebSocketServer.WebSocketWorker.1
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread, Throwable th5) {
                    WebSocketServer.log.error("Uncaught exception in thread {}: {}", thread.getName(), th5);
                }
            });
        }

        private void doDecode(WebSocketImpl webSocketImpl, ByteBuffer byteBuffer) throws InterruptedException {
            try {
                try {
                    webSocketImpl.decode(byteBuffer);
                } catch (Exception e16) {
                    WebSocketServer.log.error("Error while reading from remote connection", (Throwable) e16);
                }
            } finally {
                WebSocketServer.this.pushBuffer(byteBuffer);
            }
        }

        public void put(WebSocketImpl webSocketImpl) throws InterruptedException {
            this.iqueue.put(webSocketImpl);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            WebSocketImpl webSocketImpl;
            RuntimeException e16;
            while (true) {
                try {
                    try {
                        webSocketImpl = this.iqueue.take();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                } catch (RuntimeException e17) {
                    webSocketImpl = null;
                    e16 = e17;
                }
                try {
                    doDecode(webSocketImpl, webSocketImpl.inQueue.poll());
                } catch (RuntimeException e18) {
                    e16 = e18;
                    WebSocketServer.this.handleFatal(webSocketImpl, e16);
                    return;
                }
            }
        }
    }

    public WebSocketServer() {
        this(new InetSocketAddress(80), AVAILABLE_PROCESSORS, null);
    }

    private void doAccept(SelectionKey selectionKey, Iterator<SelectionKey> it) throws IOException, InterruptedException {
        if (!onConnect(selectionKey)) {
            selectionKey.cancel();
            return;
        }
        SocketChannel accept = this.server.accept();
        if (accept == null) {
            return;
        }
        accept.configureBlocking(false);
        Socket socket = accept.socket();
        socket.setTcpNoDelay(isTcpNoDelay());
        socket.setKeepAlive(true);
        WebSocketImpl createWebSocket = this.wsf.createWebSocket((WebSocketAdapter) this, this.drafts);
        createWebSocket.setSelectionKey(accept.register(this.selector, 1, createWebSocket));
        try {
            createWebSocket.setChannel(this.wsf.wrapChannel(accept, createWebSocket.getSelectionKey()));
            it.remove();
            allocateBuffers(createWebSocket);
        } catch (IOException e16) {
            if (createWebSocket.getSelectionKey() != null) {
                createWebSocket.getSelectionKey().cancel();
            }
            handleIOException(createWebSocket.getSelectionKey(), null, e16);
        }
    }

    private void doAdditionalRead() throws InterruptedException, IOException {
        while (!this.iqueue.isEmpty()) {
            WebSocketImpl remove = this.iqueue.remove(0);
            WrappedByteChannel wrappedByteChannel = (WrappedByteChannel) remove.getChannel();
            ByteBuffer takeBuffer = takeBuffer();
            try {
                if (SocketChannelIOHelper.readMore(takeBuffer, remove, wrappedByteChannel)) {
                    this.iqueue.add(remove);
                }
                if (takeBuffer.hasRemaining()) {
                    remove.inQueue.put(takeBuffer);
                    queue(remove);
                } else {
                    pushBuffer(takeBuffer);
                }
            } catch (IOException e16) {
                pushBuffer(takeBuffer);
                throw e16;
            }
        }
    }

    private void doBroadcast(Object obj, Collection<WebSocket> collection) {
        String str = obj instanceof String ? (String) obj : null;
        ByteBuffer byteBuffer = obj instanceof ByteBuffer ? (ByteBuffer) obj : null;
        if (str == null && byteBuffer == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (WebSocket webSocket : collection) {
            if (webSocket != null) {
                Draft draft = webSocket.getDraft();
                fillFrames(draft, hashMap, str, byteBuffer);
                try {
                    webSocket.sendFrame(hashMap.get(draft));
                } catch (WebsocketNotConnectedException unused) {
                }
            }
        }
    }

    private boolean doEnsureSingleThread() {
        synchronized (this) {
            if (this.selectorthread == null) {
                this.selectorthread = Thread.currentThread();
                return !this.isclosed.get();
            }
            throw new IllegalStateException(getClass().getName() + " can only be started once.");
        }
    }

    private boolean doRead(SelectionKey selectionKey, Iterator<SelectionKey> it) throws InterruptedException, IOException {
        WebSocketImpl webSocketImpl = (WebSocketImpl) selectionKey.attachment();
        ByteBuffer takeBuffer = takeBuffer();
        if (webSocketImpl.getChannel() == null) {
            selectionKey.cancel();
            handleIOException(selectionKey, webSocketImpl, new IOException());
            return false;
        }
        try {
            if (SocketChannelIOHelper.read(takeBuffer, webSocketImpl, webSocketImpl.getChannel())) {
                if (takeBuffer.hasRemaining()) {
                    webSocketImpl.inQueue.put(takeBuffer);
                    queue(webSocketImpl);
                    it.remove();
                    if (!(webSocketImpl.getChannel() instanceof WrappedByteChannel) || !((WrappedByteChannel) webSocketImpl.getChannel()).isNeedRead()) {
                        return true;
                    }
                    this.iqueue.add(webSocketImpl);
                    return true;
                }
                pushBuffer(takeBuffer);
                return true;
            }
            pushBuffer(takeBuffer);
            return true;
        } catch (IOException e16) {
            pushBuffer(takeBuffer);
            throw e16;
        }
    }

    private void doServerShutdown() {
        stopConnectionLostTimer();
        List<WebSocketWorker> list = this.decoders;
        if (list != null) {
            Iterator<WebSocketWorker> it = list.iterator();
            while (it.hasNext()) {
                it.next().interrupt();
            }
        }
        Selector selector = this.selector;
        if (selector != null) {
            try {
                selector.close();
            } catch (IOException e16) {
                log.error("IOException during selector.close", (Throwable) e16);
                onError(null, e16);
            }
        }
        ServerSocketChannel serverSocketChannel = this.server;
        if (serverSocketChannel != null) {
            try {
                serverSocketChannel.close();
            } catch (IOException e17) {
                log.error("IOException during server.close", (Throwable) e17);
                onError(null, e17);
            }
        }
    }

    private boolean doSetupSelectorAndServerThread() {
        this.selectorthread.setName("WebSocketSelector-" + this.selectorthread.getId());
        try {
            ServerSocketChannel open = ServerSocketChannel.open();
            this.server = open;
            open.configureBlocking(false);
            ServerSocket socket = this.server.socket();
            socket.setReceiveBufferSize(16384);
            socket.setReuseAddress(isReuseAddr());
            socket.bind(this.address);
            Selector open2 = Selector.open();
            this.selector = open2;
            ServerSocketChannel serverSocketChannel = this.server;
            serverSocketChannel.register(open2, serverSocketChannel.validOps());
            startConnectionLostTimer();
            Iterator<WebSocketWorker> it = this.decoders.iterator();
            while (it.hasNext()) {
                it.next().start();
            }
            onStart();
            return true;
        } catch (IOException e16) {
            handleFatal(null, e16);
            return false;
        }
    }

    private void doWrite(SelectionKey selectionKey) throws IOException {
        WebSocketImpl webSocketImpl = (WebSocketImpl) selectionKey.attachment();
        if (SocketChannelIOHelper.batch(webSocketImpl, webSocketImpl.getChannel()) && selectionKey.isValid()) {
            selectionKey.interestOps(1);
        }
    }

    private void fillFrames(Draft draft, Map<Draft, List<Framedata>> map, String str, ByteBuffer byteBuffer) {
        if (map.containsKey(draft)) {
            return;
        }
        List<Framedata> createFrames = str != null ? draft.createFrames(str, false) : null;
        if (byteBuffer != null) {
            createFrames = draft.createFrames(byteBuffer, false);
        }
        if (createFrames != null) {
            map.put(draft, createFrames);
        }
    }

    private Socket getSocket(WebSocket webSocket) {
        return ((SocketChannel) ((WebSocketImpl) webSocket).getSelectionKey().channel()).socket();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFatal(WebSocket webSocket, Exception exc) {
        log.error("Shutdown due to fatal error", (Throwable) exc);
        onError(webSocket, exc);
        List<WebSocketWorker> list = this.decoders;
        if (list != null) {
            Iterator<WebSocketWorker> it = list.iterator();
            while (it.hasNext()) {
                it.next().interrupt();
            }
        }
        Thread thread = this.selectorthread;
        if (thread != null) {
            thread.interrupt();
        }
        try {
            stop();
        } catch (IOException e16) {
            log.error("Error during shutdown", (Throwable) e16);
            onError(null, e16);
        } catch (InterruptedException e17) {
            Thread.currentThread().interrupt();
            log.error("Interrupt during stop", (Throwable) exc);
            onError(null, e17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushBuffer(ByteBuffer byteBuffer) throws InterruptedException {
        if (this.buffers.size() > this.queuesize.intValue()) {
            return;
        }
        this.buffers.put(byteBuffer);
    }

    private ByteBuffer takeBuffer() throws InterruptedException {
        return this.buffers.take();
    }

    protected boolean addConnection(WebSocket webSocket) {
        boolean add;
        if (!this.isclosed.get()) {
            synchronized (this.connections) {
                add = this.connections.add(webSocket);
            }
            return add;
        }
        webSocket.close(1001);
        return true;
    }

    protected void allocateBuffers(WebSocket webSocket) throws InterruptedException {
        if (this.queuesize.get() >= (this.decoders.size() * 2) + 1) {
            return;
        }
        this.queuesize.incrementAndGet();
        this.buffers.put(createBuffer());
    }

    public void broadcast(String str) {
        broadcast(str, this.connections);
    }

    public InetSocketAddress getAddress() {
        return this.address;
    }

    @Override // org.java_websocket.AbstractWebSocket
    public Collection<WebSocket> getConnections() {
        return Collections.unmodifiableCollection(new ArrayList(this.connections));
    }

    public List<Draft> getDraft() {
        return Collections.unmodifiableList(this.drafts);
    }

    @Override // org.java_websocket.WebSocketListener
    public InetSocketAddress getLocalSocketAddress(WebSocket webSocket) {
        return (InetSocketAddress) getSocket(webSocket).getLocalSocketAddress();
    }

    public int getPort() {
        ServerSocketChannel serverSocketChannel;
        int port = getAddress().getPort();
        return (port != 0 || (serverSocketChannel = this.server) == null) ? port : serverSocketChannel.socket().getLocalPort();
    }

    @Override // org.java_websocket.WebSocketListener
    public InetSocketAddress getRemoteSocketAddress(WebSocket webSocket) {
        return (InetSocketAddress) getSocket(webSocket).getRemoteSocketAddress();
    }

    public final WebSocketFactory getWebSocketFactory() {
        return this.wsf;
    }

    public abstract void onClose(WebSocket webSocket, int i3, String str, boolean z16);

    protected boolean onConnect(SelectionKey selectionKey) {
        return true;
    }

    public abstract void onError(WebSocket webSocket, Exception exc);

    public abstract void onMessage(WebSocket webSocket, String str);

    public abstract void onOpen(WebSocket webSocket, ClientHandshake clientHandshake);

    public abstract void onStart();

    @Override // org.java_websocket.WebSocketListener
    public final void onWebsocketClose(WebSocket webSocket, int i3, String str, boolean z16) {
        this.selector.wakeup();
        try {
            if (removeConnection(webSocket)) {
                onClose(webSocket, i3, str, z16);
            }
            try {
                releaseBuffers(webSocket);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } catch (Throwable th5) {
            try {
                releaseBuffers(webSocket);
            } catch (InterruptedException unused2) {
                Thread.currentThread().interrupt();
            }
            throw th5;
        }
    }

    @Override // org.java_websocket.WebSocketListener
    public void onWebsocketCloseInitiated(WebSocket webSocket, int i3, String str) {
        onCloseInitiated(webSocket, i3, str);
    }

    @Override // org.java_websocket.WebSocketListener
    public void onWebsocketClosing(WebSocket webSocket, int i3, String str, boolean z16) {
        onClosing(webSocket, i3, str, z16);
    }

    @Override // org.java_websocket.WebSocketListener
    public final void onWebsocketError(WebSocket webSocket, Exception exc) {
        onError(webSocket, exc);
    }

    @Override // org.java_websocket.WebSocketListener
    public final void onWebsocketMessage(WebSocket webSocket, String str) {
        onMessage(webSocket, str);
    }

    @Override // org.java_websocket.WebSocketListener
    public final void onWebsocketOpen(WebSocket webSocket, Handshakedata handshakedata) {
        if (addConnection(webSocket)) {
            onOpen(webSocket, (ClientHandshake) handshakedata);
        }
    }

    @Override // org.java_websocket.WebSocketListener
    public final void onWriteDemand(WebSocket webSocket) {
        WebSocketImpl webSocketImpl = (WebSocketImpl) webSocket;
        try {
            webSocketImpl.getSelectionKey().interestOps(5);
        } catch (CancelledKeyException unused) {
            webSocketImpl.outQueue.clear();
        }
        this.selector.wakeup();
    }

    protected void queue(WebSocketImpl webSocketImpl) throws InterruptedException {
        if (webSocketImpl.getWorkerThread() == null) {
            List<WebSocketWorker> list = this.decoders;
            webSocketImpl.setWorkerThread(list.get(this.queueinvokes % list.size()));
            this.queueinvokes++;
        }
        webSocketImpl.getWorkerThread().put(webSocketImpl);
    }

    protected boolean removeConnection(WebSocket webSocket) {
        boolean z16;
        synchronized (this.connections) {
            if (this.connections.contains(webSocket)) {
                z16 = this.connections.remove(webSocket);
            } else {
                log.trace("Removing connection which is not in the connections collection! Possible no handshake recieved! {}", webSocket);
                z16 = false;
            }
        }
        if (this.isclosed.get() && this.connections.isEmpty()) {
            this.selectorthread.interrupt();
        }
        return z16;
    }

    @Override // java.lang.Runnable
    public void run() {
        SelectionKey selectionKey;
        SelectionKey next;
        if (doEnsureSingleThread() && doSetupSelectorAndServerThread()) {
            int i3 = 0;
            int i16 = 5;
            while (!this.selectorthread.isInterrupted() && i16 != 0) {
                try {
                    try {
                        try {
                            try {
                                if (this.isclosed.get()) {
                                    i3 = 5;
                                }
                                if (this.selector.select(i3) == 0 && this.isclosed.get()) {
                                    i16--;
                                }
                                Iterator<SelectionKey> it = this.selector.selectedKeys().iterator();
                                selectionKey = null;
                                while (it.hasNext()) {
                                    try {
                                        next = it.next();
                                    } catch (IOException e16) {
                                        e = e16;
                                    }
                                    try {
                                        if (next.isValid()) {
                                            if (next.isAcceptable()) {
                                                doAccept(next, it);
                                            } else if ((!next.isReadable() || doRead(next, it)) && next.isWritable()) {
                                                doWrite(next);
                                            }
                                        }
                                        selectionKey = next;
                                    } catch (IOException e17) {
                                        e = e17;
                                        selectionKey = next;
                                        if (selectionKey != null) {
                                            selectionKey.cancel();
                                        }
                                        handleIOException(selectionKey, null, e);
                                    }
                                }
                                doAdditionalRead();
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                            } catch (CancelledKeyException unused2) {
                            } catch (ClosedByInterruptException unused3) {
                                return;
                            }
                        } catch (IOException e18) {
                            e = e18;
                            selectionKey = null;
                        }
                    } catch (RuntimeException e19) {
                        handleFatal(null, e19);
                    }
                } finally {
                    doServerShutdown();
                }
            }
        }
    }

    public final void setWebSocketFactory(WebSocketServerFactory webSocketServerFactory) {
        WebSocketServerFactory webSocketServerFactory2 = this.wsf;
        if (webSocketServerFactory2 != null) {
            webSocketServerFactory2.close();
        }
        this.wsf = webSocketServerFactory;
    }

    public void start() {
        if (this.selectorthread == null) {
            new Thread(this).start();
            return;
        }
        throw new IllegalStateException(getClass().getName() + " can only be started once.");
    }

    public void stop(int i3) throws InterruptedException {
        ArrayList arrayList;
        Selector selector;
        if (this.isclosed.compareAndSet(false, true)) {
            synchronized (this.connections) {
                arrayList = new ArrayList(this.connections);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((WebSocket) it.next()).close(1001);
            }
            this.wsf.close();
            synchronized (this) {
                if (this.selectorthread != null && (selector = this.selector) != null) {
                    selector.wakeup();
                    this.selectorthread.join(i3);
                }
            }
        }
    }

    public WebSocketServer(InetSocketAddress inetSocketAddress) {
        this(inetSocketAddress, AVAILABLE_PROCESSORS, null);
    }

    public void broadcast(byte[] bArr) {
        broadcast(bArr, this.connections);
    }

    @Override // org.java_websocket.WebSocketListener
    public final void onWebsocketMessage(WebSocket webSocket, ByteBuffer byteBuffer) {
        onMessage(webSocket, byteBuffer);
    }

    public WebSocketServer(InetSocketAddress inetSocketAddress, int i3) {
        this(inetSocketAddress, i3, null);
    }

    public void broadcast(ByteBuffer byteBuffer) {
        broadcast(byteBuffer, this.connections);
    }

    public ByteBuffer createBuffer() {
        return ByteBuffer.allocate(16384);
    }

    public WebSocketServer(InetSocketAddress inetSocketAddress, List<Draft> list) {
        this(inetSocketAddress, AVAILABLE_PROCESSORS, list);
    }

    public void broadcast(byte[] bArr, Collection<WebSocket> collection) {
        if (bArr != null && collection != null) {
            broadcast(ByteBuffer.wrap(bArr), collection);
            return;
        }
        throw new IllegalArgumentException();
    }

    public WebSocketServer(InetSocketAddress inetSocketAddress, int i3, List<Draft> list) {
        this(inetSocketAddress, i3, list, new HashSet());
    }

    private void handleIOException(SelectionKey selectionKey, WebSocket webSocket, IOException iOException) {
        SelectableChannel channel;
        if (webSocket != null) {
            webSocket.closeConnection(1006, iOException.getMessage());
        } else {
            if (selectionKey == null || (channel = selectionKey.channel()) == null || !channel.isOpen()) {
                return;
            }
            try {
                channel.close();
            } catch (IOException unused) {
            }
            log.trace("Connection closed because of exception", (Throwable) iOException);
        }
    }

    public WebSocketServer(InetSocketAddress inetSocketAddress, int i3, List<Draft> list, Collection<WebSocket> collection) {
        this.isclosed = new AtomicBoolean(false);
        this.queueinvokes = 0;
        this.queuesize = new AtomicInteger(0);
        this.wsf = new DefaultWebSocketServerFactory();
        if (inetSocketAddress != null && i3 >= 1 && collection != null) {
            if (list == null) {
                this.drafts = Collections.emptyList();
            } else {
                this.drafts = list;
            }
            this.address = inetSocketAddress;
            this.connections = collection;
            setTcpNoDelay(false);
            setReuseAddr(false);
            this.iqueue = new LinkedList();
            this.decoders = new ArrayList(i3);
            this.buffers = new LinkedBlockingQueue();
            for (int i16 = 0; i16 < i3; i16++) {
                this.decoders.add(new WebSocketWorker());
            }
            return;
        }
        throw new IllegalArgumentException("address and connectionscontainer must not be null and you need at least 1 decoder");
    }

    public void broadcast(ByteBuffer byteBuffer, Collection<WebSocket> collection) {
        if (byteBuffer != null && collection != null) {
            doBroadcast(byteBuffer, collection);
            return;
        }
        throw new IllegalArgumentException();
    }

    public void broadcast(String str, Collection<WebSocket> collection) {
        if (str != null && collection != null) {
            doBroadcast(str, collection);
            return;
        }
        throw new IllegalArgumentException();
    }

    public void stop() throws IOException, InterruptedException {
        stop(0);
    }

    public void onClosing(WebSocket webSocket, int i3, String str, boolean z16) {
    }

    public void onMessage(WebSocket webSocket, ByteBuffer byteBuffer) {
    }

    public void onCloseInitiated(WebSocket webSocket, int i3, String str) {
    }

    protected void releaseBuffers(WebSocket webSocket) throws InterruptedException {
    }
}
