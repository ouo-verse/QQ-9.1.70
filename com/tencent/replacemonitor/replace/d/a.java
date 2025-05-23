package com.tencent.replacemonitor.replace.d;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.replacemonitor.MonitorStep;
import com.tencent.replacemonitor.MonitorTask;
import com.tencent.replacemonitor.replace.ReplaceMonitor;
import com.tencent.tmassistantbase.util.j;
import com.tencent.tmassistantbase.util.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static a f364896d;

    /* renamed from: a, reason: collision with root package name */
    private Map<Long, MonitorTask> f364897a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, MonitorTask> f364898b;

    /* renamed from: c, reason: collision with root package name */
    private b f364899c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11717);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f364897a = new ConcurrentHashMap();
        this.f364898b = new ConcurrentHashMap();
        b bVar = new b();
        this.f364899c = bVar;
        ArrayList<MonitorTask> e16 = bVar.e();
        if (!com.tencent.tmassistantbase.util.b.a(e16)) {
            for (MonitorTask monitorTask : e16) {
                if (monitorTask.lastStep == MonitorStep.INSTALLING) {
                    PackageInfo b16 = j.b(monitorTask.packageName);
                    if (b16 != null && b16.versionCode == monitorTask.versionCode && System.currentTimeMillis() - b16.lastUpdateTime > 86400000) {
                        r.b(ReplaceMonitor.WASH_TAG, "MonitorTaskCache>>MonitorTaskCache \u53d1\u73b0\u8d85\u8fc724\u5c0f\u65f6\u810f\u6570\u636e\uff0c\u5220\u9664 task.packageName = " + monitorTask.packageName);
                        this.f364899c.a(monitorTask);
                    } else {
                        r.b(ReplaceMonitor.WASH_TAG, "MonitorTaskCache>>MonitorTaskCache \u8865\u5145\u6267\u884c\u4e00\u6b21\u5b89\u88c5\u540e\u68c0\u6d4b task.packageName = " + monitorTask.packageName);
                        ReplaceMonitor.get().execSync(monitorTask, MonitorStep.AFTER_INSTALL);
                    }
                }
                this.f364897a.put(Long.valueOf(monitorTask.f364885id), monitorTask);
                if (!TextUtils.isEmpty(monitorTask.additionalId)) {
                    this.f364898b.put(monitorTask.additionalId, monitorTask);
                }
            }
        }
    }

    public static synchronized a c() {
        a aVar;
        synchronized (a.class) {
            if (f364896d == null) {
                f364896d = new a();
            }
            aVar = f364896d;
        }
        return aVar;
    }

    public synchronized MonitorTask a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MonitorTask) iPatchRedirector.redirect((short) 4, (Object) this, j3);
        }
        MonitorTask monitorTask = this.f364897a.get(Long.valueOf(j3));
        if (monitorTask == null && (monitorTask = this.f364899c.b(j3)) != null) {
            this.f364897a.put(Long.valueOf(j3), monitorTask);
        }
        return monitorTask;
    }

    public synchronized MonitorTask b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MonitorTask) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        MonitorTask monitorTask = this.f364898b.get(str);
        if (monitorTask == null && (monitorTask = this.f364899c.d(str)) != null) {
            this.f364898b.put(str, monitorTask);
            this.f364897a.put(Long.valueOf(monitorTask.f364885id), monitorTask);
        }
        return monitorTask;
    }

    public synchronized List<MonitorTask> d(String str, int i3) {
        ArrayList<MonitorTask> e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, i3);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MonitorTask monitorTask : this.f364897a.values()) {
            if (str.equals(monitorTask.packageName) && i3 == monitorTask.versionCode) {
                arrayList.add(monitorTask);
            }
        }
        if (com.tencent.tmassistantbase.util.b.a(arrayList)) {
            for (MonitorTask monitorTask2 : this.f364898b.values()) {
                if (str.equals(monitorTask2.packageName) && i3 == monitorTask2.versionCode) {
                    arrayList.add(monitorTask2);
                }
            }
        }
        if (com.tencent.tmassistantbase.util.b.a(arrayList) && (e16 = this.f364899c.e()) != null) {
            for (MonitorTask monitorTask3 : e16) {
                if (str.equals(monitorTask3.packageName) && i3 == monitorTask3.versionCode) {
                    arrayList.add(monitorTask3);
                }
            }
        }
        return arrayList;
    }

    public synchronized void e(MonitorTask monitorTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) monitorTask);
        } else {
            if (monitorTask == null) {
                return;
            }
            this.f364897a.remove(Long.valueOf(monitorTask.f364885id));
            this.f364898b.remove(monitorTask.additionalId);
            this.f364899c.a(monitorTask);
        }
    }

    public synchronized long f(MonitorTask monitorTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this, (Object) monitorTask)).longValue();
        }
        long j3 = monitorTask.f364885id;
        if (j3 == 0) {
            long f16 = this.f364899c.f(monitorTask);
            monitorTask.f364885id = f16;
            if (f16 != -1) {
                this.f364897a.put(Long.valueOf(f16), monitorTask);
                if (!TextUtils.isEmpty(monitorTask.additionalId)) {
                    this.f364898b.put(monitorTask.additionalId, monitorTask);
                }
            }
        } else {
            this.f364897a.put(Long.valueOf(j3), monitorTask);
            this.f364899c.i(monitorTask);
            if (!TextUtils.isEmpty(monitorTask.additionalId)) {
                this.f364898b.put(monitorTask.additionalId, monitorTask);
            }
        }
        return monitorTask.f364885id;
    }

    public synchronized List<MonitorTask> g(String str) {
        ArrayList<MonitorTask> e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MonitorTask monitorTask : this.f364897a.values()) {
            if (str.equals(monitorTask.appName)) {
                arrayList.add(monitorTask);
            }
        }
        if (com.tencent.tmassistantbase.util.b.a(arrayList)) {
            for (MonitorTask monitorTask2 : this.f364898b.values()) {
                if (str.equals(monitorTask2.appName)) {
                    arrayList.add(monitorTask2);
                }
            }
        }
        if (com.tencent.tmassistantbase.util.b.a(arrayList) && (e16 = this.f364899c.e()) != null) {
            for (MonitorTask monitorTask3 : e16) {
                if (str.equals(monitorTask3.appName)) {
                    arrayList.add(monitorTask3);
                }
            }
        }
        return arrayList;
    }
}
