package com.tencent.mobileqq.widget;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@TargetApi(14)
/* loaded from: classes20.dex */
public abstract class AbsSlidingIndicator extends HorizontalScrollView {

    /* renamed from: a0, reason: collision with root package name */
    private static final int[] f315358a0 = {R.attr.textSize, R.attr.textColor};
    protected int C;
    protected int D;
    protected int E;
    private int F;
    private int G;
    protected int H;
    protected boolean I;
    protected Paint J;
    protected RectF K;
    protected f L;
    private com.tencent.mobileqq.activity.contacts.base.tabs.e M;
    private e N;
    protected boolean P;
    SparseBooleanArray Q;
    protected int R;
    protected int S;
    protected d T;
    Drawable U;
    protected int V;
    protected ViewTreeObserver.OnGlobalLayoutListener W;

    /* renamed from: d, reason: collision with root package name */
    protected LinearLayout f315359d;

    /* renamed from: e, reason: collision with root package name */
    private int f315360e;

    /* renamed from: f, reason: collision with root package name */
    protected int f315361f;

    /* renamed from: h, reason: collision with root package name */
    protected int f315362h;

    /* renamed from: i, reason: collision with root package name */
    protected String[] f315363i;

    /* renamed from: m, reason: collision with root package name */
    protected int[] f315364m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends View.AccessibilityDelegate {
        a() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i3) {
            if (i3 != 4096) {
                super.sendAccessibilityEvent(view, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f315366d;

        b(int i3) {
            this.f315366d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AbsSlidingIndicator absSlidingIndicator = AbsSlidingIndicator.this;
            int i3 = absSlidingIndicator.f315361f;
            if (i3 == this.f315366d && i3 >= 0 && absSlidingIndicator.N != null) {
                AbsSlidingIndicator.this.N.k1(this.f315366d);
            }
            AbsSlidingIndicator.this.s(this.f315366d, true, true);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class c implements ViewTreeObserver.OnGlobalLayoutListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            AbsSlidingIndicator.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            AbsSlidingIndicator absSlidingIndicator = AbsSlidingIndicator.this;
            absSlidingIndicator.r(absSlidingIndicator.f315361f);
            AbsSlidingIndicator absSlidingIndicator2 = AbsSlidingIndicator.this;
            absSlidingIndicator2.q(absSlidingIndicator2.f315361f);
            AbsSlidingIndicator absSlidingIndicator3 = AbsSlidingIndicator.this;
            View childAt = absSlidingIndicator3.f315359d.getChildAt(absSlidingIndicator3.f315361f);
            if (childAt != null) {
                AbsSlidingIndicator absSlidingIndicator4 = AbsSlidingIndicator.this;
                if (absSlidingIndicator4.P) {
                    QLog.i("SimpleSlidingIndicator", 2, "onGlobalLayout is anim");
                } else {
                    absSlidingIndicator4.V = absSlidingIndicator4.h();
                }
                if (childAt.getMeasuredWidth() == 0) {
                    AbsSlidingIndicator absSlidingIndicator5 = AbsSlidingIndicator.this;
                    absSlidingIndicator5.V = absSlidingIndicator5.k();
                }
                AbsSlidingIndicator.this.invalidate();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface d {
        void a(View view, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface e {
        void k1(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface f {
        int I0(int i3, boolean z16);
    }

    public AbsSlidingIndicator(Context context) {
        this(context, null);
    }

    private void w() {
        for (int i3 = 0; i3 < this.f315360e; i3++) {
            View childAt = this.f315359d.getChildAt(i3);
            if (childAt instanceof RedTouch) {
                RedTouch redTouch = (RedTouch) childAt;
                if (redTouch.getTarget() instanceof TextView) {
                    ((TextView) redTouch.getTarget()).setTextSize(0, this.H);
                }
            }
        }
    }

    protected abstract void b(int i3, View view);

    protected void c(int i3, String str, int i16) {
        RedDotTextView redDotTextView = new RedDotTextView(getContext());
        redDotTextView.setText(str);
        redDotTextView.setGravity(17);
        int i17 = this.R;
        int i18 = this.S;
        redDotTextView.setPadding(i17, i18, i17, i18);
        redDotTextView.setSingleLine();
        RedTouch applyTo = new RedTouch(getContext(), redDotTextView).setGravity(53).applyTo();
        applyTo.setId(i16);
        b(i3, applyTo);
        d dVar = this.T;
        if (dVar != null) {
            dVar.a(applyTo, i3);
        }
    }

    protected abstract void d();

    public void e(int i3) {
        this.Q.delete(i3);
        invalidate();
    }

    public void f(int i3) {
        RedTouch redTouch = (RedTouch) this.f315359d.findViewById(i3);
        if (redTouch != null && redTouch.hasRedTouch()) {
            redTouch.clearRedTouch();
        }
    }

    protected abstract void g(Canvas canvas);

    protected abstract int h();

    protected abstract int[] i();

    public int j() {
        return this.f315361f;
    }

    protected abstract int k();

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(Context context) {
        this.U = getResources().getDrawable(com.tencent.mobileqq.R.drawable.clb);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f315359d = linearLayout;
        linearLayout.setOrientation(0);
        this.f315359d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        int[] i3 = i();
        this.f315359d.setPadding(i3[0], i3[1], i3[2], i3[3]);
        addView(this.f315359d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        Paint paint = new Paint();
        this.J = paint;
        paint.setAntiAlias(true);
        this.J.setStyle(Paint.Style.FILL);
        if (SimpleUIUtil.isNowElderMode()) {
            this.H = DisplayUtil.dip2px(getContext(), 18.0f);
        }
        this.J.setTextSize(this.H);
        this.K = new RectF();
    }

    public void n() {
        this.f315359d.removeAllViews();
        this.f315360e = this.f315363i.length;
        for (int i3 = 0; i3 < this.f315360e; i3++) {
            c(i3, this.f315363i[i3], this.f315364m[i3]);
        }
        w();
        getViewTreeObserver().addOnGlobalLayoutListener(this.W);
    }

    public void o(int i3) {
        if (i3 > 255) {
            this.F = 255;
        } else if (i3 < 0) {
            this.F = 0;
        } else {
            this.F = i3;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.f315360e != 0) {
            getHeight();
            this.J.setColor(this.E);
            this.J.setAlpha(this.F);
            if (this.f315359d.getChildAt(this.f315361f) != null) {
                g(canvas);
            }
            for (int i3 = 0; i3 < this.f315360e; i3++) {
                if (this.Q.get(i3)) {
                    RedTouch redTouch = (RedTouch) this.f315359d.getChildAt(i3);
                    TextView textView = (TextView) redTouch.getTarget();
                    int right = redTouch.getRight() - textView.getPaddingRight();
                    int top = textView.getTop();
                    int i16 = right - this.G;
                    int dip2px = ViewUtils.dip2px(10.0f);
                    this.U.setBounds(i16, top, i16 + dip2px, dip2px + top);
                    this.U.draw(canvas);
                }
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        com.tencent.mobileqq.activity.contacts.base.tabs.e eVar;
        int action = motionEvent.getAction();
        if (action != 0) {
            if ((action == 1 || action == 3) && (eVar = this.M) != null) {
                eVar.d(false);
            }
        } else {
            com.tencent.mobileqq.activity.contacts.base.tabs.e eVar2 = this.M;
            if (eVar2 != null) {
                eVar2.d(true);
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.tencent.mobileqq.activity.contacts.base.tabs.e eVar;
        int action = motionEvent.getAction();
        if ((action == 1 || action == 3) && (eVar = this.M) != null) {
            eVar.d(false);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void p(int i3, int i16, int i17) {
        this.C = getResources().getColor(i3);
        this.D = getResources().getColor(i16);
        this.E = getResources().getColor(i17);
        r(this.f315361f);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(int i3) {
        if (this.f315360e == 0) {
            return;
        }
        setAccessibilityMsg();
        View childAt = this.f315359d.getChildAt(i3);
        if (childAt != null) {
            int scrollX = getScrollX();
            int i16 = this.G * 3;
            int right = ((childAt.getRight() - scrollX) + i16) - getWidth();
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(int i3) {
        int childCount = this.f315359d.getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            TextView textView = (TextView) ((RedTouch) this.f315359d.getChildAt(i16)).getTarget();
            if (i16 == i3) {
                textView.setTextColor(this.C);
            } else {
                textView.setTextColor(this.D);
            }
        }
    }

    protected void s(int i3, boolean z16, boolean z17) {
        int i16 = this.f315361f;
        if (i16 != i3 && i16 >= 0) {
            this.f315362h = i16;
            this.f315361f = i3;
            r(i3);
            q(this.f315361f);
            if (z16) {
                d();
            } else {
                if (this.f315359d.getChildAt(this.f315361f) != null) {
                    this.V = h();
                }
                invalidate();
            }
            f fVar = this.L;
            if (fVar != null) {
                fVar.I0(i3, z17);
            }
        }
    }

    public void setAccessibilityMsg() {
        boolean z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("talkback_fix_enable_2") && AppSetting.f99565y) {
            for (int i3 = 0; i3 < this.f315360e; i3++) {
                View childAt = this.f315359d.getChildAt(i3);
                if (childAt != null) {
                    String str = this.f315363i[i3];
                    if (i3 == this.f315361f) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    childAt.setSelected(z16);
                    childAt.setContentDescription(str);
                }
            }
        }
    }

    public void setCheckedTextColor(int i3) {
        this.C = i3;
    }

    public void setCurrentPosition(int i3, boolean z16) {
        s(i3, z16, false);
    }

    public void setCurrentPositionFromUserClick(int i3, boolean z16) {
        s(i3, z16, true);
    }

    public void setIndicatorColor(int i3) {
        this.E = i3;
    }

    public void setInterceptListener(com.tencent.mobileqq.activity.contacts.base.tabs.e eVar) {
        this.M = eVar;
    }

    public void setItemContentPaddingLR(int i3) {
        this.R = i3;
    }

    public void setOnAddTabListener(d dVar) {
        this.T = dVar;
    }

    public void setOnTabClickListener(e eVar) {
        this.N = eVar;
    }

    public void setOnTabListener(f fVar) {
        this.L = fVar;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i3) {
        super.setOverScrollMode(2);
    }

    public void setTabData(String[] strArr, int[] iArr) {
        if (strArr != null && strArr.length != 0 && iArr != null && iArr.length == strArr.length) {
            this.f315363i = (String[]) strArr.clone();
            int[] iArr2 = (int[]) iArr.clone();
            this.f315364m = iArr2;
            if (iArr2.length > 6) {
                this.I = true;
            }
            n();
        }
    }

    public void setUnCheckedTextColor(int i3) {
        this.D = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t(int i3, View view) {
        view.setOnClickListener(new b(i3));
    }

    public void u(int i3) {
        this.Q.put(i3, true);
        invalidate();
    }

    public void v(int i3, BusinessInfoCheckUpdate.AppInfo appInfo) {
        RedTouch redTouch = (RedTouch) this.f315359d.findViewById(i3);
        if (redTouch != null) {
            redTouch.parseRedTouch(appInfo);
        }
    }

    public AbsSlidingIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbsSlidingIndicator(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315361f = 0;
        this.f315362h = 0;
        this.C = -16777216;
        this.D = -7829368;
        this.E = -16776961;
        this.F = 25;
        this.G = 6;
        this.H = 12;
        this.P = false;
        this.Q = new SparseBooleanArray();
        this.R = 30;
        this.S = 4;
        this.W = new c();
        setFillViewport(true);
        setWillNotDraw(false);
        setAccessibilityDelegate(new a());
    }
}
