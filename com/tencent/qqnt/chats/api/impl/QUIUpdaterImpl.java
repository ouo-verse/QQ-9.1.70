package com.tencent.qqnt.chats.api.impl;

import com.tencent.mobileqq.resconfig.MainResourceConfig;
import com.tencent.qqnt.chats.api.IQUIUpdater;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/chats/api/impl/QUIUpdaterImpl;", "Lcom/tencent/qqnt/chats/api/IQUIUpdater;", "()V", "getSwitchFor9000", "", "isUIFor9000", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class QUIUpdaterImpl implements IQUIUpdater {
    @Override // com.tencent.qqnt.chats.api.IQUIUpdater
    public boolean getSwitchFor9000() {
        return MainResourceConfig.INSTANCE.h();
    }

    @Override // com.tencent.qqnt.chats.api.IQUIUpdater
    public boolean isUIFor9000() {
        return MainResourceConfig.INSTANCE.i();
    }
}
