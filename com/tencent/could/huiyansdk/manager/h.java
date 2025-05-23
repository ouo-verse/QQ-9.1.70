package com.tencent.could.huiyansdk.manager;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes5.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public SensorManager f100182a;

    /* renamed from: b, reason: collision with root package name */
    public a f100183b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f100184c;

    /* renamed from: d, reason: collision with root package name */
    public c f100185d;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements SensorEventListener {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
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
                return;
            }
            if (sensorEvent.sensor.getType() == 5) {
                float f16 = sensorEvent.values[0];
                c cVar = h.this.f100185d;
                if (cVar != null) {
                    cVar.a(f16);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final h f100187a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21357);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f100187a = new h();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface c {
        void a(float f16);
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f100184c = false;
        }
    }

    public void a() {
        SensorManager sensorManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else if (this.f100184c && (sensorManager = this.f100182a) != null) {
            this.f100184c = false;
            sensorManager.unregisterListener(this.f100183b);
            this.f100185d = null;
        }
    }
}
