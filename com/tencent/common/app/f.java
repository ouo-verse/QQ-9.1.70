package com.tencent.common.app;

import android.content.Context;
import android.os.HandlerThread;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.mobileqq.msf.MSFStartupDirector;
import com.tencent.mobileqq.msf.core.startup.MSFStartupListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.MSFInterfaceAdapter;
import com.tencent.qqperf.safemode.SafeModeClearHelper;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f extends MSFInterfaceAdapter {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qphone.base.util.MSFInterfaceAdapter
    public void addHandlerThreadMonitor(int i3, HandlerThread handlerThread) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3, (Object) handlerThread);
        } else {
            com.tencent.mobileqq.perf.thread.a.b(i3, handlerThread);
        }
    }

    @Override // com.tencent.qphone.base.util.MSFInterfaceAdapter
    public void beaconReport(String str, String str2, String str3, boolean z16, Map<String, String> map, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            QQBeaconReport.reportWithAppKey(str, str2, str3, z16, map, z17);
        } else {
            iPatchRedirector.redirect((short) 9, this, str, str2, str3, Boolean.valueOf(z16), map, Boolean.valueOf(z17));
        }
    }

    @Override // com.tencent.qphone.base.util.MSFInterfaceAdapter
    public boolean clearConfigData(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), str, str2)).booleanValue();
        }
        return SafeModeClearHelper.f(i3, str, str2);
    }

    @Override // com.tencent.qphone.base.util.MSFInterfaceAdapter
    public String getBeaconAppKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return "0S200MNJT807V3GE";
    }

    @Override // com.tencent.qphone.base.util.MSFInterfaceAdapter
    public String getChannel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return AppSetting.g();
    }

    @Override // com.tencent.qphone.base.util.MSFInterfaceAdapter
    public String getWTUinStoreFileDirLastResort() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return SoLoadCore.APP_ROOT;
    }

    @Override // com.tencent.qphone.base.util.MSFInterfaceAdapter
    public void handleCatchException(Thread thread, Throwable th5, String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, thread, th5, str, bArr);
        } else {
            com.tencent.qqperf.monitor.crash.catchedexception.a.d(th5, str, thread);
        }
    }

    @Override // com.tencent.qphone.base.util.MSFInterfaceAdapter
    public boolean isGrayVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.qphone.base.util.MSFInterfaceAdapter
    public boolean isPublicVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.qphone.base.util.MSFInterfaceAdapter
    public boolean isReleaseVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.qphone.base.util.MSFInterfaceAdapter
    public boolean isSwitchOn(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(str, z16);
    }

    @Override // com.tencent.qphone.base.util.MSFInterfaceAdapter
    public boolean isSwitchToTestEnv() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return AppSetting.H;
    }

    @Override // com.tencent.qphone.base.util.MSFInterfaceAdapter
    public boolean isVIPAccount(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
        }
        try {
            return Utils.L(Long.parseLong(str));
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.tencent.qphone.base.util.MSFInterfaceAdapter
    public void onServiceInit(Context context, MSFStartupListener mSFStartupListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) context, (Object) mSFStartupListener);
        } else {
            MSFStartupDirector.getNtDirector().onServiceInit(context, mSFStartupListener);
        }
    }

    @Override // com.tencent.qphone.base.util.MSFInterfaceAdapter
    public boolean useNtWtLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return MobileQQ.sMobileQQ.isLoginByNT();
    }

    @Override // com.tencent.qphone.base.util.MSFInterfaceAdapter
    public void beaconReport(String str, String str2, boolean z16, Map<String, String> map, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            QQBeaconReport.report(str, str2, z16, map, z17);
        } else {
            iPatchRedirector.redirect((short) 10, this, str, str2, Boolean.valueOf(z16), map, Boolean.valueOf(z17));
        }
    }
}
