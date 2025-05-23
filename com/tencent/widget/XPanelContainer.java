package com.tencent.widget;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.voicetextpanel.view.BaseVoicetoTextView;
import com.tencent.mobileqq.emoticonview.EmoticonPanelViewBinder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.p;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AnimateUtils;
import com.tencent.util.VersionUtils;
import com.tencent.widget.api.IFitSystemWindowsUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarTintManager;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppActivity;

/* loaded from: classes27.dex */
public class XPanelContainer extends FrameLayout implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: e0, reason: collision with root package name */
    private static int f384711e0;

    /* renamed from: f0, reason: collision with root package name */
    private static boolean f384712f0;

    /* renamed from: g0, reason: collision with root package name */
    private static boolean f384713g0;

    /* renamed from: h0, reason: collision with root package name */
    public static int f384714h0;

    /* renamed from: i0, reason: collision with root package name */
    public static int f384715i0;

    /* renamed from: j0, reason: collision with root package name */
    public static int f384716j0;

    /* renamed from: k0, reason: collision with root package name */
    public static volatile int f384717k0;

    /* renamed from: l0, reason: collision with root package name */
    public static boolean f384718l0;

    /* renamed from: m0, reason: collision with root package name */
    private static boolean f384719m0;
    private int C;
    private g D;
    private View E;
    boolean F;
    private SparseArray<View> G;
    private int H;
    private int I;
    private int J;
    private boolean K;
    private boolean L;
    private boolean M;
    private int N;
    private boolean P;
    public boolean Q;
    private int R;
    protected int S;
    private boolean T;
    protected boolean U;
    protected boolean V;
    private boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f384720a0;

    /* renamed from: b0, reason: collision with root package name */
    private final ConcurrentLinkedQueue<WeakReference<f>> f384721b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f384722c0;

    /* renamed from: d, reason: collision with root package name */
    private List<com.tencent.widget.h> f384723d;

    /* renamed from: d0, reason: collision with root package name */
    private long f384724d0;

    /* renamed from: e, reason: collision with root package name */
    private int f384725e;

    /* renamed from: f, reason: collision with root package name */
    protected int f384726f;

    /* renamed from: h, reason: collision with root package name */
    protected int f384727h;

    /* renamed from: i, reason: collision with root package name */
    private int f384728i;

    /* renamed from: m, reason: collision with root package name */
    private View f384729m;

    /* loaded from: classes27.dex */
    class a implements View.OnSystemUiVisibilityChangeListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) XPanelContainer.this);
            }
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i3) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (i3 != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (XPanelContainer.f384718l0 != z16) {
                XPanelContainer.this.P = true;
                XPanelContainer.f384718l0 = z16;
            }
            if (QLog.isColorLevel()) {
                QLog.d("XPanelContainer", 2, "onSystemUiVisibilityChange..visibility =  " + i3 + " context = " + XPanelContainer.this.getContext().getClass().getName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes27.dex */
    public class b implements View.OnFocusChangeListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) XPanelContainer.this);
            }
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Boolean.valueOf(z16));
            } else if (QLog.isColorLevel() && (XPanelContainer.this.getContext() instanceof Activity)) {
                QLog.d("XPanelContainer", 2, "input focus changed, hasFocus=", Boolean.valueOf(z16), ", current focus=", ((Activity) XPanelContainer.this.getContext()).getCurrentFocus());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes27.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f384732d;

        c(int i3) {
            this.f384732d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) XPanelContainer.this, i3);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            XPanelContainer xPanelContainer = XPanelContainer.this;
            if (!xPanelContainer.F) {
                xPanelContainer.f384722c0 = this.f384732d - intValue;
                XPanelContainer.this.requestLayout();
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("XPanelContainer", 2, "openAnim resetPosition");
                }
                XPanelContainer.this.f384722c0 = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes27.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f384734d;

        d(int i3) {
            this.f384734d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) XPanelContainer.this, i3);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            XPanelContainer xPanelContainer = XPanelContainer.this;
            if (!xPanelContainer.F) {
                xPanelContainer.f384722c0 = this.f384734d - intValue;
                XPanelContainer.this.requestLayout();
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("XPanelContainer", 2, "colseAnim resetPosition");
                }
                XPanelContainer.this.f384722c0 = 0;
            }
        }
    }

    /* loaded from: classes27.dex */
    public interface e {
    }

    /* loaded from: classes27.dex */
    public interface f {
        void a(int i3, int i16);
    }

    /* loaded from: classes27.dex */
    public interface g {
        void E();

        View E2(int i3);

        boolean T(int i3);

        void onPanelChanged(int i3, int i16);
    }

    /* loaded from: classes27.dex */
    public interface h {
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29388);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 38)) {
            redirector.redirect((short) 38);
            return;
        }
        f384712f0 = true;
        f384713g0 = false;
        f384713g0 = VersionUtils.isHoneycomb();
    }

    @TargetApi(11)
    public XPanelContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        int i3 = 0;
        this.f384726f = 0;
        this.f384727h = -1;
        this.f384728i = -1;
        this.C = 0;
        this.F = false;
        this.G = new SparseArray<>(4);
        this.H = -1;
        this.I = -1;
        this.J = -1;
        this.Q = true;
        this.S = 0;
        this.T = true;
        this.V = false;
        this.W = true;
        this.f384720a0 = true;
        this.f384721b0 = new ConcurrentLinkedQueue<>();
        this.f384722c0 = 0;
        this.f384724d0 = -1L;
        w();
        if (f384714h0 == 0) {
            f384715i0 = (int) (o() * context.getResources().getDisplayMetrics().density);
            f384714h0 = p();
            if (SystemBarTintManager.hasNavBar(context)) {
                i3 = SystemBarTintManager.getNavigationBarHeight(context);
                f384716j0 = (int) ((context.getResources().getDisplayMetrics().heightPixels + i3) * 0.5d);
            } else {
                f384716j0 = (int) (context.getResources().getDisplayMetrics().heightPixels * 0.5d);
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.aio.XPanelContainer", 2, " mMAXExternalPanelheight = " + f384716j0 + "mExternalPanelheight=" + f384714h0);
            }
            if (QLog.isColorLevel()) {
                QLog.d("XPanelContainer", 2, " mDefaultExternalPanelheight = " + f384715i0 + "mMAXExternalPanelheight=" + f384716j0 + "density=" + context.getResources().getDisplayMetrics().density + "mNavigationBarHeight=" + i3);
            }
        }
        this.N = ImmersiveUtils.getStatusBarHeight(getContext());
        if (Build.VERSION.SDK_INT >= 24 || wy2.a.a()) {
            return;
        }
        setOnSystemUiVisibilityChangeListener(new a());
    }

    private boolean A() {
        return this.f384720a0;
    }

    private boolean B() {
        if (ah.p0() && Build.VERSION.SDK_INT >= 30) {
            return true;
        }
        return false;
    }

    private boolean C(int i3, int i16, int i17, int i18, View view) {
        if (!f384718l0) {
            return false;
        }
        f384715i0 = (int) (o() * getContext().getResources().getDisplayMetrics().density);
        f384714h0 = r();
        f384717k0 = 0;
        int i19 = this.S;
        if (i19 == 1) {
            if (view != null) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i17 - i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i18 - i16, 1073741824));
                view.layout(i3, i16, i17, i18);
            }
        } else if (i19 == 0) {
            if (view != null) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i17 - i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i18 - i16, 1073741824));
                view.layout(i3, i16, i17, i18);
            }
        } else {
            View view2 = this.E;
            if (view2 != null && view2.getVisibility() == 0) {
                int i26 = i17 - i3;
                this.E.measure(View.MeasureSpec.makeMeasureSpec(i26, 1073741824), View.MeasureSpec.makeMeasureSpec(f384714h0, 1073741824));
                this.E.layout(i3, i18 - f384714h0, i17, i18);
                if (view != null) {
                    view.measure(View.MeasureSpec.makeMeasureSpec(i26, 1073741824), View.MeasureSpec.makeMeasureSpec((i18 - i16) - f384714h0, 1073741824));
                    view.layout(i3, i16, i17, i18 - f384714h0);
                }
            } else {
                this.S = 0;
                this.f384727h = -1;
                M(0);
                requestLayout();
                return true;
            }
        }
        M(this.S);
        this.f384727h = 0;
        return true;
    }

    private void E(int i3, int i16) {
        Iterator<WeakReference<f>> it = this.f384721b0.iterator();
        while (it.hasNext()) {
            f fVar = it.next().get();
            if (fVar != null) {
                fVar.a(i3, i16);
            }
        }
    }

    private boolean G(int i3, int i16, int i17, int i18, boolean z16, View view) {
        int visibility;
        if (QLog.isDevelopLevel()) {
            View view2 = this.E;
            if (view2 == null) {
                visibility = 0;
            } else {
                visibility = view2.getVisibility();
            }
            QLog.d("Q.aio.XPanelContainer", 4, " onLayout bom panel ,confirm it mExternalPanelheight= " + f384714h0 + " bottom = " + i18 + "  mCurPanel.getVisibility() " + visibility);
        }
        View view3 = this.E;
        if (view3 != null && view3.getVisibility() == 0) {
            if (QLog.isDevelopLevel()) {
                QLog.d("Q.aio.XPanelContainer", 4, " onLayout bom panel ,confirm it vp.ViewParent = " + this.E.getParent().getClass().getName());
            }
            if (view != null) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i17 - i3, 1073741824), View.MeasureSpec.makeMeasureSpec((i18 - i16) - f384714h0, 1073741824));
                view.layout(i3, i16, i17, i18 - f384714h0);
            }
            View view4 = this.E;
            if (!(view4 instanceof BaseVoicetoTextView)) {
                view4.measure(View.MeasureSpec.makeMeasureSpec(i17 - i3, 1073741824), View.MeasureSpec.makeMeasureSpec(f384714h0, 1073741824));
                this.E.layout(i3, i18 - f384714h0, i17, i18);
            } else {
                ((BaseVoicetoTextView) view4).d(i3, i18 - f384714h0, i17, i18, z16);
            }
            return false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("Q.aio.XPanelContainer", 4, " onLayout panel hold on error ,restore status NONE ");
        }
        H(i18);
        M(0);
        this.f384727h = -1;
        requestLayout();
        return true;
    }

    private void H(int i3) {
        boolean z16;
        this.C++;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(" mDefaultBottom= ");
        sb5.append(this.f384725e);
        sb5.append(" mExternalPanelHeight= ");
        sb5.append(f384714h0);
        sb5.append(" mDefaultExternalPanelHeight= ");
        sb5.append(f384715i0);
        sb5.append(" mNormalSize=");
        sb5.append(this.f384728i);
        sb5.append(" mAnimationPosition=");
        sb5.append(this.f384722c0);
        sb5.append(" mStatus=");
        sb5.append(this.f384726f);
        sb5.append(" mPendingStatus=");
        sb5.append(this.f384727h);
        sb5.append(" mSoftInputShowing=");
        sb5.append(this.V);
        sb5.append(" mCurPanel == null : ");
        if (this.E == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append(" mMaxExternalPanelHeight= ");
        sb5.append(f384716j0);
        sb5.append(" sInputMethodPanelHeight= ");
        sb5.append(f384711e0);
        sb5.append(" bottom= ");
        sb5.append(i3);
        sb5.append(" printDebugLogTimes= ");
        sb5.append(this.C);
        QLog.d("XPanelContainer", 1, sb5.toString());
    }

    private void I() {
        postDelayed(new Runnable() { // from class: com.tencent.widget.XPanelContainer.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) XPanelContainer.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    View findViewById = ((Activity) XPanelContainer.this.getContext()).findViewById(R.id.rlCommenTitle);
                    int[] iArr = new int[2];
                    findViewById.getLocationInWindow(iArr);
                    QLog.d("XPanelContainer", 1, "getLocationInWindow:" + Arrays.toString(iArr));
                    findViewById.getLocationOnScreen(iArr);
                    QLog.d("XPanelContainer", 1, "getLocationOnScreen:" + Arrays.toString(iArr));
                    Rect rect = new Rect();
                    findViewById.getLocalVisibleRect(rect);
                    QLog.d("XPanelContainer", 1, "getLocalVisibleRect: " + rect.toString());
                    QLog.d("XPanelContainer", 1, "status bar height:" + ImmersiveUtils.getStatusBarHeight(XPanelContainer.this.getContext()));
                    QLog.d("XPanelContainer", 1, "title bar height:" + findViewById.getHeight());
                } catch (Exception e16) {
                    QLog.e("XPanelContainer", 1, e16, new Object[0]);
                }
            }
        }, 200L);
    }

    private void K() {
        if (f384717k0 != 0) {
            i();
        }
        f384717k0 = 0;
        f384711e0 = 0;
        f384712f0 = false;
        p.g(BaseApplication.getContext(), "", true, "sp_key_input_height", 0);
        int o16 = (int) (o() * getContext().getResources().getDisplayMetrics().density);
        f384715i0 = o16;
        f384714h0 = o16;
        this.f384725e = 0;
    }

    private void L() {
        int i3 = f384711e0;
        if (i3 > 0) {
            p.g(BaseApplication.getContext(), "", true, "sp_key_input_height", Integer.valueOf(i3));
            if (QLog.isColorLevel()) {
                QLog.i("XPanelContainer", 2, "saveInputMethodPanelHeight.height = " + i3);
            }
        }
    }

    private void P(int i3, boolean z16) {
        if (QLog.isDevelopLevel()) {
            QLog.d("Q.aio.XPanelContainer", 4, " showExternalPanel mAnimationPosition= " + this.f384722c0 + "mExternalPanelheight=" + f384714h0);
        }
        if (this.f384722c0 > 0) {
            return;
        }
        this.f384727h = i3;
        URLDrawable.pause();
        ApngImage.pauseByTag(0);
        this.M = z16;
        if (f384713g0 && z16) {
            this.K = true;
            int height = getHeight();
            ValueAnimator ofInt = ValueAnimator.ofInt(height, height - f384714h0);
            ofInt.setDuration(150L);
            ofInt.addUpdateListener(new c(height));
            ofInt.start();
            return;
        }
        this.f384722c0 = f384714h0;
        this.f384724d0 = AnimationUtils.currentAnimationTimeMillis();
        this.f384727h = -1;
        M(i3);
        requestLayout();
    }

    private void Q(int i3) {
        int i16 = this.f384722c0;
        if (i16 != 0 && i16 != f384714h0) {
            if (QLog.isColorLevel()) {
                QLog.d("XPanelContainer", 2, "mAnimationPosition went wrong. mAnimationPosition = ", Integer.valueOf(this.f384722c0), " mExternalPanelheight = ", Integer.valueOf(f384714h0));
            }
            H(-1);
            this.f384722c0 = f384714h0;
            this.f384724d0 = AnimationUtils.currentAnimationTimeMillis();
        }
        this.f384727h = i3;
        v();
        if (this.f384722c0 == 0 && !this.U && this.f384728i > 0 && getHeight() >= this.f384728i) {
            if (QLog.isColorLevel()) {
                QLog.w("XPanelContainer", 2, "soft input status error, reset");
            }
            J();
        }
    }

    private boolean R(int i3) {
        if (!f384718l0) {
            return false;
        }
        if (i3 == 1) {
            if (this.f384729m.requestFocusFromTouch()) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.aio.XPanelContainer", 2, " requestFocusFromTouch success ");
                }
            } else if (QLog.isColorLevel()) {
                QLog.e("Q.aio.XPanelContainer", 2, " requestFocusFromTouch fail ");
            }
            BaseAIOUtils.o(this.f384729m);
            View view = this.E;
            if (view != null) {
                view.setVisibility(8);
            }
        } else if (i3 > 1) {
            v();
            if (this.f384726f == 1) {
                this.f384726f = 0;
            }
            View view2 = this.G.get(i3);
            if (view2 != null && this.D.T(i3)) {
                this.G.remove(i3);
                removeView(view2);
                view2 = null;
            }
            if (view2 == null) {
                try {
                    view2 = this.D.E2(i3);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("XPanelContainer", 2, e16, new Object[0]);
                    }
                }
                if (view2 == null) {
                    return true;
                }
                addView(view2);
                this.G.put(i3, view2);
            }
            View view3 = this.E;
            if (view2 != view3) {
                if (view3 != null) {
                    view3.setVisibility(8);
                }
                view2.setVisibility(0);
                this.E = view2;
            }
        } else {
            s();
        }
        requestLayout();
        return true;
    }

    private void T(boolean z16, int i3, int i16, int i17, int i18, boolean z17, View view) {
        int i19;
        int i26;
        if (QLog.isDevelopLevel()) {
            QLog.d("Q.aio.XPanelContainer", 4, " onLayout bom panel mannule layout  =  softInputShowing " + z17 + " changed = " + z16);
        }
        if (z17 && z16) {
            requestLayout();
            return;
        }
        e();
        if (f384713g0 && this.M) {
            if (this.K) {
                i19 = this.f384722c0;
            } else {
                i19 = f384714h0;
            }
        } else {
            if (!this.M) {
                this.M = true;
            }
            i19 = f384714h0 - this.f384722c0;
        }
        int i27 = i19;
        View view2 = this.E;
        if (view2 == null) {
            QLog.e("XPanelContainer", 1, " onLayout panel error:curPanel==nulll ,restore status NONE ");
            H(i18);
            M(0);
            this.f384727h = -1;
            requestLayout();
            return;
        }
        if (view2 instanceof BaseVoicetoTextView) {
            int i28 = i18 - i27;
            i26 = 1073741824;
            ((BaseVoicetoTextView) view2).d(i3, i28, i17, i28 + f384714h0, z17);
        } else {
            i26 = 1073741824;
            view2.measure(View.MeasureSpec.makeMeasureSpec(i17 - i3, 1073741824), View.MeasureSpec.makeMeasureSpec(f384714h0, 1073741824));
            int i29 = i18 - i27;
            this.E.layout(i3, i29, i17, f384714h0 + i29);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("Q.aio.XPanelContainer", 4, " onLayout bom panel mannule layout calcposition d= " + i27 + "mAnimationPosition = " + this.f384722c0 + "isOpenAnim=" + this.K + "mExternalPanelheight=" + f384714h0);
        }
        if (view != null && view != this.E) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i17 - i3, i26), View.MeasureSpec.makeMeasureSpec((i18 - i16) - i27, i26));
            view.layout(i3, i16, i17, i18 - i27);
        }
        if (!this.K && (this.f384722c0 == 0 || this.f384727h > 1)) {
            M(this.f384727h);
            this.f384727h = -1;
            if (QLog.isDevelopLevel()) {
                QLog.d("Q.aio.XPanelContainer", 4, " onLayout bom panel mannule layout,end \uff0cnot canvas =  isOpenAnim " + this.K + " mAnimationPosition = " + this.f384722c0);
                return;
            }
            return;
        }
        if (!f384713g0) {
            postDelayed(this, 1L);
        }
    }

    private boolean V(int i3) {
        if (this.f384726f != 3) {
            return false;
        }
        int i16 = this.f384725e - i3;
        boolean z16 = true;
        if (QLog.isDevelopLevel()) {
            QLog.d("XPanelContainer", 4, " showSoftInputWithAnim inputHeight ", Integer.valueOf(i16), " mExternalPanelheight = ", Integer.valueOf(f384714h0), " mDefaultExternalPanelheight = ", Integer.valueOf(f384715i0), " mAddedHeight = ", f384717k0 + " bottom is " + i3);
        }
        int o16 = (int) (o() * getContext().getResources().getDisplayMetrics().density);
        f384715i0 = o16;
        if (i16 <= o16 || i16 >= f384716j0) {
            z16 = false;
        }
        f384712f0 = z16;
        f384719m0 = y();
        if (!f384712f0) {
            return false;
        }
        if (f384711e0 != i16) {
            f384711e0 = i16;
            f384717k0 = i16 - f384715i0;
            L();
        }
        throw null;
    }

    @TargetApi(11)
    private void e() {
        if (f384713g0 && this.M) {
            if (this.K) {
                if (this.f384722c0 >= f384714h0) {
                    this.f384722c0 = 0;
                    this.K = false;
                    return;
                }
                return;
            }
            if (this.L && this.f384722c0 <= 0) {
                this.f384722c0 = 0;
                this.L = false;
                return;
            }
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() >= this.f384724d0 + 0) {
            this.f384722c0 = 0;
        } else {
            this.f384722c0 = (int) (f384714h0 - (AnimateUtils.viscousFluid(((float) (AnimationUtils.currentAnimationTimeMillis() - this.f384724d0)) / 0.0f) * f384714h0));
        }
    }

    private void f(boolean z16) {
        List<com.tencent.widget.h> list = this.f384723d;
        if (list != null) {
            for (com.tencent.widget.h hVar : list) {
                if (!hVar.a(z16)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("XPanelContainer", 2, "don't hide keyboard, it intercepted by " + hVar);
                        return;
                    }
                    return;
                }
            }
        }
        v();
    }

    private void g() {
        if (getContext() instanceof AppActivity) {
            int i3 = ((Activity) getContext()).getWindow().getAttributes().softInputMode;
            if ((i3 & 255) != 18) {
                QLog.e("XPanelContainer", 1, "illegal soft input mode: " + i3);
                I();
                ((Activity) getContext()).getWindow().setSoftInputMode((i3 & (-256)) | 18);
                requestLayout();
            }
        }
    }

    private void h() {
        boolean z16;
        boolean isInMultiWindowMode;
        if (Build.VERSION.SDK_INT >= 24) {
            if (f384718l0) {
                long currentTimeMillis = System.currentTimeMillis();
                if (getContext() instanceof Activity) {
                    isInMultiWindowMode = ((Activity) getContext()).isInMultiWindowMode();
                    QLog.d("XPanelContainer", 1, "targetSdk > 24 tmpIsMultiScreen= " + isInMultiWindowMode + ",calltime = " + (System.currentTimeMillis() - currentTimeMillis));
                    if (f384718l0 != isInMultiWindowMode) {
                        this.P = true;
                        f384718l0 = isInMultiWindowMode;
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (getSystemUiVisibility() == 0 && A()) {
            if (getParent() != null) {
                View view = (View) getParent();
                if (view.getParent() instanceof View) {
                    QLog.i("XPanelContainer", 1, "[checkIsMultiScreen]: getTop by fitSystemWindowUtil");
                    this.R = ((IFitSystemWindowsUtil) QRoute.api(IFitSystemWindowsUtil.class)).getTopInset((View) view.getParent());
                } else if (view.getParent() != null) {
                    QLog.i("XPanelContainer", 1, "[checkIsMultiScreen]: getTop by locationInWindow");
                    int[] iArr = new int[2];
                    view.getLocationInWindow(iArr);
                    this.R = iArr[1];
                }
            }
            if (this.R < this.N - 5) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (f384718l0 != z16) {
                this.P = true;
                f384718l0 = z16;
            }
            QLog.d("XPanelContainer", 1, "tmpIsMultiScreen= " + z16 + ", mTopInset " + this.R + ", default top " + this.N + ",mIsNeedHandleMultiScreenSdkBelow24 " + this.f384720a0 + ",mIsMultiChange" + this.P);
        }
    }

    private boolean j(boolean z16, int i3, int i16, int i17, int i18, boolean z17, View view) {
        if (this.f384726f != 1 || f384711e0 <= 0) {
            return false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("XPanelContainer", 4, "defaultAnimLayout changed is " + z16 + " bottom is " + i18 + " inputHeight is " + f384711e0 + " externalPanelHeight is " + f384714h0);
        }
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i17 - i3, 1073741824), View.MeasureSpec.makeMeasureSpec(((i18 - i16) + f384711e0) - f384714h0, 1073741824));
            view.layout(i3, i16, i17, (f384711e0 + i18) - f384714h0);
        }
        View view2 = this.E;
        if (view2 != null) {
            if (view2 instanceof BaseVoicetoTextView) {
                ((BaseVoicetoTextView) view2).d(i3, i16, i17, i18, z17);
            } else {
                view2.measure(View.MeasureSpec.makeMeasureSpec(i17 - i3, 1073741824), View.MeasureSpec.makeMeasureSpec(f384714h0, 1073741824));
                View view3 = this.E;
                int i19 = f384711e0;
                view3.layout(i3, (i18 + i19) - f384714h0, i17, i19 + i18);
            }
        }
        return true;
    }

    private boolean l(int i3, int i16, int i17, int i18) {
        if (this.Q) {
            this.Q = false;
        }
        if (!this.P) {
            return false;
        }
        this.P = false;
        if (this.E != null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.aio.XPanelContainer", 2, "  multi screen change to normal ");
            }
            this.E.setVisibility(8);
            this.E = null;
        }
        ((InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(getWindowToken(), 0);
        i();
        M(0);
        this.S = 0;
        this.f384727h = -1;
        int o16 = (int) (o() * getContext().getResources().getDisplayMetrics().density);
        f384715i0 = o16;
        f384714h0 = o16;
        f384717k0 = 0;
        try {
            int paddingRight = (i17 - i3) - getPaddingRight();
            int paddingLeft = getPaddingLeft();
            int paddingBottom = (i18 - i16) - getPaddingBottom();
            int paddingTop = getPaddingTop();
            View childAt = getChildAt(0);
            if (childAt != null) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(paddingRight - paddingLeft, 1073741824), View.MeasureSpec.makeMeasureSpec(paddingBottom - paddingTop, 1073741824));
                childAt.layout(paddingLeft, paddingTop, paddingRight, paddingBottom);
                return true;
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.aio.XPanelContainer", 2, "  error = " + e16);
                return true;
            }
            return true;
        }
    }

    public static int o() {
        return 196;
    }

    private static int p() {
        int i3 = f384711e0;
        if (i3 <= 0) {
            return (int) (BaseApplication.getContext().getApplicationContext().getResources().getDisplayMetrics().heightPixels / 3.0f);
        }
        return i3;
    }

    public static int q() {
        return f384711e0;
    }

    private int r() {
        KeyEvent.Callback callback = this.E;
        if (callback != null && (callback instanceof j)) {
            return ((j) callback).a();
        }
        return f384715i0;
    }

    private void w() {
        if (f384711e0 == 0) {
            f384711e0 = ((Integer) p.b(getContext(), "", "sp_key_input_height", 0)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.i("XPanelContainer", 2, "initInputMethodPanelHeight.height = " + f384711e0);
        }
    }

    private boolean x(boolean z16, int i3, int i16) {
        float f16;
        float f17;
        boolean z17;
        boolean z18;
        Configuration configuration = getResources().getConfiguration();
        int i17 = this.f384728i;
        if ((i17 < 0 || this.H != configuration.orientation) && z16 && i3 > 0) {
            this.H = configuration.orientation;
            if (VersionUtils.isHoneycombMR2()) {
                this.I = configuration.screenWidthDp;
                this.J = configuration.screenHeightDp;
            }
            this.f384728i = i3;
        } else if (i3 > i17) {
            this.f384728i = i3;
        }
        if (getResources().getConfiguration().orientation == 2) {
            f16 = this.f384728i;
            f17 = 0.3f;
        } else {
            f16 = this.f384728i;
            f17 = 0.2f;
        }
        int i18 = (int) (f16 * f17);
        int i19 = this.f384728i;
        if (i19 > i3 && i19 - i3 > i18) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 != this.U) {
            z18 = true;
        } else {
            z18 = false;
        }
        this.V = z18;
        this.U = z17;
        if (QLog.isColorLevel()) {
            QLog.d("Q.aio.XPanelContainer", 2, " setStatus onLayout before finalStatus = ", Integer.valueOf(i16), " softInputShowing = ", Boolean.valueOf(z17), " mStatus = ", Integer.valueOf(this.f384726f), " changed = ", Boolean.valueOf(z16), " mPendingStatus = ", Integer.valueOf(this.f384727h), " mIsMultiScreen = ", Boolean.valueOf(f384718l0), " mTopInset = ", Integer.valueOf(this.R), " mClickStatus = ", Integer.valueOf(this.S), "mNormalSize = ", Integer.valueOf(this.f384728i), " height = ", Integer.valueOf(i3), " dHeight = " + i18 + " mSoftInputChange=" + this.V);
        }
        return z17;
    }

    private boolean y() {
        return false;
    }

    private boolean z() {
        if (!B() || this.f384726f <= 1) {
            return true;
        }
        return false;
    }

    protected boolean D(boolean z16, int i3, int i16, int i17, int i18, boolean z17, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z17), view)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("XPanelContainer", 2, String.format("normalScreenLayout changed= %b inputShow=%b [%d, %d, %d, %d] status=[%d -> %d]", Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(this.f384726f), Integer.valueOf(this.f384727h)));
        }
        if (!z17 && this.f384726f != 1 && this.f384725e == 0) {
            this.f384725e = i18;
            QLog.i("XPanelContainer", 1, "init mDefaultBottom: " + i18);
        }
        if (z17 && this.f384726f != 1) {
            if (!y() || !V(i18)) {
                U(i3, i16, i17, i18, z17, view);
            }
        } else {
            int i19 = this.f384727h;
            if (i19 > 1 && (!z17 || z16)) {
                T(z16, i3, i16, i17, i18, z17, view);
                return true;
            }
            if (i19 == 0 && this.f384726f > 1) {
                S(i3, i16, i17, i18, z17, view);
                return true;
            }
            if (this.f384726f > 1 && !z17) {
                if (G(i3, i16, i17, i18, z17, view)) {
                    return true;
                }
            } else if (!y() || !j(z16, i3, i16, i17, i18, z17, view)) {
                k(z16, i3, i16, i17, i18, z17, view);
            }
        }
        return false;
    }

    public void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("XPanelContainer", 2, "-->finish--reset resetPosition");
        }
        this.f384727h = -1;
        M(0);
        this.F = true;
        this.K = false;
        this.L = false;
        this.f384722c0 = 0;
        requestLayout();
    }

    protected void M(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("XPanelContainer", 2, "setStatus status=" + i3 + " mStatus=" + this.f384726f + " mSoftInputChange=" + this.V + " mSoftInputShowing=" + this.U);
        }
        if (i3 == 0 && y()) {
            throw null;
        }
        int i16 = this.f384726f;
        if (i3 != i16) {
            this.f384726f = i3;
            g gVar = this.D;
            if (gVar != null) {
                gVar.onPanelChanged(i16, i3);
            }
            URLDrawable.resume();
            ApngImage.playByTag(0);
            View view = this.E;
            if (view != null && i3 <= 1) {
                if (!(view instanceof BaseVoicetoTextView) || i3 != 1) {
                    if (this.V && !this.U) {
                        if (view instanceof BaseVoicetoTextView) {
                            this.f384726f = 36;
                        }
                    } else {
                        if (view.getVisibility() == 0) {
                            this.E.setVisibility(8);
                            this.E = null;
                            postDelayed(this, 1L);
                            return;
                        }
                        this.E = null;
                    }
                }
            }
        }
    }

    public void N(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            O(i3, true);
        }
    }

    @TargetApi(11)
    public void O(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.aio.XPanelContainer", 2, " showExternalPanel panelId = " + i3 + " mStatus = " + this.f384726f + " ready = " + this.T);
        }
        if (!this.T) {
            return;
        }
        this.S = i3;
        E(this.f384726f, i3);
        if (R(i3)) {
            return;
        }
        if (i3 == 1) {
            QLog.i("XPanelContainer", 1, " show input panel from showExternalPanel | sInputMethodPanelHeight=" + f384711e0);
            BaseAIOUtils.o(this.f384729m);
            return;
        }
        if (i3 > 1) {
            this.F = false;
            View view = this.G.get(i3);
            if (view != null && this.D.T(i3)) {
                this.G.remove(i3);
                removeView(view);
                view = null;
            }
            if (view == null) {
                try {
                    view = this.D.E2(i3);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("XPanelContainer", 2, e16, new Object[0]);
                    }
                }
                if (view == null) {
                    return;
                }
                addView(view);
                this.G.put(i3, view);
            }
            View view2 = this.E;
            if (view != view2) {
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                view.setVisibility(0);
                this.E = view;
            }
            int i16 = this.f384726f;
            if (i16 == 0) {
                if (y() && i3 == 3) {
                    throw null;
                }
                P(i3, z16);
            } else if (i16 == 1) {
                Q(i3);
            } else if (i16 != i3) {
                M(i3);
            }
            if (this.f384726f != 0 && y()) {
                throw null;
            }
            return;
        }
        throw new IllegalArgumentException("wrong argument..must be SOFT_INPUT,EXTERNAL_EMOTICON,EXTERNAL_INPUT");
    }

    protected void S(int i3, int i16, int i17, int i18, boolean z16, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16), view);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("Q.aio.XPanelContainer", 4, " onLayout reget =  mAnimationPosition = " + this.f384722c0);
        }
        e();
        View view2 = this.E;
        if (view2 == null) {
            QLog.e("XPanelContainer", 1, " onLayout panel error:curPanel==nulll ,restore status NONE ");
            M(0);
            this.f384727h = -1;
            requestLayout();
            return;
        }
        if (view2 instanceof BaseVoicetoTextView) {
            int i19 = this.f384722c0;
            ((BaseVoicetoTextView) view2).d(i3, i18 - i19, i17, (i18 - i19) + f384714h0, z16);
        } else {
            view2.measure(View.MeasureSpec.makeMeasureSpec(i17 - i3, 1073741824), View.MeasureSpec.makeMeasureSpec(f384714h0, 1073741824));
            View view3 = this.E;
            int i26 = this.f384722c0;
            view3.layout(i3, i18 - i26, i17, (i18 - i26) + f384714h0);
        }
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i17 - i3, 1073741824), View.MeasureSpec.makeMeasureSpec((i18 - i16) - this.f384722c0, 1073741824));
            view.layout(i3, i16, i17, i18 - this.f384722c0);
        }
        if (this.f384722c0 == 0) {
            M(this.f384727h);
            this.f384727h = -1;
        } else if (!f384713g0) {
            postDelayed(this, 1L);
        }
    }

    protected void U(int i3, int i16, int i17, int i18, boolean z16, View view) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16), view);
            return;
        }
        if (this.E instanceof BaseVoicetoTextView) {
            if (view != null) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i17 - i3, 1073741824), View.MeasureSpec.makeMeasureSpec((i18 - i16) - f384714h0, 1073741824));
                view.layout(i3, i16, i17, i18 - f384714h0);
            }
            ((BaseVoicetoTextView) this.E).d(i3, i16, i17, i18, z16);
        } else if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i17 - i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i18 - i16, 1073741824));
            view.layout(i3, i16, i17, i18);
        }
        int i19 = this.f384725e - i18;
        if (QLog.isColorLevel()) {
            QLog.d("Q.aio.XPanelContainer", 2, " onLayout inputHeight ", Integer.valueOf(i19), " mExternalPanelheight = ", Integer.valueOf(f384714h0), " mDefaultExternalPanelheight = ", Integer.valueOf(f384715i0), " mAddedHeight = ", Integer.valueOf(f384717k0));
        }
        int o16 = (int) (o() * getContext().getResources().getDisplayMetrics().density);
        f384715i0 = o16;
        boolean z18 = f384712f0;
        if (i19 > o16 && i19 < f384716j0) {
            z17 = true;
        } else {
            z17 = false;
        }
        f384712f0 = z17;
        f384719m0 = y();
        if (f384714h0 != i19) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.aio.XPanelContainer", 2, " mExternalPanelheight=" + f384714h0 + " inputHeight=" + i19 + " mDefaultExternalPanelheight=" + f384715i0 + " mMAXHExternalPanelheight=" + f384716j0 + " mAnimationPosition=" + this.f384722c0 + " mDefaultBottom=" + this.f384725e);
            }
            if (this.f384722c0 == 0) {
                int i26 = f384715i0;
                if (i19 > i26) {
                    int i27 = f384716j0;
                    if (i19 > i27) {
                        if (i27 > i26) {
                            f384714h0 = i27;
                        } else {
                            f384714h0 = i26;
                        }
                    } else {
                        f384714h0 = i19;
                        f384711e0 = i19;
                        if (this.W) {
                            L();
                        }
                    }
                } else {
                    f384714h0 = i26;
                    if (i19 < i26 / 2) {
                        this.f384725e = 0;
                        QLog.i("XPanelContainer", 1, "reset mDefaultBottom");
                    }
                }
                f384717k0 = f384714h0 - f384715i0;
            }
            if (!y() || f384712f0 != z18) {
                i();
            }
            if (QLog.isColorLevel()) {
                QLog.d("XPanelContainer", 2, "mExternalPanelheight=" + f384714h0 + "mAddedHeight=" + f384717k0);
            }
        }
    }

    public void c(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            d(view, true);
        }
    }

    public void d(View view, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, view, Boolean.valueOf(z16));
            return;
        }
        this.f384729m = view;
        if (view.getOnFocusChangeListener() == null) {
            view.setOnFocusChangeListener(new b());
        }
        if (z16 && view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            viewGroup.setDescendantFocusability(131072);
            viewGroup.setFocusableInTouchMode(true);
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.aio.XPanelContainer", 2, " clearAllPanel ");
        }
        if (this.E instanceof BaseVoicetoTextView) {
            return;
        }
        for (int i3 = 0; i3 < this.G.size(); i3++) {
            try {
                SparseArray<View> sparseArray = this.G;
                View view = sparseArray.get(sparseArray.keyAt(i3));
                if (view.getParent() != null) {
                    removeView(view);
                }
            } catch (Exception unused) {
            }
        }
        this.G.clear();
        this.E = null;
        EmoticonPanelViewBinder.destroyViewPool();
    }

    protected void k(boolean z16, int i3, int i16, int i17, int i18, boolean z17, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z17), view);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("Q.aio.XPanelContainer", 4, " onLayout use default layout = ");
        }
        if (this.E instanceof BaseVoicetoTextView) {
            if (view != null) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i17 - i3, 1073741824), View.MeasureSpec.makeMeasureSpec((i18 - i16) - f384714h0, 1073741824));
                view.layout(i3, i16, i17, i18 - f384714h0);
            }
            ((BaseVoicetoTextView) this.E).d(i3, i16, i17, i18, z17);
            return;
        }
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i17 - i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i18 - i16, 1073741824));
            view.layout(i3, i16, i17, i18);
        }
    }

    public int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return this.f384726f;
    }

    public View n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (View) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return this.E;
    }

    @Override // android.view.View
    @TargetApi(13)
    protected void onConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        if (VersionUtils.isHoneycombMR2()) {
            if (configuration.orientation != this.H || b71.a.a(getContext())) {
                if (this.I != configuration.screenWidthDp || this.J != configuration.screenHeightDp) {
                    this.H = -1;
                    this.J = -1;
                    this.f384728i = -1;
                    K();
                    s();
                    return;
                }
                return;
            }
            return;
        }
        if (configuration.orientation != this.H) {
            this.H = -1;
            this.f384728i = -1;
            K();
            s();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0113, code lost:
    
        if (((com.tencent.mobileqq.activity.aio.voicetextpanel.view.BaseVoicetoTextView) r1).f() == false) goto L46;
     */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    @TargetApi(13)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        View view;
        String str;
        int i19;
        int i26;
        int i27;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.aio.XPanelContainer", 2, String.format("onLayout changed :%b [%d, %d, %d, %d]", Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18)));
        }
        g();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int paddingBottom = getPaddingBottom();
        int paddingTop = getPaddingTop();
        h();
        if (l(i3, i16, i17, i18)) {
            return;
        }
        int i28 = i18 - i16;
        int i29 = this.f384726f;
        boolean x16 = x(z16, i28, i29);
        int i36 = (i17 - i3) - paddingRight;
        int i37 = i28 - paddingBottom;
        View childAt = getChildAt(0);
        Context context = null;
        if (childAt instanceof BaseVoicetoTextView) {
            view = null;
        } else {
            view = childAt;
        }
        try {
            if (C(paddingLeft, paddingTop, i36, i37, view)) {
                return;
            }
            i19 = 0;
            try {
                if (D(z16, paddingLeft, paddingTop, i36, i37, x16, view)) {
                    return;
                }
                if (z16 && x16) {
                    this.f384727h = -1;
                    i27 = 1;
                } else if (this.f384727h != 0 && (!z() || !z16 || x16)) {
                    i27 = i29;
                } else {
                    if (z16) {
                        if (i29 != 28 && i29 != 35) {
                            View view2 = this.E;
                            if (view2 instanceof BaseVoicetoTextView) {
                            }
                        }
                        i26 = i29;
                        this.f384727h = -1;
                        i27 = i26;
                    }
                    i26 = 0;
                    this.f384727h = -1;
                    i27 = i26;
                }
                M(i27);
                this.S = i27;
                if (QLog.isColorLevel()) {
                    QLog.d("Q.aio.XPanelContainer", 2, " onLayout after finalStatus = ", Integer.valueOf(i27), " softInputShowing = ", Boolean.valueOf(x16), " mStatus = ", Integer.valueOf(this.f384726f), " changed = ", Boolean.valueOf(z16), " mPendingStatus = ", Integer.valueOf(this.f384727h));
                }
                View view3 = this.E;
                if (view3 instanceof BaseVoicetoTextView) {
                    ((BaseVoicetoTextView) view3).e();
                }
            } catch (Exception e16) {
                e = e16;
                str = "Q.aio.XPanelContainer";
                StringBuilder sb5 = new StringBuilder();
                sb5.append("main.getContext: ");
                if (view != null) {
                    context = view.getContext();
                }
                sb5.append(context);
                sb5.append(" \n ");
                sb5.append(e.toString());
                sb5.append(" crash happen restore init status");
                QLog.e(str, 1, sb5.toString(), e);
                View view4 = this.E;
                if (view4 != null) {
                    view4.setVisibility(8);
                }
                M(i19);
                this.f384727h = -1;
                requestLayout();
            }
        } catch (Exception e17) {
            e = e17;
            str = "Q.aio.XPanelContainer";
            i19 = 0;
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            setMeasuredDimension(View.getDefaultSize(getSuggestedMinimumWidth(), i3), View.getDefaultSize(getSuggestedMinimumHeight(), i16));
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        } else {
            requestLayout();
        }
    }

    @TargetApi(11)
    public boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return t(true);
    }

    public void setAnimationManager(l61.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) bVar);
        } else {
            f384719m0 = y();
        }
    }

    public void setIsInMultiScreen(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, z16);
        } else if (f384718l0 != z16) {
            this.P = true;
            f384718l0 = z16;
        }
    }

    public void setIsNeedHandleMultiScreenSdkBelow24(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
        } else {
            this.f384720a0 = z16;
        }
    }

    public void setOnChangeMultiScreenListener(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) eVar);
        }
    }

    public void setOnGoingToShowPanelListener(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) fVar);
        } else {
            this.f384721b0.add(new WeakReference<>(fVar));
        }
    }

    public void setOnPanelChangeListener(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) gVar);
        } else {
            this.D = gVar;
        }
    }

    public void setReadyToShow(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("XPanelContainer", 2, "setReadyToShow() called with: readyToShow = [" + z16 + "]");
        }
        if (this.T != z16) {
            this.T = z16;
            F(z16);
        }
    }

    public void setReadyToShowChangeListener(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) hVar);
        }
    }

    public void setSaveSoftInputHeight(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, z16);
        } else {
            this.W = z16;
        }
    }

    @TargetApi(11)
    public boolean t(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, z16)).booleanValue();
        }
        return u(z16, false);
    }

    @TargetApi(11)
    public boolean u(boolean z16, boolean z17) {
        boolean z18;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), Boolean.valueOf(z17))).booleanValue();
        }
        g gVar = this.D;
        if (gVar != null) {
            gVar.E();
        }
        int i16 = this.f384726f;
        if (i16 > 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (f384718l0) {
            if (i16 == 1) {
                f(z17);
            }
            this.S = 0;
            requestLayout();
            return z18;
        }
        if (i16 == 1) {
            try {
                f(z17);
            } catch (Exception e16) {
                QLog.e("XPanelContainer", 1, e16, new Object[0]);
            }
        } else if (i16 > 1) {
            if (this.f384722c0 > 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.aio.XPanelContainer", 2, "  hideAllPanel return  mAnimationPosition = " + this.f384722c0);
                }
                return true;
            }
            this.S = 0;
            this.f384727h = 0;
            if (z16) {
                i3 = f384714h0;
            } else {
                i3 = 0;
            }
            this.f384722c0 = i3;
            this.f384724d0 = AnimationUtils.currentAnimationTimeMillis();
            if (f384713g0 && z16) {
                this.L = true;
                int height = getHeight();
                ValueAnimator ofInt = ValueAnimator.ofInt(height - f384714h0, height);
                ofInt.setDuration(150L);
                ofInt.addUpdateListener(new d(height));
                ofInt.start();
            } else {
                requestLayout();
            }
        }
        return z18;
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            ((InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    private void F(boolean z16) {
    }

    public XPanelContainer(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
    }
}
