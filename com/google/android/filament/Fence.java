package com.google.android.filament;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Fence {
    public static final long WAIT_FOR_EVER = -1;
    private long mNativeObject;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum FenceStatus {
        ERROR,
        CONDITION_SATISFIED,
        TIMEOUT_EXPIRED
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum Mode {
        FLUSH,
        DONT_FLUSH
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fence(long j3) {
        this.mNativeObject = j3;
    }

    private static native int nWait(long j3, int i3, long j16);

    private static native int nWaitAndDestroy(long j3, int i3);

    public static FenceStatus waitAndDestroy(@NonNull Fence fence, @NonNull Mode mode) {
        int nWaitAndDestroy = nWaitAndDestroy(fence.getNativeObject(), mode.ordinal());
        if (nWaitAndDestroy != -1) {
            if (nWaitAndDestroy != 0) {
                return FenceStatus.ERROR;
            }
            return FenceStatus.CONDITION_SATISFIED;
        }
        return FenceStatus.ERROR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearNativeObject() {
        this.mNativeObject = 0L;
    }

    public long getNativeObject() {
        long j3 = this.mNativeObject;
        if (j3 != 0) {
            return j3;
        }
        throw new IllegalStateException("Calling method on destroyed Fence");
    }

    public FenceStatus wait(@NonNull Mode mode, long j3) {
        int nWait = nWait(getNativeObject(), mode.ordinal(), j3);
        if (nWait != -1) {
            if (nWait != 0) {
                if (nWait != 1) {
                    return FenceStatus.ERROR;
                }
                return FenceStatus.TIMEOUT_EXPIRED;
            }
            return FenceStatus.CONDITION_SATISFIED;
        }
        return FenceStatus.ERROR;
    }
}
