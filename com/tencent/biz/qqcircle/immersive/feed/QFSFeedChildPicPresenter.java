package com.tencent.biz.qqcircle.immersive.feed;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.activity.QCircleFolderActivity;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QFSMusicCurrentProgressEvent;
import com.tencent.biz.qqcircle.events.QFSRestartAudioEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSSeekEvent;
import com.tencent.biz.qqcircle.immersive.feed.av;
import com.tencent.biz.qqcircle.immersive.feed.dr;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFeedItemScaleGestureEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFeedItemTouchEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSPicFeedPlayEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSPicFullPreViewEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSQzoneFirstVideoAutoSlideEvent;
import com.tencent.biz.qqcircle.immersive.gallery.view.QFSGalleryProgressViewNoAnim;
import com.tencent.biz.qqcircle.immersive.personal.utils.QFSRecentlyWatchedRecorder;
import com.tencent.biz.qqcircle.immersive.report.QFSImageBannerReport;
import com.tencent.biz.qqcircle.immersive.request.QFSGetMusicInfoRequest;
import com.tencent.biz.qqcircle.immersive.views.QFSAudioBannerView;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.widgets.QFSGalleryPreListView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.biz.richframework.video.rfw.view.RFWVideoView;
import com.tencent.libra.decode.LibraRequestKey;
import com.tencent.libra.download.LibraDownloadKey;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.event.QCircleSeekAreaEvent;
import com.tencent.mobileqq.qcircle.api.event.QFSApertureExposeFeedEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.sender.call.Call;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StFeedMusic;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StTagInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import qqcircle.QQCircleSmartMatchMusic$MusicInfoRsp;
import qqcircle.QQCircleSmartMatchMusic$SongInfo;

/* loaded from: classes4.dex */
public class QFSFeedChildPicPresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener, dr.b {

    /* renamed from: m0, reason: collision with root package name */
    public static WeakReference<QFSImageBanner> f85133m0;
    private FrameLayout J;
    private LinearLayout K;
    private TextView L;
    private TextView M;
    private View N;
    private TextView P;
    private QFSImageBanner Q;
    private ImageView R;
    private FrameLayout S;
    private QFSGalleryProgressViewNoAnim T;
    private QFSImageBannerReport U;
    private QFSAudioBannerView V;
    private com.tencent.biz.qqcircle.immersive.views.banner.i X;

    /* renamed from: a0, reason: collision with root package name */
    private QFSPicFeedPlayEvent f85134a0;

    /* renamed from: b0, reason: collision with root package name */
    private QFSGalleryPreListView f85135b0;

    /* renamed from: c0, reason: collision with root package name */
    private View f85136c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f85137d0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f85139f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f85140g0;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f85141h0;

    /* renamed from: i0, reason: collision with root package name */
    private av.a f85142i0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f85145l0;
    private int W = 0;
    private long Y = 0;
    private int Z = 0;

    /* renamed from: e0, reason: collision with root package name */
    private final ConcurrentHashMap<String, Integer> f85138e0 = new ConcurrentHashMap<>();

