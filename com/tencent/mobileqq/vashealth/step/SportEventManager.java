package com.tencent.mobileqq.vashealth.step;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorEventListener2;
import android.hardware.SensorManager;
import android.os.Build;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vashealth.StepCounterPermissionUtils;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/vashealth/step/SportEventManager;", "", "", "k", tl.h.F, "b", "i", "f", "j", "g", "d", "c", "e", "Landroid/hardware/SensorEventListener;", "Landroid/hardware/SensorEventListener;", "sensorEventListener", "Landroid/content/BroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "newDayReceiver", "shutdownReceiver", "<init>", "()V", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class SportEventManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SportEventManager f312326a = new SportEventManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile SensorEventListener sensorEventListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile BroadcastReceiver newDayReceiver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile BroadcastReceiver shutdownReceiver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/vashealth/step/SportEventManager$a", "Landroid/hardware/SensorEventListener2;", "Landroid/hardware/Sensor;", WebRTCSDK.PRIVILEGE_SENSOR, "", "onFlushCompleted", "Landroid/hardware/SensorEvent;", "event", "onSensorChanged", "", "accuracy", "onAccuracyChanged", "health-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements SensorEventListener2 {
        a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(@NotNull Sensor sensor, int accuracy) {
            Intrinsics.checkNotNullParameter(sensor, "sensor");
        }

        @Override // android.hardware.SensorEventListener2
        public void onFlushCompleted(@NotNull Sensor sensor) {
            Intrinsics.checkNotNullParameter(sensor, "sensor");
            d.f312333a.g();
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(@NotNull SensorEvent event) {
            boolean z16;
            Intrinsics.checkNotNullParameter(event, "event");
            float[] fArr = event.values;
            if (fArr != null) {
                Intrinsics.checkNotNullExpressionValue(fArr, "event.values");
                if (fArr.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    int i3 = (int) event.values[0];
                    long j3 = event.timestamp / 1000000;
                    d dVar = d.f312333a;
                    Pair<Long, Integer> b16 = dVar.b();
                    Object obj = b16.second;
                    Intrinsics.checkNotNullExpressionValue(obj, "lastRecord.second");
                    if (i3 - ((Number) obj).intValue() > 9) {
                        long j16 = event.timestamp;
                        Object obj2 = b16.first;
                        Intrinsics.checkNotNullExpressionValue(obj2, "lastRecord.first");
                        if (j16 - ((Number) obj2).longValue() > 100) {
                            dVar.e(i3, j3);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            QLog.e("SportEventManager", 1, "sensor value is null");
        }
    }

    SportEventManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        if (sensorEventListener != null) {
            Object systemService = BaseApplication.context.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
            ((SensorManager) systemService).flush(sensorEventListener);
        }
    }

    private final void d() {
        try {
            QLog.d("SportEventManager", 1, "reRegisterListener");
            Object systemService = BaseApplication.context.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
            SensorManager sensorManager = (SensorManager) systemService;
            SensorMonitor.registerListener(sensorManager, sensorEventListener, SensorMonitor.getDefaultSensor(sensorManager, 19), 1, 360000000);
        } catch (Throwable th5) {
            QLog.e("SportEventManager", 1, "reRegisterListener failed, error is " + th5);
        }
    }

    private final void f() {
        if (newDayReceiver != null) {
            BaseApplication.context.unregisterReceiver(newDayReceiver);
            newDayReceiver = null;
        }
    }

    private final void g() {
        if (shutdownReceiver != null) {
            BaseApplication.context.unregisterReceiver(shutdownReceiver);
            shutdownReceiver = null;
        }
    }

    private final void h() {
        try {
            if (sensorEventListener != null) {
                QLog.d("SportEventManager", 1, "remove SensorEventListener2");
                Object systemService = BaseApplication.context.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
                ((SensorManager) systemService).unregisterListener(sensorEventListener);
                sensorEventListener = null;
            }
        } catch (Throwable th5) {
            QLog.e("SportEventManager", 1, "remove SensorEventListener2 failed, error is " + th5);
        }
    }

    private final void i() {
        if (newDayReceiver != null) {
            return;
        }
        newDayReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.vashealth.step.SportEventManager$setNewDayListener$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                if (QLog.isColorLevel()) {
                    QLog.d("SportEventManager", 2, "receive alarm when enter a new day");
                }
                d.f312333a.d(NetConnInfoCenter.getServerTimeMillis());
            }
        };
        BaseApplication baseApplication = BaseApplication.context;
        baseApplication.registerReceiver(newDayReceiver, new IntentFilter("StepEventHandlerImpl.action_time_monitor"));
        PendingIntent broadcast = PendingIntent.getBroadcast(baseApplication, 1, new Intent("StepEventHandlerImpl.action_time_monitor"), 167772160);
        Object systemService = baseApplication.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        AlarmManager alarmManager = (AlarmManager) systemService;
        long a16 = (l.f312344a.a(1) + 1) * 1000;
        try {
            if (Build.VERSION.SDK_INT > 30 && ContextCompat.checkSelfPermission(baseApplication, "android.permission.SCHEDULE_EXACT_ALARM") != 0) {
                alarmManager.set(0, a16, broadcast);
            } else {
                alarmManager.setExactAndAllowWhileIdle(0, a16, broadcast);
            }
        } catch (Exception e16) {
            QLog.e("SportEventManager", 1, "setNewDayListener failed, exception is " + e16);
        }
    }

    private final void j() {
        if (shutdownReceiver != null) {
            return;
        }
        shutdownReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.vashealth.step.SportEventManager$setShutdownReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                QLog.d("SportEventManager", 1, "receive shut down broadcast");
                SportEventManager.f312326a.b();
                d.f312333a.f(NetConnInfoCenter.getServerTime());
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_SHUTDOWN");
        BaseApplication.context.registerReceiver(shutdownReceiver, intentFilter);
    }

    private final void k() {
        try {
            if (sensorEventListener == null) {
                QLog.d("SportEventManager", 2, "init SensorEventListener2");
                sensorEventListener = new a();
                d();
            }
        } catch (Throwable th5) {
            QLog.e("SportEventManager", 2, "init SensorEventListener2 failed, error is " + th5);
        }
    }

    public final void c() {
        if (!StepCounterPermissionUtils.e() && !StepCounterPermissionUtils.h() && !StepCounterPermissionUtils.i()) {
            if (!StepCounterPermissionUtils.g()) {
                QLog.d("SportEventManager", 1, "user permission denied, cancel init listener");
                return;
            }
            k();
            i();
            j();
            return;
        }
        QLog.d("SportEventManager", 1, "user device permission accept, cancel init listener");
    }

    public final void e() {
        h();
        f();
        g();
    }
}
