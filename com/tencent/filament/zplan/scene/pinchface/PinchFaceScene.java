package com.tencent.filament.zplan.scene.pinchface;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.app.scene.BaseSceneV2308;
import com.tencent.filament.zplan.engine.CppSceneEnum;
import com.tencent.filament.zplan.engine.ZPlanFilamentScene;
import com.tencent.filament.zplan.scene.pinchface.PinchFaceScene;
import com.tencent.filament.zplan.scene.xwconnect.MiniHomeConnectScene;
import com.tencent.filament.zplan.scene.xwconnect.handler.ZPlanFilamentSceneLifeCycleHandler;
import com.tencent.filament.zplan.scene.xwconnect.handler.ZPlanFilamentSceneTouchHandler;
import com.tencent.filament.zplan.scene.xwconnect.handler.ZPlanFilamentSceneVsyncHandler;
import com.tencent.filament.zplanservice.channel.MessageChannel;
import com.tencent.filament.zplanservice.channel.SceneEventConfig;
import com.tencent.filament.zplanservice.channel.f;
import com.tencent.filament.zplanservice.pbjava.EmptyMessageChannel$EmptyMessage;
import com.tencent.filament.zplanservice.pbjava.MessageChannelErrorCode$MessageResponse;
import com.tencent.filament.zplanservice.pbjava.PinchFaceEvent$EnginePinchFaceNotify;
import com.tencent.filament.zplanservice.pbjava.PinchFaceEvent$EnginePinchFaceRsp;
import com.tencent.filament.zplanservice.pbjava.PinchFaceEvent$EnginePinchFaceSaveRsp;
import com.tencent.filament.zplanservice.pbjava.PinchFaceEvent$NativePinchFaceHistoryReq;
import com.tencent.filament.zplanservice.pbjava.PinchFaceEvent$NativePinchFaceSaveReq;
import com.tencent.filament.zplanservice.pbjava.PinchFaceEvent$NativePinchFaceSelectGroupReq;
import com.tencent.filament.zplanservice.pbjava.PinchFaceEvent$NativePinchFaceSideReq;
import com.tencent.filament.zplanservice.pbjava.PinchFaceEvent$PinchFaceUiInfo;
import com.tencent.filament.zplanservice.pbjava.avatar_info.AvatarDressInfo$FaceInfo;
import com.tencent.filament.zplanservice.pbjava.sceneevent.SceneEventVsync$PauseVsync;
import com.tencent.filament.zplanservice.pbjava.sceneevent.SceneEventVsync$ResumeVsync;
import com.tencent.filament.zplanservice.pbjava.sceneevent.SceneEventVsync$StartVsync;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tk0.b;
import tk0.c;

