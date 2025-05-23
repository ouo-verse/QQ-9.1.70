package com.tencent.qimei.av;

import android.os.MessageQueue;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d implements MessageQueue.IdleHandler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f343153a;

    public d(f fVar) {
        this.f343153a = fVar;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        f.a(this.f343153a);
        return false;
    }
}
