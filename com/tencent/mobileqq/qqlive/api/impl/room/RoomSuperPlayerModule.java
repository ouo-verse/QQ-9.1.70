package com.tencent.mobileqq.qqlive.api.impl.room;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.richmedia.i;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqlive.api.monitor.IResourceProvider;
import com.tencent.mobileqq.qqlive.api.monitor.ISuperPlayerTrafficFlowReportApi;
import com.tencent.mobileqq.qqlive.api.monitor.ISuperPlayerTrafficFlowReporter;
import com.tencent.mobileqq.qqlive.api.player.IPlayerChangeUrlManager;
import com.tencent.mobileqq.qqlive.api.room.AudienceRoomConfig;
import com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView;
import com.tencent.mobileqq.qqlive.api.room.PlayerConfig;
import com.tencent.mobileqq.qqlive.callback.room.VideoSeiInfo;
import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener;
import com.tencent.mobileqq.qqlive.utils.g;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.mobileqq.videoplatform.api.ILog;
import com.tencent.mobileqq.videoplatform.util.LogUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.common.api.IQQLiveHEVCAbilityKt;
import com.tencent.superplayer.api.ISuperPlayer;
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

/* loaded from: classes17.dex */
public class RoomSuperPlayerModule implements RoomPlayModule, ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnVideoSizeChangedListener, ISuperPlayer.OnInfoListener {
    static IPatchRedirector $redirector_ = null;
    private static final String APP_ID_UNKNOWN = "-1";
    private static final long DEFAULT_RETRY_TIME = 10;
    private static final int FLV_PRELOAD_DURATION_MS;
    private static final long FLV_PRELOAD_SIZE;
    private static final int MIN_UPDATE_DOWNLOAD_INFO_INTERVAL = 1000;
    private static final String SCENE_LIVE_ROOM = "live_room";
    private static final int[] SPECIAL_SEI_ARRAY;
    private boolean canRecycle;
    private PlayerConfig config;
    private Context context;
    private int currentStatus;
    private String currentUrl;
    private final IAegisLogApi iAegisLogApi;
    private long intervalTime;
    private boolean isDestroy;
    private boolean isPlaySoon;
    private boolean isPreload;
    private boolean isSdkPreparing;
    private long lastTotalMediaSize;
    private String mAppId;
    private long mOnFirstFrameComeTime;
    private long mOpenMediaPlayerTime;
    private String mTrafficFlowReportScene;
    private List<TPOptionalParam> options;
    private ISuperPlayer player;
    private IPlayerChangeUrlManager playerChangeUrlManager;
    final CopyOnWriteArrayList<AudienceRoomPlayerListener> playerListeners;
    private boolean playerOnlyPauseWhenReset;
    private ITPPlayerVideoView playerView;
    private final List<Runnable> preOperate;
    private int prepareStatus;
    private String requestProtocol;
    private final Runnable retryRunnable;
    private PlayRetryStrategy retryStrategy;
    private ISPlayerVideoView superPlayerView;
    private String tag;
    private ISuperPlayerTrafficFlowReporter trafficFlowReporter;
    private final Runnable updateDownloadInfoRunnable;
    private Runnable updateDownloadInfoRunnableRet;
    private i videoSize;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61059);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 35)) {
            redirector.redirect((short) 35);
            return;
        }
        FLV_PRELOAD_DURATION_MS = ht3.a.b("qqlive_flv_download_proxy_preload_duration", 1200);
        FLV_PRELOAD_SIZE = ht3.a.c("qqlive_flv_download_proxy_preload_size", 2684354560L);
        SPECIAL_SEI_ARRAY = new int[]{243};
    }

    public RoomSuperPlayerModule(String str, boolean z16) {
        this(str, z16, new PlayerConfig());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, str, Boolean.valueOf(z16));
    }

    private void checkNeedReOpen(String str) {
        if (!TextUtils.isEmpty(this.currentUrl) && !str.equals(this.currentUrl) && this.player != null) {
            resetPlayerInner();
        }
    }

    private boolean checkSdkStatus(String str, boolean z16) {
        if (this.player != null) {
            return true;
        }
        if (this.isSdkPreparing) {
            this.iAegisLogApi.e(this.tag, 1, "play when sdk is preparing isPreload is " + z16);
            this.preOperate.add(new Runnable(z16, str) { // from class: com.tencent.mobileqq.qqlive.api.impl.room.RoomSuperPlayerModule.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean val$isPreload;
                final /* synthetic */ String val$url;

                {
                    this.val$isPreload = z16;
                    this.val$url = str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, RoomSuperPlayerModule.this, Boolean.valueOf(z16), str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else if (this.val$isPreload) {
                        RoomSuperPlayerModule.this.preloadUrl(this.val$url);
                    } else {
                        RoomSuperPlayerModule.this.startPlay(this.val$url);
                    }
                }
            });
            return false;
        }
        this.iAegisLogApi.e(this.tag, 1, "play when but sdk init failed");
        Iterator<AudienceRoomPlayerListener> it = this.playerListeners.iterator();
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
                PlayerConfig playerConfig = this.config;
                if (playerConfig.enableQUIC) {
                    superPlayerOption.superPlayerDownOption.quicEnableMode = 2;
                }
                superPlayerOption.superPlayerDownOption.enableQuicPlaintext = playerConfig.enableQuicPlaintext;
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
        AppInterface a16 = g.a();
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
    public void lambda$onInfo$3(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
        int i16;
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<AudienceRoomPlayerListener> it = this.playerListeners.iterator();
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
                                Iterator<AudienceRoomPlayerListener> it5 = this.playerListeners.iterator();
                                while (it5.hasNext()) {
                                    it5.next().onAutoRecover(getPlayUrl());
                                }
                                return;
                            }
                            return;
                        }
                        this.iAegisLogApi.i(this.tag, 1, "onAutoDeInit");
                        Iterator<AudienceRoomPlayerListener> it6 = this.playerListeners.iterator();
                        while (it6.hasNext()) {
                            it6.next().onAutoDeInit(getPlayUrl());
                        }
                        return;
                    }
                    this.iAegisLogApi.i(this.tag, 1, "onBufferEnd");
                    Iterator<AudienceRoomPlayerListener> it7 = this.playerListeners.iterator();
                    while (it7.hasNext()) {
                        it7.next().onStopBuffer();
                    }
                    return;
                }
                this.iAegisLogApi.i(this.tag, 1, "onStartBuffer");
                Iterator<AudienceRoomPlayerListener> it8 = this.playerListeners.iterator();
                while (it8.hasNext()) {
                    it8.next().onStartBuffer();
                }
                return;
            }
            if (obj instanceof TPVideoSeiInfo) {
                VideoSeiInfo videoSeiInfo = new VideoSeiInfo();
                TPVideoSeiInfo tPVideoSeiInfo = (TPVideoSeiInfo) obj;
                videoSeiInfo.seiData = tPVideoSeiInfo.getSeiData();
                if (tPVideoSeiInfo.getSeiData() != null) {
                    i16 = tPVideoSeiInfo.getSeiData().length;
                } else {
                    i16 = 0;
                }
                videoSeiInfo.seiDataSize = i16;
                videoSeiInfo.videoCodecType = tPVideoSeiInfo.getCodecType();
                videoSeiInfo.videoSeiType = tPVideoSeiInfo.getSeiType();
                Iterator<AudienceRoomPlayerListener> it9 = this.playerListeners.iterator();
                while (it9.hasNext()) {
                    it9.next().onInfo(videoSeiInfo);
                }
                return;
            }
            return;
        }
        this.iAegisLogApi.i(this.tag, 1, "on firstFrame rendered");
        ISuperPlayerTrafficFlowReporter iSuperPlayerTrafficFlowReporter = this.trafficFlowReporter;
        if (iSuperPlayerTrafficFlowReporter != null) {
            iSuperPlayerTrafficFlowReporter.onPlayerFirstFrameCome();
        }
        this.mOnFirstFrameComeTime = currentTimeMillis;
        Iterator<AudienceRoomPlayerListener> it10 = this.playerListeners.iterator();
        while (it10.hasNext()) {
            it10.next().onFirstFrameCome(this.mOpenMediaPlayerTime, this.mOnFirstFrameComeTime);
        }
    }

    private void initPlayer(boolean z16) {
        if (this.player == null) {
            int i3 = this.config.playerSceneID;
            ISuperPlayer b16 = com.tencent.mobileqq.qqlive.player.a.c().b();
            this.player = b16;
            if (b16 == null) {
                this.player = SuperPlayerFactory.createMediaPlayer(this.context, i3, this.superPlayerView);
            } else {
                setVideoSurface();
            }
            this.player.updatePlayerSceneId(i3);
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
        ISuperPlayerTrafficFlowReporter trafficFlowReporter = ((ISuperPlayerTrafficFlowReportApi) QRoute.api(ISuperPlayerTrafficFlowReportApi.class)).getTrafficFlowReporter(this.mTrafficFlowReportScene, this.player, new IResourceProvider() { // from class: com.tencent.mobileqq.qqlive.api.impl.room.d
            @Override // com.tencent.mobileqq.qqlive.api.monitor.IResourceProvider
            public final String getUrl() {
                String lambda$initPlayer$2;
                lambda$initPlayer$2 = RoomSuperPlayerModule.this.lambda$initPlayer$2();
                return lambda$initPlayer$2;
            }
        });
        this.trafficFlowReporter = trafficFlowReporter;
        trafficFlowReporter.init();
    }

    private void initSuperPlayerLog() {
        if (!this.config.enableOpenPlayerAllLog) {
            LogUtil.setLogImp(new com.tencent.mobileqq.qqvideoplatform.imp.b());
            this.iAegisLogApi.i(this.tag, 1, "initSuperPlayerLog \u6536\u96c6error\u65e5\u5fd7");
        } else {
            this.iAegisLogApi.i(this.tag, 1, "initSuperPlayerLog \u6536\u96c6\u5168\u91cf\u65e5\u5fd7");
            LogUtil.setLogImp(new ILog() { // from class: com.tencent.mobileqq.qqlive.api.impl.room.RoomSuperPlayerModule.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) RoomSuperPlayerModule.this);
                    }
                }

                @Override // com.tencent.mobileqq.videoplatform.api.ILog
                public void d(String str, int i3, String str2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), str2);
                    } else {
                        QLog.d(str, 1, str2);
                    }
                }

                @Override // com.tencent.mobileqq.videoplatform.api.ILog
                public void e(String str, int i3, String str2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                        QLog.e(str, 1, str2);
                    } else {
                        iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), str2);
                    }
                }

                @Override // com.tencent.mobileqq.videoplatform.api.ILog
                public void i(String str, int i3, String str2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), str2);
                    } else {
                        QLog.i(str, 1, str2);
                    }
                }

                @Override // com.tencent.mobileqq.videoplatform.api.ILog
                public boolean isColorLevel() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                    }
                    return true;
                }

                @Override // com.tencent.mobileqq.videoplatform.api.ILog
                public void v(String str, int i3, String str2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), str2);
                    } else {
                        QLog.d(str, 1, str2);
                    }
                }

                @Override // com.tencent.mobileqq.videoplatform.api.ILog
                public void w(String str, int i3, String str2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                        iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), str2);
                    } else {
                        QLog.w(str, 1, str2);
                    }
                }

                @Override // com.tencent.mobileqq.videoplatform.api.ILog
                public void e(String str, int i3, String str2, Throwable th5) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                        QLog.e(str, 1, str2, th5);
                    } else {
                        iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), str2, th5);
                    }
                }
            });
        }
    }

    private void initVideoSdk(Context context, final boolean z16) {
        this.iAegisLogApi.e(this.tag, 1, "waite videoSdk init");
        this.isSdkPreparing = true;
        QQVideoPlaySDKManager.initSDKAsync(context, new SDKInitListener() { // from class: com.tencent.mobileqq.qqlive.api.impl.room.e
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
    public /* synthetic */ String lambda$initPlayer$2() {
        if (TextUtils.isEmpty(this.currentUrl)) {
            return "";
        }
        return this.currentUrl;
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
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqlive.api.impl.room.a
            @Override // java.lang.Runnable
            public final void run() {
                RoomSuperPlayerModule.this.lambda$initVideoSdk$0(z17, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateDownloadInfo$4(long j3, long j16, long j17, long j18) {
        Iterator<AudienceRoomPlayerListener> it = this.playerListeners.iterator();
        while (it.hasNext()) {
            AudienceRoomPlayerListener next = it.next();
            if (next != null) {
                next.onUpdateDownloadInfo(j3, j16, j17, j18);
            }
        }
    }

    private void onPreparing() {
        Iterator<AudienceRoomPlayerListener> it = this.playerListeners.iterator();
        while (it.hasNext()) {
            it.next().onPreparing(this.currentUrl, this.config);
        }
    }

    private void onStop() {
        Iterator<AudienceRoomPlayerListener> it = this.playerListeners.iterator();
        while (it.hasNext()) {
            it.next().onStop();
        }
    }

    private static void openFlvPreload(SuperPlayerOption superPlayerOption, SuperPlayerVideoInfo superPlayerVideoInfo) {
        superPlayerOption.enableDownloadProxy = Boolean.TRUE;
        superPlayerOption.superPlayerDownOption.enableFlvPreloadMode = true;
        superPlayerVideoInfo.getExtraDownloadParams().put("dl_param_preload_duration", String.valueOf(FLV_PRELOAD_DURATION_MS));
        superPlayerVideoInfo.getExtraDownloadParams().put("dl_param_preload_size", String.valueOf(FLV_PRELOAD_SIZE));
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
                    Iterator<AudienceRoomPlayerListener> it = this.playerListeners.iterator();
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

    private void tryChangeUrlRePlay(int i3) {
        IPlayerChangeUrlManager iPlayerChangeUrlManager = this.playerChangeUrlManager;
        if (iPlayerChangeUrlManager == null || !iPlayerChangeUrlManager.needChangeUrl(i3)) {
            return;
        }
        this.playerChangeUrlManager.getChangedUrl(new IPlayerChangeUrlManager.Callback() { // from class: com.tencent.mobileqq.qqlive.api.impl.room.RoomSuperPlayerModule.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) RoomSuperPlayerModule.this);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.api.player.IPlayerChangeUrlManager.Callback
            public void onError(long j3, @Nullable String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    RoomSuperPlayerModule.this.iAegisLogApi.e(RoomSuperPlayerModule.this.tag, "getChangedUrl error, errCode:" + j3 + ", errMsg:" + str);
                    return;
                }
                iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), str);
            }

            @Override // com.tencent.mobileqq.qqlive.api.player.IPlayerChangeUrlManager.Callback
            public void onResult(@NonNull String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    RoomSuperPlayerModule.this.iAegisLogApi.i(RoomSuperPlayerModule.this.tag, "getChangedUrl success, url:" + str);
                    ThreadManager.getUIHandler().post(new Runnable(str) { // from class: com.tencent.mobileqq.qqlive.api.impl.room.RoomSuperPlayerModule.6.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ String val$url;

                        {
                            this.val$url = str;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass6.this, (Object) str);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else if (!TextUtils.isEmpty(this.val$url)) {
                                RoomSuperPlayerModule.this.currentUrl = this.val$url;
                                RoomSuperPlayerModule.this.replay();
                            }
                        }
                    });
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDownloadInfo(final long j3, final long j16, final long j17, final long j18, long j19) {
        IAegisLogApi iAegisLogApi = this.iAegisLogApi;
        String str = this.tag;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("updateDownloadInfo isPlaying: ");
        boolean z16 = true;
        if (getCurrentStatus() != 1) {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append(" totalSize:");
        sb5.append(((float) j3) / 1024.0f);
        sb5.append("KB cacheSize:");
        sb5.append(((float) j16) / 1024.0f);
        sb5.append("KB cacheDuration:");
        sb5.append(((float) j17) / 1000.0f);
        sb5.append("\u79d2 speed:");
        sb5.append(((float) j18) / 1024.0f);
        sb5.append("KB/s useTime:");
        sb5.append(j19);
        sb5.append("ms");
        iAegisLogApi.i(str, sb5.toString());
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.api.impl.room.b
            @Override // java.lang.Runnable
            public final void run() {
                RoomSuperPlayerModule.this.lambda$updateDownloadInfo$4(j3, j16, j17, j18);
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

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.RoomPlayModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
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
                com.tencent.mobileqq.qqlive.player.a.c().d(this.player);
            } else {
                iSuperPlayer.release();
            }
            this.player = null;
        }
        this.playerView = null;
        ISuperPlayerTrafficFlowReporter iSuperPlayerTrafficFlowReporter = this.trafficFlowReporter;
        if (iSuperPlayerTrafficFlowReporter != null) {
            iSuperPlayerTrafficFlowReporter.unInit();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.RoomPlayModule
    public boolean disableViewCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        return this.superPlayerView.disableViewCallback();
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.RoomPlayModule
    public boolean enableViewCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this)).booleanValue();
        }
        return this.superPlayerView.enableViewCallback();
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.RoomPlayModule
    public int getCurrentStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.currentStatus;
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.RoomPlayModule
    public String getPlayUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.currentUrl;
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.RoomPlayModule
    public IPlayerChangeUrlManager getPlayerChangeUrlManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IPlayerChangeUrlManager) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.playerChangeUrlManager;
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.RoomPlayModule
    public List<AudienceRoomPlayerListener> getPlayerListeners() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (List) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.playerListeners;
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.RoomPlayModule
    @NonNull
    public i getVideoSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (i) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        i iVar = this.videoSize;
        if (iVar == null) {
            return new i(0, 0);
        }
        return iVar;
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.RoomPlayModule
    public ITPPlayerVideoView getVideoView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (ITPPlayerVideoView) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.playerView;
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.RoomPlayModule
    public boolean isOutputMute() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        ISuperPlayer iSuperPlayer = this.player;
        if (iSuperPlayer != null) {
            return iSuperPlayer.isOutputMute();
        }
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
    public void onCompletion(ISuperPlayer iSuperPlayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) iSuperPlayer);
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.api.impl.room.RoomSuperPlayerModule.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RoomSuperPlayerModule.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (!RoomSuperPlayerModule.this.isDestroy) {
                        RoomSuperPlayerModule.this.resetPlayerInner();
                        RoomSuperPlayerModule.this.currentStatus = 3;
                        Iterator<AudienceRoomPlayerListener> it = RoomSuperPlayerModule.this.playerListeners.iterator();
                        while (it.hasNext()) {
                            it.next().onPlayCompleted();
                        }
                        RoomSuperPlayerModule.this.iAegisLogApi.e(RoomSuperPlayerModule.this.tag, 1, "onCompletion url:" + RoomSuperPlayerModule.this.currentUrl);
                        RoomSuperPlayerModule.this.retry();
                    }
                }
            });
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
    public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, this, iSuperPlayer, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str)).booleanValue();
        }
        ThreadManager.getUIHandler().post(new Runnable(i3, i16, i17, str) { // from class: com.tencent.mobileqq.qqlive.api.impl.room.RoomSuperPlayerModule.5
            static IPatchRedirector $redirector_;
            final /* synthetic */ int val$errorCode;
            final /* synthetic */ int val$errorType;
            final /* synthetic */ String val$extraInfo;
            final /* synthetic */ int val$module;

            {
                this.val$module = i3;
                this.val$errorType = i16;
                this.val$errorCode = i17;
                this.val$extraInfo = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, RoomSuperPlayerModule.this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (!RoomSuperPlayerModule.this.isDestroy) {
                    RoomSuperPlayerModule.this.iAegisLogApi.e(RoomSuperPlayerModule.this.tag, "player error module:" + this.val$module + " errorType:" + this.val$errorType + " errorCode:" + this.val$errorCode + " extraInfo:" + this.val$extraInfo);
                    RoomSuperPlayerModule.this.resetPlayerInner();
                    if (RoomSuperPlayerModule.this.playerView != null && MobileQQ.sProcessId != 7) {
                        RoomSuperPlayerModule.this.playerView.blackScreen(true);
                    }
                    RoomSuperPlayerModule.this.retryStrategy.onError(this.val$module, this.val$errorType, this.val$errorCode, this.val$extraInfo);
                    RoomSuperPlayerModule.this.currentStatus = 0;
                }
            }
        });
        tryChangeUrlRePlay(i17);
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
    public boolean onInfo(final ISuperPlayer iSuperPlayer, final int i3, final long j3, final long j16, final Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, this, iSuperPlayer, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), obj)).booleanValue();
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            lambda$onInfo$3(iSuperPlayer, i3, j3, j16, obj);
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.api.impl.room.c
                @Override // java.lang.Runnable
                public final void run() {
                    RoomSuperPlayerModule.this.lambda$onInfo$3(iSuperPlayer, i3, j3, j16, obj);
                }
            });
        }
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
    public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) iSuperPlayer);
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.api.impl.room.RoomSuperPlayerModule.7
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RoomSuperPlayerModule.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
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
                            Iterator<AudienceRoomPlayerListener> it = RoomSuperPlayerModule.this.playerListeners.iterator();
                            while (it.hasNext()) {
                                it.next().onPlay();
                            }
                            RoomSuperPlayerModule.this.iAegisLogApi.i(RoomSuperPlayerModule.this.tag, "onVideoPrepared startUpdateDownloadInfoRunnable");
                            RoomSuperPlayerModule.this.startUpdateDownloadInfoRunnable();
                        }
                        RoomSuperPlayerModule.this.prepareStatus = 2;
                        RoomSuperPlayerModule.this.retryStrategy.onPrepared();
                        RoomSuperPlayerModule.this.canRecycle = true;
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(ISuperPlayer iSuperPlayer, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, iSuperPlayer, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.videoSize = new i(i3, i16);
            ThreadManager.getUIHandler().post(new Runnable(i3, i16) { // from class: com.tencent.mobileqq.qqlive.api.impl.room.RoomSuperPlayerModule.8
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$h;
                final /* synthetic */ int val$w;

                {
                    this.val$w = i3;
                    this.val$h = i16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, RoomSuperPlayerModule.this, Integer.valueOf(i3), Integer.valueOf(i16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (RoomSuperPlayerModule.this.superPlayerView != null) {
                        RoomSuperPlayerModule.this.superPlayerView.setFixedSize(this.val$w, this.val$h);
                    }
                    Iterator<AudienceRoomPlayerListener> it = RoomSuperPlayerModule.this.playerListeners.iterator();
                    while (it.hasNext()) {
                        it.next().onVideoSizeChanged(this.val$w, this.val$h);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.RoomPlayModule
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        this.iAegisLogApi.i(this.tag, 1, "pause prepareStatus:" + this.prepareStatus + " status:" + getCurrentStatus());
        if (this.player != null) {
            this.iAegisLogApi.i(this.tag, 1, "pause player state:" + this.player.getCurrentPlayerState());
        }
        this.isPlaySoon = false;
        ISuperPlayer iSuperPlayer = this.player;
        if (iSuperPlayer != null && iSuperPlayer.isPlaying()) {
            this.player.pause();
            this.currentStatus = 2;
            Iterator<AudienceRoomPlayerListener> it = this.playerListeners.iterator();
            while (it.hasNext()) {
                it.next().onPause();
            }
            ISuperPlayerTrafficFlowReporter iSuperPlayerTrafficFlowReporter = this.trafficFlowReporter;
            if (iSuperPlayerTrafficFlowReporter != null) {
                iSuperPlayerTrafficFlowReporter.onPlayerPause();
                return;
            }
            return;
        }
        if (this.isSdkPreparing) {
            this.iAegisLogApi.e(this.tag, 1, "pause when sdk is preparing");
            this.preOperate.clear();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.RoomPlayModule
    public void playerOnlyPauseWhenReset(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
        } else {
            this.playerOnlyPauseWhenReset = z16;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.RoomPlayModule
    public void preloadUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
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

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.RoomPlayModule
    public void registerRoomPlayerListener(AudienceRoomPlayerListener audienceRoomPlayerListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) audienceRoomPlayerListener);
        } else if (!this.playerListeners.contains(audienceRoomPlayerListener)) {
            this.playerListeners.add(audienceRoomPlayerListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.RoomPlayModule
    public void replay() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        QLog.i(this.tag, 1, "replay curUrl: " + this.currentUrl);
        if (this.player == null) {
            QLog.e(this.tag, 1, "replay player is null");
        } else {
            resetPlayerInner();
            startPlay(this.currentUrl);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.RoomPlayModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        if (this.isDestroy) {
            return;
        }
        this.iAegisLogApi.i(this.tag, 1, "reset playerOnlyPauseWhenReset:" + this.playerOnlyPauseWhenReset);
        resetVideoSize();
        this.playerListeners.clear();
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
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.RoomPlayModule
    public void resetPlayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        stopRetry();
        this.retryStrategy.reset();
        if (this.playerOnlyPauseWhenReset) {
            ISuperPlayer iSuperPlayer = this.player;
            if (iSuperPlayer != null && iSuperPlayer.isPlaying()) {
                this.player.pause();
                this.currentStatus = 2;
                Iterator<AudienceRoomPlayerListener> it = this.playerListeners.iterator();
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

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.RoomPlayModule
    public void retry() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        this.iAegisLogApi.i(this.tag, 1, "retry isPreload: " + this.isPreload);
        if (!this.isPreload) {
            stopRetry();
            ThreadManager.getUIHandler().postDelayed(this.retryRunnable, this.intervalTime);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.RoomPlayModule
    public void setMute(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
            return;
        }
        ISuperPlayer iSuperPlayer = this.player;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOutputMute(z16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.RoomPlayModule
    public void setPlayUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.currentUrl = str;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.RoomPlayModule
    public void setPlayerChangeUrlManager(IPlayerChangeUrlManager iPlayerChangeUrlManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iPlayerChangeUrlManager);
        } else {
            this.playerChangeUrlManager = iPlayerChangeUrlManager;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.RoomPlayModule
    public void setRetryParams(long j3, int i3) {
        PlayRetryStrategy playRetryStrategy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
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

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.RoomPlayModule
    public void setVideoSurface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        this.player.setXYaxis(this.playerView.getViewRenderMode());
        this.player.updatePlayerVideoView(this.superPlayerView);
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.RoomPlayModule
    public void startPlay(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
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

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.RoomPlayModule
    public void switchDefinition(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
            return;
        }
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

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.RoomPlayModule
    public void unRegisterRoomPlayerListener(AudienceRoomPlayerListener audienceRoomPlayerListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) audienceRoomPlayerListener);
        } else {
            this.playerListeners.remove(audienceRoomPlayerListener);
        }
    }

    public RoomSuperPlayerModule(String str, boolean z16, PlayerConfig playerConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16), playerConfig);
            return;
        }
        this.tag = "";
        this.player = null;
        this.prepareStatus = 0;
        this.isPlaySoon = false;
        this.playerListeners = new CopyOnWriteArrayList<>();
        this.isDestroy = false;
        this.currentStatus = 0;
        this.isPreload = false;
        this.isSdkPreparing = false;
        this.preOperate = new ArrayList();
        this.videoSize = null;
        IAegisLogApi iAegisLogApi = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        this.iAegisLogApi = iAegisLogApi;
        this.intervalTime = 2000L;
        this.retryStrategy = new ResumeRetryStrategy();
        this.playerOnlyPauseWhenReset = false;
        this.options = new ArrayList();
        this.canRecycle = true;
        this.retryRunnable = new Runnable() { // from class: com.tencent.mobileqq.qqlive.api.impl.room.RoomSuperPlayerModule.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RoomSuperPlayerModule.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    RoomSuperPlayerModule.this.iAegisLogApi.e(RoomSuperPlayerModule.this.tag, 1, "try play url is " + RoomSuperPlayerModule.this.currentUrl);
                    RoomSuperPlayerModule.this.startPlay("");
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        };
        this.updateDownloadInfoRunnableRet = null;
        this.requestProtocol = new String();
        this.updateDownloadInfoRunnable = new Runnable() { // from class: com.tencent.mobileqq.qqlive.api.impl.room.RoomSuperPlayerModule.9
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RoomSuperPlayerModule.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
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
        this.playerView = new com.tencent.mobileqq.qqlive.view.b(this.superPlayerView);
        this.retryStrategy.bindPlayModule(this);
        if (QQVideoPlaySDKManager.isSDKReady()) {
            initSuperPlayerLog();
            initPlayer(z16);
        } else {
            initVideoSdk(this.context, z16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.RoomPlayModule
    public void setRetryParams(long j3, int i3, PlayRetryStrategy playRetryStrategy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Long.valueOf(j3), Integer.valueOf(i3), playRetryStrategy);
            return;
        }
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
