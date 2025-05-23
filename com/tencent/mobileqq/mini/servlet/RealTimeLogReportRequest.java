package com.tencent.mobileqq.mini.servlet;

import NS_MINI_REALTIMELOG.REALTIMELOG$StLogItem;
import NS_MINI_REALTIMELOG.REALTIMELOG$StReportLogReq;
import NS_MINI_REALTIMELOG.REALTIMELOG$StReportLogRsp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.RealTimeLogItem;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class RealTimeLogReportRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_log_report.ReportLog";
    private static final String unikey = "RealTimeLogReport";
    private REALTIMELOG$StReportLogReq req;

    public RealTimeLogReportRequest(String str, String str2, String str3, String[] strArr, List<RealTimeLogItem> list) {
        REALTIMELOG$StReportLogReq rEALTIMELOG$StReportLogReq = new REALTIMELOG$StReportLogReq();
        this.req = rEALTIMELOG$StReportLogReq;
        rEALTIMELOG$StReportLogReq.page.set(str);
        this.req.jslib_version.set(str2);
        for (String str4 : strArr) {
            this.req.filter_msgs.add(str4);
        }
        this.req.report_time.set(System.currentTimeMillis());
        this.req.appid.set(str3);
        for (RealTimeLogItem realTimeLogItem : list) {
            REALTIMELOG$StLogItem rEALTIMELOG$StLogItem = new REALTIMELOG$StLogItem();
            rEALTIMELOG$StLogItem.log_level.set(realTimeLogItem.level);
            rEALTIMELOG$StLogItem.log_time.set(realTimeLogItem.time);
            rEALTIMELOG$StLogItem.f24968msg.set(realTimeLogItem.f348089msg);
            this.req.logs.add(rEALTIMELOG$StLogItem);
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    public static REALTIMELOG$StReportLogRsp onResponse(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        REALTIMELOG$StReportLogRsp rEALTIMELOG$StReportLogRsp = new REALTIMELOG$StReportLogRsp();
        try {
            rEALTIMELOG$StReportLogRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return rEALTIMELOG$StReportLogRsp;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ProtoBufRequest", 2, "onResponse fail." + e16);
            }
            return null;
        }
    }
}
