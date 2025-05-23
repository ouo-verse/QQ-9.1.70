package km2;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final SensorManager f412698a;

    /* renamed from: b, reason: collision with root package name */
    private final Sensor f412699b;

    /* renamed from: d, reason: collision with root package name */
    private boolean f412701d;

    /* renamed from: c, reason: collision with root package name */
    private final Object f412700c = new Object();

    /* renamed from: e, reason: collision with root package name */
    private final List<c> f412702e = new CopyOnWriteArrayList();

    /* renamed from: f, reason: collision with root package name */
    private final SensorEventListener f412703f = new b();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface c {
        void a(float f16, float f17, float f18);
    }

    public f(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        this.f412698a = sensorManager;
        this.f412699b = SensorMonitor.getDefaultSensor(sensorManager, 9);
    }

    public void b(c cVar) {
        synchronized (this.f412700c) {
            this.f412702e.add(cVar);
            if (!this.f412701d) {
                SensorMonitor.registerListener(this.f412698a, this.f412703f, this.f412699b, 2);
                this.f412701d = true;
            }
        }
    }

    public void c(c cVar) {
        this.f412702e.remove(cVar);
    }

    public void d() {
        synchronized (this.f412700c) {
            this.f412702e.clear();
            if (this.f412701d) {
                this.f412698a.unregisterListener(this.f412703f);
                this.f412701d = false;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private class b implements SensorEventListener {
        b() {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = sensorEvent.values;
            float f16 = fArr[0];
            float f17 = fArr[1];
            float f18 = fArr[2];
            Iterator it = f.this.f412702e.iterator();
            while (it.hasNext()) {
                ((c) it.next()).a(f16, f17, f18);
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
        }
    }
}
