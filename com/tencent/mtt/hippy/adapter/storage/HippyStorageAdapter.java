package com.tencent.mtt.hippy.adapter.storage;

import com.tencent.mtt.hippy.common.HippyArray;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface HippyStorageAdapter {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface Callback<T> {
        void onError(String str);

        void onSuccess(T t16);
    }

    void destroyIfNeed();

    void getAllKeys(Callback<HippyArray> callback);

    void multiGet(HippyArray hippyArray, Callback<List<HippyStorageKeyValue>> callback);

    void multiRemove(HippyArray hippyArray, Callback<Void> callback);

    void multiSet(List<HippyStorageKeyValue> list, Callback<Void> callback);
}
