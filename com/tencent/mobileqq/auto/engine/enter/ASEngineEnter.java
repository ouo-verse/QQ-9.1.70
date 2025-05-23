package com.tencent.mobileqq.auto.engine.enter;

import android.os.Handler;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.concurrent.ConcurrentHashMap;
import uq3.c;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ASEngineEnter {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Handler f199834a;

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, s91.a> f199835b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements s91.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // s91.a
        public void a(ASEnterBean aSEnterBean) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) aSEnterBean);
            } else {
                QLog.d(ASDynamicEngine.q(aSEnterBean.getBusinessKey()), 1, "do thing native");
            }
        }

        @Override // s91.a
        public void b(ASEnterBean aSEnterBean) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aSEnterBean);
            } else {
                QLog.d(ASDynamicEngine.q(aSEnterBean.getBusinessKey()), 1, "do thing native");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40327);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f199835b = new ConcurrentHashMap<>();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("ASPluginEnter");
        baseHandlerThread.start();
        f199834a = new Handler(baseHandlerThread.getLooper());
    }

    public static void b(ASEnterBean aSEnterBean) {
        if (c.h5()) {
            c(aSEnterBean);
        } else {
            f199834a.post(new Runnable() { // from class: com.tencent.mobileqq.auto.engine.enter.ASEngineEnter.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ASEnterBean.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        ASEngineEnter.c(ASEnterBean.this);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(ASEnterBean aSEnterBean) {
        s91.a d16;
        if (aSEnterBean == null) {
            return;
        }
        ConcurrentHashMap<String, s91.a> concurrentHashMap = f199835b;
        if (concurrentHashMap.containsKey(aSEnterBean.getBusinessKey())) {
            d16 = concurrentHashMap.get(aSEnterBean.getBusinessKey());
        } else {
            d16 = d(aSEnterBean);
        }
        if (d16 == null) {
            QLog.d(ASDynamicEngine.q(aSEnterBean.getBusinessKey()), 1, "their is no enter");
            return;
        }
        concurrentHashMap.put(aSEnterBean.getBusinessKey(), d16);
        if (!com.tencent.mobileqq.auto.engine.loader.a.e(aSEnterBean.getBusinessKey()).v() && !com.tencent.mobileqq.auto.engine.loader.a.e(aSEnterBean.getBusinessKey()).f() && !com.tencent.mobileqq.auto.engine.loader.a.e(aSEnterBean.getBusinessKey()).j().j()) {
            d16.b(aSEnterBean);
        } else {
            d16.a(aSEnterBean);
        }
    }

    private static s91.a d(ASEnterBean aSEnterBean) {
        s91.a aVar;
        String businessKey = aSEnterBean.getBusinessKey();
        businessKey.hashCode();
        if (!businessKey.equals(ASEngineConstants.BusinessKey.BUSINESS_ECOMMERCE)) {
            if (!businessKey.equals(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE)) {
                return new a();
            }
            aVar = new u91.a(com.tencent.mobileqq.auto.engine.loader.a.e(aSEnterBean.getBusinessKey()).k());
        } else {
            aVar = new t91.a(com.tencent.mobileqq.auto.engine.loader.a.e(aSEnterBean.getBusinessKey()).k());
        }
        return aVar;
    }
}
