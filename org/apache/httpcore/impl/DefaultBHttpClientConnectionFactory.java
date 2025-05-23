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
public class DefaultBHttpClientConnectionFactory implements HttpConnectionFactory<DefaultBHttpClientConnection> {
    public static final DefaultBHttpClientConnectionFactory INSTANCE = new DefaultBHttpClientConnectionFactory();
    private final ConnectionConfig cconfig;
    private final ContentLengthStrategy incomingContentStrategy;
    private final ContentLengthStrategy outgoingContentStrategy;
    private final HttpMessageWriterFactory<HttpRequest> requestWriterFactory;
    private final HttpMessageParserFactory<HttpResponse> responseParserFactory;

    public DefaultBHttpClientConnectionFactory(ConnectionConfig connectionConfig, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, HttpMessageWriterFactory<HttpRequest> httpMessageWriterFactory, HttpMessageParserFactory<HttpResponse> httpMessageParserFactory) {
        this.cconfig = connectionConfig == null ? ConnectionConfig.DEFAULT : connectionConfig;
        this.incomingContentStrategy = contentLengthStrategy;
        this.outgoingContentStrategy = contentLengthStrategy2;
        this.requestWriterFactory = httpMessageWriterFactory;
        this.responseParserFactory = httpMessageParserFactory;
    }

    @Override // org.apache.httpcore.HttpConnectionFactory
    public DefaultBHttpClientConnection createConnection(Socket socket) throws IOException {
        DefaultBHttpClientConnection defaultBHttpClientConnection = new DefaultBHttpClientConnection(this.cconfig.getBufferSize(), this.cconfig.getFragmentSizeHint(), ConnSupport.createDecoder(this.cconfig), ConnSupport.createEncoder(this.cconfig), this.cconfig.getMessageConstraints(), this.incomingContentStrategy, this.outgoingContentStrategy, this.requestWriterFactory, this.responseParserFactory);
        defaultBHttpClientConnection.bind(socket);
        return defaultBHttpClientConnection;
    }

    public DefaultBHttpClientConnectionFactory(ConnectionConfig connectionConfig, HttpMessageWriterFactory<HttpRequest> httpMessageWriterFactory, HttpMessageParserFactory<HttpResponse> httpMessageParserFactory) {
        this(connectionConfig, null, null, httpMessageWriterFactory, httpMessageParserFactory);
    }

    public DefaultBHttpClientConnectionFactory(ConnectionConfig connectionConfig) {
        this(connectionConfig, null, null, null, null);
    }

    public DefaultBHttpClientConnectionFactory() {
        this(null, null, null, null, null);
    }
}
