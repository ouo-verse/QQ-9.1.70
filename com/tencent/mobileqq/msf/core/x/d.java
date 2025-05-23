package com.tencent.mobileqq.msf.core.x;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int A() {
        com.tencent.mobileqq.msf.core.f0.c.e.f fVar = (com.tencent.mobileqq.msf.core.f0.c.e.f) MsfService.getCore().getConfigManager(c.f250223r);
        if (fVar == null) {
            if (BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
                return 1;
            }
            return 5;
        }
        return fVar.a();
    }

    public static int A0() {
        com.tencent.mobileqq.msf.core.f0.c.e.i iVar = (com.tencent.mobileqq.msf.core.f0.c.e.i) MsfService.getCore().getConfigManager(c.f250214i);
        if (iVar == null) {
            return 500;
        }
        return iVar.b();
    }

    public static boolean B() {
        com.tencent.mobileqq.msf.core.f0.c.e.h hVar = (com.tencent.mobileqq.msf.core.f0.c.e.h) MsfService.getCore().getConfigManager(c.f250221p);
        if (hVar == null) {
            return false;
        }
        return hVar.c();
    }

    public static int B0() {
        com.tencent.mobileqq.msf.core.f0.c.e.i iVar = (com.tencent.mobileqq.msf.core.f0.c.e.i) MsfService.getCore().getConfigManager(c.f250214i);
        if (iVar == null) {
            return 1500;
        }
        return iVar.c();
    }

    public static int C() {
        com.tencent.mobileqq.msf.core.f0.c.e.h hVar = (com.tencent.mobileqq.msf.core.f0.c.e.h) MsfService.getCore().getConfigManager(c.f250221p);
        if (hVar == null) {
            return 3000;
        }
        return hVar.a();
    }

    public static int C0() {
        l lVar = (l) MsfService.getCore().getConfigManager(c.f250209d);
        if (lVar == null) {
            return 10000;
        }
        return lVar.f();
    }

    public static HashMap<String, Integer> D() {
        com.tencent.mobileqq.msf.core.f0.c.e.h hVar = (com.tencent.mobileqq.msf.core.f0.c.e.h) MsfService.getCore().getConfigManager(c.f250221p);
        if (hVar == null) {
            return new HashMap<>();
        }
        return hVar.b();
    }

    public static int D0() {
        com.tencent.mobileqq.msf.core.f0.c.e.n nVar = (com.tencent.mobileqq.msf.core.f0.c.e.n) MsfService.getCore().getConfigManager(c.f250217l);
        if (nVar == null) {
            return 3;
        }
        return nVar.h();
    }

    public static int E() {
        com.tencent.mobileqq.msf.core.f0.c.e.k kVar = (com.tencent.mobileqq.msf.core.f0.c.e.k) MsfService.getCore().getConfigManager(c.f250222q);
        if (kVar == null) {
            return 3;
        }
        return kVar.a();
    }

    public static int E0() {
        com.tencent.mobileqq.msf.core.f0.c.e.n nVar = (com.tencent.mobileqq.msf.core.f0.c.e.n) MsfService.getCore().getConfigManager(c.f250217l);
        if (nVar == null) {
            return 0;
        }
        return nVar.i();
    }

    public static Boolean F() {
        com.tencent.mobileqq.msf.core.f0.c.e.k kVar = (com.tencent.mobileqq.msf.core.f0.c.e.k) MsfService.getCore().getConfigManager(c.f250222q);
        if (kVar == null) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(kVar.b());
    }

    public static boolean F0() {
        com.tencent.mobileqq.msf.core.f0.c.e.l lVar = (com.tencent.mobileqq.msf.core.f0.c.e.l) MsfService.getCore().getConfigManager(c.f250215j);
        if (lVar == null) {
            return true;
        }
        return lVar.a();
    }

    public static HashMap<String, Integer> G() {
        com.tencent.mobileqq.msf.core.f0.c.e.a aVar = (com.tencent.mobileqq.msf.core.f0.c.e.a) MsfService.getCore().getConfigManager(c.f250225t);
        if (aVar == null) {
            return new HashMap<>();
        }
        return aVar.a();
    }

    public static int G0() {
        com.tencent.mobileqq.msf.core.f0.c.e.l lVar = (com.tencent.mobileqq.msf.core.f0.c.e.l) MsfService.getCore().getConfigManager(c.f250215j);
        if (lVar == null) {
            return 20;
        }
        return lVar.b();
    }

    public static boolean H() {
        k kVar = (k) MsfService.getCore().getConfigManager(c.f250227v);
        if (kVar == null) {
            return false;
        }
        return kVar.c();
    }

    public static int H0() {
        com.tencent.mobileqq.msf.core.f0.c.e.l lVar = (com.tencent.mobileqq.msf.core.f0.c.e.l) MsfService.getCore().getConfigManager(c.f250215j);
        if (lVar == null) {
            return 1;
        }
        return lVar.c();
    }

    public static Boolean I() {
        k kVar = (k) MsfService.getCore().getConfigManager(c.f250227v);
        if (kVar == null) {
            return Boolean.TRUE;
        }
        return Boolean.valueOf(kVar.d());
    }

    public static int I0() {
        com.tencent.mobileqq.msf.core.f0.c.e.l lVar = (com.tencent.mobileqq.msf.core.f0.c.e.l) MsfService.getCore().getConfigManager(c.f250215j);
        if (lVar == null) {
            return 8;
        }
        return lVar.d();
    }

    public static int J() {
        k kVar = (k) MsfService.getCore().getConfigManager(c.f250227v);
        if (kVar == null) {
            return 500;
        }
        return kVar.e();
    }

    public static int J0() {
        com.tencent.mobileqq.msf.core.f0.c.e.l lVar = (com.tencent.mobileqq.msf.core.f0.c.e.l) MsfService.getCore().getConfigManager(c.f250215j);
        if (lVar == null) {
            return 15;
        }
        return lVar.e();
    }

    public static int K() {
        k kVar = (k) MsfService.getCore().getConfigManager(c.f250227v);
        if (kVar == null) {
            return 6000;
        }
        return kVar.f();
    }

    public static int K0() {
        com.tencent.mobileqq.msf.core.f0.c.e.l lVar = (com.tencent.mobileqq.msf.core.f0.c.e.l) MsfService.getCore().getConfigManager(c.f250215j);
        if (lVar == null) {
            return 3;
        }
        return lVar.f();
    }

    public static int L() {
        k kVar = (k) MsfService.getCore().getConfigManager(c.f250227v);
        if (kVar == null) {
            return 500;
        }
        return kVar.g();
    }

    public static int L0() {
        com.tencent.mobileqq.msf.core.f0.c.e.l lVar = (com.tencent.mobileqq.msf.core.f0.c.e.l) MsfService.getCore().getConfigManager(c.f250215j);
        if (lVar == null) {
            return 3;
        }
        return lVar.g();
    }

    public static int M() {
        k kVar = (k) MsfService.getCore().getConfigManager(c.f250227v);
        if (kVar == null) {
            return 5000;
        }
        return kVar.a();
    }

    public static int M0() {
        com.tencent.mobileqq.msf.core.f0.c.e.l lVar = (com.tencent.mobileqq.msf.core.f0.c.e.l) MsfService.getCore().getConfigManager(c.f250215j);
        if (lVar == null) {
            return 2;
        }
        return lVar.h();
    }

    public static int N() {
        k kVar = (k) MsfService.getCore().getConfigManager(c.f250227v);
        if (kVar == null) {
            return 180000;
        }
        return kVar.h();
    }

    public static boolean N0() {
        com.tencent.mobileqq.msf.core.f0.c.e.m mVar = (com.tencent.mobileqq.msf.core.f0.c.e.m) MsfService.getCore().getConfigManager(c.f250216k);
        if (mVar == null) {
            return true;
        }
        return mVar.a();
    }

    public static int O() {
        com.tencent.mobileqq.msf.core.h0.b bVar = (com.tencent.mobileqq.msf.core.h0.b) MsfService.getCore().getConfigManager(c.f250218m);
        if (bVar == null) {
            return 60000;
        }
        return bVar.a();
    }

    public static int O0() {
        com.tencent.mobileqq.msf.core.f0.c.e.m mVar = (com.tencent.mobileqq.msf.core.f0.c.e.m) MsfService.getCore().getConfigManager(c.f250216k);
        if (mVar == null) {
            return 8;
        }
        return mVar.b();
    }

    public static int P() {
        com.tencent.mobileqq.msf.core.h0.b bVar = (com.tencent.mobileqq.msf.core.h0.b) MsfService.getCore().getConfigManager(c.f250218m);
        if (bVar == null) {
            return 8000;
        }
        return bVar.b();
    }

    public static int P0() {
        com.tencent.mobileqq.msf.core.f0.c.e.m mVar = (com.tencent.mobileqq.msf.core.f0.c.e.m) MsfService.getCore().getConfigManager(c.f250216k);
        if (mVar == null) {
            return 15;
        }
        return mVar.c();
    }

    public static int Q() {
        com.tencent.mobileqq.msf.core.h0.b bVar = (com.tencent.mobileqq.msf.core.h0.b) MsfService.getCore().getConfigManager(c.f250218m);
        if (bVar == null) {
            return 8000;
        }
        return bVar.c();
    }

    public static int Q0() {
        com.tencent.mobileqq.msf.core.f0.c.e.m mVar = (com.tencent.mobileqq.msf.core.f0.c.e.m) MsfService.getCore().getConfigManager(c.f250216k);
        if (mVar == null) {
            return 3;
        }
        return mVar.d();
    }

    public static int R() {
        com.tencent.mobileqq.msf.core.h0.b bVar = (com.tencent.mobileqq.msf.core.h0.b) MsfService.getCore().getConfigManager(c.f250218m);
        if (bVar == null) {
            return 8000;
        }
        return bVar.d();
    }

    public static int R0() {
        com.tencent.mobileqq.msf.core.f0.c.e.m mVar = (com.tencent.mobileqq.msf.core.f0.c.e.m) MsfService.getCore().getConfigManager(c.f250216k);
        if (mVar == null) {
            return 3;
        }
        return mVar.e();
    }

    public static int S() {
        com.tencent.mobileqq.msf.core.h0.b bVar = (com.tencent.mobileqq.msf.core.h0.b) MsfService.getCore().getConfigManager(c.f250218m);
        if (bVar == null) {
            return 300000;
        }
        return bVar.e();
    }

    public static int S0() {
        com.tencent.mobileqq.msf.core.f0.c.e.m mVar = (com.tencent.mobileqq.msf.core.f0.c.e.m) MsfService.getCore().getConfigManager(c.f250216k);
        if (mVar == null) {
            return 2;
        }
        return mVar.f();
    }

    public static int T() {
        com.tencent.mobileqq.msf.core.h0.b bVar = (com.tencent.mobileqq.msf.core.h0.b) MsfService.getCore().getConfigManager(c.f250218m);
        if (bVar == null) {
            return 8000;
        }
        return bVar.f();
    }

    public static int T0() {
        l lVar = (l) MsfService.getCore().getConfigManager(c.f250209d);
        if (lVar == null) {
            return 1;
        }
        return lVar.g();
    }

    public static int U() {
        com.tencent.mobileqq.msf.core.f0.c.e.g gVar = (com.tencent.mobileqq.msf.core.f0.c.e.g) MsfService.getCore().getConfigManager(c.f250213h);
        if (gVar == null) {
            return 6000;
        }
        return gVar.c();
    }

    public static int U0() {
        com.tencent.mobileqq.msf.core.f0.c.e.i iVar = (com.tencent.mobileqq.msf.core.f0.c.e.i) MsfService.getCore().getConfigManager(c.f250214i);
        if (iVar == null) {
            return 1000;
        }
        return iVar.d();
    }

    public static int V() {
        com.tencent.mobileqq.msf.core.f0.c.e.d dVar = (com.tencent.mobileqq.msf.core.f0.c.e.d) MsfService.getCore().getConfigManager(c.f250219n);
        if (dVar == null) {
            return 30;
        }
        return dVar.a();
    }

    public static int V0() {
        com.tencent.mobileqq.msf.core.f0.c.e.i iVar = (com.tencent.mobileqq.msf.core.f0.c.e.i) MsfService.getCore().getConfigManager(c.f250214i);
        if (iVar == null) {
            return 1500;
        }
        return iVar.e();
    }

    public static int W() {
        com.tencent.mobileqq.msf.core.f0.c.e.d dVar = (com.tencent.mobileqq.msf.core.f0.c.e.d) MsfService.getCore().getConfigManager(c.f250219n);
        if (dVar == null) {
            return 60000;
        }
        return dVar.b();
    }

    public static int W0() {
        n nVar = (n) MsfService.getCore().getConfigManager(c.f250210e);
        if (nVar == null) {
            return 12;
        }
        return nVar.a();
    }

    public static int X() {
        com.tencent.mobileqq.msf.core.f0.c.e.d dVar = (com.tencent.mobileqq.msf.core.f0.c.e.d) MsfService.getCore().getConfigManager(c.f250219n);
        if (dVar == null) {
            return 60000;
        }
        return dVar.c();
    }

    public static int X0() {
        n nVar = (n) MsfService.getCore().getConfigManager(c.f250210e);
        if (nVar == null) {
            return 5;
        }
        return nVar.b();
    }

    public static int Y() {
        com.tencent.mobileqq.msf.core.f0.c.e.g gVar = (com.tencent.mobileqq.msf.core.f0.c.e.g) MsfService.getCore().getConfigManager(c.f250213h);
        if (gVar == null) {
            return 10;
        }
        return gVar.d();
    }

    public static boolean Y0() {
        com.tencent.mobileqq.msf.core.j jVar = (com.tencent.mobileqq.msf.core.j) MsfService.getCore().getConfigManager(c.f250208c);
        if (jVar == null) {
            return false;
        }
        if (BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && !jVar.d()) {
            return false;
        }
        return true;
    }

    public static int Z() {
        com.tencent.mobileqq.msf.core.f0.c.e.g gVar = (com.tencent.mobileqq.msf.core.f0.c.e.g) MsfService.getCore().getConfigManager(c.f250213h);
        if (gVar == null) {
            return 1000;
        }
        return gVar.e();
    }

    public static boolean Z0() {
        return !BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion();
    }

    public static void a(@NonNull ToServiceMsg toServiceMsg) {
        int intValue = ((Integer) toServiceMsg.getAttribute(BaseConstants.KEY_CONFIG_MANAGER_ID, -1)).intValue();
        if (intValue == -1) {
            QLog.e("MSFConfig", 1, "[onUpdateConfig] with error config managerID");
            return;
        }
        f configManager = MsfService.getCore().getConfigManager(intValue);
        if (configManager == null) {
            QLog.e("MSFConfig", 1, "[onUpdateConfig] with null config");
        } else {
            configManager.a((String) toServiceMsg.getAttribute(BaseConstants.KEY_CONFIG_CONTENT, ""));
        }
    }

    public static int a0() {
        com.tencent.mobileqq.msf.core.f0.c.e.g gVar = (com.tencent.mobileqq.msf.core.f0.c.e.g) MsfService.getCore().getConfigManager(c.f250213h);
        if (gVar == null) {
            return 3072;
        }
        return gVar.f();
    }

    public static boolean a1() {
        com.tencent.mobileqq.msf.core.h0.b bVar = (com.tencent.mobileqq.msf.core.h0.b) MsfService.getCore().getConfigManager(c.f250218m);
        if (bVar == null) {
            return false;
        }
        return bVar.h();
    }

    public static boolean b() {
        com.tencent.mobileqq.msf.core.j jVar = (com.tencent.mobileqq.msf.core.j) MsfService.getCore().getConfigManager(c.f250208c);
        if (jVar == null) {
            return false;
        }
        return jVar.b();
    }

    public static int b0() {
        com.tencent.mobileqq.msf.core.f0.c.e.g gVar = (com.tencent.mobileqq.msf.core.f0.c.e.g) MsfService.getCore().getConfigManager(c.f250213h);
        if (gVar == null) {
            return 300;
        }
        return gVar.g();
    }

    public static boolean b1() {
        com.tencent.mobileqq.msf.core.h0.b bVar = (com.tencent.mobileqq.msf.core.h0.b) MsfService.getCore().getConfigManager(c.f250218m);
        if (bVar == null) {
            return false;
        }
        return bVar.g();
    }

    public static int c() {
        com.tencent.mobileqq.msf.core.f0.c.e.n nVar = (com.tencent.mobileqq.msf.core.f0.c.e.n) MsfService.getCore().getConfigManager(c.f250217l);
        if (nVar == null) {
            return 45;
        }
        return nVar.a();
    }

    public static boolean c0() {
        com.tencent.mobileqq.msf.core.f0.c.e.e eVar = (com.tencent.mobileqq.msf.core.f0.c.e.e) MsfService.getCore().getConfigManager(c.f250212g);
        if (eVar == null) {
            return true;
        }
        return eVar.a();
    }

    public static boolean c1() {
        j jVar = (j) MsfService.getCore().getConfigManager(c.f250211f);
        if (jVar == null) {
            return false;
        }
        return jVar.a();
    }

    public static HashMap<String, Boolean> d() {
        com.tencent.mobileqq.msf.core.f0.c.e.c cVar = (com.tencent.mobileqq.msf.core.f0.c.e.c) MsfService.getCore().getConfigManager(c.f250220o);
        if (cVar == null) {
            return new HashMap<>();
        }
        return cVar.a();
    }

    public static int d0() {
        com.tencent.mobileqq.msf.core.f0.c.e.e eVar = (com.tencent.mobileqq.msf.core.f0.c.e.e) MsfService.getCore().getConfigManager(c.f250212g);
        if (eVar == null) {
            return 8;
        }
        return eVar.b();
    }

    public static boolean d1() {
        n nVar = (n) MsfService.getCore().getConfigManager(c.f250210e);
        if (nVar == null) {
            return false;
        }
        return nVar.c();
    }

    public static int e() {
        com.tencent.mobileqq.msf.core.f0.c.e.n nVar = (com.tencent.mobileqq.msf.core.f0.c.e.n) MsfService.getCore().getConfigManager(c.f250217l);
        if (nVar == null) {
            return 300;
        }
        return nVar.b();
    }

    public static int e0() {
        com.tencent.mobileqq.msf.core.f0.c.e.e eVar = (com.tencent.mobileqq.msf.core.f0.c.e.e) MsfService.getCore().getConfigManager(c.f250212g);
        if (eVar == null) {
            return 15;
        }
        return eVar.c();
    }

    public static int f() {
        com.tencent.mobileqq.msf.core.f0.c.e.n nVar = (com.tencent.mobileqq.msf.core.f0.c.e.n) MsfService.getCore().getConfigManager(c.f250217l);
        if (nVar == null) {
            return 15;
        }
        return nVar.c();
    }

    public static int f0() {
        com.tencent.mobileqq.msf.core.f0.c.e.e eVar = (com.tencent.mobileqq.msf.core.f0.c.e.e) MsfService.getCore().getConfigManager(c.f250212g);
        if (eVar == null) {
            return 3;
        }
        return eVar.d();
    }

    public static int g() {
        com.tencent.mobileqq.msf.core.f0.c.e.n nVar = (com.tencent.mobileqq.msf.core.f0.c.e.n) MsfService.getCore().getConfigManager(c.f250217l);
        if (nVar == null) {
            return 1;
        }
        return nVar.d();
    }

    public static int g0() {
        com.tencent.mobileqq.msf.core.f0.c.e.e eVar = (com.tencent.mobileqq.msf.core.f0.c.e.e) MsfService.getCore().getConfigManager(c.f250212g);
        if (eVar == null) {
            return 3;
        }
        return eVar.e();
    }

    public static int h() {
        com.tencent.mobileqq.msf.core.j jVar = (com.tencent.mobileqq.msf.core.j) MsfService.getCore().getConfigManager(c.f250208c);
        if (jVar == null) {
            return 60;
        }
        return jVar.c();
    }

    public static int h0() {
        com.tencent.mobileqq.msf.core.f0.c.e.e eVar = (com.tencent.mobileqq.msf.core.f0.c.e.e) MsfService.getCore().getConfigManager(c.f250212g);
        if (eVar == null) {
            return 2;
        }
        return eVar.f();
    }

    public static int i() {
        com.tencent.mobileqq.msf.core.f0.c.e.b bVar = (com.tencent.mobileqq.msf.core.f0.c.e.b) MsfService.getCore().getConfigManager(c.f250226u);
        if (bVar == null) {
            return 45;
        }
        return bVar.a();
    }

    public static Boolean i0() {
        k kVar = (k) MsfService.getCore().getConfigManager(c.f250227v);
        if (kVar == null) {
            return Boolean.valueOf(!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion());
        }
        return Boolean.valueOf(kVar.b());
    }

    public static int j() {
        com.tencent.mobileqq.msf.core.f0.c.e.b bVar = (com.tencent.mobileqq.msf.core.f0.c.e.b) MsfService.getCore().getConfigManager(c.f250226u);
        if (bVar == null) {
            return 300;
        }
        return bVar.b();
    }

    public static int j0() {
        l lVar = (l) MsfService.getCore().getConfigManager(c.f250209d);
        if (lVar == null) {
            return 100;
        }
        return lVar.d();
    }

    public static int k() {
        com.tencent.mobileqq.msf.core.f0.c.e.b bVar = (com.tencent.mobileqq.msf.core.f0.c.e.b) MsfService.getCore().getConfigManager(c.f250226u);
        if (bVar == null) {
            return 15;
        }
        return bVar.c();
    }

    public static int k0() {
        l lVar = (l) MsfService.getCore().getConfigManager(c.f250209d);
        if (lVar == null) {
            return 10000;
        }
        return lVar.e();
    }

    public static boolean l() {
        com.tencent.mobileqq.msf.core.f0.c.e.b bVar = (com.tencent.mobileqq.msf.core.f0.c.e.b) MsfService.getCore().getConfigManager(c.f250226u);
        if (bVar == null) {
            return false;
        }
        return bVar.g();
    }

    public static boolean l0() {
        com.tencent.mobileqq.msf.core.f0.c.e.g gVar = (com.tencent.mobileqq.msf.core.f0.c.e.g) MsfService.getCore().getConfigManager(c.f250213h);
        if (gVar == null) {
            return true;
        }
        return gVar.a();
    }

    public static boolean m() {
        com.tencent.mobileqq.msf.core.f0.c.e.b bVar = (com.tencent.mobileqq.msf.core.f0.c.e.b) MsfService.getCore().getConfigManager(c.f250226u);
        if (bVar == null) {
            return true;
        }
        return bVar.h();
    }

    public static double m0() {
        com.tencent.mobileqq.msf.core.f0.c.e.n nVar = (com.tencent.mobileqq.msf.core.f0.c.e.n) MsfService.getCore().getConfigManager(c.f250217l);
        if (nVar == null) {
            return 3000.0d;
        }
        return nVar.f();
    }

    public static boolean n() {
        com.tencent.mobileqq.msf.core.f0.c.e.b bVar = (com.tencent.mobileqq.msf.core.f0.c.e.b) MsfService.getCore().getConfigManager(c.f250226u);
        if (bVar == null) {
            return false;
        }
        return bVar.i();
    }

    public static int n0() {
        com.tencent.mobileqq.msf.core.f0.c.e.n nVar = (com.tencent.mobileqq.msf.core.f0.c.e.n) MsfService.getCore().getConfigManager(c.f250217l);
        if (nVar == null) {
            return 3;
        }
        return nVar.g();
    }

    public static boolean o() {
        com.tencent.mobileqq.msf.core.f0.c.e.b bVar = (com.tencent.mobileqq.msf.core.f0.c.e.b) MsfService.getCore().getConfigManager(c.f250226u);
        if (bVar == null) {
            return true;
        }
        return bVar.j();
    }

    public static boolean o0() {
        com.tencent.mobileqq.msf.core.f0.c.e.i iVar = (com.tencent.mobileqq.msf.core.f0.c.e.i) MsfService.getCore().getConfigManager(c.f250214i);
        if (iVar == null) {
            return true;
        }
        return iVar.a();
    }

    public static int p() {
        com.tencent.mobileqq.msf.core.f0.c.e.b bVar = (com.tencent.mobileqq.msf.core.f0.c.e.b) MsfService.getCore().getConfigManager(c.f250226u);
        if (bVar == null) {
            return 1;
        }
        return bVar.d();
    }

    public static boolean p0() {
        com.tencent.mobileqq.msf.core.f0.c.e.j jVar = (com.tencent.mobileqq.msf.core.f0.c.e.j) MsfService.getCore().getConfigManager(c.f250224s);
        if (jVar == null) {
            return !BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion();
        }
        return jVar.d();
    }

    public static int q() {
        com.tencent.mobileqq.msf.core.f0.c.e.b bVar = (com.tencent.mobileqq.msf.core.f0.c.e.b) MsfService.getCore().getConfigManager(c.f250226u);
        if (bVar == null) {
            return 1;
        }
        return bVar.e();
    }

    public static int q0() {
        com.tencent.mobileqq.msf.core.f0.c.e.j jVar = (com.tencent.mobileqq.msf.core.f0.c.e.j) MsfService.getCore().getConfigManager(c.f250224s);
        if (jVar == null) {
            return 45;
        }
        return jVar.a();
    }

    public static int r() {
        com.tencent.mobileqq.msf.core.f0.c.e.b bVar = (com.tencent.mobileqq.msf.core.f0.c.e.b) MsfService.getCore().getConfigManager(c.f250226u);
        if (bVar == null) {
            return 5;
        }
        return bVar.f();
    }

    public static int r0() {
        com.tencent.mobileqq.msf.core.f0.c.e.j jVar = (com.tencent.mobileqq.msf.core.f0.c.e.j) MsfService.getCore().getConfigManager(c.f250224s);
        if (jVar == null) {
            return 300;
        }
        return jVar.b();
    }

    public static boolean s() {
        com.tencent.mobileqq.msf.core.f0.c.e.n nVar = (com.tencent.mobileqq.msf.core.f0.c.e.n) MsfService.getCore().getConfigManager(c.f250217l);
        if (nVar == null) {
            return false;
        }
        return nVar.e();
    }

    public static int s0() {
        com.tencent.mobileqq.msf.core.f0.c.e.j jVar = (com.tencent.mobileqq.msf.core.f0.c.e.j) MsfService.getCore().getConfigManager(c.f250224s);
        if (jVar == null) {
            return 15;
        }
        return jVar.c();
    }

    public static boolean t() {
        com.tencent.mobileqq.msf.core.f0.c.e.d dVar = (com.tencent.mobileqq.msf.core.f0.c.e.d) MsfService.getCore().getConfigManager(c.f250219n);
        if (dVar == null) {
            return false;
        }
        return dVar.d();
    }

    public static int t0() {
        com.tencent.mobileqq.msf.core.f0.c.e.j jVar = (com.tencent.mobileqq.msf.core.f0.c.e.j) MsfService.getCore().getConfigManager(c.f250224s);
        if (jVar == null) {
            return 3;
        }
        return jVar.g();
    }

    public static int u() {
        l lVar = (l) MsfService.getCore().getConfigManager(c.f250209d);
        if (lVar == null) {
            return 10;
        }
        return lVar.a();
    }

    public static boolean u0() {
        com.tencent.mobileqq.msf.core.f0.c.e.j jVar = (com.tencent.mobileqq.msf.core.f0.c.e.j) MsfService.getCore().getConfigManager(c.f250224s);
        if (jVar == null) {
            return true;
        }
        return jVar.e();
    }

    public static int v() {
        l lVar = (l) MsfService.getCore().getConfigManager(c.f250209d);
        if (lVar == null) {
            return 100;
        }
        return lVar.b();
    }

    public static double v0() {
        com.tencent.mobileqq.msf.core.f0.c.e.j jVar = (com.tencent.mobileqq.msf.core.f0.c.e.j) MsfService.getCore().getConfigManager(c.f250224s);
        if (jVar == null) {
            return 3000.0d;
        }
        return jVar.f();
    }

    public static int w() {
        l lVar = (l) MsfService.getCore().getConfigManager(c.f250209d);
        if (lVar == null) {
            return 100;
        }
        return lVar.c();
    }

    public static int w0() {
        com.tencent.mobileqq.msf.core.f0.c.e.j jVar = (com.tencent.mobileqq.msf.core.f0.c.e.j) MsfService.getCore().getConfigManager(c.f250224s);
        if (jVar == null) {
            return 0;
        }
        return jVar.h();
    }

    public static boolean x() {
        com.tencent.mobileqq.msf.core.f0.c.e.g gVar = (com.tencent.mobileqq.msf.core.f0.c.e.g) MsfService.getCore().getConfigManager(c.f250213h);
        if (gVar == null) {
            return false;
        }
        return gVar.b();
    }

    public static boolean x0() {
        com.tencent.mobileqq.msf.core.f0.c.e.f fVar = (com.tencent.mobileqq.msf.core.f0.c.e.f) MsfService.getCore().getConfigManager(c.f250223r);
        if (fVar == null) {
            return true;
        }
        return fVar.c();
    }

    public static boolean y() {
        com.tencent.mobileqq.msf.core.f0.c.e.c cVar = (com.tencent.mobileqq.msf.core.f0.c.e.c) MsfService.getCore().getConfigManager(c.f250220o);
        if (cVar == null) {
            return false;
        }
        return cVar.b();
    }

    public static boolean y0() {
        com.tencent.mobileqq.msf.core.f0.c.e.f fVar = (com.tencent.mobileqq.msf.core.f0.c.e.f) MsfService.getCore().getConfigManager(c.f250223r);
        if (fVar == null) {
            return true;
        }
        return fVar.d();
    }

    public static boolean z() {
        com.tencent.mobileqq.msf.core.f0.c.e.c cVar = (com.tencent.mobileqq.msf.core.f0.c.e.c) MsfService.getCore().getConfigManager(c.f250220o);
        if (cVar == null) {
            return true;
        }
        return cVar.c();
    }

    public static int z0() {
        com.tencent.mobileqq.msf.core.f0.c.e.f fVar = (com.tencent.mobileqq.msf.core.f0.c.e.f) MsfService.getCore().getConfigManager(c.f250223r);
        if (fVar == null) {
            return 2000;
        }
        return fVar.b();
    }

    public static boolean a() {
        com.tencent.mobileqq.msf.core.j jVar = (com.tencent.mobileqq.msf.core.j) MsfService.getCore().getConfigManager(c.f250208c);
        if (jVar == null) {
            return false;
        }
        return jVar.a();
    }

    public static boolean a(String str) {
        j jVar = (j) MsfService.getCore().getConfigManager(c.f250211f);
        if (jVar == null) {
            return false;
        }
        return jVar.b(str);
    }
}
