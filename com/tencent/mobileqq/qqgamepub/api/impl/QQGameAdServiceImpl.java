package com.tencent.mobileqq.qqgamepub.api.impl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqgamepub.adapter.QQGamePaAdInfoListenerAdapter;
import com.tencent.mobileqq.qqgamepub.api.IQQGameAdService;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.data.QQGamePaAdInfo$GdtDataReportReq;
import com.tencent.mobileqq.qqgamepub.data.QQGamePaAdInfo$LoginReportReq;
import com.tencent.mobileqq.qqgamepub.data.QQGamePaAdInfo$LoginReportRsp;
import com.tencent.mobileqq.qqgamepub.data.QQGamePaAdInfo$ReportUrl;
import com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import common.config.service.QzoneConfig;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQGameAdServiceImpl implements IQQGameAdService {
    static IPatchRedirector $redirector_ = null;
    private static final String QQ_GAME_AD_TICKET_ID = "807825";
    private static final String SP_KEY_AD_RESP_INTERVAL_TIME = "ad_rsp_interval_time";
    private static final String SP_KEY_AD_RESP_TIME = "ad_rsp_time";
    private static final String TAG = "QQGamePub_QQGameAdServiceImpl";
    public static int mRequestInterval;
    private QQGamePaAdInfoListenerAdapter listenerAdapter;
    private Context mContext;
    private boolean mHasReportLogin;
    private long mLastEmptyRequestTime;
    private long mUin;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends QQGamePaAdInfoListenerAdapter {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGameAdServiceImpl.this);
            }
        }

        @Override // com.tencent.mobileqq.qqgamepub.adapter.QQGamePaAdInfoListenerAdapter, com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public void onTrpcRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, intent, str, Long.valueOf(j3), trpcInovkeRsp);
                return;
            }
            super.onTrpcRsp(intent, str, j3, trpcInovkeRsp);
            if (QLog.isColorLevel()) {
                QLog.i(QQGameAdServiceImpl.TAG, 2, "cmd: " + str + " ret: " + j3);
            }
            try {
                if ("/v1/62".equals(str) && j3 == 0 && trpcInovkeRsp != null && trpcInovkeRsp.data.get() != null) {
                    QQGamePaAdInfo$LoginReportRsp qQGamePaAdInfo$LoginReportRsp = new QQGamePaAdInfo$LoginReportRsp();
                    qQGamePaAdInfo$LoginReportRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                    long j16 = qQGamePaAdInfo$LoginReportRsp.cacheTime.get();
                    QLog.i(QQGameAdServiceImpl.TAG, 2, "pull ad cacheTs: " + j16);
                    com.tencent.mobileqq.qqgamepub.utils.f.b(QQGameAdServiceImpl.this.mContext, QQGameAdServiceImpl.this.getSpKeyAdRespIntervalTime(), j16 * 1000);
                    com.tencent.mobileqq.qqgamepub.utils.f.b(QQGameAdServiceImpl.this.mContext, QQGameAdServiceImpl.this.getSpKeyRespTime(), System.currentTimeMillis());
                }
            } catch (Throwable th5) {
                QLog.e(QQGameAdServiceImpl.TAG, 1, th5, new Object[0]);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18718);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            mRequestInterval = 300000;
        }
    }

    public QQGameAdServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.listenerAdapter = new a();
        this.mContext = BaseApplication.getContext();
        this.mUin = MobileQQ.sMobileQQ.peekAppRuntime().getLongAccountUin();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.api.impl.QQGameAdServiceImpl.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQGameAdServiceImpl.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).initGdtContext(QQGameAdServiceImpl.this.mContext, new InitGdtContextParams());
                    QLog.i(QQGameAdServiceImpl.TAG, 2, "<<<<init device info<<<<");
                }
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSpKeyAdRespIntervalTime() {
        return "ad_rsp_interval_time_" + this.mUin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSpKeyRespTime() {
        return "ad_rsp_time_" + this.mUin;
    }

    private boolean isOverTimeReqInterval() {
        if (AppSetting.isDebugVersion()) {
            QLog.i(TAG, 2, "[isOverTimeReqInterval] debug version, return false.");
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long a16 = com.tencent.mobileqq.qqgamepub.utils.f.a(this.mContext, getSpKeyRespTime());
        long a17 = com.tencent.mobileqq.qqgamepub.utils.f.a(this.mContext, getSpKeyAdRespIntervalTime());
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "currentTs: " + currentTimeMillis + " lastTs: " + a16 + " tsInterval: " + a17);
        }
        if (currentTimeMillis - a16 >= a17) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$reportGdt$0(int i3, QQGameMsgInfo qQGameMsgInfo, int i16) {
        int i17;
        long longAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getLongAccountUin();
        QQGamePaAdInfo$GdtDataReportReq qQGamePaAdInfo$GdtDataReportReq = new QQGamePaAdInfo$GdtDataReportReq();
        qQGamePaAdInfo$GdtDataReportReq.aciotnId.set(i3);
        qQGamePaAdInfo$GdtDataReportReq.uin.set(longAccountUin);
        qQGamePaAdInfo$GdtDataReportReq.redCnt.set(i16);
        try {
            JSONObject jSONObject = new JSONObject(qQGameMsgInfo.adJson);
            JSONObject optJSONObject = jSONObject.optJSONObject("trace_info");
            if (optJSONObject != null) {
                if (!TextUtils.isEmpty(qQGameMsgInfo.advId)) {
                    try {
                        i17 = Integer.parseInt(qQGameMsgInfo.advId);
                    } catch (Exception e16) {
                        QLog.e(TAG, 1, e16, new Object[0]);
                    }
                    qQGamePaAdInfo$GdtDataReportReq.adid.set(i17);
                    qQGamePaAdInfo$GdtDataReportReq.viewId.set(optJSONObject.optString("view_id", ""));
                }
                i17 = 0;
                qQGamePaAdInfo$GdtDataReportReq.adid.set(i17);
                qQGamePaAdInfo$GdtDataReportReq.viewId.set(optJSONObject.optString("view_id", ""));
            } else {
                i17 = 0;
            }
            QQGamePaAdInfo$ReportUrl qQGamePaAdInfo$ReportUrl = new QQGamePaAdInfo$ReportUrl();
            qQGamePaAdInfo$ReportUrl.clickUrl.set(jSONObject.optString("click_url", ""));
            qQGamePaAdInfo$ReportUrl.exposureUrl.set(jSONObject.optString("exposure_url", ""));
            qQGamePaAdInfo$ReportUrl.originalExposureUrl.set(jSONObject.optString("original_exposure_url", ""));
            qQGamePaAdInfo$GdtDataReportReq.reportUrl.set(qQGamePaAdInfo$ReportUrl);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "reportGdt actionId=" + i3 + ",unreadCount=" + i16 + ",adId=" + i17 + ",uin=" + longAccountUin + ",msgInfo.adJson=" + qQGameMsgInfo.adJson);
            }
            IQQGameTrpcService iQQGameTrpcService = (IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class);
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = iQQGameTrpcService.createTrpcInvokeReq(WadlProxyConsts.CMD_GAME_PA_ADINFO, false, qQGamePaAdInfo$GdtDataReportReq.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            iQQGameTrpcService.requestTrpc(trpcListReq, null);
        } catch (JSONException e17) {
            e17.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameAdService
    public void doOnRunningForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (!this.mHasReportLogin) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastEmptyRequestTime > mRequestInterval) {
            this.mLastEmptyRequestTime = currentTimeMillis;
            pullAd(0);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameAdService
    public void pullAd(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        if (!isOverTimeReqInterval()) {
            QLog.i(TAG, 2, "<<<< pullAd time not over last req time!!!!!<<<<");
            return;
        }
        try {
            QLog.i(TAG, 2, "<<<<begin pullAd!!!!!<<<<");
            ((IPskeyManager) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IPskeyManager.class, "all")).getPskey(new String[]{"gamecenter.qq.com"}, new sd2.a(i3) { // from class: com.tencent.mobileqq.qqgamepub.api.impl.QQGameAdServiceImpl.3
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f264403a;

                {
                    this.f264403a = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQGameAdServiceImpl.this, i3);
                    }
                }

                @Override // sd2.a
                public void onFail(@NonNull String str) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str);
                        return;
                    }
                    QLog.i(QQGameAdServiceImpl.TAG, 2, "[pullAd] getPskey failed: " + str);
                }

                @Override // sd2.a
                public void onSuccess(@NonNull Map<String, String> map) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, (Object) map);
                    } else {
                        ThreadManagerV2.excute(new Runnable(map) { // from class: com.tencent.mobileqq.qqgamepub.api.impl.QQGameAdServiceImpl.3.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ Map f264405d;

                            {
                                this.f264405d = map;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this, (Object) map);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                qq_ad_get.QQAdGet.DeviceInfo deviceInfo;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                try {
                                    QQGamePaAdInfo$LoginReportReq qQGamePaAdInfo$LoginReportReq = new QQGamePaAdInfo$LoginReportReq();
                                    GdtDeviceInfoHelper.Result create = GdtDeviceInfoHelper.create(MobileQQ.sMobileQQ.getApplicationContext(), new GdtDeviceInfoHelper.Params());
                                    if (create != null) {
                                        deviceInfo = create.deviceInfo;
                                    } else {
                                        deviceInfo = null;
                                    }
                                    if (deviceInfo != null) {
                                        Object pbToJson = GdtJsonPbUtil.pbToJson(deviceInfo);
                                        if (pbToJson != null) {
                                            qQGamePaAdInfo$LoginReportReq.deviceInfo.set(pbToJson.toString());
                                        } else {
                                            QLog.i(QQGameAdServiceImpl.TAG, 2, "<<<<get device info fail because  deviceObj is null !!!!!<<<<");
                                        }
                                    } else {
                                        QLog.i(QQGameAdServiceImpl.TAG, 2, "<<<<get device info fail !!!!!<<<<");
                                    }
                                    qQGamePaAdInfo$LoginReportReq.uin.set(QQGameAdServiceImpl.this.mUin);
                                    String str = (String) this.f264405d.get("gamecenter.qq.com");
                                    if (!TextUtils.isEmpty(str)) {
                                        qQGamePaAdInfo$LoginReportReq.gcPskey.set(str);
                                    }
                                    qQGamePaAdInfo$LoginReportReq.source.set(AnonymousClass3.this.f264403a);
                                    TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/62", false, qQGamePaAdInfo$LoginReportReq.toByteArray());
                                    TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
                                    trpcListReq.list.add(createTrpcInvokeReq);
                                    ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(QQGameAdServiceImpl.this.listenerAdapter);
                                    ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
                                } catch (Throwable th5) {
                                    QLog.e(QQGameAdServiceImpl.TAG, 1, th5, new Object[0]);
                                }
                            }
                        }, 128, null, true);
                    }
                }
            });
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameAdService
    public void reportGdt(final QQGameMsgInfo qQGameMsgInfo, final int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qQGameMsgInfo, i3);
        } else {
            ((IQQGamePubMsgApi) QRoute.api(IQQGamePubMsgApi.class)).getUnreadCnt(new IQQGamePubMsgApi.c() { // from class: com.tencent.mobileqq.qqgamepub.api.impl.b
                @Override // com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi.c
                public final void onSuccess(int i16) {
                    QQGameAdServiceImpl.lambda$reportGdt$0(i3, qQGameMsgInfo, i16);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameAdService
    public void reportTianShu(com.tencent.mobileqq.qqgamepub.data.a aVar) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
            return;
        }
        QLog.d(TAG, 1, "report2Tianshu: " + aVar);
        TianShuReportData tianShuReportData = new TianShuReportData();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            str = "";
        } else {
            str = peekAppRuntime.getAccount();
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        tianShuReportData.mTraceId = str + "_" + serverTimeMillis;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mAppId = QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE;
        tianShuReportData.mPageId = QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE;
        tianShuReportData.mItemId = aVar.f264499d;
        tianShuReportData.mSubItemId = "";
        tianShuReportData.mOperTime = serverTimeMillis;
        tianShuReportData.mActionId = aVar.f264498c;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mActionAttr = 1;
        tianShuReportData.mTriggerInfo = aVar.f264500e;
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameAdService
    public void updatePullAdInfo(boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Long.valueOf(j3));
        } else {
            this.mHasReportLogin = z16;
            this.mLastEmptyRequestTime = j3;
        }
    }
}
