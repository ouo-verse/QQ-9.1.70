package com.tencent.mobileqq.auto.engine.loader;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import uq3.p;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.auto.engine.loader.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C7428a extends ASDynamicEngine.a {
        static IPatchRedirector $redirector_;

        C7428a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine.a
        List<String> b() {
            ArrayList arrayList = new ArrayList();
            arrayList.add("ecommerce");
            arrayList.add("ecplugin");
            return arrayList;
        }

        @Override // com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine.a
        boolean f() {
            boolean m3 = t91.a.m();
            boolean B0 = uq3.c.B0(ASEngineConstants.BusinessKey.BUSINESS_ECOMMERCE);
            if (QLog.isColorLevel()) {
                QLog.d("ASDynamicEngineFactory", 2, "createEcommerceEngine: enablePluginConfig=" + m3 + ", forceNativeWns=" + B0);
            }
            if (m3 && !B0) {
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b extends ASDynamicEngine.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine.a
        List<String> b() {
            ArrayList arrayList = new ArrayList();
            arrayList.add("qcircle");
            return arrayList;
        }

        @Override // com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine.a
        boolean f() {
            return uq3.c.B0(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE);
        }

        @Override // com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine.a
        public boolean g(ASEnterBean aSEnterBean) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aSEnterBean)).booleanValue();
            }
            boolean a16 = p.a("qcircle_enable_use_native_fragment_v3");
            QLog.d("ASDynamicEngineFactory", 1, "useNativeFragment result:" + a16 + " |allowLandscape:" + ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isAllowLandscape());
            return a16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class c extends ASDynamicEngine.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine.a
        List<String> b() {
            return new ArrayList();
        }

        @Override // com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine.a
        boolean f() {
            return true;
        }
    }

    private static ASDynamicEngine a(String str) {
        str.hashCode();
        if (!str.equals(ASEngineConstants.BusinessKey.BUSINESS_ECOMMERCE)) {
            if (!str.equals(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE)) {
                return b();
            }
            return d();
        }
        return c();
    }

    private static ASDynamicEngine b() {
        return new c().c("unKnowBusiness").d(false).e(false).a();
    }

    private static ASDynamicEngine c() {
        return new C7428a().c(ASEngineConstants.BusinessKey.BUSINESS_ECOMMERCE).d(true).e(false).a();
    }

    private static ASDynamicEngine d() {
        return new b().c(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE).d(true).e(false).a();
    }

    public static synchronized ASDynamicEngine e(@NonNull String str) {
        ASDynamicEngine l3;
        synchronized (a.class) {
            l3 = ASDynamicEngine.l(str);
            if (l3 == null) {
                l3 = a(str);
            }
        }
        return l3;
    }
}
