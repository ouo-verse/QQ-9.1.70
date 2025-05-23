package c.t.m.g;

import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes.dex */
public class g3 {

    /* renamed from: m, reason: collision with root package name */
    public static final g3 f29696m = new g3();

    /* renamed from: a, reason: collision with root package name */
    public String f29697a;

    /* renamed from: b, reason: collision with root package name */
    public String f29698b;

    /* renamed from: c, reason: collision with root package name */
    public String f29699c;

    /* renamed from: d, reason: collision with root package name */
    public String f29700d;

    /* renamed from: e, reason: collision with root package name */
    public String f29701e;

    /* renamed from: f, reason: collision with root package name */
    public String f29702f;

    /* renamed from: g, reason: collision with root package name */
    public String f29703g;

    /* renamed from: h, reason: collision with root package name */
    public String f29704h;

    /* renamed from: i, reason: collision with root package name */
    public String f29705i;

    /* renamed from: j, reason: collision with root package name */
    public String f29706j;

    /* renamed from: k, reason: collision with root package name */
    public String f29707k;

    /* renamed from: l, reason: collision with root package name */
    public final Bundle f29708l;

    public g3() {
        this.f29708l = new Bundle();
    }

    public static g3 a(g3 g3Var) {
        if (g3Var == null) {
            return null;
        }
        return new g3(g3Var);
    }

    public String toString() {
        return "SubnationData{name=" + this.f29698b + ",address=" + this.f29707k + ",code=" + this.f29699c + ",nation=" + this.f29697a + ",province=" + this.f29700d + ",city=" + this.f29701e + ",district=" + this.f29702f + ",town=" + this.f29703g + ",village=" + this.f29704h + ",street=" + this.f29705i + ",street_no=" + this.f29706j + ",bundle" + this.f29708l + ",}";
    }

    public g3(g3 g3Var) {
        Bundle bundle = new Bundle();
        this.f29708l = bundle;
        if (g3Var.f29708l.size() > 0) {
            bundle.putAll(g3Var.f29708l);
            return;
        }
        this.f29697a = g3Var.f29697a;
        this.f29698b = g3Var.f29698b;
        this.f29699c = g3Var.f29699c;
        this.f29700d = g3Var.f29700d;
        this.f29701e = g3Var.f29701e;
        this.f29702f = g3Var.f29702f;
        this.f29703g = g3Var.f29703g;
        this.f29704h = g3Var.f29704h;
        this.f29705i = g3Var.f29705i;
        this.f29706j = g3Var.f29706j;
        this.f29707k = g3Var.f29707k;
    }

    public g3(JSONObject jSONObject) throws JSONException {
        Bundle bundle = new Bundle();
        this.f29708l = bundle;
        try {
            if (jSONObject.has("admin_level_1")) {
                String string = jSONObject.getString("nation");
                String string2 = jSONObject.getString("admin_level_1");
                String string3 = jSONObject.getString("admin_level_2");
                String string4 = jSONObject.getString("admin_level_3");
                String string5 = jSONObject.getString("locality");
                String string6 = jSONObject.getString("sublocality");
                String string7 = jSONObject.getString("route");
                bundle.putString("nation", string);
                bundle.putString("admin_level_1", string2);
                bundle.putString("admin_level_2", string3);
                bundle.putString("admin_level_3", string4);
                bundle.putString("locality", string5);
                bundle.putString("sublocality", string6);
                bundle.putString("route", string7);
                return;
            }
            this.f29698b = jSONObject.getString("name");
            this.f29699c = jSONObject.getString("code");
            this.f29697a = jSONObject.getString("nation");
            this.f29700d = jSONObject.getString("province");
            this.f29701e = jSONObject.getString("city");
            this.f29702f = jSONObject.getString("district");
            this.f29703g = jSONObject.getString("town");
            this.f29704h = jSONObject.getString("village");
            this.f29705i = jSONObject.getString("street");
            this.f29706j = jSONObject.getString("street_no");
            String optString = jSONObject.optString("mergedname");
            String optString2 = jSONObject.optString("mergedaddr");
            if (!TextUtils.isEmpty(optString)) {
                this.f29698b = optString;
            }
            if (TextUtils.isEmpty(optString2)) {
                return;
            }
            this.f29707k = optString2;
        } catch (JSONException e16) {
            o3.a("TencentJson", "json error", e16);
            throw e16;
        }
    }
}
