package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM;
import NS_MINI_SHARE.MiniProgramShare$StAdaptShareInfoReq;
import NS_MINI_SHARE.MiniProgramShare$StAdaptShareInfoRsp;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GetShareInfoRequest extends ProtoBufRequest {
    public static final String JSON_DATA = "jsonData";
    public static final String MINI_APP_NEED_ONLY_PREVIEW = "miniAppNeedOnlyPreview";
    public static final String NEED_SHARE_CALLBACK = "needShareCallBack";
    public static final long SHARE_APPID_MISMATCHING = -1000710003;
    public static final long SHARE_DANGEROUS_PERSON = -100070016;
    public static final long SHARE_OUT_OF_LIMIT = -100070004;
    private static final String TAG = "GetShareInfoRequest";
    private MiniProgramShare$StAdaptShareInfoReq req;

    public GetShareInfoRequest(MiniProgramShare$StAdaptShareInfoReq miniProgramShare$StAdaptShareInfoReq) {
        this.req = miniProgramShare$StAdaptShareInfoReq;
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "AdaptShareInfo";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_app_share";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) {
        if (bArr == null) {
            return null;
        }
        MiniProgramShare$StAdaptShareInfoRsp miniProgramShare$StAdaptShareInfoRsp = new MiniProgramShare$StAdaptShareInfoRsp();
        try {
            miniProgramShare$StAdaptShareInfoRsp.mergeFrom(bArr);
            long j3 = jSONObject.getLong("retCode");
            jSONObject.getString("errMsg");
            COMM.StCommonExt stCommonExt = miniProgramShare$StAdaptShareInfoRsp.extInfo;
            boolean z16 = false;
            z16 = false;
            if (stCommonExt != null && stCommonExt.mapInfo != null) {
                boolean z17 = false;
                for (int i3 = 0; i3 < miniProgramShare$StAdaptShareInfoRsp.extInfo.mapInfo.size(); i3++) {
                    COMM.Entry entry = miniProgramShare$StAdaptShareInfoRsp.extInfo.mapInfo.get(i3);
                    if ("needShareCallBack".equals(entry.key.get()) && "true".equals(entry.value.get())) {
                        z17 = true;
                    }
                }
                z16 = z17;
            }
            if (j3 != -100070004 && j3 != -1000710003 && j3 != -100070016) {
                JSONObject jSONObject2 = new JSONObject(miniProgramShare$StAdaptShareInfoRsp.jsonData.get());
                jSONObject2.put("needShareCallBack", z16);
                return jSONObject2;
            }
            QMLog.e(TAG, "onGetShareInfo isSuccess=false, retCode=" + j3);
            jSONObject.put("needShareCallBack", z16);
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d(TAG, "onResponse fail." + e16);
            return null;
        }
    }
}
