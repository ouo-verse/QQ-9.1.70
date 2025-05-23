package com.tencent.mobileqq.armap.sensor.provider;

import android.hardware.GeomagneticField;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mobileqq.armap.sensor.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class e implements SensorEventListener {
    static IPatchRedirector $redirector_;
    private float C;
    private float D;

    /* renamed from: d, reason: collision with root package name */
    protected List<Sensor> f199771d;

    /* renamed from: e, reason: collision with root package name */
    protected float[] f199772e;

    /* renamed from: f, reason: collision with root package name */
    protected SensorManager f199773f;

    /* renamed from: h, reason: collision with root package name */
    protected a.InterfaceC7424a f199774h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f199775i;

    /* renamed from: m, reason: collision with root package name */
    private float f199776m;

    public e(SensorManager sensorManager, a.InterfaceC7424a interfaceC7424a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) sensorManager, (Object) interfaceC7424a);
            return;
        }
        this.f199771d = new ArrayList();
        this.f199772e = new float[3];
        this.f199775i = false;
        this.f199776m = -1.0f;
        this.C = -1.0f;
        this.D = -1.0f;
        this.f199773f = sensorManager;
        this.f199774h = interfaceC7424a;
    }

    private GeomagneticField b() {
        if (this.f199775i) {
            return new GeomagneticField(this.f199776m, this.C, this.D, System.currentTimeMillis());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Float) iPatchRedirector.redirect((short) 7, (Object) this)).floatValue();
        }
        GeomagneticField b16 = b();
        if (b16 != null) {
            return b16.getDeclination();
        }
        return 0.0f;
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        Iterator<Sensor> it = this.f199771d.iterator();
        while (it.hasNext()) {
            SensorMonitor.registerListener(this.f199773f, this, it.next(), 1);
        }
    }

    public void d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        Iterator<Sensor> it = this.f199771d.iterator();
        while (it.hasNext()) {
            SensorMonitor.registerListener(this.f199773f, this, it.next(), i3);
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Iterator<Sensor> it = this.f199771d.iterator();
        while (it.hasNext()) {
            this.f199773f.unregisterListener(this, it.next());
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) sensor, i3);
        }
    }
}
