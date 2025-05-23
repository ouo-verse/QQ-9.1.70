package com.tencent.mobileqq.qqlive.push;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class d implements ni2.c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f271423a;

    /* renamed from: b, reason: collision with root package name */
    private ni2.a f271424b;

    /* renamed from: c, reason: collision with root package name */
    private LivePushRepository f271425c;

    public d(LivePushRepository livePushRepository) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) livePushRepository);
        } else {
            this.f271425c = livePushRepository;
        }
    }

    @Override // ni2.c
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        LivePushRepository livePushRepository = this.f271425c;
        if (livePushRepository != null) {
            livePushRepository.i(this);
        }
        this.f271424b = null;
    }

    @Override // ni2.c
    public ni2.c b(int i3, ni2.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ni2.c) iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) aVar);
        }
        this.f271423a = i3;
        this.f271424b = aVar;
        LivePushRepository livePushRepository = this.f271425c;
        if (livePushRepository != null) {
            livePushRepository.b(this);
        }
        return this;
    }

    public ni2.a c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ni2.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f271424b;
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f271423a;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return super.toString() + ", RoomPush" + this.f271424b;
    }
}
