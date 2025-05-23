package com.tencent.mobileqq.widget;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bt {

    /* renamed from: a, reason: collision with root package name */
    private static long f316781a = 400;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f316782b = false;

    public static void b() {
        f316782b = false;
    }

    public static void c(ViewGroup viewGroup) {
        if (f316782b) {
            return;
        }
        f316782b = true;
        viewGroup.invalidate();
        View childAt = viewGroup.getChildAt(0);
        View childAt2 = viewGroup.getChildAt(1);
        bd bdVar = new bd(childAt2);
        bdVar.setDuration(f316781a);
        bdVar.setFillAfter(true);
        bdVar.setAnimationListener(new a(childAt, childAt2));
        childAt2.startAnimation(bdVar);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f316783d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f316784e;

        a(View view, View view2) {
            this.f316783d = view;
            this.f316784e = view2;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            bc bcVar = new bc(this.f316783d);
            bcVar.setDuration(bt.f316781a);
            bcVar.setFillAfter(true);
            this.f316783d.startAnimation(bcVar);
            this.f316783d.setVisibility(0);
            this.f316784e.clearAnimation();
            this.f316784e.setVisibility(4);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.f316783d.clearAnimation();
            this.f316783d.setVisibility(4);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
