package com.tencent.sqshow.sharedengine;

import android.graphics.Point;
import com.google.gson.Gson;
import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.CameraParams;
import com.tencent.filament.zplan.avatar.Exposure;
import com.tencent.filament.zplan.avatar.LensProjection;
import com.tencent.filament.zplan.avatar.LightsParams;
import com.tencent.filament.zplan.avatar.LookAt;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.business.api.IBusinessScene;
import com.tencent.filament.zplan.business.api.SceneType;
import com.tencent.filament.zplan.business.impl.AbsBusinessScene;
import com.tencent.filament.zplan.data.FetchActionData;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplan.engine.js.FilamentEventDispatcher;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.mobileqq.search.model.ac;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.sqshow.sharedengine.anim.state.PullDownAnimState;
import com.tencent.sqshow.zootopia.avatar.filament.IDynamicBusinessScene;
import com.tencent.sqshow.zootopia.avatar.filament.IPortalBusiness;
import com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper;
import com.tencent.sqshow.zootopia.avatar.filament.h;
import com.tencent.sqshow.zootopia.nativeui.data.CameraKey;
import com.tencent.zplan.zplantracing.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import r74.b;
import s74.a;
import uk0.e;
import vk0.d;

@Metadata(d1 = {"\u0000\u0084\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 |2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001}B\u0007\u00a2\u0006\u0004\bz\u0010{J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0001J\u0010\u0010\r\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u0011J\u0010\u0010\u0014\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0011J\u0013\u0010\u0017\u001a\u00020\u0007H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016\u00a2\u0006\u0004\b\"\u0010#J\u0014\u0010'\u001a\u0004\u0018\u00010&2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\n\u0010)\u001a\u0004\u0018\u00010(H\u0016J\b\u0010*\u001a\u00020$H\u0016J\b\u0010,\u001a\u00020+H\u0016J'\u00101\u001a\u00020\u00072\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0 2\b\u00100\u001a\u0004\u0018\u00010/H\u0016\u00a2\u0006\u0004\b1\u00102J\u0013\u00103\u001a\u00020\u0007H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b3\u0010\u0018J\b\u00105\u001a\u000204H\u0016J\u001c\u00109\u001a\u0004\u0018\u0001082\u0006\u00107\u001a\u0002062\b\u00100\u001a\u0004\u0018\u00010/H\u0016J$\u0010<\u001a\u00020\u00072\u0006\u0010:\u001a\u00020$2\b\u0010;\u001a\u0004\u0018\u00010$2\b\u00100\u001a\u0004\u0018\u00010/H\u0016J\b\u0010=\u001a\u000204H\u0016J\b\u0010>\u001a\u000204H\u0016J\b\u0010?\u001a\u000204H\u0016J\b\u0010@\u001a\u000204H\u0016J\b\u0010A\u001a\u00020\u001bH\u0016J\b\u0010B\u001a\u000204H\u0016J\u0012\u0010E\u001a\u00020\u00072\b\u0010D\u001a\u0004\u0018\u00010CH\u0016J\u0012\u0010H\u001a\u00020\u00072\b\u0010G\u001a\u0004\u0018\u00010FH\u0016J\u0012\u0010K\u001a\u00020\u00072\b\u0010J\u001a\u0004\u0018\u00010IH\u0016J\u0010\u0010M\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020LH\u0016J\b\u0010N\u001a\u00020\u0007H\u0016J\b\u0010O\u001a\u000204H\u0016J\b\u0010P\u001a\u000204H\u0016J\u0012\u0010R\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010QH\u0016J\u0010\u0010U\u001a\u00020\u00072\u0006\u0010T\u001a\u00020SH\u0016J\b\u0010V\u001a\u00020SH\u0016J\u0018\u0010X\u001a\u00020\u00072\u0006\u0010:\u001a\u00020$2\u0006\u0010\f\u001a\u00020WH\u0016J\u0018\u0010Y\u001a\u00020\u00072\u0006\u0010:\u001a\u00020$2\u0006\u0010\f\u001a\u00020WH\u0016J\u0010\u0010\\\u001a\u00020\u00072\u0006\u0010[\u001a\u00020ZH\u0016J\n\u0010]\u001a\u0004\u0018\u00010IH\u0016J\b\u0010^\u001a\u000204H\u0016J\u0010\u0010`\u001a\u00020\u00072\u0006\u0010_\u001a\u000204H\u0016J\n\u0010b\u001a\u0004\u0018\u00010aH\u0016J\b\u0010d\u001a\u00020cH\u0016J\u0010\u0010f\u001a\u00020\u00072\u0006\u0010e\u001a\u00020$H\u0016J\u001e\u0010i\u001a\u00020\u00072\u0006\u0010g\u001a\u00020$2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00070hH\u0016J\b\u0010k\u001a\u0004\u0018\u00010jJ\b\u0010l\u001a\u00020\u0007H\u0016R\u0018\u0010m\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010p\u001a\u00020o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010rR\u0018\u0010s\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u001a\u0010v\u001a\b\u0012\u0004\u0012\u00020\u000e0u8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bv\u0010wR\u0018\u0010x\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010y\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006~"}, d2 = {"Lcom/tencent/sqshow/sharedengine/ZPlanShareEngineScene;", "Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene;", "Lcom/tencent/sqshow/zootopia/avatar/filament/IPortalBusiness;", "Lcom/tencent/sqshow/zootopia/avatar/filament/IDynamicBusinessScene;", "Lcom/tencent/filament/zplan/business/api/IBusinessScene;", "oldScene", "newScene", "", "notifySceneChange", "scene", "initScene", "Ls74/a;", "listener", "setCameraChangeListener", "Lvk0/d;", "addSceneChangeListener", "removeSceneChangeListener", "", "getAnimStateType", "Lr74/b$a$a;", "setAnimStateChangeListener", "type", "dynamicJumpType", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene$FetchAvatarInfoFrom;", "from", "Lorg/json/JSONObject;", "fetchAvatarInfo", "(Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene$FetchAvatarInfoFrom;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "gender", "", "Lcom/tencent/filament/zplan/data/FetchActionData;", "getActionDataArray", "(Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;)[Lcom/tencent/filament/zplan/data/FetchActionData;", "", "bodyTypeName", "Lcom/tencent/filament/zplan/avatar/CameraParams;", "getBodyTypeCamera", "Lcom/tencent/filament/zplan/avatar/LightsParams;", "getLightConfigAfterThemeChange", "getSceneConfig", "Lcom/tencent/filament/zplan/business/api/SceneType;", "getSceneType", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "actionArray", "Lcom/tencent/zplan/zplantracing/c;", "zplanSpanContext", "loadAnimation", "([Lcom/tencent/filament/zplan/animation/ZPlanAction;Lcom/tencent/zplan/zplantracing/c;)V", "onTerminate", "", "canRender", "", "now", "Lcom/tencent/filament/zplan/business/api/a;", "animate", "event", "eventData", "processDispatchEvent", "needApplyShoesHeight", "enablePlanarReflection", "enablePlanarShadow", "enablePelvisOffset", "getAvatarMask", "disableGlassesMetallic", "Lcom/tencent/filament/zplan/engine/js/FilamentEventDispatcher;", "dispatcher", "setEventDispatcher", "Lcom/tencent/filament/zplan/business/api/b;", "task", "setExecuteFunk", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2;", "viewer", "setViewer", "Lcom/tencent/filament/zplan/business/api/c;", "setReloadAvatarListener", "onFirstRenderEnd", "needRecordFirstFrame", "launchOnIOThread", "Lcom/tencent/sqshow/zootopia/avatar/filament/h;", "setRenderListener", "Lqu4/a;", ac.f283467k0, "updateAvatarCharacter", "getAvatarCharacter", "Luk0/e;", "addListener", "removeListener", "Lcom/tencent/sqshow/zootopia/nativeui/data/m;", "cameraKey", "updateInitCameraId", "getViewer", "getPortalNeedFullReloadAfterFirstFrame", "needReload", "setPortalNeedFullReloadAfterFirstFrame", "Lcom/tencent/sqshow/zootopia/avatar/filament/anim/PortalAnimHelper;", "getPortalAnimHelper", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "getPortalUrlTemplate", "camera", "setCamera", "funName", "Lkotlin/Function0;", "runOnViewerThread", "Landroid/graphics/Point;", "get501HandPostion", "resetAnim", "realScene", "Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene;", "Lr74/b;", "animStateMachine", "Lr74/b;", "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "cameraChangeListener", "Ls74/a;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "sceneListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "handPosition", "Landroid/graphics/Point;", "<init>", "()V", "Companion", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanShareEngineScene extends AbsBusinessScene implements IPortalBusiness, IDynamicBusinessScene {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final CameraParams DEFAULT_TYPE_STRETCH_CAMERA;
    private static final List<String> INTERCEPT_EVENT_NAME;
    private static final String TAG = "ZPlanShareEngineScene_";
    private static final Integer[] dynamicActionIdArray;
    private a cameraChangeListener;
    private Point handPosition;
    private AbsBusinessScene realScene;
    private b animStateMachine = new b();
    private EnumUserGender gender = EnumUserGender.GENDER_UNINIT;
    private final CopyOnWriteArrayList<d> sceneListeners = new CopyOnWriteArrayList<>();

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/sqshow/sharedengine/ZPlanShareEngineScene$a;", "", "Lcom/tencent/filament/zplan/avatar/CameraParams;", "DEFAULT_TYPE_STRETCH_CAMERA", "Lcom/tencent/filament/zplan/avatar/CameraParams;", "a", "()Lcom/tencent/filament/zplan/avatar/CameraParams;", "", "TAG", "Ljava/lang/String;", "", "", "dynamicActionIdArray", "[Ljava/lang/Integer;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.sharedengine.ZPlanShareEngineScene$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CameraParams a() {
            return ZPlanShareEngineScene.DEFAULT_TYPE_STRETCH_CAMERA;
        }

        Companion() {
        }
    }

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf("onCostumeChange");
        INTERCEPT_EVENT_NAME = listOf;
        dynamicActionIdArray = new Integer[]{501, 502, Integer.valueOf(PullDownAnimState.INSTANCE.a())};
        CameraParams cameraParams = new CameraParams(null, null, null, null, null, 31, null);
        Exposure exposure = new Exposure(0, 0.0d, 0.0d, 7, null);
        exposure.setAperture(16);
        exposure.setSensitivity(100.0d);
        exposure.setShutterSpeed(0.008d);
        cameraParams.setExposure(exposure);
        LookAt lookAt = new LookAt(null, null, null, 7, null);
        lookAt.setEye(new float[]{0.0f, 1.0f, 14.62263f});
        lookAt.setTarget(new float[]{0.0f, 0.7090301f, 0.0f});
        lookAt.setUpward(new float[]{0.0f, 1.0f, 0.0f});
        cameraParams.setLookAt(lookAt);
        LensProjection lensProjection = new LensProjection(0.0f, 0.0f, 0, 0.0f, 15, null);
        lensProjection.setAspect(0.75f);
        lensProjection.setFar(1000.0f);
        lensProjection.setFocalLength(120);
        lensProjection.setNear(0.05f);
        cameraParams.setLensProjection(lensProjection);
        DEFAULT_TYPE_STRETCH_CAMERA = cameraParams;
    }

    private final void notifySceneChange(IBusinessScene oldScene, IBusinessScene newScene) {
        QLog.i(TAG, 1, "notifySceneChange, oldSceneType=" + oldScene.getSceneType() + ", newSceneType=" + newScene.getSceneType());
        Iterator<T> it = this.sceneListeners.iterator();
        while (it.hasNext()) {
            ((d) it.next()).C4(oldScene, newScene);
        }
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.IPortalBusiness
    public void addListener(String event, e listener) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(listener, "listener");
        IBusinessScene iBusinessScene = this.realScene;
        IPortalBusiness iPortalBusiness = iBusinessScene instanceof IPortalBusiness ? (IPortalBusiness) iBusinessScene : null;
        if (iPortalBusiness != null) {
            iPortalBusiness.addListener(event, listener);
        }
    }

    public final void addSceneChangeListener(d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.sceneListeners.contains(listener)) {
            return;
        }
        this.sceneListeners.add(listener);
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    public com.tencent.filament.zplan.business.api.a animate(double now, c zplanSpanContext) {
        AbsBusinessScene absBusinessScene = this.realScene;
        if (absBusinessScene != null) {
            absBusinessScene.animate(now, zplanSpanContext);
        }
        AbsBusinessScene absBusinessScene2 = this.realScene;
        boolean z16 = false;
        if (absBusinessScene2 != null && !absBusinessScene2.getCanRender()) {
            z16 = true;
        }
        if (z16) {
            AbsBusinessScene absBusinessScene3 = this.realScene;
            if ((absBusinessScene3 != null ? absBusinessScene3.getSceneType() : null) == SceneType.PORTAL) {
                this.animStateMachine.b(this.gender, now, zplanSpanContext);
            }
        }
        return null;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    /* renamed from: canRender */
    public boolean getCanRender() {
        AbsBusinessScene absBusinessScene = this.realScene;
        if ((absBusinessScene != null ? absBusinessScene.getSceneType() : null) != SceneType.PORTAL) {
            AbsBusinessScene absBusinessScene2 = this.realScene;
            Intrinsics.checkNotNull(absBusinessScene2);
            return absBusinessScene2.getCanRender();
        }
        return super.getCanRender();
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public boolean disableGlassesMetallic() {
        AbsBusinessScene absBusinessScene = this.realScene;
        if (absBusinessScene != null) {
            return absBusinessScene.disableGlassesMetallic();
        }
        return super.disableGlassesMetallic();
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public boolean enablePelvisOffset() {
        return true;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public boolean enablePlanarReflection() {
        AbsBusinessScene absBusinessScene = this.realScene;
        if (absBusinessScene != null) {
            return absBusinessScene.enablePlanarReflection();
        }
        return super.enablePlanarReflection();
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public boolean enablePlanarShadow() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object fetchAvatarInfo(AbsBusinessScene.FetchAvatarInfoFrom fetchAvatarInfoFrom, Continuation<? super JSONObject> continuation) {
        ZPlanShareEngineScene$fetchAvatarInfo$1 zPlanShareEngineScene$fetchAvatarInfo$1;
        Object coroutine_suspended;
        int i3;
        JSONObject jSONObject;
        if (continuation instanceof ZPlanShareEngineScene$fetchAvatarInfo$1) {
            zPlanShareEngineScene$fetchAvatarInfo$1 = (ZPlanShareEngineScene$fetchAvatarInfo$1) continuation;
            int i16 = zPlanShareEngineScene$fetchAvatarInfo$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanShareEngineScene$fetchAvatarInfo$1.label = i16 - Integer.MIN_VALUE;
                Object obj = zPlanShareEngineScene$fetchAvatarInfo$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanShareEngineScene$fetchAvatarInfo$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    AbsBusinessScene absBusinessScene = this.realScene;
                    if (absBusinessScene != null) {
                        zPlanShareEngineScene$fetchAvatarInfo$1.label = 1;
                        obj = absBusinessScene.fetchAvatarInfo(fetchAvatarInfoFrom, zPlanShareEngineScene$fetchAvatarInfo$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return new JSONObject();
                }
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                jSONObject = (JSONObject) obj;
                if (jSONObject != null) {
                    return jSONObject;
                }
                return new JSONObject();
            }
        }
        zPlanShareEngineScene$fetchAvatarInfo$1 = new ZPlanShareEngineScene$fetchAvatarInfo$1(this, continuation);
        Object obj2 = zPlanShareEngineScene$fetchAvatarInfo$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanShareEngineScene$fetchAvatarInfo$1.label;
        if (i3 != 0) {
        }
        jSONObject = (JSONObject) obj2;
        if (jSONObject != null) {
        }
        return new JSONObject();
    }

    /* renamed from: get501HandPostion, reason: from getter */
    public final Point getHandPosition() {
        return this.handPosition;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public FetchActionData[] getActionDataArray(EnumUserGender gender) {
        Intrinsics.checkNotNullParameter(gender, "gender");
        AbsBusinessScene absBusinessScene = this.realScene;
        QLog.i(TAG, 1, "getActionDataArray=" + gender + ", sceneType=" + (absBusinessScene != null ? absBusinessScene.getSceneType() : null));
        this.gender = gender;
        AbsBusinessScene absBusinessScene2 = this.realScene;
        if ((absBusinessScene2 != null ? absBusinessScene2.getSceneType() : null) == SceneType.DYNAMIC) {
            Integer[] numArr = dynamicActionIdArray;
            ArrayList arrayList = new ArrayList(numArr.length);
            for (Integer num : numArr) {
                arrayList.add(new FetchActionData(num.intValue(), null, null, 6, null));
            }
            Object[] array = arrayList.toArray(new FetchActionData[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return (FetchActionData[]) array;
        }
        AbsBusinessScene absBusinessScene3 = this.realScene;
        if (absBusinessScene3 != null) {
            return absBusinessScene3.getActionDataArray(gender);
        }
        return null;
    }

    public final int getAnimStateType() {
        return this.animStateMachine.e();
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.IPortalBusiness
    public qu4.a getAvatarCharacter() {
        qu4.a avatarCharacter;
        IBusinessScene iBusinessScene = this.realScene;
        IPortalBusiness iPortalBusiness = iBusinessScene instanceof IPortalBusiness ? (IPortalBusiness) iBusinessScene : null;
        return (iPortalBusiness == null || (avatarCharacter = iPortalBusiness.getAvatarCharacter()) == null) ? new qu4.a() : avatarCharacter;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public JSONObject getAvatarMask() {
        JSONObject avatarMask;
        AbsBusinessScene absBusinessScene = this.realScene;
        return (absBusinessScene == null || (avatarMask = absBusinessScene.getAvatarMask()) == null) ? new JSONObject() : avatarMask;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public CameraParams getBodyTypeCamera(String bodyTypeName) {
        AbsBusinessScene absBusinessScene = this.realScene;
        if ((absBusinessScene != null ? absBusinessScene.getSceneType() : null) == SceneType.DRAWER) {
            return DEFAULT_TYPE_STRETCH_CAMERA;
        }
        AbsBusinessScene absBusinessScene2 = this.realScene;
        if ((absBusinessScene2 != null ? absBusinessScene2.getSceneType() : null) == SceneType.DYNAMIC) {
            return b84.a.f28061a.b(new CameraKey(2000011, 0, 2, null), bodyTypeName);
        }
        AbsBusinessScene absBusinessScene3 = this.realScene;
        if (absBusinessScene3 != null) {
            return absBusinessScene3.getBodyTypeCamera(bodyTypeName);
        }
        return null;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public LightsParams getLightConfigAfterThemeChange() {
        AbsBusinessScene absBusinessScene = this.realScene;
        if (absBusinessScene != null) {
            return absBusinessScene.getLightConfigAfterThemeChange();
        }
        return null;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.IPortalBusiness
    public PortalAnimHelper getPortalAnimHelper() {
        IBusinessScene iBusinessScene = this.realScene;
        IPortalBusiness iPortalBusiness = iBusinessScene instanceof IPortalBusiness ? (IPortalBusiness) iBusinessScene : null;
        if (iPortalBusiness != null) {
            return iPortalBusiness.getPortalAnimHelper();
        }
        return null;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.IPortalBusiness
    public boolean getPortalNeedFullReloadAfterFirstFrame() {
        IBusinessScene iBusinessScene = this.realScene;
        IPortalBusiness iPortalBusiness = iBusinessScene instanceof IPortalBusiness ? (IPortalBusiness) iBusinessScene : null;
        if (iPortalBusiness != null) {
            return iPortalBusiness.getPortalNeedFullReloadAfterFirstFrame();
        }
        return false;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.IPortalBusiness
    public FilamentUrlTemplate getPortalUrlTemplate() {
        FilamentUrlTemplate portalUrlTemplate;
        IBusinessScene iBusinessScene = this.realScene;
        IPortalBusiness iPortalBusiness = iBusinessScene instanceof IPortalBusiness ? (IPortalBusiness) iBusinessScene : null;
        return (iPortalBusiness == null || (portalUrlTemplate = iPortalBusiness.getPortalUrlTemplate()) == null) ? FilamentFeatureUtil.f106409g.F() : portalUrlTemplate;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public String getSceneConfig() {
        String sceneConfig;
        AbsBusinessScene absBusinessScene = this.realScene;
        return (absBusinessScene == null || (sceneConfig = absBusinessScene.getSceneConfig()) == null) ? "{}" : sceneConfig;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    public SceneType getSceneType() {
        SceneType sceneType;
        AbsBusinessScene absBusinessScene = this.realScene;
        return (absBusinessScene == null || (sceneType = absBusinessScene.getSceneType()) == null) ? SceneType.NONE : sceneType;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.IPortalBusiness
    public FilamentViewerV2 getViewer() {
        return getViewerV2();
    }

    public final void initScene(final AbsBusinessScene scene) {
        AbsBusinessScene absBusinessScene;
        AbsBusinessScene absBusinessScene2;
        Intrinsics.checkNotNullParameter(scene, "scene");
        AbsBusinessScene absBusinessScene3 = this.realScene;
        this.realScene = scene;
        com.tencent.filament.zplan.business.api.b exeTask = getExeTask();
        if (exeTask != null && (absBusinessScene2 = this.realScene) != null) {
            absBusinessScene2.setExecuteFunk(exeTask);
        }
        FilamentEventDispatcher dispatcher = getDispatcher();
        if (dispatcher != null && (absBusinessScene = this.realScene) != null) {
            absBusinessScene.setDispatcher(dispatcher);
        }
        if (getViewerV2() != null) {
            doTask("init_scene", new Function0<Unit>() { // from class: com.tencent.sqshow.sharedengine.ZPlanShareEngineScene$initScene$3$1
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
                    AbsBusinessScene absBusinessScene4;
                    b bVar;
                    absBusinessScene4 = ZPlanShareEngineScene.this.realScene;
                    if (absBusinessScene4 != null) {
                        absBusinessScene4.setViewer(ZPlanShareEngineScene.this.getViewerV2());
                    }
                    FilamentViewerV2 viewerV2 = ZPlanShareEngineScene.this.getViewerV2();
                    if (viewerV2 != null) {
                        viewerV2.resetRotation();
                    }
                    if (scene.getSceneType() != SceneType.PORTAL) {
                        FilamentViewerV2 viewerV22 = ZPlanShareEngineScene.this.getViewerV2();
                        if (viewerV22 != null) {
                            viewerV22.setHandHeldShow(false);
                        }
                        bVar = ZPlanShareEngineScene.this.animStateMachine;
                        bVar.g();
                    }
                }
            });
        }
        if (absBusinessScene3 == null || absBusinessScene3.getSceneType() == scene.getSceneType()) {
            return;
        }
        notifySceneChange(absBusinessScene3, scene);
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    /* renamed from: launchOnIOThread */
    public boolean getMEnableFilamentPreLaunch() {
        AbsBusinessScene absBusinessScene = this.realScene;
        if (absBusinessScene != null) {
            return absBusinessScene.getMEnableFilamentPreLaunch();
        }
        return super.getMEnableFilamentPreLaunch();
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public void loadAnimation(ZPlanAction[] actionArray, c zplanSpanContext) {
        AbsBusinessScene absBusinessScene;
        Intrinsics.checkNotNullParameter(actionArray, "actionArray");
        AbsBusinessScene absBusinessScene2 = this.realScene;
        if ((absBusinessScene2 != null ? absBusinessScene2.getSceneType() : null) == SceneType.PORTAL) {
            if (actionArray.length == 1 && (absBusinessScene = this.realScene) != null) {
                absBusinessScene.loadAnimation(actionArray, zplanSpanContext);
            }
        } else {
            AbsBusinessScene absBusinessScene3 = this.realScene;
            if (absBusinessScene3 != null) {
                absBusinessScene3.loadAnimation(actionArray, zplanSpanContext);
            }
        }
        this.animStateMachine.f(new q74.a(getScope(), getExeTask(), getService(), getViewerV2()), zplanSpanContext, this.gender, getUrlTemplate());
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public boolean needApplyShoesHeight() {
        return true;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    /* renamed from: needRecordFirstFrame */
    public boolean getNeedRecordFirstFrame() {
        AbsBusinessScene absBusinessScene = this.realScene;
        if ((absBusinessScene != null ? absBusinessScene.getSceneType() : null) == SceneType.PORTAL) {
            return false;
        }
        AbsBusinessScene absBusinessScene2 = this.realScene;
        if (absBusinessScene2 != null) {
            return absBusinessScene2.getNeedRecordFirstFrame();
        }
        return super.getNeedRecordFirstFrame();
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    public void onFirstRenderEnd() {
        AbsBusinessScene absBusinessScene = this.realScene;
        QLog.i(TAG, 1, "onFirstRenderEnd, sceneType=" + (absBusinessScene != null ? absBusinessScene.getSceneType() : null));
        AbsBusinessScene absBusinessScene2 = this.realScene;
        if ((absBusinessScene2 != null ? absBusinessScene2.getSceneType() : null) != SceneType.PORTAL) {
            FilamentViewerV2 viewerV2 = getViewerV2();
            Point nodePoint = viewerV2 != null ? viewerV2.getNodePoint("hand_r") : null;
            this.handPosition = nodePoint;
            QLog.i(TAG, 1, "onFirstRenderEnd, handPosition=" + nodePoint);
        }
        super.onFirstRenderEnd();
        AbsBusinessScene absBusinessScene3 = this.realScene;
        if (absBusinessScene3 != null) {
            absBusinessScene3.onFirstRenderEnd();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object onTerminate(Continuation<? super Unit> continuation) {
        ZPlanShareEngineScene$onTerminate$1 zPlanShareEngineScene$onTerminate$1;
        Object coroutine_suspended;
        int i3;
        ZPlanShareEngineScene zPlanShareEngineScene;
        if (continuation instanceof ZPlanShareEngineScene$onTerminate$1) {
            zPlanShareEngineScene$onTerminate$1 = (ZPlanShareEngineScene$onTerminate$1) continuation;
            int i16 = zPlanShareEngineScene$onTerminate$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanShareEngineScene$onTerminate$1.label = i16 - Integer.MIN_VALUE;
                Object obj = zPlanShareEngineScene$onTerminate$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanShareEngineScene$onTerminate$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    zPlanShareEngineScene$onTerminate$1.L$0 = this;
                    zPlanShareEngineScene$onTerminate$1.label = 1;
                    if (super.onTerminate(zPlanShareEngineScene$onTerminate$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    zPlanShareEngineScene = this;
                } else if (i3 == 1) {
                    zPlanShareEngineScene = (ZPlanShareEngineScene) zPlanShareEngineScene$onTerminate$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                zPlanShareEngineScene.sceneListeners.clear();
                return Unit.INSTANCE;
            }
        }
        zPlanShareEngineScene$onTerminate$1 = new ZPlanShareEngineScene$onTerminate$1(this, continuation);
        Object obj2 = zPlanShareEngineScene$onTerminate$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanShareEngineScene$onTerminate$1.label;
        if (i3 != 0) {
        }
        zPlanShareEngineScene.sceneListeners.clear();
        return Unit.INSTANCE;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    public void processDispatchEvent(String event, String eventData, c zplanSpanContext) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (INTERCEPT_EVENT_NAME.contains(event)) {
            super.processDispatchEvent(event, eventData, zplanSpanContext);
        } else {
            AbsBusinessScene absBusinessScene = this.realScene;
            if (absBusinessScene != null) {
                absBusinessScene.processDispatchEvent(event, eventData, zplanSpanContext);
            }
        }
        if (Intrinsics.areEqual(event, "ZPlanShareEngineScene_OnSetCamera")) {
            JSONObject jSONObject = new JSONObject(eventData);
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = !getFirstRenderEnd().get() ? 0 : jSONObject.optInt("now");
            final int optInt = jSONObject.optInt("duration");
            doTask("setCamera", new Function0<Unit>() { // from class: com.tencent.sqshow.sharedengine.ZPlanShareEngineScene$processDispatchEvent$1
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
                    a aVar;
                    FilamentViewerV2 viewerV2 = ZPlanShareEngineScene.this.getViewerV2();
                    if (viewerV2 != null) {
                        String json = new Gson().toJson(ZPlanShareEngineScene.INSTANCE.a());
                        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(DEFAULT_TYPE_STRETCH_CAMERA)");
                        String json2 = new Gson().toJson(b84.a.f28061a.b(new CameraKey(2000011, 0, 2, null), ZPlanShareEngineScene.this.getBodyTypeName()));
                        Intrinsics.checkNotNullExpressionValue(json2, "Gson().toJson(FilamentCo\u2026(2000011), bodyTypeName))");
                        viewerV2.playCameraAnimation(json, json2, optInt, intRef.element);
                    }
                    aVar = ZPlanShareEngineScene.this.cameraChangeListener;
                    if (aVar != null) {
                        aVar.Z6(intRef.element / optInt);
                    }
                }
            });
        }
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.IPortalBusiness
    public void removeListener(String event, e listener) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(listener, "listener");
        IBusinessScene iBusinessScene = this.realScene;
        IPortalBusiness iPortalBusiness = iBusinessScene instanceof IPortalBusiness ? (IPortalBusiness) iBusinessScene : null;
        if (iPortalBusiness != null) {
            iPortalBusiness.removeListener(event, listener);
        }
    }

    public final void removeSceneChangeListener(d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.sceneListeners.contains(listener)) {
            this.sceneListeners.remove(listener);
        }
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.IDynamicBusinessScene
    public void resetAnim() {
        IBusinessScene iBusinessScene = this.realScene;
        IDynamicBusinessScene iDynamicBusinessScene = iBusinessScene instanceof IDynamicBusinessScene ? (IDynamicBusinessScene) iBusinessScene : null;
        if (iDynamicBusinessScene != null) {
            iDynamicBusinessScene.resetAnim();
        }
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.IPortalBusiness, com.tencent.sqshow.zootopia.avatar.filament.i
    public void runOnViewerThread(String funName, Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(funName, "funName");
        Intrinsics.checkNotNullParameter(task, "task");
        IBusinessScene iBusinessScene = this.realScene;
        IPortalBusiness iPortalBusiness = iBusinessScene instanceof IPortalBusiness ? (IPortalBusiness) iBusinessScene : null;
        if (iPortalBusiness != null) {
            iPortalBusiness.runOnViewerThread(funName, task);
        }
    }

    public final void setAnimStateChangeListener(b.Companion.InterfaceC11119a listener) {
        this.animStateMachine.h(listener);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.IPortalBusiness
    public void setCamera(String camera2) {
        Intrinsics.checkNotNullParameter(camera2, "camera");
        IBusinessScene iBusinessScene = this.realScene;
        IPortalBusiness iPortalBusiness = iBusinessScene instanceof IPortalBusiness ? (IPortalBusiness) iBusinessScene : null;
        if (iPortalBusiness != null) {
            iPortalBusiness.setCamera(camera2);
        }
    }

    public final void setCameraChangeListener(a listener) {
        this.cameraChangeListener = listener;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    public void setEventDispatcher(FilamentEventDispatcher dispatcher) {
        super.setEventDispatcher(dispatcher);
        AbsBusinessScene absBusinessScene = this.realScene;
        if (absBusinessScene != null) {
            absBusinessScene.setEventDispatcher(dispatcher);
        }
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    public void setExecuteFunk(com.tencent.filament.zplan.business.api.b task) {
        super.setExecuteFunk(task);
        AbsBusinessScene absBusinessScene = this.realScene;
        if (absBusinessScene != null) {
            absBusinessScene.setExecuteFunk(task);
        }
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.IPortalBusiness
    public void setPortalNeedFullReloadAfterFirstFrame(boolean needReload) {
        IBusinessScene iBusinessScene = this.realScene;
        IPortalBusiness iPortalBusiness = iBusinessScene instanceof IPortalBusiness ? (IPortalBusiness) iBusinessScene : null;
        if (iPortalBusiness != null) {
            iPortalBusiness.setPortalNeedFullReloadAfterFirstFrame(needReload);
        }
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    public void setReloadAvatarListener(com.tencent.filament.zplan.business.api.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        super.setReloadAvatarListener(listener);
        AbsBusinessScene absBusinessScene = this.realScene;
        if (absBusinessScene != null) {
            absBusinessScene.setReloadAvatarListener(listener);
        }
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.IPortalBusiness
    public void setRenderListener(h listener) {
        IBusinessScene iBusinessScene = this.realScene;
        IPortalBusiness iPortalBusiness = iBusinessScene instanceof IPortalBusiness ? (IPortalBusiness) iBusinessScene : null;
        if (iPortalBusiness != null) {
            iPortalBusiness.setRenderListener(listener);
        }
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    public void setViewer(FilamentViewerV2 viewer) {
        super.setViewer(viewer);
        AbsBusinessScene absBusinessScene = this.realScene;
        if (absBusinessScene != null) {
            absBusinessScene.setViewer(viewer);
        }
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.IPortalBusiness
    public void updateAvatarCharacter(qu4.a ac5) {
        Intrinsics.checkNotNullParameter(ac5, "ac");
        IBusinessScene iBusinessScene = this.realScene;
        IPortalBusiness iPortalBusiness = iBusinessScene instanceof IPortalBusiness ? (IPortalBusiness) iBusinessScene : null;
        if (iPortalBusiness != null) {
            iPortalBusiness.updateAvatarCharacter(ac5);
        }
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.IPortalBusiness
    public void updateInitCameraId(CameraKey cameraKey) {
        Intrinsics.checkNotNullParameter(cameraKey, "cameraKey");
        IBusinessScene iBusinessScene = this.realScene;
        IPortalBusiness iPortalBusiness = iBusinessScene instanceof IPortalBusiness ? (IPortalBusiness) iBusinessScene : null;
        if (iPortalBusiness != null) {
            iPortalBusiness.updateInitCameraId(cameraKey);
        }
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    public Object onPause(Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        QLog.i(TAG, 1, "ZPlanShareEngineScene onPause");
        AbsBusinessScene absBusinessScene = this.realScene;
        if (absBusinessScene != null) {
            Object onPause = absBusinessScene.onPause(continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return onPause == coroutine_suspended ? onPause : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public final void dynamicJumpType(int type) {
        if (type == 2) {
            this.animStateMachine.c(2);
        } else {
            this.animStateMachine.c(1);
        }
    }
}
