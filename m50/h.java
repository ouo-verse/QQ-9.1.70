package m50;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.utils.ac;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener;
import com.tencent.biz.richframework.video.rfw.view.RFWPlayerReuseUtils;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import l40.i;
import m50.h;
import tianshu.QQCircleTianShu$AdItem;

/* compiled from: P */
/* loaded from: classes4.dex */
public class h implements l40.a {
    private volatile boolean C;
    private FeedCloudMeta$StFeed D;
    private ImageView E;
    private boolean F;
    private c H;

    /* renamed from: d, reason: collision with root package name */
    private final QCircleInitBean f416171d;

    /* renamed from: e, reason: collision with root package name */
    private String f416172e;

    /* renamed from: f, reason: collision with root package name */
    private ViewGroup f416173f;

    /* renamed from: h, reason: collision with root package name */
    private QFSVideoView f416174h;

    /* renamed from: i, reason: collision with root package name */
    private FrameLayout f416175i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f416176m;
    protected final com.tencent.biz.qqcircle.immersive.report.f G = new com.tencent.biz.qqcircle.immersive.report.f("QFSLayerFastPlay");
    private final Runnable I = new Runnable() { // from class: m50.a
        @Override // java.lang.Runnable
        public final void run() {
            h.this.A();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements IRFWPlayerPrepareListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QFSVideoView f416177d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f416178e;

        a(QFSVideoView qFSVideoView, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f416177d = qFSVideoView;
            this.f416178e = feedCloudMeta$StFeed;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(RFWPlayer rFWPlayer) {
            c cVar = h.this.H;
            if (cVar != null) {
                cVar.b();
            }
            if (h.this.E != null) {
                h.this.E.setVisibility(8);
            }
            h.this.G.Y7(rFWPlayer);
            h.this.G.i8(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_FIRST_RENDER);
            h.this.f416176m = true;
            h.this.E();
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onFirstFrameRendered(final RFWPlayer rFWPlayer) {
            QLog.d("QFSLayerFastPlay", 1, "[onFirstFrameRendered]");
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: m50.g
                @Override // java.lang.Runnable
                public final void run() {
                    h.a.this.b(rFWPlayer);
                }
            });
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onVideoPrepared(RFWPlayer rFWPlayer) {
            QLog.d("QFSLayerFastPlay", 1, "[onVideoPrepared] mHaveRelease:" + h.this.C);
            if (h.this.C) {
                return;
            }
            h.this.G.onVideoPrepared(rFWPlayer);
            h.this.G.i8(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_PREPARED);
            h.this.q(this.f416177d, rFWPlayer.getRealPlayer(), this.f416178e);
            RFWPlayerOptions rFWPlayerOptions = rFWPlayer.getRFWPlayerOptions();
            boolean hitPreloadCache = rFWPlayerOptions.hitPreloadCache();
            boolean isPreloadPlayer = rFWPlayerOptions.isPreloadPlayer();
            boolean firstFramePreRenderSucceed = rFWPlayerOptions.getFirstFramePreRenderSucceed();
            if (isPreloadPlayer) {
                hitPreloadCache = true;
            }
            QLog.d("QFSLayerFastPlay", 1, "[onVideoPrepared] hitCache:" + hitPreloadCache + ",hitPreloadPlayer:" + isPreloadPlayer + ",firstFramePreRenderSucceed:" + firstFramePreRenderSucceed);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements IRFWPlayErrorStatusListener {
        b() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener
        public void onVideoPlayError(int i3, int i16, int i17, String str) {
            QLog.d("QFSLayerFastPlay", 1, "[onVideoPlayError] errorType:" + i16 + ",errorCode:" + i17);
            h.this.E();
            h.this.G.onVideoPlayError(i17);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface c {
        void a();

        void b();
    }

    public h(QCircleInitBean qCircleInitBean) {
        this.f416172e = null;
        this.f416171d = qCircleInitBean;
        if (qCircleInitBean != null && qCircleInitBean.getSchemeAttrs() != null) {
            this.f416172e = qCircleInitBean.getSchemeAttrs().get("xsj_custom_pgid");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A() {
        QLog.d("QFSLayerFastPlay", 1, "mEnvTimeOutRunnable run");
        Q6();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B() {
        FrameLayout frameLayout = this.f416175i;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        E();
        G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C() {
        QFSVideoView qFSVideoView = this.f416174h;
        if (qFSVideoView != null) {
            qFSVideoView.pause();
            qFSVideoView.release();
        }
        FrameLayout frameLayout = this.f416175i;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        final c cVar = this.H;
        if (cVar != null) {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: m50.c
                @Override // java.lang.Runnable
                public final void run() {
                    h.c.this.a();
                }
            });
        }
        this.H = null;
    }

    private void I() {
        QLog.d("QFSLayerFastPlay", 1, "[unRegisterIoc] mRootView:" + this.f416173f);
        if (this.f416173f != null) {
            RFWIocAbilityProvider.g().unregisterSingleIoc(this.f416173f, l40.a.class);
        }
    }

    private void l(QFSVideoView qFSVideoView, @NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, RFWPlayerOptions rFWPlayerOptions, String str) {
        if (rFWPlayerOptions == null) {
            return;
        }
        o(qFSVideoView, rFWPlayerOptions);
        n(qFSVideoView, rFWPlayerOptions, feedCloudMeta$StFeed);
        m(feedCloudMeta$StFeed, rFWPlayerOptions);
    }

    private void m(FeedCloudMeta$StFeed feedCloudMeta$StFeed, @NonNull RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addErrorStatusListener(new b());
    }

    private void n(QFSVideoView qFSVideoView, RFWPlayerOptions rFWPlayerOptions, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        rFWPlayerOptions.getListenerSet().addPrepareListeners(new a(qFSVideoView, feedCloudMeta$StFeed));
    }

    private void o(final QFSVideoView qFSVideoView, RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addSDKInitListeners(new IRFWPlayerSdkInitListener() { // from class: m50.e
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener
            public final void onInitSuccess(RFWPlayer rFWPlayer) {
                h.this.y(qFSVideoView, rFWPlayer);
            }
        });
    }

    private void p(@NonNull ImageView imageView, @NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        Option targetView;
        imageView.setVisibility(0);
        if (TextUtils.isEmpty(feedCloudMeta$StFeed.cover.layerPicUrl.get())) {
            targetView = Option.obtain().setUrl(feedCloudMeta$StFeed.cover.picUrl.get()).setTargetView(imageView);
        } else {
            targetView = Option.obtain().setUrl(feedCloudMeta$StFeed.cover.layerPicUrl.get()).setTargetView(imageView);
        }
        targetView.setSupportRecycler(true);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams != null) {
            targetView.setRequestWidth(layoutParams.width);
            targetView.setRequestHeight(layoutParams.height);
        }
        QLog.d("QFSLayerFastPlay", 1, "[bindCover]");
        targetView.setLoadingDrawable(i.N());
        targetView.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        QCircleFeedPicLoader.g().loadImage(targetView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(final QFSVideoView qFSVideoView, ISuperPlayer iSuperPlayer, final FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (qFSVideoView != null && feedCloudMeta$StFeed != null && iSuperPlayer != null) {
            this.f416176m = true;
            s(qFSVideoView, feedCloudMeta$StFeed);
            qFSVideoView.start();
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: m50.f
                @Override // java.lang.Runnable
                public final void run() {
                    h.this.z(qFSVideoView, feedCloudMeta$StFeed);
                }
            });
        }
    }

    private void r(@NonNull QFSVideoView qFSVideoView, @NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QLog.d("QFSLayerFastPlay", 1, "[doVideoPlayLogic]");
        this.G.Gd();
        this.G.i8(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_AUTO_PLAY);
        String N = r.N(feedCloudMeta$StFeed.video.playUrl.get());
        RFWPlayerOptions addAttachInfo = RFWPlayerOptions.obtain(cq.f92752a.p(feedCloudMeta$StFeed)).setPlayUrl(feedCloudMeta$StFeed.video.playUrl.get()).setFileId(feedCloudMeta$StFeed.video.fileId.get()).setStVideo(gb0.b.k(feedCloudMeta$StFeed.video)).setStartOffset(0L).setFromType(2).setEnableDataCollect(true).addAttachInfo("ATTACH_INFO_KEY_POI", 0);
        l(qFSVideoView, feedCloudMeta$StFeed, addAttachInfo, N);
        RFWLog.d("QFSLayerFastPlay_" + addAttachInfo.tag(), RFWLog.USR, "fs_lifecycle  startANewPlayer:" + ac.f90062a.a(feedCloudMeta$StFeed.content.get()));
        qFSVideoView.loadPlayOptions(addAttachInfo);
        this.G.i8(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_SET_VIDEO_PATH);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void s(QFSVideoView qFSVideoView, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        View view;
        if (qFSVideoView != null && feedCloudMeta$StFeed != null) {
            String u16 = u();
            Map<String, ?> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            e30.b bVar = new e30.b(feedCloudMeta$StFeed);
            bVar.p();
            buildElementParams.putAll(ua0.c.d(bVar));
            buildElementParams.putAll(ua0.c.e(feedCloudMeta$StFeed));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, 1);
            buildElementParams.put("xsj_custom_pgid", u16);
            buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REC_SLOT_EXP_FEED_LIST, r.v(bVar));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_REC_SLOT_VIDEO, Integer.valueOf(r.A0(bVar) ? 1 : 0));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REC_SLOT_ORIGINAL_FEED_ID, feedCloudMeta$StFeed.f398449id.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REC_SLOT_TYPE, r.I(bVar));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_RECOM_SHOW_STYLE, Integer.valueOf(r.E(bVar)));
            QQCircleTianShu$AdItem L = r.L(feedCloudMeta$StFeed, 1050);
            if (L != null) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_MULTIMEDIA_LIKE_TIANSHU_ID, Integer.valueOf(L.iAdId.get()));
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REC_SLOT_EXP_STATUS, Integer.valueOf(r.C(bVar)));
            if (qFSVideoView.getSuperPlayer() != null && (qFSVideoView.getSuperPlayer().getVideoView() instanceof View)) {
                view = (View) qFSVideoView.getSuperPlayer().getVideoView();
            } else {
                view = qFSVideoView;
            }
            VideoEntity build = new VideoEntity.Builder().setContentId(feedCloudMeta$StFeed.f398449id.get()).setPage((Object) u16).setContentType(2).setVideoDuration(feedCloudMeta$StFeed.video.duration.get()).setVideoView(view).addCustomParams(buildElementParams).ignoreReport(false).bizReady(true).build();
            ISuperPlayer superPlayer = qFSVideoView.getSuperPlayer();
            if (superPlayer != null) {
                VideoReport.bindVideoPlayerInfo(superPlayer, build);
                RFWLog.i("QFSLayerFastPlay", RFWLog.USR, "dtReportBindVideoData");
            }
        }
    }

    private long t() {
        try {
            return Long.parseLong(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_layer_fast_play_time_out_duration", QzoneConfig.DefaultValue.DEFAULT_GIF_ANTISHAKE_MAX_FRAME_SHOOTTIME));
        } catch (Exception unused) {
            return 3000L;
        }
    }

    private void w(ViewGroup viewGroup) {
        String str;
        QCircleReportBean qCircleReportBean = new QCircleReportBean();
        qCircleReportBean.setDtPageId("layer_fast_play");
        QCircleInitBean qCircleInitBean = this.f416171d;
        if (qCircleInitBean == null || qCircleInitBean.getSchemeAttrs() == null || (str = this.f416171d.getSchemeAttrs().get("xsj_custom_pgid")) == null) {
            str = QCircleDaTongConstant.PageId.PG_XSJ_LAYER_PAGE;
        }
        this.G.r(viewGroup, str, qCircleReportBean, this.f416171d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(QFSVideoView qFSVideoView, RFWPlayer rFWPlayer) {
        this.G.i8(QCircleFolderFunnelCollect.PERIOD_VIDEO_SDK_SUCCEED);
        qFSVideoView.setLoopBack(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(QFSVideoView qFSVideoView, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        gb0.b.d(qFSVideoView, this.E, feedCloudMeta$StFeed);
    }

    public void D() {
        QFSVideoView qFSVideoView;
        QLog.d("QFSLayerFastPlay", 1, "[onDestroy]");
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_unbind_report_when_fast_play_destroy", true) && (qFSVideoView = this.f416174h) != null) {
            VideoReport.unbindVideoPlayerInfo(qFSVideoView);
        }
    }

    public void F() {
        QLog.d("QFSLayerFastPlay", 1, "[onPause]");
        E();
        G();
    }

    public void G() {
        if (this.D == null) {
            QLog.d("QFSLayerFastPlay", 1, "[onRelease] mFastPlayFeed is null");
            return;
        }
        if (this.C) {
            QLog.d("QFSLayerFastPlay", 1, "[onRelease] re call");
            return;
        }
        QLog.d("QFSLayerFastPlay", 1, "[onRelease]");
        I();
        RFWThreadManager.getUIHandler().removeCallbacks(this.I);
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: m50.d
            @Override // java.lang.Runnable
            public final void run() {
                h.this.C();
            }
        });
        this.G.x(0, this.D);
        this.C = true;
    }

    public boolean H(Activity activity, FeedCloudMeta$StFeed feedCloudMeta$StFeed, c cVar) {
        ImageView imageView;
        this.H = cVar;
        QFSVideoView qFSVideoView = this.f416174h;
        if (qFSVideoView != null && i.T(feedCloudMeta$StFeed)) {
            this.D = feedCloudMeta$StFeed;
            this.G.v(activity);
            this.G.y(new ArrayList());
            FrameLayout frameLayout = this.f416175i;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
                VideoReport.addToDetectionWhitelist(activity);
                VideoReport.setPageId(this.f416175i, u());
                VideoReport.setPageParams(this.f416175i, new QCircleDTParamBuilder().buildPageParams("QFSLayerFastPlay", new HashMap()));
                VideoReport.setLogicParent(qFSVideoView, this.f416175i);
            }
            if (this.F && (imageView = this.E) != null) {
                gb0.b.d(qFSVideoView, imageView, feedCloudMeta$StFeed);
                p(this.E, feedCloudMeta$StFeed);
            }
            r(qFSVideoView, feedCloudMeta$StFeed);
            RFWThreadManager.getUIHandler().postDelayed(this.I, t());
            return true;
        }
        E();
        G();
        return false;
    }

    @Override // l40.a
    public void Q6() {
        RFWLog.i("QFSLayerFastPlay", RFWLog.USR, "onRealPlayEnvReady");
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: m50.b
            @Override // java.lang.Runnable
            public final void run() {
                h.this.B();
            }
        });
    }

