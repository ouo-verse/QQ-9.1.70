package com.tencent.qqnt.aio.menu.ui;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.menu.MenuUtils;
import com.tencent.qqnt.aio.widget.BubblePopupWindow;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import com.tencent.qui.quiblurview.f;

/* compiled from: P */
/* loaded from: classes23.dex */
public class QQCustomMenuExpandableLayout extends RelativeLayout implements com.tencent.qqnt.aio.menu.ui.a {
    static IPatchRedirector $redirector_;

    /* renamed from: b0, reason: collision with root package name */
    private static final int f351514b0;

    /* renamed from: c0, reason: collision with root package name */
    private static final int f351515c0;

    /* renamed from: d0, reason: collision with root package name */
    private static final int f351516d0;

    /* renamed from: e0, reason: collision with root package name */
    private static final int f351517e0;

    /* renamed from: f0, reason: collision with root package name */
    private static final int f351518f0;
    private int C;
    private int D;
    private int E;
    private int F;
    private float G;
    private int H;
    private f I;
    private f J;
    private f K;
    private int L;
    private boolean M;
    private Integer N;
    private ViewGroup P;
    private ScrollView Q;
    private LinearLayout R;
    private QQBlurViewWrapper S;
    private View T;
    private boolean U;
    private Path V;
    private float W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f351519a0;

    /* renamed from: d, reason: collision with root package name */
    private BubblePopupWindow f351520d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.qqnt.aio.menu.ui.c f351521e;

    /* renamed from: f, reason: collision with root package name */
    private View.OnClickListener f351522f;

    /* renamed from: h, reason: collision with root package name */
    private Context f351523h;

    /* renamed from: i, reason: collision with root package name */
    private int f351524i;

