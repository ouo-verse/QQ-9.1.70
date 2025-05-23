package com.tencent.biz.qqcircle.richframework.recycler;

import android.os.Looper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.immersive.manager.d;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.concurrent.atomic.AtomicBoolean;
import uq3.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleMemoryManager {

    /* renamed from: a, reason: collision with root package name */
    private static RestoreMainTask f91989a;

    /* renamed from: b, reason: collision with root package name */
    private static ClearMemoryTask f91990b;

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f91991c = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class ClearMemoryTask implements Runnable {
        ClearMemoryTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QCircleMemoryManager.f();
            QCircleMemoryManager.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class RestoreMainTask implements Runnable {
        RestoreMainTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QCircleMemoryManager.o();
        }
    }

    public static void e() {
        if (!i()) {
            return;
        }
        AtomicBoolean atomicBoolean = f91991c;
        if (atomicBoolean.get()) {
            m("[clearMemory] current is clear memory flag, end clear flow.");
            return;
        }
        atomicBoolean.set(true);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            f();
            g();
        } else {
            f91990b = new ClearMemoryTask();
            RFWThreadManager.getUIHandler().post(f91990b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f() {
        if (!j()) {
            return;
        }
        QCircleFeedPicLoader.g().handlerMemoryClear();
        d.c().f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g() {
        if (!k()) {
            return;
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.recycler.a
            @Override // java.lang.Runnable
            public final void run() {
                QCircleMemoryManager.l();
            }
        });
    }

    public static void h() {
        if (!i()) {
            return;
        }
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            o();
        } else {
            f91989a = new RestoreMainTask();
            RFWThreadManager.getUIHandler().post(f91989a);
        }
    }

    private static boolean i() {
        if (c.X0("qqcircle", "qqcircle_enabled_memory_clear", 1).intValue() == 1) {
            return true;
        }
        return false;
    }

    private static boolean j() {
        if (c.X0("qqcircle", "qqcircle_enabled_memory_receiver", 1).intValue() == 1) {
            return true;
        }
        return false;
    }

    private static boolean k() {
        if (c.X0("qqcircle", "qqcircle_enabled_memory_video_clear", 1).intValue() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l() {
        QQVideoPlaySDKManager.clearMemory(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO());
    }

    private static void m(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("QCircleMemoryManager", 2, str);
        }
    }

    public static void n() {
        QCircleFeedPicLoader.g().release();
        d.c().l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o() {
        if (!j()) {
            return;
        }
        QCircleFeedPicLoader.g().handlerMemoryRestore();
        d.c().g();
    }

    public static void p() {
        if (!i()) {
            return;
        }
        AtomicBoolean atomicBoolean = f91991c;
        if (!atomicBoolean.get()) {
            m("[restoreSourceLoadMemory] current not is clear memory flag, end restore flow.");
            return;
        }
        atomicBoolean.set(false);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            o();
        } else {
            f91989a = new RestoreMainTask();
            RFWThreadManager.getUIHandler().post(f91989a);
        }
    }
}
