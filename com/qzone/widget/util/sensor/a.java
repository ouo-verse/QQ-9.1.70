package com.qzone.widget.util.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;

/* compiled from: P */
/* loaded from: classes37.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private SensorManager f61149a;

    /* renamed from: b, reason: collision with root package name */
    private Sensor f61150b;

    /* renamed from: c, reason: collision with root package name */
    private Sensor f61151c;

    /* renamed from: i, reason: collision with root package name */
    private b f61157i;

    /* renamed from: d, reason: collision with root package name */
    private float[] f61152d = new float[3];

    /* renamed from: e, reason: collision with root package name */
    private float[] f61153e = new float[3];

    /* renamed from: f, reason: collision with root package name */
    private double f61154f = 0.0d;

    /* renamed from: g, reason: collision with root package name */
    private double f61155g = 0.0d;

    /* renamed from: h, reason: collision with root package name */
    private long f61156h = 0;

    /* renamed from: j, reason: collision with root package name */
    private SensorEventListener f61158j = new C0508a();

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface b {
        void a(double d16, double d17, double d18, double d19);
    }

    public a(b bVar) {
        this.f61157i = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (System.currentTimeMillis() - this.f61156h < 100) {
            return;
        }
        this.f61156h = System.currentTimeMillis();
        float[] fArr = new float[9];
        SensorManager.getRotationMatrix(fArr, null, this.f61152d, this.f61153e);
        SensorManager.getOrientation(fArr, new float[3]);
        double degrees = Math.toDegrees(r0[2]);
        double degrees2 = Math.toDegrees(r0[1]);
        double d16 = degrees - this.f61154f;
        double d17 = degrees2 - this.f61155g;
        this.f61154f = degrees;
        this.f61155g = degrees2;
        b bVar = this.f61157i;
        if (bVar != null) {
            bVar.a(degrees, d16, degrees2, d17);
        }
    }

    public void e() {
        SensorManager sensorManager;
        SensorManager sensorManager2;
        try {
            if (FeedGlobalEnv.getContext() == null) {
                return;
            }
            if (this.f61149a == null) {
                this.f61149a = (SensorManager) FeedGlobalEnv.getContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
            }
            if (this.f61150b == null && (sensorManager2 = this.f61149a) != null) {
                Sensor defaultSensor = SensorMonitor.getDefaultSensor(sensorManager2, 1);
                this.f61150b = defaultSensor;
                if (defaultSensor != null) {
                    com.qzone.proxy.feedcomponent.b.e("GifPlayController", "register sensor event Listener : mAccelerateSensor");
                    SensorMonitor.registerListener(this.f61149a, this.f61158j, this.f61150b, 3);
                }
            }
            if (this.f61151c != null || (sensorManager = this.f61149a) == null) {
                return;
            }
            Sensor defaultSensor2 = SensorMonitor.getDefaultSensor(sensorManager, 2);
            this.f61151c = defaultSensor2;
            if (defaultSensor2 != null) {
                com.qzone.proxy.feedcomponent.b.e("GifPlayController", "register sensor event Listener : mAccelerateSensor");
                SensorMonitor.registerListener(this.f61149a, this.f61158j, this.f61151c, 3);
            }
        } catch (Throwable th5) {
            com.qzone.proxy.feedcomponent.b.c("GifPlayController", "startSensorEvent exception " + th5.toString());
            try {
                SensorManager sensorManager3 = this.f61149a;
                if (sensorManager3 != null) {
                    sensorManager3.unregisterListener(this.f61158j);
                }
            } catch (Throwable th6) {
                com.qzone.proxy.feedcomponent.b.c("GifPlayController", "startSensorEvent unregisterListener exception " + th6.toString());
            }
        }
    }

    public void f() {
        if (this.f61149a != null) {
            com.qzone.proxy.feedcomponent.b.e("GifPlayController", "unregister sensor event Listener");
            this.f61149a.unregisterListener(this.f61158j);
        }
    }

    /* compiled from: P */
    /* renamed from: com.qzone.widget.util.sensor.a$a, reason: collision with other inner class name */
    /* loaded from: classes37.dex */
    class C0508a implements SensorEventListener {
        C0508a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            int type = sensorEvent.sensor.getType();
            if (type != 1) {
                if (type != 2) {
                    return;
                }
                a.this.f61153e = sensorEvent.values;
                return;
            }
            a.this.f61152d = sensorEvent.values;
            try {
                a.this.d();
            } catch (Throwable th5) {
                com.qzone.proxy.feedcomponent.b.d("GifPlayController", "calculateXAngle exception", th5);
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
        }
    }
}