    /* renamed from: m, reason: collision with root package name */
    private int f351525m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class a implements BubblePopupWindow.c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQCustomMenuExpandableLayout.this);
            }
        }

        @Override // com.tencent.qqnt.aio.widget.BubblePopupWindow.c
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QQCustomMenuExpandableLayout.e(QQCustomMenuExpandableLayout.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class b implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQCustomMenuExpandableLayout.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f351531d;

        c(int i3) {
            this.f351531d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQCustomMenuExpandableLayout.this, i3);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QQCustomMenuExpandableLayout.this.I((ImageView) view);
                QQCustomMenuExpandableLayout.e(QQCustomMenuExpandableLayout.this);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f351533d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.aio.menu.ui.d f351534e;

        d(int i3, com.tencent.qqnt.aio.menu.ui.d dVar) {
            this.f351533d = i3;
            this.f351534e = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QQCustomMenuExpandableLayout.this, Integer.valueOf(i3), dVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Object tag = view.getTag();
                if (tag instanceof com.tencent.qqnt.aio.menu.ui.d) {
                    com.tencent.qqnt.aio.menu.ui.d dVar = (com.tencent.qqnt.aio.menu.ui.d) tag;
                    dVar.h();
                    if (QQCustomMenuExpandableLayout.this.f351522f != null && !dVar.g()) {
                        QQCustomMenuExpandableLayout.this.f351522f.onClick(view);
                    }
                }
                QQCustomMenuExpandableLayout.this.f351520d.w();
                QQCustomMenuExpandableLayout.e(QQCustomMenuExpandableLayout.this);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface e {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class f extends LinearLayout {
        static IPatchRedirector $redirector_;

        public f(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQCustomMenuExpandableLayout.this, (Object) context);
            } else {
                setOrientation(0);
            }
        }

        @Override // android.view.ViewGroup, android.view.ViewManager
        public void addView(View view, ViewGroup.LayoutParams layoutParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) layoutParams);
            } else {
                view.setLayoutParams(layoutParams);
                addView(view);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48219);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
            return;
        }
        f351514b0 = ViewUtils.dip2px(60.0f);
        f351515c0 = ViewUtils.dip2px(76.0f);
        f351516d0 = ViewUtils.dip2px(44.0f);
        f351517e0 = ViewUtils.dip2px(16.0f);
        f351518f0 = ViewUtils.dip2px(6.0f);
    }

    public QQCustomMenuExpandableLayout(Context context) {
        super(context);
        int dpToPx;
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f351524i = 0;
        this.H = com.tencent.qqnt.aio.menu.ui.e.f351563b;
        this.L = ViewUtils.dip2px(4.0f);
        this.M = false;
        this.N = null;
        this.U = false;
        this.V = null;
        this.W = 0.0f;
        this.f351519a0 = false;
        this.f351523h = context;
        MenuUtils menuUtils = MenuUtils.f351230a;
        float k3 = menuUtils.k(context);
        boolean n3 = menuUtils.n(context);
        this.f351525m = (int) (f351514b0 * k3);
        this.C = (int) (f351515c0 * k3);
        this.D = (int) (f351517e0 * k3);
        this.F = (int) (f351518f0 * k3);
        if (n3) {
            dpToPx = ViewUtils.dpToPx(4.0f);
        } else {
            dpToPx = ViewUtils.dpToPx(8.0f);
        }
        this.E = dpToPx;
        if (n3) {
            f16 = 10.7f;
        } else {
            f16 = 13.0f;
        }
        this.G = f16;
    }

    private Path A() {
        if (this.V == null) {
            this.V = new Path();
        }
        this.V.reset();
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        float dip2px = ViewUtils.dip2px(this.W);
        this.V.addRoundRect(rectF, dip2px, dip2px, Path.Direction.CCW);
        return this.V;
    }

    private StateListDrawable B() {
        GradientDrawable C = C(true);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.setExitFadeDuration(400);
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, C);
        return stateListDrawable;
    }

    private float[] D() {
        int i3 = this.L;
        return new float[]{i3, i3, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    private float[] E() {
        int i3 = this.L;
        return new float[]{0.0f, 0.0f, i3, i3, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    private boolean F() {
        com.tencent.qqnt.aio.menu.ui.c cVar = this.f351521e;
        if (cVar != null && cVar.d() > 0) {
            int i3 = 0;
            int i16 = 0;
            for (int i17 = 0; i17 < this.f351521e.d(); i17++) {
                com.tencent.qqnt.aio.menu.ui.d b16 = this.f351521e.b(i17);
                if (b16 != null) {
                    String title = b16.getTitle();
                    if (TextUtils.isEmpty(title)) {
                        continue;
                    } else {
                        int length = title.length();
                        if (i3 >= 4 && length >= 4) {
                            int d16 = this.f351521e.d();
                            int i18 = this.H;
                            if (d16 <= i18 || i16 != i18 - 1) {
                                return true;
                            }
                        }
                        i16 = i17;
                        i3 = length;
                    }
                }
            }
        }
        return false;
    }

    private void H() {
        removeAllViews();
        boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
        int d16 = this.f351521e.d();
        if (QLog.isColorLevel()) {
            QLog.d("QQCustomMenuExpandableLayout", 2, "[menu] showMenu size: " + d16);
        }
        n();
        ScrollView scrollView = new ScrollView(this.f351523h);
        this.Q = scrollView;
        scrollView.setVerticalScrollBarEnabled(false);
        this.Q.setOverScrollMode(2);
        this.Q.setFillViewport(true);
        this.Q.setOnTouchListener(new b());
        LinearLayout linearLayout = new LinearLayout(this.f351523h);
        this.R = linearLayout;
        linearLayout.setOrientation(1);
        this.Q.addView(this.R);
        q(isNowThemeIsNight, d16, F());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.P != null) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, f351516d0);
            layoutParams2.addRule(14);
            addView(this.P, layoutParams2);
            View view = new View(this.f351523h);
            view.setBackgroundColor(Color.parseColor("#1AFFFFFF"));
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((this.f351525m * this.H) - (this.E * 2), ViewUtils.dip2px(0.5f));
            layoutParams3.addRule(14);
            layoutParams3.addRule(3, this.P.getId());
            addView(view, layoutParams3);
            layoutParams.addRule(3, this.P.getId());
        }
        int i3 = this.E;
        layoutParams.setMargins(i3, 0, i3, 0);
        addView(this.Q, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(ImageView imageView) {
        int i3;
        int i16;
        float f16;
        int i17;
        if (this.Q != null && this.K != null) {
            this.f351519a0 = !this.f351519a0;
            float f17 = 1.0f;
            PathInterpolator pathInterpolator = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
            boolean z16 = this.f351519a0;
            if (z16) {
                i3 = com.tencent.mobileqq.R.drawable.qui_chevron_up_filled_new;
            } else {
                i3 = com.tencent.mobileqq.R.drawable.qui_chevron_down_filled_new;
            }
            if (z16) {
                i16 = com.tencent.mobileqq.R.string.qnx;
            } else {
                i16 = com.tencent.mobileqq.R.string.qnw;
            }
            imageView.setContentDescription(HardCodeUtil.qqStr(i16));
            imageView.setImageDrawable(ie0.a.f().o(this.f351523h, i3, com.tencent.mobileqq.R.color.qui_common_icon_white, 1000));
            boolean z17 = this.f351519a0;
            if (z17) {
                f16 = 0.0f;
            } else {
                f16 = 1.0f;
            }
            if (!z17) {
                f17 = 0.0f;
            }
            if (z17) {
                i17 = this.C * 2;
            } else {
                i17 = 0;
            }
            if (z17) {
                this.I.animate().alpha(f16).setDuration(200L).setInterpolator(pathInterpolator);
            } else {
                this.I.setAlpha(0.0f);
                this.I.setVisibility(0);
                this.I.animate().alpha(f16).setDuration(200L).setInterpolator(pathInterpolator);
            }
            if (this.f351519a0) {
                this.K.setVisibility(0);
                this.K.setAlpha(0.0f);
            }
            this.K.animate().alpha(f17).setDuration(200L).setInterpolator(pathInterpolator);
            this.Q.post(new Runnable(i17, pathInterpolator) { // from class: com.tencent.qqnt.aio.menu.ui.QQCustomMenuExpandableLayout.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f351526d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ PathInterpolator f351527e;

                {
                    this.f351526d = i17;
                    this.f351527e = pathInterpolator;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, QQCustomMenuExpandableLayout.this, Integer.valueOf(i17), pathInterpolator);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    ObjectAnimator ofInt = ObjectAnimator.ofInt(QQCustomMenuExpandableLayout.this.Q, "scrollY", QQCustomMenuExpandableLayout.this.Q.getScrollY(), this.f351526d);
                    ofInt.setDuration(200L);
                    ofInt.setInterpolator(this.f351527e);
                    ofInt.start();
                    QQCustomMenuExpandableLayout.this.Q.postDelayed(new Runnable() { // from class: com.tencent.qqnt.aio.menu.ui.QQCustomMenuExpandableLayout.4.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else if (!QQCustomMenuExpandableLayout.this.f351519a0) {
                                QQCustomMenuExpandableLayout.this.K.setVisibility(4);
                            }
                        }
                    }, 200L);
                }
            });
        }
    }

    static /* bridge */ /* synthetic */ e e(QQCustomMenuExpandableLayout qQCustomMenuExpandableLayout) {
        qQCustomMenuExpandableLayout.getClass();
        return null;
    }

    private View m() {
        return new View(getContext());
    }

    private void n() {
        boolean z16;
        if (!c()) {
            setBackgroundResource(com.tencent.mobileqq.R.drawable.jwi);
            return;
        }
        setBackgroundResource(com.tencent.mobileqq.R.color.ajr);
        if (this.S == null) {
            this.S = new QQBlurViewWrapper(this.f351523h);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            z16 = true;
        } else {
            z16 = false;
        }
        f.a aVar = new f.a(z16, 64.0f, null, -1, new ColorDrawable(this.f351523h.getColor(com.tencent.mobileqq.R.color.cdl)), Integer.valueOf(com.tencent.mobileqq.R.drawable.jwh));
        aVar.o(true);
        this.S.a(aVar);
        this.S.setDebugTag("CustomMenu");
        View view = this.T;
        if (view != null) {
            this.S.setBlurSource(view, null, null);
        }
        this.S.setVisibility(8);
        if (this.S != null) {
            addView(this.S, new RelativeLayout.LayoutParams(-2, -2));
        }
        this.U = false;
    }

    private View o() {
        View view = new View(this.f351523h);
        view.setBackgroundColor(Color.parseColor("#1AFFFFFF"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ViewUtils.dip2px(0.5f));
        int i3 = this.E;
        layoutParams.setMargins(i3 * 2, 0, i3 * 2, 0);
        view.setLayoutParams(layoutParams);
        return view;
    }

    private View p(int i3, com.tencent.qqnt.aio.menu.ui.d dVar, boolean z16, float[] fArr) {
        StateListDrawable B = B();
        String title = dVar.getTitle();
        if (this.M && title.length() > 4) {
            title = title.substring(0, 3) + "\u2026";
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        linearLayout.setTag(dVar);
        linearLayout.setBackgroundDrawable(B);
        linearLayout.setOnClickListener(new d(i3, dVar));
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageResource(dVar.b());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.f351525m / 3);
        layoutParams.bottomMargin = this.F;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(getContext());
        textView.setText(title);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextSize(2, this.G);
        textView.setMaxLines(1);
        textView.setLetterSpacing((-0.5f) / TypedValue.applyDimension(2, this.G, getContext().getResources().getDisplayMetrics()));
        String a16 = dVar.a();
        if (a16 == null) {
            a16 = dVar.getTitle();
        }
        textView.setContentDescription(a16);
        textView.setId(dVar.c());
        textView.setTextColor(getContext().getColor(com.tencent.mobileqq.R.color.qui_common_text_allwhite_primary));
        textView.setIncludeFontPadding(true);
        textView.setGravity(17);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        return linearLayout;
    }

    private void q(boolean z16, int i3, boolean z17) {
        int i16 = this.H;
        if (i3 <= i16) {
            r(z16, i3, z17);
        } else if (i3 <= i16 * 2) {
            t(z16, i3, z17);
        } else {
            s(z16, i3, z17);
        }
    }

    private void r(boolean z16, int i3, boolean z17) {
        View p16;
        float[] x16;
        f fVar = new f(this.f351523h);
        this.I = fVar;
        fVar.setId(View.generateViewId());
        for (int i16 = 0; i16 < i3; i16++) {
            com.tencent.qqnt.aio.menu.ui.d b16 = this.f351521e.b(i16);
            if (b16 != null && b16.getTitle() != null) {
                QLog.d("QQCustomMenuExpandableLayout", 1, "fillMenu title=" + com.tencent.qqnt.aio.utils.b.c(b16.getTitle()));
            }
            if (i16 == 0) {
                int i17 = i16 + 1;
                if (i3 == 1) {
                    x16 = w();
                } else {
                    x16 = x();
                }
                p16 = p(i17, b16, z16, x16);
                AccessibilityUtil.l(this.f351523h, p16);
            } else if (i16 == i3 - 1) {
                p16 = p(i16 + 1, b16, z16, z());
            } else {
                p16 = p(i16 + 1, b16, z16, y());
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f351525m, -1);
            if (i16 > 0 && z17) {
                layoutParams.leftMargin = ViewUtils.dip2px(1.0f);
            }
            int i18 = this.D;
            p16.setPadding(0, i18, 0, i18);
            this.I.addView(p16, layoutParams);
        }
        this.R.addView(this.I, new LinearLayout.LayoutParams(-2, this.C));
    }

    private void s(boolean z16, int i3, boolean z17) {
        int i16;
        View p16;
        float[] y16;
        View p17;
        f fVar = new f(this.f351523h);
        this.I = fVar;
        fVar.setId(View.generateViewId());
        f fVar2 = new f(this.f351523h);
        this.J = fVar2;
        fVar2.setId(View.generateViewId());
        f fVar3 = new f(this.f351523h);
        this.K = fVar3;
        fVar3.setId(View.generateViewId());
        for (int i17 = 0; i17 < this.H; i17++) {
            com.tencent.qqnt.aio.menu.ui.d b16 = this.f351521e.b(i17);
            if (i17 == 0) {
                p17 = p(i17 + 1, b16, z16, D());
                AccessibilityUtil.l(this.f351523h, p17);
            } else if (i17 == this.H - 1) {
                p17 = p(i17 + 1, b16, z16, E());
            } else {
                p17 = p(i17 + 1, b16, z16, y());
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f351525m, -1);
            if (i17 > 0 && z17) {
                layoutParams.leftMargin = ViewUtils.dip2px(1.0f);
            }
            int i18 = this.D;
            p17.setPadding(0, i18, 0, i18);
            this.I.addView(p17, layoutParams);
        }
        int i19 = 0;
        while (true) {
            i16 = this.H;
            if (i19 >= i16 - 1) {
                break;
            }
            com.tencent.qqnt.aio.menu.ui.d b17 = this.f351521e.b(i16 + i19);
            if (i19 == 0) {
                int i26 = this.H + i19 + 1;
                if (i19 == 0) {
                    y16 = u();
                } else {
                    y16 = y();
                }
                p16 = p(i26, b17, z16, y16);
            } else {
                p16 = p(this.H + i19 + 1, b17, z16, y());
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.f351525m, -1);
            if (i19 > 0 && z17) {
                layoutParams2.leftMargin = ViewUtils.dip2px(1.0f);
            }
            int i27 = this.D;
            p16.setPadding(0, i27, 0, i27);
            this.J.addView(p16, layoutParams2);
            i19++;
        }
        ImageView l3 = l(i16 * 2);
        int i28 = this.D;
        l3.setPadding(0, i28, 0, i28);
        this.J.addView(l3, new LinearLayout.LayoutParams(this.f351525m, -1));
        int min = Math.min(i3 - ((r1 * 2) - 1), this.H);
        for (int i29 = 0; i29 < min; i29++) {
            View p18 = p((this.H * 2) + i29, this.f351521e.b(((this.H * 2) + i29) - 1), z16, y());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(this.f351525m, -1);
            if (i29 > 0 && z17) {
                layoutParams3.leftMargin = ViewUtils.dip2px(1.0f);
            }
            int i36 = this.D;
            p18.setPadding(0, i36, 0, i36);
            this.K.addView(p18, layoutParams3);
        }
        int i37 = this.H - min;
        for (int i38 = 0; i38 < i37; i38++) {
            View m3 = m();
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(this.f351525m, -1);
            layoutParams4.addRule(15);
            this.K.addView(m3, layoutParams4);
        }
        this.R.addView(this.I, new LinearLayout.LayoutParams(-2, this.C));
        MenuUtils menuUtils = MenuUtils.f351230a;
        if (menuUtils.l()) {
            this.R.addView(o());
        }
        this.R.addView(this.J, new LinearLayout.LayoutParams(-2, this.C));
        if (menuUtils.l()) {
            this.R.addView(o());
        }
        this.K.setVisibility(4);
        this.R.addView(this.K, new LinearLayout.LayoutParams(-2, this.C));
    }

    private void t(boolean z16, int i3, boolean z17) {
        int i16;
        View p16;
        View p17;
        f fVar = new f(this.f351523h);
        this.I = fVar;
        fVar.setId(View.generateViewId());
        f fVar2 = new f(this.f351523h);
        this.J = fVar2;
        fVar2.setId(View.generateViewId());
        int i17 = 0;
        while (true) {
            i16 = this.H;
            if (i17 >= i16) {
                break;
            }
            com.tencent.qqnt.aio.menu.ui.d b16 = this.f351521e.b(i17);
            if (i17 == 0) {
                p17 = p(i17 + 1, b16, z16, D());
                AccessibilityUtil.l(this.f351523h, p17);
            } else if (i17 == this.H - 1) {
                p17 = p(i17 + 1, b16, z16, E());
            } else {
                p17 = p(i17 + 1, b16, z16, y());
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f351525m, -1);
            if (i17 > 0 && z17) {
                layoutParams.leftMargin = ViewUtils.dip2px(1.0f);
            }
            int i18 = this.D;
            p17.setPadding(0, i18, 0, i18);
            this.I.addView(p17, layoutParams);
            i17++;
        }
        int i19 = i3 - i16;
        for (int i26 = 0; i26 < i19; i26++) {
            com.tencent.qqnt.aio.menu.ui.d b17 = this.f351521e.b(this.H + i26);
            if (i26 == 0) {
                p16 = p(this.H + i26 + 1, b17, z16, u());
            } else if (i26 == i19 - 1) {
                p16 = p(this.H + i26 + 1, b17, z16, v());
            } else {
                p16 = p(this.H + i26 + 1, b17, z16, y());
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.f351525m, -1);
            if (i26 > 0 && z17) {
                layoutParams2.leftMargin = ViewUtils.dip2px(1.0f);
            }
            int i27 = this.D;
            p16.setPadding(0, i27, 0, i27);
            this.J.addView(p16, layoutParams2);
        }
        int i28 = this.H - i19;
        for (int i29 = 0; i29 < i28; i29++) {
            View m3 = m();
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.f351525m, -1);
            layoutParams3.addRule(15);
            this.J.addView(m3, layoutParams3);
        }
        this.R.addView(this.I, new LinearLayout.LayoutParams(-2, this.C));
        if (MenuUtils.f351230a.l()) {
            this.R.addView(o());
        }
        this.R.addView(this.J, new LinearLayout.LayoutParams(-2, this.C));
    }

    private float[] u() {
        int i3 = this.L;
        return new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, i3, i3};
    }

    private float[] v() {
        int i3 = this.L;
        return new float[]{0.0f, 0.0f, 0.0f, 0.0f, i3, i3, 0.0f, 0.0f};
    }

    private float[] w() {
        int i3 = this.L;
        return new float[]{i3, i3, i3, i3, i3, i3, i3, i3};
    }

    private float[] x() {
        int i3 = this.L;
        return new float[]{i3, i3, 0.0f, 0.0f, 0.0f, 0.0f, i3, i3};
    }

    private float[] y() {
        return new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    private float[] z() {
        int i3 = this.L;
        return new float[]{0.0f, 0.0f, i3, i3, i3, i3, 0.0f, 0.0f};
    }

    protected GradientDrawable C(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (GradientDrawable) iPatchRedirector.redirect((short) 20, (Object) this, z16);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(this.f351523h.getResources().getColor(com.tencent.mobileqq.R.color.c4x));
        return gradientDrawable;
    }

    public void G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            H();
        }
    }

    @Override // com.tencent.qqnt.aio.menu.ui.a
    public Integer a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Integer) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.N;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.a
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.f351521e.d() >= this.H) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.a
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return MenuUtils.f351230a.b(this.f351521e);
    }

    @Override // com.tencent.qqnt.aio.menu.ui.a
    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.M;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.a
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        BubblePopupWindow bubblePopupWindow = this.f351520d;
        if (bubblePopupWindow != null) {
            bubblePopupWindow.w();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) canvas);
            return;
        }
        if (this.W > 0.0f) {
            i3 = canvas.save();
            canvas.clipPath(A());
        } else {
            i3 = -1;
        }
        super.dispatchDraw(canvas);
        if (i3 != -1) {
            canvas.restoreToCount(i3);
        }
    }

    protected ImageView l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (ImageView) iPatchRedirector.redirect((short) 14, (Object) this, i3);
        }
        StateListDrawable B = B();
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(ie0.a.f().o(this.f351523h, com.tencent.mobileqq.R.drawable.qui_chevron_down, com.tencent.mobileqq.R.color.qui_common_icon_white, 1000));
        imageView.setContentDescription(HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.qnw));
        imageView.setBackgroundDrawable(B);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setOnClickListener(new c(i3));
        AccessibilityUtil.l(this.f351523h, imageView);
        return imageView;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        int makeMeasureSpec;
        QQBlurViewWrapper qQBlurViewWrapper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (MenuUtils.f351230a.l()) {
            i17 = this.C * 2;
        } else {
            i17 = (this.C * 2) + f351516d0;
        }
        int mode = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i16);
        if (mode == 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i17, Integer.MIN_VALUE);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.min(size, i17), mode);
        }
        super.onMeasure(i3, makeMeasureSpec);
        if (!this.U && (qQBlurViewWrapper = this.S) != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) qQBlurViewWrapper.getLayoutParams();
            layoutParams.width = getMeasuredWidth();
            layoutParams.height = getMeasuredHeight();
            this.S.setLayoutParams(layoutParams);
            this.S.setVisibility(0);
            View view = this.T;
            if (view != null) {
                view.postInvalidate();
            }
            this.U = true;
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.removeAllViews();
        this.I = null;
        this.J = null;
        this.K = null;
    }

    public void setContainerBottom(Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) num);
        } else {
            this.N = num;
        }
    }

    public void setIgnoreTouchLocation(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.M = z16;
        }
    }

    public void setMenu(com.tencent.qqnt.aio.menu.ui.c cVar, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar, (Object) view);
            return;
        }
        this.f351521e = cVar.c();
        this.T = view;
        if (QLog.isColorLevel()) {
            QLog.d("QQCustomMenuExpandableLayout", 4, "[menu] setMenu MENU:" + this.f351521e.toString() + ", mSourceView = " + this.T);
        }
    }

    public void setMenuCreateOrClickCallback(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) eVar);
        }
    }

    public void setMenuIconClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) onClickListener);
        } else {
            this.f351522f = onClickListener;
        }
    }

    public void setPopupWindow(BubblePopupWindow bubblePopupWindow, BubblePopupWindow.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bubblePopupWindow, (Object) fVar);
            return;
        }
        this.f351520d = bubblePopupWindow;
        bubblePopupWindow.r(new a());
        this.f351520d.O(fVar);
    }

    public void setTopContainer(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) viewGroup);
        } else if (viewGroup != null) {
            this.P = viewGroup;
            viewGroup.setId(View.generateViewId());
        }
    }

    public void setViewRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Float.valueOf(f16));
        } else {
            this.W = f16;
        }
    }
}
