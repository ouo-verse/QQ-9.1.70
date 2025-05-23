package com.tencent.mobileqq.tvideo.view;

import android.animation.Animator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import androidx.annotation.Keep;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.ViewUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TVideoLoadingView extends View {
    private static int D = 50;
    private static final int E = ViewUtils.dip2px(26.0f);
    private static final int F = ViewUtils.dip2px(10.0f);
    private boolean C;

    /* renamed from: d, reason: collision with root package name */
    private Animation f304787d;

    /* renamed from: e, reason: collision with root package name */
    private Animation f304788e;

    /* renamed from: f, reason: collision with root package name */
    private final ArrayList<a> f304789f;

    /* renamed from: h, reason: collision with root package name */
    private Animator f304790h;

    /* renamed from: i, reason: collision with root package name */
    private int f304791i;

    /* renamed from: m, reason: collision with root package name */
    private int f304792m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<TVideoLoadingView> f304793a;

        /* renamed from: b, reason: collision with root package name */
        private final Drawable f304794b;

        /* renamed from: c, reason: collision with root package name */
        private final int f304795c;

        /* renamed from: d, reason: collision with root package name */
        private final int f304796d;

        /* renamed from: e, reason: collision with root package name */
        private final int f304797e;

        /* renamed from: f, reason: collision with root package name */
        private final int f304798f;

        public a(TVideoLoadingView tVideoLoadingView, int i3, int i16) {
            this.f304793a = new WeakReference<>(tVideoLoadingView);
            Drawable mutate = tVideoLoadingView.getContext().getResources().getDrawable(i3).mutate();
            this.f304794b = mutate;
            int intrinsicWidth = mutate.getIntrinsicWidth();
            int intrinsicHeight = mutate.getIntrinsicHeight();
            int i17 = intrinsicWidth / 2;
            this.f304797e = i17;
            this.f304795c = (i16 * intrinsicWidth) + i17;
            int i18 = intrinsicHeight / 2;
            this.f304798f = i18;
            this.f304796d = i18;
        }

        private float e(float f16) {
            ArrayList<Keyframe> d16 = d();
            if (TVideoLoadingView.h(d16)) {
                return 0.0f;
            }
            Iterator<Keyframe> it = d16.iterator();
            Keyframe keyframe = null;
            Keyframe keyframe2 = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Keyframe next = it.next();
                if (TVideoLoadingView.j(Float.valueOf(next.getFraction()), Float.valueOf(f16))) {
                    return ((Float) next.getValue()).floatValue();
                }
                if (next.getFraction() < f16) {
                    keyframe2 = next;
                } else if (next.getFraction() > f16) {
                    keyframe = next;
                    break;
                }
            }
            if (keyframe2 != null && keyframe != null) {
                float fraction = keyframe2.getFraction();
                float fraction2 = keyframe.getFraction();
                if (fraction >= fraction2) {
                    return e(0.0f);
                }
                if (TVideoLoadingView.i(keyframe2, keyframe)) {
                    return e(0.0f);
                }
                Float f17 = (Float) keyframe2.getValue();
                return (((f16 - fraction) / (fraction2 - fraction)) * (((Float) keyframe.getValue()).floatValue() - f17.floatValue())) + f17.floatValue();
            }
            return e(0.0f);
        }

        private void f() {
            TVideoLoadingView tVideoLoadingView = this.f304793a.get();
            if (tVideoLoadingView != null) {
                tVideoLoadingView.k();
            }
        }

        private void g(int i3) {
            this.f304794b.setAlpha(Math.max(0, Math.min(i3, 255)));
        }

        private void h(float f16) {
            int i3 = this.f304795c;
            int i16 = this.f304797e;
            int i17 = (int) (i3 - (i16 * f16));
            int i18 = (int) (i3 + (i16 * f16));
            int i19 = this.f304796d;
            int i26 = this.f304798f;
            this.f304794b.setBounds(i17, (int) (i19 - (i26 * f16)), i18, (int) (i19 + (i26 * f16)));
        }

        public void c(Canvas canvas) {
            this.f304794b.draw(canvas);
        }

        protected abstract ArrayList<Keyframe> d();

        public void i(float f16) {
            float e16 = e(f16);
            h(e16);
            g((int) ((1.0f - ((1.0f - e16) * 1.5f)) * 255.0f));
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class b extends a {

        /* renamed from: g, reason: collision with root package name */
        private static final ArrayList<Keyframe> f304799g = j();

        public b(TVideoLoadingView tVideoLoadingView) {
            super(tVideoLoadingView, R.drawable.obk, 2);
        }

        private static ArrayList<Keyframe> j() {
            Keyframe ofFloat = Keyframe.ofFloat(0.0f, 0.6666667f);
            Keyframe ofFloat2 = Keyframe.ofFloat(0.16666667f, 1.0f);
            Keyframe ofFloat3 = Keyframe.ofFloat(0.6666667f, 0.0f);
            Keyframe ofFloat4 = Keyframe.ofFloat(1.0f, 0.6666667f);
            ArrayList<Keyframe> arrayList = new ArrayList<>();
            arrayList.add(ofFloat);
            arrayList.add(ofFloat2);
            arrayList.add(ofFloat3);
            arrayList.add(ofFloat4);
            return arrayList;
        }

        @Override // com.tencent.mobileqq.tvideo.view.TVideoLoadingView.a
        protected ArrayList<Keyframe> d() {
            return f304799g;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class c extends a {

        /* renamed from: g, reason: collision with root package name */
        private static final ArrayList<Keyframe> f304800g = j();

        public c(TVideoLoadingView tVideoLoadingView) {
            super(tVideoLoadingView, R.drawable.obl, 1);
        }

        private static ArrayList<Keyframe> j() {
            Keyframe ofFloat = Keyframe.ofFloat(0.0f, 1.0f);
            Keyframe ofFloat2 = Keyframe.ofFloat(0.5f, 0.0f);
            Keyframe ofFloat3 = Keyframe.ofFloat(1.0f, 1.0f);
            ArrayList<Keyframe> arrayList = new ArrayList<>();
            arrayList.add(ofFloat);
            arrayList.add(ofFloat2);
            arrayList.add(ofFloat3);
            return arrayList;
        }

        @Override // com.tencent.mobileqq.tvideo.view.TVideoLoadingView.a
        protected ArrayList<Keyframe> d() {
            return f304800g;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class d extends a {

        /* renamed from: g, reason: collision with root package name */
        private static final ArrayList<Keyframe> f304801g = j();

        public d(TVideoLoadingView tVideoLoadingView) {
            super(tVideoLoadingView, R.drawable.obm, 0);
        }

        private static ArrayList<Keyframe> j() {
            Keyframe ofFloat = Keyframe.ofFloat(0.0f, 0.6666667f);
            Keyframe ofFloat2 = Keyframe.ofFloat(0.33333334f, 0.0f);
            Keyframe ofFloat3 = Keyframe.ofFloat(0.8333333f, 1.0f);
            Keyframe ofFloat4 = Keyframe.ofFloat(1.0f, 0.6666667f);
            ArrayList<Keyframe> arrayList = new ArrayList<>();
            arrayList.add(ofFloat);
            arrayList.add(ofFloat2);
            arrayList.add(ofFloat3);
            arrayList.add(ofFloat4);
            return arrayList;
        }

        @Override // com.tencent.mobileqq.tvideo.view.TVideoLoadingView.a
        protected ArrayList<Keyframe> d() {
            return f304801g;
        }
    }

    public TVideoLoadingView(Context context) {
        super(context);
        this.f304789f = new ArrayList<>(3);
        this.f304791i = Integer.MAX_VALUE;
        this.f304792m = Integer.MAX_VALUE;
        this.C = true;
        d();
    }

    private void d() {
        setVisibility(4);
        e();
    }

    private void e() {
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.f304787d = translateAnimation;
        translateAnimation.setInterpolator(linearInterpolator);
        this.f304787d.setDuration(300L);
        this.f304787d.setFillBefore(true);
        this.f304787d.setFillAfter(false);
        this.f304787d.setFillEnabled(true);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.f304788e = translateAnimation2;
        translateAnimation2.setInterpolator(linearInterpolator);
        this.f304788e.setDuration(300L);
        this.f304788e.setFillAfter(true);
    }

    private Animator f() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "fraction", 0.0f, 1.0f);
        ofFloat.setRepeatCount(D);
        ofFloat.setDuration(AppConstants.FANS_MSG_BOX_UIN_LONGVALUE);
        ofFloat.setInterpolator(new LinearInterpolator());
        return ofFloat;
    }

    private void g() {
        d dVar = new d(this);
        c cVar = new c(this);
        b bVar = new b(this);
        this.f304789f.add(dVar);
        this.f304789f.add(cVar);
        this.f304789f.add(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean h(ArrayList<Keyframe> arrayList) {
        if (y.h(arrayList) || arrayList.size() <= 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean i(Keyframe keyframe, Keyframe keyframe2) {
        if ((keyframe.getValue() instanceof Float) && (keyframe2.getValue() instanceof Float)) {
            return false;
        }
        return true;
    }

    public static boolean j(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return true;
        }
        if (obj != null && obj2 != null && obj.equals(obj2)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        invalidate();
    }

    private void n(Canvas canvas) {
        if (this.f304791i != Integer.MAX_VALUE && this.f304792m != Integer.MAX_VALUE) {
            return;
        }
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        a aVar = this.f304789f.get(0);
        this.f304791i = (width / 2) - (aVar.f304797e * 3);
        this.f304792m = (height / 2) - aVar.f304798f;
    }

    public void l() {
        this.C = true;
        clearAnimation();
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        if (y.h(this.f304789f)) {
            g();
        }
        Animator animator = this.f304790h;
        if (animator != null) {
            animator.cancel();
        }
        Animator f16 = f();
        this.f304790h = f16;
        f16.start();
    }

    public void m() {
        this.C = false;
        Animator animator = this.f304790h;
        if (animator != null) {
            animator.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        m();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!y.h(this.f304789f) && this.C) {
            n(canvas);
            canvas.save();
            canvas.translate(this.f304791i, this.f304792m);
            Iterator<a> it = this.f304789f.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.c(canvas);
                }
            }
            canvas.restore();
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.f304791i = Integer.MAX_VALUE;
        this.f304792m = Integer.MAX_VALUE;
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int defaultSize;
        int defaultSize2;
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        if (mode == Integer.MIN_VALUE) {
            defaultSize = E;
        } else {
            defaultSize = View.getDefaultSize(getSuggestedMinimumWidth(), i3);
        }
        if (mode2 == Integer.MIN_VALUE) {
            defaultSize2 = F;
        } else {
            defaultSize2 = View.getDefaultSize(getSuggestedMinimumHeight(), i16);
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Keep
    public void setFraction(float f16) {
        Iterator<a> it = this.f304789f.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null) {
                next.i(f16);
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        if (i3 == 8) {
            m();
        }
        super.setVisibility(i3);
    }

    public TVideoLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f304789f = new ArrayList<>(3);
        this.f304791i = Integer.MAX_VALUE;
        this.f304792m = Integer.MAX_VALUE;
        this.C = true;
        d();
    }

    public TVideoLoadingView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f304789f = new ArrayList<>(3);
        this.f304791i = Integer.MAX_VALUE;
        this.f304792m = Integer.MAX_VALUE;
        this.C = true;
        d();
    }
}
