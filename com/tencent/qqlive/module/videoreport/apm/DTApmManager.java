package com.tencent.qqlive.module.videoreport.apm;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTEventKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import com.tencent.qqlive.module.videoreport.utils.reuse.ReusablePool;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DTApmManager {
    private static final int MAX_EFFECTIVE_DETECT_TIME = 10;
    private static final int MAX_TOTAL_DETECT_TIME = 100;
    private static final String TAG = "common.DTApmManager";
    private long mElementDetectMaxTime;
    private int mElementEffectiveDetectCount;
    private long mElementEffectiveTime;
    private int mElementIneffectiveDetectCount;
    private long mElementIneffectiveTime;
    private int mElementTotalDetectCount;
    private long mElementTotalDetectTime;
    private boolean mIsElementDetectEnable;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class InstanceHolder {
        static final DTApmManager INSTANCE = new DTApmManager();

        InstanceHolder() {
        }
    }

    public static DTApmManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void handleOnElementDetect(boolean z16, long j3) {
        int i3 = this.mElementTotalDetectCount + 1;
        this.mElementTotalDetectCount = i3;
        this.mElementTotalDetectTime += j3;
        if (j3 > this.mElementDetectMaxTime) {
            this.mElementDetectMaxTime = j3;
        }
        if (z16) {
            this.mElementEffectiveTime += j3;
            this.mElementEffectiveDetectCount++;
        } else {
            this.mElementIneffectiveTime += j3;
            this.mElementIneffectiveDetectCount++;
        }
        if (this.mElementEffectiveDetectCount >= 10 || i3 >= 100) {
            triggleElementDetectReport();
        }
    }

    private boolean isDetectEnable() {
        if (!VideoReportInner.getInstance().getConfiguration().isElementDetectEnable() || new Random().nextInt(10000) > 10) {
            return false;
        }
        return true;
    }

    private void reset() {
        this.mElementTotalDetectCount = 0;
        this.mElementEffectiveDetectCount = 0;
        this.mElementIneffectiveDetectCount = 0;
        this.mElementTotalDetectTime = 0L;
        this.mElementIneffectiveTime = 0L;
        this.mElementEffectiveTime = 0L;
        this.mElementDetectMaxTime = 0L;
    }

    private void triggleElementDetectReport() {
        float f16;
        float f17;
        float f18;
        FinalData finalData = (FinalData) ReusablePool.obtain(FinalData.class);
        finalData.setEventKey(DTEventKey.MONITOR_VIEW_DETECT);
        int i3 = this.mElementTotalDetectCount;
        float f19 = 0.0f;
        if (i3 > 0) {
            f16 = this.mElementEffectiveDetectCount / i3;
        } else {
            f16 = 0.0f;
        }
        if (i3 > 0) {
            f17 = ((float) this.mElementTotalDetectTime) / i3;
        } else {
            f17 = 0.0f;
        }
        int i16 = this.mElementEffectiveDetectCount;
        if (i16 > 0) {
            f18 = ((float) this.mElementEffectiveTime) / i16;
        } else {
            f18 = 0.0f;
        }
        int i17 = this.mElementIneffectiveDetectCount;
        if (i17 > 0) {
            f19 = ((float) this.mElementIneffectiveTime) / i17;
        }
        finalData.put(DTParamKey.REPORT_KEY_EFFECTIVE_RATE, Integer.valueOf((int) (100.0f * f16)));
        finalData.put(DTParamKey.REPORT_KEY_TIME_AVERAGE, Integer.valueOf((int) f17));
        finalData.put(DTParamKey.REPORT_KEY_TIME_MAX, Long.valueOf(this.mElementDetectMaxTime));
        finalData.put(DTParamKey.REPORT_KEY_EFFECTIVE_TIME_AVERAGE, Integer.valueOf((int) f18));
        finalData.put(DTParamKey.REPORT_KEY_INEFFECTIVE_TIME_AVERAGE, Integer.valueOf((int) f19));
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "effective_rate=" + f16 + "&time_average=" + f17 + "&time_max=" + this.mElementDetectMaxTime + "&effective_averate=" + f18 + "&ineffective_averate=" + f19);
        }
        reset();
        FinalDataTarget.handle(null, finalData);
    }

    public void onElementDetect(final boolean z16, final long j3) {
        if (!this.mIsElementDetectEnable) {
            return;
        }
        ThreadUtils.execTask(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.apm.DTApmManager.1
            @Override // java.lang.Runnable
            public void run() {
                DTApmManager.this.handleOnElementDetect(z16, j3);
            }
        });
    }

    DTApmManager() {
        this.mIsElementDetectEnable = false;
        this.mElementTotalDetectCount = 0;
        this.mElementEffectiveDetectCount = 0;
        this.mElementIneffectiveDetectCount = 0;
        this.mElementTotalDetectTime = 0L;
        this.mElementDetectMaxTime = 0L;
        this.mElementEffectiveTime = 0L;
        this.mElementIneffectiveTime = 0L;
        this.mIsElementDetectEnable = isDetectEnable();
    }
}
