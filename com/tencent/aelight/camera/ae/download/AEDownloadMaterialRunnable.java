package com.tencent.aelight.camera.ae.download;

import com.tencent.aelight.camera.ae.config.CameraDataServiceHandler;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEDownloadMaterialRunnable implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    private static final String f63569e = "AEDownloadMaterialRunnable";

    /* renamed from: d, reason: collision with root package name */
    private boolean f63570d;

    public AEDownloadMaterialRunnable() {
    }

    public boolean e() {
        boolean isFeatureSwitchEnable = ((IFeatureRuntimeService) QQStoryContext.a().getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("camera_story_makeup", true);
        ms.a.f(f63569e, "useCameraStoryMakeup: " + isFeatureSwitchEnable);
        return isFeatureSwitchEnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ms.a.a(f63569e, "download material");
            CameraDataServiceHandler cameraDataServiceHandler = (CameraDataServiceHandler) QQStoryContext.a().getBusinessHandler(PeakAppInterface.I);
            if (this.f63570d && e()) {
                cameraDataServiceHandler.X2(AECameraConstants.CAMERA_STORY_MAKEUP_SERVICEID);
            } else {
                cameraDataServiceHandler.X2(AECameraConstants.CAMERA_STORY_SERVICEID);
                cameraDataServiceHandler.X2(AECameraConstants.CAMERA_EMO_SERVICEID);
                cameraDataServiceHandler.U2();
            }
            cameraDataServiceHandler.V2();
            cameraDataServiceHandler.S2();
            VSConfigManager.c().d();
        } catch (Exception e16) {
            ms.a.c(f63569e, "pre download exception" + e16.getMessage());
        }
    }

    public AEDownloadMaterialRunnable(boolean z16) {
        this.f63570d = z16;
    }
}
