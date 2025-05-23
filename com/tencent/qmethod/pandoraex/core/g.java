package com.tencent.qmethod.pandoraex.core;

import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qmethod.pandoraex.api.b;
import com.tencent.qmethod.pandoraex.api.v;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f344133a = new Object();

    public static Map<String, com.tencent.qmethod.pandoraex.api.b> a() {
        HashMap hashMap;
        synchronized (f344133a) {
            hashMap = new HashMap();
            b(hashMap);
            d(hashMap);
            c(hashMap);
            e(hashMap);
        }
        return hashMap;
    }

    private static void b(Map<String, com.tencent.qmethod.pandoraex.api.b> map) {
        x.f(map, new b.a().f("default_module").a(new v.a().g("before").i("ban").a()).a(new v.a().g("back").i("cache_only").a()).a(new v.a().g("silence").h(10000L).i("cache_only").a()).a(new v.a().g("high_freq").c(new com.tencent.qmethod.pandoraex.api.c(10000L, 10)).i("normal").a()).a(new v.a().g("normal").i("normal").a()).a(new v.a().g("mod_no_perm").i("ban").a()).a(new v.a().g("deny_retry").i("ban").a()).b());
    }

    private static void c(Map<String, com.tencent.qmethod.pandoraex.api.b> map) {
        x.f(map, new b.a().f("device").a(new v.a().g("high_freq").c(new com.tencent.qmethod.pandoraex.api.c(10000L, 10)).i(QQPermissionConstants.Permission.STORAGE_GROUP).b(0L).a()).a(new v.a().g("normal").i(QQPermissionConstants.Permission.STORAGE_GROUP).b(0L).a()).b());
        com.tencent.qmethod.pandoraex.api.b b16 = new b.a().f("device").i("TM#G_LI_NUM").a(new v.a().g("high_freq").c(new com.tencent.qmethod.pandoraex.api.c(10000L, 10)).i("normal").a()).a(new v.a().g("normal").i("normal").a()).b();
        x.f(map, b16);
        b16.f343879b = "TM#G_SIM_SE_NUM";
        x.f(map, b16);
        b16.f343879b = "TM#G_SIM_OP";
        x.f(map, b16);
    }

    private static void d(Map<String, com.tencent.qmethod.pandoraex.api.b> map) {
        com.tencent.qmethod.pandoraex.api.b b16 = new b.a().f("network").i("WI#G_MA_ADDR").a(new v.a().g("high_freq").c(new com.tencent.qmethod.pandoraex.api.c(10000L, 10)).i(QQPermissionConstants.Permission.STORAGE_GROUP).b(0L).a()).a(new v.a().g("normal").i(QQPermissionConstants.Permission.STORAGE_GROUP).b(0L).a()).b();
        x.f(map, b16);
        b16.f343879b = "NI#G_HW_ADDR";
        x.f(map, b16);
    }

    private static void e(Map<String, com.tencent.qmethod.pandoraex.api.b> map) {
        x.f(map, new b.a().f(WebRTCSDK.PRIVILEGE_SENSOR).a(new v.a().g("back").i("normal").a()).b());
    }
}
