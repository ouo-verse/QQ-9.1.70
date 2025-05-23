package com.tencent.state.map.v2.filament;

import android.content.Context;
import android.view.TextureView;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.filament.zplan.app.api.IFilamentNativeAppV2305;
import com.tencent.filament.zplan.manager.FilamentRenderFactory;
import com.tencent.filament.zplan.scene.square.BootMapEvent;
import com.tencent.filament.zplan.scene.square.MoveViewportEvent;
import com.tencent.filament.zplan.scene.square.ObjectState;
import com.tencent.filament.zplan.scene.square.OnObjectAnimationLastFrameEvent;
import com.tencent.filament.zplan.scene.square.OnObjectStateChangedEvent;
import com.tencent.filament.zplan.scene.square.OnRecoveredFilamentRender;
import com.tencent.filament.zplan.scene.square.OnViewportChangedEvent;
import com.tencent.filament.zplan.scene.square.RemoveObjectEvent;
import com.tencent.filament.zplan.scene.square.SquareLoadObjectStatistics;
import com.tencent.filament.zplan.scene.square.SquareMapEvent;
import com.tencent.filament.zplan.scene.square.SquareRenderStatistics;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.state.map.v2.IMap;
import com.tencent.state.map.v2.IMapListener;
import com.tencent.state.map.v2.IMapObject;
import com.tencent.state.map.v2.MapError;
import com.tencent.state.map.v2.ObjectParams;
import com.tencent.state.map.v2.ObjectType;
import com.tencent.state.map.v2.Size;
import com.tencent.state.map.v2.ViewportInfo;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.avatar.filament.FilamentReportHelper;
import com.tencent.state.square.avatar.filament.LoadFilamentAssetsStatistics;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import com.tencent.zplan.zplantracing.b;
import com.tencent.zplan.zplantracing.c;
import dl0.d;
import dl0.k;
import fl0.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import org.aspectj.lang.JoinPoint;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00eb\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007*\u0001]\u0018\u0000 b2\u00020\u0001:\u0001bB\u0007\u00a2\u0006\u0004\b`\u0010aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002Jd\u0010\u001a\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2B\u0010\u0019\u001a>\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00040\u0011j\b\u0012\u0004\u0012\u00020\u0016`\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016JX\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"2F\u0010\u0019\u001aB\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0018H\u0016J\u0018\u0010'\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%H\u0016J\u0012\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00020(0*H\u0016J\"\u00101\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010.\u001a\u00020,2\u0006\u00100\u001a\u00020/H\u0016J\b\u00102\u001a\u00020,H\u0016J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00020\u00020*H\u0016J\u000e\u00104\u001a\u00020%2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u00107\u001a\u00020\u00042\u0006\u00106\u001a\u000205J\b\u00108\u001a\u0004\u0018\u00010\u0016J\u0016\u0010;\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010:\u001a\u000209J\u000e\u0010<\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010>\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010A\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010G\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR \u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020L0K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR(\u0010P\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040O0K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010NR&\u0010R\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002090Q0K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010NR\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020\u001e0S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010V\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010HR\u0016\u0010X\u001a\u00020W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010[\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010^\u001a\u00020]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_\u00a8\u0006c"}, d2 = {"Lcom/tencent/state/map/v2/filament/FilamentMap;", "Lcom/tencent/state/map/v2/IMap;", "", "id", "", "handleObjectAnimationEnd", "Lcom/tencent/filament/zplan/scene/square/OnObjectStateChangedEvent;", "evt", "handleObjectStateChanged", "Lcom/tencent/state/map/v2/filament/FilamentMapObjectStatistics;", "firstObjectStatistics", "reportFilamentFirstAvatarLoaded", "Landroid/content/Context;", "context", "Lcom/tencent/state/map/v2/Size;", "mapSize", "viewportSize", "Lkotlin/Function2;", "Lcom/tencent/state/map/v2/MapError;", "Lkotlin/ParameterName;", "name", NotificationCompat.CATEGORY_ERROR, "Landroid/view/TextureView;", "data", "Lcom/tencent/state/map/v2/MapCallback;", "callback", "boot", "pause", "resume", "destroy", "Lcom/tencent/state/map/v2/IMapListener;", "listener", "addMapListener", "removeMapListener", "Lcom/tencent/state/map/v2/ObjectParams;", "params", "addObject", "", "waitForAnimationEnd", "removeObject", "Lcom/tencent/state/map/v2/IMapObject;", "getObject", "", "getAllObjects", "Lcom/tencent/state/map/v2/ViewportInfo;", "from", "to", "", "duration", "moveViewport", "getViewport", "getCurrentObjectIds", "containsObject", "Lcom/tencent/filament/zplan/scene/square/SquareMapEvent;", "event", "dispatchToScene", "getEngineView", "Ljava/lang/Runnable;", "task", "addObjectAnimationEndTask", "cleanObjectAnimationEndTasks", "", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/lang/Object;", "Lcom/tencent/filament/zplan/app/api/IFilamentNativeAppV2305;", "app", "Lcom/tencent/filament/zplan/app/api/IFilamentNativeAppV2305;", "Lcom/tencent/zplan/zplantracing/b;", TtmlNode.TAG_SPAN, "Lcom/tencent/zplan/zplantracing/b;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isReady", "Ljava/util/concurrent/atomic/AtomicBoolean;", "currentViewport", "Lcom/tencent/state/map/v2/ViewportInfo;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/state/map/v2/filament/FilamentMapObject;", "mapObjects", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlinx/coroutines/Deferred;", "mapObjectsLoadDefers", "", "mapObjectsAnimationEndTasks", "", "mapListeners", "Ljava/util/Set;", "isFirstAvatarLoaded", "", "bootStartTime", "J", "Lcom/tencent/filament/zplan/scene/square/SquareRenderStatistics;", "sceneRenderStatistics", "Lcom/tencent/filament/zplan/scene/square/SquareRenderStatistics;", "com/tencent/state/map/v2/filament/FilamentMap$filamentListener$1", "filamentListener", "Lcom/tencent/state/map/v2/filament/FilamentMap$filamentListener$1;", "<init>", "()V", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class FilamentMap implements IMap {
    private static final List<String> FILAMENT_EVENTS;
    private static final String TAG = "FilamentMap";
    private IFilamentNativeAppV2305 app;
    private long bootStartTime;
    private SquareRenderStatistics sceneRenderStatistics;
    private final Object lock = new Object();
    private b span = ZPlanSpanFactory.INSTANCE.startRootSpan(TAG);
    private final AtomicBoolean isReady = new AtomicBoolean(false);
    private ViewportInfo currentViewport = new ViewportInfo(0.0f, null, 3, null);
    private final ConcurrentHashMap<String, FilamentMapObject> mapObjects = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Deferred<Unit>> mapObjectsLoadDefers = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, List<Runnable>> mapObjectsAnimationEndTasks = new ConcurrentHashMap<>();
    private final Set<IMapListener> mapListeners = new LinkedHashSet();
    private final AtomicBoolean isFirstAvatarLoaded = new AtomicBoolean(false);
    private FilamentMap$filamentListener$1 filamentListener = new sk0.b() { // from class: com.tencent.state.map.v2.filament.FilamentMap$filamentListener$1
        private final WeakReference<FilamentMap> mapRef;

        /* JADX INFO: Access modifiers changed from: package-private */
        {
            this.mapRef = new WeakReference<>(FilamentMap.this);
        }

        public final WeakReference<FilamentMap> getMapRef() {
            return this.mapRef;
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x004f, code lost:
        
            r8 = r8.mapListeners;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0073, code lost:
        
            r8 = r8.isReady;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0092, code lost:
        
            r8 = r8.mapListeners;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00fc, code lost:
        
            r9 = r9.mapListeners;
         */
        @Override // sk0.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleEvent(c spanContext, String type, String data) {
            OnObjectAnimationLastFrameEvent onObjectAnimationLastFrameEvent;
            FilamentMap filamentMap;
            OnViewportChangedEvent onViewportChangedEvent;
            Set set;
            OnObjectStateChangedEvent onObjectStateChangedEvent;
            FilamentMap filamentMap2;
            Set set2;
            AtomicBoolean atomicBoolean;
            Set set3;
            Intrinsics.checkNotNullParameter(type, "type");
            try {
                switch (type.hashCode()) {
                    case -1565730423:
                        if (type.equals("onFilamentRenderFail")) {
                            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "FilamentMap", "render fail " + data, null, 4, null);
                            return;
                        }
                        return;
                    case -1252242555:
                        if (!type.equals(OnObjectAnimationLastFrameEvent.NAME) || (onObjectAnimationLastFrameEvent = (OnObjectAnimationLastFrameEvent) SquareMapEvent.INSTANCE.a(data, OnObjectAnimationLastFrameEvent.class)) == null || (filamentMap = this.mapRef.get()) == null) {
                            return;
                        }
                        filamentMap.handleObjectAnimationEnd(onObjectAnimationLastFrameEvent.getId());
                        return;
                    case -948176043:
                        if (!type.equals(OnViewportChangedEvent.NAME) || (onViewportChangedEvent = (OnViewportChangedEvent) SquareMapEvent.INSTANCE.a(data, OnViewportChangedEvent.class)) == null) {
                            return;
                        }
                        FilamentMap.this.currentViewport = ModelsKt.toSquare(onViewportChangedEvent.getViewport());
                        FilamentMap filamentMap3 = this.mapRef.get();
                        if (filamentMap3 == null || set == null) {
                            return;
                        }
                        Iterator it = set.iterator();
                        while (it.hasNext()) {
                            ((IMapListener) it.next()).onViewportChanged(ModelsKt.toSquare(onViewportChangedEvent.getViewport()));
                        }
                        return;
                    case -776800736:
                        if (!type.equals(OnObjectStateChangedEvent.NAME) || (onObjectStateChangedEvent = (OnObjectStateChangedEvent) SquareMapEvent.INSTANCE.a(data, OnObjectStateChangedEvent.class)) == null || (filamentMap2 = this.mapRef.get()) == null) {
                            return;
                        }
                        filamentMap2.handleObjectStateChanged(onObjectStateChangedEvent);
                        return;
                    case -511306435:
                        if (!type.equals(OnRecoveredFilamentRender.NAME) || (r8 = this.mapRef.get()) == null || set2 == null) {
                            return;
                        }
                        Iterator it5 = set2.iterator();
                        while (it5.hasNext()) {
                            ((IMapListener) it5.next()).onEngineRenderRecovered();
                        }
                        return;
                    case 1621140201:
                        if (type.equals("onFirstFrameRenderEnd")) {
                            SquareBaseKt.getSquareLog().i("FilamentMap", "first render " + data);
                            SquareRenderStatistics squareRenderStatistics = (SquareRenderStatistics) SquareMapEvent.INSTANCE.a(data, SquareRenderStatistics.class);
                            if (squareRenderStatistics != null) {
                                FilamentMap.this.sceneRenderStatistics = squareRenderStatistics;
                            }
                            FilamentMap filamentMap4 = this.mapRef.get();
                            if (filamentMap4 != null && set3 != null) {
                                Iterator it6 = set3.iterator();
                                while (it6.hasNext()) {
                                    ((IMapListener) it6.next()).onMapReady();
                                }
                            }
                            FilamentMap filamentMap5 = this.mapRef.get();
                            if (filamentMap5 == null || atomicBoolean == null) {
                                return;
                            }
                            atomicBoolean.set(true);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } catch (Exception e16) {
                SquareBaseKt.getSquareLog().e("FilamentMap", "handleEvent error", e16);
            }
        }
    };

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ObjectType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ObjectType.AVATAR.ordinal()] = 1;
            iArr[ObjectType.IMAGE.ordinal()] = 2;
        }
    }

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"onFirstFrameRenderEnd", "onFilamentRenderFail", OnViewportChangedEvent.NAME, OnObjectStateChangedEvent.NAME, OnObjectAnimationLastFrameEvent.NAME, OnRecoveredFilamentRender.NAME});
        FILAMENT_EVENTS = listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleObjectAnimationEnd(String id5) {
        Runnable runnable;
        Object removeFirstOrNull;
        synchronized (this.lock) {
            while (true) {
                List<Runnable> list = this.mapObjectsAnimationEndTasks.get(id5);
                if ((list != null ? list.size() : 0) > 0) {
                    List<Runnable> list2 = this.mapObjectsAnimationEndTasks.get(id5);
                    if (list2 != null) {
                        removeFirstOrNull = CollectionsKt__MutableCollectionsKt.removeFirstOrNull(list2);
                        runnable = (Runnable) removeFirstOrNull;
                    } else {
                        runnable = null;
                    }
                    if (runnable != null) {
                        try {
                            runnable.run();
                        } catch (Exception e16) {
                            SquareBaseKt.getSquareLog().e(TAG, "run mapObjectsAnimationEndTasks(" + id5 + ") error", e16);
                        }
                    }
                } else {
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleObjectStateChanged(final OnObjectStateChangedEvent evt) {
        synchronized (this.lock) {
            FilamentMapObject filamentMapObject = this.mapObjects.get(evt.getId());
            if (filamentMapObject != null) {
                Intrinsics.checkNotNullExpressionValue(filamentMapObject, "mapObjects[evt.id] ?: return");
                filamentMapObject.setState(ModelsKt.toSquare(evt.getState()), evt.getLoadStatistics());
                try {
                    for (final IMapListener iMapListener : this.mapListeners) {
                        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.map.v2.filament.FilamentMap$handleObjectStateChanged$$inlined$synchronized$lambda$1
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
                                IMapListener.this.onObjectStateChanged(evt.getId(), ModelsKt.toSquare(evt.getState()));
                            }
                        });
                    }
                } catch (Exception e16) {
                    SquareBaseKt.getSquareLog().e(TAG, "onObjectStateChanged error", e16);
                }
                if (!this.isFirstAvatarLoaded.get() && evt.getState() == ObjectState.LOADED) {
                    this.isFirstAvatarLoaded.set(true);
                    reportFilamentFirstAvatarLoaded(filamentMapObject.getStatistics());
                }
                if (evt.getState() == ObjectState.REMOVED) {
                    this.mapObjects.remove(evt.getId());
                    this.mapObjectsLoadDefers.remove(evt.getId());
                    this.mapObjectsAnimationEndTasks.remove(evt.getId());
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final void reportFilamentFirstAvatarLoaded(FilamentMapObjectStatistics firstObjectStatistics) {
        Map<String, Object> mutableMapOf;
        long currentTimeMillis = System.currentTimeMillis() - this.bootStartTime;
        FilamentReportHelper filamentReportHelper = FilamentReportHelper.INSTANCE;
        boolean isFirstFilamentAfterInstall = filamentReportHelper.isFirstFilamentAfterInstall();
        FilamentMap$reportFilamentFirstAvatarLoaded$enumYesOrNo$1 filamentMap$reportFilamentFirstAvatarLoaded$enumYesOrNo$1 = new Function1<Boolean, String>() { // from class: com.tencent.state.map.v2.filament.FilamentMap$reportFilamentFirstAvatarLoaded$enumYesOrNo$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Boolean bool) {
                return Intrinsics.areEqual(bool, Boolean.TRUE) ? "yes" : "no";
            }
        };
        FilamentMap$reportFilamentFirstAvatarLoaded$valueInt$1 filamentMap$reportFilamentFirstAvatarLoaded$valueInt$1 = new Function1<Long, Integer>() { // from class: com.tencent.state.map.v2.filament.FilamentMap$reportFilamentFirstAvatarLoaded$valueInt$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Integer invoke(Long l3) {
                return Integer.valueOf(invoke2(l3));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2(Long l3) {
                if (l3 != null) {
                    return (int) l3.longValue();
                }
                return 0;
            }
        };
        Pair[] pairArr = new Pair[21];
        pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_IMP_STATE, 1);
        pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_FAIL_REASON, 0);
        pairArr[2] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_IMP_USE_TIMES, Long.valueOf(currentTimeMillis));
        pairArr[3] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_PG_ID, SquareReportConst.PageId.INSTANCE.checkNearby());
        pairArr[4] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_IS_INSTALL_FIRST_ACT, Integer.valueOf(isFirstFilamentAfterInstall ? 1 : 0));
        SquareRenderStatistics squareRenderStatistics = this.sceneRenderStatistics;
        pairArr[5] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_LOAD_SO_COST, filamentMap$reportFilamentFirstAvatarLoaded$valueInt$1.invoke((FilamentMap$reportFilamentFirstAvatarLoaded$valueInt$1) (squareRenderStatistics != null ? Long.valueOf(squareRenderStatistics.getLoadSoCost()) : null)));
        SquareRenderStatistics squareRenderStatistics2 = this.sceneRenderStatistics;
        pairArr[6] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_BOOT_COST, filamentMap$reportFilamentFirstAvatarLoaded$valueInt$1.invoke((FilamentMap$reportFilamentFirstAvatarLoaded$valueInt$1) (squareRenderStatistics2 != null ? Long.valueOf(squareRenderStatistics2.getBootTimeCost()) : null)));
        SquareRenderStatistics squareRenderStatistics3 = this.sceneRenderStatistics;
        pairArr[7] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_BOOT_USE_NET, filamentMap$reportFilamentFirstAvatarLoaded$enumYesOrNo$1.invoke((FilamentMap$reportFilamentFirstAvatarLoaded$enumYesOrNo$1) (squareRenderStatistics3 != null ? Boolean.valueOf(squareRenderStatistics3.getBootDownloadedFromNet()) : null)));
        SquareRenderStatistics squareRenderStatistics4 = this.sceneRenderStatistics;
        pairArr[8] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_ENGINE_FIRST_FRAME_COST, filamentMap$reportFilamentFirstAvatarLoaded$valueInt$1.invoke((FilamentMap$reportFilamentFirstAvatarLoaded$valueInt$1) (squareRenderStatistics4 != null ? Long.valueOf(squareRenderStatistics4.getFirstFrameCost()) : null)));
        LoadFilamentAssetsStatistics assetsLoadStatistics = firstObjectStatistics.getAssetsLoadStatistics();
        pairArr[9] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_LOAD_FASSET_COST, filamentMap$reportFilamentFirstAvatarLoaded$valueInt$1.invoke((FilamentMap$reportFilamentFirstAvatarLoaded$valueInt$1) (assetsLoadStatistics != null ? Long.valueOf(assetsLoadStatistics.getLoadMoodConfigCost()) : null)));
        LoadFilamentAssetsStatistics assetsLoadStatistics2 = firstObjectStatistics.getAssetsLoadStatistics();
        pairArr[10] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_LOAD_FASSET_USE_NET, filamentMap$reportFilamentFirstAvatarLoaded$enumYesOrNo$1.invoke((FilamentMap$reportFilamentFirstAvatarLoaded$enumYesOrNo$1) (assetsLoadStatistics2 != null ? Boolean.valueOf(assetsLoadStatistics2.getLoadMoodConfigFromNet()) : null)));
        LoadFilamentAssetsStatistics assetsLoadStatistics3 = firstObjectStatistics.getAssetsLoadStatistics();
        pairArr[11] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_LOAD_HOST_AVATAR_INFO_COST, filamentMap$reportFilamentFirstAvatarLoaded$valueInt$1.invoke((FilamentMap$reportFilamentFirstAvatarLoaded$valueInt$1) (assetsLoadStatistics3 != null ? Long.valueOf(assetsLoadStatistics3.getLoadHostAvatarInfoCost()) : null)));
        LoadFilamentAssetsStatistics assetsLoadStatistics4 = firstObjectStatistics.getAssetsLoadStatistics();
        pairArr[12] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_LOAD_GUEST_AVATAR_INFO_COST, filamentMap$reportFilamentFirstAvatarLoaded$valueInt$1.invoke((FilamentMap$reportFilamentFirstAvatarLoaded$valueInt$1) (assetsLoadStatistics4 != null ? Long.valueOf(assetsLoadStatistics4.getLoadGuestAvatarInfoCost()) : null)));
        SquareLoadObjectStatistics sceneLoadStatistics = firstObjectStatistics.getSceneLoadStatistics();
        pairArr[13] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_AVATAR_HAS_GUEST, filamentMap$reportFilamentFirstAvatarLoaded$enumYesOrNo$1.invoke((FilamentMap$reportFilamentFirstAvatarLoaded$enumYesOrNo$1) (sceneLoadStatistics != null ? Boolean.valueOf(sceneLoadStatistics.getHasGuest()) : null)));
        SquareLoadObjectStatistics sceneLoadStatistics2 = firstObjectStatistics.getSceneLoadStatistics();
        pairArr[14] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_AVATAR_HAS_EXTRA, filamentMap$reportFilamentFirstAvatarLoaded$enumYesOrNo$1.invoke((FilamentMap$reportFilamentFirstAvatarLoaded$enumYesOrNo$1) (sceneLoadStatistics2 != null ? Boolean.valueOf(sceneLoadStatistics2.getHasExtra()) : null)));
        SquareLoadObjectStatistics sceneLoadStatistics3 = firstObjectStatistics.getSceneLoadStatistics();
        pairArr[15] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_AVATAR_LOAD_COST, filamentMap$reportFilamentFirstAvatarLoaded$valueInt$1.invoke((FilamentMap$reportFilamentFirstAvatarLoaded$valueInt$1) (sceneLoadStatistics3 != null ? Long.valueOf(sceneLoadStatistics3.getLoadCost()) : null)));
        SquareLoadObjectStatistics sceneLoadStatistics4 = firstObjectStatistics.getSceneLoadStatistics();
        pairArr[16] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_AVATAR_LOAD_RES_COST, filamentMap$reportFilamentFirstAvatarLoaded$valueInt$1.invoke((FilamentMap$reportFilamentFirstAvatarLoaded$valueInt$1) (sceneLoadStatistics4 != null ? Long.valueOf(sceneLoadStatistics4.getLoadAvatarResourceCost()) : null)));
        SquareLoadObjectStatistics sceneLoadStatistics5 = firstObjectStatistics.getSceneLoadStatistics();
        pairArr[17] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_AVATAR_LOAD_RES_USE_NET, filamentMap$reportFilamentFirstAvatarLoaded$enumYesOrNo$1.invoke((FilamentMap$reportFilamentFirstAvatarLoaded$enumYesOrNo$1) (sceneLoadStatistics5 != null ? Boolean.valueOf(sceneLoadStatistics5.getLoadAvatarResourceFromNet()) : null)));
        SquareLoadObjectStatistics sceneLoadStatistics6 = firstObjectStatistics.getSceneLoadStatistics();
        pairArr[18] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_AVATAR_OBJ_CREATE_COST, filamentMap$reportFilamentFirstAvatarLoaded$valueInt$1.invoke((FilamentMap$reportFilamentFirstAvatarLoaded$valueInt$1) (sceneLoadStatistics6 != null ? Long.valueOf(sceneLoadStatistics6.getCreateObjectCost()) : null)));
        SquareLoadObjectStatistics sceneLoadStatistics7 = firstObjectStatistics.getSceneLoadStatistics();
        pairArr[19] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_AVATAR_OBJ_LOAD_ANIM_COST, filamentMap$reportFilamentFirstAvatarLoaded$valueInt$1.invoke((FilamentMap$reportFilamentFirstAvatarLoaded$valueInt$1) (sceneLoadStatistics7 != null ? Long.valueOf(sceneLoadStatistics7.getLoadAnimationCost()) : null)));
        SquareLoadObjectStatistics sceneLoadStatistics8 = firstObjectStatistics.getSceneLoadStatistics();
        pairArr[20] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_AVATAR_OBJ_APPLY_ANIM_COST, filamentMap$reportFilamentFirstAvatarLoaded$valueInt$1.invoke((FilamentMap$reportFilamentFirstAvatarLoaded$valueInt$1) (sceneLoadStatistics8 != null ? Long.valueOf(sceneLoadStatistics8.getApplyAnimationCost()) : null)));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        SquareBaseKt.getSquareReporter().reportEvent(SquareReportConst.CustomEventId.EVENT_ID_FILAMENT_FIRST_FRAME_IMP, mutableMapOf);
        SquareBaseKt.getSquareLog().i(TAG, "report filament map first avatar loaded after: " + currentTimeMillis + "ms, isFirst=" + (isFirstFilamentAfterInstall ? 1 : 0) + ", data=" + mutableMapOf);
        filamentReportHelper.setUsedFilamentAfterInstall();
    }

    @Override // com.tencent.state.map.v2.IMap
    public void addMapListener(IMapListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.lock) {
            if (this.mapListeners.contains(listener)) {
                return;
            }
            this.mapListeners.add(listener);
            if (this.isReady.get()) {
                listener.onMapReady();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void addObjectAnimationEndTask(String id5, Runnable task) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(task, "task");
        synchronized (this.lock) {
            if (containsObject(id5)) {
                if (this.mapObjectsAnimationEndTasks.get(id5) == null) {
                    this.mapObjectsAnimationEndTasks.put(id5, new ArrayList());
                }
                List<Runnable> list = this.mapObjectsAnimationEndTasks.get(id5);
                if (list != null) {
                    list.add(task);
                }
            }
        }
    }

    public final void cleanObjectAnimationEndTasks(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        synchronized (this.lock) {
            this.mapObjectsAnimationEndTasks.remove(id5);
        }
    }

    public final boolean containsObject(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        return this.mapObjects.containsKey(id5);
    }

    @Override // com.tencent.state.map.v2.IMap
    public void destroy() {
        synchronized (this.lock) {
            this.mapListeners.clear();
            this.mapObjectsLoadDefers.clear();
            this.mapObjects.clear();
            this.mapObjectsAnimationEndTasks.clear();
            IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.app;
            if (iFilamentNativeAppV2305 != null) {
                iFilamentNativeAppV2305.destroy();
            }
            this.app = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void dispatchToScene(SquareMapEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.app;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.dispatchEvent(null, event.getEventName(), event.toJson());
        }
    }

    @Override // com.tencent.state.map.v2.IMap
    public List<IMapObject> getAllObjects() {
        List<IMapObject> list;
        Collection<FilamentMapObject> values = this.mapObjects.values();
        Intrinsics.checkNotNullExpressionValue(values, "mapObjects.values");
        list = CollectionsKt___CollectionsKt.toList(values);
        return list;
    }

    @Override // com.tencent.state.map.v2.IMap
    public List<String> getCurrentObjectIds() {
        List<String> list;
        Set<String> keySet = this.mapObjects.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "mapObjects.keys");
        list = CollectionsKt___CollectionsKt.toList(keySet);
        return list;
    }

    public final TextureView getEngineView() {
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.app;
        if (iFilamentNativeAppV2305 != null) {
            return iFilamentNativeAppV2305.getView();
        }
        return null;
    }

    @Override // com.tencent.state.map.v2.IMap
    public IMapObject getObject(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        return this.mapObjects.get(id5);
    }

    @Override // com.tencent.state.map.v2.IMap
    /* renamed from: getViewport, reason: from getter */
    public ViewportInfo getCurrentViewport() {
        return this.currentViewport;
    }

    @Override // com.tencent.state.map.v2.IMap
    public void moveViewport(ViewportInfo from, ViewportInfo to5, int duration) {
        Intrinsics.checkNotNullParameter(to5, "to");
        dispatchToScene(new MoveViewportEvent(from != null ? ModelsKt.toFilament(from) : null, ModelsKt.toFilament(to5), duration));
    }

    @Override // com.tencent.state.map.v2.IMap
    public void pause() {
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.app;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.pause();
        }
    }

    @Override // com.tencent.state.map.v2.IMap
    public void removeMapListener(IMapListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.lock) {
            this.mapListeners.remove(listener);
        }
    }

    @Override // com.tencent.state.map.v2.IMap
    public void removeObject(final String id5, final boolean waitForAnimationEnd) {
        Intrinsics.checkNotNullParameter(id5, "id");
        synchronized (this.lock) {
            final WeakReference weakReference = new WeakReference(this);
            Deferred<Unit> deferred = this.mapObjectsLoadDefers.get(id5);
            if (deferred != null && deferred.isActive()) {
                Deferred<Unit> deferred2 = this.mapObjectsLoadDefers.get(id5);
                if (deferred2 != null) {
                    deferred2.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.state.map.v2.filament.FilamentMap$removeObject$$inlined$synchronized$lambda$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                            invoke2(th5);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable th5) {
                            FilamentMap filamentMap = (FilamentMap) weakReference.get();
                            if (filamentMap != null) {
                                IMap.DefaultImpls.removeObject$default(filamentMap, id5, false, 2, null);
                            }
                        }
                    });
                }
            } else {
                this.mapObjectsLoadDefers.remove(id5);
                if (waitForAnimationEnd) {
                    addObjectAnimationEndTask(id5, new Runnable() { // from class: com.tencent.state.map.v2.filament.FilamentMap$removeObject$$inlined$synchronized$lambda$2
                        @Override // java.lang.Runnable
                        public final void run() {
                            FilamentMap.this.removeObject(id5, false);
                        }
                    });
                } else {
                    SquareBaseKt.getSquareThread().postOnSubThread(new Function0<Unit>() { // from class: com.tencent.state.map.v2.filament.FilamentMap$removeObject$$inlined$synchronized$lambda$3
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
                            FilamentMap.this.dispatchToScene(new RemoveObjectEvent(id5));
                        }
                    });
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    @Override // com.tencent.state.map.v2.IMap
    public void resume() {
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.app;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.resume();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00d2, code lost:
    
        r0 = r20.invoke(new com.tencent.state.map.v2.MapError(5, "params invalid"), kotlin.Unit.INSTANCE);
     */
    @Override // com.tencent.state.map.v2.IMap
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addObject(final ObjectParams params, final Function2<? super MapError, ? super Unit, Unit> callback) {
        Deferred<Unit> async$default;
        Intrinsics.checkNotNullParameter(params, "params");
        synchronized (this.lock) {
            SquareBaseKt.getSquareLog().d(TAG, "addObject " + params.getId());
            FilamentMapObjectParams filamentMapObjectParams = (FilamentMapObjectParams) (!(params instanceof FilamentMapObjectParams) ? null : params);
            if (filamentMapObjectParams != null && filamentMapObjectParams.isValid()) {
                final WeakReference weakReference = new WeakReference(this);
                Deferred<Unit> deferred = this.mapObjectsLoadDefers.get(params.getId());
                if (deferred != null && deferred.isActive()) {
                    SquareBaseKt.getSquareLog().d(TAG, "addObject " + params.getId() + " is loading");
                    Deferred<Unit> deferred2 = this.mapObjectsLoadDefers.get(params.getId());
                    if (deferred2 != null) {
                        deferred2.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.state.map.v2.filament.FilamentMap$addObject$$inlined$synchronized$lambda$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                                invoke2(th5);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable th5) {
                                FilamentMap filamentMap = (FilamentMap) weakReference.get();
                                if (filamentMap != null) {
                                    filamentMap.addObject(params, callback);
                                }
                            }
                        });
                    }
                    return;
                }
                this.mapObjectsLoadDefers.remove(params.getId());
                ConcurrentHashMap<String, Deferred<Unit>> concurrentHashMap = this.mapObjectsLoadDefers;
                String id5 = params.getId();
                async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FilamentMap$addObject$$inlined$synchronized$lambda$2(filamentMapObjectParams, weakReference, null, this, params, callback), 3, null);
                concurrentHashMap.put(id5, async$default);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // com.tencent.state.map.v2.IMap
    public void boot(Context context, final Size mapSize, final Size viewportSize, final Function2<? super MapError, ? super TextureView, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mapSize, "mapSize");
        Intrinsics.checkNotNullParameter(viewportSize, "viewportSize");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "boot mapSize=" + mapSize + ", viewportSize=" + viewportSize);
        FilamentReportHelper.INSTANCE.markUsedFilament();
        this.bootStartTime = System.currentTimeMillis();
        a aVar = a.f399763a;
        final IFilamentNativeAppV2305 c16 = FilamentRenderFactory.f105773b.c(new sk0.a(FilamentFeatureUtil.f106409g.F(), false, context, (int) 15.0f, (k) aVar.a(k.class), (d) aVar.a(d.class), null, 64, null));
        this.app = c16;
        Iterator<T> it = FILAMENT_EVENTS.iterator();
        while (it.hasNext()) {
            c16.addEventListener((String) it.next(), this.filamentListener);
        }
        b bVar = this.span;
        c16.startWithEntry(bVar != null ? bVar.c() : null, "bundle/scenes/square_map/main.js");
        dispatchToScene(new BootMapEvent(ModelsKt.toFilament(mapSize), ModelsKt.toFilament(viewportSize)));
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.map.v2.filament.FilamentMap$boot$$inlined$let$lambda$1
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
                callback.invoke(null, IFilamentNativeAppV2305.this.getView());
            }
        });
    }
}
