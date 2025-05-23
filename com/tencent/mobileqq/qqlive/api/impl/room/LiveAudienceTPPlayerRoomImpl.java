package com.tencent.mobileqq.qqlive.api.impl.room;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.richmedia.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.player.IPlayerChangeUrlManager;
import com.tencent.mobileqq.qqlive.api.room.AudienceRoomConfig;
import com.tencent.mobileqq.qqlive.api.room.ILiveAudienceTPPlayerRoom;
import com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView;
import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayUrlHandler;
import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener;
import com.tencent.mobileqq.qqlive.callback.room.audience.EnterAudienceRoomCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.EnterRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.room.QQLiveRoomStatusInfo;
import com.tencent.mobileqq.qqlive.data.room.stream.ServiceAddressInfo;
import com.tencent.mobileqq.qqlive.data.room.stream.ServiceFrameInfo;
import com.tencent.mobileqq.qqlive.data.room.stream.ServiceStreamInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes17.dex */
public class LiveAudienceTPPlayerRoomImpl extends BaseAudienceRoom implements ILiveAudienceTPPlayerRoom {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "LiveTPPlayerRoom";
    private EnterRoomInfo.VideoDefinition curVideoDefinition;
    private List<EnterRoomInfo.VideoDefinition> definitionList;
    private final IAegisLogApi iAegisLogApi;
    private boolean ignoreRoomPush;
    private long maxPlayPreloadDuration;
    protected RoomPlayModule playModule;
    private long startPreloadTime;
    private AudienceRoomPlayUrlHandler urlHandler;

