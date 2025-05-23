package com.tencent.timi.game.utils;

import com.tencent.mobileqq.app.ThreadManagerV2;

/* loaded from: classes26.dex */
class ThreadPool$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Runnable f380290d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f380291e;

    @Override // java.lang.Runnable
    public void run() {
        ThreadManagerV2.excute(this.f380290d, this.f380291e, null, true);
    }
}
