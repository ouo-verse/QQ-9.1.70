package com.tencent.luggage.wxa.ef;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.luggage.wxa.xk.a;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends k0 implements a.b {
    private static final int CTRL_INDEX = 341;
    private static final String NAME = "onLocationChange";

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.xd.d f124675a;

    public b(com.tencent.luggage.wxa.xd.d dVar) {
        this.f124675a = dVar;
    }

    @Override // com.tencent.luggage.wxa.xk.a.b
    public void a(int i3, String str, a.C6919a c6919a) {
        if (i3 != 0) {
            w.b("MicroMsg.AppBrand.EventOnLocationChange", "errCode:%d, errStr:%s", Integer.valueOf(i3), str);
            return;
        }
        HashMap hashMap = new HashMap(7);
        hashMap.put("longitude", Double.valueOf(c6919a.f145142b));
        hashMap.put("latitude", Double.valueOf(c6919a.f145141a));
        hashMap.put("speed", Double.valueOf(c6919a.f145144d));
        hashMap.put("accuracy", Double.valueOf(c6919a.f145145e));
        hashMap.put("altitude", Double.valueOf(c6919a.f145146f));
        hashMap.put("verticalAccuracy", Float.valueOf(0.0f));
        hashMap.put("horizontalAccuracy", Double.valueOf(c6919a.f145145e));
        if (!w0.c(c6919a.f145147g)) {
            hashMap.put("buildingId", c6919a.f145147g);
            hashMap.put("floorName", c6919a.f145148h);
        }
        hashMap.put("provider", c6919a.f145143c);
        hashMap.put("indoorLocationType", Integer.valueOf(c6919a.f145150j));
        hashMap.put("direction", Float.valueOf(c6919a.f145151k));
        hashMap.put("steps", Double.valueOf(c6919a.f145152l));
        hashMap.put("type", c6919a.f145153m);
        String jSONObject = new JSONObject(hashMap).toString();
        w.g("MicroMsg.AppBrand.EventOnLocationChange", "onLocationChanged %s, %s, %s", this.f124675a.getAppId(), c6919a.f145143c, jSONObject);
        synchronized (this) {
            setContext(this.f124675a).setData(jSONObject).dispatch();
        }
    }
}
