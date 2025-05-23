package com.tencent.gdtad.basics.motivevideo.motivepicture;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.GdtRewardTimeCounter;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.m;
import com.tencent.gdtad.basics.motivevideo.n;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.gdtad.basics.motivevideo.report.GdtAnalysisHelperForMotiveAd;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtImpressionReporter;
import com.tencent.gdtad.statistics.GdtOriginalExposureReporter;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.gdtad.util.GdtUtil;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.video.GdtVideoReportListenerImp;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import java.lang.ref.WeakReference;
import rm0.b;

/* loaded from: classes6.dex */
public class GdtMvPictureViewController implements b.a {
    private AdExposureChecker D;

    /* renamed from: a, reason: collision with root package name */
    private Context f109040a;

    /* renamed from: b, reason: collision with root package name */
    private GdtMotiveVideoModel f109041b;

    /* renamed from: c, reason: collision with root package name */
    private final n f109042c;

    /* renamed from: d, reason: collision with root package name */
    private View f109043d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f109044e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f109045f;

    /* renamed from: g, reason: collision with root package name */
    private RelativeLayout f109046g;

    /* renamed from: h, reason: collision with root package name */
    private QQCustomDialog f109047h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f109048i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f109049j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f109050k;

    /* renamed from: p, reason: collision with root package name */
    private String f109055p;

    /* renamed from: q, reason: collision with root package name */
    private long f109056q;

    /* renamed from: u, reason: collision with root package name */
    private int f109060u;

    /* renamed from: v, reason: collision with root package name */
    private com.tencent.gdtad.basics.motivevideo.motivepicture.b f109061v;

    /* renamed from: x, reason: collision with root package name */
    private GdtRewardTimeCounter f109063x;

    /* renamed from: y, reason: collision with root package name */
    private GdtVideoReportListenerImp f109064y;

    /* renamed from: l, reason: collision with root package name */
    private boolean f109051l = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f109052m = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f109053n = true;

    /* renamed from: o, reason: collision with root package name */
    private boolean f109054o = true;

    /* renamed from: r, reason: collision with root package name */
    private long f109057r = 0;

    /* renamed from: s, reason: collision with root package name */
    private long f109058s = 0;

    /* renamed from: t, reason: collision with root package name */
    private long f109059t = 5000;

    /* renamed from: w, reason: collision with root package name */
    private final rm0.b f109062w = new rm0.b();

