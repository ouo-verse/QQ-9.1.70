package com.tencent.hippy.qq.module;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
@HippyNativeModule(name = QQSensorModule.CLASS_NAME)
/* loaded from: classes7.dex */
public class QQSensorModule extends QQBaseModule {
    public static final String CLASS_NAME = "QQSensorModule";
    private static final String HIPPY_EVENT_ON_SENSOR_CHANGED = "onSensorChanged";
    private static final long SEND_SENSOR_EVENT_GAP = 50;
    private long lastSendEventTime;
    protected QQSensorEventListener mAccelerometerListener;
    protected SensorManager mSensorManager;

    public QQSensorModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        this.lastSendEventTime = 0L;
    }

    @Override // com.tencent.hippy.qq.module.QQBaseModule, com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void destroy() {
        super.destroy();
        doStopAccelerometer();
    }

    public final void doStartAccelerometer(Promise promise) {
        QLog.i(CLASS_NAME, 1, "[doStartAccelerometer]");
        if (this.mSensorManager == null) {
            this.mSensorManager = (SensorManager) MobileQQ.sMobileQQ.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        }
        List<Sensor> sensorList = SensorMonitor.getSensorList(this.mSensorManager, 1);
        if (sensorList.size() > 0) {
            Sensor sensor = sensorList.get(0);
            if (this.mAccelerometerListener != null) {
                doStopAccelerometer();
            }
            QQSensorEventListener qQSensorEventListener = new QQSensorEventListener();
            this.mAccelerometerListener = qQSensorEventListener;
            SensorMonitor.registerListener(this.mSensorManager, qQSensorEventListener, sensor, 0);
            promise.resolve(Boolean.TRUE);
            return;
        }
        promise.resolve(Boolean.FALSE);
    }

    public final void doStopAccelerometer() {
        QQSensorEventListener qQSensorEventListener;
        QLog.i(CLASS_NAME, 1, "[doStopAccelerometer]");
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null && (qQSensorEventListener = this.mAccelerometerListener) != null) {
            sensorManager.unregisterListener(qQSensorEventListener);
            this.mAccelerometerListener = null;
        }
    }

    public final void doVibrate() {
        try {
            Vibrator vibrator = (Vibrator) MobileQQ.sMobileQQ.getSystemService("vibrator");
            if (vibrator != null) {
                vibrator.vibrate(200L);
            }
        } catch (Exception e16) {
            QLog.e(CLASS_NAME, 1, "exception when doVibrate.", e16);
        }
    }

    @HippyMethod(name = "startAccelerometer")
    public void startAccelerometer(Promise promise) {
        doStartAccelerometer(promise);
    }

    @HippyMethod(name = "stopAccelerometer")
    public void stopAccelerometer() {
        doStopAccelerometer();
    }

    @HippyMethod(name = "vibrate")
    public void vibrate() {
        doVibrate();
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class QQSensorEventListener implements SensorEventListener {
        public QQSensorEventListener() {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (Math.abs(QQSensorModule.this.lastSendEventTime - System.currentTimeMillis()) < 50) {
                return;
            }
            QQSensorModule.this.lastSendEventTime = System.currentTimeMillis();
            float[] fArr = sensorEvent.values;
            float f16 = fArr[0];
            float f17 = fArr[1];
            float f18 = fArr[2];
            HippyQQEngine hippyQQEngine = QQSensorModule.this.getHippyQQEngine();
            if (hippyQQEngine != null) {
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushDouble(HippyTKDListViewAdapter.X, Double.parseDouble(String.valueOf(f16)));
                hippyMap.pushDouble("y", Double.parseDouble(String.valueOf(f17)));
                hippyMap.pushDouble(QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, Double.parseDouble(String.valueOf(f18)));
                hippyQQEngine.sendEvent(QQSensorModule.HIPPY_EVENT_ON_SENSOR_CHANGED, hippyMap);
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
        }
    }
}
