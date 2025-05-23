package com.tencent.aelight.camera.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface ICameraCompatible extends QRouteApi {
    boolean isFoundCoolPad();

    boolean isFoundProduct(String str);

    boolean isFoundProductByRomID(String str);

    boolean isFoundProductFeature(String str);

    boolean isFoundProductFeatureRom(String str);

    boolean isFoundProductManufacturer(String str);

    boolean isInARParticleBackList();

    boolean isNeedDrawOnOpenGLSingleThread();

    boolean isNotSupportFilterBasedSdk();

    boolean notSupportCameraFrontSysPhoto();

    void updateCompatibleList(String str, boolean z16);
}
