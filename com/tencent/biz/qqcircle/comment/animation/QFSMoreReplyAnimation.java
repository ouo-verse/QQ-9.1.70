package com.tencent.biz.qqcircle.comment.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMoreReplyAnimation extends SimpleItemAnimator {

    /* renamed from: l, reason: collision with root package name */
    private static TimeInterpolator f83422l;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<RecyclerView.ViewHolder> f83423a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<RecyclerView.ViewHolder> f83424b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<g> f83425c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<f> f83426d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    ArrayList<ArrayList<RecyclerView.ViewHolder>> f83427e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    ArrayList<ArrayList<g>> f83428f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    ArrayList<ArrayList<f>> f83429g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    ArrayList<RecyclerView.ViewHolder> f83430h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    ArrayList<RecyclerView.ViewHolder> f83431i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    ArrayList<RecyclerView.ViewHolder> f83432j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    ArrayList<RecyclerView.ViewHolder> f83433k = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f83437d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f83438e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f83439f;

        a(RecyclerView.ViewHolder viewHolder, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f83437d = viewHolder;
            this.f83438e = viewPropertyAnimator;
            this.f83439f = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f83438e.setListener(null);
            this.f83439f.setAlpha(1.0f);
            QFSMoreReplyAnimation.this.dispatchRemoveFinished(this.f83437d);
            QFSMoreReplyAnimation.this.f83432j.remove(this.f83437d);
            QFSMoreReplyAnimation.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QFSMoreReplyAnimation.this.dispatchRemoveStarting(this.f83437d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f83441d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f83442e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f83443f;

        b(RecyclerView.ViewHolder viewHolder, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f83441d = viewHolder;
            this.f83442e = view;
            this.f83443f = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f83442e.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f83443f.setListener(null);
            try {
                try {
                    QFSMoreReplyAnimation.this.dispatchAddFinished(this.f83441d);
                } catch (Exception e16) {
                    RFWLog.e("QFSMoreReplyAnimation", RFWLog.USR, "[animateAddImpl] " + e16);
                }
            } finally {
                QFSMoreReplyAnimation.this.f83430h.remove(this.f83441d);
                QFSMoreReplyAnimation.this.dispatchFinishedWhenDone();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QFSMoreReplyAnimation.this.dispatchAddStarting(this.f83441d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f83445d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f83446e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f83447f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f83448h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f83449i;

        c(RecyclerView.ViewHolder viewHolder, int i3, View view, int i16, ViewPropertyAnimator viewPropertyAnimator) {
            this.f83445d = viewHolder;
            this.f83446e = i3;
            this.f83447f = view;
            this.f83448h = i16;
            this.f83449i = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f83446e != 0) {
                this.f83447f.setTranslationX(0.0f);
            }
            if (this.f83448h != 0) {
                this.f83447f.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f83449i.setListener(null);
            QFSMoreReplyAnimation.this.dispatchMoveFinished(this.f83445d);
            QFSMoreReplyAnimation.this.f83431i.remove(this.f83445d);
            QFSMoreReplyAnimation.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QFSMoreReplyAnimation.this.dispatchMoveStarting(this.f83445d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f83451d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f83452e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f83453f;

        d(f fVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f83451d = fVar;
            this.f83452e = viewPropertyAnimator;
            this.f83453f = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f83452e.setListener(null);
            this.f83453f.setAlpha(1.0f);
            this.f83453f.setTranslationX(0.0f);
            this.f83453f.setTranslationY(0.0f);
            QFSMoreReplyAnimation.this.dispatchChangeFinished(this.f83451d.f83459a, true);
            QFSMoreReplyAnimation.this.f83433k.remove(this.f83451d.f83459a);
            QFSMoreReplyAnimation.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QFSMoreReplyAnimation.this.dispatchChangeStarting(this.f83451d.f83459a, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f83455d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f83456e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f83457f;

        e(f fVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f83455d = fVar;
            this.f83456e = viewPropertyAnimator;
            this.f83457f = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f83456e.setListener(null);
            this.f83457f.setAlpha(1.0f);
            this.f83457f.setTranslationX(0.0f);
            this.f83457f.setTranslationY(0.0f);
            QFSMoreReplyAnimation.this.dispatchChangeFinished(this.f83455d.f83460b, false);
            QFSMoreReplyAnimation.this.f83433k.remove(this.f83455d.f83460b);
            QFSMoreReplyAnimation.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QFSMoreReplyAnimation.this.dispatchChangeStarting(this.f83455d.f83460b, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.ViewHolder f83465a;

        /* renamed from: b, reason: collision with root package name */
        public int f83466b;

        /* renamed from: c, reason: collision with root package name */
        public int f83467c;

        /* renamed from: d, reason: collision with root package name */
        public int f83468d;

        /* renamed from: e, reason: collision with root package name */
        public int f83469e;

        g(RecyclerView.ViewHolder viewHolder, int i3, int i16, int i17, int i18) {
            this.f83465a = viewHolder;
            this.f83466b = i3;
            this.f83467c = i16;
            this.f83468d = i17;
            this.f83469e = i18;
        }
    }

    private void animateRemoveImpl(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.f83432j.add(viewHolder);
        animate.setDuration(320L).alpha(0.0f).setInterpolator(new LinearInterpolator()).setListener(new a(viewHolder, animate, view)).start();
    }

    private void b(f fVar) {
        RecyclerView.ViewHolder viewHolder = fVar.f83459a;
        if (viewHolder != null) {
            c(fVar, viewHolder);
        }
        RecyclerView.ViewHolder viewHolder2 = fVar.f83460b;
        if (viewHolder2 != null) {
            c(fVar, viewHolder2);
        }
    }

    private boolean c(f fVar, RecyclerView.ViewHolder viewHolder) {
        boolean z16 = false;
        if (fVar.f83460b == viewHolder) {
            fVar.f83460b = null;
        } else {
            if (fVar.f83459a != viewHolder) {
                return false;
            }
            fVar.f83459a = null;
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
            if (c(fVar, viewHolder) && fVar.f83459a == null && fVar.f83460b == null) {
                list.remove(fVar);
            }
        }
    }

    private void resetAnimation(RecyclerView.ViewHolder viewHolder) {
        if (f83422l == null) {
            f83422l = new ValueAnimator().getInterpolator();
        }
        viewHolder.itemView.animate().setInterpolator(f83422l);
        endAnimation(viewHolder);
    }

    void a(f fVar) {
        View view;
        RecyclerView.ViewHolder viewHolder = fVar.f83459a;
        View view2 = null;
        if (viewHolder == null) {
            view = null;
        } else {
            view = viewHolder.itemView;
        }
        RecyclerView.ViewHolder viewHolder2 = fVar.f83460b;
        if (viewHolder2 != null) {
            view2 = viewHolder2.itemView;
        }
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(getChangeDuration());
            this.f83433k.add(fVar.f83459a);
            duration.translationX(fVar.f83463e - fVar.f83461c);
            duration.translationY(fVar.f83464f - fVar.f83462d);
            duration.alpha(0.0f).setListener(new d(fVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.f83433k.add(fVar.f83460b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new e(fVar, animate, view2)).start();
        }
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateAdd(RecyclerView.ViewHolder viewHolder) {
        resetAnimation(viewHolder);
        viewHolder.itemView.setAlpha(0.0f);
        this.f83424b.add(viewHolder);
        return true;
    }

    void animateAddImpl(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.f83430h.add(viewHolder);
        animate.alpha(1.0f).setDuration(getAddDuration()).setInterpolator(new LinearInterpolator()).setListener(new b(viewHolder, view, animate)).start();
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
        this.f83426d.add(new f(viewHolder, viewHolder2, i3, i16, i17, i18));
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
        this.f83425c.add(new g(viewHolder, translationX, translationY, i17, i18));
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
        this.f83431i.add(viewHolder);
        animate.setDuration(getMoveDuration()).setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new c(viewHolder, i19, view, i26, animate)).start();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateRemove(RecyclerView.ViewHolder viewHolder) {
        resetAnimation(viewHolder);
        this.f83423a.add(viewHolder);
        return true;
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

    public void d() {
        long j3;
        long j16;
        boolean z16 = !this.f83423a.isEmpty();
        boolean z17 = !this.f83425c.isEmpty();
        boolean z18 = !this.f83426d.isEmpty();
        boolean z19 = !this.f83424b.isEmpty();
        if (!z16 && !z17 && !z19 && !z18) {
            return;
        }
        Iterator<RecyclerView.ViewHolder> it = this.f83423a.iterator();
        while (it.hasNext()) {
            animateRemoveImpl(it.next());
        }
        this.f83423a.clear();
        if (z17) {
            final ArrayList<g> arrayList = new ArrayList<>();
            arrayList.addAll(this.f83425c);
            this.f83428f.add(arrayList);
            this.f83425c.clear();
            Runnable runnable = new Runnable() { // from class: com.tencent.biz.qqcircle.comment.animation.QFSMoreReplyAnimation.1
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        g gVar = (g) it5.next();
                        QFSMoreReplyAnimation.this.animateMoveImpl(gVar.f83465a, gVar.f83466b, gVar.f83467c, gVar.f83468d, gVar.f83469e);
                    }
                    arrayList.clear();
                    QFSMoreReplyAnimation.this.f83428f.remove(arrayList);
                }
            };
            if (z16) {
                ViewCompat.postOnAnimationDelayed(arrayList.get(0).f83465a.itemView, runnable, getRemoveDuration());
            } else {
                runnable.run();
            }
        }
        if (z18) {
            final ArrayList<f> arrayList2 = new ArrayList<>();
            arrayList2.addAll(this.f83426d);
            this.f83429g.add(arrayList2);
            this.f83426d.clear();
            Runnable runnable2 = new Runnable() { // from class: com.tencent.biz.qqcircle.comment.animation.QFSMoreReplyAnimation.2
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it5 = arrayList2.iterator();
                    while (it5.hasNext()) {
                        QFSMoreReplyAnimation.this.a((f) it5.next());
                    }
                    arrayList2.clear();
                    QFSMoreReplyAnimation.this.f83429g.remove(arrayList2);
                }
            };
            if (z16) {
                ViewCompat.postOnAnimationDelayed(arrayList2.get(0).f83459a.itemView, runnable2, getRemoveDuration());
            } else {
                runnable2.run();
            }
        }
        if (z19) {
            final ArrayList<RecyclerView.ViewHolder> arrayList3 = new ArrayList<>();
            arrayList3.addAll(this.f83424b);
            this.f83427e.add(arrayList3);
            this.f83424b.clear();
            Runnable runnable3 = new Runnable() { // from class: com.tencent.biz.qqcircle.comment.animation.QFSMoreReplyAnimation.3
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it5 = arrayList3.iterator();
                    while (it5.hasNext()) {
                        QFSMoreReplyAnimation.this.animateAddImpl((RecyclerView.ViewHolder) it5.next());
                    }
                    arrayList3.clear();
                    QFSMoreReplyAnimation.this.f83427e.remove(arrayList3);
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

    void dispatchFinishedWhenDone() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimation(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        view.animate().cancel();
        int size = this.f83425c.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.f83425c.get(size).f83465a == viewHolder) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                dispatchMoveFinished(viewHolder);
                this.f83425c.remove(size);
            }
        }
        endChangeAnimation(this.f83426d, viewHolder);
        if (this.f83423a.remove(viewHolder)) {
            view.setAlpha(1.0f);
            dispatchRemoveFinished(viewHolder);
        }
        if (this.f83424b.remove(viewHolder)) {
            view.setAlpha(1.0f);
            dispatchAddFinished(viewHolder);
        }
        for (int size2 = this.f83429g.size() - 1; size2 >= 0; size2--) {
            ArrayList<f> arrayList = this.f83429g.get(size2);
            endChangeAnimation(arrayList, viewHolder);
            if (arrayList.isEmpty()) {
                this.f83429g.remove(size2);
            }
        }
        for (int size3 = this.f83428f.size() - 1; size3 >= 0; size3--) {
            ArrayList<g> arrayList2 = this.f83428f.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).f83465a == viewHolder) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    dispatchMoveFinished(viewHolder);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f83428f.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f83427e.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.ViewHolder> arrayList3 = this.f83427e.get(size5);
            if (arrayList3.remove(viewHolder)) {
                view.setAlpha(1.0f);
                dispatchAddFinished(viewHolder);
                if (arrayList3.isEmpty()) {
                    this.f83427e.remove(size5);
                }
            }
        }
        this.f83432j.remove(viewHolder);
        this.f83430h.remove(viewHolder);
        this.f83433k.remove(viewHolder);
        this.f83431i.remove(viewHolder);
        dispatchFinishedWhenDone();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimations() {
        int size = this.f83425c.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            g gVar = this.f83425c.get(size);
            View view = gVar.f83465a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            dispatchMoveFinished(gVar.f83465a);
            this.f83425c.remove(size);
        }
        for (int size2 = this.f83423a.size() - 1; size2 >= 0; size2--) {
            dispatchRemoveFinished(this.f83423a.get(size2));
            this.f83423a.remove(size2);
        }
        int size3 = this.f83424b.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.ViewHolder viewHolder = this.f83424b.get(size3);
            viewHolder.itemView.setAlpha(1.0f);
            dispatchAddFinished(viewHolder);
            this.f83424b.remove(size3);
        }
        for (int size4 = this.f83426d.size() - 1; size4 >= 0; size4--) {
            b(this.f83426d.get(size4));
        }
        this.f83426d.clear();
        if (!isRunning()) {
            return;
        }
        for (int size5 = this.f83428f.size() - 1; size5 >= 0; size5--) {
            ArrayList<g> arrayList = this.f83428f.get(size5);
            for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                g gVar2 = arrayList.get(size6);
                View view2 = gVar2.f83465a.itemView;
                view2.setTranslationY(0.0f);
                view2.setTranslationX(0.0f);
                dispatchMoveFinished(gVar2.f83465a);
                arrayList.remove(size6);
                if (arrayList.isEmpty()) {
                    this.f83428f.remove(arrayList);
                }
            }
        }
        for (int size7 = this.f83427e.size() - 1; size7 >= 0; size7--) {
            ArrayList<RecyclerView.ViewHolder> arrayList2 = this.f83427e.get(size7);
            for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                RecyclerView.ViewHolder viewHolder2 = arrayList2.get(size8);
                viewHolder2.itemView.setAlpha(1.0f);
                dispatchAddFinished(viewHolder2);
                arrayList2.remove(size8);
                if (arrayList2.isEmpty()) {
                    this.f83427e.remove(arrayList2);
                }
            }
        }
        for (int size9 = this.f83429g.size() - 1; size9 >= 0; size9--) {
            ArrayList<f> arrayList3 = this.f83429g.get(size9);
            for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                b(arrayList3.get(size10));
                if (arrayList3.isEmpty()) {
                    this.f83429g.remove(arrayList3);
                }
            }
        }
        cancelAll(this.f83432j);
        cancelAll(this.f83431i);
        cancelAll(this.f83430h);
        cancelAll(this.f83433k);
        dispatchAnimationsFinished();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean isRunning() {
        if (this.f83424b.isEmpty() && this.f83426d.isEmpty() && this.f83425c.isEmpty() && this.f83423a.isEmpty() && this.f83431i.isEmpty() && this.f83432j.isEmpty() && this.f83430h.isEmpty() && this.f83433k.isEmpty() && this.f83428f.isEmpty() && this.f83427e.isEmpty() && this.f83429g.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        try {
            d();
        } catch (Exception e16) {
            RFWLog.e("QFSMoreReplyAnimation", RFWLog.USR, "[runPendingAnimations] exception: ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.ViewHolder f83459a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView.ViewHolder f83460b;

        /* renamed from: c, reason: collision with root package name */
        public int f83461c;

        /* renamed from: d, reason: collision with root package name */
        public int f83462d;

        /* renamed from: e, reason: collision with root package name */
        public int f83463e;

        /* renamed from: f, reason: collision with root package name */
        public int f83464f;

        f(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            this.f83459a = viewHolder;
            this.f83460b = viewHolder2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f83459a + ", newHolder=" + this.f83460b + ", fromX=" + this.f83461c + ", fromY=" + this.f83462d + ", toX=" + this.f83463e + ", toY=" + this.f83464f + '}';
        }

        f(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i3, int i16, int i17, int i18) {
            this(viewHolder, viewHolder2);
            this.f83461c = i3;
            this.f83462d = i16;
            this.f83463e = i17;
            this.f83464f = i18;
        }
    }
}
