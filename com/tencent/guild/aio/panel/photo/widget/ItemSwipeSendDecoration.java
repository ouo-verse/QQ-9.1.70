package com.tencent.guild.aio.panel.photo.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.guild.aio.panel.photo.widget.ItemSwipeSendDecoration;
import com.tencent.mobileqq.widget.f;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class ItemSwipeSendDecoration extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
    float C;
    private float D;
    private float E;

    @NonNull
    c G;
    int I;
    private int K;
    RecyclerView L;

    /* renamed from: h, reason: collision with root package name */
    float f112101h;

    /* renamed from: i, reason: collision with root package name */
    float f112102i;

    /* renamed from: m, reason: collision with root package name */
    float f112103m;

    /* renamed from: d, reason: collision with root package name */
    final List<View> f112098d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private final float[] f112099e = new float[2];

    /* renamed from: f, reason: collision with root package name */
    RecyclerView.ViewHolder f112100f = null;
    int F = -1;
    private int H = 0;
    List<d> J = new ArrayList();
    private final RecyclerView.OnItemTouchListener M = new a();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements RecyclerView.OnItemTouchListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            int findPointerIndex;
            d a16;
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                ItemSwipeSendDecoration.this.F = motionEvent.getPointerId(0);
                ItemSwipeSendDecoration.this.f112101h = motionEvent.getX();
                ItemSwipeSendDecoration.this.f112102i = motionEvent.getY();
                ItemSwipeSendDecoration itemSwipeSendDecoration = ItemSwipeSendDecoration.this;
                if (itemSwipeSendDecoration.f112100f == null && (a16 = itemSwipeSendDecoration.a(motionEvent)) != null) {
                    ItemSwipeSendDecoration itemSwipeSendDecoration2 = ItemSwipeSendDecoration.this;
                    itemSwipeSendDecoration2.f112101h -= a16.F;
                    itemSwipeSendDecoration2.f112102i -= a16.G;
                    itemSwipeSendDecoration2.endRecoverAnimation(a16.f112111i, true);
                    if (ItemSwipeSendDecoration.this.f112098d.remove(a16.f112111i.itemView)) {
                        ItemSwipeSendDecoration itemSwipeSendDecoration3 = ItemSwipeSendDecoration.this;
                        itemSwipeSendDecoration3.G.a(itemSwipeSendDecoration3.L, a16.f112111i);
                    }
                    ItemSwipeSendDecoration.this.select(a16.f112111i, a16.f112112m);
                    ItemSwipeSendDecoration itemSwipeSendDecoration4 = ItemSwipeSendDecoration.this;
                    itemSwipeSendDecoration4.updateDxDy(motionEvent, itemSwipeSendDecoration4.I, 0);
                }
            } else if (actionMasked != 3 && actionMasked != 1) {
                int i3 = ItemSwipeSendDecoration.this.F;
                if (i3 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i3)) >= 0) {
                    ItemSwipeSendDecoration.this.checkSelectForSwipe(actionMasked, motionEvent, findPointerIndex);
                }
            } else {
                ItemSwipeSendDecoration itemSwipeSendDecoration5 = ItemSwipeSendDecoration.this;
                itemSwipeSendDecoration5.F = -1;
                itemSwipeSendDecoration5.select(null, 0);
            }
            if (ItemSwipeSendDecoration.this.f112100f != null) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z16) {
            if (!z16) {
                return;
            }
            ItemSwipeSendDecoration.this.select(null, 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            if (ItemSwipeSendDecoration.this.F == -1) {
                return;
            }
            int actionMasked = motionEvent.getActionMasked();
            int findPointerIndex = motionEvent.findPointerIndex(ItemSwipeSendDecoration.this.F);
            if (findPointerIndex >= 0) {
                ItemSwipeSendDecoration.this.checkSelectForSwipe(actionMasked, motionEvent, findPointerIndex);
            }
            ItemSwipeSendDecoration itemSwipeSendDecoration = ItemSwipeSendDecoration.this;
            if (itemSwipeSendDecoration.f112100f == null) {
                return;
            }
            int i3 = 0;
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 6) {
                            int actionIndex = motionEvent.getActionIndex();
                            int pointerId = motionEvent.getPointerId(actionIndex);
                            ItemSwipeSendDecoration itemSwipeSendDecoration2 = ItemSwipeSendDecoration.this;
                            if (pointerId == itemSwipeSendDecoration2.F) {
                                if (actionIndex == 0) {
                                    i3 = 1;
                                }
                                itemSwipeSendDecoration2.F = motionEvent.getPointerId(i3);
                                ItemSwipeSendDecoration itemSwipeSendDecoration3 = ItemSwipeSendDecoration.this;
                                itemSwipeSendDecoration3.updateDxDy(motionEvent, itemSwipeSendDecoration3.I, actionIndex);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                } else {
                    if (findPointerIndex >= 0) {
                        itemSwipeSendDecoration.updateDxDy(motionEvent, itemSwipeSendDecoration.I, findPointerIndex);
                        ItemSwipeSendDecoration.this.L.invalidate();
                        return;
                    }
                    return;
                }
            }
            itemSwipeSendDecoration.select(null, 0);
            ItemSwipeSendDecoration.this.F = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b extends d {
        final /* synthetic */ int K;
        final /* synthetic */ RecyclerView.ViewHolder L;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(RecyclerView.ViewHolder viewHolder, int i3, int i16, float f16, float f17, float f18, float f19, int i17, RecyclerView.ViewHolder viewHolder2) {
            super(viewHolder, i3, i16, f16, f17, f18, f19);
            this.K = i17;
            this.L = viewHolder2;
        }

        @Override // com.tencent.guild.aio.panel.photo.widget.ItemSwipeSendDecoration.d, com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (this.H) {
                return;
            }
            if (this.K <= 0) {
                ItemSwipeSendDecoration itemSwipeSendDecoration = ItemSwipeSendDecoration.this;
                itemSwipeSendDecoration.G.a(itemSwipeSendDecoration.L, this.L);
            } else {
                ItemSwipeSendDecoration.this.f112098d.add(this.L.itemView);
                this.E = true;
                ItemSwipeSendDecoration.this.d(this, this.K);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static abstract class c {
        public static int j(int i3, int i16) {
            return i16 << (i3 * 8);
        }

        public static int k(int i3, int i16) {
            return j(0, i3 | i16) | j(1, i16);
        }

        public void a(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            viewHolder.itemView.setTranslationX(0.0f);
            viewHolder.itemView.setTranslationY(0.0f);
        }

        public int b(int i3, int i16) {
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

        final int c(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return b(e(recyclerView, viewHolder), ViewCompat.getLayoutDirection(recyclerView));
        }

        public abstract long d(@NonNull RecyclerView recyclerView, int i3, float f16, float f17);

        public abstract int e(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder);

        public abstract float f(float f16, float f17, @NonNull RecyclerView.ViewHolder viewHolder);

        public abstract float g(float f16, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder);

        public abstract float h(float f16, int i3);

        /* renamed from: i */
        public abstract boolean getSwipedEnable();

        public void l(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float f16, float f17, int i3, boolean z16) {
            viewHolder.itemView.setTranslationX(f16);
            viewHolder.itemView.setTranslationY(f17);
        }

        public abstract void m(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f16, float f17, float f18, int i3, boolean z16);

        public void n(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f16, float f17, int i3, int i16, float f18, boolean z16) {
            l(canvas, recyclerView, viewHolder, f16, f17, i3, z16);
        }

        void o(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<d> list, int i3, float f16, float f17) {
            int size = list.size();
            for (int i16 = 0; i16 < size; i16++) {
                d dVar = list.get(i16);
                dVar.update();
                int save = canvas.save();
                n(canvas, recyclerView, dVar.f112111i, dVar.F, dVar.G, dVar.f112112m, dVar.D, dVar.J, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                l(canvas, recyclerView, viewHolder, f16, f17, i3, true);
                canvas.restoreToCount(save2);
            }
        }

        void p(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<d> list, int i3, float f16, float f17, float f18) {
            int size = list.size();
            boolean z16 = false;
            for (int i16 = 0; i16 < size; i16++) {
                d dVar = list.get(i16);
                int save = canvas.save();
                m(canvas, recyclerView, dVar.f112111i, dVar.F, dVar.G, f18, dVar.f112112m, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                m(canvas, recyclerView, viewHolder, f16, f17, f18, i3, true);
                canvas.restoreToCount(save2);
            }
            for (int i17 = size - 1; i17 >= 0; i17--) {
                d dVar2 = list.get(i17);
                boolean z17 = dVar2.I;
                if (z17 && !dVar2.E) {
                    list.remove(i17);
                } else if (!z17) {
                    z16 = true;
                }
            }
            if (z16) {
                recyclerView.invalidate();
            }
        }

        public abstract void q(@NonNull RecyclerView.ViewHolder viewHolder, int i3);
    }

    public ItemSwipeSendDecoration(@NonNull c cVar) {
        this.G = cVar;
    }

    private float b(float f16, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return this.G.g(f16, recyclerView, viewHolder);
    }

    private float c(float f16, int i3) {
        return this.G.h(f16, i3);
    }

    private int checkVerticalSwipe(RecyclerView.ViewHolder viewHolder, int i3) {
        int i16;
        if ((i3 & 3) != 0) {
            if (this.C > 0.0f) {
                i16 = 2;
            } else {
                i16 = 1;
            }
            float height = this.L.getHeight() * this.G.f(this.f112101h, this.f112102i, viewHolder);
            if ((i3 & i16) != 0 && Math.abs(this.C) > height) {
                return i16;
            }
            return 0;
        }
        return 0;
    }

    private void destroyCallbacks() {
        this.L.removeItemDecoration(this);
        this.L.removeOnItemTouchListener(this.M);
        this.L.removeOnChildAttachStateChangeListener(this);
        for (int size = this.J.size() - 1; size >= 0; size--) {
            this.G.a(this.L, this.J.get(0).f112111i);
        }
        this.J.clear();
    }

    private RecyclerView.ViewHolder findSwipedView(MotionEvent motionEvent) {
        View findChildView;
        RecyclerView.LayoutManager layoutManager = this.L.getLayoutManager();
        int i3 = this.F;
        if (i3 == -1) {
            return null;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i3);
        float x16 = motionEvent.getX(findPointerIndex) - this.f112101h;
        float y16 = motionEvent.getY(findPointerIndex) - this.f112102i;
        float abs = Math.abs(x16);
        float abs2 = Math.abs(y16);
        int i16 = this.K;
        if (abs < i16 && abs2 < i16) {
            return null;
        }
        if (abs > abs2 && layoutManager.canScrollHorizontally()) {
            return null;
        }
        if ((abs2 > abs && layoutManager.canScrollVertically()) || (findChildView = findChildView(motionEvent)) == null) {
            return null;
        }
        return this.L.getChildViewHolder(findChildView);
    }

    private void getSelectedDxDy(float[] fArr) {
        if ((this.I & 12) != 0) {
            fArr[0] = (this.D + this.f112103m) - this.f112100f.itemView.getLeft();
        } else {
            fArr[0] = this.f112100f.itemView.getTranslationX();
        }
        if ((this.I & 3) != 0) {
            fArr[1] = (this.E + this.C) - this.f112100f.itemView.getTop();
        } else {
            fArr[1] = this.f112100f.itemView.getTranslationY();
        }
    }

    private static boolean hitTest(View view, float f16, float f17, float f18, float f19) {
        if (f16 >= f18 && f16 <= f18 + view.getWidth() && f17 >= f19 && f17 <= f19 + view.getHeight()) {
            return true;
        }
        return false;
    }

    private void setupCallbacks() {
        this.K = ViewConfiguration.get(this.L.getContext()).getScaledTouchSlop();
        this.L.addItemDecoration(this);
        this.L.addOnItemTouchListener(this.M);
        this.L.addOnChildAttachStateChangeListener(this);
    }

    private int swipeIfNecessary(RecyclerView.ViewHolder viewHolder) {
        int checkVerticalSwipe;
        int b16 = (this.G.b(this.G.e(this.L, viewHolder), ViewCompat.getLayoutDirection(this.L)) & 65280) >> 8;
        if (b16 == 0 || (checkVerticalSwipe = checkVerticalSwipe(viewHolder, b16)) <= 0) {
            return 0;
        }
        return checkVerticalSwipe;
    }

    d a(MotionEvent motionEvent) {
        if (this.J.isEmpty()) {
            return null;
        }
        View findChildView = findChildView(motionEvent);
        for (int size = this.J.size() - 1; size >= 0; size--) {
            d dVar = this.J.get(size);
            if (dVar.f112111i.itemView == findChildView) {
                return dVar;
            }
        }
        return null;
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.L;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            destroyCallbacks();
        }
        this.L = recyclerView;
        if (recyclerView != null) {
            setupCallbacks();
        }
    }

    void checkSelectForSwipe(int i3, MotionEvent motionEvent, int i16) {
        RecyclerView.ViewHolder findSwipedView;
        int c16;
        if (this.f112100f != null || i3 != 2 || !this.G.getSwipedEnable() || this.L.getScrollState() == 1 || (findSwipedView = findSwipedView(motionEvent)) == null || (c16 = (this.G.c(this.L, findSwipedView) & 65280) >> 8) == 0) {
            return;
        }
        float x16 = motionEvent.getX(i16);
        float y16 = motionEvent.getY(i16);
        float f16 = x16 - this.f112101h;
        float f17 = y16 - this.f112102i;
        float abs = Math.abs(f16);
        float abs2 = Math.abs(f17);
        int i17 = this.K;
        if (abs < i17 && abs2 < i17) {
            return;
        }
        if (abs > abs2) {
            if (f16 < 0.0f && (c16 & 4) == 0) {
                return;
            }
            if (f16 > 0.0f && (c16 & 8) == 0) {
                return;
            }
        } else {
            if (f17 < 0.0f && (c16 & 1) == 0) {
                return;
            }
            if (f17 > 0.0f && (c16 & 2) == 0) {
                return;
            }
        }
        this.C = 0.0f;
        this.f112103m = 0.0f;
        this.F = motionEvent.getPointerId(0);
        select(findSwipedView, 1);
    }

    void d(final d dVar, final int i3) {
        this.L.post(new Runnable() { // from class: com.tencent.guild.aio.panel.photo.widget.ItemSwipeSendDecoration.3
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView recyclerView = ItemSwipeSendDecoration.this.L;
                if (recyclerView != null && recyclerView.isAttachedToWindow()) {
                    d dVar2 = dVar;
                    if (!dVar2.H && dVar2.f112111i.getAdapterPosition() != -1) {
                        RecyclerView.ItemAnimator itemAnimator = ItemSwipeSendDecoration.this.L.getItemAnimator();
                        if ((itemAnimator == null || !itemAnimator.isRunning(null)) && !ItemSwipeSendDecoration.this.hasRunningRecoverAnim()) {
                            ItemSwipeSendDecoration.this.G.q(dVar.f112111i, i3);
                        } else {
                            ItemSwipeSendDecoration.this.L.post(this);
                        }
                    }
                }
            }
        });
    }

    void endRecoverAnimation(RecyclerView.ViewHolder viewHolder, boolean z16) {
        for (int size = this.J.size() - 1; size >= 0; size--) {
            d dVar = this.J.get(size);
            if (dVar.f112111i == viewHolder) {
                dVar.H |= z16;
                if (!dVar.I) {
                    dVar.cancel();
                }
                this.J.remove(size);
                return;
            }
        }
    }

    View findChildView(MotionEvent motionEvent) {
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        RecyclerView.ViewHolder viewHolder = this.f112100f;
        if (viewHolder != null) {
            View view = viewHolder.itemView;
            if (hitTest(view, x16, y16, this.D + this.f112103m, this.E + this.C)) {
                return view;
            }
        }
        for (int size = this.J.size() - 1; size >= 0; size--) {
            d dVar = this.J.get(size);
            View view2 = dVar.f112111i.itemView;
            if (hitTest(view2, x16, y16, dVar.F, dVar.G)) {
                return view2;
            }
        }
        return this.L.findChildViewUnder(x16, y16);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.setEmpty();
    }

    boolean hasRunningRecoverAnim() {
        int size = this.J.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!this.J.get(i3).I) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(@NonNull View view) {
        RecyclerView.ViewHolder childViewHolder = this.L.getChildViewHolder(view);
        if (childViewHolder == null) {
            return;
        }
        RecyclerView.ViewHolder viewHolder = this.f112100f;
        if (viewHolder != null && childViewHolder == viewHolder) {
            select(null, 0);
            return;
        }
        endRecoverAnimation(childViewHolder, false);
        if (this.f112098d.remove(childViewHolder.itemView)) {
            this.G.a(this.L, childViewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f16;
        float f17;
        if (this.f112100f != null) {
            getSelectedDxDy(this.f112099e);
            float[] fArr = this.f112099e;
            float f18 = fArr[0];
            f17 = fArr[1];
            f16 = f18;
        } else {
            f16 = 0.0f;
            f17 = 0.0f;
        }
        this.G.o(canvas, recyclerView, this.f112100f, this.J, this.H, f16, f17);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f16;
        float f17;
        if (this.f112100f != null) {
            getSelectedDxDy(this.f112099e);
            float[] fArr = this.f112099e;
            float f18 = fArr[0];
            f17 = fArr[1];
            f16 = f18;
        } else {
            f16 = 0.0f;
            f17 = 0.0f;
        }
        this.G.p(canvas, recyclerView, this.f112100f, this.J, this.H, f16, f17, this.f112102i);
    }

    void select(@Nullable RecyclerView.ViewHolder viewHolder, int i3) {
        boolean z16;
        boolean z17;
        float b16;
        float c16;
        if (viewHolder == this.f112100f && i3 == this.H) {
            return;
        }
        int i16 = this.H;
        endRecoverAnimation(viewHolder, true);
        this.H = i3;
        int i17 = (1 << ((i3 * 8) + 8)) - 1;
        RecyclerView.ViewHolder viewHolder2 = this.f112100f;
        if (viewHolder2 != null) {
            if (viewHolder2.itemView.getParent() != null) {
                int swipeIfNecessary = swipeIfNecessary(viewHolder2);
                int i18 = 2;
                if (swipeIfNecessary != 1 && swipeIfNecessary != 2) {
                    b16 = 0.0f;
                    c16 = 0.0f;
                } else {
                    b16 = b(this.f112101h, this.L, viewHolder2);
                    c16 = c(this.C, this.L.getHeight());
                }
                if (swipeIfNecessary <= 0) {
                    i18 = 4;
                }
                int i19 = i18;
                getSelectedDxDy(this.f112099e);
                float[] fArr = this.f112099e;
                float f16 = fArr[0];
                float f17 = fArr[1];
                b bVar = new b(viewHolder2, i19, i16, f16, f17, b16, c16, swipeIfNecessary, viewHolder2);
                bVar.setDuration(this.G.d(this.L, i19, b16 - f16, c16 - f17));
                this.J.add(bVar);
                bVar.start();
                z16 = true;
            } else {
                this.G.a(this.L, viewHolder2);
                z16 = false;
            }
            this.f112100f = null;
        } else {
            z16 = false;
        }
        if (viewHolder != null) {
            this.I = (this.G.c(this.L, viewHolder) & i17) >> (this.H * 8);
            this.D = viewHolder.itemView.getLeft();
            this.E = viewHolder.itemView.getTop();
            this.f112100f = viewHolder;
        }
        ViewParent parent = this.L.getParent();
        if (parent != null) {
            if (this.f112100f != null) {
                z17 = true;
            } else {
                z17 = false;
            }
            parent.requestDisallowInterceptTouchEvent(z17);
        }
        if (!z16) {
            this.L.getLayoutManager().requestSimpleAnimationsInNextLayout();
        }
        this.L.invalidate();
    }

    void updateDxDy(MotionEvent motionEvent, int i3, int i16) {
        float x16 = motionEvent.getX(i16);
        float y16 = motionEvent.getY(i16);
        float f16 = x16 - this.f112101h;
        this.f112103m = f16;
        this.C = y16 - this.f112102i;
        if ((i3 & 4) == 0) {
            this.f112103m = Math.max(0.0f, f16);
        }
        if ((i3 & 8) == 0) {
            this.f112103m = Math.min(0.0f, this.f112103m);
        }
        if ((i3 & 1) == 0) {
            this.C = Math.max(0.0f, this.C);
        }
        if ((i3 & 2) == 0) {
            this.C = Math.min(0.0f, this.C);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class d extends f {
        private final ValueAnimator C;
        final int D;
        boolean E;
        float F;
        float G;
        boolean H = false;
        boolean I = false;
        private float J;

        /* renamed from: d, reason: collision with root package name */
        final float f112107d;

        /* renamed from: e, reason: collision with root package name */
        final float f112108e;

        /* renamed from: f, reason: collision with root package name */
        final float f112109f;

        /* renamed from: h, reason: collision with root package name */
        final float f112110h;

        /* renamed from: i, reason: collision with root package name */
        final RecyclerView.ViewHolder f112111i;

        /* renamed from: m, reason: collision with root package name */
        final int f112112m;

        d(RecyclerView.ViewHolder viewHolder, int i3, int i16, float f16, float f17, float f18, float f19) {
            this.f112112m = i16;
            this.D = i3;
            this.f112111i = viewHolder;
            this.f112107d = f16;
            this.f112108e = f17;
            this.f112109f = f18;
            this.f112110h = f19;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.C = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.guild.aio.panel.photo.widget.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ItemSwipeSendDecoration.d.this.g(valueAnimator);
                }
            });
            ofFloat.setTarget(viewHolder.itemView);
            ofFloat.addListener(this);
            setFraction(0.0f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(ValueAnimator valueAnimator) {
            setFraction(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }

        public void cancel() {
            this.C.cancel();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            setFraction(1.0f);
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.I) {
                this.f112111i.setIsRecyclable(true);
            }
            this.I = true;
        }

        public void setDuration(long j3) {
            this.C.setDuration(j3);
        }

        public void setFraction(float f16) {
            this.J = f16;
        }

        public void start() {
            this.f112111i.setIsRecyclable(false);
            this.C.setInterpolator(new DecelerateInterpolator(1.0f));
            this.C.start();
        }

        public void update() {
            float f16 = this.f112107d;
            float f17 = this.f112109f;
            if (f16 == f17) {
                this.F = this.f112111i.itemView.getTranslationX();
            } else {
                this.F = f16 + (this.J * (f17 - f16));
            }
            float f18 = this.f112108e;
            float f19 = this.f112110h;
            if (f18 == f19) {
                this.G = this.f112111i.itemView.getTranslationY();
            } else {
                this.G = f18 + (this.J * (f19 - f18));
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(@NonNull View view) {
    }
}
