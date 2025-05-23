package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.mobileqq.webview.swift.injector.ac;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes20.dex */
public class e extends b.C8976b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static ArrayList<com.tencent.mobileqq.webview.swift.d> f314453e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49199);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f314453e = new ArrayList<>();
            f314453e = ac.a();
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public boolean g(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent)).booleanValue();
        }
        Activity activity = this.f314441d.getActivity();
        String stringExtra = intent.getStringExtra("url");
        Iterator<com.tencent.mobileqq.webview.swift.d> it = f314453e.iterator();
        while (it.hasNext()) {
            if (it.next().needSwitchFragment(intent, activity, stringExtra)) {
                return true;
            }
        }
        return false;
    }

    public boolean h(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent)).booleanValue();
        }
        Activity activity = this.f314441d.getActivity();
        String stringExtra = intent.getStringExtra("url");
        Iterator<com.tencent.mobileqq.webview.swift.d> it = f314453e.iterator();
        while (it.hasNext()) {
            if (it.next().navigateToAnotherActivity(intent, activity, stringExtra)) {
                return true;
            }
        }
        return false;
    }
}
