package com.tencent.mobileqq.guild.feed.personalbox;

import cn1.a;
import cn1.b;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.group_pro_proto.personalbox.PersonalBox$ReportReq;

/* loaded from: classes13.dex */
public class GuildFeedPersonalBoxHandler extends BusinessHandler implements b {
    public GuildFeedPersonalBoxHandler(AppInterface appInterface) {
        super(appInterface);
    }

    private void D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        int resultCode = fromServiceMsg.getResultCode();
        String businessFailMsg = fromServiceMsg.getBusinessFailMsg();
        if (resultCode == 1000) {
            z16 = true;
        } else {
            z16 = false;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handleReportReadRsp, isSuccess = ");
        sb5.append(z16);
        sb5.append(", errMsg: ");
        if (businessFailMsg == null) {
            businessFailMsg = "";
        }
        sb5.append(businessFailMsg);
        sb5.append(", result: ");
        sb5.append(resultCode);
        QLog.i("GuildFeedPersonalBoxHandler", 2, sb5.toString());
        notifyUI(a.f31135e, z16, new Object[]{Integer.valueOf(resultCode)});
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("trpc.group_pro.personal_box.PersonalBox.SsoReport");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.d("GuildFeedPersonalBoxHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if ("trpc.group_pro.personal_box.PersonalBox.SsoReport".equals(fromServiceMsg.getServiceCmd())) {
                D2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GuildFeedPersonalBoxHandler", 2, "onReceive,resp == null or req == null");
        }
    }

    @Override // cn1.b
    public void z2(long j3) {
        QLog.i("GuildFeedPersonalBoxHandler", 1, "reportRead. timestamp: " + j3);
        PersonalBox$ReportReq personalBox$ReportReq = new PersonalBox$ReportReq();
        personalBox$ReportReq.report_time.set(j3);
        personalBox$ReportReq.biz_type.set(1L);
        ToServiceMsg createToServiceMsg = createToServiceMsg("trpc.group_pro.personal_box.PersonalBox.SsoReport");
        createToServiceMsg.putWupBuffer(personalBox$ReportReq.toByteArray());
        createToServiceMsg.setTimeout(30000L);
        sendPbReq(createToServiceMsg);
    }
}
