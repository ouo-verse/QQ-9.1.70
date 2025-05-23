package com.tencent.luggage.wxa.l0;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.tencent.luggage.wxa.n0.v;
import java.lang.reflect.InvocationTargetException;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l implements g {

    /* renamed from: a, reason: collision with root package name */
    public final Context f132797a;

    /* renamed from: b, reason: collision with root package name */
    public final u f132798b;

    /* renamed from: c, reason: collision with root package name */
    public final g f132799c;

    /* renamed from: d, reason: collision with root package name */
    public g f132800d;

    /* renamed from: e, reason: collision with root package name */
    public g f132801e;

    /* renamed from: f, reason: collision with root package name */
    public g f132802f;

    /* renamed from: g, reason: collision with root package name */
    public g f132803g;

    /* renamed from: h, reason: collision with root package name */
    public g f132804h;

    public l(Context context, u uVar, g gVar) {
        this.f132797a = context.getApplicationContext();
        this.f132798b = uVar;
        this.f132799c = (g) com.tencent.luggage.wxa.n0.a.a(gVar);
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public long a(j jVar) {
        com.tencent.luggage.wxa.n0.a.b(this.f132804h == null);
        String scheme = jVar.f132782a.getScheme();
        if (v.a(jVar.f132782a)) {
            if (jVar.f132782a.getPath().startsWith("/android_asset/")) {
                this.f132804h = a();
            } else {
                this.f132804h = c();
            }
        } else if ("asset".equals(scheme)) {
            this.f132804h = a();
        } else if ("content".equals(scheme)) {
            this.f132804h = b();
        } else if ("rtmp".equals(scheme)) {
            this.f132804h = d();
        } else {
            this.f132804h = this.f132799c;
        }
        return this.f132804h.a(jVar);
    }

    public final g b() {
        if (this.f132802f == null) {
            this.f132802f = new e(this.f132797a, this.f132798b);
        }
        return this.f132802f;
    }

    public final g c() {
        if (this.f132800d == null) {
            this.f132800d = new o(this.f132798b);
        }
        return this.f132800d;
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public void close() {
        g gVar = this.f132804h;
        if (gVar != null) {
            try {
                gVar.close();
            } finally {
                this.f132804h = null;
            }
        }
    }

    public final g d() {
        if (this.f132803g == null) {
            try {
                this.f132803g = (g) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException unused) {
                Log.w("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (IllegalAccessException e16) {
                Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", e16);
            } catch (InstantiationException e17) {
                Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", e17);
            } catch (NoSuchMethodException e18) {
                Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", e18);
            } catch (InvocationTargetException e19) {
                Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", e19);
            }
            if (this.f132803g == null) {
                this.f132803g = this.f132799c;
            }
        }
        return this.f132803g;
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public Uri getUri() {
        g gVar = this.f132804h;
        if (gVar == null) {
            return null;
        }
        return gVar.getUri();
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public int read(byte[] bArr, int i3, int i16) {
        return this.f132804h.read(bArr, i3, i16);
    }

    public final g a() {
        if (this.f132801e == null) {
            this.f132801e = new c(this.f132797a, this.f132798b);
        }
        return this.f132801e;
    }
}
