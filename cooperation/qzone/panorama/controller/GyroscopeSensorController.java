package cooperation.qzone.panorama.controller;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;

/* compiled from: P */
/* loaded from: classes38.dex */
public class GyroscopeSensorController implements SensorEventListener {
    private static final float NS2S = 1.0E-9f;
    private static final float SENSOR_SENSITIVITY = 1.0f;
    private Sensor mGyroscope;
    private SensorManager mSensorManager;
    private SensorChangeListener sensorChangeListener;
    private long timestamp;
    private float[] angle = new float[3];
    private float[] preAngle = new float[3];

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public interface SensorChangeListener {
        void onSensorChange(float f16, float f17, float f18);
    }

    public GyroscopeSensorController(Context context, SensorChangeListener sensorChangeListener) {
        SensorManager sensorManager = (SensorManager) context.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        this.mSensorManager = sensorManager;
        this.mGyroscope = SensorMonitor.getDefaultSensor(sensorManager, 4);
        this.sensorChangeListener = sensorChangeListener;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 4) {
            long j3 = this.timestamp;
            if (j3 != 0) {
                float f16 = ((float) (sensorEvent.timestamp - j3)) * NS2S;
                float[] fArr = this.angle;
                float f17 = fArr[0];
                float[] fArr2 = sensorEvent.values;
                fArr[0] = f17 + (fArr2[0] * f16);
                fArr[1] = fArr[1] + (fArr2[1] * f16);
                fArr[2] = fArr[2] + (fArr2[2] * f16);
                float degrees = ((float) Math.toDegrees(r3 - this.preAngle[0])) * 1.0f;
                float degrees2 = ((float) Math.toDegrees(this.angle[1] - this.preAngle[1])) * 1.0f;
                float degrees3 = ((float) Math.toDegrees(this.angle[2] - this.preAngle[2])) * 1.0f;
                SensorChangeListener sensorChangeListener = this.sensorChangeListener;
                if (sensorChangeListener != null) {
                    sensorChangeListener.onSensorChange(degrees, degrees2, degrees3);
                }
                float[] fArr3 = this.preAngle;
                float[] fArr4 = this.angle;
                fArr3[0] = fArr4[0];
                fArr3[1] = fArr4[1];
                fArr3[2] = fArr4[2];
            }
            this.timestamp = sensorEvent.timestamp;
        }
    }

    public void registerGyroscopeListener() {
        SensorMonitor.registerListener(this.mSensorManager, this, this.mGyroscope, 1);
    }

    public void unregisterGyroscopeListener() {
        this.mSensorManager.unregisterListener(this, this.mGyroscope);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
    }
}
