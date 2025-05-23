package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Damson extends BaseThread {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f375588a;

    public Damson(Context context) {
        this.f375588a = context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public final void run() {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            j3 = Long.valueOf(Chestnut.b(this.f375588a, "801")).longValue();
        } catch (Throwable unused) {
            j3 = 0;
        }
        if (j3 == 0) {
            Context context = this.f375588a;
            HashMap hashMap = new HashMap();
            StringBuilder a16 = Pyxis.a("");
            a16.append(System.currentTimeMillis());
            hashMap.put("801", a16.toString());
            Chestnut.a(context, hashMap);
        }
    }
}
