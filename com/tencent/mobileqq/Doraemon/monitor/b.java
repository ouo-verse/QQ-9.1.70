package com.tencent.mobileqq.Doraemon.monitor;

import android.content.Intent;
import android.util.LruCache;
import com.tencent.mobileqq.Doraemon.monitor.a;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b implements a.InterfaceC7087a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static b f154265d;

    /* renamed from: a, reason: collision with root package name */
    a f154266a;

    /* renamed from: b, reason: collision with root package name */
    LruCache<String, Map<String, APIQuotaItem>> f154267b;

    /* renamed from: c, reason: collision with root package name */
    Map<String, Boolean> f154268c;

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f154268c = new ConcurrentHashMap();
        this.f154267b = new LruCache<>(5);
        if (MobileQQ.sProcessId == 1) {
            if (QLog.isColorLevel()) {
                QLog.d("DoraemonOpenAPI.freqCtrl", 2, "create reporter");
            }
            this.f154266a = new DoraemonAPIReporterMain();
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("DoraemonOpenAPI.freqCtrl", 2, "create reporter proxy");
            }
            this.f154266a = new DoraemonAPIReporterProxy();
        }
        this.f154266a.a(this);
    }

    public static b c() {
        if (f154265d == null) {
            synchronized (b.class) {
                if (f154265d == null) {
                    f154265d = new b();
                }
            }
        }
        return f154265d;
    }

    private Map<String, APIQuotaItem> f(String str, int i3, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("DoraemonOpenAPI.freqCtrl", 2, "init key=" + str);
        }
        Map<String, APIQuotaItem> map = this.f154267b.get(str);
        boolean z16 = false;
        if (map == null) {
            synchronized (this) {
                map = this.f154267b.get(str);
                if (map == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("DoraemonOpenAPI.freqCtrl", 2, "init create cache map, key=" + str);
                    }
                    map = new ConcurrentHashMap<>();
                    this.f154267b.put(str, map);
                    z16 = true;
                }
            }
        }
        if (z16) {
            this.f154266a.b(str, i3, str2);
        }
        return map;
    }

    @Override // com.tencent.mobileqq.Doraemon.monitor.a.InterfaceC7087a
    public void a(String str, int i3, String str2, String str3, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), str2, str3, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        QLog.d("DoraemonOpenAPI.freqCtrl", 1, "update key=" + str + ", api=" + str3 + ", remain=" + j3);
        Map<String, APIQuotaItem> map = this.f154267b.get(str);
        if (map != null) {
            APIQuotaItem aPIQuotaItem = map.get(str3);
            if (aPIQuotaItem == null) {
                APIQuotaItem aPIQuotaItem2 = new APIQuotaItem();
                aPIQuotaItem2.remainTimes = j3;
                aPIQuotaItem2.expireTimeMillis = j16;
                map.put(str3, aPIQuotaItem2);
            } else {
                aPIQuotaItem.remainTimes = j3;
                aPIQuotaItem.expireTimeMillis = j16;
            }
        }
        if (MobileQQ.sProcessId == 1 && this.f154268c.containsKey(str)) {
            Intent intent = new Intent("com.tencent.mobileqq.Doraemon.monitor.update");
            intent.putExtra("key", str);
            intent.putExtra("type", i3);
            intent.putExtra("appid", str2);
            intent.putExtra(DTConstants.TAG.API, str3);
            intent.putExtra("remain", j3);
            intent.putExtra("time", j16);
            BaseApplication.getContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
        }
    }

    @Override // com.tencent.mobileqq.Doraemon.monitor.a.InterfaceC7087a
    public void b(String str, HashMap<String, APIQuotaItem> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) hashMap);
            return;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.d("DoraemonOpenAPI.freqCtrl", 2, "update all key=" + str);
            }
            Map<String, APIQuotaItem> map = this.f154267b.get(str);
            if (map != null) {
                map.putAll(hashMap);
            }
            if (MobileQQ.sProcessId == 1 && this.f154268c.containsKey(str)) {
                Intent intent = new Intent("com.tencent.mobileqq.Doraemon.monitor.update_batch");
                intent.putExtra("key", str);
                intent.putExtra("map", hashMap);
                BaseApplication.getContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
            }
        } catch (Exception e16) {
            QLog.e("DoraemonOpenAPI.freqCtrl", 1, "onUpdateBatch error, key=" + str, e16);
        }
    }

    public boolean d(String str, int i3, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), str2, str3)).booleanValue();
        }
        Map<String, APIQuotaItem> map = this.f154267b.get(str);
        if (map == null) {
            map = f(str, i3, str2);
        }
        APIQuotaItem aPIQuotaItem = map.get(str3);
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        if (aPIQuotaItem == null) {
            if (QLog.isColorLevel()) {
                QLog.d("DoraemonOpenAPI.freqCtrl", 2, "no record use default key=" + str + ", api=" + str3);
            }
            APIQuotaItem aPIQuotaItem2 = new APIQuotaItem();
            aPIQuotaItem2.remainTimes = 10L;
            aPIQuotaItem2.expireTimeMillis = serverTimeMillis + 60000;
            map.put(str3, aPIQuotaItem2);
            return true;
        }
        if (aPIQuotaItem.remainTimes > 0) {
            if (QLog.isColorLevel()) {
                QLog.d("DoraemonOpenAPI.freqCtrl", 2, "has quota key=" + str + ", api=" + str3 + ", remain=" + aPIQuotaItem.remainTimes);
            }
            return true;
        }
        if (aPIQuotaItem.expireTimeMillis < serverTimeMillis) {
            if (QLog.isColorLevel()) {
                QLog.d("DoraemonOpenAPI.freqCtrl", 2, "expired use default key=" + str + ", api=" + str3);
            }
            aPIQuotaItem.remainTimes = 10L;
            aPIQuotaItem.expireTimeMillis = serverTimeMillis + 60000;
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DoraemonOpenAPI.freqCtrl", 2, "no quota key=" + str + ", api=" + str3);
        }
        return false;
    }

    public void e(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), str2);
        } else {
            f(str, i3, str2);
        }
    }

    public void g(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), str2);
            return;
        }
        if (MobileQQ.sProcessId != 1) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DoraemonOpenAPI.freqCtrl", 2, "load from proxy key=" + str);
        }
        this.f154268c.put(str, Boolean.TRUE);
        this.f154266a.b(str, i3, str2);
    }

    public void h(String str, int i3, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), str2, str3);
            return;
        }
        QLog.d("DoraemonOpenAPI.freqCtrl", 1, "report key=" + str + ", api=" + str3);
        this.f154266a.c(str, i3, str2, str3);
    }

    public void i(String str, int i3, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), str2, str3);
            return;
        }
        if (MobileQQ.sProcessId != 1) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DoraemonOpenAPI.freqCtrl", 2, "report from proxy key=" + str + ", api=" + str3);
        }
        this.f154268c.put(str, Boolean.TRUE);
        this.f154266a.c(str, i3, str2, str3);
    }
}
