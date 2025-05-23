package com.tencent.filament.zplan.render.impl;

import al0.a;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.exifinterface.media.ExifInterface;
import cl0.FilamentSceneMonitorConfig;
import cl0.GpuOptimizeOptions;
import cl0.SceneConfig;
import com.google.gson.Gson;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.filament.zplan.business.api.IBusinessScene;
import com.tencent.filament.zplan.business.api.SceneType;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplan.engine.js.FilamentEventDispatcher;
import com.tencent.filament.zplan.render.impl.FilamentNativeApp$executor$2;
import com.tencent.filament.zplan.render.impl.FilamentNativeApp$vSyncListener$2;
import com.tencent.filament.zplan.util.GamePerformanceMonitor;
import com.tencent.filament.zplan.util.JsonUtilKt;
import com.tencent.filament.zplan.util.vsync.VSyncScheduler;
import com.tencent.filament.zplan.view.FilamentTextureView;
import com.tencent.filament.zplan.view.controller.FilamentTouchController;
import com.tencent.filament.zplan.view.event.TouchEvent;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import dl0.g;
import dl0.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;
import uk0.c;
import uk0.e;
import vk0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ba\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u000f*\b\u0098\u0001\u00aa\u0001\u00ae\u0001\u00b2\u0001\b\u0000\u0018\u0000 \u00bf\u00012\u00020\u00012\u00020\u0002:\u00017B\u001c\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u0012\u0007\u0010\u00bc\u0001\u001a\u00020\u0005\u00a2\u0006\u0006\b\u00bd\u0001\u0010\u00be\u0001J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u001e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0010H\u0002J(\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u00142\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0010H\u0002J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0017H\u0002J\u0018\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u000eH\u0002J\b\u0010\u001c\u001a\u00020\u0014H\u0002J\b\u0010\u001d\u001a\u00020\u0005H\u0002J\b\u0010\u001e\u001a\u00020\fH\u0002J\u0018\u0010\"\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020\u0005H\u0016J$\u0010(\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010\u000e2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u0018\u0010,\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020*H\u0016J\u0018\u0010-\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020*H\u0016J\u0010\u0010.\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u000eH\u0016J!\u00103\u001a\u0002022\u0006\u00100\u001a\u00020/2\b\u00101\u001a\u0004\u0018\u00010\u0014H\u0016\u00a2\u0006\u0004\b3\u00104J\n\u00105\u001a\u0004\u0018\u00010 H\u0016J\u0012\u00107\u001a\u00020\f2\b\u0010+\u001a\u0004\u0018\u000106H\u0016J\b\u00108\u001a\u00020\fH\u0016J\u0013\u00109\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b9\u0010:J\b\u0010;\u001a\u00020\fH\u0016J\b\u0010<\u001a\u00020\fH\u0016J\u0006\u0010=\u001a\u00020\fJ\u0010\u0010?\u001a\u00020\f2\u0006\u0010$\u001a\u00020>H\u0016R\u0014\u0010B\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u0010AR\u0016\u0010E\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010H\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010GR\u0018\u0010K\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010^\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010b\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u001a\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00170c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010dR \u0010j\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020g0f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0014\u0010n\u001a\u00020k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0014\u0010p\u001a\u00020k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bo\u0010mR\u0014\u0010r\u001a\u00020k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bq\u0010mR\u0018\u0010v\u001a\u0004\u0018\u00010s8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010x\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010wR\u0018\u0010z\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010RR\u0014\u0010|\u001a\u00020k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b{\u0010mR\u0014\u0010}\u001a\u00020k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010mR\u0014\u0010\u007f\u001a\u00020k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b~\u0010mR\u001c\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R!\u0010\u0089\u0001\u001a\u00030\u0084\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R.\u0010\u008f\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0005\u0012\u00030\u008b\u00010\u008a\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u008c\u0001\u0010\u0086\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R \u0010\u0093\u0001\u001a\u00030\u0090\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\"\u0010\u0086\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R \u0010\u0097\u0001\u001a\u00030\u0094\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b3\u0010\u0086\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R \u0010\u009b\u0001\u001a\u00030\u0098\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b#\u0010\u0086\u0001\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001R!\u0010\u00a0\u0001\u001a\u00030\u009c\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u009d\u0001\u0010\u0086\u0001\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0018\u0010\u00a4\u0001\u001a\u00030\u00a1\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a2\u0001\u0010\u00a3\u0001R!\u0010\u00a9\u0001\u001a\u00030\u00a5\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00a6\u0001\u0010\u0086\u0001\u001a\u0006\b\u00a7\u0001\u0010\u00a8\u0001R\u0018\u0010\u00ad\u0001\u001a\u00030\u00aa\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ab\u0001\u0010\u00ac\u0001R\u0018\u0010\u00b1\u0001\u001a\u00030\u00ae\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00af\u0001\u0010\u00b0\u0001R\u0018\u0010\u00b5\u0001\u001a\u00030\u00b2\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b3\u0001\u0010\u00b4\u0001R\u001d\u0010'\u001a\u0004\u0018\u00010&8\u0006\u00a2\u0006\u0010\n\u0006\b\u00b6\u0001\u0010\u00b7\u0001\u001a\u0006\b\u00b8\u0001\u0010\u00b9\u0001R\u001a\u0010\u00bc\u0001\u001a\u00020\u00058\u0006\u00a2\u0006\u000e\n\u0004\bD\u0010D\u001a\u0006\b\u00ba\u0001\u0010\u00bb\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u00c0\u0001"}, d2 = {"Lcom/tencent/filament/zplan/render/impl/FilamentNativeApp;", "Lwk0/a;", "Lcom/tencent/filament/zplan/view/controller/FilamentTouchController$b;", "Lcom/tencent/filament/zplan/business/api/SceneType;", "sceneType", "", "level", "Lcl0/i;", "y0", "", "totalTime", "frameTime", "", "F0", "", "funName", "Lkotlin/Function0;", "task", "q0", "from", "", "forceEvaluate", "G0", "Ljava/lang/Runnable;", "p0", "errorCode", "errorMessage", "E0", "r0", "z0", "I0", "entry", "Lcom/tencent/filament/zplan/business/api/IBusinessScene;", "businessScene", "y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "event", "data", "Lcom/tencent/zplan/zplantracing/c;", "zplanSpanContext", "k", "type", "Luk0/e;", "listener", "c", "t", "removeEventListener", "Landroid/content/Context;", "context", "enableTouch", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Landroid/content/Context;Ljava/lang/Boolean;)Landroid/view/View;", "getScene", "Luk0/c;", "a", "onResume", "J0", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "s0", "Lcom/tencent/filament/zplan/view/event/TouchEvent;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "ioScope", "b", "I", "deviceLevel", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2;", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2;", "viewer", "d", "Lcom/tencent/filament/zplan/business/api/IBusinessScene;", "scene", "Ljava/util/concurrent/atomic/AtomicInteger;", "e", "Ljava/util/concurrent/atomic/AtomicInteger;", "appStatus", "Lcom/tencent/zplan/zplantracing/b;", "f", "Lcom/tencent/zplan/zplantracing/b;", "startWithEntrySpan", "Lvk0/a;", "g", "Lvk0/a;", "startUpTrack", "Lcom/tencent/filament/zplan/view/FilamentTextureView;", h.F, "Lcom/tencent/filament/zplan/view/FilamentTextureView;", "filamentView", "i", "Luk0/c;", "filamentRenderListener", "Landroid/graphics/SurfaceTexture;", "j", "Landroid/graphics/SurfaceTexture;", "surfaceTextureTmp", "", "Ljava/util/List;", "viewerWaitList", "", "Lal0/a;", "l", "Ljava/util/Map;", "startupSteps", "Ljava/util/concurrent/atomic/AtomicBoolean;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/concurrent/atomic/AtomicBoolean;", "needFirstFramePng", DomainData.DOMAIN_NAME, "attached", "o", "loadResource", "Lcom/tencent/filament/zplan/view/controller/FilamentTouchController;", "p", "Lcom/tencent/filament/zplan/view/controller/FilamentTouchController;", "filamentTouchController", "Z", "firstFrameFlag", "r", "loadSoSpan", ReportConstant.COSTREPORT_PREFIX, "hasRecordFrameCallback", "hasMonitorRecordEnd", "u", "hasPaused", "Lcom/tencent/filament/zplan/util/GamePerformanceMonitor;", "v", "Lcom/tencent/filament/zplan/util/GamePerformanceMonitor;", "gamePerformanceMonitor", "Lcl0/g;", "w", "Lkotlin/Lazy;", "w0", "()Lcl0/g;", "filamentSceneMonitorConfig", "", "Lcl0/k;", HippyTKDListViewAdapter.X, "v0", "()Ljava/util/Map;", "filamentGpuLevelConfig", "Lcom/tencent/filament/zplan/engine/js/FilamentEventDispatcher;", "t0", "()Lcom/tencent/filament/zplan/engine/js/FilamentEventDispatcher;", "eventDispatcher", "Lcom/tencent/filament/zplan/business/api/b;", "u0", "()Lcom/tencent/filament/zplan/business/api/b;", "executor", "com/tencent/filament/zplan/render/impl/FilamentNativeApp$vSyncListener$2$a", "A0", "()Lcom/tencent/filament/zplan/render/impl/FilamentNativeApp$vSyncListener$2$a;", "vSyncListener", "Lcom/tencent/filament/zplan/util/vsync/VSyncScheduler;", "B", "B0", "()Lcom/tencent/filament/zplan/util/vsync/VSyncScheduler;", "vSyncScheduler", "Landroid/os/HandlerThread;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/os/HandlerThread;", "viewerHandlerThread", "Landroid/os/Handler;", "D", "C0", "()Landroid/os/Handler;", "viewerHandler", "com/tencent/filament/zplan/render/impl/FilamentNativeApp$recordFrameListener$1", "E", "Lcom/tencent/filament/zplan/render/impl/FilamentNativeApp$recordFrameListener$1;", "recordFrameListener", "com/tencent/filament/zplan/render/impl/FilamentNativeApp$loadSoListener$1", UserInfo.SEX_FEMALE, "Lcom/tencent/filament/zplan/render/impl/FilamentNativeApp$loadSoListener$1;", "loadSoListener", "com/tencent/filament/zplan/render/impl/FilamentNativeApp$c", "G", "Lcom/tencent/filament/zplan/render/impl/FilamentNativeApp$c;", "innerEventListener", "H", "Lcom/tencent/zplan/zplantracing/c;", "D0", "()Lcom/tencent/zplan/zplantracing/c;", "x0", "()I", "fps", "<init>", "(Lcom/tencent/zplan/zplantracing/c;I)V", "L", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentNativeApp implements wk0.a, FilamentTouchController.b {
    private static final g J;
    private static final boolean K;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A, reason: from kotlin metadata */
    private final Lazy vSyncListener;

    /* renamed from: B, reason: from kotlin metadata */
    private final Lazy vSyncScheduler;

    /* renamed from: C, reason: from kotlin metadata */
    private final HandlerThread viewerHandlerThread;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy viewerHandler;

    /* renamed from: E, reason: from kotlin metadata */
    private final FilamentNativeApp$recordFrameListener$1 recordFrameListener;

    /* renamed from: F, reason: from kotlin metadata */
    private final FilamentNativeApp$loadSoListener$1 loadSoListener;

    /* renamed from: G, reason: from kotlin metadata */
    private final c innerEventListener;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private final com.tencent.zplan.zplantracing.c zplanSpanContext;

    /* renamed from: I, reason: from kotlin metadata */
    private final int fps;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final CoroutineScope ioScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int deviceLevel = -1;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private FilamentViewerV2 viewer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private IBusinessScene scene;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final AtomicInteger appStatus;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.zplan.zplantracing.b startWithEntrySpan;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private vk0.a startUpTrack;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FilamentTextureView filamentView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private uk0.c filamentRenderListener;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private SurfaceTexture surfaceTextureTmp;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final List<Runnable> viewerWaitList;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final Map<String, al0.a> startupSteps;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean needFirstFramePng;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean attached;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean loadResource;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private FilamentTouchController filamentTouchController;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private boolean firstFrameFlag;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private com.tencent.zplan.zplantracing.b loadSoSpan;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean hasRecordFrameCallback;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean hasMonitorRecordEnd;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean hasPaused;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private GamePerformanceMonitor gamePerformanceMonitor;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private final Lazy filamentSceneMonitorConfig;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private final Lazy filamentGpuLevelConfig;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private final Lazy eventDispatcher;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private final Lazy executor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u0002H\u0002R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0007R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/filament/zplan/render/impl/FilamentNativeApp$a;", "", "Lcom/tencent/filament/zplan/business/api/IBusinessScene;", "", "b", "", "DEFAULT_EXECUTAE_AFTER_DESTROY", "Z", "REPORT_KEY_RUNTIME_PERFORMANCE", "Ljava/lang/String;", "TAG", "THREAD_NAME", "", "THREAD_PRIORITY_DEFAULT", "I", "UNKNOWN_SCENE", "executeAfterDestroy", "Ldl0/g;", "qqmcProxy", "Ldl0/g;", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplan.render.impl.FilamentNativeApp$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String b(IBusinessScene iBusinessScene) {
            if (iBusinessScene == null) {
                return "unknownScene";
            }
            return iBusinessScene.getClass().getSimpleName();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n\u00a2\u0006\u0002\b\u0007\u00a8\u0006\t"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch", "com/tencent/filament/zplan/render/impl/FilamentNativeApp$getView$1$1$3", "com/tencent/filament/zplan/render/impl/FilamentNativeApp$$special$$inlined$apply$lambda$2"}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    static final class b implements View.OnTouchListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f105858e;

        b(Context context) {
            this.f105858e = context;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            ScaleGestureDetector o16;
            GestureDetector m3;
            if (motionEvent != null) {
                int pointerCount = motionEvent.getPointerCount();
                FilamentTouchController filamentTouchController = FilamentNativeApp.this.filamentTouchController;
                if (filamentTouchController != null) {
                    filamentTouchController.z(motionEvent);
                }
                if (pointerCount == 1) {
                    FilamentTouchController filamentTouchController2 = FilamentNativeApp.this.filamentTouchController;
                    if (filamentTouchController2 != null && (m3 = filamentTouchController2.m()) != null) {
                        m3.onTouchEvent(motionEvent);
                    }
                } else {
                    FilamentTouchController filamentTouchController3 = FilamentNativeApp.this.filamentTouchController;
                    if (filamentTouchController3 != null && (o16 = filamentTouchController3.o()) != null) {
                        o16.onTouchEvent(motionEvent);
                    }
                }
            }
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/filament/zplan/render/impl/FilamentNativeApp$c", "Luk0/e;", "", "type", "eventData", "", "onEvent", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class c implements e {
        c() {
        }

        @Override // uk0.e
        public void onEvent(@NotNull String type, @NotNull String eventData) {
            JSONObject b16;
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(eventData, "eventData");
            FLog.INSTANCE.i("FilamentNativeApp", "innerEventListener onEvent:" + type + ", data:" + eventData);
            if (type.hashCode() == -1565730423 && type.equals("onFilamentRenderFail") && (b16 = com.tencent.zplan.common.utils.h.f385294a.b(eventData)) != null) {
                int optInt = b16.optInt("errorCode");
                String errorMessage = b16.optString("errorMessage");
                vk0.a aVar = FilamentNativeApp.this.startUpTrack;
                String valueOf = String.valueOf(FilamentNativeApp.this.appStatus.get());
                Intrinsics.checkNotNullExpressionValue(errorMessage, "errorMessage");
                aVar.c(valueOf, optInt, errorMessage);
                FilamentNativeApp.this.E0(optInt, errorMessage);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/filament/zplan/render/impl/FilamentNativeApp$d", "Lcom/tencent/filament/zplan/business/api/c;", "Lal0/a;", "statistic", "", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class d implements com.tencent.filament.zplan.business.api.c {
        d() {
        }

        @Override // com.tencent.filament.zplan.business.api.c
        public void a(@NotNull al0.a statistic) {
            Intrinsics.checkNotNullParameter(statistic, "statistic");
            FLog.INSTANCE.i("FilamentNativeApp", "onReloadAvatarComplete, statistic:" + statistic);
            FilamentNativeApp.this.needFirstFramePng.set(true);
            FilamentNativeApp.this.firstFrameFlag = true;
            FilamentNativeApp.this.loadResource.set(true);
            FilamentNativeApp.this.startUpTrack.h(statistic);
            com.tencent.zplan.zplantracing.b bVar = FilamentNativeApp.this.startWithEntrySpan;
            if (bVar != null) {
                bVar.b();
            }
            FilamentNativeApp.this.startWithEntrySpan = null;
        }
    }

    static {
        g gVar = (g) fl0.a.f399763a.a(g.class);
        J = gVar;
        boolean z16 = false;
        if (gVar != null) {
            z16 = gVar.isSwitchOn("native_app_execute_after_destroy", false);
        }
        K = z16;
    }

    public FilamentNativeApp(@Nullable com.tencent.zplan.zplantracing.c cVar, int i3) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        this.zplanSpanContext = cVar;
        this.fps = i3;
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this.appStatus = atomicInteger;
        this.startUpTrack = new vk0.a();
        this.viewerWaitList = new ArrayList();
        this.startupSteps = new LinkedHashMap();
        this.needFirstFramePng = new AtomicBoolean(true);
        this.attached = new AtomicBoolean(false);
        this.loadResource = new AtomicBoolean(false);
        this.firstFrameFlag = true;
        this.hasRecordFrameCallback = new AtomicBoolean(false);
        this.hasMonitorRecordEnd = new AtomicBoolean(false);
        this.hasPaused = new AtomicBoolean(false);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FilamentSceneMonitorConfig>() { // from class: com.tencent.filament.zplan.render.impl.FilamentNativeApp$filamentSceneMonitorConfig$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FilamentSceneMonitorConfig invoke() {
                return FilamentFeatureUtil.f106409g.w();
            }
        });
        this.filamentSceneMonitorConfig = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Map<String, ? extends SceneConfig>>() { // from class: com.tencent.filament.zplan.render.impl.FilamentNativeApp$filamentGpuLevelConfig$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<String, ? extends SceneConfig> invoke() {
                return FilamentFeatureUtil.f106409g.v();
            }
        });
        this.filamentGpuLevelConfig = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<FilamentEventDispatcher>() { // from class: com.tencent.filament.zplan.render.impl.FilamentNativeApp$eventDispatcher$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FilamentEventDispatcher invoke() {
                return new FilamentEventDispatcher();
            }
        });
        this.eventDispatcher = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<FilamentNativeApp$executor$2.a>() { // from class: com.tencent.filament.zplan.render.impl.FilamentNativeApp$executor$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/filament/zplan/render/impl/FilamentNativeApp$executor$2$a", "Lcom/tencent/filament/zplan/business/api/b;", "", "funName", "Lkotlin/Function0;", "", "task", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
            /* loaded from: classes6.dex */
            public static final class a implements com.tencent.filament.zplan.business.api.b {
                a() {
                }

                @Override // com.tencent.filament.zplan.business.api.b
                public void a(@NotNull String funName, @NotNull Function0<Unit> task) {
                    boolean z16;
                    Intrinsics.checkNotNullParameter(funName, "funName");
                    Intrinsics.checkNotNullParameter(task, "task");
                    z16 = FilamentNativeApp.K;
                    if (!z16 && FilamentNativeApp.this.appStatus.get() == 3) {
                        return;
                    }
                    FilamentNativeApp.H0(FilamentNativeApp.this, funName, false, task, 2, null);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a();
            }
        });
        this.executor = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<FilamentNativeApp$vSyncListener$2.a>() { // from class: com.tencent.filament.zplan.render.impl.FilamentNativeApp$vSyncListener$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/filament/zplan/render/impl/FilamentNativeApp$vSyncListener$2$a", "Lcom/tencent/filament/zplan/util/vsync/b;", "", "totalTime", "frameTime", "", "d", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
            /* loaded from: classes6.dex */
            public static final class a implements com.tencent.filament.zplan.util.vsync.b {
                a() {
                }

                @Override // com.tencent.filament.zplan.util.vsync.b
                public void d(long totalTime, long frameTime) {
                    FilamentNativeApp.this.F0(totalTime, frameTime);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a();
            }
        });
        this.vSyncListener = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<VSyncScheduler>() { // from class: com.tencent.filament.zplan.render.impl.FilamentNativeApp$vSyncScheduler$2

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "command", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "execute"}, k = 3, mv = {1, 4, 2})
            /* loaded from: classes6.dex */
            public static final class a implements Executor {
                a() {
                }

                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    Handler C0;
                    if (runnable != null) {
                        C0 = FilamentNativeApp.this.C0();
                        C0.post(runnable);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VSyncScheduler invoke() {
                FilamentNativeApp$vSyncListener$2.a A0;
                A0 = FilamentNativeApp.this.A0();
                return new VSyncScheduler(A0, FilamentNativeApp.this.getFps(), new a());
            }
        });
        this.vSyncScheduler = lazy6;
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("filament_native_" + UUID.randomUUID(), 0);
        baseHandlerThread.start();
        Unit unit = Unit.INSTANCE;
        this.viewerHandlerThread = baseHandlerThread;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.filament.zplan.render.impl.FilamentNativeApp$viewerHandler$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                HandlerThread handlerThread;
                handlerThread = FilamentNativeApp.this.viewerHandlerThread;
                return new Handler(handlerThread.getLooper());
            }
        });
        this.viewerHandler = lazy7;
        this.recordFrameListener = new FilamentNativeApp$recordFrameListener$1(this);
        FilamentNativeApp$loadSoListener$1 filamentNativeApp$loadSoListener$1 = new FilamentNativeApp$loadSoListener$1(this);
        this.loadSoListener = filamentNativeApp$loadSoListener$1;
        c cVar2 = new c();
        this.innerEventListener = cVar2;
        FLog fLog = FLog.INSTANCE;
        fLog.i("FilamentNativeApp", "init , " + this);
        this.loadSoSpan = ZPlanSpanFactory.INSTANCE.startSpan("load_so", cVar);
        this.startUpTrack.d(0);
        dl0.d dVar = (dl0.d) fl0.a.f399763a.a(dl0.d.class);
        if (dVar == null) {
            fLog.e("FilamentNativeApp", "loadSoProxy is null");
            atomicInteger.set(2);
        }
        if (dVar != null) {
            dVar.a(new WeakReference<>(filamentNativeApp$loadSoListener$1));
        }
        t0().addListener("onFilamentRenderFail", cVar2);
        t0().addListener("onAvatarInfoReady", this.startUpTrack);
        t0().addListener("onBootResourceReady", this.startUpTrack);
        t0().addListener("onAvatarResourceReady", this.startUpTrack);
        t0().addListener("onAllResourceReady", this.startUpTrack);
        t0().addListener("onAnimationResourceReady", this.startUpTrack);
        t0().addListener("onIndirectLightResourceReady", this.startUpTrack);
        t0().addListener("onCostumeChange", this.startUpTrack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FilamentNativeApp$vSyncListener$2.a A0() {
        return (FilamentNativeApp$vSyncListener$2.a) this.vSyncListener.getValue();
    }

    private final VSyncScheduler B0() {
        return (VSyncScheduler) this.vSyncScheduler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler C0() {
        return (Handler) this.viewerHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E0(int errorCode, String errorMessage) {
        switch (errorCode) {
            case 201002:
            case 201022:
            case 201023:
            case 301002:
                if (FilamentFeatureUtil.f106409g.J()) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FilamentNativeApp$handleRenderFail$1(errorCode, errorMessage, null), 3, null);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F0(long totalTime, long frameTime) {
        com.tencent.filament.zplan.business.api.a aVar;
        boolean z16;
        Boolean bool;
        boolean z17;
        if (this.attached.get() && this.loadResource.get() && this.appStatus.get() == 1) {
            double d16 = frameTime / 1000000000;
            IBusinessScene iBusinessScene = this.scene;
            if (iBusinessScene != null) {
                aVar = iBusinessScene.animate(d16, this.zplanSpanContext);
            } else {
                aVar = null;
            }
            FilamentViewerV2 filamentViewerV2 = this.viewer;
            if (filamentViewerV2 != null) {
                filamentViewerV2.kawaiiPhysicsUpdate(d16);
            }
            IBusinessScene iBusinessScene2 = this.scene;
            if (iBusinessScene2 != null && iBusinessScene2.getCanRender()) {
                if (!this.needFirstFramePng.get() && this.hasRecordFrameCallback.get() && !this.hasMonitorRecordEnd.get() && r0()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    if (this.gamePerformanceMonitor == null) {
                        this.gamePerformanceMonitor = new GamePerformanceMonitor(this.fps);
                    }
                    GamePerformanceMonitor gamePerformanceMonitor = this.gamePerformanceMonitor;
                    if (gamePerformanceMonitor != null) {
                        gamePerformanceMonitor.startFrame();
                    }
                }
                IBusinessScene iBusinessScene3 = this.scene;
                if (iBusinessScene3 != null) {
                    bool = Boolean.valueOf(iBusinessScene3.getNeedRecordFirstFrame());
                } else {
                    bool = null;
                }
                if (this.needFirstFramePng.get() && !Intrinsics.areEqual(bool, Boolean.FALSE)) {
                    FilamentViewerV2 filamentViewerV22 = this.viewer;
                    if (filamentViewerV22 != null) {
                        z17 = filamentViewerV22.render(true, this.zplanSpanContext);
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        this.needFirstFramePng.set(false);
                    }
                } else {
                    FilamentViewerV2 filamentViewerV23 = this.viewer;
                    if (filamentViewerV23 != null) {
                        FilamentViewerV2.render$default(filamentViewerV23, false, null, 2, null);
                    }
                }
                if (Intrinsics.areEqual(bool, Boolean.FALSE) && this.firstFrameFlag) {
                    this.recordFrameListener.a(new byte[0], 0, 0);
                    this.firstFrameFlag = false;
                }
                if (aVar != null) {
                    aVar.d();
                }
                if (z16) {
                    GamePerformanceMonitor gamePerformanceMonitor2 = this.gamePerformanceMonitor;
                    if (gamePerformanceMonitor2 != null) {
                        gamePerformanceMonitor2.endFrame();
                    }
                    I0();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G0(final String from, boolean forceEvaluate, final Function0<Unit> task) {
        p0(new Runnable() { // from class: com.tencent.filament.zplan.render.impl.FilamentNativeApp$postToViewerThread$1
            @Override // java.lang.Runnable
            public final void run() {
                FilamentNativeApp.this.q0(from, task);
            }
        });
        if (!forceEvaluate && this.appStatus.get() != 1) {
            FLog.INSTANCE.e("FilamentNativeApp", "evaluateViewerWaitList return, forceExecutor: " + forceEvaluate + ", appStatus: " + this.appStatus.get());
            return;
        }
        s0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void H0(FilamentNativeApp filamentNativeApp, String str, boolean z16, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        filamentNativeApp.G0(str, z16, function0);
    }

    private final void I0() {
        int i3;
        Double d16;
        Double d17;
        Double d18;
        Integer num;
        Integer num2;
        Integer num3;
        Double d19;
        Double d26;
        Double d27;
        Integer num4;
        Integer num5;
        Integer num6;
        Double d28;
        Map<String, String> mutableMapOf;
        GamePerformanceMonitor gamePerformanceMonitor = this.gamePerformanceMonitor;
        if (gamePerformanceMonitor == null) {
            return;
        }
        if (gamePerformanceMonitor != null) {
            i3 = gamePerformanceMonitor.getFrameCount();
        } else {
            i3 = 0;
        }
        if (i3 != z0()) {
            return;
        }
        this.hasMonitorRecordEnd.compareAndSet(false, true);
        FLog fLog = FLog.INSTANCE;
        fLog.e("FilamentNativeApp", "--------------------------------------------------------------------------------");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Average frame rate: ");
        GamePerformanceMonitor gamePerformanceMonitor2 = this.gamePerformanceMonitor;
        SceneType sceneType = null;
        if (gamePerformanceMonitor2 != null) {
            d16 = Double.valueOf(gamePerformanceMonitor2.getAverageFrameRate());
        } else {
            d16 = null;
        }
        sb5.append(d16);
        sb5.append(" FPS.");
        fLog.e("FilamentNativeApp", sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append("Average frame interval: ");
        GamePerformanceMonitor gamePerformanceMonitor3 = this.gamePerformanceMonitor;
        if (gamePerformanceMonitor3 != null) {
            d17 = Double.valueOf(gamePerformanceMonitor3.getAverageFrameInterval());
        } else {
            d17 = null;
        }
        sb6.append(d17);
        sb6.append(" ms.");
        fLog.e("FilamentNativeApp", sb6.toString());
        StringBuilder sb7 = new StringBuilder();
        sb7.append("Stutter rate: ");
        GamePerformanceMonitor gamePerformanceMonitor4 = this.gamePerformanceMonitor;
        if (gamePerformanceMonitor4 != null) {
            d18 = Double.valueOf(gamePerformanceMonitor4.getStutterRate());
        } else {
            d18 = null;
        }
        sb7.append(d18);
        sb7.append('.');
        fLog.e("FilamentNativeApp", sb7.toString());
        StringBuilder sb8 = new StringBuilder();
        sb8.append("Jank count:: ");
        GamePerformanceMonitor gamePerformanceMonitor5 = this.gamePerformanceMonitor;
        if (gamePerformanceMonitor5 != null) {
            num = Integer.valueOf(gamePerformanceMonitor5.getJankCount());
        } else {
            num = null;
        }
        sb8.append(num);
        sb8.append(" .");
        fLog.e("FilamentNativeApp", sb8.toString());
        StringBuilder sb9 = new StringBuilder();
        sb9.append("perfDog Jank count: ");
        GamePerformanceMonitor gamePerformanceMonitor6 = this.gamePerformanceMonitor;
        if (gamePerformanceMonitor6 != null) {
            num2 = Integer.valueOf(gamePerformanceMonitor6.getPerfDogJankCount());
        } else {
            num2 = null;
        }
        sb9.append(num2);
        sb9.append('.');
        fLog.e("FilamentNativeApp", sb9.toString());
        StringBuilder sb10 = new StringBuilder();
        sb10.append("perfDog Big jank count: ");
        GamePerformanceMonitor gamePerformanceMonitor7 = this.gamePerformanceMonitor;
        if (gamePerformanceMonitor7 != null) {
            num3 = Integer.valueOf(gamePerformanceMonitor7.getPerfDogBigJankCount());
        } else {
            num3 = null;
        }
        sb10.append(num3);
        sb10.append('.');
        fLog.e("FilamentNativeApp", sb10.toString());
        StringBuilder sb11 = new StringBuilder();
        sb11.append("perfDog Stutter ratee: ");
        GamePerformanceMonitor gamePerformanceMonitor8 = this.gamePerformanceMonitor;
        if (gamePerformanceMonitor8 != null) {
            d19 = Double.valueOf(gamePerformanceMonitor8.getPerfDogStutterRate());
        } else {
            d19 = null;
        }
        sb11.append(d19);
        sb11.append('.');
        fLog.e("FilamentNativeApp", sb11.toString());
        fLog.e("FilamentNativeApp", "--------------------------------------------------------------------------------");
        GamePerformanceMonitor gamePerformanceMonitor9 = this.gamePerformanceMonitor;
        if (gamePerformanceMonitor9 != null) {
            gamePerformanceMonitor9.reset();
        }
        GamePerformanceMonitor gamePerformanceMonitor10 = this.gamePerformanceMonitor;
        if (gamePerformanceMonitor10 != null) {
            gamePerformanceMonitor10.destory();
        }
        this.gamePerformanceMonitor = null;
        Pair[] pairArr = new Pair[9];
        pairArr[0] = TuplesKt.to("averageFrameRate", String.valueOf((Object) null));
        GamePerformanceMonitor gamePerformanceMonitor11 = this.gamePerformanceMonitor;
        if (gamePerformanceMonitor11 != null) {
            d26 = Double.valueOf(gamePerformanceMonitor11.getAverageFrameInterval());
        } else {
            d26 = null;
        }
        pairArr[1] = TuplesKt.to("averageFrameInterval", String.valueOf(d26));
        GamePerformanceMonitor gamePerformanceMonitor12 = this.gamePerformanceMonitor;
        if (gamePerformanceMonitor12 != null) {
            d27 = Double.valueOf(gamePerformanceMonitor12.getStutterRate());
        } else {
            d27 = null;
        }
        pairArr[2] = TuplesKt.to("stutterRate", String.valueOf(d27));
        GamePerformanceMonitor gamePerformanceMonitor13 = this.gamePerformanceMonitor;
        if (gamePerformanceMonitor13 != null) {
            num4 = Integer.valueOf(gamePerformanceMonitor13.getJankCount());
        } else {
            num4 = null;
        }
        pairArr[3] = TuplesKt.to("jankCount", String.valueOf(num4));
        GamePerformanceMonitor gamePerformanceMonitor14 = this.gamePerformanceMonitor;
        if (gamePerformanceMonitor14 != null) {
            num5 = Integer.valueOf(gamePerformanceMonitor14.getPerfDogJankCount());
        } else {
            num5 = null;
        }
        pairArr[4] = TuplesKt.to("perfDogJankCount", String.valueOf(num5));
        GamePerformanceMonitor gamePerformanceMonitor15 = this.gamePerformanceMonitor;
        if (gamePerformanceMonitor15 != null) {
            num6 = Integer.valueOf(gamePerformanceMonitor15.getPerfDogBigJankCount());
        } else {
            num6 = null;
        }
        pairArr[5] = TuplesKt.to("perfDogBigJankCount", String.valueOf(num6));
        GamePerformanceMonitor gamePerformanceMonitor16 = this.gamePerformanceMonitor;
        if (gamePerformanceMonitor16 != null) {
            d28 = Double.valueOf(gamePerformanceMonitor16.getPerfDogStutterRate());
        } else {
            d28 = null;
        }
        pairArr[6] = TuplesKt.to("perfDogStutterRate", String.valueOf(d28));
        pairArr[7] = TuplesKt.to("hasStopped", String.valueOf(this.hasPaused.get()));
        IBusinessScene iBusinessScene = this.scene;
        if (iBusinessScene != null) {
            sceneType = iBusinessScene.getSceneType();
        }
        pairArr[8] = TuplesKt.to("scene", String.valueOf(sceneType));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        dl0.h hVar = (dl0.h) fl0.a.f399763a.a(dl0.h.class);
        if (hVar != null) {
            hVar.a("zplanlite#nativeapp#runtime#performance", mutableMapOf);
        }
    }

    private final void p0(Runnable task) {
        synchronized (this.viewerWaitList) {
            this.viewerWaitList.add(task);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(final String funName, final Function0<Unit> task) {
        C0().post(new Runnable() { // from class: com.tencent.filament.zplan.render.impl.FilamentNativeApp$doTaskOnViewerThread$1
            @Override // java.lang.Runnable
            public final void run() {
                Map map;
                al0.a aVar = new al0.a(0L, 0L, false, 0, null, 31, null);
                FLog fLog = FLog.INSTANCE;
                fLog.i("FilamentNativeApp", "before doTask: " + funName + ", " + task.hashCode() + ", " + FilamentNativeApp.this);
                Function0 function0 = task;
                a.Companion companion = al0.a.INSTANCE;
                aVar.l(companion.b());
                function0.invoke();
                aVar.i(companion.b());
                fLog.i("FilamentNativeApp", "after doTask: " + funName + ", " + task.hashCode() + ", " + aVar + ", " + FilamentNativeApp.this);
                map = FilamentNativeApp.this.startupSteps;
                map.put(funName, aVar);
            }
        });
    }

    private final boolean r0() {
        SceneType sceneType;
        IBusinessScene iBusinessScene = this.scene;
        if (iBusinessScene == null || (sceneType = iBusinessScene.getSceneType()) == null || com.tencent.filament.zplan.render.impl.b.f105911b[sceneType.ordinal()] != 1) {
            return false;
        }
        return w0().getPortalSceneMonitorConfig().getEnablePortal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FilamentEventDispatcher t0() {
        return (FilamentEventDispatcher) this.eventDispatcher.getValue();
    }

    private final com.tencent.filament.zplan.business.api.b u0() {
        return (com.tencent.filament.zplan.business.api.b) this.executor.getValue();
    }

    private final Map<String, SceneConfig> v0() {
        return (Map) this.filamentGpuLevelConfig.getValue();
    }

    private final FilamentSceneMonitorConfig w0() {
        return (FilamentSceneMonitorConfig) this.filamentSceneMonitorConfig.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GpuOptimizeOptions y0(SceneType sceneType, int level) {
        GpuOptimizeOptions none;
        GpuOptimizeOptions portal;
        GpuOptimizeOptions drawer;
        GpuOptimizeOptions dynamic;
        GpuOptimizeOptions profile_card;
        GpuOptimizeOptions aigc_preview;
        GpuOptimizeOptions friend_profile_card;
        GpuOptimizeOptions friends_dress_up;
        GpuOptimizeOptions my_name_by;
        GpuOptimizeOptions guest_name_by;
        String str = "level_" + level;
        if (!v0().containsKey(str)) {
            return new GpuOptimizeOptions(false, false, false, 0.0f, 15, null);
        }
        SceneConfig sceneConfig = v0().get(str);
        switch (com.tencent.filament.zplan.render.impl.b.f105910a[sceneType.ordinal()]) {
            case 1:
                if (sceneConfig == null || (none = sceneConfig.getNone()) == null) {
                    return new GpuOptimizeOptions(false, false, false, 0.0f, 15, null);
                }
                return none;
            case 2:
                if (sceneConfig == null || (portal = sceneConfig.getPortal()) == null) {
                    return new GpuOptimizeOptions(false, false, false, 0.0f, 15, null);
                }
                return portal;
            case 3:
                if (sceneConfig == null || (drawer = sceneConfig.getDrawer()) == null) {
                    return new GpuOptimizeOptions(false, false, false, 0.0f, 15, null);
                }
                return drawer;
            case 4:
                if (sceneConfig == null || (dynamic = sceneConfig.getDynamic()) == null) {
                    return new GpuOptimizeOptions(false, false, false, 0.0f, 15, null);
                }
                return dynamic;
            case 5:
                if (sceneConfig == null || (profile_card = sceneConfig.getProfile_card()) == null) {
                    return new GpuOptimizeOptions(false, false, false, 0.0f, 15, null);
                }
                return profile_card;
            case 6:
                if (sceneConfig == null || (aigc_preview = sceneConfig.getAigc_preview()) == null) {
                    return new GpuOptimizeOptions(false, false, false, 0.0f, 15, null);
                }
                return aigc_preview;
            case 7:
                if (sceneConfig == null || (friend_profile_card = sceneConfig.getFriend_profile_card()) == null) {
                    return new GpuOptimizeOptions(false, false, false, 0.0f, 15, null);
                }
                return friend_profile_card;
            case 8:
                if (sceneConfig == null || (friends_dress_up = sceneConfig.getFriends_dress_up()) == null) {
                    return new GpuOptimizeOptions(false, false, false, 0.0f, 15, null);
                }
                return friends_dress_up;
            case 9:
                if (sceneConfig == null || (my_name_by = sceneConfig.getMy_name_by()) == null) {
                    return new GpuOptimizeOptions(false, false, false, 0.0f, 15, null);
                }
                return my_name_by;
            case 10:
                if (sceneConfig == null || (guest_name_by = sceneConfig.getGuest_name_by()) == null) {
                    return new GpuOptimizeOptions(false, false, false, 0.0f, 15, null);
                }
                return guest_name_by;
            default:
                return new GpuOptimizeOptions(false, false, false, 0.0f, 15, null);
        }
    }

    private final int z0() {
        SceneType sceneType;
        IBusinessScene iBusinessScene = this.scene;
        if (iBusinessScene == null || (sceneType = iBusinessScene.getSceneType()) == null || com.tencent.filament.zplan.render.impl.b.f105912c[sceneType.ordinal()] != 1) {
            return 0;
        }
        return w0().getPortalSceneMonitorConfig().getRecordFrameCount();
    }

    @Override // wk0.a
    public int A() {
        return hashCode();
    }

    @Nullable
    /* renamed from: D0, reason: from getter */
    public final com.tencent.zplan.zplantracing.c getZplanSpanContext() {
        return this.zplanSpanContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object J0(Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new FilamentNativeApp$updateEngineLevelConfig$2(this, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (withContext == coroutine_suspended) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    @Override // wk0.b
    public void a(@Nullable uk0.c listener) {
        FLog.INSTANCE.i("FilamentNativeApp", "setFilamentRenderListener listener: " + listener + ", " + this);
        this.filamentRenderListener = listener;
    }

    @Override // vk0.c
    public void c(@NotNull String type, @NotNull e listener) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(listener, "listener");
        FLog.INSTANCE.i("FilamentNativeApp", "addEventListener type: " + type + ", listener: " + listener + ", " + this);
        t0().addListener(type, listener);
    }

    @Override // wk0.b
    @Nullable
    public IBusinessScene getScene() {
        return this.scene;
    }

    @Override // vk0.b
    public void k(@NotNull String event, @Nullable String data, @Nullable com.tencent.zplan.zplantracing.c zplanSpanContext) {
        Iterable<String> asIterable;
        Intrinsics.checkNotNullParameter(event, "event");
        int hashCode = event.hashCode();
        if (hashCode != -313972203) {
            if (hashCode == 92828522 && event.equals("onDrawFrame")) {
                q0("onDrawFrame", new Function0<Unit>() { // from class: com.tencent.filament.zplan.render.impl.FilamentNativeApp$dispatch$1
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
                        FilamentNativeApp.this.F0(0L, System.nanoTime());
                    }
                });
                return;
            }
        } else if (event.equals("preCompileShader")) {
            if (data == null) {
                FLog.INSTANCE.e("FilamentNativeApp", "preCompileShader need data");
                return;
            }
            JSONObject jSONObject = new JSONObject(data);
            FilamentViewerV2 filamentViewerV2 = this.viewer;
            if (filamentViewerV2 != null) {
                asIterable = SequencesKt___SequencesKt.asIterable(JsonUtilKt.a(JsonUtilKt.b(jSONObject, "paths", new JSONArray())));
                filamentViewerV2.preCompiledShader(asIterable);
                return;
            }
            return;
        }
        IBusinessScene iBusinessScene = this.scene;
        if (iBusinessScene != null) {
            iBusinessScene.processDispatchEvent(event, data, zplanSpanContext);
        }
    }

    @Override // wk0.b
    public void onDestroy() {
        long j3;
        FLog.INSTANCE.i("FilamentNativeApp", "onDestroy , " + this + ", " + Thread.currentThread());
        if (!K) {
            this.appStatus.set(3);
        }
        B0().p();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new FilamentNativeApp$onDestroy$1(this, null), 3, null);
        t0().removeAllListener();
        Handler C0 = C0();
        Runnable runnable = new Runnable() { // from class: com.tencent.filament.zplan.render.impl.FilamentNativeApp$onDestroy$2
            @Override // java.lang.Runnable
            public final void run() {
                boolean z16;
                GamePerformanceMonitor gamePerformanceMonitor;
                FilamentViewerV2 filamentViewerV2;
                HandlerThread handlerThread;
                SurfaceTexture surfaceTexture;
                FilamentTextureView filamentTextureView;
                z16 = FilamentNativeApp.K;
                if (z16) {
                    FilamentNativeApp.this.appStatus.set(3);
                }
                gamePerformanceMonitor = FilamentNativeApp.this.gamePerformanceMonitor;
                if (gamePerformanceMonitor != null) {
                    gamePerformanceMonitor.destory();
                }
                FilamentNativeApp.this.gamePerformanceMonitor = null;
                FLog fLog = FLog.INSTANCE;
                fLog.i("FilamentNativeApp", "before doTask: destroy, " + FilamentNativeApp.this);
                filamentViewerV2 = FilamentNativeApp.this.viewer;
                if (filamentViewerV2 != null) {
                    filamentViewerV2.destroy();
                }
                FilamentNativeApp.this.viewer = null;
                fLog.i("FilamentNativeApp", "after doTask: destroy, " + FilamentNativeApp.this);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("viewerHandlerThread quitSafely, ");
                sb5.append(FilamentNativeApp.this);
                sb5.append(", ");
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                sb5.append(currentThread.getId());
                sb5.append(", ");
                Thread currentThread2 = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread2, "Thread.currentThread()");
                sb5.append(currentThread2.getName());
                fLog.i("FilamentNativeApp", sb5.toString());
                handlerThread = FilamentNativeApp.this.viewerHandlerThread;
                handlerThread.quitSafely();
                surfaceTexture = FilamentNativeApp.this.surfaceTextureTmp;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                }
                FilamentNativeApp.this.surfaceTextureTmp = null;
                filamentTextureView = FilamentNativeApp.this.filamentView;
                if (filamentTextureView != null) {
                    filamentTextureView.a();
                }
                FilamentNativeApp.this.filamentView = null;
            }
        };
        k kVar = (k) fl0.a.f399763a.a(k.class);
        if (kVar != null) {
            j3 = kVar.d("zplan_filament_destroy_delay_time", 100);
        } else {
            j3 = 0;
        }
        C0.postDelayed(runnable, j3);
        this.filamentTouchController = null;
    }

    @Override // wk0.b
    public void onPause() {
        FLog.INSTANCE.i("FilamentNativeApp", "onPause , " + this + ", " + Thread.currentThread());
        this.startUpTrack.f();
        B0().p();
        this.hasPaused.compareAndSet(false, true);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new FilamentNativeApp$onPause$1(this, null), 3, null);
    }

    @Override // wk0.b
    public void onResume() {
        FLog.INSTANCE.i("FilamentNativeApp", "onResume , " + this + ", " + Thread.currentThread());
        B0().o();
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new FilamentNativeApp$onResume$1(this, null), 3, null);
    }

    @Override // com.tencent.filament.zplan.view.controller.FilamentTouchController.b
    public void q(@NotNull TouchEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        b.a.a(this, "onTouchEvent", new Gson().toJson(event), null, 4, null);
    }

    @Override // vk0.c
    public void removeEventListener(@NotNull String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        FLog.INSTANCE.i("FilamentNativeApp", "removeEventListener type: " + type + ", " + this);
        t0().removeListener(type);
    }

    public final void s0() {
        synchronized (this.viewerWaitList) {
            Iterator<Runnable> it = this.viewerWaitList.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
            this.viewerWaitList.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // vk0.c
    public void t(@NotNull String type, @NotNull e listener) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(listener, "listener");
        FLog.INSTANCE.i("FilamentNativeApp", "removeEventListener type: " + type + ", listener: " + listener + ", " + this);
        t0().removeListener(type, listener);
    }

    /* renamed from: x0, reason: from getter */
    public final int getFps() {
        return this.fps;
    }

    @Override // wk0.a
    public int y(@NotNull String entry, @NotNull IBusinessScene businessScene) {
        com.tencent.zplan.zplantracing.b startSpan;
        CoroutineScope CoroutineScope;
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(businessScene, "businessScene");
        FLog.INSTANCE.i("FilamentNativeApp", "startWithEntry, businessScene: " + businessScene + ", appStatus: " + this.appStatus.get() + ", " + this);
        com.tencent.zplan.zplantracing.c cVar = this.zplanSpanContext;
        if (cVar == null) {
            startSpan = ZPlanSpanFactory.INSTANCE.startRootSpan("startWithEntry");
        } else {
            startSpan = ZPlanSpanFactory.INSTANCE.startSpan("startWithEntry", cVar);
        }
        if (startSpan != null) {
            startSpan.e("entry", entry);
            Unit unit = Unit.INSTANCE;
        } else {
            startSpan = null;
        }
        this.startWithEntrySpan = startSpan;
        this.startUpTrack.i(INSTANCE.b(businessScene), businessScene.getSceneType());
        this.scene = businessScene;
        H0(this, "setViewer", false, new Function0<Unit>() { // from class: com.tencent.filament.zplan.render.impl.FilamentNativeApp$startWithEntry$2
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
                IBusinessScene iBusinessScene;
                FilamentViewerV2 filamentViewerV2;
                iBusinessScene = FilamentNativeApp.this.scene;
                if (iBusinessScene != null) {
                    filamentViewerV2 = FilamentNativeApp.this.viewer;
                    iBusinessScene.setViewer(filamentViewerV2);
                }
            }
        }, 2, null);
        IBusinessScene iBusinessScene = this.scene;
        if (iBusinessScene != null) {
            iBusinessScene.setEventDispatcher(t0());
        }
        IBusinessScene iBusinessScene2 = this.scene;
        if (iBusinessScene2 != null) {
            iBusinessScene2.setExecuteFunk(u0());
        }
        IBusinessScene iBusinessScene3 = this.scene;
        if (iBusinessScene3 != null) {
            iBusinessScene3.setReloadAvatarListener(new d());
        }
        IBusinessScene iBusinessScene4 = this.scene;
        if (iBusinessScene4 != null && iBusinessScene4.getMEnableFilamentPreLaunch()) {
            CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        } else {
            CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new FilamentNativeApp$startWithEntry$4(this, null), 3, null);
        return this.appStatus.get();
    }

    @Override // wk0.b
    @NotNull
    public View z(@NotNull final Context context, @Nullable Boolean enableTouch) {
        ViewParent parent;
        Intrinsics.checkNotNullParameter(context, "context");
        FLog.INSTANCE.i("FilamentNativeApp", "getView context: " + context + ", enableTouch: " + enableTouch + ", " + this);
        FilamentTextureView filamentTextureView = this.filamentView;
        if (filamentTextureView == null) {
            FilamentTextureView filamentTextureView2 = new FilamentTextureView(new FilamentTextureView.FilamentTextureParam(context, false, enableTouch, 2, null));
            SurfaceTexture surfaceTexture = new SurfaceTexture(0);
            surfaceTexture.detachFromGLContext();
            Unit unit = Unit.INSTANCE;
            this.surfaceTextureTmp = surfaceTexture;
            filamentTextureView2.setFilamentRenderListener(new uk0.c() { // from class: com.tencent.filament.zplan.render.impl.FilamentNativeApp$getView$$inlined$apply$lambda$1
                @Override // uk0.c
                public void a(@NotNull Surface surface, final int width, final int height) {
                    uk0.c cVar;
                    Intrinsics.checkNotNullParameter(surface, "surface");
                    c.a.a(this, surface, width, height);
                    FilamentNativeApp.H0(FilamentNativeApp.this, "onSurfaceChanged", false, new Function0<Unit>() { // from class: com.tencent.filament.zplan.render.impl.FilamentNativeApp$getView$$inlined$apply$lambda$1.2
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
                            SurfaceTexture surfaceTexture2;
                            FilamentViewerV2 filamentViewerV2;
                            FilamentViewerV2 filamentViewerV22;
                            AtomicBoolean atomicBoolean;
                            surfaceTexture2 = FilamentNativeApp.this.surfaceTextureTmp;
                            if (surfaceTexture2 != null) {
                                filamentViewerV2 = FilamentNativeApp.this.viewer;
                                if (filamentViewerV2 != null) {
                                    filamentViewerV2.attach(new Surface(surfaceTexture2), surfaceTexture2, width, height);
                                }
                                filamentViewerV22 = FilamentNativeApp.this.viewer;
                                if (filamentViewerV22 != null) {
                                    filamentViewerV22.setViewPort(width, height);
                                }
                                atomicBoolean = FilamentNativeApp.this.attached;
                                atomicBoolean.set(true);
                                return;
                            }
                            FLog.INSTANCE.e("FilamentNativeApp", "onSurfaceChanged surfaceTexture has release, return.");
                        }
                    }, 2, null);
                    cVar = FilamentNativeApp.this.filamentRenderListener;
                    if (cVar != null) {
                        cVar.a(surface, width, height);
                    }
                }

                /* JADX WARN: Code restructure failed: missing block: B:3:0x0011, code lost:
                
                    r1 = r8.f105855a.filamentView;
                 */
                @Override // uk0.c
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void b(@NotNull Surface surface, final int width, final int height) {
                    SurfaceTexture surfaceTexture2;
                    uk0.c cVar;
                    FilamentTextureView filamentTextureView3;
                    Intrinsics.checkNotNullParameter(surface, "surface");
                    c.a.b(this, surface, width, height);
                    surfaceTexture2 = FilamentNativeApp.this.surfaceTextureTmp;
                    if (surfaceTexture2 != null && filamentTextureView3 != null) {
                        filamentTextureView3.setSurfaceTexture(surfaceTexture2);
                    }
                    FilamentNativeApp.H0(FilamentNativeApp.this, "onSurfaceCreate", false, new Function0<Unit>() { // from class: com.tencent.filament.zplan.render.impl.FilamentNativeApp$getView$$inlined$apply$lambda$1.1
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
                            SurfaceTexture surfaceTexture3;
                            FilamentViewerV2 filamentViewerV2;
                            FilamentViewerV2 filamentViewerV22;
                            AtomicBoolean atomicBoolean;
                            surfaceTexture3 = FilamentNativeApp.this.surfaceTextureTmp;
                            if (surfaceTexture3 != null) {
                                filamentViewerV2 = FilamentNativeApp.this.viewer;
                                if (filamentViewerV2 != null) {
                                    filamentViewerV2.attach(new Surface(surfaceTexture3), surfaceTexture3, width, height);
                                }
                                filamentViewerV22 = FilamentNativeApp.this.viewer;
                                if (filamentViewerV22 != null) {
                                    filamentViewerV22.setViewPort(width, height);
                                }
                                atomicBoolean = FilamentNativeApp.this.attached;
                                atomicBoolean.set(true);
                                return;
                            }
                            FLog.INSTANCE.e("FilamentNativeApp", "onSurfaceCreate surfaceTexture has release, return.");
                        }
                    }, 2, null);
                    cVar = FilamentNativeApp.this.filamentRenderListener;
                    if (cVar != null) {
                        cVar.b(surface, width, height);
                    }
                }

                @Override // uk0.c
                public void onSurfaceDestroyed(@NotNull Surface surface) {
                    uk0.c cVar;
                    Intrinsics.checkNotNullParameter(surface, "surface");
                    c.a.c(this, surface);
                    FLog fLog = FLog.INSTANCE;
                    fLog.i("FilamentNativeApp", "onSurfaceDestroyed start");
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    FilamentNativeApp.this.G0("onSurfaceDestroyed&flushAndWait", true, new Function0<Unit>() { // from class: com.tencent.filament.zplan.render.impl.FilamentNativeApp$getView$$inlined$apply$lambda$1.3
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
                            FilamentViewerV2 filamentViewerV2;
                            atomicBoolean = FilamentNativeApp.this.attached;
                            atomicBoolean.set(false);
                            filamentViewerV2 = FilamentNativeApp.this.viewer;
                            if (filamentViewerV2 != null) {
                                filamentViewerV2.flushAndWait();
                            }
                            countDownLatch.countDown();
                        }
                    });
                    if (FilamentNativeApp.this.appStatus.get() == 1) {
                        countDownLatch.await(FilamentFeatureUtil.f106409g.C().getSurfaceDestroyTimeout(), TimeUnit.MILLISECONDS);
                    }
                    fLog.i("FilamentNativeApp", "onSurfaceDestroyed end");
                    cVar = FilamentNativeApp.this.filamentRenderListener;
                    if (cVar != null) {
                        cVar.onSurfaceDestroyed(surface);
                    }
                }
            });
            SurfaceTexture surfaceTexture2 = this.surfaceTextureTmp;
            Intrinsics.checkNotNull(surfaceTexture2);
            filamentTextureView2.setSurfaceTexture(surfaceTexture2);
            if (this.filamentTouchController == null) {
                this.filamentTouchController = new FilamentTouchController(context, this);
            }
            filamentTextureView2.setOnTouchListener(new b(context));
            this.filamentView = filamentTextureView2;
        } else {
            if (filamentTextureView != null && (parent = filamentTextureView.getParent()) != null) {
                ((ViewGroup) parent).removeView(this.filamentView);
            }
            FilamentTextureView filamentTextureView3 = this.filamentView;
            if (filamentTextureView3 != null) {
                filamentTextureView3.setTextureParam(new FilamentTextureView.FilamentTextureParam(context, false, enableTouch, 2, null));
            }
        }
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new FilamentNativeApp$getView$3(this, context, null), 3, null);
        FilamentTextureView filamentTextureView4 = this.filamentView;
        Intrinsics.checkNotNull(filamentTextureView4);
        return filamentTextureView4;
    }
}
