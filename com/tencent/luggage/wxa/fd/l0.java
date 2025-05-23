package com.tencent.luggage.wxa.fd;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l0 extends com.tencent.luggage.wxa.on.c {

    /* renamed from: d, reason: collision with root package name */
    public final String f125842d;

    /* renamed from: e, reason: collision with root package name */
    public final int f125843e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f125844f;

    public l0(String event, int i3, Object obj) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f125842d = event;
        this.f125843e = i3;
        this.f125844f = obj;
    }

    public final String d() {
        return this.f125842d;
    }

    public final Object e() {
        return this.f125844f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l0)) {
            return false;
        }
        l0 l0Var = (l0) obj;
        if (Intrinsics.areEqual(this.f125842d, l0Var.f125842d) && this.f125843e == l0Var.f125843e && Intrinsics.areEqual(this.f125844f, l0Var.f125844f)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.f125842d.hashCode() * 31) + this.f125843e) * 31;
        Object obj = this.f125844f;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public String toString() {
        return "WxaAttrStorageNotifyEvent(event=" + this.f125842d + ", eventId=" + this.f125843e + ", obj=" + this.f125844f + ')';
    }
}
