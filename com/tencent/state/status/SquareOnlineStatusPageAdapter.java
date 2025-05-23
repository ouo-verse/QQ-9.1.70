package com.tencent.state.status;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.detail.DetailMeFragmentConfig;
import com.tencent.state.status.SquareOnlineStatusGridAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001a\b\u0002\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005\u00a2\u0006\u0002\u0010\tJ \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J(\u0010\u0014\u001a\u00020\u000f2\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00052\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0018\u001a\u00020\u0006J\u0018\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006J\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006J\u0018\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J$\u0010\"\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0$J\u0016\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0006J\u000e\u0010(\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u0006J \u0010)\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020 J\u000e\u0010+\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/tencent/state/status/SquareOnlineStatusPageAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "context", "Landroid/content/Context;", ISchemeApi.KEY_PAGE_DATA, "", "", "", "Lcom/tencent/state/status/StatusPanelData;", "(Landroid/content/Context;Ljava/util/Map;)V", "listener", "Lcom/tencent/state/status/SquareOnlineStatusGridAdapter$OnlineStatusClickListener;", "recyclerViewList", "Landroid/view/ViewGroup;", "destroyItem", "", ParseCommon.CONTAINER, "position", "obj", "", "fillListData", "map", "getCount", "getPositionData", "index", "getStatusPanelData", DetailMeFragmentConfig.CURRENT_STATUS_ID, DetailMeFragmentConfig.CURRENT_RICH_ID, "getStatusView", "Landroid/view/View;", "instantiateItem", "isViewFromObject", "", "view", "scrollSelect", "scrollCallBack", "Lkotlin/Function0;", "setDefaultSelectView", "curSelectId", "newStatusId", "updateLockIcon", "updateSelectView", "isClick", "updateSelected", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareOnlineStatusPageAdapter extends PagerAdapter {
    private final Context context;
    private SquareOnlineStatusGridAdapter.OnlineStatusClickListener listener;
    private Map<Integer, ? extends List<StatusPanelData>> pageData;
    private ViewGroup recyclerViewList;

    public /* synthetic */ SquareOnlineStatusPageAdapter(Context context, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? new HashMap() : map);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup r16, int position, Object obj) {
        Intrinsics.checkNotNullParameter(r16, "container");
        Intrinsics.checkNotNullParameter(obj, "obj");
        r16.removeView((View) obj);
    }

    public final void fillListData(Map<Integer, ? extends List<StatusPanelData>> map, SquareOnlineStatusGridAdapter.OnlineStatusClickListener listener) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.pageData = map;
        this.listener = listener;
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        return this.pageData.size();
    }

    public final List<StatusPanelData> getPositionData(int index) {
        List<StatusPanelData> emptyList;
        List<StatusPanelData> list = this.pageData.get(Integer.valueOf(index));
        if (list != null) {
            return list;
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final StatusPanelData getStatusPanelData(int r75, int r85) {
        StatusPanelData statusPanelData;
        Iterator<Map.Entry<Integer, ? extends List<StatusPanelData>>> it = this.pageData.entrySet().iterator();
        do {
            statusPanelData = null;
            if (!it.hasNext()) {
                break;
            }
            Iterator<T> it5 = it.next().getValue().iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Object next = it5.next();
                StatusPanelData statusPanelData2 = (StatusPanelData) next;
                if (statusPanelData2.getStatus().getTopStatusId() == r75 && statusPanelData2.getStatus().getRichStatus() == r85) {
                    statusPanelData = next;
                    break;
                }
            }
            statusPanelData = statusPanelData;
        } while (statusPanelData == null);
        return statusPanelData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View getStatusView(final int r46, final int r56) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        ViewGroup viewGroup = this.recyclerViewList;
        if (viewGroup != null) {
            ViewExtensionsKt.forEachChild(viewGroup, new Function1<View, Unit>() { // from class: com.tencent.state.status.SquareOnlineStatusPageAdapter$getStatusView$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (it instanceof RecyclerView) {
                        RecyclerView recyclerView = (RecyclerView) it;
                        RecyclerView.Adapter adapter = recyclerView.getAdapter();
                        if (!(adapter instanceof SquareOnlineStatusGridAdapter)) {
                            adapter = null;
                        }
                        SquareOnlineStatusGridAdapter squareOnlineStatusGridAdapter = (SquareOnlineStatusGridAdapter) adapter;
                        if (squareOnlineStatusGridAdapter != null) {
                            RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
                            int itemCount = adapter2 != null ? adapter2.getItemCount() : 0;
                            for (int i3 = 0; i3 < itemCount && recyclerView.getScrollState() == 0 && !recyclerView.isComputingLayout(); i3++) {
                                StatusPanelData indexData = squareOnlineStatusGridAdapter.getIndexData(i3);
                                if (indexData.getStatus().getTopStatusId() == r46 && indexData.getStatus().getRichStatus() == r56) {
                                    Ref.ObjectRef objectRef2 = objectRef;
                                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                                    objectRef2.element = layoutManager != null ? layoutManager.findViewByPosition(i3) : 0;
                                    return;
                                }
                            }
                        }
                    }
                }
            });
        }
        return (View) objectRef.element;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup r65, int position) {
        Integer num;
        Intrinsics.checkNotNullParameter(r65, "container");
        int i3 = 0;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.context, 4, 1, false);
        List<StatusPanelData> list = this.pageData.get(Integer.valueOf(position));
        SquareOnlineStatusGridAdapter squareOnlineStatusGridAdapter = new SquareOnlineStatusGridAdapter(this.context, list != null ? list : CollectionsKt__CollectionsKt.emptyList());
        SquareOnlineStatusGridAdapter.OnlineStatusClickListener onlineStatusClickListener = this.listener;
        if (onlineStatusClickListener != null) {
            squareOnlineStatusGridAdapter.setOnlineStatusClickListener(onlineStatusClickListener);
        }
        final RecyclerView recyclerView = new RecyclerView(this.context);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(squareOnlineStatusGridAdapter);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.tencent.state.status.SquareOnlineStatusPageAdapter$instantiateItem$1$1
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                outRect.bottom = ViewExtensionsKt.dip(RecyclerView.this.getContext(), 8);
                outRect.right = ViewExtensionsKt.dip(RecyclerView.this.getContext(), 8);
            }
        });
        r65.addView(recyclerView);
        this.recyclerViewList = r65;
        if (list != null) {
            Iterator<StatusPanelData> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i3 = -1;
                    break;
                }
                if (it.next().isSelect()) {
                    break;
                }
                i3++;
            }
            num = Integer.valueOf(i3);
        } else {
            num = null;
        }
        if (num != null) {
            recyclerView.scrollToPosition(num.intValue());
        }
        return recyclerView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(obj, "obj");
        return Intrinsics.areEqual(view, obj);
    }

    public final void scrollSelect(int r102, int r112, Function0<Unit> scrollCallBack) {
        View childAt;
        Intrinsics.checkNotNullParameter(scrollCallBack, "scrollCallBack");
        Iterator<Map.Entry<Integer, ? extends List<StatusPanelData>>> it = this.pageData.entrySet().iterator();
        int i3 = 0;
        int i16 = 0;
        while (it.hasNext()) {
            Iterator<T> it5 = it.next().getValue().iterator();
            int i17 = 0;
            while (true) {
                if (it5.hasNext()) {
                    Object next = it5.next();
                    int i18 = i17 + 1;
                    if (i17 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    StatusPanelData statusPanelData = (StatusPanelData) next;
                    if (statusPanelData.getStatus().getTopStatusId() == r102 && statusPanelData.getStatus().getRichStatus() == r112) {
                        i3 = statusPanelData.getPageIndex();
                        i16 = i17;
                        break;
                    }
                    i17 = i18;
                }
            }
        }
        ViewGroup viewGroup = this.recyclerViewList;
        if (viewGroup != null && (childAt = viewGroup.getChildAt(i3)) != null) {
            RecyclerView recyclerView = null;
            if (!(childAt instanceof RecyclerView)) {
                childAt = null;
            }
            RecyclerView recyclerView2 = (RecyclerView) childAt;
            if (recyclerView2 != null) {
                recyclerView2.scrollToPosition(i16);
                SquareBaseKt.getSquareThread().postOnUi(scrollCallBack);
                recyclerView = recyclerView2;
            }
            if (recyclerView != null) {
                return;
            }
        }
        SquareBaseKt.getSquareThread().postOnUi(scrollCallBack);
        Unit unit = Unit.INSTANCE;
    }

    public final void updateLockIcon(final int curSelectId) {
        ViewGroup viewGroup = this.recyclerViewList;
        if (viewGroup != null) {
            ViewExtensionsKt.forEachChild(viewGroup, new Function1<View, Unit>() { // from class: com.tencent.state.status.SquareOnlineStatusPageAdapter$updateLockIcon$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (it instanceof RecyclerView) {
                        RecyclerView recyclerView = (RecyclerView) it;
                        RecyclerView.Adapter adapter = recyclerView.getAdapter();
                        if (!(adapter instanceof SquareOnlineStatusGridAdapter)) {
                            adapter = null;
                        }
                        SquareOnlineStatusGridAdapter squareOnlineStatusGridAdapter = (SquareOnlineStatusGridAdapter) adapter;
                        if (squareOnlineStatusGridAdapter != null) {
                            RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
                            int itemCount = adapter2 != null ? adapter2.getItemCount() : 0;
                            for (int i3 = 0; i3 < itemCount && recyclerView.getScrollState() == 0 && !recyclerView.isComputingLayout(); i3++) {
                                StatusPanelData indexData = squareOnlineStatusGridAdapter.getIndexData(i3);
                                if (indexData.getStatus().getId() == curSelectId && indexData.getTaskInfo().getPrizeStatus() == PanelStatusTaskPrizeStatus.PRIZE_PENDING) {
                                    squareOnlineStatusGridAdapter.notifyItemChanged(i3, PanelItemUpdateEvent.UNLOCK_AVATAR_MOTION);
                                    indexData.getTaskInfo().setPrizeStatus(PanelStatusTaskPrizeStatus.PRIZE_VALID);
                                    return;
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    public final void updateSelected(int r56) {
        Iterator<Map.Entry<Integer, ? extends List<StatusPanelData>>> it = this.pageData.entrySet().iterator();
        while (it.hasNext()) {
            for (StatusPanelData statusPanelData : it.next().getValue()) {
                statusPanelData.setSelect(statusPanelData.getStatus().getId() == r56);
            }
        }
    }

    public SquareOnlineStatusPageAdapter(Context context, Map<Integer, ? extends List<StatusPanelData>> pageData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        this.context = context;
        this.pageData = pageData;
    }

    public final void setDefaultSelectView(int curSelectId, int newStatusId) {
        updateSelectView(curSelectId, newStatusId, true);
    }

    public final void updateSelectView(final int curSelectId, final int newStatusId, final boolean isClick) {
        ViewGroup viewGroup;
        if (curSelectId == newStatusId || (viewGroup = this.recyclerViewList) == null) {
            return;
        }
        ViewExtensionsKt.forEachChild(viewGroup, new Function1<View, Unit>() { // from class: com.tencent.state.status.SquareOnlineStatusPageAdapter$updateSelectView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it instanceof RecyclerView) {
                    RecyclerView recyclerView = (RecyclerView) it;
                    RecyclerView.Adapter adapter = recyclerView.getAdapter();
                    if (!(adapter instanceof SquareOnlineStatusGridAdapter)) {
                        adapter = null;
                    }
                    final SquareOnlineStatusGridAdapter squareOnlineStatusGridAdapter = (SquareOnlineStatusGridAdapter) adapter;
                    if (squareOnlineStatusGridAdapter != null) {
                        RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
                        int itemCount = adapter2 != null ? adapter2.getItemCount() : 0;
                        for (final int i3 = 0; i3 < itemCount && recyclerView.getScrollState() == 0 && !recyclerView.isComputingLayout(); i3++) {
                            StatusPanelData indexData = squareOnlineStatusGridAdapter.getIndexData(i3);
                            int id5 = indexData.getStatus().getId();
                            if (id5 == newStatusId) {
                                indexData.setSelect(true);
                                squareOnlineStatusGridAdapter.notifyItemChanged(i3, PanelItemUpdateEvent.UPDATE_SELECT_ITEM);
                                if (isClick) {
                                    SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.status.SquareOnlineStatusPageAdapter$updateSelectView$1.1
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
                                            SquareOnlineStatusGridAdapter.this.notifyItemChanged(i3, PanelItemUpdateEvent.CLICK_SELECT_ITEM);
                                        }
                                    });
                                }
                            } else if (id5 == curSelectId) {
                                indexData.setSelect(false);
                                squareOnlineStatusGridAdapter.notifyItemChanged(i3, PanelItemUpdateEvent.UPDATE_SELECT_ITEM);
                            } else {
                                indexData.setSelect(false);
                                squareOnlineStatusGridAdapter.notifyItemChanged(i3, PanelItemUpdateEvent.UPDATE_SELECT_ITEM);
                            }
                        }
                    }
                }
            }
        });
    }

    public static /* synthetic */ void updateSelectView$default(SquareOnlineStatusPageAdapter squareOnlineStatusPageAdapter, int i3, int i16, boolean z16, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            z16 = false;
        }
        squareOnlineStatusPageAdapter.updateSelectView(i3, i16, z16);
    }
}
