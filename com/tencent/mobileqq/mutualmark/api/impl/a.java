package com.tencent.mobileqq.mutualmark.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.mutualmark.model.c;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static String f251996b = "MutualMarkResourceHelper";

    /* renamed from: c, reason: collision with root package name */
    public static String f251997c = "rare_resource_0";

    /* renamed from: d, reason: collision with root package name */
    public static String f251998d = "rare_resource_1";

    /* renamed from: e, reason: collision with root package name */
    public static String f251999e = "rare_resource_1_dark";

    /* renamed from: f, reason: collision with root package name */
    public static String f252000f = "LevelUrl";

    /* renamed from: g, reason: collision with root package name */
    public static String f252001g = "LightBgUrl";

    /* renamed from: h, reason: collision with root package name */
    public static String f252002h = "bgImageUrl";

    /* renamed from: i, reason: collision with root package name */
    public static String f252003i = "progressDefaultUrl";

    /* renamed from: j, reason: collision with root package name */
    public static String f252004j = "dressIconUrl";

    /* renamed from: k, reason: collision with root package name */
    public static String f252005k = "bottomButtonDefaultUrl";

    /* renamed from: l, reason: collision with root package name */
    public static String f252006l = "title";

    /* renamed from: m, reason: collision with root package name */
    public static String f252007m = "description";

    /* renamed from: n, reason: collision with root package name */
    public static String f252008n = "tag";

    /* renamed from: o, reason: collision with root package name */
    public static String f252009o = "button";

    /* renamed from: p, reason: collision with root package name */
    public static String f252010p = "textColor";

    /* renamed from: q, reason: collision with root package name */
    public static String f252011q = "backgroundColor";

    /* renamed from: r, reason: collision with root package name */
    public static String f252012r = "lottie_zip";

    /* renamed from: s, reason: collision with root package name */
    public static String f252013s = "lottieUrl";

    /* renamed from: t, reason: collision with root package name */
    public static String f252014t = "lottieMd5";

    /* renamed from: u, reason: collision with root package name */
    public static String f252015u = "tipsTimes";

    /* renamed from: v, reason: collision with root package name */
    public static String f252016v = "beginner_guide";

    /* renamed from: a, reason: collision with root package name */
    private String f252017a = f251997c;

    public static c b() {
        String d16 = com.tencent.relation.common.config.toggle.c.L.d(f252012r, "");
        c cVar = new c();
        if (TextUtils.isEmpty(d16)) {
            return cVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(d16);
            cVar.f252186a = jSONObject.optString(f252013s);
            cVar.f252187b = jSONObject.optString(f252014t);
            return cVar;
        } catch (JSONException e16) {
            QLog.e(f251996b, 1, e16, new Object[0]);
            return null;
        }
    }

    public com.tencent.mobileqq.mutualmark.model.a a() {
        String d16 = com.tencent.relation.common.config.toggle.c.L.d(f252016v, "");
        com.tencent.mobileqq.mutualmark.model.a aVar = new com.tencent.mobileqq.mutualmark.model.a();
        if (TextUtils.isEmpty(d16)) {
            return aVar;
        }
        try {
            aVar.f252172a = new JSONObject(d16).optInt(f252015u);
            return aVar;
        } catch (JSONException e16) {
            QLog.e(f251996b, 1, e16, new Object[0]);
            return null;
        }
    }

    public com.tencent.mobileqq.mutualmark.model.b c(int i3) {
        String str;
        if (i3 == 0) {
            this.f252017a = f251997c;
        } else if (i3 == 1) {
            if (QQTheme.isNowThemeIsNight()) {
                str = f251999e;
            } else {
                str = f251998d;
            }
            this.f252017a = str;
        }
        String d16 = com.tencent.relation.common.config.toggle.c.L.d(this.f252017a, "");
        if (TextUtils.isEmpty(d16)) {
            return null;
        }
        com.tencent.mobileqq.mutualmark.model.b bVar = new com.tencent.mobileqq.mutualmark.model.b();
        try {
            JSONObject jSONObject = new JSONObject(d16);
            bVar.f252173a = jSONObject.optString(f252000f);
            bVar.f252174b = jSONObject.optString(f252001g);
            bVar.f252175c = jSONObject.optString(f252002h);
            bVar.f252176d = jSONObject.optString(f252003i);
            bVar.f252177e = jSONObject.optString(f252004j);
            bVar.f252178f = jSONObject.optString(f252005k);
            JSONObject optJSONObject = jSONObject.optJSONObject(f252006l);
            bVar.f252179g.f252183a = optJSONObject.optString(f252010p);
            bVar.f252179g.f252184b = optJSONObject.optString(f252011q);
            JSONObject optJSONObject2 = jSONObject.optJSONObject(f252007m);
            bVar.f252180h.f252183a = optJSONObject2.optString(f252010p);
            bVar.f252180h.f252184b = optJSONObject2.optString(f252011q);
            JSONObject optJSONObject3 = jSONObject.optJSONObject(f252008n);
            bVar.f252181i.f252183a = optJSONObject3.optString(f252010p);
            bVar.f252181i.f252184b = optJSONObject3.optString(f252011q);
            JSONObject optJSONObject4 = jSONObject.optJSONObject(f252009o);
            bVar.f252182j.f252183a = optJSONObject4.optString(f252010p);
            bVar.f252182j.f252184b = optJSONObject4.optString(f252011q);
            return bVar;
        } catch (JSONException e16) {
            QLog.e(f251996b, 1, e16, new Object[0]);
            return null;
        }
    }
}
