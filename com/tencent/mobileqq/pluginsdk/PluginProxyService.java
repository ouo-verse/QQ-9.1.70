package com.tencent.mobileqq.pluginsdk;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes16.dex */
public class PluginProxyService extends Service {
    static IPatchRedirector $redirector_;
    private String mApkFilePath;
    private String mLaunchService;
    private String mPluginID;
    private String mPluginName;
    private int mPluginResoucesType;
    private IPluginService mPluginService;

    public PluginProxyService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void bindService(Context context, String str, String str2, String str3, String str4, Intent intent, ServiceConnection serviceConnection) {
        intent.putExtra("pluginsdk_pluginName", str);
        intent.putExtra("pluginsdk_pluginLocation", str2);
        intent.putExtra(PluginStatic.PARAM_LAUNCH_SERVICE, str4);
        intent.putExtra("pluginsdk_pluginpath", str3);
        try {
            context.bindService(intent, serviceConnection, 1);
        } catch (Throwable th5) {
            QLog.d("plugin_tag", 1, "", th5);
        }
    }

    private String initPlugin() throws Exception {
        PluginRecoverReceiver.addCarePluginId(this.mPluginID);
        ConcurrentHashMap<String, PackageInfo> concurrentHashMap = PluginStatic.sPackageInfoMap;
        PackageInfo packageInfo = concurrentHashMap.get(this.mApkFilePath);
        if (packageInfo == null) {
            try {
                packageInfo = ApkFileParser.getPackageInfoWithException(this, this.mApkFilePath, 129);
                if (packageInfo == null) {
                    return "Get Package Info Failed!";
                }
                concurrentHashMap.put(this.mApkFilePath, packageInfo);
            } catch (Throwable th5) {
                throw new PluginUtils.GetPackageInfoFailException("getPackageInfoWithException", th5);
            }
        }
        PackageInfo packageInfo2 = packageInfo;
        ClassLoader orCreateClassLoaderByPath = PluginStatic.getOrCreateClassLoaderByPath(this, this.mPluginID, this.mApkFilePath, true);
        try {
            IPluginService iPluginService = (IPluginService) orCreateClassLoaderByPath.loadClass(this.mLaunchService).newInstance();
            this.mPluginService = iPluginService;
            iPluginService.IInit(this.mPluginName, this.mPluginID, this.mApkFilePath, this, orCreateClassLoaderByPath, packageInfo2, this.mPluginResoucesType);
            return null;
        } catch (Throwable th6) {
            if (DebugHelper.sDebug) {
                DebugHelper.log("plugin_tag", "PluginProxyService initPlugin ", th6);
                return "new PluginService failed!";
            }
            return "new PluginService failed!";
        }
    }

