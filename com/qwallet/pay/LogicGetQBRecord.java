package com.qwallet.pay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.qwallet.utils.QWalletUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.IAPMidasNetCallBack;
import com.tencent.midas.api.request.APMidasQueryRequest;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import org.json.JSONObject;
import y05.a;

/* compiled from: P */
/* loaded from: classes3.dex */
public class LogicGetQBRecord extends a {
    public LogicGetQBRecord(Context context, Intent intent) {
        super(context, intent);
    }

    @Override // com.qwallet.pay.a
    public void g(Context context) {
        String str;
        String str2;
        super.g(context);
        try {
            new Bundle();
            String string = this.f41632d.getString("reqData");
            final JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject(string);
            String optString = jSONObject2.optString("order", "asc");
            String optString2 = jSONObject2.optString("pageNum");
            String optString3 = jSONObject2.optString("pageSize");
            final String optString4 = jSONObject2.optString("offerId");
            int optInt = jSONObject2.optInt("durationDays");
            if (optInt <= 0) {
                optInt = 60;
            }
            final String str3 = "qq_m_qq-2013-android-" + AppSetting.f() + "-" + jSONObject2.optString("aid");
            final String optString5 = jSONObject2.optString("callback");
            String string2 = this.f41632d.getString("uin");
            String optString6 = jSONObject2.optString("userKey");
            String optString7 = jSONObject2.optString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE);
            if (TextUtils.isEmpty(optString6) && TextUtils.isEmpty(optString7)) {
                String string3 = this.f41632d.getString("userKey");
                str2 = this.f41632d.getString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE);
                str = string3;
            } else {
                str = optString6;
                str2 = optString7;
            }
            final APMidasQueryRequest aPMidasQueryRequest = new APMidasQueryRequest();
            aPMidasQueryRequest.setOfferId(optString4);
            aPMidasQueryRequest.setOpenId(string2);
            aPMidasQueryRequest.setOpenKey(str);
            aPMidasQueryRequest.setSessionId("uin");
            aPMidasQueryRequest.setSessionType(str2);
            aPMidasQueryRequest.setPf(str3);
            aPMidasQueryRequest.setPfKey("pfKey");
            aPMidasQueryRequest.setCmdCode("query");
            aPMidasQueryRequest.setSubCmdCode("qqacctinfo");
            aPMidasQueryRequest.setBeginTime(String.valueOf(NetConnInfoCenter.getServerTime() - ((optInt * 24) * 3600)));
            aPMidasQueryRequest.setEndTime(String.valueOf(NetConnInfoCenter.getServerTime()));
            aPMidasQueryRequest.setOrderBy(optString);
            aPMidasQueryRequest.setPageNum(optString2);
            aPMidasQueryRequest.setPageSize(optString3);
            aPMidasQueryRequest.setIsRetTotalCnt("true");
            aPMidasQueryRequest.setCrossApp("true");
            APMidasPayAPI.setEnv(QWalletUtils.d());
            APMidasPayAPI.setLogEnable(r.o());
            APMidasPayAPI.setLogCallback(v.class);
            final String str4 = str2;
            APMidasPayAPI.init(this.f41629a, aPMidasQueryRequest, new ResultReceiver(ThreadManagerV2.getUIHandlerV2()) { // from class: com.qwallet.pay.LogicGetQBRecord.1
                @Override // android.os.ResultReceiver
                protected void onReceiveResult(int i3, Bundle bundle) {
                    APMidasPayAPI.getInfo((Activity) LogicGetQBRecord.this.f41629a, APMidasQueryRequest.NET_REQ_TRANSACTION, aPMidasQueryRequest, new a(bundle));
                    y05.a.b(new a.MidasPayReportInfo(16, optString4, str4, str3, -1, -1, LogicGetQBRecord.this.f41632d.getString("payparmas_h5_url"), null, null));
                }

                /* compiled from: P */
                /* renamed from: com.qwallet.pay.LogicGetQBRecord$1$a */
                /* loaded from: classes3.dex */
                class a implements IAPMidasNetCallBack {

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ Bundle f41611a;

                    a(Bundle bundle) {
                        this.f41611a = bundle;
                    }

                    @Override // com.tencent.midas.api.IAPMidasNetCallBack
                    public void MidasNetFinish(String str, String str2) {
                        try {
                            JSONObject jSONObject = new JSONObject(str2);
                            jSONObject.put("retMessage", jSONObject.optString("ResultInfo"));
                            jSONObject.put(QzoneIPCModule.RESULT_CODE, jSONObject.optString("ResultCode"));
                            jSONObject.put("respString", str2);
                            this.f41611a.putString("retData", jSONObject.toString());
                            this.f41611a.putString("callback", optString5);
                            LogicGetQBRecord.this.e(this.f41611a);
                        } catch (Exception e16) {
                            QLog.e("Q.qwallet.BasePayPluginLogic", 1, "", e16);
                        }
                    }

                    @Override // com.tencent.midas.api.IAPMidasNetCallBack
                    public void MidasNetStop(String str) {
                    }

                    @Override // com.tencent.midas.api.IAPMidasNetCallBack
                    public void MidasNetError(String str, int i3, String str2) {
                    }
                }
            });
        } catch (Exception e16) {
            QLog.e("Q.qwallet.BasePayPluginLogic", 1, "", e16);
        }
    }
}
