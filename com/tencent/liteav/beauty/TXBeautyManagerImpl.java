package com.tencent.liteav.beauty;

import android.graphics.Bitmap;
import com.tencent.liteav.base.annotations.JNINamespace;

/* compiled from: P */
@JNINamespace("liteav::manager")
/* loaded from: classes7.dex */
public class TXBeautyManagerImpl implements TXBeautyManager {
    private long mNativeBeautyManager;

    public TXBeautyManagerImpl(long j3) {
        this.mNativeBeautyManager = j3;
    }

    private static native void nativeDestroy(long j3);

    private static native void nativeEnableSharpnessEnhancement(long j3, boolean z16);

    private static native void nativeSetBeautyLevel(long j3, float f16);

    private static native void nativeSetBeautyStyle(long j3, int i3);

    private static native int nativeSetChinLevel(long j3, float f16);

    private static native int nativeSetEyeAngleLevel(long j3, float f16);

    private static native int nativeSetEyeDistanceLevel(long j3, float f16);

    private static native int nativeSetEyeLightenLevel(long j3, float f16);

    private static native int nativeSetEyeScaleLevel(long j3, float f16);

    private static native int nativeSetFaceBeautyLevel(long j3, float f16);

    private static native int nativeSetFaceNarrowLevel(long j3, float f16);

    private static native int nativeSetFaceShortLevel(long j3, float f16);

    private static native int nativeSetFaceSlimLevel(long j3, float f16);

    private static native int nativeSetFaceVLevel(long j3, float f16);

    private static native void nativeSetFilter(long j3, Bitmap bitmap);

    private static native void nativeSetFilterStrength(long j3, float f16);

    private static native int nativeSetForeheadLevel(long j3, float f16);

    private static native int nativeSetGreenScreenFile(long j3, String str);

    private static native int nativeSetLipsThicknessLevel(long j3, float f16);

    private static native void nativeSetMotionMute(long j3, boolean z16);

    private static native void nativeSetMotionTmpl(long j3, String str);

    private static native int nativeSetMouthShapeLevel(long j3, float f16);

    private static native int nativeSetNosePositionLevel(long j3, float f16);

    private static native int nativeSetNoseSlimLevel(long j3, float f16);

    private static native int nativeSetNoseWingLevel(long j3, float f16);

    private static native int nativeSetPounchRemoveLevel(long j3, float f16);

    private static native void nativeSetRuddyLevel(long j3, float f16);

    private static native int nativeSetSmileLinesRemoveLevel(long j3, float f16);

    private static native int nativeSetToothWhitenLevel(long j3, float f16);

    private static native void nativeSetWhitenessLevel(long j3, float f16);

    private static native int nativeSetWrinkleRemoveLevel(long j3, float f16);

    public void clear() {
        this.mNativeBeautyManager = 0L;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void enableSharpnessEnhancement(boolean z16) {
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeEnableSharpnessEnhancement(j3, z16);
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeDestroy(j3);
            this.mNativeBeautyManager = 0L;
        }
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setBeautyLevel(float f16) {
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeSetBeautyLevel(j3, f16);
        }
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setBeautyStyle(int i3) {
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeSetBeautyStyle(j3, i3);
        }
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setChinLevel(float f16) {
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeSetChinLevel(j3, f16);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setEyeAngleLevel(float f16) {
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeSetEyeAngleLevel(j3, f16);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setEyeDistanceLevel(float f16) {
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeSetEyeDistanceLevel(j3, f16);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setEyeLightenLevel(float f16) {
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeSetEyeLightenLevel(j3, f16);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setEyeScaleLevel(float f16) {
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeSetEyeScaleLevel(j3, f16);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setFaceBeautyLevel(float f16) {
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeSetFaceBeautyLevel(j3, f16);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setFaceNarrowLevel(float f16) {
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeSetFaceNarrowLevel(j3, f16);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setFaceShortLevel(float f16) {
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeSetFaceShortLevel(j3, f16);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setFaceSlimLevel(float f16) {
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeSetFaceSlimLevel(j3, f16);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setFaceVLevel(float f16) {
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeSetFaceVLevel(j3, f16);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setFilter(Bitmap bitmap) {
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeSetFilter(j3, bitmap);
        }
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setFilterStrength(float f16) {
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeSetFilterStrength(j3, f16);
        }
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setForeheadLevel(float f16) {
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeSetForeheadLevel(j3, f16);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setGreenScreenFile(String str) {
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeSetGreenScreenFile(j3, str);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setLipsThicknessLevel(float f16) {
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeSetLipsThicknessLevel(j3, f16);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setMotionMute(boolean z16) {
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeSetMotionMute(j3, z16);
        }
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setMotionTmpl(String str) {
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeSetMotionTmpl(j3, str);
        }
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setMouthShapeLevel(float f16) {
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeSetMouthShapeLevel(j3, f16);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setNosePositionLevel(float f16) {
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeSetNosePositionLevel(j3, f16);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setNoseSlimLevel(float f16) {
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeSetNoseSlimLevel(j3, f16);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setNoseWingLevel(float f16) {
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeSetNoseWingLevel(j3, f16);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setPounchRemoveLevel(float f16) {
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeSetPounchRemoveLevel(j3, f16);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setRuddyLevel(float f16) {
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeSetRuddyLevel(j3, f16);
        }
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setSmileLinesRemoveLevel(float f16) {
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeSetSmileLinesRemoveLevel(j3, f16);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setToothWhitenLevel(float f16) {
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeSetToothWhitenLevel(j3, f16);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setWhitenessLevel(float f16) {
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeSetWhitenessLevel(j3, f16);
        }
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setWrinkleRemoveLevel(float f16) {
        long j3 = this.mNativeBeautyManager;
        if (j3 != 0) {
            nativeSetWrinkleRemoveLevel(j3, f16);
            return 0;
        }
        return 0;
    }
}
