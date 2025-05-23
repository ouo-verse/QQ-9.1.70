package com.tencent.qqprotect.qsec;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static d f363528d;

    /* renamed from: a, reason: collision with root package name */
    private SensorManager f363529a;

    /* renamed from: b, reason: collision with root package name */
    private a f363530b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f363531c;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    private class a implements SensorEventListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private float f363532d;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) sensor, i3);
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) sensorEvent);
            } else if (sensorEvent.sensor.getType() == 5) {
                this.f363532d = sensorEvent.values[0];
            }
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f363531c = false;
        }
    }

    public static d a() {
        if (f363528d == null) {
            f363528d = new d();
        }
        return f363528d;
    }

    public float b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
        }
        a aVar = this.f363530b;
        if (aVar != null) {
            return aVar.f363532d;
        }
        return -1.0f;
    }

    public void c(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        if (this.f363531c) {
            return;
        }
        this.f363531c = true;
        SensorManager sensorManager = (SensorManager) context.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        this.f363529a = sensorManager;
        Sensor defaultSensor = SensorMonitor.getDefaultSensor(sensorManager, 5);
        if (defaultSensor != null) {
            a aVar = new a();
            this.f363530b = aVar;
            SensorMonitor.registerListener(this.f363529a, aVar, defaultSensor, 0);
        }
    }

    public void d() {
        SensorManager sensorManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (this.f363531c && (sensorManager = this.f363529a) != null) {
            this.f363531c = false;
            sensorManager.unregisterListener(this.f363530b);
        }
    }
}
