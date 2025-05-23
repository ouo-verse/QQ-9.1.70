package com.tencent.mobileqq.vas.hippy.view.waterfall;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.hippylist.RecyclerViewEventHelper;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyWaterfallView extends RecyclerView implements HippyViewBase {
    HippyArray C;
    private b D;
    private boolean E;
    private ViewTreeObserver.OnPreDrawListener F;
    private ViewTreeObserver G;

    /* renamed from: d, reason: collision with root package name */
    com.tencent.mobileqq.vas.hippy.view.waterfall.a f309531d;

    /* renamed from: e, reason: collision with root package name */
    private HippyEngineContext f309532e;

    /* renamed from: f, reason: collision with root package name */
    private NativeGestureDispatcher f309533f;

    /* renamed from: h, reason: collision with root package name */
    private Runnable f309534h;

    /* renamed from: i, reason: collision with root package name */
    boolean f309535i;

    /* renamed from: m, reason: collision with root package name */
    boolean f309536m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a extends HippyViewEvent {

        /* renamed from: a, reason: collision with root package name */
        public int f309539a;

        /* renamed from: b, reason: collision with root package name */
        public int f309540b;

        /* renamed from: c, reason: collision with root package name */
        public int f309541c;

        /* renamed from: d, reason: collision with root package name */
        public int f309542d;

        /* renamed from: e, reason: collision with root package name */
        public int f309543e;

        /* renamed from: f, reason: collision with root package name */
        public int f309544f;

        /* renamed from: g, reason: collision with root package name */
        public HippyArray f309545g;

        public a(int i3, int i16, int i17, int i18, int i19, int i26, int i27, HippyArray hippyArray) {
            super("onExposureReport");
            this.f309539a = i16;
            this.f309540b = i17;
            this.f309541c = i18;
            this.f309542d = i19;
            this.f309543e = i26;
            this.f309544f = i27;
            this.f309545g = hippyArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b extends HippyViewEvent {
        public b(String str) {
            super(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class c extends RecyclerViewBase.RecycledViewPool {
        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.RecycledViewPool
        public void putRecycledView(RecyclerViewBase.ViewHolder viewHolder, RecyclerViewBase.Adapter adapter) {
            int itemViewType = viewHolder.getItemViewType();
            ArrayList<RecyclerViewBase.ViewHolder> scrapHeapForType = getScrapHeapForType(itemViewType);
            if (this.mMaxScrap.get(itemViewType) <= scrapHeapForType.size()) {
                RecyclerViewBase.ViewHolder viewHolder2 = scrapHeapForType.get(0);
                scrapHeapForType.remove(0);
                if (adapter != null && (viewHolder2 instanceof RecyclerView.ViewHolderWrapper)) {
                    ((com.tencent.mobileqq.vas.hippy.view.waterfall.a) adapter).onViewAbandonHelper((RecyclerView.ViewHolderWrapper) viewHolder2);
                }
            }
            viewHolder.mPosition = Integer.MIN_VALUE;
            viewHolder.mOldPosition = Integer.MIN_VALUE;
            viewHolder.mItemId = -1L;
            viewHolder.clearFlagsForSharedPool();
            scrapHeapForType.add(viewHolder);
        }
    }

    public HippyWaterfallView(Context context) {
        super(context);
        this.f309534h = null;
        this.E = false;
        this.F = null;
        this.G = null;
        this.f309532e = ((HippyInstanceContext) context).getEngineContext();
        setLayoutManager(new HippyWaterfallLayoutManager(context));
        this.f309531d = new com.tencent.mobileqq.vas.hippy.view.waterfall.a(this, this, this.f309532e);
        setRecycledViewPool(new c());
        this.f309535i = true;
        this.f309536m = false;
        this.C = null;
        addOnListScrollListener(this.f309531d.getOnListScrollListener());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b h() {
        if (this.D == null) {
            this.D = new b(RecyclerViewEventHelper.INITIAL_LIST_READY);
        }
        return this.D;
    }

    private void traversalChildViewForSkinChange(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                traversalChildViewForSkinChange(viewGroup.getChildAt(i3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean enableOnSrollReport() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a g(int i3, int i16) {
        return this.f309531d.b(i3, i16);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public NativeGestureDispatcher getGestureDispatcher() {
        return this.f309533f;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    public void handleInTraversal(int i3, int i16, View view) {
        if (i3 == 1001) {
            traversalChildViewForSkinChange(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.E) {
            this.G = getViewTreeObserver();
            if (this.F == null) {
                this.F = new ViewTreeObserver.OnPreDrawListener() { // from class: com.tencent.mobileqq.vas.hippy.view.waterfall.HippyWaterfallView.4
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        if (HippyWaterfallView.this.f309531d.getItemCount() > 0 && HippyWaterfallView.this.getChildCount() > 0) {
                            HippyWaterfallView.this.G.removeOnPreDrawListener(this);
                            HippyWaterfallView.this.E = true;
                            HippyWaterfallView.this.post(new Runnable() { // from class: com.tencent.mobileqq.vas.hippy.view.waterfall.HippyWaterfallView.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    HippyWaterfallView.this.h().send(HippyWaterfallView.this, null);
                                }
                            });
                        }
                        return true;
                    }
                };
            }
            this.G.removeOnPreDrawListener(this.F);
            this.G.addOnPreDrawListener(this.F);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.F;
        if (onPreDrawListener != null && (viewTreeObserver = this.G) != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
        }
        super.onDetachedFromWindow();
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.OnScrollListener
    public void onScrollStateChanged(int i3, int i16) {
        super.onScrollStateChanged(i3, i16);
        if (getAdapter() != null) {
            this.f309531d.checkScrollForReport();
            this.f309531d.checkExposureForReport(i3, i16);
        }
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        NativeGestureDispatcher nativeGestureDispatcher = this.f309533f;
        if (nativeGestureDispatcher != null) {
            return onTouchEvent | nativeGestureDispatcher.handleTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    public void scrollToContentOffset(double d16, double d17, boolean z16) {
        scrollToPosition(0, (int) (-PixelUtil.dp2px(d17)));
        post(new Runnable() { // from class: com.tencent.mobileqq.vas.hippy.view.waterfall.HippyWaterfallView.3
            @Override // java.lang.Runnable
            public void run() {
                HippyWaterfallView.this.dispatchLayout();
            }
        });
    }

    public void scrollToIndex(int i3, int i16, boolean z16) {
        scrollToPosition(i16, 0);
        post(new Runnable() { // from class: com.tencent.mobileqq.vas.hippy.view.waterfall.HippyWaterfallView.2
            @Override // java.lang.Runnable
            public void run() {
                HippyWaterfallView.this.dispatchLayout();
            }
        });
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase, com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.RefreshableCallback
    public void scrollToTopAtOnce() {
        super.scrollToTopAtOnce();
    }

    public void setEnableExposureReport(boolean z16) {
        this.f309531d.setEnableExposureReport(z16);
    }

    public void setEnableScrollForReport(boolean z16) {
        this.f309531d.setEnableScrollForReport(z16);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public void setGestureDispatcher(NativeGestureDispatcher nativeGestureDispatcher) {
        this.f309533f = nativeGestureDispatcher;
    }

    public void setListData() {
        if (getAdapter() == null) {
            setAdapter(this.f309531d);
        }
        this.f309531d.notifyDataSetChanged();
        if (this.f309534h == null) {
            this.f309534h = new Runnable() { // from class: com.tencent.mobileqq.vas.hippy.view.waterfall.HippyWaterfallView.1
                @Override // java.lang.Runnable
                public void run() {
                    HippyWaterfallView.this.dispatchLayout();
                }
            };
        }
        removeCallbacks(this.f309534h);
        post(this.f309534h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLoadingStatus(int i3, String str) {
        this.f309531d.setLoadingStatus(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPreloadItemNumber(int i3) {
        this.f309531d.setPreloadItemNumber(i3);
    }

    public void setPreloadPixel(int i3) {
        this.f309531d.f(i3);
    }

    public void setRefreshColors(HippyArray hippyArray) {
        this.C = hippyArray;
    }

    public void setRefreshEnabled(boolean z16) {
        this.f309536m = z16;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    protected boolean shouldStopOnInterceptTouchEvent(MotionEvent motionEvent, int i3, boolean z16) {
        if (this.mOffsetY >= 0 && getHeight() <= i3) {
            return false;
        }
        return !z16;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    protected boolean shouldStopOnTouchEvent(MotionEvent motionEvent, int i3, boolean z16) {
        if (this.mOffsetY >= 0 && getHeight() <= i3) {
            return false;
        }
        return !z16;
    }

    public void startLoadMore() {
        this.f309531d.a().send(this, null);
        this.f309531d.setLoadingStatus(1);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    public void checkNotifyFooterAppearWithFewChild(int i3) {
    }
}
