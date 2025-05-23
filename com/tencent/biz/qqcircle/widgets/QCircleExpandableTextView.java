package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleExpandableTextView extends LinearLayout {
    boolean C;
    int D;
    boolean E;
    int F;
    int G;
    boolean H;
    c I;
    private boolean J;

    /* renamed from: d, reason: collision with root package name */
    QCircleAsyncTextView f92983d;

    /* renamed from: e, reason: collision with root package name */
    TextView f92984e;

    /* renamed from: f, reason: collision with root package name */
    int f92985f;

    /* renamed from: h, reason: collision with root package name */
    int f92986h;

    /* renamed from: i, reason: collision with root package name */
    String f92987i;

    /* renamed from: m, reason: collision with root package name */
    String f92988m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private class b extends Animation {

        /* renamed from: d, reason: collision with root package name */
        int f92991d;

        /* renamed from: e, reason: collision with root package name */
        int f92992e;

        b(int i3, int i16) {
            this.f92991d = 0;
            this.f92992e = 0;
            setDuration(QCircleExpandableTextView.this.f92986h);
            this.f92991d = i3;
            this.f92992e = i16;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f16, Transformation transformation) {
            super.applyTransformation(f16, transformation);
            int i3 = this.f92992e;
            int i16 = (int) (((i3 - r0) * f16) + this.f92991d);
            QCircleExpandableTextView qCircleExpandableTextView = QCircleExpandableTextView.this;
            qCircleExpandableTextView.f92983d.setMaxHeight(i16 - qCircleExpandableTextView.G);
            QCircleExpandableTextView.this.getLayoutParams().height = i16;
            QCircleExpandableTextView.this.requestLayout();
        }

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface c {
        void W0(boolean z16);

        void X0(boolean z16);

        void Y0(boolean z16);
    }

    public QCircleExpandableTextView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(TextView textView, int i3) {
        int lineTop;
        int compoundPaddingTop;
        if (textView == null) {
            return 0;
        }
        if (textView.getLayout() == null) {
            lineTop = textView.getCompoundPaddingBottom();
            compoundPaddingTop = textView.getCompoundPaddingTop();
        } else {
            lineTop = textView.getLayout().getLineTop(i3) + textView.getCompoundPaddingBottom();
            compoundPaddingTop = textView.getCompoundPaddingTop();
        }
        return lineTop + compoundPaddingTop;
    }

    private void f(Context context, AttributeSet attributeSet) {
        setOrientation(1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y91.a.f449645f1);
        this.f92985f = obtainStyledAttributes.getInteger(y91.a.f449684i1, 3);
        this.f92986h = obtainStyledAttributes.getInteger(y91.a.f449658g1, 250);
        this.f92987i = obtainStyledAttributes.getString(y91.a.f449671h1);
        this.f92988m = obtainStyledAttributes.getString(y91.a.f449696j1);
        obtainStyledAttributes.recycle();
    }

    private void h(String str, RFWAsyncRichTextView.OnClickAtTextListener onClickAtTextListener) {
        this.C = true;
        this.f92983d.setOnClickAtTextListener(onClickAtTextListener);
        this.f92983d.setText(str);
    }

    public TextView c() {
        return this.f92984e;
    }

    public TextView e() {
        return this.f92983d;
    }

    public boolean g() {
        return this.E;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() < 2) {
            return;
        }
        this.f92983d = (QCircleAsyncTextView) getChildAt(0);
        TextView textView = (TextView) getChildAt(1);
        this.f92984e = textView;
        textView.setText(this.f92988m);
        this.f92984e.setOnClickListener(new a());
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.H;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (getVisibility() != 8 && this.C) {
            this.C = false;
            this.f92984e.setVisibility(8);
            this.f92983d.setMaxLines(Integer.MAX_VALUE);
            if (this.f92983d.getLineCount() <= this.f92985f) {
                super.onMeasure(i3, i16);
                return;
            }
            QCircleAsyncTextView qCircleAsyncTextView = this.f92983d;
            this.D = d(qCircleAsyncTextView, qCircleAsyncTextView.getLineCount());
            if (this.E) {
                this.f92983d.setMaxLines(this.f92985f);
            }
            if (this.I != null && this.f92984e.getVisibility() == 8) {
                this.I.X0(!this.E);
            }
            this.f92984e.setVisibility(0);
            super.onMeasure(i3, i16);
            if (this.E) {
                this.f92983d.post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QCircleExpandableTextView qCircleExpandableTextView = QCircleExpandableTextView.this;
                        qCircleExpandableTextView.G = qCircleExpandableTextView.getHeight() - QCircleExpandableTextView.this.f92983d.getHeight();
                        QCircleExpandableTextView qCircleExpandableTextView2 = QCircleExpandableTextView.this;
                        qCircleExpandableTextView2.F = qCircleExpandableTextView2.getMeasuredHeight();
                        QLog.d("QCircleExpandableTextView", 1, "onMeasure isCollapsed == true lastHeight: ", Integer.valueOf(QCircleExpandableTextView.this.G), " | collapsedHeight: ", Integer.valueOf(QCircleExpandableTextView.this.F));
                    }
                });
                return;
            } else {
                this.f92983d.post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView.3
                    @Override // java.lang.Runnable
                    public void run() {
                        QCircleExpandableTextView qCircleExpandableTextView = QCircleExpandableTextView.this;
                        qCircleExpandableTextView.G = qCircleExpandableTextView.getHeight() - QCircleExpandableTextView.this.f92983d.getHeight();
                        QCircleExpandableTextView qCircleExpandableTextView2 = QCircleExpandableTextView.this;
                        int d16 = qCircleExpandableTextView2.d(qCircleExpandableTextView2.f92983d, qCircleExpandableTextView2.f92985f);
                        int i17 = QCircleExpandableTextView.this.G;
                        qCircleExpandableTextView2.F = d16 + i17;
                        QLog.d("QCircleExpandableTextView", 1, "onMeasure isCollapsed == false lastHeight: ", Integer.valueOf(i17), " | collapsedHeight: ", Integer.valueOf(QCircleExpandableTextView.this.F));
                    }
                });
                return;
            }
        }
        super.onMeasure(i3, i16);
    }

    public void setClickAreaTextColor(int i3) {
        this.f92983d.setClickAreaTextColor(i3);
    }

    public void setDisableExpand(boolean z16) {
        this.J = z16;
    }

    public void setListener(c cVar) {
        this.I = cVar;
    }

    public void setNeedSpecialAreaBold(boolean z16) {
        this.f92983d.setNeedSpecialAreaBold(z16);
    }

    public void setOnClickHashTagListener(RFWAsyncRichTextView.OnClickHashTagTextListener onClickHashTagTextListener) {
        this.f92983d.setOnClickHashTagTextListener(onClickHashTagTextListener);
    }

    public void setSpecialAreaTextColor(int i3) {
        this.f92983d.setSpecialClickAreaColor(i3);
    }

    public void setText(String str, boolean z16, RFWAsyncRichTextView.OnClickAtTextListener onClickAtTextListener) {
        boolean z17 = !z16;
        this.E = z17;
        if (z17) {
            this.f92984e.setText(this.f92988m);
        } else {
            this.f92984e.setText(this.f92987i);
        }
        clearAnimation();
        h(str, onClickAtTextListener);
        getLayoutParams().height = -2;
        c cVar = this.I;
        if (cVar != null) {
            cVar.W0(z16);
        }
    }

    public QCircleExpandableTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QCircleExpandableTextView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f92985f = 0;
        this.f92986h = 0;
        this.C = false;
        this.D = 0;
        this.E = true;
        this.F = 0;
        this.G = 0;
        this.H = false;
        f(context, attributeSet);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QCircleExpandableTextView.this.J) {
                QCircleExpandableTextView qCircleExpandableTextView = QCircleExpandableTextView.this;
                c cVar = qCircleExpandableTextView.I;
                if (cVar != null) {
                    cVar.Y0(qCircleExpandableTextView.E);
                }
            } else {
                QCircleExpandableTextView qCircleExpandableTextView2 = QCircleExpandableTextView.this;
                boolean z16 = !qCircleExpandableTextView2.E;
                qCircleExpandableTextView2.E = z16;
                if (z16) {
                    qCircleExpandableTextView2.f92984e.setText(qCircleExpandableTextView2.f92988m);
                    QCircleExpandableTextView qCircleExpandableTextView3 = QCircleExpandableTextView.this;
                    bVar = new b(qCircleExpandableTextView3.getHeight(), QCircleExpandableTextView.this.F);
                } else {
                    qCircleExpandableTextView2.f92984e.setText(qCircleExpandableTextView2.f92987i);
                    QCircleExpandableTextView qCircleExpandableTextView4 = QCircleExpandableTextView.this;
                    int height = qCircleExpandableTextView4.getHeight();
                    QCircleExpandableTextView qCircleExpandableTextView5 = QCircleExpandableTextView.this;
                    bVar = new b(height, qCircleExpandableTextView5.D + qCircleExpandableTextView5.G);
                }
                bVar.setFillAfter(true);
                bVar.setAnimationListener(new AnimationAnimationListenerC0934a());
                QCircleExpandableTextView.this.clearAnimation();
                QCircleExpandableTextView.this.startAnimation(bVar);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* compiled from: P */
        /* renamed from: com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView$a$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class AnimationAnimationListenerC0934a implements Animation.AnimationListener {
            AnimationAnimationListenerC0934a() {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                QCircleExpandableTextView.this.clearAnimation();
                QCircleExpandableTextView qCircleExpandableTextView = QCircleExpandableTextView.this;
                qCircleExpandableTextView.H = false;
                c cVar = qCircleExpandableTextView.I;
                if (cVar != null) {
                    cVar.W0(!qCircleExpandableTextView.E);
                    QCircleExpandableTextView.this.I.Y0(!r2.E);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                QCircleExpandableTextView.this.H = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        }
    }
}
