package com.tencent.mm.ui.widget.snackbar;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.ui.widget.snackbar.SnackBar;
import com.tencent.mobileqq.R;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes9.dex */
public class SnackContainer extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public Queue f153832a;

    /* renamed from: b, reason: collision with root package name */
    public AnimationSet f153833b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f153834c;

    /* renamed from: d, reason: collision with root package name */
    public AnimationSet f153835d;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class SnackHolder {

        /* renamed from: a, reason: collision with root package name */
        public final View f153840a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f153841b;

        /* renamed from: c, reason: collision with root package name */
        public final TextView f153842c;

        /* renamed from: d, reason: collision with root package name */
        public final Snack f153843d;

        /* renamed from: e, reason: collision with root package name */
        public final SnackBar.OnVisibilityChangeListener f153844e;

        SnackHolder(Snack snack, View view, SnackBar.OnVisibilityChangeListener onVisibilityChangeListener) {
            this.f153840a = view;
            this.f153842c = (TextView) view.findViewById(R.id.f86684sb);
            this.f153841b = (TextView) view.findViewById(R.id.f86704sd);
            this.f153843d = snack;
            this.f153844e = onVisibilityChangeListener;
        }
    }

    public SnackContainer(Context context) {
        super(context);
        this.f153832a = new LinkedList();
        this.f153834c = new Runnable() { // from class: com.tencent.mm.ui.widget.snackbar.SnackContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (SnackContainer.this.getVisibility() == 0) {
                    SnackContainer snackContainer = SnackContainer.this;
                    snackContainer.startAnimation(snackContainer.f153833b);
                }
            }
        };
        a();
    }

    public void clearSnacks(boolean z16) {
        this.f153832a.clear();
        if (z16) {
            this.f153834c.run();
        }
    }

    public void hide() {
        removeCallbacks(this.f153834c);
        this.f153834c.run();
    }

    public boolean isEmpty() {
        return this.f153832a.isEmpty();
    }

    public boolean isShowing() {
        return !this.f153832a.isEmpty();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f153835d.cancel();
        this.f153833b.cancel();
        removeCallbacks(this.f153834c);
        this.f153832a.clear();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
        if (8 == i3) {
            removeAllViews();
            if (!this.f153832a.isEmpty()) {
                a((SnackHolder) this.f153832a.poll());
            }
            if (!isEmpty()) {
                c((SnackHolder) this.f153832a.peek());
            } else {
                setVisibility(8);
            }
            SnackBarAlert.setShowMode(false);
        }
    }

    public void restoreState(Bundle bundle, View view) {
        Parcelable[] parcelableArray = bundle.getParcelableArray("SAVED_MSGS");
        if (parcelableArray == null) {
            return;
        }
        int length = parcelableArray.length;
        boolean z16 = true;
        int i3 = 0;
        while (i3 < length) {
            showSnack((Snack) parcelableArray[i3], view, null, z16);
            i3++;
            z16 = false;
        }
    }

    public Bundle saveState() {
        Bundle bundle = new Bundle();
        Snack[] snackArr = new Snack[this.f153832a.size()];
        Iterator it = this.f153832a.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            snackArr[i3] = ((SnackHolder) it.next()).f153843d;
            i3++;
        }
        bundle.putParcelableArray("SAVED_MSGS", snackArr);
        return bundle;
    }

    public void showSnack(Snack snack, View view, SnackBar.OnVisibilityChangeListener onVisibilityChangeListener) {
        showSnack(snack, view, onVisibilityChangeListener, false);
    }

    public final void c(SnackHolder snackHolder) {
        a(snackHolder, false);
    }

    public void showSnack(Snack snack, View view, SnackBar.OnVisibilityChangeListener onVisibilityChangeListener, boolean z16) {
        if (view.getParent() != null && view.getParent() != this) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        SnackHolder snackHolder = new SnackHolder(snack, view, onVisibilityChangeListener);
        this.f153832a.offer(snackHolder);
        if (this.f153832a.size() == 1) {
            a(snackHolder, z16);
        }
    }

    public final void a() {
        this.f153835d = new AnimationSet(false);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.f153835d.setInterpolator(new DecelerateInterpolator(1.5f));
        this.f153835d.addAnimation(translateAnimation);
        this.f153835d.addAnimation(alphaAnimation);
        this.f153833b = new AnimationSet(false);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, 1.0f);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        this.f153833b.addAnimation(translateAnimation2);
        this.f153833b.addAnimation(alphaAnimation2);
        this.f153833b.setDuration(300L);
        this.f153833b.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.mm.ui.widget.snackbar.SnackContainer.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                SnackContainer.this.removeAllViews();
                if (!SnackContainer.this.f153832a.isEmpty()) {
                    SnackContainer snackContainer = SnackContainer.this;
                    snackContainer.a((SnackHolder) snackContainer.f153832a.poll());
                }
                if (!SnackContainer.this.isEmpty()) {
                    SnackContainer snackContainer2 = SnackContainer.this;
                    snackContainer2.c((SnackHolder) snackContainer2.f153832a.peek());
                } else {
                    SnackContainer.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (!SnackContainer.this.isEmpty() && SnackContainer.this.f153832a.peek() != null && ((SnackHolder) SnackContainer.this.f153832a.peek()).f153844e != null) {
                    SnackBarAlert.setShowMode(false);
                    ((SnackHolder) SnackContainer.this.f153832a.peek()).f153844e.startHide();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public final void b(SnackHolder snackHolder) {
        if (snackHolder.f153844e != null) {
            SnackBarAlert.setShowMode(true);
            snackHolder.f153844e.onShow();
        }
    }

    public SnackContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f153832a = new LinkedList();
        this.f153834c = new Runnable() { // from class: com.tencent.mm.ui.widget.snackbar.SnackContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (SnackContainer.this.getVisibility() == 0) {
                    SnackContainer snackContainer = SnackContainer.this;
                    snackContainer.startAnimation(snackContainer.f153833b);
                }
            }
        };
        a();
    }

    public SnackContainer(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        this.f153832a = new LinkedList();
        this.f153834c = new Runnable() { // from class: com.tencent.mm.ui.widget.snackbar.SnackContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (SnackContainer.this.getVisibility() == 0) {
                    SnackContainer snackContainer = SnackContainer.this;
                    snackContainer.startAnimation(snackContainer.f153833b);
                }
            }
        };
        viewGroup.addView(this, new ViewGroup.LayoutParams(-1, -1));
        setVisibility(8);
        setId(R.id.f86694sc);
        a();
    }

    public final void a(final SnackHolder snackHolder, boolean z16) {
        setVisibility(0);
        b(snackHolder);
        if (snackHolder.f153843d.f153808g != 0) {
            ViewGroup.LayoutParams layoutParams = snackHolder.f153840a.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = snackHolder.f153843d.f153808g;
            }
        }
        View view = snackHolder.f153843d.f153809h;
        if (view != null) {
            addView(view);
        } else {
            addView(snackHolder.f153840a);
        }
        snackHolder.f153841b.setText(snackHolder.f153843d.f153802a);
        if (snackHolder.f153843d.f153803b != null) {
            snackHolder.f153842c.setVisibility(0);
            snackHolder.f153842c.setText(snackHolder.f153843d.f153803b);
        } else {
            snackHolder.f153842c.setVisibility(8);
        }
        if (z16) {
            this.f153835d.setDuration(0L);
        } else {
            this.f153835d.setDuration(500L);
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154554n8);
        loadAnimation.setDuration(500L);
        startAnimation(this.f153835d);
        loadAnimation.setStartOffset(200L);
        snackHolder.f153842c.startAnimation(loadAnimation);
        snackHolder.f153841b.startAnimation(loadAnimation);
        int i3 = snackHolder.f153843d.f153806e;
        if (i3 > 0) {
            postDelayed(this.f153834c, i3);
        }
        snackHolder.f153840a.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mm.ui.widget.snackbar.SnackContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 4) {
                    SnackContainer snackContainer = SnackContainer.this;
                    snackContainer.removeCallbacks(snackContainer.f153834c);
                    SnackContainer.this.a(snackHolder);
                    SnackContainer snackContainer2 = SnackContainer.this;
                    snackContainer2.startAnimation(snackContainer2.f153833b);
                    if (!SnackContainer.this.f153832a.isEmpty()) {
                        SnackContainer.this.f153832a.clear();
                        return true;
                    }
                    return true;
                }
                return true;
            }
        });
    }

    public final void a(SnackHolder snackHolder) {
        if (snackHolder.f153844e != null) {
            SnackBarAlert.setShowMode(false);
            snackHolder.f153844e.onHide();
        }
    }
}
