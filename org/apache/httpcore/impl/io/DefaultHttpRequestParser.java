package org.apache.httpcore.impl.io;

import java.io.IOException;
import java.net.Socket;
import org.apache.httpcore.ConnectionClosedException;
import org.apache.httpcore.HttpException;
import org.apache.httpcore.HttpRequest;
import org.apache.httpcore.HttpRequestFactory;
import org.apache.httpcore.ParseException;
import org.apache.httpcore.config.MessageConstraints;
import org.apache.httpcore.impl.DefaultHttpRequestFactory;
import org.apache.httpcore.io.SessionInputBuffer;
import org.apache.httpcore.message.LineParser;
import org.apache.httpcore.message.ParserCursor;
import org.apache.httpcore.params.HttpParams;
import org.apache.httpcore.util.Args;
import org.apache.httpcore.util.CharArrayBuffer;

/* loaded from: classes29.dex */
public class DefaultHttpRequestParser extends AbstractMessageParser<HttpRequest> {
    private final CharArrayBuffer lineBuf;
    private final HttpRequestFactory requestFactory;

    @Deprecated
    public DefaultHttpRequestParser(SessionInputBuffer sessionInputBuffer, LineParser lineParser, HttpRequestFactory httpRequestFactory, HttpParams httpParams) {
        super(sessionInputBuffer, lineParser, httpParams);
        this.requestFactory = (HttpRequestFactory) Args.notNull(httpRequestFactory, "Request factory");
        this.lineBuf = new CharArrayBuffer(128);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.httpcore.impl.io.AbstractMessageParser
    public HttpRequest parseHead(Socket socket, SessionInputBuffer sessionInputBuffer) throws IOException, HttpException, ParseException {
        this.lineBuf.clear();
        if (sessionInputBuffer.readLine(this.lineBuf) != -1) {
            return this.requestFactory.newHttpRequest(socket, this.lineParser.parseRequestLine(this.lineBuf, new ParserCursor(0, this.lineBuf.length())));
        }
        throw new ConnectionClosedException("Client closed connection");
    }

    public DefaultHttpRequestParser(SessionInputBuffer sessionInputBuffer, LineParser lineParser, HttpRequestFactory httpRequestFactory, MessageConstraints messageConstraints) {
        super(sessionInputBuffer, lineParser, messageConstraints);
        this.requestFactory = httpRequestFactory == null ? DefaultHttpRequestFactory.INSTANCE : httpRequestFactory;
        this.lineBuf = new CharArrayBuffer(128);
    }

    public DefaultHttpRequestParser(SessionInputBuffer sessionInputBuffer, MessageConstraints messageConstraints) {
        this(sessionInputBuffer, (LineParser) null, (HttpRequestFactory) null, messageConstraints);
    }

    public DefaultHttpRequestParser(SessionInputBuffer sessionInputBuffer) {
        this(sessionInputBuffer, (LineParser) null, (HttpRequestFactory) null, MessageConstraints.DEFAULT);
    }
}
