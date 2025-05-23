package com.tencent.mobileqq.kandian.base.image;

import android.graphics.Bitmap;
import android.os.Build;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NativeBitmap {

    /* renamed from: a, reason: collision with root package name */
    static boolean f238949a = true;

    static {
        StringBuilder sb5;
        try {
            try {
                f238949a = SoLoadUtil.m(BaseApplicationImpl.getApplication(), "readinjoybitmaps", 0, true);
            } catch (Exception unused) {
                f238949a = false;
                if (QLog.isColorLevel()) {
                    com.tencent.mobileqq.kandian.base.image.imageloader.c.e("NativeBitmap", "load so fail");
                }
                if (MobileQQ.sProcessId == 1) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("model", DeviceInfoMonitor.getModel());
                    hashMap.put("androidVersion", Build.VERSION.SDK);
                    hashMap.put("brand", Build.BRAND);
                    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "readinjoy.loadso", false, 0L, 0L, hashMap, null);
                }
                if (!QLog.isColorLevel()) {
                    return;
                } else {
                    sb5 = new StringBuilder();
                }
            }
            if (QLog.isColorLevel()) {
                sb5 = new StringBuilder();
                sb5.append("canUseNativeBitmap:");
                sb5.append(f238949a);
                com.tencent.mobileqq.kandian.base.image.imageloader.c.e("NativeBitmap", sb5.toString());
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                com.tencent.mobileqq.kandian.base.image.imageloader.c.e("NativeBitmap", "canUseNativeBitmap:" + f238949a);
            }
            throw th5;
        }
    }

    public static native void nativePinBitmap(Bitmap bitmap);
}
