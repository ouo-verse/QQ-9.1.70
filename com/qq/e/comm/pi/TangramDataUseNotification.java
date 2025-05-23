package com.qq.e.comm.pi;

import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class TangramDataUseNotification {

    /* renamed from: a, reason: collision with root package name */
    private List<Integer> f38336a;

    public TangramDataUseNotification(List<Integer> list) {
        this.f38336a = list;
    }

    public List<Integer> getIdList() {
        return this.f38336a;
    }

    public abstract void onDataUsed(Map<Integer, String> map);
}
