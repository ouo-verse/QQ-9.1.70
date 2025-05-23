package com.tencent.karaoke.audiobasesdk.commom;

import android.util.Log;
import com.tencent.component.utils.LogUtil;
import com.tencent.karaoke.audiobasesdk.AudiobaseContext;

/* loaded from: classes7.dex */
public class PublicPitchProcessor {
    private static final String TAG = "PublicPitchProcessor";
    private static boolean mIsLoaded = AudiobaseContext.loadLibrary();
    private long mAiScoreHandle;
    private long nativeHandle;
    private boolean mIsValid = false;
    private boolean mIsMarkAsFinished = false;

    private native float[][] native_GetAllRealTimePitchs();

    private native float[][] native_GetCurPitchs();

    private native float[][] native_GetNonRealTimePitchs();

    private native int native_MarkAsFinished();

    private native int native_Process(byte[] bArr, int i3, float f16);

    private native int native_SetPitchDetectionSwitch(boolean z16, boolean z17);

    private native int native_StopNonRealTimeProcess();

    private native void native_UnInitAiScore(long j3);

    private native long native_external_native_handle_id();

    private native int native_getAiScore(long j3);

    private native float[] native_getPitchAlian10ms();

    private native float[] native_getPitchAlian5ms();

    private native int native_init(int i3, int i16);

    private native long native_initAiScore(String str);

    private native int native_uninit();

    public float[][] GetAllRealTimePitchs() {
        if (this.mIsValid) {
            return native_GetAllRealTimePitchs();
        }
        return null;
    }

    public float[][] GetCurPitchs() {
        if (this.mIsValid) {
            return native_GetCurPitchs();
        }
        return null;
    }

    public float[][] GetNonRealTimePitchs() {
        if (this.mIsValid) {
            return native_GetNonRealTimePitchs();
        }
        return null;
    }

    public synchronized int MarkAsFinished() {
        if (this.mIsValid && !this.mIsMarkAsFinished) {
            int native_MarkAsFinished = native_MarkAsFinished();
            LogUtil.i(TAG, "MarkAsFinished");
            if (native_MarkAsFinished == 0) {
                this.mIsMarkAsFinished = true;
            }
            return native_MarkAsFinished;
        }
        if (this.mIsMarkAsFinished) {
            LogUtil.i(TAG, "MarkAsFinished: has finish before");
            return 0;
        }
        return -1;
    }

    public int Process(byte[] bArr, int i3, float f16) {
        if (this.mIsValid) {
            return native_Process(bArr, i3, f16);
        }
        return -1;
    }

    public int SetPitchDetectionSwitch(Boolean bool, Boolean bool2) {
        if (this.mIsValid) {
            return native_SetPitchDetectionSwitch(bool.booleanValue(), bool2.booleanValue());
        }
        return -1;
    }

    public synchronized int StopNonRealTimeProcess() {
        if (this.mIsValid) {
            int native_StopNonRealTimeProcess = native_StopNonRealTimeProcess();
            if (native_StopNonRealTimeProcess == 0) {
                this.mIsValid = false;
                LogUtil.i(TAG, "StopNonRealTimeProcess: success");
            }
            return native_StopNonRealTimeProcess;
        }
        return -1;
    }

    public int getAiScore() {
        long j3 = this.mAiScoreHandle;
        if (j3 != 0) {
            return native_getAiScore(j3);
        }
        LogUtil.w(TAG, "getAiScore -> score handle is 0");
        return -1;
    }

    @Deprecated
    public long getExternalNativeHandleId() {
        return 0L;
    }

    public float[] getPitchsAlign10ms() {
        if (this.mIsValid) {
            return native_getPitchAlian10ms();
        }
        return null;
    }

    public float[] getPitchsAlign5ms() {
        if (this.mIsValid) {
            return native_getPitchAlian5ms();
        }
        return null;
    }

    public int init(int i3, int i16) {
        boolean z16;
        if (mIsLoaded) {
            LogUtil.i(TAG, "first unit");
            unInit();
            LogUtil.i(TAG, "then init: ");
            int native_init = native_init(i3, i16);
            if (native_init == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mIsValid = z16;
            if (!z16) {
                Log.w(TAG, "init: failed,ret=" + native_init);
            }
            this.mIsMarkAsFinished = false;
            return native_init;
        }
        LogUtil.i(TAG, "init: load so fail");
        return -1;
    }

    public boolean initAiScore(String str) {
        if (mIsLoaded) {
            LogUtil.i(TAG, "init: ");
            long native_initAiScore = native_initAiScore(str);
            this.mAiScoreHandle = native_initAiScore;
            if (native_initAiScore == 0) {
                return false;
            }
            return true;
        }
        LogUtil.i(TAG, "init: load so fail");
        return false;
    }

    public void unInit() {
        if (this.mIsValid) {
            if (this.mAiScoreHandle != 0) {
                LogUtil.i(TAG, "unInit -> UnInitAiScore");
                native_UnInitAiScore(this.mAiScoreHandle);
                this.mAiScoreHandle = 0L;
            }
            if (native_uninit() == 0) {
                LogUtil.i(TAG, "unInit: success");
            }
            this.mIsValid = false;
        }
    }
}
