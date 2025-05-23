package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.concurrent.FutureTask;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Bootes {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static final Peach<Bootes> f382613b;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap<String, FutureTask<Canesatici>> f382614a;

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.Bootes$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public class Cdo extends Peach<Bootes> {
        static IPatchRedirector $redirector_;

        public Cdo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.tencent.turingfd.sdk.xq.Bootes, java.lang.Object] */
        @Override // com.tencent.turingfd.sdk.xq.Peach
        public Bootes a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new Bootes();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10886);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f382613b = new Cdo();
        }
    }

    public Bootes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f382614a = new HashMap<>();
        }
    }
}
