package com.tencent.mobileqq.gateway.localphone.ecdh.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/gateway/localphone/ecdh/api/ILocalPhoneIPCApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getLocalPhoneIPCModule", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "qqlogin-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface ILocalPhoneIPCApi extends QRouteApi {
    @NotNull
    QIPCModule getLocalPhoneIPCModule();
}
