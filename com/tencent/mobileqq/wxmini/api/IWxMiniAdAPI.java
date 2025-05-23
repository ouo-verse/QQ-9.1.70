package com.tencent.mobileqq.wxmini.api;

import com.tencent.kuikly.core.render.android.b;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IWxMiniAdAPI extends QRouteApi {
    void registerGameCenterKuiklyExternalModule(b bVar);
}
