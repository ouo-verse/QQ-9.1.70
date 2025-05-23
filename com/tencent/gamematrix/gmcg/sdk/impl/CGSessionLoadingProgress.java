package com.tencent.gamematrix.gmcg.sdk.impl;

import android.os.Handler;
import android.os.Looper;
import com.tencent.gamematrix.gmcg.api.GmCgPlayStatus;
import com.tencent.gamematrix.gmcg.api.GmCgPlayStatusListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* loaded from: classes6.dex */
public class CGSessionLoadingProgress {
    private final GmCgPlayStatusListener mPlayStatusListener;
    private StatusProgressLimit mStatusProgressLimit;
    private volatile GmCgPlayStatus mCurProgressPlayStatus = GmCgPlayStatus.StatusStart;
    private int mCurProgressPercent = 0;
    private boolean mIsSessionResumed = false;
    private final Map<GmCgPlayStatus, StatusProgressLimit> mStatusProgressLimitMap = new HashMap<GmCgPlayStatus, StatusProgressLimit>() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.CGSessionLoadingProgress.1
        {
            put(GmCgPlayStatus.StatusCheckingAuth, new StatusProgressLimit(0, 9));
            put(GmCgPlayStatus.StatusPrepareData, new StatusProgressLimit(10, 19));
            put(GmCgPlayStatus.StatusCheckingDevice, new StatusProgressLimit(20, 29));
            put(GmCgPlayStatus.StatusLoadingGameArchive, new StatusProgressLimit(30, 59));
            put(GmCgPlayStatus.StatusLoginLaunchingDevice, new StatusProgressLimit(60, 69));
            put(GmCgPlayStatus.StatusRTCConnecting, new StatusProgressLimit(70, 89));
            put(GmCgPlayStatus.StatusRTCConnected, new StatusProgressLimit(90, 99));
            put(GmCgPlayStatus.StatusLoadingFinished, new StatusProgressLimit(100, 100));
        }
    };
    private final Runnable mProgressIncreaseTimerTask = new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.CGSessionLoadingProgress.2
        @Override // java.lang.Runnable
        public void run() {
            if (CGSessionLoadingProgress.this.mStatusProgressLimit == null) {
                return;
            }
            int nextInt = CGSessionLoadingProgress.this.mCurProgressPercent + CGSessionLoadingProgress.this.mProgressIncreaseRandom.nextInt(5);
            CGSessionLoadingProgress cGSessionLoadingProgress = CGSessionLoadingProgress.this;
            cGSessionLoadingProgress.mCurProgressPercent = Math.min(nextInt, cGSessionLoadingProgress.mStatusProgressLimit.pProgressUpper);
            CGSessionLoadingProgress.this.updatePlayProgress();
            CGSessionLoadingProgress.this.startProgressIncreaseTimerIfNecessary();
        }
    };
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());
    private final Random mProgressIncreaseRandom = new Random();

    /* loaded from: classes6.dex */
    static class StatusProgressLimit {
        public int pProgressLower;
        public int pProgressUpper;

        StatusProgressLimit(int i3, int i16) {
            this.pProgressLower = i3;
            this.pProgressUpper = i16;
        }
    }

    public CGSessionLoadingProgress(GmCgPlayStatusListener gmCgPlayStatusListener) {
        this.mPlayStatusListener = gmCgPlayStatusListener;
    }

    private boolean needFinishLoadingProgress(GmCgPlayStatus gmCgPlayStatus) {
        if (this.mCurProgressPercent < 100 && !gmCgPlayStatus.is(GmCgPlayStatus.StatusLoadingFinished) && !gmCgPlayStatus.is(GmCgPlayStatus.StatusStopped) && !gmCgPlayStatus.is(GmCgPlayStatus.StatusErrorHappen)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startProgressIncreaseTimerIfNecessary() {
        if (this.mProgressIncreaseTimerTask != null && !needFinishLoadingProgress(this.mCurProgressPlayStatus)) {
            this.mMainHandler.postDelayed(this.mProgressIncreaseTimerTask, 100L);
        }
    }

    private void stopProgressIncreaseTimer() {
        Runnable runnable = this.mProgressIncreaseTimerTask;
        if (runnable != null) {
            this.mMainHandler.removeCallbacks(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlayProgress() {
        if (this.mPlayStatusListener != null && !needFinishLoadingProgress(this.mCurProgressPlayStatus)) {
            this.mPlayStatusListener.onGmCgPlayLoadingProgressUpdate(this.mCurProgressPlayStatus, this.mCurProgressPercent, this.mIsSessionResumed);
        }
    }

    public void isSessionResumed(boolean z16) {
        this.mIsSessionResumed = z16;
    }

    public void onGmCgPlayStatusUpdate(GmCgPlayStatus gmCgPlayStatus) {
        StatusProgressLimit statusProgressLimit;
        this.mCurProgressPlayStatus = gmCgPlayStatus;
        stopProgressIncreaseTimer();
        if (!needFinishLoadingProgress(gmCgPlayStatus) && (statusProgressLimit = this.mStatusProgressLimitMap.get(this.mCurProgressPlayStatus)) != null) {
            this.mStatusProgressLimit = statusProgressLimit;
            this.mCurProgressPercent = statusProgressLimit.pProgressLower;
            updatePlayProgress();
            startProgressIncreaseTimerIfNecessary();
        }
    }
}
