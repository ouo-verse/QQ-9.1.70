package com.tencent.mobileqq.activity.recent;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import androidx.fragment.app.Argus;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.vas.theme.ThemeVideoController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.widget.SwipeMenuLayout;
import com.tencent.util.WeakReferenceHandler;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DrawerFrame extends FrameLayout implements Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: y0, reason: collision with root package name */
    public static final boolean f185112y0;

    /* renamed from: z0, reason: collision with root package name */
    public static int f185113z0;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private WeakReferenceHandler I;
    private Scroller J;
    private ViewGroup K;
    private ViewGroup L;
    private ViewGroup M;
    private View N;
    private ViewGroup P;
    private View Q;
    private VelocityTracker R;
    private d S;
    private int T;
    private int U;
    private int V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private int f185114a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f185115b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f185116c0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f185117d;

    /* renamed from: d0, reason: collision with root package name */
    private View f185118d0;

    /* renamed from: e, reason: collision with root package name */
    private boolean f185119e;

    /* renamed from: e0, reason: collision with root package name */
    private int f185120e0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f185121f;

    /* renamed from: f0, reason: collision with root package name */
    private int f185122f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f185123g0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f185124h;

    /* renamed from: h0, reason: collision with root package name */
    private int f185125h0;

    /* renamed from: i, reason: collision with root package name */
    private boolean f185126i;

    /* renamed from: i0, reason: collision with root package name */
    private int f185127i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f185128j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f185129k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f185130l0;

    /* renamed from: m, reason: collision with root package name */
    private int f185131m;

    /* renamed from: m0, reason: collision with root package name */
    private long f185132m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f185133n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f185134o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f185135p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f185136q0;

    /* renamed from: r0, reason: collision with root package name */
    private e f185137r0;

    /* renamed from: s0, reason: collision with root package name */
    private Map<Integer, e> f185138s0;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f185139t0;

    /* renamed from: u0, reason: collision with root package name */
    private FrameHelperActivity f185140u0;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f185141v0;

    /* renamed from: w0, reason: collision with root package name */
    private StringBuilder f185142w0;

    /* renamed from: x0, reason: collision with root package name */
    protected c f185143x0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DrawerFrame.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b implements Interpolator {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private float f185145a;

        /* renamed from: b, reason: collision with root package name */
        private float f185146b;

        /* renamed from: c, reason: collision with root package name */
        private float f185147c;

        /* renamed from: d, reason: collision with root package name */
        private float f185148d;

        public b(float f16, float f17, float f18, float f19) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
                return;
            }
            this.f185145a = f16;
            this.f185147c = f18;
            this.f185146b = f17;
            this.f185148d = f19;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Float) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16))).floatValue();
            }
            double d16 = f16;
            return (float) ((Math.pow(1.0f - f16, 2.0d) * 3.0d * d16 * this.f185146b) + (r0 * 3.0f * Math.pow(d16, 2.0d) * this.f185148d) + Math.pow(d16, 3.0d));
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class c extends ViewOutlineProvider {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private float f185149a;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void a(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
            } else {
                this.f185149a = f16;
            }
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) outline);
            } else {
                outline.setRoundRect(new Rect(0, 0, view.getWidth(), view.getHeight()), this.f185149a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface d {
        void a(int i3, int i16);

        void b(int i3, int i16);

        void c(int i3, boolean z16);

        void d(int i3);

        void e(int i3, float f16);
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface e {
        boolean interceptDrawer(View view, MotionEvent motionEvent);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69131);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 41)) {
            redirector.redirect((short) 41);
            return;
        }
        f185112y0 = QLog.isDevelopLevel();
        f185113z0 = 0;
        Argus.INSTANCE.addBlockCreator(new com.tencent.mobileqq.activity.recent.c());
    }

    public DrawerFrame(Context context, ViewGroup viewGroup, ViewGroup viewGroup2, View view, ViewGroup viewGroup3, FrameHelperActivity frameHelperActivity) throws NullPointerException {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, context, viewGroup, viewGroup2, view, viewGroup3, frameHelperActivity);
            return;
        }
        this.f185117d = true;
        this.f185119e = false;
        this.f185121f = false;
        this.f185124h = false;
        this.f185126i = true;
        this.f185131m = 0;
        this.f185123g0 = 0;
        this.f185125h0 = -1;
        this.f185127i0 = 0;
        this.f185128j0 = true;
        this.f185129k0 = true;
        this.f185132m0 = 0L;
        this.f185133n0 = false;
        this.f185134o0 = false;
        this.f185135p0 = false;
        this.f185138s0 = new HashMap();
        this.f185141v0 = true;
        this.f185143x0 = new c();
        if (context != null) {
            Resources resources = context.getResources();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f185116c0 = 0;
            this.T = (int) ((displayMetrics.density * 100.0f) + 0.5d);
            this.V = resources.getDimensionPixelSize(R.dimen.akx);
            this.D = resources.getDimensionPixelSize(R.dimen.auk);
            this.U = 0;
            this.f185126i = true;
            this.I = new WeakReferenceHandler(Looper.getMainLooper(), this);
            this.J = new Scroller(context, new b(0.165f, 0.84f, 0.44f, 1.0f));
            if (context instanceof Activity) {
                this.f185125h0 = ah.V((Activity) context);
            } else {
                this.f185125h0 = context.getResources().getConfiguration().orientation;
            }
            if (f185112y0) {
                C("DrawerFrame", null);
            }
            this.f185140u0 = frameHelperActivity;
            QLog.i(Argus.TAG, 1, "getNodeInfo");
            D(viewGroup, viewGroup2, view, viewGroup3);
            K(this.f185123g0, 1);
            Argus argus = Argus.INSTANCE;
            argus.getNode(viewGroup2, this, true, true);
            argus.getNode(viewGroup, this, true, true);
            return;
        }
        throw new NullPointerException("context is null");
    }

    private void C(String str, Object obj) {
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = this.f185142w0;
            if (sb5 == null) {
                this.f185142w0 = new StringBuilder(120);
            } else {
                sb5.setLength(0);
            }
            StringBuilder sb6 = this.f185142w0;
            sb6.append(str);
            sb6.append(", mConfigurationFlag = ");
            sb6.append(this.f185127i0);
            sb6.append(", mCurOrientation = ");
            sb6.append(this.f185125h0);
            sb6.append(", mDecorOffsetX = ");
            sb6.append(this.f185131m);
            sb6.append(", mLeftDrawerWidth = ");
            sb6.append(this.C);
            sb6.append(", mConfigurationFlag = ");
            sb6.append(this.f185127i0);
            sb6.append(", mWidth = ");
            sb6.append(this.f185120e0);
            sb6.append(", mHeight =");
            sb6.append(this.f185122f0);
            sb6.append(", param = ");
            sb6.append(obj);
            QLog.i("DrawerFrame", 4, this.f185142w0.toString());
        }
    }

    private void E(ViewGroup viewGroup, int i3) {
        ViewGroup viewGroup2 = this.P;
        if (viewGroup != viewGroup2) {
            if (viewGroup2 != null) {
                removeView(viewGroup2);
            }
            this.P = viewGroup;
            if (viewGroup != null) {
                RandomCoverView randomCoverView = (RandomCoverView) viewGroup.findViewById(R.id.f167001jt4);
                if (randomCoverView != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) randomCoverView.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = i3;
                    randomCoverView.setLayoutParams(layoutParams);
                    randomCoverView.setDefaultCoverBg();
                }
                addView(this.P, new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    private void F(ViewGroup viewGroup) {
        ViewGroup viewGroup2 = this.K;
        if (viewGroup != viewGroup2) {
            if (viewGroup2 != null) {
                removeView(viewGroup2);
                ViewGroup viewGroup3 = this.L;
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this);
                    this.L.addView(this.K);
                    this.L.setOnClickListener(null);
                    this.L = null;
                }
            }
            this.K = viewGroup;
            AccessibilityUtil.e(viewGroup, true);
            ViewGroup viewGroup4 = this.K;
            if (viewGroup4 != null) {
                ViewParent parent = viewGroup4.getParent();
                if (parent instanceof ViewGroup) {
                    ViewGroup viewGroup5 = (ViewGroup) parent;
                    this.L = viewGroup5;
                    viewGroup5.removeView(this.K);
                } else {
                    this.L = null;
                }
                addView(this.K, new FrameLayout.LayoutParams(-1, -1));
            }
            if (this.f185126i) {
                if (this.Q == null) {
                    View view = new View(getContext());
                    this.Q = view;
                    view.setBackgroundColor(-16777216);
                    this.Q.setAlpha(0.0f);
                }
                this.f185128j0 = true;
                addView(this.Q, new FrameLayout.LayoutParams(-1, -1));
            } else {
                View view2 = this.Q;
                if (view2 != null) {
                    removeView(view2);
                }
            }
            ViewGroup viewGroup6 = this.L;
            if (viewGroup6 != null) {
                viewGroup6.addView(this);
                this.L.setOnClickListener(new a());
            }
        }
    }

    private void G(ViewGroup viewGroup) {
        ViewGroup viewGroup2 = this.M;
        if (viewGroup != viewGroup2) {
            if (viewGroup2 != null) {
                removeView(viewGroup2);
            }
            this.M = viewGroup;
            if (viewGroup != null) {
                addView(this.M, new FrameLayout.LayoutParams(-1, -1, 19));
            }
        }
    }

    private void H(View view) {
        View view2 = this.N;
        if (view != view2) {
            if (view2 != null) {
                removeView(view2);
            }
            this.N = view;
            if (view != null) {
                addView(this.N, new FrameLayout.LayoutParams(-2, -1, 21));
            }
        }
    }

    private void K(int i3, int i16) {
        int i17;
        int i18;
        int i19;
        int i26;
        int i27 = 8;
        boolean z16 = false;
        if (i16 != 1 && this.f185136q0) {
            i17 = 0;
        } else {
            i17 = 8;
        }
        ViewGroup viewGroup = this.P;
        if (viewGroup != null && viewGroup.getVisibility() != i17) {
            this.P.setVisibility(i17);
        }
        if (i16 != 1 && i3 != 1) {
            i18 = 0;
        } else {
            i18 = 8;
        }
        ViewGroup viewGroup2 = this.M;
        if (viewGroup2 != null && viewGroup2.getVisibility() != i18) {
            this.M.setVisibility(i18);
        }
        if (i16 != 1 && i3 != 0) {
            i19 = 0;
        } else {
            i19 = 8;
        }
        View view = this.N;
        if (view != null && view.getVisibility() != i19) {
            this.N.setVisibility(i19);
        }
        if (i16 != 2 && i16 != 0) {
            i26 = 8;
        } else {
            i26 = 0;
        }
        View view2 = this.Q;
        if (view2 != null && view2.getVisibility() != i26 && this.f185128j0) {
            this.Q.setVisibility(i26);
        }
        if (i16 == 0) {
            i27 = 0;
        }
        View view3 = this.f185118d0;
        if (view3 != null && view3.getVisibility() != i27) {
            this.f185118d0.setVisibility(i27);
        }
        if (i3 != 0) {
            return;
        }
        if (i16 != 1 && i16 != 0) {
            z16 = true;
        }
        this.f185130l0 = z16;
        if (R() && !this.f185130l0) {
            this.K.setRenderEffect(null);
        }
    }

    private void N(int i3, boolean z16) {
        this.f185116c0 = 2;
        if (!this.f185119e) {
            z(i3, z16);
        } else {
            d(z16);
        }
    }

    private void Q(Float f16) {
        RenderEffect createBlurEffect;
        if (R() && this.f185123g0 == 0) {
            float min = Math.min(f16.floatValue() * 8.0f * 2.0f, 8.0f);
            if (min > 0.0f) {
                ViewGroup viewGroup = this.K;
                createBlurEffect = RenderEffect.createBlurEffect(min, min, Shader.TileMode.CLAMP);
                viewGroup.setRenderEffect(createBlurEffect);
            } else if (min == 0.0f) {
                this.K.setRenderEffect(null);
            }
            View view = this.Q;
            if (view != null) {
                view.setAlpha(0.0f);
                return;
            }
            return;
        }
        float floatValue = f16.floatValue() * 0.5f;
        if (this.Q != null) {
            if (ThemeUtil.isNowThemeIsSuperTheme()) {
                this.Q.setAlpha(0.0f);
            } else {
                this.Q.setAlpha(floatValue);
            }
        }
    }

    private boolean R() {
        return false;
    }

    private boolean b() {
        int i3 = this.f185125h0;
        if (i3 == 1 && this.f185120e0 > this.f185122f0) {
            return false;
        }
        if (i3 == 0 && this.f185120e0 < this.f185122f0) {
            return false;
        }
        return true;
    }

    private void d(boolean z16) {
        QLog.i("DrawerFrame", 1, "closeDrawer isDraggable:" + n() + ", drawerOpened:" + this.f185119e);
        ApngImage.pauseByTag(1);
        if (!n()) {
            return;
        }
        if (this.f185121f) {
            this.I.removeMessages(1);
            this.I.removeMessages(2);
            this.I.removeMessages(4);
            this.I.removeMessages(3);
        } else if (!this.f185119e) {
            return;
        }
        ThemeVideoController.getInstance().playMainAnimation();
        this.f185121f = true;
        d dVar = this.S;
        if (dVar != null) {
            dVar.d(this.f185123g0);
        }
        d dVar2 = this.S;
        int i3 = 0;
        if (dVar2 != null) {
            dVar2.c(this.f185123g0, false);
        }
        Scroller scroller = this.J;
        int i16 = this.f185131m;
        int i17 = -i16;
        if (z16) {
            i3 = 300;
        }
        scroller.startScroll(i16, 0, i17, 0, i3);
        this.I.sendEmptyMessage(2);
    }

    private void f(int i3) {
        RandomCoverView randomCoverView = (RandomCoverView) this.P.findViewById(R.id.f167001jt4);
        if (randomCoverView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) randomCoverView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = i3;
            randomCoverView.setLayoutParams(layoutParams);
        }
    }

    private void i() {
        boolean computeScrollOffset = this.J.computeScrollOffset();
        this.J.getCurrX();
        int currX = this.J.getCurrX();
        this.f185131m = currX;
        if (this.K != null) {
            e(this.f185123g0, currX);
        }
        postInvalidate();
        if (!computeScrollOffset) {
            this.f185121f = false;
            this.f185119e = false;
            ViewGroup viewGroup = this.M;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            View view = this.N;
            if (view != null) {
                view.setVisibility(8);
            }
            this.I.sendEmptyMessage(4);
            return;
        }
        this.I.sendEmptyMessage(2);
    }

    private void j() {
        int i3;
        if (q()) {
            int i16 = this.f185123g0;
            if (i16 == 0) {
                int i17 = this.C;
                i3 = i17 - this.f185131m;
                this.f185131m = i17;
            } else if (i16 == 1) {
                int i18 = this.D;
                i3 = (-i18) - this.f185131m;
                this.f185131m = -i18;
            } else {
                i3 = 0;
            }
            if (this.K != null && i3 != 0) {
                String str = Build.BRAND;
                String model = DeviceInfoMonitor.getModel();
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(model) || !str.equalsIgnoreCase("OPPO") || !model.equalsIgnoreCase("PEUM00")) {
                    this.K.offsetLeftAndRight(i3);
                }
                e(this.f185123g0, this.f185131m);
                postInvalidate();
            }
            if (f185112y0) {
                C("MSG_CONFIGURATION_CHANGED", Integer.valueOf(i3));
            }
        }
    }

    private boolean k() {
        QBaseFragment qBaseFragment;
        if (this.f185121f) {
            return true;
        }
        AccessibilityUtil.e(this.K, true);
        d dVar = this.S;
        if (dVar != null) {
            dVar.b(this.f185123g0, this.f185116c0);
            Argus.INSTANCE.updatePage(this.K);
        }
        this.f185116c0 = 0;
        this.f185123g0 = 0;
        this.f185129k0 = true;
        K(0, 1);
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if ((baseActivity instanceof BaseActivity) && (qBaseFragment = (QBaseFragment) baseActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName())) != null) {
            int currentTab = ((MainFragment) qBaseFragment).getCurrentTab();
            if (currentTab == com.tencent.mobileqq.activity.home.impl.a.f183038a) {
                ApngImage.playByTag(2);
            } else if (currentTab == com.tencent.mobileqq.activity.home.impl.a.f183040c) {
                ApngImage.playByTag(3);
            } else if (currentTab == com.tencent.mobileqq.activity.home.impl.a.f183041d) {
                ApngImage.playByTag(4);
            } else if (currentTab == com.tencent.mobileqq.activity.home.impl.a.f183043f) {
                ApngImage.playByTag(5);
            } else if (currentTab == com.tencent.mobileqq.activity.home.impl.a.f183044g) {
                ApngImage.playByTag(8);
            }
        }
        return false;
    }

    private boolean l() {
        if (this.f185121f) {
            return true;
        }
        AccessibilityUtil.e(this.K, false);
        K(this.f185123g0, 0);
        d dVar = this.S;
        if (dVar != null) {
            dVar.a(this.f185123g0, this.f185116c0);
            Argus.INSTANCE.updatePage(this.M);
        }
        this.f185116c0 = 0;
        this.f185129k0 = false;
        ApngImage.playByTag(1);
        return false;
    }

    private void m() {
        boolean computeScrollOffset = this.J.computeScrollOffset();
        this.J.getCurrX();
        int currX = this.J.getCurrX();
        this.f185131m = currX;
        if (this.K != null) {
            e(this.f185123g0, currX);
        }
        postInvalidate();
        if (!computeScrollOffset) {
            this.f185121f = false;
            this.f185119e = true;
            this.I.sendEmptyMessage(3);
            return;
        }
        this.I.sendEmptyMessage(1);
    }

    private boolean n() {
        if (this.f185117d && this.M != null && this.K != null) {
            return true;
        }
        return false;
    }

    private boolean r(View view) {
        if (view != this.P && view != this.M) {
            return false;
        }
        return true;
    }

    private boolean s(int i3, int i16) {
        this.F = i3;
        this.E = i3;
        this.H = i16;
        this.G = i16;
        if (!this.f185119e || i3 > this.U) {
            this.f185124h = true;
        }
        if (this.f185121f) {
            int i17 = this.f185123g0;
            if ((i17 == 0 && i3 > this.f185131m) || (i17 == 1 && i3 < this.f185120e0 + this.f185131m)) {
                this.f185124h = true;
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean t(int i3, int i16, int i17) {
        boolean z16 = false;
        if (!this.f185124h) {
            return false;
        }
        if (SwipeMenuLayout.f() != null) {
            Log.i("DrawerFrame", "SwipeMenuLayout.getViewCache() != null");
            return false;
        }
        if (!this.f185119e && (i16 < this.F || i16 < this.E)) {
            this.f185124h = false;
            return false;
        }
        this.F = i16;
        this.H = i17;
        int abs = Math.abs(i16 - this.E);
        int abs2 = Math.abs(this.H - this.G);
        if (!this.f185119e ? !(abs <= i3 || (abs2 + 0.0f) / abs >= 0.6f) : abs > i3) {
            z16 = true;
        }
        Log.i("DrawerFrame", "onInterceptTouchActionMove ACTION_MOVE dx=" + abs + ",overcameSlop=" + z16 + ",scaledTouchSlop=" + i3 + ",mGestureCurrentX=" + this.F + ",mGestureStartX=" + this.E);
        if (z16 && this.f185121f) {
            this.I.removeMessages(1);
            this.I.removeMessages(2);
            this.I.removeMessages(4);
            this.I.removeMessages(3);
        }
        return z16;
    }

    private boolean u() {
        this.f185124h = false;
        if ((this.f185119e && this.f185123g0 == 0 && this.E > this.C) || (this.f185123g0 == 1 && this.E < this.f185120e0 - this.D)) {
            this.f185116c0 = 3;
            int i3 = this.G;
            if (i3 >= this.f185114a0 && i3 <= this.f185115b0) {
                this.f185116c0 = 4;
            }
            c();
            this.F = -1;
            this.E = -1;
            this.H = -1;
            this.G = -1;
            return true;
        }
        this.F = -1;
        this.E = -1;
        this.H = -1;
        this.G = -1;
        return false;
    }

    private void w() {
        if (this.f185121f) {
            this.I.removeMessages(1);
            this.I.removeMessages(2);
            this.I.removeMessages(4);
            this.I.removeMessages(3);
        }
    }

    private boolean x(int i3) {
        d dVar;
        ApngImage.pauseAll();
        boolean z16 = this.f185121f;
        this.f185121f = true;
        ThemeVideoController.getInstance().playExitAnimation();
        if (!z16 && (dVar = this.S) != null) {
            dVar.d(this.f185123g0);
        }
        this.f185116c0 = 1;
        int i16 = this.f185123g0;
        if (i16 == 0) {
            int i17 = this.f185131m;
            int i18 = i17 + i3;
            int i19 = this.C;
            if (i18 > i19) {
                if (i17 != i19) {
                    this.f185119e = true;
                    this.f185131m = i19;
                    e(i16, i19);
                    invalidate();
                }
                return true;
            }
        }
        if (i16 == 0) {
            int i26 = this.f185131m;
            if (i26 + i3 < 0) {
                if (i26 != 0) {
                    this.f185119e = false;
                    this.f185131m = 0;
                    e(i16, 0);
                    invalidate();
                }
                return true;
            }
        }
        if (i16 == 1) {
            int i27 = this.f185131m;
            int i28 = i27 + i3;
            int i29 = this.D;
            if (i28 < (-i29)) {
                if (i27 != (-i29)) {
                    this.f185119e = true;
                    int i36 = -i29;
                    this.f185131m = i36;
                    e(i16, i36);
                    invalidate();
                }
                return true;
            }
        }
        if (i16 == 1) {
            int i37 = this.f185131m;
            if (i37 + i3 > 0) {
                if (i37 != 0) {
                    this.f185119e = false;
                    this.f185131m = 0;
                    e(i16, 0);
                    invalidate();
                }
                return true;
            }
        }
        int i38 = this.f185131m + i3;
        this.f185131m = i38;
        e(i16, i38);
        invalidate();
        return true;
    }

    private boolean y(ViewConfiguration viewConfiguration) {
        if (this.C == 0) {
            QLog.i("DrawerFrame", 1, "onTouchWhenActionUp mLeftDrawerWidth == 0");
        }
        this.f185124h = false;
        this.f185121f = false;
        this.R.computeCurrentVelocity(1000);
        if (Math.abs(this.R.getXVelocity()) > viewConfiguration.getScaledMinimumFlingVelocity()) {
            if (this.f185123g0 == 0) {
                if (this.R.getXVelocity() > 0.0f) {
                    this.f185119e = false;
                    A();
                } else {
                    this.f185119e = true;
                    c();
                }
            } else if (this.R.getXVelocity() < 0.0f) {
                this.f185119e = false;
                B();
            } else {
                this.f185119e = true;
                c();
            }
        } else if (this.f185123g0 == 0) {
            if (this.f185131m > this.f185120e0 / 2.0d) {
                this.f185119e = false;
                A();
            } else {
                this.f185119e = true;
                c();
            }
        } else if (this.f185131m < (-((this.D / 3.0d) * 2.0d))) {
            this.f185119e = false;
            B();
        } else {
            this.f185119e = true;
            c();
        }
        return true;
    }

    private void z(int i3, boolean z16) {
        int i16;
        int i17;
        QLog.i("DrawerFrame", 1, "openDrawer isDraggable:" + n() + ", drawerOpened:" + this.f185119e);
        if (!n()) {
            return;
        }
        this.f185123g0 = i3;
        if (this.f185121f) {
            this.I.removeMessages(1);
            this.I.removeMessages(2);
            this.I.removeMessages(4);
            this.I.removeMessages(3);
        } else if (this.f185119e) {
            return;
        }
        ThemeVideoController.getInstance().playDrawerAnimation();
        int i18 = this.f185123g0;
        if (i18 == 0) {
            this.M.setVisibility(0);
        } else if (i18 == 1) {
            this.N.setVisibility(0);
        }
        this.f185121f = true;
        d dVar = this.S;
        if (dVar != null) {
            dVar.d(this.f185123g0);
        }
        if (i3 != 0) {
            if (i3 == 1) {
                Scroller scroller = this.J;
                int i19 = this.f185131m;
                int i26 = (-this.D) - i19;
                if (z16) {
                    i17 = 300;
                } else {
                    i17 = 1;
                }
                scroller.startScroll(i19, 0, i26, 0, i17);
            }
        } else {
            Scroller scroller2 = this.J;
            int i27 = this.f185131m;
            int i28 = this.C - i27;
            if (z16) {
                i16 = 300;
            } else {
                i16 = 1;
            }
            scroller2.startScroll(i27, 0, i28, 0, i16);
        }
        d dVar2 = this.S;
        if (dVar2 != null) {
            dVar2.c(i3, true);
        }
        this.I.sendEmptyMessage(1);
    }

    public void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            z(0, true);
        }
    }

    public void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        } else {
            z(1, true);
        }
    }

    public void D(ViewGroup viewGroup, ViewGroup viewGroup2, View view, ViewGroup viewGroup3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, viewGroup, viewGroup2, view, viewGroup3);
            return;
        }
        int width = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        int dip2px = ScreenUtil.dip2px(170.0f);
        if (QLog.isColorLevel()) {
            QLog.d("DrawerFrame", 2, "Screen:(" + width + "," + ScreenUtil.SCREEN_HIGHT + ") cover:(" + dip2px + ")");
        }
        F(viewGroup);
        E(viewGroup3, dip2px);
        G(viewGroup2);
        H(view);
        if (this.M != null && this.f185118d0 == null) {
            View view2 = new View(getContext());
            this.f185118d0 = view2;
            view2.setFocusable(true);
            this.f185118d0.setFocusableInTouchMode(true);
            this.f185118d0.setClickable(true);
            this.f185118d0.setVisibility(8);
            this.f185118d0.setBackgroundResource(17170445);
            this.f185118d0.setContentDescription(HardCodeUtil.qqStr(R.string.lst));
            addView(this.f185118d0, new FrameLayout.LayoutParams(this.C, this.W, 21));
        }
    }

    public void I(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.f185138s0.remove(Integer.valueOf(i3));
        }
    }

    public void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("DrawerFrame", 4, "resetDrawer()");
        }
        this.I.removeMessages(1);
        this.I.removeMessages(2);
        this.I.removeMessages(4);
        this.I.removeMessages(3);
        this.f185121f = false;
        this.f185123g0 = 0;
        this.f185131m = 0;
        ViewGroup viewGroup = this.K;
        if (viewGroup != null) {
            viewGroup.offsetLeftAndRight(0 - viewGroup.getLeft());
        }
        e(this.f185123g0, this.f185131m);
        postInvalidate();
        if (this.f185119e) {
            this.f185119e = false;
            this.I.sendEmptyMessage(4);
        }
        K(this.f185123g0, 1);
        f185113z0 = 0;
    }

    protected void L(View view, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, view, Float.valueOf(f16));
            return;
        }
        if (view == null) {
            return;
        }
        if (f16 > 0.0f) {
            this.f185143x0.a(x.c(BaseApplication.getContext(), f16));
            view.setOutlineProvider(this.f185143x0);
            view.setClipToOutline(true);
        } else {
            view.setOutlineProvider(null);
            view.setClipToOutline(false);
        }
    }

    public void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("DrawerFrame", 2, "stopMovingOnPause");
        }
        if (this.f185123g0 == 0) {
            if (this.f185131m > this.f185120e0 / 2.0d) {
                this.f185119e = false;
                A();
                return;
            } else {
                this.f185119e = true;
                c();
                return;
            }
        }
        if (this.f185131m < (-((this.D / 3.0d) * 2.0d))) {
            this.f185119e = false;
            B();
        } else {
            this.f185119e = true;
            c();
        }
    }

    public void O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            N(0, true);
        }
    }

    public void P() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            N(1, true);
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        View view = this.Q;
        if (view != null) {
            view.setVisibility(0);
        }
        this.f185128j0 = true;
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            d(true);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i3;
        boolean z16;
        e eVar;
        QBaseFragment qBaseFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) motionEvent)).booleanValue();
        }
        QQAppInterface qQAppInterface = (QQAppInterface) this.f185140u0.getQBaseActivity().getAppRuntime();
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if ((baseActivity instanceof BaseActivity) && (qBaseFragment = (QBaseFragment) baseActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName())) != null) {
            i3 = ((MainFragment) qBaseFragment).getCurrentTab();
        } else {
            i3 = -1;
        }
        if (!qQAppInterface.isInCallList && this.f185129k0) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            if (obtain != null && i3 != -1 && (eVar = this.f185138s0.get(Integer.valueOf(i3))) != null) {
                z16 = eVar.interceptDrawer(this, obtain);
            } else {
                z16 = false;
            }
            if (obtain != null) {
                obtain.recycle();
            }
        } else {
            z16 = false;
        }
        if (motionEvent.getAction() == 0) {
            this.f185139t0 = false;
        }
        if (this.f185139t0 && !z16) {
            motionEvent.setAction(0);
        }
        this.f185139t0 = z16;
        if (z16) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j3) {
        int right;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, this, canvas, view, Long.valueOf(j3))).booleanValue();
        }
        if (this.f185123g0 != 0) {
            return super.drawChild(canvas, view, j3);
        }
        int height = getHeight();
        boolean r16 = true ^ r(view);
        int width = getWidth();
        int save = canvas.save();
        if (r16) {
            int childCount = getChildCount();
            int i3 = 0;
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt = getChildAt(i16);
                if (childAt.getVisibility() == 0 && r(childAt) && childAt.getHeight() >= height && (right = childAt.getRight() + ((int) childAt.getTranslationX())) > i3) {
                    i3 = right;
                }
            }
            canvas.clipRect(i3, 0, width, getHeight());
        }
        boolean drawChild = super.drawChild(canvas, view, j3);
        canvas.restoreToCount(save);
        return drawChild;
    }

    @TargetApi(11)
    protected void e(int i3, int i16) {
        float f16;
        int i17;
        float f17;
        QBaseFragment qBaseFragment;
        float f18;
        float f19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        K(i3, 2);
        if (i3 == 0) {
            f16 = i16;
            i17 = this.C;
        } else {
            f16 = -i16;
            i17 = this.D;
        }
        float f26 = f16 / i17;
        if (Float.isNaN(f26)) {
            f26 = 0.0f;
        }
        float f27 = 1.0f;
        float f28 = 1.0f - (0.100000024f * f26);
        if (ThemeUtil.isNowThemeIsSuperTheme() || Float.isNaN(f28)) {
            f28 = 1.0f;
        }
        float f29 = 30.0f * f26;
        ViewGroup viewGroup = this.K;
        if (viewGroup != null) {
            viewGroup.setPivotX(viewGroup.getWidth() / 2.0f);
            this.K.setPivotY(r5.getHeight() / 2.0f);
            this.K.setScaleX(f28);
            this.K.setScaleY(f28);
            L(this.K, f29);
            float f36 = 1.0f - (f26 / 0.2f);
            if (ThemeUtil.isNowThemeIsSuperTheme()) {
                f27 = f36;
            }
            ViewGroup viewGroup2 = this.K;
            if (f27 < 0.0f) {
                f17 = 0.0f;
            } else {
                f17 = f27;
            }
            viewGroup2.setAlpha(f17);
            BaseActivity baseActivity = BaseActivity.sTopActivity;
            if (baseActivity != null && (qBaseFragment = (QBaseFragment) baseActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName())) != null) {
                MainFragment mainFragment = (MainFragment) qBaseFragment;
                if (mainFragment.mTabDragIcon != null) {
                    for (int i18 = 0; i18 < mainFragment.mTabDragIcon.size(); i18++) {
                        TabDragAnimationView valueAt = mainFragment.mTabDragIcon.valueAt(i18);
                        valueAt.setPivotX(valueAt.getWidth() / 2.0f);
                        valueAt.setPivotY(valueAt.getHeight() / 2.0f);
                        if (f27 < 0.0f) {
                            f18 = 0.0f;
                        } else {
                            f18 = f27;
                        }
                        valueAt.setScaleX(f18);
                        if (f27 < 0.0f) {
                            f19 = 0.0f;
                        } else {
                            f19 = f27;
                        }
                        valueAt.setScaleY(f19);
                    }
                }
            }
        }
        Q(Float.valueOf(f26));
        ViewGroup viewGroup3 = this.P;
        if (viewGroup3 != null) {
            viewGroup3.setTranslationX(i16 - this.C);
        }
        this.M.setTranslationX(i16 - this.C);
        d dVar = this.S;
        if (dVar != null) {
            dVar.e(this.f185123g0, f26);
        }
    }

    public View g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (View) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        return this.K;
    }

    public View h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (View) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        return this.M;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            j();
                        }
                    } else {
                        k();
                        return true;
                    }
                } else {
                    l();
                    return true;
                }
            } else {
                i();
            }
        } else {
            m();
        }
        return true;
    }

    public boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return this.f185117d;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) configuration);
            return;
        }
        int i3 = configuration.orientation;
        if (i3 != this.f185125h0) {
            this.f185125h0 = i3;
            if (q() && this.f185127i0 == 0) {
                this.f185127i0 = 1;
            }
            if (f185112y0) {
                C("onConfigurationChanged", Boolean.valueOf(q()));
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!n()) {
            Log.i("DrawerFrame", "onInterceptTouchEvent !isDraggable()");
            return false;
        }
        if (!this.f185141v0) {
            Log.i("DrawerFrame", "onInterceptTouchEvent !iisTouchable");
            return false;
        }
        int scaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        int x16 = (int) (motionEvent.getX() + 0.5f);
        int y16 = (int) (motionEvent.getY() + 0.5f);
        int action = motionEvent.getAction() & 255;
        Log.i("DrawerFrame", "onInterceptTouchEvent onInterceptTouchEvent=action" + action + "\uff0ccurX=" + x16 + "\uff0ccurY=" + y16);
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    QLog.i("DrawerFrame", 1, "onInterceptTouchEvent !iisTouchable");
                    return false;
                }
                return t(scaledTouchSlop, x16, y16);
            }
            return u();
        }
        return s(x16, y16);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        ViewGroup viewGroup = this.P;
        if (viewGroup != null && viewGroup.getVisibility() != 8) {
            try {
                this.P.layout(i3, i16, i17, i18);
            } catch (Exception e16) {
                QLog.e("DrawerFrame", 1, "mBgView layout error");
                throw e16;
            }
        }
        ViewGroup viewGroup2 = this.M;
        if (viewGroup2 != null && viewGroup2.getVisibility() != 8) {
            try {
                this.M.layout(i3, i16, i17, i18);
            } catch (Exception e17) {
                QLog.e("DrawerFrame", 1, "mLeftDrawerContent layout error");
                throw e17;
            }
        }
        View view = this.Q;
        if (view != null) {
            try {
                view.layout(i3, i16, i17, i18);
            } catch (Exception e18) {
                QLog.e("DrawerFrame", 1, "mDrawerMaskView layout error");
                throw e18;
            }
        }
        View view2 = this.N;
        if (view2 != null && view2.getVisibility() != 8) {
            try {
                this.N.layout(i17 - this.D, this.f185114a0, i17, this.f185115b0);
            } catch (Exception e19) {
                QLog.e("DrawerFrame", 1, "mRightDrawerContent layout error");
                throw e19;
            }
        }
        ViewGroup viewGroup3 = this.K;
        if (viewGroup3 != null && viewGroup3.getVisibility() != 8) {
            try {
                ViewGroup viewGroup4 = this.K;
                viewGroup4.layout(viewGroup4.getLeft(), this.K.getTop(), this.K.getLeft() + i17, i18);
            } catch (Exception e26) {
                QLog.e("DrawerFrame", 1, "mContentView layout error");
                throw e26;
            }
        }
        View view3 = this.f185118d0;
        if (view3 != null && view3.getVisibility() != 8) {
            try {
                int i19 = this.f185123g0;
                if (i19 == 0) {
                    View view4 = this.f185118d0;
                    int i26 = this.C;
                    view4.layout(i26, this.f185114a0, this.V + i26, this.f185115b0);
                } else if (i19 == 1) {
                    this.f185118d0.layout(0, this.f185114a0, i17 - this.D, this.f185115b0);
                }
            } catch (Exception e27) {
                QLog.e("DrawerFrame", 1, "mDCMaskView layout error");
                throw e27;
            }
        }
        if (b()) {
            if (this.f185127i0 == 2) {
                this.f185127i0 = 0;
                if (!this.I.hasMessages(5)) {
                    this.I.sendEmptyMessage(5);
                }
                if (f185112y0) {
                    C("onLayout", "valid orientation");
                    return;
                }
                return;
            }
            return;
        }
        if (f185112y0) {
            C("onLayout", "not valid orientation");
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        this.f185120e0 = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f185122f0 = measuredHeight;
        this.C = this.f185120e0 - this.V;
        int i17 = (int) ((measuredHeight * 0.9f) + 0.5d);
        this.W = i17;
        int i18 = (int) ((measuredHeight * 0.100000024f) / 2.0f);
        this.f185114a0 = i18;
        this.f185115b0 = i18 + i17;
        View view = this.N;
        if (view != null) {
            view.getLayoutParams().height = this.W;
        }
        if (b()) {
            if (this.f185127i0 == 1) {
                this.f185127i0 = 2;
                if (f185112y0) {
                    C("onMeasure", "valid orientation");
                    return;
                }
                return;
            }
            return;
        }
        if (f185112y0) {
            C("onMeasure", "not valid orientation");
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!n()) {
            Log.i("DrawerFrame", "onTouchEvent !isDraggable");
            return false;
        }
        if (!this.f185141v0) {
            Log.i("DrawerFrame", "onTouchEvent !isTouchable");
            return false;
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        int x16 = (int) (motionEvent.getX() + 0.5f);
        int y16 = (int) (motionEvent.getY() + 0.5f);
        int i3 = x16 - this.F;
        if (this.R == null) {
            this.R = VelocityTracker.obtain();
        }
        this.R.addMovement(motionEvent);
        this.F = x16;
        this.H = y16;
        int action = motionEvent.getAction() & 255;
        Log.i("DrawerFrame", "onTouchEvent action=" + action);
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    return false;
                }
            } else {
                return y(viewConfiguration);
            }
        } else {
            w();
        }
        return x(i3);
    }

    public boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        return this.f185121f;
    }

    public boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        return this.f185119e;
    }

    public void setBgViewVisibility(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        if (this.f185136q0 != z16) {
            QLog.i("DrawerFrame", 1, "setBgViewVisibility: " + z16);
            this.f185136q0 = z16;
            if (this.f185119e) {
                K(0, 0);
            }
        }
    }

    public void setDrawerCallbacks(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) dVar);
        } else {
            this.S = dVar;
        }
    }

    public void setDrawerEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
        } else {
            this.f185117d = z16;
        }
    }

    public void setDrawerShadowFlag(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.f185128j0 = z16;
        }
    }

    public void setIsQQSettingMeInit(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
        }
    }

    public void setMiniAppTouchEventInterceptor(int i3, e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3, (Object) eVar);
        } else {
            this.f185138s0.put(Integer.valueOf(i3), eVar);
        }
    }

    public void setStoryTouchEventInterceptor(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) eVar);
        } else {
            this.f185137r0 = eVar;
        }
    }

    public void v(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DrawerFrame", 2, "onMultiWindowModeChanged, isInMultiWindowMode:" + z16);
        }
        f(ScreenUtil.dip2px(170.0f));
    }
}
