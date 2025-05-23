package com.tencent.mobileqq.search.rich;

import com.tencent.ark.ark;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.security.ArkAppUrlChecker;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.ark.api.IArkAppLifeEvent;
import com.tencent.mobileqq.ark.api.IArkSecureReport;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.rich.ArkAppModule;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements ArkAppModule.a, ark.ApplicationCallback {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<WeakReference<f>> f283743a = new ArrayList<>();

    private f c(long j3) {
        ArkNodeContainer arkNodeContainer;
        ark.Container arkGetContainer = ark.arkGetContainer(j3);
        if (arkGetContainer == null) {
            if (QLog.isColorLevel()) {
                QLog.d("ArkNodeContainer", 2, "getArkNode, arkcontainer is null");
            }
            return null;
        }
        if (this.f283743a.size() == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("ArkNodeContainer", 2, "getArkNode, list is null");
            }
            return null;
        }
        for (int i3 = 0; i3 < this.f283743a.size(); i3++) {
            f fVar = this.f283743a.get(i3).get();
            if (fVar != null && (fVar instanceof d)) {
                arkNodeContainer = ((d) fVar).l();
            } else {
                arkNodeContainer = null;
            }
            if (arkNodeContainer != null && arkNodeContainer.getContainer() == arkGetContainer) {
                return fVar;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ArkNodeContainer", 2, "getArkNode, not found");
        }
        return null;
    }

    @Override // com.tencent.ark.ark.ApplicationCallback
    public void AppCreate(ark.Application application) {
        ((IArkAppLifeEvent) QRoute.api(IArkAppLifeEvent.class)).doAction(0, application.GetSpecific("appName"), null);
    }

    @Override // com.tencent.ark.ark.ApplicationCallback
    public void AppDestroy(ark.Application application) {
        String GetSpecific = application.GetSpecific("appName");
        ((IArkAppLifeEvent) QRoute.api(IArkAppLifeEvent.class)).doAction(1, GetSpecific, null);
        ((IArkSecureReport) QRoute.api(IArkSecureReport.class)).reportAccumulatedValidURL(GetSpecific);
    }

    @Override // com.tencent.ark.ark.ApplicationCallback
    public boolean CheckUrlLegalityCallback(ark.Application application, String str) {
        boolean z16;
        boolean z17;
        int i3;
        String GetSpecific = application.GetSpecific("appName");
        ArkAppUrlChecker urlChecker = ArkAppConfigMgr.getInstance().getUrlChecker(GetSpecific, application.GetSpecific(ark.APP_SPECIFIC_BIZSRC));
        if (urlChecker != null) {
            int checkUrlIsValidByAppResouceList = urlChecker.checkUrlIsValidByAppResouceList(str);
            if (checkUrlIsValidByAppResouceList == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                if (!ArkAppConfigMgr.getInstance().isUrlCheckEnable(GetSpecific)) {
                    QLog.e("ArkNodeContainer", 1, "ArkSafe.UrlCheck.setDisable.EngineCallback seach appName=", GetSpecific, JefsClass.INDEX_URL, com.tencent.biz.common.util.k.f(str, new String[0]), ", isValid set=true");
                    i3 = 2;
                    z16 = true;
                } else {
                    z16 = z17;
                    i3 = 1;
                }
            } else {
                z16 = z17;
                i3 = 0;
            }
            ((IArkSecureReport) QRoute.api(IArkSecureReport.class)).reportResourceURLAccess(GetSpecific, str, checkUrlIsValidByAppResouceList, i3, "");
        } else {
            z16 = true;
        }
        QLog.e("ArkNodeContainer", 1, "ArkSafe.EngineCallback search appName=", GetSpecific, JefsClass.INDEX_URL, com.tencent.biz.common.util.k.f(str, new String[0]), ", isValid=", Boolean.valueOf(z16));
        return z16;
    }

    @Override // com.tencent.ark.ark.ApplicationCallback
    public void OutputScriptError(String str, String str2) {
        String str3;
        String str4;
        if (str == null) {
            str3 = "";
        } else {
            str3 = str;
        }
        if (str2 == null) {
            str4 = "";
        } else {
            str4 = str2;
        }
        if (QLog.isColorLevel()) {
            QLog.e("ArkNodeContainer", 2, String.format("%s.script error: %s", str3, str4));
        }
        com.tencent.mobileqq.ark.g.b(null, str3, "ScriptError", 0, 0, 0L, 0L, 0L, str4, "");
    }

    @Override // com.tencent.ark.ark.ApplicationCallback
    public void RegisterModules(ark.ModuleRegister moduleRegister, ark.Application application) {
        ((IArkAPIService) QRoute.api(IArkAPIService.class)).registerModules(moduleRegister, application);
        ArkAppModule arkAppModule = new ArkAppModule(application, 0);
        arkAppModule.v(this);
        arkAppModule.m(com.tencent.mobileqq.ark.b.f199162d.get(arkAppModule.GetTypeName()));
        moduleRegister.RegCallbackWrapper(arkAppModule);
    }

    @Override // com.tencent.mobileqq.search.rich.ArkAppModule.a
    public void a(long j3, String str) {
        f c16 = c(j3);
        if (c16 != null && (c16 instanceof d)) {
            ((d) c16).p(str);
        }
    }

    @Override // com.tencent.mobileqq.search.rich.ArkAppModule.a
    public void b(long j3, String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("ArkNodeContainer", 2, "onNotify, KEY\uff1a" + str + " VALUE:" + str2);
        }
        f c16 = c(j3);
        if (c16 != null && (c16 instanceof d)) {
            ((d) c16).o(str, str2);
        }
    }

    public void d(d dVar) {
        if (dVar == null) {
            return;
        }
        Iterator<WeakReference<f>> it = this.f283743a.iterator();
        while (it.hasNext()) {
            if (it.next().get() == dVar) {
                return;
            }
        }
        this.f283743a.add(new WeakReference<>(dVar));
    }

    public void e(d dVar) {
        if (dVar == null) {
            return;
        }
        Iterator<WeakReference<f>> it = this.f283743a.iterator();
        while (it.hasNext()) {
            WeakReference<f> next = it.next();
            if (next.get() == dVar) {
                this.f283743a.remove(next);
                return;
            }
        }
    }
}
