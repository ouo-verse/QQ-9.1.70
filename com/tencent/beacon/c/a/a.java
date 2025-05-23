package com.tencent.beacon.c.a;

import com.tencent.beacon.a.c.e;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.module.StatModule;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f77793a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(c cVar) {
        this.f77793a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Map map;
        Map map2;
        String str;
        Map map3;
        Map map4;
        StatModule statModule;
        Map<String, String> map5;
        e l3 = e.l();
        f e16 = f.e();
        map = this.f77793a.f77802g;
        map.put("A19", l3.q());
        map2 = this.f77793a.f77802g;
        if (com.tencent.beacon.a.c.b.f77633d) {
            str = "Y";
        } else {
            str = "N";
        }
        map2.put("A85", str);
        map3 = this.f77793a.f77802g;
        map3.put("A20", e16.j());
        map4 = this.f77793a.f77802g;
        map4.put("A69", e16.k());
        statModule = this.f77793a.f77803h;
        map5 = this.f77793a.f77802g;
        statModule.a(map5);
    }
}
