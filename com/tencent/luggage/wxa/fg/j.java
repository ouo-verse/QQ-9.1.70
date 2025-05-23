package com.tencent.luggage.wxa.fg;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.nb.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j {

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap f126180d = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public SensorManager f126181a;

    /* renamed from: b, reason: collision with root package name */
    public Handler f126182b;

    /* renamed from: c, reason: collision with root package name */
    public String f126183c = null;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f126184a;

        static {
            int[] iArr = new int[e.d.values().length];
            f126184a = iArr;
            try {
                iArr[e.d.BACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f126184a[e.d.CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f126184a[e.d.HOME_PRESSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f126184a[e.d.LAUNCH_NATIVE_PAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f126184a[e.d.LAUNCH_MINI_PROGRAM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class b extends e.c implements SensorEventListener {
        public b() {
        }

        public abstract void a(boolean z16);

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onPause(e.d dVar) {
            int i3 = a.f126184a[dVar.ordinal()];
            if ((i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5) && h.f126170b.A()) {
                a(true);
            }
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onResume() {
            if (h.f126170b.A()) {
                a(false);
            }
        }

        public b(com.tencent.luggage.wxa.xd.d dVar) {
        }
    }

    public j(String str) {
        this.f126182b = new Handler(a(str).getLooper());
    }

    public static HandlerThread a(String str) {
        HandlerThread handlerThread;
        String str2 = "MicroMsg.UnitSensor." + str;
        HashMap hashMap = f126180d;
        synchronized (hashMap) {
            handlerThread = (HandlerThread) hashMap.get(str2);
            if (handlerThread == null) {
                handlerThread = com.tencent.luggage.wxa.cq.d.e(str2, 5);
                hashMap.put(str2, handlerThread);
            }
        }
        if (handlerThread.getLooper() == null) {
            handlerThread.start();
        }
        return handlerThread;
    }

    public com.tencent.luggage.wxa.bf.f a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, b bVar, String str, List list) {
        return a(dVar.getAppId(), jSONObject, bVar, str, list);
    }

    public com.tencent.luggage.wxa.bf.f a(String str, JSONObject jSONObject, b bVar, String str2, List list) {
        this.f126183c = str2;
        boolean optBoolean = jSONObject.optBoolean("enable");
        int optInt = jSONObject.optInt(WidgetCacheConstellationData.INTERVAL, 200);
        w.d("MicroMsg.UnitSensor", "sessionId:%s,interval:%s,enable:%b", str2, Integer.valueOf(optInt), Boolean.valueOf(optBoolean));
        if (this.f126181a == null) {
            this.f126181a = (SensorManager) z.c().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        }
        if (this.f126181a == null) {
            w.d("MicroMsg.UnitSensor", "getSystemService(SENSOR_SERVICE) failed.");
            return new com.tencent.luggage.wxa.bf.f("fail:null system service", new Object[0]);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Sensor sensor = (Sensor) com.tencent.luggage.wxa.ia.a.a(this.f126181a, com.tencent.luggage.wxa.ja.b.a(((Integer) it.next()).intValue(), new com.tencent.luggage.wxa.ja.a()).a(), "com/tencent/mm/plugin/appbrand/jsapi/sensor/UnitSensor", "invoke", "(Ljava/lang/String;Lorg/json/JSONObject;Lcom/tencent/mm/plugin/appbrand/jsapi/sensor/UnitSensor$SensorEventListenerImpl;Ljava/lang/String;Ljava/util/List;)Lcom/tencent/mm/plugin/appbrand/jsapi/file/INFSApiUnit$CallResult;", "android/hardware/SensorManager", "getDefaultSensor", "(I)Landroid/hardware/Sensor;");
            if (sensor == null) {
                w.d("MicroMsg.UnitSensor", "get sensor failed.");
                return new com.tencent.luggage.wxa.bf.f("fail:null sensor", new Object[0]);
            }
            arrayList.add(sensor);
        }
        String str3 = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
        if (optBoolean) {
            a.c c16 = com.tencent.luggage.wxa.nb.a.a().c(str2);
            if (c16 == null) {
                c16 = com.tencent.luggage.wxa.nb.a.a().a(str2, true);
            }
            if (((b) c16.a("sensor_event_listener", (Object) null)) != null) {
                w.f("MicroMsg.UnitSensor", "register failed, sensorEventListener has already registered.");
                return new com.tencent.luggage.wxa.bf.f("fail, has enable, should stop pre operation", new Object[0]);
            }
            com.tencent.luggage.wxa.ic.e.a(str, bVar);
            c16.b("sensor_event_listener", bVar);
            Iterator it5 = arrayList.iterator();
            boolean z16 = false;
            while (it5.hasNext() && (z16 = SensorMonitor.registerListener(this.f126181a, bVar, (Sensor) it5.next(), i.a(optInt), this.f126182b))) {
            }
            if (!z16) {
                this.f126181a.unregisterListener(bVar);
                bVar.a(true);
                com.tencent.luggage.wxa.ic.e.b(str, bVar);
                c16.b();
                com.tencent.luggage.wxa.nb.a.a().d(str2);
            }
            w.d("MicroMsg.UnitSensor", "register sensor finished(s : %s, r : %s).", str2, Boolean.valueOf(z16));
            if (!z16) {
                str3 = "fail:system error";
            }
            return new com.tencent.luggage.wxa.bf.f(str3, new Object[0]);
        }
        a.c d16 = com.tencent.luggage.wxa.nb.a.a().d(str2);
        if (d16 == null) {
            w.d("MicroMsg.UnitSensor", "unregister sensor event listener failed, keyValueSet do not exist.");
            return new com.tencent.luggage.wxa.bf.f("fail:fail to disable, not enable?", new Object[0]);
        }
        b bVar2 = (b) d16.a("sensor_event_listener", (Object) null);
        if (bVar2 == null) {
            w.d("MicroMsg.UnitSensor", "unregister sensor event listener failed, listener do not exist.");
            return new com.tencent.luggage.wxa.bf.f("fail:fail to disable, not enable?", new Object[0]);
        }
        this.f126181a.unregisterListener(bVar2);
        com.tencent.luggage.wxa.ic.e.b(str, bVar2);
        bVar2.a(true);
        d16.b();
        w.d("MicroMsg.UnitSensor", "unregister sensor finished(%s).", str2);
        return new com.tencent.luggage.wxa.bf.f(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, new Object[0]);
    }

    public void a(b bVar) {
        this.f126181a.unregisterListener(bVar);
        if (TextUtils.isEmpty(this.f126183c)) {
            return;
        }
        com.tencent.luggage.wxa.nb.a.a().d(this.f126183c);
    }
}
