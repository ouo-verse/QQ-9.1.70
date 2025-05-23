package com.tencent.luggage.wxa.f7;

import com.tencent.luggage.wxa.n3.e0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang.StringUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends com.tencent.luggage.wxa.r6.a {

    /* renamed from: b, reason: collision with root package name */
    public String f125401b;

    /* renamed from: c, reason: collision with root package name */
    public String f125402c;

    /* renamed from: d, reason: collision with root package name */
    public int f125403d;

    /* renamed from: e, reason: collision with root package name */
    public String f125404e;

    /* renamed from: f, reason: collision with root package name */
    public int f125405f;

    /* renamed from: g, reason: collision with root package name */
    public String f125406g;

    /* renamed from: h, reason: collision with root package name */
    public long f125407h;

    /* renamed from: i, reason: collision with root package name */
    public int f125408i;

    public /* synthetic */ a(String str, String str2, int i3, String str3, int i16, String str4, long j3, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? null : str, (i18 & 2) != 0 ? null : str2, (i18 & 4) != 0 ? 0 : i3, (i18 & 8) != 0 ? null : str3, (i18 & 16) != 0 ? 0 : i16, (i18 & 32) == 0 ? str4 : null, (i18 & 64) != 0 ? 0L : j3, (i18 & 128) == 0 ? i17 : 0);
    }

    @Override // com.tencent.luggage.wxa.r6.a
    public int a() {
        return 10055;
    }

    public final void b(String str) {
        this.f125404e = str;
    }

    public final void c(String str) {
        this.f125401b = str;
    }

    public final void d(String str) {
        this.f125406g = str;
    }

    public final void e(String str) {
        this.f125402c = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (Intrinsics.areEqual(this.f125401b, aVar.f125401b) && Intrinsics.areEqual(this.f125402c, aVar.f125402c) && this.f125403d == aVar.f125403d && Intrinsics.areEqual(this.f125404e, aVar.f125404e) && this.f125405f == aVar.f125405f && Intrinsics.areEqual(this.f125406g, aVar.f125406g) && this.f125407h == aVar.f125407h && this.f125408i == aVar.f125408i) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        String str = this.f125401b;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.f125402c;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (((i16 + hashCode2) * 31) + this.f125403d) * 31;
        String str3 = this.f125404e;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i18 = (((i17 + hashCode3) * 31) + this.f125405f) * 31;
        String str4 = this.f125406g;
        if (str4 != null) {
            i3 = str4.hashCode();
        }
        return ((((i18 + i3) * 31) + androidx.fragment.app.a.a(this.f125407h)) * 31) + this.f125408i;
    }

    public String toString() {
        return "KVReport_CALL_API_10055(hostAppId=" + this.f125401b + ", wxaAppId=" + this.f125402c + ", appState=" + this.f125403d + ", apiName=" + this.f125404e + ", isSuccess=" + this.f125405f + ", pkgName=" + this.f125406g + ", iLinkUIN=" + this.f125407h + ", sdkVersion=" + this.f125408i + ')';
    }

    public a(String str, String str2, int i3, String str3, int i16, String str4, long j3, int i17) {
        this.f125401b = str;
        this.f125402c = str2;
        this.f125403d = i3;
        this.f125404e = str3;
        this.f125405f = i16;
        this.f125406g = str4;
        this.f125407h = j3;
        this.f125408i = i17;
    }

    public final void a(int i3) {
        this.f125403d = i3;
    }

    public final void b(int i3) {
        this.f125408i = i3;
    }

    public final void c(int i3) {
        this.f125405f = i3;
    }

    @Override // com.tencent.luggage.wxa.r6.a
    public String d() {
        String join = StringUtils.join(new String[]{this.f125401b, this.f125402c, String.valueOf(this.f125403d), this.f125404e, String.valueOf(this.f125405f), this.f125406g, e0.f135163b.b(this.f125407h), String.valueOf(this.f125408i)}, ",");
        Intrinsics.checkNotNullExpressionValue(join, "join(arrayOf(\n          \u2026oString()\n        ), \",\")");
        return join;
    }

    public final void a(long j3) {
        this.f125407h = j3;
    }
}
