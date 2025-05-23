package com.tencent.aelight.camera.util.api.impl;

import com.tencent.aelight.camera.ae.flashshow.util.g;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;

/* compiled from: P */
/* loaded from: classes32.dex */
public class CaptureUtilImpl implements ICaptureUtil {
    private static final String AIO_CAMERA_FORBID_SYS_CAM = "9060_aio_camera_forbid_sys_75043247";
    private boolean isForceUseSysCam = false;

    @Override // com.tencent.aelight.camera.util.api.ICaptureUtil
    public int alainSize(int i3) {
        return g.a(i3);
    }

    @Override // com.tencent.aelight.camera.util.api.ICaptureUtil
    public int[] clipVideoSize(int i3, int i16, int i17, int i18, float f16) {
        return g.b(i3, i16, i17, i18, f16);
    }

    @Override // com.tencent.aelight.camera.util.api.ICaptureUtil
    public boolean getForceSysCamForTest() {
        return this.isForceUseSysCam;
    }

    @Override // com.tencent.aelight.camera.util.api.ICaptureUtil
    public boolean getFreesiaSupportCapture() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(AIO_CAMERA_FORBID_SYS_CAM, true);
    }

    @Override // com.tencent.aelight.camera.util.api.ICaptureUtil
    public boolean getGestureRecoglizeResult() {
        return g.d();
    }

    @Override // com.tencent.aelight.camera.util.api.ICaptureUtil
    public int getPhotoOrientationDegree(int i3) {
        return g.e(i3);
    }

    @Override // com.tencent.aelight.camera.util.api.ICaptureUtil
    public int getVideoOrientationDegree(int i3) {
        return g.f(i3);
    }

    @Override // com.tencent.aelight.camera.util.api.ICaptureUtil
    public boolean loadEffectSo() {
        return g.g();
    }

    @Override // com.tencent.aelight.camera.util.api.ICaptureUtil
    public int[] scaleVideoSize(int i3, int i16, int i17) {
        return g.h(i3, i16, i17);
    }

    @Override // com.tencent.aelight.camera.util.api.ICaptureUtil
    public void setForceSysCamForTest(boolean z16) {
        this.isForceUseSysCam = z16;
    }

    @Override // com.tencent.aelight.camera.util.api.ICaptureUtil
    public void setGestureRecognitionResult(boolean z16, boolean z17) {
        g.i(z16, z17);
    }

    @Override // com.tencent.aelight.camera.util.api.ICaptureUtil
    public boolean supportCapture() {
        return g.j();
    }
}
