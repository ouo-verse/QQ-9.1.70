package com.tencent.sqshow.zootopia.avatar.filament;

import android.os.Handler;
import b94.a;
import com.google.gson.Gson;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.avatar.AvatarEngineType;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentNativeEngineApiImpl;
import com.tencent.sqshow.zootopia.avatar.filament.anim.AnimPath;
import com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper;
import com.tencent.sqshow.zootopia.nativeui.data.CameraKey;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.zplan.luabridge.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import qu4.q;
import s94.FaceControlPointData;
import s94.FaceInfoSyncData;
import t74.r;
import uv4.am;
import vk0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 O2\u00020\u0001:\u00028PB\u001f\u0012\u0006\u0010:\u001a\u00020$\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010>\u001a\u00020<\u00a2\u0006\u0004\bM\u0010NJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\u001a\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J@\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\"\u0010 \u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!J\u000e\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$J\u001a\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010+\u001a\u00020\u00062\u0006\u0010(\u001a\u00020*2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J,\u00101\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,2\b\u0010.\u001a\u0004\u0018\u00010,2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u00100\u001a\u00020/H\u0016J\u0012\u00102\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u00104\u001a\u00020\u00062\u0006\u00103\u001a\u00020\tH\u0016J\u0010\u00105\u001a\u00020\u00062\u0006\u00103\u001a\u00020\tH\u0016J\u001a\u00106\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u00108\u001a\u000207H\u0016R\u0016\u0010:\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u00109R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010;R\u0014\u0010>\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010=R\u0014\u0010A\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010@R\u0014\u0010D\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010CR\u0018\u0010G\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010FR\u001b\u0010L\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\u00a8\u0006Q"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/filament/FilamentNativeEngineApiImpl;", "Lb94/a;", "Lqu4/a;", "avatarCharacter", "Lorg/json/JSONObject;", "clickedItemParam", "", "u", "avatar", "", "v", "Lcom/tencent/sqshow/zootopia/avatar/filament/anim/a;", ReportConstant.COSTREPORT_PREFIX, "r", "", "from", HippyTKDListViewAdapter.X, "Lcom/tencent/sqshow/zootopia/avatar/AvatarEngineType;", "getType", "f", "i", "params", "Lcom/tencent/zplan/luabridge/a$b;", "cb", "l", "tag", "Lcom/tencent/zplan/zplantracing/b;", "zplanSpan", "d", "type", "clickedItem", "eventData", "w", "Lcom/tencent/sqshow/zootopia/avatar/filament/IPortalBusiness;", "scene", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lwk0/a;", "app", "y", "Ls94/b;", "data", "b", "Ls94/a;", "j", "Luv4/am;", "aiCameraCfg", "currentCameraCfg", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "e", "k", "enable", tl.h.F, "c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "a", "Lwk0/a;", "filamentNativeApp", "Lcom/tencent/sqshow/zootopia/avatar/filament/IPortalBusiness;", "Lcom/tencent/sqshow/zootopia/avatar/filament/FilamentTouchHelper;", "Lcom/tencent/sqshow/zootopia/avatar/filament/FilamentTouchHelper;", "touchHelper", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mChangeAvatarDressLock", "Lcom/tencent/sqshow/zootopia/avatar/filament/FilamentNativeEngineApiImpl$ResetLockTask;", "Lcom/tencent/sqshow/zootopia/avatar/filament/FilamentNativeEngineApiImpl$ResetLockTask;", "mResetLockTask", "Luk0/e;", "Luk0/e;", "mListener", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "t", "()Z", "enableCameraAnimation", "<init>", "(Lwk0/a;Lcom/tencent/sqshow/zootopia/avatar/filament/IPortalBusiness;Lcom/tencent/sqshow/zootopia/avatar/filament/FilamentTouchHelper;)V", "D", "ResetLockTask", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class FilamentNativeEngineApiImpl implements b94.a {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy enableCameraAnimation;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private wk0.a filamentNativeApp;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private IPortalBusiness scene;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final FilamentTouchHelper touchHelper;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean mChangeAvatarDressLock;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ResetLockTask mResetLockTask;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private uk0.e mListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/filament/FilamentNativeEngineApiImpl$ResetLockTask;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "Lcom/tencent/sqshow/zootopia/avatar/filament/FilamentNativeEngineApiImpl;", "d", "Ljava/lang/ref/WeakReference;", "getRef", "()Ljava/lang/ref/WeakReference;", "ref", "<init>", "(Ljava/lang/ref/WeakReference;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class ResetLockTask implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<FilamentNativeEngineApiImpl> ref;

        public ResetLockTask(WeakReference<FilamentNativeEngineApiImpl> ref) {
            Intrinsics.checkNotNullParameter(ref, "ref");
            this.ref = ref;
        }

        @Override // java.lang.Runnable
        public void run() {
            FilamentNativeEngineApiImpl filamentNativeEngineApiImpl = this.ref.get();
            if (filamentNativeEngineApiImpl != null) {
                filamentNativeEngineApiImpl.x("time out");
            }
            r.e(null, "zplan_portal_change_avatar_dress_time_out", null, 5, null);
        }
    }

    public FilamentNativeEngineApiImpl(wk0.a filamentNativeApp, IPortalBusiness scene, FilamentTouchHelper touchHelper) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(filamentNativeApp, "filamentNativeApp");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(touchHelper, "touchHelper");
        this.filamentNativeApp = filamentNativeApp;
        this.scene = scene;
        this.touchHelper = touchHelper;
        this.mChangeAvatarDressLock = new AtomicBoolean(false);
        this.mResetLockTask = new ResetLockTask(new WeakReference(this));
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.sqshow.zootopia.avatar.filament.FilamentNativeEngineApiImpl$enableCameraAnimation$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(ZPlanQQMC.INSTANCE.enableCameraAnimation());
            }
        });
        this.enableCameraAnimation = lazy;
    }

    private final boolean t() {
        return ((Boolean) this.enableCameraAnimation.getValue()).booleanValue();
    }

    private final void u(qu4.a avatarCharacter, JSONObject clickedItemParam) {
        PortalAnimHelper portalAnimHelper;
        AnimPath s16 = s(avatarCharacter, clickedItemParam);
        FilamentViewerV2 viewer = this.scene.getViewer();
        UEAvatarGender D = CommonExKt.D(avatarCharacter.f429576e);
        QLog.i("FilamentNativeEngineApiImpl", 1, "animPath:" + s16 + ", gender:" + D);
        if (viewer == null || s16 == null || D == null) {
            return;
        }
        boolean v3 = v(avatarCharacter, clickedItemParam);
        PortalAnimHelper portalAnimHelper2 = this.scene.getPortalAnimHelper();
        if (portalAnimHelper2 != null) {
            portalAnimHelper2.t0(viewer, D, s16, v3);
        }
        if (r(avatarCharacter, clickedItemParam) || (portalAnimHelper = this.scene.getPortalAnimHelper()) == null) {
            return;
        }
        portalAnimHelper.l1(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(String from) {
        QLog.i("FilamentNativeEngineApiImpl", 1, "resetLock from:" + from);
        this.mChangeAvatarDressLock.set(false);
    }

    @Override // b94.a
    public FilamentUrlTemplate a() {
        return this.scene.getPortalUrlTemplate();
    }

    @Override // b94.a
    public void b(FaceInfoSyncData data, a.b cb5) {
        Intrinsics.checkNotNullParameter(data, "data");
        String jSONObject = data.f().toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "data.toJson().toString()");
        QLog.i("FilamentNativeEngineApiImpl", 1, "syncFaceInfo params:" + jSONObject);
    }

    @Override // b94.a
    public void d(String from, qu4.a avatarCharacter, final JSONObject clickedItemParam, String tag, final a.b cb5, final com.tencent.zplan.zplantracing.b zplanSpan) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(avatarCharacter, "avatarCharacter");
        this.scene.updateAvatarCharacter(avatarCharacter);
        if (this.mChangeAvatarDressLock.get()) {
            QLog.e("FilamentNativeEngineApiImpl", 1, "changeAvatarDress mChangeAvatarDressLock is true");
            return;
        }
        this.mChangeAvatarDressLock.set(true);
        u(avatarCharacter, clickedItemParam);
        JSONObject h16 = r94.c.h(avatarCharacter);
        if (clickedItemParam != null) {
            h16.put("clicked_item_data", clickedItemParam);
        }
        if (tag != null) {
            h16.put("tag", tag);
        }
        String jSONObject = h16.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "paramJson.toString()");
        QLog.i("FilamentNativeEngineApiImpl", 1, "changeAvatarDress taskFrom:" + from + " , tag = " + tag);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("changeAvatarDress paramStr:");
        sb5.append(jSONObject);
        QLog.i("FilamentNativeEngineApiImpl", 1, sb5.toString());
        uk0.e eVar = this.mListener;
        if (eVar != null) {
            this.filamentNativeApp.t("onFirstFrameRenderEnd", eVar);
            this.filamentNativeApp.t("onFilamentRenderFail", eVar);
        }
        uk0.e eVar2 = new uk0.e() { // from class: com.tencent.sqshow.zootopia.avatar.filament.FilamentNativeEngineApiImpl$changeAvatarDress$listener$1
            @Override // uk0.e
            public void onEvent(String type, final String eventData) {
                wk0.a aVar;
                com.tencent.zplan.zplantracing.b bVar;
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(eventData, "eventData");
                QLog.i("FilamentNativeEngineApiImpl", 1, "changeAvatarDress onEvent type:" + type + ", eventData:" + eventData);
                FilamentNativeEngineApiImpl.this.w(type, clickedItemParam, eventData);
                if (Intrinsics.areEqual(type, "onFilamentRenderFail") && (bVar = zplanSpan) != null) {
                    bVar.a("render fail");
                }
                if (Intrinsics.areEqual(type, "onFirstFrameRenderEnd")) {
                    aVar = FilamentNativeEngineApiImpl.this.filamentNativeApp;
                    aVar.removeEventListener("onFirstFrameRenderEnd");
                    final FilamentNativeEngineApiImpl filamentNativeEngineApiImpl = FilamentNativeEngineApiImpl.this;
                    final a.b bVar2 = cb5;
                    final com.tencent.zplan.zplantracing.b bVar3 = zplanSpan;
                    CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.avatar.filament.FilamentNativeEngineApiImpl$changeAvatarDress$listener$1$onEvent$1
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
                            FilamentNativeEngineApiImpl.ResetLockTask resetLockTask;
                            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                            resetLockTask = FilamentNativeEngineApiImpl.this.mResetLockTask;
                            uIHandlerV2.removeCallbacks(resetLockTask);
                            FilamentNativeEngineApiImpl.this.x("onFirstFrameRenderEnd");
                            a.b bVar4 = bVar2;
                            if (bVar4 != null) {
                                bVar4.onLuaResult(true, eventData);
                            }
                            com.tencent.zplan.zplantracing.b bVar5 = bVar3;
                            if (bVar5 != null) {
                                bVar5.b();
                            }
                        }
                    });
                }
            }
        };
        this.mListener = eVar2;
        this.filamentNativeApp.c("onFirstFrameRenderEnd", eVar2);
        this.filamentNativeApp.c("onFilamentRenderFail", eVar2);
        this.filamentNativeApp.k("onCostumeChange", "", zplanSpan != null ? zplanSpan.c() : null);
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mResetLockTask);
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.mResetLockTask, 5000L);
    }

    @Override // b94.a
    public void e(am aiCameraCfg, am currentCameraCfg, a.b cb5, ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(aiCameraCfg, "aiCameraCfg");
        Intrinsics.checkNotNullParameter(source, "source");
        com.tencent.sqshow.zootopia.nativeui.data.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
        int index = cVar.n().getIndex();
        String b16 = ah.b(source);
        String jSONObject = r94.c.h(cVar.m().b().getAvatarCharacter()).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "AvatarDataCenter.getCurr\u2026acter.toJson().toString()");
        QLog.i("FilamentNativeEngineApiImpl", 1, "enterAiMakeFace gender:" + index + ", rootSourceId:" + b16);
        ((IZPlanIPCHelper) QRoute.api(IZPlanIPCHelper.class)).openFilamentFaceCamera(index, source, jSONObject);
    }

    @Override // b94.a
    public void f() {
        PortalAnimHelper portalAnimHelper = this.scene.getPortalAnimHelper();
        if (portalAnimHelper != null) {
            portalAnimHelper.n1();
        }
    }

    @Override // b94.a
    public void g(qu4.a aVar) {
        a.C0113a.e(this, aVar);
    }

    @Override // b94.a
    public AvatarEngineType getType() {
        return AvatarEngineType.FILAMENT;
    }

    @Override // b94.a
    public void i() {
        PortalAnimHelper portalAnimHelper = this.scene.getPortalAnimHelper();
        if (portalAnimHelper != null) {
            portalAnimHelper.o1();
        }
    }

    @Override // b94.a
    public void j(FaceControlPointData data, a.b cb5) {
        Intrinsics.checkNotNullParameter(data, "data");
        String jSONObject = data.c().toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "data.toJson().toString()");
        QLog.i("FilamentNativeEngineApiImpl", 1, "changeFaceControlPoint params:" + jSONObject);
    }

    @Override // b94.a
    public void k(a.b cb5) {
        this.touchHelper.h();
    }

    @Override // b94.a
    public void l(String params, a.b cb5) {
        Intrinsics.checkNotNullParameter(params, "params");
        QLog.i("FilamentNativeEngineApiImpl", 1, "setCameraConfig params:" + params);
        CameraKey cameraKey = new CameraKey(CommonExKt.A(params).optInt("id"), CommonExKt.A(params).optInt("body_item_id"));
        b84.a aVar = b84.a.f28061a;
        if (!aVar.f(cameraKey)) {
            QLog.e("FilamentNativeEngineApiImpl", 1, "setCameraConfig not support cameraKey:" + cameraKey);
            if (cb5 != null) {
                cb5.onLuaResult(true, "");
                return;
            }
            return;
        }
        final String cfgJson = new Gson().toJson(aVar.b(cameraKey, null));
        QLog.i("FilamentNativeEngineApiImpl", 1, "setCameraConfig cfgJson:" + cfgJson);
        this.touchHelper.i();
        this.touchHelper.h();
        if (t()) {
            IPortalBusiness iPortalBusiness = this.scene;
            Intrinsics.checkNotNullExpressionValue(cfgJson, "cfgJson");
            iPortalBusiness.setCamera(cfgJson);
        } else {
            this.scene.runOnViewerThread("setCamera", new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.avatar.filament.FilamentNativeEngineApiImpl$setCameraConfig$1
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
                    IPortalBusiness iPortalBusiness2;
                    iPortalBusiness2 = FilamentNativeEngineApiImpl.this.scene;
                    FilamentViewerV2 viewer = iPortalBusiness2.getViewer();
                    if (viewer != null) {
                        String cfgJson2 = cfgJson;
                        Intrinsics.checkNotNullExpressionValue(cfgJson2, "cfgJson");
                        viewer.setCamera(cfgJson2);
                    }
                }
            });
        }
        if (cb5 != null) {
            cb5.onLuaResult(true, "");
        }
    }

    @Override // b94.a
    public void m(qu4.a avatarCharacter, com.tencent.zplan.zplantracing.b zplanSpan) {
        Intrinsics.checkNotNullParameter(avatarCharacter, "avatarCharacter");
        a.C0113a.k(this, avatarCharacter, zplanSpan);
        this.scene.updateAvatarCharacter(avatarCharacter);
        wk0.a aVar = this.filamentNativeApp;
        qu4.c cVar = avatarCharacter.f429575d;
        Intrinsics.checkNotNullExpressionValue(cVar, "avatarCharacter.colorInfo");
        b.a.a(aVar, "PortalPage.onColorInfoChange", r94.c.j(cVar).toString(), null, 4, null);
    }

    public final void w(String type, JSONObject clickedItem, String eventData) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, "onFirstFrameRenderEnd") || Intrinsics.areEqual(type, "onFilamentRenderFail")) {
            HashMap hashMap = new HashMap();
            Map<String, String> a16 = com.tencent.zplan.common.utils.h.f385294a.a(eventData);
            if (a16 != null) {
                hashMap.putAll(a16);
            }
            String optString = clickedItem != null ? clickedItem.optString("item_id") : null;
            if (optString == null) {
                optString = "";
            }
            hashMap.put("clicked_item_id", optString);
            r.e(null, "zplan_portal_change_avatar_dress", hashMap, 1, null);
            QLog.i("FilamentNativeEngineApiImpl", 1, "reportChangeAvatarDressResult, params=" + hashMap);
        }
    }

    public final void y(wk0.a app) {
        Intrinsics.checkNotNullParameter(app, "app");
        this.filamentNativeApp = app;
    }

    public final void z(IPortalBusiness scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.scene = scene;
    }

    @Override // b94.a
    public void c(boolean enable) {
        if (enable) {
            this.touchHelper.d();
        } else {
            this.touchHelper.b();
        }
    }

    @Override // b94.a
    public void h(boolean enable) {
        if (enable) {
            this.touchHelper.c();
        } else {
            this.touchHelper.a();
        }
    }

    private final boolean r(qu4.a avatarCharacter, JSONObject clickedItemParam) {
        q qVar;
        if (clickedItemParam == null) {
            return false;
        }
        int optInt = clickedItemParam.optInt("item_id");
        q[] qVarArr = avatarCharacter.f429572a.f429578b;
        Intrinsics.checkNotNullExpressionValue(qVarArr, "avatarCharacter.avatarInfo.slotArr");
        int length = qVarArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                qVar = null;
                break;
            }
            qVar = qVarArr[i3];
            if (qVar.f429640b == optInt) {
                break;
            }
            i3++;
        }
        return qVar != null && qVar.f429639a == 201;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0035 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final AnimPath s(qu4.a avatarCharacter, JSONObject clickedItemParam) {
        qu4.r rVar;
        q[] qVarArr;
        q qVar;
        int optInt = clickedItemParam != null ? clickedItemParam.optInt("item_id") : 0;
        if (optInt == 0) {
            return null;
        }
        qu4.b bVar = avatarCharacter.f429572a;
        if (bVar != null && (qVarArr = bVar.f429578b) != null) {
            int length = qVarArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    qVar = null;
                    break;
                }
                qVar = qVarArr[i3];
                if (qVar.f429640b == optInt) {
                    break;
                }
                i3++;
            }
            if (qVar != null) {
                rVar = qVar.f429643e;
                if (rVar != null) {
                    return null;
                }
                String str = rVar.f429666w;
                Intrinsics.checkNotNullExpressionValue(str, "targetItem.headMontagePath");
                String z16 = CommonExKt.z(str);
                String str2 = rVar.f429667z;
                Intrinsics.checkNotNullExpressionValue(str2, "targetItem.bodyMontagePath");
                String z17 = CommonExKt.z(str2);
                QLog.i("FilamentNativeEngineApiImpl", 1, "getAnimPath headPath:" + z16 + ", bodyPath:" + z17);
                if (!(z16.length() > 0)) {
                    return null;
                }
                if (z17.length() > 0) {
                    return new AnimPath(z16, z17);
                }
                return null;
            }
        }
        rVar = null;
        if (rVar != null) {
        }
    }

    private final boolean v(qu4.a avatar, JSONObject clickedItemParam) {
        int optInt = clickedItemParam != null ? clickedItemParam.optInt("item_id") : 0;
        if (optInt == 0) {
            return false;
        }
        qu4.b bVar = avatar.f429572a;
        q[] qVarArr = bVar != null ? bVar.f429578b : null;
        if (qVarArr == null) {
            return false;
        }
        for (q qVar : qVarArr) {
            int i3 = qVar.f429639a;
            int i16 = qVar.f429640b;
            if (i3 == 201 && i16 == optInt) {
                return true;
            }
        }
        return false;
    }
}
