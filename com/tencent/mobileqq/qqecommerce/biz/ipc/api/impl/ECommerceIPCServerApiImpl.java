package com.tencent.mobileqq.qqecommerce.biz.ipc.api.impl;

import af2.c;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqecommerce.biz.ipc.api.IECommerceIPCServerApi;
import com.tencent.mobileqq.qqecommerce.biz.ipc.module.ECommerceServerQIPCModule;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/ipc/api/impl/ECommerceIPCServerApiImpl;", "Lcom/tencent/mobileqq/qqecommerce/biz/ipc/api/IECommerceIPCServerApi;", "()V", "getEcommerceIPCModule", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "getPluginIPCModule", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ECommerceIPCServerApiImpl implements IECommerceIPCServerApi {
    @Override // com.tencent.mobileqq.qqecommerce.biz.ipc.api.IECommerceIPCServerApi
    public QIPCModule getEcommerceIPCModule() {
        return ECommerceServerQIPCModule.INSTANCE.a();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.ipc.api.IECommerceIPCServerApi
    public QIPCModule getPluginIPCModule() {
        return c.f25997d;
    }
}
