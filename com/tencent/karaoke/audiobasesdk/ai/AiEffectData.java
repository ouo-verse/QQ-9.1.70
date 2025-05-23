package com.tencent.karaoke.audiobasesdk.ai;

import android.text.TextUtils;
import com.tencent.component.utils.LogUtil;
import com.tencent.karaoke.audiobasesdk.AudiobaseContext;
import com.tencent.karaoke.audiobasesdk.audiofx.AudioAiParamsEntity;

/* compiled from: P */
/* loaded from: classes7.dex */
public class AiEffectData {
    private static final String TAG = "AiEffectData";
    private static volatile boolean mIsLoaded = AudiobaseContext.loadLibrary();

    private native int native_AiParams_operatation(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, float[] fArr5, float[] fArr6, float[] fArr7, float[] fArr8, float[] fArr9, float[] fArr10);

    private native String native_getCurParam(int i3, int i16);

    private native int native_setAIParamsValue(byte[] bArr, String str, String str2, int i3);

    private native int native_setNativeParamsValue(int[] iArr, float[] fArr);

    public synchronized String getCurAiParams() {
        if (!mIsLoaded) {
            LogUtil.e(TAG, "load library failed");
            return "";
        }
        return native_getCurParam(0, 0);
    }

    public synchronized AudioAiParamsEntity operateAiParams() {
        LogUtil.d(TAG, "operateAiParams");
        if (!mIsLoaded) {
            LogUtil.e(TAG, "load library failed");
            return new AudioAiParamsEntity();
        }
        float[] fArr = new float[10];
        float[] fArr2 = new float[10];
        float[] fArr3 = new float[10];
        float[] fArr4 = new float[10];
        float[] fArr5 = new float[16];
        float[] fArr6 = new float[10];
        AudioAiParamsEntity audioAiParamsEntity = new AudioAiParamsEntity();
        audioAiParamsEntity.f116942id = native_AiParams_operatation(new float[1], fArr, fArr2, fArr3, fArr4, fArr5, fArr6, new float[1], new float[1], new float[1]);
        audioAiParamsEntity.mReverb = fArr;
        audioAiParamsEntity.mCompressor = fArr2;
        audioAiParamsEntity.mEq = fArr3;
        audioAiParamsEntity.mObbEq = fArr4;
        audioAiParamsEntity.mBEq = fArr5;
        audioAiParamsEntity.mCommand = fArr6;
        return audioAiParamsEntity;
    }

    public synchronized int setAiParams(byte[] bArr, String str, String str2, int i3) {
        LogUtil.i(TAG, "setAiParams");
        if (!mIsLoaded) {
            LogUtil.e(TAG, "load library failed");
            return -1;
        }
        if (bArr != null && bArr.length != 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str2.length() < 4) {
                str2 = str2 + "0000";
            }
            return native_setAIParamsValue(bArr, str, str2, i3);
        }
        LogUtil.e(TAG, "param is error !!!");
        return -1;
    }

    public synchronized int setNativeParamsValue(int[] iArr, float[] fArr) {
        LogUtil.i(TAG, "setNativeParamsValue");
        if (!mIsLoaded) {
            LogUtil.e(TAG, "load library failed");
            return -1;
        }
        return native_setNativeParamsValue(iArr, fArr);
    }
}
