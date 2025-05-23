package com.huya.huyasdk.api;

import android.content.Context;
import android.os.Build;
import com.huya.huyasdk.api.HuyaSdk;
import com.huya.huyasdk.service.api.ILoginService;
import com.huya.huyasdk.service.api.IQimeiService;
import com.huya.huyasdk.service.api.IUdbInfoService;
import hynb.b.l;
import hynb.e.a;
import hynb.j.d;
import hynb.n.b;
import hynb.p.c;
import hynb.p.e;
import hynb.p.g;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HuyaSdk {
    public static final String TAG = "HuyaSdk";
    public static boolean isInit = false;
    public static LifecycleApi mLifecycleApi;
    public static IHYLogger mLogger = new a();

    public static /* synthetic */ boolean a() {
        LifecycleApi lifecycleApi = mLifecycleApi;
        if (lifecycleApi != null && lifecycleApi.isForeGround()) {
            return true;
        }
        return false;
    }

    public static IHYLogger getLogger() {
        return mLogger;
    }

    public static void initHuyaSdk(Context context, b bVar) {
        l.i().a(context);
        l.i().b(bVar.f406768a + "&cn&2052");
        l.i().c(hynb.m.a.f406755b);
        l.i().b(bVar.f406775h);
        l.i().a(bVar.f406779l);
        l.i().a(new hynb.c.a() { // from class: com.huya.huyasdk.api.HuyaSdk.1
            @Override // hynb.c.a
            public boolean isForeGround() {
                if (HuyaSdk.mLifecycleApi != null) {
                    return HuyaSdk.mLifecycleApi.isForeGround();
                }
                g.f406799a.info(HuyaSdk.TAG, "mLifecycleApi is null!");
                return false;
            }
        });
        if (bVar.f406776i) {
            hynb.i.a.a();
        }
        g.f406799a.info(TAG, String.format("dynamic resource ready, init HuyaSdk with version: %s, buildNumber: %s, huyaua: %s, enableNetEncrypt: %s, testEnv: %s", "1.0.5", "253", hynb.m.a.f406755b, Boolean.valueOf(bVar.f406779l), Boolean.valueOf(bVar.f406775h)));
    }

    public static void initMtpApi(final Context context) {
        g.a(new hynb.e.b());
        context.getClass();
        g.a(new hynb.p.a() { // from class: z2.c
        });
        g.a(new c() { // from class: z2.d
            @Override // hynb.p.c
            public final boolean a() {
                return HuyaSdk.a();
            }
        });
    }

    public static synchronized void setup(Context context, String str, IHYLogger iHYLogger, LifecycleApi lifecycleApi) {
        synchronized (HuyaSdk.class) {
            if (isInit) {
                g.f406799a.error(TAG, "HuyaSdk has been initialized");
                return;
            }
            isInit = true;
            if (iHYLogger != null) {
                mLogger = iHYLogger;
            }
            mLifecycleApi = lifecycleApi;
            initMtpApi(context);
            b udbInfo = ((IUdbInfoService) d.a(IUdbInfoService.class)).getUdbInfo(str);
            if (udbInfo == null) {
                g.f406799a.b(TAG, "udbInfo is null, appId: %s", str);
                return;
            }
            hynb.m.a.f406755b = String.format("%s&%s&official&%s", udbInfo.f406772e, "1.0.5", Integer.valueOf(Build.VERSION.SDK_INT));
            hynb.m.a.f406756c = Integer.parseInt("253");
            hynb.m.a.f406757d = "huyasdk";
            hynb.m.a.f406754a = context;
            hynb.n.a.a().f406767a = udbInfo;
            initHuyaSdk(context, udbInfo);
            ((ILoginService) d.a(ILoginService.class)).init(udbInfo);
            hynb.o.d.a(new Runnable() { // from class: z2.b
                @Override // java.lang.Runnable
                public final void run() {
                    ((IQimeiService) hynb.j.d.a(IQimeiService.class)).init();
                }
            }, 3000L);
            e eVar = g.f406799a;
            eVar.a(TAG, "init HuyaSdk with version: %s, buildNumber: %s", "1.0.5", "253");
            eVar.c(TAG, "huyaUa: %s", hynb.m.a.f406755b);
        }
    }
}
