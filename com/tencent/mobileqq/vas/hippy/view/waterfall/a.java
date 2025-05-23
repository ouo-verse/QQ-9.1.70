package com.tencent.mobileqq.vas.hippy.view.waterfall;

import android.util.Log;
import android.view.View;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippy.qq.view.viola.list.TkdListView;
import com.tencent.mobileqq.vas.hippy.view.waterfall.HippyWaterfallView;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.list.HippyListAdapter;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a extends HippyListAdapter {
    private int C;
    private boolean D;
    private int E;
    protected boolean F;
    private boolean G;
    private boolean H;
    private RecyclerView.OnListScrollListener I;
    private int J;

    /* renamed from: d, reason: collision with root package name */
    private final HippyWaterfallView f309547d;

    /* renamed from: e, reason: collision with root package name */
    private final HippyEngineContext f309548e;

    /* renamed from: f, reason: collision with root package name */
    private HippyViewEvent f309549f;

    /* renamed from: h, reason: collision with root package name */
    private HippyViewEvent f309550h;

    /* renamed from: i, reason: collision with root package name */
    private HippyViewEvent f309551i;

    /* renamed from: m, reason: collision with root package name */
    private HippyViewEvent f309552m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b extends HippyViewEvent {

        /* renamed from: a, reason: collision with root package name */
        String f309554a;

        public b(String str) {
            super(str);
            this.f309554a = str;
        }

        @Override // com.tencent.mtt.hippy.uimanager.HippyViewEvent
        public void send(View view, Object obj) {
            super.send(view, obj);
        }
    }

    public a(HippyWaterfallView hippyWaterfallView, RecyclerView recyclerView, HippyEngineContext hippyEngineContext) {
        super(recyclerView, hippyEngineContext);
        this.f309547d = hippyWaterfallView;
        this.f309548e = hippyEngineContext;
        setLoadingStatus(1);
    }

    private HippyViewEvent c() {
        if (this.f309550h == null) {
            this.f309550h = new b("onFooterAppeared");
        }
        return this.f309550h;
    }

    private HippyViewEvent d() {
        if (this.f309551i == null) {
            this.f309551i = new b(HippyScrollViewEventHelper.EVENT_TYPE_REFRESH);
        }
        return this.f309551i;
    }

    private HippyViewEvent e() {
        if (this.f309552m == null) {
            this.f309552m = new b("onScrollForReport");
        }
        return this.f309552m;
    }

    private void sendOnScrollForReport(int i3, int i16, int i17, int i18, int i19, HippyArray hippyArray) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushInt(HippyTKDListViewAdapter.START_EDGE_POS, i3);
        hippyMap.pushInt(HippyTKDListViewAdapter.END_EDGE_POS, i16);
        hippyMap.pushInt(HippyTKDListViewAdapter.FIRST_VISIBLE_ROW_INDEX, i17);
        hippyMap.pushInt(HippyTKDListViewAdapter.LAST_VISIBLE_ROW_INDEX, i18);
        hippyMap.pushInt(HippyTKDListViewAdapter.SCROLL_STATE, i19);
        hippyMap.pushArray(HippyTKDListViewAdapter.VISIBLE_ROW_FRAMES, hippyArray);
        e().send(this.mParentRecyclerView, hippyMap);
    }

    public HippyViewEvent a() {
        if (this.f309549f == null) {
            this.f309549f = new b("onEndReached");
        }
        return this.f309549f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HippyWaterfallView.a b(int i3, int i16) {
        if (!this.H || this.mParentRecyclerView.mViewFlinger.getScroller() == null) {
            return null;
        }
        int px2dp = (int) PixelUtil.px2dp(this.mParentRecyclerView.mOffsetY);
        int px2dp2 = (int) PixelUtil.px2dp(this.mParentRecyclerView.getHeight() + this.mParentRecyclerView.mOffsetY);
        int findFirstVisibleItemPosition = ((HippyWaterfallLayoutManager) this.mParentRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = ((HippyWaterfallLayoutManager) this.mParentRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
        HippyArray hippyArray = new HippyArray();
        for (int i17 = findFirstVisibleItemPosition; i17 <= findLastVisibleItemPosition; i17++) {
            View findViewByPosition = this.mParentRecyclerView.getLayoutManager().findViewByPosition(i17);
            if (findViewByPosition != null) {
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushInt(HippyTKDListViewAdapter.X, findViewByPosition.getLeft());
                hippyMap.pushInt("y", findViewByPosition.getTop() + this.f309547d.mOffsetY);
                hippyMap.pushInt("width", (int) PixelUtil.px2dp(getItemWidth(i17)));
                hippyMap.pushInt("height", (int) PixelUtil.px2dp(getItemHeight(i17)));
                hippyArray.pushMap(hippyMap);
            }
        }
        return new HippyWaterfallView.a(this.mParentRecyclerView.getId(), px2dp, px2dp2, findFirstVisibleItemPosition, findLastVisibleItemPosition, (int) Math.abs(this.mParentRecyclerView.mViewFlinger.getScroller().getCurrVelocity()), i16, hippyArray);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int calcPreloadThresholdWithItemNumber() {
        if (this.D) {
            int itemCount = getItemCount() - this.C;
            if (itemCount < 0) {
                itemCount = 0;
            }
            this.E = 0;
            for (int itemCount2 = getItemCount() - 1; itemCount2 >= itemCount; itemCount2--) {
                this.E += getItemHeight(itemCount2);
            }
            this.D = false;
        }
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkExposureForReport(int i3, int i16) {
        HippyWaterfallView.a g16;
        if (this.H && (g16 = this.f309547d.g(i3, i16)) != null && checkNeedToReport(g16.f309543e, i16)) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt(HippyTKDListViewAdapter.START_EDGE_POS, g16.f309539a);
            hippyMap.pushInt(HippyTKDListViewAdapter.END_EDGE_POS, g16.f309540b);
            hippyMap.pushInt(HippyTKDListViewAdapter.FIRST_VISIBLE_ROW_INDEX, g16.f309541c);
            hippyMap.pushInt(HippyTKDListViewAdapter.LAST_VISIBLE_ROW_INDEX, g16.f309542d);
            hippyMap.pushInt(HippyTKDListViewAdapter.SCROLL_STATE, g16.f309544f);
            hippyMap.pushArray(HippyTKDListViewAdapter.VISIBLE_ROW_FRAMES, g16.f309545g);
            g16.send(this.mParentRecyclerView, hippyMap);
        }
    }

    protected boolean checkNeedToReport(float f16, int i3) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkScrollForReport() {
        if (!this.G) {
            return;
        }
        int px2dp = (int) PixelUtil.px2dp(this.mParentRecyclerView.mOffsetY);
        int px2dp2 = (int) PixelUtil.px2dp(this.mParentRecyclerView.getHeight() + this.mParentRecyclerView.mOffsetY);
        int findFirstVisibleItemPosition = ((HippyWaterfallLayoutManager) this.mParentRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = ((HippyWaterfallLayoutManager) this.mParentRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
        if (this.mParentRecyclerView.mViewFlinger.getScroller() == null) {
            return;
        }
        float abs = Math.abs(this.mParentRecyclerView.mViewFlinger.getScroller().getCurrVelocity());
        int scrollState = this.mParentRecyclerView.getScrollState();
        HippyArray hippyArray = new HippyArray();
        for (int i3 = findFirstVisibleItemPosition; i3 <= findLastVisibleItemPosition; i3++) {
            View findViewByPosition = this.mParentRecyclerView.getLayoutManager().findViewByPosition(i3);
            if (findViewByPosition != null) {
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushInt(HippyTKDListViewAdapter.X, findViewByPosition.getLeft());
                hippyMap.pushInt("y", findViewByPosition.getTop() + this.f309547d.mOffsetY);
                hippyMap.pushInt("width", (int) PixelUtil.px2dp(getItemWidth(i3)));
                hippyMap.pushInt("height", (int) PixelUtil.px2dp(getItemHeight(i3)));
                hippyArray.pushMap(hippyMap);
            }
        }
        handleCurrentScrollStateInner(px2dp, px2dp2, findFirstVisibleItemPosition, findLastVisibleItemPosition, abs, scrollState, hippyArray);
    }

    public void f(int i3) {
        this.J = i3;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int getHeightBefore(int i3) {
        return ((HippyWaterfallLayoutManager) this.f309547d.getLayoutManager()).getHeightBefore(i3);
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int getItemHeight(int i3) {
        return super.getItemHeight(i3) + ((HippyWaterfallLayoutManager) this.mParentRecyclerView.getLayoutManager()).getItemGap();
    }

    public RecyclerView.OnListScrollListener getOnListScrollListener() {
        if (this.I == null) {
            this.I = new C8911a();
        }
        return this.I;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int getPreloadThresholdInPixels() {
        return this.J;
    }

    public View getRecyclerItemView(int i3) {
        ArrayList arrayList;
        try {
            Class<? super Object> superclass = getClass().getSuperclass();
            Objects.requireNonNull(superclass);
            Field declaredField = superclass.getDeclaredField("mListViewHolder");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            if (obj instanceof ArrayList) {
                arrayList = (ArrayList) obj;
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                if (i3 < arrayList.size()) {
                    return ((RecyclerViewBase.ViewHolder) arrayList.get(i3)).mContent;
                }
                return this.mParentRecyclerView.getChildAt(i3 - arrayList.size());
            }
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
        } catch (NoSuchFieldException e17) {
            e17.printStackTrace();
        }
        return null;
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int getTotalHeight() {
        int totalHeight = ((HippyWaterfallLayoutManager) this.f309547d.getLayoutManager()).getTotalHeight();
        this.mContentHeight = totalHeight;
        return totalHeight;
    }

    void handleCurrentScrollStateInner(int i3, int i16, int i17, int i18, float f16, int i19, HippyArray hippyArray) {
        if ((i19 == 0 || i19 == 1) && checkNeedToReport(0.0f, i19)) {
            sendOnScrollForReport(i3, i16, i17, i18, i19, hippyArray);
        } else if (f16 < this.mParentRecyclerView.getHeight() * 2) {
            checkNeedToReport(f16, i19);
        }
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public boolean hasCustomRecycler() {
        return true;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void notifyDataSetChanged() {
        setPreloadItemNumber(getPreloadThresholdInItemNumber());
        super.notifyDataSetChanged();
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void notifyLastFooterAppeared() {
        super.notifyLastFooterAppeared();
        int i3 = this.mLoadingStatus;
        if (i3 != 1 && i3 != 100 && i3 != 6) {
            setLoadingStatus(1);
        }
        if (!this.F) {
            int preloadThresholdInPixels = getPreloadThresholdInPixels();
            int preloadThresholdInItemNumber = getPreloadThresholdInItemNumber();
            if (preloadThresholdInPixels > 0 || preloadThresholdInItemNumber > 0) {
                a().send(this.mParentRecyclerView, null);
            }
        }
        if (this.mLoadingStatus == 1) {
            c().send(this.mParentRecyclerView, null);
        }
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void onPreload() {
        this.F = true;
        a().send(this.mParentRecyclerView, null);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void onSuddenStop() {
        checkScrollForReport();
    }

    public void onViewAbandonHelper(RecyclerView.ViewHolderWrapper viewHolderWrapper) {
        onViewAbandon(viewHolderWrapper);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setEnableExposureReport(boolean z16) {
        this.H = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setEnableScrollForReport(boolean z16) {
        this.G = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLoadingStatus(int i3, String str) {
        if (i3 != 1) {
            setLoadingStatus(i3);
            View view = this.mDefaultLoadingView;
            if (view != null) {
                view.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.mDefaultLoadingView.getHeight(), 1073741824));
                View view2 = this.mDefaultLoadingView;
                view2.layout(view2.getLeft(), this.mDefaultLoadingView.getTop(), this.mDefaultLoadingView.getRight(), this.mDefaultLoadingView.getBottom());
                this.mDefaultLoadingView.invalidate();
            }
            this.F = false;
            return;
        }
        setLoadingStatus(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.views.list.HippyListAdapter
    public void setPreloadItemNumber(int i3) {
        super.setPreloadItemNumber(i3);
        this.C = i3;
        this.D = true;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void startRefreshData() {
        d().send(this.mParentRecyclerView, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.vas.hippy.view.waterfall.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public class C8911a implements RecyclerView.OnListScrollListener {
        C8911a() {
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener
        public void onDragEnd() {
            Log.d("HippyWaterfallAdapter", "onDragEnd");
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener
        public void onScroll(int i3, int i16) {
            RecyclerView recyclerView = a.this.mParentRecyclerView;
            if ((recyclerView instanceof HippyWaterfallView) && ((HippyWaterfallView) recyclerView).enableOnSrollReport()) {
                a.this.checkScrollForReport();
            }
            Log.d("HippyWaterfallAdapter", "onScroll position:" + i3 + " scrollY:" + i16);
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener
        public void onScrollEnd() {
            Log.d("HippyWaterfallAdapter", TkdListView.EVENT_TYPE_SCROLL_END);
            a.this.checkScrollForReport();
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener
        public void onStartDrag() {
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener
        public void onStartFling() {
        }
    }
}
