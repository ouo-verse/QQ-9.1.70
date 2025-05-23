package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @ConfigInject(configPath = "Foundation/QQActivity/src/main/resources/Inject_TabData.yml", version = 1)
    public static ArrayList<Class<? extends e>> f182354a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35272);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<Class<? extends e>> arrayList = new ArrayList<>();
        f182354a = arrayList;
        arrayList.add(yy2.a.class);
    }
}
