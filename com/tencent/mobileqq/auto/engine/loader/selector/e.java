package com.tencent.mobileqq.auto.engine.loader.selector;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASEngineUtils;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import uq3.k;
import uq3.o;

/* compiled from: P */
/* loaded from: classes11.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private List<g<ASPluginBean>> f199882a;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f199882a = new ArrayList();
        }
    }

    private ASPluginBean c(String str) {
        return null;
    }

    private String e(@NonNull String str) {
        return str + "_" + ASEngineUtils.getUin() + "_" + QUA.getQUA3();
    }

    private void g(@NonNull ASPluginBean aSPluginBean) {
        String json = new Gson().toJson(aSPluginBean);
        if (TextUtils.isEmpty(json)) {
            QLog.d(ASDynamicEngine.q(aSPluginBean.getBusinessKey()), 1, "writeCurrentBeanToLocal failed");
            return;
        }
        QLog.d(ASDynamicEngine.q(aSPluginBean.getBusinessKey()), 1, "writeCurrentBeanToLocal :" + json);
        k.b().p(e(aSPluginBean.getBusinessKey()), json);
    }

    public e a(List<g<ASPluginBean>> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (e) iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
        }
        this.f199882a.addAll(list);
        return this;
    }

    public e b(g<ASPluginBean> gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (e) iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
        }
        this.f199882a.add(gVar);
        return this;
    }

    public ASPluginBean d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ASPluginBean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (o.a()) {
            QLog.e(ASDynamicEngine.q(str), 1, "getCurrentBean");
            return new ASPluginBean().setBusinessKey(str).setType(ASPluginBean.TYPE_NATIVE).setVersionCode(ASEngineUtils.getHostVersion());
        }
        ASPluginBean c16 = c(str);
        if (c16 != null) {
            QLog.d(ASDynamicEngine.q(str), 1, "getCurrentBean debug intercept:" + str);
            return c16;
        }
        String h16 = k.b().h(e(str), "");
        if (TextUtils.isEmpty(h16)) {
            QLog.d(ASDynamicEngine.q(str), 1, "ASSelectorChain getCurrentBean native");
            return new ASPluginBean().setBusinessKey(str).setType(ASPluginBean.TYPE_NATIVE).setVersionCode(ASEngineUtils.getHostVersion());
        }
        ASPluginBean aSPluginBean = (ASPluginBean) new Gson().fromJson(h16, ASPluginBean.class);
        QLog.d(ASDynamicEngine.q(str), 1, "ASSelectorChain getCurrentBean success:" + aSPluginBean);
        return aSPluginBean;
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Iterator<g<ASPluginBean>> it = this.f199882a.iterator();
        while (it.hasNext()) {
            ASPluginBean a16 = it.next().a();
            if (a16 != null) {
                g(a16);
                return;
            }
        }
    }
}
