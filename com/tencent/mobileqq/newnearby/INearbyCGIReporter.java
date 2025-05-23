package com.tencent.mobileqq.newnearby;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.json.JSONObject;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface INearbyCGIReporter extends QRouteApi {
    void reportByJson(JSONObject jSONObject);
}
