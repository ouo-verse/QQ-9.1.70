package com.tencent.mobileqq.icgame.api.impl.room.trtc;

import android.text.TextUtils;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.IQQLiveSDKManager;
import com.tencent.mobileqq.icgame.api.impl.room.PlayRetryStrategy;
import com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule;
import com.tencent.mobileqq.icgame.api.impl.room.trtc.RoomTRTCPlayCallback;
import com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.icgame.api.room.AudienceRoomConfig;
import com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView;
import com.tencent.mobileqq.icgame.api.room.IcgRoomPlayerConfig;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqmini.sdk.widget.media.MiniAppVideoConstants;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes15.dex */
public class RoomTRTCPlayModule implements RoomPlayModule {
    private static final String TAG = "RoomTRTCPlayModule";
    private String anchorId;
    private final IAegisLogApi iAegisLogApi = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
    private boolean isMute;
    private boolean isPause;
    private boolean isRetryPlay;
    private LiveInfo liveInfo;
    private int playStatus;
    private final List<b32.a> playerListeners;
    private final IcgRoomPlayerConfig preloadPlayParams;
    private int prepareState;
    private final RoomTRTCPlayCallback.StateCallback prepareStateCallback;
    private final AudienceRoomConfig roomConfig;
    private final TRTCCloud trtcCloud;
    private final RoomTRTCPlayCallback trtcPlayerCallback;
    private String url;
    private final u42.b videoView;

