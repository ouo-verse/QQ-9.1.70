package com.tencent.midas.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes9.dex */
public class APPluginProxyBroadcastReceiver extends BroadcastReceiver {
    public static void sendBroadcastReceiver(Context context, String str, String str2, Intent intent) {
        intent.putExtra("pluginsdk_pluginName", str);
        intent.putExtra("pluginsdk_launchReceiver", str2);
        try {
            context.sendBroadcast(intent);
        } catch (Throwable unused) {
        }
    }

    private IAPPluginBroadcastReceiver startPluginIfNeccessary(Context context, Intent intent) {
        String canonicalPath;
        if (intent == null) {
            return null;
        }
        String stringExtra = intent.getStringExtra("pluginsdk_pluginName");
        String stringExtra2 = intent.getStringExtra("pluginsdk_launchReceiver");
        if (TextUtils.isEmpty(null)) {
            try {
                canonicalPath = APPluginInstallerAndUpdater.getInstallPath(context, stringExtra).getCanonicalPath();
            } catch (IOException unused) {
            }
            APLog.i("APPLuginProxyBroadcastReciver", "startPluginIfNeccessary Params:" + stringExtra + ", " + stringExtra2);
            if (stringExtra == null && stringExtra.length() > 0) {
                File file = new File(canonicalPath);
                if (!file.exists() || !file.isFile()) {
                    return null;
                }
                ConcurrentHashMap<String, PackageInfo> concurrentHashMap = APPluginStatic.sPackageInfoMap;
                PackageInfo packageInfo = concurrentHashMap.get(canonicalPath);
                if (packageInfo == null) {
                    packageInfo = APApkFileParser.getPackageInfo(context, canonicalPath, 1);
                    concurrentHashMap.put(canonicalPath, packageInfo);
                }
                PackageInfo packageInfo2 = packageInfo;
                try {
                    DexClassLoader orCreateClassLoaderByPath = APPluginLoader.getOrCreateClassLoaderByPath(context, stringExtra, canonicalPath);
                    IAPPluginBroadcastReceiver iAPPluginBroadcastReceiver = (IAPPluginBroadcastReceiver) orCreateClassLoaderByPath.loadClass(stringExtra2).newInstance();
                    try {
                        iAPPluginBroadcastReceiver.IInit(stringExtra, canonicalPath, this, orCreateClassLoaderByPath, packageInfo2, false);
                    } catch (Exception unused2) {
                    }
                    return iAPPluginBroadcastReceiver;
                } catch (Exception unused3) {
                    return null;
                }
            }
        }
        canonicalPath = null;
        APLog.i("APPLuginProxyBroadcastReciver", "startPluginIfNeccessary Params:" + stringExtra + ", " + stringExtra2);
        return stringExtra == null ? null : null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IAPPluginBroadcastReceiver startPluginIfNeccessary = startPluginIfNeccessary(context, intent);
        APLog.i("APPLuginProxyBroadcastReciver", "onReceive startPluginIfNeccessary: " + startPluginIfNeccessary);
        if (startPluginIfNeccessary != null) {
            startPluginIfNeccessary.IOnReceive(context, intent);
        }
    }
}
