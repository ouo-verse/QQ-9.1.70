package com.tencent.mobileqq.qqsomonitor;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqsomonitor.api.ISoMonitorIPCModuleApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.File;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    private static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final c f274730a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37193);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f274730a = new c(ISoMonitorIPCModuleApi.NAME);
            }
        }
    }

    c(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    public static c b() {
        return a.f274730a;
    }

    private EIPCResult c(Bundle bundle, int i3) {
        String string = bundle.getString(ISoMonitorIPCModuleApi.BUNDLE_KEY_SO_FILE_PATH);
        if (TextUtils.isEmpty(string)) {
            QLog.d("SoMonitor.SoMonitorIPCModule", 1, "[handleGetSoFileInfo] soFileName is empty!");
            return EIPCResult.createResult(-102, null);
        }
        com.tencent.mobileqq.qqsomonitor.a d16 = f.d(BaseApplication.getContext(), new File(string));
        if (d16 == null) {
            QLog.d("SoMonitor.SoMonitorIPCModule", 1, "[handleGetSoFileInfo] soFileInfo is null!");
            return EIPCResult.createSuccessResult(null);
        }
        String json = new Gson().toJson(d16);
        Bundle bundle2 = new Bundle();
        bundle2.putString(ISoMonitorIPCModuleApi.BUNDLE_KEY_SO_FILE_INFO, json);
        return EIPCResult.createSuccessResult(bundle2);
    }

    private EIPCResult d(Bundle bundle, int i3) {
        String string = bundle.getString(ISoMonitorIPCModuleApi.BUNDLE_KEY_SO_FILE_INFO);
        if (TextUtils.isEmpty(string)) {
            QLog.d("SoMonitor.SoMonitorIPCModule", 1, "[handleRegisterSoFileInfo] soFileInfoString is empty!");
        }
        if (f.k(BaseApplication.getContext(), string)) {
            return EIPCResult.createSuccessResult(null);
        }
        return EIPCResult.createResult(-102, null);
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        QLog.d("SoMonitor.SoMonitorIPCModule", 1, "[onCall], action = " + str);
        if (TextUtils.equals(str, ISoMonitorIPCModuleApi.ACTION_REGISTER_SO_FILE_INFO)) {
            return d(bundle, i3);
        }
        if (TextUtils.equals(str, ISoMonitorIPCModuleApi.ACTION_GET_SO_FILE_INFO)) {
            return c(bundle, i3);
        }
        return EIPCResult.UNKNOW_RESULT;
    }
}
