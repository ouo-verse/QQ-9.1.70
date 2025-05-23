package com.tencent.luggage.wxa.fg;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.fg.j;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.p;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 92;
    public static final String NAME = "enableAccelerometer";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends d {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ j f126116e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(com.tencent.luggage.wxa.xd.d dVar, j jVar) {
            super(dVar);
            this.f126116e = jVar;
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onDestroy() {
            a(true);
            com.tencent.luggage.wxa.ic.e.b(this.f126122d.getAppId(), this);
            this.f126116e.a(this);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.fg.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6216b extends k0 {
        private static final int CTRL_INDEX = 93;
        private static final String NAME = "onAccelerometerChange";
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class d extends c {

        /* renamed from: c, reason: collision with root package name */
        public C6216b f126121c;

        /* renamed from: d, reason: collision with root package name */
        public com.tencent.luggage.wxa.xd.d f126122d;

        public d(com.tencent.luggage.wxa.xd.d dVar) {
            C6216b c6216b = new C6216b();
            this.f126121c = c6216b;
            c6216b.setContext(dVar);
            this.f126122d = dVar;
        }

        @Override // com.tencent.luggage.wxa.fg.b.c
        public boolean a(Map map) {
            this.f126121c.setData((Map<String, Object>) map);
            return i.b().c(this.f126121c, this.f126122d);
        }
    }

    public final String b(com.tencent.luggage.wxa.xd.d dVar) {
        return "JsApi#SensorAccelerometer" + dVar.hashCode();
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        j jVar = new j(NAME);
        com.tencent.luggage.wxa.bf.f a16 = jVar.a(dVar, jSONObject, new a(dVar, jVar), b(dVar), new ArrayList(Arrays.asList(1)));
        dVar.a(i3, makeReturnJson(a16.f144873b, a16.f144872a));
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class c extends j.b {

        /* renamed from: b, reason: collision with root package name */
        public boolean f126119b = false;

        /* renamed from: a, reason: collision with root package name */
        public p f126118a = new p(i.d(), new a());

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements p.a {
            public a() {
            }

            @Override // com.tencent.luggage.wxa.uk.p.a
            public boolean a(Object... objArr) {
                float[] fArr = (float[]) objArr[0];
                HashMap hashMap = new HashMap();
                hashMap.put(HippyTKDListViewAdapter.X, Float.valueOf((-fArr[0]) / 10.0f));
                hashMap.put("y", Float.valueOf((-fArr[1]) / 10.0f));
                hashMap.put(QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, Float.valueOf((-fArr[2]) / 10.0f));
                return c.this.a(hashMap);
            }
        }

        @Override // com.tencent.luggage.wxa.fg.j.b
        public void a(boolean z16) {
            this.f126119b = z16;
        }

        public abstract boolean a(Map map);

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (this.f126119b || sensorEvent.sensor.getType() != 1) {
                return;
            }
            float[] fArr = sensorEvent.values;
            if (fArr != null && fArr.length >= 3) {
                w.g("MicroMsg.JsApiEnableAccelerometer", "try to do frequency limit action(%s).", Boolean.valueOf(this.f126118a.a(fArr)));
            } else {
                w.f("MicroMsg.JsApiEnableAccelerometer", "ACCELEROMETER sensor callback data invalidate.");
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
        }
    }
}
