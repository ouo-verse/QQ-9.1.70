package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.vaswebviewplugin.DailySignInWebviewPlugin;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes11.dex */
public class cz extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static cz f195479d;

    cz() {
        super("SignInModule");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static cz b() {
        if (f195479d == null) {
            f195479d = new cz();
        }
        return f195479d;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        int i16 = bundle.getInt("type", 1);
        int i17 = bundle.getInt("result", 2);
        int i18 = bundle.getInt("day", 1);
        if (QLog.isColorLevel()) {
            QLog.i(DailySignInWebviewPlugin.TAG, 2, "SignInModule onCall type = " + i16 + ",result = " + i17 + ",day = " + i18);
        }
        if (i17 == 0 && (qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()) != null) {
            qQAppInterface.getPreferences();
            CardHandler cardHandler = (CardHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
            if (QLog.isColorLevel()) {
                QLog.i(DailySignInWebviewPlugin.TAG, 2, "get oidb0x922 by web");
            }
            cardHandler.l3(0);
            cardHandler.k3();
            return null;
        }
        return null;
    }
}
