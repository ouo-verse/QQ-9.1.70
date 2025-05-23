package com.tencent.biz.qqcircle.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Handler;
import com.tencent.avbiz.Constants;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$Entry;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007*\u0001\u001c\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u0004\u0018\u00010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0011R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/biz/qqcircle/sensor/c;", "", "Lcom/tencent/biz/qqcircle/sensor/PostureType;", "d", "", "c", "Landroid/hardware/SensorEvent;", "event", "", "g", "Lfeedcloud/FeedCloudCommon$Entry;", "e", "", "b", "Z", "enableSample", "", "I", "continuousSampleCount", "samplePeriodMs", "sportThreshold", "", "f", "J", "lastTimestamp", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "com/tencent/biz/qqcircle/sensor/c$b", h.F, "Lcom/tencent/biz/qqcircle/sensor/c$b;", "eventListener", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class c {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static long lastTimestamp;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f92294a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean enableSample = true;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int continuousSampleCount = 3;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int samplePeriodMs = 1000;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int sportThreshold = 1;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Handler handler = new Handler(ThreadManagerV2.getQQCommonThreadLooper());

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final b eventListener = new b();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f92302a;

        static {
            int[] iArr = new int[PostureType.values().length];
            try {
                iArr[PostureType.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PostureType.SPORT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PostureType.OTHER_STILL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PostureType.LYING_STILL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f92302a = iArr;
        }
    }

    c() {
    }

    private final String c() {
        String str;
        int i3 = a.f92302a[d().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        str = "\u9759\u6b62-\u8eba\u4e0b";
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    str = "\u9759\u6b62-\u5176\u4ed6";
                }
            } else {
                str = Constants.Business.QQ_HEALTH;
            }
        } else {
            str = "\u672a\u77e5";
        }
        return str + ", " + ((Object) null);
    }

    private final PostureType d() {
        return PostureType.UNKNOWN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        QCircleToast.v(QCircleToast.f91644d, f92294a.c(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(SensorEvent event) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastTimestamp < samplePeriodMs) {
            return;
        }
        lastTimestamp = currentTimeMillis;
        float[] fArr = event.values;
        new AccelerometerPoint(fArr[0], fArr[1], fArr[2]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final FeedCloudCommon$Entry e() {
        String str;
        PBStringField pBStringField;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        FeedCloudCommon$Entry feedCloudCommon$Entry = (FeedCloudCommon$Entry) objectRef.element;
        if (feedCloudCommon$Entry != null && (pBStringField = feedCloudCommon$Entry.value) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        QLog.d("PostureSensorManager", 1, "[getPostureEntry] value=" + str);
        if (com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_REQUEST_FEED_POSTURE, 0)) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.biz.qqcircle.sensor.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.f();
                }
            });
        }
        return (FeedCloudCommon$Entry) objectRef.element;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/biz/qqcircle/sensor/c$b", "Landroid/hardware/SensorEventListener;", "Landroid/hardware/SensorEvent;", "event", "", "onSensorChanged", "Landroid/hardware/Sensor;", WebRTCSDK.PRIVILEGE_SENSOR, "", "accuracy", "onAccuracyChanged", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class b implements SensorEventListener {
        b() {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(@Nullable SensorEvent event) {
            Integer num;
            Sensor sensor;
            if (event != null && (sensor = event.sensor) != null) {
                num = Integer.valueOf(sensor.getType());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 1) {
                c.f92294a.g(event);
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(@Nullable Sensor sensor, int accuracy) {
        }
    }
}
