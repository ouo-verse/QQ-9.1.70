package com.tencent.mobileqq.nearby.interestTag;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.json.JSONObject;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IInterestTagInfoUtils extends QRouteApi {
    Object convertFrom(Object obj);

    Object convertFrom(JSONObject jSONObject);
}
