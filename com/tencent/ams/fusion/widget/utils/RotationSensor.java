package com.tencent.ams.fusion.widget.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.tencent.ams.fusion.widget.utils.OnActivityLifecycleChanged;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes3.dex */
public class RotationSensor implements SensorEventListener, OnActivityLifecycleChanged.OnActivityLifecycleChangedListener {
    static IPatchRedirector $redirector_ = null;
    private static final float NS2S = 1.0E-9f;
    protected static final String TAG = "RotationSensor";
    private static final String THREAD_NAME = "RotationSensor-Handler-Thread";
    protected Context mContext;
    protected volatile int mCurrentActivityState;
    private boolean mEnableOrientationCheck;
    private volatile Handler mHandler;
    protected volatile boolean mIsRegistered;
    private long mLastTimestamp;
    protected volatile OnRotationChangeListener mOnRotationChangeListener;
    private int mOrientation;
    private OrientationEventListener mOrientationEventListener;
    private final float[] mRotationVector;
    protected Sensor mSensor;
    protected SensorManager mSensorManager;
    protected SensorMocker mSensorMocker;
    protected int mStatus;
    private volatile HandlerThread mThread;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface OnRotationChangeListener {
        void onChanged(float f16, float f17, float f18);

        void onError();
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    protected @interface Status {
        public static final int ERROR = -1;
        public static final int IDLE = 0;
        public static final int PAUSE = 2;
        public static final int RUNNING = 1;
    }

    public RotationSensor(Context context) {
        this(context, false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private float getRealRotationX(float f16, float f17) {
        int i3 = this.mOrientation;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return -f16;
                    }
                    return f17;
                }
                return -f16;
            }
            return -f17;
        }
        return f16;
    }

    private float getRealRotationY(float f16, float f17) {
        int i3 = this.mOrientation;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return -f17;
                    }
                    return f16;
                }
                return -f17;
            }
            return -f16;
        }
        return f17;
    }

    private void initHandlerThread() {
        HandlerThread handlerThread = this.mThread;
        if (handlerThread == null || !handlerThread.isAlive()) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread(THREAD_NAME);
            baseHandlerThread.start();
            this.mThread = baseHandlerThread;
        }
    }

    private void initRotationVector() {
        float[] fArr = this.mRotationVector;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
    }

    private void initSensorManager() {
        try {
            Handler handler = getHandler();
            handler.post(new Runnable(handler) { // from class: com.tencent.ams.fusion.widget.utils.RotationSensor.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Handler val$handler;

                {
                    this.val$handler = handler;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) RotationSensor.this, (Object) handler);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        RotationSensor.this.initSensorManager(this.val$handler);
                    }
                }
            });
        } catch (Throwable th5) {
            Logger.e(TAG, "initSensorManager failed", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOrientation(int i3) {
        if (i3 == -1) {
            return;
        }
        if (i3 <= 350 && i3 >= 10) {
            if (i3 > 80 && i3 < 100) {
                this.mOrientation = 3;
            } else if (i3 > 170 && i3 < 190) {
                this.mOrientation = 2;
            } else if (i3 > 260 && i3 < 280) {
                this.mOrientation = 1;
            }
        } else {
            this.mOrientation = 0;
        }
        Logger.d(TAG, "setOrientation:" + this.mOrientation);
    }

    public Handler getHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Handler) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        initHandlerThread();
        Handler handler = this.mHandler;
        HandlerThread handlerThread = this.mThread;
        if (handler == null || handler.getLooper() != handlerThread.getLooper()) {
            Handler handler2 = new Handler(handlerThread.getLooper());
            this.mHandler = handler2;
            return handler2;
        }
        return handler;
    }

    protected int getSamplingPeriodUs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 2;
    }

    protected void initOrientation() {
        Display defaultDisplay;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (!this.mEnableOrientationCheck) {
            OrientationEventListener orientationEventListener = this.mOrientationEventListener;
            if (orientationEventListener != null) {
                orientationEventListener.disable();
                this.mOrientationEventListener = null;
                this.mOrientation = 0;
                return;
            }
            return;
        }
        if (this.mOrientationEventListener == null) {
            this.mOrientationEventListener = new OrientationEventListener(this.mContext) { // from class: com.tencent.ams.fusion.widget.utils.RotationSensor.2
                static IPatchRedirector $redirector_;

                {
                    super(r5);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RotationSensor.this, (Object) r5);
                    }
                }

                @Override // android.view.OrientationEventListener
                public void onOrientationChanged(int i3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        RotationSensor.this.setOrientation(i3);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                    }
                }
            };
        }
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            this.mOrientation = defaultDisplay.getRotation();
        }
        Logger.d(TAG, "initRotation:" + this.mOrientation);
        if (this.mOrientationEventListener.canDetectOrientation()) {
            this.mOrientationEventListener.enable();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) sensor, i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.utils.OnActivityLifecycleChanged.OnActivityLifecycleChangedListener
    public void onChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        Logger.i(TAG, "onChanged, state: " + i3);
        this.mCurrentActivityState = i3;
        if (i3 == 4 && this.mStatus == 1) {
            initSensorManager();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] mockRotation;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) sensorEvent);
            return;
        }
        if (sensorEvent == null) {
            return;
        }
        long j3 = this.mLastTimestamp;
        if (j3 == 0) {
            this.mLastTimestamp = sensorEvent.timestamp;
            return;
        }
        long j16 = sensorEvent.timestamp;
        float f16 = ((float) (j16 - j3)) * NS2S;
        this.mLastTimestamp = j16;
        float[] fArr = sensorEvent.values;
        float f17 = fArr[0] * f16;
        float f18 = fArr[1] * f16;
        float f19 = fArr[2] * f16;
        float[] fArr2 = this.mRotationVector;
        float f26 = fArr2[0] + f17;
        fArr2[0] = f26;
        fArr2[1] = fArr2[1] + f18;
        fArr2[2] = fArr2[2] + f19;
        float degrees = (float) Math.toDegrees(f26);
        float degrees2 = (float) Math.toDegrees(this.mRotationVector[1]);
        float degrees3 = (float) Math.toDegrees(this.mRotationVector[2]);
        SensorMocker sensorMocker = this.mSensorMocker;
        if (sensorMocker != null && (mockRotation = sensorMocker.mockRotation()) != null && mockRotation.length == 3) {
            degrees = mockRotation[0];
            degrees2 = mockRotation[1];
            degrees3 = mockRotation[2];
        }
        Logger.i(TAG, "rotationX: " + degrees + ", rotationY: " + degrees2 + ", rotationZ: " + degrees3);
        OnRotationChangeListener onRotationChangeListener = this.mOnRotationChangeListener;
        if (onRotationChangeListener != null) {
            if (this.mEnableOrientationCheck) {
                onRotationChangeListener.onChanged(getRealRotationX(degrees, degrees2), getRealRotationY(degrees, degrees2), degrees3);
            } else {
                onRotationChangeListener.onChanged(degrees, degrees2, degrees3);
            }
        }
    }

    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        Logger.i(TAG, "pause");
        if (this.mStatus == 1) {
            Logger.i(TAG, "do pause");
            SensorManager sensorManager = this.mSensorManager;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
            }
            OrientationEventListener orientationEventListener = this.mOrientationEventListener;
            if (orientationEventListener != null) {
                orientationEventListener.disable();
            }
            this.mLastTimestamp = 0L;
            this.mStatus = 2;
            this.mIsRegistered = false;
        }
    }

    public void resetRotation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            this.mLastTimestamp = 0L;
            initRotationVector();
        }
    }

    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        Logger.i(TAG, "resume");
        if (this.mStatus == 2) {
            Logger.i(TAG, "do resume");
            initSensorManager();
            this.mStatus = 1;
        }
    }

    public void setOnRotationChangeListener(OnRotationChangeListener onRotationChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) onRotationChangeListener);
        } else {
            this.mOnRotationChangeListener = onRotationChangeListener;
        }
    }

    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        Logger.i(TAG, "start, this: " + this);
        if (this.mStatus == 0) {
            Logger.i(TAG, "do start");
            initRotationVector();
            initSensorManager();
            this.mStatus = 1;
        }
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        Logger.i(TAG, "stop");
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        OrientationEventListener orientationEventListener = this.mOrientationEventListener;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        OnActivityLifecycleChanged.removeListener(this);
        this.mIsRegistered = false;
        this.mSensor = null;
        HandlerThread handlerThread = this.mThread;
        if (handlerThread != null && handlerThread.isAlive()) {
            handlerThread.quitSafely();
        }
        this.mThread = null;
        this.mHandler = null;
        this.mOnRotationChangeListener = null;
        this.mStatus = 0;
    }

    public void updateEnableOrientationCheck(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.mEnableOrientationCheck = z16;
        }
    }

    public RotationSensor(Context context, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(z16));
            return;
        }
        this.mRotationVector = new float[3];
        this.mOrientation = 0;
        this.mIsRegistered = false;
        if (context != null) {
            this.mContext = context.getApplicationContext();
            this.mEnableOrientationCheck = z16;
            OnActivityLifecycleChanged.addListener(context, this);
            initRotationVector();
        }
    }

    protected void initSensorManager(Handler handler) {
        SensorManager sensorManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) handler);
            return;
        }
        Logger.i(TAG, "do initSensorManager");
        if (this.mContext == null) {
            Logger.w(TAG, "context is null.");
            return;
        }
        if (this.mCurrentActivityState != 3 && this.mCurrentActivityState != 5 && this.mCurrentActivityState != 6 && Utils.isAppOnForeground(this.mContext)) {
            if (this.mIsRegistered) {
                Logger.w(TAG, "sensor listener is registered.");
                return;
            }
            try {
                if (this.mSensorManager == null) {
                    this.mSensorManager = (SensorManager) this.mContext.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
                }
                if (this.mSensor == null && (sensorManager = this.mSensorManager) != null) {
                    this.mSensor = SensorMonitor.getDefaultSensor(sensorManager, 4);
                }
                SensorManager sensorManager2 = this.mSensorManager;
                if (sensorManager2 != null) {
                    this.mIsRegistered = SensorMonitor.registerListener(sensorManager2, this, this.mSensor, getSamplingPeriodUs(), handler);
                }
                initOrientation();
            } catch (Throwable th5) {
                Logger.e(TAG, "initSensorManager error.", th5);
            }
            if (!this.mIsRegistered) {
                Logger.i(TAG, "register sensor listener error.");
                this.mStatus = -1;
                OnRotationChangeListener onRotationChangeListener = this.mOnRotationChangeListener;
                if (onRotationChangeListener != null) {
                    onRotationChangeListener.onError();
                }
            }
            if (FusionWidgetConfig.isEnableMockSensor()) {
                SensorMocker sensorMocker = new SensorMocker();
                this.mSensorMocker = sensorMocker;
                sensorMocker.startMock(1);
                return;
            }
            return;
        }
        Logger.w(TAG, "do not allow to initialize sensors in the background.");
    }
}
