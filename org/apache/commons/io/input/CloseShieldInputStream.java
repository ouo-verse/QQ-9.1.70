package org.apache.commons.io.input;

import java.io.FilterInputStream;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CloseShieldInputStream extends ProxyInputStream {
    public CloseShieldInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ((FilterInputStream) this).in = new ClosedInputStream();
    }
}
