package com.tencent.av.ui.effect.view;

import android.R;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView;
import com.tencent.av.ui.effect.toolbar.newversion.DownLineButton;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QavEffectSlidingTabView extends HorizontalScrollView {
    private static final int[] R = {R.attr.textSize, R.attr.textColor};
    private int C;
    protected int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    protected int J;
    private int K;
    private Paint L;
    private int M;
    private c N;
    private boolean P;
    protected int Q;

    /* renamed from: d, reason: collision with root package name */
    protected LinearLayout f75591d;

    /* renamed from: e, reason: collision with root package name */
    protected ArrayList<View> f75592e;

    /* renamed from: f, reason: collision with root package name */
    protected int f75593f;

    /* renamed from: h, reason: collision with root package name */
    protected int f75594h;

    /* renamed from: i, reason: collision with root package name */
    protected int f75595i;

    /* renamed from: m, reason: collision with root package name */
    protected int f75596m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f75597d;

        a(int i3) {
            this.f75597d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QavEffectSlidingTabView.this.f(this.f75597d);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QavEffectSlidingTabView.this.G = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            QavEffectSlidingTabView.this.invalidate();
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface c {
        void onTabChecked(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface d {
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public String f75600a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f75601b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f75602c;
    }

    public QavEffectSlidingTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f75591d = null;
        this.f75592e = new ArrayList<>(5);
        this.f75593f = -7829368;
        this.f75594h = -16777216;
        this.f75595i = Color.parseColor("#E62555");
        this.f75596m = 14;
        this.C = 0;
        this.D = 15;
        this.E = 5;
        this.F = 52;
        this.G = 0;
        this.H = 4;
        this.I = -16776961;
        this.J = 0;
        this.K = 0;
        this.L = null;
        this.M = 0;
        this.P = false;
        this.Q = -1;
        e(context, attributeSet);
    }

    private void e(Context context, AttributeSet attributeSet) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f75591d = linearLayout;
        linearLayout.setOrientation(0);
        this.f75591d.setLayoutParams(layoutParams);
        addView(this.f75591d);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.C = (int) TypedValue.applyDimension(1, this.C, displayMetrics);
        this.F = (int) TypedValue.applyDimension(1, this.F, displayMetrics);
        this.H = (int) TypedValue.applyDimension(1, this.H, displayMetrics);
        this.D = (int) TypedValue.applyDimension(1, this.D, displayMetrics);
        this.f75596m = (int) TypedValue.applyDimension(1, this.f75596m, displayMetrics);
        this.E = (int) TypedValue.applyDimension(1, this.E, displayMetrics);
        context.obtainStyledAttributes(attributeSet, R).recycle();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mobileqq.R.styleable.QIMSlidingTabViewStyle);
        this.C = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.R.styleable.QIMSlidingTabViewStyle_tabStartEndMargin, this.C);
        this.D = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.R.styleable.QIMSlidingTabViewStyle_tabPadding, this.D);
        this.I = obtainStyledAttributes.getColor(com.tencent.mobileqq.R.styleable.QIMSlidingTabViewStyle_tabIndicatorColor, this.I);
        this.H = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.R.styleable.QIMSlidingTabViewStyle_tabIndicatorHeight, this.H);
        this.f75593f = obtainStyledAttributes.getColor(com.tencent.mobileqq.R.styleable.QIMSlidingTabViewStyle_tabTextNormalColor, this.f75593f);
        this.f75594h = obtainStyledAttributes.getColor(com.tencent.mobileqq.R.styleable.QIMSlidingTabViewStyle_tabTextCheckedColor, this.f75594h);
        this.f75596m = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.R.styleable.QIMSlidingTabViewStyle_tabTextSize, this.f75596m);
        this.E = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.R.styleable.QIMSlidingTabViewStyle_tabIndicatorPadding, this.E);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.L = paint;
        paint.setAntiAlias(true);
        this.L.setColor(this.I);
        this.L.setStyle(Paint.Style.FILL);
        setFillViewport(true);
        setWillNotDraw(false);
        setHorizontalScrollBarEnabled(false);
        this.M = ScreenUtil.dip2px(0.0f);
    }

    private void g(int i3) {
        View childAt = this.f75591d.getChildAt(i3);
        if (childAt != null) {
            int scrollX = getScrollX();
            int i16 = this.D * 4;
            int right = ((childAt.getRight() - scrollX) - getWidth()) + i16;
            if (right > 0) {
                smoothScrollBy(right, 0);
                return;
            }
            int left = (childAt.getLeft() - scrollX) - i16;
            if (left < 0) {
                smoothScrollBy(left, 0);
            }
        }
    }

    private void h(int i3) {
        int childCount = this.f75591d.getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = this.f75591d.getChildAt(i16);
            if (childAt instanceof ViewGroup) {
                childAt = ((ViewGroup) childAt).getChildAt(0);
            }
            ArrayList<View> arrayList = this.f75592e;
            if (arrayList != null && i16 < arrayList.size()) {
                View view = this.f75592e.get(i16);
                if (i16 == i3) {
                    if (view instanceof ImageView) {
                        Bundle bundle = (Bundle) view.getTag();
                        if (bundle != null) {
                            ((ImageView) view).setImageResource(bundle.getInt(QIMSlidingTabView.KEY_CHECKED_IMAGE_BG_ID, com.tencent.mobileqq.R.drawable.ff5));
                        }
                    } else if (view instanceof RedDotTextView) {
                        if (this.Q == i16) {
                            ((RedDotTextView) childAt).setTextColor(this.f75595i);
                        } else {
                            ((RedDotTextView) childAt).setTextColor(this.f75594h);
                        }
                        ((RedDotTextView) childAt).c(false);
                    } else if (view instanceof DownLineButton) {
                        DownLineButton downLineButton = (DownLineButton) childAt;
                        downLineButton.setSelected(true);
                        downLineButton.setTextColor(getResources().getColor(com.tencent.mobileqq.R.color.c_b));
                    } else if (view instanceof TextView) {
                        ((TextView) childAt).setTextColor(this.f75594h);
                    }
                } else if (view instanceof ImageView) {
                    Bundle bundle2 = (Bundle) view.getTag();
                    if (bundle2 != null) {
                        ((ImageView) view).setImageResource(bundle2.getInt(QIMSlidingTabView.KEY_NOMAL_IMAGE_BG_ID, com.tencent.mobileqq.R.drawable.f161987ff4));
                    }
                } else if (view instanceof RedDotTextView) {
                    ((RedDotTextView) childAt).setTextColor(this.f75593f);
                } else if (view instanceof DownLineButton) {
                    DownLineButton downLineButton2 = (DownLineButton) childAt;
                    downLineButton2.setSelected(false);
                    downLineButton2.setTextColor(getResources().getColor(com.tencent.mobileqq.R.color.c_a));
                } else if (view instanceof TextView) {
                    ((TextView) childAt).setTextColor(this.f75593f);
                }
            }
        }
    }

    protected int b(int i3, View view) {
        if (i3 < 0) {
            return -1;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        layoutParams.gravity = 16;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams2.gravity = 1;
        view.setLayoutParams(layoutParams2);
        view.setOnClickListener(new a(i3));
        this.f75592e.add(i3, view);
        linearLayout.addView(view);
        this.f75591d.addView(linearLayout, i3);
        return 0;
    }

    @TargetApi(11)
    protected void c() {
        View view;
        int left;
        int left2;
        int i3 = this.K;
        int i16 = this.J;
        if (i3 != i16) {
            View childAt = this.f75591d.getChildAt(i3);
            View view2 = null;
            if (childAt instanceof ViewGroup) {
                view = ((ViewGroup) childAt).getChildAt(0);
            } else {
                view = null;
            }
            View childAt2 = this.f75591d.getChildAt(this.J);
            if (childAt2 instanceof ViewGroup) {
                view2 = ((ViewGroup) childAt2).getChildAt(0);
            }
            if (childAt != null && childAt2 != null) {
                int left3 = childAt.getLeft();
                if (view == null) {
                    left = 0;
                } else {
                    left = view.getLeft();
                }
                int i17 = left3 + left;
                int left4 = childAt2.getLeft();
                if (view2 == null) {
                    left2 = 0;
                } else {
                    left2 = view2.getLeft();
                }
                int i18 = left4 + left2;
                if (i17 == 0 && i18 == 0) {
                    this.P = true;
                    return;
                }
                this.P = false;
                ValueAnimator ofInt = ValueAnimator.ofInt(i17, i18);
                ofInt.setDuration(100L);
                ofInt.addUpdateListener(new b());
                ofInt.start();
                return;
            }
            return;
        }
        View childAt3 = this.f75591d.getChildAt(i16);
        if (childAt3 instanceof ViewGroup) {
            childAt3 = ((ViewGroup) childAt3).getChildAt(0);
        }
        this.G = childAt3.getLeft();
        invalidate();
    }

    public void d(ArrayList<e> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            this.f75592e.clear();
            this.f75591d.removeAllViews();
            int i3 = -1;
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                RedDotTextView redDotTextView = new RedDotTextView(getContext());
                redDotTextView.setText(arrayList.get(i16).f75600a);
                redDotTextView.setContentDescription(arrayList.get(i16).f75600a);
                redDotTextView.setGravity(17);
                redDotTextView.setSingleLine();
                redDotTextView.setTextSize(0, this.f75596m);
                int i17 = this.D;
                redDotTextView.setPadding(i17, 0, i17, 0);
                redDotTextView.c(arrayList.get(i16).f75601b);
                if (arrayList.get(i16).f75602c) {
                    i3 = i16;
                }
                b(i16, redDotTextView);
            }
            this.Q = i3;
            h(this.J);
            return;
        }
        this.f75591d.removeAllViews();
    }

    public void f(int i3) {
        if (i3 >= 0 && i3 < this.f75592e.size()) {
            this.J = i3;
            h(i3);
            g(i3);
            c();
            c cVar = this.N;
            if (cVar != null) {
                cVar.onTabChecked(i3);
            }
            this.K = this.J;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i3;
        super.onDraw(canvas);
        int height = getHeight();
        View childAt = this.f75591d.getChildAt(this.J);
        if (childAt instanceof ViewGroup) {
            childAt = ((ViewGroup) childAt).getChildAt(0);
        }
        if (childAt != null) {
            if (this.P) {
                this.G = childAt.getLeft();
                g(this.J);
                this.P = false;
            }
            if (this.J == 0 && this.G < childAt.getLeft()) {
                this.G = childAt.getLeft();
            }
            if (this.Q == this.J) {
                i3 = this.f75595i;
            } else {
                i3 = this.I;
            }
            this.L.setColor(i3);
            int i16 = this.G;
            RectF rectF = new RectF(this.E + i16, height - this.H, (i16 + childAt.getWidth()) - this.E, height);
            int i17 = this.M;
            canvas.drawRoundRect(rectF, i17, i17, this.L);
        }
    }

    public void setTabCheckListener(c cVar) {
        this.N = cVar;
    }

    public QavEffectSlidingTabView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f75591d = null;
        this.f75592e = new ArrayList<>(5);
        this.f75593f = -7829368;
        this.f75594h = -16777216;
        this.f75595i = Color.parseColor("#E62555");
        this.f75596m = 14;
        this.C = 0;
        this.D = 15;
        this.E = 5;
        this.F = 52;
        this.G = 0;
        this.H = 4;
        this.I = -16776961;
        this.J = 0;
        this.K = 0;
        this.L = null;
        this.M = 0;
        this.P = false;
        this.Q = -1;
        e(context, attributeSet);
    }

    public void setInterceptor(d dVar) {
    }
}
