package com.tencent.mobileqq.guild.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.api.IGuildProtocolsReportApi;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* loaded from: classes12.dex */
public class GuildProtocolsReportApiImpl implements IGuildProtocolsReportApi {
    private static final String GUILD_MSG_SEND_PB_REPORT = "guild_msg_send_pb_report";
    private static final String TAG = "GuildMsgSendPbReportServiceImpl";
    private fw1.h mParserFactory = new fw1.h();

    private void doEndOpenTelemetryReport(String str, fw1.b bVar) {
        int b16;
        try {
            String c16 = com.tencent.open.base.a.c(com.tencent.open.adapter.a.f().e());
            HashMap hashMap = new HashMap();
            hashMap.put("result", String.valueOf(bVar.b()));
            hashMap.put("err_msg", bVar.a());
            hashMap.put("network", c16);
            IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class);
            hashMap.put("source", "gpro_cssender");
            iQQOpenTelemetryReportApi.setOpenTelemetryTaskAttributes(str, hashMap);
            if (bVar.c()) {
                b16 = 0;
            } else {
                b16 = bVar.b();
            }
            iQQOpenTelemetryReportApi.setStatusCode(str, b16);
            iQQOpenTelemetryReportApi.endOpenTelemetryTask(str);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "endGuildMsgProtocolReport:", e16);
        }
    }

    private fw1.a getReportProtocolParser(int i3, ToServiceMsg toServiceMsg) {
        return this.mParserFactory.a(i3);
    }

    private String getTaskKey(ToServiceMsg toServiceMsg) {
        if (toServiceMsg == null) {
            return null;
        }
        return toServiceMsg.extraData.getString(GUILD_MSG_SEND_PB_REPORT);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildProtocolsReportApi
    public void endGuildMsgProtocolReport(int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object... objArr) {
        if (toServiceMsg != null && fromServiceMsg != null) {
            String taskKey = getTaskKey(toServiceMsg);
            if (TextUtils.isEmpty(taskKey)) {
                QLog.d(TAG, 1, "endGuildMsgProtocolReport taskKey error!");
                return;
            }
            fw1.a reportProtocolParser = getReportProtocolParser(i3, toServiceMsg);
            if (reportProtocolParser == null) {
                QLog.d(TAG, 1, "endGuildMsgProtocolReport getReportProtocolParser null! parserId = " + i3);
                return;
            }
            doEndOpenTelemetryReport(taskKey, reportProtocolParser.d(fromServiceMsg, objArr));
            return;
        }
        QLog.d(TAG, 1, "endGuildMsgProtocolReport args error! parserId = " + i3);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildProtocolsReportApi
    public void startGuildMsgProtocolReport(ToServiceMsg toServiceMsg) {
        if (toServiceMsg == null) {
            QLog.d(TAG, 1, "startGuildMsgProtocolReport toServiceMsg null!");
            return;
        }
        try {
            String serviceCmd = toServiceMsg.getServiceCmd();
            IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class);
            String startOpenTelemetryTask = iQQOpenTelemetryReportApi.startOpenTelemetryTask(serviceCmd);
            if (TextUtils.isEmpty(serviceCmd) || TextUtils.isEmpty(startOpenTelemetryTask)) {
                QLog.d(TAG, 1, "serviceCmd error || taskKey error serviceCmd = " + serviceCmd + " taskKey = " + startOpenTelemetryTask);
            }
            iQQOpenTelemetryReportApi.setOpenTelemetryTaskAttributes(startOpenTelemetryTask, new HashMap());
            toServiceMsg.extraData.putString(GUILD_MSG_SEND_PB_REPORT, startOpenTelemetryTask);
            String traceInfo = iQQOpenTelemetryReportApi.getTraceInfo(startOpenTelemetryTask);
            if (!TextUtils.isEmpty(traceInfo)) {
                toServiceMsg.setTraceInfo(traceInfo);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "startGuildMsgProtocolReport:", e16);
        }
    }
}
