package com.google.android.exoplayer2.util;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class ReusableBufferedOutputStream extends BufferedOutputStream {
    private boolean closed;

    public ReusableBufferedOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
        try {
            flush();
            th = null;
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            ((BufferedOutputStream) this).out.close();
        } catch (Throwable th6) {
            if (th == null) {
                th = th6;
            }
        }
        if (th != null) {
            Util.sneakyThrow(th);
        }
    }

    public void reset(OutputStream outputStream) {
        Assertions.checkState(this.closed);
        ((BufferedOutputStream) this).out = outputStream;
        ((BufferedOutputStream) this).count = 0;
        this.closed = false;
    }

    public ReusableBufferedOutputStream(OutputStream outputStream, int i3) {
        super(outputStream, i3);
    }
}
