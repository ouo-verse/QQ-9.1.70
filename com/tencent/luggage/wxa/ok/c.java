package com.tencent.luggage.wxa.ok;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.tencent.luggage.wxa.fd.e0;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.mo.y;
import com.tencent.luggage.wxa.n4.a;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.wj.c;
import com.tencent.luggage.wxa.wj.e;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.modelappbrand.image.WxaIconTransformation;
import com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl;
import com.tencent.mm.plugin.appbrand.ui.AppBrandCircleProgressView;
import com.tencent.mm.plugin.appbrand.ui.WxaDefaultIcon;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes8.dex */
public class c extends h implements l {
    public com.tencent.luggage.wxa.ic.g I;
    public int J;
    public ImageView K;
    public TextView L;
    public AppBrandCircleProgressView M;
    public ViewGroup N;
    public TextView O;
    public Function0 P;
    public Boolean Q;
    public ViewStub R;
    public ViewStub S;
    public com.tencent.luggage.wxa.fd.r T;
    public com.tencent.luggage.wxa.ok.d U;
    public FrameLayout V;
    public boolean W;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f136558a0;

    /* renamed from: b0, reason: collision with root package name */
    public final Set f136559b0;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.lj.d dVar;
            com.tencent.luggage.wxa.ic.g gVar = c.this.I;
            if (gVar != null && gVar.M() != null) {
                dVar = (com.tencent.luggage.wxa.lj.d) c.this.I.M().b(c.this.getContext(), com.tencent.luggage.wxa.lj.d.class);
            } else {
                dVar = new com.tencent.luggage.wxa.lj.d(c.this.getContext());
            }
            c.this.setActionBar(dVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f136561a;

        public b(Activity activity) {
            this.f136561a = activity;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            int i3;
            c.C6887c statusBar;
            if (c.this.V == null) {
                return true;
            }
            c.this.V.getViewTreeObserver().removeOnPreDrawListener(this);
            int i16 = 0;
            if (c.this.getWindowAndroid() != null && (statusBar = c.this.getWindowAndroid().getStatusBar()) != null) {
                if (c.this.getWindowAndroid().getOrientationHandler().a() == e.b.PORTRAIT) {
                    c.this.a(statusBar.f144267a);
                } else {
                    c cVar = c.this;
                    if (statusBar.f144268b == 0) {
                        i16 = statusBar.f144267a;
                    }
                    cVar.a(i16);
                }
                return true;
            }
            if (com.tencent.luggage.wxa.bo.a.a(c.this.getContext()) == null) {
                return true;
            }
            int[] iArr = new int[2];
            c.this.getLocationInWindow(iArr);
            if (iArr[1] != 0) {
                return true;
            }
            if (com.tencent.luggage.wxa.ok.g.i(this.f136561a)) {
                c.this.a(0);
                return true;
            }
            WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(c.this);
            if (rootWindowInsets != null && (i3 = rootWindowInsets.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.statusBars()).top) > 0) {
                c.this.a(i3);
            }
            return true;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ok.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6555c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewParent f136563a;

        public RunnableC6555c(ViewParent viewParent) {
            this.f136563a = viewParent;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.d("MicroMsg.AppBrandUILoadingSplash", "animateHide, remove splash");
            c.this.setVisibility(8);
            ((ViewGroup) this.f136563a).removeView(c.this);
            c.this.p();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Runnable {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f136566a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ViewParent f136567b;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.ok.c$d$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC6556a implements Runnable {
                public RunnableC6556a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    w.d("MicroMsg.AppBrandUILoadingSplash", "animateHide, hide ends && remove splash");
                    c.this.setVisibility(8);
                    a aVar = a.this;
                    ((ViewGroup) aVar.f136567b).removeView(c.this);
                    c.this.p();
                }
            }

            public a(int i3, ViewParent viewParent) {
                this.f136566a = i3;
                this.f136567b = viewParent;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                int argb = Color.argb(intValue, Color.red(this.f136566a), Color.green(this.f136566a), Color.blue(this.f136566a));
                c.this.N.setBackgroundColor(argb);
                c.super.a(argb, !r1.t());
                if (intValue == 0) {
                    c.this.post(new RunnableC6556a());
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f136570a;

            public b(int i3) {
                this.f136570a = i3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                c.this.L.setTextColor(Color.argb(Math.round(255.0f * floatValue), Color.red(this.f136570a), Color.green(this.f136570a), Color.blue(this.f136570a)));
                c.this.M.setAlpha(floatValue);
                c.this.K.setAlpha(floatValue);
                c.this.S.setAlpha(floatValue);
                c cVar = c.this;
                cVar.a(cVar.getBgColor(), !c.this.t());
            }
        }

        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w.d("MicroMsg.AppBrandUILoadingSplash", "animateHide, start hide with animation");
            ViewParent parent = c.this.getParent();
            if (!(parent instanceof ViewGroup)) {
                w.d("MicroMsg.AppBrandUILoadingSplash", "animateHide, wrong ViewGroup");
                return;
            }
            c.this.M.a();
            ValueAnimator ofInt = ValueAnimator.ofInt(255, 0);
            ofInt.addUpdateListener(new a(c.this.getBgColor(), parent));
            ofInt.setStartDelay(Math.round(160.0f));
            ofInt.setDuration(Math.round(40.0f));
            ofInt.setInterpolator(new FastOutLinearInInterpolator());
            ofInt.start();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.setDuration(Math.round(160.0f));
            ofFloat.addUpdateListener(new b(c.this.getNameTextColor()));
            ofFloat.setInterpolator(new FastOutSlowInInterpolator());
            ofFloat.start();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = c.this;
            com.tencent.luggage.wxa.ic.g gVar = cVar.I;
            if (gVar != null) {
                if (cVar.f136558a0) {
                    return;
                }
                com.tencent.luggage.wxa.ic.e.a(gVar.getAppId(), e.d.CLOSE);
                c.this.I.D();
                return;
            }
            if (cVar.P != null) {
                c.this.P.invoke();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class f {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f136573a;

        static {
            int[] iArr = new int[com.tencent.luggage.wxa.fd.r.values().length];
            f136573a = iArr;
            try {
                iArr[com.tencent.luggage.wxa.fd.r.FORCE_LIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f136573a[com.tencent.luggage.wxa.fd.r.FORCE_DARK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface g {
    }

    public c(Context context) {
        super(context);
        this.T = com.tencent.luggage.wxa.fd.r.NORMAL;
        this.W = true;
        this.f136558a0 = false;
        this.f136559b0 = new LinkedHashSet();
        this.J = 0;
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBgColor() {
        int i3 = f.f136573a[this.T.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return getResources().getColor(R.color.agv);
            }
            return Color.parseColor("#191919");
        }
        return getResources().getColor(R.color.f156699b25);
    }

    @Nullable
    private com.tencent.luggage.wxa.lj.d getCapsuleBarImplView() {
        View findViewById = findViewById(R.id.f164368st0);
        if (findViewById instanceof com.tencent.luggage.wxa.lj.d) {
            return (com.tencent.luggage.wxa.lj.d) findViewById;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNameTextColor() {
        int i3 = f.f136573a[this.T.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return getResources().getColor(R.color.c7u);
            }
            return Color.parseColor("#CCFFFFFF");
        }
        return Color.parseColor("#E6000000");
    }

    public int getLayoutId() {
        return R.layout.dxv;
    }

    public int getProgress() {
        return this.M.getProgress();
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.ok.i
    public String m() {
        String appId;
        com.tencent.luggage.wxa.ic.g gVar = this.I;
        if (gVar == null) {
            appId = "null";
        } else {
            appId = gVar.getAppId();
        }
        return "AppBrandUILoadingSplash:" + appId;
    }

    public void n() {
        com.tencent.luggage.wxa.ok.b.a(this.K, this.M, this.L);
    }

    public final boolean o() {
        com.tencent.luggage.wxa.ic.g gVar = this.I;
        if (gVar != null && (gVar instanceof com.tencent.luggage.wxa.c5.e) && ((com.tencent.luggage.wxa.c5.e) gVar).y1()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.ok.i, com.tencent.mm.ui.statusbar.DrawStatusBarFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(getBgColor(), !t());
        this.M.b();
        try {
            a(getContext().getResources().getConfiguration());
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View
    public void onCancelPendingInputEvents() {
        super.onCancelPendingInputEvents();
        com.tencent.luggage.wxa.lj.d capsuleBarImplView = getCapsuleBarImplView();
        if (capsuleBarImplView != null) {
            capsuleBarImplView.cancelPendingInputEvents();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            a(configuration);
        } catch (Exception unused) {
        }
        if (this.U != null) {
            try {
                this.U.a(this.I.n0().getOrientationHandler().a());
            } catch (Exception unused2) {
            }
        }
    }

    public final void p() {
        LinkedList linkedList = new LinkedList(this.f136559b0);
        this.f136559b0.clear();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((Function0) it.next()).invoke();
        }
    }

    @Override // com.tencent.luggage.wxa.ok.i, android.view.View
    public final boolean post(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        if (!ViewCompat.isAttachedToWindow(this) && o()) {
            c0.a(runnable);
            return true;
        }
        return super.post(runnable);
    }

    @Override // com.tencent.luggage.wxa.ok.i, android.view.View
    public final boolean postDelayed(Runnable runnable, long j3) {
        if (runnable == null) {
            return false;
        }
        if (!ViewCompat.isAttachedToWindow(this) && o()) {
            c0.a(runnable, j3);
            return true;
        }
        return super.postDelayed(runnable, j3);
    }

    public View.OnClickListener q() {
        return new e();
    }

    public void r() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
        this.L = (TextView) findViewById(R.id.sra);
        AppBrandCircleProgressView appBrandCircleProgressView = (AppBrandCircleProgressView) findViewById(R.id.tww);
        this.M = appBrandCircleProgressView;
        appBrandCircleProgressView.setCircleColor(ContextCompat.getColor(getContext(), R.color.f156611ai0));
        this.M.setDotWidth(getResources().getDimensionPixelSize(R.dimen.f158328c24));
        this.M.setDotColor(ContextCompat.getColor(getContext(), R.color.ap8));
        this.M.setCircleStrokeWidth(getResources().getDimensionPixelSize(R.dimen.f158327c23));
        this.M.setProgressColor(ContextCompat.getColor(getContext(), R.color.ap8));
        this.M.setProgressWidth(getResources().getDimensionPixelSize(R.dimen.f158329c25));
        if (z.m()) {
            this.M.setTransitionTimingMs(Integer.MAX_VALUE);
        }
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.srb);
        this.N = viewGroup;
        com.tencent.luggage.wxa.mo.z.a(viewGroup, ImageView.class, new y() { // from class: o31.a
            @Override // com.tencent.luggage.wxa.mo.y
            public final void a(View view) {
                com.tencent.luggage.wxa.ok.c.this.a((ImageView) view);
            }
        });
        n();
        this.R = (ViewStub) findViewById(R.id.t_s);
        this.S = (ViewStub) findViewById(R.id.yci);
        this.V = (FrameLayout) findViewById(R.id.f164369st1);
        x();
        com.tencent.luggage.wxa.e5.g.a("AppBrandUILoadingSplash setupRightButton", new a());
        this.L.getLayoutParams().height = com.tencent.luggage.wxa.il.b.a(getContext());
        if (this.I != null) {
            u();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(R.id.sra));
        arrayList.add(Integer.valueOf(R.id.s_g));
        arrayList.add(Integer.valueOf(R.id.s_f));
        com.tencent.luggage.wxa.ok.a.a(arrayList, getView());
        s();
    }

    public final void s() {
        if (findViewById(R.id.f164370st2) != null) {
            w.d("MicroMsg.AppBrandUILoadingSplash", "initPlayabelView has inited");
            return;
        }
        a.b bVar = a.b.f135289a;
        if (bVar.a() != null && this.I != null) {
            boolean z16 = false;
            try {
                com.tencent.luggage.wxa.xa.e eVar = new com.tencent.luggage.wxa.xa.e(bVar.a().b("clicfg_sns_playable_weapp_loading_view_config_android"));
                String appId = this.I.getAppId();
                w.d("MicroMsg.AppBrandUILoadingSplash", String.format("initPlayabelView allow list:%s appid:%s", eVar, appId));
                int length = eVar.length();
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (w0.a(eVar.getString(i3), appId)) {
                        z16 = true;
                        break;
                    }
                    i3++;
                }
            } catch (com.tencent.luggage.wxa.xa.f e16) {
                w.f("MicroMsg.AppBrandUILoadingSplash", "get clicfg_sns_playable_weapp_loading_view_config_android error" + e16.getMessage());
            }
            if (!z16) {
                w.f("MicroMsg.AppBrandUILoadingSplash", "initPlayabelView not match allow list");
                return;
            }
            View view = new View(getContext());
            view.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-17548, -748993}));
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            view.setId(R.id.f164370st2);
            this.N.addView(view);
            this.V.bringToFront();
        }
    }

    public void setActionBar(View view) {
        View findViewById = this.V.findViewById(R.id.f164368st0);
        if (findViewById != null) {
            this.V.removeView(findViewById);
        }
        view.setId(R.id.f164368st0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.N.getResources().getDimensionPixelSize(R.dimen.bfh));
        layoutParams.gravity = 8388661;
        this.V.addView(view, layoutParams);
    }

    @Override // com.tencent.luggage.wxa.ok.i, com.tencent.luggage.wxa.ok.j
    public void setAppServiceType(int i3) {
        if (i3 != this.J) {
            this.J = i3;
            if (ViewCompat.isAttachedToWindow(this)) {
                try {
                    a(getContext().getResources().getConfiguration());
                } catch (Exception unused) {
                }
            }
            a(getCapsuleBarImplView());
        }
    }

    @Override // com.tencent.luggage.wxa.ok.i, com.tencent.luggage.wxa.ok.j
    public void setCanShowHideAnimation(boolean z16) {
        this.W = z16;
    }

    @Override // com.tencent.luggage.wxa.ok.i, com.tencent.luggage.wxa.ok.j
    public void setProgress(int i3) {
        this.M.setProgress(i3);
    }

    public void setTheme(com.tencent.luggage.wxa.fd.r rVar) {
        this.T = rVar;
        this.N.setBackgroundColor(getBgColor());
        this.L.setTextColor(getNameTextColor());
    }

    public final boolean t() {
        if (this.T == com.tencent.luggage.wxa.fd.r.FORCE_LIGHT) {
            return false;
        }
        if (this.Q == null) {
            this.Q = Boolean.valueOf(com.tencent.luggage.wxa.h6.l.f126905a.c());
        }
        return this.Q.booleanValue();
    }

    public final void u() {
        int i3;
        int i16;
        com.tencent.luggage.wxa.er.a.a(this.I);
        View.OnClickListener q16 = q();
        com.tencent.luggage.wxa.lj.d capsuleBarImplView = getCapsuleBarImplView();
        if (capsuleBarImplView != null) {
            if (t()) {
                i3 = -1;
            } else {
                i3 = -16777216;
            }
            capsuleBarImplView.setStyleColor(i3);
            capsuleBarImplView.setHomeButtonOnClickListener(q16);
            if (this.I.S() instanceof com.tencent.luggage.wxa.j4.d) {
                i16 = ((com.tencent.luggage.wxa.j4.d) this.I.S()).I;
            } else {
                i16 = 0;
            }
            setAppServiceType(i16);
        }
    }

    public void v() {
        View inflate;
        ViewStub viewStub = (ViewStub) findViewById(R.id.sun);
        if (viewStub == null || (inflate = viewStub.inflate()) == null) {
            return;
        }
        this.U = new com.tencent.luggage.wxa.ok.d(this.I, inflate);
    }

    public void w() {
        c(R.string.z3i);
        try {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.O.getLayoutParams();
            layoutParams.topToBottom = R.id.sra;
            layoutParams.bottomToBottom = -1;
            TextView textView = this.O;
            textView.setPadding(textView.getPaddingLeft(), getContext().getResources().getDimensionPixelSize(R.dimen.bif), this.O.getPaddingRight(), this.O.getPaddingBottom());
            this.O.requestLayout();
        } catch (Exception unused) {
        }
    }

    public final void x() {
        Activity activity;
        WindowAndroidActivityImpl b16;
        a(true);
        if (getWindowAndroid() != null && (b16 = WindowAndroidActivityImpl.b(getWindowAndroid())) != null) {
            activity = b16.j();
        } else {
            activity = null;
        }
        if (activity == null) {
            activity = com.tencent.luggage.wxa.bo.a.a(getContext());
        }
        if (activity != null) {
            ViewCompat.requestApplyInsets(this);
        }
        FrameLayout frameLayout = this.V;
        if (frameLayout != null) {
            frameLayout.getViewTreeObserver().addOnPreDrawListener(new b(activity));
        }
    }

    @Override // com.tencent.luggage.wxa.ok.j
    public void c(Function0 function0) {
        Object[] objArr = new Object[3];
        com.tencent.luggage.wxa.ic.g gVar = this.I;
        objArr[0] = gVar == null ? "null" : gVar.getAppId();
        objArr[1] = Boolean.valueOf(this.W);
        objArr[2] = Boolean.valueOf(this.f136558a0);
        w.d("MicroMsg.AppBrandUILoadingSplash", "animateHide appId[%s] mCanShowHideAnimation[%b], mIsHideInvoked[%b]", objArr);
        if (function0 != null) {
            this.f136559b0.add(function0);
        }
        if (this.f136558a0) {
            return;
        }
        this.f136558a0 = true;
        if (!this.W) {
            w.d("MicroMsg.AppBrandUILoadingSplash", "animateHide, start hide without animation");
            ViewParent parent = getParent();
            if (!(parent instanceof ViewGroup)) {
                w.d("MicroMsg.AppBrandUILoadingSplash", "animateHide, wrong ViewGroup");
                return;
            } else {
                post(new RunnableC6555c(parent));
                return;
            }
        }
        post(new d());
    }

    @Override // com.tencent.mm.ui.statusbar.DrawStatusBarFrameLayout, com.tencent.mm.ui.statusbar.a.d
    public void a(int i3) {
        super.a(i3);
        w.a("MicroMsg.AppBrandUILoadingSplash", "onStatusBarHeightChange height:%d, stack:%s", Integer.valueOf(i3), Log.getStackTraceString(new Throwable()));
        FrameLayout frameLayout = this.V;
        if (frameLayout != null) {
            frameLayout.setTranslationY(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ImageView imageView) {
        imageView.setId(R.id.sr9);
        this.K = imageView;
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.bir), getContext().getResources().getDimensionPixelSize(R.dimen.bir));
        layoutParams.leftToLeft = R.id.tww;
        layoutParams.rightToRight = R.id.tww;
        layoutParams.topToTop = R.id.tww;
        layoutParams.bottomToBottom = R.id.tww;
        imageView.setLayoutParams(layoutParams);
        imageView.setImageDrawable(WxaDefaultIcon.get());
    }

    public c(Context context, @NonNull com.tencent.luggage.wxa.ic.g gVar) {
        super(context);
        this.T = com.tencent.luggage.wxa.fd.r.NORMAL;
        this.W = true;
        this.f136558a0 = false;
        this.f136559b0 = new LinkedHashSet();
        this.I = gVar;
        this.J = gVar.S() instanceof com.tencent.luggage.wxa.j4.d ? ((com.tencent.luggage.wxa.j4.d) this.I.S()).I : 0;
        r();
    }

    public final void c(int i3) {
        if (this.O == null) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.sum);
            if (viewStub == null) {
                return;
            } else {
                this.O = (TextView) viewStub.inflate();
            }
        }
        TextView textView = this.O;
        if (textView == null) {
            return;
        }
        textView.setVisibility(0);
        this.O.setText(i3);
    }

    public void a(com.tencent.luggage.wxa.ic.g gVar) {
        w.a("MicroMsg.AppBrandUILoadingSplash", "attachRuntime %s", gVar.S().f125809b);
        this.I = gVar;
        if (gVar.L() != null) {
            a(gVar.L());
        }
        u();
        s();
    }

    @Override // com.tencent.luggage.wxa.ok.i, com.tencent.luggage.wxa.ok.j
    @NotNull
    public View getView() {
        return this;
    }

    public final void a(Context context) {
        if (getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) getContext()).setBaseContext(context);
            a(getBgColor(), !t());
        }
    }

    @Override // com.tencent.luggage.wxa.ok.j
    public void a(String str, String str2) {
        AppBrandSimpleImageLoader.instance().attach(this.K, str, (Drawable) null, WxaIconTransformation.INSTANCE);
        this.L.setText(str2);
    }

    public final void a(com.tencent.luggage.wxa.lj.d dVar) {
        Context context;
        com.tencent.luggage.wxa.ic.g gVar = this.I;
        if (gVar != null && gVar.L() != null && this.I.M() != null) {
            context = this.I.M().a(this.I.L(), com.tencent.luggage.wxa.kl.b.class);
        } else {
            context = dVar.getContext();
        }
        if (e0.a(this.J)) {
            dVar.getLayoutParams().height = context.getResources().getDimensionPixelSize(R.dimen.c1h);
            com.tencent.luggage.wxa.lj.p pVar = (com.tencent.luggage.wxa.lj.p) com.tencent.luggage.wxa.eo.g.a(com.tencent.luggage.wxa.lj.p.class);
            if (pVar != null) {
                pVar.b(dVar, context);
                if (dVar.getParent() instanceof ViewGroup) {
                    pVar.a((ViewGroup) dVar.getParent(), context);
                    return;
                }
                return;
            }
            return;
        }
        dVar.getLayoutParams().height = context.getResources().getDimensionPixelSize(R.dimen.c1h);
        dVar.setCapsuleContentAreaMarginEnd(context.getResources().getDimensionPixelSize(R.dimen.c1f));
    }

    public void setLabelInjector(g gVar) {
    }

    public void a(Configuration configuration) {
        boolean isInMultiWindowMode;
        com.tencent.luggage.wxa.ic.g gVar = this.I;
        if (gVar == null) {
            return;
        }
        WindowAndroidActivityImpl b16 = WindowAndroidActivityImpl.b(gVar.n0());
        Activity j3 = b16 == null ? null : b16.j();
        if (e0.a(this.J)) {
            com.tencent.luggage.wxa.ok.g.a((Context) j3, true);
            return;
        }
        boolean z16 = configuration.orientation == 2;
        if (z16 && j3 != null && Build.VERSION.SDK_INT >= 24) {
            isInMultiWindowMode = j3.isInMultiWindowMode();
            if (isInMultiWindowMode && j3.getRequestedOrientation() == 1) {
                return;
            }
        }
        if (j3 != null) {
            Window window = j3.getWindow();
            View decorView = window.getDecorView();
            if (z16) {
                window.addFlags(1024);
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 4 | 256);
            } else {
                com.tencent.luggage.wxa.ok.g.d(window, false);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.ok.l
    public void a(Function0 function0) {
        this.P = function0;
    }
}
