package com.tencent.ams.fusion.widget.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SensorChecker implements SensorEventListener {
    static IPatchRedirector $redirector_ = null;
    public static final int DEFAULT_SENSOR_CHECK_WAIT_TIME = 100;
    public static final int DEFAULT_SENSOR_UPDATE_VALID_TIME = 1000;
    private static final int MSG_SENSOR_DISABLE = 1;
    private static final int MSG_SENSOR_ENABLE = 0;
    private static final String TAG = "SensorChecker";
    private static final BlockingItem<Boolean> mIsSensorEnable;
    private AvailableChangeListener mAvailableChangeListener;
    private int mCheckWaitTime;
    private boolean mIsRegisterListener;
    private Sensor mSensor;
    private SensorManager mSensorManager;
    private int mSensorType;
    private final Handler mUpdateHandler;
    private int mUpdateValidTime;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface AvailableChangeListener {
        void onChanged(boolean z16);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39034);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            mIsSensorEnable = new BlockingItem<>();
        }
    }

    public SensorChecker(Context context, int i3) {
        this(context, i3, 1000, 100);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
    }

    private void initSensor(Context context, int i3) {
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
            this.mSensorManager = sensorManager;
            this.mSensorType = i3;
            this.mSensor = SensorMonitor.getDefaultSensor(sensorManager, i3);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSensorEnable(boolean z16) {
        BlockingItem<Boolean> blockingItem = mIsSensorEnable;
        Boolean peek = blockingItem.peek();
        if (peek == null || peek.booleanValue() != z16) {
            blockingItem.put(Boolean.valueOf(z16));
            AvailableChangeListener availableChangeListener = this.mAvailableChangeListener;
            if (availableChangeListener != null) {
                availableChangeListener.onChanged(z16);
            }
        }
    }

    private void start() {
        if (!this.mIsRegisterListener) {
            Logger.i(TAG, "start: register listener");
            try {
                Sensor sensor = this.mSensor;
                if (sensor != null) {
                    if (SensorMonitor.registerListener(this.mSensorManager, this, sensor, 3)) {
                        this.mIsRegisterListener = true;
                        Logger.i(TAG, "start: register listener success");
                        this.mUpdateHandler.sendEmptyMessageDelayed(1, this.mUpdateValidTime);
                        return;
                    }
                } else {
                    Logger.w(TAG, "sensor get failed");
                }
            } catch (Throwable unused) {
            }
            Logger.w(TAG, "start: register listener failed");
            setSensorEnable(false);
        }
    }

    public boolean isSensorEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        start();
        try {
            Boolean tryTake = mIsSensorEnable.tryTake(this.mCheckWaitTime);
            if (tryTake == null) {
                return false;
            }
            return tryTake.booleanValue();
        } catch (InterruptedException unused) {
            return false;
        }
    }

    public boolean isSensorGetFailed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.mSensor == null) {
            return true;
        }
        return false;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) sensor, i3);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) sensorEvent);
            return;
        }
        float[] fArr = sensorEvent.values;
        if (fArr != null && fArr.length == 3) {
            Logger.i(TAG, "onSensorChanged: " + Arrays.toString(sensorEvent.values));
            float[] fArr2 = sensorEvent.values;
            if (fArr2[0] == 0.0f && fArr2[1] == 0.0f && fArr2[2] == 0.0f) {
                return;
            }
            this.mUpdateHandler.removeMessages(1);
            this.mUpdateHandler.sendEmptyMessage(0);
        }
    }

    public void setAvailableChangeListener(AvailableChangeListener availableChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) availableChangeListener);
        } else {
            this.mAvailableChangeListener = availableChangeListener;
        }
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
            this.mIsRegisterListener = false;
        }
        this.mUpdateHandler.removeCallbacksAndMessages(null);
        this.mAvailableChangeListener = null;
    }

    public SensorChecker(Context context, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.mUpdateValidTime = 1000;
        this.mCheckWaitTime = 100;
        this.mUpdateHandler = new Handler(Looper.getMainLooper()) { // from class: com.tencent.ams.fusion.widget.utils.SensorChecker.1
            static IPatchRedirector $redirector_;

            {
                super(r5);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SensorChecker.this, (Object) r5);
                }
            }

            @Override // android.os.Handler
            public void handleMessage(@NonNull Message message) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) message);
                    return;
                }
                int i18 = message.what;
                if (i18 == 0) {
                    SensorChecker.this.setSensorEnable(true);
                    sendEmptyMessageDelayed(1, SensorChecker.this.mUpdateValidTime);
                } else if (i18 == 1) {
                    SensorChecker.this.setSensorEnable(false);
                }
            }
        };
        initSensor(context, i3);
        if (i16 > 0) {
            this.mUpdateValidTime = i16;
        }
        if (i17 > 0) {
            this.mCheckWaitTime = i17;
        }
        start();
    }
}
