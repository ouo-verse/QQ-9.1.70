package com.tencent.biz.qqcircle.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.qqcircle.utils.d;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Animator.AnimatorListener f92761d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f92762e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f92763f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ List f92764h;

        b(Animator.AnimatorListener animatorListener, List list, int i3, List list2) {
            this.f92761d = animatorListener;
            this.f92762e = list;
            this.f92763f = i3;
            this.f92764h = list2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Animator.AnimatorListener animatorListener = this.f92761d;
            if (animatorListener != null) {
                animatorListener.onAnimationCancel(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Drawable drawable;
            for (int i3 = 0; i3 < this.f92762e.size(); i3++) {
                View view = (View) this.f92762e.get(i3);
                if (view != null) {
                    view.setBackgroundColor(this.f92763f);
                    if (this.f92764h.size() > i3) {
                        drawable = (Drawable) this.f92764h.get(i3);
                    } else {
                        drawable = null;
                    }
                    view.setBackground(drawable);
                }
            }
            Animator.AnimatorListener animatorListener = this.f92761d;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Animator.AnimatorListener animatorListener = this.f92761d;
            if (animatorListener != null) {
                animatorListener.onAnimationRepeat(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Animator.AnimatorListener animatorListener = this.f92761d;
            if (animatorListener != null) {
                animatorListener.onAnimationStart(animator);
            }
        }
    }

    public static AnimatorSet d(View view, long j3, int i3, float... fArr) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, fArr);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_Y, fArr);
        ofFloat.setRepeatCount(i3);
        ofFloat2.setRepeatCount(i3);
        animatorSet.setDuration(j3);
        animatorSet.play(ofFloat).with(ofFloat2);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(int i3, List list, ValueAnimator valueAnimator) {
        int b16 = QFSQUIUtilsKt.b(i3, ((Float) valueAnimator.getAnimatedValue()).floatValue());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            if (view != null) {
                view.setBackgroundColor(b16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(int i3, List list, ValueAnimator valueAnimator) {
        int b16 = QFSQUIUtilsKt.b(i3, ((Float) valueAnimator.getAnimatedValue()).floatValue());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            if (view != null) {
                view.setBackgroundColor(b16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(View view, String str) {
        if (view != null && !TextUtils.isEmpty(str)) {
            if (BasicAnimation.KeyPath.ROTATION_X.equals(str)) {
                view.setRotationX(0.0f);
            } else if (BasicAnimation.KeyPath.ROTATION_Y.equals(str)) {
                view.setRotationY(0.0f);
            }
        }
    }

    public static void h(View view, int i3, final List<View> list, List<Drawable> list2, Animator.AnimatorListener animatorListener) {
        if (view == null) {
            return;
        }
        final int d16 = QFSQUIUtilsKt.d(view.getContext(), R.color.qui_common_fill_standard_secondary);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 0.6f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.utils.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.e(d16, list, valueAnimator);
            }
        });
        ofFloat.addListener(new a(view, i3, list, list2, animatorListener));
        ofFloat.start();
    }

    public static void i(Context context, int i3, final List<View> list, List<Drawable> list2, Animator.AnimatorListener animatorListener) {
        if (list != null && list.size() > 0) {
            final int d16 = QFSQUIUtilsKt.d(context, R.color.qui_common_fill_standard_secondary);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.6f, 0.0f);
            ofFloat.setInterpolator(new jc0.a(0.42f, 0.0f, 0.58f, 1.0f));
            ofFloat.setDuration(700L);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.utils.b
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    d.f(d16, list, valueAnimator);
                }
            });
            ofFloat.addListener(new b(animatorListener, list, i3, list2));
            ofFloat.start();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void j(@NonNull RecyclerView recyclerView) {
        boolean z16;
        int childCount = recyclerView.getChildCount();
        ArrayList<View> arrayList = new ArrayList();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = recyclerView.getChildAt(i3);
            if (childAt != null) {
                Object tag = childAt.getTag(R.id.f52332_i);
                if (tag instanceof Boolean) {
                    z16 = ((Boolean) tag).booleanValue();
                    if (!z16) {
                        arrayList.add(childAt);
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
        QLog.d("AnimationUtils", 1, "showLikeTopAnimation childCount \uff1a " + childCount + " animViews.size : " + arrayList.size());
        ArrayList arrayList2 = new ArrayList();
        for (View view : arrayList) {
            if (view != null) {
                arrayList2.add(view.getBackground());
                view.setTag(R.id.f52332_i, Boolean.FALSE);
            }
        }
        h(recyclerView, 0, arrayList, arrayList2, null);
    }

    public static void k(View view, long j3, int i3, float... fArr) {
        d(view, j3, i3, fArr).start();
    }

    public static void l(View view, int i3, View view2, int i16) {
        if (view != null && view2 != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
            long j3 = i3;
            ofFloat.setDuration(j3);
            ofFloat.addListener(new c(view));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            ofFloat2.setDuration(i16);
            ofFloat2.addListener(new C0932d(view2));
            ofFloat2.setStartDelay(j3);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.start();
        }
    }

    public static void m(View view, int i3, View view2, int i16, String str) {
        if (view != null && view2 != null && !TextUtils.isEmpty(str)) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, str, 0.0f, -90.0f);
            long j3 = i3;
            ofFloat.setDuration(j3);
            he0.b.l(ofFloat, R.anim.f154973ug);
            ofFloat.addListener(new e(view, str));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, str, -270.0f, -360.0f);
            ofFloat2.setDuration(i16 - 50);
            ofFloat2.addListener(new f(view2));
            he0.b.l(ofFloat2, R.anim.f154980un);
            ofFloat2.setStartDelay(j3);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f92756d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f92757e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f92758f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ List f92759h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Animator.AnimatorListener f92760i;

        a(View view, int i3, List list, List list2, Animator.AnimatorListener animatorListener) {
            this.f92756d = view;
            this.f92757e = i3;
            this.f92758f = list;
            this.f92759h = list2;
            this.f92760i = animatorListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(View view, int i3, List list, List list2, Animator.AnimatorListener animatorListener) {
            d.i(view.getContext(), i3, list, list2, animatorListener);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            final View view = this.f92756d;
            final int i3 = this.f92757e;
            final List list = this.f92758f;
            final List list2 = this.f92759h;
            final Animator.AnimatorListener animatorListener = this.f92760i;
            view.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.utils.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.a.b(view, i3, list, list2, animatorListener);
                }
            }, 1000L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class c implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f92765d;

        c(View view) {
            this.f92765d = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View view = this.f92765d;
            if (view != null) {
                view.setVisibility(8);
                this.f92765d.setAlpha(1.0f);
                this.f92765d.setClickable(true);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            View view = this.f92765d;
            if (view != null) {
                view.setClickable(false);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.utils.d$d, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C0932d implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f92766d;

        C0932d(View view) {
            this.f92766d = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            VideoReport.traverseExposure();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            View view = this.f92766d;
            if (view != null) {
                view.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class e implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f92767d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f92768e;

        e(View view, String str) {
            this.f92767d = view;
            this.f92768e = str;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View view = this.f92767d;
            if (view != null) {
                view.setVisibility(4);
                d.g(this.f92767d, this.f92768e);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class f implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f92769d;

        f(View view) {
            this.f92769d = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            View view = this.f92769d;
            if (view != null) {
                view.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
