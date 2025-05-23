package com.tencent.mobileqq.dexasm;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Set;
import org.jf.dexlib2.iface.AnnotationElement;
import org.jf.dexlib2.immutable.ImmutableAnnotation;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    protected int f203491b;

    /* renamed from: c, reason: collision with root package name */
    protected String f203492c;

    /* renamed from: d, reason: collision with root package name */
    protected Set<? extends AnnotationElement> f203493d;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.dexasm.b
    public void a(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
        } else {
            this.f203491b = i3;
            this.f203492c = str;
        }
    }

    @Override // com.tencent.mobileqq.dexasm.b
    public void b(Set<? extends AnnotationElement> set) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) set);
        } else {
            this.f203493d = set;
        }
    }

    public ImmutableAnnotation c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ImmutableAnnotation) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new ImmutableAnnotation(this.f203491b, this.f203492c, this.f203493d);
    }
}
