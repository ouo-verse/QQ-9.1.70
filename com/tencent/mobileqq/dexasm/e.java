package com.tencent.mobileqq.dexasm;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.HiddenApiRestriction;
import org.jf.dexlib2.Opcodes;
import org.jf.dexlib2.iface.MethodParameter;
import org.jf.dexlib2.iface.value.EncodedValue;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected final Opcodes f203495a;

    /* renamed from: b, reason: collision with root package name */
    protected e f203496b;

    public e(@Nonnull Opcodes opcodes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f203495a = opcodes;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) opcodes);
        }
    }

    public void a(String str, int i3, @Nullable String str2, @Nonnull List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), str2, list);
            return;
        }
        n.n(str);
        e eVar = this.f203496b;
        if (eVar != null) {
            eVar.a(str, i3, str2, list);
        }
    }

    public b b(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (b) iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) str);
        }
        n.n(str);
        e eVar = this.f203496b;
        if (eVar != null) {
            return eVar.b(i3, str);
        }
        return null;
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        e eVar = this.f203496b;
        if (eVar != null) {
            eVar.c();
        }
    }

    public i d(@Nonnull String str, @Nonnull String str2, int i3, @Nullable EncodedValue encodedValue, @Nonnull Set<HiddenApiRestriction> set) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (i) iPatchRedirector.redirect((short) 6, this, str, str2, Integer.valueOf(i3), encodedValue, set);
        }
        n.n(str2);
        e eVar = this.f203496b;
        if (eVar != null) {
            return eVar.d(str, str2, i3, encodedValue, set);
        }
        return null;
    }

    public k e(@Nonnull String str, @Nonnull List<? extends MethodParameter> list, @Nonnull String str2, int i3, @Nonnull Set<HiddenApiRestriction> set) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (k) iPatchRedirector.redirect((short) 7, this, str, list, str2, Integer.valueOf(i3), set);
        }
        n.g(str, i3);
        Iterator<? extends MethodParameter> it = list.iterator();
        while (it.hasNext()) {
            n.n(it.next().getType());
        }
        n.l(str2);
        e eVar = this.f203496b;
        if (eVar != null) {
            return eVar.e(str, list, str2, i3, set);
        }
        return null;
    }

    public void f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        e eVar = this.f203496b;
        if (eVar != null) {
            eVar.f(str);
        }
    }

    public e(Opcodes opcodes, e eVar) {
        this(opcodes);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f203496b = eVar;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) opcodes, (Object) eVar);
        }
    }
}
