package com.tencent.qqnt.aio.api.impl;

import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqnt.aio.api.IPttPanelApi;
import com.tencent.qqnt.aio.audiopanel.PttPanelVB;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0005\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/PttPanelApiImpl;", "Lcom/tencent/qqnt/aio/api/IPttPanelApi;", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "getPanelVB", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PttPanelApiImpl implements IPttPanelApi {
    @Override // com.tencent.qqnt.aio.api.IPttPanelApi
    public com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> getPanelVB() {
        return new PttPanelVB();
    }
}
