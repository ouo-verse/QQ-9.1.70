package com.tencent.luggage.wxa.qg;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements t {

    /* renamed from: a, reason: collision with root package name */
    public final AssetManager f138689a;

    /* renamed from: b, reason: collision with root package name */
    public final s f138690b;

    /* renamed from: c, reason: collision with root package name */
    public Uri f138691c;

    /* renamed from: d, reason: collision with root package name */
    public InputStream f138692d;

    /* renamed from: e, reason: collision with root package name */
    public long f138693e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f138694f;

    /* renamed from: g, reason: collision with root package name */
    public long f138695g;

    /* renamed from: h, reason: collision with root package name */
    public long f138696h;

    /* renamed from: i, reason: collision with root package name */
    public String f138697i;

    /* renamed from: j, reason: collision with root package name */
    public String f138698j;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.qg.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6644a extends IOException {
        public C6644a(IOException iOException) {
            super(iOException);
        }
    }

    public a(Context context) {
        this(context, null);
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public long a(g gVar) {
        try {
            Uri uri = gVar.f138703a;
            this.f138691c = uri;
            String path = uri.getPath();
            this.f138697i = path;
            if (path.startsWith("/android_asset/")) {
                this.f138697i = this.f138697i.substring(15);
            } else if (this.f138697i.startsWith("/")) {
                this.f138697i = this.f138697i.substring(1);
            }
            this.f138692d = this.f138689a.open(this.f138697i, 1);
            e();
            long j3 = this.f138695g;
            long j16 = gVar.f138705c;
            this.f138696h = j3 - j16;
            if (this.f138692d.skip(j16) >= gVar.f138705c) {
                long j17 = gVar.f138706d;
                if (j17 != -1) {
                    this.f138693e = j17;
                } else {
                    long available = this.f138692d.available();
                    this.f138693e = available;
                    if (available == TTL.MAX_VALUE) {
                        this.f138693e = -1L;
                    }
                }
                this.f138694f = true;
                s sVar = this.f138690b;
                if (sVar != null) {
                    sVar.onTransferStart();
                }
                return this.f138693e;
            }
            throw new EOFException();
        } catch (IOException e16) {
            throw new C6644a(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public long available() {
        return this.f138696h;
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public long c() {
        return this.f138695g;
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public void close() {
        this.f138691c = null;
        try {
            try {
                InputStream inputStream = this.f138692d;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e16) {
                throw new C6644a(e16);
            }
        } finally {
            this.f138692d = null;
            if (this.f138694f) {
                this.f138694f = false;
                s sVar = this.f138690b;
                if (sVar != null) {
                    sVar.onTransferEnd();
                }
            }
        }
    }

    public final String d() {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(this.f138697i);
        if (fileExtensionFromUrl != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return null;
    }

    public final void e() {
        this.f138695g = -1L;
        AssetFileDescriptor assetFileDescriptor = null;
        try {
            try {
                assetFileDescriptor = this.f138689a.openFd(this.f138697i);
                this.f138695g = assetFileDescriptor.getLength();
                assetFileDescriptor.close();
            } catch (IOException e16) {
                e16.printStackTrace();
                if (assetFileDescriptor != null) {
                    assetFileDescriptor.close();
                }
            }
            if (this.f138695g == -1) {
                this.f138695g = -1L;
            }
        } catch (Throwable th5) {
            if (assetFileDescriptor != null) {
                try {
                    assetFileDescriptor.close();
                } catch (IOException unused) {
                }
            }
            throw th5;
        }
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public com.tencent.luggage.wxa.rg.b getFileType() {
        String d16 = d();
        if (TextUtils.isEmpty(d16)) {
            return com.tencent.luggage.wxa.rg.b.f139663d;
        }
        return com.tencent.luggage.wxa.rg.b.d(d16);
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public int read(byte[] bArr, int i3, int i16) {
        if (i16 == 0) {
            return 0;
        }
        long j3 = this.f138693e;
        if (j3 == 0) {
            return -1;
        }
        if (j3 != -1) {
            try {
                i16 = (int) Math.min(j3, i16);
            } catch (IOException e16) {
                throw new C6644a(e16);
            }
        }
        int read = this.f138692d.read(bArr, i3, i16);
        if (read == -1) {
            if (this.f138693e == -1) {
                return -1;
            }
            throw new C6644a(new EOFException());
        }
        long j16 = this.f138693e;
        if (j16 != -1) {
            this.f138693e = j16 - read;
        }
        s sVar = this.f138690b;
        if (sVar != null) {
            sVar.a(read);
        }
        return read;
    }

    public a(Context context, s sVar) {
        this.f138695g = -1L;
        this.f138696h = -1L;
        this.f138698j = "";
        this.f138689a = context.getAssets();
        this.f138690b = sVar;
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public void a(String str) {
        this.f138698j = str;
    }
}
