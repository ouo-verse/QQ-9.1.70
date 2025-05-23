package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public class ItemTouchHelper extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
    float C;
    float D;
    float E;
    float F;
    float G;
    c I;
    int K;
    private int M;
    RecyclerView N;
    VelocityTracker Q;
    private List<RecyclerView.ViewHolder> R;
    private List<Integer> S;
    com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.d W;
    private Rect Y;
    private long Z;

    /* renamed from: h, reason: collision with root package name */
    float f319276h;

    /* renamed from: i, reason: collision with root package name */
    float f319277i;

    /* renamed from: m, reason: collision with root package name */
    float f319278m;

    /* renamed from: d, reason: collision with root package name */
    final List<View> f319273d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private final float[] f319274e = new float[2];

    /* renamed from: f, reason: collision with root package name */
    RecyclerView.ViewHolder f319275f = null;
    int H = -1;
    int J = 0;
    List<e> L = new ArrayList();
    final Runnable P = new Runnable() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ItemTouchHelper.1
        @Override // java.lang.Runnable
        public void run() {
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            if (itemTouchHelper.f319275f != null && itemTouchHelper.scrollIfNecessary()) {
                ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                RecyclerView.ViewHolder viewHolder = itemTouchHelper2.f319275f;
                if (viewHolder != null) {
                    itemTouchHelper2.moveIfNecessary(viewHolder);
                }
                ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                itemTouchHelper3.N.removeCallbacks(itemTouchHelper3.P);
                ViewCompat.postOnAnimation(ItemTouchHelper.this.N, this);
            }
        }
    };
    private RecyclerView.ChildDrawingOrderCallback T = null;
    View U = null;
    int V = -1;
    private final RecyclerView.OnItemTouchListener X = new a();

    /* renamed from: a0, reason: collision with root package name */
    private final int f319272a0 = com.tencent.videocut.utils.e.f384236a.a(30.0f);

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a implements RecyclerView.OnItemTouchListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            int findPointerIndex;
            e c16;
            ItemTouchHelper.this.W.a(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                ItemTouchHelper.this.H = motionEvent.getPointerId(0);
                ItemTouchHelper.this.f319276h = motionEvent.getX();
                ItemTouchHelper.this.f319277i = motionEvent.getY();
                ItemTouchHelper.this.obtainVelocityTracker();
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                if (itemTouchHelper.f319275f == null && (c16 = itemTouchHelper.c(motionEvent)) != null) {
                    ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                    itemTouchHelper2.f319276h -= c16.F;
                    itemTouchHelper2.f319277i -= c16.G;
                    itemTouchHelper2.b(c16.f319291i, true);
                    if (ItemTouchHelper.this.f319273d.remove(c16.f319291i.itemView)) {
                        ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                        itemTouchHelper3.I.c(itemTouchHelper3.N, c16.f319291i);
                    }
                    ItemTouchHelper.this.select(c16.f319291i, c16.f319292m);
                    ItemTouchHelper itemTouchHelper4 = ItemTouchHelper.this;
                    itemTouchHelper4.updateDxDy(motionEvent, itemTouchHelper4.K, 0);
                }
            } else if (actionMasked != 3 && actionMasked != 1) {
                int i3 = ItemTouchHelper.this.H;
                if (i3 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i3)) >= 0) {
                    ItemTouchHelper.this.a(actionMasked, motionEvent, findPointerIndex);
                }
            } else {
                ItemTouchHelper itemTouchHelper5 = ItemTouchHelper.this;
                itemTouchHelper5.H = -1;
                itemTouchHelper5.select(null, 0);
            }
            VelocityTracker velocityTracker = ItemTouchHelper.this.Q;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.f319275f != null) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z16) {
            if (!z16) {
                return;
            }
            ItemTouchHelper.this.select(null, 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            ItemTouchHelper.this.W.a(motionEvent);
            VelocityTracker velocityTracker = ItemTouchHelper.this.Q;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.H == -1) {
                return;
            }
            int actionMasked = motionEvent.getActionMasked();
            int findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.H);
            if (findPointerIndex >= 0) {
                ItemTouchHelper.this.a(actionMasked, motionEvent, findPointerIndex);
            }
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            RecyclerView.ViewHolder viewHolder = itemTouchHelper.f319275f;
            if (viewHolder == null) {
                return;
            }
            int i3 = 0;
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 6) {
                            int actionIndex = motionEvent.getActionIndex();
                            int pointerId = motionEvent.getPointerId(actionIndex);
                            ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                            if (pointerId == itemTouchHelper2.H) {
                                if (actionIndex == 0) {
                                    i3 = 1;
                                }
                                itemTouchHelper2.H = motionEvent.getPointerId(i3);
                                ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                                itemTouchHelper3.updateDxDy(motionEvent, itemTouchHelper3.K, actionIndex);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    VelocityTracker velocityTracker2 = itemTouchHelper.Q;
                    if (velocityTracker2 != null) {
                        velocityTracker2.clear();
                    }
                } else {
                    if (findPointerIndex >= 0) {
                        itemTouchHelper.updateDxDy(motionEvent, itemTouchHelper.K, findPointerIndex);
                        ItemTouchHelper.this.moveIfNecessary(viewHolder);
                        ItemTouchHelper itemTouchHelper4 = ItemTouchHelper.this;
                        itemTouchHelper4.N.removeCallbacks(itemTouchHelper4.P);
                        ItemTouchHelper.this.P.run();
                        ItemTouchHelper.this.N.invalidate();
                        return;
                    }
                    return;
                }
            }
            ItemTouchHelper.this.select(null, 0);
            ItemTouchHelper.this.H = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class b extends e {
        final /* synthetic */ int L;
        final /* synthetic */ RecyclerView.ViewHolder M;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(RecyclerView.ViewHolder viewHolder, int i3, int i16, float f16, float f17, float f18, float f19, int i17, RecyclerView.ViewHolder viewHolder2) {
            super(viewHolder, i3, i16, f16, f17, f18, f19);
            this.L = i17;
            this.M = viewHolder2;
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ItemTouchHelper.e, com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.b, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (this.H) {
                return;
            }
            if (this.L <= 0) {
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                itemTouchHelper.I.c(itemTouchHelper.N, this.M);
            } else {
                ItemTouchHelper.this.f319273d.add(this.M.itemView);
                this.E = true;
                int i3 = this.L;
                if (i3 > 0) {
                    ItemTouchHelper.this.e(this, i3);
                }
            }
            ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
            View view = itemTouchHelper2.U;
            View view2 = this.M.itemView;
            if (view == view2) {
                itemTouchHelper2.removeChildDrawingOrderCallbackIfNecessary(view2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class d extends GestureDetector.SimpleOnGestureListener {
        d() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            RecyclerView.ViewHolder childViewHolder;
            View findChildView = ItemTouchHelper.this.findChildView(motionEvent);
            if (findChildView != null && (childViewHolder = ItemTouchHelper.this.N.getChildViewHolder(findChildView)) != null) {
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                if (!itemTouchHelper.I.o(itemTouchHelper.N, childViewHolder)) {
                    return;
                }
                int pointerId = motionEvent.getPointerId(0);
                int i3 = ItemTouchHelper.this.H;
                if (pointerId == i3) {
                    int findPointerIndex = motionEvent.findPointerIndex(i3);
                    float x16 = motionEvent.getX(findPointerIndex);
                    float y16 = motionEvent.getY(findPointerIndex);
                    ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                    itemTouchHelper2.f319276h = x16;
                    itemTouchHelper2.f319277i = y16;
                    itemTouchHelper2.E = 0.0f;
                    itemTouchHelper2.D = 0.0f;
                    if (itemTouchHelper2.I.r()) {
                        ItemTouchHelper.this.select(childViewHolder, 2);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static abstract class f extends c {

        /* renamed from: e, reason: collision with root package name */
        private int f319295e;

        /* renamed from: f, reason: collision with root package name */
        private int f319296f;

        public f(int i3, int i16) {
            this.f319295e = i16;
            this.f319296f = i3;
        }

        public int C(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return this.f319296f;
        }

        public int D(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return this.f319295e;
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ItemTouchHelper.c
        public int k(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return c.t(C(recyclerView, viewHolder), D(recyclerView, viewHolder));
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface g {
        void prepareForDrop(View view, View view2, int i3, int i16);
    }

    public ItemTouchHelper(c cVar) {
        this.I = cVar;
    }

    private int checkHorizontalSwipe(RecyclerView.ViewHolder viewHolder, int i3) {
        int i16;
        if ((i3 & 12) != 0) {
            int i17 = 8;
            if (this.D > 0.0f) {
                i16 = 8;
            } else {
                i16 = 4;
            }
            VelocityTracker velocityTracker = this.Q;
            if (velocityTracker != null && this.H > -1) {
                velocityTracker.computeCurrentVelocity(1000, this.I.n(this.C));
                float xVelocity = this.Q.getXVelocity(this.H);
                float yVelocity = this.Q.getYVelocity(this.H);
                if (xVelocity <= 0.0f) {
                    i17 = 4;
                }
                float abs = Math.abs(xVelocity);
                if ((i17 & i3) != 0 && i16 == i17 && abs >= this.I.l(this.f319278m) && abs > Math.abs(yVelocity)) {
                    return i17;
                }
            }
            float width = this.N.getWidth() * this.I.m(viewHolder);
            if ((i3 & i16) != 0 && Math.abs(this.D) > width) {
                return i16;
            }
            return 0;
        }
        return 0;
    }

    private int checkVerticalSwipe(RecyclerView.ViewHolder viewHolder, int i3) {
        int i16;
        if ((i3 & 3) != 0) {
            int i17 = 2;
            if (this.E > 0.0f) {
                i16 = 2;
            } else {
                i16 = 1;
            }
            VelocityTracker velocityTracker = this.Q;
            if (velocityTracker != null && this.H > -1) {
                velocityTracker.computeCurrentVelocity(1000, this.I.n(this.C));
                float xVelocity = this.Q.getXVelocity(this.H);
                float yVelocity = this.Q.getYVelocity(this.H);
                if (yVelocity <= 0.0f) {
                    i17 = 1;
                }
                float abs = Math.abs(yVelocity);
                if ((i17 & i3) != 0 && i17 == i16 && abs >= this.I.l(this.f319278m) && abs > Math.abs(xVelocity)) {
                    return i17;
                }
            }
            float height = this.N.getHeight() * this.I.m(viewHolder);
            if ((i3 & i16) != 0 && Math.abs(this.E) > height) {
                return i16;
            }
            return 0;
        }
        return 0;
    }

    private void d() {
        if (this.W != null) {
            return;
        }
        this.W = new com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.d(this.N.getContext(), new d());
    }

    private void destroyCallbacks() {
        this.N.removeItemDecoration(this);
        this.N.removeOnItemTouchListener(this.X);
        this.N.removeOnChildAttachStateChangeListener(this);
        for (int size = this.L.size() - 1; size >= 0; size--) {
            this.I.c(this.N, this.L.get(0).f319291i);
        }
        this.L.clear();
        this.U = null;
        this.V = -1;
        releaseVelocityTracker();
    }

    private List<RecyclerView.ViewHolder> findSwapTargets(RecyclerView.ViewHolder viewHolder) {
        RecyclerView.ViewHolder viewHolder2 = viewHolder;
        List<RecyclerView.ViewHolder> list = this.R;
        if (list == null) {
            this.R = new ArrayList();
            this.S = new ArrayList();
        } else {
            list.clear();
            this.S.clear();
        }
        int h16 = this.I.h();
        int round = Math.round(this.F + this.D) - h16;
        int round2 = Math.round(this.G + this.E) - h16;
        int i3 = h16 * 2;
        int width = viewHolder2.itemView.getWidth() + round + i3;
        int height = viewHolder2.itemView.getHeight() + round2 + i3;
        int i16 = (round + width) / 2;
        int i17 = (round2 + height) / 2;
        RecyclerView.LayoutManager layoutManager = this.N.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        int i18 = 0;
        while (i18 < childCount) {
            View childAt = layoutManager.getChildAt(i18);
            if (childAt != viewHolder2.itemView && childAt.getBottom() >= round2 && childAt.getTop() <= height && childAt.getRight() >= round && childAt.getLeft() <= width) {
                RecyclerView.ViewHolder childViewHolder = this.N.getChildViewHolder(childAt);
                if (this.I.a(this.N, this.f319275f, childViewHolder)) {
                    int abs = Math.abs(i16 - ((childAt.getLeft() + childAt.getRight()) / 2));
                    int abs2 = Math.abs(i17 - ((childAt.getTop() + childAt.getBottom()) / 2));
                    int i19 = (abs * abs) + (abs2 * abs2);
                    int size = this.R.size();
                    int i26 = 0;
                    for (int i27 = 0; i27 < size && i19 > this.S.get(i27).intValue(); i27++) {
                        i26++;
                    }
                    this.R.add(i26, childViewHolder);
                    this.S.add(i26, Integer.valueOf(i19));
                }
            }
            i18++;
            viewHolder2 = viewHolder;
        }
        return this.R;
    }

    private RecyclerView.ViewHolder findSwipedView(MotionEvent motionEvent) {
        View findChildView;
        RecyclerView.LayoutManager layoutManager = this.N.getLayoutManager();
        int i3 = this.H;
        if (i3 == -1) {
            return null;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i3);
        float x16 = motionEvent.getX(findPointerIndex) - this.f319276h;
        float y16 = motionEvent.getY(findPointerIndex) - this.f319277i;
        float abs = Math.abs(x16);
        float abs2 = Math.abs(y16);
        int i16 = this.M;
        if (abs < i16 && abs2 < i16) {
            return null;
        }
        if (abs > abs2 && layoutManager.canScrollHorizontally()) {
            return null;
        }
        if ((abs2 > abs && layoutManager.canScrollVertically()) || (findChildView = findChildView(motionEvent)) == null) {
            return null;
        }
        return this.N.getChildViewHolder(findChildView);
    }

    private void getSelectedDxDy(float[] fArr) {
        if ((this.K & 12) != 0) {
            fArr[0] = (this.F + this.D) - this.f319275f.itemView.getLeft();
        } else {
            fArr[0] = this.f319275f.itemView.getTranslationX();
        }
        if ((this.K & 3) != 0) {
            fArr[1] = (this.G + this.E) - this.f319275f.itemView.getTop();
        } else {
            fArr[1] = this.f319275f.itemView.getTranslationY();
        }
    }

    private static boolean hitTest(View view, float f16, float f17, float f18, float f19) {
        if (f16 >= f18 && f16 <= f18 + view.getWidth() && f17 >= f19 && f17 <= f19 + view.getHeight()) {
            return true;
        }
        return false;
    }

    private void releaseVelocityTracker() {
        VelocityTracker velocityTracker = this.Q;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.Q = null;
        }
    }

    private void setupCallbacks() {
        this.M = ViewConfiguration.get(this.N.getContext()).getScaledTouchSlop();
        this.N.addItemDecoration(this);
        this.N.addOnItemTouchListener(this.X);
        this.N.addOnChildAttachStateChangeListener(this);
        d();
    }

    private int swipeIfNecessary(RecyclerView.ViewHolder viewHolder) {
        if (this.J == 2) {
            return 0;
        }
        int k3 = this.I.k(this.N, viewHolder);
        int d16 = (this.I.d(k3, ViewCompat.getLayoutDirection(this.N)) & 65280) >> 8;
        if (d16 == 0) {
            return 0;
        }
        int i3 = (k3 & 65280) >> 8;
        if (Math.abs(this.D) > Math.abs(this.E)) {
            int checkHorizontalSwipe = checkHorizontalSwipe(viewHolder, d16);
            if (checkHorizontalSwipe > 0) {
                if ((i3 & checkHorizontalSwipe) == 0) {
                    return c.e(checkHorizontalSwipe, ViewCompat.getLayoutDirection(this.N));
                }
                return checkHorizontalSwipe;
            }
            int checkVerticalSwipe = checkVerticalSwipe(viewHolder, d16);
            if (checkVerticalSwipe > 0) {
                return checkVerticalSwipe;
            }
        } else {
            int checkVerticalSwipe2 = checkVerticalSwipe(viewHolder, d16);
            if (checkVerticalSwipe2 > 0) {
                return checkVerticalSwipe2;
            }
            int checkHorizontalSwipe2 = checkHorizontalSwipe(viewHolder, d16);
            if (checkHorizontalSwipe2 > 0) {
                if ((i3 & checkHorizontalSwipe2) == 0) {
                    return c.e(checkHorizontalSwipe2, ViewCompat.getLayoutDirection(this.N));
                }
                return checkHorizontalSwipe2;
            }
        }
        return 0;
    }

    boolean a(int i3, MotionEvent motionEvent, int i16) {
        RecyclerView.ViewHolder findSwipedView;
        int f16;
        if (this.f319275f != null || i3 != 2 || this.J == 2 || !this.I.q() || this.N.getScrollState() == 1 || (findSwipedView = findSwipedView(motionEvent)) == null || (f16 = (this.I.f(this.N, findSwipedView) & 65280) >> 8) == 0) {
            return false;
        }
        float x16 = motionEvent.getX(i16);
        float y16 = motionEvent.getY(i16);
        float f17 = x16 - this.f319276h;
        float f18 = y16 - this.f319277i;
        float abs = Math.abs(f17);
        float abs2 = Math.abs(f18);
        int i17 = this.M;
        if (abs < i17 && abs2 < i17) {
            return false;
        }
        if (abs > abs2) {
            if (f17 < 0.0f && (f16 & 4) == 0) {
                return false;
            }
            if (f17 > 0.0f && (f16 & 8) == 0) {
                return false;
            }
        } else {
            if (f18 < 0.0f && (f16 & 1) == 0) {
                return false;
            }
            if (f18 > 0.0f && (f16 & 2) == 0) {
                return false;
            }
        }
        this.E = 0.0f;
        this.D = 0.0f;
        this.H = motionEvent.getPointerId(0);
        select(findSwipedView, 1);
        return true;
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.N;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            destroyCallbacks();
        }
        this.N = recyclerView;
        if (recyclerView != null) {
            Resources resources = recyclerView.getResources();
            this.f319278m = resources.getDimension(R.dimen.f159068vg);
            this.C = resources.getDimension(R.dimen.f159067vf);
            setupCallbacks();
        }
    }

    int b(RecyclerView.ViewHolder viewHolder, boolean z16) {
        for (int size = this.L.size() - 1; size >= 0; size--) {
            e eVar = this.L.get(size);
            if (eVar.f319291i == viewHolder) {
                eVar.H |= z16;
                if (!eVar.I) {
                    eVar.a();
                }
                this.L.remove(size);
                return eVar.D;
            }
        }
        return 0;
    }

    e c(MotionEvent motionEvent) {
        if (this.L.isEmpty()) {
            return null;
        }
        View findChildView = findChildView(motionEvent);
        for (int size = this.L.size() - 1; size >= 0; size--) {
            e eVar = this.L.get(size);
            if (eVar.f319291i.itemView == findChildView) {
                return eVar;
            }
        }
        return null;
    }

    void e(final e eVar, final int i3) {
        this.N.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ItemTouchHelper.4
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView recyclerView = ItemTouchHelper.this.N;
                if (recyclerView != null && recyclerView.isAttachedToWindow()) {
                    e eVar2 = eVar;
                    if (!eVar2.H && eVar2.f319291i.getAdapterPosition() != -1) {
                        RecyclerView.ItemAnimator itemAnimator = ItemTouchHelper.this.N.getItemAnimator();
                        if ((itemAnimator == null || !itemAnimator.isRunning(null)) && !ItemTouchHelper.this.hasRunningRecoverAnim()) {
                            ItemTouchHelper.this.I.B(eVar.f319291i, i3);
                        } else {
                            ItemTouchHelper.this.N.post(this);
                        }
                    }
                }
            }
        });
    }

    View findChildView(MotionEvent motionEvent) {
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        RecyclerView.ViewHolder viewHolder = this.f319275f;
        if (viewHolder != null) {
            View view = viewHolder.itemView;
            if (hitTest(view, x16, y16, this.F + this.D, this.G + this.E)) {
                return view;
            }
        }
        for (int size = this.L.size() - 1; size >= 0; size--) {
            e eVar = this.L.get(size);
            View view2 = eVar.f319291i.itemView;
            if (hitTest(view2, x16, y16, eVar.F, eVar.G)) {
                return view2;
            }
        }
        return this.N.findChildViewUnder(x16, y16);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.setEmpty();
    }

    boolean hasRunningRecoverAnim() {
        int size = this.L.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!this.L.get(i3).I) {
                return true;
            }
        }
        return false;
    }

    void moveIfNecessary(RecyclerView.ViewHolder viewHolder) {
        if (this.N.isLayoutRequested() || this.J != 2) {
            return;
        }
        float j3 = this.I.j(viewHolder);
        int i3 = (int) (this.F + this.D);
        int i16 = (int) (this.G + this.E);
        if (Math.abs(i16 - viewHolder.itemView.getTop()) < viewHolder.itemView.getHeight() * j3 && Math.abs(i3 - viewHolder.itemView.getLeft()) < viewHolder.itemView.getWidth() * j3) {
            return;
        }
        List<RecyclerView.ViewHolder> findSwapTargets = findSwapTargets(viewHolder);
        if (findSwapTargets.size() == 0) {
            return;
        }
        RecyclerView.ViewHolder b16 = this.I.b(viewHolder, findSwapTargets, i3, i16);
        if (b16 == null) {
            this.R.clear();
            this.S.clear();
            return;
        }
        int adapterPosition = b16.getAdapterPosition();
        int adapterPosition2 = viewHolder.getAdapterPosition();
        if (this.I.y(this.N, viewHolder, b16)) {
            this.I.z(this.N, viewHolder, adapterPosition2, b16, adapterPosition, i3, i16);
        }
    }

    void obtainVelocityTracker() {
        VelocityTracker velocityTracker = this.Q;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.Q = VelocityTracker.obtain();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(View view) {
        removeChildDrawingOrderCallbackIfNecessary(view);
        RecyclerView.ViewHolder childViewHolder = this.N.getChildViewHolder(view);
        if (childViewHolder == null) {
            return;
        }
        RecyclerView.ViewHolder viewHolder = this.f319275f;
        if (viewHolder != null && childViewHolder == viewHolder) {
            select(null, 0);
            return;
        }
        b(childViewHolder, false);
        if (this.f319273d.remove(childViewHolder.itemView)) {
            this.I.c(this.N, childViewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f16;
        float f17;
        this.V = -1;
        if (this.f319275f != null) {
            getSelectedDxDy(this.f319274e);
            float[] fArr = this.f319274e;
            float f18 = fArr[0];
            f17 = fArr[1];
            f16 = f18;
        } else {
            f16 = 0.0f;
            f17 = 0.0f;
        }
        this.I.w(canvas, recyclerView, this.f319275f, this.L, this.J, f16, f17);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f16;
        float f17;
        if (this.f319275f != null) {
            getSelectedDxDy(this.f319274e);
            float[] fArr = this.f319274e;
            float f18 = fArr[0];
            f17 = fArr[1];
            f16 = f18;
        } else {
            f16 = 0.0f;
            f17 = 0.0f;
        }
        this.I.x(canvas, recyclerView, this.f319275f, this.L, this.J, f16, f17);
    }

    void removeChildDrawingOrderCallbackIfNecessary(View view) {
        if (view == this.U) {
            this.U = null;
            if (this.T != null) {
                this.N.setChildDrawingOrderCallback(null);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c7, code lost:
    
        if (r1 > 0) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0106 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean scrollIfNecessary() {
        long j3;
        int i3;
        int i16;
        int i17;
        int width;
        if (this.f319275f == null) {
            this.Z = Long.MIN_VALUE;
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j16 = this.Z;
        if (j16 == Long.MIN_VALUE) {
            j3 = 0;
        } else {
            j3 = currentTimeMillis - j16;
        }
        RecyclerView.LayoutManager layoutManager = this.N.getLayoutManager();
        if (this.Y == null) {
            this.Y = new Rect();
        }
        layoutManager.calculateItemDecorationsForChild(this.f319275f.itemView, this.Y);
        if (layoutManager.canScrollHorizontally()) {
            int i18 = (int) (this.F + this.D);
            int paddingLeft = ((i18 - this.Y.left) - this.N.getPaddingLeft()) - this.f319272a0;
            float f16 = this.D;
            if (f16 < 0.0f && paddingLeft < 0) {
                i3 = paddingLeft;
            } else if (f16 > 0.0f && (width = ((i18 + this.f319275f.itemView.getWidth()) + this.Y.right) - (this.N.getWidth() - this.N.getPaddingRight())) > 0) {
                i3 = width;
            }
            if (layoutManager.canScrollVertically()) {
                int i19 = (int) (this.G + this.E);
                int paddingTop = ((i19 - this.Y.top) - this.N.getPaddingTop()) - this.f319272a0;
                float f17 = this.E;
                if (f17 < 0.0f && paddingTop < 0) {
                    i16 = paddingTop;
                } else if (f17 > 0.0f) {
                    i16 = ((i19 + this.f319275f.itemView.getHeight()) + this.Y.bottom) - (this.N.getHeight() - this.N.getPaddingBottom());
                }
                if (i3 != 0) {
                    i3 = this.I.p(this.N, this.f319275f.itemView.getWidth(), i3, this.N.getWidth(), j3);
                }
                int i26 = i3;
                if (i16 != 0) {
                    i17 = i26;
                    i16 = this.I.p(this.N, this.f319275f.itemView.getHeight(), i16, this.N.getHeight(), j3);
                } else {
                    i17 = i26;
                }
                if (i17 != 0 && i16 == 0) {
                    this.Z = Long.MIN_VALUE;
                    return false;
                }
                if (this.Z == Long.MIN_VALUE) {
                    this.Z = currentTimeMillis;
                }
                this.N.scrollBy(i17, i16);
                return true;
            }
            i16 = 0;
            if (i3 != 0) {
            }
            int i262 = i3;
            if (i16 != 0) {
            }
            if (i17 != 0) {
            }
            if (this.Z == Long.MIN_VALUE) {
            }
            this.N.scrollBy(i17, i16);
            return true;
        }
        i3 = 0;
        if (layoutManager.canScrollVertically()) {
        }
        i16 = 0;
        if (i3 != 0) {
        }
        int i2622 = i3;
        if (i16 != 0) {
        }
        if (i17 != 0) {
        }
        if (this.Z == Long.MIN_VALUE) {
        }
        this.N.scrollBy(i17, i16);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void select(RecyclerView.ViewHolder viewHolder, int i3) {
        boolean z16;
        boolean z17;
        ViewParent parent;
        boolean z18;
        int swipeIfNecessary;
        float f16;
        float signum;
        int i16;
        if (viewHolder == this.f319275f && i3 == this.J) {
            return;
        }
        this.Z = Long.MIN_VALUE;
        int i17 = this.J;
        b(viewHolder, true);
        this.J = i3;
        if (i3 == 2) {
            if (viewHolder != null) {
                this.U = viewHolder.itemView;
            }
            addChildDrawingOrderCallback();
        }
        int i18 = (1 << ((i3 * 8) + 8)) - 1;
        RecyclerView.ViewHolder viewHolder2 = this.f319275f;
        if (viewHolder2 != null) {
            if (viewHolder2.itemView.getParent() != null) {
                if (i17 == 2) {
                    swipeIfNecessary = 0;
                } else {
                    swipeIfNecessary = swipeIfNecessary(viewHolder2);
                }
                releaseVelocityTracker();
                if (swipeIfNecessary != 1 && swipeIfNecessary != 2) {
                    if (swipeIfNecessary != 4 && swipeIfNecessary != 8 && swipeIfNecessary != 16 && swipeIfNecessary != 32) {
                        f16 = 0.0f;
                        signum = 0.0f;
                    } else {
                        signum = 0.0f;
                        f16 = Math.signum(this.D) * this.N.getWidth();
                    }
                } else {
                    f16 = 0.0f;
                    signum = Math.signum(this.E) * this.N.getHeight();
                }
                if (i17 == 2) {
                    i16 = 8;
                } else if (swipeIfNecessary > 0) {
                    i16 = 2;
                } else {
                    i16 = 4;
                }
                getSelectedDxDy(this.f319274e);
                float[] fArr = this.f319274e;
                float f17 = fArr[0];
                float f18 = fArr[1];
                b bVar = new b(viewHolder2, i16, i17, f17, f18, f16, signum, swipeIfNecessary, viewHolder2);
                bVar.b(this.I.g(this.N, i16, f16 - f17, signum - f18));
                this.L.add(bVar);
                bVar.d();
                z16 = true;
            } else {
                removeChildDrawingOrderCallbackIfNecessary(viewHolder2.itemView);
                this.I.c(this.N, viewHolder2);
                z16 = false;
            }
            this.f319275f = null;
        } else {
            z16 = false;
        }
        if (viewHolder != null) {
            this.K = (this.I.f(this.N, viewHolder) & i18) >> (this.J * 8);
            this.F = viewHolder.itemView.getLeft();
            this.G = viewHolder.itemView.getTop();
            this.f319275f = viewHolder;
            if (i3 == 2) {
                z17 = false;
                viewHolder.itemView.performHapticFeedback(0);
                parent = this.N.getParent();
                if (parent != null) {
                    if (this.f319275f != null) {
                        z18 = true;
                    } else {
                        z18 = z17;
                    }
                    parent.requestDisallowInterceptTouchEvent(z18);
                }
                if (!z16) {
                    this.N.getLayoutManager().requestSimpleAnimationsInNextLayout();
                }
                this.I.A(this.f319275f, this.J);
                this.N.invalidate();
            }
        }
        z17 = false;
        parent = this.N.getParent();
        if (parent != null) {
        }
        if (!z16) {
        }
        this.I.A(this.f319275f, this.J);
        this.N.invalidate();
    }

    public void startDrag(RecyclerView.ViewHolder viewHolder) {
        if (!this.I.o(this.N, viewHolder)) {
            Log.e("ItemTouchHelper", "Start drag has been called but dragging is not enabled");
            return;
        }
        if (viewHolder.itemView.getParent() != this.N) {
            Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
            return;
        }
        obtainVelocityTracker();
        this.E = 0.0f;
        this.D = 0.0f;
        select(viewHolder, 2);
    }

    void updateDxDy(MotionEvent motionEvent, int i3, int i16) {
        float x16 = motionEvent.getX(i16);
        float y16 = motionEvent.getY(i16);
        float f16 = x16 - this.f319276h;
        this.D = f16;
        this.E = y16 - this.f319277i;
        if ((i3 & 4) == 0) {
            this.D = Math.max(0.0f, f16);
        }
        if ((i3 & 8) == 0) {
            this.D = Math.min(0.0f, this.D);
        }
        if ((i3 & 1) == 0) {
            this.E = Math.max(0.0f, this.E);
        }
        if ((i3 & 2) == 0) {
            this.E = Math.min(0.0f, this.E);
        }
    }

    private void addChildDrawingOrderCallback() {
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        private int f319285a = -1;

        /* renamed from: c, reason: collision with root package name */
        private static final Interpolator f319283c = new a();

        /* renamed from: d, reason: collision with root package name */
        private static final Interpolator f319284d = new b();

        /* renamed from: b, reason: collision with root package name */
        private static final com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.e f319282b = new com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.g();

        /* compiled from: P */
        /* loaded from: classes21.dex */
        class a implements Interpolator {
            a() {
            }

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f16) {
                return f16 * f16 * f16 * f16 * f16;
            }
        }

        /* compiled from: P */
        /* loaded from: classes21.dex */
        class b implements Interpolator {
            b() {
            }

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f16) {
                float f17 = f16 - 1.0f;
                return (f17 * f17 * f17 * f17 * f17) + 1.0f;
            }
        }

        public static int e(int i3, int i16) {
            int i17;
            int i18 = i3 & 789516;
            if (i18 == 0) {
                return i3;
            }
            int i19 = i3 & (~i18);
            if (i16 == 0) {
                i17 = i18 << 2;
            } else {
                int i26 = i18 << 1;
                i19 |= (-789517) & i26;
                i17 = (i26 & 789516) << 2;
            }
            return i19 | i17;
        }

        private int i(RecyclerView recyclerView) {
            if (this.f319285a == -1) {
                this.f319285a = recyclerView.getResources().getDimensionPixelSize(R.dimen.f159066ve);
            }
            return this.f319285a;
        }

        public static int s(int i3, int i16) {
            return i16 << (i3 * 8);
        }

        public static int t(int i3, int i16) {
            return s(2, i3) | s(1, i16) | s(0, i16 | i3);
        }

        public void A(RecyclerView.ViewHolder viewHolder, int i3) {
            if (viewHolder != null) {
                f319282b.onSelected(viewHolder.itemView);
            }
        }

        public abstract void B(RecyclerView.ViewHolder viewHolder, int i3);

        public boolean a(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            return true;
        }

        public RecyclerView.ViewHolder b(RecyclerView.ViewHolder viewHolder, List<RecyclerView.ViewHolder> list, int i3, int i16) {
            int bottom;
            int abs;
            int top;
            int abs2;
            int left;
            int abs3;
            int right;
            int abs4;
            int width = i3 + viewHolder.itemView.getWidth();
            int height = i16 + viewHolder.itemView.getHeight();
            int left2 = i3 - viewHolder.itemView.getLeft();
            int top2 = i16 - viewHolder.itemView.getTop();
            int size = list.size();
            RecyclerView.ViewHolder viewHolder2 = null;
            int i17 = -1;
            for (int i18 = 0; i18 < size; i18++) {
                RecyclerView.ViewHolder viewHolder3 = list.get(i18);
                if (left2 > 0 && (right = viewHolder3.itemView.getRight() - width) < 0 && viewHolder3.itemView.getRight() > viewHolder.itemView.getRight() && (abs4 = Math.abs(right)) > i17) {
                    viewHolder2 = viewHolder3;
                    i17 = abs4;
                }
                if (left2 < 0 && (left = viewHolder3.itemView.getLeft() - i3) > 0 && viewHolder3.itemView.getLeft() < viewHolder.itemView.getLeft() && (abs3 = Math.abs(left)) > i17) {
                    viewHolder2 = viewHolder3;
                    i17 = abs3;
                }
                if (top2 < 0 && (top = viewHolder3.itemView.getTop() - i16) > 0 && viewHolder3.itemView.getTop() < viewHolder.itemView.getTop() && (abs2 = Math.abs(top)) > i17) {
                    viewHolder2 = viewHolder3;
                    i17 = abs2;
                }
                if (top2 > 0 && (bottom = viewHolder3.itemView.getBottom() - height) < 0 && viewHolder3.itemView.getBottom() > viewHolder.itemView.getBottom() && (abs = Math.abs(bottom)) > i17) {
                    viewHolder2 = viewHolder3;
                    i17 = abs;
                }
            }
            return viewHolder2;
        }

        public void c(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            f319282b.clearView(viewHolder.itemView);
        }

        public int d(int i3, int i16) {
            int i17;
            int i18 = i3 & 3158064;
            if (i18 == 0) {
                return i3;
            }
            int i19 = i3 & (~i18);
            if (i16 == 0) {
                i17 = i18 >> 2;
            } else {
                int i26 = i18 >> 1;
                i19 |= (-3158065) & i26;
                i17 = (i26 & 3158064) >> 2;
            }
            return i19 | i17;
        }

        final int f(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return d(k(recyclerView, viewHolder), ViewCompat.getLayoutDirection(recyclerView));
        }

        public long g(RecyclerView recyclerView, int i3, float f16, float f17) {
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                if (i3 == 8) {
                    return 200L;
                }
                return 250L;
            }
            if (i3 == 8) {
                return itemAnimator.getMoveDuration();
            }
            return itemAnimator.getRemoveDuration();
        }

        public int h() {
            return 0;
        }

        public float j(RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public abstract int k(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder);

        public float m(RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        boolean o(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            if ((f(recyclerView, viewHolder) & ITVKAsset.VOD_ASSET_MASK_BIT) != 0) {
                return true;
            }
            return false;
        }

        public int p(RecyclerView recyclerView, int i3, int i16, int i17, long j3) {
            int i18 = i(recyclerView);
            float f16 = 1.0f;
            int signum = (int) (((int) Math.signum(i16)) * i18 * f319284d.getInterpolation(Math.min(1.0f, (Math.abs(i16) * 1.0f) / i3)));
            if (j3 <= 2000) {
                f16 = ((float) j3) / 2000.0f;
            }
            int interpolation = (int) (signum * f319283c.getInterpolation(f16));
            if (interpolation == 0) {
                if (i16 > 0) {
                    return 1;
                }
                return -1;
            }
            return interpolation;
        }

        public boolean q() {
            return true;
        }

        public abstract boolean r();

        public void u(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f16, float f17, int i3, boolean z16) {
            f319282b.onDraw(canvas, recyclerView, viewHolder.itemView, f16, f17, i3, z16);
        }

        public void v(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f16, float f17, int i3, boolean z16) {
            f319282b.onDrawOver(canvas, recyclerView, viewHolder.itemView, f16, f17, i3, z16);
        }

        void w(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<e> list, int i3, float f16, float f17) {
            int size = list.size();
            for (int i16 = 0; i16 < size; i16++) {
                e eVar = list.get(i16);
                eVar.e();
                int save = canvas.save();
                u(canvas, recyclerView, eVar.f319291i, eVar.F, eVar.G, eVar.f319292m, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                u(canvas, recyclerView, viewHolder, f16, f17, i3, true);
                canvas.restoreToCount(save2);
            }
        }

        void x(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<e> list, int i3, float f16, float f17) {
            int size = list.size();
            boolean z16 = false;
            for (int i16 = 0; i16 < size; i16++) {
                e eVar = list.get(i16);
                int save = canvas.save();
                v(canvas, recyclerView, eVar.f319291i, eVar.F, eVar.G, eVar.f319292m, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                v(canvas, recyclerView, viewHolder, f16, f17, i3, true);
                canvas.restoreToCount(save2);
            }
            for (int i17 = size - 1; i17 >= 0; i17--) {
                e eVar2 = list.get(i17);
                boolean z17 = eVar2.I;
                if (z17 && !eVar2.E) {
                    list.remove(i17);
                } else if (!z17) {
                    z16 = true;
                }
            }
            if (z16) {
                recyclerView.invalidate();
            }
        }

        public abstract boolean y(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2);

        /* JADX WARN: Multi-variable type inference failed */
        public void z(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i3, RecyclerView.ViewHolder viewHolder2, int i16, int i17, int i18) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof g) {
                ((g) layoutManager).prepareForDrop(viewHolder.itemView, viewHolder2.itemView, i17, i18);
                return;
            }
            if (layoutManager.canScrollHorizontally()) {
                if (layoutManager.getDecoratedLeft(viewHolder2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.scrollToPosition(i16);
                }
                if (layoutManager.getDecoratedRight(viewHolder2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.scrollToPosition(i16);
                }
            }
            if (layoutManager.canScrollVertically()) {
                if (layoutManager.getDecoratedTop(viewHolder2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.scrollToPosition(i16);
                }
                if (layoutManager.getDecoratedBottom(viewHolder2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.scrollToPosition(i16);
                }
            }
        }

        public float l(float f16) {
            return f16;
        }

        public float n(float f16) {
            return f16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class e extends com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.b {
        private final ValueAnimator C;
        final int D;
        public boolean E;
        float F;
        float G;
        boolean H = false;
        boolean I = false;
        private float J;

        /* renamed from: d, reason: collision with root package name */
        final float f319287d;

        /* renamed from: e, reason: collision with root package name */
        final float f319288e;

        /* renamed from: f, reason: collision with root package name */
        final float f319289f;

        /* renamed from: h, reason: collision with root package name */
        final float f319290h;

        /* renamed from: i, reason: collision with root package name */
        final RecyclerView.ViewHolder f319291i;

        /* renamed from: m, reason: collision with root package name */
        final int f319292m;

        /* compiled from: P */
        /* loaded from: classes21.dex */
        class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ItemTouchHelper f319293d;

            a(ItemTouchHelper itemTouchHelper) {
                this.f319293d = itemTouchHelper;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                e.this.c(valueAnimator.getAnimatedFraction());
            }
        }

        e(RecyclerView.ViewHolder viewHolder, int i3, int i16, float f16, float f17, float f18, float f19) {
            this.f319292m = i16;
            this.D = i3;
            this.f319291i = viewHolder;
            this.f319287d = f16;
            this.f319288e = f17;
            this.f319289f = f18;
            this.f319290h = f19;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.C = ofFloat;
            ofFloat.addUpdateListener(new a(ItemTouchHelper.this));
            ofFloat.setTarget(viewHolder.itemView);
            ofFloat.addListener(this);
            c(0.0f);
        }

        public void a() {
            this.C.cancel();
        }

        public void b(long j3) {
            this.C.setDuration(j3);
        }

        public void c(float f16) {
            this.J = f16;
        }

        public void d() {
            this.f319291i.setIsRecyclable(false);
            this.C.start();
        }

        public void e() {
            float f16 = this.f319287d;
            float f17 = this.f319289f;
            if (f16 == f17) {
                this.F = this.f319291i.itemView.getTranslationX();
            } else {
                this.F = f16 + (this.J * (f17 - f16));
            }
            float f18 = this.f319288e;
            float f19 = this.f319290h;
            if (f18 == f19) {
                this.G = this.f319291i.itemView.getTranslationY();
            } else {
                this.G = f18 + (this.J * (f19 - f18));
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            c(1.0f);
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.b, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.I) {
                this.f319291i.setIsRecyclable(true);
            }
            this.I = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.b, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(View view) {
    }
}
