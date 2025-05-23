package com.tencent.bugly.library;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.BuildConfigWrapper;
import com.tencent.bugly.common.utils.ProcessUtil;
import com.tencent.bugly.impl.BuglyInitializer;
import com.tencent.bugly.impl.FPSCallbackWrapper;
import com.tencent.feedback.eup.a;
import com.tencent.rmonitor.RMonitorProxy;
import com.tencent.rmonitor.base.plugin.listener.ICustomDataCollector;
import com.tencent.rmonitor.base.plugin.listener.ICustomDataCollectorForIssue;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.rmonitor.memory.leakdetect.MemoryLeakInspector;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class Bugly implements BuglyConstants {
    private static FPSCallbackWrapper callbackWrapper;

    public static void abolishPerformanceMonitors() {
        if (!RMonitorProxy.isInitOk()) {
            Log.e(BuglyConstants.TAG, "abolish monitors failed, pls init monitor first!");
        } else {
            RMonitorProxy.abolish();
        }
    }

    public static void addCustomDataCollector(ICustomDataCollector iCustomDataCollector) {
        if (!RMonitorProxy.isInitOk()) {
            Log.e(BuglyConstants.TAG, "add custom data collector failed, pls init monitor first!");
        } else {
            RMonitorProxy.addProperty(216, iCustomDataCollector);
        }
    }

    public static void enterScene(String str) {
        if (!RMonitorProxy.isInitOk()) {
            Log.e(BuglyConstants.TAG, "enter scene failed, pls init monitor first!");
        } else {
            RMonitorProxy.enterScene(str);
        }
    }

    public static void exitScene(String str) {
        if (!RMonitorProxy.isInitOk()) {
            Log.e(BuglyConstants.TAG, "exit scene failed, pls init monitor first!");
        } else {
            RMonitorProxy.exitScene(str);
        }
    }

    public static ICustomDataEditor getGlobalCustomDataEditor() {
        if (!RMonitorProxy.isInitOk()) {
            Log.e(BuglyConstants.TAG, "get global custom data editor failed, pls init monitor first!");
            return null;
        }
        return RMonitorProxy.getGlobalCustomDataEditor();
    }

    public static boolean handleCatchException(Thread thread, Throwable th5, String str, byte[] bArr, boolean z16) {
        if (!a.g()) {
            Log.e(BuglyConstants.TAG, "handle catch exception failed, pls init monitor first!");
            return false;
        }
        return a.e(thread, th5, str, bArr, z16);
    }

    public static boolean init(Context context, BuglyBuilder buglyBuilder) {
        return init(context, buglyBuilder, ProcessUtil.isMainProcess(context));
    }

    public static void postException(Thread thread, int i3, String str, String str2, String str3, Map<String, String> map) {
        if (!a.g()) {
            Log.e(BuglyConstants.TAG, "post Exception failed, pls init monitor first!");
        } else {
            a.h(thread, i3, str, str2, str3, map);
        }
    }

    public static void putUserData(Context context, String str, String str2) {
        if (!a.g()) {
            Log.e(BuglyConstants.TAG, "put user data failed, pls init monitor first!");
        } else {
            a.i(context, str, str2);
        }
    }

    public static boolean reRegisterHandler() {
        if (a.g() && RMonitorProxy.isInitOk()) {
            return a.j();
        }
        Log.e(BuglyConstants.TAG, "reRegisterHandler failed, pls init monitor first!");
        return false;
    }

    public static void removeCustomDataCollector(ICustomDataCollector iCustomDataCollector) {
        if (!RMonitorProxy.isInitOk()) {
            Log.e(BuglyConstants.TAG, "remove custom data collector failed, pls init monitor first!");
        } else {
            RMonitorProxy.removeProperty(216, iCustomDataCollector);
        }
    }

    public static String removeUserData(Context context, String str) {
        if (!a.g()) {
            Log.e(BuglyConstants.TAG, "remove user data failed, pls init monitor first!");
            return null;
        }
        return a.k(context, str);
    }

    public static boolean setAdditionalAttachmentPaths(String[] strArr) {
        if (!a.g()) {
            Log.e(BuglyConstants.TAG, "set additional attachment paths failed, pls init monitor first!");
            return false;
        }
        return a.m(strArr);
    }

    public static void setCaseLabels(String str) {
        if (!a.g()) {
            Log.e(BuglyConstants.TAG, "set case labels fail, pls init bugly first!");
        } else {
            a.q(str);
        }
    }

    public static void setCrashMonitorAble(int i3, boolean z16) {
        if (!a.g()) {
            Log.e(BuglyConstants.TAG, "set crash monitor able failed, pls init monitor first!");
            return;
        }
        switch (i3) {
            case 100:
                a.v(z16);
                return;
            case 101:
                a.w(z16);
                return;
            case 102:
                a.l(z16);
                return;
            default:
                Log.e(BuglyConstants.TAG, "Crash monitor able set failed, please check crash type.");
                return;
        }
    }

    public static void setMonitorCallback(String str, MonitorCallback monitorCallback) {
        if ("fps".equals(str)) {
            FPSCallbackWrapper fPSCallbackWrapper = callbackWrapper;
            if (fPSCallbackWrapper == null) {
                fPSCallbackWrapper = new FPSCallbackWrapper();
                callbackWrapper = fPSCallbackWrapper;
            }
            fPSCallbackWrapper.setCallback(monitorCallback);
        }
    }

    public static void setPerformanceMonitorAble(String str, boolean z16) {
        if (!RMonitorProxy.isInitOk()) {
            Log.e(BuglyConstants.TAG, "set performance monitors able failed, pls init monitor first!");
        } else if (z16) {
            RMonitorProxy.startMonitor(str);
        } else {
            RMonitorProxy.stopMonitor(str);
        }
    }

    public static void setPerformanceMonitorsAble(List<String> list, boolean z16) {
        if (!RMonitorProxy.isInitOk()) {
            Log.e(BuglyConstants.TAG, "set performance monitors able failed, pls init monitor first!");
        } else if (z16) {
            RMonitorProxy.startMonitors(list);
        } else {
            RMonitorProxy.stopMonitors(list);
        }
    }

    public static void setTestLabels(String str) {
        if (!a.g()) {
            Log.e(BuglyConstants.TAG, "set test labels fail, pls init bugly first!");
        } else {
            a.B(str);
        }
    }

    public static void setUserInfoReportOpt(boolean z16) {
        if (a.g() && RMonitorProxy.isInitOk()) {
            a.D(z16);
        } else {
            Log.e(BuglyConstants.TAG, "setUserInfoReportOpt failed, pls init monitor first!");
        }
    }

    public static void startInspectLeakObj(Object obj) {
        if (!RMonitorProxy.isInitOk()) {
            Log.e(BuglyConstants.TAG, "start inspect leak obj failed, pls init monitor first!");
        } else {
            MemoryLeakInspector.l(obj, new h14.a());
        }
    }

    public static void testCrash(int i3) {
        if (!a.g()) {
            Log.e(BuglyConstants.TAG, "test crash failed, pls init monitor first!");
            return;
        }
        switch (i3) {
            case 100:
                a.F();
                return;
            case 101:
                a.G(false, true, false);
                return;
            case 102:
                a.E();
                return;
            default:
                Log.e(BuglyConstants.TAG, "test crash failed, please check crash type.");
                return;
        }
    }

    public static void updateDeviceModel(Context context, String str) {
        if (a.g() && RMonitorProxy.isInitOk()) {
            a.u(context, str);
            RMonitorProxy.setProperty(113, str);
        } else {
            Log.e(BuglyConstants.TAG, "update device model failed, pls init monitor first!");
        }
    }

    public static void updateLogLevel(int i3) {
        if (!RMonitorProxy.isInitOk()) {
            Log.e(BuglyConstants.TAG, "update log level failed, pls init monitor first!");
        } else {
            RMonitorProxy.setProperty(104, Integer.valueOf(i3));
        }
    }

    public static void updateUniqueId(Context context, String str) {
        if (a.g() && RMonitorProxy.isInitOk()) {
            a.t(context, str);
            RMonitorProxy.setProperty(106, str);
        } else {
            Log.e(BuglyConstants.TAG, "update unique id failed, pls init monitor first!");
        }
    }

    public static void updateUserId(Context context, String str) {
        if (a.g() && RMonitorProxy.isInitOk()) {
            a.C(context, str);
            RMonitorProxy.setProperty(102, str);
        } else {
            Log.e(BuglyConstants.TAG, "update user id failed, pls init monitor first!");
        }
    }

    public static boolean init(Context context, BuglyBuilder buglyBuilder, boolean z16) {
        if (buglyBuilder == null) {
            Log.e(BuglyConstants.TAG, "Bugly init failed, please make sure Bugly builder not null.");
            return false;
        }
        if (!TextUtils.isEmpty(buglyBuilder.serverHostType)) {
            BuildConfigWrapper.setDomain(buglyBuilder.serverHostType);
        }
        BuglyInitializer.init(context, buglyBuilder);
        a.x(context, buglyBuilder.appVersion);
        a.C(context, buglyBuilder.userId);
        a.t(context, buglyBuilder.uniqueId);
        a.z(buglyBuilder.buildNumber);
        a.u(context, buglyBuilder.deviceModel);
        a.n(context, buglyBuilder.enableAllThreadStackCrash, buglyBuilder.enableAllThreadStackAnr);
        a.f(context, buglyBuilder.appId, buglyBuilder.debugMode, buglyBuilder.StrategyBean(), 0L);
        a.o(context, buglyBuilder.appChannel);
        a.p(buglyBuilder.hotPatchNum);
        RMonitorProxy.disableAutoStartMetricAndSla();
        RMonitorProxy.setProperty(107, context);
        RMonitorProxy.setProperty(100, buglyBuilder.appKey);
        RMonitorProxy.setProperty(101, buglyBuilder.appId);
        RMonitorProxy.setProperty(103, buglyBuilder.appVersion);
        RMonitorProxy.setProperty(109, buglyBuilder.buildNumber);
        RMonitorProxy.setProperty(102, buglyBuilder.userId);
        RMonitorProxy.setProperty(106, buglyBuilder.uniqueId);
        RMonitorProxy.setProperty(113, buglyBuilder.deviceModel);
        RMonitorProxy.setProperty(104, Integer.valueOf(buglyBuilder.logLevel));
        RMonitorProxy.setProperty(112, buglyBuilder.appVersionType);
        RMonitorProxy.setProperty(214, Boolean.valueOf(buglyBuilder.enableCrashProtect));
        RMonitorProxy.setProperty(111, buglyBuilder.spProvider);
        List<String> monitorList = buglyBuilder.getMonitorList();
        if (z16) {
            monitorList.remove(BuglyMonitorName.MEMORY_METRIC_OF_SUB_PROCESS);
        } else {
            monitorList.remove(BuglyMonitorName.MEMORY_METRIC);
        }
        RMonitorProxy.startMonitors(monitorList);
        return a.g() && RMonitorProxy.isInitOk();
    }

    public static void addCustomDataCollector(ICustomDataCollectorForIssue iCustomDataCollectorForIssue) {
        if (!RMonitorProxy.isInitOk()) {
            Log.e(BuglyConstants.TAG, "add custom data collector failed, pls init monitor first!");
        } else {
            RMonitorProxy.addProperty(217, iCustomDataCollectorForIssue);
        }
    }

    public static boolean handleCatchException(Thread thread, Throwable th5, String str, byte[] bArr) {
        if (!a.g()) {
            Log.e(BuglyConstants.TAG, "handle catch exception failed, pls init monitor first!");
            return false;
        }
        return a.e(thread, th5, str, bArr, true);
    }

    public static void postException(int i3, String str, String str2, String str3, Map<String, String> map) {
        if (!a.g()) {
            Log.e(BuglyConstants.TAG, "post Exception failed, pls init monitor first!");
        } else {
            a.h(Thread.currentThread(), i3, str, str2, str3, map);
        }
    }

    public static void removeCustomDataCollector(ICustomDataCollectorForIssue iCustomDataCollectorForIssue) {
        if (!RMonitorProxy.isInitOk()) {
            Log.e(BuglyConstants.TAG, "remove custom data collector failed, pls init monitor first!");
        } else {
            RMonitorProxy.removeProperty(217, iCustomDataCollectorForIssue);
        }
    }
}
