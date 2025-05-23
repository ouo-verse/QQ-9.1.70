package com.tencent.upgrade.network;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upgrade.bean.HttpPostParams;
import com.tencent.upgrade.bean.ReportParam;
import com.tencent.upgrade.core.j;
import com.tencent.upgrade.util.HttpUtil;
import com.tencent.upgrade.util.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    static class a implements HttpUtil.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.upgrade.util.HttpUtil.b
        public void onFail(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            d.c("ReportUploadUtil", "errorCode = " + i3 + " errorMsg = " + str);
        }

        @Override // com.tencent.upgrade.util.HttpUtil.b
        public void onSuccess(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            d.a("ReportUploadUtil", "success  = " + str);
        }
    }

    private static String a(boolean z16) {
        if (z16) {
            return "https://dev.release.qq.com/gray/uploadEvent";
        }
        return "https://r.release.qq.com/gray/uploadEvent";
    }

    public static void b(ReportParam reportParam, boolean z16) {
        if (j.l().v()) {
            String a16 = a(z16);
            HttpPostParams d16 = com.tencent.upgrade.network.a.d(reportParam);
            d16.print();
            HttpUtil.k(a16, d16, new a());
        }
    }
}
