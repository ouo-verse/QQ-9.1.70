package com.tencent.mobileqq.pluginsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public abstract class PluginBroadcastReceiver extends BroadcastReceiver implements IPluginBroadcastReceiver {
    static IPatchRedirector $redirector_;
    protected String mApkFilePath;
    protected ClassLoader mDexClassLoader;
    protected boolean mIsRunInPlugin;
    protected BroadcastReceiver mOutReceiver;
    protected PackageInfo mPackageInfo;
    protected String mPluginID;
    protected String mPluginName;
    private int mPluginResourcesType;

    public PluginBroadcastReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginBroadcastReceiver
    public void IInit(String str, String str2, String str3, BroadcastReceiver broadcastReceiver, ClassLoader classLoader, PackageInfo packageInfo, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, str3, broadcastReceiver, classLoader, packageInfo, Integer.valueOf(i3));
            return;
        }
        if (DebugHelper.sDebug) {
            DebugHelper.log("plugin_tag", "PluginBroadcastReceiver.Init:" + str2 + ", " + this.mPluginResourcesType);
        }
        this.mIsRunInPlugin = true;
        this.mPluginName = str;
        this.mPluginID = str2;
        this.mApkFilePath = str3;
        this.mOutReceiver = broadcastReceiver;
        this.mDexClassLoader = classLoader;
        this.mPackageInfo = packageInfo;
        this.mPluginResourcesType = i3;
    }

    @Override // com.tencent.mobileqq.pluginsdk.IPluginBroadcastReceiver
    public void IOnReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (DebugHelper.sDebug) {
            DebugHelper.log("plugin_tag", "PluginBroadcastReceiver.IOnReceive");
        }
        onReceive(new PluginContext(context, 0, this.mApkFilePath, this.mDexClassLoader, context.getResources(), this.mPluginResourcesType), intent);
    }

    public void openActivity(Intent intent, String str, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, intent, str, str2, Boolean.valueOf(z16));
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
