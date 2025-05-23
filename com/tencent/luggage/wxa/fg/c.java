package com.tencent.luggage.wxa.fg;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.tencent.hippy.qq.adapter.image.HippyImageInfo;
import com.tencent.luggage.wxa.fg.j;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.p;
import com.tencent.luggage.wxa.xd.k0;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 94;
    public static final String NAME = "enableCompass";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends AbstractC6217c {

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f126123h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ j f126124i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(com.tencent.luggage.wxa.xd.d dVar, com.tencent.luggage.wxa.xd.d dVar2, j jVar) {
            super(dVar);
            this.f126123h = dVar2;
            this.f126124i = jVar;
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onDestroy() {
            a(true);
            com.tencent.luggage.wxa.ic.e.b(this.f126123h.getAppId(), this);
            this.f126124i.a(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends k0 {
        private static final int CTRL_INDEX = 95;
        private static final String NAME = "onCompassChange";
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.fg.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static abstract class AbstractC6217c extends j.b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f126126a;

        /* renamed from: b, reason: collision with root package name */
        public float[] f126127b;

        /* renamed from: c, reason: collision with root package name */
        public float[] f126128c;

        /* renamed from: d, reason: collision with root package name */
        public p f126129d;

        /* renamed from: e, reason: collision with root package name */
        public String f126130e;

        /* renamed from: f, reason: collision with root package name */
        public int f126131f;

        /* renamed from: g, reason: collision with root package name */
        public b f126132g;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.fg.c$c$a */
        /* loaded from: classes8.dex */
        public class a implements p.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xd.d f126133a;

            public a(com.tencent.luggage.wxa.xd.d dVar) {
                this.f126133a = dVar;
            }

            @Override // com.tencent.luggage.wxa.uk.p.a
            public boolean a(Object... objArr) {
                w.e("MicroMsg.JsApiEnableCompass", "onAction.");
                float[] fArr = new float[9];
                SensorManager.getRotationMatrix(fArr, null, AbstractC6217c.this.f126127b, AbstractC6217c.this.f126128c);
                SensorManager.getOrientation(fArr, new float[3]);
                HashMap hashMap = new HashMap();
                float degrees = (float) Math.toDegrees(r5[0]);
                if (degrees < 0.0f) {
                    degrees += 360.0f;
                }
                hashMap.put("direction", Float.valueOf(degrees));
                if (AbstractC6217c.this.f126130e.equalsIgnoreCase(QzoneWebMusicJsPlugin.EVENT_UNKOWN)) {
                    hashMap.put("accuracy", AbstractC6217c.this.f126130e + "{value:" + AbstractC6217c.this.f126131f + "}");
                } else {
                    hashMap.put("accuracy", AbstractC6217c.this.f126130e);
                }
                AbstractC6217c.this.f126132g.setData(hashMap);
                return i.b().c(AbstractC6217c.this.f126132g, this.f126133a);
            }
        }

        public AbstractC6217c(com.tencent.luggage.wxa.xd.d dVar) {
            super(dVar);
            this.f126127b = new float[3];
            this.f126128c = new float[3];
            this.f126130e = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
            this.f126131f = 0;
            b bVar = new b();
            this.f126132g = bVar;
            bVar.setContext(dVar);
            this.f126129d = new p(i.d(), new a(dVar));
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (this.f126126a) {
                return;
            }
            float[] fArr = sensorEvent.values;
            if (fArr != null && fArr.length >= 3) {
                if (sensorEvent.sensor.getType() == 2) {
                    this.f126128c = sensorEvent.values;
                    int i3 = sensorEvent.accuracy;
                    if (i3 != -1) {
                        if (i3 != 0) {
                            if (i3 != 1) {
                                if (i3 != 2) {
                                    if (i3 != 3) {
                                        this.f126130e = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
                                        this.f126131f = i3;
                                    } else {
                                        this.f126130e = "high";
                                    }
                                } else {
                                    this.f126130e = "medium";
                                }
                            } else {
                                this.f126130e = HippyImageInfo.QUALITY_LOW;
                            }
                        } else {
                            this.f126130e = "unreliable";
                        }
                    } else {
                        this.f126130e = "no-contact";
                    }
                } else if (sensorEvent.sensor.getType() == 1) {
                    this.f126127b = sensorEvent.values;
                } else {
                    return;
                }
                w.g("MicroMsg.JsApiEnableCompass", "try to do frequency limit action(%s).", Boolean.valueOf(this.f126129d.a(new Object[0])));
                return;
            }
            w.f("MicroMsg.JsApiEnableCompass", "compass sensor callback data invalidate.");
        }

        @Override // com.tencent.luggage.wxa.fg.j.b
        public void a(boolean z16) {
            this.f126126a = z16;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
        }
    }

    public final String b(com.tencent.luggage.wxa.xd.d dVar) {
        return "JsApi#SensorMagneticField" + dVar.hashCode();
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        j jVar = new j(NAME);
        com.tencent.luggage.wxa.bf.f a16 = jVar.a(dVar, jSONObject, new a(dVar, dVar, jVar), b(dVar), new ArrayList(Arrays.asList(2, 1)));
        dVar.a(i3, makeReturnJson(a16.f144873b, a16.f144872a));
    }
}
