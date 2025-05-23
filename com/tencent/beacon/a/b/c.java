package com.tencent.beacon.a.b;

import com.tencent.beacon.base.net.HttpMethod;
import com.tencent.beacon.base.net.call.Callback;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f77593a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f77594b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Throwable f77595c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f77596d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Callback f77597e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ g f77598f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(g gVar, String str, String str2, Throwable th5, boolean z16, Callback callback) {
        this.f77598f = gVar;
        this.f77593a = str;
        this.f77594b = str2;
        this.f77595c = th5;
        this.f77596d = z16;
        this.f77597e = callback;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Map map;
        String str;
        obj = this.f77598f.f77608d;
        synchronized (obj) {
            map = g.f77605a;
            LinkedHashMap linkedHashMap = new LinkedHashMap(map);
            linkedHashMap.put("error_code", this.f77593a);
            linkedHashMap.put("error_msg", this.f77594b);
            linkedHashMap.put("error_stack_full", com.tencent.beacon.base.util.b.a(this.f77595c));
            linkedHashMap.put("_dc", String.valueOf(Math.random()));
            if (this.f77596d) {
                str = "https://htrace.wetvinfo.com/kv";
            } else {
                str = "https://h.trace.qq.com/kv";
            }
            com.tencent.beacon.base.net.c.c().a(com.tencent.beacon.base.net.call.e.b().b(str).a(com.tencent.rmonitor.base.config.data.k.ATTA_CONFIG_KEY).a(linkedHashMap).a(HttpMethod.POST).a()).a(this.f77597e);
            com.tencent.beacon.base.util.c.d("[atta] upload a new error, errorCode: %s, message: %s, stack: %s", this.f77593a, this.f77594b, com.tencent.beacon.base.util.b.a(this.f77595c));
        }
    }
}
