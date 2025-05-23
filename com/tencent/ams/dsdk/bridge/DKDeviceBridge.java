package com.tencent.ams.dsdk.bridge;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEngine;
import com.tencent.ams.dsdk.event.hardware.DKAccelerometerSensorEventCenter;
import com.tencent.ams.dsdk.event.hardware.DKGyroScopeSensorEventCenter;
import com.tencent.ams.dsdk.utils.DKSystemUtils;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
@HippyNativeModule(name = "DKDevice", thread = HippyNativeModule.Thread.BRIDGE)
/* loaded from: classes3.dex */
public final class DKDeviceBridge extends HippyNativeModuleBase {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DKDeviceBridge";
    private DKAccelerometerSensorEventCenter mAccelerometerSensorEventCenter;
    private DKAccelerometerSensorEventCenter.EventParamsBuilder mDeviceAccelerometerSensorEventCenterEventParamsBuilder;
    private DKGyroScopeSensorEventCenter.EventParamsBuilder mDeviceGyroScopeSensorEventCenterEventParamsBuilder;
    private DKGyroScopeSensorEventCenter mGyroScopeSensorEventCenter;
    private WeakReference<DKHippyEngine> mWeakHippyEngine;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static final class AccelerometerParamName {
        static IPatchRedirector $redirector_ = null;
        private static final String DATA = "accelerometerData";
        private static final String X = "xAcceleration";
        private static final String Y = "yAcceleration";
        private static final String Z = "zAcceleration";

        AccelerometerParamName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class DeviceType {
        static IPatchRedirector $redirector_ = null;
        public static final int ACCELEROMETER = 1;
        public static final int GYROSCOPE = 3;
        public static final int VIBRATION = 2;

        public DeviceType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static final class ErrorCode {
        static IPatchRedirector $redirector_ = null;
        private static final int OTHER_ERROR = -2;
        private static final int PARAMS_ERROR = -1;
        private static final int SUCCESS = 0;

        ErrorCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static final class GyroScopeParamName {
        static IPatchRedirector $redirector_ = null;
        private static final String DATA = "gyroscopeData";
        private static final String TIME_STAMP = "timestamp";
        private static final String X = "rotationRateX";
        private static final String Y = "rotationRateY";
        private static final String Z = "rotationRateZ";

        GyroScopeParamName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static final class ParamName {
        static IPatchRedirector $redirector_ = null;
        private static final String DEVICE_TYPE = "deviceType";
        private static final String UPDATE_INTERVAL_MILLIS = "updateIntervalMillis";

        ParamName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public DKDeviceBridge(HippyEngineContext hippyEngineContext, WeakReference<DKHippyEngine> weakReference) {
        super(hippyEngineContext);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hippyEngineContext, (Object) weakReference);
            return;
        }
        this.mDeviceAccelerometerSensorEventCenterEventParamsBuilder = createAccelerometerEventCenterEventParamsBuilder();
        this.mDeviceGyroScopeSensorEventCenterEventParamsBuilder = createGyroScopeEventCenterEventParamsBuilder();
        this.mWeakHippyEngine = weakReference;
    }

    private static HippyMap buildResult(int i3) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushInt("code", i3);
        return hippyMap;
    }

    private static DKAccelerometerSensorEventCenter.EventParamsBuilder createAccelerometerEventCenterEventParamsBuilder() {
        return new DKAccelerometerSensorEventCenter.EventParamsBuilder() { // from class: com.tencent.ams.dsdk.bridge.DKDeviceBridge.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.ams.dsdk.event.hardware.DKAccelerometerSensorEventCenter.EventParamsBuilder
            public JSONObject build(float f16, float f17, float f18) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (JSONObject) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("xAcceleration", f16 / 9.8f);
                    jSONObject.put("yAcceleration", f17 / 9.8f);
                    jSONObject.put("zAcceleration", f18 / 9.8f);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("deviceType", 1);
                    jSONObject2.put("accelerometerData", jSONObject);
                    return jSONObject2;
                } catch (Throwable th5) {
                    DLog.e(DKDeviceBridge.TAG, "[sendEvent]", th5);
                    return null;
                }
            }
        };
    }

