package com.tencent.beacon.base.net.call;

import com.tencent.beacon.base.net.BResponse;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c implements a<BResponse> {

    /* renamed from: a, reason: collision with root package name */
    private e f77751a;

    public c(e eVar) {
        this.f77751a = eVar;
    }

    public void a(Callback<BResponse> callback) {
        com.tencent.beacon.base.net.c.c().a(this.f77751a, new b(this, callback));
    }
}
