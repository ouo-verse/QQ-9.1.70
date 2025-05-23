package com.tencent.aelight.camera.watermark.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.soso.location.data.SosoLocation;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAEWaterMarkManager extends QRouteApi {
    SosoLocation getLocation();

    void onConfigChange(boolean z16);
}
