package com.tencent.smtt.utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private final RandomAccessFile f369660a;

    /* renamed from: b, reason: collision with root package name */
    private final File f369661b;

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f369662c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f369663d;

    public c(String str) throws FileNotFoundException {
        this(new File(str));
    }

    public void a(boolean z16) {
        this.f369663d = z16;
    }

    public final int b() throws IOException {
        int readInt = this.f369660a.readInt();
        if (this.f369663d) {
            return ((readInt & (-16777216)) >>> 24) | ((readInt & 255) << 24) | ((65280 & readInt) << 8) | ((16711680 & readInt) >>> 8);
        }
        return readInt;
    }

    public final long c() throws IOException {
        if (this.f369663d) {
            this.f369660a.readFully(this.f369662c, 0, 8);
            byte[] bArr = this.f369662c;
            return (bArr[0] & 255) | (bArr[7] << 56) | ((bArr[6] & 255) << 48) | ((bArr[5] & 255) << 40) | ((bArr[4] & 255) << 32) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8);
        }
        return this.f369660a.readLong();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.f369660a.close();
        } catch (IOException e16) {
            e16.printStackTrace();
        }
    }

    public c(File file) throws FileNotFoundException {
        this.f369662c = new byte[8];
        this.f369661b = file;
        this.f369660a = new RandomAccessFile(file, "r");
    }

    public void a(long j3) throws IOException {
        this.f369660a.seek(j3);
    }

    public final int a(byte[] bArr) throws IOException {
        return this.f369660a.read(bArr);
    }

    public final int a(char[] cArr) throws IOException {
        byte[] bArr = new byte[cArr.length];
        int read = this.f369660a.read(bArr);
        for (int i3 = 0; i3 < cArr.length; i3++) {
            cArr[i3] = (char) bArr[i3];
        }
        return read;
    }

    public final short a() throws IOException {
        short readShort = this.f369660a.readShort();
        if (!this.f369663d) {
            return readShort;
        }
        return (short) (((readShort & 65280) >>> 8) | ((readShort & 255) << 8));
    }
}
