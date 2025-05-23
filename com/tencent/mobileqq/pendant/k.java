package com.tencent.mobileqq.pendant;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.vas.avatar.AvatarPendantViewImpl;
import com.tencent.mobileqq.vas.inject.IAvatarPendantView;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes16.dex */
public class k {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList f257517b;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Business/Vas/Inject_IAvatarPendantView.yml", version = 2)
    public IAvatarPendantView f257518a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50250);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f257517b = arrayList;
        arrayList.add(AvatarPendantViewImpl.class);
    }

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            a();
        }
    }

    @QAutoInitMethod
    void a() {
        this.f257518a = (IAvatarPendantView) com.tencent.mobileqq.qroute.utils.b.a(f257517b);
    }
}
