package com.tencent.karaoke.audiobasesdk;

import com.tencent.component.utils.LogUtil;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes7.dex */
public class AudioSingClearScore {
    public static final int CODE_SUCCESS = 0;
    private static final String TAG = "AudioSingClearScore";
    private OnScoreListener mOnScoreListener = null;
    private long nativeHandle;
    private static final AtomicBoolean ALL_SENTENCES_COMPLETED = new AtomicBoolean(false);
    private static final AtomicBoolean HAS_INIT = new AtomicBoolean(false);
    private static boolean mIsLoaded = AudiobaseContext.loadLibrary();

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface OnScoreListener {
        void onFinish(int i3, int[] iArr);

        void onSentenceUpdate(int i3, int i16, int i17);
    }

    private native int[] native_getScoreResults();

    private native boolean native_init(String str, String str2, int i3, int i16);

    private native void native_markAsFinished();

    private native int native_process(byte[] bArr, int i3, int[] iArr);

    private native int native_seek(int i3);

    private native boolean native_setValidSentenceFlags(int[] iArr);

    private native void native_unInit();

    public int[] getScoreResults() {
        if (!HAS_INIT.get()) {
            LogUtil.e(TAG, "getScoreResults ERROR: has not init, or init get error!");
            return null;
        }
        return native_getScoreResults();
    }

    public boolean initScore(String str, String str2, int i3, int i16, OnScoreListener onScoreListener) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("initScore() enter. HAS_INIT:");
        AtomicBoolean atomicBoolean = HAS_INIT;
        sb5.append(atomicBoolean.get());
        sb5.append(" mIsLoaded:");
        sb5.append(mIsLoaded);
        sb5.append(" sampleRate:");
        sb5.append(i3);
        sb5.append(" channels:");
        sb5.append(i16);
        LogUtil.i(TAG, sb5.toString());
        if (atomicBoolean.get()) {
            LogUtil.e(TAG, "initScore ERROR: Last progress is running! First to uninit()...");
            unInit();
        }
        if (!mIsLoaded) {
            LogUtil.e(TAG, "initScore ERROR:so load error! return...");
            return false;
        }
        this.mOnScoreListener = onScoreListener;
        boolean native_init = native_init(str, str2, i3, i16);
        LogUtil.i(TAG, "initScore result: " + native_init);
        if (!native_init) {
            LogUtil.e(TAG, "initScore ERROR: initScore get error!");
        }
        atomicBoolean.set(native_init);
        return native_init;
    }

    public boolean isAllSentencesCompleted() {
        return ALL_SENTENCES_COMPLETED.get();
    }

    public boolean isEnabled() {
        return HAS_INIT.get();
    }

    public void markAsFinished() {
        if (!HAS_INIT.get()) {
            LogUtil.e(TAG, "markAsFinished ERROR: has not init, or init get error!");
            return;
        }
        native_markAsFinished();
        ALL_SENTENCES_COMPLETED.set(true);
        OnScoreListener onScoreListener = this.mOnScoreListener;
        if (onScoreListener != null) {
            onScoreListener.onFinish(0, getScoreResults());
        } else {
            LogUtil.i(TAG, "markAsFinished ERROR: OnScoreListener is null!");
        }
        LogUtil.i(TAG, "markAsFinished end!");
    }

    public int process(byte[] bArr, int i3) {
        if (!HAS_INIT.get()) {
            return -1;
        }
        int[] iArr = {-1};
        int native_process = native_process(bArr, i3, iArr);
        OnScoreListener onScoreListener = this.mOnScoreListener;
        if (onScoreListener != null && -1 != native_process) {
            if (native_process >= 0) {
                onScoreListener.onSentenceUpdate(native_process, iArr[0], 0);
            } else {
                onScoreListener.onSentenceUpdate(0, iArr[0], native_process);
            }
        }
        return native_process;
    }

    public int seek(int i3) {
        LogUtil.i(TAG, "seek:" + i3);
        if (!HAS_INIT.get()) {
            LogUtil.e(TAG, "seek ERROR: has not init, or init get error!");
            return -1;
        }
        return native_seek(i3);
    }

    public boolean setValidSentenceFlags(int[] iArr) {
        LogUtil.i(TAG, "setValidSentenceFlags enter");
        if (!HAS_INIT.get()) {
            LogUtil.e(TAG, "setValidSentenceFlags ERROR: has not init, or init get error!");
            return false;
        }
        return native_setValidSentenceFlags(iArr);
    }

    public void unInit() {
        native_unInit();
        HAS_INIT.set(false);
        ALL_SENTENCES_COMPLETED.set(false);
        this.mOnScoreListener = null;
        LogUtil.i(TAG, "unInit end!");
    }
}
