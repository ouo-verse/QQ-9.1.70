package com.tencent.msdk.dns.base.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.msdk.dns.base.report.a.InterfaceC9209a;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public interface a<InitParameters extends InterfaceC9209a> {

    /* compiled from: P */
    /* renamed from: com.tencent.msdk.dns.base.report.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC9209a {
        public static final IPatchRedirector $redirector_ = null;

        static {
            ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(16822), (Class<?>) InterfaceC9209a.class, "$redirector_");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1);
            }
        }
    }

    boolean a();

    boolean b(InitParameters initparameters);

    boolean c(int i3, String str, Map<String, String> map);

    String getName();
}
