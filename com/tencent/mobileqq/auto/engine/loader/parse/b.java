package com.tencent.mobileqq.auto.engine.loader.parse;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASEngineUtils;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final String f199875a;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, ASPluginBean> f199876b;

    public b(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.f199876b = new ConcurrentHashMap<>();
            this.f199875a = str;
        }
    }

    private void b() {
        ASPluginBean versionCode = new ASPluginBean().setBusinessKey(this.f199875a).setType(ASPluginBean.TYPE_NATIVE).setVersionCode(ASEngineUtils.getHostVersion());
        this.f199876b.put(versionCode.getType(), versionCode);
        QLog.d(ASDynamicEngine.q(this.f199875a), 1, "initNativeParse() create a fake bean");
    }

    private void c() {
        ASPluginBean d16 = com.tencent.mobileqq.auto.engine.loader.a.e(this.f199875a).m().d(this.f199875a);
        if (d16 == null) {
            QLog.d("ASDynamicEngine", 1, "netBean is empty");
            return;
        }
        QLog.d(ASDynamicEngine.q(d16.getBusinessKey()), 1, "initNetParse" + d16);
        ASPluginBean call = new d(d16).call();
        if (call != null) {
            this.f199876b.put(call.getType(), call);
        }
    }

    public ConcurrentHashMap<String, ASPluginBean> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.f199876b.size() > 0) {
            return this.f199876b;
        }
        b();
        c();
        return this.f199876b;
    }
}
