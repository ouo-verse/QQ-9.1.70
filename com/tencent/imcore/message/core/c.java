package com.tencent.imcore.message.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class c implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.imcore.message.basic.c<Integer, a> f116586a;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f116586a = new com.tencent.imcore.message.basic.d();
        }
    }

    @Override // com.tencent.imcore.message.basic.c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a get(Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) num);
        }
        return this.f116586a.get(num);
    }

    @Override // com.tencent.imcore.message.basic.c
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(Integer num, Class<? extends a> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) num, (Object) cls);
        } else {
            this.f116586a.a(num, cls);
        }
    }

    @Override // com.tencent.imcore.message.basic.c
    public List<Class<? extends a>> values() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f116586a.values();
    }
}
