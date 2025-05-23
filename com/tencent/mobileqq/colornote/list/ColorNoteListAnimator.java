package com.tencent.mobileqq.colornote.list;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ColorNoteListAnimator {

    /* renamed from: i, reason: collision with root package name */
    private static TimeInterpolator f201414i;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<View> f201415a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<c> f201416b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    ArrayList<ArrayList<c>> f201417c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    ArrayList<View> f201418d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    ArrayList<View> f201419e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private int f201420f = 300;

    /* renamed from: g, reason: collision with root package name */
    private int f201421g = 300;

    /* renamed from: h, reason: collision with root package name */
    private d f201422h = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public View f201434a;

        /* renamed from: b, reason: collision with root package name */
        public int f201435b;

        /* renamed from: c, reason: collision with root package name */
        public int f201436c;

        /* renamed from: d, reason: collision with root package name */
        public int f201437d;

        /* renamed from: e, reason: collision with root package name */
        public int f201438e;

        c(View view, int i3, int i16, int i17, int i18) {
            this.f201434a = view;
            this.f201435b = i3;
            this.f201436c = i16;
            this.f201437d = i17;
            this.f201438e = i18;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface d {
        void onAnimationFinished();
    }

    private void d(View view) {
        ViewPropertyAnimator animate = view.animate();
        this.f201419e.add(view);
        animate.setDuration(this.f201420f).alpha(0.0f).translationX(view.getWidth()).setListener(new a(view, animate, view)).start();
    }

    private void e() {
        d dVar = this.f201422h;
        if (dVar != null) {
            dVar.onAnimationFinished();
        }
    }

    private void i(View view) {
        if (f201414i == null) {
            f201414i = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(f201414i);
        g(view, true);
    }

    public boolean a(View view, int i3, int i16, int i17, int i18) {
        int translationX = i3 + ((int) view.getTranslationX());
        int translationY = i16 + ((int) view.getTranslationY());
        i(view);
        int i19 = i18 - translationY;
        if (i17 - translationX == 0 && i19 == 0) {
            return false;
        }
        this.f201416b.add(new c(view, translationX, translationY, i17, i18));
        return true;
    }

    void b(View view, int i3, int i16, int i17, int i18) {
        int i19 = i17 - i3;
        int i26 = i18 - i16;
        if (i19 != 0) {
            view.animate().x(i17);
        }
        if (i26 != 0) {
            view.animate().y(i18);
        }
        ViewPropertyAnimator animate = view.animate();
        this.f201418d.add(view);
        animate.setDuration(this.f201421g).setListener(new b(i19, view, i17, i26, i18, animate, view)).start();
    }

    public boolean c(View view) {
        i(view);
        this.f201415a.add(view);
        view.setTranslationX(0.0f);
        return true;
    }

    void f() {
        if (!h()) {
            e();
            Log.e("ColorNoteListAnimator", "dispatchFinishedWhenDone");
        }
    }

    public void g(View view, boolean z16) {
        view.animate().cancel();
        for (int size = this.f201416b.size() - 1; size >= 0; size--) {
            if (this.f201416b.get(size).f201434a == view) {
                this.f201416b.remove(size);
            }
        }
        this.f201415a.remove(view);
        for (int size2 = this.f201417c.size() - 1; size2 >= 0; size2--) {
            ArrayList<c> arrayList = this.f201417c.get(size2);
            int size3 = arrayList.size() - 1;
            while (true) {
                if (size3 < 0) {
                    break;
                }
                if (arrayList.get(size3).f201434a == view) {
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f201417c.remove(size2);
                    }
                } else {
                    size3--;
                }
            }
        }
        if (!this.f201419e.remove(view)) {
            if (!this.f201418d.remove(view)) {
                if (!z16) {
                    f();
                    return;
                }
                return;
            }
            throw new IllegalStateException("after animation is cancelled, item should not be in mMoveAnimations list");
        }
        throw new IllegalStateException("after animation is cancelled, item should not be in mRemoveAnimations list");
    }

    public boolean h() {
        if (this.f201416b.isEmpty() && this.f201415a.isEmpty() && this.f201418d.isEmpty() && this.f201419e.isEmpty() && this.f201417c.isEmpty()) {
            return false;
        }
        return true;
    }

    public void j() {
        boolean z16 = !this.f201415a.isEmpty();
        boolean z17 = !this.f201416b.isEmpty();
        if (!z16 && !z17) {
            return;
        }
        Iterator<View> it = this.f201415a.iterator();
        while (it.hasNext()) {
            d(it.next());
        }
        this.f201415a.clear();
        if (z17) {
            final ArrayList<c> arrayList = new ArrayList<>();
            arrayList.addAll(this.f201416b);
            this.f201417c.add(arrayList);
            this.f201416b.clear();
            new Runnable() { // from class: com.tencent.mobileqq.colornote.list.ColorNoteListAnimator.1
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        c cVar = (c) it5.next();
                        ColorNoteListAnimator.this.b(cVar.f201434a, cVar.f201435b, cVar.f201436c, cVar.f201437d, cVar.f201438e);
                    }
                    arrayList.clear();
                    ColorNoteListAnimator.this.f201417c.remove(arrayList);
                }
            }.run();
        }
    }

    public void k(d dVar) {
        this.f201422h = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f201424d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f201425e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f201426f;

        a(View view, ViewPropertyAnimator viewPropertyAnimator, View view2) {
            this.f201424d = view;
            this.f201425e = viewPropertyAnimator;
            this.f201426f = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f201424d.setAlpha(0.0f);
            this.f201424d.setTranslationX(r2.getWidth());
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f201425e.setListener(null);
            ColorNoteListAnimator.this.f201419e.remove(this.f201426f);
            ColorNoteListAnimator.this.f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b extends AnimatorListenerAdapter {
        final /* synthetic */ View C;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f201428d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f201429e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f201430f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f201431h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f201432i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f201433m;

        b(int i3, View view, int i16, int i17, int i18, ViewPropertyAnimator viewPropertyAnimator, View view2) {
            this.f201428d = i3;
            this.f201429e = view;
            this.f201430f = i16;
            this.f201431h = i17;
            this.f201432i = i18;
            this.f201433m = viewPropertyAnimator;
            this.C = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f201428d != 0) {
                this.f201429e.setX(this.f201430f);
            }
            if (this.f201431h != 0) {
                this.f201429e.setX(this.f201432i);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f201433m.setListener(null);
            ColorNoteListAnimator.this.f201418d.remove(this.C);
            ColorNoteListAnimator.this.f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
