package com.tencent.luggage.wxa.fg;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.tencent.luggage.wxa.fg.j;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.p;
import com.tencent.luggage.wxa.xd.k0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 491;
    public static final String NAME = "enableDeviceMotionChangeListening";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends c {

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f126135h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ j f126136i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(com.tencent.luggage.wxa.xd.d dVar, com.tencent.luggage.wxa.xd.d dVar2, j jVar) {
            super(dVar);
            this.f126135h = dVar2;
            this.f126136i = jVar;
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onDestroy() {
            a(true);
            com.tencent.luggage.wxa.ic.e.b(this.f126135h.getAppId(), this);
            this.f126136i.a(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends k0 {
        private static final int CTRL_INDEX = 490;
        private static final String NAME = "onDeviceMotionChange";
    }

    public final String b(com.tencent.luggage.wxa.xd.d dVar) {
        return "JsApi#SensorDeviceMotion" + dVar.hashCode();
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        j jVar = new j(NAME);
        a aVar = new a(dVar, dVar, jVar);
        if (h.f126170b.R()) {
            com.tencent.luggage.wxa.bf.f a16 = jVar.a(dVar, jSONObject, aVar, b(dVar), new ArrayList(Arrays.asList(11)));
            dVar.a(i3, makeReturnJson(a16.f144873b, a16.f144872a));
        } else {
            com.tencent.luggage.wxa.bf.f a17 = jVar.a(dVar, jSONObject, aVar, b(dVar), new ArrayList(Arrays.asList(3)));
            dVar.a(i3, makeReturnJson(a17.f144873b, a17.f144872a));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class c extends j.b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f126138a;

        /* renamed from: b, reason: collision with root package name */
        public p f126139b;

        /* renamed from: c, reason: collision with root package name */
        public b f126140c;

        /* renamed from: d, reason: collision with root package name */
        public float[] f126141d;

        /* renamed from: e, reason: collision with root package name */
        public float[] f126142e;

        /* renamed from: f, reason: collision with root package name */
        public final double f126143f;

        /* renamed from: g, reason: collision with root package name */
        public float[] f126144g;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements p.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xd.d f126145a;

            public a(com.tencent.luggage.wxa.xd.d dVar) {
                this.f126145a = dVar;
            }

            @Override // com.tencent.luggage.wxa.uk.p.a
            public boolean a(Object... objArr) {
                float[] fArr = (float[]) objArr[0];
                HashMap hashMap = new HashMap();
                hashMap.put(com.tencent.luggage.wxa.c8.c.f123400v, Float.valueOf(fArr[0]));
                hashMap.put("beta", Float.valueOf(fArr[1]));
                hashMap.put("gamma", Float.valueOf(fArr[2]));
                c.this.f126140c.setData(hashMap);
                return i.b().c(c.this.f126140c, this.f126145a);
            }
        }

        public c(com.tencent.luggage.wxa.xd.d dVar) {
            super(dVar);
            this.f126141d = new float[9];
            this.f126142e = new float[3];
            this.f126143f = 6.283185307179586d;
            this.f126144g = new float[3];
            b bVar = new b();
            this.f126140c = bVar;
            bVar.setContext(dVar);
            this.f126139b = new p(i.d(), new a(dVar));
        }

        public final void a(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() != 3) {
                return;
            }
            float[] fArr = sensorEvent.values;
            if (fArr == null || fArr.length < 3) {
                w.f("MicroMsg.JsApiEnableDeviceMotion", "deviceMotion sensor callback data invalidate.");
            } else {
                w.g("MicroMsg.JsApiEnableDeviceMotion", "try to do frequency limit action(%s).", Boolean.valueOf(this.f126139b.a(fArr)));
            }
        }

        public final void b(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() != 11) {
                return;
            }
            SensorManager.getRotationMatrixFromVector(this.f126141d, sensorEvent.values);
            SensorManager.getOrientation(this.f126141d, this.f126142e);
            float[] fArr = this.f126142e;
            float f16 = fArr[0];
            if (f16 < 0.0f) {
                fArr[0] = (float) (f16 + 6.283185307179586d);
            }
            fArr[2] = -fArr[2];
            this.f126144g[0] = (float) Math.toDegrees(fArr[0]);
            this.f126144g[1] = (float) Math.toDegrees(this.f126142e[1]);
            this.f126144g[2] = (float) Math.toDegrees(this.f126142e[2]);
            w.g("MicroMsg.JsApiEnableDeviceMotion", "try to do frequency limit action(%s).", Boolean.valueOf(this.f126139b.a(this.f126144g)));
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (this.f126138a) {
                return;
            }
            if (h.f126170b.R()) {
                b(sensorEvent);
            } else {
                a(sensorEvent);
            }
        }

        @Override // com.tencent.luggage.wxa.fg.j.b
        public void a(boolean z16) {
            this.f126138a = z16;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
        }
    }
}
