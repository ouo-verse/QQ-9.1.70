package com.tencent.luggage.wxa.bd;

import android.graphics.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public Map f122392a = new HashMap();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static e f122393a = new e();
    }

    public e() {
        a(new h());
        a(new f());
        a(new g());
        a(new i());
        a(new d());
        a(new b());
        a(new c());
        a(new j());
    }

    public static e a() {
        return a.f122393a;
    }

    public Path a(com.tencent.luggage.wxa.yc.c cVar) {
        Path path = new Path();
        List<com.tencent.luggage.wxa.yc.a> list = cVar.f145521b;
        if (list != null && list.size() != 0) {
            for (com.tencent.luggage.wxa.yc.a aVar : list) {
                if (aVar != null) {
                    a(path, aVar);
                }
            }
        }
        return path;
    }

    public final boolean a(Path path, com.tencent.luggage.wxa.yc.a aVar) {
        com.tencent.luggage.wxa.bd.a aVar2 = (com.tencent.luggage.wxa.bd.a) this.f122392a.get(aVar.f144662a);
        if (aVar2 == null) {
            return false;
        }
        return aVar2.a(path, aVar);
    }

    public Path a(JSONArray jSONArray) {
        Path path = new Path();
        if (jSONArray != null && jSONArray.length() != 0) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    a(path, optJSONObject);
                }
            }
        }
        return path;
    }

    public final boolean a(Path path, JSONObject jSONObject) {
        String optString = jSONObject.optString("method");
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        com.tencent.luggage.wxa.bd.a aVar = (com.tencent.luggage.wxa.bd.a) this.f122392a.get(optString);
        if (aVar == null) {
            return false;
        }
        return aVar.a(path, optJSONArray);
    }

    public final void a(com.tencent.luggage.wxa.bd.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f122392a.put(aVar.getMethod(), aVar);
    }
}
