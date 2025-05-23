package com.tencent.aelight.camera.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import ps.b;

@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAEPhotoAIManager extends QRouteApi {
    void downloadPhotoAIRes();

    b getPhotoAIResult(String str);

    boolean isPhotoAIResExist();
}
