package com.tencent.mobileqq.servlet;

import NS_USER_ACTION_REPORT.UserActionReport;
import NS_USER_ACTION_REPORT.UserActionReportRsp;
import NS_USER_ACTION_REPORT.UserCommReport;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.mobilereport.MobileReportRequest;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes18.dex */
public class g extends MSFServlet {
    static IPatchRedirector $redirector_;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(int i3, AppRuntime appRuntime, UserCommReport userCommReport, ArrayList<UserActionReport> arrayList) {
        NewIntent newIntent = new NewIntent(appRuntime.getApplication(), g.class);
        newIntent.putExtra("userCommReport", userCommReport);
        newIntent.putExtra("reportInfos", arrayList);
        newIntent.putExtra("type", i3);
        appRuntime.startServlet(newIntent);
    }

    public static void b(AppRuntime appRuntime, UserCommReport userCommReport, ArrayList<UserActionReport> arrayList) {
        NewIntent newIntent = new NewIntent(appRuntime.getApplication(), g.class);
        newIntent.putExtra("userCommReport", userCommReport);
        newIntent.putExtra("reportInfos", arrayList);
        appRuntime.startServlet(newIntent);
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        int i3;
        UserActionReportRsp onResponse;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (fromServiceMsg != null) {
            i3 = fromServiceMsg.getResultCode();
        } else {
            i3 = -1;
        }
        new Bundle().putString("msg", "servlet result code is " + i3);
        QLog.d("MobileReport.Servlet", 2, "report onReceive onSend");
        if (i3 == 1000 && fromServiceMsg != null && (onResponse = MobileReportRequest.onResponse(fromServiceMsg.getWupBuffer())) != null) {
            long j3 = onResponse.report_interval;
            if (j3 > 0) {
                com.tencent.mobileqq.vastrash.uec.b.f312425a = j3;
                QLog.d("MobileReport.Servlet", 2, "get onReceive onSend sReportTime = " + onResponse.report_interval);
            }
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        MobileReportRequest mobileReportRequest = new MobileReportRequest(intent.getIntExtra("type", 1), (UserCommReport) intent.getSerializableExtra("userCommReport"), (ArrayList) intent.getSerializableExtra("reportInfos"), (ArrayList) intent.getSerializableExtra("qqStayTimeInfo"), (ArrayList) intent.getSerializableExtra("qqSchemaInfo"));
        packet.setTimeout(10000L);
        packet.setSSOCommand(mobileReportRequest.getCmdString());
        packet.putSendData(mobileReportRequest.encode());
    }
}
