package com.tencent.pts.support;

import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.support.RecyclerViewCompat;

/* loaded from: classes22.dex */
public class PagerSnapHelper {
    static IPatchRedirector $redirector_ = null;
    private static final int MAX_SCROLL_ON_FLING_DURATION = 300;
    private static final String TAG = "PagerSnapHelper";
    private int centerPosition;
    private PagerEventListener eventListener;
    private OrientationHelper horizontalHelper;
    private boolean isQuickPageChanged;
    private boolean isSnapping;
    private View lastCenterView;
    private LinearLayoutManager layoutManager;
    private OnLayoutChangedListenerImpl onLayoutChangedListener;
    private int placeHeaderCount;
    private int reboundFooterCount;
    private RecyclerViewCompat recyclerView;
    private TouchEventProcessor touchEventProcessor;
    private OrientationHelper verticalHelper;

    /* loaded from: classes22.dex */
    public interface PagerEventListener {
        void onFooterRebound();

        void onPagerChanged(RecyclerView.ViewHolder viewHolder);
    }

    public PagerSnapHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.lastCenterView = null;
        this.reboundFooterCount = 0;
        this.placeHeaderCount = 0;
        this.centerPosition = -1;
        this.isSnapping = false;
        this.isQuickPageChanged = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public int[] calculateDistanceToFinalSnap(@NonNull LinearLayoutManager linearLayoutManager, @NonNull View view) {
        int[] iArr = new int[2];
        if (linearLayoutManager.canScrollHorizontally()) {
            iArr[0] = distanceToCenter(linearLayoutManager, view, getOrientationHelper(linearLayoutManager));
        } else {
            iArr[0] = 0;
        }
        if (linearLayoutManager.canScrollVertically()) {
            iArr[1] = distanceToCenter(linearLayoutManager, view, getOrientationHelper(linearLayoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    private boolean checkIsPositionOutOfBound(int i3, RecyclerView.LayoutManager layoutManager) {
        int endPosition = getEndPosition(layoutManager);
        if (i3 >= getStartPosition() && i3 <= endPosition) {
            return false;
        }
        return true;
    }

    private void checkRecyclerViewState(RecyclerView recyclerView) {
        if (recyclerView != null && recyclerView.getAdapter() != null && recyclerView.getLayoutManager() != null) {
            if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                return;
            } else {
                throw new IllegalStateException("PagerSnapHelper can only attach to the RecyclerView with LinearLayoutManager");
            }
        }
        throw new IllegalStateException("PagerSnapHelper can't attach to the RecyclerView before setup Adapter or LayoutManager");
    }

    private void destroyCallbacks() {
        this.recyclerView.removeOnScrollListener(this.touchEventProcessor);
        this.recyclerView.setOnFlingListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchPagerChanged(View view, boolean z16) {
        RecyclerViewCompat recyclerViewCompat;
        if (view != null && (recyclerViewCompat = this.recyclerView) != null && this.layoutManager != null) {
            RecyclerView.ViewHolder childViewHolder = recyclerViewCompat.getChildViewHolder(view);
            int position = this.layoutManager.getPosition(view);
            if (childViewHolder != null && position != -1) {
                if ((position == this.centerPosition && !z16) || checkIsPositionOutOfBound(position, this.layoutManager)) {
                    return;
                }
                this.centerPosition = position;
                PagerEventListener pagerEventListener = this.eventListener;
                if (pagerEventListener != null) {
                    pagerEventListener.onPagerChanged(childViewHolder);
                }
            }
        }
    }

    private int distanceToCenter(@NonNull LinearLayoutManager linearLayoutManager, @NonNull View view, OrientationHelper orientationHelper) {
        int end;
        int decoratedStart = orientationHelper.getDecoratedStart(view) + (orientationHelper.getDecoratedMeasurement(view) / 2);
        if (linearLayoutManager.getClipToPadding()) {
            end = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
        } else {
            end = orientationHelper.getEnd() / 2;
        }
        return decoratedStart - end;
    }

    @Nullable
    private View findFirstVisibleView(LinearLayoutManager linearLayoutManager) {
        int childCount = linearLayoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        OrientationHelper orientationHelper = getOrientationHelper(linearLayoutManager);
        int i3 = Integer.MAX_VALUE;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = linearLayoutManager.getChildAt(i16);
            int decoratedStart = orientationHelper.getDecoratedStart(childAt);
            if (decoratedStart < i3) {
                view = childAt;
                i3 = decoratedStart;
            }
        }
        return view;
    }

    private View findLastVisibleView(LinearLayoutManager linearLayoutManager) {
        int childCount = linearLayoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        OrientationHelper orientationHelper = getOrientationHelper(linearLayoutManager);
        int i3 = Integer.MIN_VALUE;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = linearLayoutManager.getChildAt(i16);
            int decoratedStart = orientationHelper.getDecoratedStart(childAt);
            if (decoratedStart > i3) {
                view = childAt;
                i3 = decoratedStart;
            }
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getEndPosition(RecyclerView.LayoutManager layoutManager) {
        return (layoutManager.getItemCount() - this.reboundFooterCount) - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getStartPosition() {
        return this.placeHeaderCount;
    }

    private void setupCallbacks() throws IllegalStateException {
        if (this.recyclerView.getOnFlingListenerCompat() == null) {
            AnonymousClass1 anonymousClass1 = null;
            this.touchEventProcessor = new TouchEventProcessor(this, anonymousClass1);
            this.onLayoutChangedListener = new OnLayoutChangedListenerImpl(this, anonymousClass1);
            this.recyclerView.addOnScrollListener(this.touchEventProcessor);
            this.recyclerView.setOnFlingListenerCompat(this.touchEventProcessor);
            this.recyclerView.addOnLayoutChangeListener(this.onLayoutChangedListener);
            this.recyclerView.getAdapter().registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() { // from class: com.tencent.pts.support.PagerSnapHelper.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) PagerSnapHelper.this);
                    }
                }

                private void onPagerDataChanged(int i3, int i16) {
                    if (i3 <= PagerSnapHelper.this.centerPosition && (i3 + i16) - 1 >= PagerSnapHelper.this.centerPosition) {
                        PagerSnapHelper.this.onLayoutChangedListener.reset = true;
                        PagerSnapHelper.this.recyclerView.addOnLayoutChangeListener(PagerSnapHelper.this.onLayoutChangedListener);
                        PagerSnapHelper.this.recyclerView.requestLayout();
                    }
                }

                @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
                public void onChanged() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        onPagerDataChanged(0, PagerSnapHelper.this.layoutManager.getItemCount());
                    }
                }

                @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
                public void onItemRangeChanged(int i3, int i16, Object obj) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), obj);
                    } else if (obj == null) {
                        onItemRangeChanged(i3, i16);
                    }
                }

