package com.tencent.mobileqq.icgame.api.impl.room;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.activity.richmedia.i;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModuleFactory;
import com.tencent.mobileqq.icgame.api.impl.room.report.PlayerStatisticsProvider;
import com.tencent.mobileqq.icgame.api.impl.room.report.RoomPlayerTrafficFlowReporter;
import com.tencent.mobileqq.icgame.api.impl.room.report.RoomPlayerTrafficFlowReporterWrapper;
import com.tencent.mobileqq.icgame.api.impl.room.trtc.RoomTRTCPlayModule;
import com.tencent.mobileqq.icgame.api.room.AudienceRoomConfig;
import com.tencent.mobileqq.icgame.api.room.ILiveAudienceTPPlayerRoom;
import com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView;
import com.tencent.mobileqq.icgame.api.room.IcgRoomPlayerConfig;
import com.tencent.mobileqq.icgame.api.room.StreamType;
import com.tencent.mobileqq.icgame.data.room.EnterRoomInfo;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayUrlHandler;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.stream.ServiceAddressInfo;
import com.tencent.mobileqq.qqlive.data.room.stream.ServiceFrameInfo;
import com.tencent.mobileqq.qqlive.data.room.stream.ServiceStreamInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes15.dex */
public class LiveAudienceTPPlayerRoomImpl extends BaseAudienceRoom implements ILiveAudienceTPPlayerRoom {
    private static final String TAG = "ICGameLiveTPPlayerRoom";
    private EnterRoomInfo.VideoDefinition curVideoDefinition;
    private List<EnterRoomInfo.VideoDefinition> definitionList;
    private final IAegisLogApi iAegisLogApi;
    private boolean isPausePlayModule;
    private long maxPlayPreloadDuration;
    protected RoomPlayModule playModule;
    private final List<b32.a> playerListenersCache;
    private PlayerStatisticsProvider playerStatisticsProvider;
    private IcgRoomPlayerConfig preloadPlayParams;
    private AudienceRoomConfig roomConfig;
    private long startPreloadTime;
    private RoomPlayerTrafficFlowReporterWrapper trafficFlowReporter;
    private AudienceRoomPlayUrlHandler urlHandler;
    private int videoViewXYAxis;

    public LiveAudienceTPPlayerRoomImpl(AudienceRoomConfig audienceRoomConfig) {
        super(audienceRoomConfig);
        this.playModule = null;
        this.maxPlayPreloadDuration = 0L;
        this.startPreloadTime = 0L;
        this.curVideoDefinition = EnterRoomInfo.VideoDefinition.ORIGIN;
        this.definitionList = new ArrayList();
        IAegisLogApi iAegisLogApi = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        this.iAegisLogApi = iAegisLogApi;
        this.preloadPlayParams = new IcgRoomPlayerConfig();
        this.playerListenersCache = new CopyOnWriteArrayList();
        this.videoViewXYAxis = 2;
        this.isPausePlayModule = false;
        this.roomConfig = audienceRoomConfig;
        iAegisLogApi.i(TAG, "" + audienceRoomConfig);
        this.preloadPlayParams.copyFrom(audienceRoomConfig.preloadPlayParams);
        this.maxPlayPreloadDuration = audienceRoomConfig.maxPlayPreloadDuration;
        createPreloadRoomPlayModule(audienceRoomConfig, this.preloadPlayParams);
        this.playerStatisticsProvider = new PlayerStatisticsProvider();
        this.trafficFlowReporter = new RoomPlayerTrafficFlowReporterWrapper(new RoomPlayerTrafficFlowReporter("live_room_player", this.playerStatisticsProvider));
    }

