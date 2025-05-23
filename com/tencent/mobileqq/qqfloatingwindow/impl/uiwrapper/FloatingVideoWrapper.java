package com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenEnterListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.p;
import com.tencent.mobileqq.widget.f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import gh2.d;
import gh2.e;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes16.dex */
public class FloatingVideoWrapper extends com.tencent.mobileqq.qqfloatingwindow.a implements IVideoOuterStatusListener, SeekBar.OnSeekBarChangeListener, gh2.a {
    static IPatchRedirector $redirector_ = null;
    public static final String CLASS_NAME;
    public static final String TAG = "FloatingVideoWrapper";
    private ImageView C;
    private TextView D;
    private TextView E;
    private LinearLayout F;
    private ImageView G;
    private SeekBar H;
    private TextView I;
    private ImageView J;
    private TextView K;
    private TextView L;
    private int M;
    private int N;
    private TextView P;
    private TextView Q;
    private List<View> R;
    private int S;
    private int T;
    private int U;
    private int V;
    private int W;
    private ObjectAnimator X;
    private Runnable Y;
    private StringBuilder Z;

    /* renamed from: a0, reason: collision with root package name */
    private Formatter f264360a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f264361b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f264362c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f264363d0;

    /* renamed from: e, reason: collision with root package name */
    private IVideoInnerStatusListener f264364e;

    /* renamed from: e0, reason: collision with root package name */
    private int f264365e0;

    /* renamed from: f, reason: collision with root package name */
    private IFullScreenEnterListener f264366f;

    /* renamed from: h, reason: collision with root package name */
    private FrameLayout f264367h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f264368i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f264369m;
    public gh2.c mFullScreenViewClickListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f264377d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f264378e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f264379f;

