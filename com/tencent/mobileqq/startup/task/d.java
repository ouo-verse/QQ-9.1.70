package com.tencent.mobileqq.startup.task;

import android.text.TextUtils;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d {
    static IPatchRedirector $redirector_;

    private static void c() {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.startup.task.c
            @Override // java.lang.Runnable
            public final void run() {
                d.e();
            }
        });
    }

    public static void d() {
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null && mobileQQ.peekAppRuntime() != null && !TextUtils.isEmpty(MobileQQ.sMobileQQ.peekAppRuntime().getAccount()) && MobileQQ.sMobileQQ.peekAppRuntime().isLogin()) {
            c();
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.startup.task.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.f();
                }
            }, 128, null, false, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e() {
        try {
            if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
                return;
            }
            GdtDeviceInfoHelper.create(BaseApplication.getContext(), new GdtDeviceInfoHelper.Params());
        } catch (Throwable th5) {
            QLog.e("AdSdkInitTask", 1, "initAdDeviceInfo error! ", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f() {
        ((IVasAdvApi) QRoute.api(IVasAdvApi.class)).requestPublicAccountAd(3, "");
    }
}
