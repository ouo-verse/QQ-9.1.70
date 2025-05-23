package com.tencent.mobileqq.ar.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieListener;
import com.tencent.av.utils.ad;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ar.ARRecord.ARRecordUtils;
import com.tencent.mobileqq.ar.arengine.aj;
import com.tencent.mobileqq.ar.arengine.ak;
import com.tencent.mobileqq.ar.model.CameraProxy;
import com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl;
import com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView;
import com.tencent.mobileqq.ar.y;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.QBarResult;
import com.tencent.mobileqq.qrscan.QMiniResult;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IMiniCodeApi;
import com.tencent.mobileqq.qrscan.api.IQRJumpApi;
import com.tencent.mobileqq.qrscan.api.IQRScanReportApi;
import com.tencent.mobileqq.qrscan.api.IScanCacheApi;
import com.tencent.mobileqq.qrscan.api.IScanDaTongApi;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView;
import com.tencent.mobileqq.qrscan.view.ScannerSingleResultView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.ab;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QRScanEntryView extends ScanEntryProviderView implements ak, aj, View.OnClickListener, CameraProxy.a {
    protected View F;
    private ViewfinderView G;
    private ViewGroup H;
    private TextView I;
    private TextView J;
    private ViewGroup K;
    private Rect L;
    private ViewGroup M;
    private TextView N;
    private TextView P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private CheckBox V;
    private boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f198693a0;

    /* renamed from: b0, reason: collision with root package name */
    private ScannerMultiResultSelectView f198694b0;

    /* renamed from: c0, reason: collision with root package name */
    private ScannerSingleResultView f198695c0;

    /* renamed from: d0, reason: collision with root package name */
    private ScanEntryProviderContainerView.i f198696d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f198697e0;

    /* renamed from: f0, reason: collision with root package name */
    private View.OnTouchListener f198698f0;

    /* renamed from: g0, reason: collision with root package name */
    volatile boolean f198699g0;

    /* renamed from: h0, reason: collision with root package name */
    ImageView f198700h0;

    /* renamed from: i0, reason: collision with root package name */
    Runnable f198701i0;

    /* renamed from: j0, reason: collision with root package name */
    private ScannerMultiResultSelectView.c f198702j0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f198716d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f198717e;

        a(View view, boolean z16) {
            this.f198716d = view;
            this.f198717e = z16;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View view = this.f198716d;
            if (view != null) {
                view.setAlpha(1.0f);
                if (!this.f198717e) {
                    this.f198716d.setVisibility(4);
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            View view = this.f198716d;
            if (view != null && this.f198717e) {
                view.setVisibility(0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QRScanEntryView.this.findViewById(R.id.dwh).setAlpha(1.0f);
            QRScanEntryView qRScanEntryView = QRScanEntryView.this;
            ScanTorchActivity scanTorchActivity = (ScanTorchActivity) qRScanEntryView.f198780f;
            String currentAccountUin = qRScanEntryView.f198778d.getCurrentAccountUin();
            String f16 = ac.f(QRScanEntryView.this.f198778d, currentAccountUin);
            Intent intent = new Intent(scanTorchActivity, (Class<?>) QRDisplayActivity.class);
            intent.putExtra("from", "ScannerActivity");
            intent.putExtra("my_qrcode_pg_source", "2");
            intent.putExtra("title", scanTorchActivity.getString(R.string.g2w));
            intent.putExtra("nick", f16);
            intent.putExtra("uin", currentAccountUin);
            intent.putExtra("type", 1);
            com.tencent.biz.qrcode.util.f.c(intent, scanTorchActivity);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QRScanEntryView.this.Q) {
                if (CameraProxy.v().P(!QRScanEntryView.this.R)) {
                    QRScanEntryView.this.R = !r0.R;
                    ((com.tencent.mobileqq.ar.model.b) QRScanEntryView.this.f198782i).o0(!r0.R, 0L);
                    QRScanEntryView.this.r0(true);
                    QRScanEntryView qRScanEntryView = QRScanEntryView.this;
                    qRScanEntryView.k0(qRScanEntryView.R);
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("AREngine_QRScanEntryView", 2, "initView click mFlashLightTips when view invisble.");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class e implements CompoundButton.OnCheckedChangeListener {
        e() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            ((IQRScanReportApi) QRoute.api(IQRScanReportApi.class)).setSaveDetectImage(z16);
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class f implements View.OnTouchListener {
        f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    view.setAlpha(1.0f);
                    return false;
                }
                return false;
            }
            view.setAlpha(0.5f);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class g implements LottieListener<LottieComposition> {
        g() {
        }

        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(LottieComposition lottieComposition) {
            long j3;
            if (lottieComposition != null) {
                j3 = lottieComposition.getDuration() + 100.0f;
                LottieDrawable lottieDrawable = new LottieDrawable();
                lottieDrawable.setComposition(lottieComposition);
                lottieDrawable.setBounds(0, 0, ViewUtils.dpToPx(30.0f), ViewUtils.dpToPx(30.0f));
                lottieDrawable.playAnimation();
                QRScanEntryView.this.P.setCompoundDrawables(null, lottieDrawable, null, null);
            } else {
                QLog.e("AREngine_QRScanEntryView", 1, "loadFlashLightSVGDrawable fail, use static resource.");
                QRScanEntryView.this.P.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.emy, 0, 0);
                j3 = 0;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(QRScanEntryView.this.P, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f, 1.0f);
            ofFloat.setDuration(300L);
            ofFloat.setRepeatCount(2);
            ofFloat.setStartDelay(j3);
            ofFloat.start();
            QRScanEntryView qRScanEntryView = QRScanEntryView.this;
            qRScanEntryView.s0(qRScanEntryView.P, true, false);
            QRScanEntryView qRScanEntryView2 = QRScanEntryView.this;
            qRScanEntryView2.s0(qRScanEntryView2.N, false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class h implements MiniAppLaunchListener {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<Activity> f198726a;

        /* renamed from: b, reason: collision with root package name */
        private String f198727b;

        /* renamed from: c, reason: collision with root package name */
        private String f198728c;

        /* renamed from: d, reason: collision with root package name */
        private com.tencent.mobileqq.qrscan.h f198729d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<com.tencent.mobileqq.ar.model.b> f198730e;

        public h(Activity activity, String str, String str2, com.tencent.mobileqq.qrscan.h hVar, com.tencent.mobileqq.ar.model.b bVar) {
            this.f198726a = new WeakReference<>(activity);
            this.f198727b = str;
            this.f198728c = str2;
            this.f198729d = hVar;
            this.f198730e = new WeakReference<>(bVar);
        }

        @Override // com.tencent.mobileqq.mini.api.MiniAppLaunchListener
        public void onLaunchResult(boolean z16, Bundle bundle) {
            Activity activity = this.f198726a.get();
            if (z16 && activity != null) {
                Intent intent = new Intent();
                intent.putExtra("detectType", 2);
                intent.putExtra("scannerResult", this.f198727b.trim());
                if (!TextUtils.isEmpty(this.f198728c)) {
                    intent.putExtra("filePath", this.f198728c);
                }
                activity.setResult(13, intent);
                activity.finish();
                activity.overridePendingTransition(0, 0);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("AREngine_QRScanEntryView", 2, "onLaunchResult 2 false");
            }
            if (this.f198730e.get() != null) {
                this.f198730e.get().l0(false);
            }
        }
    }

    public QRScanEntryView(Context context, com.tencent.mobileqq.ar.view.d dVar, boolean z16) {
        super(context, dVar);
        this.f198697e0 = false;
        this.f198698f0 = new f();
        this.f198701i0 = new Runnable() { // from class: com.tencent.mobileqq.ar.view.QRScanEntryView.11
            @Override // java.lang.Runnable
            public void run() {
                if (QRScanEntryView.this.f198699g0) {
                    QRScanEntryView qRScanEntryView = QRScanEntryView.this;
                    ImageView imageView = qRScanEntryView.f198700h0;
                    if (imageView == null) {
                        qRScanEntryView.f198700h0 = new ImageView(QRScanEntryView.this.getContext());
                        QRScanEntryView.this.f198700h0.setImageResource(R.drawable.f160545jt);
                        int f16 = BaseAIOUtils.f(25.0f, QRScanEntryView.this.getResources());
                        Rect rect = new Rect(0, 0, f16, f16);
                        int i3 = (int) (f16 * 0.5f);
                        rect.offset(QRScanEntryView.this.L.centerX() - i3, QRScanEntryView.this.L.centerY() - i3);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f16, f16);
                        layoutParams.leftMargin = rect.left;
                        layoutParams.topMargin = rect.top;
                        QRScanEntryView qRScanEntryView2 = QRScanEntryView.this;
                        qRScanEntryView2.addView(qRScanEntryView2.f198700h0, layoutParams);
                    } else {
                        imageView.setVisibility(0);
                    }
                    ((Animatable) QRScanEntryView.this.f198700h0.getDrawable()).start();
                    return;
                }
                ImageView imageView2 = QRScanEntryView.this.f198700h0;
                if (imageView2 != null) {
                    ((Animatable) imageView2.getDrawable()).stop();
                    QRScanEntryView.this.f198700h0.setVisibility(8);
                }
            }
        };
        this.f198702j0 = new ScannerMultiResultSelectView.c() { // from class: com.tencent.mobileqq.ar.view.QRScanEntryView.15
            @Override // com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView.c
            public void a(QBarResult qBarResult, int i3, com.tencent.mobileqq.qrscan.h hVar) {
                if (QLog.isColorLevel()) {
                    QLog.d("AREngine_QRScanEntryView", 2, "onMultiSelectQr result:" + qBarResult + " " + i3);
                }
                QRScanEntryView qRScanEntryView = QRScanEntryView.this;
                qRScanEntryView.i0(qBarResult.f276508f, qBarResult.f276507e, (Activity) qRScanEntryView.f198780f, hVar, false);
            }

            @Override // com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView.c
            public void b() {
                if (QLog.isColorLevel()) {
                    QLog.d("AREngine_QRScanEntryView", 2, "onMultiCancel");
                }
                QRScanEntryView qRScanEntryView = QRScanEntryView.this;
                com.tencent.mobileqq.ar.model.a aVar = qRScanEntryView.f198782i;
                if (aVar != null && (aVar instanceof com.tencent.mobileqq.ar.model.b) && qRScanEntryView.D) {
                    qRScanEntryView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.ar.view.QRScanEntryView.15.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.ar.model.a aVar2;
                            QRScanEntryView qRScanEntryView2 = QRScanEntryView.this;
                            if (qRScanEntryView2.D && (aVar2 = qRScanEntryView2.f198782i) != null && (aVar2 instanceof com.tencent.mobileqq.ar.model.b)) {
                                ((com.tencent.mobileqq.ar.model.b) aVar2).l0(false);
                                ((com.tencent.mobileqq.ar.model.b) QRScanEntryView.this.f198782i).k0();
                                ((com.tencent.mobileqq.ar.model.b) QRScanEntryView.this.f198782i).j0();
                                ((com.tencent.mobileqq.ar.model.b) QRScanEntryView.this.f198782i).i0();
                            }
                        }
                    }, 500L);
                }
                QRScanEntryView.this.d0(1);
                QRScanEntryView.this.H.setVisibility(0);
                QRScanEntryView.this.G.setShowScanline(true);
            }

            @Override // com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView.c
            public void c(QMiniResult qMiniResult, int i3, com.tencent.mobileqq.qrscan.h hVar) {
                if (QLog.isColorLevel()) {
                    QLog.d("AREngine_QRScanEntryView", 2, "onMultiSelectMini result:" + qMiniResult + " " + i3);
                }
                QRScanEntryView qRScanEntryView = QRScanEntryView.this;
                qRScanEntryView.g0(qMiniResult.f276511e, qMiniResult.f276513h, (Activity) qRScanEntryView.f198780f, hVar);
            }
        };
        this.W = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(int i3) {
        boolean z16;
        com.tencent.mobileqq.ar.view.d dVar = this.f198783m;
        if (i3 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        dVar.k(z16);
        float f16 = i3;
        if (this.M.getAlpha() == f16) {
            return;
        }
        ViewGroup viewGroup = this.M;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(viewGroup, com.tencent.luggage.wxa.c8.c.f123400v, viewGroup.getAlpha(), f16);
        ofFloat.setDuration(300L);
        ofFloat.addListener(new b(i3));
        ofFloat.start();
    }

    private void e0() {
        QLog.d("AREngine_QRScanEntryView", 1, "checkIfNeedAutoFocus isCameraPrviewing=" + CameraProxy.v().B() + ";mIsResumed=" + this.D);
        if (CameraProxy.v().B() && this.D) {
            CameraProxy.v().n(UniformGLRenderManagerImpl.U, UniformGLRenderManagerImpl.V);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(final ScannerResult scannerResult, final com.tencent.mobileqq.qrscan.h hVar, final boolean z16) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.QRScanEntryView.13
            @Override // java.lang.Runnable
            public void run() {
                QRScanEntryView qRScanEntryView = QRScanEntryView.this;
                Context context = qRScanEntryView.f198780f;
                if (context != null && qRScanEntryView.f198782i != null) {
                    Activity activity = (Activity) context;
                    ScannerResult scannerResult2 = scannerResult;
                    if (scannerResult2 != null && scannerResult2.k() && (hVar.f276637a == null || ((IMiniCodeApi) QRoute.api(IMiniCodeApi.class)).isDetectInited())) {
                        QRScanEntryView.this.p0(scannerResult, 3, hVar, z16);
                        if (!z16) {
                            QRScanEntryView.this.l0(true);
                            return;
                        }
                        return;
                    }
                    ScannerResult scannerResult3 = scannerResult;
                    if (scannerResult3 != null && scannerResult3.l()) {
                        Pair<StringBuilder, StringBuilder> f16 = scannerResult.f();
                        if (f16 != null) {
                            if (!z16) {
                                QRScanEntryView.this.q0(scannerResult, 1, hVar);
                            }
                            QRScanEntryView.this.i0(String.valueOf(f16.first), String.valueOf(f16.second), activity, hVar, z16);
                        }
                        if (!z16) {
                            QRScanEntryView.this.l0(false);
                        }
                        ReportController.o(null, "dc00898", "", "", "0X80085AC", "0X80085AC", 0, 0, "", "", "", "");
                        return;
                    }
                    ScannerResult scannerResult4 = scannerResult;
                    if (scannerResult4 != null && scannerResult4.j()) {
                        String c16 = scannerResult.c();
                        String e16 = scannerResult.e();
                        if (!z16) {
                            QRScanEntryView.this.q0(scannerResult, 2, hVar);
                        }
                        QRScanEntryView.this.g0(c16, e16, activity, hVar);
                        if (!z16) {
                            QRScanEntryView.this.l0(false);
                        }
                        ReportController.o(null, "dc00898", "", "", "0X80085AC", "0X80085AC", 1, 0, "", "", "", "");
                        return;
                    }
                    if (!TextUtils.isEmpty(hVar.f276640d)) {
                        ((com.tencent.mobileqq.ar.model.b) QRScanEntryView.this.f198782i).l0(false);
                        ARRecordUtils.h(HardCodeUtil.qqStr(R.string.ref), false);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(String str, String str2, Activity activity, com.tencent.mobileqq.qrscan.h hVar) {
        com.tencent.mobileqq.ar.model.a aVar;
        if (!TextUtils.isEmpty(str) && activity != null && (aVar = this.f198782i) != null) {
            com.tencent.mobileqq.ar.model.b bVar = (com.tencent.mobileqq.ar.model.b) aVar;
            if ("qq".equals(str2)) {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).launchAppByMiniCode(activity, str, 1047, new h(activity, str, hVar.f276640d, hVar, bVar));
            } else if ("wx".equals(str2)) {
                QLog.i("AREngine_QRScanEntryView", 2, String.format("handleScannerMiniResult jumpMiniCode result=%s", str));
                ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByQQCode(activity, str, 1047);
                activity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(String str, String str2, Activity activity, com.tencent.mobileqq.qrscan.h hVar, boolean z16) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && activity != null) {
            Intent intent = activity.getIntent();
            Intent intent2 = new Intent();
            intent2.putExtra("detectType", 1);
            intent2.putExtra("scannerResult", str.trim());
            intent2.putExtra("scannerType", str2.trim());
            if (hVar != null && !TextUtils.isEmpty(hVar.f276640d)) {
                intent2.putExtra("filePath", hVar.f276640d);
            }
            ScannerParams scannerParams = (ScannerParams) intent.getParcelableExtra("scanner_param");
            if ((scannerParams != null && scannerParams.f276514d) || z16) {
                activity.setResult(13, intent2);
                activity.finish();
                activity.overridePendingTransition(0, 0);
            } else {
                o0(hVar);
                intent2.putExtra("qr_report_param", intent.getStringExtra("qr_report_param"));
                intent2.putExtra("scanner_param", scannerParams);
                intent2.setClass(activity, ((IQRJumpApi) QRoute.api(IQRJumpApi.class)).getDispatchScanResultActivityCls());
                activity.startActivity(intent2);
            }
        }
    }

    private void j0() {
        LottieCompositionFactory.fromAsset(this.f198780f, "qq_ar_light_first_show.json").addListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(boolean z16) {
        if (!this.T && z16) {
            ReportController.o(null, "dc00898", "", "", "0X8008C91", "0X8008C91", 1, 0, "", "", "", "");
            this.T = true;
        } else if (!this.U && !z16) {
            ReportController.o(null, "dc00898", "", "", "0X8008C91", "0X8008C91", 0, 0, "", "", "", "");
            this.U = true;
        }
        ((IScanDaTongApi) QRoute.api(IScanDaTongApi.class)).setFlashlightBtnInfo(this.P, IScanDaTongApi.PAGE_ID_QR, this.W, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(boolean z16) {
        String str;
        String str2;
        com.tencent.mobileqq.ar.model.a aVar = this.f198782i;
        if (aVar != null && (aVar instanceof com.tencent.mobileqq.ar.model.b)) {
            long currentTimeMillis = System.currentTimeMillis() - ((com.tencent.mobileqq.ar.model.b) this.f198782i).a0();
            int W = ((com.tencent.mobileqq.ar.model.b) this.f198782i).W();
            boolean X = ((com.tencent.mobileqq.ar.model.b) this.f198782i).X();
            String valueOf = String.valueOf(currentTimeMillis);
            String valueOf2 = String.valueOf(W);
            if (z16) {
                str = "1";
            } else {
                str = "0";
            }
            if (X) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            ReportController.o(null, "dc00898", "", "", "0X800C3BC", "0X800C3BC", 0, 0, valueOf, valueOf2, str, str2);
            if (W == 0) {
                return;
            }
            long j3 = W;
            ReportController.o(null, "dc00898", "", "", "0X800C3BD", "0X800C3BD", 0, 0, String.valueOf(((com.tencent.mobileqq.ar.model.b) this.f198782i).Y() / j3), String.valueOf(((com.tencent.mobileqq.ar.model.b) this.f198782i).Z() / j3), "", "");
        }
    }

    private void m0() {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_QRScanEntryView", 2, "resetFlashLightState");
        }
        this.Q = false;
        this.R = false;
        s0(this.P, false, false);
        s0(this.N, !this.Q, false);
        ((com.tencent.mobileqq.ar.model.b) this.f198782i).o0(true, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(ScannerResult scannerResult, int i3, int i16) {
        if (scannerResult != null && i3 > 0 && i16 > 0) {
            if (scannerResult.j()) {
                Iterator<QMiniResult> it = scannerResult.f276521e.iterator();
                while (it.hasNext()) {
                    QMiniResult next = it.next();
                    RectF rectF = new RectF();
                    RectF rectF2 = next.f276512f;
                    rectF.set(1.0f - rectF2.bottom, rectF2.left, 1.0f - rectF2.top, rectF2.right);
                    next.f276512f.set(rectF);
                }
            }
            if (scannerResult.l()) {
                Iterator<QBarResult> it5 = scannerResult.f276520d.iterator();
                while (it5.hasNext()) {
                    QBarResult next2 = it5.next();
                    RectF rectF3 = new RectF();
                    RectF rectF4 = next2.f276509h;
                    rectF3.set(1.0f - rectF4.bottom, rectF4.left, 1.0f - rectF4.top, rectF4.right);
                    next2.f276509h.set(rectF3);
                }
            }
        }
    }

    private void o0(final com.tencent.mobileqq.qrscan.h hVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.ar.view.QRScanEntryView.12
            @Override // java.lang.Runnable
            public void run() {
                ((IScanCacheApi) QRoute.api(IScanCacheApi.class)).saveTempCameraData(hVar);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(ScannerResult scannerResult, int i3, com.tencent.mobileqq.qrscan.h hVar, boolean z16) {
        int i16;
        if (scannerResult != null && scannerResult.k() && this.f198782i != null && this.f198780f != null) {
            ScannerMultiResultSelectView scannerMultiResultSelectView = this.f198694b0;
            if (scannerMultiResultSelectView != null && scannerMultiResultSelectView.isShowing()) {
                return;
            }
            if (this.f198694b0 == null) {
                ScannerMultiResultSelectView scannerMultiResultSelectView2 = new ScannerMultiResultSelectView(this.f198780f);
                this.f198694b0 = scannerMultiResultSelectView2;
                scannerMultiResultSelectView2.setMultiSelectListener(this.f198702j0);
            }
            RelativeLayout relativeLayout = (RelativeLayout) ((Activity) this.f198780f).findViewById(R.id.f79584_6);
            ScannerMultiResultSelectView scannerMultiResultSelectView3 = this.f198694b0;
            if (z16) {
                i16 = 4;
            } else {
                i16 = 3;
            }
            scannerMultiResultSelectView3.B(relativeLayout, scannerResult, i3, hVar, 1, i16);
            d0(0);
            this.H.setVisibility(8);
            this.G.setShowScanline(false);
            if (!ad.o(this.f198780f) && !ad.n(this.f198780f) && !ad.l(this.f198780f)) {
                AudioUtil.n(R.raw.f169446aa, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(ScannerResult scannerResult, int i3, com.tencent.mobileqq.qrscan.h hVar) {
        if (scannerResult != null && this.f198782i != null && this.f198780f != null) {
            ScannerSingleResultView scannerSingleResultView = this.f198695c0;
            if ((scannerSingleResultView != null && scannerSingleResultView.t()) || scannerResult.k()) {
                return;
            }
            if (this.f198695c0 == null) {
                this.f198695c0 = new ScannerSingleResultView(this.f198780f);
            }
            this.f198695c0.w((RelativeLayout) ((Activity) this.f198780f).findViewById(R.id.f79584_6), scannerResult, i3, hVar);
            d0(0);
            this.H.setVisibility(8);
            this.G.setShowScanline(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(boolean z16) {
        boolean z17;
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_QRScanEntryView", 2, String.format("updateFlashLightView byUserClick=%s mIsFlashLightVisible=%s mIsFlashLightOn=%s", Boolean.valueOf(z16), Boolean.valueOf(this.Q), Boolean.valueOf(this.R)));
        }
        TextView textView = this.P;
        if (textView != null) {
            boolean z18 = this.Q;
            if (z18 && !this.R && !this.S) {
                this.S = true;
                j0();
                return;
            }
            s0(textView, z18, !z16);
            TextView textView2 = this.N;
            if (this.Q && !this.R) {
                z17 = false;
            } else {
                z17 = true;
            }
            s0(textView2, z17, true);
            if (this.R) {
                this.P.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.emz, 0, 0);
                this.P.setText(R.string.f9w);
                this.P.setTextColor(-16717057);
            } else {
                this.P.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.emy, 0, 0);
                this.P.setText(R.string.f9x);
                this.P.setTextColor(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(View view, boolean z16, boolean z17) {
        ObjectAnimator ofFloat;
        if (view != null) {
            int i3 = 4;
            if (!z17) {
                view.setAlpha(1.0f);
                if (z16) {
                    i3 = 0;
                }
                view.setVisibility(i3);
                return;
            }
            if (z16) {
                ofFloat = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
                view.setAlpha(0.0f);
                view.setVisibility(4);
            } else {
                ofFloat = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
                view.setAlpha(1.0f);
                view.setVisibility(0);
            }
            ofFloat.addListener(new a(view, z16));
            ofFloat.setDuration(300L);
            ofFloat.start();
        }
    }

    @Override // com.tencent.mobileqq.ar.view.ScanEntryProviderView
    public void A() {
        QLog.d("AREngine_QRScanEntryView", 1, "onDestroy ");
        super.A();
        CameraProxy.v().H(this);
        ScanEntryProviderContainerView.i iVar = this.f198696d0;
        if (iVar != null) {
            iVar.a(4);
        }
        ThreadManager.getUIHandler().removeCallbacks(this.f198701i0);
        ((IQRScanReportApi) QRoute.api(IQRScanReportApi.class)).setSaveDetectImage(false);
    }

    @Override // com.tencent.mobileqq.ar.view.ScanEntryProviderView
    public void C() {
        QLog.d("AREngine_QRScanEntryView", 1, "onPause ");
        super.C();
        m0();
        CameraProxy.v().p();
        ScanEntryProviderContainerView.i iVar = this.f198696d0;
        if (iVar != null) {
            iVar.a(3);
            this.f198697e0 = false;
        }
    }

    @Override // com.tencent.mobileqq.ar.view.ScanEntryProviderView
    public void D() {
        QLog.d("AREngine_QRScanEntryView", 1, "onProviderViewClose ");
        super.D();
        ((com.tencent.mobileqq.ar.model.b) this.f198782i).o0(false, 0L);
        CameraProxy.v().p();
        if (this.R) {
            CameraProxy.v().P(false);
        }
        ScanEntryProviderContainerView.i iVar = this.f198696d0;
        if (iVar != null) {
            iVar.a(3);
            this.f198697e0 = false;
        }
    }

    @Override // com.tencent.mobileqq.ar.view.ScanEntryProviderView
    public void E() {
        QLog.d("AREngine_QRScanEntryView", 1, "onProviderViewShow ");
        super.E();
        m0();
        ((IScanDaTongApi) QRoute.api(IScanDaTongApi.class)).setPageParams((ScanTorchActivity) this.f198780f, this, IScanDaTongApi.PAGE_ID_QR, this.W);
        if (y()) {
            e0();
            ScanEntryProviderContainerView.i iVar = this.f198696d0;
            if (iVar != null && !this.f198697e0) {
                iVar.a(2);
                this.f198697e0 = true;
            }
        }
    }

    @Override // com.tencent.mobileqq.ar.view.ScanEntryProviderView
    public void F() {
        QLog.d("AREngine_QRScanEntryView", 1, "onResume ");
        super.F();
        ((com.tencent.mobileqq.ar.model.b) this.f198782i).o0(true, 1000L);
        e0();
        ScanEntryProviderContainerView.i iVar = this.f198696d0;
        if (iVar != null && !this.f198697e0) {
            iVar.a(2);
            this.f198697e0 = true;
        }
    }

    @Override // com.tencent.mobileqq.ar.model.CameraProxy.a
    public void S3() {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_QRScanEntryView", 2, "onStartPreviewSuccess");
        }
        e0();
    }

    @Override // com.tencent.mobileqq.ar.arengine.aj
    public void a(long j3) {
        if (QLog.isColorLevel()) {
            QLog.i("AREngine_QRScanEntryView", 2, String.format("onSaveImg %d", Long.valueOf(j3)));
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.QRScanEntryView.6
            @Override // java.lang.Runnable
            public void run() {
                QRScanEntryView.this.V.setChecked(false);
                QQToast.makeText(QRScanEntryView.this.getContext(), HardCodeUtil.qqStr(R.string.red), 1).show();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_QRScanEntryView", 2, String.format("dispatchTouchEvent", new Object[0]) + dispatchTouchEvent);
        }
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.ar.arengine.ak
    public void f(final int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_QRScanEntryView", 2, String.format("onLuminanceChanged luminance=%d", Integer.valueOf(i3)));
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.QRScanEntryView.7
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                if (!QRScanEntryView.this.R) {
                    if (i3 <= y.a().f198848h) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (QRScanEntryView.this.Q != z16) {
                        QRScanEntryView.this.Q = z16;
                        QRScanEntryView.this.r0(false);
                    }
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.ar.arengine.ak
    public void o(final ScannerResult scannerResult, final byte[] bArr, final int i3, final int i16) {
        ScannerMultiResultSelectView scannerMultiResultSelectView;
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_QRScanEntryView", 2, String.format("onQRRecognizeSuccess results=%s", scannerResult));
        }
        if (this.D && this.f198780f != null && this.f198782i != null && ((scannerMultiResultSelectView = this.f198694b0) == null || !scannerMultiResultSelectView.isShowing())) {
            ((com.tencent.mobileqq.ar.model.b) this.f198782i).l0(true);
            final com.tencent.mobileqq.qrscan.h hVar = new com.tencent.mobileqq.qrscan.h();
            hVar.f276637a = bArr;
            hVar.f276638b = i3;
            hVar.f276639c = i16;
            ((com.tencent.mobileqq.ar.model.b) this.f198782i).l0(true);
            if (scannerResult.f276523h && bArr != null) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.ar.view.QRScanEntryView.5
                    @Override // java.lang.Runnable
                    public void run() {
                        ScannerResult scannerResult2;
                        Bitmap decodeBitmapFromYuv = ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeBitmapFromYuv(bArr, i3, i16);
                        if (decodeBitmapFromYuv != null) {
                            scannerResult2 = ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQQCodeFromBmp(decodeBitmapFromYuv, 3);
                        } else {
                            scannerResult2 = null;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("AREngine_QRScanEntryView", 2, "onRecognizeSuccess new result:" + scannerResult2 + " bitmap:" + decodeBitmapFromYuv);
                        }
                        QRScanEntryView.this.n0(scannerResult2, i3, i16);
                        if (QLog.isColorLevel()) {
                            QLog.d("AREngine_QRScanEntryView", 2, "onRecognizeSuccess rotate result:" + scannerResult2);
                        }
                        QRScanEntryView qRScanEntryView = QRScanEntryView.this;
                        if (scannerResult2 == null || !scannerResult2.m()) {
                            scannerResult2 = scannerResult;
                        }
                        qRScanEntryView.f0(scannerResult2, hVar, false);
                    }
                }, 16, null, true);
                return;
            } else {
                f0(scannerResult, hVar, false);
                return;
            }
        }
        QLog.d("AREngine_QRScanEntryView", 1, "QREntry has closed,so give up this result");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.jo_) {
            w();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.ar.arengine.ak
    public void s(boolean z16, float f16) {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_QRScanEntryView", 2, String.format("onQRRecognizeFail hasQR=%s qrAreaRatio=%s", Boolean.valueOf(z16), Float.valueOf(f16)));
        }
    }

    @Override // com.tencent.mobileqq.ar.view.ScanEntryProviderView
    public void setRectAreas(Rect rect) {
        com.tencent.mobileqq.ar.model.a aVar = this.f198782i;
        if (aVar != null) {
            ((com.tencent.mobileqq.ar.model.b) aVar).n0(rect);
        }
        this.L = rect;
        ViewfinderView viewfinderView = this.G;
        if (viewfinderView != null) {
            viewfinderView.setRect(rect);
        }
    }

    public void setVoiceScanStatusListener(ScanEntryProviderContainerView.i iVar) {
        this.f198696d0 = iVar;
    }

    @Override // com.tencent.mobileqq.ar.arengine.ak
    public void t(List<com.tencent.mobileqq.qrscan.a> list) {
        boolean z16;
        Object obj;
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[2];
            if (list.size() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            objArr[0] = Boolean.valueOf(z16);
            if (list.size() > 0) {
                obj = list.get(0).f276532b;
            } else {
                obj = "null";
            }
            objArr[1] = obj;
            QLog.i("AREngine_QRScanEntryView", 2, String.format("onMiniDetectResult suc=%b rect=%s", objArr));
        }
        if (this.D && this.G != null && ((IQRScanReportApi) QRoute.api(IQRScanReportApi.class)).isBaseTestSwitchOn()) {
            this.G.setDetectRect(list);
        }
    }

    @Override // com.tencent.mobileqq.ar.view.ScanEntryProviderView
    public boolean u() {
        ScannerMultiResultSelectView scannerMultiResultSelectView = this.f198694b0;
        if (scannerMultiResultSelectView != null && scannerMultiResultSelectView.isShowing()) {
            this.f198694b0.x();
            return true;
        }
        return super.u();
    }

    @Override // com.tencent.mobileqq.ar.view.ScanEntryProviderView
    public void x(final String str) {
        com.tencent.mobileqq.ar.model.a aVar;
        if (!TextUtils.isEmpty(str) && this.f198780f != null && (aVar = this.f198782i) != null) {
            ((com.tencent.mobileqq.ar.model.b) aVar).l0(true);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.ar.view.QRScanEntryView.4
                @Override // java.lang.Runnable
                public void run() {
                    ScannerResult decodeQQCodeFromFile = ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQQCodeFromFile(Uri.parse("file://" + str), QRScanEntryView.this.f198780f, 3, false);
                    if (QLog.isColorLevel()) {
                        QLog.d("AREngine_QRScanEntryView", 2, "doDealGalleryPicFile scannerResult:" + decodeQQCodeFromFile);
                    }
                    com.tencent.mobileqq.qrscan.h hVar = new com.tencent.mobileqq.qrscan.h();
                    hVar.f276640d = str;
                    QRScanEntryView.this.f0(decodeQQCodeFromFile, hVar, true);
                }
            }, 16, null, true);
        }
    }

    @Override // com.tencent.mobileqq.ar.view.ScanEntryProviderView
    public void z(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.F == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ard, (ViewGroup) this, true);
            this.M = (ViewGroup) findViewById(R.id.h0u);
            boolean isFeatureSwitchEnable = ((IFeatureRuntimeService) this.f198778d.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("qq_scan_qr_rect");
            ViewfinderView viewfinderView = (ViewfinderView) findViewById(R.id.h0x);
            this.G = viewfinderView;
            viewfinderView.setNeedHideRectCorner(isFeatureSwitchEnable);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.jo9);
            this.H = viewGroup;
            z81.e.d(this.f198780f, viewGroup);
            this.J = (TextView) findViewById(R.id.jo_);
            this.I = (TextView) findViewById(R.id.joc);
            this.J.setOnClickListener(this);
            if (ab.a()) {
                AccessibilityUtil.c(this.J, HardCodeUtil.qqStr(R.string.button_back), Button.class.getName());
            }
            this.K = (ViewGroup) findViewById(R.id.b_t);
            ((IScanDaTongApi) QRoute.api(IScanDaTongApi.class)).setMyQrCodeInfo(this.K, IScanDaTongApi.PAGE_ID_QR, false);
            if (this.W) {
                this.K.setVisibility(8);
            }
            findViewById(R.id.dwh).setOnTouchListener(this.f198698f0);
            this.K.setOnClickListener(new c());
            TextView textView = (TextView) findViewById(R.id.h0t);
            this.N = textView;
            if (this.W) {
                textView.setTextSize(16.0f);
            }
            TextView textView2 = (TextView) findViewById(R.id.h0i);
            this.P = textView2;
            textView2.setOnTouchListener(this.f198698f0);
            this.P.setOnClickListener(new d());
            this.F = inflate;
        }
        CameraProxy.v().M(this);
        com.tencent.mobileqq.ar.model.b bVar = new com.tencent.mobileqq.ar.model.b();
        this.f198782i = bVar;
        bVar.H(this.f198780f, this.f198778d);
        ((com.tencent.mobileqq.ar.model.b) this.f198782i).m0(this, this);
        this.V = (CheckBox) findViewById(R.id.axe);
        ((IQRScanReportApi) QRoute.api(IQRScanReportApi.class)).setSaveDetectImage(false);
        this.V.setChecked(false);
        if (((IQRScanReportApi) QRoute.api(IQRScanReportApi.class)).isBaseTestSwitchOn()) {
            this.V.setVisibility(0);
            this.V.setOnCheckedChangeListener(new e());
        }
        this.f198693a0 = ((IFeatureRuntimeService) this.f198778d.getRuntimeService(IFeatureRuntimeService.class, "tool")).isFeatureSwitchEnable("qrscan_tips_view_adjust");
        this.f198779e = true;
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_QRScanEntryView", 2, String.format("onCreate time cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f198719d;

        b(int i3) {
            this.f198719d = i3;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f198719d == 1) {
                QRScanEntryView.this.M.setVisibility(0);
            } else {
                QRScanEntryView.this.M.setVisibility(8);
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

    @Override // com.tencent.mobileqq.ar.model.CameraProxy.a
    public void R5(int i3, int i16) {
    }
}
