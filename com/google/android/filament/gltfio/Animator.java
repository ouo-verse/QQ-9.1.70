package com.google.android.filament.gltfio;

import androidx.annotation.IntRange;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Animator {
    private long mNativeObject;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Animator(long j3) {
        this.mNativeObject = j3;
    }

    private static native void nApplyAnimation(long j3, int i3, float f16);

    private static native void nApplyCrossFade(long j3, int i3, float f16, float f17);

    private static native int nGetAnimationCount(long j3);

    private static native float nGetAnimationDuration(long j3, int i3);

    private static native String nGetAnimationName(long j3, int i3);

    private static native void nResetBoneMatrices(long j3);

    private static native void nUpdateBoneMatrices(long j3);

    public void applyAnimation(@IntRange(from = 0) int i3, float f16) {
        nApplyAnimation(getNativeObject(), i3, f16);
    }

    public void applyCrossFade(int i3, float f16, float f17) {
        nApplyCrossFade(getNativeObject(), i3, f16, f17);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearNativeObject() {
        this.mNativeObject = 0L;
    }

    public int getAnimationCount() {
        return nGetAnimationCount(getNativeObject());
    }

    public float getAnimationDuration(@IntRange(from = 0) int i3) {
        return nGetAnimationDuration(getNativeObject(), i3);
    }

    public String getAnimationName(@IntRange(from = 0) int i3) {
        return nGetAnimationName(getNativeObject(), i3);
    }

    long getNativeObject() {
        long j3 = this.mNativeObject;
        if (j3 != 0) {
            return j3;
        }
        throw new IllegalStateException("Using Animator on destroyed asset");
    }

    public void resetBoneMatrices() {
        nResetBoneMatrices(getNativeObject());
    }

    public void updateBoneMatrices() {
        nUpdateBoneMatrices(getNativeObject());
    }
}
