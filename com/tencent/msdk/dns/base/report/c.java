package com.tencent.msdk.dns.base.report;

import android.content.Context;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.reflect.Method;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
final class c extends b<d> {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static final String f336216a = "b";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17381);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.msdk.dns.base.report.a
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        try {
            Context context = UserAction.mContext;
            com.tencent.msdk.dns.base.log.c.c("find UserAction class for %s", UserAction.class);
            return true;
        } catch (Throwable th5) {
            com.tencent.msdk.dns.base.log.c.c("Can not find UserAction class for %s", th5);
            return false;
        }
    }

    @Override // com.tencent.msdk.dns.base.report.b
    boolean d(int i3, String str, Map<String, String> map) {
        try {
            Context context = UserAction.mContext;
            Class cls = Boolean.TYPE;
            Class cls2 = Long.TYPE;
            Method method = UserAction.class.getMethod("onUserAction", String.class, cls, cls2, cls2, Map.class, cls);
            Boolean bool = Boolean.TRUE;
            boolean booleanValue = ((Boolean) method.invoke(null, str, bool, 0, -1, map, bool)).booleanValue();
            com.tencent.msdk.dns.base.log.c.c("UserAction reportInternal success %s", Boolean.valueOf(booleanValue));
            return booleanValue;
        } catch (Throwable th5) {
            com.tencent.msdk.dns.base.log.c.c("UserAction reportInternal failed %s", th5);
            return false;
        }
    }

    @Override // com.tencent.msdk.dns.base.report.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean b(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) dVar)).booleanValue();
        }
        try {
            Context context = UserAction.mContext;
            Method method = UserAction.class.getMethod("initUserAction", Context.class);
            Method method2 = UserAction.class.getMethod("setAppKey", String.class);
            method.invoke(null, dVar.f336217a);
            method2.invoke(null, dVar.f336218b);
            return true;
        } catch (Throwable th5) {
            com.tencent.msdk.dns.base.log.c.c("UserAction init failed %s", th5);
            return false;
        }
    }

    @Override // com.tencent.msdk.dns.base.report.a
    public String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return f336216a;
    }
}
