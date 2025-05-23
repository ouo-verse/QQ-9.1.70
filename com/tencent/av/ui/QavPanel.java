package com.tencent.av.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieDrawable;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.NormalMenuView;
import com.tencent.av.ui.beauty.QavBeautyMenuPanel;
import com.tencent.av.ui.effect.menuview.QavEffectBaseMenuView;
import com.tencent.av.ui.effect.menuview.QavEffectMenuView;
import com.tencent.av.ui.m;
import com.tencent.av.ui.operation.QavOperationBaseMenuView;
import com.tencent.av.ui.operation.QavOperationV2MenuView;
import com.tencent.av.ui.virtual.QavVirtualMenuView;
import com.tencent.av.utils.QQFrameByFrameAnimation;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.av.utils.aw;
import com.tencent.av.utils.ba;
import com.tencent.av.widget.shimmer.ShimmerTextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.BaseFragmentActivity;

/* loaded from: classes3.dex */
public class QavPanel extends RelativeLayout {

    /* renamed from: j1, reason: collision with root package name */
    private static final int[] f75042j1 = {m.l.A, m.l.B, m.l.C, m.l.E, m.l.G, m.l.Q, m.l.S};
    TextView A0;
    View B0;
    Button C;
    ImageView C0;
    Button D;
    View D0;
    Button E;
    View E0;
    Button F;
    View F0;
    ImageView G;
    ImageView G0;
    ImageView H;
    View.OnTouchListener H0;
    ShimmerTextView I;
    View.OnClickListener I0;
    ImageView J;
    private boolean J0;
    View K;
    VideoAppInterface K0;
    public v L;
    NormalMenuView[] L0;
    ImageButton M;
    public int M0;
    Button N;
    rw.c N0;
    private boolean O0;
    Button P;
    private com.tencent.av.utils.ao P0;
    Button Q;
    private View Q0;
    Button R;
    private ImageView R0;
    RedTouch S;
    private ImageView S0;
    RedTouch T;
    private TextView T0;
    View U;
    private ImageView U0;
    View V;
    private ValueAnimator V0;
    View W;
    private boolean W0;
    private LottieDrawable X0;
    private ImageView Y0;
    private ImageView Z0;

    /* renamed from: a0, reason: collision with root package name */
    ImageButton f75043a0;

    /* renamed from: a1, reason: collision with root package name */
    public final int f75044a1;

    /* renamed from: b0, reason: collision with root package name */
    ImageButton f75045b0;

    /* renamed from: b1, reason: collision with root package name */
    public final int f75046b1;

    /* renamed from: c0, reason: collision with root package name */
    ImageButton f75047c0;

    /* renamed from: c1, reason: collision with root package name */
    public final int f75048c1;

    /* renamed from: d, reason: collision with root package name */
    final String f75049d;

    /* renamed from: d0, reason: collision with root package name */
    ImageButton f75050d0;

    /* renamed from: d1, reason: collision with root package name */
    public final int f75051d1;

    /* renamed from: e, reason: collision with root package name */
    int f75052e;

    /* renamed from: e0, reason: collision with root package name */
    FrameLayout f75053e0;

    /* renamed from: e1, reason: collision with root package name */
    public final int f75054e1;

    /* renamed from: f, reason: collision with root package name */
    View f75055f;

    /* renamed from: f0, reason: collision with root package name */
    Button f75056f0;

    /* renamed from: f1, reason: collision with root package name */
    public final int f75057f1;

    /* renamed from: g0, reason: collision with root package name */
    TextView f75058g0;

    /* renamed from: g1, reason: collision with root package name */
    private int f75059g1;

    /* renamed from: h, reason: collision with root package name */
    View f75060h;

    /* renamed from: h0, reason: collision with root package name */
    TextView f75061h0;

    /* renamed from: h1, reason: collision with root package name */
    private l f75062h1;

    /* renamed from: i, reason: collision with root package name */
    boolean f75063i;

    /* renamed from: i0, reason: collision with root package name */
    TextView f75064i0;

    /* renamed from: i1, reason: collision with root package name */
    private o f75065i1;

    /* renamed from: j0, reason: collision with root package name */
    ImageView f75066j0;

    /* renamed from: k0, reason: collision with root package name */
    Button f75067k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f75068l0;

    /* renamed from: m, reason: collision with root package name */
    Button f75069m;

    /* renamed from: m0, reason: collision with root package name */
    private ValueAnimator f75070m0;

    /* renamed from: n0, reason: collision with root package name */
    private volatile boolean f75071n0;

    /* renamed from: o0, reason: collision with root package name */
    ClipDrawable f75072o0;

    /* renamed from: p0, reason: collision with root package name */
    Button f75073p0;

    /* renamed from: q0, reason: collision with root package name */
    RelativeLayout f75074q0;

    /* renamed from: r0, reason: collision with root package name */
    RelativeLayout f75075r0;

    /* renamed from: s0, reason: collision with root package name */
    Button f75076s0;

    /* renamed from: t0, reason: collision with root package name */
    Button f75077t0;

    /* renamed from: u0, reason: collision with root package name */
    View f75078u0;

    /* renamed from: v0, reason: collision with root package name */
    Button f75079v0;

    /* renamed from: w0, reason: collision with root package name */
    Button f75080w0;

    /* renamed from: x0, reason: collision with root package name */
    ImageButton f75081x0;

    /* renamed from: y0, reason: collision with root package name */
    TextView f75082y0;

    /* renamed from: z0, reason: collision with root package name */
    ImageButton f75083z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f75088a;

        a(Runnable runnable) {
            this.f75088a = runnable;
        }

