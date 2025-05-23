package com.tencent.mobileqq.startup.task;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.startup.task.NtTask;
import java.lang.reflect.Method;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends NtTask {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f289786d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46411);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f289786d = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102777", true);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void a() {
        boolean z16;
        for (Method method : AIOPreLoadHelper.class.getDeclaredMethods()) {
            if ((method.getModifiers() & 8) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                try {
                    String name = ((Class) method.invoke(null, new Object[0])).getName();
                    QLog.d("AIOPreLoadTaskNew", 4, "loadClass " + name);
                    Class.forName(name);
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.e("AIOPreLoadTaskNew", 1, "preLoad error", th5);
                    }
                }
            }
        }
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NonNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            if (1 != MobileQQ.sProcessId || !f289786d) {
                return;
            }
            QLog.d("AIOPreLoadTaskNew", 1, "startPreLoad ");
            a();
        }
    }
}
