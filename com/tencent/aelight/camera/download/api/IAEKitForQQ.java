package com.tencent.aelight.camera.download.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.light.LightEngine;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAEKitForQQ extends QRouteApi {
    LightEngine.SDKServiceCallback getLightServiceCallback();

    boolean init();

    boolean initWithConfig();

    boolean isSupported();

    boolean lightSdkIsFunctionReadyWithConfig();

    boolean lightSdkLoadBasicFeaturesWithConfig();

    boolean loadLightSdkWithConfig();
}
