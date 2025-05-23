package com.tencent.mobileqq.perf.raftkit.dump;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private b f257952d;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    private static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static c f257953a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47425);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f257953a = new c();
            }
        }
    }

    c() {
        super("PerfMonitorIPCModule");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f257952d = new b();
        }
    }

    public static c b() {
        return a.f257953a;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        if (QLog.isColorLevel()) {
            QLog.d("PerfMonitorIPCModule", 2, "PerfMonitorIPCModule : " + str);
        }
        if ("ACTION_DUMP_CPU".equals(str)) {
            this.f257952d.c();
            return null;
        }
        if ("ACTION_FAVORITE_CPU".equals(str)) {
            this.f257952d.b();
            return null;
        }
        if ("ACTION_DUMP_MEMORY".equals(str)) {
            this.f257952d.a();
            return null;
        }
        if ("ACTION_FAVORITE_MEMORY".equals(str)) {
            this.f257952d.d();
            return null;
        }
        if ("ACTION_OPEN_MEMORY_FLOAT_WINDOW".equals(str)) {
            this.f257952d.e();
            return null;
        }
        return null;
    }
}
