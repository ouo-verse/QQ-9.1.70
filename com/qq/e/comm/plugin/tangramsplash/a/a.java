package com.qq.e.comm.plugin.tangramsplash.a;

import android.text.TextUtils;
import com.qq.e.comm.util.Md5Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    static String f39760a = "uoid";

    /* renamed from: b, reason: collision with root package name */
    static String f39761b = "date";

    /* renamed from: c, reason: collision with root package name */
    static String f39762c = "exposureUrl";

    /* renamed from: d, reason: collision with root package name */
    static String f39763d = "customUrls";

    /* renamed from: e, reason: collision with root package name */
    static String f39764e = "c2sSdkUrls";

    /* renamed from: f, reason: collision with root package name */
    static String f39765f = "posId";

    /* renamed from: g, reason: collision with root package name */
    static String f39766g = "traceId";

    /* renamed from: h, reason: collision with root package name */
    static String f39767h = "cl";

    /* renamed from: i, reason: collision with root package name */
    static String f39768i = "isHotStart";

    /* renamed from: j, reason: collision with root package name */
    static String f39769j = "originalEpUrl";

    /* renamed from: k, reason: collision with root package name */
    static String f39770k = "appInstalledStatus";

    /* renamed from: l, reason: collision with root package name */
    public String f39771l;

    /* renamed from: m, reason: collision with root package name */
    public String f39772m;

    /* renamed from: n, reason: collision with root package name */
    public String f39773n;

    /* renamed from: o, reason: collision with root package name */
    public List<String> f39774o;

    /* renamed from: p, reason: collision with root package name */
    public List<String> f39775p;

    /* renamed from: q, reason: collision with root package name */
    public String f39776q;

    /* renamed from: r, reason: collision with root package name */
    public String f39777r;

    /* renamed from: s, reason: collision with root package name */
    public String f39778s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f39779t;

    /* renamed from: u, reason: collision with root package name */
    public String f39780u;

    /* renamed from: v, reason: collision with root package name */
    public String f39781v;

    public a() {
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f39771l = jSONObject.optString(f39760a, "");
            this.f39772m = jSONObject.optString(f39761b, "");
            this.f39773n = jSONObject.optString(f39762c, "");
            this.f39776q = jSONObject.optString(f39765f, "");
            this.f39777r = jSONObject.optString(f39766g, "");
            this.f39778s = jSONObject.optString(f39767h, "");
            this.f39779t = jSONObject.optBoolean(f39768i, false);
            JSONArray optJSONArray = jSONObject.optJSONArray(f39763d);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.f39774o = new ArrayList();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    this.f39774o.add(optJSONArray.optString(i3));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray(f39764e);
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                this.f39775p = new ArrayList();
                for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                    this.f39775p.add(optJSONArray2.optString(i16));
                }
            }
            this.f39780u = jSONObject.optString(f39769j, "");
            this.f39781v = jSONObject.optString(f39770k, "");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public String b() {
        if (!TextUtils.isEmpty(this.f39771l) && !TextUtils.isEmpty(this.f39772m)) {
            return Md5Util.encode(com.qq.e.comm.plugin.tangramsplash.d.a.a());
        }
        return "";
    }

    public a(String str) {
        a(str);
    }

    public String a() {
        if (TextUtils.isEmpty(this.f39771l)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.f39771l)) {
                jSONObject.put(f39760a, this.f39771l);
            }
            if (!TextUtils.isEmpty(this.f39772m)) {
                jSONObject.put(f39761b, this.f39772m);
            }
            if (!TextUtils.isEmpty(this.f39773n)) {
                jSONObject.put(f39762c, this.f39773n);
            }
            if (!TextUtils.isEmpty(this.f39776q)) {
                jSONObject.put(f39765f, this.f39776q);
            }
            if (!TextUtils.isEmpty(this.f39777r)) {
                jSONObject.put(f39766g, this.f39777r);
            }
            if (!TextUtils.isEmpty(this.f39778s)) {
                jSONObject.put(f39767h, this.f39778s);
            }
            jSONObject.put(f39768i, this.f39779t);
            List<String> list = this.f39774o;
            if (list != null && list.size() > 0) {
                jSONObject.put(f39763d, new JSONArray((Collection) this.f39774o));
            }
            List<String> list2 = this.f39775p;
            if (list2 != null && list2.size() > 0) {
                jSONObject.put(f39764e, new JSONArray((Collection) this.f39775p));
            }
            if (!TextUtils.isEmpty(this.f39780u)) {
                jSONObject.put(f39769j, this.f39780u);
            }
            if (!TextUtils.isEmpty(this.f39781v)) {
                jSONObject.put(f39770k, this.f39781v);
            }
            return jSONObject.toString();
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "";
        }
    }
}