    /* renamed from: z, reason: collision with root package name */
    private final com.tencent.gdtad.basics.motivevideo.report.d f109065z = new com.tencent.gdtad.basics.motivevideo.report.d();
    private final com.tencent.gdtad.basics.motivevideo.report.c A = new com.tencent.gdtad.basics.motivevideo.report.c();
    private final GdtThirdProcessorProxy B = new GdtThirdProcessorProxy();
    private final GdtImpressionReporter.GdtVideoReportInfo C = new GdtImpressionReporter.GdtVideoReportInfo();
    private AdExposureChecker.ExposureCallback E = null;
    private final Runnable F = new Runnable() { // from class: com.tencent.gdtad.basics.motivevideo.motivepicture.GdtMvPictureViewController.2
        @Override // java.lang.Runnable
        public void run() {
            GdtMvPictureViewController.this.f109057r += 100;
            if (GdtMvPictureViewController.this.f109057r == 2000 && GdtMvPictureViewController.this.f109061v != null) {
                GdtMvPictureViewController.this.f109061v.i();
            }
            if (GdtMvPictureViewController.this.f109057r == GdtMvPictureViewController.this.f109059t - 200 && GdtMvPictureViewController.this.f109061v != null) {
                GdtMvPictureViewController.this.f109061v.h();
            }
            if (GdtMvPictureViewController.this.f109057r == GdtMvPictureViewController.this.f109059t && GdtMvPictureViewController.this.f109061v != null) {
                GdtMvPictureViewController.this.f109061v.e();
            }
            if (GdtMvPictureViewController.this.f109057r == GdtMvPictureViewController.this.f109059t + 2000 && GdtMvPictureViewController.this.f109057r < GdtMvPictureViewController.this.f109056q * 1000 && GdtMvPictureViewController.this.f109061v != null) {
                GdtMvPictureViewController.this.f109061v.f();
            }
            if (GdtMvPictureViewController.this.f109057r == GdtMvPictureViewController.this.f109059t + 3000 && GdtMvPictureViewController.this.f109057r < GdtMvPictureViewController.this.f109056q * 1000 && GdtMvPictureViewController.this.f109061v != null) {
                GdtMvPictureViewController.this.f109061v.f();
            }
            if (GdtMvPictureViewController.this.f109058s == 200 && GdtMvPictureViewController.this.f109061v != null) {
                GdtMvPictureViewController.this.f109061v.d();
            }
            GdtMvPictureViewController gdtMvPictureViewController = GdtMvPictureViewController.this;
            gdtMvPictureViewController.n0(gdtMvPictureViewController.f109058s, (GdtMvPictureViewController.this.f109058s / 1000) + 1, GdtMvPictureViewController.this.f109057r);
            if (GdtMvPictureViewController.this.f109058s == 0) {
                GdtMvPictureViewController.this.f109050k = true;
                GdtMvPictureViewController.this.a0();
                GdtMvPictureViewController.this.T();
            }
            if (!GdtMvPictureViewController.this.f109052m) {
                GdtMvPictureViewController.this.g0();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements m {
        a() {
        }

        @Override // com.tencent.gdtad.basics.motivevideo.m
        public void a(long j3) {
            GdtMvPictureViewController.this.f109058s = j3;
            UiThreadUtil.runOnUiThread(GdtMvPictureViewController.this.F);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            GdtMvPictureViewController.this.i0();
            GdtMvPictureViewController.this.Z(GdtADFlyingStreamingReportHelper.EVENT_CODE_40062);
            GdtMvPictureViewController.this.d0(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            GdtMvPictureViewController.this.x();
            GdtMvPictureViewController.this.Z(GdtADFlyingStreamingReportHelper.EVENT_CODE_40092);
            GdtMvPictureViewController.this.d0(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class d implements DialogInterface.OnKeyListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
            if (i3 == 4 && keyEvent.getRepeatCount() == 0) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class e implements AdExposureChecker.ExposureCallback {
        e() {
        }

        @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
        public void onExposure(WeakReference<View> weakReference) {
            String str = new com.tencent.gdtad.basics.motivevideo.report.b().e(GdtMvPictureViewController.this.f109041b.getGdtAd().getUrlForImpression()) + "&slot=1";
            GdtReporter.doExposeCgiReport(str);
            QLog.d("GdtMvPictureViewController", 1, "AdExposureChecker exposure report url: " + str);
        }
    }

    public GdtMvPictureViewController(n nVar, GdtMotiveVideoModel gdtMotiveVideoModel, boolean z16) {
        boolean z17;
        boolean z18 = false;
        this.f109056q = 15L;
        this.f109060u = 0;
        this.f109042c = nVar;
        this.f109041b = gdtMotiveVideoModel;
        this.f109048i = z16;
        GdtMotiveVideoPageData gdtMotiveVideoPageData = gdtMotiveVideoModel.getGdtMotiveVideoPageData();
        gdtMotiveVideoPageData.style = 0;
        if (gdtMotiveVideoPageData.screenOrientation == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.f109049j = z17;
        this.f109060u = gdtMotiveVideoPageData.getType();
        this.f109056q = GdtUtil.getRewardTime(this.f109041b);
        this.f109055p = gdtMotiveVideoPageData.getRewardText();
        if (this.f109041b.getAdInfo() != null && this.f109041b.getAdInfo().exp_info.video_countdown_style.has()) {
            z18 = true;
        }
        QLog.i("GdtMvPictureViewController", 1, "GdtMpViewController: video_countdown = " + this.f109056q + ", video_countdown_style has = " + z18 + ", rewardText = " + this.f109055p);
    }

    private void D() {
        if (this.f109041b.getGdtAd() == null) {
            return;
        }
        long bigBottomAdCardShowTime = this.f109041b.getGdtAd().getBigBottomAdCardShowTime();
        if (bigBottomAdCardShowTime >= 5 && bigBottomAdCardShowTime <= this.f109056q) {
            this.f109059t = bigBottomAdCardShowTime * 1000;
        }
    }

    private void E() {
        GdtMotiveVideoPageData gdtMotiveVideoPageData = this.f109041b.getGdtMotiveVideoPageData();
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        if (this.f109040a != null && gdtMotiveVideoPageData != null) {
            URLDrawable.removeMemoryCacheByUrl(gdtMotiveVideoPageData.previewImgUrl, obtain);
            Drawable urlDrawable = GdtUIUtils.getUrlDrawable(this.f109040a.getResources(), gdtMotiveVideoPageData.previewImgUrl);
            ImageView imageView = this.f109045f;
            if (imageView != null && urlDrawable != null) {
                imageView.setImageDrawable(urlDrawable);
                F();
            }
        }
    }

    private void F() {
        ImageView imageView;
        if (this.f109046g != null && (imageView = this.f109045f) != null) {
            imageView.setVisibility(0);
            K(this.f109045f);
            Z(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020034);
            if (!this.f109049j) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f109046g.getLayoutParams();
            if (this.f109060u == 4) {
                layoutParams.addRule(12);
                layoutParams.bottomMargin = ViewUtils.dpToPx(334.0f);
                layoutParams.height = (int) (ViewUtils.getScreenWidth() * 0.5625f);
            }
            this.f109046g.requestLayout();
        }
    }

    private void G() {
        if (this.f109044e == null) {
            return;
        }
        GdtMotiveVideoPageData gdtMotiveVideoPageData = this.f109041b.getGdtMotiveVideoPageData();
        if (this.f109040a != null && gdtMotiveVideoPageData != null) {
            this.f109044e.setImageDrawable(this.B.getPreViewImage(this.f109040a, Uri.parse(gdtMotiveVideoPageData.previewImgUrl).buildUpon().appendQueryParameter(VasProfileTemplatePreloadHelper.BACKGROUND, "blur").build().toString()));
        }
    }

    private void H() {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.f109043d.getContext(), 0, (String) null, "", HardCodeUtil.qqStr(R.string.n1e), HardCodeUtil.qqStr(R.string.n1b), new b(), new c());
        this.f109047h = createCustomDialog;
        createCustomDialog.setOnKeyListener(new d());
    }

    private void I() {
        long j3 = this.f109056q * 1000;
        this.f109058s = j3;
        GdtRewardTimeCounter gdtRewardTimeCounter = new GdtRewardTimeCounter(j3, new a());
        this.f109063x = gdtRewardTimeCounter;
        gdtRewardTimeCounter.g(100L);
    }

    private void J() {
        GdtMotiveVideoModel gdtMotiveVideoModel = this.f109041b;
        if (gdtMotiveVideoModel == null) {
            return;
        }
        this.f109062w.h(this.f109043d, this, gdtMotiveVideoModel);
        this.f109062w.b(this.f109042c.getActivity(), this.f109049j);
        this.f109062w.f();
    }

    private void K(View view) {
        QLog.d("GdtMvPictureViewController", 1, "initExpoReport isFirst=", Boolean.valueOf(this.f109053n));
        if (this.f109053n && view != null) {
            this.f109053n = false;
            this.D = new AdExposureChecker(this.f109041b.getGdtAd(), new WeakReference(view));
            this.E = new e();
            this.D.setCallback(new WeakReference<>(this.E));
            this.D.startCheck();
            f0(0, NetConnInfoCenter.getServerTime());
        }
    }

    private void L() {
        if (this.f109061v != null) {
            this.f109064y = new GdtVideoReportListenerImp(11);
            this.C.setPlayType(11);
        } else {
            QLog.e("GdtMvPictureViewController", 1, "initVideoReport error");
        }
    }

    private View M(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        try {
            if (this.f109049j) {
                this.f109043d = layoutInflater.inflate(R.layout.ecz, viewGroup, false);
            } else {
                this.f109043d = layoutInflater.inflate(R.layout.ecy, viewGroup, false);
            }
            View view = this.f109043d;
            if (view == null) {
                return null;
            }
            GdtUIUtils.setNightThemeByView(view.findViewById(R.id.f_1));
            com.tencent.gdtad.basics.motivevideo.motivepicture.b bVar = new com.tencent.gdtad.basics.motivevideo.motivepicture.b(this, this.f109043d, this.f109041b, this.B);
            this.f109061v = bVar;
            bVar.D(this.f109065z);
            this.f109061v.C(this.f109049j);
            this.f109061v.B(this.f109060u);
            this.f109061v.t();
            this.f109044e = (ImageView) this.f109043d.findViewById(R.id.f163990fp);
            this.f109046g = (RelativeLayout) this.f109043d.findViewById(R.id.vmj);
            this.f109045f = (ImageView) this.f109043d.findViewById(R.id.vmk);
            return this.f109043d;
        } catch (Exception e16) {
            QLog.e("GdtMvPictureViewController", 1, "initViews error:", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        n0(0L, 0L, 0L);
        m0(0L, true);
        k0();
        h0();
        this.A.c();
        this.A.d();
    }

    private void X() {
        if (this.f109048i) {
            R();
            Q();
        }
    }

    private void Y() {
        GdtADFlyingStreamingReportHelper.getInstance().setShowCardStatus(1);
        Z(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020030);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(long j3) {
        GdtADFlyingStreamingReportHelper.getInstance().reportADEvent(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        if (!this.f109051l) {
            QLog.d("GdtMvPictureViewController", 1, "reportAchieveReward");
            Z(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020012);
            f0(2, NetConnInfoCenter.getServerTime());
            this.f109051l = true;
        }
    }

    private void b0() {
        Activity activity;
        n nVar = this.f109042c;
        GdtMotiveVideoPageData gdtMotiveVideoPageData = null;
        if (nVar != null) {
            activity = nVar.getActivity();
        } else {
            activity = null;
        }
        GdtMotiveVideoModel gdtMotiveVideoModel = this.f109041b;
        if (gdtMotiveVideoModel != null) {
            gdtMotiveVideoPageData = gdtMotiveVideoModel.getGdtMotiveVideoPageData();
        }
        if (gdtMotiveVideoPageData != null && activity != null) {
            GdtAnalysisHelperForMotiveAd.c(this.f109040a, gdtMotiveVideoPageData, Integer.MIN_VALUE, Integer.MIN_VALUE, false);
        } else {
            GdtLog.e("GdtMvPictureViewController", "[reportForMotiveClose] report params error");
        }
    }

    private void c0() {
        Activity activity;
        n nVar = this.f109042c;
        GdtMotiveVideoPageData gdtMotiveVideoPageData = null;
        if (nVar != null) {
            activity = nVar.getActivity();
        } else {
            activity = null;
        }
        GdtMotiveVideoModel gdtMotiveVideoModel = this.f109041b;
        if (gdtMotiveVideoModel != null) {
            gdtMotiveVideoPageData = gdtMotiveVideoModel.getGdtMotiveVideoPageData();
        }
        if (gdtMotiveVideoPageData != null && activity != null && activity.getIntent() != null) {
            Intent intent = activity.getIntent();
            long j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            long longExtra = intent.getLongExtra("key_motive_show_start_time", WebViewConstants.WV.ENABLE_WEBAIO_SWITCH);
            Context context = this.f109040a;
            if (longExtra != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
                j3 = System.currentTimeMillis() - longExtra;
            }
            GdtAnalysisHelperForMotiveAd.d(context, gdtMotiveVideoPageData, j3, false);
            return;
        }
        GdtLog.e("GdtMvPictureViewController", "[reportForMotiveViewShow] report params error");
    }

    private void e0() {
        this.A.f(this.f109056q * 1000);
        this.A.e(this.f109056q);
        d0(11);
    }

    private void f0(int i3, long j3) {
        String str;
        String str2 = "";
        if (this.f109065z == null) {
            return;
        }
        try {
            GdtMotiveVideoPageData gdtMotiveVideoPageData = this.f109041b.getGdtMotiveVideoPageData();
            GdtAd gdtAd = this.f109041b.getGdtAd();
            if (gdtAd == null) {
                str = "";
            } else {
                str = String.valueOf(gdtAd.getAId());
            }
            if (gdtMotiveVideoPageData != null) {
                try {
                    str2 = gdtMotiveVideoPageData.appId;
                } catch (Exception unused) {
                    QLog.e("GdtMvPictureViewController", 1, "get adInfo aId and appId fail");
                    com.tencent.gdtad.basics.motivevideo.report.d dVar = this.f109065z;
                    dVar.a(i3, j3, str, str2);
                }
            }
        } catch (Exception unused2) {
            str = "";
        }
        com.tencent.gdtad.basics.motivevideo.report.d dVar2 = this.f109065z;
        dVar2.a(i3, j3, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0() {
        GdtVideoReportListenerImp gdtVideoReportListenerImp;
        GdtVideoData gdtVideoData = this.f109041b.getGdtVideoData();
        if (gdtVideoData != null && (gdtVideoReportListenerImp = this.f109064y) != null) {
            this.f109052m = true;
            gdtVideoReportListenerImp.onStarted(gdtVideoData, 0L);
        }
    }

    private void h0() {
        GdtVideoReportListenerImp gdtVideoReportListenerImp;
        GdtVideoData gdtVideoData = this.f109041b.getGdtVideoData();
        if (gdtVideoData != null && (gdtVideoReportListenerImp = this.f109064y) != null) {
            if (this.f109050k) {
                gdtVideoData.setDurationMillis(this.f109056q * 1000);
                this.f109064y.onCompleted(gdtVideoData, this.C);
            } else {
                gdtVideoReportListenerImp.onStopped(gdtVideoData, this.f109057r, this.C);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        QLog.i("GdtMvPictureViewController", 4, "[resumeVideoPlayer]");
        GdtRewardTimeCounter gdtRewardTimeCounter = this.f109063x;
        if (gdtRewardTimeCounter != null) {
            gdtRewardTimeCounter.i();
        }
        if (GdtADFlyingStreamingReportHelper.getInstance().getShowCardStatus() == 1) {
            Z(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020041);
        } else {
            Z(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020011);
        }
    }

    private void j0() {
        GdtAd gdtAd;
        QQCustomDialog qQCustomDialog = this.f109047h;
        if (qQCustomDialog != null && !qQCustomDialog.isShowing()) {
            com.tencent.gdtad.basics.motivevideo.b bVar = com.tencent.gdtad.basics.motivevideo.b.f108898a;
            GdtMotiveVideoModel gdtMotiveVideoModel = this.f109041b;
            if (gdtMotiveVideoModel != null) {
                gdtAd = gdtMotiveVideoModel.getGdtAd();
            } else {
                gdtAd = null;
            }
            String b16 = bVar.b(gdtAd, this.f109056q);
            if (TextUtils.isEmpty(b16)) {
                StringBuilder sb5 = new StringBuilder(HardCodeUtil.qqStr(R.string.f13788082));
                if (TextUtils.isEmpty(this.f109055p)) {
                    sb5.append(HardCodeUtil.qqStr(R.string.f13787081));
                } else {
                    sb5.append(this.f109055p);
                }
                b16 = HardCodeUtil.qqStr(R.string.n1_) + this.f109056q + sb5.toString();
            }
            this.f109047h.setMessage(b16);
            this.f109047h.show();
            Window window = this.f109047h.getWindow();
            if (window != null) {
                window.getDecorView().setSystemUiVisibility(7942);
            }
            Z(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020029);
            d0(9);
        }
    }

    private void k0() {
        com.tencent.gdtad.basics.motivevideo.motivepicture.b bVar = this.f109061v;
        if (bVar == null) {
            return;
        }
        bVar.F();
        Z(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020035);
        GdtADFlyingStreamingReportHelper.getInstance().setShowCardStatus(2);
        d0(10);
    }

    private void l0() {
        GdtRewardTimeCounter gdtRewardTimeCounter = this.f109063x;
        if (gdtRewardTimeCounter != null) {
            gdtRewardTimeCounter.j();
        }
    }

    private void o0() {
        l0();
        h0();
        Z(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020010);
        this.f109052m = false;
    }

    private void w() {
        GdtMotiveVideoModel gdtMotiveVideoModel = this.f109041b;
        if (gdtMotiveVideoModel != null && gdtMotiveVideoModel.getGdtAd() != null && this.f109041b.getGdtAd().isValid()) {
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).preLoadAfterAdLoaded(this.f109040a, this.f109041b.getGdtAd());
        } else {
            QLog.e("GdtMvPictureViewController", 1, "doAdPreload error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        QLog.i("GdtMvPictureViewController", 4, "[finish]");
        if (this.f109042c == null) {
            return;
        }
        b0();
        this.f109042c.finish();
        if (GdtADFlyingStreamingReportHelper.getInstance().getShowCardStatus() == 1) {
            Z(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020040);
        }
    }

    public long A() {
        return this.f109057r;
    }

    public GdtImpressionReporter.GdtVideoReportInfo B() {
        return this.C;
    }

    public View C(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View M = M(layoutInflater, viewGroup);
        if (M == null) {
            QLog.i("GdtMvPictureViewController", 1, "GdtMvViewController init:rootView==null error");
            return null;
        }
        this.f109040a = M.getContext();
        w();
        L();
        I();
        D();
        J();
        H();
        E();
        G();
        GdtADFlyingStreamingReportHelper.getInstance().init(this.f109041b);
        Y();
        Z(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020033);
        Z(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020006);
        c0();
        e0();
        if (this.f109054o) {
            GdtOriginalExposureReporter.reportOriginalExposure(this.f109041b.getGdtAd(), this.f109040a, 1);
            this.f109054o = false;
        }
        return M;
    }

    public boolean N() {
        return this.f109050k;
    }

    public boolean O() {
        return W(false);
    }

    public void P() {
        QLog.i("GdtMvPictureViewController", 1, "[onCreate]");
        ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplication.getContext(), false, 55);
    }

    public void Q() {
        com.tencent.gdtad.basics.motivevideo.motivepicture.b bVar = this.f109061v;
        if (bVar != null) {
            bVar.x();
        }
    }

    public void R() {
        S(true);
    }

    public void S(boolean z16) {
        this.f109052m = false;
        if (!this.f109050k) {
            h0();
        }
        com.tencent.gdtad.basics.motivevideo.motivepicture.b bVar = this.f109061v;
        if (bVar != null) {
            bVar.y();
        }
        if (z16) {
            l0();
        }
    }

    public void U() {
        GdtRewardTimeCounter gdtRewardTimeCounter = this.f109063x;
        if (gdtRewardTimeCounter != null && !this.f109050k) {
            gdtRewardTimeCounter.h(true);
            this.f109063x.i();
        }
    }

    public void V() {
        l0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean W(boolean z16) {
        int i3 = 1;
        QLog.i("GdtMvPictureViewController", 1, "[onBackEvent] mHasWatchAds " + this.f109050k);
        if (z16) {
            try {
                if (this.f109050k) {
                    d0(4);
                    i3 = 0;
                } else {
                    o0();
                    GdtMotiveVideoModel gdtMotiveVideoModel = this.f109041b;
                    if (gdtMotiveVideoModel != null && gdtMotiveVideoModel.canShowCustomDialog()) {
                        j0();
                    } else {
                        x();
                    }
                }
            } catch (Throwable th5) {
                QLog.e("GdtMvPictureViewController", i3, "show dialog err, errInfo->" + th5.getMessage());
                return false;
            }
        }
        return i3;
    }

    @Override // rm0.b.a
    public void b() {
        QLog.i("GdtMvPictureViewController", 1, "onClick close_ads");
        if (GdtADFlyingStreamingReportHelper.getInstance().getShowCardStatus() == 2) {
            Z(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020016);
        } else {
            Z(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020028);
        }
        if (!W(true)) {
            b0();
            this.f109042c.finish();
        }
    }

    public void d0(int i3) {
        this.A.b(i3, this.f109057r);
    }

    protected void m0(long j3, boolean z16) {
        this.f109062w.m(j3, z16);
    }

    protected void n0(long j3, long j16, long j17) {
        this.f109062w.n(j3, j16, j17);
    }

    public void u() {
        v("");
    }

    public void v(String str) {
        GdtMotiveVideoPageData gdtMotiveVideoPageData = this.f109041b.getGdtMotiveVideoPageData();
        QLog.i("GdtMvPictureViewController", 1, "GDT beforeFinish call stack:", new Throwable());
        Intent intent = new Intent();
        if (gdtMotiveVideoPageData != null && gdtMotiveVideoPageData.supportOpenMotiveAd) {
            intent.putExtra("profitable_flag", this.f109050k);
            intent.putExtra("arg_callback", gdtMotiveVideoPageData.getAsyncCallbackId());
            QLog.i("GdtMvPictureViewController", 1, "[beforeFinish] mHasWatchAds" + this.f109050k);
        } else {
            intent.putExtra(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_END_DURATION_TIME, this.f109056q * 1000);
            intent.putExtra("elapsed_time", this.f109057r);
            intent.putExtra("profitable_flag", this.f109050k);
            intent.putExtra("is_end", this.f109050k);
            if (!this.f109050k) {
                intent.putExtra("elapsed_time", this.f109057r);
            }
            QLog.d("GdtMvPictureViewController", 1, "[beforeFinish] " + this.f109057r + " /" + (this.f109056q * 1000));
            this.B.doCallbackBeforeFinish(gdtMotiveVideoPageData, this.f109056q * 1000, this.f109057r, this.f109050k);
        }
        this.B.addReadInJoyCb(intent, str);
        this.f109042c.setResult(-1, intent);
        X();
    }

    public boolean y() {
        return this.f109062w.c();
    }

    public n z() {
        return this.f109042c;
    }

    @Override // rm0.b.a
    public void a() {
    }

    @Override // rm0.b.a
    public void c() {
    }
}
