package com.tencent.luggage.wxa.ef;

import android.os.Bundle;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.x0;
import com.tencent.luggage.wxa.xk.a;
import com.tencent.qqmini.sdk.plugins.MapJsPlugin;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h extends com.tencent.luggage.wxa.ef.a {
    public static final int CTRL_INDEX = 1138;
    public static final String NAME = "getFuzzyLocation";

    /* renamed from: c, reason: collision with root package name */
    public static final BigDecimal f124689c = new BigDecimal(100);

    /* renamed from: d, reason: collision with root package name */
    public static final BigDecimal f124690d = new BigDecimal("0.01");

    /* renamed from: e, reason: collision with root package name */
    public static final BigDecimal f124691e = new BigDecimal("0.01");

    /* renamed from: b, reason: collision with root package name */
    public SecureRandom f124692b = new SecureRandom();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements a.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f124693a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f124694b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f124695c;

        public a(com.tencent.luggage.wxa.xd.d dVar, String str, int i3) {
            this.f124693a = dVar;
            this.f124694b = str;
            this.f124695c = i3;
        }

        @Override // com.tencent.luggage.wxa.xk.a.b
        public void a(int i3, String str, a.C6919a c6919a) {
            w.d("MicroMsg.JsApiGetFuzzyLocation", "errCode:%d, errStr:%s, location:%s", Integer.valueOf(i3), str, c6919a);
            h.this.a(this.f124693a, i3, str, c6919a);
            if (i3 == 0) {
                HashMap hashMap = new HashMap(4);
                hashMap.put("type", this.f124694b);
                double a16 = h.this.a(c6919a.f145141a);
                hashMap.put("latitude", Double.valueOf(a16));
                double b16 = h.this.b(c6919a.f145142b);
                hashMap.put("longitude", Double.valueOf(h.this.b(c6919a.f145142b)));
                if (com.tencent.luggage.wxa.tn.e.f141565g || com.tencent.luggage.wxa.tn.e.f141559a || x0.a()) {
                    w.d("MicroMsg.JsApiGetFuzzyLocation", "distance:%f", Double.valueOf(h.a(c6919a.f145141a, c6919a.f145142b, a16, b16)));
                }
                this.f124693a.a(this.f124695c, h.this.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a, hashMap));
                return;
            }
            HashMap hashMap2 = new HashMap(1);
            hashMap2.put("errCode", Integer.valueOf(i3));
            this.f124693a.a(this.f124695c, h.this.makeReturnJson("fail:" + str, com.tencent.luggage.wxa.af.f.f121331a, hashMap2));
        }
    }

    public static double c(double d16) {
        return (d16 * 3.141592653589793d) / 180.0d;
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

    public final double b(double d16) {
        BigDecimal bigDecimal = new BigDecimal(d16 + "");
        BigDecimal add = f124691e.add(f124690d.multiply(new BigDecimal(this.f124692b.nextInt(100))).divide(f124689c));
        if (this.f124692b.nextBoolean()) {
            return bigDecimal.add(add).doubleValue();
        }
        return bigDecimal.subtract(add).doubleValue();
    }

    public void c(com.tencent.luggage.wxa.xd.d dVar) {
    }

    @Override // com.tencent.luggage.wxa.ef.a
    public void a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        String trim = w0.d(jSONObject.optString("type", MapJsPlugin.LOCATION_TYPE_84)).trim();
        if (w0.c(trim)) {
            trim = MapJsPlugin.LOCATION_TYPE_84;
        }
        w.d("MicroMsg.JsApiGetFuzzyLocation", "getFuzzyLocation data:%s", jSONObject);
        if (!MapJsPlugin.LOCATION_TYPE_84.equals(trim) && !MapJsPlugin.LOCATION_TYPE_02.equals(trim)) {
            w.b("MicroMsg.JsApiGetFuzzyLocation", "doGeoLocation fail, unsupported type = %s", trim);
            HashMap hashMap = new HashMap(1);
            hashMap.put("errCode", -1);
            dVar.a(i3, makeReturnJson("fail:invalid data", com.tencent.luggage.wxa.af.e.f121315k, hashMap));
            return;
        }
        if (!b(dVar)) {
            HashMap hashMap2 = new HashMap(1);
            hashMap2.put("errCode", -2);
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121308d, hashMap2));
        } else {
            c(dVar);
            Bundle a16 = a(dVar, jSONObject);
            com.tencent.luggage.wxa.xk.a aVar = (com.tencent.luggage.wxa.xk.a) dVar.b(com.tencent.luggage.wxa.xk.a.class);
            if (aVar != null) {
                aVar.getLocation(trim, a(dVar, new a(dVar, trim, i3)), a16);
            }
        }
    }

    public static double a(double d16, double d17, double d18, double d19) {
        double c16 = c(d16);
        double c17 = c(d18);
        return (Math.round(((Math.asin(Math.sqrt(Math.pow(Math.sin((c16 - c17) / 2.0d), 2.0d) + ((Math.cos(c16) * Math.cos(c17)) * Math.pow(Math.sin((c(d17) - c(d19)) / 2.0d), 2.0d)))) * 2.0d) * 6378.137d) * 10000.0d) / 10000.0d) * 1000.0d;
    }

    public final double a(double d16) {
        BigDecimal bigDecimal = new BigDecimal(d16 + "");
        BigDecimal add = f124691e.add(f124690d.multiply(new BigDecimal(this.f124692b.nextInt(100))).divide(f124689c));
        if (this.f124692b.nextBoolean()) {
            return bigDecimal.add(add).doubleValue();
        }
        return bigDecimal.subtract(add).doubleValue();
    }

    public Bundle a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("useCache", dVar.getAppState() != com.tencent.luggage.wxa.qc.b.FOREGROUND);
        return bundle;
    }
}
