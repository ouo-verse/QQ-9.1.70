package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StCurrChannelInfo;
import NS_MINI_INTERFACE.INTERFACE$StUseUserAppReq;
import NS_MINI_INTERFACE.INTERFACE$StUseUserAppRsp;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class UseUserAppRequest extends ProtoBufRequest {
    public static final String TAG = "UseUserAppRequest";
    private JSONObject mJSONObject = new JSONObject();
    private INTERFACE$StUseUserAppReq req;

    public UseUserAppRequest(COMM.StCommonExt stCommonExt, String str, int i3, int i16, String str2, String str3) {
        if (getContentType() == 0) {
            INTERFACE$StUseUserAppReq iNTERFACE$StUseUserAppReq = new INTERFACE$StUseUserAppReq();
            this.req = iNTERFACE$StUseUserAppReq;
            iNTERFACE$StUseUserAppReq.appId.set(str);
            this.req.verType.set(i3);
            this.req.source.set(i16);
            INTERFACE$StCurrChannelInfo iNTERFACE$StCurrChannelInfo = new INTERFACE$StCurrChannelInfo();
            iNTERFACE$StCurrChannelInfo.refer.set(str2);
            iNTERFACE$StCurrChannelInfo.via.set(str3);
            this.req.channelInfo.set(iNTERFACE$StCurrChannelInfo);
            if (stCommonExt != null) {
                this.req.extInfo.set(stCommonExt);
                return;
            }
            return;
        }
        try {
            this.mJSONObject.put("appId", str);
            this.mJSONObject.put("verType", i3);
            this.mJSONObject.put("source", i16);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("refer", str2);
            jSONObject.put("via", str3);
            this.mJSONObject.put("channelInfo", jSONObject);
        } catch (Exception e16) {
            QMLog.d("UseUserAppRequest", "UseUserAppRequest Exception:" + e16);
        }
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public byte[] getBusiBuf() {
        if (getContentType() == 0) {
            return this.req.toByteArray();
        }
        return this.mJSONObject.toString().getBytes();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "UseUserApp";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public int getContentType() {
        return QUAUtil.isAlienApp() ? 1 : 0;
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_app_userapp";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) {
        if (bArr == null) {
            return null;
        }
        if (getContentType() == 0) {
            INTERFACE$StUseUserAppRsp iNTERFACE$StUseUserAppRsp = new INTERFACE$StUseUserAppRsp();
            try {
                iNTERFACE$StUseUserAppRsp.mergeFrom(bArr);
                COMM.StCommonExt stCommonExt = iNTERFACE$StUseUserAppRsp.extInfo;
                if (stCommonExt != null) {
                    jSONObject.put("ext", stCommonExt.get());
                    return jSONObject;
                }
                QMLog.d("UseUserAppRequest", "onResponse fail.extInfo = null");
                return null;
            } catch (Exception e16) {
                QMLog.d("UseUserAppRequest", "onResponse fail." + e16);
                return null;
            }
        }
        return jSONObject;
    }
}
