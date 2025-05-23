package com.tencent.luggage.wxa.i2;

import com.tencent.luggage.wxa.fd.q;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.k5.i;
import com.tencent.luggage.wxa.n5.b;
import com.tencent.luggage.wxa.tn.w;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 192;
    public static final String NAME = "openSetting";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends b.f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f129194a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f129195b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f129196c;

        public a(WeakReference weakReference, int i3, boolean z16) {
            this.f129194a = weakReference;
            this.f129195b = i3;
            this.f129196c = z16;
        }

        @Override // com.tencent.luggage.wxa.n5.b.f
        public void a(int i3, String str, String str2, int i16, boolean z16) {
            JSONArray jSONArray;
            JSONObject jSONObject;
            w.g("Luggage.JsApiOpenSetting", "settingInfo %s", str);
            l lVar = (l) this.f129194a.get();
            if (lVar == null) {
                return;
            }
            com.tencent.luggage.wxa.s2.a.a(lVar.getRuntime(), i16);
            if (str == null) {
                w.b("Luggage.JsApiOpenSetting", "settingInfo is null, err");
                lVar.a(this.f129195b, e.this.makeReturnJson("fail:authSetting is null, return"));
                return;
            }
            try {
                jSONArray = new JSONArray(str);
            } catch (JSONException unused) {
                jSONArray = new JSONArray();
            }
            if (this.f129196c) {
                try {
                    jSONObject = new JSONObject(str2);
                } catch (JSONException unused2) {
                    jSONObject = new JSONObject();
                }
            } else {
                jSONObject = null;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("errMsg", e.this.getName() + ":ok");
                jSONObject2.put("authSetting", jSONArray);
                if (this.f129196c) {
                    jSONObject2.put("subscriptionsSetting", jSONObject);
                }
            } catch (JSONException e16) {
                w.b("Luggage.JsApiOpenSetting", "set json error!");
                w.a("Luggage.JsApiOpenSetting", e16, "", new Object[0]);
            }
            lVar.a(this.f129195b, jSONObject2.toString());
        }
    }

    public int[] a(l lVar) {
        return null;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(l lVar, JSONObject jSONObject, int i3) {
        q j06 = lVar.getRuntime().j0();
        if (j06 == null) {
            w.b("Luggage.JsApiOpenSetting", "config is null!");
            lVar.a(i3, makeReturnJson("fail:config is null"));
            return;
        }
        boolean optBoolean = jSONObject.optBoolean("withSubscriptions", false);
        String appId = lVar.getAppId();
        String str = j06.f125955a;
        String str2 = ((com.tencent.luggage.wxa.j4.d) lVar.getRuntime().S()).G;
        WeakReference weakReference = new WeakReference(lVar);
        i.a(lVar.J(), appId, str2, str, com.tencent.luggage.wxa.n5.b.INSTANCE.a(lVar.D()), a(lVar), new a(weakReference, i3, optBoolean));
    }
}
