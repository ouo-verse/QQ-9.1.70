package org.apache.httpcore.impl.io;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import org.apache.httpcore.Header;
import org.apache.httpcore.HttpException;
import org.apache.httpcore.HttpMessage;
import org.apache.httpcore.MessageConstraintException;
import org.apache.httpcore.ParseException;
import org.apache.httpcore.ProtocolException;
import org.apache.httpcore.config.MessageConstraints;
import org.apache.httpcore.io.HttpMessageParser;
import org.apache.httpcore.io.SessionInputBuffer;
import org.apache.httpcore.message.BasicLineParser;
import org.apache.httpcore.message.LineParser;
import org.apache.httpcore.message.TokenParser;
import org.apache.httpcore.params.HttpParamConfig;
import org.apache.httpcore.params.HttpParams;
import org.apache.httpcore.util.Args;
import org.apache.httpcore.util.CharArrayBuffer;

/* loaded from: classes29.dex */
public abstract class AbstractMessageParser<T extends HttpMessage> implements HttpMessageParser<T> {
    private static final int HEADERS = 1;
    private static final int HEAD_LINE = 0;
    private final List<CharArrayBuffer> headerLines;
    protected final LineParser lineParser;
    private T message;
    private final MessageConstraints messageConstraints;
    private final SessionInputBuffer sessionBuffer;
    private int state;

    @Deprecated
    public AbstractMessageParser(SessionInputBuffer sessionInputBuffer, LineParser lineParser, HttpParams httpParams) {
        Args.notNull(sessionInputBuffer, "Session input buffer");
        Args.notNull(httpParams, "HTTP parameters");
        this.sessionBuffer = sessionInputBuffer;
        this.messageConstraints = HttpParamConfig.getMessageConstraints(httpParams);
        this.lineParser = lineParser == null ? BasicLineParser.INSTANCE : lineParser;
        this.headerLines = new ArrayList();
        this.state = 0;
    }

    public static Header[] parseHeaders(SessionInputBuffer sessionInputBuffer, int i3, int i16, LineParser lineParser) throws HttpException, IOException {
        ArrayList arrayList = new ArrayList();
        if (lineParser == null) {
            lineParser = BasicLineParser.INSTANCE;
        }
        return parseHeaders(sessionInputBuffer, i3, i16, lineParser, arrayList);
    }

    @Override // org.apache.httpcore.io.HttpMessageParser
    public T parse(Socket socket) throws IOException, HttpException {
        int i3 = this.state;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("Inconsistent parser state");
            }
        } else {
            try {
                this.message = parseHead(socket, this.sessionBuffer);
                this.state = 1;
            } catch (ParseException e16) {
                throw new ProtocolException(e16.getMessage(), e16);
            }
        }
        this.message.setHeaders(parseHeaders(this.sessionBuffer, this.messageConstraints.getMaxHeaderCount(), this.messageConstraints.getMaxLineLength(), this.lineParser, this.headerLines));
        T t16 = this.message;
        this.message = null;
        this.headerLines.clear();
        this.state = 0;
        return t16;
    }

    protected abstract T parseHead(Socket socket, SessionInputBuffer sessionInputBuffer) throws IOException, HttpException, ParseException;

    public static Header[] parseHeaders(SessionInputBuffer sessionInputBuffer, int i3, int i16, LineParser lineParser, List<CharArrayBuffer> list) throws HttpException, IOException {
        int i17;
        char charAt;
        Args.notNull(sessionInputBuffer, "Session input buffer");
        Args.notNull(lineParser, "Line parser");
        Args.notNull(list, "Header line list");
        CharArrayBuffer charArrayBuffer = null;
        CharArrayBuffer charArrayBuffer2 = null;
        while (true) {
            if (charArrayBuffer == null) {
                charArrayBuffer = new CharArrayBuffer(64);
            } else {
                charArrayBuffer.clear();
            }
            i17 = 0;
            if (sessionInputBuffer.readLine(charArrayBuffer) == -1 || charArrayBuffer.length() < 1) {
                break;
            }
            if ((charArrayBuffer.charAt(0) == ' ' || charArrayBuffer.charAt(0) == '\t') && charArrayBuffer2 != null) {
                while (i17 < charArrayBuffer.length() && ((charAt = charArrayBuffer.charAt(i17)) == ' ' || charAt == '\t')) {
                    i17++;
                }
                if (i16 > 0 && ((charArrayBuffer2.length() + 1) + charArrayBuffer.length()) - i17 > i16) {
                    throw new MessageConstraintException("Maximum line length limit exceeded");
                }
                charArrayBuffer2.append(TokenParser.SP);
                charArrayBuffer2.append(charArrayBuffer, i17, charArrayBuffer.length() - i17);
            } else {
                list.add(charArrayBuffer);
                charArrayBuffer2 = charArrayBuffer;
                charArrayBuffer = null;
            }
            if (i3 > 0 && list.size() >= i3) {
                throw new MessageConstraintException("Maximum header count exceeded");
            }
        }
        Header[] headerArr = new Header[list.size()];
        while (i17 < list.size()) {
            try {
                headerArr[i17] = lineParser.parseHeader(list.get(i17));
                i17++;
            } catch (ParseException e16) {
                throw new ProtocolException(e16.getMessage());
            }
        }
        return headerArr;
    }

    public AbstractMessageParser(SessionInputBuffer sessionInputBuffer, LineParser lineParser, MessageConstraints messageConstraints) {
        this.sessionBuffer = (SessionInputBuffer) Args.notNull(sessionInputBuffer, "Session input buffer");
        this.lineParser = lineParser == null ? BasicLineParser.INSTANCE : lineParser;
        this.messageConstraints = messageConstraints == null ? MessageConstraints.DEFAULT : messageConstraints;
        this.headerLines = new ArrayList();
        this.state = 0;
    }
}
