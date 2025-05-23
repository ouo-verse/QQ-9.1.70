package com.tencent.bugly.agent;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.crashreport.BuglyLog;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.feedback.eup.CrashStrategyBean;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.rmonitor.RMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class GameAgent {
    private static final String CLASS_COCOS_ACTIVITY = "org.cocos2dx.lib.Cocos2dxActivity";
    private static final String CLASS_UNITY_PLAYER = "com.unity3d.player.UnityPlayer";
    public static final int GAME_TYPE_COCOS = 1;
    public static final int GAME_TYPE_UNITY = 2;
    public static final int GAME_TYPE_UNKNOWN = 0;
    private static final int LOG_LEVEL_DEBUG = 1;
    private static final int LOG_LEVEL_ERROR = 4;
    private static final int LOG_LEVEL_INFO = 2;
    private static final int LOG_LEVEL_VERBOSE = 0;
    private static final int LOG_LEVEL_WARN = 3;
    private static final String LOG_TAG = "CrashReport-GameAgent";
    private static final int TYPE_COCOS2DX_JS_CRASH = 5;
    private static final int TYPE_COCOS2DX_LUA_CRASH = 6;
    private static final int TYPE_U3D_CRASH = 4;
    private static final String VERSION = "4.0";
    private static long delay = 0;
    private static boolean hasGuessed = false;
    private static WeakReference<Activity> sActivity;
    private static WeakReference<Context> sContext;
    private static CrashHandleListener sCrashHandleListener;
    private static int sGameType;
    protected static Handler sHandler;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class Reflection {
        Reflection() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Object getStaticField(String str, String str2, Object obj) {
            try {
                Field declaredField = Class.forName(str).getDeclaredField(str2);
                declaredField.setAccessible(true);
                return declaredField.get(obj);
            } catch (ClassNotFoundException e16) {
                e16.printStackTrace();
                return null;
            } catch (IllegalAccessException e17) {
                e17.printStackTrace();
                return null;
            } catch (NoSuchFieldException e18) {
                e18.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Object invokeStaticMethod(String str, String str2, Object[] objArr, Class<?>... clsArr) {
            try {
                Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(null, objArr);
            } catch (ClassNotFoundException e16) {
                e16.printStackTrace();
                return null;
            } catch (IllegalAccessException e17) {
                e17.printStackTrace();
                return null;
            } catch (NoSuchMethodException e18) {
                e18.printStackTrace();
                return null;
            } catch (InvocationTargetException e19) {
                e19.printStackTrace();
                return null;
            } catch (Exception e26) {
                e26.printStackTrace();
                return null;
            }
        }

        private static Object newInstance(String str, Object[] objArr, Class<?>... clsArr) {
            try {
                Class<?> cls = Class.forName(str);
                if (objArr == null) {
                    return cls.newInstance();
                }
                return cls.getConstructor(clsArr).newInstance(objArr);
            } catch (ClassNotFoundException e16) {
                e16.printStackTrace();
                return null;
            } catch (IllegalAccessException e17) {
                e17.printStackTrace();
                return null;
            } catch (InstantiationException e18) {
                e18.printStackTrace();
                return null;
            } catch (NoSuchMethodException e19) {
                e19.printStackTrace();
                return null;
            } catch (InvocationTargetException e26) {
                e26.printStackTrace();
                return null;
            } catch (Exception e27) {
                e27.printStackTrace();
                return null;
            }
        }
    }

    public static void SetCrashHandlerListener(CrashHandleListener crashHandleListener) {
        sCrashHandleListener = crashHandleListener;
    }

    public static void abolish() {
        runTaskInUiThread(new Runnable() { // from class: com.tencent.bugly.agent.GameAgent.22
            @Override // java.lang.Runnable
            public void run() {
                RMonitor.abolish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void delayExit(long j3) {
        long max = Math.max(0L, j3);
        Handler handler = sHandler;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: com.tencent.bugly.agent.GameAgent.1
                @Override // java.lang.Runnable
                public void run() {
                    GameAgent.exitApplication();
                }
            }, max);
            return;
        }
        try {
            LockMethodProxy.sleep(max);
            exitApplication();
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
    }

    public static void enterScene(final String str) {
        runTaskInUiThread(new Runnable() { // from class: com.tencent.bugly.agent.GameAgent.23
            @Override // java.lang.Runnable
            public void run() {
                RMonitor.enterScene(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void exitApplication() {
        int myPid = Process.myPid();
        printLog(3, String.format(Locale.US, "Exit application by kill process[%d]", Integer.valueOf(myPid)));
        SystemMethodProxy.killProcess(myPid);
    }

    public static void exitScene(final String str) {
        runTaskInUiThread(new Runnable() { // from class: com.tencent.bugly.agent.GameAgent.24
            @Override // java.lang.Runnable
            public void run() {
                RMonitor.exitScene(str);
            }
        });
    }

    private static Activity getActivity() {
        Activity cocosActivity;
        WeakReference<Activity> weakReference = sActivity;
        if (weakReference == null || weakReference.get() == null) {
            int i3 = sGameType;
            if (i3 != 1) {
                if (i3 != 2) {
                    Log.w(LOG_TAG, "Game type has not been set.");
                    cocosActivity = guessActivity();
                } else {
                    cocosActivity = getUnityActivity();
                }
            } else {
                cocosActivity = getCocosActivity();
            }
            if (cocosActivity != null) {
                sActivity = new WeakReference<>(cocosActivity);
            }
        }
        WeakReference<Activity> weakReference2 = sActivity;
        if (weakReference2 != null) {
            return weakReference2.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Context getApplicationContext() {
        Activity activity;
        WeakReference<Context> weakReference = sContext;
        if ((weakReference == null || weakReference.get() == null) && (activity = getActivity()) != null) {
            sContext = new WeakReference<>(activity.getApplicationContext());
        }
        WeakReference<Context> weakReference2 = sContext;
        if (weakReference2 != null) {
            return weakReference2.get();
        }
        return null;
    }

    public static Activity getCocosActivity() {
        try {
            Object invokeStaticMethod = Reflection.invokeStaticMethod(CLASS_COCOS_ACTIVITY, "getContext", null, new Class[0]);
            if (invokeStaticMethod != null && (invokeStaticMethod instanceof Activity)) {
                return (Activity) invokeStaticMethod;
            }
        } catch (Exception unused) {
            Log.w(LOG_TAG, "Failed to get activity of Cocos.");
        }
        return null;
    }

    public static Activity getUnityActivity() {
        try {
            Object staticField = Reflection.getStaticField(CLASS_UNITY_PLAYER, "currentActivity", null);
            if (staticField != null && (staticField instanceof Activity)) {
                return (Activity) staticField;
            }
        } catch (Exception unused) {
            Log.w(LOG_TAG, "Failed to get activity of Unity.");
        }
        return null;
    }

    public static String getVersion() {
        return VERSION;
    }

    private static Activity guessActivity() {
        if (hasGuessed) {
            return null;
        }
        hasGuessed = true;
        Activity cocosActivity = getCocosActivity();
        if (cocosActivity == null) {
            return getUnityActivity();
        }
        return cocosActivity;
    }

    public static void init(final String str, String str2, String str3, String str4, String[] strArr, String str5, final boolean z16) {
        final Context applicationContext = getApplicationContext();
        if (applicationContext == null) {
            printLog(4, "Context is null. bugly initialize terminated.");
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!TextUtils.isEmpty(str3)) {
                CrashReport.setProductVersion(applicationContext, str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                CrashReport.setRdmUuid(str4);
            }
            sHandler = new Handler(Looper.getMainLooper());
            runTaskInUiThread(new Runnable() { // from class: com.tencent.bugly.agent.GameAgent.6
                @Override // java.lang.Runnable
                public void run() {
                    if (GameAgent.sCrashHandleListener != null) {
                        CrashStrategyBean crashStrategyBean = new CrashStrategyBean();
                        crashStrategyBean.setCrashHandler(GameAgent.sCrashHandleListener);
                        CrashReport.initCrashReport(applicationContext, str, z16, crashStrategyBean, GameAgent.delay);
                        return;
                    }
                    CrashReport.initCrashReport(applicationContext, str, z16, null, GameAgent.delay);
                }
            });
            return;
        }
        printLog(4, "Please input appId and appKey.");
    }

    public static void initRMonitor(String str, String str2, String str3, String str4, final String[] strArr, String str5) {
        Context applicationContext = getApplicationContext();
        if (applicationContext == null) {
            printLog(4, "Context is null. bugly initialize terminated.");
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            RMonitor.setProperty(107, applicationContext);
            RMonitor.setProperty(101, str);
            RMonitor.setProperty(100, str2);
            if (!TextUtils.isEmpty(str3)) {
                RMonitor.setProperty(103, str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                RMonitor.setProperty(109, str4);
            }
            if (!TextUtils.isEmpty(str5)) {
                RMonitor.setProperty(112, str5);
            }
            runTaskInUiThread(new Runnable() { // from class: com.tencent.bugly.agent.GameAgent.5
                @Override // java.lang.Runnable
                public void run() {
                    RMonitor.startMonitors((List<String>) Arrays.asList(strArr));
                }
            });
            return;
        }
        printLog(4, "Please input appId and appKey.");
    }

    protected static HashMap<String, String> parseExtraInfo(String str) {
        HashMap<String, String> hashMap = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            HashMap<String, String> hashMap2 = new HashMap<>();
            try {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    hashMap2.put(str2, jSONObject.getString(str2));
                }
                return hashMap2;
            } catch (Exception e16) {
                e = e16;
                hashMap = hashMap2;
                Log.w(LOG_TAG, "Failed to parse extra info. " + e);
                return hashMap;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    private static void postCocosJsException(final int i3, final String str, final String str2, final String str3, final boolean z16, final Map<String, String> map) {
        runTaskInUiThread(new Runnable() { // from class: com.tencent.bugly.agent.GameAgent.3
            @Override // java.lang.Runnable
            public void run() {
                InnerApi.postCocos2dxCrashAsync(i3, str, str2, str3, map);
                if (z16) {
                    GameAgent.delayExit(3000L);
                }
            }
        });
    }

    private static void postCocosLuaException(final int i3, String str, final String str2, String str3, final boolean z16, final Map<String, String> map) {
        final String str4;
        String str5;
        try {
            if (str3.startsWith("stack traceback")) {
                str3 = str3.substring(str3.indexOf("\n") + 1, str3.length()).trim();
            }
            int indexOf = str3.indexOf("\n");
            if (indexOf > 0) {
                str3 = str3.substring(indexOf + 1, str3.length());
            }
            int indexOf2 = str3.indexOf("\n");
            if (indexOf2 > 0) {
                str5 = str3.substring(0, indexOf2);
            } else {
                str5 = str3;
            }
            int indexOf3 = str5.indexOf("]:");
            if (str == null || str.length() == 0) {
                if (indexOf3 != -1) {
                    str = str5.substring(0, indexOf3 + 1);
                } else {
                    str = str2;
                }
            }
        } catch (Throwable unused) {
            if (str == null || str.length() == 0) {
                str4 = str2;
            }
        }
        str4 = str;
        final String str6 = str3;
        runTaskInUiThread(new Runnable() { // from class: com.tencent.bugly.agent.GameAgent.2
            @Override // java.lang.Runnable
            public void run() {
                InnerApi.postCocos2dxCrashAsync(i3, str4, str2, str6, map);
                if (z16) {
                    GameAgent.delayExit(3000L);
                }
            }
        });
    }

    public static void postException(int i3, String str, String str2, String str3, boolean z16) {
        postException(i3, str, str2, str3, null, z16);
    }

    private static void postUnityException(final String str, final String str2, final String str3, final boolean z16, final Map<String, String> map) {
        runTaskInUiThread(new Runnable() { // from class: com.tencent.bugly.agent.GameAgent.4
            @Override // java.lang.Runnable
            public void run() {
                InnerApi.postU3dCrashAsync(str, str2, str3, map);
                if (z16) {
                    GameAgent.delayExit(3000L);
                }
            }
        });
    }

    public static void printLog(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("<Log>")) {
            printLog(2, str);
            return;
        }
        if (str.startsWith("<LogDebug>")) {
            printLog(1, str);
            return;
        }
        if (str.startsWith("<LogInfo>")) {
            printLog(2, str);
            return;
        }
        if (str.startsWith("<LogWarning>")) {
            printLog(3, str);
            return;
        }
        if (str.startsWith("<LogAssert>")) {
            printLog(3, str);
            return;
        }
        if (str.startsWith("<LogError>")) {
            printLog(4, str);
        } else if (str.startsWith("<LogException>")) {
            printLog(4, str);
        } else {
            printLog(0, str);
        }
    }

    public static void putUserData(final String str, final String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            runTaskInUiThread(new Runnable() { // from class: com.tencent.bugly.agent.GameAgent.18
                @Override // java.lang.Runnable
                public void run() {
                    CrashReport.putUserData(GameAgent.getApplicationContext(), str, str2);
                }
            });
        }
    }

    public static void removeUserData(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        runTaskInUiThread(new Runnable() { // from class: com.tencent.bugly.agent.GameAgent.19
            @Override // java.lang.Runnable
            public void run() {
                CrashReport.removeUserData(GameAgent.getApplicationContext(), str);
            }
        });
    }

    protected static void runTaskInUiThread(Runnable runnable) {
        Activity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(runnable);
        } else {
            new BaseThread(runnable).start();
        }
    }

    public static void setAdditionalAttachmentPaths(final String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            runTaskInUiThread(new Runnable() { // from class: com.tencent.bugly.agent.GameAgent.16
                @Override // java.lang.Runnable
                public void run() {
                    CrashReport.setAdditionalAttachmentPaths(strArr);
                }
            });
        }
    }

    public static void setAppChannel(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        runTaskInUiThread(new Runnable() { // from class: com.tencent.bugly.agent.GameAgent.8
            @Override // java.lang.Runnable
            public void run() {
                CrashReport.setAppChannel(GameAgent.getApplicationContext(), str);
            }
        });
    }

    public static void setDeviceId(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        runTaskInUiThread(new Runnable() { // from class: com.tencent.bugly.agent.GameAgent.12
            @Override // java.lang.Runnable
            public void run() {
                CrashReport.setDeviceId(GameAgent.getApplicationContext(), str);
            }
        });
    }

    public static void setDeviceIdMonitor(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        runTaskInUiThread(new Runnable() { // from class: com.tencent.bugly.agent.GameAgent.13
            @Override // java.lang.Runnable
            public void run() {
                RMonitor.setProperty(106, str);
            }
        });
    }

    public static void setDeviceModel(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        runTaskInUiThread(new Runnable() { // from class: com.tencent.bugly.agent.GameAgent.14
            @Override // java.lang.Runnable
            public void run() {
                CrashReport.setDeviceModel(GameAgent.getApplicationContext(), str);
            }
        });
    }

    public static void setDeviceModelMonitor(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        runTaskInUiThread(new Runnable() { // from class: com.tencent.bugly.agent.GameAgent.15
            @Override // java.lang.Runnable
            public void run() {
                RMonitor.setProperty(113, str);
            }
        });
    }

    public static void setDumpFilePath(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        runTaskInUiThread(new Runnable() { // from class: com.tencent.bugly.agent.GameAgent.7
            @Override // java.lang.Runnable
            public void run() {
                CrashReport.setDumpFilePath(GameAgent.getApplicationContext(), str);
            }
        });
    }

    public static void setGameType(int i3) {
        sGameType = i3;
    }

    public static void setLog(int i3, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        BuglyLog.d(str, str2);
                        return;
                    } else {
                        BuglyLog.e(str, str2);
                        return;
                    }
                }
                BuglyLog.w(str, str2);
                return;
            }
            BuglyLog.i(str, str2);
            return;
        }
        BuglyLog.v(str, str2);
    }

    public static void setLogLevel(final int i3) {
        runTaskInUiThread(new Runnable() { // from class: com.tencent.bugly.agent.GameAgent.9
            @Override // java.lang.Runnable
            public void run() {
                RMonitor.setProperty(104, Integer.valueOf(i3));
            }
        });
    }

    public static void setQueryDelayTime(long j3) {
        delay = j3;
    }

    public static void setUserId(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        runTaskInUiThread(new Runnable() { // from class: com.tencent.bugly.agent.GameAgent.10
            @Override // java.lang.Runnable
            public void run() {
                CrashReport.setUserId(GameAgent.getApplicationContext(), str);
            }
        });
    }

    public static void setUserIdMonitor(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        runTaskInUiThread(new Runnable() { // from class: com.tencent.bugly.agent.GameAgent.11
            @Override // java.lang.Runnable
            public void run() {
                RMonitor.setProperty(102, str);
            }
        });
    }

    public static void setUserSceneTag(final int i3) {
        runTaskInUiThread(new Runnable() { // from class: com.tencent.bugly.agent.GameAgent.17
            @Override // java.lang.Runnable
            public void run() {
                CrashReport.setUserSceneTag(GameAgent.getApplicationContext(), i3);
            }
        });
    }

    public static void startMonitor(final String[] strArr) {
        runTaskInUiThread(new Runnable() { // from class: com.tencent.bugly.agent.GameAgent.20
            @Override // java.lang.Runnable
            public void run() {
                RMonitor.startMonitors((List<String>) Arrays.asList(strArr));
            }
        });
    }

    public static void stopMonitor(final String[] strArr) {
        runTaskInUiThread(new Runnable() { // from class: com.tencent.bugly.agent.GameAgent.21
            @Override // java.lang.Runnable
            public void run() {
                RMonitor.stopMonitors((List<String>) Arrays.asList(strArr));
            }
        });
    }

    public static void postException(int i3, String str, String str2, String str3, String str4, boolean z16) {
        HashMap<String, String> parseExtraInfo = parseExtraInfo(str4);
        if (i3 == 4) {
            postUnityException(str, str2, str3, z16, parseExtraInfo);
            return;
        }
        if (i3 == 5) {
            postCocosJsException(i3, str, str2, str3, z16, parseExtraInfo);
            return;
        }
        if (i3 != 6) {
            printLog(4, "The category of exception posted is unknown: " + String.valueOf(i3));
            return;
        }
        postCocosLuaException(i3, str, str2, str3, z16, parseExtraInfo);
    }

    private static void printLog(int i3, String str) {
        setLog(i3, LOG_TAG, str);
    }
}
