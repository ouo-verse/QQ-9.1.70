package com.qq.e.comm.managers.status;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DeviceInfoSetting {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<Integer, Object> f38237a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<Integer, Boolean> f38238b = new ConcurrentHashMap<>();

    public ConcurrentHashMap<Integer, Boolean> getDeviceInfoConfig() {
        return this.f38238b;
    }

    public Object getDeviceInfoValue(int i3) {
        ConcurrentHashMap<Integer, Object> concurrentHashMap = this.f38237a;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(Integer.valueOf(i3))) {
            return null;
        }
        return this.f38237a.get(Integer.valueOf(i3));
    }

    public void setDeviceInfoConfig(int i3, boolean z16) {
        this.f38238b.put(Integer.valueOf(i3), Boolean.valueOf(z16));
    }

    public void setDeviceInfoValue(int i3, Object obj) {
        this.f38237a.put(Integer.valueOf(i3), obj);
    }

    public ConcurrentHashMap<Integer, Object> getDeviceInfoValue() {
        return this.f38237a;
    }
}