    public static void openService(Context context, String str, String str2, String str3, String str4, Intent intent) {
        intent.putExtra("pluginsdk_pluginName", str);
        intent.putExtra("pluginsdk_pluginLocation", str2);
        intent.putExtra(PluginStatic.PARAM_LAUNCH_SERVICE, str4);
        intent.putExtra("pluginsdk_pluginpath", str3);
        try {
            context.startService(intent);
        } catch (Throwable th5) {
            QLog.d("plugin_tag", 1, "", th5);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IBinder iBinder;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (IBinder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
        }
        if (DebugHelper.sDebug) {
            DebugHelper.log("plugin_tag", "PluginProxyService.onBind PluginService:" + this.mPluginService);
        }
        if (this.mPluginService == null) {
            startPluginIfNeccessary(intent);
        }
        IPluginService iPluginService = this.mPluginService;
        if (iPluginService != null) {
            iBinder = iPluginService.IOnBind(intent);
        } else {
            iBinder = null;
        }
        if (DebugHelper.sDebug) {
            DebugHelper.log("plugin_tag", "PluginProxyService.onBind IBinder:" + iBinder);
        }
        return iBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.onCreate();
        IPluginProxyComponent.registerAccountReceiverIfNeccessary();
        if (DebugHelper.sDebug) {
            DebugHelper.log("plugin_tag", "PluginProxyService.onCreate");
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDestroy();
        if (DebugHelper.sDebug) {
            DebugHelper.log("plugin_tag", "PluginProxyService.onDestroy");
        }
        IPluginService iPluginService = this.mPluginService;
        if (iPluginService != null) {
            iPluginService.IOnDestroy();
            this.mPluginService = null;
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i3) {
        IPluginService iPluginService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, i3);
            return;
        }
        super.onStart(intent, i3);
        if (DebugHelper.sDebug) {
            DebugHelper.log("plugin_tag", "PluginProxyService.onStart Intent:" + intent);
        }
        if (startPluginIfNeccessary(intent) && (iPluginService = this.mPluginService) != null) {
            iPluginService.IOnStart(intent, i3);
        }
    }

    @Override // android.app.Service
    @SuppressLint({"NewApi"})
    public int onStartCommand(Intent intent, int i3, int i16) {
        IPluginService iPluginService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, intent, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        int onStartCommand = super.onStartCommand(intent, i3, i16);
        if (DebugHelper.sDebug) {
            DebugHelper.log("plugin_tag", "PluginProxyService.onStartCommand Intent:" + intent);
        }
        if (startPluginIfNeccessary(intent) && (iPluginService = this.mPluginService) != null) {
            return iPluginService.IOnStartCommand(intent, i3, i16);
        }
        return onStartCommand;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent)).booleanValue();
        }
        boolean onUnbind = super.onUnbind(intent);
        if (DebugHelper.sDebug) {
            DebugHelper.log("plugin_tag", "PluginProxyService.onUnbind Intent:" + intent);
        }
        IPluginService iPluginService = this.mPluginService;
        if (iPluginService != null) {
            return iPluginService.IOnUnbind(intent);
        }
        return onUnbind;
    }

    protected boolean startPluginIfNeccessary(Intent intent) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) intent)).booleanValue();
        }
        if (DebugHelper.sDebug) {
            DebugHelper.log("plugin_tag", "PluginProxyService.startPluginIfNeccessary Intent:" + intent);
        }
        if (intent == null || !PluginStatic.isValidPluginIntent(intent.getExtras())) {
            return false;
        }
        String stringExtra = intent.getStringExtra("pluginsdk_pluginName");
        String stringExtra2 = intent.getStringExtra("pluginsdk_pluginLocation");
        String stringExtra3 = intent.getStringExtra(PluginStatic.PARAM_LAUNCH_SERVICE);
        this.mPluginResoucesType = intent.getIntExtra(PluginStatic.PARAM_USE_QQ_RESOURCES, 0);
        String stringExtra4 = intent.getStringExtra("pluginsdk_pluginpath");
        String stringExtra5 = intent.getStringExtra(PluginStatic.PARAM_UIN);
        if (!TextUtils.isEmpty(stringExtra5)) {
            IPluginAdapterProxy.getProxy().currentUin = stringExtra5;
        }
        if (TextUtils.isEmpty(stringExtra4)) {
            try {
                stringExtra4 = PluginUtils.getInstalledPluginPath(this, stringExtra2).getCanonicalPath();
            } catch (IOException unused) {
            }
        }
        if (DebugHelper.sDebug) {
            DebugHelper.log("plugin_tag", "PluginProxyService.startPluginIfNeccessary Params:" + stringExtra2 + ", " + stringExtra3);
        }
        if (this.mPluginService != null) {
            if (this.mPluginID.equals(stringExtra2) && this.mPluginName.equals(stringExtra) && this.mLaunchService.equals(stringExtra3)) {
                if (DebugHelper.sDebug) {
                    DebugHelper.log("plugin_tag", "PluginProxyService.startPluginIfNeccessary: already init the same service");
                }
                return true;
            }
            if (DebugHelper.sDebug) {
                DebugHelper.log("plugin_tag", "PluginProxyService.startPluginIfNeccessary: error arguments");
            }
            return false;
        }
        this.mPluginID = stringExtra2;
        this.mApkFilePath = stringExtra4;
        this.mPluginName = stringExtra;
        this.mLaunchService = stringExtra3;
        ClassLoader classLoader = PluginStatic.getClassLoader(stringExtra2);
        if (classLoader != null) {
            intent.setExtrasClassLoader(classLoader);
        }
        String str2 = this.mPluginID;
        if (str2 != null && str2.length() != 0) {
            File file = new File(this.mApkFilePath);
            if (!file.exists() && !file.isFile()) {
                str = "Plugin File Not Found!";
            } else {
                try {
                    String initPlugin = initPlugin();
                    if (initPlugin == null) {
                        PluginProxyActivity.uploadLaunchInfoWhenCreateClassLoader(this.mLaunchService, intent);
                        this.mPluginService.IOnCreate();
                    }
                    str = initPlugin;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    str = PluginUtils.getExceptionInfo(e16);
                    stopSelf();
                }
            }
        } else {
            str = "Param mPluingLocation missing!";
        }
        if (DebugHelper.sDebug) {
            DebugHelper.log("plugin_tag", "PluginProxyService.startPluginIfNeccessary ErrorInfo: " + str);
        }
        return true;
    }
}
