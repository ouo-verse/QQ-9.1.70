package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final String f182346a;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f182346a = ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass().getName();
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.controllerinject.a
    public boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        return this.f182346a.equals(str);
    }
}
