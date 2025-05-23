package com.tencent.mobileqq.auto.engine.loader.net;

import com.tencent.mobileqq.auto.engine.loader.ASEngineUtils;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.ASEngineQualityReport;
import cooperation.qzone.QUA;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import uq3.o;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static final Object f199866c;

    /* renamed from: a, reason: collision with root package name */
    private EntityManager f199867a;

    /* renamed from: b, reason: collision with root package name */
    private CountDownLatch f199868b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40629);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f199866c = new Object();
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else if (this.f199867a == null) {
            this.f199867a = ASEngineUtils.getEntityManager();
        }
    }

    private EntityManager c() {
        return this.f199867a;
    }

    public ASDataBaseInfo a(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ASDataBaseInfo) iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
        }
        List<? extends Entity> query = c().query(ASDataBaseInfo.class, ASDataBaseInfo.class.getSimpleName(), true, "mBusinessKey = ?", new String[]{str}, (String) null, (String) null, (String) null, (String) null);
        if (query != null && query.size() > 0) {
            Iterator<? extends Entity> it = query.iterator();
            while (it.hasNext()) {
                ASDataBaseInfo aSDataBaseInfo = (ASDataBaseInfo) it.next();
                if (aSDataBaseInfo != null && (!z16 || aSDataBaseInfo.mIsReady)) {
                    if (!aSDataBaseInfo.mIsInvalid && aSDataBaseInfo.mUin == ASEngineUtils.getUinLong() && aSDataBaseInfo.mQua.equals(QUA.getQUA3()) && str.equals(aSDataBaseInfo.mBusinessKey)) {
                        QLog.d("ASNetInfoManger", 1, "getAsPluginBean():" + aSDataBaseInfo);
                        return aSDataBaseInfo;
                    }
                }
            }
        }
        QLog.d("ASNetInfoManger", 1, "getAsPluginBean():" + str + "no plugin");
        return null;
    }

    public ASPluginBean b(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ASPluginBean) iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16));
        }
        ASDataBaseInfo a16 = a(str, z16);
        if (a16 == null) {
            ASEngineQualityReport.report(new ASEngineQualityReport.ReportData().setEventId(ASEngineQualityReport.EVENT_PLUGIN_GET).setExt1(str).setPluginVersion(com.tencent.mobileqq.auto.engine.loader.a.e(str).k().getVersionCode()).setPluginType(ASPluginBean.TYPE_NET).setRetCode(-1L));
            return null;
        }
        ASEngineQualityReport.report(new ASEngineQualityReport.ReportData().setEventId(ASEngineQualityReport.EVENT_PLUGIN_GET).setExt1(str).setPluginVersion(com.tencent.mobileqq.auto.engine.loader.a.e(str).k().getVersionCode()).setPluginType(ASPluginBean.TYPE_NET).setRetCode(0L));
        return ASEngineUtils.transFormToASPluginBean(a16);
    }

    public synchronized ASPluginBean d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ASPluginBean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        if (!o.B()) {
            QLog.e("ASNetInfoManger", 1, "sendRainBow return");
            return null;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f199868b = countDownLatch;
        try {
            countDownLatch.await(60L, TimeUnit.SECONDS);
        } catch (InterruptedException e16) {
            QLog.e("ASNetInfoManger", 1, "queryLastPluginBean error" + e16.getMessage());
            e16.printStackTrace();
        }
        ASPluginBean b16 = b(str, true);
        QLog.e("ASNetInfoManger", 1, "queryLastPluginBean success" + b16);
        return b16;
    }

    public void e(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) str);
            return;
        }
        QLog.e("ASNetInfoManger", 1, "setQCirclePluginInvalid=" + i3 + str);
        ASDataBaseInfo aSDataBaseInfo = (ASDataBaseInfo) DBMethodProxy.find(c(), (Class<? extends Entity>) ASDataBaseInfo.class, String.valueOf(i3), str);
        if (aSDataBaseInfo != null) {
            QLog.e("ASNetInfoManger", 1, "setQCirclePluginInvalid success" + i3);
            aSDataBaseInfo.mIsInvalid = true;
            synchronized (f199866c) {
                c().update(aSDataBaseInfo);
            }
            ASEngineQualityReport.report(new ASEngineQualityReport.ReportData().setExt1(str).setEventId(ASEngineQualityReport.EVENT_PLUGIN_SET_PLUGIN_INVALID).setRetCode(0L).setPluginType(ASPluginBean.TYPE_NET).setPluginVersion(i3));
            return;
        }
        ASEngineQualityReport.report(new ASEngineQualityReport.ReportData().setEventId(ASEngineQualityReport.EVENT_PLUGIN_SET_PLUGIN_INVALID).setExt1(str).setPluginType(ASPluginBean.TYPE_NET).setRetCode(-1L).setPluginVersion(i3));
    }
}
