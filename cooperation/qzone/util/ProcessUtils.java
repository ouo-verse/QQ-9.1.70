package cooperation.qzone.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.Foreground;

/* loaded from: classes28.dex */
public class ProcessUtils {
    private static final String LOG_TAG = "ProcessUtils";
    private static List<String> homePackages = null;
    public static WeakReference<Activity> mQzoneTopActivityWeak = null;
    public static int qzoneTopActivityHashCode = 0;
    public static String qzoneTopActivityName = "";

    private static String getActivePackage() {
        Field field;
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo;
        Integer num;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
        if (QLog.isDevelopLevel()) {
            QLog.d(LOG_TAG, 4, "processInfos.size()=" + runningAppProcesses.size());
        }
        try {
            field = ActivityManager.RunningAppProcessInfo.class.getDeclaredField("processState");
        } catch (NoSuchFieldException e16) {
            QLog.w(LOG_TAG, 1, "NoSuchFieldException: processState", e16);
            field = null;
        }
        if (field != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (it.hasNext()) {
                runningAppProcessInfo = it.next();
                if (QLog.isDevelopLevel()) {
                    QLog.d(LOG_TAG, 4, "processInfo: processName=" + runningAppProcessInfo.processName + " importance=" + runningAppProcessInfo.importance + " importanceReasonCode=" + runningAppProcessInfo.importanceReasonCode);
                }
                if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.importanceReasonCode == 0) {
                    try {
                        num = Integer.valueOf(field.getInt(runningAppProcessInfo));
                    } catch (IllegalAccessException e17) {
                        QLog.w(LOG_TAG, 1, "IllegalAccessException", e17);
                        num = null;
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.d(LOG_TAG, 4, "processInfo: state=" + num);
                    }
                    if (num != null && num.intValue() == 2) {
                        break;
                    }
                }
            }
        }
        runningAppProcessInfo = null;
        if (QLog.isDevelopLevel()) {
            QLog.d(LOG_TAG, 4, "===============");
        }
        if (runningAppProcessInfo == null) {
            return null;
        }
        return runningAppProcessInfo.processName;
    }

    public static String getActivePackageCompat() {
        ComponentName componentName;
        ComponentName componentName2;
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getRunningTasks(1);
        if (runningTasks != null && runningTasks.get(0) != null) {
            componentName = runningTasks.get(0).topActivity;
            if (componentName != null) {
                componentName2 = runningTasks.get(0).topActivity;
                return componentName2.getPackageName() + "/" + componentName2.getClassName();
            }
            return null;
        }
        return null;
    }

    public static String getCurProcessName(Context context) {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
        if (runningAppProcesses == null) {
            QLog.e(LOG_TAG, 1, "getCurProcessName: processInfos is null.");
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    private static List<String> getHomes() {
        List<String> list = homePackages;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = BaseApplication.getContext().getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        Iterator<ResolveInfo> it = InstalledAppListMonitor.queryIntentActivities(packageManager, intent, 65536).iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().activityInfo.packageName);
        }
        homePackages = arrayList;
        return arrayList;
    }

    public static String getRunningProcessPackageName() {
        return getActivePackage();
    }

    public static Activity getTopActivity() {
        Activity activity;
        WeakReference<Activity> weakReference = mQzoneTopActivityWeak;
        if (weakReference == null) {
            activity = null;
        } else {
            activity = weakReference.get();
        }
        if (activity == null) {
            return Foreground.getTopActivity();
        }
        return activity;
    }

    public static int getTopActivityHashCode() {
        return qzoneTopActivityHashCode;
    }

    public static String getTopActivityName() {
        return qzoneTopActivityName;
    }

    public static boolean isH5(String str) {
        if (!TextUtils.isEmpty(str) && ("com.tencent.mobileqq:tool".equals(str) || "com.tencent.mobileqq/com.tencent.mobileqq.activity.QQBrowserActivity".equals(str))) {
            return true;
        }
        return false;
    }

    public static boolean isHome(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        List<String> homes = getHomes();
        if (homes.contains(str)) {
            return true;
        }
        String[] split = str.split("/");
        if (split.length < 2) {
            return false;
        }
        return homes.contains(split[0]);
    }

    public static boolean isPeak(String str) {
        if (!TextUtils.isEmpty(str) && ("com.tencent.mobileqq:peak".equals(str) || "com.tencent.mobileqq/com.tencent.mobileqq.activity.photo.PhotoListActivity".equals(str) || "com.tencent.mobileqq/com.tencent.mobileqq.activity.photo.AlbumListActivity".equals(str))) {
            return true;
        }
        return false;
    }

    public static boolean isPicture(String str) {
        if (!TextUtils.isEmpty(str) && "com.tencent.mobileqq:picture".equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean isQQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if ("com.tencent.mobileqq".equals(str)) {
            return true;
        }
        String[] split = str.split("/");
        if (split.length < 2 || !"com.tencent.mobileqq".equals(split[0]) || TextUtils.isEmpty(split[1])) {
            return false;
        }
        return true;
    }

    public static boolean isQzone(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if ("com.tencent.mobileqq:qzone".equals(str)) {
            return true;
        }
        String[] split = str.split("/");
        if (split.length < 2 || !"com.tencent.mobileqq".equals(split[0]) || TextUtils.isEmpty(split[1])) {
            return false;
        }
        String[] split2 = split[1].toLowerCase().split("\\.");
        if (split2.length <= 0 || !split2[split2.length - 1].startsWith("qzone") || !split2[split2.length - 1].endsWith("proxyactivity")) {
            return false;
        }
        return true;
    }

    public static boolean isQzoneLive(String str) {
        if (!TextUtils.isEmpty(str) && ("com.tencent.mobileqq:qzonelive".equals(str) || "com.tencent.mobileqq/cooperation.qzone.video.QzoneLiveVideoGpuProxyActivity".equals(str))) {
            return true;
        }
        return false;
    }

    public static void setTopActivity(Activity activity, String str) {
        WeakReference<Activity> weakReference = new WeakReference<>(activity);
        mQzoneTopActivityWeak = weakReference;
        qzoneTopActivityHashCode = weakReference.hashCode();
        qzoneTopActivityName = str;
    }
}
