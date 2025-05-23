package com.tencent.mobileqq.intimate;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mutualmark.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static volatile c f238538d;

    public c(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    public static c b() {
        if (f238538d == null) {
            synchronized (c.class) {
                if (f238538d == null) {
                    f238538d = new c("IntimateQIPCModule");
                }
            }
        }
        return f238538d;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (!(runtime instanceof QQAppInterface)) {
            return null;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) runtime;
        if ("key_web_change_switch_request".equals(str)) {
            boolean z16 = bundle.getBoolean("key_web_mutual_mark_switch_status");
            if (QLog.isColorLevel()) {
                QLog.d("IntimateQIPCModule", 2, "onCall KEY_WEB_CHANGE_SWITCH_REQUEST ,status = " + z16);
            }
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X8007021", "0X8007021", 0, 0, String.valueOf(z16 ? 1 : 0), "", "", "");
            ((CardHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a5(!z16);
        } else if ("key_web_jump_show_reactive_request".equals(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("IntimateQIPCModule", 2, "onCall KEY_WEB_JUMP_SHOW_REACTIVE_REQUEST");
            }
            g.p(qQAppInterface, qQAppInterface.getApp(), bundle.getInt("key_web_jump_show_reactive_entry_value"));
        }
        return null;
    }
}
