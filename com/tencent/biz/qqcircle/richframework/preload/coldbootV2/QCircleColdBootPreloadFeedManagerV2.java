package com.tencent.biz.qqcircle.richframework.preload.coldbootV2;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.debug.recommend.data.RecExptInfo;
import com.tencent.biz.qqcircle.immersive.events.QFSFeedExposeEvent;
import com.tencent.biz.qqcircle.immersive.manager.QFSEcommerceTopViewManager;
import com.tencent.biz.qqcircle.immersive.manager.QFSTopViewManager;
import com.tencent.biz.qqcircle.immersive.utils.ba;
import com.tencent.biz.qqcircle.immersive.utils.j;
import com.tencent.biz.qqcircle.richframework.preload.coldbootV2.QCircleColdBootPreloadFeedManagerV2;
import com.tencent.biz.qqcircle.richframework.video.player.process.QFSPlayerOptionsExchangeUrlProcess;
import com.tencent.biz.qqcircle.utils.ak;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWPostAtFrontUtils;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsProcessManager;
import com.tencent.biz.richframework.video.rfw.player.playerprender.RFWPlayerPreRenderBean;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPreRenderHelper;
import com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadManager;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.qcircle.api.IQCircleColdBootServiceV2;
import com.tencent.mobileqq.qcircle.api.coldboot.IPreloadTask;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StPrePullCacheFeed;
import feedcloud.FeedCloudRead$StGetFeedListReq;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.Foreground;
import qqcircle.QQCircleFeedBase$PrePullMetaData;
import qqcircle.QQCircleFeedBase$PrePullRspFeedsOpActionDesc;
import qqcircle.QQCircleFeedBase$StFeedListBusiReqData;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase$StGetPrePullInfoReqV2;
import qqcircle.QQCircleFeedBase$StGetPrePullInfoRspV2;
import uq3.k;

