package org.apache.httpcore.impl.io;

import org.apache.httpcore.HttpResponse;
import org.apache.httpcore.HttpResponseFactory;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.config.MessageConstraints;
import org.apache.httpcore.impl.DefaultHttpResponseFactory;
import org.apache.httpcore.io.HttpMessageParser;
import org.apache.httpcore.io.HttpMessageParserFactory;
import org.apache.httpcore.io.SessionInputBuffer;
import org.apache.httpcore.message.BasicLineParser;
import org.apache.httpcore.message.LineParser;

@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/* loaded from: classes29.dex */
public class DefaultHttpResponseParserFactory implements HttpMessageParserFactory<HttpResponse> {
    public static final DefaultHttpResponseParserFactory INSTANCE = new DefaultHttpResponseParserFactory();
    private final LineParser lineParser;
    private final HttpResponseFactory responseFactory;

    public DefaultHttpResponseParserFactory(LineParser lineParser, HttpResponseFactory httpResponseFactory) {
        this.lineParser = lineParser == null ? BasicLineParser.INSTANCE : lineParser;
        this.responseFactory = httpResponseFactory == null ? DefaultHttpResponseFactory.INSTANCE : httpResponseFactory;
    }

    @Override // org.apache.httpcore.io.HttpMessageParserFactory
    public HttpMessageParser<HttpResponse> create(SessionInputBuffer sessionInputBuffer, MessageConstraints messageConstraints) {
        return new DefaultHttpResponseParser(sessionInputBuffer, this.lineParser, this.responseFactory, messageConstraints);
    }

    public DefaultHttpResponseParserFactory() {
        this(null, null);
    }
}
