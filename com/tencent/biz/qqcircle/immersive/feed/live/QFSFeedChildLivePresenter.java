package com.tencent.biz.qqcircle.immersive.feed.live;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleFeedVideoControlEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedVideoCurrentTimeEvent;
import com.tencent.biz.qqcircle.events.QCircleShareItemClickEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.live.LiveRetryPlayerCtrl;
import com.tencent.biz.qqcircle.immersive.feed.live.QFSFeedChildLivePresenter;
import com.tencent.biz.qqcircle.immersive.utils.ah;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.utils.ae;
import com.tencent.biz.qqcircle.utils.bj;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerUpperData;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qqlive.api.displayview.IDisplayViewApi;
import com.tencent.mobileqq.qqlive.api.monitor.IResourceProvider;
import com.tencent.mobileqq.qqlive.api.monitor.ISuperPlayerTrafficFlowReportApi;
import com.tencent.mobileqq.qqlive.api.monitor.ISuperPlayerTrafficFlowReporter;
import com.tencent.mobileqq.qqlive.api.player.IPlayerChangeUrlManager;
import com.tencent.mobileqq.qqlive.api.room.QCircleLiveFeedReplaceSurfaceEvent;
import com.tencent.mobileqq.qqlive.api.room.QCircleLiveFeedsPlayerEvent;
import com.tencent.mobileqq.qqlive.utils.QQLiveFolderScreenUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import cooperation.qqcircle.QCircleConfig;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05502;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLive;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class QFSFeedChildLivePresenter extends com.tencent.biz.qqcircle.immersive.feed.d<FeedCloudMeta$StFeed> {

    /* renamed from: o0, reason: collision with root package name */
    private static final Runnable f86232o0 = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.i
        @Override // java.lang.Runnable
        public final void run() {
            QFSFeedChildLivePresenter.V2();
        }
    };
    private View N;
    private Handler R;
    private TextView S;
    private e T;
    private com.tencent.biz.qqcircle.immersive.feed.live.b U;
    private com.tencent.biz.qqcircle.immersive.feed.live.a V;
    private boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f86233a0;

    /* renamed from: e0, reason: collision with root package name */
    private Option f86237e0;

    /* renamed from: g0, reason: collision with root package name */
    private IPlayerChangeUrlManager f86239g0;

    /* renamed from: n0, reason: collision with root package name */
    private ISuperPlayerTrafficFlowReporter f86246n0;
    private boolean P = true;
    private long Q = 0;
    private String W = "";
    private boolean X = false;
    private ConcurrentHashMap<String, Long> Y = new ConcurrentHashMap<>();

    /* renamed from: b0, reason: collision with root package name */
    private boolean f86234b0 = false;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f86235c0 = false;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f86236d0 = false;

    /* renamed from: f0, reason: collision with root package name */
    @VisibleForTesting
    boolean f86238f0 = false;

    /* renamed from: h0, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.feed.a f86240h0 = new com.tencent.biz.qqcircle.immersive.feed.a();

    /* renamed from: i0, reason: collision with root package name */
    private LiveRetryPlayerCtrl f86241i0 = new LiveRetryPlayerCtrl();

    /* renamed from: j0, reason: collision with root package name */
    private LiveRetryPlayerCtrl.b f86242j0 = new a();

    /* renamed from: k0, reason: collision with root package name */
    @VisibleForTesting
    boolean f86243k0 = false;

    /* renamed from: l0, reason: collision with root package name */
    private IAegisLogApi f86244l0 = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    /* renamed from: m0, reason: collision with root package name */
    private long f86245m0 = System.currentTimeMillis();

    /* loaded from: classes4.dex */
    class a implements LiveRetryPlayerCtrl.b {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.feed.live.LiveRetryPlayerCtrl.b
        public void onRetry() {
            QFSFeedChildLivePresenter.this.f86244l0.i("QFSFeedChildLivePresenter", "retryTime run, mSelected " + QFSFeedChildLivePresenter.this.f86238f0 + ", mIsLiveOver " + QFSFeedChildLivePresenter.this.f86243k0 + ", isOnScreen: " + QFSFeedChildLivePresenter.this.G2());
            QFSFeedChildLivePresenter qFSFeedChildLivePresenter = QFSFeedChildLivePresenter.this;
            if (qFSFeedChildLivePresenter.f86238f0 && !qFSFeedChildLivePresenter.f86243k0 && qFSFeedChildLivePresenter.G2()) {
                QFSFeedChildLivePresenter.this.k3(true, null);
            } else {
                QFSFeedChildLivePresenter.this.f86241i0.i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends RFWPlayerIOC {
        b() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QCircleReportBean getReportBean() {
            return QFSFeedChildLivePresenter.this.getReportBean();
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        public RFWPlayerReportInfo<e30.b> getBusinessReportInfo() {
            return gb0.b.m(((QFSBaseFeedChildPresenter) QFSFeedChildLivePresenter.this).E.o("KEY_RFW_VIDEO_FEED_POI", Integer.valueOf(((QFSBaseFeedChildPresenter) QFSFeedChildLivePresenter.this).f85018i)));
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        /* renamed from: getPlayerUpperData */
        public RFWPlayerUpperData getUpperData() {
            Context context;
            RFWPlayerUpperData dtCustomPgId = new RFWPlayerUpperData().setDtCustomPgId(QFSFeedChildLivePresenter.this.q0());
            if (((com.tencent.biz.qqcircle.immersive.feed.d) QFSFeedChildLivePresenter.this).I != null) {
                context = ((com.tencent.biz.qqcircle.immersive.feed.d) QFSFeedChildLivePresenter.this).I.getContext();
            } else {
                context = null;
            }
            return dtCustomPgId.setContext(context);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        public boolean isValid() {
            return QFSFeedChildLivePresenter.this.G2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements IRFWPlayerPrepareListener {
        c() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onFirstFrameRendered(RFWPlayer rFWPlayer) {
            QFSFeedChildLivePresenter.this.f86244l0.i("QFSFeedChildLivePresenter", 1, QFSFeedChildLivePresenter.this.x2() + " firstFrameRenderCallBack");
            QFSFeedChildLivePresenter.this.f86241i0.f();
            if (QFSFeedChildLivePresenter.this.f86246n0 != null) {
                QFSFeedChildLivePresenter.this.f86246n0.onPlayerFirstFrameCome();
            }
            QFSFeedChildLivePresenter.this.X = false;
            QFSFeedChildLivePresenter.this.o2(true);
            QFSFeedChildLivePresenter qFSFeedChildLivePresenter = QFSFeedChildLivePresenter.this;
            qFSFeedChildLivePresenter.R0(300, 4, qFSFeedChildLivePresenter.r(), "1");
            QFSFeedChildLivePresenter.this.f86245m0 = System.currentTimeMillis();
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onVideoPrepared(RFWPlayer rFWPlayer) {
            QFSFeedChildLivePresenter.this.r2(rFWPlayer.getRealPlayer());
            QFSFeedChildLivePresenter.this.f86244l0.i("QFSFeedChildLivePresenter", 1, "onVideoPrepared");
        }
    }

    private void A2(AnchorLiveStateChangeEvent anchorLiveStateChangeEvent) {
        if (anchorLiveStateChangeEvent.getRoomId() != x2()) {
            return;
        }
        this.f86243k0 = !anchorLiveStateChangeEvent.isLiving();
        if (anchorLiveStateChangeEvent.isLiving()) {
            return;
        }
        this.f86241i0.i();
        this.X = true;
        h3(false);
        TextView textView = this.S;
        if (textView != null) {
            textView.setText("\u76f4\u64ad\u5df2\u7ed3\u675f");
        }
    }

    private void B2(boolean z16) {
        int i3;
        View view = this.f85016f;
        if (view == null) {
            this.f86244l0.i("QFSFeedChildLivePresenter", 1, "[hideVideoContainer] container should not be null.");
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean E2() {
        T t16 = this.f85017h;
        if (t16 != 0 && ((FeedCloudMeta$StFeed) t16).type.get() == 4) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean G2() {
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
        boolean a16 = ae.a(mInitBean);
        boolean isTopActivityInQCircle = QCirclePluginUtil.isTopActivityInQCircle((Activity) this.I.getContext());
        this.f86244l0.i("QFSFeedChildLivePresenter", 1, "isFeedOnScreen:" + E0() + " isOnThirdTab:" + isOnThirdTab + " pageId:" + y0() + "| isFromBottom" + z16 + "| isShowSplash" + a16 + "| isQCircleTopActivity" + isTopActivityInQCircle + hashCode());
        if (E0() && ((isOnThirdTab || !QCirclePluginUtil.isTabMode() || !z16) && !a16 && isTopActivityInQCircle)) {
            this.f86244l0.i("QFSFeedChildLivePresenter", 1, "isOnScreen:true");
            return true;
        }
        this.f86244l0.i("QFSFeedChildLivePresenter", 1, "isOnScreen:false");
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean H2(QCircleLiveFeedsPlayerEvent qCircleLiveFeedsPlayerEvent) {
        long j3;
        T t16 = this.f85017h;
        if (t16 != 0 && ((FeedCloudMeta$StFeed) t16).live != null && ((FeedCloudMeta$StFeed) t16).live.room != null) {
            Bundle params = qCircleLiveFeedsPlayerEvent.getParams();
            if (params != null) {
                j3 = params.getLong("param_live_roomid");
            } else {
                j3 = 0;
            }
            if (j3 != ((FeedCloudMeta$StFeed) this.f85017h).live.room.roomId.get() && -1 != j3) {
                this.f86244l0.i("QFSFeedChildLivePresenter", 1, "isPlayEventValid, roomId = " + j3);
                return false;
            }
            this.f86244l0.e("QFSFeedChildLivePresenter", 1, "onPlayerStatusChange, eventType = " + qCircleLiveFeedsPlayerEvent.getEventType() + ", roomId =" + j3);
            return true;
        }
        this.f86244l0.e("QFSFeedChildLivePresenter", 1, "isPlayEventValid live.room is null");
        return false;
    }

    private boolean J2() {
        boolean z16;
        Iterator<ActivityManager.RunningAppProcessInfo> it = SystemMethodProxy.getRunningAppProcesses((ActivityManager) this.C.getContext().getApplicationContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().processName.equals("com.tencent.mobileqq:tool")) {
                    z16 = true;
                    break;
                }
            } else {
                z16 = false;
                break;
            }
        }
        if (!z16) {
            this.f86235c0 = false;
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K2(RFWPlayer rFWPlayer) {
        this.I.setLoadingView(this.N);
        this.I.setLoopBack(true);
        this.f86244l0.i("QFSFeedChildLivePresenter", 1, "onInitSuccess");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L2(int i3, int i16, int i17, String str) {
        this.f86244l0.e("QFSFeedChildLivePresenter", "onVideoPlayError_ module=" + i3 + ",errorType=" + i16 + ",errorCode=" + i17 + ",extraInfo=" + str);
        this.X = true;
        h3(false);
        this.f86241i0.g(i17);
        SimpleEventBus.getInstance().dispatchEvent(new PlayerErrorEvent(x2(), i17));
        o3(i17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M2(final int i3, final int i16, final int i17, final String str) {
        e3(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.o
            @Override // java.lang.Runnable
            public final void run() {
                QFSFeedChildLivePresenter.this.L2(i3, i16, i17, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N2(ISuperPlayer iSuperPlayer) {
        j2(iSuperPlayer.getVideoWidth(), iSuperPlayer.getVideoHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P2(int i3, int i16) {
        this.f86244l0.i("QFSFeedChildLivePresenter", String.format("videoSizeChanged, width %s, height %s", Integer.valueOf(i3), Integer.valueOf(i16)));
        j2(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q2(ISuperPlayer iSuperPlayer, final int i3, final int i16) {
        e3(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.h
            @Override // java.lang.Runnable
            public final void run() {
                QFSFeedChildLivePresenter.this.P2(i3, i16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S2(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Y2();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T2() {
        this.f86240h0.c(this.I);
        this.I.stop();
        o2(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String U2(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        String str = feedCloudMeta$StFeed.video.playUrl.get();
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V2() {
        QLog.i("QFSFeedChildLivePresenter", 1, "run preloadProcessRunnable");
        ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).preloadQQLiveRoomProcess();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Y2() {
        this.f86244l0.e("QFSFeedChildLivePresenter", 1, "playerView onLiveClick");
        R0(300, 2, r(), "1");
        QFSVideoView qFSVideoView = this.I;
        if (qFSVideoView != null && qFSVideoView.getSuperPlayer() != null) {
            T t16 = this.f85017h;
            if (((FeedCloudMeta$StFeed) t16).live != null && ((FeedCloudMeta$StFeed) t16).live.room != null) {
                l3();
                return;
            }
            return;
        }
        this.f86244l0.a("QFSFeedChildLivePresenter", 1, "QFSFeedChildLivePresenter onLiveClick playerView is null");
    }

    private void Z2(QCircleLiveFeedsPlayerEvent qCircleLiveFeedsPlayerEvent) {
        if (!H2(qCircleLiveFeedsPlayerEvent)) {
            return;
        }
        String eventType = qCircleLiveFeedsPlayerEvent.getEventType();
        if (eventType.equalsIgnoreCase("release")) {
            a();
            return;
        }
        if ("stop".equals(eventType)) {
            this.R.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.l
                @Override // java.lang.Runnable
                public final void run() {
                    QFSFeedChildLivePresenter.this.T2();
                }
            });
            return;
        }
        if (QCircleLiveFeedsPlayerEvent.EVENT_IGNORE_LIFECYCLE.equals(eventType)) {
            this.f86244l0.w("QFSFeedChildLivePresenter", 1, "EVENT_IGNORE_LIFECYCLE");
            this.f86235c0 = true;
        } else if (QCircleLiveFeedsPlayerEvent.EVENT_RECEIVE_LIFECYCLE.equals(eventType)) {
            this.f86244l0.w("QFSFeedChildLivePresenter", 1, "EVENT_RECEIVE_LIFECYCLE");
            this.f86235c0 = false;
        } else if (QCircleLiveFeedsPlayerEvent.EVENT_SWITCH_DEFINITION.equals(eventType)) {
            this.f86244l0.w("QFSFeedChildLivePresenter", 1, "EVENT_SWITCH_DEFINITION");
            n3(qCircleLiveFeedsPlayerEvent);
        } else {
            this.f86240h0.a(this.I, qCircleLiveFeedsPlayerEvent);
        }
    }

    private void a3(QCircleLiveFeedReplaceSurfaceEvent qCircleLiveFeedReplaceSurfaceEvent) {
        this.f86244l0.e("QFSFeedChildLivePresenter", 1, "onReplaceSurface, roomId = " + qCircleLiveFeedReplaceSurfaceEvent.getRoomId());
        if (qCircleLiveFeedReplaceSurfaceEvent.getSurface() == null) {
            this.f86244l0.e("QFSFeedChildLivePresenter", 1, "onReplaceSurface, illegal surface");
            return;
        }
        if (!this.f86238f0) {
            this.f86244l0.e("QFSFeedChildLivePresenter", 1, "onReplaceSurface, not mSelected");
            return;
        }
        QFSVideoView qFSVideoView = this.I;
        if (qFSVideoView != null && qFSVideoView.getSuperPlayer() != null) {
            boolean d16 = this.f86240h0.d(this.I, qCircleLiveFeedReplaceSurfaceEvent.getSurface());
            this.f86244l0.e("QFSFeedChildLivePresenter", 1, "onReplaceSurface  switchSurface result = " + d16);
            return;
        }
        this.f86244l0.e("QFSFeedChildLivePresenter", 1, "mPlayer illegal");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c3() {
        QCircleExtraTypeInfo r16 = r();
        if (r16 != null && r16.mFeed != null) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) this.f85017h;
            long currentTimeMillis = System.currentTimeMillis();
            QCircleLpReportDc05502.report(new QCircleLpReportDc05502.DataBuilder(ua0.c.b(feedCloudMeta$StFeed).setToUin(feedCloudMeta$StFeed.poster.f398463id.get()).setBeginTime(this.f86245m0).setEndTime(currentTimeMillis).setStayTime(currentTimeMillis - this.f86245m0).setIndex(r16.mDataPosition).setExt1("1").setPageId(y0())));
            this.f86244l0.i(QCircleReportHelper.TAG, 1, "reportStayEvent endTime - mSelectedTime=" + (currentTimeMillis - this.f86245m0));
            return;
        }
        this.f86244l0.e("QCircleReportHelper_QFSFeedChildLivePresenter", 1, "reportStayEvent extraTypeInfo is null or lost feed");
    }

    private void d3() {
        this.f86238f0 = false;
        this.f86243k0 = false;
        this.f86235c0 = false;
        this.f86241i0.i();
        this.W = "";
        this.Z = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e3(Runnable runnable) {
        RFWThreadManager.getUIHandler().post(runnable);
    }

    private boolean g3() {
        if (this.f86235c0 && J2()) {
            return true;
        }
        return false;
    }

    private void h2(RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.setPlayIOC(new b());
        rFWPlayerOptions.getListenerSet().addSDKInitListeners(new IRFWPlayerSdkInitListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.m
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener
            public final void onInitSuccess(RFWPlayer rFWPlayer) {
                QFSFeedChildLivePresenter.this.K2(rFWPlayer);
            }
        });
        rFWPlayerOptions.getListenerSet().addPrepareListeners(new c());
        rFWPlayerOptions.getListenerSet().addErrorStatusListener(new IRFWPlayErrorStatusListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.n
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener
            public final void onVideoPlayError(int i3, int i16, int i17, String str) {
                QFSFeedChildLivePresenter.this.M2(i3, i16, i17, str);
            }
        });
    }

    private void h3(boolean z16) {
        if (z16) {
            this.T.r();
            this.U.g();
        } else {
            this.T.s();
            this.U.h();
        }
    }

    private void i2() {
        ViewGroup.LayoutParams layoutParams = this.J.getLayoutParams();
        layoutParams.height = ScreenUtils.getScreenHeight(this.J.getContext());
        layoutParams.width = ScreenUtils.getScreenWidth(this.J.getContext());
        this.J.setLayoutParams(layoutParams);
    }

    private void i3(int i3, int i16) {
        this.f86244l0.i("QFSFeedChildLivePresenter", "showVideoHorizontalState");
        this.f86236d0 = false;
        int horizontalVideoTopMargin = ((IDisplayViewApi) QRoute.api(IDisplayViewApi.class)).getHorizontalVideoTopMargin(false);
        f3(this.I, ((IDisplayViewApi) QRoute.api(IDisplayViewApi.class)).getHorizontalVideoHeight(i3, i16), horizontalVideoTopMargin);
    }

    private void j2(int i3, int i16) {
        boolean z16;
        this.f86244l0.i("QFSFeedChildLivePresenter", "adjustVideoState, width=" + i3 + ", height=" + i16);
        if (i16 > i3) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.f86236d0 == z16) {
            return;
        }
        if (z16) {
            j3();
        } else {
            i3(i3, i16);
        }
    }

    private void j3() {
        this.f86244l0.i("QFSFeedChildLivePresenter", "showVideoVerticalState");
        this.f86236d0 = true;
        if (QQLiveFolderScreenUtil.isFolderScreenOpenMode(m0())) {
            ViewGroup.LayoutParams layoutParams = this.I.getLayoutParams();
            layoutParams.width = (int) (ScreenUtils.getScreenHeight(this.I.getContext()) * 0.5625f);
            layoutParams.height = -1;
            this.I.setLayoutParams(layoutParams);
            return;
        }
        f3(this.I, -1, 0);
    }

    private void k2(int i3, int i16) {
        ImageView imageView = this.J;
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        if (i3 > i16) {
            i3(i3, i16);
        } else {
            j3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void k3(boolean z16, RFWFeedSelectInfo rFWFeedSelectInfo) {
        long j3;
        String str;
        if (!E2()) {
            return;
        }
        if (!TextUtils.isEmpty(this.W) && this.W.equals(((FeedCloudMeta$StFeed) this.f85017h).video.playUrl.get()) && !this.X) {
            this.f86244l0.i("QFSFeedChildLivePresenter", "startANewPlayer, but play url not changed, return!!!");
            return;
        }
        n1();
        boolean z17 = false;
        this.X = false;
        this.S.setText("\u70b9\u51fb\u8fdb\u5165\u76f4\u64ad\u95f4");
        h3(false);
        final FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) this.f85017h;
        this.I.setData(feedCloudMeta$StFeed, this.f85018i);
        String N = com.tencent.biz.qqcircle.immersive.utils.r.N(feedCloudMeta$StFeed.video.playUrl.get());
        if (z16 && this.Y.containsKey(N)) {
            j3 = this.Y.get(N).longValue();
        } else {
            j3 = 0;
        }
        RFWPlayerOptions addAttachInfo = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).setPlayUrl(feedCloudMeta$StFeed.video.playUrl.get()).setStartOffset(j3).setFileId(feedCloudMeta$StFeed.video.fileId.get()).setStVideo(gb0.b.k(feedCloudMeta$StFeed.video.get())).setFromType(7).setEnableDataCollect(true).addAttachInfo("ATTACH_INFO_KEY_POI", Integer.valueOf(this.f85018i));
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
        h2(addAttachInfo3);
        this.W = feedCloudMeta$StFeed.video.playUrl.get();
        String str2 = "QFSFeedChildLivePresenter startANewPlayer playUrlKey:" + N + "|" + this.Y.containsKey(N) + "continuePlay=" + z16;
        if (TextUtils.isEmpty(N)) {
            this.f86244l0.a("QFSFeedChildLivePresenter_" + addAttachInfo3.tag(), 1, str2);
        } else {
            this.f86244l0.i("QFSFeedChildLivePresenter_" + addAttachInfo3.tag(), 1, hashCode() + str2);
        }
        this.I.loadPlayOptions(addAttachInfo3);
        ISuperPlayer superPlayer = this.I.getSuperPlayer();
        if (superPlayer == null) {
            this.f86244l0.w("QFSFeedChildLivePresenter", "player == null");
            return;
        }
        ISuperPlayerTrafficFlowReporter iSuperPlayerTrafficFlowReporter = this.f86246n0;
        if (iSuperPlayerTrafficFlowReporter != null) {
            iSuperPlayerTrafficFlowReporter.unInit();
        }
        ISuperPlayerTrafficFlowReporter trafficFlowReporter = ((ISuperPlayerTrafficFlowReportApi) QRoute.api(ISuperPlayerTrafficFlowReportApi.class)).getTrafficFlowReporter("scene_qcircle_live", superPlayer, new IResourceProvider() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.k
            @Override // com.tencent.mobileqq.qqlive.api.monitor.IResourceProvider
            public final String getUrl() {
                String U2;
                U2 = QFSFeedChildLivePresenter.U2(FeedCloudMeta$StFeed.this);
                return U2;
            }
        });
        this.f86246n0 = trafficFlowReporter;
        trafficFlowReporter.init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: l2, reason: merged with bridge method [inline-methods] */
    public void R2() {
        if (this.J == null) {
            return;
        }
        this.f86237e0 = Option.obtain().setUrl(o40.a.a((FeedCloudMeta$StFeed) this.f85017h)).setLoadingDrawable(w2()).setPreferDecodeFormat(DecodeFormat.PREFER_ARGB_8888).setSupportRecycler(true).disableHardwareDecode();
        ViewGroup.LayoutParams layoutParams = this.J.getLayoutParams();
        if (layoutParams != null) {
            this.f86237e0.setRequestWidth(layoutParams.width).setRegionHeight(layoutParams.height);
        }
        this.J.setVisibility(8);
        QLog.d("QFSFeedChildLivePresenter", 1, "[PMC][bindCover]mCoverOption.setTargetView mCoverOption " + this.f86237e0.getSeq() + " | mCoverImg: " + this.J.hashCode() + APLogFileUtil.SEPARATOR_LOG + bj.g((FeedCloudMeta$StFeed) this.f85017h));
        QCircleFeedPicLoader.g().loadImage(this.f86237e0, new QCirclePicStateListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.QFSFeedChildLivePresenter.2

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: com.tencent.biz.qqcircle.immersive.feed.live.QFSFeedChildLivePresenter$2$1, reason: invalid class name */
            /* loaded from: classes4.dex */
            public class AnonymousClass1 implements Runnable {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Bitmap f86248d;

                AnonymousClass1(Bitmap bitmap) {
                    this.f86248d = bitmap;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void b(Bitmap bitmap) {
                    if (bitmap == null) {
                        AegisLogger.w("QFSFeedChildLivePresenter", "bindCover, blurBitmap is null ");
                        return;
                    }
                    ((com.tencent.biz.qqcircle.immersive.feed.d) QFSFeedChildLivePresenter.this).J.setImageBitmap(QFSFeedChildLivePresenter.this.z2(bitmap, 0.5f, 0.75f));
                    ((com.tencent.biz.qqcircle.immersive.feed.d) QFSFeedChildLivePresenter.this).J.setVisibility(0);
                    QCircleFeedPicLoader.g().updateOptionTargetView(QFSFeedChildLivePresenter.this.f86237e0, ((com.tencent.biz.qqcircle.immersive.feed.d) QFSFeedChildLivePresenter.this).J);
                    QLog.d("QFSFeedChildLivePresenter", 1, "[PMC][bindCover]mCoverOption.setTargetView mCoverImg: " + ((com.tencent.biz.qqcircle.immersive.feed.d) QFSFeedChildLivePresenter.this).J.hashCode() + " | feed id: " + bj.g((FeedCloudMeta$StFeed) ((QFSBaseFeedChildPresenter) QFSFeedChildLivePresenter.this).f85017h));
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this.f86248d == null) {
                        QLog.w("QFSFeedChildLivePresenter", 1, "bindCover, resultBitMap is null ");
                    } else {
                        final Bitmap a16 = i40.a.f407180a.a(QFSFeedChildLivePresenter.this.m0(), this.f86248d, 25.0f, 2, 1);
                        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.r
                            @Override // java.lang.Runnable
                            public final void run() {
                                QFSFeedChildLivePresenter.AnonymousClass2.AnonymousClass1.this.b(a16);
                            }
                        });
                    }
                }
            }

            @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
            public void onStateChange(LoadState loadState, Option option) {
                if (loadState == LoadState.STATE_SUCCESS) {
                    RFWThreadManager.getInstance().execOnSubThread(new AnonymousClass1(option.getResultBitMap()));
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void l3() {
        if (System.currentTimeMillis() - this.Q < 500) {
            this.f86244l0.i("QFSFeedChildLivePresenter", 1, "startLiveRoom, duplicate click");
            return;
        }
        this.Q = System.currentTimeMillis();
        this.f86244l0.i("QFSFeedChildLivePresenter", 1, "startLiveRoom");
        this.f86233a0 = true;
        this.R.removeCallbacksAndMessages(null);
        if (b3()) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f86234b0 = W2();
            this.f86244l0.i("QFSFeedChildLivePresenter", "reUsePlayerSuc: " + this.f86234b0 + ", cost: " + (System.currentTimeMillis() - currentTimeMillis));
            ah.g(this.I.getContext(), this.f86234b0, (FeedCloudMeta$StFeed) this.f85017h, 17);
            return;
        }
        ah.g(this.I.getContext(), false, (FeedCloudMeta$StFeed) this.f85017h, 17);
    }

    private boolean m2() {
        if (s0() != null && this.I != null && G2()) {
            return false;
        }
        this.f86244l0.i("QFSFeedChildLivePresenter", 1, "canNotPlay");
        return true;
    }

    private void n2() {
        this.f86244l0.i("QFSFeedChildLivePresenter", 1, "[cancelPreloadProcess]");
        Handler handler = this.R;
        if (handler == null) {
            this.f86244l0.i("QFSFeedChildLivePresenter", 1, "[cancelPreloadProcess] invalid handler");
        } else {
            handler.removeCallbacks(f86232o0);
        }
    }

    private void n3(QCircleLiveFeedsPlayerEvent qCircleLiveFeedsPlayerEvent) {
        ISuperPlayer superPlayer = this.I.getSuperPlayer();
        if (superPlayer == null) {
            this.f86244l0.e("QFSFeedChildLivePresenter", 1, "EVENT_SWITCH_DEFINITION fail, player is null");
            return;
        }
        if (qCircleLiveFeedsPlayerEvent != null && qCircleLiveFeedsPlayerEvent.getParams() != null) {
            String string = qCircleLiveFeedsPlayerEvent.getParams().getString("switchDefinitionUrl");
            if (TextUtils.isEmpty(string)) {
                this.f86244l0.e("QFSFeedChildLivePresenter", 1, "EVENT_SWITCH_DEFINITION fail, url is empty");
                return;
            } else {
                superPlayer.switchDefinitionForUrl(string, 2);
                return;
            }
        }
        this.f86244l0.e("QFSFeedChildLivePresenter", 1, "EVENT_SWITCH_DEFINITION fail, event params invalid");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o2(boolean z16) {
        if (this.J == null) {
            return;
        }
        if (z16) {
            this.S.setText("\u70b9\u51fb\u8fdb\u5165\u76f4\u64ad\u95f4");
            h3(true);
        } else {
            this.f86244l0.i("QFSFeedChildLivePresenter", 1, "set cover image VISIBLE");
            this.J.setVisibility(0);
            h3(false);
        }
    }

    private void o3(int i3) {
        if (this.f86239g0 == null) {
            IPlayerChangeUrlManager iPlayerChangeUrlManager = (IPlayerChangeUrlManager) QRoute.api(IPlayerChangeUrlManager.class);
            this.f86239g0 = iPlayerChangeUrlManager;
            iPlayerChangeUrlManager.init(x2());
        }
        if (!this.f86239g0.needChangeUrl(i3)) {
            return;
        }
        this.f86239g0.getChangedUrl(new IPlayerChangeUrlManager.Callback() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.QFSFeedChildLivePresenter.5
            @Override // com.tencent.mobileqq.qqlive.api.player.IPlayerChangeUrlManager.Callback
            public void onError(long j3, @Nullable String str) {
                QFSFeedChildLivePresenter.this.f86244l0.e("QFSFeedChildLivePresenter", "getChangedUrl error, errCode:" + j3 + ", errMsg:" + str);
            }

            @Override // com.tencent.mobileqq.qqlive.api.player.IPlayerChangeUrlManager.Callback
            public void onResult(@NonNull final String str) {
                QFSFeedChildLivePresenter.this.f86244l0.i("QFSFeedChildLivePresenter", "getChangedUrl success, url:" + str);
                QFSFeedChildLivePresenter.this.e3(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.QFSFeedChildLivePresenter.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!TextUtils.isEmpty(str)) {
                            ((FeedCloudMeta$StFeed) ((QFSBaseFeedChildPresenter) QFSFeedChildLivePresenter.this).f85017h).video.playUrl.set(str);
                            QFSFeedChildLivePresenter.this.k3(false, null);
                        }
                    }
                });
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean p2(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        if (com.tencent.biz.qqcircle.immersive.utils.r.B0(feedCloudMeta$StFeed, (FeedCloudMeta$StFeed) this.f85017h) && i3 == this.f85018i) {
            return true;
        }
        if (feedCloudMeta$StFeed == null) {
            this.f86244l0.i("QFSFeedChildLivePresenter", 1, "onBindData is null: " + i3);
            return true;
        }
        return false;
    }

    private void p3() {
        long currentTimeMillis = System.currentTimeMillis();
        if (J2()) {
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            this.f86244l0.w("QFSFeedChildLivePresenter", 1, "[tryPreloadProcess] exist process, cost=" + currentTimeMillis2);
            return;
        }
        if (this.R == null) {
            this.f86244l0.w("QFSFeedChildLivePresenter", 1, "[tryPreloadProcess] invalid handler");
            return;
        }
        long intValue = QCircleConfig.getInstance().getConfigValue("qqcircle", "qqcircle_live_feed_preload_process_delay", (Integer) 2000).intValue();
        this.f86244l0.i("QFSFeedChildLivePresenter", 1, "[tryPreloadProcess] delay=" + intValue);
        Handler handler = this.R;
        Runnable runnable = f86232o0;
        handler.removeCallbacks(runnable);
        this.R.postDelayed(runnable, intValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void r2(final ISuperPlayer iSuperPlayer) {
        this.f86244l0.i("QFSFeedChildLivePresenter", 1, "doOnVideoPrepare mPlayView=" + this.I + ",mData=" + this.f85017h);
        if (this.I != null && this.f85017h != 0 && G2() && iSuperPlayer != null) {
            e3(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.p
                @Override // java.lang.Runnable
                public final void run() {
                    QFSFeedChildLivePresenter.this.N2(iSuperPlayer);
                }
            });
            iSuperPlayer.setOnVideoSizeChangedListener(new ISuperPlayer.OnVideoSizeChangedListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.q
                @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener
                public final void onVideoSizeChanged(ISuperPlayer iSuperPlayer2, int i3, int i16) {
                    QFSFeedChildLivePresenter.this.Q2(iSuperPlayer2, i3, i16);
                }
            });
            if (y2() == 1) {
                iSuperPlayer.setXYaxis(0);
            } else if (TransitionHelper.shouldVideoYFullScreen(((FeedCloudMeta$StFeed) this.f85017h).video.width.get(), ((FeedCloudMeta$StFeed) this.f85017h).video.height.get())) {
                iSuperPlayer.setXYaxis(1);
            } else {
                iSuperPlayer.setXYaxis(2);
            }
            t2();
            this.I.start();
            return;
        }
        this.f86244l0.i("QFSFeedChildLivePresenter", 1, "doOnVideoPrepare return");
    }

    private void s2(QCircleFeedVideoControlEvent qCircleFeedVideoControlEvent) {
        if (!qCircleFeedVideoControlEvent.isPlay()) {
            return;
        }
        u2(false, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void t2() {
        if (this.I != null && this.f85017h != 0) {
            Map<String, ?> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(ua0.c.d(this.E));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.f85018i + 1));
            buildElementParams.put("xsj_custom_pgid", r0());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_QQLIVE_ROOM_ID, Long.valueOf(x2()));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_ROOM_TYPE, Integer.valueOf(y2()));
            v70.a.b(buildElementParams, this.E);
            v70.a.a(buildElementParams, this.E);
            if (((FeedCloudMeta$StFeed) this.f85017h).live.liveExtInfo.get() != null) {
                for (FeedCloudCommon$Entry feedCloudCommon$Entry : ((FeedCloudMeta$StFeed) this.f85017h).live.liveExtInfo.get()) {
                    if (D2(feedCloudCommon$Entry.key.get())) {
                        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_TOKEN, feedCloudCommon$Entry.value.get());
                    }
                }
            }
            VideoEntity build = new VideoEntity.Builder().setContentId(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get()).setPage((Object) r0()).setContentType(2).setVideoDuration(((FeedCloudMeta$StFeed) this.f85017h).video.duration.get()).setVideoView((View) this.I).addCustomParams(buildElementParams).ignoreReport(false).bizReady(true).build();
            ISuperPlayer superPlayer = this.I.getSuperPlayer();
            if (superPlayer != null) {
                VideoReport.bindVideoPlayerInfo(superPlayer, build);
            }
            this.f86244l0.i("QFSFeedChildLivePresenter", 1, "dtReportBindVideoData  pos = " + this.f85018i);
        }
    }

    private void u2(boolean z16, RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (m2()) {
            return;
        }
        if (this.I.getSuperPlayer() == null) {
            k3(z16, rFWFeedSelectInfo);
        } else {
            if (this.I.getSuperPlayer().isPlaying()) {
                return;
            }
            k3(z16, rFWFeedSelectInfo);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void v2(QCircleFeedVideoCurrentTimeEvent qCircleFeedVideoCurrentTimeEvent) {
        T t16 = this.f85017h;
        if (t16 != 0 && ((FeedCloudMeta$StFeed) t16).video != null && ((FeedCloudMeta$StFeed) t16).video.playUrl != null && qCircleFeedVideoCurrentTimeEvent != null) {
            String N = com.tencent.biz.qqcircle.immersive.utils.r.N(((FeedCloudMeta$StFeed) t16).video.playUrl.get());
            if (!TextUtils.isEmpty(N) && this.Y.containsKey(N)) {
                this.Y.replace(N, Long.valueOf(qCircleFeedVideoCurrentTimeEvent.getCurrentTime()));
            }
        }
    }

    private Drawable w2() {
        if (this.f85018i == 0 && s0() != null && s0().getTransitionLoadingDrawable() != null) {
            return s0().getTransitionLoadingDrawable();
        }
        return new ColorDrawable(QCircleSkinHelper.getInstance().getColor(R.color.cje));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public long x2() {
        return o40.a.b((FeedCloudMeta$StFeed) this.f85017h);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int y2() {
        return o40.a.c((FeedCloudMeta$StFeed) this.f85017h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap z2(Bitmap bitmap, float f16, float f17) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
            if (createBitmap == null) {
                AegisLogger.w("QFSFeedChildLivePresenter", "handleImageEffect invalid new bm");
                return bitmap;
            }
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint(1);
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setScale(f16, f16, f16, 1.0f);
            ColorMatrix colorMatrix2 = new ColorMatrix();
            colorMatrix2.set(new float[]{f17, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f17, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f17, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
            ColorMatrix colorMatrix3 = new ColorMatrix();
            colorMatrix3.postConcat(colorMatrix);
            colorMatrix3.postConcat(colorMatrix2);
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix3));
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            bitmap.recycle();
            return createBitmap;
        } catch (Exception e16) {
            AegisLogger.e("QFSFeedChildLivePresenter", "handleImageEffect", " catch Exception!", e16);
            return bitmap;
        } catch (OutOfMemoryError e17) {
            AegisLogger.e("QFSFeedChildLivePresenter", "handleImageEffect", " catch OutOfMemoryError", e17);
            return bitmap;
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.C0(hVar);
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.o) {
            l3();
        }
    }

    void C2(View view) {
        if (view != null) {
            ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("exp_xsj_livefeeds_liveicon");
            expEntity.reportExpExposure();
            this.U = new com.tencent.biz.qqcircle.immersive.feed.live.b(view, this.f86244l0, expEntity);
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.uxz);
            FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.txz);
            ExpEntityInfo expEntity2 = ABTestController.getInstance().getExpEntity("exp_xsj_livefeeds_clickbutton");
            expEntity2.reportExpExposure();
            this.T = new e(frameLayout, frameLayout2, this.f86244l0, expEntity2);
            this.V = new com.tencent.biz.qqcircle.immersive.feed.live.a(view.findViewById(R.id.yln), view.findViewById(R.id.ylm));
        }
    }

    boolean D2(String str) {
        return "rcmd_context".equalsIgnoreCase(str);
    }

    boolean F2() {
        return NetworkUtil.isMobileNetWork(this.C.getContext());
    }

    @VisibleForTesting
    boolean I2() {
        QFSVideoView qFSVideoView = this.I;
        if (qFSVideoView != null && qFSVideoView.getSuperPlayer() != null) {
            return true;
        }
        this.f86244l0.e("QFSFeedChildLivePresenter", 1, "playView is null");
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        super.K0();
        QFSVideoView qFSVideoView = this.I;
        if (qFSVideoView != null) {
            qFSVideoView.setReportBean(getReportBean());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.d, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.C = view;
        this.N = view.findViewById(R.id.vai);
        this.S = (TextView) view.findViewById(R.id.f164812ty0);
        this.P = true;
        this.R = new Handler(Looper.getMainLooper());
        C2(view);
        i2();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void Q0() {
        super.Q0();
        if (E2()) {
            R0(300, 1, r(), "1");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @VisibleForTesting
    boolean W2() {
        if (!b3()) {
            this.f86244l0.e("QFSFeedChildLivePresenter", 1, "not translucentPage, return");
            return false;
        }
        if (!this.f86238f0) {
            this.f86244l0.e("QFSFeedChildLivePresenter", 1, "delayNotifyOutHasPlayer, not mSelected");
            return false;
        }
        T t16 = this.f85017h;
        if (((FeedCloudMeta$StFeed) t16).live != null && ((FeedCloudMeta$StFeed) t16).live.room != null) {
            if (((FeedCloudMeta$StFeed) t16).live.room.roomType.get() != 0) {
                this.f86244l0.e("QFSFeedChildLivePresenter", 1, "roomType is not normal room");
                return false;
            }
            if (!I2()) {
                return false;
            }
            if (F2()) {
                this.f86244l0.i("QFSFeedChildLivePresenter", 1, "isMobileNetWork, return");
                return false;
            }
            this.f86244l0.i("QFSFeedChildLivePresenter", 1, "notifyOuterHasPlayer");
            return q2();
        }
        this.f86244l0.e("QFSFeedChildLivePresenter", 1, "live data is null");
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.d
    protected void a() {
        if (this.I == null) {
            return;
        }
        this.f86244l0.i("QFSFeedChildLivePresenter", 1, "releasePlayer");
        this.W = "";
        this.X = false;
        VideoReport.unbindVideoPlayerInfo(this.I);
        ISuperPlayerTrafficFlowReporter iSuperPlayerTrafficFlowReporter = this.f86246n0;
        if (iSuperPlayerTrafficFlowReporter != null) {
            iSuperPlayerTrafficFlowReporter.onPlayerPause();
        }
        this.I.release();
        o2(false);
    }

    @VisibleForTesting
    boolean b3() {
        this.f86244l0.i("QFSFeedChildLivePresenter", "mReUsePlayer = " + this.P + ", roomType = " + y2() + ", mPrePlayError = " + this.X + ", mIsVideoVertical = " + this.f86236d0);
        if (this.f86236d0) {
            if (this.P && y2() == 0 && !this.X) {
                return true;
            }
            return false;
        }
        boolean enableHorizontalVideoSeamless = ((IDisplayViewApi) QRoute.api(IDisplayViewApi.class)).enableHorizontalVideoSeamless();
        this.f86244l0.i("QFSFeedChildLivePresenter", "enable horizontalVideo seamless:" + enableHorizontalVideoSeamless);
        if (this.P && y2() == 0 && !this.X && enableHorizontalVideoSeamless) {
            return true;
        }
        return false;
    }

    boolean f3(View view, int i3, int i16) {
        if (i3 != 0 && view != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-1, i3);
            }
            layoutParams.width = -1;
            layoutParams.height = i3;
            layoutParams.topMargin = i16;
            view.setLayoutParams(layoutParams);
            return true;
        }
        this.f86244l0.i("QFSFeedChildLivePresenter", 1, "setSize origin size zero");
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.d, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QCircleFeedVideoControlEvent.class);
        eventClass.add(QCircleFeedVideoCurrentTimeEvent.class);
        eventClass.add(QCircleLiveFeedReplaceSurfaceEvent.class);
        eventClass.add(QCircleLiveFeedsPlayerEvent.class);
        eventClass.add(AnchorLiveStateChangeEvent.class);
        eventClass.add(StartingShareEvent.class);
        eventClass.add(QCircleShareItemClickEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.d
    protected void i1(RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (m2()) {
            return;
        }
        this.f86244l0.i("QFSFeedChildLivePresenter", 1, "executeFromSelected");
        k3(false, rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.d
    protected void k1(@NonNull ASEngineTabStatusEvent aSEngineTabStatusEvent) {
        super.k1(aSEngineTabStatusEvent);
        if (aSEngineTabStatusEvent.isSelected()) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.j
                @Override // java.lang.Runnable
                public final void run() {
                    QFSFeedChildLivePresenter.this.R2();
                }
            });
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.d, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (rFWFeedSelectInfo == null) {
            return;
        }
        this.f86245m0 = System.currentTimeMillis();
        this.f86238f0 = true;
        this.f86235c0 = false;
        this.f86241i0.i();
        this.f86241i0.j(this.f86242j0);
        p3();
        this.f86244l0.i("QFSFeedChildLivePresenter", 1, "onSelected:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + APLogFileUtil.SEPARATOR_LOG + hashCode() + ", roomId:" + x2() + ", roomType:" + y2());
        if (rFWFeedSelectInfo.getPosition() != this.f85018i) {
            return;
        }
        i1(rFWFeedSelectInfo);
        long x26 = x2();
        this.f86244l0.i("QFSFeedChildLivePresenter", 1, "onFeedSelected refreshLiveStatus, roomId:" + x26 + ", roomType:" + y2());
        this.T.n();
        this.U.d();
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("qqlive_experiment_darklayer_0323");
        expEntity.reportExpExposure();
        boolean isExperiment = expEntity.isExperiment("qqlive_experiment_darklayer_0323_B");
        QLog.d("QFSFeedChildLivePresenter", 1, "mask abtest, isNewStyle = " + isExperiment);
        this.V.a(isExperiment);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        this.f86244l0.i("QFSFeedChildLivePresenter", 1, "onUnSelected:" + rFWFeedSelectInfo + APLogFileUtil.SEPARATOR_LOG + hashCode());
        n2();
        d3();
        if (rFWFeedSelectInfo == null || rFWFeedSelectInfo.getPosition() != this.f85018i) {
            return;
        }
        this.f86244l0.i("QFSFeedChildLivePresenter", 1, "onUnSelected, release player, mPos:" + this.f85018i);
        a();
        c3();
        ISuperPlayerTrafficFlowReporter iSuperPlayerTrafficFlowReporter = this.f86246n0;
        if (iSuperPlayerTrafficFlowReporter != null) {
            iSuperPlayerTrafficFlowReporter.unInit();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onPaused(rFWFeedSelectInfo);
        n2();
        if (g3()) {
            this.f86244l0.w("QFSFeedChildLivePresenter", 1, "onPaused, ignore lifecycle!!!");
            return;
        }
        this.f86244l0.i("QFSFeedChildLivePresenter", 1, "onPaused:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + APLogFileUtil.SEPARATOR_LOG + hashCode());
        if (this.f86233a0) {
            this.f86244l0.i("QFSFeedChildLivePresenter", 1, "onPaused:jumping live room");
        } else if (this.Z) {
            this.f86244l0.i("QFSFeedChildLivePresenter", "onPaused:starting share");
        } else {
            a();
            c3();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.d, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QCircleFeedVideoControlEvent) {
            QCircleFeedVideoControlEvent qCircleFeedVideoControlEvent = (QCircleFeedVideoControlEvent) simpleBaseEvent;
            if (m0() != null && m0().hashCode() == qCircleFeedVideoControlEvent.getHashCode()) {
                s2(qCircleFeedVideoControlEvent);
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof QCircleFeedVideoCurrentTimeEvent) {
            v2((QCircleFeedVideoCurrentTimeEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QCircleLiveFeedReplaceSurfaceEvent) {
            a3((QCircleLiveFeedReplaceSurfaceEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QCircleLiveFeedsPlayerEvent) {
            if (G2()) {
                return;
            }
            Z2((QCircleLiveFeedsPlayerEvent) simpleBaseEvent);
        } else {
            if (simpleBaseEvent instanceof AnchorLiveStateChangeEvent) {
                A2((AnchorLiveStateChangeEvent) simpleBaseEvent);
                return;
            }
            if (simpleBaseEvent instanceof StartingShareEvent) {
                this.f86244l0.i("QFSFeedChildLivePresenter", "receive starting share panel even!!!");
                this.Z = true;
            } else if ((simpleBaseEvent instanceof QCircleShareItemClickEvent) && 2 == ((QCircleShareItemClickEvent) simpleBaseEvent).getAction()) {
                this.f86244l0.i("QFSFeedChildLivePresenter", "receive KEY_SPECIFIED_FRIEND_SHARE_OPERATION");
                this.Z = true;
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onResumed(rFWFeedSelectInfo);
        if (g3()) {
            this.f86244l0.w("QFSFeedChildLivePresenter", 1, "onResumed, ignore lifecycle!!!");
            return;
        }
        if (this.I == null) {
            this.f86244l0.i("QFSFeedChildLivePresenter", 1, "onResumed:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + APLogFileUtil.SEPARATOR_LOG + hashCode() + "|playView is null");
            return;
        }
        if (rFWFeedSelectInfo == null) {
            return;
        }
        if (this.Z) {
            this.Z = false;
        }
        if (G2()) {
            p3();
            if (this.f86233a0) {
                this.W = "";
                boolean c16 = this.f86240h0.c(this.I);
                this.f86244l0.e("QFSFeedChildLivePresenter", 1, "resetSurface result = " + c16);
            }
        }
        if (this.f85018i == rFWFeedSelectInfo.getPosition()) {
            if (this.f86233a0 && this.f86234b0) {
                QLog.i("QFSFeedChildLivePresenter", 1, "startANewPlayer, set cover image VISIBLE");
                this.J.setVisibility(0);
                k3(true, rFWFeedSelectInfo);
            } else {
                u2(true, rFWFeedSelectInfo);
            }
        }
        this.f86234b0 = false;
        this.f86233a0 = false;
        this.f86244l0.i("QFSFeedChildLivePresenter", 1, "onResumed:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + APLogFileUtil.SEPARATOR_LOG + hashCode());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onStop(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onStop(rFWFeedSelectInfo);
        if (g3()) {
            this.f86244l0.w("QFSFeedChildLivePresenter", 1, "onStop, ignore lifecycle!!!");
            return;
        }
        this.f86244l0.i("QFSFeedChildLivePresenter", 1, "onStop:" + rFWFeedSelectInfo + " |  | mPos:" + this.f85018i + hashCode() + "|playView is null");
        if (this.f86233a0 && b3() && this.f86234b0) {
            this.f86244l0.i("QFSFeedChildLivePresenter", 1, "onStop:jumping live room,unbind player");
            return;
        }
        if (this.Z) {
            this.f86244l0.i("QFSFeedChildLivePresenter", "onStop:starting share");
            return;
        }
        a();
        ISuperPlayerTrafficFlowReporter iSuperPlayerTrafficFlowReporter = this.f86246n0;
        if (iSuperPlayerTrafficFlowReporter != null) {
            iSuperPlayerTrafficFlowReporter.unInit();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public void onViewHolderDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewHolderDetachedFromWindow(viewHolder);
        this.f86244l0.i("QFSFeedChildLivePresenter", 1, "onViewHolderDetachedFromWindow: | mPos:" + this.f85018i + " | holder.pos:" + viewHolder.getAdapterPosition() + " | hashCode:" + hashCode() + " | pageId:" + y0());
        a();
        d3();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @VisibleForTesting
    boolean q2() {
        int i3;
        int videoWidth = this.I.getSuperPlayer().getVideoWidth();
        int videoHeight = this.I.getSuperPlayer().getVideoHeight();
        if (this.f86236d0) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        return ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).notifyOuterHasPlayer(((FeedCloudMeta$StFeed) this.f85017h).live.room.roomId.get(), videoWidth, videoHeight, i3, this.I.getSuperPlayer());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: s1 */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        FeedCloudMeta$StLive feedCloudMeta$StLive;
        if (p2(feedCloudMeta$StFeed, i3)) {
            return;
        }
        super.L0(feedCloudMeta$StFeed, i3);
        this.f86244l0.i("QFSFeedChildLivePresenter", 1, "data type: " + feedCloudMeta$StFeed.type.get() + "isFeedLiveType=" + E2() + ",pos=" + i3 + ",roomId=" + x2() + ",roomType=" + y2());
        if (feedCloudMeta$StFeed.type.get() == 4 && (feedCloudMeta$StLive = feedCloudMeta$StFeed.live) != null && feedCloudMeta$StLive.room != null) {
            B2(true);
            k2(o40.a.e(feedCloudMeta$StFeed), o40.a.d(feedCloudMeta$StFeed));
            R2();
            o2(false);
            this.C.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSFeedChildLivePresenter.this.S2(view);
                }
            });
            this.T.o();
            this.U.e(feedCloudMeta$StFeed, i3);
            return;
        }
        this.f86244l0.i("QFSFeedChildLivePresenter", 1, "hideVideoContainer, return");
        B2(false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildLivePresenter";
    }
}
