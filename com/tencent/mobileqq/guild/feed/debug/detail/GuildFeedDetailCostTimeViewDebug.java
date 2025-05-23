package com.tencent.mobileqq.guild.feed.debug.detail;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.guild.feed.debug.j;
import com.tencent.mobileqq.guild.feed.event.GuildFeedReportEvent;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedDetailCostTimeViewDebug implements LifecycleEventObserver, SensorEventListener, SimpleEventReceiver {

    /* renamed from: e, reason: collision with root package name */
    private static volatile GuildFeedDetailCostTimeViewDebug f218431e;

    /* renamed from: d, reason: collision with root package name */
    private long f218432d;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.feed.debug.detail.GuildFeedDetailCostTimeViewDebug$2, reason: invalid class name */
    /* loaded from: classes13.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ GuildFeedDetailCostTimeViewDebug this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.b();
        }
    }

    GuildFeedDetailCostTimeViewDebug() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (!j.b().a("key_feed_detail_time_cost_view_enabled", false)) {
            return;
        }
        f();
    }

    public static GuildFeedDetailCostTimeViewDebug c() {
        if (f218431e == null) {
            synchronized (GuildFeedDetailCostTimeViewDebug.class) {
                if (f218431e == null) {
                    f218431e = new GuildFeedDetailCostTimeViewDebug();
                }
            }
        }
        return f218431e;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildFeedReportEvent.class);
        return arrayList;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() != 1) {
            return;
        }
        float[] fArr = sensorEvent.values;
        float f16 = fArr[0];
        float f17 = fArr[1];
        float f18 = fArr[2];
        if (Math.abs(f16) > 15.0f || Math.abs(f17) > 15.0f || Math.abs(f18) > 15.0f) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f218432d > 2000) {
                f();
                this.f218432d = currentTimeMillis;
            }
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            e();
            lifecycleOwner.getLifecycle().removeObserver(this);
        }
    }

    private void e() {
    }

    private void f() {
    }

    public void d(Fragment fragment) {
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
    }
}
