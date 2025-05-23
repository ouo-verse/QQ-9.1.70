package com.tencent.qqnt.chats.core.anim;

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
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes24.dex */
public class DefaultItemAnimator extends SimpleItemAnimator {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name */
    private static TimeInterpolator f354655l;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<RecyclerView.ViewHolder> f354656a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<RecyclerView.ViewHolder> f354657b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<g> f354658c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<f> f354659d;

    /* renamed from: e, reason: collision with root package name */
    ArrayList<ArrayList<RecyclerView.ViewHolder>> f354660e;

    /* renamed from: f, reason: collision with root package name */
    ArrayList<ArrayList<g>> f354661f;

    /* renamed from: g, reason: collision with root package name */
    ArrayList<ArrayList<f>> f354662g;

    /* renamed from: h, reason: collision with root package name */
    ArrayList<RecyclerView.ViewHolder> f354663h;

    /* renamed from: i, reason: collision with root package name */
    ArrayList<RecyclerView.ViewHolder> f354664i;

    /* renamed from: j, reason: collision with root package name */
    ArrayList<RecyclerView.ViewHolder> f354665j;

    /* renamed from: k, reason: collision with root package name */
    ArrayList<RecyclerView.ViewHolder> f354666k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes24.dex */
    public class a extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f354670d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f354671e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f354672f;

