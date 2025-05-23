package com.tencent.bugly.agent;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.launch.AppLaunchProxy;
import com.tencent.bugly.library.Bugly;
import com.tencent.bugly.library.BuglyBuilder;
import com.tencent.bugly.library.BuglyConstants;
import com.tencent.feedback.eup.CrashHandleListener;

/* loaded from: classes5.dex */
public class GameAgentPro {
    private static CrashHandleListener crashHandleListener;

    public static void initAgent(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z16, int i3, String[] strArr) {
        Context applicationContext = GameAgent.getApplicationContext();
        if (applicationContext == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        GameAgent.sHandler = new Handler(Looper.getMainLooper());
        BuglyBuilder buglyBuilder = new BuglyBuilder(str, str2);
        if (!TextUtils.isEmpty(str3)) {
            buglyBuilder.appVersion = str3;
        }
        if (!TextUtils.isEmpty(str4)) {
            buglyBuilder.buildNumber = str4;
        }
        if (!TextUtils.isEmpty(str5)) {
            buglyBuilder.uniqueId = str5;
        }
        if (!TextUtils.isEmpty(str6)) {
            buglyBuilder.userId = str6;
        }
        if (!TextUtils.isEmpty(str7)) {
            buglyBuilder.deviceModel = str7;
        }
        if (!TextUtils.isEmpty(str8)) {
            buglyBuilder.appVersionType = str8;
        }
        if (!TextUtils.isEmpty(str9)) {
            buglyBuilder.appChannel = str9;
        }
        buglyBuilder.debugMode = z16;
        buglyBuilder.logLevel = i3;
        if (strArr != null) {
            for (String str10 : strArr) {
                buglyBuilder.addMonitor(str10);
            }
        }
        CrashHandleListener crashHandleListener2 = crashHandleListener;
        if (crashHandleListener2 != null) {
            buglyBuilder.setCrashHandleListener(crashHandleListener2);
        }
        Bugly.init(applicationContext, buglyBuilder);
    }

    public static void launchAddTagAgent(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AppLaunchProxy.getAppLaunch().addTag(str);
    }

    public static void launchSpanEndAgent(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AppLaunchProxy.getAppLaunch().spanEnd(str);
    }

    public static void launchSpanStartAgent(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AppLaunchProxy.getAppLaunch().spanStart(str, str2);
    }

    public static void postExceptionAgent(int i3, String str, String str2, String str3, boolean z16) {
        if (str != null && str2 != null && str3 != null) {
            Bugly.postException(i3, str, str2, str3, null);
            if (z16) {
                GameAgent.delayExit(3000L);
            }
        }
    }

    public static void putUserDataAgent(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Bugly.putUserData(GameAgent.getApplicationContext(), str, str2);
        }
    }

    public static void reportAppFullLaunchAgent() {
        AppLaunchProxy.getAppLaunch().reportAppFullLaunch();
    }

    public static void setAdditionalAttachmentPathsAgent(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            Log.i(BuglyConstants.TAG, "set additional attachment " + Bugly.setAdditionalAttachmentPaths(strArr));
        }
    }

    public static void setCrashHandlerListenerAgent(CrashHandleListener crashHandleListener2) {
        crashHandleListener = crashHandleListener2;
    }

    public static void setGameType(int i3) {
        GameAgent.setGameType(i3);
    }

    public static void startInspectLeakObjAgent(Object obj) {
        if (obj == null) {
            return;
        }
        Bugly.startInspectLeakObj(obj);
    }

    public static void updateLogLevelAgent(int i3) {
        Bugly.updateLogLevel(i3);
    }

    public static void updateUniqueIdAgent(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bugly.updateUniqueId(GameAgent.getApplicationContext(), str);
    }

    public static void updateUserIdAgent(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bugly.updateUserId(GameAgent.getApplicationContext(), str);
    }
}
