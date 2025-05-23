package com.tencent.thumbplayer.core.utils;

import android.os.Process;
import android.text.TextUtils;

/* loaded from: classes26.dex */
public class TPThreadUtil {
    private static final String TAG = "PlayerCore.TPThreadUtil";

    public static void setThreadName(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Thread.currentThread().setName(str);
    }

    public static void setThreadPriority(int i3) {
        if (i3 >= -19 && i3 <= 19) {
            try {
                if (Process.getThreadPriority(0) != i3) {
                    Process.setThreadPriority(i3);
                }
                TPNativeLog.printLog(2, "setThreadPriority, priority:" + i3);
                return;
            } catch (Exception e16) {
                TPNativeLog.printLog(0, TAG, e16.toString());
                return;
            }
        }
        TPNativeLog.printLog(0, "setThreadPriority error, priority range:[-19,20], priority:" + i3);
    }
}
