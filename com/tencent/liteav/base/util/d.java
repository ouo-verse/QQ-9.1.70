package com.tencent.liteav.base.util;

import android.os.MessageQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final CustomHandler f119016a;

    /* renamed from: b, reason: collision with root package name */
    private final MessageQueue.IdleHandler f119017b;

    d(CustomHandler customHandler, MessageQueue.IdleHandler idleHandler) {
        this.f119016a = customHandler;
        this.f119017b = idleHandler;
    }

    public static Runnable a(CustomHandler customHandler, MessageQueue.IdleHandler idleHandler) {
        return new d(customHandler, idleHandler);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CustomHandler.lambda$quitLooper$3(this.f119016a, this.f119017b);
    }
}
