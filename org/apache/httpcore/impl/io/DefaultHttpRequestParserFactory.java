package org.apache.httpcore.impl.io;

import org.apache.httpcore.HttpRequest;
import org.apache.httpcore.HttpRequestFactory;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.config.MessageConstraints;
import org.apache.httpcore.impl.DefaultHttpRequestFactory;
import org.apache.httpcore.io.HttpMessageParser;
import org.apache.httpcore.io.HttpMessageParserFactory;
import org.apache.httpcore.io.SessionInputBuffer;
import org.apache.httpcore.message.BasicLineParser;
import org.apache.httpcore.message.LineParser;

@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/* loaded from: classes29.dex */
public class DefaultHttpRequestParserFactory implements HttpMessageParserFactory<HttpRequest> {
    public static final DefaultHttpRequestParserFactory INSTANCE = new DefaultHttpRequestParserFactory();
    private final LineParser lineParser;
    private final HttpRequestFactory requestFactory;

    public DefaultHttpRequestParserFactory(LineParser lineParser, HttpRequestFactory httpRequestFactory) {
        this.lineParser = lineParser == null ? BasicLineParser.INSTANCE : lineParser;
        this.requestFactory = httpRequestFactory == null ? DefaultHttpRequestFactory.INSTANCE : httpRequestFactory;
    }

    @Override // org.apache.httpcore.io.HttpMessageParserFactory
    public HttpMessageParser<HttpRequest> create(SessionInputBuffer sessionInputBuffer, MessageConstraints messageConstraints) {
        return new DefaultHttpRequestParser(sessionInputBuffer, this.lineParser, this.requestFactory, messageConstraints);
    }

    public DefaultHttpRequestParserFactory() {
        this(null, null);
    }
}
