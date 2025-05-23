package com.tencent.aelight.camera.ae.flashshow.util;

import android.util.Log;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.flashshow.mode.LSCaptureMode;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private static com.tencent.mobileqq.activity.richmedia.i f65119a = new com.tencent.mobileqq.activity.richmedia.i(ViewUtils.getScreenWidth(), ViewUtils.getScreenHeight());

    public static com.tencent.mobileqq.activity.richmedia.i a() {
        return f65119a;
    }

    public static com.tencent.mobileqq.activity.richmedia.i c(LSCaptureMode lSCaptureMode, com.tencent.mobileqq.activity.richmedia.i iVar, boolean z16, AEVideoStoryTopBarViewModel.Ratio ratio) {
        Log.d("adjustRatio ", "getPreviewSize" + lSCaptureMode + " currentRatio" + ratio);
        if (lSCaptureMode == LSCaptureMode.NORMAL) {
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
        if (lSCaptureMode != LSCaptureMode.GIF) {
            return iVar;
        }
        int min2 = Math.min(iVar.f185860a, iVar.f185861b);
        int c16 = x.c(BaseApplication.getContext(), 250.0f);
        if (c16 > 0) {
            min2 = Math.min(min2, c16);
        }
        return new com.tencent.mobileqq.activity.richmedia.i(min2, min2);
    }

    public static void d(com.tencent.mobileqq.activity.richmedia.i iVar) {
        f65119a = iVar;
    }

    public static com.tencent.mobileqq.activity.richmedia.i b(LSCaptureMode lSCaptureMode, com.tencent.mobileqq.activity.richmedia.i iVar, AEVideoStoryTopBarViewModel.Ratio ratio) {
        return c(lSCaptureMode, iVar, true, ratio);
    }
}
