package org.apache.httpcore.protocol;

import java.io.IOException;
import java.net.InetAddress;
import org.apache.httpcore.HttpConnection;
import org.apache.httpcore.HttpException;
import org.apache.httpcore.HttpHost;
import org.apache.httpcore.HttpInetConnection;
import org.apache.httpcore.HttpRequest;
import org.apache.httpcore.HttpRequestInterceptor;
import org.apache.httpcore.HttpVersion;
import org.apache.httpcore.ProtocolException;
import org.apache.httpcore.ProtocolVersion;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.util.Args;

/* compiled from: P */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes29.dex */
public class RequestTargetHost implements HttpRequestInterceptor {
    @Override // org.apache.httpcore.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        HttpCoreContext adapt = HttpCoreContext.adapt(httpContext);
        ProtocolVersion protocolVersion = httpRequest.getRequestLine().getProtocolVersion();
        if ((!httpRequest.getRequestLine().getMethod().equalsIgnoreCase("CONNECT") || !protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) && !httpRequest.containsHeader("Host")) {
            HttpHost targetHost = adapt.getTargetHost();
            if (targetHost == null) {
                HttpConnection connection = adapt.getConnection();
                if (connection instanceof HttpInetConnection) {
                    HttpInetConnection httpInetConnection = (HttpInetConnection) connection;
                    InetAddress remoteAddress = httpInetConnection.getRemoteAddress();
                    int remotePort = httpInetConnection.getRemotePort();
                    if (remoteAddress != null) {
                        targetHost = new HttpHost(remoteAddress.getHostName(), remotePort);
                    }
                }
                if (targetHost == null) {
                    if (protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) {
                        return;
                    } else {
                        throw new ProtocolException("Target host missing");
                    }
                }
            }
            httpRequest.addHeader("Host", targetHost.toHostString());
        }
    }
}
