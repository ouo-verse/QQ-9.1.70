package com.tencent.filament.zplan.scene.intimateSpace;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.app.scene.BaseSceneV2308;
import com.tencent.filament.zplan.engine.CppSceneEnum;
import com.tencent.filament.zplan.engine.ZPlanFilamentScene;
import com.tencent.filament.zplan.scene.xwconnect.MiniHomeConnectScene;
import com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectDrawHandler;
import com.tencent.filament.zplan.scene.xwconnect.handler.ZPlanFilamentSceneLifeCycleHandler;
import com.tencent.filament.zplan.scene.xwconnect.handler.ZPlanFilamentSceneTouchHandler;
import com.tencent.filament.zplan.scene.xwconnect.handler.ZPlanFilamentSceneVsyncHandler;
import com.tencent.filament.zplanservice.channel.SceneEventConfig;
import com.tencent.filament.zplanservice.channel.f;
import com.tencent.filament.zplanservice.pbjava.XwConnect$DrawTextReq;
import com.tencent.filament.zplanservice.pbjava.sceneevent.SceneEventVsync$PauseVsync;
import com.tencent.filament.zplanservice.pbjava.sceneevent.SceneEventVsync$ResumeVsync;
import com.tencent.filament.zplanservice.pbjava.sceneevent.SceneEventVsync$StartVsync;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.zplan.zplantracing.c;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u00019\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010=\u001a\u0004\u0018\u00010<\u0012\f\u0010@\u001a\b\u0012\u0004\u0012\u00020?0>\u00a2\u0006\u0004\bA\u0010BJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016J \u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R,\u00108\u001a\u001a\u0012\u0004\u0012\u000203\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030504028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010;\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010:\u00a8\u0006C"}, d2 = {"Lcom/tencent/filament/zplan/scene/intimateSpace/IntimateSpaceScene;", "Lcom/tencent/filament/zplan/app/scene/BaseSceneV2308;", "", "viewWidth", "viewHeight", "Landroid/graphics/SurfaceTexture;", "surfaceTexture", "", "L", "width", "height", ReportConstant.COSTREPORT_PREFIX, "u", "surface", "t", "", "totalTime", "frameTime", "d", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "Lcom/tencent/filament/zplan/engine/ZPlanFilamentScene;", "D", "Lcom/tencent/filament/zplan/engine/ZPlanFilamentScene;", "filamentScene", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneVsyncHandler;", "E", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneVsyncHandler;", "vsyncHandler", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneLifeCycleHandler;", UserInfo.SEX_FEMALE, "Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneLifeCycleHandler;", "lifeCycleHandler", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneTouchHandler;", "G", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneTouchHandler;", "touchHandler", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectDrawHandler;", "H", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectDrawHandler;", "drawHandler", "Ljava/util/concurrent/atomic/AtomicBoolean;", "I", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasSurface", "", "J", "Z", "isDestroy", "", "", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/pb/MessageMicro;", "K", "Ljava/util/Map;", "handlerEventMap", "com/tencent/filament/zplan/scene/intimateSpace/IntimateSpaceScene$a", "Lcom/tencent/filament/zplan/scene/intimateSpace/IntimateSpaceScene$a;", "sceneHandler", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/app/impl/FilamentNativeAppV2305;", "app", "<init>", "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/ref/WeakReference;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class IntimateSpaceScene extends BaseSceneV2308 {

    /* renamed from: D, reason: from kotlin metadata */
    private ZPlanFilamentScene filamentScene;

    /* renamed from: E, reason: from kotlin metadata */
    private ZPlanFilamentSceneVsyncHandler vsyncHandler;

    /* renamed from: F, reason: from kotlin metadata */
    private ZPlanFilamentSceneLifeCycleHandler lifeCycleHandler;

    /* renamed from: G, reason: from kotlin metadata */
    private ZPlanFilamentSceneTouchHandler touchHandler;

    /* renamed from: H, reason: from kotlin metadata */
    private MiniHomeConnectDrawHandler drawHandler;

    /* renamed from: I, reason: from kotlin metadata */
    private AtomicBoolean hasSurface;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isDestroy;

    /* renamed from: K, reason: from kotlin metadata */
    private final Map<String, Class<? extends MessageMicro<?>>> handlerEventMap;

    /* renamed from: L, reason: from kotlin metadata */
    private final a sceneHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002O\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0001j\u0002`\u000bJ%\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00022\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\t\u001a\u00020\bH\u0096\u0002\u00a8\u0006\r"}, d2 = {"com/tencent/filament/zplan/scene/intimateSpace/IntimateSpaceScene$a", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", AdMetricTag.EVENT_NAME, "Lcom/tencent/mobileqq/pb/MessageMicro;", "pbField", "Lcom/tencent/filament/zplanservice/channel/a;", "callbackN2C", "", "Lcom/tencent/filament/zplanservice/channel/SceneHandler;", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class a implements Function3<String, MessageMicro<?>, com.tencent.filament.zplanservice.channel.a, Unit> {
        a() {
        }

        public void a(@NotNull String eventName, @NotNull MessageMicro<?> pbField, @NotNull com.tencent.filament.zplanservice.channel.a callbackN2C) {
            MiniHomeConnectDrawHandler miniHomeConnectDrawHandler;
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(pbField, "pbField");
            Intrinsics.checkNotNullParameter(callbackN2C, "callbackN2C");
            if (Intrinsics.areEqual(eventName, MiniHomeConnectScene.Companion.C2NEventName.START_VSYNC.getValue())) {
                ZPlanFilamentSceneVsyncHandler zPlanFilamentSceneVsyncHandler = IntimateSpaceScene.this.vsyncHandler;
                if (zPlanFilamentSceneVsyncHandler != null) {
                    zPlanFilamentSceneVsyncHandler.c(pbField);
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(eventName, MiniHomeConnectScene.Companion.C2NEventName.PAUSE_VSYNC.getValue())) {
                ZPlanFilamentSceneVsyncHandler zPlanFilamentSceneVsyncHandler2 = IntimateSpaceScene.this.vsyncHandler;
                if (zPlanFilamentSceneVsyncHandler2 != null) {
                    zPlanFilamentSceneVsyncHandler2.a();
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(eventName, MiniHomeConnectScene.Companion.C2NEventName.RESUME_VSYNC.getValue())) {
                ZPlanFilamentSceneVsyncHandler zPlanFilamentSceneVsyncHandler3 = IntimateSpaceScene.this.vsyncHandler;
                if (zPlanFilamentSceneVsyncHandler3 != null) {
                    zPlanFilamentSceneVsyncHandler3.b();
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(eventName, MiniHomeConnectScene.Companion.C2NEventName.DRAW_TEXT.getValue()) && (miniHomeConnectDrawHandler = IntimateSpaceScene.this.drawHandler) != null) {
                miniHomeConnectDrawHandler.f(pbField, callbackN2C);
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(String str, MessageMicro<?> messageMicro, com.tencent.filament.zplanservice.channel.a aVar) {
            a(str, messageMicro, aVar);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntimateSpaceScene(@Nullable c cVar, @NotNull final WeakReference<FilamentNativeAppV2305> app) {
        super(cVar, app);
        Map<String, Class<? extends MessageMicro<?>>> mutableMapOf;
        Intrinsics.checkNotNullParameter(app, "app");
        this.hasSurface = new AtomicBoolean(false);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(MiniHomeConnectScene.Companion.C2NEventName.START_VSYNC.getValue(), SceneEventVsync$StartVsync.class), TuplesKt.to(MiniHomeConnectScene.Companion.C2NEventName.PAUSE_VSYNC.getValue(), SceneEventVsync$PauseVsync.class), TuplesKt.to(MiniHomeConnectScene.Companion.C2NEventName.RESUME_VSYNC.getValue(), SceneEventVsync$ResumeVsync.class), TuplesKt.to(MiniHomeConnectScene.Companion.C2NEventName.DRAW_TEXT.getValue(), XwConnect$DrawTextReq.class));
        this.handlerEventMap = mutableMapOf;
        this.sceneHandler = new a();
        k().d("IntimateSpaceSceneInit", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.intimateSpace.IntimateSpaceScene.1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/filament/zplan/scene/intimateSpace/IntimateSpaceScene$1$a", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneVsyncHandler$b;", "", "fps", "", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
            /* renamed from: com.tencent.filament.zplan.scene.intimateSpace.IntimateSpaceScene$1$a */
            /* loaded from: classes6.dex */
            public static final class a implements ZPlanFilamentSceneVsyncHandler.b {
                a() {
                }

                @Override // com.tencent.filament.zplan.scene.xwconnect.handler.ZPlanFilamentSceneVsyncHandler.b
                public void a(float fps) {
                    IntimateSpaceScene.this.x(fps);
                }
            }

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
                IntimateSpaceScene intimateSpaceScene = IntimateSpaceScene.this;
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                intimateSpaceScene.filamentScene = new ZPlanFilamentScene(currentThread.getId(), CppSceneEnum.IntimateSpaceScene);
                ZPlanFilamentScene zPlanFilamentScene = IntimateSpaceScene.this.filamentScene;
                if (zPlanFilamentScene != null) {
                    long j3 = zPlanFilamentScene.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.SCENE_ID java.lang.String();
                    FilamentNativeAppV2305 filamentNativeAppV2305 = (FilamentNativeAppV2305) app.get();
                    if (filamentNativeAppV2305 != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(WadlProxyConsts.SCENE_ID, j3);
                        Unit unit = Unit.INSTANCE;
                        filamentNativeAppV2305.dispatchEvent(null, "IntimateSpaceScene.setSceneId", jSONObject.toString());
                    }
                }
                IntimateSpaceScene intimateSpaceScene2 = IntimateSpaceScene.this;
                ZPlanFilamentScene zPlanFilamentScene2 = IntimateSpaceScene.this.filamentScene;
                Intrinsics.checkNotNull(zPlanFilamentScene2);
                intimateSpaceScene2.vsyncHandler = new ZPlanFilamentSceneVsyncHandler(zPlanFilamentScene2.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.SCENE_ID java.lang.String());
                ZPlanFilamentSceneVsyncHandler zPlanFilamentSceneVsyncHandler = IntimateSpaceScene.this.vsyncHandler;
                Intrinsics.checkNotNull(zPlanFilamentSceneVsyncHandler);
                zPlanFilamentSceneVsyncHandler.d(new a());
                ZPlanFilamentSceneVsyncHandler zPlanFilamentSceneVsyncHandler2 = IntimateSpaceScene.this.vsyncHandler;
                if (zPlanFilamentSceneVsyncHandler2 != null) {
                    zPlanFilamentSceneVsyncHandler2.onCreate();
                }
                IntimateSpaceScene intimateSpaceScene3 = IntimateSpaceScene.this;
                WeakReference weakReference = app;
                ZPlanFilamentScene zPlanFilamentScene3 = IntimateSpaceScene.this.filamentScene;
                Intrinsics.checkNotNull(zPlanFilamentScene3);
                intimateSpaceScene3.lifeCycleHandler = new ZPlanFilamentSceneLifeCycleHandler(weakReference, zPlanFilamentScene3.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.SCENE_ID java.lang.String());
                ZPlanFilamentSceneLifeCycleHandler zPlanFilamentSceneLifeCycleHandler = IntimateSpaceScene.this.lifeCycleHandler;
                if (zPlanFilamentSceneLifeCycleHandler != null) {
                    zPlanFilamentSceneLifeCycleHandler.onCreate();
                }
                IntimateSpaceScene intimateSpaceScene4 = IntimateSpaceScene.this;
                WeakReference weakReference2 = app;
                ZPlanFilamentScene zPlanFilamentScene4 = IntimateSpaceScene.this.filamentScene;
                Intrinsics.checkNotNull(zPlanFilamentScene4);
                intimateSpaceScene4.touchHandler = new ZPlanFilamentSceneTouchHandler(weakReference2, zPlanFilamentScene4.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.SCENE_ID java.lang.String());
                ZPlanFilamentSceneTouchHandler zPlanFilamentSceneTouchHandler = IntimateSpaceScene.this.touchHandler;
                if (zPlanFilamentSceneTouchHandler != null) {
                    zPlanFilamentSceneTouchHandler.onCreate();
                }
                IntimateSpaceScene intimateSpaceScene5 = IntimateSpaceScene.this;
                WeakReference weakReference3 = app;
                ZPlanFilamentScene zPlanFilamentScene5 = IntimateSpaceScene.this.filamentScene;
                Intrinsics.checkNotNull(zPlanFilamentScene5);
                intimateSpaceScene5.drawHandler = new MiniHomeConnectDrawHandler(weakReference3, zPlanFilamentScene5.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.SCENE_ID java.lang.String());
                MiniHomeConnectDrawHandler miniHomeConnectDrawHandler = IntimateSpaceScene.this.drawHandler;
                if (miniHomeConnectDrawHandler != null) {
                    miniHomeConnectDrawHandler.onCreate();
                }
                f fVar = f.f106360b;
                ZPlanFilamentScene zPlanFilamentScene6 = IntimateSpaceScene.this.filamentScene;
                Intrinsics.checkNotNull(zPlanFilamentScene6);
                fVar.c(zPlanFilamentScene6.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.SCENE_ID java.lang.String(), new SceneEventConfig(IntimateSpaceScene.this.sceneHandler, IntimateSpaceScene.this.handlerEventMap));
                ZPlanFilamentScene zPlanFilamentScene7 = IntimateSpaceScene.this.filamentScene;
                if (zPlanFilamentScene7 != null) {
                    zPlanFilamentScene7.e();
                }
            }
        });
    }

    private final void L(final int viewWidth, final int viewHeight, final SurfaceTexture surfaceTexture) {
        if (this.isDestroy) {
            return;
        }
        k().d("attach", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.intimateSpace.IntimateSpaceScene$attach$1
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
                ZPlanFilamentScene zPlanFilamentScene = IntimateSpaceScene.this.filamentScene;
                if (zPlanFilamentScene != null) {
                    zPlanFilamentScene.b(viewWidth, viewHeight, new Surface(surfaceTexture), surfaceTexture, true);
                }
                atomicBoolean = IntimateSpaceScene.this.hasSurface;
                atomicBoolean.set(true);
            }
        });
    }

    @Override // com.tencent.filament.zplan.util.vsync.b
    public void d(long totalTime, long frameTime) {
        if (!this.hasSurface.get()) {
            return;
        }
        k().e(new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.intimateSpace.IntimateSpaceScene$onVSync$1
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
                ZPlanFilamentSceneVsyncHandler zPlanFilamentSceneVsyncHandler = IntimateSpaceScene.this.vsyncHandler;
                if (zPlanFilamentSceneVsyncHandler != null) {
                    zPlanFilamentSceneVsyncHandler.e();
                }
            }
        });
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void n() {
        super.n();
        this.isDestroy = true;
        k().d(MosaicConstants$JsFunction.FUNC_ON_DESTROY, new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.intimateSpace.IntimateSpaceScene$onDestroy$1
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
                ZPlanFilamentSceneVsyncHandler zPlanFilamentSceneVsyncHandler = IntimateSpaceScene.this.vsyncHandler;
                if (zPlanFilamentSceneVsyncHandler != null) {
                    zPlanFilamentSceneVsyncHandler.onDestroy();
                }
                ZPlanFilamentSceneLifeCycleHandler zPlanFilamentSceneLifeCycleHandler = IntimateSpaceScene.this.lifeCycleHandler;
                if (zPlanFilamentSceneLifeCycleHandler != null) {
                    zPlanFilamentSceneLifeCycleHandler.onDestroy();
                }
                ZPlanFilamentSceneTouchHandler zPlanFilamentSceneTouchHandler = IntimateSpaceScene.this.touchHandler;
                if (zPlanFilamentSceneTouchHandler != null) {
                    zPlanFilamentSceneTouchHandler.onDestroy();
                }
                MiniHomeConnectDrawHandler miniHomeConnectDrawHandler = IntimateSpaceScene.this.drawHandler;
                if (miniHomeConnectDrawHandler != null) {
                    miniHomeConnectDrawHandler.onDestroy();
                }
                ZPlanFilamentScene zPlanFilamentScene = IntimateSpaceScene.this.filamentScene;
                if (zPlanFilamentScene != null) {
                    f.f106360b.d(zPlanFilamentScene.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.SCENE_ID java.lang.String());
                }
                ZPlanFilamentScene zPlanFilamentScene2 = IntimateSpaceScene.this.filamentScene;
                if (zPlanFilamentScene2 != null) {
                    zPlanFilamentScene2.c();
                }
                IntimateSpaceScene.this.filamentScene = null;
                IntimateSpaceScene.this.k().i();
            }
        });
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void q() {
        super.q();
        ZPlanFilamentSceneLifeCycleHandler zPlanFilamentSceneLifeCycleHandler = this.lifeCycleHandler;
        if (zPlanFilamentSceneLifeCycleHandler != null) {
            zPlanFilamentSceneLifeCycleHandler.f();
        }
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void r() {
        super.r();
        ZPlanFilamentSceneLifeCycleHandler zPlanFilamentSceneLifeCycleHandler = this.lifeCycleHandler;
        if (zPlanFilamentSceneLifeCycleHandler != null) {
            zPlanFilamentSceneLifeCycleHandler.g();
        }
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void s(@NotNull SurfaceTexture surfaceTexture, int width, int height) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        super.s(surfaceTexture, width, height);
        L(width, height, surfaceTexture);
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void t(@NotNull SurfaceTexture surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        super.t(surface);
        this.hasSurface.set(false);
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void u(@NotNull SurfaceTexture surfaceTexture, int width, int height) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        super.u(surfaceTexture, width, height);
        L(width, height, surfaceTexture);
    }
}
