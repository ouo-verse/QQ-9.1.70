package com.tencent.mobileqq.activity.specialcare;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public List<a> f186574a;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f186575a;

        /* renamed from: b, reason: collision with root package name */
        public String f186576b;

        /* renamed from: c, reason: collision with root package name */
        public int f186577c;

        /* renamed from: d, reason: collision with root package name */
        public String f186578d;

        /* renamed from: e, reason: collision with root package name */
        public String f186579e;

        /* renamed from: f, reason: collision with root package name */
        public String f186580f;

        /* renamed from: g, reason: collision with root package name */
        public int f186581g;

        /* renamed from: h, reason: collision with root package name */
        public String f186582h;

        /* renamed from: i, reason: collision with root package name */
        public String f186583i;

        /* renamed from: j, reason: collision with root package name */
        public int f186584j;

        /* renamed from: k, reason: collision with root package name */
        public int f186585k;

        /* renamed from: l, reason: collision with root package name */
        public String f186586l;

        /* renamed from: m, reason: collision with root package name */
        public String f186587m;

        /* renamed from: n, reason: collision with root package name */
        public String f186588n;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        static a a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return new a();
            }
            a aVar = new a();
            try {
                aVar.f186575a = jSONObject.getInt("id");
                aVar.f186576b = jSONObject.getString("name");
                aVar.f186577c = jSONObject.getInt("type");
                aVar.f186578d = jSONObject.optString("soundVersion", "0");
                aVar.f186579e = jSONObject.getString("soundUrl");
                aVar.f186580f = jSONObject.getString("whiteList");
                aVar.f186581g = jSONObject.getInt(ViewStickEventHelper.IS_SHOW);
                aVar.f186585k = jSONObject.getInt("classify");
                aVar.f186586l = jSONObject.getString("classifyName");
                aVar.f186582h = jSONObject.getString("backgroundUrl");
                aVar.f186583i = String.valueOf(jSONObject.getInt(AppConstants.VIPKey.KEY_FOR_VIP_TYPE));
                aVar.f186584j = jSONObject.getInt("useNum");
                aVar.f186587m = jSONObject.getString("trialstartday");
                aVar.f186588n = jSONObject.getString("trialendday");
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            return aVar;
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f186574a = new ArrayList();
        }
    }

    public static g a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new g();
        }
        g gVar = new g();
        try {
            JSONArray jSONArray = new JSONArray(jSONObject.getString("items"));
            if (jSONArray.length() >= 0) {
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    gVar.f186574a.add(a.a(jSONArray.getJSONObject(i3)));
                }
            }
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
        } catch (JSONException e17) {
            e17.printStackTrace();
        } catch (Exception e18) {
            e18.printStackTrace();
        }
        return gVar;
    }
}
