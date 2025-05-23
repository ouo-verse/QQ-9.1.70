package c.t.m.g;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.autotemplate.model.TAVBaseAutomaticEffect;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes.dex */
public class h2 implements SensorEventListener, z1 {

    /* renamed from: o, reason: collision with root package name */
    public static Context f29720o;

    /* renamed from: p, reason: collision with root package name */
    public static volatile h2 f29721p;

    /* renamed from: q, reason: collision with root package name */
    public static SharedPreferences f29722q;

    /* renamed from: b, reason: collision with root package name */
    public SensorManager f29724b;

    /* renamed from: c, reason: collision with root package name */
    public Sensor f29725c;

    /* renamed from: d, reason: collision with root package name */
    public Sensor f29726d;

    /* renamed from: e, reason: collision with root package name */
    public Sensor f29727e;

    /* renamed from: k, reason: collision with root package name */
    public HandlerThread f29733k;

    /* renamed from: f, reason: collision with root package name */
    public long f29728f = 0;

    /* renamed from: g, reason: collision with root package name */
    public long f29729g = 0;

    /* renamed from: h, reason: collision with root package name */
    public double f29730h = 0.0d;

    /* renamed from: i, reason: collision with root package name */
    public boolean f29731i = false;

    /* renamed from: j, reason: collision with root package name */
    public String f29732j = "unknown";

    /* renamed from: l, reason: collision with root package name */
    public int f29734l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f29735m = 0;

    /* renamed from: n, reason: collision with root package name */
    public int f29736n = 0;

    /* renamed from: a, reason: collision with root package name */
    public y1 f29723a = new y1(1.0f, 0.6f);

    public static h2 a() {
        if (f29721p == null) {
            f29721p = new h2();
        }
        return f29721p;
    }

    public String b() {
        if (this.f29732j.equals(TencentLocation.VEHICLE_MODE) && this.f29730h > 0.0d && System.currentTimeMillis() - this.f29730h > 30000.0d) {
            this.f29732j = "unknown";
            this.f29730h = 0.0d;
        }
        if (this.f29732j.equals(TencentLocation.VEHICLE_MODE)) {
            this.f29735m = 0;
            return TencentLocation.VEHICLE_MODE;
        }
        if (this.f29732j.equals("static")) {
            this.f29735m = 0;
            return "static";
        }
        if (this.f29729g > 0 && System.currentTimeMillis() - this.f29729g > 20000) {
            this.f29735m = 0;
            return "static";
        }
        if (this.f29728f > 0 && this.f29729g == 0 && System.currentTimeMillis() - this.f29728f > 20000) {
            this.f29735m = 0;
            return "static";
        }
        if (this.f29729g > 0 && System.currentTimeMillis() - this.f29729g < 10000 && this.f29735m >= 2) {
            return TencentLocation.PEDESTRIAN_MODE;
        }
        this.f29735m = 0;
        return "unknown";
    }

    public int c() {
        return this.f29734l;
    }

    @TargetApi(19)
    public final void d() {
        if (!this.f29731i) {
            this.f29728f = System.currentTimeMillis();
            try {
                if (this.f29724b == null) {
                    this.f29734l = -1;
                    return;
                }
                Handler handler = new Handler(this.f29733k.getLooper());
                if (!SensorMonitor.registerListener(this.f29724b, this, this.f29725c, 1, handler)) {
                    this.f29734l = -1;
                }
                SensorMonitor.registerListener(this.f29724b, this, this.f29726d, 3, handler);
                Sensor sensor = this.f29727e;
                if (sensor != null) {
                    SensorMonitor.registerListener(this.f29724b, this, sensor, 3, handler);
                    o3.b("TxMotionProvider", "Support STEP_COUNTER sensor!");
                } else {
                    o3.a("TxMotionProvider", "Don't support STEP_COUNTER sensor!");
                }
                this.f29731i = true;
            } catch (Throwable unused) {
                this.f29731i = false;
            }
        }
    }

