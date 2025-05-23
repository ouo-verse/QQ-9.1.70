package com.tencent.luggage.wxa.l0;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class o implements g {

    /* renamed from: a, reason: collision with root package name */
    public final u f132825a;

    /* renamed from: b, reason: collision with root package name */
    public RandomAccessFile f132826b;

    /* renamed from: c, reason: collision with root package name */
    public Uri f132827c;

    /* renamed from: d, reason: collision with root package name */
    public long f132828d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f132829e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public o(u uVar) {
        this.f132825a = uVar;
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public long a(j jVar) {
        try {
            this.f132827c = jVar.f132782a;
            RandomAccessFile randomAccessFile = new RandomAccessFile(jVar.f132782a.getPath(), "r");
            this.f132826b = randomAccessFile;
            randomAccessFile.seek(jVar.f132785d);
            long j3 = jVar.f132786e;
            if (j3 == -1) {
                j3 = this.f132826b.length() - jVar.f132785d;
            }
            this.f132828d = j3;
            if (j3 >= 0) {
                this.f132829e = true;
                u uVar = this.f132825a;
                if (uVar != null) {
                    uVar.a(this, jVar);
                }
                return this.f132828d;
            }
            throw new EOFException();
        } catch (IOException e16) {
            throw new a(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public void close() {
        this.f132827c = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.f132826b;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e16) {
                throw new a(e16);
            }
        } finally {
            this.f132826b = null;
            if (this.f132829e) {
                this.f132829e = false;
                u uVar = this.f132825a;
                if (uVar != null) {
                    uVar.a(this);
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public Uri getUri() {
        return this.f132827c;
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public int read(byte[] bArr, int i3, int i16) {
        if (i16 == 0) {
            return 0;
        }
        long j3 = this.f132828d;
        if (j3 == 0) {
            return -1;
        }
        try {
            int read = this.f132826b.read(bArr, i3, (int) Math.min(j3, i16));
            if (read > 0) {
                this.f132828d -= read;
                u uVar = this.f132825a;
                if (uVar != null) {
                    uVar.a(this, read);
                }
            }
            return read;
        } catch (IOException e16) {
            throw new a(e16);
        }
    }
}
