package com.huawei.hms.hatool;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class l0 {

    /* renamed from: a, reason: collision with root package name */
    private String f37165a;

    /* renamed from: b, reason: collision with root package name */
    private String f37166b;

    /* renamed from: c, reason: collision with root package name */
    private String f37167c;

    /* renamed from: d, reason: collision with root package name */
    private List<b1> f37168d;

    /* renamed from: e, reason: collision with root package name */
    private String f37169e;

    public l0(String str, String str2, String str3, List<b1> list, String str4) {
        this.f37165a = str;
        this.f37166b = str2;
        this.f37167c = str3;
        this.f37168d = list;
        this.f37169e = str4;
    }

    private String a(String str, String str2) {
        String str3;
        String f16 = a1.f(str, str2);
        if (TextUtils.isEmpty(f16)) {
            v.a("hmsSdk", "No report address,TAG : %s,TYPE: %s ", str, str2);
            return "";
        }
        if ("oper".equals(str2)) {
            str3 = "{url}/common/hmshioperqrt";
        } else if ("maint".equals(str2)) {
            str3 = "{url}/common/hmshimaintqrt";
        } else {
            if (!"diffprivacy".equals(str2)) {
                return "";
            }
            str3 = "{url}/common/common2";
        }
        return str3.replace("{url}", f16);
    }

    private void b() {
        if (c0.a(q0.i(), "backup_event", 5242880)) {
            v.d("hmsSdk", "backup file reach max limited size, discard new event ");
            return;
        }
        JSONArray c16 = c();
        String a16 = n1.a(this.f37165a, this.f37166b, this.f37169e);
        v.c("hmsSdk", "Update data cached into backup,spKey: " + a16);
        d.b(q0.i(), "backup_event", a16, c16.toString());
    }

    private JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        Iterator<b1> it = this.f37168d.iterator();
        while (it.hasNext()) {
            try {
                jSONArray.mo162put(it.next().d());
            } catch (JSONException unused) {
                v.c("hmsSdk", "handleEvents: json error,Abandon this data");
            }
        }
        return jSONArray;
    }

    private h1 d() {
        return k.a(this.f37168d, this.f37165a, this.f37166b, this.f37169e, this.f37167c);
    }

    public void a() {
        g d1Var;
        b0 c16;
        String str;
        String a16 = a(this.f37165a, this.f37166b);
        if (!TextUtils.isEmpty(a16) || "preins".equals(this.f37166b)) {
            if (!"_hms_config_tag".equals(this.f37165a) && !"_openness_config_tag".equals(this.f37165a)) {
                b();
            }
            h1 d16 = d();
            if (d16 != null) {
                byte[] a17 = a(d16);
                if (a17.length == 0) {
                    str = "request body is empty";
                } else {
                    d1Var = new f(a17, a16, this.f37165a, this.f37166b, this.f37169e, this.f37168d);
                    c16 = b0.b();
                }
            } else {
                d1Var = new d1(this.f37168d, this.f37165a, this.f37169e, this.f37166b);
                c16 = b0.c();
            }
            c16.a(d1Var);
            return;
        }
        str = "collectUrl is empty";
        v.e("hmsSdk", str);
    }

    private byte[] a(h1 h1Var) {
        String str;
        try {
            JSONObject a16 = h1Var.a();
            if (a16 != null) {
                return k1.a(a16.toString().getBytes("UTF-8"));
            }
            v.e("hmsSdk", "uploadEvents is null");
            return new byte[0];
        } catch (UnsupportedEncodingException unused) {
            str = "sendData(): getBytes - Unsupported coding format!!";
            v.e("hmsSdk", str);
            return new byte[0];
        } catch (JSONException unused2) {
            str = "uploadEvents to json error";
            v.e("hmsSdk", str);
            return new byte[0];
        }
    }
}
