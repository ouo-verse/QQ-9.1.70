package org.apache.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.io.SessionInputBuffer;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public class ChunkedInputStream extends InputStream {
    public ChunkedInputStream(SessionInputBuffer sessionInputBuffer) {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        throw new RuntimeException("Stub!");
    }

    public Header[] getFooters() {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        throw new RuntimeException("Stub!");
    }
}
