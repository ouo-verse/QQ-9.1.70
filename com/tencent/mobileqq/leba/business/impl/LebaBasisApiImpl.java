package com.tencent.mobileqq.leba.business.impl;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.leba.business.ILebaBasisApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LebaBasisApiImpl implements ILebaBasisApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "LebaBasisApiImpl";

    public LebaBasisApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.leba.business.ILebaBasisApi
    public boolean isLocaleUpdatedByUser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return LocaleManager.isLocaleUpdatedByUser();
    }

    @Override // com.tencent.mobileqq.leba.business.ILebaBasisApi
    public void jumpByScheme(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) str);
            return;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            ax c16 = bi.c((QQAppInterface) runtime, context, str);
            if (c16 != null) {
                c16.b();
                return;
            } else {
                QLog.i(TAG, 1, "jumpAction jAction == null");
                return;
            }
        }
        QLog.i(TAG, 1, "jumpByScheme app !instanceof QQAppInterface");
    }
}
