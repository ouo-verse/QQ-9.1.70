package com.tencent.luggage.wxa.qg;

import android.net.Uri;
import android.text.TextUtils;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: P */
/* loaded from: classes8.dex */
public class k implements t {

    /* renamed from: a, reason: collision with root package name */
    public final s f138751a;

    /* renamed from: b, reason: collision with root package name */
    public RandomAccessFile f138752b;

    /* renamed from: c, reason: collision with root package name */
    public String f138753c;

    /* renamed from: d, reason: collision with root package name */
    public long f138754d;

    /* renamed from: e, reason: collision with root package name */
    public long f138755e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f138756f;

    /* renamed from: g, reason: collision with root package name */
    public Uri f138757g;

    /* renamed from: h, reason: collision with root package name */
    public String f138758h;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public k() {
        this(null);
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public long a(g gVar) {
        try {
            this.f138757g = gVar.f138703a;
            RandomAccessFile randomAccessFile = new RandomAccessFile(gVar.f138703a.getPath(), "r");
            this.f138752b = randomAccessFile;
            randomAccessFile.seek(gVar.f138705c);
            long j3 = gVar.f138706d;
            if (j3 == -1) {
                j3 = this.f138752b.length() - gVar.f138705c;
            }
            this.f138754d = j3;
            this.f138755e = this.f138752b.length() - gVar.f138705c;
            if (this.f138754d >= 0) {
                this.f138756f = true;
                s sVar = this.f138751a;
                if (sVar != null) {
                    sVar.onTransferStart();
                }
                return this.f138754d;
            }
            throw new EOFException();
        } catch (IOException e16) {
            throw new a(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public long available() {
        return this.f138755e;
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public long c() {
        try {
            return this.f138752b.length();
        } catch (IOException e16) {
            e16.printStackTrace();
            return 0L;
        }
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public void close() {
        this.f138753c = null;
        RandomAccessFile randomAccessFile = this.f138752b;
        if (randomAccessFile != null) {
            try {
                try {
                    randomAccessFile.close();
                } catch (IOException e16) {
                    throw new a(e16);
                }
            } finally {
                this.f138752b = null;
                if (this.f138756f) {
                    this.f138756f = false;
                    s sVar = this.f138751a;
                    if (sVar != null) {
                        sVar.onTransferEnd();
                    }
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public com.tencent.luggage.wxa.rg.b getFileType() {
        String type = com.tencent.luggage.wxa.og.a.a().b().getContentResolver().getType(this.f138757g);
        if (type == null) {
            return com.tencent.luggage.wxa.rg.b.f139664e;
        }
        return com.tencent.luggage.wxa.rg.b.d(type);
    }

    @Override // com.tencent.luggage.wxa.qg.t
    public String getUri() {
        Uri uri;
        if (TextUtils.isEmpty(this.f138753c) && (uri = this.f138757g) != null) {
            this.f138753c = uri.toString();
        }
        return this.f138753c;
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public int read(byte[] bArr, int i3, int i16) {
        long j3 = this.f138754d;
        if (j3 == 0) {
            return -1;
        }
        try {
            int read = this.f138752b.read(bArr, i3, (int) Math.min(j3, i16));
            if (read > 0) {
                this.f138754d -= read;
                s sVar = this.f138751a;
                if (sVar != null) {
                    sVar.a(read);
                }
            }
            return read;
        } catch (IOException e16) {
            throw new a(e16);
        }
    }

    public k(s sVar) {
        this.f138755e = -1L;
        this.f138758h = "";
        this.f138751a = sVar;
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public void a(String str) {
        this.f138758h = str;
    }
}
