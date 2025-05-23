package com.tencent.mobileqq.leba.feed;

import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f240564a;

    /* renamed from: b, reason: collision with root package name */
    private static AtomicBoolean f240565b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27194);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f240564a = true;
            f240565b = new AtomicBoolean(false);
        }
    }

    public static boolean a() {
        return f240564a;
    }

    public static boolean b() {
        return f240565b.get();
    }

    private static void c(boolean z16) {
        QLog.e("LebaFeedUtil", 1, "notifyLebaStyleChange showQzoneFrame= " + z16);
        ((ILebaHelperService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ILebaHelperService.class, "")).notifyLebaStyleChange(z16);
    }

    public static void d(boolean z16) {
        boolean z17;
        QLog.i("LebaFeedUtil", 1, "setIsShowQzoneFrame isShow=" + z16);
        if (z16 != f240564a) {
            z17 = true;
        } else {
            z17 = false;
        }
        f240564a = z16;
        if (f240565b.compareAndSet(false, true)) {
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("leba_ignore_first_frame_change_switch", false);
            QLog.i("LebaFeedUtil", 1, "setIsShowQzoneFrame init. ignore: " + isSwitchOn);
            if (!isSwitchOn) {
                c(z16);
                return;
            }
            return;
        }
        if (z17) {
            QLog.i("LebaFeedUtil", 2, "setIsShowQzoneFrame change -> " + z16);
            c(z16);
        }
    }
}
