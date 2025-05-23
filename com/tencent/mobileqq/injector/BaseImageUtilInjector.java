package com.tencent.mobileqq.injector;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.UtilApi;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class BaseImageUtilInjector implements com.tencent.mobileqq.inject.c {
    static IPatchRedirector $redirector_;

    public BaseImageUtilInjector() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.inject.c
    public void a(String str, Context context, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, context, Boolean.valueOf(z16));
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ThreadManagerV2.post(new Runnable(peekAppRuntime, str, z16) { // from class: com.tencent.mobileqq.injector.BaseImageUtilInjector.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ AppRuntime f238069d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f238070e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ boolean f238071f;

                {
                    this.f238069d = peekAppRuntime;
                    this.f238070e = str;
                    this.f238071f = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, BaseImageUtilInjector.this, peekAppRuntime, str, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f238069d.getAccount(), this.f238070e, this.f238071f, 0L, 0L, new HashMap<>(), "");
                    }
                }
            }, 2, null, false);
        }
    }

    @Override // com.tencent.mobileqq.inject.c
    public boolean isActiveReporting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return UtilApi.util.isActiveReporting();
    }
}
