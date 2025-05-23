package com.tencent.luggage.wxa.mc;

import android.text.TextUtils;
import com.tencent.luggage.wxa.n4.a;
import com.tencent.luggage.wxa.tn.w0;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Locale;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a implements com.tencent.luggage.wxa.rc.q {

    /* renamed from: a, reason: collision with root package name */
    public volatile String f134248a;

    /* renamed from: b, reason: collision with root package name */
    public volatile String f134249b;

    /* renamed from: c, reason: collision with root package name */
    public volatile String f134250c;

    /* renamed from: d, reason: collision with root package name */
    public volatile com.tencent.luggage.wxa.xa.h f134251d;

    /* renamed from: e, reason: collision with root package name */
    public volatile com.tencent.luggage.wxa.n4.a f134252e;

    @Override // com.tencent.luggage.wxa.rc.q
    public final String D() {
        r();
        return this.f134249b;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(com.tencent.luggage.wxa.rc.q qVar) {
        if (qVar == null) {
            return -1;
        }
        if (qVar.getClass() == getClass() && qVar.w() > 0 && qVar.w() == w()) {
            return 0;
        }
        return u().compareTo(qVar.u());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && compareTo((com.tencent.luggage.wxa.rc.q) obj) == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.mc.k
    public final String g(String str) {
        InputStream a16 = a(str);
        if (a16 == null) {
            return null;
        }
        long a17 = w0.a();
        String b16 = com.tencent.luggage.wxa.tk.c.b(a16);
        w0.a((Closeable) a16);
        com.tencent.luggage.wxa.tn.w.g("MicroMsg.AppBrand.AbsReader", "readAsString(%s), cost %dms", str, Long.valueOf(w0.a() - a17));
        return b16;
    }

    @Override // com.tencent.luggage.wxa.rc.q
    public final String h(String str) {
        com.tencent.luggage.wxa.xa.h c16;
        if (TextUtils.isEmpty(str) || (c16 = y().c(com.tencent.rmonitor.base.config.data.k.FEATURES_KEY)) == null) {
            return null;
        }
        return c16.optString(str, null);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(w()), u());
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0043  */
    @Override // com.tencent.luggage.wxa.mc.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String r() {
        String str;
        String str2;
        String str3 = "";
        if (TextUtils.isEmpty(this.f134248a)) {
            try {
                com.tencent.luggage.wxa.xa.h y16 = y();
                str2 = y16.getString("version");
                try {
                    str = y16.getString("updateTime");
                } catch (Exception e16) {
                    e = e16;
                    str = "";
                }
            } catch (Exception e17) {
                e = e17;
                str = "";
                str2 = str;
            }
            try {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.AbsReader", "AbsReader version parsed wx.version[%s | %s]", str2, str);
            } catch (Exception e18) {
                e = e18;
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.AbsReader", e, "get WAVersion.json failed.", new Object[0]);
                if (str2 != null) {
                }
                this.f134248a = str3;
                this.f134249b = str;
                this.f134250c = String.format(Locale.US, "%s (%s)", this.f134248a, this.f134249b);
                return this.f134248a;
            }
            if (str2 != null) {
                str3 = str2;
            }
            this.f134248a = str3;
            this.f134249b = str;
            this.f134250c = String.format(Locale.US, "%s (%s)", this.f134248a, this.f134249b);
        }
        return this.f134248a;
    }

    @Override // com.tencent.luggage.wxa.mc.k
    public final String u() {
        r();
        return w0.d(this.f134250c);
    }

    @Override // com.tencent.luggage.wxa.mc.k
    public final int w() {
        return e().pkgVersion();
    }

    public final synchronized com.tencent.luggage.wxa.n4.a x() {
        if (this.f134252e == null) {
            this.f134252e = a.c.a(h("expt"), h("exptNeedParams"));
            if (this.f134252e == null) {
                this.f134252e = a.c.a();
            }
        }
        return this.f134252e;
    }

    public final com.tencent.luggage.wxa.xa.h y() {
        com.tencent.luggage.wxa.xa.h hVar;
        if (this.f134251d == null) {
            synchronized (this) {
                if (this.f134251d == null) {
                    String g16 = g("WAVersion.json");
                    if (TextUtils.isEmpty(g16)) {
                        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.AbsReader", "getVersionMetaJson EMPTY WAVersion.json, info=%s", e());
                    }
                    try {
                        if (TextUtils.isEmpty(g16)) {
                            hVar = new com.tencent.luggage.wxa.xa.h();
                        } else {
                            hVar = new com.tencent.luggage.wxa.xa.h(g16);
                        }
                        this.f134251d = hVar;
                    } catch (com.tencent.luggage.wxa.xa.f e16) {
                        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.AbsReader", e16, "parse WAVersion.json[%s] ", g16);
                        return new com.tencent.luggage.wxa.xa.h();
                    }
                }
            }
        }
        return this.f134251d;
    }
}
