package com.tencent.ams.music.widget.blowingdetection.blow;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private InterfaceC0699a f71646a;

    /* compiled from: P */
    /* renamed from: com.tencent.ams.music.widget.blowingdetection.blow.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    interface InterfaceC0699a {
        void a(byte[] bArr, int i3);

        void onError(int i3, int i16, String str);

        void onStart();

        void onStop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public InterfaceC0699a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (InterfaceC0699a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f71646a;
    }

    public void b(InterfaceC0699a interfaceC0699a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) interfaceC0699a);
        } else {
            this.f71646a = interfaceC0699a;
        }
    }
}
