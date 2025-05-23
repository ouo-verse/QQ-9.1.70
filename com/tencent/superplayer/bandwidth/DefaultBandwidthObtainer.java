package com.tencent.superplayer.bandwidth;

import android.annotation.SuppressLint;
import android.net.TrafficStats;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.superplayer.utils.LogUtil;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes26.dex */
public class DefaultBandwidthObtainer implements IBandwidthObtainer {
    private static final long LOG_INTERVAL = 5000;
    private static final String TAG = "DefaultBandwidthObtainer";
    private static long lastLogTime;
    private Method getLoopbackRxBytes;
    private Method getRxBytes;
    private long lastLoopBackBytes;
    private long lastTimeStamp = 0;
    private long lastTotalRxBytes;

    @SuppressLint({"DiscouragedPrivateApi", "PrivateApi"})
    private long getLoopbackRxBytesIn14() {
        try {
            if (this.getRxBytes == null) {
                Method declaredMethod = TrafficStats.class.getDeclaredMethod("getRxBytes", String.class);
                this.getRxBytes = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            return ((Long) this.getRxBytes.invoke(null, "lo")).longValue();
        } catch (Exception e16) {
            logError("getLoopbackRxBytesIn14: ", e16);
            return 0L;
        }
    }

    @SuppressLint({"DiscouragedPrivateApi", "PrivateApi"})
    private long getLoopbackRxBytesIn28() {
        try {
            if (this.getLoopbackRxBytes == null) {
                Method declaredMethod = TrafficStats.class.getDeclaredMethod("getLoopbackRxBytes", new Class[0]);
                this.getLoopbackRxBytes = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            return ((Long) this.getLoopbackRxBytes.invoke(null, new Object[0])).longValue();
        } catch (Exception e16) {
            logError("getLoopbackRxBytesIn28: ", e16);
            return 0L;
        }
    }

    private long getTotalRxBytes() {
        try {
            return TrafficStats.getTotalRxBytes();
        } catch (Exception e16) {
            logError("getTotalRxBytes: ", e16);
            return 0L;
        }
    }

    private void logError(String str, Throwable th5) {
        if (System.currentTimeMillis() - lastLogTime > 5000) {
            LogUtil.e(TAG, str, th5);
            lastLogTime = System.currentTimeMillis();
        }
    }

    @Override // com.tencent.superplayer.bandwidth.IBandwidthObtainer
    public long getCurrentBandwidth() {
        long loopbackRxBytesIn14;
        int i3;
        int i16 = Build.VERSION.SDK_INT;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long totalRxBytes = getTotalRxBytes();
        if (i16 >= 28) {
            loopbackRxBytesIn14 = getLoopbackRxBytesIn28();
        } else {
            loopbackRxBytesIn14 = getLoopbackRxBytesIn14();
        }
        long j3 = this.lastTotalRxBytes;
        long j16 = 0;
        if (j3 > 0) {
            long j17 = this.lastLoopBackBytes;
            if (j17 > 0) {
                long j18 = (totalRxBytes - j3) - (loopbackRxBytesIn14 - j17);
                long j19 = this.lastTimeStamp;
                if (j19 > 0) {
                    i3 = (int) Math.max((elapsedRealtime - j19) / 1000, 1L);
                } else {
                    i3 = 1;
                }
                j16 = Math.max(0L, j18 / 1024) / i3;
            }
        }
        this.lastTotalRxBytes = totalRxBytes;
        this.lastLoopBackBytes = loopbackRxBytesIn14;
        this.lastTimeStamp = elapsedRealtime;
        return j16;
    }
}
