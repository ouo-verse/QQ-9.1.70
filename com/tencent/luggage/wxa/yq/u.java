package com.tencent.luggage.wxa.yq;

import android.content.Context;
import android.os.Handler;
import com.tencent.luggage.wxa.ar.i0;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.y0;
import com.tencent.xweb.XWebSdk;
import com.tencent.xweb.internal.ConstValue;
import com.tencent.xweb.xwalk.plugin.XWalkPluginUpdateListener;
import com.tencent.xweb.xwalk.plugin.XWalkPluginUpdater;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    public static final c f146136a = new s();

    /* renamed from: b, reason: collision with root package name */
    public static final b f146137b = new XWalkPluginUpdater();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f146138a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HashMap f146139b;

        public a(Context context, HashMap hashMap) {
            this.f146138a = context;
            this.f146139b = hashMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            u.c(this.f146138a, this.f146139b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b extends c {
        void cancelPluginUpdate();

        void setPluginOnlyOneToUpdate(String str, XWalkPluginUpdateListener xWalkPluginUpdateListener);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {
        boolean isBusyUpdate();

        boolean needCheckUpdate();

        void startCheck(Context context, HashMap hashMap);
    }

    public static boolean b() {
        if (y0.a() == null) {
            x0.f("XWebUpdater", "checkUpdateTimeThreshold, init xweb environment first");
            return false;
        }
        long j3 = y0.o().getLong("last_check_update_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        long c16 = c();
        x0.d("XWebUpdater", "checkUpdateTimeThreshold, timeThreshold=" + c16 + ", lastCheckTime=" + j3 + ", currentTime=" + currentTimeMillis);
        if (XWebSdk.getInstalledNewstVersion(XWalkEnvironment.getApplicationContext()) <= 0 || Math.abs(currentTimeMillis - j3) >= c16) {
            return true;
        }
        x0.f("XWebUpdater", "checkUpdateTimeThreshold, check too fast");
        return false;
    }

    public static long c() {
        return i0.getFetchConfigPeriod();
    }

    public static boolean d() {
        boolean isBusyUpdate = f146136a.isBusyUpdate();
        boolean isBusyUpdate2 = f146137b.isBusyUpdate();
        if (!isBusyUpdate && !isBusyUpdate2) {
            return false;
        }
        return true;
    }

    public static void e() {
        if (y0.a() == null) {
            x0.f("XWebUpdater", "saveCheckUpdateTime, init first");
        } else {
            y0.o().edit().putLong("last_check_update_time", System.currentTimeMillis()).apply();
        }
    }

    public static void f() {
        x0.d("XWebUpdater", "tryEmbedInstall, start check runtime update");
        HashMap hashMap = new HashMap();
        hashMap.put(ConstValue.XWEB_UPDATER_START_CHECK_TYPE, "4");
        f146136a.startCheck(XWalkEnvironment.getApplicationContext(), hashMap);
    }

    public static void g() {
        x0.d("XWebUpdater", "tryStartDownload, start check runtime update");
        f146136a.startCheck(XWalkEnvironment.getApplicationContext(), null);
    }

    public static void a(Context context) {
        XWalkEnvironment.ensureInitEnvironment(context);
        x0.d("XWebUpdater", "checkConfigUpdate, start check base config update");
        HashMap hashMap = new HashMap();
        hashMap.put(ConstValue.XWEB_UPDATER_START_CHECK_TYPE, "5");
        f146136a.startCheck(XWalkEnvironment.getApplicationContext(), hashMap);
        x0.d("XWebUpdater", "checkConfigUpdate, start check plugin config update");
        HashMap hashMap2 = new HashMap();
        hashMap2.put(ConstValue.XWEB_UPDATER_START_CHECK_TYPE, "5");
        f146137b.startCheck(XWalkEnvironment.getApplicationContext(), hashMap2);
    }

    public static void c(Context context, HashMap hashMap) {
        n0.K();
        x0.d("XWebUpdater", "startCheck, start check plugin update");
        b bVar = f146137b;
        bVar.setPluginOnlyOneToUpdate("", null);
        bVar.startCheck(context, hashMap);
    }

    public static void a() {
        x0.d("XWebUpdater", "checkNeedDownload, start check runtime update");
        HashMap hashMap = new HashMap();
        hashMap.put(ConstValue.XWEB_UPDATER_START_CHECK_TYPE, "2");
        f146136a.startCheck(XWalkEnvironment.getApplicationContext(), hashMap);
    }

    public static void b(Context context, HashMap hashMap) {
        synchronized (u.class) {
            n0.L();
            x0.d("XWebUpdater", "startCheck, start check runtime update");
            e();
            f146136a.startCheck(context, hashMap);
            String str = hashMap != null ? (String) hashMap.get(ConstValue.XWEB_UPDATER_START_CHECK_TYPE) : null;
            x0.d("XWebUpdater", "startCheck, check type:" + str);
            if (str != null && (str.equals("0") || str.equals("7"))) {
                new Handler().postDelayed(new a(context, hashMap), 5000L);
            } else {
                c(context, hashMap);
            }
        }
    }

    public static boolean a(boolean z16) {
        synchronized (u.class) {
            if (!b()) {
                return false;
            }
            if (f146136a.needCheckUpdate()) {
                x0.d("XWebUpdater", "needCheckUpdate, sRuntimeUpdater ret true");
                return true;
            }
            x0.f("XWebUpdater", "needCheckUpdate, sRuntimeUpdater ret false");
            if (!z16) {
                return false;
            }
            if (f146137b.needCheckUpdate()) {
                x0.d("XWebUpdater", "needCheckUpdate, sPluginUpdater ret true");
                return true;
            }
            x0.f("XWebUpdater", "needCheckUpdate, sPluginUpdater ret false");
            return false;
        }
    }
}
