package org.apache.httpcore.impl.io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.httpcore.io.BufferInfo;
import org.apache.httpcore.io.SessionInputBuffer;
import org.apache.httpcore.util.Args;

/* compiled from: P */
/* loaded from: classes29.dex */
public class IdentityInputStream extends InputStream {
    private boolean closed = false;

    /* renamed from: in, reason: collision with root package name */
    private final SessionInputBuffer f423548in;

    public IdentityInputStream(SessionInputBuffer sessionInputBuffer) {
        this.f423548in = (SessionInputBuffer) Args.notNull(sessionInputBuffer, "Session input buffer");
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        SessionInputBuffer sessionInputBuffer = this.f423548in;
        if (sessionInputBuffer instanceof BufferInfo) {
            return ((BufferInfo) sessionInputBuffer).length();
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.closed) {
            return -1;
        }
        return this.f423548in.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        if (this.closed) {
            return -1;
        }
        return this.f423548in.read(bArr, i3, i16);
    }
}
