package com.tencent.mobileqq.data;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.dex.sdkupdate.TVKUpdateInfo;
import com.trunk.Qworkflow.Qworkflow$WorkflowChangeNotification;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForApproval extends ChatMessage {
    public int approvalStatus;
    public long creator;
    public int mainType;
    public int notifyType;
    public int serviceType;
    public int subType;
    public String summary;
    public String title;
    public String workId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        try {
            Qworkflow$WorkflowChangeNotification qworkflow$WorkflowChangeNotification = new Qworkflow$WorkflowChangeNotification();
            qworkflow$WorkflowChangeNotification.mergeFrom(this.msgData);
            this.workId = qworkflow$WorkflowChangeNotification.bytes_workflow_id.get().toStringUtf8();
            this.mainType = qworkflow$WorkflowChangeNotification.uint32_main_type.get();
            this.subType = qworkflow$WorkflowChangeNotification.uint32_sub_type.get();
            this.creator = qworkflow$WorkflowChangeNotification.uint64_author_uin.get();
            this.title = qworkflow$WorkflowChangeNotification.bytes_title.get().toStringUtf8();
            this.summary = qworkflow$WorkflowChangeNotification.msg_summary.bytes_content.get().toStringUtf8();
            this.notifyType = qworkflow$WorkflowChangeNotification.enum_change_type.get();
            this.approvalStatus = qworkflow$WorkflowChangeNotification.msg_current_state.uint32_state_num.get();
        } catch (Exception e16) {
            QLog.e("MessageForApproval_Approval", 1, e16.toString());
        }
    }

    public String getFullTitle() {
        if (!this.mIsParsed) {
            parse();
        }
        StringBuilder sb5 = new StringBuilder();
        try {
            String[] split = this.title.split("\u0002");
            sb5.append("\u7533\u8bf7");
            String str = "";
            for (String str2 : split) {
                if (str2.startsWith(TVKUpdateInfo.APP_ID)) {
                    String substring = str2.substring(3);
                    if (HardCodeUtil.qqStr(R.string.f172176o24).equalsIgnoreCase(substring)) {
                        substring = HardCodeUtil.qqStr(R.string.f172167o10);
                    }
                    sb5.append(substring);
                } else if (str2.startsWith(QQHealthReportApiImpl.MSG_EXPOSE_KEY)) {
                    sb5.append(str2.substring(3));
                } else if (str2.startsWith(QQHealthReportApiImpl.MSG_CLICK_KEY)) {
                    sb5.append(str2.substring(3));
                } else if (str2.startsWith("003")) {
                    str = str2.substring(3);
                }
            }
            if ("1".equalsIgnoreCase(str)) {
                sb5.append("(\u542b\u5468\u672b)");
            }
        } catch (Exception unused) {
            if (QLog.isDevelopLevel()) {
                sb5.append("\u89e3\u6790\u51fa\u9519\u4e86\uff0c\u5feb\u67e5!");
            }
        }
        return HardCodeUtil.qqStr(R.string.o1j) + sb5.toString();
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        return HardCodeUtil.qqStr(R.string.o1z);
    }
}
