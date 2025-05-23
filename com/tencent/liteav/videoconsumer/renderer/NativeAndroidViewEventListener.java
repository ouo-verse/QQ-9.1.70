package com.tencent.liteav.videoconsumer.renderer;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.rtmp.ui.AndroidViewEventListener;

/* compiled from: P */
@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public class NativeAndroidViewEventListener implements AndroidViewEventListener {
    private long mNativeHandler;

    public NativeAndroidViewEventListener(long j3) {
        this.mNativeHandler = j3;
    }

    private static native void nativeOnTap(long j3, int i3, int i16, int i17, int i18);

    private static native void nativeOnZoom(long j3, float f16);

    private static native void nativeonSizeChanged(long j3, int i3, int i16, int i17, int i18);

    @Override // com.tencent.rtmp.ui.AndroidViewEventListener
    public synchronized void onSizeChanged(int i3, int i16, int i17, int i18) {
        long j3 = this.mNativeHandler;
        if (j3 != 0) {
            nativeonSizeChanged(j3, i3, i16, i17, i18);
        }
    }

    @Override // com.tencent.rtmp.ui.AndroidViewEventListener
    public synchronized void onTap(int i3, int i16, int i17, int i18) {
        long j3 = this.mNativeHandler;
        if (j3 != 0) {
            nativeOnTap(j3, i3, i16, i17, i18);
        }
    }

    @Override // com.tencent.rtmp.ui.AndroidViewEventListener
    public synchronized void onZoom(float f16) {
        long j3 = this.mNativeHandler;
        if (j3 != 0) {
            nativeOnZoom(j3, f16);
        }
    }

    public synchronized void resetNativeHandle() {
        this.mNativeHandler = 0L;
    }
}
