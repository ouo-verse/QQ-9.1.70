package com.tencent.av.foldable;

import android.content.Context;
import android.content.res.Configuration;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import androidx.annotation.NonNull;
import com.tencent.av.foldable.h;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private h<Integer> f73747a = null;

    /* renamed from: b, reason: collision with root package name */
    private h<Integer> f73748b = null;

    public f(@NonNull Context context) {
        d(context);
    }

    private void d(@NonNull Context context) {
        Sensor sensor;
        if (context != null && FoldInfoUtils.h(context)) {
            if (FoldInfoUtils.k()) {
                QLog.d("FoldInfoTracker", 1, "Hit using content provider!");
                this.f73747a = new c(context, FoldInfoUtils.b());
                this.f73748b = new d(context, FoldInfoUtils.d());
                return;
            }
            if (Build.VERSION.SDK_INT < FoldInfoUtils.e()) {
                QLog.d("FoldInfoTracker", 1, "API level is lower than " + FoldInfoUtils.e());
                this.f73747a = new h<>(-1);
                this.f73748b = new h<>(-1);
                return;
            }
            SensorManager sensorManager = (SensorManager) context.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
            if (sensorManager != null) {
                sensor = SensorMonitor.getDefaultSensor(sensorManager, 36);
            } else {
                QLog.d("FoldInfoTracker", 1, "SensorManager is null!");
                sensor = null;
            }
            if (sensorManager != null && sensor != null) {
                QLog.d("FoldInfoTracker", 1, "Hit using sensor tracker!");
                this.f73747a = new g(sensorManager, sensor);
                this.f73748b = new e();
                return;
            } else {
                QLog.d("FoldInfoTracker", 1, "Hit nothing!");
                this.f73747a = new h<>(-1);
                this.f73748b = new h<>(-1);
                return;
            }
        }
        QLog.d("FoldInfoTracker", 1, "Is not foldable device");
        this.f73747a = new h<>(-1);
        this.f73748b = new h<>(-1);
    }

    public void a() {
        this.f73748b.a();
        this.f73747a.a();
    }

    public int b() {
        return this.f73747a.b().intValue();
    }

    public int c() {
        return this.f73748b.b().intValue();
    }

    public void e(h.a<Integer> aVar) {
        this.f73747a.c(aVar);
    }

    public void f(h.a<Integer> aVar) {
        this.f73748b.c(aVar);
    }

    public void g() {
        this.f73748b.d();
        this.f73747a.d();
    }

    public void h(Configuration configuration) {
        if (this.f73748b instanceof e) {
            h<Integer> hVar = this.f73747a;
            if (hVar instanceof a) {
                ((e) this.f73748b).f(configuration, ((a) hVar).f());
            }
        }
    }
}
