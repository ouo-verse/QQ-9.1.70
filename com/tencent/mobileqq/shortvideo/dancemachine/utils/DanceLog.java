package com.tencent.mobileqq.shortvideo.dancemachine.utils;

import android.os.Process;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.sveffects.SLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class DanceLog {
    private static final String TAG = "DanceLog";

    private static String getThreadLogSignature() {
        return " TName=" + Thread.currentThread().getName() + " ,pid=" + Process.myPid() + ",tid=" + Process.myTid();
    }

    public static void print(String str, String str2) {
        if (SLog.isEnable()) {
            SLog.d(TAG, str + MsgSummary.STR_COLON + str2);
        }
    }

    public static void printFrameQueue(String str, String str2) {
        if (SLog.isEnable()) {
            SLog.e(TAG, getThreadLogSignature() + " [" + str + "]: " + str2);
        }
    }

    public static void print(String str, String str2, Throwable th5) {
        if (SLog.isEnable()) {
            SLog.e(TAG, str + MsgSummary.STR_COLON + str2, th5);
        }
    }
}
