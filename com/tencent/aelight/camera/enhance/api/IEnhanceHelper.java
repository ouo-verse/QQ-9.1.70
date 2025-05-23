package com.tencent.aelight.camera.enhance.api;

import com.tencent.aelight.camera.struct.editor.EnhanceConfig;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IEnhanceHelper extends QRouteApi {
    EnhanceConfig getEnhanceConfig();

    void updateEnhanceConfigInSubThread();
}
