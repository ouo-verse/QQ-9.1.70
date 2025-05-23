package com.tencent.mobileqq.emosm.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.ProgressCircle;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQUIAppSetting;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes6.dex */
public class DragSortListView extends XListView {
    static final int DRAGGING = 4;
    public static final int DRAG_NEG_X = 2;
    public static final int DRAG_NEG_Y = 8;
    public static final int DRAG_POS_X = 1;
    public static final int DRAG_POS_Y = 4;
    static final int DROPPING = 2;
    private static final int IDLE = 0;
    private static final int NO_CANCEL = 0;
    private static final int ON_INTERCEPT_TOUCH_EVENT = 2;
    private static final int ON_TOUCH_EVENT = 1;
    static final int REMOVING = 1;
    private static final int STOPPED = 3;
    private static final int S_CACHE_SIZE = 3;
    private boolean ignoreDeleteEnabled;
    private c mAdapterWrapper;
    private boolean mAnimate;
    private boolean mBlockLayoutRequests;
    private MotionEvent mCancelEvent;
    private int mCancelMethod;
    private j mChildHeightCache;
    private float mCurrFloatAlpha;
    private boolean mDelImmediately;
    private int mDownScrollStartY;
    float mDownScrollStartYF;
    private int mDragDeltaX;
    int mDragDeltaY;
    float mDragDownScrollHeight;
    private float mDragDownScrollStartFrac;
    private boolean mDragEnabled;
    private int mDragFlags;
    private d mDragListener;
    private DragScroller mDragScroller;
    private g mDragSortTracker;
    private int mDragStartY;
    int mDragState;
    float mDragUpScrollHeight;
    private float mDragUpScrollStartFrac;
    private DropAnimator mDropAnimator;
    private h mDropListener;
    int mFirstExpPos;
    private float mFloatAlpha;
    Point mFloatLoc;
    int mFloatPos;
    private View mFloatView;
    int mFloatViewHeight;
    int mFloatViewHeightHalf;
    private boolean mFloatViewInvalidated;
    private i mFloatViewManager;
    int mFloatViewMid;
    private boolean mFloatViewOnMeasured;
    private boolean mIgnoreTouchEvent;
    private boolean mInTouchEvent;
    private boolean mIsDelEvent;
    private boolean mIsDelShow;
    private boolean mIsItemEvent;
    private boolean mIsLeftEvent;
    private boolean mIsUpdateEvent;
    int mItemHeightCollapsed;
    private boolean mLastCallWasIntercept;
    private long mLastShowTime;
    private int mLastX;
    int mLastY;
    private k mLeftEventListener;
    private LiftAnimator mLiftAnimator;
    private boolean mListViewIntercepted;
    float mMaxScrollSpeed;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    int mProgressPos;
    private RemoveAnimator mRemoveAnimator;
    private l mRemoveListener;
    float mRemoveVelocityX;
    private View[] mSampleViewTypes;
    e mScrollProfile;
    int mSecondExpPos;
    private Rect mShaderRect;
    private float mSlideFrac;
    private float mSlideRegionFrac;
    int mSrcPos;
    int mTapPos;
    private Point mTouchLoc;
    private boolean mTrackDragSort;
    private int mUpScrollStartY;
    float mUpScrollStartYF;
    boolean mUseRemoveVelocity;
    private int mWidthMeasureSpec;
    private int mX;
    int mY;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class DragScroller implements Runnable {
        private int C;
        private float D;
        private boolean E = false;

        /* renamed from: d, reason: collision with root package name */
        private boolean f204415d;

        /* renamed from: e, reason: collision with root package name */
        private long f204416e;

        /* renamed from: f, reason: collision with root package name */
        private long f204417f;

        /* renamed from: h, reason: collision with root package name */
        private int f204418h;

        /* renamed from: i, reason: collision with root package name */
        private float f204419i;

        /* renamed from: m, reason: collision with root package name */
        private long f204420m;

        public DragScroller() {
        }

        public int e() {
            if (this.E) {
                return this.C;
            }
            return -1;
        }

        public boolean f() {
            return this.E;
        }

        public void g(int i3) {
            if (!this.E) {
                this.f204415d = false;
                this.E = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f204420m = uptimeMillis;
                this.f204416e = uptimeMillis;
                this.C = i3;
                DragSortListView.this.post(this);
            }
        }

        public void h(boolean z16) {
            if (z16) {
                DragSortListView.this.removeCallbacks(this);
                this.E = false;
            } else {
                this.f204415d = true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f204415d) {
                this.E = false;
                return;
            }
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            int lastVisiblePosition = DragSortListView.this.getLastVisiblePosition();
            int count = DragSortListView.this.getCount();
            int paddingTop = DragSortListView.this.getPaddingTop();
            int height = (DragSortListView.this.getHeight() - paddingTop) - DragSortListView.this.getPaddingBottom();
            DragSortListView dragSortListView = DragSortListView.this;
            int min = Math.min(dragSortListView.mY, dragSortListView.mFloatViewMid + dragSortListView.mFloatViewHeightHalf);
            DragSortListView dragSortListView2 = DragSortListView.this;
            int max = Math.max(dragSortListView2.mY, dragSortListView2.mFloatViewMid - dragSortListView2.mFloatViewHeightHalf);
            if (this.C == 0) {
                View childAt = DragSortListView.this.getChildAt(0);
                if (childAt == null) {
                    this.E = false;
                    return;
                } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                    this.E = false;
                    return;
                } else {
                    DragSortListView dragSortListView3 = DragSortListView.this;
                    this.D = dragSortListView3.mScrollProfile.getSpeed((dragSortListView3.mUpScrollStartYF - max) / dragSortListView3.mDragUpScrollHeight, this.f204416e);
                }
            } else {
                View childAt2 = DragSortListView.this.getChildAt(lastVisiblePosition - firstVisiblePosition);
                if (childAt2 == null) {
                    this.E = false;
                    return;
                } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                    this.E = false;
                    return;
                } else {
                    DragSortListView dragSortListView4 = DragSortListView.this;
                    this.D = -dragSortListView4.mScrollProfile.getSpeed((min - dragSortListView4.mDownScrollStartYF) / dragSortListView4.mDragDownScrollHeight, this.f204416e);
                }
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f204417f = uptimeMillis;
            float f16 = (float) (uptimeMillis - this.f204416e);
            this.f204419i = f16;
            int round = Math.round(this.D * f16);
            this.f204418h = round;
            if (round >= 0) {
                this.f204418h = Math.min(height, round);
                lastVisiblePosition = firstVisiblePosition;
            } else {
                this.f204418h = Math.max(-height, round);
            }
            View childAt3 = DragSortListView.this.getChildAt(lastVisiblePosition - firstVisiblePosition);
            int top = childAt3.getTop() + this.f204418h;
            if (lastVisiblePosition == 0 && top > paddingTop) {
                top = paddingTop;
            }
            DragSortListView.this.mBlockLayoutRequests = true;
            DragSortListView.this.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
            DragSortListView.this.layoutChildren();
            DragSortListView.this.invalidate();
            DragSortListView.this.mBlockLayoutRequests = false;
            DragSortListView.this.doDragFloatView(lastVisiblePosition, childAt3, false);
            this.f204416e = this.f204417f;
            DragSortListView.this.post(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class DropAnimator extends SmoothAnimator {
        private int E;
        private int F;
        private float G;
        private float H;

        public DropAnimator(float f16, int i3) {
            super(f16, i3);
        }

        private int j() {
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            DragSortListView dragSortListView = DragSortListView.this;
            int dividerHeight = (dragSortListView.mItemHeightCollapsed + dragSortListView.getDividerHeight()) / 2;
            View childAt = DragSortListView.this.getChildAt(this.E - firstVisiblePosition);
            if (childAt != null) {
                int i3 = this.E;
                int i16 = this.F;
                if (i3 == i16) {
                    return childAt.getTop();
                }
                if (i3 < i16) {
                    return childAt.getTop() - dividerHeight;
                }
                return (childAt.getBottom() + dividerHeight) - DragSortListView.this.mFloatViewHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.tencent.mobileqq.emosm.view.DragSortListView.SmoothAnimator
        public void e() {
            DragSortListView dragSortListView = DragSortListView.this;
            this.E = dragSortListView.mFloatPos;
            this.F = dragSortListView.mSrcPos;
            dragSortListView.mDragState = 2;
            this.G = dragSortListView.mFloatLoc.y - j();
            DragSortListView dragSortListView2 = DragSortListView.this;
            this.H = dragSortListView2.mFloatLoc.x - dragSortListView2.getPaddingLeft();
        }

        @Override // com.tencent.mobileqq.emosm.view.DragSortListView.SmoothAnimator
        public void f() {
            DragSortListView.this.dropFloatView();
        }

        @Override // com.tencent.mobileqq.emosm.view.DragSortListView.SmoothAnimator
        public void g(float f16, float f17) {
            int j3 = j();
            int paddingLeft = DragSortListView.this.getPaddingLeft();
            Point point = DragSortListView.this.mFloatLoc;
            float f18 = point.y - j3;
            float f19 = point.x - paddingLeft;
            float f26 = 1.0f - f17;
            if (f26 < Math.abs(f18 / this.G) || f26 < Math.abs(f19 / this.H)) {
                DragSortListView dragSortListView = DragSortListView.this;
                Point point2 = dragSortListView.mFloatLoc;
                point2.y = j3 + ((int) (this.G * f26));
                point2.x = dragSortListView.getPaddingLeft() + ((int) (this.H * f26));
                DragSortListView.this.doDragFloatView(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class LiftAnimator extends SmoothAnimator {
        private float E;
        private float F;
        final /* synthetic */ DragSortListView this$0;

        @Override // com.tencent.mobileqq.emosm.view.DragSortListView.SmoothAnimator
        public void e() {
            DragSortListView dragSortListView = this.this$0;
            this.E = dragSortListView.mDragDeltaY;
            this.F = dragSortListView.mFloatViewHeightHalf;
        }

        @Override // com.tencent.mobileqq.emosm.view.DragSortListView.SmoothAnimator
        public void g(float f16, float f17) {
            DragSortListView dragSortListView = this.this$0;
            if (dragSortListView.mDragState != 4) {
                cancel();
                return;
            }
            int i3 = (int) ((this.F * f17) + ((1.0f - f17) * this.E));
            dragSortListView.mDragDeltaY = i3;
            dragSortListView.mFloatLoc.y = dragSortListView.mY - i3;
            dragSortListView.doDragFloatView(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class RemoveAnimator extends SmoothAnimator {
        private float E;
        private float F;
        private float G;
        private int H;
        private int I;
        private int J;
        private int K;
        private int L;

        public RemoveAnimator(float f16, int i3) {
            super(f16, i3);
            this.H = -1;
            this.I = -1;
        }

        @Override // com.tencent.mobileqq.emosm.view.DragSortListView.SmoothAnimator
        public void e() {
            int i3 = -1;
            this.H = -1;
            this.I = -1;
            DragSortListView dragSortListView = DragSortListView.this;
            this.J = dragSortListView.mFirstExpPos;
            this.K = dragSortListView.mSecondExpPos;
            this.L = dragSortListView.mSrcPos;
            dragSortListView.mDragState = 1;
            this.E = dragSortListView.mFloatLoc.x;
            if (dragSortListView.mUseRemoveVelocity) {
                float width = dragSortListView.getWidth() * 2.0f;
                DragSortListView dragSortListView2 = DragSortListView.this;
                float f16 = dragSortListView2.mRemoveVelocityX;
                if (f16 == 0.0f) {
                    if (this.E >= 0.0f) {
                        i3 = 1;
                    }
                    dragSortListView2.mRemoveVelocityX = i3 * width;
                    return;
                }
                float f17 = width * 2.0f;
                if (f16 < 0.0f) {
                    float f18 = -f17;
                    if (f16 > f18) {
                        dragSortListView2.mRemoveVelocityX = f18;
                        return;
                    }
                }
                if (f16 > 0.0f && f16 < f17) {
                    dragSortListView2.mRemoveVelocityX = f17;
                    return;
                }
                return;
            }
            dragSortListView.destroyFloatView();
        }

        @Override // com.tencent.mobileqq.emosm.view.DragSortListView.SmoothAnimator
        public void f() {
            DragSortListView.this.doRemoveItem();
        }

        @Override // com.tencent.mobileqq.emosm.view.DragSortListView.SmoothAnimator
        public void g(float f16, float f17) {
            View childAt;
            int i3;
            float f18 = 1.0f - f17;
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            View childAt2 = DragSortListView.this.getChildAt(this.J - firstVisiblePosition);
            if (DragSortListView.this.mUseRemoveVelocity) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f204421d)) / 1000.0f;
                if (uptimeMillis == 0.0f) {
                    return;
                }
                DragSortListView dragSortListView = DragSortListView.this;
                float f19 = dragSortListView.mRemoveVelocityX * uptimeMillis;
                int width = dragSortListView.getWidth();
                DragSortListView dragSortListView2 = DragSortListView.this;
                float f26 = dragSortListView2.mRemoveVelocityX;
                if (f26 > 0.0f) {
                    i3 = 1;
                } else {
                    i3 = -1;
                }
                float f27 = i3 * uptimeMillis;
                float f28 = width;
                dragSortListView2.mRemoveVelocityX = f26 + (f27 * f28);
                float f29 = this.E + f19;
                this.E = f29;
                dragSortListView2.mFloatLoc.x = (int) f29;
                if (f29 < f28 && f29 > (-width)) {
                    this.f204421d = SystemClock.uptimeMillis();
                    DragSortListView.this.doDragFloatView(true);
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.H == -1) {
                    this.H = DragSortListView.this.getChildHeight(this.J, childAt2, false);
                    this.F = childAt2.getHeight() - this.H;
                }
                int max = Math.max((int) (this.F * f18), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = this.H + max;
                childAt2.setLayoutParams(layoutParams);
            }
            int i16 = this.K;
            if (i16 != this.J && (childAt = DragSortListView.this.getChildAt(i16 - firstVisiblePosition)) != null) {
                if (this.I == -1) {
                    this.I = DragSortListView.this.getChildHeight(this.K, childAt, false);
                    this.G = childAt.getHeight() - this.I;
                }
                int max2 = Math.max((int) (f18 * this.G), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = this.I + max2;
                childAt.setLayoutParams(layoutParams2);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements e {
        a() {
        }

        @Override // com.tencent.mobileqq.emosm.view.DragSortListView.e
        public float getSpeed(float f16, long j3) {
            return DragSortListView.this.mMaxScrollSpeed * f16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class b extends DataSetObserver {
        b() {
        }

        private void a() {
            DragSortListView dragSortListView = DragSortListView.this;
            if (dragSortListView.mDragState == 4) {
                dragSortListView.cancelDrag();
            }
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class c extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private ListAdapter f204429d;

        /* compiled from: P */
        /* loaded from: classes6.dex */
        class a extends DataSetObserver {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ DragSortListView f204431a;

            a(DragSortListView dragSortListView) {
                this.f204431a = dragSortListView;
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                c.this.notifyDataSetChanged();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                c.this.notifyDataSetInvalidated();
            }
        }

        public c(ListAdapter listAdapter) {
            this.f204429d = listAdapter;
            listAdapter.registerDataSetObserver(new a(DragSortListView.this));
        }

        public ListAdapter a() {
            return this.f204429d;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return this.f204429d.areAllItemsEnabled();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f204429d.getCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return this.f204429d.getItem(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return this.f204429d.getItemId(i3);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            return this.f204429d.getItemViewType(i3);
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            DragSortItemView dragSortItemView;
            DragSortItemView dragSortItemView2;
            if (view != null) {
                dragSortItemView2 = (DragSortItemView) view;
                View childAt = dragSortItemView2.getChildAt(0);
                View view2 = this.f204429d.getView(i3, childAt, DragSortListView.this);
                if (view2 != childAt) {
                    if (childAt != null) {
                        dragSortItemView2.removeViewAt(0);
                    }
                    dragSortItemView2.addView(view2);
                }
            } else {
                View view3 = this.f204429d.getView(i3, null, DragSortListView.this);
                if (view3 instanceof Checkable) {
                    dragSortItemView = new DragSortItemViewCheckable(DragSortListView.this.getContext());
                } else {
                    dragSortItemView = new DragSortItemView(DragSortListView.this.getContext());
                }
                dragSortItemView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                dragSortItemView.addView(view3);
                dragSortItemView2 = dragSortItemView;
            }
            DragSortListView dragSortListView = DragSortListView.this;
            dragSortListView.adjustItem(dragSortListView.getHeaderViewsCount() + i3, dragSortItemView2, true);
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return dragSortItemView2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return this.f204429d.getViewTypeCount();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return this.f204429d.hasStableIds();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean isEmpty() {
            return this.f204429d.isEmpty();
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i3) {
            return this.f204429d.isEnabled(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface d {
        void drag(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface e {
        float getSpeed(float f16, long j3);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface f extends h, d, l {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class g {

        /* renamed from: b, reason: collision with root package name */
        File f204434b;

        /* renamed from: a, reason: collision with root package name */
        StringBuilder f204433a = new StringBuilder();

        /* renamed from: c, reason: collision with root package name */
        private int f204435c = 0;

        /* renamed from: d, reason: collision with root package name */
        private int f204436d = 0;

        /* renamed from: e, reason: collision with root package name */
        private boolean f204437e = false;

        public g() {
            File file = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
            this.f204434b = file;
            if (!file.exists()) {
                try {
                    this.f204434b.createNewFile();
                } catch (IOException unused) {
                }
            }
        }

        public void a() {
            if (!this.f204437e) {
                return;
            }
            this.f204433a.append("<DSLVState>\n");
            int childCount = DragSortListView.this.getChildCount();
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            this.f204433a.append("    <Positions>");
            for (int i3 = 0; i3 < childCount; i3++) {
                StringBuilder sb5 = this.f204433a;
                sb5.append(firstVisiblePosition + i3);
                sb5.append(",");
            }
            this.f204433a.append("</Positions>\n");
            this.f204433a.append("    <Tops>");
            for (int i16 = 0; i16 < childCount; i16++) {
                StringBuilder sb6 = this.f204433a;
                sb6.append(DragSortListView.this.getChildAt(i16).getTop());
                sb6.append(",");
            }
            this.f204433a.append("</Tops>\n");
            this.f204433a.append("    <Bottoms>");
            for (int i17 = 0; i17 < childCount; i17++) {
                StringBuilder sb7 = this.f204433a;
                sb7.append(DragSortListView.this.getChildAt(i17).getBottom());
                sb7.append(",");
            }
            this.f204433a.append("</Bottoms>\n");
            StringBuilder sb8 = this.f204433a;
            sb8.append("    <FirstExpPos>");
            sb8.append(DragSortListView.this.mFirstExpPos);
            sb8.append("</FirstExpPos>\n");
            StringBuilder sb9 = this.f204433a;
            sb9.append("    <FirstExpBlankHeight>");
            DragSortListView dragSortListView = DragSortListView.this;
            int itemHeight = dragSortListView.getItemHeight(dragSortListView.mFirstExpPos);
            DragSortListView dragSortListView2 = DragSortListView.this;
            sb9.append(itemHeight - dragSortListView2.getChildHeight(dragSortListView2.mFirstExpPos));
            sb9.append("</FirstExpBlankHeight>\n");
            StringBuilder sb10 = this.f204433a;
            sb10.append("    <SecondExpPos>");
            sb10.append(DragSortListView.this.mSecondExpPos);
            sb10.append("</SecondExpPos>\n");
            StringBuilder sb11 = this.f204433a;
            sb11.append("    <SecondExpBlankHeight>");
            DragSortListView dragSortListView3 = DragSortListView.this;
            int itemHeight2 = dragSortListView3.getItemHeight(dragSortListView3.mSecondExpPos);
            DragSortListView dragSortListView4 = DragSortListView.this;
            sb11.append(itemHeight2 - dragSortListView4.getChildHeight(dragSortListView4.mSecondExpPos));
            sb11.append("</SecondExpBlankHeight>\n");
            StringBuilder sb12 = this.f204433a;
            sb12.append("    <SrcPos>");
            sb12.append(DragSortListView.this.mSrcPos);
            sb12.append("</SrcPos>\n");
            StringBuilder sb13 = this.f204433a;
            sb13.append("    <SrcHeight>");
            DragSortListView dragSortListView5 = DragSortListView.this;
            sb13.append(dragSortListView5.mFloatViewHeight + dragSortListView5.getDividerHeight());
            sb13.append("</SrcHeight>\n");
            StringBuilder sb14 = this.f204433a;
            sb14.append("    <ViewHeight>");
            sb14.append(DragSortListView.this.getHeight());
            sb14.append("</ViewHeight>\n");
            StringBuilder sb15 = this.f204433a;
            sb15.append("    <LastY>");
            sb15.append(DragSortListView.this.mLastY);
            sb15.append("</LastY>\n");
            StringBuilder sb16 = this.f204433a;
            sb16.append("    <FloatY>");
            sb16.append(DragSortListView.this.mFloatViewMid);
            sb16.append("</FloatY>\n");
            this.f204433a.append("    <ShuffleEdges>");
            for (int i18 = 0; i18 < childCount; i18++) {
                StringBuilder sb17 = this.f204433a;
                DragSortListView dragSortListView6 = DragSortListView.this;
                sb17.append(dragSortListView6.getShuffleEdge(firstVisiblePosition + i18, dragSortListView6.getChildAt(i18).getTop()));
                sb17.append(",");
            }
            this.f204433a.append("</ShuffleEdges>\n");
            this.f204433a.append("</DSLVState>\n");
            int i19 = this.f204435c + 1;
            this.f204435c = i19;
            if (i19 > 1000) {
                b();
                this.f204435c = 0;
            }
        }

        public void b() {
            boolean z16;
            FileWriter fileWriter;
            if (!this.f204437e) {
                return;
            }
            if (this.f204436d == 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            FileWriter fileWriter2 = null;
            try {
                try {
                    fileWriter = new FileWriter(this.f204434b, z16);
                } catch (IOException unused) {
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    fileWriter.write(this.f204433a.toString());
                    StringBuilder sb5 = this.f204433a;
                    sb5.delete(0, sb5.length());
                    fileWriter.flush();
                    this.f204436d++;
                    fileWriter.close();
                } catch (IOException unused2) {
                    fileWriter2 = fileWriter;
                    if (fileWriter2 != null) {
                        fileWriter2.close();
                    }
                } catch (Throwable th6) {
                    th = th6;
                    fileWriter2 = fileWriter;
                    if (fileWriter2 != null) {
                        try {
                            fileWriter2.close();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e17) {
                e17.printStackTrace();
            }
        }

        public void c() {
            this.f204433a.append("<DSLVStates>\n");
            this.f204436d = 0;
            this.f204437e = true;
        }

        public void d() {
            if (this.f204437e) {
                this.f204433a.append("</DSLVStates>\n");
                b();
                this.f204437e = false;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface h {
        void drop(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface i {
        View onCreateFloatView(int i3);

        void onDestroyFloatView(View view);

        void onDragFloatView(View view, Point point, Point point2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class j {

        /* renamed from: a, reason: collision with root package name */
        private SparseIntArray f204439a;

        /* renamed from: b, reason: collision with root package name */
        private ArrayList<Integer> f204440b;

        /* renamed from: c, reason: collision with root package name */
        private int f204441c;

        public j(int i3) {
            this.f204439a = new SparseIntArray(i3);
            this.f204440b = new ArrayList<>(i3);
            this.f204441c = i3;
        }

        public void a(int i3, int i16) {
            int i17 = this.f204439a.get(i3, -1);
            if (i17 != i16) {
                if (i17 == -1) {
                    if (this.f204439a.size() == this.f204441c) {
                        this.f204439a.delete(this.f204440b.remove(0).intValue());
                    }
                } else {
                    this.f204440b.remove(Integer.valueOf(i3));
                }
                this.f204439a.put(i3, i16);
                this.f204440b.add(Integer.valueOf(i3));
            }
        }

        public void b() {
            this.f204439a.clear();
            this.f204440b.clear();
        }

        public int c(int i3) {
            return this.f204439a.get(i3, -1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface k {
        void a(int i3);

        void b(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface l {
        void remove(int i3);
    }

    public DragSortListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i3;
        float f16;
        boolean z16;
        this.mFloatLoc = new Point();
        this.mTouchLoc = new Point();
        this.mFloatViewOnMeasured = false;
        this.mFloatAlpha = 1.0f;
        this.mCurrFloatAlpha = 1.0f;
        this.mAnimate = false;
        this.mDragEnabled = true;
        this.ignoreDeleteEnabled = false;
        this.mDragState = 0;
        this.mItemHeightCollapsed = 1;
        this.mWidthMeasureSpec = 0;
        this.mSampleViewTypes = new View[1];
        this.mDragUpScrollStartFrac = 0.33333334f;
        this.mDragDownScrollStartFrac = 0.33333334f;
        this.mMaxScrollSpeed = 0.5f;
        this.mScrollProfile = new a();
        this.mDragFlags = 0;
        this.mLastCallWasIntercept = false;
        this.mInTouchEvent = false;
        this.mFloatViewManager = null;
        this.mCancelMethod = 0;
        this.mSlideRegionFrac = 0.25f;
        this.mSlideFrac = 0.0f;
        this.mTrackDragSort = false;
        this.mBlockLayoutRequests = false;
        this.mIgnoreTouchEvent = false;
        this.mChildHeightCache = new j(3);
        this.mRemoveVelocityX = 0.0f;
        this.mLastShowTime = 0L;
        this.mListViewIntercepted = false;
        this.mIsItemEvent = true;
        this.mFloatViewInvalidated = false;
        this.mProgressPos = -1;
        this.mShaderRect = null;
        int i16 = 150;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, jj2.b.f410044f1, 0, 0);
            this.mItemHeightCollapsed = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410068h1, 1));
            boolean z17 = obtainStyledAttributes.getBoolean(jj2.b.f410247x1, false);
            this.mTrackDragSort = z17;
            if (z17) {
                this.mDragSortTracker = new g();
            }
            float f17 = obtainStyledAttributes.getFloat(jj2.b.f410146o1, this.mFloatAlpha);
            this.mFloatAlpha = f17;
            this.mCurrFloatAlpha = f17;
            this.mDragEnabled = obtainStyledAttributes.getBoolean(jj2.b.f410080i1, this.mDragEnabled);
            this.ignoreDeleteEnabled = obtainStyledAttributes.getBoolean(jj2.b.f410170q1, this.ignoreDeleteEnabled);
            float max = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(jj2.b.f410227v1, 0.75f)));
            this.mSlideRegionFrac = max;
            if (max > 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mAnimate = z16;
            setDragScrollStart(obtainStyledAttributes.getFloat(jj2.b.f410102k1, this.mDragUpScrollStartFrac));
            this.mMaxScrollSpeed = obtainStyledAttributes.getFloat(jj2.b.f410182r1, this.mMaxScrollSpeed);
            int i17 = obtainStyledAttributes.getInt(jj2.b.f410194s1, 150);
            i3 = obtainStyledAttributes.getInt(jj2.b.f410124m1, 150);
            if (obtainStyledAttributes.getBoolean(jj2.b.f410258y1, true)) {
                boolean z18 = obtainStyledAttributes.getBoolean(jj2.b.f410205t1, false);
                int i18 = obtainStyledAttributes.getInt(jj2.b.f410216u1, 1);
                boolean z19 = obtainStyledAttributes.getBoolean(jj2.b.f410237w1, true);
                int i19 = obtainStyledAttributes.getInt(jj2.b.f410113l1, 0);
                int resourceId = obtainStyledAttributes.getResourceId(jj2.b.f410091j1, 0);
                int resourceId2 = obtainStyledAttributes.getResourceId(jj2.b.f410135n1, 0);
                int resourceId3 = obtainStyledAttributes.getResourceId(jj2.b.f410056g1, 0);
                int color = obtainStyledAttributes.getColor(jj2.b.f410158p1, -16777216);
                com.tencent.mobileqq.emosm.view.c cVar = new com.tencent.mobileqq.emosm.view.c(this, resourceId, i19, i18, resourceId3, resourceId2);
                cVar.g(z18);
                cVar.j(z19);
                cVar.a(color);
                this.mFloatViewManager = cVar;
                super.setOnTouchListener(cVar);
            }
            obtainStyledAttributes.recycle();
            i16 = i17;
        } else {
            i3 = 150;
        }
        this.mDragScroller = new DragScroller();
        this.mDelImmediately = true;
        if (i16 > 0) {
            f16 = 0.5f;
            this.mRemoveAnimator = new RemoveAnimator(0.5f, i16);
        } else {
            f16 = 0.5f;
        }
        if (i3 > 0) {
            this.mDropAnimator = new DropAnimator(f16, i3);
        }
        this.mCancelEvent = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        this.mObserver = new b();
    }

    private void adjustAllItems() {
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        int min = Math.min(lastVisiblePosition - firstVisiblePosition, ((getCount() - 1) - getFooterViewsCount()) - firstVisiblePosition);
        for (int max = Math.max(0, getHeaderViewsCount() - firstVisiblePosition); max <= min; max++) {
            View childAt = getChildAt(max);
            if (childAt != null) {
                adjustItem(firstVisiblePosition + max, childAt, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adjustItem(int i3, View view, boolean z16) {
        int calcItemHeight;
        int i16;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (i3 != this.mSrcPos && i3 != this.mFirstExpPos && i3 != this.mSecondExpPos) {
            calcItemHeight = -2;
        } else {
            calcItemHeight = calcItemHeight(i3, view, z16);
        }
        if (calcItemHeight != layoutParams.height) {
            layoutParams.height = calcItemHeight;
            view.setLayoutParams(layoutParams);
        }
        if (i3 == this.mFirstExpPos || i3 == this.mSecondExpPos) {
            int i17 = this.mSrcPos;
            if (i3 < i17) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i3 > i17) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        if (i3 == this.mSrcPos && this.mFloatView != null) {
            i16 = 4;
        } else {
            i16 = 0;
        }
        if (i16 != visibility) {
            view.setVisibility(i16);
        }
    }

    private void adjustOnReorder() {
        int firstVisiblePosition = super.getFirstVisiblePosition();
        if (this.mSrcPos < firstVisiblePosition) {
            int i3 = 0;
            View childAt = super.getChildAt(0);
            if (childAt != null) {
                i3 = childAt.getTop();
            }
            super.setSelectionFromTop(firstVisiblePosition - 1, i3 - getPaddingTop());
        }
    }

    private int adjustScroll(int i3, View view, int i16, int i17) {
        int i18;
        int i19;
        int childHeight = getChildHeight(i3);
        int height = view.getHeight();
        int calcItemHeight = calcItemHeight(i3, childHeight);
        int i26 = this.mSrcPos;
        if (i3 != i26) {
            i18 = height - childHeight;
            i19 = calcItemHeight - childHeight;
        } else {
            i18 = height;
            i19 = calcItemHeight;
        }
        int i27 = this.mFloatViewHeight;
        int i28 = this.mFirstExpPos;
        if (i26 != i28 && i26 != this.mSecondExpPos) {
            i27 -= this.mItemHeightCollapsed;
        }
        if (i3 <= i16) {
            if (i3 <= i28) {
                return 0;
            }
            return 0 + (i27 - i19);
        }
        if (i3 == i17) {
            if (i3 <= i28) {
                i18 -= i27;
            } else if (i3 == this.mSecondExpPos) {
                return 0 + (height - calcItemHeight);
            }
            return 0 + i18;
        }
        if (i3 <= i28) {
            return 0 - i27;
        }
        if (i3 != this.mSecondExpPos) {
            return 0;
        }
        return 0 - i19;
    }

    private static int buildRunList(SparseBooleanArray sparseBooleanArray, int i3, int i16, int[] iArr, int[] iArr2) {
        int keyAt;
        int findFirstSetIndex = findFirstSetIndex(sparseBooleanArray, i3, i16);
        if (findFirstSetIndex == -1) {
            return 0;
        }
        int keyAt2 = sparseBooleanArray.keyAt(findFirstSetIndex);
        int i17 = keyAt2 + 1;
        int i18 = 0;
        for (int i19 = findFirstSetIndex + 1; i19 < sparseBooleanArray.size() && (keyAt = sparseBooleanArray.keyAt(i19)) < i16; i19++) {
            if (sparseBooleanArray.valueAt(i19)) {
                if (keyAt == i17) {
                    i17++;
                } else {
                    iArr[i18] = keyAt2;
                    iArr2[i18] = i17;
                    i18++;
                    i17 = keyAt + 1;
                    keyAt2 = keyAt;
                }
            }
        }
        if (i17 == i16) {
            i17 = i3;
        }
        iArr[i18] = keyAt2;
        iArr2[i18] = i17;
        int i26 = i18 + 1;
        if (i26 > 1 && iArr[0] == i3) {
            int i27 = i26 - 1;
            if (iArr2[i27] == i3) {
                iArr[0] = iArr[i27];
                return i26 - 1;
            }
            return i26;
        }
        return i26;
    }

    private int calcItemHeight(int i3, View view, boolean z16) {
        return calcItemHeight(i3, getChildHeight(i3, view, z16));
    }

    private void clearPositions() {
        this.mSrcPos = -1;
        this.mFirstExpPos = -1;
        this.mSecondExpPos = -1;
        this.mFloatPos = -1;
    }

    private void continueDrag(int i3, int i16) {
        Point point = this.mFloatLoc;
        point.x = i3 - this.mDragDeltaX;
        point.y = i16 - this.mDragDeltaY;
        doDragFloatView(true);
        int min = Math.min(i16, this.mFloatViewMid + this.mFloatViewHeightHalf);
        int max = Math.max(i16, this.mFloatViewMid - this.mFloatViewHeightHalf);
        int e16 = this.mDragScroller.e();
        int i17 = this.mLastY;
        if (min > i17 && min > this.mDownScrollStartY && e16 != 1) {
            if (e16 != -1) {
                this.mDragScroller.h(true);
            }
            this.mDragScroller.g(1);
        } else if (max < i17 && max < this.mUpScrollStartY && e16 != 0) {
            if (e16 != -1) {
                this.mDragScroller.h(true);
            }
            this.mDragScroller.g(0);
        } else if (max >= this.mUpScrollStartY && min <= this.mDownScrollStartY && this.mDragScroller.f()) {
            this.mDragScroller.h(true);
        }
    }

    private void doActionUpOrCancel() {
        this.mCancelMethod = 0;
        this.mInTouchEvent = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.mCurrFloatAlpha = this.mFloatAlpha;
        this.mListViewIntercepted = false;
        this.mChildHeightCache.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRemoveItem() {
        doRemoveItem(this.mSrcPos - getHeaderViewsCount());
    }

    private void drawDivider(int i3, Canvas canvas) {
        ViewGroup viewGroup;
        int i16;
        int i17;
        Drawable divider = super.getDivider();
        int dividerHeight = super.getDividerHeight();
        if (divider != null && dividerHeight != 0 && (viewGroup = (ViewGroup) super.getChildAt(i3 - getFirstVisiblePosition())) != null) {
            int paddingLeft = super.getPaddingLeft();
            int width = super.getWidth() - super.getPaddingRight();
            int height = viewGroup.getChildAt(0).getHeight();
            if (i3 > this.mSrcPos) {
                i17 = viewGroup.getTop() + height;
                i16 = dividerHeight + i17;
            } else {
                int bottom = viewGroup.getBottom() - height;
                int i18 = bottom - dividerHeight;
                i16 = bottom;
                i17 = i18;
            }
            canvas.save();
            canvas.clipRect(paddingLeft, i17, width, i16);
            divider.setBounds(paddingLeft, i17, width, i16);
            divider.draw(canvas);
            canvas.restore();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dropFloatView() {
        int i3;
        this.mDragState = 2;
        if (this.mDropListener != null && (i3 = this.mFloatPos) >= 0 && i3 < getCount()) {
            int headerViewsCount = getHeaderViewsCount();
            this.mDropListener.drop(this.mSrcPos - headerViewsCount, this.mFloatPos - headerViewsCount);
        }
        destroyFloatView();
        adjustOnReorder();
        clearPositions();
        adjustAllItems();
        if (this.mInTouchEvent) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        if (r2.keyAt(r3) < r4) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:?, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int findFirstSetIndex(SparseBooleanArray sparseBooleanArray, int i3, int i16) {
        int size = sparseBooleanArray.size();
        int insertionIndexForKey = insertionIndexForKey(sparseBooleanArray, i3);
        while (insertionIndexForKey < size && sparseBooleanArray.keyAt(insertionIndexForKey) < i16 && !sparseBooleanArray.valueAt(insertionIndexForKey)) {
            insertionIndexForKey++;
        }
        return -1;
    }

    private int getEventPosition(MotionEvent motionEvent) {
        return super.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    private ImageView getLeftIndicator(int i3) {
        View childAt;
        int firstVisiblePosition = i3 - getFirstVisiblePosition();
        if (firstVisiblePosition >= 0 && firstVisiblePosition <= getChildCount() && (childAt = super.getChildAt(firstVisiblePosition)) != null) {
            return (ImageView) childAt.findViewById(R.id.bvh);
        }
        return null;
    }

    private boolean handleOnTouchEvent(MotionEvent motionEvent) {
        boolean z16 = this.mLastCallWasIntercept;
        boolean z17 = false;
        this.mLastCallWasIntercept = false;
        if (!z16) {
            saveTouchCoords(motionEvent);
        }
        int i3 = this.mDragState;
        if (i3 == 4) {
            onDragTouchEvent(motionEvent);
            return true;
        }
        if (i3 == 0 && super.onTouchEvent(motionEvent)) {
            z17 = true;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 1 && action != 3) {
            if (z17) {
                this.mCancelMethod = 1;
            }
        } else {
            doActionUpOrCancel();
        }
        return z17;
    }

    private static int insertionIndexForKey(SparseBooleanArray sparseBooleanArray, int i3) {
        int size = sparseBooleanArray.size();
        int i16 = 0;
        while (size - i16 > 0) {
            int i17 = (i16 + size) >> 1;
            if (sparseBooleanArray.keyAt(i17) < i3) {
                i16 = i17 + 1;
            } else {
                size = i17;
            }
        }
        return i16;
    }

    private void invalidateFloatView() {
        this.mFloatViewInvalidated = true;
    }

    private boolean isEventInView(View view, int i3, int i16) {
        if (this.mShaderRect == null) {
            this.mShaderRect = new Rect();
        }
        view.getDrawingRect(this.mShaderRect);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect rect = this.mShaderRect;
        int i17 = iArr[0];
        rect.left = i17;
        int i18 = iArr[1];
        rect.top = i18;
        rect.right += i17;
        rect.bottom += i18;
        return rect.contains(i3, i16);
    }

    private void measureFloatView() {
        View view = this.mFloatView;
        if (view != null) {
            measureItem(view);
            int measuredHeight = this.mFloatView.getMeasuredHeight();
            this.mFloatViewHeight = measuredHeight;
            this.mFloatViewHeightHalf = measuredHeight / 2;
        }
    }

    private void measureItem(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -2);
            view.setLayoutParams(layoutParams);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, getListPaddingLeft() + getListPaddingRight(), layoutParams.width);
        int i3 = layoutParams.height;
        if (i3 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    private boolean onDragDisableTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.mIsDelShow) {
                if (this.mIsDelEvent) {
                    if (this.mDelImmediately) {
                        hideDelButtonWithoutAnimation();
                        removeItem(this.mSrcPos);
                        this.mIsDelEvent = false;
                    } else {
                        l lVar = this.mRemoveListener;
                        if (lVar != null) {
                            lVar.remove(this.mSrcPos);
                        }
                        this.mIsDelEvent = false;
                        return false;
                    }
                } else {
                    hideDelButton();
                }
                this.mIsDelShow = false;
                return false;
            }
            Button button = (Button) getItemChild(this.mTapPos, R.id.kiu);
            if (this.mIsUpdateEvent && button != null) {
                this.mIsUpdateEvent = false;
                this.mIsItemEvent = true;
                return false;
            }
            if (!this.mIsItemEvent) {
                this.mIsItemEvent = true;
                return true;
            }
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (ArrayIndexOutOfBoundsException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private static int rotate(int i3, int i16, int i17, int i18) {
        int i19 = i18 - i17;
        int i26 = i3 + i16;
        if (i26 < i17) {
            return i26 + i19;
        }
        if (i26 >= i18) {
            return i26 - i19;
        }
        return i26;
    }

    private void saveTouchCoords(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.mLastX = this.mX;
            this.mLastY = this.mY;
        }
        this.mX = (int) motionEvent.getX();
        int y16 = (int) motionEvent.getY();
        this.mY = y16;
        if (action == 0) {
            this.mLastX = this.mX;
            this.mLastY = y16;
        }
        this.mOffsetX = ((int) motionEvent.getRawX()) - this.mX;
        this.mOffsetY = ((int) motionEvent.getRawY()) - this.mY;
    }

    private void updateFloatView() {
        int i3;
        int i16;
        if (this.mFloatViewManager != null) {
            this.mTouchLoc.set(this.mX, this.mY);
            this.mFloatViewManager.onDragFloatView(this.mFloatView, this.mFloatLoc, this.mTouchLoc);
        }
        Point point = this.mFloatLoc;
        int i17 = point.x;
        int i18 = point.y;
        int paddingLeft = getPaddingLeft();
        int i19 = this.mDragFlags;
        if ((i19 & 1) == 0 && i17 > paddingLeft) {
            this.mFloatLoc.x = paddingLeft;
        } else if ((i19 & 2) == 0 && i17 < paddingLeft) {
            this.mFloatLoc.x = paddingLeft;
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        int paddingTop = getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.mDragFlags & 8) == 0 && firstVisiblePosition <= (i16 = this.mSrcPos)) {
            paddingTop = Math.max(getChildAt(i16 - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = getHeight() - getPaddingBottom();
        if (lastVisiblePosition >= (getCount() - footerViewsCount) - 1) {
            height = getChildAt(((getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.mDragFlags & 4) == 0 && lastVisiblePosition >= (i3 = this.mSrcPos)) {
            height = Math.min(getChildAt(i3 - firstVisiblePosition).getBottom(), height);
        }
        if (i18 < paddingTop) {
            this.mFloatLoc.y = paddingTop;
        } else {
            int i26 = this.mFloatViewHeight;
            if (i18 + i26 > height) {
                this.mFloatLoc.y = height - i26;
            }
        }
        this.mFloatViewMid = this.mFloatLoc.y + this.mFloatViewHeightHalf;
    }

    private boolean updatePositions() {
        int i3;
        int i16;
        boolean z16;
        int firstVisiblePosition = super.getFirstVisiblePosition();
        int i17 = this.mFirstExpPos;
        View childAt = super.getChildAt(i17 - firstVisiblePosition);
        if (childAt == null) {
            i17 = (getChildCount() / 2) + firstVisiblePosition;
            childAt = super.getChildAt(i17 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int shuffleEdge = getShuffleEdge(i17, top);
        int dividerHeight = super.getDividerHeight();
        if (this.mFloatViewMid < shuffleEdge) {
            while (i17 >= 0) {
                i17--;
                int itemHeight = getItemHeight(i17);
                if (i17 == 0) {
                    i3 = (top - dividerHeight) - itemHeight;
                    int i18 = shuffleEdge;
                    shuffleEdge = i3;
                    i16 = i18;
                    break;
                }
                top -= itemHeight + dividerHeight;
                int shuffleEdge2 = getShuffleEdge(i17, top);
                if (this.mFloatViewMid >= shuffleEdge2) {
                    i16 = shuffleEdge;
                    shuffleEdge = shuffleEdge2;
                    break;
                }
                shuffleEdge = shuffleEdge2;
            }
            i16 = shuffleEdge;
        } else {
            int count = getCount();
            while (i17 < count) {
                if (i17 == count - 1) {
                    i3 = top + dividerHeight + height;
                    int i182 = shuffleEdge;
                    shuffleEdge = i3;
                    i16 = i182;
                    break;
                }
                top += height + dividerHeight;
                int i19 = i17 + 1;
                int itemHeight2 = getItemHeight(i19);
                int shuffleEdge3 = getShuffleEdge(i19, top);
                if (this.mFloatViewMid < shuffleEdge3) {
                    i16 = shuffleEdge;
                    shuffleEdge = shuffleEdge3;
                    break;
                }
                i17 = i19;
                height = itemHeight2;
                shuffleEdge = shuffleEdge3;
            }
            i16 = shuffleEdge;
        }
        int headerViewsCount = super.getHeaderViewsCount();
        int footerViewsCount = super.getFooterViewsCount();
        int i26 = this.mFirstExpPos;
        int i27 = this.mSecondExpPos;
        float f16 = this.mSlideFrac;
        if (this.mAnimate) {
            int abs = Math.abs(shuffleEdge - i16);
            int i28 = this.mFloatViewMid;
            if (i28 < shuffleEdge) {
                int i29 = shuffleEdge;
                shuffleEdge = i16;
                i16 = i29;
            }
            int i36 = (int) (this.mSlideRegionFrac * 0.5f * abs);
            float f17 = i36;
            int i37 = shuffleEdge + i36;
            int i38 = i16 - i36;
            if (i28 < i37) {
                this.mFirstExpPos = i17 - 1;
                this.mSecondExpPos = i17;
                this.mSlideFrac = ((i37 - i28) * 0.5f) / f17;
            } else if (i28 < i38) {
                this.mFirstExpPos = i17;
                this.mSecondExpPos = i17;
            } else {
                this.mFirstExpPos = i17;
                this.mSecondExpPos = i17 + 1;
                this.mSlideFrac = (((i16 - i28) / f17) + 1.0f) * 0.5f;
            }
        } else {
            this.mFirstExpPos = i17;
            this.mSecondExpPos = i17;
        }
        if (this.mFirstExpPos < headerViewsCount) {
            this.mFirstExpPos = headerViewsCount;
            this.mSecondExpPos = headerViewsCount;
            i17 = headerViewsCount;
        } else if (this.mSecondExpPos >= getCount() - footerViewsCount) {
            i17 = (super.getCount() - footerViewsCount) - 1;
            this.mFirstExpPos = i17;
            this.mSecondExpPos = i17;
        }
        if (this.mFirstExpPos == i26 && this.mSecondExpPos == i27 && this.mSlideFrac == f16) {
            z16 = false;
        } else {
            z16 = true;
        }
        int i39 = this.mFloatPos;
        if (i17 != i39) {
            d dVar = this.mDragListener;
            if (dVar != null) {
                dVar.drag(i39 - headerViewsCount, i17 - headerViewsCount);
            }
            this.mFloatPos = i17;
            return true;
        }
        return z16;
    }

    private void updateScrollStarts() {
        int paddingTop = getPaddingTop();
        float height = (getHeight() - paddingTop) - getPaddingBottom();
        float f16 = paddingTop;
        float f17 = (this.mDragUpScrollStartFrac * height) + f16;
        this.mUpScrollStartYF = f17;
        float f18 = ((1.0f - this.mDragDownScrollStartFrac) * height) + f16;
        this.mDownScrollStartYF = f18;
        this.mUpScrollStartY = (int) f17;
        this.mDownScrollStartY = (int) f18;
        this.mDragUpScrollHeight = f17 - f16;
        this.mDragDownScrollHeight = (paddingTop + r1) - f18;
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.mDragScroller.h(true);
            destroyFloatView();
            clearPositions();
            adjustAllItems();
            if (this.mInTouchEvent) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    public void clickDelForAndroid8() {
        if (this.mIsDelShow && VersionUtils.isOreo() && QQUIAppSetting.enableTalkBack()) {
            if (this.mDelImmediately) {
                hideDelButtonWithoutAnimation();
                removeItem(this.mSrcPos);
                this.mIsDelEvent = false;
            } else {
                l lVar = this.mRemoveListener;
                if (lVar != null) {
                    lVar.remove(this.mSrcPos);
                }
                this.mIsDelEvent = false;
            }
            this.mIsDelShow = false;
        }
    }

    void destroyFloatView() {
        View view = this.mFloatView;
        if (view != null) {
            view.setVisibility(8);
            i iVar = this.mFloatViewManager;
            if (iVar != null) {
                iVar.onDestroyFloatView(this.mFloatView);
            }
            this.mFloatView = null;
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.XListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        float f16;
        super.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            int i3 = this.mFirstExpPos;
            if (i3 != this.mSrcPos) {
                drawDivider(i3, canvas);
            }
            int i16 = this.mSecondExpPos;
            if (i16 != this.mFirstExpPos && i16 != this.mSrcPos) {
                drawDivider(i16, canvas);
            }
        }
        View view = this.mFloatView;
        if (view != null) {
            int width = view.getWidth();
            int height = this.mFloatView.getHeight();
            int i17 = this.mFloatLoc.x;
            int width2 = getWidth();
            if (i17 < 0) {
                i17 = -i17;
            }
            if (i17 < width2) {
                float f17 = (width2 - i17) / width2;
                f16 = f17 * f17;
            } else {
                f16 = 0.0f;
            }
            int i18 = (int) (this.mCurrFloatAlpha * 255.0f * f16);
            canvas.save();
            Point point = this.mFloatLoc;
            canvas.translate(point.x, point.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i18, 31);
            this.mFloatView.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    void doDragFloatView(boolean z16) {
        int firstVisiblePosition = getFirstVisiblePosition() + (getChildCount() / 2);
        View childAt = getChildAt(getChildCount() / 2);
        if (childAt == null) {
            return;
        }
        doDragFloatView(firstVisiblePosition, childAt, z16);
    }

    int getChildHeight(int i3) {
        View view;
        if (i3 == this.mSrcPos) {
            return 0;
        }
        View childAt = getChildAt(i3 - getFirstVisiblePosition());
        if (childAt != null) {
            return getChildHeight(i3, childAt, false);
        }
        int c16 = this.mChildHeightCache.c(i3);
        if (c16 != -1) {
            return c16;
        }
        ListAdapter adapter = getAdapter();
        int itemViewType = adapter.getItemViewType(i3);
        int viewTypeCount = adapter.getViewTypeCount();
        if (viewTypeCount != this.mSampleViewTypes.length) {
            this.mSampleViewTypes = new View[viewTypeCount];
        }
        if (itemViewType >= 0) {
            View view2 = this.mSampleViewTypes[itemViewType];
            if (view2 == null) {
                view = adapter.getView(i3, null, this);
                this.mSampleViewTypes[itemViewType] = view;
            } else {
                view = adapter.getView(i3, view2, this);
            }
        } else {
            view = adapter.getView(i3, null, this);
        }
        int childHeight = getChildHeight(i3, view, true);
        this.mChildHeightCache.a(i3, childHeight);
        return childHeight;
    }

    public ShaderAnimLayout getDelButton(int i3) {
        View childAt;
        int firstVisiblePosition = i3 - super.getFirstVisiblePosition();
        if (firstVisiblePosition >= 0 && firstVisiblePosition <= super.getChildCount() && (childAt = super.getChildAt(firstVisiblePosition)) != null) {
            return (ShaderAnimLayout) childAt.findViewById(R.id.iqk);
        }
        return null;
    }

    public float getFloatAlpha() {
        return this.mCurrFloatAlpha;
    }

    public ListAdapter getInputAdapter() {
        c cVar = this.mAdapterWrapper;
        if (cVar == null) {
            return null;
        }
        return cVar.a();
    }

    public View getItemChild(int i3, int i16) {
        View childAt;
        int firstVisiblePosition = i3 - super.getFirstVisiblePosition();
        if (firstVisiblePosition >= 0 && firstVisiblePosition <= getChildCount() && (childAt = super.getChildAt(firstVisiblePosition)) != null) {
            return childAt.findViewById(i16);
        }
        return null;
    }

    int getItemHeight(int i3) {
        View childAt = super.getChildAt(i3 - getFirstVisiblePosition());
        if (childAt != null) {
            return childAt.getHeight();
        }
        return calcItemHeight(i3, getChildHeight(i3));
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        if (r8 <= r5) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    int getShuffleEdge(int i3, int i16) {
        int headerViewsCount = super.getHeaderViewsCount();
        int footerViewsCount = super.getFooterViewsCount();
        if (i3 > headerViewsCount && i3 < getCount() - footerViewsCount) {
            int dividerHeight = super.getDividerHeight();
            int i17 = this.mFloatViewHeight - this.mItemHeightCollapsed;
            int childHeight = getChildHeight(i3);
            int itemHeight = getItemHeight(i3);
            int i18 = this.mSecondExpPos;
            int i19 = this.mSrcPos;
            if (i18 <= i19) {
                if (i3 == i18 && this.mFirstExpPos != i18) {
                    if (i3 == i19) {
                        i16 += itemHeight;
                        i17 = this.mFloatViewHeight;
                    } else {
                        i16 += itemHeight - childHeight;
                    }
                } else if (i3 > i18) {
                }
                i16 -= i17;
            } else if (i3 > i19 && i3 <= this.mFirstExpPos) {
                i16 += i17;
            } else if (i3 == i18 && this.mFirstExpPos != i18) {
                i16 += itemHeight - childHeight;
            }
            if (i3 <= i19) {
                return i16 + (((this.mFloatViewHeight - dividerHeight) - getChildHeight(i3 - 1)) / 2);
            }
            return i16 + (((childHeight - dividerHeight) - this.mFloatViewHeight) / 2);
        }
        return i16;
    }

    public void hideDelButton() {
        RelativeLayout relativeLayout;
        ShaderAnimLayout delButton = getDelButton(this.mSrcPos);
        if (delButton != null) {
            delButton.a();
            this.mIsDelShow = false;
            int i3 = this.mProgressPos;
            if (i3 >= 0 && (relativeLayout = (RelativeLayout) getItemChild(i3, R.id.kiv)) != null && ((ProgressCircle) relativeLayout.findViewById(R.id.kiw)).getVisibility() == 0) {
                relativeLayout.setVisibility(0);
            }
        }
    }

    public void hideDelButtonWithoutAnimation() {
        RelativeLayout relativeLayout;
        ShaderAnimLayout delButton = getDelButton(this.mSrcPos);
        if (delButton != null) {
            delButton.d();
            this.mIsDelShow = false;
            int i3 = this.mProgressPos;
            if (i3 >= 0 && (relativeLayout = (RelativeLayout) getItemChild(i3, R.id.kiv)) != null && ((ProgressCircle) relativeLayout.findViewById(R.id.kiw)).getVisibility() == 0) {
                relativeLayout.setVisibility(0);
            }
        }
    }

    public boolean isDragEnabled() {
        return this.mDragEnabled;
    }

    public boolean isScrolling() {
        return this.mDragScroller.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView
    public void layoutChildren() {
        super.layoutChildren();
        View view = this.mFloatView;
        if (view != null) {
            if (view.isLayoutRequested() && !this.mFloatViewOnMeasured) {
                measureFloatView();
            }
            View view2 = this.mFloatView;
            view2.layout(0, 0, view2.getMeasuredWidth(), this.mFloatView.getMeasuredHeight());
            this.mFloatViewOnMeasured = false;
        }
    }

    public boolean listViewIntercepted() {
        return this.mListViewIntercepted;
    }

    public void moveCheckState(int i3, int i16) {
        int i17;
        int i18;
        SparseBooleanArray checkedItemPositions = getCheckedItemPositions();
        if (checkedItemPositions == null) {
            return;
        }
        if (i16 < i3) {
            i18 = i3;
            i17 = i16;
        } else {
            i17 = i3;
            i18 = i16;
        }
        int i19 = i18 + 1;
        int[] iArr = new int[checkedItemPositions.size()];
        int[] iArr2 = new int[checkedItemPositions.size()];
        int buildRunList = buildRunList(checkedItemPositions, i17, i19, iArr, iArr2);
        if (buildRunList == 1 && iArr[0] == iArr2[0]) {
            return;
        }
        if (i3 < i16) {
            for (int i26 = 0; i26 != buildRunList; i26++) {
                setItemChecked(rotate(iArr[i26], -1, i17, i19), true);
                setItemChecked(rotate(iArr2[i26], -1, i17, i19), false);
            }
            return;
        }
        for (int i27 = 0; i27 != buildRunList; i27++) {
            setItemChecked(iArr[i27], false);
            setItemChecked(iArr2[i27], true);
        }
    }

    public void moveItem(int i3, int i16) {
        ListAdapter inputAdapter;
        if (this.mDropListener == null || (inputAdapter = getInputAdapter()) == null) {
            return;
        }
        int count = inputAdapter.getCount();
        if (i3 >= 0 && i3 < count && i16 >= 0 && i16 < count) {
            this.mDropListener.drop(i3, i16);
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        motionEvent.getAction();
        int action = motionEvent.getAction() & 255;
        if (action != 1) {
            if (action != 2) {
                if (action == 3) {
                    if (this.mDragState == 4) {
                        cancelDrag();
                    }
                    doActionUpOrCancel();
                }
            } else {
                continueDrag((int) motionEvent.getX(), (int) motionEvent.getY());
            }
        } else {
            if (this.mDragState == 4) {
                stopDrag(false);
            }
            doActionUpOrCancel();
        }
        return true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mTrackDragSort) {
            this.mDragSortTracker.a();
        }
    }

    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        if (!this.mDragEnabled) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            if (this.mIsDelShow) {
                ShaderAnimLayout delButton = getDelButton(this.mSrcPos);
                if (delButton == null) {
                    return false;
                }
                if (isEventInView(delButton, rawX, rawY)) {
                    this.mIsDelEvent = true;
                } else {
                    hideDelButton();
                    this.mIsItemEvent = false;
                }
            } else {
                Button button = (Button) getItemChild(this.mTapPos, R.id.kiu);
                if (button == null) {
                    return false;
                }
                if (isEventInView(button, rawX, rawY)) {
                    this.mIsUpdateEvent = true;
                    return false;
                }
            }
            return true;
        }
        int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        ImageView leftIndicator = getLeftIndicator(pointToPosition);
        if (leftIndicator != null && isEventInView(leftIndicator, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            if (this.mIsDelShow && this.mSrcPos != pointToPosition) {
                this.mIsLeftEvent = false;
                return true;
            }
            this.mSrcPos = pointToPosition;
            this.mIsLeftEvent = true;
            return true;
        }
        if (this.mIsDelShow) {
            int rawX2 = (int) motionEvent.getRawX();
            int rawY2 = (int) motionEvent.getRawY();
            ShaderAnimLayout delButton2 = getDelButton(this.mSrcPos);
            if (delButton2 == null) {
                return false;
            }
            if (isEventInView(delButton2, rawX2, rawY2)) {
                this.mIsDelEvent = true;
            }
            return true;
        }
        saveTouchCoords(motionEvent);
        this.mLastCallWasIntercept = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.mIgnoreTouchEvent = true;
                return true;
            }
            this.mInTouchEvent = true;
        }
        if (this.mFloatView != null) {
            z16 = true;
        } else {
            if (super.onInterceptTouchEvent(motionEvent)) {
                this.mListViewIntercepted = true;
                z16 = true;
            } else {
                z16 = false;
            }
            if (action != 1 && action != 3) {
                if (z16) {
                    this.mCancelMethod = 1;
                } else {
                    this.mCancelMethod = 2;
                }
            } else {
                doActionUpOrCancel();
            }
        }
        if (action == 1 || action == 3) {
            this.mInTouchEvent = false;
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.XListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        View view = this.mFloatView;
        if (view != null) {
            if (view.isLayoutRequested()) {
                measureFloatView();
            }
            this.mFloatViewOnMeasured = true;
        }
        this.mWidthMeasureSpec = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.XListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        updateScrollStarts();
    }

    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ShaderAnimLayout delButton;
        if (this.mIgnoreTouchEvent) {
            this.mIgnoreTouchEvent = false;
            return false;
        }
        if (!this.mDragEnabled) {
            return onDragDisableTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0) {
            if (this.mIsLeftEvent) {
                boolean z16 = true;
                if (this.mIsDelShow) {
                    k kVar = this.mLeftEventListener;
                    if (kVar != null) {
                        kVar.a(this.mSrcPos);
                    }
                    if (QQUIAppSetting.enableTalkBack() && System.currentTimeMillis() - this.mLastShowTime < 300) {
                        z16 = false;
                    }
                    if (z16 && (delButton = getDelButton(this.mSrcPos)) != null) {
                        this.mIsDelShow = false;
                        delButton.a();
                    }
                } else {
                    k kVar2 = this.mLeftEventListener;
                    if (kVar2 != null) {
                        kVar2.b(this.mSrcPos);
                    }
                    ShaderAnimLayout delButton2 = getDelButton(this.mSrcPos);
                    if (delButton2 != null) {
                        this.mIsDelShow = true;
                        delButton2.f();
                        this.mLastShowTime = System.currentTimeMillis();
                    }
                }
                this.mIsLeftEvent = false;
                return false;
            }
            if (this.mIsDelShow) {
                if (this.mIsDelEvent) {
                    if (!this.ignoreDeleteEnabled) {
                        hideDelButtonWithoutAnimation();
                        removeItem(this.mSrcPos);
                        this.mIsDelEvent = false;
                    } else {
                        l lVar = this.mRemoveListener;
                        if (lVar != null) {
                            lVar.remove(this.mSrcPos);
                        }
                        this.mIsDelEvent = false;
                        return false;
                    }
                } else {
                    hideDelButton();
                }
                this.mIsDelShow = false;
                return false;
            }
        }
        return handleOnTouchEvent(motionEvent);
    }

    public void removeCheckState(int i3) {
        int i16;
        SparseBooleanArray checkedItemPositions = getCheckedItemPositions();
        if (checkedItemPositions == null || checkedItemPositions.size() == 0) {
            return;
        }
        int[] iArr = new int[checkedItemPositions.size()];
        int[] iArr2 = new int[checkedItemPositions.size()];
        int keyAt = checkedItemPositions.keyAt(checkedItemPositions.size() - 1) + 1;
        int buildRunList = buildRunList(checkedItemPositions, i3, keyAt, iArr, iArr2);
        for (int i17 = 0; i17 != buildRunList; i17++) {
            int i18 = iArr[i17];
            if (i18 != i3 && ((i16 = iArr2[i17]) >= i18 || i16 <= i3)) {
                setItemChecked(rotate(i18, -1, i3, keyAt), true);
            }
            setItemChecked(rotate(iArr2[i17], -1, i3, keyAt), false);
        }
    }

    public void removeItem(int i3) {
        this.mUseRemoveVelocity = false;
        removeItem(i3, 0.0f);
    }

    @Override // com.tencent.widget.AbsListView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            super.requestLayout();
        }
    }

    public void setDelImmediately(boolean z16) {
        this.mDelImmediately = z16;
    }

    public void setDragEnabled(boolean z16) {
        this.mDragEnabled = z16;
        this.mIsDelShow = false;
        this.mIsDelEvent = false;
        this.mIsLeftEvent = false;
    }

    public void setDragListener(d dVar) {
        this.mDragListener = dVar;
    }

    public void setDragScrollProfile(e eVar) {
        if (eVar != null) {
            this.mScrollProfile = eVar;
        }
    }

    public void setDragScrollStart(float f16) {
        setDragScrollStarts(f16, f16);
    }

    public void setDragScrollStarts(float f16, float f17) {
        if (f17 > 0.5f) {
            this.mDragDownScrollStartFrac = 0.5f;
        } else {
            this.mDragDownScrollStartFrac = f17;
        }
        if (f16 > 0.5f) {
            this.mDragUpScrollStartFrac = 0.5f;
        } else {
            this.mDragUpScrollStartFrac = f16;
        }
        if (getHeight() != 0) {
            updateScrollStarts();
        }
    }

    public void setDragSortListener(f fVar) {
        setDropListener(fVar);
        setDragListener(fVar);
        setRemoveListener(fVar);
    }

    public void setDropListener(h hVar) {
        this.mDropListener = hVar;
    }

    public void setFloatAlpha(float f16) {
        this.mCurrFloatAlpha = f16;
    }

    public void setFloatViewManager(i iVar) {
        this.mFloatViewManager = iVar;
    }

    public void setLeftEventListener(k kVar) {
        this.mLeftEventListener = kVar;
    }

    public void setMaxScrollSpeed(float f16) {
        this.mMaxScrollSpeed = f16;
    }

    public void setRemoveListener(l lVar) {
        this.mRemoveListener = lVar;
    }

    public void setSrcPos(int i3) {
        this.mSrcPos = i3;
    }

    public void setTapPos(int i3) {
        this.mTapPos = i3;
    }

    public void showDelButton() {
        ShaderAnimLayout delButton;
        if (!this.mIsDelShow && (delButton = getDelButton(this.mSrcPos)) != null) {
            delButton.f();
            this.mIsDelShow = true;
            RelativeLayout relativeLayout = (RelativeLayout) getItemChild(this.mSrcPos, R.id.kiv);
            if (relativeLayout == null) {
                return;
            }
            ProgressCircle progressCircle = (ProgressCircle) relativeLayout.findViewById(R.id.kiw);
            if (relativeLayout.getVisibility() == 0 && progressCircle.getVisibility() == 0) {
                relativeLayout.setVisibility(8);
                this.mProgressPos = this.mSrcPos;
            }
        }
    }

    public boolean startDrag(int i3, int i16, int i17, int i18) {
        i iVar;
        View onCreateFloatView;
        if (!this.mInTouchEvent || (iVar = this.mFloatViewManager) == null || (onCreateFloatView = iVar.onCreateFloatView(i3)) == null) {
            return false;
        }
        return startDrag(i3, onCreateFloatView, i16, i17, i18);
    }

    public boolean stopDrag(boolean z16) {
        this.mUseRemoveVelocity = false;
        return stopDrag(z16, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z16, float f16) {
        this.mUseRemoveVelocity = true;
        return stopDrag(z16, f16);
    }

    private int calcItemHeight(int i3, int i16) {
        getDividerHeight();
        boolean z16 = this.mAnimate && this.mFirstExpPos != this.mSecondExpPos;
        int i17 = this.mFloatViewHeight;
        int i18 = this.mItemHeightCollapsed;
        int i19 = i17 - i18;
        int i26 = (int) (this.mSlideFrac * i19);
        int i27 = this.mSrcPos;
        return i3 == i27 ? i27 == this.mFirstExpPos ? z16 ? i26 + i18 : i17 : i27 == this.mSecondExpPos ? i17 - i26 : this.mDragState == 0 ? i16 : i18 : i3 == this.mFirstExpPos ? z16 ? i16 + i26 : i16 + i19 : i3 == this.mSecondExpPos ? (i16 + i19) - i26 : i16;
    }

    private void doRemoveItem(int i3) {
        this.mDragState = 1;
        l lVar = this.mRemoveListener;
        if (lVar != null) {
            lVar.remove(i3);
        }
        destroyFloatView();
        adjustOnReorder();
        clearPositions();
        if (this.mInTouchEvent) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, com.tencent.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.mAdapterWrapper = new c(listAdapter);
            listAdapter.registerDataSetObserver(this.mObserver);
            if (listAdapter instanceof h) {
                setDropListener((h) listAdapter);
            }
            if (listAdapter instanceof d) {
                setDragListener((d) listAdapter);
            }
            if (listAdapter instanceof l) {
                setRemoveListener((l) listAdapter);
            }
        } else {
            this.mAdapterWrapper = null;
        }
        super.setAdapter((ListAdapter) this.mAdapterWrapper);
    }

    public void removeItem(int i3, float f16) {
        int i16 = this.mDragState;
        if (i16 == 0 || i16 == 4) {
            if (i16 == 0) {
                int headerViewsCount = getHeaderViewsCount() + i3;
                this.mSrcPos = headerViewsCount;
                this.mFirstExpPos = headerViewsCount;
                this.mSecondExpPos = headerViewsCount;
                this.mFloatPos = headerViewsCount;
                View childAt = super.getChildAt(headerViewsCount - getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.mRemoveVelocityX = f16;
            if (this.mInTouchEvent) {
                int i17 = this.mCancelMethod;
                if (i17 == 1) {
                    super.onTouchEvent(this.mCancelEvent);
                } else if (i17 == 2) {
                    super.onInterceptTouchEvent(this.mCancelEvent);
                }
            }
            RemoveAnimator removeAnimator = this.mRemoveAnimator;
            if (removeAnimator != null) {
                removeAnimator.h();
            } else {
                doRemoveItem(i3);
            }
        }
    }

    public boolean stopDrag(boolean z16, float f16) {
        if (this.mFloatView == null) {
            return false;
        }
        this.mDragScroller.h(true);
        if (z16) {
            removeItem(this.mSrcPos - getHeaderViewsCount(), f16);
        } else {
            DropAnimator dropAnimator = this.mDropAnimator;
            if (dropAnimator != null) {
                dropAnimator.h();
            } else {
                dropFloatView();
            }
        }
        if (this.mTrackDragSort) {
            this.mDragSortTracker.d();
        }
        return true;
    }

    void doDragFloatView(int i3, View view, boolean z16) {
        this.mBlockLayoutRequests = true;
        updateFloatView();
        int i16 = this.mFirstExpPos;
        int i17 = this.mSecondExpPos;
        boolean updatePositions = updatePositions();
        if (updatePositions) {
            adjustAllItems();
            setSelectionFromTop(i3, (view.getTop() + adjustScroll(i3, view, i16, i17)) - getPaddingTop());
            layoutChildren();
        }
        if (updatePositions || z16) {
            invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    public boolean startDrag(int i3, View view, int i16, int i17, int i18) {
        if (this.mDragState != 0 || !this.mInTouchEvent || this.mFloatView != null || view == null || !this.mDragEnabled) {
            return false;
        }
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        int headerViewsCount = i3 + getHeaderViewsCount();
        this.mFirstExpPos = headerViewsCount;
        this.mSecondExpPos = headerViewsCount;
        this.mSrcPos = headerViewsCount;
        this.mFloatPos = headerViewsCount;
        this.mDragState = 4;
        this.mDragFlags = i16 | 0;
        this.mFloatView = view;
        measureFloatView();
        this.mDragDeltaX = i17;
        this.mDragDeltaY = i18;
        int i19 = this.mY;
        this.mDragStartY = i19;
        Point point = this.mFloatLoc;
        point.x = this.mX - i17;
        point.y = i19 - i18;
        View childAt = getChildAt(this.mSrcPos - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setVisibility(4);
        }
        if (this.mTrackDragSort) {
            this.mDragSortTracker.c();
        }
        int i26 = this.mCancelMethod;
        if (i26 == 1) {
            super.onTouchEvent(this.mCancelEvent);
        } else if (i26 == 2) {
            super.onInterceptTouchEvent(this.mCancelEvent);
        }
        requestLayout();
        LiftAnimator liftAnimator = this.mLiftAnimator;
        if (liftAnimator != null) {
            liftAnimator.h();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getChildHeight(int i3, View view, boolean z16) {
        int i16;
        if (i3 == this.mSrcPos) {
            return 0;
        }
        if (i3 >= getHeaderViewsCount() && i3 < getCount() - getFooterViewsCount()) {
            view = ((ViewGroup) view).getChildAt(0);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null && (i16 = layoutParams.height) > 0) {
            return i16;
        }
        int height = view.getHeight();
        if (height != 0 && !z16) {
            return height;
        }
        measureItem(view);
        return view.getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class SmoothAnimator implements Runnable {
        private float C;
        private boolean D;

        /* renamed from: d, reason: collision with root package name */
        protected long f204421d;

        /* renamed from: e, reason: collision with root package name */
        private float f204422e;

        /* renamed from: f, reason: collision with root package name */
        private float f204423f;

        /* renamed from: h, reason: collision with root package name */
        private float f204424h;

        /* renamed from: i, reason: collision with root package name */
        private float f204425i;

        /* renamed from: m, reason: collision with root package name */
        private float f204426m;

        public SmoothAnimator(float f16, int i3) {
            this.f204423f = f16;
            this.f204422e = i3;
            float f17 = 1.0f / ((f16 * 2.0f) * (1.0f - f16));
            this.C = f17;
            this.f204424h = f17;
            this.f204425i = f16 / ((f16 - 1.0f) * 2.0f);
            this.f204426m = 1.0f / (1.0f - f16);
        }

        public void cancel() {
            this.D = true;
        }

        public void h() {
            this.f204421d = SystemClock.uptimeMillis();
            this.D = false;
            e();
            DragSortListView.this.post(this);
        }

        public float i(float f16) {
            float f17 = this.f204423f;
            if (f16 < f17) {
                return this.f204424h * f16 * f16;
            }
            if (f16 < 1.0f - f17) {
                return this.f204425i + (this.f204426m * f16);
            }
            float f18 = f16 - 1.0f;
            return 1.0f - ((this.C * f18) * f18);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.D) {
                return;
            }
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f204421d)) / this.f204422e;
            if (uptimeMillis >= 1.0f) {
                g(1.0f, 1.0f);
                f();
            } else {
                g(uptimeMillis, i(uptimeMillis));
                DragSortListView.this.post(this);
            }
        }

        public void e() {
        }

        public void f() {
        }

        public void g(float f16, float f17) {
        }
    }
}
