package com.tencent.mobileqq.login.restart;

import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/login/restart/c;", "", "Lcom/tencent/mobileqq/login/restart/Scene;", "scene", "", "d", "Lcom/tencent/mobileqq/login/restart/b;", DownloadInfo.spKey_Config, "e", "a", "c", "", "b", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f242621a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23410);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f242621a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final boolean d(@NotNull Scene scene) {
        boolean z16;
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullExpressionValue(QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations"), "from(MobileQQ.getContext(), QMMKVFile.FILE_COMMON)");
        QRouteApi api = QRoute.api(IUnitedConfigManager.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IUnitedConfigManager::class.java)");
        if (!((IUnitedConfigManager) api).isSwitchOn("switch_logout_account_restart_process", false)) {
            QLog.i("LoginProcessRestartConfig", 1, "[disable] switch is off");
            return false;
        }
        c cVar = f242621a;
        b a16 = cVar.a();
        if (QLog.isColorLevel()) {
            QLog.i("LoginProcessRestartConfig", 2, "config: " + a16);
        }
        if (!cVar.c()) {
            QLog.i("LoginProcessRestartConfig", 1, "[disable] device enable false");
            return false;
        }
        if (cVar.e(a16)) {
            QLog.i("LoginProcessRestartConfig", 1, "[disable] launch slow");
            return false;
        }
        if (Scene.SWITCH_ACCOUNT == scene) {
            z16 = a16.g().contains("switchAccount");
        } else if (Scene.LOGOUT == scene) {
            z16 = a16.g().contains("logout");
        } else {
            z16 = false;
        }
        if (!z16) {
            QLog.i("LoginProcessRestartConfig", 1, "[disable] scene: " + scene);
            return false;
        }
        if (LoginProcessRestartMonitor.f242582a.s()) {
            QLog.i("LoginProcessRestartConfig", 1, "[disable] local downgrade");
            return false;
        }
        com.tencent.mobileqq.perf.memory.collect.a a17 = com.tencent.mobileqq.perf.memory.collect.a.INSTANCE.a();
        int i3 = a17.c().i();
        float e16 = a17.a().e();
        if (i3 / 1024 < a16.k() && 100 * e16 < a16.e()) {
            QLog.i("LoginProcessRestartConfig", 1, "[disable] totalPss:" + i3 + " javaUsedRatio:" + e16);
            return false;
        }
        QLog.i("LoginProcessRestartConfig", 1, "[enable]");
        return true;
    }

    private final boolean e(b config) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19 = false;
        if (com.tencent.mobileqq.startup.a.f289673n >= config.i()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!com.tencent.mobileqq.startup.a.f289670k && com.tencent.mobileqq.startup.a.f289674o >= config.h()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (com.tencent.mobileqq.startup.a.f289670k && com.tencent.mobileqq.startup.a.f289675p >= config.j()) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z16 || z17 || z18) {
            z19 = true;
        }
        if (z19) {
            QLog.i("LoginProcessRestartConfig", 1, "[launch slow] sysLaunchCost:" + com.tencent.mobileqq.startup.a.f289673n + " isBackgroundCreate:" + com.tencent.mobileqq.startup.a.f289670k + " coldStartCost:" + com.tencent.mobileqq.startup.a.f289674o + " warmStartCost=" + com.tencent.mobileqq.startup.a.f289675p);
        }
        return z19;
    }

    @NotNull
    public final b a() {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        QRouteApi api = QRoute.api(IUnitedConfigManager.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IUnitedConfigManager::class.java)");
        IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) api;
        if (iUnitedConfigManager.isSwitchOn("switch_account_restart_process", false)) {
            bVar = (b) iUnitedConfigManager.loadConfig("switch_account_restart_process");
        } else {
            bVar = null;
        }
        if (bVar == null) {
            return new b(null, null, 0, 0, 0, 0, false, false, 0, 0, 0, 0, 4095, null);
        }
        return bVar;
    }

    public final int b() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.getContext(), QMMKVFile.FILE_COMMON)");
        int decodeInt = from.decodeInt("login_device_perf_level", 0);
        if (decodeInt > 0) {
            return decodeInt;
        }
        int n3 = ah.n();
        long c16 = com.tencent.mobileqq.utils.m.c();
        if (n3 >= 8 && c16 >= 7516192768L) {
            i3 = 1;
        } else if (n3 > 6 && c16 > 4294967296L) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        from.encodeInt("login_device_perf_level", i3);
        return i3;
    }

    public final boolean c() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        b a16 = a();
        int b16 = b();
        boolean contains = a16.b().contains(Integer.valueOf(b16));
        int i3 = Build.VERSION.SDK_INT;
        boolean z17 = false;
        if (i3 >= a16.a()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (contains && z16) {
            z17 = true;
        }
        if (!z17) {
            QLog.i("LoginProcessRestartConfig", 1, "[device disable] perfLevel:" + b16 + " androidVersion=" + i3);
        }
        return z17;
    }
}
