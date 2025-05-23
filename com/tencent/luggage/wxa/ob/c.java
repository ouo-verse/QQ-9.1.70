package com.tencent.luggage.wxa.ob;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f136272a;

    /* renamed from: b, reason: collision with root package name */
    public final String f136273b;

    /* renamed from: c, reason: collision with root package name */
    public final String f136274c;

    /* renamed from: d, reason: collision with root package name */
    public final int f136275d;

    public c(String mimeType, String imagePath, String materialName, int i3) {
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        Intrinsics.checkNotNullParameter(materialName, "materialName");
        this.f136272a = mimeType;
        this.f136273b = imagePath;
        this.f136274c = materialName;
        this.f136275d = i3;
    }

    public final String a() {
        return this.f136273b;
    }

    public final String b() {
        return this.f136274c;
    }

    public final int c() {
        return this.f136275d;
    }

    public final String d() {
        return this.f136272a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (Intrinsics.areEqual(this.f136272a, cVar.f136272a) && Intrinsics.areEqual(this.f136273b, cVar.f136273b) && Intrinsics.areEqual(this.f136274c, cVar.f136274c) && this.f136275d == cVar.f136275d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f136272a.hashCode() * 31) + this.f136273b.hashCode()) * 31) + this.f136274c.hashCode()) * 31) + this.f136275d;
    }

    public String toString() {
        return "PersonalCreatorExtraData(mimeType=" + this.f136272a + ", imagePath=" + this.f136273b + ", materialName=" + this.f136274c + ", materialSize=" + this.f136275d + ')';
    }
}
