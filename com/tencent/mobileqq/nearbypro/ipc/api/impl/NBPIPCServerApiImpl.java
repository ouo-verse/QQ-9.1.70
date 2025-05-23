package com.tencent.mobileqq.nearbypro.ipc.api.impl;

import com.tencent.mobileqq.nearbypro.ipc.api.INBPIPCServerApi;
import com.tencent.mobileqq.nearbypro.ipc.api.module.NBPIPCModule;
import com.tencent.mobileqq.qipc.QIPCModule;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/ipc/api/impl/NBPIPCServerApiImpl;", "Lcom/tencent/mobileqq/nearbypro/ipc/api/INBPIPCServerApi;", "()V", "getNBPIPCModule", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class NBPIPCServerApiImpl implements INBPIPCServerApi {
    @Override // com.tencent.mobileqq.nearbypro.ipc.api.INBPIPCServerApi
    @NotNull
    public QIPCModule getNBPIPCModule() {
        return NBPIPCModule.INSTANCE.a();
    }
}
