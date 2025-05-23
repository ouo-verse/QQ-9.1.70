package org.apache.httpcore.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import org.apache.httpcore.HttpClientConnection;
import org.apache.httpcore.HttpEntity;
import org.apache.httpcore.HttpEntityEnclosingRequest;
import org.apache.httpcore.HttpException;
import org.apache.httpcore.HttpRequest;
import org.apache.httpcore.HttpResponse;
import org.apache.httpcore.config.MessageConstraints;
import org.apache.httpcore.entity.ContentLengthStrategy;
import org.apache.httpcore.impl.io.DefaultHttpRequestWriterFactory;
import org.apache.httpcore.impl.io.DefaultHttpResponseParserFactory;
import org.apache.httpcore.io.HttpMessageParser;
import org.apache.httpcore.io.HttpMessageParserFactory;
import org.apache.httpcore.io.HttpMessageWriter;
import org.apache.httpcore.io.HttpMessageWriterFactory;
import org.apache.httpcore.util.Args;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DefaultBHttpClientConnection extends BHttpConnectionBase implements HttpClientConnection {
    private final HttpMessageWriter<HttpRequest> requestWriter;
    private final HttpMessageParser<HttpResponse> responseParser;

    public DefaultBHttpClientConnection(int i3, int i16, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, HttpMessageWriterFactory<HttpRequest> httpMessageWriterFactory, HttpMessageParserFactory<HttpResponse> httpMessageParserFactory) {
        super(i3, i16, charsetDecoder, charsetEncoder, messageConstraints, contentLengthStrategy, contentLengthStrategy2);
        this.requestWriter = (httpMessageWriterFactory == null ? DefaultHttpRequestWriterFactory.INSTANCE : httpMessageWriterFactory).create(getSessionOutputBuffer());
        this.responseParser = (httpMessageParserFactory == null ? DefaultHttpResponseParserFactory.INSTANCE : httpMessageParserFactory).create(getSessionInputBuffer(), messageConstraints);
    }

    @Override // org.apache.httpcore.impl.BHttpConnectionBase
    public void bind(Socket socket) throws IOException {
        super.bind(socket);
    }

    @Override // org.apache.httpcore.HttpClientConnection
    public void flush() throws IOException {
        ensureOpen();
        doFlush();
    }

    @Override // org.apache.httpcore.HttpClientConnection
    public boolean isResponseAvailable(int i3) throws IOException {
        ensureOpen();
        try {
            return awaitInput(i3);
        } catch (SocketTimeoutException unused) {
            return false;
        }
    }

    @Override // org.apache.httpcore.HttpClientConnection
    public void receiveResponseEntity(HttpResponse httpResponse) throws HttpException, IOException {
        Args.notNull(httpResponse, "HTTP response");
        ensureOpen();
        httpResponse.setEntity(prepareInput(httpResponse));
    }

    @Override // org.apache.httpcore.HttpClientConnection
    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        ensureOpen();
        HttpResponse parse = this.responseParser.parse(getSocket());
        onResponseReceived(parse);
        if (parse.getStatusLine().getStatusCode() >= 200) {
            incrementResponseCount();
        }
        return parse;
    }

    @Override // org.apache.httpcore.HttpClientConnection
    public void sendRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest) throws HttpException, IOException {
        Args.notNull(httpEntityEnclosingRequest, "HTTP request");
        ensureOpen();
        HttpEntity entity = httpEntityEnclosingRequest.getEntity();
        if (entity == null) {
            return;
        }
        OutputStream prepareOutput = prepareOutput(httpEntityEnclosingRequest);
        entity.writeTo(prepareOutput);
        prepareOutput.close();
    }

    @Override // org.apache.httpcore.HttpClientConnection
    public void sendRequestHeader(HttpRequest httpRequest) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        ensureOpen();
        this.requestWriter.write(httpRequest);
        onRequestSubmitted(httpRequest);
        incrementRequestCount();
    }

    public DefaultBHttpClientConnection(int i3, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints) {
        this(i3, i3, charsetDecoder, charsetEncoder, messageConstraints, null, null, null, null);
    }

    public DefaultBHttpClientConnection(int i3) {
        this(i3, i3, null, null, null, null, null, null, null);
    }

    protected void onRequestSubmitted(HttpRequest httpRequest) {
    }

    protected void onResponseReceived(HttpResponse httpResponse) {
    }
}
