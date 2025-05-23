package com.tencent.mobileqq.qzoneplayer.panorama;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;

/* compiled from: P */
/* loaded from: classes35.dex */
public class h implements SensorEventListener {

    /* renamed from: d, reason: collision with root package name */
    private SensorManager f279434d;

    /* renamed from: e, reason: collision with root package name */
    private Sensor f279435e;

    /* renamed from: f, reason: collision with root package name */
    private long f279436f;

    /* renamed from: m, reason: collision with root package name */
    private a f279439m;

    /* renamed from: h, reason: collision with root package name */
    private float[] f279437h = new float[3];

    /* renamed from: i, reason: collision with root package name */
    private float[] f279438i = new float[3];
    private boolean C = false;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface a {
        void a();

        void onSensorChange(float f16, float f17, float f18);
    }

    public h(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        this.f279434d = sensorManager;
        this.f279435e = SensorMonitor.getDefaultSensor(sensorManager, 4);
    }

    public boolean a() {
        return this.C;
    }

    public void b(a aVar) {
        this.f279439m = aVar;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 4) {
            long j3 = this.f279436f;
            if (j3 != 0) {
                float f16 = ((float) (sensorEvent.timestamp - j3)) * 1.0E-9f;
                float[] fArr = this.f279437h;
                float f17 = fArr[0];
                float[] fArr2 = sensorEvent.values;
                fArr[0] = f17 + (fArr2[0] * f16);
                fArr[1] = fArr[1] + (fArr2[1] * f16);
                fArr[2] = fArr[2] + (fArr2[2] * f16);
                float degrees = (float) Math.toDegrees(r3 - this.f279438i[0]);
                float degrees2 = (float) Math.toDegrees(this.f279437h[1] - this.f279438i[1]);
                float degrees3 = (float) Math.toDegrees(this.f279437h[2] - this.f279438i[2]);
                a aVar = this.f279439m;
                if (aVar != null) {
                    aVar.onSensorChange(degrees2, degrees, degrees3);
                }
                float[] fArr3 = this.f279438i;
                float[] fArr4 = this.f279437h;
                fArr3[0] = fArr4[0];
                fArr3[1] = fArr4[1];
                fArr3[2] = fArr4[2];
            }
            this.f279436f = sensorEvent.timestamp;
        }
    }

    public void c() {
        this.C = true;
        SensorMonitor.registerListener(this.f279434d, this, this.f279435e, 1);
        a aVar = this.f279439m;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void d() {
        this.C = false;
        this.f279434d.unregisterListener(this, this.f279435e);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
    }
}
