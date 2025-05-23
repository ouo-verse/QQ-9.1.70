package com.tencent.map.tools.orientation;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.OrientationEventListener;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class OrientationManager extends OrientationEventListener implements SensorEventListener {
    private static final float THRESHOLD = 1.0E-6f;
    private Context contextObj;
    private float mLastAngle;
    private List<OrientationListener> mListeners;
    private int mOrientation;

    public OrientationManager(Context context) {
        super(context, 3);
        this.mListeners = new ArrayList();
        this.contextObj = context;
    }

    public void addOrientationListener(OrientationListener orientationListener) {
        if (!this.mListeners.contains(orientationListener)) {
            this.mListeners.add(orientationListener);
            if (this.mListeners.size() == 1) {
                try {
                    enable();
                    SensorManager sensorManager = (SensorManager) this.contextObj.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
                    List<Sensor> sensorList = SensorMonitor.getSensorList(sensorManager, 11);
                    if (!sensorList.isEmpty()) {
                        SensorMonitor.registerListener(sensorManager, this, sensorList.get(0), 2);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public void destroy() {
        this.mListeners.clear();
        try {
            disable();
            SensorManager sensorManager = (SensorManager) this.contextObj.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
            if (!SensorMonitor.getSensorList(sensorManager, 11).isEmpty()) {
                sensorManager.unregisterListener(this);
            }
        } catch (Exception unused) {
        }
        this.contextObj = null;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i3) {
        if (i3 >= 0) {
            this.mOrientation = i3;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float f16;
        if (sensorEvent.sensor.getType() == 11) {
            float[] fArr = new float[16];
            SensorManager.getRotationMatrixFromVector(fArr, sensorEvent.values);
            SensorManager.getOrientation(fArr, new float[3]);
            boolean z16 = false;
            float degrees = (float) Math.toDegrees(r1[0]);
            float degrees2 = (float) Math.toDegrees(r1[1]);
            float degrees3 = (float) Math.toDegrees(r1[2]);
            if (Math.abs(degrees) <= THRESHOLD) {
                return;
            }
            if (Math.abs(this.mLastAngle - degrees) > 30.0f) {
                this.mLastAngle = degrees;
                return;
            }
            float f17 = (degrees + this.mLastAngle) / 2.0f;
            this.mLastAngle = f17;
            try {
                if (this.contextObj.getResources().getConfiguration().orientation == 2) {
                    z16 = true;
                }
            } catch (Exception unused) {
            }
            int i3 = this.mOrientation;
            if (z16) {
                if (i3 > 45 && i3 <= 135) {
                    f16 = 270.0f;
                } else if (i3 > 135 && i3 <= 225) {
                    f16 = 180.0f;
                } else if (i3 > 225 && i3 < 315) {
                    f16 = 90.0f;
                }
                f17 = (f17 + f16) % 360.0f;
            }
            try {
                ArrayList<OrientationListener> arrayList = new ArrayList();
                arrayList.addAll(this.mListeners);
                for (OrientationListener orientationListener : arrayList) {
                    if (orientationListener != null) {
                        orientationListener.onOrientationChanged(f17, degrees2, degrees3);
                    }
                }
            } catch (ArrayIndexOutOfBoundsException | OutOfMemoryError unused2) {
            }
        }
    }

    public void removeOrientationListener(OrientationListener orientationListener) {
        if (this.mListeners.contains(orientationListener)) {
            this.mListeners.remove(orientationListener);
            if (this.mListeners.isEmpty()) {
                try {
                    disable();
                    SensorManager sensorManager = (SensorManager) this.contextObj.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
                    if (!SensorMonitor.getSensorList(sensorManager, 11).isEmpty()) {
                        sensorManager.unregisterListener(this);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
    }
}
