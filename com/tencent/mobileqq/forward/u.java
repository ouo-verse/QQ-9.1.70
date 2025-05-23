package com.tencent.mobileqq.forward;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes12.dex */
public class u implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ForwardD55Manager f211072d;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, Map<String, Object>> f211073e;

    public u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f211073e = new HashMap();
        QLog.d("SDK_SHARE.ForwardSdkStatusManager", 1, "--> init");
        this.f211072d = new ForwardD55Manager();
    }

    public void a(String str, Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) map);
        } else {
            this.f211073e.put(str, map);
            QLog.d("SDK_SHARE.ForwardSdkStatusManager", 1, "--> cache key:", str);
        }
    }

    public Map<String, Object> b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Map) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        Map<String, Object> remove = this.f211073e.remove(str);
        Object[] objArr = new Object[4];
        boolean z16 = false;
        objArr[0] = "--> cache key:";
        objArr[1] = str;
        objArr[2] = " obj is Empty? ->";
        if (remove == null) {
            z16 = true;
        }
        objArr[3] = Boolean.valueOf(z16);
        QLog.d("SDK_SHARE.ForwardSdkStatusManager", 1, objArr);
        return remove;
    }

    public ForwardD55Manager c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ForwardD55Manager) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f211072d;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            QLog.d("SDK_SHARE.ForwardSdkStatusManager", 1, "--> onDestroy");
            this.f211072d.i();
        }
    }
}
