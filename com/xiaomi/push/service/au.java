package com.xiaomi.push.service;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.push.hz;
import com.xiaomi.push.ii;
import com.xiaomi.push.ij;
import com.xiaomi.push.service.am;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes28.dex */
public class au {

    /* renamed from: a, reason: collision with root package name */
    public final String f389664a;

    /* renamed from: b, reason: collision with root package name */
    public final String f389665b;

    /* renamed from: c, reason: collision with root package name */
    public final String f389666c;

    /* renamed from: d, reason: collision with root package name */
    public final String f389667d;

    /* renamed from: e, reason: collision with root package name */
    public final String f389668e;

    /* renamed from: f, reason: collision with root package name */
    public final String f389669f;

    /* renamed from: g, reason: collision with root package name */
    public final int f389670g;

    public au(String str, String str2, String str3, String str4, String str5, String str6, int i3) {
        this.f389664a = str;
        this.f389665b = str2;
        this.f389666c = str3;
        this.f389667d = str4;
        this.f389668e = str5;
        this.f389669f = str6;
        this.f389670g = i3;
    }

    private static String c(Context context) {
        if ("com.xiaomi.xmsf".equals(context)) {
            if (!TextUtils.isEmpty(null)) {
                return null;
            }
            String g16 = hz.g("ro.miui.region");
            if (TextUtils.isEmpty(g16)) {
                return hz.g("ro.product.locale.region");
            }
            return g16;
        }
        return hz.n();
    }

    public static boolean d() {
        try {
            return ii.c(null, "miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean(null);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean e(Context context) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName()) && d()) {
            return true;
        }
        return false;
    }

    private static boolean f(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    public am.b a(XMPushService xMPushService) {
        am.b bVar = new am.b(xMPushService);
        b(bVar, xMPushService, xMPushService.m459b(), "c");
        return bVar;
    }

    public am.b b(am.b bVar, Context context, an anVar, String str) {
        String str2;
        bVar.f389605a = context.getPackageName();
        bVar.f389606b = this.f389664a;
        bVar.f389613i = this.f389666c;
        bVar.f389607c = this.f389665b;
        bVar.f389612h = "5";
        bVar.f389608d = "XMPUSH-PASS";
        bVar.f389609e = false;
        ij.a aVar = new ij.a();
        aVar.a(HiAnalyticsConstant.BI_KEY_SDK_VER, 48).a("cpvn", "5_9_9-C").a("cpvc", 50909).a("country_code", ag.a(context).f()).a(TtmlNode.TAG_REGION, ag.a(context).b()).a("miui_vn", hz.q()).a("miui_vc", Integer.valueOf(hz.b(context))).a("xmsf_vc", Integer.valueOf(com.xiaomi.push.g.b(context, "com.xiaomi.xmsf"))).a("android_ver", Integer.valueOf(Build.VERSION.SDK_INT)).a("n_belong_to_app", Boolean.valueOf(j.t(context))).a("systemui_vc", Integer.valueOf(com.xiaomi.push.g.a(context)));
        String c16 = c(context);
        if (!TextUtils.isEmpty(c16)) {
            aVar.a("latest_country_code", c16);
        }
        String s16 = hz.s();
        if (!TextUtils.isEmpty(s16)) {
            aVar.a("device_ch", s16);
        }
        String u16 = hz.u();
        if (!TextUtils.isEmpty(u16)) {
            aVar.a("device_mfr", u16);
        }
        bVar.f389610f = aVar.toString();
        if (f(context)) {
            str2 = "1000271";
        } else {
            str2 = this.f389667d;
        }
        ij.a aVar2 = new ij.a();
        aVar2.a("appid", str2).a("locale", Locale.getDefault().toString()).a("sync", 1);
        if (e(context)) {
            aVar2.a("ab", str);
        }
        bVar.f389611g = aVar2.toString();
        bVar.f389615k = anVar;
        return bVar;
    }
}
