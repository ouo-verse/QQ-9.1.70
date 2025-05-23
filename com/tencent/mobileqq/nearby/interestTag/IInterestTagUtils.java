package com.tencent.mobileqq.nearby.interestTag;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import m92.a;
import org.json.JSONObject;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IInterestTagUtils extends QRouteApi {
    Object convertFrom(Object obj);

    Object convertFromJSONObject(JSONObject jSONObject);

    Object convertTo(a aVar);
}
