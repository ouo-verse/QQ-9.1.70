package com.tencent.qqnt.aio.adapter.api.impl;

import com.tencent.qqnt.aio.adapter.api.ISimpleUIApi;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/SimpleUIApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/ISimpleUIApi;", "()V", "shouldHideShortcutBar", "", "chatType", "", "shouldSwitchInputBar", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class SimpleUIApiImpl implements ISimpleUIApi {
    @Override // com.tencent.qqnt.aio.adapter.api.ISimpleUIApi
    public boolean shouldHideShortcutBar(int chatType) {
        if (chatType == 2 || chatType == 1 || chatType == 102 || chatType == 117) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ISimpleUIApi
    public boolean shouldSwitchInputBar(int chatType) {
        if (chatType == 2 || chatType == 1 || chatType == 102 || chatType == 117) {
            return true;
        }
        return false;
    }
}
