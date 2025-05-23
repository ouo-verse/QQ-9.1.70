package com.tencent.mobileqq.wxmini.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/wxmini/api/IWxRuntimeApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createAppInterface", "Lmqq/app/AppRuntime;", "app", "Lmqq/app/MobileQQ;", "procName", "", "getWxaIPCModule", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "wxmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IWxRuntimeApi extends QRouteApi {
    @Nullable
    AppRuntime createAppInterface(@Nullable MobileQQ app, @Nullable String procName);

    @NotNull
    QIPCModule getWxaIPCModule();
}
