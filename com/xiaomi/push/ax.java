package com.xiaomi.push;

import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.mobileqq.app.identity.jwt.JsonWebSignature;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ax {

    /* renamed from: a, reason: collision with root package name */
    public String f388218a;

    /* renamed from: b, reason: collision with root package name */
    private long f388219b;

    /* renamed from: d, reason: collision with root package name */
    public String f388221d;

    /* renamed from: e, reason: collision with root package name */
    public String f388222e;

    /* renamed from: f, reason: collision with root package name */
    public String f388223f;

    /* renamed from: g, reason: collision with root package name */
    public String f388224g;

    /* renamed from: h, reason: collision with root package name */
    public String f388225h;

    /* renamed from: i, reason: collision with root package name */
    public String f388226i;

    /* renamed from: j, reason: collision with root package name */
    protected String f388227j;

    /* renamed from: k, reason: collision with root package name */
    private String f388228k;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<be> f388220c = new ArrayList<>();

    /* renamed from: l, reason: collision with root package name */
    private double f388229l = 0.1d;

    /* renamed from: m, reason: collision with root package name */
    private String f388230m = "s.mi1.cc";

    /* renamed from: n, reason: collision with root package name */
    private long f388231n = 86400000;

    public ax(String str) {
        this.f388218a = "";
        if (!TextUtils.isEmpty(str)) {
            this.f388219b = System.currentTimeMillis();
            this.f388220c.add(new be(str, -1));
            this.f388218a = bb.d();
            this.f388221d = str;
            return;
        }
        throw new IllegalArgumentException("the host is empty");
    }

    private synchronized void v(String str) {
        Iterator<be> it = this.f388220c.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().f388258e, str)) {
                it.remove();
            }
        }
    }

    public synchronized ax a(JSONObject jSONObject) {
        this.f388218a = jSONObject.optString("net");
        this.f388231n = jSONObject.getLong(RemoteMessageConst.TTL);
        this.f388229l = jSONObject.getDouble("pct");
        this.f388219b = jSONObject.getLong("ts");
        this.f388223f = jSONObject.optString("city");
        this.f388222e = jSONObject.optString("prv");
        this.f388226i = jSONObject.optString(JsonWebSignature.CONTENT_TYPE);
        this.f388224g = jSONObject.optString("isp");
        this.f388225h = jSONObject.optString("ip");
        this.f388221d = jSONObject.optString("host");
        this.f388227j = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            i(new be().d(jSONArray.getJSONObject(i3)));
        }
        return this;
    }

    public synchronized String b() {
        if (!TextUtils.isEmpty(this.f388228k)) {
            return this.f388228k;
        }
        if (TextUtils.isEmpty(this.f388224g)) {
            return "hardcode_isp";
        }
        String g16 = ag.g(new String[]{this.f388224g, this.f388222e, this.f388223f, this.f388226i, this.f388225h}, "_");
        this.f388228k = g16;
        return g16;
    }

    public synchronized ArrayList<String> c() {
        return e(false);
    }

    public ArrayList<String> d(String str) {
        if (!TextUtils.isEmpty(str)) {
            URL url = new URL(str);
            if (TextUtils.equals(url.getHost(), this.f388221d)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<String> it = e(true).iterator();
                while (it.hasNext()) {
                    az b16 = az.b(it.next(), url.getPort());
                    arrayList.add(new URL(url.getProtocol(), b16.c(), b16.a(), url.getFile()).toString());
                }
                return arrayList;
            }
            throw new IllegalArgumentException("the url is not supported by the fallback");
        }
        throw new IllegalArgumentException("the url is empty.");
    }

    public synchronized ArrayList<String> e(boolean z16) {
        ArrayList<String> arrayList;
        int size = this.f388220c.size();
        be[] beVarArr = new be[size];
        this.f388220c.toArray(beVarArr);
        Arrays.sort(beVarArr);
        arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < size; i3++) {
            be beVar = beVarArr[i3];
            if (z16) {
                arrayList.add(beVar.f388258e);
            } else {
                int indexOf = beVar.f388258e.indexOf(":");
                if (indexOf != -1) {
                    arrayList.add(beVar.f388258e.substring(0, indexOf));
                } else {
                    arrayList.add(beVar.f388258e);
                }
            }
        }
        return arrayList;
    }

    public synchronized JSONObject f() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("net", this.f388218a);
        jSONObject.put(RemoteMessageConst.TTL, this.f388231n);
        jSONObject.put("pct", this.f388229l);
        jSONObject.put("ts", this.f388219b);
        jSONObject.put("city", this.f388223f);
        jSONObject.put("prv", this.f388222e);
        jSONObject.put(JsonWebSignature.CONTENT_TYPE, this.f388226i);
        jSONObject.put("isp", this.f388224g);
        jSONObject.put("ip", this.f388225h);
        jSONObject.put("host", this.f388221d);
        jSONObject.put("xf", this.f388227j);
        JSONArray jSONArray = new JSONArray();
        Iterator<be> it = this.f388220c.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(it.next().h());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public void g(double d16) {
        this.f388229l = d16;
    }

    public void h(long j3) {
        if (j3 > 0) {
            this.f388231n = j3;
            return;
        }
        throw new IllegalArgumentException("the duration is invalid " + j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void i(be beVar) {
        v(beVar.f388258e);
        this.f388220c.add(beVar);
    }

    public synchronized void j(String str) {
        i(new be(str));
    }

    public void k(String str, int i3, long j3, long j16, Exception exc) {
        n(str, new aw(i3, j3, j16, exc));
    }

    public void l(String str, long j3, long j16) {
        try {
            s(new URL(str).getHost(), j3, j16);
        } catch (MalformedURLException unused) {
        }
    }

    public void m(String str, long j3, long j16, Exception exc) {
        try {
            t(new URL(str).getHost(), j3, j16, exc);
        } catch (MalformedURLException unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        r1.i(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void n(String str, aw awVar) {
        Iterator<be> it = this.f388220c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            be next = it.next();
            if (TextUtils.equals(str, next.f388258e)) {
                break;
            }
        }
    }

    public synchronized void o(String[] strArr) {
        int i3;
        int size = this.f388220c.size() - 1;
        while (true) {
            i3 = 0;
            if (size < 0) {
                break;
            }
            int length = strArr.length;
            while (true) {
                if (i3 < length) {
                    if (TextUtils.equals(this.f388220c.get(size).f388258e, strArr[i3])) {
                        this.f388220c.remove(size);
                        break;
                    }
                    i3++;
                }
            }
            size--;
        }
        Iterator<be> it = this.f388220c.iterator();
        int i16 = 0;
        while (it.hasNext()) {
            int i17 = it.next().f388260h;
            if (i17 > i16) {
                i16 = i17;
            }
        }
        while (i3 < strArr.length) {
            i(new be(strArr[i3], (strArr.length + i16) - i3));
            i3++;
        }
    }

    public boolean p() {
        return TextUtils.equals(this.f388218a, bb.d());
    }

    public boolean q(ax axVar) {
        return TextUtils.equals(this.f388218a, axVar.f388218a);
    }

    public void r(String str) {
        this.f388230m = str;
    }

    public void s(String str, long j3, long j16) {
        k(str, 0, j3, j16, null);
    }

    public void t(String str, long j3, long j16, Exception exc) {
        k(str, -1, j3, j16, exc);
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f388218a);
        sb5.append("\n");
        sb5.append(b());
        Iterator<be> it = this.f388220c.iterator();
        while (it.hasNext()) {
            be next = it.next();
            sb5.append("\n");
            sb5.append(next.toString());
        }
        sb5.append("\n");
        return sb5.toString();
    }

    public boolean u() {
        if (System.currentTimeMillis() - this.f388219b < this.f388231n) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean w() {
        long j3 = this.f388231n;
        if (864000000 >= j3) {
            j3 = 864000000;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j16 = this.f388219b;
        if (currentTimeMillis - j16 <= j3 && (currentTimeMillis - j16 <= this.f388231n || !this.f388218a.startsWith("WIFI-"))) {
            return false;
        }
        return true;
    }
}
