package com.tencent.mobileqq.vashealth.api;

import com.tencent.kuikly.core.render.android.b;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IQQHealthKuiklyApi extends QRouteApi {
    void registerExternalModule(b bVar);

    void registerExternalRenderView(b bVar);
}
