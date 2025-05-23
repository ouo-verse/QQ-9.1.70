package com.tencent.aelight.camera.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAEPath extends QRouteApi {
    void clearAECache();

    String getCameraMaterialConfig();

    String getCameraMaterialUnZipDownload();

    String getCameraPathMaterialFinalUsable();

    String getCameraResPath();

    String getGifPreviewCache();

    String getLoadPagPath();

    String getMoodPathFinalUsable();

    String getPendantBasePath();

    String getQZoneCameraPathMaterialFinalUsable();

    String getQZoneCameraZipPathMaterialFinalUsable();

    String getTmpCache();
}
