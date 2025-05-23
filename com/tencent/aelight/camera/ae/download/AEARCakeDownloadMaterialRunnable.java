package com.tencent.aelight.camera.ae.download;

import com.tencent.aelight.camera.ae.config.CameraDataServiceHandler;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.mobileqq.app.PeakAppInterface;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEARCakeDownloadMaterialRunnable implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private static final String f63568d = "AEARCakeDownloadMaterialRunnable";

    @Override // java.lang.Runnable
    public void run() {
        ms.a.a(f63568d, "arcake download material~~~~~~~");
        CameraDataServiceHandler cameraDataServiceHandler = (CameraDataServiceHandler) QQStoryContext.a().getBusinessHandler(PeakAppInterface.I);
        cameraDataServiceHandler.S2();
        VSConfigManager.c().d();
        cameraDataServiceHandler.W2();
    }
}
