package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes.dex */
public final class g extends FilterInputStream {

    /* renamed from: f, reason: collision with root package name */
    private static final byte[] f31578f;

    /* renamed from: h, reason: collision with root package name */
    private static final int f31579h;

    /* renamed from: i, reason: collision with root package name */
    private static final int f31580i;

    /* renamed from: d, reason: collision with root package name */
    private final byte f31581d;

    /* renamed from: e, reason: collision with root package name */
    private int f31582e;

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, RegisterType.REFERENCE, 0, 2, 0, 0, 0, 1, 0};
        f31578f = bArr;
        int length = bArr.length;
        f31579h = length;
        f31580i = length + 2;
    }

    public g(InputStream inputStream, int i3) {
        super(inputStream);
        if (i3 >= -1 && i3 <= 8) {
            this.f31581d = (byte) i3;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i3);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read;
        int i3;
        int i16 = this.f31582e;
        if (i16 < 2 || i16 > (i3 = f31580i)) {
            read = super.read();
        } else if (i16 == i3) {
            read = this.f31581d;
        } else {
            read = f31578f[i16 - 2] & 255;
        }
        if (read != -1) {
            this.f31582e++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j3) throws IOException {
        long skip = super.skip(j3);
        if (skip > 0) {
            this.f31582e = (int) (this.f31582e + skip);
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i3, int i16) throws IOException {
        int i17;
        int i18 = this.f31582e;
        int i19 = f31580i;
        if (i18 > i19) {
            i17 = super.read(bArr, i3, i16);
        } else if (i18 == i19) {
            bArr[i3] = this.f31581d;
            i17 = 1;
        } else if (i18 < 2) {
            i17 = super.read(bArr, i3, 2 - i18);
        } else {
            int min = Math.min(i19 - i18, i16);
            System.arraycopy(f31578f, this.f31582e - 2, bArr, i3, min);
            i17 = min;
        }
        if (i17 > 0) {
            this.f31582e += i17;
        }
        return i17;
    }
}
