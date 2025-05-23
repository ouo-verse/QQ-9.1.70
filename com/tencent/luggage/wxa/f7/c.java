package com.tencent.luggage.wxa.f7;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang.StringUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends com.tencent.luggage.wxa.r6.a {

    /* renamed from: b, reason: collision with root package name */
    public int f125423b;

    /* renamed from: c, reason: collision with root package name */
    public String f125424c;

    /* renamed from: d, reason: collision with root package name */
    public String f125425d;

    /* renamed from: e, reason: collision with root package name */
    public int f125426e;

    /* renamed from: f, reason: collision with root package name */
    public int f125427f;

    /* renamed from: g, reason: collision with root package name */
    public String f125428g;

    /* renamed from: h, reason: collision with root package name */
    public String f125429h;

    /* renamed from: i, reason: collision with root package name */
    public String f125430i;

    /* renamed from: j, reason: collision with root package name */
    public String f125431j;

    /* renamed from: k, reason: collision with root package name */
    public int f125432k;

    /* renamed from: l, reason: collision with root package name */
    public int f125433l;

    /* renamed from: m, reason: collision with root package name */
    public int f125434m;

    /* renamed from: n, reason: collision with root package name */
    public long f125435n;

    /* renamed from: o, reason: collision with root package name */
    public int f125436o;

    /* renamed from: p, reason: collision with root package name */
    public String f125437p;

    /* renamed from: q, reason: collision with root package name */
    public int f125438q;

    /* renamed from: r, reason: collision with root package name */
    public int f125439r;

    /* renamed from: s, reason: collision with root package name */
    public String f125440s;

    /* renamed from: t, reason: collision with root package name */
    public int f125441t;

    /* renamed from: u, reason: collision with root package name */
    public String f125442u;

    /* renamed from: v, reason: collision with root package name */
    public String f125443v;

    /* renamed from: w, reason: collision with root package name */
    public String f125444w;

    public /* synthetic */ c(int i3, String str, String str2, int i16, int i17, String str3, String str4, String str5, String str6, int i18, int i19, int i26, long j3, int i27, String str7, int i28, int i29, String str8, int i36, String str9, String str10, String str11, int i37, DefaultConstructorMarker defaultConstructorMarker) {
        this((i37 & 1) != 0 ? 0 : i3, (i37 & 2) != 0 ? null : str, (i37 & 4) != 0 ? null : str2, (i37 & 8) != 0 ? 0 : i16, (i37 & 16) != 0 ? 0 : i17, (i37 & 32) != 0 ? null : str3, (i37 & 64) != 0 ? null : str4, (i37 & 128) != 0 ? null : str5, (i37 & 256) != 0 ? null : str6, (i37 & 512) != 0 ? 0 : i18, (i37 & 1024) != 0 ? 0 : i19, (i37 & 2048) != 0 ? 0 : i26, (i37 & 4096) != 0 ? 0L : j3, (i37 & 8192) != 0 ? 0 : i27, (i37 & 16384) != 0 ? null : str7, (i37 & 32768) != 0 ? 0 : i28, (i37 & 65536) != 0 ? 0 : i29, (i37 & 131072) != 0 ? null : str8, (i37 & 262144) != 0 ? 0 : i36, (i37 & 524288) != 0 ? null : str9, (i37 & 1048576) != 0 ? null : str10, (i37 & 2097152) != 0 ? null : str11);
    }

    @Override // com.tencent.luggage.wxa.r6.a
    public int a() {
        return 13542;
    }

    @Override // com.tencent.luggage.wxa.r6.a
    public boolean b() {
        return true;
    }

    public final void c(int i3) {
        this.f125426e = i3;
    }

    public final void d(int i3) {
        this.f125434m = i3;
    }

    public final void e(String str) {
        this.f125431j = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f125423b == cVar.f125423b && Intrinsics.areEqual(this.f125424c, cVar.f125424c) && Intrinsics.areEqual(this.f125425d, cVar.f125425d) && this.f125426e == cVar.f125426e && this.f125427f == cVar.f125427f && Intrinsics.areEqual(this.f125428g, cVar.f125428g) && Intrinsics.areEqual(this.f125429h, cVar.f125429h) && Intrinsics.areEqual(this.f125430i, cVar.f125430i) && Intrinsics.areEqual(this.f125431j, cVar.f125431j) && this.f125432k == cVar.f125432k && this.f125433l == cVar.f125433l && this.f125434m == cVar.f125434m && this.f125435n == cVar.f125435n && this.f125436o == cVar.f125436o && Intrinsics.areEqual(this.f125437p, cVar.f125437p) && this.f125438q == cVar.f125438q && this.f125439r == cVar.f125439r && Intrinsics.areEqual(this.f125440s, cVar.f125440s) && this.f125441t == cVar.f125441t && Intrinsics.areEqual(this.f125442u, cVar.f125442u) && Intrinsics.areEqual(this.f125443v, cVar.f125443v) && Intrinsics.areEqual(this.f125444w, cVar.f125444w)) {
            return true;
        }
        return false;
    }

    public final void f(int i3) {
        this.f125433l = i3;
    }

    public final void g(int i3) {
        this.f125439r = i3;
    }

    public final void h(String str) {
        this.f125429h = str;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        int hashCode9;
        int hashCode10;
        int i3 = this.f125423b * 31;
        String str = this.f125424c;
        int i16 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i17 = (i3 + hashCode) * 31;
        String str2 = this.f125425d;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i18 = (((((i17 + hashCode2) * 31) + this.f125426e) * 31) + this.f125427f) * 31;
        String str3 = this.f125428g;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i19 = (i18 + hashCode3) * 31;
        String str4 = this.f125429h;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int i26 = (i19 + hashCode4) * 31;
        String str5 = this.f125430i;
        if (str5 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str5.hashCode();
        }
        int i27 = (i26 + hashCode5) * 31;
        String str6 = this.f125431j;
        if (str6 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str6.hashCode();
        }
        int a16 = (((((((((((i27 + hashCode6) * 31) + this.f125432k) * 31) + this.f125433l) * 31) + this.f125434m) * 31) + androidx.fragment.app.a.a(this.f125435n)) * 31) + this.f125436o) * 31;
        String str7 = this.f125437p;
        if (str7 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = str7.hashCode();
        }
        int i28 = (((((a16 + hashCode7) * 31) + this.f125438q) * 31) + this.f125439r) * 31;
        String str8 = this.f125440s;
        if (str8 == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = str8.hashCode();
        }
        int i29 = (((i28 + hashCode8) * 31) + this.f125441t) * 31;
        String str9 = this.f125442u;
        if (str9 == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = str9.hashCode();
        }
        int i36 = (i29 + hashCode9) * 31;
        String str10 = this.f125443v;
        if (str10 == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = str10.hashCode();
        }
        int i37 = (i36 + hashCode10) * 31;
        String str11 = this.f125444w;
        if (str11 != null) {
            i16 = str11.hashCode();
        }
        return i37 + i16;
    }

    public final void i(int i3) {
        this.f125423b = i3;
    }

    public final void j(int i3) {
        this.f125438q = i3;
    }

    public final void k(String str) {
        this.f125424c = str;
    }

    public final void l(String str) {
        this.f125425d = str;
    }

    public String toString() {
        return "KVReport_CALL_JSAPI_13542(scene=" + this.f125423b + ", sceneNote=" + this.f125424c + ", wxaAppid=" + this.f125425d + ", appVersion=" + this.f125426e + ", appState=" + this.f125427f + ", pagePath=" + this.f125428g + ", networkType=" + this.f125429h + ", functionName=" + this.f125430i + ", keyParam=" + this.f125431j + ", result=" + this.f125432k + ", permissionValue=" + this.f125433l + ", errorCode=" + this.f125434m + ", costTime=" + this.f125435n + ", errorMsg=" + this.f125436o + ", errorMsgStr=" + this.f125437p + ", usedState=" + this.f125438q + ", prescene=" + this.f125439r + ", presceneNote=" + this.f125440s + ", appType=" + this.f125441t + ", keyResult=" + this.f125442u + ", keyRequest=" + this.f125443v + ", instanceId=" + this.f125444w + ')';
    }

    public c(int i3, String str, String str2, int i16, int i17, String str3, String str4, String str5, String str6, int i18, int i19, int i26, long j3, int i27, String str7, int i28, int i29, String str8, int i36, String str9, String str10, String str11) {
        this.f125423b = i3;
        this.f125424c = str;
        this.f125425d = str2;
        this.f125426e = i16;
        this.f125427f = i17;
        this.f125428g = str3;
        this.f125429h = str4;
        this.f125430i = str5;
        this.f125431j = str6;
        this.f125432k = i18;
        this.f125433l = i19;
        this.f125434m = i26;
        this.f125435n = j3;
        this.f125436o = i27;
        this.f125437p = str7;
        this.f125438q = i28;
        this.f125439r = i29;
        this.f125440s = str8;
        this.f125441t = i36;
        this.f125442u = str9;
        this.f125443v = str10;
        this.f125444w = str11;
    }

    public final void a(int i3) {
        this.f125427f = i3;
    }

    public final void b(String str) {
        this.f125437p = str;
    }

    public final void c(String str) {
        this.f125430i = str;
    }

    public final void d(String str) {
        this.f125444w = str;
    }

    public final void e(int i3) {
        this.f125436o = i3;
    }

    public final void f(String str) {
        this.f125443v = str;
    }

    public final void g(String str) {
        this.f125442u = str;
    }

    public final void h(int i3) {
        this.f125432k = i3;
    }

    public final void i(String str) {
        this.f125428g = str;
    }

    public final void j(String str) {
        this.f125440s = str;
    }

    public final void a(long j3) {
        this.f125435n = j3;
    }

    public final void b(int i3) {
        this.f125441t = i3;
    }

    @Override // com.tencent.luggage.wxa.r6.a
    public String d() {
        String join = StringUtils.join(new String[]{String.valueOf(this.f125423b), this.f125424c, this.f125425d, String.valueOf(this.f125426e), String.valueOf(this.f125427f), this.f125428g, this.f125429h, this.f125430i, this.f125431j, String.valueOf(this.f125432k), String.valueOf(this.f125433l), String.valueOf(this.f125434m), String.valueOf(this.f125435n), String.valueOf(this.f125436o), this.f125437p, String.valueOf(this.f125438q), String.valueOf(this.f125439r), String.valueOf(this.f125440s), String.valueOf(this.f125441t), this.f125442u, this.f125443v, this.f125444w}, ",");
        Intrinsics.checkNotNullExpressionValue(join, "join(arrayOf(\n          \u2026nstanceId\n        ), \",\")");
        return join;
    }
}
