package com.tencent.av.opengl.effects;

import android.os.SystemClock;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AEFilterSupport {

    /* renamed from: a, reason: collision with root package name */
    private static tw.b f73900a;

    /* renamed from: b, reason: collision with root package name */
    private static long f73901b;

    /* renamed from: c, reason: collision with root package name */
    private static Runnable f73902c;

    /* renamed from: d, reason: collision with root package name */
    private static final Object f73903d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private static int f73904e;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static final class CheckAEFilterTask implements Runnable {
        CheckAEFilterTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (QLog.isColorLevel()) {
                QLog.i("AEFilterSupport", 2, "CheckAEFilterTask before[" + AEFilterSupport.f73904e + "]");
            }
            if (AEFilterSupport.f73904e != 1) {
                AEFilterSupport.d();
            }
            AEFilterSupport.f73902c = null;
            if (QLog.isColorLevel()) {
                QLog.i("AEFilterSupport", 2, "CheckAEFilterTask after[" + AEFilterSupport.f73904e + "]");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d() {
        long j3;
        int i3;
        if (!j.D()) {
            if (QLog.isColorLevel()) {
                QLog.i("AEFilterSupport", 2, "checkAndLoadAEKitSo, not support AEKit.");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            j3 = SystemClock.elapsedRealtime();
        } else {
            j3 = 0;
        }
        boolean isAEBaseSoReady = ((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEBaseSoReady();
        if (!isAEBaseSoReady) {
            isAEBaseSoReady = gm2.b.b();
        }
        if (isAEBaseSoReady) {
            i3 = 1;
        } else {
            i3 = -1;
        }
        if (f73904e != 1) {
            synchronized (f73903d) {
                if (f73904e != 1) {
                    f73904e = i3;
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("AEFilterSupport", 2, "checkAndLoadAEKitSo ret[" + isAEBaseSoReady + "], cost[" + (SystemClock.elapsedRealtime() - j3) + "], flag[" + f73904e + "]");
        }
    }

    public static int e() {
        if (f73900a == null) {
            f73900a = new tw.b(com.tencent.av.utils.af.c("machineMiddleLine"), com.tencent.av.utils.af.c("machineHighLine"));
        }
        return f73900a.a();
    }

    public static boolean f(int i3) {
        if (!j.D()) {
            if (QLog.isColorLevel()) {
                QLog.i("AEFilterSupport", 2, "isAEKitSoReady, not support AEKit.");
            }
            return false;
        }
        if (f73904e != 1) {
            if (((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEBaseSoReady()) {
                f73904e = 1;
                return true;
            }
            if (i3 == 1) {
                f73901b = SystemClock.elapsedRealtime();
                d();
            } else if (i3 == 2 && f73902c == null && Math.abs(SystemClock.elapsedRealtime() - f73901b) > 30000) {
                f73901b = SystemClock.elapsedRealtime();
                CheckAEFilterTask checkAEFilterTask = new CheckAEFilterTask();
                f73902c = checkAEFilterTask;
                ThreadManagerV2.excute(checkAEFilterTask, 16, null, false);
            }
        }
        if (f73904e != 1) {
            return false;
        }
        return true;
    }
}
