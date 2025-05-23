package com.tencent.qqlive.module.videoreport.data;

import android.support.annotation.NonNull;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoReportDataStorage<T> {
    private final WeakHashMap<Object, T> mDataMap = new WeakHashMap<>();

    public T getData(@NonNull Object obj) {
        return this.mDataMap.get(obj);
    }

    public void removeData(@NonNull Object obj) {
        this.mDataMap.remove(obj);
    }

    public void setData(@NonNull Object obj, T t16) {
        this.mDataMap.put(obj, t16);
    }
}
