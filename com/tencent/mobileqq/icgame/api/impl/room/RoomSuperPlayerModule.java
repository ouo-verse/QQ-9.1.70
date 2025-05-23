package com.tencent.mobileqq.icgame.api.impl.room;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.activity.richmedia.i;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.icgame.api.room.AudienceRoomConfig;
import com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView;
import com.tencent.mobileqq.icgame.api.room.PlayerConfig;
import com.tencent.mobileqq.icgame.api.room.StreamType;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.mobileqq.videoplatform.api.ILog;
import com.tencent.mobileqq.videoplatform.util.LogUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IQQLiveHEVCAbilityKt;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.common.TPVideoSeiInfo;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.MobileQQ;

/* loaded from: classes15.dex */
public class RoomSuperPlayerModule implements RoomPlayModule, ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnVideoSizeChangedListener, ISuperPlayer.OnInfoListener {
    private static final String APP_ID_UNKNOWN = "-1";
    private static final long DEFAULT_RETRY_TIME = 10;
    private static final int FLV_PRELOAD_DURATION_MS = 600;
    private static final int FLV_PRELOAD_SIZE = 419430400;
    private static final int MIN_UPDATE_DOWNLOAD_INFO_INTERVAL = 1000;
    private static final String SCENE_LIVE_ROOM = "live_room";
    private static final int[] SPECIAL_SEI_ARRAY = {243};
    private boolean canRecycle;
    private PlayerConfig config;
    private Context context;
    private String currentUrl;
    private final IAegisLogApi iAegisLogApi;
    private long intervalTime;
    private long lastTotalMediaSize;
    private String mAppId;
    private long mOnFirstFrameComeTime;
    private long mOpenMediaPlayerTime;
    private String mTrafficFlowReportScene;
    private List<TPOptionalParam> options;
    private boolean playerOnlyPauseWhenReset;
    private ITPPlayerVideoView playerView;
    private String requestProtocol;
    private final Runnable retryRunnable;
    private PlayRetryStrategy retryStrategy;
    private ISPlayerVideoView superPlayerView;
    private String tag;
    private final Runnable updateDownloadInfoRunnable;
    private Runnable updateDownloadInfoRunnableRet;
    private ISuperPlayer player = null;
    private int prepareStatus = 0;
    private boolean isPlaySoon = false;
    private final List<b32.a> playerListeners = new CopyOnWriteArrayList();
    private boolean isDestroy = false;
    private int currentStatus = 0;
    private boolean isPreload = false;
    private boolean isSdkPreparing = false;
    private final List<Runnable> preOperate = new ArrayList();
    private i videoSize = null;

