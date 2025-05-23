package com.huawei.hms.framework.network.grs.g.k;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final GrsBaseInfo f37032a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f37033b;

    /* renamed from: c, reason: collision with root package name */
    private final Set<String> f37034c = new HashSet();

    public c(GrsBaseInfo grsBaseInfo, Context context) {
        this.f37032a = grsBaseInfo;
        this.f37033b = context;
    }

    private String e() {
        Set<String> b16 = com.huawei.hms.framework.network.grs.f.b.a(this.f37033b.getPackageName(), this.f37032a).b();
        if (b16.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = b16.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(it.next());
        }
        try {
            jSONObject.put("services", jSONArray);
            Logger.i("GrsRequestInfo", "post service list is:%s", jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    private String f() {
        Logger.v("GrsRequestInfo", "getGeoipService enter");
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.f37034c.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(it.next());
        }
        try {
            jSONObject.put("services", jSONArray);
            Logger.v("GrsRequestInfo", "post query service list is:%s", jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    public Context a() {
        return this.f37033b;
    }

    public GrsBaseInfo b() {
        return this.f37032a;
    }

    public String c() {
        if (this.f37034c.size() == 0) {
            return e();
        }
        return f();
    }

    public Set<String> d() {
        return this.f37034c;
    }

    public void a(String str) {
        this.f37034c.add(str);
    }
}
