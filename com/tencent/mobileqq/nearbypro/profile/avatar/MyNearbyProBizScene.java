package com.tencent.mobileqq.nearbypro.profile.avatar;

import android.graphics.PointF;
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
import com.tencent.filament.zplan.business.impl.AbsBusinessScene;
import com.tencent.filament.zplan.data.FetchActionData;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplan.engine.js.FilamentEventDispatcher;
import com.tencent.filament.zplan.view.event.RotateParam;
import com.tencent.filament.zplan.view.event.TouchEvent;
import com.tencent.filament.zplan.view.event.TouchEventState;
import com.tencent.filament.zplan.view.event.TouchEventType;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.activity.qqsettingme.api.IThemeUtilApi;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.zplan.resource.api.IZPlanAvatarInfoHelper;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import wk3.i;

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 P2\u00020\u0001:\u0001QB\u0007\u00a2\u0006\u0004\bN\u0010OJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\u001f\u0010\u0013\u001a\u0004\u0018\u00010\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u001b\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u000f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020\u0015H\u0016J\b\u0010$\u001a\u00020\u0015H\u0016J'\u0010(\u001a\u00020\u00062\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016\u00a2\u0006\u0004\b(\u0010)J\u0014\u0010,\u001a\u0004\u0018\u00010+2\b\u0010*\u001a\u0004\u0018\u00010!H\u0016J\n\u0010-\u001a\u0004\u0018\u00010\u0002H\u0016J$\u00100\u001a\u00020\u00062\u0006\u0010.\u001a\u00020!2\b\u0010/\u001a\u0004\u0018\u00010!2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u000e\u00102\u001a\u00020\u00062\u0006\u0010.\u001a\u000201J\u001c\u00106\u001a\u0004\u0018\u0001052\u0006\u00104\u001a\u0002032\b\u0010'\u001a\u0004\u0018\u00010&H\u0016R\u0018\u00107\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u00109\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00108R\u0018\u0010:\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00108R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010=R\u0016\u0010?\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010=R\u0016\u0010@\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010AR\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020\t0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR$\u0010E\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0018\u0010L\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010M\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/profile/avatar/MyNearbyProBizScene;", "Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene;", "Lcom/tencent/filament/zplan/avatar/LightsParams;", "getLightsParams", "", "angle", "", "rotateAvatar", "resetRotate", "", "status", "changeAnimationStatus", "Lcom/tencent/mobileqq/nearbypro/profile/avatar/b;", "animationResource", "loadAvatarAnimation", "", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "animations", "Lcom/tencent/filament/zplan/animation/b;", "trackGroupWithAnimations", "([Lcom/tencent/filament/zplan/animation/ZPlanAction;)Lcom/tencent/filament/zplan/animation/b;", "", "needApplyShoesHeight", "Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene$FetchAvatarInfoFrom;", "from", "Lorg/json/JSONObject;", "fetchAvatarInfo", "(Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene$FetchAvatarInfoFrom;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "gender", "Lcom/tencent/filament/zplan/data/FetchActionData;", "getActionDataArray", "(Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;)[Lcom/tencent/filament/zplan/data/FetchActionData;", "", "getSceneConfig", "enablePlanarShadow", "enablePelvisOffset", "actionArray", "Lcom/tencent/zplan/zplantracing/c;", "zplanSpanContext", "loadAnimation", "([Lcom/tencent/filament/zplan/animation/ZPlanAction;Lcom/tencent/zplan/zplantracing/c;)V", "bodyTypeName", "Lcom/tencent/filament/zplan/avatar/CameraParams;", "getBodyTypeCamera", "getLightConfigAfterThemeChange", "event", "eventData", "processDispatchEvent", "Lcom/tencent/filament/zplan/view/event/TouchEvent;", "handlePanEvent", "", "now", "Lcom/tencent/filament/zplan/business/api/a;", "animate", "defaultAnimationTrackGroup", "Lcom/tencent/filament/zplan/animation/b;", "pulledAnimationTrackGroup", "fullScreenAnimationTrackGroup", "Ljava/util/concurrent/atomic/AtomicInteger;", "animationStatus", "Ljava/util/concurrent/atomic/AtomicInteger;", "offset", NodeProps.MAX_HEIGHT, "normalAnimateBeginTime", "D", "fullScreenAnimationBeginTime", "actionIdArray", "[Ljava/lang/Integer;", "avatarCharacter", "Lorg/json/JSONObject;", "getAvatarCharacter", "()Lorg/json/JSONObject;", "setAvatarCharacter", "(Lorg/json/JSONObject;)V", "Landroid/graphics/PointF;", "mLastPanPoint", "Landroid/graphics/PointF;", "<init>", "()V", "Companion", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public class MyNearbyProBizScene extends AbsBusinessScene {
    public static final int ANIMATION_STATUS_FULL_SCREEN = 2;
    public static final int ANIMATION_STATUS_NORMAL = 0;
    public static final int ANIMATION_STATUS_PULLED = 1;

    @NotNull
    private static final CameraParams BODY_TYPE_STRETCH_CAMERA;

    @NotNull
    public static final String CLICK = "CLICK";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final CameraParams DEFAULT_CAMERA;

    @NotNull
    public static final String TAG = "NBP.PersonalPart.NearbyProBizScene";
    private static boolean mIsBodyTypeStretch;

    @Nullable
    private JSONObject avatarCharacter;

    @Nullable
    private com.tencent.filament.zplan.animation.b defaultAnimationTrackGroup;
    private double fullScreenAnimationBeginTime;

    @Nullable
    private com.tencent.filament.zplan.animation.b fullScreenAnimationTrackGroup;

    @Nullable
    private PointF mLastPanPoint;
    private double normalAnimateBeginTime;

    @Nullable
    private com.tencent.filament.zplan.animation.b pulledAnimationTrackGroup;

    @NotNull
    private AtomicInteger animationStatus = new AtomicInteger(0);

    @NotNull
    private AtomicInteger offset = new AtomicInteger(0);

    @NotNull
    private AtomicInteger maxHeight = new AtomicInteger(0);

    @NotNull
    private final Integer[] actionIdArray = {501, 502, 506, 601};

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/profile/avatar/MyNearbyProBizScene$a;", "", "", "mIsBodyTypeStretch", "Z", "a", "()Z", "setMIsBodyTypeStretch", "(Z)V", "", "ANIMATION_STATUS_FULL_SCREEN", "I", "ANIMATION_STATUS_NORMAL", "ANIMATION_STATUS_PULLED", "", MyNearbyProBizScene.CLICK, "Ljava/lang/String;", "TAG", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.nearbypro.profile.avatar.MyNearbyProBizScene$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return MyNearbyProBizScene.mIsBodyTypeStretch;
        }

        Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f253718a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f253719b;

        static {
            int[] iArr = new int[TouchEventType.values().length];
            try {
                iArr[TouchEventType.Pan.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TouchEventType.Tap.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f253718a = iArr;
            int[] iArr2 = new int[TouchEventState.values().length];
            try {
                iArr2[TouchEventState.Began.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            f253719b = iArr2;
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
        if (status != 0) {
            if (status == 2) {
                this.fullScreenAnimationBeginTime = 0.0d;
            }
        } else {
            this.normalAnimateBeginTime = 0.0d;
            resetRotate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0062 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ Object fetchAvatarInfo$suspendImpl(MyNearbyProBizScene myNearbyProBizScene, AbsBusinessScene.FetchAvatarInfoFrom fetchAvatarInfoFrom, Continuation<? super JSONObject> continuation) {
        MyNearbyProBizScene$fetchAvatarInfo$1 myNearbyProBizScene$fetchAvatarInfo$1;
        Object coroutine_suspended;
        int i3;
        JSONObject jSONObject;
        if (continuation instanceof MyNearbyProBizScene$fetchAvatarInfo$1) {
            myNearbyProBizScene$fetchAvatarInfo$1 = (MyNearbyProBizScene$fetchAvatarInfo$1) continuation;
            int i16 = myNearbyProBizScene$fetchAvatarInfo$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                myNearbyProBizScene$fetchAvatarInfo$1.label = i16 - Integer.MIN_VALUE;
                Object obj = myNearbyProBizScene$fetchAvatarInfo$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = myNearbyProBizScene$fetchAvatarInfo$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    JSONObject jSONObject2 = myNearbyProBizScene.avatarCharacter;
                    if (jSONObject2 != null) {
                        return jSONObject2;
                    }
                    IZPlanAvatarInfoHelper iZPlanAvatarInfoHelper = (IZPlanAvatarInfoHelper) QRoute.api(IZPlanAvatarInfoHelper.class);
                    myNearbyProBizScene$fetchAvatarInfo$1.label = 1;
                    obj = iZPlanAvatarInfoHelper.fetchMyAvatarInfo(myNearbyProBizScene$fetchAvatarInfo$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                jSONObject = (JSONObject) obj;
                if (jSONObject != null) {
                    j.c().e(TAG, "fetchAvatarInfo fail.");
                    return new JSONObject();
                }
                return jSONObject;
            }
        }
        myNearbyProBizScene$fetchAvatarInfo$1 = new MyNearbyProBizScene$fetchAvatarInfo$1(myNearbyProBizScene, continuation);
        Object obj2 = myNearbyProBizScene$fetchAvatarInfo$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = myNearbyProBizScene$fetchAvatarInfo$1.label;
        if (i3 == 0) {
        }
        jSONObject = (JSONObject) obj2;
        if (jSONObject != null) {
        }
    }

    private final LightsParams getLightsParams() {
        float f16;
        List mutableListOf;
        boolean isInNightMode = ((IThemeUtilApi) QRoute.api(IThemeUtilApi.class)).isInNightMode(MobileQQ.sMobileQQ.peekAppRuntime());
        j.c().e(TAG, "getSceneConfig, nightMode: " + isInNightMode);
        SpotLight spotLight = new SpotLight(null, null, null, null, 0.0f, 0.0d, 0, 0, false, 511, null);
        spotLight.setKey("spotLight1");
        spotLight.setCastShadows(false);
        if (isInNightMode) {
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
        if (isInNightMode) {
            spotLight2.setPosition(new float[]{0.152f, 0.273f, -1.897f});
            spotLight2.setDirection(new float[]{-0.307f, -0.237f, 0.922f});
            spotLight2.setColor(new float[]{0.5f, 0.5f, 1.0f});
            spotLight2.setIntensity(4833.0f);
            spotLight2.setFalloff(30.0d);
            spotLight2.setInnerCone(10);
            spotLight2.setOuterCone(40);
        } else {
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
        if (isInNightMode) {
            directional.setColor(new float[]{0.95f, 0.94f, 0.85f});
            directional.setIntensity(35000.0f);
            directional.setDirection(new float[]{-0.45f, -0.31f, -0.86f});
        } else {
            directional.setColor(new float[]{1.0f, 0.94f, 0.99f});
            directional.setIntensity(67000.0f);
            directional.setDirection(new float[]{0.5f, -0.246f, -0.856f});
        }
        IndirectLight indirectLight = new IndirectLight(null, 0.0f, 3, null);
        if (isInNightMode) {
            f16 = 2000.0f;
        } else {
            f16 = 5000.0f;
        }
        indirectLight.setIntensity(f16);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(spotLight, spotLight2);
        return new LightsParams(directional, indirectLight, mutableListOf);
    }

    private final void loadAvatarAnimation(DrawerAnimationModel animationResource) {
        ZPlanAction breathAction = animationResource.getBreathAction();
        this.defaultAnimationTrackGroup = trackGroupWithAnimations(new ZPlanAction[]{breathAction, breathAction, breathAction, animationResource.getStretchAction()});
        this.pulledAnimationTrackGroup = trackGroupWithAnimations(new ZPlanAction[]{animationResource.getRefreshAction()});
        this.fullScreenAnimationTrackGroup = trackGroupWithAnimations(new ZPlanAction[]{animationResource.getStandBreathAction()});
    }

    private final void resetRotate() {
        j.c().e(TAG, "resetRotate");
        final FilamentViewerV2 viewerV2 = getViewerV2();
        if (viewerV2 != null) {
            doTask("resetRotation", new Function0<Unit>() { // from class: com.tencent.mobileqq.nearbypro.profile.avatar.MyNearbyProBizScene$resetRotate$2$1
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

    private final void rotateAvatar(final float angle) {
        final FilamentViewerV2 viewerV2 = getViewerV2();
        if (viewerV2 != null) {
            doTask("resetRotation", new Function0<Unit>() { // from class: com.tencent.mobileqq.nearbypro.profile.avatar.MyNearbyProBizScene$rotateAvatar$1$1
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
        boolean z16;
        boolean z17;
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
            if (loadAnimation$default.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                first2 = ArraysKt___ArraysKt.first(loadAnimation$default);
                aVar.a((FilamentAnimation) first2);
            }
            FilamentAnimation[] loadAnimation$default2 = FilamentViewerV2.loadAnimation$default(viewerV2, zPlanAction.getBodyAnimationGltfPath(), null, 2, null);
            if (loadAnimation$default2.length == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                first = ArraysKt___ArraysKt.first(loadAnimation$default2);
                aVar2.a((FilamentAnimation) first);
            }
        }
        bVar.a(aVar);
        bVar.a(aVar2);
        return bVar;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    @Nullable
    public com.tencent.filament.zplan.business.api.a animate(double now, @Nullable c zplanSpanContext) {
        FilamentViewerV2 viewerV2;
        com.tencent.filament.zplan.animation.b bVar;
        FilamentViewerV2 viewerV22;
        double d16 = 0.0d;
        if (!getFirstRenderEnd().get()) {
            if (this.animationStatus.get() == 2) {
                bVar = this.fullScreenAnimationTrackGroup;
            } else {
                bVar = this.defaultAnimationTrackGroup;
            }
            if (bVar != null && (viewerV22 = getViewerV2()) != null) {
                viewerV22.playAnimationWithTrackGroup(bVar, 0.0d);
            }
            return null;
        }
        int i3 = this.animationStatus.get();
        boolean z16 = false;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    FLog.INSTANCE.e(TAG, "can't process this status. status: " + this.animationStatus.get());
                } else {
                    com.tencent.filament.zplan.animation.b bVar2 = this.fullScreenAnimationTrackGroup;
                    if (bVar2 != null) {
                        double d17 = this.fullScreenAnimationBeginTime;
                        if (d17 == 0.0d) {
                            z16 = true;
                        }
                        if (z16) {
                            this.fullScreenAnimationBeginTime = now;
                        } else {
                            d16 = now - d17;
                        }
                        double b16 = bVar2.b();
                        if (d16 >= b16) {
                            d16 %= b16;
                        }
                        FilamentViewerV2 viewerV23 = getViewerV2();
                        if (viewerV23 != null) {
                            viewerV23.playAnimationWithTrackGroup(bVar2, d16);
                        }
                    }
                }
            } else {
                com.tencent.filament.zplan.animation.b bVar3 = this.pulledAnimationTrackGroup;
                if (bVar3 != null) {
                    double b17 = bVar3.b();
                    double min = Math.min(this.offset.get(), this.maxHeight.get()) / this.maxHeight.get();
                    if (min < 1.0d && (viewerV2 = getViewerV2()) != null) {
                        viewerV2.playAnimationWithTrackGroup(bVar3, min * b17);
                    }
                }
            }
        } else {
            com.tencent.filament.zplan.animation.b bVar4 = this.defaultAnimationTrackGroup;
            if (bVar4 != null) {
                double d18 = this.normalAnimateBeginTime;
                if (d18 == 0.0d) {
                    z16 = true;
                }
                if (z16) {
                    this.normalAnimateBeginTime = now;
                } else {
                    d16 = now - d18;
                }
                FilamentViewerV2 viewerV24 = getViewerV2();
                if (viewerV24 != null) {
                    viewerV24.playAnimationWithTrackGroup(bVar4, d16);
                }
            }
        }
        return null;
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

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    @Nullable
    public Object fetchAvatarInfo(@NotNull AbsBusinessScene.FetchAvatarInfoFrom fetchAvatarInfoFrom, @NotNull Continuation<? super JSONObject> continuation) {
        return fetchAvatarInfo$suspendImpl(this, fetchAvatarInfoFrom, continuation);
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    @Nullable
    public FetchActionData[] getActionDataArray(@NotNull EnumUserGender gender) {
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

    @Nullable
    public final JSONObject getAvatarCharacter() {
        return this.avatarCharacter;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    @Nullable
    public CameraParams getBodyTypeCamera(@Nullable String bodyTypeName) {
        boolean areEqual;
        if (Intrinsics.areEqual(bodyTypeName, "BoyStretchConfig")) {
            areEqual = true;
        } else {
            areEqual = Intrinsics.areEqual(bodyTypeName, "GirlStretchConfig");
        }
        if (areEqual) {
            FLog.INSTANCE.i(TAG, "setCamera success, bodyTypeName:" + bodyTypeName);
            return BODY_TYPE_STRETCH_CAMERA;
        }
        FLog.INSTANCE.i(TAG, "use default bodyType. bodyTypeName: " + bodyTypeName);
        return DEFAULT_CAMERA;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    @Nullable
    public LightsParams getLightConfigAfterThemeChange() {
        return getLightsParams();
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    @NotNull
    public String getSceneConfig() {
        boolean z16;
        CameraParams cameraParams;
        if (!Intrinsics.areEqual("BoyStretchConfig", getBodyTypeName()) && !Intrinsics.areEqual("BoyStretchConfig", getBodyTypeName())) {
            z16 = false;
        } else {
            z16 = true;
        }
        mIsBodyTypeStretch = z16;
        CameraParams bodyTypeCamera = getBodyTypeCamera(getBodyTypeName());
        if (bodyTypeCamera == null) {
            cameraParams = new CameraParams(null, null, null, null, null, 31, null);
        } else {
            cameraParams = bodyTypeCamera;
        }
        String json = new Gson().toJson(new BusinessSceneConfig(cameraParams, null, getLightsParams(), 2, null));
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(businessSceneConfig)");
        return json;
    }

    public final void handlePanEvent(@NotNull TouchEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (b.f253719b[event.getState().ordinal()] == 1) {
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

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public void loadAnimation(@NotNull ZPlanAction[] actionArray, @Nullable c zplanSpanContext) {
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
    public void processDispatchEvent(@NotNull String event, @Nullable String eventData, @Nullable c zplanSpanContext) {
        TouchEvent touchEvent;
        FilamentEventDispatcher dispatcher;
        Intrinsics.checkNotNullParameter(event, "event");
        super.processDispatchEvent(event, eventData, zplanSpanContext);
        int hashCode = event.hashCode();
        if (hashCode != -1934624373) {
            if (hashCode != -19988224) {
                if (hashCode == 1719579098 && event.equals("onTouchEvent")) {
                    try {
                        touchEvent = (TouchEvent) new Gson().fromJson(eventData, TouchEvent.class);
                    } catch (Exception unused) {
                        j.c().e(TAG, "onEvent TOUCH_EVENT");
                        touchEvent = null;
                    }
                    if (touchEvent == null) {
                        return;
                    }
                    int i3 = b.f253718a[touchEvent.getType().ordinal()];
                    if (i3 != 1) {
                        if (i3 == 2 && (dispatcher = getDispatcher()) != null) {
                            dispatcher.onEvent("onTouchEvent", CLICK);
                            return;
                        }
                        return;
                    }
                    handlePanEvent(touchEvent);
                    return;
                }
            } else if (event.equals("DrawerPageAvatar.onScrollOffsetChanged")) {
                if (eventData == null) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(eventData);
                    int i16 = jSONObject.getInt(NodeProps.MAX_HEIGHT);
                    int i17 = jSONObject.getInt("offset");
                    this.maxHeight.set(i16);
                    this.offset.set(i17);
                    return;
                } catch (JSONException e16) {
                    FLog.INSTANCE.e(TAG, "parse eventData fail.", e16);
                    return;
                }
            }
        } else if (event.equals("DrawerPageAvatar.onPlayStateChanged")) {
            if (eventData == null) {
                return;
            }
            try {
                changeAnimationStatus(new JSONObject(eventData).getInt("status"));
                return;
            } catch (JSONException e17) {
                FLog.INSTANCE.e(TAG, "parse eventData fail.", e17);
                return;
            }
        }
        FLog.INSTANCE.e(TAG, "can't process this event. event: " + event + ", eventData: " + eventData);
    }

    public final void setAvatarCharacter(@Nullable JSONObject jSONObject) {
        this.avatarCharacter = jSONObject;
    }
}