    public RoomSuperPlayerModule(String str, boolean z16, PlayerConfig playerConfig) {
        this.tag = "";
        IAegisLogApi iAegisLogApi = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        this.iAegisLogApi = iAegisLogApi;
        this.intervalTime = 2000L;
        this.retryStrategy = new ResumeRetryStrategy();
        this.playerOnlyPauseWhenReset = false;
        this.options = new ArrayList();
        this.canRecycle = true;
        this.retryRunnable = new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.RoomSuperPlayerModule.1
            @Override // java.lang.Runnable
            public void run() {
                RoomSuperPlayerModule.this.iAegisLogApi.e(RoomSuperPlayerModule.this.tag, 1, "try play url is " + RoomSuperPlayerModule.this.currentUrl);
                RoomSuperPlayerModule.this.startPlay("");
            }
        };
        this.updateDownloadInfoRunnableRet = null;
        this.requestProtocol = new String();
        this.updateDownloadInfoRunnable = new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.RoomSuperPlayerModule.8
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                if (RoomSuperPlayerModule.this.config == null) {
                    RoomSuperPlayerModule.this.iAegisLogApi.e(RoomSuperPlayerModule.this.tag, "updateDownloadInfoRunnable config is null!");
                    return;
                }
                int i3 = RoomSuperPlayerModule.this.config.updateDownloadInfoDuration;
                long totalMediaSize = RoomSuperPlayerModule.this.getTotalMediaSize();
                if (totalMediaSize < 0) {
                    RoomSuperPlayerModule.this.iAegisLogApi.e(RoomSuperPlayerModule.this.tag, "updateDownloadInfoRunnable! player state is error! size:" + totalMediaSize);
                    return;
                }
                if (totalMediaSize <= 0 || totalMediaSize < RoomSuperPlayerModule.this.lastTotalMediaSize) {
                    RoomSuperPlayerModule.this.lastTotalMediaSize = totalMediaSize;
                }
                int i16 = i3 / 1000;
                if (i16 <= 0) {
                    RoomSuperPlayerModule.this.iAegisLogApi.i(RoomSuperPlayerModule.this.tag, "updateDownloadInfoRunnable timeSecond is error! timeSecond:" + i16);
                    return;
                }
                long j3 = (totalMediaSize - RoomSuperPlayerModule.this.lastTotalMediaSize) / i16;
                long mediaBufferSize = RoomSuperPlayerModule.this.getMediaBufferSize();
                long mediaBufferDuration = RoomSuperPlayerModule.this.getMediaBufferDuration();
                RoomSuperPlayerModule.this.lastTotalMediaSize = totalMediaSize;
                RoomSuperPlayerModule.this.updateDownloadInfo(totalMediaSize, mediaBufferSize, mediaBufferDuration, j3, System.currentTimeMillis() - currentTimeMillis);
                if (RoomSuperPlayerModule.this.player != null && RoomSuperPlayerModule.this.getCurrentStatus() != 1 && !RoomSuperPlayerModule.this.isPlaySoon && mediaBufferDuration >= RoomSuperPlayerModule.this.config.minBufferDuration) {
                    RoomSuperPlayerModule.this.player.pauseDownload();
                    RoomSuperPlayerModule.this.iAegisLogApi.i(RoomSuperPlayerModule.this.tag, "\u9884\u52a0\u8f7d\u89c6\u9891\u7f13\u5b58\u5b8c\u6bd5\uff01 prepareStatus:" + RoomSuperPlayerModule.this.prepareStatus + " isPlaySoon:false cacheDuration:" + mediaBufferDuration);
                    return;
                }
                if (!RoomSuperPlayerModule.this.isDestroy && RoomSuperPlayerModule.this.player != null && i3 >= 1000) {
                    RoomSuperPlayerModule roomSuperPlayerModule = RoomSuperPlayerModule.this;
                    roomSuperPlayerModule.updateDownloadInfoRunnableRet = ThreadManagerV2.executeDelay(roomSuperPlayerModule.updateDownloadInfoRunnable, 16, null, false, i3);
                }
            }
        };
        this.tag = "RoomSuperPlayerModule" + hashCode();
        this.config = playerConfig;
        this.mAppId = TextUtils.isEmpty(str) ? "-1" : str;
        this.mTrafficFlowReportScene = "live_room_app_id_" + this.mAppId;
        Context applicationContext = BaseApplication.getContext().getApplicationContext();
        this.context = applicationContext;
        ISPlayerVideoView createPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(applicationContext, playerConfig.isUseTextureView);
        this.superPlayerView = createPlayerVideoView;
        View renderView = createPlayerVideoView.getRenderView();
        if ((renderView instanceof SurfaceView) && playerConfig.isZOrderMediaOverlay) {
            iAegisLogApi.i(this.tag, 1, "SurfaceView setZOrderMediaOverlay.");
            ((SurfaceView) renderView).setZOrderMediaOverlay(true);
        }
        this.playerView = new u42.a(this.superPlayerView);
        this.retryStrategy.bindPlayModule(this);
        if (QQVideoPlaySDKManager.isSDKReady()) {
            initSuperPlayerLog();
            initPlayer(z16);
        } else {
            initVideoSdk(this.context, z16);
        }
    }

    private void checkNeedReOpen(String str) {
        if (!TextUtils.isEmpty(this.currentUrl) && !str.equals(this.currentUrl) && this.player != null) {
            resetPlayerInner();
        }
    }

    private boolean checkSdkStatus(final String str, final boolean z16) {
        if (this.player != null) {
            return true;
        }
        if (this.isSdkPreparing) {
            this.iAegisLogApi.e(this.tag, 1, "play when sdk is preparing isPreload is " + z16);
            this.preOperate.add(new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.RoomSuperPlayerModule.3
                @Override // java.lang.Runnable
                public void run() {
                    if (z16) {
                        RoomSuperPlayerModule.this.preloadUrl(str);
                    } else {
                        RoomSuperPlayerModule.this.startPlay(str);
                    }
                }
            });
            return false;
        }
        this.iAegisLogApi.e(this.tag, 1, "play when but sdk init failed");
        Iterator<b32.a> it = this.playerListeners.iterator();
        while (it.hasNext()) {
            it.next().onError(5104, "videoSDK init failed");
        }
        return false;
    }

    private void configSuperPlayerParam(SuperPlayerOption superPlayerOption, SuperPlayerVideoInfo superPlayerVideoInfo, String str) {
        if (this.config.format == AudienceRoomConfig.VideoFormat.FLV && !isRtmpUrl(str)) {
            if (this.config.isEnableDownloadProxy) {
                openFlvPreload(superPlayerOption, superPlayerVideoInfo);
            }
            if (this.config.isSupportQuicFLv) {
                openFlvPreload(superPlayerOption, superPlayerVideoInfo);
                SuperPlayerDownOption superPlayerDownOption = superPlayerOption.superPlayerDownOption;
                superPlayerDownOption.quicEnableMode = 2;
                superPlayerDownOption.enableQuicPlaintext = this.config.enableQuicPlaintext;
            }
        }
        Map<String, String> map = this.config.httpHeader;
        if (map != null) {
            superPlayerOption.httpHeader = map;
        }
    }

    private void detectHevcAbility() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        boolean decodeBool = from.decodeBool(IQQLiveHEVCAbilityKt.KEY_QQLIVE_HEVC_HAS_DETECTED, false);
        this.iAegisLogApi.d(this.tag, "[detectHevcAbility] hasDetected=" + decodeBool);
        if (!decodeBool) {
            int i3 = -1;
            try {
                i3 = com.tencent.superplayer.utils.e.d(172, 102).getMaxLevel();
                this.iAegisLogApi.i(this.tag, "[detectHevcAbility] level=" + i3);
            } catch (Exception e16) {
                this.iAegisLogApi.e(this.tag, "[detectHevcAbility] error: ", e16);
            }
            from.encodeInt(IQQLiveHEVCAbilityKt.KEY_QQLIVE_HEVC_SUPPORT_LEVEL, i3);
            from.encodeBool(IQQLiveHEVCAbilityKt.KEY_QQLIVE_HEVC_HAS_DETECTED, true);
        }
    }

    private void executePreOperate() {
        if (this.preOperate.size() > 0) {
            Iterator<Runnable> it = this.preOperate.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }
        this.preOperate.clear();
    }

    private String getAccountStr() {
        AppInterface a16 = t42.d.a();
        if (a16 == null) {
            return null;
        }
        return a16.getAccount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getMediaBufferDuration() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getMediaBufferSize() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getTotalMediaSize() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleInfo, reason: merged with bridge method [inline-methods] */
    public void lambda$onInfo$2(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
        int i16;
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<b32.a> it = this.playerListeners.iterator();
        while (it.hasNext()) {
            it.next().onInfo(i3, j3, j16, obj);
        }
        if (i3 != 105) {
            if (i3 != 126) {
                if (i3 != 112) {
                    if (i3 != 113) {
                        if (i3 != 253) {
                            if (i3 == 254) {
                                this.iAegisLogApi.i(this.tag, 1, "onAutoRecover");
                                Iterator<b32.a> it5 = this.playerListeners.iterator();
                                while (it5.hasNext()) {
                                    it5.next().onAutoRecover(getPlayUrl());
                                }
                                return;
                            }
                            return;
                        }
                        this.iAegisLogApi.i(this.tag, 1, "onAutoDeInit");
                        Iterator<b32.a> it6 = this.playerListeners.iterator();
                        while (it6.hasNext()) {
                            it6.next().onAutoDeInit(getPlayUrl());
                        }
                        return;
                    }
                    this.iAegisLogApi.i(this.tag, 1, "onBufferEnd");
                    Iterator<b32.a> it7 = this.playerListeners.iterator();
                    while (it7.hasNext()) {
                        it7.next().onStopBuffer();
                    }
                    return;
                }
                this.iAegisLogApi.i(this.tag, 1, "onStartBuffer");
                Iterator<b32.a> it8 = this.playerListeners.iterator();
                while (it8.hasNext()) {
                    it8.next().onStartBuffer();
                }
                return;
            }
            if (obj instanceof TPVideoSeiInfo) {
                a32.c cVar = new a32.c();
                TPVideoSeiInfo tPVideoSeiInfo = (TPVideoSeiInfo) obj;
                cVar.f25431d = tPVideoSeiInfo.getSeiData();
                if (tPVideoSeiInfo.getSeiData() != null) {
                    i16 = tPVideoSeiInfo.getSeiData().length;
                } else {
                    i16 = 0;
                }
                cVar.f25430c = i16;
                cVar.f25428a = tPVideoSeiInfo.getCodecType();
                cVar.f25429b = tPVideoSeiInfo.getSeiType();
                Iterator<b32.a> it9 = this.playerListeners.iterator();
                while (it9.hasNext()) {
                    it9.next().onInfo(cVar);
                }
                return;
            }
            return;
        }
        this.iAegisLogApi.i(this.tag, 1, "on firstFrame rendered");
        this.mOnFirstFrameComeTime = currentTimeMillis;
        Iterator<b32.a> it10 = this.playerListeners.iterator();
        while (it10.hasNext()) {
            it10.next().onFirstFrameCome(this.mOpenMediaPlayerTime, this.mOnFirstFrameComeTime);
        }
    }

    private void initPlayer(boolean z16) {
        if (this.player == null) {
            ISuperPlayer b16 = s32.a.c().b();
            this.player = b16;
            if (b16 == null) {
                this.player = SuperPlayerFactory.createMediaPlayer(this.context, 139, this.superPlayerView);
            } else {
                setVideoSurface();
            }
            this.player.updatePlayerSceneId(139);
            this.player.setOnVideoPreparedListener(this);
            this.player.setOnErrorListener(this);
            this.player.setOnCompletionListener(this);
            this.player.setOnInfoListener(this);
            this.player.setOnVideoSizeChangedListener(this);
            this.player.setOutputMute(z16);
            this.player.addExtReportData("param_uin", getAccountStr());
            updatePlayerOptions();
            detectHevcAbility();
        }
    }

    private void initSuperPlayerLog() {
        if (!this.config.enableOpenPlayerAllLog) {
            LogUtil.setLogImp(new com.tencent.mobileqq.qqvideoplatform.imp.b());
            this.iAegisLogApi.i(this.tag, 1, "initSuperPlayerLog \u6536\u96c6error\u65e5\u5fd7");
        } else {
            this.iAegisLogApi.i(this.tag, 1, "initSuperPlayerLog \u6536\u96c6\u5168\u91cf\u65e5\u5fd7");
            LogUtil.setLogImp(new ILog() { // from class: com.tencent.mobileqq.icgame.api.impl.room.RoomSuperPlayerModule.2
                @Override // com.tencent.mobileqq.videoplatform.api.ILog
                public void d(String str, int i3, String str2) {
                    QLog.d(str, 1, str2);
                }

                @Override // com.tencent.mobileqq.videoplatform.api.ILog
                public void e(String str, int i3, String str2) {
                    QLog.e(str, 1, str2);
                }

                @Override // com.tencent.mobileqq.videoplatform.api.ILog
                public void i(String str, int i3, String str2) {
                    QLog.i(str, 1, str2);
                }

                @Override // com.tencent.mobileqq.videoplatform.api.ILog
                public boolean isColorLevel() {
                    return true;
                }

                @Override // com.tencent.mobileqq.videoplatform.api.ILog
                public void v(String str, int i3, String str2) {
                    QLog.d(str, 1, str2);
                }

                @Override // com.tencent.mobileqq.videoplatform.api.ILog
                public void w(String str, int i3, String str2) {
                    QLog.w(str, 1, str2);
                }

                @Override // com.tencent.mobileqq.videoplatform.api.ILog
                public void e(String str, int i3, String str2, Throwable th5) {
                    QLog.e(str, 1, str2, th5);
                }
            });
        }
    }

    private void initVideoSdk(Context context, final boolean z16) {
        this.iAegisLogApi.e(this.tag, 1, "waite videoSdk init");
        this.isSdkPreparing = true;
        QQVideoPlaySDKManager.initSDKAsync(context, new SDKInitListener() { // from class: com.tencent.mobileqq.icgame.api.impl.room.d
            @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
            public final void onSDKInited(boolean z17) {
                RoomSuperPlayerModule.this.lambda$initVideoSdk$1(z16, z17);
            }
        });
    }

    private boolean isRtmpUrl(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("rtmp://")) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initVideoSdk$0(boolean z16, boolean z17) {
        this.iAegisLogApi.i(this.tag, "videoSdk init " + z16 + ", isDestroy " + this.isDestroy);
        if (this.isDestroy) {
            return;
        }
        this.isSdkPreparing = false;
        if (z16) {
            initSuperPlayerLog();
            initPlayer(z17);
            executePreOperate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initVideoSdk$1(final boolean z16, final boolean z17) {
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.b
            @Override // java.lang.Runnable
            public final void run() {
                RoomSuperPlayerModule.this.lambda$initVideoSdk$0(z17, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateDownloadInfo$3(long j3, long j16, long j17, long j18) {
        for (b32.a aVar : this.playerListeners) {
            if (aVar != null) {
                aVar.onUpdateDownloadInfo(j3, j16, j17, j18);
            }
        }
    }

    private void onPreparing() {
        Iterator<b32.a> it = this.playerListeners.iterator();
        while (it.hasNext()) {
            it.next().onPreparing(StreamType.FLV, this.currentUrl, this.config);
        }
    }

    private void onStop() {
        Iterator<b32.a> it = this.playerListeners.iterator();
        while (it.hasNext()) {
            it.next().onStop();
        }
    }

    private static void openFlvPreload(SuperPlayerOption superPlayerOption, SuperPlayerVideoInfo superPlayerVideoInfo) {
        superPlayerOption.enableDownloadProxy = Boolean.TRUE;
        superPlayerOption.superPlayerDownOption.enableFlvPreloadMode = true;
        superPlayerVideoInfo.getExtraDownloadParams().put("dl_param_preload_duration", String.valueOf(600));
        superPlayerVideoInfo.getExtraDownloadParams().put("dl_param_preload_size", String.valueOf(419430400));
    }

    private void openMediaPlayer(String str) {
        int i3;
        SuperPlayerOption obtain = SuperPlayerOption.obtain();
        if (this.config.format == AudienceRoomConfig.VideoFormat.FLV && !isRtmpUrl(str)) {
            i3 = 202;
        } else {
            i3 = 203;
        }
        if (isRtmpUrl(str)) {
            i3 = 103;
        }
        SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(str, i3, (String) null);
        configSuperPlayerParam(obtain, createVideoInfoForUrl, str);
        updatePlayerOptions();
        this.mOpenMediaPlayerTime = System.currentTimeMillis();
        this.player.openMediaPlayer(this.context, createVideoInfoForUrl, 0L, obtain);
        this.canRecycle = false;
        startUpdateDownloadInfoRunnable();
    }

    private void playWhenUrlIsNullOrEqCurUrl() {
        int i3 = this.prepareStatus;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    this.player.resumeDownload();
                    this.player.start();
                    this.currentStatus = 1;
                    Iterator<b32.a> it = this.playerListeners.iterator();
                    while (it.hasNext()) {
                        it.next().onPlay();
                    }
                    this.iAegisLogApi.i(this.tag, "player.start startUpdateDownloadInfoRunnable");
                    startUpdateDownloadInfoRunnable();
                    return;
                }
                return;
            }
            this.isPlaySoon = true;
            return;
        }
        if (!TextUtils.isEmpty(this.currentUrl)) {
            String str = this.currentUrl;
            this.currentUrl = "";
            startPlay(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetPlayerInner() {
        stopUpdateDownloadInfoRunnable();
        this.player.stop();
        this.player.reset();
        this.prepareStatus = 0;
        this.requestProtocol = "";
        setVideoSurface();
        this.player.setPlayerOptionalParamList(this.options);
    }

    private void resetVideoSize() {
        this.videoSize = null;
    }

    private void runOnUiThread(Runnable runnable) {
        ThreadManagerV2.getUIHandlerV2().post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUpdateDownloadInfoRunnable() {
        Object valueOf;
        PlayerConfig playerConfig = this.config;
        if (playerConfig != null && playerConfig.updateDownloadInfoDuration >= 1000) {
            stopUpdateDownloadInfoRunnable();
            int i3 = this.config.updateDownloadInfoDuration;
            if (i3 < 1000) {
                this.iAegisLogApi.w(this.tag, "startUpdateCacheInfoRunnable is disable, updateDuration:" + i3);
                return;
            }
            this.iAegisLogApi.i(this.tag, "startUpdateCacheInfoRunnable updateDuration:" + i3);
            this.updateDownloadInfoRunnableRet = ThreadManagerV2.executeDelay(this.updateDownloadInfoRunnable, 16, null, false, (long) i3);
            return;
        }
        IAegisLogApi iAegisLogApi = this.iAegisLogApi;
        String str = this.tag;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("startUpdateCacheInfoRunnable is disable, updateDownloadInfoDuration:");
        PlayerConfig playerConfig2 = this.config;
        if (playerConfig2 == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(playerConfig2.updateDownloadInfoDuration);
        }
        sb5.append(valueOf);
        iAegisLogApi.w(str, sb5.toString());
    }

    private void stopRetry() {
        ThreadManager.getUIHandler().removeCallbacks(this.retryRunnable);
    }

    private void stopUpdateDownloadInfoRunnable() {
        this.iAegisLogApi.i(this.tag, "stopUpdateCacheInfoRunnable " + this.updateDownloadInfoRunnableRet);
        Runnable runnable = this.updateDownloadInfoRunnableRet;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 16);
            this.updateDownloadInfoRunnableRet = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDownloadInfo(final long j3, final long j16, final long j17, final long j18, long j19) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.c
            @Override // java.lang.Runnable
            public final void run() {
                RoomSuperPlayerModule.this.lambda$updateDownloadInfo$3(j3, j16, j17, j18);
            }
        });
    }

    private void updatePlayerOptions() {
        this.options.clear();
        this.options.add(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_BUFFER_PACKET_TOTAL_DURATION_MS, this.config.maxBufferDuration));
        long j3 = this.config.bufferingPacketDurationMin;
        if (j3 > 0) {
            this.options.add(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_BUFFERING_FOR_PLAYBACK_MS, j3));
        }
        this.options.add(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_BUFFERING_TIMEOUT_MS, this.config.bufferingTimeOut));
        this.options.add(TPOptionalParam.buildQueueInt(TPOptionalID.OPTIONAL_ID_BEFORE_QUEUE_INT_SPECIAL_SEI_TYPES_CALLBACK, SPECIAL_SEI_ARRAY));
        if (this.config.format == AudienceRoomConfig.VideoFormat.FLV) {
            this.options.add(TPOptionalParam.buildQueueInt(TPOptionalID.OPTIONAL_ID_BEFORE_QUEUE_INT_DEMUXER_TYPE, new int[]{1}));
            this.options.add(TPOptionalParam.buildInt(TPOptionalID.OPTIONAL_ID_BEFORE_INT_BUFFER_STRATEGY, 2));
        }
        this.options.add(TPOptionalParam.buildLong(TPDownloadProxyEnum.DLPARAM_PLAYER_BUFFER_MINI_DURATION, this.config.minBufferDuration));
        int i3 = this.config.latencyStrategy.action;
        this.options.add(TPOptionalParam.buildInt(TPOptionalID.OPTIONAL_ID_BEFORE_INT_REDUCE_LIVE_LATENCY_ACTION, i3));
        if (i3 == 1) {
            this.options.add(TPOptionalParam.buildFloat(TPOptionalID.OPTIONAL_ID_BEFORE_FLOAT_REDUCE_LATENCY_SPEED_UP_RATE, this.config.speedUpRate));
        }
        this.player.setPlayerOptionalParamList(this.options);
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void destroy() {
        this.iAegisLogApi.i(this.tag, 1, "destroy player:" + this.player + ", playerView:" + this.playerView + " canRecycle:" + this.canRecycle);
        this.isDestroy = true;
        stopUpdateDownloadInfoRunnable();
        resetVideoSize();
        stopRetry();
        this.preOperate.clear();
        this.playerListeners.clear();
        ISuperPlayer iSuperPlayer = this.player;
        if (iSuperPlayer != null) {
            if (this.canRecycle) {
                s32.a.c().d(this.player);
            } else {
                iSuperPlayer.release();
            }
            this.player = null;
        }
        this.playerView = null;
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public boolean disableViewCallback() {
        return this.superPlayerView.disableViewCallback();
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public boolean enableViewCallback() {
        return this.superPlayerView.enableViewCallback();
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public int getCurrentStatus() {
        return this.currentStatus;
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public String getPlayUrl() {
        return this.currentUrl;
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public List<b32.a> getRoomPlayerListeners() {
        return this.playerListeners;
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    @NonNull
    public i getVideoSize() {
        i iVar = this.videoSize;
        if (iVar == null) {
            return new i(0, 0);
        }
        return iVar;
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public ITPPlayerVideoView getVideoView() {
        return this.playerView;
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public boolean isOutputMute() {
        ISuperPlayer iSuperPlayer = this.player;
        if (iSuperPlayer != null) {
            return iSuperPlayer.isOutputMute();
        }
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
    public void onCompletion(ISuperPlayer iSuperPlayer) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.RoomSuperPlayerModule.4
            @Override // java.lang.Runnable
            public void run() {
                if (!RoomSuperPlayerModule.this.isDestroy) {
                    RoomSuperPlayerModule.this.resetPlayerInner();
                    RoomSuperPlayerModule.this.currentStatus = 3;
                    Iterator it = RoomSuperPlayerModule.this.playerListeners.iterator();
                    while (it.hasNext()) {
                        ((b32.a) it.next()).onPlayCompleted();
                    }
                    RoomSuperPlayerModule.this.iAegisLogApi.e(RoomSuperPlayerModule.this.tag, 1, "onCompletion url:" + RoomSuperPlayerModule.this.currentUrl);
                    RoomSuperPlayerModule.this.retry();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void onEnterRoom(LiveInfo liveInfo, String str, boolean z16) {
        this.iAegisLogApi.i(this.tag, "onEnterRoom liveInfo:" + liveInfo + " isPause:" + z16 + " url:" + str);
        if (TextUtils.isEmpty(getPlayUrl())) {
            setPlayUrl(str);
        }
        if (TextUtils.isEmpty(str)) {
            this.iAegisLogApi.w(this.tag, 1, "url is empty room status is " + liveInfo.watchMediaInfo.mVideoStatus);
            return;
        }
        if (!z16) {
            startPlay(str);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
    public boolean onError(ISuperPlayer iSuperPlayer, final int i3, final int i16, final int i17, final String str) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.RoomSuperPlayerModule.5
            @Override // java.lang.Runnable
            public void run() {
                if (!RoomSuperPlayerModule.this.isDestroy) {
                    RoomSuperPlayerModule.this.iAegisLogApi.e(RoomSuperPlayerModule.this.tag, "player error module:" + i3 + " errorType:" + i16 + " errorCode:" + i17 + " extraInfo:" + str);
                    RoomSuperPlayerModule.this.resetPlayerInner();
                    if (RoomSuperPlayerModule.this.playerView != null && MobileQQ.sProcessId != 7) {
                        RoomSuperPlayerModule.this.playerView.blackScreen(true);
                    }
                    RoomSuperPlayerModule.this.retryStrategy.onError(i3, i16, i17, str);
                    RoomSuperPlayerModule.this.currentStatus = 0;
                }
            }
        });
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
    public boolean onInfo(final ISuperPlayer iSuperPlayer, final int i3, final long j3, final long j16, final Object obj) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            lambda$onInfo$2(iSuperPlayer, i3, j3, j16, obj);
            return false;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.e
            @Override // java.lang.Runnable
            public final void run() {
                RoomSuperPlayerModule.this.lambda$onInfo$2(iSuperPlayer, i3, j3, j16, obj);
            }
        });
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
    public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.RoomSuperPlayerModule.6
            @Override // java.lang.Runnable
            public void run() {
                RoomSuperPlayerModule.this.iAegisLogApi.i(RoomSuperPlayerModule.this.tag, 1, "onVideoPrepared isPlaySoon: " + RoomSuperPlayerModule.this.isPlaySoon + " url:" + RoomSuperPlayerModule.this.currentUrl);
                if (RoomSuperPlayerModule.this.isDestroy) {
                    return;
                }
                if (RoomSuperPlayerModule.this.playerView != null && MobileQQ.sProcessId != 7) {
                    RoomSuperPlayerModule.this.playerView.blackScreen(false);
                }
                if (RoomSuperPlayerModule.this.isPlaySoon) {
                    RoomSuperPlayerModule.this.isPlaySoon = false;
                    RoomSuperPlayerModule.this.player.resumeDownload();
                    RoomSuperPlayerModule.this.player.start();
                    RoomSuperPlayerModule.this.currentStatus = 1;
                    Iterator it = RoomSuperPlayerModule.this.playerListeners.iterator();
                    while (it.hasNext()) {
                        ((b32.a) it.next()).onPlay();
                    }
                    RoomSuperPlayerModule.this.iAegisLogApi.i(RoomSuperPlayerModule.this.tag, "onVideoPrepared startUpdateDownloadInfoRunnable");
                    RoomSuperPlayerModule.this.startUpdateDownloadInfoRunnable();
                }
                RoomSuperPlayerModule.this.prepareStatus = 2;
                RoomSuperPlayerModule.this.retryStrategy.onPrepared();
                RoomSuperPlayerModule.this.canRecycle = true;
            }
        });
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(ISuperPlayer iSuperPlayer, final int i3, final int i16) {
        this.videoSize = new i(i3, i16);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.RoomSuperPlayerModule.7
            @Override // java.lang.Runnable
            public void run() {
                if (RoomSuperPlayerModule.this.superPlayerView != null) {
                    RoomSuperPlayerModule.this.superPlayerView.setFixedSize(i3, i16);
                }
                Iterator it = RoomSuperPlayerModule.this.playerListeners.iterator();
                while (it.hasNext()) {
                    ((b32.a) it.next()).onVideoSizeChanged(i3, i16);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void pause() {
        this.iAegisLogApi.i(this.tag, 1, "pause prepareStatus:" + this.prepareStatus + " status:" + getCurrentStatus());
        if (this.player != null) {
            this.iAegisLogApi.i(this.tag, 1, "pause player state:" + this.player.getCurrentPlayerState());
        }
        this.isPlaySoon = false;
        ISuperPlayer iSuperPlayer = this.player;
        if (iSuperPlayer != null && iSuperPlayer.isPlaying()) {
            this.player.pause();
            this.currentStatus = 2;
            Iterator<b32.a> it = this.playerListeners.iterator();
            while (it.hasNext()) {
                it.next().onPause();
            }
            return;
        }
        if (this.isSdkPreparing) {
            this.iAegisLogApi.e(this.tag, 1, "pause when sdk is preparing");
            this.preOperate.clear();
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void playerOnlyPauseWhenReset(boolean z16) {
        this.playerOnlyPauseWhenReset = z16;
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void preloadUrl(String str) {
        this.isPreload = true;
        this.iAegisLogApi.i(this.tag, 1, "preload: " + str + " cur: " + this.currentUrl + " status is " + this.prepareStatus);
        stopRetry();
        if (TextUtils.isEmpty(str) || !checkSdkStatus(str, true)) {
            return;
        }
        checkNeedReOpen(str);
        if (this.player != null && !str.equals(this.currentUrl)) {
            this.currentUrl = str;
            this.prepareStatus = 1;
            onPreparing();
            openMediaPlayer(str);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void registerRoomPlayerListener(b32.a aVar) {
        if (aVar != null && !this.playerListeners.contains(aVar)) {
            this.playerListeners.add(aVar);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void replay() {
        QLog.i(this.tag, 1, "replay curUrl: " + this.currentUrl);
        if (this.player == null) {
            QLog.e(this.tag, 1, "replay player is null");
        } else {
            resetPlayerInner();
            startPlay(this.currentUrl);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void reset() {
        if (this.isDestroy) {
            return;
        }
        this.iAegisLogApi.i(this.tag, 1, "reset playerOnlyPauseWhenReset:" + this.playerOnlyPauseWhenReset);
        resetVideoSize();
        this.preOperate.clear();
        this.prepareStatus = 0;
        this.currentUrl = "";
        this.isPlaySoon = false;
        Object obj = this.superPlayerView;
        if (obj != null && (obj instanceof View)) {
            ViewParent parent = ((View) obj).getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView((View) this.superPlayerView);
            }
        }
        resetPlayer();
        this.playerListeners.clear();
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void resetPlayer() {
        stopRetry();
        this.retryStrategy.reset();
        if (this.playerOnlyPauseWhenReset) {
            ISuperPlayer iSuperPlayer = this.player;
            if (iSuperPlayer != null && iSuperPlayer.isPlaying()) {
                this.player.pause();
                this.currentStatus = 2;
                Iterator<b32.a> it = this.playerListeners.iterator();
                while (it.hasNext()) {
                    it.next().onPause();
                }
                return;
            }
            return;
        }
        if (this.player != null) {
            resetPlayerInner();
            onStop();
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void retry() {
        this.iAegisLogApi.i(this.tag, 1, "retry isPreload: " + this.isPreload);
        if (!this.isPreload) {
            stopRetry();
            ThreadManager.getUIHandler().postDelayed(this.retryRunnable, this.intervalTime);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void setMute(boolean z16) {
        ISuperPlayer iSuperPlayer = this.player;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOutputMute(z16);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void setPlayUrl(String str) {
        this.currentUrl = str;
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void setRetryParams(long j3, int i3) {
        PlayRetryStrategy playRetryStrategy;
        if (j3 == -1) {
            j3 = 2000;
        }
        this.intervalTime = j3;
        if (i3 == -1) {
            playRetryStrategy = new ResumeRetryStrategy();
        } else {
            NormalRetryStrategy normalRetryStrategy = new NormalRetryStrategy();
            normalRetryStrategy.retryTime = i3;
            playRetryStrategy = normalRetryStrategy;
        }
        playRetryStrategy.bindPlayModule(this);
        this.retryStrategy = playRetryStrategy;
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void setVideoSurface() {
        this.player.setXYaxis(this.playerView.getViewRenderMode());
        this.player.updatePlayerVideoView(this.superPlayerView);
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void startPlay(String str) {
        this.isPreload = false;
        this.iAegisLogApi.i(this.tag, 1, "start: " + str + " cur: " + this.currentUrl + " status is " + this.prepareStatus);
        stopRetry();
        if (!checkSdkStatus(str, false)) {
            return;
        }
        ISuperPlayer iSuperPlayer = this.player;
        if (iSuperPlayer != null) {
            iSuperPlayer.setXYaxis(this.playerView.getViewRenderMode());
        }
        if (!TextUtils.isEmpty(str) && !str.equals(this.currentUrl)) {
            checkNeedReOpen(str);
            if (this.prepareStatus == 0) {
                this.isPlaySoon = true;
                this.currentUrl = str;
                this.prepareStatus = 1;
                onPreparing();
                openMediaPlayer(str);
                return;
            }
            return;
        }
        playWhenUrlIsNullOrEqCurUrl();
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void switchDefinition(String str) {
        if (this.player == null) {
            QLog.i(this.tag, 1, "switchDefinition fail! player is null!");
            return;
        }
        QLog.i(this.tag, 1, "switchDefinition status:" + getCurrentStatus() + " isPlaying: " + this.player.isPlaying() + " isPausing:" + this.player.isPausing() + " spStatus: " + this.player.getCurrentPlayerState() + " url:" + str);
        if (this.prepareStatus != 1 && getCurrentStatus() != 2 && this.prepareStatus != 0) {
            if (getCurrentStatus() == 1 && this.player.isPlaying()) {
                this.currentUrl = str;
                this.player.switchDefinitionForUrl(str, 2);
                return;
            } else {
                this.currentUrl = "";
                if (this.player != null) {
                    resetPlayerInner();
                }
                startPlay(str);
                return;
            }
        }
        QLog.i(this.tag, 1, "switchDefinition player has paused or preparing!");
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void unRegisterRoomPlayerListener(b32.a aVar) {
        this.playerListeners.remove(aVar);
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void setRetryParams(long j3, int i3, PlayRetryStrategy playRetryStrategy) {
        if (playRetryStrategy == null) {
            return;
        }
        if (j3 == -1) {
            j3 = 2000;
        }
        this.intervalTime = j3;
        ((ThirdpushRetryStrategy) playRetryStrategy).retryTime = i3;
        playRetryStrategy.bindPlayModule(this);
        this.retryStrategy = playRetryStrategy;
    }
}
