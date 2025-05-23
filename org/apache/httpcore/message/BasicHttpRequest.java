package org.apache.httpcore.message;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import org.apache.httpcore.HttpRequest;
import org.apache.httpcore.HttpVersion;
import org.apache.httpcore.ProtocolVersion;
import org.apache.httpcore.RequestLine;
import org.apache.httpcore.util.Args;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BasicHttpRequest extends AbstractHttpMessage implements HttpRequest {
    private String localAddr;
    private String localName;
    private int localPort;
    private final String method;
    private String remoteAddr;
    private String remoteHost;
    private int remotePort;
    private RequestLine requestline;
    private final Socket socket;
    private final String uri;

    public BasicHttpRequest(Socket socket, String str, String str2) {
        this.localPort = -1;
        this.remotePort = -1;
        this.socket = socket;
        this.method = (String) Args.notNull(str, "Method name");
        this.uri = (String) Args.notNull(str2, "Request URI");
        this.requestline = null;
    }

    @Override // org.apache.httpcore.HttpRequest
    public String getLocalAddr() {
        String str = this.localAddr;
        if (str != null) {
            return str;
        }
        SocketAddress localSocketAddress = this.socket.getLocalSocketAddress();
        if (localSocketAddress instanceof InetSocketAddress) {
            this.localAddr = ((InetSocketAddress) localSocketAddress).getAddress().getHostAddress();
        }
        return this.localAddr;
    }

    @Override // org.apache.httpcore.HttpRequest
    public String getLocalName() {
        String str = this.localName;
        if (str != null) {
            return str;
        }
        SocketAddress localSocketAddress = this.socket.getLocalSocketAddress();
        if (localSocketAddress instanceof InetSocketAddress) {
            this.localName = ((InetSocketAddress) localSocketAddress).getHostName();
        }
        return this.localName;
    }

    @Override // org.apache.httpcore.HttpRequest
    public int getLocalPort() {
        int i3 = this.localPort;
        if (i3 != -1) {
            return i3;
        }
        SocketAddress localSocketAddress = this.socket.getLocalSocketAddress();
        if (localSocketAddress instanceof InetSocketAddress) {
            this.localPort = ((InetSocketAddress) localSocketAddress).getPort();
        }
        return this.localPort;
    }

    @Override // org.apache.httpcore.HttpMessage
    public ProtocolVersion getProtocolVersion() {
        return getRequestLine().getProtocolVersion();
    }

    @Override // org.apache.httpcore.HttpRequest
    public String getRemoteAddr() {
        String str = this.remoteAddr;
        if (str != null) {
            return str;
        }
        SocketAddress remoteSocketAddress = this.socket.getRemoteSocketAddress();
        if (remoteSocketAddress instanceof InetSocketAddress) {
            this.remoteAddr = ((InetSocketAddress) remoteSocketAddress).getAddress().getHostAddress();
        }
        return this.remoteAddr;
    }

    @Override // org.apache.httpcore.HttpRequest
    public String getRemoteHost() {
        String str = this.remoteHost;
        if (str != null) {
            return str;
        }
        SocketAddress remoteSocketAddress = this.socket.getRemoteSocketAddress();
        if (remoteSocketAddress instanceof InetSocketAddress) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) remoteSocketAddress;
            this.remoteHost = inetSocketAddress.getAddress().getHostName();
            if (this.remoteAddr == null) {
                this.remoteAddr = inetSocketAddress.getAddress().getHostAddress();
            }
        }
        return this.remoteHost;
    }

    @Override // org.apache.httpcore.HttpRequest
    public int getRemotePort() {
        int i3 = this.remotePort;
        if (i3 != -1) {
            return i3;
        }
        SocketAddress remoteSocketAddress = this.socket.getRemoteSocketAddress();
        if (remoteSocketAddress instanceof InetSocketAddress) {
            this.remotePort = ((InetSocketAddress) remoteSocketAddress).getPort();
        }
        return this.remotePort;
    }

    @Override // org.apache.httpcore.HttpRequest
    public RequestLine getRequestLine() {
        if (this.requestline == null) {
            this.requestline = new BasicRequestLine(this.method, this.uri, HttpVersion.HTTP_1_1);
        }
        return this.requestline;
    }

    public String toString() {
        return this.method + TokenParser.SP + this.uri + TokenParser.SP + this.headergroup;
    }

    public BasicHttpRequest(Socket socket, String str, String str2, ProtocolVersion protocolVersion) {
        this(socket, new BasicRequestLine(str, str2, protocolVersion));
    }

    public BasicHttpRequest(Socket socket, RequestLine requestLine) {
        this.localPort = -1;
        this.remotePort = -1;
        this.socket = socket;
        this.requestline = (RequestLine) Args.notNull(requestLine, "Request line");
        this.method = requestLine.getMethod();
        this.uri = requestLine.getUri();
    }
}
