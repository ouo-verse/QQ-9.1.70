package c.t.m.g;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes.dex */
public class d3 {

    /* renamed from: a, reason: collision with root package name */
    public String f29546a;

    /* renamed from: b, reason: collision with root package name */
    public String f29547b;

    /* renamed from: c, reason: collision with root package name */
    public int f29548c;

    public d3(JSONObject jSONObject) {
        this.f29546a = jSONObject.optString("bid", null);
        this.f29547b = jSONObject.optString("floor", "1000");
        this.f29548c = jSONObject.optInt("type", -1);
    }
}
