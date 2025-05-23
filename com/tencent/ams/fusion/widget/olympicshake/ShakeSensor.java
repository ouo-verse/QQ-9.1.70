package com.tencent.ams.fusion.widget.olympicshake;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.ams.fusion.widget.utils.FusionWidgetConfig;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.OnActivityLifecycleChanged;
import com.tencent.ams.fusion.widget.utils.SensorMocker;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ShakeSensor implements SensorEventListener, OnActivityLifecycleChanged.OnActivityLifecycleChangedListener {
    static IPatchRedirector $redirector_ = null;
    public static final float DEFAULT_SHAKE_FACTOR_X = 1.0f;
    public static final float DEFAULT_SHAKE_FACTOR_Y = 1.0f;
    public static final float DEFAULT_SHAKE_FACTOR_Z = 0.5f;
    public static final int DEFAULT_SHAKE_SAMPLE = 60;
    public static final float DEFAULT_SHAKE_THRESHOLD = 3.0f;
    public static final int DEFAULT_SHAKE_VALID_COUNT = 60;
    private static final String TAG = "ShakeSensor";
    private static final int UPTATE_INTERVAL_TIME = 16;
    private Context mContext;
    private int mCurrentActivityState;
    private int mCurrentShakeCount;
    private OnDebugShakeListener mDebugShakeListener;
    private long mFirstShakeSuccessTime;
    private long mFirstUpdateTime;
    private boolean mIsComplete;
    private boolean mIsFirstShake;
    private boolean mIsNeedRegister;
    private boolean mIsPause;
    private boolean mIsStart;
    private long mLastUpdateTime;
    private float mLastX;
    private float mLastY;
    private float mLastZ;
    private Sensor mSensor;
    private HandlerThread mSensorEventsDeliveredHandlerThread;
    private boolean mSensorEventsDeliveredOnMainThread;
    private SensorManager mSensorManager;
    private SensorMocker mSensorMocker;
    private int[] mShakeDirectcombine;
    private int mShakeDuration;
    private float mShakeFactorX;
    private float mShakeFactorY;
    private float mShakeFactorZ;
    private OnShakeListener mShakeListener;
    private int mShakeSampleRate;
    private float mShakeThreshold;
    private int mShakeValidCount;

    public ShakeSensor(Context context) {
        this(context, 3.0f, 60);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void callbackOnShaking(double d16) {
        OnShakeListener onShakeListener = this.mShakeListener;
        if (onShakeListener != null && !this.mIsComplete) {
            onShakeListener.onShaking(d16, this.mCurrentShakeCount);
        }
    }

    private boolean judgeByNewShakeRule() {
        int i3 = this.mCurrentShakeCount;
        int i16 = this.mShakeValidCount;
        if (i3 >= i16 && (i16 <= 1 || System.currentTimeMillis() - this.mFirstShakeSuccessTime > this.mShakeDuration)) {
            return true;
        }
        return false;
    }

    private boolean judgeByOldShakeRule() {
        if (this.mCurrentShakeCount >= this.mShakeValidCount) {
            return true;
        }
        return false;
    }

    private boolean judgeShakeResult(boolean z16, double d16) {
        boolean judgeByOldShakeRule;
        OnShakeListener onShakeListener = this.mShakeListener;
        if (onShakeListener != null && !this.mIsComplete) {
            if (z16) {
                judgeByOldShakeRule = judgeByNewShakeRule();
            } else {
                judgeByOldShakeRule = judgeByOldShakeRule();
            }
            if (judgeByOldShakeRule) {
                this.mIsComplete = true;
                onShakeListener.onShakeComplete(d16);
                Logger.i(TAG, "onShakeComplete: " + d16);
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean updateShakeInfoByShakeDirect(float f16, float f17, float f18, double d16) {
        int i3;
        int i16;
        int i17;
        Logger.i(TAG, "updateShakeInfoByShakeDirect: x:" + f16 + " y:" + f17 + " z:" + f18 + " last x:" + this.mLastX + " last y:" + this.mLastY + " last z:" + this.mLastZ);
        if (this.mLastX == 0.0f) {
            this.mLastX = f16;
        }
        if (this.mLastY == 0.0f) {
            this.mLastY = f17;
        }
        if (this.mLastZ == 0.0f) {
            this.mLastZ = f18;
        }
        boolean z16 = false;
        if (this.mLastX * f16 < 0.0f) {
            this.mLastX = f16;
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (this.mLastY * f17 < 0.0f) {
            this.mLastY = f17;
            i16 = 1;
        } else {
            i16 = 0;
        }
        if (this.mLastZ * f18 < 0.0f) {
            this.mLastZ = f18;
            i17 = 1;
        } else {
            i17 = 0;
        }
        Logger.i(TAG, "onSensorChanged: xChange:" + i3 + " yChange:" + i16 + " zChange:" + i17);
        int i18 = (i3 << 2) | (i16 << 1) | i17;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onSensorChanged: direct result:");
        sb5.append(Integer.toBinaryString(i18));
        Logger.i(TAG, sb5.toString());
        int[] iArr = this.mShakeDirectcombine;
        int length = iArr.length;
        int i19 = 0;
        while (true) {
            if (i19 >= length) {
                break;
            }
            int i26 = iArr[i19];
            Logger.i(TAG, "onSensorChanged: ShakeDirectcombine:" + Integer.toBinaryString(i26));
            if ((i18 & i26) == i26) {
                int i27 = this.mCurrentShakeCount + 1;
                this.mCurrentShakeCount = i27;
                if (i27 == 1) {
                    this.mFirstShakeSuccessTime = System.currentTimeMillis();
                    Logger.i(TAG, "mFirstShakeSuccessTime:" + this.mFirstShakeSuccessTime);
                }
                z16 = true;
            } else {
                i19++;
            }
        }
        callbackOnShaking(d16);
        return z16;
    }

    public void addActivityLifecycleListener(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) context);
        } else {
            OnActivityLifecycleChanged.addListener(context, this);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) sensor, i3);
            return;
        }
        Logger.d(TAG, " - onAccuracyChanged,  accuracy = " + i3);
    }

    @Override // com.tencent.ams.fusion.widget.utils.OnActivityLifecycleChanged.OnActivityLifecycleChangedListener
    public void onChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
            return;
        }
        Logger.i(TAG, "onChanged, state: " + i3);
        this.mCurrentActivityState = i3;
        if (i3 == 4 && this.mIsNeedRegister) {
            Logger.d(TAG, "onChanged, need register");
            register();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float f16;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) sensorEvent);
            return;
        }
        if (!this.mIsComplete && !this.mIsPause) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mFirstUpdateTime == 0) {
                this.mFirstUpdateTime = currentTimeMillis;
            }
            if (currentTimeMillis - this.mLastUpdateTime < 1000 / this.mShakeSampleRate) {
                return;
            }
            this.mLastUpdateTime = currentTimeMillis;
            int shakeSensorValidStartTime = FusionWidgetConfig.getShakeSensorValidStartTime();
            if (shakeSensorValidStartTime > 0 && this.mLastUpdateTime - this.mFirstUpdateTime < shakeSensorValidStartTime) {
                Logger.i(TAG, "shakeSensorValidStartTime return, shakeSensorValidStartTime: " + shakeSensorValidStartTime);
                return;
            }
            SensorMocker sensorMocker = this.mSensorMocker;
            if (sensorMocker != null) {
                sensorMocker.mockSensorEvent(sensorEvent);
            }
            float[] fArr = sensorEvent.values;
            float f17 = fArr[0];
            float f18 = fArr[1];
            float f19 = fArr[2];
            double sqrt = Math.sqrt((Math.pow(this.mShakeFactorX * f17, 2.0d) + Math.pow(this.mShakeFactorY * f18, 2.0d)) + Math.pow(this.mShakeFactorZ * f19, 2.0d)) / 9.8d;
            if (this.mIsFirstShake) {
                this.mIsFirstShake = false;
                float firstShakeSensorMaxValidValue = FusionWidgetConfig.getFirstShakeSensorMaxValidValue();
                if (firstShakeSensorMaxValidValue > 0.0f && sqrt > firstShakeSensorMaxValidValue) {
                    this.mIsComplete = true;
                    Logger.i(TAG, "firstShakeSensorMaxValidValue return, " + firstShakeSensorMaxValidValue + ", shakeValue: " + sqrt);
                    return;
                }
            }
            OnDebugShakeListener onDebugShakeListener = this.mDebugShakeListener;
            if (onDebugShakeListener != null) {
                f16 = f19;
                onDebugShakeListener.onShakeSensorChanged(new double[]{this.mShakeFactorX, this.mShakeFactorY, this.mShakeFactorZ, f17, f18, f16, sqrt});
            } else {
                f16 = f19;
            }
            float shakeSensorMaxValidValue = FusionWidgetConfig.getShakeSensorMaxValidValue();
            if (shakeSensorMaxValidValue > 0.0f && sqrt > shakeSensorMaxValidValue) {
                Logger.w(TAG, "shakeValue is invalid: bigger than max valid value");
                return;
            }
            int[] iArr = this.mShakeDirectcombine;
            if (iArr != null && iArr.length > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (sqrt >= this.mShakeThreshold) {
                if (z16) {
                    Logger.i(TAG, "ShakeDirectcombine: " + Arrays.toString(this.mShakeDirectcombine));
                    if (updateShakeInfoByShakeDirect(f17, f18, f16, sqrt) && judgeShakeResult(true, sqrt)) {
                        Logger.i(TAG, "useShakeDirectJudgement onShakeComplete: cost time = " + (System.currentTimeMillis() - this.mFirstShakeSuccessTime));
                        return;
                    }
                } else {
                    this.mCurrentShakeCount++;
                }
            }
            if (!z16) {
                callbackOnShaking(sqrt);
                judgeShakeResult(false, sqrt);
            }
        }
    }

    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            Logger.i(TAG, "pause");
            this.mIsPause = true;
        }
    }

    public boolean register() {
        SensorManager sensorManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        Logger.i(TAG, "register");
        if (this.mIsStart) {
            Logger.d(TAG, "registered");
            return true;
        }
        int i3 = this.mCurrentActivityState;
        if (i3 != 3 && i3 != 5 && i3 != 6 && Utils.isAppOnForeground(this.mContext)) {
            SensorManager sensorManager2 = (SensorManager) this.mContext.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
            this.mSensorManager = sensorManager2;
            if (this.mSensor == null && sensorManager2 != null) {
                this.mSensor = SensorMonitor.getDefaultSensor(sensorManager2, 1);
            }
            Sensor sensor = this.mSensor;
            if (sensor != null && (sensorManager = this.mSensorManager) != null) {
                try {
                    if (this.mSensorEventsDeliveredOnMainThread) {
                        this.mIsStart = SensorMonitor.registerListener(sensorManager, this, sensor, 1);
                    } else {
                        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("SensorEventsDeliveredHandlerThread");
                        this.mSensorEventsDeliveredHandlerThread = baseHandlerThread;
                        baseHandlerThread.start();
                        this.mIsStart = SensorMonitor.registerListener(this.mSensorManager, this, this.mSensor, 1, new Handler(this.mSensorEventsDeliveredHandlerThread.getLooper()));
                    }
                    Logger.i(TAG, "register success: " + this.mIsStart);
                } catch (Throwable unused) {
                    Logger.w(TAG, "register listener failed");
                }
            } else {
                Logger.w(TAG, " - \u4f20\u611f\u5668\u521d\u59cb\u5316\u5931\u8d25!");
            }
            if (FusionWidgetConfig.isEnableMockSensor()) {
                SensorMocker sensorMocker = new SensorMocker();
                this.mSensorMocker = sensorMocker;
                sensorMocker.startMock(0);
            }
            return this.mIsStart;
        }
        Logger.w(TAG, "register failed: in background");
        this.mIsNeedRegister = true;
        return false;
    }

    public void removeActivityLifecycleListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            OnActivityLifecycleChanged.removeListener(this);
        }
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        this.mIsComplete = false;
        this.mLastUpdateTime = 0L;
        this.mCurrentShakeCount = 0;
        this.mLastX = 0.0f;
        this.mLastY = 0.0f;
        this.mLastZ = 0.0f;
        this.mFirstShakeSuccessTime = 0L;
        this.mIsFirstShake = true;
    }

    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Logger.i(TAG, "resume");
        if (!this.mIsStart && this.mIsNeedRegister) {
            register();
        }
        this.mIsPause = false;
    }

    public void setDebugShakeListener(OnDebugShakeListener onDebugShakeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) onDebugShakeListener);
        } else {
            this.mDebugShakeListener = onDebugShakeListener;
        }
    }

    public void setSensorEventsDeliveredOnMainThread(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.mSensorEventsDeliveredOnMainThread = z16;
        }
    }

    public void setShakeDirectCombine(int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) iArr);
        } else {
            this.mShakeDirectcombine = iArr;
        }
    }

    public void setShakeFactor(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
            return;
        }
        this.mShakeFactorX = f16;
        this.mShakeFactorY = f17;
        this.mShakeFactorZ = f18;
    }

    public void setShakeListener(OnShakeListener onShakeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) onShakeListener);
        } else {
            this.mShakeListener = onShakeListener;
        }
    }

    public void setShakeSampleRate(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        } else {
            if (i3 == 0) {
                return;
            }
            this.mShakeSampleRate = i3;
        }
    }

    public void setShakeTimeDuration(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.mShakeDuration = i3;
        }
    }

    public void setShakeValue(float f16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16), Integer.valueOf(i3));
        } else {
            this.mShakeThreshold = f16;
            this.mShakeValidCount = i3;
        }
    }

    public void unregister() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Logger.i(TAG, "unregister");
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        OnActivityLifecycleChanged.removeListener(this);
        this.mIsStart = false;
        this.mShakeListener = null;
        this.mDebugShakeListener = null;
        this.mShakeValidCount = 0;
        this.mIsNeedRegister = false;
        HandlerThread handlerThread = this.mSensorEventsDeliveredHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        this.mFirstUpdateTime = 0L;
    }

    public ShakeSensor(Context context, float f16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Float.valueOf(f16), Integer.valueOf(i3));
            return;
        }
        this.mSensorManager = null;
        this.mSensor = null;
        this.mShakeListener = null;
        this.mDebugShakeListener = null;
        this.mShakeDuration = 0;
        this.mShakeSampleRate = 60;
        this.mShakeDirectcombine = null;
        this.mShakeFactorX = 1.0f;
        this.mShakeFactorY = 1.0f;
        this.mShakeFactorZ = 0.5f;
        this.mLastX = 0.0f;
        this.mLastY = 0.0f;
        this.mLastZ = 0.0f;
        this.mIsFirstShake = true;
        this.mIsStart = false;
        this.mIsPause = false;
        this.mSensorEventsDeliveredOnMainThread = true;
        this.mContext = context;
        this.mShakeThreshold = f16;
        this.mShakeValidCount = i3;
        OnActivityLifecycleChanged.addListener(context, this);
        Logger.d(TAG, " - threshold: " + f16 + "\uff0c validCount: " + i3);
    }
}
