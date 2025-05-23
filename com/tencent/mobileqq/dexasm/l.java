package com.tencent.mobileqq.dexasm;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;
import org.jf.dexlib2.HiddenApiRestriction;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.Opcodes;
import org.jf.dexlib2.builder.BuilderInstruction;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.MethodImplementation;
import org.jf.dexlib2.iface.MethodParameter;
import org.jf.dexlib2.immutable.ImmutableMethod;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes10.dex */
public class l extends k {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private final String f203521e;

    /* renamed from: f, reason: collision with root package name */
    private final String f203522f;

    /* renamed from: g, reason: collision with root package name */
    private final List<? extends MethodParameter> f203523g;

    /* renamed from: h, reason: collision with root package name */
    private final String f203524h;

    /* renamed from: i, reason: collision with root package name */
    private final int f203525i;

    /* renamed from: j, reason: collision with root package name */
    private final List<c> f203526j;

    /* renamed from: k, reason: collision with root package name */
    private m f203527k;

    /* renamed from: l, reason: collision with root package name */
    @Nonnull
    private Set<HiddenApiRestriction> f203528l;

    public l(@Nonnull Opcodes opcodes, String str, String str2, List<? extends MethodParameter> list, String str3, int i3, @Nonnull Set<HiddenApiRestriction> set) {
        super(opcodes);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, opcodes, str, str2, list, str3, Integer.valueOf(i3), set);
            return;
        }
        this.f203526j = new ArrayList();
        this.f203521e = str;
        this.f203522f = str2;
        this.f203523g = list;
        this.f203524h = str3;
        this.f203525i = i3;
        this.f203528l = set;
    }

    @Override // com.tencent.mobileqq.dexasm.k
    public void b(int i3, @Nonnull BuilderInstruction builderInstruction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) builderInstruction);
        } else {
            this.f203527k.addInstruction(i3, builderInstruction);
        }
    }

    @Override // com.tencent.mobileqq.dexasm.k
    public void c(int i3, @Nonnull BuilderInstruction builderInstruction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) builderInstruction);
        } else {
            this.f203527k.replaceInstruction(i3, builderInstruction);
        }
    }

    @Override // com.tencent.mobileqq.dexasm.k
    public m g(@Nonnull MethodImplementation methodImplementation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (m) iPatchRedirector.redirect((short) 3, (Object) this, (Object) methodImplementation);
        }
        m mVar = new m(methodImplementation);
        this.f203527k = mVar;
        return mVar;
    }

    @Override // com.tencent.mobileqq.dexasm.k
    public void p(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        m mVar = this.f203527k;
        if (mVar != null) {
            mVar.a(i3);
        }
    }

    @Override // com.tencent.mobileqq.dexasm.k
    public void q(int i3, @Nonnull BuilderInstruction builderInstruction, int i16) {
        Opcode opcode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), builderInstruction, Integer.valueOf(i16));
            return;
        }
        List<BuilderInstruction> instructions = this.f203527k.getInstructions();
        Opcode opcode2 = builderInstruction.getOpcode();
        String str = this.f203524h;
        if (i3 > 0 && instructions.size() >= i3) {
            opcode = instructions.get(i3 - 1).getOpcode();
        } else {
            opcode = null;
        }
        n.m(opcode2, str, opcode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableMethod t() {
        HashSet hashSet = new HashSet();
        Iterator<c> it = this.f203526j.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().c());
        }
        return new ImmutableMethod(this.f203521e, this.f203522f, this.f203523g, this.f203524h, this.f203525i, hashSet, this.f203528l, this.f203527k);
    }

    @Override // com.tencent.mobileqq.dexasm.k
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public c e(Annotation annotation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) annotation);
        }
        c cVar = new c();
        this.f203526j.add(cVar);
        return cVar;
    }
}
