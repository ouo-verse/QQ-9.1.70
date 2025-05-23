package com.tencent.av.audioprocess.api;

import au.f;
import com.tencent.avcore.engine.common.IAVEngineCommon;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAudioProcessHelperApi extends QRouteApi {
    IAudioProcessApi createInstance(IAVEngineCommon iAVEngineCommon, f fVar);

    void destroyInstance();

    IAudioProcessApi getInstance();

    boolean hasInstance();
}
