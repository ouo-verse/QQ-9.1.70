package com.tencent.mobileqq.msf.core.h0;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.core.x.d;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c implements com.tencent.mobileqq.msf.core.y.c {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: e, reason: collision with root package name */
    public static final String f248420e = "MSF.C.MSFWakeUpLockManager";

    /* renamed from: a, reason: collision with root package name */
    private final String f248421a;

    /* renamed from: b, reason: collision with root package name */
    private final com.tencent.mobileqq.msf.core.h0.a f248422b;

    /* renamed from: c, reason: collision with root package name */
    private PendingIntent f248423c;

    /* renamed from: d, reason: collision with root package name */
    private final BroadcastReceiver f248424d;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.msf.core.h0.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        class RunnableC8081a implements Runnable {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f248426a;

            RunnableC8081a(String str) {
                this.f248426a = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (IECScreenReceiver.ACTION_SCREEN_ON.equals(this.f248426a)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(c.f248420e, 2, "screenOn");
                    }
                    c.this.d();
                } else if (IECScreenReceiver.ACTION_SCREEN_OFF.equals(this.f248426a)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(c.f248420e, 2, "screenOff");
                    }
                    c.this.c();
                } else if (c.this.f248421a.equals(this.f248426a)) {
                    QLog.d(c.f248420e, 1, "onAlarm, requestWakeLock");
                    c.this.a(d.O());
                }
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            } else {
                q.s().post(new RunnableC8081a(intent.getAction()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements Runnable {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
            intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
            intentFilter.addAction(c.this.f248421a);
            BaseApplication.getContext().registerReceiver(c.this.f248424d, intentFilter);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f248424d = new a();
        this.f248421a = MsfSdkUtils.getProcessName(BaseApplication.getContext()) + "_" + getClass().hashCode();
        this.f248422b = new com.tencent.mobileqq.msf.core.h0.a();
    }

    private void e() {
        q.s().post(new b());
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            if (!d.a1()) {
                return;
            }
            QLog.d(f248420e, 1, "requestWakeLock for screenOff");
            a(d.O());
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (!d.a1()) {
            return;
        }
        if (com.tencent.mobileqq.msf.core.y.a.h().i() && d.b1()) {
            QLog.d(f248420e, 1, "requestWakeLock for screenOn with foreground");
            a(d.Q());
        } else if (!com.tencent.mobileqq.msf.core.y.a.h().i()) {
            QLog.d(f248420e, 1, "requestWakeLock for screenOn with background");
            a(d.O());
        }
    }

    @Override // com.tencent.mobileqq.msf.core.y.c
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            if (!d.a1() || !d.b1()) {
                return;
            }
            QLog.d(f248420e, 1, "requestWakeLock for foreground");
            a(d.Q());
        }
    }

    @Override // com.tencent.mobileqq.msf.core.y.c
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            if (!d.a1()) {
                return;
            }
            QLog.d(f248420e, 1, "requestWakeLock for background");
            a(d.O());
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            com.tencent.mobileqq.msf.core.y.a.h().a(this);
            e();
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (d.a1() && !com.tencent.mobileqq.msf.core.y.a.h().i()) {
            QLog.d(f248420e, 1, "requestWakeLock for ConnOpenPrepare");
            a(d.P());
        }
    }

    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f248422b.a(i3);
        QLog.d(f248420e, 1, "requestWakeLock, time:" + i3 + ", costTime:" + (System.currentTimeMillis() - currentTimeMillis));
        if (!com.tencent.mobileqq.msf.core.y.a.h().i()) {
            a(d.S());
        } else if (a(this.f248423c)) {
            this.f248423c = null;
        }
    }

    public void a(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) toServiceMsg);
            return;
        }
        if (d.a1() && !com.tencent.mobileqq.msf.core.y.a.h().i()) {
            String serviceCmd = toServiceMsg.getServiceCmd();
            if (BaseConstants.CMD_HEARTBEATALIVE.equals(serviceCmd) || BaseConstants.CMD_HEARTBEATPING.equals(serviceCmd) || BaseConstants.CMD_NT_SSO_HEART_BEAT.equals(serviceCmd) || BaseConstants.CMD_STATUS_SVC_MSF_HELLO.equals(serviceCmd)) {
                QLog.d(f248420e, 1, "requestWakeLock for Heartbeat");
                a(d.R());
            }
        }
    }

    public void a(FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) fromServiceMsg);
            return;
        }
        if (d.a1() && !com.tencent.mobileqq.msf.core.y.a.h().i()) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (BaseConstants.CMD_TRPC_MSG_PUSH.equals(serviceCmd) || BaseConstants.CMD_CONN_PROBE.equals(serviceCmd)) {
                QLog.d(f248420e, 1, "requestWakeLock for msg push, cmd:" + serviceCmd);
                a(d.T());
            }
        }
    }

    private void a(long j3) {
        AlarmManager alarmManager = (AlarmManager) BaseApplication.getContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager == null) {
            QLog.e(f248420e, 1, "setAlarmMgr error, get null alarmManager");
            return;
        }
        a(this.f248423c);
        this.f248423c = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, new Intent(this.f248421a), Build.VERSION.SDK_INT > 23 ? 201326592 : 134217728);
        long currentTimeMillis = System.currentTimeMillis() + j3;
        try {
            QLog.d(f248420e, 1, "register alarm with setAndAllowWhileIdle, intent:" + this.f248423c);
            Method declaredMethod = AlarmManager.class.getDeclaredMethod("setExactAndAllowWhileIdle", Integer.TYPE, Long.TYPE, PendingIntent.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(alarmManager, 0, Long.valueOf(currentTimeMillis), this.f248423c);
        } catch (Throwable th5) {
            QLog.e(f248420e, 1, "registerAlarmMgr get setAndAllowWhileIdle method error!", th5);
            try {
                QLog.d(f248420e, 1, "register alarm, intent:" + this.f248423c);
                alarmManager.setExact(0, currentTimeMillis, this.f248423c);
            } catch (Throwable th6) {
                QLog.e(f248420e, 1, "registerAlarmMgr setExact error!", th6);
            }
        }
        QLog.d(f248420e, 1, "register " + this.f248421a + " alarm alive send at " + MsfSdkUtils.timeMillisToDay(currentTimeMillis));
    }

    private boolean a(PendingIntent pendingIntent) {
        AlarmManager alarmManager = (AlarmManager) BaseApplication.getContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager == null) {
            QLog.e(f248420e, 1, "cancelAlarmMsg error, get null alarmManager");
            return false;
        }
        if (pendingIntent == null) {
            QLog.d(f248420e, 1, "cancelAlarmMsg fail, pendingIntent == null");
            return false;
        }
        try {
            QLog.d(f248420e, 1, "cancel alarm, intent:" + pendingIntent);
            alarmManager.cancel(pendingIntent);
            pendingIntent.cancel();
            return true;
        } catch (Exception e16) {
            QLog.e(f248420e, 1, "cancel alarm error:" + e16.getMessage(), e16);
            return false;
        }
    }
}
