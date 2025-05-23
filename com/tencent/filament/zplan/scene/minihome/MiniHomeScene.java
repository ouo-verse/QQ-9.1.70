package com.tencent.filament.zplan.scene.minihome;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.Surface;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.app.scene.BaseSceneV2308;
import com.tencent.filament.zplan.app.view.FilamentTextureViewV2305;
import com.tencent.filament.zplan.engine.FilamentMiniHome;
import com.tencent.filament.zplan.scene.minihome.MiniHomeScene;
import com.tencent.filament.zplan.view.event.TouchEvent;
import com.tencent.filament.zplan.view.event.TouchEventState;
import com.tencent.filament.zplan.view.event.TouchEventType;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentMiniHomeSceneUrlTemplate;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.zplan.zplantracing.c;
import dl0.g;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a3\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001d\u0018\u0000 o2\u00020\u00012\u00020\u0002:\u0001pB\u001f\u0012\b\u0010i\u001a\u0004\u0018\u00010h\u0012\f\u0010l\u001a\b\u0012\u0004\u0012\u00020k0j\u00a2\u0006\u0004\bm\u0010nJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J \u0010\f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J \u0010\r\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u001a\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\tH\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0002J\u0012\u0010\u001e\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J \u0010#\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\"H\u0002J\u0012\u0010$\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010%\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010&\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010'\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010(\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010)\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010*\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010+\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010,\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010-\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010.\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010/\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u00100\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u00101\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u00102\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u00103\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0018\u00107\u001a\u0002042\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u000204H\u0002J\b\u00108\u001a\u00020\u0003H\u0002R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010K\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010,R\u0016\u0010P\u001a\u00020L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010,R\u0016\u0010R\u001a\u00020L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010,R\u0016\u0010T\u001a\u00020L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010,R\u0016\u0010V\u001a\u00020L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010,R\u0016\u0010Y\u001a\u00020W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010BR\u0016\u0010[\u001a\u00020W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010BR\u0016\u0010_\u001a\u00020\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010a\u001a\u00020\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010^R\u0016\u0010c\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010OR\u0014\u0010g\u001a\u00020d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\be\u0010f\u00a8\u0006q"}, d2 = {"Lcom/tencent/filament/zplan/scene/minihome/MiniHomeScene;", "Lcom/tencent/filament/zplan/app/scene/BaseSceneV2308;", "Landroid/hardware/SensorEventListener;", "", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "Landroid/graphics/SurfaceTexture;", "surfaceTexture", "", "width", "height", ReportConstant.COSTREPORT_PREFIX, "u", "surface", "t", "", "totalTime", "frameTime", "d", "Landroid/hardware/SensorEvent;", "event", "onSensorChanged", "Landroid/hardware/Sensor;", WebRTCSDK.PRIVILEGE_SENSOR, "accuracy", "onAccuracyChanged", "d0", "", "data", "c0", "i0", "viewWidth", "viewHeight", "Landroid/view/Surface;", "V", "f0", "e0", "h0", "k0", "l0", "W", "m0", "a0", "Z", "X", "j0", "o0", "n0", "p0", "q0", "b0", "Lorg/json/JSONObject;", "json1", "json2", "g0", "Y", "Lcom/tencent/filament/zplan/engine/FilamentMiniHome;", "D", "Lcom/tencent/filament/zplan/engine/FilamentMiniHome;", "minihome", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "E", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "Lcom/tencent/filament/zplanservice/feature/model/FilamentMiniHomeSceneUrlTemplate;", UserInfo.SEX_FEMALE, "Lcom/tencent/filament/zplanservice/feature/model/FilamentMiniHomeSceneUrlTemplate;", "miniHomeSceneUrlTemplate", "Landroid/hardware/SensorManager;", "G", "Landroid/hardware/SensorManager;", "sensorManager", "H", "Landroid/hardware/Sensor;", "gyroSensor", "", "I", "disableSensorByTouch", "J", "enableGyroSensor", "K", "hasSeneorRegister", "L", "hasDestroy", "M", "enableTouchEvent", "", "N", "rotateX", "P", "rotateY", "Ljava/util/concurrent/atomic/AtomicBoolean;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasInitHome", BdhLogUtil.LogTag.Tag_Req, "hasSurface", ExifInterface.LATITUDE_SOUTH, "lastVsycTime", "com/tencent/filament/zplan/scene/minihome/MiniHomeScene$miniHomeEventUpdateCallback$1", "T", "Lcom/tencent/filament/zplan/scene/minihome/MiniHomeScene$miniHomeEventUpdateCallback$1;", "miniHomeEventUpdateCallback", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/app/impl/FilamentNativeAppV2305;", "app", "<init>", "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/ref/WeakReference;)V", "U", "Companion", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class MiniHomeScene extends BaseSceneV2308 implements SensorEventListener {

    /* renamed from: D, reason: from kotlin metadata */
    private FilamentMiniHome minihome;

    /* renamed from: E, reason: from kotlin metadata */
    private final FilamentUrlTemplate urlTemplate;

    /* renamed from: F, reason: from kotlin metadata */
    private final FilamentMiniHomeSceneUrlTemplate miniHomeSceneUrlTemplate;

    /* renamed from: G, reason: from kotlin metadata */
    private SensorManager sensorManager;

    /* renamed from: H, reason: from kotlin metadata */
    private Sensor gyroSensor;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean disableSensorByTouch;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean enableGyroSensor;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean hasSeneorRegister;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean hasDestroy;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean enableTouchEvent;

    /* renamed from: N, reason: from kotlin metadata */
    private float rotateX;

    /* renamed from: P, reason: from kotlin metadata */
    private float rotateY;

    /* renamed from: Q, reason: from kotlin metadata */
    private AtomicBoolean hasInitHome;

    /* renamed from: R, reason: from kotlin metadata */
    private AtomicBoolean hasSurface;

    /* renamed from: S, reason: from kotlin metadata */
    private long lastVsycTime;

    /* renamed from: T, reason: from kotlin metadata */
    private final MiniHomeScene$miniHomeEventUpdateCallback$1 miniHomeEventUpdateCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeScene(@Nullable c cVar, @NotNull WeakReference<FilamentNativeAppV2305> app) {
        super(cVar, app);
        final JSONObject jSONObject;
        sk0.a configuration;
        g qqmcProxy;
        sk0.a configuration2;
        Intrinsics.checkNotNullParameter(app, "app");
        FilamentNativeAppV2305 filamentNativeAppV2305 = app.get();
        FilamentUrlTemplate F = (filamentNativeAppV2305 == null || (configuration2 = filamentNativeAppV2305.getConfiguration()) == null || (F = configuration2.getUrlTemplate()) == null) ? FilamentFeatureUtil.f106409g.F() : F;
        this.urlTemplate = F;
        FilamentNativeAppV2305 filamentNativeAppV23052 = app.get();
        FilamentMiniHomeSceneUrlTemplate filamentMiniHomeSceneUrlTemplate = (filamentNativeAppV23052 == null || (configuration = filamentNativeAppV23052.getConfiguration()) == null || (qqmcProxy = configuration.getQqmcProxy()) == null || (filamentMiniHomeSceneUrlTemplate = qqmcProxy.c()) == null) ? new FilamentMiniHomeSceneUrlTemplate(null, 1, null) : filamentMiniHomeSceneUrlTemplate;
        this.miniHomeSceneUrlTemplate = filamentMiniHomeSceneUrlTemplate;
        this.enableTouchEvent = true;
        this.hasInitHome = new AtomicBoolean(false);
        this.hasSurface = new AtomicBoolean(false);
        this.lastVsycTime = System.nanoTime();
        this.miniHomeEventUpdateCallback = new MiniHomeScene$miniHomeEventUpdateCallback$1(this, app);
        try {
            jSONObject = g0(new JSONObject(new Gson().toJson(F)), new JSONObject(new Gson().toJson(filamentMiniHomeSceneUrlTemplate)));
        } catch (Throwable th5) {
            FLog.INSTANCE.e("MiniHomeScene", "init json error, " + th5);
            jSONObject = new JSONObject();
        }
        k().d(FilamentMiniHome.TAG, new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MiniHomeScene miniHomeScene = MiniHomeScene.this;
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                long id5 = currentThread.getId();
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "finalUrlTemplate.toString()");
                miniHomeScene.minihome = new FilamentMiniHome(id5, jSONObject2);
                FilamentMiniHome filamentMiniHome = MiniHomeScene.this.minihome;
                if (filamentMiniHome != null) {
                    filamentMiniHome.setMiniHomeEventUpdateCallback(MiniHomeScene.this.miniHomeEventUpdateCallback);
                }
            }
        });
        MiniHomeScene$eventListener$1 miniHomeScene$eventListener$1 = new MiniHomeScene$eventListener$1(this);
        FilamentNativeAppV2305 filamentNativeAppV23053 = app.get();
        if (filamentNativeAppV23053 != null) {
            filamentNativeAppV23053.addEventListener(Companion.EVENT.INIT_HOME.name(), miniHomeScene$eventListener$1);
        }
        if (filamentNativeAppV23053 != null) {
            filamentNativeAppV23053.addEventListener(Companion.EVENT.LOAD_ROOM.name(), miniHomeScene$eventListener$1);
        }
        if (filamentNativeAppV23053 != null) {
            filamentNativeAppV23053.addEventListener(Companion.EVENT.LOAD_AVATAR.name(), miniHomeScene$eventListener$1);
        }
        if (filamentNativeAppV23053 != null) {
            filamentNativeAppV23053.addEventListener(Companion.EVENT.RESET_ROOM_AND_AVATAR.name(), miniHomeScene$eventListener$1);
        }
        if (filamentNativeAppV23053 != null) {
            filamentNativeAppV23053.addEventListener(Companion.EVENT.RESET.name(), miniHomeScene$eventListener$1);
        }
        if (filamentNativeAppV23053 != null) {
            filamentNativeAppV23053.addEventListener(Companion.EVENT.SET_GYRO_ANGLE_LIMIT.name(), miniHomeScene$eventListener$1);
        }
        if (filamentNativeAppV23053 != null) {
            filamentNativeAppV23053.addEventListener(Companion.EVENT.ENABLE_GYRO_SENSOR.name(), miniHomeScene$eventListener$1);
        }
        if (filamentNativeAppV23053 != null) {
            filamentNativeAppV23053.addEventListener(Companion.EVENT.ENABLE_TOUCH_EVENT.name(), miniHomeScene$eventListener$1);
        }
        if (filamentNativeAppV23053 != null) {
            filamentNativeAppV23053.addEventListener(Companion.EVENT.SET_IS_NIGHT.name(), miniHomeScene$eventListener$1);
        }
        if (filamentNativeAppV23053 != null) {
            filamentNativeAppV23053.addEventListener(Companion.EVENT.REPLACE_DECORATE.name(), miniHomeScene$eventListener$1);
        }
        if (filamentNativeAppV23053 != null) {
            filamentNativeAppV23053.addEventListener(Companion.EVENT.SELECT_DECORATE.name(), miniHomeScene$eventListener$1);
        }
        if (filamentNativeAppV23053 != null) {
            filamentNativeAppV23053.addEventListener(Companion.EVENT.SELECT_DECORATE_RAYCAST.name(), miniHomeScene$eventListener$1);
        }
        if (filamentNativeAppV23053 != null) {
            filamentNativeAppV23053.addEventListener(Companion.EVENT.CANCEL_SELECT_DECORATE.name(), miniHomeScene$eventListener$1);
        }
        if (filamentNativeAppV23053 != null) {
            filamentNativeAppV23053.addEventListener(Companion.EVENT.SET_CAMERA_MODE.name(), miniHomeScene$eventListener$1);
        }
        if (filamentNativeAppV23053 != null) {
            filamentNativeAppV23053.addEventListener(Companion.EVENT.GET_ROOM_CONFIG.name(), miniHomeScene$eventListener$1);
        }
        if (filamentNativeAppV23053 != null) {
            filamentNativeAppV23053.addEventListener(Companion.EVENT.GET_DECORATE_POSITION.name(), miniHomeScene$eventListener$1);
        }
        if (filamentNativeAppV23053 != null) {
            filamentNativeAppV23053.addEventListener(Companion.EVENT.DELETE_DECORATE.name(), miniHomeScene$eventListener$1);
        }
        if (filamentNativeAppV23053 != null) {
            filamentNativeAppV23053.addEventListener(Companion.EVENT.ROTATE_DECORATE.name(), miniHomeScene$eventListener$1);
        }
        if (filamentNativeAppV23053 != null) {
            filamentNativeAppV23053.addEventListener("onTouchEvent", miniHomeScene$eventListener$1);
        }
        d0();
    }

    private final void V(final int viewWidth, final int viewHeight, final Surface surface) {
        if (this.hasDestroy) {
            return;
        }
        k().d("attach", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$attach$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AtomicBoolean atomicBoolean;
                FilamentMiniHome filamentMiniHome = MiniHomeScene.this.minihome;
                if (filamentMiniHome != null) {
                    filamentMiniHome.attach(viewWidth, viewHeight, surface);
                }
                atomicBoolean = MiniHomeScene.this.hasSurface;
                atomicBoolean.set(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(String data) {
        if (this.hasDestroy) {
            return;
        }
        FLog.INSTANCE.i("MiniHomeScene", "cancelSelectDecorate");
        k().d("cancelSelectDecorate", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$cancelSelectDecorate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FilamentMiniHome filamentMiniHome = MiniHomeScene.this.minihome;
                if (filamentMiniHome != null) {
                    filamentMiniHome.cancelSelectDecorate();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0030 A[Catch: all -> 0x0066, TryCatch #0 {all -> 0x0066, blocks: (B:3:0x0003, B:7:0x0008, B:9:0x0023, B:15:0x0030, B:17:0x004c, B:21:0x0056), top: B:2:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void X(String data) {
        boolean z16;
        try {
            if (this.hasDestroy) {
                return;
            }
            FLog.INSTANCE.i("MiniHomeScene", "deleteDecorate " + data);
            boolean z17 = false;
            if (data != null && data.length() != 0) {
                z16 = false;
                if (!z16) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(data);
                final int optInt = jSONObject.optInt(Companion.DATA.LOAD_INDEX.name(), -1);
                final String optString = jSONObject.optString(Companion.DATA.DECORATE_SLOT.name());
                if (optString == null || optString.length() == 0) {
                    z17 = true;
                }
                if (z17) {
                    return;
                }
                k().d("deleteDecorate", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$deleteDecorate$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        FilamentMiniHome filamentMiniHome;
                        if (optInt == -1 || (filamentMiniHome = MiniHomeScene.this.minihome) == null) {
                            return;
                        }
                        filamentMiniHome.deleteDecorate(optString, new IMiniHomeMessageCallback() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$deleteDecorate$1.1
                            @Override // com.tencent.filament.zplan.scene.minihome.IMiniHomeMessageCallback
                            public void onMiniHomeMessage(@Nullable String dataJson) {
                                FLog.INSTANCE.i("MiniHomeScene", "deleteDecorate onMiniHomeMessage " + dataJson);
                                FilamentNativeAppV2305 filamentNativeAppV2305 = MiniHomeScene.this.j().get();
                                if (filamentNativeAppV2305 != null) {
                                    String name = MiniHomeScene.Companion.EVENT.DELETE_DECORATE_CALLBACK.name();
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put(MiniHomeScene.Companion.DATA.LOAD_INDEX.name(), optInt);
                                    if (dataJson != null) {
                                        jSONObject2.put(MiniHomeScene.Companion.DATA.DELETE_DECORATE_CALLBACK_DATA.name(), dataJson);
                                    }
                                    Unit unit = Unit.INSTANCE;
                                    filamentNativeAppV2305.dispatchEvent(null, name, jSONObject2.toString());
                                }
                            }
                        });
                    }
                });
                return;
            }
            z16 = true;
            if (!z16) {
            }
        } catch (Throwable th5) {
            FLog.INSTANCE.e("MiniHomeScene", "deleteDecorate error, " + th5);
        }
    }

    private final void Y() {
        FLog.INSTANCE.e("MiniHomeScene", "flushAndWait");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        k().d("flushAndWait", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$flushAndWait$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FilamentMiniHome filamentMiniHome = MiniHomeScene.this.minihome;
                if (filamentMiniHome != null) {
                    filamentMiniHome.flushAndWait(new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$flushAndWait$1.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            FLog.INSTANCE.e("MiniHomeScene", "flushAndWait callback");
                            countDownLatch.countDown();
                        }
                    });
                }
            }
        });
        countDownLatch.await(FilamentFeatureUtil.f106409g.r().getSurfaceDestroyTimeout(), TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f A[Catch: all -> 0x003c, TRY_LEAVE, TryCatch #0 {all -> 0x003c, blocks: (B:3:0x0006, B:7:0x000b, B:9:0x0012, B:15:0x001f), top: B:2:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Z(String data) {
        boolean z16;
        try {
            if (this.hasDestroy) {
                return;
            }
            FLog.INSTANCE.i("MiniHomeScene", "getDecoratePosition");
            if (data != null && data.length() != 0) {
                z16 = false;
                if (!z16) {
                    return;
                }
                final int optInt = new JSONObject(data).optInt(Companion.DATA.LOAD_INDEX.name(), -1);
                k().d("getDecoratePosition", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$getDecoratePosition$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        FilamentMiniHome filamentMiniHome;
                        if (optInt == -1 || (filamentMiniHome = MiniHomeScene.this.minihome) == null) {
                            return;
                        }
                        filamentMiniHome.getDecorateScreenPosition(new IMiniHomeMessageCallback() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$getDecoratePosition$1.1
                            @Override // com.tencent.filament.zplan.scene.minihome.IMiniHomeMessageCallback
                            public void onMiniHomeMessage(@Nullable String dataJson) {
                                FLog.INSTANCE.i("MiniHomeScene", "getDecoratePosition onMiniHomeMessage " + dataJson);
                                FilamentNativeAppV2305 filamentNativeAppV2305 = MiniHomeScene.this.j().get();
                                if (filamentNativeAppV2305 != null) {
                                    String name = MiniHomeScene.Companion.EVENT.GET_DECORATE_POSITION_CALLBACK.name();
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put(MiniHomeScene.Companion.DATA.LOAD_INDEX.name(), optInt);
                                    if (dataJson != null) {
                                        jSONObject.put(MiniHomeScene.Companion.DATA.GET_DECORATE_POSITION_DATA.name(), dataJson);
                                    }
                                    Unit unit = Unit.INSTANCE;
                                    filamentNativeAppV2305.dispatchEvent(null, name, jSONObject.toString());
                                }
                            }
                        });
                    }
                });
                return;
            }
            z16 = true;
            if (!z16) {
            }
        } catch (Throwable th5) {
            FLog.INSTANCE.e("MiniHomeScene", "getDecoratePosition error, " + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0020 A[Catch: all -> 0x0047, TRY_LEAVE, TryCatch #0 {all -> 0x0047, blocks: (B:3:0x0006, B:7:0x000b, B:9:0x0013, B:15:0x0020), top: B:2:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a0(String data) {
        boolean z16;
        try {
            if (this.hasDestroy) {
                return;
            }
            FLog.INSTANCE.i("MiniHomeScene", "getRoomConfig");
            if (data != null && data.length() != 0) {
                z16 = false;
                if (!z16) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(data);
                final int optInt = jSONObject.optInt(Companion.DATA.LOAD_INDEX.name(), -1);
                final boolean optBoolean = jSONObject.optBoolean(Companion.DATA.NEED_ROOM_JSON_DATA.name(), false);
                k().d("getRoomConfig", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$getRoomConfig$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        FilamentMiniHome filamentMiniHome;
                        if (optInt == -1 || (filamentMiniHome = MiniHomeScene.this.minihome) == null) {
                            return;
                        }
                        filamentMiniHome.getRoomConfig(optBoolean, new IMiniHomeMessageCallback() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$getRoomConfig$1.1
                            @Override // com.tencent.filament.zplan.scene.minihome.IMiniHomeMessageCallback
                            public void onMiniHomeMessage(@Nullable String dataJson) {
                                FLog.INSTANCE.i("MiniHomeScene", "getRoomConfig onMiniHomeMessage " + dataJson);
                                FilamentNativeAppV2305 filamentNativeAppV2305 = MiniHomeScene.this.j().get();
                                if (filamentNativeAppV2305 != null) {
                                    String name = MiniHomeScene.Companion.EVENT.GET_ROOM_CONFIG_CALLBACK.name();
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put(MiniHomeScene.Companion.DATA.LOAD_INDEX.name(), optInt);
                                    if (dataJson != null) {
                                        jSONObject2.put(MiniHomeScene.Companion.DATA.GET_ROOM_CONFIG_DATA.name(), dataJson);
                                    }
                                    Unit unit = Unit.INSTANCE;
                                    filamentNativeAppV2305.dispatchEvent(null, name, jSONObject2.toString());
                                }
                            }
                        });
                    }
                });
                return;
            }
            z16 = true;
            if (!z16) {
            }
        } catch (Throwable th5) {
            FLog.INSTANCE.e("MiniHomeScene", "getRoomConfig error, " + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(String data) {
        boolean z16;
        if (this.hasDestroy || !this.enableTouchEvent) {
            return;
        }
        try {
            TouchEvent touchEvent = (TouchEvent) new Gson().fromJson(data, TouchEvent.class);
            FLog.INSTANCE.i("MiniHomeScene", String.valueOf(touchEvent.getState()));
            boolean z17 = true;
            if (touchEvent.getTouchCount() == 1) {
                if (touchEvent.getState() == TouchEventState.Began) {
                    this.rotateX = touchEvent.getLocation().x;
                    this.rotateY = touchEvent.getLocation().y;
                }
                if (touchEvent.getState() == TouchEventState.Changed && touchEvent.getType() == TouchEventType.Pan) {
                    this.disableSensorByTouch = true;
                    final Ref.FloatRef floatRef = new Ref.FloatRef();
                    floatRef.element = 0.0f;
                    final Ref.FloatRef floatRef2 = new Ref.FloatRef();
                    floatRef2.element = 0.0f;
                    if (this.rotateX != 0.0f) {
                        floatRef.element = touchEvent.getLocation().x - this.rotateX;
                        this.rotateX = touchEvent.getLocation().x;
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (this.rotateY != 0.0f) {
                        floatRef2.element = touchEvent.getLocation().y - this.rotateY;
                        this.rotateY = touchEvent.getLocation().y;
                    } else {
                        z17 = z16;
                    }
                    if (z17) {
                        k().d("setGyroEuler", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$handleTouchEvent$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                FilamentMiniHome filamentMiniHome;
                                if (Math.abs(floatRef.element) > Math.abs(floatRef2.element)) {
                                    FilamentMiniHome filamentMiniHome2 = MiniHomeScene.this.minihome;
                                    if (filamentMiniHome2 != null) {
                                        filamentMiniHome2.setGyroEuler(0.0f, 0.0f, floatRef.element * 0.001f);
                                        return;
                                    }
                                    return;
                                }
                                if (Math.abs(floatRef2.element) <= Math.abs(floatRef.element) || (filamentMiniHome = MiniHomeScene.this.minihome) == null) {
                                    return;
                                }
                                filamentMiniHome.setGyroEuler(0.0f, floatRef2.element * 0.001f, 0.0f);
                            }
                        });
                    }
                }
                if (touchEvent.getState() == TouchEventState.Ended) {
                    this.disableSensorByTouch = false;
                    this.rotateX = 0.0f;
                    this.rotateY = 0.0f;
                }
            }
        } catch (Exception e16) {
            FLog.INSTANCE.e("MiniHomeScene", "process this event error", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0(String data) {
        if (this.hasInitHome.get() || this.hasDestroy) {
            return;
        }
        FLog.INSTANCE.i("MiniHomeScene", "initMiniHome data: " + data);
        k().d("initMiniHome", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$initMiniHome$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AtomicBoolean atomicBoolean;
                FilamentMiniHome filamentMiniHome = MiniHomeScene.this.minihome;
                if (filamentMiniHome != null) {
                    filamentMiniHome.initV2();
                }
                atomicBoolean = MiniHomeScene.this.hasInitHome;
                atomicBoolean.set(true);
            }
        });
        k().d("setErrorCallback", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$initMiniHome$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/filament/zplan/scene/minihome/MiniHomeScene$initMiniHome$2$a", "Lcom/tencent/filament/zplan/engine/FilamentMiniHome$b;", "", "errMsg", "", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
            /* loaded from: classes6.dex */
            public static final class a implements FilamentMiniHome.b {
                a() {
                }

                @Override // com.tencent.filament.zplan.engine.FilamentMiniHome.b
                public void a(@Nullable String errMsg) {
                    FLog.INSTANCE.i("MiniHomeScene", "onErrorCallback " + errMsg);
                    FilamentNativeAppV2305 filamentNativeAppV2305 = MiniHomeScene.this.j().get();
                    if (filamentNativeAppV2305 != null) {
                        filamentNativeAppV2305.dispatchEvent(null, "onErrorCallback", errMsg);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FilamentMiniHome filamentMiniHome = MiniHomeScene.this.minihome;
                if (filamentMiniHome != null) {
                    filamentMiniHome.setErrorCallback(new a());
                }
            }
        });
    }

    private final void d0() {
        Object obj;
        sk0.a configuration;
        Context viewContext;
        if (this.enableGyroSensor) {
            if (this.sensorManager == null || this.gyroSensor == null) {
                FilamentNativeAppV2305 filamentNativeAppV2305 = j().get();
                if (filamentNativeAppV2305 != null && (configuration = filamentNativeAppV2305.getConfiguration()) != null && (viewContext = configuration.getViewContext()) != null) {
                    obj = viewContext.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
                } else {
                    obj = null;
                }
                if (obj != null) {
                    SensorManager sensorManager = (SensorManager) obj;
                    this.sensorManager = sensorManager;
                    this.gyroSensor = SensorMonitor.getDefaultSensor(sensorManager, 4);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.hardware.SensorManager");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0030 A[Catch: all -> 0x0066, TryCatch #0 {all -> 0x0066, blocks: (B:3:0x0003, B:7:0x0008, B:9:0x0023, B:15:0x0030, B:17:0x0041, B:21:0x004b), top: B:2:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e0(String data) {
        boolean z16;
        try {
            if (this.hasDestroy) {
                return;
            }
            FLog.INSTANCE.i("MiniHomeScene", "loadAvatar data: " + data);
            boolean z17 = false;
            if (data != null && data.length() != 0) {
                z16 = false;
                if (!z16) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(data);
                final String optString = jSONObject.optString(Companion.DATA.AVATAR_INFO.name());
                if (optString == null || optString.length() == 0) {
                    z17 = true;
                }
                if (z17) {
                    return;
                }
                final int optInt = jSONObject.optInt(Companion.DATA.LOAD_INDEX.name(), -1);
                k().d("setControlledAvatar", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$loadAvatar$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        if (optInt == -1) {
                            FilamentMiniHome filamentMiniHome = MiniHomeScene.this.minihome;
                            if (filamentMiniHome != null) {
                                FilamentMiniHome.setControlledAvatar$default(filamentMiniHome, optString.toString(), null, 2, null);
                                return;
                            }
                            return;
                        }
                        FilamentMiniHome filamentMiniHome2 = MiniHomeScene.this.minihome;
                        if (filamentMiniHome2 != null) {
                            filamentMiniHome2.setControlledAvatar(optString.toString(), new IMiniHomeLoadCallback() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$loadAvatar$1.1
                                @Override // com.tencent.filament.zplan.scene.minihome.IMiniHomeLoadCallback
                                public void onMiniHomeLoadResult(boolean success, @Nullable String dataJson) {
                                    FLog.INSTANCE.i("MiniHomeScene", "loadAvatar onMiniHomeLoadResult " + success + ", " + dataJson);
                                    FilamentNativeAppV2305 filamentNativeAppV2305 = MiniHomeScene.this.j().get();
                                    if (filamentNativeAppV2305 != null) {
                                        String name = MiniHomeScene.Companion.EVENT.LOAD_AVATAR_CALLBACK.name();
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put(MiniHomeScene.Companion.DATA.LOAD_INDEX.name(), optInt);
                                        jSONObject2.put(MiniHomeScene.Companion.DATA.LOAD_CALLBACK_RESULT.name(), success);
                                        if (dataJson != null) {
                                            jSONObject2.put(MiniHomeScene.Companion.DATA.LOAD_CALLBACK_DATA.name(), dataJson);
                                        }
                                        Unit unit = Unit.INSTANCE;
                                        filamentNativeAppV2305.dispatchEvent(null, name, jSONObject2.toString());
                                    }
                                }
                            });
                        }
                    }
                });
                return;
            }
            z16 = true;
            if (!z16) {
            }
        } catch (Throwable th5) {
            FLog.INSTANCE.e("MiniHomeScene", "loadRoom error, " + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0030 A[Catch: all -> 0x0066, TryCatch #0 {all -> 0x0066, blocks: (B:3:0x0003, B:7:0x0008, B:9:0x0023, B:15:0x0030, B:17:0x0041, B:21:0x004b), top: B:2:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f0(String data) {
        boolean z16;
        try {
            if (this.hasDestroy) {
                return;
            }
            FLog.INSTANCE.i("MiniHomeScene", "loadRoom data: " + data);
            boolean z17 = false;
            if (data != null && data.length() != 0) {
                z16 = false;
                if (!z16) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(data);
                final String optString = jSONObject.optString(Companion.DATA.ROOM_JSON.name());
                if (optString == null || optString.length() == 0) {
                    z17 = true;
                }
                if (z17) {
                    return;
                }
                final int optInt = jSONObject.optInt(Companion.DATA.LOAD_INDEX.name(), -1);
                k().d("loadUserRoom", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$loadRoom$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        if (optInt == -1) {
                            FilamentMiniHome filamentMiniHome = MiniHomeScene.this.minihome;
                            if (filamentMiniHome != null) {
                                FilamentMiniHome.loadUserRoom$default(filamentMiniHome, optString.toString(), null, 2, null);
                                return;
                            }
                            return;
                        }
                        FilamentMiniHome filamentMiniHome2 = MiniHomeScene.this.minihome;
                        if (filamentMiniHome2 != null) {
                            filamentMiniHome2.loadUserRoom(optString.toString(), new IMiniHomeLoadCallback() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$loadRoom$1.1
                                @Override // com.tencent.filament.zplan.scene.minihome.IMiniHomeLoadCallback
                                public void onMiniHomeLoadResult(boolean success, @Nullable String dataJson) {
                                    FLog.INSTANCE.i("MiniHomeScene", "loadRoom onMiniHomeLoadResult " + success + ", " + dataJson);
                                    FilamentNativeAppV2305 filamentNativeAppV2305 = MiniHomeScene.this.j().get();
                                    if (filamentNativeAppV2305 != null) {
                                        String name = MiniHomeScene.Companion.EVENT.LOAD_ROOM_CALLBACK.name();
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put(MiniHomeScene.Companion.DATA.LOAD_INDEX.name(), optInt);
                                        jSONObject2.put(MiniHomeScene.Companion.DATA.LOAD_CALLBACK_RESULT.name(), success);
                                        if (dataJson != null) {
                                            jSONObject2.put(MiniHomeScene.Companion.DATA.LOAD_CALLBACK_DATA.name(), dataJson);
                                        }
                                        Unit unit = Unit.INSTANCE;
                                        filamentNativeAppV2305.dispatchEvent(null, name, jSONObject2.toString());
                                    }
                                }
                            });
                        }
                    }
                });
                return;
            }
            z16 = true;
            if (!z16) {
            }
        } catch (Throwable th5) {
            FLog.INSTANCE.e("MiniHomeScene", "loadRoom error, " + th5);
        }
    }

    private final JSONObject g0(JSONObject json1, JSONObject json2) {
        JSONObject jSONObject = new JSONObject();
        Iterator keys = json1.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "json1.keys()");
        while (keys.hasNext()) {
            String str = (String) keys.next();
            jSONObject.put(str, json1.get(str));
        }
        Iterator keys2 = json2.keys();
        Intrinsics.checkNotNullExpressionValue(keys2, "json2.keys()");
        while (keys2.hasNext()) {
            String str2 = (String) keys2.next();
            jSONObject.put(str2, json2.get(str2));
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0030 A[Catch: all -> 0x007f, TryCatch #0 {all -> 0x007f, blocks: (B:3:0x0003, B:7:0x0008, B:9:0x0023, B:15:0x0030, B:17:0x004b, B:23:0x0059, B:28:0x0063), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007e A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h0(String data) {
        boolean z16;
        boolean z17;
        try {
            if (this.hasDestroy) {
                return;
            }
            FLog.INSTANCE.i("MiniHomeScene", "replaceDecorate data: " + data);
            boolean z18 = false;
            if (data != null && data.length() != 0) {
                z16 = false;
                if (!z16) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(data);
                final String optString = jSONObject.optString(Companion.DATA.DECORATE_SLOT.name());
                final String optString2 = jSONObject.optString(Companion.DATA.DECORATE_JSON_DATA.name());
                if (optString != null && optString.length() != 0) {
                    z17 = false;
                    if (z17) {
                        if (optString2 == null || optString2.length() == 0) {
                            z18 = true;
                        }
                        if (!z18) {
                            final int optInt = jSONObject.optInt(Companion.DATA.LOAD_INDEX.name(), -1);
                            k().d("replaceDecorate", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$replaceDecorate$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    if (optInt == -1) {
                                        FilamentMiniHome filamentMiniHome = MiniHomeScene.this.minihome;
                                        if (filamentMiniHome != null) {
                                            FilamentMiniHome.replaceDecorate$default(filamentMiniHome, optString, optString2, null, 4, null);
                                            return;
                                        }
                                        return;
                                    }
                                    FilamentMiniHome filamentMiniHome2 = MiniHomeScene.this.minihome;
                                    if (filamentMiniHome2 != null) {
                                        filamentMiniHome2.replaceDecorate(optString, optString2, new IMiniHomeMessageCallback() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$replaceDecorate$1.1
                                            @Override // com.tencent.filament.zplan.scene.minihome.IMiniHomeMessageCallback
                                            public void onMiniHomeMessage(@Nullable String dataJson) {
                                                FLog.INSTANCE.i("MiniHomeScene", "replaceDecorate onMiniHomeMessage " + dataJson);
                                                FilamentNativeAppV2305 filamentNativeAppV2305 = MiniHomeScene.this.j().get();
                                                if (filamentNativeAppV2305 != null) {
                                                    String name = MiniHomeScene.Companion.EVENT.REPLACE_DECORATE_CALLBACK.name();
                                                    JSONObject jSONObject2 = new JSONObject();
                                                    jSONObject2.put(MiniHomeScene.Companion.DATA.LOAD_INDEX.name(), optInt);
                                                    if (dataJson != null) {
                                                        jSONObject2.put(MiniHomeScene.Companion.DATA.REPLACE_CALLBACK_DATA.name(), dataJson);
                                                    }
                                                    Unit unit = Unit.INSTANCE;
                                                    filamentNativeAppV2305.dispatchEvent(null, name, jSONObject2.toString());
                                                }
                                            }
                                        });
                                    }
                                }
                            });
                            return;
                        }
                        return;
                    }
                    return;
                }
                z17 = true;
                if (z17) {
                }
            }
            z16 = true;
            if (!z16) {
            }
        } catch (Throwable th5) {
            FLog.INSTANCE.e("MiniHomeScene", "replaceDecorate error, " + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(String data) {
        boolean z16;
        final JSONObject jSONObject;
        if (this.hasDestroy) {
            return;
        }
        FLog.INSTANCE.i("MiniHomeScene", "resetMiniHome data: " + data);
        if (data != null && data.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            jSONObject = new JSONObject();
        } else {
            jSONObject = new JSONObject(data);
        }
        k().d("resetRoomAndAvatar", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$resetRoomAndAvatar$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FilamentMiniHome filamentMiniHome;
                FilamentMiniHome filamentMiniHome2 = MiniHomeScene.this.minihome;
                if (filamentMiniHome2 != null) {
                    filamentMiniHome2.resetRoomAndAvatar();
                }
                int optInt = jSONObject.optInt(MiniHomeScene.Companion.DATA.FIRST_FRAME_TYPE.name(), 1);
                if (optInt != 0 && (filamentMiniHome = MiniHomeScene.this.minihome) != null) {
                    filamentMiniHome.setReadPixelsCallback(optInt);
                }
                FilamentMiniHome filamentMiniHome3 = MiniHomeScene.this.minihome;
                if (filamentMiniHome3 != null) {
                    filamentMiniHome3.setStartUpTimeStatCallback();
                }
                FilamentMiniHome filamentMiniHome4 = MiniHomeScene.this.minihome;
                if (filamentMiniHome4 != null) {
                    filamentMiniHome4.setErrorCallback();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0030 A[Catch: all -> 0x0066, TryCatch #0 {all -> 0x0066, blocks: (B:3:0x0003, B:7:0x0008, B:9:0x0023, B:15:0x0030, B:17:0x004c, B:21:0x0056), top: B:2:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j0(String data) {
        boolean z16;
        try {
            if (this.hasDestroy) {
                return;
            }
            FLog.INSTANCE.i("MiniHomeScene", "rotateDecorate " + data);
            boolean z17 = false;
            if (data != null && data.length() != 0) {
                z16 = false;
                if (!z16) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(data);
                final int optInt = jSONObject.optInt(Companion.DATA.LOAD_INDEX.name(), -1);
                final String optString = jSONObject.optString(Companion.DATA.DECORATE_SLOT.name());
                if (optString == null || optString.length() == 0) {
                    z17 = true;
                }
                if (z17) {
                    return;
                }
                k().d("rotateDecorate", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$rotateDecorate$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        FilamentMiniHome filamentMiniHome;
                        if (optInt == -1 || (filamentMiniHome = MiniHomeScene.this.minihome) == null) {
                            return;
                        }
                        filamentMiniHome.rotateDecorate(optString, new IMiniHomeMessageCallback() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$rotateDecorate$1.1
                            @Override // com.tencent.filament.zplan.scene.minihome.IMiniHomeMessageCallback
                            public void onMiniHomeMessage(@Nullable String dataJson) {
                                FLog.INSTANCE.i("MiniHomeScene", "rotateDecorate onMiniHomeMessage " + dataJson);
                                FilamentNativeAppV2305 filamentNativeAppV2305 = MiniHomeScene.this.j().get();
                                if (filamentNativeAppV2305 != null) {
                                    String name = MiniHomeScene.Companion.EVENT.ROTATE_DECORATE_CALLBACK.name();
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put(MiniHomeScene.Companion.DATA.LOAD_INDEX.name(), optInt);
                                    if (dataJson != null) {
                                        jSONObject2.put(MiniHomeScene.Companion.DATA.ROTATE_DECORATE_CALLBACK_DATA.name(), dataJson);
                                    }
                                    Unit unit = Unit.INSTANCE;
                                    filamentNativeAppV2305.dispatchEvent(null, name, jSONObject2.toString());
                                }
                            }
                        });
                    }
                });
                return;
            }
            z16 = true;
            if (!z16) {
            }
        } catch (Throwable th5) {
            FLog.INSTANCE.e("MiniHomeScene", "rotateDecorate error, " + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0030 A[Catch: all -> 0x0066, TryCatch #0 {all -> 0x0066, blocks: (B:3:0x0003, B:7:0x0008, B:9:0x0023, B:15:0x0030, B:17:0x0041, B:21:0x004b), top: B:2:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k0(String data) {
        boolean z16;
        try {
            if (this.hasDestroy) {
                return;
            }
            FLog.INSTANCE.i("MiniHomeScene", "selectDecorate data: " + data);
            boolean z17 = false;
            if (data != null && data.length() != 0) {
                z16 = false;
                if (!z16) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(data);
                final String optString = jSONObject.optString(Companion.DATA.DECORATE_SLOT.name());
                if (optString == null || optString.length() == 0) {
                    z17 = true;
                }
                if (z17) {
                    return;
                }
                final int optInt = jSONObject.optInt(Companion.DATA.LOAD_INDEX.name(), -1);
                k().d("selectDecorate", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$selectDecorate$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        FilamentMiniHome filamentMiniHome;
                        if (optInt == -1 || (filamentMiniHome = MiniHomeScene.this.minihome) == null) {
                            return;
                        }
                        filamentMiniHome.selectDecorate(optString, new IMiniHomeMessageCallback() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$selectDecorate$1.1
                            @Override // com.tencent.filament.zplan.scene.minihome.IMiniHomeMessageCallback
                            public void onMiniHomeMessage(@Nullable String dataJson) {
                                FLog.INSTANCE.i("MiniHomeScene", "selectDecorate onMiniHomeMessage " + dataJson);
                                FilamentNativeAppV2305 filamentNativeAppV2305 = MiniHomeScene.this.j().get();
                                if (filamentNativeAppV2305 != null) {
                                    String name = MiniHomeScene.Companion.EVENT.SELECT_DECORATE_CALLBACK.name();
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put(MiniHomeScene.Companion.DATA.LOAD_INDEX.name(), optInt);
                                    if (dataJson != null) {
                                        jSONObject2.put(MiniHomeScene.Companion.DATA.SELECT_DECORATE_CALLBACK_DATA.name(), dataJson);
                                    }
                                    Unit unit = Unit.INSTANCE;
                                    filamentNativeAppV2305.dispatchEvent(null, name, jSONObject2.toString());
                                }
                            }
                        });
                    }
                });
                return;
            }
            z16 = true;
            if (!z16) {
            }
        } catch (Throwable th5) {
            FLog.INSTANCE.e("MiniHomeScene", "selectDecorate error, " + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002e A[Catch: all -> 0x0062, TRY_LEAVE, TryCatch #0 {all -> 0x0062, blocks: (B:3:0x0003, B:7:0x0008, B:9:0x0021, B:15:0x002e), top: B:2:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l0(String data) {
        boolean z16;
        try {
            if (this.hasDestroy) {
                return;
            }
            FLog.INSTANCE.i("MiniHomeScene", "selectDecorate data: " + data);
            if (data != null && data.length() != 0) {
                z16 = false;
                if (!z16) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(data);
                final int optInt = jSONObject.optInt(Companion.DATA.DECORATE_RAYCAST_VIEWPORT_X.name());
                final int optInt2 = jSONObject.optInt(Companion.DATA.DECORATE_RAYCAST_VIEWPORT_Y.name());
                final int optInt3 = jSONObject.optInt(Companion.DATA.LOAD_INDEX.name(), -1);
                k().d("selectDecorateRaycast", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$selectDecorateRaycast$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        FilamentMiniHome filamentMiniHome;
                        if (optInt3 == -1 || (filamentMiniHome = MiniHomeScene.this.minihome) == null) {
                            return;
                        }
                        filamentMiniHome.selectDecorateRaycast(optInt, optInt2, new IMiniHomeMessageCallback() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$selectDecorateRaycast$1.1
                            @Override // com.tencent.filament.zplan.scene.minihome.IMiniHomeMessageCallback
                            public void onMiniHomeMessage(@Nullable String dataJson) {
                                FLog.INSTANCE.i("MiniHomeScene", "selectDecorateRaycast onMiniHomeMessage " + dataJson);
                                FilamentNativeAppV2305 filamentNativeAppV2305 = MiniHomeScene.this.j().get();
                                if (filamentNativeAppV2305 != null) {
                                    String name = MiniHomeScene.Companion.EVENT.SELECT_DECORATE_RAYCAST_CALLBACK.name();
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put(MiniHomeScene.Companion.DATA.LOAD_INDEX.name(), optInt3);
                                    if (dataJson != null) {
                                        jSONObject2.put(MiniHomeScene.Companion.DATA.SELECT_DECORATE_CALLBACK_DATA.name(), dataJson);
                                    }
                                    Unit unit = Unit.INSTANCE;
                                    filamentNativeAppV2305.dispatchEvent(null, name, jSONObject2.toString());
                                }
                            }
                        });
                    }
                });
                return;
            }
            z16 = true;
            if (!z16) {
            }
        } catch (Throwable th5) {
            FLog.INSTANCE.e("MiniHomeScene", "selectDecorateRaycast error, " + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(String data) {
        boolean z16;
        if (this.hasDestroy) {
            return;
        }
        FLog.INSTANCE.i("MiniHomeScene", "setCameraMode data: " + data);
        if (data != null && data.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        final int optInt = new JSONObject(data).optInt(Companion.DATA.CAMERA_MODE.name(), Companion.CAMERAMODE.NORMAL.getValue());
        k().d("setCameraMode", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$setCameraMode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FilamentMiniHome filamentMiniHome = MiniHomeScene.this.minihome;
                if (filamentMiniHome != null) {
                    filamentMiniHome.setCameraMode(optInt);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(String data) {
        boolean z16;
        boolean z17;
        if (this.hasDestroy) {
            return;
        }
        FLog.INSTANCE.i("MiniHomeScene", "setGyroAngleLimit data: " + data);
        boolean z18 = false;
        if (data != null && data.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        final String optString = new JSONObject(data).optString(Companion.DATA.GYRO_ANGLE_LIMIT_PITCH.name());
        final String optString2 = new JSONObject(data).optString(Companion.DATA.GYRO_ANGLE_LIMIT_YAW.name());
        if (optString != null && optString.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z17) {
            if (optString2 == null || optString2.length() == 0) {
                z18 = true;
            }
            if (!z18) {
                k().d("setGyroAngleLimit", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$setGyroAngleLimit$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        FilamentMiniHome filamentMiniHome = MiniHomeScene.this.minihome;
                        if (filamentMiniHome != null) {
                            filamentMiniHome.setGyroAngleLimit(Float.parseFloat(optString), Float.parseFloat(optString2));
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0(String data) {
        boolean z16;
        if (this.hasDestroy) {
            return;
        }
        FLog.INSTANCE.i("MiniHomeScene", "setIsNight data: " + data);
        if (data != null && data.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        final boolean optBoolean = new JSONObject(data).optBoolean(Companion.DATA.IS_NIGHT.name());
        k().d("setIsNight", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$setIsNight$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FilamentMiniHome filamentMiniHome = MiniHomeScene.this.minihome;
                if (filamentMiniHome != null) {
                    filamentMiniHome.toggleNight(optBoolean);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0(String data) {
        boolean z16;
        if (this.hasDestroy) {
            return;
        }
        FLog.INSTANCE.i("MiniHomeScene", "updateGyroSensor data: " + data);
        if (data != null && data.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        boolean optBoolean = new JSONObject(data).optBoolean(Companion.DATA.ENABLE_GYRO_SENSOR.name(), false);
        this.enableGyroSensor = optBoolean;
        if (optBoolean) {
            d0();
            if (!this.hasSeneorRegister) {
                SensorManager sensorManager = this.sensorManager;
                if (sensorManager != null) {
                    SensorMonitor.registerListener(sensorManager, this, this.gyroSensor, 1);
                }
                this.hasSeneorRegister = true;
                return;
            }
            return;
        }
        SensorManager sensorManager2 = this.sensorManager;
        if (sensorManager2 != null) {
            sensorManager2.unregisterListener(this);
        }
        this.hasSeneorRegister = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(String data) {
        boolean z16;
        if (this.hasDestroy) {
            return;
        }
        FLog.INSTANCE.i("MiniHomeScene", "updateEnableTouchEvent data: " + data);
        if (data != null && data.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        this.enableTouchEvent = new JSONObject(data).optBoolean(Companion.DATA.ENABLE_TOUCH_EVENT.name(), false);
    }

    @Override // com.tencent.filament.zplan.util.vsync.b
    public void d(long totalTime, long frameTime) {
        if (!this.hasSurface.get()) {
            return;
        }
        long nanoTime = System.nanoTime();
        float f16 = ((float) (nanoTime - this.lastVsycTime)) / 1.0E9f;
        this.lastVsycTime = nanoTime;
        FilamentMiniHome filamentMiniHome = this.minihome;
        if (filamentMiniHome != null) {
            filamentMiniHome.update(f16);
        }
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void n() {
        final FilamentNativeAppV2305 filamentNativeAppV2305;
        super.n();
        this.hasDestroy = true;
        SensorManager sensorManager = this.sensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        this.hasSeneorRegister = false;
        FilamentFeatureUtil filamentFeatureUtil = FilamentFeatureUtil.f106409g;
        long sceneDestroyDelayTimeMillis = filamentFeatureUtil.D().getSceneDestroyDelayTimeMillis();
        if (filamentFeatureUtil.n()) {
            filamentNativeAppV2305 = j().get();
        } else {
            filamentNativeAppV2305 = null;
        }
        k().g(MosaicConstants$JsFunction.FUNC_ON_DESTROY, sceneDestroyDelayTimeMillis, new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$onDestroy$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FilamentTextureViewV2305 a16;
                FilamentMiniHome filamentMiniHome = MiniHomeScene.this.minihome;
                if (filamentMiniHome != null) {
                    filamentMiniHome.destroy();
                }
                MiniHomeScene.this.minihome = null;
                FilamentNativeAppV2305 filamentNativeAppV23052 = filamentNativeAppV2305;
                if (filamentNativeAppV23052 == null) {
                    filamentNativeAppV23052 = MiniHomeScene.this.j().get();
                }
                if (filamentNativeAppV23052 != null && (a16 = filamentNativeAppV23052.a()) != null) {
                    a16.a();
                }
                FLog fLog = FLog.INSTANCE;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("viewerHandlerThread quitSafely, scene:");
                sb5.append(MiniHomeScene.this);
                sb5.append(", app:");
                sb5.append(filamentNativeAppV23052);
                sb5.append(", ");
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                sb5.append(currentThread.getId());
                sb5.append(", ");
                Thread currentThread2 = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread2, "Thread.currentThread()");
                sb5.append(currentThread2.getName());
                fLog.i("MiniHomeScene", sb5.toString());
                MiniHomeScene.this.k().j();
            }
        });
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(@Nullable SensorEvent event) {
        Integer num;
        Sensor sensor;
        if (this.hasDestroy || !this.enableGyroSensor || this.disableSensorByTouch) {
            return;
        }
        if (event != null && (sensor = event.sensor) != null) {
            num = Integer.valueOf(sensor.getType());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 4) {
            float[] fArr = event.values;
            final float f16 = fArr[0];
            final float f17 = fArr[1];
            if (Math.abs(f16) < 1 && Math.abs(f17) < 0.3d) {
                return;
            }
            k().e(new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$onSensorChanged$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FilamentMiniHome filamentMiniHome;
                    if (Math.abs(f16) > Math.abs(f17)) {
                        FilamentMiniHome filamentMiniHome2 = MiniHomeScene.this.minihome;
                        if (filamentMiniHome2 != null) {
                            filamentMiniHome2.setGyroEuler(0.0f, f16 * 0.005f, 0.0f);
                            return;
                        }
                        return;
                    }
                    if (Math.abs(f17) <= Math.abs(f16) || (filamentMiniHome = MiniHomeScene.this.minihome) == null) {
                        return;
                    }
                    filamentMiniHome.setGyroEuler(0.0f, 0.0f, f17 * 0.01f);
                }
            });
        }
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void q() {
        super.q();
        SensorManager sensorManager = this.sensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        this.hasSeneorRegister = false;
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void r() {
        super.r();
        if (this.enableGyroSensor && !this.hasSeneorRegister) {
            SensorManager sensorManager = this.sensorManager;
            if (sensorManager != null) {
                SensorMonitor.registerListener(sensorManager, this, this.gyroSensor, 1);
            }
            this.hasSeneorRegister = true;
        }
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void s(@NotNull SurfaceTexture surfaceTexture, int width, int height) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        super.s(surfaceTexture, width, height);
        V(width, height, new Surface(surfaceTexture));
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void t(@NotNull SurfaceTexture surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        super.t(surface);
        this.hasSurface.set(false);
        Y();
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void u(@NotNull SurfaceTexture surfaceTexture, int width, int height) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        super.u(surfaceTexture, width, height);
        V(width, height, new Surface(surfaceTexture));
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(@Nullable Sensor sensor, int accuracy) {
    }
}
