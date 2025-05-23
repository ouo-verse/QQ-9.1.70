package com.tencent.beacon.a.b;

import com.tencent.beacon.base.net.HttpMethod;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import java.util.LinkedHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f77601a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f77602b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f77603c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ g f77604d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(g gVar, String str, String str2, String str3) {
        this.f77604d = gVar;
        this.f77601a = str;
        this.f77602b = str2;
        this.f77603c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        obj = this.f77604d.f77608d;
        synchronized (obj) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("attaid", this.f77604d.b());
            linkedHashMap.put("token", this.f77604d.c());
            linkedHashMap.put("platform", "Android");
            linkedHashMap.put("uin", "");
            linkedHashMap.put("model", "");
            linkedHashMap.put("os", "");
            linkedHashMap.put("error_stack_full", "");
            linkedHashMap.put("app_version", "");
            linkedHashMap.put("sdk_version", com.tencent.beacon.a.c.c.c().i());
            linkedHashMap.put(ReportDataBuilder.KEY_PRODUCT_ID, this.f77601a);
            linkedHashMap.put("error_code", this.f77602b);
            linkedHashMap.put("error_msg", this.f77603c);
            linkedHashMap.put("_dc", String.valueOf(Math.random()));
            com.tencent.beacon.base.net.c.c().a(com.tencent.beacon.base.net.call.e.b().b("https://h.trace.qq.com/kv").a(com.tencent.rmonitor.base.config.data.k.ATTA_CONFIG_KEY).a(linkedHashMap).a(HttpMethod.POST).a()).a(new e(this));
        }
    }
}
