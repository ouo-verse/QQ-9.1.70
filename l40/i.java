package l40;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdTopViewPresenter;
import com.tencent.biz.qqcircle.immersive.utils.ac;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.immersive.utils.y;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.order.RFWOrderElementManager;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerOnInfoListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener;
import com.tencent.biz.richframework.video.rfw.view.RFWPlayerReuseUtils;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.utils.QCircleVideoDeviceInfoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import gb0.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.util.WeakReference;
import tianshu.QQCircleTianShu$AdItem;

/* compiled from: P */
/* loaded from: classes4.dex */
public class i implements l40.a {
    private static Boolean M;
    private static Boolean N;
    private static Boolean P;
    private boolean C;
    private FrameLayout D;
    private boolean F;
    private WeakReference<View> I;
    private String J;
    private boolean K;
    private z70.b L;

    /* renamed from: d, reason: collision with root package name */
    private Runnable f413812d;

    /* renamed from: e, reason: collision with root package name */
    private QFSVideoView f413813e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f413814f;

    /* renamed from: h, reason: collision with root package name */
    private e f413815h;

    /* renamed from: i, reason: collision with root package name */
    private FeedCloudMeta$StFeed f413816i;

    /* renamed from: m, reason: collision with root package name */
    private long f413817m;
    protected final com.tencent.biz.qqcircle.immersive.report.f E = new com.tencent.biz.qqcircle.immersive.report.f("QCircleFastVideoPlayWrapper_");
    private boolean G = false;
    private final Runnable H = new Runnable() { // from class: l40.b
        @Override // java.lang.Runnable
        public final void run() {
            i.this.b0();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements IRFWPlayerSdkInitListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QFSVideoView f413819d;

        b(QFSVideoView qFSVideoView) {
            this.f413819d = qFSVideoView;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener
        public void onInitSuccess(RFWPlayer rFWPlayer) {
            i.this.E.i8(QCircleFolderFunnelCollect.PERIOD_VIDEO_SDK_SUCCEED);
            QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_VIDEO_SDK_SUCCEED);
            this.f413819d.setLoopBack(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements IRFWPlayerPrepareListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QFSVideoView f413821d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ImageView f413822e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f413823f;

        c(QFSVideoView qFSVideoView, ImageView imageView, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f413821d = qFSVideoView;
            this.f413822e = imageView;
            this.f413823f = feedCloudMeta$StFeed;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onFirstFrameRendered(RFWPlayer rFWPlayer) {
            QLog.d("QCircleFastVideoPlayWrapper_", 1, "[onFirstFrameRendered]");
            i.this.F = true;
            i.this.E.Y7(rFWPlayer);
            i.this.E.i8(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_FIRST_RENDER);
            QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_FIRST_RENDER);
            i.this.O();
            i.this.u();
            com.tencent.mobileqq.qcircle.api.global.a.f(System.currentTimeMillis() - i.this.f413817m);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onVideoPrepared(RFWPlayer rFWPlayer) {
            QLog.d("QCircleFastVideoPlayWrapper_", 1, "[onVideoPrepared] mHaveRelease:" + i.this.G);
            if (i.this.G && i.this.J()) {
                return;
            }
            i.this.E.onVideoPrepared(rFWPlayer);
            i.this.E.i8(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_PREPARED);
            QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_PREPARED);
            i.this.B(this.f413821d, this.f413822e, rFWPlayer.getRealPlayer(), this.f413823f);
            RFWPlayerOptions rFWPlayerOptions = rFWPlayer.getRFWPlayerOptions();
            boolean hitPreloadCache = rFWPlayerOptions.hitPreloadCache();
            boolean isPreloadPlayer = rFWPlayerOptions.isPreloadPlayer();
            boolean firstFramePreRenderSucceed = rFWPlayerOptions.getFirstFramePreRenderSucceed();
            if (isPreloadPlayer) {
                hitPreloadCache = true;
            }
            QLog.d("QCircleFastVideoPlayWrapper_", 1, "[onVideoPrepared] hitCache:" + hitPreloadCache + ",hitPreloadPlayer:" + isPreloadPlayer + ",firstFramePreRenderSucceed:" + firstFramePreRenderSucceed);
            if (i.v()) {
                QCircleToast.o("\u7f13\u5b58\uff1a" + hitPreloadCache + ",\u9884\u6e32\u67d3\uff1a" + isPreloadPlayer + ",\u6e32\u67d3\u6210\u529f\uff1a" + firstFramePreRenderSucceed, 3000);
            }
            com.tencent.mobileqq.qcircle.api.global.a.g(hitPreloadCache, isPreloadPlayer, firstFramePreRenderSucceed);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements IRFWPlayErrorStatusListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RFWPlayerOptions f413825d;

        d(RFWPlayerOptions rFWPlayerOptions) {
            this.f413825d = rFWPlayerOptions;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener
        public void onVideoPlayError(int i3, int i16, int i17, String str) {
            String fileId;
            QLog.d("QCircleFastVideoPlayWrapper_", 1, "[onVideoPlayError] errorType:" + i16 + ",errorCode:" + i17);
            i.this.u();
            i.this.E.onVideoPlayError(i17);
            com.tencent.biz.qqcircle.immersive.report.b f16 = com.tencent.biz.qqcircle.immersive.report.b.f();
            RFWPlayerOptions rFWPlayerOptions = this.f413825d;
            if (rFWPlayerOptions == null) {
                fileId = "";
            } else {
                fileId = rFWPlayerOptions.getFileId();
            }
            f16.p(fileId, i3, i16, i17, str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface e {
        FeedCloudMeta$StFeed a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(final QFSVideoView qFSVideoView, ImageView imageView, ISuperPlayer iSuperPlayer, final FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (qFSVideoView != null && feedCloudMeta$StFeed != null && iSuperPlayer != null) {
            this.F = true;
            D(qFSVideoView, feedCloudMeta$StFeed);
            qFSVideoView.start();
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: l40.g
                @Override // java.lang.Runnable
                public final void run() {
                    i.this.a0(qFSVideoView, feedCloudMeta$StFeed);
                }
            });
            QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_START_PLAY);
        }
    }

    private void C(Context context, @NonNull QFSVideoView qFSVideoView, ImageView imageView, @NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (this.G) {
            QLog.d("QCircleFastVideoPlayWrapper_", 1, "[doVideoPlayLogic] but have release");
            return;
        }
        this.E.Gd();
        this.E.i8(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_AUTO_PLAY);
        String N2 = r.N(feedCloudMeta$StFeed.video.playUrl.get());
        RFWPlayerOptions addAttachInfo = RFWPlayerOptions.obtain(cq.f92752a.p(feedCloudMeta$StFeed)).setPlayUrl(feedCloudMeta$StFeed.video.playUrl.get()).setFileId(feedCloudMeta$StFeed.video.fileId.get()).setStVideo(gb0.b.k(feedCloudMeta$StFeed.video)).setStartOffset(0L).setFromType(2).setEnableDataCollect(true).addAttachInfo("ATTACH_INFO_KEY_POI", 0);
        if (QCirclePluginUtil.isQFSTabNativeFragmentMode(context)) {
            addAttachInfo.setIsMutualExclusion(false);
        }
        o(qFSVideoView, imageView, feedCloudMeta$StFeed, addAttachInfo, N2);
        RFWLog.d("QCircleFastVideoPlayWrapper__" + addAttachInfo.tag(), RFWLog.USR, "fs_lifecycle  startANewPlayer:" + ac.f90062a.a(feedCloudMeta$StFeed.content.get()));
        qFSVideoView.loadPlayOptions(addAttachInfo);
        this.E.i8(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_SET_VIDEO_PATH);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void D(QFSVideoView qFSVideoView, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        View view;
        if (qFSVideoView != null && feedCloudMeta$StFeed != null) {
            Map<String, ?> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            e30.b bVar = new e30.b(feedCloudMeta$StFeed);
            bVar.p();
            buildElementParams.putAll(ua0.c.d(bVar));
            buildElementParams.putAll(ua0.c.e(feedCloudMeta$StFeed));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, 1);
            buildElementParams.put("xsj_custom_pgid", "pg_xsj_explore_page");
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
            VideoEntity build = new VideoEntity.Builder().setContentId(feedCloudMeta$StFeed.f398449id.get()).setPage((Object) "pg_xsj_explore_page").setContentType(2).setVideoDuration(feedCloudMeta$StFeed.video.duration.get()).setVideoView(view).addCustomParams(buildElementParams).ignoreReport(false).bizReady(true).build();
            ISuperPlayer superPlayer = qFSVideoView.getSuperPlayer();
            if (superPlayer != null) {
                VideoReport.bindVideoPlayerInfo(superPlayer, build);
                RFWLog.i("QCircleFastVideoPlayWrapper_", RFWLog.USR, "dtReportBindVideoData");
            }
        }
    }

    public static boolean E() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_frame_enable_anr_thread_protect", true);
    }

    public static boolean F() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_can_use_folder_file_cache_use_next_video", true);
    }

    public static boolean G() {
        Boolean bool = N;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_fast_play_cancel_runnable_when_pause", true);
        N = Boolean.valueOf(isSwitchOn);
        return isSwitchOn;
    }

    public static boolean H() {
        Boolean bool = P;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_fast_play_use_display_order", true));
        P = valueOf;
        return valueOf.booleanValue();
    }

    public static boolean I() {
        Boolean bool = M;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (!p0()) {
            M = Boolean.FALSE;
            QLog.d("QCircleFastVideoPlayWrapper_", 1, "[enableFastPlay] videoDeviceLevel not support");
            return false;
        }
        if (com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_CLOSE_FAST_PLAY_CONTROLLER, 0)) {
            M = Boolean.FALSE;
            QLog.d("QCircleFastVideoPlayWrapper_", 1, "[enableFastPlay] close by debug");
            return false;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_can_use_folder_fast_play", true);
        M = Boolean.valueOf(isSwitchOn);
        return isSwitchOn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_fast_play_release_intercept", true);
    }

    private long L() {
        try {
            return Long.parseLong(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_folder_fast_play_time_out_duration", QzoneConfig.DefaultValue.DEFAULT_GIF_ANTISHAKE_MAX_FRAME_SHOOTTIME));
        } catch (Exception unused) {
            return 3000L;
        }
    }

    private View M() {
        WeakReference<View> weakReference = this.I;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static Drawable N() {
        return new ColorDrawable(QCircleSkinHelper.getInstance().getColor(R.color.cje));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        QLog.d("QCircleFastVideoPlayWrapper_", 1, "[hideCoverView]");
        ImageView imageView = this.f413814f;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private void Q(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (y.f(feedCloudMeta$StFeed)) {
            QLog.d("QCircleFastVideoPlayWrapper_", 1, "[hideOtherViewByOrder] ad feed");
        } else {
            QLog.d("QCircleFastVideoPlayWrapper_", 1, "[hideOtherViewByOrder] normal feed");
            n0(true);
        }
    }

    private void R(Context context) {
        if (!H()) {
            QLog.e("QCircleFastVideoPlayWrapper_", 1, "[initOrderPriorityView] disallow by config");
            return;
        }
        z70.b bVar = new z70.b(context, "folder_pendant", 105);
        com.tencent.biz.qqcircle.immersive.manager.e.a().addElement(bVar);
        this.L = bVar;
    }

    private void S(View view) {
        QCircleReportBean qCircleReportBean = new QCircleReportBean();
        qCircleReportBean.setDtPageId("xsj_fast_play");
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setSchemeAttrs(new HashMap<>());
        this.E.r(view, "pg_xsj_explore_page", qCircleReportBean, qCircleInitBean);
        this.E.J(true);
    }

    public static boolean T(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null || feedCloudMeta$StFeed.type.get() != 3) {
            return false;
        }
        int i3 = feedCloudMeta$StFeed.feedType.get();
        if (i3 == 1) {
            return true;
        }
        if (i3 != 4) {
            return false;
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_folder_fast_play_enable_ad_feed", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void W(RFWPlayerOptions rFWPlayerOptions, int i3, long j3, long j16, Object obj) {
        com.tencent.biz.qqcircle.immersive.report.b.f().q(rFWPlayerOptions.getFileId(), i3, j3, j16, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void X(final RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addInfoListener(new IRFWPlayerOnInfoListener() { // from class: l40.h
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerOnInfoListener
            public final void onInfo(int i3, long j3, long j16, Object obj) {
                i.W(RFWPlayerOptions.this, i3, j3, j16, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Y(float f16) {
        QLog.d("QCircleFastVideoPlayWrapper_", 1, "[collectFastPlayCacheInfo] time:" + f16);
        com.tencent.mobileqq.qcircle.api.global.a.e(f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(Context context, QFSVideoView qFSVideoView, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        C(context, qFSVideoView, this.f413814f, feedCloudMeta$StFeed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(QFSVideoView qFSVideoView, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        gb0.b.d(qFSVideoView, this.f413814f, feedCloudMeta$StFeed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0() {
        QLog.d("QCircleFastVideoPlayWrapper_", 1, "mEnvTimeOutRunnable run");
        com.tencent.mobileqq.qcircle.api.global.a.h(true);
        u();
        i0();
        if (v()) {
            QCircleToast.o("fastPlay\u64ad\u653e\u8d85\u65f6", 3000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c0(FrameLayout frameLayout) {
        try {
            ViewParent parent = frameLayout.getParent();
            if (parent instanceof ViewGroup) {
                QLog.d("QCircleFastVideoPlayWrapper_", 1, "[tryRemoveFastPlayRootView] real remove");
                ((ViewGroup) parent).removeView(frameLayout);
            }
        } catch (Exception e16) {
            QLog.e("QCircleFastVideoPlayWrapper_", 1, "[tryRemoveFastPlayRootView] error\uff1a" + e16);
        }
    }

    private void g0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QLog.d("QCircleFastVideoPlayWrapper_", 1, "[pauseVideo] currentFastPlayFeed\uff1a" + feedCloudMeta$StFeed);
        QFSVideoView qFSVideoView = this.f413813e;
        if (qFSVideoView != null && feedCloudMeta$StFeed != null) {
            qFSVideoView.pause();
            if (J()) {
                this.f413813e.release();
            }
            VideoReport.unbindVideoPlayerInfo(this.f413813e);
        }
    }

    private void i0() {
        QLog.d("QCircleFastVideoPlayWrapper_", 1, "[releaseFastPlay]");
        g0(this.f413816i);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f413816i;
        if (feedCloudMeta$StFeed != null) {
            this.E.x(0, feedCloudMeta$StFeed);
        }
        P();
        RFWThreadManager.getUIHandler().removeCallbacks(this.H);
        this.f413816i = null;
        s0();
        q0();
        this.G = true;
    }

    private void m0(Context context, boolean z16) {
        if (!H()) {
            QLog.e("QCircleFastVideoPlayWrapper_", 1, "[setOrderPriority] disallow by config, fastPlayShow:" + z16);
            return;
        }
        if (z16) {
            this.K = true;
        } else {
            if (!this.K) {
                QLog.d("QCircleFastVideoPlayWrapper_", 1, "[setOrderPriority] hide but not rob");
                return;
            }
            this.K = false;
        }
        z70.b x16 = QFSFeedChildAdTopViewPresenter.x1(context);
        if (x16 != null) {
            QLog.d("QCircleFastVideoPlayWrapper_", 1, "[setOrderPriority] real active fastPlayShow:" + z16);
            if (z16) {
                x16.l(RFWOrderElementManager.OrderMode.ROB_MODE);
            } else {
                x16.m();
            }
        }
    }

    private void n0(boolean z16) {
        View M2 = M();
        if (M2 == null) {
            QLog.e("QCircleFastVideoPlayWrapper_", 1, "[setOrderPriority] iocRegisterContainer is null, fastPlayShow:" + z16);
            return;
        }
        m0(M2.getContext(), z16);
    }

    private void o(QFSVideoView qFSVideoView, ImageView imageView, @NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, RFWPlayerOptions rFWPlayerOptions, String str) {
        if (rFWPlayerOptions == null) {
            return;
        }
        s(qFSVideoView, rFWPlayerOptions);
        r(qFSVideoView, imageView, rFWPlayerOptions, feedCloudMeta$StFeed);
        p(feedCloudMeta$StFeed, rFWPlayerOptions);
        q(rFWPlayerOptions);
    }

    private void p(FeedCloudMeta$StFeed feedCloudMeta$StFeed, @NonNull RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addErrorStatusListener(new d(rFWPlayerOptions));
    }

    private static boolean p0() {
        if (QCircleVideoDeviceInfoUtils.getVideoDeviceLevel() != 1 || ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_can_use_folder_fast_play_low_devices", true)) {
            return true;
        }
        QLog.e("QCircleFastVideoPlayWrapper_", 1, "[supportFastPlay] is low device");
        return false;
    }

    private void q(final RFWPlayerOptions rFWPlayerOptions) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: l40.f
            @Override // java.lang.Runnable
            public final void run() {
                i.X(RFWPlayerOptions.this);
            }
        });
    }

    private void q0() {
        final FrameLayout frameLayout = this.D;
        if (frameLayout == null) {
            QLog.d("QCircleFastVideoPlayWrapper_", 1, "[tryRemoveFastPlayRootView] fastPlayViewContainer is null");
        } else {
            QLog.d("QCircleFastVideoPlayWrapper_", 1, "[tryRemoveFastPlayRootView]");
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: l40.d
                @Override // java.lang.Runnable
                public final void run() {
                    i.c0(frameLayout);
                }
            });
        }
    }

    private void r(QFSVideoView qFSVideoView, ImageView imageView, RFWPlayerOptions rFWPlayerOptions, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        rFWPlayerOptions.getListenerSet().addPrepareListeners(new c(qFSVideoView, imageView, feedCloudMeta$StFeed));
    }

    private void r0(View view) {
        if (view != null) {
            QLog.d("QCircleFastVideoPlayWrapper_", 1, "[unRegisterIoc] iocRegisterContainer: " + view);
            RFWIocAbilityProvider.g().unregisterSingleIoc(view, l40.a.class);
        }
    }

    private void s(QFSVideoView qFSVideoView, RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addSDKInitListeners(new b(qFSVideoView));
    }

    private void t(FrameLayout frameLayout) {
        if (this.f413813e != null && frameLayout != null) {
            VideoReport.setPageId(frameLayout, "pg_xsj_explore_page");
            VideoReport.setPageParams(frameLayout, new QCircleDTParamBuilder().buildPageParams("QCircleFastVideoPlayWrapper_", new HashMap()));
            VideoReport.setLogicParent(this.f413813e, frameLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        Runnable runnable = this.f413812d;
        QLog.d("QCircleFastVideoPlayWrapper_", 1, "[onFastPlayFinish] realCall:" + runnable);
        if (runnable != null) {
            runnable.run();
            this.f413812d = null;
        }
    }

    public static boolean v() {
        return com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_ENABLE_FAST_PLAY_LOG, 0);
    }

    private void x(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        new gb0.d(new d.a() { // from class: l40.e
            @Override // gb0.d.a
            public final void a(float f16) {
                i.Y(f16);
            }
        }).b(feedCloudMeta$StFeed);
    }

    private boolean y() {
        if (bz.l() && TransitionHelper.isFolderScreenOpenMode(RFWApplication.getApplication())) {
            return false;
        }
        return true;
    }

    private void z(@NonNull ImageView imageView, @NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
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
        QLog.d("QCircleFastVideoPlayWrapper_", 1, "[bindCover] option:" + targetView);
        targetView.setLoadingDrawable(N());
        targetView.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        QCircleFeedPicLoader.g().loadImage(targetView);
    }

    public void A(final Context context, Runnable runnable) {
        boolean z16;
        this.G = false;
        final FeedCloudMeta$StFeed a16 = this.f413815h.a();
        final QFSVideoView qFSVideoView = this.f413813e;
        boolean T = T(a16);
        boolean y16 = gb0.b.y(a16);
        QCirclePluginGlobalInfo.i0(null);
        int x16 = QCirclePluginGlobalInfo.x(false);
        if (x16 != -1 && x16 != 6) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("QCircleFastVideoPlayWrapper_", 1, "[doFastPlay] afterRunnable:" + runnable + ",nextFolderNeedPlayFeed:" + a16 + ",videoView:" + qFSVideoView + ",normalVideoFeed:" + T + ",videoDownloadSucceed:" + y16 + ",interceptBySchemaType:" + z16);
        if (!z16 && T && qFSVideoView != null && y()) {
            this.E.v(null);
            this.E.y(new ArrayList());
            this.f413817m = System.currentTimeMillis();
            QLog.d("QCircleFastVideoPlayWrapper_", 1, "[doFastPlay] feedId:" + a16.f398449id.get() + ",videoDownloadSucceed:" + y16 + ",videoPreRenderSucceed:" + gb0.b.A(a16));
            RFWThreadManager.getUIHandler().postDelayed(this.H, L());
            this.J = a16.f398449id.get();
            QCirclePluginGlobalInfo.i0(a16);
            this.f413816i = a16;
            this.f413812d = runnable;
            FrameLayout frameLayout = this.D;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
                t(this.D);
            }
            gb0.b.d(qFSVideoView, this.f413814f, a16);
            z(this.f413814f, a16);
            x(a16);
            if (E()) {
                RFWThreadManager.getUIHandler().postAtFrontOfQueue(new Runnable() { // from class: l40.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.this.Z(context, qFSVideoView, a16);
                    }
                });
            } else {
                C(context, qFSVideoView, this.f413814f, a16);
            }
            Q(a16);
            return;
        }
        if (v()) {
            QCircleToast.o("\u662f\u5426\u89c6\u9891feed\uff1a" + T, 3000);
        }
        runnable.run();
    }

    public boolean K() {
        if (this.f413812d == null) {
            return true;
        }
        return false;
    }

    public void P() {
        FrameLayout frameLayout = this.D;
        if (frameLayout != null) {
            QLog.d("QCircleFastVideoPlayWrapper_", 1, "[hideFastVideoView] fastPlayViewContainer:" + frameLayout);
            frameLayout.setVisibility(8);
        }
    }

    @Override // l40.a
    public void Q6() {
        QLog.d("QCircleFastVideoPlayWrapper_", 1, "[onRealPlayEnvReady]");
        i0();
        u();
    }

    @Override // l40.a
    public void T4() {
        QLog.d("QCircleFastVideoPlayWrapper_", 1, "[doPlayerReuse] mFastPlayVideoView:" + this.f413813e);
        RFWPlayerReuseUtils.prepareToReusePlayer(this.f413813e);
    }

    public boolean U() {
        return this.C;
    }

    public boolean V() {
        return this.G;
    }

    public void d0() {
        QLog.d("QCircleFastVideoPlayWrapper_", 1, "[onDestroy] mFastPlayViewContainer:" + this.D);
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_fast_play_use_same_release_logic", true)) {
            i0();
        } else {
            QFSVideoView qFSVideoView = this.f413813e;
            if (qFSVideoView != null) {
                qFSVideoView.release();
            }
            s0();
        }
        this.E.w();
        QLog.d("QCircleFastVideoPlayWrapper_", 1, "[onDestroy] 1");
    }

    public void e0() {
        QLog.d("QCircleFastVideoPlayWrapper_", 1, "[onPause]");
        if (G()) {
            w();
        } else {
            u();
            i0();
        }
    }

    public void f0() {
        QLog.d("QCircleFastVideoPlayWrapper_", 1, "[onResume]");
    }

    public void h0(View view) {
        if (view == null) {
            QLog.d("QCircleFastVideoPlayWrapper_", 1, "[attachIoc] rootView is null");
            return;
        }
        if (this.G) {
            return;
        }
        View M2 = M();
        if (M2 == view) {
            QLog.d("QCircleFastVideoPlayWrapper_", 1, "[attachIoc] re register " + view);
            return;
        }
        if (M2 != null) {
            r0(M2);
        }
        Context context = view.getContext();
        if (context == null) {
            QLog.d("QCircleFastVideoPlayWrapper_", 1, "[attachIoc] context is null");
        }
        this.I = new WeakReference<>(view);
        QLog.d("QCircleFastVideoPlayWrapper_", 1, "[registerIoc] rootView:" + view + ",context:" + view.getContext().hashCode());
        RFWIocAbilityProvider.g().registerIoc(view, this, l40.a.class);
        S(view);
        R(context);
    }

    public void j0() {
        z70.b bVar;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_fast_play_auto_release_order_element", true) && (bVar = this.L) != null) {
            this.L = null;
            QLog.d("QCircleFastVideoPlayWrapper_", 1, "[releaseOrderElement]" + bVar);
            com.tencent.biz.qqcircle.immersive.manager.e.a().removeElement(bVar);
        }
    }

    public void k0() {
        QLog.d("QCircleFastVideoPlayWrapper_", 1, "[resetExpFlag]");
        M = null;
        N = null;
        P = null;
    }

    public void l0(e eVar) {
        this.f413815h = eVar;
    }

    @MainThread
    public void o0(ViewGroup viewGroup, int i3, int i16, boolean z16) {
        if (this.C) {
            return;
        }
        k0();
        if (viewGroup == null) {
            QLog.d("QCircleFastVideoPlayWrapper_", 1, "[setRootView] rootView is null");
            return;
        }
        QLog.d("QCircleFastVideoPlayWrapper_", 1, "[setRootView] topMargin:" + i3 + ",bottomMargin:" + i16 + ",needAdjustNavigationBar:" + z16);
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setBackgroundColor(-16777216);
        QFSVideoView qFSVideoView = new QFSVideoView(RFWApplication.getApplication());
        qFSVideoView.setLoopBack(true);
        frameLayout.setPadding(0, i3, 0, 0);
        frameLayout.addView(qFSVideoView, new FrameLayout.LayoutParams(-1, -1));
        ImageView imageView = new ImageView(viewGroup.getContext());
        this.f413814f = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        frameLayout.addView(this.f413814f, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setOnTouchListener(new a());
        frameLayout.setVisibility(8);
        this.D = frameLayout;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = i16;
        viewGroup.addView(frameLayout, layoutParams);
        if (z16) {
            com.tencent.mobileqq.qui.b.f276860a.a(frameLayout, RFWNavigationBarImmersiveHelper.ImmersiveType.ABOVE);
        }
        this.f413813e = qFSVideoView;
        this.C = true;
    }

    public void s0() {
        QLog.d("QCircleFastVideoPlayWrapper_", 1, "[unRegisterIoc]");
        View M2 = M();
        if (M2 != null) {
            m0(M2.getContext(), false);
            r0(M2);
        }
        this.I = null;
    }

    public void w() {
        QLog.d("QCircleFastVideoPlayWrapper_", 1, "[cancelFastPlay] mAfterFirstRenderRunnable:" + this.f413812d);
        this.f413812d = null;
        i0();
    }
}
