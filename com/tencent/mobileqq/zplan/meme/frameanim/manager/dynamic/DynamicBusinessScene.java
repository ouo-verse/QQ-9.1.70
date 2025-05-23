package com.tencent.mobileqq.zplan.meme.frameanim.manager.dynamic;

import com.google.gson.Gson;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.filament.zplan.animation.FilamentAnimation;
import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.animation.a;
import com.tencent.filament.zplan.animation.b;
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
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.zplan.resource.api.impl.ZPlanAvatarInfoHelperImpl;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.avatar.filament.IDynamicBusinessScene;
import com.tencent.zplan.zplantracing.c;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import rx4.DynamicAnimationModel;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0016\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001BB\u0007\u00a2\u0006\u0004\b?\u0010@J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001f\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001e\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0014\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\b\u0010$\u001a\u00020 H\u0016J\b\u0010&\u001a\u00020%H\u0016J\n\u0010'\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010*\u001a\u00020\t2\u0006\u0010(\u001a\u00020 2\b\u0010)\u001a\u0004\u0018\u00010 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010+\u001a\u00020\u0003H\u0016J\b\u0010,\u001a\u00020\u0003H\u0016J\u001c\u00100\u001a\u0004\u0018\u00010/2\u0006\u0010.\u001a\u00020-2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u00101\u001a\u00020\tH\u0016R\u0018\u00102\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00104\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00103R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00107R\u0016\u00109\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0016\u0010:\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020<0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/frameanim/manager/dynamic/DynamicBusinessScene;", "Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene;", "Lcom/tencent/sqshow/zootopia/avatar/filament/IDynamicBusinessScene;", "", "nightMode", "Lcom/tencent/filament/zplan/avatar/LightsParams;", "getLightParamsByTheme", "Lrx4/a;", "animationResource", "", "loadAvatarAnimation", "", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "animations", "Lcom/tencent/filament/zplan/animation/b;", "trackGroupWithAnimations", "([Lcom/tencent/filament/zplan/animation/ZPlanAction;)Lcom/tencent/filament/zplan/animation/b;", "Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene$FetchAvatarInfoFrom;", "from", "Lorg/json/JSONObject;", "fetchAvatarInfo", "(Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene$FetchAvatarInfoFrom;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "gender", "Lcom/tencent/filament/zplan/data/FetchActionData;", "getActionDataArray", "(Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;)[Lcom/tencent/filament/zplan/data/FetchActionData;", "actionArray", "Lcom/tencent/zplan/zplantracing/c;", "zplanSpanContext", "loadAnimation", "([Lcom/tencent/filament/zplan/animation/ZPlanAction;Lcom/tencent/zplan/zplantracing/c;)V", "", "bodyTypeName", "Lcom/tencent/filament/zplan/avatar/CameraParams;", "getBodyTypeCamera", "getSceneConfig", "Lcom/tencent/filament/zplan/business/api/SceneType;", "getSceneType", "getLightConfigAfterThemeChange", "event", "eventData", "processDispatchEvent", "needApplyShoesHeight", "canRender", "", "now", "Lcom/tencent/filament/zplan/business/api/a;", "animate", "resetAnim", "defaultAnimationTrackGroup", "Lcom/tencent/filament/zplan/animation/b;", "pulledAnimationTrackGroup", "Ljava/util/concurrent/atomic/AtomicInteger;", "animationStatus", "Ljava/util/concurrent/atomic/AtomicInteger;", "offset", NodeProps.MAX_HEIGHT, "animateBeginTime", "D", "", "actionIdArray", "[Ljava/lang/Integer;", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class DynamicBusinessScene extends AbsBusinessScene implements IDynamicBusinessScene {
    public static final int ANIMATION_STATUS_NORMAL = 0;
    public static final int ANIMATION_STATUS_PULLED = 1;
    private static final CameraParams BODY_TYPE_DEFAULT_CAMERA;
    private static final CameraParams BODY_TYPE_STRETCH_CAMERA;
    public static final String TAG = "DynamicBusinessScene";
    private double animateBeginTime;
    private b defaultAnimationTrackGroup;
    private b pulledAnimationTrackGroup;
    private AtomicInteger animationStatus = new AtomicInteger(0);
    private AtomicInteger offset = new AtomicInteger(0);
    private AtomicInteger maxHeight = new AtomicInteger(0);
    private final Integer[] actionIdArray = {501, 502, 506};

    static {
        CameraParams cameraParams = new CameraParams(null, null, null, null, null, 31, null);
        Exposure exposure = new Exposure(0, 0.0d, 0.0d, 7, null);
        exposure.setAperture(16);
        exposure.setSensitivity(100.0d);
        exposure.setShutterSpeed(0.008d);
        cameraParams.setExposure(exposure);
        LookAt lookAt = new LookAt(null, null, null, 7, null);
        lookAt.setEye(new float[]{0.0f, 1.35f, 6.7f});
        lookAt.setTarget(new float[]{0.0f, 0.807f, 0.0f});
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
        cameraParams2.setLensProjection(new LensProjection(0.0f, 0.0f, 0, 0.0f, 15, null));
        BODY_TYPE_DEFAULT_CAMERA = cameraParams2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ Object fetchAvatarInfo$suspendImpl(DynamicBusinessScene dynamicBusinessScene, AbsBusinessScene.FetchAvatarInfoFrom fetchAvatarInfoFrom, Continuation<? super JSONObject> continuation) {
        DynamicBusinessScene$fetchAvatarInfo$1 dynamicBusinessScene$fetchAvatarInfo$1;
        Object coroutine_suspended;
        int i3;
        JSONObject jSONObject;
        if (continuation instanceof DynamicBusinessScene$fetchAvatarInfo$1) {
            dynamicBusinessScene$fetchAvatarInfo$1 = (DynamicBusinessScene$fetchAvatarInfo$1) continuation;
            int i16 = dynamicBusinessScene$fetchAvatarInfo$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                dynamicBusinessScene$fetchAvatarInfo$1.label = i16 - Integer.MIN_VALUE;
                Object obj = dynamicBusinessScene$fetchAvatarInfo$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = dynamicBusinessScene$fetchAvatarInfo$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ZPlanAvatarInfoHelperImpl.Companion companion = ZPlanAvatarInfoHelperImpl.INSTANCE;
                    dynamicBusinessScene$fetchAvatarInfo$1.label = 1;
                    obj = companion.fetchMyAvatarInfo(dynamicBusinessScene$fetchAvatarInfo$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            jSONObject = (JSONObject) obj;
                            if (jSONObject == null) {
                                QLog.e(TAG, 1, "fetchAvatarInfo fail.");
                            }
                            return jSONObject == null ? new JSONObject() : jSONObject;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                jSONObject = (JSONObject) obj;
                if (jSONObject == null) {
                    ZPlanAvatarInfoHelperImpl.Companion companion2 = ZPlanAvatarInfoHelperImpl.INSTANCE;
                    dynamicBusinessScene$fetchAvatarInfo$1.label = 2;
                    obj = companion2.fetchMyAvatarInfo(dynamicBusinessScene$fetchAvatarInfo$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    jSONObject = (JSONObject) obj;
                }
                if (jSONObject == null) {
                }
                if (jSONObject == null) {
                }
            }
        }
        dynamicBusinessScene$fetchAvatarInfo$1 = new DynamicBusinessScene$fetchAvatarInfo$1(dynamicBusinessScene, continuation);
        Object obj2 = dynamicBusinessScene$fetchAvatarInfo$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = dynamicBusinessScene$fetchAvatarInfo$1.label;
        if (i3 != 0) {
        }
        jSONObject = (JSONObject) obj2;
        if (jSONObject == null) {
        }
        if (jSONObject == null) {
        }
        if (jSONObject == null) {
        }
    }

    private final void loadAvatarAnimation(DynamicAnimationModel animationResource) {
        ZPlanAction breathAction = animationResource.getBreathAction();
        this.defaultAnimationTrackGroup = trackGroupWithAnimations(new ZPlanAction[]{breathAction, breathAction, breathAction, animationResource.getStretchAction()});
        this.pulledAnimationTrackGroup = trackGroupWithAnimations(new ZPlanAction[]{animationResource.getRefreshAction()});
    }

    private final b trackGroupWithAnimations(ZPlanAction[] animations) {
        Object first;
        Object first2;
        FilamentViewerV2 viewerV2 = getViewerV2();
        if (viewerV2 == null) {
            return null;
        }
        b bVar = new b();
        a aVar = new a();
        a aVar2 = new a();
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
            b bVar = this.defaultAnimationTrackGroup;
            if (bVar != null && (viewerV22 = getViewerV2()) != null) {
                viewerV22.playAnimationWithTrackGroup(bVar, 0.0d);
            }
            return null;
        }
        int i3 = this.animationStatus.get();
        if (i3 == 0) {
            b bVar2 = this.defaultAnimationTrackGroup;
            if (bVar2 != null) {
                double d17 = this.animateBeginTime;
                if (d17 == 0.0d) {
                    this.animateBeginTime = now;
                } else {
                    d16 = now - d17;
                }
                FilamentViewerV2 viewerV23 = getViewerV2();
                if (viewerV23 != null) {
                    viewerV23.playAnimationWithTrackGroup(bVar2, d16);
                }
            }
        } else if (i3 != 1) {
            FLog.INSTANCE.e(TAG, "can't process this status. status: " + this.animationStatus.get());
        } else {
            b bVar3 = this.pulledAnimationTrackGroup;
            if (bVar3 != null) {
                double b16 = bVar3.b();
                double min = Math.min(this.offset.get(), this.maxHeight.get()) / this.maxHeight.get();
                if (min < 1.0d && (viewerV2 = getViewerV2()) != null) {
                    viewerV2.playAnimationWithTrackGroup(bVar3, min * b16);
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
    public Object fetchAvatarInfo(AbsBusinessScene.FetchAvatarInfoFrom fetchAvatarInfoFrom, Continuation<? super JSONObject> continuation) {
        return fetchAvatarInfo$suspendImpl(this, fetchAvatarInfoFrom, continuation);
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
        return BODY_TYPE_DEFAULT_CAMERA;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public LightsParams getLightConfigAfterThemeChange() {
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
        QLog.i(TAG, 1, "getLightConfigAfterThemeChange, nightMode: " + isNowThemeIsNight);
        return getLightParamsByTheme(isNowThemeIsNight);
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public String getSceneConfig() {
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
        QLog.i(TAG, 1, "getSceneConfig, nightMode: " + isNowThemeIsNight);
        CameraParams bodyTypeCamera = getBodyTypeCamera(getBodyTypeName());
        LightsParams lightParamsByTheme = getLightParamsByTheme(isNowThemeIsNight);
        if (bodyTypeCamera == null) {
            bodyTypeCamera = new CameraParams(null, null, null, null, null, 31, null);
        }
        String json = new Gson().toJson(new BusinessSceneConfig(bodyTypeCamera, null, lightParamsByTheme, 2, null));
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(businessSceneConfig)");
        return json;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    public SceneType getSceneType() {
        return SceneType.DYNAMIC;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public void loadAnimation(ZPlanAction[] actionArray, c zplanSpanContext) {
        Intrinsics.checkNotNullParameter(actionArray, "actionArray");
        if (actionArray.length != this.actionIdArray.length) {
            return;
        }
        loadAvatarAnimation(new DynamicAnimationModel(actionArray[0], actionArray[1], actionArray[2]));
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public boolean needApplyShoesHeight() {
        return false;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    public void processDispatchEvent(String event, String eventData, c zplanSpanContext) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, "DynamicPageAvatar.onScrollOffsetChanged")) {
            if (QLog.isDevelopLevel()) {
                QLog.i(TAG, 2, "onEvent. event: " + event + ", eventData: " + eventData);
            }
        } else {
            QLog.i(TAG, 2, "onEvent. event: " + event + ", eventData: " + eventData);
        }
        super.processDispatchEvent(event, eventData, zplanSpanContext);
        if (Intrinsics.areEqual(event, "DynamicPageAvatar.onPlayStateChanged")) {
            if (eventData == null) {
                return;
            }
            try {
                this.animationStatus.set(new JSONObject(eventData).getInt("status"));
                return;
            } catch (JSONException e16) {
                QLog.i(TAG, 1, "parse eventData fail.", e16);
                return;
            }
        }
        if (!Intrinsics.areEqual(event, "DynamicPageAvatar.onScrollOffsetChanged")) {
            FLog.INSTANCE.e(TAG, "can't process this event. event: " + event + ", eventData: " + eventData);
            return;
        }
        if (eventData == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(eventData);
            int i3 = jSONObject.getInt(NodeProps.MAX_HEIGHT);
            int i16 = jSONObject.getInt("offset");
            this.maxHeight.set(i3);
            this.offset.set(i16);
        } catch (JSONException e17) {
            FLog.INSTANCE.e(TAG, "parse eventData fail.", e17);
        }
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.IDynamicBusinessScene
    public void resetAnim() {
        this.animateBeginTime = 0.0d;
        getFirstRenderEnd().set(false);
        this.defaultAnimationTrackGroup = null;
        this.pulledAnimationTrackGroup = null;
    }

    private final LightsParams getLightParamsByTheme(boolean nightMode) {
        List mutableListOf;
        List mutableListOf2;
        if (nightMode) {
            SpotLight spotLight = new SpotLight(null, null, null, null, 0.0f, 0.0d, 0, 0, false, 511, null);
            spotLight.setKey("spotLight1");
            spotLight.setPosition(new float[]{1.017f, 1.017f, 0.905f});
            spotLight.setDirection(new float[]{-0.61f, 0.281f, -0.741f});
            spotLight.setColor(new float[]{0.8f, 0.8f, 1.0f});
            spotLight.setIntensity(3380.0f);
            spotLight.setFalloff(5.0d);
            spotLight.setInnerCone(30);
            spotLight.setOuterCone(50);
            spotLight.setCastShadows(false);
            SpotLight spotLight2 = new SpotLight(null, null, null, null, 0.0f, 0.0d, 0, 0, false, 511, null);
            spotLight2.setKey("spotLight2");
            spotLight2.setPosition(new float[]{0.152f, 0.273f, -1.897f});
            spotLight2.setDirection(new float[]{-0.307f, -0.237f, 0.922f});
            spotLight2.setColor(new float[]{0.5f, 0.5f, 1.0f});
            spotLight2.setIntensity(4833.0f);
            spotLight2.setFalloff(30.0d);
            spotLight2.setInnerCone(10);
            spotLight2.setOuterCone(40);
            spotLight2.setCastShadows(false);
            Directional directional = new Directional(null, 0, 0.0f, null, false, 31, null);
            directional.setColor(new float[]{0.95f, 0.94f, 0.85f});
            directional.setIntensity(35000.0f);
            directional.setDirection(new float[]{-0.45f, -0.31f, -0.86f});
            directional.setCastShadows(true);
            IndirectLight indirectLight = new IndirectLight(null, 0.0f, 3, null);
            indirectLight.setIntensity(2000.0f);
            mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(spotLight, spotLight2);
            return new LightsParams(directional, indirectLight, mutableListOf2);
        }
        SpotLight spotLight3 = new SpotLight(null, null, null, null, 0.0f, 0.0d, 0, 0, false, 511, null);
        spotLight3.setKey("spotLight1");
        spotLight3.setPosition(new float[]{1.017f, 1.017f, 0.905f});
        spotLight3.setDirection(new float[]{-0.61f, 0.281f, -0.741f});
        spotLight3.setColor(new float[]{0.8f, 0.8f, 1.0f});
        spotLight3.setIntensity(123380.0f);
        spotLight3.setFalloff(10.0d);
        spotLight3.setInnerCone(10);
        spotLight3.setOuterCone(50);
        spotLight3.setCastShadows(false);
        SpotLight spotLight4 = new SpotLight(null, null, null, null, 0.0f, 0.0d, 0, 0, false, 511, null);
        spotLight4.setKey("spotLight2");
        spotLight4.setPosition(new float[]{0.152f, 0.273f, -1.897f});
        spotLight4.setDirection(new float[]{-0.307f, -0.237f, 0.922f});
        spotLight4.setColor(new float[]{0.5f, 0.5f, 1.0f});
        spotLight4.setIntensity(48330.0f);
        spotLight4.setFalloff(30.0d);
        spotLight4.setInnerCone(10);
        spotLight4.setOuterCone(40);
        spotLight4.setCastShadows(false);
        Directional directional2 = new Directional(null, 0, 0.0f, null, false, 31, null);
        directional2.setColor(new float[]{1.0f, 0.94f, 0.99f});
        directional2.setIntensity(67000.0f);
        directional2.setDirection(new float[]{0.5f, -0.246f, -0.856f});
        directional2.setCastShadows(true);
        IndirectLight indirectLight2 = new IndirectLight(null, 0.0f, 3, null);
        indirectLight2.setIntensity(5000.0f);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(spotLight3, spotLight4);
        return new LightsParams(directional2, indirectLight2, mutableListOf);
    }
}
