package com.tencent.mobileqq.widget.annimation.invertview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QUIInvertViewLayout extends FrameLayout {
    private boolean C;
    private boolean D;
    private ValueAnimator.AnimatorUpdateListener E;
    private AnimatorListenerAdapter F;

    /* renamed from: d, reason: collision with root package name */
    private List<View> f316649d;

    /* renamed from: e, reason: collision with root package name */
    private ValueAnimator f316650e;

    /* renamed from: f, reason: collision with root package name */
    private int f316651f;

    /* renamed from: h, reason: collision with root package name */
    private int f316652h;

    /* renamed from: i, reason: collision with root package name */
    private int f316653i;

    /* renamed from: m, reason: collision with root package name */
    private int f316654m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            View view;
            View view2;
            if (QUIInvertViewLayout.this.C) {
                if (QUIInvertViewLayout.this.f316649d == null || QUIInvertViewLayout.this.f316653i < 0 || QUIInvertViewLayout.this.f316653i >= QUIInvertViewLayout.this.f316649d.size() || (view2 = (View) QUIInvertViewLayout.this.f316649d.get(QUIInvertViewLayout.this.f316653i)) == null) {
                    return;
                }
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                view2.setAlpha(1.0f - floatValue);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                marginLayoutParams.bottomMargin = (int) (QUIInvertViewLayout.this.getHeight() * floatValue);
                marginLayoutParams.topMargin = (int) ((-QUIInvertViewLayout.this.getHeight()) * floatValue);
                view2.setLayoutParams(marginLayoutParams);
                return;
            }
            if (QUIInvertViewLayout.this.f316649d == null || QUIInvertViewLayout.this.f316654m < 0 || QUIInvertViewLayout.this.f316654m >= QUIInvertViewLayout.this.f316649d.size() || (view = (View) QUIInvertViewLayout.this.f316649d.get(QUIInvertViewLayout.this.f316654m)) == null) {
                return;
            }
            float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            view.setAlpha(floatValue2);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams2.topMargin = (int) (QUIInvertViewLayout.this.getHeight() * (1.0f - floatValue2));
            marginLayoutParams2.bottomMargin = (int) ((-QUIInvertViewLayout.this.getHeight()) * floatValue2);
            view.setLayoutParams(marginLayoutParams2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View view;
            super.onAnimationEnd(animator);
            QUIInvertViewLayout.this.f316650e.cancel();
            if (QUIInvertViewLayout.this.C) {
                if (QUIInvertViewLayout.this.f316649d != null && QUIInvertViewLayout.this.f316653i >= 0 && QUIInvertViewLayout.this.f316653i < QUIInvertViewLayout.this.f316649d.size()) {
                    View view2 = (View) QUIInvertViewLayout.this.f316649d.get(QUIInvertViewLayout.this.f316653i);
                    if (view2 != null) {
                        view2.setVisibility(8);
                    }
                    QUIInvertViewLayout.this.r(2000L);
                    return;
                }
                return;
            }
            if (QUIInvertViewLayout.this.f316649d == null || QUIInvertViewLayout.this.f316654m < 0 || QUIInvertViewLayout.this.f316654m >= QUIInvertViewLayout.this.f316649d.size() || (view = (View) QUIInvertViewLayout.this.f316649d.get(QUIInvertViewLayout.this.f316654m)) == null) {
                return;
            }
            view.setVisibility(0);
            QUIInvertViewLayout.this.s();
        }
    }

    public QUIInvertViewLayout(@NonNull Context context) {
        this(context, null);
    }

    private void m() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f316650e = ofFloat;
        he0.b.m(ofFloat, this.f316651f, this.f316652h);
        this.f316650e.setRepeatCount(0);
        this.f316650e.addUpdateListener(this.E);
        this.f316650e.addListener(this.F);
    }

    private void o() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(long j3) {
        if (j3 < 0) {
            j3 = 0;
        }
        new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.widget.annimation.invertview.QUIInvertViewLayout.5
            @Override // java.lang.Runnable
            public void run() {
                if (QUIInvertViewLayout.this.f316649d != null && QUIInvertViewLayout.this.f316654m >= 0 && QUIInvertViewLayout.this.f316654m < QUIInvertViewLayout.this.f316649d.size()) {
                    QUIInvertViewLayout.this.C = false;
                    if (QUIInvertViewLayout.this.f316649d.get(QUIInvertViewLayout.this.f316654m) != null) {
                        ((View) QUIInvertViewLayout.this.f316649d.get(QUIInvertViewLayout.this.f316654m)).setVisibility(0);
                    }
                    QUIInvertViewLayout.this.f316650e.start();
                }
            }
        }, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.widget.annimation.invertview.QUIInvertViewLayout.4
            @Override // java.lang.Runnable
            public void run() {
                QUIInvertViewLayout qUIInvertViewLayout = QUIInvertViewLayout.this;
                qUIInvertViewLayout.f316653i = qUIInvertViewLayout.f316654m;
                QUIInvertViewLayout.this.f316654m++;
                if (QUIInvertViewLayout.this.f316649d == null) {
                    return;
                }
                if (QUIInvertViewLayout.this.f316654m >= QUIInvertViewLayout.this.f316649d.size()) {
                    QUIInvertViewLayout.this.f316654m = -1;
                }
                if (QUIInvertViewLayout.this.f316654m != -1 || !QUIInvertViewLayout.this.D) {
                    QUIInvertViewLayout.this.C = true;
                    QUIInvertViewLayout.this.f316650e.start();
                }
            }
        }, 2000L);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view, 0);
        if (this.f316649d == null) {
            this.f316649d = new ArrayList();
        }
        if (view != null) {
            this.f316649d.add(0, view);
            view.setVisibility(8);
        }
    }

    public boolean n() {
        ValueAnimator valueAnimator = this.f316650e;
        if (valueAnimator != null) {
            return valueAnimator.isRunning();
        }
        return false;
    }

    public QUIInvertViewLayout p(int i3, int i16) {
        this.f316651f = i3;
        if (i16 > 0) {
            this.f316652h = i16;
        }
        ValueAnimator valueAnimator = this.f316650e;
        if (valueAnimator != null) {
            he0.b.m(valueAnimator, i3, this.f316652h);
        }
        return this;
    }

    public void q() {
        if (this.f316650e.isRunning()) {
            this.f316650e.cancel();
        }
        o();
        this.f316653i = -1;
        this.f316654m = 0;
        this.D = true;
        r(0L);
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        List<View> list = this.f316649d;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        List<View> list;
        super.removeView(view);
        if (view != null && (list = this.f316649d) != null) {
            list.remove(view);
        }
    }

    public QUIInvertViewLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QUIInvertViewLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316649d = new ArrayList();
        this.f316651f = R.anim.f154986ut;
        this.f316652h = 3;
        this.f316653i = -1;
        this.f316654m = -1;
        this.C = false;
        this.D = true;
        this.E = new a();
        this.F = new b();
        m();
        post(new Runnable() { // from class: com.tencent.mobileqq.widget.annimation.invertview.QUIInvertViewLayout.3
            @Override // java.lang.Runnable
            public void run() {
                int childCount = QUIInvertViewLayout.this.getChildCount();
                if (QUIInvertViewLayout.this.f316649d == null) {
                    QUIInvertViewLayout.this.f316649d = new ArrayList();
                }
                QUIInvertViewLayout.this.f316649d.clear();
                if (childCount <= 0) {
                    return;
                }
                for (int i16 = 0; i16 < childCount; i16++) {
                    View childAt = QUIInvertViewLayout.this.getChildAt(i16);
                    QUIInvertViewLayout.this.f316649d.add(childAt);
                    childAt.setVisibility(8);
                }
            }
        });
    }
}
