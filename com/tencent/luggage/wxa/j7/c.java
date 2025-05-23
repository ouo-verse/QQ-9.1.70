package com.tencent.luggage.wxa.j7;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.luggage.wxa.i3.t;
import com.tencent.luggage.wxa.ii.h;
import com.tencent.luggage.wxa.mc.j0;
import com.tencent.luggage.wxa.mc.r;
import com.tencent.luggage.wxa.n3.m0;
import com.tencent.luggage.wxa.tn.b1;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c implements a {
    @Override // com.tencent.luggage.wxa.j7.a
    public void a(Intent intent, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Map a16 = b1.a(str, "sysmsg", null);
        if (a16 == null) {
            w.b("WMPF.Debugger.ForceOpenAppNotify", "parsedKV is null, return");
            return;
        }
        String str2 = (String) a16.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppID");
        int a17 = w0.a((String) a16.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.VersionType"), -1);
        w0.a((String) a16.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppVersion"), -1);
        String str3 = (String) a16.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.Path");
        String str4 = (String) a16.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.URL");
        String str5 = (String) a16.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.MD5");
        String str6 = (String) a16.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.ExtJsonInfo");
        String str7 = (String) a16.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.SubUrls");
        if (a17 >= 0 && !TextUtils.isEmpty(str2)) {
            if (a17 != 0) {
                if (j0.a().a(str2, a17, str4, str5)) {
                    b.b(str2, a17);
                }
                a(str2, str7, a17);
                h.a().a(str2, a17, str6);
            }
            com.tencent.luggage.wxa.d6.b bVar = new com.tencent.luggage.wxa.d6.b();
            bVar.f124086d = str2;
            bVar.f124089g = str3;
            bVar.f124090h = a17;
            t.a(z.c(), bVar);
        }
    }

    @Override // com.tencent.luggage.wxa.j7.a
    public String name() {
        return "ForceOpenAppNotify";
    }

    public static void a(String str, String str2, int i3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str3 = (String) keys.next();
                j0.a().a(new r(str, str3).toString(), i3, jSONObject.optString(str3), m0.f135220a);
            }
        } catch (Throwable th5) {
            w.a("WMPF.Debugger.ForceOpenAppNotify", th5, "processSubUrlsAndSave appId[%s], json[%s]", str, str2);
        }
    }
}
