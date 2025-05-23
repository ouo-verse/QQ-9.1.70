package com.tencent.mars.ilink.comm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.tencent.mars.ilink.xlog.Log;
import java.util.TreeMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public class Alarm extends BroadcastReceiver {
    private static final String KEXTRA_ID = "ID";
    private static final String KEXTRA_PID = "PID";
    private static final String TAG = "MicroMsg.Alarm";
    private static Alarm bc_alarm;
    private static TreeMap<Long, AlarmRecord> gPendingAlarms = new TreeMap<>();
    private static WakerLock wakerlock;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class AlarmRecord implements Comparable<AlarmRecord> {

        /* renamed from: id, reason: collision with root package name */
        final long f151364id;
        PendingIntent pendingIntent;
        long waitTime;

        public AlarmRecord(long j3, long j16, PendingIntent pendingIntent) {
            this.f151364id = j3;
            this.waitTime = j16;
            this.pendingIntent = pendingIntent;
        }

        @Override // java.lang.Comparable
        public int compareTo(AlarmRecord alarmRecord) {
            return (int) (this.f151364id - alarmRecord.f151364id);
        }
    }

    private static boolean cancelAlarmMgr(long j3, Context context, PendingIntent pendingIntent) {
        if (((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)) == null) {
            Log.e(TAG, "am == null");
            return false;
        }
        if (pendingIntent == null) {
            Log.e(TAG, "pendingIntent == null");
            return false;
        }
        AlarmHelper.cancel(context, (int) j3, pendingIntent);
        pendingIntent.cancel();
        return true;
    }

    private native void onAlarm(long j3);

    public static void resetAlarm(Context context) {
        synchronized (gPendingAlarms) {
            for (AlarmRecord alarmRecord : gPendingAlarms.values()) {
                cancelAlarmMgr(alarmRecord.f151364id, context, alarmRecord.pendingIntent);
            }
            gPendingAlarms.clear();
            Alarm alarm = bc_alarm;
            if (alarm != null) {
                context.unregisterReceiver(alarm);
                bc_alarm = null;
            }
        }
    }

    private static PendingIntent setAlarmMgr(int i3, long j3, long j16, Context context) {
        if (((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)) == null) {
            Log.e(TAG, "am == null");
            return null;
        }
        Intent intent = new Intent();
        intent.setAction("ALARM_ACTION(" + String.valueOf(Process.myPid()) + ")");
        intent.putExtra(KEXTRA_ID, j3);
        intent.putExtra(KEXTRA_PID, Process.myPid());
        return AlarmHelper.setExact(context, i3, 2, j16, intent, 268435456);
    }

    public static boolean start(int i3, long j3, int i16, Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (i16 < 0) {
            Log.e(TAG, "id:%d, after:%d", Long.valueOf(j3), Integer.valueOf(i16));
            return false;
        }
        if (context == null) {
            Log.e(TAG, "null==context, id:%d, after:%d", Long.valueOf(j3), Integer.valueOf(i16));
            return false;
        }
        synchronized (gPendingAlarms) {
            if (wakerlock == null) {
                wakerlock = new WakerLock(context);
                Log.i(TAG, "start new wakerlock");
            }
            if (bc_alarm == null) {
                Alarm alarm = new Alarm();
                bc_alarm = alarm;
                context.registerReceiver(alarm, new IntentFilter("ALARM_ACTION(" + String.valueOf(Process.myPid()) + ")"));
            }
            if (gPendingAlarms.containsKey(Long.valueOf(j3))) {
                Log.e(TAG, "id exist=%d", Long.valueOf(j3));
                return false;
            }
            if (i16 >= 0) {
                elapsedRealtime += i16;
            }
            long j16 = elapsedRealtime;
            PendingIntent alarmMgr = setAlarmMgr(i3, j3, j16, context);
            if (alarmMgr == null) {
                return false;
            }
            gPendingAlarms.put(Long.valueOf(j3), new AlarmRecord(j3, j16, alarmMgr));
            Log.i(TAG, "Alarm.start [id: %d, after: %d, size: %d]", Long.valueOf(j3), Integer.valueOf(i16), Integer.valueOf(gPendingAlarms.size()));
            return true;
        }
    }

    public static boolean stop(long j3, Context context) {
        Log.i(TAG, "Alarm.stop [id: %d]", Long.valueOf(j3));
        if (context == null) {
            Log.e(TAG, "context==null");
            return false;
        }
        synchronized (gPendingAlarms) {
            if (wakerlock == null) {
                wakerlock = new WakerLock(context);
                Log.i(TAG, "stop new wakerlock");
            }
            if (bc_alarm == null) {
                bc_alarm = new Alarm();
                context.registerReceiver(bc_alarm, new IntentFilter());
                Log.i(TAG, "stop new Alarm");
            }
            AlarmRecord remove = gPendingAlarms.remove(Long.valueOf(j3));
            if (remove == null) {
                return false;
            }
            cancelAlarmMgr(remove.f151364id, context, remove.pendingIntent);
            return true;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null) {
            long longExtra = intent.getLongExtra(KEXTRA_ID, 0L);
            int intExtra = intent.getIntExtra(KEXTRA_PID, 0);
            if (0 != longExtra && intExtra != 0) {
                if (intExtra != Process.myPid()) {
                    Log.w(TAG, "onReceive id:%d, pid:%d, mypid:%d", Long.valueOf(longExtra), Integer.valueOf(intExtra), Integer.valueOf(Process.myPid()));
                    return;
                }
                synchronized (gPendingAlarms) {
                    AlarmRecord remove = gPendingAlarms.remove(Long.valueOf(longExtra));
                    if (remove != null) {
                        Log.i(TAG, "Alarm.onReceive [id: %d, delta miss time: %d, size: %d]", Long.valueOf(longExtra), Long.valueOf(SystemClock.elapsedRealtime() - remove.waitTime), Integer.valueOf(gPendingAlarms.size()));
                        WakerLock wakerLock = wakerlock;
                        if (wakerLock != null) {
                            wakerLock.lock(200L);
                        }
                        onAlarm(longExtra);
                    } else {
                        Log.e(TAG, "onReceive not found id:%d, pid:%d, gPendingAlarms.size:%d", Long.valueOf(longExtra), Integer.valueOf(intExtra), Integer.valueOf(gPendingAlarms.size()));
                    }
                }
            }
        }
    }
}
