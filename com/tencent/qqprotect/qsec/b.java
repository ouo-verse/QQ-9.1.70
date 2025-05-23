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
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static b f363512d;

    /* renamed from: a, reason: collision with root package name */
    private SensorManager f363513a;

    /* renamed from: b, reason: collision with root package name */
    private a f363514b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f363515c;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    private class a implements SensorEventListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private float f363516d;

        /* renamed from: e, reason: collision with root package name */
        private float f363517e;

        /* renamed from: f, reason: collision with root package name */
        private float f363518f;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
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
            } else if (sensorEvent.sensor.getType() == 1) {
                float[] fArr = sensorEvent.values;
                this.f363516d = fArr[0];
                this.f363517e = fArr[1];
                this.f363518f = fArr[2];
            }
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f363515c = false;
        }
    }

    public static b a() {
        if (f363512d == null) {
            f363512d = new b();
        }
        return f363512d;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.f363514b != null) {
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put(HippyTKDListViewAdapter.X, Float.valueOf(this.f363514b.f363516d));
            arrayMap.put("y", Float.valueOf(this.f363514b.f363517e));
            arrayMap.put(QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, Float.valueOf(this.f363514b.f363518f));
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
        if (this.f363515c) {
            return;
        }
        this.f363515c = true;
        SensorManager sensorManager = (SensorManager) context.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        this.f363513a = sensorManager;
        Sensor defaultSensor = SensorMonitor.getDefaultSensor(sensorManager, 1);
        if (defaultSensor != null) {
            a aVar = new a();
            this.f363514b = aVar;
            SensorMonitor.registerListener(this.f363513a, aVar, defaultSensor, 3);
        }
    }

    public void d() {
        SensorManager sensorManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (this.f363515c && (sensorManager = this.f363513a) != null) {
            this.f363515c = false;
            sensorManager.unregisterListener(this.f363514b);
        }
    }
}
