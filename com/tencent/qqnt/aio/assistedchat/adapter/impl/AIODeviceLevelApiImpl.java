package com.tencent.qqnt.aio.assistedchat.adapter.impl;

import com.tencent.qqnt.aio.assistedchat.adapter.IAIODeviceLevelApi;
import com.tencent.qqperf.tools.d;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/adapter/impl/AIODeviceLevelApiImpl;", "Lcom/tencent/qqnt/aio/assistedchat/adapter/IAIODeviceLevelApi;", "()V", "levelHigh", "", "getLevelHigh", "()I", "levelLow", "getLevelLow", "levelMedium", "getLevelMedium", "getDeviceLevel", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class AIODeviceLevelApiImpl implements IAIODeviceLevelApi {
    @Override // com.tencent.qqnt.aio.assistedchat.adapter.IAIODeviceLevelApi
    public int getDeviceLevel() {
        return d.f363413a.a();
    }

    @Override // com.tencent.qqnt.aio.assistedchat.adapter.IAIODeviceLevelApi
    public int getLevelHigh() {
        return 1;
    }

    @Override // com.tencent.qqnt.aio.assistedchat.adapter.IAIODeviceLevelApi
    public int getLevelLow() {
        return 3;
    }

    @Override // com.tencent.qqnt.aio.assistedchat.adapter.IAIODeviceLevelApi
    public int getLevelMedium() {
        return 2;
    }
}
