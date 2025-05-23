package com.tencent.filament.zplan.scene.square;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.app.impl.FilamentThreadHandler;
import com.tencent.filament.zplan.app.scene.BaseSceneV2305;
import com.tencent.filament.zplan.avatar.exception.BlackListResourceException;
import com.tencent.filament.zplan.avatar.exception.FetchFileException;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplan.engine.FilamentViewerV2305;
import com.tencent.filament.zplan.engine.RenderCallback;
import com.tencent.filament.zplan.scene.square.SquareMapEvent;
import com.tencent.filament.zplan.view.event.TouchEvent;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u0082\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001AB!\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020~0}\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\u001a\u0010\u0016\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u001fH\u0002J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020!H\u0002J\u0010\u0010$\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020#H\u0002J\u0010\u0010&\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020%H\u0002J\u0010\u0010(\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020'H\u0002J\u0010\u0010+\u001a\u00020\t2\u0006\u0010*\u001a\u00020)H\u0002J\u0016\u0010.\u001a\u0004\u0018\u00010\u00072\n\u0010-\u001a\u00060\u0005j\u0002`,H\u0002J\b\u0010/\u001a\u00020\tH\u0002J\b\u00100\u001a\u00020\tH\u0002J\b\u00101\u001a\u00020\tH\u0002J\b\u00102\u001a\u00020\u0005H\u0016J\u001c\u00106\u001a\u00020\t2\n\u00104\u001a\u00060\u0005j\u0002`32\u0006\u00105\u001a\u00020\u0005H\u0016J$\u00109\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u00107\u001a\u00020\u00072\b\u00108\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010=\u001a\u00020\t2\u0006\u0010;\u001a\u00020:2\b\u0010<\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010?\u001a\u00020>H\u0016J\n\u0010A\u001a\u0004\u0018\u00010@H\u0016J\b\u0010B\u001a\u00020\u0002H\u0016J\b\u0010D\u001a\u00020CH\u0016J\u0010\u0010G\u001a\u00020\t2\u0006\u0010F\u001a\u00020EH\u0016J\n\u0010I\u001a\u0004\u0018\u00010HH\u0016R\u0014\u0010L\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010U\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010NR\u0016\u0010X\u001a\u00020V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010\u0013R\u001c\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00050Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010^\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010TR\u001c\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00050Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010[R\u0014\u0010b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010TR\u001a\u0010d\u001a\u00060\u0005j\u0002`38\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010TR\u0014\u0010f\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\be\u0010RR \u0010k\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020h0g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0014\u0010o\u001a\u00020l8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010r\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u001a\u0010x\u001a\u00020s8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bt\u0010u\u001a\u0004\bv\u0010wR\u0014\u0010|\u001a\u00020y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bz\u0010{\u00a8\u0006\u0083\u0001"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/SquareMapScene;", "Lcom/tencent/filament/zplan/app/scene/BaseSceneV2305;", "Lkotlinx/coroutines/CoroutineScope;", "Lsk0/b;", "Lcom/tencent/filament/zplan/scene/square/e;", "", "b0", "", "currentFrameTag", "", "q0", "currentFrameId", "r0", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "Lcom/tencent/filament/zplan/scene/square/Size;", "mapSize", "viewportSize", "Lkotlinx/coroutines/Deferred;", "Z", "Lcom/tencent/filament/zplan/scene/square/AddObjectEvent;", "evt", "c0", "Lcom/tencent/filament/zplan/scene/square/RemoveObjectEvent;", "n0", "Lcom/tencent/filament/zplan/scene/square/ObjectPlayEvent;", "g0", "Lcom/tencent/filament/zplan/scene/square/ObjectStopEvent;", "i0", "Lcom/tencent/filament/zplan/scene/square/ObjectResetEvent;", "h0", "Lcom/tencent/filament/zplan/scene/square/ObjectUpdateResourceEvent;", "k0", "Lcom/tencent/filament/zplan/scene/square/ObjectUpdateVisibleEvent;", "l0", "Lcom/tencent/filament/zplan/scene/square/ObjectMoveToEvent;", "f0", "Lcom/tencent/filament/zplan/scene/square/ObjectInteractionEvent;", "e0", "Lcom/tencent/filament/zplan/scene/square/MoveViewportEvent;", "d0", "Lcom/tencent/filament/zplan/view/event/TouchEvent;", "touchEvent", "j0", "Lcom/tencent/filament/zplan/engine/RenderObjectId;", "renderObjectId", "a0", "o0", "p0", "m0", "g", "Lcom/tencent/filament/zplan/scene/square/EngineTime;", "totalTime", "frameTime", "d", "type", "data", "handleEvent", "", "errorCode", "errorMessage", "o", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "a", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2305;", "b", "getCoroutineScope", "Lcom/tencent/filament/zplan/app/impl/FilamentThreadHandler;", "c", "Lcom/tencent/filament/zplan/scene/square/SquareMapEvent;", "event", "e", "Lcom/tencent/filament/zplan/scene/square/n;", "f", "G", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "H", "Ljava/lang/String;", "indirectLightPath", "Ljava/util/concurrent/atomic/AtomicBoolean;", "I", "Ljava/util/concurrent/atomic/AtomicBoolean;", "booted", "J", "recoverFilamentFrameTag", "", "K", "pauseFilament", "", "L", "Ljava/util/Set;", "syncFrames", "M", "frameIdGenerator", "N", "waitCallbackFrameIds", "P", WadlProxyConsts.CREATE_TIME, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "curAnimTime", BdhLogUtil.LogTag.Tag_Req, "isFirstRendered", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/filament/zplan/scene/square/d;", ExifInterface.LATITUDE_SOUTH, "Ljava/util/concurrent/ConcurrentHashMap;", "mapObjects", "Lcom/tencent/filament/zplan/scene/square/SquareMapViewport;", "T", "Lcom/tencent/filament/zplan/scene/square/SquareMapViewport;", "viewport", "U", "Lcom/tencent/filament/zplan/scene/square/n;", "squareMapSceneHelper", "Lkotlin/coroutines/CoroutineContext;", "V", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lcom/tencent/filament/zplan/scene/square/SquareRenderStatistics;", "W", "Lcom/tencent/filament/zplan/scene/square/SquareRenderStatistics;", "statistics", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/app/impl/FilamentNativeAppV2305;", "app", "<init>", "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/ref/WeakReference;)V", "Y", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class SquareMapScene extends BaseSceneV2305 implements CoroutineScope, sk0.b, e {
    private static List<String> X;

    /* renamed from: G, reason: from kotlin metadata */
    private final FilamentUrlTemplate urlTemplate;

    /* renamed from: H, reason: from kotlin metadata */
    private String indirectLightPath;

    /* renamed from: I, reason: from kotlin metadata */
    private final AtomicBoolean booted;

    /* renamed from: J, reason: from kotlin metadata */
    private String recoverFilamentFrameTag;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean pauseFilament;

    /* renamed from: L, reason: from kotlin metadata */
    private Set<Long> syncFrames;

    /* renamed from: M, reason: from kotlin metadata */
    private long frameIdGenerator;

    /* renamed from: N, reason: from kotlin metadata */
    private Set<Long> waitCallbackFrameIds;

    /* renamed from: P, reason: from kotlin metadata */
    private final long createTime;

    /* renamed from: Q, reason: from kotlin metadata */
    private long curAnimTime;

    /* renamed from: R, reason: from kotlin metadata */
    private final AtomicBoolean isFirstRendered;

    /* renamed from: S, reason: from kotlin metadata */
    private final ConcurrentHashMap<String, d> mapObjects;

    /* renamed from: T, reason: from kotlin metadata */
    private final SquareMapViewport viewport;

    /* renamed from: U, reason: from kotlin metadata */
    private n squareMapSceneHelper;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final CoroutineContext coroutineContext;

    /* renamed from: W, reason: from kotlin metadata */
    private final SquareRenderStatistics statistics;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SquareMapScene f106092d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CoroutineContext.Key key, SquareMapScene squareMapScene) {
            super(key);
            this.f106092d = squareMapScene;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            FLog.INSTANCE.e("SquareMapScene", "there is an error in coroutine.", exception);
            String str = "";
            if (exception instanceof FetchFileException) {
                SquareMapScene squareMapScene = this.f106092d;
                FetchFileException fetchFileException = (FetchFileException) exception;
                int errorCode = fetchFileException.getErrorCode();
                String errorMessage = fetchFileException.getErrorMessage();
                if (errorMessage != null) {
                    str = errorMessage;
                }
                squareMapScene.o(errorCode, str);
                return;
            }
            if (exception instanceof BlackListResourceException) {
                SquareMapScene squareMapScene2 = this.f106092d;
                String message = exception.getMessage();
                if (message != null) {
                    str = message;
                }
                squareMapScene2.o(201005, str);
                return;
            }
            SquareMapScene squareMapScene3 = this.f106092d;
            String message2 = exception.getMessage();
            if (message2 != null) {
                str = message2;
            }
            squareMapScene3.o(201000, str);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/filament/zplan/scene/square/SquareMapScene$c", "Lcom/tencent/filament/zplan/engine/RenderCallback;", "", "pixelsAddress", "pixelsSize", "", "width", "height", "", "onFrameRendered", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class c implements RenderCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f106093a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WeakReference f106094b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f106095c;

        c(String str, WeakReference weakReference, long j3) {
            this.f106093a = str;
            this.f106094b = weakReference;
            this.f106095c = j3;
        }

        @Override // com.tencent.filament.zplan.engine.RenderCallback
        public void onFrameRendered(long pixelsAddress, long pixelsSize, int width, int height) {
            SquareMapScene squareMapScene;
            String str = this.f106093a;
            if (str != null && (squareMapScene = (SquareMapScene) this.f106094b.get()) != null) {
                squareMapScene.q0(str);
            }
            SquareMapScene squareMapScene2 = (SquareMapScene) this.f106094b.get();
            if (squareMapScene2 != null) {
                squareMapScene2.r0(this.f106095c);
            }
        }
    }

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"onTouchEvent", BootMapEvent.NAME, AddObjectEvent.NAME, RemoveObjectEvent.NAME, MoveViewportEvent.NAME, ObjectPlayEvent.NAME, ObjectStopEvent.NAME, ObjectResetEvent.NAME, ObjectUpdateResourceEvent.NAME, ObjectUpdateVisibleEvent.NAME, ObjectMoveToEvent.NAME, ObjectInteractionEvent.NAME, ResetObjectLocationEvent.NAME, StopObjectAnimationEvent.NAME, PlayObjectAnimationEvent.NAME});
        X = listOf;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareMapScene(@Nullable com.tencent.zplan.zplantracing.c cVar, @NotNull WeakReference<FilamentNativeAppV2305> app) {
        super(cVar, app);
        sk0.a configuration;
        FilamentUrlTemplate urlTemplate;
        Intrinsics.checkNotNullParameter(app, "app");
        FilamentNativeAppV2305 filamentNativeAppV2305 = app.get();
        this.urlTemplate = (filamentNativeAppV2305 == null || (configuration = filamentNativeAppV2305.getConfiguration()) == null || (urlTemplate = configuration.getUrlTemplate()) == null) ? FilamentFeatureUtil.f106409g.F() : urlTemplate;
        this.indirectLightPath = "";
        this.booted = new AtomicBoolean(false);
        this.syncFrames = new LinkedHashSet();
        this.waitCallbackFrameIds = new LinkedHashSet();
        this.createTime = System.currentTimeMillis();
        this.isFirstRendered = new AtomicBoolean(false);
        this.mapObjects = new ConcurrentHashMap<>();
        this.viewport = new SquareMapViewport(new WeakReference(this));
        this.coroutineContext = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()).plus(new a(CoroutineExceptionHandler.INSTANCE, this));
        this.statistics = new SquareRenderStatistics(0L, false, 0L, 0L, 15, null);
        for (String str : X) {
            FilamentNativeAppV2305 filamentNativeAppV23052 = app.get();
            if (filamentNativeAppV23052 != null) {
                filamentNativeAppV23052.addEventListener(str, this);
            }
        }
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = System.currentTimeMillis();
        k().e(new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.square.SquareMapScene.2
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
                SquareMapScene.this.statistics.setLoadSoCost(System.currentTimeMillis() - longRef.element);
            }
        });
    }

    private final Deferred<Unit> Z(com.tencent.zplan.zplantracing.c spanContext, Size mapSize, Size viewportSize) {
        Deferred<Unit> async$default;
        async$default = BuildersKt__Builders_commonKt.async$default(this, null, null, new SquareMapScene$bootAsync$1(this, mapSize, viewportSize, spanContext, null), 3, null);
        return async$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String a0(long renderObjectId) {
        for (Map.Entry<String, d> entry : this.mapObjects.entrySet()) {
            if (entry.getValue().g(renderObjectId)) {
                return entry.getKey();
            }
        }
        return null;
    }

    private final long b0() {
        long j3 = this.frameIdGenerator + 1;
        this.frameIdGenerator = j3;
        return j3;
    }

    private final synchronized void c0(com.tencent.zplan.zplantracing.c spanContext, AddObjectEvent evt) {
        d squareMapObjectAvatar;
        WeakReference weakReference = new WeakReference(this);
        if (this.mapObjects.containsKey(evt.getId())) {
            return;
        }
        int i3 = m.f106116b[evt.getType().ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                SquareImageData imageResource = evt.getImageResource();
                if (imageResource != null) {
                    squareMapObjectAvatar = new SquareMapObjectImage(evt.getId(), weakReference, imageResource, evt.getLocation(), evt.getSize(), evt.getDepth(), spanContext);
                } else {
                    return;
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            SquareAvatarData avatarResource = evt.getAvatarResource();
            if (avatarResource != null) {
                squareMapObjectAvatar = new SquareMapObjectAvatar(evt.getId(), weakReference, avatarResource, evt.getLocation(), evt.getSize(), evt.getDepth(), spanContext);
            } else {
                return;
            }
        }
        this.mapObjects.put(evt.getId(), squareMapObjectAvatar);
        e(new OnObjectStateChangedEvent(evt.getId(), ObjectState.INIT, null, 4, null));
    }

    private final void d0(MoveViewportEvent evt) {
        this.viewport.g(evt.getFrom(), evt.getTo(), evt.getDuration());
    }

    private final void e0(ObjectInteractionEvent evt) {
        d dVar = this.mapObjects.get(evt.getId());
        if (dVar != null) {
            dVar.b(evt.getHostAnim(), evt.getGuestAnim(), evt.getExtraAnimGltf());
        }
    }

    private final void f0(ObjectMoveToEvent evt) {
        d dVar = this.mapObjects.get(evt.getId());
        if (dVar != null) {
            dVar.d(evt.getTargetLocation(), evt.getDuration());
        }
    }

    private final void g0(ObjectPlayEvent evt) {
        d dVar = this.mapObjects.get(evt.getId());
        if (dVar != null) {
            dVar.play();
        }
    }

    private final void h0(ObjectResetEvent evt) {
        d dVar = this.mapObjects.get(evt.getId());
        if (dVar != null) {
            dVar.reset();
        }
    }

    private final void i0(ObjectStopEvent evt) {
        d dVar = this.mapObjects.get(evt.getId());
        if (dVar != null) {
            dVar.stop();
        }
    }

    private final void j0(final TouchEvent touchEvent) {
        final ObjectTapType a16 = l.a(touchEvent.getType());
        if (a16 != null) {
            k().e(new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.square.SquareMapScene$handleObjectTappedEvent$1
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
                    FilamentViewerV2305 viewer;
                    String a06;
                    viewer = SquareMapScene.this.getViewer();
                    if (viewer != null) {
                        a06 = SquareMapScene.this.a0(viewer.getHitRenderObjectIDAt(b.a(viewer, touchEvent.getLocation())));
                        if (a06 != null) {
                            SquareMapScene.this.e(new OnObjectTappedEvent(a06, a16));
                        }
                    }
                }
            });
        }
    }

    private final void k0(ObjectUpdateResourceEvent evt) {
        Object obj;
        d dVar = this.mapObjects.get(evt.getId());
        if (dVar != null) {
            if (dVar instanceof SquareMapObjectAvatar) {
                obj = evt.getAvatarResource();
            } else if (dVar instanceof SquareMapObjectImage) {
                obj = evt.getImageResource();
            } else {
                obj = null;
            }
            if (obj != null) {
                dVar.f(obj);
            }
        }
    }

    private final void l0(ObjectUpdateVisibleEvent evt) {
        d dVar = this.mapObjects.get(evt.getId());
        if (dVar != null) {
            dVar.setVisibility(evt.getVisible());
        }
    }

    private final void m0() {
        k().e(new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.square.SquareMapScene$handlePlayObjectAnimationEvent$1
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
                SquareMapScene squareMapScene = SquareMapScene.this;
                squareMapScene.recoverFilamentFrameTag = String.valueOf(squareMapScene.g());
            }
        });
    }

    private final void n0(RemoveObjectEvent evt) {
        d remove = this.mapObjects.remove(evt.getId());
        if (remove != null) {
            remove.destroy();
        }
        e(new OnObjectStateChangedEvent(evt.getId(), ObjectState.REMOVED, null, 4, null));
    }

    private final void o0() {
        Iterator<Map.Entry<String, d>> it = this.mapObjects.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().e();
        }
    }

    private final void p0() {
        k().e(new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.square.SquareMapScene$handleStopObjectAnimationEvent$1
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
                ConcurrentHashMap concurrentHashMap;
                SquareMapScene.this.recoverFilamentFrameTag = null;
                SquareMapScene.this.pauseFilament = true;
                SquareMapScene.this.x(60.0f);
                concurrentHashMap = SquareMapScene.this.mapObjects;
                Iterator it = concurrentHashMap.entrySet().iterator();
                while (it.hasNext()) {
                    ((d) ((Map.Entry) it.next()).getValue()).stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(final String currentFrameTag) {
        k().e(new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.square.SquareMapScene$onRecoverFilamentFrameEnd$1
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
                String str;
                Set set;
                Set set2;
                ConcurrentHashMap concurrentHashMap;
                ConcurrentHashMap concurrentHashMap2;
                str = SquareMapScene.this.recoverFilamentFrameTag;
                if (Intrinsics.areEqual(str, currentFrameTag)) {
                    SquareMapScene.this.recoverFilamentFrameTag = null;
                    SquareMapScene.this.pauseFilament = false;
                    SquareMapScene.this.e(new OnRecoveredFilamentRender());
                    set = SquareMapScene.this.waitCallbackFrameIds;
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        long longValue = ((Number) it.next()).longValue();
                        concurrentHashMap2 = SquareMapScene.this.mapObjects;
                        Iterator it5 = concurrentHashMap2.entrySet().iterator();
                        while (it5.hasNext()) {
                            ((d) ((Map.Entry) it5.next()).getValue()).a(longValue);
                        }
                    }
                    set2 = SquareMapScene.this.waitCallbackFrameIds;
                    set2.clear();
                    SquareMapScene.this.x(15.0f);
                    concurrentHashMap = SquareMapScene.this.mapObjects;
                    Iterator it6 = concurrentHashMap.entrySet().iterator();
                    while (it6.hasNext()) {
                        ((d) ((Map.Entry) it6.next()).getValue()).play();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0(final long currentFrameId) {
        k().e(new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.square.SquareMapScene$onSyncFrameRenderEnd$1
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
                boolean z16;
                ConcurrentHashMap concurrentHashMap;
                Set set;
                AtomicBoolean atomicBoolean;
                long j3;
                Set set2;
                z16 = SquareMapScene.this.pauseFilament;
                if (z16) {
                    set2 = SquareMapScene.this.waitCallbackFrameIds;
                    set2.add(Long.valueOf(currentFrameId));
                } else {
                    concurrentHashMap = SquareMapScene.this.mapObjects;
                    Iterator it = concurrentHashMap.entrySet().iterator();
                    while (it.hasNext()) {
                        ((d) ((Map.Entry) it.next()).getValue()).a(currentFrameId);
                    }
                }
                set = SquareMapScene.this.syncFrames;
                CollectionsKt__MutableCollectionsKt.removeAll(set, new Function1<Long, Boolean>() { // from class: com.tencent.filament.zplan.scene.square.SquareMapScene$onSyncFrameRenderEnd$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Long l3) {
                        return Boolean.valueOf(invoke(l3.longValue()));
                    }

                    public final boolean invoke(long j16) {
                        return j16 <= currentFrameId;
                    }
                });
                atomicBoolean = SquareMapScene.this.isFirstRendered;
                if (atomicBoolean.compareAndSet(false, true)) {
                    SquareRenderStatistics squareRenderStatistics = SquareMapScene.this.statistics;
                    long currentTimeMillis = System.currentTimeMillis();
                    j3 = SquareMapScene.this.createTime;
                    squareRenderStatistics.setFirstFrameCost(currentTimeMillis - j3);
                    FLog.INSTANCE.i("SquareMapScene", "first render success. used: " + SquareMapScene.this.statistics.getFirstFrameCost() + "ms");
                    FilamentNativeAppV2305 filamentNativeAppV2305 = SquareMapScene.this.j().get();
                    if (filamentNativeAppV2305 != null) {
                        filamentNativeAppV2305.dispatchEvent(null, "onFirstFrameRenderEnd", SquareMapScene.this.statistics.toJson());
                    }
                }
            }
        });
    }

    @Override // com.tencent.filament.zplan.scene.square.e
    @NotNull
    /* renamed from: a, reason: from getter */
    public FilamentUrlTemplate getUrlTemplate() {
        return this.urlTemplate;
    }

    @Override // com.tencent.filament.zplan.scene.square.e
    @Nullable
    public FilamentViewerV2305 b() {
        return getViewer();
    }

    @Override // com.tencent.filament.zplan.scene.square.e
    @NotNull
    public FilamentThreadHandler c() {
        return k();
    }

    @Override // com.tencent.filament.zplan.util.vsync.b
    public void d(long totalTime, long frameTime) {
        if (!getAttached().get()) {
            return;
        }
        this.curAnimTime = totalTime;
        this.viewport.c(totalTime);
        Collection<d> values = this.mapObjects.values();
        Intrinsics.checkNotNullExpressionValue(values, "mapObjects.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((d) it.next()).c(this.curAnimTime);
        }
        if (this.isFirstRendered.get() && !(!this.syncFrames.isEmpty())) {
            FilamentViewerV2305 viewer = getViewer();
            if (viewer != null) {
                FilamentViewerV2.render$default(viewer, false, null, 3, null);
                return;
            }
            return;
        }
        WeakReference weakReference = new WeakReference(this);
        String str = this.recoverFilamentFrameTag;
        long b06 = b0();
        FilamentViewerV2305 viewer2 = getViewer();
        if (viewer2 != null) {
            viewer2.render((com.tencent.zplan.zplantracing.c) null, new c(str, weakReference, b06));
        }
    }

    @Override // com.tencent.filament.zplan.scene.square.e
    public void e(@NotNull SquareMapEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        FilamentNativeAppV2305 filamentNativeAppV2305 = j().get();
        if (filamentNativeAppV2305 != null) {
            filamentNativeAppV2305.dispatchEvent(null, event.getEventName(), event.toJson());
        }
    }

    @Override // com.tencent.filament.zplan.scene.square.e
    @Nullable
    /* renamed from: f, reason: from getter */
    public n getSquareMapSceneHelper() {
        return this.squareMapSceneHelper;
    }

    @Override // com.tencent.filament.zplan.scene.square.e
    public long g() {
        long j3 = this.frameIdGenerator + 1;
        this.syncFrames.add(Long.valueOf(j3));
        return j3;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // sk0.b
    public void handleEvent(@Nullable com.tencent.zplan.zplantracing.c spanContext, @NotNull String type, @Nullable String data) {
        AddObjectEvent addObjectEvent;
        BootMapEvent bootMapEvent;
        ObjectPlayEvent objectPlayEvent;
        ObjectStopEvent objectStopEvent;
        ObjectUpdateVisibleEvent objectUpdateVisibleEvent;
        MoveViewportEvent moveViewportEvent;
        ObjectUpdateResourceEvent objectUpdateResourceEvent;
        RemoveObjectEvent removeObjectEvent;
        ObjectResetEvent objectResetEvent;
        ObjectInteractionEvent objectInteractionEvent;
        ObjectMoveToEvent objectMoveToEvent;
        Intrinsics.checkNotNullParameter(type, "type");
        switch (type.hashCode()) {
            case -2063736183:
                if (type.equals(PlayObjectAnimationEvent.NAME)) {
                    m0();
                    return;
                }
                return;
            case -1356971113:
                if (type.equals(AddObjectEvent.NAME)) {
                    SquareMapEvent.Companion companion = SquareMapEvent.INSTANCE;
                    if (data != null && (addObjectEvent = (AddObjectEvent) companion.a(data, AddObjectEvent.class)) != null) {
                        c0(spanContext, addObjectEvent);
                        return;
                    }
                    return;
                }
                return;
            case -610910263:
                if (type.equals(BootMapEvent.NAME)) {
                    SquareMapEvent.Companion companion2 = SquareMapEvent.INSTANCE;
                    if (data != null && (bootMapEvent = (BootMapEvent) companion2.a(data, BootMapEvent.class)) != null) {
                        Z(spanContext, bootMapEvent.getMapSize(), bootMapEvent.getViewportSize());
                        return;
                    }
                    return;
                }
                return;
            case 40804506:
                if (type.equals(ObjectPlayEvent.NAME)) {
                    SquareMapEvent.Companion companion3 = SquareMapEvent.INSTANCE;
                    if (data != null && (objectPlayEvent = (ObjectPlayEvent) companion3.a(data, ObjectPlayEvent.class)) != null) {
                        g0(objectPlayEvent);
                        return;
                    }
                    return;
                }
                return;
            case 40901992:
                if (type.equals(ObjectStopEvent.NAME)) {
                    SquareMapEvent.Companion companion4 = SquareMapEvent.INSTANCE;
                    if (data != null && (objectStopEvent = (ObjectStopEvent) companion4.a(data, ObjectStopEvent.class)) != null) {
                        i0(objectStopEvent);
                        return;
                    }
                    return;
                }
                return;
            case 150441154:
                if (type.equals(ObjectUpdateVisibleEvent.NAME)) {
                    SquareMapEvent.Companion companion5 = SquareMapEvent.INSTANCE;
                    if (data != null && (objectUpdateVisibleEvent = (ObjectUpdateVisibleEvent) companion5.a(data, ObjectUpdateVisibleEvent.class)) != null) {
                        l0(objectUpdateVisibleEvent);
                        return;
                    }
                    return;
                }
                return;
            case 206728250:
                if (type.equals(MoveViewportEvent.NAME)) {
                    SquareMapEvent.Companion companion6 = SquareMapEvent.INSTANCE;
                    if (data != null && (moveViewportEvent = (MoveViewportEvent) companion6.a(data, MoveViewportEvent.class)) != null) {
                        d0(moveViewportEvent);
                        return;
                    }
                    return;
                }
                return;
            case 705333423:
                if (type.equals(ObjectUpdateResourceEvent.NAME)) {
                    SquareMapEvent.Companion companion7 = SquareMapEvent.INSTANCE;
                    if (data != null && (objectUpdateResourceEvent = (ObjectUpdateResourceEvent) companion7.a(data, ObjectUpdateResourceEvent.class)) != null) {
                        k0(objectUpdateResourceEvent);
                        return;
                    }
                    return;
                }
                return;
            case 907548224:
                if (type.equals(RemoveObjectEvent.NAME)) {
                    SquareMapEvent.Companion companion8 = SquareMapEvent.INSTANCE;
                    if (data != null && (removeObjectEvent = (RemoveObjectEvent) companion8.a(data, RemoveObjectEvent.class)) != null) {
                        n0(removeObjectEvent);
                        return;
                    }
                    return;
                }
                return;
            case 1040702331:
                if (type.equals(StopObjectAnimationEvent.NAME)) {
                    p0();
                    return;
                }
                return;
            case 1266594953:
                if (type.equals(ObjectResetEvent.NAME)) {
                    SquareMapEvent.Companion companion9 = SquareMapEvent.INSTANCE;
                    if (data != null && (objectResetEvent = (ObjectResetEvent) companion9.a(data, ObjectResetEvent.class)) != null) {
                        h0(objectResetEvent);
                        return;
                    }
                    return;
                }
                return;
            case 1570932172:
                if (type.equals(ObjectInteractionEvent.NAME)) {
                    SquareMapEvent.Companion companion10 = SquareMapEvent.INSTANCE;
                    if (data != null && (objectInteractionEvent = (ObjectInteractionEvent) companion10.a(data, ObjectInteractionEvent.class)) != null) {
                        e0(objectInteractionEvent);
                        return;
                    }
                    return;
                }
                return;
            case 1719579098:
                if (type.equals("onTouchEvent")) {
                    try {
                        TouchEvent touchEvent = (TouchEvent) new Gson().fromJson(data, TouchEvent.class);
                        int i3 = m.f106115a[touchEvent.getType().ordinal()];
                        if (i3 != 1) {
                            if (i3 != 2) {
                                if (i3 == 3 || i3 == 4 || i3 == 5) {
                                    Intrinsics.checkNotNullExpressionValue(touchEvent, "touchEvent");
                                    j0(touchEvent);
                                }
                            } else {
                                SquareMapViewport squareMapViewport = this.viewport;
                                Intrinsics.checkNotNullExpressionValue(touchEvent, "touchEvent");
                                squareMapViewport.f(spanContext, touchEvent);
                            }
                        } else {
                            SquareMapViewport squareMapViewport2 = this.viewport;
                            Intrinsics.checkNotNullExpressionValue(touchEvent, "touchEvent");
                            squareMapViewport2.e(spanContext, touchEvent);
                        }
                        return;
                    } catch (Exception e16) {
                        FLog.INSTANCE.e("SquareMapScene", "touchEvent: error: " + e16);
                        return;
                    }
                }
                return;
            case 1868529283:
                if (type.equals(ObjectMoveToEvent.NAME)) {
                    SquareMapEvent.Companion companion11 = SquareMapEvent.INSTANCE;
                    if (data != null && (objectMoveToEvent = (ObjectMoveToEvent) companion11.a(data, ObjectMoveToEvent.class)) != null) {
                        f0(objectMoveToEvent);
                        return;
                    }
                    return;
                }
                return;
            case 2009195098:
                if (type.equals(ResetObjectLocationEvent.NAME)) {
                    o0();
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void o(int errorCode, @Nullable String errorMessage) {
        super.o(errorCode, errorMessage);
        FilamentNativeAppV2305 filamentNativeAppV2305 = j().get();
        if (filamentNativeAppV2305 != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("errorCode", errorCode);
            jSONObject.put("errorMessage", errorMessage);
            Unit unit = Unit.INSTANCE;
            filamentNativeAppV2305.dispatchEvent(null, "onFilamentRenderFail", jSONObject.toString());
        }
    }

    @Override // com.tencent.filament.zplan.scene.square.e
    @NotNull
    public CoroutineScope getCoroutineScope() {
        return this;
    }
}
