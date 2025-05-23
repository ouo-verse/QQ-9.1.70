package com.tencent.qmethod.pandoraex.monitor;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.hardware.TriggerEventListener;
import android.os.Handler;
import androidx.annotation.RequiresApi;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qmethod.pandoraex.core.MonitorReporter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vr3.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SensorMonitor {
    private static final String SENSOR_TYPE_KEY = "sensor_type";
    private static final String WAKE_UP_KEY = "wake_up";
    private static int lastGetSensors;
    private static final Map<Integer, List<Sensor>> lastGetSensorListMap = new HashMap();
    private static final Map<Integer, List<Sensor>> lastGetDynamicSensorListMap = new HashMap();
    private static final Map<Integer, Sensor> lastGetDefaultSensorMap = new HashMap();
    private static final Map<String, Sensor> lastGetDefaultSensorParamIBMap = new HashMap();

    public static Sensor getDefaultSensor(SensorManager sensorManager, int i3) {
        vr3.a d16 = new a.C11438a().b("ban").b("cache_only").b("memory").d();
        HashMap hashMap = new HashMap();
        hashMap.put(SENSOR_TYPE_KEY, String.valueOf(i3));
        hashMap.put("index", String.valueOf(i3));
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport(WebRTCSDK.PRIVILEGE_SENSOR, "SM#G_DS#I", d16, hashMap);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            Sensor defaultSensor = sensorManager.getDefaultSensor(i3);
            lastGetDefaultSensorMap.put(Integer.valueOf(i3), defaultSensor);
            return defaultSensor;
        }
        if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            return lastGetDefaultSensorMap.get(Integer.valueOf(i3));
        }
        return null;
    }

    @RequiresApi(api = 24)
    public static List<Sensor> getDynamicSensorList(SensorManager sensorManager, int i3) {
        List<Sensor> dynamicSensorList;
        vr3.a d16 = new a.C11438a().b("ban").b("cache_only").b("memory").d();
        HashMap hashMap = new HashMap();
        hashMap.put(SENSOR_TYPE_KEY, String.valueOf(i3));
        hashMap.put("index", String.valueOf(i3));
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport(WebRTCSDK.PRIVILEGE_SENSOR, "SM#G_DSL#I", d16, hashMap);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            dynamicSensorList = sensorManager.getDynamicSensorList(i3);
            lastGetDynamicSensorListMap.put(Integer.valueOf(i3), dynamicSensorList);
            return dynamicSensorList;
        }
        if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            List<Sensor> list = lastGetDynamicSensorListMap.get(Integer.valueOf(i3));
            if (list == null) {
                return new ArrayList();
            }
            return list;
        }
        return new ArrayList();
    }

    public static List<Sensor> getSensorList(SensorManager sensorManager, int i3) {
        vr3.a d16 = new a.C11438a().b("ban").b("cache_only").b("memory").d();
        HashMap hashMap = new HashMap();
        hashMap.put(SENSOR_TYPE_KEY, String.valueOf(i3));
        hashMap.put("index", String.valueOf(i3));
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport(WebRTCSDK.PRIVILEGE_SENSOR, "SM#G_SL#I", d16, hashMap);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            List<Sensor> sensorList = sensorManager.getSensorList(i3);
            lastGetSensorListMap.put(Integer.valueOf(i3), sensorList);
            return sensorList;
        }
        if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            List<Sensor> list = lastGetSensorListMap.get(Integer.valueOf(i3));
            if (list == null) {
                return new ArrayList();
            }
            return list;
        }
        return new ArrayList();
    }

    public static int getSensors(SensorManager sensorManager) {
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport(WebRTCSDK.PRIVILEGE_SENSOR, "SM#G_S", new a.C11438a().b("ban").b("cache_only").b("memory").d(), null);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            int sensors = sensorManager.getSensors();
            lastGetSensors = sensors;
            return sensors;
        }
        if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            return lastGetSensors;
        }
        return 0;
    }

    @RequiresApi(api = 24)
    public static void registerDynamicSensorCallback(SensorManager sensorManager, SensorManager.DynamicSensorCallback dynamicSensorCallback) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport(WebRTCSDK.PRIVILEGE_SENSOR, "SM#RDSC#D", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            sensorManager.registerDynamicSensorCallback(dynamicSensorCallback);
        }
    }

    public static boolean registerListener(SensorManager sensorManager, SensorListener sensorListener, int i3) {
        vr3.a d16 = new a.C11438a().b("ban").b("cache_only").d();
        HashMap hashMap = new HashMap();
        hashMap.put(SENSOR_TYPE_KEY, String.valueOf(i3));
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport(WebRTCSDK.PRIVILEGE_SENSOR, "SM#RL#SI", d16, hashMap))) {
            return sensorManager.registerListener(sensorListener, i3);
        }
        return false;
    }

    @RequiresApi(api = 18)
    public static boolean requestTriggerSensor(SensorManager sensorManager, TriggerEventListener triggerEventListener, Sensor sensor) {
        vr3.a d16 = new a.C11438a().b("ban").b("cache_only").d();
        HashMap hashMap = new HashMap();
        if (sensor != null) {
            hashMap.put(SENSOR_TYPE_KEY, String.valueOf(sensor.getType()));
        }
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport(WebRTCSDK.PRIVILEGE_SENSOR, "SM#RTL#TS", d16, hashMap))) {
            return sensorManager.requestTriggerSensor(triggerEventListener, sensor);
        }
        return false;
    }

    @RequiresApi(api = 24)
    public static void registerDynamicSensorCallback(SensorManager sensorManager, SensorManager.DynamicSensorCallback dynamicSensorCallback, Handler handler) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport(WebRTCSDK.PRIVILEGE_SENSOR, "SM#RDSC#DH", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            sensorManager.registerDynamicSensorCallback(dynamicSensorCallback, handler);
        }
    }

    public static boolean registerListener(SensorManager sensorManager, SensorListener sensorListener, int i3, int i16) {
        vr3.a d16 = new a.C11438a().b("ban").b("cache_only").d();
        HashMap hashMap = new HashMap();
        hashMap.put(SENSOR_TYPE_KEY, String.valueOf(i3));
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport(WebRTCSDK.PRIVILEGE_SENSOR, "SM#RL#SII", d16, hashMap))) {
            return sensorManager.registerListener(sensorListener, i3, i16);
        }
        return false;
    }

    @RequiresApi(api = 21)
    public static Sensor getDefaultSensor(SensorManager sensorManager, int i3, boolean z16) {
        String str = i3 + "#" + z16;
        vr3.a d16 = new a.C11438a().b("ban").b("cache_only").b("memory").d();
        HashMap hashMap = new HashMap();
        hashMap.put(SENSOR_TYPE_KEY, String.valueOf(i3));
        hashMap.put(WAKE_UP_KEY, String.valueOf(z16));
        hashMap.put("index", String.valueOf(i3) + z16);
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport(WebRTCSDK.PRIVILEGE_SENSOR, "SM#G_DS#IB", d16, hashMap);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            Sensor defaultSensor = sensorManager.getDefaultSensor(i3, z16);
            lastGetDefaultSensorParamIBMap.put(str, defaultSensor);
            return defaultSensor;
        }
        if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            return lastGetDefaultSensorParamIBMap.get(str);
        }
        return null;
    }

    public static boolean registerListener(SensorManager sensorManager, SensorEventListener sensorEventListener, Sensor sensor, int i3) {
        vr3.a d16 = new a.C11438a().b("ban").b("cache_only").d();
        HashMap hashMap = new HashMap();
        if (sensor != null) {
            hashMap.put(SENSOR_TYPE_KEY, String.valueOf(sensor.getType()));
        }
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport(WebRTCSDK.PRIVILEGE_SENSOR, "SM#RL#SSI", d16, hashMap))) {
            return sensorManager.registerListener(sensorEventListener, sensor, i3);
        }
        return false;
    }

    @RequiresApi(api = 19)
    public static boolean registerListener(SensorManager sensorManager, SensorEventListener sensorEventListener, Sensor sensor, int i3, int i16) {
        vr3.a d16 = new a.C11438a().b("ban").b("cache_only").d();
        HashMap hashMap = new HashMap();
        if (sensor != null) {
            hashMap.put(SENSOR_TYPE_KEY, String.valueOf(sensor.getType()));
        }
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport(WebRTCSDK.PRIVILEGE_SENSOR, "SM#RL#SSII", d16, hashMap))) {
            return sensorManager.registerListener(sensorEventListener, sensor, i3, i16);
        }
        return false;
    }

    public static boolean registerListener(SensorManager sensorManager, SensorEventListener sensorEventListener, Sensor sensor, int i3, Handler handler) {
        vr3.a d16 = new a.C11438a().b("ban").b("cache_only").d();
        HashMap hashMap = new HashMap();
        if (sensor != null) {
            hashMap.put(SENSOR_TYPE_KEY, String.valueOf(sensor.getType()));
        }
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport(WebRTCSDK.PRIVILEGE_SENSOR, "SM#RL#SSIH", d16, hashMap))) {
            return sensorManager.registerListener(sensorEventListener, sensor, i3, handler);
        }
        return false;
    }

    @RequiresApi(api = 19)
    public static boolean registerListener(SensorManager sensorManager, SensorEventListener sensorEventListener, Sensor sensor, int i3, int i16, Handler handler) {
        vr3.a d16 = new a.C11438a().b("ban").b("cache_only").d();
        HashMap hashMap = new HashMap();
        if (sensor != null) {
            hashMap.put(SENSOR_TYPE_KEY, String.valueOf(sensor.getType()));
        }
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport(WebRTCSDK.PRIVILEGE_SENSOR, "SM#RL#SSIIH", d16, hashMap))) {
            return sensorManager.registerListener(sensorEventListener, sensor, i3, i16, handler);
        }
        return false;
    }
}
