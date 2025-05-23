package org.java_websocket.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import org.java_websocket.AbstractWebSocket;
import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.enums.Opcode;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.HandshakeImpl1Client;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class WebSocketClient extends AbstractWebSocket implements Runnable, WebSocket {
    private CountDownLatch closeLatch;
    private CountDownLatch connectLatch;
    private Thread connectReadThread;
    private int connectTimeout;
    private Draft draft;
    private WebSocketImpl engine;
    private Map<String, String> headers;
    private OutputStream ostream;
    private Proxy proxy;
    private Socket socket;
    private SocketFactory socketFactory;
    protected URI uri;
    private Thread writeThread;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    private class WebsocketWriteThread implements Runnable {
        private final WebSocketClient webSocketClient;

        WebsocketWriteThread(WebSocketClient webSocketClient) {
            this.webSocketClient = webSocketClient;
        }

        private void closeSocket() {
            try {
                if (WebSocketClient.this.socket != null) {
                    WebSocketClient.this.socket.close();
                }
            } catch (IOException e16) {
                WebSocketClient.this.onWebsocketError(this.webSocketClient, e16);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("WebSocketWriteThread-" + Thread.currentThread().getId());
            try {
                try {
                    runWriteData();
                } catch (IOException e16) {
                    WebSocketClient.this.handleIOException(e16);
                }
            } finally {
                closeSocket();
                WebSocketClient.this.writeThread = null;
            }
        }

        private void runWriteData() throws IOException {
            while (!Thread.interrupted()) {
                try {
                    ByteBuffer take = WebSocketClient.this.engine.outQueue.take();
                    WebSocketClient.this.ostream.write(take.array(), 0, take.limit());
                    WebSocketClient.this.ostream.flush();
                } catch (InterruptedException unused) {
                    for (ByteBuffer byteBuffer : WebSocketClient.this.engine.outQueue) {
                        WebSocketClient.this.ostream.write(byteBuffer.array(), 0, byteBuffer.limit());
                        WebSocketClient.this.ostream.flush();
                    }
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }

    public WebSocketClient(URI uri) {
        this(uri, new Draft_6455());
    }

    private int getPort() {
        int port = this.uri.getPort();
        if (port != -1) {
            return port;
        }
        String scheme = this.uri.getScheme();
        if ("wss".equals(scheme)) {
            return WebSocketImpl.DEFAULT_WSS_PORT;
        }
        if ("ws".equals(scheme)) {
            return 80;
        }
        throw new IllegalArgumentException("unknown scheme: " + scheme);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleIOException(IOException iOException) {
        if (iOException instanceof SSLException) {
            onError(iOException);
        }
        this.engine.eot();
    }

    private void reset() {
        Thread currentThread = Thread.currentThread();
        if (currentThread != this.writeThread && currentThread != this.connectReadThread) {
            try {
                closeBlocking();
                Thread thread = this.writeThread;
                if (thread != null) {
                    thread.interrupt();
                    this.writeThread = null;
                }
                Thread thread2 = this.connectReadThread;
                if (thread2 != null) {
                    thread2.interrupt();
                    this.connectReadThread = null;
                }
                this.draft.reset();
                Socket socket = this.socket;
                if (socket != null) {
                    socket.close();
                    this.socket = null;
                }
                this.connectLatch = new CountDownLatch(1);
                this.closeLatch = new CountDownLatch(1);
                this.engine = new WebSocketImpl(this, this.draft);
                return;
            } catch (Exception e16) {
                onError(e16);
                this.engine.closeConnection(1006, e16.getMessage());
                return;
            }
        }
        throw new IllegalStateException("You cannot initialize a reconnect out of the websocket thread. Use reconnect in another thread to insure a successful cleanup.");
    }

    private void sendHandshake() throws InvalidHandshakeException {
        String str;
        String rawPath = this.uri.getRawPath();
        String rawQuery = this.uri.getRawQuery();
        if (rawPath == null || rawPath.length() == 0) {
            rawPath = "/";
        }
        if (rawQuery != null) {
            rawPath = rawPath + '?' + rawQuery;
        }
        int port = getPort();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.uri.getHost());
        if (port != 80 && port != 443) {
            str = ":" + port;
        } else {
            str = "";
        }
        sb5.append(str);
        String sb6 = sb5.toString();
        HandshakeImpl1Client handshakeImpl1Client = new HandshakeImpl1Client();
        handshakeImpl1Client.setResourceDescriptor(rawPath);
        handshakeImpl1Client.put("Host", sb6);
        Map<String, String> map = this.headers;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                handshakeImpl1Client.put(entry.getKey(), entry.getValue());
            }
        }
        this.engine.startHandshake(handshakeImpl1Client);
    }

    @Override // org.java_websocket.WebSocket
    public void close() {
        if (this.writeThread != null) {
            this.engine.close(1000);
        }
    }

    public void closeBlocking() throws InterruptedException {
        close();
        this.closeLatch.await();
    }

    @Override // org.java_websocket.WebSocket
    public void closeConnection(int i3, String str) {
        this.engine.closeConnection(i3, str);
    }

    public void connect() {
        if (this.connectReadThread == null) {
            Thread thread = new Thread(this);
            this.connectReadThread = thread;
            thread.setName("WebSocketConnectReadThread-" + this.connectReadThread.getId());
            this.connectReadThread.start();
            return;
        }
        throw new IllegalStateException("WebSocketClient objects are not reuseable");
    }

    public boolean connectBlocking() throws InterruptedException {
        connect();
        this.connectLatch.await();
        return this.engine.isOpen();
    }

    @Override // org.java_websocket.WebSocket
    public <T> T getAttachment() {
        return (T) this.engine.getAttachment();
    }

    public WebSocket getConnection() {
        return this.engine;
    }

    @Override // org.java_websocket.AbstractWebSocket
    protected Collection<WebSocket> getConnections() {
        return Collections.singletonList(this.engine);
    }

    @Override // org.java_websocket.WebSocket
    public Draft getDraft() {
        return this.draft;
    }

    @Override // org.java_websocket.WebSocketListener
    public InetSocketAddress getLocalSocketAddress(WebSocket webSocket) {
        Socket socket = this.socket;
        if (socket != null) {
            return (InetSocketAddress) socket.getLocalSocketAddress();
        }
        return null;
    }

    @Override // org.java_websocket.WebSocket
    public ReadyState getReadyState() {
        return this.engine.getReadyState();
    }

    @Override // org.java_websocket.WebSocketListener
    public InetSocketAddress getRemoteSocketAddress(WebSocket webSocket) {
        Socket socket = this.socket;
        if (socket != null) {
            return (InetSocketAddress) socket.getRemoteSocketAddress();
        }
        return null;
    }

    @Override // org.java_websocket.WebSocket
    public String getResourceDescriptor() {
        return this.uri.getPath();
    }

    public Socket getSocket() {
        return this.socket;
    }

    public URI getURI() {
        return this.uri;
    }

    @Override // org.java_websocket.WebSocket
    public boolean hasBufferedData() {
        return this.engine.hasBufferedData();
    }

    @Override // org.java_websocket.WebSocket
    public boolean isClosed() {
        return this.engine.isClosed();
    }

    @Override // org.java_websocket.WebSocket
    public boolean isClosing() {
        return this.engine.isClosing();
    }

    @Override // org.java_websocket.WebSocket
    public boolean isFlushAndClose() {
        return this.engine.isFlushAndClose();
    }

    @Override // org.java_websocket.WebSocket
    public boolean isOpen() {
        return this.engine.isOpen();
    }

    public abstract void onClose(int i3, String str, boolean z16);

    public abstract void onError(Exception exc);

    public abstract void onMessage(String str);

    public abstract void onOpen(ServerHandshake serverHandshake);

    @Override // org.java_websocket.WebSocketListener
    public final void onWebsocketClose(WebSocket webSocket, int i3, String str, boolean z16) {
        stopConnectionLostTimer();
        Thread thread = this.writeThread;
        if (thread != null) {
            thread.interrupt();
        }
        onClose(i3, str, z16);
        this.connectLatch.countDown();
        this.closeLatch.countDown();
    }

    @Override // org.java_websocket.WebSocketListener
    public void onWebsocketCloseInitiated(WebSocket webSocket, int i3, String str) {
        onCloseInitiated(i3, str);
    }

    @Override // org.java_websocket.WebSocketListener
    public void onWebsocketClosing(WebSocket webSocket, int i3, String str, boolean z16) {
        onClosing(i3, str, z16);
    }

    @Override // org.java_websocket.WebSocketListener
    public final void onWebsocketError(WebSocket webSocket, Exception exc) {
        onError(exc);
    }

    @Override // org.java_websocket.WebSocketListener
    public final void onWebsocketMessage(WebSocket webSocket, String str) {
        onMessage(str);
    }

    @Override // org.java_websocket.WebSocketListener
    public final void onWebsocketOpen(WebSocket webSocket, Handshakedata handshakedata) {
        startConnectionLostTimer();
        onOpen((ServerHandshake) handshakedata);
        this.connectLatch.countDown();
    }

    public void reconnect() {
        reset();
        connect();
    }

    public boolean reconnectBlocking() throws InterruptedException {
        reset();
        return connectBlocking();
    }

    @Override // org.java_websocket.WebSocket
    public void send(String str) {
        this.engine.send(str);
    }

    @Override // org.java_websocket.WebSocket
    public void sendFragmentedFrame(Opcode opcode, ByteBuffer byteBuffer, boolean z16) {
        this.engine.sendFragmentedFrame(opcode, byteBuffer, z16);
    }

    @Override // org.java_websocket.WebSocket
    public void sendFrame(Framedata framedata) {
        this.engine.sendFrame(framedata);
    }

    @Override // org.java_websocket.WebSocket
    public void sendPing() {
        this.engine.sendPing();
    }

    @Override // org.java_websocket.WebSocket
    public <T> void setAttachment(T t16) {
        this.engine.setAttachment(t16);
    }

    @Deprecated
    public void setSocket(Socket socket) {
        if (this.socket == null) {
            this.socket = socket;
            return;
        }
        throw new IllegalStateException("socket has already been set");
    }

    public void setSocketFactory(SocketFactory socketFactory) {
        this.socketFactory = socketFactory;
    }

    public WebSocketClient(URI uri, Draft draft) {
        this(uri, draft, null, 0);
    }

    @Override // org.java_websocket.WebSocketListener
    public final void onWebsocketMessage(WebSocket webSocket, ByteBuffer byteBuffer) {
        onMessage(byteBuffer);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003e A[Catch: Exception -> 0x00e9, TryCatch #0 {Exception -> 0x00e9, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x0024, B:9:0x003e, B:12:0x0057, B:14:0x0066, B:15:0x0086, B:37:0x000e, B:39:0x0012, B:40:0x001d, B:42:0x00e3, B:43:0x00e8), top: B:2:0x0001 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        boolean z16;
        byte[] bArr;
        int read;
        try {
            SocketFactory socketFactory = this.socketFactory;
            if (socketFactory != null) {
                this.socket = socketFactory.createSocket();
            } else {
                Socket socket = this.socket;
                if (socket == null) {
                    this.socket = new Socket(this.proxy);
                    z16 = true;
                    this.socket.setTcpNoDelay(isTcpNoDelay());
                    this.socket.setReuseAddress(isReuseAddr());
                    if (!this.socket.isBound()) {
                        this.socket.connect(new InetSocketAddress(this.uri.getHost(), getPort()), this.connectTimeout);
                    }
                    if (z16 && "wss".equals(this.uri.getScheme())) {
                        SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
                        sSLContext.init(null, null, null);
                        this.socket = sSLContext.getSocketFactory().createSocket(this.socket, this.uri.getHost(), getPort(), true);
                    }
                    InputStream inputStream = this.socket.getInputStream();
                    this.ostream = this.socket.getOutputStream();
                    sendHandshake();
                    Thread thread = new Thread(new WebsocketWriteThread(this));
                    this.writeThread = thread;
                    thread.start();
                    bArr = new byte[16384];
                    while (!isClosing() && !isClosed() && (read = inputStream.read(bArr)) != -1) {
                        try {
                            this.engine.decode(ByteBuffer.wrap(bArr, 0, read));
                        } catch (IOException e16) {
                            handleIOException(e16);
                        } catch (RuntimeException e17) {
                            onError(e17);
                            this.engine.closeConnection(1006, e17.getMessage());
                        }
                    }
                    this.engine.eot();
                    this.connectReadThread = null;
                }
                if (socket.isClosed()) {
                    throw new IOException();
                }
            }
            z16 = false;
            this.socket.setTcpNoDelay(isTcpNoDelay());
            this.socket.setReuseAddress(isReuseAddr());
            if (!this.socket.isBound()) {
            }
            if (z16) {
                SSLContext sSLContext2 = SSLContext.getInstance("TLSv1.2");
                sSLContext2.init(null, null, null);
                this.socket = sSLContext2.getSocketFactory().createSocket(this.socket, this.uri.getHost(), getPort(), true);
            }
            InputStream inputStream2 = this.socket.getInputStream();
            this.ostream = this.socket.getOutputStream();
            sendHandshake();
            Thread thread2 = new Thread(new WebsocketWriteThread(this));
            this.writeThread = thread2;
            thread2.start();
            bArr = new byte[16384];
            while (!isClosing()) {
                this.engine.decode(ByteBuffer.wrap(bArr, 0, read));
            }
            this.engine.eot();
            this.connectReadThread = null;
        } catch (Exception e18) {
            onWebsocketError(this.engine, e18);
            this.engine.closeConnection(-1, e18.getMessage());
        }
    }

    @Override // org.java_websocket.WebSocket
    public void send(byte[] bArr) {
        this.engine.send(bArr);
    }

    @Override // org.java_websocket.WebSocket
    public void sendFrame(Collection<Framedata> collection) {
        this.engine.sendFrame(collection);
    }

    public WebSocketClient(URI uri, Map<String, String> map) {
        this(uri, new Draft_6455(), map);
    }

    @Override // org.java_websocket.WebSocket
    public void close(int i3) {
        this.engine.close(i3);
    }

    @Override // org.java_websocket.WebSocket
    public InetSocketAddress getLocalSocketAddress() {
        return this.engine.getLocalSocketAddress();
    }

    @Override // org.java_websocket.WebSocket
    public InetSocketAddress getRemoteSocketAddress() {
        return this.engine.getRemoteSocketAddress();
    }

    @Override // org.java_websocket.WebSocket
    public void send(ByteBuffer byteBuffer) {
        this.engine.send(byteBuffer);
    }

    public void setProxy(Proxy proxy) {
        if (proxy != null) {
            this.proxy = proxy;
            return;
        }
        throw new IllegalArgumentException();
    }

    public WebSocketClient(URI uri, Draft draft, Map<String, String> map) {
        this(uri, draft, map, 0);
    }

    @Override // org.java_websocket.WebSocket
    public void close(int i3, String str) {
        this.engine.close(i3, str);
    }

    public boolean connectBlocking(long j3, TimeUnit timeUnit) throws InterruptedException {
        connect();
        return this.connectLatch.await(j3, timeUnit) && this.engine.isOpen();
    }

    public WebSocketClient(URI uri, Draft draft, Map<String, String> map, int i3) {
        this.uri = null;
        this.engine = null;
        this.socket = null;
        this.socketFactory = null;
        this.proxy = Proxy.NO_PROXY;
        this.connectLatch = new CountDownLatch(1);
        this.closeLatch = new CountDownLatch(1);
        this.connectTimeout = 0;
        if (uri == null) {
            throw new IllegalArgumentException();
        }
        if (draft != null) {
            this.uri = uri;
            this.draft = draft;
            this.headers = map;
            this.connectTimeout = i3;
            setTcpNoDelay(false);
            setReuseAddr(false);
            this.engine = new WebSocketImpl(this, draft);
            return;
        }
        throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    }

    public void onCloseInitiated(int i3, String str) {
    }

    public void onClosing(int i3, String str, boolean z16) {
    }

    public void onMessage(ByteBuffer byteBuffer) {
    }

    @Override // org.java_websocket.WebSocketListener
    public final void onWriteDemand(WebSocket webSocket) {
    }
}