        a(float f16, float f17, View view) {
            this.f264377d = f16;
            this.f264378e = f17;
            this.f264379f = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, FloatingVideoWrapper.this, Float.valueOf(f16), Float.valueOf(f17), view);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            this.f264379f.setAlpha(this.f264377d + (((Float) valueAnimator.getAnimatedValue()).floatValue() * (this.f264378e - this.f264377d)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b extends f {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f264381d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f264382e;

        b(int i3, View view) {
            this.f264381d = i3;
            this.f264382e = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, FloatingVideoWrapper.this, Integer.valueOf(i3), view);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
                return;
            }
            View view = this.f264382e;
            if (view != null) {
                int i3 = this.f264381d;
                if (i3 == 0) {
                    view.setAlpha(1.0f);
                } else if (i3 == 1) {
                    view.setAlpha(0.0f);
                }
                FloatingVideoWrapper.this.W = this.f264381d;
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                FloatingVideoWrapper.this.W = this.f264381d;
                if (this.f264381d == 1) {
                    FloatingVideoWrapper.this.i1(false);
                    FloatingVideoWrapper floatingVideoWrapper = FloatingVideoWrapper.this;
                    floatingVideoWrapper.i0(false, floatingVideoWrapper.G);
                }
                FloatingVideoWrapper.this.k1();
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                FloatingVideoWrapper.this.W = 2;
                if (this.f264381d == 0) {
                    FloatingVideoWrapper.this.i1(true);
                    if (FloatingVideoWrapper.this.S == 1 || FloatingVideoWrapper.this.S == 4) {
                        FloatingVideoWrapper floatingVideoWrapper = FloatingVideoWrapper.this;
                        floatingVideoWrapper.i0(true, floatingVideoWrapper.G);
                        return;
                    }
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class c implements gh2.f {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FloatingVideoWrapper.this);
            }
        }

        @Override // gh2.f
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            if (FloatingVideoWrapper.this.f264364e != null) {
                FloatingVideoWrapper.this.f264364e.notifyVideoStop();
            }
            FloatingVideoWrapper floatingVideoWrapper = FloatingVideoWrapper.this;
            floatingVideoWrapper.i0(true, floatingVideoWrapper.G, FloatingVideoWrapper.this.D);
            FloatingVideoWrapper floatingVideoWrapper2 = FloatingVideoWrapper.this;
            floatingVideoWrapper2.i0(false, floatingVideoWrapper2.E);
            FloatingVideoWrapper.this.U(false);
        }

        @Override // gh2.f
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            } else {
                FloatingVideoWrapper.this.quitWindowFloat(5);
            }
        }

        @Override // gh2.f
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (FloatingVideoWrapper.this.f264364e != null) {
                FloatingVideoWrapper.this.f264364e.notifyVideoStop();
                FloatingVideoWrapper.this.S = 1;
            }
            FloatingVideoWrapper floatingVideoWrapper = FloatingVideoWrapper.this;
            floatingVideoWrapper.i0(true, floatingVideoWrapper.G);
        }

        @Override // gh2.f
        public void d(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, z16);
                return;
            }
            if (!FloatingVideoWrapper.this.t() && FloatingVideoWrapper.this.u() != 0) {
                FloatingVideoWrapper.this.U(true);
                if (z16 && FloatingVideoWrapper.this.f264364e != null && FloatingVideoWrapper.this.S == 0) {
                    FloatingVideoWrapper.this.f264364e.notifyVideoStart();
                    FloatingVideoWrapper floatingVideoWrapper = FloatingVideoWrapper.this;
                    floatingVideoWrapper.i0(false, floatingVideoWrapper.G);
                } else if (FloatingVideoWrapper.this.I != null && FloatingVideoWrapper.this.I.getVisibility() == 0) {
                    FloatingVideoWrapper floatingVideoWrapper2 = FloatingVideoWrapper.this;
                    floatingVideoWrapper2.i0(false, floatingVideoWrapper2.G);
                } else {
                    FloatingVideoWrapper floatingVideoWrapper3 = FloatingVideoWrapper.this;
                    floatingVideoWrapper3.i0(true, floatingVideoWrapper3.G);
                    FloatingVideoWrapper.this.S = 1;
                }
            }
        }

        @Override // gh2.f
        public /* synthetic */ void e() {
            e.a(this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35596);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 28)) {
            redirector.redirect((short) 28);
        } else {
            CLASS_NAME = FloatingVideoWrapper.class.getName();
        }
    }

    public FloatingVideoWrapper(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.M = 0;
        this.N = 0;
        this.S = -1;
        this.T = -1;
        this.U = -1;
        this.V = -1;
        this.W = 0;
        this.Y = new Runnable() { // from class: com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingVideoWrapper.12
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FloatingVideoWrapper.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    FloatingVideoWrapper floatingVideoWrapper = FloatingVideoWrapper.this;
                    floatingVideoWrapper.i0(false, floatingVideoWrapper.f264368i);
                }
            }
        };
        this.f264361b0 = 0;
        this.f264362c0 = 0;
        this.f264363d0 = 0;
        this.f264365e0 = 0;
    }

    private void J0() {
        Context v3 = v();
        if (v3 != null && this.F != null && com.tencent.mobileqq.qqfloatingwindow.impl.b.a(v3)) {
            int d16 = com.tencent.mobileqq.qqfloatingwindow.impl.b.d(v3);
            int c16 = com.tencent.mobileqq.qqfloatingwindow.impl.b.c(v3);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "screenRealHeight = " + d16 + " screenPureHeight = " + c16);
            }
            if (d16 > 0 && c16 > 0) {
                int b16 = com.tencent.mobileqq.qqfloatingwindow.impl.b.b(16.0f, v3.getResources()) + Math.min(Math.max(d16 - c16, 0), 100);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.F.getLayoutParams();
                layoutParams.bottomMargin = b16;
                this.F.setLayoutParams(layoutParams);
            }
        }
    }

    private void K0(Context context) {
        int statusBarHeight = LiuHaiUtils.getStatusBarHeight(context);
        if (statusBarHeight > 0) {
            ((RelativeLayout.LayoutParams) this.C.getLayoutParams()).topMargin = statusBarHeight;
            ((RelativeLayout.LayoutParams) this.f264369m.getLayoutParams()).topMargin = statusBarHeight;
        }
    }

    private void L0(int i3) {
        float f16 = 1.0f;
        float f17 = 0.0f;
        if (i3 == 0) {
            f17 = 1.0f;
            f16 = 0.0f;
        } else if (i3 != 1) {
            return;
        }
        View z16 = z();
        if (z16 != null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(z16, PropertyValuesHolder.ofFloat(com.tencent.luggage.wxa.c8.c.f123400v, f16, f17));
            this.X = ofPropertyValuesHolder;
            ofPropertyValuesHolder.addUpdateListener(new a(f16, f17, z16));
            this.X.addListener(new b(i3, z16));
            this.X.setDuration(300L).start();
        }
    }

    private void M0() {
        if (!t() && o()) {
            if (p()) {
                if (y() || !x(r(), s())) {
                    IFullScreenEnterListener iFullScreenEnterListener = this.f264366f;
                    if (iFullScreenEnterListener != null) {
                        iFullScreenEnterListener.onEnter(r(), s());
                    } else {
                        O0();
                    }
                }
                com.tencent.mobileqq.qqfloatingwindow.b.i();
                return;
            }
            if (w()) {
                N0();
            }
        }
    }

    private void N0() {
        int i3 = this.W;
        if (i3 != 0) {
            if (i3 == 1) {
                L0(0);
            }
        } else {
            int i16 = this.S;
            if (i16 == 0 || i16 == 1 || i16 == 4) {
                L0(1);
            }
        }
    }

    private void O0() {
        if (!t()) {
            if (!p()) {
                return;
            }
            i(true, this.U, this.V, true);
            l();
            i1(true);
            l1(true);
            i0(false, this.K);
            N(false);
        }
        e1();
        g1(false);
        k1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0() {
        j1(400);
        f0(true, this.D, this.E, this.H);
        this.S = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0(Bitmap bitmap) {
        ImageView imageView = this.f264368i;
        if (imageView != null && bitmap != null) {
            imageView.setImageBitmap(bitmap);
            this.f264368i.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0(Drawable drawable) {
        ImageView imageView = this.f264368i;
        if (imageView != null && drawable != null) {
            imageView.setImageDrawable(drawable);
            this.f264368i.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0(boolean z16) {
        i0(true, this.D, this.G);
        i0(false, this.E, this.I, this.J);
        i0(z16, this.f264368i);
        f0(true, this.D, this.E);
        f0(false, this.H);
        this.P.setText(h1(this.N));
        this.H.setProgress(100);
        this.S = 4;
        k1();
        if (p()) {
            d1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0() {
        j1(401);
        f0(false, this.D, this.E, this.H);
        this.S = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0(int i3) {
        if (i3 < 0) {
            i3 = 0;
        } else {
            int i16 = this.N;
            if (i3 > i16) {
                i3 = i16;
            }
        }
        int i17 = (int) ((i3 * 100.0d) / this.N);
        this.M = i17;
        this.H.setProgress(i17);
        this.P.setText(h1(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(int i3, int i16) {
        if (i3 > 0) {
            this.U = i3;
        }
        if (i16 > 0) {
            this.V = i16;
        }
        if (o()) {
            i(!p(), this.U, this.V, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0(int i3) {
        i0(false, this.D, this.G, this.I, this.J, this.L);
        i0(true, this.E);
        f0(true, this.D, this.E, this.H);
        e0();
        this.S = 0;
        k1();
        if (i3 > 0 && this.N != i3) {
            this.N = i3;
            TextView textView = this.Q;
            if (textView != null) {
                textView.setText(h1(i3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0() {
        i0(true, this.D, this.G);
        i0(false, this.E, this.I, this.J);
        f0(true, this.D, this.E, this.H);
        this.S = 1;
        k1();
    }

    private static boolean Y0() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        return false;
    }

    private void Z0() {
        if (!t()) {
            if (!w()) {
                return;
            }
            i(false, this.U, this.V, false);
            m();
            i1(false);
            l1(false);
            N(true);
        }
        gh2.c cVar = this.mFullScreenViewClickListener;
        if (cVar != null) {
            cVar.a();
        }
        this.X = null;
        g1(true);
        k1();
        if (this.S == 4) {
            d1();
        }
    }

    private void a1() {
        onVideoStop();
        IVideoInnerStatusListener iVideoInnerStatusListener = this.f264364e;
        if (iVideoInnerStatusListener != null) {
            iVideoInnerStatusListener.notifyVideoStop();
        }
    }

    private void b1() {
        onVideoStart(this.N);
        IVideoInnerStatusListener iVideoInnerStatusListener = this.f264364e;
        if (iVideoInnerStatusListener != null) {
            iVideoInnerStatusListener.notifyVideoStart();
        }
    }

    private boolean c1(int i3) {
        if (i3 != 401 && i3 != 402 && i3 != 403) {
            return false;
        }
        return true;
    }

    private void d1() {
        if (this.N == 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "showFinishTime() mAllTime == 0");
            }
            i0(false, this.L);
        } else {
            i0(true, this.L);
            TextView textView = this.L;
            if (textView != null) {
                textView.setText(h1(this.N));
            }
        }
    }

    private void e1() {
        d0();
        Z(1.0f);
        this.W = 0;
    }

    private void g1(boolean z16) {
        int i3;
        if (z16) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        T(i3, i3, i3, i3);
        L(z16);
        W(z16);
        Context v3 = v();
        if (v3 != null && v3.getResources() != null) {
            if (z16) {
                V(v3.getResources().getDrawable(R.drawable.hh_));
            } else {
                V(v3.getResources().getDrawable(R.drawable.hh9));
            }
        }
    }

    private String h1(long j3) {
        if (this.f264360a0 == null) {
            this.Z = new StringBuilder();
            this.f264360a0 = new Formatter(this.Z, Locale.getDefault());
        }
        int i3 = (int) (j3 / 1000);
        this.f264361b0 = i3;
        this.f264362c0 = i3 % 60;
        this.f264363d0 = (i3 / 60) % 60;
        this.f264365e0 = i3 / 3600;
        this.Z.setLength(0);
        int i16 = this.f264365e0;
        if (i16 > 0) {
            return this.f264360a0.format("%d:%02d:%02d", Integer.valueOf(i16), Integer.valueOf(this.f264363d0), Integer.valueOf(this.f264362c0)).toString();
        }
        return this.f264360a0.format("%02d:%02d", Integer.valueOf(this.f264363d0), Integer.valueOf(this.f264362c0)).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1(boolean z16) {
        for (View view : this.R) {
            if (view != null) {
                if (z16) {
                    view.setVisibility(0);
                } else {
                    view.setVisibility(4);
                }
            }
        }
    }

    private void j1(int i3) {
        Context v3;
        e1();
        if (!t()) {
            i1(w());
        }
        i0(false, this.G);
        i0(true, this.I);
        if (i3 != 400 && (v3 = v()) != null) {
            a0(v3.getResources().getColor(R.color.acv));
        }
        if (this.J != null) {
            if (c1(i3)) {
                this.J.setImageResource(R.drawable.hvs);
                this.J.setVisibility(0);
            } else {
                this.J.setVisibility(8);
            }
        }
        TextView textView = this.I;
        if (textView != null) {
            if (i3 == 400) {
                textView.setText(R.string.f209775gb);
                return;
            }
            if (i3 == 401) {
                textView.setText(R.string.f209785gc);
                return;
            }
            if (i3 == 402) {
                textView.setText(R.string.f209805ge);
            } else if (i3 == 403) {
                textView.setText(R.string.f209795gd);
            } else {
                textView.setText(R.string.f209785gc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1() {
        Context v3;
        if (t() || (v3 = v()) == null) {
            return;
        }
        if (p()) {
            int i3 = this.S;
            if (i3 != 1 && i3 != 4) {
                c0(v3.getResources().getString(R.string.f209625fx));
                return;
            } else {
                c0(v3.getResources().getString(R.string.f209745g9));
                return;
            }
        }
        int i16 = this.W;
        if (i16 == 0) {
            c0(v3.getResources().getString(R.string.f209825gg));
        } else if (i16 == 1) {
            c0(v3.getResources().getString(R.string.f209635fy));
        }
    }

    private void l1(boolean z16) {
        int i3;
        Context v3 = v();
        if (v3 == null) {
            return;
        }
        Resources resources = v3.getResources();
        ImageView imageView = this.G;
        int i16 = -2;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (z16) {
                layoutParams.width = -2;
                layoutParams.height = -2;
                this.G.setImageResource(R.drawable.c0z);
            } else {
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.G.setImageResource(R.drawable.hvt);
            }
            this.G.setLayoutParams(layoutParams);
        }
        ImageView imageView2 = this.J;
        if (imageView2 != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) imageView2.getLayoutParams();
            if (z16) {
                if (resources != null) {
                    i3 = com.tencent.mobileqq.qqfloatingwindow.impl.b.b(16.0f, resources);
                } else {
                    i3 = 32;
                }
            } else if (resources != null) {
                i16 = com.tencent.mobileqq.qqfloatingwindow.impl.b.b(20.0f, resources);
                i3 = com.tencent.mobileqq.qqfloatingwindow.impl.b.b(8.0f, resources);
            } else {
                i16 = 40;
                i3 = 16;
            }
            layoutParams2.width = i16;
            layoutParams2.height = i16;
            layoutParams2.setMargins(0, 0, 0, i3);
            this.J.setLayoutParams(layoutParams2);
        }
        TextView textView = this.I;
        if (textView != null) {
            if (z16) {
                textView.setTextSize(17.0f);
            } else {
                textView.setTextSize(12.0f);
            }
        }
        int i17 = this.S;
        if (i17 != 2 && i17 != 3) {
            if (z16) {
                b0(R.drawable.hvu);
                return;
            } else {
                if (resources != null) {
                    a0(resources.getColor(R.color.ajr));
                    return;
                }
                return;
            }
        }
        if (resources != null) {
            a0(resources.getColor(R.color.acv));
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public void B(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        super.B(context);
        O(this);
        FrameLayout frameLayout = new FrameLayout(context);
        this.f264367h = frameLayout;
        frameLayout.setId(R.id.m2z);
        ImageView imageView = new ImageView(context);
        this.f264368i = imageView;
        imageView.setId(R.id.m2l);
        this.f264368i.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageView imageView2 = (ImageView) A(R.id.m2p);
        this.f264369m = imageView2;
        imageView2.setContentDescription(context.getResources().getString(R.string.f209615fw));
        ImageView imageView3 = (ImageView) A(R.id.m2o);
        this.C = imageView3;
        imageView3.setContentDescription(context.getResources().getString(R.string.f209605fv));
        TextView textView = (TextView) A(R.id.m2v);
        this.D = textView;
        textView.setContentDescription(context.getResources().getString(R.string.f209755g_));
        TextView textView2 = (TextView) A(R.id.m2u);
        this.E = textView2;
        textView2.setContentDescription(context.getResources().getString(R.string.f209655g0));
        this.F = (LinearLayout) A(R.id.m2s);
        ImageView imageView4 = (ImageView) A(R.id.m2q);
        this.G = imageView4;
        imageView4.setContentDescription(context.getResources().getString(R.string.f209745g9));
        this.I = (TextView) A(R.id.m2w);
        this.J = (ImageView) A(R.id.m2r);
        this.P = (TextView) A(R.id.m2y);
        this.Q = (TextView) A(R.id.m2x);
        TextView textView3 = (TextView) A(R.id.f630432g);
        this.K = textView3;
        textView3.setShadowLayer(3.0f, 1.0f, 1.0f, -16777216);
        this.L = (TextView) A(R.id.f630532h);
        g0(this, this.f264369m, this.C, this.D, this.E, this.G);
        SeekBar seekBar = (SeekBar) A(R.id.f166637m31);
        this.H = seekBar;
        seekBar.setOnSeekBarChangeListener(this);
        this.H.setThumb(context.getResources().getDrawable(R.drawable.gnh));
        this.H.setProgressDrawable(context.getResources().getDrawable(R.drawable.aik));
        if (this.R == null) {
            this.R = new ArrayList(4);
        }
        this.R.clear();
        this.R.add(this.F);
        this.R.add(this.f264369m);
        this.R.add(this.C);
        if (LiuHaiUtils.isLiuHaiUseValid()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f264369m.getLayoutParams();
            layoutParams.addRule(10, -1);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
            layoutParams2.addRule(10, -1);
            int b16 = LiuHaiUtils.sNotchHeight - com.tencent.mobileqq.qqfloatingwindow.impl.b.b(12.0f, context.getResources());
            layoutParams.topMargin = b16;
            layoutParams2.topMargin = b16;
        }
        K0(context);
        J0();
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public IVideoOuterStatusListener M(IVideoInnerStatusListener iVideoInnerStatusListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (IVideoOuterStatusListener) iPatchRedirector.redirect((short) 11, (Object) this, (Object) iVideoInnerStatusListener);
        }
        this.f264364e = iVideoInnerStatusListener;
        return this;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public void X(IFullScreenEnterListener iFullScreenEnterListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) iFullScreenEnterListener);
        } else {
            this.f264366f = iFullScreenEnterListener;
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public void Y(gh2.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) cVar);
        } else {
            this.mFullScreenViewClickListener = cVar;
        }
    }

    public void f1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        Context v3 = v();
        if (v3 != null && !((Boolean) p.b(v3, "", AppConstants.Preferences.KEY_FLOAT_VIDEO_HAS_SHOW_TIPS, Boolean.FALSE)).booleanValue()) {
            i0(true, this.K);
            p.g(v3, "", true, AppConstants.Preferences.KEY_FLOAT_VIDEO_HAS_SHOW_TIPS, Boolean.TRUE);
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingVideoWrapper.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FloatingVideoWrapper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        FloatingVideoWrapper floatingVideoWrapper = FloatingVideoWrapper.this;
                        floatingVideoWrapper.i0(false, floatingVideoWrapper.K);
                    }
                }
            }, 3000L);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.a
    public void initStatusReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            g(0, new c());
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void initWidgetWrapper(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
            return;
        }
        this.f264367h.removeAllViews();
        E(view);
        view.setId(R.id.f166638m32);
        this.f264367h.addView(view, new FrameLayout.LayoutParams(-1, -1));
        E(this.f264368i);
        this.f264367h.addView(this.f264368i, new FrameLayout.LayoutParams(-1, -1));
        D();
        E(this.f264367h);
        h(this.f264367h, new FrameLayout.LayoutParams(-1, -1));
        F();
        f(new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public int j(FloatingScreenParams floatingScreenParams, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) floatingScreenParams, (Object) view)).intValue();
        }
        int j3 = super.j(floatingScreenParams, view);
        IVideoInnerStatusListener iVideoInnerStatusListener = this.f264364e;
        if (iVideoInnerStatusListener != null) {
            iVideoInnerStatusListener.notifyVideoClose(6);
            this.f264364e = null;
        } else {
            com.tencent.mobileqq.qqfloatingwindow.b.q();
            if (j3 == 0 && floatingScreenParams != null && floatingScreenParams.getCanZoom()) {
                f1();
            }
        }
        g1(true);
        this.f264366f = null;
        this.N = 0;
        return j3;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public void j0(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) dVar);
        } else {
            super.j0(dVar);
        }
    }

    @Override // gh2.a
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            quitWindowFloat(3);
            com.tencent.mobileqq.qqfloatingwindow.b.g();
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.m2n) {
                quitWindowFloat(1);
                com.tencent.mobileqq.qqfloatingwindow.b.d();
            } else if (id5 == R.id.m2o) {
                quitWindowFloat(2);
                com.tencent.mobileqq.qqfloatingwindow.b.l();
            } else if (id5 == R.id.m2p) {
                Z0();
                com.tencent.mobileqq.qqfloatingwindow.b.h();
            } else if (id5 == R.id.m2v) {
                b1();
                com.tencent.mobileqq.qqfloatingwindow.b.f();
            } else if (id5 == R.id.m2u) {
                a1();
                com.tencent.mobileqq.qqfloatingwindow.b.f();
            } else if (id5 == R.id.m2q) {
                b1();
            } else if (id5 == R.id.m2t) {
                M0();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener
    public void onOrientationChange(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
        } else {
            S(z16);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, seekBar, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        this.M = i3;
        IVideoInnerStatusListener iVideoInnerStatusListener = this.f264364e;
        if (iVideoInnerStatusListener != null && z16) {
            iVideoInnerStatusListener.notifyVideoSeek(i3);
            onVideoProgressUpdate((int) ((this.M * this.N) / 100.0d));
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener
    public void onSetVideoCover(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) drawable);
        } else if (Y0()) {
            R0(drawable);
        } else {
            ThreadManager.getUIHandler().post(new Runnable(drawable) { // from class: com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingVideoWrapper.10
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Drawable f264370d;

                {
                    this.f264370d = drawable;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FloatingVideoWrapper.this, (Object) drawable);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        FloatingVideoWrapper.this.R0(this.f264370d);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        IVideoInnerStatusListener iVideoInnerStatusListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) seekBar);
            return;
        }
        int i3 = this.S;
        this.T = i3;
        if (i3 == 0 && (iVideoInnerStatusListener = this.f264364e) != null) {
            iVideoInnerStatusListener.notifyVideoStop();
            this.S = 1;
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        IVideoInnerStatusListener iVideoInnerStatusListener;
        EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) seekBar);
        } else {
            int i3 = this.S;
            int i16 = this.T;
            if (i3 != i16 && i16 == 0 && (iVideoInnerStatusListener = this.f264364e) != null) {
                iVideoInnerStatusListener.notifyVideoStart();
                this.S = 0;
            }
        }
        EventCollector.getInstance().onStopTrackingTouch(seekBar);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener
    public void onVideoBuffering() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else if (Y0()) {
            P0();
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingVideoWrapper.7
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FloatingVideoWrapper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        FloatingVideoWrapper.this.P0();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener
    public void onVideoComplete(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
            return;
        }
        if (p()) {
            com.tencent.mobileqq.qqfloatingwindow.b.j();
        } else {
            com.tencent.mobileqq.qqfloatingwindow.b.m();
        }
        if (Y0()) {
            S0(z16);
        } else {
            ThreadManager.getUIHandler().post(new Runnable(z16) { // from class: com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingVideoWrapper.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f264373d;

                {
                    this.f264373d = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, FloatingVideoWrapper.this, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        FloatingVideoWrapper.this.S0(this.f264373d);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener
    public void onVideoError(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
        } else if (Y0()) {
            T0();
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingVideoWrapper.8
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FloatingVideoWrapper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        FloatingVideoWrapper.this.T0();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener
    public void onVideoProgressUpdate(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else {
            if (this.N == 0) {
                return;
            }
            if (Y0()) {
                U0(i3);
            } else {
                ThreadManager.getUIHandler().post(new Runnable(i3) { // from class: com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingVideoWrapper.6
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ int f264374d;

                    {
                        this.f264374d = i3;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FloatingVideoWrapper.this, i3);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            FloatingVideoWrapper.this.U0(this.f264374d);
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                });
            }
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener
    public void onVideoSize(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else if (Y0()) {
            V0(i3, i16);
        } else {
            ThreadManager.getUIHandler().post(new Runnable(i3, i16) { // from class: com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingVideoWrapper.9
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f264375d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f264376e;

                {
                    this.f264375d = i3;
                    this.f264376e = i16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, FloatingVideoWrapper.this, Integer.valueOf(i3), Integer.valueOf(i16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        FloatingVideoWrapper.this.V0(this.f264375d, this.f264376e);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener
    public void onVideoStart(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
            return;
        }
        if (this.N != i3) {
            com.tencent.mobileqq.qqfloatingwindow.b.p(i3);
        }
        if (Y0()) {
            W0(i3);
        } else {
            ThreadManager.getUIHandler().post(new Runnable(i3) { // from class: com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingVideoWrapper.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f264372d;

                {
                    this.f264372d = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FloatingVideoWrapper.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        FloatingVideoWrapper.this.W0(this.f264372d);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
        ThreadManager.getUIHandler().postDelayed(this.Y, 300L);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener
    public void onVideoStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else if (Y0()) {
            X0();
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingVideoWrapper.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FloatingVideoWrapper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        FloatingVideoWrapper.this.X0();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void quitWindowFloat(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        if (!t() && p()) {
            ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).saveFloatingCenter(r(), s());
        }
        IVideoInnerStatusListener iVideoInnerStatusListener = this.f264364e;
        if (iVideoInnerStatusListener != null) {
            iVideoInnerStatusListener.notifyVideoClose(i3);
            this.f264364e = null;
        }
        this.f264366f = null;
        ThreadManager.getUIHandler().removeCallbacks(this.Y);
        super.quitWindowFloat(i3);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void updateFloatingView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        i0(true, this.E);
        U(true);
        N(true);
        i0(false, this.D, this.I, this.J, this.G, this.f264368i);
        f0(true, this.D, this.E, this.H);
        e1();
        l1(false);
        i1(false);
        k1();
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener
    public void onSetVideoCover(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) bitmap);
        } else if (Y0()) {
            Q0(bitmap);
        } else {
            ThreadManager.getUIHandler().post(new Runnable(bitmap) { // from class: com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingVideoWrapper.11
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Bitmap f264371d;

                {
                    this.f264371d = bitmap;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FloatingVideoWrapper.this, (Object) bitmap);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        FloatingVideoWrapper.this.Q0(this.f264371d);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }
}
