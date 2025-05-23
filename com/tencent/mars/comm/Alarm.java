package com.tencent.mars.comm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.tencent.luggage.wxa.aa.j;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.x8.a;
import com.tencent.luggage.wxa.xm.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.TreeMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public class Alarm extends BroadcastReceiver {
    static IPatchRedirector $redirector_ = null;
    private static final int IDKEY_ALARM_DELAY_REPORT = 1256;
    private static final int INTENT_FILTER_ACTION_ID_DEFAULT = 10000;
    private static final String KEXTRA_ID = "ID";
    private static final String KEXTRA_PID = "PID";
    private static final int KV_ALARM_DELAY_REPORT = 18860;
    private static final String TAG = "MicroMsg.Alarm";
    private static Alarm bc_alarm;
    private static TreeMap<Long, AlarmRecord> gPendingAlarms;
    private static WakerLock wakerlock;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class AlarmRecord implements Comparable<AlarmRecord> {
        static IPatchRedirector $redirector_;

        /* renamed from: id, reason: collision with root package name */
        final long f151363id;
        PendingIntent pendingIntent;
        long waitTime;

        public AlarmRecord(long j3, long j16, PendingIntent pendingIntent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), pendingIntent);
                return;
            }
            this.f151363id = j3;
            this.waitTime = j16;
            this.pendingIntent = pendingIntent;
        }

        @Override // java.lang.Comparable
        public int compareTo(AlarmRecord alarmRecord) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? (int) (this.f151363id - alarmRecord.f151363id) : ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) alarmRecord)).intValue();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58975);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            gPendingAlarms = new TreeMap<>();
        }
    }

    public Alarm() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean cancelAlarmMgr(long j3, Context context, PendingIntent pendingIntent) {
        if (((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)) == null) {
            w.b(TAG, "am == null");
            return false;
        }
        if (pendingIntent == null) {
            w.b(TAG, "pendingIntent == null");
            return false;
        }
        a.a(context, (int) j3, pendingIntent);
        pendingIntent.cancel();
        return true;
    }

    private native void onAlarm(long j3);

    public static void resetAlarm(Context context) {
        synchronized (gPendingAlarms) {
            for (AlarmRecord alarmRecord : gPendingAlarms.values()) {
                cancelAlarmMgr(alarmRecord.f151363id, context, alarmRecord.pendingIntent);
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
            w.b(TAG, "am == null");
            return null;
        }
        Intent intent = new Intent();
        intent.setAction("ALARM_ACTION(" + String.valueOf(10000) + ")");
        intent.putExtra(KEXTRA_ID, j3);
        intent.putExtra(KEXTRA_PID, Process.myPid());
        return a.b(context, i3, 2, j16, intent, j.a(268435456));
    }

    public static boolean start(int i3, long j3, int i16, Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (i16 < 0) {
            w.b(TAG, "id:%d, after:%d", Long.valueOf(j3), Integer.valueOf(i16));
            return false;
        }
        if (context == null) {
            w.b(TAG, "null==context, id:%d, after:%d", Long.valueOf(j3), Integer.valueOf(i16));
            return false;
        }
        synchronized (gPendingAlarms) {
            if (wakerlock == null) {
                wakerlock = new WakerLock(context, TAG);
                w.d(TAG, "start new wakerlock");
            }
            if (bc_alarm == null) {
                bc_alarm = new Alarm();
                if (com.tencent.luggage.wxa.aa.a.a(33)) {
                    context.registerReceiver(bc_alarm, new IntentFilter("ALARM_ACTION(" + String.valueOf(10000) + ")"));
                } else {
                    context.registerReceiver(bc_alarm, new IntentFilter("ALARM_ACTION(" + String.valueOf(10000) + ")"), 2);
                }
            }
            if (gPendingAlarms.containsKey(Long.valueOf(j3))) {
                w.b(TAG, "id exist=%d", Long.valueOf(j3));
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
            w.d(TAG, "Alarm.start [id: %d, after: %d, size: %d]", Long.valueOf(j3), Integer.valueOf(i16), Integer.valueOf(gPendingAlarms.size()));
            return true;
        }
    }

    public static boolean stop(long j3, Context context) {
        w.d(TAG, "Alarm.stop [id: %d]", Long.valueOf(j3));
        if (context == null) {
            w.b(TAG, "context==null");
            return false;
        }
        synchronized (gPendingAlarms) {
            if (wakerlock == null) {
                wakerlock = new WakerLock(context, TAG);
                w.d(TAG, "stop new wakerlock");
            }
            if (bc_alarm == null) {
                bc_alarm = new Alarm();
                IntentFilter intentFilter = new IntentFilter();
                if (Build.VERSION.SDK_INT >= 31) {
                    context.registerReceiver(bc_alarm, intentFilter, 2);
                } else {
                    context.registerReceiver(bc_alarm, intentFilter);
                }
                w.d(TAG, "stop new Alarm");
            }
            AlarmRecord remove = gPendingAlarms.remove(Long.valueOf(j3));
            if (remove == null) {
                return false;
            }
            cancelAlarmMgr(remove.f151363id, context, remove.pendingIntent);
            return true;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (context != null && intent != null) {
            long j3 = 0;
            long longExtra = intent.getLongExtra(KEXTRA_ID, 0L);
            int intExtra = intent.getIntExtra(KEXTRA_PID, 0);
            if (0 != longExtra && intExtra != 0) {
                if (intExtra != Process.myPid()) {
                    w.h(TAG, "onReceive id:%d, pid:%d, mypid:%d", Long.valueOf(longExtra), Integer.valueOf(intExtra), Integer.valueOf(Process.myPid()));
                    return;
                }
                synchronized (gPendingAlarms) {
                    AlarmRecord remove = gPendingAlarms.remove(Long.valueOf(longExtra));
                    if (remove != null) {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - remove.waitTime;
                        w.d(TAG, "Alarm.onReceive [id: %d, delta miss time: %d, size: %d]", Long.valueOf(longExtra), Long.valueOf(elapsedRealtime), Integer.valueOf(gPendingAlarms.size()));
                        if (elapsedRealtime > 30000) {
                            if (elapsedRealtime <= 60000) {
                                j3 = 1;
                            } else if (elapsedRealtime <= 120000) {
                                j3 = 2;
                            } else if (elapsedRealtime <= MiniBoxNoticeInfo.MIN_5) {
                                j3 = 3;
                            } else {
                                j3 = 4;
                            }
                        }
                        long j16 = j3;
                        b bVar = b.INSTANCE;
                        bVar.a(1256L, j16, 1L, false);
                        bVar.a(KV_ALARM_DELAY_REPORT, Long.valueOf(elapsedRealtime));
                        WakerLock wakerLock = wakerlock;
                        if (wakerLock != null) {
                            wakerLock.lock(200L, "Alarm.onReceive");
                        }
                        onAlarm(longExtra);
                    } else {
                        w.b(TAG, "onReceive not found id:%d, pid:%d, gPendingAlarms.size:%d", Long.valueOf(longExtra), Integer.valueOf(intExtra), Integer.valueOf(gPendingAlarms.size()));
                    }
                }
            }
        }
    }
}
