package c.t.m.g;

import com.tencent.map.geolocation.TencentPoi;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes.dex */
public class f3 implements TencentPoi {

    /* renamed from: a, reason: collision with root package name */
    public String f29637a;

    /* renamed from: b, reason: collision with root package name */
    public String f29638b;

    /* renamed from: c, reason: collision with root package name */
    public String f29639c;

    /* renamed from: d, reason: collision with root package name */
    public double f29640d;

    /* renamed from: e, reason: collision with root package name */
    public String f29641e;

    /* renamed from: f, reason: collision with root package name */
    public double f29642f;

    /* renamed from: g, reason: collision with root package name */
    public double f29643g;

    /* renamed from: h, reason: collision with root package name */
    public String f29644h;

    public f3(TencentPoi tencentPoi) {
        this.f29637a = tencentPoi.getName();
        this.f29638b = tencentPoi.getAddress();
        this.f29639c = tencentPoi.getCatalog();
        this.f29640d = tencentPoi.getDistance();
        this.f29641e = tencentPoi.getUid();
        this.f29642f = tencentPoi.getLatitude();
        this.f29643g = tencentPoi.getLongitude();
        this.f29644h = tencentPoi.getDirection();
    }

    public final void a(JSONObject jSONObject) {
        this.f29644h = jSONObject.optString("direction", "");
        if (Double.isNaN(this.f29642f)) {
            this.f29642f = jSONObject.optDouble("pointy");
        }
        if (Double.isNaN(this.f29643g)) {
            this.f29643g = jSONObject.optDouble("pointx");
        }
    }

    public final void b(JSONObject jSONObject) throws JSONException {
        try {
            this.f29637a = jSONObject.getString("name");
            this.f29638b = jSONObject.getString("addr");
            this.f29639c = jSONObject.getString("catalog");
            this.f29640d = jSONObject.optDouble("dist");
            this.f29641e = jSONObject.getString("uid");
            this.f29642f = jSONObject.optDouble("latitude");
            this.f29643g = jSONObject.optDouble("longitude");
            a(jSONObject);
        } catch (JSONException e16) {
            o3.a("TencentJson", "json error", e16);
            throw e16;
        }
    }

    @Override // com.tencent.map.geolocation.TencentPoi
    public String getAddress() {
        return this.f29638b;
    }

    @Override // com.tencent.map.geolocation.TencentPoi
    public String getCatalog() {
        return this.f29639c;
    }

    @Override // com.tencent.map.geolocation.TencentPoi
    public String getDirection() {
        return this.f29644h;
    }

    @Override // com.tencent.map.geolocation.TencentPoi
    public double getDistance() {
        return this.f29640d;
    }

    @Override // com.tencent.map.geolocation.TencentPoi
    public double getLatitude() {
        return this.f29642f;
    }

    @Override // com.tencent.map.geolocation.TencentPoi
    public double getLongitude() {
        return this.f29643g;
    }

    @Override // com.tencent.map.geolocation.TencentPoi
    public String getName() {
        return this.f29637a;
    }

    @Override // com.tencent.map.geolocation.TencentPoi
    public String getUid() {
        return this.f29641e;
    }

    public String toString() {
        return "PoiData{name=" + this.f29637a + ",addr=" + this.f29638b + ",catalog=" + this.f29639c + ",dist=" + this.f29640d + ",latitude=" + this.f29642f + ",longitude=" + this.f29643g + ",direction=" + this.f29644h + ",}";
    }

    public f3(JSONObject jSONObject) throws JSONException {
        b(jSONObject);
    }
}
