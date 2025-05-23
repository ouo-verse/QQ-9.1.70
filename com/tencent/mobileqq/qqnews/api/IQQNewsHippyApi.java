package com.tencent.mobileqq.qqnews.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.HippyAPIProvider;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqnews/api/IQQNewsHippyApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createHippyProvider", "Lcom/tencent/mtt/hippy/HippyAPIProvider;", "hasNewMessage", "", "isCanPreload", "isQQNewsModule", "moduleName", "", "qqnews-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQQNewsHippyApi extends QRouteApi {
    @NotNull
    HippyAPIProvider createHippyProvider();

    boolean hasNewMessage();

    boolean isCanPreload();

    boolean isQQNewsModule(@NotNull String moduleName);
}