@Metadata(d1 = {"\u0000\u00c0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n*\u0002MQ\u0018\u0000 \\2\u00020\u0001:\u0006]^_`\u000faB\u001f\u0012\b\u0010V\u001a\u0004\u0018\u00010U\u0012\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020X0W\u00a2\u0006\u0004\bZ\u0010[J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J \u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002JB\u0010\u001e\u001a\u00020\u000728\u0010\u001d\u001a4\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\u001b\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00070\u0016H\u0002J=\u0010&\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2#\u0010\u001d\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010$\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00070#H\u0002J5\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'2#\u0010\u001d\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010$\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00070#H\u0002J5\u0010+\u001a\u00020\u00072\u0006\u0010(\u001a\u00020*2#\u0010\u001d\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010$\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00070#H\u0002J5\u0010-\u001a\u00020\u00072\u0006\u0010(\u001a\u00020,2#\u0010\u001d\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010$\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00070#H\u0002R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010@R\u0016\u0010F\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER,\u0010L\u001a\u001a\u0012\u0004\u0012\u00020\u001f\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030I0H0G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010T\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010S\u00a8\u0006b"}, d2 = {"Lcom/tencent/filament/zplan/scene/pinchface/PinchFaceScene;", "Lcom/tencent/filament/zplan/app/scene/BaseSceneV2308;", "Landroid/graphics/SurfaceTexture;", "surfaceTexture", "", "width", "height", "", ReportConstant.COSTREPORT_PREFIX, "u", "surface", "t", "", "totalTime", "frameTime", "d", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "viewWidth", "viewHeight", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "Lcom/tencent/filament/zplanservice/pbjava/avatar_info/AvatarDressInfo$FaceInfo;", "faceInfo", "callback", ExifInterface.LATITUDE_SOUTH, "", AdMetricTag.EVENT_NAME, "", "reqData", "Lkotlin/Function1;", "Lcom/tencent/filament/zplanservice/pbjava/PinchFaceEvent$PinchFaceUiInfo;", "uiInfo", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/filament/zplanservice/pbjava/PinchFaceEvent$NativePinchFaceSideReq;", "req", "P", "Lcom/tencent/filament/zplanservice/pbjava/PinchFaceEvent$NativePinchFaceSelectGroupReq;", "T", "Lcom/tencent/filament/zplanservice/pbjava/PinchFaceEvent$NativePinchFaceHistoryReq;", "U", "Lcom/tencent/filament/zplan/engine/ZPlanFilamentScene;", "D", "Lcom/tencent/filament/zplan/engine/ZPlanFilamentScene;", "pinchFaceScene", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneVsyncHandler;", "E", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneVsyncHandler;", "vsyncHandler", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneLifeCycleHandler;", UserInfo.SEX_FEMALE, "Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneLifeCycleHandler;", "lifeCycleHandler", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneTouchHandler;", "G", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneTouchHandler;", "touchHandler", "Ljava/util/concurrent/atomic/AtomicBoolean;", "H", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasAttachedSurfaceTexture", "I", "hasSurface", "J", "Z", "isDestroy", "", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/pb/MessageMicro;", "K", "Ljava/util/Map;", "handlerEventMap", "com/tencent/filament/zplan/scene/pinchface/PinchFaceScene$f", "L", "Lcom/tencent/filament/zplan/scene/pinchface/PinchFaceScene$f;", "sceneHandler", "com/tencent/filament/zplan/scene/pinchface/PinchFaceScene$nativeAppDispatchAction$1", "M", "Lcom/tencent/filament/zplan/scene/pinchface/PinchFaceScene$nativeAppDispatchAction$1;", "nativeAppDispatchAction", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/app/impl/FilamentNativeAppV2305;", "app", "<init>", "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/ref/WeakReference;)V", "N", "Companion", "a", "b", "c", "e", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class PinchFaceScene extends BaseSceneV2308 {

    /* renamed from: D, reason: from kotlin metadata */
    private ZPlanFilamentScene pinchFaceScene;

    /* renamed from: E, reason: from kotlin metadata */
    private ZPlanFilamentSceneVsyncHandler vsyncHandler;

    /* renamed from: F, reason: from kotlin metadata */
    private ZPlanFilamentSceneLifeCycleHandler lifeCycleHandler;

    /* renamed from: G, reason: from kotlin metadata */
    private ZPlanFilamentSceneTouchHandler touchHandler;

    /* renamed from: H, reason: from kotlin metadata */
    private AtomicBoolean hasAttachedSurfaceTexture;

    /* renamed from: I, reason: from kotlin metadata */
    private AtomicBoolean hasSurface;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isDestroy;

    /* renamed from: K, reason: from kotlin metadata */
    private final Map<String, Class<? extends MessageMicro<?>>> handlerEventMap;

    /* renamed from: L, reason: from kotlin metadata */
    private final f sceneHandler;

    /* renamed from: M, reason: from kotlin metadata */
    private final PinchFaceScene$nativeAppDispatchAction$1 nativeAppDispatchAction;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/filament/zplan/scene/pinchface/PinchFaceScene$a;", "Ltk0/b;", "Lcom/tencent/filament/zplanservice/pbjava/PinchFaceEvent$PinchFaceUiInfo;", "a", "Lcom/tencent/filament/zplanservice/pbjava/PinchFaceEvent$PinchFaceUiInfo;", "()Lcom/tencent/filament/zplanservice/pbjava/PinchFaceEvent$PinchFaceUiInfo;", "uiInfo", "<init>", "(Lcom/tencent/filament/zplanservice/pbjava/PinchFaceEvent$PinchFaceUiInfo;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class a implements tk0.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final PinchFaceEvent$PinchFaceUiInfo uiInfo;

        public a(@Nullable PinchFaceEvent$PinchFaceUiInfo pinchFaceEvent$PinchFaceUiInfo) {
            this.uiInfo = pinchFaceEvent$PinchFaceUiInfo;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final PinchFaceEvent$PinchFaceUiInfo getUiInfo() {
            return this.uiInfo;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B4\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012#\u0010\u0012\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\n\u00a2\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR4\u0010\u0012\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\n8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0003\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/filament/zplan/scene/pinchface/PinchFaceScene$b;", "Ltk0/b;", "Lcom/tencent/filament/zplanservice/pbjava/PinchFaceEvent$NativePinchFaceSideReq;", "a", "Lcom/tencent/filament/zplanservice/pbjava/PinchFaceEvent$NativePinchFaceSideReq;", "b", "()Lcom/tencent/filament/zplanservice/pbjava/PinchFaceEvent$NativePinchFaceSideReq;", "setReq", "(Lcom/tencent/filament/zplanservice/pbjava/PinchFaceEvent$NativePinchFaceSideReq;)V", "req", "Lkotlin/Function1;", "Lcom/tencent/filament/zplanservice/pbjava/PinchFaceEvent$PinchFaceUiInfo;", "Lkotlin/ParameterName;", "name", "uiInfo", "", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "callback", "<init>", "(Lcom/tencent/filament/zplanservice/pbjava/PinchFaceEvent$NativePinchFaceSideReq;Lkotlin/jvm/functions/Function1;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class b implements tk0.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private PinchFaceEvent$NativePinchFaceSideReq req;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<PinchFaceEvent$PinchFaceUiInfo, Unit> callback;

        /* JADX WARN: Multi-variable type inference failed */
        public b(@NotNull PinchFaceEvent$NativePinchFaceSideReq req, @NotNull Function1<? super PinchFaceEvent$PinchFaceUiInfo, Unit> callback) {
            Intrinsics.checkNotNullParameter(req, "req");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.req = req;
            this.callback = callback;
        }

        @NotNull
        public final Function1<PinchFaceEvent$PinchFaceUiInfo, Unit> a() {
            return this.callback;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final PinchFaceEvent$NativePinchFaceSideReq getReq() {
            return this.req;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001BA\u00128\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fRI\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/filament/zplan/scene/pinchface/PinchFaceScene$c;", "Ltk0/b;", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "Lcom/tencent/filament/zplanservice/pbjava/avatar_info/AvatarDressInfo$FaceInfo;", "faceInfo", "", "a", "Lkotlin/jvm/functions/Function2;", "()Lkotlin/jvm/functions/Function2;", "callback", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class c implements tk0.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function2<Boolean, AvatarDressInfo$FaceInfo, Unit> callback;

        /* JADX WARN: Multi-variable type inference failed */
        public c(@NotNull Function2<? super Boolean, ? super AvatarDressInfo$FaceInfo, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.callback = callback;
        }

        @NotNull
        public final Function2<Boolean, AvatarDressInfo$FaceInfo, Unit> a() {
            return this.callback;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B4\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012#\u0010\u0012\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\n\u00a2\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR4\u0010\u0012\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\n8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0003\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/filament/zplan/scene/pinchface/PinchFaceScene$d;", "Ltk0/b;", "Lcom/tencent/filament/zplanservice/pbjava/PinchFaceEvent$NativePinchFaceSelectGroupReq;", "a", "Lcom/tencent/filament/zplanservice/pbjava/PinchFaceEvent$NativePinchFaceSelectGroupReq;", "b", "()Lcom/tencent/filament/zplanservice/pbjava/PinchFaceEvent$NativePinchFaceSelectGroupReq;", "setReq", "(Lcom/tencent/filament/zplanservice/pbjava/PinchFaceEvent$NativePinchFaceSelectGroupReq;)V", "req", "Lkotlin/Function1;", "Lcom/tencent/filament/zplanservice/pbjava/PinchFaceEvent$PinchFaceUiInfo;", "Lkotlin/ParameterName;", "name", "uiInfo", "", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "callback", "<init>", "(Lcom/tencent/filament/zplanservice/pbjava/PinchFaceEvent$NativePinchFaceSelectGroupReq;Lkotlin/jvm/functions/Function1;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class d implements tk0.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private PinchFaceEvent$NativePinchFaceSelectGroupReq req;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<PinchFaceEvent$PinchFaceUiInfo, Unit> callback;

        /* JADX WARN: Multi-variable type inference failed */
        public d(@NotNull PinchFaceEvent$NativePinchFaceSelectGroupReq req, @NotNull Function1<? super PinchFaceEvent$PinchFaceUiInfo, Unit> callback) {
            Intrinsics.checkNotNullParameter(req, "req");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.req = req;
            this.callback = callback;
        }

        @NotNull
        public final Function1<PinchFaceEvent$PinchFaceUiInfo, Unit> a() {
            return this.callback;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final PinchFaceEvent$NativePinchFaceSelectGroupReq getReq() {
            return this.req;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B4\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012#\u0010\u0012\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\n\u00a2\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR4\u0010\u0012\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\n8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0003\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/filament/zplan/scene/pinchface/PinchFaceScene$e;", "Ltk0/b;", "Lcom/tencent/filament/zplanservice/pbjava/PinchFaceEvent$NativePinchFaceHistoryReq;", "a", "Lcom/tencent/filament/zplanservice/pbjava/PinchFaceEvent$NativePinchFaceHistoryReq;", "b", "()Lcom/tencent/filament/zplanservice/pbjava/PinchFaceEvent$NativePinchFaceHistoryReq;", "setReq", "(Lcom/tencent/filament/zplanservice/pbjava/PinchFaceEvent$NativePinchFaceHistoryReq;)V", "req", "Lkotlin/Function1;", "Lcom/tencent/filament/zplanservice/pbjava/PinchFaceEvent$PinchFaceUiInfo;", "Lkotlin/ParameterName;", "name", "uiInfo", "", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "callback", "<init>", "(Lcom/tencent/filament/zplanservice/pbjava/PinchFaceEvent$NativePinchFaceHistoryReq;Lkotlin/jvm/functions/Function1;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class e implements tk0.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private PinchFaceEvent$NativePinchFaceHistoryReq req;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<PinchFaceEvent$PinchFaceUiInfo, Unit> callback;

        /* JADX WARN: Multi-variable type inference failed */
        public e(@NotNull PinchFaceEvent$NativePinchFaceHistoryReq req, @NotNull Function1<? super PinchFaceEvent$PinchFaceUiInfo, Unit> callback) {
            Intrinsics.checkNotNullParameter(req, "req");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.req = req;
            this.callback = callback;
        }

        @NotNull
        public final Function1<PinchFaceEvent$PinchFaceUiInfo, Unit> a() {
            return this.callback;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final PinchFaceEvent$NativePinchFaceHistoryReq getReq() {
            return this.req;
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002O\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0001j\u0002`\u000bJ%\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00022\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\t\u001a\u00020\bH\u0096\u0002\u00a8\u0006\r"}, d2 = {"com/tencent/filament/zplan/scene/pinchface/PinchFaceScene$f", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", AdMetricTag.EVENT_NAME, "Lcom/tencent/mobileqq/pb/MessageMicro;", "pbField", "Lcom/tencent/filament/zplanservice/channel/a;", "callbackN2C", "", "Lcom/tencent/filament/zplanservice/channel/SceneHandler;", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class f implements Function3<String, MessageMicro<?>, com.tencent.filament.zplanservice.channel.a, Unit> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ WeakReference f105981e;

        f(WeakReference weakReference) {
            this.f105981e = weakReference;
        }

        public void a(@NotNull String eventName, @NotNull MessageMicro<?> pbField, @NotNull com.tencent.filament.zplanservice.channel.a callbackN2C) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(pbField, "pbField");
            Intrinsics.checkNotNullParameter(callbackN2C, "callbackN2C");
            if (Intrinsics.areEqual(eventName, MiniHomeConnectScene.Companion.C2NEventName.START_VSYNC.getValue())) {
                ZPlanFilamentSceneVsyncHandler zPlanFilamentSceneVsyncHandler = PinchFaceScene.this.vsyncHandler;
                if (zPlanFilamentSceneVsyncHandler != null) {
                    zPlanFilamentSceneVsyncHandler.c(pbField);
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(eventName, MiniHomeConnectScene.Companion.C2NEventName.PAUSE_VSYNC.getValue())) {
                ZPlanFilamentSceneVsyncHandler zPlanFilamentSceneVsyncHandler2 = PinchFaceScene.this.vsyncHandler;
                if (zPlanFilamentSceneVsyncHandler2 != null) {
                    zPlanFilamentSceneVsyncHandler2.a();
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(eventName, MiniHomeConnectScene.Companion.C2NEventName.RESUME_VSYNC.getValue())) {
                ZPlanFilamentSceneVsyncHandler zPlanFilamentSceneVsyncHandler3 = PinchFaceScene.this.vsyncHandler;
                if (zPlanFilamentSceneVsyncHandler3 != null) {
                    zPlanFilamentSceneVsyncHandler3.b();
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(eventName, Companion.C2NEventName.UIInfo.getValue())) {
                PinchFaceEvent$EnginePinchFaceNotify pinchFaceEvent$EnginePinchFaceNotify = (PinchFaceEvent$EnginePinchFaceNotify) pbField;
                FilamentNativeAppV2305 filamentNativeAppV2305 = (FilamentNativeAppV2305) this.f105981e.get();
                if (filamentNativeAppV2305 != null) {
                    filamentNativeAppV2305.dispatchEvent(new a(pinchFaceEvent$EnginePinchFaceNotify.ui_info));
                }
                com.tencent.filament.zplanservice.channel.handler.a.e(callbackN2C, new MessageMicro<EmptyMessageChannel$EmptyMessage>() { // from class: com.tencent.filament.zplanservice.pbjava.EmptyMessageChannel$EmptyMessage
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"placeholder"}, new Object[]{0}, EmptyMessageChannel$EmptyMessage.class);
                    public final PBInt32Field placeholder = PBField.initInt32(0);
                });
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(String str, MessageMicro<?> messageMicro, com.tencent.filament.zplanservice.channel.a aVar) {
            a(str, messageMicro, aVar);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r4v7, types: [com.tencent.filament.zplan.scene.pinchface.PinchFaceScene$nativeAppDispatchAction$1] */
    public PinchFaceScene(@Nullable com.tencent.zplan.zplantracing.c cVar, @NotNull final WeakReference<FilamentNativeAppV2305> app) {
        super(cVar, app);
        Map<String, Class<? extends MessageMicro<?>>> mutableMapOf;
        Intrinsics.checkNotNullParameter(app, "app");
        this.hasAttachedSurfaceTexture = new AtomicBoolean(false);
        this.hasSurface = new AtomicBoolean(false);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(MiniHomeConnectScene.Companion.C2NEventName.START_VSYNC.getValue(), SceneEventVsync$StartVsync.class), TuplesKt.to(MiniHomeConnectScene.Companion.C2NEventName.PAUSE_VSYNC.getValue(), SceneEventVsync$PauseVsync.class), TuplesKt.to(MiniHomeConnectScene.Companion.C2NEventName.RESUME_VSYNC.getValue(), SceneEventVsync$ResumeVsync.class), TuplesKt.to(Companion.C2NEventName.UIInfo.getValue(), PinchFaceEvent$EnginePinchFaceNotify.class));
        this.handlerEventMap = mutableMapOf;
        this.sceneHandler = new f(app);
        this.nativeAppDispatchAction = new tk0.a() { // from class: com.tencent.filament.zplan.scene.pinchface.PinchFaceScene$nativeAppDispatchAction$1
            @Override // tk0.a
            public void call(@NotNull b event) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (event instanceof PinchFaceScene.c) {
                    PinchFaceScene.this.S(((PinchFaceScene.c) event).a());
                    return;
                }
                if (event instanceof PinchFaceScene.b) {
                    PinchFaceScene.b bVar = (PinchFaceScene.b) event;
                    PinchFaceScene.this.P(bVar.getReq(), bVar.a());
                } else if (event instanceof PinchFaceScene.d) {
                    PinchFaceScene.d dVar = (PinchFaceScene.d) event;
                    PinchFaceScene.this.T(dVar.getReq(), dVar.a());
                } else if (event instanceof PinchFaceScene.e) {
                    PinchFaceScene.e eVar = (PinchFaceScene.e) event;
                    PinchFaceScene.this.U(eVar.getReq(), eVar.a());
                }
            }
        };
        k().d("PinchFaceSceneInit", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.pinchface.PinchFaceScene.1

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/filament/zplan/scene/pinchface/PinchFaceScene$1$a", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/ZPlanFilamentSceneVsyncHandler$b;", "", "fps", "", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
            /* renamed from: com.tencent.filament.zplan.scene.pinchface.PinchFaceScene$1$a */
            /* loaded from: classes6.dex */
            public static final class a implements ZPlanFilamentSceneVsyncHandler.b {
                a() {
                }

                @Override // com.tencent.filament.zplan.scene.xwconnect.handler.ZPlanFilamentSceneVsyncHandler.b
                public void a(float fps) {
                    PinchFaceScene.this.x(fps);
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
                FilamentNativeAppV2305 filamentNativeAppV2305 = (FilamentNativeAppV2305) app.get();
                if (filamentNativeAppV2305 != null) {
                    filamentNativeAppV2305.register(tk0.c.f436439a.a(Reflection.getOrCreateKotlinClass(c.class)), PinchFaceScene.this.nativeAppDispatchAction);
                }
                FilamentNativeAppV2305 filamentNativeAppV23052 = (FilamentNativeAppV2305) app.get();
                if (filamentNativeAppV23052 != null) {
                    filamentNativeAppV23052.register(tk0.c.f436439a.a(Reflection.getOrCreateKotlinClass(b.class)), PinchFaceScene.this.nativeAppDispatchAction);
                }
                FilamentNativeAppV2305 filamentNativeAppV23053 = (FilamentNativeAppV2305) app.get();
                if (filamentNativeAppV23053 != null) {
                    filamentNativeAppV23053.register(tk0.c.f436439a.a(Reflection.getOrCreateKotlinClass(d.class)), PinchFaceScene.this.nativeAppDispatchAction);
                }
                FilamentNativeAppV2305 filamentNativeAppV23054 = (FilamentNativeAppV2305) app.get();
                if (filamentNativeAppV23054 != null) {
                    filamentNativeAppV23054.register(tk0.c.f436439a.a(Reflection.getOrCreateKotlinClass(e.class)), PinchFaceScene.this.nativeAppDispatchAction);
                }
                PinchFaceScene pinchFaceScene = PinchFaceScene.this;
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                pinchFaceScene.pinchFaceScene = new ZPlanFilamentScene(currentThread.getId(), CppSceneEnum.ZPlanPinchFaceScene);
                PinchFaceScene pinchFaceScene2 = PinchFaceScene.this;
                ZPlanFilamentScene zPlanFilamentScene = PinchFaceScene.this.pinchFaceScene;
                Intrinsics.checkNotNull(zPlanFilamentScene);
                pinchFaceScene2.vsyncHandler = new ZPlanFilamentSceneVsyncHandler(zPlanFilamentScene.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.SCENE_ID java.lang.String());
                ZPlanFilamentSceneVsyncHandler zPlanFilamentSceneVsyncHandler = PinchFaceScene.this.vsyncHandler;
                Intrinsics.checkNotNull(zPlanFilamentSceneVsyncHandler);
                zPlanFilamentSceneVsyncHandler.d(new a());
                ZPlanFilamentSceneVsyncHandler zPlanFilamentSceneVsyncHandler2 = PinchFaceScene.this.vsyncHandler;
                if (zPlanFilamentSceneVsyncHandler2 != null) {
                    zPlanFilamentSceneVsyncHandler2.onCreate();
                }
                PinchFaceScene pinchFaceScene3 = PinchFaceScene.this;
                WeakReference weakReference = app;
                ZPlanFilamentScene zPlanFilamentScene2 = PinchFaceScene.this.pinchFaceScene;
                Intrinsics.checkNotNull(zPlanFilamentScene2);
                pinchFaceScene3.lifeCycleHandler = new ZPlanFilamentSceneLifeCycleHandler(weakReference, zPlanFilamentScene2.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.SCENE_ID java.lang.String());
                ZPlanFilamentSceneLifeCycleHandler zPlanFilamentSceneLifeCycleHandler = PinchFaceScene.this.lifeCycleHandler;
                if (zPlanFilamentSceneLifeCycleHandler != null) {
                    zPlanFilamentSceneLifeCycleHandler.onCreate();
                }
                PinchFaceScene pinchFaceScene4 = PinchFaceScene.this;
                WeakReference weakReference2 = app;
                ZPlanFilamentScene zPlanFilamentScene3 = PinchFaceScene.this.pinchFaceScene;
                Intrinsics.checkNotNull(zPlanFilamentScene3);
                pinchFaceScene4.touchHandler = new ZPlanFilamentSceneTouchHandler(weakReference2, zPlanFilamentScene3.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.SCENE_ID java.lang.String());
                ZPlanFilamentSceneTouchHandler zPlanFilamentSceneTouchHandler = PinchFaceScene.this.touchHandler;
                if (zPlanFilamentSceneTouchHandler != null) {
                    zPlanFilamentSceneTouchHandler.onCreate();
                }
                com.tencent.filament.zplanservice.channel.f fVar = com.tencent.filament.zplanservice.channel.f.f106360b;
                ZPlanFilamentScene zPlanFilamentScene4 = PinchFaceScene.this.pinchFaceScene;
                Intrinsics.checkNotNull(zPlanFilamentScene4);
                fVar.c(zPlanFilamentScene4.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.SCENE_ID java.lang.String(), new SceneEventConfig(PinchFaceScene.this.sceneHandler, PinchFaceScene.this.handlerEventMap));
                ZPlanFilamentScene zPlanFilamentScene5 = PinchFaceScene.this.pinchFaceScene;
                if (zPlanFilamentScene5 != null) {
                    zPlanFilamentScene5.e();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(PinchFaceEvent$NativePinchFaceSideReq req, Function1<? super PinchFaceEvent$PinchFaceUiInfo, Unit> callback) {
        ZPlanFilamentScene zPlanFilamentScene = this.pinchFaceScene;
        if (zPlanFilamentScene != null) {
            req.scene_address.set(zPlanFilamentScene.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.SCENE_ID java.lang.String());
            byte[] byteArray = req.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
            R("PinchFace.PinchFaceSide", byteArray, callback);
            return;
        }
        FLog.INSTANCE.e("BaseSceneV2308", "sceneId is null");
        callback.invoke(null);
    }

    private final void Q(final int viewWidth, final int viewHeight, final SurfaceTexture surfaceTexture) {
        if (this.isDestroy) {
            return;
        }
        k().d("attach", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.pinchface.PinchFaceScene$attach$1
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
                AtomicBoolean atomicBoolean2;
                ZPlanFilamentScene zPlanFilamentScene;
                atomicBoolean = PinchFaceScene.this.hasAttachedSurfaceTexture;
                if (atomicBoolean.compareAndSet(false, true) && (zPlanFilamentScene = PinchFaceScene.this.pinchFaceScene) != null) {
                    zPlanFilamentScene.b(viewWidth, viewHeight, new Surface(surfaceTexture), surfaceTexture, true);
                }
                atomicBoolean2 = PinchFaceScene.this.hasSurface;
                atomicBoolean2.set(true);
            }
        });
    }

    private final void R(String eventName, byte[] reqData, final Function1<? super PinchFaceEvent$PinchFaceUiInfo, Unit> callback) {
        MessageChannel.INSTANCE.callN2C(eventName, reqData, new Function1<MessageChannelErrorCode$MessageResponse, Unit>() { // from class: com.tencent.filament.zplan.scene.pinchface.PinchFaceScene$pinchFaceRspCallN2C$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MessageChannelErrorCode$MessageResponse messageChannelErrorCode$MessageResponse) {
                invoke2(messageChannelErrorCode$MessageResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable MessageChannelErrorCode$MessageResponse messageChannelErrorCode$MessageResponse) {
                PBBytesField pBBytesField;
                ByteStringMicro byteStringMicro;
                byte[] byteArray;
                if (messageChannelErrorCode$MessageResponse != null && (pBBytesField = messageChannelErrorCode$MessageResponse.data) != null && (byteStringMicro = pBBytesField.get()) != null && (byteArray = byteStringMicro.toByteArray()) != null) {
                    PinchFaceEvent$EnginePinchFaceRsp mergeFrom = new PinchFaceEvent$EnginePinchFaceRsp().mergeFrom(byteArray);
                    if (mergeFrom.get().do_op_result.get() != 0) {
                        FLog.INSTANCE.e("BaseSceneV2308", "pinchFaceRspCallN2C rsp failed");
                        callback.invoke(null);
                        return;
                    } else {
                        callback.invoke(mergeFrom.get().ui_info);
                        return;
                    }
                }
                FLog.INSTANCE.e("BaseSceneV2308", "pinchFaceRspCallN2C rsp is null");
                callback.invoke(null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S(final Function2<? super Boolean, ? super AvatarDressInfo$FaceInfo, Unit> callback) {
        ZPlanFilamentScene zPlanFilamentScene = this.pinchFaceScene;
        if (zPlanFilamentScene != null) {
            long j3 = zPlanFilamentScene.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.SCENE_ID java.lang.String();
            PinchFaceEvent$NativePinchFaceSaveReq pinchFaceEvent$NativePinchFaceSaveReq = new PinchFaceEvent$NativePinchFaceSaveReq();
            pinchFaceEvent$NativePinchFaceSaveReq.scene_address.set(j3);
            MessageChannel.INSTANCE.callN2C("PinchFace.PinchFaceSave", pinchFaceEvent$NativePinchFaceSaveReq.toByteArray(), new Function1<MessageChannelErrorCode$MessageResponse, Unit>() { // from class: com.tencent.filament.zplan.scene.pinchface.PinchFaceScene$save$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MessageChannelErrorCode$MessageResponse messageChannelErrorCode$MessageResponse) {
                    invoke2(messageChannelErrorCode$MessageResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable MessageChannelErrorCode$MessageResponse messageChannelErrorCode$MessageResponse) {
                    PBBytesField pBBytesField;
                    ByteStringMicro byteStringMicro;
                    byte[] byteArray;
                    if (messageChannelErrorCode$MessageResponse != null && (pBBytesField = messageChannelErrorCode$MessageResponse.data) != null && (byteStringMicro = pBBytesField.get()) != null && (byteArray = byteStringMicro.toByteArray()) != null) {
                        PinchFaceEvent$EnginePinchFaceSaveRsp mergeFrom = new PinchFaceEvent$EnginePinchFaceSaveRsp().mergeFrom(byteArray);
                        FLog.INSTANCE.w("BaseSceneV2308", "PinchFaceSave is Success: " + mergeFrom.save_success);
                        callback.invoke(Boolean.valueOf(mergeFrom.save_success.get()), mergeFrom.save_face_info.get());
                        return;
                    }
                    FLog.INSTANCE.e("BaseSceneV2308", "PinchFaceSave rsp is null");
                    callback.invoke(Boolean.FALSE, null);
                }
            });
            return;
        }
        FLog.INSTANCE.e("BaseSceneV2308", "sceneId is null");
        callback.invoke(Boolean.FALSE, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(PinchFaceEvent$NativePinchFaceSelectGroupReq req, Function1<? super PinchFaceEvent$PinchFaceUiInfo, Unit> callback) {
        ZPlanFilamentScene zPlanFilamentScene = this.pinchFaceScene;
        if (zPlanFilamentScene != null) {
            req.scene_address.set(zPlanFilamentScene.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.SCENE_ID java.lang.String());
            byte[] byteArray = req.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
            R("PinchFace.SelectGroup", byteArray, callback);
            return;
        }
        FLog.INSTANCE.e("BaseSceneV2308", "sceneId is null");
        callback.invoke(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(PinchFaceEvent$NativePinchFaceHistoryReq req, Function1<? super PinchFaceEvent$PinchFaceUiInfo, Unit> callback) {
        ZPlanFilamentScene zPlanFilamentScene = this.pinchFaceScene;
        if (zPlanFilamentScene != null) {
            req.scene_address.set(zPlanFilamentScene.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.SCENE_ID java.lang.String());
            byte[] byteArray = req.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
            R("PinchFace.UndoOrRedo", byteArray, callback);
            return;
        }
        FLog.INSTANCE.e("BaseSceneV2308", "sceneId is null");
        callback.invoke(null);
    }

    @Override // com.tencent.filament.zplan.util.vsync.b
    public void d(long totalTime, long frameTime) {
        if (!this.hasSurface.get()) {
            return;
        }
        k().e(new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.pinchface.PinchFaceScene$onVSync$1
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
                ZPlanFilamentSceneVsyncHandler zPlanFilamentSceneVsyncHandler = PinchFaceScene.this.vsyncHandler;
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
        k().d(MosaicConstants$JsFunction.FUNC_ON_DESTROY, new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.pinchface.PinchFaceScene$onDestroy$1
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
                FilamentNativeAppV2305 filamentNativeAppV2305 = PinchFaceScene.this.j().get();
                if (filamentNativeAppV2305 != null) {
                    filamentNativeAppV2305.unregister(c.f436439a.a(Reflection.getOrCreateKotlinClass(PinchFaceScene.c.class)), PinchFaceScene.this.nativeAppDispatchAction);
                }
                FilamentNativeAppV2305 filamentNativeAppV23052 = PinchFaceScene.this.j().get();
                if (filamentNativeAppV23052 != null) {
                    filamentNativeAppV23052.unregister(c.f436439a.a(Reflection.getOrCreateKotlinClass(PinchFaceScene.b.class)), PinchFaceScene.this.nativeAppDispatchAction);
                }
                FilamentNativeAppV2305 filamentNativeAppV23053 = PinchFaceScene.this.j().get();
                if (filamentNativeAppV23053 != null) {
                    filamentNativeAppV23053.unregister(c.f436439a.a(Reflection.getOrCreateKotlinClass(PinchFaceScene.d.class)), PinchFaceScene.this.nativeAppDispatchAction);
                }
                FilamentNativeAppV2305 filamentNativeAppV23054 = PinchFaceScene.this.j().get();
                if (filamentNativeAppV23054 != null) {
                    filamentNativeAppV23054.unregister(c.f436439a.a(Reflection.getOrCreateKotlinClass(PinchFaceScene.e.class)), PinchFaceScene.this.nativeAppDispatchAction);
                }
                ZPlanFilamentSceneVsyncHandler zPlanFilamentSceneVsyncHandler = PinchFaceScene.this.vsyncHandler;
                if (zPlanFilamentSceneVsyncHandler != null) {
                    zPlanFilamentSceneVsyncHandler.onDestroy();
                }
                ZPlanFilamentSceneLifeCycleHandler zPlanFilamentSceneLifeCycleHandler = PinchFaceScene.this.lifeCycleHandler;
                if (zPlanFilamentSceneLifeCycleHandler != null) {
                    zPlanFilamentSceneLifeCycleHandler.onDestroy();
                }
                ZPlanFilamentSceneTouchHandler zPlanFilamentSceneTouchHandler = PinchFaceScene.this.touchHandler;
                if (zPlanFilamentSceneTouchHandler != null) {
                    zPlanFilamentSceneTouchHandler.onDestroy();
                }
                ZPlanFilamentScene zPlanFilamentScene = PinchFaceScene.this.pinchFaceScene;
                if (zPlanFilamentScene != null) {
                    f.f106360b.d(zPlanFilamentScene.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.SCENE_ID java.lang.String());
                }
                ZPlanFilamentScene zPlanFilamentScene2 = PinchFaceScene.this.pinchFaceScene;
                if (zPlanFilamentScene2 != null) {
                    zPlanFilamentScene2.c();
                }
                PinchFaceScene.this.pinchFaceScene = null;
                PinchFaceScene.this.k().i();
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
        Q(width, height, surfaceTexture);
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
        Q(width, height, surfaceTexture);
    }
}
