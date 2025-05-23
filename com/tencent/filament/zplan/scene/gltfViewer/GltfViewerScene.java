package com.tencent.filament.zplan.scene.gltfViewer;

import android.os.Build;
import android.view.TextureView;
import com.google.gson.Gson;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.app.scene.BaseSceneV2305;
import com.tencent.filament.zplan.avatar.CameraParams;
import com.tencent.filament.zplan.avatar.Directional;
import com.tencent.filament.zplan.avatar.FovProjection;
import com.tencent.filament.zplan.avatar.IndirectLight;
import com.tencent.filament.zplan.avatar.LightsParams;
import com.tencent.filament.zplan.avatar.SpotLight;
import com.tencent.filament.zplan.avatar.exception.BlackListResourceException;
import com.tencent.filament.zplan.avatar.exception.FetchFileException;
import com.tencent.filament.zplan.avatar.model.BootResourceModel;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplan.engine.FilamentViewerV2305;
import com.tencent.filament.zplan.scene.couple.config.d;
import com.tencent.filament.zplan.view.event.TouchEvent;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import com.tencent.zplan.zplantracing.b;
import com.tencent.zplan.zplantracing.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001=B\u001f\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\f\u00109\u001a\b\u0012\u0004\u0012\u00020807\u00a2\u0006\u0004\b:\u0010;J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u001a\u0010\f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0014\u0010\u0011\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\u0013\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\u0019\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0016H\u0002R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0016\u00100\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010+R\u001a\u00106\u001a\u0002018\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105\u00a8\u0006>"}, d2 = {"Lcom/tencent/filament/zplan/scene/gltfViewer/GltfViewerScene;", "Lcom/tencent/filament/zplan/app/scene/BaseSceneV2305;", "Lkotlinx/coroutines/CoroutineScope;", "", "totalTime", "frameTime", "", "d", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "gltfPath", "d0", "Lcom/tencent/filament/zplan/view/event/TouchEvent;", "event", "b0", "c0", "e0", "f0", "g0", "Z", "Lkotlinx/coroutines/Deferred;", "Lcom/tencent/filament/zplan/avatar/model/BootResourceModel;", "a0", "bootResource", "Y", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "G", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "H", "J", "currentRenderObjID", "Ljava/util/concurrent/atomic/AtomicBoolean;", "I", "Ljava/util/concurrent/atomic/AtomicBoolean;", "booted", "resReady", "K", "Ljava/lang/String;", "indirectLightPath", "", "L", UserInfo.SEX_FEMALE, "kScaleMultiplier", "M", "previousPinchScale", "N", "totalScale", "Lkotlin/coroutines/CoroutineContext;", "P", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/app/impl/FilamentNativeAppV2305;", "app", "<init>", "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/ref/WeakReference;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "b", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class GltfViewerScene extends BaseSceneV2305 implements CoroutineScope {

    /* renamed from: G, reason: from kotlin metadata */
    private final FilamentUrlTemplate urlTemplate;

    /* renamed from: H, reason: from kotlin metadata */
    private long currentRenderObjID;

    /* renamed from: I, reason: from kotlin metadata */
    private final AtomicBoolean booted;

    /* renamed from: J, reason: from kotlin metadata */
    private final AtomicBoolean resReady;

    /* renamed from: K, reason: from kotlin metadata */
    private String indirectLightPath;

    /* renamed from: L, reason: from kotlin metadata */
    private final float kScaleMultiplier;

    /* renamed from: M, reason: from kotlin metadata */
    private float previousPinchScale;

    /* renamed from: N, reason: from kotlin metadata */
    private float totalScale;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final CoroutineContext coroutineContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GltfViewerScene f105959d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CoroutineContext.Key key, GltfViewerScene gltfViewerScene) {
            super(key);
            this.f105959d = gltfViewerScene;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            FLog.INSTANCE.e("GltfViewerScene", "there is an error in coroutine.", exception);
            String str = "";
            if (exception instanceof FetchFileException) {
                GltfViewerScene gltfViewerScene = this.f105959d;
                FetchFileException fetchFileException = (FetchFileException) exception;
                int errorCode = fetchFileException.getErrorCode();
                String errorMessage = fetchFileException.getErrorMessage();
                if (errorMessage != null) {
                    str = errorMessage;
                }
                gltfViewerScene.o(errorCode, str);
                return;
            }
            if (exception instanceof BlackListResourceException) {
                GltfViewerScene gltfViewerScene2 = this.f105959d;
                String message = exception.getMessage();
                if (message != null) {
                    str = message;
                }
                gltfViewerScene2.o(201005, str);
                return;
            }
            GltfViewerScene gltfViewerScene3 = this.f105959d;
            String message2 = exception.getMessage();
            if (message2 != null) {
                str = message2;
            }
            gltfViewerScene3.o(201000, str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GltfViewerScene(@Nullable c cVar, @NotNull WeakReference<FilamentNativeAppV2305> app) {
        super(cVar, app);
        sk0.a configuration;
        FilamentUrlTemplate urlTemplate;
        Intrinsics.checkNotNullParameter(app, "app");
        FilamentNativeAppV2305 filamentNativeAppV2305 = app.get();
        this.urlTemplate = (filamentNativeAppV2305 == null || (configuration = filamentNativeAppV2305.getConfiguration()) == null || (urlTemplate = configuration.getUrlTemplate()) == null) ? FilamentFeatureUtil.f106409g.F() : urlTemplate;
        this.booted = new AtomicBoolean(false);
        this.resReady = new AtomicBoolean(false);
        GltfViewerScene$eventListener$1 gltfViewerScene$eventListener$1 = new GltfViewerScene$eventListener$1(this);
        FilamentNativeAppV2305 filamentNativeAppV23052 = app.get();
        if (filamentNativeAppV23052 != null) {
            filamentNativeAppV23052.addEventListener("init_scene", gltfViewerScene$eventListener$1);
        }
        if (filamentNativeAppV23052 != null) {
            filamentNativeAppV23052.addEventListener("load_gltf", gltfViewerScene$eventListener$1);
        }
        if (filamentNativeAppV23052 != null) {
            filamentNativeAppV23052.addEventListener("onTouchEvent", gltfViewerScene$eventListener$1);
        }
        this.kScaleMultiplier = 100.0f;
        this.coroutineContext = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()).plus(new a(CoroutineExceptionHandler.INSTANCE, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y(c spanContext, final BootResourceModel bootResource) {
        if (this.booted.get()) {
            return;
        }
        final b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("boot", spanContext);
        k().d("boot", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.gltfViewer.GltfViewerScene$bootAsync$1
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
                FilamentViewerV2305 viewer;
                boolean z16;
                AtomicBoolean atomicBoolean;
                viewer = GltfViewerScene.this.getViewer();
                if (viewer != null) {
                    BootResourceModel bootResourceModel = bootResource;
                    FilamentFeatureUtil filamentFeatureUtil = FilamentFeatureUtil.f106409g;
                    z16 = viewer.boot(bootResourceModel, "", false, false, false, filamentFeatureUtil.K(), filamentFeatureUtil.j());
                } else {
                    z16 = false;
                }
                if (!z16) {
                    b bVar = startSpan;
                    if (bVar != null) {
                        bVar.a("boot fail");
                    }
                    GltfViewerScene.this.o(201024, "boot fail");
                    return;
                }
                b bVar2 = startSpan;
                if (bVar2 != null) {
                    bVar2.b();
                }
                atomicBoolean = GltfViewerScene.this.booted;
                atomicBoolean.set(true);
            }
        });
    }

    private final void Z(final c spanContext) {
        k().d("clearRenderObject", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.gltfViewer.GltfViewerScene$clearRenderObject$1
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

            /* JADX WARN: Code restructure failed: missing block: B:3:0x000c, code lost:
            
                r0 = r4.this$0.getViewer();
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                long j3;
                FilamentViewerV2305 viewer;
                j3 = GltfViewerScene.this.currentRenderObjID;
                if (j3 == 0 || viewer == null) {
                    return;
                }
                viewer.deleteAllRenderObject(spanContext);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Deferred<BootResourceModel> a0(c spanContext) {
        Deferred<BootResourceModel> async$default;
        async$default = BuildersKt__Builders_commonKt.async$default(this, null, null, new GltfViewerScene$fetchBootResourceAndBootAsync$1(this, spanContext, null), 3, null);
        return async$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(final TouchEvent event) {
        k().d("handleEvnetPan", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.gltfViewer.GltfViewerScene$handleEvnetPan$1
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

            /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
            
                r0 = r5.this$0.getViewer();
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                FilamentViewerV2305 viewer;
                FilamentViewerV2305 viewer2;
                FilamentViewerV2305 viewer3;
                int i3 = a.f105961a[event.getState().ordinal()];
                if (i3 == 1) {
                    viewer = GltfViewerScene.this.getViewer();
                    if (viewer != null) {
                        viewer.grabCameraManipulatorBegin((int) event.getLocation().x, (int) event.getLocation().y, event.getTouchCount() > 1);
                        return;
                    }
                    return;
                }
                if (i3 != 2) {
                    if (i3 == 3 && viewer3 != null) {
                        viewer3.grabCameraManipulatorEnd();
                        return;
                    }
                    return;
                }
                viewer2 = GltfViewerScene.this.getViewer();
                if (viewer2 != null) {
                    viewer2.grabCameraManipulatorUpdate((int) event.getLocation().x, (int) event.getLocation().y);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0(final TouchEvent event) {
        k().d("handleEvnetPinch", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.gltfViewer.GltfViewerScene$handleEvnetPinch$1
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
                float f16;
                float f17;
                float f18;
                FilamentViewerV2305 viewer;
                float f19;
                TextureView view;
                int i3 = a.f105962b[event.getState().ordinal()];
                if (i3 == 1) {
                    GltfViewerScene gltfViewerScene = GltfViewerScene.this;
                    Float scale = event.getScale();
                    gltfViewerScene.previousPinchScale = scale != null ? scale.floatValue() : 0.0f;
                    return;
                }
                if (i3 == 2 || i3 == 3) {
                    Float scale2 = event.getScale();
                    float floatValue = scale2 != null ? scale2.floatValue() : 0.0f;
                    f16 = GltfViewerScene.this.previousPinchScale;
                    float f26 = floatValue - f16;
                    GltfViewerScene gltfViewerScene2 = GltfViewerScene.this;
                    Float scale3 = event.getScale();
                    gltfViewerScene2.previousPinchScale = scale3 != null ? scale3.floatValue() : 0.0f;
                    GltfViewerScene gltfViewerScene3 = GltfViewerScene.this;
                    f17 = gltfViewerScene3.totalScale;
                    float f27 = -f26;
                    f18 = GltfViewerScene.this.kScaleMultiplier;
                    gltfViewerScene3.totalScale = f17 + (f18 * f27);
                    viewer = GltfViewerScene.this.getViewer();
                    if (viewer != null) {
                        float f28 = event.getLocation().x;
                        FilamentNativeAppV2305 filamentNativeAppV2305 = GltfViewerScene.this.j().get();
                        float height = ((filamentNativeAppV2305 == null || (view = filamentNativeAppV2305.getView()) == null) ? 0 : view.getHeight()) - event.getLocation().y;
                        f19 = GltfViewerScene.this.kScaleMultiplier;
                        viewer.scrollCameraManipulator(f28, height, f27 * f19);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0(c spanContext, String gltfPath) {
        FLog.INSTANCE.e("GltfViewerScene", "loadGltf " + gltfPath);
        Z(spanContext);
        g0(spanContext, gltfPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0(c spanContext) {
        k().d("setCamera", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.gltfViewer.GltfViewerScene$setCamera$1
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
                FilamentViewerV2305 viewer;
                CameraParams cameraParams = new CameraParams(null, null, null, null, null, 31, null);
                cameraParams.getExposure().setAperture(9);
                cameraParams.getExposure().setShutterSpeed(125.0d);
                cameraParams.getExposure().setSensitivity(100.0d);
                cameraParams.getLookAt().setEye(new float[]{3.0f, 1.8f, 3.0f});
                cameraParams.getLookAt().setTarget(new float[]{0.0f, 1.0f, 0.0f});
                cameraParams.getLookAt().setUpward(new float[]{0.0f, 1.0f, 0.0f});
                FovProjection fovProjection = new FovProjection(0.0f, 0.0f, 0.0f, 0.0f, null, 31, null);
                fovProjection.setFov(35.0f);
                fovProjection.setAspect(1.0f);
                fovProjection.setNear(0.1f);
                fovProjection.setFar(20971.0f);
                Unit unit = Unit.INSTANCE;
                cameraParams.setFovProjection(fovProjection);
                viewer = GltfViewerScene.this.getViewer();
                if (viewer != null) {
                    String json = new Gson().toJson(cameraParams);
                    Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(camera)");
                    viewer.setCamera(json);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0(c spanContext) {
        FLog.INSTANCE.i("GltfViewerScene", "setLight " + this.indirectLightPath);
        k().d("setLight", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.gltfViewer.GltfViewerScene$setLight$1
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
                String str;
                FilamentViewerV2305 viewer;
                Directional directional = new Directional(null, 0, 0.0f, null, false, 31, null);
                directional.setColor(new float[]{1.0f, 0.94f, 0.99f});
                directional.setIntensity(1.0f);
                directional.setDirection(new float[]{0.5f, -0.246f, -0.856f});
                directional.setCastShadows(true);
                IndirectLight indirectLight = new IndirectLight(null, 0.0f, 3, null);
                str = GltfViewerScene.this.indirectLightPath;
                if (str == null) {
                    str = "";
                }
                indirectLight.setPath(str);
                indirectLight.setIntensity(1.0f);
                SpotLight spotLight = new SpotLight(null, null, null, null, 0.0f, 0.0d, 0, 0, false, 511, null);
                spotLight.setKey("spotLight1");
                spotLight.setPosition(new float[]{1.017f, 1.017f, 0.905f});
                spotLight.setDirection(new float[]{-0.61f, 0.281f, -0.741f});
                spotLight.setColor(new float[]{0.8f, 0.8f, 1.0f});
                spotLight.setIntensity(1.0f);
                spotLight.setFalloff(10.0d);
                spotLight.setInnerCone(10);
                spotLight.setOuterCone(50);
                spotLight.setCastShadows(false);
                SpotLight spotLight2 = new SpotLight(null, null, null, null, 0.0f, 0.0d, 0, 0, false, 511, null);
                spotLight2.setKey("spotLight2");
                spotLight2.setPosition(new float[]{0.152f, 0.273f, -1.897f});
                spotLight2.setDirection(new float[]{-0.307f, -0.237f, 0.922f});
                spotLight2.setColor(new float[]{0.5f, 0.5f, 1.0f});
                spotLight2.setIntensity(1.0f);
                spotLight2.setFalloff(30.0d);
                spotLight2.setInnerCone(10);
                spotLight2.setOuterCone(40);
                spotLight2.setCastShadows(false);
                LightsParams lightsParams = new LightsParams(directional, indirectLight, Build.VERSION.SDK_INT < 28 ? new ArrayList() : CollectionsKt__CollectionsKt.mutableListOf(spotLight, spotLight2));
                viewer = GltfViewerScene.this.getViewer();
                if (viewer != null) {
                    viewer.setLights(lightsParams);
                }
            }
        });
    }

    private final void g0(final c spanContext, final String gltfPath) {
        k().d("updateRenderObject", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.gltfViewer.GltfViewerScene$updateRenderObject$1
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
                FilamentViewerV2305 viewer;
                FilamentViewerV2305 viewer2;
                FilamentViewerV2305 viewer3;
                long j3;
                long j16;
                GltfViewerScene gltfViewerScene = GltfViewerScene.this;
                viewer = gltfViewerScene.getViewer();
                gltfViewerScene.currentRenderObjID = viewer != null ? viewer.createGltfRenderObject(spanContext) : 0L;
                viewer2 = GltfViewerScene.this.getViewer();
                if (viewer2 != null) {
                    c cVar = spanContext;
                    j16 = GltfViewerScene.this.currentRenderObjID;
                    viewer2.updateRenderObjectGltf(cVar, j16, gltfPath);
                }
                d dVar = new d(null, null, null, 7, null);
                viewer3 = GltfViewerScene.this.getViewer();
                if (viewer3 != null) {
                    j3 = GltfViewerScene.this.currentRenderObjID;
                    viewer3.setRenderObjectTransform(j3, dVar.toString());
                }
            }
        });
    }

    @Override // com.tencent.filament.zplan.util.vsync.b
    public void d(long totalTime, long frameTime) {
        FilamentViewerV2305 viewer = getViewer();
        if (viewer == null || !this.booted.get() || !this.resReady.get()) {
            return;
        }
        FilamentViewerV2.render$default(viewer, false, null, 2, null);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }
}
