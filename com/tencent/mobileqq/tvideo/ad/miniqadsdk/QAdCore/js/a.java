package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.QAdRouteJsApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.QAdSpaJsApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.QAdUserJsApi;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import pw2.n;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a> f303835a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, d> f303836b;

    /* renamed from: c, reason: collision with root package name */
    private b f303837c;

    /* renamed from: d, reason: collision with root package name */
    private String f303838d;

    /* renamed from: e, reason: collision with root package name */
    private String f303839e;

    public a(b bVar) {
        this.f303837c = bVar;
        g();
        h();
        b();
    }

    private void a(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a aVar) {
        if (aVar == null) {
            return;
        }
        for (Method method : aVar.getClass().getMethods()) {
            if (method.isAnnotationPresent(QAdBasicInterface.class)) {
                this.f303836b.put(c(method), new d(aVar, method));
            }
        }
    }

    private void b() {
        if (y.i(this.f303836b)) {
            n.e("QADJsApiContainer", "genInjectJS fail");
            return;
        }
        try {
            StringBuilder i3 = i();
            String e16 = e();
            if (!TextUtils.isEmpty(e16)) {
                e16 = e16.replace("${injectedName}", "TenvideoJSBridge").replace("${allFuncName}", i3.toString());
            }
            this.f303838d = e16;
        } catch (Exception e17) {
            n.b("QADJsApiContainer", "init js error:" + e17.getMessage());
        }
    }

    private String c(Method method) {
        StringBuffer stringBuffer = new StringBuffer(method.getName());
        for (Class<?> cls : method.getParameterTypes()) {
            if (cls == String.class) {
                stringBuffer.append("_S");
            } else if (cls == String[].class) {
                stringBuffer.append("_[LS");
            } else if (cls == long[].class) {
                stringBuffer.append("_[LN");
            } else if (cls != Integer.TYPE && cls != Long.TYPE && cls != Float.TYPE && cls != Double.TYPE) {
                if (cls == Boolean.TYPE) {
                    stringBuffer.append("_B");
                } else if (cls == JSONObject.class) {
                    stringBuffer.append("_O");
                } else if (cls == jv2.c.class) {
                    stringBuffer.append("_F");
                } else {
                    stringBuffer.append("_P");
                }
            } else {
                stringBuffer.append("_N");
            }
        }
        return stringBuffer.toString();
    }

    private String e() {
        if (!TextUtils.isEmpty(this.f303839e)) {
            return this.f303839e;
        }
        String e16 = y.e(qv2.b.a(), "qad_tvideojs.js");
        this.f303839e = e16;
        return e16;
    }

    private void g() {
        HashMap<String, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a> hashMap = new HashMap<>();
        this.f303835a = hashMap;
        hashMap.put("QAdSpaJsApi", new QAdSpaJsApi(this, this.f303837c));
        this.f303835a.put("QAdRouteJsApi", new QAdRouteJsApi(this, this.f303837c));
        this.f303835a.put("QAdUserJsApi", new QAdUserJsApi(this, this.f303837c));
    }

    private void h() {
        this.f303836b = new HashMap<>();
        Iterator<Map.Entry<String, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a>> it = this.f303835a.entrySet().iterator();
        while (it.hasNext()) {
            a(it.next().getValue());
        }
    }

    private StringBuilder i() {
        StringBuilder sb5 = new StringBuilder(10240);
        for (d dVar : this.f303836b.values()) {
            sb5.append("a.");
            sb5.append(dVar.f303847b.getName());
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        }
        return sb5;
    }

    public HashMap<String, d> d() {
        return this.f303836b;
    }

    public String f() {
        return this.f303838d;
    }

    public void j(jv2.a aVar) {
        QAdSpaJsApi qAdSpaJsApi = (QAdSpaJsApi) this.f303835a.get("QAdSpaJsApi");
        if (qAdSpaJsApi != null) {
            qAdSpaJsApi.updateDataHandler(aVar);
        }
    }
}
