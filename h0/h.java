package h0;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes.dex */
public class h extends FilterInputStream {

    /* renamed from: d, reason: collision with root package name */
    private int f403961d;

    public h(@NonNull InputStream inputStream) {
        super(inputStream);
        this.f403961d = Integer.MIN_VALUE;
    }

    private long a(long j3) {
        int i3 = this.f403961d;
        if (i3 == 0) {
            return -1L;
        }
        if (i3 != Integer.MIN_VALUE && j3 > i3) {
            return i3;
        }
        return j3;
    }

    private void b(long j3) {
        int i3 = this.f403961d;
        if (i3 != Integer.MIN_VALUE && j3 != -1) {
            this.f403961d = (int) (i3 - j3);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i3 = this.f403961d;
        if (i3 == Integer.MIN_VALUE) {
            return super.available();
        }
        return Math.min(i3, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i3) {
        super.mark(i3);
        this.f403961d = i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (a(1L) == -1) {
            return -1;
        }
        int read = super.read();
        b(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.f403961d = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j3) throws IOException {
        long a16 = a(j3);
        if (a16 == -1) {
            return 0L;
        }
        long skip = super.skip(a16);
        b(skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i3, int i16) throws IOException {
        int a16 = (int) a(i16);
        if (a16 == -1) {
            return -1;
        }
        int read = super.read(bArr, i3, a16);
        b(read);
        return read;
    }
}
