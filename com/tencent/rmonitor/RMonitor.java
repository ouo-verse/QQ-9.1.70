package com.tencent.rmonitor;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.text.TextUtils;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin;
import com.tencent.rmonitor.base.plugin.monitor.RMonitorPlugin;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.g;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RMonitor implements RMonitorConstants {
    private static final String TAG = "RMonitor_manager_sdk";
    private static DebugInterface debugInterface;

    public static void abolish() {
        RMonitorProxy.abolish();
    }

    public static boolean addProperty(int i3, Object obj) {
        return RMonitorProxy.addProperty(i3, obj);
    }

    @Deprecated
    public static boolean beginScene(String str, int i3) {
        if (!isInitOk()) {
            Logger.f365497g.e(TAG, "beginScene sceneName[" + str + "] fail for ", g.c());
            return false;
        }
        Logger.f365497g.d(TAG, String.format("beginScene, sceneName: %s, mode: %s", str, Integer.valueOf(i3)));
        enterScene(str);
        String b16 = b.b(i3);
        if (TextUtils.equals(b16, BuglyMonitorName.FLUENCY_METRIC) && !RMonitorProxy.f365249s.contains(b16)) {
            startMonitor(b16);
        }
        return true;
    }

    @Deprecated
    public static boolean endScene(String str, int i3) {
        if (!isInitOk()) {
            Logger.f365497g.e(TAG, "endScene sceneName[" + str + "] fail for ", g.c());
            return false;
        }
        if (Logger.verbos) {
            Logger.f365497g.v(TAG, String.format("endScene, sceneName: %s, mode: %s", str, Integer.valueOf(i3)));
        }
        exitScene(str);
        return true;
    }

    public static void enterScene(String str) {
        RMonitorProxy.enterScene(str);
    }

    public static void exitScene(String str) {
        RMonitorProxy.exitScene(str);
    }

    public static DebugInterface getDebugInterface(Activity activity) {
        if (DebugInterfaceProxy.b(activity)) {
            if (debugInterface == null) {
                debugInterface = new DebugInterfaceProxy();
            }
            return debugInterface;
        }
        return null;
    }

    public static ICustomDataEditor getGlobalCustomDataEditor() {
        return RMonitorProxy.getGlobalCustomDataEditor();
    }

    public static String getUserData(String str) {
        return RMonitorProxy.getUserData(str);
    }

    public static boolean isInitOk() {
        return RMonitorProxy.isInitOk();
    }

    @Deprecated
    public static boolean isMonitorResume(int i3) {
        return isMonitorResume(b.b(i3));
    }

    @Deprecated
    public static boolean isPluginRunning(int i3) {
        return isPluginRunning(a.a(i3));
    }

    @Deprecated
    public static void pauseMonitor(int i3) {
        pauseMonitor(b.b(i3));
    }

    public static boolean putUserData(String str, String str2) {
        return RMonitorProxy.putUserData(str, str2);
    }

    public static boolean removeProperty(int i3, Object obj) {
        return RMonitorProxy.removeProperty(i3, obj);
    }

    public static String removeUserData(String str) {
        return RMonitorProxy.removeUserData(str);
    }

    @Deprecated
    public static void resumeMonitor(int i3) {
        resumeMonitor(b.b(i3));
    }

    public static boolean setForkDumpModeOnly(boolean z16) {
        return g.e(z16);
    }

    public static boolean setProperty(int i3, String str) {
        return RMonitorProxy.setProperty(i3, str);
    }

    public static void startMonitor(String str) {
        RMonitorProxy.startMonitor(str);
    }

    public static void startMonitors(List<String> list) {
        RMonitorProxy.startMonitors(list);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Deprecated
    public static void stopDisabledPlugins() {
        if (!isInitOk()) {
            Logger.f365497g.e(TAG, "stopDisabledPlugins fail for ", g.c());
        } else {
            Logger.f365497g.i(TAG, "stopDisabledPlugins");
            Magnifier.e();
        }
    }

    public static void stopMonitor(String str) {
        RMonitorProxy.stopMonitor(str);
    }

    public static void stopMonitors(List<String> list) {
        RMonitorProxy.stopMonitors(list);
    }

    public static boolean isMonitorResume(String str) {
        QAPMMonitorPlugin b16 = Magnifier.b(str, false);
        if (b16 instanceof RMonitorPlugin) {
            return ((RMonitorPlugin) b16).isResume();
        }
        return false;
    }

    public static boolean isPluginRunning(String str) {
        if (!isInitOk()) {
            return false;
        }
        QAPMMonitorPlugin b16 = Magnifier.b(str, false);
        if (b16 instanceof RMonitorPlugin) {
            return ((RMonitorPlugin) b16).isRunning();
        }
        return false;
    }

    public static void pauseMonitor(String str) {
        QAPMMonitorPlugin b16 = Magnifier.b(str, false);
        if (b16 instanceof RMonitorPlugin) {
            ((RMonitorPlugin) b16).pause();
        }
    }

    public static void resumeMonitor(String str) {
        QAPMMonitorPlugin b16 = Magnifier.b(str, false);
        if (b16 instanceof RMonitorPlugin) {
            ((RMonitorPlugin) b16).resume();
        }
    }

    public static boolean setProperty(int i3, @Nullable Object obj) {
        return RMonitorProxy.setProperty(i3, obj);
    }

    @Deprecated
    public static void startMonitors(int i3) {
        startMonitors(b.c(i3));
    }

    @Deprecated
    public static void stopMonitors(int i3) {
        stopMonitors(b.c(i3));
    }
}
