package com.qzone.proxy.feedcomponent.widget;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;

/* compiled from: P */
/* loaded from: classes39.dex */
public class f implements SensorEventListener {

    /* renamed from: d, reason: collision with root package name */
    Handler f50950d;

    /* renamed from: e, reason: collision with root package name */
    Context f50951e;

    /* renamed from: f, reason: collision with root package name */
    SensorManager f50952f;

    /* renamed from: h, reason: collision with root package name */
    float f50953h;

    /* renamed from: i, reason: collision with root package name */
    boolean f50954i;

    /* renamed from: m, reason: collision with root package name */
    Sensor f50955m;

    public f(Context context, Handler handler) {
        this.f50951e = context;
        this.f50950d = handler;
        if (context != null && handler != null) {
            b();
            return;
        }
        throw new IllegalArgumentException();
    }

    void a() {
        Message obtain = Message.obtain();
        obtain.what = 2449;
        this.f50950d.dispatchMessage(obtain);
    }

    void b() {
        try {
            SensorManager sensorManager = (SensorManager) this.f50951e.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
            this.f50952f = sensorManager;
            Sensor defaultSensor = SensorMonitor.getDefaultSensor(sensorManager, 8);
            this.f50955m = defaultSensor;
            if (defaultSensor != null) {
                this.f50953h = defaultSensor.getMaximumRange();
            }
            if (this.f50953h > 10.0f) {
                this.f50953h = 10.0f;
            }
        } catch (Error | Exception unused) {
        }
    }

    public boolean c() {
        return this.f50954i;
    }

    public void d() {
        try {
            SensorMonitor.registerListener(this.f50952f, this, this.f50955m, 1);
        } catch (Error | Exception unused) {
        }
    }

    public void e() {
        try {
            this.f50952f.unregisterListener(this);
        } catch (Error | Exception unused) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() != 8) {
            return;
        }
        float f16 = sensorEvent.values[0];
        boolean z16 = this.f50954i;
        float f17 = this.f50953h;
        if (z16 != (f16 < f17)) {
            this.f50954i = f16 < f17;
            a();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
    }
}
