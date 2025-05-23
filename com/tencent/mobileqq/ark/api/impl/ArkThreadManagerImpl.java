package com.tencent.mobileqq.ark.api.impl;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkThreadManagerImpl implements IArkThreadManager {
    static final String TAG = "ArkApp.ArkThreadManager";

    @Override // com.tencent.mobileqq.ark.api.IArkThreadManager
    public void postToAppThread(String str, Runnable runnable) {
        com.tencent.mobileqq.ark.base.b.c().post(str, runnable);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkThreadManager
    public void postToAppThreadDelay(String str, Runnable runnable, int i3) {
        com.tencent.mobileqq.ark.base.b.c().postDelayed(str, runnable, i3);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkThreadManager
    public void postToLogicThread(Runnable runnable) {
        com.tencent.mobileqq.ark.base.b.b(runnable);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkThreadManager
    public void postToLogicThreadDelay(Runnable runnable, int i3) {
        com.tencent.mobileqq.ark.base.b.a(runnable, i3);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkThreadManager
    public void postToMainThread(Runnable runnable) {
        com.tencent.mobileqq.ark.base.b.c().postToMainThread(runnable);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkThreadManager
    public void postToMainThreadDelay(Runnable runnable, int i3) {
        com.tencent.mobileqq.ark.base.b.c().postToMainThreadDelayed(runnable, i3);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkThreadManager
    public void sendToAppThread(String str, Runnable runnable) {
        com.tencent.mobileqq.ark.base.b.c().send(str, runnable);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkThreadManager
    public void sendToMainThread(final Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
            return;
        }
        final Object obj = new Object();
        synchronized (obj) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ark.api.impl.ArkThreadManagerImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                    synchronized (obj) {
                        obj.notify();
                    }
                }
            });
            try {
                LockMethodProxy.wait(obj);
            } catch (InterruptedException e16) {
                QLog.i(TAG, 1, "sendToMainThread, " + e16.toString());
            }
        }
    }
}
