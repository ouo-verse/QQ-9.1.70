package com.tencent.luggage.wxa.x8;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.tencent.luggage.wxa.aa.j;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f144646a;

    public static boolean a(int i3) {
        return i3 >= 100 && i3 <= 120;
    }

    public static PendingIntent b(Context context, int i3, int i16, long j3, Intent intent, int i17) {
        return b(context, i3, i16, j3, intent, i17, true);
    }

    public static PendingIntent a(Context context, int i3, int i16, long j3, Intent intent, int i17) {
        return a(context, i3, i16, j3, intent, i17, true);
    }

    public static PendingIntent b(Context context, int i3, int i16, long j3, Intent intent, int i17, boolean z16) {
        PendingIntent activity;
        boolean canScheduleExactAlarms;
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(i16);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Long.valueOf(j3);
        objArr[3] = intent != null ? intent : "null";
        objArr[4] = Integer.valueOf(i17);
        objArr[5] = a();
        w.d("MicroMsg.AlarmHelper", "setExact(type:%s requestCode:%s triggerAtMillis:%s intent:%s flags:%s stack:%s)", objArr);
        f144646a++;
        if (context == null) {
            w.b("MicroMsg.AlarmHelper", "setExact(requestCode:%s): context == null", Integer.valueOf(i3));
            return null;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager == null) {
            w.b("MicroMsg.AlarmHelper", "setExact(requestCode:%s): am == null", Integer.valueOf(i3));
            return null;
        }
        if (!a(i3)) {
            w.b("MicroMsg.AlarmHelper", "setExact(requestCode:%s): requestCode invalid", Integer.valueOf(i3));
            return null;
        }
        if (z16) {
            activity = PendingIntent.getBroadcast(context, i3, intent, j.a(i17));
        } else {
            activity = PendingIntent.getActivity(context, i3, intent, j.a(i17));
        }
        try {
            if (Build.VERSION.SDK_INT >= 31 && context.getApplicationInfo().targetSdkVersion >= 31) {
                canScheduleExactAlarms = alarmManager.canScheduleExactAlarms();
                if (canScheduleExactAlarms) {
                    alarmManager.setExact(i16, j3, activity);
                } else {
                    alarmManager.set(i16, j3, activity);
                    w.f("MicroMsg.AlarmHelper", "disable setExact");
                }
            } else {
                alarmManager.setExact(i16, j3, activity);
            }
        } catch (Exception e16) {
            w.b("MicroMsg.AlarmHelper", "setExact Exception:%s %s", e16.getClass().getSimpleName(), e16.getMessage());
        }
        return activity;
    }

    public static PendingIntent a(Context context, int i3, int i16, long j3, Intent intent, int i17, boolean z16) {
        PendingIntent activity;
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(i16);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Long.valueOf(j3);
        objArr[3] = intent != null ? intent : "null";
        objArr[4] = Integer.valueOf(i17);
        objArr[5] = a();
        w.d("MicroMsg.AlarmHelper", "set(type:%s requestCode:%s triggerAtMillis:%s intent:%s flags:%s stack:%s)", objArr);
        if (context == null) {
            w.b("MicroMsg.AlarmHelper", "set(requestCode:%s): context == null", Integer.valueOf(i3));
            return null;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager == null) {
            w.b("MicroMsg.AlarmHelper", "set(requestCode:%s): am == null", Integer.valueOf(i3));
            return null;
        }
        if (!a(i3)) {
            w.b("MicroMsg.AlarmHelper", "set(requestCode:%s): requestCode invalid", Integer.valueOf(i3));
            return null;
        }
        if (z16) {
            activity = PendingIntent.getBroadcast(context, i3, intent, j.a(i17));
        } else {
            activity = PendingIntent.getActivity(context, i3, intent, j.a(i17));
        }
        try {
            alarmManager.set(i16, j3, activity);
        } catch (Exception e16) {
            w.b("MicroMsg.AlarmHelper", "set Exception:%s %s", e16.getClass().getSimpleName(), e16.getMessage());
        }
        return activity;
    }

    public static void a(Context context, int i3, PendingIntent pendingIntent) {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i3);
        objArr[1] = pendingIntent != null ? "no null" : "null";
        w.d("MicroMsg.AlarmHelper", "cancel(requestCode:%s operation:%s)", objArr);
        if (context == null) {
            w.b("MicroMsg.AlarmHelper", "cancel(requestCode:%s): context == null", Integer.valueOf(i3));
            return;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager == null) {
            w.b("MicroMsg.AlarmHelper", "cancel(requestCode:%s): am == null", Integer.valueOf(i3));
            return;
        }
        try {
            alarmManager.cancel(pendingIntent);
        } catch (Exception e16) {
            w.b("MicroMsg.AlarmHelper", "cancel Exception:%s %s", e16.getClass().getSimpleName(), e16.getMessage());
        }
    }

    public static String a() {
        return w0.b().toString();
    }
}
