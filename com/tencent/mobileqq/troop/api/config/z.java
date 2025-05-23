package com.tencent.mobileqq.troop.api.config;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496$AioKeyword;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496$GroupMsgConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes19.dex */
public class z {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static ArrayList<g> f293999a;

    /* renamed from: b, reason: collision with root package name */
    private static z f294000b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63865);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f293999a = new ArrayList<>();
        }
    }

    z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            b();
        }
    }

    public static z a() {
        if (f294000b == null) {
            synchronized (z.class) {
                if (f294000b == null) {
                    f294000b = new z();
                }
            }
        }
        return f294000b;
    }

    void b() {
        ArrayList<Class<? extends g>> arrayList = com.tencent.mobileqq.troop.api.config.extension.a.f293984h;
        if (arrayList != null) {
            Iterator<Class<? extends g>> it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    f293999a.add(it.next().newInstance());
                } catch (Throwable th5) {
                    QLog.i("TroopConfigHandlerProcessorConfig", 1, "Init Fail", th5);
                }
            }
        }
    }

    public void c(AppInterface appInterface, oidb_0x496$AioKeyword oidb_0x496_aiokeyword) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appInterface, (Object) oidb_0x496_aiokeyword);
            return;
        }
        Iterator<g> it = f293999a.iterator();
        while (it.hasNext()) {
            it.next().a(appInterface, oidb_0x496_aiokeyword);
        }
    }

    public void d(AppInterface appInterface, oidb_0x496$GroupMsgConfig oidb_0x496_groupmsgconfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface, (Object) oidb_0x496_groupmsgconfig);
            return;
        }
        Iterator<g> it = f293999a.iterator();
        while (it.hasNext()) {
            it.next().b(appInterface, oidb_0x496_groupmsgconfig);
        }
    }
}
