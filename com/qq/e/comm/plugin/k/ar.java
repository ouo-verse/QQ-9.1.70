package com.qq.e.comm.plugin.k;

import com.qq.e.comm.managers.thread.GdtSDKThreadManager;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ar implements lt.a {
    @Override // lt.a
    public void a(Runnable runnable) {
        GdtSDKThreadManager.getInstance().runOnThread(2, runnable);
    }

    @Override // lt.a
    public void b(Runnable runnable) {
        GdtSDKThreadManager.getInstance().runOnThread(1, runnable);
    }

    @Override // lt.a
    public void c(Runnable runnable) {
        aa.a(runnable);
    }

    @Override // lt.a
    public void d(Runnable runnable) {
        GdtSDKThreadManager.getInstance().runOnThread(2, runnable);
    }

    @Override // lt.a
    public void a(Runnable runnable, long j3) {
        GdtSDKThreadManager.getInstance().runOnThread(3, runnable, j3);
    }
}
