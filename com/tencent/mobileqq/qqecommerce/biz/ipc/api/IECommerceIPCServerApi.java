package com.tencent.mobileqq.qqecommerce.biz.ipc.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/ipc/api/IECommerceIPCServerApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getEcommerceIPCModule", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "getPluginIPCModule", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IECommerceIPCServerApi extends QRouteApi {
    @NotNull
    QIPCModule getEcommerceIPCModule();

    @NotNull
    QIPCModule getPluginIPCModule();
}
