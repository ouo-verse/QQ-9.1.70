package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.qq.e.comm.constants.Constants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleAdClickEvent;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedVideoControlEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedVideoCurrentTimeEvent;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QCircleVideoRateEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSSeekEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSVideoFeedPlayEvent;
import com.tencent.biz.qqcircle.immersive.views.QFSSeekBar;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerUpperData;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerCompletionListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.event.QCircleFrameEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleSeekAreaEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.widget.media.QUIPlayIconView;
import com.tencent.xweb.FileReaderHelper;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.QFS5507ReportHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class QFSFeedChildAdVideoPresenter extends com.tencent.biz.qqcircle.immersive.feed.d<FeedCloudMeta$StFeed> {

    /* renamed from: r0, reason: collision with root package name */
    private static boolean f85397r0;

    /* renamed from: s0, reason: collision with root package name */
    static Map<Class, i> f85398s0;
    private QFSSeekBar N;
    private View P;
    private LinearLayout Q;
    private LinearLayout R;
    private TextView S;
    private TextView T;
    private QUIPlayIconView U;
    private int V;
    private int W;
    private int Y;
    private int Z;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f85400b0;

    /* renamed from: c0, reason: collision with root package name */
    private FeedCloudMeta$StFeed f85401c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f85402d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f85403e0;

    /* renamed from: g0, reason: collision with root package name */
    private String f85405g0;

    /* renamed from: h0, reason: collision with root package name */
    private int f85406h0;

    /* renamed from: i0, reason: collision with root package name */
    private QFSVideoFeedPlayEvent f85407i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f85408j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f85409k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f85410l0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f85414p0;
    private com.tencent.biz.qqcircle.immersive.feed.event.ao X = null;

    /* renamed from: a0, reason: collision with root package name */
    private ConcurrentHashMap<String, Long> f85399a0 = new ConcurrentHashMap<>();

    /* renamed from: f0, reason: collision with root package name */
    private JSONObject f85404f0 = new JSONObject();

    /* renamed from: m0, reason: collision with root package name */
    private ValueAnimator f85411m0 = null;

    /* renamed from: n0, reason: collision with root package name */
    private GdtAd f85412n0 = new GdtAd();

    /* renamed from: o0, reason: collision with root package name */
    private boolean f85413o0 = false;

    /* renamed from: q0, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.feed.event.an f85415q0 = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends RFWPlayerIOC {
        a() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QCircleReportBean getReportBean() {
            return QFSFeedChildAdVideoPresenter.this.getReportBean();
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        public RFWPlayerReportInfo<e30.b> getBusinessReportInfo() {
            return gb0.b.m(((QFSBaseFeedChildPresenter) QFSFeedChildAdVideoPresenter.this).E.o("KEY_RFW_VIDEO_FEED_POI", Integer.valueOf(((QFSBaseFeedChildPresenter) QFSFeedChildAdVideoPresenter.this).f85018i)));
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        /* renamed from: getPlayerUpperData */
        public RFWPlayerUpperData getUpperData() {
            Context context;
            RFWPlayerUpperData dtCustomPgId = new RFWPlayerUpperData().setDtCustomPgId(QFSFeedChildAdVideoPresenter.this.q0());
            if (((com.tencent.biz.qqcircle.immersive.feed.d) QFSFeedChildAdVideoPresenter.this).I != null) {
                context = ((com.tencent.biz.qqcircle.immersive.feed.d) QFSFeedChildAdVideoPresenter.this).I.getContext();
            } else {
                context = null;
            }
            return dtCustomPgId.setContext(context);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        public boolean isValid() {
            return QFSFeedChildAdVideoPresenter.this.e3();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements IRFWPlayerSdkInitListener {
        b() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener
        public void onInitSuccess(RFWPlayer rFWPlayer) {
            QFSFeedChildAdVideoPresenter.this.r3(QCircleFolderFunnelCollect.PERIOD_VIDEO_SDK_SUCCEED);
            ((com.tencent.biz.qqcircle.immersive.feed.d) QFSFeedChildAdVideoPresenter.this).I.setProgressBar(QFSFeedChildAdVideoPresenter.this.N);
            ((com.tencent.biz.qqcircle.immersive.feed.d) QFSFeedChildAdVideoPresenter.this).I.setLoadingView(QFSFeedChildAdVideoPresenter.this.P);
            ((com.tencent.biz.qqcircle.immersive.feed.d) QFSFeedChildAdVideoPresenter.this).I.setLoopBack(QFSFeedChildAdVideoPresenter.this.f85403e0);
            if (((QFSBaseFeedChildPresenter) QFSFeedChildAdVideoPresenter.this).E != null) {
                ((com.tencent.biz.qqcircle.immersive.feed.d) QFSFeedChildAdVideoPresenter.this).I.setPlayRate(QCirclePluginGlobalInfo.t(((QFSBaseFeedChildPresenter) QFSFeedChildAdVideoPresenter.this).E.g().f398449id.get()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements IRFWPlayerPrepareListener {
        c() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onFirstFrameRendered(RFWPlayer rFWPlayer) {
            QFSFeedChildAdVideoPresenter.this.B2(true);
            QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_FIRST_RENDER);
            QFSFeedChildAdVideoPresenter.this.C3("bf", "1");
            QFSFeedChildAdVideoPresenter.this.l1(rFWPlayer);
            QFSFeedChildAdVideoPresenter.this.r3(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_FIRST_RENDER);
            t40.f j16 = QFSFeedChildAdVideoPresenter.this.j1();
            if (j16 != null) {
                j16.Y7(rFWPlayer);
            }
            QFSFeedChildAdVideoPresenter.this.u1();
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onVideoPrepared(RFWPlayer rFWPlayer) {
            String fileId;
            QFSFeedChildAdVideoPresenter.this.r3(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_PREPARED);
            QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_PREPARED);
            QFSFeedChildAdVideoPresenter.this.K2(rFWPlayer.getRealPlayer());
            QFSFeedChildAdVideoPresenter.this.C3("pa", "11");
            t40.f j16 = QFSFeedChildAdVideoPresenter.this.j1();
            if (j16 != null) {
                j16.onVideoPrepared(rFWPlayer);
            }
            com.tencent.biz.qqcircle.immersive.report.b f16 = com.tencent.biz.qqcircle.immersive.report.b.f();
            if (rFWPlayer.getRFWPlayerOptions() == null) {
                fileId = "";
            } else {
                fileId = rFWPlayer.getRFWPlayerOptions().getFileId();
            }
            f16.o(fileId);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements IRFWPlayerSeekListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f85420d;

        d(String str) {
            this.f85420d = str;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onProgress(String str, int i3, int i16) {
            QFSFeedChildAdVideoPresenter.this.D2(i3, i16, this.f85420d);
            QFSFeedChildAdVideoPresenter.this.C3(FileReaderHelper.ET_EXT, String.valueOf(i16));
            if (!QFSFeedChildAdVideoPresenter.this.f85410l0) {
                QFSFeedChildAdVideoPresenter qFSFeedChildAdVideoPresenter = QFSFeedChildAdVideoPresenter.this;
                qFSFeedChildAdVideoPresenter.f85409k0 = (qFSFeedChildAdVideoPresenter.f85409k0 + i16) - QFSFeedChildAdVideoPresenter.this.f85408j0;
                QFSFeedChildAdVideoPresenter qFSFeedChildAdVideoPresenter2 = QFSFeedChildAdVideoPresenter.this;
                qFSFeedChildAdVideoPresenter2.C3("pt", String.valueOf(qFSFeedChildAdVideoPresenter2.f85409k0));
            }
            if (QFSFeedChildAdVideoPresenter.this.f85406h0 != 0 && QFSFeedChildAdVideoPresenter.this.f85409k0 >= QFSFeedChildAdVideoPresenter.this.f85406h0 && QFSFeedChildAdVideoPresenter.this.f85406h0 <= QFSFeedChildAdVideoPresenter.this.Y) {
                com.tencent.biz.qqcircle.immersive.utils.d.f90201a.i(QFSFeedChildAdVideoPresenter.this.f85412n0);
            }
            QFSFeedChildAdVideoPresenter.this.f85408j0 = i16;
            QFSFeedChildAdVideoPresenter.this.f85410l0 = false;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onSeekBarProgressChanged(SeekBar seekBar, int i3, boolean z16) {
            QFSFeedChildAdVideoPresenter.this.E2(seekBar, i3, z16);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            QFSFeedChildAdVideoPresenter.this.F2(seekBar);
            QLog.d("QFSFeedAdChildVideoPresenter", 1, "[onStartTrackingTouch] seek progress: " + seekBar.getProgress());
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            QFSFeedChildAdVideoPresenter.this.G2(seekBar);
            QFSFeedChildAdVideoPresenter.this.f85410l0 = true;
            QLog.d("QFSFeedAdChildVideoPresenter", 1, "[onStopTrackingTouch] seek progress: " + seekBar.getProgress());
            QFSFeedChildAdVideoPresenter qFSFeedChildAdVideoPresenter = QFSFeedChildAdVideoPresenter.this;
            qFSFeedChildAdVideoPresenter.t3(400, 5, qFSFeedChildAdVideoPresenter.r(), "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements IRFWPlayerLooperListener {
        e() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener
        public void onVideoLoopEnd() {
            QFSFeedChildAdVideoPresenter.this.Z++;
            QFSFeedChildAdVideoPresenter.this.C3("ef", "1");
            QFSFeedChildAdVideoPresenter.this.s3();
            QFSFeedChildAdVideoPresenter.this.C3("ef", "0");
            if ((QFSFeedChildAdVideoPresenter.this.Y > 30000 && QFSFeedChildAdVideoPresenter.this.Z == 2) || (QFSFeedChildAdVideoPresenter.this.Y <= 30000 && QFSFeedChildAdVideoPresenter.this.Z == 3)) {
                QFSFeedChildAdVideoPresenter.this.Z = 0;
            }
            QFSFeedChildAdVideoPresenter.this.I2();
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener
        public void onVideoLoopStart() {
            QFSFeedChildAdVideoPresenter.this.C3("pa", "14");
            QFSFeedChildAdVideoPresenter.this.C3("bt", "0");
            QFSFeedChildAdVideoPresenter.this.f85408j0 = 0;
            QFSFeedChildAdVideoPresenter.this.J2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class g implements IRFWPlayErrorStatusListener {
        g() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener
        public void onVideoPlayError(int i3, int i16, int i17, String str) {
            QFSFeedChildAdVideoPresenter.this.u1();
            QFSFeedChildAdVideoPresenter.this.C3(Constants.KEYS.PLACEMENTS, "2");
            t40.f j16 = QFSFeedChildAdVideoPresenter.this.j1();
            if (j16 != null) {
                j16.onVideoPlayError(i17);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class h implements IRFWPlayerLifeCycle {
        h() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
        public void onDeInit(RFWPlayer rFWPlayer) {
            boolean z16;
            re0.a.a(this, rFWPlayer);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[onDeInit] player: ");
            if (rFWPlayer != null) {
                z16 = rFWPlayer.isRelease();
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("QFSFeedAdChildVideoPresenter", 1, sb5.toString());
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
        public /* synthetic */ void onStart(RFWPlayer rFWPlayer) {
            re0.a.d(this, rFWPlayer);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
        public /* synthetic */ void onStop(RFWPlayer rFWPlayer) {
            re0.a.e(this, rFWPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public interface i {
        void a(QFSFeedChildAdVideoPresenter qFSFeedChildAdVideoPresenter, SimpleBaseEvent simpleBaseEvent);
    }

    static {
        HashMap hashMap = new HashMap();
        f85398s0 = hashMap;
        hashMap.put(QCircleFeedVideoControlEvent.class, new i() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.dg
            @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdVideoPresenter.i
            public final void a(QFSFeedChildAdVideoPresenter qFSFeedChildAdVideoPresenter, SimpleBaseEvent simpleBaseEvent) {
                QFSFeedChildAdVideoPresenter.g3(qFSFeedChildAdVideoPresenter, simpleBaseEvent);
            }
        });
        f85398s0.put(QCircleFeedVideoCurrentTimeEvent.class, new i() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.dh
            @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdVideoPresenter.i
            public final void a(QFSFeedChildAdVideoPresenter qFSFeedChildAdVideoPresenter, SimpleBaseEvent simpleBaseEvent) {
                QFSFeedChildAdVideoPresenter.h3(qFSFeedChildAdVideoPresenter, simpleBaseEvent);
            }
        });
        f85398s0.put(QCirclePanelStateEvent.class, new i() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.di
            @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdVideoPresenter.i
            public final void a(QFSFeedChildAdVideoPresenter qFSFeedChildAdVideoPresenter, SimpleBaseEvent simpleBaseEvent) {
                QFSFeedChildAdVideoPresenter.i3(qFSFeedChildAdVideoPresenter, simpleBaseEvent);
            }
        });
        f85398s0.put(QCircleConfigChangeEvent.class, new i() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.dj
            @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdVideoPresenter.i
            public final void a(QFSFeedChildAdVideoPresenter qFSFeedChildAdVideoPresenter, SimpleBaseEvent simpleBaseEvent) {
                QFSFeedChildAdVideoPresenter.j3(qFSFeedChildAdVideoPresenter, simpleBaseEvent);
            }
        });
        f85398s0.put(QCircleVideoRateEvent.class, new i() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.dk
            @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdVideoPresenter.i
            public final void a(QFSFeedChildAdVideoPresenter qFSFeedChildAdVideoPresenter, SimpleBaseEvent simpleBaseEvent) {
                QFSFeedChildAdVideoPresenter.k3(qFSFeedChildAdVideoPresenter, simpleBaseEvent);
            }
        });
        f85398s0.put(QCircleFrameEvent.class, new i() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.dl
            @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdVideoPresenter.i
            public final void a(QFSFeedChildAdVideoPresenter qFSFeedChildAdVideoPresenter, SimpleBaseEvent simpleBaseEvent) {
                QFSFeedChildAdVideoPresenter.l3(qFSFeedChildAdVideoPresenter, simpleBaseEvent);
            }
        });
        f85398s0.put(QCircleAdClickEvent.class, new i() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.dm
            @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdVideoPresenter.i
            public final void a(QFSFeedChildAdVideoPresenter qFSFeedChildAdVideoPresenter, SimpleBaseEvent simpleBaseEvent) {
                QFSFeedChildAdVideoPresenter.n3(qFSFeedChildAdVideoPresenter, simpleBaseEvent);
            }
        });
    }

    private boolean A2() {
        if (s0() != null && this.I != null && e3()) {
            return false;
        }
        QLog.d("QFSFeedAdChildVideoPresenter", 1, "canNotPlay");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B2(boolean z16) {
        ImageView imageView = this.J;
        if (imageView != null && this.N != null) {
            if (z16) {
                imageView.setVisibility(8);
                this.N.setVisibility(0);
                f85397r0 = false;
            } else {
                imageView.setVisibility(0);
                this.N.setVisibility(8);
            }
            RFWLog.d("QFSFeedAdChildVideoPresenter", RFWLog.USR, "[changeViewStatus] isPlay: " + z16);
            return;
        }
        RFWLog.d("QFSFeedAdChildVideoPresenter", RFWLog.USR, "[changeViewStatus] mCoverImg == null || mSeekBar == null.");
    }

    private void B3() {
        if (!TextUtils.equals(this.f85404f0.optString("ft"), "2")) {
            C3("ft", "3");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean C2(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = (FeedCloudMeta$StFeed) this.f85017h;
        if (feedCloudMeta$StFeed == null) {
            QLog.d("QFSFeedAdChildVideoPresenter", 1, "onBindData is null: " + i3);
            return true;
        }
        if (com.tencent.biz.qqcircle.immersive.utils.r.B0(feedCloudMeta$StFeed, feedCloudMeta$StFeed2) && i3 == this.f85018i) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C3(String str, String str2) {
        try {
            this.f85404f0.put(str, str2);
        } catch (JSONException e16) {
            QLog.e("QFSFeedAdChildVideoPresenter", 1, "initVideoReportParams failed, exception is " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
    
        if (java.lang.Math.abs(r1 - r0.longValue()) > 100) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void D2(int i3, int i16, String str) {
        if (i16 == this.V && this.W == i3) {
            return;
        }
        Long l3 = this.f85399a0.get(str);
        if (l3 != null) {
            long j3 = i3;
            if (j3 != l3.longValue()) {
            }
            this.V = i16;
            this.W = i3;
            if (this.f85415q0 == null) {
                this.f85415q0 = new com.tencent.biz.qqcircle.immersive.feed.event.an();
            }
            this.f85415q0.h(i3);
            this.f85415q0.j(i16);
            this.f85415q0.i(this.Z);
            this.f85415q0.k(this.Y);
            T0(this.f85415q0);
            if (!this.f85414p0) {
                w3(i3, i16);
                return;
            }
            return;
        }
        this.f85399a0.put(str, Long.valueOf(i16));
        this.V = i16;
        this.W = i3;
        if (this.f85415q0 == null) {
        }
        this.f85415q0.h(i3);
        this.f85415q0.j(i16);
        this.f85415q0.i(this.Z);
        this.f85415q0.k(this.Y);
        T0(this.f85415q0);
        if (!this.f85414p0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E2(SeekBar seekBar, int i3, boolean z16) {
        TextView textView = this.T;
        if (textView != null && z16) {
            RFWTypefaceUtil.setNumberTypeface(textView, false);
            this.T.setText(com.tencent.biz.qqcircle.utils.cv.c(i3) + " / ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void F2(SeekBar seekBar) {
        String str;
        this.f85400b0 = true;
        this.R.setVisibility(0);
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        T t16 = this.f85017h;
        if (t16 == 0) {
            str = "";
        } else {
            str = ((FeedCloudMeta$StFeed) t16).f398449id.get();
        }
        simpleEventBus.dispatchEvent(new QFSSeekEvent(str, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void G2(SeekBar seekBar) {
        String str;
        this.f85400b0 = false;
        this.R.setVisibility(8);
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        T t16 = this.f85017h;
        if (t16 == 0) {
            str = "";
        } else {
            str = ((FeedCloudMeta$StFeed) t16).f398449id.get();
        }
        simpleEventBus.dispatchEvent(new QFSSeekEvent(str, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H2() {
        T0(new com.tencent.biz.qqcircle.immersive.feed.event.e(this.f85412n0.getTraceId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I2() {
        T0(new com.tencent.biz.qqcircle.immersive.feed.event.d(this.f85412n0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J2() {
        if (this.X == null) {
            this.X = new com.tencent.biz.qqcircle.immersive.feed.event.ao();
        }
        T0(this.X);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void K2(final ISuperPlayer iSuperPlayer) {
        if (this.I != null && this.f85017h != 0 && iSuperPlayer != null && e3()) {
            ISPlayerVideoView iSPlayerVideoView = (ISPlayerVideoView) this.I.getQCirclePlayer().getVideoView();
            ((ISPlayerVideoView) this.I.getQCirclePlayer().getVideoView()).setFixedSize(((FeedCloudMeta$StFeed) this.f85017h).video.width.get(), ((FeedCloudMeta$StFeed) this.f85017h).video.height.get());
            if (!TransitionHelper.shouldVideoYFullScreen(((FeedCloudMeta$StFeed) this.f85017h).video.width.get(), ((FeedCloudMeta$StFeed) this.f85017h).video.height.get()) && (!TransitionHelper.isFolderScreenOpenMode(this.J.getContext()) || I0())) {
                iSPlayerVideoView.setXYaxis(2);
            } else {
                iSPlayerVideoView.setXYaxis(0);
            }
            QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_START_PLAY);
            M2();
            r3(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_START_PLAY);
            this.I.start();
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdVideoPresenter.9
                @Override // java.lang.Runnable
                public void run() {
                    if (QFSFeedChildAdVideoPresenter.this.S != null) {
                        RFWTypefaceUtil.setNumberTypeface(QFSFeedChildAdVideoPresenter.this.S, false);
                        QFSFeedChildAdVideoPresenter.this.S.setText(com.tencent.biz.qqcircle.utils.cv.c((int) iSuperPlayer.getDurationMs()));
                    }
                    if (QFSFeedChildAdVideoPresenter.this.N != null) {
                        QFSFeedChildAdVideoPresenter.this.N.W();
                    }
                }
            });
        }
    }

    private void L2(QCircleFeedVideoControlEvent qCircleFeedVideoControlEvent) {
        if (qCircleFeedVideoControlEvent.isPlay() && m0() != null && m0().hashCode() != qCircleFeedVideoControlEvent.getHashCode()) {
            N2(false, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void M2() {
        if (this.I != null && this.f85017h != 0) {
            Map<String, ?> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(ua0.c.d(this.E));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.f85018i + 1));
            buildElementParams.put("xsj_custom_pgid", r0());
            buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            if (this.f85412n0.isValid()) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADS_ID, Long.valueOf(this.f85412n0.getAId()));
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADS_TRACE_ID, this.f85412n0.getTraceId());
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADS_POS_ID, this.f85412n0.getPosId());
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADS_URL, this.f85412n0.getUrlForClick());
            }
            buildElementParams.put("xsj_feed_id", this.E.g().f398449id.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, ((FeedCloudMeta$StFeed) this.f85017h).feedShowReason.showReason.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_TYPE, 5);
            VideoEntity build = new VideoEntity.Builder().setContentId(this.E.g().f398449id.get()).setPage((Object) r0()).setContentType(2).setVideoDuration(this.Y).setVideoView((View) this.I).addCustomParams(buildElementParams).ignoreReport(false).bizReady(true).build();
            ISuperPlayer superPlayer = this.I.getSuperPlayer();
            if (superPlayer != null) {
                VideoReport.bindVideoPlayerInfo(superPlayer, build);
            }
        }
    }

    private void N2(boolean z16, RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (A2()) {
            A3(true);
            return;
        }
        if (this.I.getSuperPlayer() == null) {
            RFWLog.d("QFSFeedAdChildVideoPresenter", RFWLog.USR, "[executePlay] getSuperPlayer null:" + hashCode());
            y3(z16, rFWFeedSelectInfo);
            return;
        }
        if (!this.I.isRelease() && !this.I.getQCirclePlayer().isDeInit()) {
            if (this.I.getSuperPlayer().isPlaying()) {
                RFWLog.d("QFSFeedAdChildVideoPresenter", RFWLog.USR, "[executePlay] isPlaying when resume:" + hashCode());
                return;
            }
            if (this.I.getSuperPlayer().isPausing()) {
                n();
                RFWLog.d("QFSFeedAdChildVideoPresenter", RFWLog.USR, "[executePlay] startFromPause hashCode:" + hashCode());
                return;
            }
            y3(z16, rFWFeedSelectInfo);
            return;
        }
        RFWLog.d("QFSFeedAdChildVideoPresenter", RFWLog.USR, "[executePlay] execute a new player released" + hashCode());
        y3(z16, rFWFeedSelectInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void P2(QCircleFeedVideoCurrentTimeEvent qCircleFeedVideoCurrentTimeEvent) {
        T t16 = this.f85017h;
        if (t16 != 0 && ((FeedCloudMeta$StFeed) t16).video != null && ((FeedCloudMeta$StFeed) t16).video.playUrl != null && qCircleFeedVideoCurrentTimeEvent != null) {
            String N = com.tencent.biz.qqcircle.immersive.utils.r.N(((FeedCloudMeta$StFeed) t16).video.playUrl.get());
            if (!TextUtils.isEmpty(N) && this.f85399a0.containsKey(N)) {
                this.f85399a0.replace(N, Long.valueOf(qCircleFeedVideoCurrentTimeEvent.getCurrentTime()));
            }
        }
    }

    private Drawable Q2() {
        if (s0() != null && s0().getTransitionLoadingDrawable() != null) {
            return s0().getTransitionLoadingDrawable();
        }
        return new ColorDrawable(QCircleSkinHelper.getInstance().getColor(R.color.cje));
    }

    private int R2(RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (rFWFeedSelectInfo == null) {
            return -1;
        }
        int position = rFWFeedSelectInfo.getPosition();
        int nextPosition = rFWFeedSelectInfo.getNextPosition();
        if (nextPosition == 0) {
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

    private void S2(QCircleAdClickEvent qCircleAdClickEvent) {
        if (TextUtils.equals(qCircleAdClickEvent.getMTraceId(), this.f85412n0.getTraceId())) {
            C3("ft", "2");
        }
    }

    private void T2(com.tencent.biz.qqcircle.immersive.feed.event.f fVar) {
        if (TextUtils.equals(fVar.getMTraceId(), this.f85412n0.getTraceId())) {
            ValueAnimator valueAnimator = this.f85411m0;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.I.getSuperPlayer().seekTo(0);
            this.I.start();
        }
    }

    private void U2(@NonNull QCirclePanelStateEvent qCirclePanelStateEvent) {
        if (!TextUtils.equals(qCirclePanelStateEvent.getFeedId(), j())) {
            return;
        }
        z3(!this.f85413o0);
    }

    private void V2(QCircleConfigChangeEvent qCircleConfigChangeEvent) {
        if (qCircleConfigChangeEvent.configuration == null) {
            return;
        }
        int instantScreenHeight = DisplayUtil.getInstantScreenHeight(this.J.getContext());
        QLog.d("QFSFeedAdChildVideoPresenter", 1, "onConfigChange disPlayWidth:|mScreenWidth" + DisplayUtil.getInstantScreenWidth(this.J.getContext()) + "|mScreenHeight" + instantScreenHeight);
        W(this.I, this.J);
    }

    private void W2(QCircleVideoRateEvent qCircleVideoRateEvent) {
        QFSVideoView qFSVideoView;
        e30.b bVar = this.E;
        if (bVar != null && bVar.g().f398449id.get().equals(qCircleVideoRateEvent.getFeedId()) && (qFSVideoView = this.I) != null) {
            qFSVideoView.setPlayRate(qCircleVideoRateEvent.getSelectedRate());
        }
    }

    private void Y2(QCircleFrameEvent qCircleFrameEvent) {
        int i3 = qCircleFrameEvent.mRefreshTab;
        if (i3 == 0 || i3 == 1) {
            u3(5);
        }
    }

    private void Z2(boolean z16) {
        int i3;
        if (this.N == null) {
            return;
        }
        View view = this.f85016f;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    private void a3(boolean z16) {
        int i3;
        View view = this.f85016f;
        if (view == null) {
            QLog.d("QFSFeedAdChildVideoPresenter", 1, "[hideVideoContainer] container should not be null.");
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void b3() {
        QFSVideoView qFSVideoView = this.I;
        if (qFSVideoView == null) {
            return;
        }
        qFSVideoView.setLoadingView(this.P);
        this.I.setProgressBar(this.N);
    }

    private void c3() {
        try {
            this.f85404f0.put("bt", "0");
            this.f85404f0.put(FileReaderHelper.ET_EXT, "0");
            this.f85404f0.put("bf", "0");
            this.f85404f0.put("ef", "0");
            this.f85404f0.put("pp", "0");
            this.f85404f0.put("pa", "0");
            this.f85404f0.put("ft", "0");
            this.f85404f0.put(Constants.KEYS.PLACEMENTS, "0");
            this.f85404f0.put("pt", "0");
        } catch (JSONException e16) {
            QLog.e("QFSFeedAdChildVideoPresenter", 1, "initVideoReportParams failed, exception is " + e16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean d3() {
        T t16 = this.f85017h;
        if (t16 != 0 && ((FeedCloudMeta$StFeed) t16).type.get() == 3 && !af.T(this.f85412n0)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e3() {
        QCircleInitBean mInitBean;
        boolean z16;
        boolean isOnThirdTab = ASInject.g().getAsEngineDelegate().isOnThirdTab(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE);
        HashMap<String, String> hashMap = null;
        if (s0() == null) {
            mInitBean = null;
        } else {
            mInitBean = s0().getMInitBean();
        }
        if (mInitBean != null) {
            hashMap = s0().getMInitBean().getSchemeAttrs();
        }
        if (hashMap != null && String.valueOf(11).equals(hashMap.get("key_jump_from"))) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean a16 = com.tencent.biz.qqcircle.utils.ae.a(mInitBean);
        boolean isTopActivityInQCircle = QCirclePluginUtil.isTopActivityInQCircle((Activity) m0());
        QLog.d("QFSFeedAdChildVideoPresenter", 1, "isFeedOnScreen:" + E0() + " isOnThirdTab:" + isOnThirdTab + " pageId:" + y0() + "| isFromBottom" + z16 + "| isShowSplash" + a16 + "| isQCircleTopActivity" + isTopActivityInQCircle + hashCode());
        if (E0() && ((isOnThirdTab || !QCirclePluginUtil.isTabMode() || !z16) && !a16 && isTopActivityInQCircle)) {
            QLog.d("QFSFeedAdChildVideoPresenter", 1, "isOnScreen:true");
            return true;
        }
        QLog.d("QFSFeedAdChildVideoPresenter", 1, "isOnScreen:false");
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean f3() {
        T t16;
        if (this.f85401c0 != null && (t16 = this.f85017h) != 0 && this.f85402d0 == this.f85018i) {
            try {
                if (((FeedCloudMeta$StFeed) t16).f398449id.get().equals(this.f85401c0.f398449id.get()) && ((FeedCloudMeta$StFeed) this.f85017h).video.playUrl.get().equals(this.f85401c0.video.playUrl.get())) {
                    QLog.d("QFSFeedAdChildVideoPresenter", 1, "fs_lifecycle , same video, playUrl = " + this.f85401c0.video.playUrl.get());
                    return true;
                }
            } catch (Exception e16) {
                QLog.d("QFSFeedAdChildVideoPresenter", 1, "same video, exception = " + e16.getMessage());
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g3(QFSFeedChildAdVideoPresenter qFSFeedChildAdVideoPresenter, SimpleBaseEvent simpleBaseEvent) {
        qFSFeedChildAdVideoPresenter.L2((QCircleFeedVideoControlEvent) simpleBaseEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h3(QFSFeedChildAdVideoPresenter qFSFeedChildAdVideoPresenter, SimpleBaseEvent simpleBaseEvent) {
        qFSFeedChildAdVideoPresenter.P2((QCircleFeedVideoCurrentTimeEvent) simpleBaseEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i3(QFSFeedChildAdVideoPresenter qFSFeedChildAdVideoPresenter, SimpleBaseEvent simpleBaseEvent) {
        qFSFeedChildAdVideoPresenter.U2((QCirclePanelStateEvent) simpleBaseEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String j() {
        T t16 = this.f85017h;
        if (t16 == 0) {
            return "";
        }
        return ((FeedCloudMeta$StFeed) t16).f398449id.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j3(QFSFeedChildAdVideoPresenter qFSFeedChildAdVideoPresenter, SimpleBaseEvent simpleBaseEvent) {
        qFSFeedChildAdVideoPresenter.V2((QCircleConfigChangeEvent) simpleBaseEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k3(QFSFeedChildAdVideoPresenter qFSFeedChildAdVideoPresenter, SimpleBaseEvent simpleBaseEvent) {
        qFSFeedChildAdVideoPresenter.W2((QCircleVideoRateEvent) simpleBaseEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l3(QFSFeedChildAdVideoPresenter qFSFeedChildAdVideoPresenter, SimpleBaseEvent simpleBaseEvent) {
        qFSFeedChildAdVideoPresenter.Y2((QCircleFrameEvent) simpleBaseEvent);
    }

    private void n() {
        QFSVideoView qFSVideoView = this.I;
        if (qFSVideoView != null && qFSVideoView.getSuperPlayer() != null && this.I.getSuperPlayer().isPausing()) {
            C3("bt", String.valueOf(this.f85408j0));
            M2();
            this.I.start();
            B2(true);
            T0(new com.tencent.biz.qqcircle.immersive.feed.event.ap(false));
            this.U.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n3(QFSFeedChildAdVideoPresenter qFSFeedChildAdVideoPresenter, SimpleBaseEvent simpleBaseEvent) {
        qFSFeedChildAdVideoPresenter.S2((QCircleAdClickEvent) simpleBaseEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void o3(String str) {
        QFSVideoView qFSVideoView;
        T t16 = this.f85017h;
        if (t16 != 0 && ((FeedCloudMeta$StFeed) t16).f398449id.get().equals(str) && (qFSVideoView = this.I) != null && qFSVideoView.getSuperPlayer() != null) {
            if (this.I.getSuperPlayer().isPlaying()) {
                C3("ft", "1");
                p3(true);
                this.N.T();
                s3();
                C3("bf", "0");
                f85397r0 = true;
                return;
            }
            if (this.I.getSuperPlayer().isPausing()) {
                C3("pa", "12");
                this.N.X();
                n();
                f85397r0 = false;
            }
        }
    }

    private void p3(boolean z16) {
        QFSVideoView qFSVideoView = this.I;
        if (qFSVideoView != null && qFSVideoView.getSuperPlayer() != null) {
            if (this.I.getSuperPlayer().isPlaying()) {
                VideoReport.unbindVideoPlayerInfo(this.I);
                this.I.pause();
                T0(new com.tencent.biz.qqcircle.immersive.feed.event.ap(true));
                int i3 = 0;
                if (!z16) {
                    this.U.setVisibility(0);
                    QLog.d("QFSFeedAdChildVideoPresenter", 1, "[pausePlayer] current show panel player recover, not show play icon.");
                } else {
                    QUIPlayIconView qUIPlayIconView = this.U;
                    if (!z16) {
                        i3 = 8;
                    }
                    qUIPlayIconView.setVisibility(i3);
                }
                C3("ef", "0");
                if (!this.f85414p0) {
                    w3(this.W, this.V);
                }
            }
            t3(400, 5, r(), "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r3(String str) {
        t40.f j16 = j1();
        if (j16 != null) {
            j16.i8(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s3() {
        if (TextUtils.isEmpty(this.f85405g0)) {
            QLog.i("QFSFeedAdChildVideoPresenter", 1, "videoReportUrl is empty, cancel video report");
        } else {
            com.tencent.biz.qqcircle.immersive.utils.d.f90201a.d(String.format(Locale.CHINA, "%s&video=%s", this.f85405g0, URLEncoder.encode(this.f85404f0.toString())));
            C3("ft", "0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t3(int i3, int i16, QCircleExtraTypeInfo qCircleExtraTypeInfo, String str, String str2) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        if (qCircleExtraTypeInfo != null && (feedCloudMeta$StFeed = qCircleExtraTypeInfo.mFeed) != null) {
            QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder(ua0.c.c(feedCloudMeta$StFeed));
            dataBuilder.setActionType(i3).setSubActionType(i16).setToUin(qCircleExtraTypeInfo.mFeed.poster.f398463id.get()).setPosition(qCircleExtraTypeInfo.mDataPosition).setPlayScene(qCircleExtraTypeInfo.mPlayScene).setVideoPlayTime(this.f85409k0).setSealTransfer(qCircleExtraTypeInfo.mFeed.recomInfo.recomTrace.get()).setExt1(str).setExt4(str2).setPageId(y0()).setFeedType1(5).setFeedType2(1).setfpageid(Integer.valueOf(t0()).intValue()).setFirstFeedId(w20.a.j().h());
            QCircleLpReportDc05507.report(dataBuilder);
        } else {
            QLog.e("QCircleReportHelper_QFSFeedAdChildVideoPresenter", 1, "extraTypeInfo is null or lost feed,actionType:" + i3 + ",subActionType:" + i16);
        }
    }

    private void u3(int i3) {
        if (i3 == -1) {
            return;
        }
        Gson gson = new Gson();
        HashMap hashMap = new HashMap();
        hashMap.put(QFS5507ReportHelper.JsonKey.END_TYPE, Integer.valueOf(i3));
        t3(400, 5, r(), "", gson.toJson(hashMap));
    }

    private void v3() {
        this.W = 0;
        this.V = 0;
        this.Z = 0;
        this.f85409k0 = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void w3(int i3, int i16) {
        String str;
        t40.a s06 = s0();
        if (s06 == null) {
            return;
        }
        if (this.f85407i0 == null) {
            this.f85407i0 = new QFSVideoFeedPlayEvent();
        }
        QFSVideoFeedPlayEvent qFSVideoFeedPlayEvent = this.f85407i0;
        qFSVideoFeedPlayEvent.indexInFeed = this.f85018i;
        qFSVideoFeedPlayEvent.progress = i16;
        qFSVideoFeedPlayEvent.duration = i3;
        qFSVideoFeedPlayEvent.loopCount = this.Z;
        qFSVideoFeedPlayEvent.globalKey = s06.getViewModelKey();
        QFSVideoFeedPlayEvent qFSVideoFeedPlayEvent2 = this.f85407i0;
        T t16 = this.f85017h;
        String str2 = "";
        if (t16 == 0) {
            str = "";
        } else {
            str = ((FeedCloudMeta$StFeed) t16).video.playUrl.get();
        }
        qFSVideoFeedPlayEvent2.playUrl = str;
        QFSVideoFeedPlayEvent qFSVideoFeedPlayEvent3 = this.f85407i0;
        T t17 = this.f85017h;
        if (t17 != 0) {
            str2 = ((FeedCloudMeta$StFeed) t17).f398449id.get();
        }
        qFSVideoFeedPlayEvent3.feedId = str2;
        SimpleEventBus.getInstance().dispatchEvent(this.f85407i0);
    }

    private long x3(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QCircleInitBean qCircleInitBean;
        String N = com.tencent.biz.qqcircle.immersive.utils.r.N(feedCloudMeta$StFeed.video.playUrl.get());
        if (s0() != null) {
            qCircleInitBean = s0().getMInitBean();
        } else {
            qCircleInitBean = null;
        }
        long videoStartOffsetFromScheme = QCirclePluginUtil.getVideoStartOffsetFromScheme(qCircleInitBean, feedCloudMeta$StFeed);
        this.f85399a0.put(N, Long.valueOf(videoStartOffsetFromScheme));
        return videoStartOffsetFromScheme;
    }

    private void y2(RFWPlayerOptions rFWPlayerOptions, String str) {
        rFWPlayerOptions.setPlayIOC(new a());
        rFWPlayerOptions.getListenerSet().addSDKInitListeners(new b());
        rFWPlayerOptions.getListenerSet().addPrepareListeners(new c());
        rFWPlayerOptions.getListenerSet().addSeekListeners(new d(str));
        rFWPlayerOptions.getListenerSet().addLooperListeners(new e());
        rFWPlayerOptions.getListenerSet().addCompletionListener(new f());
        rFWPlayerOptions.getListenerSet().addErrorStatusListener(new g());
        rFWPlayerOptions.getListenerSet().addLifeCycleListeners(new h());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void y3(boolean z16, RFWFeedSelectInfo rFWFeedSelectInfo) {
        long j3;
        String str;
        QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_AUTO_PLAY);
        t40.f j16 = j1();
        if (j16 != null) {
            j16.Gd();
        }
        r3(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_AUTO_PLAY);
        if (!d3()) {
            QLog.d("QFSFeedAdChildVideoPresenter", 1, "fs_lifecycle startANewPlayer not video type, return");
            return;
        }
        t1();
        boolean z17 = false;
        A3(false);
        n1();
        q50.b.e().o(this.K);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) this.f85017h;
        this.I.setData(feedCloudMeta$StFeed, this.f85018i);
        QFSVideoView.D = new WeakReference<>(this.I);
        String N = com.tencent.biz.qqcircle.immersive.utils.r.N(feedCloudMeta$StFeed.video.playUrl.get());
        if (z16 && this.f85399a0.containsKey(N)) {
            j3 = this.f85399a0.get(N).longValue();
        } else {
            j3 = 0;
        }
        RFWPlayerOptions addAttachInfo = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).setFileId(feedCloudMeta$StFeed.video.fileId.get()).setPlayUrl(feedCloudMeta$StFeed.video.playUrl.get()).setStVideo(gb0.b.k(feedCloudMeta$StFeed.video)).setStartOffset(j3).setFromType(5).setEnableDataCollect(true).addAttachInfo("ATTACH_INFO_KEY_POI", Integer.valueOf(this.f85018i));
        if (rFWFeedSelectInfo != null && rFWFeedSelectInfo.isScrollToNext()) {
            z17 = true;
        }
        RFWPlayerOptions addAttachInfo2 = addAttachInfo.addAttachInfo("ATTACH_INFO_KEY_SCROLL_NEXT", Boolean.valueOf(z17));
        if (rFWFeedSelectInfo != null) {
            str = rFWFeedSelectInfo.getSelectedType();
        } else {
            str = "";
        }
        RFWPlayerOptions addAttachInfo3 = addAttachInfo2.addAttachInfo("ATTACH_INFO_KEY_SELECTED_TYPE", str);
        y2(addAttachInfo3, N);
        QLog.d("QFSFeedAdChildVideoPresenter", 1, "fs_lifecycle  startANewPlayer ,tag:" + addAttachInfo3.tag() + " , playUrlKey:" + N + " , containsKey: " + this.f85399a0.containsKey(N) + " , feedId: " + feedCloudMeta$StFeed.f398449id.get() + " , hashcode: " + hashCode() + " , traceId: " + com.tencent.biz.qqcircle.immersive.utils.ba.d(feedCloudMeta$StFeed));
        this.I.loadPlayOptions(addAttachInfo3);
        z3(this.f85413o0 ^ true);
        r3(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_SET_VIDEO_PATH);
        this.f85401c0 = (FeedCloudMeta$StFeed) this.f85017h;
        this.f85402d0 = this.f85018i;
        QUIPlayIconView qUIPlayIconView = this.U;
        if (qUIPlayIconView != null) {
            qUIPlayIconView.setVisibility(8);
        }
        QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_SET_VIDEO_PATH);
        if (!this.f85414p0) {
            w3(this.W, this.V);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void z2() {
        if (super.h1()) {
            QLog.d("QFSFeedAdChildVideoPresenter", 1, "[bindCover] bind current frame bitmap.");
            return;
        }
        if (this.J == null) {
            return;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) this.f85017h;
        if (TextUtils.isEmpty(feedCloudMeta$StFeed.cover.layerPicUrl.get())) {
            this.K = Option.obtain().setUrl(feedCloudMeta$StFeed.cover.picUrl.get()).setTargetView(this.J);
        } else {
            this.K = Option.obtain().setUrl(feedCloudMeta$StFeed.cover.layerPicUrl.get()).setTargetView(this.J);
        }
        this.K.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        this.K.setLoadingDrawable(Q2());
        this.K.setSupportRecycler(true);
        QCircleFeedPicLoader.g().loadImage(this.K);
    }

    private void z3(boolean z16) {
        if (this.I == null) {
            return;
        }
        this.f85403e0 = z16;
        QLog.d("QFSFeedAdChildVideoPresenter", 2, "[updateAutoScroll] mIsLoopBack: ", Boolean.valueOf(z16), " | mIsAutoScroll: ", Boolean.valueOf(this.f85413o0));
        this.I.setLoopBack(z16);
    }

    public void A3(boolean z16) {
        t40.f j16 = j1();
        if (j16 != null) {
            j16.P7(z16);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        View view;
        super.C0(hVar);
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.ak) {
            if (af.T(this.f85412n0)) {
                QLog.d("QFSFeedAdChildVideoPresenter", 1, "[handle QFSTapClickEvent] pic type, return.");
                return;
            }
            com.tencent.biz.qqcircle.immersive.feed.event.ak akVar = (com.tencent.biz.qqcircle.immersive.feed.event.ak) hVar;
            MotionEvent a16 = akVar.a();
            if (a16 != null && (view = this.f85016f) != null) {
                int height = view.getHeight();
                float y16 = a16.getY();
                com.tencent.biz.qqcircle.immersive.utils.ad.a aVar = com.tencent.biz.qqcircle.immersive.utils.ad.a.f90082a;
                boolean a17 = aVar.a(this.f85412n0, this.V, this.Y, height, y16);
                boolean b16 = aVar.b(this.f85412n0, height, y16);
                QLog.d("QFSFeedAdChildVideoPresenter", 1, "handleBroadcastMessage mCurrentPosition: " + this.V + "|mTotalDuration:" + this.Y + "|heightPx: " + height + "|touchY: " + y16 + "|canOpenLandingPageInFullScreen: " + a17 + "|canOpenLandingPageInVideoArea: " + b16);
                if (!a17 && !b16) {
                    o3(akVar.b());
                    return;
                } else {
                    com.tencent.biz.qqcircle.immersive.utils.j.f90213a.K(this.f85412n0, this.f85016f, this.f85018i, r(), 6);
                    return;
                }
            }
            o3(akVar.b());
            return;
        }
        if (!(hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.f) || af.T(this.f85412n0)) {
            return;
        }
        T2((com.tencent.biz.qqcircle.immersive.feed.event.f) hVar);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public boolean D0(e40.p pVar) {
        super.D0(pVar);
        return this.f85400b0;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        String str;
        super.K0();
        QFSVideoView qFSVideoView = this.I;
        if (qFSVideoView != null) {
            qFSVideoView.setReportBean(getReportBean());
        }
        C3("bt", String.valueOf(this.f85408j0));
        if (this.f85408j0 == 0) {
            str = "1";
        } else {
            str = "0";
        }
        C3("bf", str);
        QLog.d("QFSFeedAdChildVideoPresenter", 1, "onAttachedToWindow  | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        super.M0();
        QLog.d("QFSFeedAdChildVideoPresenter", 1, "[onDetachedFromWindow] mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
        this.f85400b0 = false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.d, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.U = (QUIPlayIconView) this.f85016f.findViewById(R.id.va5);
        this.N = (QFSSeekBar) view.findViewById(R.id.vad);
        this.P = view.findViewById(R.id.vai);
        if (DisplayUtil.getScreenWidth() == 1080 && this.N != null) {
            this.N.setMinimumHeight(DisplayUtil.dp2pxScreenDensity3(view.getContext(), 1.0f));
        }
        this.Q = (LinearLayout) view.findViewById(R.id.f46311u9);
        this.R = (LinearLayout) view.findViewById(R.id.vac);
        this.S = (TextView) view.findViewById(R.id.vah);
        this.T = (TextView) view.findViewById(R.id.vag);
        b3();
        this.f85414p0 = uq3.c.h0();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.d
    protected void a() {
        QFSVideoView qFSVideoView = this.I;
        if (qFSVideoView == null) {
            return;
        }
        VideoReport.unbindVideoPlayerInfo(qFSVideoView);
        this.I.release();
        B2(false);
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
        eventClass.add(QCircleSeekAreaEvent.class);
        eventClass.add(QCircleVideoRateEvent.class);
        eventClass.add(QCircleAdClickEvent.class);
        return eventClass;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.d
    protected void i1(RFWFeedSelectInfo rFWFeedSelectInfo) {
        boolean z16 = true;
        if (!A2() && (!f3() || e1(this.I))) {
            QLog.d("QFSFeedAdChildVideoPresenter", 1, "executeFromSelected");
            if ((rFWFeedSelectInfo == null || !TextUtils.equals(rFWFeedSelectInfo.getSelectedType(), "TYPE_SELECT_ADAPTER_BIND_HOLDER")) && x3((FeedCloudMeta$StFeed) this.f85017h) <= 0) {
                z16 = false;
            }
            y3(z16, rFWFeedSelectInfo);
            return;
        }
        QLog.d("QFSFeedAdChildVideoPresenter", 1, "executeFromSelected return");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.d
    protected void k1(@NonNull ASEngineTabStatusEvent aSEngineTabStatusEvent) {
        super.k1(aSEngineTabStatusEvent);
        if (!aSEngineTabStatusEvent.isSelected() && QCirclePluginUtil.isQFSTabNativeFragmentMode(m0())) {
            p3(false);
            this.f85401c0 = null;
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        super.onDestroy();
        QLog.d("QFSFeedAdChildVideoPresenter", 1, "fs_lifecycle onDestroy: | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | playView is null | pageId:" + y0());
        a();
        this.f85401c0 = null;
        this.f85402d0 = 0;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.d, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (rFWFeedSelectInfo == null) {
            return;
        }
        QLog.d("QFSFeedAdChildVideoPresenter", 1, "fs_lifecycle onSelected:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
        if (rFWFeedSelectInfo.getPosition() != this.f85018i) {
            return;
        }
        ValueAnimator valueAnimator = this.f85411m0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        GdtAd gdtAd = this.f85412n0;
        if (gdtAd != null && !TextUtils.isEmpty(gdtAd.getTraceId())) {
            v.c(this.f85412n0.getTraceId());
            v.b(this.f85412n0.getTraceId());
        }
        W(this.I, this.J);
        this.f85408j0 = 0;
        c3();
        i1(rFWFeedSelectInfo);
        v3();
        cc0.e.d(System.currentTimeMillis(), rFWFeedSelectInfo.getPosition());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo == null || rFWFeedSelectInfo.getPosition() != this.f85018i) {
            return;
        }
        C3("ft", "3");
        QFSVideoView qFSVideoView = this.I;
        if (qFSVideoView == null || qFSVideoView.getSuperPlayer() == null || this.I.getSuperPlayer().isPlaying()) {
            s3();
        }
        QLog.d("QFSFeedAdChildVideoPresenter", 1, "onUnSelected:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
        this.f85401c0 = null;
        this.f85402d0 = 0;
        a();
        u3(R2(rFWFeedSelectInfo));
        t3(400, 3, r(), "", "");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onPaused(rFWFeedSelectInfo);
        QLog.d("QFSFeedAdChildVideoPresenter", 1, "fs_lifecycle onPaused:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + APLogFileUtil.SEPARATOR_LOG + hashCode());
        if (QCirclePluginUtil.isSharePanelOnShow()) {
            QLog.d("QFSFeedAdChildVideoPresenter", 1, "isSharePanelOnShow don't release player | pageId:" + y0());
            return;
        }
        ValueAnimator valueAnimator = this.f85411m0;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
        B3();
        p3(false);
        if (this.f85401c0 == null) {
            return;
        }
        s3();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.d, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        for (Class cls : f85398s0.keySet()) {
            if (simpleBaseEvent.getClass() == cls) {
                f85398s0.get(cls).a(this, simpleBaseEvent);
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onResumed(rFWFeedSelectInfo);
        GdtAd gdtAd = this.f85412n0;
        if (gdtAd != null && !TextUtils.isEmpty(gdtAd.getTraceId())) {
            v.c(this.f85412n0.getTraceId());
        }
        if (this.I == null) {
            QLog.d("QFSFeedAdChildVideoPresenter", 1, "onResumed:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + APLogFileUtil.SEPARATOR_LOG + hashCode() + "|playView is null");
            return;
        }
        if (rFWFeedSelectInfo == null) {
            return;
        }
        if (this.f85018i == rFWFeedSelectInfo.getPosition()) {
            z3(!this.f85413o0);
            W(this.I, this.J);
            N2(true, rFWFeedSelectInfo);
        }
        ValueAnimator valueAnimator = this.f85411m0;
        if (valueAnimator != null) {
            valueAnimator.resume();
        }
        QLog.d("QFSFeedAdChildVideoPresenter", 1, "fs_lifecycle onResumed:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onStop(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onStop(rFWFeedSelectInfo);
        QLog.d("QFSFeedAdChildVideoPresenter", 1, "fs_lifecycle onStop:" + rFWFeedSelectInfo + " |  | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | playView is null | pageId:" + y0());
        B3();
        p3(false);
        C3("bf", "0");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public void onViewHolderDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewHolderDetachedFromWindow(viewHolder);
        QLog.d("QFSFeedAdChildVideoPresenter", 1, "fs_lifecycle onViewHolderDetachedFromWindow: | mPos:" + this.f85018i + " | holder.pos:" + viewHolder.getAdapterPosition() + " | hashCode:" + hashCode() + " | pageId:" + y0());
        a();
        this.f85401c0 = null;
        this.f85402d0 = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [feedcloud.FeedCloudMeta$StFeed, T] */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: s1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        FeedCloudMeta$StFeed g16;
        if (C2(feedCloudMeta$StFeed, i3)) {
            return;
        }
        super.L0(feedCloudMeta$StFeed, i3);
        this.f85017h = u.c(this.E);
        this.f85412n0 = new GdtAd(u.e(this.E));
        if (this.f85017h == 0) {
            QLog.e("QFSFeedAdChildVideoPresenter", 1, "[onBindData] mData is null, adFeed transform error.");
        }
        if (((FeedCloudMeta$StFeed) this.f85017h).type.get() != 3) {
            a3(false);
            Z2(false);
            QLog.d("QFSFeedAdChildVideoPresenter", 1, "[onBindData] not ad video type.");
            return;
        }
        QUIPlayIconView qUIPlayIconView = this.U;
        if (qUIPlayIconView != null) {
            qUIPlayIconView.setVisibility(8);
        }
        a3(true);
        Z2(true);
        LinearLayout linearLayout = this.Q;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        QFSSeekBar qFSSeekBar = this.N;
        if (qFSSeekBar != null) {
            qFSSeekBar.W();
        }
        U0(ae.b(this.E.g(), i3));
        e30.b bVar = this.E;
        if (bVar == null) {
            g16 = null;
        } else {
            g16 = bVar.g();
        }
        this.f85413o0 = af.h(g16, (FeedCloudMeta$StFeed) this.f85017h, this.f85412n0);
        if (af.T(this.f85412n0)) {
            a3(false);
            Z2(false);
            QLog.d("QFSFeedAdChildVideoPresenter", 1, "[onBindData] ad inner show type pic.");
        } else {
            this.f85406h0 = this.f85412n0.info.report_info.thirdparty_monitor_urls.video_play_duration.get();
            this.f85405g0 = this.f85412n0.getVideoReportUrl();
            W(this.I, this.J);
            z2();
            B2(false);
            this.Y = ((FeedCloudMeta$StFeed) this.f85017h).video.duration.get();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedAdChildVideoPresenter";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class f implements IRFWPlayerCompletionListener {
        f() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerCompletionListener
        public void onCompletion(ISuperPlayer iSuperPlayer) {
            QFSFeedChildAdVideoPresenter.this.H2();
            QFSFeedChildAdVideoPresenter.this.C3("ef", "1");
            QFSFeedChildAdVideoPresenter.this.s3();
            if (TextUtils.equals(af.v((FeedCloudMeta$StFeed) ((QFSBaseFeedChildPresenter) QFSFeedChildAdVideoPresenter.this).f85017h), "0")) {
                return;
            }
            QFSFeedChildAdVideoPresenter.this.f85411m0 = ValueAnimator.ofInt(0, 1);
            QFSFeedChildAdVideoPresenter.this.f85411m0.setInterpolator(new DecelerateInterpolator());
            QFSFeedChildAdVideoPresenter.this.f85411m0.setDuration(Integer.parseInt(af.v((FeedCloudMeta$StFeed) ((QFSBaseFeedChildPresenter) QFSFeedChildAdVideoPresenter.this).f85017h)) * 1000);
            QFSFeedChildAdVideoPresenter.this.f85411m0.addListener(new a());
            QFSFeedChildAdVideoPresenter.this.f85411m0.start();
        }

        /* loaded from: classes4.dex */
        class a extends com.tencent.mobileqq.widget.ak {
            a() {
            }

            @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                QFSFeedChildAdVideoPresenter.this.S0();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }
    }
}
