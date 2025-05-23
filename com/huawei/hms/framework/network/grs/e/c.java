package com.huawei.hms.framework.network.grs.e;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private static final String f36947b = "c";

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, PLSharedPreferences> f36948c = new ConcurrentHashMap(16);

    /* renamed from: a, reason: collision with root package name */
    private final PLSharedPreferences f36949a;

    public c(Context context, String str) {
        String packageName = context.getPackageName();
        Logger.d(f36947b, "get pkgname from context is{%s}", packageName);
        Map<String, PLSharedPreferences> map = f36948c;
        if (map.containsKey(str + packageName)) {
            this.f36949a = map.get(str + packageName);
        } else {
            PLSharedPreferences pLSharedPreferences = new PLSharedPreferences(context, str + packageName);
            this.f36949a = pLSharedPreferences;
            map.put(str + packageName, pLSharedPreferences);
        }
        a(context);
    }

    public String a(String str, String str2) {
        String string;
        PLSharedPreferences pLSharedPreferences = this.f36949a;
        if (pLSharedPreferences == null) {
            return str2;
        }
        synchronized (pLSharedPreferences) {
            string = this.f36949a.getString(str, str2);
        }
        return string;
    }

    public void b() {
        PLSharedPreferences pLSharedPreferences = this.f36949a;
        if (pLSharedPreferences == null) {
            return;
        }
        synchronized (pLSharedPreferences) {
            this.f36949a.clear();
        }
    }

    public Map<String, ?> a() {
        Map<String, ?> all;
        PLSharedPreferences pLSharedPreferences = this.f36949a;
        if (pLSharedPreferences == null) {
            return new HashMap();
        }
        synchronized (pLSharedPreferences) {
            all = this.f36949a.getAll();
        }
        return all;
    }

    public void b(String str, String str2) {
        PLSharedPreferences pLSharedPreferences = this.f36949a;
        if (pLSharedPreferences == null) {
            return;
        }
        synchronized (pLSharedPreferences) {
            this.f36949a.putString(str, str2);
        }
    }

    private void a(Context context) {
        String str = f36947b;
        Logger.i(str, "ContextHolder.getAppContext() from GRS is:" + ContextHolder.getAppContext());
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        try {
            String l3 = Long.toString(InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 16384).versionCode);
            String a16 = a("version", "");
            if (l3.equals(a16)) {
                return;
            }
            Logger.i(str, "app version changed! old version{%s} and new version{%s}", a16, l3);
            b();
            b("version", l3);
        } catch (PackageManager.NameNotFoundException unused) {
            Logger.w(f36947b, "get app version failed and catch NameNotFoundException");
        }
    }

    public void a(String str) {
        PLSharedPreferences pLSharedPreferences = this.f36949a;
        if (pLSharedPreferences == null) {
            return;
        }
        synchronized (pLSharedPreferences) {
            this.f36949a.remove(str);
        }
    }
}
