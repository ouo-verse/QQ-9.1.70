package kz4;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.vivo.push.PushClientConstants;
import com.xiaomi.push.an;
import com.xiaomi.push.hz;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public int f413529a;

    /* renamed from: b, reason: collision with root package name */
    public String f413530b;

    /* renamed from: c, reason: collision with root package name */
    public int f413531c;

    /* renamed from: d, reason: collision with root package name */
    private String f413532d = an.a();

    /* renamed from: e, reason: collision with root package name */
    private String f413533e = hz.d();

    /* renamed from: f, reason: collision with root package name */
    private String f413534f;

    /* renamed from: g, reason: collision with root package name */
    private String f413535g;

    public void a(String str) {
        this.f413534f = str;
    }

    public void b(String str) {
        this.f413535g = str;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("production", this.f413529a);
            jSONObject.put(AdMetricTag.Report.TYPE, this.f413531c);
            jSONObject.put("clientInterfaceId", this.f413530b);
            jSONObject.put("os", this.f413532d);
            jSONObject.put("miuiVersion", this.f413533e);
            jSONObject.put(PushClientConstants.TAG_PKG_NAME, this.f413534f);
            jSONObject.put("sdkVersion", this.f413535g);
            return jSONObject;
        } catch (JSONException e16) {
            jz4.c.q(e16);
            return null;
        }
    }

    public String d() {
        JSONObject c16 = c();
        if (c16 == null) {
            return "";
        }
        return c16.toString();
    }
}
