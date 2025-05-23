package com.tencent.mobileqq.vas.hippy.api;

import com.tencent.gamecenter.wadl.api.IQQGameSwitchApi;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.HippyAPIProvider;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qv4.ak;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vas/hippy/api/IZPlanParadiseHippyApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mtt/hippy/HippyAPIProvider;", "getHippyAPIProvider", "", "moduleName", "", "isZplanParadiseModule", "Lqv4/ak;", IQQGameSwitchApi.PARAMS_KEY_HIPPY_INFO, "", "preloadHippyRes", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IZPlanParadiseHippyApi extends QRouteApi {
    @NotNull
    HippyAPIProvider getHippyAPIProvider();

    boolean isZplanParadiseModule(@Nullable String moduleName);

    void preloadHippyRes(@NotNull ak hippyInfo);
}
