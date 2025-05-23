package com.tencent.luggage.wxa.xd;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class f1 {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ei.p f144788a;

    /* renamed from: b, reason: collision with root package name */
    public final d f144789b;

    /* renamed from: c, reason: collision with root package name */
    public final JSONObject f144790c;

    /* renamed from: d, reason: collision with root package name */
    public final JSONObject f144791d;

    /* renamed from: e, reason: collision with root package name */
    public final int f144792e;

    public f1(com.tencent.luggage.wxa.ei.p pVar, d invokeEnv, JSONObject data, JSONObject jSONObject, int i3) {
        Intrinsics.checkNotNullParameter(invokeEnv, "invokeEnv");
        Intrinsics.checkNotNullParameter(data, "data");
        this.f144788a = pVar;
        this.f144789b = invokeEnv;
        this.f144790c = data;
        this.f144791d = jSONObject;
        this.f144792e = i3;
    }

    public final d a() {
        return this.f144789b;
    }

    public final JSONObject b() {
        return this.f144790c;
    }

    public final int c() {
        return this.f144792e;
    }

    public final int d() {
        return this.f144792e;
    }

    public final JSONObject e() {
        return this.f144790c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f1)) {
            return false;
        }
        f1 f1Var = (f1) obj;
        if (Intrinsics.areEqual(this.f144788a, f1Var.f144788a) && Intrinsics.areEqual(this.f144789b, f1Var.f144789b) && Intrinsics.areEqual(this.f144790c, f1Var.f144790c) && Intrinsics.areEqual(this.f144791d, f1Var.f144791d) && this.f144792e == f1Var.f144792e) {
            return true;
        }
        return false;
    }

    public final d f() {
        return this.f144789b;
    }

    public final JSONObject g() {
        return this.f144791d;
    }

    public int hashCode() {
        int hashCode;
        com.tencent.luggage.wxa.ei.p pVar = this.f144788a;
        int i3 = 0;
        if (pVar == null) {
            hashCode = 0;
        } else {
            hashCode = pVar.hashCode();
        }
        int hashCode2 = ((((hashCode * 31) + this.f144789b.hashCode()) * 31) + this.f144790c.hashCode()) * 31;
        JSONObject jSONObject = this.f144791d;
        if (jSONObject != null) {
            i3 = jSONObject.hashCode();
        }
        return ((hashCode2 + i3) * 31) + this.f144792e;
    }

    public String toString() {
        return "JsInvokeContext(jsRuntime=" + this.f144788a + ", invokeEnv=" + this.f144789b + ", data=" + this.f144790c + ", privateData=" + this.f144791d + ", callbackId=" + this.f144792e + ')';
    }
}
