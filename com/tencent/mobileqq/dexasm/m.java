package com.tencent.mobileqq.dexasm;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import javax.annotation.Nonnull;
import org.jf.dexlib2.builder.MutableMethodImplementation;
import org.jf.dexlib2.iface.MethodImplementation;

/* compiled from: P */
/* loaded from: classes10.dex */
public class m extends MutableMethodImplementation {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f203529a;

    public m(@Nonnull MethodImplementation methodImplementation) {
        super(methodImplementation);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) methodImplementation);
        } else {
            this.f203529a = -1;
        }
    }

    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.f203529a = i3;
        }
    }

    @Override // org.jf.dexlib2.builder.MutableMethodImplementation, org.jf.dexlib2.iface.MethodImplementation
    public int getRegisterCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        int i3 = this.f203529a;
        if (i3 == -1) {
            return super.getRegisterCount();
        }
        return i3;
    }
}
