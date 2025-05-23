package com.tencent.mobileqq.msf.core.stepcount.g;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorEventListener2;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants;
import com.tencent.mobileqq.msf.core.stepcount.e;
import com.tencent.mobileqq.msf.service.n;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b implements com.tencent.mobileqq.msf.core.stepcount.d, Handler.Callback {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: m, reason: collision with root package name */
    private static final String f250039m = "StepEventHandlerImpl";

    /* renamed from: n, reason: collision with root package name */
    private static final int f250040n = 0;

    /* renamed from: o, reason: collision with root package name */
    private static final int f250041o = 360000000;

    /* renamed from: p, reason: collision with root package name */
    private static final float f250042p = 60.0f;

    /* renamed from: q, reason: collision with root package name */
    private static final long f250043q = 60;

    /* renamed from: r, reason: collision with root package name */
    private static final int f250044r = 1;

    /* renamed from: s, reason: collision with root package name */
    private static final String f250045s = "StepEventHandlerImpl.action_time_monitor";

    /* renamed from: t, reason: collision with root package name */
    private static final int f250046t = 4;

    /* renamed from: u, reason: collision with root package name */
    private static final int f250047u = 5;

    /* renamed from: a, reason: collision with root package name */
    private final Context f250048a;

    /* renamed from: b, reason: collision with root package name */
    private final com.tencent.mobileqq.msf.core.stepcount.c f250049b;

    /* renamed from: c, reason: collision with root package name */
    private volatile SensorEventListener f250050c;

    /* renamed from: d, reason: collision with root package name */
    private volatile BroadcastReceiver f250051d;

    /* renamed from: e, reason: collision with root package name */
    private volatile BroadcastReceiver f250052e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f250053f;

    /* renamed from: g, reason: collision with root package name */
    private long f250054g;

    /* renamed from: h, reason: collision with root package name */
    private int f250055h;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f250056i;

    /* renamed from: j, reason: collision with root package name */
    private long f250057j;

    /* renamed from: k, reason: collision with root package name */
    private int f250058k;

    /* renamed from: l, reason: collision with root package name */
    private long f250059l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements SensorEventListener2 {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) sensor, i3);
            }
        }

        @Override // android.hardware.SensorEventListener2
        public void onFlushCompleted(Sensor sensor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) sensor);
            } else {
                b.this.f250049b.d();
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) sensorEvent);
                return;
            }
            if (sensorEvent != null && (fArr = sensorEvent.values) != null && fArr.length != 0) {
                long serverTime = NetConnInfoCenter.getServerTime();
                int i3 = (int) sensorEvent.values[0];
                b.this.a(i3, serverTime);
                if (((Integer) b.this.f250049b.b().second).intValue() != i3) {
                    b.this.k();
                }
                b.this.f250049b.a(i3, serverTime);
                return;
            }
            QLog.d(b.f250039m, 1, "sensor value is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.core.stepcount.g.b$b, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class C8098b extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        C8098b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(b.f250039m, 2, "receive alarm when enter a new day");
            }
            b.this.f250049b.a(NetConnInfoCenter.getServerTime());
            b.this.f250049b.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        @RequiresApi(api = 19)
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            long serverTime = NetConnInfoCenter.getServerTime();
            QLog.d(b.f250039m, 1, "receive shut down broadcast");
            b.this.f();
            b.this.f250049b.b(serverTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f250063a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f250064b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f250065c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ToServiceMsg f250066d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f250067e;

        d(long j3, int i3, String str, ToServiceMsg toServiceMsg, boolean z16) {
            this.f250063a = j3;
            this.f250064b = i3;
            this.f250065c = str;
            this.f250066d = toServiceMsg;
            this.f250067e = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, b.this, Long.valueOf(j3), Integer.valueOf(i3), str, toServiceMsg, Boolean.valueOf(z16));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                b.this.a(this.f250063a, this.f250064b, this.f250065c, this.f250066d, this.f250067e);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    public b(@NonNull Context context, com.tencent.mobileqq.msf.core.stepcount.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) cVar);
            return;
        }
        this.f250050c = null;
        this.f250051d = null;
        this.f250052e = null;
        this.f250053f = null;
        this.f250056i = true;
        this.f250048a = context;
        this.f250049b = cVar;
    }

    private void d() {
        try {
            if (this.f250050c == null) {
                n();
            } else {
                a(true);
            }
        } catch (Throwable th5) {
            QLog.e(f250039m, 2, "checkListenerStatus failed, error is " + th5);
        }
    }

    private void e() {
        if (this.f250053f == null) {
            this.f250053f = new Handler(Looper.getMainLooper(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 19)
    public void f() {
        SensorManager sensorManager;
        if (this.f250050c != null && (sensorManager = (SensorManager) this.f250048a.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR)) != null) {
            sensorManager.flush(this.f250050c);
        }
    }

    private long g() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar.getTimeInMillis();
    }

    private void h() {
        if (this.f250051d != null) {
            this.f250048a.unregisterReceiver(this.f250051d);
            this.f250051d = null;
        }
    }

    private void i() {
        if (this.f250052e != null) {
            this.f250048a.unregisterReceiver(this.f250052e);
            this.f250052e = null;
        }
    }

    private void j() {
        try {
            if (this.f250050c != null) {
                QLog.d(f250039m, 2, "remove SensorEventListener2");
                ((SensorManager) this.f250048a.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR)).unregisterListener(this.f250050c);
                this.f250050c = null;
            }
        } catch (Throwable th5) {
            QLog.e(f250039m, 2, "remove SensorEventListener2 failed, error is " + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        e();
        if (this.f250053f.hasMessages(4)) {
            this.f250053f.removeMessages(4);
        }
        this.f250053f.sendEmptyMessageDelayed(4, e.a().e() * 1000);
    }

    @RequiresApi(api = 19)
    private void l() {
        int i3;
        if (this.f250051d == null) {
            this.f250051d = new C8098b();
            this.f250048a.registerReceiver(this.f250051d, new IntentFilter(f250045s));
            Intent intent = new Intent(f250045s);
            if (Build.VERSION.SDK_INT > 23) {
                i3 = 201326592;
            } else {
                i3 = 134217728;
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(this.f250048a, 1, intent, i3);
            QLog.d(f250039m, 1, "register alarm, intent:" + broadcast);
            ((AlarmManager) this.f250048a.getSystemService(NotificationCompat.CATEGORY_ALARM)).setExactAndAllowWhileIdle(0, g(), broadcast);
        }
    }

    private void m() {
        if (this.f250052e == null) {
            this.f250052e = new c();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.ACTION_SHUTDOWN");
            this.f250048a.registerReceiver(this.f250052e, intentFilter);
        }
    }

    @RequiresApi(api = 19)
    private void n() {
        try {
            if (this.f250050c == null) {
                QLog.d(f250039m, 2, "init SensorEventListener2");
                this.f250050c = new a();
                a(false);
            }
        } catch (Throwable th5) {
            QLog.e(f250039m, 2, "init SensorEventListener2 failed, error is " + th5);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 == 4) {
            QLog.d(f250039m, 1, "receive message to report steps");
            a((String) null, (ToServiceMsg) null);
            return true;
        }
        if (i3 == 5) {
            this.f250056i = true;
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.msf.core.stepcount.d
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f250039m, 2, "notifyReportSuccess");
        }
        this.f250049b.c();
        this.f250054g = this.f250057j;
        this.f250055h = this.f250058k;
        this.f250056i = true;
    }

    @Override // com.tencent.mobileqq.msf.core.stepcount.d
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        j();
        h();
        i();
    }

    @Override // com.tencent.mobileqq.msf.core.stepcount.d
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (!e.a().h()) {
            if (QLog.isColorLevel()) {
                QLog.d(f250039m, 2, "user switch off step counter helper");
            }
        } else {
            n();
            l();
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3, long j3) {
        Pair<Long, Integer> b16 = this.f250049b.b();
        long longValue = ((Long) b16.first).longValue();
        int intValue = ((Integer) b16.second).intValue();
        boolean a16 = a(j3, longValue);
        if (i3 <= intValue) {
            a16 = false;
        }
        long j16 = j3 - longValue;
        long b17 = e.a().b() / 60;
        if (b17 > 0) {
            j16 += b17;
        }
        int i16 = i3 - intValue;
        if (((j16 > 0L ? 1 : (j16 == 0L ? 0 : -1)) != 0 ? (((float) i16) * 1.0f) / ((float) j16) : 0.0f) * 60.0f <= ((float) e.a().f()) ? a16 : false) {
            this.f250049b.b(i16, longValue);
        }
    }

    private boolean a(long j3, long j16) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3 * 1000);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j16 * 1000);
        return calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1);
    }

    @Override // com.tencent.mobileqq.msf.core.stepcount.d
    public void a(String str, ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) toServiceMsg);
            return;
        }
        long serverTime = NetConnInfoCenter.getServerTime();
        int c16 = this.f250049b.c(serverTime);
        boolean z16 = (str == null || toServiceMsg == null) ? false : true;
        if (QLog.isColorLevel()) {
            QLog.d(f250039m, 2, "reportSteps, ActiveReport is" + z16);
        }
        e();
        d();
        if (this.f250055h != c16 && serverTime - this.f250059l > e.a().b() / 5) {
            this.f250049b.d();
            this.f250059l = serverTime;
        }
        boolean z17 = toServiceMsg != null && ((Boolean) toServiceMsg.getAttribute(StepCounterConstants.ATTR_IS_REPORT_STEP, Boolean.FALSE)).booleanValue();
        if (!a(z16, serverTime, c16) || z17) {
            this.f250056i = false;
            q.s().post(new d(serverTime, c16, str, toServiceMsg, z16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j3, int i3, String str, ToServiceMsg toServiceMsg, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(f250039m, 2, "reportStepToServer");
        }
        this.f250057j = j3;
        this.f250058k = i3;
        HashMap<Long, Integer> a16 = this.f250049b.a(j3, this.f250054g);
        boolean a17 = this.f250049b.a();
        long longValue = ((Long) this.f250049b.b().first).longValue();
        if (z16) {
            FromServiceMsg a18 = n.a(toServiceMsg);
            a18.setMsgSuccess();
            a18.addAttribute(StepCounterConstants.ATTR_STEP_COUNT_HISTORY, a16);
            a18.addAttribute(StepCounterConstants.ATTR_HAS_SHUTDOWN_FLAG, Boolean.valueOf(a17));
            a18.addAttribute(StepCounterConstants.ATTR_LAST_SENSOR_EVENT_TIME, Long.valueOf(longValue));
            a18.addAttribute(StepCounterConstants.ATTR_STEP_COUNTER_ENABLE, Boolean.valueOf(e.a().h()));
            com.tencent.mobileqq.msf.service.e.b(str, toServiceMsg, a18);
            if (QLog.isColorLevel()) {
                QLog.d(f250039m, 2, "active report msf server msg sent, ");
                return;
            }
            return;
        }
        Intent intent = new Intent(StepCounterConstants.ACTION_SSO_STEP_REPORT);
        intent.putExtra(StepCounterConstants.ATTR_STEP_COUNT_HISTORY, a16);
        intent.putExtra(StepCounterConstants.ATTR_HAS_SHUTDOWN_FLAG, a17);
        intent.putExtra(StepCounterConstants.ATTR_LAST_SENSOR_EVENT_TIME, longValue);
        intent.putExtra(StepCounterConstants.ATTR_STEP_COUNTER_ENABLE, e.a().h());
        this.f250048a.sendBroadcast(intent);
        if (QLog.isColorLevel()) {
            QLog.d(f250039m, 2, "passive report broadcast sent,");
        }
    }

    private boolean a(boolean z16, long j3, int i3) {
        if (!this.f250056i) {
            if (!this.f250053f.hasMessages(5)) {
                this.f250053f.sendEmptyMessageDelayed(5, 10000L);
            }
            if (QLog.isColorLevel()) {
                QLog.d(f250039m, 2, "last step report is not completed, cancel the report, is activeReport " + z16);
            }
            return true;
        }
        if (j3 - this.f250054g < (z16 ? e.a().b() : e.a().e())) {
            if (QLog.isColorLevel()) {
                QLog.i(f250039m, 2, "last report time: " + this.f250054g + " , current time:" + j3 + ", interval is too short, cancel report");
            }
            return true;
        }
        if (this.f250055h != i3) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f250039m, 2, "last report step is equal to latest step, cancel report");
        }
        return true;
    }

    private void a(boolean z16) {
        try {
            QLog.d(f250039m, 2, "reRegisterListener, needUnRegisterListener is " + z16);
            SensorManager sensorManager = (SensorManager) this.f250048a.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
            Sensor defaultSensor = SensorMonitor.getDefaultSensor(sensorManager, 19);
            if (z16) {
                sensorManager.unregisterListener(this.f250050c);
            }
            SensorMonitor.registerListener(sensorManager, this.f250050c, defaultSensor, 0, f250041o);
        } catch (Throwable th5) {
            QLog.e(f250039m, 2, "reRegisterListener failed, error is " + th5);
        }
    }
}
