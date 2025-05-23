package com.tencent.mobileqq.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class dd {

    /* renamed from: a, reason: collision with root package name */
    private SensorManager f307617a;

    /* renamed from: b, reason: collision with root package name */
    private Sensor f307618b;

    /* renamed from: c, reason: collision with root package name */
    private float f307619c;

    /* renamed from: d, reason: collision with root package name */
    private c f307620d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f307621e;

    /* renamed from: g, reason: collision with root package name */
    private Context f307623g;

    /* renamed from: f, reason: collision with root package name */
    public boolean f307622f = false;

    /* renamed from: h, reason: collision with root package name */
    public SensorEventListener f307624h = new a();

    /* renamed from: i, reason: collision with root package name */
    private Handler f307625i = new b(Looper.getMainLooper());

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            synchronized (dd.this) {
                if (dd.this.f307620d != null) {
                    dd.this.f307620d.s2(dd.this.f307621e);
                } else if (QLog.isDevelopLevel()) {
                    QLog.d("QQLSActivity", 4, "QQLSSensor handler callback=null");
                }
            }
            super.handleMessage(message);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface c {
        void s2(boolean z16);
    }

    public dd(Context context, c cVar) {
        this.f307620d = cVar;
        this.f307623g = context;
    }

    public void f() {
        if (QLog.isColorLevel()) {
            QLog.d("QQLSSensor", 2, "LSSensor open=====");
        }
        this.f307621e = false;
        SensorManager sensorManager = (SensorManager) this.f307623g.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        this.f307617a = sensorManager;
        Sensor defaultSensor = SensorMonitor.getDefaultSensor(sensorManager, 8);
        this.f307618b = defaultSensor;
        if (defaultSensor != null) {
            this.f307622f = true;
            float maximumRange = defaultSensor.getMaximumRange();
            this.f307619c = maximumRange;
            if (maximumRange > 10.0f) {
                this.f307619c = 10.0f;
            }
            try {
                SensorMonitor.registerListener(this.f307617a, this.f307624h, this.f307618b, 2);
                return;
            } catch (Exception e16) {
                QLog.d("QQLSSensor", 1, "registerListener error", e16);
                return;
            }
        }
        this.f307622f = false;
        this.f307620d.s2(this.f307621e);
    }

    public void g() {
        if (QLog.isColorLevel()) {
            QLog.d("QQLSSensor", 2, "LSSensor shutdown=====");
        }
        SensorManager sensorManager = this.f307617a;
        if (sensorManager != null) {
            try {
                sensorManager.unregisterListener(this.f307624h);
            } catch (Exception e16) {
                QLog.d("QQLSSensor", 1, "unregisterListener error", e16);
            }
            this.f307617a = null;
        }
        synchronized (this) {
            this.f307620d = null;
        }
        this.f307618b = null;
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements SensorEventListener {
        a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (QLog.isDevelopLevel()) {
                QLog.d("QQLSSensor", 4, "QQLSSensor onSensorChanged" + sensorEvent.values[0]);
            }
            if (dd.this.f307620d == null) {
                return;
            }
            if (ah.n0()) {
                dd.this.f307622f = false;
                return;
            }
            if (sensorEvent.values[0] < dd.this.f307619c) {
                dd.this.f307621e = true;
            } else {
                dd.this.f307621e = false;
            }
            String model = DeviceInfoMonitor.getModel();
            if (ah.p0()) {
                if (dd.this.f307625i.hasMessages(1)) {
                    dd.this.f307625i.removeMessages(1);
                }
                dd.this.f307625i.sendMessageDelayed(dd.this.f307625i.obtainMessage(1), 150L);
            } else {
                if (!model.equalsIgnoreCase("mi 3c") && !model.equalsIgnoreCase("K-Touch W619") && !model.equalsIgnoreCase("mi 3w")) {
                    synchronized (dd.this) {
                        if (dd.this.f307620d != null) {
                            dd.this.f307620d.s2(dd.this.f307621e);
                        }
                    }
                    return;
                }
                if (dd.this.f307625i.hasMessages(1)) {
                    dd.this.f307625i.removeMessages(1);
                }
                dd.this.f307625i.sendMessageDelayed(dd.this.f307625i.obtainMessage(1), 250L);
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
        }
    }
}
