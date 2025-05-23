package com.tencent.richframework.data.base;

import com.tencent.richframework.data.idata.IDataStore;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class BaseDataStore<T> implements IDataStore<T> {
    @Override // com.tencent.richframework.data.idata.IDataStore
    public void addData(T t16) {
        getAllData().put(getKeyFromData(t16), t16);
    }

    public void addDataList(Collection<T> collection) {
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            addData(it.next());
        }
    }

    @Override // com.tencent.richframework.data.idata.IDataStore
    public T getData(String str) {
        return getAllData().get(str);
    }

    @Override // com.tencent.richframework.data.idata.IDataStore
    public void removeDataByKey(String str) {
        getAllData().remove(str);
    }
}
