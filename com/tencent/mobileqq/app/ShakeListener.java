package com.tencent.mobileqq.app;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ShakeListener implements SensorEventListener {
    static IPatchRedirector $redirector_ = null;
    private static final int TOTAL_THRESHOLD = 180;
    private int cnt;
    private long lastTime;
    private float lastX;
    private float lastY;
    private float lastZ;
    private float totalShake;

    public ShakeListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.cnt = 0;
        }
    }

    private void initShake(long j3) {
        this.lastTime = j3;
        this.lastX = 0.0f;
        this.lastY = 0.0f;
        this.lastZ = 0.0f;
        this.totalShake = 0.0f;
        this.cnt = 0;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) sensor, i3);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) sensorEvent);
            return;
        }
        if (sensorEvent.sensor.getType() == 1) {
            float[] fArr = sensorEvent.values;
            float f16 = fArr[0];
            float f17 = fArr[1];
            float f18 = fArr[2];
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = currentTimeMillis - this.lastTime;
            if (j3 > 5000) {
                initShake(currentTimeMillis);
                return;
            }
            if (j3 > 80) {
                float f19 = this.lastX;
                float f26 = 0.0f;
                if (f19 != 0.0f || this.lastY != 0.0f || this.lastZ != 0.0f) {
                    f26 = Math.abs(f18 - this.lastZ) + Math.abs(f16 - f19) + Math.abs(f17 - this.lastY);
                }
                float f27 = this.totalShake + f26;
                this.totalShake = f27;
                if (f27 > 180.0f && this.cnt >= 3) {
                    if (QLog.isColorLevel()) {
                        QLog.d("CIO_test", 2, "now[" + f16 + "," + f17 + "," + f18 + "]duration:" + j3 + " shake:" + f26);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("last[");
                        sb5.append(this.lastX);
                        sb5.append(",");
                        sb5.append(this.lastY);
                        sb5.append(",");
                        sb5.append(this.lastZ);
                        sb5.append("]total_shake:");
                        sb5.append(f26);
                        QLog.d("CIO_test", 2, sb5.toString());
                    }
                    shake();
                    initShake(currentTimeMillis);
                    return;
                }
                int i3 = this.cnt;
                if (i3 < 10) {
                    this.cnt = i3 + 1;
                    this.lastX = f16;
                    this.lastY = f17;
                    this.lastZ = f18;
                    this.lastTime = currentTimeMillis;
                    return;
                }
                initShake(currentTimeMillis);
            }
        }
    }

    protected void shake() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }
}
