package com.tencent.mobileqq.applets;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static d f196754d;

    public d(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    public static d b() {
        if (f196754d == null) {
            synchronized (d.class) {
                if (f196754d == null) {
                    f196754d = new d("PublicAccountModule");
                }
            }
        }
        return f196754d;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        if (QLog.isColorLevel()) {
            QLog.d("PublicAccountModule", 2, "PublicAccountModule : " + str + ", " + bundle.toString(), ", " + i3);
        }
        if ("ACTION_REPORT_PUBLIC_ACCOUNT_FOLLOW_INFO_IN_WEBVIEW".equalsIgnoreCase(str)) {
            int i16 = bundle.getInt("BUNDLE_KEY_REPORT_INFO_SOURCE", -1);
            String string = bundle.getString("BUNDLE_KEY_REPORT_INFO_PUIN", "");
            boolean z16 = bundle.getBoolean("BUNDLE_KEY_REPORT_INFO_IS_FOLLOW", false);
            if (i16 != -1 && !TextUtils.isEmpty(string)) {
                if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
                    qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                } else {
                    qQAppInterface = null;
                }
                if (qQAppInterface == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("PublicAccountModule", 2, "app is null!");
                    }
                    return null;
                }
                e.c(qQAppInterface, z16, string, i16);
            } else if (QLog.isColorLevel()) {
                QLog.d("PublicAccountModule", 2, "empty error: source=", Integer.valueOf(i16), " uin=", string);
            }
        }
        return null;
    }
}
