package com.tencent.qphone.base.util.exp;

import android.os.Process;
import com.tencent.qphone.base.util.BaseQLogItem;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes22.dex */
public class QLogItemCircularQueuePool {
    private static final int MIN_PAGE_NUM = 2;
    private static final String TAG = "QLogItemCircularQueuePool";
    private static Runnable cacheExceedCallback = null;
    private static int front = 0;
    public static double obtainCount = 0.0d;
    public static double overCount = 0.0d;
    private static int rear = 0;
    private static int sDisplacementBase = 7;
    private static int sMaxPageNum = 128;
    private static int sMaxPageSize = 128;
    static BaseQLogItem[][] sPool;
    private static int sMaxLogCacheNum = 128 * 128;
    private static final Object sPoolSync = new Object();

    public static void destroy() {
        synchronized (sPoolSync) {
            sPool = null;
            rear = 0;
            front = 0;
            QLog.i(TAG, 1, "is destroyed.");
        }
    }

    public static int getFront() {
        return front;
    }

    public static int getRear() {
        return rear;
    }

    public static int getsMaxLogCacheNum() {
        return sMaxLogCacheNum;
    }

    public static int getsMaxPageNum() {
        return sMaxPageNum;
    }

    public static int getsMaxPageSize() {
        return sMaxPageSize;
    }

    static void init(int i3, int i16) throws Exception {
        if (i3 >= 2) {
            if (isInt(log2(i3))) {
                sDisplacementBase = (int) log2(i16);
                if (isInt(log2(i16))) {
                    sDisplacementBase = (int) log2(i16);
                    synchronized (sPoolSync) {
                        sMaxPageNum = i3;
                        sMaxPageSize = i16;
                        sMaxLogCacheNum = i3 * i16;
                        rear = 0;
                        front = 0;
                        sPool = null;
                    }
                    return;
                }
                throw new Exception("maxPageSize \u9700\u8981\u4e3a 2 \u7684\u5e42\u6b21\u65b9.");
            }
            throw new Exception("maxPageNum \u9700\u8981\u4e3a 2 \u7684\u5e42\u6b21\u65b9.");
        }
        throw new Exception("maxPageSize \u8981\u5927\u4e8e 2.");
    }

    private static boolean isInt(double d16) {
        if (Math.abs(d16 - Math.round(d16)) < Double.MIN_VALUE) {
            return true;
        }
        return false;
    }

    public static boolean isNoUse() {
        int i3 = front;
        int i16 = rear;
        if (i3 == i16 || ((i3 + 1) & (sMaxLogCacheNum - 1)) == i16) {
            return true;
        }
        return false;
    }

    public static BaseQLogItem loc(int i3) {
        BaseQLogItem baseQLogItem;
        BaseQLogItem[] baseQLogItemArr = sPool[i3 >> sDisplacementBase];
        if (baseQLogItemArr == null || (baseQLogItem = baseQLogItemArr[i3 & (sMaxPageSize - 1)]) == null) {
            return null;
        }
        return baseQLogItem;
    }

    private static BaseQLogItem locIfNullCreate(int i3) {
        int i16 = i3 >> sDisplacementBase;
        BaseQLogItem[][] baseQLogItemArr = sPool;
        if (baseQLogItemArr[i16] == null) {
            baseQLogItemArr[i16] = new BaseQLogItem[sMaxPageSize];
        }
        int i17 = i3 & (sMaxPageSize - 1);
        BaseQLogItem[] baseQLogItemArr2 = baseQLogItemArr[i16];
        if (baseQLogItemArr2[i17] == null) {
            baseQLogItemArr2[i17] = new BaseQLogItem();
        }
        return sPool[i16][i17];
    }

    private static double log2(int i3) {
        return Math.log(i3) / Math.log(2.0d);
    }

    static BaseQLogItem obtain() {
        obtainCount += 1.0d;
        synchronized (sPoolSync) {
            if (sPool == null) {
                BaseQLogItem[][] baseQLogItemArr = new BaseQLogItem[sMaxPageNum];
                sPool = baseQLogItemArr;
                rear++;
                BaseQLogItem[] baseQLogItemArr2 = new BaseQLogItem[sMaxPageSize];
                baseQLogItemArr[0] = baseQLogItemArr2;
                baseQLogItemArr2[0] = new BaseQLogItem();
                QLog.i(TAG, 1, "first obtain success.");
                return sPool[0][0];
            }
            int i3 = rear;
            int i16 = (i3 + 1) & (sMaxLogCacheNum - 1);
            BaseQLogItem locIfNullCreate = locIfNullCreate(i3);
            if (i16 == front) {
                overCount += 1.0d;
                for (int i17 = 0; i17 < sMaxPageSize; i17++) {
                    recycleHead();
                }
                Runnable runnable = cacheExceedCallback;
                if (runnable != null) {
                    runnable.run();
                }
            }
            rear = i16;
            return locIfNullCreate;
        }
    }

    public static void recycleHead() {
        synchronized (sPoolSync) {
            BaseQLogItem loc = loc(front);
            if (loc != null) {
                loc.recycle();
            }
            front = (front + 1) & (sMaxLogCacheNum - 1);
        }
    }

    public static void setCacheExceedCallback(Runnable runnable) {
        cacheExceedCallback = runnable;
    }

    public static void obtain(byte b16, long j3, byte b17, String str, String str2, Throwable th5) {
        BaseQLogItem obtain = obtain();
        obtain.androidLogLevel = b16;
        obtain.logTime = j3;
        obtain.threadId = (short) Process.myTid();
        obtain.curJavaThreadId = (short) Thread.currentThread().getId();
        obtain.tag = str;
        obtain.level = b17;
        obtain.f344405msg = str2;
        obtain.trace = th5;
    }

    public static void obtain(byte b16, long j3, byte b17, String str, Throwable th5) {
        BaseQLogItem obtain = obtain();
        obtain.androidLogLevel = b16;
        obtain.logTime = j3;
        obtain.threadId = (short) Process.myTid();
        obtain.curJavaThreadId = (short) Thread.currentThread().getId();
        obtain.tag = str;
        obtain.level = b17;
        obtain.trace = th5;
    }
}
