package com.huawei.hms.framework.network.grs.e;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.g.d;
import com.huawei.hms.framework.network.grs.g.h;
import com.huawei.hms.framework.network.grs.h.e;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: f, reason: collision with root package name */
    private static final String f36940f = "a";

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Map<String, Map<String, String>>> f36941a = new ConcurrentHashMap(16);

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, Long> f36942b = new ConcurrentHashMap(16);

    /* renamed from: c, reason: collision with root package name */
    private final c f36943c;

    /* renamed from: d, reason: collision with root package name */
    private final c f36944d;

    /* renamed from: e, reason: collision with root package name */
    private final h f36945e;

    public a(c cVar, c cVar2, h hVar) {
        this.f36944d = cVar2;
        this.f36943c = cVar;
        this.f36945e = hVar;
        hVar.a(this);
    }

    public c a() {
        return this.f36943c;
    }

    public h b() {
        return this.f36945e;
    }

    public c c() {
        return this.f36944d;
    }

    public Map<String, String> a(GrsBaseInfo grsBaseInfo, String str, b bVar, Context context) {
        Map<String, Map<String, String>> map = this.f36941a.get(grsBaseInfo.getGrsParasKey(true, true, context));
        if (map == null || map.isEmpty()) {
            return new HashMap();
        }
        a(grsBaseInfo, bVar, context, str);
        return map.get(str);
    }

    public void b(GrsBaseInfo grsBaseInfo, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        String a16 = this.f36943c.a(grsParasKey, "");
        String a17 = this.f36943c.a(grsParasKey + "time", "0");
        long j3 = 0;
        if (!TextUtils.isEmpty(a17) && a17.matches("\\d+")) {
            try {
                j3 = Long.parseLong(a17);
            } catch (NumberFormatException e16) {
                Logger.w(f36940f, "convert urlParamKey from String to Long catch NumberFormatException.", e16);
            }
        }
        this.f36941a.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(a16));
        this.f36942b.put(grsParasKey, Long.valueOf(j3));
        a(grsBaseInfo, grsParasKey, context);
    }

    public void a(GrsBaseInfo grsBaseInfo, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        this.f36943c.b(grsParasKey + "time", "0");
        this.f36942b.remove(grsParasKey + "time");
        this.f36941a.remove(grsParasKey);
        this.f36945e.a(grsParasKey);
    }

    private void a(GrsBaseInfo grsBaseInfo, b bVar, Context context, String str) {
        Long l3 = this.f36942b.get(grsBaseInfo.getGrsParasKey(true, true, context));
        if (e.a(l3)) {
            bVar.a(2);
            return;
        }
        if (e.a(l3, MiniBoxNoticeInfo.MIN_5)) {
            this.f36945e.a(new com.huawei.hms.framework.network.grs.g.k.c(grsBaseInfo, context), null, str, this.f36944d);
        }
        bVar.a(1);
    }

    public void a(GrsBaseInfo grsBaseInfo, d dVar, Context context, com.huawei.hms.framework.network.grs.g.k.c cVar) {
        if (dVar.f() == 2) {
            Logger.w(f36940f, "update cache from server failed");
            return;
        }
        if (cVar.d().size() != 0) {
            this.f36943c.b("geoipCountryCode", dVar.j());
            this.f36943c.b("geoipCountryCodetime", dVar.a());
            return;
        }
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        if (dVar.m()) {
            this.f36941a.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(this.f36943c.a(grsParasKey, "")));
        } else {
            this.f36943c.b(grsParasKey, dVar.j());
            this.f36941a.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(dVar.j()));
        }
        if (!TextUtils.isEmpty(dVar.e())) {
            this.f36943c.b(grsParasKey + "ETag", dVar.e());
        }
        this.f36943c.b(grsParasKey + "time", dVar.a());
        this.f36942b.put(grsParasKey, Long.valueOf(Long.parseLong(dVar.a())));
    }

    private void a(GrsBaseInfo grsBaseInfo, String str, Context context) {
        if (e.a(this.f36942b.get(str), MiniBoxNoticeInfo.MIN_5)) {
            this.f36945e.a(new com.huawei.hms.framework.network.grs.g.k.c(grsBaseInfo, context), null, null, this.f36944d);
        }
    }
}