                @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
                public void onItemRangeInserted(int i3, int i16) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
                        return;
                    }
                    if (i3 <= PagerSnapHelper.this.centerPosition) {
                        PagerSnapHelper.this.centerPosition += i16;
                    }
                    onPagerDataChanged(i3, i16);
                }

                @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
                public void onItemRangeMoved(int i3, int i16, int i17) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                        iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                        return;
                    }
                    if (i3 == PagerSnapHelper.this.centerPosition) {
                        PagerSnapHelper.this.centerPosition = i16;
                    }
                    onPagerDataChanged(i3, i17);
                }

                @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
                public void onItemRangeRemoved(int i3, int i16) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                        iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
                        return;
                    }
                    if (i3 <= PagerSnapHelper.this.centerPosition) {
                        PagerSnapHelper.this.centerPosition -= i16;
                    }
                    onPagerDataChanged(i3, i16);
                }

                @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
                public void onItemRangeChanged(int i3, int i16) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                        onPagerDataChanged(i3, i16);
                    } else {
                        iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
                    }
                }
            });
            return;
        }
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean snapFromFling(@NonNull LinearLayoutManager linearLayoutManager, float f16, float f17, int i3) {
        View findCenterView;
        int position;
        if (linearLayoutManager.getItemCount() == 0 || (findCenterView = findCenterView(linearLayoutManager)) == null || (position = linearLayoutManager.getPosition(findCenterView)) == -1) {
            return false;
        }
        boolean z16 = true;
        if (!linearLayoutManager.canScrollHorizontally() ? f17 <= 0.0f : f16 <= 0.0f) {
            z16 = false;
        }
        int startPosition = getStartPosition();
        int endPosition = getEndPosition(linearLayoutManager);
        if (i3 == -1 || position == i3) {
            if (z16) {
                position++;
            } else {
                position--;
            }
        }
        if (position == -1) {
            return false;
        }
        if (position >= startPosition) {
            if (position > endPosition) {
                startPosition = endPosition;
            } else {
                startPosition = position;
            }
        }
        return snapToTargetPosition(startPosition);
    }

    public void attachToRecyclerView(@Nullable RecyclerViewCompat recyclerViewCompat) throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerViewCompat);
            return;
        }
        RecyclerViewCompat recyclerViewCompat2 = this.recyclerView;
        if (recyclerViewCompat2 == recyclerViewCompat) {
            return;
        }
        if (recyclerViewCompat2 != null) {
            destroyCallbacks();
        }
        this.recyclerView = recyclerViewCompat;
        if (recyclerViewCompat != null) {
            checkRecyclerViewState(recyclerViewCompat);
            this.layoutManager = (LinearLayoutManager) this.recyclerView.getLayoutManager();
            setupCallbacks();
            snapToCenterPosition();
        }
    }

    protected LinearSmoothScroller createSnapScroller(LinearLayoutManager linearLayoutManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (LinearSmoothScroller) iPatchRedirector.redirect((short) 18, (Object) this, (Object) linearLayoutManager);
        }
        return new LinearSmoothScroller(this.recyclerView.getContext(), linearLayoutManager) { // from class: com.tencent.pts.support.PagerSnapHelper.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ LinearLayoutManager val$layoutManager;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                this.val$layoutManager = linearLayoutManager;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, PagerSnapHelper.this, r8, linearLayoutManager);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.support.v7.widget.LinearSmoothScroller
            public int calculateTimeForDeceleration(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    return ((Integer) iPatchRedirector2.redirect((short) 3, (Object) this, i3)).intValue();
                }
                return Math.min(300, super.calculateTimeForDeceleration(i3));
            }

            @Override // android.support.v7.widget.LinearSmoothScroller
            public PointF computeScrollVectorForPosition(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    return (PointF) iPatchRedirector2.redirect((short) 4, (Object) this, i3);
                }
                return this.val$layoutManager.computeScrollVectorForPosition(i3);
            }

            @Override // android.support.v7.widget.LinearSmoothScroller, android.support.v7.widget.RecyclerView.SmoothScroller
            protected void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    int[] calculateDistanceToFinalSnap = PagerSnapHelper.this.calculateDistanceToFinalSnap(this.val$layoutManager, view);
                    int i3 = calculateDistanceToFinalSnap[0];
                    int i16 = calculateDistanceToFinalSnap[1];
                    int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i3), Math.abs(i16)));
                    if (calculateTimeForDeceleration <= 0) {
                        PagerSnapHelper.this.touchEventProcessor.onIdle();
                        return;
                    } else {
                        action.update(i3, i16, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                        return;
                    }
                }
                iPatchRedirector2.redirect((short) 2, this, view, state, action);
            }
        };
    }

    @Nullable
    public View findCenterView(LinearLayoutManager linearLayoutManager) {
        int end;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (View) iPatchRedirector.redirect((short) 9, (Object) this, (Object) linearLayoutManager);
        }
        int childCount = linearLayoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        OrientationHelper orientationHelper = getOrientationHelper(linearLayoutManager);
        if (linearLayoutManager.getClipToPadding()) {
            end = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
        } else {
            end = orientationHelper.getEnd() / 2;
        }
        int i3 = Integer.MAX_VALUE;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = linearLayoutManager.getChildAt(i16);
            int abs = Math.abs((orientationHelper.getDecoratedStart(childAt) + (orientationHelper.getDecoratedMeasurement(childAt) / 2)) - end);
            if (abs < i3) {
                view = childAt;
                i3 = abs;
            }
        }
        return view;
    }

    public int getCurrentPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.centerPosition;
    }

    @NonNull
    protected OrientationHelper getOrientationHelper(LinearLayoutManager linearLayoutManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (OrientationHelper) iPatchRedirector.redirect((short) 10, (Object) this, (Object) linearLayoutManager);
        }
        if (linearLayoutManager.canScrollVertically()) {
            if (this.verticalHelper == null) {
                this.verticalHelper = OrientationHelper.createOrientationHelper(linearLayoutManager, 1);
            }
            return this.verticalHelper;
        }
        if (this.horizontalHelper == null) {
            this.horizontalHelper = OrientationHelper.createOrientationHelper(linearLayoutManager, 0);
        }
        return this.horizontalHelper;
    }

    public boolean isSnapping() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.isSnapping;
    }

    public void offsetToTargetPosition(View view) {
        LinearLayoutManager linearLayoutManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) view);
            return;
        }
        if (this.recyclerView == null || (linearLayoutManager = this.layoutManager) == null || view == null || checkIsPositionOutOfBound(linearLayoutManager.getPosition(view), this.layoutManager)) {
            return;
        }
        int[] calculateDistanceToFinalSnap = calculateDistanceToFinalSnap(this.layoutManager, view);
        int i3 = calculateDistanceToFinalSnap[0];
        if (i3 != 0 || calculateDistanceToFinalSnap[1] != 0) {
            this.recyclerView.scrollBy(i3, calculateDistanceToFinalSnap[1]);
        }
    }

    public void requestLayoutChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.recyclerView.addOnLayoutChangeListener(this.onLayoutChangedListener);
        }
    }

    public void setEventListener(PagerEventListener pagerEventListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) pagerEventListener);
        } else {
            this.eventListener = pagerEventListener;
        }
    }

    public void setPlaceHeaderCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.placeHeaderCount = i3;
        }
    }

    public void setQuickPageChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            this.isQuickPageChanged = z16;
        }
    }

    public void setReboundFooterCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.reboundFooterCount = i3;
        }
    }

    public boolean snapToCenterPosition() {
        LinearLayoutManager linearLayoutManager;
        View findCenterView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.recyclerView == null || (linearLayoutManager = this.layoutManager) == null || (findCenterView = findCenterView(linearLayoutManager)) == null) {
            return false;
        }
        return snapToTargetView(findCenterView);
    }

    public boolean snapToNextPosition() {
        LinearLayoutManager linearLayoutManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.recyclerView == null || (linearLayoutManager = this.layoutManager) == null) {
            return false;
        }
        int i3 = this.centerPosition + 1;
        if (checkIsPositionOutOfBound(i3, linearLayoutManager)) {
            return false;
        }
        snapToTargetPosition(i3);
        return true;
    }

    public boolean snapToPreviousPosition() {
        LinearLayoutManager linearLayoutManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.recyclerView == null || (linearLayoutManager = this.layoutManager) == null) {
            return false;
        }
        int i3 = this.centerPosition - 1;
        if (checkIsPositionOutOfBound(i3, linearLayoutManager)) {
            return false;
        }
        snapToTargetPosition(i3);
        return true;
    }

    public boolean snapToTargetPosition(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, i3)).booleanValue();
        }
        if (checkIsPositionOutOfBound(i3, this.layoutManager)) {
            return false;
        }
        View findViewByPosition = this.layoutManager.findViewByPosition(i3);
        if (findViewByPosition == null) {
            this.recyclerView.smoothScrollToPosition(i3);
            this.isSnapping = true;
            return true;
        }
        LinearSmoothScroller createSnapScroller = createSnapScroller(this.layoutManager);
        createSnapScroller.setTargetPosition(i3);
        this.layoutManager.startSmoothScroll(createSnapScroller);
        this.isSnapping = true;
        if (this.isQuickPageChanged) {
            dispatchPagerChanged(findViewByPosition, false);
        }
        return true;
    }

    public boolean snapToTargetView(View view) {
        int position;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) view)).booleanValue();
        }
        if (view == null || (position = this.layoutManager.getPosition(view)) == -1) {
            return false;
        }
        int startPosition = getStartPosition();
        int endPosition = getEndPosition(this.layoutManager);
        if (position < startPosition) {
            position = startPosition;
        } else if (position > endPosition) {
            position = endPosition;
        }
        return snapToTargetPosition(position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class OnLayoutChangedListenerImpl implements View.OnLayoutChangeListener {
        static IPatchRedirector $redirector_;
        private boolean reset;

        OnLayoutChangedListenerImpl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.reset = false;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PagerSnapHelper.this);
            }
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28));
                return;
            }
            PagerSnapHelper.this.recyclerView.removeOnLayoutChangeListener(this);
            if (PagerSnapHelper.this.layoutManager.getItemCount() > PagerSnapHelper.this.placeHeaderCount + PagerSnapHelper.this.reboundFooterCount) {
                PagerSnapHelper pagerSnapHelper = PagerSnapHelper.this;
                View findCenterView = pagerSnapHelper.findCenterView(pagerSnapHelper.layoutManager);
                if (!PagerSnapHelper.this.snapToTargetView(findCenterView) || this.reset) {
                    PagerSnapHelper.this.dispatchPagerChanged(findCenterView, this.reset);
                }
                this.reset = false;
            }
        }

        /* synthetic */ OnLayoutChangedListenerImpl(PagerSnapHelper pagerSnapHelper, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) pagerSnapHelper, (Object) anonymousClass1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class TouchEventProcessor extends RecyclerView.OnScrollListener implements RecyclerViewCompat.OnFlingListener {
        static IPatchRedirector $redirector_;
        private int currentScrollState;
        private boolean reset;
        private boolean scrolled;

        TouchEventProcessor() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PagerSnapHelper.this);
                return;
            }
            this.scrolled = false;
            this.currentScrollState = 0;
            this.reset = false;
        }

        private void onDragging(int i3) {
            if (i3 == 0 || i3 == 2) {
                PagerSnapHelper pagerSnapHelper = PagerSnapHelper.this;
                pagerSnapHelper.lastCenterView = pagerSnapHelper.findCenterView(pagerSnapHelper.layoutManager);
                if (PagerSnapHelper.this.centerPosition != -1 && PagerSnapHelper.this.layoutManager.findViewByPosition(PagerSnapHelper.this.centerPosition) == null) {
                    this.reset = true;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onIdle() {
            boolean z16;
            boolean z17;
            int i3;
            boolean z18 = true;
            if (this.scrolled) {
                this.scrolled = false;
                z16 = !PagerSnapHelper.this.snapToCenterPosition();
            } else {
                z16 = true;
            }
            if (z16) {
                PagerSnapHelper.this.isSnapping = false;
            }
            int startPosition = PagerSnapHelper.this.getStartPosition();
            PagerSnapHelper pagerSnapHelper = PagerSnapHelper.this;
            int endPosition = pagerSnapHelper.getEndPosition(pagerSnapHelper.layoutManager);
            if (PagerSnapHelper.this.centerPosition == endPosition && !this.reset) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (PagerSnapHelper.this.centerPosition != startPosition || this.reset) {
                z18 = false;
            }
            PagerSnapHelper pagerSnapHelper2 = PagerSnapHelper.this;
            View findCenterView = pagerSnapHelper2.findCenterView(pagerSnapHelper2.layoutManager);
            if (findCenterView != null) {
                i3 = PagerSnapHelper.this.layoutManager.getPosition(findCenterView);
            } else {
                i3 = -1;
            }
            if (i3 >= endPosition && z17) {
                if (z16 && PagerSnapHelper.this.eventListener != null) {
                    PagerSnapHelper.this.eventListener.onFooterRebound();
                }
            } else if (i3 > startPosition || !z18) {
                PagerSnapHelper.this.dispatchPagerChanged(findCenterView, this.reset);
            }
            this.reset = false;
        }

        @Override // com.tencent.pts.support.RecyclerViewCompat.OnFlingListener
        public boolean onFling(float f16, float f17) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
            }
            if (PagerSnapHelper.this.layoutManager == null || PagerSnapHelper.this.recyclerView.getAdapter() == null) {
                return false;
            }
            int minFlingVelocity = PagerSnapHelper.this.recyclerView.getMinFlingVelocity();
            if (PagerSnapHelper.this.lastCenterView != null) {
                i3 = PagerSnapHelper.this.layoutManager.getPosition(PagerSnapHelper.this.lastCenterView);
            } else {
                i3 = -1;
            }
            float f18 = minFlingVelocity;
            if (Math.abs(f17) <= f18 && Math.abs(f16) <= f18) {
                return false;
            }
            PagerSnapHelper pagerSnapHelper = PagerSnapHelper.this;
            return pagerSnapHelper.snapFromFling(pagerSnapHelper.layoutManager, f16, f17, i3);
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) recyclerView, i3);
                return;
            }
            int i16 = this.currentScrollState;
            this.currentScrollState = i3;
            if (i3 == 0) {
                onIdle();
            } else if (i3 == 1) {
                onDragging(i16);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, recyclerView, Integer.valueOf(i3), Integer.valueOf(i16));
            } else if (i3 != 0 || i16 != 0) {
                this.scrolled = true;
            }
        }

        /* synthetic */ TouchEventProcessor(PagerSnapHelper pagerSnapHelper, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) pagerSnapHelper, (Object) anonymousClass1);
        }
    }
}
