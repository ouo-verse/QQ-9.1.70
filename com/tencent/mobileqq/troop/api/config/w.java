package com.tencent.mobileqq.troop.api.config;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;
import com.tencent.qphone.base.util.QLog;
import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes19.dex */
public class w {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static ArrayList<c> f293991a;

    /* renamed from: b, reason: collision with root package name */
    private static w f293992b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63864);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f293991a = new ArrayList<>();
        }
    }

    w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            b();
        }
    }

    public static w a() {
        if (f293992b == null) {
            synchronized (w.class) {
                if (f293992b == null) {
                    f293992b = new w();
                }
            }
        }
        return f293992b;
    }

    void b() {
        ArrayList<Class<? extends c>> arrayList = com.tencent.mobileqq.troop.api.config.extension.a.f293981e;
        if (arrayList != null) {
            Iterator<Class<? extends c>> it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    f293991a.add(it.next().newInstance());
                } catch (Throwable th5) {
                    QLog.i("TroopAnnouncementHandlerProcessorConfig", 1, "Init Fail", th5);
                }
            }
        }
    }

    public void c(AppInterface appInterface, long j3, long j16, int i3, ITroopAnnouncementHelperApi.a aVar, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appInterface, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), aVar, str, Boolean.valueOf(z16));
            return;
        }
        Iterator<c> it = f293991a.iterator();
        while (it.hasNext()) {
            it.next().a(appInterface, j3, j16, i3, aVar, str, z16);
        }
    }

    public void d(AppInterface appInterface, long j3, long j16, int i3, String str, int i16, boolean z16, DataInputStream dataInputStream) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appInterface, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), str, Integer.valueOf(i16), Boolean.valueOf(z16), dataInputStream);
            return;
        }
        Iterator<c> it = f293991a.iterator();
        while (it.hasNext()) {
            it.next().b(appInterface, j3, j16, i3, str, i16, z16, dataInputStream);
        }
    }
}
