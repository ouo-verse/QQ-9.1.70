package c.t.m.g;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes.dex */
public class e3 {

    /* renamed from: a, reason: collision with root package name */
    public double f29594a;

    /* renamed from: b, reason: collision with root package name */
    public double f29595b;

    /* renamed from: c, reason: collision with root package name */
    public double f29596c;

    /* renamed from: d, reason: collision with root package name */
    public float f29597d;

    /* renamed from: e, reason: collision with root package name */
    public String f29598e;

    /* renamed from: f, reason: collision with root package name */
    public String f29599f;

    public e3() {
    }

    public static e3 a(e3 e3Var) {
        e3 e3Var2 = new e3();
        if (e3Var != null) {
            e3Var2.f29594a = e3Var.f29594a;
            e3Var2.f29595b = e3Var.f29595b;
            e3Var2.f29596c = e3Var.f29596c;
            e3Var2.f29597d = e3Var.f29597d;
            e3Var2.f29598e = e3Var.f29598e;
            e3Var2.f29599f = e3Var.f29599f;
        }
        return e3Var2;
    }

    public e3(JSONObject jSONObject) throws JSONException {
        try {
            this.f29594a = jSONObject.getDouble("latitude");
            this.f29595b = jSONObject.getDouble("longitude");
            this.f29596c = jSONObject.getDouble("altitude");
            this.f29597d = (float) jSONObject.getDouble("accuracy");
            this.f29598e = jSONObject.optString("name");
            this.f29599f = jSONObject.optString("addr");
        } catch (JSONException e16) {
            o3.a("TencentJson", "json error", e16);
            throw e16;
        }
    }
}
