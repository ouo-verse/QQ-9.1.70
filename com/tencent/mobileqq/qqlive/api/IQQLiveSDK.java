package com.tencent.mobileqq.qqlive.api;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqlive.api.anchor.IQQLiveAnchorPageService;
import com.tencent.mobileqq.qqlive.api.anchor.IQQLiveModuleAnchor;
import com.tencent.mobileqq.qqlive.api.common.IQQLiveUserCard;
import com.tencent.mobileqq.qqlive.api.config.IQQLiveConfigModule;
import com.tencent.mobileqq.qqlive.api.datareport.IDataReportModule;
import com.tencent.mobileqq.qqlive.api.game.IQQLiveGameListService;
import com.tencent.mobileqq.qqlive.api.gift.IQQLiveGiftEntranceService;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.api.lottery.IQQLiveLotteryService;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveFollowMsgService;
import com.tencent.mobileqq.qqlive.api.room.AudienceRoomConfig;
import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveMoreRoomService;
import com.tencent.mobileqq.qqlive.api.room.IRoomGetInfoModule;
import com.tencent.mobileqq.qqlive.api.sso.IQQLiveSsoProxyModule;
import com.tencent.mobileqq.qqlive.api.supervision.IQQLiveModuleReport;
import com.tencent.mobileqq.qqlive.api.upload.IQQLiveModuleFileUpload;
import com.tencent.mobileqq.qqlive.api.verified.IQQLiveVerifyService;
import com.tencent.mobileqq.qqlive.callback.IFetchRoomListCallback;
import com.tencent.mobileqq.qqlive.data.config.QQLiveSDKConfig;
import com.tencent.mobileqq.qqlive.data.record.QQLiveCurRoomInfo;
import com.tencent.mobileqq.qqlive.data.record.QQLiveSwitchRoom;
import com.tencent.mobileqq.qqlive.report.tianjige.b;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveSDK {
    void clearFetchRoomList();

    IAudienceRoom createAudienceRoom(AudienceRoomConfig audienceRoomConfig);

    void destroy();

    IQQLiveModuleAnchor getAnchorModule();

    IQQLiveAnchorPageService getAnchorPageService();

    String getAppId();

    AppRuntime getAppRuntime();

    IQQLiveConfigModule getConfigModule();

    QQLiveCurRoomInfo getCurRoomInfo();

    IDataReportModule getDataReportModule();

    IQQLiveModule getExtModule(String str);

    List<QQLiveSwitchRoom> getFetchRoomList();

    IQQLiveModuleFileUpload getFileUploadModule();

    IQQLiveFollowMsgService getFollowMsgService();

    IQQLiveGameListService getGameListService();

    IQQLiveGiftEntranceService getGiftEntranceService();

    IQQLiveModuleLogin getLoginModule();

    IQQLiveLotteryService getLotteryService();

    ILiveMoreRoomService getMoreRoomService();

    b getProtocolsReport();

    IQQLiveSsoProxyModule getProxySsoService();

    IQQLiveVerifyService getQQLiveVerifyModule();

    IQQLiveModuleReport getReportModule();

    IRoomGetInfoModule getRoomGetInfoModule();

    QQLiveSDKConfig getSDKConfig();

    IQQLiveUserCard getUserCardModule();

    void init(AppRuntime appRuntime, QQLiveSDKConfig qQLiveSDKConfig);

    boolean isDestroyed();

    boolean isInited();

    void recordCurRoomInfo(@NonNull QQLiveCurRoomInfo qQLiveCurRoomInfo);

    void recordFetchRoomList(@NonNull List<QQLiveSwitchRoom> list);

    void registerExtModule(String str, IQQLiveModule iQQLiveModule, boolean z16);

    void registerFetchRoomListUpdateCallback(IFetchRoomListCallback iFetchRoomListCallback);

    void removeCurRoomRecord(@NonNull long j3);

    void unRegisterFetchRoomListUpdateCallback(IFetchRoomListCallback iFetchRoomListCallback);
}
