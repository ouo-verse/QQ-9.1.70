package com.tencent.aelight.camera.filament.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IZShowFilamentPreviewProvider extends QRouteApi {
    BaseZShowFilamentPreviewView getView();

    boolean isSupportFilament();
}
