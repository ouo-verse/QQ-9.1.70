package com.tencent.mobileqq.qqlive.api.impl;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.IQQLiveAnchorPageService;
import com.tencent.mobileqq.qqlive.api.anchor.IQQLiveModuleAnchor;
import com.tencent.mobileqq.qqlive.api.common.IQQLiveUserCard;
import com.tencent.mobileqq.qqlive.api.config.IQQLiveConfigModule;
import com.tencent.mobileqq.qqlive.api.datareport.IDataReportModule;
import com.tencent.mobileqq.qqlive.api.game.IQQLiveGameListService;
import com.tencent.mobileqq.qqlive.api.gift.IQQLiveGiftEntranceService;
import com.tencent.mobileqq.qqlive.api.impl.anchor.QQLiveAnchorPageServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.anchor.QQLiveModuleAnchorImpl;
import com.tencent.mobileqq.qqlive.api.impl.common.QQLiveUserCardImpl;
import com.tencent.mobileqq.qqlive.api.impl.datareport.BaseDataReportModule;
import com.tencent.mobileqq.qqlive.api.impl.game.QQLiveGameListServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.gift.QQLiveGiftEntranceServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.login.QQLiveModuleLoginImpl;
import com.tencent.mobileqq.qqlive.api.impl.lottery.QQLiveLotteryServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.message.QQLiveFollowMsgServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.proxy.QQLiveSsoProxyModuleImpl;
import com.tencent.mobileqq.qqlive.api.impl.room.MoreRoomServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.room.QQLiveModuleReportImpl;
import com.tencent.mobileqq.qqlive.api.impl.room.RoomGetInfoModule;
import com.tencent.mobileqq.qqlive.api.impl.room.avchatroom.LiveAudienceAVChatRoomImpl;
import com.tencent.mobileqq.qqlive.api.impl.room.voiceroom.LiveAudienceVoiceRoomImpl;
import com.tencent.mobileqq.qqlive.api.impl.upload.QQLiveModuleFileUploadImpl;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.api.lottery.IQQLiveLotteryService;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveFollowMsgService;
import com.tencent.mobileqq.qqlive.api.room.AudienceRoomConfig;
import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveMoreRoomService;
import com.tencent.mobileqq.qqlive.api.room.IRoomGetInfoModule;
import com.tencent.mobileqq.qqlive.api.sso.IQQLiveSsoProxyModule;
import com.tencent.mobileqq.qqlive.api.supervision.IQQLiveBanChat;
import com.tencent.mobileqq.qqlive.api.supervision.IQQLiveModuleKickOut;
import com.tencent.mobileqq.qqlive.api.supervision.IQQLiveModuleReport;
import com.tencent.mobileqq.qqlive.api.supervision.IQQLiveRoomAdmin;
import com.tencent.mobileqq.qqlive.api.upload.IQQLiveModuleFileUpload;
import com.tencent.mobileqq.qqlive.api.verified.IQQLiveVerifyService;
import com.tencent.mobileqq.qqlive.callback.IFetchRoomListCallback;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.data.config.ConfigData;
import com.tencent.mobileqq.qqlive.data.config.QQLiveSDKConfig;
import com.tencent.mobileqq.qqlive.data.record.QQLiveCurRoomInfo;
import com.tencent.mobileqq.qqlive.data.record.QQLiveSwitchRoom;
import com.tencent.mobileqq.qqlive.player.a;
import com.tencent.mobileqq.qqlive.push.f;
import com.tencent.mobileqq.qqlive.sso.QQLiveBusinessHandler;
import com.tencent.mobileqq.qqlive.sso.c;
import com.tencent.mobileqq.qqlive.sso.i;
import com.tencent.mobileqq.qqlive.sso.j;
import com.tencent.mobileqq.qqlive.utils.g;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import ni2.b;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveSDKImpl implements IQQLiveSDK {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQLiveSDK_Impl";
    private IQQLiveModuleAnchor anchorModule;
    private IQQLiveAnchorPageService anchorPageService;
    private String appId;
    private IQQLiveBanChat banChatModule;
    private IQQLiveConfigModule configModule;
    private IDataReportModule dataReportModule;
    private final ConcurrentHashMap<String, IQQLiveModule> extModuleMap;
    private final Set<IFetchRoomListCallback> fetchRoomListCallbackSet;
    private IQQLiveModuleFileUpload fileUploadModule;
    private IQQLiveFollowMsgService followMsgService;
    private IQQLiveGameListService gameListService;
    private IQQLiveGiftEntranceService giftEntranceService;
    private IAegisLogApi iAegisLogApi;
    private volatile boolean isDestroyed;
    private volatile boolean isInited;
    private IQQLiveModuleKickOut kickOutModule;
    private IQQLiveLotteryService liveLotteryService;
    private ILiveMoreRoomService liveMoreRoomService;
    private IQQLiveModuleLogin loginModule;
    private b msgPushModule;
    private com.tencent.mobileqq.qqlive.report.tianjige.b protocolsReport;
    private IQQLiveModuleReport reportModule;
    private IQQLiveRoomAdmin roomAdminModule;
    private IRoomGetInfoModule roomGetInfoModule;
    private QQLiveSDKConfig sdkConfig;
    private c ssoModule;
    private IQQLiveSsoProxyModule ssoProxyModule;
    private List<QQLiveSwitchRoom> switchRoomList;
    private final Object switchRoomListSyncObject;
    private IQQLiveUserCard userCardModule;
    private IQQLiveVerifyService verifyService;

    public QQLiveSDKImpl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.extModuleMap = new ConcurrentHashMap<>();
        this.fetchRoomListCallbackSet = new HashSet();
        this.isDestroyed = false;
        this.isInited = false;
        this.configModule = new QQLiveConfigModule();
        this.iAegisLogApi = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        this.switchRoomList = new ArrayList();
        this.switchRoomListSyncObject = new Object();
        this.appId = str;
    }

    private void initLoginModule() {
        QQLiveModuleLoginImpl qQLiveModuleLoginImpl = new QQLiveModuleLoginImpl();
        this.loginModule = qQLiveModuleLoginImpl;
        qQLiveModuleLoginImpl.init(this);
        AppInterface a16 = g.a();
        if (a16 == null) {
            this.iAegisLogApi.e(TAG, 1, "[init] getAppInterface is null!");
            return;
        }
        ConfigData configData = this.configModule.getConfigData();
        if (configData == null) {
            this.iAegisLogApi.e(TAG, 1, "configModule.getConfigData() null");
            return;
        }
        QQLiveBusinessHandler qQLiveBusinessHandler = (QQLiveBusinessHandler) a16.getBusinessHandler(QQLiveBusinessHandler.QQ_LIVE_HANDLER);
        if (qQLiveBusinessHandler != null) {
            qQLiveBusinessHandler.registerCommonHeaderCallback(this.appId, new i(this.loginModule, this.sdkConfig, configData), null);
        } else {
            this.iAegisLogApi.e(TAG, 1, "[init] getBusinessHandler is null");
        }
    }

    private void initProtocolReport() {
        if (!isDestroyed() && this.protocolsReport == null) {
            com.tencent.mobileqq.qqlive.report.g gVar = new com.tencent.mobileqq.qqlive.report.g();
            this.protocolsReport = gVar;
            gVar.init(this);
        }
    }

    private void reportLiveSdkUv() {
        boolean isEnable = VasToggle.isEnable(VasToggle.VAS_QQLIVE_SAMPLING_REPORT_ENABLE, false);
        this.iAegisLogApi.i(TAG, "reportLiveSdkUv:" + isEnable);
        if (isEnable && !TextUtils.isEmpty(this.appId) && g.a() != null && g.a().getAccount() != null) {
            ft3.c a16 = getDataReportModule().newReportTask().a(DTConstants.TAG.SDK_INIT);
            a16.addKeyValue("appid", this.appId);
            a16.addKeyValue(AudienceReportConst.USER_QQ, g.a().getAccount());
            a16.send();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public void clearFetchRoomList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        synchronized (this.switchRoomListSyncObject) {
            List<QQLiveSwitchRoom> list = this.switchRoomList;
            if (list == null) {
                if (QLog.isColorLevel()) {
                    this.iAegisLogApi.i(TAG, 1, "clearFetchRoomList, switchRoomList is null");
                }
            } else {
                list.clear();
                if (QLog.isColorLevel()) {
                    this.iAegisLogApi.i(TAG, 1, "clearFetchRoomList, switchRoomList clear!");
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public IAudienceRoom createAudienceRoom(@NonNull AudienceRoomConfig audienceRoomConfig) {
        IAudienceRoom liveAudienceAVChatRoomImpl;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (IAudienceRoom) iPatchRedirector.redirect((short) 9, (Object) this, (Object) audienceRoomConfig);
        }
        this.iAegisLogApi.i(TAG, 1, "createAudienceRoom config:" + audienceRoomConfig);
        audienceRoomConfig.appId = getAppId();
        int i3 = audienceRoomConfig.roomType;
        if (i3 != 0 && i3 != 1) {
            if (i3 == 2) {
                liveAudienceAVChatRoomImpl = new LiveAudienceVoiceRoomImpl(g.a().getApplication(), audienceRoomConfig);
            } else {
                liveAudienceAVChatRoomImpl = new LiveAudienceAVChatRoomImpl(audienceRoomConfig);
            }
        } else {
            liveAudienceAVChatRoomImpl = new LiveAudienceAVChatRoomImpl(audienceRoomConfig);
        }
        liveAudienceAVChatRoomImpl.init(this);
        return liveAudienceAVChatRoomImpl;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        if (this.isDestroyed) {
            return;
        }
        this.isDestroyed = true;
        this.iAegisLogApi.i(TAG, 1, "sdk destroy, appId:" + this.appId);
        if (!this.extModuleMap.isEmpty()) {
            Iterator<Map.Entry<String, IQQLiveModule>> it = this.extModuleMap.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().destroy();
            }
        }
        this.extModuleMap.clear();
        IQQLiveModuleLogin iQQLiveModuleLogin = this.loginModule;
        if (iQQLiveModuleLogin != null) {
            iQQLiveModuleLogin.destroy();
        }
        IQQLiveFollowMsgService iQQLiveFollowMsgService = this.followMsgService;
        if (iQQLiveFollowMsgService != null) {
            iQQLiveFollowMsgService.destroy();
        }
        IQQLiveGameListService iQQLiveGameListService = this.gameListService;
        if (iQQLiveGameListService != null) {
            iQQLiveGameListService.destroy();
        }
        IQQLiveGiftEntranceService iQQLiveGiftEntranceService = this.giftEntranceService;
        if (iQQLiveGiftEntranceService != null) {
            iQQLiveGiftEntranceService.destroy();
        }
        ILiveMoreRoomService iLiveMoreRoomService = this.liveMoreRoomService;
        if (iLiveMoreRoomService != null) {
            iLiveMoreRoomService.destroy();
        }
        com.tencent.mobileqq.qqlive.report.tianjige.b bVar = this.protocolsReport;
        if (bVar != null) {
            bVar.destroy();
        }
        AppInterface a16 = g.a();
        if (a16 != null) {
            QQLiveBusinessHandler qQLiveBusinessHandler = (QQLiveBusinessHandler) a16.getBusinessHandler(QQLiveBusinessHandler.QQ_LIVE_HANDLER);
            if (qQLiveBusinessHandler != null) {
                qQLiveBusinessHandler.removeCommonHeaderCallback(this.appId);
            }
        } else {
            QLog.e(TAG, 1, "[destroy] appInterface is null");
        }
        this.sdkConfig = null;
        this.fetchRoomListCallbackSet.clear();
        a.c().e();
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public IQQLiveModuleAnchor getAnchorModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (IQQLiveModuleAnchor) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        if (!isDestroyed() && this.anchorModule == null) {
            QQLiveModuleAnchorImpl qQLiveModuleAnchorImpl = new QQLiveModuleAnchorImpl();
            this.anchorModule = qQLiveModuleAnchorImpl;
            qQLiveModuleAnchorImpl.init(this);
        }
        return this.anchorModule;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public IQQLiveAnchorPageService getAnchorPageService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (IQQLiveAnchorPageService) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        if (!isDestroyed() && this.anchorPageService == null) {
            QQLiveAnchorPageServiceImpl qQLiveAnchorPageServiceImpl = new QQLiveAnchorPageServiceImpl();
            this.anchorPageService = qQLiveAnchorPageServiceImpl;
            qQLiveAnchorPageServiceImpl.init(this);
        }
        return this.anchorPageService;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public String getAppId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.appId;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public AppRuntime getAppRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return g.a();
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public IQQLiveConfigModule getConfigModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (IQQLiveConfigModule) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.configModule;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public QQLiveCurRoomInfo getCurRoomInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (QQLiveCurRoomInfo) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        return com.tencent.mobileqq.qqlive.record.a.c(this.appId);
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public IDataReportModule getDataReportModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (IDataReportModule) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        if (!isDestroyed() && this.dataReportModule == null) {
            BaseDataReportModule baseDataReportModule = new BaseDataReportModule();
            this.dataReportModule = baseDataReportModule;
            baseDataReportModule.init(this);
        }
        return this.dataReportModule;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public IQQLiveModule getExtModule(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (IQQLiveModule) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        IQQLiveModule iQQLiveModule = this.extModuleMap.get(str);
        if (!isDestroyed() && iQQLiveModule == null) {
            if (TextUtils.equals("sso_module", str)) {
                j jVar = new j();
                this.ssoModule = jVar;
                registerExtModule("sso_module", jVar, true);
                return this.ssoModule;
            }
            if (TextUtils.equals("roomPush", str)) {
                f fVar = new f();
                this.msgPushModule = fVar;
                registerExtModule("roomPush", fVar, true);
                return this.msgPushModule;
            }
        }
        return iQQLiveModule;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public List<QQLiveSwitchRoom> getFetchRoomList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (List) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        return this.switchRoomList;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public IQQLiveModuleFileUpload getFileUploadModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (IQQLiveModuleFileUpload) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        if (!isDestroyed() && this.fileUploadModule == null) {
            QQLiveModuleFileUploadImpl qQLiveModuleFileUploadImpl = new QQLiveModuleFileUploadImpl();
            this.fileUploadModule = qQLiveModuleFileUploadImpl;
            qQLiveModuleFileUploadImpl.init(this);
        }
        return this.fileUploadModule;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public IQQLiveFollowMsgService getFollowMsgService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (IQQLiveFollowMsgService) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        if (!isDestroyed() && this.followMsgService == null) {
            QQLiveFollowMsgServiceImpl qQLiveFollowMsgServiceImpl = new QQLiveFollowMsgServiceImpl();
            this.followMsgService = qQLiveFollowMsgServiceImpl;
            qQLiveFollowMsgServiceImpl.init(this);
        }
        return this.followMsgService;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public IQQLiveGameListService getGameListService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (IQQLiveGameListService) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        if (!isDestroyed() && this.gameListService == null) {
            QQLiveGameListServiceImpl qQLiveGameListServiceImpl = new QQLiveGameListServiceImpl();
            this.gameListService = qQLiveGameListServiceImpl;
            qQLiveGameListServiceImpl.init(this);
        }
        return this.gameListService;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public IQQLiveGiftEntranceService getGiftEntranceService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (IQQLiveGiftEntranceService) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        if (!isDestroyed() && this.giftEntranceService == null) {
            QQLiveGiftEntranceServiceImpl qQLiveGiftEntranceServiceImpl = new QQLiveGiftEntranceServiceImpl();
            this.giftEntranceService = qQLiveGiftEntranceServiceImpl;
            qQLiveGiftEntranceServiceImpl.init(this);
        }
        return this.giftEntranceService;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public IQQLiveModuleLogin getLoginModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (IQQLiveModuleLogin) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        if (!isDestroyed() && this.loginModule == null) {
            initLoginModule();
        }
        return this.loginModule;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public IQQLiveLotteryService getLotteryService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (IQQLiveLotteryService) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        if (!isDestroyed() && this.liveLotteryService == null) {
            QQLiveLotteryServiceImpl qQLiveLotteryServiceImpl = new QQLiveLotteryServiceImpl();
            this.liveLotteryService = qQLiveLotteryServiceImpl;
            qQLiveLotteryServiceImpl.init(this);
        }
        return this.liveLotteryService;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public ILiveMoreRoomService getMoreRoomService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (ILiveMoreRoomService) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        if (!isDestroyed() && this.liveMoreRoomService == null) {
            MoreRoomServiceImpl moreRoomServiceImpl = new MoreRoomServiceImpl();
            this.liveMoreRoomService = moreRoomServiceImpl;
            moreRoomServiceImpl.init(this);
        }
        return this.liveMoreRoomService;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public com.tencent.mobileqq.qqlive.report.tianjige.b getProtocolsReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (com.tencent.mobileqq.qqlive.report.tianjige.b) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        initProtocolReport();
        return this.protocolsReport;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public IQQLiveSsoProxyModule getProxySsoService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (IQQLiveSsoProxyModule) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        getLoginModule();
        if (!isDestroyed() && this.ssoProxyModule == null) {
            QQLiveSsoProxyModuleImpl qQLiveSsoProxyModuleImpl = new QQLiveSsoProxyModuleImpl();
            this.ssoProxyModule = qQLiveSsoProxyModuleImpl;
            qQLiveSsoProxyModuleImpl.init(this);
        }
        return this.ssoProxyModule;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public IQQLiveVerifyService getQQLiveVerifyModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (IQQLiveVerifyService) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        if (!isDestroyed() && this.verifyService == null) {
            com.tencent.mobileqq.qqlive.verified.b bVar = new com.tencent.mobileqq.qqlive.verified.b();
            this.verifyService = bVar;
            bVar.init(this);
        }
        return this.verifyService;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public IQQLiveModuleReport getReportModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (IQQLiveModuleReport) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        if (!isDestroyed() && this.reportModule == null) {
            QQLiveModuleReportImpl qQLiveModuleReportImpl = new QQLiveModuleReportImpl();
            this.reportModule = qQLiveModuleReportImpl;
            qQLiveModuleReportImpl.init(this);
        }
        return this.reportModule;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public IRoomGetInfoModule getRoomGetInfoModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (IRoomGetInfoModule) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        if (!isDestroyed() && this.roomGetInfoModule == null) {
            RoomGetInfoModule roomGetInfoModule = new RoomGetInfoModule();
            this.roomGetInfoModule = roomGetInfoModule;
            roomGetInfoModule.init(this);
        }
        return this.roomGetInfoModule;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public QQLiveSDKConfig getSDKConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (QQLiveSDKConfig) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.sdkConfig;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public IQQLiveUserCard getUserCardModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (IQQLiveUserCard) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        if (!isDestroyed() && this.userCardModule == null) {
            QQLiveUserCardImpl qQLiveUserCardImpl = new QQLiveUserCardImpl();
            this.userCardModule = qQLiveUserCardImpl;
            qQLiveUserCardImpl.init(this);
        }
        return this.userCardModule;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public void init(AppRuntime appRuntime, QQLiveSDKConfig qQLiveSDKConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime, (Object) qQLiveSDKConfig);
            return;
        }
        this.iAegisLogApi.i(TAG, "[init]");
        if (this.isInited) {
            return;
        }
        this.sdkConfig = qQLiveSDKConfig;
        this.configModule.init(this, qQLiveSDKConfig.appConfig);
        this.isInited = true;
        reportLiveSdkUv();
        initProtocolReport();
        QQLiveContext.Companion companion = QQLiveContext.INSTANCE;
        if (companion.c(this.appId) == null) {
            this.iAegisLogApi.i(TAG, "[init] no current context");
            companion.f(companion.b(new com.tencent.mobileqq.qqlive.context.a(this.appId, null, null, null)));
        }
        this.iAegisLogApi.i(TAG, 1, "sdk init done");
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public boolean isDestroyed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        return this.isDestroyed;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public boolean isInited() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        return this.isInited;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public void recordCurRoomInfo(@NonNull QQLiveCurRoomInfo qQLiveCurRoomInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) qQLiveCurRoomInfo);
        } else {
            com.tencent.mobileqq.qqlive.record.a.g(this.appId, qQLiveCurRoomInfo);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public void recordFetchRoomList(@NonNull List<QQLiveSwitchRoom> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) list);
            return;
        }
        synchronized (this.switchRoomListSyncObject) {
            this.switchRoomList = list;
        }
        Iterator<IFetchRoomListCallback> it = this.fetchRoomListCallbackSet.iterator();
        while (it.hasNext()) {
            it.next().onRoomListUpdate(list);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public void registerExtModule(String str, IQQLiveModule iQQLiveModule, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, iQQLiveModule, Boolean.valueOf(z16));
            return;
        }
        if (!TextUtils.isEmpty(str) && iQQLiveModule != null) {
            this.extModuleMap.put(str, iQQLiveModule);
            if (z16) {
                iQQLiveModule.init(this);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public void registerFetchRoomListUpdateCallback(IFetchRoomListCallback iFetchRoomListCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) iFetchRoomListCallback);
        } else {
            this.fetchRoomListCallbackSet.add(iFetchRoomListCallback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public void removeCurRoomRecord(@NonNull long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, j3);
        } else {
            com.tencent.mobileqq.qqlive.record.a.h(this.appId, j3);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDK
    public void unRegisterFetchRoomListUpdateCallback(IFetchRoomListCallback iFetchRoomListCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) iFetchRoomListCallback);
        } else {
            this.fetchRoomListCallbackSet.remove(iFetchRoomListCallback);
        }
    }
}
