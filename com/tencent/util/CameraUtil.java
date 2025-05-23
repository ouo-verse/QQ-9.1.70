package com.tencent.util;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.os.Looper;
import com.tencent.mobileqq.config.aq;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.CameraMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CameraUtil {
    static IPatchRedirector $redirector_ = null;
    private static final int DEFAULT_MAX_RETRY_TIMES = 2;
    private static final String TAG = "CameraUtil";

    public CameraUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Camera openCameraWithRetry() {
        return openCameraWithRetry(-1, 2);
    }

    public static Camera openCameraWithRetry(int i3) {
        return openCameraWithRetry(i3, 2);
    }

    @TargetApi(9)
    public static Camera openCameraWithRetry(int i3, int i16) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            if (aq.f202317e) {
                throw new Error("Do not open camera on ui thread.");
            }
            i16 = 1;
        }
        Camera camera2 = null;
        int i17 = 0;
        while (i17 < i16) {
            try {
                QLog.d(TAG, 1, "openCameraWithRetry, try to open camera.  retry times = " + i17);
                if (i3 != -1) {
                    camera2 = CameraMonitor.open(i3);
                } else {
                    camera2 = CameraMonitor.open();
                }
                if (!QLog.isColorLevel()) {
                    break;
                }
                QLog.d(TAG, 2, "openCameraWithRetry successfully.  retry times = " + i17 + ", max retry times = " + i16);
                break;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "openCameraWithRetry. Fail to open camera. error msg: " + e16.getMessage() + ", retry times = " + i17 + ", max retry times = " + i16);
                }
                i17++;
                if (i17 < i16) {
                    try {
                        Thread.currentThread();
                        LockMethodProxy.sleep(1500);
                    } catch (InterruptedException e17) {
                        e17.printStackTrace();
                    }
                } else {
                    throw new RuntimeException(e16);
                }
            }
        }
        return camera2;
    }
}
