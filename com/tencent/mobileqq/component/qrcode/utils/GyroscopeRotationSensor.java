package com.tencent.mobileqq.component.qrcode.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.component.qrcode.utils.GyroscopeRotationSensor;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0002\u0018\u0000 #2\u00020\u0001:\u0002\u000b\u000fB\u0017\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b0\u00101J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010 \u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001f\u0010\u0004R\u001b\u0010%\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\u0010\u001a\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010'R\u0016\u0010*\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010)R\u0011\u0010-\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/component/qrcode/utils/GyroscopeRotationSensor;", "", "com/tencent/mobileqq/component/qrcode/utils/GyroscopeRotationSensor$c", "g", "()Lcom/tencent/mobileqq/component/qrcode/utils/GyroscopeRotationSensor$c;", "", "o", "", "p", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/component/qrcode/utils/GyroscopeRotationSensor$b;", "a", "Lcom/tencent/mobileqq/component/qrcode/utils/GyroscopeRotationSensor$b;", "mOnRotationChangeListener", "Landroid/hardware/SensorManager;", "b", "Lkotlin/Lazy;", "l", "()Landroid/hardware/SensorManager;", "sensorManager", "Landroid/hardware/Sensor;", "c", "j", "()Landroid/hardware/Sensor;", WebRTCSDK.PRIVILEGE_SENSOR, "Landroid/os/Handler;", "d", h.F, "()Landroid/os/Handler;", "handler", "e", "k", "sensorListener", "", "f", "i", "()[F", "rotationVector", "", "J", "lastTimestamp", "Z", "_isRunning", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Z", "isRunning", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/component/qrcode/utils/GyroscopeRotationSensor$b;)V", "qrcode_component_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class GyroscopeRotationSensor {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mOnRotationChangeListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy sensorManager;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy sensor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy handler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy sensorListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy rotationVector;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long lastTimestamp;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean _isRunning;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/component/qrcode/utils/GyroscopeRotationSensor$a;", "", "", "NS2S", UserInfo.SEX_FEMALE, "<init>", "()V", "qrcode_component_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.component.qrcode.utils.GyroscopeRotationSensor$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/component/qrcode/utils/GyroscopeRotationSensor$b;", "", "", BasicAnimation.KeyPath.ROTATION_X, BasicAnimation.KeyPath.ROTATION_Y, "rotationZ", "", "onChanged", "qrcode_component_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public interface b {
        void onChanged(float rotationX, float rotationY, float rotationZ);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/component/qrcode/utils/GyroscopeRotationSensor$c", "Landroid/hardware/SensorEventListener;", "Landroid/hardware/SensorEvent;", "sensorEvent", "", "onSensorChanged", "Landroid/hardware/Sensor;", WebRTCSDK.PRIVILEGE_SENSOR, "", "accuracy", "onAccuracyChanged", "qrcode_component_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class c implements SensorEventListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GyroscopeRotationSensor.this);
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(@Nullable Sensor sensor, int accuracy) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) sensor, accuracy);
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(@Nullable SensorEvent sensorEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) sensorEvent);
                return;
            }
            if (sensorEvent != null) {
                GyroscopeRotationSensor gyroscopeRotationSensor = GyroscopeRotationSensor.this;
                if (gyroscopeRotationSensor.lastTimestamp == 0) {
                    gyroscopeRotationSensor.lastTimestamp = sensorEvent.timestamp;
                    return;
                }
                float f16 = ((float) (sensorEvent.timestamp - gyroscopeRotationSensor.lastTimestamp)) * 1.0E-9f;
                gyroscopeRotationSensor.lastTimestamp = sensorEvent.timestamp;
                float[] i3 = gyroscopeRotationSensor.i();
                i3[0] = i3[0] + (sensorEvent.values[0] * f16);
                float[] i16 = gyroscopeRotationSensor.i();
                i16[1] = i16[1] + (sensorEvent.values[1] * f16);
                float[] i17 = gyroscopeRotationSensor.i();
                i17[2] = i17[2] + (sensorEvent.values[2] * f16);
                gyroscopeRotationSensor.mOnRotationChangeListener.onChanged((float) Math.toDegrees(gyroscopeRotationSensor.i()[0]), (float) Math.toDegrees(gyroscopeRotationSensor.i()[1]), (float) Math.toDegrees(gyroscopeRotationSensor.i()[2]));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35974);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public GyroscopeRotationSensor(@NotNull final Context context, @NotNull b mOnRotationChangeListener) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mOnRotationChangeListener, "mOnRotationChangeListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) mOnRotationChangeListener);
            return;
        }
        this.mOnRotationChangeListener = mOnRotationChangeListener;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SensorManager>(context) { // from class: com.tencent.mobileqq.component.qrcode.utils.GyroscopeRotationSensor$sensorManager$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final SensorManager invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (SensorManager) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Object systemService = this.$context.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
                if (systemService instanceof SensorManager) {
                    return (SensorManager) systemService;
                }
                return null;
            }
        });
        this.sensorManager = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Sensor>() { // from class: com.tencent.mobileqq.component.qrcode.utils.GyroscopeRotationSensor$sensor$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GyroscopeRotationSensor.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Sensor invoke() {
                SensorManager l3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Sensor) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                l3 = GyroscopeRotationSensor.this.l();
                if (l3 != null) {
                    return SensorMonitor.getDefaultSensor(l3, 4);
                }
                return null;
            }
        });
        this.sensor = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(GyroscopeRotationSensor$handler$2.INSTANCE);
        this.handler = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.component.qrcode.utils.GyroscopeRotationSensor$sensorListener$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GyroscopeRotationSensor.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GyroscopeRotationSensor.c invoke() {
                GyroscopeRotationSensor.c g16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (GyroscopeRotationSensor.c) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                g16 = GyroscopeRotationSensor.this.g();
                return g16;
            }
        });
        this.sensorListener = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(GyroscopeRotationSensor$rotationVector$2.INSTANCE);
        this.rotationVector = lazy5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c g() {
        return new c();
    }

    private final Handler h() {
        return (Handler) this.handler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float[] i() {
        return (float[]) this.rotationVector.getValue();
    }

    private final Sensor j() {
        return (Sensor) this.sensor.getValue();
    }

    private final c k() {
        return (c) this.sensorListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SensorManager l() {
        return (SensorManager) this.sensorManager.getValue();
    }

    public final boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this._isRunning;
    }

    public final void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        i()[0] = 0.0f;
        i()[1] = 0.0f;
        i()[2] = 0.0f;
        this.lastTimestamp = 0L;
    }

    public final boolean o() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        SensorManager l3 = l();
        if (l3 != null) {
            z16 = SensorMonitor.registerListener(l3, k(), j(), 2, h());
        } else {
            z16 = false;
        }
        this._isRunning = z16;
        return m();
    }

    public final void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this._isRunning = false;
        SensorManager l3 = l();
        if (l3 != null) {
            l3.unregisterListener(k());
        }
    }
}
