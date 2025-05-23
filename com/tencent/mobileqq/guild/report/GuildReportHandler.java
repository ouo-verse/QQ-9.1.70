package com.tencent.mobileqq.guild.report;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.guild.config.subconfig.parser.GuildNotificationReportBean;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.group_pro_proto.reportsvr.ReportSvr$Record;
import tencent.im.group_pro_proto.reportsvr.ReportSvr$ReqBody;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildReportHandler extends BusinessHandler implements g {
    public GuildReportHandler(AppInterface appInterface) {
        super(appInterface);
    }

    @Override // com.tencent.mobileqq.guild.report.g
    public void L0(i iVar) {
        if (QLog.isColorLevel()) {
            QLog.d("GuildReportHandler", 2, "reportAtta:" + iVar);
        }
        tg1.a a16 = ch.E().a(103);
        if ((a16 instanceof GuildNotificationReportBean) && !((GuildNotificationReportBean) a16).canReport) {
            QLog.i("GuildReportHandler", 1, " reportAtta: ERR filter currUin");
            return;
        }
        ReportSvr$Record record = iVar.toRecord();
        if (record == null) {
            return;
        }
        ReportSvr$ReqBody reportSvr$ReqBody = new ReportSvr$ReqBody();
        reportSvr$ReqBody.records.add(record);
        reportSvr$ReqBody.report_type.set(1);
        ToServiceMsg createToServiceMsg = createToServiceMsg("trpc.group_pro.reportsvr.ReporterSvr.SsoReportData");
        createToServiceMsg.putWupBuffer(reportSvr$ReqBody.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("trpc.group_pro.reportsvr.ReporterSvr.SsoReportData");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.d("GuildReportHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if ("trpc.group_pro.reportsvr.ReporterSvr.SsoReportData".equals(fromServiceMsg.getServiceCmd()) && QLog.isColorLevel()) {
                QLog.d("GuildReportHandler", 2, "resp resultCode=" + fromServiceMsg.getResultCode());
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GuildReportHandler", 2, "onReceive,resp == null or req == null");
        }
    }
}