    @Override // l40.a
    public void T4() {
        if (this.C) {
            return;
        }
        QLog.d("QFSLayerFastPlay", 1, "[doPlayerReuse] mFastPlayVideoView:" + this.f416174h);
        RFWPlayerReuseUtils.prepareToReusePlayer(this.f416174h);
    }

    public String u() {
        String str = this.f416172e;
        if (TextUtils.isEmpty(str)) {
            return QCircleDaTongConstant.PageId.PG_XSJ_LAYER_PAGE;
        }
        return str;
    }

    public void v(ViewGroup viewGroup, float f16, float f17, boolean z16) {
        if (viewGroup == null) {
            return;
        }
        this.f416173f = viewGroup;
        RFWIocAbilityProvider.g().registerIoc(viewGroup, this, l40.a.class);
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setPadding(0, (int) f16, 0, (int) f17);
        frameLayout.setBackgroundColor(-16777216);
        viewGroup.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        QFSVideoView qFSVideoView = new QFSVideoView(RFWApplication.getApplication());
        qFSVideoView.setLoopBack(true);
        frameLayout.addView(qFSVideoView, new FrameLayout.LayoutParams(-1, -1));
        if (z16) {
            ImageView imageView = new ImageView(viewGroup.getContext());
            this.E = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            frameLayout.addView(this.E, new FrameLayout.LayoutParams(-1, -1));
        } else {
            this.E = new ImageView(viewGroup.getContext());
        }
        frameLayout.setVisibility(4);
        this.F = z16;
        this.f416175i = frameLayout;
        this.f416174h = qFSVideoView;
        w(viewGroup);
    }

    public boolean x() {
        return this.f416176m;
    }
}
