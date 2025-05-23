package org.apache.httpcore.impl;

import java.io.IOException;
import java.net.Socket;
import org.apache.httpcore.HttpConnectionFactory;
import org.apache.httpcore.HttpRequest;
import org.apache.httpcore.HttpResponse;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.config.ConnectionConfig;
import org.apache.httpcore.entity.ContentLengthStrategy;
import org.apache.httpcore.io.HttpMessageParserFactory;
import org.apache.httpcore.io.HttpMessageWriterFactory;

/* compiled from: P */
@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/* loaded from: classes29.dex */
public class DefaultBHttpServerConnectionFactory implements HttpConnectionFactory<DefaultBHttpServerConnection> {
    public static final DefaultBHttpServerConnectionFactory INSTANCE = new DefaultBHttpServerConnectionFactory();
    private final ConnectionConfig cconfig;
    private final ContentLengthStrategy incomingContentStrategy;
    private final ContentLengthStrategy outgoingContentStrategy;
    private final HttpMessageParserFactory<HttpRequest> requestParserFactory;
    private final HttpMessageWriterFactory<HttpResponse> responseWriterFactory;

    public DefaultBHttpServerConnectionFactory(ConnectionConfig connectionConfig, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, HttpMessageParserFactory<HttpRequest> httpMessageParserFactory, HttpMessageWriterFactory<HttpResponse> httpMessageWriterFactory) {
        this.cconfig = connectionConfig == null ? ConnectionConfig.DEFAULT : connectionConfig;
        this.incomingContentStrategy = contentLengthStrategy;
        this.outgoingContentStrategy = contentLengthStrategy2;
        this.requestParserFactory = httpMessageParserFactory;
        this.responseWriterFactory = httpMessageWriterFactory;
    }

    @Override // org.apache.httpcore.HttpConnectionFactory
    public DefaultBHttpServerConnection createConnection(Socket socket) throws IOException {
        DefaultBHttpServerConnection defaultBHttpServerConnection = new DefaultBHttpServerConnection(this.cconfig.getBufferSize(), this.cconfig.getFragmentSizeHint(), ConnSupport.createDecoder(this.cconfig), ConnSupport.createEncoder(this.cconfig), this.cconfig.getMessageConstraints(), this.incomingContentStrategy, this.outgoingContentStrategy, this.requestParserFactory, this.responseWriterFactory);
        defaultBHttpServerConnection.bind(socket);
        return defaultBHttpServerConnection;
    }

    public DefaultBHttpServerConnectionFactory(ConnectionConfig connectionConfig, HttpMessageParserFactory<HttpRequest> httpMessageParserFactory, HttpMessageWriterFactory<HttpResponse> httpMessageWriterFactory) {
        this(connectionConfig, null, null, httpMessageParserFactory, httpMessageWriterFactory);
    }

    public DefaultBHttpServerConnectionFactory(ConnectionConfig connectionConfig) {
        this(connectionConfig, null, null, null, null);
    }

    public DefaultBHttpServerConnectionFactory() {
        this(null, null, null, null, null);
    }
}
