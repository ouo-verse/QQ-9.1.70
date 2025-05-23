package org.apache.httpcore.impl.io;

import java.io.IOException;
import org.apache.httpcore.HttpResponse;
import org.apache.httpcore.io.SessionOutputBuffer;
import org.apache.httpcore.message.LineFormatter;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DefaultHttpResponseWriter extends AbstractMessageWriter<HttpResponse> {
    public DefaultHttpResponseWriter(SessionOutputBuffer sessionOutputBuffer, LineFormatter lineFormatter) {
        super(sessionOutputBuffer, lineFormatter);
    }

    public DefaultHttpResponseWriter(SessionOutputBuffer sessionOutputBuffer) {
        super(sessionOutputBuffer, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.httpcore.impl.io.AbstractMessageWriter
    public void writeHeadLine(HttpResponse httpResponse) throws IOException {
        this.lineFormatter.formatStatusLine(this.lineBuf, httpResponse.getStatusLine());
        this.sessionBuffer.writeLine(this.lineBuf);
    }
}
