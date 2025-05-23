package com.tencent.mobileqq.auto.engine.loader.selector;

import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.ASEngineQualityReport;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    ASPluginBean f199879a;

    /* renamed from: b, reason: collision with root package name */
    ASPluginBean f199880b;

    public b(ASPluginBean aSPluginBean, ASPluginBean aSPluginBean2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aSPluginBean, (Object) aSPluginBean2);
        } else {
            this.f199879a = aSPluginBean;
            this.f199880b = aSPluginBean2;
        }
    }

    private ASPluginBean c(ASPluginBean aSPluginBean, ASPluginBean aSPluginBean2) {
        if (aSPluginBean.getVersionCode() <= aSPluginBean2.getVersionCode()) {
            e(4);
            QLog.i(ASDynamicEngine.q(aSPluginBean.getBusinessKey()), 1, "ASPluginSelectorNetProcess#checkNet():net plugin version:" + aSPluginBean.getVersionCode() + " lower then asset, go to checkAsset");
            return null;
        }
        return d(aSPluginBean);
    }

    private ASPluginBean d(ASPluginBean aSPluginBean) {
        Object obj;
        if (!b(aSPluginBean)) {
            e(6);
            QLog.i(ASDynamicEngine.q(aSPluginBean.getBusinessKey()), 1, "ASPluginSelectorNetProcess#checkNet():net plugin version:" + aSPluginBean.getVersionCode() + " crash too many, go to checkAsset");
            return null;
        }
        if (aSPluginBean.getVersionCode() < aSPluginBean.getSupportMinPluginVersion()) {
            e(4);
            QLog.i(ASDynamicEngine.q(aSPluginBean.getBusinessKey()), 1, "ASPluginSelectorNetProcess#checkNet():net plugin version:" + aSPluginBean.getVersionCode() + " mini not support, go to checkAsset");
            return null;
        }
        String q16 = ASDynamicEngine.q(aSPluginBean.getBusinessKey());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ASPluginSelectorNetProcess#checkNet():use netWork plugin, net version:");
        sb5.append(aSPluginBean.getVersionCode());
        sb5.append(" asset version:");
        ASPluginBean aSPluginBean2 = this.f199880b;
        if (aSPluginBean2 != null) {
            obj = Integer.valueOf(aSPluginBean2.getVersionCode());
        } else {
            obj = " ";
        }
        sb5.append(obj);
        sb5.append(" MiniSupportVersion");
        sb5.append(aSPluginBean.getSupportMinPluginVersion());
        QLog.i(q16, 1, sb5.toString());
        return aSPluginBean;
    }

    private void e(int i3) {
        if (this.f199879a == null) {
            return;
        }
        ASEngineQualityReport.report(new ASEngineQualityReport.ReportData().setExt1(this.f199879a.getBusinessKey()).setPluginVersion(this.f199879a.getVersionCode()).setPluginType(this.f199879a.getType()).setEventId(ASEngineQualityReport.EVENT_PLUGIN_LOAD).setRetCode(i3));
    }

    @Override // com.tencent.mobileqq.auto.engine.loader.selector.g
    public ASPluginBean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ASPluginBean) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ASPluginBean aSPluginBean = this.f199879a;
        if (aSPluginBean == null) {
            return null;
        }
        ASPluginBean aSPluginBean2 = this.f199880b;
        if (aSPluginBean2 != null) {
            return c(aSPluginBean, aSPluginBean2);
        }
        return d(aSPluginBean);
    }
}
