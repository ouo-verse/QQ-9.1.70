package com.tencent.mobileqq.guild.live.livemanager;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.provider.Settings;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 -2\u00020\u0001:\u0002./B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u00a2\u0006\u0004\b+\u0010,J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0004J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010!R\u0016\u0010$\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010#R\u0014\u0010*\u001a\u00020\u001b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010)\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/guild/live/livemanager/QQGuildOrientationSensorManager;", "Landroid/hardware/SensorEventListener;", "Landroid/content/Context;", "context", "", tl.h.F, "", "g", "f", "enable", "i", "d", "Landroid/hardware/SensorEvent;", "event", "onSensorChanged", "Landroid/hardware/Sensor;", WebRTCSDK.PRIVILEGE_SENSOR, "", "accuracy", "onAccuracyChanged", "Lcom/tencent/mobileqq/guild/live/livemanager/QQGuildOrientationSensorManager$b;", "Lcom/tencent/mobileqq/guild/live/livemanager/QQGuildOrientationSensorManager$b;", "listener", "Landroid/hardware/SensorManager;", "e", "Landroid/hardware/SensorManager;", "sensorManager", "", "J", "preTime", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "refreshIsAutoRotateOnJob", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isAutoRotateOn", BdhLogUtil.LogTag.Tag_Conn, "I", "mPreOrientation", "D", "()J", "curSecond", "<init>", "(Lcom/tencent/mobileqq/guild/live/livemanager/QQGuildOrientationSensorManager$b;)V", "E", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QQGuildOrientationSensorManager implements SensorEventListener {

    /* renamed from: C, reason: from kotlin metadata */
    private int mPreOrientation;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean enable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b listener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SensorManager sensorManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long preTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b refreshIsAutoRotateOnJob;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Context context;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isAutoRotateOn;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/live/livemanager/QQGuildOrientationSensorManager$b;", "", "", "newOrientation", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface b {
        void a(int newOrientation);
    }

    public QQGuildOrientationSensorManager(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        this.mPreOrientation = -1;
        this.enable = true;
        this.preTime = e();
    }

    private final long e() {
        return System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean g(Context context) {
        int i3;
        if (context == null) {
            return false;
        }
        try {
            i3 = Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation");
        } catch (Exception e16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "get ACCELEROMETER_ROTATION error:" + e16.getMessage();
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QQGuildOrientationSensorManager", 1, (String) it.next(), null);
            }
            i3 = 0;
        }
        if (i3 != 1) {
            return false;
        }
        return true;
    }

    private final void h(Context context) {
        Job f16;
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.refreshIsAutoRotateOnJob;
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar2 = null;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        CoroutineScope f17 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.c.f261781e);
        if (f17 != null) {
            bVar2 = CorountineFunKt.e(f17, "refreshIsAutoRotateOn", Boolean.FALSE, null, Boolean.TRUE, new QQGuildOrientationSensorManager$refreshIsAutoRotateOn$1(this, context, null), 4, null);
        }
        this.refreshIsAutoRotateOnJob = bVar2;
    }

    public final void d() {
        Job f16;
        SensorManager sensorManager = this.sensorManager;
        if (sensorManager != null) {
            Intrinsics.checkNotNull(sensorManager);
            sensorManager.unregisterListener(this);
            com.tencent.mobileqq.guild.util.performance.f.f235588a.c(0);
            this.sensorManager = null;
        }
        this.context = null;
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.refreshIsAutoRotateOnJob;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        this.refreshIsAutoRotateOnJob = null;
    }

    public final void f() {
        Object obj;
        BaseApplication context = BaseApplication.getContext();
        this.context = context;
        if (context != null) {
            obj = context.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        } else {
            obj = null;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.hardware.SensorManager");
        SensorManager sensorManager = (SensorManager) obj;
        this.sensorManager = sensorManager;
        Intrinsics.checkNotNull(sensorManager);
        SensorManager sensorManager2 = this.sensorManager;
        Intrinsics.checkNotNull(sensorManager2);
        SensorMonitor.registerListener(sensorManager, this, SensorMonitor.getDefaultSensor(sensorManager2, 1), 3);
        com.tencent.mobileqq.guild.util.performance.f.f235588a.b(0);
    }

    public final void i(boolean enable) {
        this.enable = enable;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(@NotNull Sensor sensor, int accuracy) {
        Intrinsics.checkNotNullParameter(sensor, "sensor");
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(@NotNull SensorEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.enable) {
            int i3 = 1;
            if (1 == event.sensor.getType()) {
                long e16 = e();
                if (e16 - this.preTime < 1) {
                    return;
                }
                this.preTime = e16;
                h(this.context);
                if (!this.isAutoRotateOn) {
                    return;
                }
                float[] fArr = event.values;
                float f16 = fArr[0];
                float f17 = fArr[1];
                double d16 = f16;
                if (d16 >= 4.5d || d16 < -4.5d || f17 < 4.5d) {
                    if (d16 >= 4.5d) {
                        double d17 = f17;
                        if (d17 < 4.5d && d17 >= -4.5d) {
                            i3 = 0;
                        }
                    }
                    if (d16 <= -4.5d) {
                        double d18 = f17;
                        if (d18 < 4.5d && d18 >= -4.5d) {
                            i3 = 8;
                        }
                    }
                    i3 = -1;
                }
                if (this.mPreOrientation != i3 && i3 != -1) {
                    this.mPreOrientation = i3;
                    this.listener.a(i3);
                }
            }
        }
    }
}
