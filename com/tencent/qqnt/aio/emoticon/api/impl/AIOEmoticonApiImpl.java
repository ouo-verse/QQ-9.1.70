package com.tencent.qqnt.aio.emoticon.api.impl;

import com.tencent.mobileqq.emotionintegrate.p;
import com.tencent.qqnt.aio.emoticon.api.IAIOEmoticonApi;
import com.tencent.richframework.data.idata.IDataStore;
import com.tencent.richframework.gallery.datacenter.RFWLayerDataCenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import zu3.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/emoticon/api/impl/AIOEmoticonApiImpl;", "Lcom/tencent/qqnt/aio/emoticon/api/IAIOEmoticonApi;", "()V", "getEmoticonDataStore", "", "onAIOEmotionFragmentDestroy", "", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class AIOEmoticonApiImpl implements IAIOEmoticonApi {
    @Override // com.tencent.qqnt.aio.emoticon.api.IAIOEmoticonApi
    public List<?> getEmoticonDataStore() {
        LinkedHashMap<String, p> allData;
        Collection<p> values;
        IDataStore iDataStore = RFWLayerDataCenter.INSTANCE.getAllDataStore().get("AIO_EMOTICON_DATA_KEY");
        a aVar = iDataStore instanceof a ? (a) iDataStore : null;
        if (aVar == null || (allData = aVar.getAllData()) == null || (values = allData.values()) == null) {
            return null;
        }
        return new ArrayList(values);
    }

    @Override // com.tencent.qqnt.aio.emoticon.api.IAIOEmoticonApi
    public void onAIOEmotionFragmentDestroy() {
        RFWLayerDataCenter.INSTANCE.getAllDataStore().remove("AIO_EMOTICON_DATA_KEY");
    }
}