    private void createEnterRoomPlayModule(AudienceRoomConfig audienceRoomConfig, IcgRoomPlayerConfig icgRoomPlayerConfig, final LiveInfo liveInfo, final Runnable runnable) {
        RoomPlayModuleFactory.createRoomPlayModule(audienceRoomConfig, icgRoomPlayerConfig, liveInfo, new RoomPlayModuleFactory.Callback() { // from class: com.tencent.mobileqq.icgame.api.impl.room.LiveAudienceTPPlayerRoomImpl.3
            @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModuleFactory.Callback
            public boolean isInterrupt() {
                LiveAudienceTPPlayerRoomImpl liveAudienceTPPlayerRoomImpl = LiveAudienceTPPlayerRoomImpl.this;
                if (!liveAudienceTPPlayerRoomImpl.isDestroy && !liveAudienceTPPlayerRoomImpl.isExitRoom) {
                    return false;
                }
                return true;
            }

            @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModuleFactory.Callback
            public void onResult(RoomPlayModule roomPlayModule) {
                long j3;
                LiveRoomInfo liveRoomInfo;
                if (roomPlayModule != null) {
                    LiveAudienceTPPlayerRoomImpl.this.onPlayModuleCreate(roomPlayModule);
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                        return;
                    }
                    return;
                }
                LiveInfo liveInfo2 = liveInfo;
                if (liveInfo2 != null && (liveRoomInfo = liveInfo2.roomInfo) != null) {
                    j3 = liveRoomInfo.roomId;
                } else {
                    j3 = -1;
                }
                LiveAudienceTPPlayerRoomImpl.this.iAegisLogApi.a(LiveAudienceTPPlayerRoomImpl.TAG, "\u623f\u95f4\u5185\u521b\u5efa\u64ad\u653e\u5668\u5931\u8d25! create play module fail! roomId:" + j3);
            }
        });
    }

    private void createPreloadRoomPlayModule(AudienceRoomConfig audienceRoomConfig, IcgRoomPlayerConfig icgRoomPlayerConfig) {
        RoomPlayModuleFactory.createRoomPlayModule(audienceRoomConfig, icgRoomPlayerConfig, null, new RoomPlayModuleFactory.Callback() { // from class: com.tencent.mobileqq.icgame.api.impl.room.LiveAudienceTPPlayerRoomImpl.2
            @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModuleFactory.Callback
            public boolean isInterrupt() {
                LiveAudienceTPPlayerRoomImpl liveAudienceTPPlayerRoomImpl = LiveAudienceTPPlayerRoomImpl.this;
                if (!liveAudienceTPPlayerRoomImpl.isDestroy && !liveAudienceTPPlayerRoomImpl.isExitRoom) {
                    return false;
                }
                return true;
            }

            @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModuleFactory.Callback
            public void onResult(RoomPlayModule roomPlayModule) {
                if (roomPlayModule != null) {
                    LiveAudienceTPPlayerRoomImpl.this.onPlayModuleCreate(roomPlayModule);
                } else {
                    LiveAudienceTPPlayerRoomImpl.this.iAegisLogApi.i(LiveAudienceTPPlayerRoomImpl.TAG, "createPreloadPlayModule null!");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: enterRoomStartPlay, reason: merged with bridge method [inline-methods] */
    public void lambda$afterEnterRoomSuccess$0(EnterRoomInfo enterRoomInfo, LiveInfo liveInfo, boolean z16) {
        this.iAegisLogApi.i(TAG, "enterRoomStartPlay playModule:" + this.playModule + liveInfo + " liveInfo:" + liveInfo + " autoPlay:" + z16);
        fillVideoDefinition(liveInfo);
        String targetUrl = getTargetUrl(liveInfo, enterRoomInfo.getTargetDefinition());
        this.curVideoDefinition = enterRoomInfo.getTargetDefinition();
        RoomPlayModule roomPlayModule = this.playModule;
        if (roomPlayModule == null) {
            return;
        }
        roomPlayModule.onEnterRoom(liveInfo, handleUrl(targetUrl), this.isPausePlayModule);
        this.iAegisLogApi.i(TAG, 1, enterRoomInfo.getRoomId() + " enterRoomSuccess url is " + targetUrl);
    }

    private void fillVideoDefinition(LiveInfo liveInfo) {
        ServiceStreamInfo serviceStreamInfo = liveInfo.watchMediaInfo.serviceStreamInfo;
        if (serviceStreamInfo == null) {
            this.iAegisLogApi.e(TAG, 1, "fillVideoDefinition streamInfo is null");
            return;
        }
        ArrayList<ServiceFrameInfo> arrayList = serviceStreamInfo.frames;
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<ServiceFrameInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                EnterRoomInfo.VideoDefinition definition = getDefinition(it.next().level);
                if (definition != null) {
                    this.definitionList.add(definition);
                }
            }
            return;
        }
        this.iAegisLogApi.e(TAG, 1, "fillVideoDefinition frames is empty");
    }

    private EnterRoomInfo.VideoDefinition getDefinition(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                return null;
                            }
                            return EnterRoomInfo.VideoDefinition.THFD;
                        }
                        return EnterRoomInfo.VideoDefinition.FHD;
                    }
                    return EnterRoomInfo.VideoDefinition.SHD;
                }
                return EnterRoomInfo.VideoDefinition.HD;
            }
            return EnterRoomInfo.VideoDefinition.SD;
        }
        return EnterRoomInfo.VideoDefinition.ORIGIN;
    }

    private ServiceFrameInfo getTargetFrame(ArrayList<ServiceFrameInfo> arrayList, int i3) {
        Collections.sort(arrayList, new Comparator<ServiceFrameInfo>() { // from class: com.tencent.mobileqq.icgame.api.impl.room.LiveAudienceTPPlayerRoomImpl.1
            @Override // java.util.Comparator
            public int compare(ServiceFrameInfo serviceFrameInfo, ServiceFrameInfo serviceFrameInfo2) {
                return Integer.compare(serviceFrameInfo.level, serviceFrameInfo2.level);
            }
        });
        int i16 = -1;
        for (int i17 = 0; i17 < arrayList.size(); i17++) {
            ServiceFrameInfo serviceFrameInfo = arrayList.get(i17);
            int i18 = serviceFrameInfo.level;
            if (i18 == i3) {
                return serviceFrameInfo;
            }
            if (i18 < i3 || i16 == -1) {
                i16 = i17;
            }
        }
        if (i3 == EnterRoomInfo.VideoDefinition.ORIGIN.level) {
            return arrayList.get(arrayList.size() - 1);
        }
        return arrayList.get(i16);
    }

    private String handleUrl(String str) {
        AudienceRoomPlayUrlHandler audienceRoomPlayUrlHandler = this.urlHandler;
        if (audienceRoomPlayUrlHandler == null) {
            return str;
        }
        String handle = audienceRoomPlayUrlHandler.handle(str);
        if (TextUtils.isEmpty(handle)) {
            return str;
        }
        return handle;
    }

    private boolean isCurrentAnchor(long j3) {
        BaseAnchorInfo anchorInfo = getAnchorInfo();
        if (anchorInfo == null || anchorInfo.getAnchorUid() != j3) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPlayModuleCreate(RoomPlayModule roomPlayModule) {
        this.playModule = roomPlayModule;
        this.iAegisLogApi.i(TAG, "onPlayModuleCreate playModule:" + this.playModule);
        Iterator<b32.a> it = this.playerListenersCache.iterator();
        while (it.hasNext()) {
            this.playModule.registerRoomPlayerListener(it.next());
        }
        this.playerListenersCache.clear();
        ITPPlayerVideoView videoView = this.playModule.getVideoView();
        if (videoView != null) {
            videoView.setXYAxis(this.videoViewXYAxis);
        }
    }

    private void registerRoomPlayerListeners() {
        registerRoomPlayerListener(this.techReporter);
        registerRoomPlayerListener(this.playerStatisticsProvider);
        registerRoomPlayerListener(this.trafficFlowReporter);
    }

    private void unregisterRoomPlayerListeners() {
        unRegisterRoomPlayerListener(this.techReporter);
        unRegisterRoomPlayerListener(this.playerStatisticsProvider);
        unRegisterRoomPlayerListener(this.trafficFlowReporter);
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.BaseAudienceRoom
    protected void afterEnterRoomSuccess(final EnterRoomInfo enterRoomInfo, final LiveInfo liveInfo, final boolean z16) {
        this.iAegisLogApi.i(TAG, "afterEnterRoomSuccess playModule:" + this.playModule);
        if (this.playModule != null) {
            lambda$afterEnterRoomSuccess$0(enterRoomInfo, liveInfo, z16);
        } else {
            createEnterRoomPlayModule(this.roomConfig, this.preloadPlayParams, liveInfo, new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.a
                @Override // java.lang.Runnable
                public final void run() {
                    LiveAudienceTPPlayerRoomImpl.this.lambda$afterEnterRoomSuccess$0(enterRoomInfo, liveInfo, z16);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.BaseAudienceRoom, com.tencent.mobileqq.icgame.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void destroy() {
        super.destroy();
        this.iAegisLogApi.i(TAG, "play destroy:" + this.playModule);
        RoomPlayModule roomPlayModule = this.playModule;
        if (roomPlayModule != null) {
            roomPlayModule.destroy();
            this.playModule = null;
        }
        this.trafficFlowReporter.unInit();
        this.startPreloadTime = 0L;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveAudienceTPPlayerRoom
    public boolean disableViewCallback() {
        RoomPlayModule roomPlayModule = this.playModule;
        if (roomPlayModule != null) {
            return roomPlayModule.disableViewCallback();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveAudienceTPPlayerRoom
    public boolean enableViewCallback() {
        RoomPlayModule roomPlayModule = this.playModule;
        if (roomPlayModule != null) {
            return roomPlayModule.enableViewCallback();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.BaseAudienceRoom, com.tencent.mobileqq.icgame.api.room.IAudienceRoom
    public void enterRoom(EnterRoomInfo enterRoomInfo, boolean z16, b32.c cVar) {
        if (!this.isDestroy) {
            this.definitionList.clear();
        }
        super.enterRoom(enterRoomInfo, z16, cVar);
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.BaseAudienceRoom, com.tencent.mobileqq.icgame.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.icgame.api.room.ILiveRoomBase
    public void exitRoom(ExitRoomCallback exitRoomCallback) {
        if (!this.isDestroy) {
            this.definitionList.clear();
        }
        super.exitRoom(exitRoomCallback);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveAudienceTPPlayerRoom
    public List<EnterRoomInfo.VideoDefinition> getDefinitionList() {
        return this.definitionList;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveTPPlayerRoom
    public int getPlayStatus() {
        RoomPlayModule roomPlayModule = this.playModule;
        if (roomPlayModule == null) {
            return 0;
        }
        return roomPlayModule.getCurrentStatus();
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveAudienceTPPlayerRoom
    public StreamType getStreamType() {
        RoomPlayModule roomPlayModule = this.playModule;
        if (roomPlayModule == null) {
            return StreamType.NONE;
        }
        if (roomPlayModule instanceof RoomSuperPlayerModule) {
            return StreamType.FLV;
        }
        if (roomPlayModule instanceof RoomTRTCPlayModule) {
            return StreamType.TRTC;
        }
        return StreamType.NONE;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveAudienceTPPlayerRoom
    public String getTargetUrl(EnterRoomInfo.VideoDefinition videoDefinition) {
        LiveInfo roomLiveInfo = getRoomLiveInfo();
        if (videoDefinition == null || roomLiveInfo == null) {
            return null;
        }
        String targetUrl = getTargetUrl(roomLiveInfo, videoDefinition);
        if (TextUtils.isEmpty(targetUrl)) {
            this.iAegisLogApi.e(TAG, 1, "switchVideoDefinition failed " + videoDefinition + " not find url");
            return null;
        }
        return handleUrl(targetUrl);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveAudienceTPPlayerRoom
    public EnterRoomInfo.VideoDefinition getVideoDefinition() {
        return this.curVideoDefinition;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveAudienceTPPlayerRoom
    @NonNull
    public i getVideoSize() {
        RoomPlayModule roomPlayModule = this.playModule;
        if (roomPlayModule == null) {
            return new i(0, 0);
        }
        return roomPlayModule.getVideoSize();
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.BaseAudienceRoom, com.tencent.mobileqq.icgame.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        super.init(iQQLiveSDK);
        registerRoomPlayerListeners();
        this.trafficFlowReporter.init();
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveMediaRoom
    public boolean isOutputMute() {
        RoomPlayModule roomPlayModule;
        if (!this.isDestroy && (roomPlayModule = this.playModule) != null) {
            return roomPlayModule.isOutputMute();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.icgame.api.impl.room.BaseLiveRoom
    public void onEnterRoom() {
        if (this.isDestroy) {
            return;
        }
        super.onEnterRoom();
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveTPPlayerRoom
    public void pause() {
        this.iAegisLogApi.i(TAG, "pause playModule:" + this.playModule);
        this.isPausePlayModule = true;
        RoomPlayModule roomPlayModule = this.playModule;
        if (roomPlayModule != null) {
            roomPlayModule.pause();
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveTPPlayerRoom
    public void play() {
        this.iAegisLogApi.i(TAG, "play playModule:" + this.playModule);
        this.isPausePlayModule = false;
        RoomPlayModule roomPlayModule = this.playModule;
        if (roomPlayModule != null) {
            roomPlayModule.startPlay("");
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveTPPlayerRoom
    public void playerOnlyPauseWhenReset(boolean z16) {
        RoomPlayModule roomPlayModule = this.playModule;
        if (roomPlayModule != null) {
            roomPlayModule.playerOnlyPauseWhenReset(z16);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveTPPlayerRoom
    public void preloadUrl(String str) {
        RoomPlayModule roomPlayModule;
        this.iAegisLogApi.i(TAG, "preloadUrl playModule:" + this.playModule + " url:" + str);
        String handleUrl = handleUrl(str);
        this.techReporter.setMediaUrl(handleUrl);
        if (!this.isDestroy && (roomPlayModule = this.playModule) != null) {
            roomPlayModule.preloadUrl(handleUrl);
            this.startPreloadTime = System.currentTimeMillis();
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveTPPlayerRoom
    public void preloadWithCurrentUrl() {
        RoomPlayModule roomPlayModule = this.playModule;
        if (roomPlayModule == null) {
            return;
        }
        roomPlayModule.preloadUrl(roomPlayModule.getPlayUrl());
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveTPPlayerRoom
    public void registerRoomPlayerListener(b32.a aVar) {
        if (this.isDestroy) {
            return;
        }
        RoomPlayModule roomPlayModule = this.playModule;
        if (roomPlayModule == null) {
            if (aVar != null && !this.playerListenersCache.contains(aVar)) {
                this.iAegisLogApi.i(TAG, "registerRoomPlayerListener " + aVar);
                this.playerListenersCache.add(aVar);
                return;
            }
            return;
        }
        roomPlayModule.registerRoomPlayerListener(aVar);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveAudienceTPPlayerRoom
    public void replay() {
        this.iAegisLogApi.i(TAG, "replay playModule:" + this.playModule);
        RoomPlayModule roomPlayModule = this.playModule;
        if (roomPlayModule != null) {
            roomPlayModule.replay();
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.BaseAudienceRoom, com.tencent.mobileqq.icgame.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void reset() {
        super.reset();
        RoomPlayModule roomPlayModule = this.playModule;
        if (roomPlayModule != null) {
            roomPlayModule.reset();
        }
        this.trafficFlowReporter.unInit();
        this.startPreloadTime = 0L;
        this.isPausePlayModule = false;
        unregisterRoomPlayerListeners();
        this.playerListenersCache.clear();
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveMediaRoom
    public void setMute(boolean z16) {
        RoomPlayModule roomPlayModule;
        if (!this.isDestroy && (roomPlayModule = this.playModule) != null) {
            roomPlayModule.setMute(z16);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveTPPlayerRoom
    public void setRetryParams(long j3, int i3) {
        this.playModule.setRetryParams(j3, i3);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveAudienceTPPlayerRoom
    public void setUrlHandler(AudienceRoomPlayUrlHandler audienceRoomPlayUrlHandler) {
        this.urlHandler = audienceRoomPlayUrlHandler;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveAudienceTPPlayerRoom
    public void setXYAxis(int i3) {
        this.videoViewXYAxis = i3;
        RoomPlayModule roomPlayModule = this.playModule;
        if (roomPlayModule != null && roomPlayModule.getVideoView() != null) {
            this.playModule.getVideoView().setXYAxis(i3);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveTPPlayerRoom
    public void startPlay(String str) {
        this.iAegisLogApi.i(TAG, "startPlay isDestroy:" + this.isDestroy + " playModule:" + this.playModule + " isPausePlayModule:" + this.isPausePlayModule + " url:" + str);
        this.isPausePlayModule = false;
        if (!this.isDestroy && this.playModule != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.maxPlayPreloadDuration > 0 && this.startPreloadTime > 0 && TextUtils.isEmpty(str) && currentTimeMillis - this.startPreloadTime > this.maxPlayPreloadDuration) {
                this.playModule.replay();
                this.startPreloadTime = 0L;
            } else {
                this.playModule.startPlay(str);
            }
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveAudienceTPPlayerRoom
    public void switchVideoDefinition(EnterRoomInfo.VideoDefinition videoDefinition) {
        LiveInfo roomLiveInfo = getRoomLiveInfo();
        if (videoDefinition != null && roomLiveInfo != null && this.playModule != null && videoDefinition != this.curVideoDefinition) {
            String targetUrl = getTargetUrl(roomLiveInfo, videoDefinition);
            if (TextUtils.isEmpty(targetUrl)) {
                this.iAegisLogApi.e(TAG, 1, "switchVideoDefinition failed " + videoDefinition + " not find url");
                return;
            }
            String handleUrl = handleUrl(targetUrl);
            this.curVideoDefinition = videoDefinition;
            Iterator<b32.a> it = this.playModule.getRoomPlayerListeners().iterator();
            while (it.hasNext()) {
                it.next().onSwitchDefinition(videoDefinition, handleUrl);
            }
            this.playModule.switchDefinition(handleUrl);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveTPPlayerRoom
    public void unRegisterRoomPlayerListener(b32.a aVar) {
        if (this.isDestroy) {
            return;
        }
        RoomPlayModule roomPlayModule = this.playModule;
        if (roomPlayModule == null) {
            if (aVar != null) {
                this.iAegisLogApi.i(TAG, "unRegisterRoomPlayerListener " + aVar);
                this.playerListenersCache.remove(aVar);
                return;
            }
            return;
        }
        roomPlayModule.unRegisterRoomPlayerListener(aVar);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveAudienceTPPlayerRoom
    public void updateCurrentDefinitionFromOutPlayer(EnterRoomInfo.VideoDefinition videoDefinition) {
        this.curVideoDefinition = videoDefinition;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.icgame.api.room.ILiveMediaRoom
    public ITPPlayerVideoView getDisplayView() {
        RoomPlayModule roomPlayModule;
        if (this.isDestroy || (roomPlayModule = this.playModule) == null) {
            return null;
        }
        return roomPlayModule.getVideoView();
    }

    private String getTargetUrl(LiveInfo liveInfo, EnterRoomInfo.VideoDefinition videoDefinition) {
        if (videoDefinition == null) {
            videoDefinition = EnterRoomInfo.VideoDefinition.ORIGIN;
        }
        ServiceStreamInfo serviceStreamInfo = liveInfo.watchMediaInfo.serviceStreamInfo;
        int i3 = videoDefinition.level;
        if (serviceStreamInfo == null) {
            this.iAegisLogApi.e(TAG, 1, "streamInfo is null");
            return "";
        }
        ArrayList<ServiceFrameInfo> arrayList = serviceStreamInfo.frames;
        if (arrayList != null && arrayList.size() != 0) {
            ServiceFrameInfo targetFrame = getTargetFrame(arrayList, i3);
            ArrayList<ServiceAddressInfo> arrayList2 = targetFrame.addresses;
            if (arrayList2 != null && arrayList2.size() != 0) {
                this.iAegisLogApi.i(TAG, 1, "getTargetUrl target: " + i3 + " actually: " + targetFrame.level);
                return arrayList2.get(0).url;
            }
            this.iAegisLogApi.e(TAG, 1, "addresses is empty");
            return "";
        }
        this.iAegisLogApi.e(TAG, 1, "frames is empty");
        return "";
    }
}
