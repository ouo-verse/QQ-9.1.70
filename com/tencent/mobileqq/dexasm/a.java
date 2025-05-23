package com.tencent.mobileqq.dexasm;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.Opcodes;
import org.jf.dexlib2.builder.BuilderInstruction;
import org.jf.dexlib2.iface.MethodImplementation;
import org.jf.dexlib2.iface.reference.MethodReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a extends k {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private final String f203487e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f203488f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f203489g;

    public a(Opcodes opcodes, @Nullable k kVar, String str) {
        super(opcodes, kVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, opcodes, kVar, str);
        } else {
            this.f203487e = str;
            this.f203488f = "<init>".equals(str);
        }
    }

    private void t(int i3, @Nonnull BuilderInstruction builderInstruction, @Nonnull MethodReference methodReference, int... iArr) {
        if (this.f203488f && !this.f203489g && h.e(builderInstruction.getOpcode())) {
            this.f203489g = true;
            u(i3 + 1);
        }
    }

    @Override // com.tencent.mobileqq.dexasm.k
    public m g(@Nonnull MethodImplementation methodImplementation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (m) iPatchRedirector.redirect((short) 2, (Object) this, (Object) methodImplementation);
        }
        m g16 = super.g(methodImplementation);
        if (!this.f203488f) {
            u(0);
        }
        return g16;
    }

    @Override // com.tencent.mobileqq.dexasm.k
    public void l(int i3, @Nonnull BuilderInstruction builderInstruction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) builderInstruction);
            return;
        }
        if (builderInstruction.getOpcode() == Opcode.THROW) {
            v(i3);
        }
        super.l(i3, builderInstruction);
    }

    @Override // com.tencent.mobileqq.dexasm.k
    public void m(int i3, @Nonnull BuilderInstruction builderInstruction, @Nonnull MethodReference methodReference, int... iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), builderInstruction, methodReference, iArr);
        } else {
            super.m(i3, builderInstruction, methodReference, iArr);
            t(i3, builderInstruction, methodReference, iArr);
        }
    }

    @Override // com.tencent.mobileqq.dexasm.k
    public void q(int i3, @Nonnull BuilderInstruction builderInstruction, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), builderInstruction, Integer.valueOf(i16));
        } else {
            v(i3);
            super.q(i3, builderInstruction, i16);
        }
    }

    protected void u(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
    }

    protected void v(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
    }
}
