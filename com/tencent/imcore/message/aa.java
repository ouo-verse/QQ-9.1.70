package com.tencent.imcore.message;

import com.tencent.imcore.message.z;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class aa implements z.a {
    static IPatchRedirector $redirector_;

    public aa() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private f g(int i3, z zVar, AppRuntime appRuntime, BaseProxyManager baseProxyManager, MsgPool msgPool) {
        f e16;
        if (i3 != 0 && (e16 = zVar.e(0)) != null) {
            return e16;
        }
        return j(new y(appRuntime, baseProxyManager, msgPool), new Class[]{com.tencent.imcore.message.msgproxy.a.class, com.tencent.imcore.message.msgproxy.e.class});
    }

    private void h() {
        StatisticCollector.ReportContext reportContext = new StatisticCollector.ReportContext();
        reportContext.mainthreadTag = 0;
        reportContext.opttypeTag = "select";
        reportContext.optsceneTag = "launch";
        if (reportContext.optcountTag != 0 && StatisticCollector.sqlite3Optimizereport()) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(StatisticCollector.SqliteOptCostInfo.MAINTHREAD_TAG, String.valueOf(reportContext.mainthreadTag));
            hashMap.put(StatisticCollector.SqliteOptCostInfo.OPTTYPE_TAG, reportContext.opttypeTag);
            hashMap.put(StatisticCollector.SqliteOptCostInfo.OPTTOTALCOST_TAG, String.valueOf(reportContext.opttotalcostTag));
            hashMap.put(StatisticCollector.SqliteOptCostInfo.OPTCOUNT_TAG, String.valueOf(reportContext.optcountTag));
            hashMap.put(StatisticCollector.SqliteOptCostInfo.OPTMSGCOUNT_TAG, String.valueOf(reportContext.optmsgcountTag));
            hashMap.put(StatisticCollector.SqliteOptCostInfo.OPTONECOST_TAG, String.valueOf(reportContext.optonecostTag));
            hashMap.put(StatisticCollector.SqliteOptCostInfo.OPTSCENE_TAG, reportContext.optsceneTag);
            hashMap.put(StatisticCollector.SqliteOptCostInfo.WALSWITCH_TAG, String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, StatisticCollector.SQLITE_OPERATE_COST, true, reportContext.optmsgcountTag, 0L, hashMap, (String) null, false);
        }
    }

    private void i(f fVar) {
        StringBuilder sb5 = new StringBuilder();
        while (fVar != null) {
            sb5.append(fVar.toString());
            sb5.append(", ");
            if (fVar instanceof com.tencent.imcore.message.msgproxy.d) {
                fVar = ((com.tencent.imcore.message.msgproxy.d) fVar).H0();
            } else {
                fVar = null;
            }
        }
        QLog.d("MsgProxyContainerCallback", 1, "printWrappers() called with:[" + sb5.toString() + "]");
    }

    private f j(f fVar, Class<? extends com.tencent.imcore.message.msgproxy.d>[] clsArr) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("wrapMsgProxy() called with: next = [");
        f fVar2 = fVar;
        sb5.append(fVar2);
        sb5.append("], wrapCls = [");
        sb5.append(Arrays.toString(clsArr));
        sb5.append("]");
        QLog.d("MsgProxyContainerCallback", 1, sb5.toString());
        AppRuntime C = fVar.C();
        BaseProxyManager J = fVar.J();
        MsgPool I = fVar.I();
        f fVar3 = fVar2;
        for (int length = clsArr.length - 1; length >= 0; length--) {
            try {
                com.tencent.imcore.message.msgproxy.d newInstance = clsArr[length].getConstructor(AppRuntime.class, BaseProxyManager.class, MsgPool.class).newInstance(C, J, I);
                try {
                    newInstance.I0(fVar3);
                    fVar2 = newInstance;
                    fVar3 = fVar2;
                } catch (Exception e16) {
                    e = e16;
                    fVar2 = newInstance;
                    QLog.e("MsgProxyContainerCallback", 1, "wrapMsgProxy: ", e);
                }
            } catch (Exception e17) {
                e = e17;
            }
        }
        i(fVar2);
        return fVar2;
    }

    @Override // com.tencent.imcore.message.z.a
    public void a(long j3, z.b bVar, z zVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), bVar, zVar);
        }
    }

    @Override // com.tencent.imcore.message.z.a
    public void b(z zVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) zVar);
        } else {
            h();
        }
    }

    @Override // com.tencent.imcore.message.z.a
    public List<z.b> c(z zVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) zVar);
        }
        ArrayList arrayList = new ArrayList();
        for (RecentUser recentUser : ((ProxyManager) zVar.c().getManager(QQManagerFactory.PROXY_MANAGER)).m().getRecentList(true)) {
            arrayList.add(new z.b(recentUser.uin, recentUser.getType()));
        }
        return arrayList;
    }

    @Override // com.tencent.imcore.message.z.a
    public void d(z zVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) zVar);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        zVar.e(0);
        zVar.e(1);
        zVar.e(3000);
        zVar.e(1026);
        zVar.e(10014);
        zVar.e(1033);
        zVar.e(1034);
        QLog.d("MsgProxyContainerCallback", 2, "initProxies() called with: msgProxyContainer = [" + zVar + "], costTime =[" + (System.currentTimeMillis() - currentTimeMillis) + "]ms");
    }

    @Override // com.tencent.imcore.message.z.a
    public void e(long j3, z.b bVar, z zVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), bVar, zVar);
            return;
        }
        StatisticCollector.ReportContext reportContext = new StatisticCollector.ReportContext();
        reportContext.mainthreadTag = 0;
        reportContext.opttypeTag = "select";
        reportContext.optsceneTag = "launch";
        MsgProxyCallback.F(zVar.c(), bVar.f116750a, bVar.a(), reportContext, j3);
    }

    @Override // com.tencent.imcore.message.z.a
    public f f(int i3, z zVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (f) iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) zVar);
        }
        AppRuntime c16 = zVar.c();
        BaseProxyManager f16 = zVar.f();
        MsgPool d16 = zVar.d();
        if (i3 != 1 && i3 != 1026 && i3 != 3000) {
            return g(i3, zVar, c16, f16, d16);
        }
        return j(new com.tencent.mobileqq.troop.data.j(c16, f16, d16), new Class[]{com.tencent.imcore.message.msgproxy.a.class});
    }
}
