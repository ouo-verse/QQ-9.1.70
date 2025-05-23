package com.tencent.filament.zplan.scene.cartoon;

import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.app.scene.BaseSceneV2305;
import com.tencent.filament.zplan.avatar.CameraParams;
import com.tencent.filament.zplan.avatar.Directional;
import com.tencent.filament.zplan.avatar.Exposure;
import com.tencent.filament.zplan.avatar.IndirectLight;
import com.tencent.filament.zplan.avatar.LensProjection;
import com.tencent.filament.zplan.avatar.LightsParams;
import com.tencent.filament.zplan.avatar.LookAt;
import com.tencent.filament.zplan.avatar.SpotLight;
import com.tencent.filament.zplan.avatar.exception.BlackListResourceException;
import com.tencent.filament.zplan.avatar.exception.FetchFileException;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplan.engine.FilamentViewerV2305;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.zplan.common.utils.h;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import sk0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00062\u00020\u00012\u00020\u0002:\u00018B\u001f\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\f\u00105\u001a\b\u0012\u0004\u0012\u00020403\u00a2\u0006\u0004\b6\u00107J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002JE\u0010\u0016\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\tH\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u001a\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\tH\u0016R\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020\u00138\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010*\u001a\u00060\u0018j\u0002`'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010+R\u001a\u00102\u001a\u00020-8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\u00a8\u00069"}, d2 = {"Lcom/tencent/filament/zplan/scene/cartoon/CartoonScene;", "Lcom/tencent/filament/zplan/app/scene/BaseSceneV2305;", "Lkotlinx/coroutines/CoroutineScope;", "", "now", "", "L", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "eventData", "Lkotlinx/coroutines/Job;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/filament/zplan/avatar/LightsParams;", "N", "Lcom/tencent/filament/zplan/avatar/CameraParams;", "M", "eventType", "data", "", "isSuccess", "errorMsg", "O", "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "", "totalTime", "frameTime", "d", "", "errorCode", "errorMessage", "o", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "G", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "H", "Z", "isNightModel", "Lcom/tencent/filament/zplan/engine/RenderObjectId;", "I", "J", "avatarRenderObjectId", "D", "animationBeginTime", "Lkotlin/coroutines/CoroutineContext;", "K", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/app/impl/FilamentNativeAppV2305;", "app", "<init>", "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/ref/WeakReference;)V", "b", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class CartoonScene extends BaseSceneV2305 implements CoroutineScope {

    /* renamed from: G, reason: from kotlin metadata */
    private final FilamentUrlTemplate urlTemplate;

    /* renamed from: H, reason: from kotlin metadata */
    private final boolean isNightModel;

    /* renamed from: I, reason: from kotlin metadata */
    private long avatarRenderObjectId;

    /* renamed from: J, reason: from kotlin metadata */
    private double animationBeginTime;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final CoroutineContext coroutineContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CartoonScene f105914d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CoroutineContext.Key key, CartoonScene cartoonScene) {
            super(key);
            this.f105914d = cartoonScene;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            FLog.INSTANCE.e("CartoonBusinessScene", "there is an error in coroutine.", exception);
            String str = "";
            if (exception instanceof FetchFileException) {
                CartoonScene cartoonScene = this.f105914d;
                FetchFileException fetchFileException = (FetchFileException) exception;
                int errorCode = fetchFileException.getErrorCode();
                String errorMessage = fetchFileException.getErrorMessage();
                if (errorMessage != null) {
                    str = errorMessage;
                }
                cartoonScene.o(errorCode, str);
                return;
            }
            if (exception instanceof BlackListResourceException) {
                CartoonScene cartoonScene2 = this.f105914d;
                String message = exception.getMessage();
                if (message != null) {
                    str = message;
                }
                cartoonScene2.o(201005, str);
                return;
            }
            CartoonScene cartoonScene3 = this.f105914d;
            String message2 = exception.getMessage();
            if (message2 != null) {
                str = message2;
            }
            cartoonScene3.o(201000, str);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/filament/zplan/scene/cartoon/CartoonScene$c", "Lsk0/b;", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "type", "data", "", "handleEvent", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class c implements b {
        c() {
        }

        @Override // sk0.b
        public void handleEvent(@Nullable com.tencent.zplan.zplantracing.c spanContext, @NotNull String type, @Nullable String data) {
            boolean z16;
            Intrinsics.checkNotNullParameter(type, "type");
            if (type.hashCode() == -674343582 && type.equals("ViewerV2.onLoadCartoonAvatar")) {
                if (data != null && data.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    CartoonScene.this.Q(spanContext, data);
                    return;
                }
                FLog.INSTANCE.e("CartoonBusinessScene", "eventData is empty. eventType:" + type);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CartoonScene(@Nullable com.tencent.zplan.zplantracing.c cVar, @NotNull WeakReference<FilamentNativeAppV2305> app) {
        super(cVar, app);
        sk0.a configuration;
        FilamentUrlTemplate urlTemplate;
        Intrinsics.checkNotNullParameter(app, "app");
        FilamentNativeAppV2305 filamentNativeAppV2305 = app.get();
        this.urlTemplate = (filamentNativeAppV2305 == null || (configuration = filamentNativeAppV2305.getConfiguration()) == null || (urlTemplate = configuration.getUrlTemplate()) == null) ? FilamentFeatureUtil.f106409g.F() : urlTemplate;
        this.isNightModel = true;
        c cVar2 = new c();
        FilamentNativeAppV2305 filamentNativeAppV23052 = app.get();
        if (filamentNativeAppV23052 != null) {
            filamentNativeAppV23052.addEventListener("ViewerV2.onLoadCartoonAvatar", cVar2);
        }
        this.coroutineContext = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()).plus(new a(CoroutineExceptionHandler.INSTANCE, this));
    }

    private final void L(double now) {
        double d16 = this.animationBeginTime;
        double d17 = 0.0d;
        if (d16 == 0.0d) {
            this.animationBeginTime = now;
        } else {
            d17 = now - d16;
        }
        FilamentViewerV2305 viewer = getViewer();
        if (viewer != null) {
            viewer.applyAnimation(this.avatarRenderObjectId, d17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CameraParams M() {
        CameraParams cameraParams = new CameraParams(null, null, null, null, null, 31, null);
        Exposure exposure = new Exposure(0, 0.0d, 0.0d, 7, null);
        exposure.setAperture(16);
        exposure.setSensitivity(100.0d);
        exposure.setShutterSpeed(0.008d);
        Unit unit = Unit.INSTANCE;
        cameraParams.setExposure(exposure);
        LookAt lookAt = new LookAt(null, null, null, 7, null);
        lookAt.setEye(new float[]{0.0f, 1.35f, 12.7f});
        lookAt.setTarget(new float[]{0.0f, 0.807f, 0.0f});
        lookAt.setUpward(new float[]{0.0f, 1.0f, 0.0f});
        cameraParams.setLookAt(lookAt);
        cameraParams.setLensProjection(new LensProjection(0.0f, 0.0f, 0, 0.0f, 15, null));
        return cameraParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LightsParams N() {
        List mutableListOf;
        Directional directional = new Directional(null, 0, 0.0f, null, false, 31, null);
        directional.setColor(new float[]{1.0f, 0.94f, 0.99f});
        directional.setIntensity(67000.0f);
        directional.setDirection(new float[]{0.5f, -0.246f, -0.856f});
        directional.setCastShadows(true);
        Unit unit = Unit.INSTANCE;
        IndirectLight indirectLight = new IndirectLight(null, 0.0f, 3, null);
        indirectLight.setIntensity(5000.0f);
        SpotLight spotLight = new SpotLight(null, null, null, null, 0.0f, 0.0d, 0, 0, false, 511, null);
        spotLight.setKey("spotLight1");
        spotLight.setPosition(new float[]{1.017f, 1.017f, 0.905f});
        spotLight.setDirection(new float[]{-0.61f, 0.281f, -0.741f});
        spotLight.setColor(new float[]{0.8f, 0.8f, 1.0f});
        spotLight.setIntensity(123380.0f);
        spotLight.setFalloff(10.0d);
        spotLight.setInnerCone(10);
        spotLight.setOuterCone(50);
        spotLight.setCastShadows(false);
        SpotLight spotLight2 = new SpotLight(null, null, null, null, 0.0f, 0.0d, 0, 0, false, 511, null);
        spotLight2.setKey("spotLight2");
        spotLight2.setPosition(new float[]{0.152f, 0.273f, -1.897f});
        spotLight2.setDirection(new float[]{-0.307f, -0.237f, 0.922f});
        spotLight2.setColor(new float[]{0.5f, 0.5f, 1.0f});
        spotLight2.setIntensity(48330.0f);
        spotLight2.setFalloff(30.0d);
        spotLight2.setInnerCone(10);
        spotLight2.setOuterCone(40);
        spotLight2.setCastShadows(false);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(spotLight, spotLight2);
        return new LightsParams(directional, indirectLight, mutableListOf);
    }

    private final void O(com.tencent.zplan.zplantracing.c spanContext, String eventType, String data, Boolean isSuccess, String errorMsg) {
        JSONObject jSONObject;
        if (data == null) {
            data = new JSONObject().toString();
            Intrinsics.checkNotNullExpressionValue(data, "JSONObject().toString()");
        }
        FilamentNativeAppV2305 filamentNativeAppV2305 = j().get();
        if (filamentNativeAppV2305 != null) {
            JSONObject b16 = h.f385294a.b(data);
            if (b16 != null) {
                b16.put("isSuccess", isSuccess);
                jSONObject = b16.put("errMsg", errorMsg);
            } else {
                jSONObject = null;
            }
            filamentNativeAppV2305.dispatchEvent(spanContext, eventType, String.valueOf(jSONObject));
        }
    }

    static /* synthetic */ void P(CartoonScene cartoonScene, com.tencent.zplan.zplantracing.c cVar, String str, String str2, Boolean bool, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            cVar = null;
        }
        com.tencent.zplan.zplantracing.c cVar2 = cVar;
        if ((i3 & 8) != 0) {
            bool = Boolean.TRUE;
        }
        Boolean bool2 = bool;
        if ((i3 & 16) != 0) {
            str3 = "";
        }
        cartoonScene.O(cVar2, str, str2, bool2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Job Q(com.tencent.zplan.zplantracing.c spanContext, String eventData) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this, null, null, new CartoonScene$onLoad$1(this, eventData, spanContext, null), 3, null);
        return launch$default;
    }

    @Override // com.tencent.filament.zplan.util.vsync.b
    public void d(long totalTime, long frameTime) {
        if (!getAttached().get()) {
            return;
        }
        double d16 = frameTime / 1000000000;
        L(d16);
        FilamentViewerV2305 viewer = getViewer();
        if (viewer != null) {
            viewer.kawaiiPhysicsUpdate(d16);
        }
        FilamentViewerV2305 viewer2 = getViewer();
        if (viewer2 != null) {
            FilamentViewerV2.render$default(viewer2, false, null, 2, null);
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    /* renamed from: getCoroutineContext, reason: from getter */
    public CoroutineContext getContext() {
        return this.coroutineContext;
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void o(int errorCode, @Nullable String errorMessage) {
        super.o(errorCode, errorMessage);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errorCode", errorCode);
        jSONObject.put("errorMessage", errorMessage);
        Unit unit = Unit.INSTANCE;
        P(this, null, "onFilamentRenderFail", jSONObject.toString(), null, null, 25, null);
    }
}
