package org.apache.http.conn;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public class EofSensorInputStream extends InputStream implements ConnectionReleaseTrigger {
    protected InputStream wrappedStream;

    public EofSensorInputStream(InputStream inputStream, EofSensorWatcher eofSensorWatcher) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ConnectionReleaseTrigger
    public void abortConnection() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        throw new RuntimeException("Stub!");
    }

    protected void checkAbort() throws IOException {
        throw new RuntimeException("Stub!");
    }

    protected void checkClose() throws IOException {
        throw new RuntimeException("Stub!");
    }

    protected void checkEOF(int i3) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        throw new RuntimeException("Stub!");
    }

    protected boolean isReadAllowed() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ConnectionReleaseTrigger
    public void releaseConnection() throws IOException {
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
