package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StReportShareReq;
import NS_MINI_INTERFACE.INTERFACE$StReportShareRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ReportShareRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_usr_time.ReportShare";
    public static final String TAG = "ReportShareRequest";
    private INTERFACE$StReportShareReq req;

    public ReportShareRequest(long j3, String str, int i3, int i16, int i17, int i18, String str2) {
        INTERFACE$StReportShareReq iNTERFACE$StReportShareReq = new INTERFACE$StReportShareReq();
        this.req = iNTERFACE$StReportShareReq;
        iNTERFACE$StReportShareReq.reportTime.set(j3);
        this.req.appid.set(str);
        this.req.appType.set(i3);
        this.req.shareScene.set(i16);
        this.req.shareType.set(i17);
        this.req.destType.set(i18);
        this.req.destId.set(str2);
    }

    public static INTERFACE$StReportShareRsp onResponse(byte[] bArr) {
        INTERFACE$StReportShareRsp iNTERFACE$StReportShareRsp = new INTERFACE$StReportShareRsp();
        try {
            iNTERFACE$StReportShareRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StReportShareRsp;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("ReportShareRequest", 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
