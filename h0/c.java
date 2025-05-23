package h0;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes.dex */
public final class c extends FilterInputStream {

    /* renamed from: d, reason: collision with root package name */
    private final long f403947d;

    /* renamed from: e, reason: collision with root package name */
    private int f403948e;

    c(@NonNull InputStream inputStream, long j3) {
        super(inputStream);
        this.f403947d = j3;
    }

    private int a(int i3) throws IOException {
        if (i3 >= 0) {
            this.f403948e += i3;
        } else if (this.f403947d - this.f403948e > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f403947d + ", but read: " + this.f403948e);
        }
        return i3;
    }

    @NonNull
    public static InputStream b(@NonNull InputStream inputStream, long j3) {
        return new c(inputStream, j3);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.f403947d - this.f403948e, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        a(read >= 0 ? 1 : -1);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i3, int i16) throws IOException {
        return a(super.read(bArr, i3, i16));
    }
}
