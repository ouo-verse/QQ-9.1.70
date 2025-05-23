package com.tencent.ttpic.audio;

import com.tencent.ttpic.logic.watermark.DecibelDetector;

/* compiled from: P */
/* loaded from: classes27.dex */
public enum LocalAudioDataManager {
    INSTANCE;

    private static final int DECIBEL_UPDATE_INTERVAL = 500;
    private static final String TAG = LocalAudioDataManager.class.getSimpleName();
    private int mDecibel;
    private boolean mNeedDecibel = false;
    private long mDecibelUpdateTimestamp = 0;
    private boolean mUseDecibelFromCameraRecorder = false;

    LocalAudioDataManager() {
    }

    private int adjustDB(int i3) {
        return (int) ((i3 * 0.65d) + 40.0d);
    }

    public static LocalAudioDataManager getInstance() {
        return INSTANCE;
    }

    public void destroy() {
        destroyDecibelDetector();
    }

    public void destroyDecibelDetector() {
        DecibelDetector.getInstance().destroy();
    }

    public String getDB() {
        if (!this.mUseDecibelFromCameraRecorder) {
            DecibelDetector.getInstance().init();
            int decibel = DecibelDetector.getInstance().getDecibel();
            if (decibel != 0) {
                setDecibel(decibel);
            }
        }
        return String.valueOf(adjustDB(this.mDecibel));
    }

    public boolean needDecibel() {
        return this.mNeedDecibel;
    }

    public void reset() {
        this.mNeedDecibel = false;
        this.mUseDecibelFromCameraRecorder = false;
        this.mDecibelUpdateTimestamp = 0L;
    }

    public void setDecibel(int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mDecibelUpdateTimestamp > 500) {
            this.mDecibel = i3;
            this.mDecibelUpdateTimestamp = currentTimeMillis;
        }
    }

    public void setDecibelFromCameraRecorder(boolean z16) {
        this.mUseDecibelFromCameraRecorder = z16;
    }

    public void setNeedDB(boolean z16) {
        this.mNeedDecibel = z16;
    }
}
