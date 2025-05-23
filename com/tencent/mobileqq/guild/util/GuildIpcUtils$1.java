package com.tencent.mobileqq.guild.util;

import eipc.EIPCResult;
import java.util.concurrent.CountDownLatch;

/* compiled from: P */
/* loaded from: classes14.dex */
class GuildIpcUtils$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ EIPCResult[] f235343d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f235344e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Object[] f235345f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ CountDownLatch f235346h;

    @Override // java.lang.Runnable
    public void run() {
        this.f235343d[0] = y.h(this.f235344e, this.f235345f);
        this.f235346h.countDown();
    }
}
