package com.tencent.gdtad.basics.motivevideo;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.util.UiThreadUtil;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes6.dex */
public class d implements l, Handler.Callback {
    private AdExposureChecker C;
    private int F;

    /* renamed from: d, reason: collision with root package name */
    private Context f108902d;

    /* renamed from: e, reason: collision with root package name */
    private ICmGameVideoPlayer f108903e;

    /* renamed from: f, reason: collision with root package name */
    private RelativeLayout f108904f;

    /* renamed from: h, reason: collision with root package name */
    private GdtMotiveVideoModel f108905h;

    /* renamed from: i, reason: collision with root package name */
    private k f108906i;

    /* renamed from: m, reason: collision with root package name */
    private Handler f108907m = new Handler(Looper.getMainLooper(), this);
    private AdExposureChecker.ExposureCallback D = null;
    public final com.tencent.gdtad.basics.motivevideo.report.d E = new com.tencent.gdtad.basics.motivevideo.report.d();
    private boolean G = true;
    private int H = 0;
    private long I = 0;
    private String J = "";
    private boolean K = false;
    private boolean L = false;
    private volatile boolean M = false;
    private boolean N = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements SDKInitListener {
        a() {
        }

        @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
        public void onSDKInited(boolean z16) {
            QLog.i("VideoGdtGdtMotiveVideoController", 1, "onSDKInited " + z16);
            if (z16) {
                d.this.f108907m.sendEmptyMessage(3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b implements AdExposureChecker.ExposureCallback {
        b() {
        }

        @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
        public void onExposure(WeakReference<View> weakReference) {
            String e16 = new com.tencent.gdtad.basics.motivevideo.report.b().e(d.this.f108905h.getGdtAd().getUrlForImpression());
            if (d.this.F > 0) {
                e16 = e16 + "&slot=" + d.this.F;
            }
            if (TextUtils.equals(e16, d.this.J)) {
                return;
            }
            GdtReporter.doExposeCgiReport(e16);
            d.this.J = e16;
            QLog.d("GdtMotiveVideoController", 1, "AdExposureChecker exposure report url: " + e16);
        }
    }

    public d(@NotNull Context context, RelativeLayout relativeLayout, GdtMotiveVideoModel gdtMotiveVideoModel, k kVar) {
        this.f108902d = context;
        this.f108904f = relativeLayout;
        this.f108905h = gdtMotiveVideoModel;
        this.f108906i = kVar;
    }

    private void n(View view) {
        QLog.d("GdtMotiveVideoController", 1, "initExpoReport isFirst=", Boolean.valueOf(this.N));
        if (this.N && view != null) {
            this.N = false;
            this.C = new AdExposureChecker(this.f108905h.getGdtAd(), new WeakReference(view));
            this.D = new b();
            this.C.setCallback(new WeakReference<>(this.D));
            this.C.startCheck();
            z(0, NetConnInfoCenter.getServerTime());
        }
    }

    private void o() {
        if (QQVideoPlaySDKManager.isSDKReady()) {
            p();
        } else {
            q();
        }
    }

    private void p() {
        String str;
        CmGameGdtVideoPlayer cmGameGdtVideoPlayer = new CmGameGdtVideoPlayer();
        this.f108903e = cmGameGdtVideoPlayer;
        cmGameGdtVideoPlayer.initVideoPlayer(this.f108902d, ((ICmGameHelper) QRoute.api(ICmGameHelper.class)).getAppInterface());
        this.f108903e.addPlayerCallback(this, 100L);
        final View videoContainer = this.f108903e.getVideoContainer();
        if (videoContainer != null && this.f108904f != null) {
            final RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            GdtMotiveVideoPageData gdtMotiveVideoPageData = this.f108905h.getGdtMotiveVideoPageData();
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.gdtad.basics.motivevideo.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.t(videoContainer, layoutParams);
                }
            });
            ICmGameVideoPlayer iCmGameVideoPlayer = this.f108903e;
            if (iCmGameVideoPlayer != null && gdtMotiveVideoPageData != null && (str = gdtMotiveVideoPageData.url) != null) {
                iCmGameVideoPlayer.startPlay(str, "sd", 0);
                return;
            }
            return;
        }
        QLog.i("VideoGdtGdtMotiveVideoController", 1, "[setViewStatus], video container is null." + this.f108904f);
    }

    private void q() {
        try {
            QLog.i("VideoGdtGdtMotiveVideoController", 1, "installSDK");
            QQVideoPlaySDKManager.initSDKAsync(BaseApplication.getContext(), new a());
        } catch (Throwable th5) {
            QLog.e("VideoGdtGdtMotiveVideoController", 1, "installSDK", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(View view, RelativeLayout.LayoutParams layoutParams) {
        this.f108904f.addView(view, layoutParams);
    }

    private void x() {
        RelativeLayout relativeLayout;
        int maxScreenSize;
        int minScreenSize;
        int i3;
        if (this.f108903e != null && (relativeLayout = this.f108904f) != null) {
            relativeLayout.setVisibility(0);
            n(this.f108904f);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f108904f.getLayoutParams();
            layoutParams.addRule(14);
            int videoWidth = this.f108903e.getVideoWidth();
            int videoHeight = this.f108903e.getVideoHeight();
            if (this.G) {
                maxScreenSize = GdtUIUtils.getMinScreenSize(this.f108902d);
            } else {
                maxScreenSize = GdtUIUtils.getMaxScreenSize(this.f108902d);
            }
            if (this.G) {
                minScreenSize = GdtUIUtils.getMaxScreenSize(this.f108902d);
            } else {
                minScreenSize = GdtUIUtils.getMinScreenSize(this.f108902d);
            }
            if (this.G) {
                if (this.H == 3) {
                    if (videoWidth != 0) {
                        i3 = (int) (((maxScreenSize * 1.0f) * videoHeight) / videoWidth);
                    } else {
                        i3 = 0;
                    }
                    layoutParams.height = i3;
                    layoutParams.width = maxScreenSize;
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.height = (int) (((maxScreenSize * 1.0f) * videoHeight) / videoWidth);
                    layoutParams.width = maxScreenSize;
                    layoutParams.topMargin = (int) ((minScreenSize * 455.0f) / 1624.0f);
                }
            }
            this.f108904f.requestLayout();
            y(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020034);
        }
    }

    private void y(long j3) {
        GdtADFlyingStreamingReportHelper.getInstance().reportADEvent(j3);
    }

    private void z(int i3, long j3) {
        String str;
        String str2 = "";
        if (this.E == null) {
            return;
        }
        try {
            GdtMotiveVideoPageData gdtMotiveVideoPageData = this.f108905h.getGdtMotiveVideoPageData();
            GdtAd gdtAd = this.f108905h.getGdtAd();
            if (gdtAd == null) {
                str = "";
            } else {
                str = String.valueOf(gdtAd.getAId());
            }
            if (gdtMotiveVideoPageData != null) {
                try {
                    str2 = gdtMotiveVideoPageData.appId;
                } catch (Exception unused) {
                    QLog.e("GdtMotiveVideoController", 1, "get adInfo aId and appId fail");
                    com.tencent.gdtad.basics.motivevideo.report.d dVar = this.E;
                    dVar.a(i3, j3, str, str2);
                }
            }
        } catch (Exception unused2) {
            str = "";
        }
        com.tencent.gdtad.basics.motivevideo.report.d dVar2 = this.E;
        dVar2.a(i3, j3, str, str2);
    }

    public void A(boolean z16) {
        ICmGameVideoPlayer iCmGameVideoPlayer = this.f108903e;
        if (iCmGameVideoPlayer == null) {
            return;
        }
        this.K = z16;
        iCmGameVideoPlayer.setMute(z16);
    }

    public void B(int i3, boolean z16) {
        long j3;
        this.F = i3;
        this.K = z16;
        GdtMotiveVideoPageData gdtMotiveVideoPageData = this.f108905h.getGdtMotiveVideoPageData();
        if (gdtMotiveVideoPageData == null) {
            return;
        }
        boolean z17 = true;
        if (gdtMotiveVideoPageData.screenOrientation != 1) {
            z17 = false;
        }
        this.G = z17;
        this.H = gdtMotiveVideoPageData.getType();
        if (this.f108905h.getAdInfo() != null) {
            j3 = this.f108905h.getAdInfo().display_info.video_info.media_duration.get() * 1000;
        } else {
            j3 = 0;
        }
        this.I = j3;
        o();
    }

    public void C() {
        if (this.L && this.f108903e != null) {
            w();
            this.f108906i.onVideoPlayStart();
        }
    }

    @Override // com.tencent.gdtad.basics.motivevideo.l
    public void a(int i3, int i16, int i17, String str) {
        this.f108907m.sendEmptyMessage(4);
        this.f108906i.a(i3, i16, i17, str);
    }

    @Override // com.tencent.gdtad.basics.motivevideo.l
    public void b(long j3, long j16) {
        this.f108906i.b(j3, j16);
    }

    @Override // com.tencent.gdtad.basics.motivevideo.l
    public void c() {
        k kVar = this.f108906i;
        if (kVar != null) {
            kVar.c();
        }
    }

    @Override // com.tencent.gdtad.basics.motivevideo.l
    public void d() {
        QLog.i("GdtMotiveVideoController", 1, "[onVideoCompletion]");
        this.L = false;
        if (!this.M) {
            this.M = true;
            Handler handler = this.f108907m;
            if (handler != null) {
                handler.obtainMessage(2).sendToTarget();
            }
            this.f108906i.d(this.I);
            y(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020013);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull @NotNull Message message) {
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        QLog.i("GdtMotiveVideoController", 1, "[VIDEO_FAIL] handle message");
                        return false;
                    }
                    return false;
                }
                QLog.i("GdtMotiveVideoController", 1, "[VIDEO_SDK_INSTALLED] initVideoView");
                p();
                return false;
            }
            QLog.i("GdtMotiveVideoController", 1, "[onVideoCompletion]");
            ICmGameVideoPlayer iCmGameVideoPlayer = this.f108903e;
            if (iCmGameVideoPlayer != null) {
                iCmGameVideoPlayer.removePlayerCallback(this);
                return false;
            }
            return false;
        }
        if (this.f108903e != null) {
            x();
            ICmGameVideoPlayer iCmGameVideoPlayer2 = this.f108903e;
            if (iCmGameVideoPlayer2 != null) {
                iCmGameVideoPlayer2.setMute(this.K);
                this.I = this.f108903e.getVideoDuration();
                this.f108905h.getGdtVideoData().setDurationMillis(this.I);
                C();
                return false;
            }
            return false;
        }
        return false;
    }

    public long k() {
        ICmGameVideoPlayer iCmGameVideoPlayer = this.f108903e;
        if (iCmGameVideoPlayer == null) {
            return 0L;
        }
        return iCmGameVideoPlayer.getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        ICmGameVideoPlayer iCmGameVideoPlayer = this.f108903e;
        if (iCmGameVideoPlayer == null) {
            return false;
        }
        return iCmGameVideoPlayer.getMuteValue();
    }

    public long m() {
        if (this.f108903e != null) {
            if (this.M) {
                return this.I;
            }
            return this.f108903e.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.tencent.gdtad.basics.motivevideo.l
    public void onVideoPrepared() {
        QLog.i("GdtMotiveVideoController", 1, "[onVideoPrepared]");
        if (!this.L) {
            this.L = true;
            if (this.f108907m != null) {
                QLog.i("GdtMotiveVideoController", 1, "[onVideoPrepared] send PREPARED msg");
                this.f108907m.obtainMessage(1).sendToTarget();
                return;
            }
            return;
        }
        ICmGameVideoPlayer iCmGameVideoPlayer = this.f108903e;
        if (iCmGameVideoPlayer != null && !iCmGameVideoPlayer.isPlaying()) {
            QLog.i("GdtMotiveVideoController", 1, "[onVideoPrepared] resume VideoPlayer again");
            C();
        }
    }

    public boolean r() {
        ICmGameVideoPlayer iCmGameVideoPlayer = this.f108903e;
        if (iCmGameVideoPlayer == null) {
            return false;
        }
        return iCmGameVideoPlayer.isPaused();
    }

    public boolean s() {
        ICmGameVideoPlayer iCmGameVideoPlayer = this.f108903e;
        if (iCmGameVideoPlayer == null) {
            return false;
        }
        return iCmGameVideoPlayer.isPlaying();
    }

    public void u() {
        ICmGameVideoPlayer iCmGameVideoPlayer = this.f108903e;
        if (iCmGameVideoPlayer != null) {
            iCmGameVideoPlayer.removePlayerCallback(this);
            this.f108903e.release();
            this.f108903e = null;
        }
        AdExposureChecker adExposureChecker = this.C;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityDestroy();
            this.C.setCallback(null);
        }
    }

    public void v() {
        QLog.d("GdtMotiveVideoController", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        ICmGameVideoPlayer iCmGameVideoPlayer = this.f108903e;
        if (iCmGameVideoPlayer != null) {
            iCmGameVideoPlayer.pause();
        }
        AdExposureChecker adExposureChecker = this.C;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityPause();
        }
    }

    public void w() {
        ICmGameVideoPlayer iCmGameVideoPlayer = this.f108903e;
        if (iCmGameVideoPlayer == null) {
            return;
        }
        iCmGameVideoPlayer.resume();
        AdExposureChecker adExposureChecker = this.C;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityResume();
        }
    }
}
