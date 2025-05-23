package com.tencent.luggage.wxa.ij;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f130610a;

    /* renamed from: b, reason: collision with root package name */
    public String f130611b;

    /* renamed from: c, reason: collision with root package name */
    public String f130612c;

    /* renamed from: d, reason: collision with root package name */
    public int f130613d;

    /* renamed from: e, reason: collision with root package name */
    public final String f130614e;

    /* renamed from: f, reason: collision with root package name */
    public final String f130615f;

    /* renamed from: g, reason: collision with root package name */
    public final long f130616g;

    /* renamed from: h, reason: collision with root package name */
    public final long f130617h;

    /* renamed from: i, reason: collision with root package name */
    public String f130618i;

    public c(String type, String name, String path, int i3, String content, String talker, long j3, long j16, String groupOpenID) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(talker, "talker");
        Intrinsics.checkNotNullParameter(groupOpenID, "groupOpenID");
        this.f130610a = type;
        this.f130611b = name;
        this.f130612c = path;
        this.f130613d = i3;
        this.f130614e = content;
        this.f130615f = talker;
        this.f130616g = j3;
        this.f130617h = j16;
        this.f130618i = groupOpenID;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f130611b = str;
    }

    public final String b() {
        return this.f130611b;
    }

    public final String c() {
        return this.f130612c;
    }

    public final int d() {
        return this.f130613d;
    }

    public final String e() {
        return this.f130610a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (Intrinsics.areEqual(this.f130610a, cVar.f130610a) && Intrinsics.areEqual(this.f130611b, cVar.f130611b) && Intrinsics.areEqual(this.f130612c, cVar.f130612c) && this.f130613d == cVar.f130613d && Intrinsics.areEqual(this.f130614e, cVar.f130614e) && Intrinsics.areEqual(this.f130615f, cVar.f130615f) && this.f130616g == cVar.f130616g && this.f130617h == cVar.f130617h && Intrinsics.areEqual(this.f130618i, cVar.f130618i)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((this.f130610a.hashCode() * 31) + this.f130611b.hashCode()) * 31) + this.f130612c.hashCode()) * 31) + this.f130613d) * 31) + this.f130614e.hashCode()) * 31) + this.f130615f.hashCode()) * 31) + androidx.fragment.app.a.a(this.f130616g)) * 31) + androidx.fragment.app.a.a(this.f130617h)) * 31) + this.f130618i.hashCode();
    }

    public String toString() {
        return "AppBrandOpenMsgMaterial(type=" + this.f130610a + ", name=" + this.f130611b + ", path=" + this.f130612c + ", size=" + this.f130613d + ", content=" + this.f130614e + ", talker=" + this.f130615f + ", timeStamp=" + this.f130616g + ", messageId=" + this.f130617h + ", groupOpenID=" + this.f130618i + ')';
    }

    public final String a() {
        return this.f130614e;
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f130612c = str;
    }

    public final void a(int i3) {
        this.f130613d = i3;
    }

    public /* synthetic */ c(String str, String str2, String str3, int i3, String str4, String str5, long j3, long j16, String str6, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i16 & 2) != 0 ? "" : str2, (i16 & 4) != 0 ? "" : str3, (i16 & 8) != 0 ? 0 : i3, (i16 & 16) != 0 ? "" : str4, (i16 & 32) != 0 ? "" : str5, (i16 & 64) != 0 ? 0L : j3, (i16 & 128) == 0 ? j16 : 0L, (i16 & 256) == 0 ? str6 : "");
    }
}
