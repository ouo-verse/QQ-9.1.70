package com.tencent.luggage.wxa.qg;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.oskplayer.datasource.RawResourceDataSource;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

/* compiled from: P */
/* loaded from: classes8.dex */
public class o implements t {

    /* renamed from: a, reason: collision with root package name */
    public final Resources f138767a;

    /* renamed from: b, reason: collision with root package name */
    public final s f138768b;

    /* renamed from: c, reason: collision with root package name */
    public Uri f138769c;

    /* renamed from: d, reason: collision with root package name */
    public AssetFileDescriptor f138770d;

    /* renamed from: e, reason: collision with root package name */
    public InputStream f138771e;

    /* renamed from: f, reason: collision with root package name */
    public long f138772f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f138773g;

    /* renamed from: h, reason: collision with root package name */
    public String f138774h;

    /* renamed from: i, reason: collision with root package name */
    public long f138775i;

    /* renamed from: j, reason: collision with root package name */
    public long f138776j;

    /* renamed from: k, reason: collision with root package name */
    public String f138777k;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a extends IOException {
        public a(String str) {
            super(str);
        }

        public a(IOException iOException) {
            super(iOException);
        }
    }

    public o(Context context) {
        this(context, null);
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public long a(g gVar) {
        try {
            Uri uri = gVar.f138703a;
            this.f138769c = uri;
            if (TextUtils.equals(RawResourceDataSource.RAW_RESOURCE_SCHEME, uri.getScheme())) {
                try {
                    AssetFileDescriptor openRawResourceFd = this.f138767a.openRawResourceFd(Integer.parseInt(this.f138769c.getLastPathSegment()));
                    this.f138770d = openRawResourceFd;
                    long length = openRawResourceFd.getLength();
                    this.f138775i = length;
                    this.f138776j = length - gVar.f138705c;
                    FileInputStream fileInputStream = new FileInputStream(this.f138770d.getFileDescriptor());
                    this.f138771e = fileInputStream;
                    if (fileInputStream.markSupported()) {
                        this.f138774h = URLConnection.guessContentTypeFromStream(this.f138771e);
                    }
                    this.f138771e.skip(this.f138770d.getStartOffset());
                    if (this.f138771e.skip(gVar.f138705c) >= gVar.f138705c) {
                        long j3 = gVar.f138706d;
                        long j16 = -1;
                        if (j3 != -1) {
                            this.f138772f = j3;
                        } else {
                            long length2 = this.f138770d.getLength();
                            if (length2 != -1) {
                                j16 = length2 - gVar.f138705c;
                            }
                            this.f138772f = j16;
                        }
                        this.f138773g = true;
                        s sVar = this.f138768b;
                        if (sVar != null) {
                            sVar.onTransferStart();
                        }
                        return this.f138772f;
                    }
                    throw new EOFException();
                } catch (NumberFormatException unused) {
                    throw new a("Resource identifier must be an integer.");
                }
            }
            throw new a("URI must use scheme android.resource");
        } catch (IOException e16) {
            throw new a(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public long available() {
        return this.f138776j;
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public long c() {
        return this.f138775i;
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public void close() {
        this.f138769c = null;
        try {
            try {
                InputStream inputStream = this.f138771e;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.f138771e = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f138770d;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e16) {
                        throw new a(e16);
                    }
                } finally {
                    this.f138770d = null;
                    if (this.f138773g) {
                        this.f138773g = false;
                        s sVar = this.f138768b;
                        if (sVar != null) {
                            sVar.onTransferEnd();
                        }
                    }
                }
            } catch (IOException e17) {
                throw new a(e17);
            }
        } catch (Throwable th5) {
            this.f138771e = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f138770d;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f138770d = null;
                    if (this.f138773g) {
                        this.f138773g = false;
                        s sVar2 = this.f138768b;
                        if (sVar2 != null) {
                            sVar2.onTransferEnd();
                        }
                    }
                    throw th5;
                } finally {
                    this.f138770d = null;
                    if (this.f138773g) {
                        this.f138773g = false;
                        s sVar3 = this.f138768b;
                        if (sVar3 != null) {
                            sVar3.onTransferEnd();
                        }
                    }
                }
            } catch (IOException e18) {
                throw new a(e18);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public com.tencent.luggage.wxa.rg.b getFileType() {
        if (TextUtils.isEmpty(this.f138774h)) {
            return com.tencent.luggage.wxa.rg.b.f139663d;
        }
        return com.tencent.luggage.wxa.rg.b.d(this.f138774h);
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public int read(byte[] bArr, int i3, int i16) {
        if (i16 == 0) {
            return 0;
        }
        long j3 = this.f138772f;
        if (j3 == 0) {
            return -1;
        }
        if (j3 != -1) {
            try {
                i16 = (int) Math.min(j3, i16);
            } catch (IOException e16) {
                throw new a(e16);
            }
        }
        int read = this.f138771e.read(bArr, i3, i16);
        if (read == -1) {
            if (this.f138772f == -1) {
                return -1;
            }
            throw new a(new EOFException());
        }
        long j16 = this.f138772f;
        if (j16 != -1) {
            this.f138772f = j16 - read;
        }
        s sVar = this.f138768b;
        if (sVar != null) {
            sVar.a(read);
        }
        return read;
    }

    public o(Context context, s sVar) {
        this.f138774h = null;
        this.f138775i = -1L;
        this.f138776j = -1L;
        this.f138777k = "";
        this.f138767a = context.getResources();
        this.f138768b = sVar;
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public void a(String str) {
        this.f138777k = str;
    }
}
