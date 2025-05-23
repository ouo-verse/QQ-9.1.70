package com.tencent.mobileqq.search.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kn2.e;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J,\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/search/api/ISearchShareApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lmqq/app/AppRuntime;", "app", "", "resourceId", "actionId", "Lkn2/e;", "shareCallback", "", "getShareInfo", "qqsearch-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISearchShareApi extends QRouteApi {
    void getShareInfo(@Nullable AppRuntime app, @Nullable String resourceId, @NotNull String actionId, @NotNull e shareCallback);
}
