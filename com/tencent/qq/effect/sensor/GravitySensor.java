package com.tencent.qq.effect.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes22.dex */
public class GravitySensor implements SensorEventListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "GravitySensor";
    float[] mGravity;
    private ArrayList<WeakReference<GravitySensorListener>> mGravitySensorListenerList;
    private boolean mIsInitial;
    private boolean mIsPause;
    private boolean mIsReset;
    float[] mPreGravity;
    private Sensor mSensor;
    private SensorManager mSensorManager;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface GravitySensorListener {
        void updateGravityData(float[] fArr, boolean z16);
    }

    public GravitySensor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mGravity = new float[]{0.0f, 0.0f, 0.0f};
        this.mPreGravity = new float[]{0.0f, 0.0f, 0.0f};
        this.mIsInitial = false;
        this.mIsPause = false;
        this.mIsReset = false;
    }

    private float[] calibrateSensorData(SensorEvent sensorEvent) {
        float[] fArr = this.mGravity;
        float[] fArr2 = sensorEvent.values;
        fArr[0] = fArr2[0] / 9.8f;
        fArr[1] = fArr2[1] / 9.8f;
        fArr[2] = fArr2[2] / 9.8f;
        return fArr;
    }

    public void addListener(GravitySensorListener gravitySensorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) gravitySensorListener);
            return;
        }
        resume();
        synchronized (GravitySensor.class) {
            this.mGravitySensorListenerList.add(new WeakReference<>(gravitySensorListener));
        }
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager == null) {
            Log.e(TAG, "clear but mSensorManager is null.");
            return;
        }
        if (this.mSensor != null) {
            sensorManager.unregisterListener(this);
        }
        this.mIsInitial = false;
        this.mGravitySensorListenerList.clear();
    }

    public void init(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        this.mIsInitial = true;
        this.mGravitySensorListenerList = new ArrayList<>();
        SensorManager sensorManager = (SensorManager) context.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        this.mSensorManager = sensorManager;
        Sensor defaultSensor = SensorMonitor.getDefaultSensor(sensorManager, 9);
        this.mSensor = defaultSensor;
        SensorMonitor.registerListener(this.mSensorManager, this, defaultSensor, 1);
    }

    public boolean isInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.mIsInitial;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) sensor, i3);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) sensorEvent);
            return;
        }
        if (this.mIsPause) {
            return;
        }
        float round = Math.round(sensorEvent.values[0] * 10.0f);
        float round2 = Math.round(sensorEvent.values[1] * 10.0f);
        float round3 = Math.round(sensorEvent.values[2] * 10.0f);
        float[] fArr = this.mPreGravity;
        if (fArr[0] == round && fArr[1] == round2 && fArr[2] == round3) {
            return;
        }
        fArr[0] = round;
        fArr[1] = round2;
        fArr[2] = round3;
        Iterator<WeakReference<GravitySensorListener>> it = this.mGravitySensorListenerList.iterator();
        while (it.hasNext()) {
            GravitySensorListener gravitySensorListener = it.next().get();
            if (gravitySensorListener != null) {
                gravitySensorListener.updateGravityData(calibrateSensorData(sensorEvent), this.mIsReset);
            }
        }
        this.mIsReset = false;
    }

    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.mIsPause = true;
        }
    }

    public void removeListener(GravitySensorListener gravitySensorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) gravitySensorListener);
            return;
        }
        resume();
        synchronized (GravitySensor.class) {
            Iterator<WeakReference<GravitySensorListener>> it = this.mGravitySensorListenerList.iterator();
            while (it.hasNext()) {
                WeakReference<GravitySensorListener> next = it.next();
                if (gravitySensorListener == next.get()) {
                    this.mGravitySensorListenerList.remove(next);
                    return;
                }
            }
        }
    }

    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.mIsPause = false;
            this.mIsReset = true;
        }
    }
}
