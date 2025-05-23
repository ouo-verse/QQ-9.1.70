package com.tencent.mobileqq.utils;

import android.app.ActivityManager;
import android.os.Debug;
import android.os.Process;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes20.dex */
public class MemoryUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicLong f307038a = new AtomicLong(62914560);

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicLong f307039b = new AtomicLong(0);

    /* renamed from: c, reason: collision with root package name */
    public static final Runnable f307040c = new Runnable() { // from class: com.tencent.mobileqq.utils.MemoryUtils.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                Debug.MemoryInfo[] processMemoryInfo = SystemMethodProxy.getProcessMemoryInfo((ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY), new int[]{Process.myPid()});
                if (processMemoryInfo != null && processMemoryInfo.length > 0) {
                    MemoryUtils.f307039b.set(System.currentTimeMillis());
                    MemoryUtils.f307038a.set(processMemoryInfo[0].getTotalPss() * 1024);
                }
            } catch (Throwable th5) {
                QLog.e("MemoryUtils", 1, "Tick Get Memory Error: ", th5);
            }
        }
    };

    public static long c(int i3) {
        try {
            if (i3 == Process.myPid()) {
                return SystemMethodProxy.getPss() * 1024;
            }
            Debug.MemoryInfo[] processMemoryInfo = SystemMethodProxy.getProcessMemoryInfo((ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY), new int[]{i3});
            if (processMemoryInfo != null && processMemoryInfo.length > 0) {
                return processMemoryInfo[0].getTotalPss() * 1024;
            }
            return 62914560L;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("MemoryUtils", 2, "getMemory ex pid=" + i3, e16);
                return 62914560L;
            }
            return 62914560L;
        } catch (OutOfMemoryError e17) {
            if (QLog.isColorLevel()) {
                QLog.d("MemoryUtils", 2, "getMemory OutOfMemoryError pid=", Integer.valueOf(i3), e17);
                return 62914560L;
            }
            return 62914560L;
        }
    }

    public static long d(int i3, boolean z16) {
        if (i3 == Process.myPid() && z16) {
            e();
            if (System.currentTimeMillis() - f307039b.get() > 15000) {
                if (QLog.isColorLevel()) {
                    QLog.d("MemoryUtils", 2, "Return Memory: TimeOut");
                    return 62914560L;
                }
                return 62914560L;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MemoryUtils", 2, "Return Memory: ", Long.valueOf(f307038a.get()));
            }
            return f307038a.get();
        }
        return c(i3);
    }

    private static void e() {
        ThreadManagerV2.excute(f307040c, 16, null, false);
    }
}
