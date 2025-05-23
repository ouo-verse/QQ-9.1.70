package com.tencent.mobileqq.ar.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionResDownload;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.model.CameraProxy;
import com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl;
import com.tencent.mobileqq.ar.model.c;
import com.tencent.mobileqq.ar.view.b;
import com.tencent.mobileqq.ar.view.f;
import com.tencent.mobileqq.olympic.activity.PromotionEntry;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.olympic.activity.c;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IScanABTestApi;
import com.tencent.mobileqq.qrscan.api.IScanDaTongApi;
import com.tencent.mobileqq.qrscan.api.IScannerAlbumApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.ab;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.os.MqqHandler;
import z81.a;

/* loaded from: classes11.dex */
public class ScanEntryProviderContainerView extends FrameLayout implements c.InterfaceC7406c, com.tencent.mobileqq.ar.view.d, PromotionEntry.c, c.e {
    View C;
    public LinearLayout D;
    TextView E;
    private LinearLayout F;
    private LinearLayout G;
    private boolean H;
    private com.tencent.mobileqq.ar.view.f I;
    private HashMap<Integer, ScanEntryProviderView> J;
    private ScanEntryProviderView K;
    private int L;
    private com.tencent.mobileqq.ar.model.c M;
    private ARCommonConfigInfo N;
    private com.tencent.mobileqq.ar.model.d P;
    private Rect Q;
    private boolean R;
    private Handler S;
    private GestureDetector T;
    private boolean U;
    private boolean V;
    private a.b W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f198731a0;

    /* renamed from: b0, reason: collision with root package name */
    private PromotionEntry f198732b0;

    /* renamed from: c0, reason: collision with root package name */
    private com.tencent.mobileqq.olympic.activity.c f198733c0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f198734d;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f198735d0;

    /* renamed from: e, reason: collision with root package name */
    protected Context f198736e;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f198737e0;

    /* renamed from: f, reason: collision with root package name */
    protected AppInterface f198738f;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f198739f0;

    /* renamed from: g0, reason: collision with root package name */
    private long f198740g0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f198741h;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f198742h0;

    /* renamed from: i, reason: collision with root package name */
    View f198743i;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f198744i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f198745j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f198746k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f198747l0;

    /* renamed from: m, reason: collision with root package name */
    FrameLayout f198748m;

    /* renamed from: m0, reason: collision with root package name */
    private int f198749m0;

    /* renamed from: n0, reason: collision with root package name */
    private final Runnable f198750n0;

    /* renamed from: o0, reason: collision with root package name */
    private final Runnable f198751o0;

    /* renamed from: p0, reason: collision with root package name */
    private com.tencent.mobileqq.ar.view.b f198752p0;

    /* renamed from: q0, reason: collision with root package name */
    private View.OnTouchListener f198753q0;

    /* renamed from: r0, reason: collision with root package name */
    private final View.OnClickListener f198754r0;

    /* renamed from: s0, reason: collision with root package name */
    private i f198755s0;

    /* renamed from: t0, reason: collision with root package name */
    private PromotionConfigInfo.a f198756t0;

    /* renamed from: u0, reason: collision with root package name */
    private LinearLayout f198757u0;

    /* renamed from: v0, reason: collision with root package name */
    private TextView f198758v0;

    /* renamed from: w0, reason: collision with root package name */
    private TextView f198759w0;

    /* renamed from: x0, reason: collision with root package name */
    private TextView f198760x0;

    /* renamed from: com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView$2, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass2 implements View.OnTouchListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (QLog.isColorLevel()) {
                QLog.d("ScanEntryProviderContainerView", 2, String.format("dispatchTouchEvent onTabClickListener", new Object[0]));
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - ScanEntryProviderContainerView.this.f198740g0 > 1000) {
                ScanEntryProviderContainerView.this.f198740g0 = currentTimeMillis;
                if (motionEvent.getAction() == 0) {
                    final Integer num = (Integer) view.getTag();
                    ScanEntryProviderContainerView.this.f198752p0.f(num.intValue(), new b.InterfaceC7409b() { // from class: com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView.2.1
                        @Override // com.tencent.mobileqq.ar.view.b.InterfaceC7409b
                        public void onAnimationEnd() {
                            if (ScanEntryProviderContainerView.this.S != null) {
                                ScanEntryProviderContainerView.this.S.post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView.2.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Bundle bundle = new Bundle();
                                        bundle.putInt("fromSource", 1);
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        ScanEntryProviderContainerView.this.j0(num.intValue(), bundle);
                                    }
                                });
                            }
                        }
                    });
                    if (num.intValue() == 3) {
                        ReportController.o(null, "dc00898", "", "", "0X800A9CE", "0X800A9CE", 0, 0, "", "0", "0", "");
                    }
                }
                return false;
            }
            QLog.i("ScanEntryProviderContainerView", 1, "avoid user fast click");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ScanEntryProviderContainerView.this.f198734d = false;
        }
    }

    /* loaded from: classes11.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ScanEntryProviderContainerView.this.j0(((Integer) view.getTag()).intValue(), new Bundle());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ScanEntryProviderContainerView.this.S();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!FastClickUtils.isFastDoubleClick("ScanEntryProviderContainerView", 500L)) {
                ScanEntryProviderContainerView.this.h0();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes11.dex */
    class f implements i {
        f() {
        }

