package com.tencent.luggage.wxa.ef;

import android.os.Bundle;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xk.a;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qqmini.sdk.plugins.MapJsPlugin;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class k extends com.tencent.luggage.wxa.ef.a {
    public static final int CTRL_INDEX = 37;
    public static final String NAME = "getLocation";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements a.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f124698a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f124699b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f124700c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f124701d;

        public a(com.tencent.luggage.wxa.xd.d dVar, String str, boolean z16, int i3) {
            this.f124698a = dVar;
            this.f124699b = str;
            this.f124700c = z16;
            this.f124701d = i3;
        }

        @Override // com.tencent.luggage.wxa.xk.a.b
        public void a(int i3, String str, a.C6919a c6919a) {
            w.d("MicroMsg.JsApiGetLocation", "errCode:%d, errStr:%s, location:%s", Integer.valueOf(i3), str, c6919a);
            k.this.a(this.f124698a, i3, str, c6919a);
            if (i3 == 0) {
                HashMap hashMap = new HashMap(4);
                hashMap.put("type", this.f124699b);
                hashMap.put("latitude", Double.valueOf(c6919a.f145141a));
                hashMap.put("longitude", Double.valueOf(c6919a.f145142b));
                hashMap.put("speed", Double.valueOf(c6919a.f145144d));
                hashMap.put("accuracy", Double.valueOf(c6919a.f145145e));
                if (this.f124700c) {
                    hashMap.put("altitude", Double.valueOf(c6919a.f145146f));
                }
                hashMap.put("provider", c6919a.f145143c);
                hashMap.put("verticalAccuracy", 0);
                hashMap.put("horizontalAccuracy", Double.valueOf(c6919a.f145145e));
                if (!w0.c(c6919a.f145147g)) {
                    hashMap.put("buildingId", c6919a.f145147g);
                    hashMap.put("floorName", c6919a.f145148h);
                }
                hashMap.put("indoorLocationType", Integer.valueOf(c6919a.f145150j));
                hashMap.put("direction", Float.valueOf(c6919a.f145151k));
                hashMap.put("steps", Double.valueOf(c6919a.f145152l));
                this.f124698a.a(this.f124701d, k.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
                return;
            }
            HashMap hashMap2 = new HashMap(1);
            hashMap2.put("errCode", Integer.valueOf(i3));
            this.f124698a.a(this.f124701d, k.this.makeReturnJson("fail:" + str, hashMap2));
        }
    }

    public a.b a(com.tencent.luggage.wxa.xd.d dVar, a.b bVar) {
        return bVar;
    }

    @Override // com.tencent.luggage.wxa.ef.a, com.tencent.luggage.wxa.xd.a
    public /* bridge */ /* synthetic */ void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        super.invoke(dVar, jSONObject, i3);
    }

    public void a(com.tencent.luggage.wxa.xd.d dVar, int i3, String str, a.C6919a c6919a) {
    }

    @Override // com.tencent.luggage.wxa.ef.a
    public void a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        String trim = w0.d(jSONObject.optString("type", MapJsPlugin.LOCATION_TYPE_84)).trim();
        if (w0.c(trim)) {
            trim = MapJsPlugin.LOCATION_TYPE_84;
        }
        boolean optBoolean = jSONObject.optBoolean("altitude", false);
        w.d("MicroMsg.JsApiGetLocation", "getLocation data:%s", jSONObject);
        if (!MapJsPlugin.LOCATION_TYPE_84.equals(trim) && !MapJsPlugin.LOCATION_TYPE_02.equals(trim)) {
            w.b("MicroMsg.JsApiGetLocation", "doGeoLocation fail, unsupported type = %s", trim);
            HashMap hashMap = new HashMap(1);
            hashMap.put("errCode", -1);
            dVar.a(i3, makeReturnJson("fail:invalid data", hashMap));
            return;
        }
        if (!b(dVar)) {
            HashMap hashMap2 = new HashMap(1);
            hashMap2.put("errCode", -2);
            dVar.a(i3, makeReturnJson("fail:system permission denied", hashMap2));
        } else {
            c(dVar);
            Bundle a16 = a(dVar, jSONObject);
            com.tencent.luggage.wxa.xk.a aVar = (com.tencent.luggage.wxa.xk.a) dVar.b(com.tencent.luggage.wxa.xk.a.class);
            if (aVar != null) {
                aVar.getLocation(trim, a(dVar, new a(dVar, trim, optBoolean, i3)), a16);
            }
        }
    }

    public Bundle a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        boolean optBoolean = jSONObject.optBoolean("isHighAccuracy", false);
        int optInt = jSONObject.optInt("highAccuracyExpireTime", 3000);
        bundle.putBoolean("isHighAccuracy", optBoolean);
        bundle.putInt("highAccuracyExpireTime", optInt);
        bundle.putBoolean("useCache", dVar.getAppState() != com.tencent.luggage.wxa.qc.b.FOREGROUND);
        return bundle;
    }

    public void c(com.tencent.luggage.wxa.xd.d dVar) {
    }
}
