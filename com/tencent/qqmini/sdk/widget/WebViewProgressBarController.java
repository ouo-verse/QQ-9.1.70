package com.tencent.qqmini.sdk.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;

/* loaded from: classes23.dex */
public class WebViewProgressBarController {
    private static final float ACCELERATE_MAX_RATE = 40.0f;
    private static final float ACCELERATE_RATE = 0.5f;
    private static final float ACCELERATE_TIME = 300.0f;
    private static final float END_ALPHA = 10.0f;
    private static final String LOG_TAG = "WebViewProgressBarController";
    public static final int MSG_REFRESH_DELAY = 20;
    public static final int MSG_UPDATE_PROGRESS = 200;
    private static final float PART_ONE_END_PROGRESS = 20.0f;
    private static final int PART_ONE_SPEED_REDUCE_RATE = 5;
    private static final float PART_TWO_END_PROGRESS = 80.0f;
    private static final int PART_TWO_SPEED_REDUCE_RATE = 20;
    private static final int PROGRESS_BEFORE_FINISH = 98;
    private static final int START_PROGRESS = 0;
    public static final byte STATUS_FINISH = 2;
    public static final byte STATUS_LOADING = 0;
    public static final byte STATUS_PART1_FINISH = 1;
    public static final byte STEP_ACCELERATE = 5;
    public static final byte STEP_FINISH = 6;
    public static final byte STEP_PART_ONE = 0;
    public static final byte STEP_PART_ONE_WAIT = 1;
    public static final byte STEP_PART_TWO = 2;
    public static final byte STEP_PART_TWO_WAIT = 3;
    public static final byte STEP_WAIT_FINISH = 4;
    private float mCurrAlphaRate;
    private float mCurrWidth;
    private float mCurrentProgress;
    protected WebViewProgressBar mProgressBar;
    private float mProgressRate;
    private long mStartLoadingTime;
    private float mStartWidth;
    private byte mStatus = -1;
    private int mProgressBarWidth = 0;
    private Handler mHandler = new MainThreadHandler();
    private boolean mFinishAllWidth = false;
    private int mAlpha = 255;
    private byte mStep = 6;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class DurationGenerator {
        private static final int DEFAULT_DURATION_FOR_PHASEONE_2G = 9000;
        private static final int DEFAULT_DURATION_FOR_PHASEONE_NON_2G = 1800;
        private static final int DEFAULT_DURATION_FOR_PHASETWO_2G = 6000;
        private static final int DEFAULT_DURATION_FOR_PHASETWO_NON_2G = 1200;
        private static final int FINISHED_TIME_MAX_FACTOR = 3;
        private static final int MAX_STATISTICS_COUNT = 3;
        private static final int MIN_EXPECTED_FINISH_TIME = 100;
        public static final int PHASE_ONE = 0;
        public static final int PHASE_TWO = 1;
        private static DurationGenerator sPhaseOne;
        private static DurationGenerator sPhaseTwo;
        private int m2GDuration;
        private int mLastSampleIndex;
        private int mNetType = 0;
        private int mNon2GDuration;
        private int mPhaseType;
        private int[] mSampleDuration;
        private long mStartingTime;

        public DurationGenerator(int i3) {
            this.mSampleDuration = null;
            this.m2GDuration = 9000;
            this.mNon2GDuration = 1800;
            this.mPhaseType = i3;
            if (i3 == 0) {
                this.m2GDuration = 9000;
                this.mNon2GDuration = 1800;
            } else {
                this.m2GDuration = 6000;
                this.mNon2GDuration = 1200;
            }
            this.mStartingTime = 0L;
            this.mLastSampleIndex = 0;
            this.mSampleDuration = new int[3];
            for (int i16 = 0; i16 < 3; i16++) {
                this.mSampleDuration[i16] = 0;
            }
        }

        private void clearSampleDuration() {
            for (int i3 = 0; i3 < 3; i3++) {
                this.mSampleDuration[i3] = 0;
            }
            this.mLastSampleIndex = 0;
        }

        public static DurationGenerator getInstance(int i3) {
            if (i3 == 0) {
                if (sPhaseOne == null) {
                    sPhaseOne = new DurationGenerator(0);
                }
                return sPhaseOne;
            }
            if (sPhaseTwo == null) {
                sPhaseTwo = new DurationGenerator(1);
            }
            return sPhaseTwo;
        }

        private int getSampleDuration() {
            int i3 = 0;
            int i16 = 0;
            for (int i17 = 0; i17 < 3; i17++) {
                int i18 = this.mSampleDuration[i17];
                if (i18 > 0) {
                    i3++;
                    i16 += i18;
                }
            }
            if (i3 <= 0) {
                return 0;
            }
            return i16 / i3;
        }

        public int getDefaultDuration() {
            if (2 == this.mNetType) {
                return this.m2GDuration;
            }
            return this.mNon2GDuration;
        }

        public void recordFinish() {
            int i3;
            int i16;
            int currentTimeMillis = (int) (System.currentTimeMillis() - this.mStartingTime);
            int sampleDuration = getSampleDuration();
            if (this.mNetType == 2) {
                i3 = this.m2GDuration;
            } else {
                i3 = this.mNon2GDuration;
            }
            if (sampleDuration == 0) {
                i16 = i3 * 3;
            } else {
                i16 = sampleDuration * 3;
            }
            if (currentTimeMillis > 100) {
                if (currentTimeMillis > i16) {
                    currentTimeMillis = i16;
                }
                int[] iArr = this.mSampleDuration;
                int i17 = this.mLastSampleIndex;
                iArr[i17] = (int) (currentTimeMillis * 1.2f);
                int i18 = i17 + 1;
                this.mLastSampleIndex = i18;
                this.mLastSampleIndex = i18 % 3;
            }
        }

        public int recordStart() {
            boolean z16;
            int i3;
            this.mStartingTime = System.currentTimeMillis();
            int activeNetworkType = NetworkUtil.getActiveNetworkType(AppLoaderFactory.g().getContext());
            if (this.mNetType != activeNetworkType) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mNetType = activeNetworkType;
            if (z16) {
                if (activeNetworkType == 2) {
                    i3 = this.m2GDuration;
                } else {
                    i3 = this.mNon2GDuration;
                }
                int i16 = i3;
                clearSampleDuration();
                return i16;
            }
            int sampleDuration = getSampleDuration();
            if (sampleDuration <= 0) {
                return 0;
            }
            return sampleDuration;
        }
    }

