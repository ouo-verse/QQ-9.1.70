package com.gyailib.library;

import android.graphics.Bitmap;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GYAISmile {
    private long nativePtr;

    public native int deinit();

    public native int detect(Bitmap bitmap, int i3, int i16, int i17, int i18);

    public long getNativePtr() {
        return this.nativePtr;
    }

    public native int init(SDKModelConfig sDKModelConfig);

    public void setNativePtr(long j3) {
        this.nativePtr = j3;
    }
}