    public RoomTRTCPlayModule(AudienceRoomConfig audienceRoomConfig, @NotNull IcgRoomPlayerConfig icgRoomPlayerConfig) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.playerListeners = copyOnWriteArrayList;
        this.url = "";
        this.prepareState = 0;
        this.playStatus = 0;
        this.isMute = false;
        this.isRetryPlay = false;
        this.isPause = false;
        this.anchorId = "";
        RoomTRTCPlayCallback.StateCallback stateCallback = new RoomTRTCPlayCallback.StateCallback() { // from class: com.tencent.mobileqq.icgame.api.impl.room.trtc.RoomTRTCPlayModule.1
            @Override // com.tencent.mobileqq.icgame.api.impl.room.trtc.RoomTRTCPlayCallback.StateCallback
            public void onPlayError() {
                if (!RoomTRTCPlayModule.this.isRetryPlay) {
                    RoomTRTCPlayModule.this.isRetryPlay = true;
                    RoomTRTCPlayModule.this.iAegisLogApi.e(RoomTRTCPlayModule.TAG, "onPlayError! start replay! liveInfo:" + RoomTRTCPlayModule.this.liveInfo);
                    if (RoomTRTCPlayModule.this.liveInfo != null) {
                        RoomTRTCPlayModule roomTRTCPlayModule = RoomTRTCPlayModule.this;
                        roomTRTCPlayModule.startPlay(roomTRTCPlayModule.getPlayUrl());
                    }
                }
            }

            @Override // com.tencent.mobileqq.icgame.api.impl.room.trtc.RoomTRTCPlayCallback.StateCallback
            public void onPlayStatusChange(int i3) {
                RoomTRTCPlayModule.this.playStatus = i3;
                RoomTRTCPlayModule.this.iAegisLogApi.i(RoomTRTCPlayModule.TAG, "onPlayStatusChange prepareState:" + RoomTRTCPlayModule.this.prepareState);
            }

            @Override // com.tencent.mobileqq.icgame.api.impl.room.trtc.RoomTRTCPlayCallback.StateCallback
            public void onPrepareStateChange(int i3) {
                if (RoomTRTCPlayModule.this.prepareState != 2 && i3 == 2) {
                    RoomTRTCPlayModule.this.onTRTCPrepared();
                }
                RoomTRTCPlayModule.this.prepareState = i3;
                RoomTRTCPlayModule.this.iAegisLogApi.i(RoomTRTCPlayModule.TAG, "onPrepareStateChange prepareState:" + RoomTRTCPlayModule.this.prepareState);
            }

            @Override // com.tencent.mobileqq.icgame.api.impl.room.trtc.RoomTRTCPlayCallback.StateCallback
            public void onVideoAvailableChange(String str, boolean z16) {
                if (!TextUtils.isEmpty(str) && str.equals(RoomTRTCPlayModule.this.anchorId) && z16) {
                    onPrepareStateChange(2);
                }
            }
        };
        this.prepareStateCallback = stateCallback;
        this.roomConfig = audienceRoomConfig;
        this.preloadPlayParams = icgRoomPlayerConfig;
        this.anchorId = icgRoomPlayerConfig.trtcPlayerParams.anchorId;
        TRTCCloud tRTCCloud = TRTCSdk.getInstance().getTRTCCloud();
        this.trtcCloud = tRTCCloud;
        this.videoView = new u42.b(tRTCCloud, BaseApplication.getContext().getApplicationContext());
        RoomTRTCPlayCallback roomTRTCPlayCallback = new RoomTRTCPlayCallback(stateCallback, copyOnWriteArrayList);
        this.trtcPlayerCallback = roomTRTCPlayCallback;
        roomTRTCPlayCallback.setAnchorId(this.anchorId);
    }

    private void enterTRTCRoom(TRTCCloudDef.TRTCParams tRTCParams) {
        this.prepareState = 1;
        this.iAegisLogApi.i(TAG, "enterTRTCRoom trtcParams:" + tRTCParams);
        this.trtcPlayerCallback.notifyOnPreparing(getPlayUrl(), this.roomConfig.playerConfig);
        this.trtcCloud.setListener(this.trtcPlayerCallback);
        this.trtcCloud.enterRoom(tRTCParams, 1);
    }

    private void exitTRTCRoom() {
        this.iAegisLogApi.i(TAG, "exitTRTCRoom prepareState:" + this.prepareState);
        if (this.prepareState != 0) {
            this.trtcPlayerCallback.notifyOnStop();
            this.trtcCloud.stopAllRemoteView();
            this.trtcCloud.exitRoom();
        }
        this.prepareState = 0;
        this.playStatus = 2;
    }

    private long getUserId(AudienceRoomConfig audienceRoomConfig) {
        IQQLiveSDK sDKImpl = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(audienceRoomConfig.appId);
        if (sDKImpl == null) {
            this.iAegisLogApi.i(TAG, "getUserId fail! liveSDK is null!");
            return 0L;
        }
        IQQLiveModuleLogin loginModule = sDKImpl.getLoginModule();
        if (loginModule == null) {
            this.iAegisLogApi.i(TAG, "getUserId fail! moduleLogin is null!");
            return 0L;
        }
        return loginModule.getUserInfo().uid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTRTCPrepared() {
        this.iAegisLogApi.i(TAG, "onTRTCPrepared anchorId:" + this.anchorId + " isPause:" + this.isPause);
        if (TextUtils.isEmpty(this.anchorId)) {
            this.iAegisLogApi.e(TAG, "onTRTCPrepared fail! anchor is empty!");
            return;
        }
        this.trtcCloud.startRemoteView(this.anchorId, 0, this.videoView.a());
        TRTCCloudDef.TRTCRenderParams tRTCRenderParams = new TRTCCloudDef.TRTCRenderParams();
        tRTCRenderParams.fillMode = 0;
        tRTCRenderParams.mirrorType = 2;
        tRTCRenderParams.rotation = 0;
        this.trtcCloud.setRemoteRenderParams(this.anchorId, 0, tRTCRenderParams);
        this.trtcCloud.muteAllRemoteVideoStreams(this.isPause);
        this.trtcCloud.muteAllRemoteAudio(this.isPause);
        this.isMute = false;
        this.isRetryPlay = false;
    }

    private void pauseRemoteView() {
        this.iAegisLogApi.i(TAG, "pauseRemoteView prepareState:" + this.prepareState);
        if (this.prepareState == 0) {
            return;
        }
        this.trtcPlayerCallback.notifyOnPause();
        this.trtcCloud.muteAllRemoteVideoStreams(true);
        this.trtcCloud.muteAllRemoteAudio(true);
    }

    private void resumeRemoteView() {
        this.iAegisLogApi.i(TAG, "resumeRemoteView prepareState:" + this.prepareState + " isMute:" + this.isMute);
        if (this.prepareState == 0) {
            return;
        }
        this.trtcPlayerCallback.notifyOnResume();
        this.trtcCloud.muteAllRemoteVideoStreams(false);
        this.trtcCloud.muteAllRemoteAudio(this.isMute);
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void destroy() {
        this.iAegisLogApi.i(TAG, "destroy prepareState:" + this.prepareState);
        if (this.prepareState != 0) {
            exitTRTCRoom();
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public boolean disableViewCallback() {
        this.iAegisLogApi.i(TAG, "disableViewCallback");
        return false;
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public boolean enableViewCallback() {
        this.iAegisLogApi.i(TAG, "enableViewCallback");
        return false;
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public int getCurrentStatus() {
        this.iAegisLogApi.i(TAG, "getCurrentStatus ret:0");
        return this.playStatus;
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public String getPlayUrl() {
        this.iAegisLogApi.i(TAG, "getPlayUrl url:" + this.url);
        return this.url;
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public List<b32.a> getRoomPlayerListeners() {
        return this.playerListeners;
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public com.tencent.mobileqq.activity.richmedia.i getVideoSize() {
        com.tencent.mobileqq.activity.richmedia.i videoSize = this.trtcPlayerCallback.getVideoSize();
        this.iAegisLogApi.i(TAG, "getVideoSize videoSize:" + videoSize);
        return videoSize;
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public ITPPlayerVideoView getVideoView() {
        this.iAegisLogApi.i(TAG, "getVideoView videoView:" + this.videoView);
        return this.videoView;
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public boolean isOutputMute() {
        this.iAegisLogApi.i(TAG, "isOutputMute isOutputMute:" + this.isMute);
        return this.isMute;
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void onEnterRoom(@NotNull LiveInfo liveInfo, String str, boolean z16) {
        this.iAegisLogApi.i(TAG, "onEnterRoom liveInfo:" + liveInfo + " isPause:" + z16);
        this.liveInfo = liveInfo;
        if (liveInfo.anchorInfo != null) {
            String str2 = "" + liveInfo.anchorInfo.uid;
            this.anchorId = str2;
            this.trtcPlayerCallback.setAnchorId(str2);
        }
        if (!z16) {
            startPlay(getPlayUrl());
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void pause() {
        this.iAegisLogApi.i(TAG, "pause");
        this.isPause = true;
        pauseRemoteView();
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void playerOnlyPauseWhenReset(boolean z16) {
        this.iAegisLogApi.i(TAG, "playerOnlyPauseWhenReset onlyPause:" + z16);
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void preloadUrl(String str) {
        this.iAegisLogApi.i(TAG, "preloadUrl url:" + str);
        if (this.prepareState == 0 && this.preloadPlayParams.isSupportTRTCPlay()) {
            TRTCCloudDef.TRTCParams buildFromPreloadParams = RoomTRTCParamsBuilder.buildFromPreloadParams(getUserId(this.roomConfig), this.preloadPlayParams);
            if (buildFromPreloadParams == null) {
                this.iAegisLogApi.e(TAG, "preloadUrl fail! trtcParams is null!");
            } else {
                enterTRTCRoom(buildFromPreloadParams);
            }
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void registerRoomPlayerListener(b32.a aVar) {
        if (aVar != null && !this.playerListeners.contains(aVar)) {
            this.iAegisLogApi.i(TAG, "registerRoomPlayerListener " + aVar);
            this.playerListeners.add(aVar);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void replay() {
        this.iAegisLogApi.i(TAG, "replay");
        startPlay(getPlayUrl());
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void reset() {
        this.iAegisLogApi.i(TAG, "reset prepareState:" + this.prepareState);
        if (this.prepareState != 0) {
            exitTRTCRoom();
        }
        this.playerListeners.clear();
        this.isPause = false;
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void resetPlayer() {
        this.iAegisLogApi.i(TAG, MiniAppVideoConstants.NOTIFY_STATUS_RESET);
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void retry() {
        this.iAegisLogApi.i(TAG, TVKCommonParamEnum.REQ_PARAM_KEY_RETRY);
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void setMute(boolean z16) {
        this.iAegisLogApi.i(TAG, "setMute isMute:" + z16 + " prepareState:" + this.prepareState + " anchorId:" + this.anchorId);
        if (this.prepareState == 0) {
            return;
        }
        this.isMute = z16;
        this.iAegisLogApi.i(TAG, "muteRemoteAudio isMute:" + z16);
        this.trtcCloud.muteRemoteAudio(this.anchorId, z16);
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void setPlayUrl(String str) {
        if (str == null) {
            str = "";
        }
        this.url = str;
        this.iAegisLogApi.i(TAG, "setPlayUrl url:" + str);
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void setRetryParams(long j3, int i3) {
        this.iAegisLogApi.i(TAG, "setRetryParams intervalTime:" + j3 + " retryTimes:" + i3);
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void setVideoSurface() {
        this.iAegisLogApi.i(TAG, "setVideoSurface");
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void startPlay(String str) {
        this.iAegisLogApi.i(TAG, "startPlay url:" + str);
        if (!TextUtils.isEmpty(str)) {
            setPlayUrl(str);
        }
        this.isPause = false;
        int i3 = this.prepareState;
        if (i3 == 0) {
            TRTCCloudDef.TRTCParams buildFromLiveInfo = RoomTRTCParamsBuilder.buildFromLiveInfo(getUserId(this.roomConfig), this.liveInfo);
            if (buildFromLiveInfo == null) {
                this.iAegisLogApi.e(TAG, "startPlay fail! trtcParams is null!");
                return;
            } else {
                enterTRTCRoom(buildFromLiveInfo);
                return;
            }
        }
        if (i3 == 2) {
            resumeRemoteView();
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void switchDefinition(String str) {
        this.iAegisLogApi.i(TAG, "switchDefinition url:" + str);
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void unRegisterRoomPlayerListener(b32.a aVar) {
        this.iAegisLogApi.i(TAG, "unRegisterRoomPlayerListener " + aVar);
        this.playerListeners.remove(aVar);
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.room.RoomPlayModule
    public void setRetryParams(long j3, int i3, PlayRetryStrategy playRetryStrategy) {
        this.iAegisLogApi.i(TAG, "setRetryParams intervalTime:" + j3 + " retryTimes:" + i3 + " playRetryStrategy:" + playRetryStrategy);
    }
}
