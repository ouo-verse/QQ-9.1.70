package com.tencent.mobileqq.pluginsdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.WtloginManagerImpl;
import mqq.manager.Manager;

/* loaded from: classes16.dex */
public class PluginRuntime extends AppRuntime {
    static IPatchRedirector $redirector_ = null;
    private static final String CRASH_ACTION = "com.tencent.mobileqq.ACTION_PLUGIN_CRASH";
    private static final String INDEX_PLUGINID = "pluginsdk_carsh_pluginID";
    private static final String INDEX_THROWABLE = "pluginsdk_carsh_throwable";
    private static final boolean SUPPORT_CRASH_REPORT = true;
    private IClickEventReportor mReportor;

    /* loaded from: classes16.dex */
    public interface IClickEventReportor {
        void reportClickEvent(String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9);

        void reportClickEventRuntime(String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9);
    }

    public PluginRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static PluginRuntime getRuntime() {
        AppRuntime waitAppRuntime = MobileQQ.getMobileQQ().waitAppRuntime(null);
        if (waitAppRuntime == null || !(waitAppRuntime instanceof PluginRuntime)) {
            return null;
        }
        return (PluginRuntime) waitAppRuntime;
    }

    public static void handleCrash(Throwable th5, String str, Context context) {
        Intent intent = new Intent(CRASH_ACTION);
        intent.putExtra(INDEX_PLUGINID, str);
        intent.putExtra(INDEX_THROWABLE, th5);
        intent.setPackage(BaseApplication.getContext().getPackageName());
        context.sendBroadcast(intent);
    }

    @Override // mqq.app.AppRuntime
    public BaseApplication getApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (BaseApplication) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return null;
    }

    @Override // mqq.app.AppRuntime
    public String getCurrentAccountUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return getAccount();
    }

    @Override // mqq.app.AppRuntime
    public Manager getManager(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Manager) iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        Manager manager = super.getManager(i3);
        if (manager != null) {
            return manager;
        }
        if (i3 == 1) {
            manager = new WtloginManagerImpl(this);
        }
        if (manager != null) {
            addManager(i3, manager);
        }
        return manager;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppRuntime
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        if (this.parentRuntime == null) {
            PluginRecoverReceiver.register(getApplication(), new PluginRecoverReceiver());
        }
    }

    public void reportClickEvent(String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, str3, str4, str5, Integer.valueOf(i3), Integer.valueOf(i16), str6, str7, str8, str9);
            return;
        }
        IClickEventReportor iClickEventReportor = this.mReportor;
        if (iClickEventReportor != null) {
            iClickEventReportor.reportClickEvent(str, str2, str3, str4, str5, i3, i16, str6, str7, str8, str9);
        }
    }

    public void reportClickEventRuntime(String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, str3, str4, str5, Integer.valueOf(i3), Integer.valueOf(i16), str6, str7, str8, str9);
            return;
        }
        IClickEventReportor iClickEventReportor = this.mReportor;
        if (iClickEventReportor != null) {
            iClickEventReportor.reportClickEventRuntime(str, str2, str3, str4, str5, i3, i16, str6, str7, str8, str9);
        }
    }

    public void sendAppDataIncerment(String str, String[] strArr, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, strArr, Long.valueOf(j3));
            return;
        }
        if (DebugHelper.sDebug) {
            DebugHelper.log("PluginRuntime.sendAppDataIncerment:" + strArr);
        }
        super.sendAppDataIncermentMsg(str, strArr, j3);
    }

    public void setClickEventReportor(IClickEventReportor iClickEventReportor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iClickEventReportor);
        } else {
            this.mReportor = iClickEventReportor;
        }
    }
}
