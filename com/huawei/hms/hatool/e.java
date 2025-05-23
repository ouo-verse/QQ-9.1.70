package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private static e f37093b;

    /* renamed from: c, reason: collision with root package name */
    private static Map<String, Long> f37094c = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private Context f37095a;

    public static e a() {
        return b();
    }

    private static synchronized e b() {
        e eVar;
        synchronized (e.class) {
            if (f37093b == null) {
                f37093b = new e();
            }
            eVar = f37093b;
        }
        return eVar;
    }

    private void b(Context context) {
        String str;
        String d16 = o.d(context);
        q0.a(d16);
        if (q1.b().a()) {
            String a16 = d.a(context, "global_v2", "app_ver", "");
            d.b(context, "global_v2", "app_ver", d16);
            q0.b(a16);
            if (!TextUtils.isEmpty(a16)) {
                if (a16.equals(d16)) {
                    return;
                }
                v.c("hmsSdk", "the appVers are different!");
                a().a("", "alltype", a16);
                return;
            }
            str = "app ver is first save!";
        } else {
            str = "userManager.isUserUnlocked() == false";
        }
        v.c("hmsSdk", str);
    }

    public void a(Context context) {
        this.f37095a = context;
        b(context);
        s.c().b().h(o.a());
    }

    public void a(String str, int i3) {
        if (this.f37095a == null) {
            v.e("hmsSdk", "onReport() null context or SDK was not init.");
        } else {
            v.c("hmsSdk", "onReport: Before calling runtaskhandler()");
            a(str, n1.a(i3), q0.g());
        }
    }

    public void a(String str, int i3, String str2, JSONObject jSONObject) {
        long currentTimeMillis = System.currentTimeMillis();
        if (2 == i3) {
            currentTimeMillis = n1.a(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, currentTimeMillis);
        }
        b0.c().a(new a0(str2, jSONObject, str, n1.a(i3), currentTimeMillis));
    }

    public void a(String str, int i3, String str2, JSONObject jSONObject, long j3) {
        new i1(str, n1.a(i3), str2, jSONObject.toString(), j3).a();
    }

    public void a(String str, String str2) {
        if (!a1.a(str, str2)) {
            v.c("hmsSdk", "auto report is closed tag:" + str);
            return;
        }
        long j3 = a1.j(str, str2);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - j3 <= 30000) {
            v.f("hmsSdk", "autoReport timeout. interval < 30s ");
            return;
        }
        v.a("hmsSdk", "begin to call onReport!");
        a1.a(str, str2, currentTimeMillis);
        a(str, str2, q0.g());
    }

    public void a(String str, String str2, String str3) {
        Context context = this.f37095a;
        if (context == null) {
            v.e("hmsSdk", "onReport() null context or SDK was not init.");
            return;
        }
        String a16 = r0.a(context);
        if (a1.e(str, str2) && !Global.TRACKING_WIFI.equals(a16)) {
            v.c("hmsSdk", "strNetworkType is :" + a16);
            return;
        }
        if (TextUtils.isEmpty(a16) || "2G".equals(a16)) {
            v.e("hmsSdk", "The network is bad.");
        } else {
            b0.c().a(new v0(str, str2, str3));
        }
    }
}
