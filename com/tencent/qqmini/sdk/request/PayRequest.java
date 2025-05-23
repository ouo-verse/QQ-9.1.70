package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM;
import NS_MINI_APP_PAY.MiniAppMidasPay$StGamePayReq;
import NS_MINI_APP_PAY.MiniAppMidasPay$StGamePayRsp;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class PayRequest extends ProtoBufRequest {
    private static final String TAG = "MiniAppPayRequest";
    private MiniAppMidasPay$StGamePayReq req;

    public PayRequest(String str, String str2, int i3, int i16, int i17, int i18, int i19, String str3, String str4) {
        MiniAppMidasPay$StGamePayReq miniAppMidasPay$StGamePayReq = new MiniAppMidasPay$StGamePayReq();
        this.req = miniAppMidasPay$StGamePayReq;
        miniAppMidasPay$StGamePayReq.appId.set(str);
        this.req.prepayId.set(str2);
        this.req.starCurrency.set(i3);
        this.req.balanceAmount.set(i16);
        this.req.topupAmount.set(i17);
        this.req.payChannel.set(i18);
        this.req.sandboxEnv.set(i19);
        COMM.StCommonExt stCommonExt = new COMM.StCommonExt();
        ArrayList arrayList = new ArrayList();
        COMM.Entry entry = new COMM.Entry();
        entry.key.set("refer");
        entry.value.set(TextUtils.isEmpty(str3) ? "" : str3);
        arrayList.add(entry);
        COMM.Entry entry2 = new COMM.Entry();
        entry2.key.set("via");
        entry2.value.set(TextUtils.isEmpty(str4) ? "" : str4);
        arrayList.add(entry2);
        stCommonExt.mapInfo.set(arrayList);
        this.req.extInfo.setHasFlag(true);
        this.req.extInfo.set(stCommonExt);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "GamePay";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_app_pay";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) {
        if (bArr == null) {
            return null;
        }
        MiniAppMidasPay$StGamePayRsp miniAppMidasPay$StGamePayRsp = new MiniAppMidasPay$StGamePayRsp();
        try {
            miniAppMidasPay$StGamePayRsp.mergeFrom(bArr);
            jSONObject.put("response", miniAppMidasPay$StGamePayRsp);
            jSONObject.put(QzoneIPCModule.RESULT_CODE, jSONObject.get("retCode"));
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d("MiniAppPayRequest", "onResponse fail." + e16);
            return null;
        }
    }
}
