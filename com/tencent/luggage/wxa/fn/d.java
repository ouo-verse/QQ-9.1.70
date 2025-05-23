package com.tencent.luggage.wxa.fn;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public Object f126265a;

    public d(e attr, Object obj) {
        Intrinsics.checkNotNullParameter(attr, "attr");
        this.f126265a = obj;
    }

    public final e a() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        dVar.getClass();
        if (Intrinsics.areEqual((Object) null, (Object) null) && Intrinsics.areEqual(this.f126265a, dVar.f126265a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        throw null;
    }

    public String toString() {
        Object obj = this.f126265a;
        obj.getClass();
        return ((Object) null) + " => " + obj;
    }

    public /* synthetic */ d(e eVar, Object obj, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(eVar, (i3 & 2) != 0 ? null : obj);
    }
}
