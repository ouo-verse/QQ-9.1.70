package com.tencent.mobileqq.music;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @ConfigInject(configPath = "AutoInjectYml/Component/AudioKit/Inject_QQPlayerConfig.yml", version = 1)
    public static ArrayList<Class<? extends d>> f251882a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32218);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<Class<? extends d>> arrayList = new ArrayList<>();
        f251882a = arrayList;
        arrayList.add(b.class);
        f251882a.add(f.class);
    }
}
