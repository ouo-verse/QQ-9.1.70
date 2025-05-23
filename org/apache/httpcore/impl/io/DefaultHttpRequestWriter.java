package org.apache.httpcore.impl.io;

import java.io.IOException;
import org.apache.httpcore.HttpRequest;
import org.apache.httpcore.io.SessionOutputBuffer;
import org.apache.httpcore.message.LineFormatter;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DefaultHttpRequestWriter extends AbstractMessageWriter<HttpRequest> {
    public DefaultHttpRequestWriter(SessionOutputBuffer sessionOutputBuffer, LineFormatter lineFormatter) {
        super(sessionOutputBuffer, lineFormatter);
    }

    public DefaultHttpRequestWriter(SessionOutputBuffer sessionOutputBuffer) {
        this(sessionOutputBuffer, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.httpcore.impl.io.AbstractMessageWriter
    public void writeHeadLine(HttpRequest httpRequest) throws IOException {
        this.lineFormatter.formatRequestLine(this.lineBuf, httpRequest.getRequestLine());
        this.sessionBuffer.writeLine(this.lineBuf);
    }
}
