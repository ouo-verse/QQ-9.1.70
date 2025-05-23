package com.tencent.mobileqq.zplan.web.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import org.json.JSONObject;

@QRouteFactory(singleton = false)
@QAPI(process = {"tool"})
/* loaded from: classes21.dex */
public interface IZPlanJsPlugin extends QRouteApi {
    public static final String BUSINESS_NAME = "zplan";

    JSONObject getThunderJson(boolean z16);
}
