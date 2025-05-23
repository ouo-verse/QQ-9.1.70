package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StJudgeTimingReq;
import NS_MINI_INTERFACE.INTERFACE$StJudgeTimingRsp;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import cooperation.qzone.QzoneIPCModule;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class JudgeTimingRequest extends ProtoBufRequest {
    public static final String TAG = "JudgeTimingRequest";
    private final INTERFACE$StJudgeTimingReq req;

    public JudgeTimingRequest(String str, int i3, int i16, int i17, long j3, int i18, int i19, String str2, int i26, String str3, int i27, COMM.StCommonExt stCommonExt, String str4, String str5) {
        INTERFACE$StJudgeTimingReq iNTERFACE$StJudgeTimingReq = new INTERFACE$StJudgeTimingReq();
        this.req = iNTERFACE$StJudgeTimingReq;
        iNTERFACE$StJudgeTimingReq.appid.set(str);
        iNTERFACE$StJudgeTimingReq.appType.set(i3);
        iNTERFACE$StJudgeTimingReq.scene.set(i16);
        iNTERFACE$StJudgeTimingReq.factType.set(i17);
        iNTERFACE$StJudgeTimingReq.reportTime.set(j3);
        iNTERFACE$StJudgeTimingReq.totalTime.set(i19);
        iNTERFACE$StJudgeTimingReq.launchId.set(str2);
        iNTERFACE$StJudgeTimingReq.afterCertify.set(i26);
        iNTERFACE$StJudgeTimingReq.via.set(str3);
        iNTERFACE$StJudgeTimingReq.AdsTotalTime.set(i27);
        iNTERFACE$StJudgeTimingReq.sourceID.set(str5);
        iNTERFACE$StJudgeTimingReq.duration.set(i18);
        if (stCommonExt != null) {
            iNTERFACE$StJudgeTimingReq.extInfo.set(stCommonExt);
        }
        if (str4 != null) {
            iNTERFACE$StJudgeTimingReq.hostExtInfo.set(str4);
        }
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "JudgeTiming";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_app_growguard";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) {
        if (bArr == null) {
            return null;
        }
        INTERFACE$StJudgeTimingRsp iNTERFACE$StJudgeTimingRsp = new INTERFACE$StJudgeTimingRsp();
        try {
            iNTERFACE$StJudgeTimingRsp.mergeFrom(bArr);
            jSONObject.put("response", iNTERFACE$StJudgeTimingRsp);
            jSONObject.put(QzoneIPCModule.RESULT_CODE, 0);
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d(TAG, "onResponse fail." + e16);
            return null;
        }
    }
}
