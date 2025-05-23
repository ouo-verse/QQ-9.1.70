package com.tencent.qq.minibox.api.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MiniBoxLiveAlive implements Handler.Callback {

    /* renamed from: e, reason: collision with root package name */
    private static MiniBoxLiveAlive f344506e;

    /* renamed from: d, reason: collision with root package name */
    private WeakReferenceHandler f344507d = new WeakReferenceHandler(Looper.getMainLooper(), this);

    MiniBoxLiveAlive() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (p51.c.d(BaseApplication.getContext())) {
            GuardManager guardManager = GuardManager.sInstance;
            if (guardManager != null) {
                guardManager.onEvent(0, null);
                this.f344507d.removeMessages(255);
                QLog.i("MiniBoxLiveAlive", 1, "checkPostNextMessage onEvent");
            }
            this.f344507d.sendEmptyMessageDelayed(255, 30000L);
            QLog.i("MiniBoxLiveAlive", 1, "checkPostNextMessage post next keep alive msg");
            return;
        }
        QLog.i("MiniBoxLiveAlive", 1, "checkPostNextMessage minibox app process die, no need keep alive");
    }

    public static synchronized MiniBoxLiveAlive c() {
        MiniBoxLiveAlive miniBoxLiveAlive;
        synchronized (MiniBoxLiveAlive.class) {
            if (f344506e == null) {
                f344506e = new MiniBoxLiveAlive();
            }
            miniBoxLiveAlive = f344506e;
        }
        return miniBoxLiveAlive;
    }

    public void d() {
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.onEvent(0, null);
            QLog.i("MiniBoxLiveAlive", 1, "startKeepAlive onEvent");
        }
        this.f344507d.removeMessages(255);
        this.f344507d.sendEmptyMessageDelayed(255, 30000L);
        QLog.i("MiniBoxLiveAlive", 1, "startKeepAlive post next msg");
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        if (message.what == 255) {
            QLog.i("MiniBoxLiveAlive", 1, "handleMessage MSG_CODE_KEEP_ALIVE");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qq.minibox.api.impl.MiniBoxLiveAlive.1
                @Override // java.lang.Runnable
                public void run() {
                    MiniBoxLiveAlive.this.b();
                }
            }, 16, null, false);
        }
        return false;
    }
}
