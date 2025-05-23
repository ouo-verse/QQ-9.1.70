package com.tencent.aelight.camera.ae.flashshow.download;

import com.tencent.aelight.camera.ae.config.CameraDataServiceHandler;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.PeakAppInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ms.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001c\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/download/LSDownloadMaterialRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "", "kotlin.jvm.PlatformType", "d", "Ljava/lang/String;", "TAG", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class LSDownloadMaterialRunnable implements Runnable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String TAG = LSDownloadMaterialRunnable.class.getSimpleName();

    @Override // java.lang.Runnable
    public void run() {
        a.a(this.TAG, "download material");
        try {
            BusinessHandler businessHandler = QQStoryContext.a().getBusinessHandler(PeakAppInterface.I);
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.aelight.camera.ae.config.CameraDataServiceHandler");
            CameraDataServiceHandler cameraDataServiceHandler = (CameraDataServiceHandler) businessHandler;
            cameraDataServiceHandler.X2(AECameraConstants.CAMERA_FLASH_SHOW_SERVICEID);
            cameraDataServiceHandler.V2();
            cameraDataServiceHandler.S2();
            VSConfigManager.c().d();
        } catch (Exception e16) {
            a.c(this.TAG, "pre download exception" + e16.getMessage());
        }
    }
}
