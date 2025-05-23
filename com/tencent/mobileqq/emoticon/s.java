package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes12.dex */
public class s implements ISogouEmoji {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f204879a;

    /* renamed from: b, reason: collision with root package name */
    public static String f204880b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47983);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f204879a = MiniAppGetGameTaskTicketServlet.KEY_TASKID;
            f204880b = "exprId";
        }
    }
}
