package com.tencent.relation.common.servlet;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RelationSSORequestHandler implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<String, c> f364753d;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicLong f364754e;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    private static class UpdateRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        c f364755d;

        /* renamed from: e, reason: collision with root package name */
        boolean f364756e;

        /* renamed from: f, reason: collision with root package name */
        Bundle f364757f;

        public UpdateRunnable(c cVar, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, cVar, Boolean.valueOf(z16), bundle);
                return;
            }
            this.f364755d = cVar;
            this.f364756e = z16;
            this.f364757f = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            c cVar = this.f364755d;
            if (cVar != null) {
                cVar.onReceive(0, this.f364756e, this.f364757f);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    private static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final RelationSSORequestHandler f364758a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23813);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f364758a = new RelationSSORequestHandler();
            }
        }
    }

    public RelationSSORequestHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f364753d = new HashMap<>();
            this.f364754e = new AtomicLong();
        }
    }

    public static RelationSSORequestHandler a() {
        return a.f364758a;
    }

    public void b(AppRuntime appRuntime, String str, byte[] bArr, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appRuntime, str, bArr, cVar);
            return;
        }
        NewIntent newIntent = new NewIntent(appRuntime.getApplicationContext(), e.class);
        String str2 = str + "_" + this.f364754e.getAndIncrement();
        newIntent.putExtra("cmd", str);
        newIntent.putExtra("data", bArr);
        newIntent.putExtra("timeout", 30000L);
        newIntent.putExtra("__cmd_seq__", str2);
        newIntent.setObserver(this);
        this.f364753d.put(str2, cVar);
        appRuntime.startServlet(newIntent);
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            return;
        }
        String string = bundle.getString("__cmd_seq__");
        if (!TextUtils.isEmpty(string) && this.f364753d.containsKey(string)) {
            c cVar = this.f364753d.get(string);
            this.f364753d.remove(string);
            ThreadManagerV2.excute(new UpdateRunnable(cVar, z16, bundle), 16, null, true);
        }
    }
}
