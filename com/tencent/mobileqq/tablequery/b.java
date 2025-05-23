package com.tencent.mobileqq.tablequery;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private c f291386d;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(QQAppInterface qQAppInterface, ReportData$ReqBody reportData$ReqBody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQAppInterface, (Object) reportData$ReqBody);
            return;
        }
        NewIntent newIntent = new NewIntent(qQAppInterface.getApp(), d.class);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3380);
        oidb_sso_oidbssopkg.uint32_service_type.set(2);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(reportData$ReqBody.toByteArray()));
        newIntent.setObserver(this.f291386d);
        newIntent.putExtra("RequestBytes", oidb_sso_oidbssopkg.toByteArray());
        qQAppInterface.startServlet(newIntent);
    }

    public void b(QQAppInterface qQAppInterface, String str, int i3, String str2, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qQAppInterface, str, Integer.valueOf(i3), str2, str3, str4);
            return;
        }
        ReportData$ReqMqqParam reportData$ReqMqqParam = new ReportData$ReqMqqParam();
        reportData$ReqMqqParam.department.set(str2);
        reportData$ReqMqqParam.opername.set(str3);
        reportData$ReqMqqParam.action.set(str4);
        if (this.f291386d == null) {
            this.f291386d = new c();
        }
        try {
            ReportData$ReqBody reportData$ReqBody = new ReportData$ReqBody();
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            reportData$ReqBody.reportId.set(arrayList);
            reportData$ReqBody.type.set(i3);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(reportData$ReqMqqParam);
            reportData$ReqBody.params.set(arrayList2);
            a(qQAppInterface, reportData$ReqBody);
        } catch (Exception e16) {
            QLog.e("TableQueryManager", 1, e16.toString());
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }
}
