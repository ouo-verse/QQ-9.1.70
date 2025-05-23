package com.tencent.qqnt.aio.adapter.api.impl;

import com.tencent.libra.listener.ILoaderResultListener;
import com.tencent.mobileqq.qcircle.picload.listener.RFWPicLoaderResultListener;
import com.tencent.qqnt.aio.adapter.api.IPicLoaderApi;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/PicLoaderApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IPicLoaderApi;", "()V", "getLoadResultListener", "Lcom/tencent/libra/listener/ILoaderResultListener;", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class PicLoaderApiImpl implements IPicLoaderApi {
    @Override // com.tencent.qqnt.aio.adapter.api.IPicLoaderApi
    public ILoaderResultListener getLoadResultListener() {
        return new RFWPicLoaderResultListener("6");
    }
}
