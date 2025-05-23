package com.tencent.state.square;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.state.map.BaseMapView;
import com.tencent.state.map.IMapItemViewManager;
import com.tencent.state.map.IMapLocator;
import com.tencent.state.map.IMapPlayManager;
import com.tencent.state.map.IMapViewListener;
import com.tencent.state.map.IMapViewManipulator;
import com.tencent.state.map.IMapViewUpdater;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapAdapter;
import com.tencent.state.map.MapContainer;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapItemController;
import com.tencent.state.map.MapPlayableViewHolder;
import com.tencent.state.map.MapViewConfig;
import com.tencent.state.map.MapViewDataObserver;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.map.MapViewItemIgnoreClick;
import com.tencent.state.map.v2.Size;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.SquarePageBackgroundInfo;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.avatar.PlayerSourceHelper;
import com.tencent.state.square.components.SquareGroupReportComponentKt;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.exposure.SquareExposureManager;
import com.tencent.state.square.filamentmap.IFilamentMapController;
import com.tencent.state.square.filamentmap.ISquareFilamentMapEventListener;
import com.tencent.state.square.filamentmap.SquareFilamentMapView;
import com.tencent.state.square.filamentmap.SquareFilamentViewController;
import com.tencent.state.square.holder.AvatarViewHolder;
import com.tencent.state.square.layout.IDynamicLayoutComponent;
import com.tencent.state.square.layout.MoveCommand;
import com.tencent.state.square.layout.OnMoveCallback;
import com.tencent.state.square.layout.SquareDynamicLayoutAnimator;
import com.tencent.state.square.locator.SquareAreaRankLocator;
import com.tencent.state.square.resource.SquareResourceManagerKt;
import com.tencent.state.utils.AnimationUtils;
import com.tencent.state.utils.BackgroundUtils;
import com.tencent.state.utils.SquareSwitchUtils;
import com.tencent.state.view.SquareImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00d4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 V2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002VWB%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\r\u0010\u0016\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ&\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\u0014\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\u0011H\u0014J\u001e\u0010'\u001a\u00020\u00022\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150(2\u0006\u0010)\u001a\u00020*H\u0014J\u001e\u0010+\u001a\u00020*2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150(2\u0006\u0010 \u001a\u00020!H\u0014J\u0010\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020.H\u0014J \u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00192\u0006\u0010)\u001a\u00020*H\u0014J\u0010\u00104\u001a\u00020\u001d2\u0006\u00105\u001a\u000206H\u0014J(\u00107\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020*2\u0006\u00108\u001a\u00020\u00192\u0006\u0010-\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0014J\b\u0010<\u001a\u00020\u001dH\u0014J\b\u0010=\u001a\u00020\u001dH\u0014J\u001a\u0010>\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020\b2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010AJ\u0012\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J \u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\bJ*\u0010H\u001a\u00020\u001d2\b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020\b2\u0010\b\u0002\u0010I\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010JJ\u0012\u0010K\u001a\u00020C2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u0010\u0010L\u001a\u00020\u001d2\b\u0010M\u001a\u0004\u0018\u00010\rJ$\u0010N\u001a\u00020\u001d2\u0006\u0010O\u001a\u00020C2\u0012\u0010P\u001a\u000e\u0012\u0002\b\u0003\u0018\u00010Qj\u0004\u0018\u0001`RH\u0002J\u0018\u0010S\u001a\u00020\u001d2\u000e\u0010T\u001a\n\u0012\u0002\b\u00030Qj\u0002`RH\u0014J\b\u0010U\u001a\u00020\u001dH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006X"}, d2 = {"Lcom/tencent/state/square/SquareView;", "Lcom/tencent/state/map/BaseMapView;", "Lcom/tencent/state/square/SquareBaseAdapter;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animator", "Lcom/tencent/state/square/layout/OnMoveCallback;", "backgroundInfo", "Lcom/tencent/state/service/SquarePageBackgroundInfo;", "backgroundView", "Landroid/view/View;", "createdFilamentMap", "Lcom/tencent/state/square/filamentmap/SquareFilamentMapView;", "findItemStaticViewLocation", "Lcom/tencent/state/map/Location;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/state/map/MapItem;", "getMeIndex", "()Ljava/lang/Integer;", "getPlayManager", "Lcom/tencent/state/map/IMapPlayManager;", "getUpdater", "Lcom/tencent/state/square/ISquareViewUpdater;", "initialize", "", "dataList", "", DownloadInfo.spKey_Config, "Lcom/tencent/state/map/MapViewConfig;", "listener", "Lcom/tencent/state/map/IMapViewListener;", "onCreateFilamentMapViewUpdater", "Lcom/tencent/state/square/filamentmap/IFilamentMapController;", "filamentMap", "onCreateMapAdapter", "", "locator", "Lcom/tencent/state/map/IMapLocator;", "onCreateMapLocator", "onCreateMapPlayManager", "observer", "Lcom/tencent/state/map/MapViewDataObserver;", "onCreateMapViewUpdater", "Lcom/tencent/state/map/IMapViewUpdater;", "adapter", "Lcom/tencent/state/map/MapAdapter;", "rpm", "onDoubleClicked", "e", "Landroid/view/MotionEvent;", "onInitMapAdapter", "rmp", "Lcom/tencent/state/map/IMapItemViewManager;", "manipulator", "Lcom/tencent/state/map/IMapViewManipulator;", "onMapSizeInitReadyAction", "onScrollIdled", "openMeDetail", "viewInt", "extra", "", "scaleToDetail", "", "uin", "", "type", "viewId", "scaleToDetailAmin", "callback", "Lkotlin/Function0;", "scaleToMeDetail", "setBackgroundInfo", "backgroundUrl", "startTargetAlphaAnimation", "isScaleToCenter", "targetHolder", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "startViewAlpha", "viewHolder", "updateBackgroundInfo", "Companion", "SquareBackgroundView", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareView extends BaseMapView<SquareBaseAdapter> {
    private static final String TAG = "Square_SquareView";
    private OnMoveCallback animator;
    private SquarePageBackgroundInfo backgroundInfo;
    private View backgroundView;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/square/SquareView$SquareBackgroundView;", "Lcom/tencent/state/view/SquareImageView;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onDraw", "", PM.CANVAS, "Landroid/graphics/Canvas;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class SquareBackgroundView extends SquareImageView {
        public SquareBackgroundView(Context context) {
            this(context, null, 0, 6, null);
        }

        @Override // android.widget.ImageView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            setElevation(-2000.0f);
        }

        public SquareBackgroundView(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0, 4, null);
        }

        public /* synthetic */ SquareBackgroundView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SquareBackgroundView(Context context, AttributeSet attributeSet, int i3) {
            super(context, attributeSet, i3);
            Intrinsics.checkNotNullParameter(context, "context");
        }
    }

    public SquareView(Context context) {
        this(context, null, 0, 6, null);
    }

    private final SquareFilamentMapView createdFilamentMap() {
        if (!SquareSwitchUtils.INSTANCE.enableFilamentIndex()) {
            return null;
        }
        if (getFilamentMap() == null) {
            final WeakReference weakReference = new WeakReference(this);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            SquareFilamentMapView squareFilamentMapView = new SquareFilamentMapView(context, null, 0, new ISquareFilamentMapEventListener() { // from class: com.tencent.state.square.SquareView$createdFilamentMap$view$1
                @Override // com.tencent.state.square.filamentmap.ISquareFilamentMapEventListener
                public void onChangeAvatarImageVisibility(List<String> ids, boolean visible) {
                    ISquareViewUpdater updater;
                    Intrinsics.checkNotNullParameter(ids, "ids");
                    for (String str : ids) {
                        SquareView squareView = (SquareView) weakReference.get();
                        if (squareView != null && (updater = squareView.getUpdater()) != null) {
                            updater.updateAvatarImageVisible(str, visible);
                        }
                    }
                }

                @Override // com.tencent.state.square.filamentmap.ISquareFilamentMapEventListener
                public void onReady() {
                    SquareView squareView = (SquareView) weakReference.get();
                    if (squareView != null) {
                        squareView.updateFilamentViewport();
                    }
                }
            }, 6, null);
            getContainer().addView(squareFilamentMapView);
            setFilamentMap(squareFilamentMapView);
        }
        return getFilamentMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized Location findItemStaticViewLocation(MapItem item) {
        MapItemController controller;
        IMapItemViewManager viewManager;
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            int indexOf = adapter.indexOf(item);
            SquareBaseAdapter adapter2 = getAdapter();
            MapViewHolder<?> mapViewHolder = null;
            MapViewHolder<?> viewHolder = (adapter2 == null || (controller = adapter2.getController()) == null || (viewManager = controller.getViewManager()) == null) ? null : viewManager.getViewHolder(indexOf);
            if (viewHolder instanceof MapPlayableViewHolder) {
                mapViewHolder = viewHolder;
            }
            if (((MapPlayableViewHolder) mapViewHolder) != null) {
                return ((MapPlayableViewHolder) viewHolder).getPlayerViewLocation();
            }
            return item.getLocation();
        }
        return item.getLocation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateBackgroundInfo() {
        SquarePageBackgroundInfo squarePageBackgroundInfo = this.backgroundInfo;
        if (squarePageBackgroundInfo != null) {
            BackgroundUtils backgroundUtils = BackgroundUtils.INSTANCE;
            BackgroundUtils.setBkgImage$default(backgroundUtils, this.backgroundView, squarePageBackgroundInfo.getBackgroundUrl(), false, 4, null);
            backgroundUtils.setBackgroundGradientColor(this.backgroundView, squarePageBackgroundInfo.getGradientArr());
        }
    }

    public final Integer getMeIndex() {
        MapAdapter adapter = getAdapter();
        if (adapter != null) {
            return Integer.valueOf(adapter.getMeIndex());
        }
        return null;
    }

    public final IMapPlayManager getPlayManager() {
        return (IMapPlayManager) getComponent(IMapPlayManager.class);
    }

    public final ISquareViewUpdater getUpdater() {
        return (ISquareViewUpdater) getComponent(ISquareViewUpdater.class);
    }

    @Override // com.tencent.state.map.BaseMapView
    public void initialize(List<? extends MapItem> dataList, MapViewConfig config, IMapViewListener listener) {
        int width;
        int height;
        IMapLocator locator;
        IDynamicLayoutComponent layoutManager;
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (getWidth() == 0) {
            width = config.getViewPortWidth();
        } else {
            width = getWidth();
        }
        float f16 = width;
        if (getHeight() == 0) {
            height = config.getViewPortHeight();
        } else {
            height = getHeight();
        }
        Size size = new Size(f16, height);
        SquareFilamentMapView createdFilamentMap = createdFilamentMap();
        if (createdFilamentMap != null) {
            createdFilamentMap.initialize(config, size);
        }
        super.initialize(dataList, config, listener);
        if (dataList.isEmpty()) {
            View view = this.backgroundView;
            if (view != null) {
                view.setVisibility(8);
            }
            View view2 = this.backgroundView;
            if (view2 != null) {
                view2.setBackground(null);
            }
        } else {
            View view3 = this.backgroundView;
            if (view3 != null) {
                view3.post(new Runnable() { // from class: com.tencent.state.square.SquareView$initialize$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        View view4;
                        try {
                            view4 = SquareView.this.backgroundView;
                            if (view4 != null) {
                                view4.setVisibility(0);
                            }
                            SquareView.this.updateBackgroundInfo();
                        } catch (Throwable th5) {
                            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "Square_SquareView", "background load error " + th5, null, 4, null);
                        }
                    }
                });
            }
        }
        MapViewDataObserver observer = getObserver();
        if (observer == null || (locator = getLocator()) == null) {
            return;
        }
        this.animator = new SquareDynamicLayoutAnimator(observer, locator, this);
        SquareBaseAdapter adapter = getAdapter();
        if (adapter == null || (layoutManager = adapter.getLayoutManager()) == null) {
            return;
        }
        registerComponent(layoutManager);
    }

    @Override // com.tencent.state.map.BaseMapView
    public /* bridge */ /* synthetic */ SquareBaseAdapter onCreateMapAdapter(List list, IMapLocator iMapLocator) {
        return onCreateMapAdapter2((List<MapItem>) list, iMapLocator);
    }

    @Override // com.tencent.state.map.BaseMapView
    protected IMapLocator onCreateMapLocator(List<MapItem> dataList, MapViewConfig config) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(config, "config");
        return new SquareAreaRankLocator(config, dataList);
    }

    @Override // com.tencent.state.map.BaseMapView
    protected IMapPlayManager onCreateMapPlayManager(MapViewDataObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        IMapPlayManager onCreateMapPlayManager = super.onCreateMapPlayManager(observer);
        registerComponent(onCreateMapPlayManager);
        return onCreateMapPlayManager;
    }

    @Override // com.tencent.state.map.BaseMapView
    protected IMapViewUpdater onCreateMapViewUpdater(MapAdapter adapter, IMapPlayManager rpm, IMapLocator locator) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(rpm, "rpm");
        Intrinsics.checkNotNullParameter(locator, "locator");
        return new SquareViewUpdater(getAdapter(), locator, rpm);
    }

    @Override // com.tencent.state.map.BaseMapView
    protected void onDoubleClicked(MotionEvent e16) {
        Intrinsics.checkNotNullParameter(e16, "e");
        List<View> findTargetViews = getViewFinder().findTargetViews(e16.getX(), e16.getY());
        ArrayList arrayList = new ArrayList();
        for (Object obj : findTargetViews) {
            if (!(((View) obj) instanceof MapViewItemIgnoreClick)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            BaseMapView.ScaleState.zoomMap$default(getScaleState(), false, null, null, null, 14, null);
        }
    }

    @Override // com.tencent.state.map.BaseMapView
    protected void onInitMapAdapter(IMapLocator locator, IMapPlayManager rmp, IMapItemViewManager observer, IMapViewManipulator manipulator) {
        Intrinsics.checkNotNullParameter(locator, "locator");
        Intrinsics.checkNotNullParameter(rmp, "rmp");
        Intrinsics.checkNotNullParameter(observer, "observer");
        Intrinsics.checkNotNullParameter(manipulator, "manipulator");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            MapItemController mapItemController = new MapItemController(rmp, locator, manipulator, observer, getListener(), new SquareExposureManager(), null, 64, null);
            if (Square.INSTANCE.getConfig().getNeedScaleAnimation()) {
                mapItemController.setWelcomeScaleAnimDone(false);
            }
            Unit unit = Unit.INSTANCE;
            adapter.initialize(mapItemController);
        }
    }

    @Override // com.tencent.state.map.BaseMapView
    protected void onMapSizeInitReadyAction() {
        final int i3 = Square.INSTANCE.getConfig().getNeedScaleAnimation() ? 0 : 2;
        PlayerSourceHelper.INSTANCE.setMapZoomLevel(i3);
        post(new Runnable() { // from class: com.tencent.state.square.SquareView$onMapSizeInitReadyAction$1
            @Override // java.lang.Runnable
            public final void run() {
                BaseMapView.ScaleState scaleState;
                IMapViewListener listener;
                scaleState = SquareView.this.getScaleState();
                BaseMapView.ScaleState.zoomMap$default(scaleState, true, Integer.valueOf(i3), 0L, null, 8, null);
                listener = SquareView.this.getListener();
                if (listener != null) {
                    listener.onMapSizeInitReady();
                }
            }
        });
    }

    @Override // com.tencent.state.map.BaseMapView
    protected void onScrollIdled() {
        super.onScrollIdled();
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, SquareGroupReportComponentKt.getSourceFrom(getContext()));
        Unit unit = Unit.INSTANCE;
        squareReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_SLIDE_MAP, linkedHashMap);
    }

    public final void openMeDetail(int viewInt, Object extra) {
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            MapViewHolder<?> viewHolder = getViewHolder(adapter.getMeIndex());
            if (!(viewHolder instanceof AvatarViewHolder)) {
                viewHolder = null;
            }
            AvatarViewHolder avatarViewHolder = (AvatarViewHolder) viewHolder;
            if (avatarViewHolder != null) {
                avatarViewHolder.doScaleToDetail(viewInt, extra);
            }
        }
    }

    public final boolean scaleToDetail(final String uin, final int type, final int viewId) {
        SquareBaseAdapter adapter = getAdapter();
        if (adapter == null) {
            return false;
        }
        final int indexOf = adapter.indexOf(uin != null ? uin : "", type);
        MapViewHolder<?> viewHolder = getViewHolder(indexOf);
        if (viewHolder != null) {
            MapViewHolder.doScaleToDetail$default(viewHolder, viewId, null, 2, null);
            return true;
        }
        getManipulator().locateTo(indexOf, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.SquareView$scaleToDetail$$inlined$let$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                MapViewHolder<?> viewHolder2;
                if (!z16 || (viewHolder2 = SquareView.this.getViewHolder(indexOf)) == null) {
                    return;
                }
                MapViewHolder.doScaleToDetail$default(viewHolder2, viewId, null, 2, null);
            }
        });
        return true;
    }

    public final void scaleToDetailAmin(final String uin, final int type, final Function0<Unit> callback) {
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            int indexOf = adapter.indexOf(uin != null ? uin : "", type);
            final MapViewHolder<?> viewHolder = getViewHolder(indexOf);
            Boolean valueOf = viewHolder != null ? Boolean.valueOf(viewHolder.onScaleToDetail()) : null;
            if (valueOf == null) {
                getManipulator().locateTo(indexOf, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.SquareView$scaleToDetailAmin$$inlined$let$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        MapViewHolder mapViewHolder;
                        Function0 function0;
                        if (!z16 || (mapViewHolder = MapViewHolder.this) == null || !mapViewHolder.onScaleToDetail() || (function0 = callback) == null) {
                            return;
                        }
                    }
                });
            } else {
                if (!Intrinsics.areEqual(valueOf, Boolean.TRUE) || callback == null) {
                    return;
                }
                callback.invoke();
            }
        }
    }

    @Override // com.tencent.state.map.BaseMapView
    public boolean scaleToMeDetail(final Object extra) {
        SquareBaseAdapter adapter = getAdapter();
        if (adapter == null) {
            return false;
        }
        final int meIndex = adapter.getMeIndex();
        MapViewHolder<?> viewHolder = getViewHolder(meIndex);
        if (viewHolder != null) {
            viewHolder.doScaleToDetail(3, extra);
        } else {
            IMapViewManipulator.DefaultImpls.locateToMe$default(getManipulator(), 0, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.SquareView$scaleToMeDetail$$inlined$let$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    MapViewHolder<?> viewHolder2;
                    if (!z16 || (viewHolder2 = SquareView.this.getViewHolder(meIndex)) == null) {
                        return;
                    }
                    viewHolder2.doScaleToDetail(3, extra);
                }
            }, 1, null);
        }
        return true;
    }

    public final void setBackgroundInfo(SquarePageBackgroundInfo backgroundUrl) {
        this.backgroundInfo = backgroundUrl;
    }

    @Override // com.tencent.state.map.BaseMapView
    protected void startViewAlpha(MapViewHolder<?> viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(viewHolder.getIndex()));
        getAnimateState().startOtherViewAlpha(arrayList);
        Object data = viewHolder.getData();
        if (!(data instanceof SquareAvatarItem)) {
            data = null;
        }
        SquareAvatarItem squareAvatarItem = (SquareAvatarItem) data;
        if (squareAvatarItem == null || !SquareResourceManagerKt.hasSpecialState(squareAvatarItem)) {
            return;
        }
        startTargetAlphaAnimation(isInDetailMode(), viewHolder);
    }

    public SquareView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    @Override // com.tencent.state.map.BaseMapView
    /* renamed from: onCreateMapAdapter, reason: avoid collision after fix types in other method */
    protected SquareBaseAdapter onCreateMapAdapter2(List<MapItem> dataList, IMapLocator locator) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(locator, "locator");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return new SquareAreaRankAdapter(context, locator, dataList, new OnMoveCallback() { // from class: com.tencent.state.square.SquareView$onCreateMapAdapter$1
            @Override // com.tencent.state.square.layout.OnMoveCallback
            public void onMove(List<MoveCommand> commands) {
                OnMoveCallback onMoveCallback;
                Intrinsics.checkNotNullParameter(commands, "commands");
                onMoveCallback = SquareView.this.animator;
                if (onMoveCallback != null) {
                    onMoveCallback.onMove(commands);
                }
            }
        });
    }

    public /* synthetic */ SquareView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    private final void startTargetAlphaAnimation(final boolean isScaleToCenter, final MapViewHolder<?> targetHolder) {
        if (targetHolder != null) {
            if (isScaleToCenter) {
                View view = targetHolder.itemView;
                Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
                view.setAlpha(0.0f);
            }
            AnimationUtils animationUtils = AnimationUtils.INSTANCE;
            View view2 = targetHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
            animationUtils.startAlphaAnimation(view2, isScaleToCenter, 500L, new AnimatorListenerAdapter() { // from class: com.tencent.state.square.SquareView$startTargetAlphaAnimation$1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (isScaleToCenter) {
                        return;
                    }
                    View view3 = targetHolder.itemView;
                    Intrinsics.checkNotNullExpressionValue(view3, "holder.itemView");
                    view3.setAlpha(0.0f);
                }
            });
        }
    }

    @Override // com.tencent.state.map.BaseMapView
    protected IFilamentMapController onCreateFilamentMapViewUpdater(SquareFilamentMapView filamentMap) {
        if (filamentMap != null) {
            return new SquareFilamentViewController(filamentMap, new SquareView$onCreateFilamentMapViewUpdater$1$1(this));
        }
        return null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        SquareBackgroundView squareBackgroundView = new SquareBackgroundView(context, null, 0, 6, null);
        this.backgroundView = squareBackgroundView;
        BackgroundUtils backgroundUtils = BackgroundUtils.INSTANCE;
        backgroundUtils.setBackgroundGradientColor(squareBackgroundView, backgroundUtils.getDefaultGradient());
        MapContainer container = getContainer();
        View view = this.backgroundView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        container.addBackgroundView(view, layoutParams);
    }

    @Override // com.tencent.state.map.BaseMapView
    public boolean scaleToDetail(String uin) {
        return scaleToDetail(uin, 1, 8);
    }

    public static /* synthetic */ void openMeDetail$default(SquareView squareView, int i3, Object obj, int i16, Object obj2) {
        if ((i16 & 2) != 0) {
            obj = null;
        }
        squareView.openMeDetail(i3, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void scaleToDetailAmin$default(SquareView squareView, String str, int i3, Function0 function0, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            function0 = null;
        }
        squareView.scaleToDetailAmin(str, i3, function0);
    }
}
