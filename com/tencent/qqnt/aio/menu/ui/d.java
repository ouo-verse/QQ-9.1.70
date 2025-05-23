package com.tencent.qqnt.aio.menu.ui;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected boolean f351559a;

    /* renamed from: b, reason: collision with root package name */
    protected int f351560b;

    /* renamed from: c, reason: collision with root package name */
    private AIOMsgItem f351561c;

    public d(AIOMsgItem aIOMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aIOMsgItem);
        } else {
            this.f351559a = false;
            this.f351561c = aIOMsgItem;
        }
    }

    @Nullable
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return null;
    }

    public abstract int b();

    public abstract int c();

    public AIOMsgItem d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f351561c;
    }

    public abstract String e();

    public abstract String f();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    public abstract void h();

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "QQCustomMenuItem{title='" + f() + "', special=" + this.f351559a + ", priority=" + this.f351560b + '}';
    }
}
