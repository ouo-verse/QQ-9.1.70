package cooperation.qzone.mobilereport;

import NS_USER_ACTION_REPORT.QQSchemaInfo;
import NS_USER_ACTION_REPORT.QQStayTimeInfo;
import NS_USER_ACTION_REPORT.UserActionReport;
import NS_USER_ACTION_REPORT.UserActionReportReq;
import NS_USER_ACTION_REPORT.UserActionReportRsp;
import NS_USER_ACTION_REPORT.UserCommReport;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes28.dex */
public class MobileReportRequest extends QzoneExternalRequest {
    private static final String CmdString = "MobileReport.UserActionReport";
    private static final String UNIKEY = "UserActionReport";
    private static final String newCmdString = "QQVASsoReport.UserActionReport";
    private final JceStruct req;

    public MobileReportRequest(int i3, UserCommReport userCommReport, ArrayList<UserActionReport> arrayList, ArrayList<QQStayTimeInfo> arrayList2, ArrayList<QQSchemaInfo> arrayList3) {
        this.req = new UserActionReportReq(i3, userCommReport, arrayList, arrayList2, arrayList3);
        this.needCompress = false;
    }

    public static UserActionReportRsp onResponse(byte[] bArr) {
        UserActionReportRsp userActionReportRsp;
        if (bArr == null || (userActionReportRsp = (UserActionReportRsp) QzoneExternalRequest.decode(bArr, UNIKEY)) == null) {
            return null;
        }
        return userActionReportRsp;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        return newCmdString;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public JceStruct getReq() {
        return this.req;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return UNIKEY;
    }
}
