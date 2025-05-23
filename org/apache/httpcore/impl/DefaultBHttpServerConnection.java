package org.apache.httpcore.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import org.apache.httpcore.HttpEntity;
import org.apache.httpcore.HttpEntityEnclosingRequest;
import org.apache.httpcore.HttpException;
import org.apache.httpcore.HttpRequest;
import org.apache.httpcore.HttpResponse;
import org.apache.httpcore.HttpServerConnection;
import org.apache.httpcore.config.MessageConstraints;
import org.apache.httpcore.entity.ContentLengthStrategy;
import org.apache.httpcore.impl.entity.DisallowIdentityContentLengthStrategy;
import org.apache.httpcore.impl.io.DefaultHttpRequestParserFactory;
import org.apache.httpcore.impl.io.DefaultHttpResponseWriterFactory;
import org.apache.httpcore.io.HttpMessageParser;
import org.apache.httpcore.io.HttpMessageParserFactory;
import org.apache.httpcore.io.HttpMessageWriter;
import org.apache.httpcore.io.HttpMessageWriterFactory;
import org.apache.httpcore.util.Args;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DefaultBHttpServerConnection extends BHttpConnectionBase implements HttpServerConnection {
    private final HttpMessageParser<HttpRequest> requestParser;
    private final HttpMessageWriter<HttpResponse> responseWriter;

    public DefaultBHttpServerConnection(int i3, int i16, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, HttpMessageParserFactory<HttpRequest> httpMessageParserFactory, HttpMessageWriterFactory<HttpResponse> httpMessageWriterFactory) {
        super(i3, i16, charsetDecoder, charsetEncoder, messageConstraints, contentLengthStrategy != null ? contentLengthStrategy : DisallowIdentityContentLengthStrategy.INSTANCE, contentLengthStrategy2);
        this.requestParser = (httpMessageParserFactory != null ? httpMessageParserFactory : DefaultHttpRequestParserFactory.INSTANCE).create(getSessionInputBuffer(), messageConstraints);
        this.responseWriter = (httpMessageWriterFactory != null ? httpMessageWriterFactory : DefaultHttpResponseWriterFactory.INSTANCE).create(getSessionOutputBuffer());
    }

    @Override // org.apache.httpcore.impl.BHttpConnectionBase
    public void bind(Socket socket) throws IOException {
        super.bind(socket);
    }

    @Override // org.apache.httpcore.HttpServerConnection
    public void flush() throws IOException {
        ensureOpen();
        doFlush();
    }

    @Override // org.apache.httpcore.HttpServerConnection
    public void receiveRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest) throws HttpException, IOException {
        Args.notNull(httpEntityEnclosingRequest, "HTTP request");
        ensureOpen();
        httpEntityEnclosingRequest.setEntity(prepareInput(httpEntityEnclosingRequest));
    }

    @Override // org.apache.httpcore.HttpServerConnection
    public HttpRequest receiveRequestHeader() throws HttpException, IOException {
        ensureOpen();
        HttpRequest parse = this.requestParser.parse(getSocket());
        onRequestReceived(parse);
        incrementRequestCount();
        return parse;
    }

    @Override // org.apache.httpcore.HttpServerConnection
    public void sendResponseEntity(HttpResponse httpResponse) throws HttpException, IOException {
        Args.notNull(httpResponse, "HTTP response");
        ensureOpen();
        HttpEntity entity = httpResponse.getEntity();
        if (entity == null) {
            return;
        }
        OutputStream prepareOutput = prepareOutput(httpResponse);
        entity.writeTo(prepareOutput);
        prepareOutput.close();
    }

    @Override // org.apache.httpcore.HttpServerConnection
    public void sendResponseHeader(HttpResponse httpResponse) throws HttpException, IOException {
        Args.notNull(httpResponse, "HTTP response");
        ensureOpen();
        this.responseWriter.write(httpResponse);
        onResponseSubmitted(httpResponse);
        if (httpResponse.getStatusLine().getStatusCode() >= 200) {
            incrementResponseCount();
        }
    }

    public DefaultBHttpServerConnection(int i3, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints) {
        this(i3, i3, charsetDecoder, charsetEncoder, messageConstraints, null, null, null, null);
    }

    public DefaultBHttpServerConnection(int i3) {
        this(i3, i3, null, null, null, null, null, null, null);
    }

    protected void onRequestReceived(HttpRequest httpRequest) {
    }

    protected void onResponseSubmitted(HttpResponse httpResponse) {
    }
}
