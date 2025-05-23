package com.tencent.mobileqq.dexasm;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.Opcodes;
import org.jf.dexlib2.builder.BuilderInstruction;
import org.jf.dexlib2.builder.BuilderTryBlock;
import org.jf.dexlib2.builder.Label;
import org.jf.dexlib2.builder.instruction.BuilderInstruction11x;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.MethodImplementation;
import org.jf.dexlib2.iface.instruction.ReferenceInstruction;
import org.jf.dexlib2.iface.instruction.formats.Instruction21c;
import org.jf.dexlib2.iface.instruction.formats.Instruction22c;
import org.jf.dexlib2.iface.instruction.formats.Instruction31c;
import org.jf.dexlib2.iface.instruction.formats.Instruction35c;
import org.jf.dexlib2.iface.instruction.formats.Instruction3rc;
import org.jf.dexlib2.iface.reference.FieldReference;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.dexlib2.iface.reference.TypeReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @Nonnull
    protected final Opcodes f203516a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    protected k f203517b;

    /* renamed from: c, reason: collision with root package name */
    private int f203518c;

    /* renamed from: d, reason: collision with root package name */
    private m f203519d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f203520a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16530);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[Opcode.values().length];
            f203520a = iArr;
            try {
                iArr[Opcode.RETURN_VOID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f203520a[Opcode.RETURN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f203520a[Opcode.RETURN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f203520a[Opcode.RETURN_WIDE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public k(@Nonnull Opcodes opcodes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f203516a = opcodes;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) opcodes);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean j(BuilderInstruction builderInstruction, short s16) {
        if (s16 >= this.f203516a.getOpcodeValue(Opcode.IGET).shortValue() && s16 <= this.f203516a.getOpcodeValue(Opcode.IPUT_SHORT).shortValue()) {
            Instruction22c instruction22c = (Instruction22c) builderInstruction;
            i(this.f203518c, builderInstruction, instruction22c.getRegisterA(), instruction22c.getRegisterB(), (FieldReference) instruction22c.getReference());
            return true;
        }
        if (s16 >= this.f203516a.getOpcodeValue(Opcode.SGET).shortValue() && s16 <= this.f203516a.getOpcodeValue(Opcode.SPUT_SHORT).shortValue()) {
            Instruction21c instruction21c = (Instruction21c) builderInstruction;
            i(this.f203518c, builderInstruction, instruction21c.getRegisterA(), -1, (FieldReference) instruction21c.getReference());
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean n(BuilderInstruction builderInstruction, short s16) {
        if (s16 >= this.f203516a.getOpcodeValue(Opcode.INVOKE_VIRTUAL).shortValue() && s16 <= this.f203516a.getOpcodeValue(Opcode.INVOKE_INTERFACE).shortValue()) {
            Instruction35c instruction35c = (Instruction35c) builderInstruction;
            m(this.f203518c, builderInstruction, (MethodReference) instruction35c.getReference(), h.b(instruction35c));
            return true;
        }
        if (s16 >= this.f203516a.getOpcodeValue(Opcode.INVOKE_VIRTUAL_RANGE).shortValue() && s16 <= this.f203516a.getOpcodeValue(Opcode.INVOKE_INTERFACE_RANGE).shortValue()) {
            Instruction3rc instruction3rc = (Instruction3rc) builderInstruction;
            m(this.f203518c, builderInstruction, (MethodReference) instruction3rc.getReference(), h.c(instruction3rc));
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean o(BuilderInstruction builderInstruction) {
        if ((builderInstruction instanceof ReferenceInstruction) && ((ReferenceInstruction) builderInstruction).getReferenceType() == 1) {
            if (builderInstruction instanceof Instruction21c) {
                Instruction21c instruction21c = (Instruction21c) builderInstruction;
                s(this.f203518c, builderInstruction, (TypeReference) instruction21c.getReference(), instruction21c.getRegisterA());
                return true;
            }
            if (builderInstruction instanceof Instruction22c) {
                Instruction22c instruction22c = (Instruction22c) builderInstruction;
                s(this.f203518c, builderInstruction, (TypeReference) instruction22c.getReference(), instruction22c.getRegisterA(), instruction22c.getRegisterB());
                return true;
            }
            if (builderInstruction instanceof Instruction31c) {
                Instruction31c instruction31c = (Instruction31c) builderInstruction;
                s(this.f203518c, builderInstruction, (TypeReference) instruction31c.getReference(), instruction31c.getRegisterA());
                return true;
            }
            if (builderInstruction instanceof Instruction35c) {
                Instruction35c instruction35c = (Instruction35c) builderInstruction;
                s(this.f203518c, builderInstruction, (TypeReference) instruction35c.getReference(), h.b(instruction35c));
                return true;
            }
            if (builderInstruction instanceof Instruction3rc) {
                Instruction3rc instruction3rc = (Instruction3rc) builderInstruction;
                s(this.f203518c, builderInstruction, (TypeReference) instruction3rc.getReference(), h.c(instruction3rc));
                return true;
            }
        }
        return false;
    }

    private boolean r(BuilderInstruction builderInstruction) {
        int i3 = a.f203520a[builderInstruction.getOpcode().ordinal()];
        if (i3 != 1) {
            if (i3 != 2 && i3 != 3 && i3 != 4) {
                return false;
            }
            q(this.f203518c, builderInstruction, ((BuilderInstruction11x) builderInstruction).getRegisterA());
            return true;
        }
        q(this.f203518c, builderInstruction, -1);
        return true;
    }

    public final void a(int i3, @Nonnull BuilderInstruction builderInstruction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3, (Object) builderInstruction);
            return;
        }
        n.k(builderInstruction);
        n.o(builderInstruction);
        b(i3, builderInstruction);
        int i16 = this.f203518c;
        if (i3 <= i16) {
            this.f203518c = i16 + 1;
        }
    }

    protected void b(int i3, @Nonnull BuilderInstruction builderInstruction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3, (Object) builderInstruction);
            return;
        }
        k kVar = this.f203517b;
        if (kVar != null) {
            kVar.a(i3, builderInstruction);
        }
    }

    protected void c(int i3, @Nonnull BuilderInstruction builderInstruction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3, (Object) builderInstruction);
            return;
        }
        k kVar = this.f203517b;
        if (kVar != null) {
            kVar.d(i3, builderInstruction);
        }
    }

    public final void d(int i3, @Nonnull BuilderInstruction builderInstruction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3, (Object) builderInstruction);
            return;
        }
        n.k(builderInstruction);
        n.o(builderInstruction);
        c(i3, builderInstruction);
    }

    public b e(Annotation annotation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) annotation);
        }
        k kVar = this.f203517b;
        if (kVar != null) {
            return kVar.e(annotation);
        }
        return null;
    }

    public void f(@Nullable String str, @Nonnull Label label, @Nonnull Label label2, @Nonnull Label label3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, str, label, label2, label3);
            return;
        }
        k kVar = this.f203517b;
        if (kVar != null) {
            kVar.f(str, label, label2, label3);
        }
    }

    public m g(@Nonnull MethodImplementation methodImplementation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (m) iPatchRedirector.redirect((short) 5, (Object) this, (Object) methodImplementation);
        }
        k kVar = this.f203517b;
        if (kVar != null) {
            return kVar.g(methodImplementation);
        }
        return null;
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        k kVar = this.f203517b;
        if (kVar != null) {
            kVar.h();
        }
    }

    public void i(int i3, @Nonnull BuilderInstruction builderInstruction, int i16, int i17, @Nonnull FieldReference fieldReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), builderInstruction, Integer.valueOf(i16), Integer.valueOf(i17), fieldReference);
            return;
        }
        k kVar = this.f203517b;
        if (kVar != null) {
            kVar.i(i3, builderInstruction, i16, i17, fieldReference);
        }
    }

    public final void k(@Nullable MethodImplementation methodImplementation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) methodImplementation);
            return;
        }
        if (methodImplementation == null) {
            return;
        }
        p(methodImplementation.getRegisterCount());
        m g16 = g(methodImplementation);
        this.f203519d = g16;
        List<BuilderInstruction> instructions = g16.getInstructions();
        int i3 = 0;
        while (true) {
            this.f203518c = i3;
            if (this.f203518c >= instructions.size()) {
                break;
            }
            BuilderInstruction builderInstruction = instructions.get(this.f203518c);
            short shortValue = this.f203516a.getOpcodeValue(builderInstruction.getOpcode()).shortValue();
            if (!j(builderInstruction, shortValue) && !n(builderInstruction, shortValue) && !o(builderInstruction) && !r(builderInstruction)) {
                l(this.f203518c, builderInstruction);
            }
            i3 = this.f203518c + 1;
        }
        for (BuilderTryBlock builderTryBlock : this.f203519d.getTryBlocks()) {
            f(builderTryBlock.exceptionHandler.getExceptionType(), builderTryBlock.start, builderTryBlock.end, builderTryBlock.exceptionHandler.getHandler());
        }
    }

    public void l(int i3, @Nonnull BuilderInstruction builderInstruction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) builderInstruction);
            return;
        }
        k kVar = this.f203517b;
        if (kVar != null) {
            kVar.l(i3, builderInstruction);
        }
    }

    public void m(int i3, @Nonnull BuilderInstruction builderInstruction, @Nonnull MethodReference methodReference, int... iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), builderInstruction, methodReference, iArr);
            return;
        }
        k kVar = this.f203517b;
        if (kVar != null) {
            kVar.m(i3, builderInstruction, methodReference, iArr);
        }
    }

    public void p(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        k kVar = this.f203517b;
        if (kVar != null) {
            kVar.p(i3);
        }
    }

    public void q(int i3, @Nonnull BuilderInstruction builderInstruction, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), builderInstruction, Integer.valueOf(i16));
            return;
        }
        k kVar = this.f203517b;
        if (kVar != null) {
            kVar.q(i3, builderInstruction, i16);
        }
    }

    public void s(int i3, @Nonnull BuilderInstruction builderInstruction, @Nonnull TypeReference typeReference, int... iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), builderInstruction, typeReference, iArr);
            return;
        }
        k kVar = this.f203517b;
        if (kVar != null) {
            kVar.s(i3, builderInstruction, typeReference, iArr);
        }
    }

    public k(Opcodes opcodes, @Nullable k kVar) {
        this(opcodes);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f203517b = kVar;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) opcodes, (Object) kVar);
        }
    }
}
