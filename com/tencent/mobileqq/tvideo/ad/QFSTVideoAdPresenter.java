package com.tencent.mobileqq.tvideo.ad;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.event.ah;
import com.tencent.biz.qqcircle.immersive.feed.event.h;
import com.tencent.biz.qqcircle.immersive.feed.event.s;
import com.tencent.biz.qqcircle.immersive.utils.ac;
import com.tencent.biz.qqcircle.immersive.views.QFSTVKVideoView;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.RFWTVKPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerCompletionListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSecondBufferListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.QFSTVideoAdPresenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.mobileqq.tvideo.channel.event.QFSTVideoScreenChangedEvent;
import com.tencent.mobileqq.tvideo.channel.event.QFSTVideoScreenTouchEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoFeedsAdItemSelectedEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoFloatingWindowEntranceVisibleEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetFactory;
import com.tencent.qqlive.tvkplayer.view.TVKPlayerVideoView;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.tvideo.protocol.pb.AdFeedInfo;
import e60.k;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import jy2.g;
import pw2.p;
import tvideo.Ads;

/* loaded from: classes19.dex */
public class QFSTVideoAdPresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements uw2.a, xw2.a, k.b {
    private QFSTVKVideoView I;
    private xw2.b J;
    private xw2.d K;
    private uw2.b L;
    private boolean M;
    private long N;
    private RFWPlayerOptions Q;
    private int P = 0;
    private final QAdCardExtraData R = new QAdCardExtraData();

    /* loaded from: classes19.dex */
    private @interface PlayState {
        public static final int COMPLETE = 4;
        public static final int ERROR = 5;
        public static final int PAUSE = 2;
        public static final int PLAYING = 1;
        public static final int UNKNOWN = 0;
    }

    private void A1() {
        this.R.b(QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_IS_VR_REPORT_PARAM, new QAdVrReportParams.a().i());
    }

