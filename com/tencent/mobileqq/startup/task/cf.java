package com.tencent.mobileqq.startup.task;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.gateway.localphone.ecdh.api.IECDHServiceApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelSetter;
import com.tencent.qqnt.kernel.nativeinterface.IKernelECDHService;
import com.tencent.qqnt.startup.task.NtTask;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class cf extends NtTask {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f289831d;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements com.tencent.qqnt.kernel.api.u {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cf.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.api.u
        public void a(@NonNull AppRuntime appRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
                return;
            }
            QLog.d("SubKernelInitTask", 1, "onKernelInitComplete");
            try {
                QLog.d("SubKernelInitTask", 2, "onKernelInitComplete set kernel debug");
                IKernelECDHService eCDHService = ((IECDHServiceApi) QRoute.api(IECDHServiceApi.class)).getECDHService();
                if (eCDHService != null) {
                    eCDHService.setIsDebug(((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion());
                }
            } catch (Exception e16) {
                QLog.e("SubKernelInitTask", 1, "onKernelInitComplete set Debug Mode Fail :" + e16);
            }
        }

        @Override // com.tencent.qqnt.kernel.api.u
        public void b(@NonNull AppRuntime appRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
            } else {
                QLog.d("SubKernelInitTask", 1, "onKernelSessionCreated");
            }
        }
    }

    public cf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f289831d = new AtomicBoolean(false);
        }
    }

    @Override // com.tencent.qqnt.startup.task.NtTask
    public boolean blockUntilFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NonNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        int i3 = MobileQQ.sProcessId;
        if (i3 != 1 && i3 != 4 && this.f289831d.compareAndSet(false, true)) {
            QLog.i("SubKernelInitTask", 1, "init kernel");
            ((IKernelSetter) QRoute.api(IKernelSetter.class)).getAccountCallback(new a());
        }
    }
}
