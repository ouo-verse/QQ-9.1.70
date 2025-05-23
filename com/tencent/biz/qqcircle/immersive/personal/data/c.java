package com.tencent.biz.qqcircle.immersive.personal.data;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private final a f88534a;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, b> f88535b = new ConcurrentHashMap<>();

    public c(a aVar) {
        this.f88534a = aVar;
        for (b bVar : b()) {
            bVar.c(this.f88534a);
            this.f88535b.put(bVar.b(), bVar);
        }
    }

    public abstract String a();

    public abstract List<b> b();

    public void c(a aVar) {
        for (Map.Entry<String, b> entry : this.f88535b.entrySet()) {
            String key = entry.getKey();
            long h16 = this.f88534a.h(key);
            long h17 = aVar.h(key);
            if (h17 > h16) {
                entry.getValue().d(aVar, h17);
            }
        }
    }

    public void d(long j3) {
        RFWLog.i(a(), RFWLog.USR, "[updateAllVersion]");
        Iterator<String> it = this.f88535b.keySet().iterator();
        while (it.hasNext()) {
            this.f88534a.f(it.next(), j3);
        }
    }

    public void e(String str, long j3) {
        this.f88534a.f(str, j3);
    }
}
