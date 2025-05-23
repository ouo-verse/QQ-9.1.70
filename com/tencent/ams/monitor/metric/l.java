package com.tencent.ams.monitor.metric;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface l {
    l cloneDeeply();

    int getBusinessType();

    ConcurrentHashMap<String, String> getCommonTagSets();

    int getCountThreshold();

    long getIntervalMillisThreshold();

    int getMaxCount();

    String getUrl();

    WeakReference<j> getWeakLogAdapter();

    WeakReference<m> getWeakThreadManagerAdapter();
}
