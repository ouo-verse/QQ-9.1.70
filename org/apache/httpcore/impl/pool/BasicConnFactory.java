package org.apache.httpcore.impl.pool;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import org.apache.httpcore.HttpClientConnection;
import org.apache.httpcore.HttpConnectionFactory;
import org.apache.httpcore.HttpHost;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.config.ConnectionConfig;
import org.apache.httpcore.config.SocketConfig;
import org.apache.httpcore.impl.DefaultBHttpClientConnection;
import org.apache.httpcore.impl.DefaultBHttpClientConnectionFactory;
import org.apache.httpcore.params.HttpParamConfig;
import org.apache.httpcore.params.HttpParams;
import org.apache.httpcore.pool.ConnFactory;
import org.apache.httpcore.util.Args;
import org.apache.httpcore.util.Asserts;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/* loaded from: classes29.dex */
public class BasicConnFactory implements ConnFactory<HttpHost, HttpClientConnection> {
    private final HttpConnectionFactory<? extends HttpClientConnection> connFactory;
    private final int connectTimeout;
    private final SocketFactory plainfactory;
    private final SocketConfig sconfig;
    private final SSLSocketFactory sslfactory;

    @Deprecated
    public BasicConnFactory(SSLSocketFactory sSLSocketFactory, HttpParams httpParams) {
        Args.notNull(httpParams, "HTTP params");
        this.plainfactory = null;
        this.sslfactory = sSLSocketFactory;
        this.connectTimeout = httpParams.getIntParameter("http.connection.timeout", 0);
        this.sconfig = HttpParamConfig.getSocketConfig(httpParams);
        this.connFactory = new DefaultBHttpClientConnectionFactory(HttpParamConfig.getConnectionConfig(httpParams));
    }

    @Deprecated
    protected HttpClientConnection create(Socket socket, HttpParams httpParams) throws IOException {
        DefaultBHttpClientConnection defaultBHttpClientConnection = new DefaultBHttpClientConnection(httpParams.getIntParameter("http.socket.buffer-size", 8192));
        defaultBHttpClientConnection.bind(socket);
        return defaultBHttpClientConnection;
    }

    @Override // org.apache.httpcore.pool.ConnFactory
    public HttpClientConnection create(HttpHost httpHost) throws IOException {
        final Socket createSocket;
        String schemeName = httpHost.getSchemeName();
        if ("http".equalsIgnoreCase(schemeName)) {
            SocketFactory socketFactory = this.plainfactory;
            createSocket = socketFactory != null ? socketFactory.createSocket() : new Socket();
        } else if ("https".equalsIgnoreCase(schemeName)) {
            SocketFactory socketFactory2 = this.sslfactory;
            if (socketFactory2 == null) {
                socketFactory2 = SSLSocketFactory.getDefault();
            }
            createSocket = socketFactory2.createSocket();
        } else {
            throw new IOException(schemeName + " scheme is not supported");
        }
        String hostName = httpHost.getHostName();
        int port = httpHost.getPort();
        if (port == -1) {
            if (httpHost.getSchemeName().equalsIgnoreCase("http")) {
                port = 80;
            } else if (httpHost.getSchemeName().equalsIgnoreCase("https")) {
                port = WebSocketImpl.DEFAULT_WSS_PORT;
            }
        }
        createSocket.setSoTimeout(this.sconfig.getSoTimeout());
        if (this.sconfig.getSndBufSize() > 0) {
            createSocket.setSendBufferSize(this.sconfig.getSndBufSize());
        }
        if (this.sconfig.getRcvBufSize() > 0) {
            createSocket.setReceiveBufferSize(this.sconfig.getRcvBufSize());
        }
        createSocket.setTcpNoDelay(this.sconfig.isTcpNoDelay());
        int soLinger = this.sconfig.getSoLinger();
        if (soLinger >= 0) {
            createSocket.setSoLinger(true, soLinger);
        }
        createSocket.setKeepAlive(this.sconfig.isSoKeepAlive());
        final InetSocketAddress inetSocketAddress = new InetSocketAddress(hostName, port);
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction<Object>() { // from class: org.apache.httpcore.impl.pool.BasicConnFactory.1
                @Override // java.security.PrivilegedExceptionAction
                public Object run() throws IOException {
                    createSocket.connect(inetSocketAddress, BasicConnFactory.this.connectTimeout);
                    return null;
                }
            });
            return this.connFactory.createConnection(createSocket);
        } catch (PrivilegedActionException e16) {
            Asserts.check(e16.getCause() instanceof IOException, "method contract violation only checked exceptions are wrapped: " + e16.getCause());
            throw ((IOException) e16.getCause());
        }
    }

    @Deprecated
    public BasicConnFactory(HttpParams httpParams) {
        this((SSLSocketFactory) null, httpParams);
    }

    public BasicConnFactory(SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, int i3, SocketConfig socketConfig, ConnectionConfig connectionConfig) {
        this.plainfactory = socketFactory;
        this.sslfactory = sSLSocketFactory;
        this.connectTimeout = i3;
        this.sconfig = socketConfig == null ? SocketConfig.DEFAULT : socketConfig;
        this.connFactory = new DefaultBHttpClientConnectionFactory(connectionConfig == null ? ConnectionConfig.DEFAULT : connectionConfig);
    }

    public BasicConnFactory(int i3, SocketConfig socketConfig, ConnectionConfig connectionConfig) {
        this(null, null, i3, socketConfig, connectionConfig);
    }

    public BasicConnFactory(SocketConfig socketConfig, ConnectionConfig connectionConfig) {
        this(null, null, 0, socketConfig, connectionConfig);
    }

    public BasicConnFactory() {
        this(null, null, 0, SocketConfig.DEFAULT, ConnectionConfig.DEFAULT);
    }
}
