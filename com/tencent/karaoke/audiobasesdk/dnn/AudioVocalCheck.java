package com.tencent.karaoke.audiobasesdk.dnn;

import com.tencent.karaoke.audiobasesdk.AudiobaseContext;

/* compiled from: P */
/* loaded from: classes7.dex */
public class AudioVocalCheck {
    public static final String TAG = "AudioVocalCheck";
    private static boolean mIsLoaded = AudiobaseContext.loadLibrary();
    private boolean mIsValid = false;
    private long nativeHandle;

    private native int[] native_fetchAccompanyChunks(byte[] bArr, int i3);

    private native void native_init(int i3, int i16, int i17, int i18);

    private native boolean native_isValidForDnnNoise(byte[] bArr, int i3, byte[] bArr2, int i16, String str);

    public int[] fetchAccompanyChunks(byte[] bArr, int i3) {
        if (mIsLoaded) {
            return native_fetchAccompanyChunks(bArr, i3);
        }
        return null;
    }

    public void init(int i3, int i16, int i17, int i18) {
        if (mIsLoaded) {
            native_init(i3, i16, i17, i18);
            this.mIsValid = true;
        }
    }

    public boolean isValidForDnnNoise(byte[] bArr, int i3, byte[] bArr2, int i16, String str) {
        if (mIsLoaded) {
            return native_isValidForDnnNoise(bArr, i3, bArr2, i16, str);
        }
        return false;
    }

    public void uninit() {
        this.mIsValid = false;
    }
}