    private static DKGyroScopeSensorEventCenter.EventParamsBuilder createGyroScopeEventCenterEventParamsBuilder() {
        return new DKGyroScopeSensorEventCenter.EventParamsBuilder() { // from class: com.tencent.ams.dsdk.bridge.DKDeviceBridge.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.ams.dsdk.event.hardware.DKGyroScopeSensorEventCenter.EventParamsBuilder
            public JSONObject build(float f16, float f17, float f18, long j3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (JSONObject) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Long.valueOf(j3));
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("rotationRateX", f16);
                    jSONObject.put("rotationRateY", f17);
                    jSONObject.put("rotationRateZ", f18);
                    jSONObject.put("timestamp", j3);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("deviceType", 3);
                    jSONObject2.put("gyroscopeData", jSONObject);
                    return jSONObject2;
                } catch (Throwable th5) {
                    DLog.e(DKDeviceBridge.TAG, "[sendEvent]", th5);
                    return null;
                }
            }
        };
    }

    private static int getDeviceType(HippyMap hippyMap) {
        Object param = getParam(hippyMap, "deviceType");
        if (param instanceof Integer) {
            return ((Integer) param).intValue();
        }
        DLog.e(TAG, "[getDeviceType] error");
        return Integer.MIN_VALUE;
    }

    private static Object getParam(HippyMap hippyMap, String str) {
        if (hippyMap == null) {
            DLog.e(TAG, "[getParam] error,  params is null");
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            DLog.e(TAG, "[getParam] error,  key is null");
            return null;
        }
        if (!hippyMap.containsKey(str)) {
            DLog.e(TAG, "[getParam] error, has no " + str);
            return Integer.MIN_VALUE;
        }
        return hippyMap.get(str);
    }

    private static int getUpdateIntervalMillis(HippyMap hippyMap) {
        try {
            return Integer.parseInt(String.valueOf(getParam(hippyMap, "updateIntervalMillis")));
        } catch (Throwable th5) {
            DLog.e(TAG, "[getUpdateIntervalMillis]", th5);
            return Integer.MIN_VALUE;
        }
    }

    private static void reject(@NonNull Promise promise, int i3) {
        if (promise == null) {
            DLog.e(TAG, "[reject] error, promise is null");
            return;
        }
        DLog.i(TAG, "[reject] errorCode:" + i3);
        promise.reject(buildResult(i3));
    }

    private static void resolve(@NonNull Promise promise, int i3) {
        if (promise == null) {
            DLog.e(TAG, "[resolve] error, promise is null");
            return;
        }
        DLog.i(TAG, "[resolve] errorCode:" + i3);
        promise.resolve(buildResult(i3));
    }

    private int startAccelerometer(@Nullable HippyMap hippyMap) {
        DKHippyEngine dKHippyEngine;
        int updateIntervalMillis = getUpdateIntervalMillis(hippyMap);
        if (updateIntervalMillis < 0) {
            return -1;
        }
        WeakReference<DKHippyEngine> weakReference = this.mWeakHippyEngine;
        if (weakReference != null) {
            dKHippyEngine = weakReference.get();
        } else {
            dKHippyEngine = null;
        }
        if (dKHippyEngine == null) {
            return -2;
        }
        DKAccelerometerSensorEventCenter dKAccelerometerSensorEventCenter = this.mAccelerometerSensorEventCenter;
        if (dKAccelerometerSensorEventCenter == null) {
            DKAccelerometerSensorEventCenter dKAccelerometerSensorEventCenter2 = new DKAccelerometerSensorEventCenter(new WeakReference(dKHippyEngine), new Handler(Looper.myLooper()), 1);
            this.mAccelerometerSensorEventCenter = dKAccelerometerSensorEventCenter2;
            dKAccelerometerSensorEventCenter2.setUpdateIntervalMillis(updateIntervalMillis);
            this.mAccelerometerSensorEventCenter.setEventParamsBuilder(new WeakReference<>(this.mDeviceAccelerometerSensorEventCenterEventParamsBuilder));
            this.mAccelerometerSensorEventCenter.register(DKEngine.getApplicationContext());
            return 0;
        }
        dKAccelerometerSensorEventCenter.setUpdateIntervalMillis(updateIntervalMillis);
        return 0;
    }

    private int startGyroScope(@Nullable HippyMap hippyMap) {
        DKHippyEngine dKHippyEngine;
        int updateIntervalMillis = getUpdateIntervalMillis(hippyMap);
        if (updateIntervalMillis < 0) {
            return -1;
        }
        WeakReference<DKHippyEngine> weakReference = this.mWeakHippyEngine;
        if (weakReference != null) {
            dKHippyEngine = weakReference.get();
        } else {
            dKHippyEngine = null;
        }
        if (dKHippyEngine == null) {
            return -2;
        }
        DKGyroScopeSensorEventCenter dKGyroScopeSensorEventCenter = this.mGyroScopeSensorEventCenter;
        if (dKGyroScopeSensorEventCenter == null) {
            DKGyroScopeSensorEventCenter dKGyroScopeSensorEventCenter2 = new DKGyroScopeSensorEventCenter(new WeakReference(dKHippyEngine), new Handler(Looper.myLooper()), 1);
            this.mGyroScopeSensorEventCenter = dKGyroScopeSensorEventCenter2;
            dKGyroScopeSensorEventCenter2.setUpdateIntervalMillis(updateIntervalMillis);
            this.mGyroScopeSensorEventCenter.setEventParamsBuilder(new WeakReference<>(this.mDeviceGyroScopeSensorEventCenterEventParamsBuilder));
            this.mGyroScopeSensorEventCenter.register(DKEngine.getApplicationContext());
            return 0;
        }
        dKGyroScopeSensorEventCenter.setUpdateIntervalMillis(updateIntervalMillis);
        return 0;
    }

    private int startVibration(@Nullable HippyMap hippyMap) {
        if (DKSystemUtils.vibrate(DKEngine.getApplicationContext(), 500L)) {
            return 0;
        }
        return -2;
    }

    private int stopAccelerometer(@Nullable HippyMap hippyMap) {
        DKAccelerometerSensorEventCenter dKAccelerometerSensorEventCenter = this.mAccelerometerSensorEventCenter;
        if (dKAccelerometerSensorEventCenter != null) {
            dKAccelerometerSensorEventCenter.unRegister(DKEngine.getApplicationContext());
            this.mAccelerometerSensorEventCenter = null;
            return 0;
        }
        return 0;
    }

    private int stopGyroScope(@Nullable HippyMap hippyMap) {
        DKGyroScopeSensorEventCenter dKGyroScopeSensorEventCenter = this.mGyroScopeSensorEventCenter;
        if (dKGyroScopeSensorEventCenter != null) {
            dKGyroScopeSensorEventCenter.unRegister(DKEngine.getApplicationContext());
        }
        this.mGyroScopeSensorEventCenter = null;
        return 0;
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            DLog.i(TAG, "[destroy]");
            stopAccelerometer(null);
        }
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void initialize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            DLog.i(TAG, "[initialize]");
        }
    }

    @HippyMethod(name = "start")
    public void start(@Nullable HippyMap hippyMap, @NonNull Promise promise) {
        int startAccelerometer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) hippyMap, (Object) promise);
            return;
        }
        DLog.i(TAG, "[start] params: " + hippyMap);
        int deviceType = getDeviceType(hippyMap);
        if (deviceType != 1) {
            if (deviceType != 2) {
                if (deviceType != 3) {
                    startAccelerometer = -1;
                } else {
                    startAccelerometer = startGyroScope(hippyMap);
                }
            } else {
                startAccelerometer = startVibration(hippyMap);
            }
        } else {
            startAccelerometer = startAccelerometer(hippyMap);
        }
        if (startAccelerometer == 0) {
            resolve(promise, startAccelerometer);
        } else {
            reject(promise, startAccelerometer);
        }
    }

    @HippyMethod(name = "stop")
    public void stop(@Nullable HippyMap hippyMap, @NonNull Promise promise) {
        int stopAccelerometer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) hippyMap, (Object) promise);
            return;
        }
        DLog.i(TAG, "[stop] params: " + hippyMap);
        int deviceType = getDeviceType(hippyMap);
        if (deviceType != 1) {
            if (deviceType != 3) {
                stopAccelerometer = -1;
            } else {
                stopAccelerometer = stopGyroScope(hippyMap);
            }
        } else {
            stopAccelerometer = stopAccelerometer(hippyMap);
        }
        if (stopAccelerometer == 0) {
            resolve(promise, stopAccelerometer);
        } else {
            reject(promise, stopAccelerometer);
        }
    }
}
