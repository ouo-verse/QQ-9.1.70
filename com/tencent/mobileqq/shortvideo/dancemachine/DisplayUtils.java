package com.tencent.mobileqq.shortvideo.dancemachine;

import com.tencent.sveffects.SdkContext;

/* compiled from: P */
/* loaded from: classes18.dex */
public class DisplayUtils {
    private static float DENSITY = 0.0f;
    private static final float DIP = 2.0f;

    private static float dip2px(float f16) {
        if (DENSITY == 0.0f) {
            DENSITY = SdkContext.getInstance().getApplication().getResources().getDisplayMetrics().density;
        }
        return (f16 * DENSITY) + 0.5f;
    }

    public static int pixelToRealPixel(float f16) {
        return (int) pixelToRealPixelF(f16);
    }

    private static float pixelToRealPixelF(float f16) {
        return dip2px(f16 / 2.0f);
    }

    public static int pixelToRealPixel(float f16, float f17) {
        return (int) (pixelToRealPixelF(f16) * f17);
    }
}
