package com.tencent.mobileqq.upgrade;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.upgrade.NewUpgradeConfig;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import protocol.KQQConfig.UpgradeInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0002H\u0007J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0007J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/upgrade/n;", "", "", "i", "j", "Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;", "wrapper", "", "k", "", "redDotTimestamp", tl.h.F, "a", "isInstall", "l", "c", "b", "e", "g", "d", "f", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class n {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n f306316a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63087);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f306316a = new n();
        }
    }

    n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(@NotNull UpgradeDetailWrapper wrapper) {
        Intrinsics.checkNotNullParameter(wrapper, "wrapper");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        BaseApplication baseApplication = BaseApplication.context;
        String currentUin = peekAppRuntime.getCurrentUin();
        if (ea.L1(baseApplication, currentUin) != wrapper.f306171e.iUpgradeSdkId) {
            ea.I2(baseApplication, currentUin, 0);
            ea.J2(baseApplication, currentUin, 0L);
            ea.R2(baseApplication, currentUin, 0);
            ea.S2(baseApplication, currentUin, 0L);
            ea.q3(baseApplication, currentUin, wrapper.f306171e.iUpgradeSdkId);
        }
    }

    @JvmStatic
    public static final boolean b(@Nullable UpgradeDetailWrapper wrapper) {
        UpgradeInfo upgradeInfo;
        AppRuntime peekAppRuntime;
        long S;
        int i3;
        NewUpgradeConfig.a aVar = null;
        if (wrapper != null) {
            upgradeInfo = wrapper.f306170d;
        } else {
            upgradeInfo = null;
        }
        if (upgradeInfo == null) {
            return false;
        }
        NewUpgradeConfig newUpgradeConfig = wrapper.f306174i;
        if (newUpgradeConfig != null) {
            aVar = newUpgradeConfig.dialog;
        }
        if (aVar == null || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return false;
        }
        boolean e16 = f306316a.e();
        if (e16) {
            S = ea.m0(BaseApplication.context, peekAppRuntime.getCurrentUin());
        } else {
            S = ea.S(BaseApplication.context, peekAppRuntime.getCurrentUin());
        }
        if (e16) {
            i3 = wrapper.f306174i.dialog.f306168t;
        } else {
            i3 = wrapper.f306174i.dialog.f306166r;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeController_Manager", 2, "checkDialogShownTimestamp, isInstall: " + e16 + ", dayRate: " + i3 + ", shownTimestamp: " + S + ", now: " + currentTimeMillis);
        }
        if (currentTimeMillis - S <= i3 * 86400000) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean c(@Nullable UpgradeDetailWrapper wrapper) {
        UpgradeInfo upgradeInfo;
        AppRuntime peekAppRuntime;
        int R;
        int i3;
        NewUpgradeConfig.a aVar = null;
        if (wrapper != null) {
            upgradeInfo = wrapper.f306170d;
        } else {
            upgradeInfo = null;
        }
        if (upgradeInfo == null) {
            return false;
        }
        NewUpgradeConfig newUpgradeConfig = wrapper.f306174i;
        if (newUpgradeConfig != null) {
            aVar = newUpgradeConfig.dialog;
        }
        if (aVar == null || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return false;
        }
        boolean e16 = f306316a.e();
        if (e16) {
            R = ea.l0(BaseApplication.context, peekAppRuntime.getCurrentUin());
        } else {
            R = ea.R(BaseApplication.context, peekAppRuntime.getCurrentUin());
        }
        if (e16) {
            i3 = wrapper.f306174i.dialog.f306167s;
        } else {
            i3 = wrapper.f306174i.dialog.f306165q;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeController_Manager", 2, "checkDialogShownTimes, isInstall: " + e16 + ", maxTimes: " + i3 + ", shownTimes: " + R);
        }
        if (R >= i3) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean d(int redDotTimestamp) {
        boolean z16;
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        int i3 = fromV2.getInt("NEW_ICON_TIMESTAMP_IGNORE", -1);
        if (i3 == redDotTimestamp) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("UpgradeController_Manager", 1, "hasDelayRemindClicked, " + z16);
        if (i3 != redDotTimestamp) {
            return false;
        }
        return true;
    }

    private final boolean e() {
        int k3 = k.i().k();
        if (QLog.isColorLevel() && k3 != 4) {
            QLog.d("UpgradeController_Manager", 2, "hasNewApkDownloaded, downloadState: " + k3);
        }
        if (k3 == 4) {
            return true;
        }
        return false;
    }

    private final boolean f(int redDotTimestamp) {
        boolean z16;
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        int i3 = fromV2.getInt("NEW_ICON_TIMESTAMP", -1);
        if (i3 == redDotTimestamp) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("UpgradeController_Manager", 1, "hasNewRedDotClicked, " + z16);
        if (i3 != redDotTimestamp) {
            return false;
        }
        return true;
    }

    private final void g(int redDotTimestamp) {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        fromV2.putInt("NEW_ICON_TIMESTAMP_IGNORE", redDotTimestamp);
        QLog.d("UpgradeController_Manager", 1, "markDelayRemindClicked, " + redDotTimestamp);
    }

    @JvmStatic
    public static final void h(int redDotTimestamp) {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        fromV2.putInt("NEW_ICON_TIMESTAMP", redDotTimestamp);
        QLog.d("UpgradeController_Manager", 1, "markNewRedDotClicked, " + redDotTimestamp);
    }

    @JvmStatic
    public static final boolean i() {
        UpgradeInfo upgradeInfo;
        UpgradeDetailWrapper j3 = k.i().j();
        if (j3 != null) {
            upgradeInfo = j3.f306170d;
        } else {
            upgradeInfo = null;
        }
        if (upgradeInfo == null || !j() || f306316a.f(j3.f306170d.iNewTimeStamp)) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean j() {
        UpgradeInfo upgradeInfo;
        UpgradeDetailWrapper j3 = k.i().j();
        if (j3 != null) {
            upgradeInfo = j3.f306170d;
        } else {
            upgradeInfo = null;
        }
        if (upgradeInfo == null) {
            return false;
        }
        UpgradeInfo upgradeInfo2 = j3.f306170d;
        if (upgradeInfo2.iUpgradeType <= 0 || upgradeInfo2.bNewSwitch != 1 || d(upgradeInfo2.iNewTimeStamp)) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final void k(@NotNull UpgradeDetailWrapper wrapper) {
        NewUpgradeConfig newUpgradeConfig;
        NewUpgradeConfig.a aVar;
        Intrinsics.checkNotNullParameter(wrapper, "wrapper");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (newUpgradeConfig = wrapper.f306174i) != null && (aVar = newUpgradeConfig.dialog) != null) {
            int i3 = aVar.f306167s;
            int i16 = wrapper.f306174i.dialog.f306165q;
            ea.R2(BaseApplication.context, peekAppRuntime.getCurrentUin(), i3);
            ea.I2(BaseApplication.context, peekAppRuntime.getCurrentUin(), i16);
            UpgradeInfo upgradeInfo = wrapper.f306170d;
            if (upgradeInfo != null && upgradeInfo.iUpgradeType > 0) {
                h(upgradeInfo.iNewTimeStamp);
                f306316a.g(wrapper.f306170d.iNewTimeStamp);
            }
        }
    }

    @JvmStatic
    public static final void l(boolean isInstall) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        if (isInstall) {
            ea.R2(BaseApplication.context, peekAppRuntime.getCurrentUin(), ea.l0(BaseApplication.context, peekAppRuntime.getCurrentUin()) + 1);
            ea.S2(BaseApplication.context, peekAppRuntime.getCurrentUin(), System.currentTimeMillis());
        } else {
            ea.I2(BaseApplication.context, peekAppRuntime.getCurrentUin(), ea.R(BaseApplication.context, peekAppRuntime.getCurrentUin()) + 1);
            ea.J2(BaseApplication.context, peekAppRuntime.getCurrentUin(), System.currentTimeMillis());
        }
    }
}
