package com.tencent.tbs.one.impl.c.a;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class a implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    boolean f374639a;

    /* renamed from: b, reason: collision with root package name */
    private final RandomAccessFile f374640b;

    /* renamed from: c, reason: collision with root package name */
    private final File f374641c;

    /* renamed from: d, reason: collision with root package name */
    private final byte[] f374642d = new byte[8];

    public a(File file) throws FileNotFoundException {
        this.f374641c = file;
        this.f374640b = new RandomAccessFile(file, "r");
    }

    public final void a(long j3) throws IOException {
        this.f374640b.seek(j3);
    }

    public final int b() throws IOException {
        int readInt = this.f374640b.readInt();
        if (this.f374639a) {
            return ((readInt & (-16777216)) >>> 24) | ((readInt & 255) << 24) | ((65280 & readInt) << 8) | ((16711680 & readInt) >>> 8);
        }
        return readInt;
    }

    public final long c() throws IOException {
        if (this.f374639a) {
            this.f374640b.readFully(this.f374642d, 0, 8);
            byte[] bArr = this.f374642d;
            return (bArr[0] & 255) | (bArr[7] << 56) | ((bArr[6] & 255) << 48) | ((bArr[5] & 255) << 40) | ((bArr[4] & 255) << 32) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8);
        }
        return this.f374640b.readLong();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        com.tencent.tbs.one.impl.a.d.a(this.f374640b);
    }

    public final int a(byte[] bArr) throws IOException {
        return this.f374640b.read(bArr);
    }

    public final int a(char[] cArr) throws IOException {
        byte[] bArr = new byte[cArr.length];
        int read = this.f374640b.read(bArr);
        for (int i3 = 0; i3 < cArr.length; i3++) {
            cArr[i3] = (char) bArr[i3];
        }
        return read;
    }

    public final short a() throws IOException {
        short readShort = this.f374640b.readShort();
        if (!this.f374639a) {
            return readShort;
        }
        return (short) (((readShort & 65280) >>> 8) | ((readShort & 255) << 8));
    }
}
