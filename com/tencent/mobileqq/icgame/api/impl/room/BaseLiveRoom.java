package com.tencent.mobileqq.icgame.api.impl.room;

import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.gift.IQQLiveGiftService;
import com.tencent.mobileqq.icgame.api.heart.IQQLiveFloatHeartService;
import com.tencent.mobileqq.icgame.api.impl.gift.QQLiveGiftServiceImpl;
import com.tencent.mobileqq.icgame.api.impl.luckybag.ICGameLuckyBagServiceImpl;
import com.tencent.mobileqq.icgame.api.impl.message.LiveEnterRoomServiceImpl;
import com.tencent.mobileqq.icgame.api.impl.message.QQLiveAnnounceMsgServiceImpl;
import com.tencent.mobileqq.icgame.api.impl.message.QQLiveChatMsgServiceImpl;
import com.tencent.mobileqq.icgame.api.impl.message.QQLiveFloatHeartServiceImpl;
import com.tencent.mobileqq.icgame.api.impl.message.QQLiveFollowMsgServiceImpl;
import com.tencent.mobileqq.icgame.api.impl.message.QQLivePushCmdServiceImpl;
import com.tencent.mobileqq.icgame.api.impl.message.QQLiveSystemMsgServiceImpl;
import com.tencent.mobileqq.icgame.api.impl.room.report.QQLiveRoomBizReportHelper;
import com.tencent.mobileqq.icgame.api.luckybag.IICGameLuckyBagService;
import com.tencent.mobileqq.icgame.api.message.IQQLiveAnnounceMsgService;
import com.tencent.mobileqq.icgame.api.message.IQQLiveChatMsgService;
import com.tencent.mobileqq.icgame.api.message.IQQLiveEnterRoomService;
import com.tencent.mobileqq.icgame.api.message.IQQLiveFollowMsgService;
import com.tencent.mobileqq.icgame.api.message.IQQLivePushCmdService;
import com.tencent.mobileqq.icgame.api.message.IQQLiveSystemMsgService;
import com.tencent.mobileqq.icgame.api.room.IAudienceList;
import com.tencent.mobileqq.icgame.api.room.ILiveRoom;
import com.tencent.mobileqq.icgame.api.room.ILiveRoomBase;
import com.tencent.mobileqq.icgame.api.room.ILiveRoomEndPage;
import com.tencent.mobileqq.icgame.data.heart.FloatHeart;
import com.tencent.mobileqq.icgame.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveAnnouncePushListener;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.data.config.MessagePushConfig;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import t42.g;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class BaseLiveRoom implements ILiveRoom {
    public static final String HEAR_TREAD_NAME = "room-heart";
    private static final String TAG = "ICGameBaseLiveRoom";
    protected String appId;
    protected IQQLiveSDK liveSDK = null;
    t32.a pushService = new com.tencent.mobileqq.icgame.push.e();
    LiveRoomStatusService roomStatusService = new LiveRoomStatusService();
    private IQQLiveChatMsgService chatMsgService = new QQLiveChatMsgServiceImpl();
    private IQQLiveSystemMsgService systemMsgService = new QQLiveSystemMsgServiceImpl();
    private IQQLiveEnterRoomService enterRoomService = new LiveEnterRoomServiceImpl();
    private IQQLiveGiftService giftService = new QQLiveGiftServiceImpl();
    private IQQLiveFloatHeartService floatHeartService = new QQLiveFloatHeartServiceImpl();
    private IQQLiveFollowMsgService followMsgService = new QQLiveFollowMsgServiceImpl();
    private IQQLiveAnnounceMsgService announceMsgService = new QQLiveAnnounceMsgServiceImpl();
    private IQQLivePushCmdService pushCmdService = new QQLivePushCmdServiceImpl();
    private IAudienceList audienceListService = new AudienceListImpl();
    private ILiveRoomEndPage endPageModule = new LiveRoomEndPageImpl();
    private IICGameLuckyBagService luckyBagService = new ICGameLuckyBagServiceImpl();
    protected QQLiveRoomBizReportHelper reportHelper = new QQLiveRoomBizReportHelper();
    protected boolean isExitRoom = false;
    protected boolean isInited = false;
    protected boolean isDestroy = false;
    protected boolean isEnterRoomed = false;

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoom
    public void clearReportCallback() {
        QQLiveRoomBizReportHelper qQLiveRoomBizReportHelper = this.reportHelper;
        if (qQLiveRoomBizReportHelper != null) {
            qQLiveRoomBizReportHelper.clearReportCallback();
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void destroy() {
        g.a(TAG, "destroy in sub thread!!");
        QLog.i(TAG, 1, "destroy");
        t32.a aVar = (t32.a) this.liveSDK.getExtModule("roomPush");
        BaseRoomInfo roomInfo = getRoomInfo();
        if (roomInfo != null && aVar != null && aVar.getRoomId() == roomInfo.getRoomId()) {
            aVar.reset();
        }
        IQQLiveChatMsgService iQQLiveChatMsgService = this.chatMsgService;
        if (iQQLiveChatMsgService != null) {
            iQQLiveChatMsgService.destroy();
            this.chatMsgService = null;
        }
        IQQLiveSystemMsgService iQQLiveSystemMsgService = this.systemMsgService;
        if (iQQLiveSystemMsgService != null) {
            iQQLiveSystemMsgService.destroy();
            this.systemMsgService = null;
        }
        IQQLiveEnterRoomService iQQLiveEnterRoomService = this.enterRoomService;
        if (iQQLiveEnterRoomService != null) {
            iQQLiveEnterRoomService.destroy();
            this.enterRoomService = null;
        }
        IQQLiveFloatHeartService iQQLiveFloatHeartService = this.floatHeartService;
        if (iQQLiveFloatHeartService != null) {
            iQQLiveFloatHeartService.destroy();
            this.floatHeartService = null;
        }
        IQQLiveGiftService iQQLiveGiftService = this.giftService;
        if (iQQLiveGiftService != null) {
            iQQLiveGiftService.destroy();
            this.giftService = null;
        }
        IICGameLuckyBagService iICGameLuckyBagService = this.luckyBagService;
        if (iICGameLuckyBagService != null) {
            iICGameLuckyBagService.destroy();
            this.luckyBagService = null;
        }
        IQQLiveFollowMsgService iQQLiveFollowMsgService = this.followMsgService;
        if (iQQLiveFollowMsgService != null) {
            iQQLiveFollowMsgService.destroy();
            this.followMsgService = null;
        }
        LiveRoomStatusService liveRoomStatusService = this.roomStatusService;
        if (liveRoomStatusService != null) {
            liveRoomStatusService.destroy();
            this.roomStatusService = null;
        }
        IQQLiveAnnounceMsgService iQQLiveAnnounceMsgService = this.announceMsgService;
        if (iQQLiveAnnounceMsgService != null) {
            iQQLiveAnnounceMsgService.destroy();
            this.announceMsgService = null;
        }
        IQQLivePushCmdService iQQLivePushCmdService = this.pushCmdService;
        if (iQQLivePushCmdService != null) {
            iQQLivePushCmdService.destroy();
            this.pushCmdService = null;
        }
        IAudienceList iAudienceList = this.audienceListService;
        if (iAudienceList != null) {
            iAudienceList.destroy();
            this.audienceListService = null;
        }
        ILiveRoomEndPage iLiveRoomEndPage = this.endPageModule;
        if (iLiveRoomEndPage != null) {
            iLiveRoomEndPage.destroy();
            this.endPageModule = null;
        }
        this.isDestroy = true;
        QQLiveRoomBizReportHelper qQLiveRoomBizReportHelper = this.reportHelper;
        if (qQLiveRoomBizReportHelper != null) {
            qQLiveRoomBizReportHelper.destroy();
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomBase
    public void exitRoom(ExitRoomCallback exitRoomCallback) {
        this.isExitRoom = true;
        QQLiveRoomBizReportHelper qQLiveRoomBizReportHelper = this.reportHelper;
        if (qQLiveRoomBizReportHelper != null) {
            qQLiveRoomBizReportHelper.onExitRoom();
        }
        reset();
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomTime
    public long getEnterRoomTime() {
        QQLiveRoomBizReportHelper qQLiveRoomBizReportHelper = this.reportHelper;
        if (qQLiveRoomBizReportHelper != null) {
            return qQLiveRoomBizReportHelper.getEnterRoomTime();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomBase
    public void getLiveEndPageInfo(b32.d dVar) {
        BaseRoomInfo roomInfo;
        BaseAnchorInfo anchorInfo;
        if (this.isDestroy || (roomInfo = getRoomInfo()) == null || (anchorInfo = getAnchorInfo()) == null) {
            return;
        }
        this.endPageModule.getLiveEndPageInfo(anchorInfo.getAnchorUid(), roomInfo.getProgramId(), dVar);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomOperation
    public void getRoomAnnounce(long j3, t22.a aVar) {
        if (this.isDestroy) {
            return;
        }
        this.announceMsgService.getRoomAnnounce(j3, aVar);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomBase
    public void getUserNumber(long j3, a32.b bVar) {
        if (this.isDestroy) {
            return;
        }
        this.audienceListService.getUserNumber(j3, bVar);
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        this.liveSDK = iQQLiveSDK;
        if (iQQLiveSDK.getSDKConfig() != null) {
            this.appId = this.liveSDK.getAppId();
        }
        String str = this.appId;
        if (str == null) {
            str = "";
        }
        this.appId = str;
        QQLiveRoomBizReportHelper qQLiveRoomBizReportHelper = this.reportHelper;
        if (qQLiveRoomBizReportHelper != null) {
            qQLiveRoomBizReportHelper.init(iQQLiveSDK, this);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomBase
    public boolean isDestroyed() {
        return this.isDestroy;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomBase
    public boolean isExitRoom() {
        return this.isExitRoom;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomBase
    public boolean isInited() {
        return this.isInited;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onEnterRoom() {
        this.endPageModule.init(this.liveSDK);
        if (this.isDestroy) {
            return;
        }
        t32.a aVar = (t32.a) this.liveSDK.getExtModule("roomPush");
        this.pushService = aVar;
        if (aVar == null) {
            QLog.e(TAG, 1, "IQQLiveRoomPushService is null onEnterRoom");
            return;
        }
        aVar.h(0L, getRoomInfo().getRoomId());
        this.chatMsgService.init(this.liveSDK);
        this.systemMsgService.init(this.liveSDK);
        this.enterRoomService.init(this.liveSDK);
        this.enterRoomService.bindRoom(this);
        this.floatHeartService.init(this.liveSDK);
        this.giftService.init(this.liveSDK);
        this.followMsgService.init(this.liveSDK);
        this.announceMsgService.init(this.liveSDK);
        this.pushCmdService.init(this.liveSDK);
        this.audienceListService.init(this.liveSDK);
        this.roomStatusService.init(this.liveSDK);
        this.luckyBagService.init(this.liveSDK);
        this.liveSDK.getDataReportModule().setRoomInfo(getRoomInfo());
        QQLiveRoomBizReportHelper qQLiveRoomBizReportHelper = this.reportHelper;
        if (qQLiveRoomBizReportHelper != null) {
            qQLiveRoomBizReportHelper.onEnterRoom();
        }
        this.isEnterRoomed = true;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomBase
    public void preloadService(long j3, ILiveRoomBase.ServiceType serviceType) {
        if (serviceType == ILiveRoomBase.ServiceType.DATA) {
            this.audienceListService.init(this.liveSDK);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage
    public void registerAnnounceMessageListener(IQQLiveAnnouncePushListener iQQLiveAnnouncePushListener) {
        if (this.isDestroy) {
            return;
        }
        this.announceMsgService.addAnnounceMessageListener(iQQLiveAnnouncePushListener);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage
    public void registerAudienceInfoListener(a32.a aVar) {
        if (this.isDestroy) {
            return;
        }
        this.enterRoomService.addEnterRoomMessageListener(aVar);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage
    public void registerFollowMessageListener(IQQLiveReceiveFollowListener iQQLiveReceiveFollowListener) {
        if (this.isDestroy) {
            return;
        }
        this.followMsgService.addFollowMessageListener(iQQLiveReceiveFollowListener);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage
    public void registerHighPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback) {
        if (this.isDestroy) {
            return;
        }
        this.pushCmdService.registerHighPriorityListener(i3, iQQCmdPushCallback);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage
    public void registerLivePushChannel(int i3, IQQCmdPushCallback iQQCmdPushCallback) {
        if (this.isDestroy) {
            return;
        }
        this.pushCmdService.registerLivePushChannel(i3, iQQCmdPushCallback);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage
    public void registerLowPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback) {
        if (this.isDestroy) {
            return;
        }
        this.pushCmdService.registerLowPriorityListener(i3, iQQCmdPushCallback);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoom
    public void registerMessageSmoothConfig(MessagePushConfig messagePushConfig) {
        t32.a aVar = this.pushService;
        if (aVar != null && !this.isDestroy && this.isEnterRoomed) {
            aVar.registerMessageSmoothConfig(messagePushConfig);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage
    public void registerOnReceiveFloatHeartListener(ji2.a aVar) {
        if (this.isDestroy) {
            return;
        }
        this.floatHeartService.addOnReceiveFloatHeartListener(aVar);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage
    public void registerReceiveGiftMessageListener(v22.a aVar) {
        if (this.isDestroy) {
            return;
        }
        this.giftService.addReceiveGiftMessageListener(aVar);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage
    public void registerReceiveLuckyBagMessageListener(x22.a aVar) {
        if (this.isDestroy) {
            return;
        }
        this.luckyBagService.addReceiveGiftMessageListener(aVar);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoom
    public void registerReportCallback(com.tencent.mobileqq.qqlive.report.a aVar) {
        QQLiveRoomBizReportHelper qQLiveRoomBizReportHelper = this.reportHelper;
        if (qQLiveRoomBizReportHelper != null) {
            qQLiveRoomBizReportHelper.registerReportCallback(aVar);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage
    public void registerRoomChatMsgListener(y22.a aVar) {
        if (this.isDestroy) {
            return;
        }
        this.chatMsgService.addChatMessageListener(aVar);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage
    public void registerRoomFollowListener(IQQLiveReceiveFollowListener iQQLiveReceiveFollowListener) {
        if (this.isDestroy) {
            return;
        }
        this.followMsgService.addFollowRoomListener(iQQLiveReceiveFollowListener);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage
    public void registerRoomStatusListener(b32.e eVar) {
        if (this.isDestroy) {
            return;
        }
        this.roomStatusService.registerRoomInfoListener(eVar);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage
    public void registerSystemMsgListener(y22.a aVar) {
        if (this.isDestroy) {
            return;
        }
        this.systemMsgService.addSystemMessageListener(aVar);
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void reset() {
        QLog.i(TAG, 1, "reset");
        QQLiveRoomBizReportHelper qQLiveRoomBizReportHelper = this.reportHelper;
        if (qQLiveRoomBizReportHelper != null) {
            qQLiveRoomBizReportHelper.reset();
        }
        try {
            if (this.isDestroy) {
                return;
            }
            t32.a aVar = (t32.a) this.liveSDK.getExtModule("roomPush");
            BaseRoomInfo roomInfo = getRoomInfo();
            if (roomInfo != null && aVar.getRoomId() == roomInfo.getRoomId()) {
                aVar.reset();
            }
            IQQLiveChatMsgService iQQLiveChatMsgService = this.chatMsgService;
            if (iQQLiveChatMsgService != null) {
                iQQLiveChatMsgService.reset();
            }
            IQQLiveSystemMsgService iQQLiveSystemMsgService = this.systemMsgService;
            if (iQQLiveSystemMsgService != null) {
                iQQLiveSystemMsgService.reset();
            }
            IQQLiveEnterRoomService iQQLiveEnterRoomService = this.enterRoomService;
            if (iQQLiveEnterRoomService != null) {
                iQQLiveEnterRoomService.reset();
            }
            IQQLiveFloatHeartService iQQLiveFloatHeartService = this.floatHeartService;
            if (iQQLiveFloatHeartService != null) {
                iQQLiveFloatHeartService.reset();
            }
            IQQLiveGiftService iQQLiveGiftService = this.giftService;
            if (iQQLiveGiftService != null) {
                iQQLiveGiftService.reset();
            }
            IICGameLuckyBagService iICGameLuckyBagService = this.luckyBagService;
            if (iICGameLuckyBagService != null) {
                iICGameLuckyBagService.reset();
            }
            IQQLiveFollowMsgService iQQLiveFollowMsgService = this.followMsgService;
            if (iQQLiveFollowMsgService != null) {
                iQQLiveFollowMsgService.reset();
            }
            LiveRoomStatusService liveRoomStatusService = this.roomStatusService;
            if (liveRoomStatusService != null) {
                liveRoomStatusService.reset();
            }
            IQQLiveAnnounceMsgService iQQLiveAnnounceMsgService = this.announceMsgService;
            if (iQQLiveAnnounceMsgService != null) {
                iQQLiveAnnounceMsgService.reset();
            }
            IQQLivePushCmdService iQQLivePushCmdService = this.pushCmdService;
            if (iQQLivePushCmdService != null) {
                iQQLivePushCmdService.reset();
            }
            IAudienceList iAudienceList = this.audienceListService;
            if (iAudienceList != null) {
                iAudienceList.reset();
            }
            ILiveRoomEndPage iLiveRoomEndPage = this.endPageModule;
            if (iLiveRoomEndPage != null) {
                iLiveRoomEndPage.reset();
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomOperation
    public void sendFloatHeart(boolean z16, String str) {
        if (this.isDestroy) {
            return;
        }
        FloatHeart floatHeart = new FloatHeart();
        floatHeart.firstLike = z16;
        floatHeart.roomId = getRoomInfo().getRoomId();
        floatHeart.materialId = str;
        if (getAnchorInfo() != null) {
            floatHeart.anchorId = getAnchorInfo().getAnchorUid();
        }
        this.floatHeartService.sendFloatHeart(floatHeart);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomOperation
    public void sendFloatHeartEnd() {
        if (!this.isDestroy && this.isEnterRoomed) {
            this.floatHeartService.sendFloatHeartEnd();
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomOperation
    public void sendMessage(String str, ArrayList<LiveMessageData.ExtData> arrayList, IQQLiveMessageCallback iQQLiveMessageCallback) {
        if (this.isDestroy) {
            return;
        }
        this.chatMsgService.sendMessage(str, arrayList, iQQLiveMessageCallback);
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomTime
    public void setEnterRoomTime(long j3) {
        QQLiveRoomBizReportHelper qQLiveRoomBizReportHelper = this.reportHelper;
        if (qQLiveRoomBizReportHelper != null) {
            qQLiveRoomBizReportHelper.setEnterRoomTime(j3);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomOperation
    public void setRoomAnnounce(long j3, long j16, String str, t22.b bVar) {
        if (this.isDestroy) {
            return;
        }
        this.announceMsgService.setRoomAnnounce(j3, j16, str, bVar);
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomTime
    public void startRoomTimer(long j3) {
        QQLiveRoomBizReportHelper qQLiveRoomBizReportHelper = this.reportHelper;
        if (qQLiveRoomBizReportHelper != null) {
            qQLiveRoomBizReportHelper.startRoomHeartForBiz(j3);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomTime
    public void stopRoomTimer() {
        QQLiveRoomBizReportHelper qQLiveRoomBizReportHelper = this.reportHelper;
        if (qQLiveRoomBizReportHelper != null) {
            qQLiveRoomBizReportHelper.stopRoomHeartForBiz();
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage
    public void unRegisterAnnounceMessageListener(IQQLiveAnnouncePushListener iQQLiveAnnouncePushListener) {
        if (this.isDestroy) {
            return;
        }
        this.announceMsgService.delAnnounceMessageListener(iQQLiveAnnouncePushListener);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage
    public void unRegisterAudienceInfoListener(a32.a aVar) {
        if (this.isDestroy) {
            return;
        }
        this.enterRoomService.delEnterRoomMessageListener(aVar);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage
    public void unRegisterFollowMessageListener(IQQLiveReceiveFollowListener iQQLiveReceiveFollowListener) {
        if (this.isDestroy) {
            return;
        }
        this.followMsgService.delFollowMessageListener(iQQLiveReceiveFollowListener);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage
    public void unRegisterHighPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback) {
        if (this.isDestroy) {
            return;
        }
        this.pushCmdService.unRegisterHighPriorityListener(i3, iQQCmdPushCallback);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage
    public void unRegisterLivePushChannel(IQQCmdPushCallback iQQCmdPushCallback) {
        if (this.isDestroy) {
            return;
        }
        this.pushCmdService.unRegisterLivePushChannel(iQQCmdPushCallback);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage
    public void unRegisterLowPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback) {
        if (this.isDestroy) {
            return;
        }
        this.pushCmdService.unRegisterLowPriorityListener(i3, iQQCmdPushCallback);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoom
    public void unRegisterMessageSmooth() {
        t32.a aVar = this.pushService;
        if (aVar != null && !this.isDestroy && this.isEnterRoomed) {
            aVar.unRegisterMessageSmooth();
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage
    public void unRegisterOnReceiveFloatHeartListener(ji2.a aVar) {
        if (this.isDestroy) {
            return;
        }
        this.floatHeartService.removeOnReceiveFloatHeartListener(aVar);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage
    public void unRegisterReceiveGiftMessageListener(v22.a aVar) {
        if (this.isDestroy) {
            return;
        }
        this.giftService.delReceiveGiftMessageListener(aVar);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage
    public void unRegisterReceiveLuckyBagMessageListener(x22.a aVar) {
        if (this.isDestroy) {
            return;
        }
        this.luckyBagService.delReceiveGiftMessageListener(aVar);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoom
    public void unRegisterReportCallback(com.tencent.mobileqq.qqlive.report.a aVar) {
        QQLiveRoomBizReportHelper qQLiveRoomBizReportHelper = this.reportHelper;
        if (qQLiveRoomBizReportHelper != null) {
            qQLiveRoomBizReportHelper.unRegisterReportCallback(aVar);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage
    public void unRegisterRoomChatMsgListener(y22.a aVar) {
        if (this.isDestroy) {
            return;
        }
        this.chatMsgService.delChatMessageListener(aVar);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage
    public void unRegisterRoomFollowListener(IQQLiveReceiveFollowListener iQQLiveReceiveFollowListener) {
        if (this.isDestroy) {
            return;
        }
        this.followMsgService.delFollowRoomListener(iQQLiveReceiveFollowListener);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage
    public void unRegisterRoomStatusListener(b32.e eVar) {
        if (this.isDestroy) {
            return;
        }
        this.roomStatusService.unRegisterRoomInfoListener(eVar);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage
    public void unRegisterSystemMsgListener(y22.a aVar) {
        if (this.isDestroy) {
            return;
        }
        this.systemMsgService.delSystemMessageListener(aVar);
    }
}
