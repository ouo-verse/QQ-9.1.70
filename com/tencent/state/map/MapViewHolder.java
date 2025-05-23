package com.tencent.state.map;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.state.map.BaseMapView;
import com.tencent.state.map.MapItem;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.utils.ViewHolderRecycleChecker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 U*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001UB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010%\u001a\u00020&2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011J\u001e\u0010%\u001a\u00020&2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u0011J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016J\u001d\u0010,\u001a\u00020&2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u0011H$\u00a2\u0006\u0002\u0010-J%\u0010,\u001a\u00020&2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u0011H\u0014\u00a2\u0006\u0002\u0010.J\u001a\u0010/\u001a\u00020&2\u0006\u00100\u001a\u00020\u00112\n\b\u0002\u00101\u001a\u0004\u0018\u000102J\b\u00103\u001a\u00020\u0017H\u0004J\b\u00104\u001a\u00020&H\u0016J\u0018\u00105\u001a\u00020&2\u0006\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u0017H\u0016J\u0018\u00108\u001a\u00020&2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H&J\b\u00109\u001a\u00020&H\u0017J\u0010\u0010:\u001a\u00020&2\u0006\u0010;\u001a\u00020\u0017H\u0016J/\u0010<\u001a\u00020&2\u0006\u0010=\u001a\u00020\u00112\u0006\u0010>\u001a\u00020)2\u0006\u0010?\u001a\u00020\u00172\b\u0010@\u001a\u0004\u0018\u00010\u0017H\u0016\u00a2\u0006\u0002\u0010AJ\u001f\u0010B\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u00a2\u0006\u0002\u0010CJ\b\u0010D\u001a\u00020&H\u0017J\b\u0010E\u001a\u00020\u0017H\u0016J\u0010\u0010F\u001a\u00020&2\u0006\u0010G\u001a\u00020\u0017H\u0016J\b\u0010H\u001a\u00020&H\u0017J\b\u0010I\u001a\u00020&H\u0016J\u000e\u0010J\u001a\u00020&2\u0006\u0010*\u001a\u00020KJ\u0010\u0010L\u001a\u00020&2\u0006\u0010M\u001a\u00020\"H\u0017J\u0010\u0010N\u001a\u00020&2\u0006\u0010O\u001a\u00020\u0017H\u0016J\u0017\u0010P\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\u0002H$\u00a2\u0006\u0002\u0010QJ\u0016\u0010R\u001a\u00020S*\u00020K2\b\u0010T\u001a\u0004\u0018\u00010SH\u0002R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00018\u00002\b\u0010\u000b\u001a\u0004\u0018\u00018\u0000@BX\u0086\u000e\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u001a\u0010\u001e\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0011@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0013\u00a8\u0006V"}, d2 = {"Lcom/tencent/state/map/MapViewHolder;", "T", "Lcom/tencent/state/map/MapItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "controller", "Lcom/tencent/state/map/MapItemController;", "getController", "()Lcom/tencent/state/map/MapItemController;", "<set-?>", "data", "getData", "()Lcom/tencent/state/map/MapItem;", "Lcom/tencent/state/map/MapItem;", "index", "", "getIndex", "()I", "setIndex", "(I)V", "isInAnim", "", "()Z", "setInAnim", "(Z)V", "lastViewTypeForCache", "getLastViewTypeForCache", "setLastViewTypeForCache", "locationRepeat", "getLocationRepeat", "setLocationRepeat", "ownerAdapter", "Lcom/tencent/state/map/MapAdapter;", "viewType", "getViewType", "bind", "", "event", "calculateElevation", "", "location", "Lcom/tencent/state/map/Location;", "doBind", "(Lcom/tencent/state/map/MapItem;I)V", "(Lcom/tencent/state/map/MapItem;II)V", "doScaleToDetail", "viewId", "extra", "", "isMapMinimum", "onBackFromDetail", "onCenterScaled", "isScaleToCenter", "isAnimeEnd", "onFirstScreenCompleted", "onInVisible", "onMapMinimum", "isMin", "onMapZoomEnd", "zoomLevel", "scale", "isZoomIn", "doMinView", "(IFZLjava/lang/Boolean;)V", "onPreBind", "(Lcom/tencent/state/map/MapItem;I)Lcom/tencent/state/map/MapItem;", "onRecycled", "onScaleToDetail", "onVisibilityChanged", "isVisible", "onVisible", "onZoomOverOut", "setLayoutParams", "Landroid/graphics/Rect;", "setMapAdapter", "adapter", "setRepeat", "repeat", "transform", "(Lcom/tencent/state/map/MapItem;)Lcom/tencent/state/map/MapItem;", "getLayoutParams", "Lcom/tencent/state/map/BaseMapView$LayoutParams;", "lp", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public abstract class MapViewHolder<T extends MapItem> extends RecyclerView.ViewHolder {
    private static final String TAG = "MapViewHolder";
    private T data;
    private int index;
    private boolean isInAnim;
    private int lastViewTypeForCache;
    private boolean locationRepeat;
    private MapAdapter ownerAdapter;
    private int viewType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.index = -1;
        this.lastViewTypeForCache = -1;
    }

    private final T onPreBind(MapItem data, int index) {
        T transform = transform(data);
        if (transform == null) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "bind data type is not valid", null, 4, null);
            return transform;
        }
        this.index = index;
        this.data = transform;
        this.viewType = transform.getType();
        return transform;
    }

    public final void bind(MapItem data, int index) {
        IMapViewListener listener;
        Intrinsics.checkNotNullParameter(data, "data");
        this.lastViewTypeForCache = data.getType();
        T onPreBind = onPreBind(data, index);
        if (onPreBind != null) {
            MapItemController controller = getController();
            if (controller != null) {
                Location itemLocation = controller.getLocator().getItemLocation(index);
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                itemView.setElevation(calculateElevation(itemLocation));
                if (controller.getExposure().canExposure(onPreBind)) {
                    controller.getExposure().doExposure(onPreBind);
                }
            }
            doBind(onPreBind, index);
            MapItemController controller2 = getController();
            if (controller2 == null || (listener = controller2.getListener()) == null) {
                return;
            }
            listener.onItemBind(this, index, data);
        }
    }

    public float calculateElevation(Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        if (this.locationRepeat) {
            return 0.0f;
        }
        return location.getCenterY();
    }

    protected abstract void doBind(T data, int index);

    /* JADX INFO: Access modifiers changed from: protected */
    public void doBind(T data, int index, int event) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public final void doScaleToDetail(int viewId, Object extra) {
        MapItemController controller;
        IMapViewListener listener;
        if (!onScaleToDetail() || (controller = getController()) == null || (listener = controller.getListener()) == null) {
            return;
        }
        listener.onItemClicked(this, this.index, this.data, viewId, extra);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MapItemController getController() {
        MapAdapter mapAdapter = this.ownerAdapter;
        if (mapAdapter != null) {
            return mapAdapter.getController();
        }
        return null;
    }

    public final T getData() {
        return this.data;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getLastViewTypeForCache() {
        return this.lastViewTypeForCache;
    }

    public final boolean getLocationRepeat() {
        return this.locationRepeat;
    }

    public final int getViewType() {
        return this.viewType;
    }

    /* renamed from: isInAnim, reason: from getter */
    public final boolean getIsInAnim() {
        return this.isInAnim;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isMapMinimum() {
        IMapItemViewManager viewManager;
        MapItemController controller = getController();
        return (controller == null || (viewManager = controller.getViewManager()) == null || viewManager.getCurrentZoomLevel() != 0) ? false : true;
    }

    public abstract void onFirstScreenCompleted(MapItem data, int index);

    public void onInVisible() {
        IMapViewListener listener;
        MapItemController controller = getController();
        if (controller == null || (listener = controller.getListener()) == null) {
            return;
        }
        listener.onInVisible(this, this.index, this.data);
    }

    public void onRecycled() {
        IMapViewListener listener;
        MapItemController controller = getController();
        if (controller != null && (listener = controller.getListener()) != null) {
            listener.onItemRecycled(this, this.index, this.data);
        }
        ViewHolderRecycleChecker.INSTANCE.onHolderRecycle(this);
        this.index = -1;
        this.data = null;
        this.ownerAdapter = null;
        this.isInAnim = false;
        this.locationRepeat = false;
    }

    public boolean onScaleToDetail() {
        IMapViewManipulator manipulator;
        MapItemController controller = getController();
        if (controller != null && controller.getBlockClick()) {
            return false;
        }
        MapItemController controller2 = getController();
        if (controller2 != null) {
            controller2.setBlockClick(true);
        }
        MapItemController controller3 = getController();
        if (controller3 != null && (manipulator = controller3.getManipulator()) != null) {
            manipulator.scaleToCenter(this);
        }
        return true;
    }

    public void onVisible() {
        IMapViewListener listener;
        MapItemController controller = getController();
        if (controller == null || (listener = controller.getListener()) == null) {
            return;
        }
        listener.onVisible(this, this.index, this.data);
    }

    public final void setInAnim(boolean z16) {
        this.isInAnim = z16;
    }

    public final void setIndex(int i3) {
        this.index = i3;
    }

    public final void setLastViewTypeForCache(int i3) {
        this.lastViewTypeForCache = i3;
    }

    public final void setLayoutParams(Rect location) {
        Intrinsics.checkNotNullParameter(location, "location");
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
        if (!(layoutParams instanceof BaseMapView.LayoutParams)) {
            layoutParams = null;
        }
        View itemView2 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
        BaseMapView.LayoutParams layoutParams2 = getLayoutParams(location, (BaseMapView.LayoutParams) layoutParams);
        layoutParams2.setHolder(this);
        Unit unit = Unit.INSTANCE;
        itemView2.setLayoutParams(layoutParams2);
    }

    public final void setLocationRepeat(boolean z16) {
        this.locationRepeat = z16;
    }

    public void setMapAdapter(MapAdapter adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.ownerAdapter = adapter;
    }

    protected abstract T transform(MapItem data);

    private final BaseMapView.LayoutParams getLayoutParams(Rect rect, BaseMapView.LayoutParams layoutParams) {
        if (layoutParams == null) {
            BaseMapView.LayoutParams layoutParams2 = new BaseMapView.LayoutParams(rect.width(), rect.height());
            ((FrameLayout.LayoutParams) layoutParams2).leftMargin = rect.left;
            ((FrameLayout.LayoutParams) layoutParams2).topMargin = rect.top;
            return layoutParams2;
        }
        ((FrameLayout.LayoutParams) layoutParams).width = rect.width();
        ((FrameLayout.LayoutParams) layoutParams).height = rect.height();
        ((FrameLayout.LayoutParams) layoutParams).leftMargin = rect.left;
        ((FrameLayout.LayoutParams) layoutParams).topMargin = rect.top;
        return layoutParams;
    }

    public void onMapZoomEnd(int zoomLevel, float scale, boolean isZoomIn, Boolean doMinView) {
        if (doMinView != null) {
            doMinView.booleanValue();
            onMapMinimum(doMinView.booleanValue());
        }
    }

    public static /* synthetic */ void doScaleToDetail$default(MapViewHolder mapViewHolder, int i3, Object obj, int i16, Object obj2) {
        if (obj2 == null) {
            if ((i16 & 2) != 0) {
                obj = null;
            }
            mapViewHolder.doScaleToDetail(i3, obj);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doScaleToDetail");
    }

    public final void bind(MapItem data, int index, int event) {
        IMapViewListener listener;
        Intrinsics.checkNotNullParameter(data, "data");
        T onPreBind = onPreBind(data, index);
        if (onPreBind != null) {
            doBind(onPreBind, index, event);
            MapItemController controller = getController();
            if (controller == null || (listener = controller.getListener()) == null) {
                return;
            }
            listener.onItemBind(this, index, data, event);
        }
    }

    public void onBackFromDetail() {
    }

    public void onZoomOverOut() {
    }

    public void onMapMinimum(boolean isMin) {
    }

    public void onVisibilityChanged(boolean isVisible) {
    }

    public void setRepeat(boolean repeat) {
    }

    public void onCenterScaled(boolean isScaleToCenter, boolean isAnimeEnd) {
    }
}
