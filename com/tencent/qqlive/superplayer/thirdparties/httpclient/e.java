package com.tencent.qqlive.superplayer.thirdparties.httpclient;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class e extends InputStream {

    /* renamed from: d, reason: collision with root package name */
    private final d f345431d;

    /* renamed from: e, reason: collision with root package name */
    private final DataSpec f345432e;

    /* renamed from: m, reason: collision with root package name */
    private long f345436m;

    /* renamed from: h, reason: collision with root package name */
    private boolean f345434h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f345435i = false;

    /* renamed from: f, reason: collision with root package name */
    private final byte[] f345433f = new byte[1];

    public e(d dVar, DataSpec dataSpec) {
        this.f345431d = dVar;
        this.f345432e = dataSpec;
    }

    private void a() throws IOException {
        if (!this.f345434h) {
            this.f345431d.a(this.f345432e);
            this.f345434h = true;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f345435i) {
            this.f345431d.close();
            this.f345435i = true;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.f345433f) == -1) {
            return -1;
        }
        return this.f345433f[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(@NonNull byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(@NonNull byte[] bArr, int i3, int i16) throws IOException {
        a.e(!this.f345435i);
        a();
        int read = this.f345431d.read(bArr, i3, i16);
        if (read == -1) {
            return -1;
        }
        this.f345436m += read;
        return read;
    }
}
