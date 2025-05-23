package com.tencent.mobileqq.tianshu.impl.qboss;

import NS_MOBILE_QBOSS_PROTO.MobileQbossReportRsp;
import android.os.Bundle;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuTempApi;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends QZoneObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static c f293078d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23070);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            f293078d = null;
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static c m() {
        if (f293078d == null) {
            synchronized (c.class) {
                if (f293078d == null) {
                    f293078d = new c();
                }
            }
        }
        return f293078d;
    }

    private AppRuntime n() {
        return MobileQQ.sMobileQQ.waitAppRuntime(null);
    }

    @Override // com.tencent.mobileqq.observer.QZoneObserver
    protected void l(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), bundle);
            return;
        }
        if (z16) {
            Serializable serializable = bundle.getSerializable("data");
            if (serializable != null && (serializable instanceof MobileQbossReportRsp)) {
                MobileQbossReportRsp mobileQbossReportRsp = (MobileQbossReportRsp) serializable;
                if (mobileQbossReportRsp.iRet == 0) {
                    QLog.i("QbossReportManager", 4, " onReportQbossResponse success:" + mobileQbossReportRsp.sMsg);
                } else {
                    QLog.i("QbossReportManager", 4, "onReportQbossResponse fail:" + mobileQbossReportRsp.sMsg);
                }
            } else {
                QLog.i("QbossReportManager", 4, "onReportQbossResponse fail: rsp == null || not instanceof MobileQbossReportRsp");
            }
        } else {
            QLog.i("QbossReportManager", 1, "onReportQbossResponse fail: ret = " + bundle.getInt("ret", 0) + " msg = " + bundle.getString("msg"));
        }
        AppRuntime n3 = n();
        if (n3 != null) {
            n3.unRegistObserver(this);
        }
    }

    public void o(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            return;
        }
        v(str, str2, 2);
        if (QLog.isDevelopLevel()) {
            QLog.d("QbossReportManager", 4, "Type:reportClick, sQBosstrace:" + str);
        }
    }

    public void p(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            return;
        }
        v(str, str2, 3);
        if (QLog.isDevelopLevel()) {
            QLog.d("QbossReportManager", 4, "Type:reportClose, sQBosstrace:" + str);
        }
    }

    public void q(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            return;
        }
        v(str, str2, 1);
        if (QLog.isDevelopLevel()) {
            QLog.d("QbossReportManager", 4, "Type:reportExpose, sQBosstrace:" + str);
        }
    }

    public void r(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
            return;
        }
        v(str, str2, 11);
        if (QLog.isDevelopLevel()) {
            QLog.d("QbossReportManager", 4, "Type:reportExpose, sQBosstrace:" + str);
        }
    }

    public void s(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, Integer.valueOf(i3));
            return;
        }
        w(str, str2, 9, i3);
        if (QLog.isDevelopLevel()) {
            QLog.d("QbossReportManager", 4, "Type:reportExpose, sQBosstrace:" + str);
        }
    }

    public void t(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            return;
        }
        v(str, str2, 8);
        if (QLog.isDevelopLevel()) {
            QLog.d("QbossReportManager", 4, "Type:reportUrlClick, sQBosstrace:" + str);
        }
    }

    public void u(int i3, int i16, int i17, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("QbossReportManager", 1, "Type:sendErrorReport, code:" + i17 + " errorMessage = " + str);
        }
        AppRuntime n3 = n();
        if (n3 == null) {
            QLog.e("QbossReportManager", 1, "send report error with runtime null ");
            return;
        }
        NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ.getApplicationContext(), b.class);
        try {
            newIntent.putExtra("uin", Long.parseLong(n3.getAccount()));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        newIntent.putExtra("code", i17);
        newIntent.putExtra("appId", i3);
        newIntent.putExtra(MiniAppGetGameTaskTicketServlet.KEY_TASKID, i16);
        newIntent.putExtra("message", str);
        n3.startServlet(newIntent);
    }

    public void v(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, str2, Integer.valueOf(i3));
        } else {
            w(str, str2, i3, 1);
        }
    }

    public void w(String str, String str2, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        AppRuntime n3 = n();
        if (n3 == null) {
            QLog.e("QbossReportManager", 1, "send report error with runtime null ");
            return;
        }
        NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ.getApplicationContext(), e.class);
        try {
            newIntent.putExtra("uin", Long.parseLong(n3.getAccount()));
        } catch (Exception e16) {
            QLog.e("QbossReportManager", 1, "send report error " + e16);
        }
        newIntent.putExtra("qua", ((ITianshuTempApi) QRoute.api(ITianshuTempApi.class)).getQua());
        newIntent.putExtra("sQBosstrace", str);
        newIntent.putExtra("iOperType", i3);
        newIntent.putExtra("sUserID", str2);
        newIntent.putExtra(Element.ELEMENT_NAME_TIMES, i16);
        n3.registObserver(this);
        n3.startServlet(newIntent);
    }
}
