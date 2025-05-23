package com.qzone.reborn.intimate.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieDrawable;
import com.qzone.reborn.intimate.event.QZoneIntimateNewBadgeFullAnimEvent;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.ArrayUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QZoneConfigHelper;
import java.util.ArrayList;
import java.util.Iterator;
import pj.j;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneIntimateNewBadgeFullAnimView extends QZoneBaseWidgetView<ArrayList<ij.a>> implements View.OnClickListener {
    private ImageView C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private QUIButton G;
    private ImageView H;
    private ArrayList<ij.a> I;
    private ArrayList<String> J;
    private ArrayList<String> K;
    private ArrayList<String> L;
    private int M;
    private boolean N;
    private String P;
    private String Q;
    private RotateAnimation R;
    private qj.e S;
    private final Runnable T;
    private final Runnable U;
    private final Runnable V;
    private final Runnable W;

    /* renamed from: a0, reason: collision with root package name */
    private final Runnable f57689a0;

    /* renamed from: b0, reason: collision with root package name */
    private final Runnable f57690b0;

    /* renamed from: c0, reason: collision with root package name */
    private final Runnable f57691c0;

    /* renamed from: e, reason: collision with root package name */
    private final pj.j f57692e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f57693f;

    /* renamed from: h, reason: collision with root package name */
    private LottieDrawable f57694h;

    /* renamed from: i, reason: collision with root package name */
    private ViewGroup f57695i;

    /* renamed from: m, reason: collision with root package name */
    private LinearLayout f57696m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QLog.d("QZoneIntimateNewBadgeFullAnimView", 1, "[endShowBadgeAnim] show index=" + QZoneIntimateNewBadgeFullAnimView.this.M);
            QZoneIntimateNewBadgeFullAnimView.this.f57696m.setVisibility(0);
            mk.b.n(QZoneIntimateNewBadgeFullAnimView.this.G, QZoneIntimateNewBadgeFullAnimView.this.H);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QLog.d("QZoneIntimateNewBadgeFullAnimView", 1, "[startShowBadgeAnim]");
            if (QZoneIntimateNewBadgeFullAnimView.this.C != null) {
                QZoneIntimateNewBadgeFullAnimView.this.C.setTranslationY(0.0f);
                QZoneIntimateNewBadgeFullAnimView.this.C.setVisibility(0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QLog.d("QZoneIntimateNewBadgeFullAnimView", 1, "[endHaloScaleView]");
            if (QZoneIntimateNewBadgeFullAnimView.this.D != null) {
                QZoneIntimateNewBadgeFullAnimView.this.D.setAlpha(1.0f);
            }
            QZoneIntimateNewBadgeFullAnimView qZoneIntimateNewBadgeFullAnimView = QZoneIntimateNewBadgeFullAnimView.this;
            qZoneIntimateNewBadgeFullAnimView.R = mk.b.k(qZoneIntimateNewBadgeFullAnimView.D);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QLog.d("QZoneIntimateNewBadgeFullAnimView", 1, "[startHaloScaleView]");
            if (QZoneIntimateNewBadgeFullAnimView.this.D != null) {
                QZoneIntimateNewBadgeFullAnimView.this.D.setVisibility(0);
                QZoneIntimateNewBadgeFullAnimView.this.D.setAlpha(1.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f57701d;

        c(boolean z16) {
            this.f57701d = z16;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QLog.d("QZoneIntimateNewBadgeFullAnimView", 1, "[startHaloHideAndBadgeContentHideAnim], show index is " + QZoneIntimateNewBadgeFullAnimView.this.M);
            QZoneIntimateNewBadgeFullAnimView.this.S0(true);
            if (this.f57701d) {
                if (QZoneIntimateNewBadgeFullAnimView.this.D != null) {
                    QZoneIntimateNewBadgeFullAnimView.this.D.setVisibility(8);
                }
                if (QZoneIntimateNewBadgeFullAnimView.this.E != null) {
                    QZoneIntimateNewBadgeFullAnimView.this.E.setVisibility(8);
                }
                if (QZoneIntimateNewBadgeFullAnimView.this.F != null) {
                    QZoneIntimateNewBadgeFullAnimView.this.F.setVisibility(8);
                    return;
                }
                return;
            }
            QLog.d("QZoneIntimateNewBadgeFullAnimView", 1, "isHideContentTv is false");
            QZoneIntimateNewBadgeFullAnimView.this.Q0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QLog.d("QZoneIntimateNewBadgeFullAnimView", 1, "[startHaloHideAndBadgeContentHideAnim]");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QLog.d("QZoneIntimateNewBadgeFullAnimView", 1, "[endBadgeTranslationYDownAnim], show index is " + QZoneIntimateNewBadgeFullAnimView.this.M);
            QZoneIntimateNewBadgeFullAnimView.this.a1();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QLog.d("QZoneIntimateNewBadgeFullAnimView", 1, "[startBadgeTranslationYDownAnim]");
            mk.b.m(QZoneIntimateNewBadgeFullAnimView.this.G, QZoneIntimateNewBadgeFullAnimView.this.H);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QLog.d("QZoneIntimateNewBadgeFullAnimView", 1, "[endLottieAnim]");
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QLog.d("QZoneIntimateNewBadgeFullAnimView", 1, "[startLottieAnim]");
        }
    }

    public QZoneIntimateNewBadgeFullAnimView(Context context) {
        super(context);
        this.f57692e = new pj.j();
        this.M = 0;
        this.N = false;
        this.T = new Runnable() { // from class: com.qzone.reborn.intimate.widget.QZoneIntimateNewBadgeFullAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QZoneIntimateNewBadgeFullAnimView.this.E != null) {
                    QZoneIntimateNewBadgeFullAnimView.this.f1();
                    QZoneIntimateNewBadgeFullAnimView.this.E.setVisibility(0);
                    QZoneIntimateNewBadgeFullAnimView.this.E.setAlpha(1.0f);
                }
            }
        };
        this.U = new Runnable() { // from class: com.qzone.reborn.intimate.widget.QZoneIntimateNewBadgeFullAnimView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QZoneIntimateNewBadgeFullAnimView.this.F != null) {
                    QZoneIntimateNewBadgeFullAnimView.this.e1();
                    QZoneIntimateNewBadgeFullAnimView.this.F.setVisibility(0);
                    QZoneIntimateNewBadgeFullAnimView.this.F.setAlpha(1.0f);
                }
            }
        };
        this.V = new Runnable() { // from class: com.qzone.reborn.intimate.widget.s
            @Override // java.lang.Runnable
            public final void run() {
                QZoneIntimateNewBadgeFullAnimView.this.Z0();
            }
        };
        this.W = new Runnable() { // from class: com.qzone.reborn.intimate.widget.t
            @Override // java.lang.Runnable
            public final void run() {
                QZoneIntimateNewBadgeFullAnimView.this.b1();
            }
        };
        this.f57689a0 = new Runnable() { // from class: com.qzone.reborn.intimate.widget.u
            @Override // java.lang.Runnable
            public final void run() {
                QZoneIntimateNewBadgeFullAnimView.this.X0();
            }
        };
        this.f57690b0 = new Runnable() { // from class: com.qzone.reborn.intimate.widget.v
            @Override // java.lang.Runnable
            public final void run() {
                QZoneIntimateNewBadgeFullAnimView.this.V0();
            }
        };
        this.f57691c0 = new Runnable() { // from class: com.qzone.reborn.intimate.widget.w
            @Override // java.lang.Runnable
            public final void run() {
                QZoneIntimateNewBadgeFullAnimView.this.M0();
            }
        };
    }

    private void H0() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f57696m.getLayoutParams();
        if (pl.a.f426446a.B(getContext())) {
            layoutParams.bottomMargin = ImmersiveUtils.dpToPx(10.0f);
        } else {
            layoutParams.bottomMargin = ImmersiveUtils.dpToPx(80.0f);
        }
        this.f57696m.setLayoutParams(layoutParams);
    }

    private void L0() {
        if (com.qzone.reborn.util.e.a("QZoneIntimateNewBadgeFullAnimView")) {
            return;
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            com.qzone.reborn.util.o.f59556a.c(R.string.w9c, 1);
            return;
        }
        qj.e eVar = (qj.e) getIocInterface(qj.e.class);
        if (eVar == null) {
            QLog.e("QZoneIntimateNewBadgeFullAnimView", 1, "[doShareToQQunChecked] ioc:" + eVar);
            return;
        }
        S0(false);
        eVar.R2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0() {
        fo.c.n(this.G, "em_qz_share_paster");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0() {
        mk.b.h(this.E, this.F, this.G, this.H);
        RFWThreadManager.getInstance().runOnUiThread(this.T, 20L);
        RFWThreadManager.getInstance().runOnUiThread(this.U, 40L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0(boolean z16) {
        this.G.setEnabled(z16);
        if (z16) {
            this.G.setText(com.qzone.util.l.a(R.string.v8n));
        } else {
            this.G.setText(com.qzone.util.l.a(R.string.v8l));
        }
    }

    private void T0() {
        String c16 = this.f57692e.c(this.Q);
        if (!TextUtils.isEmpty(c16)) {
            com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setUrl(c16).setTargetView(this.D).setFailedDrawableId(R.drawable.trans).setLoadingDrawableId(R.drawable.trans));
        } else {
            QLog.e("QZoneIntimateNewBadgeFullAnimView", 1, "[setImgRes] haloLocalPath is null");
        }
        if (ArrayUtils.isOutOfArrayIndex(this.M, this.J)) {
            QLog.e("QZoneIntimateNewBadgeFullAnimView", 1, "show anim index is " + this.M + ", out of index");
            return;
        }
        String c17 = this.f57692e.c(this.J.get(this.M));
        if (!TextUtils.isEmpty(c17)) {
            com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setUrl(c17).setTargetView(this.C).setFailedDrawableId(R.drawable.trans).setLoadingDrawableId(R.drawable.trans));
        } else {
            QLog.e("QZoneIntimateNewBadgeFullAnimView", 1, "[setImgRes] badgeLocalPath is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0() {
        if (this.N) {
            QLog.e("QZoneIntimateNewBadgeFullAnimView", 1, "[startAnim] anim is running");
            return;
        }
        if (ArrayUtils.isOutOfArrayIndex(this.M, this.J)) {
            return;
        }
        this.N = true;
        setVisibility(0);
        T0();
        d1();
        this.M++;
        QLog.d("QZoneIntimateNewBadgeFullAnimView", 1, "[startAnim] show index = " + this.M);
        if (this.M == 1) {
            RFWThreadManager.getInstance().runOnUiThread(this.T, 20L);
            RFWThreadManager.getInstance().runOnUiThread(this.U, 40L);
        }
        RFWThreadManager.getInstance().runOnUiThread(this.V, 100L);
        RFWThreadManager.getInstance().runOnUiThread(this.W, 160L);
        RFWThreadManager.getInstance().runOnUiThread(this.f57689a0, 260L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0() {
        mk.b.i(this.C, this.E, new d());
    }

    private void W0(boolean z16) {
        mk.b.j(this.D, this.E, this.F, new c(z16));
    }

    private void c1() {
        LottieDrawable lottieDrawable = this.f57694h;
        if (lottieDrawable == null || !lottieDrawable.isRunning()) {
            return;
        }
        this.f57694h.stop();
        this.f57694h.removeAllAnimatorListeners();
    }

    private void d1() {
        String str;
        String str2;
        if (!ArrayUtils.isOutOfArrayIndex(this.M, this.I)) {
            str = this.I.get(this.M).getBadgeName();
            str2 = this.I.get(this.M).getBadgeUrl();
            if (TextUtils.isEmpty(str)) {
                str = "\u4eb2\u5bc6\u8d34\u7eb8";
            }
        } else {
            str = "";
            str2 = "";
        }
        QLog.i("QZoneIntimateNewBadgeFullAnimView", 1, "[updateArkShareInfo] showAnimIndex=" + this.M + ",latestMedalName:" + str + ",latestMedalUrl:" + str2);
        qj.e eVar = (qj.e) getIocInterface(qj.e.class);
        this.S = eVar;
        if (eVar != null) {
            eVar.p0(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1() {
        int i3 = this.M - 1;
        if (!ArrayUtils.isOutOfArrayIndex(i3, this.K) && !ArrayUtils.isOutOfArrayIndex(i3, this.L)) {
            this.F.setText(this.L.get(i3));
            return;
        }
        QLog.i("QZoneIntimateNewBadgeFullAnimView", 1, "show anim index is " + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f1() {
        int i3 = this.M - 1;
        if (!ArrayUtils.isOutOfArrayIndex(i3, this.K) && !ArrayUtils.isOutOfArrayIndex(i3, this.L)) {
            this.E.setText(this.K.get(i3));
            return;
        }
        QLog.i("QZoneIntimateNewBadgeFullAnimView", 1, "show anim index is " + i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public void bindData(ArrayList<ij.a> arrayList, int i3) {
        mk.b bVar = mk.b.f416873a;
        ArrayList<ij.a> a16 = bVar.a(arrayList);
        if (ArrayUtils.isOutOfArrayIndex(0, a16)) {
            setVisibility(8);
            return;
        }
        this.M = 0;
        this.N = false;
        this.I = a16;
        S0(true);
        this.J = bVar.e(a16);
        this.K = bVar.g(a16);
        this.L = bVar.f(a16);
        this.Q = QZoneConfigHelper.y0();
        this.P = QZoneConfigHelper.z0();
        ArrayList arrayList2 = new ArrayList(this.J);
        arrayList2.add(this.Q);
        arrayList2.add(this.P);
        this.f57692e.e(arrayList2, new j.a() { // from class: com.qzone.reborn.intimate.widget.QZoneIntimateNewBadgeFullAnimView.3
            @Override // pj.j.a
            public void onLoadError() {
                QLog.d("QZoneIntimateNewBadgeFullAnimView", 1, "[bindData] res load error");
                QZoneIntimateNewBadgeFullAnimView.this.K0(false);
            }

            @Override // pj.j.a
            public void onLoadSucceed() {
                QLog.d("QZoneIntimateNewBadgeFullAnimView", 1, "[bindData] res load success");
                RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.intimate.widget.QZoneIntimateNewBadgeFullAnimView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QZoneIntimateNewBadgeFullAnimView.this.U0();
                        QZoneIntimateNewBadgeFullAnimView.this.P0();
                    }
                });
            }
        });
    }

    public void O0(boolean z16) {
        RotateAnimation rotateAnimation = this.R;
        if (rotateAnimation != null && z16) {
            rotateAnimation.cancel();
        }
        c1();
        RFWThreadManager.getUIHandler().removeCallbacks(this.T);
        RFWThreadManager.getUIHandler().removeCallbacks(this.U);
        RFWThreadManager.getUIHandler().removeCallbacks(this.V);
        RFWThreadManager.getUIHandler().removeCallbacks(this.W);
        RFWThreadManager.getUIHandler().removeCallbacks(this.f57689a0);
        RFWThreadManager.getUIHandler().removeCallbacks(this.f57690b0);
        RFWThreadManager.getUIHandler().removeCallbacks(this.f57691c0);
    }

    public void X0() {
        this.D.setPivotX(this.f57695i.getWidth() / 2.0f);
        this.D.setPivotY(this.f57695i.getHeight() / 2.0f);
        mk.b.l(this.D, new b());
    }

    public void Z0() {
        String str = this.f57692e.c(this.P) + "confetti_frist.json";
        QLog.d("QZoneIntimateNewBadgeFullAnimView", 1, "[startLottie] lottieResUrl = " + this.P + ", lottiePath = " + str);
        if (TextUtils.isEmpty(this.P) || TextUtils.isEmpty(str)) {
            return;
        }
        LottieHelper.c(this.f57693f.getContext(), str, "", ScreenUtil.dip2px(this.f57693f.getWidth()), ScreenUtil.dip2px(this.f57693f.getHeight()), new LottieHelper.d() { // from class: com.qzone.reborn.intimate.widget.x
            @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
            public final void onLoad(LottieDrawable lottieDrawable) {
                QZoneIntimateNewBadgeFullAnimView.this.N0(lottieDrawable);
            }
        });
    }

    public void b1() {
        mk.b.o(this.C, new a());
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.ckb;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            switch (view.getId()) {
                case R.id.f19475s /* 1745223772 */:
                    RFWThreadManager.getInstance().runOnUiThread(this.f57690b0);
                    break;
                case R.id.f19485t /* 1745223773 */:
                    L0();
                    break;
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0(boolean z16) {
        ij.a aVar;
        if (ArrayUtils.isOutOfArrayIndex(0, this.I)) {
            QLog.e("QZoneIntimateNewBadgeFullAnimView", 1, "mBadgeAnimViewList is empty");
            return;
        }
        Iterator<ij.a> it = this.I.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                break;
            } else {
                aVar = it.next();
                if (aVar.g()) {
                    break;
                }
            }
        }
        if (aVar == null) {
            QLog.e("QZoneIntimateNewBadgeFullAnimView", 1, "[dispatchFullAnimEvent] medalDetail is null");
            return;
        }
        QLog.d("QZoneIntimateNewBadgeFullAnimView", 1, "[dispatchFullAnimEvent] hasDoneAnim = " + z16);
        SimpleEventBus.getInstance().dispatchEvent(new QZoneIntimateNewBadgeFullAnimEvent(z16, aVar.e(), aVar.getAlertMedalId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M0() {
        K0(true);
    }

    private void Y0() {
        this.N = false;
        O0(true);
        setVisibility(8);
        S0(true);
        if (this.M > 0) {
            RFWThreadManager.getInstance().runOnUiThread(this.f57691c0, 120L);
        }
        this.M = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1() {
        this.N = false;
        int i3 = this.M;
        if (i3 > 0 && i3 <= this.I.size() - 1) {
            W0(false);
            O0(false);
            U0();
            return;
        }
        Y0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N0(LottieDrawable lottieDrawable) {
        if (lottieDrawable == null || this.f57693f == null) {
            return;
        }
        c1();
        this.f57694h = lottieDrawable;
        this.f57693f.setImageDrawable(lottieDrawable);
        this.f57694h.addAnimatorListener(new e());
        this.f57694h.start();
    }

    public void I0(boolean z16) {
        if (z16) {
            RFWThreadManager.getInstance().runOnUiThread(this.f57690b0);
        } else {
            S0(true);
        }
    }

    private void initView() {
        this.f57693f = (ImageView) findViewById(R.id.klr);
        this.f57695i = (ViewGroup) findViewById(R.id.fen);
        this.C = (ImageView) findViewById(R.id.khm);
        this.E = (TextView) findViewById(R.id.f162951ni1);
        this.F = (TextView) findViewById(R.id.f162952ni2);
        this.f57696m = (LinearLayout) findViewById(R.id.mdt);
        this.G = (QUIButton) findViewById(R.id.f19485t);
        this.H = (ImageView) findViewById(R.id.f19475s);
        this.D = (ImageView) findViewById(R.id.kip);
        this.G.setOnClickListener(this);
        this.H.setOnClickListener(this);
        com.tencent.mobileqq.qzone.picload.c.a().m(this.H, getContext().getColor(R.color.qui_common_icon_allwhite_primary));
        H0();
    }

    public QZoneIntimateNewBadgeFullAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f57692e = new pj.j();
        this.M = 0;
        this.N = false;
        this.T = new Runnable() { // from class: com.qzone.reborn.intimate.widget.QZoneIntimateNewBadgeFullAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QZoneIntimateNewBadgeFullAnimView.this.E != null) {
                    QZoneIntimateNewBadgeFullAnimView.this.f1();
                    QZoneIntimateNewBadgeFullAnimView.this.E.setVisibility(0);
                    QZoneIntimateNewBadgeFullAnimView.this.E.setAlpha(1.0f);
                }
            }
        };
        this.U = new Runnable() { // from class: com.qzone.reborn.intimate.widget.QZoneIntimateNewBadgeFullAnimView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QZoneIntimateNewBadgeFullAnimView.this.F != null) {
                    QZoneIntimateNewBadgeFullAnimView.this.e1();
                    QZoneIntimateNewBadgeFullAnimView.this.F.setVisibility(0);
                    QZoneIntimateNewBadgeFullAnimView.this.F.setAlpha(1.0f);
                }
            }
        };
        this.V = new Runnable() { // from class: com.qzone.reborn.intimate.widget.s
            @Override // java.lang.Runnable
            public final void run() {
                QZoneIntimateNewBadgeFullAnimView.this.Z0();
            }
        };
        this.W = new Runnable() { // from class: com.qzone.reborn.intimate.widget.t
            @Override // java.lang.Runnable
            public final void run() {
                QZoneIntimateNewBadgeFullAnimView.this.b1();
            }
        };
        this.f57689a0 = new Runnable() { // from class: com.qzone.reborn.intimate.widget.u
            @Override // java.lang.Runnable
            public final void run() {
                QZoneIntimateNewBadgeFullAnimView.this.X0();
            }
        };
        this.f57690b0 = new Runnable() { // from class: com.qzone.reborn.intimate.widget.v
            @Override // java.lang.Runnable
            public final void run() {
                QZoneIntimateNewBadgeFullAnimView.this.V0();
            }
        };
        this.f57691c0 = new Runnable() { // from class: com.qzone.reborn.intimate.widget.w
            @Override // java.lang.Runnable
            public final void run() {
                QZoneIntimateNewBadgeFullAnimView.this.M0();
            }
        };
        initView();
    }

    public QZoneIntimateNewBadgeFullAnimView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f57692e = new pj.j();
        this.M = 0;
        this.N = false;
        this.T = new Runnable() { // from class: com.qzone.reborn.intimate.widget.QZoneIntimateNewBadgeFullAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QZoneIntimateNewBadgeFullAnimView.this.E != null) {
                    QZoneIntimateNewBadgeFullAnimView.this.f1();
                    QZoneIntimateNewBadgeFullAnimView.this.E.setVisibility(0);
                    QZoneIntimateNewBadgeFullAnimView.this.E.setAlpha(1.0f);
                }
            }
        };
        this.U = new Runnable() { // from class: com.qzone.reborn.intimate.widget.QZoneIntimateNewBadgeFullAnimView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QZoneIntimateNewBadgeFullAnimView.this.F != null) {
                    QZoneIntimateNewBadgeFullAnimView.this.e1();
                    QZoneIntimateNewBadgeFullAnimView.this.F.setVisibility(0);
                    QZoneIntimateNewBadgeFullAnimView.this.F.setAlpha(1.0f);
                }
            }
        };
        this.V = new Runnable() { // from class: com.qzone.reborn.intimate.widget.s
            @Override // java.lang.Runnable
            public final void run() {
                QZoneIntimateNewBadgeFullAnimView.this.Z0();
            }
        };
        this.W = new Runnable() { // from class: com.qzone.reborn.intimate.widget.t
            @Override // java.lang.Runnable
            public final void run() {
                QZoneIntimateNewBadgeFullAnimView.this.b1();
            }
        };
        this.f57689a0 = new Runnable() { // from class: com.qzone.reborn.intimate.widget.u
            @Override // java.lang.Runnable
            public final void run() {
                QZoneIntimateNewBadgeFullAnimView.this.X0();
            }
        };
        this.f57690b0 = new Runnable() { // from class: com.qzone.reborn.intimate.widget.v
            @Override // java.lang.Runnable
            public final void run() {
                QZoneIntimateNewBadgeFullAnimView.this.V0();
            }
        };
        this.f57691c0 = new Runnable() { // from class: com.qzone.reborn.intimate.widget.w
            @Override // java.lang.Runnable
            public final void run() {
                QZoneIntimateNewBadgeFullAnimView.this.M0();
            }
        };
        initView();
    }
}
