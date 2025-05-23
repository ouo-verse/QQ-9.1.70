package com.tencent.qfsmonet.utils.device;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b implements SensorEventListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private SensorManager f342627d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f342628e;

    /* renamed from: f, reason: collision with root package name */
    private a f342629f;

    /* renamed from: h, reason: collision with root package name */
    private Handler f342630h;

    /* renamed from: i, reason: collision with root package name */
    private Context f342631i;

    public b(@NonNull Context context, Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) handler);
            return;
        }
        this.f342628e = false;
        this.f342629f = null;
        this.f342631i = context;
        this.f342630h = handler;
    }

    public void a(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            this.f342629f = aVar;
            com.tencent.qfsmonet.utils.a.c("Monet[MonetRotationVectorSensor.java]", "sensorDataListener was set.");
        }
    }

    public void b() throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.f342628e) {
            com.tencent.qfsmonet.utils.a.c("Monet[MonetRotationVectorSensor.java]", "sensor was started.");
            return;
        }
        try {
            SensorManager sensorManager = (SensorManager) this.f342631i.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
            this.f342627d = sensorManager;
            Sensor defaultSensor = SensorMonitor.getDefaultSensor(sensorManager, 11);
            if (defaultSensor != null) {
                boolean registerListener = SensorMonitor.registerListener(this.f342627d, this, defaultSensor, 1, this.f342630h);
                this.f342628e = registerListener;
                if (registerListener) {
                    return;
                }
                com.tencent.qfsmonet.utils.a.b("Monet[MonetRotationVectorSensor.java]", "listener registered fail.");
                throw new IllegalStateException("listener registered fail.");
            }
            com.tencent.qfsmonet.utils.a.b("Monet[MonetRotationVectorSensor.java]", "sensor do not support TYPE_ROTATION_VECTOR");
            throw new IllegalStateException("sensor do not support TYPE_ROTATION_VECTOR.");
        } catch (Throwable th5) {
            com.tencent.qfsmonet.utils.a.b("Monet[MonetRotationVectorSensor.java]", th5.toString());
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            if (!this.f342628e) {
                return;
            }
            this.f342627d.unregisterListener(this);
            this.f342628e = false;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) sensor, i3);
            return;
        }
        com.tencent.qfsmonet.utils.a.c("Monet[MonetRotationVectorSensor.java]", "onAccuracyChanged, " + i3);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) sensorEvent);
            return;
        }
        if (sensorEvent.accuracy == 0) {
            return;
        }
        float[] fArr = sensorEvent.values;
        float[] fArr2 = {fArr[0], fArr[1], fArr[2]};
        a aVar = this.f342629f;
        if (aVar == null) {
            com.tencent.qfsmonet.utils.a.b("Monet[MonetRotationVectorSensor.java]", "sensorDataListener was not set." + sensorEvent);
            return;
        }
        aVar.a(1, sensorEvent.timestamp, fArr2);
    }
}
