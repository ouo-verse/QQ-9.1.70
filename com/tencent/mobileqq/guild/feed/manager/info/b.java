package com.tencent.mobileqq.guild.feed.manager.info;

import com.tencent.richframework.data.idata.IDataConverter;

/* compiled from: P */
/* loaded from: classes13.dex */
public class b implements IDataConverter<a> {
    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a cloneConvertData(a aVar) {
        a aVar2 = new a();
        aVar2.h(aVar.d());
        update(aVar2, aVar);
        return aVar2;
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String getObserverKey(a aVar) {
        return aVar.b();
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(a aVar, a aVar2) {
        aVar.g(aVar2.c());
        aVar.i(aVar2.e());
    }
}
