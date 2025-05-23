package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StReportLogFileReq;
import NS_MINI_INTERFACE.INTERFACE$StReportLogFileRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ReportLogFileRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_info.ReportLogFile";
    public static final String TAG = "ReportLogFileRequest";
    private INTERFACE$StReportLogFileReq req;

    public ReportLogFileRequest(COMM.StCommonExt stCommonExt, String str, String str2, int i3) {
        INTERFACE$StReportLogFileReq iNTERFACE$StReportLogFileReq = new INTERFACE$StReportLogFileReq();
        this.req = iNTERFACE$StReportLogFileReq;
        iNTERFACE$StReportLogFileReq.appid.set(str);
        this.req.fileUrl.set(str2);
        this.req.fileSize.set(i3);
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt);
        }
    }

    public static INTERFACE$StReportLogFileRsp onResponse(byte[] bArr) {
        INTERFACE$StReportLogFileRsp iNTERFACE$StReportLogFileRsp = new INTERFACE$StReportLogFileRsp();
        try {
            iNTERFACE$StReportLogFileRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StReportLogFileRsp;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d(TAG, 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
