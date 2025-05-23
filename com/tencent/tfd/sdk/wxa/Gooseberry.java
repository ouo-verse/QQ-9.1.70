package com.tencent.tfd.sdk.wxa;

import android.view.Window;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Gooseberry extends Cif {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public Berry f375633b;

    /* renamed from: c, reason: collision with root package name */
    public String f375634c;

    public Gooseberry(Window.Callback callback, Berry berry, String str) {
        super(callback);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, callback, berry, str);
        } else {
            this.f375633b = berry;
            this.f375634c = str;
        }
    }
}
