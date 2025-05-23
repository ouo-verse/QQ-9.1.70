package org.apache.httpcore.impl.io;

import java.io.IOException;
import org.apache.httpcore.HeaderIterator;
import org.apache.httpcore.HttpException;
import org.apache.httpcore.HttpMessage;
import org.apache.httpcore.io.HttpMessageWriter;
import org.apache.httpcore.io.SessionOutputBuffer;
import org.apache.httpcore.message.BasicLineFormatter;
import org.apache.httpcore.message.LineFormatter;
import org.apache.httpcore.params.HttpParams;
import org.apache.httpcore.util.Args;
import org.apache.httpcore.util.CharArrayBuffer;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class AbstractMessageWriter<T extends HttpMessage> implements HttpMessageWriter<T> {
    protected final CharArrayBuffer lineBuf;
    protected final LineFormatter lineFormatter;
    protected final SessionOutputBuffer sessionBuffer;

    @Deprecated
    public AbstractMessageWriter(SessionOutputBuffer sessionOutputBuffer, LineFormatter lineFormatter, HttpParams httpParams) {
        Args.notNull(sessionOutputBuffer, "Session input buffer");
        this.sessionBuffer = sessionOutputBuffer;
        this.lineBuf = new CharArrayBuffer(128);
        this.lineFormatter = lineFormatter == null ? BasicLineFormatter.INSTANCE : lineFormatter;
    }

    @Override // org.apache.httpcore.io.HttpMessageWriter
    public void write(T t16) throws IOException, HttpException {
        Args.notNull(t16, "HTTP message");
        writeHeadLine(t16);
        HeaderIterator headerIterator = t16.headerIterator();
        while (headerIterator.hasNext()) {
            this.sessionBuffer.writeLine(this.lineFormatter.formatHeader(this.lineBuf, headerIterator.nextHeader()));
        }
        this.lineBuf.clear();
        this.sessionBuffer.writeLine(this.lineBuf);
    }

    protected abstract void writeHeadLine(T t16) throws IOException;

    public AbstractMessageWriter(SessionOutputBuffer sessionOutputBuffer, LineFormatter lineFormatter) {
        this.sessionBuffer = (SessionOutputBuffer) Args.notNull(sessionOutputBuffer, "Session input buffer");
        this.lineFormatter = lineFormatter == null ? BasicLineFormatter.INSTANCE : lineFormatter;
        this.lineBuf = new CharArrayBuffer(128);
    }
}
