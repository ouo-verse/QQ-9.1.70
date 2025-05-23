package com.tencent.mobileqq.guild.feed.feedsquare.animator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tencent.mobileqq.guild.feed.feedsquare.animator.FeedDefaultItemAnimator;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes13.dex */
public class FeedDefaultItemAnimator extends SimpleItemAnimator {

    /* renamed from: m, reason: collision with root package name */
    private static TimeInterpolator f218732m;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<RecyclerView.ViewHolder> f218733a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<RecyclerView.ViewHolder> f218734b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<g> f218735c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<f> f218736d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    ArrayList<ArrayList<RecyclerView.ViewHolder>> f218737e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    ArrayList<ArrayList<g>> f218738f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    ArrayList<ArrayList<f>> f218739g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    ArrayList<RecyclerView.ViewHolder> f218740h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    ArrayList<RecyclerView.ViewHolder> f218741i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    ArrayList<RecyclerView.ViewHolder> f218742j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    ArrayList<RecyclerView.ViewHolder> f218743k = new ArrayList<>();

    /* renamed from: l, reason: collision with root package name */
    private boolean f218744l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f218748d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f218749e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f218750f;

        a(RecyclerView.ViewHolder viewHolder, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f218748d = viewHolder;
            this.f218749e = viewPropertyAnimator;
            this.f218750f = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f218749e.setListener(null);
            this.f218750f.setAlpha(1.0f);
            FeedDefaultItemAnimator.this.dispatchRemoveFinished(this.f218748d);
            FeedDefaultItemAnimator.this.f218742j.remove(this.f218748d);
            FeedDefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            FeedDefaultItemAnimator.this.dispatchRemoveStarting(this.f218748d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f218752d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f218753e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f218754f;

        b(RecyclerView.ViewHolder viewHolder, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f218752d = viewHolder;
            this.f218753e = view;
            this.f218754f = viewPropertyAnimator;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String c(RecyclerView.ViewHolder viewHolder) {
            return "animateAddImpl onAnimationCancel holder:" + viewHolder.hashCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String d(Animator animator) {
            return "animateAddImpl onAnimationEnd holder:" + animator.hashCode();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f218753e.setAlpha(1.0f);
            Logger logger = Logger.f235387a;
            final RecyclerView.ViewHolder viewHolder = this.f218752d;
            logger.e("FeedDefaultItemAnimator", new Function0() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.animator.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String c16;
                    c16 = FeedDefaultItemAnimator.b.c(RecyclerView.ViewHolder.this);
                    return c16;
                }
            });
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(final Animator animator) {
            this.f218754f.setListener(null);
            FeedDefaultItemAnimator.this.dispatchAddFinished(this.f218752d);
            FeedDefaultItemAnimator.this.f218740h.remove(this.f218752d);
            FeedDefaultItemAnimator.this.dispatchFinishedWhenDone();
            Logger.f235387a.e("FeedDefaultItemAnimator", new Function0() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.animator.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String d16;
                    d16 = FeedDefaultItemAnimator.b.d(animator);
                    return d16;
                }
            });
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            FeedDefaultItemAnimator.this.dispatchAddStarting(this.f218752d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f218756d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f218757e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f218758f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f218759h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f218760i;

        c(RecyclerView.ViewHolder viewHolder, int i3, View view, int i16, ViewPropertyAnimator viewPropertyAnimator) {
            this.f218756d = viewHolder;
            this.f218757e = i3;
            this.f218758f = view;
            this.f218759h = i16;
            this.f218760i = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f218757e != 0) {
                this.f218758f.setTranslationX(0.0f);
            }
            if (this.f218759h != 0) {
                this.f218758f.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f218760i.setListener(null);
            FeedDefaultItemAnimator.this.dispatchMoveFinished(this.f218756d);
            FeedDefaultItemAnimator.this.f218741i.remove(this.f218756d);
            FeedDefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            FeedDefaultItemAnimator.this.dispatchMoveStarting(this.f218756d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f218762d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f218763e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f218764f;

        d(f fVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f218762d = fVar;
            this.f218763e = viewPropertyAnimator;
            this.f218764f = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f218763e.setListener(null);
            this.f218764f.setAlpha(1.0f);
            this.f218764f.setTranslationX(0.0f);
            this.f218764f.setTranslationY(0.0f);
            FeedDefaultItemAnimator.this.dispatchChangeFinished(this.f218762d.f218770a, true);
            FeedDefaultItemAnimator.this.f218743k.remove(this.f218762d.f218770a);
            FeedDefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            FeedDefaultItemAnimator.this.dispatchChangeStarting(this.f218762d.f218770a, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f218766d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f218767e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f218768f;

        e(f fVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f218766d = fVar;
            this.f218767e = viewPropertyAnimator;
            this.f218768f = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f218767e.setListener(null);
            this.f218768f.setAlpha(1.0f);
            this.f218768f.setTranslationX(0.0f);
            this.f218768f.setTranslationY(0.0f);
            FeedDefaultItemAnimator.this.dispatchChangeFinished(this.f218766d.f218771b, false);
            FeedDefaultItemAnimator.this.f218743k.remove(this.f218766d.f218771b);
            FeedDefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            FeedDefaultItemAnimator.this.dispatchChangeStarting(this.f218766d.f218771b, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.ViewHolder f218776a;

        /* renamed from: b, reason: collision with root package name */
        public int f218777b;

        /* renamed from: c, reason: collision with root package name */
        public int f218778c;

        /* renamed from: d, reason: collision with root package name */
        public int f218779d;

        /* renamed from: e, reason: collision with root package name */
        public int f218780e;

        g(RecyclerView.ViewHolder viewHolder, int i3, int i16, int i17, int i18) {
            this.f218776a = viewHolder;
            this.f218777b = i3;
            this.f218778c = i16;
            this.f218779d = i17;
            this.f218780e = i18;
        }
    }

    public FeedDefaultItemAnimator(Boolean bool) {
        this.f218744l = false;
        this.f218744l = bool.booleanValue();
    }

    private void animateRemoveImpl(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.f218742j.add(viewHolder);
        animate.setDuration(getRemoveDuration()).alpha(0.0f).setListener(new a(viewHolder, animate, view)).start();
    }

    private void d(f fVar) {
        RecyclerView.ViewHolder viewHolder = fVar.f218770a;
        if (viewHolder != null) {
            e(fVar, viewHolder);
        }
        RecyclerView.ViewHolder viewHolder2 = fVar.f218771b;
        if (viewHolder2 != null) {
            e(fVar, viewHolder2);
        }
    }

    private boolean e(f fVar, RecyclerView.ViewHolder viewHolder) {
        boolean z16 = false;
        if (fVar.f218771b == viewHolder) {
            fVar.f218771b = null;
        } else {
            if (fVar.f218770a != viewHolder) {
                return false;
            }
            fVar.f218770a = null;
            z16 = true;
        }
        viewHolder.itemView.setAlpha(1.0f);
        viewHolder.itemView.setTranslationX(0.0f);
        viewHolder.itemView.setTranslationY(0.0f);
        dispatchChangeFinished(viewHolder, z16);
        return true;
    }

    private void endChangeAnimation(List<f> list, RecyclerView.ViewHolder viewHolder) {
        for (int size = list.size() - 1; size >= 0; size--) {
            f fVar = list.get(size);
            if (e(fVar, viewHolder) && fVar.f218770a == null && fVar.f218771b == null) {
                list.remove(fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String f(RecyclerView.ViewHolder viewHolder) {
        return "animateAddImpl begin holder:" + viewHolder.hashCode() + " duration:" + getAddDuration();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String g() {
        return "runPendingAnimations mPendingRemovals:" + this.f218733a.size() + " mPendingMoves:" + this.f218735c.size() + " mPendingChanges:" + this.f218736d.size() + "mPendingAdditions:" + this.f218734b.size();
    }

    private void resetAnimation(RecyclerView.ViewHolder viewHolder) {
        if (f218732m == null) {
            f218732m = new ValueAnimator().getInterpolator();
        }
        viewHolder.itemView.animate().setInterpolator(f218732m);
        endAnimation(viewHolder);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateAdd(RecyclerView.ViewHolder viewHolder) {
        resetAnimation(viewHolder);
        viewHolder.itemView.setAlpha(0.0f);
        this.f218734b.add(viewHolder);
        return true;
    }

    void animateAddImpl(final RecyclerView.ViewHolder viewHolder) {
        Logger.f235387a.e("FeedDefaultItemAnimator", new Function0() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.animator.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String f16;
                f16 = FeedDefaultItemAnimator.this.f(viewHolder);
                return f16;
            }
        });
        View view = viewHolder.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.f218740h.add(viewHolder);
        animate.alpha(1.0f).setDuration(getAddDuration()).setListener(new b(viewHolder, view, animate)).start();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i3, int i16, int i17, int i18) {
        if (viewHolder == viewHolder2) {
            return animateMove(viewHolder, i3, i16, i17, i18);
        }
        float translationX = viewHolder.itemView.getTranslationX();
        float translationY = viewHolder.itemView.getTranslationY();
        float alpha = viewHolder.itemView.getAlpha();
        resetAnimation(viewHolder);
        int i19 = (int) ((i17 - i3) - translationX);
        int i26 = (int) ((i18 - i16) - translationY);
        viewHolder.itemView.setTranslationX(translationX);
        viewHolder.itemView.setTranslationY(translationY);
        viewHolder.itemView.setAlpha(alpha);
        if (viewHolder2 != null) {
            resetAnimation(viewHolder2);
            viewHolder2.itemView.setTranslationX(-i19);
            viewHolder2.itemView.setTranslationY(-i26);
            viewHolder2.itemView.setAlpha(0.0f);
        }
        this.f218736d.add(new f(viewHolder, viewHolder2, i3, i16, i17, i18));
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateMove(RecyclerView.ViewHolder viewHolder, int i3, int i16, int i17, int i18) {
        View view = viewHolder.itemView;
        int translationX = i3 + ((int) view.getTranslationX());
        int translationY = i16 + ((int) viewHolder.itemView.getTranslationY());
        resetAnimation(viewHolder);
        int i19 = i17 - translationX;
        int i26 = i18 - translationY;
        if (i19 == 0 && i26 == 0) {
            dispatchMoveFinished(viewHolder);
            return false;
        }
        if (i19 != 0) {
            view.setTranslationX(-i19);
        }
        if (i26 != 0) {
            view.setTranslationY(-i26);
        }
        this.f218735c.add(new g(viewHolder, translationX, translationY, i17, i18));
        return true;
    }

    void animateMoveImpl(RecyclerView.ViewHolder viewHolder, int i3, int i16, int i17, int i18) {
        View view = viewHolder.itemView;
        int i19 = i17 - i3;
        int i26 = i18 - i16;
        if (i19 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i26 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.f218741i.add(viewHolder);
        animate.setDuration(getMoveDuration()).setListener(new c(viewHolder, i19, view, i26, animate)).start();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateRemove(RecyclerView.ViewHolder viewHolder) {
        resetAnimation(viewHolder);
        this.f218733a.add(viewHolder);
        return true;
    }

    void c(f fVar) {
        View view;
        RecyclerView.ViewHolder viewHolder = fVar.f218770a;
        View view2 = null;
        if (viewHolder == null) {
            view = null;
        } else {
            view = viewHolder.itemView;
        }
        RecyclerView.ViewHolder viewHolder2 = fVar.f218771b;
        if (viewHolder2 != null) {
            view2 = viewHolder2.itemView;
        }
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(getChangeDuration());
            this.f218743k.add(fVar.f218770a);
            duration.translationX(fVar.f218774e - fVar.f218772c);
            duration.translationY(fVar.f218775f - fVar.f218773d);
            duration.alpha(0.0f).setListener(new d(fVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.f218743k.add(fVar.f218771b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new e(fVar, animate, view2)).start();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<Object> list) {
        if (list.isEmpty() && !super.canReuseUpdatedViewHolder(viewHolder, list)) {
            return false;
        }
        return true;
    }

    void cancelAll(List<RecyclerView.ViewHolder> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    void dispatchFinishedWhenDone() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimation(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        view.animate().cancel();
        int size = this.f218735c.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.f218735c.get(size).f218776a == viewHolder) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                dispatchMoveFinished(viewHolder);
                this.f218735c.remove(size);
            }
        }
        endChangeAnimation(this.f218736d, viewHolder);
        if (this.f218733a.remove(viewHolder)) {
            view.setAlpha(1.0f);
            dispatchRemoveFinished(viewHolder);
        }
        if (this.f218734b.remove(viewHolder)) {
            view.setAlpha(1.0f);
            dispatchAddFinished(viewHolder);
        }
        for (int size2 = this.f218739g.size() - 1; size2 >= 0; size2--) {
            ArrayList<f> arrayList = this.f218739g.get(size2);
            endChangeAnimation(arrayList, viewHolder);
            if (arrayList.isEmpty()) {
                this.f218739g.remove(size2);
            }
        }
        for (int size3 = this.f218738f.size() - 1; size3 >= 0; size3--) {
            ArrayList<g> arrayList2 = this.f218738f.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).f218776a == viewHolder) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    dispatchMoveFinished(viewHolder);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f218738f.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f218737e.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.ViewHolder> arrayList3 = this.f218737e.get(size5);
            if (arrayList3.remove(viewHolder)) {
                view.setAlpha(1.0f);
                dispatchAddFinished(viewHolder);
                if (arrayList3.isEmpty()) {
                    this.f218737e.remove(size5);
                }
            }
        }
        this.f218742j.remove(viewHolder);
        this.f218740h.remove(viewHolder);
        this.f218743k.remove(viewHolder);
        this.f218741i.remove(viewHolder);
        dispatchFinishedWhenDone();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimations() {
        int size = this.f218735c.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            g gVar = this.f218735c.get(size);
            View view = gVar.f218776a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            dispatchMoveFinished(gVar.f218776a);
            this.f218735c.remove(size);
        }
        for (int size2 = this.f218733a.size() - 1; size2 >= 0; size2--) {
            dispatchRemoveFinished(this.f218733a.get(size2));
            this.f218733a.remove(size2);
        }
        int size3 = this.f218734b.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.ViewHolder viewHolder = this.f218734b.get(size3);
            viewHolder.itemView.setAlpha(1.0f);
            dispatchAddFinished(viewHolder);
            this.f218734b.remove(size3);
        }
        for (int size4 = this.f218736d.size() - 1; size4 >= 0; size4--) {
            d(this.f218736d.get(size4));
        }
        this.f218736d.clear();
        if (!isRunning()) {
            return;
        }
        for (int size5 = this.f218738f.size() - 1; size5 >= 0; size5--) {
            ArrayList<g> arrayList = this.f218738f.get(size5);
            for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                g gVar2 = arrayList.get(size6);
                View view2 = gVar2.f218776a.itemView;
                view2.setTranslationY(0.0f);
                view2.setTranslationX(0.0f);
                dispatchMoveFinished(gVar2.f218776a);
                arrayList.remove(size6);
                if (arrayList.isEmpty()) {
                    this.f218738f.remove(arrayList);
                }
            }
        }
        for (int size7 = this.f218737e.size() - 1; size7 >= 0; size7--) {
            ArrayList<RecyclerView.ViewHolder> arrayList2 = this.f218737e.get(size7);
            for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                RecyclerView.ViewHolder viewHolder2 = arrayList2.get(size8);
                viewHolder2.itemView.setAlpha(1.0f);
                dispatchAddFinished(viewHolder2);
                arrayList2.remove(size8);
                if (arrayList2.isEmpty()) {
                    this.f218737e.remove(arrayList2);
                }
            }
        }
        for (int size9 = this.f218739g.size() - 1; size9 >= 0; size9--) {
            ArrayList<f> arrayList3 = this.f218739g.get(size9);
            for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                d(arrayList3.get(size10));
                if (arrayList3.isEmpty()) {
                    this.f218739g.remove(arrayList3);
                }
            }
        }
        cancelAll(this.f218742j);
        cancelAll(this.f218741i);
        cancelAll(this.f218740h);
        cancelAll(this.f218743k);
        dispatchAnimationsFinished();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean isRunning() {
        if (this.f218734b.isEmpty() && this.f218736d.isEmpty() && this.f218735c.isEmpty() && this.f218733a.isEmpty() && this.f218741i.isEmpty() && this.f218742j.isEmpty() && this.f218740h.isEmpty() && this.f218743k.isEmpty() && this.f218738f.isEmpty() && this.f218737e.isEmpty() && this.f218739g.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        long j3;
        long j16;
        boolean z16 = !this.f218733a.isEmpty();
        boolean z17 = !this.f218735c.isEmpty();
        boolean z18 = !this.f218736d.isEmpty();
        boolean z19 = !this.f218734b.isEmpty();
        Logger.f235387a.e("FeedDefaultItemAnimator", new Function0() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.animator.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String g16;
                g16 = FeedDefaultItemAnimator.this.g();
                return g16;
            }
        });
        if (!z16 && !z17 && !z19 && !z18) {
            return;
        }
        Iterator<RecyclerView.ViewHolder> it = this.f218733a.iterator();
        while (it.hasNext()) {
            animateRemoveImpl(it.next());
        }
        this.f218733a.clear();
        if (z17) {
            final ArrayList<g> arrayList = new ArrayList<>();
            arrayList.addAll(this.f218735c);
            this.f218738f.add(arrayList);
            this.f218735c.clear();
            Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.animator.FeedDefaultItemAnimator.1
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        g gVar = (g) it5.next();
                        FeedDefaultItemAnimator.this.animateMoveImpl(gVar.f218776a, gVar.f218777b, gVar.f218778c, gVar.f218779d, gVar.f218780e);
                    }
                    arrayList.clear();
                    FeedDefaultItemAnimator.this.f218738f.remove(arrayList);
                }
            };
            if (!this.f218744l && z16) {
                ViewCompat.postOnAnimationDelayed(arrayList.get(0).f218776a.itemView, runnable, getRemoveDuration());
            } else {
                runnable.run();
            }
        }
        if (z18) {
            final ArrayList<f> arrayList2 = new ArrayList<>();
            arrayList2.addAll(this.f218736d);
            this.f218739g.add(arrayList2);
            this.f218736d.clear();
            Runnable runnable2 = new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.animator.FeedDefaultItemAnimator.2
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it5 = arrayList2.iterator();
                    while (it5.hasNext()) {
                        FeedDefaultItemAnimator.this.c((f) it5.next());
                    }
                    arrayList2.clear();
                    FeedDefaultItemAnimator.this.f218739g.remove(arrayList2);
                }
            };
            if (!this.f218744l && z16) {
                ViewCompat.postOnAnimationDelayed(arrayList2.get(0).f218770a.itemView, runnable2, getRemoveDuration());
            } else {
                runnable2.run();
            }
        }
        if (z19) {
            final ArrayList<RecyclerView.ViewHolder> arrayList3 = new ArrayList<>();
            arrayList3.addAll(this.f218734b);
            this.f218737e.add(arrayList3);
            this.f218734b.clear();
            Runnable runnable3 = new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.animator.FeedDefaultItemAnimator.3
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it5 = arrayList3.iterator();
                    while (it5.hasNext()) {
                        FeedDefaultItemAnimator.this.animateAddImpl((RecyclerView.ViewHolder) it5.next());
                    }
                    arrayList3.clear();
                    FeedDefaultItemAnimator.this.f218737e.remove(arrayList3);
                }
            };
            if (!this.f218744l && (z16 || z17 || z18)) {
                long j17 = 0;
                if (z16) {
                    j3 = getRemoveDuration();
                } else {
                    j3 = 0;
                }
                if (z17) {
                    j16 = getMoveDuration();
                } else {
                    j16 = 0;
                }
                if (z18) {
                    j17 = getChangeDuration();
                }
                ViewCompat.postOnAnimationDelayed(arrayList3.get(0).itemView, runnable3, j3 + Math.max(j16, j17));
                return;
            }
            runnable3.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.ViewHolder f218770a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView.ViewHolder f218771b;

        /* renamed from: c, reason: collision with root package name */
        public int f218772c;

        /* renamed from: d, reason: collision with root package name */
        public int f218773d;

        /* renamed from: e, reason: collision with root package name */
        public int f218774e;

        /* renamed from: f, reason: collision with root package name */
        public int f218775f;

        f(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            this.f218770a = viewHolder;
            this.f218771b = viewHolder2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f218770a + ", newHolder=" + this.f218771b + ", fromX=" + this.f218772c + ", fromY=" + this.f218773d + ", toX=" + this.f218774e + ", toY=" + this.f218775f + '}';
        }

        f(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i3, int i16, int i17, int i18) {
            this(viewHolder, viewHolder2);
            this.f218772c = i3;
            this.f218773d = i16;
            this.f218774e = i17;
            this.f218775f = i18;
        }
    }
}
