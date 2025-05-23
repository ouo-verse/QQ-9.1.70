package com.tencent.mobileqq.mini.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.mini.util.HttpUtil;

/* loaded from: classes33.dex */
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
    /* loaded from: classes33.dex */
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

        public void recordFinish() {
            int i3;
            int currentTimeMillis = (int) (System.currentTimeMillis() - this.mStartingTime);
            int sampleDuration = getSampleDuration();
            if (this.mNetType == 2) {
                i3 = this.m2GDuration;
            } else {
                i3 = this.mNon2GDuration;
            }
            int i16 = sampleDuration == 0 ? i3 * 3 : sampleDuration * 3;
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
            int i3;
            this.mStartingTime = System.currentTimeMillis();
            int netWorkType = HttpUtil.getNetWorkType();
            boolean z16 = this.mNetType != netWorkType;
            this.mNetType = netWorkType;
            if (z16) {
                if (netWorkType == 2) {
                    i3 = this.m2GDuration;
                } else {
                    i3 = this.mNon2GDuration;
                }
                int i16 = i3;
                clearSampleDuration();
                return i16;
            }
            int sampleDuration = getSampleDuration();
            if (sampleDuration > 0) {
                return sampleDuration;
            }
            return 0;
        }

        public int getDefaultDuration() {
            if (2 == this.mNetType) {
                return this.m2GDuration;
            }
            return this.mNon2GDuration;
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

        private void clearSampleDuration() {
            for (int i3 = 0; i3 < 3; i3++) {
                this.mSampleDuration[i3] = 0;
            }
            this.mLastSampleIndex = 0;
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
            if (i3 > 0) {
                return i16 / i3;
            }
            return 0;
        }
    }

    /* loaded from: classes33.dex */
    private class MainThreadHandler extends Handler {
        public MainThreadHandler() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 200) {
                return;
            }
            WebViewProgressBarController.this.refreshUI();
        }
    }

    /* loaded from: classes33.dex */
    interface NetType {
        public static final int CABLE = 5;
        public static final int G2 = 2;
        public static final int G3 = 3;
        public static final int G4 = 4;
        public static final int NONE = 0;
        public static final int WIFI = 1;
    }

    private long smoothUseTime(long j3) {
        if (j3 > 30) {
            return 30L;
        }
        return j3;
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

    public void refreshUI() {
        if (this.mStep != 6) {
            long currentTimeMillis = System.currentTimeMillis();
            float f16 = this.mCurrentProgress;
            if (f16 >= 100.0f) {
                reset();
            } else {
                byte b16 = this.mStep;
                if (b16 == 0) {
                    long smoothUseTime = smoothUseTime(currentTimeMillis - this.mStartLoadingTime);
                    float f17 = this.mCurrentProgress;
                    float f18 = (float) smoothUseTime;
                    float f19 = this.mProgressRate;
                    float f26 = f17 + (f18 * f19);
                    this.mCurrentProgress = f26;
                    this.mStartLoadingTime = currentTimeMillis;
                    if (f26 >= 20.0f) {
                        this.mStartLoadingTime = currentTimeMillis;
                        this.mStep = (byte) 1;
                        this.mProgressRate = f19 / 5.0f;
                    }
                    this.mCurrWidth = (this.mProgressBarWidth * f26) / 100.0f;
                } else if (b16 == 1) {
                    float smoothUseTime2 = this.mCurrentProgress + (((float) smoothUseTime(currentTimeMillis - this.mStartLoadingTime)) * this.mProgressRate);
                    this.mCurrentProgress = smoothUseTime2;
                    this.mStartLoadingTime = currentTimeMillis;
                    if (smoothUseTime2 >= 98.0f) {
                        this.mStartLoadingTime = currentTimeMillis;
                        this.mStep = (byte) 4;
                        this.mCurrentProgress = 98.0f;
                        this.mProgressRate = 0.0f;
                    }
                    this.mCurrWidth = (this.mProgressBarWidth * this.mCurrentProgress) / 100.0f;
                } else if (b16 == 2) {
                    long smoothUseTime3 = smoothUseTime(currentTimeMillis - this.mStartLoadingTime);
                    float f27 = this.mCurrentProgress;
                    float f28 = (float) smoothUseTime3;
                    float f29 = this.mProgressRate;
                    float f36 = f27 + (f28 * f29);
                    this.mCurrentProgress = f36;
                    this.mStartLoadingTime = currentTimeMillis;
                    if (f36 >= PART_TWO_END_PROGRESS) {
                        this.mStartLoadingTime = currentTimeMillis;
                        this.mStep = (byte) 3;
                        this.mProgressRate = f29 / 20.0f;
                    }
                    this.mCurrWidth = (this.mProgressBarWidth * f36) / 100.0f;
                } else if (b16 == 3) {
                    float smoothUseTime4 = this.mCurrentProgress + (((float) smoothUseTime(currentTimeMillis - this.mStartLoadingTime)) * this.mProgressRate);
                    this.mCurrentProgress = smoothUseTime4;
                    this.mStartLoadingTime = currentTimeMillis;
                    if (smoothUseTime4 >= 98.0f) {
                        this.mStartLoadingTime = currentTimeMillis;
                        this.mStep = (byte) 4;
                        this.mProgressRate = 0.0f;
                    }
                    this.mCurrWidth = (this.mProgressBarWidth * smoothUseTime4) / 100.0f;
                } else if (b16 == 4) {
                    this.mCurrWidth = (this.mProgressBarWidth * f16) / 100.0f;
                } else if (b16 == 5) {
                    float smoothUseTime5 = (float) smoothUseTime(currentTimeMillis - this.mStartLoadingTime);
                    float f37 = this.mCurrentProgress + (this.mProgressRate * smoothUseTime5);
                    this.mCurrentProgress = f37;
                    this.mStartLoadingTime = currentTimeMillis;
                    int i3 = this.mProgressBarWidth;
                    float f38 = (i3 * f37) / 100.0f;
                    this.mCurrWidth = f38;
                    if (!this.mFinishAllWidth) {
                        int i16 = this.mAlpha - ((int) (smoothUseTime5 * this.mCurrAlphaRate));
                        this.mAlpha = i16;
                        if (i16 <= 0) {
                            reset();
                            this.mAlpha = 0;
                        }
                    } else if (f38 >= i3) {
                        this.mCurrWidth = i3;
                    }
                }
            }
            this.mHandler.removeMessages(200);
            this.mHandler.sendEmptyMessageDelayed(200, 20L);
        }
        WebViewProgressBar webViewProgressBar = this.mProgressBar;
        if (webViewProgressBar != null) {
            webViewProgressBar.invalidate();
        }
    }

    public void setProgressBar(WebViewProgressBar webViewProgressBar) {
        this.mProgressBar = webViewProgressBar;
    }

    public void setProgressBarWidth(int i3) {
        this.mProgressBarWidth = i3;
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

    public void reset() {
        this.mStep = (byte) 6;
        this.mCurrentProgress = 0.0f;
        this.mStartWidth = (int) ((0.0f * this.mProgressBarWidth) / 100.0f);
        this.mAlpha = 255;
        this.mStartLoadingTime = System.currentTimeMillis();
    }

    public void enterStatus(byte b16) {
        if (b16 == 0) {
            if (this.mStatus == 0) {
                return;
            }
            this.mStatus = (byte) 0;
            performLoadingStart();
            return;
        }
        if (b16 == 1) {
            performPartOneFinish();
            return;
        }
        if (b16 != 2) {
            return;
        }
        byte b17 = this.mStatus;
        if (b17 == 0 || b17 == 1) {
            performLoadingFinish();
        }
        this.mStatus = (byte) 2;
    }
}
