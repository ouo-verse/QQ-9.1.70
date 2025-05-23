package com.tencent.mobileqq.icgame.sso;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.common.api.IQQLiveHEVCAbility;
import com.tencent.icgame.common.ratelimit.RateLimitConfig;
import com.tencent.mobileqq.app.BaseBusinessHandler;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.IQQLiveSDKManager;
import com.tencent.mobileqq.icgame.api.config.ICGameQMCCConfigKeysKt;
import com.tencent.mobileqq.icgame.api.config.IICGameConfigApi;
import com.tencent.mobileqq.qqlive.callback.sso.IBufferHeaderHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import w32.a;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QQLiveBusinessHandler extends BusinessHandler {
    protected static final String[] HandlerId = {QQLiveBusinessHandler.class.getName(), "com.tencent.mobileqq.qqgift.sso.QQGiftBusinessHandler"};
    public static final int PLAT_ID = 109;
    public static final String QQ_LIVE_HANDLER = "com.tencent.mobileqq.icgame.sso.QQLiveBusinessHandler";
    private static final String TAG = "ICGameBusinessHandler";
    private ConcurrentHashMap<String, com.tencent.mobileqq.qqlive.sso.b> bizCommonHeader;
    private IBufferHeaderHandler headerHandler;
    private boolean isLimitReqFuncOpen;
    private boolean isOpenSsoReport;
    private IAegisLogApi mAegisLog;
    private final HashSet<String> mCheckUidSsoReqSet;
    private final HashSet<String> mSsoCmdReportBlackSet;
    private x32.b mSsoRateLimitController;

    protected QQLiveBusinessHandler(AppInterface appInterface) {
        super(appInterface);
        this.mAegisLog = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        this.bizCommonHeader = new ConcurrentHashMap<>();
        this.mSsoCmdReportBlackSet = new HashSet<>(3);
        this.mCheckUidSsoReqSet = new HashSet<>(3);
        initSsoReportConfig();
        initSsoLimitConfig();
        initReqUidCheckConfig();
    }

    private void initReqUidCheckConfig() {
        this.mAegisLog.i(TAG, "initReqUidCheckConfig isCheckSsoReqUid=true");
        this.mCheckUidSsoReqSet.add("trpc.qlive.room_dating_stage.RoomDatingStage.GetStageInfo");
        this.mCheckUidSsoReqSet.add("trpc.qlive.rank_list_svr.RankListSvr.RankListForNative");
        this.mAegisLog.i(TAG, "initReqUidCheckConfig mCheckUidSsoReqSet=" + Arrays.toString(this.mCheckUidSsoReqSet.toArray()));
    }

    private void initSsoLimitConfig() {
        RateLimitConfig rateLimitConfig = (RateLimitConfig) ((IICGameConfigApi) QRoute.api(IICGameConfigApi.class)).getConfigBean(ICGameQMCCConfigKeysKt.KEY_ICGAME_LIVE_SDK_SSO_LIMIT_CONFIG, RateLimitConfig.class, new RateLimitConfig());
        this.isLimitReqFuncOpen = rateLimitConfig.getEnable();
        this.mAegisLog.i(TAG, "isLimitReqFuncOpen=" + this.isLimitReqFuncOpen);
        if (!this.isLimitReqFuncOpen) {
            return;
        }
        this.mAegisLog.i(TAG, "QQLiveBusinessHandler config=" + rateLimitConfig);
        this.mSsoRateLimitController = new x32.b(rateLimitConfig);
    }

    private void initSsoReportConfig() {
        SsoCmdReportConfig ssoCmdReportConfig = (SsoCmdReportConfig) ((IICGameConfigApi) QRoute.api(IICGameConfigApi.class)).getConfigBean(ICGameQMCCConfigKeysKt.KEY_ICGAME_LIVE_SDK_SSO_CMD_REPORT_CONFIG, SsoCmdReportConfig.class, new SsoCmdReportConfig());
        this.isOpenSsoReport = ssoCmdReportConfig.getEnable();
        this.mAegisLog.i(TAG, "isOpenSsoReport=" + this.isOpenSsoReport);
        if (!this.isOpenSsoReport) {
            return;
        }
        this.mSsoCmdReportBlackSet.addAll(ssoCmdReportConfig.a());
        this.mAegisLog.i(TAG, "mSsoCmdReportBlackSet=" + Arrays.toString(this.mSsoCmdReportBlackSet.toArray()));
    }

    private static /* synthetic */ void lambda$liveDispatchMessage$2(Exception exc) {
        throw new RuntimeException(exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$liveDispatchMessage$3(BusinessObserver businessObserver, int i3, boolean z16, Object obj) {
        try {
            businessObserver.onUpdate(i3, z16, obj);
        } catch (Exception e16) {
            this.mAegisLog.e("CatchException", 1, "onUpdate fail " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$realSendQQLiveReq$1(String str, ToServiceMsg toServiceMsg, String str2, Boolean bool) {
        if (bool.booleanValue()) {
            return;
        }
        performSendQQLiveReq(str, toServiceMsg, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendQQLiveReq$0(IQQLiveSDK iQQLiveSDK, ToServiceMsg toServiceMsg, String str, String str2, String str3, String str4, boolean z16) {
        if (z16) {
            iQQLiveSDK.getProtocolsReport().a(toServiceMsg, str, str2);
        }
        realSendQQLiveReq(str3, toServiceMsg, str4);
    }

    private void liveDispatchMessage(final int i3, final boolean z16, final Object obj, final BusinessObserver businessObserver, boolean z17) {
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.icgame.sso.d
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveBusinessHandler.this.lambda$liveDispatchMessage$3(businessObserver, i3, z16, obj);
            }
        };
        if (z17) {
            ThreadManagerV2.getUIHandlerV2().post(runnable);
        } else {
            ThreadManagerV2.excute(runnable, 16, null, false);
        }
    }

    private void liveNotifyUI(ToServiceMsg toServiceMsg, int i3, boolean z16, Object obj) {
        BusinessObserver remove;
        boolean z17;
        Bundle bundle = toServiceMsg.extraData;
        String str = BaseBusinessHandler.SEQ_KEY;
        if (bundle.containsKey(str)) {
            long j3 = toServiceMsg.extraData.getLong(str);
            synchronized (this.uiObserverMap) {
                remove = this.uiObserverMap.remove(Long.valueOf(j3));
            }
            if (remove == null) {
                synchronized (this.bgObserverMap) {
                    remove = this.bgObserverMap.remove(Long.valueOf(j3));
                }
                z17 = false;
            } else {
                z17 = true;
            }
            boolean z18 = z17;
            BusinessObserver businessObserver = remove;
            if (businessObserver != null) {
                liveDispatchMessage(i3, z16, obj, businessObserver, z18);
                return;
            }
        }
        notifyUI(i3, z16, obj);
    }

    private byte[] packSendBuffer(String str, byte[] bArr, String str2, String str3) {
        IBufferHeaderHandler iBufferHeaderHandler = this.headerHandler;
        if (iBufferHeaderHandler != null) {
            return iBufferHeaderHandler.packReqWithHeader(bArr);
        }
        com.tencent.mobileqq.qqlive.sso.b bVar = this.bizCommonHeader.get(str);
        iz0.b bVar2 = new iz0.b();
        if (bVar == null) {
            this.mAegisLog.a(TAG, 1, "[packSendBuffer]_biz_is_null! appId:" + str + ", method:" + str3 + " hashCode:" + hashCode());
        } else {
            if ("trpc.icggame.room_msg_read_proxy_svr.RoomMsgReadProxySvr".equals(str2) && "PullMsgProxy".equals(str3)) {
                bVar2.f408997d = bVar.b();
            } else {
                bVar2.f408997d = bVar.getPlatform();
            }
            bVar2.f408998e = bVar.getVersion();
            bVar2.f408999f = bArr;
            bVar2.f409000g = bVar.getVersionCode();
            bVar2.f409001h = bVar.getStreamType();
            bVar2.f409009p = bVar.getClientId().getBytes();
            bVar2.C = t42.f.a();
            if (bVar.d().booleanValue()) {
                bVar2.f409007n = 2;
            } else {
                bVar2.f409007n = 0;
            }
            bVar2.f409004k = bVar.getLoginType();
            bVar2.f409010q = 37;
            bVar2.f408994a = bVar.getUid();
            bVar2.f408995b = bVar.getTinyId();
            if (!TextUtils.isEmpty(bVar.c())) {
                bVar2.f408996c = bVar.c();
            } else {
                bVar2.f408996c = "";
            }
            bVar2.f409003j = bVar.a();
            String openId = bVar.getOpenId();
            bVar2.f409002i = openId;
            if (openId == null) {
                bVar2.f409002i = "";
            }
            bVar2.f409013t = "0.0.1-snapshot";
            String str4 = AppSetting.f99551k;
            if (TextUtils.isEmpty(str4)) {
                str4 = "";
            }
            bVar2.f409014u = str4;
            bVar2.f409015v = str2;
            bVar2.f409016w = str3;
            bVar2.f409017z = 109;
            bVar2.A = 0;
            bVar2.f409006m = "";
            bVar2.f409011r = "";
            bVar2.f409008o = new iz0.a[0];
            bVar2.f409012s = new iz0.d[0];
            bVar2.E = ((IQQLiveHEVCAbility) QRoute.api(IQQLiveHEVCAbility.class)).getDeviceInfo();
        }
        return MessageNano.toByteArray(bVar2);
    }

    private void performSendQQLiveReq(String str, ToServiceMsg toServiceMsg, String str2) {
        AppInterface a16 = t42.d.a();
        if (a16 == null) {
            this.mAegisLog.e(TAG, 1, "[sendQQLiveReq] appInterface is null");
        } else {
            toServiceMsg.extraData.putString("moduleId", t42.d.c());
            a16.sendToService(toServiceMsg);
        }
        if (QLog.isColorLevel()) {
            this.mAegisLog.i(TAG, 2, "[Live SSO] onSend cmd:[" + str2 + "]");
        }
    }

    private void realSendQQLiveReq(final String str, final ToServiceMsg toServiceMsg, final String str2) {
        x32.b bVar;
        if (this.isLimitReqFuncOpen && (bVar = this.mSsoRateLimitController) != null) {
            bVar.b(str2, new com.tencent.icgame.common.ratelimit.a() { // from class: com.tencent.mobileqq.icgame.sso.f
                @Override // com.tencent.icgame.common.ratelimit.a
                public final void a(Boolean bool) {
                    QQLiveBusinessHandler.this.lambda$realSendQQLiveReq$1(str, toServiceMsg, str2, bool);
                }
            });
        } else {
            performSendQQLiveReq(str, toServiceMsg, str2);
        }
    }

    private void reportSsoRequestResult(String str, long j3, String str2, FromServiceMsg fromServiceMsg, i iVar, String str3) {
        int i3;
        String str4;
        String c16;
        int i16;
        if (!this.isOpenSsoReport || this.mSsoCmdReportBlackSet.contains(str2)) {
            return;
        }
        IQQLiveSDK sDKImpl = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(str);
        if (sDKImpl != null && sDKImpl.isInited()) {
            com.tencent.mobileqq.qqlive.sso.b bVar = this.bizCommonHeader.get(str);
            if (bVar == null) {
                this.mAegisLog.e(TAG, 1, "reportSsoRequestTime get IQQLiveSSOCommonHeader is null");
                return;
            }
            int resultCode = fromServiceMsg.getResultCode();
            if (!fromServiceMsg.isSuccess()) {
                resultCode = iVar.h().getBusinessFailCode();
                c16 = iVar.h().getBusinessFailMsg();
                i16 = 2;
            } else if (iVar.g() != 0) {
                resultCode = iVar.g();
                c16 = iVar.f();
                i16 = 3;
            } else if (iVar.b() != 0) {
                resultCode = iVar.b();
                c16 = iVar.c();
                i16 = 4;
            } else {
                i3 = 0;
                str4 = "";
                b.a(str, j3, str2, resultCode, str4, i3, str3, bVar.getUid(), bVar.getVersion());
                return;
            }
            str4 = c16;
            i3 = i16;
            b.a(str, j3, str2, resultCode, str4, i3, str3, bVar.getUid(), bVar.getVersion());
            return;
        }
        this.mAegisLog.e(TAG, 1, "reportSsoRequestTime get sdk null");
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return null;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        super.onDestroy();
        this.uiObserverMap.clear();
        this.bgObserverMap.clear();
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        String str2;
        int i3;
        String str3;
        String str4;
        i iVar;
        String serviceCmd = fromServiceMsg.getServiceCmd();
        int intValue = ((Integer) toServiceMsg.getAttribute("live_notify_type", 0)).intValue();
        String str5 = (String) toServiceMsg.getAttribute("live_app_id", "");
        String str6 = (String) toServiceMsg.getAttribute("live_cmd", "");
        if (TextUtils.isEmpty(str6)) {
            return;
        }
        long longValue = ((Long) toServiceMsg.getAttribute("live_start_time", 0L)).longValue();
        boolean booleanValue = ((Boolean) toServiceMsg.getAttribute("live_self_notify", Boolean.FALSE)).booleanValue();
        long currentTimeMillis = System.currentTimeMillis() - longValue;
        IQQLiveSDK sDKImpl = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(str5);
        if (sDKImpl != null && sDKImpl.isInited()) {
            String c16 = sDKImpl.getProtocolsReport().c(toServiceMsg, fromServiceMsg);
            if (obj == null) {
                i iVar2 = new i(fromServiceMsg, str5, str6);
                str = c16;
                str2 = TAG;
                str4 = "], appId:";
                i3 = intValue;
                iVar = iVar2;
                str3 = ", trulyCmd:[";
            } else {
                str = c16;
                str2 = TAG;
                i3 = intValue;
                str3 = ", trulyCmd:[";
                str4 = "], appId:";
                iVar = new i(this.headerHandler, fromServiceMsg, (byte[]) obj, str5, str6);
            }
            i iVar3 = iVar;
            reportSsoRequestResult(str5, currentTimeMillis, str6, fromServiceMsg, iVar3, str);
            if (msgCmdFilter(serviceCmd)) {
                this.mAegisLog.e(str2, 1, "[Live SSO] onReceive msgCmdFilter, cmd:" + serviceCmd + str3 + str6 + str4 + str5);
                return;
            }
            boolean isSuccess = fromServiceMsg.isSuccess();
            if (isSuccess) {
                if (QLog.isColorLevel()) {
                    this.mAegisLog.i(str2, 2, "[Live SSO] onReceive cmd[" + str6 + "] success, appId:" + str5 + "traceInfo:" + str);
                }
            } else {
                int businessFailCode = fromServiceMsg.getBusinessFailCode();
                String businessFailMsg = fromServiceMsg.getBusinessFailMsg();
                this.mAegisLog.e(str2, 1, "[Live SSO] onReceive cmd[" + str6 + "] fail, appId:" + str5 + ", failCode:" + businessFailCode + ", failMsg:" + businessFailMsg + "traceInfo:" + str);
            }
            if (booleanValue) {
                if (obj == null) {
                    this.mAegisLog.e(str2, 1, "[Live SSO] onReceive data is null, cmd:" + serviceCmd + str3 + str6 + str4 + str5);
                    liveNotifyUI(toServiceMsg, i3, isSuccess, new i(fromServiceMsg, str5, str6));
                    return;
                }
                liveNotifyUI(toServiceMsg, i3, isSuccess, new i(this.headerHandler, fromServiceMsg, (byte[]) obj, str5, str6));
                return;
            }
            String str7 = str2;
            String str8 = str4;
            int i16 = i3;
            if (obj == null) {
                this.mAegisLog.e(str7, 1, "[Live SSO] onReceive data is null, cmd:" + serviceCmd + str3 + str6 + str8 + str5);
            }
            notifyUI(toServiceMsg, i16, isSuccess, iVar3);
            return;
        }
        this.mAegisLog.e(TAG, 1, "[Live SSO] onReceive, cmd:" + serviceCmd + ", trulyCmd:[" + str6 + "], appId:" + str5 + " has destroyed!");
    }

    public void registerCommonHeaderCallback(String str, com.tencent.mobileqq.qqlive.sso.b bVar, IBufferHeaderHandler iBufferHeaderHandler) {
        if (!TextUtils.isEmpty(str) && bVar != null) {
            this.headerHandler = iBufferHeaderHandler;
            this.bizCommonHeader.put(str, bVar);
        }
    }

    public void removeCommonHeaderCallback(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.bizCommonHeader.remove(str);
    }

    public void sendQQLiveReq(final String str, final String str2, final String str3, byte[] bArr, int i3, int i16, boolean z16, g gVar) {
        gVar.setAppId(str);
        final ToServiceMsg createToServiceMsg = super.createToServiceMsg("trpc.icgame.gateway.gatewayTrpc.Sso*", gVar);
        createToServiceMsg.addAttribute("live_notify_type", Integer.valueOf(i16));
        createToServiceMsg.addAttribute("live_app_id", str);
        createToServiceMsg.addAttribute("live_start_time", Long.valueOf(System.currentTimeMillis()));
        createToServiceMsg.addAttribute("live_self_notify", Boolean.valueOf(z16));
        final String str4 = str2 + "." + str3;
        createToServiceMsg.addAttribute("live_cmd", str4);
        createToServiceMsg.putWupBuffer(packSendBuffer(str, bArr, str2, str3));
        createToServiceMsg.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.TRUE);
        if (i3 > 0) {
            long j3 = i3;
            createToServiceMsg.setTimeout(j3);
            createToServiceMsg.setSendTimeout(j3);
        }
        if (!com.tencent.mobileqq.service.a.c("trpc.icgame.gateway.gatewayTrpc.Sso*")) {
            com.tencent.mobileqq.service.a.g("trpc.icgame.gateway.gatewayTrpc.Sso*", HandlerId);
        }
        final IQQLiveSDK sDKImpl = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(str);
        if (sDKImpl != null) {
            if (sDKImpl.getProtocolsReport().isInit()) {
                sDKImpl.getProtocolsReport().a(createToServiceMsg, str2, str3);
            } else {
                sDKImpl.getProtocolsReport().e(new a.InterfaceC11457a() { // from class: com.tencent.mobileqq.icgame.sso.e
                    @Override // w32.a.InterfaceC11457a
                    public final void a(boolean z17) {
                        QQLiveBusinessHandler.this.lambda$sendQQLiveReq$0(sDKImpl, createToServiceMsg, str2, str3, str, str4, z17);
                    }
                });
                return;
            }
        }
        realSendQQLiveReq(str, createToServiceMsg, str4);
    }
}
