package com.qzone.module.covercomponent.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class SimpleMemoryCache {

    /* renamed from: a, reason: collision with root package name */
    private int f48743a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<Long, MyCacheData> f48744b = new ConcurrentHashMap<>();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class MyCacheData {
        public Object data;
        public long time;
    }

    public SimpleMemoryCache(int i3) {
        this.f48743a = i3;
    }

    public void clear() {
        this.f48744b.clear();
    }

    public Object get(long j3) {
        MyCacheData myCacheData = this.f48744b.get(Long.valueOf(j3));
        if (myCacheData == null) {
            return null;
        }
        return myCacheData.data;
    }

    public void remove(long j3) {
        if (this.f48744b.containsKey(Long.valueOf(j3))) {
            this.f48744b.remove(Long.valueOf(j3));
        }
    }

    public void add(long j3, Object obj) {
        if (obj == null) {
            return;
        }
        MyCacheData myCacheData = new MyCacheData();
        long currentTimeMillis = System.currentTimeMillis();
        myCacheData.time = currentTimeMillis;
        myCacheData.data = obj;
        if (this.f48744b.size() >= this.f48743a) {
            ConcurrentHashMap<Long, MyCacheData> concurrentHashMap = this.f48744b;
            long j16 = 0;
            for (Map.Entry<Long, MyCacheData> entry : concurrentHashMap.entrySet()) {
                long j17 = entry.getValue().time;
                if (j17 < currentTimeMillis) {
                    j16 = entry.getKey().longValue();
                    currentTimeMillis = j17;
                }
            }
            if (j16 > 0) {
                concurrentHashMap.remove(Long.valueOf(j16));
            }
        }
        this.f48744b.put(Long.valueOf(j3), myCacheData);
    }
}
