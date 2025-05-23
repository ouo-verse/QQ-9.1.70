package com.tencent.aelight.camera.download.old.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAEOldPath extends QRouteApi {
    String getCameraResPath();

    String getPendantBasePath();

    String getTmpCache();
}
