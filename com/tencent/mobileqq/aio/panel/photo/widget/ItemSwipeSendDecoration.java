package com.tencent.mobileqq.aio.panel.photo.widget;

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
import com.tencent.mobileqq.aio.panel.photo.widget.ItemSwipeSendDecoration;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.f;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ItemSwipeSendDecoration extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
    static IPatchRedirector $redirector_;
    float C;
    private float D;
    private float E;
    int F;

    @NonNull
    c G;
    private int H;
    int I;
    List<d> J;
    private int K;
    RecyclerView L;
    private final RecyclerView.OnItemTouchListener M;

    /* renamed from: d, reason: collision with root package name */
    final List<View> f193114d;

    /* renamed from: e, reason: collision with root package name */
    private final float[] f193115e;

    /* renamed from: f, reason: collision with root package name */
    RecyclerView.ViewHolder f193116f;

    /* renamed from: h, reason: collision with root package name */
    float f193117h;

    /* renamed from: i, reason: collision with root package name */
    float f193118i;

    /* renamed from: m, reason: collision with root package name */
    float f193119m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements RecyclerView.OnItemTouchListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ItemSwipeSendDecoration.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            int findPointerIndex;
            d b16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView, (Object) motionEvent)).booleanValue();
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                ItemSwipeSendDecoration.this.F = motionEvent.getPointerId(0);
                ItemSwipeSendDecoration.this.f193117h = motionEvent.getX();
                ItemSwipeSendDecoration.this.f193118i = motionEvent.getY();
                ItemSwipeSendDecoration itemSwipeSendDecoration = ItemSwipeSendDecoration.this;
                if (itemSwipeSendDecoration.f193116f == null && (b16 = itemSwipeSendDecoration.b(motionEvent)) != null) {
                    ItemSwipeSendDecoration itemSwipeSendDecoration2 = ItemSwipeSendDecoration.this;
                    itemSwipeSendDecoration2.f193117h -= b16.F;
                    itemSwipeSendDecoration2.f193118i -= b16.G;
                    itemSwipeSendDecoration2.endRecoverAnimation(b16.f193128i, true);
                    if (ItemSwipeSendDecoration.this.f193114d.remove(b16.f193128i.itemView)) {
                        ItemSwipeSendDecoration itemSwipeSendDecoration3 = ItemSwipeSendDecoration.this;
                        itemSwipeSendDecoration3.G.a(itemSwipeSendDecoration3.L, b16.f193128i);
                    }
                    ItemSwipeSendDecoration.this.select(b16.f193128i, b16.f193129m);
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
            if (ItemSwipeSendDecoration.this.f193116f != null) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
            } else {
                if (!z16) {
                    return;
                }
                ItemSwipeSendDecoration.this.select(null, 0);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) recyclerView, (Object) motionEvent);
                return;
            }
            if (ItemSwipeSendDecoration.this.F == -1) {
                return;
            }
            int actionMasked = motionEvent.getActionMasked();
            int findPointerIndex = motionEvent.findPointerIndex(ItemSwipeSendDecoration.this.F);
            if (findPointerIndex >= 0) {
                ItemSwipeSendDecoration.this.checkSelectForSwipe(actionMasked, motionEvent, findPointerIndex);
            }
            ItemSwipeSendDecoration itemSwipeSendDecoration = ItemSwipeSendDecoration.this;
            if (itemSwipeSendDecoration.f193116f == null) {
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
    /* loaded from: classes11.dex */
    public class b extends d {
        static IPatchRedirector $redirector_;
        final /* synthetic */ int K;
        final /* synthetic */ RecyclerView.ViewHolder L;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(RecyclerView.ViewHolder viewHolder, int i3, int i16, float f16, float f17, float f18, float f19, int i17, RecyclerView.ViewHolder viewHolder2) {
            super(viewHolder, i3, i16, f16, f17, f18, f19);
            this.K = i17;
            this.L = viewHolder2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ItemSwipeSendDecoration.this, viewHolder, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Integer.valueOf(i17), viewHolder2);
            }
        }

        @Override // com.tencent.mobileqq.aio.panel.photo.widget.ItemSwipeSendDecoration.d, com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                return;
            }
            super.onAnimationEnd(animator);
            if (this.H) {
                return;
            }
            if (this.K <= 0) {
                ItemSwipeSendDecoration itemSwipeSendDecoration = ItemSwipeSendDecoration.this;
                itemSwipeSendDecoration.G.a(itemSwipeSendDecoration.L, this.L);
            } else {
                ItemSwipeSendDecoration.this.f193114d.add(this.L.itemView);
                this.E = true;
                ItemSwipeSendDecoration.this.f(this, this.K);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static abstract class c {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public static int k(int i3, int i16) {
            return i16 << (i3 * 8);
        }

        public static int l(int i3, int i16) {
            return k(0, i3 | i16) | k(1, i16);
        }

        public void a(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) recyclerView, (Object) viewHolder);
            } else {
                viewHolder.itemView.setTranslationX(0.0f);
                viewHolder.itemView.setTranslationY(0.0f);
            }
        }

        public int b(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
            }
            int i17 = i3 & 3158064;
            if (i17 == 0) {
                return i3;
            }
            int i18 = i3 & (~i17);
            if (i16 == 0) {
                return i18 | (i17 >> 2);
            }
            int i19 = i17 >> 1;
            return i18 | ((-3158065) & i19) | ((i19 & 3158064) >> 2);
        }

        final int c(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return b(f(recyclerView, viewHolder), ViewCompat.getLayoutDirection(recyclerView));
        }

        public abstract long d(@NonNull RecyclerView recyclerView, int i3, float f16, float f17);

        public abstract int e();

        public abstract int f(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder);

        public abstract float g(float f16, float f17, @NonNull RecyclerView.ViewHolder viewHolder);

        public abstract float h(float f16, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder);

        public abstract float i(float f16, RecyclerView recyclerView, int i3);

        public abstract boolean j();

        public void m(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float f16, float f17, int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, canvas, recyclerView, viewHolder, Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(i3), Boolean.valueOf(z16));
            } else {
                viewHolder.itemView.setTranslationX(f16);
                viewHolder.itemView.setTranslationY(f17);
            }
        }

        public abstract void n(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f16, float f17, float f18, int i3, boolean z16);

        public void o(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f16, float f17, int i3, int i16, float f18, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, canvas, recyclerView, viewHolder, Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f18), Boolean.valueOf(z16));
            } else {
                m(canvas, recyclerView, viewHolder, f16, f17, i3, z16);
            }
        }

        void p(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<d> list, int i3, float f16, float f17) {
            int size = list.size();
            for (int i16 = 0; i16 < size; i16++) {
                d dVar = list.get(i16);
                dVar.update();
                int save = canvas.save();
                o(canvas, recyclerView, dVar.f193128i, dVar.F, dVar.G, dVar.f193129m, dVar.D, dVar.J, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                m(canvas, recyclerView, viewHolder, f16, f17, i3, true);
                canvas.restoreToCount(save2);
            }
        }

        void q(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<d> list, int i3, float f16, float f17, float f18) {
            int size = list.size();
            boolean z16 = false;
            for (int i16 = 0; i16 < size; i16++) {
                d dVar = list.get(i16);
                int save = canvas.save();
                n(canvas, recyclerView, dVar.f193128i, dVar.F, dVar.G, f18, dVar.f193129m, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                n(canvas, recyclerView, viewHolder, f16, f17, f18, i3, true);
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

        public abstract void r(@NonNull RecyclerView.ViewHolder viewHolder, int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class d extends f {
        static IPatchRedirector $redirector_;
        private final ValueAnimator C;
        final int D;
        boolean E;
        float F;
        float G;
        boolean H;
        boolean I;
        private float J;

        /* renamed from: d, reason: collision with root package name */
        final float f193124d;

        /* renamed from: e, reason: collision with root package name */
        final float f193125e;

        /* renamed from: f, reason: collision with root package name */
        final float f193126f;

        /* renamed from: h, reason: collision with root package name */
        final float f193127h;

        /* renamed from: i, reason: collision with root package name */
        final RecyclerView.ViewHolder f193128i;

        /* renamed from: m, reason: collision with root package name */
        final int f193129m;

        d(RecyclerView.ViewHolder viewHolder, int i3, int i16, float f16, float f17, float f18, float f19) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, viewHolder, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
                return;
            }
            this.H = false;
            this.I = false;
            this.f193129m = i16;
            this.D = i3;
            this.f193128i = viewHolder;
            this.f193124d = f16;
            this.f193125e = f17;
            this.f193126f = f18;
            this.f193127h = f19;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.C = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.aio.panel.photo.widget.a
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
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                this.C.cancel();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) animator);
            } else {
                setFraction(1.0f);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) animator);
                return;
            }
            if (!this.I) {
                this.f193128i.setIsRecyclable(true);
            }
            this.I = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) animator);
            }
        }

        public void setDuration(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, j3);
            } else {
                this.C.setDuration(j3);
            }
        }

        public void setFraction(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
            } else {
                this.J = f16;
            }
        }

        public void start() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            this.f193128i.setIsRecyclable(false);
            this.C.setInterpolator(new DecelerateInterpolator(1.0f));
            this.C.start();
        }

        public void update() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            float f16 = this.f193124d;
            float f17 = this.f193126f;
            if (f16 == f17) {
                this.F = this.f193128i.itemView.getTranslationX();
            } else {
                this.F = f16 + (this.J * (f17 - f16));
            }
            float f18 = this.f193125e;
            float f19 = this.f193127h;
            if (f18 == f19) {
                this.G = this.f193128i.itemView.getTranslationY();
            } else {
                this.G = f18 + (this.J * (f19 - f18));
            }
        }
    }

    public ItemSwipeSendDecoration(@NonNull c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
            return;
        }
        this.f193114d = new ArrayList();
        this.f193115e = new float[2];
        this.f193116f = null;
        this.F = -1;
        this.H = 0;
        this.J = new ArrayList();
        this.M = new a();
        this.G = cVar;
    }

    private float c(float f16, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return this.G.h(f16, recyclerView, viewHolder);
    }

    private int checkVerticalSwipe(RecyclerView.ViewHolder viewHolder, int i3) {
        int i16;
        if ((i3 & 3) != 0) {
            if (this.C > 0.0f) {
                i16 = 2;
            } else {
                i16 = 1;
            }
            float height = this.L.getHeight() * this.G.g(this.f193117h, this.f193118i, viewHolder);
            if ((i3 & i16) != 0 && Math.abs(this.C) > height) {
                return i16;
            }
            return 0;
        }
        return 0;
    }

    private float d(float f16, RecyclerView recyclerView, int i3) {
        return this.G.i(f16, recyclerView, i3);
    }

    private void destroyCallbacks() {
        this.L.removeItemDecoration(this);
        this.L.removeOnItemTouchListener(this.M);
        this.L.removeOnChildAttachStateChangeListener(this);
        for (int size = this.J.size() - 1; size >= 0; size--) {
            this.G.a(this.L, this.J.get(0).f193128i);
        }
        this.J.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(d dVar, int i3, boolean z16) {
        RecyclerView.ViewHolder viewHolder;
        if (!z16 && dVar != null && (viewHolder = dVar.f193128i) != null && viewHolder.getAdapterPosition() != -1) {
            this.G.r(dVar.f193128i, i3);
            return true;
        }
        return false;
    }

    private RecyclerView.ViewHolder findSwipedView(MotionEvent motionEvent) {
        View findChildView;
        RecyclerView.LayoutManager layoutManager = this.L.getLayoutManager();
        int i3 = this.F;
        if (i3 == -1) {
            return null;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i3);
        float x16 = motionEvent.getX(findPointerIndex) - this.f193117h;
        float y16 = motionEvent.getY(findPointerIndex) - this.f193118i;
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
            fArr[0] = (this.D + this.f193119m) - this.f193116f.itemView.getLeft();
        } else {
            fArr[0] = this.f193116f.itemView.getTranslationX();
        }
        if ((this.I & 3) != 0) {
            fArr[1] = (this.E + this.C) - this.f193116f.itemView.getTop();
        } else {
            fArr[1] = this.f193116f.itemView.getTranslationY();
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
        int b16 = (this.G.b(this.G.f(this.L, viewHolder), ViewCompat.getLayoutDirection(this.L)) & 65280) >> 8;
        if (b16 == 0 || (checkVerticalSwipe = checkVerticalSwipe(viewHolder, b16)) <= 0) {
            return 0;
        }
        return checkVerticalSwipe;
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView);
            return;
        }
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

    d b(MotionEvent motionEvent) {
        if (this.J.isEmpty()) {
            return null;
        }
        View findChildView = findChildView(motionEvent);
        for (int size = this.J.size() - 1; size >= 0; size--) {
            d dVar = this.J.get(size);
            if (dVar.f193128i.itemView == findChildView) {
                return dVar;
            }
        }
        return null;
    }

    void checkSelectForSwipe(int i3, MotionEvent motionEvent, int i16) {
        RecyclerView.ViewHolder findSwipedView;
        int c16;
        if (this.f193116f != null || i3 != 2 || !this.G.j() || this.L.getScrollState() == 1 || (findSwipedView = findSwipedView(motionEvent)) == null || (c16 = (this.G.c(this.L, findSwipedView) & 65280) >> 8) == 0) {
            return;
        }
        float x16 = motionEvent.getX(i16);
        float y16 = motionEvent.getY(i16);
        float f16 = x16 - this.f193117h;
        float f17 = y16 - this.f193118i;
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
        this.f193119m = 0.0f;
        this.F = motionEvent.getPointerId(0);
        select(findSwipedView, 1);
    }

    void endRecoverAnimation(RecyclerView.ViewHolder viewHolder, boolean z16) {
        for (int size = this.J.size() - 1; size >= 0; size--) {
            d dVar = this.J.get(size);
            if (dVar.f193128i == viewHolder) {
                dVar.H |= z16;
                if (!dVar.I) {
                    dVar.cancel();
                }
                this.J.remove(size);
                return;
            }
        }
    }

    void f(d dVar, int i3) {
        RecyclerView recyclerView = this.L;
        if (recyclerView == null) {
            QLog.i("ItemSwipeSendDecoration", 1, "mRecyclerView is null, return");
        } else if (e(dVar, i3, recyclerView.isAttachedToWindow())) {
            QLog.i("ItemSwipeSendDecoration", 1, "not need to enter runnable, send photo directly");
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(dVar, i3) { // from class: com.tencent.mobileqq.aio.panel.photo.widget.ItemSwipeSendDecoration.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                private int f193120d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ d f193121e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f193122f;

                {
                    this.f193121e = dVar;
                    this.f193122f = i3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, ItemSwipeSendDecoration.this, dVar, Integer.valueOf(i3));
                    } else {
                        this.f193120d = 0;
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    RecyclerView recyclerView2 = ItemSwipeSendDecoration.this.L;
                    if (recyclerView2 == null) {
                        QLog.i("ItemSwipeSendDecoration", 1, "enter runnable, mRecyclerView is null, return");
                        return;
                    }
                    boolean isAttachedToWindow = recyclerView2.isAttachedToWindow();
                    int adapterPosition = this.f193121e.f193128i.getAdapterPosition();
                    QLog.i("ItemSwipeSendDecoration", 1, "postDispatchSwipe retryCount:" + this.f193120d + ", mRecyclerView.isAttachedToWindow:" + isAttachedToWindow + ", anim.mOverridden:" + this.f193121e.H + ", adapterPosition:" + adapterPosition);
                    if (ItemSwipeSendDecoration.this.e(this.f193121e, this.f193122f, isAttachedToWindow)) {
                        QLog.i("ItemSwipeSendDecoration", 1, "enter runnable, send photo directly");
                        return;
                    }
                    if (isAttachedToWindow && !this.f193121e.H && adapterPosition != -1) {
                        RecyclerView.ItemAnimator itemAnimator = ItemSwipeSendDecoration.this.L.getItemAnimator();
                        if ((itemAnimator == null || !itemAnimator.isRunning(null)) && !ItemSwipeSendDecoration.this.hasRunningRecoverAnim()) {
                            QLog.i("ItemSwipeSendDecoration", 1, "enter runnable, send photo normally");
                            ItemSwipeSendDecoration.this.G.r(this.f193121e.f193128i, this.f193122f);
                        } else if (this.f193120d < 5) {
                            ThreadManagerV2.getUIHandlerV2().postDelayed(this, 10L);
                            this.f193120d++;
                        } else {
                            QLog.i("ItemSwipeSendDecoration", 1, "retry over limit times\uff0conSwiped directly");
                            ItemSwipeSendDecoration.this.G.r(this.f193121e.f193128i, this.f193122f);
                        }
                    }
                }
            });
        }
    }

    View findChildView(MotionEvent motionEvent) {
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        RecyclerView.ViewHolder viewHolder = this.f193116f;
        if (viewHolder != null) {
            View view = viewHolder.itemView;
            if (hitTest(view, x16, y16, this.D + this.f193119m, this.E + this.C)) {
                return view;
            }
        }
        for (int size = this.J.size() - 1; size >= 0; size--) {
            d dVar = this.J.get(size);
            View view2 = dVar.f193128i.itemView;
            if (hitTest(view2, x16, y16, dVar.F, dVar.G)) {
                return view2;
            }
        }
        return this.L.findChildViewUnder(x16, y16);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, rect, view, recyclerView, state);
        } else {
            rect.setEmpty();
        }
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
    public void onChildViewAttachedToWindow(@NonNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(@NonNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
            return;
        }
        RecyclerView.ViewHolder childViewHolder = this.L.getChildViewHolder(view);
        if (childViewHolder == null) {
            return;
        }
        RecyclerView.ViewHolder viewHolder = this.f193116f;
        if (viewHolder != null && childViewHolder == viewHolder) {
            select(null, 0);
            return;
        }
        endRecoverAnimation(childViewHolder, false);
        if (this.f193114d.remove(childViewHolder.itemView)) {
            this.G.a(this.L, childViewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f16;
        float f17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, canvas, recyclerView, state);
            return;
        }
        if (this.f193116f != null) {
            getSelectedDxDy(this.f193115e);
            float[] fArr = this.f193115e;
            float f18 = fArr[0];
            f17 = fArr[1];
            f16 = f18;
        } else {
            f16 = 0.0f;
            f17 = 0.0f;
        }
        this.G.p(canvas, recyclerView, this.f193116f, this.J, this.H, f16, f17);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f16;
        float f17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, canvas, recyclerView, state);
            return;
        }
        if (this.f193116f != null) {
            getSelectedDxDy(this.f193115e);
            float[] fArr = this.f193115e;
            float f18 = fArr[0];
            f17 = fArr[1];
            f16 = f18;
        } else {
            f16 = 0.0f;
            f17 = 0.0f;
        }
        this.G.q(canvas, recyclerView, this.f193116f, this.J, this.H, f16, f17, this.f193118i);
    }

    void select(@Nullable RecyclerView.ViewHolder viewHolder, int i3) {
        boolean z16;
        boolean z17;
        float c16;
        float d16;
        if (viewHolder == this.f193116f && i3 == this.H) {
            return;
        }
        int i16 = this.H;
        endRecoverAnimation(viewHolder, true);
        this.H = i3;
        int i17 = (1 << ((i3 * 8) + 8)) - 1;
        RecyclerView.ViewHolder viewHolder2 = this.f193116f;
        if (viewHolder2 != null) {
            if (viewHolder2.itemView.getParent() != null) {
                int swipeIfNecessary = swipeIfNecessary(viewHolder2);
                int i18 = 2;
                if (swipeIfNecessary != 1 && swipeIfNecessary != 2) {
                    c16 = 0.0f;
                    d16 = 0.0f;
                } else {
                    c16 = c(this.f193117h, this.L, viewHolder2);
                    d16 = d(this.C, this.L, this.G.e());
                }
                if (swipeIfNecessary <= 0) {
                    i18 = 4;
                }
                int i19 = i18;
                getSelectedDxDy(this.f193115e);
                float[] fArr = this.f193115e;
                float f16 = fArr[0];
                float f17 = fArr[1];
                b bVar = new b(viewHolder2, i19, i16, f16, f17, c16, d16, swipeIfNecessary, viewHolder2);
                bVar.setDuration(this.G.d(this.L, i19, c16 - f16, d16 - f17));
                this.J.add(bVar);
                bVar.start();
                z16 = true;
            } else {
                this.G.a(this.L, viewHolder2);
                z16 = false;
            }
            this.f193116f = null;
        } else {
            z16 = false;
        }
        if (viewHolder != null) {
            this.I = (this.G.c(this.L, viewHolder) & i17) >> (this.H * 8);
            this.D = viewHolder.itemView.getLeft();
            this.E = viewHolder.itemView.getTop();
            this.f193116f = viewHolder;
        }
        ViewParent parent = this.L.getParent();
        if (parent != null) {
            if (this.f193116f != null) {
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
        float f16 = x16 - this.f193117h;
        this.f193119m = f16;
        this.C = y16 - this.f193118i;
        if ((i3 & 4) == 0) {
            this.f193119m = Math.max(0.0f, f16);
        }
        if ((i3 & 8) == 0) {
            this.f193119m = Math.min(0.0f, this.f193119m);
        }
        if ((i3 & 1) == 0) {
            this.C = Math.max(0.0f, this.C);
        }
        if ((i3 & 2) == 0) {
            this.C = Math.min(0.0f, this.C);
        }
    }
}
