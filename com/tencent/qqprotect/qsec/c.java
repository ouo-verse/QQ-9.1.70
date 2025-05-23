package com.tencent.qqprotect.qsec;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.ArrayMap;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static c f363520d;

    /* renamed from: a, reason: collision with root package name */
    private SensorManager f363521a;

    /* renamed from: b, reason: collision with root package name */
    private a f363522b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f363523c;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    private class a implements SensorEventListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private float f363524d;

        /* renamed from: e, reason: collision with root package name */
        private float f363525e;

        /* renamed from: f, reason: collision with root package name */
        private float f363526f;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
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
            } else if (sensorEvent.sensor.getType() == 4) {
                float[] fArr = sensorEvent.values;
                this.f363524d = fArr[0];
                this.f363525e = fArr[1];
                this.f363526f = fArr[2];
            }
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f363523c = false;
        }
    }

    public static c a() {
        if (f363520d == null) {
            f363520d = new c();
        }
        return f363520d;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.f363522b != null) {
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put(HippyTKDListViewAdapter.X, Float.valueOf(this.f363522b.f363524d));
            arrayMap.put("y", Float.valueOf(this.f363522b.f363525e));
            arrayMap.put(QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, Float.valueOf(this.f363522b.f363526f));
            return arrayMap.toString();
        }
        return "-1";
    }

    public void c(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        if (this.f363523c) {
            return;
        }
        this.f363523c = true;
        SensorManager sensorManager = (SensorManager) context.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        this.f363521a = sensorManager;
        Sensor defaultSensor = SensorMonitor.getDefaultSensor(sensorManager, 4);
        if (defaultSensor != null) {
            a aVar = new a();
            this.f363522b = aVar;
            SensorMonitor.registerListener(this.f363521a, aVar, defaultSensor, 3);
        }
    }

    public void d() {
        SensorManager sensorManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (this.f363523c && (sensorManager = this.f363521a) != null) {
            this.f363523c = false;
            sensorManager.unregisterListener(this.f363522b);
        }
    }
}
