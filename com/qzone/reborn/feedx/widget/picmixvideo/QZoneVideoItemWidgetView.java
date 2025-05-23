package com.qzone.reborn.feedx.widget.picmixvideo;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.reborn.feedx.event.QZoneVideoOnPlayEvent;
import com.qzone.reborn.feedx.video.QZonePlayer;
import com.qzone.reborn.feedx.video.view.QZoneVideoView;
import com.qzone.util.ap;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.richframework.gallery.RFWLaunchKey;
import com.tencent.richframework.gallery.video.RFWLayerVideoPlayPosRecorder;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import gf.r;
import java.lang.ref.WeakReference;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneVideoItemWidgetView extends QZoneMixBaseWidgetView implements r {
    protected VideoInfo D;
    protected QZoneVideoView E;
    protected ImageView F;
    protected ImageView G;
    protected LinearLayout H;
    private TextView I;
    private ImageView J;
    private boolean K;
    private boolean L;
    private volatile boolean M;
    private boolean N;
    private c P;
    private h Q;
    private e R;
    private i S;
    private g T;
    private d U;
    private f V;
    private ImageView W;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneVideoItemWidgetView.this.b1();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements IPicLoadStateListener {
        b() {
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            String str;
            PictureUrl pictureUrl;
            if (loadState.isFinish()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("loadImage  | state = ");
                sb5.append(loadState);
                sb5.append(" | feedKey = ");
                BusinessFeedData businessFeedData = QZoneVideoItemWidgetView.this.f56454e;
                String str2 = "";
                if (businessFeedData == null) {
                    str = "";
                } else {
                    str = businessFeedData.getFeedCommInfo().feedskey;
                }
                sb5.append(str);
                sb5.append(" | pos = ");
                sb5.append(QZoneVideoItemWidgetView.this.f56455f);
                sb5.append(" | url = ");
                VideoInfo videoInfo = QZoneVideoItemWidgetView.this.D;
                if (videoInfo != null && (pictureUrl = videoInfo.coverUrl) != null) {
                    str2 = pictureUrl.url;
                }
                sb5.append(str2);
                QLog.i("PSLink-QZoneVideoItemWidgetView", 4, sb5.toString());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface c {
        void a();

        void b(boolean z16);

        void c();

        void d(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class d implements lh.a {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QZoneVideoItemWidgetView> f56481a;

        /* renamed from: b, reason: collision with root package name */
        private final String f56482b;

        public d(QZoneVideoItemWidgetView qZoneVideoItemWidgetView, String str) {
            this.f56481a = new WeakReference<>(qZoneVideoItemWidgetView);
            this.f56482b = str;
        }

        @Override // lh.a
        public void onCompletion(ISuperPlayer iSuperPlayer) {
            QZoneVideoItemWidgetView T0 = QZoneVideoItemWidgetView.T0(this.f56481a);
            if (T0 == null) {
                return;
            }
            RFWLayerVideoPlayPosRecorder.INSTANCE.updatePlayPosition(this.f56482b, 0L);
            T0.g1(true);
            ap.f59791b.e(20, 15, T0.f56455f, T0.f56454e);
            T0.e1("[addCallback]  [onCompletion]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class f implements lh.d {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QZoneVideoItemWidgetView> f56484a;

        f(QZoneVideoItemWidgetView qZoneVideoItemWidgetView) {
            this.f56484a = new WeakReference<>(qZoneVideoItemWidgetView);
        }

        @Override // lh.d
        public void onVideoPassivePause(int i3, int i16, long j3, long j16, long j17) {
            QZoneVideoItemWidgetView T0 = QZoneVideoItemWidgetView.T0(this.f56484a);
            if (T0 == null) {
                return;
            }
            T0.g1(true);
            ap.f59791b.e(20, 15, T0.f56455f, T0.f56454e);
            T0.e1("[addCallback]  [onVideoPassivePause]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class g implements lh.e {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QZoneVideoItemWidgetView> f56485a;

        g(QZoneVideoItemWidgetView qZoneVideoItemWidgetView) {
            this.f56485a = new WeakReference<>(qZoneVideoItemWidgetView);
        }

        @Override // lh.e
        public void a(QZonePlayer qZonePlayer) {
            QZoneVideoItemWidgetView T0 = QZoneVideoItemWidgetView.T0(this.f56485a);
            if (T0 == null || T0.J0(qZonePlayer)) {
                return;
            }
            T0.L0(qZonePlayer.i());
        }

        @Override // lh.e
        public void b(QZonePlayer qZonePlayer) {
            QZoneVideoItemWidgetView T0 = QZoneVideoItemWidgetView.T0(this.f56485a);
            if (T0 == null || T0.J0(qZonePlayer)) {
                return;
            }
            T0.c1();
            ap.f59791b.e(20, 14, T0.f56455f, T0.f56454e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class h implements lh.f {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QZoneVideoItemWidgetView> f56486a;

        h(QZoneVideoItemWidgetView qZoneVideoItemWidgetView) {
            this.f56486a = new WeakReference<>(qZoneVideoItemWidgetView);
        }

        @Override // lh.f
        public void a(QZonePlayer qZonePlayer) {
            QZoneVideoItemWidgetView T0 = QZoneVideoItemWidgetView.T0(this.f56486a);
            if (T0 == null) {
                return;
            }
            T0.E.setOutPutMute(T0.L);
            T0.k1(T0.L);
            T0.E.setLoopBack(T0.Y0());
            T0.e1("[addCallback]  [onInitSuccess]");
        }
    }

    public QZoneVideoItemWidgetView(Context context) {
        this(context, null);
    }

    private void I0() {
        h1();
        this.E.setDataPosInList(this.f56455f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(ISuperPlayer iSuperPlayer) {
        if (this.E == null) {
            return;
        }
        iSuperPlayer.setXYaxis(2);
        this.E.start();
        e1("[doOnVideoPrepare]  ");
        M0();
    }

    private void M0() {
        RFWIocAbilityProvider.g().getIoc(gf.e.class).originView(this).done(new OnPromiseResolved() { // from class: com.qzone.reborn.feedx.widget.picmixvideo.o
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                QZoneVideoItemWidgetView.this.a1((gf.e) obj);
            }
        }).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a1(gf.e eVar) {
        VideoInfo videoInfo = this.D;
        if (videoInfo == null || this.E == null) {
            return;
        }
        String dtPageId = eVar.getDtPageId();
        if (TextUtils.isEmpty(dtPageId)) {
            return;
        }
        e1("[dtReportBindVideoData] ");
        Map<String, ?> b16 = new fo.a().b();
        b16.putAll(fh.b.INSTANCE.a(this.f56454e));
        VideoEntity build = new VideoEntity.Builder().setContentId(videoInfo.videoId).setPage((Object) dtPageId).setContentType(2).setVideoDuration(n.a(videoInfo.videoTime)).setVideoView((View) this.E).addCustomParams(b16).ignoreReport(false).bizReady(true).build();
        ISuperPlayer superPlayer = this.E.getSuperPlayer();
        if (superPlayer != null) {
            VideoReport.bindVideoPlayerInfo(superPlayer, build);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1() {
        VideoInfo videoInfo = this.D;
        if (videoInfo == null) {
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QZoneVideoOnPlayEvent(videoInfo.videoId, getRootView().hashCode()));
        g1(false);
        e1("[onVideoStartViewOperation]  ");
    }

    private void d1(ISuperPlayer iSuperPlayer) {
        QZoneVideoView qZoneVideoView;
        if (!Z0()) {
            QLog.d("PSLink-QZoneVideoItemWidgetView", 1, "playWhenOldPlayerIsExist  !isPlaySameVideo, startANewPlayer");
            j1(false);
            return;
        }
        if (iSuperPlayer.isPlaying() && (qZoneVideoView = this.E) != null && qZoneVideoView.y0()) {
            QLog.d("PSLink-QZoneVideoItemWidgetView", 1, "playWhenOldPlayerIsExist  isPlaying , return");
            if (this.F.getVisibility() == 0) {
                g1(false);
                return;
            }
            return;
        }
        if (iSuperPlayer.isPausing()) {
            if (this.K) {
                iSuperPlayer.seekTo(0);
                QLog.d("PSLink-QZoneVideoItemWidgetView", 1, "playWhenOldPlayerIsExist  isPausing , start play from start");
            } else if (N0()) {
                iSuperPlayer.seekTo((int) Q0(this.D));
            }
            iSuperPlayer.start();
            c1();
            QLog.d("PSLink-QZoneVideoItemWidgetView", 1, "playWhenOldPlayerIsExist  isPausing , start play");
            return;
        }
        QLog.d("PSLink-QZoneVideoItemWidgetView", 1, "playWhenOldPlayerIsExist  startANewPlayer");
        j1(!this.K);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1(String str) {
        String str2;
        String str3;
        VideoUrl videoUrl;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append(" | feedKey = ");
        BusinessFeedData businessFeedData = this.f56454e;
        String str4 = "";
        if (businessFeedData == null) {
            str2 = "";
        } else {
            str2 = businessFeedData.getFeedCommInfo().feedskey;
        }
        sb5.append(str2);
        sb5.append(" | videoId = ");
        VideoInfo videoInfo = this.D;
        sb5.append(videoInfo != null ? videoInfo.videoId : null);
        sb5.append(" | position = ");
        sb5.append(this.f56455f);
        sb5.append(" | url = ");
        VideoInfo videoInfo2 = this.D;
        if (videoInfo2 == null || (videoUrl = videoInfo2.videoUrl) == null) {
            str3 = "";
        } else {
            str3 = videoUrl.url;
        }
        sb5.append(str3);
        sb5.append(" | text = ");
        BusinessFeedData businessFeedData2 = this.f56454e;
        if (businessFeedData2 != null) {
            str4 = businessFeedData2.getCellSummary().displayStr;
        }
        sb5.append(str4);
        sb5.append(" | hashcode = ");
        sb5.append(hashCode());
        QLog.i("PSLink-QZoneVideoItemWidgetViewQZone_PLAYER", 1, sb5.toString());
    }

    private void h1() {
        QZoneVideoView qZoneVideoView = this.E;
        if (qZoneVideoView == null || qZoneVideoView.getSuperPlayer() == null) {
            return;
        }
        this.E.getSuperPlayer().setXYaxis(2);
        this.E.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1(final boolean z16) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView.4
                @Override // java.lang.Runnable
                public void run() {
                    QZoneVideoItemWidgetView.this.k1(z16);
                }
            });
            return;
        }
        if (!this.M) {
            this.J.setVisibility(8);
            return;
        }
        if (this.J.getVisibility() == 8) {
            this.J.setVisibility(0);
        }
        if (z16) {
            this.J.setImageResource(R.drawable.qui_voice_mute);
        } else {
            this.J.setImageResource(R.drawable.qui_voice_low);
        }
        com.tencent.mobileqq.qzone.picload.c.a().m(this.J, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1(final int i3, final int i16) {
        String str;
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView.3
                @Override // java.lang.Runnable
                public void run() {
                    QZoneVideoItemWidgetView.this.l1(i3, i16);
                }
            });
            return;
        }
        int i17 = i3 - i16;
        if (!this.M) {
            this.I.setVisibility(8);
            c cVar = this.P;
            if (cVar != null) {
                cVar.d(i17);
                return;
            }
            return;
        }
        this.I.setVisibility(0);
        this.I.setText(nh.c.d(i17));
        String e16 = nh.c.e(i17);
        LinearLayout linearLayout = this.H;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\u5269\u4f59\u65f6\u95f4");
        sb5.append(e16);
        sb5.append("\u70b9\u51fb");
        if (this.L) {
            str = "\u6253\u5f00\u58f0\u97f3";
        } else {
            str = "\u9759\u97f3";
        }
        sb5.append(str);
        linearLayout.setContentDescription(sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E0(com.qzone.reborn.feedx.video.c cVar, String str) {
        this.Q = new h(this);
        cVar.b().f(this.Q);
        this.R = new e(this);
        cVar.b().c(this.R);
        this.S = new i(this, str);
        cVar.b().h(this.S);
        this.T = new g(this);
        cVar.b().e(this.T);
        this.V = new f(this);
        cVar.b().d(this.V);
        this.U = new d(this, str);
        cVar.b().a(this.U);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F0() {
        String str;
        if (this.D == null) {
            QLog.e("PSLink-QZoneVideoItemWidgetView", 1, "adjustViewSize  params error");
            return;
        }
        BusinessFeedData businessFeedData = this.f56454e;
        if (businessFeedData == null || businessFeedData.getPictureInfo() == null || bl.b(this.f56454e.getPictureInfo().pics)) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            com.qzone.reborn.feedx.widget.picmixvideo.b.b(getContext(), layoutParams, this.D);
            i1(this.F, layoutParams.width, layoutParams.height);
            i1(this.E, layoutParams.width, layoutParams.height);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("adjustViewSize  | position = ");
            sb5.append(this.f56455f);
            sb5.append(" | text = ");
            BusinessFeedData businessFeedData2 = this.f56454e;
            String str2 = "";
            if (businessFeedData2 == null || businessFeedData2.getCellSummaryV2() == null) {
                str = "";
            } else {
                str = this.f56454e.getCellSummaryV2().displayStr;
            }
            sb5.append(str);
            sb5.append(" | feedKey = ");
            BusinessFeedData businessFeedData3 = this.f56454e;
            if (businessFeedData3 != null) {
                str2 = businessFeedData3.getFeedCommInfo().feedskey;
            }
            sb5.append(str2);
            sb5.append(" | videoWidth = ");
            sb5.append(this.D.width);
            sb5.append(" | videoHeight = ");
            sb5.append(this.D.height);
            sb5.append(" | realWidth = ");
            sb5.append(layoutParams.width);
            sb5.append(" | realHeight = ");
            sb5.append(layoutParams.height);
            QLog.i("PSLink-QZoneVideoItemWidgetView", 1, sb5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G0() {
        VideoInfo videoInfo = this.D;
        if (videoInfo != null && videoInfo.coverUrl != null) {
            Option obtain = Option.obtain();
            obtain.setUrl(this.D.coverUrl.url);
            if (this.F.getLayoutParams() != null) {
                obtain.setRequestWidth(this.F.getLayoutParams().width);
                obtain.setRequestHeight(this.F.getLayoutParams().height);
            }
            obtain.setTargetView(this.F);
            com.qzone.reborn.util.m mVar = com.qzone.reborn.util.m.f59551a;
            obtain.setLoadingDrawable(mVar.b(getContext()));
            obtain.setFailDrawable(mVar.a(getContext()));
            com.tencent.mobileqq.qzone.picload.c.a().i(obtain, K0());
            if (this.E.getSuperPlayer() == null || !this.E.getSuperPlayer().isPlaying()) {
                g1(true);
                return;
            }
            return;
        }
        QLog.e("PSLink-QZoneVideoItemWidgetView", 1, "bindCoverData  params error");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IPicLoadStateListener K0() {
        return new b();
    }

    public boolean N0() {
        return true;
    }

    public ImageView O0() {
        return this.W;
    }

    public boolean P0() {
        return this.L;
    }

    public long S0(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        Long valueOf = Long.valueOf(RFWLayerVideoPlayPosRecorder.INSTANCE.getPlayPosition(nh.c.g(str)));
        if (valueOf != null) {
            return valueOf.longValue();
        }
        return 0L;
    }

    public String U0(VideoInfo videoInfo) {
        if (!TextUtils.isEmpty(videoInfo.videoId)) {
            return videoInfo.videoId;
        }
        return nh.c.g(videoInfo.videoUrl.url);
    }

    public QZoneVideoView V0() {
        return this.E;
    }

    protected boolean X0() {
        return false;
    }

    protected boolean Y0() {
        return false;
    }

    protected boolean Z0() {
        return this.f56454e != null && (this.E.getData() instanceof BusinessFeedData) && TextUtils.equals(((BusinessFeedData) this.E.getData()).getIdInfo().cellId, this.f56454e.getIdInfo().cellId);
    }

    public void a() {
        VideoReport.unbindVideoPlayerInfo(this.E);
        if (this.E.getSuperPlayer() != null) {
            this.E.release();
        }
        g1(true);
        ap.f59791b.e(20, 15, this.f56455f, this.f56454e);
        e1("[releasePlayer]  ");
    }

    public void b1() {
        if (this.E.getOutPutMute()) {
            this.E.setOutPutMute(false);
            k1(false);
            setOutPutMute(false);
        } else {
            this.E.setOutPutMute(true);
            k1(true);
            setOutPutMute(true);
        }
        c cVar = this.P;
        if (cVar != null) {
            cVar.b(this.L);
        }
    }

    public void f1() {
        QZoneVideoView qZoneVideoView;
        if (this.D != null && (qZoneVideoView = this.E) != null) {
            ISuperPlayer superPlayer = qZoneVideoView.getSuperPlayer();
            int Q0 = (int) Q0(this.D);
            e1("[seekToHistoryPos] currentProgress: " + Q0);
            if (superPlayer != null) {
                superPlayer.seekTo(Q0);
                return;
            }
            return;
        }
        e1("[seekToHistoryPos] mVideoInfo: " + this.D + ",mVideoView:" + this.E);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g1(final boolean z16) {
        c cVar;
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView.5
                @Override // java.lang.Runnable
                public void run() {
                    QZoneVideoItemWidgetView.this.g1(z16);
                }
            });
            return;
        }
        ImageView imageView = this.W;
        if (imageView != null && !z16) {
            imageView.setVisibility(8);
        }
        this.F.setVisibility(z16 ? 0 : 8);
        if (this.N) {
            this.G.setVisibility(z16 ? 0 : 8);
        } else {
            this.G.setVisibility(8);
        }
        this.H.setVisibility((z16 && this.M) ? 8 : 0);
        if (this.M || (cVar = this.P) == null) {
            return;
        }
        if (z16) {
            cVar.a();
        } else {
            cVar.c();
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.chp;
    }

    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneMixBaseWidgetView
    protected String getLogTag() {
        return "PSLink-QZoneVideoItemWidgetView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i1(View view, int i3, int i16) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i16;
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j1(boolean z16) {
        VideoInfo videoInfo;
        String str;
        String str2;
        String str3;
        VideoUrl videoUrl;
        QZoneVideoView qZoneVideoView = this.E;
        if (qZoneVideoView != null && (videoInfo = this.D) != null && videoInfo.videoUrl != null) {
            qZoneVideoView.setExchangeUrlProcess(new com.qzone.reborn.feedx.video.process.b(this.f56454e, videoInfo));
            this.E.setData(this.f56454e, this.f56455f);
            String U0 = U0(this.D);
            long j3 = 0;
            if (z16) {
                long playPosition = RFWLayerVideoPlayPosRecorder.INSTANCE.getPlayPosition(U0);
                if (playPosition != 0) {
                    j3 = playPosition;
                }
            }
            com.qzone.reborn.feedx.video.c q16 = com.qzone.reborn.feedx.video.c.l().n(this.D.videoUrl.url).m(this.D.videoId).o(this.D.videoId).r(this.D.videoTime).q((int) j3);
            E0(q16, U0);
            this.E.A0(q16);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[startANewPlayer]  | feedKey = ");
            BusinessFeedData businessFeedData = this.f56454e;
            String str4 = "";
            if (businessFeedData == null) {
                str = "";
            } else {
                str = businessFeedData.getFeedCommInfo().feedskey;
            }
            sb5.append(str);
            sb5.append(" | position = ");
            sb5.append(this.f56455f);
            sb5.append(" | url = ");
            VideoInfo videoInfo2 = this.D;
            if (videoInfo2 == null || (videoUrl = videoInfo2.videoUrl) == null) {
                str2 = "";
            } else {
                str2 = videoUrl.url;
            }
            sb5.append(str2);
            sb5.append(" | id = ");
            VideoInfo videoInfo3 = this.D;
            Object obj = "null";
            if (videoInfo3 == null) {
                str3 = "null";
            } else {
                str3 = videoInfo3.videoId;
            }
            sb5.append(str3);
            sb5.append(" | time = ");
            VideoInfo videoInfo4 = this.D;
            if (videoInfo4 != null) {
                obj = Long.valueOf(videoInfo4.videoTime);
            }
            sb5.append(obj);
            sb5.append(" | text = ");
            BusinessFeedData businessFeedData2 = this.f56454e;
            if (businessFeedData2 != null) {
                str4 = businessFeedData2.getCellSummary().displayStr;
            }
            sb5.append(str4);
            sb5.append(" | playUrlKey = ");
            sb5.append(U0);
            sb5.append(" | startOffset = ");
            sb5.append(j3);
            sb5.append(" | hashcode: ");
            sb5.append(hashCode());
            QLog.d("PSLink-QZoneVideoItemWidgetViewQZone_PLAYER", 1, sb5.toString());
            return;
        }
        QLog.d("PSLink-QZoneVideoItemWidgetViewQZone_PLAYER", 1, "startANewPlayer fail : " + this.E);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneMixBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void bindData(PictureItem pictureItem, int i3) {
        VideoInfo videoInfo;
        super.bindData(pictureItem, i3);
        if (pictureItem != null && (videoInfo = pictureItem.videodata) != null) {
            H0(videoInfo);
        } else {
            QLog.e("PSLink-QZoneVideoItemWidgetView", 1, "bindData  params error");
        }
    }

    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneMixBaseWidgetView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        F0();
    }

    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneMixBaseWidgetView, android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        if (com.qzone.reborn.configx.g.f53821a.b().J1()) {
            F0();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneMixBaseWidgetView
    public ImageView p0() {
        return this.F;
    }

    public void pause() {
        String str;
        VideoUrl videoUrl;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[pause]   | feedKey = ");
        BusinessFeedData businessFeedData = this.f56454e;
        String str2 = "";
        if (businessFeedData == null) {
            str = "";
        } else {
            str = businessFeedData.getFeedCommInfo().feedskey;
        }
        sb5.append(str);
        sb5.append(" | position = ");
        sb5.append(this.f56455f);
        sb5.append(" | url = ");
        VideoInfo videoInfo = this.D;
        if (videoInfo != null && (videoUrl = videoInfo.videoUrl) != null) {
            str2 = videoUrl.url;
        }
        sb5.append(str2);
        sb5.append(" | hashcode = ");
        sb5.append(hashCode());
        QLog.d("PSLink-QZoneVideoItemWidgetViewQZone_PLAYER", 1, sb5.toString());
        if (this.E.getSuperPlayer() != null && this.E.getSuperPlayer().isPlaying()) {
            this.E.getSuperPlayer().pause();
        }
        g1(true);
    }

    public void play() {
        String str;
        VideoUrl videoUrl;
        boolean X0 = X0();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[play]   | feedKey = ");
        BusinessFeedData businessFeedData = this.f56454e;
        String str2 = "";
        if (businessFeedData == null) {
            str = "";
        } else {
            str = businessFeedData.getFeedCommInfo().feedskey;
        }
        sb5.append(str);
        sb5.append(" | position = ");
        sb5.append(this.f56455f);
        sb5.append(" | url = ");
        VideoInfo videoInfo = this.D;
        if (videoInfo != null && (videoUrl = videoInfo.videoUrl) != null) {
            str2 = videoUrl.url;
        }
        sb5.append(str2);
        sb5.append(" | videoInfoAutoPlay = ");
        VideoInfo videoInfo2 = this.D;
        sb5.append(videoInfo2 == null || videoInfo2.isAutoPlay());
        sb5.append(" | ignoreUserAutoPlay = ");
        sb5.append(X0);
        sb5.append(" | this = ");
        sb5.append(this);
        QLog.d("PSLink-QZoneVideoItemWidgetViewQZone_PLAYER", 1, sb5.toString());
        if (!X0) {
            boolean m3 = com.qzone.adapter.feedcomponent.i.H().m();
            QLog.d("PSLink-QZoneVideoItemWidgetView", 1, "[play]  userCanAutoPlay = " + m3);
            if (!m3) {
                return;
            }
        }
        VideoInfo videoInfo3 = this.D;
        if (videoInfo3 == null || videoInfo3.isAutoPlay()) {
            ISuperPlayer superPlayer = this.E.getSuperPlayer();
            if (superPlayer != null) {
                d1(superPlayer);
            } else {
                j1(!this.K);
            }
        }
    }

    public void setAnimCoverView(ImageView imageView) {
        this.W = imageView;
    }

    public void setIsPlayFromStart(boolean z16) {
        this.K = z16;
    }

    public void setIsTimeMuteLayoutVisible(boolean z16) {
        this.M = z16;
        LinearLayout linearLayout = this.H;
        if (linearLayout != null) {
            linearLayout.setVisibility(z16 ? 0 : 8);
        }
    }

    public void setOutPutMute(boolean z16) {
        this.L = z16;
        ImageView imageView = this.F;
        if (imageView != null) {
            imageView.setTag(RFWLaunchKey.ID_VIDEO_MUTE, Boolean.valueOf(z16));
        }
    }

    public void setPlayIconVisible(boolean z16) {
        this.N = z16;
        ImageView imageView = this.G;
        if (imageView != null) {
            imageView.setVisibility(z16 ? 0 : 8);
        }
    }

    public void setVideoStateBroadcastCallback(c cVar) {
        this.P = cVar;
    }

    public QZoneVideoItemWidgetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QZoneVideoItemWidgetView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.K = false;
        this.L = true;
        this.M = true;
        this.N = true;
        W0();
        setOutPutMute(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static QZoneVideoItemWidgetView T0(WeakReference<QZoneVideoItemWidgetView> weakReference) {
        if (weakReference == null) {
            QLog.e("PSLink-QZoneVideoItemWidgetView", 1, "getVideoItemWidgetView  weakReference == null");
            return null;
        }
        QZoneVideoItemWidgetView qZoneVideoItemWidgetView = weakReference.get();
        if (qZoneVideoItemWidgetView != null) {
            return qZoneVideoItemWidgetView;
        }
        QLog.e("PSLink-QZoneVideoItemWidgetView", 1, "getVideoItemWidgetView  widgetView == null");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J0(QZonePlayer qZonePlayer) {
        String str;
        if (qZonePlayer == null || this.D == null) {
            return true;
        }
        if (TextUtils.equals(qZonePlayer.h().c(), this.D.videoUrl.url)) {
            return false;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("checkIsNotSameVideo   url not equals | player.playUrl = ");
        sb5.append(qZonePlayer.h().c());
        sb5.append(" | feedKey = ");
        BusinessFeedData businessFeedData = this.f56454e;
        String str2 = "";
        if (businessFeedData == null) {
            str = "";
        } else {
            str = businessFeedData.getFeedCommInfo().feedskey;
        }
        sb5.append(str);
        sb5.append(" | videoId = ");
        sb5.append(this.D.videoId);
        sb5.append(" | position = ");
        sb5.append(this.f56455f);
        sb5.append(" | url = ");
        VideoUrl videoUrl = this.D.videoUrl;
        if (videoUrl != null) {
            str2 = videoUrl.url;
        }
        sb5.append(str2);
        sb5.append(" | hashcode = ");
        sb5.append(hashCode());
        QLog.w("PSLink-QZoneVideoItemWidgetViewQZone_PLAYER", 1, sb5.toString());
        return true;
    }

    public void H0(VideoInfo videoInfo) {
        String str;
        if (videoInfo == null) {
            return;
        }
        this.D = videoInfo;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[bindVideoInfoData]   | feedKey = ");
        BusinessFeedData businessFeedData = this.f56454e;
        String str2 = "";
        if (businessFeedData == null) {
            str = "";
        } else {
            str = businessFeedData.getFeedCommInfo().feedskey;
        }
        sb5.append(str);
        sb5.append(" | position = ");
        sb5.append(this.f56455f);
        sb5.append(" | url = ");
        VideoUrl videoUrl = this.D.videoUrl;
        if (videoUrl != null) {
            str2 = videoUrl.url;
        }
        sb5.append(str2);
        sb5.append(" | hashcode = ");
        sb5.append(hashCode());
        QLog.d("PSLink-QZoneVideoItemWidgetViewQZone_PLAYER", 4, sb5.toString());
        F0();
        G0();
        I0();
        l1((int) this.D.videoTime, 0);
    }

    protected void W0() {
        RoundCorneredFrameLayout roundCorneredFrameLayout = (RoundCorneredFrameLayout) findViewById(R.id.n6k);
        this.f56457i = roundCorneredFrameLayout;
        roundCorneredFrameLayout.setRadius(DisplayUtil.dip2px(MobileQQ.sMobileQQ, 2.0f));
        this.E = (QZoneVideoView) findViewById(R.id.ndb);
        this.F = (ImageView) findViewById(R.id.mth);
        ImageView imageView = (ImageView) findViewById(R.id.l2y);
        this.G = imageView;
        imageView.setImageResource(R.drawable.f153484);
        this.H = (LinearLayout) findViewById(R.id.m_y);
        this.I = (TextView) findViewById(R.id.nks);
        this.J = (ImageView) findViewById(R.id.f162750ln3);
        this.H.setOnClickListener(new a());
        AccessibilityUtil.s(this, com.qzone.util.l.a(R.string.f2202968q));
    }

    public long Q0(VideoInfo videoInfo) {
        VideoUrl videoUrl;
        if (videoInfo == null) {
            return 0L;
        }
        Long valueOf = !TextUtils.isEmpty(videoInfo.videoId) ? Long.valueOf(RFWLayerVideoPlayPosRecorder.INSTANCE.getPlayPosition(videoInfo.videoId)) : null;
        if (valueOf == null && (videoUrl = videoInfo.videoUrl) != null && !TextUtils.isEmpty(videoUrl.url)) {
            valueOf = Long.valueOf(S0(videoInfo.videoUrl.url));
        }
        if (valueOf != null) {
            return valueOf.longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class e implements lh.c {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QZoneVideoItemWidgetView> f56483a;

        e(QZoneVideoItemWidgetView qZoneVideoItemWidgetView) {
            this.f56483a = new WeakReference<>(qZoneVideoItemWidgetView);
        }

        @Override // lh.c
        public void onVideoLoopStart() {
            QZoneVideoItemWidgetView T0 = QZoneVideoItemWidgetView.T0(this.f56483a);
            if (T0 == null) {
                return;
            }
            ap.f59791b.e(20, 17, T0.f56455f, T0.f56454e);
        }

        @Override // lh.c
        public void onVideoLoopEnd() {
        }
    }

    @Override // gf.r
    public QZoneVideoItemWidgetView d() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class i implements lh.h {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QZoneVideoItemWidgetView> f56487a;

        /* renamed from: b, reason: collision with root package name */
        private final String f56488b;

        public i(QZoneVideoItemWidgetView qZoneVideoItemWidgetView, String str) {
            this.f56487a = new WeakReference<>(qZoneVideoItemWidgetView);
            this.f56488b = str;
        }

        @Override // lh.h
        public void onProgress(String str, int i3, int i16) {
            QZoneVideoItemWidgetView T0 = QZoneVideoItemWidgetView.T0(this.f56487a);
            if (T0 == null) {
                return;
            }
            RFWLayerVideoPlayPosRecorder.INSTANCE.updatePlayPosition(this.f56488b, i16);
            T0.l1(i3, i16);
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
