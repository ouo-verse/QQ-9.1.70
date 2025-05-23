package kc0;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.biz.richframework.AutoShadowPluginRuntime;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final List<String> f412003a;

    static {
        ArrayList arrayList = new ArrayList();
        f412003a = arrayList;
        arrayList.add("com.tencent.mobileqq.activity.SplashActivity");
        arrayList.add("com.tencent.biz.qqcircle.activity.QCircleFolderActivity");
        arrayList.add("com.tencent.biz.qqcircle.activity.QCircleFragmentActivity");
        arrayList.add("com.tencent.biz.qqcircle.activity.QCircleTransFragmentActivity");
        arrayList.add("com.tencent.biz.qcircleshadow.local.activity.QCircleDefaultProxyActivity");
        arrayList.add("com.tencent.biz.qcircleshadow.local.activity.QCircleTransProxyActivity");
        arrayList.add("com.tencent.biz.qcircleshadow.local.activity.QCircleDefaultSingleTaskProxyActivity");
        arrayList.add("cooperation.qzone.video.QzoneVerticalVideoGpuProxyActivity");
    }

    public static String a() {
        ActivityManager activityManager;
        String processName;
        if (Build.VERSION.SDK_INT >= 28) {
            processName = Application.getProcessName();
            return processName;
        }
        Application application = AutoShadowPluginRuntime.getInstance().getApplication();
        if (application == null) {
            QLog.e("QFSRuntimeUtil", 1, "getCurrentProcessName: app is empty");
            return null;
        }
        try {
            activityManager = (ActivityManager) application.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        } catch (Exception e16) {
            QLog.e("QFSRuntimeUtil", 1, "getCurrentProcessName:" + e16);
        }
        if (activityManager == null) {
            QLog.e("QFSRuntimeUtil", 1, "getCurrentProcessName: manager is null");
            return null;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager);
        if (runningAppProcesses == null) {
            QLog.e("QFSRuntimeUtil", 1, "getCurrentProcessName: runningApps is null");
            return null;
        }
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public static boolean b() {
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager == null) {
            return true;
        }
        return guardManager.isApplicationForeground();
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches("com.tencent.mobileqq.[\\s\\S]*SplashActivity", str);
    }

    @Deprecated
    public static boolean d() {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ComponentName componentName;
        Application application = AutoShadowPluginRuntime.getInstance().getApplication();
        if (application == null) {
            QLog.d("QFSRuntimeUtil", 1, "isInQCircleNew: app is empty");
            return false;
        }
        try {
            ActivityManager activityManager = (ActivityManager) application.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && runningTasks.size() > 0) {
                componentName = runningTasks.get(0).topActivity;
                String className = componentName.getClassName();
                if (!"com.tencent.mobileqq.activity.SplashActivity".equals(className) && !c(className)) {
                    return f412003a.contains(className);
                }
                return g();
            }
            return false;
        } catch (Exception e16) {
            QLog.d("QFSRuntimeUtil", 1, "isInQCircle:" + e16);
            return false;
        }
    }

    public static boolean e(String str) {
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager == null) {
            return true;
        }
        return guardManager.isProcessForeground(str);
    }

    public static boolean f(String str) {
        if (!f412003a.contains(str) && !c(str)) {
            return false;
        }
        return true;
    }

    public static boolean g() {
        if (ASInject.g().getAsEngineDelegate() != null) {
            return ASInject.g().getAsEngineDelegate().isOnThirdTab(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE);
        }
        return false;
    }
}
