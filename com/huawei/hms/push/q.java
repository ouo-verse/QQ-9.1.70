package com.huawei.hms.push;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.support.log.HMSLog;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.util.Date;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class q {
    public static String a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128)).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.i("PushSelfShowLog", "get the app name of package:" + str + " failed.");
            return null;
        }
    }

    public static Intent b(Context context, String str) {
        try {
            return InstalledAppListMonitor.getLaunchIntentForPackage(context.getPackageManager(), str);
        } catch (Exception unused) {
            HMSLog.w("PushSelfShowLog", str + " not have launch activity");
            return null;
        }
    }

    public static boolean c() {
        return true;
    }

    public static boolean d() {
        if (Build.VERSION.SDK_INT >= 30) {
            return true;
        }
        return false;
    }

    public static boolean e() {
        return true;
    }

    public static boolean c(Context context, String str) {
        if (context != null && str != null && !"".equals(str)) {
            try {
                if (context.getPackageManager().getApplicationInfo(str, 8192) == null) {
                    return false;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                sb5.append(" is installed");
                HMSLog.d("PushSelfShowLog", sb5.toString());
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static int b() {
        return c() ? 67108864 : 134217728;
    }

    public static Boolean a(Context context, String str, Intent intent) {
        try {
            List<ResolveInfo> queryIntentActivities = InstalledAppListMonitor.queryIntentActivities(context.getPackageManager(), intent, 0);
            if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                int size = queryIntentActivities.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (queryIntentActivities.get(i3).activityInfo != null && str.equals(queryIntentActivities.get(i3).activityInfo.applicationInfo.packageName)) {
                        return Boolean.TRUE;
                    }
                }
            }
        } catch (Exception e16) {
            HMSLog.e("PushSelfShowLog", e16.toString(), e16);
        }
        return Boolean.FALSE;
    }

    public static long a(String str) {
        if (str == null) {
            str = "";
        }
        try {
            Date date = new Date();
            int hours = (date.getHours() * 2) + (date.getMinutes() / 30);
            String concat = str.concat(str);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("startIndex is ");
            sb5.append(hours);
            sb5.append(",ap is:");
            sb5.append(concat);
            sb5.append(",length is:");
            sb5.append(concat.length());
            HMSLog.i("PushSelfShowLog", sb5.toString());
            int length = concat.length();
            for (int i3 = hours; i3 < length; i3++) {
                if (concat.charAt(i3) != '0') {
                    long minutes = (((i3 - hours) * 30) - (date.getMinutes() % 30)) * 60000;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("startIndex is:");
                    sb6.append(hours);
                    sb6.append(" i is:");
                    sb6.append(i3);
                    sb6.append(" delay:");
                    sb6.append(minutes);
                    HMSLog.d("PushSelfShowLog", sb6.toString());
                    if (minutes >= 0) {
                        return minutes;
                    }
                    return 0L;
                }
            }
        } catch (Exception e16) {
            HMSLog.e("PushSelfShowLog", "error ", e16);
        }
        return 0L;
    }

    public static void a(Context context, Intent intent, long j3) {
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("enter setAPDelayAlarm(interval:");
            sb5.append(j3);
            sb5.append("ms.");
            HMSLog.d("PushSelfShowLog", sb5.toString());
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (alarmManager != null) {
                alarmManager.set(0, System.currentTimeMillis() + j3, PendingIntent.getBroadcast(context, (int) (System.currentTimeMillis() / 1000), intent, b()));
            }
        } catch (Exception e16) {
            HMSLog.w("PushSelfShowLog", "set DelayAlarm error" + e16.toString());
        }
    }

    public static boolean a(Context context) {
        return "com.huawei.hwid".equals(context.getPackageName());
    }

    public static void a(Context context, int i3) {
        if (context == null) {
            HMSLog.e("PushSelfShowLog", "context is null");
            return;
        }
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.cancel(i3);
            }
        } catch (Exception e16) {
            HMSLog.e("PushSelfShowLog", "removeNotifiCationById err:" + e16.toString());
        }
    }

    public static void a(Context context, Intent intent) {
        try {
            int intExtra = intent.getIntExtra("selfshow_auto_clear_id", 0);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("setDelayAlarm(cancel) alarmNotityId ");
            sb5.append(intExtra);
            HMSLog.d("PushSelfShowLog", sb5.toString());
            if (intExtra == 0) {
                return;
            }
            Intent intent2 = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
            intent2.setPackage(context.getPackageName()).setFlags(32);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, intExtra, intent2, a());
            if (broadcast != null && alarmManager != null) {
                HMSLog.d("PushSelfShowLog", "alarm cancel");
                alarmManager.cancel(broadcast);
            } else {
                HMSLog.d("PushSelfShowLog", "alarm not exist");
            }
        } catch (Exception e16) {
            HMSLog.e("PushSelfShowLog", "cancelAlarm err:" + e16.toString());
        }
    }

    public static int a() {
        return d() ? 603979776 : 536870912;
    }
}
