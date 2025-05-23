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
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 488;
    public static final String NAME = "enableGyroscope";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends c {

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f126147d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ j f126148e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(com.tencent.luggage.wxa.xd.d dVar, com.tencent.luggage.wxa.xd.d dVar2, j jVar) {
            super(dVar);
            this.f126147d = dVar2;
            this.f126148e = jVar;
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onDestroy() {
            a(true);
            com.tencent.luggage.wxa.ic.e.b(this.f126147d.getAppId(), this);
            this.f126148e.a(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends k0 {
        private static final int CTRL_INDEX = 489;
        private static final String NAME = "onGyroscopeChange";
    }

    public final String b(com.tencent.luggage.wxa.xd.d dVar) {
        return "JsApi#SensorGyroscope" + dVar.hashCode();
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        j jVar = new j(NAME);
        com.tencent.luggage.wxa.bf.f a16 = jVar.a(dVar, jSONObject, new a(dVar, dVar, jVar), b(dVar), new ArrayList(Arrays.asList(4)));
        dVar.a(i3, makeReturnJson(a16.f144873b, a16.f144872a));
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class c extends j.b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f126150a;

        /* renamed from: b, reason: collision with root package name */
        public p f126151b;

        /* renamed from: c, reason: collision with root package name */
        public b f126152c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements p.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xd.d f126153a;

            public a(com.tencent.luggage.wxa.xd.d dVar) {
                this.f126153a = dVar;
            }

            @Override // com.tencent.luggage.wxa.uk.p.a
            public boolean a(Object... objArr) {
                float[] fArr = (float[]) objArr[0];
                HashMap hashMap = new HashMap();
                hashMap.put(HippyTKDListViewAdapter.X, Float.valueOf(fArr[0]));
                hashMap.put("y", Float.valueOf(fArr[1]));
                hashMap.put(QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, Float.valueOf(fArr[2]));
                c.this.f126152c.setData(hashMap);
                return i.b().c(c.this.f126152c, this.f126153a);
            }
        }

        public c(com.tencent.luggage.wxa.xd.d dVar) {
            super(dVar);
            b bVar = new b();
            this.f126152c = bVar;
            bVar.setContext(dVar);
            this.f126151b = new p(i.d(), new a(dVar));
        }

        @Override // com.tencent.luggage.wxa.fg.j.b
        public void a(boolean z16) {
            this.f126150a = z16;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (this.f126150a || sensorEvent.sensor.getType() != 4) {
                return;
            }
            float[] fArr = sensorEvent.values;
            if (fArr != null && fArr.length >= 3) {
                w.g("MicroMsg.JsApiEnableGyroscope", "try to do frequency limit action(%s).", Boolean.valueOf(this.f126151b.a(fArr)));
            } else {
                w.f("MicroMsg.JsApiEnableGyroscope", "deviceMotion sensor callback data invalidate.");
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
        }
    }
}
