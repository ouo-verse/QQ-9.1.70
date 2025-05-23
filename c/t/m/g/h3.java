package c.t.m.g;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentPoi;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes.dex */
public class h3 implements TencentLocation, Parcelable {
    public static final Parcelable.Creator<TencentLocation> CREATOR = new a();

    /* renamed from: p, reason: collision with root package name */
    public static final h3 f29737p = new h3(-1);

    /* renamed from: a, reason: collision with root package name */
    public e3 f29738a;

    /* renamed from: b, reason: collision with root package name */
    public d3 f29739b;

    /* renamed from: c, reason: collision with root package name */
    public int f29740c;

    /* renamed from: d, reason: collision with root package name */
    public int f29741d;

    /* renamed from: e, reason: collision with root package name */
    public String f29742e;

    /* renamed from: f, reason: collision with root package name */
    public String f29743f;

    /* renamed from: g, reason: collision with root package name */
    public b3 f29744g;

    /* renamed from: h, reason: collision with root package name */
    public final Bundle f29745h;

    /* renamed from: i, reason: collision with root package name */
    public String f29746i;

    /* renamed from: j, reason: collision with root package name */
    public String f29747j;

    /* renamed from: k, reason: collision with root package name */
    public Location f29748k;

    /* renamed from: l, reason: collision with root package name */
    public final long f29749l;

    /* renamed from: m, reason: collision with root package name */
    public long f29750m;

    /* renamed from: n, reason: collision with root package name */
    public int f29751n;

    /* renamed from: o, reason: collision with root package name */
    public int f29752o;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<TencentLocation> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TencentLocation[] newArray(int i3) {
            return new TencentLocation[i3];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TencentLocation createFromParcel(Parcel parcel) {
            h3 h3Var = new h3(parcel.readInt(), (a) null);
            e3 e3Var = new e3();
            b3 b3Var = new b3();
            g3 g3Var = new g3();
            b3Var.f29514c = g3Var;
            h3Var.f29746i = parcel.readString();
            e3Var.f29594a = parcel.readDouble();
            e3Var.f29595b = parcel.readDouble();
            e3Var.f29597d = parcel.readFloat();
            e3Var.f29596c = parcel.readDouble();
            e3Var.f29599f = parcel.readString();
            g3Var.f29697a = parcel.readString();
            g3Var.f29700d = parcel.readString();
            g3Var.f29701e = parcel.readString();
            g3Var.f29702f = parcel.readString();
            g3Var.f29705i = parcel.readString();
            g3Var.f29706j = parcel.readString();
            g3Var.f29698b = parcel.readString();
            h3Var.f29738a = e3Var;
            h3Var.f29744g = b3Var;
            h3Var.f29750m = parcel.readLong();
            Bundle readBundle = parcel.readBundle();
            if (readBundle != null) {
                h3Var.f29745h.putAll(readBundle);
            }
            return h3Var;
        }
    }

    public /* synthetic */ h3(int i3, a aVar) {
        this(i3);
    }

