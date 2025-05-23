package com.qzone.reborn.feedx.widget.ad;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.SeekBar;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.commoncode.module.gdt.QZoneAdVideoPlayReporter;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.qzone.reborn.feedx.video.view.QZoneVideoView;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView;
import com.qzone.reborn.util.m;
import com.qzone.util.ag;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerOption;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneAdVideoItemWidgetView extends QZoneVideoItemWidgetView {

    /* renamed from: a0, reason: collision with root package name */
    protected GdtAd f55970a0;

    /* renamed from: b0, reason: collision with root package name */
    private WeakReference<c> f55971b0;

    /* renamed from: c0, reason: collision with root package name */
    private WeakReference<d> f55972c0;

    /* renamed from: d0, reason: collision with root package name */
    private QZoneAdVideoPlayReporter f55973d0;

    /* renamed from: e0, reason: collision with root package name */
    public Runnable f55974e0;

    /* renamed from: f0, reason: collision with root package name */
    public Runnable f55975f0;

    /* renamed from: g0, reason: collision with root package name */
    public com.qzone.commoncode.module.gdt.f f55976g0;

    /* renamed from: h0, reason: collision with root package name */
    public com.qzone.commoncode.module.gdt.e f55977h0;

    /* renamed from: i0, reason: collision with root package name */
    private e f55978i0;

    /* renamed from: j0, reason: collision with root package name */
    private g f55979j0;

    /* renamed from: k0, reason: collision with root package name */
    private f f55980k0;

    /* renamed from: l0, reason: collision with root package name */
    private h f55981l0;

    /* renamed from: m0, reason: collision with root package name */
    private volatile boolean f55982m0;

    /* renamed from: n0, reason: collision with root package name */
    protected boolean f55983n0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a extends kh.c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.qzone.commoncode.module.gdt.d f55985d;

        a(com.qzone.commoncode.module.gdt.d dVar) {
            this.f55985d = dVar;
        }

        @Override // kh.c
        public void b(SuperPlayerOption superPlayerOption, ISuperPlayer iSuperPlayer) {
            super.b(superPlayerOption, iSuperPlayer);
            if (superPlayerOption != null && iSuperPlayer != null) {
                QLog.i("PSLink-QZoneAdVideoItemWidgetView", 2, "[updateSettingsForP2PAndPCDN][beforeOpenMedia]");
                SuperPlayerDownOption superPlayerDownOption = superPlayerOption.superPlayerDownOption;
                superPlayerDownOption.pcdnChargeId = "pcdn_ad_qqkj";
                com.qzone.commoncode.module.gdt.d dVar = this.f55985d;
                superPlayerDownOption.enablePcdn = dVar.f46207a;
                int i3 = dVar.f46208b;
                int i16 = dVar.f46209c;
                int i17 = dVar.f46210d;
                iSuperPlayer.setBusinessDownloadStrategy(i3, i16, i17, i17);
                return;
            }
            QLog.i("PSLink-QZoneAdVideoItemWidgetView", 2, "[updateSettingsForP2PAndPCDN][beforeOpenMedia] error");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements IPicLoadStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IPicLoadStateListener f55987d;

        b(IPicLoadStateListener iPicLoadStateListener) {
            this.f55987d = iPicLoadStateListener;
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            this.f55987d.onStateChange(loadState, option);
            QZoneAdVideoItemWidgetView.this.B1(loadState, option);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface c extends lh.a {
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface d extends IPicLoadStateListener {
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    private static class e implements lh.a {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QZoneAdVideoItemWidgetView> f55989a;

        e(QZoneAdVideoItemWidgetView qZoneAdVideoItemWidgetView) {
            this.f55989a = new WeakReference<>(qZoneAdVideoItemWidgetView);
        }

        @Override // lh.a
        public void onCompletion(ISuperPlayer iSuperPlayer) {
            QZoneAdVideoItemWidgetView w16 = QZoneAdVideoItemWidgetView.w1(this.f55989a);
            if (w16 == null) {
                return;
            }
            GdtAd gdtAd = w16.f55970a0;
            long aId = gdtAd != null ? gdtAd.getAId() : WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            QLog.i("PSLink-QZoneAdVideoItemWidgetView", 2, "[onCompletion] aid:" + aId + " currentPosition:" + w16.x1());
            w16.A1(iSuperPlayer);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    private static class f implements lh.b {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QZoneAdVideoItemWidgetView> f55990a;

        f(QZoneAdVideoItemWidgetView qZoneAdVideoItemWidgetView) {
            this.f55990a = new WeakReference<>(qZoneAdVideoItemWidgetView);
        }

        @Override // lh.b
        public void onVideoPlayError(int i3, int i16, int i17, String str) {
            QZoneAdVideoItemWidgetView w16 = QZoneAdVideoItemWidgetView.w1(this.f55990a);
            if (w16 == null) {
                return;
            }
            GdtAd gdtAd = w16.f55970a0;
            long aId = gdtAd != null ? gdtAd.getAId() : WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            long x16 = w16.x1();
            QLog.i("PSLink-QZoneAdVideoItemWidgetView", 2, "[onVideoPlayError] aid:" + aId + " currentPosition:" + x16);
            if (w16.f55973d0 != null) {
                w16.f55973d0.k(x16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    private static class g implements lh.c {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QZoneAdVideoItemWidgetView> f55991a;

        /* compiled from: P */
        /* loaded from: classes37.dex */
        class a implements jm0.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ QZoneAdVideoItemWidgetView f55992a;

            a(QZoneAdVideoItemWidgetView qZoneAdVideoItemWidgetView) {
                this.f55992a = qZoneAdVideoItemWidgetView;
            }

            @Override // jm0.a
            public void pausePlay() {
                QZoneAdVideoItemWidgetView qZoneAdVideoItemWidgetView = this.f55992a;
                if (qZoneAdVideoItemWidgetView != null) {
                    qZoneAdVideoItemWidgetView.pause();
                }
            }
        }

        g(QZoneAdVideoItemWidgetView qZoneAdVideoItemWidgetView) {
            this.f55991a = new WeakReference<>(qZoneAdVideoItemWidgetView);
        }

        @Override // lh.c
        public void onVideoLoopEnd() {
            QZoneAdVideoItemWidgetView w16 = QZoneAdVideoItemWidgetView.w1(this.f55991a);
            if (w16 == null) {
                return;
            }
            GdtAd gdtAd = w16.f55970a0;
            long aId = gdtAd != null ? gdtAd.getAId() : WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            QLog.i("PSLink-QZoneAdVideoItemWidgetView", 2, "[onVideoLoopEnd] aid:" + aId + " currentPosition:" + w16.x1());
            if (w16.f55973d0 != null) {
                w16.f55973d0.m(w16.y1());
            }
        }

        @Override // lh.c
        public void onVideoLoopStart() {
            QZoneAdVideoItemWidgetView w16 = QZoneAdVideoItemWidgetView.w1(this.f55991a);
            if (w16 == null) {
                return;
            }
            ((IGdtAPI) QRoute.api(IGdtAPI.class)).checkAppForegroundState(2, new a(w16));
            GdtAd gdtAd = w16.f55970a0;
            long aId = gdtAd != null ? gdtAd.getAId() : WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            QLog.i("PSLink-QZoneAdVideoItemWidgetView", 2, "[onVideoLoopStart] aid:" + aId + " currentPosition:" + w16.x1());
            if (w16.f55973d0 != null) {
                w16.f55973d0.l(0L, false, true);
            }
            if (w16.f55974e0 != null && w16.f55982m0) {
                w16.f55974e0.run();
            }
            com.qzone.commoncode.module.gdt.e eVar = w16.f55977h0;
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    public QZoneAdVideoItemWidgetView(Context context) {
        super(context);
        this.f55974e0 = null;
        this.f55975f0 = null;
        this.f55976g0 = null;
        this.f55977h0 = null;
        this.f55982m0 = false;
        this.f55983n0 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A1(ISuperPlayer iSuperPlayer) {
        WeakReference<c> weakReference = this.f55971b0;
        c cVar = weakReference != null ? weakReference.get() : null;
        if (cVar == null) {
            return;
        }
        cVar.onCompletion(iSuperPlayer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B1(LoadState loadState, Option option) {
        WeakReference<d> weakReference = this.f55972c0;
        d dVar = weakReference != null ? weakReference.get() : null;
        if (dVar == null) {
            return;
        }
        dVar.onStateChange(loadState, option);
    }

    private void F1() {
        Object obj;
        com.qzone.commoncode.module.gdt.d dVar = new com.qzone.commoncode.module.gdt.d(this.f55970a0);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[updateSettingsForP2PAndPCDN] aid:");
        GdtAd gdtAd = this.f55970a0;
        if (gdtAd != null) {
            obj = Long.valueOf(gdtAd.getAId());
        } else {
            obj = "";
        }
        sb5.append(obj);
        sb5.append(" enablePCDN:");
        sb5.append(dVar.f46207a);
        sb5.append(" emergencyTimeSeconds:");
        sb5.append(dVar.f46208b);
        sb5.append(" safePlayTimeSeconds:");
        sb5.append(dVar.f46209c);
        sb5.append(" preloadDurationSeconds:");
        sb5.append(dVar.f46210d);
        QLog.i("PSLink-QZoneAdVideoItemWidgetView", 2, sb5.toString());
        if (this.E == null) {
            QLog.e("PSLink-QZoneAdVideoItemWidgetView", 1, "[updateSettingsForP2PAndPCDN] error, mVideoView is null");
            return;
        }
        if (!dVar.a()) {
            QLog.i("PSLink-QZoneAdVideoItemWidgetView", 1, "[updateSettingsForP2PAndPCDN] error, not valid");
            this.E.setDynamicPlayerInterceptor(null);
        } else if (!dVar.f46207a) {
            QLog.i("PSLink-QZoneAdVideoItemWidgetView", 1, "[updateSettingsForP2PAndPCDN] P2P and PCDN not enabled");
            this.E.setDynamicPlayerInterceptor(null);
        } else {
            this.E.setDynamicPlayerInterceptor(new a(dVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long x1() {
        VideoInfo videoInfo = this.D;
        return videoInfo != null ? Q0(videoInfo) : WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long y1() {
        VideoInfo videoInfo = this.D;
        return videoInfo != null ? videoInfo.videoTime : WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
    }

    private void z1(final String str) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.feedx.widget.ad.QZoneAdVideoItemWidgetView.3
            @Override // java.lang.Runnable
            public void run() {
                ImageView p06 = QZoneAdVideoItemWidgetView.this.p0();
                if (p06 != null) {
                    p06.setImageDrawable(m.f59551a.b(QZoneAdVideoItemWidgetView.this.getContext()));
                }
            }
        });
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.feedx.widget.ad.QZoneAdVideoItemWidgetView.4
            @Override // java.lang.Runnable
            public void run() {
                QLog.i("PSLink-QZoneAdVideoItemWidgetView", 2, "[loadVideoFirstFrame]");
                ImageView p06 = QZoneAdVideoItemWidgetView.this.p0();
                String u16 = ag.u(ag.d(str));
                Option obtain = Option.obtain();
                obtain.setLocalPath(u16);
                m mVar = m.f59551a;
                obtain.setLoadingDrawable(mVar.b(QZoneAdVideoItemWidgetView.this.getContext()));
                obtain.setFailDrawable(mVar.a(QZoneAdVideoItemWidgetView.this.getContext()));
                obtain.setTargetView(p06);
                com.tencent.mobileqq.qzone.picload.c.a().i(obtain, QZoneAdVideoItemWidgetView.this.K0());
                if (((QZoneVideoItemWidgetView) QZoneAdVideoItemWidgetView.this).E.getSuperPlayer() == null || !((QZoneVideoItemWidgetView) QZoneAdVideoItemWidgetView.this).E.getSuperPlayer().isPlaying()) {
                    QZoneAdVideoItemWidgetView.this.g1(true);
                }
            }
        });
    }

    public void C1(BusinessFeedData businessFeedData, int i3, VideoInfo videoInfo) {
        setFeedData(businessFeedData);
        this.f55970a0 = GdtFeedUtilForQZone.E(businessFeedData);
        setFeedPosition(i3);
        H0(videoInfo);
        this.f55983n0 = QZoneAdFeedDataExtKt.isAdFeedVideoNeedAutoPlay(businessFeedData);
        F1();
        D1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView
    public void E0(com.qzone.reborn.feedx.video.c cVar, String str) {
        super.E0(cVar, str);
        if (cVar != null && cVar.b() != null) {
            this.f55978i0 = new e(this);
            cVar.b().a(this.f55978i0);
            this.f55979j0 = new g(this);
            cVar.b().c(this.f55979j0);
            this.f55980k0 = new f(this);
            cVar.b().b(this.f55980k0);
            this.f55981l0 = new h(this);
            cVar.b().h(this.f55981l0);
            return;
        }
        QLog.e("PSLink-QZoneAdVideoItemWidgetView", 1, "[addCallback] error");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView
    public void G0() {
        VideoUrl videoUrl;
        PictureUrl pictureUrl;
        VideoInfo videoInfo = this.D;
        if (videoInfo != null && (pictureUrl = videoInfo.coverUrl) != null && !TextUtils.isEmpty(pictureUrl.url)) {
            super.G0();
            return;
        }
        QLog.e("PSLink-QZoneAdVideoItemWidgetView", 1, "bindCoverData params is null");
        VideoInfo videoInfo2 = this.D;
        if (videoInfo2 == null || (videoUrl = videoInfo2.videoUrl) == null || this.f55970a0 == null) {
            return;
        }
        z1(videoUrl.url);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView
    public IPicLoadStateListener K0() {
        return new b(super.K0());
    }

    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView
    public boolean N0() {
        return false;
    }

    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView
    protected boolean X0() {
        return this.f55983n0;
    }

    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView, gf.r
    public void a() {
        boolean isPlaying = isPlaying();
        GdtAd gdtAd = this.f55970a0;
        long aId = gdtAd != null ? gdtAd.getAId() : WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        long x16 = x1();
        QLog.i("PSLink-QZoneAdVideoItemWidgetView", 2, "[releasePlayer] aid:" + aId + " currentPosition:" + x16 + " isPlaying:" + isPlaying);
        super.a();
        QZoneAdVideoPlayReporter qZoneAdVideoPlayReporter = this.f55973d0;
        if (qZoneAdVideoPlayReporter == null || !isPlaying) {
            return;
        }
        qZoneAdVideoPlayReporter.m(x16);
    }

    public boolean isPlaying() {
        QZoneVideoView qZoneVideoView = this.E;
        return (qZoneVideoView == null || qZoneVideoView.getSuperPlayer() == null || !this.E.getSuperPlayer().isPlaying()) ? false : true;
    }

    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView, gf.r
    public void pause() {
        boolean isPlaying = isPlaying();
        GdtAd gdtAd = this.f55970a0;
        long aId = gdtAd != null ? gdtAd.getAId() : WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        long x16 = x1();
        QLog.i("PSLink-QZoneAdVideoItemWidgetView", 2, "[pause] aid:" + aId + " currentPosition:" + x16 + " isPlaying:" + isPlaying);
        super.pause();
        QZoneAdVideoPlayReporter qZoneAdVideoPlayReporter = this.f55973d0;
        if (qZoneAdVideoPlayReporter != null && isPlaying) {
            qZoneAdVideoPlayReporter.m(x16);
        }
        if (this.f55975f0 != null && this.f55982m0 && isPlaying) {
            this.f55975f0.run();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView, gf.r
    public void play() {
        boolean isPlaying = isPlaying();
        GdtAd gdtAd = this.f55970a0;
        long aId = gdtAd != null ? gdtAd.getAId() : WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        long x16 = x1();
        QLog.i("PSLink-QZoneAdVideoItemWidgetView", 2, "[play] aid:" + aId + " currentPosition:" + x16 + " isPlaying:" + isPlaying);
        super.play();
        QZoneAdVideoPlayReporter qZoneAdVideoPlayReporter = this.f55973d0;
        if (qZoneAdVideoPlayReporter != null && !isPlaying) {
            if (this.f55982m0) {
                x16 = 0;
            }
            qZoneAdVideoPlayReporter.l(x16, false, false);
        }
        if (this.f55974e0 == null || !this.f55982m0 || isPlaying) {
            return;
        }
        this.f55974e0.run();
    }

    public void setIsBrokenWindowAd(boolean z16) {
        this.f55982m0 = z16;
        setIsPlayFromStart(z16);
        setIsTimeMuteLayoutVisible(!z16);
    }

    public void setVideoCompletionListener(WeakReference<c> weakReference) {
        this.f55971b0 = weakReference;
    }

    public void setVideoCoverLoadStateListener(WeakReference<d> weakReference) {
        this.f55972c0 = weakReference;
    }

    public void setVideoLoopStartCallback(com.qzone.commoncode.module.gdt.e eVar) {
        this.f55977h0 = eVar;
    }

    public void setVideoProgressCallback(com.qzone.commoncode.module.gdt.f fVar) {
        this.f55976g0 = fVar;
    }

    public void setVideoStartPlayCallback(Runnable runnable) {
        this.f55974e0 = runnable;
    }

    public void setVideoStopCallback(Runnable runnable) {
        this.f55975f0 = runnable;
    }

    private void D1() {
        QLog.i("PSLink-QZoneAdVideoItemWidgetView", 2, "[updateReporter]");
        this.f55973d0 = new QZoneAdVideoPlayReporter(this.f55970a0, 1, y1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static QZoneAdVideoItemWidgetView w1(WeakReference<QZoneAdVideoItemWidgetView> weakReference) {
        if (weakReference == null) {
            QLog.e("PSLink-QZoneAdVideoItemWidgetView", 1, "getAdVideoItemWidgetView  weakReference == null");
            return null;
        }
        QZoneAdVideoItemWidgetView qZoneAdVideoItemWidgetView = weakReference.get();
        if (qZoneAdVideoItemWidgetView != null) {
            return qZoneAdVideoItemWidgetView;
        }
        QLog.e("PSLink-QZoneAdVideoItemWidgetView", 1, "getAdVideoItemWidgetView  widgetView == null");
        return null;
    }

    public QZoneAdVideoItemWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f55974e0 = null;
        this.f55975f0 = null;
        this.f55976g0 = null;
        this.f55977h0 = null;
        this.f55982m0 = false;
        this.f55983n0 = false;
    }

    public QZoneAdVideoItemWidgetView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f55974e0 = null;
        this.f55975f0 = null;
        this.f55976g0 = null;
        this.f55977h0 = null;
        this.f55982m0 = false;
        this.f55983n0 = false;
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    private static class h implements lh.h {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QZoneAdVideoItemWidgetView> f55994a;

        h(QZoneAdVideoItemWidgetView qZoneAdVideoItemWidgetView) {
            this.f55994a = new WeakReference<>(qZoneAdVideoItemWidgetView);
        }

        @Override // lh.h
        public void onProgress(String str, int i3, int i16) {
            QZoneAdVideoItemWidgetView w16 = QZoneAdVideoItemWidgetView.w1(this.f55994a);
            if (w16 == null) {
                return;
            }
            GdtAd gdtAd = w16.f55970a0;
            if (gdtAd != null && gdtAd.getTraceId() != null) {
                QZoneAdFeedUtils.f55717a.f0(w16.f55970a0.getTraceId(), i16);
            }
            com.qzone.commoncode.module.gdt.f fVar = w16.f55976g0;
            if (fVar != null) {
                fVar.onProgress(i16);
            }
        }

        @Override // lh.h
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // lh.h
        public void onStopTrackingTouch(SeekBar seekBar) {
        }

        @Override // lh.h
        public void onSeekBarProgressChanged(SeekBar seekBar, int i3, boolean z16) {
        }
    }
}
