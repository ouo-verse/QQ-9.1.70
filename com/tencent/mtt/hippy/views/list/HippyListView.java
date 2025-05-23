package com.tencent.mtt.hippy.views.list;

import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.hippylist.RecyclerViewEventHelper;
import com.tencent.mtt.hippy.views.refresh.HippyPullFooterView;
import com.tencent.mtt.hippy.views.refresh.HippyPullHeaderView;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager;
import com.tencent.mtt.supportui.views.recyclerview.LinearLayoutManager;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewItem;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyListView extends RecyclerView implements HippyViewBase {
    public static final String EVENT_TYPE_FOOTER_PULLING = "onFooterPulling";
    public static final String EVENT_TYPE_FOOTER_RELEASED = "onFooterReleased";
    public static final String EVENT_TYPE_HEADER_PULLING = "onHeaderPulling";
    public static final String EVENT_TYPE_HEADER_RELEASED = "onHeaderReleased";
    public static final int REFRESH_STATE_IDLE = 0;
    public static final int REFRESH_STATE_LOADING = 1;
    private boolean hasCompleteFirstBatch;
    private int initialContentOffset;
    private boolean isTvPlatform;
    protected final boolean mEnableRefresh;
    protected boolean mExposureEventEnable;
    private HippyListViewFocusHelper mFocusHelper;
    protected int mFooterRefreshState;
    private NativeGestureDispatcher mGestureDispatcher;
    private boolean mHasRemovePreDraw;
    protected boolean mHasUnsentScrollEvent;
    protected int mHeaderRefreshState;
    private HippyEngineContext mHippyContext;
    protected int mLastOffsetX;
    protected int mLastOffsetY;
    protected long mLastScrollEventTimeStamp;
    private RecyclerAdapter mListAdapter;
    protected boolean mMomentumScrollBeginEventEnable;
    protected boolean mMomentumScrollEndEventEnable;
    private OnInitialListReadyEvent mOnInitialListReadyEvent;
    private OnScrollDragEndedEvent mOnScrollDragEndedEvent;
    private OnScrollDragStartedEvent mOnScrollDragStartedEvent;
    private OnScrollEvent mOnScrollEvent;
    private OnScrollFlingEndedEvent mOnScrollFlingEndedEvent;
    private OnScrollFlingStartedEvent mOnScrollFlingStartedEvent;
    private ViewTreeObserver.OnPreDrawListener mPreDrawListener;
    protected boolean mScrollBeginDragEventEnable;
    protected boolean mScrollEnable;
    protected boolean mScrollEndDragEventEnable;
    protected boolean mScrollEventEnable;
    protected int mScrollEventThrottle;
    private ViewTreeObserver mViewTreeObserver;
    private float touchDownX;
    private float touchDownY;
    private int touchSlop;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class OnInitialListReadyEvent extends HippyViewEvent {
        public OnInitialListReadyEvent(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class OnScrollDragEndedEvent extends HippyViewEvent {
        public OnScrollDragEndedEvent(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class OnScrollDragStartedEvent extends HippyViewEvent {
        public OnScrollDragStartedEvent(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class OnScrollEvent extends HippyViewEvent {
        public OnScrollEvent(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class OnScrollFlingEndedEvent extends HippyViewEvent {
        public OnScrollFlingEndedEvent(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class OnScrollFlingStartedEvent extends HippyViewEvent {
        public OnScrollFlingStartedEvent(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class PullElementEvent extends HippyViewEvent {
        public PullElementEvent(String str) {
            super(str);
        }
    }

    public HippyListView(Context context) {
        super(context);
        this.mHeaderRefreshState = 0;
        this.mFooterRefreshState = 0;
        this.mEnableRefresh = true;
        this.mScrollBeginDragEventEnable = false;
        this.mScrollEndDragEventEnable = false;
        this.mMomentumScrollBeginEventEnable = false;
        this.mMomentumScrollEndEventEnable = false;
        this.mScrollEventEnable = true;
        this.mScrollEnable = true;
        this.mExposureEventEnable = false;
        this.initialContentOffset = 0;
        this.hasCompleteFirstBatch = false;
        this.mScrollEventThrottle = 400;
        this.mLastOffsetX = Integer.MIN_VALUE;
        this.mLastOffsetY = Integer.MIN_VALUE;
        this.mLastScrollEventTimeStamp = -1L;
        this.mHasRemovePreDraw = false;
        this.mPreDrawListener = null;
        this.mViewTreeObserver = null;
        this.mFocusHelper = null;
        init(context, 1);
    }

    private void dispatchExposureEvent() {
        BaseLayoutManager.OrientationHelper orientationHelper;
        int i3;
        RecyclerViewBase.LayoutManager layoutManager = this.mLayout;
        if (!(layoutManager instanceof BaseLayoutManager) || (orientationHelper = ((BaseLayoutManager) layoutManager).mOrientationHelper) == null) {
            return;
        }
        int childCount = getChildCount();
        if (this.mLayout.canScrollHorizontally()) {
            i3 = this.mState.mCustomHeaderWidth;
        } else {
            i3 = this.mState.mCustomHeaderHeight;
        }
        int startAfterPadding = orientationHelper.getStartAfterPadding() + i3;
        int endAfterPadding = orientationHelper.getEndAfterPadding() - i3;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            int decoratedStart = orientationHelper.getDecoratedStart(childAt);
            int decoratedEnd = orientationHelper.getDecoratedEnd(childAt);
            if (childAt instanceof RecyclerViewItem) {
                RecyclerViewItem recyclerViewItem = (RecyclerViewItem) childAt;
                if (recyclerViewItem.getChildCount() > 0) {
                    checkExposureView(recyclerViewItem.getChildAt(0), startAfterPadding, endAfterPadding, decoratedStart, decoratedEnd);
                }
            }
        }
    }

    private HippyMap getItemViewProps(int i3) {
        RenderNode renderNode;
        HippyEngineContext hippyEngineContext = this.mHippyContext;
        if (hippyEngineContext == null || (renderNode = hippyEngineContext.getRenderManager().getRenderNode(i3)) == null) {
            return null;
        }
        return renderNode.getProps();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OnInitialListReadyEvent getOnInitialListReadyEvent() {
        if (this.mOnInitialListReadyEvent == null) {
            this.mOnInitialListReadyEvent = new OnInitialListReadyEvent(RecyclerViewEventHelper.INITIAL_LIST_READY);
        }
        return this.mOnInitialListReadyEvent;
    }

    private void init(Context context, int i3) {
        this.mHippyContext = ((HippyInstanceContext) context).getEngineContext();
        setLayoutManager(new LinearLayoutManager(context, i3, false));
        setRepeatableSuspensionMode(false);
        RecyclerAdapter createAdapter = createAdapter(this, this.mHippyContext);
        this.mListAdapter = createAdapter;
        setAdapter(createAdapter);
        boolean isRunningOnTVPlatform = this.mHippyContext.isRunningOnTVPlatform();
        this.isTvPlatform = isRunningOnTVPlatform;
        if (isRunningOnTVPlatform) {
            this.mFocusHelper = new HippyListViewFocusHelper(this);
            setFocusableInTouchMode(true);
        }
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0022, code lost:
    
        if (r2 < 0) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void scrollToInitContentOffset() {
        int i3;
        RecyclerAdapter recyclerAdapter = this.mListAdapter;
        if (recyclerAdapter == null) {
            return;
        }
        int itemCount = recyclerAdapter.getItemCount();
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (true) {
            i3 = this.initialContentOffset;
            if (i17 >= i3 || i18 >= itemCount) {
                break;
            }
            i17 += this.mListAdapter.getItemHeight(i18);
            i18++;
        }
        int i19 = itemCount - 1;
        int i26 = i17 - i3;
        if (i18 >= i19) {
            i18 = i19;
        }
        i16 = i26;
        scrollToPosition(i18, i16);
    }

    private boolean shouldStopReleaseGlowsForHorizontal(boolean z16) {
        int totalHeight = this.mAdapter.getTotalHeight();
        if (this.mOffsetX > 0 && getWidth() <= totalHeight - this.mState.mCustomHeaderWidth) {
            int width = totalHeight - getWidth();
            RecyclerViewBase.State state = this.mState;
            int i3 = width + state.mCustomFooterWidth;
            if (totalHeight - state.mCustomHeaderWidth < getWidth() || this.mOffsetX >= i3) {
                if (this.mFooterRefreshState == 0) {
                    sendPullFooterEvent("onFooterReleased", new HippyMap());
                    this.mFooterRefreshState = 1;
                }
                View customFooterView = getCustomFooterView();
                if ((customFooterView instanceof HippyPullFooterView) && ((HippyPullFooterView) customFooterView).getStickEnabled()) {
                    smoothScrollBy(i3 - this.mOffsetX, 0, false, true);
                    return true;
                }
            }
            return false;
        }
        if (this.mHeaderRefreshState == 0 && z16) {
            sendPullHeaderEvent("onHeaderReleased", new HippyMap());
            this.mHeaderRefreshState = 1;
        }
        int i16 = this.mOffsetX;
        if (i16 < 0) {
            smoothScrollBy(-i16, 0, false, true);
        }
        return true;
    }

    private boolean shouldStopReleaseGlowsForVertical(boolean z16) {
        int totalHeight = this.mAdapter.getTotalHeight();
        if (getOffsetY() > 0 && getHeight() <= totalHeight - this.mState.mCustomHeaderHeight) {
            int height = totalHeight - getHeight();
            RecyclerViewBase.State state = this.mState;
            int i3 = height + state.mCustomFooterHeight;
            if (totalHeight - state.mCustomHeaderHeight < getHeight() || getOffsetY() >= i3) {
                if (this.mFooterRefreshState == 0) {
                    sendPullFooterEvent("onFooterReleased", new HippyMap());
                    this.mFooterRefreshState = 1;
                }
                View customFooterView = getCustomFooterView();
                if ((customFooterView instanceof HippyPullFooterView) && ((HippyPullFooterView) customFooterView).getStickEnabled()) {
                    smoothScrollBy(0, i3 - this.mOffsetY, false, true);
                    return true;
                }
            }
            return false;
        }
        if (this.mHeaderRefreshState == 0 && z16) {
            sendPullHeaderEvent("onHeaderReleased", new HippyMap());
            this.mHeaderRefreshState = 1;
        }
        if (getOffsetY() < 0) {
            smoothScrollBy(0, -this.mOffsetY, false, true);
        }
        return true;
    }

    protected void checkExposureView(View view, int i3, int i16, int i17, int i18) {
        int top;
        int bottom;
        int height;
        int i19;
        if (!(view instanceof HippyListItemView)) {
            return;
        }
        if (this.mLayout.canScrollHorizontally()) {
            top = view.getLeft();
        } else {
            top = view.getTop();
        }
        if (this.mLayout.canScrollHorizontally()) {
            bottom = view.getRight();
        } else {
            bottom = view.getBottom();
        }
        int i26 = top + i17;
        int i27 = bottom + i17;
        HippyListItemView hippyListItemView = (HippyListItemView) view;
        HippyMap itemViewProps = getItemViewProps(hippyListItemView.getId());
        if (itemViewProps == null) {
            return;
        }
        int exposureState = hippyListItemView.getExposureState();
        if (this.mLayout.canScrollHorizontally()) {
            height = view.getWidth();
        } else {
            height = view.getHeight();
        }
        int ceil = (int) Math.ceil(height * 0.1f);
        if (i27 > i3 + ceil && i26 < i16 - ceil) {
            if ((i26 < i3 && i27 > i3) || (i26 < i16 && i27 > i16)) {
                if (exposureState == 1) {
                    sendExposureEvent(view, HippyListItemView.EXPOSURE_EVENT_WILL_DISAPPEAR, itemViewProps);
                    i19 = 3;
                } else if (exposureState == 2) {
                    sendExposureEvent(view, "onWillAppear", itemViewProps);
                    i19 = 0;
                } else {
                    return;
                }
                hippyListItemView.setExposureState(i19);
                return;
            }
            if (((i26 >= i3 && i27 <= i16) || (i26 <= i3 && i27 > i16)) && hippyListItemView.getExposureState() != 1) {
                if (hippyListItemView.getExposureState() == 2) {
                    sendExposureEvent(view, "onWillAppear", itemViewProps);
                }
                sendExposureEvent(view, HippyListItemView.EXPOSURE_EVENT_APPEAR, itemViewProps);
                hippyListItemView.setExposureState(1);
                return;
            }
            return;
        }
        if (hippyListItemView.getExposureState() != 2) {
            if (hippyListItemView.getExposureState() == 1) {
                sendExposureEvent(view, HippyListItemView.EXPOSURE_EVENT_WILL_DISAPPEAR, itemViewProps);
            }
            sendExposureEvent(view, HippyListItemView.EXPOSURE_EVENT_DISAPPEAR, itemViewProps);
            hippyListItemView.setExposureState(2);
        }
    }

    protected void checkSendOnScrollEvent() {
        if (this.mScrollEventEnable) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - this.mLastScrollEventTimeStamp >= this.mScrollEventThrottle) {
                this.mLastScrollEventTimeStamp = elapsedRealtime;
                sendOnScrollEvent();
            } else {
                this.mHasUnsentScrollEvent = true;
            }
        }
    }

    protected RecyclerAdapter createAdapter(RecyclerView recyclerView, HippyEngineContext hippyEngineContext) {
        return new HippyListAdapter(recyclerView, hippyEngineContext);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && this.isTvPlatform) {
            this.mFocusHelper.setKeyCode(keyEvent.getKeyCode());
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase, android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i3) {
        if (!this.isTvPlatform) {
            return super.focusSearch(view, i3);
        }
        return this.mFocusHelper.focusSearch(view, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HippyMap generateScrollEvent() {
        HippyMap hippyMap = new HippyMap();
        double d16 = 0.0d;
        if (this.mLayout.canScrollHorizontally()) {
            hippyMap.pushDouble(HippyTKDListViewAdapter.X, (this.mOffsetX - this.mState.mCustomHeaderWidth) / PixelUtil.getDensity());
        } else {
            float density = (this.mOffsetY - this.mState.mCustomHeaderHeight) / PixelUtil.getDensity();
            hippyMap.pushDouble(HippyTKDListViewAdapter.X, 0.0d);
            d16 = density;
        }
        hippyMap.pushDouble("y", d16);
        HippyMap hippyMap2 = new HippyMap();
        hippyMap2.pushMap("contentOffset", hippyMap);
        return hippyMap2;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i3, int i16) {
        if (!this.isTvPlatform) {
            return super.getChildDrawingOrder(i3, i16);
        }
        return this.mFocusHelper.getChildDrawingOrder(i3, i16);
    }

    public View getCustomFooterView() {
        RecyclerViewBase.ViewHolder childViewHolderInt;
        if (getChildCount() > 0 && (childViewHolderInt = RecyclerViewBase.getChildViewHolderInt(getChildAt(getChildCount() - 1))) != null) {
            return childViewHolderInt.mContent;
        }
        return null;
    }

    public View getCustomHeaderView() {
        RecyclerViewBase.ViewHolder childViewHolderInt;
        if (getChildCount() > 0 && (childViewHolderInt = RecyclerViewBase.getChildViewHolderInt(getChildAt(0))) != null) {
            return childViewHolderInt.mContent;
        }
        return null;
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public NativeGestureDispatcher getGestureDispatcher() {
        return this.mGestureDispatcher;
    }

    protected OnScrollDragEndedEvent getOnScrollDragEndedEvent() {
        if (this.mOnScrollDragEndedEvent == null) {
            this.mOnScrollDragEndedEvent = new OnScrollDragEndedEvent(HippyScrollViewEventHelper.EVENT_TYPE_END_DRAG);
        }
        return this.mOnScrollDragEndedEvent;
    }

    protected OnScrollDragStartedEvent getOnScrollDragStartedEvent() {
        if (this.mOnScrollDragStartedEvent == null) {
            this.mOnScrollDragStartedEvent = new OnScrollDragStartedEvent(HippyScrollViewEventHelper.EVENT_TYPE_BEGIN_DRAG);
        }
        return this.mOnScrollDragStartedEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public OnScrollEvent getOnScrollEvent() {
        if (this.mOnScrollEvent == null) {
            this.mOnScrollEvent = new OnScrollEvent(HippyScrollViewEventHelper.EVENT_TYPE_SCROLL);
        }
        return this.mOnScrollEvent;
    }

    protected OnScrollFlingEndedEvent getOnScrollFlingEndedEvent() {
        if (this.mOnScrollFlingEndedEvent == null) {
            this.mOnScrollFlingEndedEvent = new OnScrollFlingEndedEvent(HippyScrollViewEventHelper.EVENT_TYPE_MOMENTUM_END);
        }
        return this.mOnScrollFlingEndedEvent;
    }

    protected OnScrollFlingStartedEvent getOnScrollFlingStartedEvent() {
        if (this.mOnScrollFlingStartedEvent == null) {
            this.mOnScrollFlingStartedEvent = new OnScrollFlingStartedEvent(HippyScrollViewEventHelper.EVENT_TYPE_MOMENTUM_BEGIN);
        }
        return this.mOnScrollFlingStartedEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.mHasRemovePreDraw) {
            this.mViewTreeObserver = getViewTreeObserver();
            if (this.mPreDrawListener == null) {
                this.mPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.tencent.mtt.hippy.views.list.HippyListView.1
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        if (HippyListView.this.mAdapter.getItemCount() > 0 && HippyListView.this.getChildCount() > 0) {
                            HippyListView.this.mViewTreeObserver.removeOnPreDrawListener(this);
                            HippyListView.this.mHasRemovePreDraw = true;
                            HippyListView.this.post(new Runnable() { // from class: com.tencent.mtt.hippy.views.list.HippyListView.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    HippyListView.this.onInitialListReady();
                                    HippyListView.this.getOnInitialListReadyEvent().send(HippyListView.this, null);
                                }
                            });
                        }
                        return true;
                    }
                };
            }
            this.mViewTreeObserver.removeOnPreDrawListener(this.mPreDrawListener);
            this.mViewTreeObserver.addOnPreDrawListener(this.mPreDrawListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.mPreDrawListener;
        if (onPreDrawListener != null && (viewTreeObserver = this.mViewTreeObserver) != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
        }
        super.onDetachedFromWindow();
    }

    public void onFooterRefreshFinish() {
        if (this.mFooterRefreshState == 1) {
            if (this.mLayout.canScrollHorizontally()) {
                int totalHeight = getTotalHeight() - getWidth();
                int i3 = this.mOffsetX;
                if (i3 > totalHeight) {
                    smoothScrollBy(totalHeight - i3, 0, false, true);
                }
            } else {
                int totalHeight2 = getTotalHeight() - getHeight();
                int i16 = this.mOffsetY;
                if (i16 > totalHeight2) {
                    smoothScrollBy(0, totalHeight2 - i16, false, true);
                }
            }
            this.mFooterRefreshState = 0;
        }
    }

    public void onHeaderRefresh() {
        if (this.mHeaderRefreshState == 0) {
            if (this.mLayout.canScrollHorizontally()) {
                smoothScrollBy(-this.mOffsetX, 0, false, true);
            } else {
                smoothScrollBy(0, -this.mOffsetY, false, true);
            }
        }
    }

    public void onHeaderRefreshFinish() {
        if (this.mHeaderRefreshState == 1) {
            if (this.mLayout.canScrollHorizontally()) {
                int i3 = this.mOffsetX;
                int i16 = this.mState.mCustomHeaderWidth;
                if (i3 < i16) {
                    smoothScrollBy((-i3) + i16, 0, false, true);
                }
            } else {
                int i17 = this.mOffsetY;
                int i18 = this.mState.mCustomHeaderHeight;
                if (i17 < i18) {
                    smoothScrollBy(0, (-i17) + i18, false, true);
                }
            }
            this.mHeaderRefreshState = 0;
        }
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mScrollEnable) {
            return false;
        }
        if (this.mLayout.canScrollVertically()) {
            int action = motionEvent.getAction();
            float y16 = motionEvent.getY();
            float x16 = motionEvent.getX();
            if (action != 0) {
                if (action == 2 && Math.abs(x16 - this.touchDownX) / Math.abs(y16 - this.touchDownY) > 1.0f && Math.abs(x16 - this.touchDownX) > this.touchSlop) {
                    return false;
                }
            } else {
                this.touchDownY = y16;
                this.touchDownX = x16;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView
    protected void onScrollDragEnded() {
        if (this.mScrollEndDragEventEnable) {
            getOnScrollDragEndedEvent().send(this, generateScrollEvent());
        }
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView
    protected void onScrollDragStarted() {
        if (this.mScrollBeginDragEventEnable) {
            getOnScrollDragStartedEvent().send(this, generateScrollEvent());
        }
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView
    protected void onScrollFlingEnded() {
        if (this.mMomentumScrollEndEventEnable) {
            getOnScrollFlingEndedEvent().send(this, generateScrollEvent());
        }
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView
    protected void onScrollFlingStarted() {
        if (this.mMomentumScrollBeginEventEnable) {
            getOnScrollFlingStartedEvent().send(this, generateScrollEvent());
        }
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.OnScrollListener
    public void onScrollStateChanged(int i3, int i16) {
        super.onScrollStateChanged(i3, i16);
        if (this.mHasUnsentScrollEvent) {
            sendOnScrollEvent();
        }
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.OnScrollListener
    public void onScrolled(int i3, int i16) {
        super.onScrolled(i3, i16);
        checkSendOnScrollEvent();
        if (this.mExposureEventEnable) {
            dispatchExposureEvent();
        }
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mScrollEnable) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    protected void onTouchMove(int i3, int i16) {
        int offsetY;
        int height;
        int abs;
        float f16;
        String str;
        int totalHeight = this.mAdapter.getTotalHeight();
        HippyMap hippyMap = new HippyMap();
        if (this.mLayout.canScrollHorizontally()) {
            int i17 = this.mOffsetX;
            int i18 = this.mState.mCustomHeaderWidth;
            if (i17 < i18) {
                abs = Math.abs(i17 - i18);
                f16 = abs;
                str = "onHeaderPulling";
            } else {
                if (i17 > totalHeight - getWidth()) {
                    offsetY = this.mOffsetX - totalHeight;
                    height = getWidth();
                    f16 = Math.abs(offsetY - height);
                    str = "onFooterPulling";
                }
                f16 = 0.0f;
                str = "";
            }
        } else if (getOffsetY() < this.mState.mCustomHeaderHeight) {
            abs = Math.abs(getOffsetY() - this.mState.mCustomHeaderHeight);
            f16 = abs;
            str = "onHeaderPulling";
        } else {
            if (getOffsetY() > totalHeight - getHeight()) {
                offsetY = getOffsetY() - totalHeight;
                height = getHeight();
                f16 = Math.abs(offsetY - height);
                str = "onFooterPulling";
            }
            f16 = 0.0f;
            str = "";
        }
        hippyMap.pushDouble("contentOffset", PixelUtil.px2dp(f16));
        if (!str.equals("onFooterPulling")) {
            if (str.equals("onHeaderPulling")) {
                sendPullHeaderEvent(str, hippyMap);
                return;
            }
            return;
        }
        sendPullFooterEvent(str, hippyMap);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!this.isTvPlatform) {
            return;
        }
        this.mFocusHelper.requestChildFocus(view, view2);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase, android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z16) {
        if (!this.isTvPlatform) {
            return super.requestChildRectangleOnScreen(view, rect, z16);
        }
        return this.mFocusHelper.requestChildRectangleOnScreen(view, rect, z16);
    }

    public void scrollToContentOffset(double d16, double d17, boolean z16, int i3) {
        int dp2px = ((int) PixelUtil.dp2px(d17)) - this.mOffsetY;
        int dp2px2 = ((int) PixelUtil.dp2px(d16)) - this.mOffsetX;
        if (z16) {
            if (i3 != 0) {
                if ((dp2px != 0 || dp2px2 != 0) && !this.mState.didStructureChange()) {
                    this.mViewFlinger.smoothScrollBy(dp2px2, dp2px, i3, true);
                    return;
                }
                return;
            }
            smoothScrollBy(dp2px2, dp2px);
            return;
        }
        scrollBy(dp2px2, dp2px);
        post(new Runnable() { // from class: com.tencent.mtt.hippy.views.list.HippyListView.3
            @Override // java.lang.Runnable
            public void run() {
                HippyListView.this.dispatchLayout();
            }
        });
    }

    public void scrollToIndex(int i3, int i16, boolean z16, int i17) {
        if (z16) {
            int heightBefore = getHeightBefore(i16) - getOffsetY();
            if (i17 != 0) {
                if (heightBefore != 0 && !this.mState.didStructureChange()) {
                    this.mViewFlinger.smoothScrollBy(0, heightBefore, i17, true);
                    return;
                }
                return;
            }
            smoothScrollBy(0, heightBefore);
            return;
        }
        scrollToPosition(i16, 0);
        post(new Runnable() { // from class: com.tencent.mtt.hippy.views.list.HippyListView.2
            @Override // java.lang.Runnable
            public void run() {
                HippyListView.this.dispatchLayout();
            }
        });
    }

    protected void sendExposureEvent(View view, String str, HippyMap hippyMap) {
        if (hippyMap.containsKey(str)) {
            new HippyViewEvent(str).send(view, null);
        }
    }

    protected void sendOnScrollEvent() {
        this.mHasUnsentScrollEvent = false;
        getOnScrollEvent().send(this, generateScrollEvent());
    }

    protected void sendPullFooterEvent(String str, HippyMap hippyMap) {
        PullElementEvent pullElementEvent = new PullElementEvent(str);
        View customFooterView = getCustomFooterView();
        if (customFooterView instanceof HippyPullFooterView) {
            pullElementEvent.send(customFooterView, hippyMap);
        }
    }

    protected void sendPullHeaderEvent(String str, HippyMap hippyMap) {
        PullElementEvent pullElementEvent = new PullElementEvent(str);
        View customHeaderView = getCustomHeaderView();
        if (customHeaderView instanceof HippyPullHeaderView) {
            pullElementEvent.send(customHeaderView, hippyMap);
        }
    }

    public void setExposureEventEnable(boolean z16) {
        this.mExposureEventEnable = z16;
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public void setGestureDispatcher(NativeGestureDispatcher nativeGestureDispatcher) {
        this.mGestureDispatcher = nativeGestureDispatcher;
    }

    public void setInitialContentOffset(int i3) {
        this.initialContentOffset = i3;
    }

    public void setListData() {
        LogUtils.d("hippylistview", "setListData");
        this.mListAdapter.notifyDataSetChanged();
        if (this.isTvPlatform) {
            this.mFocusHelper.setListData();
        }
        dispatchLayout();
        if (this.mExposureEventEnable) {
            dispatchExposureEvent();
        }
        if (!this.hasCompleteFirstBatch && getChildCount() > 0) {
            if (this.initialContentOffset > 0) {
                scrollToInitContentOffset();
            }
            this.hasCompleteFirstBatch = true;
        }
    }

    public void setMomentumScrollBeginEventEnable(boolean z16) {
        this.mMomentumScrollBeginEventEnable = z16;
    }

    public void setMomentumScrollEndEventEnable(boolean z16) {
        this.mMomentumScrollEndEventEnable = z16;
    }

    public void setOnScrollEventEnable(boolean z16) {
        this.mScrollEventEnable = z16;
    }

    public void setScrollBeginDragEventEnable(boolean z16) {
        this.mScrollBeginDragEventEnable = z16;
    }

    public void setScrollEnable(boolean z16) {
        this.mScrollEnable = z16;
    }

    public void setScrollEndDragEventEnable(boolean z16) {
        this.mScrollEndDragEventEnable = z16;
    }

    public void setScrollEventThrottle(int i3) {
        this.mScrollEventThrottle = i3;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    protected boolean shouldStopReleaseGlows(boolean z16, boolean z17) {
        if (!z16) {
            return false;
        }
        if (this.mLayout.canScrollHorizontally()) {
            return shouldStopReleaseGlowsForHorizontal(z17);
        }
        return shouldStopReleaseGlowsForVertical(z17);
    }

    public HippyListView(Context context, int i3) {
        super(context);
        this.mHeaderRefreshState = 0;
        this.mFooterRefreshState = 0;
        this.mEnableRefresh = true;
        this.mScrollBeginDragEventEnable = false;
        this.mScrollEndDragEventEnable = false;
        this.mMomentumScrollBeginEventEnable = false;
        this.mMomentumScrollEndEventEnable = false;
        this.mScrollEventEnable = true;
        this.mScrollEnable = true;
        this.mExposureEventEnable = false;
        this.initialContentOffset = 0;
        this.hasCompleteFirstBatch = false;
        this.mScrollEventThrottle = 400;
        this.mLastOffsetX = Integer.MIN_VALUE;
        this.mLastOffsetY = Integer.MIN_VALUE;
        this.mLastScrollEventTimeStamp = -1L;
        this.mHasRemovePreDraw = false;
        this.mPreDrawListener = null;
        this.mViewTreeObserver = null;
        this.mFocusHelper = null;
        init(context, i3);
    }

    protected void onInitialListReady() {
    }
}
