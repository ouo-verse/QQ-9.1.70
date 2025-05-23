package com.tencent.mobileqq.webview.swift;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.biz.widgets.Hole;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.SwiftFloatViewUI;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.SystemBarTintManager;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SwiftFloatViewUI {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.mobileqq.webview.swift.component.v f314010a;

    /* renamed from: b, reason: collision with root package name */
    public r f314011b;

    /* renamed from: c, reason: collision with root package name */
    public View f314012c;

    /* renamed from: d, reason: collision with root package name */
    public View f314013d;

    /* renamed from: e, reason: collision with root package name */
    public View f314014e;

    /* renamed from: f, reason: collision with root package name */
    public View f314015f;

    /* renamed from: g, reason: collision with root package name */
    public View f314016g;

    /* renamed from: h, reason: collision with root package name */
    public View f314017h;

    /* renamed from: i, reason: collision with root package name */
    public View f314018i;

    /* renamed from: j, reason: collision with root package name */
    public View f314019j;

    /* renamed from: k, reason: collision with root package name */
    public View f314020k;

    /* renamed from: l, reason: collision with root package name */
    public View f314021l;

    /* renamed from: m, reason: collision with root package name */
    public Hole f314022m;

    /* renamed from: n, reason: collision with root package name */
    public int f314023n;

    /* renamed from: o, reason: collision with root package name */
    public int f314024o;

    /* renamed from: p, reason: collision with root package name */
    Rect f314025p;

    /* renamed from: q, reason: collision with root package name */
    int f314026q;

    /* renamed from: r, reason: collision with root package name */
    int f314027r;

    /* renamed from: s, reason: collision with root package name */
    Runnable f314028s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f314029d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ DisplayMetrics f314030e;

        a(View view, DisplayMetrics displayMetrics) {
            this.f314029d = view;
            this.f314030e = displayMetrics;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SwiftFloatViewUI.this, view, displayMetrics);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.f314029d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            SwiftFloatViewUI.this.f314022m.setHole(((r0.f314012c.getLeft() + SwiftFloatViewUI.this.f314012c.getRight()) / 2) - 1, ((SwiftFloatViewUI.this.f314012c.getTop() + SwiftFloatViewUI.this.f314012c.getBottom()) / 2) - 1, (int) (this.f314030e.density * 30.0f));
            SwiftFloatViewUI.this.f314022m.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements View.OnTouchListener {
        static IPatchRedirector $redirector_;
        int C;
        int D;
        boolean E;
        int F;
        final /* synthetic */ DisplayMetrics G;

        /* renamed from: d, reason: collision with root package name */
        int f314032d;

        /* renamed from: e, reason: collision with root package name */
        int f314033e;

        /* renamed from: f, reason: collision with root package name */
        int f314034f;

        /* renamed from: h, reason: collision with root package name */
        int f314035h;

        /* renamed from: i, reason: collision with root package name */
        int f314036i;

        /* renamed from: m, reason: collision with root package name */
        int f314037m;

        /* compiled from: P */
        /* loaded from: classes20.dex */
        class a implements Animation.AnimationListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f314038d;

            a(View view) {
                this.f314038d = view;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) view);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                    return;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f314038d.getLayoutParams();
                b bVar = b.this;
                layoutParams.leftMargin = bVar.f314036i;
                layoutParams.topMargin = bVar.f314037m;
                this.f314038d.setLayoutParams(layoutParams);
                this.f314038d.clearAnimation();
                this.f314038d.setVisibility(0);
                b.this.E = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                }
            }
        }

        b(DisplayMetrics displayMetrics) {
            this.G = displayMetrics;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwiftFloatViewUI.this, (Object) displayMetrics);
            } else {
                this.f314036i = 2000;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).a(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_show", 0, 1, 0, SwiftFloatViewUI.this.f314011b.f314622e + "", "", "", "");
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
        
            if (r0 != 3) goto L63;
         */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouch(View view, MotionEvent motionEvent) {
            TranslateAnimation translateAnimation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            SwiftFloatViewUI swiftFloatViewUI = SwiftFloatViewUI.this;
            if (view == swiftFloatViewUI.f314012c) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            if (SwiftFloatViewUI.this.f314013d.getVisibility() != 0) {
                                int rawX = ((int) motionEvent.getRawX()) - this.f314032d;
                                int rawY = ((int) motionEvent.getRawY()) - this.f314033e;
                                this.f314036i = view.getLeft() + rawX;
                                this.f314037m = view.getTop() + rawY;
                                this.C = view.getRight() + rawX;
                                this.D = view.getBottom() + rawY;
                                if (this.f314036i < 0) {
                                    this.f314036i = 0;
                                    this.C = view.getWidth() + 0;
                                } else {
                                    int i3 = this.C;
                                    int i16 = SwiftFloatViewUI.this.f314023n;
                                    if (i3 > i16) {
                                        this.C = i16;
                                        this.f314036i = i16 - view.getWidth();
                                    }
                                }
                                if (this.f314037m < 0) {
                                    this.f314037m = 0;
                                    this.D = 0 + view.getHeight();
                                } else {
                                    int i17 = this.D;
                                    int i18 = SwiftFloatViewUI.this.f314024o;
                                    if (i17 > i18) {
                                        this.D = i18;
                                        this.f314037m = i18 - view.getHeight();
                                    }
                                }
                                view.layout(this.f314036i, this.f314037m, this.C, this.D);
                                this.f314032d = (int) motionEvent.getRawX();
                                this.f314033e = (int) motionEvent.getRawY();
                                if (!this.E && (Math.abs(motionEvent.getRawX() - this.f314034f) > this.G.density * 5.0f || Math.abs(motionEvent.getRawY() - this.f314035h) > this.G.density * 5.0f)) {
                                    SwiftFloatViewUI.this.f314013d.setVisibility(8);
                                    SwiftFloatViewUI swiftFloatViewUI2 = SwiftFloatViewUI.this;
                                    swiftFloatViewUI2.g(swiftFloatViewUI2.f314012c, true);
                                    SwiftFloatViewUI.this.f314020k.setVisibility(8);
                                    this.E = true;
                                }
                            }
                        }
                    }
                    SwiftFloatViewUI swiftFloatViewUI3 = SwiftFloatViewUI.this;
                    swiftFloatViewUI3.g(swiftFloatViewUI3.f314012c, true);
                    if (!this.E) {
                        if (SwiftFloatViewUI.this.f314013d.getVisibility() == 0) {
                            SwiftFloatViewUI.this.f314013d.setVisibility(8);
                            SwiftFloatViewUI swiftFloatViewUI4 = SwiftFloatViewUI.this;
                            swiftFloatViewUI4.g(swiftFloatViewUI4.f314012c, true);
                            SwiftFloatViewUI.this.f314020k.setVisibility(8);
                        } else {
                            SwiftFloatViewUI.this.f314013d.setVisibility(0);
                            SwiftFloatViewUI swiftFloatViewUI5 = SwiftFloatViewUI.this;
                            swiftFloatViewUI5.g(swiftFloatViewUI5.f314012c, false);
                            SwiftFloatViewUI.this.f314020k.setVisibility(0);
                            int top = view.getTop();
                            int width = view.getWidth() / 2;
                            int i19 = this.f314036i + width;
                            SwiftFloatViewUI swiftFloatViewUI6 = SwiftFloatViewUI.this;
                            if (i19 < swiftFloatViewUI6.f314023n / 2) {
                                try {
                                    swiftFloatViewUI6.f314012c.setRotationY(180.0f);
                                } catch (Throwable th5) {
                                    QLog.e("WebLog_SwiftFloatViewUI", 1, "floatbtn.setrotationy error!", th5);
                                }
                                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SwiftFloatViewUI.this.f314013d.getLayoutParams();
                                layoutParams.gravity = 3;
                                layoutParams.leftMargin = this.f314036i + width;
                                layoutParams.topMargin = top;
                                SwiftFloatViewUI.this.f314013d.setLayoutParams(layoutParams);
                                View view2 = SwiftFloatViewUI.this.f314013d;
                                view2.setPadding((int) (this.G.density * 35.0f), view2.getPaddingTop(), (int) (this.G.density * 20.0f), SwiftFloatViewUI.this.f314013d.getPaddingBottom());
                            } else {
                                try {
                                    swiftFloatViewUI6.f314012c.setRotationY(0.0f);
                                } catch (Throwable th6) {
                                    QLog.e("WebLog_SwiftFloatViewUI", 1, "floatbtn.setrotationy error!", th6);
                                }
                                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) SwiftFloatViewUI.this.f314013d.getLayoutParams();
                                layoutParams2.gravity = 5;
                                layoutParams2.rightMargin = (SwiftFloatViewUI.this.f314023n - view.getRight()) + width;
                                layoutParams2.topMargin = top;
                                SwiftFloatViewUI.this.f314013d.setLayoutParams(layoutParams2);
                                View view3 = SwiftFloatViewUI.this.f314013d;
                                view3.setPadding((int) (this.G.density * 20.0f), view3.getPaddingTop(), (int) (this.G.density * 35.0f), SwiftFloatViewUI.this.f314013d.getPaddingBottom());
                            }
                            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.t
                                @Override // java.lang.Runnable
                                public final void run() {
                                    SwiftFloatViewUI.b.this.b();
                                }
                            }, 16, null, false);
                        }
                    } else {
                        int min = Math.min(this.f314036i, SwiftFloatViewUI.this.f314023n - this.C);
                        this.F = min;
                        if (min == this.f314036i) {
                            translateAnimation = new TranslateAnimation(0.0f, -this.f314036i, 0.0f, 0.0f);
                            this.f314036i = 0;
                            this.C = 0 + view.getWidth();
                        } else {
                            translateAnimation = new TranslateAnimation(0.0f, this.F, 0.0f, 0.0f);
                            int i26 = SwiftFloatViewUI.this.f314023n;
                            this.C = i26;
                            this.f314036i = i26 - view.getWidth();
                        }
                        translateAnimation.setDuration(500L);
                        view.setVisibility(8);
                        translateAnimation.setAnimationListener(new a(view));
                        view.startAnimation(translateAnimation);
                    }
                } else {
                    SwiftFloatViewUI.this.f314014e.setVisibility(8);
                    int rawX2 = (int) motionEvent.getRawX();
                    this.f314032d = rawX2;
                    this.f314034f = rawX2;
                    int rawY2 = (int) motionEvent.getRawY();
                    this.f314033e = rawY2;
                    this.f314035h = rawY2;
                }
                return true;
            }
            View view4 = swiftFloatViewUI.f314014e;
            if (view == view4) {
                view4.setVisibility(8);
                SwiftFloatViewUI.this.f314013d.setVisibility(8);
                SwiftFloatViewUI swiftFloatViewUI7 = SwiftFloatViewUI.this;
                swiftFloatViewUI7.g(swiftFloatViewUI7.f314012c, true);
                SwiftFloatViewUI.this.f314020k.setVisibility(8);
                return true;
            }
            if (view != swiftFloatViewUI.f314020k) {
                return false;
            }
            view4.setVisibility(8);
            SwiftFloatViewUI.this.f314013d.setVisibility(8);
            SwiftFloatViewUI swiftFloatViewUI8 = SwiftFloatViewUI.this;
            swiftFloatViewUI8.g(swiftFloatViewUI8.f314012c, true);
            SwiftFloatViewUI.this.f314020k.setVisibility(8);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements View.OnLayoutChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f314040d;

        c(View view) {
            this.f314040d = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwiftFloatViewUI.this, (Object) view);
            }
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            View view2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28));
                return;
            }
            this.f314040d.getWindowVisibleDisplayFrame(SwiftFloatViewUI.this.f314025p);
            SwiftFloatViewUI swiftFloatViewUI = SwiftFloatViewUI.this;
            Rect rect = swiftFloatViewUI.f314025p;
            int i29 = rect.right - rect.left;
            int i36 = rect.bottom - rect.top;
            if (swiftFloatViewUI.f314026q != i29 || swiftFloatViewUI.f314027r != i36) {
                ThreadManager.getUIHandler().post(SwiftFloatViewUI.this.f314028s);
                SwiftFloatViewUI swiftFloatViewUI2 = SwiftFloatViewUI.this;
                swiftFloatViewUI2.f314026q = i29;
                swiftFloatViewUI2.f314027r = i36;
            }
            int i37 = i17 - i3;
            if (i37 != i27 - i19 && (view2 = SwiftFloatViewUI.this.f314012c) != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view2.getLayoutParams();
                if (layoutParams.leftMargin > i37 / 2 && 8 == SwiftFloatViewUI.this.f314014e.getVisibility()) {
                    layoutParams.leftMargin = i37 - SwiftFloatViewUI.this.f314012c.getWidth();
                    SwiftFloatViewUI.this.f314012c.setLayoutParams(layoutParams);
                }
            }
            SwiftFloatViewUI.this.f314023n = i37;
        }
    }

    public SwiftFloatViewUI(com.tencent.mobileqq.webview.swift.component.v vVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) vVar);
            return;
        }
        this.f314025p = new Rect();
        this.f314028s = new Runnable() { // from class: com.tencent.mobileqq.webview.swift.SwiftFloatViewUI.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SwiftFloatViewUI.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                WebViewProvider webViewProvider;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                com.tencent.mobileqq.webview.swift.component.v vVar2 = SwiftFloatViewUI.this.f314010a;
                if (vVar2 != null && (webViewProvider = vVar2.P) != null) {
                    an.e(webViewProvider.getHostActivity());
                }
            }
        };
        this.f314010a = vVar;
        this.f314011b = vVar.f314512m;
    }

    private View.OnTouchListener a(DisplayMetrics displayMetrics) {
        return new b(displayMetrics);
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        r rVar = this.f314011b;
        if (rVar != null && rVar.f314629l && rVar.W && this.f314012c != null && 8 == this.f314014e.getVisibility()) {
            e();
        }
    }

    @TargetApi(16)
    public void c(View view, View.OnClickListener onClickListener) {
        DisplayMetrics displayMetrics;
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) onClickListener);
            return;
        }
        Activity activity = this.f314010a.E;
        if (activity != null) {
            displayMetrics = activity.getResources().getDisplayMetrics();
        } else {
            displayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
        }
        if (this.f314011b.f314629l) {
            int i17 = displayMetrics.heightPixels;
            int i18 = displayMetrics.widthPixels;
            if (i17 > i18) {
                i16 = i17;
            } else {
                i16 = i18;
            }
            this.f314023n = i16;
            if (i17 > i18) {
                i17 = i18;
            }
            this.f314024o = i17;
        } else {
            int i19 = displayMetrics.heightPixels;
            int i26 = displayMetrics.widthPixels;
            if (i19 < i26) {
                i3 = i19;
            } else {
                i3 = i26;
            }
            this.f314023n = i3;
            if (i19 < i26) {
                i19 = i26;
            }
            this.f314024o = i19;
        }
        this.f314012c = view.findViewById(R.id.cd8);
        this.f314014e = view.findViewById(R.id.jm8);
        this.f314013d = view.findViewById(R.id.adu);
        this.f314015f = view.findViewById(R.id.bzi);
        this.f314017h = view.findViewById(R.id.iqr);
        this.f314018i = view.findViewById(R.id.ins);
        this.f314019j = view.findViewById(R.id.ezq);
        this.f314016g = view.findViewById(R.id.cgm);
        this.f314021l = view.findViewById(R.id.sy8);
        this.f314020k = view.findViewById(R.id.enc);
        this.f314022m = (Hole) view.findViewById(R.id.d6b);
        b();
        if (this.f314011b.f314623f) {
            j(view);
        }
        if ((this.f314011b.f314622e & 1) != 0) {
            this.f314017h.setVisibility(0);
            this.f314012c.setVisibility(0);
        }
        if ((this.f314011b.f314622e & 4) != 0) {
            this.f314015f.setVisibility(0);
            this.f314012c.setVisibility(0);
        }
        if ((this.f314011b.f314622e & 2) != 0) {
            this.f314019j.setVisibility(0);
            this.f314012c.setVisibility(0);
        }
        r rVar = this.f314011b;
        if (((rVar.f314621d & 2048) != 0 || (rVar.f314620c & WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) != 0) && this.f314010a.P != null && AuthorizeConfig.y().O("aio_authorize_config", this.f314010a.P.getCurrentUrl())) {
            this.f314016g.setVisibility(0);
            this.f314012c.setVisibility(0);
        }
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(AppConstants.Key.SEC_HAND_COM_SHAREPRE_KEY, 0);
        if (sharedPreferences.getBoolean("first_float_tip", true)) {
            this.f314014e.setVisibility(0);
            sharedPreferences.edit().putBoolean("first_float_tip", false).apply();
            view.getViewTreeObserver().addOnGlobalLayoutListener(new a(view, displayMetrics));
        } else {
            this.f314014e.setVisibility(8);
        }
        View.OnTouchListener a16 = a(displayMetrics);
        this.f314015f.setOnClickListener(onClickListener);
        this.f314017h.setOnClickListener(onClickListener);
        this.f314019j.setOnClickListener(onClickListener);
        this.f314018i.setOnClickListener(onClickListener);
        this.f314016g.setOnClickListener(onClickListener);
        this.f314012c.setOnTouchListener(a16);
        this.f314014e.setOnTouchListener(a16);
        this.f314020k.setOnTouchListener(a16);
        View view2 = this.f314021l;
        if (view2 != null) {
            view2.setOnClickListener(onClickListener);
        }
    }

    public void d() {
        DisplayMetrics displayMetrics;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.f314012c != null && 8 == this.f314014e.getVisibility()) {
            Activity activity = this.f314010a.E;
            if (activity != null) {
                displayMetrics = activity.getResources().getDisplayMetrics();
            } else {
                displayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
            }
            this.f314023n = displayMetrics.widthPixels;
            this.f314024o = displayMetrics.heightPixels;
            r rVar = this.f314011b;
            if (rVar != null && rVar.f314629l && rVar.W) {
                e();
                return;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f314012c.getLayoutParams();
            float f16 = this.f314023n;
            float f17 = displayMetrics.density;
            layoutParams.leftMargin = (int) (f16 - (50.0f * f17));
            layoutParams.topMargin = (int) (this.f314024o - (f17 * 100.0f));
            this.f314012c.setLayoutParams(layoutParams);
        }
    }

    public void e() {
        DisplayMetrics displayMetrics;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        int i3 = this.f314024o;
        int i16 = this.f314023n;
        if (i3 <= i16) {
            i16 = i3;
            i3 = i16;
        }
        Activity activity = this.f314010a.E;
        if (activity != null) {
            displayMetrics = activity.getResources().getDisplayMetrics();
        } else {
            displayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f314012c.getLayoutParams();
        layoutParams.leftMargin = (int) (i3 - (displayMetrics.density * 70.0f));
        layoutParams.topMargin = (i16 / 2) - (this.f314012c.getWidth() / 2);
        this.f314012c.setLayoutParams(layoutParams);
    }

    @TargetApi(11)
    public void f(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity);
        } else if (SystemBarTintManager.hasNavBar(activity)) {
            View findViewById = activity.findViewById(android.R.id.content);
            findViewById.addOnLayoutChangeListener(new c(findViewById));
        }
    }

    public void g(View view, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, view, Boolean.valueOf(z16));
            return;
        }
        r rVar = this.f314011b;
        if (rVar.f314623f) {
            view.setBackgroundResource(R.drawable.dld);
            return;
        }
        if (rVar.W) {
            view.setBackgroundResource(R.drawable.dlf);
        } else if (z16) {
            view.setBackgroundResource(R.drawable.dl5);
        } else {
            view.setBackgroundResource(R.drawable.dl6);
        }
    }

    public void h(boolean z16) {
        View view;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        View view2 = this.f314021l;
        if (view2 != null) {
            if (z16) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            view2.setVisibility(i3);
        }
        if (!z16 && (view = this.f314012c) != null) {
            if (view.getVisibility() == 8 || this.f314012c.getVisibility() == 4) {
                this.f314012c.setVisibility(0);
            }
        }
    }

    public void i(boolean z16) {
        View view;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        View view2 = this.f314017h;
        if (view2 != null) {
            if (z16) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            view2.setVisibility(i3);
        }
        if (!z16 && (view = this.f314012c) != null) {
            if (view.getVisibility() == 8 || this.f314012c.getVisibility() == 4) {
                this.f314012c.setVisibility(0);
            }
        }
    }

    public void j(View view) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
            return;
        }
        int color = view.getResources().getColor(R.color.aht);
        if (this.f314011b.f314623f) {
            color = view.getResources().getColor(R.color.ahu);
        }
        View view2 = this.f314017h;
        if (view2 != null && (view2 instanceof TextView)) {
            if (this.f314011b.f314623f) {
                i19 = R.drawable.dlk;
            } else {
                i19 = R.drawable.dlj;
            }
            ((TextView) view2).setCompoundDrawablesWithIntrinsicBounds(0, i19, 0, 0);
            ((TextView) this.f314017h).setTextColor(color);
        }
        View view3 = this.f314018i;
        if (view3 != null && (view3 instanceof TextView)) {
            if (this.f314011b.f314623f) {
                i18 = R.drawable.dlh;
            } else {
                i18 = R.drawable.dlg;
            }
            ((TextView) view3).setCompoundDrawablesWithIntrinsicBounds(0, i18, 0, 0);
            ((TextView) this.f314018i).setTextColor(color);
        }
        View view4 = this.f314016g;
        if (view4 != null && (view4 instanceof TextView)) {
            if (this.f314011b.f314623f) {
                i17 = R.drawable.dlb;
            } else {
                i17 = R.drawable.dla;
            }
            ((TextView) view4).setCompoundDrawablesWithIntrinsicBounds(0, i17, 0, 0);
            ((TextView) this.f314016g).setTextColor(color);
        }
        View view5 = this.f314015f;
        if (view5 != null && (view5 instanceof TextView)) {
            if (this.f314011b.f314623f) {
                i16 = R.drawable.dl9;
            } else {
                i16 = R.drawable.dl8;
            }
            ((TextView) view5).setCompoundDrawablesWithIntrinsicBounds(0, i16, 0, 0);
            ((TextView) this.f314015f).setTextColor(color);
        }
        View view6 = this.f314021l;
        if (view6 != null && (view6 instanceof TextView)) {
            ((TextView) view6).setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.n85, 0, 0);
            ((TextView) this.f314021l).setTextColor(color);
        }
        View view7 = this.f314012c;
        if (view7 != null && (view7 instanceof Button)) {
            r rVar = this.f314011b;
            if (rVar.f314623f) {
                i3 = R.drawable.dld;
            } else if (rVar.W) {
                i3 = R.drawable.dlf;
            } else {
                i3 = R.drawable.dl5;
            }
            view7.setBackgroundResource(i3);
        }
    }
}
