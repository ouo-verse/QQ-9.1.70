package com.tencent.qqmini.sdk.plugins;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import androidx.annotation.NonNull;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.hippy.qq.adapter.image.HippyImageInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.jg.w;
import com.tencent.luggage.wxa.jg.x;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class SensorJsPlugin extends BaseJsPlugin {
    public static final String EVENT_ACCELEROMETER_STATE_CHANGE = "onAccelerometerChange";
    public static final String EVENT_COMPASS_STATE_CHANGE = "onCompassChange";
    public static final String EVENT_DEVICE_MOTION_STATE_CHANGE = "onDeviceMotionChange";
    public static final String EVENT_GYROSCOPE_STATE_CHANGE = "onGyroscopeChange";
    public static final String SENSOR_INTERVAL_GAME = "game";
    public static final int SENSOR_INTERVAL_GAME_NUMBER = 20;
    public static final String SENSOR_INTERVAL_NORMAL = "normal";
    public static final int SENSOR_INTERVAL_NORMAL_NUMBER = 200;
    public static final String SENSOR_INTERVAL_UI = "ui";
    public static final int SENSOR_INTERVAL_UI_NUMBER = 60;
    private static final String TAG = "SensorJsPlugin";
    private Sensor accelerometerSensor;
    private AccelerometerSensorJsPlugin accelerometerSensorJsPlugin;
    private CompassSensorJsPlugin compassSensorJsPlugin;
    private Sensor gyroscopeSensor;
    private GyroscopeSensorJsPlugin gyroscopeSensorJsPlugin;
    private boolean mIsPause;
    private Sensor magneticSensor;
    private Sensor orientationSensor;
    private RotationSensorJsPlugin orientationSensorJsPlugin;
    private SensorManager senSensorManager;
    private Vibrator vibrator;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class CompassSensorJsPlugin implements SensorEventListener {
        private IJsService mJsService;
        int accuracy = -1;
        private float[] mAccelerometerValues = new float[3];
        private float[] mMagneticFieldValues = new float[3];
        private float[] mValues = new float[3];
        private float[] mMatrix = new float[9];

        CompassSensorJsPlugin(@NonNull IJsService iJsService) {
            this.mJsService = iJsService;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
            this.accuracy = i3;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (SensorJsPlugin.this.mIsPause) {
                return;
            }
            if (sensorEvent.sensor.getType() == 2) {
                this.mMagneticFieldValues = sensorEvent.values;
            }
            if (sensorEvent.sensor.getType() == 1) {
                float[] fArr = sensorEvent.values;
                this.mAccelerometerValues = fArr;
                SensorManager.getRotationMatrix(this.mMatrix, null, fArr, this.mMagneticFieldValues);
                SensorManager.getOrientation(this.mMatrix, this.mValues);
                float degrees = (float) Math.toDegrees(this.mValues[0]);
                String str = "unknow ${" + this.accuracy + "}";
                int i3 = this.accuracy;
                if (i3 != -1) {
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 != 2) {
                                if (i3 == 3) {
                                    str = "high";
                                }
                            } else {
                                str = "medium";
                            }
                        } else {
                            str = HippyImageInfo.QUALITY_LOW;
                        }
                    } else {
                        str = "unreliable";
                    }
                } else {
                    str = "no-contact";
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("direction", degrees);
                    jSONObject.put("accuracy", str);
                    SensorJsPlugin.this.sendSubscribeEvent(SensorJsPlugin.EVENT_COMPASS_STATE_CHANGE, jSONObject.toString(), 0, this.mJsService);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doVibrate(long j3) {
        try {
            Vibrator vibrator = this.vibrator;
            if (vibrator != null) {
                vibrator.vibrate(j3);
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "exception when doVibrate.", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSensor() {
        if (this.senSensorManager == null) {
            SensorManager sensorManager = (SensorManager) this.mContext.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
            this.senSensorManager = sensorManager;
            this.magneticSensor = SensorMonitor.getDefaultSensor(sensorManager, 2);
            this.gyroscopeSensor = SensorMonitor.getDefaultSensor(this.senSensorManager, 4);
            this.orientationSensor = SensorMonitor.getDefaultSensor(this.senSensorManager, 3);
        }
        if (this.vibrator == null) {
            this.vibrator = (Vibrator) this.mContext.getSystemService("vibrator");
        }
        if (this.accelerometerSensor == null) {
            List<Sensor> sensorList = SensorMonitor.getSensorList(this.senSensorManager, 1);
            if (sensorList.size() > 0) {
                this.accelerometerSensor = sensorList.get(0);
            }
        }
    }

    @JsEvent({com.tencent.luggage.wxa.fg.b.NAME})
    public String enableAccelerometer(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.SensorJsPlugin.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SensorJsPlugin.this.initSensor();
                    JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                    if (jSONObject.optBoolean("enable")) {
                        if (SensorJsPlugin.this.startAccelerometer(requestEvent.jsService, SensorJsPlugin.this.getInterval(jSONObject))) {
                            requestEvent.ok();
                        } else {
                            requestEvent.fail();
                        }
                    } else {
                        SensorJsPlugin.this.stopAccelerometer();
                        requestEvent.ok();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("errMsg", requestEvent.event + ":cancel");
                        requestEvent.evaluateCallbackJs(jSONObject2.toString());
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        });
        return "";
    }

    @JsEvent({com.tencent.luggage.wxa.fg.c.NAME})
    public String enableCompass(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.SensorJsPlugin.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SensorJsPlugin.this.initSensor();
                    if (new JSONObject(requestEvent.jsonParams).optBoolean("enable")) {
                        if (SensorJsPlugin.this.startCompass(requestEvent.jsService, 3)) {
                            requestEvent.ok();
                        } else {
                            requestEvent.fail();
                        }
                    } else {
                        SensorJsPlugin.this.stopCompass();
                        requestEvent.ok();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("errMsg", requestEvent.event + ":cancel");
                        requestEvent.evaluateCallbackJs(jSONObject.toString());
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        });
        return "";
    }

    @JsEvent({com.tencent.luggage.wxa.fg.d.NAME})
    public String enableDeviceMotionChangeListening(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.SensorJsPlugin.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SensorJsPlugin.this.initSensor();
                    JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                    if (jSONObject.optBoolean("enable")) {
                        if (SensorJsPlugin.this.startRotationListening(requestEvent.jsService, SensorJsPlugin.this.getInterval(jSONObject))) {
                            requestEvent.ok();
                        } else {
                            requestEvent.fail();
                        }
                    } else {
                        SensorJsPlugin.this.stopRotationListening();
                        requestEvent.ok();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("errMsg", requestEvent.event + ":cancel");
                        requestEvent.evaluateCallbackJs(jSONObject2.toString());
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        });
        return "";
    }

    @JsEvent({com.tencent.luggage.wxa.fg.e.NAME})
    public String enableGyroscope(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.SensorJsPlugin.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SensorJsPlugin.this.initSensor();
                    JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                    if (jSONObject.optBoolean("enable")) {
                        if (SensorJsPlugin.this.startGyroscope(requestEvent.jsService, SensorJsPlugin.this.getInterval(jSONObject), jSONObject.optBoolean("isCalibrate", false))) {
                            requestEvent.ok();
                        } else {
                            requestEvent.fail();
                        }
                    } else {
                        SensorJsPlugin.this.stopGyroscope();
                        requestEvent.ok();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("errMsg", requestEvent.event + ":cancel");
                        requestEvent.evaluateCallbackJs(jSONObject2.toString());
                    }
                } catch (JSONException e16) {
                    QMLog.e(SensorJsPlugin.TAG, "enableGyroscope exception=", e16);
                }
            }
        });
        return "";
    }

    public int getInterval(JSONObject jSONObject) {
        String optString = jSONObject.optString(WidgetCacheConstellationData.INTERVAL);
        int optInt = jSONObject.optInt(WidgetCacheConstellationData.INTERVAL, -1);
        if (optInt == -1) {
            if ("game".equals(optString)) {
                return 1;
            }
            if (SENSOR_INTERVAL_UI.equals(optString)) {
                return 2;
            }
            "normal".equals(optString);
            return 3;
        }
        if (optInt == 20) {
            return 1;
        }
        if (optInt != 60) {
            return 3;
        }
        return 2;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(IMiniAppContext iMiniAppContext) {
        super.onCreate(iMiniAppContext);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        super.onDestroy();
        stopAccelerometer();
        stopCompass();
        stopGyroscope();
        stopRotationListening();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onPause() {
        super.onPause();
        this.mIsPause = true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onResume() {
        super.onResume();
        this.mIsPause = false;
    }

    public final boolean startAccelerometer(IJsService iJsService, int i3) {
        if (this.senSensorManager != null && this.accelerometerSensor != null) {
            if (this.accelerometerSensorJsPlugin != null) {
                stopAccelerometer();
            }
            AccelerometerSensorJsPlugin accelerometerSensorJsPlugin = new AccelerometerSensorJsPlugin(iJsService);
            this.accelerometerSensorJsPlugin = accelerometerSensorJsPlugin;
            return SensorMonitor.registerListener(this.senSensorManager, accelerometerSensorJsPlugin, this.accelerometerSensor, i3);
        }
        return false;
    }

    public final boolean startCompass(IJsService iJsService, int i3) {
        if (this.senSensorManager == null || this.accelerometerSensor == null || this.magneticSensor == null) {
            return false;
        }
        if (this.compassSensorJsPlugin != null) {
            stopAccelerometer();
        }
        CompassSensorJsPlugin compassSensorJsPlugin = new CompassSensorJsPlugin(iJsService);
        this.compassSensorJsPlugin = compassSensorJsPlugin;
        if (!SensorMonitor.registerListener(this.senSensorManager, compassSensorJsPlugin, this.accelerometerSensor, i3) || !SensorMonitor.registerListener(this.senSensorManager, this.compassSensorJsPlugin, this.magneticSensor, i3)) {
            return false;
        }
        return true;
    }

    public final boolean startGyroscope(IJsService iJsService, int i3, boolean z16) {
        if (this.senSensorManager != null && this.gyroscopeSensor != null) {
            if (this.gyroscopeSensorJsPlugin != null) {
                stopGyroscope();
            }
            GyroscopeSensorJsPlugin gyroscopeSensorJsPlugin = new GyroscopeSensorJsPlugin(iJsService, z16);
            this.gyroscopeSensorJsPlugin = gyroscopeSensorJsPlugin;
            return SensorMonitor.registerListener(this.senSensorManager, gyroscopeSensorJsPlugin, this.gyroscopeSensor, i3);
        }
        return false;
    }

    public final boolean startRotationListening(IJsService iJsService, int i3) {
        if (this.senSensorManager != null && this.orientationSensor != null) {
            if (this.orientationSensorJsPlugin != null) {
                stopRotationListening();
            }
            RotationSensorJsPlugin rotationSensorJsPlugin = new RotationSensorJsPlugin(iJsService);
            this.orientationSensorJsPlugin = rotationSensorJsPlugin;
            return SensorMonitor.registerListener(this.senSensorManager, rotationSensorJsPlugin, this.orientationSensor, i3);
        }
        return false;
    }

    public final void stopAccelerometer() {
        AccelerometerSensorJsPlugin accelerometerSensorJsPlugin;
        SensorManager sensorManager = this.senSensorManager;
        if (sensorManager != null && (accelerometerSensorJsPlugin = this.accelerometerSensorJsPlugin) != null) {
            sensorManager.unregisterListener(accelerometerSensorJsPlugin);
            this.accelerometerSensorJsPlugin = null;
        }
    }

    public final void stopCompass() {
        CompassSensorJsPlugin compassSensorJsPlugin;
        SensorManager sensorManager = this.senSensorManager;
        if (sensorManager != null && (compassSensorJsPlugin = this.compassSensorJsPlugin) != null) {
            sensorManager.unregisterListener(compassSensorJsPlugin);
            this.compassSensorJsPlugin = null;
        }
    }

    public final void stopGyroscope() {
        GyroscopeSensorJsPlugin gyroscopeSensorJsPlugin;
        SensorManager sensorManager = this.senSensorManager;
        if (sensorManager != null && (gyroscopeSensorJsPlugin = this.gyroscopeSensorJsPlugin) != null) {
            sensorManager.unregisterListener(gyroscopeSensorJsPlugin);
            this.gyroscopeSensorJsPlugin = null;
        }
    }

    public final void stopRotationListening() {
        RotationSensorJsPlugin rotationSensorJsPlugin;
        SensorManager sensorManager = this.senSensorManager;
        if (sensorManager != null && (rotationSensorJsPlugin = this.orientationSensorJsPlugin) != null) {
            sensorManager.unregisterListener(rotationSensorJsPlugin);
            this.orientationSensorJsPlugin = null;
        }
    }

    @JsEvent({w.NAME})
    public String vibrateLong(RequestEvent requestEvent) {
        initSensor();
        ThreadManager.executeOnComputationThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.SensorJsPlugin.6
            @Override // java.lang.Runnable
            public void run() {
                SensorJsPlugin.this.doVibrate(400L);
            }
        });
        requestEvent.ok();
        return "";
    }

    @JsEvent({x.NAME})
    public String vibrateShort(RequestEvent requestEvent) {
        initSensor();
        ThreadManager.executeOnComputationThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.SensorJsPlugin.5
            @Override // java.lang.Runnable
            public void run() {
                SensorJsPlugin.this.doVibrate(15L);
            }
        });
        requestEvent.ok();
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class AccelerometerSensorJsPlugin implements SensorEventListener {
        private static final float COEFFICIENT = 10.0f;
        private IJsService mJsService;

        AccelerometerSensorJsPlugin(@NonNull IJsService iJsService) {
            this.mJsService = iJsService;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (!SensorJsPlugin.this.mIsPause && sensorEvent.sensor.getType() == 1) {
                float[] fArr = sensorEvent.values;
                float f16 = (-fArr[0]) / 10.0f;
                float f17 = (-fArr[1]) / 10.0f;
                float f18 = (-fArr[2]) / 10.0f;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(HippyTKDListViewAdapter.X, f16);
                    jSONObject.put("y", f17);
                    jSONObject.put(QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, f18);
                    SensorJsPlugin.this.sendSubscribeEvent(SensorJsPlugin.EVENT_ACCELEROMETER_STATE_CHANGE, jSONObject.toString(), 0, this.mJsService);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class GyroscopeSensorJsPlugin implements SensorEventListener {
        private static final float NS2S = 1.0E-9f;
        private float[] angle = new float[3];
        private boolean isCalibrate;
        private IJsService mJsService;
        private float timestamp;

        GyroscopeSensorJsPlugin(@NonNull IJsService iJsService, boolean z16) {
            this.mJsService = iJsService;
            this.isCalibrate = z16;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            float degrees;
            float degrees2;
            double degrees3;
            if (!SensorJsPlugin.this.mIsPause && sensorEvent.sensor.getType() == 4) {
                float f16 = this.timestamp;
                if (f16 != 0.0f) {
                    if (this.isCalibrate) {
                        degrees = (float) Math.toDegrees(sensorEvent.values[0]);
                        degrees2 = (float) Math.toDegrees(sensorEvent.values[1]);
                        degrees3 = Math.toDegrees(sensorEvent.values[2]);
                    } else {
                        float f17 = (((float) sensorEvent.timestamp) - f16) * NS2S;
                        float[] fArr = this.angle;
                        float f18 = fArr[0];
                        float[] fArr2 = sensorEvent.values;
                        float f19 = f18 + (fArr2[0] * f17);
                        fArr[0] = f19;
                        fArr[1] = fArr[1] + (fArr2[1] * f17);
                        fArr[2] = fArr[2] + (fArr2[2] * f17);
                        degrees = (float) Math.toDegrees(f19);
                        degrees2 = (float) Math.toDegrees(this.angle[1]);
                        degrees3 = Math.toDegrees(this.angle[2]);
                    }
                    float f26 = (float) degrees3;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(HippyTKDListViewAdapter.X, degrees);
                        jSONObject.put("y", degrees2);
                        jSONObject.put(QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, f26);
                        SensorJsPlugin.this.sendSubscribeEvent(SensorJsPlugin.EVENT_GYROSCOPE_STATE_CHANGE, jSONObject.toString(), 0, this.mJsService);
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                }
                this.timestamp = (float) sensorEvent.timestamp;
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class RotationSensorJsPlugin implements SensorEventListener {
        private IJsService mJsService;

        RotationSensorJsPlugin(@NonNull IJsService iJsService) {
            this.mJsService = iJsService;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (!SensorJsPlugin.this.mIsPause && sensorEvent.sensor.getType() == 3) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(com.tencent.luggage.wxa.c8.c.f123400v, sensorEvent.values[0]);
                    jSONObject.put("beta", sensorEvent.values[1]);
                    jSONObject.put("gamma", sensorEvent.values[2]);
                    IJsService iJsService = this.mJsService;
                    if (iJsService != null) {
                        iJsService.evaluateSubscribeJS(SensorJsPlugin.EVENT_DEVICE_MOTION_STATE_CHANGE, jSONObject.toString(), 0);
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
        }
    }
}
