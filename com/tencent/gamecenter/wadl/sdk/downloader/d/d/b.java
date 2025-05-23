package com.tencent.gamecenter.wadl.sdk.downloader.d.d;

import com.tencent.gamecenter.wadl.sdk.common.e.g;
import com.tencent.rmonitor.base.config.data.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f107368a;

    /* renamed from: b, reason: collision with root package name */
    public String f107369b;

    /* renamed from: c, reason: collision with root package name */
    public long f107370c;

    /* renamed from: d, reason: collision with root package name */
    public String f107371d;

    /* renamed from: e, reason: collision with root package name */
    public String f107372e;

    /* renamed from: f, reason: collision with root package name */
    public String f107373f;

    /* renamed from: g, reason: collision with root package name */
    public List<C1131b> f107374g;

    /* renamed from: h, reason: collision with root package name */
    public List<com.tencent.gamecenter.wadl.sdk.downloader.d.a> f107375h;

    /* renamed from: i, reason: collision with root package name */
    public List<String> f107376i;

    /* renamed from: j, reason: collision with root package name */
    public Map<Integer, Map<String, String>> f107377j = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.gamecenter.wadl.sdk.downloader.d.d.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1131b {

        /* renamed from: a, reason: collision with root package name */
        private int f107378a;

        /* renamed from: b, reason: collision with root package name */
        private String f107379b;

        /* renamed from: c, reason: collision with root package name */
        private List<String> f107380c;

        /* renamed from: d, reason: collision with root package name */
        private String f107381d;

        /* renamed from: e, reason: collision with root package name */
        private Map<String, String> f107382e;

        C1131b() {
            this.f107382e = new HashMap();
        }
    }

    public b(JSONObject jSONObject, String str) {
        a(jSONObject, str);
    }

    private List<com.tencent.gamecenter.wadl.sdk.downloader.d.a> a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return this.f107375h;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            arrayList.add(new com.tencent.gamecenter.wadl.sdk.downloader.d.a(jSONObject.optLong("offset"), jSONObject.optInt("length")));
        }
        return arrayList;
    }

    private List<C1131b> b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                C1131b c1131b = new C1131b();
                c1131b.f107378a = jSONObject.optInt("type");
                c1131b.f107379b = jSONObject.optString("realurl");
                JSONArray optJSONArray = jSONObject.optJSONArray("iplist");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("ipv6list");
                c1131b.f107380c = new ArrayList();
                boolean z16 = true;
                if (optJSONArray2 != null) {
                    int i16 = 0;
                    while (i16 < optJSONArray2.length()) {
                        c1131b.f107380c.add((String) optJSONArray2.get(i16));
                        i16++;
                        z16 = false;
                    }
                }
                if (z16 && optJSONArray != null) {
                    for (int i17 = 0; i17 < optJSONArray.length(); i17++) {
                        c1131b.f107380c.add((String) optJSONArray.get(i17));
                    }
                }
                c1131b.f107381d = jSONObject.optString("scheurl");
                JSONObject optJSONObject = jSONObject.optJSONObject("headers");
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    c1131b.f107382e.put(str, optJSONObject.optString(str));
                }
                arrayList.add(c1131b);
            }
        }
        return arrayList;
    }

    private void a(JSONObject jSONObject, String str) {
        this.f107368a = false;
        try {
            jSONObject.optString("ipinfo");
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("resultmap"));
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                this.f107369b = str2;
                if (str2.equals(str)) {
                    JSONObject optJSONObject = jSONObject2.optJSONObject(this.f107369b);
                    optJSONObject.optInt("code");
                    this.f107370c = optJSONObject.optLong("size");
                    this.f107371d = optJSONObject.optString("md5");
                    this.f107372e = optJSONObject.optString("schedulecode");
                    this.f107373f = optJSONObject.optString("featuresmd5");
                    this.f107374g = b(optJSONObject.optJSONArray("reselements"));
                    this.f107375h = a(optJSONObject.optJSONArray(k.FEATURES_KEY));
                    this.f107376i = new ArrayList();
                    for (C1131b c1131b : this.f107374g) {
                        if (c1131b.f107378a == 0) {
                            this.f107376i.add(c1131b.f107381d);
                            Iterator it = c1131b.f107380c.iterator();
                            while (it.hasNext()) {
                                this.f107376i.add(g.a(c1131b.f107381d, (String) it.next()));
                            }
                        } else if (c1131b.f107378a == 1) {
                            this.f107376i.add(c1131b.f107381d);
                        }
                        if (c1131b.f107382e.size() > 0) {
                            this.f107377j.put(Integer.valueOf(c1131b.f107378a), c1131b.f107382e);
                        }
                    }
                }
            }
            this.f107368a = true;
        } catch (Exception e16) {
            this.f107368a = false;
            e16.printStackTrace();
        }
    }
}
