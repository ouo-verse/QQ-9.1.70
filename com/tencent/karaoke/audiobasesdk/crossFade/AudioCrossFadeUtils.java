package com.tencent.karaoke.audiobasesdk.crossFade;

/* compiled from: P */
/* loaded from: classes7.dex */
public class AudioCrossFadeUtils {
    private long nativeHandle;

    /* JADX INFO: Access modifiers changed from: protected */
    public native float GetFirstPcmWeight();

    /* JADX INFO: Access modifiers changed from: protected */
    public native int GetLastError();

    /* JADX INFO: Access modifiers changed from: protected */
    public native float GetSecondPcmWeight();

    /* JADX INFO: Access modifiers changed from: protected */
    public native boolean ProcessConcat(byte[] bArr, int i3, byte[] bArr2, int i16, byte[] bArr3, int[] iArr);

    /* JADX INFO: Access modifiers changed from: protected */
    public native boolean ProcessFadeIn(byte[] bArr, int i3, byte[] bArr2, int[] iArr);

    /* JADX INFO: Access modifiers changed from: protected */
    public native boolean SetConcatLen(int i3, int i16);

    /* JADX INFO: Access modifiers changed from: protected */
    public native boolean SetConcatMs(int i3, int i16);

    /* JADX INFO: Access modifiers changed from: protected */
    public native boolean SetFadeInMs(int i3, int i16);

    /* JADX INFO: Access modifiers changed from: protected */
    public native boolean SetFastFadeInMode(boolean z16);

    /* JADX INFO: Access modifiers changed from: protected */
    public native boolean SetSeekFadeInMs(int i3, int i16);

    /* JADX INFO: Access modifiers changed from: protected */
    public native boolean init(int i3, int i16);

    /* JADX INFO: Access modifiers changed from: protected */
    public native boolean resetConcat();

    /* JADX INFO: Access modifiers changed from: protected */
    public native void uninit();
}
