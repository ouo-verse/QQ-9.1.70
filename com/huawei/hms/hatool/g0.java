package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class g0 {

    /* renamed from: c, reason: collision with root package name */
    private static g0 f37103c;

    /* renamed from: a, reason: collision with root package name */
    private Context f37104a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f37105b = new Object();

    g0() {
    }

    public static g0 a() {
        if (f37103c == null) {
            b();
        }
        return f37103c;
    }

    private static synchronized void b() {
        synchronized (g0.class) {
            if (f37103c == null) {
                f37103c = new g0();
            }
        }
    }

    private JSONObject a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException unused) {
                v.b("hmsSdk", "Exception occured when transferring bundle to json");
            }
        }
        return jSONObject;
    }

    public void b(String str, int i3, String str2, LinkedHashMap<String, String> linkedHashMap) {
        e.a().a(str, i3, str2, a(linkedHashMap), System.currentTimeMillis());
    }

    public void a(Context context) {
        synchronized (this.f37105b) {
            if (this.f37104a != null) {
                return;
            }
            this.f37104a = context;
            e.a().a(context);
        }
    }

    public void a(String str, int i3) {
        e.a().a(str, i3);
    }

    public void a(String str, int i3, String str2, LinkedHashMap<String, String> linkedHashMap) {
        e.a().a(str, i3, str2, a(linkedHashMap));
    }

    public void a(String str, Context context, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_constants", str3);
            e.a().a(str, 0, str2, jSONObject);
        } catch (JSONException unused) {
            v.f("hmsSdk", "onEvent():JSON structure Exception!");
        }
    }
}
