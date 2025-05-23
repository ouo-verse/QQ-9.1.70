package com.tencent.mobileqq.pluginsdk;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppService;
import mqq.app.MobileQQ;

@SuppressLint({"NewApi"})
/* loaded from: classes16.dex */
public abstract class PluginService extends AppService implements IPluginService {
    static IPatchRedirector $redirector_;
    protected String mApkFilePath;
    private Context mContext;
    protected ClassLoader mDexClassLoader;
    protected boolean mIsRunInPlugin;
    protected Service mOutService;
    protected PackageInfo mPackageInfo;
    protected String mPluginID;
    protected String mPluginName;
    private int mPluginResourcesType;

    public PluginService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginService
    public void IInit(String str, String str2, String str3, Service service, ClassLoader classLoader, PackageInfo packageInfo, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, str2, str3, service, classLoader, packageInfo, Integer.valueOf(i3));
            return;
        }
        if (DebugHelper.sDebug) {
            DebugHelper.log("plugin_tag", "PluginService.IInit: " + str2 + ", " + this.mPluginResourcesType);
        }
        this.mIsRunInPlugin = true;
        this.mPluginName = str;
        this.mPluginID = str2;
        this.mApkFilePath = str3;
        this.mOutService = service;
        this.mDexClassLoader = classLoader;
        this.mPackageInfo = packageInfo;
        this.mPluginResourcesType = i3;
        if (this.mContext == null) {
            try {
                this.mContext = new PluginContext(service, 0, this.mApkFilePath, this.mDexClassLoader, service.getResources(), this.mPluginResourcesType);
            } catch (Error unused) {
            }
        }
        attachBaseContext(this.mContext);
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginService
    public IBinder IOnBind(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (IBinder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
        }
        IBinder onBind = onBind(intent);
        if (DebugHelper.sDebug) {
            DebugHelper.log("plugin_tag", "PluginService.IOnBind: " + onBind + ", " + intent);
        }
        return onBind;
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginService
    public void IOnCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            onCreate();
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginService
    public void IOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginService
    public void IOnStart(Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, i3);
        } else {
            onStart(intent, i3);
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginService
    public int IOnStartCommand(Intent intent, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, intent, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        return onStartCommand(intent, i3, i16);
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginService
    public boolean IOnUnbind(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent)).booleanValue();
        }
        return onUnbind(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ApplicationInfo getApplicationInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ApplicationInfo) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        if (this.mIsRunInPlugin) {
            return this.mPackageInfo.applicationInfo;
        }
        return super.getApplicationInfo();
    }

    @Override // mqq.app.AppService
    public String getModuleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.mPluginID;
    }

    public PackageInfo getPackageInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (PackageInfo) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (this.mIsRunInPlugin) {
            return this.mPackageInfo;
        }
        return null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        if (this.mIsRunInPlugin) {
            return this.mPackageInfo.packageName;
        }
        return super.getPackageName();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        if (!"window".equals(str) && !"search".equals(str)) {
            Context context = this.mContext;
            if (context != null) {
                return context.getSystemService(str);
            }
            return super.getSystemService(str);
        }
        if (this.mIsRunInPlugin) {
            return this.mOutService.getSystemService(str);
        }
        return super.getSystemService(str);
    }

    public void openActivity(Intent intent, String str, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, intent, str, str2, Boolean.valueOf(z16));
            return;
        }
        intent.putExtra("pluginsdk_IsPluginActivity", true);
        PluginProxyActivity.StartActivityParams startActivityParams = new PluginProxyActivity.StartActivityParams();
        startActivityParams.mPluginName = this.mPluginName;
        startActivityParams.mPluginID = this.mPluginID;
        startActivityParams.mPluginApkFilePath = this.mApkFilePath;
        startActivityParams.proxyActivity = str;
        startActivityParams.mPluginResoucesType = this.mPluginResourcesType;
        startActivityParams.mUseSkinEngine = z16;
        startActivityParams.loader = this.mDexClassLoader;
        startActivityParams.launchActivity = str2;
        PluginProxyActivity.openActivity(MobileQQ.sMobileQQ, intent, startActivityParams);
    }
}
