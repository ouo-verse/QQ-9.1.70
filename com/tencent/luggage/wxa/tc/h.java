package com.tencent.luggage.wxa.tc;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h extends com.tencent.luggage.wxa.on.c {

    /* renamed from: d, reason: collision with root package name */
    public final String f141235d;

    /* renamed from: e, reason: collision with root package name */
    public final c f141236e;

    public h(String wxaLaunchInstanceId, c data) {
        Intrinsics.checkNotNullParameter(wxaLaunchInstanceId, "wxaLaunchInstanceId");
        Intrinsics.checkNotNullParameter(data, "data");
        this.f141235d = wxaLaunchInstanceId;
        this.f141236e = data;
    }

    public final c d() {
        return this.f141236e;
    }

    public final String e() {
        return this.f141235d;
    }
}
