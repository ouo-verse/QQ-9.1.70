package com.tencent.qqmusic.mediaplayer;

import android.content.Context;
import android.os.Process;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.lang.ref.WeakReference;

/* loaded from: classes23.dex */
public class PlayerConfigManager {
    private static final int ADD = 1;
    private static final int DTS_COST_THRESHOLD = 40;
    private static boolean ENABLE_CHANGE_THREAD_PRIORITY = false;
    private static final boolean ENABLE_REAL_CHECK = true;
    private static final int MAX_RATIO = 4;
    private static final int MAX_TIMES = 10;
    private static final int MIN_RATIO = 8;
    private static final int NONE = 0;
    private static final int SUB = -1;
    private static final String TAG = "PlayerConfigManager";
    private static PlayerConfigManager mInstance;
    private int count;
    private int mBufRatio;
    private long mLastDecodeSpeed;
    private long mStartTime;
    private ContextGetter contextGetter = null;
    private long mPlaySpeed = 1;
    private int mAddPriority = 0;
    private int mProcessorNumber = Runtime.getRuntime().availableProcessors();
    private WeakReference<CorePlayer> mCommonPlayerRef = null;
    private int[] THREAD_PRIORITY = {19, 10, -2, -4, -8, -16, -19};
    private int mCurrPriorityIndex = 0;

    /* loaded from: classes23.dex */
    public interface ContextGetter {
        Context getContext();
    }

    PlayerConfigManager() {
        this.mBufRatio = 4;
        this.count = 0;
        this.mStartTime = 0L;
        this.mBufRatio = 4;
        this.count = 0;
        this.mStartTime = 0L;
    }

    private boolean add() {
        if (this.mAddPriority >= 1) {
            return true;
        }
        return false;
    }

    public static synchronized PlayerConfigManager getInstance() {
        PlayerConfigManager playerConfigManager;
        synchronized (PlayerConfigManager.class) {
            if (mInstance == null) {
                mInstance = new PlayerConfigManager();
            }
            playerConfigManager = mInstance;
        }
        return playerConfigManager;
    }

    private boolean sub() {
        if (this.mAddPriority < -1) {
            return true;
        }
        return false;
    }

    public void calDTSCostEnd() {
        if (this.mBufRatio != 8 && System.currentTimeMillis() - this.mStartTime > 40) {
            int i3 = this.count + 1;
            this.count = i3;
            if (i3 > 10) {
                this.mBufRatio *= 2;
                this.count = 0;
            }
        }
    }

    public void calDTSCostStart() {
        if (this.mBufRatio == 8) {
            return;
        }
        this.mStartTime = System.currentTimeMillis();
    }

    public void changeDecodeThreadPriority() {
        CorePlayer corePlayer;
        WeakReference<CorePlayer> weakReference = this.mCommonPlayerRef;
        if (weakReference != null && (corePlayer = weakReference.get()) != null) {
            corePlayer.changePlayThreadPriorityImmediately();
        }
    }

    public void changeDecodeThreadPriorityIfNeed() {
        try {
            int i3 = this.mCurrPriorityIndex;
            int i16 = this.THREAD_PRIORITY[r2.length - 1];
            if (isSingleCpuOrScreenOff() && ENABLE_CHANGE_THREAD_PRIORITY) {
                if (add()) {
                    i3++;
                } else if (sub()) {
                    i3--;
                }
                if (i3 == this.mCurrPriorityIndex && i3 >= 0 && i3 < this.THREAD_PRIORITY.length) {
                    Logger.i(TAG, "changeDecodeThreadPriorityIfNeed don't change Priority mCurrPriorityIndex = " + this.THREAD_PRIORITY[this.mCurrPriorityIndex]);
                    return;
                }
                if (i3 < 0) {
                    i3 = 0;
                } else {
                    int[] iArr = this.THREAD_PRIORITY;
                    if (i3 >= iArr.length) {
                        i3 = iArr.length - 1;
                    }
                }
                this.mCurrPriorityIndex = i3;
                int i17 = this.THREAD_PRIORITY[i3];
                this.mAddPriority = 0;
            } else {
                int i18 = this.THREAD_PRIORITY[r1.length - 1];
            }
            Process.setThreadPriority(0);
        } catch (Throwable th5) {
            Logger.e(TAG, th5);
        }
    }

    public int getBufRatio() {
        int i3 = this.mBufRatio;
        if (i3 <= 1) {
            this.mBufRatio = 4;
        } else if (i3 > 8) {
            this.mBufRatio = 8;
        }
        Logger.i(TAG, "getBufRatio = " + this.mBufRatio);
        this.count = 0;
        return this.mBufRatio;
    }

    public Context getContext() {
        ContextGetter contextGetter = this.contextGetter;
        if (contextGetter != null) {
            return contextGetter.getContext();
        }
        return null;
    }

    public boolean isSingleCpuOrScreenOff() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.mProcessorNumber = availableProcessors;
        if (availableProcessors <= 1) {
            return true;
        }
        return false;
    }

    public void setCommonPlayerRef(CorePlayer corePlayer) {
        if (corePlayer != null) {
            this.mCommonPlayerRef = new WeakReference<>(corePlayer);
            this.mCurrPriorityIndex = 0;
            this.mAddPriority = 0;
            AudioInformation currentAudioInformation = corePlayer.getCurrentAudioInformation();
            if (currentAudioInformation != null) {
                this.mPlaySpeed = ((float) ((currentAudioInformation.getSampleRate() * 2) * currentAudioInformation.getChannels())) / 1000.0f;
                Logger.i(TAG, "setCommonPlayerRef info = " + currentAudioInformation + ",mPlaySpeed = " + this.mPlaySpeed);
            }
        }
    }

    public void setContextGetter(ContextGetter contextGetter) {
        this.contextGetter = contextGetter;
    }
}
