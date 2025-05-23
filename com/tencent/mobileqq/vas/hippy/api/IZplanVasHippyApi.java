package com.tencent.mobileqq.vas.hippy.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mtt.hippy.HippyAPIProvider;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/hippy/api/IZplanVasHippyApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getBusinessData", "Lorg/json/JSONObject;", "getVasZplanHippyAPIProvider", "Lcom/tencent/mtt/hippy/HippyAPIProvider;", "isVasZplanSmallHomeModule", "", "moduleName", "", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IZplanVasHippyApi extends QRouteApi {
    @NotNull
    JSONObject getBusinessData();

    @NotNull
    HippyAPIProvider getVasZplanHippyAPIProvider();

    boolean isVasZplanSmallHomeModule(@Nullable String moduleName);
}