    /* renamed from: j0, reason: collision with root package name */
    private final Runnable f85143j0 = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildPicPresenter.1
        @Override // java.lang.Runnable
        public void run() {
            QFSFeedChildPicPresenter.this.T1();
        }
    };

    /* renamed from: k0, reason: collision with root package name */
    private final av.b f85144k0 = new d();
    private final boolean I = ac0.c.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i3) {
            super.onPageScrollStateChanged(i3);
            if (i3 == 0) {
                QFSFeedChildPicPresenter.this.x2();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            super.onPageSelected(i3);
            QFSFeedChildPicPresenter.this.s2(i3);
            QFSFeedChildPicPresenter.this.M2(i3);
            if (QFSFeedChildPicPresenter.this.Z != i3) {
                QFSFeedChildPicPresenter.this.Z = i3;
                QFSFeedChildPicPresenter.this.D2(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements QFSImageBanner.f {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.f
        public void a() {
            QFSFeedChildPicPresenter.this.M1(true);
        }
    }

    /* loaded from: classes4.dex */
    class d implements av.b {
        d() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.feed.av.b
        public void a(av.a aVar) {
            QFSFeedChildPicPresenter.this.f85142i0 = aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.biz.qqcircle.immersive.feed.av.b
        public void b() {
            QFSFeedChildPicPresenter qFSFeedChildPicPresenter = QFSFeedChildPicPresenter.this;
            T t16 = qFSFeedChildPicPresenter.f85017h;
            if (t16 != 0) {
                qFSFeedChildPicPresenter.n2(((FeedCloudMeta$StFeed) t16).f398449id.get());
            }
        }

        @Override // com.tencent.biz.qqcircle.immersive.feed.av.b
        public boolean isPlaying() {
            return QFSFeedChildPicPresenter.this.e2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements QFSGalleryPreListView.d {
        e() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSGalleryPreListView.d
        public void onSelected(int i3) {
            QFSFeedChildPicPresenter.this.Q.setCurrentItem(i3, false);
            QFSFeedChildPicPresenter.this.L2(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class f implements IRFWPlayErrorStatusListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeedMusic f85151d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f85152e;

        f(FeedCloudMeta$StFeedMusic feedCloudMeta$StFeedMusic, int i3) {
            this.f85151d = feedCloudMeta$StFeedMusic;
            this.f85152e = i3;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener
        public void onVideoPlayError(int i3, int i16, int i17, String str) {
            if (QFSFeedChildPicPresenter.this.V != null && QFSFeedChildPicPresenter.this.V.getSuperPlayer() != null) {
                QFSFeedChildPicPresenter.this.w2(this.f85151d.MID.get(), this.f85151d.playUrl.get(), this.f85152e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class g implements Call.OnRspCallBack<QCircleBaseRequest> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f85154d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f85155e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f85156f;

        g(String str, int i3, String str2) {
            this.f85154d = str;
            this.f85155e = i3;
            this.f85156f = str2;
        }

        @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(boolean z16, long j3, String str, QCircleBaseRequest qCircleBaseRequest, Object obj, Bundle bundle) {
            if (QFSFeedChildPicPresenter.this.V != null && (obj instanceof QQCircleSmartMatchMusic$MusicInfoRsp)) {
                QQCircleSmartMatchMusic$MusicInfoRsp qQCircleSmartMatchMusic$MusicInfoRsp = (QQCircleSmartMatchMusic$MusicInfoRsp) obj;
                if (qQCircleSmartMatchMusic$MusicInfoRsp.musicListInfo.isEmpty()) {
                    QLog.i("PIC-QFSFeedChildPicPresenter", 1, "[requestMusicInfo] musicListInfo is null");
                    return;
                }
                QQCircleSmartMatchMusic$SongInfo qQCircleSmartMatchMusic$SongInfo = qQCircleSmartMatchMusic$MusicInfoRsp.musicListInfo.get().get(0).songInfo;
                if (qQCircleSmartMatchMusic$SongInfo == null) {
                    QLog.i("PIC-QFSFeedChildPicPresenter", 1, "[requestMusicInfo] songInfo is null");
                    return;
                }
                RFWPlayerOptions startOffset = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).setFileId(this.f85154d).setPlayUrl(qQCircleSmartMatchMusic$SongInfo.get().PlayUrl.get()).setIsVideo(false).setStartOffset(this.f85155e);
                QFSFeedChildPicPresenter.this.z1(startOffset, this.f85156f);
                QFSFeedChildPicPresenter.this.V.loadPlayOptions(startOffset);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class h extends RFWPlayerIOC {
        h() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        public RFWPlayerReportInfo<e30.b> getBusinessReportInfo() {
            QFSFeedChildPicPresenter qFSFeedChildPicPresenter = QFSFeedChildPicPresenter.this;
            return gb0.b.m(qFSFeedChildPicPresenter.E.o("KEY_RFW_VIDEO_FEED_POI", Integer.valueOf(qFSFeedChildPicPresenter.f85018i)));
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        public boolean isValid() {
            return QFSFeedChildPicPresenter.this.d2();
        }
    }

    /* loaded from: classes4.dex */
    class k implements QFSGalleryProgressViewNoAnim.a {
        k() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.gallery.view.QFSGalleryProgressViewNoAnim.a
        public void a(int i3, int i16) {
            if (i3 >= i16) {
                i3 = i16 - 1;
            }
            if (QFSFeedChildPicPresenter.this.M != null) {
                QFSFeedChildPicPresenter.this.M.setText((i3 + 1) + "/" + i16);
            }
        }
    }

    private void A1(RFWPlayerOptions rFWPlayerOptions, FeedCloudMeta$StFeedMusic feedCloudMeta$StFeedMusic, int i3) {
        rFWPlayerOptions.getListenerSet().addErrorStatusListener(new f(feedCloudMeta$StFeedMusic, i3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void A2() {
        QFSAudioBannerView qFSAudioBannerView = this.V;
        if (qFSAudioBannerView != null && qFSAudioBannerView.getSuperPlayer() != null) {
            this.V.start();
            this.V.seek(w20.a.j().c(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get()));
            N2(false);
            return;
        }
        QLog.d("PIC-QFSFeedChildPicPresenter", 1, "[resumePlayer] current play view or player is null, end flow.");
    }

    private void B1() {
        int i3 = 0;
        QFSFeedItemScaleGestureEvent playStatusProvider = new QFSFeedItemScaleGestureEvent(1.0f, 0).setPlayStatusProvider(this.f85144k0);
        if (m0() != null) {
            i3 = m0().hashCode();
        }
        playStatusProvider.mHashCode = i3;
        SimpleEventBus.getInstance().dispatchEvent(playStatusProvider);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void B2() {
        if (TextUtils.equals(q0(), QCircleDaTongConstant.PageId.PG_XSJ_AVATAR_APERTURE_PAGE) && this.f85017h != 0) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSApertureExposeFeedEvent(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get()));
        }
    }

    private boolean C1() {
        if (s0() != null && this.V != null && d2()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void C2() {
        if (s0() == null) {
            return;
        }
        com.tencent.biz.qqcircle.helpers.e.f84616a.c(s0().getInitBean(), (FeedCloudMeta$StFeed) this.f85017h);
    }

    private boolean D1() {
        if (s0() != null && this.Q != null && d2() && !QCirclePluginUtil.isSharePanelOnShow()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void D2(int i3) {
        t40.a s06 = s0();
        if (s06 == null) {
            return;
        }
        QLog.d("PIC-QFSFeedChildPicPresenter", 1, "sendEvent " + i3);
        if (this.f85134a0 == null) {
            this.f85134a0 = new QFSPicFeedPlayEvent();
        }
        QFSPicFeedPlayEvent qFSPicFeedPlayEvent = this.f85134a0;
        qFSPicFeedPlayEvent.progress = i3;
        qFSPicFeedPlayEvent.indexInFeed = this.f85018i;
        qFSPicFeedPlayEvent.globalKey = s06.getViewModelKey();
        this.f85134a0.feedId = ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get();
        SimpleEventBus.getInstance().dispatchEvent(this.f85134a0);
    }

    private boolean E1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.images.size() > 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void E2() {
        if (this.X == null) {
            return;
        }
        boolean z16 = false;
        if (this.I) {
            if (f2((FeedCloudMeta$StFeed) this.f85017h)) {
                this.X.setEnableLoop(false);
                this.X.r0(true);
                this.f85141h0 = false;
            } else {
                this.f85141h0 = true;
                this.X.setEnableLoop(true);
                this.X.r0(false);
            }
        } else {
            if (g2() && f2((FeedCloudMeta$StFeed) this.f85017h)) {
                z16 = true;
            }
            boolean z17 = !z16;
            this.f85141h0 = z17;
            this.X.setEnableLoop(z17);
            this.X.r0(!this.f85141h0);
        }
        J2();
        QFSImageBanner qFSImageBanner = this.Q;
        if (qFSImageBanner != null) {
            qFSImageBanner.setEnableOperate(this.I);
        }
    }

    private void F1() {
        if (this.f85145l0) {
            return;
        }
        x0().postDelayed(this.f85143j0, L1());
        this.f85145l0 = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void G1() {
        LinearLayout linearLayout = this.K;
        if (linearLayout != null && this.f85017h != 0) {
            VideoReport.setElementId(linearLayout, QCircleDaTongConstant.ElementId.EM_XSJ_PICTURE_BUTTON);
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_amount", Integer.valueOf(((FeedCloudMeta$StFeed) this.f85017h).images.size()));
            VideoReport.setElementParams(this.K, buildElementParams);
            VideoReport.setElementReuseIdentifier(this.K, QCircleDaTongConstant.ElementId.EM_XSJ_PICTURE_BUTTON + ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void G2() {
        if (!D1() && this.Q != null) {
            QFSVideoView.D = null;
            F2(true);
            this.Q.v0();
            f85133m0 = new WeakReference<>(this.Q);
            int S = this.Q.S();
            D2(S);
            w20.a.j().r(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get(), true);
            QLog.e("PIC-QFSFeedChildPicPresenter", 1, "startBanner[updatePicListPosition] -> startBanner == null " + S);
        }
    }

    private void H1(boolean z16) {
        QFSImageBanner qFSImageBanner;
        this.f85139f0 = !z16;
        if (z16 && (qFSImageBanner = this.Q) != null && qFSImageBanner.T() == 1) {
            F1();
        } else {
            r2();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void H2(boolean z16) {
        if (l2() != null && this.V != null) {
            FeedCloudMeta$StFeedMusic feedCloudMeta$StFeedMusic = l2().musicInfo;
            if (feedCloudMeta$StFeedMusic != null && !TextUtils.isEmpty(feedCloudMeta$StFeedMusic.playUrl.get())) {
                QFSVideoView.D = null;
                N2(false);
                int i3 = feedCloudMeta$StFeedMusic.startPos.get();
                int i16 = feedCloudMeta$StFeedMusic.endPos.get();
                int c16 = w20.a.j().c(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
                QLog.i("PIC-QFSFeedChildPicPresenter", 1, "[startPlayer] url = " + feedCloudMeta$StFeedMusic.playUrl.get() + ",start = " + i3 + ",end = " + i16);
                this.V.setPlayRange(i3, i16);
                RFWPlayerOptions startOffset = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).setFileId(feedCloudMeta$StFeedMusic.MID.get()).setPlayUrl(feedCloudMeta$StFeedMusic.playUrl.get()).setIsVideo(false).setStartOffset((long) c16);
                z1(startOffset, feedCloudMeta$StFeedMusic.playUrl.get());
                A1(startOffset, feedCloudMeta$StFeedMusic, c16);
                this.V.loadPlayOptions(startOffset);
                return;
            }
            QLog.i("PIC-QFSFeedChildPicPresenter", 1, "[startPlayer] music is null");
        }
    }

    private void I1(boolean z16) {
        if (C1()) {
            return;
        }
        if (this.V.getSuperPlayer() == null) {
            RFWLog.d("PIC-QFSFeedChildPicPresenter", RFWLog.USR, "execute a new player" + hashCode());
            H2(z16);
            return;
        }
        if (!this.V.isRelease() && !this.V.getQCirclePlayer().isDeInit()) {
            if (this.V.getSuperPlayer().isPlaying()) {
                RFWLog.d("PIC-QFSFeedChildPicPresenter", RFWLog.USR, "isPlaying when resume:" + hashCode());
                return;
            }
            if (this.V.getSuperPlayer().isPausing()) {
                A2();
                RFWLog.d("PIC-QFSFeedChildPicPresenter", RFWLog.USR, "startFromPause hashCode:" + hashCode());
                return;
            }
            H2(z16);
            return;
        }
        RFWLog.d("PIC-QFSFeedChildPicPresenter", RFWLog.USR, "execute a new player released" + hashCode());
        H2(z16);
    }

    private void I2(boolean z16) {
        QFSImageBanner qFSImageBanner = this.Q;
        if (qFSImageBanner == null) {
            return;
        }
        qFSImageBanner.z0(z16);
    }

    private QCircleLpReportDc05507.DataBuilder J1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder(ua0.c.c(feedCloudMeta$StFeed));
        dataBuilder.setfpageid(Integer.parseInt(t0()));
        dataBuilder.setPageId(y0());
        return dataBuilder;
    }

    private void J2() {
        TextView textView = this.M;
        if (textView == null) {
            return;
        }
        int i3 = 8;
        if (this.I) {
            if (!this.f85141h0) {
                i3 = 0;
            }
            textView.setVisibility(i3);
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private FeedCloudMeta$StImage K1(int i3) {
        List<FeedCloudMeta$StImage> list;
        T t16 = this.f85017h;
        if (t16 == 0) {
            list = null;
        } else {
            list = ((FeedCloudMeta$StFeed) t16).images.get();
        }
        return (FeedCloudMeta$StImage) RFSafeListUtils.get(list, i3);
    }

    private void K2() {
        int T = this.Q.T();
        TextView textView = this.L;
        if (textView != null && this.N != null && this.P != null) {
            if (T > 1) {
                textView.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f196454hc));
                this.N.setVisibility(0);
                this.P.setVisibility(0);
                this.P.setText(String.format(com.tencent.biz.qqcircle.utils.h.a(R.string.f196464hd), Integer.valueOf(T)));
                return;
            }
            textView.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f196554hm));
            this.N.setVisibility(8);
            this.P.setVisibility(8);
        }
    }

    private int L1() {
        return uq3.c.X0("qqcircle", "qqcircle_autoslide_single_pic_interval", 5000).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L2(int i3) {
        this.W = i3;
        T0(new com.tencent.biz.qqcircle.immersive.feed.event.ad(k2(), i3));
        K2();
        QFSGalleryProgressViewNoAnim qFSGalleryProgressViewNoAnim = this.T;
        if (qFSGalleryProgressViewNoAnim != null) {
            qFSGalleryProgressViewNoAnim.f(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void M1(boolean z16) {
        if (this.Q == null) {
            QLog.e(getTAG(), 1, "[onLoopEnd] mImageBanner == null");
            return;
        }
        if (this.f85139f0) {
            QLog.d(getTAG(), 1, "mIsUserInteract = true");
            return;
        }
        boolean d16 = com.tencent.biz.qqcircle.utils.bi.d(m0(), (FeedCloudMeta$StFeed) this.f85017h);
        int T = this.Q.T();
        QLog.d(getTAG(), 1, "[onLoopEnd] shouldAutoSlide = " + d16 + ", dataSize = " + T + ", mHasPostAutoSlideTask = " + this.f85145l0);
        if (!d16) {
            return;
        }
        if (T == 1) {
            F1();
        } else {
            if (!z16) {
                return;
            }
            T1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void M2(int i3) {
        L2(i3);
        w20.a.j().t(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get(), i3);
    }

    private void N1(QFSQzoneFirstVideoAutoSlideEvent qFSQzoneFirstVideoAutoSlideEvent) {
        if (!TextUtils.equals(qFSQzoneFirstVideoAutoSlideEvent.getFeedId(), j())) {
            return;
        }
        T1();
    }

    private void N2(boolean z16) {
        int i3;
        this.f85140g0 = z16;
        ImageView imageView = this.R;
        if (imageView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }
        av.a aVar = this.f85142i0;
        if (aVar != null) {
            aVar.a(!this.f85140g0);
        }
    }

    private void O1(boolean z16) {
        int i3;
        LinearLayout linearLayout = this.K;
        if (linearLayout == null) {
            return;
        }
        if (z16) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        linearLayout.setVisibility(i3);
        if (z16) {
            u2();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void P1(@NonNull QCirclePanelStateEvent qCirclePanelStateEvent) {
        T t16 = this.f85017h;
        if (t16 != 0 && TextUtils.equals(((FeedCloudMeta$StFeed) t16).f398449id.get(), qCirclePanelStateEvent.getFeedId())) {
            if (qCirclePanelStateEvent.isShowing()) {
                I2(false);
            } else {
                G2();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Q1(@NonNull MotionEvent motionEvent) {
        String str;
        int hashCode;
        if (!this.f85137d0) {
            this.f85137d0 = true;
            T t16 = this.f85017h;
            if (t16 == 0) {
                str = "";
            } else {
                str = ((FeedCloudMeta$StFeed) t16).f398449id.get();
            }
            SimpleEventBus.getInstance().dispatchEvent(new QFSSeekEvent(str, true));
            X1();
            QFSGalleryPreListView qFSGalleryPreListView = this.f85135b0;
            if (qFSGalleryPreListView == null) {
                return;
            }
            qFSGalleryPreListView.setVisibility(0);
            if (m0() == null) {
                hashCode = 0;
            } else {
                hashCode = m0().hashCode();
            }
            QFSPicFullPreViewEvent qFSPicFullPreViewEvent = new QFSPicFullPreViewEvent(0, hashCode);
            qFSPicFullPreViewEvent.setPreView(this.f85135b0);
            qFSPicFullPreViewEvent.setClearDetectorView(this.Q);
            SimpleEventBus.getInstance().dispatchEvent(qFSPicFullPreViewEvent);
            I2(false);
            this.f85135b0.setData((FeedCloudMeta$StFeed) this.f85017h);
            this.f85135b0.setOnItemSelectedListener(new e());
            this.f85135b0.w0(motionEvent.getRawX());
            QLog.d("PIC-QFSFeedChildPicPresenter", 1, "[handleMoveEvent] rawX: " + motionEvent.getRawX());
            return;
        }
        QFSGalleryPreListView qFSGalleryPreListView2 = this.f85135b0;
        if (qFSGalleryPreListView2 != null) {
            qFSGalleryPreListView2.v0(motionEvent.getRawX());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void R1(@NonNull QFSMusicCurrentProgressEvent qFSMusicCurrentProgressEvent) {
        T t16 = this.f85017h;
        if (t16 != 0 && TextUtils.equals(((FeedCloudMeta$StFeed) t16).f398449id.get(), qFSMusicCurrentProgressEvent.getFeedId())) {
            this.f85138e0.put(((FeedCloudMeta$StFeed) this.f85017h).musicInfo.playUrl.get(), Integer.valueOf(qFSMusicCurrentProgressEvent.getCurrentProgress()));
        }
    }

    private void S1(@NonNull QCirclePanelStateEvent qCirclePanelStateEvent) {
        if (!d2()) {
            return;
        }
        int panelType = qCirclePanelStateEvent.getPanelType();
        if (panelType != 1) {
            if (panelType != 2 && panelType != 14 && panelType != 16 && panelType != 34) {
                if (!TextUtils.equals(qCirclePanelStateEvent.getFeedId(), j())) {
                    return;
                }
                H1(!QCirclePanelStateEvent.isAnyPanelShowing());
                return;
            }
            H1(!QCirclePanelStateEvent.isAnyPanelShowing());
            return;
        }
        P1(qCirclePanelStateEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T1() {
        boolean d26 = d2();
        QLog.d(getTAG(), 1, "[handleScrollToNextItem] isOnScreen = " + d26);
        if (!d26) {
            return;
        }
        S0();
    }

    private void U1(@NonNull QCircleSeekAreaEvent qCircleSeekAreaEvent) {
        if (this.f85017h == 0 || !E0()) {
            return;
        }
        MotionEvent event = qCircleSeekAreaEvent.getEvent();
        if (event.getAction() == 2) {
            Q1(event);
        } else if (event.getAction() == 1 || event.getAction() == 3) {
            V1();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void V1() {
        String str;
        int i3 = 0;
        this.f85137d0 = false;
        T t16 = this.f85017h;
        if (t16 == 0) {
            str = "";
        } else {
            str = ((FeedCloudMeta$StFeed) t16).f398449id.get();
        }
        QFSSeekEvent qFSSeekEvent = new QFSSeekEvent(str, false);
        QFSGalleryPreListView qFSGalleryPreListView = this.f85135b0;
        if (qFSGalleryPreListView != null) {
            qFSGalleryPreListView.setVisibility(8);
            if (m0() != null) {
                i3 = m0().hashCode();
            }
            SimpleEventBus.getInstance().dispatchEvent(new QFSPicFullPreViewEvent(1, i3));
            this.f85135b0.x0();
            QFSAudioBannerView qFSAudioBannerView = this.V;
            if (qFSAudioBannerView != null && qFSAudioBannerView.getSuperPlayer() != null && this.V.getSuperPlayer().isPlaying()) {
                G2();
            }
        }
        SimpleEventBus.getInstance().dispatchEvent(qFSSeekEvent);
    }

    private void W1(@NonNull com.tencent.biz.qqcircle.immersive.feed.event.ak akVar) {
        if (this.I) {
            n2(akVar.b());
        } else {
            j2();
        }
    }

    private void X1() {
        if (this.f85135b0 == null) {
            this.f85135b0 = (QFSGalleryPreListView) ((ViewStub) this.f85136c0.findViewById(R.id.f40911fn)).inflate();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Z1() {
        if (this.Q == null) {
            QLog.e("PIC-QFSFeedChildPicPresenter", 1, "[initBanner] -> mImageBanner == null ");
            return;
        }
        if (this.X == null) {
            com.tencent.biz.qqcircle.immersive.views.banner.i iVar = new com.tencent.biz.qqcircle.immersive.views.banner.i();
            this.X = iVar;
            this.Q.setAdapter(iVar);
        }
        if (this.U == null) {
            QFSImageBannerReport qFSImageBannerReport = new QFSImageBannerReport(y0());
            this.U = qFSImageBannerReport;
            this.Q.setStatusListener(qFSImageBannerReport);
        }
        this.U.o((FeedCloudMeta$StFeed) this.f85017h);
        long P2 = uq3.c.P2();
        long O2 = uq3.c.O2();
        QLog.i("PIC-QFSFeedChildPicPresenter", 1, "[initBanner] picExposeTime = " + P2 + ", picAnimDuration = " + O2);
        this.X.s0(P2);
        this.X.q0(O2);
        E2();
        this.X.v0((FeedCloudMeta$StFeed) this.f85017h);
        this.X.notifyDataSetChanged();
        this.Q.q0(new a());
        this.Q.setOnLoopStateListener(new b());
        this.Q.setOnSwitchListener(new c());
        this.Q.setCurrentItem(this.W, false);
        this.Q.setOnPlayRateListener(new QFSImageBanner.g() { // from class: com.tencent.biz.qqcircle.immersive.feed.au
            @Override // com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.g
            public final void a(float f16) {
                QFSFeedChildPicPresenter.this.i2(f16);
            }
        });
        M2(this.W);
    }

    private void a() {
        QFSAudioBannerView qFSAudioBannerView = this.V;
        if (qFSAudioBannerView == null) {
            return;
        }
        qFSAudioBannerView.release();
    }

    private void a2(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FrameLayout frameLayout;
        int i3;
        if (this.T != null && (frameLayout = this.S) != null) {
            if (E1(feedCloudMeta$StFeed)) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            frameLayout.setVisibility(i3);
            this.T.setTotalCount(feedCloudMeta$StFeed.images.size());
            return;
        }
        QLog.e(getTAG(), 1, "[initProgress] mProgressView == null or mProgressFl == null");
    }

    private boolean c2() {
        FeedCloudMeta$StFeed l26 = l2();
        if (l26 != null && l26.type.get() == 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d2() {
        return J0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e2() {
        return !this.f85140g0;
    }

    private boolean f2(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.images.size() == 1) {
            return true;
        }
        return false;
    }

    private boolean g2() {
        Fragment hostFragment;
        t40.a s06 = s0();
        if (s06 == null || (hostFragment = s06.getHostFragment()) == null || !(hostFragment.getActivity() instanceof QCircleFolderActivity)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void h2() {
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setFeed(l2());
        qCircleInitBean.setFromReportBean(getReportBean());
        QCirclePluginUtil.setIsGalleryPageOnShow(true);
        com.tencent.biz.qqcircle.launcher.c.F(m0(), qCircleInitBean);
        QCircleLpReportDc05507.DataBuilder J1 = J1((FeedCloudMeta$StFeed) this.f85017h);
        J1.setActionType(616).setSubActionType(2);
        QCircleLpReportDc05507.report(J1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i2(float f16) {
        F2(true);
        QFSImageBanner qFSImageBanner = this.Q;
        if (qFSImageBanner != null) {
            qFSImageBanner.v0();
        }
        this.f85140g0 = false;
        N2(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String j() {
        T t16 = this.f85017h;
        if (t16 == 0) {
            return "";
        }
        return ((FeedCloudMeta$StFeed) t16).f398449id.get();
    }

    private void j2() {
        h2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String k2() {
        T t16 = this.f85017h;
        if (t16 == 0) {
            return "";
        }
        return ((FeedCloudMeta$StFeed) t16).f398449id.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private FeedCloudMeta$StFeed l2() {
        return (FeedCloudMeta$StFeed) this.f85017h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void n2(String str) {
        T t16 = this.f85017h;
        if (t16 != 0 && ((FeedCloudMeta$StFeed) t16).f398449id.get().equals(str)) {
            if (this.f85140g0) {
                this.f85140g0 = false;
                A2();
                G2();
                M1(false);
            } else {
                this.f85140g0 = true;
                QFSAudioBannerView qFSAudioBannerView = this.V;
                if (qFSAudioBannerView != null && qFSAudioBannerView.getSuperPlayer() != null) {
                    o2(true);
                }
                I2(false);
                r2();
            }
            QLog.d("PIC-QFSFeedChildPicPresenter", 1, "pauseOrResume" + this.f85140g0);
            w20.a.j().r(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get(), true ^ this.f85140g0);
            N2(this.f85140g0);
        }
    }

    private void o2(boolean z16) {
        QFSAudioBannerView qFSAudioBannerView = this.V;
        if (qFSAudioBannerView != null && qFSAudioBannerView.getSuperPlayer() != null) {
            QLog.d("PIC-QFSFeedChildPicPresenter", 1, "[pausePlayer]  mAudioView.getSuperPlayer() " + this.V.getSuperPlayer().isPlaying());
            this.V.pause();
            N2(z16);
            I2(false);
            return;
        }
        QLog.d("PIC-QFSFeedChildPicPresenter", 1, "[pausePlayer]  null ");
    }

    private void p2() {
        FeedCloudMeta$StFeed l26 = l2();
        if (l26 == null) {
            return;
        }
        for (FeedCloudMeta$StImage feedCloudMeta$StImage : l26.images.get()) {
            if (feedCloudMeta$StImage != null) {
                Option predecode = Option.obtain().setUrl(feedCloudMeta$StImage.picUrl.get()).setPredecode(false);
                predecode.setCacheKey(new LibraRequestKey.Builder(new LibraDownloadKey(QCircleFeedPicLoader.g().getPicLocalPath(predecode))).build());
                QCircleFeedPicLoader.g().loadImage(predecode);
            }
        }
    }

    private void q2() {
        this.W = 0;
        QFSImageBanner qFSImageBanner = this.Q;
        if (qFSImageBanner != null) {
            qFSImageBanner.setCurrentItem(0, false);
            M2(this.W);
            QLog.d("PIC-QFSFeedChildPicPresenter", 1, "[reloadPictureContent] change new feed, current position: ", 0);
        }
    }

    private void r2() {
        x0().removeCallbacks(this.f85143j0);
        this.f85145l0 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void s2(int i3) {
        if (this.f85017h != 0 && d2()) {
            QCircleLpReportDc05507.DataBuilder J1 = J1((FeedCloudMeta$StFeed) this.f85017h);
            J1.setActionType(100).setSubActionType(2).setExt1(String.valueOf(i3));
            QCircleLpReportDc05507.report(J1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void t2() {
        long P2;
        if (this.f85017h != 0 && this.Y != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.Y;
            int size = ((FeedCloudMeta$StFeed) this.f85017h).images.size();
            if (((FeedCloudMeta$StFeed) this.f85017h).images.size() == 1) {
                P2 = 5000;
            } else {
                P2 = (size * uq3.c.P2()) + ((size - 1) * uq3.c.O2());
            }
            QLog.i("PIC-QFSFeedChildPicPresenter", 1, "[reportEndExposure] -> videoPlayTime = " + currentTimeMillis + " , picSize = " + size + " , videoTotalTime = " + P2);
            QCircleLpReportDc05507.DataBuilder J1 = J1((FeedCloudMeta$StFeed) this.f85017h);
            QCircleLpReportDc05507.DataBuilder ext1 = J1.setActionType(1).setSubActionType(8).setFeedId(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get()).setExt1("1");
            StringBuilder sb5 = new StringBuilder();
            sb5.append(((FeedCloudMeta$StFeed) this.f85017h).images.size());
            sb5.append("");
            ext1.setExt3(sb5.toString()).setAuthorUin(((FeedCloudMeta$StFeed) this.f85017h).poster.f398463id.get()).setVideoPlayTime(currentTimeMillis).setVideoTotalTime((int) P2).setFirstFeedId(w20.a.j().h());
            QCircleLpReportDc05507.report(J1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void u2() {
        LinearLayout linearLayout;
        if (this.f85017h != 0 && (linearLayout = this.K) != null && linearLayout.getVisibility() != 8) {
            QCircleLpReportDc05507.DataBuilder J1 = J1((FeedCloudMeta$StFeed) this.f85017h);
            J1.setActionType(616).setSubActionType(1);
            QCircleLpReportDc05507.report(J1);
        }
    }

    private void v2(int i3, int i16, QCircleExtraTypeInfo qCircleExtraTypeInfo, String str, FeedCloudMeta$StImage feedCloudMeta$StImage) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        String str2;
        if (qCircleExtraTypeInfo != null && (feedCloudMeta$StFeed = qCircleExtraTypeInfo.mFeed) != null) {
            FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo = feedCloudMeta$StFeed.authSchoolInfo;
            if (feedCloudMeta$StTagInfo == null) {
                str2 = "";
            } else {
                str2 = feedCloudMeta$StTagInfo.tagName.get();
            }
            QCircleLpReportDc05507.DataBuilder J1 = J1(qCircleExtraTypeInfo.mFeed);
            J1.setActionType(i3).setSubActionType(i16).setToUin(qCircleExtraTypeInfo.mFeed.poster.f398463id.get()).setPosition(qCircleExtraTypeInfo.mDataPosition).setPlayScene(qCircleExtraTypeInfo.mPlayScene).setExt1(str).setExt6(str2).setFirstFeedId(w20.a.j().h());
            long P2 = uq3.c.P2();
            if (c2() && P2 > 0) {
                J1.setExt5(String.valueOf(P2));
            }
            if (feedCloudMeta$StImage != null) {
                J1.setLloc(feedCloudMeta$StImage.picId.get());
            }
            QCircleLpReportDc05507.report(J1);
            return;
        }
        QLog.e("QCircleReportHelper_PIC-QFSFeedChildPicPresenter", 1, "extraTypeInfo is null or lost feed,actionType:" + i3 + ",subActionType:" + i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w2(String str, String str2, int i3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().addRequest(new QFSGetMusicInfoRequest(arrayList)).m250setRspOnCallBack((Call.OnRspCallBack) new g(str, i3, str2)).execute();
    }

    private void y2() {
        QFSGalleryProgressViewNoAnim qFSGalleryProgressViewNoAnim = this.T;
        if (qFSGalleryProgressViewNoAnim != null) {
            qFSGalleryProgressViewNoAnim.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z1(RFWPlayerOptions rFWPlayerOptions, String str) {
        rFWPlayerOptions.setPlayIOC(new h());
        rFWPlayerOptions.getListenerSet().addPrepareListeners(new i());
        rFWPlayerOptions.getListenerSet().addSeekListeners(new j(str));
    }

    private void z2() {
        this.Y = System.currentTimeMillis();
        this.Z = 0;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.C0(hVar);
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.ak) {
            W1((com.tencent.biz.qqcircle.immersive.feed.event.ak) hVar);
        } else if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.p) {
            O1(((com.tencent.biz.qqcircle.immersive.feed.event.p) hVar).a());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void F2(boolean z16) {
        if (!this.I) {
            return;
        }
        if (f2((FeedCloudMeta$StFeed) this.f85017h)) {
            z16 = false;
        }
        QLog.e(getTAG(), 1, "setLooperMode :" + z16);
        this.f85141h0 = z16;
        J2();
        QFSImageBanner qFSImageBanner = this.Q;
        if (qFSImageBanner != null && qFSImageBanner.X() != null && this.Q.X().getScrollState() == 0) {
            x2();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        super.K0();
        if (s0() != null && s0().getInitBean() != null && s0().getInitBean().getExtraTypeInfo() != null && s0().getInitBean().getExtraTypeInfo().sourceType == 20101) {
            v2(5000, 55010, r(), "1", K1(0));
            com.tencent.biz.qqcircle.immersive.personal.data.w wVar = new com.tencent.biz.qqcircle.immersive.personal.data.w(((FeedCloudMeta$StFeed) this.f85017h).poster.f398463id.get());
            wVar.K();
            wVar.X();
            wVar.R();
        }
        u2();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.f85136c0 = view;
        this.f85016f = ((ViewStub) view.findViewById(R.id.f40951fr)).inflate();
        this.J = (FrameLayout) view.findViewById(R.id.v9e);
        this.K = (LinearLayout) view.findViewById(R.id.f46311u9);
        this.L = (TextView) view.findViewById(R.id.f56722ld);
        this.N = view.findViewById(R.id.f56732le);
        this.P = (TextView) view.findViewById(R.id.f56742lf);
        this.Q = (QFSImageBanner) view.findViewById(R.id.f43991nz);
        this.R = (ImageView) view.findViewById(R.id.f489421c);
        this.M = (TextView) view.findViewById(R.id.f56182jx);
        VideoReport.setElementId(this.Q, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA);
        QFSAudioBannerView qFSAudioBannerView = new QFSAudioBannerView(view.getContext());
        this.V = qFSAudioBannerView;
        qFSAudioBannerView.setBanner(this.Q);
        RFWIocAbilityProvider.g().registerIoc(view, this, dr.b.class);
        if (this.I) {
            this.M.setVisibility(0);
            this.K.setVisibility(8);
            ((ViewStub) view.findViewById(R.id.f40931fp)).inflate();
            this.T = (QFSGalleryProgressViewNoAnim) view.findViewById(R.id.f40941fq);
            this.S = (FrameLayout) view.findViewById(R.id.f40921fo);
            this.T.setPosChangeListener(new k());
        } else {
            this.K.setVisibility(0);
            this.M.setVisibility(8);
        }
        P2(false);
    }

    protected void P2(boolean z16) {
        int i3;
        View view = this.f85016f;
        if (view != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void Q0() {
        super.Q0();
        if (c2()) {
            v2(1, 1, r(), "1", K1(0));
            com.tencent.biz.qqcircle.immersive.utils.bl.b(l2());
            QFSRecentlyWatchedRecorder.i().n(this.E);
            B2();
            C2();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void c1(boolean z16) {
        int i3;
        super.c1(z16);
        FrameLayout frameLayout = this.S;
        if (frameLayout != null) {
            if (!z16 && E1((FeedCloudMeta$StFeed) this.f85017h)) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            frameLayout.setVisibility(i3);
        }
        if (z16) {
            TextView textView = this.M;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        J2();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QCirclePanelStateEvent.class);
        eventClass.add(QFSRestartAudioEvent.class);
        if (this.I) {
            eventClass.add(QCircleSeekAreaEvent.class);
            eventClass.add(QFSFeedItemTouchEvent.class);
        }
        eventClass.add(QFSMusicCurrentProgressEvent.class);
        eventClass.add(QFSQzoneFirstVideoAutoSlideEvent.class);
        return eventClass;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: m2, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        if (!c2()) {
            P2(false);
            return;
        }
        this.f85018i = i3;
        String k26 = k2();
        p2();
        QLog.d("PIC-QFSFeedChildPicPresenter", 1, "[onBindData] bind data feed id: ", k26, "mPos: ", Integer.valueOf(this.f85018i));
        FrameLayout frameLayout = this.J;
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
        }
        this.W = w20.a.j().f(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
        Z1();
        a2(feedCloudMeta$StFeed);
        N2(false);
        P2(true);
        G1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f46311u9) {
            j2();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        super.onDestroy();
        a();
        this.U = null;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo != null && rFWFeedSelectInfo.getPosition() == this.f85018i) {
            if (!c2()) {
                QLog.d("PIC-QFSFeedChildPicPresenter", 4, "[reloadPicPosition] current feed not is pic type.");
                return;
            }
            r2();
            G2();
            I1(false);
            QFSImageBanner qFSImageBanner = this.Q;
            if (qFSImageBanner != null) {
                s2(qFSImageBanner.S());
            }
            z2();
            com.tencent.a.c(String.valueOf(m0().hashCode()));
            B1();
            f85133m0 = new WeakReference<>(this.Q);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo != null && rFWFeedSelectInfo.getPosition() == this.f85018i) {
            QLog.d("PIC-QFSFeedChildPicPresenter", 1, "[onFeedUnSelected] feed id: " + j() + " | trace id: " + com.tencent.biz.qqcircle.immersive.utils.ba.d((FeedCloudMeta$StFeed) this.f85017h));
            a();
            I2(true);
            q2();
            y2();
            this.f85138e0.clear();
            t2();
            if (this.f85137d0) {
                V1();
            }
            f85133m0 = null;
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onPaused(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo != null && rFWFeedSelectInfo.getPosition() == this.f85018i) {
            r2();
            if (QCirclePluginUtil.isSharePanelOnShow()) {
                QLog.d("PIC-QFSFeedChildPicPresenter", 1, "isSharePanelOnShow don't release player");
                return;
            }
            I2(false);
            t2();
            if (QCirclePluginUtil.isGalleryPageOnShow()) {
                QLog.d("PIC-QFSFeedChildPicPresenter", 1, "isGalleryPageOnShow don't release player");
            } else {
                o2(false);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        QFSImageBanner qFSImageBanner;
        QFSAudioBannerView qFSAudioBannerView;
        super.onReceiveEvent(simpleBaseEvent);
        boolean z16 = simpleBaseEvent instanceof QCirclePanelStateEvent;
        if (z16) {
            S1((QCirclePanelStateEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSRestartAudioEvent) {
            QFSRestartAudioEvent qFSRestartAudioEvent = (QFSRestartAudioEvent) simpleBaseEvent;
            if (this.f85017h != 0 && (qFSAudioBannerView = this.V) != null && qFSAudioBannerView.getSuperPlayer() != null && TextUtils.equals(qFSRestartAudioEvent.mTargetFeedId, ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get()) && TextUtils.equals(qFSRestartAudioEvent.mPageId, r0()) && !this.V.getSuperPlayer().isPlaying()) {
                I1(false);
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof QCircleSeekAreaEvent) {
            U1((QCircleSeekAreaEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSMusicCurrentProgressEvent) {
            R1((QFSMusicCurrentProgressEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSQzoneFirstVideoAutoSlideEvent) {
            N1((QFSQzoneFirstVideoAutoSlideEvent) simpleBaseEvent);
            return;
        }
        if (z16) {
            S1((QCirclePanelStateEvent) simpleBaseEvent);
        } else if ((simpleBaseEvent instanceof QFSFeedItemTouchEvent) && (qFSImageBanner = this.Q) != null) {
            qFSImageBanner.dispatchTouchEvent(((QFSFeedItemTouchEvent) simpleBaseEvent).getEvent());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onResumed(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo != null && rFWFeedSelectInfo.getPosition() == this.f85018i) {
            if (!c2()) {
                QLog.d("PIC-QFSFeedChildPicPresenter", 1, "[reloadPicPosition] current feed not is pic type.");
                return;
            }
            I1(true);
            this.Q.setCurrentItem(w20.a.j().f(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get()), false);
            w20.a.j().r(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get(), true);
            G2();
            u2();
            z2();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onStop(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onStop(rFWFeedSelectInfo);
        if (QCirclePluginUtil.isGalleryPageOnShow()) {
            QLog.d("PIC-QFSFeedChildPicPresenter", 1, "isGalleryPageOnShow don't pause player");
        } else {
            o2(false);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.dr.b
    public RFWVideoView v() {
        return this.V;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "PIC-QFSFeedChildPicPresenter";
    }

    public void x2() {
        com.tencent.biz.qqcircle.immersive.views.banner.i iVar;
        if (this.I && (iVar = this.X) != null && iVar.isCanLoop() != this.f85141h0) {
            QLog.e(getTAG(), 1, "[setLooperMode] looper:" + this.f85141h0);
            this.X.setEnableLoop(this.f85141h0);
            this.X.r0(this.f85141h0 ^ true);
            this.X.notifyDataSetChanged();
            QFSImageBanner qFSImageBanner = this.Q;
            if (qFSImageBanner != null) {
                qFSImageBanner.setCurrentItemWhenModeChange(this.W);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements QFSImageBanner.h {
        c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.h
        public void c() {
            RFWLog.d("PIC-QFSFeedChildPicPresenter", RFWLog.USR, "onUserTouchSwitch");
            if (QFSFeedChildPicPresenter.this.Q != null) {
                w20.a.j().r(((FeedCloudMeta$StFeed) QFSFeedChildPicPresenter.this.f85017h).f398449id.get(), false);
                QFSFeedChildPicPresenter.this.Q.y0();
            }
            QFSFeedChildPicPresenter.this.F2(false);
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.h
        public void a(int i3) {
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.h
        public void b(int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class i implements IRFWPlayerPrepareListener {
        i() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onVideoPrepared(RFWPlayer rFWPlayer) {
            if (QFSFeedChildPicPresenter.this.V != null && QFSFeedChildPicPresenter.this.d2()) {
                QFSFeedChildPicPresenter.this.V.start();
            }
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onFirstFrameRendered(RFWPlayer rFWPlayer) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class j implements IRFWPlayerSeekListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f85160d;

        j(String str) {
            this.f85160d = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onProgress(String str, int i3, int i16) {
            QFSFeedChildPicPresenter.this.f85138e0.put(this.f85160d, Integer.valueOf(i16));
            w20.a.j().q(((FeedCloudMeta$StFeed) QFSFeedChildPicPresenter.this.f85017h).f398449id.get(), i16);
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
}
