package com.tencent.beacon.base.net.call;

import java.util.Date;

/* compiled from: P */
/* loaded from: classes2.dex */
public class j implements a<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    private final JceRequestEntity f77775a;

    /* renamed from: b, reason: collision with root package name */
    private long f77776b;

    public j(JceRequestEntity jceRequestEntity) {
        this.f77775a = jceRequestEntity;
    }

    public void a(Callback<byte[]> callback) {
        com.tencent.beacon.a.b.a.a().a(new g(this, callback));
    }

    public void b(Callback<byte[]> callback) {
        this.f77776b = new Date().getTime();
        com.tencent.beacon.base.net.c.c().a(this.f77775a, new i(this, callback));
    }

    public void a(Callback<byte[]> callback, com.tencent.beacon.a.b.a aVar) {
        aVar.a(new h(this, callback));
    }
}
