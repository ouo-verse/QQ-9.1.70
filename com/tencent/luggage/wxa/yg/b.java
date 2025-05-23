package com.tencent.luggage.wxa.yg;

import android.net.Uri;
import com.tencent.luggage.wxa.l0.g;
import com.tencent.luggage.wxa.l0.i;
import com.tencent.luggage.wxa.l0.j;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.msf.core.auth.k;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class b extends InputStream {

    /* renamed from: h, reason: collision with root package name */
    public static final a f145781h = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final g f145782a;

    /* renamed from: b, reason: collision with root package name */
    public final Uri f145783b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f145784c;

    /* renamed from: d, reason: collision with root package name */
    public long f145785d;

    /* renamed from: e, reason: collision with root package name */
    public long f145786e;

    /* renamed from: f, reason: collision with root package name */
    public InputStream f145787f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f145788g;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(g dataSource, Uri uri) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.f145782a = dataSource;
        this.f145783b = uri;
        this.f145784c = new byte[1];
    }

    public final InputStream a() {
        String str;
        InputStream inputStream = this.f145787f;
        long j3 = this.f145785d;
        long j16 = this.f145786e;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("requireInputStream, curInputStream is ");
        if (inputStream == null) {
            str = "null";
        } else {
            str = "not null";
        }
        sb5.append(str);
        sb5.append(", curReadPos: ");
        sb5.append(j3);
        sb5.append(", expectReadLen: ");
        sb5.append(j16);
        w.a("MicroMsg.AppBrand.RealInferContentTypeInputStream", sb5.toString());
        if (inputStream == null) {
            if (32768 <= j3) {
                w.d("MicroMsg.AppBrand.RealInferContentTypeInputStream", "requireInputStream, reach max read length");
                return null;
            }
            if (j3 < j16) {
                w.d("MicroMsg.AppBrand.RealInferContentTypeInputStream", "requireInputStream, end of file");
                return null;
            }
            this.f145786e = j3;
            i iVar = new i(this.f145782a, new j(this.f145783b, j3, 1024L, null));
            this.f145787f = iVar;
            this.f145786e += 1024;
            return iVar;
        }
        return inputStream;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        w.a("MicroMsg.AppBrand.RealInferContentTypeInputStream", "close");
        if (!this.f145788g) {
            d();
            this.f145785d = 0L;
            this.f145788g = true;
        }
    }

    public final void d() {
        InputStream inputStream = this.f145787f;
        if (inputStream != null) {
            inputStream.close();
        }
        this.f145787f = null;
    }

    @Override // java.io.InputStream
    public int read() {
        w.a("MicroMsg.AppBrand.RealInferContentTypeInputStream", k.f247491e);
        if (-1 == read(this.f145784c)) {
            return -1;
        }
        return this.f145784c[0];
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        w.a("MicroMsg.AppBrand.RealInferContentTypeInputStream", "read([B)");
        com.tencent.luggage.wxa.n0.a.b(!this.f145788g);
        InputStream a16 = a();
        if (a16 == null) {
            return -1;
        }
        try {
            int read = a16.read(bArr);
            if (-1 == read) {
                d();
                return read(bArr);
            }
            this.f145785d += read;
            return read;
        } catch (IOException e16) {
            w.d("MicroMsg.AppBrand.RealInferContentTypeInputStream", "read([B), fail since " + e16);
            throw e16;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i16) {
        w.a("MicroMsg.AppBrand.RealInferContentTypeInputStream", "read([BII), off: " + i3 + ", len: " + i16);
        com.tencent.luggage.wxa.n0.a.b(this.f145788g ^ true);
        InputStream a16 = a();
        if (a16 == null) {
            return -1;
        }
        try {
            int read = a16.read(bArr, i3, i16);
            if (-1 == read) {
                d();
                return read(bArr, i3, i16);
            }
            this.f145785d += read;
            return read;
        } catch (IOException e16) {
            w.a("MicroMsg.AppBrand.RealInferContentTypeInputStream", e16, "read([BII), fail", new Object[0]);
            throw e16;
        }
    }
}