    private void B1() {
        if (this.Q == null) {
            RFWPlayerOptions obtain = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.TENCENT_VIDEO_PLAYER());
            this.Q = obtain;
            p1(obtain);
        }
    }

    private boolean C1() {
        return ScreenUtils.isLandscape();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E1(ISuperPlayer iSuperPlayer) {
        RFWLog.d("QFSTVideoAdPresenter", RFWLog.CLR, "[onCompletion] current is auto scroll: ");
        this.P = 4;
        xw2.b bVar = this.J;
        if (bVar != null) {
            bVar.b(this.K);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F1(RFWPlayerOptions rFWPlayerOptions, int i3, int i16, int i17, String str, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        T0(new s(rFWPlayerOptions, i3, i16, i17, str, feedCloudMeta$StFeed));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void G1(final RFWPlayerOptions rFWPlayerOptions, final int i3, final int i16, final int i17, final String str) {
        if (rFWPlayerOptions.isPlayerByDirectIP()) {
            QLog.d("QFSTVideoAdPresenter", 1, "error play by ip return");
            return;
        }
        this.P = 5;
        this.N = 0L;
        xw2.b bVar = this.J;
        if (bVar != null) {
            bVar.l(i17, str);
        }
        final FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) this.f85017h;
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.c
            @Override // java.lang.Runnable
            public final void run() {
                QFSTVideoAdPresenter.this.F1(rFWPlayerOptions, i3, i16, i17, str, feedCloudMeta$StFeed);
            }
        });
    }

    private void I1(boolean z16) {
        QFSTVKVideoView qFSTVKVideoView = this.I;
        if (qFSTVKVideoView != null && qFSTVKVideoView.getSuperPlayer() != null) {
            this.I.pause();
            if (z16) {
                xw2.b bVar = this.J;
                if (bVar != null) {
                    bVar.i(this.K);
                }
            } else {
                xw2.b bVar2 = this.J;
                if (bVar2 != null) {
                    bVar2.g(this.K);
                }
            }
            this.P = 2;
            RFWLog.d(getTAG(), RFWLog.USR, "pause success");
        }
    }

    private void J1() {
        this.M = false;
        this.N = 0L;
        this.P = 0;
    }

    private void K1(boolean z16) {
        uw2.b bVar = this.L;
        if (bVar != null) {
            bVar.i(z16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void L1() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) this.f85017h;
        QFSVideoView.D = new WeakReference<>(this.I);
        O1();
        RFWLog.d("QFSTVideoAdPresenter_" + this.Q.tag(), RFWLog.USR, "fs_lifecycle  startANewPlayer:" + ac.f90062a.a(feedCloudMeta$StFeed.content.get()));
        this.I.loadPlayOptions(this.Q);
    }

    private void M1(boolean z16) {
        if (z16) {
            long j3 = this.N;
            if (j3 > 0) {
                this.I.seek(j3);
            }
        }
        this.I.start();
        if (this.P == 2) {
            xw2.b bVar = this.J;
            if (bVar != null) {
                bVar.h(this.K);
            }
        } else {
            xw2.b bVar2 = this.J;
            if (bVar2 != null) {
                bVar2.e(this.K, this.M, v1());
            }
        }
        this.P = 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000c, code lost:
    
        if (r4 == 1) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void N1(int i3) {
        boolean z16;
        if (this.L == null) {
            return;
        }
        if (C1()) {
            z16 = true;
        }
        z16 = false;
        this.R.b(QAdCardExtraData.AdExtraInnerKey.AD_RETURN_BTN_VISIBLE, Boolean.valueOf(z16));
        int dimensionPixelSize = m0().getResources().getDimensionPixelSize(R.dimen.dh_);
        if (!z16) {
            dimensionPixelSize = m0().getResources().getDimensionPixelSize(R.dimen.dh9);
        }
        this.R.b(QAdCardExtraData.AdExtraInnerKey.AD_TITLE_LAYOUT_MARGIN_LEFT, Integer.valueOf(dimensionPixelSize));
        uw2.b bVar = this.L;
        if (bVar != null) {
            bVar.e(this.R);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void O1() {
        this.Q.setFileId(((FeedCloudMeta$StFeed) this.f85017h).video.fileId.get()).setFromType(8).setTVKPlayerOption(RFWTVKPlayerOptions.obtain().setTVKPlayerVideoInfo(z1()).setDefinition(hy2.a.f406605a.a()));
        this.Q.setStartOffset(this.N);
    }

    private void a() {
        QFSTVKVideoView qFSTVKVideoView = this.I;
        if (qFSTVKVideoView != null) {
            qFSTVKVideoView.release();
        }
    }

    private void o1() {
        View h16;
        uw2.b bVar = this.L;
        if (bVar != null && (h16 = bVar.h()) != null && h16.getParent() == null) {
            ((ViewGroup) this.C).addView(h16, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void p1(RFWPlayerOptions rFWPlayerOptions) {
        if (rFWPlayerOptions == null) {
            return;
        }
        s1(rFWPlayerOptions);
        q1(rFWPlayerOptions);
        r1(rFWPlayerOptions);
        t1(rFWPlayerOptions);
        u1(rFWPlayerOptions);
    }

    private void q1(RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addCompletionListener(new IRFWPlayerCompletionListener() { // from class: com.tencent.mobileqq.tvideo.ad.b
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerCompletionListener
            public final void onCompletion(ISuperPlayer iSuperPlayer) {
                QFSTVideoAdPresenter.this.E1(iSuperPlayer);
            }
        });
    }

    private void r1(@NonNull final RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addErrorStatusListener(new IRFWPlayErrorStatusListener() { // from class: com.tencent.mobileqq.tvideo.ad.a
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener
            public final void onVideoPlayError(int i3, int i16, int i17, String str) {
                QFSTVideoAdPresenter.this.G1(rFWPlayerOptions, i3, i16, i17, str);
            }
        });
    }

    private void s1(RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addPrepareListeners(new b());
    }

    private void t1(RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addSecondBufferListeners(new a());
    }

    private void u1(@NonNull RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addSeekListeners(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public sv2.a v1() {
        RFWPlayer qCirclePlayer;
        sv2.a aVar = new sv2.a();
        aVar.f434840i = C1();
        aVar.f434838g = y1(this.K);
        aVar.f434849r = D1();
        QFSTVKVideoView qFSTVKVideoView = this.I;
        if (qFSTVKVideoView != null && (qCirclePlayer = qFSTVKVideoView.getQCirclePlayer()) != null) {
            aVar.f434834c = qCirclePlayer.getVideoDuration();
            aVar.f434846o = qCirclePlayer.getPlayTime();
            aVar.f434843l = qCirclePlayer.getPlayTime();
            aVar.f434835d = qCirclePlayer.getPlayTime();
            aVar.f434833b = qCirclePlayer.getPlayTime();
            aVar.f434842k = String.valueOf(qCirclePlayer.getVideoPlayId());
        }
        HashMap hashMap = new HashMap();
        aVar.f434837f = hashMap;
        hashMap.put(QAdVrReportParams.ParamKey.VR_PAGE_ID, Integer.valueOf(y0()));
        return aVar;
    }

    private xw2.c w1() {
        xw2.c cVar = new xw2.c();
        cVar.f448916a = v1();
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x1(ISuperPlayer iSuperPlayer) {
        xw2.b bVar = this.J;
        if (bVar != null) {
            bVar.m(this.K);
        }
        QLog.d("QFSTVideoAdPresenter", 1, "doOnVideoPrepare");
        if (this.I != null && this.f85017h != 0 && iSuperPlayer != null && J0()) {
            ((TVKPlayerVideoView) this.I.getQCirclePlayer().getVideoView()).setXYaxis(0);
            M1(true);
        }
    }

    @NonNull
    private String y1(xw2.d dVar) {
        if (dVar != null) {
            return dVar.a();
        }
        return "";
    }

    private TVKPlayerVideoInfo z1() {
        TVKPlayerVideoInfo tVKPlayerVideoInfo = new TVKPlayerVideoInfo(TVKAssetFactory.createOnlineVodVidAsset(y1(this.K), y1(this.K)));
        tVKPlayerVideoInfo.setPlayType(2);
        tVKPlayerVideoInfo.addExtraRequestParamsMap("scene", "playerUiType=10&ext_platform=6220303");
        return tVKPlayerVideoInfo;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(h hVar) {
        super.C0(hVar);
        if (hVar instanceof ah) {
            QLog.d("QFSTVideoAdPresenter", 1, "handleBroadcastMessage" + ((ah) hVar).a());
        }
    }

    public boolean D1() {
        return this.I.getOutPutMute();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: H1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        boolean z16;
        super.L0(feedCloudMeta$StFeed, i3);
        J1();
        Ads p16 = g.p((FeedCloudMeta$StFeed) this.f85017h);
        AdFeedInfo build = new AdFeedInfo.a().build();
        try {
            build = (AdFeedInfo) p.c(AdFeedInfo.class, p16.ad_feed_info);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (this.L != null) {
            if (C1() && !cy2.b.e().k()) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.R.b(QAdCardExtraData.AdExtraInnerKey.AD_RETURN_BTN_VISIBLE, Boolean.valueOf(!z16));
            this.L.e(this.R);
            this.L.g(build);
            this.L.f(C1());
            this.L.a(this);
        }
        o1();
        QFSTVKVideoView qFSTVKVideoView = this.I;
        if (qFSTVKVideoView != null) {
            qFSTVKVideoView.setData(feedCloudMeta$StFeed, i3);
        }
    }

    @Override // xw2.a
    public void I(xw2.b bVar) {
        QLog.d("QFSTVideoAdPresenter", 1, "unregisterListener");
        this.J = null;
    }

    @Override // uw2.a
    public void K() {
        QLog.d("QFSTVideoAdPresenter", 1, "onEnterLandingPage");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        super.K0();
        uw2.b bVar = this.L;
        if (bVar != null) {
            bVar.b();
        }
        k.j().p(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        super.M0();
        uw2.b bVar = this.L;
        if (bVar != null) {
            bVar.c();
        }
        a();
        k.j().s(this);
    }

    @Override // e60.k.b
    public boolean M8(int i3) {
        uw2.b bVar = this.L;
        boolean z16 = false;
        if (bVar == null) {
            return false;
        }
        if (3 == i3 || 4 == i3) {
            z16 = true;
        }
        bVar.f(z16);
        return true;
    }

    @Override // uw2.a
    public void N(boolean z16) {
        QLog.d("QFSTVideoAdPresenter", 1, "changeScreenMode isisVerticalStandard = " + z16);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        uw2.b a16 = sw2.a.a(m0());
        this.L = a16;
        a16.d(this);
        this.I = (QFSTVKVideoView) view.findViewById(R.id.f74163vi);
        B1();
        A1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        if (eventClass != null) {
            eventClass.add(QFSTVideoScreenTouchEvent.class);
        }
        return eventClass;
    }

    @Override // xw2.a
    public xw2.c o() {
        return w1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        super.onDestroy();
        RFWLog.d("QFSTVideoAdPresenter", RFWLog.USR, "fs_lifecycle onDestroy: | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | playView is null | pageId:" + y0());
        a();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        this.M = false;
        if (rFWFeedSelectInfo.getPosition() != this.f85018i) {
            return;
        }
        if (this.L != null) {
            N1(cy2.b.e().f());
            this.L.f(C1());
        }
        K1(true);
        xw2.b bVar = this.J;
        if (bVar != null) {
            bVar.f(w1());
        }
        if (this.P == 4) {
            return;
        }
        if (this.I.isRelease()) {
            L1();
        } else {
            M1(true);
        }
        gy2.c.E("", "", 0, "feeds_ad");
        SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoFloatingWindowEntranceVisibleEvent(false));
        SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoFeedsAdItemSelectedEvent());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (rFWFeedSelectInfo == null || rFWFeedSelectInfo.getPosition() != this.f85018i) {
            return;
        }
        RFWLog.d("QFSTVideoAdPresenter", RFWLog.USR, "onUnSelected:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
        K1(false);
        if (this.P == 1) {
            I1(false);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onPaused(rFWFeedSelectInfo);
        RFWLog.d("QFSTVideoAdPresenter", RFWLog.USR, "fs_lifecycle onPaused:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + APLogFileUtil.SEPARATOR_LOG + hashCode());
        K1(false);
        if (this.P == 1) {
            I1(false);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSTVideoScreenChangedEvent) {
            N1(((QFSTVideoScreenChangedEvent) simpleBaseEvent).getUiState());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onResumed(rFWFeedSelectInfo);
        K1(true);
        if (this.I == null) {
            RFWLog.d("QFSTVideoAdPresenter", RFWLog.USR, "onResumed:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + APLogFileUtil.SEPARATOR_LOG + hashCode() + "|playView is null");
            return;
        }
        if (!J0()) {
            RFWLog.d("QFSTVideoAdPresenter", RFWLog.USR, "onResumed" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + APLogFileUtil.SEPARATOR_LOG + hashCode() + "|notVideoOnScreen");
            return;
        }
        if (this.P != 4) {
            if (this.I.isRelease()) {
                L1();
            } else {
                M1(false);
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onStop(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onStop(rFWFeedSelectInfo);
        RFWLog.d("QFSTVideoAdPresenter", RFWLog.USR, "fs_lifecycle onStop:" + rFWFeedSelectInfo + " |  | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | playView is null | pageId:" + y0());
    }

    @Override // xw2.a
    public void pause() {
        QLog.d("QFSTVideoAdPresenter", 1, "pause");
        I1(false);
    }

    @Override // xw2.a
    public void replay() {
        this.M = true;
        this.N = 0L;
        QLog.d("QFSTVideoAdPresenter", 1, "replay");
        L1();
    }

    @Override // xw2.a
    public void start() {
        QLog.d("QFSTVideoAdPresenter", 1, "start");
        M1(true);
    }

    @Override // xw2.a
    public void t(xw2.d dVar) {
        this.K = dVar;
    }

    @Override // xw2.a
    public boolean u(xw2.b bVar) {
        QLog.d("QFSTVideoAdPresenter", 1, "registerListener");
        this.J = bVar;
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSTVideoAdPresenter";
    }

    @Override // xw2.a
    public void z(View view) {
        QLog.d("QFSTVideoAdPresenter", 1, "setDisplay");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class a implements IRFWPlayerSecondBufferListener {
        a() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSecondBufferListener
        public void onSecondBufferEnd() {
            QFSTVideoAdPresenter.this.x0().post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.d
                @Override // java.lang.Runnable
                public final void run() {
                    QFSTVideoAdPresenter.a.c();
                }
            });
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSecondBufferListener
        public void onSecondBufferStart() {
            QFSTVideoAdPresenter.this.x0().post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.e
                @Override // java.lang.Runnable
                public final void run() {
                    QFSTVideoAdPresenter.a.d();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class b implements IRFWPlayerPrepareListener {
        b() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onVideoPrepared(RFWPlayer rFWPlayer) {
            QFSTVideoAdPresenter.this.x1(rFWPlayer.getRealPlayer());
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onFirstFrameRendered(RFWPlayer rFWPlayer) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class c implements IRFWPlayerSeekListener {
        c() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onProgress(String str, int i3, int i16) {
            long j3 = i16;
            QFSTVideoAdPresenter.this.N = j3;
            if (QFSTVideoAdPresenter.this.J != null) {
                sv2.a v16 = QFSTVideoAdPresenter.this.v1();
                v16.f434833b = j3;
                v16.f434835d = j3;
                v16.f434846o = j3;
                v16.f434834c = i3;
                v16.f434843l = j3;
                QFSTVideoAdPresenter.this.J.j(QFSTVideoAdPresenter.this.K, v16);
            }
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onSeekBarProgressChanged(SeekBar seekBar, int i3, boolean z16) {
        }
    }

    @Override // uw2.a
    public void M() {
    }
}
