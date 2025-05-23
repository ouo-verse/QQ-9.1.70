package cooperation.qzone.report.lp;

import NS_MOBILE_CLIENT_UPDATE.CLIENT_REPORT_REQ;
import NS_MOBILE_CLIENT_UPDATE.CLIENT_REPORT_RSP;
import NS_MOBILE_CLIENT_UPDATE.REPORT_INFO;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReportRequest extends QzoneExternalRequest {
    private static final String CMD = "update.ClientReport";
    public static final String UNI_KEY = "ClientReport";
    public JceStruct req;

    public LpReportRequest(long j3, ArrayList<Map<String, String>> arrayList, Map<String, String> map, ArrayList<REPORT_INFO> arrayList2) {
        CLIENT_REPORT_REQ client_report_req = new CLIENT_REPORT_REQ();
        client_report_req.type = j3;
        client_report_req.info = arrayList;
        client_report_req.extra_info = map;
        client_report_req.multi_info = arrayList2;
        this.req = client_report_req;
    }

    public static CLIENT_REPORT_RSP onResponse(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        JceStruct decode = QzoneExternalRequest.decode(bArr, "ClientReport");
        if (!(decode instanceof CLIENT_REPORT_RSP)) {
            return null;
        }
        return (CLIENT_REPORT_RSP) decode;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        return "QzoneNewService.update.ClientReport";
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public JceStruct getReq() {
        return this.req;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "ClientReport";
    }
}
