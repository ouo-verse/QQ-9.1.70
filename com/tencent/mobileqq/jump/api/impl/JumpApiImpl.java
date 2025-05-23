package com.tencent.mobileqq.jump.api.impl;

import android.content.Context;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.jump.api.IJumpApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class JumpApiImpl implements IJumpApi {
    static IPatchRedirector $redirector_;

    public JumpApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.jump.api.IJumpApi
    public void doJumpAction(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) str);
            return;
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (!(waitAppRuntime instanceof QQAppInterface)) {
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) waitAppRuntime;
        if (qQAppInterface == null) {
            QLog.e(com.tencent.mobileqq.guild.nt.misc.api.impl.JumpApiImpl.TAG, 1, "getApp is null");
            return;
        }
        ax c16 = bi.c(qQAppInterface, context, str);
        if (c16 != null) {
            c16.b();
            return;
        }
        QLog.e(com.tencent.mobileqq.guild.nt.misc.api.impl.JumpApiImpl.TAG, 2, "Push toast content clicked, but jumpAction is null! jumpUrl: " + str);
    }

    @Override // com.tencent.mobileqq.jump.api.IJumpApi
    public String getJumpActionQCircle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "qcircle";
    }

    @Override // com.tencent.mobileqq.jump.api.IJumpApi
    public Class getJumpActivityClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return JumpActivity.class;
    }
}
