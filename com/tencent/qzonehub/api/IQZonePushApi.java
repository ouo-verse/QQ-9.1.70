package com.tencent.qzonehub.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;

@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQZonePushApi extends QRouteApi {
    void handleSilentPush(String str, Map<String, String> map);
}
