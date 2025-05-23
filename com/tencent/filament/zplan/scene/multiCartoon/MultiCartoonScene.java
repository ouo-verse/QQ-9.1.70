package com.tencent.filament.zplan.scene.multiCartoon;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.tencent.filament.zplan.animation.FilamentAnimation;
import com.tencent.filament.zplan.animation.sequencer.NormalAnimation;
import com.tencent.filament.zplan.animation.sequencer.Track;
import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.app.scene.BaseSceneV2305;
import com.tencent.filament.zplan.avatar.CameraParams;
import com.tencent.filament.zplan.avatar.Directional;
import com.tencent.filament.zplan.avatar.Exposure;
import com.tencent.filament.zplan.avatar.FovProjection;
import com.tencent.filament.zplan.avatar.LightsParams;
import com.tencent.filament.zplan.avatar.LookAt;
import com.tencent.filament.zplan.avatar.SpotLight;
import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.exception.BlackListResourceException;
import com.tencent.filament.zplan.avatar.exception.FetchFileException;
import com.tencent.filament.zplan.avatar.model.ReloadAvatarResourceModel;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplan.engine.FilamentViewerV2305;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.zplan.common.utils.h;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import sk0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001VB\u001f\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010S\u001a\b\u0012\u0004\u0012\u00020R0Q\u00a2\u0006\u0004\bT\u0010UJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J2\u0010\u0013\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J0\u0010\u001a\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\n\u0010\u0019\u001a\u00060\u0017j\u0002`\u0018H\u0002J \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u001c2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001b\u001a\u00020\tH\u0002J \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001c2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001e\u001a\u00020\u0010H\u0002J\"\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u001c2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020\tH\u0002J\b\u0010#\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020$H\u0002J\u0012\u0010'\u001a\u0004\u0018\u00010\u00102\u0006\u0010&\u001a\u00020\tH\u0002JE\u0010-\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010(\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\tH\u0002\u00a2\u0006\u0004\b-\u0010.J\u0018\u00101\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u0017H\u0016J\u001a\u00105\u001a\u00020\u00052\u0006\u00103\u001a\u0002022\b\u00104\u001a\u0004\u0018\u00010\tH\u0016R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u001a\u0010B\u001a\u00060\u0017j\u0002`\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010AR\u001a\u0010D\u001a\u00060\u0017j\u0002`\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010AR\u001a\u0010F\u001a\u00060\u0017j\u0002`\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010AR\u001a\u0010H\u001a\u00060\u0017j\u0002`\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010AR\u001a\u0010I\u001a\u00060\u0017j\u0002`\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010AR\u0016\u0010K\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010JR\u001a\u0010P\u001a\u00020L8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b%\u0010M\u001a\u0004\bN\u0010O\u00a8\u0006W"}, d2 = {"Lcom/tencent/filament/zplan/scene/multiCartoon/MultiCartoonScene;", "Lcom/tencent/filament/zplan/app/scene/BaseSceneV2305;", "Lkotlinx/coroutines/CoroutineScope;", "", "now", "", "N", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "eventData", "Lkotlinx/coroutines/Job;", "X", "leftAvatarGltfPath", "Lcom/tencent/filament/zplan/avatar/model/ReloadAvatarResourceModel;", "rightAvatarResourceModel", "Lorg/json/JSONObject;", "rightAvatarCharacter", "resourceConfig", "P", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2305;", "viewer", "animationGltfPath", "", "Lcom/tencent/filament/zplan/engine/RenderObjectId;", "renderObjectId", "W", "filamatPath", "Lkotlinx/coroutines/Deferred;", "O", "avatarInfo", "V", "configPath", "U", "Lcom/tencent/filament/zplan/avatar/LightsParams;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/filament/zplan/avatar/CameraParams;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "gltfPath", "Y", "eventType", "data", "", "isSuccess", "errorMsg", ExifInterface.LATITUDE_SOUTH, "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "totalTime", "frameTime", "d", "", "errorCode", "errorMessage", "o", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "G", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "H", "Lorg/json/JSONObject;", "attachments", "Ljava/util/concurrent/atomic/AtomicBoolean;", "I", "Ljava/util/concurrent/atomic/AtomicBoolean;", "booted", "J", "leftAvatarObjectId", "K", "rightAvatarObjectId", "L", "sceneStaticPropObjectId", "M", "leftDynamicPropObjectId", "rightDynamicPropObjectId", "D", "animationBeginTime", "Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/app/impl/FilamentNativeAppV2305;", "app", "<init>", "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/ref/WeakReference;)V", "b", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class MultiCartoonScene extends BaseSceneV2305 implements CoroutineScope {

    /* renamed from: G, reason: from kotlin metadata */
    private final FilamentUrlTemplate urlTemplate;

    /* renamed from: H, reason: from kotlin metadata */
    private JSONObject attachments;

    /* renamed from: I, reason: from kotlin metadata */
    private final AtomicBoolean booted;

    /* renamed from: J, reason: from kotlin metadata */
    private long leftAvatarObjectId;

    /* renamed from: K, reason: from kotlin metadata */
    private long rightAvatarObjectId;

    /* renamed from: L, reason: from kotlin metadata */
    private long sceneStaticPropObjectId;

    /* renamed from: M, reason: from kotlin metadata */
    private long leftDynamicPropObjectId;

    /* renamed from: N, reason: from kotlin metadata */
    private long rightDynamicPropObjectId;

    /* renamed from: P, reason: from kotlin metadata */
    private double animationBeginTime;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final CoroutineContext coroutineContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MultiCartoonScene f105969d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CoroutineContext.Key key, MultiCartoonScene multiCartoonScene) {
            super(key);
            this.f105969d = multiCartoonScene;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            FLog.INSTANCE.e("MultiCartoonScene", "there is an error in coroutine.", exception);
            String str = "";
            if (exception instanceof FetchFileException) {
                MultiCartoonScene multiCartoonScene = this.f105969d;
                FetchFileException fetchFileException = (FetchFileException) exception;
                int errorCode = fetchFileException.getErrorCode();
                String errorMessage = fetchFileException.getErrorMessage();
                if (errorMessage != null) {
                    str = errorMessage;
                }
                multiCartoonScene.o(errorCode, str);
                return;
            }
            if (exception instanceof BlackListResourceException) {
                MultiCartoonScene multiCartoonScene2 = this.f105969d;
                String message = exception.getMessage();
                if (message != null) {
                    str = message;
                }
                multiCartoonScene2.o(201005, str);
                return;
            }
            MultiCartoonScene multiCartoonScene3 = this.f105969d;
            String message2 = exception.getMessage();
            if (message2 != null) {
                str = message2;
            }
            multiCartoonScene3.o(201000, str);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/filament/zplan/scene/multiCartoon/MultiCartoonScene$c", "Lsk0/b;", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "type", "data", "", "handleEvent", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class c implements b {
        c() {
        }

        @Override // sk0.b
        public void handleEvent(@Nullable com.tencent.zplan.zplantracing.c spanContext, @NotNull String type, @Nullable String data) {
            boolean z16;
            Intrinsics.checkNotNullParameter(type, "type");
            if (type.hashCode() == -701691475 && type.equals("ViewerV2.onLoadMultiAvatar")) {
                if (data != null && data.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    MultiCartoonScene.this.X(spanContext, data);
                    return;
                }
                FLog.INSTANCE.e("MultiCartoonScene", "eventData is empty. eventType:" + type);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiCartoonScene(@Nullable com.tencent.zplan.zplantracing.c cVar, @NotNull WeakReference<FilamentNativeAppV2305> app) {
        super(cVar, app);
        sk0.a configuration;
        FilamentUrlTemplate urlTemplate;
        Intrinsics.checkNotNullParameter(app, "app");
        FilamentNativeAppV2305 filamentNativeAppV2305 = app.get();
        this.urlTemplate = (filamentNativeAppV2305 == null || (configuration = filamentNativeAppV2305.getConfiguration()) == null || (urlTemplate = configuration.getUrlTemplate()) == null) ? FilamentFeatureUtil.f106409g.F() : urlTemplate;
        this.booted = new AtomicBoolean(false);
        c cVar2 = new c();
        FilamentNativeAppV2305 filamentNativeAppV23052 = app.get();
        if (filamentNativeAppV23052 != null) {
            filamentNativeAppV23052.addEventListener("ViewerV2.onLoadMultiAvatar", cVar2);
        }
        this.coroutineContext = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()).plus(new a(CoroutineExceptionHandler.INSTANCE, this));
    }

    private final void N(double now) {
        double d16 = this.animationBeginTime;
        double d17 = 0.0d;
        if (d16 == 0.0d) {
            this.animationBeginTime = now;
        } else {
            d17 = now - d16;
        }
        FilamentViewerV2305 viewer = getViewer();
        if (viewer != null) {
            viewer.applyAnimation(this.leftAvatarObjectId, d17);
        }
        FilamentViewerV2305 viewer2 = getViewer();
        if (viewer2 != null) {
            viewer2.applyAnimation(this.rightAvatarObjectId, d17);
        }
        FilamentViewerV2305 viewer3 = getViewer();
        if (viewer3 != null) {
            viewer3.applyAnimation(this.leftDynamicPropObjectId, d17);
        }
        FilamentViewerV2305 viewer4 = getViewer();
        if (viewer4 != null) {
            viewer4.applyAnimation(this.rightDynamicPropObjectId, d17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Deferred<Unit> O(com.tencent.zplan.zplantracing.c spanContext, String filamatPath) {
        Deferred<Unit> async$default;
        async$default = BuildersKt__Builders_commonKt.async$default(this, null, null, new MultiCartoonScene$bootAsync$1(this, spanContext, filamatPath, null), 3, null);
        return async$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(com.tencent.zplan.zplantracing.c spanContext, String leftAvatarGltfPath, ReloadAvatarResourceModel rightAvatarResourceModel, JSONObject rightAvatarCharacter, JSONObject resourceConfig) {
        FilamentViewerV2305 viewer = getViewer();
        if (viewer != null) {
            String json = new Gson().toJson(Q());
            Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(defaultCamera())");
            viewer.setCamera(json);
            viewer.setLights(R());
            String sceneStaticPropGltfPath = resourceConfig.optString("sceneStaticPropGltfPath");
            Intrinsics.checkNotNullExpressionValue(sceneStaticPropGltfPath, "sceneStaticPropGltfPath");
            if (sceneStaticPropGltfPath.length() > 0) {
                long createGltfRenderObject = viewer.createGltfRenderObject(spanContext);
                this.sceneStaticPropObjectId = createGltfRenderObject;
                viewer.updateRenderObjectGltf(spanContext, createGltfRenderObject, sceneStaticPropGltfPath);
                JSONObject Y = Y(sceneStaticPropGltfPath);
                if (Y != null) {
                    long j3 = this.sceneStaticPropObjectId;
                    String jSONObject = Y.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject, "it.toString()");
                    viewer.setRenderObjectTransform(j3, jSONObject);
                }
            }
            String leftDynamicPropGltfPath = resourceConfig.optString("leftDynamicPropGltfPath");
            Intrinsics.checkNotNullExpressionValue(leftDynamicPropGltfPath, "leftDynamicPropGltfPath");
            if (leftDynamicPropGltfPath.length() > 0) {
                long createGltfRenderObject2 = viewer.createGltfRenderObject(spanContext);
                this.leftDynamicPropObjectId = createGltfRenderObject2;
                viewer.updateRenderObjectGltf(spanContext, createGltfRenderObject2, leftDynamicPropGltfPath);
                JSONObject Y2 = Y(leftDynamicPropGltfPath);
                if (Y2 != null) {
                    long j16 = this.leftDynamicPropObjectId;
                    String jSONObject2 = Y2.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "it.toString()");
                    viewer.setRenderObjectTransform(j16, jSONObject2);
                }
            }
            String rightDynamicPropGltfPath = resourceConfig.optString("rightDynamicPropGltfPath");
            Intrinsics.checkNotNullExpressionValue(rightDynamicPropGltfPath, "rightDynamicPropGltfPath");
            if (rightDynamicPropGltfPath.length() > 0) {
                long createGltfRenderObject3 = viewer.createGltfRenderObject(spanContext);
                this.rightDynamicPropObjectId = createGltfRenderObject3;
                viewer.updateRenderObjectGltf(spanContext, createGltfRenderObject3, rightDynamicPropGltfPath);
                JSONObject Y3 = Y(rightDynamicPropGltfPath);
                if (Y3 != null) {
                    long j17 = this.rightDynamicPropObjectId;
                    String jSONObject3 = Y3.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject3, "it.toString()");
                    viewer.setRenderObjectTransform(j17, jSONObject3);
                }
            }
            JSONObject jSONObject4 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.mo162put("HandHeldSlot");
            Unit unit = Unit.INSTANCE;
            jSONObject4.put("hideSlotPart", jSONArray);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("avatarGltf", leftAvatarGltfPath);
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("slotGltfMap", jSONObject5);
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("dressUpInfo", jSONObject6);
            long createAvatarRenderObject = viewer.createAvatarRenderObject(spanContext);
            this.leftAvatarObjectId = createAvatarRenderObject;
            viewer.updateRenderObjectAvatar(spanContext, createAvatarRenderObject, jSONObject7);
            viewer.setRenderObjectHittable(this.leftAvatarObjectId, true);
            JSONObject o16 = ZPlanAvatarResourceHelper.f105660o.o(rightAvatarResourceModel, rightAvatarCharacter, false, false, false, spanContext);
            o16.put("avatarMask", jSONObject4);
            long createAvatarRenderObject2 = viewer.createAvatarRenderObject(spanContext);
            this.rightAvatarObjectId = createAvatarRenderObject2;
            viewer.updateRenderObjectAvatar(spanContext, createAvatarRenderObject2, o16);
            viewer.setRenderObjectHittable(this.rightAvatarObjectId, true);
            W(spanContext, viewer, resourceConfig.optString("leftDynamicPropAnimPath"), this.leftDynamicPropObjectId);
            W(spanContext, viewer, resourceConfig.optString("rightDynamicPropAnimPath"), this.rightDynamicPropObjectId);
            JSONObject optJSONObject = resourceConfig.optJSONObject("leftAvatarAction");
            if (optJSONObject != null) {
                optJSONObject.optString("faceAnimationGltf");
            }
            W(spanContext, viewer, optJSONObject != null ? optJSONObject.optString("bodyAnimationGltf") : null, this.leftAvatarObjectId);
            JSONObject optJSONObject2 = resourceConfig.optJSONObject("rightAvatarAction");
            String optString = optJSONObject2 != null ? optJSONObject2.optString("faceAnimationGltf") : null;
            String optString2 = optJSONObject2 != null ? optJSONObject2.optString("bodyAnimationGltf") : null;
            W(spanContext, viewer, optString, this.rightAvatarObjectId);
            W(spanContext, viewer, optString2, this.rightAvatarObjectId);
            return;
        }
        throw new IllegalStateException("viewer is null");
    }

    private final CameraParams Q() {
        CameraParams cameraParams = new CameraParams(null, null, null, null, null, 31, null);
        Exposure exposure = new Exposure(0, 0.0d, 0.0d, 7, null);
        exposure.setAperture(16);
        exposure.setSensitivity(100.0d);
        exposure.setShutterSpeed(0.008d);
        Unit unit = Unit.INSTANCE;
        cameraParams.setExposure(exposure);
        LookAt lookAt = new LookAt(null, null, null, 7, null);
        lookAt.setEye(new float[]{-9.02f, 0.6f, 9.972f});
        lookAt.setTarget(new float[]{0.714f, 0.6f, -0.84f});
        lookAt.setUpward(new float[]{0.0f, 1.0f, 0.0f});
        cameraParams.setLookAt(lookAt);
        cameraParams.setFovProjection(new FovProjection(10.0f, 1.0f, 1000.0f, 0.05f, "horizontal"));
        return cameraParams;
    }

    private final LightsParams R() {
        List mutableListOf;
        Directional directional = new Directional(null, 0, 0.0f, null, false, 31, null);
        directional.setColor(new float[]{1.0f, 0.94f, 0.99f});
        directional.setIntensity(67000.0f);
        directional.setDirection(new float[]{0.5f, -0.246f, -0.856f});
        directional.setCastShadows(true);
        Unit unit = Unit.INSTANCE;
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
        return new LightsParams(directional, null, mutableListOf);
    }

    private final void S(com.tencent.zplan.zplantracing.c spanContext, String eventType, String data, Boolean isSuccess, String errorMsg) {
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

    static /* synthetic */ void T(MultiCartoonScene multiCartoonScene, com.tencent.zplan.zplantracing.c cVar, String str, String str2, Boolean bool, String str3, int i3, Object obj) {
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
        multiCartoonScene.S(cVar2, str, str2, bool2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Deferred<JSONObject> U(com.tencent.zplan.zplantracing.c spanContext, String configPath) {
        Deferred<JSONObject> async$default;
        async$default = BuildersKt__Builders_commonKt.async$default(this, null, null, new MultiCartoonScene$fetchAttachmentConfigAsync$1(configPath, null), 3, null);
        return async$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Deferred<ReloadAvatarResourceModel> V(com.tencent.zplan.zplantracing.c spanContext, JSONObject avatarInfo) {
        Deferred<ReloadAvatarResourceModel> async$default;
        async$default = BuildersKt__Builders_commonKt.async$default(this, null, null, new MultiCartoonScene$fetchReloadAvatarResourceAsync$1(this, spanContext, avatarInfo, null), 3, null);
        return async$default;
    }

    private final void W(com.tencent.zplan.zplantracing.c spanContext, FilamentViewerV2305 viewer, String animationGltfPath, long renderObjectId) {
        boolean z16;
        Object firstOrNull;
        List mutableListOf;
        if (animationGltfPath != null && animationGltfPath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(viewer.loadAnimation(animationGltfPath, spanContext));
            FilamentAnimation filamentAnimation = (FilamentAnimation) firstOrNull;
            if (filamentAnimation != null) {
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(NormalAnimation.INSTANCE.a(filamentAnimation));
                viewer.bindAnimationTrack(spanContext, renderObjectId, new Track(true, mutableListOf));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Job X(com.tencent.zplan.zplantracing.c spanContext, String eventData) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this, null, null, new MultiCartoonScene$onLoad$1(this, eventData, spanContext, null), 3, null);
        return launch$default;
    }

    private final JSONObject Y(String gltfPath) {
        JSONArray optJSONArray;
        String optString;
        String substringAfterLast$default;
        JSONObject jSONObject = this.attachments;
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("meshes")) == null) {
            return null;
        }
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            if (optJSONObject != null && (optString = optJSONObject.optString("path")) != null) {
                substringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(gltfPath, "/", (String) null, 2, (Object) null);
                if (Intrinsics.areEqual(optString, substringAfterLast$default)) {
                    return optJSONObject;
                }
            }
        }
        return null;
    }

    @Override // com.tencent.filament.zplan.util.vsync.b
    public void d(long totalTime, long frameTime) {
        if (!getAttached().get()) {
            return;
        }
        double d16 = frameTime / 1000000000;
        N(d16);
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
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void o(int errorCode, @Nullable String errorMessage) {
        super.o(errorCode, errorMessage);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errorCode", errorCode);
        jSONObject.put("errorMessage", errorMessage);
        Unit unit = Unit.INSTANCE;
        T(this, null, "onFilamentRenderFail", jSONObject.toString(), null, null, 25, null);
    }
}
