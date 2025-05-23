package com.tencent.mobileqq.qqlive.sso;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.api.impl.QQGameReportServiceImpl;
import com.tencent.mobileqq.app.BaseBusinessHandler;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.callback.sso.IBufferHeaderHandler;
import com.tencent.mobileqq.qqlive.report.tianjige.b;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.common.api.IQQLiveHEVCAbility;
import com.tencent.qqlive.common.ratelimit.RateLimitConfig;
import com.tencent.xweb.FileReaderX5;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveBusinessHandler extends BusinessHandler {
    static IPatchRedirector $redirector_ = null;
    private static final int BUSINESS_ERROR = 4;
    private static final String CMD_LOGIN = "trpc.qlive.login_svr.Login.Login";
    protected static final String[] HandlerId;
    private static final int MSF_ERROR = 2;
    public static final int PLAT_ID = 109;
    private static final int PROXY_ERROR = 3;
    public static final String QQ_LIVE_HANDLER;
    private static final String QQ_LIVE_MSG_SEND_PB_REPORT = "QQ_LIVE_MSG_SEND_PB_REPORT";
    private static final String TAG = "QQLiveBusinessHandler";
    private static Handler bgHandler;
    private ConcurrentHashMap<String, b> bizCommonHeader;
    private IBufferHeaderHandler headerHandler;
    private boolean isCheckSsoReqUid;
    private boolean isLimitReqFuncOpen;
    private boolean isOpenSsoReport;
    private IAegisLogApi mAegisLog;
    private final HashSet<String> mCheckUidSsoReqSet;
    private final HashSet<String> mHighFrequencySsoCmdSet;
    private com.tencent.mobileqq.qqlive.reqlimit.b mSsoRateLimitController;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61319);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        bgHandler = new Handler(ThreadManagerV2.getSubThreadLooper());
        QQ_LIVE_HANDLER = QQLiveBusinessHandler.class.getName();
        HandlerId = new String[]{QQLiveBusinessHandler.class.getName(), "com.tencent.mobileqq.qqgift.sso.QQGiftBusinessHandler"};
    }

    protected QQLiveBusinessHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.mAegisLog = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        this.bizCommonHeader = new ConcurrentHashMap<>();
        this.mHighFrequencySsoCmdSet = new HashSet<>(3);
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
        this.isLimitReqFuncOpen = VasToggle.isEnable("qqlive_sso_rate_limit", false);
        this.mAegisLog.i(TAG, "isLimitReqFuncOpen=" + this.isLimitReqFuncOpen);
        if (!this.isLimitReqFuncOpen) {
            return;
        }
        RateLimitConfig rateLimitConfig = (RateLimitConfig) VasToggle.getBean("qqlive_sso_rate_limit", RateLimitConfig.class, null);
        this.mAegisLog.i(TAG, "QQLiveBusinessHandler config=" + rateLimitConfig);
        if (rateLimitConfig != null && !TextUtils.isEmpty(rateLimitConfig.toString())) {
            this.mSsoRateLimitController = new com.tencent.mobileqq.qqlive.reqlimit.b(rateLimitConfig);
        }
    }

    private void initSsoReportConfig() {
        List list;
        this.isOpenSsoReport = VasToggle.isEnable(VasToggle.VAS_QQLIVE_HIGH_SSO_REPORT, false);
        this.mAegisLog.i(TAG, "isOpenSsoReport=" + this.isOpenSsoReport);
        if (this.isOpenSsoReport && (list = (List) VasToggle.getBean(VasToggle.VAS_QQLIVE_HIGH_SSO_REPORT, List.class, null)) != null && !list.isEmpty()) {
            this.mHighFrequencySsoCmdSet.addAll(list);
            this.mAegisLog.i(TAG, "mHighFrequencySsoCmdSet=" + Arrays.toString(this.mHighFrequencySsoCmdSet.toArray()));
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

    private void liveDispatchMessage(int i3, boolean z16, Object obj, BusinessObserver businessObserver, Handler handler) {
        handler.post(new Runnable(businessObserver, i3, z16, obj) { // from class: com.tencent.mobileqq.qqlive.sso.QQLiveBusinessHandler.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ BusinessObserver f273185d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f273186e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f273187f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ Object f273188h;

            {
                this.f273185d = businessObserver;
                this.f273186e = i3;
                this.f273187f = z16;
                this.f273188h = obj;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, QQLiveBusinessHandler.this, businessObserver, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    this.f273185d.onUpdate(this.f273186e, this.f273187f, this.f273188h);
                } catch (Exception e16) {
                    QQLiveBusinessHandler.this.mAegisLog.e("CatchException", 1, "onUpdate fail " + e16);
                }
            }
        });
    }

    private void liveNotifyUI(ToServiceMsg toServiceMsg, int i3, boolean z16, Object obj) {
        BusinessObserver remove;
        Handler uIHandlerV2;
        Bundle bundle = toServiceMsg.extraData;
        String str = BaseBusinessHandler.SEQ_KEY;
        if (bundle.containsKey(str)) {
            long j3 = toServiceMsg.extraData.getLong(str);
            synchronized (this.uiObserverMap) {
                remove = this.uiObserverMap.remove(Long.valueOf(j3));
                uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            }
            if (remove == null) {
                synchronized (this.bgObserverMap) {
                    remove = this.bgObserverMap.remove(Long.valueOf(j3));
                    uIHandlerV2 = bgHandler;
                }
            }
            BusinessObserver businessObserver = remove;
            Handler handler = uIHandlerV2;
            if (businessObserver != null) {
                liveDispatchMessage(i3, z16, obj, businessObserver, handler);
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
        b bVar = this.bizCommonHeader.get(str);
        dr4.b bVar2 = new dr4.b();
        if (bVar == null) {
            this.mAegisLog.a(TAG, 1, "[packSendBuffer]_biz_is_null! appId:" + str + ", method:" + str3 + " hashCode:" + hashCode());
        } else {
            if ("trpc.qlive.room_msg_read_proxy_svr.RoomMsgReadProxySvr".equals(str2) && "PullMsgProxy".equals(str3)) {
                bVar2.f394694d = bVar.b();
            } else {
                bVar2.f394694d = bVar.getPlatform();
            }
            bVar2.f394695e = bVar.getVersion();
            bVar2.f394696f = bArr;
            bVar2.f394697g = bVar.getVersionCode();
            bVar2.f394698h = bVar.getStreamType();
            bVar2.f394706p = bVar.getClientId().getBytes();
            bVar2.C = com.tencent.mobileqq.qqlive.utils.h.a();
            if (bVar.d().booleanValue()) {
                bVar2.f394704n = 2;
            } else {
                bVar2.f394704n = 0;
            }
            bVar2.f394701k = bVar.getLoginType();
            bVar2.f394707q = 37;
            bVar2.f394691a = bVar.getUid();
            bVar2.f394692b = bVar.getTinyId();
            if (!TextUtils.isEmpty(bVar.c())) {
                bVar2.f394693c = bVar.c();
            } else {
                bVar2.f394693c = "";
            }
            bVar2.f394700j = bVar.a();
            String openId = bVar.getOpenId();
            bVar2.f394699i = openId;
            if (openId == null) {
                bVar2.f394699i = "";
            }
            bVar2.f394710t = "0.0.1-snapshot";
            String str4 = AppSetting.f99551k;
            if (TextUtils.isEmpty(str4)) {
                str4 = "";
            }
            bVar2.f394711u = str4;
            bVar2.f394712v = str2;
            bVar2.f394713w = str3;
            bVar2.f394714z = 109;
            bVar2.A = 0;
            bVar2.f394703m = "";
            bVar2.f394708r = "";
            bVar2.f394705o = new dr4.a[0];
            bVar2.f394709s = new dr4.d[0];
            bVar2.E = ((IQQLiveHEVCAbility) QRoute.api(IQQLiveHEVCAbility.class)).getDeviceInfo();
        }
        return MessageNano.toByteArray(bVar2);
    }

    private void performSendQQLiveReq(String str, ToServiceMsg toServiceMsg, String str2) {
        AppInterface a16 = com.tencent.mobileqq.qqlive.utils.g.a();
        if (a16 == null) {
            this.mAegisLog.e(TAG, 1, "[sendQQLiveReq] appInterface is null");
        } else {
            toServiceMsg.extraData.putString("moduleId", com.tencent.mobileqq.qqlive.utils.g.d());
            a16.sendToService(toServiceMsg);
        }
        if (QLog.isColorLevel()) {
            this.mAegisLog.i(TAG, 2, "[Live SSO] onSend cmd:[" + str2 + "]");
        }
    }

    private void realSendQQLiveReq(final String str, final ToServiceMsg toServiceMsg, final String str2) {
        com.tencent.mobileqq.qqlive.reqlimit.b bVar;
        if (this.isLimitReqFuncOpen && (bVar = this.mSsoRateLimitController) != null) {
            bVar.b(str2, new com.tencent.qqlive.common.ratelimit.a() { // from class: com.tencent.mobileqq.qqlive.sso.e
                @Override // com.tencent.qqlive.common.ratelimit.a
                public final void a(Boolean bool) {
                    QQLiveBusinessHandler.this.lambda$realSendQQLiveReq$1(str, toServiceMsg, str2, bool);
                }
            });
        } else {
            performSendQQLiveReq(str, toServiceMsg, str2);
        }
    }

    private void reportSsoRequestResult(String str, long j3, String str2, FromServiceMsg fromServiceMsg, h hVar, String str3) {
        int i3;
        String str4;
        if (!this.isOpenSsoReport || this.mHighFrequencySsoCmdSet.contains(str2)) {
            return;
        }
        IQQLiveSDK sDKImpl = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(str);
        if (sDKImpl != null && sDKImpl.isInited()) {
            b bVar = this.bizCommonHeader.get(str);
            if (bVar == null) {
                this.mAegisLog.e(TAG, 1, "reportSsoRequestTime get IQQLiveSSOCommonHeader is null");
                return;
            }
            boolean isSuccess = fromServiceMsg.isSuccess();
            ft3.c a16 = sDKImpl.getDataReportModule().newReportTask().a("sso_cost_time");
            a16.addKeyValue("appid", str);
            int resultCode = fromServiceMsg.getResultCode();
            if (!isSuccess) {
                resultCode = hVar.h().getBusinessFailCode();
                str4 = hVar.h().getBusinessFailMsg();
                i3 = 2;
            } else if (hVar.g() != 0) {
                resultCode = hVar.g();
                str4 = hVar.f();
                i3 = 3;
            } else if (hVar.b() != 0) {
                resultCode = hVar.b();
                str4 = hVar.c();
                i3 = 4;
            } else {
                i3 = 0;
                str4 = "";
            }
            a16.addKeyValue("errorcode", resultCode);
            a16.addKeyValue("errormsg", str4);
            a16.addKeyValue(QQGameReportServiceImpl.ATTA_KEY_ERROR_TYPE, i3);
            a16.addKeyValue("trace_info", str3);
            a16.addKeyValue("uid", bVar.getUid());
            a16.addKeyValue("version", bVar.getVersion());
            if (!TextUtils.isEmpty(str2)) {
                a16.addKeyValue("service", str2);
            }
            a16.addKeyValue("costtime", j3);
            a16.send();
            return;
        }
        this.mAegisLog.e(TAG, 1, "reportSsoRequestTime get sdk null");
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
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
        h hVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
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
                h hVar2 = new h(fromServiceMsg, str5, str6);
                str = c16;
                str2 = TAG;
                str4 = "], appId:";
                i3 = intValue;
                hVar = hVar2;
                str3 = ", trulyCmd:[";
            } else {
                str = c16;
                str2 = TAG;
                i3 = intValue;
                str3 = ", trulyCmd:[";
                str4 = "], appId:";
                hVar = new h(this.headerHandler, fromServiceMsg, (byte[]) obj, str5, str6);
            }
            h hVar3 = hVar;
            reportSsoRequestResult(str5, currentTimeMillis, str6, fromServiceMsg, hVar3, str);
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
                    liveNotifyUI(toServiceMsg, i3, isSuccess, new h(fromServiceMsg, str5, str6));
                    return;
                }
                liveNotifyUI(toServiceMsg, i3, isSuccess, new h(this.headerHandler, fromServiceMsg, (byte[]) obj, str5, str6));
                return;
            }
            String str7 = str2;
            String str8 = str4;
            int i16 = i3;
            if (obj == null) {
                this.mAegisLog.e(str7, 1, "[Live SSO] onReceive data is null, cmd:" + serviceCmd + str3 + str6 + str8 + str5);
            }
            notifyUI(toServiceMsg, i16, isSuccess, hVar3);
            return;
        }
        this.mAegisLog.e(TAG, 1, "[Live SSO] onReceive, cmd:" + serviceCmd + ", trulyCmd:[" + str6 + "], appId:" + str5 + " has destroyed!");
    }

    public void registerCommonHeaderCallback(String str, b bVar, IBufferHeaderHandler iBufferHeaderHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, bVar, iBufferHeaderHandler);
        } else if (!TextUtils.isEmpty(str) && bVar != null) {
            this.headerHandler = iBufferHeaderHandler;
            this.bizCommonHeader.put(str, bVar);
        }
    }

    public void removeCommonHeaderCallback(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.bizCommonHeader.remove(str);
        }
    }

    public void sendQQLiveReq(final String str, final String str2, final String str3, byte[] bArr, int i3, int i16, boolean z16, f fVar) {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, str3, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), fVar);
            return;
        }
        fVar.setAppId(str);
        final ToServiceMsg createToServiceMsg = super.createToServiceMsg("trpc.qlive.qlive_proxy_svr.TrpcProxy.*", fVar);
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
        if (!com.tencent.mobileqq.service.a.c("trpc.qlive.qlive_proxy_svr.TrpcProxy.*")) {
            com.tencent.mobileqq.service.a.g("trpc.qlive.qlive_proxy_svr.TrpcProxy.*", HandlerId);
        }
        final IQQLiveSDK sDKImpl = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(str);
        if (sDKImpl != null) {
            if (sDKImpl.getProtocolsReport().isInit()) {
                sDKImpl.getProtocolsReport().a(createToServiceMsg, str2, str3);
            } else {
                sDKImpl.getProtocolsReport().i(new b.a() { // from class: com.tencent.mobileqq.qqlive.sso.d
                    @Override // com.tencent.mobileqq.qqlive.report.tianjige.b.a
                    public final void a(boolean z17) {
                        QQLiveBusinessHandler.this.lambda$sendQQLiveReq$0(sDKImpl, createToServiceMsg, str2, str3, str, str4, z17);
                    }
                });
                return;
            }
        }
        if (this.isCheckSsoReqUid && !CMD_LOGIN.equals(str4) && this.mCheckUidSsoReqSet.contains(str4) && ((bVar = this.bizCommonHeader.get(str)) == null || bVar.getUid() == 0)) {
            this.mAegisLog.e(TAG, "sendQQLiveReq biz =" + bVar + ",biz.getUid() == 0");
            FromServiceMsg fromServiceMsg = new FromServiceMsg();
            fromServiceMsg.setBusinessFail(FileReaderX5.ERR_CODE_INIT_FAILED, "\u8bf7\u6c42uid\u4e3a0");
            liveNotifyUI(createToServiceMsg, i16, false, new h(fromServiceMsg, str, str4));
            return;
        }
        realSendQQLiveReq(str, createToServiceMsg, str4);
    }
}
