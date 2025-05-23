package com.tencent.mobileqq.microapp.out.plugins;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
final class c implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f246031a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f246032b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f246033c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ OtherJsPlugin f246034d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(OtherJsPlugin otherJsPlugin, String str, String str2, int i3) {
        this.f246034d = otherJsPlugin;
        this.f246031a = str;
        this.f246032b = str2;
        this.f246033c = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, otherJsPlugin, str, str2, Integer.valueOf(i3));
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f246034d.callbackSettingEvent(this.f246031a, this.f246032b, this.f246033c);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }
}
