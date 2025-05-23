package com.tencent.mobileqq.service.message.codec.decoder;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.imcore.message.basic.c<Integer, d> f286182a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.imcore.message.basic.a<d> f286183b;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f286182a = new com.tencent.imcore.message.basic.d();
            this.f286183b = new com.tencent.imcore.message.basic.b();
        }
    }

    @Override // com.tencent.imcore.message.basic.c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d get(Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (d) iPatchRedirector.redirect((short) 3, (Object) this, (Object) num);
        }
        return this.f286182a.get(num);
    }

    @Override // com.tencent.imcore.message.basic.c
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(Integer num, Class<? extends d> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) num, (Object) cls);
        } else {
            this.f286182a.a(num, cls);
        }
    }

    @Override // com.tencent.imcore.message.basic.a
    public List<d> getInstances() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f286183b.getInstances();
    }

    @Override // com.tencent.imcore.message.basic.a
    public void register(Class<? extends d> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cls);
        } else {
            this.f286183b.register(cls);
        }
    }

    @Override // com.tencent.imcore.message.basic.a
    public void unregister(Class<? extends d> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) cls);
        } else {
            this.f286183b.unregister(cls);
        }
    }

    @Override // com.tencent.imcore.message.basic.c
    public List<Class<? extends d>> values() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        List<Class<? extends d>> values = this.f286182a.values();
        List<Class<? extends d>> values2 = this.f286183b.values();
        ArrayList arrayList = new ArrayList(values);
        arrayList.addAll(values2);
        return arrayList;
    }
}
