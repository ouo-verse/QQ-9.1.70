package com.tencent.mobileqq.leba.core;

import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.core.f;
import com.tencent.mobileqq.leba.data.LebaUnitedConfigHelper;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.leba.logic.LebaPluginLogic;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static volatile int f240372e;

    /* renamed from: f, reason: collision with root package name */
    private static final Object f240373f;

    /* renamed from: g, reason: collision with root package name */
    protected static volatile e f240374g;

    /* renamed from: a, reason: collision with root package name */
    public List<n> f240375a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.mobileqq.leba.business.e f240376b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f240377c;

    /* renamed from: d, reason: collision with root package name */
    public HashMap<String, n> f240378d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21286);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            f240372e = 0;
            f240373f = new Object();
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f240376b = new com.tencent.mobileqq.leba.business.e();
        this.f240377c = false;
        this.f240378d = new HashMap<>();
        this.f240375a = new ArrayList();
        f240372e = 0;
        f();
    }

    public static e a() {
        if (f240374g == null) {
            synchronized (f240373f) {
                if (f240374g == null) {
                    f240374g = new e();
                }
            }
        }
        return f240374g;
    }

    private List<n> d(AppRuntime appRuntime) {
        return LebaPluginLogic.C(appRuntime, this.f240375a).f240502a;
    }

    public List<n> b() {
        LebaPluginInfo lebaPluginInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this.f240375a) {
            for (n nVar : this.f240375a) {
                if (nVar != null && (lebaPluginInfo = nVar.f240505b) != null && lebaPluginInfo.cDataType != 1) {
                    arrayList.add(nVar);
                }
            }
        }
        f.x(arrayList);
        return arrayList;
    }

    public List<n> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        BasePluginDataManager a16 = b.a();
        if (a16 != null) {
            List<n> f16 = a16.f();
            QLog.d("LebaShowListManager", 2, "getLebaShowList size:" + f16.size());
            return f16;
        }
        return Collections.emptyList();
    }

    public n e(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (n) iPatchRedirector.redirect((short) 6, (Object) this, j3);
        }
        for (n nVar : b()) {
            if (nVar.f240505b.uiResId == j3) {
                return nVar;
            }
        }
        return null;
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f240376b.b();
        }
    }

    public boolean g(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, j3)).booleanValue();
        }
        List<n> c16 = c();
        if (c16 != null) {
            for (n nVar : c16) {
                LebaPluginInfo lebaPluginInfo = nVar.f240505b;
                if (lebaPluginInfo != null && lebaPluginInfo.uiResId == j3) {
                    return nVar.d();
                }
            }
            return false;
        }
        return false;
    }

    public List<n> h(AppRuntime appRuntime) {
        List<LebaPluginInfo> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this, (Object) appRuntime);
        }
        if (LebaUnitedConfigHelper.d()) {
            return new ArrayList();
        }
        if (appRuntime == null) {
            QLog.i("LebaShowListManager", 1, "reloadLebaItems app == null");
            return new ArrayList();
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(LogTag.LEBA_MGR, 4, String.format(Locale.getDefault(), "reloadLebaItems [%s, %s]", Boolean.valueOf(this.f240377c), appRuntime));
        }
        ArrayList arrayList = new ArrayList();
        ILebaHelperService iLebaHelperService = (ILebaHelperService) appRuntime.getRuntimeService(ILebaHelperService.class, ProcessConstant.MULTI);
        if (iLebaHelperService != null) {
            list = iLebaHelperService.getLebaConfigList();
        } else {
            QLog.d("LebaShowListManager", 1, "reloadLebaItems lebaHelperService == null");
            list = null;
        }
        if (list != null) {
            ArrayList<LebaPluginInfo> arrayList2 = new ArrayList(list);
            ArrayList arrayList3 = new ArrayList();
            for (LebaPluginInfo lebaPluginInfo : arrayList2) {
                if (lebaPluginInfo != null) {
                    n nVar = new n();
                    try {
                        nVar.f240504a = lebaPluginInfo.uiResId;
                        nVar.f240505b = lebaPluginInfo;
                        if (f.s(nVar)) {
                            this.f240378d.put(nVar.f240505b.strPkgName, nVar);
                        } else if (!this.f240376b.a(nVar)) {
                            arrayList3.add(nVar);
                        }
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d(LogTag.LEBA_MGR, 2, e16.toString());
                        }
                    }
                }
            }
            f.x(arrayList3);
            Collections.sort(arrayList3, new f.a());
            k(appRuntime, arrayList3);
            List<n> d16 = d(appRuntime);
            f.u(arrayList, d16);
            if (QLog.isColorLevel()) {
                QLog.i(LogTag.LEBA_MGR, 2, "reloadLebaItems, info.size=" + list.size() + ", alldatasize=" + this.f240375a.size() + ", pluginShowList=" + d16.size());
            }
        }
        return arrayList;
    }

    public void i(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) appRuntime);
            return;
        }
        List<n> c16 = c();
        if (c16 == null) {
            return;
        }
        for (n nVar : c16) {
            if (nVar != null) {
                if (nVar.d()) {
                    LebaPluginInfo lebaPluginInfo = nVar.f240505b;
                    if (lebaPluginInfo != null) {
                        ReportController.o(appRuntime, "CliStatus", "", "", "trends_tab", "Clk_plug_in_s", 0, 0, "1", String.valueOf(lebaPluginInfo.uiResId), "", "");
                    }
                } else {
                    LebaPluginInfo lebaPluginInfo2 = nVar.f240505b;
                    if (lebaPluginInfo2 != null) {
                        ReportController.o(appRuntime, "CliStatus", "", "", "trends_tab", "Clk_plug_in_s", 0, 0, "0", String.valueOf(lebaPluginInfo2.uiResId), "", "");
                    }
                }
            }
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        synchronized (this.f240375a) {
            this.f240375a.clear();
        }
        f240372e = 0;
    }

    public void k(AppRuntime appRuntime, List<n> list) {
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime, (Object) list);
            return;
        }
        if (LebaUnitedConfigHelper.d()) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("setAllLebaList, ");
            if (list == null) {
                size = 0;
            } else {
                size = list.size();
            }
            sb5.append(size);
            QLog.i(LogTag.LEBA_MGR, 4, sb5.toString());
        }
        LebaPluginLogic.C(appRuntime, list);
        synchronized (this.f240375a) {
            this.f240375a.clear();
            if (list != null) {
                this.f240375a.addAll(list);
            }
        }
    }
}
