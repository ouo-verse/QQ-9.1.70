package com.tencent.mobileqq.webview.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.service.profile.a;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import px.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/webview/api/IOfflineApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/mobileqq/service/profile/a;", "getCheckUpdateItemInterface", "Lpx/c;", "getOfflineDownloader", "", "release", "webview_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IOfflineApi extends QRouteApi {
    @NotNull
    a getCheckUpdateItemInterface(@NotNull AppRuntime app);

    @NotNull
    c getOfflineDownloader();

    void release();
}
