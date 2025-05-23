package com.tencent.mobileqq.qqecommerce.base.video;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.qqcircle.immersive.views.search.QFSVideoTaskRunner;
import com.tencent.biz.qqcircle.immersive.views.search.widget.QFSSearchVideoView;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.RFWTVKPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerUpperData;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerCompletionListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerOnInfoListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSecondBufferListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWSeekCompletionListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWVideoSizeChangedListener;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.room.QCircleLiveFeedsPlayerEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.open.base.g;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.superplayer.api.ISuperPlayer;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StVideo;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\u0007\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002\u0014V\u0018\u0000 q2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n:\u0001.B\u000f\u0012\u0006\u0010n\u001a\u00020m\u00a2\u0006\u0004\bo\u0010pJ\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000bH\u0002J!\u0010\u0015\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u001a\u0010\u001d\u001a\u00020\u000f2\u0010\u0010\u001c\u001a\f\u0012\u0004\u0012\u00020\u000f0\u001aj\u0002`\u001bH\u0002J\u0018\u0010!\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0002J\b\u0010#\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010%\u001a\u00020\u000fH\u0016J\b\u0010&\u001a\u00020\u000fH\u0016J\b\u0010'\u001a\u00020\u000fH\u0016J\u0018\u0010+\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u001eH\u0016J\u0010\u0010.\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020\u000fH\u0016J\u0010\u00102\u001a\u00020\u000f2\u0006\u00101\u001a\u000200H\u0016J\u0010\u00104\u001a\u00020\u000f2\u0006\u00103\u001a\u000200H\u0016J\u0010\u00105\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u001eH\u0016J\b\u00106\u001a\u00020(H\u0016J\b\u00107\u001a\u00020(H\u0016J\b\u00108\u001a\u00020(H\u0016J\b\u00109\u001a\u00020\u001eH\u0016J*\u0010?\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020\u001e2\u0006\u0010;\u001a\u00020(2\u0006\u0010<\u001a\u00020(2\b\u0010>\u001a\u0004\u0018\u00010=H\u0016J*\u0010E\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020\u001e2\u0006\u0010A\u001a\u00020\u001e2\u0006\u0010B\u001a\u00020\u001e2\b\u0010D\u001a\u0004\u0018\u00010CH\u0016J\u0012\u0010H\u001a\u00020\u000f2\b\u0010G\u001a\u0004\u0018\u00010FH\u0016J\u0012\u0010K\u001a\u00020\u000f2\b\u0010J\u001a\u0004\u0018\u00010IH\u0016J\u0012\u0010L\u001a\u00020\u000f2\b\u0010J\u001a\u0004\u0018\u00010IH\u0016J\b\u0010M\u001a\u00020\u000fH\u0016J\b\u0010N\u001a\u00020\u000fH\u0016J\b\u0010O\u001a\u00020\u000fH\u0016J\b\u0010P\u001a\u00020\u000fH\u0016J\u0012\u0010Q\u001a\u00020\u000f2\b\u0010J\u001a\u0004\u0018\u00010IH\u0016J\u0012\u0010R\u001a\u00020\u000f2\b\u0010G\u001a\u0004\u0018\u00010FH\u0016J\"\u0010U\u001a\u00020\u000f2\b\u0010G\u001a\u0004\u0018\u00010F2\u0006\u0010S\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020\u001eH\u0016R\u0014\u0010Y\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010\\\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[Rd\u0010b\u001aR\u0012\"\u0012 \u0012\u0004\u0012\u00020\u000f ^*\u0010\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001aj\u0004\u0018\u0001`\u001b0\u001aj\u0002`\u001b ^*(\u0012\"\u0012 \u0012\u0004\u0012\u00020\u000f ^*\u0010\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001aj\u0004\u0018\u0001`\u001b0\u001aj\u0002`\u001b\u0018\u00010_0]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u001c\u0010h\u001a\n ^*\u0004\u0018\u00010e0e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010i\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010dR\u0018\u0010l\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010k\u00a8\u0006r"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/video/ECQFSVideoView;", "Lcom/tencent/mobileqq/qqecommerce/base/video/f;", "Lcom/tencent/biz/richframework/video/rfw/player/listener/IRFWPlayerOnInfoListener;", "Lcom/tencent/biz/richframework/video/rfw/player/listener/IRFWPlayErrorStatusListener;", "Lcom/tencent/biz/richframework/video/rfw/player/listener/IRFWPlayerCompletionListener;", "Lcom/tencent/biz/richframework/video/rfw/player/listener/IRFWPlayerPrepareListener;", "Lcom/tencent/biz/richframework/video/rfw/player/listener/IRFWPlayerLooperListener;", "Lcom/tencent/biz/richframework/video/rfw/player/listener/IRFWPlayerSecondBufferListener;", "Lcom/tencent/biz/richframework/video/rfw/player/listener/IRFWPlayerSdkInitListener;", "Lcom/tencent/biz/richframework/video/rfw/player/listener/IRFWSeekCompletionListener;", "Lcom/tencent/biz/richframework/video/rfw/player/listener/IRFWVideoSizeChangedListener;", "Lcom/tencent/mobileqq/qqecommerce/base/video/c;", "info", "Lfeedcloud/FeedCloudMeta$StFeed;", "stFeed", "", DomainData.DOMAIN_NAME, ReportConstant.COSTREPORT_PREFIX, "r", "t", "com/tencent/mobileqq/qqecommerce/base/video/ECQFSVideoView$b", "o", "(Lcom/tencent/mobileqq/qqecommerce/base/video/c;Lfeedcloud/FeedCloudMeta$StFeed;)Lcom/tencent/mobileqq/qqecommerce/base/video/ECQFSVideoView$b;", "Lcom/tencent/biz/richframework/video/rfw/player/RFWPlayerOptions;", "options", "u", "Lkotlin/Function0;", "Lcom/tencent/mobileqq/qqecommerce/base/video/LazyTask;", "lazyTask", "v", "", "videoWidth", "videoHeight", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "getView", "b", "pause", "release", "start", "", com.tencent.luggage.wxa.c8.c.G, "mode", InnerAudioPlugin.AUDIO_OPERATE_SEEK, "Lcom/tencent/mobileqq/qqecommerce/base/video/d;", "callback", "a", "stop", "", "loop", "setLoop", "mute", "setMute", QCircleLiveFeedsPlayerEvent.EVENT_FIX_XY, "getCurrentPositionMs", "getDurationMs", "getFileSizeBytes", "getState", "what", "arg1", "arg2", "", "extra", "onInfo", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "", "extraInfo", "onVideoPlayError", "Lcom/tencent/superplayer/api/ISuperPlayer;", "iSuperPlayer", "onCompletion", "Lcom/tencent/biz/richframework/video/rfw/RFWPlayer;", "player", "onVideoPrepared", "onFirstFrameRendered", "onVideoLoopStart", "onVideoLoopEnd", "onSecondBufferStart", "onSecondBufferEnd", "onInitSuccess", "onSeekCompletion", "width", "height", "onVideoSizeChanged", "com/tencent/mobileqq/qqecommerce/base/video/ECQFSVideoView$qfsVideoView$1", "d", "Lcom/tencent/mobileqq/qqecommerce/base/video/ECQFSVideoView$qfsVideoView$1;", "qfsVideoView", "e", "Lcom/tencent/mobileqq/qqecommerce/base/video/d;", "eventCallback", "", "kotlin.jvm.PlatformType", "", "f", "Ljava/util/Set;", "lazyTaskList", h.F, "Z", "Lcom/tencent/biz/qqcircle/immersive/views/search/QFSVideoTaskRunner;", "i", "Lcom/tencent/biz/qqcircle/immersive/views/search/QFSVideoTaskRunner;", "mediaTaskRunner", "isSyncTask", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqecommerce/base/video/c;", QCircleScheme.AttrDetail.VIDEO_INFO, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "D", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECQFSVideoView implements f, IRFWPlayerOnInfoListener, IRFWPlayErrorStatusListener, IRFWPlayerCompletionListener, IRFWPlayerPrepareListener, IRFWPlayerLooperListener, IRFWPlayerSecondBufferListener, IRFWPlayerSdkInitListener, IRFWSeekCompletionListener, IRFWVideoSizeChangedListener {

    /* renamed from: C, reason: from kotlin metadata */
    private ECVideoInfo videoInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ECQFSVideoView$qfsVideoView$1 qfsVideoView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private d eventCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Set<Function0<Unit>> lazyTaskList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mute;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final QFSVideoTaskRunner mediaTaskRunner;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isSyncTask;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/qqecommerce/base/video/ECQFSVideoView$b", "Lcom/tencent/biz/richframework/video/rfw/player/ioc/RFWPlayerIOC;", "", AppConstants.Key.COLUMN_IS_VALID, "Lcom/tencent/biz/richframework/video/rfw/player/stinfo/RFWPlayerReportInfo;", "getBusinessReportInfo", "Lcom/tencent/biz/richframework/video/rfw/player/ioc/RFWPlayerUpperData;", "getPlayerUpperData", "Lcooperation/qqcircle/report/QCircleReportBean;", "a", "d", "Lcom/tencent/biz/richframework/video/rfw/player/ioc/RFWPlayerUpperData;", "upperData", "e", "Lcooperation/qqcircle/report/QCircleReportBean;", "reportBean", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends RFWPlayerIOC {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final RFWPlayerUpperData upperData;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final QCircleReportBean reportBean;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f262501f;

        b(ECQFSVideoView eCQFSVideoView, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f262501f = feedCloudMeta$StFeed;
            RFWPlayerUpperData rFWPlayerUpperData = new RFWPlayerUpperData();
            this.upperData = rFWPlayerUpperData;
            QCircleReportBean qCircleReportBean = new QCircleReportBean();
            this.reportBean = qCircleReportBean;
            rFWPlayerUpperData.setContext(eCQFSVideoView.qfsVideoView.getContext());
            qCircleReportBean.setDtPageId("pg_xsj_game_tab_page");
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        /* renamed from: a, reason: from getter */
        public QCircleReportBean getReportBean() {
            return this.reportBean;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        public RFWPlayerReportInfo<?> getBusinessReportInfo() {
            e30.b bVar = new e30.b(this.f262501f);
            RFWPlayerReportInfo<e30.b> m3 = gb0.b.m(bVar);
            return m3 == null ? new RFWPlayerReportInfo<>(bVar) : m3;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        /* renamed from: getPlayerUpperData, reason: from getter */
        public RFWPlayerUpperData getUpperData() {
            return this.upperData;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        public boolean isValid() {
            return true;
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.tencent.mobileqq.qqecommerce.base.video.ECQFSVideoView$qfsVideoView$1, com.tencent.biz.qqcircle.immersive.views.search.widget.QFSSearchVideoView] */
    public ECQFSVideoView(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Activity a16 = af2.b.f25996a.a(context);
        context = a16 != null ? a16 : context;
        ?? r06 = new QFSSearchVideoView(context) { // from class: com.tencent.mobileqq.qqecommerce.base.video.ECQFSVideoView$qfsVideoView$1
            @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView
            public boolean isForbiddenDefaultPerfReport() {
                return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_player_slid_back_render", true);
            }
        };
        this.qfsVideoView = r06;
        this.lazyTaskList = Collections.newSetFromMap(new ConcurrentHashMap());
        this.mediaTaskRunner = QFSVideoTaskRunner.e();
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("kuikly_video_view_sync_task", true);
        this.isSyncTask = isSwitchOn;
        QLog.d("ECQFSVideoView", 2, "init: isSyncTask=" + isSwitchOn);
        r06.setProgressEnabled(true);
    }

    private final void m(int videoWidth, int videoHeight) {
        View view = getView();
        int width = view.getWidth();
        int height = view.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        float f16 = videoWidth / videoHeight;
        float f17 = width;
        if (Math.abs(f16 - (f17 / height)) < 0.01f) {
            return;
        }
        float f18 = f17 / f16;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = (int) f18;
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.gravity = 16;
        }
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(ECVideoInfo info, FeedCloudMeta$StFeed stFeed) {
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        PBUInt32Field pBUInt32Field;
        PBStringField pBStringField;
        Map<String, ?> params = new QCircleDTParamBuilder().buildElementParams();
        Map<String, Object> e16 = ua0.c.e(stFeed);
        Intrinsics.checkNotNullExpressionValue(e16, "convertDataToDTParamsMap(stFeed)");
        params.putAll(e16);
        String str = info.d().get("xsj_custom_pgid");
        if (str == null) {
            str = "pg_xsj_game_tab_page";
        }
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_custom_pgid", str);
        params.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(info.getFeedIndex()));
        params.putAll(info.d());
        VideoEntity.Builder builder = new VideoEntity.Builder();
        String str2 = (stFeed == null || (pBStringField = stFeed.f398449id) == null) ? null : pBStringField.get();
        if (str2 == null) {
            str2 = "";
        }
        VideoEntity build = builder.setContentId(str2).setPage((Object) str).setContentType(2).setVideoDuration((stFeed == null || (feedCloudMeta$StVideo = stFeed.video) == null || (pBUInt32Field = feedCloudMeta$StVideo.duration) == null) ? 0 : pBUInt32Field.get()).setVideoView((View) this.qfsVideoView).addCustomParams(params).ignoreReport(false).bizReady(true).build();
        ISuperPlayer superPlayer = getSuperPlayer();
        if (superPlayer != null) {
            VideoReport.bindVideoPlayerInfo(superPlayer, build);
        }
    }

    private final b o(ECVideoInfo info, FeedCloudMeta$StFeed stFeed) {
        return new b(this, stFeed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(ECQFSVideoView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.qfsVideoView.setOutPutMute(this$0.mute);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(ECQFSVideoView this$0, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(ECVideoInfo info, FeedCloudMeta$StFeed stFeed) {
        RFWPlayerOptions options = RFWPlayerOptions.obtain(RFWVideoUtils.parseSceneIdFromUrl(stFeed.video.playUrl.get())).setPlayUrl(stFeed.video.playUrl.get()).setFileId(stFeed.video.fileId.get()).setStVideo(gb0.b.k(stFeed.video)).setStartOffset(info.getStartPosMs()).setFromType(10).setPlayIOC(o(info, stFeed)).setIsMutualExclusion(false).setDisableSuperSample(true).setEnableDirectIP(false).setUseUrlMD5AsID(info.getUseUrlAsId());
        Intrinsics.checkNotNullExpressionValue(options, "options");
        u(options);
        loadPlayOptions(options);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(ECVideoInfo info) {
        String d16 = g.d(info.getUrl());
        FeedCloudMeta$StVideo feedCloudMeta$StVideo = new FeedCloudMeta$StVideo();
        feedCloudMeta$StVideo.playUrl.set(info.getUrl());
        feedCloudMeta$StVideo.fileId.set(d16);
        RFWPlayerOptions fromType = RFWPlayerOptions.obtain(RFWVideoUtils.parseSceneIdFromUrl(info.getUrl())).setPlayUrl(info.getUrl()).setFileId(d16).setIsMutualExclusion(false).setStVideo(gb0.b.k(feedCloudMeta$StVideo)).setStartOffset(info.getStartPosMs()).setFromType(10);
        MessageMicro<?> g16 = info.g();
        RFWPlayerOptions options = fromType.setPlayIOC(o(info, g16 instanceof FeedCloudMeta$StFeed ? (FeedCloudMeta$StFeed) g16 : null)).setDisableSuperSample(true).setEnableDirectIP(false).setUseUrlMD5AsID(info.getUseUrlAsId());
        Intrinsics.checkNotNullExpressionValue(options, "options");
        u(options);
        loadPlayOptions(options);
    }

    private final void u(RFWPlayerOptions options) {
        options.getListenerSet().addSDKInitListeners(this).addInfoListener(this).addErrorStatusListener(this).addCompletionListener(this).addPrepareListeners(this).addSecondBufferListeners(this).addLooperListeners(this).addLifeCycleListeners(null).addSeekCompletionListeners(this);
        ECVideoInfo eCVideoInfo = this.videoInfo;
        boolean z16 = false;
        if (eCVideoInfo != null && eCVideoInfo.getAdaptHeight()) {
            z16 = true;
        }
        if (z16) {
            options.getListenerSet().addVideoSizeChangedListener(this);
        }
    }

    private final void v(Function0<Unit> lazyTask) {
        if (getSuperPlayer() != null) {
            lazyTask.invoke();
        } else {
            this.lazyTaskList.add(lazyTask);
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.base.video.f
    public void a(d callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.eventCallback = callback;
    }

    @Override // com.tencent.mobileqq.qqecommerce.base.video.f
    public void b(final ECVideoInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.videoInfo = info;
        MessageMicro<?> g16 = info.g();
        final FeedCloudMeta$StFeed feedCloudMeta$StFeed = g16 instanceof FeedCloudMeta$StFeed ? (FeedCloudMeta$StFeed) g16 : null;
        this.mediaTaskRunner.b(this.isSyncTask, new QFSVideoTaskRunner.QFSVideoTask() { // from class: com.tencent.mobileqq.qqecommerce.base.video.ECQFSVideoView$open$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super("ktv-open");
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(ECVideoInfo.this.getVid())) {
                    setIsTVK(true);
                    this.t(ECVideoInfo.this);
                    return;
                }
                setIsTVK(false);
                FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = feedCloudMeta$StFeed;
                if (feedCloudMeta$StFeed2 != null) {
                    this.r(ECVideoInfo.this, feedCloudMeta$StFeed2);
                } else {
                    this.s(ECVideoInfo.this);
                }
            }
        });
        n(info, feedCloudMeta$StFeed);
    }

    @Override // com.tencent.mobileqq.qqecommerce.base.video.f
    public long getCurrentPositionMs() {
        return H0();
    }

    @Override // com.tencent.mobileqq.qqecommerce.base.video.f
    public long getDurationMs() {
        RFWPlayer qCirclePlayer = getQCirclePlayer();
        if (qCirclePlayer != null) {
            return qCirclePlayer.getDurationMs();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqecommerce.base.video.f
    public long getFileSizeBytes() {
        ISuperPlayer superPlayer = getSuperPlayer();
        if (superPlayer != null) {
            return superPlayer.getFileSizeBytes();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqecommerce.base.video.f
    public int getState() {
        ISuperPlayer superPlayer = getSuperPlayer();
        if (superPlayer != null) {
            return superPlayer.getCurrentPlayerState();
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.qqecommerce.base.video.f
    public View getView() {
        return this.qfsVideoView;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerCompletionListener
    public void onCompletion(ISuperPlayer iSuperPlayer) {
        d dVar = this.eventCallback;
        if (dVar != null) {
            dVar.onComplete();
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
    public void onFirstFrameRendered(RFWPlayer player) {
        setOutPutMute(this.mute);
        d dVar = this.eventCallback;
        if (dVar != null) {
            dVar.onInfo(105, 0L, 0L, null);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerOnInfoListener
    public void onInfo(int what, long arg1, long arg2, Object extra) {
        d dVar = this.eventCallback;
        if (dVar != null) {
            dVar.onInfo(what, arg1, arg2, extra);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener
    public void onInitSuccess(RFWPlayer player) {
        Iterator<Function0<Unit>> it = this.lazyTaskList.iterator();
        while (it.hasNext()) {
            it.next().invoke();
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSecondBufferListener
    public void onSecondBufferEnd() {
        d dVar = this.eventCallback;
        if (dVar != null) {
            dVar.onInfo(113, 0L, 0L, null);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSecondBufferListener
    public void onSecondBufferStart() {
        d dVar = this.eventCallback;
        if (dVar != null) {
            dVar.onInfo(112, 0L, 0L, null);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWSeekCompletionListener
    public void onSeekCompletion(ISuperPlayer iSuperPlayer) {
        d dVar = this.eventCallback;
        if (dVar != null) {
            dVar.onSeekComplete();
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener
    public void onVideoLoopEnd() {
        d dVar = this.eventCallback;
        if (dVar != null) {
            dVar.onInfo(108, 0L, 0L, null);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener
    public void onVideoLoopStart() {
        d dVar = this.eventCallback;
        if (dVar != null) {
            dVar.onInfo(107, 0L, 0L, null);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener
    public void onVideoPlayError(int module, int errorType, int errorCode, String extraInfo) {
        d dVar = this.eventCallback;
        if (dVar != null) {
            dVar.onError(module, errorType, errorCode, extraInfo);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
    public void onVideoPrepared(RFWPlayer player) {
        d dVar = this.eventCallback;
        if (dVar != null) {
            dVar.onPrepared();
        }
        Iterator<Function0<Unit>> it = this.lazyTaskList.iterator();
        while (it.hasNext()) {
            it.next().invoke();
        }
        post(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.base.video.b
            @Override // java.lang.Runnable
            public final void run() {
                ECQFSVideoView.p(ECQFSVideoView.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqecommerce.base.video.f
    public void pause() {
        VideoReport.unbindVideoPlayerInfo(this.qfsVideoView);
        this.mediaTaskRunner.b(this.isSyncTask, new QFSVideoTaskRunner.QFSVideoTask() { // from class: com.tencent.mobileqq.qqecommerce.base.video.ECQFSVideoView$pause$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super("ktv-pause");
            }

            @Override // java.lang.Runnable
            public void run() {
                pause();
            }
        });
    }

    @Override // com.tencent.mobileqq.qqecommerce.base.video.f
    public void release() {
        this.mediaTaskRunner.b(this.isSyncTask, new QFSVideoTaskRunner.QFSVideoTask() { // from class: com.tencent.mobileqq.qqecommerce.base.video.ECQFSVideoView$release$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super("ktv-release");
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                z16 = ECQFSVideoView.this.isSyncTask;
                if (z16) {
                    final ECQFSVideoView eCQFSVideoView = ECQFSVideoView.this;
                    com.tencent.mobileqq.activity.qcircle.utils.g.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.base.video.ECQFSVideoView$release$1$run$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            ISuperPlayer superPlayer = getSuperPlayer();
                            if (superPlayer != null) {
                                superPlayer.reset();
                            }
                            release();
                        }
                    });
                } else {
                    ISuperPlayer superPlayer = getSuperPlayer();
                    if (superPlayer != null) {
                        superPlayer.reset();
                    }
                    release();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.qqecommerce.base.video.f
    public void seek(long pos, int mode) {
        seek(pos);
    }

    @Override // com.tencent.mobileqq.qqecommerce.base.video.f
    public void setLoop(final boolean loop) {
        v(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.base.video.ECQFSVideoView$setLoop$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                setLoopBack(loop);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqecommerce.base.video.f
    public void setMute(boolean mute) {
        this.mute = mute;
        setOutPutMute(mute);
    }

    @Override // com.tencent.mobileqq.qqecommerce.base.video.f
    public void setXYaxis(final int mode) {
        v(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.base.video.ECQFSVideoView$setXYaxis$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ISuperPlayer superPlayer = getSuperPlayer();
                if (superPlayer != null) {
                    superPlayer.setXYaxis(mode);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.qqecommerce.base.video.f
    public void start() {
        this.mediaTaskRunner.b(this.isSyncTask, new QFSVideoTaskRunner.QFSVideoTask() { // from class: com.tencent.mobileqq.qqecommerce.base.video.ECQFSVideoView$start$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super("ktv-start");
            }

            @Override // java.lang.Runnable
            public void run() {
                ECVideoInfo eCVideoInfo;
                ECVideoInfo eCVideoInfo2;
                ECVideoInfo eCVideoInfo3;
                eCVideoInfo = ECQFSVideoView.this.videoInfo;
                MessageMicro<?> g16 = eCVideoInfo != null ? eCVideoInfo.g() : null;
                FeedCloudMeta$StFeed feedCloudMeta$StFeed = g16 instanceof FeedCloudMeta$StFeed ? (FeedCloudMeta$StFeed) g16 : null;
                eCVideoInfo2 = ECQFSVideoView.this.videoInfo;
                if (eCVideoInfo2 != null) {
                    ECQFSVideoView eCQFSVideoView = ECQFSVideoView.this;
                    eCVideoInfo3 = eCQFSVideoView.videoInfo;
                    Intrinsics.checkNotNull(eCVideoInfo3);
                    eCQFSVideoView.n(eCVideoInfo3, feedCloudMeta$StFeed);
                }
                start();
                final ECQFSVideoView eCQFSVideoView2 = ECQFSVideoView.this;
                com.tencent.mobileqq.activity.qcircle.utils.g.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.base.video.ECQFSVideoView$start$1$run$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        boolean z16;
                        ECQFSVideoView$qfsVideoView$1 eCQFSVideoView$qfsVideoView$1 = ECQFSVideoView.this.qfsVideoView;
                        z16 = ECQFSVideoView.this.mute;
                        eCQFSVideoView$qfsVideoView$1.setOutPutMute(z16);
                    }
                });
            }
        });
    }

    @Override // com.tencent.mobileqq.qqecommerce.base.video.f
    public void stop() {
        this.mediaTaskRunner.b(this.isSyncTask, new QFSVideoTaskRunner.QFSVideoTask() { // from class: com.tencent.mobileqq.qqecommerce.base.video.ECQFSVideoView$stop$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super("ktv-stop");
            }

            @Override // java.lang.Runnable
            public void run() {
                stop();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(ECVideoInfo info) {
        RFWPlayerOptions options = RFWPlayerOptions.obtain(137).setFromType(8).setIsMutualExclusion(false).setTVKPlayerOption(RFWTVKPlayerOptions.obtain().setVid(info.getVid()).setTVKPlayerType(2)).setEnableDirectIP(false);
        Intrinsics.checkNotNullExpressionValue(options, "options");
        u(options);
        loadPlayOptions(options);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWVideoSizeChangedListener
    public void onVideoSizeChanged(ISuperPlayer iSuperPlayer, final int width, final int height) {
        if (width == 0 || height == 0) {
            return;
        }
        getView().post(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.base.video.a
            @Override // java.lang.Runnable
            public final void run() {
                ECQFSVideoView.q(ECQFSVideoView.this, width, height);
            }
        });
    }
}
