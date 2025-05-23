package com.tencent.state.map;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.map.BaseMapView;
import com.tencent.state.map.IMapItemViewManager;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.filamentmap.IFilamentMapController;
import com.tencent.state.utils.SquareSwitchUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0001IB%\u0012\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u00030\u0004j\u0002`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\rH\u0016J\u0018\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\rH\u0016J\n\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\rH\u0016J\u0010\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\rH\u0016J\u001c\u00100\u001a\u000e\u0012\u0002\b\u0003\u0018\u000101j\u0004\u0018\u0001`22\u0006\u0010\"\u001a\u00020\rH\u0016J\b\u00103\u001a\u00020\u0019H\u0016J\u001c\u00104\u001a\u00020\r2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u001906H\u0016J\u000e\u00107\u001a\u00020)2\u0006\u00108\u001a\u00020\rJ\u0010\u00109\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\rH\u0016J\u0010\u00109\u001a\u00020\u00192\u0006\u0010:\u001a\u00020;H\u0016J\u001a\u0010<\u001a\u00020)2\u0006\u0010\"\u001a\u00020\r2\b\u0010=\u001a\u0004\u0018\u00010>H\u0002J\"\u0010?\u001a\u00020)2\u0006\u0010@\u001a\u00020\r2\u0006\u0010A\u001a\u00020\r2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u0018\u0010B\u001a\u00020)2\u0006\u0010@\u001a\u00020\r2\u0006\u0010A\u001a\u00020\rH\u0016J\u000e\u0010C\u001a\u00020)2\u0006\u0010D\u001a\u00020\u0019J\u0006\u0010E\u001a\u00020)J\u0018\u0010F\u001a\u00020)2\u000e\u0010G\u001a\n\u0012\u0002\b\u000301j\u0002`2H\u0016J\u0010\u0010F\u001a\u00020)2\u0006\u0010\"\u001a\u00020\rH\u0016J\u0010\u0010H\u001a\u00020)2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\n\u0012\u0002\b\u00030\u0004j\u0002`\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u000f\u00a8\u0006J"}, d2 = {"Lcom/tencent/state/map/MapViewDataObserver;", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "Lcom/tencent/state/map/IMapItemViewManager;", "square", "Lcom/tencent/state/map/BaseMapView;", "Lcom/tencent/state/map/MapView;", "adapter", "Lcom/tencent/state/map/MapAdapter;", "locator", "Lcom/tencent/state/map/IMapLocator;", "(Lcom/tencent/state/map/BaseMapView;Lcom/tencent/state/map/MapAdapter;Lcom/tencent/state/map/IMapLocator;)V", "inScreenIndexSet", "", "", "getInScreenIndexSet", "()Ljava/util/Set;", "inViewPortPercent", "", "inVisibleIndexSet", "indexViewList", "Landroid/util/SparseArray;", "Landroid/view/View;", "getIndexViewList", "()Landroid/util/SparseArray;", "isMapViewVisible", "", "listener", "Lcom/tencent/state/map/IMapItemViewChangedListener;", "outScreenIndexSet", "recycler", "Lcom/tencent/state/map/MapRecycler;", "visibleIndexSet", "getVisibleIndexSet", "addView", "index", "data", "Lcom/tencent/state/map/MapItem;", "checkLocationInScreen", "location", "Landroid/graphics/Rect;", "checkRecycleAndFill", "", "getCurrentZoomLevel", "getFilamentMapController", "Lcom/tencent/state/square/filamentmap/IFilamentMapController;", "getMeIndex", "getTypeItemCount", "type", "getViewHolder", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "getWelcomeScaleAnimDone", "indexOf", "block", "Lkotlin/Function1;", "initialize", "avatarCount", "isMostInScreen", "uin", "", "onItemChanged", "payload", "", "onItemRangeChanged", "positionStart", "itemCount", "onItemRangeInserted", "onVisibilityChanged", NodeProps.VISIBLE, "recycleAllViews", "recycleView", "holder", "setViewChangedListener", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class MapViewDataObserver extends RecyclerView.AdapterDataObserver implements IMapItemViewManager {
    private static final String TAG = "MapViewDataObserver";
    private final MapAdapter adapter;
    private final Set<Integer> inScreenIndexSet;
    private final float inViewPortPercent;
    private final Set<Integer> inVisibleIndexSet;
    private final SparseArray<View> indexViewList;
    private boolean isMapViewVisible;
    private IMapItemViewChangedListener listener;
    private final IMapLocator locator;
    private final Set<Integer> outScreenIndexSet;
    private final MapRecycler recycler;
    private final BaseMapView<?> square;
    private final Set<Integer> visibleIndexSet;

    public MapViewDataObserver(BaseMapView<?> square, MapAdapter adapter, IMapLocator locator) {
        Intrinsics.checkNotNullParameter(square, "square");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(locator, "locator");
        this.square = square;
        this.adapter = adapter;
        this.locator = locator;
        this.inScreenIndexSet = new LinkedHashSet();
        this.outScreenIndexSet = new LinkedHashSet();
        this.visibleIndexSet = new LinkedHashSet();
        this.inVisibleIndexSet = new LinkedHashSet();
        this.inViewPortPercent = SquareSwitchUtils.INSTANCE.enableFilamentIndex() ? 0.1f : 0.5f;
        this.indexViewList = new SparseArray<>();
        this.recycler = new MapRecycler(square, adapter, locator);
        this.isMapViewVisible = true;
    }

    private final void onItemChanged(int index, Object payload) {
        View view;
        MapViewHolder<?> mapViewHolder;
        if (!getInScreenIndexSet().contains(Integer.valueOf(index)) || (view = getIndexViewList().get(index)) == null || (mapViewHolder = MapViewKt.getMapViewHolder(view)) == null) {
            return;
        }
        List<Object> mutableListOf = payload != null ? CollectionsKt__CollectionsKt.mutableListOf(payload) : null;
        if (mutableListOf != null) {
            SquareBaseKt.getSquareLog().i(TAG, "onItemChanged: index=" + index + ", payloads=" + payload);
            this.adapter.onBindViewHolder2(mapViewHolder, index, mutableListOf);
            return;
        }
        if (mapViewHolder.getViewType() == this.adapter.getItemViewType(index)) {
            SquareBaseKt.getSquareLog().i(TAG, "onItemChanged: index=" + index + ", no payloads");
            this.adapter.onBindViewHolder(mapViewHolder, index);
            return;
        }
        SquareBaseKt.getSquareLog().i(TAG, "onItemChanged: index=" + index + ", viewType changed");
        recycleView(mapViewHolder);
        addView(index);
    }

    @Override // com.tencent.state.map.IMapItemViewManager
    public View addView(final int index) {
        final View viewForIndex = this.recycler.getViewForIndex(index);
        getIndexViewList().put(index, viewForIndex);
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.map.MapViewDataObserver$addView$1
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
                BaseMapView baseMapView;
                MapAdapter mapAdapter;
                ViewParent parent = viewForIndex.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(viewForIndex);
                }
                baseMapView = MapViewDataObserver.this.square;
                baseMapView.getContainer().addView(viewForIndex, 0);
                if (SquareBaseKt.getSquareLog().isColorLevel()) {
                    SquareLogger squareLog = SquareBaseKt.getSquareLog();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("addView index: ");
                    sb5.append(index);
                    sb5.append(", ");
                    mapAdapter = MapViewDataObserver.this.adapter;
                    MapItem itemData = mapAdapter.getItemData(index);
                    sb5.append(itemData != null ? Integer.valueOf(itemData.getType()) : null);
                    squareLog.d("MapViewDataObserver", sb5.toString());
                }
            }
        });
        return viewForIndex;
    }

    @Override // com.tencent.state.map.IMapItemViewManager
    public boolean checkLocationInScreen(Rect location) {
        Intrinsics.checkNotNullParameter(location, "location");
        if (!this.isMapViewVisible) {
            SquareBaseKt.getSquareLog().d(TAG, "checkLocationInScreen: not visible");
            return false;
        }
        return IMapLocatorKt.isInViewPort(this.locator, location, -this.square.getScrollX(), -this.square.getScrollY());
    }

    @Override // com.tencent.state.map.IMapItemViewManager
    public void checkRecycleAndFill() {
        if (!this.isMapViewVisible) {
            SquareBaseKt.getSquareLog().d(TAG, "checkRecycleAndFill: not visible");
            return;
        }
        if (!getWelcomeScaleAnimDone()) {
            SquareBaseKt.getSquareLog().d(TAG, "checkRecycleAndFill: not welcomeScaleAnimDone");
            return;
        }
        if (SquareBaseKt.getSquareLog().isColorLevel()) {
            SquareBaseKt.getSquareLog().i(TAG, "do checkRecycleAndFill");
        }
        Iterator<Integer> it = getInScreenIndexSet().iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (!IMapLocatorKt.isInViewPort(this.locator, this.square.getItemLocation(intValue), -this.square.getScrollX(), -this.square.getScrollY())) {
                recycleView(intValue);
                this.outScreenIndexSet.add(Integer.valueOf(intValue));
                it.remove();
                IMapItemViewChangedListener iMapItemViewChangedListener = this.listener;
                if (iMapItemViewChangedListener != null) {
                    iMapItemViewChangedListener.onScreenOut(intValue);
                }
            }
        }
        Iterator<Integer> it5 = getVisibleIndexSet().iterator();
        while (it5.hasNext()) {
            int intValue2 = it5.next().intValue();
            if (!IMapLocatorKt.isInViewPortPercentile(this.locator, this.square.getItemLocation(intValue2), this.inViewPortPercent, -this.square.getScrollX(), -this.square.getScrollY())) {
                this.inVisibleIndexSet.add(Integer.valueOf(intValue2));
                it5.remove();
                IMapItemViewChangedListener iMapItemViewChangedListener2 = this.listener;
                if (iMapItemViewChangedListener2 != null) {
                    iMapItemViewChangedListener2.onInVisible(intValue2);
                }
            }
        }
        Iterator<Integer> it6 = this.outScreenIndexSet.iterator();
        while (it6.hasNext()) {
            int intValue3 = it6.next().intValue();
            if (IMapLocatorKt.isInViewPort(this.locator, this.square.getItemLocation(intValue3), -this.square.getScrollX(), -this.square.getScrollY())) {
                addView(intValue3);
                getInScreenIndexSet().add(Integer.valueOf(intValue3));
                it6.remove();
                IMapItemViewChangedListener iMapItemViewChangedListener3 = this.listener;
                if (iMapItemViewChangedListener3 != null) {
                    iMapItemViewChangedListener3.onScreenIn(intValue3);
                }
            }
        }
        Iterator<Integer> it7 = this.inVisibleIndexSet.iterator();
        while (it7.hasNext()) {
            int intValue4 = it7.next().intValue();
            if (IMapLocatorKt.isInViewPortPercentile(this.locator, this.square.getItemLocation(intValue4), this.inViewPortPercent, -this.square.getScrollX(), -this.square.getScrollY())) {
                getVisibleIndexSet().add(Integer.valueOf(intValue4));
                it7.remove();
                IMapItemViewChangedListener iMapItemViewChangedListener4 = this.listener;
                if (iMapItemViewChangedListener4 != null) {
                    iMapItemViewChangedListener4.onVisible(intValue4);
                }
            }
        }
    }

    @Override // com.tencent.state.map.IMapItemViewManager
    public int getCurrentZoomLevel() {
        return this.square.getCurrentZoomLevel();
    }

    @Override // com.tencent.state.map.IMapItemViewManager
    public IFilamentMapController getFilamentMapController() {
        return this.square.getFilamentMapController();
    }

    @Override // com.tencent.state.map.IMapItemViewManager
    public Set<Integer> getInScreenIndexSet() {
        return this.inScreenIndexSet;
    }

    @Override // com.tencent.state.map.IMapItemViewManager
    public SparseArray<View> getIndexViewList() {
        return this.indexViewList;
    }

    @Override // com.tencent.state.map.IMapItemViewManager
    public int getMeIndex() {
        return this.adapter.getMeIndex();
    }

    @Override // com.tencent.state.map.IMapItemViewManager
    public int getTypeItemCount(final int type) {
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 0;
        this.adapter.forEachItemData(new Function2<Integer, MapItem, Unit>() { // from class: com.tencent.state.map.MapViewDataObserver$getTypeItemCount$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, MapItem mapItem) {
                invoke(num.intValue(), mapItem);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, MapItem mapItem) {
                if (mapItem == null || mapItem.getType() != type) {
                    return;
                }
                intRef.element++;
            }
        });
        return intRef.element;
    }

    @Override // com.tencent.state.map.IMapItemViewManager
    public MapViewHolder<?> getViewHolder(int index) {
        View view = getIndexViewList().get(index);
        if (view != null) {
            return MapViewKt.getMapViewHolder(view);
        }
        return null;
    }

    @Override // com.tencent.state.map.IMapItemViewManager
    public Set<Integer> getVisibleIndexSet() {
        return this.visibleIndexSet;
    }

    @Override // com.tencent.state.map.IMapItemViewManager
    public boolean getWelcomeScaleAnimDone() {
        MapItemController controller = this.adapter.getController();
        return controller != null && controller.getIsWelcomeScaleAnimDone();
    }

    @Override // com.tencent.state.map.IMapDataIndexer
    public int indexOf(MapItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return IMapItemViewManager.DefaultImpls.indexOf(this, data);
    }

    @Override // com.tencent.state.map.IMapDataIndexer
    public int indexOfUnitType(String uin, int i3) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return IMapItemViewManager.DefaultImpls.indexOfUnitType(this, uin, i3);
    }

    public final void initialize(int avatarCount) {
        IntRange until;
        Set set;
        Set minus;
        IntRange until2;
        Set set2;
        Set minus2;
        String joinToString$default;
        Boolean valueOf = Boolean.valueOf(Square.INSTANCE.getConfig().getNeedScaleAnimation());
        List<Integer> list = null;
        if (!(valueOf.booleanValue() && getFilamentMapController() != null)) {
            valueOf = null;
        }
        if (valueOf != null) {
            valueOf.booleanValue();
            list = IMapLocatorKt.findIndexesInViewPortPercentile(this.locator, 2.0f);
        }
        getInScreenIndexSet().addAll(list != null ? list : IMapLocatorKt.findIndexesInViewPort(this.locator));
        Set<Integer> visibleIndexSet = getVisibleIndexSet();
        if (list == null) {
            list = IMapLocatorKt.findIndexesInViewPortPercentile(this.locator, this.inViewPortPercent);
        }
        visibleIndexSet.addAll(list);
        Set<Integer> set3 = this.outScreenIndexSet;
        until = RangesKt___RangesKt.until(0, avatarCount);
        set = CollectionsKt___CollectionsKt.toSet(until);
        minus = SetsKt___SetsKt.minus(set, (Iterable) getInScreenIndexSet());
        set3.addAll(minus);
        Set<Integer> set4 = this.inVisibleIndexSet;
        until2 = RangesKt___RangesKt.until(0, avatarCount);
        set2 = CollectionsKt___CollectionsKt.toSet(until2);
        minus2 = SetsKt___SetsKt.minus(set2, (Iterable) getVisibleIndexSet());
        set4.addAll(minus2);
        Iterator<T> it = getInScreenIndexSet().iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            addView(intValue);
            IMapItemViewChangedListener iMapItemViewChangedListener = this.listener;
            if (iMapItemViewChangedListener != null) {
                iMapItemViewChangedListener.onScreenIn(intValue);
            }
        }
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("initialize: inScreenIndexSet=");
        sb5.append(getInScreenIndexSet().size());
        sb5.append(", inScreenIndexSet: ");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(getInScreenIndexSet(), ", ", null, null, 0, null, null, 62, null);
        sb5.append(joinToString$default);
        squareLog.i(TAG, sb5.toString());
    }

    @Override // com.tencent.state.map.IMapItemViewManager
    public boolean isMostInScreen(int index) {
        return IMapLocatorKt.isInViewPortPercentile(this.locator, this.locator.getItemPosition(index), this.inViewPortPercent, this.square.getScrollX(), this.square.getScrollY());
    }

    public final void onVisibilityChanged(boolean visible) {
        MapViewHolder<?> mapViewHolder;
        this.isMapViewVisible = visible;
        Iterator<T> it = getInScreenIndexSet().iterator();
        while (it.hasNext()) {
            View view = getIndexViewList().get(((Number) it.next()).intValue());
            if (view != null && (mapViewHolder = MapViewKt.getMapViewHolder(view)) != null) {
                mapViewHolder.onVisibilityChanged(visible);
            }
        }
    }

    public final void recycleAllViews() {
        Iterator<T> it = getInScreenIndexSet().iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            recycleView(intValue);
            IMapItemViewChangedListener iMapItemViewChangedListener = this.listener;
            if (iMapItemViewChangedListener != null) {
                iMapItemViewChangedListener.onScreenOut(intValue);
            }
        }
    }

    @Override // com.tencent.state.map.IMapItemViewManager
    public void recycleView(int index) {
        IFilamentMapController filamentMapController;
        View view = getIndexViewList().get(index);
        if (view != null) {
            ViewExtensionsKt.updateLayoutParams(view, new Function1<BaseMapView.LayoutParams, Unit>() { // from class: com.tencent.state.map.MapViewDataObserver$recycleView$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(BaseMapView.LayoutParams layoutParams) {
                    invoke2(layoutParams);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(BaseMapView.LayoutParams receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    ((FrameLayout.LayoutParams) receiver).width = 0;
                    ((FrameLayout.LayoutParams) receiver).height = 0;
                    ((FrameLayout.LayoutParams) receiver).topMargin = 0;
                    ((FrameLayout.LayoutParams) receiver).leftMargin = 0;
                }
            });
            getIndexViewList().remove(index);
            this.square.getContainer().removeView(view);
            this.recycler.recycleView(index, view);
            if (SquareBaseKt.getSquareLog().isColorLevel()) {
                SquareLogger squareLog = SquareBaseKt.getSquareLog();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("recycleView index: ");
                sb5.append(index);
                sb5.append(", ");
                MapItem itemData = this.adapter.getItemData(index);
                sb5.append(itemData != null ? Integer.valueOf(itemData.getType()) : null);
                squareLog.d(TAG, sb5.toString());
            }
            MapItem itemData2 = this.adapter.getItemData(index);
            if (itemData2 == null || (filamentMapController = this.square.getFilamentMapController()) == null) {
                return;
            }
            IFilamentMapController.DefaultImpls.removeItem$default(filamentMapController, itemData2, false, (Function2) null, 6, (Object) null);
        }
    }

    @Override // com.tencent.state.map.IMapItemViewManager
    public void setViewChangedListener(IMapItemViewChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    @Override // com.tencent.state.map.IMapDataIndexer
    public int indexOf(String uin, int i3) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return IMapItemViewManager.DefaultImpls.indexOf(this, uin, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeInserted(int positionStart, int itemCount) {
        IntRange until;
        int collectionSizeOrDefault;
        until = RangesKt___RangesKt.until(positionStart, itemCount + positionStart);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(until, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((IntIterator) it).nextInt()));
        }
        this.outScreenIndexSet.addAll(arrayList);
        this.inVisibleIndexSet.addAll(arrayList);
        checkRecycleAndFill();
    }

    @Override // com.tencent.state.map.IMapDataIndexer
    public int indexOf(String uin, int i3, int i16) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return IMapItemViewManager.DefaultImpls.indexOf(this, uin, i3, i16);
    }

    @Override // com.tencent.state.map.IMapItemViewManager
    public View addView(final int index, MapItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        final View viewForIndex = this.recycler.getViewForIndex(index, data);
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.map.MapViewDataObserver$addView$2
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
                BaseMapView baseMapView;
                MapAdapter mapAdapter;
                ViewParent parent = viewForIndex.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(viewForIndex);
                }
                baseMapView = MapViewDataObserver.this.square;
                baseMapView.getContainer().addView(viewForIndex);
                if (SquareBaseKt.getSquareLog().isColorLevel()) {
                    SquareLogger squareLog = SquareBaseKt.getSquareLog();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("addView index&item: ");
                    sb5.append(index);
                    sb5.append(", ");
                    mapAdapter = MapViewDataObserver.this.adapter;
                    MapItem itemData = mapAdapter.getItemData(index);
                    sb5.append(itemData != null ? Integer.valueOf(itemData.getType()) : null);
                    squareLog.d("MapViewDataObserver", sb5.toString());
                }
            }
        });
        return viewForIndex;
    }

    @Override // com.tencent.state.map.IMapDataIndexer
    public int indexOf(Function1<? super MapItem, Boolean> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return this.adapter.indexOf(block);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
        int i3 = itemCount + positionStart;
        while (positionStart < i3) {
            onItemChanged(positionStart, payload);
            positionStart++;
        }
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [com.tencent.state.map.MapItem] */
    @Override // com.tencent.state.map.IMapItemViewManager
    public boolean isMostInScreen(String uin) {
        ?? data;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Iterator<Integer> it = getInScreenIndexSet().iterator();
        while (it.hasNext()) {
            MapViewHolder<?> viewHolder = getViewHolder(it.next().intValue());
            if (viewHolder != null && (data = viewHolder.getData()) != 0 && uin.equals(data.getUin())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.tencent.state.map.MapItem] */
    @Override // com.tencent.state.map.IMapItemViewManager
    public void recycleView(MapViewHolder<?> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        getIndexViewList().remove(holder.getIndex());
        this.square.getContainer().removeView(holder.itemView);
        this.recycler.recycleView(holder);
        if (SquareBaseKt.getSquareLog().isColorLevel()) {
            SquareLogger squareLog = SquareBaseKt.getSquareLog();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("recycleView holder: ");
            sb5.append(holder.getIndex());
            sb5.append(", ");
            ?? data = holder.getData();
            sb5.append(data != 0 ? Integer.valueOf(data.getType()) : null);
            squareLog.d(TAG, sb5.toString());
        }
    }
}
