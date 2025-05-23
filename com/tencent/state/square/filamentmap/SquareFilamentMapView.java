package com.tencent.state.square.filamentmap;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.filament.zplan.scene.square.PlayObjectAnimationEvent;
import com.tencent.filament.zplan.scene.square.StopObjectAnimationEvent;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.map.IMapViewListener;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewConfig;
import com.tencent.state.map.MapViewConfigKt;
import com.tencent.state.map.MapViewItemIgnoreClick;
import com.tencent.state.map.v2.IMapListener;
import com.tencent.state.map.v2.Location;
import com.tencent.state.map.v2.MapError;
import com.tencent.state.map.v2.ObjectState;
import com.tencent.state.map.v2.Size;
import com.tencent.state.map.v2.ViewportInfo;
import com.tencent.state.map.v2.filament.FilamentMap;
import com.tencent.state.map.v2.filament.MapViewPosition;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.filamentmap.SquareFilamentMapDebugView;
import com.tencent.state.square.filamentmap.SquareFilamentMapView;
import com.tencent.state.utils.TimeoutTaskManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0001PB-\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0014\u00100\u001a\u00020\u001b2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aJ\u000e\u00102\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u0017J\u000e\u00104\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u0017J\u0006\u00105\u001a\u00020\u001bJ\u0016\u00106\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010.\u001a\u00020/J\u0006\u0010\"\u001a\u00020\u001dJ\b\u00107\u001a\u00020\u001bH\u0014J&\u00108\u001a\u00020\u001b2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020>J\u000e\u0010?\u001a\u00020\u001b2\u0006\u0010@\u001a\u00020\u001dJ\u0006\u0010A\u001a\u00020\u001bJ\u001c\u0010B\u001a\u00020\u001b2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010D\u001a\u00020\u001dJ\u000e\u0010E\u001a\u00020\u001b2\u0006\u0010F\u001a\u00020+J$\u0010G\u001a\u00020\u001b2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020I0\u00162\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020JJ\u000e\u0010K\u001a\u00020\u001b2\u0006\u0010L\u001a\u00020MJ\u000e\u0010N\u001a\u00020\u001b2\u0006\u0010L\u001a\u00020MJ\b\u0010O\u001a\u00020\u001bH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001b0'\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006Q"}, d2 = {"Lcom/tencent/state/square/filamentmap/SquareFilamentMapView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/state/map/MapViewItemIgnoreClick;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "listener", "Lcom/tencent/state/square/filamentmap/ISquareFilamentMapEventListener;", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/state/square/filamentmap/ISquareFilamentMapEventListener;)V", DownloadInfo.spKey_Config, "Lcom/tencent/state/map/MapViewConfig;", ParseCommon.CONTAINER, "Lcom/tencent/state/map/v2/filament/FilamentMap;", "getContainer", "()Lcom/tencent/state/map/v2/filament/FilamentMap;", "setContainer", "(Lcom/tencent/state/map/v2/filament/FilamentMap;)V", "currentEnginePauseObjectIds", "Ljava/util/concurrent/atomic/AtomicReference;", "", "", "engineResumeTasks", "", "Lkotlin/Function0;", "", "filamentReady", "", "getFilamentReady", "()Z", "setFilamentReady", "(Z)V", "isEnginePaused", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getListener", "()Lcom/tencent/state/square/filamentmap/ISquareFilamentMapEventListener;", "mapReadySignal", "Lkotlinx/coroutines/CompletableDeferred;", "getMapReadySignal", "()Lkotlinx/coroutines/CompletableDeferred;", "resumeEngineRenderCallback", "Lcom/tencent/state/square/filamentmap/ResumeEngineRenderCallback;", "resumeEngineTimeoutManager", "Lcom/tencent/state/utils/TimeoutTaskManager;", "viewportSize", "Lcom/tencent/state/map/v2/Size;", "addEngineResumeTask", "task", "containsObject", "id", "containsObjectInPaused", "destroy", "initialize", NodeProps.ON_ATTACHED_TO_WINDOW, "onViewportChanged", "scale", "", "scrollX", "scrollY", "mapRectF", "Landroid/graphics/RectF;", "onVisibilityChanged", "isVisible", "pauseEngineRender", "playListener", "list", "show", "prepareToResumeEngineRender", "callback", "reset", "dataList", "Lcom/tencent/state/map/MapItem;", "Lcom/tencent/state/map/IMapViewListener;", "resumeEngineRender", "mapPosition", "Lcom/tencent/state/map/v2/filament/MapViewPosition;", "updatePosition", "updateSize", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareFilamentMapView extends FrameLayout implements MapViewItemIgnoreClick {
    private static final long RESUME_ENGINE_TIMEOUT_MS = 1000;
    private static final String TAG = "SquareFilamentMapView";
    private MapViewConfig config;
    private FilamentMap container;
    private AtomicReference<List<String>> currentEnginePauseObjectIds;
    private List<Function0<Unit>> engineResumeTasks;
    private boolean filamentReady;
    private AtomicBoolean isEnginePaused;
    private final ISquareFilamentMapEventListener listener;
    private final CompletableDeferred<Unit> mapReadySignal;
    private ResumeEngineRenderCallback resumeEngineRenderCallback;
    private final TimeoutTaskManager resumeEngineTimeoutManager;
    private Size viewportSize;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/state/square/filamentmap/SquareFilamentMapView$1", "Lcom/tencent/state/map/v2/IMapListener;", "onEngineRenderRecovered", "", "onMapReady", "onObjectStateChanged", "id", "", "state", "Lcom/tencent/state/map/v2/ObjectState;", "onViewportChanged", "info", "Lcom/tencent/state/map/v2/ViewportInfo;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.state.square.filamentmap.SquareFilamentMapView$1, reason: invalid class name */
    /* loaded from: classes38.dex */
    public static final class AnonymousClass1 implements IMapListener {
        AnonymousClass1() {
        }

        @Override // com.tencent.state.map.v2.IMapListener
        public void onEngineRenderRecovered() {
            SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.filamentmap.SquareFilamentMapView$1$onEngineRenderRecovered$1
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
                    TimeoutTaskManager timeoutTaskManager;
                    ResumeEngineRenderCallback resumeEngineRenderCallback;
                    timeoutTaskManager = SquareFilamentMapView.this.resumeEngineTimeoutManager;
                    timeoutTaskManager.clearTimeout();
                    resumeEngineRenderCallback = SquareFilamentMapView.this.resumeEngineRenderCallback;
                    if (resumeEngineRenderCallback != null) {
                        resumeEngineRenderCallback.onEngineResumed();
                    }
                }
            });
        }

        @Override // com.tencent.state.map.v2.IMapListener
        public void onMapReady() {
            SquareBaseKt.getSquareLog().d(SquareFilamentMapView.TAG, "onMapReady");
            SquareFilamentMapView.this.getListener().onReady();
            SquareFilamentMapView.this.setFilamentReady(true);
            SquareFilamentMapView.this.getMapReadySignal().complete(Unit.INSTANCE);
        }

        @Override // com.tencent.state.map.v2.IMapListener
        public void onObjectStateChanged(final String id5, final ObjectState state) {
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(state, "state");
            SquareBaseKt.getSquareLog().d(SquareFilamentMapView.TAG, "onObjectStateChanged " + id5 + TokenParser.SP + state);
            SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.filamentmap.SquareFilamentMapView$1$onObjectStateChanged$1
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
                    List<String> listOf;
                    List<String> listOf2;
                    int i3 = SquareFilamentMapView.WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                    if (i3 == 1) {
                        ISquareFilamentMapEventListener listener = SquareFilamentMapView.this.getListener();
                        listOf = CollectionsKt__CollectionsJVMKt.listOf(id5);
                        listener.onChangeAvatarImageVisibility(listOf, false);
                    } else {
                        if (i3 != 2) {
                            return;
                        }
                        if (SquareFilamentMapView.this.isEnginePaused()) {
                            SquareFilamentMapView.this.addEngineResumeTask(new Function0<Unit>() { // from class: com.tencent.state.square.filamentmap.SquareFilamentMapView$1$onObjectStateChanged$1.1
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
                                    List<String> listOf3;
                                    SquareFilamentMapView$1$onObjectStateChanged$1 squareFilamentMapView$1$onObjectStateChanged$1 = SquareFilamentMapView$1$onObjectStateChanged$1.this;
                                    if (SquareFilamentMapView.this.containsObject(id5)) {
                                        return;
                                    }
                                    ISquareFilamentMapEventListener listener2 = SquareFilamentMapView.this.getListener();
                                    listOf3 = CollectionsKt__CollectionsJVMKt.listOf(id5);
                                    listener2.onChangeAvatarImageVisibility(listOf3, true);
                                }
                            });
                            return;
                        }
                        ISquareFilamentMapEventListener listener2 = SquareFilamentMapView.this.getListener();
                        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(id5);
                        listener2.onChangeAvatarImageVisibility(listOf2, true);
                    }
                }
            });
        }

        @Override // com.tencent.state.map.v2.IMapListener
        public void onViewportChanged(ViewportInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ObjectState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ObjectState.LOADED.ordinal()] = 1;
            iArr[ObjectState.REMOVED.ordinal()] = 2;
        }
    }

    public SquareFilamentMapView(Context context, AttributeSet attributeSet, ISquareFilamentMapEventListener iSquareFilamentMapEventListener) {
        this(context, attributeSet, 0, iSquareFilamentMapEventListener, 4, null);
    }

    private final void updateSize() {
        final Size size = this.viewportSize;
        if (size != null) {
            ViewExtensionsKt.updateLayoutParams(this, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.filamentmap.SquareFilamentMapView$updateSize$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FrameLayout.LayoutParams layoutParams) {
                    invoke2(layoutParams);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(FrameLayout.LayoutParams receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    receiver.width = (int) Size.this.getWidth();
                    receiver.height = (int) Size.this.getHeight();
                }
            });
        }
    }

    public final void addEngineResumeTask(Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.engineResumeTasks.add(task);
    }

    public final boolean containsObject(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        FilamentMap filamentMap = this.container;
        if (filamentMap != null) {
            return filamentMap.containsObject(id5);
        }
        return false;
    }

    public final boolean containsObjectInPaused(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        return this.currentEnginePauseObjectIds.get().contains(id5);
    }

    public final void destroy() {
        this.resumeEngineTimeoutManager.destroy();
        FilamentMap filamentMap = this.container;
        if (filamentMap != null) {
            filamentMap.destroy();
        }
        this.container = null;
        this.engineResumeTasks.clear();
        this.resumeEngineRenderCallback = null;
    }

    public final FilamentMap getContainer() {
        return this.container;
    }

    public final boolean getFilamentReady() {
        return this.filamentReady;
    }

    public final ISquareFilamentMapEventListener getListener() {
        return this.listener;
    }

    public final CompletableDeferred<Unit> getMapReadySignal() {
        return this.mapReadySignal;
    }

    public final void initialize(MapViewConfig config, Size viewportSize) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(viewportSize, "viewportSize");
        this.config = config;
        this.viewportSize = viewportSize;
        float f16 = (float) 1.0d;
        final Size size = new Size(viewportSize.getWidth() * f16, viewportSize.getHeight() * f16);
        FilamentMap filamentMap = this.container;
        if (filamentMap != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            filamentMap.boot(context, new Size(config.getMapWidth(), config.getMapHeight()), size, new Function2<MapError, TextureView, Unit>() { // from class: com.tencent.state.square.filamentmap.SquareFilamentMapView$initialize$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(MapError mapError, TextureView textureView) {
                    invoke2(mapError, textureView);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(MapError mapError, TextureView mapView) {
                    Intrinsics.checkNotNullParameter(mapView, "mapView");
                    if (mapError != null) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "SquareFilamentMapView", "FilamentMap boot failed: " + mapError, null, 4, null);
                        return;
                    }
                    SquareFilamentMapView squareFilamentMapView = SquareFilamentMapView.this;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) size.getWidth(), (int) size.getHeight());
                    layoutParams.gravity = 17;
                    Unit unit = Unit.INSTANCE;
                    squareFilamentMapView.addView(mapView, layoutParams);
                    FilamentMap container = SquareFilamentMapView.this.getContainer();
                    if (container != null) {
                        container.resume();
                    }
                }
            });
        }
    }

    public final boolean isEnginePaused() {
        return this.isEnginePaused.get();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        ViewParent parent;
        super.onAttachedToWindow();
        ViewParent parent2 = getParent();
        ViewParent parent3 = (parent2 == null || (parent = parent2.getParent()) == null) ? null : parent.getParent();
        FrameLayout frameLayout = (FrameLayout) (parent3 instanceof FrameLayout ? parent3 : null);
        if (frameLayout != null) {
            SquareFilamentMapDebugView.Companion companion = SquareFilamentMapDebugView.INSTANCE;
            FilamentMap filamentMap = this.container;
            Intrinsics.checkNotNull(filamentMap);
            companion.init(frameLayout, filamentMap);
        }
    }

    public final void onViewportChanged(float scale, int scrollX, int scrollY, RectF mapRectF) {
        Intrinsics.checkNotNullParameter(mapRectF, "mapRectF");
        SquareBaseKt.getSquareLog().d(TAG, "onViewportChanged " + scale + TokenParser.SP + scrollX + TokenParser.SP + scrollY + TokenParser.SP + mapRectF);
        float f16 = (-((float) scrollX)) + mapRectF.left;
        float f17 = (-((float) scrollY)) + mapRectF.top;
        FilamentMap filamentMap = this.container;
        if (filamentMap != null) {
            filamentMap.moveViewport(null, new ViewportInfo(scale, new Location(f16, f17)), 0);
        }
    }

    public final void pauseEngineRender() {
        List<String> emptyList;
        TextureView engineView;
        this.resumeEngineTimeoutManager.clearTimeout();
        this.isEnginePaused.set(true);
        AtomicReference<List<String>> atomicReference = this.currentEnginePauseObjectIds;
        FilamentMap filamentMap = this.container;
        if (filamentMap == null || (emptyList = filamentMap.getCurrentObjectIds()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        atomicReference.set(emptyList);
        FilamentMap filamentMap2 = this.container;
        if (filamentMap2 != null) {
            filamentMap2.dispatchToScene(new StopObjectAnimationEvent());
        }
        FilamentMap filamentMap3 = this.container;
        if (filamentMap3 == null || (engineView = filamentMap3.getEngineView()) == null) {
            return;
        }
        engineView.setVisibility(4);
    }

    public final void playListener(final List<String> list, final boolean show) {
        Intrinsics.checkNotNullParameter(list, "list");
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.filamentmap.SquareFilamentMapView$playListener$1
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
                SquareFilamentMapView.this.getListener().onChangeAvatarImageVisibility(list, show);
            }
        });
    }

    public final void prepareToResumeEngineRender(ResumeEngineRenderCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        FilamentMap filamentMap = this.container;
        if (filamentMap != null) {
            filamentMap.dispatchToScene(new PlayObjectAnimationEvent());
        }
        this.resumeEngineRenderCallback = callback;
        final WeakReference weakReference = new WeakReference(this);
        this.resumeEngineTimeoutManager.setTimeout(1000L, new Function0<Unit>() { // from class: com.tencent.state.square.filamentmap.SquareFilamentMapView$prepareToResumeEngineRender$1
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
                SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.filamentmap.SquareFilamentMapView$prepareToResumeEngineRender$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:3:0x001c, code lost:
                    
                        r0 = r0.resumeEngineRenderCallback;
                     */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void invoke2() {
                        ResumeEngineRenderCallback resumeEngineRenderCallback;
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "SquareFilamentMapView", "prepareToResumeEngineRender timeout", null, 4, null);
                        SquareFilamentMapView squareFilamentMapView = (SquareFilamentMapView) weakReference.get();
                        if (squareFilamentMapView == null || resumeEngineRenderCallback == null) {
                            return;
                        }
                        resumeEngineRenderCallback.onEngineResumed();
                    }
                });
            }
        });
    }

    public final void reset(List<? extends MapItem> dataList, MapViewConfig config, IMapViewListener listener) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public final void resumeEngineRender(MapViewPosition mapPosition) {
        TextureView engineView;
        Intrinsics.checkNotNullParameter(mapPosition, "mapPosition");
        this.isEnginePaused.set(false);
        Iterator<T> it = this.engineResumeTasks.iterator();
        while (it.hasNext()) {
            ((Function0) it.next()).invoke();
        }
        this.engineResumeTasks.clear();
        updatePosition(mapPosition);
        FilamentMap filamentMap = this.container;
        if (filamentMap == null || (engineView = filamentMap.getEngineView()) == null) {
            return;
        }
        engineView.setVisibility(0);
    }

    public final void setContainer(FilamentMap filamentMap) {
        this.container = filamentMap;
    }

    public final void setFilamentReady(boolean z16) {
        this.filamentReady = z16;
    }

    public final void updatePosition(final MapViewPosition mapPosition) {
        Intrinsics.checkNotNullParameter(mapPosition, "mapPosition");
        if (SquareBaseKt.getSquareLog().isColorLevel()) {
            SquareBaseKt.getSquareLog().d(TAG, "updatePosition: " + mapPosition);
        }
        updateSize();
        ViewExtensionsKt.updateLayoutParams(this, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.filamentmap.SquareFilamentMapView$updatePosition$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FrameLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FrameLayout.LayoutParams receiver) {
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                int mapScrollX = (int) ((mapPosition.getMapScrollX() - mapPosition.getContainerRect().left) / mapPosition.getContainerScaleX());
                int mapScrollY = (int) ((mapPosition.getMapScrollY() - mapPosition.getContainerRect().top) / mapPosition.getContainerScaleY());
                SquareFilamentMapView.this.setPivotX(0.0f);
                SquareFilamentMapView.this.setPivotY(0.0f);
                receiver.leftMargin = mapScrollX;
                receiver.topMargin = mapScrollY;
                float f16 = 1;
                SquareFilamentMapView.this.setScaleX(f16 / mapPosition.getContainerScaleX());
                SquareFilamentMapView.this.setScaleY(f16 / mapPosition.getContainerScaleY());
            }
        });
    }

    public SquareFilamentMapView(Context context, ISquareFilamentMapEventListener iSquareFilamentMapEventListener) {
        this(context, null, 0, iSquareFilamentMapEventListener, 6, null);
    }

    public /* synthetic */ SquareFilamentMapView(Context context, AttributeSet attributeSet, int i3, ISquareFilamentMapEventListener iSquareFilamentMapEventListener, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, iSquareFilamentMapEventListener);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareFilamentMapView(Context context, AttributeSet attributeSet, int i3, ISquareFilamentMapEventListener listener) {
        super(context, attributeSet, i3);
        List emptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        this.mapReadySignal = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.config = MapViewConfigKt.defaultMapConfig();
        this.isEnginePaused = new AtomicBoolean(false);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.currentEnginePauseObjectIds = new AtomicReference<>(emptyList);
        this.engineResumeTasks = new ArrayList();
        this.resumeEngineTimeoutManager = new TimeoutTaskManager();
        setBackgroundColor(0);
        setElevation(1.0f);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        FilamentMap filamentMap = new FilamentMap();
        this.container = filamentMap;
        filamentMap.addMapListener(new AnonymousClass1());
    }

    public final void onVisibilityChanged(boolean isVisible) {
    }
}
