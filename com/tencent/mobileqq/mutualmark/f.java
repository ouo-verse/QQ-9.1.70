package com.tencent.mobileqq.mutualmark;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.vas.widget.lottie.LottieLoader;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f252035f;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f252036d;

    /* renamed from: e, reason: collision with root package name */
    h f252037e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73268);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f252035f = new String[]{LottieLoader.FILE_DATA_JSON, "icon_close.png"};
        }
    }

    public f(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f252036d = qQAppInterface;
            this.f252037e = new h();
        }
    }

    public static f b(QQAppInterface qQAppInterface) {
        return (f) qQAppInterface.getManager(QQManagerFactory.MUTUAL_MARK_MANAGER);
    }

    public void a(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (c(str, str2)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MutualMarkManger", 2, "checkDownloadCartoonResource download url:" + str + " md5:" + str2);
        }
        this.f252037e.i(this.f252036d, 10089, PreDownloadConstants.DEPARTMENT_PRD, str, str2, f252035f, null);
    }

    public boolean c(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        boolean o16 = h.o(str, str2, f252035f);
        if (QLog.isColorLevel()) {
            QLog.d("MutualMarkManger", 2, "isCartoonResourceReady url:" + str + " md5:" + str2 + " res:" + o16);
        }
        return o16;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f252037e.q();
        }
    }
}
