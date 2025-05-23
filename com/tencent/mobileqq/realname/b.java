package com.tencent.mobileqq.realname;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static b f280196d;

    /* renamed from: e, reason: collision with root package name */
    private static Object f280197e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74493);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f280197e = new Object();
        }
    }

    b(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    public static b b() {
        b bVar;
        b bVar2 = f280196d;
        if (bVar2 != null) {
            return bVar2;
        }
        synchronized (f280197e) {
            if (f280196d == null) {
                f280196d = new b("REAL_NAME");
            }
            bVar = f280196d;
        }
        return bVar;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        ConfigHandler configHandler;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        if (QLog.isColorLevel()) {
            QLog.i("RealName", 2, "onCall s: " + str);
        }
        if (bundle == null) {
            return null;
        }
        int i16 = bundle.getInt("result");
        String string = bundle.getString("source");
        if (QLog.isColorLevel()) {
            QLog.i("RealName", 2, "result is : " + i16);
        }
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (string != null && qQAppInterface != null && ((TextUtils.equals(string, ProcessConstant.AVGAME) || TextUtils.equals(string, "watchtogether")) && (configHandler = (ConfigHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)) != null)) {
            if (i16 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                qQAppInterface.getPreferences().edit().putBoolean("has_auth_real_name_av", z16).commit();
            }
            if (QLog.isColorLevel()) {
                QLog.i("RealName", 2, "notifyUI");
            }
            configHandler.notifyUI(15, true, new Object[]{Boolean.valueOf(z16)});
            return null;
        }
        if (i16 != 0 && qQAppInterface != null) {
            ((ConfigHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).r3();
        }
        return null;
    }
}
