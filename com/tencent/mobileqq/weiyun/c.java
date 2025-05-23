package com.tencent.mobileqq.weiyun;

import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c extends RemoteCommand {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f315140a;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36250);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f315140a = new AtomicInteger();
        }
    }

    public c() {
        super("weiyun.notify_state");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand
    public Bundle invoke(Bundle bundle, RemoteCommand.OnInvokeFinishLinstener onInvokeFinishLinstener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bundle) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle, (Object) onInvokeFinishLinstener);
        }
        Bundle bundle2 = new Bundle();
        AtomicInteger atomicInteger = f315140a;
        int i3 = bundle.getInt("param_state", atomicInteger.get());
        if (i3 != atomicInteger.get()) {
            atomicInteger.set(i3);
        }
        return bundle2;
    }
}
