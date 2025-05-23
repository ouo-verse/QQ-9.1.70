package org.apache.commons.io.output;

import java.io.FilterOutputStream;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CloseShieldOutputStream extends ProxyOutputStream {
    public CloseShieldOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // org.apache.commons.io.output.ProxyOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ((FilterOutputStream) this).out = new ClosedOutputStream();
    }
}
