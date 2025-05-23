package com.tencent.beacon.event.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.beacon.a.a.d;
import com.tencent.beacon.a.c.e;
import com.tencent.beacon.a.c.j;
import com.tencent.beacon.event.c.g;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.EventType;
import com.tencent.beacon.module.EventModule;
import com.tencent.beacon.module.ModuleName;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b extends c implements d {

    /* renamed from: b, reason: collision with root package name */
    private boolean f77898b = false;

    /* renamed from: c, reason: collision with root package name */
    private String f77899c;

    public b() {
        com.tencent.beacon.a.a.b.a().a(2, this);
    }

    private boolean c(BeaconEvent beaconEvent) {
        if (beaconEvent.getType() != EventType.IMMEDIATE_WNS && beaconEvent.getType() != EventType.IMMEDIATE_MSF) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.beacon.event.b.c
    BeaconEvent a(BeaconEvent beaconEvent) {
        if (this.f77898b && !com.tencent.beacon.base.util.b.a(beaconEvent.getCode())) {
            return beaconEvent;
        }
        com.tencent.beacon.a.c.c c16 = com.tencent.beacon.a.c.c.c();
        Context b16 = c16.b();
        Map<String, String> params = beaconEvent.getParams();
        params.put("A3", j.b());
        params.put("A153", j.c());
        params.put("A157", j.e());
        params.put("A19", e.l().q());
        params.put("A95", "" + com.tencent.beacon.a.c.b.a());
        params.put("A48", com.tencent.beacon.a.c.c.c().d());
        params.put("A99", beaconEvent.getLogidPrefix());
        params.put("A72", c16.i());
        if (!TextUtils.isEmpty(com.tencent.beacon.a.c.c.c().f())) {
            params.put("A143", com.tencent.beacon.a.c.c.c().f());
        }
        if (!TextUtils.isEmpty(com.tencent.beacon.a.c.b.c())) {
            params.put("QQ", com.tencent.beacon.a.c.b.c());
        }
        if (TextUtils.isEmpty(j.c())) {
            params.put("A141", j.f());
        }
        String appKey = beaconEvent.getAppKey();
        EventModule eventModule = (EventModule) c16.a(ModuleName.EVENT);
        if (!TextUtils.isEmpty(c16.a(appKey))) {
            params.put("A23", c16.a(appKey));
        }
        if (!TextUtils.isEmpty(eventModule.c(appKey))) {
            params.put("A1", eventModule.c(appKey));
        }
        if (!TextUtils.isEmpty(eventModule.b(appKey))) {
            params.put("A8", eventModule.b(appKey));
        }
        params.put("A34", String.valueOf(com.tencent.beacon.base.util.b.c()));
        params.put("A156", c(beaconEvent) ? "Y" : "N");
        if (!params.containsKey("A88")) {
            if (TextUtils.isEmpty(this.f77899c)) {
                this.f77899c = com.tencent.beacon.a.c.b.a(b16);
            }
            params.put("A88", this.f77899c);
        }
        params.put("A100", g.a(b16, appKey).a(beaconEvent.getCode(), beaconEvent.getType()));
        Map<String, String> a16 = eventModule.a(appKey);
        if (a16 != null) {
            params.putAll(a16);
        }
        beaconEvent.setParams(params);
        return beaconEvent;
    }

    @Override // com.tencent.beacon.a.a.d
    public void a(com.tencent.beacon.a.a.c cVar) {
        HashMap hashMap;
        if (cVar.f77584a == 2 && (hashMap = (HashMap) cVar.f77585b.get("d_m")) != null) {
            this.f77898b = com.tencent.beacon.base.util.b.a((String) hashMap.get("tidyEF"), this.f77898b);
        }
    }
}
