package com.tencent.tgpa.lite.a;

import android.os.Build;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tgpa.lite.g.d;
import com.tencent.tgpa.lite.g.f;
import com.tencent.tgpa.lite.g.g;
import com.tencent.tgpa.lite.g.h;
import com.tencent.tgpa.lite.g.j;
import com.tenpay.ndk.CftSoLoader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f375866a;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private com.tencent.tgpa.lite.b.a b() {
        h.c("start to check local config.", new Object[0]);
        if (com.tencent.tgpa.lite.g.a.b() == null) {
            h.a("no context, can not get ex file path.", new Object[0]);
            return com.tencent.tgpa.lite.b.a.f375904x;
        }
        String str = com.tencent.tgpa.lite.g.a.b() + File.separator + ".tgpacloud";
        if (!f.c(str)) {
            h.a("no local cloud config was found.", new Object[0]);
            return com.tencent.tgpa.lite.b.a.f375905y;
        }
        String d16 = f.d(str);
        if (d16 == null) {
            h.a("local cloud config read exception.", new Object[0]);
            return com.tencent.tgpa.lite.b.a.f375906z;
        }
        if (!b.a().a(d16)) {
            h.a("local cloud config parse exception, ple check it's content.", new Object[0]);
            return com.tencent.tgpa.lite.b.a.A;
        }
        return com.tencent.tgpa.lite.b.a.f375882b;
    }

    private com.tencent.tgpa.lite.b.a c() {
        String str = com.tencent.tgpa.lite.f.a.a() + "/cloudctrl/cloud_ctrl";
        try {
            HashMap<String, String> d16 = d();
            h.a("download url: %s, data: %s.", str, d16.toString());
            String a16 = g.a(str, d16);
            h.a("download config response content: " + String.valueOf(a16), new Object[0]);
            if (a16 == null) {
                h.a("download config is null, ple check!", new Object[0]);
                return com.tencent.tgpa.lite.b.a.f375894n;
            }
            JSONObject jSONObject = new JSONObject(a16);
            if (!jSONObject.has("ret")) {
                h.a("download config has no ret, ple check!", new Object[0]);
                return com.tencent.tgpa.lite.b.a.f375899s;
            }
            if (jSONObject.getInt("ret") != 0) {
                h.d("download config ret is not 0, ple call tgpa team to open the server's control!", new Object[0]);
                return com.tencent.tgpa.lite.b.a.f375900t;
            }
            if (!jSONObject.has("data")) {
                h.a("download config has no data, ple check! ", new Object[0]);
                return com.tencent.tgpa.lite.b.a.f375901u;
            }
            String string = jSONObject.getString("data");
            if (!b.a().a(string)) {
                h.a("download config parse exception, ple check data.", new Object[0]);
                return com.tencent.tgpa.lite.b.a.f375898r;
            }
            String optString = jSONObject.optString("key");
            if (b.a().b(optString) != 0) {
                h.d("download config parse failed, ple check key. key: " + optString, new Object[0]);
                b.a().f375869b.f375871a = j.a("SecretKey", null);
                b.a().f375869b.f375872b = j.a("IvParameter", null);
            }
            this.f375866a = string;
            return com.tencent.tgpa.lite.b.a.f375882b;
        } catch (IOException e16) {
            e16.printStackTrace();
            h.a("download config exception, ple check your network! ", new Object[0]);
            return com.tencent.tgpa.lite.b.a.f375893m;
        } catch (JSONException e17) {
            e17.printStackTrace();
            h.a("download config parse json exception, ple check response! ", new Object[0]);
            return com.tencent.tgpa.lite.b.a.f375897q;
        } catch (Exception e18) {
            e18.printStackTrace();
            h.a("download config exception, ple check sdk! ", new Object[0]);
            return com.tencent.tgpa.lite.b.a.f375903w;
        }
    }

    private HashMap<String, String> d() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("tgpa_id", com.tencent.tgpa.lite.f.a.c());
        hashMap.put(HianalyticsBaseData.SDK_TYPE, "simple");
        hashMap.put("plat_type", "Android");
        hashMap.put("ver_code", String.valueOf(26));
        hashMap.put("ver_name", CftSoLoader.VERSION_1_2_6);
        hashMap.put("os_version", Build.VERSION.RELEASE);
        hashMap.put("os_sdk", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("manufacturer", d.e());
        hashMap.put("brand", d.b());
        hashMap.put("model", d.f());
        hashMap.put("device", d.d());
        hashMap.put("ui_mode", String.valueOf(d.i()));
        hashMap.put("cpu_info", d.g());
        hashMap.put("screen_size", String.valueOf(d.h()));
        hashMap.put("can_phone", String.valueOf(d.a()));
        hashMap.put("pkg_name", com.tencent.tgpa.lite.g.a.c());
        hashMap.put(TagName.PKG_VERSION, com.tencent.tgpa.lite.g.a.d());
        String a16 = j.a("XID", null);
        if (a16 == null) {
            a16 = "";
        }
        hashMap.put("xid", a16);
        return hashMap;
    }

    private void e() {
        String str = com.tencent.tgpa.lite.g.a.b() + File.separator + ".tgpacloud";
        if (f.c(str) && !f.a(str)) {
            h.b("save cloud data to file failed, delete old file failed!", new Object[0]);
        } else if (f.b(str, this.f375866a)) {
            h.c("save cloud data to file success!", new Object[0]);
        } else {
            h.b("save cloud data to file failed!", new Object[0]);
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        com.tencent.tgpa.lite.b.a c16 = c();
        com.tencent.tgpa.lite.b.a aVar = com.tencent.tgpa.lite.b.a.f375882b;
        if (c16 != aVar) {
            h.b("check config from cloud failed! code: " + c16.a(), new Object[0]);
            com.tencent.tgpa.lite.b.a b16 = b();
            if (b16 != aVar) {
                h.b("check config from local failed! code: " + b16.a(), new Object[0]);
                return;
            }
            h.a("check config from local success!", new Object[0]);
            return;
        }
        h.a("check config from cloud success!", new Object[0]);
        e();
    }
}
