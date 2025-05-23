package c.t.m.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Handler;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.map.geolocation.TencentDirectionListener;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;

/* compiled from: P */
/* loaded from: classes.dex */
public class d2 implements SensorEventListener {

    /* renamed from: h, reason: collision with root package name */
    public static volatile d2 f29538h;

    /* renamed from: a, reason: collision with root package name */
    public SensorManager f29539a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f29540b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f29541c;

    /* renamed from: d, reason: collision with root package name */
    public double f29542d;

    /* renamed from: e, reason: collision with root package name */
    public int f29543e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f29544f = false;

    /* renamed from: g, reason: collision with root package name */
    public TencentDirectionListener f29545g;

    public d2(Context context) {
        try {
            if (Build.VERSION.SDK_INT != 23) {
                this.f29539a = (SensorManager) context.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
            }
        } catch (Throwable unused) {
        }
        this.f29540b = this.f29539a != null;
    }

    public static d2 a(Context context) {
        if (f29538h == null) {
            f29538h = new d2(context);
        }
        return f29538h;
    }

    public boolean b() {
        return this.f29544f;
    }

    public void c() {
        try {
            if (this.f29540b && this.f29541c) {
                this.f29541c = false;
                this.f29542d = Double.NaN;
                this.f29539a.unregisterListener(this);
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
        try {
            if (sensor.getType() == 11 || sensor.getType() == 3) {
                this.f29543e = i3;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (sensorEvent.sensor.getType() == 11) {
                float[] fArr = new float[16];
                float[] fArr2 = new float[3];
                SensorManager.getRotationMatrixFromVector(fArr, sensorEvent.values);
                SensorManager.getOrientation(fArr, fArr2);
                double d16 = fArr2[0];
                synchronized (this) {
                    double d17 = (d16 * 180.0d) / 3.1415926d;
                    this.f29542d = d17;
                    TencentDirectionListener tencentDirectionListener = this.f29545g;
                    if (tencentDirectionListener != null) {
                        tencentDirectionListener.onDirectionChanged(d17, this.f29543e);
                    }
                }
                return;
            }
            if (sensorEvent.sensor.getType() == 3) {
                float f16 = sensorEvent.values[0] - 360.0f;
                if (f16 <= -180.0f) {
                    f16 += 360.0f;
                }
                synchronized (this) {
                    double d18 = f16;
                    this.f29542d = d18;
                    TencentDirectionListener tencentDirectionListener2 = this.f29545g;
                    if (tencentDirectionListener2 != null) {
                        tencentDirectionListener2.onDirectionChanged(d18, this.f29543e);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public int a(Handler handler, TencentDirectionListener tencentDirectionListener) {
        Sensor sensor;
        if (!this.f29540b) {
            return 2;
        }
        if (this.f29541c) {
            return 0;
        }
        try {
            sensor = SensorMonitor.getDefaultSensor(this.f29539a, 11);
        } catch (Throwable unused) {
            sensor = null;
        }
        if (sensor == null) {
            try {
                sensor = SensorMonitor.getDefaultSensor(this.f29539a, 3);
            } catch (Throwable unused2) {
            }
        }
        if (sensor != null) {
            SensorMonitor.registerListener(this.f29539a, this, sensor, 3, handler);
            this.f29545g = tencentDirectionListener;
            this.f29541c = true;
            return 0;
        }
        return 3;
    }

    public void a(boolean z16) {
        this.f29544f = z16;
    }

    public double a() {
        double d16;
        if (!this.f29541c) {
            return Double.NaN;
        }
        synchronized (this) {
            d16 = this.f29542d;
        }
        return d16;
    }
}
