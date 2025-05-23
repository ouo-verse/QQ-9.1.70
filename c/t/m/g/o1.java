package c.t.m.g;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.open.business.base.MobileInfoUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes.dex */
public class o1 {

    /* renamed from: q, reason: collision with root package name */
    public static int f29896q = 1;

    /* renamed from: a, reason: collision with root package name */
    public int f29897a;

    /* renamed from: b, reason: collision with root package name */
    public String f29898b;

    /* renamed from: c, reason: collision with root package name */
    public String f29899c;

    /* renamed from: d, reason: collision with root package name */
    public String f29900d;

    /* renamed from: e, reason: collision with root package name */
    public String f29901e;

    /* renamed from: f, reason: collision with root package name */
    public String f29902f;

    /* renamed from: g, reason: collision with root package name */
    public String f29903g;

    /* renamed from: h, reason: collision with root package name */
    public String f29904h;

    /* renamed from: i, reason: collision with root package name */
    public String f29905i;

    /* renamed from: j, reason: collision with root package name */
    public long f29906j;

    /* renamed from: k, reason: collision with root package name */
    public String f29907k;

    /* renamed from: o, reason: collision with root package name */
    public Pair<String, String> f29911o;

    /* renamed from: l, reason: collision with root package name */
    public int f29908l = -2;

    /* renamed from: m, reason: collision with root package name */
    public String f29909m = "6.1.15";

    /* renamed from: n, reason: collision with root package name */
    public String f29910n = "231103";

    /* renamed from: p, reason: collision with root package name */
    public ArrayList<w1> f29912p = new ArrayList<>();

    public o1(n1 n1Var) {
    }

    public void a(boolean z16) {
    }

    public void b(boolean z16) {
    }

    public void c(boolean z16) {
    }

    public void d(int i3) {
    }

    public String e() {
        return "0123456789ABCDEF";
    }

    public String f() {
        return TextUtils.isEmpty(this.f29898b) ? "0123456789ABCDEF" : this.f29898b;
    }

    public void g(String str) {
        this.f29899c = str;
    }

    public String h() {
        return w3.a(this.f29903g);
    }

    public String i() {
        return w3.a(this.f29900d);
    }

    public String j() {
        if (!TextUtils.isEmpty(this.f29901e) && !this.f29901e.contains("0000")) {
            return this.f29901e;
        }
        return "0123456789ABCDEF";
    }

    public Pair<String, String> k() {
        if (this.f29911o == null) {
            this.f29911o = new Pair<>((String) k1.a("LocationSDK", "location_device_id_type", ""), (String) k1.a("LocationSDK", "location_device_id", ""));
        }
        return this.f29911o;
    }

    public int l() {
        return this.f29897a;
    }

    public String m() {
        return w3.a(this.f29902f);
    }

    public String n() {
        if (TextUtils.isEmpty(this.f29899c)) {
            return "0123456789ABCDEF";
        }
        return this.f29899c;
    }

    public int o() {
        return this.f29908l;
    }

    public String p() {
        String str = this.f29909m;
        if (str == null) {
            return "None";
        }
        return str;
    }

    @Nullable
    public String q() {
        return this.f29904h;
    }

    public long r() {
        return this.f29906j;
    }

    public void a(w1 w1Var) {
        this.f29912p.add(w1Var);
    }

    public void b(int i3) {
        this.f29897a = i3;
    }

    public void c(String str) {
        this.f29903g = str;
    }

    public void d(String str) {
        this.f29900d = str;
    }

    public void e(String str) {
        this.f29901e = str;
    }

    public String g() {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("imei", f());
            hashMap.put(MobileInfoUtil.IMSI, n());
            hashMap.put("idfa", k().second);
            hashMap.put(AppConstants.Key.PHONENUM, i());
            hashMap.put("qq", m());
            hashMap.put("mac", j().toLowerCase(Locale.ENGLISH));
            hashMap.put("lid", l1.i());
        } catch (Exception unused) {
        }
        return new JSONObject(hashMap).toString();
    }

    public void h(String str) {
        this.f29904h = str;
    }

    public void a(int i3) {
        f29896q = i3;
        ArrayList<w1> arrayList = this.f29912p;
        if (arrayList != null) {
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                arrayList.get(i16).a(i3);
            }
        }
    }

    public void b(String str) {
        this.f29898b = str;
    }

    public String c() {
        return this.f29905i;
    }

    public String d() {
        String str = this.f29910n;
        return str == null ? "None" : str;
    }

    public void f(String str) {
        this.f29902f = str;
    }

    public static int b() {
        return f29896q;
    }

    public void c(int i3) {
        this.f29908l = i3;
    }

    public void a(String str) {
        this.f29905i = str;
    }

    public void a(long j3) {
        this.f29906j = Math.max(q.b().d("min_wifi_scan_interval"), j3);
    }

    public void a(Pair<String, String> pair) {
        k1.b("LocationSDK", "location_device_id_type", pair.first);
        k1.b("LocationSDK", "location_device_id", pair.second);
        this.f29911o = pair;
    }

    public String a() {
        if (this.f29907k == null) {
            StringBuilder sb5 = new StringBuilder(100);
            sb5.append(f());
            sb5.append("_");
            sb5.append(n());
            sb5.append("_");
            sb5.append(j());
            sb5.append("_QQGeoLocation");
            this.f29907k = u3.a(sb5.toString());
        }
        return this.f29907k;
    }
}