    public void e() {
        o3.b("TxMotionProvider", "shutdown");
        HandlerThread handlerThread = this.f29733k;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f29733k = null;
        }
        a(false);
        this.f29734l = 0;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type != 1) {
            if (type != 10) {
                if (type == 19) {
                    float f16 = sensorEvent.values[0];
                    if (f16 > 2.14748365E9f) {
                        o3.b("TxMotionProvider", "Sensor: probably not a real value: " + sensorEvent.values[0]);
                        return;
                    }
                    if (((int) f16) > 0) {
                        String str = (String) k1.a(f29722q, "stepStr", (Object) "");
                        if (TextUtils.isEmpty(str)) {
                            k1.b(f29722q, "stepStr", (Object) (sensorEvent.values[0] + "," + System.currentTimeMillis() + ",0"));
                            return;
                        }
                        String[] split = str.split(",");
                        float floatValue = Float.valueOf(split[0]).floatValue();
                        float floatValue2 = Float.valueOf(split[2]).floatValue();
                        float f17 = sensorEvent.values[0];
                        if (floatValue <= f17) {
                            f17 -= floatValue;
                        }
                        k1.b(f29722q, "stepStr", (Object) (sensorEvent.values[0] + "," + System.currentTimeMillis() + "," + (floatValue2 + f17)));
                        return;
                    }
                    return;
                }
                return;
            }
            float[] fArr = sensorEvent.values;
            if (fArr.length == 3) {
                float f18 = fArr[0];
                float f19 = fArr[1];
                float f26 = fArr[2];
                double d16 = (f18 * f18) + (f19 * f19) + (f26 * f26);
                if (d16 < 0.1d) {
                    int i3 = this.f29736n + 1;
                    this.f29736n = i3;
                    if (i3 > 5) {
                        this.f29732j = "static";
                        return;
                    }
                    return;
                }
                if (d16 > 0.1d && d16 < 1.0d) {
                    int i16 = this.f29736n - 1;
                    this.f29736n = i16;
                    if (i16 <= 1) {
                        this.f29732j = "unknown";
                        return;
                    }
                    return;
                }
                if (d16 > 3.0d) {
                    this.f29736n = -5;
                    this.f29732j = "unknown";
                    return;
                }
                return;
            }
            return;
        }
        float[] fArr2 = sensorEvent.values;
        if (fArr2.length == 3) {
            this.f29723a.a(fArr2, sensorEvent.timestamp);
        }
    }

    public void a(Context context) {
        f29720o = context;
        f29722q = k1.a("LocationSDK");
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("Sensor");
        this.f29733k = baseHandlerThread;
        baseHandlerThread.start();
        this.f29723a.a(this);
        if (Build.VERSION.SDK_INT != 23) {
            this.f29724b = (SensorManager) f29720o.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        }
        SensorManager sensorManager = this.f29724b;
        if (sensorManager != null) {
            this.f29725c = SensorMonitor.getDefaultSensor(sensorManager, 1);
            this.f29726d = SensorMonitor.getDefaultSensor(this.f29724b, 10);
            this.f29727e = SensorMonitor.getDefaultSensor(this.f29724b, 19);
        }
        d();
    }

    public final void a(boolean z16) {
        if (this.f29731i) {
            SensorManager sensorManager = this.f29724b;
            if (sensorManager != null) {
                try {
                    sensorManager.unregisterListener(this, this.f29725c);
                    this.f29724b.unregisterListener(this, this.f29726d);
                } catch (Throwable unused) {
                }
                try {
                    Sensor sensor = this.f29727e;
                    if (sensor != null) {
                        this.f29724b.unregisterListener(this, sensor);
                    }
                } catch (Throwable th5) {
                    o3.b("TxMotionProvider", th5.toString());
                }
            }
            this.f29728f = 0L;
            this.f29729g = 0L;
            if (z16) {
                this.f29732j = TencentLocation.VEHICLE_MODE;
            } else {
                this.f29732j = "unknown";
            }
            this.f29731i = false;
        }
    }

    public void a(int i3, double d16, double d17, long j3) {
        o3.a(TAVBaseAutomaticEffect.TYPE_SPEED, "speedType:" + i3 + "speed:" + d16 + "," + d17 + "," + j3);
        double d18 = (double) j3;
        if (d18 > this.f29730h) {
            this.f29730h = d18;
            if (i3 == 2) {
                if (d17 > 4.0d && d16 > 4.0d) {
                    this.f29732j = TencentLocation.VEHICLE_MODE;
                } else {
                    this.f29732j = "unknown";
                }
            }
            if (i3 == 1) {
                if (d17 > 8.0d && d16 > 8.0d) {
                    this.f29732j = TencentLocation.VEHICLE_MODE;
                } else {
                    this.f29732j = "unknown";
                }
            }
            if (this.f29732j.equalsIgnoreCase(TencentLocation.VEHICLE_MODE)) {
                a(true);
            }
            if (this.f29732j.equalsIgnoreCase(TencentLocation.VEHICLE_MODE)) {
                return;
            }
            d();
        }
    }

    @Override // c.t.m.g.z1
    public void a(long j3) {
        this.f29729g = System.currentTimeMillis();
        this.f29734l++;
        this.f29735m++;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
    }
}
