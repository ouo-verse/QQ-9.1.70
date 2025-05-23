package com.tencent.mobileqq.debug;

import android.os.Environment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.util.Pair;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
class CIOSubmitUtils$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f203463d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f203464e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f203465f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ String f203466h;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        String str = Environment.getExternalStorageDirectory() + "/cio_mobile_qq";
        a.m(str);
        a.h(str, this.f203463d, this.f203464e, this.f203465f, this.f203466h);
        Pair<String, String> n3 = a.n(str, MobileQQ.PACKAGE_NAME);
        a.l(n3.first, n3.second);
        a.d();
    }
}
