package com.tencent.imcore.message.core.codec;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class c implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.imcore.message.basic.a<a> f116587a;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f116587a = new com.tencent.imcore.message.basic.b();
        }
    }

    @Override // com.tencent.imcore.message.basic.a
    public List<a> getInstances() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f116587a.getInstances();
    }

    @Override // com.tencent.imcore.message.basic.a
    public void register(Class<? extends a> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cls);
        } else {
            this.f116587a.register(cls);
        }
    }

    @Override // com.tencent.imcore.message.basic.a
    public void unregister(Class<? extends a> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cls);
        } else {
            this.f116587a.unregister(cls);
        }
    }

    @Override // com.tencent.imcore.message.basic.a
    public List<Class<? extends a>> values() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f116587a.values();
    }
}
