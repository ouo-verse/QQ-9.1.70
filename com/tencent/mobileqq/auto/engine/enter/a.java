package com.tencent.mobileqq.auto.engine.enter;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.auto.engine.event.ASEngineEnterEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.mobileqq.jump.api.IJumpApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.util.EventControlUtils;
import cooperation.qqcircle.report.ASEngineQualityReport;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class a implements s91.a, SimpleEventReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected ASPluginBean f199837d;

    /* renamed from: e, reason: collision with root package name */
    protected b f199838e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f199839f;

    public a(ASPluginBean aSPluginBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aSPluginBean);
        } else {
            this.f199837d = aSPluginBean;
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    private void k(ASEngineEnterEvent aSEngineEnterEvent) {
        if (aSEngineEnterEvent.getBusinessKey().equals(this.f199837d.getBusinessKey()) && !this.f199839f && aSEngineEnterEvent.isSuccess()) {
            this.f199839f = true;
            ASEngineQualityReport.report(new ASEngineQualityReport.ReportData().setExt1(this.f199837d.getBusinessKey()).setPluginVersion(this.f199837d.getVersionCode()).setPluginType(this.f199837d.getType()).setRetCode(aSEngineEnterEvent.getResultCode()).setExt2(String.valueOf(aSEngineEnterEvent.hasPreload())).setEventId(ASEngineQualityReport.EVENT_PLUGIN_LOAD).setTimeCost(aSEngineEnterEvent.getLoadCostTime()));
            QLog.d(ASDynamicEngine.q(this.f199837d.getBusinessKey()), 1, "loadSuccess event:" + aSEngineEnterEvent);
        }
    }

    @Override // s91.a
    public void b(ASEnterBean aSEnterBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aSEnterBean);
            return;
        }
        if (aSEnterBean == null) {
            QLog.d("ASDynamicEngine", 1, "enterBean is empty");
            return;
        }
        if (j(aSEnterBean)) {
            if (!EventControlUtils.throttlingAtOnce("FSEngineEnter " + aSEnterBean.getBusinessKey(), 1000L)) {
                QLog.d("ASDynamicEngine_" + aSEnterBean.getBusinessKey(), 1, "FSPluginEngineEnter interval 1000");
                return;
            }
        }
        if (g()) {
            QLog.d("ASDynamicEngine_" + aSEnterBean.getBusinessKey(), 1, "enterMainProcess");
            d(aSEnterBean);
            return;
        }
        c(aSEnterBean);
    }

    protected void c(ASEnterBean aSEnterBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aSEnterBean);
        } else {
            if (TextUtils.isEmpty(aSEnterBean.getSchemeAction())) {
                return;
            }
            Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) ((IJumpApi) QRoute.api(IJumpApi.class)).getJumpActivityClass());
            intent.setData(Uri.parse(e(aSEnterBean.getSchemeAction(), aSEnterBean.getAttrs())));
            intent.addFlags(268435456);
            BaseApplication.getContext().startActivity(intent);
        }
    }

    protected void d(ASEnterBean aSEnterBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aSEnterBean);
            return;
        }
        if (!com.tencent.mobileqq.auto.engine.loader.a.e(aSEnterBean.getBusinessKey()).x()) {
            QLog.d("ASDynamicEngine_" + aSEnterBean.getBusinessKey(), 1, "FSPluginEngineEnter hasNeverEnter plugin enterLoading page");
            h(aSEnterBean);
            aSEnterBean.setLoadAction(1002);
        }
        aSEnterBean.setLoadAction(1001);
        aSEnterBean.setStartTime(System.currentTimeMillis());
        i(aSEnterBean);
    }

    protected abstract String e(String str, HashMap<String, String> hashMap);

    protected abstract String f();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (MobileQQ.sProcessId == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ArrayList) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(ASEngineEnterEvent.class);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(ASEnterBean aSEnterBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aSEnterBean);
            return;
        }
        QLog.d("ASDynamicEngine_" + aSEnterBean.getBusinessKey(), 1, "plugin not load");
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(BaseApplication.getContext(), QPublicTransFragmentActivity.class);
        intent.putExtra("public_fragment_class", f());
        intent.putExtra("public_fragment_window_feature", 1);
        BaseApplication.getContext().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(ASEnterBean aSEnterBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aSEnterBean);
            return;
        }
        if (this.f199838e == null) {
            this.f199838e = new b(this.f199837d);
        }
        ASEngineQualityReport.report(new ASEngineQualityReport.ReportData().setExt1(this.f199837d.getBusinessKey()).setPluginVersion(this.f199837d.getVersionCode()).setPluginType(this.f199837d.getType()).setEventId(ASEngineQualityReport.EVENT_ENTER_PLUGIN));
        this.f199838e.e(aSEnterBean);
    }

    protected boolean j(ASEnterBean aSEnterBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aSEnterBean)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof ASEngineEnterEvent) {
            k((ASEngineEnterEvent) simpleBaseEvent);
        }
    }
}
