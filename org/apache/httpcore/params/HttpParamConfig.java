package org.apache.httpcore.params;

import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import org.apache.httpcore.config.ConnectionConfig;
import org.apache.httpcore.config.MessageConstraints;
import org.apache.httpcore.config.SocketConfig;

@Deprecated
/* loaded from: classes29.dex */
public final class HttpParamConfig {
    HttpParamConfig() {
    }

    public static ConnectionConfig getConnectionConfig(HttpParams httpParams) {
        Charset charset;
        MessageConstraints messageConstraints = getMessageConstraints(httpParams);
        String str = (String) httpParams.getParameter("http.protocol.element-charset");
        ConnectionConfig.Builder custom = ConnectionConfig.custom();
        if (str != null) {
            charset = Charset.forName(str);
        } else {
            charset = null;
        }
        return custom.setCharset(charset).setMalformedInputAction((CodingErrorAction) httpParams.getParameter(CoreProtocolPNames.HTTP_MALFORMED_INPUT_ACTION)).setMalformedInputAction((CodingErrorAction) httpParams.getParameter(CoreProtocolPNames.HTTP_UNMAPPABLE_INPUT_ACTION)).setMessageConstraints(messageConstraints).build();
    }

    public static MessageConstraints getMessageConstraints(HttpParams httpParams) {
        return MessageConstraints.custom().setMaxHeaderCount(httpParams.getIntParameter("http.connection.max-header-count", -1)).setMaxLineLength(httpParams.getIntParameter("http.connection.max-line-length", -1)).build();
    }

    public static SocketConfig getSocketConfig(HttpParams httpParams) {
        return SocketConfig.custom().setSoTimeout(httpParams.getIntParameter("http.socket.timeout", 0)).setSoReuseAddress(httpParams.getBooleanParameter(CoreConnectionPNames.SO_REUSEADDR, false)).setSoKeepAlive(httpParams.getBooleanParameter(CoreConnectionPNames.SO_KEEPALIVE, false)).setSoLinger(httpParams.getIntParameter("http.socket.linger", -1)).setTcpNoDelay(httpParams.getBooleanParameter("http.tcp.nodelay", true)).build();
    }
}
