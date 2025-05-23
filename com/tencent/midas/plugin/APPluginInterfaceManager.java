package com.tencent.midas.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APPluginDataStorage;
import com.tencent.midas.control.APMidasPayHelper;
import com.tencent.midas.data.APPluginDataInterface;
import com.tencent.midas.data.APPluginReportManager;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes9.dex */
public class APPluginInterfaceManager {
    public static final String TAG = "APPluginInterfaceManager";

    private static Class<?> getObjectClass(Context context, String str, String str2, String str3) throws Exception {
        String str4;
        try {
            str4 = APPluginInstallerAndUpdater.getInstallPath(context, str).getCanonicalPath();
        } catch (Exception unused) {
            str4 = "";
        }
        try {
            ConcurrentHashMap<String, PackageInfo> concurrentHashMap = APPluginStatic.sPackageInfoMap;
            if (concurrentHashMap.get(str4) == null) {
                PackageInfo packageInfo = APApkFileParser.getPackageInfo(context, str4, 1);
                if (packageInfo == null) {
                    return null;
                }
                concurrentHashMap.put(str4, packageInfo);
            }
            return APPluginLoader.getOrCreateClassLoaderByPath(context, str, str4).loadClass(str2);
        } catch (Exception unused2) {
            return null;
        }
    }

    private static Class<?>[] getParamsType(Object[] objArr) {
        if (objArr != null) {
            int length = objArr.length;
            Class<?>[] clsArr = new Class[length];
            for (int i3 = 0; i3 < length; i3++) {
                Object obj = objArr[i3];
                if (obj != null) {
                    if (Activity.class.isAssignableFrom(obj.getClass())) {
                        clsArr[i3] = Activity.class;
                    } else {
                        clsArr[i3] = objArr[i3].getClass();
                    }
                }
            }
            return clsArr;
        }
        return null;
    }

    public static Object initPluginInterface(Context context, String str, String str2, String str3, Object[] objArr) throws Exception {
        APLog.d(TAG, "Call into initPluginInterface  plugin = " + str + " interfaceClass = " + str2 + " methodName = " + str3 + " " + Thread.currentThread().getStackTrace()[3].toString());
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            APPluginDataStorage.initCache(context, APPluginDataInterface.SHARE_PREFERENCE_NAME);
            Class<?> objectClass = getObjectClass(context, str, str2, str3);
            if (objectClass == null) {
                APPluginReportManager.getInstance().insertData(APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHPAY, APPluginReportManager.MIDASPLUGIN_FORMAT_APKLOAD_FAIL, str, "objClassIsNull");
                if (APMidasPayHelper.MED_DISTRIBUTE_PAY.equals(str3)) {
                    APLog.d(TAG, "initPluginInterface objClass is null, current method name = " + str3 + " we need to jump to pure h5 pay!");
                    APPluginUtils.showLaunchPluginFail(context.getApplicationContext(), "", true);
                } else {
                    APLog.d(TAG, "initPluginInterface objClass is null, current method name = " + str3 + " no need to jump to pure h5 pay!");
                    APPluginUtils.showLaunchPluginFail(context.getApplicationContext(), "", false);
                }
                APPluginStatic.removeAll();
                APPluginInstallerAndUpdater.unInstallPlugin(context);
                return null;
            }
            Method method = objectClass.getMethod(str3, getParamsType(objArr));
            method.setAccessible(true);
            long currentTimeMillis = System.currentTimeMillis();
            Object invoke = method.invoke(objectClass, objArr);
            APLog.i("APPLuginProxyActivity", "initPluginInterface method=" + method + " obj=" + invoke + " time=" + (System.currentTimeMillis() - currentTimeMillis));
            return invoke;
        }
        APLog.i("APPLuginProxyActivity", "initPluginInterface objClass param is null");
        return null;
    }

    public static Object initPluginInterface2(Context context, String str, String str2, String str3, Object[] objArr) throws Exception {
        APLog.i("APPLuginProxyActivity", "initPluginInterface2 pluginName=" + str);
        APLog.i("APPLuginProxyActivity", "initPluginInterface2 interfaceClass=" + str2);
        APLog.i("APPLuginProxyActivity", "initPluginInterface2 methodName=" + str3);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            Class<?> objectClass = getObjectClass(context, str, str2, str3);
            if (objectClass == null) {
                APLog.i("APPLuginProxyActivity", "initPluginInterface2 objClass is null");
                APPluginReportManager.getInstance().insertData(APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHPAY, APPluginReportManager.MIDASPLUGIN_FORMAT_APKLOAD_FAIL, str, "objClassIsNull");
                APPluginUtils.showLaunchPluginFail(context.getApplicationContext(), "", false);
                APPluginStatic.removeAll();
                APPluginInstallerAndUpdater.unInstallPlugin(context);
                return null;
            }
            Class<?>[] clsArr = {objArr[0].getClass(), objArr[1].getClass(), objArr[2].getClass()};
            APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod Name:" + str3);
            APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod objClass:" + objectClass);
            for (int i3 = 0; i3 < 3; i3++) {
                APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod paraTypes:" + clsArr[i3]);
            }
            Method method = objectClass.getMethod(str3, clsArr);
            APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod method:" + method);
            method.setAccessible(true);
            Object invoke = method.invoke(objectClass, objArr);
            APLog.i("APPLuginProxyActivity", "initPluginInterface2 obj=" + invoke);
            return invoke;
        }
        APLog.i("APPLuginProxyActivity", "initPluginInterface2 objClass param is null");
        return null;
    }

    public static Object initPluginInterface(Context context, String str, String str2, String str3, Object[] objArr, Class<?>[] clsArr) throws Exception {
        APLog.i("APPLuginProxyActivity", "initPluginInterface2 pluginName=" + str);
        APLog.i("APPLuginProxyActivity", "initPluginInterface2 interfaceClass=" + str2);
        APLog.i("APPLuginProxyActivity", "initPluginInterface2 methodName=" + str3);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            Class<?> objectClass = getObjectClass(context, str, str2, str3);
            if (objectClass == null) {
                APLog.i("APPLuginProxyActivity", "initPluginInterface2 objClass is null");
                APPluginReportManager.getInstance().insertData(APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHPAY, APPluginReportManager.MIDASPLUGIN_FORMAT_APKLOAD_FAIL, str, "objClassIsNull");
                APPluginUtils.showLaunchPluginFail(context.getApplicationContext(), "", false);
                APPluginStatic.removeAll();
                APPluginInstallerAndUpdater.unInstallPlugin(context);
                return null;
            }
            APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod Name:" + str3);
            APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod objClass:" + objectClass);
            for (Class<?> cls : clsArr) {
                APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod paraTypes:" + cls);
            }
            Method method = objectClass.getMethod(str3, clsArr);
            APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod method:" + method);
            method.setAccessible(true);
            Object invoke = method.invoke(objectClass, objArr);
            APLog.i("APPLuginProxyActivity", "initPluginInterface2 obj=" + invoke);
            return invoke;
        }
        APLog.i("APPLuginProxyActivity", "initPluginInterface2 objClass param is null");
        return null;
    }
}
