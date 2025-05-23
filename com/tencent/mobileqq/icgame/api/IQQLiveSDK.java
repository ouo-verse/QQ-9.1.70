package com.tencent.mobileqq.icgame.api;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.icgame.api.common.IQQLiveUserCard;
import com.tencent.mobileqq.icgame.api.config.IQQLiveConfigModule;
import com.tencent.mobileqq.icgame.api.datareport.IDataReportModule;
import com.tencent.mobileqq.icgame.api.gift.IQQLiveGiftEntranceService;
import com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.icgame.api.message.IQQLiveFollowMsgService;
import com.tencent.mobileqq.icgame.api.pendant.IQQLiveModulePendant;
import com.tencent.mobileqq.icgame.api.room.AudienceRoomConfig;
import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.icgame.api.room.IRoomGetInfoModule;
import com.tencent.mobileqq.icgame.api.sso.IQQLiveSsoProxyModule;
import com.tencent.mobileqq.icgame.api.supervision.IQQLiveModuleKickOut;
import com.tencent.mobileqq.icgame.data.config.QQLiveSDKConfig;
import com.tencent.mobileqq.icgame.data.record.QQLiveSwitchRoom;
import com.tencent.mobileqq.qqlive.data.record.QQLiveCurRoomInfo;
import java.util.List;
import mqq.app.AppRuntime;
import s22.b;
import w32.a;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface IQQLiveSDK {
    void clearFetchRoomList();

    IAudienceRoom createAudienceRoom(AudienceRoomConfig audienceRoomConfig);

    IQQLiveModulePendant createPendantModule();

    void destroy();

    String getAppId();

    AppRuntime getAppRuntime();

    IQQLiveConfigModule getConfigModule();

    QQLiveCurRoomInfo getCurRoomInfo();

    IDataReportModule getDataReportModule();

    IQQLiveModule getExtModule(String str);

    List<QQLiveSwitchRoom> getFetchRoomList();

    IQQLiveFollowMsgService getFollowMsgService();

    IQQLiveGiftEntranceService getGiftEntranceService();

    IQQLiveModuleKickOut getKickOutModule();

    IQQLiveModuleLogin getLoginModule();

    a getProtocolsReport();

    IQQLiveSsoProxyModule getProxySsoService();

    IRoomGetInfoModule getRoomGetInfoModule();

    QQLiveSDKConfig getSDKConfig();

    IQQLiveUserCard getUserCardModule();

    void init(AppRuntime appRuntime, QQLiveSDKConfig qQLiveSDKConfig);

    boolean isDestroyed();

    boolean isInited();

    void recordCurRoomInfo(@NonNull QQLiveCurRoomInfo qQLiveCurRoomInfo);

    void recordFetchRoomList(@NonNull List<QQLiveSwitchRoom> list);

    void registerExtModule(String str, IQQLiveModule iQQLiveModule, boolean z16);

    void registerFetchRoomListUpdateCallback(b bVar);

    void removeCurRoomRecord(@NonNull long j3);

    void unRegisterFetchRoomListUpdateCallback(b bVar);
}
