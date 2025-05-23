package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes.dex */
public final class c extends OutputStream {

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final OutputStream f31571d;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f31572e;

    /* renamed from: f, reason: collision with root package name */
    private r.b f31573f;

    /* renamed from: h, reason: collision with root package name */
    private int f31574h;

    public c(@NonNull OutputStream outputStream, @NonNull r.b bVar) {
        this(outputStream, bVar, 65536);
    }

    private void a() throws IOException {
        int i3 = this.f31574h;
        if (i3 > 0) {
            this.f31571d.write(this.f31572e, 0, i3);
            this.f31574h = 0;
        }
    }

    private void d() throws IOException {
        if (this.f31574h == this.f31572e.length) {
            a();
        }
    }

    private void release() {
        byte[] bArr = this.f31572e;
        if (bArr != null) {
            this.f31573f.put(bArr);
            this.f31572e = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.f31571d.close();
            release();
        } catch (Throwable th5) {
            this.f31571d.close();
            throw th5;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        a();
        this.f31571d.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i3) throws IOException {
        byte[] bArr = this.f31572e;
        int i16 = this.f31574h;
        this.f31574h = i16 + 1;
        bArr[i16] = (byte) i3;
        d();
    }

    @VisibleForTesting
    c(@NonNull OutputStream outputStream, r.b bVar, int i3) {
        this.f31571d = outputStream;
        this.f31573f = bVar;
        this.f31572e = (byte[]) bVar.b(i3, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i3, int i16) throws IOException {
        int i17 = 0;
        do {
            int i18 = i16 - i17;
            int i19 = i3 + i17;
            int i26 = this.f31574h;
            if (i26 == 0 && i18 >= this.f31572e.length) {
                this.f31571d.write(bArr, i19, i18);
                return;
            }
            int min = Math.min(i18, this.f31572e.length - i26);
            System.arraycopy(bArr, i19, this.f31572e, this.f31574h, min);
            this.f31574h += min;
            i17 += min;
            d();
        } while (i17 < i16);
    }
}
