package com.tencent.youtu.ytagreflectlivecheck.worker;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SensorManagerWorker {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "MicroMsg.LightSensor";
    private boolean mHasStarted;
    private LightSensorListener mLightSensorListener;
    private OnGetValue mOnGetValue;
    private SensorManager mSensorManager;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class LightSensorListener implements SensorEventListener {
        static IPatchRedirector $redirector_;
        private float lux;

        LightSensorListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) SensorManagerWorker.this);
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) sensor, i3);
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) sensorEvent);
            } else if (sensorEvent.sensor.getType() == 5) {
                this.lux = sensorEvent.values[0];
                if (SensorManagerWorker.this.mOnGetValue != null) {
                    SensorManagerWorker.this.mOnGetValue.onGetValue(this.lux);
                }
            }
        }

        public /* synthetic */ LightSensorListener(SensorManagerWorker sensorManagerWorker, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) sensorManagerWorker, (Object) anonymousClass1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnGetValue {
        void onGetValue(float f16);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class Singleton {
        static IPatchRedirector $redirector_;
        private static SensorManagerWorker instance;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16295);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                instance = new SensorManagerWorker(null);
            }
        }

        Singleton() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public /* synthetic */ SensorManagerWorker(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) anonymousClass1);
    }

    public static SensorManagerWorker getInstance() {
        return Singleton.instance;
    }

    public float getLux() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
        }
        if (this.mLightSensorListener != null) {
            Log.d(TAG, "Light lux: " + this.mLightSensorListener.lux);
            return this.mLightSensorListener.lux;
        }
        return -1.0f;
    }

    public int start(Context context, OnGetValue onGetValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) onGetValue)).intValue();
        }
        if (this.mHasStarted) {
            YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "[SensorManagerWorker.start] light sensor has started");
            return 2;
        }
        this.mHasStarted = true;
        SensorManager sensorManager = (SensorManager) context.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        this.mSensorManager = sensorManager;
        Sensor defaultSensor = SensorMonitor.getDefaultSensor(sensorManager, 5);
        if (defaultSensor != null) {
            LightSensorListener lightSensorListener = new LightSensorListener(this, null);
            this.mLightSensorListener = lightSensorListener;
            SensorMonitor.registerListener(this.mSensorManager, lightSensorListener, defaultSensor, 3);
            this.mOnGetValue = onGetValue;
            return 0;
        }
        YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "[SensorManagerWorker.start] System do not have lightSensor");
        return 1;
    }

    public void stop() {
        SensorManager sensorManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (this.mHasStarted && (sensorManager = this.mSensorManager) != null) {
            this.mHasStarted = false;
            sensorManager.unregisterListener(this.mLightSensorListener);
        }
    }

    SensorManagerWorker() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mHasStarted = false;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
