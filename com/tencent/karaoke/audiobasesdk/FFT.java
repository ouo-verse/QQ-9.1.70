package com.tencent.karaoke.audiobasesdk;

import com.tencent.component.utils.LogUtil;

/* compiled from: P */
/* loaded from: classes7.dex */
public class FFT {
    private static final String TAG = "FFT";
    private static boolean mIsLoaded = AudiobaseContext.loadLibrary();
    private boolean mIsValid = false;
    private long nativeHandle;

    private native int native_PowerSpectrum(int i3, float[] fArr, float[] fArr2);

    public int PowerSpectrum(int i3, float[] fArr, float[] fArr2) {
        if (mIsLoaded) {
            return native_PowerSpectrum(i3, fArr, fArr2);
        }
        LogUtil.e(TAG, "failed to load library");
        return -1;
    }
}
