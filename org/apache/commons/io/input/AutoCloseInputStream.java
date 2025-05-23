package org.apache.commons.io.input;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AutoCloseInputStream extends ProxyInputStream {
    public AutoCloseInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // org.apache.commons.io.input.ProxyInputStream
    protected void afterRead(int i3) throws IOException {
        if (i3 == -1) {
            close();
        }
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterInputStream) this).in.close();
        ((FilterInputStream) this).in = new ClosedInputStream();
    }

    protected void finalize() throws Throwable {
        close();
        super.finalize();
    }
}
