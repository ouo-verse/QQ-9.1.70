package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b extends WebViewPlugin {
    private static boolean C = false;
    private static boolean D = false;

    /* renamed from: i, reason: collision with root package name */
    private static String f97547i = "";

    /* renamed from: m, reason: collision with root package name */
    private static b f97548m;

    /* renamed from: e, reason: collision with root package name */
    protected SensorManager f97550e;

    /* renamed from: f, reason: collision with root package name */
    protected a f97551f;

    /* renamed from: d, reason: collision with root package name */
    protected final byte f97549d = 3;

    /* renamed from: h, reason: collision with root package name */
    private float[] f97552h = new float[4];

    public b() {
        if (QLog.isColorLevel()) {
            QLog.d("ARTransparentWebviewPlugin", 2, "init");
        }
        f97548m = this;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return WebRTCSDK.PRIVILEGE_SENSOR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (QLog.isColorLevel()) {
            QLog.d("ARTransparentWebviewPlugin", 2, String.format(Locale.getDefault(), "handleJsRequest url: %s pkgName; %s method: %s, args: %s", str, str2, str3, strArr));
        }
        if (WebRTCSDK.PRIVILEGE_SENSOR.equals(str2)) {
            if ("startMotion".equals(str3)) {
                try {
                    JSONObject jSONObject = new JSONObject(strArr[0]);
                    QLog.d("ARTransparentWebviewPlugin", 2, "handleJsRequest jsonobject is " + jSONObject.toString());
                    return t(jSONObject.optString("callback"));
                } catch (JSONException e16) {
                    e16.printStackTrace();
                    return false;
                }
            }
            if ("stopMotion".equals(str3)) {
                u();
                return true;
            }
            if ("notifyRenderReady".equals(str3)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(strArr[0]);
                    QLog.d("ARTransparentWebviewPlugin", 2, "handleJsRequest jsonobject is " + jSONObject2.toString());
                    s(jSONObject2.optString("callback"));
                    return true;
                } catch (JSONException e17) {
                    e17.printStackTrace();
                    return false;
                }
            }
            return super.handleJsRequest(jsBridgeListener, str, str2, str3, strArr);
        }
        return super.handleJsRequest(jsBridgeListener, str, str2, str3, strArr);
    }

    public void s(String str) {
        f97547i = str;
        QLog.d("ARTransparentWebviewPlugin", 1, "WebViewTime notifyRenderReady. callbackStartRender = " + f97547i);
        Activity a16 = this.mRuntime.a();
        if (a16 == null || !(a16 instanceof ScanTorchActivity)) {
            return;
        }
        ((ScanTorchActivity) a16).notifyRenderReady();
    }

    public final boolean t(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("ARTransparentWebviewPlugin", 1, "start motion");
        }
        if (this.f97550e == null) {
            this.f97550e = (SensorManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        }
        List<Sensor> sensorList = SensorMonitor.getSensorList(this.f97550e, com.tencent.mobileqq.ar.ARRenderModel.r.e() ? 15 : 11);
        Sensor defaultSensor = SensorMonitor.getDefaultSensor(this.f97550e, 4);
        if (sensorList.size() > 0 && defaultSensor != null) {
            Sensor sensor = sensorList.get(0);
            if (this.f97551f != null) {
                u();
            }
            this.f97551f = new a((byte) 3, str);
            if (DeviceInfoMonitor.getModel().equalsIgnoreCase("Nexus 5X")) {
                SensorMonitor.registerListener(this.f97550e, this.f97551f, sensor, 3);
            } else {
                SensorMonitor.registerListener(this.f97550e, this.f97551f, sensor, 1);
            }
            if (QLog.isColorLevel()) {
                QLog.d("ARTransparentWebviewPlugin", 2, "support gyroscope");
            }
        } else {
            callJs(str, "false");
            if (QLog.isColorLevel()) {
                QLog.d("ARTransparentWebviewPlugin", 2, "not support gyroscope");
            }
        }
        C = true;
        QLog.d("ARTransparentWebviewPlugin", 1, "WebViewTime startMotion. isRenderReady = " + C);
        return true;
    }

    public void u() {
        a aVar;
        if (QLog.isColorLevel()) {
            QLog.d("ARTransparentWebviewPlugin", 1, "stop motion");
        }
        SensorManager sensorManager = this.f97550e;
        if (sensorManager != null && (aVar = this.f97551f) != null) {
            sensorManager.unregisterListener(aVar);
            this.f97551f = null;
        }
        C = false;
        D = false;
    }

    public static void startRender() {
        D = true;
        QLog.d("ARTransparentWebviewPlugin", 1, "WebViewTime startRender. isStartRender = " + D);
        if (TextUtils.isEmpty(f97547i)) {
            return;
        }
        f97548m.callJs(f97547i, String.valueOf(true));
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements SensorEventListener {

        /* renamed from: d, reason: collision with root package name */
        protected byte f97553d;

        /* renamed from: e, reason: collision with root package name */
        protected String f97554e;

        public a(byte b16, String str) {
            this.f97553d = b16;
            this.f97554e = str;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (this.f97553d != 3) {
                return;
            }
            float[] fArr = new float[4];
            SensorManager sensorManager = b.this.f97550e;
            SensorManager.getQuaternionFromVector(fArr, sensorEvent.values);
            b.this.f97552h[0] = fArr[1];
            b.this.f97552h[1] = fArr[2];
            b.this.f97552h[2] = fArr[3];
            b.this.f97552h[3] = fArr[0];
            if (b.C && b.D) {
                b.this.callJs(this.f97554e, String.valueOf(true), String.valueOf(b.this.f97552h[0]), String.valueOf(b.this.f97552h[1]), String.valueOf(b.this.f97552h[2]), String.valueOf(b.this.f97552h[3]));
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
        }
    }
}
