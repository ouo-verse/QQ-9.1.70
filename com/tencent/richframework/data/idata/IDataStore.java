package com.tencent.richframework.data.idata;

import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IDataStore<T> {
    void addData(T t16);

    Map<String, T> getAllData();

    T getData(String str);

    String getKeyFromData(T t16);

    void removeDataByKey(String str);
}
