package com.tencent.mobileqq.shortvideo.panoramicvideo.utils;

/* loaded from: classes18.dex */
public class PlaneTextureRotationUtil {
    public static final float[] TEXTURE_NO_ROTATION = {0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    public static final float[] TEXTURE_ROTATED_90 = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static final float[] TEXTURE_ROTATED_180 = {1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    public static final float[] TEXTURE_ROTATED_270 = {0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f};

    PlaneTextureRotationUtil() {
    }

    private static float flip(float f16) {
        return 1.0f - f16;
    }

    public static float[] getRotation(int i3, boolean z16, boolean z17) {
        float[] fArr;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    fArr = TEXTURE_NO_ROTATION;
                } else {
                    fArr = TEXTURE_ROTATED_270;
                }
            } else {
                fArr = TEXTURE_ROTATED_180;
            }
        } else {
            fArr = TEXTURE_ROTATED_90;
        }
        if (z16) {
            fArr = new float[]{flip(fArr[0]), fArr[1], flip(fArr[2]), fArr[3], flip(fArr[4]), fArr[5], flip(fArr[6]), fArr[7]};
        }
        if (z17) {
            return new float[]{fArr[0], flip(fArr[1]), fArr[2], flip(fArr[3]), fArr[4], flip(fArr[5]), fArr[6], flip(fArr[7])};
        }
        return fArr;
    }
}
