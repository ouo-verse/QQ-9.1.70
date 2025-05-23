package com.tencent.liteav.base.util;

import android.os.MessageQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final /* synthetic */ class c implements MessageQueue.IdleHandler {

    /* renamed from: a, reason: collision with root package name */
    private final CustomHandler f119015a;

    c(CustomHandler customHandler) {
        this.f119015a = customHandler;
    }

    public static MessageQueue.IdleHandler a(CustomHandler customHandler) {
        return new c(customHandler);
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        return CustomHandler.lambda$quitLooper$2(this.f119015a);
    }
}
