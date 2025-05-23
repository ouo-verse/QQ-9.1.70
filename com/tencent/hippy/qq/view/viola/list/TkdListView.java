package com.tencent.hippy.qq.view.viola.list;

import android.content.Context;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.list.HippyListAdapter;
import com.tencent.mtt.hippy.views.list.HippyListView;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;

/* compiled from: P */
/* loaded from: classes7.dex */
public class TkdListView extends HippyListView implements RecyclerView.OnListScrollListener {
    public static final String EVENT_TYPE_DRAG_END = "onDragEnd";
    public static final String EVENT_TYPE_SCROLL_END = "onScrollEnd";
    private boolean mIsLoading;
    private int mPreloadDistance;
    private Promise mPromise;
    protected int mScrollMinOffset;

    public TkdListView(Context context) {
        super(context);
        this.mPreloadDistance = 0;
        this.mScrollMinOffset = 0;
        this.mIsLoading = false;
        this.mPromise = null;
        addOnListScrollListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.views.list.HippyListView
    public HippyMap generateScrollEvent() {
        HippyMap hippyMap = new HippyMap();
        HippyMap hippyMap2 = new HippyMap();
        HippyMap hippyMap3 = new HippyMap();
        if (this.mLayout.canScrollHorizontally()) {
            hippyMap.pushInt(HippyTKDListViewAdapter.X, (int) PixelUtil.px2dp(this.mOffsetX - this.mState.mCustomHeaderWidth));
            hippyMap.pushInt("y", (int) PixelUtil.px2dp(0.0f));
            hippyMap2.pushInt("width", (int) PixelUtil.px2dp(this.mState.mTotalHeight));
            hippyMap2.pushInt("height", (int) PixelUtil.px2dp(getHeight()));
            hippyMap3.pushInt(HippyTKDListViewAdapter.X, (int) PixelUtil.px2dp(getX()));
            hippyMap3.pushInt("y", (int) PixelUtil.px2dp(getY()));
            hippyMap3.pushInt("width", (int) PixelUtil.px2dp(getWidth()));
            hippyMap3.pushInt("height", (int) PixelUtil.px2dp(getHeight()));
        } else {
            hippyMap.pushInt(HippyTKDListViewAdapter.X, (int) PixelUtil.px2dp(0.0f));
            hippyMap.pushInt("y", (int) PixelUtil.px2dp(this.mOffsetY - this.mState.mCustomHeaderHeight));
            hippyMap2.pushInt("width", (int) PixelUtil.px2dp(getWidth()));
            hippyMap2.pushInt("height", (int) PixelUtil.px2dp(this.mState.mTotalHeight));
            hippyMap3.pushInt(HippyTKDListViewAdapter.X, (int) PixelUtil.px2dp(getX()));
            hippyMap3.pushInt("y", (int) PixelUtil.px2dp(getY()));
            hippyMap3.pushInt("width", (int) PixelUtil.px2dp(getWidth()));
            hippyMap3.pushInt("height", (int) PixelUtil.px2dp(getHeight()));
        }
        HippyMap hippyMap4 = new HippyMap();
        hippyMap4.pushMap("contentOffset", hippyMap);
        hippyMap4.pushMap("contentSize", hippyMap2);
        hippyMap4.pushMap(AIInput.KEY_FRAME, hippyMap3);
        return hippyMap4;
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener
    public void onDragEnd() {
        new HippyListView.OnScrollEvent("onDragEnd").send(this, null);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener
    public void onScrollEnd() {
        new HippyListView.OnScrollEvent(EVENT_TYPE_SCROLL_END).send(this, null);
        if (this.mPromise != null) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushString("msg", "on scroll end!");
            this.mPromise.resolve(hippyMap);
            this.mPromise = null;
        }
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListView, com.tencent.mtt.supportui.views.recyclerview.RecyclerView, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.OnScrollListener
    public void onScrolled(int i3, int i16) {
        super.onScrolled(i3, i16);
        this.mAdapter.notifyEndReached();
    }

    public void scrollWithDistance(int i3, int i16, Promise promise) {
        if (!this.mState.didStructureChange()) {
            if (this.mLayout.canScrollHorizontally()) {
                this.mViewFlinger.smoothScrollBy(i3, 0, i16, true);
            } else {
                this.mViewFlinger.smoothScrollBy(0, i3, i16, true);
            }
            this.mPromise = promise;
        }
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListView
    protected void sendOnScrollEvent() {
        if (this.mScrollEventEnable) {
            long currentTimeMillis = System.currentTimeMillis();
            int i3 = this.mScrollMinOffset;
            if (i3 > 0) {
                if (this.mLayout.canScrollHorizontally()) {
                    if (this.mLastOffsetX == Integer.MIN_VALUE) {
                        this.mLastOffsetX = this.mState.mCustomHeaderWidth;
                    }
                    int i16 = this.mOffsetX;
                    if (i16 - this.mLastOffsetX >= this.mScrollMinOffset) {
                        this.mLastOffsetX = i16;
                        getOnScrollEvent().send(this, generateScrollEvent());
                        return;
                    }
                    return;
                }
                if (this.mLastOffsetY == Integer.MIN_VALUE) {
                    this.mLastOffsetY = this.mState.mCustomHeaderHeight;
                }
                int i17 = this.mOffsetY;
                if (i17 - this.mLastOffsetY >= this.mScrollMinOffset) {
                    this.mLastOffsetY = i17;
                    getOnScrollEvent().send(this, generateScrollEvent());
                    return;
                }
                return;
            }
            if (i3 == 0 && currentTimeMillis - this.mLastScrollEventTimeStamp >= this.mScrollEventThrottle) {
                this.mLastScrollEventTimeStamp = currentTimeMillis;
                getOnScrollEvent().send(this, generateScrollEvent());
            }
        }
    }

    public void setIsLoading(boolean z16) {
        this.mIsLoading = z16;
    }

    public void setPreloadDistance(int i3) {
        this.mPreloadDistance = (int) PixelUtil.dp2px(Math.max(0, i3));
    }

    public void setScrollMinOffset(int i3) {
        this.mScrollMinOffset = (int) PixelUtil.dp2px(Math.max(200, i3));
    }

    public boolean shouldEmitEndReachedEvent() {
        if (this.mLayout.canScrollHorizontally()) {
            if ((this.mState.mTotalHeight - this.mOffsetX) - getWidth() <= this.mPreloadDistance) {
                return true;
            }
            return false;
        }
        if ((this.mState.mTotalHeight - this.mOffsetY) - getHeight() <= this.mPreloadDistance) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.views.list.HippyListView
    public HippyListAdapter createAdapter(RecyclerView recyclerView, HippyEngineContext hippyEngineContext) {
        return new TkdListViewAdapter(recyclerView, hippyEngineContext);
    }

    public TkdListView(Context context, int i3) {
        super(context, i3);
        this.mPreloadDistance = 0;
        this.mScrollMinOffset = 0;
        this.mIsLoading = false;
        this.mPromise = null;
        addOnListScrollListener(this);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener
    public void onStartDrag() {
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener
    public void onStartFling() {
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener
    public void onScroll(int i3, int i16) {
    }
}
