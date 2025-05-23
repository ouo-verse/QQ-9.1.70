package cooperation.qzone.report;

import NS_MOBILE_FEEDS.mobile_online_report_item;
import NS_MOBILE_FEEDS.mobile_online_report_req;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QzoneOnlineTimeCollectReportRequest extends QzoneExternalRequest {
    public static final String CMD_STRING = "reportOnlineTime";
    public JceStruct req;

    public QzoneOnlineTimeCollectReportRequest(long j3, ArrayList<mobile_online_report_item> arrayList) {
        super.setHostUin(j3);
        super.setLoginUserId(j3);
        mobile_online_report_req mobile_online_report_reqVar = new mobile_online_report_req();
        mobile_online_report_reqVar.appid = 8001;
        mobile_online_report_reqVar.type_id = 0;
        mobile_online_report_reqVar.uin = j3;
        mobile_online_report_reqVar.vecOnlineItem = arrayList;
        this.req = mobile_online_report_reqVar;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        return "QzoneNewService.reportOnlineTime";
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public JceStruct getReq() {
        return this.req;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }
}