    public LiveAudienceTPPlayerRoomImpl(AudienceRoomConfig audienceRoomConfig) {
        super(audienceRoomConfig);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) audienceRoomConfig);
            return;
        }
        this.playModule = null;
        this.maxPlayPreloadDuration = 0L;
        this.startPreloadTime = 0L;
        this.curVideoDefinition = EnterRoomInfo.VideoDefinition.ORIGIN;
        this.definitionList = new ArrayList();
        IAegisLogApi iAegisLogApi = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        this.iAegisLogApi = iAegisLogApi;
        iAegisLogApi.i(TAG, 1, "" + audienceRoomConfig);
        if (audienceRoomConfig.isNeedPlayer) {
            this.playModule = new RoomSuperPlayerModule(audienceRoomConfig.appId, false, audienceRoomConfig.playerConfig);
            if (audienceRoomConfig.roomId != 0) {
                IPlayerChangeUrlManager iPlayerChangeUrlManager = (IPlayerChangeUrlManager) QRoute.api(IPlayerChangeUrlManager.class);
                iPlayerChangeUrlManager.init(audienceRoomConfig.roomId);
                this.playModule.setPlayerChangeUrlManager(iPlayerChangeUrlManager);
            }
            this.maxPlayPreloadDuration = audienceRoomConfig.maxPlayPreloadDuration;
        }
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
        Collections.sort(arrayList, new Comparator<ServiceFrameInfo>() { // from class: com.tencent.mobileqq.qqlive.api.impl.room.LiveAudienceTPPlayerRoomImpl.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) LiveAudienceTPPlayerRoomImpl.this);
                }
            }

            @Override // java.util.Comparator
            public int compare(ServiceFrameInfo serviceFrameInfo, ServiceFrameInfo serviceFrameInfo2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? Integer.compare(serviceFrameInfo.level, serviceFrameInfo2.level) : ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) serviceFrameInfo, (Object) serviceFrameInfo2)).intValue();
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCurrentAnchor(long j3) {
        BaseAnchorInfo anchorInfo = getAnchorInfo();
        if (anchorInfo == null || anchorInfo.getAnchorUid() != j3) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.BaseAudienceRoom
    protected void afterEnterRoomSuccess(EnterRoomInfo enterRoomInfo, LiveInfo liveInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, enterRoomInfo, liveInfo, Boolean.valueOf(z16));
            return;
        }
        fillVideoDefinition(liveInfo);
        String targetUrl = getTargetUrl(liveInfo, enterRoomInfo.getTargetDefinition());
        this.curVideoDefinition = enterRoomInfo.getTargetDefinition();
        if (TextUtils.isEmpty(targetUrl)) {
            this.iAegisLogApi.w(TAG, 1, "url is empty room status is " + liveInfo.watchMediaInfo.mVideoStatus);
        } else if (z16) {
            startPlay(handleUrl(targetUrl));
        } else {
            RoomPlayModule roomPlayModule = this.playModule;
            if (roomPlayModule != null && TextUtils.isEmpty(roomPlayModule.getPlayUrl())) {
                this.playModule.setPlayUrl(handleUrl(targetUrl));
            }
        }
        this.iAegisLogApi.i(TAG, 1, enterRoomInfo.getRoomId() + " enterRoomSuccess url is " + targetUrl);
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.BaseAudienceRoom, com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        super.destroy();
        RoomPlayModule roomPlayModule = this.playModule;
        if (roomPlayModule != null) {
            roomPlayModule.destroy();
            this.playModule = null;
        }
        this.startPreloadTime = 0L;
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveAudienceTPPlayerRoom
    public boolean disableViewCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        RoomPlayModule roomPlayModule = this.playModule;
        if (roomPlayModule != null) {
            return roomPlayModule.disableViewCallback();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveAudienceTPPlayerRoom
    public boolean enableViewCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        RoomPlayModule roomPlayModule = this.playModule;
        if (roomPlayModule != null) {
            return roomPlayModule.enableViewCallback();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.BaseAudienceRoom, com.tencent.mobileqq.qqlive.api.room.IAudienceRoom
    public void enterRoom(EnterRoomInfo enterRoomInfo, boolean z16, EnterAudienceRoomCallback enterAudienceRoomCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, enterRoomInfo, Boolean.valueOf(z16), enterAudienceRoomCallback);
            return;
        }
        if (!this.isDestroy) {
            this.definitionList.clear();
        }
        super.enterRoom(enterRoomInfo, z16, enterAudienceRoomCallback);
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.BaseAudienceRoom, com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoomBase
    public void exitRoom(ExitRoomCallback exitRoomCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) exitRoomCallback);
            return;
        }
        if (!this.isDestroy) {
            this.definitionList.clear();
        }
        super.exitRoom(exitRoomCallback);
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveAudienceTPPlayerRoom
    public List<EnterRoomInfo.VideoDefinition> getDefinitionList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (List) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.definitionList;
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom
    public int getPlayStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this)).intValue();
        }
        RoomPlayModule roomPlayModule = this.playModule;
        if (roomPlayModule == null) {
            return 0;
        }
        return roomPlayModule.getCurrentStatus();
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveAudienceTPPlayerRoom
    public String getTargetUrl(EnterRoomInfo.VideoDefinition videoDefinition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) videoDefinition);
        }
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

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveAudienceTPPlayerRoom
    public EnterRoomInfo.VideoDefinition getVideoDefinition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (EnterRoomInfo.VideoDefinition) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        return this.curVideoDefinition;
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveAudienceTPPlayerRoom
    @NonNull
    public i getVideoSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (i) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        RoomPlayModule roomPlayModule = this.playModule;
        if (roomPlayModule == null) {
            return new i(0, 0);
        }
        return roomPlayModule.getVideoSize();
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.BaseAudienceRoom, com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iQQLiveSDK);
            return;
        }
        super.init(iQQLiveSDK);
        RoomPlayModule roomPlayModule = this.playModule;
        if (roomPlayModule != null) {
            roomPlayModule.registerRoomPlayerListener(this.techReporter);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveMediaRoom
    public boolean isOutputMute() {
        RoomPlayModule roomPlayModule;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        if (!this.isDestroy && (roomPlayModule = this.playModule) != null) {
            return roomPlayModule.isOutputMute();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom
    public boolean isPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        if (getPlayStatus() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom
    public void onEnterRoom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            if (this.isDestroy) {
                return;
            }
            super.onEnterRoom();
            this.roomStatusService.registerRoomInfoListener(new LiveRoomStatusListener() { // from class: com.tencent.mobileqq.qqlive.api.impl.room.LiveAudienceTPPlayerRoomImpl.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LiveAudienceTPPlayerRoomImpl.this);
                    }
                }

                @Override // com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener
                public void onRoomClose(QQLiveRoomStatusInfo qQLiveRoomStatusInfo) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, (Object) qQLiveRoomStatusInfo);
                        return;
                    }
                    if (LiveAudienceTPPlayerRoomImpl.this.ignoreRoomPush) {
                        return;
                    }
                    LiveAudienceTPPlayerRoomImpl liveAudienceTPPlayerRoomImpl = LiveAudienceTPPlayerRoomImpl.this;
                    if (liveAudienceTPPlayerRoomImpl.playModule != null && liveAudienceTPPlayerRoomImpl.isCurrentAnchor(qQLiveRoomStatusInfo.uin)) {
                        LiveAudienceTPPlayerRoomImpl.this.playModule.pause();
                    }
                }

                @Override // com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener
                public void onRoomOpen(QQLiveRoomStatusInfo qQLiveRoomStatusInfo) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) qQLiveRoomStatusInfo);
                        return;
                    }
                    if (LiveAudienceTPPlayerRoomImpl.this.ignoreRoomPush) {
                        return;
                    }
                    LiveAudienceTPPlayerRoomImpl liveAudienceTPPlayerRoomImpl = LiveAudienceTPPlayerRoomImpl.this;
                    if (liveAudienceTPPlayerRoomImpl.playModule != null && liveAudienceTPPlayerRoomImpl.isCurrentAnchor(qQLiveRoomStatusInfo.uin)) {
                        LiveAudienceTPPlayerRoomImpl.this.playModule.startPlay("");
                    }
                }

                @Override // com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener
                public void onRoomPause(QQLiveRoomStatusInfo qQLiveRoomStatusInfo) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        iPatchRedirector2.redirect((short) 4, (Object) this, (Object) qQLiveRoomStatusInfo);
                        return;
                    }
                    if (LiveAudienceTPPlayerRoomImpl.this.ignoreRoomPush) {
                        return;
                    }
                    LiveAudienceTPPlayerRoomImpl liveAudienceTPPlayerRoomImpl = LiveAudienceTPPlayerRoomImpl.this;
                    if (liveAudienceTPPlayerRoomImpl.playModule != null && liveAudienceTPPlayerRoomImpl.isCurrentAnchor(qQLiveRoomStatusInfo.uin)) {
                        LiveAudienceTPPlayerRoomImpl.this.playModule.pause();
                    }
                }

                @Override // com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener
                public void onRoomResume(QQLiveRoomStatusInfo qQLiveRoomStatusInfo) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                        iPatchRedirector2.redirect((short) 5, (Object) this, (Object) qQLiveRoomStatusInfo);
                        return;
                    }
                    if (LiveAudienceTPPlayerRoomImpl.this.ignoreRoomPush) {
                        return;
                    }
                    LiveAudienceTPPlayerRoomImpl liveAudienceTPPlayerRoomImpl = LiveAudienceTPPlayerRoomImpl.this;
                    if (liveAudienceTPPlayerRoomImpl.playModule != null && liveAudienceTPPlayerRoomImpl.isCurrentAnchor(qQLiveRoomStatusInfo.uin)) {
                        String playUrl = LiveAudienceTPPlayerRoomImpl.this.playModule.getPlayUrl();
                        LiveAudienceTPPlayerRoomImpl.this.playModule.resetPlayer();
                        LiveAudienceTPPlayerRoomImpl.this.playModule.startPlay(playUrl);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        RoomPlayModule roomPlayModule = this.playModule;
        if (roomPlayModule != null) {
            roomPlayModule.pause();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom
    public void play() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        RoomPlayModule roomPlayModule = this.playModule;
        if (roomPlayModule != null) {
            roomPlayModule.startPlay("");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom
    public void playerOnlyPauseWhenReset(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, z16);
            return;
        }
        RoomPlayModule roomPlayModule = this.playModule;
        if (roomPlayModule != null) {
            roomPlayModule.playerOnlyPauseWhenReset(z16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom
    public void preloadUrl(String str) {
        RoomPlayModule roomPlayModule;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        String handleUrl = handleUrl(str);
        this.techReporter.setMediaUrl(handleUrl);
        if (!this.isDestroy && (roomPlayModule = this.playModule) != null) {
            roomPlayModule.preloadUrl(handleUrl);
            this.startPreloadTime = System.currentTimeMillis();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom
    public void preloadWithCurrentUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
            return;
        }
        RoomPlayModule roomPlayModule = this.playModule;
        if (roomPlayModule == null) {
            return;
        }
        roomPlayModule.preloadUrl(roomPlayModule.getPlayUrl());
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom
    public void registerRoomPlayerListener(AudienceRoomPlayerListener audienceRoomPlayerListener) {
        RoomPlayModule roomPlayModule;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) audienceRoomPlayerListener);
        } else if (!this.isDestroy && (roomPlayModule = this.playModule) != null) {
            roomPlayModule.registerRoomPlayerListener(audienceRoomPlayerListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveAudienceTPPlayerRoom
    public void replay() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        RoomPlayModule roomPlayModule = this.playModule;
        if (roomPlayModule != null) {
            roomPlayModule.replay();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.BaseAudienceRoom, com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        super.reset();
        RoomPlayModule roomPlayModule = this.playModule;
        if (roomPlayModule != null) {
            roomPlayModule.registerRoomPlayerListener(this.techReporter);
        }
        RoomPlayModule roomPlayModule2 = this.playModule;
        if (roomPlayModule2 != null) {
            roomPlayModule2.reset();
        }
        this.startPreloadTime = 0L;
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom
    public void setIgnoreRoomPush(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, z16);
            return;
        }
        this.iAegisLogApi.i(TAG, "setIgnoreRoomPush " + z16);
        this.ignoreRoomPush = z16;
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveMediaRoom
    public void setMute(boolean z16) {
        RoomPlayModule roomPlayModule;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
        } else if (!this.isDestroy && (roomPlayModule = this.playModule) != null) {
            roomPlayModule.setMute(z16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom
    public void setRetryParams(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Long.valueOf(j3), Integer.valueOf(i3));
        } else {
            this.playModule.setRetryParams(j3, i3);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveAudienceTPPlayerRoom
    public void setUrlHandler(AudienceRoomPlayUrlHandler audienceRoomPlayUrlHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) audienceRoomPlayUrlHandler);
        } else {
            this.urlHandler = audienceRoomPlayUrlHandler;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom
    public void startPlay(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
            return;
        }
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

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveAudienceTPPlayerRoom
    public void switchVideoDefinition(EnterRoomInfo.VideoDefinition videoDefinition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) videoDefinition);
            return;
        }
        LiveInfo roomLiveInfo = getRoomLiveInfo();
        if (videoDefinition != null && roomLiveInfo != null && videoDefinition != this.curVideoDefinition) {
            String targetUrl = getTargetUrl(roomLiveInfo, videoDefinition);
            if (TextUtils.isEmpty(targetUrl)) {
                this.iAegisLogApi.e(TAG, 1, "switchVideoDefinition failed " + videoDefinition + " not find url");
                return;
            }
            String handleUrl = handleUrl(targetUrl);
            this.curVideoDefinition = videoDefinition;
            Iterator<AudienceRoomPlayerListener> it = this.playModule.getPlayerListeners().iterator();
            while (it.hasNext()) {
                it.next().onSwitchDefinition(videoDefinition, handleUrl);
            }
            this.playModule.switchDefinition(handleUrl);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom
    public void unRegisterRoomPlayerListener(AudienceRoomPlayerListener audienceRoomPlayerListener) {
        RoomPlayModule roomPlayModule;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) audienceRoomPlayerListener);
        } else if (!this.isDestroy && (roomPlayModule = this.playModule) != null) {
            roomPlayModule.unRegisterRoomPlayerListener(audienceRoomPlayerListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveAudienceTPPlayerRoom
    public void updateCurrentDefinitionFromOutPlayer(EnterRoomInfo.VideoDefinition videoDefinition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) videoDefinition);
        } else {
            this.curVideoDefinition = videoDefinition;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveMediaRoom
    public ITPPlayerVideoView getDisplayView() {
        RoomPlayModule roomPlayModule;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (ITPPlayerVideoView) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        if (this.isDestroy || (roomPlayModule = this.playModule) == null) {
            return null;
        }
        return roomPlayModule.getVideoView();
    }

    private String getTargetUrl(LiveInfo liveInfo, EnterRoomInfo.VideoDefinition videoDefinition) {
        IPlayerChangeUrlManager playerChangeUrlManager = this.playModule.getPlayerChangeUrlManager();
        if (playerChangeUrlManager != null && playerChangeUrlManager.hasChangeUrl()) {
            this.iAegisLogApi.i(TAG, "getTargetUrl use changeUrlMgr data.");
            return playerChangeUrlManager.getUrlByDefinition(videoDefinition);
        }
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
