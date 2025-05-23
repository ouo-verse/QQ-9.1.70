package com.tencent.karaoke.audiobasesdk.segment;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MediaSingSegmentNative {
    private long nativeHandle;

    /* JADX INFO: Access modifiers changed from: protected */
    public native SingSegmentData[] fetchSingSegmentList();

    /* JADX INFO: Access modifiers changed from: protected */
    public native void finish();

    /* JADX INFO: Access modifiers changed from: protected */
    public native boolean init(int i3, int i16);

    /* JADX INFO: Access modifiers changed from: protected */
    public native boolean process(byte[] bArr, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public native void uninit();
}
