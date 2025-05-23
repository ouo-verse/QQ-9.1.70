package com.tencent.biz.richframework.monitor.local.fps;

import android.text.TextUtils;
import android.view.Choreographer;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.core.os.TraceCompat;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWDropFrameCollector implements Choreographer.FrameCallback {
    private static final String DEF_DEVICE_BLACK_LIST = "PBAM00|PBAT00|PBFM00";
    private static float DROP_DURATION_0 = 0.0f;
    private static float DROP_DURATION_1_2 = 0.0f;
    private static float DROP_DURATION_2_4 = 0.0f;
    private static float DROP_DURATION_4_8 = 0.0f;
    private static float DROP_DURATION_8_15 = 0.0f;
    private static float[] DROP_DURATION_ARRAY = null;
    private static float DROP_DURATION_BIGGER = 0.0f;
    private static final int DROP_RANGE_0 = 0;
    private static final int DROP_RANGE_1 = 1;
    private static final int DROP_RANGE_2_4 = 2;
    private static final int DROP_RANGE_4_8 = 3;
    private static final int DROP_RANGE_8_15 = 4;
    private static final int DROP_RANGE_BIGGER = 5;
    private static final int MIN_DROP_COUNT_THRESHOLD = 2;
    private static final int MIN_SCROLL_SCROLL_THRESHOLD = 100;
    private static final int RANGE_COUNT = 6;
    private static final int REFRESH_INTERVAL = 500;
    private static final String TAG = "FAM-DropFrameCollector";
    private static String sDeviceBlackList = "PBAM00|PBAT00|PBFM00";
    private static boolean sIsBlackDevice = isBlackDevice();
    public static float sRefreshRate;
    private static float sVSyncIntervalNs;
    private static float sVsyncIntervalMs;
    private final DropFrameCallback mDropFrameCallback;
    private RFWDropFrameData mDropFrameData;
    private long mFrameInterval;
    private boolean mIsStarted;
    private long lastRefreshTime = 0;
    private long lastFrameTime = 0;
    private long frameCount = 0;
    private float mFps = 0.0f;
    private float mDropFrameRate = 0.0f;
    private float mSmoothRate = 0.0f;
    private float mTotalSmoothRate = 0.0f;
    private long mTotalPredictTimes = 0;
    private long mTotalScrollDurationMs = 0;
    private int mScrollCount = 1;
    private boolean mIsEnabledTracePrint = false;
    private long mStartDropTimeNanos = 0;
    private final Choreographer mChoreographer = Choreographer.getInstance();
    private final RFWStackSampler mStackSampler = new RFWStackSampler();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface DropFrameCallback {
        void onInfo(DropFrameInfo dropFrameInfo, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class DropFrameInfo {
        private float mDropFrameRate;
        private float mFps;
        private long[] mFrameTimeArray;
        private float mSmoothRate;
        private float mTotalSmoothRate;

        public float getFps() {
            return this.mFps;
        }

        public long[] getFrameTimeArray() {
            return this.mFrameTimeArray;
        }

        public float getSmoothRate() {
            return this.mSmoothRate;
        }

        public float getTotalSmoothRate() {
            return this.mTotalSmoothRate;
        }

        public void setFps(float f16) {
            this.mFps = f16;
        }

        public void setFrameTimeArray(long[] jArr) {
            this.mFrameTimeArray = jArr;
        }

        public void setSmoothRate(float f16) {
            this.mSmoothRate = f16;
        }

        public void setTotalSmoothRate(float f16) {
            this.mTotalSmoothRate = f16;
        }
    }

    public RFWDropFrameCollector(DropFrameCallback dropFrameCallback, WindowManager windowManager) {
        this.mDropFrameCallback = dropFrameCallback;
        init(windowManager);
    }

    private void collectDropFrameData(long j3, RFWDropFrameData rFWDropFrameData) {
        if (rFWDropFrameData == null || TextUtils.isEmpty(rFWDropFrameData.scene)) {
            return;
        }
        if (rFWDropFrameData.firstFrameTime == 0) {
            long j16 = this.mStartDropTimeNanos;
            rFWDropFrameData.firstFrameTime = j16;
            updateDropFrameInfo(rFWDropFrameData, (float) (j3 - j16), j3);
        } else {
            updateDropFrameInfo(rFWDropFrameData, (float) (j3 - this.lastFrameTime), j3);
        }
        this.lastFrameTime = j3;
    }

    private void computeSmoothRate(RFWDropFrameData rFWDropFrameData, long j3) {
        long[] jArr = rFWDropFrameData.dropTimes;
        int length = jArr.length;
        long j16 = 0;
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            long j17 = jArr[i16];
            j16 = ((float) j16) + (((float) j17) * DROP_DURATION_ARRAY[i16]);
            i3 = (int) (i3 + j17);
        }
        long j18 = i3 * sVsyncIntervalMs;
        rFWDropFrameData.scrollDurationMs = j16;
        RFWLog.d(TAG, RFWLog.DEV, "[computeSmoothRate] predictTimes: " + j18 + " | drawTimesMs: " + j16 + " | frameCount: " + i3);
        if (j16 != 0) {
            this.mSmoothRate = convert2Float((j18 / j16) * 100.0d, 10);
        }
        long j19 = this.mTotalPredictTimes + j18;
        this.mTotalPredictTimes = j19;
        long j26 = this.mTotalScrollDurationMs + j16;
        this.mTotalScrollDurationMs = j26;
        this.mTotalSmoothRate = convert2Float((j19 / j26) * 100.0d, 10);
    }

    private float convert2Float(double d16, int i3) {
        return ((float) Math.round(d16 * i3)) / i3;
    }

    private static int getRangeIndex(int i3) {
        if (i3 <= 0) {
            return 0;
        }
        int i16 = 1;
        if (i3 != 1) {
            i16 = 4;
            if (i3 <= 4) {
                return 2;
            }
            if (i3 <= 8) {
                return 3;
            }
            if (i3 > 15) {
                return 5;
            }
        }
        return i16;
    }

    private static boolean isBlackDevice() {
        String str = sDeviceBlackList;
        if (str == null || str.isEmpty()) {
            return false;
        }
        String[] split = sDeviceBlackList.split("\\|");
        if (split.length == 0) {
            return false;
        }
        String model = DeviceInfoMonitor.getModel();
        if (TextUtils.isEmpty(model)) {
            return false;
        }
        return Arrays.asList(split).contains(model);
    }

    private void notifyFrameInfoUpdate(boolean z16) {
        long[] jArr;
        DropFrameInfo dropFrameInfo = new DropFrameInfo();
        dropFrameInfo.setFps(this.mFps);
        dropFrameInfo.setSmoothRate(this.mSmoothRate);
        dropFrameInfo.setTotalSmoothRate(this.mTotalSmoothRate);
        RFWDropFrameData rFWDropFrameData = this.mDropFrameData;
        if (rFWDropFrameData == null) {
            jArr = null;
        } else {
            jArr = rFWDropFrameData.dropTimes;
        }
        dropFrameInfo.setFrameTimeArray(jArr);
        DropFrameCallback dropFrameCallback = this.mDropFrameCallback;
        if (dropFrameCallback != null) {
            dropFrameCallback.onInfo(dropFrameInfo, z16);
        }
    }

    private void resetData() {
        RFWDropFrameData rFWDropFrameData = this.mDropFrameData;
        if (rFWDropFrameData != null) {
            rFWDropFrameData.reset();
        }
        this.mStartDropTimeNanos = 0L;
        this.frameCount = 0L;
        this.lastRefreshTime = 0L;
        this.mSmoothRate = 0.0f;
        this.mTotalSmoothRate = 0.0f;
        this.mTotalScrollDurationMs = 0L;
        this.lastFrameTime = 0L;
    }

    private void resetDropFrameData() {
        RFWDropFrameData rFWDropFrameData = this.mDropFrameData;
        if (rFWDropFrameData == null || TextUtils.isEmpty(rFWDropFrameData.scene)) {
            return;
        }
        if (this.mIsEnabledTracePrint) {
            TraceCompat.endSection();
        }
        calculateOnce();
        resetData();
    }

    private void updateDropFrameInfo(@NonNull RFWDropFrameData rFWDropFrameData, float f16, long j3) {
        float f17 = sVSyncIntervalNs;
        int rangeIndex = getRangeIndex((int) ((f16 - f17) / f17));
        rFWDropFrameData.frameCount++;
        long[] jArr = rFWDropFrameData.dropTimes;
        jArr[rangeIndex] = jArr[rangeIndex] + 1;
        rFWDropFrameData.finalFrameTime = j3;
    }

    public void calculateOnce() {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        RFWDropFrameData rFWDropFrameData = this.mDropFrameData;
        long millis = timeUnit.toMillis(rFWDropFrameData.finalFrameTime - rFWDropFrameData.firstFrameTime);
        RFWDropFrameData rFWDropFrameData2 = this.mDropFrameData;
        if (rFWDropFrameData2.frameCount > 0) {
            computeSmoothRate(rFWDropFrameData2, millis);
            if (RFWLog.isColorLevel() || RFWApplication.isDebug()) {
                RFWLog.d(TAG, RFWLog.DEV, "[computeSmoothRate] mScrollCount= " + this.mScrollCount + ", mDropFrameData=" + this.mDropFrameData + ", smoothRate=" + this.mSmoothRate + ", totalSmoothRate=" + this.mTotalSmoothRate);
            }
            long j3 = this.mFrameInterval;
            if (j3 != 0) {
                this.mFps = ((float) (this.frameCount * 1000)) / ((float) j3);
            }
            notifyFrameInfoUpdate(true);
            this.mScrollCount++;
            return;
        }
        if (RFWLog.isColorLevel()) {
            RFWLog.d(TAG, RFWLog.DEV, "[resetDropFrameData] current frameCount: " + this.mDropFrameData.frameCount + " | scrollDurationMs: " + millis);
        }
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j3) {
        collectDropFrameData(j3, this.mDropFrameData);
        long j16 = this.lastRefreshTime;
        if (j16 <= 0) {
            this.lastRefreshTime = j3;
        } else {
            long millis = TimeUnit.NANOSECONDS.toMillis(j3 - j16);
            this.mFrameInterval = millis;
            this.frameCount = this.frameCount + 1;
            if (millis > 500) {
                this.frameCount = 0L;
                this.mFps = convert2Float(((float) (r4 * 1000)) / ((float) millis), 100);
                this.lastRefreshTime = j3;
                notifyFrameInfoUpdate(false);
            }
        }
        this.mChoreographer.postFrameCallback(this);
    }

    public void init(WindowManager windowManager) {
        if (windowManager == null || sRefreshRate == windowManager.getDefaultDisplay().getRefreshRate()) {
            return;
        }
        float refreshRate = windowManager.getDefaultDisplay().getRefreshRate();
        sRefreshRate = refreshRate;
        if (refreshRate > 0.0f) {
            sVsyncIntervalMs = 1000.0f / refreshRate;
            sVSyncIntervalNs = 1.0E9f / refreshRate;
        }
        float f16 = sVsyncIntervalMs;
        if (f16 > 0.0f) {
            DROP_DURATION_0 = f16;
            DROP_DURATION_1_2 = 1.5f * f16;
            DROP_DURATION_2_4 = 3.0f * f16;
            DROP_DURATION_4_8 = 6.0f * f16;
            DROP_DURATION_8_15 = 11.5f * f16;
            DROP_DURATION_BIGGER = f16 * 15.0f;
        }
        DROP_DURATION_ARRAY = new float[]{DROP_DURATION_0, DROP_DURATION_1_2, DROP_DURATION_2_4, DROP_DURATION_4_8, DROP_DURATION_8_15, DROP_DURATION_BIGGER};
        RFWLog.d(TAG, RFWLog.DEV, "[init] sVsyncIntervalMs=" + sVsyncIntervalMs);
        resetData();
    }

    public void setDeviceBlackList(String str) {
        sDeviceBlackList = str;
    }

    public void setEnabledTracePrint(boolean z16) {
        this.mIsEnabledTracePrint = z16;
    }

    public void start() {
        if (sIsBlackDevice) {
            RFWLog.e(TAG, RFWLog.USR, "[start] current is black device, not start drop frame monitor.");
            return;
        }
        RFWLog.e(TAG, RFWLog.USR, "[start] " + hashCode());
        this.mIsStarted = true;
        this.mChoreographer.removeFrameCallback(this);
        this.mChoreographer.postFrameCallback(this);
    }

    public void startMonitorDropFrame(String str) {
        if (sVSyncIntervalNs <= 0.0f) {
            return;
        }
        if (!this.mIsStarted) {
            start();
        }
        this.mStartDropTimeNanos = System.nanoTime();
        if (this.mDropFrameData != null && !TextUtils.isEmpty(str) && TextUtils.equals(str, this.mDropFrameData.scene)) {
            return;
        }
        if (this.mDropFrameData == null) {
            this.mDropFrameData = new RFWDropFrameData(6);
        }
        this.mDropFrameData.scene = str;
        RFWStackSampler rFWStackSampler = this.mStackSampler;
        if (rFWStackSampler != null && this.mIsEnabledTracePrint) {
            rFWStackSampler.start();
        }
        if (this.mIsEnabledTracePrint) {
            TraceCompat.beginSection(this.mDropFrameData.scene + " start scroll");
        }
    }

    public void stop() {
        if (sIsBlackDevice) {
            return;
        }
        RFWLog.e(TAG, RFWLog.USR, "[stop] " + hashCode());
        this.mIsStarted = false;
        this.mChoreographer.removeFrameCallback(this);
    }

    public void stopMonitorDropFrame() {
        resetDropFrameData();
        RFWStackSampler rFWStackSampler = this.mStackSampler;
        if (rFWStackSampler != null && this.mIsEnabledTracePrint) {
            rFWStackSampler.stop();
        }
    }
}
