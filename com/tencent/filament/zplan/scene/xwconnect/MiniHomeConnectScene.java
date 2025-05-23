package com.tencent.filament.zplan.scene.xwconnect;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.app.scene.BaseSceneV2308;
import com.tencent.filament.zplan.app.view.FilamentTextureViewV2305;
import com.tencent.filament.zplan.engine.CppSceneEnum;
import com.tencent.filament.zplan.engine.ZPlanFilamentScene;
import com.tencent.filament.zplan.scene.xwconnect.MiniHomeConnectScene;
import com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectDrawHandler;
import com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectFocusStateHandler;
import com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectHuatengHandler;
import com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectPlayCoupleActionHandler;
import com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectSceneEventHandler;
import com.tencent.filament.zplan.scene.xwconnect.handler.ZPlanFilamentSceneLifeCycleHandler;
import com.tencent.filament.zplan.scene.xwconnect.handler.ZPlanFilamentSceneTouchHandler;
import com.tencent.filament.zplan.scene.xwconnect.handler.ZPlanFilamentSceneVsyncHandler;
import com.tencent.filament.zplan.scene.xwconnect.handler.a;
import com.tencent.filament.zplan.scene.xwconnect.handler.b;
import com.tencent.filament.zplan.scene.xwconnect.handler.c;
import com.tencent.filament.zplan.scene.xwconnect.handler.d;
import com.tencent.filament.zplanservice.channel.SceneEventConfig;
import com.tencent.filament.zplanservice.channel.f;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.pbjava.XwConnect$DrawImageReq;
import com.tencent.filament.zplanservice.pbjava.XwConnect$DrawTextReq;
import com.tencent.filament.zplanservice.pbjava.sceneevent.MiniConnectMaskLayerInfo$MaskLayerInfo;
import com.tencent.filament.zplanservice.pbjava.sceneevent.NativeDoFlowerOp$NotifyFlowerUi;
import com.tencent.filament.zplanservice.pbjava.sceneevent.SceneEventCallback$SceneCallbackEvent;
import com.tencent.filament.zplanservice.pbjava.sceneevent.SceneEventVsync$PauseVsync;
import com.tencent.filament.zplanservice.pbjava.sceneevent.SceneEventVsync$ResumeVsync;
import com.tencent.filament.zplanservice.pbjava.sceneevent.SceneEventVsync$StartVsync;
import com.tencent.filament.zplanservice.pbjava.sceneevent.SceneStartupParam$StartupParam;
import com.tencent.filament.zplanservice.pbjava.sceneevent.SceneStateChange$EngineStateChangeEvent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00cd\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001a\u0018\u0000 l2\u00020\u0001:\u0001mB\u001f\u0012\b\u0010f\u001a\u0004\u0018\u00010e\u0012\f\u0010i\u001a\b\u0012\u0004\u0012\u00020h0g\u00a2\u0006\u0004\bj\u0010kJ\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J \u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J \u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010R\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010\u001dR#\u0010Y\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010T0S8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR,\u0010`\u001a\u001a\u0012\u0004\u0012\u00020[\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030]0\\0Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010d\u001a\u00020a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010c\u00a8\u0006n"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/MiniHomeConnectScene;", "Lcom/tencent/filament/zplan/app/scene/BaseSceneV2308;", "", "e0", "Landroid/graphics/SurfaceTexture;", "surfaceTexture", "", "width", "height", ReportConstant.COSTREPORT_PREFIX, "u", "surface", "t", "", "totalTime", "frameTime", "d", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "viewWidth", "viewHeight", "c0", "Lcom/tencent/filament/zplan/engine/ZPlanFilamentScene;", "D", "Lcom/tencent/filament/zplan/engine/ZPlanFilamentScene;", "homeConnect", "", "E", "Z", "isDestroy", "Ljava/util/concurrent/atomic/AtomicBoolean;", UserInfo.SEX_FEMALE, "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasSurface", "G", "hasAttachedSurfaceTexture", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectFocusStateHandler;", "H", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectFocusStateHandler;", "miniHomeConnectFocusState", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectPlayCoupleActionHandler;", "I", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectPlayCoupleActionHandler;", "miniHomeConnectPlayCoupleAtion", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectSceneEventHandler;", "J", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectSceneEventHandler;", "miniHomeConnectSceneEvent", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/c;", "K", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/c;", "miniHomeConnectSceneClickHandler", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/d;", "L", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/d;", "miniHomeConnectSceneStartupHandler", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneTouchHandler;", "M", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneTouchHandler;", "touchHandler", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneVsyncHandler;", "N", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneVsyncHandler;", "vsyncHandler", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneLifeCycleHandler;", "P", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneLifeCycleHandler;", "lifeCycleHandler", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectDrawHandler;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectDrawHandler;", "miniHomeConnectDrawHandler", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/b;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/filament/zplan/scene/xwconnect/handler/b;", "miniHomeConnectMaskLayerHandler", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectHuatengHandler;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectHuatengHandler;", "minihomeConnectHuatengHandler", "T", "enableCppRetain", "", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/a;", "U", "Lkotlin/Lazy;", "d0", "()Ljava/util/List;", "sceneHandlerList", "", "", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/pb/MessageMicro;", "V", "Ljava/util/Map;", "handlerEventMap", "com/tencent/filament/zplan/scene/xwconnect/MiniHomeConnectScene$b", "W", "Lcom/tencent/filament/zplan/scene/xwconnect/MiniHomeConnectScene$b;", "sceneHandler", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/app/impl/FilamentNativeAppV2305;", "app", "<init>", "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/ref/WeakReference;)V", "X", "Companion", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class MiniHomeConnectScene extends BaseSceneV2308 {

    /* renamed from: D, reason: from kotlin metadata */
    private ZPlanFilamentScene homeConnect;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isDestroy;

    /* renamed from: F, reason: from kotlin metadata */
    private AtomicBoolean hasSurface;

    /* renamed from: G, reason: from kotlin metadata */
    private AtomicBoolean hasAttachedSurfaceTexture;

    /* renamed from: H, reason: from kotlin metadata */
    private MiniHomeConnectFocusStateHandler miniHomeConnectFocusState;

    /* renamed from: I, reason: from kotlin metadata */
    private MiniHomeConnectPlayCoupleActionHandler miniHomeConnectPlayCoupleAtion;

    /* renamed from: J, reason: from kotlin metadata */
    private MiniHomeConnectSceneEventHandler miniHomeConnectSceneEvent;

    /* renamed from: K, reason: from kotlin metadata */
    private c miniHomeConnectSceneClickHandler;

    /* renamed from: L, reason: from kotlin metadata */
    private d miniHomeConnectSceneStartupHandler;

    /* renamed from: M, reason: from kotlin metadata */
    private ZPlanFilamentSceneTouchHandler touchHandler;

    /* renamed from: N, reason: from kotlin metadata */
    private ZPlanFilamentSceneVsyncHandler vsyncHandler;

    /* renamed from: P, reason: from kotlin metadata */
    private ZPlanFilamentSceneLifeCycleHandler lifeCycleHandler;

    /* renamed from: Q, reason: from kotlin metadata */
    private MiniHomeConnectDrawHandler miniHomeConnectDrawHandler;

    /* renamed from: R, reason: from kotlin metadata */
    private com.tencent.filament.zplan.scene.xwconnect.handler.b miniHomeConnectMaskLayerHandler;

    /* renamed from: S, reason: from kotlin metadata */
    private MiniHomeConnectHuatengHandler minihomeConnectHuatengHandler;

    /* renamed from: T, reason: from kotlin metadata */
    private final boolean enableCppRetain;

    /* renamed from: U, reason: from kotlin metadata */
    private final Lazy sceneHandlerList;

    /* renamed from: V, reason: from kotlin metadata */
    private final Map<String, Class<? extends MessageMicro<?>>> handlerEventMap;

    /* renamed from: W, reason: from kotlin metadata */
    private final b sceneHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/filament/zplan/scene/xwconnect/MiniHomeConnectScene$a", "Lsk0/b;", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "type", "data", "", "handleEvent", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class a implements sk0.b {
        a() {
        }

        @Override // sk0.b
        public void handleEvent(@Nullable com.tencent.zplan.zplantracing.c spanContext, @NotNull String type, @Nullable String data) {
            Intrinsics.checkNotNullParameter(type, "type");
            if (Intrinsics.areEqual(type, Companion.EVENT.INIT_HOME_CONNECT.name())) {
                MiniHomeConnectScene.this.e0();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002O\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0001j\u0002`\u000bJ%\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00022\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\t\u001a\u00020\bH\u0096\u0002\u00a8\u0006\r"}, d2 = {"com/tencent/filament/zplan/scene/xwconnect/MiniHomeConnectScene$b", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", AdMetricTag.EVENT_NAME, "Lcom/tencent/mobileqq/pb/MessageMicro;", "pbField", "Lcom/tencent/filament/zplanservice/channel/a;", "callbackN2C", "", "Lcom/tencent/filament/zplanservice/channel/SceneHandler;", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class b implements Function3<String, MessageMicro<?>, com.tencent.filament.zplanservice.channel.a, Unit> {
        b() {
        }

        public void a(@NotNull String eventName, @NotNull MessageMicro<?> pbField, @NotNull com.tencent.filament.zplanservice.channel.a callbackN2C) {
            MiniHomeConnectHuatengHandler miniHomeConnectHuatengHandler;
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(pbField, "pbField");
            Intrinsics.checkNotNullParameter(callbackN2C, "callbackN2C");
            if (Intrinsics.areEqual(eventName, Companion.C2NEventName.START_VSYNC.getValue())) {
                ZPlanFilamentSceneVsyncHandler zPlanFilamentSceneVsyncHandler = MiniHomeConnectScene.this.vsyncHandler;
                if (zPlanFilamentSceneVsyncHandler != null) {
                    zPlanFilamentSceneVsyncHandler.c(pbField);
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(eventName, Companion.C2NEventName.PAUSE_VSYNC.getValue())) {
                ZPlanFilamentSceneVsyncHandler zPlanFilamentSceneVsyncHandler2 = MiniHomeConnectScene.this.vsyncHandler;
                if (zPlanFilamentSceneVsyncHandler2 != null) {
                    zPlanFilamentSceneVsyncHandler2.a();
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(eventName, Companion.C2NEventName.RESUME_VSYNC.getValue())) {
                ZPlanFilamentSceneVsyncHandler zPlanFilamentSceneVsyncHandler3 = MiniHomeConnectScene.this.vsyncHandler;
                if (zPlanFilamentSceneVsyncHandler3 != null) {
                    zPlanFilamentSceneVsyncHandler3.b();
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(eventName, Companion.C2NEventName.SCENE_CALLBACK.getValue())) {
                c cVar = MiniHomeConnectScene.this.miniHomeConnectSceneClickHandler;
                if (cVar != null) {
                    cVar.a(pbField, callbackN2C);
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(eventName, Companion.C2NEventName.START_UP.getValue())) {
                d dVar = MiniHomeConnectScene.this.miniHomeConnectSceneStartupHandler;
                if (dVar != null) {
                    dVar.b(callbackN2C);
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(eventName, Companion.C2NEventName.DRAW_TEXT.getValue())) {
                MiniHomeConnectDrawHandler miniHomeConnectDrawHandler = MiniHomeConnectScene.this.miniHomeConnectDrawHandler;
                if (miniHomeConnectDrawHandler != null) {
                    miniHomeConnectDrawHandler.f(pbField, callbackN2C);
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(eventName, Companion.C2NEventName.DRAW_IMAGE.getValue())) {
                MiniHomeConnectDrawHandler miniHomeConnectDrawHandler2 = MiniHomeConnectScene.this.miniHomeConnectDrawHandler;
                if (miniHomeConnectDrawHandler2 != null) {
                    miniHomeConnectDrawHandler2.e(pbField, callbackN2C);
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(eventName, Companion.C2NEventName.ON_MASK_LAYER_DATA_READY.getValue())) {
                com.tencent.filament.zplan.scene.xwconnect.handler.b bVar = MiniHomeConnectScene.this.miniHomeConnectMaskLayerHandler;
                if (bVar != null) {
                    bVar.a((MiniConnectMaskLayerInfo$MaskLayerInfo) pbField);
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(eventName, Companion.C2NEventName.ON_ENGINE_STATE_CHANGE.getValue())) {
                MiniHomeConnectFocusStateHandler miniHomeConnectFocusStateHandler = MiniHomeConnectScene.this.miniHomeConnectFocusState;
                if (miniHomeConnectFocusStateHandler != null) {
                    miniHomeConnectFocusStateHandler.d((SceneStateChange$EngineStateChangeEvent) pbField);
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(eventName, Companion.C2NEventName.NOTIFY_FLOWER_UI.getValue()) && (miniHomeConnectHuatengHandler = MiniHomeConnectScene.this.minihomeConnectHuatengHandler) != null) {
                miniHomeConnectHuatengHandler.h((NativeDoFlowerOp$NotifyFlowerUi) pbField);
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(String str, MessageMicro<?> messageMicro, com.tencent.filament.zplanservice.channel.a aVar) {
            a(str, messageMicro, aVar);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeConnectScene(@Nullable com.tencent.zplan.zplantracing.c cVar, @NotNull WeakReference<FilamentNativeAppV2305> app) {
        super(cVar, app);
        Lazy lazy;
        Map<String, Class<? extends MessageMicro<?>>> mutableMapOf;
        Intrinsics.checkNotNullParameter(app, "app");
        this.hasSurface = new AtomicBoolean(false);
        this.hasAttachedSurfaceTexture = new AtomicBoolean(false);
        this.enableCppRetain = FilamentFeatureUtil.f106409g.h();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends com.tencent.filament.zplan.scene.xwconnect.handler.a>>() { // from class: com.tencent.filament.zplan.scene.xwconnect.MiniHomeConnectScene$sceneHandlerList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends a> invoke() {
                MiniHomeConnectPlayCoupleActionHandler miniHomeConnectPlayCoupleActionHandler;
                MiniHomeConnectSceneEventHandler miniHomeConnectSceneEventHandler;
                ZPlanFilamentSceneTouchHandler zPlanFilamentSceneTouchHandler;
                ZPlanFilamentSceneLifeCycleHandler zPlanFilamentSceneLifeCycleHandler;
                List<? extends a> listOf;
                miniHomeConnectPlayCoupleActionHandler = MiniHomeConnectScene.this.miniHomeConnectPlayCoupleAtion;
                miniHomeConnectSceneEventHandler = MiniHomeConnectScene.this.miniHomeConnectSceneEvent;
                zPlanFilamentSceneTouchHandler = MiniHomeConnectScene.this.touchHandler;
                zPlanFilamentSceneLifeCycleHandler = MiniHomeConnectScene.this.lifeCycleHandler;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new a[]{MiniHomeConnectScene.this.miniHomeConnectFocusState, miniHomeConnectPlayCoupleActionHandler, miniHomeConnectSceneEventHandler, MiniHomeConnectScene.this.miniHomeConnectSceneClickHandler, MiniHomeConnectScene.this.miniHomeConnectSceneStartupHandler, zPlanFilamentSceneTouchHandler, MiniHomeConnectScene.this.vsyncHandler, zPlanFilamentSceneLifeCycleHandler, MiniHomeConnectScene.this.miniHomeConnectDrawHandler, MiniHomeConnectScene.this.miniHomeConnectMaskLayerHandler, MiniHomeConnectScene.this.minihomeConnectHuatengHandler});
                return listOf;
            }
        });
        this.sceneHandlerList = lazy;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(Companion.C2NEventName.START_VSYNC.getValue(), SceneEventVsync$StartVsync.class), TuplesKt.to(Companion.C2NEventName.PAUSE_VSYNC.getValue(), SceneEventVsync$PauseVsync.class), TuplesKt.to(Companion.C2NEventName.RESUME_VSYNC.getValue(), SceneEventVsync$ResumeVsync.class), TuplesKt.to(Companion.C2NEventName.SCENE_CALLBACK.getValue(), SceneEventCallback$SceneCallbackEvent.class), TuplesKt.to(Companion.C2NEventName.START_UP.getValue(), SceneStartupParam$StartupParam.class), TuplesKt.to(Companion.C2NEventName.DRAW_TEXT.getValue(), XwConnect$DrawTextReq.class), TuplesKt.to(Companion.C2NEventName.DRAW_IMAGE.getValue(), XwConnect$DrawImageReq.class), TuplesKt.to(Companion.C2NEventName.ON_MASK_LAYER_DATA_READY.getValue(), MiniConnectMaskLayerInfo$MaskLayerInfo.class), TuplesKt.to(Companion.C2NEventName.ON_ENGINE_STATE_CHANGE.getValue(), SceneStateChange$EngineStateChangeEvent.class), TuplesKt.to(Companion.C2NEventName.NOTIFY_FLOWER_UI.getValue(), NativeDoFlowerOp$NotifyFlowerUi.class));
        this.handlerEventMap = mutableMapOf;
        this.sceneHandler = new b();
        a aVar = new a();
        FilamentNativeAppV2305 filamentNativeAppV2305 = app.get();
        if (filamentNativeAppV2305 != null) {
            filamentNativeAppV2305.addEventListener(Companion.EVENT.INIT_HOME_CONNECT.name(), aVar);
        }
    }

    private final void c0(final int viewWidth, final int viewHeight, final SurfaceTexture surfaceTexture) {
        if (this.isDestroy) {
            return;
        }
        k().d("attach", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.xwconnect.MiniHomeConnectScene$attach$1
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

            /* JADX WARN: Code restructure failed: missing block: B:5:0x0016, code lost:
            
                r2 = r8.this$0.homeConnect;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                boolean z16;
                ZPlanFilamentScene zPlanFilamentScene;
                boolean z17;
                AtomicBoolean atomicBoolean;
                AtomicBoolean atomicBoolean2;
                ZPlanFilamentScene zPlanFilamentScene2;
                boolean z18;
                z16 = MiniHomeConnectScene.this.enableCppRetain;
                if (z16) {
                    atomicBoolean2 = MiniHomeConnectScene.this.hasAttachedSurfaceTexture;
                    if (atomicBoolean2.compareAndSet(false, true) && zPlanFilamentScene2 != null) {
                        int i3 = viewWidth;
                        int i16 = viewHeight;
                        Surface surface = new Surface(surfaceTexture);
                        SurfaceTexture surfaceTexture2 = surfaceTexture;
                        z18 = MiniHomeConnectScene.this.enableCppRetain;
                        zPlanFilamentScene2.b(i3, i16, surface, surfaceTexture2, z18);
                    }
                } else {
                    zPlanFilamentScene = MiniHomeConnectScene.this.homeConnect;
                    if (zPlanFilamentScene != null) {
                        int i17 = viewWidth;
                        int i18 = viewHeight;
                        Surface surface2 = new Surface(surfaceTexture);
                        SurfaceTexture surfaceTexture3 = surfaceTexture;
                        z17 = MiniHomeConnectScene.this.enableCppRetain;
                        zPlanFilamentScene.b(i17, i18, surface2, surfaceTexture3, z17);
                    }
                }
                atomicBoolean = MiniHomeConnectScene.this.hasSurface;
                atomicBoolean.set(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<com.tencent.filament.zplan.scene.xwconnect.handler.a> d0() {
        return (List) this.sceneHandlerList.getValue();
    }

    @Override // com.tencent.filament.zplan.util.vsync.b
    public void d(long totalTime, long frameTime) {
        if (!this.hasSurface.get()) {
            return;
        }
        k().e(new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.xwconnect.MiniHomeConnectScene$onVSync$1
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
                ZPlanFilamentSceneVsyncHandler zPlanFilamentSceneVsyncHandler = MiniHomeConnectScene.this.vsyncHandler;
                if (zPlanFilamentSceneVsyncHandler != null) {
                    zPlanFilamentSceneVsyncHandler.e();
                }
            }
        });
    }

    public final void e0() {
        k().d("FilamentMiniHomeConnect", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.xwconnect.MiniHomeConnectScene$initScene$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006\u00b8\u0006\u0007"}, d2 = {"com/tencent/filament/zplan/scene/xwconnect/MiniHomeConnectScene$initScene$1$1$1$1", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneVsyncHandler$b;", "", "fps", "", "a", "zplan-android_release", "com/tencent/filament/zplan/scene/xwconnect/MiniHomeConnectScene$initScene$1$$special$$inlined$apply$lambda$1"}, k = 1, mv = {1, 4, 2})
            /* loaded from: classes6.dex */
            public static final class a implements ZPlanFilamentSceneVsyncHandler.b {
                a() {
                }

                @Override // com.tencent.filament.zplan.scene.xwconnect.handler.ZPlanFilamentSceneVsyncHandler.b
                public void a(float fps) {
                    MiniHomeConnectScene.this.x(fps);
                }
            }

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
                List<com.tencent.filament.zplan.scene.xwconnect.handler.a> d06;
                MiniHomeConnectScene.b bVar;
                Map map;
                MiniHomeConnectScene miniHomeConnectScene = MiniHomeConnectScene.this;
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                ZPlanFilamentScene zPlanFilamentScene = new ZPlanFilamentScene(currentThread.getId(), CppSceneEnum.ZPlanXwConnectScene);
                MiniHomeConnectScene.this.miniHomeConnectFocusState = new MiniHomeConnectFocusStateHandler(MiniHomeConnectScene.this.j(), zPlanFilamentScene.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.SCENE_ID java.lang.String());
                MiniHomeConnectScene.this.miniHomeConnectPlayCoupleAtion = new MiniHomeConnectPlayCoupleActionHandler(MiniHomeConnectScene.this.j());
                MiniHomeConnectScene.this.miniHomeConnectSceneEvent = new MiniHomeConnectSceneEventHandler(MiniHomeConnectScene.this.j(), zPlanFilamentScene.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.SCENE_ID java.lang.String());
                MiniHomeConnectScene.this.miniHomeConnectSceneClickHandler = new c(MiniHomeConnectScene.this.j());
                MiniHomeConnectScene.this.miniHomeConnectSceneStartupHandler = new d(MiniHomeConnectScene.this.j(), zPlanFilamentScene.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.SCENE_ID java.lang.String());
                MiniHomeConnectScene.this.touchHandler = new ZPlanFilamentSceneTouchHandler(MiniHomeConnectScene.this.j(), zPlanFilamentScene.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.SCENE_ID java.lang.String());
                MiniHomeConnectScene miniHomeConnectScene2 = MiniHomeConnectScene.this;
                ZPlanFilamentSceneVsyncHandler zPlanFilamentSceneVsyncHandler = new ZPlanFilamentSceneVsyncHandler(zPlanFilamentScene.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.SCENE_ID java.lang.String());
                zPlanFilamentSceneVsyncHandler.d(new a());
                Unit unit = Unit.INSTANCE;
                miniHomeConnectScene2.vsyncHandler = zPlanFilamentSceneVsyncHandler;
                MiniHomeConnectScene.this.lifeCycleHandler = new ZPlanFilamentSceneLifeCycleHandler(MiniHomeConnectScene.this.j(), zPlanFilamentScene.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.SCENE_ID java.lang.String());
                MiniHomeConnectScene.this.miniHomeConnectDrawHandler = new MiniHomeConnectDrawHandler(MiniHomeConnectScene.this.j(), zPlanFilamentScene.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.SCENE_ID java.lang.String());
                MiniHomeConnectScene.this.miniHomeConnectMaskLayerHandler = new b(MiniHomeConnectScene.this.j(), zPlanFilamentScene.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.SCENE_ID java.lang.String());
                MiniHomeConnectScene.this.minihomeConnectHuatengHandler = new MiniHomeConnectHuatengHandler(MiniHomeConnectScene.this.j(), zPlanFilamentScene.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.SCENE_ID java.lang.String());
                d06 = MiniHomeConnectScene.this.d0();
                for (com.tencent.filament.zplan.scene.xwconnect.handler.a aVar : d06) {
                    if (aVar != null) {
                        aVar.onCreate();
                    }
                }
                f fVar = f.f106360b;
                long j3 = zPlanFilamentScene.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.SCENE_ID java.lang.String();
                bVar = MiniHomeConnectScene.this.sceneHandler;
                map = MiniHomeConnectScene.this.handlerEventMap;
                fVar.c(j3, new SceneEventConfig(bVar, map));
                zPlanFilamentScene.e();
                Unit unit2 = Unit.INSTANCE;
                miniHomeConnectScene.homeConnect = zPlanFilamentScene;
            }
        });
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void n() {
        final FilamentNativeAppV2305 filamentNativeAppV2305;
        super.n();
        this.isDestroy = true;
        FilamentFeatureUtil filamentFeatureUtil = FilamentFeatureUtil.f106409g;
        if (filamentFeatureUtil.n()) {
            filamentNativeAppV2305 = j().get();
        } else {
            filamentNativeAppV2305 = null;
        }
        k().g(MosaicConstants$JsFunction.FUNC_ON_DESTROY, filamentFeatureUtil.s(), new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.xwconnect.MiniHomeConnectScene$onDestroy$1
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
                List<a> d06;
                ZPlanFilamentScene zPlanFilamentScene;
                ZPlanFilamentScene zPlanFilamentScene2;
                boolean z16;
                FilamentTextureViewV2305 a16;
                d06 = MiniHomeConnectScene.this.d0();
                for (a aVar : d06) {
                    if (aVar != null) {
                        aVar.onDestroy();
                    }
                }
                zPlanFilamentScene = MiniHomeConnectScene.this.homeConnect;
                if (zPlanFilamentScene != null) {
                    f.f106360b.d(zPlanFilamentScene.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.SCENE_ID java.lang.String());
                }
                zPlanFilamentScene2 = MiniHomeConnectScene.this.homeConnect;
                if (zPlanFilamentScene2 != null) {
                    zPlanFilamentScene2.c();
                }
                MiniHomeConnectScene.this.homeConnect = null;
                FilamentNativeAppV2305 filamentNativeAppV23052 = filamentNativeAppV2305;
                if (filamentNativeAppV23052 == null) {
                    filamentNativeAppV23052 = MiniHomeConnectScene.this.j().get();
                }
                z16 = MiniHomeConnectScene.this.enableCppRetain;
                if (!z16 && filamentNativeAppV23052 != null && (a16 = filamentNativeAppV23052.a()) != null) {
                    a16.a();
                }
                MiniHomeConnectScene.this.k().j();
            }
        });
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void q() {
        super.q();
        k().d(MiniSDKConst.NOTIFY_EVENT_ONPAUSE, new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.xwconnect.MiniHomeConnectScene$onPause$1
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
                ZPlanFilamentSceneLifeCycleHandler zPlanFilamentSceneLifeCycleHandler;
                zPlanFilamentSceneLifeCycleHandler = MiniHomeConnectScene.this.lifeCycleHandler;
                if (zPlanFilamentSceneLifeCycleHandler != null) {
                    zPlanFilamentSceneLifeCycleHandler.f();
                }
            }
        });
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void r() {
        super.r();
        k().d("onResume", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.xwconnect.MiniHomeConnectScene$onResume$1
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
                ZPlanFilamentSceneLifeCycleHandler zPlanFilamentSceneLifeCycleHandler;
                zPlanFilamentSceneLifeCycleHandler = MiniHomeConnectScene.this.lifeCycleHandler;
                if (zPlanFilamentSceneLifeCycleHandler != null) {
                    zPlanFilamentSceneLifeCycleHandler.g();
                }
            }
        });
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void s(@NotNull SurfaceTexture surfaceTexture, int width, int height) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        super.s(surfaceTexture, width, height);
        c0(width, height, surfaceTexture);
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
        c0(width, height, surfaceTexture);
    }
}
