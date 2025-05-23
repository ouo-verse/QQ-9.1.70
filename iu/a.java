package iu;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.shortvideo.panoramicvideo.Sensor.SensorEventHandler;
import com.tencent.mobileqq.shortvideo.util.CameraInterFace;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements CameraInterFace {

    /* renamed from: e, reason: collision with root package name */
    private static volatile a f408748e;

    /* renamed from: a, reason: collision with root package name */
    private SensorManager f408749a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<SensorEventHandler.CameraChangedCallBack> f408750b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f408751c = true;

    /* renamed from: d, reason: collision with root package name */
    private volatile int f408752d = -1;

    public static a c() {
        if (f408748e == null) {
            synchronized (a.class) {
                if (f408748e == null) {
                    f408748e = new a();
                }
            }
        }
        return f408748e;
    }

    public void a(boolean z16) {
        int i3;
        this.f408751c = z16;
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        this.f408752d = i3;
    }

    public boolean b() {
        return this.f408751c;
    }

    public boolean d() {
        SensorManager sensorManager = this.f408749a;
        if (sensorManager == null || SensorMonitor.getDefaultSensor(sensorManager, 11) == null) {
            return false;
        }
        return true;
    }

    public void e(SensorEventListener sensorEventListener) {
        Sensor defaultSensor;
        SensorManager sensorManager = this.f408749a;
        if (sensorManager != null && sensorEventListener != null && (defaultSensor = SensorMonitor.getDefaultSensor(sensorManager, 11)) != null) {
            SensorMonitor.registerListener(this.f408749a, sensorEventListener, defaultSensor, 1);
        }
    }

    public void f(SensorEventHandler.CameraChangedCallBack cameraChangedCallBack) {
        if (cameraChangedCallBack == null) {
            return;
        }
        this.f408750b = new WeakReference<>(cameraChangedCallBack);
    }

    public void g(Activity activity) {
        if (activity == null) {
            this.f408749a = null;
        } else if (this.f408749a == null) {
            this.f408749a = (SensorManager) activity.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.util.CameraInterFace
    public int getCameraID() {
        return this.f408752d;
    }

    public void h(boolean z16) {
        SensorEventHandler.CameraChangedCallBack cameraChangedCallBack;
        a(z16);
        WeakReference<SensorEventHandler.CameraChangedCallBack> weakReference = this.f408750b;
        if (weakReference == null || (cameraChangedCallBack = weakReference.get()) == null) {
            return;
        }
        cameraChangedCallBack.onCameraChanged(z16);
    }

    public void i(SensorEventListener sensorEventListener) {
        SensorManager sensorManager = this.f408749a;
        if (sensorManager != null && sensorEventListener != null) {
            sensorManager.unregisterListener(sensorEventListener);
        }
    }
}
