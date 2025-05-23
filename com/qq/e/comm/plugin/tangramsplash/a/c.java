package com.qq.e.comm.plugin.tangramsplash.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.QQSetting;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.net.NetworkCallBack;
import com.qq.e.comm.net.NetworkClientImpl;
import com.qq.e.comm.net.rr.PlainRequest;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.base.ad.model.s;
import com.qq.e.comm.plugin.base.ad.model.u;
import com.qq.e.comm.plugin.k.ab;
import com.qq.e.comm.plugin.k.af;
import com.qq.e.comm.plugin.k.ai;
import com.qq.e.comm.plugin.k.ay;
import com.qq.e.comm.plugin.k.g;
import com.qq.e.comm.plugin.tangramsplash.d.f;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.SharedPreferencedUtil;
import com.tencent.ams.adcore.mma.util.DeviceInfoUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f39782a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static volatile c f39783b;

    /* renamed from: c, reason: collision with root package name */
    private int f39784c = 0;

    c() {
        a(GDTADManager.getInstance().getAppContext());
    }

    static /* synthetic */ int b(c cVar) {
        int i3 = cVar.f39784c;
        cVar.f39784c = i3 + 1;
        return i3;
    }

    public static boolean c() {
        return com.qq.e.comm.plugin.tangramsplash.d.a.b().equalsIgnoreCase(h());
    }

    public static void d() {
        SharedPreferencedUtil.putString("first_play_date", com.qq.e.comm.plugin.tangramsplash.d.a.b());
    }

    public static void e() {
        GDTLogger.d("SplashReportHelper clear fp report Data");
        ai.b(ai.c());
    }

    static /* synthetic */ List f() {
        return i();
    }

    private static String h() {
        return SharedPreferencedUtil.getString("first_play_date", "");
    }

    private static List<a> i() {
        File[] listFiles = ai.c().listFiles();
        if (g.b(listFiles)) {
            GDTLogger.d("SplashReportHelper no first play cache data");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (f39782a) {
            for (File file : listFiles) {
                a aVar = new a(ai.c(file));
                arrayList.add(aVar);
                GDTLogger.d("bean " + aVar.toString());
            }
            e();
        }
        return arrayList;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        GdtSDKThreadManager.getInstance().runOnThread(2, new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (f.a(context)) {
                    GDTLogger.i("SplashReportHelper\uff1a\u6709\u7f51\u7edc\u5c1d\u8bd5\u8865\u62a5\u7b2c\u4e00\u5237");
                    c.this.b();
                    if (c.this.f39784c != 0 && !f.d() && GDTADManager.getInstance().getSM().getInteger(Constants.KEYS.TANGRAM_SPLASH_MATERIAL_CHECK_NET_WORK_RECOVER, 0) == 1) {
                        GDTLogger.i("SplashReportHelper\uff1a\u7f51\u7edc\u6062\u590d \u89e6\u53d1\u95ea\u5c4f\u7d20\u6750\u68c0\u6d4b");
                        com.qq.e.comm.plugin.tangramsplash.b.c.a(1);
                    }
                    c.b(c.this);
                    boolean a16 = com.qq.e.comm.plugin.j.c.a("isUseNewImgVideoDownloadLogic", 0, 1);
                    boolean isWifi = DeviceInfoUtil.isWifi(context);
                    com.qq.e.comm.plugin.i.f a17 = com.qq.e.comm.plugin.i.f.a(context);
                    GDTLogger.i("SplashReportHelper\uff1a\u7f51\u7edc\u72b6\u6001\u53d8\u5316\uff0c isUseNewImgAndVideoDownloadLogic\uff1a" + a16 + " \u5f53\u524d\u7f51\u7edc\u662f\u5426\u4e3awifi\u72b6\u6001\uff1a" + isWifi + " allowPreloadNonVideoNetType\uff1a" + QQSetting.getAllowPreloadNonVideoNetType() + " allowPreloadVideoNetType\uff1a" + QQSetting.getAllowPreloadVideoNetType());
                    b.a(a16, a17, isWifi);
                    return;
                }
                GDTLogger.i("SplashReportHelper\uff1a\u5f53\u524d\u65e0\u7f51\u7edc\u8fde\u63a5");
            }
        });
    }

    public static c a() {
        if (f39783b == null) {
            synchronized (c.class) {
                if (f39783b == null) {
                    f39783b = new c();
                }
            }
        }
        return f39783b;
    }

    public void b() {
        GdtSDKThreadManager.getInstance().runOnThread(3, new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                List<a> f16 = c.f();
                if (f16 != null && f16.size() != 0) {
                    for (final a aVar : f16) {
                        if (aVar != null && !TextUtils.isEmpty(aVar.f39773n)) {
                            String b16 = com.qq.e.comm.plugin.k.b.b(aVar.f39773n);
                            aVar.f39773n = b16;
                            String c16 = com.qq.e.comm.plugin.k.b.c(b16);
                            aVar.f39773n = c16;
                            String d16 = ay.d(c16, "rt", "1");
                            aVar.f39773n = d16;
                            NetworkClientImpl.getInstance().submit(new PlainRequest(d16, 1, (byte[]) null), 1, new NetworkCallBack() { // from class: com.qq.e.comm.plugin.tangramsplash.a.c.2.1
                                @Override // com.qq.e.comm.net.NetworkCallBack
                                public void onException(Exception exc) {
                                    a aVar2 = aVar;
                                    com.qq.e.comm.plugin.tangramsplash.report.c.a(1310322, aVar2.f39776q, aVar2.f39778s, aVar2.f39777r, aVar2.f39779t, -26);
                                    a aVar3 = aVar;
                                    com.qq.e.comm.plugin.tangramsplash.report.c.a(1310325, aVar3.f39776q, aVar3.f39778s, aVar3.f39777r, aVar3.f39779t, -26);
                                    GDTLogger.e("SplashReportHelpersplash exposure exception: " + exc.getMessage());
                                }

                                @Override // com.qq.e.comm.net.NetworkCallBack
                                public void onResponse(Request request, Response response) {
                                    if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
                                        a aVar2 = aVar;
                                        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310327, aVar2.f39776q, aVar2.f39778s, aVar2.f39777r, aVar2.f39779t, response.getStatusCode());
                                        a aVar3 = aVar;
                                        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310328, aVar3.f39776q, aVar3.f39778s, aVar3.f39777r, aVar3.f39779t, response.getStatusCode());
                                        GDTLogger.i("SplashReportHelpersplash exposure success");
                                        return;
                                    }
                                    a aVar4 = aVar;
                                    com.qq.e.comm.plugin.tangramsplash.report.c.a(1310322, aVar4.f39776q, aVar4.f39778s, aVar4.f39777r, aVar4.f39779t, response.getStatusCode());
                                    a aVar5 = aVar;
                                    com.qq.e.comm.plugin.tangramsplash.report.c.a(1310325, aVar5.f39776q, aVar5.f39778s, aVar5.f39777r, aVar5.f39779t, response.getStatusCode());
                                    GDTLogger.i("SplashReportHelpersplash exposure failed: " + response.getStatusCode());
                                }
                            });
                            List<String> list = aVar.f39774o;
                            if (list != null && list.size() > 0) {
                                for (String str : aVar.f39774o) {
                                    if (!TextUtils.isEmpty(str)) {
                                        af.b(str);
                                    }
                                }
                            }
                            List<String> list2 = aVar.f39775p;
                            if (list2 != null && list2.size() > 0) {
                                for (String str2 : aVar.f39775p) {
                                    if (!TextUtils.isEmpty(str2)) {
                                        ab.a(str2);
                                    }
                                }
                            }
                            if (!TextUtils.isEmpty(aVar.f39780u)) {
                                String b17 = com.qq.e.comm.plugin.k.b.b(aVar.f39780u);
                                aVar.f39780u = b17;
                                com.qq.e.comm.plugin.base.ad.e.b.a(b17, aVar.f39781v);
                            }
                        }
                    }
                }
            }
        });
    }

    public static boolean b(r rVar) {
        List<u> bs5;
        if (rVar == null || (bs5 = rVar.bs()) == null || bs5.size() <= 0) {
            return false;
        }
        Iterator<u> it = bs5.iterator();
        while (it.hasNext()) {
            if (a(it.next())) {
                return true;
            }
        }
        return false;
    }

    private void a(Context context) {
        try {
            context.getApplicationContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public static boolean a(r rVar) {
        List<u> bs5;
        if (rVar == null || (bs5 = rVar.bs()) == null || bs5.size() <= 0) {
            return false;
        }
        for (u uVar : bs5) {
            if (uVar != null && uVar.f() && a(uVar)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(u uVar) {
        if (uVar == null) {
            return false;
        }
        return com.qq.e.comm.plugin.tangramsplash.d.a.a(uVar.d());
    }

    public static void a(final a aVar) {
        GdtSDKThreadManager.getInstance().runOnThread(3, new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.f39782a) {
                    a aVar2 = a.this;
                    if (aVar2 != null) {
                        String a16 = aVar2.a();
                        if (!TextUtils.isEmpty(a16)) {
                            String b16 = a.this.b();
                            if (!TextUtils.isEmpty(b16)) {
                                GDTLogger.d("SplashReportHelpercache fb report data " + b16);
                                ai.a(new File(ai.c() + File.separator + b16), a16);
                            }
                        }
                    }
                }
            }
        });
    }

    public static void a(r rVar, boolean z16) {
        int a16;
        if (rVar == null || (a16 = com.qq.e.comm.plugin.j.c.a(rVar.s(), "splashNeedOfflineReport", 1)) == 4) {
            return;
        }
        if (a16 == 2 && rVar.bf() == 2) {
            return;
        }
        if (a16 != 3 || rVar.bf() == 2) {
            a aVar = new a();
            aVar.f39771l = rVar.bn();
            aVar.f39772m = com.qq.e.comm.plugin.tangramsplash.d.a.b();
            aVar.f39773n = com.qq.e.comm.plugin.k.b.d(rVar.j());
            aVar.f39776q = rVar.s();
            aVar.f39778s = rVar.f();
            aVar.f39777r = rVar.y();
            aVar.f39779t = z16;
            aVar.f39780u = rVar.l();
            aVar.f39781v = com.qq.e.comm.plugin.k.b.h(rVar.v());
            if (rVar.C() != null && rVar.C().size() > 0) {
                aVar.f39774o = new ArrayList();
                Iterator<s> it = rVar.C().iterator();
                while (it.hasNext()) {
                    aVar.f39774o.add(it.next().a());
                }
            }
            if (rVar.D() != null && rVar.D().size() > 0) {
                aVar.f39775p = new ArrayList();
                Iterator<s> it5 = rVar.D().iterator();
                while (it5.hasNext()) {
                    aVar.f39775p.add(it5.next().a());
                }
            }
            a(aVar);
        }
    }
}
