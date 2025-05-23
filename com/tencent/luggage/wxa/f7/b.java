package com.tencent.luggage.wxa.f7;

import com.tencent.luggage.wxa.n3.e0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang.StringUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends com.tencent.luggage.wxa.r6.a {

    /* renamed from: b, reason: collision with root package name */
    public String f125409b;

    /* renamed from: c, reason: collision with root package name */
    public String f125410c;

    /* renamed from: d, reason: collision with root package name */
    public String f125411d;

    /* renamed from: e, reason: collision with root package name */
    public int f125412e;

    /* renamed from: f, reason: collision with root package name */
    public String f125413f;

    /* renamed from: g, reason: collision with root package name */
    public int f125414g;

    /* renamed from: h, reason: collision with root package name */
    public int f125415h;

    /* renamed from: i, reason: collision with root package name */
    public String f125416i;

    /* renamed from: j, reason: collision with root package name */
    public int f125417j;

    /* renamed from: k, reason: collision with root package name */
    public int f125418k;

    /* renamed from: l, reason: collision with root package name */
    public int f125419l;

    /* renamed from: m, reason: collision with root package name */
    public String f125420m;

    /* renamed from: n, reason: collision with root package name */
    public long f125421n;

    /* renamed from: o, reason: collision with root package name */
    public int f125422o;

    public /* synthetic */ b(String str, String str2, String str3, int i3, String str4, int i16, int i17, String str5, int i18, int i19, int i26, String str6, long j3, int i27, int i28, DefaultConstructorMarker defaultConstructorMarker) {
        this((i28 & 1) != 0 ? null : str, (i28 & 2) != 0 ? null : str2, (i28 & 4) != 0 ? null : str3, (i28 & 8) != 0 ? 0 : i3, (i28 & 16) != 0 ? null : str4, (i28 & 32) != 0 ? 1 : i16, (i28 & 64) != 0 ? 0 : i17, (i28 & 128) != 0 ? null : str5, (i28 & 256) != 0 ? 0 : i18, (i28 & 512) != 0 ? 0 : i19, (i28 & 1024) != 0 ? 0 : i26, (i28 & 2048) == 0 ? str6 : null, (i28 & 4096) != 0 ? 0L : j3, (i28 & 8192) == 0 ? i27 : 0);
    }

    @Override // com.tencent.luggage.wxa.r6.a
    public int a() {
        return 10053;
    }

    public final void b(int i3) {
        this.f125415h = i3;
    }

    public final void c(String str) {
        this.f125416i = str;
    }

    public final void d(String str) {
        this.f125409b = str;
    }

    public final void e(String str) {
        this.f125411d = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (Intrinsics.areEqual(this.f125409b, bVar.f125409b) && Intrinsics.areEqual(this.f125410c, bVar.f125410c) && Intrinsics.areEqual(this.f125411d, bVar.f125411d) && this.f125412e == bVar.f125412e && Intrinsics.areEqual(this.f125413f, bVar.f125413f) && this.f125414g == bVar.f125414g && this.f125415h == bVar.f125415h && Intrinsics.areEqual(this.f125416i, bVar.f125416i) && this.f125417j == bVar.f125417j && this.f125418k == bVar.f125418k && this.f125419l == bVar.f125419l && Intrinsics.areEqual(this.f125420m, bVar.f125420m) && this.f125421n == bVar.f125421n && this.f125422o == bVar.f125422o) {
            return true;
        }
        return false;
    }

    public final void f(int i3) {
        this.f125412e = i3;
    }

    public final void g(String str) {
        this.f125410c = str;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        String str = this.f125409b;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.f125410c;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.f125411d;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i18 = (((i17 + hashCode3) * 31) + this.f125412e) * 31;
        String str4 = this.f125413f;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int i19 = (((((i18 + hashCode4) * 31) + this.f125414g) * 31) + this.f125415h) * 31;
        String str5 = this.f125416i;
        if (str5 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str5.hashCode();
        }
        int i26 = (((((((i19 + hashCode5) * 31) + this.f125417j) * 31) + this.f125418k) * 31) + this.f125419l) * 31;
        String str6 = this.f125420m;
        if (str6 != null) {
            i3 = str6.hashCode();
        }
        return ((((i26 + i3) * 31) + androidx.fragment.app.a.a(this.f125421n)) * 31) + this.f125422o;
    }

    public String toString() {
        return "KVReport_CALL_JSAPI_10053(hostAppId=" + this.f125409b + ", wxaAppId=" + this.f125410c + ", pagePath=" + this.f125411d + ", scene=" + this.f125412e + ", sceneNote=" + this.f125413f + ", appState=" + this.f125414g + ", appVersion=" + this.f125415h + ", functionName=" + this.f125416i + ", result=" + this.f125417j + ", permissionValue=" + this.f125418k + ", errorCode=" + this.f125419l + ", errMsg=" + this.f125420m + ", iLinkUIN=" + this.f125421n + ", sdkVersion=" + this.f125422o + ')';
    }

    public b(String str, String str2, String str3, int i3, String str4, int i16, int i17, String str5, int i18, int i19, int i26, String str6, long j3, int i27) {
        this.f125409b = str;
        this.f125410c = str2;
        this.f125411d = str3;
        this.f125412e = i3;
        this.f125413f = str4;
        this.f125414g = i16;
        this.f125415h = i17;
        this.f125416i = str5;
        this.f125417j = i18;
        this.f125418k = i19;
        this.f125419l = i26;
        this.f125420m = str6;
        this.f125421n = j3;
        this.f125422o = i27;
    }

    public final void a(int i3) {
        this.f125414g = i3;
    }

    public final void b(String str) {
        this.f125420m = str;
    }

    public final void c(int i3) {
        this.f125419l = i3;
    }

    public final void d(int i3) {
        this.f125418k = i3;
    }

    public final void e(int i3) {
        this.f125417j = i3;
    }

    public final void f(String str) {
        this.f125413f = str;
    }

    public final void g(int i3) {
        this.f125422o = i3;
    }

    public final void a(long j3) {
        this.f125421n = j3;
    }

    @Override // com.tencent.luggage.wxa.r6.a
    public String d() {
        String join = StringUtils.join(new String[]{this.f125409b, this.f125410c, this.f125411d, String.valueOf(this.f125412e), this.f125413f, String.valueOf(this.f125414g), String.valueOf(this.f125415h), this.f125416i, String.valueOf(this.f125417j), String.valueOf(this.f125418k), String.valueOf(this.f125419l), this.f125420m, e0.f135163b.b(this.f125421n), String.valueOf(this.f125422o)}, ",");
        Intrinsics.checkNotNullExpressionValue(join, "join(arrayOf(\n          \u2026oString()\n        ), \",\")");
        return join;
    }
}
