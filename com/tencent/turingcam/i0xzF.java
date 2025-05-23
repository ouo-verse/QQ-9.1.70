package com.tencent.turingcam;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.turingcam.ShGzN;

/* compiled from: P */
/* loaded from: classes27.dex */
public class i0xzF extends BaseThread {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShGzN.spXPg f382257a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f382258b;

    public i0xzF(ShGzN.spXPg spxpg, Context context) {
        this.f382257a = spxpg;
        this.f382258b = context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) spxpg, (Object) context);
        }
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f382257a.f382025a.b(this.f382258b);
        }
    }
}