/* loaded from: classes5.dex */
public class QCircleColdBootPreloadFeedManagerV2 implements SimpleEventReceiver, cb0.a {
    private static final String DEFAULT_TIME = "2000";
    private static final String KEY_REC_EXPT_CONFIG = "expermodel";
    private static final String TAG = "FeedLine_QCircleColdBootPreloadFeedManagerV2";
    private static volatile QCircleColdBootPreloadFeedManagerV2 sInstance;
    private com.tencent.biz.qqcircle.richframework.preload.coldbootV2.a mAppLifecycleCallback;
    private IQCircleColdBootServiceV2.a mCallback;
    private final boolean mEnableColdBootPreRender;
    private final boolean mEnableColdBootPreload;
    private Runnable mForegroundRunnable;
    private long mLastVideoPlayTime;
    private Runnable mPreRenderRunnable;
    private FeedCloudMeta$StFeed mPreloadFeed;
    private final HashSet<Integer> mSourceWriteList;
    private final ConcurrentHashMap<Integer, g> mPreloadMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Integer, QQCircleFeedBase$PrePullMetaData> mMetaDatas = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends com.tencent.biz.qqcircle.richframework.preload.coldbootV2.a {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.richframework.preload.coldbootV2.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_release_qfs_player_when_splash_destroy", true) && ak.a(activity)) {
                QLog.d(QCircleColdBootPreloadFeedManagerV2.TAG, 2, "release qfs videos");
                SuperPlayerSDKMgr.releaseOtherScened(String.valueOf(126));
            }
            super.onActivityDestroyed(activity);
        }

        @Override // com.tencent.biz.qqcircle.richframework.preload.coldbootV2.a, mqq.app.QActivityLifecycleCallbacks
        public void onProcessBackground() {
            super.onProcessBackground();
            QCircleColdBootPreloadFeedManagerV2.this.onProcessBackground();
        }

        @Override // com.tencent.biz.qqcircle.richframework.preload.coldbootV2.a, mqq.app.QActivityLifecycleCallbacks
        public void onProcessForeground() {
            super.onProcessForeground();
            QCircleColdBootPreloadFeedManagerV2.this.onProcessForeground();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements RFWPlayerOptionsProcessManager.IProcessCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f91971a;

        b(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f91971a = feedCloudMeta$StFeed;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b() {
            QLog.d(QCircleColdBootPreloadFeedManagerV2.TAG, 1, "[doExchangeUrl] videoDelete reload will playFeed");
            QCircleColdBootPreloadFeedManagerV2.getInstance().preInitWillPlayFeed();
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsProcessManager.IProcessCallBack
        public void onFinish(RFWPlayerOptions rFWPlayerOptions, boolean z16) {
            if (rFWPlayerOptions == null) {
                return;
            }
            QLog.d(QCircleColdBootPreloadFeedManagerV2.TAG, 1, "[doExchangeUrl] finish, videoDelete:" + rFWPlayerOptions.isVideoDelete());
            if (rFWPlayerOptions.isVideoDelete() && h.c()) {
                k30.h.f().n(this.f91971a);
                RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.preload.coldbootV2.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        QCircleColdBootPreloadFeedManagerV2.b.b();
                    }
                }, 3000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements SDKInitListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f91973d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f91974e;

        c(FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
            this.f91973d = feedCloudMeta$StFeed;
            this.f91974e = str;
        }

        @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
        public void onSDKInited(boolean z16) {
            if (!z16) {
                QLog.d(QCircleColdBootPreloadFeedManagerV2.TAG, 1, "initDownloadSDKAsync failed!");
                return;
            }
            RFWVideoPreloadManager.g(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).preloadVideo(gb0.b.n(this.f91973d, false), this.f91974e);
            QFSTopViewManager.e().k(this.f91973d);
            QFSEcommerceTopViewManager.b().g(this.f91973d);
            QLog.d(QCircleColdBootPreloadFeedManagerV2.TAG, 1, "initDownloadSDKAsync success! videoPlaySourceType:" + this.f91974e);
        }
    }

    QCircleColdBootPreloadFeedManagerV2() {
        boolean z16;
        boolean z17;
        HashSet<Integer> hashSet = new HashSet<>();
        this.mSourceWriteList = hashSet;
        SimpleEventBus.getInstance().registerReceiver(this);
        if (uq3.c.g6() && uq3.c.q6()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mEnableColdBootPreload = z16;
        if (uq3.c.X0("qqcircle", "qqcircle_player_cold_boot_pre_render", 1).intValue() == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.mEnableColdBootPreRender = z17;
        QLog.d(TAG, 1, "new instance, enable preload: ", Boolean.valueOf(z16));
        init();
        hashSet.add(10);
        hashSet.add(10000);
        hashSet.add(75);
        this.mLastVideoPlayTime = k.a().f("sp_key_user_last_play_video_time", -1L);
        checkAppForeground();
    }

    private void addEEveeTraceId(String str, @NonNull FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        if (str != null && feedCloudRead$StGetFeedListRsp != null) {
            FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry.key.set(EeveeRedpointUtil.EEVEE_TRACE_ID);
            feedCloudCommon$Entry.value.set(str);
            feedCloudRead$StGetFeedListRsp.extInfo.mapInfo.add(feedCloudCommon$Entry);
            if (!feedCloudRead$StGetFeedListRsp.extInfo.has()) {
                feedCloudRead$StGetFeedListRsp.extInfo.setHasFlag(true);
            }
        }
    }

    public static boolean canUsePreRenderBySystemPlayer() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_can_use_pre_render_succeed_rate_exp", false);
    }

    private void checkAppForeground() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_foreground_re_init", false)) {
            return;
        }
        QLog.d(TAG, 1, "checkAppForeground use qqbase foreground judge");
        a aVar = new a();
        this.mAppLifecycleCallback = aVar;
        Foreground.addActivityLifeCallback(aVar);
    }

    private void clearCache() {
        QLog.d(TAG, 1, "clearCache, mPreloadMap size:" + this.mPreloadMap.size());
        Iterator<Map.Entry<Integer, g>> it = this.mPreloadMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().clearAllCacheInfo();
        }
    }

    private void dealWithAllPushPreloadData(String str, byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp = new FeedCloudRead$StGetFeedListRsp();
            try {
                feedCloudRead$StGetFeedListRsp.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e(TAG, 1, "[dealWithAllPushPreloadData] parse getFeedListRsp exception:", e16.toString());
            }
            addEEveeTraceId(str, feedCloudRead$StGetFeedListRsp);
            QLog.d(TAG, 1, "[dealWithAllPushPreloadData] traceId\uff1a" + str);
            if (feedCloudRead$StGetFeedListRsp.has()) {
                QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData = new QQCircleFeedBase$StFeedListBusiRspData();
                try {
                    qQCircleFeedBase$StFeedListBusiRspData.mergeFrom(feedCloudRead$StGetFeedListRsp.busiRspData.get().toByteArray());
                } catch (InvalidProtocolBufferMicroException e17) {
                    QLog.e(TAG, 1, "[dealWithAllPushPreloadData] parse feedListBusiRspData exception:", e17.toString());
                }
                if (qQCircleFeedBase$StFeedListBusiRspData.has() && qQCircleFeedBase$StFeedListBusiRspData.getPrePullInfoRspV2.has()) {
                    QQCircleFeedBase$StGetPrePullInfoRspV2 qQCircleFeedBase$StGetPrePullInfoRspV2 = qQCircleFeedBase$StFeedListBusiRspData.getPrePullInfoRspV2.get();
                    savePrePullMetaData(qQCircleFeedBase$StGetPrePullInfoRspV2, 10);
                    parsePreloadRspInnerAllPush(feedCloudRead$StGetFeedListRsp, qQCircleFeedBase$StGetPrePullInfoRspV2);
                    return;
                }
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "[dealWithAllPushPreloadData] doParsePreloadRspByte input busiData invalid");
    }

    private void dealWithNormalPreloadData(String str, byte[] bArr, int i3) {
        if (i3 == 75 && !uq3.c.V4()) {
            return;
        }
        if (bArr != null && bArr.length != 0) {
            FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp = new FeedCloudRead$StGetFeedListRsp();
            try {
                feedCloudRead$StGetFeedListRsp.mergeFrom(bArr);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "[dealWithNormalPreloadData] parse getFeedListRsp exception:", e16.toString() + ",source:" + i3);
            }
            addEEveeTraceId(str, feedCloudRead$StGetFeedListRsp);
            QLog.e(TAG, 1, "[dealWithNormalPreloadData] traceId" + str);
            if (feedCloudRead$StGetFeedListRsp.has()) {
                QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData = new QQCircleFeedBase$StFeedListBusiRspData();
                try {
                    qQCircleFeedBase$StFeedListBusiRspData.mergeFrom(feedCloudRead$StGetFeedListRsp.busiRspData.get().toByteArray());
                } catch (InvalidProtocolBufferMicroException e17) {
                    QLog.e(TAG, 1, "[dealWithNormalPreloadData] parse feedListBusiRspData exception:", e17.toString() + ",source:" + i3);
                }
                if (qQCircleFeedBase$StFeedListBusiRspData.has() && qQCircleFeedBase$StFeedListBusiRspData.getPrePullInfoRspV2.has()) {
                    QQCircleFeedBase$StGetPrePullInfoRspV2 qQCircleFeedBase$StGetPrePullInfoRspV2 = qQCircleFeedBase$StFeedListBusiRspData.getPrePullInfoRspV2.get();
                    savePrePullMetaData(qQCircleFeedBase$StGetPrePullInfoRspV2, i3);
                    parsePreloadRspNormalRedPoint(feedCloudRead$StGetFeedListRsp, qQCircleFeedBase$StGetPrePullInfoRspV2, i3);
                    return;
                }
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "[dealWithNormalPreloadData] doParsePreloadRspByte input busiData invalid,source:" + i3);
    }

    private void destroy() {
        QLog.d(TAG, 1, "destroy");
        clearCache();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        if (this.mForegroundRunnable != null) {
            RFWThreadManager.getInstance().remove(this.mForegroundRunnable);
        }
        com.tencent.biz.qqcircle.richframework.preload.coldbootV2.a aVar = this.mAppLifecycleCallback;
        if (aVar != null) {
            Foreground.removeActivityLifeCallback(aVar);
        }
        RFWPlayerPreRenderHelper.getInstance().releaseRender();
    }

    private void doFeedExchangeUrl(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (!h.a()) {
            return;
        }
        QLog.d(TAG, 1, "[doFeedExchangeUrl]");
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(QFSPlayerOptionsExchangeUrlProcess.f92033a);
        RFWPlayerPreRenderBean f16 = gb0.b.f(getRenderBean(feedCloudMeta$StFeed, fb0.b.d(feedCloudMeta$StFeed, "cold_boot_unknown")));
        if (f16 == null) {
            QLog.d(TAG, 1, "[doFeedExchangeUrl] preloadBean is null");
        } else {
            RFWPlayerOptionsProcessManager.g().startProcess(linkedList, f16.getPlayerOptions(), new b(feedCloudMeta$StFeed));
        }
    }

    public static void doGetDoPrepare(IQCircleColdBootServiceV2.a aVar) {
        getInstance().doPrepare(aVar);
    }

    public static byte[] doGetPreloadReqByte(int i3) {
        if (i3 == 10) {
            return getInstance().getAllPushReqByte();
        }
        return getInstance().getNormalTabRedReqByte(i3);
    }

    public static IPreloadTask doGetTask(int i3) {
        return getInstance().getTask(i3);
    }

    @WorkerThread
    public static void doParsePreloadRspByte(final String str, final byte[] bArr, final int i3) {
        RFWThreadManager.getInstance().getSerialThreadHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.preload.coldbootV2.QCircleColdBootPreloadFeedManagerV2.3
            @Override // java.lang.Runnable
            public void run() {
                QCircleColdBootPreloadFeedManagerV2.getInstance().parsePreloadRspByte(str, bArr, i3);
            }
        });
    }

    private void doPreRenderPlayer(final FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (needInterceptVideoPreRender()) {
            QLog.d(TAG, 1, "[doPreRenderPlayer] needInterceptVideoPreRender return true");
            return;
        }
        Runnable runnable = this.mPreRenderRunnable;
        if (runnable != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.preload.coldbootV2.c
            @Override // java.lang.Runnable
            public final void run() {
                QCircleColdBootPreloadFeedManagerV2.this.lambda$doPreRenderPlayer$1(feedCloudMeta$StFeed);
            }
        };
        this.mPreRenderRunnable = runnable2;
        RFWPostAtFrontUtils.post(RFWThreadManager.getUIHandler(), runnable2);
    }

    private void doPrepare(IQCircleColdBootServiceV2.a aVar) {
        this.mCallback = aVar;
        if (!this.mEnableColdBootPreload) {
            aVar.onPrepared();
        } else {
            doPrepare(10000);
            doPrepare(10);
        }
    }

    private List<FeedCloudMeta$StPrePullCacheFeed> getCacheFeeds(int i3) {
        g gVar;
        if (this.mPreloadMap.containsKey(Integer.valueOf(i3)) && (gVar = this.mPreloadMap.get(Integer.valueOf(i3))) != null) {
            return gVar.g();
        }
        return new ArrayList();
    }

    private long getDelayTime() {
        try {
            return Long.parseLong(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_delay_time_when_change_to_foreground", "2000"));
        } catch (Exception e16) {
            QLog.d(TAG, 4, e16, new Object[0]);
            return Long.parseLong("2000");
        }
    }

    public static synchronized QCircleColdBootPreloadFeedManagerV2 getInstance() {
        QCircleColdBootPreloadFeedManagerV2 qCircleColdBootPreloadFeedManagerV2;
        synchronized (QCircleColdBootPreloadFeedManagerV2.class) {
            if (sInstance == null) {
                synchronized (QCircleColdBootPreloadFeedManagerV2.class) {
                    if (sInstance == null) {
                        sInstance = new QCircleColdBootPreloadFeedManagerV2();
                    }
                }
            }
            qCircleColdBootPreloadFeedManagerV2 = sInstance;
        }
        return qCircleColdBootPreloadFeedManagerV2;
    }

    private byte[] getNormalTabRedReqByte(int i3) {
        int i16;
        if (!this.mEnableColdBootPreload) {
            return null;
        }
        if (i3 == 75 && !uq3.c.V4()) {
            return null;
        }
        FeedCloudRead$StGetFeedListReq feedCloudRead$StGetFeedListReq = new FeedCloudRead$StGetFeedListReq();
        feedCloudRead$StGetFeedListReq.source.set(i3);
        feedCloudRead$StGetFeedListReq.from.set(0);
        feedCloudRead$StGetFeedListReq.adres.set(j.f90213a.j());
        QQCircleFeedBase$StFeedListBusiReqData qQCircleFeedBase$StFeedListBusiReqData = new QQCircleFeedBase$StFeedListBusiReqData();
        injectNewLayerArgs(qQCircleFeedBase$StFeedListBusiReqData);
        qQCircleFeedBase$StFeedListBusiReqData.pullSceneType.set(2);
        QQCircleFeedBase$StGetPrePullInfoReqV2 qQCircleFeedBase$StGetPrePullInfoReqV2 = new QQCircleFeedBase$StGetPrePullInfoReqV2();
        qQCircleFeedBase$StGetPrePullInfoReqV2.prePullMD.set(getPrePullMetaData(i3));
        PBEnumField pBEnumField = qQCircleFeedBase$StGetPrePullInfoReqV2.entranceMod;
        if (uq3.c.M6()) {
            i16 = 2;
        } else {
            i16 = 1;
        }
        pBEnumField.set(i16);
        qQCircleFeedBase$StGetPrePullInfoReqV2.redTouchCacheFeeds.set(getCacheFeeds(i3));
        qQCircleFeedBase$StFeedListBusiReqData.getPrePullInfoReqV2.set(qQCircleFeedBase$StGetPrePullInfoReqV2);
        feedCloudRead$StGetFeedListReq.busiReqData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StFeedListBusiReqData.toByteArray()));
        wrapRecExptConfig(feedCloudRead$StGetFeedListReq);
        QLog.d(TAG, 1, "full getNormalTabRedReqByte source", Integer.valueOf(i3));
        return feedCloudRead$StGetFeedListReq.toByteArray();
    }

    private static RFWPlayerPreRenderBean getRenderBean(FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
        if (feedCloudMeta$StFeed == null) {
            QLog.e(TAG, 1, "getRenderBean feed is null");
            return null;
        }
        e30.b bVar = new e30.b(feedCloudMeta$StFeed);
        RFWPlayerPreRenderBean multiLevel = new RFWPlayerPreRenderBean(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO(), 10002).setSourceType(str).setPreloadVideo(gb0.b.i(bVar)).setPreloadOriginData(gb0.b.m(bVar)).setMultiLevel(false);
        RFWPlayerOptions obtain = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO());
        obtain.setEnableDirectIP(false);
        multiLevel.setPlayerOptions(obtain);
        setPreRenderActivity(multiLevel);
        return multiLevel;
    }

    @WorkerThread
    private void handleAllPushNormalFeedFlag(@NonNull FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, @NonNull QQCircleFeedBase$PrePullRspFeedsOpActionDesc qQCircleFeedBase$PrePullRspFeedsOpActionDesc) {
        g gVar;
        if (qQCircleFeedBase$PrePullRspFeedsOpActionDesc.has() && this.mPreloadMap.containsKey(10) && (gVar = this.mPreloadMap.get(10)) != null) {
            gVar.handlePreloadRsp(feedCloudRead$StGetFeedListRsp, qQCircleFeedBase$PrePullRspFeedsOpActionDesc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void handleFeedExposeEvent(String str) {
        for (g gVar : this.mPreloadMap.values()) {
            if (gVar != null) {
                gVar.filterFeedById(str);
            }
        }
    }

    @WorkerThread
    private void handleRedTouchFlag(@NonNull FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, @NonNull QQCircleFeedBase$PrePullRspFeedsOpActionDesc qQCircleFeedBase$PrePullRspFeedsOpActionDesc, int i3) {
        g gVar;
        if (qQCircleFeedBase$PrePullRspFeedsOpActionDesc.has() && this.mPreloadMap.containsKey(Integer.valueOf(i3)) && (gVar = this.mPreloadMap.get(Integer.valueOf(i3))) != null) {
            gVar.handlePreloadRsp(feedCloudRead$StGetFeedListRsp, qQCircleFeedBase$PrePullRspFeedsOpActionDesc);
        }
    }

    private void init() {
        if (!this.mEnableColdBootPreload) {
            return;
        }
        QLog.d(TAG, 1, "init");
        this.mPreloadMap.put(10000, new g(10000, this));
        this.mPreloadMap.put(10, new g(10, this));
        this.mPreloadMap.put(75, new g(75, this));
    }

    private void injectNewLayerArgs(QQCircleFeedBase$StFeedListBusiReqData qQCircleFeedBase$StFeedListBusiReqData) {
        int i3;
        try {
            i3 = Integer.parseInt(uq3.c.x2());
        } catch (Exception e16) {
            QLog.e(TAG, 1, "injectNewLayerArgs error:", e16);
            i3 = 0;
        }
        QLog.i(TAG, 2, "isNewLayerMode:" + i3);
        if (i3 > 0) {
            qQCircleFeedBase$StFeedListBusiReqData.pageLayoutType.set(i3);
        }
    }

    private boolean isColdBootPreloadOpen(int i3) {
        if (this.mEnableColdBootPreload && getPreloadOpenFromServer(i3)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doPreRenderPlayer$1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (QCircleHostGlobalInfo.isCurrentTabActive()) {
            QLog.d(TAG, 1, "qcircle tab is active\uff0cdon't preload video player!");
            return;
        }
        if (QQVideoPlaySDKManager.isSDKReady()) {
            String d16 = fb0.b.d(feedCloudMeta$StFeed, "cold_boot_unknown");
            RFWPlayerPreRenderHelper.getInstance().playerRender(gb0.b.f(getRenderBean(feedCloudMeta$StFeed, d16)));
            QLog.d(TAG, 1, "isSDKReady\uff0cdo preRender! videoPlaySourceType:" + d16);
            return;
        }
        preRenderBySystemPlayer(feedCloudMeta$StFeed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onProcessForeground$0() {
        QLog.d(TAG, 1, "onAppForeground ");
        preInitWillPlayFeed();
    }

    private boolean needInterceptVideoPreRender() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void parsePreloadRspByte(String str, byte[] bArr, int i3) {
        if (!this.mEnableColdBootPreload) {
            return;
        }
        if (!this.mSourceWriteList.contains(Integer.valueOf(i3))) {
            QLog.e(TAG, 1, "[parsePreloadRspByte] mSourceWriteList not contains " + i3);
            return;
        }
        if (i3 == 10) {
            dealWithAllPushPreloadData(str, bArr);
        } else {
            dealWithNormalPreloadData(str, bArr, i3);
        }
    }

    @WorkerThread
    private void parsePreloadRspInnerAllPush(@NonNull FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, @NonNull QQCircleFeedBase$StGetPrePullInfoRspV2 qQCircleFeedBase$StGetPrePullInfoRspV2) {
        QLog.d(TAG, 1, "parsePreloadRspInnerAllPush vecFeed size: ", Integer.valueOf(feedCloudRead$StGetFeedListRsp.vecFeed.size()));
        handleRedTouchFlag(feedCloudRead$StGetFeedListRsp, qQCircleFeedBase$StGetPrePullInfoRspV2.redTouchFeedOpActions, 10000);
        handleAllPushNormalFeedFlag(feedCloudRead$StGetFeedListRsp, qQCircleFeedBase$StGetPrePullInfoRspV2.normalFeedOpActions);
    }

    @WorkerThread
    private void parsePreloadRspNormalRedPoint(@NonNull FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, @NonNull QQCircleFeedBase$StGetPrePullInfoRspV2 qQCircleFeedBase$StGetPrePullInfoRspV2, int i3) {
        QLog.d(TAG, 1, "parsePreloadRspNormalRedPoint vecFeed size: ", Integer.valueOf(feedCloudRead$StGetFeedListRsp.vecFeed.size()));
        handleRedTouchFlag(feedCloudRead$StGetFeedListRsp, qQCircleFeedBase$StGetPrePullInfoRspV2.redTouchFeedOpActions, i3);
    }

    private void preDownloadPlaySo() {
        if (uq3.c.X0("qqcircle", "qqcircle_enable_preload_download_player_so", 1).intValue() != 1) {
            QLog.d(TAG, 1, "preDownloadPlaySo not enable");
        }
        QQVideoPlaySDKManager.predownloadSo();
        QLog.d(TAG, 1, "preDownloadPlaySo enable");
    }

    private void preRenderBySystemPlayer(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (canUsePreRenderBySystemPlayer()) {
            String d16 = fb0.b.d(feedCloudMeta$StFeed, "cold_boot_unknown");
            RFWPlayerPreRenderHelper.getInstance().playerRender(gb0.b.f(getRenderBean(feedCloudMeta$StFeed, d16)).setForceRender(true));
            QLog.d(TAG, 1, "isSDK not Ready\uff0cdo preRender may by systemPlayer! videoPlaySourceType:" + d16);
            return;
        }
        QLog.d(TAG, 1, "isSDK not Ready \uff0cnot hit exp");
    }

    private void preRenderPlayer(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (!this.mEnableColdBootPreRender) {
            return;
        }
        doPreRenderPlayer(feedCloudMeta$StFeed);
    }

    public static synchronized void releaseInstance() {
        synchronized (QCircleColdBootPreloadFeedManagerV2.class) {
            if (sInstance != null) {
                synchronized (QCircleColdBootPreloadFeedManagerV2.class) {
                    if (sInstance != null) {
                        sInstance.destroy();
                        sInstance = null;
                    }
                }
            }
            QCircleApplication.onAccountChanged();
        }
    }

    private static void setPreRenderActivity(RFWPlayerPreRenderBean rFWPlayerPreRenderBean) {
        if (rFWPlayerPreRenderBean == null || !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_can_use_pre_render_set_top_activity", true)) {
            return;
        }
        Activity n3 = p40.f.n();
        if (n3 == null) {
            QLog.e(TAG, 1, "setPreRenderActivity activity is null");
            return;
        }
        QLog.e(TAG, 1, "setPreRenderActivity activity is " + n3 + ",isDestroy:" + n3.isDestroyed() + ",isFinish:" + n3.isFinishing());
        rFWPlayerPreRenderBean.setActivity(n3);
    }

    private void wrapRecExptConfig(FeedCloudRead$StGetFeedListReq feedCloudRead$StGetFeedListReq) {
        RecExptInfo k3 = QCirclePluginGlobalInfo.k();
        if (k3 != null && !TextUtils.isEmpty(k3.exptConfig)) {
            FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry.key.set(KEY_REC_EXPT_CONFIG);
            feedCloudCommon$Entry.value.set(k3.jsonString);
            feedCloudRead$StGetFeedListReq.extInfo.setHasFlag(true);
            feedCloudRead$StGetFeedListReq.extInfo.mapInfo.add(feedCloudCommon$Entry);
            QLog.d(TAG, 1, "wrapRecExptConfig done,config:", k3.exptConfig);
        }
    }

    @Override // cb0.a
    public void doPreloadImage(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        Option url;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        QLog.d(TAG, 2, "doPreloadImage url:" + feedCloudMeta$StFeed.cover.picUrl.get());
        if (TextUtils.isEmpty(feedCloudMeta$StFeed.cover.layerPicUrl.get())) {
            url = Option.obtain().setUrl(feedCloudMeta$StFeed.cover.picUrl.get());
        } else {
            url = Option.obtain().setUrl(feedCloudMeta$StFeed.cover.layerPicUrl.get());
        }
        url.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        QCircleFeedPicLoader.g().loadImage(url);
    }

    @Override // cb0.a
    @WorkerThread
    public void doPreloadVideo(FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z16) {
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        this.mPreloadFeed = feedCloudMeta$StFeed;
        QLog.d(TAG, 1, "doPreloadVideo id:" + feedCloudMeta$StFeed.f398449id.get() + " | trace id: " + ba.d(feedCloudMeta$StFeed));
        StringBuilder sb5 = new StringBuilder();
        sb5.append("preload video now, enablePreRender:");
        sb5.append(z16);
        QLog.d("QCirclePreloadProcess", 1, sb5.toString());
        doPreloadVideoNow(feedCloudMeta$StFeed, z16);
    }

    @WorkerThread
    public void doPreloadVideoNow(FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z16) {
        gb0.b.w();
        preDownloadPlaySo();
        if (z16) {
            preRenderPlayer(feedCloudMeta$StFeed);
        }
        preDownloadVideo(feedCloudMeta$StFeed);
        QLog.d(TAG, 1, "doPreloadVideo direct, url:" + feedCloudMeta$StFeed.video.playUrl.get());
    }

    public void doPrepareSpData() {
        if (!this.mEnableColdBootPreload || !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_can_pre_load_feed_sp_data", true)) {
            return;
        }
        QLog.d(TAG, 1, "doPrepareSpData");
        doPrepare(10000);
        doPrepare(10);
    }

    public byte[] getAllPushReqByte() {
        if (!this.mEnableColdBootPreload) {
            return null;
        }
        FeedCloudRead$StGetFeedListReq feedCloudRead$StGetFeedListReq = new FeedCloudRead$StGetFeedListReq();
        feedCloudRead$StGetFeedListReq.source.set(10);
        feedCloudRead$StGetFeedListReq.from.set(0);
        feedCloudRead$StGetFeedListReq.adres.set(j.f90213a.j());
        QQCircleFeedBase$StFeedListBusiReqData qQCircleFeedBase$StFeedListBusiReqData = new QQCircleFeedBase$StFeedListBusiReqData();
        injectNewLayerArgs(qQCircleFeedBase$StFeedListBusiReqData);
        int i3 = 2;
        qQCircleFeedBase$StFeedListBusiReqData.pullSceneType.set(2);
        QQCircleFeedBase$StGetPrePullInfoReqV2 qQCircleFeedBase$StGetPrePullInfoReqV2 = new QQCircleFeedBase$StGetPrePullInfoReqV2();
        qQCircleFeedBase$StGetPrePullInfoReqV2.prePullMD.set(getPrePullMetaData(10));
        PBEnumField pBEnumField = qQCircleFeedBase$StGetPrePullInfoReqV2.entranceMod;
        if (!uq3.c.M6()) {
            i3 = 1;
        }
        pBEnumField.set(i3);
        qQCircleFeedBase$StGetPrePullInfoReqV2.redTouchCacheFeeds.set(getCacheFeeds(10000));
        qQCircleFeedBase$StGetPrePullInfoReqV2.normalCacheFeeds.set(getCacheFeeds(10));
        qQCircleFeedBase$StFeedListBusiReqData.getPrePullInfoReqV2.set(qQCircleFeedBase$StGetPrePullInfoReqV2);
        feedCloudRead$StGetFeedListReq.busiReqData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StFeedListBusiReqData.toByteArray()));
        wrapRecExptConfig(feedCloudRead$StGetFeedListReq);
        cq.f92752a.b(feedCloudRead$StGetFeedListReq);
        return feedCloudRead$StGetFeedListReq.toByteArray();
    }

    public List<FeedCloudMeta$StFeed> getCurNormalPreloadFeeds() {
        IPreloadTask task = getTask(10);
        if (task == null) {
            QLog.d(TAG, 1, "getCurNormalPreloadFeeds failed!");
            return null;
        }
        Object preloadRsp = task.getPreloadRsp();
        if (!(preloadRsp instanceof FeedCloudRead$StGetFeedListRsp)) {
            return null;
        }
        return new ArrayList(((FeedCloudRead$StGetFeedListRsp) preloadRsp).vecFeed.get());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSFeedExposeEvent.class);
        return arrayList;
    }

    protected QQCircleFeedBase$PrePullMetaData getPrePullMetaData(int i3) {
        QQCircleFeedBase$PrePullMetaData qQCircleFeedBase$PrePullMetaData = this.mMetaDatas.get(Integer.valueOf(i3));
        if (qQCircleFeedBase$PrePullMetaData != null) {
            return qQCircleFeedBase$PrePullMetaData;
        }
        QQCircleFeedBase$PrePullMetaData b16 = e.b(i3);
        this.mMetaDatas.put(Integer.valueOf(i3), b16);
        return b16;
    }

    public boolean getPreloadOpenFromServer(int i3) {
        QQCircleFeedBase$PrePullMetaData prePullMetaData = getPrePullMetaData(i3);
        if (prePullMetaData != null) {
            return prePullMetaData.isOpenPrePull.get();
        }
        return true;
    }

    public IPreloadTask getTask(int i3) {
        if (!isColdBootPreloadOpen(i3)) {
            return null;
        }
        if (!this.mSourceWriteList.contains(Integer.valueOf(i3))) {
            QLog.e(TAG, 1, "don't support input source: " + i3);
            return null;
        }
        if (!this.mPreloadMap.containsKey(Integer.valueOf(i3))) {
            QLog.e(TAG, 1, "getTask failed,source: " + i3);
            return null;
        }
        QLog.d(TAG, 2, "getTask success,source: ", Integer.valueOf(i3));
        return this.mPreloadMap.get(Integer.valueOf(i3));
    }

    @Override // cb0.a
    public void onPreloadFeedChange(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QLog.d(TAG, 1, "onPreloadFeedChange");
        preInitWillPlayFeed();
    }

    public void onProcessBackground() {
        QLog.d(TAG, 1, "onProcessBackground ");
        if (this.mForegroundRunnable == null) {
            return;
        }
        RFWThreadManager.getInstance().remove(this.mForegroundRunnable);
    }

    public void onProcessForeground() {
        com.tencent.mobileqq.qcircle.api.global.a.a();
        if (this.mForegroundRunnable == null) {
            this.mForegroundRunnable = new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.preload.coldbootV2.b
                @Override // java.lang.Runnable
                public final void run() {
                    QCircleColdBootPreloadFeedManagerV2.this.lambda$onProcessForeground$0();
                }
            };
        }
        RFWThreadManager.getInstance().remove(this.mForegroundRunnable);
        RFWThreadManager.getInstance().execOnSubThread(this.mForegroundRunnable, getDelayTime());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(final SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSFeedExposeEvent) {
            RFWThreadManager.getInstance().getSerialThreadHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.preload.coldbootV2.QCircleColdBootPreloadFeedManagerV2.4
                @Override // java.lang.Runnable
                public void run() {
                    QCircleColdBootPreloadFeedManagerV2.this.handleFeedExposeEvent(((QFSFeedExposeEvent) simpleBaseEvent).getFeedId());
                }
            });
        }
    }

    @Override // cb0.a
    public void onRspPreload() {
        g gVar = this.mPreloadMap.get(10);
        g gVar2 = this.mPreloadMap.get(10000);
        if (gVar != null && gVar.k() && gVar2 != null && gVar2.k()) {
            QLog.d(TAG, 1, "onRspPreload all task ready");
            IQCircleColdBootServiceV2.a aVar = this.mCallback;
            if (aVar != null) {
                aVar.onPrepared();
            }
        }
    }

    public void onVideoPlaySucceed() {
        long currentTimeMillis = System.currentTimeMillis();
        QLog.d(TAG, 1, "onVideoPlaySucceed " + currentTimeMillis);
        k.a().n("sp_key_user_last_play_video_time", currentTimeMillis);
        this.mLastVideoPlayTime = currentTimeMillis;
    }

    public void preDownloadVideo(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        String d16 = fb0.b.d(feedCloudMeta$StFeed, "cold_boot_unknown");
        if (QQVideoPlaySDKManager.isDownloadSDKReady()) {
            RFWVideoPreloadManager.g(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).preloadVideo(gb0.b.n(feedCloudMeta$StFeed, false), d16);
            QFSTopViewManager.e().k(feedCloudMeta$StFeed);
            QFSEcommerceTopViewManager.b().g(feedCloudMeta$StFeed);
            QLog.d(TAG, 1, "isDownloadSDKReady\uff0cdo preload! videoPlaySourceType:" + d16);
            return;
        }
        QLog.d(TAG, 1, "isDownloadSDK not ready init first");
        QQVideoPlaySDKManager.initDownloadSDKAsync(RFWApplication.getApplication(), new c(feedCloudMeta$StFeed, d16));
    }

    public void preInitWillPlayFeed() {
        if (QCircleHostGlobalInfo.isCurrentTabActive()) {
            QLog.d(TAG, 1, "[preInitWillPlayFeed] isCurrentTabActive ");
            return;
        }
        FeedCloudMeta$StFeed g16 = k30.h.f().g(false);
        if (g16 == null) {
            QLog.d(TAG, 1, "[preInitWillPlayFeed] not get need retry feed ");
            return;
        }
        QLog.d(TAG, 1, "[preInitWillPlayFeed] real do");
        preRenderPlayer(g16);
        doFeedExchangeUrl(g16);
    }

    @WorkerThread
    protected void savePrePullMetaData(QQCircleFeedBase$StGetPrePullInfoRspV2 qQCircleFeedBase$StGetPrePullInfoRspV2, int i3) {
        this.mMetaDatas.put(Integer.valueOf(i3), qQCircleFeedBase$StGetPrePullInfoRspV2.prePullMD);
        e.c(qQCircleFeedBase$StGetPrePullInfoRspV2.prePullMD, i3);
    }

    protected void doPrepare(int i3) {
        if (!this.mPreloadMap.containsKey(Integer.valueOf(i3))) {
            this.mPreloadMap.put(Integer.valueOf(i3), new g(i3, this));
        }
        g gVar = this.mPreloadMap.get(Integer.valueOf(i3));
        if (gVar != null) {
            QLog.d(TAG, 1, "preload sp cache feed,source: " + i3);
            gVar.preloadFeed();
        }
    }
}
