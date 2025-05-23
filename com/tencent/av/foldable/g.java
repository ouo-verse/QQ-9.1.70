package com.tencent.av.foldable;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;

/* compiled from: P */
/* loaded from: classes3.dex */
public class g extends a implements SensorEventListener {

    /* renamed from: f, reason: collision with root package name */
    private int f73749f = -1;

    /* renamed from: h, reason: collision with root package name */
    private final SensorManager f73750h;

    /* renamed from: i, reason: collision with root package name */
    private final Sensor f73751i;

    public g(SensorManager sensorManager, Sensor sensor) {
        this.f73750h = sensorManager;
        this.f73751i = sensor;
    }

    @Override // com.tencent.av.foldable.h
    public void a() {
        Sensor sensor;
        super.a();
        SensorManager sensorManager = this.f73750h;
        if (sensorManager != null && (sensor = this.f73751i) != null) {
            sensorManager.unregisterListener(this, sensor);
        }
    }

    @Override // com.tencent.av.foldable.h
    public void d() {
        Sensor sensor;
        SensorManager sensorManager = this.f73750h;
        if (sensorManager != null && (sensor = this.f73751i) != null) {
            SensorMonitor.registerListener(sensorManager, this, sensor, 3);
        }
    }

    @Override // com.tencent.av.foldable.a
    public int f() {
        return this.f73749f;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        this.f73749f = (int) sensorEvent.values[0];
        g();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
    }
}