        @Override // com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView.i
        public void a(int i3) {
            if (ScanEntryProviderContainerView.this.M != null) {
                ScanEntryProviderContainerView.this.M.v(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class h extends GestureDetector.SimpleOnGestureListener {
        h() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if ((ScanEntryProviderContainerView.this.K instanceof QRScanEntryView) && CameraProxy.v().B() && !((com.tencent.mobileqq.ar.model.b) ScanEntryProviderContainerView.this.K.f198782i).V()) {
                MqqHandler uIHandler = ThreadManager.getUIHandler();
                uIHandler.removeCallbacks(ScanEntryProviderContainerView.this.f198750n0);
                uIHandler.post(ScanEntryProviderContainerView.this.f198751o0);
                return true;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            LinearLayout linearLayout = ScanEntryProviderContainerView.this.D;
            if (linearLayout != null && linearLayout.getVisibility() == 0) {
                ScanEntryProviderContainerView.this.D.setVisibility(8);
                return true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            int i3 = 0;
            if (ScanEntryProviderContainerView.this.f198741h && !ScanEntryProviderContainerView.this.f198745j0 && ((!(ScanEntryProviderContainerView.this.K instanceof QRScanEntryView) || !((com.tencent.mobileqq.ar.model.b) ScanEntryProviderContainerView.this.K.f198782i).V()) && !ScanEntryProviderContainerView.this.f198734d)) {
                if (motionEvent.getRawX() - motionEvent2.getRawX() > 50.0f) {
                    int i16 = ScanEntryProviderContainerView.this.L + 1;
                    if (i16 > 2) {
                        i16 = 2;
                    }
                    ScanEntryProviderContainerView.this.j0(ScanEntryProviderContainerView.this.I.d(i16).f198818a, new Bundle());
                    return true;
                }
                if (motionEvent.getRawX() - motionEvent2.getRawX() < -50.0f) {
                    int i17 = ScanEntryProviderContainerView.this.L - 1;
                    if (i17 >= 0) {
                        i3 = i17;
                    }
                    ScanEntryProviderContainerView.this.j0(ScanEntryProviderContainerView.this.I.d(i3).f198818a, new Bundle());
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if ((ScanEntryProviderContainerView.this.K instanceof QRScanEntryView) && CameraProxy.v().B() && !((com.tencent.mobileqq.ar.model.b) ScanEntryProviderContainerView.this.K.f198782i).V()) {
                ScanEntryProviderContainerView.this.f198747l0 = (int) motionEvent.getRawX();
                ScanEntryProviderContainerView.this.f198749m0 = (int) motionEvent.getRawY();
                ThreadManager.getUIHandler().post(ScanEntryProviderContainerView.this.f198750n0);
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes11.dex */
    public interface i {
        void a(int i3);
    }

    public ScanEntryProviderContainerView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(int i3) {
        View view = this.C;
        if (view != null) {
            float f16 = i3;
            if (view.getAlpha() != f16) {
                View view2 = this.C;
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, com.tencent.luggage.wxa.c8.c.f123400v, view2.getAlpha(), f16);
                ofFloat.setDuration(300L);
                ofFloat.addListener(new g(i3));
                ofFloat.start();
            }
        }
    }

    private void N(int i3) {
        R(i3).setTextColor(Color.parseColor("#0099FF"));
        int x16 = (int) this.f198757u0.getX();
        this.f198757u0.performHapticFeedback(0, 2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f198757u0, HippyTKDListViewAdapter.X, x16, ((z81.c.f452158a / 2) + x16) - (((r0.getRight() + r0.getLeft()) / 2) + x16));
        boolean z16 = this.f198741h;
        if (z16 && i3 == 2) {
            i0(this.F, ofFloat);
            i0(this.G, ofFloat);
        } else if (z16 && i3 == 1) {
            this.F.setVisibility(8);
            this.G.setVisibility(8);
        } else if (z16) {
            this.F.setVisibility(8);
            i0(this.G, ofFloat);
        }
        ofFloat.addListener(new a());
        ofFloat.setDuration(160L);
        ofFloat.start();
        this.f198734d = true;
    }

    private TextView R(int i3) {
        if (i3 == 2) {
            return this.f198759w0;
        }
        if (i3 == 1) {
            return this.f198758v0;
        }
        return this.f198760x0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        ScanTorchActivity scanTorchActivity = (ScanTorchActivity) this.f198736e;
        String currentAccountUin = this.f198738f.getCurrentAccountUin();
        String f16 = ac.f(this.f198738f, currentAccountUin);
        Intent intent = new Intent(scanTorchActivity, (Class<?>) QRDisplayActivity.class);
        intent.putExtra("from", "ScannerActivity");
        intent.putExtra("my_qrcode_pg_source", "1");
        intent.putExtra("title", scanTorchActivity.getString(R.string.g2w));
        intent.putExtra("nick", f16);
        intent.putExtra("uin", currentAccountUin);
        intent.putExtra("type", 1);
        com.tencent.biz.qrcode.util.f.c(intent, scanTorchActivity);
    }

    private void U() {
        View view = this.C;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void V(View view) {
        this.T = new GestureDetector(getContext(), new h());
        this.f198743i = view;
        this.f198748m = (FrameLayout) view.findViewById(R.id.igz);
        this.C = view.findViewById(R.id.ack);
        this.D = (LinearLayout) view.findViewById(R.id.f79614_9);
        this.E = (TextView) view.findViewById(R.id.f79604_8);
        this.I = new com.tencent.mobileqq.ar.view.f(1);
        this.S = new Handler();
    }

    private void W() {
        if (this.H && this.f198741h) {
            TextView R = R(this.I.d(this.L).f198818a);
            R.setTextColor(Color.parseColor("#0099FF"));
            int left = ((R.getLeft() + R.getRight()) / 2) + this.f198757u0.getLeft();
            int left2 = (this.f198757u0.getLeft() + (z81.c.f452158a / 2)) - left;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f198757u0.getLayoutParams();
            layoutParams.removeRule(14);
            layoutParams.leftMargin = left2;
            this.f198757u0.setLayoutParams(layoutParams);
            if ((this.f198757u0.getRight() + (z81.c.f452158a / 2)) - left > this.G.getLeft()) {
                ((RelativeLayout.LayoutParams) this.G.getLayoutParams()).rightMargin = ViewUtils.dip2px(4.0f);
            }
            this.H = false;
        }
    }

    private void X() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.gvz, (ViewGroup) null);
        addView(inflate);
        V(inflate);
        this.f198757u0 = (LinearLayout) inflate.findViewById(R.id.t_8);
        this.F = (LinearLayout) inflate.findViewById(R.id.zlu);
        ((IScanDaTongApi) QRoute.api(IScanDaTongApi.class)).setMyQrCodeInfo(this.F, IScanDaTongApi.PAGE_ID_QR, true);
        this.F.setOnClickListener(new d());
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.gallery);
        this.G = linearLayout;
        linearLayout.setOnClickListener(new e());
        this.f198758v0 = (TextView) inflate.findViewById(R.id.f916555r);
        this.f198759w0 = (TextView) inflate.findViewById(R.id.f9180566);
        this.f198760x0 = (TextView) inflate.findViewById(R.id.f9176562);
        if (ab.a()) {
            AccessibilityUtil.c(this.F, HardCodeUtil.qqStr(R.string.g2w), Button.class.getName());
            AccessibilityUtil.c(this.G, HardCodeUtil.qqStr(R.string.ree), Button.class.getName());
        }
    }

    private void Y() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.arb, (ViewGroup) null);
        addView(inflate);
        V(inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Z() {
        CameraProxy.v().o();
    }

    private void g0(a.b bVar) {
        QLog.d("ScanEntryProviderContainerView", 2, "preparePromotionResource");
        this.W = bVar;
        if (com.tencent.mobileqq.ar.ARPromotionMgr.c.a() && this.U) {
            if (this.f198733c0 == null) {
                com.tencent.mobileqq.olympic.activity.c cVar = new com.tencent.mobileqq.olympic.activity.c((ScanTorchActivity) this.f198736e);
                this.f198733c0 = cVar;
                cVar.y(this);
                this.f198733c0.z(this.f198738f);
            }
            a.b bVar2 = this.W;
            String str = null;
            if (bVar2 instanceof a.C11663a) {
                String str2 = ((a.C11663a) bVar2).f452143g;
                Q("doTransferDoor", null, false);
                str = str2;
            }
            this.f198733c0.m(this.f198738f, str);
            return;
        }
        if (this.W instanceof a.C11663a) {
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView.6
                @Override // java.lang.Runnable
                public void run() {
                    QQToast makeText = QQToast.makeText(ScanEntryProviderContainerView.this.f198736e, HardCodeUtil.qqStr(R.string.t3i), 1);
                    makeText.setAutoTextSize();
                    makeText.show();
                    ((Activity) ScanEntryProviderContainerView.this.f198736e).finish();
                }
            }, 1000L);
        }
        QLog.d("ScanEntryProviderContainerView", 2, "doTransferDoor device not support");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        Context context = this.f198736e;
        if (context instanceof Activity) {
            ((IScannerAlbumApi) QRoute.api(IScannerAlbumApi.class)).jumpToAlbumForResult((Activity) context);
        }
    }

    private void i0(View view, ObjectAnimator objectAnimator) {
        if (view.getVisibility() != 0) {
            objectAnimator.addListener(new b(view));
        }
    }

    private void l0(int i3) {
        boolean z16;
        int[] c16 = this.I.c();
        String[] b16 = this.I.b();
        for (int i16 = 0; i16 < c16.length; i16++) {
            View findViewById = findViewById(c16[i16]);
            if (findViewById != null) {
                String str = b16[i16];
                if (i16 == i3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                AccessibilityUtil.y(findViewById, str, z16);
            }
        }
    }

    public boolean O() {
        ScanEntryProviderView scanEntryProviderView = this.K;
        if (scanEntryProviderView != null) {
            return scanEntryProviderView.u();
        }
        return false;
    }

    public void P() {
        QLog.i("ScanEntryProviderContainerView", 1, "doOnWindowFocusFirstTimeVisiable");
        if (!this.V && this.U) {
            e(true);
        }
        W();
    }

    public void Q(String str, PromotionConfigInfo.a aVar, boolean z16) {
        QLog.d("ScanEntryProviderContainerView", 1, "enterTransferDoorMode[" + str + "], mIsTransferDoorMode[" + this.V + "], ready[" + z16 + "]");
        this.V = true;
        U();
    }

    public void T(String str) {
        ScanEntryProviderView scanEntryProviderView = this.K;
        if (scanEntryProviderView != null) {
            scanEntryProviderView.x(str);
        }
    }

    @Override // com.tencent.mobileqq.olympic.activity.PromotionEntry.c, com.tencent.mobileqq.olympic.activity.c.e
    public boolean a() {
        if (com.tencent.mobileqq.ar.ARPromotionMgr.c.a()) {
            if (this.W instanceof a.C11663a) {
                return true;
            }
            PromotionEntry promotionEntry = this.f198732b0;
            if (promotionEntry != null && promotionEntry.f255119c) {
                QLog.d("ScanEntryProviderContainerView", 1, "autoEnterTransferDoorMode, \u5df2\u7ecf\u70b9\u8fc7\u5165\u53e3");
                return true;
            }
            return false;
        }
        return false;
    }

    public void a0() {
        this.I.j(this.f198746k0);
        this.I.i();
        int[] c16 = this.I.c();
        String[] b16 = this.I.b();
        int e16 = this.I.e();
        for (int i3 = 0; i3 < c16.length; i3++) {
            f.a d16 = this.I.d(i3);
            View findViewById = findViewById(c16[i3]);
            int[] f16 = this.I.f(i3);
            if (f16 != null && d16 != null) {
                if (this.f198741h) {
                    findViewById.setOnClickListener(this.f198754r0);
                } else {
                    com.tencent.mobileqq.ar.view.a aVar = new com.tencent.mobileqq.ar.view.a(f16, (ImageView) findViewById, d16.f198818a == 2 ? e16 - 1 : 0);
                    findViewById.setOnTouchListener(this.f198753q0);
                    this.f198752p0.b(d16.f198818a, aVar);
                }
                findViewById.setVisibility(0);
                findViewById.setTag(Integer.valueOf(d16.f198818a));
                findViewById.setContentDescription(HardCodeUtil.qqStr(R.string.f213895rf) + b16[i3]);
            }
        }
    }

    @Override // com.tencent.mobileqq.olympic.activity.c.e
    public void b(boolean z16, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d("ScanEntryProviderContainerView", 2, "updatePromotionEntryVisiableInfo");
        }
        this.f198735d0 = true;
        this.f198737e0 = z16;
        this.f198739f0 = z17;
        this.S.post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView.11
            @Override // java.lang.Runnable
            public void run() {
                if (ScanEntryProviderContainerView.this.f198731a0) {
                    ScanEntryProviderContainerView scanEntryProviderContainerView = ScanEntryProviderContainerView.this;
                    scanEntryProviderContainerView.e(scanEntryProviderContainerView.f198731a0);
                }
            }
        });
    }

    public void b0() {
        ScanEntryProviderView scanEntryProviderView = this.K;
        if (scanEntryProviderView != null && (scanEntryProviderView instanceof ARScanEntryView)) {
            ((ARScanEntryView) scanEntryProviderView).i1();
        }
    }

    @Override // com.tencent.mobileqq.ar.view.d
    public com.tencent.mobileqq.ar.model.c c() {
        return this.M;
    }

    public void c0() {
        Iterator<Map.Entry<Integer, ScanEntryProviderView>> it = this.J.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().A();
        }
        com.tencent.mobileqq.olympic.activity.c cVar = this.f198733c0;
        if (cVar != null) {
            cVar.k(this.f198738f);
            this.f198733c0 = null;
        }
        PromotionEntry promotionEntry = this.f198732b0;
        if (promotionEntry != null) {
            promotionEntry.d(this.f198738f);
            this.f198732b0 = null;
        }
        com.tencent.mobileqq.ar.view.b bVar = this.f198752p0;
        if (bVar != null) {
            bVar.c();
        }
        com.tencent.mobileqq.ar.model.c cVar2 = this.M;
        if (cVar2 != null) {
            cVar2.z(null);
        }
        this.f198742h0 = true;
    }

    @Override // com.tencent.mobileqq.ar.view.d
    public void d(final boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("ScanEntryProviderContainerView", 2, "onNotifyBottomControllerPanelVisibleForAr enable" + z16);
        }
        if (!this.f198745j0 && !this.V && this.f198744i0 != z16) {
            this.f198744i0 = z16;
            Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView.12
                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    View view = ScanEntryProviderContainerView.this.C;
                    if (view != null) {
                        if (z16) {
                            i3 = 0;
                        } else {
                            i3 = 8;
                        }
                        view.setVisibility(i3);
                    }
                }
            };
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                runnable.run();
            } else {
                this.S.post(runnable);
            }
        }
    }

    public void d0() {
        ScanEntryProviderView scanEntryProviderView = this.K;
        if (scanEntryProviderView != null) {
            scanEntryProviderView.C();
        }
    }

    @Override // com.tencent.mobileqq.ar.view.d
    public void e(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("ScanEntryProviderContainerView", 2, "onAllowShowEntryChange enable " + z16);
        }
        if (!this.U) {
            QLog.d("ScanEntryProviderContainerView", 1, "onAllowShowEntryChange refuse ,becauseof h5 not allowed show entry");
            return;
        }
        if (!this.f198735d0) {
            this.f198731a0 = z16;
            return;
        }
        boolean z17 = this.f198737e0;
        boolean z18 = false;
        if (!z17 || ((z17 && !this.f198739f0 && this.L != 2) || this.L == 1)) {
            z16 = false;
        }
        if (this.f198731a0 == z16 && this.f198732b0 != null) {
            return;
        }
        this.f198731a0 = z16;
        if (z16 && this.f198732b0 == null && !this.V) {
            com.tencent.mobileqq.olympic.activity.c cVar = this.f198733c0;
            if (cVar != null) {
                cVar.u(this.f198738f);
                return;
            }
            return;
        }
        PromotionEntry promotionEntry = this.f198732b0;
        if (promotionEntry != null) {
            if (!this.V) {
                z18 = z16;
            }
            promotionEntry.f(z18);
        }
    }

    public void e0() {
        ScanEntryProviderView scanEntryProviderView = this.K;
        if (scanEntryProviderView != null) {
            scanEntryProviderView.F();
        }
    }

    @Override // com.tencent.mobileqq.ar.model.c.InterfaceC7406c
    public void f(ARCommonConfigInfo aRCommonConfigInfo) {
        ScanEntryProviderView scanEntryProviderView = this.K;
        if (scanEntryProviderView != null) {
            scanEntryProviderView.B(aRCommonConfigInfo);
        }
        this.N = aRCommonConfigInfo;
    }

    public void f0(Rect rect) {
        LinearLayout linearLayout;
        if (rect != null && !rect.equals(this.Q)) {
            this.Q = rect;
            Iterator<Map.Entry<Integer, ScanEntryProviderView>> it = this.J.entrySet().iterator();
            while (it.hasNext()) {
                ScanEntryProviderView value = it.next().getValue();
                if (value != null && value.f198779e) {
                    value.setRectAreas(rect);
                }
            }
        }
        if (this.f198741h && (linearLayout = this.f198757u0) != null) {
            this.H = true;
            linearLayout.setTranslationX(0.0f);
            W();
        }
    }

    @Override // com.tencent.mobileqq.ar.view.d
    public ARCommonConfigInfo g() {
        return this.N;
    }

    @Override // com.tencent.mobileqq.olympic.activity.PromotionEntry.c
    public RelativeLayout getTopView() {
        return (RelativeLayout) this.f198743i;
    }

    @Override // com.tencent.mobileqq.ar.view.d
    public com.tencent.mobileqq.olympic.activity.c h() {
        return this.f198733c0;
    }

    @Override // com.tencent.mobileqq.olympic.activity.c.e
    public void i(final PromotionConfigInfo.a aVar, boolean z16) {
        ScanEntryProviderView scanEntryProviderView;
        QLog.d("ScanEntryProviderContainerView", 1, "onPromotionResComplete, promotionItem[" + aVar + "], ready[" + z16 + "]isAlreadyEnterPromotion=" + a());
        if (!this.f198742h0 && a()) {
            if (z16) {
                Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView.9
                    @Override // java.lang.Runnable
                    public void run() {
                        ARScanEntryView aRScanEntryView;
                        if (ScanEntryProviderContainerView.this.K != null && (ScanEntryProviderContainerView.this.K instanceof ARScanEntryView)) {
                            aRScanEntryView = (ARScanEntryView) ScanEntryProviderContainerView.this.K;
                            aRScanEntryView.H1(true);
                        } else {
                            aRScanEntryView = null;
                        }
                        if (aRScanEntryView != null) {
                            aRScanEntryView.h1(aVar);
                        }
                        if (ScanEntryProviderContainerView.this.a()) {
                            ScanEntryProviderContainerView.this.Q("onTransferDoorAllReady", aVar, true);
                            if (aRScanEntryView != null) {
                                aRScanEntryView.E1("onTransferDoorAllReady", aVar, true);
                            }
                        }
                    }
                };
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    runnable.run();
                    return;
                } else {
                    ThreadManager.getUIHandler().post(runnable);
                    return;
                }
            }
            if (aVar == null && a()) {
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView.10
                    @Override // java.lang.Runnable
                    public void run() {
                        QQToast makeText = QQToast.makeText(ScanEntryProviderContainerView.this.f198736e, HardCodeUtil.qqStr(R.string.t3f), 1);
                        makeText.setAutoTextSize();
                        makeText.show();
                    }
                }, 1000L);
                return;
            } else {
                if (a() && (scanEntryProviderView = this.K) != null && (scanEntryProviderView instanceof ARScanEntryView)) {
                    ((ARScanEntryView) scanEntryProviderView).H1(true);
                    return;
                }
                return;
            }
        }
        if (z16) {
            this.f198756t0 = aVar;
        }
    }

    @Override // com.tencent.mobileqq.olympic.activity.c.e
    public boolean isEngineReady() {
        if (QLog.isColorLevel()) {
            QLog.d("ScanEntryProviderContainerView", 2, "isEngineReady = ");
        }
        ScanEntryProviderView scanEntryProviderView = this.K;
        if (scanEntryProviderView == null || !(scanEntryProviderView instanceof ARScanEntryView)) {
            return false;
        }
        return ((ARScanEntryView) scanEntryProviderView).c1();
    }

    @Override // com.tencent.mobileqq.ar.view.d
    public com.tencent.mobileqq.ar.model.d j() {
        return this.P;
    }

    public void j0(int i3, Bundle bundle) {
        ScanEntryProviderView h16;
        String str;
        bundle.getBoolean("COLD_START", false);
        int i16 = bundle.getInt("fromSource", 1);
        int g16 = this.I.g(i3);
        QLog.i("ScanEntryProviderContainerView", 1, "showProviderEntry index=" + g16);
        if (this.L == g16) {
            QLog.i("ScanEntryProviderContainerView", 1, "showProviderEntry value equal return");
            return;
        }
        if (this.f198741h && i3 != 1) {
            IScanDaTongApi iScanDaTongApi = (IScanDaTongApi) QRoute.api(IScanDaTongApi.class);
            LinearLayout linearLayout = this.G;
            if (i3 == 2) {
                str = IScanDaTongApi.PAGE_ID_QR;
            } else {
                str = IScanDaTongApi.PAGE_ID_OCR;
            }
            iScanDaTongApi.setGalleryBtnInfo(linearLayout, str, true);
        }
        l0(g16);
        ScanEntryProviderView scanEntryProviderView = this.K;
        if (scanEntryProviderView != null) {
            scanEntryProviderView.D();
            this.K.v(false);
            this.K.setVisibility(8);
        }
        if (this.J.containsKey(Integer.valueOf(g16))) {
            h16 = this.J.get(Integer.valueOf(g16));
        } else {
            h16 = this.I.h(i3, this.f198736e, this, this.f198741h);
            if (h16 != null) {
                this.J.put(Integer.valueOf(g16), h16);
                this.f198748m.addView(h16);
            }
        }
        if (h16 != null && !h16.f198779e) {
            h16.setAppInterface(this.f198738f);
            h16.z(bundle);
            h16.setRectAreas(this.Q);
            if (i3 == 2) {
                ((QRScanEntryView) h16).setVoiceScanStatusListener(this.f198755s0);
            }
        }
        this.L = g16;
        this.K = h16;
        if (h16 != null) {
            h16.setVisibility(0);
            this.K.E();
            ARCommonConfigInfo aRCommonConfigInfo = this.N;
            if (aRCommonConfigInfo != null) {
                this.K.B(aRCommonConfigInfo);
            }
            PromotionConfigInfo.a aVar = this.f198756t0;
            if (aVar != null) {
                ScanEntryProviderView scanEntryProviderView2 = this.K;
                if (scanEntryProviderView2 instanceof ARScanEntryView) {
                    ((ARScanEntryView) scanEntryProviderView2).h1(aVar);
                }
            }
            if (i3 != 3 && this.K.y()) {
                e(true);
            } else if (i3 == 3) {
                e(false);
            }
            if (this.f198741h) {
                this.f198759w0.setTextColor(Color.parseColor("#999999"));
                this.f198758v0.setTextColor(Color.parseColor("#999999"));
                this.f198760x0.setTextColor(Color.parseColor("#999999"));
            }
            if (this.f198741h && !this.H) {
                N(i3);
            }
        }
        int i17 = this.L;
        if (i17 == 0) {
            ReportController.o(null, "CliOper", "", "", "0X8008F23", "0X8008F23", 0, 0, Integer.toString(i16), "0", "0", "");
        } else if (i17 == 2) {
            ReportController.o(null, "dc00898", "", "", "0X8009C7B", "0X8009C7B", 0, 0, "", "0", "0", "");
        }
    }

    @Override // com.tencent.mobileqq.ar.view.d
    public void k(final boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("ScanEntryProviderContainerView", 2, "onNotifyBottomControllerPanelVisibleForQr enable" + z16);
        }
        if (!this.f198745j0 && this.f198744i0 != z16) {
            this.f198744i0 = z16;
            Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView.13
                @Override // java.lang.Runnable
                public void run() {
                    ScanEntryProviderContainerView scanEntryProviderContainerView = ScanEntryProviderContainerView.this;
                    if (scanEntryProviderContainerView.C != null) {
                        scanEntryProviderContainerView.M(z16 ? 1 : 0);
                    }
                }
            };
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                runnable.run();
            } else {
                this.S.post(runnable);
            }
        }
    }

    public void k0(a.b bVar, boolean z16) {
        boolean z17;
        QLog.i("ScanEntryProviderContainerView", 1, "showProviderEntry with bundle");
        Bundle bundle = new Bundle();
        bundle.putBoolean("COLD_START", true);
        bundle.putBoolean("hide_album", !this.R);
        if (!z16 && ((bVar instanceof a.C11663a) || (bVar instanceof a.c))) {
            g0(bVar);
        }
        if (!z16 && bVar != null && (z17 = bVar.f452149f)) {
            if (bVar instanceof a.C11663a) {
                bundle.putInt("fromSource", 2);
                j0(1, z81.a.a(bundle));
                ReportController.o(null, "dc00898", "", "", "0X80098C7", "0X80098C7", 3, 0, "", "", "", "");
                return;
            } else {
                if (z17) {
                    bundle.putLong("recognitionMask", bVar.f452144a);
                    bundle.putBoolean("NoLimitParams", false);
                    bundle.putBoolean("enableARCloud", bVar.f452147d);
                    ((ViewGroup) this.f198743i).removeView(this.C);
                    this.f198745j0 = true;
                    bundle.putInt("fromSource", 2);
                    j0(1, bundle);
                    return;
                }
                return;
            }
        }
        if (z16) {
            ((ViewGroup) this.f198743i).removeView(this.C);
            this.f198745j0 = true;
        }
        j0(2, bundle);
    }

    @Override // com.tencent.mobileqq.olympic.activity.PromotionEntry.c
    public void l(PromotionConfigInfo.a aVar) {
        boolean z16;
        boolean z17;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onPromotionEntryClick ");
        if (aVar != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.d("ScanEntryProviderContainerView", 1, sb5.toString());
        if (this.K != null && this.f198732b0 != null && aVar != null) {
            if (PromotionResDownload.m(false, this.f198738f.getCurrentAccountUin(), aVar) != null) {
                if (this.f198733c0 == null) {
                    QLog.d("ScanEntryProviderContainerView", 1, "operateBtnOnClick, \u8d44\u6e90\u8fd8\u6ca1\u51c6\u5907\u597d");
                    com.tencent.mobileqq.ar.ARPromotionMgr.f.b(this.f198738f).m(this.f198738f, aVar.f196897e);
                } else {
                    QLog.w("ScanEntryProviderContainerView", 1, "operateBtnOnClick, \u8d44\u6e90\u8fd8\u6ca1\u51c6\u5907\u597d, TotalProgress[" + this.f198733c0.n() + "], isDownloading[" + this.f198733c0.q() + "], isDownloadError[" + this.f198733c0.p() + "]");
                    this.f198733c0.w(this.f198738f);
                }
                z17 = false;
            } else {
                z17 = true;
            }
            ScanEntryProviderView scanEntryProviderView = this.K;
            if (scanEntryProviderView instanceof ARScanEntryView) {
                ARScanEntryView aRScanEntryView = (ARScanEntryView) scanEntryProviderView;
                if (!aRScanEntryView.c1()) {
                    QLog.d("ScanEntryProviderContainerView", 1, "onPromotionEntryClick refuse,AREngine not ready");
                    return;
                }
                PromotionConfigInfo.a aVar2 = this.f198756t0;
                if (aVar2 != null) {
                    aRScanEntryView.h1(aVar2);
                }
                aRScanEntryView.E1("onPromotionEntryClick", aVar, z17);
                ReportController.o(null, "dc00898", "", "", "0X80098C7", "0X80098C7", 2, 0, "", "", "", "");
                if (!z17) {
                    com.tencent.mobileqq.olympic.activity.c cVar = this.f198733c0;
                    if (cVar != null) {
                        cVar.A(true);
                    }
                    aRScanEntryView.r1("operateBtnOnClick1", true);
                }
            } else {
                int g16 = this.I.g(1);
                if (this.J.containsKey(Integer.valueOf(g16))) {
                    ARScanEntryView aRScanEntryView2 = (ARScanEntryView) this.J.get(Integer.valueOf(g16));
                    aRScanEntryView2.D();
                    aRScanEntryView2.v(true);
                    this.J.remove(Integer.valueOf(g16));
                }
                Bundle a16 = z81.a.a(null);
                a16.putString("Title", aVar.f196898f);
                j0(1, a16);
                ReportController.o(null, "dc00898", "", "", "0X80098C7", "0X80098C7", 1, 0, "", "", "", "");
            }
            this.f198732b0.c(false, aVar);
            com.tencent.mobileqq.olympic.activity.c cVar2 = this.f198733c0;
            if (cVar2 != null) {
                cVar2.A(true);
            }
            Q("onClickOperateEntry", aVar, z17);
        }
    }

    @Override // com.tencent.mobileqq.olympic.activity.c.e
    public void m(PromotionConfigInfo.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d("ScanEntryProviderContainerView", 2, "notifyPromotionEntryReady");
        }
        if (a()) {
            U();
            return;
        }
        PromotionEntry promotionEntry = this.f198732b0;
        if (promotionEntry == null) {
            PromotionEntry promotionEntry2 = new PromotionEntry(this);
            this.f198732b0 = promotionEntry2;
            promotionEntry2.e(this.f198738f, aVar);
        } else {
            promotionEntry.f(true);
            if (QLog.isColorLevel()) {
                QLog.d("ScanEntryProviderContainerView", 2, "PromotionEntry has already exist");
            }
        }
    }

    @Override // com.tencent.mobileqq.olympic.activity.c.e
    public boolean n() {
        return this.f198731a0;
    }

    @Override // com.tencent.mobileqq.olympic.activity.c.e
    public void o(String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("ScanEntryProviderContainerView", 2, "updatePromotionResProgress Progress:" + i3);
        }
        if (!a()) {
            if (QLog.isColorLevel()) {
                QLog.d("ScanEntryProviderContainerView", 2, "updatePromotionResProgress not show,because not under promotion mode");
            }
        } else {
            ScanEntryProviderView scanEntryProviderView = this.K;
            if (scanEntryProviderView != null && (scanEntryProviderView instanceof ARScanEntryView)) {
                ((ARScanEntryView) scanEntryProviderView).r1(str, true);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.T.onTouchEvent(motionEvent);
    }

    public void setEntranceType(int i3) {
        this.f198746k0 = i3;
    }

    public void setInitEnv(AppInterface appInterface, Context context) {
        this.f198738f = appInterface;
        this.f198736e = context;
    }

    public void setIsNewUI(boolean z16) {
        this.f198741h = z16;
    }

    public void setRenderEngine(com.tencent.mobileqq.ar.model.d dVar) {
        this.P = dVar;
    }

    public void setScanRect(Rect rect, boolean z16) {
        this.Q = rect;
        this.R = z16;
    }

    public void setUniformResManager(com.tencent.mobileqq.ar.model.c cVar) {
        this.M = cVar;
        cVar.z(this);
    }

    public ScanEntryProviderContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScanEntryProviderContainerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        boolean z16 = false;
        this.f198734d = false;
        this.H = true;
        this.J = new HashMap<>();
        this.K = null;
        this.L = -1;
        this.R = true;
        this.U = true;
        this.V = false;
        this.W = null;
        this.f198731a0 = false;
        this.f198732b0 = null;
        this.f198733c0 = null;
        this.f198735d0 = false;
        this.f198737e0 = false;
        this.f198739f0 = false;
        this.f198740g0 = 0L;
        this.f198742h0 = false;
        this.f198744i0 = true;
        this.f198745j0 = false;
        this.f198746k0 = 0;
        this.f198750n0 = new Runnable() { // from class: com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView.1
            @Override // java.lang.Runnable
            public void run() {
                CameraProxy.v().C(ScanEntryProviderContainerView.this.f198747l0, ScanEntryProviderContainerView.this.f198749m0, UniformGLRenderManagerImpl.U, UniformGLRenderManagerImpl.V);
            }
        };
        this.f198751o0 = new Runnable() { // from class: com.tencent.mobileqq.ar.view.e
            @Override // java.lang.Runnable
            public final void run() {
                ScanEntryProviderContainerView.Z();
            }
        };
        this.f198752p0 = new com.tencent.mobileqq.ar.view.b();
        this.f198753q0 = new AnonymousClass2();
        this.f198754r0 = new c();
        this.f198755s0 = new f();
        if (((IScanABTestApi) QRoute.api(IScanABTestApi.class)).isScanUIExpOnline() && ((IScanABTestApi) QRoute.api(IScanABTestApi.class)).isScanUIExperimentB()) {
            z16 = true;
        }
        this.f198741h = z16;
        ((IScanABTestApi) QRoute.api(IScanABTestApi.class)).reportScanUIExpExposure();
        QLog.i("ScanEntryProviderContainerView", 1, "isNewUI = " + this.f198741h);
        if (this.f198741h) {
            X();
        } else {
            Y();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class b implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f198769d;

        b(View view) {
            this.f198769d = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f198769d.setVisibility(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class g implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f198775d;

        g(int i3) {
            this.f198775d = i3;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f198775d == 1) {
                ScanEntryProviderContainerView.this.C.setVisibility(0);
            } else {
                ScanEntryProviderContainerView.this.C.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
