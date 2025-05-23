package com.tencent.libra.memory;

import android.app.ActivityManager;
import android.app.Application;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.util.LibraLogUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasBusiness;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.QZoneHelper;
import java.io.BufferedReader;
import java.io.FileReader;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MemoryManager {
    public static final int BUFFER_SIZE = 1024;
    public static final int DEF_DISPLAY_SCALE_RATE = 1;
    private static final long ONE_M_SIZE = 1048576;
    private static final String TAG = LibraLogUtil.INSTANCE.getLogTag("MemoryManager");
    private static long sAvailClassSize = 0;
    private static long cachedTotalMemory = 0;

    public static long getAvailClassSize() {
        long j3 = sAvailClassSize;
        if (j3 > 0) {
            return j3;
        }
        long systemTotalMemory = getSystemTotalMemory();
        long systemAvailableMemory = getSystemAvailableMemory();
        long j16 = ((3 * systemTotalMemory) + (7 * systemAvailableMemory)) / 10;
        long maxMemory = Runtime.getRuntime().maxMemory();
        if (j16 <= 157286400) {
            sAvailClassSize = Math.min(25165824L, maxMemory);
        } else if (j16 <= 262144000) {
            sAvailClassSize = Math.min(37748736L, maxMemory);
        } else if (j16 <= 419430400) {
            sAvailClassSize = Math.min(67108864L, maxMemory);
        } else if (j16 <= QZoneHelper.Constants.SUPPORT_MIX_MUSIC_DEFAULT) {
            sAvailClassSize = Math.min(134217728L, maxMemory);
        } else {
            sAvailClassSize = Math.min(VasBusiness.QWALLET, maxMemory);
        }
        RFWLog.d(TAG, RFWLog.USR, "getAvailClassSize, availClassSize=" + (sAvailClassSize / 1048576) + "M, totalMemSize=" + (systemTotalMemory / 1048576) + "M, remainMemSize=" + (systemAvailableMemory / 1048576) + "M, availMemSize=" + (j16 / 1048576) + "M, classMemSize=" + (maxMemory / 1048576) + "M");
        return sAvailClassSize;
    }

    public static long getSystemAvailableMemory() {
        Application application = RFWApplication.getApplication();
        if (application != null) {
            ActivityManager activityManager = (ActivityManager) application.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            try {
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo.availMem;
            } catch (Exception e16) {
                if (RFWLog.isColorLevel()) {
                    RFWLog.d(TAG, RFWLog.CLR, "getSystemAvaialbeMemory call the getMemoryInfo method failed:", e16);
                }
            }
        }
        return -1L;
    }

    public static long getSystemTotalMemory() {
        if (cachedTotalMemory == 0) {
            try {
                FileReader fileReader = new FileReader("/proc/meminfo");
                try {
                    BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            cachedTotalMemory = Long.parseLong(readLine.split("\\s+")[1]) * 1024;
                        }
                        bufferedReader.close();
                        fileReader.close();
                    } finally {
                    }
                } finally {
                }
            } catch (Exception unused) {
                cachedTotalMemory = 0L;
            }
            if (cachedTotalMemory == 0) {
                return 1073741824L;
            }
        }
        return cachedTotalMemory;
    }
}
