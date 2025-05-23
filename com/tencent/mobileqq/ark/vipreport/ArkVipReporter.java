package com.tencent.mobileqq.ark.vipreport;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import d91.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkVipReporter {

    /* renamed from: d, reason: collision with root package name */
    static boolean f199658d = true;

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, d> f199660a = new HashMap<>(2);

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<String, b> f199661b = new HashMap<>(2);

    /* renamed from: c, reason: collision with root package name */
    private static final Object f199657c = new Object();

    /* renamed from: e, reason: collision with root package name */
    static ArkVipReporter f199659e = new ArkVipReporter();

    public static ArkVipReporter d() {
        return f199659e;
    }

    public void c(String str, boolean z16, long j3, HashMap<String, String> hashMap) {
        if (!i(str)) {
            return;
        }
        synchronized (f199657c) {
            d e16 = e(str);
            if (e16 != null) {
                b bVar = this.f199661b.get(e16.f199684a);
                if (bVar == null) {
                    return;
                }
                a aVar = new a();
                aVar.f199664a = str;
                aVar.f199665b = bVar.f199682k.size();
                aVar.f199666c = z16;
                long currentTimeMillis = System.currentTimeMillis();
                aVar.f199668e = currentTimeMillis;
                aVar.f199669f = j3;
                aVar.f199667d = currentTimeMillis - j3;
                aVar.f199670g = NetworkUtil.getNetworkType(null);
                aVar.f199671h = hashMap;
                bVar.f199682k.add(aVar);
                QLog.d("ArkVipReporter", 1, "addEventToScene() evt:", str, ", cost time=", Long.valueOf(j3));
                if (str.equals(e16.f199686c)) {
                    h(e16.f199684a);
                }
            }
        }
    }

    d e(String str) {
        Iterator<Map.Entry<String, d>> it = this.f199660a.entrySet().iterator();
        while (it.hasNext()) {
            d value = it.next().getValue();
            Set<String> set = value.f199688e;
            if (set != null && set.contains(str)) {
                return value;
            }
        }
        return null;
    }

    public void f(String str, d dVar) {
        boolean g16 = g();
        f199658d = g16;
        if (g16 && !TextUtils.isEmpty(str) && !this.f199660a.containsKey(str)) {
            this.f199660a.put(str, dVar);
        }
        QLog.d("ArkVipReporter", 1, "initScene() sceneName=", str, ", enable =", Boolean.valueOf(f199658d));
    }

    boolean g() {
        g arkPlatformConfig = ((IArkConfig) QRoute.api(IArkConfig.class)).getArkPlatformConfig();
        if (arkPlatformConfig != null && arkPlatformConfig.c() != null) {
            return arkPlatformConfig.c().c();
        }
        return true;
    }

    void h(String str) {
        b remove;
        synchronized (f199657c) {
            remove = this.f199661b.remove(str);
        }
        if (remove != null) {
            long currentTimeMillis = System.currentTimeMillis();
            remove.f199680i = currentTimeMillis;
            remove.f199681j = currentTimeMillis - remove.f199679h;
            String jSONObject = remove.a().toString();
            QLog.d("ArkVipReporter", 1, "report() sceneName:", str, ",total cost time=", Long.valueOf(remove.f199681j));
            c.d(jSONObject);
        }
    }

    boolean i(String str) {
        if (f199658d && Utils.K() && !TextUtils.isEmpty(str)) {
            return true;
        }
        return false;
    }

    public void j(String str, long j3) {
        String account;
        if (!i(str)) {
            return;
        }
        synchronized (f199657c) {
            final d e16 = e(str);
            if (e16 != null && str.equals(e16.f199685b)) {
                final String str2 = e16.f199684a;
                if (this.f199661b.containsKey(str2)) {
                    h(str2);
                }
                b bVar = new b();
                AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
                if (waitAppRuntime.getAccount() == null) {
                    account = "";
                } else {
                    account = waitAppRuntime.getAccount();
                }
                bVar.f199672a = account;
                bVar.f199673b = Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel();
                bVar.f199674c = "android";
                bVar.f199675d = AppSetting.f99551k + "_" + AppSetting.f99542b;
                bVar.f199676e = str2;
                bVar.f199677f = e16.f199685b;
                bVar.f199678g = e16.f199686c;
                bVar.f199679h = j3;
                bVar.f199682k = new ArrayList<>(8);
                this.f199661b.put(str2, bVar);
                QLog.d("ArkVipReporter", 1, "startSceneByEvent() sceneName=", str2, ",evt =", str);
                ArkDispatchTask.getInstance().postToArkThreadDelay(new Runnable() { // from class: com.tencent.mobileqq.ark.vipreport.ArkVipReporter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (ArkVipReporter.f199657c) {
                            b bVar2 = (b) ArkVipReporter.this.f199661b.get(str2);
                            if (bVar2 != null && Math.abs(System.currentTimeMillis() - bVar2.f199679h) >= e16.f199687d) {
                                QLog.i("ArkVipReporter", 1, "startSceneByEvent() find timeout scene and report:" + str2);
                                ArkVipReporter.this.h(str2);
                            }
                        }
                    }
                }, e16.f199687d);
            }
        }
    }
}
