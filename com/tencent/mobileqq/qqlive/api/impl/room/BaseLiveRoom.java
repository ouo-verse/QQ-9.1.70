package com.tencent.mobileqq.qqlive.api.impl.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.gift.IQQLiveGiftService;
import com.tencent.mobileqq.qqlive.api.heart.IQQLiveFloatHeartService;
import com.tencent.mobileqq.qqlive.api.impl.gift.QQLiveGiftServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.lottery.QQLiveLotteryServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.luckybag.QQLiveLuckyBagServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.message.LiveEnterRoomServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.message.QQLiveAnnounceMsgServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.message.QQLiveChatMsgServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.message.QQLiveFloatHeartServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.message.QQLiveFollowMsgServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.message.QQLivePushCmdServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.message.QQLiveSystemMsgServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.message.QQLiveUserLevelServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.room.report.QQLiveRoomBizReportHelper;
import com.tencent.mobileqq.qqlive.api.lottery.IQQLiveLotteryService;
import com.tencent.mobileqq.qqlive.api.luckybag.IQQLiveLuckyBagService;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveAnnounceMsgService;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveChatMsgService;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveEnterRoomService;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveFollowMsgService;
import com.tencent.mobileqq.qqlive.api.message.IQQLivePushCmdService;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveSystemMsgService;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveUserLevelService;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveAnnouncePushListener;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener;
import com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener;
import com.tencent.mobileqq.qqlive.callback.luckybag.ReceiveLuckyBagMessageListener;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveReceiveMessageListener;
import com.tencent.mobileqq.qqlive.callback.room.RoomAudienceInfoListener;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener;
import com.tencent.mobileqq.qqlive.callback.userlevel.IQQLiveUserLevelChangeListener;
import com.tencent.mobileqq.qqlive.data.config.MessagePushConfig;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.push.f;
import com.tencent.mobileqq.qqlive.utils.o;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public abstract class BaseLiveRoom implements ILiveRoom {
    static IPatchRedirector $redirector_ = null;
    public static final String HEAR_TREAD_NAME = "room-heart";
    private static final String TAG = "BaseLiveRoom";
    private IQQLiveAnnounceMsgService announceMsgService;
    protected String appId;
    private IQQLiveChatMsgService chatMsgService;
    private IQQLiveEnterRoomService enterRoomService;
    private IQQLiveFloatHeartService floatHeartService;
    private IQQLiveFollowMsgService followMsgService;
    private IQQLiveGiftService giftService;
    protected boolean isDestroy;
    protected boolean isEnterRoomed;
    protected boolean isExitRoom;
    protected boolean isInited;
    private IQQLiveLotteryService liveLotteryService;
    protected IQQLiveSDK liveSDK;
    private IQQLiveLuckyBagService luckyBagService;
    private IQQLivePushCmdService pushCmdService;
    ni2.b pushService;
    protected QQLiveRoomBizReportHelper reportHelper;
    LiveRoomStatusService roomStatusService;
    private IQQLiveSystemMsgService systemMsgService;
    private IQQLiveUserLevelService userLevelService;

    public BaseLiveRoom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.liveSDK = null;
        this.pushService = new f();
        this.roomStatusService = new LiveRoomStatusService();
        this.chatMsgService = new QQLiveChatMsgServiceImpl();
        this.systemMsgService = new QQLiveSystemMsgServiceImpl();
        this.userLevelService = new QQLiveUserLevelServiceImpl(this);
        this.enterRoomService = new LiveEnterRoomServiceImpl();
        this.giftService = new QQLiveGiftServiceImpl();
        this.floatHeartService = new QQLiveFloatHeartServiceImpl();
        this.followMsgService = new QQLiveFollowMsgServiceImpl();
        this.announceMsgService = new QQLiveAnnounceMsgServiceImpl();
        this.pushCmdService = new QQLivePushCmdServiceImpl();
        this.liveLotteryService = new QQLiveLotteryServiceImpl();
        this.luckyBagService = new QQLiveLuckyBagServiceImpl();
        this.reportHelper = new QQLiveRoomBizReportHelper();
        this.isExitRoom = false;
        this.isInited = false;
        this.isDestroy = false;
        this.isEnterRoomed = false;
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoom
    public void clearReportCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this);
            return;
        }
        QQLiveRoomBizReportHelper qQLiveRoomBizReportHelper = this.reportHelper;
        if (qQLiveRoomBizReportHelper != null) {
            qQLiveRoomBizReportHelper.clearReportCallback();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this);
            return;
        }
        o.a(TAG, "destroy in sub thread!!");
        QLog.i(TAG, 1, "destroy");
        ni2.b bVar = (ni2.b) this.liveSDK.getExtModule("roomPush");
        BaseRoomInfo roomInfo = getRoomInfo();
        if (roomInfo != null && bVar != null && bVar.getRoomId() == roomInfo.getRoomId()) {
            bVar.reset();
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
        IQQLiveLuckyBagService iQQLiveLuckyBagService = this.luckyBagService;
        if (iQQLiveLuckyBagService != null) {
            iQQLiveLuckyBagService.destroy();
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
        this.isDestroy = true;
        QQLiveRoomBizReportHelper qQLiveRoomBizReportHelper = this.reportHelper;
        if (qQLiveRoomBizReportHelper != null) {
            qQLiveRoomBizReportHelper.destroy();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomBase
    public void exitRoom(ExitRoomCallback exitRoomCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) exitRoomCallback);
            return;
        }
        this.isExitRoom = true;
        QQLiveRoomBizReportHelper qQLiveRoomBizReportHelper = this.reportHelper;
        if (qQLiveRoomBizReportHelper != null) {
            qQLiveRoomBizReportHelper.onExitRoom();
        }
        reset();
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomTime
    public long getEnterRoomTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Long) iPatchRedirector.redirect((short) 47, (Object) this)).longValue();
        }
        QQLiveRoomBizReportHelper qQLiveRoomBizReportHelper = this.reportHelper;
        if (qQLiveRoomBizReportHelper != null) {
            return qQLiveRoomBizReportHelper.getEnterRoomTime();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iQQLiveSDK);
            return;
        }
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

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomBase
    public boolean isDestroyed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Boolean) iPatchRedirector.redirect((short) 38, (Object) this)).booleanValue();
        }
        return this.isDestroy;
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomBase
    public boolean isExitRoom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this)).booleanValue();
        }
        return this.isExitRoom;
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomBase
    public boolean isInited() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this)).booleanValue();
        }
        return this.isInited;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onEnterRoom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.isDestroy) {
            return;
        }
        ni2.b bVar = (ni2.b) this.liveSDK.getExtModule("roomPush");
        this.pushService = bVar;
        if (bVar == null) {
            QLog.e(TAG, 1, "IQQLiveRoomPushService is null onEnterRoom");
            return;
        }
        bVar.e(0L, getRoomInfo().getRoomId(), null);
        this.chatMsgService.init(this.liveSDK);
        this.systemMsgService.init(this.liveSDK);
        this.enterRoomService.init(this.liveSDK);
        this.enterRoomService.bindRoom(this);
        this.floatHeartService.init(this.liveSDK);
        this.giftService.init(this.liveSDK);
        this.followMsgService.init(this.liveSDK);
        this.announceMsgService.init(this.liveSDK);
        this.pushCmdService.init(this.liveSDK);
        this.liveLotteryService.init(this.liveSDK);
        this.roomStatusService.init(this.liveSDK);
        this.userLevelService.init(this.liveSDK);
        this.luckyBagService.init(this.liveSDK);
        this.liveSDK.getDataReportModule().setRoomInfo(getRoomInfo());
        QQLiveRoomBizReportHelper qQLiveRoomBizReportHelper = this.reportHelper;
        if (qQLiveRoomBizReportHelper != null) {
            qQLiveRoomBizReportHelper.onEnterRoom();
        }
        this.isEnterRoomed = true;
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage
    @Deprecated
    public void registerAnnounceMessageListener(IQQLiveAnnouncePushListener iQQLiveAnnouncePushListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) iQQLiveAnnouncePushListener);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.announceMsgService.addAnnounceMessageListener(iQQLiveAnnouncePushListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage
    public void registerAudienceInfoListener(RoomAudienceInfoListener roomAudienceInfoListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) roomAudienceInfoListener);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.enterRoomService.addEnterRoomMessageListener(roomAudienceInfoListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage
    public void registerFollowMessageListener(IQQLiveReceiveFollowListener iQQLiveReceiveFollowListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) iQQLiveReceiveFollowListener);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.followMsgService.addFollowMessageListener(iQQLiveReceiveFollowListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage
    public void registerHighPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, i3, (Object) iQQCmdPushCallback);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.pushCmdService.registerHighPriorityListener(i3, iQQCmdPushCallback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage
    public void registerLivePushChannel(int i3, IQQCmdPushCallback iQQCmdPushCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, i3, (Object) iQQCmdPushCallback);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.pushCmdService.registerLivePushChannel(i3, iQQCmdPushCallback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage
    public void registerLowPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, i3, (Object) iQQCmdPushCallback);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.pushCmdService.registerLowPriorityListener(i3, iQQCmdPushCallback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoom
    public void registerMessageSmoothConfig(MessagePushConfig messagePushConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) messagePushConfig);
            return;
        }
        ni2.b bVar = this.pushService;
        if (bVar != null && !this.isDestroy && this.isEnterRoomed) {
            bVar.registerMessageSmoothConfig(messagePushConfig);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage
    @Deprecated
    public void registerOnReceiveFloatHeartListener(ji2.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) aVar);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.floatHeartService.addOnReceiveFloatHeartListener(aVar);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage
    public void registerReceiveGiftMessageListener(ReceiveGiftMessageListener receiveGiftMessageListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) receiveGiftMessageListener);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.giftService.addReceiveGiftMessageListener(receiveGiftMessageListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage
    public void registerReceiveLuckyBagMessageListener(ReceiveLuckyBagMessageListener receiveLuckyBagMessageListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) receiveLuckyBagMessageListener);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.luckyBagService.addReceiveGiftMessageListener(receiveLuckyBagMessageListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoom
    public void registerReportCallback(com.tencent.mobileqq.qqlive.report.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) aVar);
            return;
        }
        QQLiveRoomBizReportHelper qQLiveRoomBizReportHelper = this.reportHelper;
        if (qQLiveRoomBizReportHelper != null) {
            qQLiveRoomBizReportHelper.registerReportCallback(aVar);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage
    public void registerRoomChatMsgListener(IQQLiveReceiveMessageListener iQQLiveReceiveMessageListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) iQQLiveReceiveMessageListener);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.chatMsgService.addChatMessageListener(iQQLiveReceiveMessageListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage
    public void registerRoomFollowListener(IQQLiveReceiveFollowListener iQQLiveReceiveFollowListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) iQQLiveReceiveFollowListener);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.followMsgService.addFollowRoomListener(iQQLiveReceiveFollowListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage
    public void registerRoomStatusListener(LiveRoomStatusListener liveRoomStatusListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) liveRoomStatusListener);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.roomStatusService.registerRoomInfoListener(liveRoomStatusListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage
    public void registerSystemMsgListener(IQQLiveReceiveMessageListener iQQLiveReceiveMessageListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) iQQLiveReceiveMessageListener);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.systemMsgService.addSystemMessageListener(iQQLiveReceiveMessageListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage
    public void registerUserLevelChangedListener(IQQLiveUserLevelChangeListener iQQLiveUserLevelChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) iQQLiveUserLevelChangeListener);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.userLevelService.registerUserLevelChangedListener(iQQLiveUserLevelChangeListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this);
            return;
        }
        QLog.i(TAG, 1, "reset");
        QQLiveRoomBizReportHelper qQLiveRoomBizReportHelper = this.reportHelper;
        if (qQLiveRoomBizReportHelper != null) {
            qQLiveRoomBizReportHelper.reset();
        }
        try {
            if (this.isDestroy) {
                return;
            }
            ni2.b bVar = (ni2.b) this.liveSDK.getExtModule("roomPush");
            BaseRoomInfo roomInfo = getRoomInfo();
            if (roomInfo != null && bVar.getRoomId() == roomInfo.getRoomId()) {
                bVar.reset();
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
            IQQLiveLuckyBagService iQQLiveLuckyBagService = this.luckyBagService;
            if (iQQLiveLuckyBagService != null) {
                iQQLiveLuckyBagService.reset();
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
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomOperation
    public void sendMessage(String str, ArrayList<LiveMessageData.ExtData> arrayList, IQQLiveMessageCallback iQQLiveMessageCallback, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, arrayList, iQQLiveMessageCallback, Integer.valueOf(i3));
        } else {
            if (this.isDestroy) {
                return;
            }
            this.chatMsgService.sendMessage(str, arrayList, iQQLiveMessageCallback, i3);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomTime
    public void setEnterRoomTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, j3);
            return;
        }
        QQLiveRoomBizReportHelper qQLiveRoomBizReportHelper = this.reportHelper;
        if (qQLiveRoomBizReportHelper != null) {
            qQLiveRoomBizReportHelper.setEnterRoomTime(j3);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomTime
    public void startRoomTimer(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, j3);
            return;
        }
        QQLiveRoomBizReportHelper qQLiveRoomBizReportHelper = this.reportHelper;
        if (qQLiveRoomBizReportHelper != null) {
            qQLiveRoomBizReportHelper.startRoomHeartForBiz(j3);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomTime
    public void stopRoomTimer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this);
            return;
        }
        QQLiveRoomBizReportHelper qQLiveRoomBizReportHelper = this.reportHelper;
        if (qQLiveRoomBizReportHelper != null) {
            qQLiveRoomBizReportHelper.stopRoomHeartForBiz();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage
    @Deprecated
    public void unRegisterAnnounceMessageListener(IQQLiveAnnouncePushListener iQQLiveAnnouncePushListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) iQQLiveAnnouncePushListener);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.announceMsgService.delAnnounceMessageListener(iQQLiveAnnouncePushListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage
    public void unRegisterAudienceInfoListener(RoomAudienceInfoListener roomAudienceInfoListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) roomAudienceInfoListener);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.enterRoomService.delEnterRoomMessageListener(roomAudienceInfoListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage
    public void unRegisterFollowMessageListener(IQQLiveReceiveFollowListener iQQLiveReceiveFollowListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) iQQLiveReceiveFollowListener);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.followMsgService.delFollowMessageListener(iQQLiveReceiveFollowListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage
    public void unRegisterHighPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, i3, (Object) iQQCmdPushCallback);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.pushCmdService.unRegisterHighPriorityListener(i3, iQQCmdPushCallback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage
    public void unRegisterLivePushChannel(IQQCmdPushCallback iQQCmdPushCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) iQQCmdPushCallback);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.pushCmdService.unRegisterLivePushChannel(iQQCmdPushCallback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage
    public void unRegisterLowPriorityListener(int i3, IQQCmdPushCallback iQQCmdPushCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, i3, (Object) iQQCmdPushCallback);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.pushCmdService.unRegisterLowPriorityListener(i3, iQQCmdPushCallback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoom
    public void unRegisterMessageSmooth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        ni2.b bVar = this.pushService;
        if (bVar != null && !this.isDestroy && this.isEnterRoomed) {
            bVar.unRegisterMessageSmooth();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage
    @Deprecated
    public void unRegisterOnReceiveFloatHeartListener(ji2.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) aVar);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.floatHeartService.removeOnReceiveFloatHeartListener(aVar);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage
    public void unRegisterReceiveGiftMessageListener(ReceiveGiftMessageListener receiveGiftMessageListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) receiveGiftMessageListener);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.giftService.delReceiveGiftMessageListener(receiveGiftMessageListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage
    public void unRegisterReceiveLuckyBagMessageListener(ReceiveLuckyBagMessageListener receiveLuckyBagMessageListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) receiveLuckyBagMessageListener);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.luckyBagService.delReceiveGiftMessageListener(receiveLuckyBagMessageListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoom
    public void unRegisterReportCallback(com.tencent.mobileqq.qqlive.report.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) aVar);
            return;
        }
        QQLiveRoomBizReportHelper qQLiveRoomBizReportHelper = this.reportHelper;
        if (qQLiveRoomBizReportHelper != null) {
            qQLiveRoomBizReportHelper.unRegisterReportCallback(aVar);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage
    public void unRegisterRoomChatMsgListener(IQQLiveReceiveMessageListener iQQLiveReceiveMessageListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) iQQLiveReceiveMessageListener);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.chatMsgService.delChatMessageListener(iQQLiveReceiveMessageListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage
    public void unRegisterRoomFollowListener(IQQLiveReceiveFollowListener iQQLiveReceiveFollowListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) iQQLiveReceiveFollowListener);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.followMsgService.delFollowRoomListener(iQQLiveReceiveFollowListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage
    public void unRegisterRoomStatusListener(LiveRoomStatusListener liveRoomStatusListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) liveRoomStatusListener);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.roomStatusService.unRegisterRoomInfoListener(liveRoomStatusListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage
    public void unRegisterSystemMsgListener(IQQLiveReceiveMessageListener iQQLiveReceiveMessageListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) iQQLiveReceiveMessageListener);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.systemMsgService.delSystemMessageListener(iQQLiveReceiveMessageListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage
    public void unRegisterUserLevelChangedListener(IQQLiveUserLevelChangeListener iQQLiveUserLevelChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) iQQLiveUserLevelChangeListener);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.userLevelService.unRegisterUserLevelChangedListener(iQQLiveUserLevelChangeListener);
        }
    }
}
