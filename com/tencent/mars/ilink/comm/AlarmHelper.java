package com.tencent.mars.ilink.comm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.tencent.mars.ilink.xlog.Log;

/* compiled from: P */
/* loaded from: classes9.dex */
public class AlarmHelper {
    private static final String TAG = "MicroMsg.AlarmHelper";

    public static void cancel(Context context, PendingIntent pendingIntent) {
        Object[] objArr = new Object[1];
        objArr[0] = pendingIntent != null ? pendingIntent.toString() : "null";
        Log.d(TAG, "cancel(operation:%s)", objArr);
        if (context == null) {
            Log.e(TAG, "cancel: context == null");
            return;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager == null) {
            Log.e(TAG, "cancel: am == null");
        } else {
            alarmManager.cancel(pendingIntent);
        }
    }

    public static PendingIntent getPendingIntent(Context context, int i3, Intent intent, int i16) {
        Object obj;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i3);
        if (intent != null) {
            obj = intent;
        } else {
            obj = "null";
        }
        objArr[1] = obj;
        objArr[2] = Integer.valueOf(i16);
        Log.d(TAG, "getPendingIntent(requestCode:%s intent:%s flags:%s)", objArr);
        if (context == null) {
            Log.e(TAG, "getPendingIntent(requestCode:%s): context == null", Integer.valueOf(i3));
            return null;
        }
        if (!isRequestCodeValid(i3)) {
            Log.e(TAG, "getPendingIntent(requestCode:%s): requestCode invalid", Integer.valueOf(i3));
            return null;
        }
        return PendingIntent.getBroadcast(context, i3, intent, i16);
    }

    private static boolean isRequestCodeValid(int i3) {
        if (i3 >= 100 && i3 <= 119) {
            return true;
        }
        return false;
    }

    public static PendingIntent set(Context context, int i3, int i16, long j3, Intent intent, int i17) {
        Object obj;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i16);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Long.valueOf(j3);
        if (intent != null) {
            obj = intent;
        } else {
            obj = "null";
        }
        objArr[3] = obj;
        objArr[4] = Integer.valueOf(i17);
        Log.d(TAG, "set(type:%s requestCode:%s triggerAtMillis:%s intent:%s flags:%s)", objArr);
        if (context == null) {
            Log.e(TAG, "set(requestCode:%s): context == null", Integer.valueOf(i3));
            return null;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager == null) {
            Log.e(TAG, "set(requestCode:%s): am == null", Integer.valueOf(i3));
            return null;
        }
        if (!isRequestCodeValid(i3)) {
            Log.e(TAG, "set(requestCode:%s): requestCode invalid", Integer.valueOf(i3));
            return null;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(context, i3, intent, i17);
        alarmManager.set(i16, j3, broadcast);
        return broadcast;
    }

    public static PendingIntent setExact(Context context, int i3, int i16, long j3, Intent intent, int i17) {
        Object obj;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i16);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Long.valueOf(j3);
        if (intent != null) {
            obj = intent;
        } else {
            obj = "null";
        }
        objArr[3] = obj;
        objArr[4] = Integer.valueOf(i17);
        Log.d(TAG, "setExact(type:%s requestCode:%s triggerAtMillis:%s intent:%s flags:%s)", objArr);
        if (context == null) {
            Log.e(TAG, "setExact(requestCode:%s): context == null", Integer.valueOf(i3));
            return null;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager == null) {
            Log.e(TAG, "setExact(requestCode:%s): am == null", Integer.valueOf(i3));
            return null;
        }
        if (!isRequestCodeValid(i3)) {
            Log.e(TAG, "setExact(requestCode:%s): requestCode invalid", Integer.valueOf(i3));
            return null;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            i17 |= 67108864;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(context, i3, intent, i17);
        alarmManager.set(i16, j3, broadcast);
        return broadcast;
    }

    public static PendingIntent setRepeating(Context context, int i3, int i16, long j3, long j16, Intent intent, int i17) {
        Object obj;
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(i16);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Long.valueOf(j3);
        objArr[3] = Long.valueOf(j16);
        if (intent != null) {
            obj = intent;
        } else {
            obj = "null";
        }
        objArr[4] = obj;
        objArr[5] = Integer.valueOf(i17);
        Log.d(TAG, "setRepeating(type:%s requestCode:%s triggerAtMillis:%s intervalMillis:%s intent:%s flags:%s)", objArr);
        if (context == null) {
            Log.e(TAG, "setRepeating(requestCode:%s): context == null", Integer.valueOf(i3));
            return null;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager == null) {
            Log.e(TAG, "setRepeating(requestCode:%s): am == null", Integer.valueOf(i3));
            return null;
        }
        if (!isRequestCodeValid(i3)) {
            Log.e(TAG, "setRepeating(requestCode:%s): requestCode invalid", Integer.valueOf(i3));
            return null;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(context, i3, intent, i17);
        alarmManager.set(i16, j3, broadcast);
        return broadcast;
    }

    public static void cancel(Context context, int i3, PendingIntent pendingIntent) {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i3);
        objArr[1] = pendingIntent != null ? pendingIntent.toString() : "null";
        Log.d(TAG, "cancel(requestCode:%s operation:%s)", objArr);
        if (context == null) {
            Log.e(TAG, "cancel(requestCode:%s): context == null", Integer.valueOf(i3));
            return;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager == null) {
            Log.e(TAG, "cancel(requestCode:%s): am == null", Integer.valueOf(i3));
        } else {
            alarmManager.cancel(pendingIntent);
        }
    }

    public static void cancel(Context context, int i3, Intent intent, int i16) {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i3);
        objArr[1] = intent != null ? intent : "null";
        objArr[2] = Integer.valueOf(i16);
        Log.d(TAG, "cancel(requestCode:%s intent:%s flags:%s)", objArr);
        if (context == null) {
            Log.e(TAG, "cancel(requestCode:%s): context == null", Integer.valueOf(i3));
            return;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager == null) {
            Log.e(TAG, "cancel(requestCode:%s): am == null", Integer.valueOf(i3));
        } else {
            alarmManager.cancel(getPendingIntent(context, i3, intent, i16));
        }
    }
}
