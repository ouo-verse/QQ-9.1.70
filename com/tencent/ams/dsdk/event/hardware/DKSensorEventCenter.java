package com.tencent.ams.dsdk.event.hardware;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class DKSensorEventCenter {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DKSensorEventCenter";
    private Handler mHandler;
    private long mLastUpdateTimeMillis;
    private Listener mListener;
    private int mSamplingPeriodUs;
    private long mUpdateIntervalMillis;
    private WeakReference<DKEngine> mWeakEngine;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static final class EventName {
        static IPatchRedirector $redirector_ = null;
        private static final String ON_DEVICE_UPDATE = "onDeviceUpdated";

        EventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public final class Listener implements SensorEventListener {
        static IPatchRedirector $redirector_;

        Listener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) DKSensorEventCenter.this);
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) sensor, i3);
                return;
            }
            DLog.i(DKSensorEventCenter.TAG, "[Listener][onAccuracyChanged] accuracy:" + i3);
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) sensorEvent);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (DKSensorEventCenter.this.mUpdateIntervalMillis == WebViewConstants.WV.ENABLE_WEBAIO_SWITCH || DKSensorEventCenter.this.mLastUpdateTimeMillis == WebViewConstants.WV.ENABLE_WEBAIO_SWITCH || currentTimeMillis - DKSensorEventCenter.this.mLastUpdateTimeMillis >= DKSensorEventCenter.this.mUpdateIntervalMillis) {
                DKSensorEventCenter.this.mLastUpdateTimeMillis = currentTimeMillis;
                DKSensorEventCenter.this.sendEvent(sensorEvent);
            }
        }

        /* synthetic */ Listener(DKSensorEventCenter dKSensorEventCenter, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) dKSensorEventCenter, (Object) anonymousClass1);
        }
    }

    public DKSensorEventCenter(WeakReference<DKEngine> weakReference, Handler handler, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, weakReference, handler, Integer.valueOf(i3));
            return;
        }
        this.mUpdateIntervalMillis = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        this.mLastUpdateTimeMillis = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        this.mHandler = handler;
        this.mWeakEngine = weakReference;
        this.mSamplingPeriodUs = i3;
    }

    private boolean isValid() {
        if (this.mSamplingPeriodUs != Integer.MIN_VALUE) {
            long j3 = this.mUpdateIntervalMillis;
            if (j3 == WebViewConstants.WV.ENABLE_WEBAIO_SWITCH || j3 >= 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean registerImpl(Context context) {
        if (this.mListener != null) {
            DLog.i(TAG, "[registerImpl] do nothing, mListener is not null");
            return true;
        }
        if (context == null) {
            DLog.e(TAG, "[registerImpl] error, context is null");
            return false;
        }
        if (!isValid()) {
            DLog.e(TAG, "[registerImpl], not valid");
            return false;
        }
        reset();
        this.mListener = new Listener(this, null);
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
            Sensor defaultSensor = SensorMonitor.getDefaultSensor(sensorManager, getSensorType());
            DLog.i(TAG, "[registerImpl]");
            return SensorMonitor.registerListener(sensorManager, this.mListener, defaultSensor, this.mSamplingPeriodUs, this.mHandler);
        } catch (Throwable th5) {
            DLog.e(TAG, "[registerImpl]", th5);
            reset();
            return false;
        }
    }

    private void reset() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.mListener = null;
        this.mLastUpdateTimeMillis = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEvent(SensorEvent sensorEvent) {
        DKEngine dKEngine;
        WeakReference<DKEngine> weakReference = this.mWeakEngine;
        if (weakReference != null) {
            dKEngine = weakReference.get();
        } else {
            dKEngine = null;
        }
        if (dKEngine == null) {
            DLog.e(TAG, "[sendEvent] error, engine is null");
            return;
        }
        JSONObject createParams = createParams(sensorEvent);
        if (createParams != null && !JSONObject.NULL.equals(createParams)) {
            DLog.i(TAG, "[sendEvent] sendEvent params:" + createParams);
            dKEngine.sendEvent("onDeviceUpdated", createParams);
            return;
        }
        DLog.e(TAG, "[sendEvent] error, params is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean unRegisterImpl(Context context) {
        if (context == null) {
            DLog.e(TAG, "[unRegister] error, context is null");
            return false;
        }
        if (this.mListener == null) {
            DLog.i(TAG, "[unRegister] do nothing, mListener is null");
            return true;
        }
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
            DLog.i(TAG, "[unRegister]");
            sensorManager.unregisterListener(this.mListener);
            reset();
            return true;
        } catch (Throwable th5) {
            DLog.e(TAG, "[unRegister]", th5);
            return false;
        }
    }

    protected abstract JSONObject createParams(SensorEvent sensorEvent);

    protected abstract int getSensorType();

    public void register(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        } else {
            run(new Runnable(new WeakReference(context)) { // from class: com.tencent.ams.dsdk.event.hardware.DKSensorEventCenter.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ WeakReference val$weakContext;

                {
                    this.val$weakContext = r5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DKSensorEventCenter.this, (Object) r5);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        DKSensorEventCenter.this.registerImpl((Context) this.val$weakContext.get());
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean run(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) runnable)).booleanValue();
        }
        if (runnable == null) {
            DLog.e(TAG, "[run] error, runnable is null");
            return false;
        }
        Handler handler = this.mHandler;
        if (handler == null) {
            DLog.e(TAG, "[run] error, handler is null");
            return false;
        }
        if (handler.getLooper() == Looper.myLooper()) {
            runnable.run();
            return true;
        }
        this.mHandler.post(runnable);
        return true;
    }

    public void setUpdateIntervalMillis(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        } else {
            run(new Runnable(j3) { // from class: com.tencent.ams.dsdk.event.hardware.DKSensorEventCenter.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long val$value;

                {
                    this.val$value = j3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, DKSensorEventCenter.this, Long.valueOf(j3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        DKSensorEventCenter.this.setUpdateIntervalMillisImpl(this.val$value);
                    }
                }
            });
        }
    }

    public void setUpdateIntervalMillisImpl(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
        } else {
            this.mUpdateIntervalMillis = j3;
        }
    }

    public void unRegister(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        } else {
            run(new Runnable(new WeakReference(context)) { // from class: com.tencent.ams.dsdk.event.hardware.DKSensorEventCenter.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ WeakReference val$weakContext;

                {
                    this.val$weakContext = r5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DKSensorEventCenter.this, (Object) r5);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        DKSensorEventCenter.this.unRegisterImpl((Context) this.val$weakContext.get());
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }
}
