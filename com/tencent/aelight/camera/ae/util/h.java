package com.tencent.aelight.camera.ae.util;

import android.util.Log;
import android.util.TypedValue;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private static int f65769a = -1;

    /* renamed from: b, reason: collision with root package name */
    private static com.tencent.mobileqq.activity.richmedia.i f65770b = new com.tencent.mobileqq.activity.richmedia.i(ViewUtils.getScreenWidth(), ViewUtils.getScreenHeight());

    public static com.tencent.mobileqq.activity.richmedia.i a() {
        return f65770b;
    }

    public static com.tencent.mobileqq.activity.richmedia.i c(AECaptureMode aECaptureMode, com.tencent.mobileqq.activity.richmedia.i iVar, boolean z16, AEVideoStoryTopBarViewModel.Ratio ratio) {
        Log.d("adjustRatio ", "getPreviewSize" + aECaptureMode + " currentRatio" + ratio);
        if (aECaptureMode == AECaptureMode.NORMAL) {
            if (ratio == AEVideoStoryTopBarViewModel.Ratio.R_1_1) {
                int min = Math.min(iVar.f185860a, iVar.f185861b);
                return new com.tencent.mobileqq.activity.richmedia.i(min, min);
            }
            if (ratio == AEVideoStoryTopBarViewModel.Ratio.FULL) {
                return iVar;
            }
            if (ratio == AEVideoStoryTopBarViewModel.Ratio.R_4_3) {
                int i3 = iVar.f185860a;
                return new com.tencent.mobileqq.activity.richmedia.i(i3, (int) (i3 * 1.3333334f));
            }
            if (ratio != AEVideoStoryTopBarViewModel.Ratio.R_16_9) {
                return iVar;
            }
            Log.d("adjustRatio", " R_16_9" + (iVar.f185860a * 1.7777778f));
            int i16 = iVar.f185860a;
            return new com.tencent.mobileqq.activity.richmedia.i(i16, (int) (i16 * 1.7777778f));
        }
        if (aECaptureMode != AECaptureMode.GIF) {
            return iVar;
        }
        int min2 = Math.min(iVar.f185860a, iVar.f185861b);
        int c16 = x.c(BaseApplication.getContext(), 250.0f);
        if (c16 > 0) {
            min2 = Math.min(min2, c16);
        }
        return new com.tencent.mobileqq.activity.richmedia.i(min2, min2);
    }

    public static int d() {
        int i3 = f65769a;
        if (i3 != -1) {
            return i3;
        }
        int screenWidth = ViewUtils.getScreenWidth();
        int screenHeight = ViewUtils.getScreenHeight();
        boolean z16 = LiuHaiUtils.sHasNotch;
        int i16 = LiuHaiUtils.sNotchHeight;
        if (z16) {
            screenHeight += i16;
        }
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext());
        int dimensionPixelSize = BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.f13189h);
        int f16 = (int) (BaseAIOUtils.f(98.0f, BaseApplication.getContext().getResources()) * 1.1735f);
        int i17 = (int) (screenWidth * 1.3333334f);
        int dimensionPixelSize2 = ((screenHeight - (BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.f130797) + BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.f130898))) - f16) - ((int) (BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.f130696) + TypedValue.applyDimension(2, 18.0f, BaseApplication.getContext().getResources().getDisplayMetrics())));
        if ((dimensionPixelSize2 - statusBarHeight) - dimensionPixelSize >= i17) {
            f65769a = 1;
        } else if (dimensionPixelSize2 >= i17) {
            f65769a = 2;
        } else {
            f65769a = 0;
        }
        ms.a.f("AEPreviewSizeUtil", "[getScreenTypeForCircle]---screen size=" + screenWidth + "X" + screenHeight + ", sScreenTypeForCircle=" + f65769a + ", statusBarHeight=" + statusBarHeight + ", hasNotch=" + z16 + ", notchHeight=" + i16);
        return f65769a;
    }

    public static void e(com.tencent.mobileqq.activity.richmedia.i iVar) {
        f65770b = iVar;
    }

    public static com.tencent.mobileqq.activity.richmedia.i b(AECaptureMode aECaptureMode, com.tencent.mobileqq.activity.richmedia.i iVar, AEVideoStoryTopBarViewModel.Ratio ratio) {
        return c(aECaptureMode, iVar, true, ratio);
    }
}
