package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.ad;
import com.vivo.push.util.af;
import com.vivo.push.util.k;
import com.vivo.push.util.u;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class c<T> {

    /* renamed from: a, reason: collision with root package name */
    protected static final Object f387619a = new Object();

    /* renamed from: b, reason: collision with root package name */
    protected List<T> f387620b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    protected Context f387621c;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f387622d;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f387623e;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context) {
        this.f387621c = ContextDelegate.getContext(context);
        ad b16 = ad.b();
        b16.a(this.f387621c);
        this.f387622d = b16.c();
        this.f387623e = b16.d();
        c();
    }

    private String b() {
        return af.b(this.f387621c).a(a(), null);
    }

    private void d(String str) {
        af.b(this.f387621c).b(a(), str);
    }

    protected abstract String a();

    protected abstract List<T> a(String str);

    abstract String b(String str) throws Exception;

    public final void c() {
        synchronized (f387619a) {
            k.a(a());
            this.f387620b.clear();
            c(b());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final byte[] e() {
        byte[] bArr = this.f387622d;
        if (bArr != null && bArr.length > 0) {
            return bArr;
        }
        return ad.b().c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final byte[] f() {
        byte[] bArr = this.f387623e;
        if (bArr != null && bArr.length > 0) {
            return bArr;
        }
        return ad.b().d();
    }

    public final void d() {
        synchronized (f387619a) {
            this.f387620b.clear();
            d("");
            u.d("CacheSettings", "clear " + a() + " strApps");
        }
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            u.d("CacheSettings", "ClientManager init " + a() + " strApps empty.");
            return;
        }
        if (str.length() > 10000) {
            u.d("CacheSettings", "sync " + a() + " strApps lenght too large");
            d();
            return;
        }
        try {
            u.d("CacheSettings", "ClientManager init " + a() + " strApps : " + str);
            List<T> a16 = a(b(str));
            if (a16 != null) {
                this.f387620b.addAll(a16);
            }
        } catch (Exception e16) {
            d();
            u.d("CacheSettings", u.a(e16));
        }
    }
}
