package com.tencent.ams.mosaic.jsengine.sensor.impl;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSValue;
import com.tencent.ams.mosaic.jsengine.a;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.sensor.MosaicSensor;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
public abstract class BaseSensorImpl implements MosaicSensor, SensorEventListener {
    static IPatchRedirector $redirector_ = null;
    private static final double NS2S;
    private static final String TAG = "BaseSensorImpl";
    private final Context mContext;
    protected com.tencent.ams.mosaic.jsengine.a mEngine;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private boolean mHasStart;
    private final int mNativeSensorType;
    protected JSFunction mOnChangedFunction;
    private JSFunction mOnErrorFunction;
    private final int mSampleFrequency;
    private Sensor mSensor;
    private boolean mSensorEventsDeliveredOnMainThread;
    private SensorManager mSensorManager;
    private final int mSensorType;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements a.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseSensorImpl.this);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.a.b
        public void onFail(JSFunction jSFunction) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSFunction);
            } else {
                f.e(BaseSensorImpl.TAG, "notify onError failed.");
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.a.b
        public void onSuccess(JSFunction jSFunction, JSValue jSValue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSFunction, (Object) jSValue);
            } else {
                f.e(BaseSensorImpl.TAG, "notify onError success");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58947);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            NS2S = TimeUnit.SECONDS.toNanos(1L);
        }
    }

    public BaseSensorImpl(Context context, com.tencent.ams.mosaic.jsengine.a aVar, int i3, int i16, int i17, JSFunction jSFunction, JSFunction jSFunction2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, aVar, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), jSFunction, jSFunction2);
            return;
        }
        this.mContext = context;
        this.mEngine = aVar;
        this.mSampleFrequency = i17;
        this.mOnErrorFunction = jSFunction2;
        this.mOnChangedFunction = jSFunction;
        this.mNativeSensorType = i3;
        this.mSensorType = i16;
        initSensor();
    }

    private int getInterval() {
        if (this.mSampleFrequency <= 0) {
            f.h(TAG, "invalid sample frequency, frequency: " + this.mSampleFrequency);
            return 2;
        }
        return (int) (TimeUnit.SECONDS.toMicros(1L) / this.mSampleFrequency);
    }

    private Sensor getSensor() {
        if (this.mSensor != null) {
            initSensor();
        }
        return this.mSensor;
    }

    private void initSensor() {
        SensorManager sensorManager;
        Context context;
        if (this.mSensorManager == null && (context = this.mContext) != null) {
            this.mSensorManager = (SensorManager) context.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        }
        if (this.mSensor == null && (sensorManager = this.mSensorManager) != null) {
            this.mSensor = SensorMonitor.getDefaultSensor(sensorManager, this.mNativeSensorType);
        }
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread == null || !handlerThread.isAlive()) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("Mosaic-Sensor-" + getSensorType());
            this.mHandlerThread = baseHandlerThread;
            baseHandlerThread.start();
        }
        Handler handler = this.mHandler;
        if (handler == null || handler.getLooper() != this.mHandlerThread.getLooper()) {
            this.mHandler = new Handler(this.mHandlerThread.getLooper());
        }
    }

    protected abstract Object createSensorData(SensorEvent sensorEvent);

    @Override // com.tencent.ams.mosaic.jsengine.sensor.MosaicSensor
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        f.e(TAG, "destroy");
        stop();
        this.mSensorManager = null;
        this.mSensor = null;
        this.mHandler = null;
        this.mOnChangedFunction = null;
        this.mOnErrorFunction = null;
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null) {
            try {
                handlerThread.quitSafely();
            } catch (Throwable th5) {
                f.c(TAG, "quit handler thread error.", th5);
            }
        }
    }

    public final int getSensorType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.mSensorType;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) sensor, i3);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Object createSensorData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) sensorEvent);
        } else if (this.mOnChangedFunction != null && this.mEngine != null && sensorEvent != null && (createSensorData = createSensorData(sensorEvent)) != null) {
            this.mEngine.u(this.mOnChangedFunction, new Object[]{Integer.valueOf(getSensorType()), Double.valueOf(sensorEvent.timestamp / NS2S), createSensorData}, null);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.sensor.MosaicSensor
    public boolean setSensorEventsDeliveredOnMainThread(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, z16)).booleanValue();
        }
        f.e(TAG, "setSensorEventsDeliveredOnMainThread: " + z16);
        if (!this.mHasStart) {
            this.mSensorEventsDeliveredOnMainThread = z16;
            return true;
        }
        return false;
    }

    @Override // com.tencent.ams.mosaic.jsengine.sensor.MosaicSensor
    public void start() {
        boolean z16;
        com.tencent.ams.mosaic.jsengine.a aVar;
        Handler handler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        f.e(TAG, "start");
        if (!this.mHasStart) {
            this.mHasStart = true;
        }
        Sensor sensor = getSensor();
        if (sensor != null) {
            SensorManager sensorManager = this.mSensorManager;
            int interval = getInterval();
            if (this.mSensorEventsDeliveredOnMainThread) {
                handler = new Handler(Looper.getMainLooper());
            } else {
                handler = this.mHandler;
            }
            z16 = SensorMonitor.registerListener(sensorManager, this, sensor, interval, handler);
        } else {
            z16 = false;
        }
        if (!z16) {
            f.h(TAG, "sensor not enable.");
            JSFunction jSFunction = this.mOnErrorFunction;
            if (jSFunction != null && (aVar = this.mEngine) != null) {
                aVar.u(jSFunction, new Object[]{3, "sensor unavailable."}, new a());
            }
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.sensor.MosaicSensor
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        f.e(TAG, "stop");
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this, this.mSensor);
        }
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "{sensorType: " + getSensorType() + "mSampleFrequency: " + this.mSampleFrequency + "}";
    }
}
