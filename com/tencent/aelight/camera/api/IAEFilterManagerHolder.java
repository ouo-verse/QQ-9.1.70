package com.tencent.aelight.camera.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAEFilterManagerHolder extends QRouteApi {
    boolean isAEFilterManagerEmpty();

    void setIsAfterUpdateMaterial(boolean z16);

    void updateLutGL(String str);
}
