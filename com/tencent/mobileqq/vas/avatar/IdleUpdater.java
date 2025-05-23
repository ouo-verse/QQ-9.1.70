package com.tencent.mobileqq.vas.avatar;

import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class IdleUpdater implements MessageQueue.IdleHandler, Runnable {

    /* renamed from: d, reason: collision with root package name */
    private int f308725d;

    public IdleUpdater(int i3) {
        this.f308725d = i3;
    }

    public abstract void e();

    public void f() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Looper.myQueue().addIdleHandler(this);
        } else {
            ThreadManager.getUIHandler().post(this);
        }
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        ThreadManagerV2.excute(this, this.f308725d, null, true);
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Looper.myQueue().addIdleHandler(this);
        } else {
            e();
        }
    }
}
