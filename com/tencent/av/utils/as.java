package com.tencent.av.utils;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.PowerManager;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.q;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.avcore.jni.audiodevice.TraeConstants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.utils.GameActivityStatusWatcher;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class as {

    /* renamed from: x, reason: collision with root package name */
    static int f77025x = -1;

    /* renamed from: l, reason: collision with root package name */
    WeakReference<Context> f77037l;

    /* renamed from: m, reason: collision with root package name */
    TraeHelper f77038m;

    /* renamed from: o, reason: collision with root package name */
    private b f77040o;

    /* renamed from: a, reason: collision with root package name */
    String f77026a = "SensorHelper";

    /* renamed from: b, reason: collision with root package name */
    boolean f77027b = false;

    /* renamed from: c, reason: collision with root package name */
    Sensor f77028c = null;

    /* renamed from: d, reason: collision with root package name */
    a f77029d = null;

    /* renamed from: e, reason: collision with root package name */
    Sensor f77030e = null;

    /* renamed from: f, reason: collision with root package name */
    c f77031f = null;

    /* renamed from: g, reason: collision with root package name */
    SensorManager f77032g = null;

    /* renamed from: h, reason: collision with root package name */
    boolean f77033h = false;

    /* renamed from: i, reason: collision with root package name */
    d f77034i = null;

    /* renamed from: j, reason: collision with root package name */
    SensorReport f77035j = new SensorReport();

    /* renamed from: k, reason: collision with root package name */
    int f77036k = 0;

    /* renamed from: n, reason: collision with root package name */
    private boolean f77039n = true;

    /* renamed from: p, reason: collision with root package name */
    private boolean f77041p = false;

    /* renamed from: q, reason: collision with root package name */
    boolean f77042q = false;

    /* renamed from: r, reason: collision with root package name */
    PowerManager.WakeLock f77043r = null;

    /* renamed from: s, reason: collision with root package name */
    boolean f77044s = false;

    /* renamed from: t, reason: collision with root package name */
    private boolean f77045t = true;

    /* renamed from: u, reason: collision with root package name */
    private boolean f77046u = true;

    /* renamed from: v, reason: collision with root package name */
    private boolean f77047v = false;

    /* renamed from: w, reason: collision with root package name */
    private boolean f77048w = true;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface b {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class d extends BroadcastReceiver {
        d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i3;
            String action = intent.getAction();
            boolean z16 = false;
            if (action.equals(IECScreenReceiver.ACTION_SCREEN_ON)) {
                boolean g16 = com.tencent.av.r.g1(context);
                boolean isInteractive = ((PowerManager) as.this.f77037l.get().getSystemService("power")).isInteractive();
                Display defaultDisplay = ((WindowManager) as.this.f77037l.get().getSystemService("window")).getDefaultDisplay();
                if (defaultDisplay != null) {
                    i3 = defaultDisplay.getState();
                } else {
                    i3 = 2;
                }
                String str = as.this.f77026a;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("ACTION_SCREEN_ON, VideoController.getInstance()[");
                if (com.tencent.av.r.h0() != null) {
                    z16 = true;
                }
                sb5.append(z16);
                sb5.append("], isInteractive[");
                sb5.append(isInteractive);
                sb5.append("], nState[");
                sb5.append(i3);
                sb5.append("], inKeyguardRestrictedInputMode[");
                sb5.append(g16);
                sb5.append("], mIsStarted[");
                sb5.append(as.this.f77044s);
                sb5.append("]");
                QLog.d(str, 1, sb5.toString());
                as asVar = as.this;
                if (asVar.f77044s) {
                    asVar.f77036k = 1;
                    asVar.f77045t = asVar.f77046u;
                    return;
                }
                return;
            }
            if (action.equals(IECScreenReceiver.ACTION_SCREEN_OFF)) {
                int intExtra = intent.getIntExtra("why", 0);
                QLog.d(as.this.f77026a, 1, "ACTION_SCREEN_OFF, why[" + intExtra + "]");
                if (com.tencent.av.r.h0() != null) {
                    com.tencent.av.r.h0().L3("backgroundReason", "4");
                    q.a.f74207a = "4";
                    return;
                }
                return;
            }
            if (action.equals("android.intent.action.USER_PRESENT")) {
                QLog.d(as.this.f77026a, 1, "ACTION_USER_PRESENT");
                return;
            }
            if (action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
                String stringExtra = intent.getStringExtra("reason");
                QLog.d(as.this.f77026a, 1, "ACTION_CLOSE_SYSTEM_DIALOGS, reason[" + stringExtra + "]");
                if (GameActivityStatusWatcher.InnerRecevier.SYSTEM_DIALOG_REASON_HOME_KEY.equalsIgnoreCase(stringExtra)) {
                    as asVar2 = as.this;
                    if (asVar2.f77044s) {
                        asVar2.f77036k = 1;
                        asVar2.f77045t = asVar2.f77046u;
                    }
                }
            }
        }
    }

    as(Activity activity, b bVar) {
        this.f77040o = null;
        this.f77037l = new WeakReference<>(activity);
        this.f77040o = bVar;
        l();
    }

    public static as k(as asVar, Activity activity, b bVar) {
        if (asVar != null) {
            asVar.r(false);
        }
        return new as(activity, bVar);
    }

    void l() {
        Context context;
        WeakReference<Context> weakReference = this.f77037l;
        if (weakReference != null && (context = weakReference.get()) != null && this.f77032g == null) {
            this.f77032g = (SensorManager) context.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        }
        SensorManager sensorManager = this.f77032g;
        if (sensorManager != null) {
            if (this.f77028c == null) {
                this.f77028c = SensorMonitor.getDefaultSensor(sensorManager, 1);
            }
            if (this.f77030e == null) {
                this.f77030e = SensorMonitor.getDefaultSensor(this.f77032g, 8);
            }
        }
        if (this.f77029d == null) {
            this.f77029d = new a();
        }
        if (this.f77031f == null) {
            this.f77031f = new c();
        }
    }

    public synchronized void m(boolean z16) {
        this.f77042q = z16;
    }

    public synchronized void n(boolean z16) {
        this.f77041p = z16;
    }

    boolean o() {
        if (f77025x == -1) {
            String model = DeviceInfoMonitor.getModel();
            if (Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING)) {
                if (!model.equalsIgnoreCase("GT-I9200") && !model.equalsIgnoreCase("GT-I8262D") && !model.equalsIgnoreCase("SM-N9008")) {
                    f77025x = 0;
                } else {
                    f77025x = 1;
                }
            } else {
                f77025x = 0;
            }
        }
        if (f77025x != 1) {
            return false;
        }
        return true;
    }

    public void p() {
        this.f77035j.h();
    }

    public void q(boolean z16) {
        this.f77039n = z16;
    }

    public void r(boolean z16) {
        WeakReference<Context> weakReference;
        if (QLog.isColorLevel()) {
            QLog.d(this.f77026a, 2, "startSensor " + z16);
        }
        if (this.f77029d != null && this.f77031f != null && (weakReference = this.f77037l) != null && weakReference.get() != null) {
            if (z16) {
                this.f77035j.b();
                if (!this.f77033h) {
                    this.f77033h = true;
                    SensorMonitor.registerListener(this.f77032g, this.f77029d, this.f77028c, 3);
                    SensorMonitor.registerListener(this.f77032g, this.f77031f, this.f77030e, 3);
                    if (this.f77034i == null) {
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
                        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
                        intentFilter.addAction("android.intent.action.USER_PRESENT");
                        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
                        this.f77034i = new d();
                        this.f77037l.get().registerReceiver(this.f77034i, intentFilter);
                        return;
                    }
                    QLog.e(this.f77026a, 1, "startSensor error, mSreenActionReceive had exist");
                    return;
                }
                return;
            }
            if (this.f77033h) {
                this.f77032g.unregisterListener(this.f77029d);
                this.f77032g.unregisterListener(this.f77031f);
                QLog.d(this.f77026a, 1, "toggleProximityWakeLock[false], when[StopSensor]");
                s(false, true);
                n(false);
                m(false);
                if (this.f77034i != null) {
                    this.f77037l.get().unregisterReceiver(this.f77034i);
                    this.f77034i = null;
                }
            }
            this.f77033h = false;
            this.f77035j.d();
            return;
        }
        QLog.e(this.f77026a, 1, "startSensor error, start[" + z16);
    }

    synchronized void s(boolean z16, boolean z17) {
        boolean o16 = o();
        if (this.f77044s != z16 && ((this.f77041p || !z16) && !o16)) {
            if (this.f77043r == null) {
                try {
                    PowerManager.WakeLock newWakeLock = ((PowerManager) this.f77037l.get().getSystemService("power")).newWakeLock(32, "mobileqq:sensor");
                    this.f77043r = newWakeLock;
                    if (newWakeLock != null) {
                        newWakeLock.setReferenceCounted(false);
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(this.f77026a, 2, "toggleProximityWakeLock off Exception", e16);
                    }
                }
            }
            PowerManager.WakeLock wakeLock = this.f77043r;
            if (wakeLock == null) {
                QLog.d(this.f77026a, 1, "toggleProximityWakeLock: mWakeLockForScreenOff is null");
                return;
            }
            if (wakeLock != null) {
                try {
                    boolean isHeld = wakeLock.isHeld();
                    QLog.d(this.f77026a, 1, String.format("toggleProximityWakeLock, start[%s], bHeld[%s]", Boolean.valueOf(z16), Boolean.valueOf(isHeld)));
                    if (z16 && !isHeld) {
                        this.f77043r.acquire();
                        this.f77044s = true;
                        this.f77035j.i();
                    } else if (!z16 && isHeld) {
                        this.f77043r.release();
                        this.f77044s = false;
                        this.f77035j.j(this.f77048w, this.f77041p, this.f77046u, this.f77036k, z17);
                    }
                    this.f77044s = z16;
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.e(this.f77026a, 2, "toggleProximityWakeLock Exception", e17);
                    }
                }
            }
            return;
        }
        QLog.d(this.f77026a, 1, String.format("toggleProximityWakeLock error, start[%s], mIsStarted[%s], mEnbaleProximiy[%s], bProximityIgnoreDevice[%s]", Boolean.valueOf(z16), Boolean.valueOf(this.f77044s), Boolean.valueOf(this.f77041p), Boolean.valueOf(o16)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements SensorEventListener {

        /* renamed from: d, reason: collision with root package name */
        long f77049d = 0;

        /* renamed from: e, reason: collision with root package name */
        long f77050e = 0;

        a() {
        }

        String a(float f16, float f17, float f18, float f19) {
            return " x[" + f16 + "], y[" + f17 + "], z[" + f18 + "], acc[" + f19 + "], mIsMoving[" + as.this.f77047v + "], mEnbaleProximiy[" + as.this.f77041p + "], mIsAppOnForeground[" + as.this.f77039n + "], mIsStarted[" + as.this.f77044s + "], mPowerkeyStatu[" + as.this.f77036k + "], mlongDistense[" + as.this.f77046u + "]";
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            boolean z16;
            boolean z17;
            boolean z18;
            as asVar;
            int i3;
            SessionInfo f16;
            if (sensorEvent.sensor.getType() != 1) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            boolean unused = as.this.f77047v;
            float[] fArr = sensorEvent.values;
            float f17 = fArr[0];
            float f18 = fArr[1];
            float f19 = fArr[2];
            float f26 = (f17 * f17) + (f18 * f18) + (f19 * f19);
            if (f26 >= 77.0f && f26 <= 106.0f) {
                if (currentTimeMillis - this.f77050e > 300) {
                    as.this.f77047v = false;
                }
            } else {
                this.f77050e = currentTimeMillis;
                as.this.f77047v = true;
            }
            if (com.tencent.av.r.h0() != null && (f16 = com.tencent.av.n.e().f()) != null && (f16.f73035i == 3 || f16.M0)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && as.this.f77041p && as.this.f77039n && !as.this.f77046u && (i3 = (asVar = as.this).f77036k) != 1 && i3 != 3) {
                if (asVar.f77047v) {
                    z18 = false;
                    z17 = true;
                }
                z18 = false;
                z17 = false;
            } else {
                if (as.this.f77036k != 2) {
                    z17 = false;
                    z18 = true;
                }
                z18 = false;
                z17 = false;
            }
            as.this.f77048w = z16;
            if (z18) {
                as asVar2 = as.this;
                if (asVar2.f77044s) {
                    QLog.d(asVar2.f77026a, 1, "toggleProximityWakeLock[false], when[AccelerationSensorEventListener]," + a(f17, f18, f19, f26));
                    as.this.s(false, false);
                    return;
                }
                return;
            }
            if (z17) {
                as asVar3 = as.this;
                if (!asVar3.f77044s) {
                    QLog.d(asVar3.f77026a, 1, "toggleProximityWakeLock[true], when[AccelerationSensorEventListener]" + a(f17, f18, f19, f26));
                    as.this.s(true, false);
                }
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c implements SensorEventListener {

        /* renamed from: d, reason: collision with root package name */
        long f77052d = 0;

        /* renamed from: e, reason: collision with root package name */
        float f77053e = 3.1f;

        /* renamed from: f, reason: collision with root package name */
        boolean f77054f = true;

        /* renamed from: h, reason: collision with root package name */
        float f77055h = 0.0f;

        /* renamed from: i, reason: collision with root package name */
        boolean f77056i = false;

        /* renamed from: m, reason: collision with root package name */
        boolean f77057m = false;
        boolean C = false;

        c() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:44:0x00c5, code lost:
        
            if (r13.C == r9.f77047v) goto L50;
         */
        @Override // android.hardware.SensorEventListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onSensorChanged(SensorEvent sensorEvent) {
            boolean z16;
            SessionInfo f16;
            String[] strArr;
            if (sensorEvent.sensor.getType() != 8) {
                return;
            }
            float f17 = this.f77055h;
            boolean z17 = false;
            float f18 = sensorEvent.values[0];
            this.f77055h = f18;
            Sensor sensor = as.this.f77030e;
            if (sensor != null && this.f77053e > sensor.getMaximumRange()) {
                this.f77053e = as.this.f77030e.getMaximumRange();
            }
            boolean z18 = true;
            if (f18 >= 0.0d && f18 < this.f77053e) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (this.f77054f) {
                this.f77054f = false;
                if (z16) {
                    as asVar = as.this;
                    asVar.f77036k = 3;
                    asVar.f77045t = !z16;
                    as.this.f77035j.g();
                }
            }
            if (as.this.f77030e == null || com.tencent.av.r.h0() == null || (f16 = com.tencent.av.n.e().f()) == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            boolean z19 = as.this.f77046u;
            as.this.f77046u = !z16;
            if (as.this.f77045t != as.this.f77046u) {
                as asVar2 = as.this;
                if (3 == asVar2.f77036k) {
                    asVar2.f77035j.c();
                }
                as.this.f77036k = 0;
            }
            if (currentTimeMillis - this.f77052d <= 1000 && z19 == as.this.f77046u && this.f77056i == f16.I0) {
                boolean z26 = this.f77057m;
                as asVar3 = as.this;
                if (z26 == asVar3.f77027b) {
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.d(as.this.f77026a, 4, "onSensorChanged distance[" + f17 + "->" + f18 + "], mlongDistense[" + as.this.f77046u + "], lastlongDistense[" + z19 + "], mIsMoving[" + this.C + "->" + as.this.f77047v + "], mSensorSet[" + this.f77057m + "->" + as.this.f77027b + "], isSpeakerOn[" + this.f77056i + "->" + f16.I0 + "]");
            }
            this.f77052d = currentTimeMillis;
            this.f77056i = f16.I0;
            as asVar4 = as.this;
            this.f77057m = asVar4.f77027b;
            this.C = asVar4.f77047v;
            if (z16 && as.this.f77047v) {
                String[] strArr2 = f16.H0;
                if (f16.I0 && strArr2 != null) {
                    int i3 = 0;
                    while (true) {
                        if (i3 < strArr2.length) {
                            if (strArr2[i3].equals(TraeConstants.DEVICE_WIRED_HEADSET) || strArr2[i3].equals(TraeConstants.DEVICE_BLUETOOTH_HEADSET)) {
                                break;
                            } else {
                                i3++;
                            }
                        } else {
                            z17 = true;
                            break;
                        }
                    }
                    if (!SmallScreenUtils.p(BaseApplicationImpl.getApplication())) {
                        if (QLog.isColorLevel()) {
                            QLog.d(as.this.f77026a, 2, "is App on background , Not execute sensor pressHandFreeBtn !!!");
                            return;
                        }
                        return;
                    }
                    if (z17 && as.this.f77042q) {
                        if (QLog.isColorLevel()) {
                            QLog.d(as.this.f77026a, 2, "1.setSensors pressHandFreeBtn, current mSensorSet = " + as.this.f77027b);
                        }
                        TraeHelper traeHelper = as.this.f77038m;
                        if (traeHelper != null) {
                            traeHelper.S();
                        }
                        if (as.this.f77040o != null) {
                            as.this.f77040o.a();
                        }
                        as.this.f77027b = true;
                        DataReport.t();
                        return;
                    }
                    return;
                }
                return;
            }
            if (as.this.f77027b && !z16) {
                if (com.tencent.av.r.h0() != null) {
                    strArr = f16.H0;
                } else {
                    strArr = null;
                }
                if (strArr != null) {
                    for (int i16 = 0; i16 < strArr.length; i16++) {
                        if (strArr[i16].equals(TraeConstants.DEVICE_WIRED_HEADSET) || strArr[i16].equals(TraeConstants.DEVICE_BLUETOOTH_HEADSET)) {
                            z18 = false;
                            break;
                        }
                    }
                    if (z18 && as.this.f77042q) {
                        if (QLog.isColorLevel()) {
                            QLog.d(as.this.f77026a, 2, "2.setSensors pressHandFreeBtn, current mSensorSet = " + as.this.f77027b);
                        }
                        TraeHelper traeHelper2 = as.this.f77038m;
                        if (traeHelper2 != null) {
                            traeHelper2.S();
                        }
                        if (as.this.f77040o != null) {
                            as.this.f77040o.a();
                        }
                        DataReport.t();
                    }
                }
                as.this.f77027b = false;
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
        }
    }
}
