package com.tencent.qqmini.sdk.launcher;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.tencent.qqmini.sdk.launcher.dynamic.Reflect;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.ProcessType;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class Configuration {
    private static final String CLASS_CUSTOM_CONFIG = "com.tencent.qqmini.sdk.core.generated.CustomConfiguration";
    private static final String FIELD_DEXLOADER_ENABLED = "DEXLOADER_ENABLED";
    private static final String FIELD_DEX_CONFIG = "DEX_CONFIG";
    private static final String FIELD_FLUTTER_ENABLED = "FLUTTER_ENABLED";
    private static final String FIELD_LOCAL_DEX_ENABLED = "LOCAL_DEX_ENABLED";
    private static final String FIELD_MINI_PROCESS_LIST = "MINI_PROCESS_LIST";
    private static final String TAG = "Configuration";
    public String dexConfig;
    public boolean dexLoaderEnable;
    public boolean flutterEnabled;
    public boolean localDexEnable;
    public List<ProcessInfo> processInfoList;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class Builder {
        Configuration configuration;

        public Builder(Context context) {
            this.configuration = new Configuration(context);
        }

        public Configuration build() {
            return this.configuration;
        }

        public Builder setFlutterEnabled(boolean z16) {
            this.configuration.flutterEnabled = z16;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class ProcessInfo {
        public Class internalUIClass;
        public String name;
        public ProcessType processType;
        public Class receiverClass;
        public int supportRuntimeType;
        public Class uiClass;
    }

    private void addProcessInfo(String str, Class cls, Class cls2, Class cls3, ProcessType processType, int i3) {
        ProcessInfo processInfo = new ProcessInfo();
        processInfo.name = str;
        processInfo.uiClass = cls;
        processInfo.internalUIClass = cls2;
        processInfo.receiverClass = cls3;
        processInfo.processType = processType;
        processInfo.supportRuntimeType = i3;
        this.processInfoList.add(processInfo);
    }

    private void ensureProcessInfo(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            for (int size = this.processInfoList.size() - 1; size >= 0; size--) {
                ProcessInfo processInfo = this.processInfoList.get(size);
                Intent intent = new Intent();
                intent.setClassName(context.getPackageName(), processInfo.uiClass.getName());
                if (packageManager.resolveActivity(intent, 0) == null) {
                    QMLog.e(TAG, "Not registered manifest. uiClass:" + processInfo.uiClass.getName());
                    this.processInfoList.remove(size);
                }
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "getDefaultConfiguration exception. ", th5);
        }
    }

    private Class findClass(String str) {
        return AppLoaderFactory.g().findClass(str);
    }

    private void initCustomConfiguration(Context context) {
        Class findClass;
        if (context == null) {
            return;
        }
        String packageName = context.getPackageName();
        this.flutterEnabled = ((Boolean) Reflect.on(CLASS_CUSTOM_CONFIG).get(FIELD_FLUTTER_ENABLED)).booleanValue();
        this.dexLoaderEnable = ((Boolean) Reflect.on(CLASS_CUSTOM_CONFIG).get(FIELD_DEXLOADER_ENABLED)).booleanValue();
        this.dexConfig = (String) Reflect.on(CLASS_CUSTOM_CONFIG).get(FIELD_DEX_CONFIG);
        this.localDexEnable = ((Boolean) Reflect.on(CLASS_CUSTOM_CONFIG).get(FIELD_LOCAL_DEX_ENABLED)).booleanValue();
        for (Object obj : (List) Reflect.on(CLASS_CUSTOM_CONFIG).get(FIELD_MINI_PROCESS_LIST)) {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                ProcessInfo processInfo = new ProcessInfo();
                processInfo.name = packageName + ":" + map.get("name").toString();
                String obj2 = map.get("processType").toString();
                if ("MINI_GAME".equals(obj2)) {
                    processInfo.processType = ProcessType.MINI_GAME;
                } else if ("MINI_APP".equals(obj2)) {
                    processInfo.processType = ProcessType.MINI_APP;
                } else if ("MINI_INTERNAL".equals(obj2)) {
                    processInfo.processType = ProcessType.MINI_INTERNAL;
                }
                if (map.get("internalUI") != null && (findClass = findClass(map.get("internalUI").toString())) != null && Activity.class.isAssignableFrom(findClass)) {
                    processInfo.internalUIClass = findClass;
                }
                processInfo.supportRuntimeType = ((Integer) map.get("supportRuntimeType")).intValue();
                processInfo.uiClass = (Class) map.get(SensorJsPlugin.SENSOR_INTERVAL_UI);
                processInfo.receiverClass = (Class) map.get("receiver");
                this.processInfoList.add(processInfo);
            }
        }
    }

    private void initDefaultConfiguration(Context context) {
        if (context == null) {
            return;
        }
        this.flutterEnabled = false;
        this.dexLoaderEnable = true;
        this.dexConfig = "";
        String packageName = context.getPackageName();
        Class findClass = findClass("com.tencent.qqmini.sdk.ui.MiniActivity1");
        Class findClass2 = findClass("com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver1");
        ProcessType processType = ProcessType.MINI_GAME;
        addProcessInfo(packageName + ":mini1", findClass, null, findClass2, processType, 4);
        addProcessInfo(packageName + ":mini2", findClass("com.tencent.qqmini.sdk.ui.MiniActivity2"), null, findClass("com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver2"), processType, 4);
        addProcessInfo(packageName + ":mini3", findClass("com.tencent.qqmini.sdk.ui.MiniActivity3"), null, findClass("com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver3"), processType, 4);
        Class findClass3 = findClass("com.tencent.qqmini.sdk.ui.MiniActivity4");
        Class findClass4 = findClass("com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver4");
        ProcessType processType2 = ProcessType.MINI_APP;
        addProcessInfo(packageName + ":mini4", findClass3, null, findClass4, processType2, 1);
        addProcessInfo(packageName + ":mini5", findClass("com.tencent.qqmini.sdk.ui.MiniActivity5"), null, findClass("com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver5"), processType2, 1);
        addProcessInfo(packageName + ":mini_internal", findClass("com.tencent.qqmini.sdk.ui.InternalMiniActivity"), null, findClass("com.tencent.qqmini.sdk.receiver.InternalAppBrandMainReceiver"), ProcessType.MINI_INTERNAL, 1);
    }

    private boolean isCustomConfigurationExist() {
        if (findClass(CLASS_CUSTOM_CONFIG) != null) {
            return true;
        }
        return false;
    }

    Configuration(Context context) {
        this.dexLoaderEnable = true;
        this.localDexEnable = false;
        this.processInfoList = new ArrayList();
        if (isCustomConfigurationExist()) {
            initCustomConfiguration(context);
        } else {
            QMLog.i(TAG, "OK with CustomConfiguration not found. Use default configuration");
            initDefaultConfiguration(context);
        }
    }
}
