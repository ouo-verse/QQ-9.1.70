package com.tencent.aelight.camera.util.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface ICaptureUtil extends QRouteApi {
    public static final int HW_SUPPORT_VERSION = 23;

    int alainSize(int i3);

    int[] clipVideoSize(int i3, int i16, int i17, int i18, float f16);

    boolean getForceSysCamForTest();

    boolean getFreesiaSupportCapture();

    boolean getGestureRecoglizeResult();

    int getPhotoOrientationDegree(int i3);

    int getVideoOrientationDegree(int i3);

    boolean loadEffectSo();

    int[] scaleVideoSize(int i3, int i16, int i17);

    void setForceSysCamForTest(boolean z16);

    void setGestureRecognitionResult(boolean z16, boolean z17);

    boolean supportCapture();
}
