package com.tencent.midas.jsbridge;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APPluginDataStorage;
import com.tencent.midas.data.APPluginDataInterface;
import com.tencent.midas.data.APPluginReportManager;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes9.dex */
public class APX5 {
    private static String getTbsVersion() {
        try {
            Field field = TbsConfig.class.getField("TBS_SDK_VERSIONNAME");
            field.setAccessible(true);
            return (String) field.get(TbsConfig.class);
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
            return "unknown";
        } catch (IllegalAccessException e17) {
            e17.printStackTrace();
            return "unknown";
        } catch (NoSuchFieldException e18) {
            e18.printStackTrace();
            return "unknown";
        }
    }

    private static boolean hasInitX5Method() {
        try {
            String str = QbSdk.SHARE_PREFERENCES_NAME;
            if (QbSdk.class.getMethod("initX5Environment", Context.class, QbSdk.PreInitCallback.class) == null) {
                return false;
            }
            return true;
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
            return false;
        } catch (NoSuchMethodException e17) {
            e17.printStackTrace();
            return false;
        }
    }

    private static boolean initTbs(Context context) {
        String str;
        APLog.d("APX5", "init Tbs Start");
        APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), APPluginReportManager.MIDASPLUGIN_X5_INIT, "", "");
        boolean z16 = false;
        try {
            String tbsVersion = getTbsVersion();
            APLog.d("APX5", "get tbs version: " + tbsVersion);
            if (hasInitX5Method()) {
                APLog.d("APX5", "tbs has initX5 method");
                initX5Environment(context);
                z16 = true;
                APLog.d("APX5", "init Tbs Success. use X5 instead of Native WebView");
            } else {
                APLog.d("APX5", "tbs has no initX5 method");
                APLog.d("APX5", "unsupported tbs, version: " + tbsVersion);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            APLog.e("APX5", "init tbs failed, use native WebView!");
            APLog.e("APX5", "unsupported tbs: exception: " + th5.getMessage());
        }
        APLog.d("APX5", "initTbs End");
        APPluginReportManager aPPluginReportManager = APPluginReportManager.getInstance();
        String launchInterface = APPluginDataInterface.singleton().getLaunchInterface();
        if (z16) {
            str = APPluginReportManager.MIDASPLUGIN_X5_INIT_SUCCESS;
        } else {
            str = APPluginReportManager.MIDASPLUGIN_X5_INIT_FAIL;
        }
        aPPluginReportManager.insertData(launchInterface, str, "", "");
        return z16;
    }

    public static void initX5(Context context) {
        APLog.d("APX5", ">>>>>>> initX5 Start <<<<<<<");
        if (!isX5Enabled(context)) {
            APLog.d("APX5", ">>>>>>> X5 is missed or disabled, use native WebView");
        } else {
            APLog.d("APX5", ">>>>>>> initX5 End <<<<<<<");
        }
    }

    private static void initX5Environment(final Context context) {
        new BaseThread(new Runnable() { // from class: com.tencent.midas.jsbridge.APX5.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String str = QbSdk.SHARE_PREFERENCES_NAME;
                    Method method = QbSdk.class.getMethod("initX5Environment", Context.class, QbSdk.PreInitCallback.class);
                    if (method != null) {
                        method.setAccessible(true);
                        method.invoke(null, context.getApplicationContext(), null);
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        }).start();
    }

    public static boolean isX5Enabled(Context context) {
        boolean z16;
        Context applicationContext = context.getApplicationContext();
        String data = APPluginDataStorage.getData(applicationContext, APPluginDataInterface.SHARE_PREFERENCE_NAME, "enableX5");
        if (!TextUtils.isEmpty(data)) {
            z16 = !data.equals("0");
        } else {
            z16 = true;
        }
        APLog.d("APX5", "is enable X5: " + data);
        if (z16 && initTbs(applicationContext)) {
            return true;
        }
        return false;
    }

    public static boolean isX5WebView(Context context) {
        boolean z16;
        String data = APPluginDataStorage.getData(context.getApplicationContext(), APPluginDataInterface.SHARE_PREFERENCE_NAME, "enableX5");
        if (!TextUtils.isEmpty(data)) {
            z16 = !data.equals("0");
        } else {
            z16 = false;
        }
        APLog.d("APX5", "isX5WebView: " + z16);
        return z16;
    }

    private static boolean needDownloadTbs(Context context) {
        try {
            String str = TbsDownloader.LOGTAG;
            Method method = TbsDownloader.class.getMethod(FavEmoConstant.ROAMING_TYPE_PANEL, Context.class);
            if (method != null) {
                method.setAccessible(true);
                return ((Boolean) method.invoke(null, context)).booleanValue();
            }
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
        } catch (IllegalAccessException e17) {
            e17.printStackTrace();
        } catch (NoSuchMethodException e18) {
            e18.printStackTrace();
        } catch (InvocationTargetException e19) {
            e19.printStackTrace();
        }
        return false;
    }

    private static void preInit(Context context) {
        try {
            String str = QbSdk.SHARE_PREFERENCES_NAME;
            Method method = QbSdk.class.getMethod("preInit", Context.class);
            if (method != null) {
                method.setAccessible(true);
                method.invoke(null, context);
            }
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
        } catch (IllegalAccessException e17) {
            e17.printStackTrace();
        } catch (NoSuchMethodException e18) {
            e18.printStackTrace();
        } catch (InvocationTargetException e19) {
            e19.printStackTrace();
        }
    }
}
