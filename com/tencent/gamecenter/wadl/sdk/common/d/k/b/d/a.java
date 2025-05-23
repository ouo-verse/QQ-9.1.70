package com.tencent.gamecenter.wadl.sdk.common.d.k.b.d;

import com.tencent.gamecenter.wadl.sdk.common.b.g;
import com.tencent.gamecenter.wadl.sdk.common.d.k.a.c.e;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a extends com.tencent.gamecenter.wadl.sdk.common.d.k.b.b {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f107194b = true;

    /* renamed from: c, reason: collision with root package name */
    public static String f107195c;

    /* renamed from: a, reason: collision with root package name */
    public e f107196a;

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.k.b.b
    public void a(com.tencent.gamecenter.wadl.sdk.common.d.k.b.a aVar) {
        if (g.a("detect_use_http_platform_on", 0, 1, 1) == 0) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-cloud-HttpDetectHandler", "ignore detect when K_detect_use_http_platform_on is 0..");
            return;
        }
        if (g.a("detect_when_start", 0, 1, 1) == 0 && f107194b) {
            f107194b = false;
            com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-cloud-HttpDetectHandler", "ignore detect when init..");
            return;
        }
        String str = f107195c;
        if (str != null && str.equals(com.tencent.gamecenter.wadl.sdk.common.b.c.b())) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-cloud-HttpDetectHandler", "lastApn is the same as the last.. just ignore detect");
            return;
        }
        f107195c = com.tencent.gamecenter.wadl.sdk.common.b.c.b();
        if (g.a("detect_only_in_ipv6_on", 0, 1, 1) != 1) {
            aVar.a("detectflag", 1);
        } else if (com.tencent.gamecenter.wadl.sdk.common.b.c.c() != 3 && com.tencent.gamecenter.wadl.sdk.common.b.c.c() != 2) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-cloud-HttpDetectHandler", "Not in ipv6 network, just ignore detect pull");
        } else {
            com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-cloud-HttpDetectHandler", "In ipv6 network, just trigger detect pull");
            aVar.a("detectflag", 1);
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.k.b.b
    public String d() {
        return "detector";
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.k.b.b
    public void a(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("NetmonTask");
            if (optJSONObject != null) {
                c cVar = new c(optJSONObject);
                ArrayList<b> arrayList = cVar.f107201a;
                if (arrayList != null && arrayList.size() != 0) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<b> it = cVar.f107201a.iterator();
                    while (it.hasNext()) {
                        b next = it.next();
                        com.tencent.gamecenter.wadl.sdk.common.d.k.a.c.a a16 = com.tencent.gamecenter.wadl.sdk.common.d.k.a.c.a.a(cVar.f107202b, next.f107197a, next.f107198b);
                        if (a16 != null) {
                            a16.a(cVar.f107203c, next.f107199c);
                            arrayList2.add(a16);
                        }
                    }
                    e eVar = this.f107196a;
                    if (eVar == null) {
                        eVar = com.tencent.gamecenter.wadl.sdk.common.d.k.a.c.c.b();
                        this.f107196a = eVar;
                    }
                    eVar.a(arrayList2);
                    return;
                }
                com.tencent.gamecenter.wadl.sdk.common.e.b.b("HttpDetectorHandler", "httpNetmonTask is empty");
            }
        } catch (Throwable unused) {
        }
    }
}
