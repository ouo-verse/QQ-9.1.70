package com.tencent.mobileqq.dextransform;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.dexasm.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.jf.dexlib2.Opcodes;
import org.jf.dexlib2.builder.BuilderInstruction;
import org.jf.dexlib2.iface.reference.FieldReference;
import org.jf.dexlib2.iface.reference.MethodReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class g extends com.tencent.mobileqq.dexasm.a {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private final b f203554h;

    /* renamed from: i, reason: collision with root package name */
    private final i f203555i;

    /* renamed from: j, reason: collision with root package name */
    private String f203556j;

    public g(Opcodes opcodes, k kVar, String str, @NonNull b bVar, @NonNull i iVar, String str2) {
        super(opcodes, kVar, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, opcodes, kVar, str, bVar, iVar, str2);
            return;
        }
        this.f203554h = bVar;
        this.f203555i = iVar;
        this.f203556j = str2;
    }

    @Override // com.tencent.mobileqq.dexasm.k
    public void i(int i3, @NonNull BuilderInstruction builderInstruction, int i16, int i17, @NonNull FieldReference fieldReference) {
        MethodReference b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), builderInstruction, Integer.valueOf(i16), Integer.valueOf(i17), fieldReference);
            return;
        }
        d[] dVarArr = this.f203554h.f203539b;
        if (dVarArr == null) {
            super.i(i3, builderInstruction, i16, i17, fieldReference);
            return;
        }
        for (d dVar : dVarArr) {
            if (dVar.i(fieldReference)) {
                try {
                    if (j.d(builderInstruction) && dVar.g()) {
                        MethodReference b17 = dVar.b();
                        if (b17 != null) {
                            d(i3, com.tencent.mobileqq.dexasm.g.e(b17, i17));
                            i3++;
                            a(i3, com.tencent.mobileqq.dexasm.g.d(b17.getReturnType(), i16));
                            this.f203555i.b();
                            com.tencent.mobileqq.nlog.c.c("ReplacementMethodVisitor", "replace Field:" + this.f203556j + " replace Configs:" + dVar.toString());
                            if (h.b() != null) {
                                h.b().b(this.f203556j, dVar);
                            }
                        } else {
                            continue;
                        }
                    } else if (j.g(builderInstruction) && dVar.h() && (b16 = dVar.b()) != null) {
                        d(i3, com.tencent.mobileqq.dexasm.g.e(b16, i17));
                        this.f203555i.b();
                        com.tencent.mobileqq.nlog.c.c("ReplacementMethodVisitor", "replace Field:" + this.f203556j + " replace Configs:" + dVar.toString());
                        if (h.b() != null) {
                            h.b().b(this.f203556j, dVar);
                        }
                    }
                    super.i(i3, builderInstruction, i16, i17, fieldReference);
                } catch (IllegalArgumentException | NullPointerException e16) {
                    com.tencent.mobileqq.nlog.c.b("ReplacementMethodVisitor", "", e16);
                }
            }
        }
        super.i(i3, builderInstruction, i16, i17, fieldReference);
    }

    @Override // com.tencent.mobileqq.dexasm.a, com.tencent.mobileqq.dexasm.k
    public void m(int i3, @NonNull BuilderInstruction builderInstruction, @NonNull MethodReference methodReference, int... iArr) {
        MethodReference b16;
        BuilderInstruction k3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), builderInstruction, methodReference, iArr);
            return;
        }
        e[] eVarArr = this.f203554h.f203538a;
        if (eVarArr != null) {
            int length = eVarArr.length;
            while (true) {
                if (i16 >= length) {
                    break;
                }
                e eVar = eVarArr[i16];
                if (eVar.g(builderInstruction) && eVar.i(methodReference) && (b16 = eVar.b()) != null && (k3 = j.k(builderInstruction, b16)) != null) {
                    d(i3, k3);
                    this.f203555i.b();
                    com.tencent.mobileqq.nlog.c.c("ReplacementMethodVisitor", "replace Class:" + this.f203556j + " replace Configs:" + eVar.toString());
                    if (h.b() != null) {
                        h.b().a(this.f203556j, eVar);
                    }
                } else {
                    i16++;
                }
            }
        }
        super.m(i3, builderInstruction, methodReference, iArr);
    }
}
