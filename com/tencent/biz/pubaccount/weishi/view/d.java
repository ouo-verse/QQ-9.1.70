package com.tencent.biz.pubaccount.weishi.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d extends f implements View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, View.OnClickListener {
    private static int K = ScreenUtil.dip2px(60.0f);
    private final TextView C;
    private final TextView D;
    private final a E;
    private b F;
    private ValueAnimator G;
    private int H;
    private boolean I;
    private boolean J;

    /* renamed from: e, reason: collision with root package name */
    private Context f82445e;

    /* renamed from: f, reason: collision with root package name */
    private final HorizontalScrollView f82446f;

    /* renamed from: h, reason: collision with root package name */
    private final LinearLayout f82447h;

    /* renamed from: i, reason: collision with root package name */
    private final TextView f82448i;

    /* renamed from: m, reason: collision with root package name */
    private final TextView f82449m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            d.this.f82446f.scrollTo(0, 0);
            x.i("WSMarqueeDirector", "onAnimationEnd: ");
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            d.this.f82446f.scrollTo(0, 0);
            x.i("WSMarqueeDirector", "onAnimationStart: ");
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (intValue < 0 || intValue > d.this.H) {
                return;
            }
            d.this.f82446f.scrollTo(intValue, 0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface b {
        void a(Object obj);

        void b(Object obj);
    }

    public d(View view) {
        super(view);
        this.E = new a();
        this.I = false;
        this.J = false;
        this.f82445e = view.getContext();
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) a(R.id.f165719xc3);
        this.f82446f = horizontalScrollView;
        LinearLayout linearLayout = (LinearLayout) a(R.id.f166103yp4);
        this.f82447h = linearLayout;
        TextView textView = (TextView) a(R.id.en9);
        this.f82448i = textView;
        TextView textView2 = (TextView) a(R.id.en_);
        this.f82449m = textView2;
        TextView textView3 = (TextView) a(R.id.yxi);
        this.C = textView3;
        TextView textView4 = (TextView) a(R.id.yxj);
        this.D = textView4;
        horizontalScrollView.setOnTouchListener(this);
        textView.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
        textView4.setOnClickListener(this);
        this.I = false;
        linearLayout.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    public void e() {
        this.f82448i.setText("");
        this.C.setText("");
        this.f82448i.setVisibility(8);
        this.C.setVisibility(8);
    }

    public void f() {
        this.f82449m.setText("");
        this.D.setText("");
        this.f82449m.setVisibility(8);
        this.D.setVisibility(8);
    }

    public void g() {
        ValueAnimator valueAnimator = this.G;
        if (valueAnimator == null) {
            return;
        }
        valueAnimator.pause();
    }

    public void h() {
        ValueAnimator valueAnimator = this.G;
        if (valueAnimator == null) {
            return;
        }
        valueAnimator.resume();
    }

    public void i(int i3, String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            e();
            return;
        }
        this.f82448i.setVisibility(0);
        this.C.setVisibility(8);
        Drawable drawable = b().getResources().getDrawable(i3);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.f82448i.setCompoundDrawables(drawable, null, null, null);
        TextView textView = this.f82448i;
        int i16 = ba.f81729d;
        textView.setCompoundDrawablePadding(i16);
        this.f82448i.setText(str);
        this.f82448i.setTag(obj);
        this.C.setCompoundDrawables(drawable, null, null, null);
        this.C.setCompoundDrawablePadding(i16);
        this.C.setText(str);
        this.C.setTag(obj);
    }

    public void j(int i3, String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            f();
            return;
        }
        this.f82449m.setVisibility(0);
        this.D.setVisibility(8);
        Drawable drawable = b().getResources().getDrawable(i3);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.f82449m.setCompoundDrawables(drawable, null, null, null);
        TextView textView = this.f82449m;
        int i16 = ba.f81729d;
        textView.setCompoundDrawablePadding(i16);
        this.f82449m.setText(str);
        this.f82449m.setTag(obj);
        this.D.setCompoundDrawables(drawable, null, null, null);
        this.D.setCompoundDrawablePadding(i16);
        this.D.setText(str);
        this.D.setTag(obj);
    }

    public void k(b bVar) {
        this.F = bVar;
    }

    public void l() {
        m();
        if (!this.I) {
            this.J = true;
            return;
        }
        this.J = false;
        int width = this.f82446f.getWidth();
        this.H = 0;
        if (!TextUtils.isEmpty(this.f82448i.getText())) {
            this.H += this.f82448i.getWidth();
        }
        if (!TextUtils.isEmpty(this.f82449m.getText())) {
            this.H += this.f82449m.getWidth();
        }
        if (this.H - width < 1) {
            this.C.setVisibility(8);
            this.D.setVisibility(8);
            return;
        }
        x.i("WSMarqueeDirector", "startAnim:  A text:" + ((Object) this.f82448i.getText()) + ",B text:" + ((Object) this.f82449m.getText()) + " , A width:" + this.f82448i.getWidth() + " , B width:" + this.f82449m.getWidth() + " , " + this.H);
        if (this.I) {
            if (this.f82448i.isShown()) {
                this.C.setVisibility(0);
            } else {
                this.C.setVisibility(8);
            }
            if (this.f82449m.isShown()) {
                this.D.setVisibility(0);
            } else {
                this.D.setVisibility(8);
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(0, this.H * 2);
            this.G = ofInt;
            ofInt.setDuration(((r2 * 1000) / K) + 1);
            this.G.addListener(this.E);
            this.G.addUpdateListener(this.E);
            this.G.setRepeatCount(-1);
            this.G.setInterpolator(new LinearInterpolator());
            this.G.start();
        }
    }

    public void m() {
        ValueAnimator valueAnimator = this.G;
        if (valueAnimator == null) {
            return;
        }
        valueAnimator.cancel();
        this.G = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.en9 /* 2131375949 */:
            case R.id.yxi /* 2131375951 */:
                b bVar = this.F;
                if (bVar == null) {
                    return;
                }
                bVar.a(view.getTag());
                return;
            case R.id.en_ /* 2131375950 */:
            case R.id.yxj /* 2131375952 */:
                b bVar2 = this.F;
                if (bVar2 == null) {
                    return;
                }
                bVar2.b(view.getTag());
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.f82447h.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        x.i("WSMarqueeDirector", "onGlobalLayout: ");
        this.I = true;
        if (this.J) {
            l();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return true;
    }
}
