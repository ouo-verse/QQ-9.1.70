package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class ThresholdingOutputStream extends OutputStream {
    private final int threshold;
    private boolean thresholdExceeded;
    private long written;

    public ThresholdingOutputStream(int i3) {
        this.threshold = i3;
    }

    protected void checkThreshold(int i3) throws IOException {
        if (!this.thresholdExceeded && this.written + i3 > this.threshold) {
            this.thresholdExceeded = true;
            thresholdReached();
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
        } catch (IOException unused) {
        }
        getStream().close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        getStream().flush();
    }

    public long getByteCount() {
        return this.written;
    }

    protected abstract OutputStream getStream() throws IOException;

    public int getThreshold() {
        return this.threshold;
    }

    public boolean isThresholdExceeded() {
        if (this.written > this.threshold) {
            return true;
        }
        return false;
    }

    protected void resetByteCount() {
        this.thresholdExceeded = false;
        this.written = 0L;
    }

    protected void setByteCount(long j3) {
        this.written = j3;
    }

    protected abstract void thresholdReached() throws IOException;

    @Override // java.io.OutputStream
    public void write(int i3) throws IOException {
        checkThreshold(1);
        getStream().write(i3);
        this.written++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        checkThreshold(bArr.length);
        getStream().write(bArr);
        this.written += bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i3, int i16) throws IOException {
        checkThreshold(i16);
        getStream().write(bArr, i3, i16);
        this.written += i16;
    }
}
