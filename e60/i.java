package e60;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class i {

    /* renamed from: b, reason: collision with root package name */
    private SensorManager f395758b;

    /* renamed from: d, reason: collision with root package name */
    private int f395760d;

    /* renamed from: e, reason: collision with root package name */
    private Sensor f395761e;

    /* renamed from: f, reason: collision with root package name */
    private SensorEventListener f395762f;

    /* renamed from: a, reason: collision with root package name */
    private int f395757a = -1;

    /* renamed from: c, reason: collision with root package name */
    private boolean f395759c = false;

    public i(Context context, int i3) {
        SensorManager sensorManager = (SensorManager) context.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        this.f395758b = sensorManager;
        this.f395760d = i3;
        Sensor defaultSensor = SensorMonitor.getDefaultSensor(sensorManager, 1);
        this.f395761e = defaultSensor;
        if (defaultSensor != null) {
            this.f395762f = new a();
        }
    }

    public boolean c() {
        if (this.f395761e != null) {
            return true;
        }
        return false;
    }

    public void d() {
        if (this.f395761e == null) {
            Log.w("QOC-QFSOrientationEventListener", "[disable] cannot detect sensors. invalid disable");
        } else if (this.f395759c) {
            QLog.d("QOC-QFSOrientationEventListener", 1, "[disable] orientation event disable.");
            this.f395758b.unregisterListener(this.f395762f);
            this.f395759c = false;
        }
    }

    public void e() {
        if (this.f395761e == null) {
            Log.w("QOC-QFSOrientationEventListener", "[enable] cannot detect sensors. not enabled");
        } else if (!this.f395759c) {
            QLog.d("QOC-QFSOrientationEventListener", 1, "[enable] orientation event enabled.");
            SensorMonitor.registerListener(this.f395758b, this.f395762f, this.f395761e, this.f395760d);
            this.f395759c = true;
        }
    }

    public abstract void f(int i3);

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements SensorEventListener {

        /* renamed from: d, reason: collision with root package name */
        private long f395763d = 0;

        /* renamed from: e, reason: collision with root package name */
        private long f395764e = uq3.c.J2(6);

        public a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            int i3;
            float[] fArr = sensorEvent.values;
            float f16 = -fArr[0];
            float f17 = -fArr[1];
            float f18 = -fArr[2];
            if (((f16 * f16) + (f17 * f17)) * 4.0f >= f18 * f18) {
                if (Math.abs(f18) > ((float) this.f395764e)) {
                    return;
                }
                if (Math.abs(f16) >= 10.0f || Math.abs(f17) >= 10.0f || Math.abs(f18) >= 10.0f) {
                    this.f395763d = System.currentTimeMillis();
                }
                if (System.currentTimeMillis() - this.f395763d <= 300) {
                    return;
                }
                i3 = 90 - Math.round(((float) Math.atan2(-f17, f16)) * 57.29578f);
                while (i3 >= 360) {
                    i3 -= 360;
                }
                while (i3 < 0) {
                    i3 += 360;
                }
            } else {
                i3 = -1;
            }
            if (i3 != i.this.f395757a) {
                i.this.f395757a = i3;
                i.this.f(i3);
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
        }
    }
}
