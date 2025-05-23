package com.tencent.mobileqq.qqconnectface.impl;

import com.tencent.mobileqq.identification.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a implements je2.a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @ConfigInject(configPath = "Business/qqconnectface-api/src/main/resources/Inject_connect_face_config.yml", version = 1)
    private static ArrayList<Class<? extends je2.a>> f262382b;

    /* renamed from: a, reason: collision with root package name */
    private je2.a f262383a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21303);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        ArrayList<Class<? extends je2.a>> arrayList = new ArrayList<>();
        f262382b = arrayList;
        arrayList.add(d.class);
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        try {
            this.f262383a = f262382b.get(0).newInstance();
        } catch (Exception e16) {
            QLog.e("VideoProxy", 1, "IVideoService newInstance", e16);
        }
    }

    @Override // je2.a
    public boolean isVideoChatting(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime)).booleanValue();
        }
        return this.f262383a.isVideoChatting(appRuntime);
    }
}
