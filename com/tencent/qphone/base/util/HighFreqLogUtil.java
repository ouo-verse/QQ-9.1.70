package com.tencent.qphone.base.util;

/* compiled from: P */
/* loaded from: classes22.dex */
public class HighFreqLogUtil {
    private static final int LOG_DEV = 1001;
    private static final int LOG_ERROR = 1003;
    private static final int LOG_WARNING = 1002;
    public static final int MODE_COMBINE = 2;
    public static final int MODE_FREQ = 1;
    private volatile StringBuffer combineBuffer;
    private StringBuilder combineBuilder;
    private int curCnt;
    private volatile int curCntWithThreadSafe;
    private long lastTime;
    private volatile long lastTimeWithThreadSafe;
    private int mode;
    private long threadHold = 10000;
    private int maxCombineCnt = 5;

    public HighFreqLogUtil(int i3) {
        this.mode = i3;
    }

    private void checkLogFreq(String str, int i3, String str2, int i16) {
        int i17 = this.mode;
        if (i17 == 1) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.lastTime >= this.threadHold) {
                this.lastTime = currentTimeMillis;
                realPrintLog(str, i3, str2, i16);
                return;
            }
            return;
        }
        if (i17 == 2) {
            if (this.combineBuilder == null) {
                this.combineBuilder = new StringBuilder(100);
                this.curCnt = 0;
            }
            if (this.curCnt >= this.maxCombineCnt) {
                realPrintLog(str, i3, this.combineBuilder.toString(), i16);
                this.curCnt = 0;
                this.combineBuilder = null;
            } else {
                StringBuilder sb5 = this.combineBuilder;
                sb5.append(str2);
                sb5.append(" ");
                this.curCnt++;
            }
        }
    }

    private synchronized void checkLogFreqWithThreadSafe(String str, int i3, String str2, int i16) {
        int i17 = this.mode;
        if (i17 == 1) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.lastTimeWithThreadSafe >= this.threadHold) {
                this.lastTimeWithThreadSafe = currentTimeMillis;
                realPrintLog(str, i3, str2, i16);
            }
        } else if (i17 == 2) {
            if (this.combineBuffer == null) {
                this.combineBuffer = new StringBuffer(100);
                this.curCntWithThreadSafe = 0;
            }
            if (this.curCntWithThreadSafe >= this.maxCombineCnt) {
                realPrintLog(str, i3, this.combineBuffer.toString(), i16);
                this.curCntWithThreadSafe = 0;
                this.combineBuffer = null;
            } else {
                StringBuffer stringBuffer = this.combineBuffer;
                stringBuffer.append(str2);
                stringBuffer.append(" ");
                this.curCntWithThreadSafe++;
            }
        }
    }

    private void realPrintLog(String str, int i3, String str2, int i16) {
        switch (i16) {
            case 1001:
                QLog.d(str, i3, str2);
                return;
            case 1002:
                QLog.w(str, i3, str2);
                return;
            case 1003:
                QLog.e(str, i3, str2);
                return;
            default:
                return;
        }
    }

    public void d(String str, int i3, String str2) {
        checkLogFreqWithThreadSafe(str, i3, str2, 1001);
    }

    public void dSafe(String str, int i3, String str2) {
        checkLogFreqWithThreadSafe(str, i3, str2, 1001);
    }

    public void e(String str, int i3, String str2) {
        checkLogFreqWithThreadSafe(str, i3, str2, 1003);
    }

    public void eSafe(String str, int i3, String str2) {
        checkLogFreqWithThreadSafe(str, i3, str2, 1003);
    }

    public void setMaxCombineCnt(int i3) {
        this.maxCombineCnt = i3;
    }

    public void setThreadHold(long j3) {
        this.threadHold = j3;
    }

    public void w(String str, int i3, String str2) {
        checkLogFreqWithThreadSafe(str, i3, str2, 1002);
    }

    public void wSafe(String str, int i3, String str2) {
        checkLogFreqWithThreadSafe(str, i3, str2, 1002);
    }
}
