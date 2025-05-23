package com.tencent.karaoke.audiobasesdk;

import com.tencent.component.utils.LogUtil;

/* compiled from: P */
@Deprecated
/* loaded from: classes7.dex */
public class KaraScoreForKtv {
    private static final String TAG = "KaraScoreForKtv";
    private static boolean mIsLoaded = AudiobaseContext.loadLibrary();
    private boolean mIsValid = false;
    private long nativeHandle;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class ScoreType {
        public static final int SCORE_TYPE_ACF = 0;
        public static final int SCORE_TYPE_MIX = 2;
        public static final int SCORE_TYPE_PYIN = 1;
    }

    private native int native_SetRecordEndTime(int i3);

    private native int native_destory();

    private native NoteItem[] native_getAllGrove();

    private native int[] native_getAllScore();

    private native int[] native_getGroveAndHit();

    private native int native_getLastScore();

    private native int native_getTotalScore();

    private native int native_getValidSentenceNum();

    private native int native_init(byte[] bArr, int[] iArr, int[] iArr2, int i3, int i16, int i17);

    private native int native_score(byte[] bArr, int i3, float f16);

    private native int native_seek(float f16);

    private native void native_setPitch(int i3);

    private native int native_setScoreRatio(float f16);

    private native int native_setSpeakerOriginal(boolean z16);

    public synchronized int destory() {
        if (this.mIsValid) {
            this.mIsValid = false;
            return native_destory();
        }
        LogUtil.w(TAG, "KaraScore invalid");
        return 0;
    }

    public synchronized NoteItem[] getAllGrove() {
        if (this.mIsValid) {
            return native_getAllGrove();
        }
        LogUtil.w(TAG, "KaraScore invalid");
        return null;
    }

    public synchronized int[] getAllScore() {
        if (this.mIsValid) {
            return native_getAllScore();
        }
        LogUtil.w(TAG, "KaraScore invalid");
        return null;
    }

    public synchronized int[] getGroveAndHit() {
        if (this.mIsValid) {
            return native_getGroveAndHit();
        }
        LogUtil.w(TAG, "KaraScore invalid");
        return null;
    }

    public synchronized int getLastScore() {
        if (this.mIsValid) {
            return native_getLastScore();
        }
        LogUtil.w(TAG, "KaraScore invalid");
        return -1;
    }

    public synchronized int getTotalScore() {
        if (this.mIsValid) {
            return native_getTotalScore();
        }
        LogUtil.w(TAG, "KaraScore invalid");
        return -1;
    }

    public synchronized int getValidSentenceNum() {
        if (this.mIsValid) {
            return native_getValidSentenceNum();
        }
        LogUtil.w(TAG, "KaraScore invalid");
        return -1;
    }

    public synchronized int init(byte[] bArr, int[] iArr, int[] iArr2, int i3, int i16, int i17) {
        int i18;
        boolean z16;
        if (mIsLoaded) {
            if (bArr != null && iArr != null) {
                i18 = native_init(bArr, iArr, iArr2, i3, i16, i17);
            } else {
                i18 = -2;
            }
            if (i18 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mIsValid = z16;
            return i18;
        }
        LogUtil.w(TAG, "KaraScore invalid");
        return -1;
    }

    public synchronized int score(byte[] bArr, int i3, float f16) {
        if (this.mIsValid) {
            return native_score(bArr, i3, f16);
        }
        LogUtil.w(TAG, "KaraScore invalid");
        return -1;
    }

    public synchronized int seek(float f16) {
        if (this.mIsValid) {
            return native_seek(f16);
        }
        LogUtil.w(TAG, "KaraScore invalid");
        return -1;
    }

    public synchronized void setPitch(int i3) {
        if (this.mIsValid) {
            native_setPitch(i3);
        } else {
            LogUtil.w(TAG, "KaraScore invalid");
        }
    }

    public synchronized void setRecordEndTime(int i3) {
        if (this.mIsValid) {
            native_SetRecordEndTime(i3);
        } else {
            LogUtil.w(TAG, "KaraScore invalid");
        }
    }

    public synchronized int setScoreRatio(float f16) {
        if (this.mIsValid) {
            return native_setScoreRatio(f16);
        }
        return -1;
    }

    public synchronized int setSpeakerOriginal(boolean z16) {
        if (this.mIsValid) {
            if (z16) {
                setScoreRatio(0.8f);
            }
            return native_setSpeakerOriginal(z16);
        }
        LogUtil.w(TAG, "KaraScore invalid");
        return -1;
    }
}
