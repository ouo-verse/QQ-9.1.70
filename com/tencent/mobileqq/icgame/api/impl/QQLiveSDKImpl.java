package com.tencent.mobileqq.icgame.api.impl;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.icgame.api.IQQLiveModule;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.common.IQQLiveUserCard;
import com.tencent.mobileqq.icgame.api.config.IQQLiveConfigModule;
import com.tencent.mobileqq.icgame.api.datareport.IDataReportModule;
import com.tencent.mobileqq.icgame.api.gift.IQQLiveGiftEntranceService;
import com.tencent.mobileqq.icgame.api.impl.common.QQLiveUserCardImpl;
import com.tencent.mobileqq.icgame.api.impl.datareport.BaseDataReportModule;
import com.tencent.mobileqq.icgame.api.impl.gift.QQLiveGiftEntranceServiceImpl;
import com.tencent.mobileqq.icgame.api.impl.login.QQLiveModuleLoginImpl;
import com.tencent.mobileqq.icgame.api.impl.message.QQLiveFollowMsgServiceImpl;
import com.tencent.mobileqq.icgame.api.impl.pendant.QQLiveModulePendant;
import com.tencent.mobileqq.icgame.api.impl.proxy.QQLiveSsoProxyModuleImpl;
import com.tencent.mobileqq.icgame.api.impl.room.LiveAudienceTPPlayerRoomImpl;
import com.tencent.mobileqq.icgame.api.impl.room.RoomGetInfoModule;
import com.tencent.mobileqq.icgame.api.impl.supervision.QQLiveKickOutImpl;
import com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.icgame.api.message.IQQLiveFollowMsgService;
import com.tencent.mobileqq.icgame.api.pendant.IQQLiveModulePendant;
import com.tencent.mobileqq.icgame.api.room.AudienceRoomConfig;
import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.icgame.api.room.IRoomGetInfoModule;
import com.tencent.mobileqq.icgame.api.sso.IQQLiveSsoProxyModule;
import com.tencent.mobileqq.icgame.api.supervision.IQQLiveModuleKickOut;
import com.tencent.mobileqq.icgame.context.BuildParams;
import com.tencent.mobileqq.icgame.context.QQLiveContext;
import com.tencent.mobileqq.icgame.data.config.ConfigData;
import com.tencent.mobileqq.icgame.data.config.QQLiveSDKConfig;
import com.tencent.mobileqq.icgame.data.record.QQLiveSwitchRoom;
import com.tencent.mobileqq.icgame.push.e;
import com.tencent.mobileqq.icgame.sso.QQLiveBusinessHandler;
import com.tencent.mobileqq.icgame.sso.c;
import com.tencent.mobileqq.icgame.sso.j;
import com.tencent.mobileqq.icgame.sso.k;
import com.tencent.mobileqq.qqlive.data.record.QQLiveCurRoomInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import t42.d;
import v32.f;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QQLiveSDKImpl implements IQQLiveSDK {
    private static final String TAG = "ICGameSDK_Impl";
    private String appId;
    private IDataReportModule dataReportModule;
    private IQQLiveFollowMsgService followMsgService;
    private IQQLiveGiftEntranceService giftEntranceService;
    private IQQLiveModuleKickOut kickOutModule;
    private IQQLiveModuleLogin loginModule;
    private t32.a msgPushModule;
    private w32.a protocolsReport;
    private IRoomGetInfoModule roomGetInfoModule;
    private QQLiveSDKConfig sdkConfig;
    private c ssoModule;
    private IQQLiveSsoProxyModule ssoProxyModule;
    private IQQLiveUserCard userCardModule;
    private final ConcurrentHashMap<String, IQQLiveModule> extModuleMap = new ConcurrentHashMap<>();
    private final Set<s22.b> fetchRoomListCallbackSet = new HashSet();
    private volatile boolean isDestroyed = false;
    private volatile boolean isInited = false;
    private IQQLiveConfigModule configModule = new QQLiveConfigModule();
    private IAegisLogApi iAegisLogApi = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
    private List<QQLiveSwitchRoom> switchRoomList = new ArrayList();
    private final Object switchRoomListSyncObject = new Object();

    public QQLiveSDKImpl(String str) {
        this.appId = str;
    }

    private void initLoginModule() {
        QQLiveModuleLoginImpl qQLiveModuleLoginImpl = new QQLiveModuleLoginImpl();
        this.loginModule = qQLiveModuleLoginImpl;
        qQLiveModuleLoginImpl.init(this);
        AppInterface a16 = d.a();
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
            qQLiveBusinessHandler.registerCommonHeaderCallback(this.appId, new j(this.loginModule, this.sdkConfig, configData), null);
        } else {
            this.iAegisLogApi.e(TAG, 1, "[init] getBusinessHandler is null");
        }
    }

    private void initProtocolReport() {
        if (!isDestroyed() && this.protocolsReport == null) {
            f fVar = new f();
            this.protocolsReport = fVar;
            fVar.init(this);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDK
    public void clearFetchRoomList() {
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

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDK
    public IAudienceRoom createAudienceRoom(@NonNull AudienceRoomConfig audienceRoomConfig) {
        this.iAegisLogApi.i(TAG, 1, "createAudienceRoom config:" + audienceRoomConfig);
        audienceRoomConfig.appId = getAppId();
        LiveAudienceTPPlayerRoomImpl liveAudienceTPPlayerRoomImpl = new LiveAudienceTPPlayerRoomImpl(audienceRoomConfig);
        liveAudienceTPPlayerRoomImpl.init(this);
        return liveAudienceTPPlayerRoomImpl;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDK
    public IQQLiveModulePendant createPendantModule() {
        QQLiveModulePendant qQLiveModulePendant = new QQLiveModulePendant();
        qQLiveModulePendant.init(this);
        return qQLiveModulePendant;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDK
    public void destroy() {
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
        IQQLiveGiftEntranceService iQQLiveGiftEntranceService = this.giftEntranceService;
        if (iQQLiveGiftEntranceService != null) {
            iQQLiveGiftEntranceService.destroy();
        }
        w32.a aVar = this.protocolsReport;
        if (aVar != null) {
            aVar.destroy();
        }
        AppInterface a16 = d.a();
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
        s32.a.c().e();
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDK
    public String getAppId() {
        return this.appId;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDK
    public AppRuntime getAppRuntime() {
        return d.a();
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDK
    public IQQLiveConfigModule getConfigModule() {
        return this.configModule;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDK
    public QQLiveCurRoomInfo getCurRoomInfo() {
        return u32.a.c(this.appId);
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDK
    public IDataReportModule getDataReportModule() {
        if (!isDestroyed() && this.dataReportModule == null) {
            BaseDataReportModule baseDataReportModule = new BaseDataReportModule();
            this.dataReportModule = baseDataReportModule;
            baseDataReportModule.init(this);
        }
        return this.dataReportModule;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDK
    public IQQLiveModule getExtModule(String str) {
        IQQLiveModule iQQLiveModule = this.extModuleMap.get(str);
        if (!isDestroyed() && iQQLiveModule == null) {
            if (TextUtils.equals("sso_module", str)) {
                k kVar = new k();
                this.ssoModule = kVar;
                registerExtModule("sso_module", kVar, true);
                return this.ssoModule;
            }
            if (TextUtils.equals("roomPush", str)) {
                e eVar = new e();
                this.msgPushModule = eVar;
                registerExtModule("roomPush", eVar, true);
                return this.msgPushModule;
            }
        }
        return iQQLiveModule;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDK
    public List<QQLiveSwitchRoom> getFetchRoomList() {
        return this.switchRoomList;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDK
    public IQQLiveFollowMsgService getFollowMsgService() {
        if (!isDestroyed() && this.followMsgService == null) {
            QQLiveFollowMsgServiceImpl qQLiveFollowMsgServiceImpl = new QQLiveFollowMsgServiceImpl();
            this.followMsgService = qQLiveFollowMsgServiceImpl;
            qQLiveFollowMsgServiceImpl.init(this);
        }
        return this.followMsgService;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDK
    public IQQLiveGiftEntranceService getGiftEntranceService() {
        if (!isDestroyed() && this.giftEntranceService == null) {
            QQLiveGiftEntranceServiceImpl qQLiveGiftEntranceServiceImpl = new QQLiveGiftEntranceServiceImpl();
            this.giftEntranceService = qQLiveGiftEntranceServiceImpl;
            qQLiveGiftEntranceServiceImpl.init(this);
        }
        return this.giftEntranceService;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDK
    public IQQLiveModuleKickOut getKickOutModule() {
        if (!isDestroyed() && this.kickOutModule == null) {
            QQLiveKickOutImpl qQLiveKickOutImpl = new QQLiveKickOutImpl();
            this.kickOutModule = qQLiveKickOutImpl;
            qQLiveKickOutImpl.init(this);
        }
        return this.kickOutModule;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDK
    public IQQLiveModuleLogin getLoginModule() {
        if (!isDestroyed() && this.loginModule == null) {
            initLoginModule();
        }
        return this.loginModule;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDK
    public w32.a getProtocolsReport() {
        initProtocolReport();
        return this.protocolsReport;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDK
    public IQQLiveSsoProxyModule getProxySsoService() {
        getLoginModule();
        if (!isDestroyed() && this.ssoProxyModule == null) {
            QQLiveSsoProxyModuleImpl qQLiveSsoProxyModuleImpl = new QQLiveSsoProxyModuleImpl();
            this.ssoProxyModule = qQLiveSsoProxyModuleImpl;
            qQLiveSsoProxyModuleImpl.init(this);
        }
        return this.ssoProxyModule;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDK
    public IRoomGetInfoModule getRoomGetInfoModule() {
        if (!isDestroyed() && this.roomGetInfoModule == null) {
            RoomGetInfoModule roomGetInfoModule = new RoomGetInfoModule();
            this.roomGetInfoModule = roomGetInfoModule;
            roomGetInfoModule.init(this);
        }
        return this.roomGetInfoModule;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDK
    public QQLiveSDKConfig getSDKConfig() {
        return this.sdkConfig;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDK
    public IQQLiveUserCard getUserCardModule() {
        if (!isDestroyed() && this.userCardModule == null) {
            QQLiveUserCardImpl qQLiveUserCardImpl = new QQLiveUserCardImpl();
            this.userCardModule = qQLiveUserCardImpl;
            qQLiveUserCardImpl.init(this);
        }
        return this.userCardModule;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDK
    public void init(AppRuntime appRuntime, QQLiveSDKConfig qQLiveSDKConfig) {
        this.iAegisLogApi.i(TAG, "[init]");
        if (this.isInited) {
            return;
        }
        this.sdkConfig = qQLiveSDKConfig;
        this.configModule.init(this, qQLiveSDKConfig.appConfig);
        this.isInited = true;
        initProtocolReport();
        QQLiveContext.Companion companion = QQLiveContext.INSTANCE;
        if (companion.b(this.appId) == null) {
            this.iAegisLogApi.i(TAG, "[init] no current context");
            companion.d(companion.a(new BuildParams(this.appId, null, null)));
        }
        this.iAegisLogApi.i(TAG, 1, "sdk init done");
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDK
    public boolean isDestroyed() {
        return this.isDestroyed;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDK
    public boolean isInited() {
        return this.isInited;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDK
    public void recordCurRoomInfo(@NonNull QQLiveCurRoomInfo qQLiveCurRoomInfo) {
        u32.a.g(this.appId, qQLiveCurRoomInfo);
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDK
    public void recordFetchRoomList(@NonNull List<QQLiveSwitchRoom> list) {
        synchronized (this.switchRoomListSyncObject) {
            this.switchRoomList = list;
        }
        Iterator<s22.b> it = this.fetchRoomListCallbackSet.iterator();
        while (it.hasNext()) {
            it.next().onRoomListUpdate(list);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDK
    public void registerExtModule(String str, IQQLiveModule iQQLiveModule, boolean z16) {
        if (!TextUtils.isEmpty(str) && iQQLiveModule != null) {
            this.extModuleMap.put(str, iQQLiveModule);
            if (z16) {
                iQQLiveModule.init(this);
            }
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDK
    public void registerFetchRoomListUpdateCallback(s22.b bVar) {
        this.fetchRoomListCallbackSet.add(bVar);
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDK
    public void removeCurRoomRecord(@NonNull long j3) {
        u32.a.h(this.appId, j3);
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDK
    public void unRegisterFetchRoomListUpdateCallback(s22.b bVar) {
        this.fetchRoomListCallbackSet.remove(bVar);
    }
}
