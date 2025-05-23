package com.tencent.halley.downloader.e.a;

import com.tencent.halley.common.utils.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rmonitor.base.config.data.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f113725a;

    /* renamed from: b, reason: collision with root package name */
    public String f113726b;

    /* renamed from: c, reason: collision with root package name */
    public String f113727c;

    /* renamed from: d, reason: collision with root package name */
    public int f113728d;

    /* renamed from: e, reason: collision with root package name */
    public long f113729e;

    /* renamed from: f, reason: collision with root package name */
    public String f113730f;

    /* renamed from: g, reason: collision with root package name */
    public String f113731g;

    /* renamed from: h, reason: collision with root package name */
    public String f113732h;

    /* renamed from: i, reason: collision with root package name */
    public List<a> f113733i;

    /* renamed from: j, reason: collision with root package name */
    public List<com.tencent.halley.downloader.e.a> f113734j;

    /* renamed from: k, reason: collision with root package name */
    public List<String> f113735k;

    /* renamed from: l, reason: collision with root package name */
    public Map<Integer, Map<String, String>> f113736l;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f113737a;

        /* renamed from: b, reason: collision with root package name */
        String f113738b;

        /* renamed from: c, reason: collision with root package name */
        public List<String> f113739c;

        /* renamed from: d, reason: collision with root package name */
        String f113740d;

        /* renamed from: e, reason: collision with root package name */
        Map<String, String> f113741e;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f113741e = new HashMap();
            }
        }
    }

    public b(JSONObject jSONObject, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) jSONObject, (Object) str);
        } else {
            this.f113736l = new HashMap();
            a(jSONObject, str);
        }
    }

    private void a(JSONArray jSONArray) {
        JSONObject jSONObject;
        String str;
        String str2;
        if (jSONArray == null) {
            return;
        }
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            try {
                jSONObject = jSONArray.getJSONObject(i3);
            } catch (JSONException e16) {
                e16.printStackTrace();
                jSONObject = null;
            }
            a aVar = new a();
            aVar.f113737a = jSONObject.optInt("type");
            aVar.f113738b = jSONObject.optString("realurl");
            JSONArray optJSONArray = jSONObject.optJSONArray("iplist");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("ipv6list");
            aVar.f113739c = new ArrayList();
            boolean z16 = true;
            if (optJSONArray2 != null) {
                int i16 = 0;
                while (i16 < optJSONArray2.length()) {
                    try {
                        str2 = (String) optJSONArray2.get(i16);
                    } catch (JSONException e17) {
                        e17.printStackTrace();
                        str2 = null;
                    }
                    aVar.f113739c.add(str2);
                    i16++;
                    z16 = false;
                }
            }
            if (z16 && optJSONArray != null) {
                for (int i17 = 0; i17 < optJSONArray.length(); i17++) {
                    try {
                        str = (String) optJSONArray.get(i17);
                    } catch (JSONException e18) {
                        e18.printStackTrace();
                        str = null;
                    }
                    aVar.f113739c.add(str);
                }
            }
            aVar.f113740d = jSONObject.optString("scheurl");
            JSONObject optJSONObject = jSONObject.optJSONObject("headers");
            Iterator keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String str3 = (String) keys.next();
                aVar.f113741e.put(str3, optJSONObject.optString(str3));
            }
            this.f113733i.add(aVar);
        }
    }

    private void a(JSONObject jSONObject, String str) {
        this.f113725a = false;
        try {
            this.f113726b = jSONObject.optString("ipinfo");
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("resultmap"));
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                this.f113727c = str2;
                if (str2.equals(str)) {
                    JSONObject optJSONObject = jSONObject2.optJSONObject(this.f113727c);
                    this.f113728d = optJSONObject.optInt("code");
                    this.f113729e = optJSONObject.optLong("size");
                    this.f113730f = optJSONObject.optString("md5");
                    this.f113731g = optJSONObject.optString("schedulecode");
                    this.f113732h = optJSONObject.optString("featuresmd5");
                    JSONArray optJSONArray = optJSONObject.optJSONArray("reselements");
                    this.f113733i = new ArrayList();
                    a(optJSONArray);
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray(k.FEATURES_KEY);
                    if (optJSONArray2 != null) {
                        this.f113734j = new ArrayList();
                        for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                            JSONObject jSONObject3 = optJSONArray2.getJSONObject(i3);
                            this.f113734j.add(new com.tencent.halley.downloader.e.a(jSONObject3.optLong("offset"), jSONObject3.optInt("length")));
                        }
                    }
                    this.f113735k = new ArrayList();
                    for (a aVar : this.f113733i) {
                        int i16 = aVar.f113737a;
                        if (i16 == 0) {
                            this.f113735k.add(aVar.f113740d);
                            Iterator<String> it = aVar.f113739c.iterator();
                            while (it.hasNext()) {
                                this.f113735k.add(j.a(aVar.f113740d, it.next()));
                            }
                        } else if (i16 == 1) {
                            this.f113735k.add(aVar.f113740d);
                        }
                        if (aVar.f113741e.size() > 0) {
                            this.f113736l.put(Integer.valueOf(aVar.f113737a), aVar.f113741e);
                        }
                    }
                }
            }
            this.f113725a = true;
        } catch (Exception e16) {
            this.f113725a = false;
            e16.printStackTrace();
        }
    }
}