        @Override // com.tencent.av.ui.QavPanel.m
        public void a() {
            this.f75088a.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements u {
        b() {
        }

        @Override // com.tencent.av.ui.u
        public void a(View view, View view2) {
            View.OnClickListener onClickListener = QavPanel.this.I0;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
        }

        @Override // com.tencent.av.ui.u
        public void b(View view, int i3) {
            RelativeLayout N = QavPanel.this.N(i3);
            if (N instanceof QavBeautyMenuPanel) {
                ((QavBeautyMenuPanel) N).h();
            }
            QavPanel.this.X0(com.tencent.av.utils.e.d(), i3, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements LottieHelper.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f75091a;

        c(View view) {
            this.f75091a = view;
        }

        @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
        public void onLoad(LottieDrawable lottieDrawable) {
            if (lottieDrawable == null) {
                return;
            }
            if (QavPanel.this.X0 != null && QavPanel.this.X0.isRunning()) {
                QavPanel.this.X0.stop();
                QavPanel.this.X0.removeAllAnimatorListeners();
            }
            QavPanel.this.X0 = lottieDrawable;
            if (QavPanel.this.Y0 != null) {
                this.f75091a.setBackground(QavPanel.this.X0);
            }
            QavPanel.this.X0.start();
            QLog.e(QavPanel.this.f75049d, 1, "loadSpeakingLottie success.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            n nVar;
            EventCollector.getInstance().onViewClickedBefore(view);
            v vVar = QavPanel.this.L;
            if (vVar != null && (nVar = vVar.f76630d) != null) {
                nVar.a(true);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements View.OnTouchListener {
        e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    QavPanel.this.f75072o0.setAlpha(255);
                    return false;
                }
                return false;
            }
            QavPanel.this.f75072o0.setAlpha(127);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f implements View.OnTouchListener {
        f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (QavPanel.this.f75067k0.isEnabled()) {
                QavPanel qavPanel = QavPanel.this;
                if (qavPanel.K0 != null) {
                    return qavPanel.Q(view, motionEvent);
                }
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class g implements View.OnTouchListener {
        g() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (QavPanel.this.f75079v0.isEnabled()) {
                QavPanel qavPanel = QavPanel.this;
                if (qavPanel.K0 != null) {
                    return qavPanel.Q(view, motionEvent);
                }
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    class h implements ValueAnimator.AnimatorUpdateListener {
        h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (QavPanel.this.f75071n0) {
                ClipDrawable clipDrawable = QavPanel.this.f75072o0;
                if (clipDrawable != null) {
                    clipDrawable.setLevel(intValue);
                }
                QavPanel qavPanel = QavPanel.this;
                qavPanel.s(qavPanel.Y0, intValue);
                if (QavPanel.this.X0 == null) {
                    QavPanel qavPanel2 = QavPanel.this;
                    qavPanel2.A0(qavPanel2.Y0);
                }
                if (QavPanel.this.J0) {
                    QavPanel.this.O0(intValue);
                    QavPanel.this.P0.d(intValue);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class i extends com.tencent.mobileqq.widget.f {
        i() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (QavPanel.this.t0()) {
                SessionInfo f16 = com.tencent.av.n.e().f();
                f16.d0("tryPlayBtnMuteAnimation onAnimationEnd", true);
                f16.q0("tryPlayBtnMuteAnimation onAnimationEnd", 1);
                QavPanel.this.H("tryPlayBtnMuteAnimation onAnimationEnd", 2, 1, false);
                return;
            }
            com.tencent.av.r.h0().T2("tryPlayBtnMuteAnimation onAnimationEnd", 1);
            QavPanel.this.H("tryPlayBtnMuteAnimation onAnimationEnd", 2, 1, false);
            QavPanel.this.f75065i1.a(false, false);
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QavPanel.this.P0.h(false);
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z16) {
            onAnimationStart(animator);
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z16) {
            onAnimationEnd(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class j implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int[] f75099d;

        j(int[] iArr) {
            this.f75099d = iArr;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int i3;
            int i16;
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (intValue >= 0 && intValue <= (i16 = this.f75099d[0])) {
                QavPanel.this.P0.setAlpha((int) (((intValue * 255) * 1.0f) / i16));
                QavPanel.this.P0.h(true);
                return;
            }
            int[] iArr = this.f75099d;
            if (intValue > iArr[0] && intValue <= iArr[1]) {
                QavPanel.this.P0.h(true);
                QavPanel.this.P0.setAlpha(255);
                return;
            }
            if (intValue > iArr[1] && intValue <= (i3 = iArr[2])) {
                QavPanel.this.P0.setAlpha((int) ((((i3 - intValue) * 255) * 1.0f) / (i3 - r1)));
                QavPanel.this.P0.h(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class k implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f75101d;

        k(View view) {
            this.f75101d = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    this.f75101d.setAlpha(1.0f);
                    return false;
                }
                return false;
            }
            this.f75101d.setAlpha(0.5f);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class l extends Handler {
        public l(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Button button;
            Button button2;
            switch (message.what) {
                case 256:
                    QavPanel.this.f1();
                    return;
                case 257:
                    QavPanel.this.g1();
                    return;
                case 258:
                    if (!ba.getPressSpeakerGuiderFlag(false)) {
                        QavPanel qavPanel = QavPanel.this;
                        Button button3 = qavPanel.f75067k0;
                        if (button3 != null || qavPanel.f75079v0 != null) {
                            if (button3 == null || button3.isShown() || (button = QavPanel.this.f75079v0) == null || button.isShown()) {
                                QavPanel qavPanel2 = QavPanel.this;
                                qavPanel2.a1(qavPanel2.getResources().getString(R.string.f1377007k));
                                ba.clearPressSpeakerGuiderFlag(false);
                                QavPanel.this.f75065i1.b();
                                if (QavPanel.this.f75062h1 != null) {
                                    QavPanel.this.f75062h1.sendEmptyMessageDelayed(260, 5000L);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 259:
                    if (!ba.getPressSpeakerGuiderFlag(true)) {
                        QavPanel qavPanel3 = QavPanel.this;
                        Button button4 = qavPanel3.f75067k0;
                        if (button4 != null || qavPanel3.f75079v0 != null) {
                            if ((button4 == null || button4.isShown() || (button2 = QavPanel.this.f75079v0) == null || button2.isShown()) && QavPanel.this.f75065i1.e()) {
                                QavPanel qavPanel4 = QavPanel.this;
                                qavPanel4.a1(qavPanel4.getResources().getString(R.string.f1377107l));
                                QavPanel.this.f75065i1.b();
                                if (QavPanel.this.f75062h1 != null) {
                                    QavPanel.this.f75062h1.sendEmptyMessageDelayed(260, 5000L);
                                }
                                ba.clearPressSpeakerGuiderFlag(true);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 260:
                    QavPanel.this.R("MSG_TRY_CLEAN_TIPS", 1);
                    return;
                case 261:
                    if (QavPanel.this.f75065i1 != null) {
                        QavPanel.this.f75065i1.b();
                        if (QavPanel.this.f75062h1 != null) {
                            QavPanel.this.f75062h1.sendEmptyMessageDelayed(261, 4000L);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface m {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface n {
        void a(boolean z16);
    }

    /* loaded from: classes3.dex */
    public interface o {
        void a(boolean z16, boolean z17);

        void b();

        long c();

        boolean d();

        boolean e();
    }

    public QavPanel(Context context) {
        super(context);
        this.f75052e = 0;
        this.f75055f = null;
        this.f75060h = null;
        this.f75063i = false;
        this.f75069m = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.f75043a0 = null;
        this.f75045b0 = null;
        this.f75047c0 = null;
        this.f75050d0 = null;
        this.f75053e0 = null;
        this.f75056f0 = null;
        this.f75058g0 = null;
        this.f75061h0 = null;
        this.f75064i0 = null;
        this.f75066j0 = null;
        this.f75067k0 = null;
        this.f75068l0 = 0;
        this.f75071n0 = false;
        this.f75072o0 = null;
        this.f75073p0 = null;
        this.f75074q0 = null;
        this.f75075r0 = null;
        this.f75076s0 = null;
        this.f75077t0 = null;
        this.f75078u0 = null;
        this.f75079v0 = null;
        this.f75080w0 = null;
        this.f75081x0 = null;
        this.f75082y0 = null;
        this.f75083z0 = null;
        this.A0 = null;
        this.B0 = null;
        this.C0 = null;
        this.D0 = null;
        this.E0 = null;
        this.F0 = null;
        this.G0 = null;
        this.H0 = null;
        this.I0 = null;
        this.J0 = false;
        this.L0 = new NormalMenuView[7];
        this.M0 = -1;
        this.N0 = null;
        this.O0 = false;
        this.W0 = false;
        this.f75044a1 = 256;
        this.f75046b1 = 257;
        this.f75048c1 = 258;
        this.f75051d1 = 259;
        this.f75054e1 = 260;
        this.f75057f1 = 261;
        this.f75059g1 = 1;
        this.f75062h1 = new l(Looper.getMainLooper());
        this.f75049d = "QavPanel_" + com.tencent.av.utils.e.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(View view) {
        VideoAppInterface videoAppInterface = this.K0;
        if (videoAppInterface == null) {
            return;
        }
        LottieHelper.b(videoAppInterface.getApplicationContext(), "qav_mic_voice_lottie/data.json", "qav_mic_voice_lottie/images/", (this.f75067k0.getWidth() * 2) / 15, (this.f75067k0.getHeight() * 7) / 30, -1, new c(view));
    }

    private AlphaAnimation B() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setFillEnabled(true);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(400L);
        return alphaAnimation;
    }

    private void C0(boolean z16) {
        Button button;
        Button button2;
        int i3;
        int i16;
        if (z16) {
            button = this.R;
        } else {
            button = this.Q;
        }
        if (z16) {
            button2 = this.Q;
        } else {
            button2 = this.R;
        }
        if (button != null) {
            if (com.tencent.av.utils.af.x()) {
                setBtnTopDrawable(button, R.drawable.n6j);
                button.setContentDescription(getResources().getString(R.string.f1781635x));
            } else {
                if (z16) {
                    i3 = R.drawable.n7p;
                } else {
                    i3 = R.drawable.n7r;
                }
                if (z16) {
                    i16 = R.string.d8h;
                } else {
                    i16 = R.string.dlf;
                }
                Drawable drawable = button.getResources().getDrawable(i3);
                drawable.setBounds(0, 0, ScreenUtil.dip2px(64.0f), ScreenUtil.dip2px(64.0f));
                button.setCompoundDrawables(null, drawable, null, null);
                setBtnTouchEffect(button);
                button.setContentDescription(getResources().getString(i16));
            }
        }
        if (button2 != null) {
            button2.setCompoundDrawables(null, null, null, null);
            button2.setContentDescription(null);
            button2.setOnTouchListener(null);
        }
    }

    private void G0(View view) {
        if (view != null) {
            view.setBackground(null);
            view.setOnTouchListener(null);
            if (view instanceof ImageButton) {
                ((ImageButton) view).setImageDrawable(null);
            } else if (view instanceof Button) {
                ((Button) view).setCompoundDrawables(null, null, null, null);
            }
        }
    }

    private NormalMenuView J() {
        int i3 = this.M0;
        if (i3 != -1) {
            return this.L0[i3];
        }
        return null;
    }

    private void L0(int i3) {
        boolean z16;
        View h16 = h1(i3);
        if (QLog.isDevelopLevel()) {
            String str = this.f75049d;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("resetViewDrawable, id");
            sb5.append(com.tencent.av.ui.m.a(i3));
            sb5.append("], view[");
            if (h16 != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d(str, 2, sb5.toString());
        }
        if (h16 != null && !h16.isShown()) {
            if (i3 == m.l.A) {
                s0((ImageButton) h16, R.drawable.f161320da1);
                return;
            }
            if (i3 == m.l.B) {
                s0(this.f75043a0, R.drawable.dae);
                return;
            }
            if (i3 == m.l.C) {
                s0(this.f75050d0, R.drawable.n7q);
                return;
            }
            if (i3 == m.l.E) {
                s0(this.f75045b0, R.drawable.n7c);
                return;
            }
            int i16 = m.l.G;
            if (i3 == i16) {
                setImgBtnDrawable(i16, R.drawable.n6n);
                return;
            }
            int i17 = m.l.Q;
            if (i3 == i17) {
                setImgBtnDrawable(i17, R.drawable.n79);
                R0(i17, ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).getAudioShareBgResId());
                return;
            }
            int i18 = m.l.S;
            if (i3 == i18) {
                setImgBtnDrawable(i18, R.drawable.n7a);
                R0(i18, ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).getScreenShareBgResId());
                Q0(i18, getResources().getString(R.string.f1784136l));
                U0(m.l.T, R.string.f1784136l);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(int i3) {
        if (this.U0 == null) {
            ImageView imageView = (ImageView) this.f75055f.findViewById(R.id.f30180nn);
            this.U0 = imageView;
            if (imageView == null) {
                return;
            }
            LottieDrawable lottieDrawable = this.X0;
            if (lottieDrawable != null) {
                imageView.setImageDrawable(lottieDrawable);
                if (!this.X0.isRunning()) {
                    this.X0.start();
                }
            } else {
                A0(imageView);
            }
        }
        s(this.U0, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Q(View view, MotionEvent motionEvent) {
        long j3;
        int L = L();
        SessionInfo f16 = com.tencent.av.n.e().f();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                this.P0.setAlpha(255);
                this.f75062h1.removeMessages(256);
                this.f75062h1.removeMessages(261);
                if (L == 3) {
                    this.O0 = true;
                    if (t0()) {
                        f16.d0("MotionEventACTION_UP", true);
                        f16.q0("MotionEventACTION_UP", 1);
                        H("MotionEventUP", 3, 1, true);
                    } else {
                        com.tencent.av.r.h0().z("MotionEventACTION_UP", this.f75065i1.c(), false, true, 1);
                        H("MotionEventACTION_UP", 3, 1, false);
                        this.f75065i1.a(false, true);
                    }
                }
                this.f75065i1.b();
            }
        } else {
            if (L == 0 || L == 1 || L == 2) {
                if (L == 2) {
                    if (t0()) {
                        f16.d0("MotionEventDown", true);
                        f16.q0("MotionEventDown", 1);
                        H("MotionEventDown", 2, 1, true);
                    } else {
                        if (com.tencent.av.r.h0().X0()) {
                            com.tencent.av.r.h0().T2("MotionEventDown", 1);
                        } else {
                            com.tencent.av.r h06 = com.tencent.av.r.h0();
                            o oVar = this.f75065i1;
                            if (oVar != null) {
                                j3 = oVar.c();
                            } else {
                                j3 = 0;
                            }
                            h06.z("MotionEventDown", j3, false, true, 1);
                        }
                        H("MotionEventDown", 2, 1, false);
                        o oVar2 = this.f75065i1;
                        if (oVar2 != null) {
                            oVar2.a(false, false);
                        }
                    }
                }
                this.P0.setAlpha(127);
            }
            if (z0()) {
                this.O0 = false;
                this.f75062h1.removeMessages(256);
                this.f75062h1.sendEmptyMessageDelayed(256, 200L);
                this.f75062h1.removeMessages(261);
            }
            o oVar3 = this.f75065i1;
            if (oVar3 != null) {
                oVar3.b();
            }
        }
        return false;
    }

    private static boolean S(int i3) {
        if (i3 != R.drawable.k9g && i3 != R.drawable.k9i && i3 != R.drawable.k9j) {
            return false;
        }
        return true;
    }

    private void U() {
        if (getContext() instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) getContext();
            if (baseFragmentActivity.getAppRuntime() instanceof VideoAppInterface) {
                this.K0 = (VideoAppInterface) baseFragmentActivity.getAppRuntime();
            }
        }
    }

    private void V() {
        Button button = (Button) this.f75055f.findViewById(m.l.f76065k);
        this.C = button;
        if (button != null) {
            com.tencent.av.utils.e.a(getResources(), this.C, R.drawable.d_5, R.color.f157463q4, R.color.f157463q4);
        }
    }

    private void X() {
        Button button = (Button) this.f75055f.findViewById(m.l.f76068n);
        this.F = button;
        if (button != null) {
            com.tencent.av.utils.e.a(getResources(), this.F, R.drawable.d_k, R.color.f157463q4, R.color.f157463q4);
        }
    }

    private void Z(int i3) {
        e0(i3);
        setBtnTopDrawable(this.f75073p0, R.drawable.k9i);
        ImageView imageView = this.Z0;
        if (imageView != null) {
            Resources resources = imageView.getResources();
            Drawable drawable = resources.getDrawable(R.drawable.d_p);
            aw a16 = aw.a(resources, R.drawable.d_p, R.color.c_e);
            a16.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            this.Z0.setBackground(a16);
        }
    }

    private void d1() {
        ValueAnimator valueAnimator = this.V0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.V0.cancel();
        }
    }

    private void e0(int i3) {
        boolean z16;
        if (this.f75067k0 == null) {
            return;
        }
        boolean z17 = true;
        if (i3 == m.a.f75993d) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!com.tencent.av.utils.af.w()) {
            z16 = false;
        }
        this.J0 = z16;
        if (!z16) {
            this.f75072o0 = (ClipDrawable) this.f75067k0.getResources().getDrawable(R.drawable.k9h);
            if (this.f75079v0 != null && this.K0 != null && com.tencent.av.r.h0() != null) {
                int i16 = com.tencent.av.n.e().f().f73046k2;
                if (i16 != 2 && i16 != 1) {
                    z17 = false;
                }
                if (z17) {
                    setBtnTopDrawableWithForeGround(this.f75079v0, R.drawable.k9g, this.f75072o0);
                }
            }
            if (this.Y0 == null) {
                setBtnTopDrawableWithForeGround(this.f75067k0, R.drawable.k9g, this.f75072o0);
                this.f75067k0.setOnTouchListener(new e());
                return;
            } else {
                setBtnTopDrawable(this.f75067k0, R.drawable.k9g);
                return;
            }
        }
        f0();
    }

    private void f0() {
        aw.a(getResources(), R.drawable.d_p, R.color.c_e).setBounds(0, 0, BaseAIOUtils.f(64.0f, getResources()), BaseAIOUtils.f(64.0f, getResources()));
        com.tencent.av.utils.ao aoVar = new com.tencent.av.utils.ao(BaseAIOUtils.f(64.0f, getResources()), BaseAIOUtils.f(64.0f, getResources()));
        this.P0 = aoVar;
        aoVar.e(0, BitmapFactory.decodeResource(getResources(), R.drawable.n6r));
        this.P0.e(1, BitmapFactory.decodeResource(getResources(), R.drawable.n6u));
        this.P0.e(2, BitmapFactory.decodeResource(getResources(), R.drawable.n6u));
        this.P0.e(2, BitmapFactory.decodeResource(getResources(), R.drawable.n6v));
        this.P0.e(3, BitmapFactory.decodeResource(getResources(), R.drawable.n6r));
        this.P0.g(0);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.P0});
        layerDrawable.setLayerInset(0, 0, 0, 0, 0);
        layerDrawable.setBounds(0, 0, this.P0.getIntrinsicWidth(), this.P0.getIntrinsicHeight());
        if (this.Y0 == null) {
            this.P0.e(0, BitmapFactory.decodeResource(getResources(), R.drawable.n6s));
        } else {
            this.P0.e(0, BitmapFactory.decodeResource(getResources(), R.drawable.n6r));
        }
        this.f75067k0.setCompoundDrawables(null, layerDrawable, null, null);
        this.f75067k0.setOnTouchListener(new f());
        Button button = this.f75079v0;
        if (button != null) {
            button.setCompoundDrawables(null, layerDrawable, null, null);
            this.f75079v0.setOnTouchListener(new g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f1() {
        if (!u()) {
            QLog.d(this.f75049d, 1, "tryPerformLongClick cannot switch muteStatus");
            return;
        }
        if (!this.f75065i1.e()) {
            QLog.d(this.f75049d, 1, "tryPerformLongClick cannot checkBlockMuteStatus");
            return;
        }
        if (L() == 1) {
            SessionInfo f16 = com.tencent.av.n.e().f();
            if (t0()) {
                f16.d0("tryPerformLongClick", false);
                f16.q0("tryPerformLongClick", 3);
                H("tryPerformLongClick", 1, 3, true);
            } else {
                com.tencent.av.r.h0().z("tryPerformLongClick", this.f75065i1.c(), true, true, 3);
                H("tryPerformLongClick", 1, 3, false);
                this.f75065i1.a(true, true);
            }
            ReportController.o(null, "dc00898", "", "", "0X800ADE2", "0X800ADE2", f16.f73035i, 0, "", "", "", "");
            this.f75062h1.sendEmptyMessageDelayed(261, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    public void g1() {
        Button button;
        Button button2 = this.f75067k0;
        if (button2 != null || this.f75079v0 != null) {
            if ((button2 != null && !button2.isShown() && (button = this.f75079v0) != null && !button.isShown()) || this.K0 == null || L() != 1) {
                return;
            }
            if (t0()) {
                SessionInfo f16 = com.tencent.av.n.e().f();
                f16.d0("tryPlayBtnMuteAnimation", true);
                f16.q0("tryPlayBtnMuteAnimation", 2);
                H("tryPlayBtnMuteAnimation start", 1, 2, false);
            } else {
                com.tencent.av.r.h0().T2("tryPlayBtnMuteAnimation onAnimationEnd", 2);
                H("tryPlayBtnMuteAnimation", 1, 2, false);
                this.f75065i1.a(false, false);
            }
            this.f75065i1.b();
            int[] iArr = {250, 2750, 3000};
            if (this.V0 == null) {
                ValueAnimator ofInt = ValueAnimator.ofInt(0, 3000);
                this.V0 = ofInt;
                ofInt.setDuration(3000L);
                this.V0.addListener(new i());
                this.V0.addUpdateListener(new j(iArr));
            }
            if (this.V0.isRunning()) {
                this.V0.cancel();
            }
            this.V0.start();
            this.W0 = true;
        }
    }

    private void i0() {
        this.N = (Button) this.f75055f.findViewById(m.l.f76073s);
        this.P = (Button) this.f75055f.findViewById(m.l.f76074t);
        this.f75074q0 = (RelativeLayout) this.f75055f.findViewById(R.id.g6n);
        this.f75060h = this.f75055f.findViewById(R.id.g7c);
        r0();
        this.f75067k0 = (Button) this.f75055f.findViewById(m.l.f76060f);
        this.f75073p0 = (Button) this.f75055f.findViewById(m.l.f76059e);
        this.f75079v0 = (Button) this.f75055f.findViewById(m.l.O);
        this.f75080w0 = (Button) this.f75055f.findViewById(m.l.P);
        this.f75078u0 = this.f75055f.findViewById(m.l.N);
        this.Y0 = (ImageView) this.f75055f.findViewById(m.l.W);
        this.Z0 = (ImageView) this.f75055f.findViewById(m.l.f76061g);
        boolean z16 = false;
        I0(false);
        int i3 = com.tencent.av.n.e().f().f73046k2;
        if (i3 == 2 || i3 == 1) {
            z16 = true;
        }
        w(z16);
    }

    private void j0(int i3, boolean z16, boolean z17) {
        int i16;
        Drawable drawable;
        Drawable drawable2;
        this.f75060h = this.f75055f.findViewById(R.id.g7c);
        this.N = (Button) this.f75055f.findViewById(m.l.f76073s);
        this.P = (Button) this.f75055f.findViewById(m.l.f76074t);
        this.f75074q0 = (RelativeLayout) this.f75055f.findViewById(R.id.g6n);
        this.f75075r0 = (RelativeLayout) this.f75055f.findViewById(R.id.g6p);
        Button button = (Button) this.f75055f.findViewById(m.l.f76062h);
        this.f75076s0 = button;
        if (button != null && (drawable2 = getResources().getDrawable(R.drawable.f161324v0)) != null) {
            drawable2.setBounds(0, 0, i3, i3);
            this.f75076s0.setCompoundDrawables(null, drawable2, null, null);
        }
        Button button2 = (Button) this.f75055f.findViewById(m.l.f76063i);
        this.f75077t0 = button2;
        if (button2 != null && (drawable = getResources().getDrawable(R.drawable.f161326v2)) != null) {
            drawable.setBounds(0, 0, i3, i3);
            this.f75077t0.setCompoundDrawables(null, drawable, null, null);
        }
        r0();
        this.f75053e0 = (FrameLayout) this.f75055f.findViewById(m.l.f76071q);
        this.f75056f0 = (Button) this.f75055f.findViewById(m.l.f76072r);
        this.f75067k0 = (Button) this.f75055f.findViewById(m.l.f76060f);
        this.f75079v0 = (Button) this.f75055f.findViewById(m.l.O);
        this.f75073p0 = (Button) this.f75055f.findViewById(m.l.f76059e);
        this.f75080w0 = (Button) this.f75055f.findViewById(m.l.P);
        this.f75078u0 = this.f75055f.findViewById(m.l.N);
        this.Y0 = (ImageView) this.f75055f.findViewById(m.l.W);
        this.Z0 = (ImageView) this.f75055f.findViewById(m.l.f76061g);
        if (z17) {
            i16 = 2;
        } else {
            i16 = 1;
        }
        H0(z16, i16, false);
        if (this.K0 != null) {
            SessionInfo f16 = com.tencent.av.n.e().f();
            if (f16.f73035i == 1 && f16.f73043k != 4) {
                w(true);
            }
        }
    }

    private void k0(int i3) {
        this.f75060h = this.f75055f.findViewById(R.id.g7c);
        this.f75069m = (Button) this.f75055f.findViewById(m.l.f76064j);
        ViewGroup viewGroup = (ViewGroup) getParent();
        this.U = viewGroup.findViewById(m.l.f76080z);
        this.f75043a0 = (ImageButton) viewGroup.findViewById(m.l.B);
        V();
        X();
        this.D = (Button) this.f75055f.findViewById(m.l.f76066l);
        QLog.d(this.f75049d, 1, "initPanel_doubleVideoInvite mWaveView VISIBLE");
    }

    private void l0(int i3) {
        this.f75060h = this.f75055f.findViewById(R.id.g7c);
        this.H = (ImageView) this.f75055f.findViewById(R.id.f166577ga2);
        this.I = (ShimmerTextView) this.f75055f.findViewById(R.id.f166578ga3);
        this.J = (ImageView) this.f75055f.findViewById(R.id.g7e);
        this.K = this.f75055f.findViewById(m.l.f76069o);
        this.f75043a0 = (ImageButton) ((ViewGroup) getParent()).findViewById(m.l.B);
        V();
        X();
        Y();
        W();
    }

    private void m0(int i3) {
        this.f75069m = (Button) this.f75055f.findViewById(m.l.f76064j);
        this.H = (ImageView) this.f75055f.findViewById(R.id.f166577ga2);
        this.I = (ShimmerTextView) this.f75055f.findViewById(R.id.f166578ga3);
        this.J = (ImageView) this.f75055f.findViewById(R.id.g7e);
        this.K = this.f75055f.findViewById(m.l.f76069o);
        this.U = ((ViewGroup) getParent()).findViewById(m.l.f76080z);
        Y();
        this.E = (Button) this.f75055f.findViewById(m.l.f76067m);
        W();
    }

    private void n0(boolean z16, int i3) {
        this.N = (Button) this.f75055f.findViewById(m.l.f76073s);
        this.f75060h = this.f75055f.findViewById(R.id.g7c);
        r0();
        this.f75067k0 = (Button) this.f75055f.findViewById(m.l.f76060f);
        p0();
        this.f75073p0 = (Button) this.f75055f.findViewById(m.l.f76059e);
        if (i3 == m.a.f75993d) {
            int screenWidth = ba.getScreenWidth(getContext()) / 4;
            int f16 = screenWidth + ((screenWidth - BaseAIOUtils.f(64.0f, getResources())) / 2);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Q0.getLayoutParams();
            layoutParams.leftMargin = f16;
            this.Q0.setLayoutParams(layoutParams);
            this.T0.setVisibility(8);
        }
        this.Y0 = (ImageView) this.f75055f.findViewById(m.l.W);
        this.Z0 = (ImageView) this.f75055f.findViewById(m.l.f76061g);
    }

    private void o0(boolean z16) {
        this.N = (Button) this.f75055f.findViewById(m.l.f76073s);
        this.f75060h = this.f75055f.findViewById(R.id.g7c);
        r0();
        this.f75067k0 = (Button) this.f75055f.findViewById(m.l.f76060f);
        p0();
        this.f75073p0 = (Button) this.f75055f.findViewById(m.l.f76059e);
        this.Y0 = (ImageView) this.f75055f.findViewById(m.l.W);
        this.Z0 = (ImageView) this.f75055f.findViewById(m.l.f76061g);
    }

    private void p0() {
        View view = this.f75055f;
        this.Q0 = view.findViewById(R.id.huk);
        this.R0 = (ImageView) view.findViewById(R.id.f30440oc);
        this.S0 = (ImageView) view.findViewById(R.id.hk9);
        this.T0 = (TextView) view.findViewById(R.id.hul);
        this.R0.setImageDrawable(getResources().getDrawable(R.drawable.n6r));
        this.Q0.setVisibility(8);
    }

    private void q0(int i3) {
        s0((ImageButton) this.U, R.drawable.d_z);
        s0(this.f75047c0, R.drawable.n6y);
        ImageButton imageButton = this.f75047c0;
        if (imageButton != null) {
            imageButton.setTag(com.tencent.av.camera.b.f73502b);
        }
    }

    private void r(View view, int i3) {
        if (view == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.leftMargin = i3;
        view.setLayoutParams(marginLayoutParams);
    }

    private void r0() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        View findViewById = viewGroup.findViewById(m.l.f76080z);
        this.U = findViewById;
        if (findViewById == null && com.tencent.av.utils.e.j()) {
            throw new IllegalArgumentException("\u6ca1\u627e\u5230VIEW_ENUM.HIDE");
        }
        this.V = viewGroup.findViewById(m.l.A);
        this.W = viewGroup.findViewById(m.l.G);
        this.f75043a0 = (ImageButton) viewGroup.findViewById(m.l.B);
        this.f75050d0 = (ImageButton) viewGroup.findViewById(m.l.C);
        this.f75045b0 = (ImageButton) viewGroup.findViewById(m.l.E);
        this.f75047c0 = (ImageButton) viewGroup.findViewById(m.b.f75998b);
        this.f75081x0 = (ImageButton) viewGroup.findViewById(m.l.S);
        this.f75082y0 = (TextView) viewGroup.findViewById(m.l.T);
        this.f75083z0 = (ImageButton) viewGroup.findViewById(m.l.Q);
        this.A0 = (TextView) viewGroup.findViewById(m.l.R);
        this.B0 = viewGroup.findViewById(m.l.H);
        this.C0 = (ImageView) viewGroup.findViewById(m.l.I);
        this.D0 = viewGroup.findViewById(m.l.J);
        this.E0 = viewGroup.findViewById(m.l.f76057c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(View view, int i3) {
        if (view == null) {
            return;
        }
        if (i3 < 2968.75f) {
            i3 = 2968;
        }
        if (i3 > 7187.5f) {
            i3 = 7187;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int dip2px = (int) (((i3 - 2968.75f) / 4218.75f) * ViewUtils.dip2px(15.0f));
        int dip2px2 = ViewUtils.dip2px(35.0f) - dip2px;
        marginLayoutParams.height = dip2px;
        marginLayoutParams.topMargin = dip2px2;
        view.setLayoutParams(marginLayoutParams);
    }

    public static void s0(ImageButton imageButton, int i3) {
        if (imageButton == null) {
            return;
        }
        Drawable drawable = imageButton.getResources().getDrawable(i3);
        drawable.clearColorFilter();
        imageButton.setImageDrawable(drawable);
        imageButton.setAdjustViewBounds(true);
        setBtnTouchEffect(imageButton);
    }

    public static void setBtnTopDrawable(TextView textView, int i3) {
        Drawable b16;
        if (textView == null) {
            return;
        }
        if (S(i3)) {
            b16 = com.tencent.av.utils.l.c(textView.getResources(), i3, false, w0(i3), w0(i3));
        } else {
            b16 = com.tencent.av.utils.l.b(textView.getResources(), i3, w0(i3), w0(i3));
        }
        textView.setCompoundDrawables(null, b16, null, null);
    }

    public static void setBtnTopDrawableWithForeGround(TextView textView, int i3, Drawable drawable) {
        if (textView == null) {
            return;
        }
        textView.setCompoundDrawables(null, com.tencent.av.utils.l.d(textView.getResources(), i3, drawable, false, w0(i3), w0(i3)), null, null);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public static void setBtnTouchEffect(View view) {
        view.setOnTouchListener(new k(view));
    }

    public static void setTopLayerImageBtnEnable(ImageButton imageButton, boolean z16) {
        if (imageButton != null && imageButton.getDrawable() != null) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoControlUI", 2, "setTopLayerImageBtnEnable, id" + com.tencent.av.ui.m.a(imageButton.getId()) + ", enable[" + z16 + "]");
            }
            Drawable drawable = imageButton.getDrawable();
            if (z16) {
                drawable.clearColorFilter();
            } else {
                drawable.setColorFilter(Color.parseColor("#4dffffff"), PorterDuff.Mode.MULTIPLY);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t0() {
        if (this.f75052e == m.a.f75990a) {
            return true;
        }
        return false;
    }

    private boolean u0() {
        VideoAppInterface videoAppInterface = this.K0;
        if (videoAppInterface != null) {
            return videoAppInterface.U();
        }
        return false;
    }

    private static boolean w0(int i3) {
        if (i3 == R.drawable.k9g) {
            return true;
        }
        return false;
    }

    private boolean x0(int i3) {
        for (int i16 : f75042j1) {
            if (i3 == i16) {
                return true;
            }
        }
        return false;
    }

    private void y() {
        RedTouch redTouch;
        if (!com.tencent.av.utils.af.x() && (redTouch = this.T) != null) {
            yv.a.b(this.K0, redTouch, 11);
        }
    }

    public static boolean y0(int i3) {
        if (i3 != m.l.f76080z && i3 != m.l.A && i3 != m.l.B && i3 != m.l.E && i3 != m.l.D && i3 != m.l.C) {
            return false;
        }
        return true;
    }

    private boolean z0() {
        o oVar = this.f75065i1;
        if (oVar != null && oVar.d()) {
            return true;
        }
        return false;
    }

    public void A() {
        RedTouch redTouch;
        if (com.tencent.av.utils.af.x() && (redTouch = this.S) != null) {
            yv.a.b(this.K0, redTouch, 1);
        }
    }

    public void B0(long j3) {
        this.f75062h1 = null;
        int i3 = 0;
        this.f75068l0 = 0;
        ValueAnimator valueAnimator = this.f75070m0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f75070m0 = null;
        }
        this.I0 = null;
        while (true) {
            NormalMenuView[] normalMenuViewArr = this.L0;
            if (i3 >= normalMenuViewArr.length) {
                break;
            }
            NormalMenuView normalMenuView = normalMenuViewArr[i3];
            if (normalMenuView != null) {
                RelativeLayout relativeLayout = normalMenuView.f74981c;
                if (relativeLayout instanceof QavMenuBaseView) {
                    ((QavMenuBaseView) relativeLayout).e(j3);
                }
            }
            this.L0[i3] = null;
            i3++;
        }
        d1();
        ValueAnimator valueAnimator2 = this.V0;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.V0.removeAllUpdateListeners();
            this.V0 = null;
        }
        if (this.K0 != null) {
            this.K0 = null;
        }
        LottieDrawable lottieDrawable = this.X0;
        if (lottieDrawable != null) {
            lottieDrawable.stop();
            this.X0.removeAllAnimatorListeners();
            this.X0.clearComposition();
            this.X0 = null;
        }
        View view = this.f75055f;
        if (view != null) {
            removeView(view);
            this.f75055f = null;
        }
        View view2 = this.f75060h;
        if (view2 != null) {
            view2.setBackground(null);
            this.f75060h = null;
        }
        Button button = this.f75069m;
        if (button != null) {
            button.setBackground(null);
            this.f75069m = null;
        }
        Button button2 = this.C;
        if (button2 != null) {
            button2.setCompoundDrawables(null, null, null, null);
            this.C = null;
        }
        Button button3 = this.D;
        if (button3 != null) {
            button3.setCompoundDrawables(null, null, null, null);
            this.D = null;
        }
        this.E = null;
        Button button4 = this.F;
        if (button4 != null) {
            button4.setCompoundDrawables(null, null, null, null);
            this.F = null;
        }
        ImageView imageView = this.G;
        if (imageView != null) {
            imageView.setOnTouchListener(null);
            this.G = null;
        }
        ImageView imageView2 = this.H;
        if (imageView2 != null) {
            imageView2.setBackground(null);
            this.H = null;
        }
        this.I = null;
        ImageView imageView3 = this.J;
        if (imageView3 != null) {
            imageView3.setBackground(null);
            this.J = null;
        }
        this.K = null;
        this.L = null;
        this.M = null;
        Button button5 = this.N;
        if (button5 != null) {
            button5.setCompoundDrawables(null, null, null, null);
            this.N = null;
        }
        Button button6 = this.P;
        if (button6 != null) {
            button6.setBackground(null);
            this.P = null;
        }
        Button button7 = this.Q;
        if (button7 != null) {
            button7.setCompoundDrawables(null, null, null, null);
            this.Q = null;
        }
        Button button8 = this.R;
        if (button8 != null) {
            button8.setCompoundDrawables(null, null, null, null);
            this.R = null;
        }
        ImageButton imageButton = this.f75050d0;
        if (imageButton != null) {
            imageButton.setImageDrawable(null);
            this.f75050d0 = null;
        }
        this.S = null;
        View view3 = this.W;
        if (view3 != null) {
            view3.setBackground(null);
            this.W = null;
        }
        View view4 = this.U;
        if (view4 != null) {
            ((ImageButton) view4).setImageDrawable(null);
            this.U = null;
        }
        View view5 = this.V;
        if (view5 != null) {
            ((ImageButton) view5).setImageDrawable(null);
            this.V = null;
        }
        ImageButton imageButton2 = this.f75043a0;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(null);
            this.f75043a0 = null;
        }
        ImageButton imageButton3 = this.f75045b0;
        if (imageButton3 != null) {
            imageButton3.setImageDrawable(null);
            this.f75045b0 = null;
        }
        ImageButton imageButton4 = this.f75047c0;
        if (imageButton4 != null) {
            imageButton4.setImageDrawable(null);
            this.f75047c0 = null;
        }
        this.f75053e0 = null;
        Button button9 = this.f75056f0;
        if (button9 != null) {
            button9.setCompoundDrawables(null, null, null, null);
            this.f75056f0 = null;
        }
        this.f75058g0 = null;
        this.f75061h0 = null;
        this.f75064i0 = null;
        this.f75066j0 = null;
        Button button10 = this.f75067k0;
        if (button10 != null) {
            button10.setCompoundDrawables(null, null, null, null);
            this.f75067k0 = null;
        }
        this.f75072o0 = null;
        Button button11 = this.f75073p0;
        if (button11 != null) {
            button11.setCompoundDrawables(null, null, null, null);
            this.f75073p0 = null;
        }
        RelativeLayout relativeLayout2 = this.f75074q0;
        if (relativeLayout2 != null) {
            relativeLayout2.clearAnimation();
            this.f75074q0 = null;
        }
        RelativeLayout relativeLayout3 = this.f75075r0;
        if (relativeLayout3 != null) {
            relativeLayout3.clearAnimation();
            this.f75075r0 = null;
        }
        Button button12 = this.f75076s0;
        if (button12 != null) {
            button12.setCompoundDrawables(null, null, null, null);
            this.f75076s0 = null;
        }
        Button button13 = this.f75077t0;
        if (button13 != null) {
            button13.setCompoundDrawables(null, null, null, null);
            this.f75077t0 = null;
        }
        View view6 = this.f75078u0;
        if (view6 != null) {
            view6.clearAnimation();
            this.f75078u0 = null;
        }
        Button button14 = this.f75079v0;
        if (button14 != null) {
            button14.setCompoundDrawables(null, null, null, null);
            this.f75079v0 = null;
        }
        Button button15 = this.f75080w0;
        if (button15 != null) {
            button15.setCompoundDrawables(null, null, null, null);
            this.f75080w0 = null;
        }
        ImageButton imageButton5 = this.f75081x0;
        if (imageButton5 != null) {
            imageButton5.setBackground(null);
            this.f75081x0 = null;
        }
        TextView textView = this.f75082y0;
        if (textView != null) {
            textView.setText("");
            this.f75082y0 = null;
        }
        ImageButton imageButton6 = this.f75083z0;
        if (imageButton6 != null) {
            imageButton6.setImageDrawable(null);
            this.f75083z0 = null;
        }
        TextView textView2 = this.A0;
        if (textView2 != null) {
            textView2.setText("");
            this.A0 = null;
        }
        this.H0 = null;
        rw.c cVar = this.N0;
        if (cVar != null) {
            cVar.f();
            this.N0 = null;
        }
        com.tencent.av.utils.ao aoVar = this.P0;
        if (aoVar != null) {
            aoVar.f();
            this.P0 = null;
        }
        this.Q0 = null;
        ImageView imageView4 = this.R0;
        if (imageView4 != null) {
            imageView4.setImageDrawable(null);
            this.R0 = null;
        }
        this.S0 = null;
        this.T0 = null;
        ImageView imageView5 = this.Y0;
        if (imageView5 != null) {
            imageView5.setBackground(null);
            this.Y0 = null;
        }
        ImageView imageView6 = this.Z0;
        if (imageView6 != null) {
            imageView6.setBackground(null);
            this.Z0 = null;
        }
        QLog.d(this.f75049d, 1, "ondestory.");
    }

    NormalMenuView C(int i3, NormalMenuView.a aVar) {
        QavMenuBaseView qavOperationMenuView;
        Context context = getContext();
        if (this.N0 != null && (context instanceof AVActivity)) {
            if (i3 != 1) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 != 6) {
                                qavOperationMenuView = new QavVirtualMenuView(context);
                                QLog.w(this.f75049d, 1, "error!!! com.tencent.av.ui.QavPanel.createMenu(int, com.tencent.av.ui.NormalMenuView.ViewEvent) run default branch");
                            } else {
                                qavOperationMenuView = new QavOperationV2MenuView(context);
                            }
                        } else {
                            qavOperationMenuView = new QavEffectMenuView(context);
                        }
                    } else {
                        qavOperationMenuView = new QavVirtualMenuView(context);
                    }
                } else {
                    qavOperationMenuView = new QavBeautyMenuPanel(context);
                }
            } else {
                qavOperationMenuView = new QavOperationMenuView(context);
            }
            qavOperationMenuView.setVisibility(8);
            qavOperationMenuView.setGravity(80);
            ((RelativeLayout) findViewById(m.l.f76055a)).addView(qavOperationMenuView, new RelativeLayout.LayoutParams(-1, -2));
            qavOperationMenuView.a(this);
            qavOperationMenuView.h();
            return new NormalMenuView(qavOperationMenuView, i3, aVar);
        }
        return null;
    }

    void D(int i3) {
        NormalMenuView normalMenuView;
        if (this.L0[i3] != null) {
            return;
        }
        if (i3 == 1) {
            normalMenuView = F(1);
        } else if (i3 == 0) {
            normalMenuView = E();
        } else if (i3 == 3) {
            normalMenuView = C(3, new com.tencent.av.ui.i("0X800A567"));
        } else if (i3 == 4) {
            normalMenuView = C(4, new com.tencent.av.ui.i(null));
        } else if (i3 == 5) {
            normalMenuView = C(5, new com.tencent.av.ui.i(null));
        } else if (i3 == 6) {
            normalMenuView = F(6);
        } else {
            normalMenuView = null;
        }
        this.L0[i3] = normalMenuView;
    }

    public void D0(boolean z16) {
        boolean z17;
        if (this.K0 == null) {
            return;
        }
        if (!t0() && com.tencent.av.r.h0().e0() != 1 && com.tencent.av.r.h0().e0() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        QLog.d(this.f75049d, 1, "refreshButtonStatus, from[1], mute[" + z16 + "], canRefresh[" + z17 + "]");
        if (this.J0 && z17) {
            if (z16) {
                this.P0.setAlpha(255);
                this.P0.g(1);
                Q0(m.l.f76060f, getResources().getString(R.string.f1376907j));
                Q0(m.l.O, getResources().getString(R.string.f1376907j));
                if (!this.W0 && z0()) {
                    this.f75062h1.removeMessages(257);
                    this.f75062h1.sendEmptyMessageDelayed(257, 5300L);
                }
                if (!ba.getPressSpeakerGuiderFlag(false)) {
                    this.f75062h1.removeMessages(258);
                    this.f75062h1.sendEmptyMessageDelayed(258, 300L);
                    return;
                }
                return;
            }
            this.P0.setAlpha(255);
            this.P0.g(0);
            this.f75062h1.removeMessages(257);
            if (!ba.getPressSpeakerGuiderFlag(true)) {
                this.f75062h1.removeMessages(259);
                this.f75062h1.sendEmptyMessageDelayed(259, 300L);
            }
        }
    }

    NormalMenuView E() {
        RelativeLayout relativeLayout;
        View view = this.f75055f;
        if (view == null || (relativeLayout = (RelativeLayout) view.findViewById(m.l.f76056b)) == null) {
            return null;
        }
        if (com.tencent.av.utils.e.e(0) == 1) {
            relativeLayout.setBackgroundColor(2142236398);
        }
        return new NormalMenuView(relativeLayout, 0, null);
    }

    public void E0() {
        NormalMenuView normalMenuView = this.L0[6];
        if (normalMenuView == null || !normalMenuView.f74983e) {
            return;
        }
        RelativeLayout relativeLayout = normalMenuView.f74981c;
        if (!(relativeLayout instanceof QavOperationBaseMenuView)) {
            return;
        }
        ((QavOperationBaseMenuView) relativeLayout).h();
    }

    NormalMenuView F(int i3) {
        NormalMenuView C = C(i3, new com.tencent.av.ui.i(null));
        if (C != null) {
            RelativeLayout relativeLayout = C.f74981c;
            if (relativeLayout instanceof QavOperationBaseMenuView) {
                QavOperationBaseMenuView qavOperationBaseMenuView = (QavOperationBaseMenuView) relativeLayout;
                qavOperationBaseMenuView.setViewController(this.N0);
                qavOperationBaseMenuView.setQavMenuActionListener(new b());
            }
        }
        return C;
    }

    void F0(boolean z16) {
        i1(z16);
        NormalMenuView normalMenuView = this.L0[0];
        if (z16) {
            if (normalMenuView != null && normalMenuView.a() != null) {
                normalMenuView.a().setBackgroundResource(R.drawable.k9b);
            }
        } else if (normalMenuView != null && normalMenuView.a() != null) {
            normalMenuView.a().setBackgroundColor(0);
        }
        c1(z16);
    }

    void G() {
        if (this.N0 != null) {
            return;
        }
        this.N0 = rw.b.a(getResources(), this.f75052e);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x006d, code lost:
    
        if (r9 == 3) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b9  */
    @TargetApi(11)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void H(String str, int i3, int i16, boolean z16) {
        boolean z17;
        boolean z18 = true;
        QLog.d(this.f75049d, 1, "doSpeakerStatusChange from:=" + str + ";lastStatus:=" + i3 + ";nextStatus:=" + i16);
        if (!this.J0) {
            return;
        }
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 == 3) {
                        this.P0.setAlpha(127);
                        this.P0.g(3);
                        b1();
                    }
                } else {
                    this.P0.g(2);
                }
                z18 = false;
            } else {
                if (i3 == 0) {
                    QLog.d(this.f75049d, 1, "test has call keep speaking status");
                } else {
                    if (i3 == 2) {
                        d1();
                    }
                    z17 = false;
                    R("doSpeakerStatusChange KEEP_SPEAKING_STATUS", 2);
                    this.P0.setAlpha(255);
                    this.P0.g(1);
                    Q0(m.l.f76060f, getResources().getString(R.string.f1376907j));
                    Q0(m.l.O, getResources().getString(R.string.f1376907j));
                    if (!this.W0 && z0()) {
                        this.f75062h1.removeMessages(257);
                        this.f75062h1.sendEmptyMessageDelayed(257, 5300L);
                    }
                    if (!ba.getPressSpeakerGuiderFlag(false)) {
                        this.f75062h1.removeMessages(258);
                        this.f75062h1.sendEmptyMessageDelayed(258, 300L);
                    }
                    z18 = z17;
                }
                z17 = true;
                R("doSpeakerStatusChange KEEP_SPEAKING_STATUS", 2);
                this.P0.setAlpha(255);
                this.P0.g(1);
                Q0(m.l.f76060f, getResources().getString(R.string.f1376907j));
                Q0(m.l.O, getResources().getString(R.string.f1376907j));
                if (!this.W0) {
                    this.f75062h1.removeMessages(257);
                    this.f75062h1.sendEmptyMessageDelayed(257, 5300L);
                }
                if (!ba.getPressSpeakerGuiderFlag(false)) {
                }
                z18 = z17;
            }
        } else {
            if (i3 == 2) {
                d1();
            }
            R("doSpeakerStatusChange KEEP_SPEAKING_STATUS", 2);
            this.P0.setAlpha(255);
            this.P0.g(0);
            if (!ba.getPressSpeakerGuiderFlag(true)) {
                this.f75062h1.removeMessages(259);
                this.f75062h1.sendEmptyMessageAtTime(259, 300L);
            }
        }
        if (this.f75065i1 != null && this.K0 != null && z16 && t0()) {
            this.f75065i1.a(com.tencent.av.n.e().f().K, z18);
        }
    }

    public void H0(boolean z16, int i3, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d(this.f75049d, 2, "videoSession :" + z16 + ", localHasVideo:" + i3 + ", isVipFunCall:" + z17);
        }
        F0(z16);
    }

    public boolean I() {
        return this.J0;
    }

    public void I0(boolean z16) {
        QLog.d(this.f75049d, 2, "resizeLayout4DoubleVideoMeeting mEffectiveType:" + z16);
        F0(z16);
    }

    public void J0(boolean z16, int i3) {
        boolean z17;
        QLog.d(this.f75049d, 2, "resizeLayout4Group mEffectiveType:" + i3);
        if (i3 == 2) {
            z17 = true;
        } else {
            z17 = false;
        }
        F0(z17);
    }

    public int K() {
        return this.M0;
    }

    public void K0(boolean z16, int i3) {
        boolean z17;
        QLog.d(this.f75049d, 2, "resizeLayout4Multi mEffectiveType:" + i3);
        if (i3 == 2) {
            z17 = true;
        } else {
            z17 = false;
        }
        F0(z17);
    }

    public int L() {
        SessionInfo f16 = com.tencent.av.n.e().f();
        if (this.f75052e == m.a.f75990a) {
            return f16.J;
        }
        return com.tencent.av.r.h0().e0();
    }

    public rw.a M(int i3) {
        rw.c cVar = this.N0;
        if (cVar == null) {
            return null;
        }
        return cVar.c(i3);
    }

    public boolean M0(TraeHelper traeHelper) {
        Button button;
        QLog.d(this.f75049d, 1, "setHandFreeButtonForTrae mBtnHandFree=" + this.f75073p0, new Throwable());
        if (traeHelper != null && (button = this.f75073p0) != null) {
            traeHelper.c0(button);
            return true;
        }
        return false;
    }

    public <T extends RelativeLayout> T N(int i3) {
        NormalMenuView normalMenuView;
        if (i3 == 99) {
            i3 = this.M0;
        }
        if (i3 >= 0 && (normalMenuView = this.L0[i3]) != null) {
            return (T) normalMenuView.a();
        }
        return null;
    }

    public boolean N0(TraeHelper traeHelper) {
        Button button;
        QLog.d(this.f75049d, 1, "setHandFreeOldButtonForTrae mBtnHandFree=" + this.f75073p0, new Throwable());
        if (traeHelper != null && (button = this.f75080w0) != null) {
            traeHelper.c0(button);
            return true;
        }
        return false;
    }

    @Deprecated
    public View O(rw.a aVar) {
        NormalMenuView normalMenuView = this.L0[1];
        if (normalMenuView == null || !normalMenuView.f74983e) {
            return null;
        }
        RelativeLayout relativeLayout = normalMenuView.f74981c;
        if (!(relativeLayout instanceof QavOperationMenuView)) {
            return null;
        }
        return ((QavOperationMenuView) relativeLayout).w(aVar);
    }

    public int P(int i3) {
        View h16 = h1(i3);
        if (h16 != null) {
            return h16.getVisibility();
        }
        return -1;
    }

    public boolean P0(n nVar) {
        v vVar = this.L;
        if (vVar == null) {
            return false;
        }
        vVar.c(nVar);
        return true;
    }

    public boolean Q0(int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(this.f75049d, 2, "setViewAccText, id" + com.tencent.av.ui.m.a(i3) + ", text[" + str + "]");
        }
        View h16 = h1(i3);
        if (h16 != null) {
            ba.setAccText(h16, str);
            return true;
        }
        return false;
    }

    public void R(String str, int i3) {
        QLog.d(this.f75049d, 1, "pressSpeaking hidePressSpreakingGuiderOrTips, from[" + str + "], tipsType[" + i3 + "]");
        View view = this.Q0;
        if (view != null) {
            if (this.f75059g1 == i3 || i3 == 0) {
                view.setVisibility(8);
            }
        }
    }

    public boolean R0(int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d(this.f75049d, 2, "setViewBackground, id" + com.tencent.av.ui.m.a(i3) + ", selected[" + i16 + "]");
        }
        View h16 = h1(i3);
        if (h16 != null) {
            h16.setBackgroundResource(i16);
            return true;
        }
        return false;
    }

    public boolean S0(int i3, boolean z16) {
        if (QLog.isDevelopLevel()) {
            QLog.d(this.f75049d, 2, "setViewClickable, id" + com.tencent.av.ui.m.a(i3));
        }
        View h16 = h1(i3);
        if (h16 != null) {
            h16.setClickable(z16);
            return true;
        }
        return false;
    }

    View T(int i3) {
        View inflate = LayoutInflater.from(getContext()).inflate(i3, (ViewGroup) this, false);
        this.f75055f = inflate;
        return inflate;
    }

    public boolean T0(int i3, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(this.f75049d, 2, "setViewSelected, id" + com.tencent.av.ui.m.a(i3) + ", selected[" + z16 + "]");
        }
        View h16 = h1(i3);
        if (h16 != null) {
            h16.setSelected(z16);
            return true;
        }
        return false;
    }

    public boolean U0(int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d(this.f75049d, 2, "setViewText, id" + com.tencent.av.ui.m.a(i3) + ", resId[" + i16 + "]");
        }
        View h16 = h1(i3);
        if (h16 != null) {
            ((TextView) h16).setText(i16);
            return true;
        }
        return false;
    }

    public void V0(long j3, int i3) {
        D(5);
        QavEffectBaseMenuView qavEffectBaseMenuView = (QavEffectBaseMenuView) N(5);
        if (qavEffectBaseMenuView == null || !qavEffectBaseMenuView.F(j3, i3)) {
            return;
        }
        X0(j3, 5, true);
    }

    void W() {
        this.G = (ImageView) this.f75055f.findViewById(m.l.f76070p);
        this.L = new v(getContext(), this.G, this.H, this.I, this.J);
        if (u0()) {
            this.G.setContentDescription(getResources().getString(R.string.ic8));
            this.G.setFocusable(true);
            this.G.setClickable(true);
            this.G.setOnClickListener(new d());
            return;
        }
        this.G.setOnTouchListener(this.L);
    }

    public void W0(QQFrameByFrameAnimation qQFrameByFrameAnimation) {
        Button button = this.N;
        if (button != null) {
            qQFrameByFrameAnimation.f(button);
            qQFrameByFrameAnimation.g();
            return;
        }
        ImageButton imageButton = this.M;
        if (imageButton != null) {
            qQFrameByFrameAnimation.f(imageButton);
            qQFrameByFrameAnimation.g();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ac, code lost:
    
        if (r20 != 6) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b4, code lost:
    
        if (r20 == 0) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void X0(final long j3, final int i3, final boolean z16) {
        int f16;
        int i16;
        boolean z17;
        int i17;
        boolean z18;
        Runnable runnable;
        if (!(getContext() instanceof AVActivity)) {
            return;
        }
        boolean z19 = false;
        NormalMenuView normalMenuView = this.L0[0];
        if (i3 != 0 && normalMenuView == null) {
            X0(-1020L, 0, false);
        }
        NormalMenuView J = J();
        if (J != null) {
            if (J.f74982d == i3) {
                QLog.w(this.f75049d, 1, "showMenu direct, menuType[" + i3 + "], needAnimation[" + z16 + "], seq[" + j3 + "]");
                J.d(j3, z16, 3);
                this.K0.k0(new Object[]{123, Integer.valueOf(i3), Long.valueOf(j3)});
                return;
            }
            D(i3);
        } else {
            D(i3);
        }
        if (this.L0[i3] == null) {
            return;
        }
        if (J == null) {
            f16 = -1;
        } else {
            f16 = J.f();
        }
        if (f16 != 0) {
            i16 = 4;
            if (f16 != 1 && f16 != 6) {
                if (f16 != -1) {
                    if (f16 == 3 || f16 == 5) {
                        if (i3 != 0) {
                            if (i3 != 1) {
                            }
                            i16 = 3;
                        }
                        z17 = true;
                        i17 = 2;
                    }
                    i17 = -1;
                    z17 = false;
                }
            } else {
                if (i3 != 3 && i3 != 5) {
                }
                i16 = 3;
                z17 = true;
                i17 = 2;
            }
            String str = this.f75049d;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("showMenu, MenuType[");
            sb5.append(f16);
            sb5.append("->");
            sb5.append(i3);
            sb5.append("], seq[");
            sb5.append(j3);
            sb5.append("], isVisible[");
            if (getVisibility() != 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            sb5.append(z18);
            sb5.append("]");
            QLog.w(str, 1, sb5.toString(), new Throwable());
            this.M0 = i3;
            if (f16 != i3 && f16 == 0) {
                R("showMenu", 0);
                this.f75062h1.removeMessages(257);
            }
            final int i18 = i16;
            runnable = new Runnable() { // from class: com.tencent.av.ui.QavPanel.9
                @Override // java.lang.Runnable
                public void run() {
                    QavPanel qavPanel = QavPanel.this;
                    if (qavPanel.K0 != null) {
                        NormalMenuView[] normalMenuViewArr = qavPanel.L0;
                        int i19 = i3;
                        NormalMenuView normalMenuView2 = normalMenuViewArr[i19];
                        if (normalMenuView2 != null) {
                            if (i19 != qavPanel.M0) {
                                QLog.w(qavPanel.f75049d, 1, "doShowAnimation, invalid menuType[" + i3 + "], curMenuType[" + QavPanel.this.M0 + "], seq[" + j3 + "]");
                                return;
                            }
                            normalMenuView2.d(j3, z16, i18);
                            QavPanel.this.K0.k0(new Object[]{123, Integer.valueOf(i3), Long.valueOf(j3)});
                        }
                    }
                }
            };
            if (getVisibility() == 0) {
                z19 = z17;
            }
            if (J != null) {
                J.b(j3, z19, i17, new a(runnable));
            }
            if (J != null || !z19) {
                runnable.run();
            }
            return;
        }
        i16 = 3;
        i17 = -1;
        z17 = false;
        String str2 = this.f75049d;
        StringBuilder sb52 = new StringBuilder();
        sb52.append("showMenu, MenuType[");
        sb52.append(f16);
        sb52.append("->");
        sb52.append(i3);
        sb52.append("], seq[");
        sb52.append(j3);
        sb52.append("], isVisible[");
        if (getVisibility() != 0) {
        }
        sb52.append(z18);
        sb52.append("]");
        QLog.w(str2, 1, sb52.toString(), new Throwable());
        this.M0 = i3;
        if (f16 != i3) {
            R("showMenu", 0);
            this.f75062h1.removeMessages(257);
        }
        final int i182 = i16;
        runnable = new Runnable() { // from class: com.tencent.av.ui.QavPanel.9
            @Override // java.lang.Runnable
            public void run() {
                QavPanel qavPanel = QavPanel.this;
                if (qavPanel.K0 != null) {
                    NormalMenuView[] normalMenuViewArr = qavPanel.L0;
                    int i19 = i3;
                    NormalMenuView normalMenuView2 = normalMenuViewArr[i19];
                    if (normalMenuView2 != null) {
                        if (i19 != qavPanel.M0) {
                            QLog.w(qavPanel.f75049d, 1, "doShowAnimation, invalid menuType[" + i3 + "], curMenuType[" + QavPanel.this.M0 + "], seq[" + j3 + "]");
                            return;
                        }
                        normalMenuView2.d(j3, z16, i182);
                        QavPanel.this.K0.k0(new Object[]{123, Integer.valueOf(i3), Long.valueOf(j3)});
                    }
                }
            }
        };
        if (getVisibility() == 0) {
        }
        if (J != null) {
        }
        if (J != null) {
        }
        runnable.run();
    }

    void Y() {
        Button button = (Button) this.f75055f.findViewById(m.l.f76066l);
        this.D = button;
        if (button != null) {
            com.tencent.av.utils.e.a(getResources(), this.D, R.drawable.dcb, R.color.f157463q4, R.color.f157463q4);
        }
    }

    public void Y0(Animation.AnimationListener animationListener) {
        boolean z16;
        if (this.P != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.f75075r0 != null && this.f75074q0 != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setFillEnabled(true);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setDuration(400L);
            AlphaAnimation B = B();
            B.setAnimationListener(animationListener);
            if (this.f75074q0.getVisibility() == 0) {
                this.f75074q0.startAnimation(alphaAnimation);
            } else if (this.f75078u0.getVisibility() == 0) {
                this.f75078u0.startAnimation(alphaAnimation);
            }
            this.f75075r0.startAnimation(B);
            if (z16) {
                this.P.startAnimation(B());
                this.P.setVisibility(0);
            }
        }
    }

    public void Z0() {
        RelativeLayout relativeLayout = this.f75075r0;
        if (relativeLayout != null && this.f75074q0 != null) {
            relativeLayout.setVisibility(0);
            this.f75075r0.clearAnimation();
            this.f75074q0.clearAnimation();
            this.f75074q0.setVisibility(4);
            this.f75078u0.clearAnimation();
            this.f75078u0.setVisibility(4);
        }
    }

    void a0() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        this.f75058g0 = (TextView) viewGroup.findViewById(m.l.f76077w);
        TextView textView = (TextView) viewGroup.findViewById(m.l.f76078x);
        this.f75061h0 = textView;
        TextView textView2 = this.f75058g0;
        if (textView2 != null && textView != null) {
            textView2.setTextColor(getResources().getColor(R.color.f157532sa));
            this.f75061h0.setTextColor(getResources().getColor(R.color.f157532sa));
        }
        this.R = (Button) viewGroup.findViewById(m.l.K);
        this.Q = (Button) viewGroup.findViewById(m.l.L);
        this.F0 = viewGroup.findViewById(m.l.f76075u);
        this.G0 = (ImageView) viewGroup.findViewById(m.l.f76076v);
        this.f75064i0 = (TextView) viewGroup.findViewById(R.id.f9d);
        this.f75066j0 = (ImageView) viewGroup.findViewById(R.id.z69);
        if (com.tencent.av.utils.af.x()) {
            d0();
        } else {
            c0();
        }
        b0();
    }

    public void a1(String str) {
        QLog.d(this.f75049d, 1, "pressSpeaking showPressSpeakingGuider, from[1], text[" + str + "], mVoiceGuiderRootContent[" + this.Q0 + "]");
        View view = this.Q0;
        if (view != null) {
            this.f75059g1 = 1;
            view.setVisibility(0);
            this.S0.getBackground().setAlpha(255);
            this.S0.setVisibility(0);
            this.T0.setText(str);
            this.T0.setVisibility(0);
            this.R0.setVisibility(8);
        }
    }

    public void b0() {
        RedTouch h16 = yv.a.h(this.K0, this.f75050d0, 11);
        this.T = h16;
        if (h16 != null) {
            this.T.setMargin(0, (int) ba.px2dp(getContext(), this.f75050d0.getPaddingRight()), (int) ba.px2dp(getContext(), this.f75050d0.getPaddingTop()), 0).applyTo();
        }
    }

    public void b1() {
        if (this.Q0 != null && z0()) {
            this.f75059g1 = 2;
            this.Q0.setVisibility(0);
            this.S0.getBackground().setAlpha(127);
            this.S0.setVisibility(0);
            this.R0.getBackground().setAlpha(127);
            this.R0.setVisibility(0);
            this.T0.setVisibility(8);
        }
    }

    public void c0() {
        RedTouch h16 = yv.a.h(this.K0, this.R, 11);
        this.S = h16;
        if (h16 != null) {
            this.S.setMargin(0, (int) ba.px2dp(getContext(), this.R.getPaddingRight()), (int) ba.px2dp(getContext(), this.R.getPaddingTop()), 0).applyTo();
        }
    }

    public void c1(boolean z16) {
        View view = this.f75060h;
        if (view == null) {
            return;
        }
        if (z16) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
        if (com.tencent.av.utils.e.e(0) == 1) {
            this.f75060h.setBackgroundColor(-536894208);
        }
    }

    public void d0() {
        RedTouch h16 = yv.a.h(this.K0, this.R, 1);
        this.S = h16;
        if (h16 != null) {
            this.S.setMargin(0, (int) ba.px2dp(getContext(), getResources().getDimensionPixelSize(R.dimen.cz8)), (int) ba.px2dp(getContext(), getResources().getDimensionPixelSize(R.dimen.cz8)), 0).applyTo();
        }
    }

    public void e1(boolean z16, boolean z17) {
        if (z17) {
            this.f75071n0 = false;
            this.f75068l0 = 0;
            ValueAnimator valueAnimator = this.f75070m0;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f75070m0 = null;
            }
            ClipDrawable clipDrawable = this.f75072o0;
            if (clipDrawable != null) {
                clipDrawable.setLevel(0);
            }
            ImageView imageView = this.Y0;
            if (imageView != null) {
                s(imageView, 0);
            }
            if (this.J0) {
                O0(0);
                this.P0.d(0);
                return;
            }
            return;
        }
        this.f75071n0 = true;
    }

    public void g0(int i3) {
        h0(i3, false, false);
    }

    public void h0(int i3, boolean z16, boolean z17) {
        if (this.f75063i) {
            return;
        }
        U();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.a8y);
        this.f75052e = i3;
        T(i3);
        QLog.d("AVDebug", 1, "init panel type: " + i3);
        int i16 = this.f75052e;
        if (i16 == m.a.f75994e) {
            k0(dimensionPixelSize);
        } else if (i16 == m.a.f75995f) {
            l0(dimensionPixelSize);
        } else if (i16 == m.a.f75996g) {
            m0(dimensionPixelSize);
        } else if (i16 == m.a.f75990a) {
            j0(dimensionPixelSize, z16, z17);
        } else if (i16 == m.a.f75992c) {
            o0(z17);
        } else if (i16 == m.a.f75993d) {
            n0(z17, i16);
        } else if (i16 == m.a.f75991b) {
            i0();
        }
        View view = this.f75055f;
        if (view != null) {
            addView(view);
        }
        G();
        t(ba.getScreenWidth(getContext()));
        this.f75063i = true;
        setBtnOnTouchListener(this.H0);
        a0();
        Z(this.f75052e);
        q0(this.f75052e);
        F0(z16);
        if (com.tencent.av.utils.e.e(0) == 1) {
            Button button = this.f75073p0;
            if (button != null) {
                button.setBackgroundColor(Color.argb(255, 68, 128, 2));
            }
            Button button2 = this.f75080w0;
            if (button2 != null) {
                button2.setBackgroundColor(Color.argb(255, 68, 128, 2));
            }
            setBackgroundColor(-545259606);
            View view2 = this.V;
            if (view2 != null) {
                view2.setBackgroundColor(2145129532);
            }
        }
    }

    public View h1(int i3) {
        if (i3 == m.l.f76060f) {
            return this.f75067k0;
        }
        if (i3 == m.l.f76061g) {
            return this.Z0;
        }
        if (i3 == m.l.O) {
            return this.f75079v0;
        }
        if (i3 == m.l.f76077w) {
            return this.f75058g0;
        }
        if (i3 == m.l.f76078x) {
            return this.f75061h0;
        }
        if (i3 == m.l.f76064j) {
            return this.f75069m;
        }
        if (i3 == m.l.f76066l) {
            return this.D;
        }
        if (i3 == m.l.f76067m) {
            return this.E;
        }
        if (i3 == m.l.f76065k) {
            return this.C;
        }
        if (i3 == m.l.f76062h) {
            return this.f75076s0;
        }
        if (i3 == m.l.f76059e) {
            return this.f75073p0;
        }
        if (i3 == m.l.P) {
            return this.f75080w0;
        }
        if (i3 == m.l.f76073s) {
            return this.N;
        }
        if (i3 == m.l.f76074t) {
            return this.P;
        }
        if (i3 == m.l.L) {
            return this.Q;
        }
        if (i3 == m.l.K) {
            return this.R;
        }
        if (i3 == m.l.f76080z) {
            return this.U;
        }
        if (i3 == m.l.f76069o) {
            return this.K;
        }
        if (i3 == m.l.f76068n) {
            return this.F;
        }
        if (i3 == m.l.f76063i) {
            return this.f75077t0;
        }
        if (i3 == m.l.f76070p) {
            return this.G;
        }
        if (i3 == m.l.f76071q) {
            return this.f75053e0;
        }
        if (i3 == m.l.f76072r) {
            return this.f75056f0;
        }
        if (i3 == m.l.A) {
            return this.V;
        }
        if (i3 == m.l.G) {
            return this.W;
        }
        if (i3 == m.l.B) {
            return this.f75043a0;
        }
        if (i3 == m.l.E) {
            return this.f75045b0;
        }
        if (i3 == m.l.D) {
            return this.f75047c0;
        }
        if (i3 == m.l.C) {
            return this.f75050d0;
        }
        if (i3 == m.l.Q) {
            return this.f75083z0;
        }
        if (i3 == m.l.R) {
            return this.A0;
        }
        if (i3 == m.l.S) {
            return this.f75081x0;
        }
        if (i3 == m.l.T) {
            return this.f75082y0;
        }
        if (i3 == m.l.U) {
            return this.f75064i0;
        }
        if (i3 == m.l.V) {
            return this.f75066j0;
        }
        if (i3 == m.l.H) {
            return this.B0;
        }
        if (i3 == m.l.I) {
            return this.C0;
        }
        if (i3 == m.l.J) {
            return this.D0;
        }
        if (i3 == m.l.f76057c) {
            return this.E0;
        }
        if (i3 == m.l.f76075u) {
            return this.F0;
        }
        String str = HardCodeUtil.qqStr(R.string.pqz) + i3 + "]\uff0cName[" + com.tencent.av.ui.m.a(i3) + "]\uff0cName[" + com.tencent.av.utils.e.h(this, i3);
        QLog.d(this.f75049d, 1, str);
        if (!com.tencent.av.utils.e.j()) {
            return null;
        }
        throw new IllegalArgumentException(str);
    }

    public void i1(boolean z16) {
        Button button = this.R;
        if (button != null && this.Q != null) {
            if (z16) {
                if (button.getVisibility() != 0) {
                    C0(true);
                    this.R.setVisibility(0);
                }
                this.Q.setVisibility(8);
            } else {
                button.setVisibility(8);
                if (this.Q.getVisibility() != 0) {
                    C0(false);
                    this.Q.setVisibility(0);
                }
            }
            View view = this.F0;
            if (view != null && view.getVisibility() == 0) {
                this.F0.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public boolean isPressed() {
        View view;
        Button button;
        Button button2;
        Button button3;
        Button button4;
        if (!super.isPressed() && (((view = this.V) == null || !view.isPressed()) && (((button = this.f75067k0) == null || !button.isPressed()) && (((button2 = this.f75079v0) == null || !button2.isPressed()) && (((button3 = this.f75073p0) == null || !button3.isPressed()) && ((button4 = this.f75080w0) == null || !button4.isPressed())))))) {
            return false;
        }
        return true;
    }

    public void j1(boolean z16, int i3) {
        int i16;
        float f16;
        if (this.F0 != null && this.G0 != null) {
            Button button = this.R;
            if (button != null && button.getVisibility() == 0) {
                this.R.setVisibility(8);
            }
            Button button2 = this.Q;
            if (button2 != null && button2.getVisibility() == 0) {
                this.Q.setVisibility(8);
            }
            if (i3 == 1) {
                i16 = R.drawable.n6k;
            } else {
                i16 = R.drawable.n6m;
            }
            if (this.F0.getVisibility() != 0) {
                this.F0.setVisibility(0);
            }
            this.G0.setImageResource(i16);
            ImageView imageView = this.G0;
            if (z16) {
                f16 = 1.0f;
            } else {
                f16 = 0.15f;
            }
            imageView.setAlpha(f16);
        }
    }

    public void p(int i3) {
        boolean z16;
        if (this.N0 == null) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(this.f75049d, 2, "SetBeautyViewVisibility, visibility:" + i3);
        }
        rw.c cVar = this.N0;
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        cVar.i(z16);
    }

    public void q(o oVar) {
        this.f75065i1 = oVar;
    }

    public void setAudioVolumeValue(int i3) {
        int i16;
        boolean z16;
        long j3;
        Button button;
        Button button2 = this.f75067k0;
        if (button2 != null || this.f75079v0 != null) {
            if (button2 != null && !button2.isShown() && (button = this.f75079v0) != null && !button.isShown()) {
                return;
            }
            int i17 = this.f75068l0;
            this.f75068l0 = i3;
            if (i3 != i17) {
                ValueAnimator valueAnimator = this.f75070m0;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    i17 = ((Integer) this.f75070m0.getAnimatedValue()).intValue();
                    this.f75070m0.cancel();
                    i16 = i17;
                } else {
                    i16 = -1;
                }
                if (this.f75070m0 == null) {
                    ValueAnimator valueAnimator2 = new ValueAnimator();
                    this.f75070m0 = valueAnimator2;
                    valueAnimator2.addUpdateListener(new h());
                }
                if (this.f75068l0 > i17) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                ValueAnimator valueAnimator3 = this.f75070m0;
                if (z16) {
                    j3 = 100;
                } else {
                    j3 = 200;
                }
                valueAnimator3.setDuration(j3);
                ValueAnimator valueAnimator4 = this.f75070m0;
                int[] iArr = new int[2];
                if (i16 != -1) {
                    i17 = i16;
                }
                iArr[0] = i17;
                iArr[1] = this.f75068l0;
                valueAnimator4.setIntValues(iArr);
                this.f75070m0.start();
                return;
            }
            ClipDrawable clipDrawable = this.f75072o0;
            if (clipDrawable != null) {
                clipDrawable.setLevel(i3);
            }
            s(this.Y0, i3);
        }
    }

    public void setBtnOnTouchListener(View.OnTouchListener onTouchListener) {
        this.H0 = onTouchListener;
        Button button = this.f75067k0;
        if (button != null) {
            button.setOnTouchListener(onTouchListener);
        }
        Button button2 = this.f75073p0;
        if (button2 != null) {
            button2.setOnTouchListener(onTouchListener);
        }
        Button button3 = this.f75079v0;
        if (button3 != null) {
            button3.setOnTouchListener(onTouchListener);
        }
        Button button4 = this.f75080w0;
        if (button4 != null) {
            button4.setOnTouchListener(onTouchListener);
        }
    }

    public void setImgBtnDrawable(int i3, int i16) {
        boolean z16;
        View h16 = h1(i3);
        if (QLog.isDevelopLevel()) {
            String str = this.f75049d;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("setImgBtnDrawable, id");
            sb5.append(com.tencent.av.ui.m.a(i3));
            sb5.append("], view[");
            if (h16 != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append("], resid[");
            sb5.append(i16);
            sb5.append("]");
            QLog.d(str, 2, sb5.toString());
        }
        if (h16 != null && (h16 instanceof ImageButton)) {
            ((ImageButton) h16).setImageDrawable(this.K0.getApplicationContext().getResources().getDrawable(i16));
        }
    }

    public void setNoVideoAndShareBtnMode() {
        rw.c cVar = this.N0;
        if (cVar != null) {
            cVar.g(m.e.f76014a);
            this.N0.g(m.e.f76030q);
            this.N0.g(m.e.f76016c);
            this.N0.g(m.e.f76024k);
            this.N0.g(m.e.f76029p);
        }
    }

    public void setOperationMenuViewOnClickListener(View.OnClickListener onClickListener) {
        this.I0 = onClickListener;
    }

    public void setPanelBottomMargin(int i3) {
        RelativeLayout relativeLayout = this.f75074q0;
        if (relativeLayout == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) relativeLayout.getLayoutParams();
        marginLayoutParams.bottomMargin = i3;
        this.f75074q0.setLayoutParams(marginLayoutParams);
    }

    public void setViewEnable(int i3, boolean z16) {
        if (QLog.isDevelopLevel()) {
            QLog.d(this.f75049d, 2, "setViewEnable, id" + com.tencent.av.ui.m.a(i3) + ", enable[" + z16 + "]");
        }
        View h16 = h1(i3);
        boolean y06 = y0(i3);
        if (h16 != null) {
            h16.setEnabled(z16);
        }
        if (h16 != null && y06) {
            setTopLayerImageBtnEnable((ImageButton) h16, z16);
        }
    }

    public void setViewVisibility(int i3, int i16) {
        boolean z16;
        View h16 = h1(i3);
        if (QLog.isDevelopLevel()) {
            String str = this.f75049d;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("setViewVisibility, id");
            sb5.append(com.tencent.av.ui.m.a(i3));
            sb5.append("], view[");
            if (h16 != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append("], visibility[");
            sb5.append(i16);
            sb5.append("]");
            QLog.d(str, 2, sb5.toString());
        }
        if (h16 != null) {
            if (x0(i3)) {
                if (i16 == 0) {
                    L0(i3);
                } else {
                    G0(h16);
                }
            }
            h16.setVisibility(i16);
        }
    }

    public void t(int i3) {
        int i16;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.a87);
        int i17 = this.f75052e;
        int i18 = m.a.f75990a;
        if (i17 != i18 && i17 != m.a.f75991b) {
            i16 = 0;
        } else {
            i16 = (displayMetrics.widthPixels * com.tencent.luggage.wxa.yf.x.CTRL_INDEX) / 750;
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.f75049d, 2, "adjustPanel, heightPixels[" + displayMetrics.heightPixels + "], widthPixels[" + displayMetrics.widthPixels + "], shadowHeight[" + dimensionPixelSize + "], videoHeight[" + i16 + "], mPanelType[" + this.f75052e + "]");
        }
        int i19 = this.f75052e;
        if (i19 == i18 || i19 == m.a.f75993d || i19 == m.a.f75991b) {
            int max = Math.max(0, (i3 - (BaseAIOUtils.f(64.0f, getResources()) * 4)) / 5);
            r(findViewById(m.l.f76058d), max);
            r(this.N, max);
            r(this.f75073p0, max);
            View findViewById = findViewById(R.id.z6_);
            if (findViewById != null) {
                r(findViewById, max);
            } else {
                r(this.f75067k0, max);
            }
        }
    }

    public boolean u() {
        if (this.K0 == null) {
            return false;
        }
        if (t0()) {
            SessionInfo f16 = com.tencent.av.n.e().f();
            if (!this.J0 || f16.J == 3 || this.O0) {
                return false;
            }
            return true;
        }
        if (!this.J0 || com.tencent.av.r.h0().e0() == 3 || this.O0) {
            return false;
        }
        return true;
    }

    public void v(boolean z16, int i3) {
        FrameLayout frameLayout = this.f75053e0;
        if (frameLayout != null && z16) {
            frameLayout.setVisibility(0);
            Button button = this.f75056f0;
            if (button != null) {
                button.setClickable(false);
                this.f75056f0.setEnabled(false);
            }
        }
    }

    public boolean v0(int i3) {
        if (i3 == this.M0) {
            return true;
        }
        return false;
    }

    public void w(boolean z16) {
        Button button;
        RelativeLayout relativeLayout = this.f75074q0;
        if (relativeLayout != null && (button = this.P) != null && this.f75078u0 != null && this.f75080w0 != null && this.f75079v0 != null) {
            if (z16) {
                relativeLayout.setVisibility(4);
                this.P.setVisibility(0);
                this.f75078u0.setVisibility(0);
                setBtnTopDrawable(this.f75080w0, R.drawable.k9i);
                this.f75080w0.setEnabled(this.f75073p0.isEnabled());
                this.f75080w0.setSelected(this.f75073p0.isSelected());
                this.f75080w0.setPressed(this.f75073p0.isPressed());
                this.f75079v0.setEnabled(this.f75067k0.isEnabled());
                this.f75079v0.setSelected(this.f75067k0.isSelected());
                this.f75079v0.setPressed(this.f75067k0.isPressed());
                N0(TraeHelper.I());
                setBtnTopDrawableWithForeGround(this.f75079v0, R.drawable.k9g, this.f75072o0);
                this.f75067k0.setCompoundDrawables(null, null, null, null);
                this.f75050d0.setVisibility(8);
                return;
            }
            button.setVisibility(4);
            this.f75078u0.setVisibility(4);
            this.f75074q0.setVisibility(0);
            this.f75073p0.setEnabled(this.f75080w0.isEnabled());
            this.f75073p0.setSelected(this.f75080w0.isSelected());
            this.f75073p0.setPressed(this.f75080w0.isPressed());
            this.f75067k0.setEnabled(this.f75079v0.isEnabled());
            this.f75067k0.setSelected(this.f75079v0.isSelected());
            this.f75067k0.setPressed(this.f75079v0.isPressed());
            M0(TraeHelper.I());
            if (this.Y0 != null) {
                setBtnTopDrawable(this.f75067k0, R.drawable.k9g);
            } else {
                setBtnTopDrawableWithForeGround(this.f75067k0, R.drawable.k9g, this.f75072o0);
            }
            this.f75079v0.setCompoundDrawables(null, null, null, null);
        }
    }

    public boolean x(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(this.f75049d, 2, "checkView, id" + com.tencent.av.ui.m.a(i3));
        }
        if (h1(i3) == null) {
            return true;
        }
        return false;
    }

    public void z() {
        RedTouch redTouch;
        if (!com.tencent.av.utils.af.x() && (redTouch = this.S) != null) {
            yv.a.b(this.K0, redTouch, 11);
        }
        y();
    }

    public QavPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f75052e = 0;
        this.f75055f = null;
        this.f75060h = null;
        this.f75063i = false;
        this.f75069m = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.f75043a0 = null;
        this.f75045b0 = null;
        this.f75047c0 = null;
        this.f75050d0 = null;
        this.f75053e0 = null;
        this.f75056f0 = null;
        this.f75058g0 = null;
        this.f75061h0 = null;
        this.f75064i0 = null;
        this.f75066j0 = null;
        this.f75067k0 = null;
        this.f75068l0 = 0;
        this.f75071n0 = false;
        this.f75072o0 = null;
        this.f75073p0 = null;
        this.f75074q0 = null;
        this.f75075r0 = null;
        this.f75076s0 = null;
        this.f75077t0 = null;
        this.f75078u0 = null;
        this.f75079v0 = null;
        this.f75080w0 = null;
        this.f75081x0 = null;
        this.f75082y0 = null;
        this.f75083z0 = null;
        this.A0 = null;
        this.B0 = null;
        this.C0 = null;
        this.D0 = null;
        this.E0 = null;
        this.F0 = null;
        this.G0 = null;
        this.H0 = null;
        this.I0 = null;
        this.J0 = false;
        this.L0 = new NormalMenuView[7];
        this.M0 = -1;
        this.N0 = null;
        this.O0 = false;
        this.W0 = false;
        this.f75044a1 = 256;
        this.f75046b1 = 257;
        this.f75048c1 = 258;
        this.f75051d1 = 259;
        this.f75054e1 = 260;
        this.f75057f1 = 261;
        this.f75059g1 = 1;
        this.f75062h1 = new l(Looper.getMainLooper());
        this.f75049d = "QavPanel_" + com.tencent.av.utils.e.d();
    }

    public QavPanel(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f75052e = 0;
        this.f75055f = null;
        this.f75060h = null;
        this.f75063i = false;
        this.f75069m = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.f75043a0 = null;
        this.f75045b0 = null;
        this.f75047c0 = null;
        this.f75050d0 = null;
        this.f75053e0 = null;
        this.f75056f0 = null;
        this.f75058g0 = null;
        this.f75061h0 = null;
        this.f75064i0 = null;
        this.f75066j0 = null;
        this.f75067k0 = null;
        this.f75068l0 = 0;
        this.f75071n0 = false;
        this.f75072o0 = null;
        this.f75073p0 = null;
        this.f75074q0 = null;
        this.f75075r0 = null;
        this.f75076s0 = null;
        this.f75077t0 = null;
        this.f75078u0 = null;
        this.f75079v0 = null;
        this.f75080w0 = null;
        this.f75081x0 = null;
        this.f75082y0 = null;
        this.f75083z0 = null;
        this.A0 = null;
        this.B0 = null;
        this.C0 = null;
        this.D0 = null;
        this.E0 = null;
        this.F0 = null;
        this.G0 = null;
        this.H0 = null;
        this.I0 = null;
        this.J0 = false;
        this.L0 = new NormalMenuView[7];
        this.M0 = -1;
        this.N0 = null;
        this.O0 = false;
        this.W0 = false;
        this.f75044a1 = 256;
        this.f75046b1 = 257;
        this.f75048c1 = 258;
        this.f75051d1 = 259;
        this.f75054e1 = 260;
        this.f75057f1 = 261;
        this.f75059g1 = 1;
        this.f75062h1 = new l(Looper.getMainLooper());
        this.f75049d = "QavPanel_" + com.tencent.av.utils.e.d();
    }
}
