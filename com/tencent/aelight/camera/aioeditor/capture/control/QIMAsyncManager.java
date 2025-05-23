package com.tencent.aelight.camera.aioeditor.capture.control;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import fr.e;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class QIMAsyncManager extends e {

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f66676d = false;

    @Override // fr.e
    public synchronized void e() {
        if (this.f66676d) {
            return;
        }
        boolean z16 = Looper.myLooper() == Looper.getMainLooper();
        if (a.b(z16)) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.capture.control.QIMAsyncManager.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (QIMAsyncManager.this) {
                    if (QIMAsyncManager.this.f66676d) {
                        return;
                    }
                    QIMAsyncManager.this.i();
                    QIMAsyncManager.this.f66676d = true;
                }
            }
        };
        if (QLog.isDevelopLevel()) {
            QLog.d("QIMAsyncManager", 4, "onInit, async:", Boolean.valueOf(z16));
        }
        if (z16) {
            ThreadManagerV2.excute(runnable, 64, null, false);
        } else {
            runnable.run();
        }
    }

    public synchronized void h() {
        if (this.f66676d) {
            return;
        }
        i();
        this.f66676d = true;
    }

    protected abstract void i();
}
