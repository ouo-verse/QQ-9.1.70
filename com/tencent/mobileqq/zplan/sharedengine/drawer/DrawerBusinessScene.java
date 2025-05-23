package com.tencent.mobileqq.zplan.sharedengine.drawer;

import android.graphics.PointF;
import androidx.core.content.ContextCompat;
import com.google.gson.Gson;
import com.tencent.filament.zplan.animation.FilamentAnimation;
import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.BusinessSceneConfig;
import com.tencent.filament.zplan.avatar.CameraParams;
import com.tencent.filament.zplan.avatar.Directional;
import com.tencent.filament.zplan.avatar.Exposure;
import com.tencent.filament.zplan.avatar.IndirectLight;
import com.tencent.filament.zplan.avatar.LensProjection;
import com.tencent.filament.zplan.avatar.LightsParams;
import com.tencent.filament.zplan.avatar.LookAt;
import com.tencent.filament.zplan.avatar.SpotLight;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.business.api.SceneType;
import com.tencent.filament.zplan.business.impl.AbsBusinessScene;
import com.tencent.filament.zplan.data.FetchActionData;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplan.view.event.RotateParam;
import com.tencent.filament.zplan.view.event.TouchEvent;
import com.tencent.filament.zplan.view.event.TouchEventState;
import com.tencent.filament.zplan.view.event.TouchEventType;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.zplan.resource.api.IZPlanAvatarInfoHelper;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.zplantracing.c;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import wk3.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 P2\u00020\u0001:\u0001QB\u0007\u00a2\u0006\u0004\bN\u0010OJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001f\u0010\u0016\u001a\u0004\u0018\u00010\u00152\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u001b\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u00122\u0006\u0010 \u001a\u00020\u001fH\u0016\u00a2\u0006\u0004\b\"\u0010#J\b\u0010%\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020&H\u0016J\b\u0010(\u001a\u00020\u0018H\u0016J\b\u0010)\u001a\u00020\u0018H\u0016J'\u0010-\u001a\u00020\u00062\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\u0010,\u001a\u0004\u0018\u00010+H\u0016\u00a2\u0006\u0004\b-\u0010.J\u0014\u00101\u001a\u0004\u0018\u0001002\b\u0010/\u001a\u0004\u0018\u00010$H\u0016J\n\u00102\u001a\u0004\u0018\u00010\u0002H\u0016J$\u00104\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020$2\b\u00103\u001a\u0004\u0018\u00010$2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\b\u00105\u001a\u00020\u0018H\u0016J\u001c\u00109\u001a\u0004\u0018\u0001082\u0006\u00107\u001a\u0002062\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\u0006\u0010:\u001a\u00020\u0006R\u0018\u0010;\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010=\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010<R\u0018\u0010>\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010<R\u0016\u0010@\u001a\u00020?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010AR\u0016\u0010C\u001a\u00020?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010AR\u0016\u0010D\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010ER\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020\f0\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010L\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010M\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/zplan/sharedengine/drawer/DrawerBusinessScene;", "Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene;", "Lcom/tencent/filament/zplan/avatar/LightsParams;", "getLightsParams", "Lcom/tencent/filament/zplan/view/event/TouchEvent;", "event", "", "handlePanEvent", "", "angle", "rotateAvatar", "resetRotate", "", "status", "changeAnimationStatus", "Lcom/tencent/mobileqq/zplan/sharedengine/drawer/a;", "animationResource", "loadAvatarAnimation", "", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "animations", "Lcom/tencent/filament/zplan/animation/b;", "trackGroupWithAnimations", "([Lcom/tencent/filament/zplan/animation/ZPlanAction;)Lcom/tencent/filament/zplan/animation/b;", "", "needApplyShoesHeight", "Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene$FetchAvatarInfoFrom;", "from", "Lorg/json/JSONObject;", "fetchAvatarInfo", "(Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene$FetchAvatarInfoFrom;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "gender", "Lcom/tencent/filament/zplan/data/FetchActionData;", "getActionDataArray", "(Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;)[Lcom/tencent/filament/zplan/data/FetchActionData;", "", "getSceneConfig", "Lcom/tencent/filament/zplan/business/api/SceneType;", "getSceneType", "enablePlanarShadow", "enablePelvisOffset", "actionArray", "Lcom/tencent/zplan/zplantracing/c;", "zplanSpanContext", "loadAnimation", "([Lcom/tencent/filament/zplan/animation/ZPlanAction;Lcom/tencent/zplan/zplantracing/c;)V", "bodyTypeName", "Lcom/tencent/filament/zplan/avatar/CameraParams;", "getBodyTypeCamera", "getLightConfigAfterThemeChange", "eventData", "processDispatchEvent", "canRender", "", "now", "Lcom/tencent/filament/zplan/business/api/a;", "animate", "resetAnim", "defaultAnimationTrackGroup", "Lcom/tencent/filament/zplan/animation/b;", "pulledAnimationTrackGroup", "fullScreenAnimationTrackGroup", "Ljava/util/concurrent/atomic/AtomicInteger;", "animationStatus", "Ljava/util/concurrent/atomic/AtomicInteger;", "offset", NodeProps.MAX_HEIGHT, "normalAnimateBeginTime", "D", "fullScreenAnimationBeginTime", "actionIdArray", "[Ljava/lang/Integer;", "currentRenderCount", "I", "Landroid/graphics/PointF;", "mLastPanPoint", "Landroid/graphics/PointF;", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class DrawerBusinessScene extends AbsBusinessScene {
    public static final int ANIMATION_STATUS_FULL_SCREEN = 2;
    public static final int ANIMATION_STATUS_NORMAL = 0;
    public static final int ANIMATION_STATUS_PULLED = 1;
    private static final CameraParams BODY_TYPE_STRETCH_CAMERA;
    private static final CameraParams DEFAULT_CAMERA;
    public static final String TAG = "DrawerBusinessScene";
    private static boolean mIsBodyTypeStretch;
    private int currentRenderCount;
    private com.tencent.filament.zplan.animation.b defaultAnimationTrackGroup;
    private double fullScreenAnimationBeginTime;
    private com.tencent.filament.zplan.animation.b fullScreenAnimationTrackGroup;
    private PointF mLastPanPoint;
    private double normalAnimateBeginTime;
    private com.tencent.filament.zplan.animation.b pulledAnimationTrackGroup;
    private AtomicInteger animationStatus = new AtomicInteger(0);
    private AtomicInteger offset = new AtomicInteger(0);
    private AtomicInteger maxHeight = new AtomicInteger(0);
    private final Integer[] actionIdArray = {501, 502, 506, 601};

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f335584a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f335585b;

        static {
            int[] iArr = new int[TouchEventType.values().length];
            try {
                iArr[TouchEventType.Pan.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f335584a = iArr;
            int[] iArr2 = new int[TouchEventState.values().length];
            try {
                iArr2[TouchEventState.Began.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            f335585b = iArr2;
        }
    }

    static {
        CameraParams cameraParams = new CameraParams(null, null, null, null, null, 31, null);
        Exposure exposure = new Exposure(0, 0.0d, 0.0d, 7, null);
        exposure.setAperture(16);
        exposure.setSensitivity(100.0d);
        exposure.setShutterSpeed(0.008d);
        cameraParams.setExposure(exposure);
        LookAt lookAt = new LookAt(null, null, null, 7, null);
        lookAt.setEye(new float[]{0.0f, 1.35f, 8.3f});
        lookAt.setTarget(new float[]{0.0f, 0.64f, 0.0f});
        lookAt.setUpward(new float[]{0.0f, 1.0f, 0.0f});
        cameraParams.setLookAt(lookAt);
        LensProjection lensProjection = new LensProjection(0.0f, 0.0f, 0, 0.0f, 15, null);
        lensProjection.setAspect(0.75f);
        lensProjection.setFar(1000.0f);
        lensProjection.setFocalLength(120);
        lensProjection.setNear(0.05f);
        cameraParams.setLensProjection(lensProjection);
        BODY_TYPE_STRETCH_CAMERA = cameraParams;
        CameraParams cameraParams2 = new CameraParams(null, null, null, null, null, 31, null);
        cameraParams2.setExposure(new Exposure(0, 0.0d, 0.0d, 7, null));
        LookAt lookAt2 = new LookAt(null, null, null, 7, null);
        lookAt2.setEye(new float[]{0.0f, 1.0f, 7.7f});
        lookAt2.setTarget(new float[]{0.0f, 0.64f, 0.0f});
        lookAt2.setUpward(new float[]{0.0f, 1.0f, 0.0f});
        cameraParams2.setLookAt(lookAt2);
        cameraParams2.setLensProjection(new LensProjection(0.0f, 0.0f, 0, 0.0f, 15, null));
        DEFAULT_CAMERA = cameraParams2;
    }

    private final void changeAnimationStatus(int status) {
        if (this.animationStatus.get() == status) {
            return;
        }
        this.animationStatus.set(status);
        if (status == 0) {
            this.normalAnimateBeginTime = 0.0d;
            resetRotate();
        } else {
            if (status != 2) {
                return;
            }
            this.fullScreenAnimationBeginTime = 0.0d;
        }
    }

    private final LightsParams getLightsParams() {
        List mutableListOf;
        boolean b16 = com.tencent.biz.qui.quicommon.a.b(ContextCompat.getColor(BaseApplication.context, R.color.qui_common_bg_bottom_standard));
        QLog.i(TAG, 1, "getSceneConfig, darkMode: " + b16);
        SpotLight spotLight = new SpotLight(null, null, null, null, 0.0f, 0.0d, 0, 0, false, 511, null);
        spotLight.setKey("spotLightl");
        spotLight.setCastShadows(false);
        if (b16) {
            spotLight.setPosition(new float[]{1.017f, 1.017f, 0.905f});
            spotLight.setDirection(new float[]{-0.61f, 0.281f, -0.741f});
            spotLight.setColor(new float[]{0.8f, 0.8f, 1.0f});
            spotLight.setIntensity(3380.0f);
            spotLight.setFalloff(5.0d);
            spotLight.setInnerCone(30);
            spotLight.setOuterCone(50);
        } else {
            spotLight.setPosition(new float[]{1.017f, 1.017f, 0.905f});
            spotLight.setDirection(new float[]{-0.61f, 0.281f, -0.741f});
            spotLight.setColor(new float[]{0.8f, 0.8f, 1.0f});
            spotLight.setIntensity(123380.0f);
            spotLight.setFalloff(10.0d);
            spotLight.setInnerCone(10);
            spotLight.setOuterCone(50);
        }
        SpotLight spotLight2 = new SpotLight(null, null, null, null, 0.0f, 0.0d, 0, 0, false, 511, null);
        spotLight2.setKey("spotLight2");
        spotLight2.setCastShadows(false);
        if (b16) {
            spotLight2.setPosition(new float[]{0.152f, 0.273f, -1.897f});
            spotLight2.setDirection(new float[]{-0.307f, -0.237f, 0.922f});
            spotLight2.setColor(new float[]{0.5f, 0.5f, 1.0f});
            spotLight2.setIntensity(4833.0f);
            spotLight2.setFalloff(30.0d);
            spotLight2.setInnerCone(10);
            spotLight2.setOuterCone(40);
        } else {
            spotLight2.setKey("spotLight2");
            spotLight2.setPosition(new float[]{0.152f, 0.273f, -1.897f});
            spotLight2.setDirection(new float[]{-0.307f, -0.237f, 0.922f});
            spotLight2.setColor(new float[]{0.5f, 0.5f, 1.0f});
            spotLight2.setIntensity(48330.0f);
            spotLight2.setFalloff(30.0d);
            spotLight2.setInnerCone(10);
            spotLight2.setOuterCone(40);
        }
        Directional directional = new Directional(null, 0, 0.0f, null, false, 31, null);
        directional.setCastShadows(true);
        if (b16) {
            directional.setColor(new float[]{0.95f, 0.94f, 0.85f});
            directional.setIntensity(35000.0f);
            directional.setDirection(new float[]{-0.45f, -0.31f, -0.86f});
        } else {
            directional.setColor(new float[]{1.0f, 0.94f, 0.99f});
            directional.setIntensity(67000.0f);
            directional.setDirection(new float[]{0.5f, -0.246f, -0.856f});
        }
        IndirectLight indirectLight = new IndirectLight(null, 0.0f, 3, null);
        indirectLight.setIntensity(b16 ? 2000.0f : 5000.0f);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(spotLight, spotLight2);
        return new LightsParams(directional, indirectLight, mutableListOf);
    }

    private final void handlePanEvent(TouchEvent event) {
        if (b.f335585b[event.getState().ordinal()] == 1) {
            this.mLastPanPoint = event.getLocation();
            return;
        }
        PointF pointF = this.mLastPanPoint;
        if (pointF == null) {
            return;
        }
        float f16 = event.getLocation().x - pointF.x;
        this.mLastPanPoint = event.getLocation();
        Intrinsics.checkNotNullExpressionValue(BaseApplication.getContext(), "getContext()");
        rotateAvatar((float) ((f16 / ((ScreenUtil.getRealHeight(r5) / 7) * 4)) * 3.141592653589793d));
    }

    private final void loadAvatarAnimation(DrawerAnimationModel animationResource) {
        ZPlanAction breathAction = animationResource.getBreathAction();
        this.defaultAnimationTrackGroup = trackGroupWithAnimations(new ZPlanAction[]{breathAction, breathAction, breathAction, animationResource.getStretchAction()});
        this.pulledAnimationTrackGroup = trackGroupWithAnimations(new ZPlanAction[]{animationResource.getRefreshAction()});
        this.fullScreenAnimationTrackGroup = trackGroupWithAnimations(new ZPlanAction[]{animationResource.getStandBreathAction()});
    }

    private final void rotateAvatar(final float angle) {
        final FilamentViewerV2 viewerV2 = getViewerV2();
        if (viewerV2 != null) {
            doTask("resetRotation", new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.sharedengine.drawer.DrawerBusinessScene$rotateAvatar$1$1
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
                    FilamentViewerV2.this.rotateAvatar(new RotateParam(0.0f, 1.0f, 0.0f, angle));
                }
            });
        }
    }

    private final com.tencent.filament.zplan.animation.b trackGroupWithAnimations(ZPlanAction[] animations) {
        Object first;
        Object first2;
        FilamentViewerV2 viewerV2 = getViewerV2();
        if (viewerV2 == null) {
            return null;
        }
        com.tencent.filament.zplan.animation.b bVar = new com.tencent.filament.zplan.animation.b();
        com.tencent.filament.zplan.animation.a aVar = new com.tencent.filament.zplan.animation.a();
        com.tencent.filament.zplan.animation.a aVar2 = new com.tencent.filament.zplan.animation.a();
        for (ZPlanAction zPlanAction : animations) {
            FilamentAnimation[] loadAnimation$default = FilamentViewerV2.loadAnimation$default(viewerV2, zPlanAction.getFaceAnimationGltfPath(), null, 2, null);
            if (!(loadAnimation$default.length == 0)) {
                first2 = ArraysKt___ArraysKt.first(loadAnimation$default);
                aVar.a((FilamentAnimation) first2);
            }
            FilamentAnimation[] loadAnimation$default2 = FilamentViewerV2.loadAnimation$default(viewerV2, zPlanAction.getBodyAnimationGltfPath(), null, 2, null);
            if (!(loadAnimation$default2.length == 0)) {
                first = ArraysKt___ArraysKt.first(loadAnimation$default2);
                aVar2.a((FilamentAnimation) first);
            }
        }
        bVar.a(aVar);
        bVar.a(aVar2);
        return bVar;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    public com.tencent.filament.zplan.business.api.a animate(double now, c zplanSpanContext) {
        FilamentViewerV2 viewerV2;
        FilamentViewerV2 viewerV22;
        double d16 = 0.0d;
        if (!getFirstRenderEnd().get()) {
            com.tencent.filament.zplan.animation.b bVar = this.defaultAnimationTrackGroup;
            if (bVar != null && (viewerV22 = getViewerV2()) != null) {
                viewerV22.playAnimationWithTrackGroup(bVar, 0.0d);
            }
            return null;
        }
        int i3 = this.animationStatus.get();
        if (i3 == 0) {
            com.tencent.filament.zplan.animation.b bVar2 = this.defaultAnimationTrackGroup;
            if (bVar2 != null) {
                double d17 = this.normalAnimateBeginTime;
                if (d17 == 0.0d) {
                    this.normalAnimateBeginTime = now;
                } else {
                    d16 = now - d17;
                }
                FilamentViewerV2 viewerV23 = getViewerV2();
                if (viewerV23 != null) {
                    viewerV23.playAnimationWithTrackGroup(bVar2, d16);
                }
            }
        } else if (i3 == 1) {
            com.tencent.filament.zplan.animation.b bVar3 = this.pulledAnimationTrackGroup;
            if (bVar3 != null) {
                double b16 = bVar3.b();
                double min = Math.min(this.offset.get(), this.maxHeight.get()) / this.maxHeight.get();
                if (min < 1.0d && (viewerV2 = getViewerV2()) != null) {
                    viewerV2.playAnimationWithTrackGroup(bVar3, min * b16);
                }
            }
        } else if (i3 != 2) {
            FLog.INSTANCE.e(TAG, "can't process this status. status: " + this.animationStatus.get());
        } else {
            com.tencent.filament.zplan.animation.b bVar4 = this.fullScreenAnimationTrackGroup;
            if (bVar4 != null) {
                double d18 = this.fullScreenAnimationBeginTime;
                if (d18 == 0.0d) {
                    this.fullScreenAnimationBeginTime = now;
                } else {
                    d16 = now - d18;
                }
                double b17 = bVar4.b();
                if (d16 >= b17) {
                    d16 %= b17;
                }
                FilamentViewerV2 viewerV24 = getViewerV2();
                if (viewerV24 != null) {
                    viewerV24.playAnimationWithTrackGroup(bVar4, d16);
                }
            }
        }
        return null;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    /* renamed from: canRender */
    public boolean getCanRender() {
        return this.defaultAnimationTrackGroup != null;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public boolean enablePelvisOffset() {
        i iVar = (i) ((IZPlanQQMC) QRoute.api(IZPlanQQMC.class)).getConfig("100195", i.class, "");
        if (iVar == null) {
            iVar = new i();
        }
        return iVar.getEnableFilamentDrawerShadow();
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public boolean enablePlanarShadow() {
        i iVar = (i) ((IZPlanQQMC) QRoute.api(IZPlanQQMC.class)).getConfig("100195", i.class, "");
        if (iVar == null) {
            iVar = new i();
        }
        return iVar.getEnableFilamentDrawerShadow();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0059 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object fetchAvatarInfo(AbsBusinessScene.FetchAvatarInfoFrom fetchAvatarInfoFrom, Continuation<? super JSONObject> continuation) {
        DrawerBusinessScene$fetchAvatarInfo$1 drawerBusinessScene$fetchAvatarInfo$1;
        Object coroutine_suspended;
        int i3;
        JSONObject jSONObject;
        if (continuation instanceof DrawerBusinessScene$fetchAvatarInfo$1) {
            drawerBusinessScene$fetchAvatarInfo$1 = (DrawerBusinessScene$fetchAvatarInfo$1) continuation;
            int i16 = drawerBusinessScene$fetchAvatarInfo$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                drawerBusinessScene$fetchAvatarInfo$1.label = i16 - Integer.MIN_VALUE;
                Object obj = drawerBusinessScene$fetchAvatarInfo$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = drawerBusinessScene$fetchAvatarInfo$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IZPlanAvatarInfoHelper iZPlanAvatarInfoHelper = (IZPlanAvatarInfoHelper) QRoute.api(IZPlanAvatarInfoHelper.class);
                    drawerBusinessScene$fetchAvatarInfo$1.label = 1;
                    obj = iZPlanAvatarInfoHelper.fetchMyAvatarInfo(drawerBusinessScene$fetchAvatarInfo$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                jSONObject = (JSONObject) obj;
                if (jSONObject == null) {
                    return jSONObject;
                }
                QLog.e(TAG, 1, "fetchAvatarInfo fail.");
                return new JSONObject();
            }
        }
        drawerBusinessScene$fetchAvatarInfo$1 = new DrawerBusinessScene$fetchAvatarInfo$1(this, continuation);
        Object obj2 = drawerBusinessScene$fetchAvatarInfo$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = drawerBusinessScene$fetchAvatarInfo$1.label;
        if (i3 != 0) {
        }
        jSONObject = (JSONObject) obj2;
        if (jSONObject == null) {
        }
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public FetchActionData[] getActionDataArray(EnumUserGender gender) {
        Intrinsics.checkNotNullParameter(gender, "gender");
        Integer[] numArr = this.actionIdArray;
        ArrayList arrayList = new ArrayList(numArr.length);
        for (Integer num : numArr) {
            arrayList.add(new FetchActionData(num.intValue(), null, null, 6, null));
        }
        Object[] array = arrayList.toArray(new FetchActionData[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (FetchActionData[]) array;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public CameraParams getBodyTypeCamera(String bodyTypeName) {
        if (Intrinsics.areEqual(bodyTypeName, "BoyStretchConfig") ? true : Intrinsics.areEqual(bodyTypeName, "GirlStretchConfig")) {
            FLog.INSTANCE.i(TAG, "setCamera success, bodyTypeName:" + bodyTypeName);
            return BODY_TYPE_STRETCH_CAMERA;
        }
        FLog.INSTANCE.i(TAG, "use default bodyType. bodyTypeName: " + bodyTypeName);
        return DEFAULT_CAMERA;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public LightsParams getLightConfigAfterThemeChange() {
        return getLightsParams();
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public String getSceneConfig() {
        mIsBodyTypeStretch = Intrinsics.areEqual("BoyStretchConfig", getBodyTypeName()) || Intrinsics.areEqual("BoyStretchConfig", getBodyTypeName());
        CameraParams bodyTypeCamera = getBodyTypeCamera(getBodyTypeName());
        String json = new Gson().toJson(new BusinessSceneConfig(bodyTypeCamera == null ? new CameraParams(null, null, null, null, null, 31, null) : bodyTypeCamera, null, getLightsParams(), 2, null));
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(businessSceneConfig)");
        return json;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    public SceneType getSceneType() {
        return SceneType.DRAWER;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public void loadAnimation(ZPlanAction[] actionArray, c zplanSpanContext) {
        Intrinsics.checkNotNullParameter(actionArray, "actionArray");
        if (actionArray.length != this.actionIdArray.length) {
            return;
        }
        loadAvatarAnimation(new DrawerAnimationModel(actionArray[0], actionArray[1], actionArray[2], actionArray[3]));
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public boolean needApplyShoesHeight() {
        return false;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    public void processDispatchEvent(String event, String eventData, c zplanSpanContext) {
        TouchEvent touchEvent;
        Intrinsics.checkNotNullParameter(event, "event");
        super.processDispatchEvent(event, eventData, zplanSpanContext);
        int hashCode = event.hashCode();
        if (hashCode == -1934624373) {
            if (event.equals("DrawerPageAvatar.onPlayStateChanged") && eventData != null) {
                try {
                    changeAnimationStatus(new JSONObject(eventData).getInt("status"));
                    return;
                } catch (JSONException e16) {
                    FLog.INSTANCE.e(TAG, "parse eventData fail.", e16);
                    return;
                }
            }
            return;
        }
        if (hashCode != -19988224) {
            if (hashCode == 1719579098 && event.equals("onTouchEvent")) {
                try {
                    touchEvent = (TouchEvent) new Gson().fromJson(eventData, TouchEvent.class);
                } catch (Exception e17) {
                    QLog.e(TAG, 1, "onEvent TOUCH_EVENT", e17);
                    touchEvent = null;
                }
                if (touchEvent == null) {
                    return;
                }
                if (b.f335584a[touchEvent.getType().ordinal()] == 1) {
                    handlePanEvent(touchEvent);
                    return;
                }
                return;
            }
            return;
        }
        if (event.equals("DrawerPageAvatar.onScrollOffsetChanged") && eventData != null) {
            try {
                JSONObject jSONObject = new JSONObject(eventData);
                int i3 = jSONObject.getInt(NodeProps.MAX_HEIGHT);
                int i16 = jSONObject.getInt("offset");
                this.maxHeight.set(i3);
                this.offset.set(i16);
            } catch (JSONException e18) {
                FLog.INSTANCE.e(TAG, "parse eventData fail.", e18);
            }
        }
    }

    private final void resetRotate() {
        QLog.i(TAG, 1, "resetRotate");
        final FilamentViewerV2 viewerV2 = getViewerV2();
        if (viewerV2 != null) {
            doTask("resetRotation", new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.sharedengine.drawer.DrawerBusinessScene$resetRotate$1$1
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
                    FilamentViewerV2.this.resetRotation();
                }
            });
        }
    }

    public final void resetAnim() {
        this.normalAnimateBeginTime = 0.0d;
        getFirstRenderEnd().set(false);
        this.defaultAnimationTrackGroup = null;
        this.pulledAnimationTrackGroup = null;
    }
}
