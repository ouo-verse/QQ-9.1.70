package com.tencent.luggage.wxa.lj;

import com.tencent.luggage.wxa.lj.k;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f133534a;

    /* renamed from: b, reason: collision with root package name */
    public final long f133535b;

    /* renamed from: c, reason: collision with root package name */
    public final String f133536c;

    /* renamed from: d, reason: collision with root package name */
    public final String f133537d;

    /* renamed from: e, reason: collision with root package name */
    public final int f133538e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f133539f;

    /* renamed from: g, reason: collision with root package name */
    public final Function0 f133540g;

    /* renamed from: h, reason: collision with root package name */
    public final Function0 f133541h;

    /* renamed from: i, reason: collision with root package name */
    public final Function0 f133542i;

    public m(CharSequence wording, long j3, String iconUrl, String darkModeIconUrl, int i3, boolean z16, Function0 function0, Function0 function02, Function0 function03) {
        Intrinsics.checkNotNullParameter(wording, "wording");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(darkModeIconUrl, "darkModeIconUrl");
        this.f133534a = wording;
        this.f133535b = j3;
        this.f133536c = iconUrl;
        this.f133537d = darkModeIconUrl;
        this.f133538e = i3;
        this.f133539f = z16;
        this.f133540g = function0;
        this.f133541h = function02;
        this.f133542i = function03;
    }

    public final boolean a() {
        return this.f133539f;
    }

    public final Function0 b() {
        return this.f133542i;
    }

    public final Function0 c() {
        return this.f133541h;
    }

    public final Function0 d() {
        return this.f133540g;
    }

    public final long e() {
        return this.f133535b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (Intrinsics.areEqual(this.f133534a, mVar.f133534a) && this.f133535b == mVar.f133535b && Intrinsics.areEqual(this.f133536c, mVar.f133536c) && Intrinsics.areEqual(this.f133537d, mVar.f133537d) && this.f133538e == mVar.f133538e && this.f133539f == mVar.f133539f && Intrinsics.areEqual(this.f133540g, mVar.f133540g) && Intrinsics.areEqual(this.f133541h, mVar.f133541h) && Intrinsics.areEqual(this.f133542i, mVar.f133542i)) {
            return true;
        }
        return false;
    }

    public final int f() {
        return this.f133538e;
    }

    public final CharSequence g() {
        return this.f133534a;
    }

    public final boolean h() {
        boolean z16;
        if (!com.tencent.luggage.wxa.h6.d.a(this.f133536c)) {
            return false;
        }
        if (this.f133536c.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = ((((((((this.f133534a.hashCode() * 31) + androidx.fragment.app.a.a(this.f133535b)) * 31) + this.f133536c.hashCode()) * 31) + this.f133537d.hashCode()) * 31) + this.f133538e) * 31;
        boolean z16 = this.f133539f;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode3 + i3) * 31;
        Function0 function0 = this.f133540g;
        int i17 = 0;
        if (function0 == null) {
            hashCode = 0;
        } else {
            hashCode = function0.hashCode();
        }
        int i18 = (i16 + hashCode) * 31;
        Function0 function02 = this.f133541h;
        if (function02 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = function02.hashCode();
        }
        int i19 = (i18 + hashCode2) * 31;
        Function0 function03 = this.f133542i;
        if (function03 != null) {
            i17 = function03.hashCode();
        }
        return i19 + i17;
    }

    public String toString() {
        return "CapsuleTipsConfig(wording=" + ((Object) this.f133534a) + ", showDuration=" + this.f133535b + ", iconUrl=" + this.f133536c + ", darkModeIconUrl=" + this.f133537d + ", type=" + this.f133538e + ", enableClickable=" + this.f133539f + ", onClick=" + this.f133540g + ", onAnimationStart=" + this.f133541h + ", onAnimationEnd=" + this.f133542i + ')';
    }

    public /* synthetic */ m(CharSequence charSequence, long j3, String str, String str2, int i3, boolean z16, Function0 function0, Function0 function02, Function0 function03, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, (i16 & 2) != 0 ? 7000L : j3, (i16 & 4) != 0 ? "" : str, (i16 & 8) == 0 ? str2 : "", (i16 & 16) != 0 ? k.b.NONE.b() : i3, (i16 & 32) != 0 ? false : z16, (i16 & 64) != 0 ? null : function0, (i16 & 128) != 0 ? null : function02, (i16 & 256) == 0 ? function03 : null);
    }
}
