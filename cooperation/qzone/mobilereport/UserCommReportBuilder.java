package cooperation.qzone.mobilereport;

import NS_USER_ACTION_REPORT.UserCommReport;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import cooperation.qzone.QUA;

/* compiled from: P */
/* loaded from: classes28.dex */
public class UserCommReportBuilder {
    private String network_type;
    private long uin;

    public UserCommReport build() {
        UserCommReport userCommReport = new UserCommReport();
        userCommReport.uin = this.uin;
        userCommReport.platform = "AND";
        userCommReport.client_type = "SQ";
        userCommReport.network_type = this.network_type;
        userCommReport.qua = QUA.getQUA3();
        userCommReport.app_version = AppSetting.n();
        if (PrivacyPolicyHelper.isUserAllow()) {
            userCommReport.os_version = ah.t();
            userCommReport.mobile_type = DeviceInfoMonitor.getModel();
        } else {
            userCommReport.os_version = "";
            userCommReport.mobile_type = "";
        }
        return userCommReport;
    }

    public UserCommReportBuilder setNetwork_type(String str) {
        this.network_type = str;
        return this;
    }

    public UserCommReportBuilder setUin(long j3) {
        this.uin = j3;
        return this;
    }
}
