package com.tencent.mobileqq.mutualmark.info;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<Long, d> f252151a;

    public f(com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else if (!TextUtils.isEmpty(aVar.m())) {
            this.f252151a = d.c(aVar.m());
        } else {
            this.f252151a = null;
        }
    }

    public void a(com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        ConcurrentHashMap<Long, d> concurrentHashMap = this.f252151a;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
            aVar.z(d.f(this.f252151a));
        } else {
            aVar.z("");
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "ExtensionMutualMarkData{mutualMarks=" + this.f252151a + '}';
    }
}
