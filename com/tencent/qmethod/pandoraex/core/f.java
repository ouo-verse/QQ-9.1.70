package com.tencent.qmethod.pandoraex.core;

import android.text.TextUtils;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qmethod.pandoraex.api.Constant$DefaultConfig;
import com.tencent.qmethod.pandoraex.api.b;
import com.tencent.qmethod.pandoraex.api.v;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    public static com.tencent.qmethod.pandoraex.api.b f344120a = new b.a().f("default_module").a(new v.a().g("before").i("ban").a()).a(new v.a().g("back").i("cache_only").a()).g(1).b();

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    public static com.tencent.qmethod.pandoraex.api.b f344121b = new b.a().f("default_module").a(new v.a().g("before").i("ban").a()).a(new v.a().g("back").i("cache_only").a()).g(1000).b();

    /* renamed from: c, reason: collision with root package name */
    @Deprecated
    public static com.tencent.qmethod.pandoraex.api.b f344122c = new b.a().f("default_module").a(new v.a().g("before").i("ban").a()).a(new v.a().g("back").i("cache_only").a()).g(100000).b();

    /* renamed from: d, reason: collision with root package name */
    @Deprecated
    public static com.tencent.qmethod.pandoraex.api.b f344123d = new b.a().f("recorder").d(true).b();

    /* renamed from: e, reason: collision with root package name */
    @Deprecated
    public static com.tencent.qmethod.pandoraex.api.b f344124e = new b.a().f("camera").d(true).b();

    /* renamed from: f, reason: collision with root package name */
    @Deprecated
    public static com.tencent.qmethod.pandoraex.api.b f344125f = new b.a().f("clipboard").g(1).c(new com.tencent.qmethod.pandoraex.api.c(10, 10)).b();

    /* renamed from: g, reason: collision with root package name */
    @Deprecated
    public static com.tencent.qmethod.pandoraex.api.b f344126g = new b.a().f("clipboard").g(10).c(new com.tencent.qmethod.pandoraex.api.c(10, 10)).b();

    /* renamed from: h, reason: collision with root package name */
    @Deprecated
    public static com.tencent.qmethod.pandoraex.api.b f344127h = new b.a().f("clipboard").g(10000).c(new com.tencent.qmethod.pandoraex.api.c(10, 10)).b();

    /* renamed from: i, reason: collision with root package name */
    @Deprecated
    public static com.tencent.qmethod.pandoraex.api.b f344128i = new b.a().f("contact").d(true).b();

    /* renamed from: j, reason: collision with root package name */
    @Deprecated
    public static com.tencent.qmethod.pandoraex.api.b f344129j = new b.a().f("location").d(true).b();

    /* renamed from: k, reason: collision with root package name */
    private static final Object f344130k = new Object();

    /* renamed from: l, reason: collision with root package name */
    private static final ConcurrentHashMap<String, com.tencent.qmethod.pandoraex.api.b> f344131l = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f344132a;

        static {
            int[] iArr = new int[Constant$DefaultConfig.values().length];
            f344132a = iArr;
            try {
                iArr[Constant$DefaultConfig.DEFAULT_CONFIG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f344132a[Constant$DefaultConfig.DEFAULT_CONFIG_WITH_HIGH_FREQ.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        d(new b.a().f("default_module").g(1).b());
    }

    public static com.tencent.qmethod.pandoraex.api.b a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f344131l.get(com.tencent.qmethod.pandoraex.api.b.c(str, str2, str3));
    }

    private static void b() {
        d(f344120a);
        d(f344125f);
        d(f344128i);
        d(f344129j);
        com.tencent.qmethod.pandoraex.api.b b16 = new b.a().f("device").a(new v.a().g("normal").i(QQPermissionConstants.Permission.STORAGE_GROUP).a()).b();
        d(b16);
        b16.f343878a = "network";
        b16.f343879b = "WI#G_MA_ADDR";
        d(b16);
        b16.f343879b = "NI#G_HW_ADDR";
        d(b16);
        com.tencent.qmethod.pandoraex.api.b b17 = new b.a().f("device").i("TM#G_LI_NUM").a(new v.a().g("normal").i("normal").b(10000L).a()).b();
        d(b17);
        b17.f343879b = "TM#G_SIM_OP";
        d(b17);
        b17.f343879b = "TM#G_SIM_SE_NUM";
        d(b17);
        d(new b.a().f(WebRTCSDK.PRIVILEGE_SENSOR).a(new v.a().g("back").i("normal").a()).b());
    }

    public static void c(Constant$DefaultConfig constant$DefaultConfig) {
        if (constant$DefaultConfig == null) {
            o.c("ConfigManager", "initDefaultConfig initLevel is null!");
            return;
        }
        ConcurrentHashMap<String, com.tencent.qmethod.pandoraex.api.b> concurrentHashMap = f344131l;
        concurrentHashMap.clear();
        int i3 = a.f344132a[constant$DefaultConfig.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                o.c("ConfigManager", "initDefaultConfig initLevel not match any DefaultLevel!");
                return;
            } else {
                o.c("ConfigManager", "initDefaultConfig initLevel is defaultConfigWithHighFreq");
                concurrentHashMap.putAll(g.a());
                return;
            }
        }
        o.c("ConfigManager", "initDefaultConfig initLevel is defaultConfig");
        b();
    }

    public static boolean d(com.tencent.qmethod.pandoraex.api.b bVar) {
        if (bVar == null) {
            return false;
        }
        return x.f(f344131l, bVar);
    }

    public static boolean e(com.tencent.qmethod.pandoraex.api.b bVar) {
        if (bVar == null) {
            return false;
        }
        return x.g(f344131l, bVar, true);
    }
}
