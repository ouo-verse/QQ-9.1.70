package com.tencent.biz.qqcircle.immersive.feed;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.tencent.avbiz.Constants;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedVideoControlEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedVideoCurrentTimeEvent;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QCircleVideoRateEvent;
import com.tencent.biz.qqcircle.events.QFSVideoControlEvent;
import com.tencent.biz.qqcircle.events.QFSVideoOnPlayEvent;
import com.tencent.biz.qqcircle.events.QFSVideoPlayEndEvent;
import com.tencent.biz.qqcircle.helpers.QFSWeakNetworkOptHelper;
import com.tencent.biz.qqcircle.immersive.events.QFSFloatEndCaptureEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSFoldFullScreenChangeEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSSeekEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSVideoLoopStartEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildVideoPresenter;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFloatVolumeSwitchEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSIdentityAuthenticationShowEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSPRatePlayGuideEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSQzoneFirstVideoAutoSlideEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSStartVideoEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSVideoFeedPlayEvent;
import com.tencent.biz.qqcircle.immersive.model.bottombarrage.QFSFakeBarrageEvent;
import com.tencent.biz.qqcircle.immersive.model.bottombarrage.QFSVideoPauseEvent;
import com.tencent.biz.qqcircle.immersive.part.QFSMainMultiTabFragmentPart;
import com.tencent.biz.qqcircle.immersive.personal.utils.QFSRecentlyWatchedRecorder;
import com.tencent.biz.qqcircle.immersive.views.QFSSeekBar;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.launcher.parser.QCircleContentDetailSchemeParser;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.event.RFWMediaFocusChangeEvent;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerUpperData;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerCompletionListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerOnInfoListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSprListener;
import com.tencent.biz.richframework.video.rfw.player.monitor.RFWPlayerMonitor;
import com.tencent.biz.richframework.video.rfw.player.spr.RFWSprManger;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountTechReporter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.event.QCircleFrameEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleSeekAreaEvent;
import com.tencent.mobileqq.qcircle.api.event.QFSApertureExposeFeedEvent;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.richframework.gallery.video.RFWLayerVideoPlayPosRecorder;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.player.MediaInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.widget.media.QUIPlayIconView;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.QFS5507ReportHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qqcircle.utils.QFSMainProcessWebView;
import e40.QFSVideoComposeSourceInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudMeta$StVideo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import k30.e;
import org.json.JSONArray;
import org.json.JSONObject;
import tianshu.QQCircleTianShu$AdItem;

/* loaded from: classes4.dex */
public class QFSFeedChildVideoPresenter extends com.tencent.biz.qqcircle.immersive.feed.d<FeedCloudMeta$StFeed> implements QFSVideoView.c {

    /* renamed from: y0, reason: collision with root package name */
    private static boolean f85204y0;
    private QFSSeekBar N;
    private View P;
    private LinearLayout Q;
    private LinearLayout R;
    private TextView S;
    private TextView T;
    private QUIPlayIconView U;
    private View V;
    private ImageView W;
    private int X;
    private int Y;

    /* renamed from: a0, reason: collision with root package name */
    private int f85205a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f85206b0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f85208d0;

    /* renamed from: e0, reason: collision with root package name */
    private FeedCloudMeta$StFeed f85209e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f85210f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f85211g0;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f85213i0;

    /* renamed from: j0, reason: collision with root package name */
    private QFSVideoFeedPlayEvent f85214j0;

    /* renamed from: k0, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.feed.event.ag f85215k0;

    /* renamed from: l0, reason: collision with root package name */
    private t40.c f85216l0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f85218n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f85219o0;

    /* renamed from: p0, reason: collision with root package name */
    private Runnable f85220p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f85221q0;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f85223s0;

    /* renamed from: t0, reason: collision with root package name */
    private t40.d f85224t0;

    /* renamed from: u0, reason: collision with root package name */
    private t40.b f85225u0;

    /* renamed from: v0, reason: collision with root package name */
    private i f85226v0;
    private com.tencent.biz.qqcircle.immersive.feed.event.al Z = null;

    /* renamed from: c0, reason: collision with root package name */
    private ConcurrentHashMap<String, Long> f85207c0 = new ConcurrentHashMap<>();

    /* renamed from: h0, reason: collision with root package name */
    private long f85212h0 = 0;

    /* renamed from: m0, reason: collision with root package name */
    private final com.tencent.biz.qqcircle.immersive.utils.x f85217m0 = new com.tencent.biz.qqcircle.immersive.utils.x();

    /* renamed from: r0, reason: collision with root package name */
    private String f85222r0 = "";

    /* renamed from: w0, reason: collision with root package name */
    private Runnable f85227w0 = null;

