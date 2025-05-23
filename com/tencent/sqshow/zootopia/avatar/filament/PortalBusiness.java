package com.tencent.sqshow.zootopia.avatar.filament;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.BusinessSceneConfig;
import com.tencent.filament.zplan.avatar.CameraParams;
import com.tencent.filament.zplan.avatar.ClearOptions;
import com.tencent.filament.zplan.avatar.LightsParams;
import com.tencent.filament.zplan.avatar.RendererParams;
import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.business.api.SceneType;
import com.tencent.filament.zplan.business.impl.AbsBusinessScene;
import com.tencent.filament.zplan.data.FetchActionData;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplanservice.download.ZPlanAvatarService;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.model.ac;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.utils.featureswitch.model.ReloadAvatarDelaySlotConfig;
import com.tencent.sqshow.zootopia.avatar.filament.IPortalBusiness;
import com.tencent.sqshow.zootopia.avatar.filament.PortalBusiness;
import com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper;
import com.tencent.sqshow.zootopia.nativeui.data.CameraKey;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u00d3\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\b\b*\u0001s\b\u0016\u0018\u0000 x2\u00020\u00012\u00020\u0002:\u0001yB\u0019\u0012\u0006\u0010P\u001a\u00020\u001f\u0012\b\u0010;\u001a\u0004\u0018\u00010:\u00a2\u0006\u0004\bv\u0010wJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0013\u0010\n\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0014H\u0016J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0003H\u0016J\n\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010\"\u001a\u00020!H\u0016J\u0010\u0010$\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0005H\u0016J\u001b\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020%H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010)J\u001f\u0010.\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\u0006\u0010+\u001a\u00020*H\u0016\u00a2\u0006\u0004\b.\u0010/J\u0014\u00102\u001a\u0004\u0018\u0001012\b\u00100\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u00104\u001a\u0004\u0018\u000103H\u0016J\b\u00105\u001a\u00020\u0005H\u0016J\b\u00107\u001a\u000206H\u0016J'\u0010<\u001a\u00020\t2\f\u00109\u001a\b\u0012\u0004\u0012\u0002080,2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016\u00a2\u0006\u0004\b<\u0010=J\u001c\u0010A\u001a\u0004\u0018\u00010@2\u0006\u0010?\u001a\u00020>2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016J$\u0010C\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010B\u001a\u0004\u0018\u00010\u00052\b\u0010;\u001a\u0004\u0018\u00010:H\u0016J\b\u0010D\u001a\u00020\u0003H\u0016J\b\u0010E\u001a\u00020\u0003H\u0016J\b\u0010F\u001a\u00020\u0003H\u0016J\b\u0010G\u001a\u00020'H\u0016J\b\u0010H\u001a\u00020\u0003H\u0016J\b\u0010I\u001a\u00020\u0003H\u0016J\b\u0010J\u001a\u00020\u0003H\u0016J\u001e\u0010N\u001a\u00020\t2\u0006\u0010K\u001a\u00020\u00052\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\t0LH\u0016J\u0013\u0010O\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\bO\u0010\u000bR\u0017\u0010P\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u0016\u0010T\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\"\u0010V\u001a\u00020\u00178\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R0\u0010_\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00140]j\b\u0012\u0004\u0012\u00020\u0014`^0\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010H\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010aR\u0016\u0010c\u001a\u00020b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010e\u001a\u00020>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010I\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010aR\u0014\u0010g\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bg\u0010aR\u0014\u0010h\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bh\u0010aR\u0016\u0010i\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010aR\u0018\u0010j\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010l\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010aR\u0016\u0010m\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010aR\"\u0010n\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bn\u0010a\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u0014\u0010t\u001a\u00020s8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bt\u0010u\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006z"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/filament/PortalBusiness;", "Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene;", "Lcom/tencent/sqshow/zootopia/avatar/filament/IPortalBusiness;", "", "isFirstFrameStaticImageExist", "", "loadSceneDebugCfg", "Lcom/tencent/filament/zplan/avatar/BusinessSceneConfig;", "buildCfg", "", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/sqshow/zootopia/avatar/filament/h;", "listener", "setRenderListener", "Lqu4/a;", ac.f283467k0, "updateAvatarCharacter", "getAvatarCharacter", "event", "Luk0/e;", "addListener", "removeListener", "Lcom/tencent/sqshow/zootopia/nativeui/data/m;", "cameraKey", "updateInitCameraId", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2;", "getViewer", "getPortalNeedFullReloadAfterFirstFrame", "needReload", "setPortalNeedFullReloadAfterFirstFrame", "Lcom/tencent/sqshow/zootopia/avatar/filament/anim/PortalAnimHelper;", "getPortalAnimHelper", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "getPortalUrlTemplate", "camera", "setCamera", "Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene$FetchAvatarInfoFrom;", "from", "Lorg/json/JSONObject;", "fetchAvatarInfo", "(Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene$FetchAvatarInfoFrom;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "gender", "", "Lcom/tencent/filament/zplan/data/FetchActionData;", "getActionDataArray", "(Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;)[Lcom/tencent/filament/zplan/data/FetchActionData;", "bodyTypeName", "Lcom/tencent/filament/zplan/avatar/CameraParams;", "getBodyTypeCamera", "Lcom/tencent/filament/zplan/avatar/LightsParams;", "getLightConfigAfterThemeChange", "getSceneConfig", "Lcom/tencent/filament/zplan/business/api/SceneType;", "getSceneType", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "actionArray", "Lcom/tencent/zplan/zplantracing/c;", "zplanSpanContext", "loadAnimation", "([Lcom/tencent/filament/zplan/animation/ZPlanAction;Lcom/tencent/zplan/zplantracing/c;)V", "", "now", "Lcom/tencent/filament/zplan/business/api/a;", "animate", "eventData", "processDispatchEvent", "needApplyShoesHeight", "enablePlanarShadow", "enablePelvisOffset", "getAvatarMask", "canRender", "needRecordFirstFrame", "launchOnIOThread", "funName", "Lkotlin/Function0;", "task", "runOnViewerThread", "onTerminate", "animHelper", "Lcom/tencent/sqshow/zootopia/avatar/filament/anim/PortalAnimHelper;", "getAnimHelper", "()Lcom/tencent/sqshow/zootopia/avatar/filament/anim/PortalAnimHelper;", "avatarCharacter", "Lqu4/a;", "initCameraKey", "Lcom/tencent/sqshow/zootopia/nativeui/data/m;", "getInitCameraKey", "()Lcom/tencent/sqshow/zootopia/nativeui/data/m;", "setInitCameraKey", "(Lcom/tencent/sqshow/zootopia/nativeui/data/m;)V", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "listenerPool", "Ljava/util/concurrent/ConcurrentHashMap;", "Z", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isPausing", "Ljava/util/concurrent/atomic/AtomicBoolean;", WadlProxyConsts.LAST_UPDATE_TIME, "D", "enableSyncLoadInitAnim", "mEnableFilamentPreLaunch", "enableRenderCompleteCallback", "renderListener", "Lcom/tencent/sqshow/zootopia/avatar/filament/h;", "hasRender", "hasFirstFrameStaticImage", "needFullReloadAfterFirstFrame", "getNeedFullReloadAfterFirstFrame", "()Z", "setNeedFullReloadAfterFirstFrame", "(Z)V", "com/tencent/sqshow/zootopia/avatar/filament/PortalBusiness$b", "mAnimRenderCallBack", "Lcom/tencent/sqshow/zootopia/avatar/filament/PortalBusiness$b;", "<init>", "(Lcom/tencent/sqshow/zootopia/avatar/filament/anim/PortalAnimHelper;Lcom/tencent/zplan/zplantracing/c;)V", "Companion", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class PortalBusiness extends AbsBusinessScene implements IPortalBusiness {
    private static final String TAG = "PortalBusiness_";
    private final PortalAnimHelper animHelper;
    private qu4.a avatarCharacter;
    private boolean canRender;
    private boolean enableRenderCompleteCallback;
    private final boolean enableSyncLoadInitAnim;
    private boolean hasFirstFrameStaticImage;
    private boolean hasRender;
    private CameraKey initCameraKey;
    private AtomicBoolean isPausing;
    private double lastUpdateTime;
    private final ConcurrentHashMap<String, HashSet<uk0.e>> listenerPool;
    private final b mAnimRenderCallBack;
    private final boolean mEnableFilamentPreLaunch;
    private volatile boolean needFullReloadAfterFirstFrame;
    private boolean needRecordFirstFrame;
    private h renderListener;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/sqshow/zootopia/avatar/filament/PortalBusiness$b", "Lcom/tencent/filament/zplan/business/api/a;", "", "d", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.filament.zplan.business.api.a {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(PortalBusiness this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            h hVar = this$0.renderListener;
            if (hVar != null) {
                hVar.d();
            }
        }

        @Override // com.tencent.filament.zplan.business.api.a
        public void d() {
            QLog.i(PortalBusiness.TAG, 1, "onRenderComplete");
            PortalBusiness.this.hasRender = true;
            if (PortalBusiness.this.renderListener != null) {
                final PortalBusiness portalBusiness = PortalBusiness.this;
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.avatar.filament.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        PortalBusiness.b.b(PortalBusiness.this);
                    }
                });
            }
        }
    }

    public PortalBusiness(PortalAnimHelper animHelper, com.tencent.zplan.zplantracing.c cVar) {
        Intrinsics.checkNotNullParameter(animHelper, "animHelper");
        this.animHelper = animHelper;
        this.avatarCharacter = new qu4.a();
        boolean z16 = false;
        this.initCameraKey = new CameraKey(2000011, 0, 2, null);
        this.listenerPool = new ConcurrentHashMap<>();
        this.isPausing = new AtomicBoolean(false);
        this.lastUpdateTime = -1.0d;
        this.needRecordFirstFrame = true;
        ZPlanQQMC zPlanQQMC = ZPlanQQMC.INSTANCE;
        this.enableSyncLoadInitAnim = zPlanQQMC.enablePortalSyncLoadInitAnim();
        this.mEnableFilamentPreLaunch = zPlanQQMC.enablePortalFilamentPreLaunch();
        this.mAnimRenderCallBack = new b();
        animHelper.T(this);
        animHelper.m1(getUrlTemplate());
        animHelper.k1(getService());
        this.hasFirstFrameStaticImage = isFirstFrameStaticImageExist();
        this.needRecordFirstFrame = ZPlanFeatureSwitch.f369852a.q3() || !this.hasFirstFrameStaticImage;
        if (zPlanQQMC.enableRenderCompelteCallback() && this.hasFirstFrameStaticImage) {
            z16 = true;
        }
        this.enableRenderCompleteCallback = z16;
        QLog.i(TAG, 1, "needRecordFirstFrame=" + this.needRecordFirstFrame + ", mEnableRenderCompleteCallback=" + z16 + ", hasFirstFrameStaticImage=" + this.hasFirstFrameStaticImage);
    }

    private final BusinessSceneConfig buildCfg() {
        LightsParams a16 = k.f370019a.a(QQTheme.isNowThemeIsNight());
        CameraParams b16 = b84.a.f28061a.b(this.initCameraKey, getBodyTypeName());
        RendererParams rendererParams = new RendererParams(null, 1, null);
        ClearOptions clearOptions = rendererParams.getClearOptions();
        clearOptions.setClearColor(new float[]{0.0f, 0.0f, 0.0f, 0.0f});
        clearOptions.setClear(true);
        clearOptions.setDiscard(true);
        return new BusinessSceneConfig(b16, rendererParams, a16);
    }

    static /* synthetic */ Object fetchAvatarInfo$suspendImpl(PortalBusiness portalBusiness, AbsBusinessScene.FetchAvatarInfoFrom fetchAvatarInfoFrom, Continuation<? super JSONObject> continuation) {
        JSONObject h16 = r94.c.h(portalBusiness.avatarCharacter);
        ZPlanQQMC zPlanQQMC = ZPlanQQMC.INSTANCE;
        if (zPlanQQMC.isSwitchOn("enable_filament_local_shader_binary", false)) {
            portalBusiness.needFullReloadAfterFirstFrame = false;
        } else if (fetchAvatarInfoFrom == AbsBusinessScene.FetchAvatarInfoFrom.ON_LAUNCH) {
            portalBusiness.needFullReloadAfterFirstFrame = ReloadAvatarDelaySlotConfig.INSTANCE.a(h16, zPlanQQMC.getPortalFilamentReloadAvatarDelaySlotConfig());
        }
        portalBusiness.animHelper.g1(h16);
        QLog.i(TAG, 1, "fetchAvatarInfo from:" + fetchAvatarInfoFrom + ", needFullReloadAfterFirstFrame:" + portalBusiness.needFullReloadAfterFirstFrame);
        return h16;
    }

    private final boolean isFirstFrameStaticImageExist() {
        qu4.h hVar;
        dw4.b value = com.tencent.sqshow.dresskey.b.f369818a.l(TAG, true).getValue();
        if (value == null || (hVar = value.f395115b) == null || TextUtils.isEmpty(hVar.f429598b)) {
            return false;
        }
        c84.e eVar = c84.e.f30458a;
        String str = value.f395115b.f429598b;
        Intrinsics.checkNotNullExpressionValue(str, "it.dressKey.dressKey");
        return eVar.e(str, QQTheme.isNowThemeIsNight());
    }

    private final String loadSceneDebugCfg() {
        return null;
    }

    static /* synthetic */ Object onPause$suspendImpl(PortalBusiness portalBusiness, Continuation<? super Unit> continuation) {
        QLog.i(TAG, 1, "PortalBusiness onPause");
        portalBusiness.isPausing.compareAndSet(false, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ Object onTerminate$suspendImpl(PortalBusiness portalBusiness, Continuation<? super Unit> continuation) {
        PortalBusiness$onTerminate$1 portalBusiness$onTerminate$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof PortalBusiness$onTerminate$1) {
            portalBusiness$onTerminate$1 = (PortalBusiness$onTerminate$1) continuation;
            int i16 = portalBusiness$onTerminate$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                portalBusiness$onTerminate$1.label = i16 - Integer.MIN_VALUE;
                Object obj = portalBusiness$onTerminate$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = portalBusiness$onTerminate$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    PortalAnimHelper portalAnimHelper = portalBusiness.animHelper;
                    portalBusiness$onTerminate$1.L$0 = portalBusiness;
                    portalBusiness$onTerminate$1.label = 1;
                    if (portalAnimHelper.U0(portalBusiness$onTerminate$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            portalBusiness = (PortalBusiness) portalBusiness$onTerminate$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            portalBusiness.listenerPool.clear();
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    portalBusiness = (PortalBusiness) portalBusiness$onTerminate$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                portalBusiness$onTerminate$1.L$0 = portalBusiness;
                portalBusiness$onTerminate$1.label = 2;
                if (super.onTerminate(portalBusiness$onTerminate$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                portalBusiness.listenerPool.clear();
                return Unit.INSTANCE;
            }
        }
        portalBusiness$onTerminate$1 = new PortalBusiness$onTerminate$1(portalBusiness, continuation);
        Object obj2 = portalBusiness$onTerminate$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = portalBusiness$onTerminate$1.label;
        if (i3 != 0) {
        }
        portalBusiness$onTerminate$1.L$0 = portalBusiness;
        portalBusiness$onTerminate$1.label = 2;
        if (super.onTerminate(portalBusiness$onTerminate$1) == coroutine_suspended) {
        }
        portalBusiness.listenerPool.clear();
        return Unit.INSTANCE;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.IPortalBusiness
    public void addListener(String event, uk0.e listener) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(listener, "listener");
        HashSet<uk0.e> hashSet = this.listenerPool.get(event);
        if (hashSet == null) {
            hashSet = new HashSet<>();
        }
        hashSet.add(listener);
        this.listenerPool.put(event, hashSet);
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    public com.tencent.filament.zplan.business.api.a animate(double now, com.tencent.zplan.zplantracing.c zplanSpanContext) {
        FilamentViewerV2 viewerV2 = getViewerV2();
        if (viewerV2 != null) {
            this.canRender = this.animHelper.b0(viewerV2, now, zplanSpanContext) || this.canRender;
            double d16 = this.lastUpdateTime;
            double d17 = now - d16;
            if ((d16 < 0.0d) || this.isPausing.get()) {
                d17 = 0.0d;
            }
            viewerV2.updateParticleSystemWithDeltaTime(d17);
            if (this.isPausing.get()) {
                this.isPausing.set(false);
            }
            this.lastUpdateTime = now;
        }
        if (!this.enableRenderCompleteCallback || this.hasRender) {
            return null;
        }
        return this.mAnimRenderCallBack;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    /* renamed from: canRender, reason: from getter */
    public boolean getCanRender() {
        return this.canRender;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public boolean enablePelvisOffset() {
        return enablePlanarShadow();
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public boolean enablePlanarShadow() {
        return ((IZPlanApi) QRoute.api(IZPlanApi.class)).enablePortalPlanarShadow();
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public Object fetchAvatarInfo(AbsBusinessScene.FetchAvatarInfoFrom fetchAvatarInfoFrom, Continuation<? super JSONObject> continuation) {
        return fetchAvatarInfo$suspendImpl(this, fetchAvatarInfoFrom, continuation);
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public FetchActionData[] getActionDataArray(EnumUserGender gender) {
        Intrinsics.checkNotNullParameter(gender, "gender");
        QLog.i(TAG, 1, "getActionIdArray, enableSyncLoadInitAnim=" + this.enableSyncLoadInitAnim + " ");
        if (!this.enableSyncLoadInitAnim) {
            this.animHelper.Z();
            return null;
        }
        return this.animHelper.j0(gender, r94.c.h(this.avatarCharacter));
    }

    public final PortalAnimHelper getAnimHelper() {
        return this.animHelper;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.IPortalBusiness
    public qu4.a getAvatarCharacter() {
        return this.avatarCharacter;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public JSONObject getAvatarMask() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("showHandheld", true);
        return jSONObject;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public CameraParams getBodyTypeCamera(String bodyTypeName) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final CameraKey getInitCameraKey() {
        return this.initCameraKey;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public LightsParams getLightConfigAfterThemeChange() {
        boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
        QLog.i(TAG, 1, "getLightConfigAfterThemeChange, nightMode: " + isNowThemeIsNight);
        return k.f370019a.a(isNowThemeIsNight);
    }

    public final boolean getNeedFullReloadAfterFirstFrame() {
        return this.needFullReloadAfterFirstFrame;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.IPortalBusiness
    public PortalAnimHelper getPortalAnimHelper() {
        return this.animHelper;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.IPortalBusiness
    public boolean getPortalNeedFullReloadAfterFirstFrame() {
        return this.needFullReloadAfterFirstFrame;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.IPortalBusiness
    public FilamentUrlTemplate getPortalUrlTemplate() {
        return getUrlTemplate();
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public String getSceneConfig() {
        String loadSceneDebugCfg = loadSceneDebugCfg();
        if (loadSceneDebugCfg != null) {
            return loadSceneDebugCfg;
        }
        BusinessSceneConfig buildCfg = buildCfg();
        String cfg = new Gson().toJson(buildCfg);
        PortalAnimHelper portalAnimHelper = this.animHelper;
        String json = new Gson().toJson(buildCfg.getCamera());
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(portalCfg.camera)");
        portalAnimHelper.h1(json);
        QLog.i(TAG, 1, "getSceneConfig cfg=" + cfg);
        Intrinsics.checkNotNullExpressionValue(cfg, "cfg");
        return cfg;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    public SceneType getSceneType() {
        return SceneType.PORTAL;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.IPortalBusiness
    public FilamentViewerV2 getViewer() {
        return getViewerV2();
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    /* renamed from: launchOnIOThread, reason: from getter */
    public boolean getMEnableFilamentPreLaunch() {
        return this.mEnableFilamentPreLaunch;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public void loadAnimation(ZPlanAction[] actionArray, com.tencent.zplan.zplantracing.c zplanSpanContext) {
        Intrinsics.checkNotNullParameter(actionArray, "actionArray");
        QLog.i(TAG, 1, "loadAnimation actionArray:" + actionArray + ", viewerV2:" + getViewerV2());
        FilamentViewerV2 viewerV2 = getViewerV2();
        if (viewerV2 != null) {
            this.animHelper.u0(viewerV2, r94.c.h(this.avatarCharacter), actionArray, zplanSpanContext);
        }
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene
    public boolean needApplyShoesHeight() {
        return true;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    /* renamed from: needRecordFirstFrame, reason: from getter */
    public boolean getNeedRecordFirstFrame() {
        return this.needRecordFirstFrame;
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    public Object onPause(Continuation<? super Unit> continuation) {
        return onPause$suspendImpl(this, continuation);
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    public Object onTerminate(Continuation<? super Unit> continuation) {
        return onTerminate$suspendImpl(this, continuation);
    }

    @Override // com.tencent.filament.zplan.business.impl.AbsBusinessScene, com.tencent.filament.zplan.business.api.IBusinessScene
    public void processDispatchEvent(String event, final String eventData, com.tencent.zplan.zplantracing.c zplanSpanContext) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.processDispatchEvent(event, eventData, zplanSpanContext);
        if (Intrinsics.areEqual(event, "PortalPage.onColorInfoChange")) {
            if (eventData == null) {
                return;
            }
            doTask("updateColorInfo", new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.avatar.filament.PortalBusiness$processDispatchEvent$1
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
                    ZPlanAvatarService service;
                    com.tencent.filament.zplan.avatar.model.a w06 = ZPlanAvatarResourceHelper.f105660o.w0(com.tencent.zplan.common.utils.h.f385294a.b(eventData));
                    if (w06 == null) {
                        return;
                    }
                    service = this.getService();
                    if (service == null) {
                        FilamentViewerV2 viewerV2 = this.getViewerV2();
                        if (viewerV2 != null) {
                            viewerV2.updateColorInfo(w06);
                            return;
                        }
                        return;
                    }
                    FilamentViewerV2 viewerV22 = this.getViewerV2();
                    if (viewerV22 != null) {
                        viewerV22.updateColorInfoWithCpp(w06);
                    }
                }
            });
        } else {
            HashSet<uk0.e> hashSet = this.listenerPool.get(event);
            if (hashSet != null) {
                Iterator<T> it = hashSet.iterator();
                while (it.hasNext()) {
                    ((uk0.e) it.next()).onEvent(event, eventData == null ? "" : eventData);
                }
            }
        }
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.IPortalBusiness
    public void removeListener(String event, uk0.e listener) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(listener, "listener");
        HashSet<uk0.e> hashSet = this.listenerPool.get(event);
        if (hashSet == null) {
            return;
        }
        hashSet.remove(listener);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.IPortalBusiness, com.tencent.sqshow.zootopia.avatar.filament.i
    public void runOnViewerThread(String funName, Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(funName, "funName");
        Intrinsics.checkNotNullParameter(task, "task");
        doTask(funName, task);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.IPortalBusiness
    public void setCamera(String camera2) {
        Intrinsics.checkNotNullParameter(camera2, "camera");
        IPortalBusiness.a.a(this, camera2);
        this.animHelper.i1(camera2);
    }

    protected final void setInitCameraKey(CameraKey cameraKey) {
        Intrinsics.checkNotNullParameter(cameraKey, "<set-?>");
        this.initCameraKey = cameraKey;
    }

    public final void setNeedFullReloadAfterFirstFrame(boolean z16) {
        this.needFullReloadAfterFirstFrame = z16;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.IPortalBusiness
    public void setPortalNeedFullReloadAfterFirstFrame(boolean needReload) {
        this.needFullReloadAfterFirstFrame = needReload;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.IPortalBusiness
    public void setRenderListener(h listener) {
        this.renderListener = listener;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.IPortalBusiness
    public void updateAvatarCharacter(qu4.a ac5) {
        Intrinsics.checkNotNullParameter(ac5, "ac");
        this.avatarCharacter = ac5;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.IPortalBusiness
    public void updateInitCameraId(CameraKey cameraKey) {
        Intrinsics.checkNotNullParameter(cameraKey, "cameraKey");
        if (cameraKey.getCameraId() != 0) {
            this.initCameraKey = cameraKey;
        }
        QLog.i(TAG, 1, "updateInitCameraId cameraKey:" + cameraKey + ", initCameraKey:" + this.initCameraKey);
    }
}
