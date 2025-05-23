package com.tencent.luggage.wxa.tj;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ic.d f141482a;

    /* renamed from: b, reason: collision with root package name */
    public final String f141483b;

    /* renamed from: c, reason: collision with root package name */
    public final String f141484c;

    /* renamed from: d, reason: collision with root package name */
    public final String f141485d;

    /* renamed from: e, reason: collision with root package name */
    public final int f141486e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(com.tencent.luggage.wxa.ic.d env, String api) {
        this(env, api, null, null, 0, 28, null);
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(api, "api");
    }

    public final String a() {
        return this.f141483b;
    }

    public final String b() {
        return this.f141484c;
    }

    public final int c() {
        return this.f141486e;
    }

    public final com.tencent.luggage.wxa.ic.d d() {
        return this.f141482a;
    }

    public final String e() {
        return this.f141485d;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("JsAuthExecuteContext(appId='");
        sb5.append(this.f141482a.getAppId());
        sb5.append("', api='");
        sb5.append(this.f141483b);
        sb5.append("', privateArgs='");
        String str = this.f141485d;
        if (str == null) {
            str = "";
        }
        sb5.append(str);
        sb5.append("', callbackId=");
        sb5.append(this.f141486e);
        sb5.append(')');
        return sb5.toString();
    }

    public e(com.tencent.luggage.wxa.ic.d env, String api, String str, String str2, int i3) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(api, "api");
        this.f141482a = env;
        this.f141483b = api;
        this.f141484c = str;
        this.f141485d = str2;
        this.f141486e = i3;
    }

    public /* synthetic */ e(com.tencent.luggage.wxa.ic.d dVar, String str, String str2, String str3, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(dVar, str, (i16 & 4) != 0 ? null : str2, (i16 & 8) != 0 ? null : str3, (i16 & 16) != 0 ? 0 : i3);
    }
}
