package com.tencent.mobileqq.shortvideo.filter;

import android.os.SystemClock;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.sveffects.SLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQFilterLogManager {
    public static String TAG = "QQFilterLog";
    public static boolean isEnable = false;
    public static long mFilterStartTime = 0;
    public static long mOnDrawFrameStartTime = 0;
    public static long mOnOldDrawFrameStartTime = 0;
    public static long mPTVStartTime = 0;
    public static long mPrintLogOverTime = 80;
    public static long mPrintLogSpcingTime = 2000;
    public static long mSpcingTime;
    public static long mStartTime;

    public static boolean isRenderOverTime(long j3) {
        if (j3 > mPrintLogOverTime) {
            return true;
        }
        return false;
    }

    public static boolean isSpacingOverTime(long j3) {
        if (j3 > mPrintLogSpcingTime) {
            return true;
        }
        return false;
    }

    public static void setLogEnd(String str) {
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis() - mStartTime;
        if (SLog.isEnable() && isEnable) {
            SLog.d(TAG, "QQFilterRenderManager \u751f\u547d\u5468\u671f\u7ed3\u675f\u8017\u65f6 [" + str + " \u6beb\u79d2=" + currentThreadTimeMillis + "ms \u5fae\u79d2=" + (currentThreadTimeMillis * 1000) + "us]");
        }
    }

    public static void setLogStart(String str) {
        mStartTime = SystemClock.currentThreadTimeMillis();
        if (SLog.isEnable() && isEnable) {
            SLog.d(TAG, "QQFilterRenderManager \u751f\u547d\u5468\u671f\u5f00\u59cb [" + str + "]");
        }
    }

    public static void setOnDrawFilterEnd(String str) {
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis() - mFilterStartTime;
        if ((SLog.isEnable() && isEnable) || (SLog.isEnable() && isRenderOverTime(currentThreadTimeMillis))) {
            SLog.d(TAG, "QQFilterRenderManager_\u6e32\u67d3item\u8017\u65f6:[" + str + " \u6beb\u79d2=" + currentThreadTimeMillis + "ms \u5fae\u79d2=" + (currentThreadTimeMillis * 1000) + "us]");
        }
    }

    public static void setOnDrawFilterStart() {
        mFilterStartTime = SystemClock.currentThreadTimeMillis();
    }

    public static void setOnDrawFrameEnd() {
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis() - mOnDrawFrameStartTime;
        if (SLog.isEnable() && isEnable) {
            SLog.w(TAG, "QQFilterRenderManager_\u4e00\u5e27\u7ed3\u675f \u603b\u8017\u65f6[ \u6beb\u79d2=" + currentThreadTimeMillis + "ms \u5fae\u79d2=" + (1000 * currentThreadTimeMillis) + "us]");
        }
        if (QmcfManager.getInstance().isQmcfWork()) {
            QmcfManager.getInstance().updateQmcfFrameConsume(currentThreadTimeMillis);
        }
    }

    public static void setOnDrawFrameStart() {
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        mOnDrawFrameStartTime = currentThreadTimeMillis;
        if (isSpacingOverTime(currentThreadTimeMillis - mSpcingTime)) {
            isEnable = true;
            mSpcingTime = mOnDrawFrameStartTime;
        } else {
            isEnable = false;
        }
        if (SLog.isEnable() && isEnable) {
            SLog.w(TAG, "QQFilterRenderManager \u4e00\u5e27\u5f00\u59cb");
        }
    }

    public static void setPTVEnd(String str) {
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis() - mPTVStartTime;
        if (SLog.isEnable() && isEnable) {
            SLog.d(TAG, "QQFilterRenderManager \u6302\u4ef6\uff1a  [" + str + " \u6beb\u79d2=" + currentThreadTimeMillis + "ms \u5fae\u79d2=" + (currentThreadTimeMillis * 1000) + "us]");
        }
    }

    public static void setPTVStart() {
        mPTVStartTime = SystemClock.currentThreadTimeMillis();
    }

    public static void setFilterStatus(String str, boolean z16) {
    }
}
