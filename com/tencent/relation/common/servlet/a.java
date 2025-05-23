package com.tencent.relation.common.servlet;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.relation.common.api.IRelationCmdHandler;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface a {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: y4, reason: collision with root package name */
    public static final String f364759y4;

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(28658), (Class<?>) a.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            f364759y4 = ((IRelationCmdHandler) QRoute.api(IRelationCmdHandler.class)).getRelationRequestHandlerName();
        }
    }

    void F(String str);

    void Z0(String str, byte[] bArr, b bVar);

    void notifyUI(int i3, boolean z16, Object obj);

    b u1(String str);

    void z(String str, b bVar);
}
