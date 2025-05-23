package com.tencent.aelight.camera.ae.control;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class AEQIMAsyncManager extends b {
    private static final String TAG = "QIMAsyncManager";
    private volatile boolean inited = false;

    public synchronized void forceInit() {
        if (this.inited) {
            return;
        }
        initIndeed();
        this.inited = true;
    }

    protected abstract void initIndeed();

    @Override // com.tencent.aelight.camera.ae.control.b
    public synchronized void onInit() {
        if (this.inited) {
            return;
        }
        boolean z16 = Looper.myLooper() == Looper.getMainLooper();
        if (com.tencent.aelight.camera.aioeditor.capture.control.a.b(z16)) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.aelight.camera.ae.control.AEQIMAsyncManager.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (AEQIMAsyncManager.this) {
                    if (AEQIMAsyncManager.this.inited) {
                        return;
                    }
                    AEQIMAsyncManager.this.initIndeed();
                    AEQIMAsyncManager.this.inited = true;
                }
            }
        };
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "onInit, async:", Boolean.valueOf(z16));
        }
        if (z16) {
            ThreadManagerV2.excute(runnable, 64, null, false);
        } else {
            runnable.run();
        }
    }

    @Override // com.tencent.aelight.camera.ae.control.b
    public void onDestroy() {
    }
}
