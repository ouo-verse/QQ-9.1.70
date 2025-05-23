package com.tencent.mobileqq.qqgift.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    private static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static a f264909a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29398);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f264909a = new a(null);
            }
        }
    }

    /* synthetic */ a(C8338a c8338a) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) c8338a);
    }

    public static a b() {
        return b.f264909a;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQGiftServerIPCModule", 2, "action = " + str);
        }
        if (bundle == null) {
            QLog.d("QQGiftServerIPCModule", 2, "QQGiftServerIPCModule Err params = null, action = " + str);
            return null;
        }
        if (str.equals("action_notify_recharge_callback")) {
            ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(bundle.getInt("params_key_business_id", 0)).f().a(bundle.getInt("params_key_callback_key", 0), bundle.getBoolean("params_key_success"), bundle.getInt("params_key_code", 0), bundle.getString("params_key_msg", ""));
        }
        return null;
    }

    a() {
        super("QQGiftServerIPCModule");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
