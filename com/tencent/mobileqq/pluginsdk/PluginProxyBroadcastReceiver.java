package com.tencent.mobileqq.pluginsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

/* loaded from: classes16.dex */
public class PluginProxyBroadcastReceiver extends BroadcastReceiver {
    static IPatchRedirector $redirector_;
    private int mPluginResoucesType;

    public PluginProxyBroadcastReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void sendBroadcastReceiver(Context context, String str, String str2, String str3, String str4, Intent intent) {
        intent.putExtra("pluginsdk_pluginName", str);
        intent.putExtra("pluginsdk_pluginLocation", str2);
        intent.putExtra("pluginsdk_launchReceiver", str4);
        intent.putExtra("pluginsdk_pluginpath", str3);
        try {
            context.sendBroadcast(intent);
        } catch (Throwable th5) {
            QLog.d("plugin_tag", 1, "", th5);
        }
    }

    private IPluginBroadcastReceiver startPluginIfNeccessary(Context context, Intent intent) {
        IPluginBroadcastReceiver iPluginBroadcastReceiver = null;
        if (intent == null || !PluginStatic.isValidPluginIntent(intent.getExtras())) {
            return null;
        }
        String stringExtra = intent.getStringExtra("pluginsdk_pluginLocation");
        String stringExtra2 = intent.getStringExtra("pluginsdk_launchReceiver");
        this.mPluginResoucesType = intent.getIntExtra(PluginStatic.PARAM_USE_QQ_RESOURCES, 0);
        String stringExtra3 = intent.getStringExtra("pluginsdk_pluginpath");
        String stringExtra4 = intent.getStringExtra(PluginStatic.PARAM_UIN);
        String stringExtra5 = intent.getStringExtra("pluginsdk_pluginName");
        if (!TextUtils.isEmpty(stringExtra4)) {
            IPluginAdapterProxy.getProxy().currentUin = stringExtra4;
        }
        if (TextUtils.isEmpty(stringExtra3)) {
            try {
                stringExtra3 = PluginUtils.getInstalledPluginPath(context, stringExtra).getCanonicalPath();
            } catch (IOException unused) {
            }
        }
        String str = stringExtra3;
        if (DebugHelper.sDebug) {
            DebugHelper.log("plugin_tag", "PluginProxyBroadcastReceiver.startPluginIfNeccessary Params:" + stringExtra + ", " + stringExtra2);
        }
        if (stringExtra == null || stringExtra.length() <= 0) {
            return null;
        }
        PluginRecoverReceiver.addCarePluginId(stringExtra);
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        PackageInfo packageInfo = PluginStatic.sPackageInfoMap.get(str);
        if (packageInfo == null) {
            try {
                packageInfo = ApkFileParser.getPackageInfoWithException(context, str, 129);
            } catch (Throwable th5) {
                if (DebugHelper.sDebug) {
                    DebugHelper.log("plugin_tag", "PluginProxyBroadcastReceiver failed", th5);
                }
            }
            if (packageInfo == null) {
                return null;
            }
            PluginStatic.sPackageInfoMap.put(str, packageInfo);
        }
        PackageInfo packageInfo2 = packageInfo;
        try {
            ClassLoader orCreateClassLoaderByPath = PluginStatic.getOrCreateClassLoaderByPath(context, stringExtra, str, true);
            IPluginBroadcastReceiver iPluginBroadcastReceiver2 = (IPluginBroadcastReceiver) orCreateClassLoaderByPath.loadClass(stringExtra2).newInstance();
            try {
                iPluginBroadcastReceiver2.IInit(stringExtra5, stringExtra, str, this, orCreateClassLoaderByPath, packageInfo2, this.mPluginResoucesType);
                PluginProxyActivity.uploadLaunchInfoWhenCreateClassLoader(stringExtra2, intent);
                return iPluginBroadcastReceiver2;
            } catch (Exception e16) {
                e = e16;
                iPluginBroadcastReceiver = iPluginBroadcastReceiver2;
                if (DebugHelper.sDebug) {
                    DebugHelper.log("plugin_tag", "PluginProxyBroadcastReceiver initPlugin", e);
                    return iPluginBroadcastReceiver;
                }
                return iPluginBroadcastReceiver;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (DebugHelper.sDebug) {
            DebugHelper.log("plugin_tag", "PluginProxyBroadcastReceiver.onReceive: " + intent);
        }
        IPluginProxyComponent.registerAccountReceiverIfNeccessary();
        IPluginBroadcastReceiver startPluginIfNeccessary = startPluginIfNeccessary(context, intent);
        if (DebugHelper.sDebug) {
            DebugHelper.log("plugin_tag", "PluginProxyBroadcastReceiver.startPluginIfNeccessary: " + startPluginIfNeccessary);
        }
        if (startPluginIfNeccessary != null) {
            startPluginIfNeccessary.IOnReceive(context, intent);
        }
    }
}
