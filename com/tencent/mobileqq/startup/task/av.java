package com.tencent.mobileqq.startup.task;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.perf.tool.CpuUtil;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqbattery.b;
import com.tencent.mobileqq.qqbattery.feature.AlarmMonitorFeature;
import com.tencent.mobileqq.qqbattery.feature.RegularMonitorFeature;
import com.tencent.mobileqq.qqbattery.feature.TrafficMonitorFeature;
import com.tencent.mobileqq.qqbattery.feature.WakeLockMonitorFeature;
import com.tencent.mobileqq.qqbattery.feature.d;
import com.tencent.mobileqq.qqbattery.utils.a;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.startup.task.NtTask;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class av extends NtTask {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements com.tencent.mobileqq.qqbattery.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) av.this);
            }
        }

        @Override // com.tencent.mobileqq.qqbattery.a
        public void a(com.tencent.mobileqq.qqbattery.h hVar) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) hVar);
                return;
            }
            if (new Random().nextInt(1000) != 1) {
                return;
            }
            HashMap hashMap = new HashMap();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getCurrentUin();
            } else {
                str = "";
            }
            hashMap.put("scene", hVar.d());
            hashMap.put("isForeground", String.valueOf(hVar.i()));
            hashMap.put("deviceStat", String.valueOf(hVar.c()));
            hashMap.put("temperature", String.valueOf(hVar.e()));
            hashMap.put("topCpuUsage", String.valueOf(hVar.f()));
            hashMap.put("powerPct", String.valueOf(hVar.b()));
            hashMap.put("alarmBgTracingCount", String.valueOf(hVar.a().f262273f));
            hashMap.put("alarmFgTracingCount", String.valueOf(hVar.a().f262272e));
            hashMap.put("mobileTxBytes", String.valueOf(hVar.g().f262292i));
            hashMap.put("mobileRxBytes", String.valueOf(hVar.g().f262291h));
            hashMap.put("totalWakeLockTime", String.valueOf(hVar.h().f262308d));
            hashMap.put("totalWakeLockCount", String.valueOf(hVar.h().f262309e));
            hashMap.put("process", MobileQQ.sMobileQQ.getQQProcessName());
            QQBeaconReport.report(str, "battery_regular_report", true, (Map<String, String>) hashMap, false);
        }

        @Override // com.tencent.mobileqq.qqbattery.a
        public void b(List<d.a.b> list, long j3) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, list, Long.valueOf(j3));
                return;
            }
            if (new Random().nextInt(10) != 1) {
                return;
            }
            HashMap hashMap = new HashMap();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getCurrentUin();
            } else {
                str = "";
            }
            hashMap.put("duringMillis", String.valueOf(j3));
            d.a.b bVar = list.get(0);
            hashMap.put("name", bVar.f262331d);
            hashMap.put("tid", String.valueOf(bVar.f262330c));
            hashMap.put("stack", bVar.f262334g);
            hashMap.put("jiffies", String.valueOf(bVar.b()));
            hashMap.put("stat", bVar.f262333f);
            hashMap.put("process", MobileQQ.sMobileQQ.getQQProcessName());
            QQBeaconReport.report(str, "battery_cpu_usage_warn", true, (Map<String, String>) hashMap, false);
        }

        @Override // com.tencent.mobileqq.qqbattery.a
        public void c(AlarmMonitorFeature.b bVar) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
                return;
            }
            HashMap hashMap = new HashMap();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getCurrentUin();
            } else {
                str = "";
            }
            hashMap.put("totalCount", String.valueOf(bVar.f262271d));
            hashMap.put("fgTracingCount", String.valueOf(bVar.f262272e));
            hashMap.put("bgTracingCount", String.valueOf(bVar.f262273f));
            hashMap.put("process", MobileQQ.sMobileQQ.getQQProcessName());
            QQBeaconReport.report(str, "battery_alarm_call", true, (Map<String, String>) hashMap, false);
        }

        @Override // com.tencent.mobileqq.qqbattery.a
        public void d(WakeLockMonitorFeature.b bVar) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
                return;
            }
            if (new Random().nextInt(10) != 1) {
                return;
            }
            HashMap hashMap = new HashMap();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getCurrentUin();
            } else {
                str = "";
            }
            hashMap.put("tag", bVar.f262303b);
            hashMap.put("packageName", bVar.f262304c);
            hashMap.put("stack", bVar.f262305d);
            hashMap.put("process", MobileQQ.sMobileQQ.getQQProcessName());
            QQBeaconReport.report(str, "battery_wakelock_not_release_on_bg", true, (Map<String, String>) hashMap, false);
        }

        @Override // com.tencent.mobileqq.qqbattery.a
        public void e(WakeLockMonitorFeature.b bVar) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
                return;
            }
            if (new Random().nextInt(10) != 1) {
                return;
            }
            HashMap hashMap = new HashMap();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getCurrentUin();
            } else {
                str = "";
            }
            hashMap.put("tag", bVar.f262303b);
            hashMap.put("packageName", bVar.f262304c);
            hashMap.put("stack", bVar.f262305d);
            hashMap.put("process", MobileQQ.sMobileQQ.getQQProcessName());
            QQBeaconReport.report(str, "battery_acquire_wakelock_on_bg", true, (Map<String, String>) hashMap, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements com.tencent.mobileqq.qqbattery.c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) av.this);
            }
        }

        @Override // com.tencent.mobileqq.qqbattery.c
        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return Foreground.isCurrentProcessForeground();
        }

        @Override // com.tencent.mobileqq.qqbattery.c
        public String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return SceneTracker.f();
        }

        @Override // com.tencent.mobileqq.qqbattery.c
        public float getCpuUsage() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Float) iPatchRedirector.redirect((short) 7, (Object) this)).floatValue();
            }
            return CpuUtil.f258160a.g(Process.myPid());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements a.InterfaceC8297a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) av.this);
            }
        }

        @Override // com.tencent.mobileqq.qqbattery.utils.a.InterfaceC8297a
        public void d(String str, String str2, Object... objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, str, str2, objArr);
                return;
            }
            if (objArr != null && objArr.length != 0) {
                str2 = String.format(str2, objArr);
            }
            QLog.d(str, 1, str2);
        }

        @Override // com.tencent.mobileqq.qqbattery.utils.a.InterfaceC8297a
        public void e(String str, String str2, Object... objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, str, str2, objArr);
                return;
            }
            if (objArr != null && objArr.length != 0) {
                str2 = String.format(str2, objArr);
            }
            QLog.e(str, 1, str2);
        }

        @Override // com.tencent.mobileqq.qqbattery.utils.a.InterfaceC8297a
        public void i(String str, String str2, Object... objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, str2, objArr);
                return;
            }
            if (objArr != null && objArr.length != 0) {
                str2 = String.format(str2, objArr);
            }
            QLog.i(str, 1, str2);
        }

        @Override // com.tencent.mobileqq.qqbattery.utils.a.InterfaceC8297a
        public void printErrStackTrace(String str, Throwable th5, String str2, Object... objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, str, th5, str2, objArr);
                return;
            }
            if (objArr != null && objArr.length != 0) {
                str2 = String.format(str2, objArr);
            }
            if (str2 == null) {
                str2 = "";
            }
            QLog.e(str, 1, str2 + "  " + Log.getStackTraceString(th5));
        }

        @Override // com.tencent.mobileqq.qqbattery.utils.a.InterfaceC8297a
        public void w(String str, String str2, Object... objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, str, str2, objArr);
                return;
            }
            if (objArr != null && objArr.length != 0) {
                str2 = String.format(str2, objArr);
            }
            QLog.w(str, 1, str2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class d implements IGuardInterface {
        static IPatchRedirector $redirector_;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else if (com.tencent.mobileqq.qqbattery.f.d()) {
                com.tencent.mobileqq.qqbattery.f.g().a().a(false);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (com.tencent.mobileqq.qqbattery.f.d()) {
                com.tencent.mobileqq.qqbattery.f.g().a().a(true);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, j3);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, j3);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onLiteTimeTick(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, j3);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
            }
        }
    }

    public av() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private com.tencent.mobileqq.qqbattery.a a() {
        return new a();
    }

    private com.tencent.mobileqq.qqbattery.c b() {
        return new b();
    }

    private void c() {
        com.tencent.mobileqq.qqbattery.f.e(new c());
    }

    private void d() {
        com.tencent.mobileqq.qqbattery.f.c(MobileQQ.sMobileQQ, new com.tencent.mobileqq.qqbattery.g(new b.a().c(WakeLockMonitorFeature.class).c(AlarmMonitorFeature.class).d(false).a(true).b(), a(), b()));
        com.tencent.mobileqq.qqbattery.f.g().f();
    }

    private void e() {
        com.tencent.mobileqq.qqbattery.b b16 = new b.a().c(TrafficMonitorFeature.class).c(com.tencent.mobileqq.qqbattery.feature.d.class).c(WakeLockMonitorFeature.class).c(AlarmMonitorFeature.class).c(RegularMonitorFeature.class).a(true).b();
        GuardManagerCallbackDispatcher.registerCallBack(new d());
        com.tencent.mobileqq.qqbattery.f.c(MobileQQ.sMobileQQ, new com.tencent.mobileqq.qqbattery.g(b16, a(), b()));
        com.tencent.mobileqq.qqbattery.f.g().f();
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NonNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        if (Build.VERSION.SDK_INT < 24 || !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101365", false)) {
            return;
        }
        c();
        int i3 = MobileQQ.sProcessId;
        if (i3 == 1) {
            e();
        } else if (i3 == 4) {
            d();
        }
    }
}