    public static void d(h3 h3Var) throws JSONException {
        if (h3Var != f29737p) {
        } else {
            throw new JSONException("location failed");
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public float getAccuracy() {
        e3 e3Var = this.f29738a;
        if (e3Var != null) {
            return e3Var.f29597d;
        }
        return 0.0f;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getAddress() {
        int i3 = this.f29740c;
        if (i3 == 5) {
            return this.f29745h.getString("addrdesp.name");
        }
        if (i3 == 3) {
            b3 b3Var = this.f29744g;
            if (b3Var == null) {
                return "";
            }
            return b3Var.f29514c.f29707k;
        }
        e3 e3Var = this.f29738a;
        if (e3Var == null) {
            return "";
        }
        return e3Var.f29599f;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public double getAltitude() {
        e3 e3Var = this.f29738a;
        if (e3Var != null) {
            return e3Var.f29596c;
        }
        return 0.0d;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public Integer getAreaStat() {
        b3 b3Var = this.f29744g;
        if (b3Var != null) {
            return Integer.valueOf(b3Var.f29512a);
        }
        return null;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public float getBearing() {
        Location location = this.f29748k;
        if (location == null) {
            return 0.0f;
        }
        return location.getBearing();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getCity() {
        b3 b3Var = this.f29744g;
        if (b3Var != null) {
            return b3Var.f29514c.f29701e;
        }
        return "";
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getCityCode() {
        b3 b3Var = this.f29744g;
        if (b3Var != null) {
            return b3Var.f29514c.f29699c;
        }
        return "";
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public int getCoordinateType() {
        return this.f29751n;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public double getDirection() {
        Bundle bundle = this.f29745h;
        if (bundle != null) {
            return bundle.getDouble("direction");
        }
        return Double.NaN;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getDistrict() {
        b3 b3Var = this.f29744g;
        if (b3Var != null) {
            return b3Var.f29514c.f29702f;
        }
        return "";
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public long getElapsedRealtime() {
        return this.f29749l;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public Bundle getExtra() {
        return this.f29745h;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public int getFakeReason() {
        return this.f29752o;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getIndoorBuildingFloor() {
        d3 d3Var = this.f29739b;
        if (d3Var != null) {
            return d3Var.f29547b;
        }
        return "1000";
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getIndoorBuildingId() {
        d3 d3Var = this.f29739b;
        if (d3Var != null) {
            return d3Var.f29546a;
        }
        return null;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public int getIndoorLocationType() {
        d3 d3Var = this.f29739b;
        if (d3Var != null) {
            return d3Var.f29548c;
        }
        return -1;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public double getLatitude() {
        e3 e3Var = this.f29738a;
        if (e3Var != null) {
            return e3Var.f29594a;
        }
        return 0.0d;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public double getLongitude() {
        e3 e3Var = this.f29738a;
        if (e3Var != null) {
            return e3Var.f29595b;
        }
        return 0.0d;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getMotion() {
        Bundle bundle = this.f29745h;
        if (bundle != null) {
            return bundle.getString("motion");
        }
        return "unknown";
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getName() {
        int i3 = this.f29740c;
        if (i3 == 5) {
            return this.f29745h.getString("addrdesp.name");
        }
        if (i3 == 3) {
            b3 b3Var = this.f29744g;
            if (b3Var == null) {
                return "";
            }
            return b3Var.f29514c.f29698b;
        }
        e3 e3Var = this.f29738a;
        if (e3Var == null) {
            return "";
        }
        return e3Var.f29598e;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getNation() {
        b3 b3Var = this.f29744g;
        if (b3Var != null) {
            return b3Var.f29514c.f29697a;
        }
        return "";
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public List<TencentPoi> getPoiList() {
        if (this.f29744g != null) {
            return new ArrayList(this.f29744g.f29513b);
        }
        return Collections.emptyList();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getProvider() {
        return this.f29746i;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getProvince() {
        b3 b3Var = this.f29744g;
        if (b3Var != null) {
            return b3Var.f29514c.f29700d;
        }
        return "";
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getRawData() {
        Bundle bundle = this.f29745h;
        if (bundle != null) {
            return bundle.getString("wifi_data");
        }
        return null;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public int getRssi() {
        Bundle extras;
        Location location = this.f29748k;
        if (location == null || (extras = location.getExtras()) == null) {
            return 0;
        }
        return extras.getInt("rssi", 0);
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getSourceProvider() {
        return this.f29747j;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public float getSpeed() {
        Location location = this.f29748k;
        if (location == null) {
            return 0.0f;
        }
        return location.getSpeed();
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getStreet() {
        b3 b3Var = this.f29744g;
        if (b3Var != null) {
            return b3Var.f29514c.f29705i;
        }
        return "";
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getStreetNo() {
        b3 b3Var = this.f29744g;
        if (b3Var != null) {
            return b3Var.f29514c.f29706j;
        }
        return "";
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public long getTime() {
        return this.f29750m;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getTown() {
        b3 b3Var = this.f29744g;
        if (b3Var != null) {
            return b3Var.f29514c.f29703g;
        }
        return "";
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getVerifyKey() {
        return this.f29742e;
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public String getVillage() {
        b3 b3Var = this.f29744g;
        if (b3Var != null) {
            return b3Var.f29514c.f29704h;
        }
        return "";
    }

    @Override // com.tencent.map.geolocation.TencentLocation
    public int isMockGps() {
        return this.f29741d;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder("TxLocation{");
        sb5.append("level=");
        sb5.append(this.f29740c);
        sb5.append(",");
        sb5.append("name=");
        sb5.append(getName());
        sb5.append(",");
        sb5.append("address=");
        sb5.append(getAddress());
        sb5.append(",");
        sb5.append("provider=");
        sb5.append(getProvider());
        sb5.append(",");
        sb5.append("latitude=");
        sb5.append(getLatitude());
        sb5.append(",");
        sb5.append("longitude=");
        sb5.append(getLongitude());
        sb5.append(",");
        sb5.append("altitude=");
        sb5.append(getAltitude());
        sb5.append(",");
        sb5.append("accuracy=");
        sb5.append(getAccuracy());
        sb5.append(",");
        sb5.append("cityCode=");
        sb5.append(getCityCode());
        sb5.append(",");
        sb5.append("areaStat=");
        sb5.append(getAreaStat());
        sb5.append(",");
        sb5.append("nation=");
        sb5.append(getNation());
        sb5.append(",");
        sb5.append("province=");
        sb5.append(getProvince());
        sb5.append(",");
        sb5.append("city=");
        sb5.append(getCity());
        sb5.append(",");
        sb5.append("district=");
        sb5.append(getDistrict());
        sb5.append(",");
        sb5.append("street=");
        sb5.append(getStreet());
        sb5.append(",");
        sb5.append("streetNo=");
        sb5.append(getStreetNo());
        sb5.append(",");
        sb5.append("town=");
        sb5.append(getTown());
        sb5.append(",");
        sb5.append("village=");
        sb5.append(getVillage());
        sb5.append(",");
        sb5.append("bearing=");
        sb5.append(getBearing());
        sb5.append(",");
        sb5.append("time=");
        sb5.append(getTime());
        sb5.append(",");
        sb5.append("poilist=[");
        Iterator<TencentPoi> it = getPoiList().iterator();
        while (it.hasNext()) {
            sb5.append(it.next());
            sb5.append(",");
        }
        sb5.append("]");
        sb5.append("}");
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f29740c);
        parcel.writeString(getProvider());
        parcel.writeDouble(getLatitude());
        parcel.writeDouble(getLongitude());
        parcel.writeDouble(getAccuracy());
        parcel.writeDouble(getAltitude());
        parcel.writeString(getAddress());
        parcel.writeString(getNation());
        parcel.writeString(getProvince());
        parcel.writeString(getCity());
        parcel.writeString(getDistrict());
        parcel.writeString(getStreet());
        parcel.writeString(getStreetNo());
        parcel.writeString(b());
        parcel.writeString(getName());
        parcel.writeLong(this.f29750m);
        parcel.writeBundle(this.f29745h);
    }

    public /* synthetic */ h3(String str, a aVar) throws JSONException {
        this(str);
    }

    public static h3 c(h3 h3Var) {
        h3 h3Var2 = new h3(-1);
        if (h3Var == null) {
            h3Var2.f29738a = new e3();
        } else {
            h3Var2.f29738a = e3.a(h3Var.f29738a);
            h3Var2.f29740c = h3Var.f29740c;
            h3Var2.f29743f = h3Var.f29743f;
            h3Var2.f29744g = b3.a(h3Var.f29744g);
            if (h3Var.f29745h.size() > 0) {
                h3Var2.f29745h.putAll(h3Var.f29745h);
            }
        }
        return h3Var2;
    }

    public h3(int i3) {
        this.f29745h = new Bundle();
        this.f29746i = "network";
        this.f29747j = "network";
        this.f29740c = i3;
        this.f29749l = SystemClock.elapsedRealtime();
        this.f29750m = System.currentTimeMillis();
    }

    public void b(Location location) {
        if (location == null || this.f29738a == null) {
            return;
        }
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        e3 e3Var = this.f29738a;
        e3Var.f29594a = Math.round(latitude * 1000000.0d) / 1000000.0d;
        e3Var.f29595b = Math.round(longitude * 1000000.0d) / 1000000.0d;
        e3Var.f29596c = location.getAltitude();
        this.f29738a.f29597d = LocationMonitor.getAccuracy(location);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f29753a;

        /* renamed from: b, reason: collision with root package name */
        public h3 f29754b;

        /* renamed from: c, reason: collision with root package name */
        public int f29755c;

        /* renamed from: d, reason: collision with root package name */
        public String f29756d = "network";

        /* renamed from: e, reason: collision with root package name */
        public String f29757e = "network";

        /* renamed from: f, reason: collision with root package name */
        public Location f29758f;

        public h3 a() {
            h3 h3Var;
            if (this.f29753a == null) {
                h3Var = h3.c(this.f29754b);
            } else {
                try {
                    h3Var = new h3(this.f29753a, (a) null);
                } catch (JSONException e16) {
                    o3.a("TxLocation", "build: ", e16);
                    return h3.f29737p;
                }
            }
            h3Var.b(this.f29755c).a(this.f29756d).b(this.f29757e).a(this.f29758f);
            TencentExtraKeys.setRawGps(h3Var, this.f29758f);
            return h3Var;
        }

        public b b(String str) {
            this.f29756d = str;
            return this;
        }

        public b c(String str) {
            this.f29757e = str;
            return this;
        }

        public b a(String str) {
            this.f29753a = str;
            return this;
        }

        public b a(h3 h3Var) {
            this.f29754b = h3Var;
            return this;
        }

        public b a(int i3) {
            this.f29755c = i3;
            return this;
        }

        public b a(Location location) {
            this.f29758f = new Location(location);
            return this;
        }
    }

    public h3 a(long j3) {
        this.f29750m = j3;
        return this;
    }

    public void a(double d16, double d17) {
        this.f29738a.f29594a = Math.round(d16 * 1000000.0d) / 1000000.0d;
        this.f29738a.f29595b = Math.round(d17 * 1000000.0d) / 1000000.0d;
    }

    public h3(String str) throws JSONException {
        g3 g3Var;
        this.f29745h = new Bundle();
        this.f29746i = "network";
        this.f29747j = "network";
        this.f29749l = SystemClock.elapsedRealtime();
        this.f29750m = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject(str);
        try {
            this.f29738a = new e3(jSONObject.getJSONObject("location"));
            try {
                this.f29739b = new d3(jSONObject.getJSONObject("indoorinfo"));
            } catch (Throwable th5) {
                o3.a("TxLocation", th5.toString());
            }
            this.f29743f = jSONObject.optString("bearing");
            this.f29741d = jSONObject.optInt("fackgps", 0);
            String optString = jSONObject.optString("verifykey", "0");
            this.f29742e = optString;
            if (optString != null && !optString.equals("0")) {
                this.f29750m = jSONObject.optLong("timestamp");
                o3.a("TxLocation", "server time:" + this.f29750m);
            }
            if (this.f29741d >= 1) {
                this.f29747j = "fake";
                this.f29752o++;
            }
            try {
                String optString2 = jSONObject.optString("icontrol");
                if (!TextUtils.isEmpty(optString2)) {
                    this.f29745h.putInt("icontrol", Integer.valueOf(optString2.split(",")[0]).intValue());
                    o3.a("TxLocation", "TxLocation control:" + optString2);
                }
            } catch (Exception unused) {
                o3.a("TxLocation", "parse icontrol failed");
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("details");
            if (optJSONObject != null) {
                try {
                    this.f29744g = new b3(optJSONObject);
                } catch (JSONException e16) {
                    o3.a("TxLocation", "details object not found", e16);
                    throw e16;
                }
            } else {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("addrdesp");
                if (optJSONObject2 != null && optJSONObject2.has("detail")) {
                    this.f29744g = new b3(optJSONObject2.optJSONObject("detail"));
                }
            }
            b3 b3Var = this.f29744g;
            if (b3Var == null || (g3Var = b3Var.f29514c) == null) {
                return;
            }
            this.f29745h.putAll(g3Var.f29708l);
        } catch (JSONException e17) {
            throw e17;
        }
    }

    public final h3 a(String str) {
        this.f29746i = str;
        return this;
    }

    public h3 a(int i3) {
        this.f29752o += i3;
        return this;
    }

    public final h3 b(String str) {
        this.f29747j = str;
        return this;
    }

    public final h3 a(Location location) {
        this.f29748k = location;
        return this;
    }

    public final h3 b(int i3) {
        this.f29740c = i3;
        return this;
    }

    public static h3 a(h3 h3Var, t2 t2Var, boolean z16, boolean z17) {
        String str;
        if (h3Var != null && t2Var != null && (str = h3Var.f29743f) != null) {
            int i3 = t2Var.f30006e;
            int parseInt = (str == null || str.split(",").length <= 1) ? 0 : Integer.parseInt(str.split(",")[1]);
            e3 e3Var = h3Var.f29738a;
            if (e3Var != null) {
                try {
                    e3Var.f29597d = (float) com.tencent.tencentmap.lbssdk.service.e.r(e3Var.f29597d, parseInt, i3);
                } catch (UnsatisfiedLinkError unused) {
                }
                if (z16) {
                    h3Var.f29747j = "fake";
                }
                if (!h3Var.f29747j.equals("fake")) {
                    if (e3Var.f29597d <= 150.0d) {
                        h3Var.f29747j = "wifi";
                    } else {
                        h3Var.f29747j = "cell";
                    }
                }
            }
        } else if (h3Var != null) {
            if (z16) {
                h3Var.f29747j = "fake";
            }
            if (!h3Var.f29747j.equals("fake")) {
                if (z17) {
                    h3Var.f29747j = TencentLocation.COARSE_PROVIDER;
                    e3 e3Var2 = h3Var.f29738a;
                    if (e3Var2 != null) {
                        e3Var2.f29597d = 5000.0f;
                    }
                } else if (h3Var.getAccuracy() <= 150.0d) {
                    h3Var.f29747j = "wifi";
                } else {
                    h3Var.f29747j = "cell";
                }
            }
        }
        return h3Var;
    }

    public String b() {
        b3 b3Var = this.f29744g;
        return b3Var != null ? b3Var.f29514c.f29699c : "";
    }

    public static h3 b(h3 h3Var, int i3) {
        h3Var.f29751n = i3;
        return h3Var;
    }

    public void a() {
        this.f29742e = null;
    }
}