    /* loaded from: classes23.dex */
    private class MainThreadHandler extends Handler {
        public MainThreadHandler() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 200) {
                WebViewProgressBarController.this.refreshUI();
            }
        }
    }

    private void doRefreshUI() {
        long currentTimeMillis = System.currentTimeMillis();
        byte b16 = this.mStep;
        if (b16 != 0) {
            if (b16 != 1) {
                if (b16 != 2) {
                    if (b16 != 3) {
                        if (b16 != 4) {
                            if (b16 == 5) {
                                stepAccelerate(currentTimeMillis);
                                return;
                            }
                            return;
                        }
                        this.mCurrWidth = (this.mProgressBarWidth * this.mCurrentProgress) / 100.0f;
                        return;
                    }
                    float smoothUseTime = this.mCurrentProgress + (((float) smoothUseTime(currentTimeMillis - this.mStartLoadingTime)) * this.mProgressRate);
                    this.mCurrentProgress = smoothUseTime;
                    this.mStartLoadingTime = currentTimeMillis;
                    if (smoothUseTime >= 98.0f) {
                        this.mStartLoadingTime = currentTimeMillis;
                        this.mStep = (byte) 4;
                        this.mProgressRate = 0.0f;
                    }
                    this.mCurrWidth = (this.mProgressBarWidth * smoothUseTime) / 100.0f;
                    return;
                }
                long smoothUseTime2 = smoothUseTime(currentTimeMillis - this.mStartLoadingTime);
                float f16 = this.mCurrentProgress;
                float f17 = (float) smoothUseTime2;
                float f18 = this.mProgressRate;
                float f19 = f16 + (f17 * f18);
                this.mCurrentProgress = f19;
                this.mStartLoadingTime = currentTimeMillis;
                if (f19 >= PART_TWO_END_PROGRESS) {
                    this.mStartLoadingTime = currentTimeMillis;
                    this.mStep = (byte) 3;
                    this.mProgressRate = f18 / 20.0f;
                }
                this.mCurrWidth = (this.mProgressBarWidth * f19) / 100.0f;
                return;
            }
            float smoothUseTime3 = this.mCurrentProgress + (((float) smoothUseTime(currentTimeMillis - this.mStartLoadingTime)) * this.mProgressRate);
            this.mCurrentProgress = smoothUseTime3;
            this.mStartLoadingTime = currentTimeMillis;
            if (smoothUseTime3 >= 98.0f) {
                this.mStartLoadingTime = currentTimeMillis;
                this.mStep = (byte) 4;
                this.mCurrentProgress = 98.0f;
                this.mProgressRate = 0.0f;
            }
            this.mCurrWidth = (this.mProgressBarWidth * this.mCurrentProgress) / 100.0f;
            return;
        }
        long smoothUseTime4 = smoothUseTime(currentTimeMillis - this.mStartLoadingTime);
        float f26 = this.mCurrentProgress;
        float f27 = this.mProgressRate;
        float f28 = f26 + (((float) smoothUseTime4) * f27);
        this.mCurrentProgress = f28;
        this.mStartLoadingTime = currentTimeMillis;
        if (f28 >= 20.0f) {
            this.mStartLoadingTime = currentTimeMillis;
            this.mStep = (byte) 1;
            this.mProgressRate = f27 / 5.0f;
        }
        this.mCurrWidth = (this.mProgressBarWidth * f28) / 100.0f;
    }

    private long smoothUseTime(long j3) {
        if (j3 > 30) {
            return 30L;
        }
        return j3;
    }

    private void stepAccelerate(long j3) {
        float smoothUseTime = (float) smoothUseTime(j3 - this.mStartLoadingTime);
        float f16 = this.mCurrentProgress + (this.mProgressRate * smoothUseTime);
        this.mCurrentProgress = f16;
        this.mStartLoadingTime = j3;
        int i3 = this.mProgressBarWidth;
        float f17 = (i3 * f16) / 100.0f;
        this.mCurrWidth = f17;
        if (this.mFinishAllWidth) {
            if (f17 >= i3) {
                this.mCurrWidth = i3;
            }
        } else {
            int i16 = this.mAlpha - ((int) (smoothUseTime * this.mCurrAlphaRate));
            this.mAlpha = i16;
            if (i16 <= 0) {
                reset();
                this.mAlpha = 0;
            }
        }
    }

    public void enterStatus(byte b16) {
        if (b16 != 0) {
            if (b16 != 1) {
                if (b16 == 2) {
                    byte b17 = this.mStatus;
                    if (b17 == 0 || b17 == 1) {
                        performLoadingFinish();
                    }
                    this.mStatus = (byte) 2;
                    return;
                }
                return;
            }
            performPartOneFinish();
            return;
        }
        if (this.mStatus == 0) {
            return;
        }
        this.mStatus = (byte) 0;
        performLoadingStart();
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public byte getCurStatus() {
        return this.mStatus;
    }

    public float getCurrWidth() {
        return this.mCurrWidth;
    }

    public byte getLoadingStep() {
        return this.mStep;
    }

    public void performLoadingFinish() {
        DurationGenerator.getInstance(1).recordFinish();
        this.mStartLoadingTime = System.currentTimeMillis();
        this.mStep = (byte) 5;
        this.mProgressRate = 0.13333334f;
        float f16 = this.mCurrentProgress;
        if (f16 <= 60.0f) {
            this.mProgressRate = (((60.0f - f16) * 0.5f) + 40.0f) / 300.0f;
            this.mCurrAlphaRate = 0.81666666f;
        } else {
            this.mCurrAlphaRate = (0.13333334f * 245.0f) / (100.0f - f16);
        }
        refreshUI();
    }

    public void performLoadingStart() {
        int recordStart = DurationGenerator.getInstance(0).recordStart();
        if (recordStart <= 0) {
            recordStart = DurationGenerator.getInstance(0).getDefaultDuration();
        }
        this.mProgressRate = 20.0f / recordStart;
        this.mCurrentProgress = 0.0f;
        this.mStep = (byte) 0;
        this.mCurrWidth = this.mStartWidth;
        this.mAlpha = 255;
        this.mStartLoadingTime = System.currentTimeMillis();
        WebViewProgressBar webViewProgressBar = this.mProgressBar;
        if (webViewProgressBar != null) {
            webViewProgressBar.setVisibility(0);
        }
        refreshUI();
    }

    public void performPartOneFinish() {
        DurationGenerator.getInstance(0).recordFinish();
        int recordStart = DurationGenerator.getInstance(1).recordStart();
        if (recordStart <= 0) {
            recordStart = DurationGenerator.getInstance(1).getDefaultDuration();
        }
        this.mProgressRate = 60.0f / recordStart;
        this.mStartLoadingTime = System.currentTimeMillis();
        this.mStep = (byte) 2;
        this.mStatus = (byte) 1;
        refreshUI();
    }

    public void refreshUI() {
        if (this.mStep != 6) {
            if (this.mCurrentProgress >= 100.0f) {
                reset();
            } else {
                doRefreshUI();
            }
            this.mHandler.removeMessages(200);
            this.mHandler.sendEmptyMessageDelayed(200, 20L);
        }
        WebViewProgressBar webViewProgressBar = this.mProgressBar;
        if (webViewProgressBar != null) {
            webViewProgressBar.invalidate();
        }
    }

    public void reset() {
        this.mStep = (byte) 6;
        this.mCurrentProgress = 0.0f;
        this.mStartWidth = (int) ((0.0f * this.mProgressBarWidth) / 100.0f);
        this.mAlpha = 255;
        this.mStartLoadingTime = System.currentTimeMillis();
    }

    public void setProgressBar(WebViewProgressBar webViewProgressBar) {
        this.mProgressBar = webViewProgressBar;
    }

    public void setProgressBarWidth(int i3) {
        this.mProgressBarWidth = i3;
    }
}
