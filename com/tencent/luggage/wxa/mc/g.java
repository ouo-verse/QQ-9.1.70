package com.tencent.luggage.wxa.mc;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g extends com.tencent.luggage.wxa.on.c {

    /* renamed from: d, reason: collision with root package name */
    public final String f134297d;

    /* renamed from: e, reason: collision with root package name */
    public final String f134298e;

    /* renamed from: f, reason: collision with root package name */
    public final String f134299f;

    public g(String reason, String url, String md5) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(md5, "md5");
        this.f134297d = reason;
        this.f134298e = url;
        this.f134299f = md5;
    }

    public final String d() {
        return this.f134299f;
    }

    public final String e() {
        return this.f134297d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (Intrinsics.areEqual(this.f134297d, gVar.f134297d) && Intrinsics.areEqual(this.f134298e, gVar.f134298e) && Intrinsics.areEqual(this.f134299f, gVar.f134299f)) {
            return true;
        }
        return false;
    }

    public final String f() {
        return this.f134298e;
    }

    public int hashCode() {
        return (((this.f134297d.hashCode() * 31) + this.f134298e.hashCode()) * 31) + this.f134299f.hashCode();
    }

    public String toString() {
        return "EventOnTestCommLibInfoHandleRequested(reason=" + this.f134297d + ", url=" + this.f134298e + ", md5=" + this.f134299f + ')';
    }
}