    /* renamed from: x0, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.feed.event.an f85228x0 = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements IRFWPlayerLifeCycle {
        a() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
        public /* synthetic */ void onDeInit(RFWPlayer rFWPlayer) {
            re0.a.a(this, rFWPlayer);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
        public /* synthetic */ void onPause(RFWPlayer rFWPlayer) {
            re0.a.b(this, rFWPlayer);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
        public /* synthetic */ void onRelease(RFWPlayer rFWPlayer) {
            re0.a.c(this, rFWPlayer);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
        public void onStart(RFWPlayer rFWPlayer) {
            QFSFeedChildVideoPresenter.this.v2(rFWPlayer);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
        public /* synthetic */ void onStop(RFWPlayer rFWPlayer) {
            re0.a.e(this, rFWPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements IRFWPlayerSprListener {
        b() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSprListener
        public void onOriginFrameBack(Bitmap bitmap) {
            com.tencent.biz.qqcircle.immersive.feed.event.u uVar = new com.tencent.biz.qqcircle.immersive.feed.event.u(2);
            uVar.e(bitmap);
            QFSFeedChildVideoPresenter.this.T0(uVar);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSprListener
        public void onSprEnable(boolean z16) {
            com.tencent.biz.qqcircle.immersive.feed.event.u uVar = new com.tencent.biz.qqcircle.immersive.feed.event.u(1);
            uVar.d(z16);
            QFSFeedChildVideoPresenter.this.T0(uVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c extends RFWPlayerIOC {
        c() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QCircleReportBean getReportBean() {
            return QFSFeedChildVideoPresenter.this.getReportBean();
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        public RFWPlayerReportInfo<e30.b> getBusinessReportInfo() {
            QFSFeedChildVideoPresenter qFSFeedChildVideoPresenter = QFSFeedChildVideoPresenter.this;
            return gb0.b.m(qFSFeedChildVideoPresenter.E.o("KEY_RFW_VIDEO_FEED_POI", Integer.valueOf(qFSFeedChildVideoPresenter.f85018i)));
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        /* renamed from: getPlayerUpperData */
        public RFWPlayerUpperData getUpperData() {
            long j3;
            Context context;
            RFWPlayerUpperData addValue = new RFWPlayerUpperData().setDtCustomPgId(QFSFeedChildVideoPresenter.this.q0()).setMayNeedSpr(true).addValue("KEY_NEED_SRP", Boolean.TRUE);
            if (QCirclePluginUtil.getQCircleInitBean(QFSFeedChildVideoPresenter.this.m0()) != null) {
                j3 = QCirclePluginUtil.getQCircleInitBean(QFSFeedChildVideoPresenter.this.m0()).getEnterTime();
            } else {
                j3 = 0;
            }
            RFWPlayerUpperData addValue2 = addValue.addValue("KEY_PAGE_START_TIME_MS", Long.valueOf(j3));
            QFSVideoView qFSVideoView = QFSFeedChildVideoPresenter.this.I;
            if (qFSVideoView != null) {
                context = qFSVideoView.getContext();
            } else {
                context = null;
            }
            return addValue2.setContext(context);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        public boolean isValid() {
            if (QFSFeedChildVideoPresenter.this.J0() && QFSFeedChildVideoPresenter.this.I != null) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements IRFWPlayerSdkInitListener {
        d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener
        public void onInitSuccess(RFWPlayer rFWPlayer) {
            QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_VIDEO_SDK_SUCCEED);
            QFSFeedChildVideoPresenter.this.Q3(QCircleFolderFunnelCollect.PERIOD_VIDEO_SDK_SUCCEED);
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_use_loop_end_auto_scroll", true)) {
                QFSFeedChildVideoPresenter.this.I.setLoopBack(true);
            } else {
                QFSFeedChildVideoPresenter qFSFeedChildVideoPresenter = QFSFeedChildVideoPresenter.this;
                qFSFeedChildVideoPresenter.I.setLoopBack(qFSFeedChildVideoPresenter.f85211g0);
            }
            QFSFeedChildVideoPresenter qFSFeedChildVideoPresenter2 = QFSFeedChildVideoPresenter.this;
            T t16 = qFSFeedChildVideoPresenter2.f85017h;
            if (t16 != 0) {
                qFSFeedChildVideoPresenter2.I.setPlayRate(QCirclePluginGlobalInfo.t(((FeedCloudMeta$StFeed) t16).f398449id.get()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements IRFWPlayerPrepareListener {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            QFSFeedChildVideoPresenter.this.r2(true);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onFirstFrameRendered(RFWPlayer rFWPlayer) {
            String str;
            if (rFWPlayer != null && rFWPlayer.getRFWPlayerOptions() != null && rFWPlayer.getRFWPlayerOptions().getStartOffset() == 0) {
                QFSFeedChildVideoPresenter.this.r2(true);
            } else {
                QLog.d("QFSFeedChildVideoPresenter", 1, "[onFirstFrameRendered] post delay hide coverImg");
                QFSFeedChildVideoPresenter.this.x0().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ca
                    @Override // java.lang.Runnable
                    public final void run() {
                        QFSFeedChildVideoPresenter.e.this.b();
                    }
                }, 32L);
            }
            QFSFeedChildVideoPresenter.this.y2();
            QFSFeedChildVideoPresenter.this.a4(true);
            QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_FIRST_RENDER);
            QFSFeedChildVideoPresenter.this.Q3(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_FIRST_RENDER);
            RFWPlayerMonitor.g().cancelFirstFrameRenderedColorLog();
            QFSFeedChildVideoPresenter.this.l1(rFWPlayer);
            t40.f j16 = QFSFeedChildVideoPresenter.this.j1();
            if (j16 != null) {
                j16.Y7(rFWPlayer);
            }
            QFSFeedChildVideoPresenter.this.u1();
            if (rFWPlayer != null && rFWPlayer.getRFWPlayerOptions() != null) {
                str = rFWPlayer.getRFWPlayerOptions().getFileId();
            } else {
                str = "";
            }
            com.tencent.biz.qqcircle.immersive.manager.j.h().j(QFSFeedChildVideoPresenter.this.y0(), QFSFeedChildVideoPresenter.this.f85210f0, str, (FeedCloudMeta$StFeed) QFSFeedChildVideoPresenter.this.n0());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onVideoPrepared(RFWPlayer rFWPlayer) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed;
            QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_PREPARED);
            QFSFeedChildVideoPresenter.this.Q3(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_PREPARED);
            if (QFSFeedChildVideoPresenter.this.w3() && (feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) QFSFeedChildVideoPresenter.this.f85017h) != null) {
                ((IQCirclePublicAccountTechReporter) QRoute.api(IQCirclePublicAccountTechReporter.class)).onVideoPlayerPrepared(feedCloudMeta$StFeed.f398449id.get(), QFSFeedChildVideoPresenter.this.I.isHitVideoCache());
            }
            t40.f j16 = QFSFeedChildVideoPresenter.this.j1();
            if (j16 != null) {
                j16.onVideoPrepared(rFWPlayer);
            }
            QFSFeedChildVideoPresenter.this.G2(rFWPlayer.getRealPlayer());
            QFSFeedChildVideoPresenter.this.u2(rFWPlayer.getRealPlayer());
            com.tencent.biz.qqcircle.immersive.report.b.f().o(com.tencent.biz.qqcircle.utils.bj.h((FeedCloudMeta$StFeed) QFSFeedChildVideoPresenter.this.f85017h));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class f implements IRFWPlayerSeekListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f85235d;

        f(String str) {
            this.f85235d = str;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onProgress(String str, int i3, int i16) {
            QFSFeedChildVideoPresenter.this.A2(i3, i16, this.f85235d);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onSeekBarProgressChanged(SeekBar seekBar, int i3, boolean z16) {
            QFSFeedChildVideoPresenter.this.B2(seekBar, i3, z16);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            int progress;
            QFSFeedChildVideoPresenter.this.C2(seekBar);
            int i3 = RFWLog.USR;
            Object[] objArr = new Object[1];
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[onStartTrackingTouch] seek progress: ");
            if (seekBar == null) {
                progress = 0;
            } else {
                progress = seekBar.getProgress();
            }
            sb5.append(progress);
            objArr[0] = sb5.toString();
            RFWLog.d("QFSFeedChildVideoPresenter", i3, objArr);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            int progress;
            int i3 = RFWLog.USR;
            Object[] objArr = new Object[1];
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[onStopTrackingTouch] seek progress: ");
            if (seekBar == null) {
                progress = 0;
            } else {
                progress = seekBar.getProgress();
            }
            sb5.append(progress);
            objArr[0] = sb5.toString();
            RFWLog.d("QFSFeedChildVideoPresenter", i3, objArr);
            QFSFeedChildVideoPresenter qFSFeedChildVideoPresenter = QFSFeedChildVideoPresenter.this;
            qFSFeedChildVideoPresenter.S3(2, 4, qFSFeedChildVideoPresenter.r(), "", "");
            QFSFeedChildVideoPresenter.this.D2(seekBar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class g implements IRFWPlayerCompletionListener {
        g() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerCompletionListener
        public void onCompletion(ISuperPlayer iSuperPlayer) {
            RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.CLR, "[onCompletion] current is auto scroll: ", Boolean.valueOf(QFSFeedChildVideoPresenter.this.d4()));
            if (QFSFeedChildVideoPresenter.this.d4() && !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_use_loop_end_auto_scroll", true)) {
                QFSFeedChildVideoPresenter.this.S0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class h implements IRFWPlayerLooperListener {
        h() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener
        public void onVideoLoopEnd() {
            QFSFeedChildVideoPresenter qFSFeedChildVideoPresenter = QFSFeedChildVideoPresenter.this;
            if (qFSFeedChildVideoPresenter.f85017h != 0 && qFSFeedChildVideoPresenter.x3()) {
                SimpleEventBus.getInstance().dispatchEvent(new QFSVideoPlayEndEvent(((FeedCloudMeta$StFeed) QFSFeedChildVideoPresenter.this.f85017h).f398449id.get(), QFSFeedChildVideoPresenter.this.f85018i));
            }
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_use_loop_end_auto_scroll", true) && QFSFeedChildVideoPresenter.this.d4()) {
                QFSFeedChildVideoPresenter.this.h4();
                return;
            }
            QFSFeedChildVideoPresenter.this.f85206b0++;
            QFSFeedChildVideoPresenter.this.E2();
            QFSFeedChildVideoPresenter.this.c3();
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener
        public void onVideoLoopStart() {
            if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_use_loop_end_auto_scroll", true) || !QFSFeedChildVideoPresenter.this.d4()) {
                QFSFeedChildVideoPresenter.this.F2();
                QLog.d(QFSFeedChildVideoPresenter.this.getTAG(), 1, "loop back start");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class i extends QCirclePicStateListener {

        /* renamed from: d, reason: collision with root package name */
        private boolean f85239d;

        /* renamed from: e, reason: collision with root package name */
        private final WeakReference<QFSFeedChildVideoPresenter> f85240e;

        public i(QFSFeedChildVideoPresenter qFSFeedChildVideoPresenter, boolean z16) {
            this.f85239d = z16;
            this.f85240e = new WeakReference<>(qFSFeedChildVideoPresenter);
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            super.onStateChange(loadState, option);
            if (loadState.isFinishSuccess() && this.f85239d) {
                ((IQCirclePublicAccountTechReporter) QRoute.api(IQCirclePublicAccountTechReporter.class)).onCoverExposure();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A2(int i3, int i16, String str) {
        String playOptionUrl;
        if (i16 == this.X && this.Y == i3) {
            return;
        }
        long j3 = i16;
        p40.u.H().C0(this.f85209e0, j3);
        String W2 = W2();
        if (!TextUtils.isEmpty(W2)) {
            RFWLayerVideoPlayPosRecorder.INSTANCE.updatePlayPosition(W2, this.X);
        }
        l4(str, j3);
        this.X = i16;
        this.Y = i3;
        if (this.f85228x0 == null) {
            this.f85228x0 = new com.tencent.biz.qqcircle.immersive.feed.event.an();
        }
        this.f85228x0.h(i3);
        this.f85228x0.j(i16);
        this.f85228x0.i(this.f85206b0);
        com.tencent.biz.qqcircle.immersive.feed.event.an anVar = this.f85228x0;
        QFSVideoView qFSVideoView = this.I;
        if (qFSVideoView == null) {
            playOptionUrl = "";
        } else {
            playOptionUrl = qFSVideoView.getPlayOptionUrl();
        }
        anVar.g(playOptionUrl);
        T0(this.f85228x0);
        if (this.f85218n0) {
            Y3(i3, i16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean A3() {
        T t16;
        if (this.f85209e0 != null && (t16 = this.f85017h) != 0 && this.f85210f0 == this.f85018i) {
            try {
                if (((FeedCloudMeta$StFeed) t16).f398449id.get().equals(this.f85209e0.f398449id.get()) && ((FeedCloudMeta$StFeed) this.f85017h).video.playUrl.get().equals(this.f85209e0.video.playUrl.get())) {
                    RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "fs_lifecycle , same video, playUrl = " + this.f85209e0.video.playUrl.get());
                    return true;
                }
            } catch (Exception e16) {
                RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "same video, exception = " + e16.getMessage());
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B2(SeekBar seekBar, int i3, boolean z16) {
        String str;
        TextView textView = this.T;
        if (textView != null && z16) {
            textView.setText(com.tencent.biz.qqcircle.utils.cv.c(i3));
        }
        if (this.f85215k0 == null) {
            this.f85215k0 = new com.tencent.biz.qqcircle.immersive.feed.event.ag();
        }
        this.f85215k0.d(i3);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f85209e0;
        if (feedCloudMeta$StFeed == null) {
            str = "";
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        this.f85215k0.c(str);
        T0(this.f85215k0);
    }

    private void B3(List<QFSVideoComposeSourceInfo> list) {
        if (this.I != null && list.size() != 0) {
            try {
                long H0 = this.I.H0();
                for (QFSVideoComposeSourceInfo qFSVideoComposeSourceInfo : list) {
                    if (qFSVideoComposeSourceInfo.getEndTimeMs() > H0) {
                        FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
                        FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
                        feedCloudMeta$StUser.f398463id.set(qFSVideoComposeSourceInfo.getPosterId());
                        feedCloudMeta$StFeed.poster.set(feedCloudMeta$StUser);
                        feedCloudMeta$StFeed.f398449id.set(qFSVideoComposeSourceInfo.getFeedId());
                        feedCloudMeta$StFeed.createTime.set(qFSVideoComposeSourceInfo.getCreateTime());
                        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
                        qCircleLayerBean.setGetFeedList(false);
                        qCircleLayerBean.setFeed(feedCloudMeta$StFeed);
                        com.tencent.biz.qqcircle.launcher.c.u(this.W.getContext(), qCircleLayerBean);
                        return;
                    }
                }
            } catch (Exception e16) {
                RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "jumpToFeedLayer, exception = " + e16.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void C2(SeekBar seekBar) {
        String str;
        if (this.R != null && this.V != null && seekBar != null) {
            K2();
            this.f85208d0 = true;
            this.R.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.V.getLayoutParams();
            layoutParams.height = com.tencent.biz.qqcircle.utils.cx.a(2.0f);
            this.V.setLayoutParams(layoutParams);
            T t16 = this.f85017h;
            if (t16 == 0) {
                str = "";
            } else {
                str = ((FeedCloudMeta$StFeed) t16).f398449id.get();
            }
            QFSSeekEvent qFSSeekEvent = new QFSSeekEvent(str, true);
            qFSSeekEvent.setStopTrackingTouchProgress(seekBar.getProgress());
            SimpleEventBus.getInstance().dispatchEvent(qFSSeekEvent);
            return;
        }
        RFWLog.e("QFSFeedChildVideoPresenter", RFWLog.USR, "[doOnStartSeekBarTrackingTouch] seek view should not is null.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C3() {
        f4(true, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void D2(SeekBar seekBar) {
        String str;
        if (this.R != null && this.V != null && seekBar != null) {
            if (this.I.getSuperPlayer().isPausing()) {
                n();
                this.N.X();
            }
            this.f85208d0 = false;
            this.R.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.V.getLayoutParams();
            layoutParams.height = com.tencent.biz.qqcircle.utils.cx.a(1.0f);
            this.V.setLayoutParams(layoutParams);
            T t16 = this.f85017h;
            if (t16 == 0) {
                str = "";
            } else {
                str = ((FeedCloudMeta$StFeed) t16).f398449id.get();
            }
            QFSSeekEvent qFSSeekEvent = new QFSSeekEvent(str, false);
            qFSSeekEvent.setStopTrackingTouchProgress(seekBar.getProgress());
            SimpleEventBus.getInstance().dispatchEvent(qFSSeekEvent);
            return;
        }
        RFWLog.e("QFSFeedChildVideoPresenter", RFWLog.USR, "[doOnStopSeekBarTrackingTouch] seek view should not is null.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D3(RFWPlayerOptions rFWPlayerOptions, int i3, int i16, int i17, String str, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        T0(new com.tencent.biz.qqcircle.immersive.feed.event.s(rFWPlayerOptions, i3, i16, i17, str, feedCloudMeta$StFeed));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E2() {
        if (this.Z == null) {
            this.Z = new com.tencent.biz.qqcircle.immersive.feed.event.al();
        }
        T0(this.Z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void E3(final RFWPlayerOptions rFWPlayerOptions, final FeedCloudMeta$StFeed feedCloudMeta$StFeed, final int i3, final int i16, final int i17, final String str) {
        u1();
        t40.f j16 = j1();
        if (j16 != null) {
            j16.onVideoPlayError(i17);
        }
        if (rFWPlayerOptions.isPlayerByDirectIP()) {
            QLog.d("QFSFeedChildVideoPresenter", 1, "error play by ip return");
            return;
        }
        String a16 = this.f85217m0.a(rFWPlayerOptions, i17);
        if (!TextUtils.isEmpty(a16)) {
            QLog.d("QFSFeedChildVideoPresenter", 1, "[addErrorListener] check error replay, flow return.");
            T t16 = this.f85017h;
            if (t16 != 0 && ((FeedCloudMeta$StFeed) t16).video != null && ((FeedCloudMeta$StFeed) t16).video.playUrl != null) {
                ((FeedCloudMeta$StFeed) t16).video.playUrl.set(a16);
            }
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.bx
                @Override // java.lang.Runnable
                public final void run() {
                    QFSFeedChildVideoPresenter.this.C3();
                }
            });
            return;
        }
        com.tencent.biz.qqcircle.immersive.report.b.f().p(rFWPlayerOptions.getFileId(), i3, i16, i17, str);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.bz
            @Override // java.lang.Runnable
            public final void run() {
                QFSFeedChildVideoPresenter.this.D3(rFWPlayerOptions, i3, i16, i17, str, feedCloudMeta$StFeed);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F2() {
        int tabType;
        if (this.f85216l0 == null) {
            this.f85216l0 = (t40.c) u0(t40.c.class);
        }
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        t40.c cVar = this.f85216l0;
        if (cVar == null) {
            tabType = 0;
        } else {
            tabType = cVar.getTabType();
        }
        simpleEventBus.dispatchEvent(new QFSVideoLoopStartEvent(tabType));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void F3(RFWPlayerOptions rFWPlayerOptions, int i3, long j3, long j16, Object obj) {
        com.tencent.biz.qqcircle.immersive.report.b.f().q(rFWPlayerOptions.getFileId(), i3, j3, j16, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void G2(final ISuperPlayer iSuperPlayer) {
        RFWPlayer qCirclePlayer;
        ISPlayerVideoView iSPlayerVideoView;
        MediaInfo mediaInfo;
        if (this.I != null && this.f85017h != 0 && iSuperPlayer != null && J0() && (qCirclePlayer = this.I.getQCirclePlayer()) != null && (iSPlayerVideoView = (ISPlayerVideoView) qCirclePlayer.getVideoView()) != null && ((FeedCloudMeta$StFeed) this.f85017h).video != null) {
            if (M2() && (mediaInfo = iSuperPlayer.getMediaInfo()) != null && mediaInfo.getVideoWidth() != 0 && mediaInfo.getVideoHeight() != 0) {
                ((FeedCloudMeta$StFeed) this.f85017h).video.width.set(mediaInfo.getVideoWidth());
                ((FeedCloudMeta$StFeed) this.f85017h).video.height.set(mediaInfo.getVideoHeight());
            }
            iSPlayerVideoView.setFixedSize(((FeedCloudMeta$StFeed) this.f85017h).video.width.get(), ((FeedCloudMeta$StFeed) this.f85017h).video.height.get());
            if (!TransitionHelper.shouldVideoYFullScreen(((FeedCloudMeta$StFeed) this.f85017h).video.width.get(), ((FeedCloudMeta$StFeed) this.f85017h).video.height.get()) && (!TransitionHelper.isFolderScreenOpenMode(this.J.getContext()) || I0())) {
                iSPlayerVideoView.setXYaxis(2);
            } else {
                iSPlayerVideoView.setXYaxis(0);
            }
            J2();
            QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_START_PLAY);
            Q3(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_START_PLAY);
            this.I.start();
            com.tencent.biz.qqcircle.immersive.feed.event.ap apVar = new com.tencent.biz.qqcircle.immersive.feed.event.ap(false);
            apVar.e(true);
            apVar.d(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
            T0(apVar);
            SimpleEventBus.getInstance().dispatchEvent(new QFSFloatVolumeSwitchEvent(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get(), iSuperPlayer.isOutputMute()));
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildVideoPresenter.10
                @Override // java.lang.Runnable
                public void run() {
                    if (QFSFeedChildVideoPresenter.this.S != null) {
                        QFSFeedChildVideoPresenter.this.S.setText(" / " + com.tencent.biz.qqcircle.utils.cv.c((int) iSuperPlayer.getDurationMs()));
                    }
                    if (QFSFeedChildVideoPresenter.this.N != null) {
                        QFSFeedChildVideoPresenter.this.N.X();
                    }
                    QFSFeedChildVideoPresenter qFSFeedChildVideoPresenter = QFSFeedChildVideoPresenter.this;
                    qFSFeedChildVideoPresenter.W(qFSFeedChildVideoPresenter.I, qFSFeedChildVideoPresenter.J);
                    QFSFeedChildVideoPresenter qFSFeedChildVideoPresenter2 = QFSFeedChildVideoPresenter.this;
                    qFSFeedChildVideoPresenter2.O0(qFSFeedChildVideoPresenter2.I, qFSFeedChildVideoPresenter2.J);
                    QFSFeedChildVideoPresenter.this.f85221q0 = false;
                }
            });
            this.f85205a0 = (int) iSuperPlayer.getDurationMs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void G3(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        N3(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
        EventCollector.getInstance().onViewClicked(view);
    }

    private void H2(QCircleFeedVideoControlEvent qCircleFeedVideoControlEvent) {
        if (!qCircleFeedVideoControlEvent.isPlay()) {
            return;
        }
        N2(false, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H3() {
        if (y3()) {
            return;
        }
        int i3 = this.f85018i + 1;
        RecyclerView recyclerView = (RecyclerView) this.C.getParent();
        QLog.d("QFSFeedChildVideoPresenter", 1, "[scrollToNextItem] nextPos: " + i3 + " | prePos: " + this.f85018i);
        if (recyclerView.getAdapter().getNUM_BACKGOURND_ICON() - 1 >= i3) {
            recyclerView.smoothScrollToPosition(i3);
            com.tencent.biz.qqcircle.immersive.utils.u.c(recyclerView);
            P0();
            return;
        }
        f4(false, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void I2(boolean z16, boolean z17) {
        int i3;
        VideoReport.unbindVideoPlayerInfo(this.I);
        this.I.pause();
        com.tencent.biz.qqcircle.immersive.feed.event.ap apVar = new com.tencent.biz.qqcircle.immersive.feed.event.ap(true);
        apVar.d(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
        T0(apVar);
        int i16 = 0;
        if (!z16) {
            this.U.setVisibility(0);
            QLog.d("QFSFeedChildVideoPresenter", 1, "[doRealPause] current show panel player recover, not show play icon.");
        } else {
            QUIPlayIconView qUIPlayIconView = this.U;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            qUIPlayIconView.setVisibility(i3);
        }
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        String str = ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get();
        long j3 = this.X;
        if (m0() != null) {
            i16 = m0().hashCode();
        }
        simpleEventBus.dispatchEvent(new QFSVideoPauseEvent(str, true, j3, i16).setClick(z17));
        x2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I3(ArrayList arrayList, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        B3(arrayList);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void J2() {
        if (this.I != null && this.f85017h != 0) {
            Map<String, ?> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(ua0.c.d(this.E));
            buildElementParams.putAll(ua0.c.e((FeedCloudMeta$StFeed) this.f85017h));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.f85018i + 1));
            buildElementParams.put("xsj_custom_pgid", r0());
            buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REC_SLOT_EXP_FEED_LIST, com.tencent.biz.qqcircle.immersive.utils.r.v(this.E));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_REC_SLOT_VIDEO, Integer.valueOf(com.tencent.biz.qqcircle.immersive.utils.r.A0(this.E) ? 1 : 0));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REC_SLOT_ORIGINAL_FEED_ID, this.E.e().f398449id.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REC_SLOT_TYPE, com.tencent.biz.qqcircle.immersive.utils.r.I(this.E));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_RECOM_SHOW_STYLE, Integer.valueOf(com.tencent.biz.qqcircle.immersive.utils.r.E(this.E)));
            QQCircleTianShu$AdItem L = com.tencent.biz.qqcircle.immersive.utils.r.L((FeedCloudMeta$StFeed) this.f85017h, 1050);
            if (L != null) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_MULTIMEDIA_LIKE_TIANSHU_ID, Integer.valueOf(L.iAdId.get()));
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REC_SLOT_EXP_STATUS, Integer.valueOf(com.tencent.biz.qqcircle.immersive.utils.r.C(this.E)));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_SHOW_AD, Integer.valueOf(com.tencent.biz.qqcircle.immersive.utils.ad.a.h((ViewGroup) this.C.findViewById(R.id.f40181do))));
            VideoEntity build = new VideoEntity.Builder().setContentId(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get()).setPage((Object) r0()).setContentType(2).setVideoDuration(((FeedCloudMeta$StFeed) this.f85017h).video.duration.get()).setVideoView((View) this.I).addCustomParams(buildElementParams).ignoreReport(false).bizReady(true).build();
            ISuperPlayer superPlayer = this.I.getSuperPlayer();
            if (superPlayer != null) {
                VideoReport.bindVideoPlayerInfo(superPlayer, build);
                RFWLog.i("QFSFeedChildVideoPresenter", RFWLog.DEV, "dtReportBindVideoData  pos = " + this.f85018i);
            }
            ImageView imageView = this.W;
            if (imageView != null) {
                VideoReport.setElementId(imageView, QCircleDaTongConstant.ElementId.EM_XSJ_ORIGINAL_FEED_VIEW_BUTTON);
                VideoReport.setElementReuseIdentifier(this.W, ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
                Map<String, Object> buildElementParams2 = new QCircleDTParamBuilder().buildElementParams();
                buildElementParams2.put(QCircleDaTongConstant.ElementParamKey.XSJ_PARENT_EMID, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA);
                VideoReport.setElementParams(this.W, buildElementParams2);
                VideoReport.setElementExposePolicy(this.W, ExposurePolicy.REPORT_NONE);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void J3() {
        if (this.J == null) {
            return;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) this.f85017h;
        String urlFromTransitionAnimBean = QCirclePluginUtil.getUrlFromTransitionAnimBean(m0(), (FeedCloudMeta$StFeed) this.f85017h);
        if (!TextUtils.isEmpty(urlFromTransitionAnimBean)) {
            this.K = Option.obtain().setUrl(urlFromTransitionAnimBean).setTargetView(this.J);
        } else if (com.tencent.biz.qqcircle.immersive.utils.r.h0(this.f85018i)) {
            QLog.d("QFSFeedChildVideoPresenter", 1, "isFirstEnterFromCacheInPad = true");
            this.K = Option.obtain().setUrl(com.tencent.biz.qqcircle.immersive.utils.r.h()).setTargetView(this.J);
        } else if (TextUtils.isEmpty(feedCloudMeta$StFeed.cover.layerPicUrl.get())) {
            this.K = Option.obtain().setUrl(feedCloudMeta$StFeed.cover.picUrl.get()).setTargetView(this.J);
        } else {
            this.K = Option.obtain().setUrl(feedCloudMeta$StFeed.cover.layerPicUrl.get()).setTargetView(this.J);
        }
        this.K.setSupportRecycler(true);
        ViewGroup.LayoutParams layoutParams = this.J.getLayoutParams();
        if (layoutParams != null) {
            this.K.setRequestWidth(layoutParams.width);
            this.K.setRequestHeight(layoutParams.height);
        }
        QLog.d("QFSFeedChildVideoPresenter", 1, "[bindCover] QPIE feedId:" + j() + " | traceid:" + com.tencent.biz.qqcircle.immersive.utils.ba.d(feedCloudMeta$StFeed) + " | option:" + this.K.toString());
        this.K.setLoadingDrawable(V2());
        this.K.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        if (w3()) {
            this.f85226v0 = new i(this, true);
        } else {
            this.f85226v0 = new i(this, false);
        }
        QCircleFeedPicLoader.g().loadImage(this.K, this.f85226v0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void K2() {
        String dtPageId;
        VideoReport.setElementId(this.N, "em_xsj_multimedia_progress_bar");
        VideoReport.setElementReuseIdentifier(this.N, ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PARENT_EMID, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA);
        buildElementParams.put("xsj_feed_id", ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
        if (com.tencent.biz.qqcircle.utils.ce.c(m0())) {
            dtPageId = QCircleDaTongConstant.PageId.PG_XSJ_CLEAR_SCREEN_INTERFACE_PAGE;
        } else if (getReportBean() == null) {
            dtPageId = "";
        } else {
            dtPageId = getReportBean().getDtPageId();
        }
        buildElementParams.put("xsj_custom_pgid", dtPageId);
        VideoReport.setElementParams(this.N, buildElementParams);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", this.N, buildElementParams);
    }

    private boolean K3() {
        boolean z16 = false;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_unable_qfs_gesture_detector_view", false) || QCircleDaTongConstant.PageId.PG_XSJ_QZEON_VIDEO_UGC_MID_PAG.equals(q0())) {
            z16 = true;
        }
        QLog.d(getTAG(), 1, "[notEnableGesture]:" + z16);
        return z16;
    }

    private boolean L2() {
        String str;
        boolean z16;
        if (getReportBean() != null) {
            str = getReportBean().getDtPageId();
        } else {
            str = "";
        }
        if (!"pg_xsj_friendtab_explore_page".equals(str) && !QCircleDaTongConstant.PageId.PG_XSJ_FOLLOWING_PAGE.equals(str) && !"pg_xsj_explore_page".equals(str)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return false;
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_fix_folder_ui_invisible", true);
    }

    private void L3(String str, boolean z16) {
        M3(str, z16, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean M2() {
        QCircleInitBean qCircleInitBean;
        if (s0() != null) {
            qCircleInitBean = s0().getInitBean();
        } else {
            qCircleInitBean = null;
        }
        if (qCircleInitBean == null || this.f85017h == 0 || !qCircleInitBean.enableUsePlayerSize() || !com.tencent.biz.qqcircle.immersive.utils.r.z0(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get(), qCircleInitBean.getFeedId())) {
            return false;
        }
        return true;
    }

    private void M3(String str, boolean z16, boolean z17) {
        if (z17 && !TextUtils.equals(str, j())) {
            return;
        }
        this.f85213i0 = z16;
        j4(!d4());
    }

    private void N2(boolean z16, RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (q2()) {
            return;
        }
        if (this.I.getSuperPlayer() == null) {
            RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "[executePlay] execute a new player" + hashCode());
            f4(z16, rFWFeedSelectInfo);
            return;
        }
        if (!this.I.isRelease() && !this.I.getQCirclePlayer().isDeInit()) {
            if (this.I.getSuperPlayer().isPlaying()) {
                RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "[executePlay] isPlaying when resume:" + hashCode());
                return;
            }
            if (this.I.getSuperPlayer().isPausing()) {
                V3();
                n();
                this.N.X();
                RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "[executePlay] startFromPause hashCode:" + hashCode());
                return;
            }
            if (this.I.getSuperPlayer().getCurrentPlayerState() == 4 && uq3.o.D()) {
                G2(this.I.getSuperPlayer());
                RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "[executePlay] from prepare hashCode:" + hashCode());
                return;
            }
            f4(z16, rFWFeedSelectInfo);
            return;
        }
        RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "[executePlay] execute a new player released" + hashCode());
        f4(z16, rFWFeedSelectInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void N3(String str) {
        T t16 = this.f85017h;
        if (t16 == 0) {
            QLog.d(getTAG(), 1, "[pauseOrStart] mData is null");
            return;
        }
        if (!((FeedCloudMeta$StFeed) t16).f398449id.get().equals(str)) {
            QLog.d(getTAG(), 1, "[pauseOrStart] feedId not equal, feedId:" + str + ", curFeedId:" + ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
            return;
        }
        QFSVideoView qFSVideoView = this.I;
        if (qFSVideoView != null && qFSVideoView.getSuperPlayer() != null) {
            if (this.I.getSuperPlayer().isPlaying()) {
                O3(true, true);
                this.N.T();
                p40.u.H().S0(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get(), true);
                f85204y0 = true;
                return;
            }
            if (this.I.getSuperPlayer().isPausing()) {
                n();
                this.N.X();
                p40.u.H().S0(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get(), false);
                f85204y0 = false;
                return;
            }
            return;
        }
        QLog.d(getTAG(), 1, "[pauseOrStart] playView or superPlayer is null");
    }

    private void O3(boolean z16, boolean z17) {
        QFSVideoView qFSVideoView = this.I;
        if (qFSVideoView != null && qFSVideoView.getSuperPlayer() != null) {
            if (!this.f85218n0 && this.I.getSuperPlayer().isPlaying()) {
                Y3(this.Y, this.X);
            }
            I2(z16, z17);
            RFWLog.d(getTAG(), RFWLog.USR, "pause success");
            S3(2, 6, r(), "", "");
        }
    }

    private void P2(int i3) {
        if (i3 != -1) {
            return;
        }
        T3(5);
        RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "First Video Refresh Report.");
    }

    private void P3() {
        String str;
        if (!E0() || !QFSWeakNetworkOptHelper.f84577a.a()) {
            return;
        }
        String tag = getTAG();
        int i3 = RFWLog.USR;
        boolean z16 = true;
        Object[] objArr = new Object[1];
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[postWeakNetShowRunnable] playTag:");
        QFSVideoView qFSVideoView = this.I;
        if (qFSVideoView != null) {
            str = qFSVideoView.M0();
        } else {
            str = "";
        }
        sb5.append(str);
        sb5.append(", runnable == null ? ");
        if (this.f85227w0 != null) {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append(", pos:");
        sb5.append(this.f85018i);
        sb5.append(", hashCode:");
        sb5.append(hashCode());
        objArr[0] = sb5.toString();
        RFWLog.d(tag, i3, objArr);
        if (this.f85227w0 == null) {
            this.f85227w0 = new QFSWeakNetworkOptHelper.WeakNetTipsShowRunnable(this, this.I, 5);
        }
        RFWThreadManager.getUIHandler().removeCallbacks(this.f85227w0);
        RFWThreadManager.getUIHandler().postDelayed(this.f85227w0, 5000L);
    }

    private void Q2() {
        if (p2() || !L2()) {
            return;
        }
        t40.b T2 = T2();
        if (!(T2 instanceof QFSMainMultiTabFragmentPart)) {
            return;
        }
        QFSMainMultiTabFragmentPart qFSMainMultiTabFragmentPart = (QFSMainMultiTabFragmentPart) T2;
        if (qFSMainMultiTabFragmentPart.getPartRootView() == null) {
            return;
        }
        com.tencent.biz.qqcircle.helpers.ab abVar = new com.tencent.biz.qqcircle.helpers.ab(qFSMainMultiTabFragmentPart.getPartRootView());
        abVar.f(this.I);
        abVar.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q3(String str) {
        t40.f j16 = j1();
        if (j16 != null) {
            j16.i8(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long R2(boolean z16, String str) {
        long longValue;
        long S2 = S2();
        boolean g16 = com.tencent.biz.qqcircle.immersive.manager.f.f().g(S2);
        Long l3 = 0L;
        if (g16) {
            l3 = Long.valueOf(com.tencent.biz.qqcircle.immersive.manager.f.f().d(d4(), S2(), str));
        } else if (z16) {
            l3 = this.f85207c0.get(str);
        }
        if (x3()) {
            l3 = com.tencent.biz.qqcircle.immersive.manager.f.f().e(str);
        }
        Long U2 = U2();
        if (U2 != null) {
            l3 = U2;
        }
        if (l3 == null) {
            longValue = 0;
        } else {
            longValue = l3.longValue();
        }
        if (v3()) {
            long R = p40.u.H().R((FeedCloudMeta$StFeed) this.f85017h);
            if (R > 0) {
                longValue = R;
            }
        }
        String str2 = "result: " + longValue + " | duration: " + S2 + " | isEnabled: " + g16;
        if (!TextUtils.equals(str2, this.f85222r0)) {
            QLog.d("QFSFeedChildVideoPresenter", 1, "[QPH][getCurrentHistoryPosition] " + str2 + " | playUrlKey: " + str);
            this.f85222r0 = str2;
        }
        return longValue;
    }

    private void R3() {
        String str;
        if (this.f85227w0 != null) {
            String tag = getTAG();
            int i3 = RFWLog.USR;
            Object[] objArr = new Object[1];
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[removeWeakNetShowRunnable] playTag:");
            QFSVideoView qFSVideoView = this.I;
            if (qFSVideoView != null) {
                str = qFSVideoView.M0();
            } else {
                str = "";
            }
            sb5.append(str);
            sb5.append(", pos:");
            sb5.append(this.f85018i);
            sb5.append(", hashCode:");
            sb5.append(hashCode());
            objArr[0] = sb5.toString();
            RFWLog.d(tag, i3, objArr);
            RFWThreadManager.getUIHandler().removeCallbacks(this.f85227w0);
            this.f85227w0 = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long S2() {
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        int i3 = this.Y;
        if (i3 <= 0) {
            T t16 = this.f85017h;
            if (t16 == 0) {
                feedCloudMeta$StVideo = null;
            } else {
                feedCloudMeta$StVideo = ((FeedCloudMeta$StFeed) t16).video;
            }
            if (feedCloudMeta$StVideo == null) {
                return 0L;
            }
            i3 = feedCloudMeta$StVideo.duration.get();
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S3(int i3, int i16, QCircleExtraTypeInfo qCircleExtraTypeInfo, String str, String str2) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        if (qCircleExtraTypeInfo != null && (feedCloudMeta$StFeed = qCircleExtraTypeInfo.mFeed) != null) {
            QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder(ua0.c.c(feedCloudMeta$StFeed));
            dataBuilder.setActionType(i3).setSubActionType(i16).setToUin(qCircleExtraTypeInfo.mFeed.poster.f398463id.get()).setPosition(qCircleExtraTypeInfo.mDataPosition).setPlayScene(qCircleExtraTypeInfo.mPlayScene).setVideoPlayTime(this.X).setExt1(str).setExt4(str2).setPageId(y0()).setfpageid(Integer.valueOf(t0()).intValue()).setFirstFeedId(w20.a.j().h());
            QCircleLpReportDc05507.report(dataBuilder);
            return;
        }
        RFWLog.e("QCircleReportHelper_QFSFeedChildVideoPresenter", RFWLog.USR, "extraTypeInfo is null or lost feed,actionType:" + i3 + ",subActionType:" + i16);
    }

    private t40.b T2() {
        if (this.f85225u0 == null) {
            this.f85225u0 = (t40.b) u0(t40.b.class);
        }
        return this.f85225u0;
    }

    private void T3(int i3) {
        if (r() != null && r().mFeed.get() != null) {
            if (fb0.a.b("reportVideoEnd" + r().mFeed.f398449id.get(), 1000L) || i3 == -1) {
                return;
            }
            Gson gson = new Gson();
            HashMap hashMap = new HashMap();
            hashMap.put(QFS5507ReportHelper.JsonKey.END_TYPE, Integer.valueOf(i3));
            S3(600, 1, r(), "", gson.toJson(hashMap));
            long currentTimeMillis = System.currentTimeMillis() - this.f85212h0;
            QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder(ua0.c.c(r().mFeed));
            dataBuilder.setActionType(1).setSubActionType(8).setExt1("2").setVideoPlayTime(currentTimeMillis).setVideoTotalTime(r().mFeed.video.duration.get()).setPosition(this.f85018i).setFirstFeedId(w20.a.j().h()).setFeedId(r().mFeed.f398449id.get()).setAuthorUin(r().mFeed.poster.f398463id.get()).setfpageid(getReportBean().getFromPageId()).setPageId(y0());
            QCircleLpReportDc05507.report(dataBuilder);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Long U2() {
        e.b p16 = k30.e.i().p();
        if (com.tencent.biz.qqcircle.utils.bz.t() && p16 != null && TextUtils.equals(p16.b(), ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get()) && p16.d() != 0 && this.N != null) {
            return Long.valueOf(p16.d());
        }
        k30.e.i().e();
        return null;
    }

    private void U3() {
        QFSVideoView qFSVideoView = this.I;
        if (qFSVideoView != null) {
            qFSVideoView.setReportBean(getReportBean());
        }
        QUIPlayIconView qUIPlayIconView = this.U;
        if (qUIPlayIconView != null) {
            qUIPlayIconView.setVisibility(8);
        }
        LinearLayout linearLayout = this.Q;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        QFSSeekBar qFSSeekBar = this.N;
        if (qFSSeekBar != null) {
            qFSSeekBar.W();
        }
    }

    private Drawable V2() {
        if (s0() != null && s0().getTransitionLoadingDrawable() != null) {
            return s0().getTransitionLoadingDrawable();
        }
        return new ColorDrawable(QCircleSkinHelper.getInstance().getColor(R.color.cje));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void V3() {
        long R = p40.u.H().R((FeedCloudMeta$StFeed) this.f85017h);
        if (R > 0) {
            this.I.seek(R);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String W2() {
        QCircleInitBean qCircleInitBean;
        String str;
        if (s0() != null) {
            qCircleInitBean = s0().getInitBean();
        } else {
            qCircleInitBean = null;
        }
        if (qCircleInitBean == null) {
            return null;
        }
        String feedId = qCircleInitBean.getFeedId();
        T t16 = this.f85017h;
        if (t16 != 0) {
            str = ((FeedCloudMeta$StFeed) t16).f398449id.get();
        } else {
            str = "";
        }
        if (!com.tencent.biz.qqcircle.immersive.utils.r.z0(feedId, str)) {
            return null;
        }
        if (TextUtils.isEmpty(qCircleInitBean.getProgressCallbackId())) {
            T t17 = this.f85017h;
            if (t17 == 0 || ((FeedCloudMeta$StFeed) t17).video == null) {
                return null;
            }
            return ((FeedCloudMeta$StFeed) t17).video.fileId.get();
        }
        return qCircleInitBean.getProgressCallbackId();
    }

    private void W3() {
        if (TextUtils.equals(q0(), QCircleDaTongConstant.PageId.PG_XSJ_AVATAR_APERTURE_PAGE) && this.f85209e0 != null) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSApertureExposeFeedEvent(this.f85209e0.f398449id.get()));
        }
    }

    private void X3() {
        if (s0() == null) {
            return;
        }
        com.tencent.biz.qqcircle.helpers.e.f84616a.c(s0().getInitBean(), this.f85209e0);
    }

    private int Y2(RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (rFWFeedSelectInfo == null) {
            return -1;
        }
        int position = rFWFeedSelectInfo.getPosition();
        int nextPosition = rFWFeedSelectInfo.getNextPosition();
        if (nextPosition == 0 && position != 1) {
            return 5;
        }
        if (position > nextPosition) {
            return 2;
        }
        if (position >= nextPosition) {
            return -1;
        }
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Y3(int i3, int i16) {
        String str;
        t40.a s06 = s0();
        if (s06 == null) {
            return;
        }
        if (this.f85214j0 == null) {
            this.f85214j0 = new QFSVideoFeedPlayEvent();
        }
        QFSVideoFeedPlayEvent qFSVideoFeedPlayEvent = this.f85214j0;
        qFSVideoFeedPlayEvent.indexInFeed = this.f85018i;
        qFSVideoFeedPlayEvent.progress = i16;
        qFSVideoFeedPlayEvent.duration = i3;
        qFSVideoFeedPlayEvent.loopCount = this.f85206b0;
        qFSVideoFeedPlayEvent.globalKey = s06.getViewModelKey();
        QFSVideoFeedPlayEvent qFSVideoFeedPlayEvent2 = this.f85214j0;
        T t16 = this.f85017h;
        String str2 = "";
        if (t16 == 0) {
            str = "";
        } else {
            str = ((FeedCloudMeta$StFeed) t16).video.playUrl.get();
        }
        qFSVideoFeedPlayEvent2.playUrl = str;
        QFSVideoFeedPlayEvent qFSVideoFeedPlayEvent3 = this.f85214j0;
        T t17 = this.f85017h;
        if (t17 != 0) {
            str2 = ((FeedCloudMeta$StFeed) t17).f398449id.get();
        }
        qFSVideoFeedPlayEvent3.feedId = str2;
        SimpleEventBus.getInstance().dispatchEvent(this.f85214j0);
    }

    private void Z2(QCirclePanelStateEvent qCirclePanelStateEvent) {
        if (!TextUtils.equals(qCirclePanelStateEvent.getFeedId(), j())) {
            return;
        }
        L3(qCirclePanelStateEvent.getFeedId(), QCirclePanelStateEvent.isAnyPanelShowing());
    }

    private void a3(QCircleConfigChangeEvent qCircleConfigChangeEvent) {
        if (qCircleConfigChangeEvent.configuration == null) {
            return;
        }
        int instantScreenHeight = DisplayUtil.getInstantScreenHeight(this.J.getContext());
        int instantScreenWidth = DisplayUtil.getInstantScreenWidth(this.J.getContext());
        RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "onConfigChange disPlayWidth:|mScreenWidth" + instantScreenWidth + "|mScreenHeight" + instantScreenHeight);
        V(this.I, this.J);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a4(boolean z16) {
        boolean z17;
        T t16;
        boolean z18;
        final ArrayList arrayList;
        if (this.W == null) {
            return;
        }
        int i3 = 0;
        if (z16 && (t16 = this.f85017h) != 0 && ((FeedCloudMeta$StFeed) t16).video != null && ((FeedCloudMeta$StFeed) t16).video.videoComposeSourceInfo.has()) {
            String str = ((FeedCloudMeta$StFeed) this.f85017h).video.videoComposeSourceInfo.get();
            if (!TextUtils.isEmpty(str)) {
                z17 = true;
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    arrayList = new ArrayList(jSONArray.length());
                    for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i16);
                        arrayList.add(new QFSVideoComposeSourceInfo(optJSONObject.optInt("endTimeMs"), optJSONObject.optString("posterId"), optJSONObject.optString("feedId"), optJSONObject.optLong(WadlProxyConsts.CREATE_TIME)));
                    }
                } catch (Exception e16) {
                    e = e16;
                    z18 = false;
                }
                if (arrayList.size() > 0) {
                    try {
                        this.W.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.bs
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                QFSFeedChildVideoPresenter.this.I3(arrayList, view);
                            }
                        });
                    } catch (Exception e17) {
                        e = e17;
                        z18 = true;
                        RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "setJumpToSourceVideoBtnVisibility, exception = " + e.getMessage());
                        z17 = z18;
                        ImageView imageView = this.W;
                        if (!z17) {
                        }
                        imageView.setVisibility(i3);
                    }
                    ImageView imageView2 = this.W;
                    if (!z17) {
                        i3 = 8;
                    }
                    imageView2.setVisibility(i3);
                }
            }
        }
        z17 = false;
        ImageView imageView22 = this.W;
        if (!z17) {
        }
        imageView22.setVisibility(i3);
    }

    private void b3(@NonNull QFSVideoControlEvent qFSVideoControlEvent) {
        String j3 = j();
        if (TextUtils.equals(j3, qFSVideoControlEvent.getFeedId()) && !TextUtils.isEmpty(j3) && !TextUtils.isEmpty(qFSVideoControlEvent.getFeedId())) {
            p3(qFSVideoControlEvent.getFeedId(), qFSVideoControlEvent.isPlay());
        }
    }

    private void b4(RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.setPlayIOC(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void c3() {
        if (com.tencent.biz.qqcircle.immersive.utils.a.f((FeedCloudMeta$StFeed) this.f85017h, this.f85210f0, s0()) && this.f85206b0 == 1) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSQzoneFirstVideoAutoSlideEvent(j()));
        }
        t2();
    }

    private long c4(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        QCircleInitBean qCircleInitBean;
        if (feedCloudMeta$StFeed == null || (feedCloudMeta$StVideo = feedCloudMeta$StFeed.video) == null) {
            return 0L;
        }
        String N = com.tencent.biz.qqcircle.immersive.utils.r.N(feedCloudMeta$StVideo.playUrl.get());
        if (s0() != null) {
            qCircleInitBean = s0().getInitBean();
        } else {
            qCircleInitBean = null;
        }
        long videoStartOffsetFromScheme = QCirclePluginUtil.getVideoStartOffsetFromScheme(qCircleInitBean, feedCloudMeta$StFeed);
        if (QCirclePluginUtil.isExistVideoStartOffsetFromScheme(qCircleInitBean, feedCloudMeta$StFeed)) {
            l4(N, videoStartOffsetFromScheme);
        }
        if (qCircleInitBean != null && qCircleInitBean.getVideoCurrentPosition() > 0) {
            long videoCurrentPosition = qCircleInitBean.getVideoCurrentPosition();
            l4(N, videoCurrentPosition);
            qCircleInitBean.setVideoCurrentPosition(0L);
            return videoCurrentPosition;
        }
        return videoStartOffsetFromScheme;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d3(QFSFloatEndCaptureEvent qFSFloatEndCaptureEvent) {
        if (this.f85017h != 0 && TextUtils.equals(qFSFloatEndCaptureEvent.getFeedId(), ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get()) && this.J != null) {
            QLog.d("QFSFeedChildVideoPresenter", 1, "[handleFloatCaptureEnd] ");
            this.J.setImageBitmap(qFSFloatEndCaptureEvent.getBitMap());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean d4() {
        if (!this.f85213i0 && com.tencent.biz.qqcircle.utils.bi.d(m0(), (FeedCloudMeta$StFeed) this.f85017h)) {
            return true;
        }
        return false;
    }

    private void e2(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, RFWPlayerOptions rFWPlayerOptions, String str) {
        if (rFWPlayerOptions == null) {
            return;
        }
        this.I.setProgressBar(this.N);
        this.I.setLoadingView(this.P);
        b4(rFWPlayerOptions);
        l2(rFWPlayerOptions);
        k2(rFWPlayerOptions);
        j2(rFWPlayerOptions);
        m2(rFWPlayerOptions, str);
        f2(rFWPlayerOptions);
        i2(rFWPlayerOptions);
        g2(feedCloudMeta$StFeed, rFWPlayerOptions);
        h2(rFWPlayerOptions);
        n2(rFWPlayerOptions);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void e3(QFSFoldFullScreenChangeEvent qFSFoldFullScreenChangeEvent) {
        t40.d dVar;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        String str;
        if (!E0() || (dVar = this.f85224t0) == null || dVar.getActivityHashCode() != qFSFoldFullScreenChangeEvent.getHashCode() || (feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) this.f85017h) == null) {
            return;
        }
        if (TextUtils.isEmpty(feedCloudMeta$StFeed.cover.layerPicUrl.get())) {
            str = feedCloudMeta$StFeed.cover.picUrl.get();
        } else {
            str = feedCloudMeta$StFeed.cover.layerPicUrl.get();
        }
        k30.e.i().v(new e.b(this.X, str, this.f85210f0, feedCloudMeta$StFeed.f398449id.get()));
        if (RFWLog.isDevelopLevel()) {
            RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.DEV, "[handleFoldFullScreenChangeEvent] real save play pos");
        }
    }

    private void f2(RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addCompletionListener(new g());
    }

    private void f3(QFSIdentityAuthenticationShowEvent qFSIdentityAuthenticationShowEvent) {
        if (qFSIdentityAuthenticationShowEvent == null) {
            RFWLog.e("QFSFeedChildVideoPresenter", RFWLog.USR, "[handleIdentityAuthenticationFragmentEvent] event is null");
        } else if (qFSIdentityAuthenticationShowEvent.isIdentityAuthenticationFragmentShow() && qFSIdentityAuthenticationShowEvent.getType() == 1) {
            n();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f4(boolean z16, RFWFeedSelectInfo rFWFeedSelectInfo) {
        boolean z17;
        String str;
        t40.f j16 = j1();
        if (j16 != null) {
            j16.Gd();
        }
        Q3(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_AUTO_PLAY);
        QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_AUTO_PLAY);
        T t16 = this.f85017h;
        if (t16 != 0 && gb0.b.F(((FeedCloudMeta$StFeed) t16).f398449id.get(), ((FeedCloudMeta$StFeed) this.f85017h).video.playUrl.get())) {
            RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "fs_lifecycle  startANewPlayer should not play");
            return;
        }
        if (!u3()) {
            return;
        }
        t1();
        r2(false);
        n1();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) this.f85017h;
        this.I.setData(feedCloudMeta$StFeed, this.f85018i);
        QFSVideoView.D = new WeakReference<>(this.I);
        int size = feedCloudMeta$StFeed.video.vecVideoUrl.size();
        String N = com.tencent.biz.qqcircle.immersive.utils.r.N(feedCloudMeta$StFeed.video.playUrl.get());
        long R2 = R2(z16, N);
        RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "[QPH]fs_lifecycle  startANewPlayer , playUrlKey:" + N + "|" + this.f85207c0.containsKey(N) + " , feedId = " + feedCloudMeta$StFeed.f398449id.get() + " , hashcode: " + hashCode() + " , traceId: " + com.tencent.biz.qqcircle.immersive.utils.ba.d(feedCloudMeta$StFeed) + " , startOffset: " + R2 + " , isContinuePlay: " + z16 + " , vecUrlsize: " + size);
        RFWPlayerOptions addAttachInfo = RFWPlayerOptions.obtain(com.tencent.biz.qqcircle.utils.cq.f92752a.p((FeedCloudMeta$StFeed) this.f85017h)).setPlayUrl(feedCloudMeta$StFeed.video.playUrl.get()).setFileId(feedCloudMeta$StFeed.video.fileId.get()).setStVideo(gb0.b.k(feedCloudMeta$StFeed.video)).setStartOffset(R2).setFromType(2).setEnableDataCollect(true).addAttachInfo("ATTACH_INFO_KEY_POI", Integer.valueOf(this.f85018i));
        if (rFWFeedSelectInfo != null && rFWFeedSelectInfo.isScrollToNext()) {
            z17 = true;
        } else {
            z17 = false;
        }
        RFWPlayerOptions addAttachInfo2 = addAttachInfo.addAttachInfo("ATTACH_INFO_KEY_SCROLL_NEXT", Boolean.valueOf(z17));
        if (rFWFeedSelectInfo != null) {
            str = rFWFeedSelectInfo.getSelectedType();
        } else {
            str = "";
        }
        RFWPlayerOptions addAttachInfo3 = addAttachInfo2.addAttachInfo("ATTACH_INFO_KEY_SELECTED_TYPE", str);
        e2(feedCloudMeta$StFeed, addAttachInfo3, N);
        RFWLog.d("QFSFeedChildVideoPresenter_" + addAttachInfo3.tag(), RFWLog.USR, "fs_lifecycle  startANewPlayer:" + com.tencent.biz.qqcircle.immersive.utils.ac.f90062a.a(feedCloudMeta$StFeed.content.get()));
        this.I.loadPlayOptions(addAttachInfo3);
        j4(d4() ^ true);
        this.f85209e0 = (FeedCloudMeta$StFeed) this.f85017h;
        this.f85210f0 = this.f85018i;
        QUIPlayIconView qUIPlayIconView = this.U;
        if (qUIPlayIconView != null) {
            qUIPlayIconView.setVisibility(8);
        }
        Q3(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_SET_VIDEO_PATH);
        QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_SET_VIDEO_PATH);
        if (w3()) {
            ((IQCirclePublicAccountTechReporter) QRoute.api(IQCirclePublicAccountTechReporter.class)).onVideoPlayerOpen(feedCloudMeta$StFeed.f398449id.get());
        }
        RFWPlayerMonitor.g().startPlayColorLog();
        if (!this.f85218n0) {
            Y3(this.Y, this.X);
        }
        T0(new com.tencent.biz.qqcircle.immersive.feed.event.aj());
    }

    private void g2(final FeedCloudMeta$StFeed feedCloudMeta$StFeed, @NonNull final RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addErrorStatusListener(new IRFWPlayErrorStatusListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.bw
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener
            public final void onVideoPlayError(int i3, int i16, int i17, String str) {
                QFSFeedChildVideoPresenter.this.E3(rFWPlayerOptions, feedCloudMeta$StFeed, i3, i16, i17, str);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void g3(QFSVideoOnPlayEvent qFSVideoOnPlayEvent) {
        String feedId = qFSVideoOnPlayEvent.getFeedId();
        int playHashCode = qFSVideoOnPlayEvent.getPlayHashCode();
        T t16 = this.f85017h;
        if (t16 != 0) {
            if (!((FeedCloudMeta$StFeed) t16).f398449id.get().equals(feedId) || playHashCode != hashCode()) {
                a();
            }
        }
    }

    private void g4(QCirclePanelStateEvent qCirclePanelStateEvent) {
        if (!J0()) {
            return;
        }
        if (qCirclePanelStateEvent.isShowing()) {
            O3(true, false);
        } else if (!f85204y0) {
            n();
        }
    }

    private void h2(final RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addInfoListener(new IRFWPlayerOnInfoListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.bv
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerOnInfoListener
            public final void onInfo(int i3, long j3, long j16, Object obj) {
                QFSFeedChildVideoPresenter.F3(RFWPlayerOptions.this, i3, j3, j16, obj);
            }
        });
    }

    private void h3(@NonNull QCirclePanelStateEvent qCirclePanelStateEvent) {
        String feedId;
        int i3;
        int panelType = qCirclePanelStateEvent.getPanelType();
        if (panelType != 2) {
            if (panelType != 11) {
                if (panelType != 14) {
                    if (panelType != 16) {
                        if (panelType != 24 && panelType != 39) {
                            if (panelType != 27) {
                                if (panelType != 28) {
                                    if (panelType != 34) {
                                        if (panelType != 35) {
                                            L3(qCirclePanelStateEvent.getFeedId(), QCirclePanelStateEvent.isAnyPanelShowing());
                                            return;
                                        } else {
                                            M3("", QCirclePanelStateEvent.isSpecifiedPanelShowing(35), false);
                                            return;
                                        }
                                    }
                                }
                            } else {
                                Context m06 = m0();
                                if (m06 != null) {
                                    i3 = m06.hashCode();
                                } else {
                                    i3 = 0;
                                }
                                if (i3 != 0 && i3 == qCirclePanelStateEvent.getContextHashCode()) {
                                    M3("", qCirclePanelStateEvent.isShowing(), false);
                                    return;
                                }
                                return;
                            }
                        }
                        if (!TextUtils.equals(qCirclePanelStateEvent.getFeedId(), j())) {
                            return;
                        }
                        this.f85219o0 = qCirclePanelStateEvent.isShowing();
                        L3(qCirclePanelStateEvent.getFeedId(), qCirclePanelStateEvent.isShowing());
                        return;
                    }
                    g4(qCirclePanelStateEvent);
                    return;
                }
                M3("", QCirclePanelStateEvent.isSpecifiedPanelShowing(14), false);
                return;
            }
            Z2(qCirclePanelStateEvent);
            return;
        }
        if (TextUtils.isEmpty(qCirclePanelStateEvent.getFeedId())) {
            feedId = j();
        } else {
            feedId = qCirclePanelStateEvent.getFeedId();
        }
        L3(feedId, QCirclePanelStateEvent.isAnyPanelShowing());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h4() {
        if (!y3()) {
            this.I.setOutPutMute(true);
            S0();
            QLog.d(getTAG(), 1, "loop back end triggerAutoScroll");
        }
    }

    private void i2(RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addLooperListeners(new h());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void i3(QCircleVideoRateEvent qCircleVideoRateEvent) {
        boolean z16;
        boolean z17;
        T t16 = this.f85017h;
        if (t16 != 0 && ((FeedCloudMeta$StFeed) t16).f398449id.get().equals(qCircleVideoRateEvent.getFeedId()) && this.I != null) {
            QLog.d("QFSFeedChildVideoPresenter", 1, "handlePlayRateEvent:" + qCircleVideoRateEvent + "|" + this.I.hashCode());
            this.I.setPlayRate(qCircleVideoRateEvent.getSelectedRate());
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handlePlayRateEvent:");
        sb5.append(qCircleVideoRateEvent);
        sb5.append("| mData == null:");
        boolean z18 = false;
        if (this.f85017h == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append("| FeedId not equals:");
        T t17 = this.f85017h;
        if (t17 != 0 && !((FeedCloudMeta$StFeed) t17).f398449id.get().equals(qCircleVideoRateEvent.getFeedId())) {
            z17 = true;
        } else {
            z17 = false;
        }
        sb5.append(z17);
        sb5.append("| mPlayView == null:");
        if (this.I == null) {
            z18 = true;
        }
        sb5.append(z18);
        QLog.d("QFSFeedChildVideoPresenter", 1, sb5.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void i4(QCircleFeedVideoCurrentTimeEvent qCircleFeedVideoCurrentTimeEvent) {
        T t16 = this.f85017h;
        if (t16 != 0 && ((FeedCloudMeta$StFeed) t16).video != null && ((FeedCloudMeta$StFeed) t16).video.playUrl != null && qCircleFeedVideoCurrentTimeEvent != null) {
            l4(com.tencent.biz.qqcircle.immersive.utils.r.N(((FeedCloudMeta$StFeed) t16).video.playUrl.get()), qCircleFeedVideoCurrentTimeEvent.getCurrentTime());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String j() {
        T t16 = this.f85017h;
        if (t16 == 0) {
            return "";
        }
        return ((FeedCloudMeta$StFeed) t16).f398449id.get();
    }

    private void j2(RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addLifeCycleListeners(new a());
    }

    private void j3(QCircleSeekAreaEvent qCircleSeekAreaEvent) {
        QFSSeekBar qFSSeekBar;
        if (E0() && this.I != null) {
            if (uq3.o.R0() && (qFSSeekBar = this.N) != null) {
                qFSSeekBar.setEnabled(true);
            }
            m4(qCircleSeekAreaEvent.getEvent());
        }
    }

    private void j4(boolean z16) {
        if (this.I == null) {
            return;
        }
        this.f85211g0 = z16;
        RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.CLR, "[updateAutoScroll] mIsLoopBack: ", Boolean.valueOf(z16), " | shouldAutoScroll: ", Boolean.valueOf(d4()));
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_use_loop_end_auto_scroll", true)) {
            this.I.setLoopBack(true);
        } else {
            this.I.setLoopBack(this.f85211g0);
        }
    }

    private void k2(RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addPrepareListeners(new e());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void k3(QFSStartVideoEvent qFSStartVideoEvent) {
        T t16 = this.f85017h;
        if (t16 != 0 && TextUtils.equals(qFSStartVideoEvent.feedId, ((FeedCloudMeta$StFeed) t16).f398449id.get())) {
            if (qFSStartVideoEvent.play) {
                QFSVideoView qFSVideoView = this.I;
                if (qFSVideoView != null && qFSVideoView.isRelease()) {
                    QLog.d("QFSFeedChildVideoPresenter", 1, "");
                    this.f85221q0 = true;
                    f4(true, null);
                } else {
                    n();
                }
                this.f85219o0 = false;
                return;
            }
            O3(false, false);
        }
    }

    private void l2(RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addSDKInitListeners(new d());
    }

    private void l3(QFSFakeBarrageEvent qFSFakeBarrageEvent) {
        if (TextUtils.equals(qFSFakeBarrageEvent.getFeedId(), j()) && qFSFakeBarrageEvent.getBarrage() != null && !TextUtils.isEmpty(qFSFakeBarrageEvent.getBarrage().content.get())) {
            n();
        }
    }

    private void l4(String str, long j3) {
        if (com.tencent.biz.qqcircle.immersive.manager.f.f().g(S2())) {
            com.tencent.biz.qqcircle.immersive.manager.f.f().m(str, j3);
        }
        this.f85207c0.put(str, Long.valueOf(j3));
        if (x3()) {
            com.tencent.biz.qqcircle.immersive.manager.f.f().n(str, Long.valueOf(j3));
        }
    }

    private void m2(RFWPlayerOptions rFWPlayerOptions, String str) {
        rFWPlayerOptions.getListenerSet().addSeekListeners(new f(str));
    }

    private void m4(MotionEvent motionEvent) {
        if (this.N == null) {
            RFWLog.e("QFSFeedChildVideoPresenter", RFWLog.USR, "[updateSeekBarEvent] seek bar should not be null.");
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("QFSFeedChildVideoPresenter", 1, "updateSeekBarEvent, hashcode: " + motionEvent.hashCode());
        }
        this.N.onTouchEvent(motionEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void n() {
        QFSVideoView qFSVideoView = this.I;
        int i3 = 0;
        if (qFSVideoView != null && qFSVideoView.getSuperPlayer() != null) {
            if (this.I.getSuperPlayer().isPausing()) {
                RFWLog.d("QFSFeedChildVideoPresenter", 1, "[startFromPause] current player is pause, try start play.");
                J2();
                this.I.start();
                r2(true);
                com.tencent.biz.qqcircle.immersive.feed.event.ap apVar = new com.tencent.biz.qqcircle.immersive.feed.event.ap(false);
                apVar.d(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
                T0(apVar);
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                String str = ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get();
                long j3 = this.X;
                if (m0() != null) {
                    i3 = m0().hashCode();
                }
                simpleEventBus.dispatchEvent(new QFSVideoPauseEvent(str, false, j3, i3));
                this.U.setVisibility(8);
                y2();
                u2(this.I.getSuperPlayer());
                return;
            }
            return;
        }
        RFWLog.d("QFSFeedChildVideoPresenter", 1, "[startFromPause] current play view or player is null, end flow.");
    }

    private void n2(RFWPlayerOptions rFWPlayerOptions) {
        if (!RFWSprManger.g().enableSpr()) {
            return;
        }
        rFWPlayerOptions.getListenerSet().addSprListener(new b());
    }

    private void n3(@NonNull RFWMediaFocusChangeEvent rFWMediaFocusChangeEvent) {
        if (TextUtils.equals(rFWMediaFocusChangeEvent.getConflictBusinessName(), Constants.Business.QQ_CIRCLE_WINDOW) || !TextUtils.equals(rFWMediaFocusChangeEvent.getFocusBusinessName(), Constants.Business.QQ_CIRCLE_WINDOW)) {
            return;
        }
        p3(null, !rFWMediaFocusChangeEvent.hasFocusConflict());
    }

    private boolean n4() {
        QCircleInitBean qCircleInitBean;
        HashMap<String, String> hashMap = null;
        if (s0() != null) {
            qCircleInitBean = s0().getInitBean();
        } else {
            qCircleInitBean = null;
        }
        if (qCircleInitBean != null) {
            hashMap = qCircleInitBean.getSchemeAttrs();
        }
        if (hashMap != null && hashMap.containsKey(QCircleSchemeAttr.Detail.USE_REAL_FEED_ID_CHECK_DATA)) {
            return "1".equals(hashMap.get(QCircleSchemeAttr.Detail.USE_REAL_FEED_ID_CHECK_DATA));
        }
        return QCircleContentDetailSchemeParser.r(hashMap);
    }

    private void o3(QFSQzoneFirstVideoAutoSlideEvent qFSQzoneFirstVideoAutoSlideEvent) {
        if (!TextUtils.equals(qFSQzoneFirstVideoAutoSlideEvent.getFeedId(), j())) {
            return;
        }
        if (QCirclePanelStateEvent.isAnyPanelShowing()) {
            QLog.d("QFSFeedChildVideoPresenter", 1, "[handlerQZoneFirstVideoAutoSlideEvent] has panel showing.");
        } else {
            QLog.d("QFSFeedChildVideoPresenter", 1, "[handlerQZoneFirstVideoAutoSlideEvent]");
            S0();
        }
    }

    private boolean p2() {
        Context m06 = m0();
        if (m06 == null || com.tencent.biz.qqcircle.helpers.i.f84624a.a(String.valueOf(m06.hashCode())) || com.tencent.biz.qqcircle.helpers.s.f84663a.a(m06.hashCode()) || com.tencent.biz.qqcircle.helpers.v.f84667a.a(m06.hashCode())) {
            return true;
        }
        return false;
    }

    private void p3(String str, boolean z16) {
        ISuperPlayer superPlayer;
        QFSVideoView qFSVideoView = this.I;
        if (qFSVideoView == null) {
            superPlayer = null;
        } else {
            superPlayer = qFSVideoView.getSuperPlayer();
        }
        if (superPlayer == null) {
            return;
        }
        QLog.d("QFSFeedChildVideoPresenter", 1, "[handleFeedIdVideoControlEvent] feed id: " + str + " | isPlay: " + z16);
        if (z16 && superPlayer.isPausing()) {
            n();
            this.N.X();
        } else if (!z16 && superPlayer.isPlaying()) {
            O3(true, false);
            this.N.T();
        }
    }

    private boolean q2() {
        if (s0() != null && this.I != null) {
            if (!J0()) {
                QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_PLAY_BUT_NOT_RESUME);
                QCircleFolderFunnelCollect.onPlayIntercept(true);
                k4(true);
                return true;
            }
            QCircleFolderFunnelCollect.onPlayIntercept(false);
            k4(false);
            return false;
        }
        RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "canNotPlay");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void r2(boolean z16) {
        String str;
        ImageView imageView = this.J;
        if (imageView != null && this.N != null) {
            if (z16) {
                imageView.setVisibility(8);
                this.N.setVisibility(0);
                f85204y0 = false;
            } else {
                imageView.setVisibility(0);
                this.N.setVisibility(8);
            }
            if (this.f85223s0 != z16) {
                int i3 = RFWLog.USR;
                Object[] objArr = new Object[1];
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[changeViewStatus], feedId:");
                T t16 = this.f85017h;
                if (t16 != 0) {
                    str = ((FeedCloudMeta$StFeed) t16).f398449id.get();
                } else {
                    str = "null";
                }
                sb5.append(str);
                sb5.append(", isPlay: ");
                sb5.append(z16);
                objArr[0] = sb5.toString();
                RFWLog.d("QFSFeedChildVideoPresenter", i3, objArr);
            }
            this.f85223s0 = z16;
        }
    }

    private void r3(boolean z16) {
        View view = this.f85016f;
        int i3 = 0;
        if (view == null) {
            RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "[hideVideoContainer] container should not be null.");
            return;
        }
        if (!z16) {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean s2(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        boolean z16;
        int i16;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = (FeedCloudMeta$StFeed) this.f85017h;
        if (com.tencent.biz.qqcircle.immersive.utils.r.B0(feedCloudMeta$StFeed, feedCloudMeta$StFeed2) && i3 == this.f85018i) {
            return true;
        }
        if (n4() && com.tencent.biz.qqcircle.immersive.utils.r.y0(feedCloudMeta$StFeed, feedCloudMeta$StFeed2)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if ((z16 || com.tencent.biz.qqcircle.immersive.utils.r.f0(feedCloudMeta$StFeed, feedCloudMeta$StFeed2)) && i3 == (i16 = this.f85018i)) {
            this.f85017h = feedCloudMeta$StFeed;
            this.f85209e0 = feedCloudMeta$StFeed;
            this.I.setData(feedCloudMeta$StFeed, i16);
            return true;
        }
        if (feedCloudMeta$StFeed != 0) {
            return false;
        }
        RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "onBindData is null: " + i3);
        return true;
    }

    private void s3() {
        this.Y = 0;
        this.X = 0;
        this.f85206b0 = 0;
        this.f85205a0 = 0;
    }

    private void t2() {
        t40.a s06 = s0();
        if (s06 == null) {
            QLog.d("QFSFeedChildVideoPresenter", 1, "[checkForceAutoSlideAtFirstVideo] getFeedIoc null.");
            return;
        }
        String a16 = com.tencent.biz.qqcircle.utils.bi.a(m0());
        if (!com.tencent.biz.qqcircle.utils.bi.c(s06.getFeedList(), a16, this.f85210f0)) {
            return;
        }
        if (QCirclePanelStateEvent.isAnyPanelShowing()) {
            QLog.d("QFSFeedChildVideoPresenter", 1, "[checkForceAutoSlideAtFirstVideo] panel showing.");
            return;
        }
        h4();
        uq3.k.a().n(a16, System.currentTimeMillis());
        QLog.d("QFSFeedChildVideoPresenter", 1, "[checkForceAutoSlideAtFirstVideo] first video force auto slide, scene: " + a16);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void t3() {
        QFSVideoView qFSVideoView = this.I;
        if (qFSVideoView == null) {
            return;
        }
        qFSVideoView.setLoadingView(this.P);
        this.I.setProgressBar(this.N);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u2(ISuperPlayer iSuperPlayer) {
        if (!K3() && iSuperPlayer != null && !com.tencent.biz.qqcircle.utils.cb.a() && iSuperPlayer.getDurationMs() >= 60000) {
            this.f85220p0 = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildVideoPresenter.6
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    SimpleEventBus.getInstance().dispatchEvent(new QFSPRatePlayGuideEvent(false, (FeedCloudMeta$StFeed) QFSFeedChildVideoPresenter.this.f85017h).setContextHashCode(QFSFeedChildVideoPresenter.this.m0().hashCode()));
                    QLog.d("QFSFeedChildVideoPresenter", 1, "dispatch rate guide event layer");
                }
            };
            x2();
            RFWThreadManager.getUIHandler().postDelayed(this.f85220p0, 5000L);
            QLog.d("QFSFeedChildVideoPresenter", 1, "can dispatch rate guide event layer");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean u3() {
        T t16 = this.f85017h;
        if (t16 != 0 && ((FeedCloudMeta$StFeed) t16).type.get() == 3) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v2(RFWPlayer rFWPlayer) {
        QFSSeekBar qFSSeekBar = this.N;
        if (qFSSeekBar != null && qFSSeekBar.J() == 0) {
            int videoDuration = rFWPlayer.getVideoDuration();
            if (videoDuration == 0 && rFWPlayer.getRealPlayer() != null) {
                QLog.d(getTAG(), 1, "checkSeekBarInitStatus get 0,use super duration");
                videoDuration = (int) rFWPlayer.getRealPlayer().getDurationMs();
            }
            this.N.setMax(videoDuration);
            QLog.d(getTAG(), 1, "checkSeekBarInitStatus success reset value:" + videoDuration);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean v3() {
        T t16 = this.f85017h;
        if (t16 == 0) {
            return false;
        }
        return TextUtils.equals(((FeedCloudMeta$StFeed) t16).f398449id.get(), p40.u.H().Q());
    }

    private void w2() {
        QUIPlayIconView qUIPlayIconView = this.U;
        if (qUIPlayIconView == null) {
            return;
        }
        qUIPlayIconView.setContentDescription("\u64ad\u653e\u6309\u94ae");
        this.U.setImportantForAccessibility(1);
        this.U.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.bt
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSFeedChildVideoPresenter.this.G3(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w3() {
        QCircleInitBean initBean;
        if (s0() == null) {
            initBean = null;
        } else {
            initBean = s0().getInitBean();
        }
        if (initBean != null && com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.c.f(initBean)) {
            return true;
        }
        return false;
    }

    private void x2() {
        if (this.f85220p0 == null) {
            return;
        }
        RFWThreadManager.getUIHandler().removeCallbacks(this.f85220p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x3() {
        QCircleExtraTypeInfo qCircleExtraTypeInfo = this.D;
        if (qCircleExtraTypeInfo == null || qCircleExtraTypeInfo.sourceType != 20111) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void y2() {
        if (this.f85017h == 0 || !uq3.o.d1()) {
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QFSVideoOnPlayEvent(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get(), hashCode()));
    }

    private boolean y3() {
        View view = this.C;
        if (view != null && (view.getParent() instanceof RecyclerView) && ((RecyclerView) this.C.getParent()).getAdapter() != null && ((RecyclerView) this.C.getParent()).getAdapter().getNUM_BACKGOURND_ICON() > this.f85018i + 1) {
            return false;
        }
        QLog.d("QFSFeedChildVideoPresenter", 1, "[scrollToNextItem] last video not need to scroll");
        return true;
    }

    private boolean z2() {
        QCircleInitBean qCircleInitBean;
        HashMap<String, String> hashMap = null;
        if (s0() != null) {
            qCircleInitBean = s0().getInitBean();
        } else {
            qCircleInitBean = null;
        }
        if (qCircleInitBean != null) {
            hashMap = qCircleInitBean.getSchemeAttrs();
        }
        if (hashMap != null && hashMap.containsKey(QCircleSchemeAttr.Detail.DISABLE_FAKE_RE_PLAY)) {
            return "1".equals(hashMap.get(QCircleSchemeAttr.Detail.DISABLE_FAKE_RE_PLAY));
        }
        return false;
    }

    private boolean z3() {
        t40.d dVar;
        if (this.f85017h == 0 || !com.tencent.biz.qqcircle.utils.bz.t() || (dVar = this.f85224t0) == null || !dVar.Uf()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.C0(hVar);
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.ak) {
            N3(((com.tencent.biz.qqcircle.immersive.feed.event.ak) hVar).b());
            return;
        }
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.t) {
            RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "onError retry:" + hashCode());
            f4(((com.tencent.biz.qqcircle.immersive.feed.event.t) hVar).a(), null);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public boolean D0(e40.p pVar) {
        super.D0(pVar);
        return this.f85208d0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public boolean J0() {
        if (!this.f85221q0 && !super.J0()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        super.K0();
        RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "onAttachedToWindow  | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
        if (s0() != null && s0().getInitBean() != null && s0().getInitBean().getExtraTypeInfo() != null && s0().getInitBean().getExtraTypeInfo().sourceType == 20101) {
            S3(5000, 55010, r(), "2", "");
            com.tencent.biz.qqcircle.immersive.personal.data.w wVar = new com.tencent.biz.qqcircle.immersive.personal.data.w(((FeedCloudMeta$StFeed) this.f85017h).poster.f398463id.get());
            wVar.K();
            wVar.X();
            wVar.R();
        }
        if (this.f85224t0 == null) {
            this.f85224t0 = (t40.d) u0(t40.d.class);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.QFSVideoView.c
    public void L(boolean z16) {
        if (z16) {
            P3();
        } else {
            R3();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        super.M0();
        RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "[onDetachedFromWindow] mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
        this.f85208d0 = false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.d, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.U = (QUIPlayIconView) this.f85016f.findViewById(R.id.va5);
        QFSVideoView qFSVideoView = (QFSVideoView) this.f85016f.findViewById(R.id.f74163vi);
        this.I = qFSVideoView;
        qFSVideoView.setAlpha(0.99f);
        this.I.G0(this);
        this.N = (QFSSeekBar) view.findViewById(R.id.vad);
        this.P = view.findViewById(R.id.vai);
        this.V = view.findViewById(R.id.f1189375h);
        this.W = (ImageView) view.findViewById(R.id.f165983yb3);
        com.tencent.biz.qqcircle.immersive.manager.d.c().i(this.W, R.drawable.oln);
        this.Q = (LinearLayout) view.findViewById(R.id.f46311u9);
        this.R = (LinearLayout) view.findViewById(R.id.vac);
        this.S = (TextView) view.findViewById(R.id.vah);
        this.T = (TextView) view.findViewById(R.id.vag);
        t3();
        w2();
        this.f85218n0 = uq3.c.h0();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void Q0() {
        super.Q0();
        if (u3()) {
            S3(1, 1, r(), "2", "");
            com.tencent.biz.qqcircle.immersive.utils.bl.b(this.f85209e0);
            QFSRecentlyWatchedRecorder.i().n(this.E);
            W3();
            X3();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void S0() {
        x0().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.bu
            @Override // java.lang.Runnable
            public final void run() {
                QFSFeedChildVideoPresenter.this.H3();
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public boolean X() {
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.d
    protected void a() {
        QFSVideoView qFSVideoView = this.I;
        if (qFSVideoView == null) {
            return;
        }
        VideoReport.unbindVideoPlayerInfo(qFSVideoView);
        this.I.release();
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildVideoPresenter.11
            @Override // java.lang.Runnable
            public void run() {
                QFSFeedChildVideoPresenter.this.r2(false);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean e4() {
        QCircleInitBean qCircleInitBean;
        if (this.f85017h == 0 || this.f85209e0 == null) {
            return false;
        }
        if (!z2() && !com.tencent.biz.qqcircle.utils.cq.f92752a.s((FeedCloudMeta$StFeed) this.f85017h)) {
            HashMap<String, String> hashMap = null;
            if (s0() != null) {
                qCircleInitBean = s0().getInitBean();
            } else {
                qCircleInitBean = null;
            }
            if (qCircleInitBean != null) {
                hashMap = qCircleInitBean.getSchemeAttrs();
            }
            if (!QCircleContentDetailSchemeParser.r(hashMap)) {
                return false;
            }
            return com.tencent.biz.qqcircle.immersive.utils.r.g0((FeedCloudMeta$StFeed) this.f85017h, this.f85209e0);
        }
        return com.tencent.biz.qqcircle.immersive.utils.r.g0((FeedCloudMeta$StFeed) this.f85017h, this.f85209e0);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public boolean f1() {
        return e1(this.I);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.d, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QCircleFeedVideoControlEvent.class);
        eventClass.add(QCircleFeedVideoCurrentTimeEvent.class);
        eventClass.add(QCirclePanelStateEvent.class);
        eventClass.add(QCircleConfigChangeEvent.class);
        eventClass.add(QFSVideoOnPlayEvent.class);
        eventClass.add(QCircleSeekAreaEvent.class);
        eventClass.add(QCircleFrameEvent.class);
        eventClass.add(QCircleVideoRateEvent.class);
        eventClass.add(QFSIdentityAuthenticationShowEvent.class);
        eventClass.add(QFSVideoControlEvent.class);
        eventClass.add(RFWMediaFocusChangeEvent.class);
        eventClass.add(QFSFloatEndCaptureEvent.class);
        eventClass.add(QFSStartVideoEvent.class);
        eventClass.add(QFSFakeBarrageEvent.class);
        eventClass.add(QFSQzoneFirstVideoAutoSlideEvent.class);
        eventClass.add(QFSFoldFullScreenChangeEvent.class);
        return eventClass;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.d
    protected void i1(RFWFeedSelectInfo rFWFeedSelectInfo) {
        boolean e46 = e4();
        boolean A3 = A3();
        boolean q26 = q2();
        boolean e16 = e1(this.I);
        RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "executeFromSelected shouldInterceptFromFakeRePlay:" + e46 + ",sameVideo:" + A3 + ",canNotPlay:" + q26 + ",shouldIntercept:" + e16);
        if (!q26 && ((!A3 || e16) && !e46)) {
            if (c4((FeedCloudMeta$StFeed) this.f85017h) > 0) {
                f4(true, rFWFeedSelectInfo);
                return;
            } else {
                f4(false, rFWFeedSelectInfo);
                return;
            }
        }
        RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "executeFromSelected return");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.feed.d
    public void k1(@NonNull ASEngineTabStatusEvent aSEngineTabStatusEvent) {
        super.k1(aSEngineTabStatusEvent);
        if (!aSEngineTabStatusEvent.isSelected() && QCirclePluginUtil.isQFSTabNativeFragmentMode(m0())) {
            O3(false, false);
            this.f85209e0 = null;
        }
    }

    public void k4(boolean z16) {
        t40.f j16 = j1();
        if (j16 != null) {
            j16.P7(z16);
        }
    }

    protected void o2() {
        if (super.h1()) {
            QLog.d("QFSFeedChildVideoPresenter", 1, "[bindCover] bind current frame bitmap.");
        } else {
            J3();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        PBStringField pBStringField;
        super.onDestroy();
        RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "fs_lifecycle onDestroy: | process:" + this.X + " | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | playView is null | pageId:" + y0());
        if (z3()) {
            if (TextUtils.isEmpty(((FeedCloudMeta$StFeed) this.f85017h).cover.layerPicUrl.get())) {
                pBStringField = ((FeedCloudMeta$StFeed) this.f85017h).cover.picUrl;
            } else {
                pBStringField = ((FeedCloudMeta$StFeed) this.f85017h).cover.layerPicUrl;
            }
            k30.e.i().v(new e.b(this.X, pBStringField.get(), this.f85210f0, ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get()));
        }
        a();
        x2();
        this.f85209e0 = null;
        this.f85210f0 = 0;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.d, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo == null) {
            return;
        }
        RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "fs_lifecycle onSelected:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
        if (rFWFeedSelectInfo.getPosition() != this.f85018i) {
            return;
        }
        QCircleToast.t(String.valueOf(hashCode()), true);
        x2();
        W(this.I, this.J);
        i1(rFWFeedSelectInfo);
        com.tencent.biz.qqcircle.immersive.manager.f.f().i();
        if (!rFWFeedSelectInfo.isIsReselected()) {
            this.f85212h0 = System.currentTimeMillis();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo == null || rFWFeedSelectInfo.getPosition() != this.f85018i) {
            return;
        }
        QCircleToast.t(String.valueOf(hashCode()), false);
        RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "onUnSelected:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
        this.f85209e0 = null;
        this.f85215k0 = null;
        this.f85210f0 = 0;
        this.f85206b0 = 0;
        x2();
        a();
        T3(Y2(rFWFeedSelectInfo));
        this.f85207c0.clear();
        this.f85217m0.d();
        com.tencent.biz.qqcircle.immersive.report.b.f().t(com.tencent.biz.qqcircle.utils.bj.h((FeedCloudMeta$StFeed) this.f85017h));
        R3();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPageScrolledIdle(int i3) {
        if (i3 == this.f85018i && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_use_loop_end_auto_scroll", true) && com.tencent.biz.qqcircle.utils.bi.d(m0(), (FeedCloudMeta$StFeed) this.f85017h)) {
            this.I.setOutPutMute(tb0.a.f435779d.b());
            QLog.d(getTAG(), 1, "onPageScrolledIdle reset output mute");
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onPaused(rFWFeedSelectInfo);
        RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "fs_lifecycle onPaused:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + APLogFileUtil.SEPARATOR_LOG + hashCode());
        if (QCirclePluginUtil.isSharePanelOnShow()) {
            RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "isSharePanelOnShow don't release player | pageId:" + y0());
            return;
        }
        if (this.f85219o0) {
            RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "is show similar recommend panel,  don't release player | pageId:" + y0());
            return;
        }
        if (QCirclePluginUtil.isIsECFloatWebViewOnShow()) {
            RFWLog.d("TAG", RFWLog.USR, "isIsECFloatWebViewOnShow don't release player | pageId:" + y0());
            return;
        }
        if (QFSMainProcessWebView.enableVideoPlayWebViewStatusCheck() && QFSMainProcessWebView.isForegroundStartRemoteWebView()) {
            RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "isForegroundStartRemoteWebView don't release player | pageId:" + y0());
            return;
        }
        QCircleToast.t(String.valueOf(hashCode()), false);
        O3(false, false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPosUpdate(int i3) {
        super.onPosUpdate(i3);
        this.f85210f0 = i3;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.d, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QCircleFeedVideoControlEvent) {
            QCircleFeedVideoControlEvent qCircleFeedVideoControlEvent = (QCircleFeedVideoControlEvent) simpleBaseEvent;
            if (m0() != null && m0().hashCode() == qCircleFeedVideoControlEvent.getHashCode()) {
                H2(qCircleFeedVideoControlEvent);
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof QCircleFeedVideoCurrentTimeEvent) {
            i4((QCircleFeedVideoCurrentTimeEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QCirclePanelStateEvent) {
            h3((QCirclePanelStateEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            a3((QCircleConfigChangeEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSVideoOnPlayEvent) {
            g3((QFSVideoOnPlayEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QCircleSeekAreaEvent) {
            j3((QCircleSeekAreaEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QCircleVideoRateEvent) {
            i3((QCircleVideoRateEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSIdentityAuthenticationShowEvent) {
            f3((QFSIdentityAuthenticationShowEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSVideoControlEvent) {
            b3((QFSVideoControlEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof RFWMediaFocusChangeEvent) {
            n3((RFWMediaFocusChangeEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSFloatEndCaptureEvent) {
            d3((QFSFloatEndCaptureEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSStartVideoEvent) {
            k3((QFSStartVideoEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSFakeBarrageEvent) {
            l3((QFSFakeBarrageEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSQzoneFirstVideoAutoSlideEvent) {
            o3((QFSQzoneFirstVideoAutoSlideEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSFoldFullScreenChangeEvent) {
            e3((QFSFoldFullScreenChangeEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onResumed(rFWFeedSelectInfo);
        if (this.I == null) {
            RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "onResumed:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + APLogFileUtil.SEPARATOR_LOG + hashCode() + "|playView is null");
            return;
        }
        Q2();
        if (rFWFeedSelectInfo == null) {
            return;
        }
        if (this.I.hasLoadOptions() && "TYPE_RE_ON_RESUME".equals(rFWFeedSelectInfo.getSelectedType()) && uq3.o.x()) {
            RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "has same task");
            return;
        }
        if (m0() != null && f85204y0 && com.tencent.biz.qqcircle.helpers.i.f84624a.b(String.valueOf(m0().hashCode()))) {
            QLog.d("QFSFeedChildVideoPresenter", 1, "[onResumed] comment panel is showing max height.");
            return;
        }
        if (this.f85018i == rFWFeedSelectInfo.getPosition()) {
            j4(!d4());
            W(this.I, this.J);
            O0(this.I, this.J);
            QCircleToast.t(String.valueOf(hashCode()), true);
            N2(true, rFWFeedSelectInfo);
        }
        RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "fs_lifecycle onResumed:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
        this.f85212h0 = System.currentTimeMillis();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onStop(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onStop(rFWFeedSelectInfo);
        RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "fs_lifecycle onStop:" + rFWFeedSelectInfo + " |  | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | playView is null | pageId:" + y0());
        O3(false, false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public void onViewHolderAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewHolderAttachedToWindow(viewHolder);
        RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "fs_lifecycle onViewHolderAttachedToWindow: | mPos:" + this.f85018i + " | holder.pos:" + viewHolder.getAdapterPosition() + " | holderHash code:" + viewHolder.hashCode() + " | hashCode:" + hashCode() + " | pageId:" + y0());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public void onViewHolderDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewHolderDetachedFromWindow(viewHolder);
        RFWLog.d("QFSFeedChildVideoPresenter", RFWLog.USR, "fs_lifecycle onViewHolderDetachedFromWindow: | mPos:" + this.f85018i + " | holder.pos:" + viewHolder.getAdapterPosition() + " | holderHash code:" + viewHolder.hashCode() + " | hashCode:" + hashCode() + " | pageId:" + y0());
        P2(viewHolder.getAdapterPosition());
        a();
        this.f85209e0 = null;
        this.f85210f0 = 0;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: s1 */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        if (s2(feedCloudMeta$StFeed, i3)) {
            return;
        }
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed.type.get() != 3) {
            r3(false);
            return;
        }
        r3(true);
        U3();
        s3();
        W(this.I, this.J);
        o2();
        r2(false);
        a4(false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildVideoPresenter";
    }
}
