package com.tencent.gdtad.basics.motivevideo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.ad.tangram.toast.AdToast;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.gdtad.basics.motivevideo.report.GdtAnalysisHelperForMotiveAd;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtImpressionPolicy;
import com.tencent.gdtad.statistics.GdtImpressionReporter;
import com.tencent.gdtad.statistics.GdtOriginalExposureReporter;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.gdtad.util.GdtUtil;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.video.GdtVideoReportListenerImp;
import com.tencent.gdtad.volume.VolumeChangeObserver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import rm0.b;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtMvVideoViewController implements b.a {
    private AudioManager B;
    private SilentModeReceiver D;
    private VolumeChangeObserver E;
    private boolean G;

    /* renamed from: a, reason: collision with root package name */
    private final n f108853a;

    /* renamed from: b, reason: collision with root package name */
    private View f108854b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f108855c;

    /* renamed from: d, reason: collision with root package name */
    private GdtRewardTimeCounter f108856d;

    /* renamed from: h, reason: collision with root package name */
    private long f108860h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f108861i;

    /* renamed from: k, reason: collision with root package name */
    private boolean f108863k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f108864l;

    /* renamed from: m, reason: collision with root package name */
    private RelativeLayout f108865m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f108866n;

    /* renamed from: o, reason: collision with root package name */
    private long f108867o;

    /* renamed from: p, reason: collision with root package name */
    private String f108868p;

    /* renamed from: q, reason: collision with root package name */
    private g f108869q;

    /* renamed from: s, reason: collision with root package name */
    private QQCustomDialog f108871s;

    /* renamed from: t, reason: collision with root package name */
    private GdtVideoReportListenerImp f108872t;

    /* renamed from: v, reason: collision with root package name */
    private Context f108874v;

    /* renamed from: x, reason: collision with root package name */
    private GdtMotiveVideoModel f108876x;

    /* renamed from: y, reason: collision with root package name */
    private com.tencent.gdtad.basics.motivevideo.d f108877y;

    /* renamed from: z, reason: collision with root package name */
    private GdtAd f108878z;

    /* renamed from: e, reason: collision with root package name */
    private long f108857e = 0;

    /* renamed from: f, reason: collision with root package name */
    private long f108858f = 0;

    /* renamed from: g, reason: collision with root package name */
    private Handler f108859g = new Handler(Looper.getMainLooper());

    /* renamed from: j, reason: collision with root package name */
    boolean f108862j = false;

    /* renamed from: r, reason: collision with root package name */
    public int f108870r = 0;

    /* renamed from: u, reason: collision with root package name */
    private boolean f108873u = false;

    /* renamed from: w, reason: collision with root package name */
    private boolean f108875w = false;
    private final List<com.tencent.gdtad.basics.motivevideo.d> A = Collections.synchronizedList(new ArrayList());
    private boolean C = false;
    private boolean F = true;
    public final rm0.b H = new rm0.b();
    public final com.tencent.gdtad.basics.motivevideo.report.d I = new com.tencent.gdtad.basics.motivevideo.report.d();
    private int J = 0;
    private int K = 0;
    private long L = 0;
    private int M = 0;
    private volatile boolean N = false;
    private volatile boolean O = false;
    private final GdtImpressionReporter.GdtVideoReportInfo P = new GdtImpressionReporter.GdtVideoReportInfo();
    private final com.tencent.gdtad.basics.motivevideo.report.c Q = new com.tencent.gdtad.basics.motivevideo.report.c();
    public GdtThirdProcessorProxy R = new GdtThirdProcessorProxy();
    private boolean S = true;
    private final k T = new d();
    private long U = 0;
    private boolean V = false;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class SilentModeReceiver extends BroadcastReceiver {
        public SilentModeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z16 = true;
            if (GdtMvVideoViewController.this.F) {
                GdtMvVideoViewController.this.F = false;
                QLog.i("GdtMvVideoViewController", 1, "SilentModeReceiver first auto called! so skip!");
                return;
            }
            if (GdtMvVideoViewController.this.B != null && "android.media.RINGER_MODE_CHANGED".equalsIgnoreCase(intent.getAction()) && GdtMvVideoViewController.this.f108877y != null) {
                int ringerMode = GdtMvVideoViewController.this.B.getRingerMode();
                int streamVolume = SystemMethodProxy.getStreamVolume(GdtMvVideoViewController.this.B, 3);
                QLog.i("GdtMvVideoViewController", 1, "system context mode: " + ringerMode + ", streamVolume = " + streamVolume);
                if (ringerMode != 2) {
                    GdtMvVideoViewController.this.C = true;
                    GdtMvVideoViewController gdtMvVideoViewController = GdtMvVideoViewController.this;
                    if (!com.tencent.gdtad.basics.motivevideo.b.f108898a.c() && streamVolume > 0) {
                        z16 = false;
                    }
                    gdtMvVideoViewController.f108862j = z16;
                    GdtMvVideoViewController.this.f108877y.A(GdtMvVideoViewController.this.f108862j);
                } else {
                    GdtMvVideoViewController.this.C = false;
                    if (streamVolume > 0) {
                        GdtMvVideoViewController.this.f108862j = false;
                    }
                    GdtMvVideoViewController.this.f108877y.A(GdtMvVideoViewController.this.f108862j);
                }
                GdtMvVideoViewController gdtMvVideoViewController2 = GdtMvVideoViewController.this;
                gdtMvVideoViewController2.B0(streamVolume, gdtMvVideoViewController2.f108875w, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            GdtMvVideoViewController.this.z0();
            GdtMvVideoViewController.this.p0(GdtADFlyingStreamingReportHelper.EVENT_CODE_40062);
            GdtMvVideoViewController.this.u0(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            GdtMvVideoViewController.this.I();
            GdtMvVideoViewController.this.p0(GdtADFlyingStreamingReportHelper.EVENT_CODE_40092);
            GdtMvVideoViewController.this.u0(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnKeyListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
            if (i3 == 4 && keyEvent.getRepeatCount() == 0) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class d implements k {
        d() {
        }

        @Override // com.tencent.gdtad.basics.motivevideo.k
        public void a(int i3, int i16, int i17, String str) {
            GdtMvVideoViewController.this.K0(i3, i16, i17, str);
        }

        @Override // com.tencent.gdtad.basics.motivevideo.k
        public void b(long j3, long j16) {
            GdtMvVideoViewController.this.L0(j3, j16);
        }

        @Override // com.tencent.gdtad.basics.motivevideo.k
        public void c() {
            GdtMvVideoViewController.this.s0();
        }

        @Override // com.tencent.gdtad.basics.motivevideo.k
        public void d(long j3) {
            GdtMvVideoViewController.this.J0(j3);
        }

        @Override // com.tencent.gdtad.basics.motivevideo.k
        public void onVideoPlayStart() {
            GdtMvVideoViewController.this.y0(!r0.f108862j);
            GdtMvVideoViewController.this.l0();
        }
    }

    public GdtMvVideoViewController(n nVar, GdtMotiveVideoModel gdtMotiveVideoModel, boolean z16) {
        this.f108853a = nVar;
        this.f108876x = gdtMotiveVideoModel;
        if (gdtMotiveVideoModel == null) {
            return;
        }
        this.f108878z = gdtMotiveVideoModel.getGdtAd();
        this.G = z16;
        GdtMotiveVideoPageData gdtMotiveVideoPageData = this.f108876x.getGdtMotiveVideoPageData();
        gdtMotiveVideoPageData.style = 0;
        this.f108861i = gdtMotiveVideoPageData.screenOrientation == 1;
        this.f108867o = GdtUtil.getRewardTime(this.f108876x);
        this.f108868p = gdtMotiveVideoPageData.getRewardText();
        QLog.i("GdtMvVideoViewController", 1, "GdtMvViewController: video_countdown = " + this.f108867o + ", video_countdown_style has = " + this.f108876x.getAdInfo().exp_info.video_countdown_style.has() + ", rewardText = " + this.f108868p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(int i3, boolean z16, boolean z17) {
        QLog.i("GdtMvVideoViewController", 1, "setVoiceIconState volume =" + i3 + " mVideoPlayer " + this.f108877y + " isFromVolumeChanged = " + z17 + ", mIsMute = " + this.f108862j + ", viewResumed = " + z16 + ", mIsVideoPlayCompleted = " + this.f108866n);
        if (z16 && this.f108877y != null) {
            l0();
            if (!this.f108866n) {
                y0(!this.f108862j);
            }
        }
    }

    private void C(int i3) {
        if (SystemClock.uptimeMillis() - this.U >= 800 && i3 != this.f108870r && this.f108869q != null) {
            this.f108870r = i3;
            this.U = SystemClock.uptimeMillis();
            this.f108869q.p(i3);
        }
    }

    private void C0() {
        QQCustomDialog qQCustomDialog = this.f108871s;
        if (qQCustomDialog != null && !qQCustomDialog.isShowing()) {
            String b16 = com.tencent.gdtad.basics.motivevideo.b.f108898a.b(this.f108878z, Math.min(this.f108867o, this.f108860h / 1000));
            if (TextUtils.isEmpty(b16)) {
                StringBuilder sb5 = new StringBuilder(HardCodeUtil.qqStr(R.string.f13788082));
                if (TextUtils.isEmpty(this.f108868p)) {
                    sb5.append(HardCodeUtil.qqStr(R.string.f13787081));
                } else {
                    sb5.append(this.f108868p);
                }
                if (this.f108860h > this.f108867o * 1000) {
                    b16 = HardCodeUtil.qqStr(R.string.n1_) + this.f108867o + sb5.toString();
                } else {
                    b16 = HardCodeUtil.qqStr(R.string.n1a);
                }
            }
            this.f108871s.setMessage(b16);
            this.f108871s.show();
            Window window = this.f108871s.getWindow();
            if (window != null) {
                window.getDecorView().setSystemUiVisibility(7942);
            }
            p0(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020029);
            u0(9);
        }
    }

    private void F() {
        GdtMotiveVideoModel gdtMotiveVideoModel = this.f108876x;
        if (gdtMotiveVideoModel == null) {
            return;
        }
        G(gdtMotiveVideoModel);
    }

    private void G(GdtMotiveVideoModel gdtMotiveVideoModel) {
        if (this.f108876x == null) {
            return;
        }
        if (gdtMotiveVideoModel != null && gdtMotiveVideoModel.getGdtAd() != null && gdtMotiveVideoModel.getGdtAd().isValid()) {
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).preLoadAfterAdLoaded(this.f108874v, gdtMotiveVideoModel.getGdtAd());
        } else {
            QLog.e("GdtMvVideoViewController", 1, "doAdPreload error");
        }
    }

    private void H(boolean z16) {
        com.tencent.gdtad.basics.motivevideo.d dVar;
        GdtVideoReportListenerImp gdtVideoReportListenerImp;
        QLog.i("GdtMvVideoViewController", 1, "[doPauseAction] mIsVideoPlayCompleted:" + this.f108866n);
        GdtVideoData gdtVideoData = this.f108876x.getGdtVideoData();
        y0(false);
        if (!this.f108866n && (dVar = this.f108877y) != null) {
            this.f108873u = false;
            if (dVar.s() && (gdtVideoReportListenerImp = this.f108872t) != null && gdtVideoData != null) {
                gdtVideoReportListenerImp.onStopped(gdtVideoData, this.f108877y.k(), this.P);
            }
            this.f108877y.v();
            if (z16) {
                F0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        QLog.i("GdtMvVideoViewController", 4, "[finish]");
        if (this.f108853a == null) {
            return;
        }
        r0();
        this.f108853a.finish();
        if (GdtADFlyingStreamingReportHelper.getInstance().getShowCardStatus() == 1) {
            p0(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020040);
        }
    }

    private void J() {
        GdtMotiveVideoModel gdtMotiveVideoModel;
        if (this.f108861i && (gdtMotiveVideoModel = this.f108876x) != null && gdtMotiveVideoModel.getGdtMotiveVideoPageData() != null && AppSetting.o(this.f108874v)) {
            this.H.a();
        }
    }

    private void O() {
        Handler handler = this.f108859g;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.gdtad.basics.motivevideo.GdtMvVideoViewController.9
                @Override // java.lang.Runnable
                public void run() {
                    boolean z16;
                    int streamVolume = SystemMethodProxy.getStreamVolume(GdtMvVideoViewController.this.B, 3);
                    if (GdtMvVideoViewController.this.f108877y != null) {
                        GdtMvVideoViewController gdtMvVideoViewController = GdtMvVideoViewController.this;
                        if (streamVolume <= 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        gdtMvVideoViewController.f108862j = z16;
                        gdtMvVideoViewController.f108877y.A(GdtMvVideoViewController.this.f108862j);
                    }
                    GdtMvVideoViewController gdtMvVideoViewController2 = GdtMvVideoViewController.this;
                    gdtMvVideoViewController2.B0(streamVolume, gdtMvVideoViewController2.f108875w, true);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.f108854b.getContext(), 0, (String) null, "", HardCodeUtil.qqStr(R.string.n1e), HardCodeUtil.qqStr(R.string.n1b), new a(), new b());
        this.f108871s = createCustomDialog;
        createCustomDialog.setOnKeyListener(new c());
    }

    private void R() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.gdtad.basics.motivevideo.i
            @Override // java.lang.Runnable
            public final void run() {
                GdtMvVideoViewController.this.Q();
            }
        });
    }

    private void S() {
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = this.f108876x.getAdInfo();
        boolean has = adInfo.exp_info.video_volume.has();
        int i3 = adInfo.exp_info.video_volume.get();
        boolean z16 = true;
        QLog.i("GdtMvVideoViewController", 1, "[initMute] videoVolume = " + i3 + ",isHasVideoVolume = " + has);
        if (!has || i3 != 0) {
            z16 = false;
        }
        this.f108862j = z16;
    }

    private void T(final GdtMotiveVideoModel gdtMotiveVideoModel) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.gdtad.basics.motivevideo.GdtMvVideoViewController.5
            @Override // java.lang.Runnable
            public void run() {
                GdtMotiveVideoPageData gdtMotiveVideoPageData = gdtMotiveVideoModel.getGdtMotiveVideoPageData();
                if (GdtMvVideoViewController.this.f108874v != null && gdtMotiveVideoPageData != null) {
                    String str = gdtMotiveVideoPageData.previewImgUrl;
                    try {
                        str = Uri.parse(str).buildUpon().appendQueryParameter(VasProfileTemplatePreloadHelper.BACKGROUND, "blur").build().toString();
                    } catch (Throwable th5) {
                        QLog.e("GdtMvVideoViewController", 1, "initPreViewImage error:", th5);
                    }
                    GdtMvVideoViewController gdtMvVideoViewController = GdtMvVideoViewController.this;
                    Drawable preViewImage = gdtMvVideoViewController.R.getPreViewImage(gdtMvVideoViewController.f108874v, str);
                    if (GdtMvVideoViewController.this.f108855c != null && preViewImage != null) {
                        GdtMvVideoViewController.this.f108855c.setImageDrawable(preViewImage);
                    }
                }
            }
        });
    }

    private void U() {
        if (this.f108869q != null) {
            this.f108872t = new GdtVideoReportListenerImp(11);
        } else {
            QLog.i("GdtMvVideoViewController", 1, " initReports error");
        }
    }

    private void V() {
        long min = Math.min(this.f108867o * 1000, this.L);
        this.f108858f = min;
        this.f108856d = new GdtRewardTimeCounter(min, new m() { // from class: com.tencent.gdtad.basics.motivevideo.GdtMvVideoViewController.1
            @Override // com.tencent.gdtad.basics.motivevideo.m
            public void a(long j3) {
                GdtMvVideoViewController.this.f108858f = j3;
                if (GdtMvVideoViewController.this.f108858f <= 0) {
                    GdtMvVideoViewController.this.f108863k = true;
                    QLog.d("GdtMvVideoViewController", 1, "onRewardTimeLeft 0 mHasWatchAds:" + GdtMvVideoViewController.this.f108863k);
                    GdtMvVideoViewController.this.q0();
                    GdtMvVideoViewController.this.Q.d();
                    if (GdtMvVideoViewController.this.f108856d != null) {
                        GdtMvVideoViewController.this.f108856d.j();
                    }
                }
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.gdtad.basics.motivevideo.GdtMvVideoViewController.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GdtMvVideoViewController gdtMvVideoViewController = GdtMvVideoViewController.this;
                        gdtMvVideoViewController.H0(gdtMvVideoViewController.f108858f, GdtMvVideoViewController.this.f108858f / 1000, GdtMvVideoViewController.this.f108857e);
                    }
                });
            }
        });
    }

    private void X() {
        long j3;
        com.tencent.gdtad.basics.motivevideo.d dVar = new com.tencent.gdtad.basics.motivevideo.d(this.f108874v, this.f108865m, this.f108876x, this.T);
        this.f108877y = dVar;
        dVar.B(this.J, this.f108862j);
        this.A.add(this.f108877y);
        this.P.setPlayType(11);
        if (this.f108876x.getAdInfo() != null) {
            j3 = this.f108876x.getAdInfo().display_info.video_info.media_duration.get() * 1000;
        } else {
            j3 = 0;
        }
        this.f108860h = j3;
    }

    private void Y() {
        GdtMotiveVideoModel gdtMotiveVideoModel = this.f108876x;
        if (gdtMotiveVideoModel != null && gdtMotiveVideoModel.getAdInfo() != null) {
            this.L = this.f108876x.getAdInfo().display_info.video_info.media_duration.get() * 1000;
        }
    }

    @Nullable
    private View Z(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        int i3;
        try {
            this.f108876x.getGdtMotiveVideoPageData();
            com.tencent.mobileqq.ad.debug.a aVar = com.tencent.mobileqq.ad.debug.a.f186830a;
            if (aVar.f()) {
                this.M = aVar.g();
            } else {
                GdtAd gdtAd = this.f108878z;
                if (gdtAd != null) {
                    i3 = gdtAd.getAdCardStyle();
                } else {
                    i3 = 1;
                }
                this.M = i3;
            }
            if (this.f108861i) {
                this.f108854b = layoutInflater.inflate(R.layout.ecn, viewGroup, false);
            } else {
                this.f108854b = layoutInflater.inflate(R.layout.ecm, viewGroup, false);
            }
            View view = this.f108854b;
            if (view == null) {
                return null;
            }
            g gVar = new g(this, view, this.f108876x, this.R);
            this.f108869q = gVar;
            gVar.S(this.f108861i);
            GdtUIUtils.setNightThemeByView(this.f108854b.findViewById(R.id.f_1));
            this.f108869q.D();
            this.f108855c = (ImageView) this.f108854b.findViewById(R.id.f163990fp);
            this.f108865m = (RelativeLayout) this.f108854b.findViewById(R.id.krm);
            return this.f108854b;
        } catch (Exception e16) {
            QLog.e("GdtMvVideoViewController", 1, " viewcontr initViews error", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(Object[] objArr) {
        O();
    }

    private void h0() {
        y0(false);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.gdtad.basics.motivevideo.GdtMvVideoViewController.8
            @Override // java.lang.Runnable
            public void run() {
                GdtMvVideoViewController.this.H0(0L, 0L, 0L);
                GdtMvVideoViewController.this.G0(0L, true);
                GdtMvVideoViewController.this.D0();
            }
        });
    }

    private void k0() {
        if (this.C) {
            boolean z16 = true;
            QLog.i("GdtMvVideoViewController", 1, "refreshVoiceIconDrawable isSilentMode is true");
            if (!com.tencent.gdtad.basics.motivevideo.b.f108898a.c() && SystemMethodProxy.getStreamVolume(this.B, 3) > 0) {
                z16 = false;
            }
            this.f108862j = z16;
        }
        l0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0() {
        this.H.j(this.f108854b.getContext(), this.f108862j);
    }

    private void m0() {
        boolean z16;
        AudioManager audioManager = this.B;
        if (audioManager != null) {
            if (audioManager.getRingerMode() != 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.C = z16;
        }
        this.D = new SilentModeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.RINGER_MODE_CHANGED");
        this.f108874v.registerReceiver(this.D, intentFilter);
        VolumeChangeObserver volumeChangeObserver = new VolumeChangeObserver(this.f108874v);
        this.E = volumeChangeObserver;
        volumeChangeObserver.registerReceiver();
        this.E.setListener(new VolumeChangeObserver.VolumeChangeListener() { // from class: com.tencent.gdtad.basics.motivevideo.j
            @Override // com.tencent.gdtad.volume.VolumeChangeObserver.VolumeChangeListener
            public final void onVolumeChanged(Object[] objArr) {
                GdtMvVideoViewController.this.b0(objArr);
            }
        });
    }

    private void n0() {
        if (this.G) {
            f0();
            e0();
        }
    }

    private void o0() {
        GdtADFlyingStreamingReportHelper.getInstance().setShowCardStatus(1);
        p0(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020030);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(long j3) {
        GdtADFlyingStreamingReportHelper.getInstance().reportADEvent(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0() {
        if (!this.V) {
            QLog.d("GdtMvVideoViewController", 1, "reportAchieveReward");
            p0(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020012);
            w0(2, NetConnInfoCenter.getServerTime());
            this.V = true;
        }
    }

    private void r0() {
        Activity activity;
        n nVar = this.f108853a;
        GdtMotiveVideoPageData gdtMotiveVideoPageData = null;
        if (nVar != null) {
            activity = nVar.getActivity();
        } else {
            activity = null;
        }
        GdtMotiveVideoModel gdtMotiveVideoModel = this.f108876x;
        if (gdtMotiveVideoModel != null) {
            gdtMotiveVideoPageData = gdtMotiveVideoModel.getGdtMotiveVideoPageData();
        }
        if (gdtMotiveVideoPageData != null && activity != null) {
            GdtAnalysisHelperForMotiveAd.c(this.f108874v, gdtMotiveVideoPageData, Integer.MIN_VALUE, Integer.MIN_VALUE, false);
        } else {
            GdtLog.e("GdtMvVideoViewController", "[reportForMotiveClose] report params error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        Activity activity;
        n nVar = this.f108853a;
        GdtMotiveVideoPageData gdtMotiveVideoPageData = null;
        if (nVar != null) {
            activity = nVar.getActivity();
        } else {
            activity = null;
        }
        GdtMotiveVideoModel gdtMotiveVideoModel = this.f108876x;
        if (gdtMotiveVideoModel != null) {
            gdtMotiveVideoPageData = gdtMotiveVideoModel.getGdtMotiveVideoPageData();
        }
        if (gdtMotiveVideoPageData != null && activity != null && activity.getIntent() != null) {
            if (this.O) {
                GdtLog.i("GdtMvVideoViewController", "[reportForMotiveVideoFirstFrameRendered] first frame reported");
                return;
            }
            this.O = true;
            Intent intent = activity.getIntent();
            long j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            long longExtra = intent.getLongExtra("key_motive_show_start_time", WebViewConstants.WV.ENABLE_WEBAIO_SWITCH);
            Context context = this.f108874v;
            if (longExtra != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
                j3 = System.currentTimeMillis() - longExtra;
            }
            GdtAnalysisHelperForMotiveAd.u(context, gdtMotiveVideoPageData, j3, false);
            return;
        }
        GdtLog.e("GdtMvVideoViewController", "[reportForMotiveVideoFirstFrameRendered] report params error");
    }

    private void t0() {
        Activity activity;
        n nVar = this.f108853a;
        GdtMotiveVideoPageData gdtMotiveVideoPageData = null;
        if (nVar != null) {
            activity = nVar.getActivity();
        } else {
            activity = null;
        }
        GdtMotiveVideoModel gdtMotiveVideoModel = this.f108876x;
        if (gdtMotiveVideoModel != null) {
            gdtMotiveVideoPageData = gdtMotiveVideoModel.getGdtMotiveVideoPageData();
        }
        if (gdtMotiveVideoPageData != null && activity != null && activity.getIntent() != null) {
            Intent intent = activity.getIntent();
            long j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            long longExtra = intent.getLongExtra("key_motive_show_start_time", WebViewConstants.WV.ENABLE_WEBAIO_SWITCH);
            Context context = this.f108874v;
            if (longExtra != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
                j3 = System.currentTimeMillis() - longExtra;
            }
            GdtAnalysisHelperForMotiveAd.d(context, gdtMotiveVideoPageData, j3, false);
            return;
        }
        GdtLog.e("GdtMvVideoViewController", "[reportForMotiveViewShow] report params error");
    }

    private void v0() {
        this.Q.f(this.f108860h);
        this.Q.e(this.f108867o);
        u0(11);
    }

    private void w0(int i3, long j3) {
        String str;
        String str2 = "";
        if (this.I == null) {
            return;
        }
        try {
            GdtMotiveVideoPageData gdtMotiveVideoPageData = this.f108876x.getGdtMotiveVideoPageData();
            GdtAd gdtAd = this.f108878z;
            if (gdtAd == null) {
                str = "";
            } else {
                str = String.valueOf(gdtAd.getAId());
            }
            if (gdtMotiveVideoPageData != null) {
                try {
                    str2 = gdtMotiveVideoPageData.appId;
                } catch (Exception unused) {
                    QLog.e("GdtMvVideoViewController", 1, "get adInfo aId and appId fail");
                    com.tencent.gdtad.basics.motivevideo.report.d dVar = this.I;
                    dVar.a(i3, j3, str, str2);
                }
            }
        } catch (Exception unused2) {
            str = "";
        }
        com.tencent.gdtad.basics.motivevideo.report.d dVar2 = this.I;
        dVar2.a(i3, j3, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(boolean z16) {
        if (this.B != null) {
            if (z16) {
                QLog.i("GdtMvVideoViewController", 1, "[requestSystemAudioFocus] gain is called!");
                this.B.requestAudioFocus(null, 3, 2);
            } else {
                QLog.i("GdtMvVideoViewController", 1, "[requestSystemAudioFocus] release is called!");
                this.B.abandonAudioFocus(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        QLog.i("GdtMvVideoViewController", 4, "[resumeVideoPlayer]");
        this.f108864l = false;
        E0();
        GdtRewardTimeCounter gdtRewardTimeCounter = this.f108856d;
        if (gdtRewardTimeCounter != null) {
            gdtRewardTimeCounter.i();
        }
        if (GdtADFlyingStreamingReportHelper.getInstance().getShowCardStatus() == 1) {
            p0(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020041);
        } else {
            p0(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020011);
        }
    }

    public void A0(int i3) {
        this.J = i3;
        this.H.k(i3);
    }

    public void D() {
        E("");
    }

    protected void D0() {
        g gVar = this.f108869q;
        if (gVar != null) {
            gVar.z();
        }
        C(1);
        p0(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020035);
        GdtADFlyingStreamingReportHelper.getInstance().setShowCardStatus(2);
        u0(10);
    }

    public void E(String str) {
        GdtMotiveVideoPageData gdtMotiveVideoPageData = this.f108876x.getGdtMotiveVideoPageData();
        QLog.i("GdtMvVideoViewController", 1, "GDT beforeFinish call stack:", new Throwable());
        Intent intent = new Intent();
        if (gdtMotiveVideoPageData != null && gdtMotiveVideoPageData.supportOpenMotiveAd) {
            intent.putExtra("profitable_flag", this.f108863k);
            intent.putExtra("arg_callback", gdtMotiveVideoPageData.getAsyncCallbackId());
            QLog.i("GdtMvVideoViewController", 1, "true[beforeFinish] mHasWatchAds" + this.f108863k);
        } else {
            intent.putExtra(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_END_DURATION_TIME, this.f108860h);
            intent.putExtra("elapsed_time", this.f108860h);
            intent.putExtra("profitable_flag", this.f108863k);
            intent.putExtra("is_end", this.f108866n);
            boolean z16 = this.f108866n;
            if (z16) {
                GdtThirdProcessorProxy gdtThirdProcessorProxy = this.R;
                long j3 = this.f108860h;
                gdtThirdProcessorProxy.doCallbackBeforeFinish(gdtMotiveVideoPageData, j3, j3, z16);
                QLog.i("GdtMvVideoViewController", 1, "true[beforeFinish] " + this.f108860h + " /" + this.f108860h);
            } else if (this.f108877y != null) {
                long j16 = this.f108857e;
                if (this.f108863k) {
                    long j17 = this.f108867o;
                    if (j16 <= j17 * 1000) {
                        j16 = 1 + (j17 * 1000);
                    }
                }
                long j18 = j16;
                intent.putExtra("elapsed_time", j18);
                this.R.doCallbackBeforeFinish(gdtMotiveVideoPageData, j18, this.f108860h, this.f108866n);
                QLog.i("GdtMvVideoViewController", 1, "HasWatchAds:" + this.f108863k + "[beforeFinish] " + j18 + "/" + this.f108860h);
            }
        }
        this.R.addReadInJoyCb(intent, str);
        this.f108853a.setResult(-1, intent);
        n0();
    }

    public void E0() {
        com.tencent.gdtad.basics.motivevideo.d dVar;
        if (this.f108875w && (dVar = this.f108877y) != null) {
            dVar.C();
            y0(!this.f108862j);
            l0();
        }
    }

    public void F0() {
        GdtRewardTimeCounter gdtRewardTimeCounter = this.f108856d;
        if (gdtRewardTimeCounter != null) {
            gdtRewardTimeCounter.j();
        }
    }

    protected void G0(long j3, boolean z16) {
        this.H.m(j3, z16);
    }

    protected void H0(long j3, long j16, long j17) {
        this.H.n(j3, j16, j17);
    }

    protected void I0() {
        com.tencent.gdtad.basics.motivevideo.d dVar = this.f108877y;
        if (dVar != null && !dVar.r()) {
            this.f108864l = true;
            H(true);
        }
        p0(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020010);
    }

    public void J0(long j3) {
        QLog.i("GdtMvVideoViewController", 1, "[onVideoCompletion]");
        GdtVideoData gdtVideoData = this.f108876x.getGdtVideoData();
        this.f108866n = true;
        this.f108863k = true;
        GdtVideoReportListenerImp gdtVideoReportListenerImp = this.f108872t;
        if (gdtVideoReportListenerImp != null && gdtVideoData != null) {
            gdtVideoReportListenerImp.onCompleted(gdtVideoData, this.P);
        }
        q0();
        this.Q.c();
        this.Q.d();
        h0();
    }

    public boolean K() {
        return this.H.c();
    }

    public void K0(int i3, int i16, int i17, String str) {
        QLog.i("GdtMvVideoViewController", 1, "[onVideoError], module:" + i3 + ",errorType:" + i16 + ",errorCode:" + i17 + ",msg:" + str);
        GdtVideoData gdtVideoData = this.f108876x.getGdtVideoData();
        if (this.f108872t != null && gdtVideoData != null) {
            this.P.setErrorTypeFromSP(i16, i17);
            this.f108872t.onError(gdtVideoData, this.f108877y.k(), this.P);
        }
        p0(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020009);
        p0(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020007);
        GdtReporter.reportPlayFail(this.f108876x, i16, i17);
    }

    public n L() {
        return this.f108853a;
    }

    public void L0(final long j3, final long j16) {
        GdtRewardTimeCounter gdtRewardTimeCounter;
        GdtVideoReportListenerImp gdtVideoReportListenerImp;
        GdtVideoData gdtVideoData = this.f108876x.getGdtVideoData();
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.f108859g.post(new Runnable() { // from class: com.tencent.gdtad.basics.motivevideo.GdtMvVideoViewController.7
                @Override // java.lang.Runnable
                public void run() {
                    GdtMvVideoViewController.this.L0(j3, j16);
                }
            });
            return;
        }
        boolean z16 = this.f108866n;
        if (!z16 && !this.f108863k) {
            long j17 = (this.L - j3) + this.K;
            this.f108857e = j17;
            G0(j17 / 1000, z16);
            if (!this.f108873u && (gdtVideoReportListenerImp = this.f108872t) != null && this.f108877y != null && gdtVideoData != null) {
                this.f108873u = true;
                gdtVideoReportListenerImp.onStarted(gdtVideoData, 0L);
            }
            if (!this.N && (gdtRewardTimeCounter = this.f108856d) != null) {
                gdtRewardTimeCounter.h(true);
                this.f108856d.i();
                this.N = true;
            }
        }
    }

    public long M() {
        com.tencent.gdtad.basics.motivevideo.d dVar = this.f108877y;
        if (dVar == null) {
            return 0L;
        }
        return dVar.m();
    }

    public GdtImpressionReporter.GdtVideoReportInfo N() {
        return this.P;
    }

    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        S();
        View Z = Z(layoutInflater, viewGroup);
        if (Z == null) {
            QLog.i("GdtMvVideoViewController", 1, "GdtMvViewController init:rootView==null error");
            return null;
        }
        this.f108874v = Z.getContext();
        QLog.i("GdtMvVideoViewController", 1, "GdtMvViewController: init = " + this.G + ", mContext = " + this.f108874v);
        this.B = (AudioManager) this.f108874v.getSystemService("audio");
        Context context = this.f108874v;
        if ((context instanceof Activity) && !this.G) {
            ((Activity) context).setVolumeControlStream(3);
        }
        F();
        Y();
        V();
        GdtADFlyingStreamingReportHelper.getInstance().init(this.f108876x);
        m0();
        k0();
        W();
        T(this.f108876x);
        X();
        R();
        U();
        J();
        o0();
        p0(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020033);
        p0(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020006);
        t0();
        v0();
        if (this.S) {
            GdtOriginalExposureReporter.reportOriginalExposure(this.f108878z, this.f108874v, this.J);
            this.S = false;
        }
        return Z;
    }

    public void W() {
        GdtMotiveVideoModel gdtMotiveVideoModel = this.f108876x;
        if (gdtMotiveVideoModel == null) {
            return;
        }
        this.H.h(this.f108854b, this, gdtMotiveVideoModel);
        this.H.b(this.f108853a.getActivity(), this.f108861i);
        this.H.l(0);
    }

    @Override // rm0.b.a
    public void a() {
        com.tencent.gdtad.basics.motivevideo.d dVar = this.f108877y;
        if (dVar == null) {
            return;
        }
        boolean l3 = dVar.l();
        this.f108862j = !l3;
        QLog.i("GdtMvVideoViewController", 1, "audioSwitch click is called isSilentMode = " + this.C + ", isMute = " + l3);
        this.f108877y.A(this.f108862j);
        B0(!this.f108862j ? 1 : 0, true, false);
        u0(7);
    }

    public boolean a0() {
        return this.f108866n;
    }

    @Override // rm0.b.a
    public void b() {
        QLog.i("GdtMvVideoViewController", 1, " onClick close_ads");
        if (GdtADFlyingStreamingReportHelper.getInstance().getShowCardStatus() == 2) {
            p0(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020016);
        } else {
            p0(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020028);
        }
        if (!j0(true)) {
            r0();
            this.f108853a.finish();
        }
    }

    @Override // rm0.b.a
    public void c() {
        QLog.i("GdtMvVideoViewController", 1, "[onClickFeedback]");
        GdtAd gdtAd = this.f108878z;
        if (gdtAd == null) {
            QLog.i("GdtMvVideoViewController", 1, "[onClickFeedback] gdtAd is null");
            return;
        }
        String urlForFeedBack = gdtAd.getUrlForFeedBack();
        if (!TextUtils.isEmpty(urlForFeedBack)) {
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).doCgiReport(urlForFeedBack.replace("__ACT_TYPE__", "2001"));
            QLog.i("GdtMvVideoViewController", 1, "[onClickFeedback] report feedback");
            AdToast.getInstance().show(this.f108874v, 2, "\u53cd\u9988\u6210\u529f\uff0c\u540e\u7eed\u5c06\u51cf\u5c11\u6b64\u54c1\u7c7b\u5e7f\u544a", 0);
        }
    }

    public boolean c0() {
        return j0(false);
    }

    public void d0() {
        QLog.i("GdtMvVideoViewController", 1, "[onCreate]");
        ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplication.getContext(), false, 55);
    }

    public void e0() {
        SilentModeReceiver silentModeReceiver;
        QLog.i("GdtMvVideoViewController", 1, "[onDestroy]");
        Handler handler = this.f108859g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        VolumeChangeObserver volumeChangeObserver = this.E;
        if (volumeChangeObserver != null) {
            volumeChangeObserver.unregisterReceiver();
        }
        g gVar = this.f108869q;
        if (gVar != null) {
            gVar.M();
            this.f108869q = null;
        }
        com.tencent.gdtad.basics.motivevideo.d dVar = this.f108877y;
        if (dVar != null) {
            dVar.u();
        }
        GdtRewardTimeCounter gdtRewardTimeCounter = this.f108856d;
        if (gdtRewardTimeCounter != null) {
            gdtRewardTimeCounter.j();
        }
        if (this.f108872t != null) {
            this.f108872t = null;
        }
        Context context = this.f108874v;
        if (context != null && (silentModeReceiver = this.D) != null) {
            context.unregisterReceiver(silentModeReceiver);
        }
        Iterator<com.tencent.gdtad.basics.motivevideo.d> it = this.A.iterator();
        while (it.hasNext()) {
            it.next().u();
        }
        this.A.clear();
        this.f108874v = null;
        GdtImpressionPolicy.getInstance().clearCountingMap();
        ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplication.getContext(), true, 55);
    }

    public void f0() {
        g0(true);
    }

    public void g0(boolean z16) {
        this.f108875w = false;
        H(z16);
        g gVar = this.f108869q;
        if (gVar != null) {
            gVar.N();
        }
        if (z16) {
            F0();
        }
        QLog.d("GdtMvVideoViewController", 1, "onPause current pos:", Long.valueOf(this.f108857e));
    }

    public void i0() {
        this.f108875w = true;
        QLog.i("GdtMvVideoViewController", 1, "[onResume]" + this.f108864l + " mIsVideoPlayCompleted " + this.f108866n);
        if (!this.f108864l && !this.f108866n) {
            E0();
        }
        GdtRewardTimeCounter gdtRewardTimeCounter = this.f108856d;
        if (gdtRewardTimeCounter != null) {
            gdtRewardTimeCounter.i();
        }
        g gVar = this.f108869q;
        if (gVar != null) {
            gVar.O();
        }
        QLog.d("GdtMvVideoViewController", 1, "onResume current pos:", Long.valueOf(this.f108857e));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean j0(boolean z16) {
        int i3 = 1;
        QLog.i("GdtMvVideoViewController", 1, "[onBackEvent] mHasWatchAds " + this.f108863k);
        if (z16) {
            try {
                if (this.f108863k) {
                    u0(4);
                    i3 = 0;
                } else {
                    I0();
                    GdtMotiveVideoModel gdtMotiveVideoModel = this.f108876x;
                    if (gdtMotiveVideoModel != null && gdtMotiveVideoModel.canShowCustomDialog()) {
                        C0();
                    } else {
                        I();
                    }
                }
            } catch (Throwable th5) {
                QLog.e("GdtMvVideoViewController", i3, "show dialog err, errInfo->" + th5.getMessage());
                return false;
            }
        }
        return i3;
    }

    public void u0(int i3) {
        this.Q.b(i3, M());
    }

    public void x0() {
        View view = this.f108854b;
        if (view != null) {
            view.requestLayout();
        }
        J();
    }
}
