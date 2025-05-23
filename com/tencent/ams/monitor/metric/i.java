package com.tencent.ams.monitor.metric;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface i {
    long getId();

    ConcurrentHashMap<String, String> getTagSets();

    long getTimeMillis();

    double getValue();
}