        a(RecyclerView.ViewHolder viewHolder, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f354670d = viewHolder;
            this.f354671e = viewPropertyAnimator;
            this.f354672f = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, DefaultItemAnimator.this, viewHolder, viewPropertyAnimator, view);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            this.f354671e.setListener(null);
            this.f354672f.setAlpha(1.0f);
            DefaultItemAnimator.this.dispatchRemoveFinished(this.f354670d);
            DefaultItemAnimator.this.f354665j.remove(this.f354670d);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else {
                DefaultItemAnimator.this.dispatchRemoveStarting(this.f354670d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes24.dex */
    public class b extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f354674d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f354675e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f354676f;

        b(RecyclerView.ViewHolder viewHolder, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f354674d = viewHolder;
            this.f354675e = view;
            this.f354676f = viewPropertyAnimator;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, DefaultItemAnimator.this, viewHolder, view, viewPropertyAnimator);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
            } else {
                this.f354675e.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
                return;
            }
            this.f354676f.setListener(null);
            DefaultItemAnimator.this.dispatchAddFinished(this.f354674d);
            DefaultItemAnimator.this.f354663h.remove(this.f354674d);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else {
                DefaultItemAnimator.this.dispatchAddStarting(this.f354674d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes24.dex */
    public class c extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f354678d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f354679e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f354680f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f354681h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f354682i;

        c(RecyclerView.ViewHolder viewHolder, int i3, View view, int i16, ViewPropertyAnimator viewPropertyAnimator) {
            this.f354678d = viewHolder;
            this.f354679e = i3;
            this.f354680f = view;
            this.f354681h = i16;
            this.f354682i = viewPropertyAnimator;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, DefaultItemAnimator.this, viewHolder, Integer.valueOf(i3), view, Integer.valueOf(i16), viewPropertyAnimator);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            if (this.f354679e != 0) {
                this.f354680f.setTranslationX(0.0f);
            }
            if (this.f354681h != 0) {
                this.f354680f.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
                return;
            }
            this.f354682i.setListener(null);
            DefaultItemAnimator.this.dispatchMoveFinished(this.f354678d);
            DefaultItemAnimator.this.f354664i.remove(this.f354678d);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else {
                DefaultItemAnimator.this.dispatchMoveStarting(this.f354678d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes24.dex */
    public class d extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f354684d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f354685e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f354686f;

        d(f fVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f354684d = fVar;
            this.f354685e = viewPropertyAnimator;
            this.f354686f = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, DefaultItemAnimator.this, fVar, viewPropertyAnimator, view);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            this.f354685e.setListener(null);
            this.f354686f.setAlpha(1.0f);
            this.f354686f.setTranslationX(0.0f);
            this.f354686f.setTranslationY(0.0f);
            DefaultItemAnimator.this.dispatchChangeFinished(this.f354684d.f354692a, true);
            DefaultItemAnimator.this.f354666k.remove(this.f354684d.f354692a);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else {
                DefaultItemAnimator.this.dispatchChangeStarting(this.f354684d.f354692a, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes24.dex */
    public class e extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f354688d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f354689e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f354690f;

        e(f fVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f354688d = fVar;
            this.f354689e = viewPropertyAnimator;
            this.f354690f = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, DefaultItemAnimator.this, fVar, viewPropertyAnimator, view);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            this.f354689e.setListener(null);
            this.f354690f.setAlpha(1.0f);
            this.f354690f.setTranslationX(0.0f);
            this.f354690f.setTranslationY(0.0f);
            DefaultItemAnimator.this.dispatchChangeFinished(this.f354688d.f354693b, false);
            DefaultItemAnimator.this.f354666k.remove(this.f354688d.f354693b);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else {
                DefaultItemAnimator.this.dispatchChangeStarting(this.f354688d.f354693b, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static class g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.ViewHolder f354698a;

        /* renamed from: b, reason: collision with root package name */
        public int f354699b;

        /* renamed from: c, reason: collision with root package name */
        public int f354700c;

        /* renamed from: d, reason: collision with root package name */
        public int f354701d;

        /* renamed from: e, reason: collision with root package name */
        public int f354702e;

        g(RecyclerView.ViewHolder viewHolder, int i3, int i16, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, viewHolder, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                return;
            }
            this.f354698a = viewHolder;
            this.f354699b = i3;
            this.f354700c = i16;
            this.f354701d = i17;
            this.f354702e = i18;
        }
    }

    public DefaultItemAnimator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f354656a = new ArrayList<>();
        this.f354657b = new ArrayList<>();
        this.f354658c = new ArrayList<>();
        this.f354659d = new ArrayList<>();
        this.f354660e = new ArrayList<>();
        this.f354661f = new ArrayList<>();
        this.f354662g = new ArrayList<>();
        this.f354663h = new ArrayList<>();
        this.f354664i = new ArrayList<>();
        this.f354665j = new ArrayList<>();
        this.f354666k = new ArrayList<>();
    }

    private void animateRemoveImpl(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.f354665j.add(viewHolder);
        animate.setDuration(getRemoveDuration()).alpha(0.0f).setListener(new a(viewHolder, animate, view)).start();
    }

    private void b(f fVar) {
        RecyclerView.ViewHolder viewHolder = fVar.f354692a;
        if (viewHolder != null) {
            c(fVar, viewHolder);
        }
        RecyclerView.ViewHolder viewHolder2 = fVar.f354693b;
        if (viewHolder2 != null) {
            c(fVar, viewHolder2);
        }
    }

    private boolean c(f fVar, RecyclerView.ViewHolder viewHolder) {
        boolean z16 = false;
        if (fVar.f354693b == viewHolder) {
            fVar.f354693b = null;
        } else {
            if (fVar.f354692a != viewHolder) {
                return false;
            }
            fVar.f354692a = null;
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
            if (c(fVar, viewHolder) && fVar.f354692a == null && fVar.f354693b == null) {
                list.remove(fVar);
            }
        }
    }

    private void resetAnimation(RecyclerView.ViewHolder viewHolder) {
        if (f354655l == null) {
            f354655l = new ValueAnimator().getInterpolator();
        }
        viewHolder.itemView.animate().setInterpolator(f354655l);
        endAnimation(viewHolder);
    }

    void a(f fVar) {
        View view;
        RecyclerView.ViewHolder viewHolder = fVar.f354692a;
        View view2 = null;
        if (viewHolder == null) {
            view = null;
        } else {
            view = viewHolder.itemView;
        }
        RecyclerView.ViewHolder viewHolder2 = fVar.f354693b;
        if (viewHolder2 != null) {
            view2 = viewHolder2.itemView;
        }
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(getChangeDuration());
            this.f354666k.add(fVar.f354692a);
            duration.translationX(fVar.f354696e - fVar.f354694c);
            duration.translationY(fVar.f354697f - fVar.f354695d);
            duration.alpha(0.0f).setListener(new d(fVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.f354666k.add(fVar.f354693b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new e(fVar, animate, view2)).start();
        }
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateAdd(RecyclerView.ViewHolder viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewHolder)).booleanValue();
        }
        resetAnimation(viewHolder);
        viewHolder.itemView.setAlpha(0.0f);
        this.f354657b.add(viewHolder);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void animateAddImpl(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.f354663h.add(viewHolder);
        animate.alpha(1.0f).setDuration(getAddDuration()).setListener(new b(viewHolder, view, animate)).start();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, viewHolder, viewHolder2, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18))).booleanValue();
        }
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
        this.f354659d.add(new f(viewHolder, viewHolder2, i3, i16, i17, i18));
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateMove(RecyclerView.ViewHolder viewHolder, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, viewHolder, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18))).booleanValue();
        }
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
        this.f354658c.add(new g(viewHolder, translationX, translationY, i17, i18));
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
        this.f354664i.add(viewHolder);
        animate.setDuration(getMoveDuration()).setListener(new c(viewHolder, i19, view, i26, animate)).start();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateRemove(RecyclerView.ViewHolder viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewHolder)).booleanValue();
        }
        resetAnimation(viewHolder);
        this.f354656a.add(viewHolder);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<Object> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) viewHolder, (Object) list)).booleanValue();
        }
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchFinishedWhenDone() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimation(RecyclerView.ViewHolder viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) viewHolder);
            return;
        }
        View view = viewHolder.itemView;
        view.animate().cancel();
        int size = this.f354658c.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.f354658c.get(size).f354698a == viewHolder) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                dispatchMoveFinished(viewHolder);
                this.f354658c.remove(size);
            }
        }
        endChangeAnimation(this.f354659d, viewHolder);
        if (this.f354656a.remove(viewHolder)) {
            view.setAlpha(1.0f);
            dispatchRemoveFinished(viewHolder);
        }
        if (this.f354657b.remove(viewHolder)) {
            view.setAlpha(1.0f);
            dispatchAddFinished(viewHolder);
        }
        for (int size2 = this.f354662g.size() - 1; size2 >= 0; size2--) {
            ArrayList<f> arrayList = this.f354662g.get(size2);
            endChangeAnimation(arrayList, viewHolder);
            if (arrayList.isEmpty()) {
                this.f354662g.remove(size2);
            }
        }
        for (int size3 = this.f354661f.size() - 1; size3 >= 0; size3--) {
            ArrayList<g> arrayList2 = this.f354661f.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).f354698a == viewHolder) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    dispatchMoveFinished(viewHolder);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f354661f.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f354660e.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.ViewHolder> arrayList3 = this.f354660e.get(size5);
            if (arrayList3.remove(viewHolder)) {
                view.setAlpha(1.0f);
                dispatchAddFinished(viewHolder);
                if (arrayList3.isEmpty()) {
                    this.f354660e.remove(size5);
                }
            }
        }
        this.f354665j.remove(viewHolder);
        this.f354663h.remove(viewHolder);
        this.f354666k.remove(viewHolder);
        this.f354664i.remove(viewHolder);
        dispatchFinishedWhenDone();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimations() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        int size = this.f354658c.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            g gVar = this.f354658c.get(size);
            View view = gVar.f354698a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            dispatchMoveFinished(gVar.f354698a);
            this.f354658c.remove(size);
        }
        for (int size2 = this.f354656a.size() - 1; size2 >= 0; size2--) {
            dispatchRemoveFinished(this.f354656a.get(size2));
            this.f354656a.remove(size2);
        }
        int size3 = this.f354657b.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.ViewHolder viewHolder = this.f354657b.get(size3);
            viewHolder.itemView.setAlpha(1.0f);
            dispatchAddFinished(viewHolder);
            this.f354657b.remove(size3);
        }
        for (int size4 = this.f354659d.size() - 1; size4 >= 0; size4--) {
            b(this.f354659d.get(size4));
        }
        this.f354659d.clear();
        if (!isRunning()) {
            return;
        }
        for (int size5 = this.f354661f.size() - 1; size5 >= 0; size5--) {
            ArrayList<g> arrayList = this.f354661f.get(size5);
            for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                g gVar2 = arrayList.get(size6);
                View view2 = gVar2.f354698a.itemView;
                view2.setTranslationY(0.0f);
                view2.setTranslationX(0.0f);
                dispatchMoveFinished(gVar2.f354698a);
                arrayList.remove(size6);
                if (arrayList.isEmpty()) {
                    this.f354661f.remove(arrayList);
                }
            }
        }
        for (int size7 = this.f354660e.size() - 1; size7 >= 0; size7--) {
            ArrayList<RecyclerView.ViewHolder> arrayList2 = this.f354660e.get(size7);
            for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                RecyclerView.ViewHolder viewHolder2 = arrayList2.get(size8);
                viewHolder2.itemView.setAlpha(1.0f);
                dispatchAddFinished(viewHolder2);
                arrayList2.remove(size8);
                if (arrayList2.isEmpty()) {
                    this.f354660e.remove(arrayList2);
                }
            }
        }
        for (int size9 = this.f354662g.size() - 1; size9 >= 0; size9--) {
            ArrayList<f> arrayList3 = this.f354662g.get(size9);
            for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                b(arrayList3.get(size10));
                if (arrayList3.isEmpty()) {
                    this.f354662g.remove(arrayList3);
                }
            }
        }
        cancelAll(this.f354665j);
        cancelAll(this.f354664i);
        cancelAll(this.f354663h);
        cancelAll(this.f354666k);
        dispatchAnimationsFinished();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean isRunning() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (this.f354657b.isEmpty() && this.f354659d.isEmpty() && this.f354658c.isEmpty() && this.f354656a.isEmpty() && this.f354664i.isEmpty() && this.f354665j.isEmpty() && this.f354663h.isEmpty() && this.f354666k.isEmpty() && this.f354661f.isEmpty() && this.f354660e.isEmpty() && this.f354662g.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        long j3;
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        boolean z16 = !this.f354656a.isEmpty();
        boolean z17 = !this.f354658c.isEmpty();
        boolean z18 = !this.f354659d.isEmpty();
        boolean z19 = !this.f354657b.isEmpty();
        if (!z16 && !z17 && !z19 && !z18) {
            return;
        }
        Iterator<RecyclerView.ViewHolder> it = this.f354656a.iterator();
        while (it.hasNext()) {
            animateRemoveImpl(it.next());
        }
        this.f354656a.clear();
        if (z17) {
            ArrayList<g> arrayList = new ArrayList<>();
            arrayList.addAll(this.f354658c);
            this.f354661f.add(arrayList);
            this.f354658c.clear();
            Runnable runnable = new Runnable(arrayList) { // from class: com.tencent.qqnt.chats.core.anim.DefaultItemAnimator.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ArrayList f354667d;

                {
                    this.f354667d = arrayList;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DefaultItemAnimator.this, (Object) arrayList);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Iterator it5 = this.f354667d.iterator();
                    while (it5.hasNext()) {
                        g gVar = (g) it5.next();
                        DefaultItemAnimator.this.animateMoveImpl(gVar.f354698a, gVar.f354699b, gVar.f354700c, gVar.f354701d, gVar.f354702e);
                    }
                    this.f354667d.clear();
                    DefaultItemAnimator.this.f354661f.remove(this.f354667d);
                }
            };
            if (z16) {
                ViewCompat.postOnAnimationDelayed(arrayList.get(0).f354698a.itemView, runnable, getRemoveDuration());
            } else {
                runnable.run();
            }
        }
        if (z18) {
            ArrayList<f> arrayList2 = new ArrayList<>();
            arrayList2.addAll(this.f354659d);
            this.f354662g.add(arrayList2);
            this.f354659d.clear();
            Runnable runnable2 = new Runnable(arrayList2) { // from class: com.tencent.qqnt.chats.core.anim.DefaultItemAnimator.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ArrayList f354668d;

                {
                    this.f354668d = arrayList2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DefaultItemAnimator.this, (Object) arrayList2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Iterator it5 = this.f354668d.iterator();
                    while (it5.hasNext()) {
                        DefaultItemAnimator.this.a((f) it5.next());
                    }
                    this.f354668d.clear();
                    DefaultItemAnimator.this.f354662g.remove(this.f354668d);
                }
            };
            if (z16) {
                ViewCompat.postOnAnimationDelayed(arrayList2.get(0).f354692a.itemView, runnable2, getRemoveDuration());
            } else {
                runnable2.run();
            }
        }
        if (z19) {
            ArrayList<RecyclerView.ViewHolder> arrayList3 = new ArrayList<>();
            arrayList3.addAll(this.f354657b);
            this.f354660e.add(arrayList3);
            this.f354657b.clear();
            Runnable runnable3 = new Runnable(arrayList3) { // from class: com.tencent.qqnt.chats.core.anim.DefaultItemAnimator.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ArrayList f354669d;

                {
                    this.f354669d = arrayList3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DefaultItemAnimator.this, (Object) arrayList3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Iterator it5 = this.f354669d.iterator();
                    while (it5.hasNext()) {
                        DefaultItemAnimator.this.animateAddImpl((RecyclerView.ViewHolder) it5.next());
                    }
                    this.f354669d.clear();
                    DefaultItemAnimator.this.f354660e.remove(this.f354669d);
                }
            };
            if (!z16 && !z17 && !z18) {
                runnable3.run();
                return;
            }
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
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static class f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.ViewHolder f354692a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView.ViewHolder f354693b;

        /* renamed from: c, reason: collision with root package name */
        public int f354694c;

        /* renamed from: d, reason: collision with root package name */
        public int f354695d;

        /* renamed from: e, reason: collision with root package name */
        public int f354696e;

        /* renamed from: f, reason: collision with root package name */
        public int f354697f;

        f(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) viewHolder, (Object) viewHolder2);
            } else {
                this.f354692a = viewHolder;
                this.f354693b = viewHolder2;
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "ChangeInfo{oldHolder=" + this.f354692a + ", newHolder=" + this.f354693b + ", fromX=" + this.f354694c + ", fromY=" + this.f354695d + ", toX=" + this.f354696e + ", toY=" + this.f354697f + '}';
        }

        f(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i3, int i16, int i17, int i18) {
            this(viewHolder, viewHolder2);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, viewHolder, viewHolder2, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                return;
            }
            this.f354694c = i3;
            this.f354695d = i16;
            this.f354696e = i17;
            this.f354697f = i18;
        }
    }
}
