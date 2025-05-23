package org.apache.httpcore.impl.io;

import org.apache.httpcore.HttpResponse;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.io.HttpMessageWriter;
import org.apache.httpcore.io.HttpMessageWriterFactory;
import org.apache.httpcore.io.SessionOutputBuffer;
import org.apache.httpcore.message.BasicLineFormatter;
import org.apache.httpcore.message.LineFormatter;

/* compiled from: P */
@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/* loaded from: classes29.dex */
public class DefaultHttpResponseWriterFactory implements HttpMessageWriterFactory<HttpResponse> {
    public static final DefaultHttpResponseWriterFactory INSTANCE = new DefaultHttpResponseWriterFactory();
    private final LineFormatter lineFormatter;

    public DefaultHttpResponseWriterFactory(LineFormatter lineFormatter) {
        this.lineFormatter = lineFormatter == null ? BasicLineFormatter.INSTANCE : lineFormatter;
    }

    @Override // org.apache.httpcore.io.HttpMessageWriterFactory
    public HttpMessageWriter<HttpResponse> create(SessionOutputBuffer sessionOutputBuffer) {
        return new DefaultHttpResponseWriter(sessionOutputBuffer, this.lineFormatter);
    }

    public DefaultHttpResponseWriterFactory() {
        this(null);
    }
}
