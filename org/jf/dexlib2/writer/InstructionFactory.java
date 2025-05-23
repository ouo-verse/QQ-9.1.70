package org.jf.dexlib2.writer;

import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.Instruction;
import org.jf.dexlib2.iface.instruction.SwitchElement;
import org.jf.dexlib2.iface.reference.Reference;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface InstructionFactory<Ref extends Reference> {
    Instruction makeArrayPayload(int i3, @Nullable List<Number> list);

    Instruction makeInstruction10t(@Nonnull Opcode opcode, int i3);

    Instruction makeInstruction10x(@Nonnull Opcode opcode);

    Instruction makeInstruction11n(@Nonnull Opcode opcode, int i3, int i16);

    Instruction makeInstruction11x(@Nonnull Opcode opcode, int i3);

    Instruction makeInstruction12x(@Nonnull Opcode opcode, int i3, int i16);

    Instruction makeInstruction20bc(@Nonnull Opcode opcode, int i3, @Nonnull Ref ref);

    Instruction makeInstruction20t(@Nonnull Opcode opcode, int i3);

    Instruction makeInstruction21c(@Nonnull Opcode opcode, int i3, @Nonnull Ref ref);

    Instruction makeInstruction21ih(@Nonnull Opcode opcode, int i3, int i16);

    Instruction makeInstruction21lh(@Nonnull Opcode opcode, int i3, long j3);

    Instruction makeInstruction21s(@Nonnull Opcode opcode, int i3, int i16);

    Instruction makeInstruction21t(@Nonnull Opcode opcode, int i3, int i16);

    Instruction makeInstruction22b(@Nonnull Opcode opcode, int i3, int i16, int i17);

    Instruction makeInstruction22c(@Nonnull Opcode opcode, int i3, int i16, @Nonnull Ref ref);

    Instruction makeInstruction22s(@Nonnull Opcode opcode, int i3, int i16, int i17);

    Instruction makeInstruction22t(@Nonnull Opcode opcode, int i3, int i16, int i17);

    Instruction makeInstruction22x(@Nonnull Opcode opcode, int i3, int i16);

    Instruction makeInstruction23x(@Nonnull Opcode opcode, int i3, int i16, int i17);

    Instruction makeInstruction30t(@Nonnull Opcode opcode, int i3);

    Instruction makeInstruction31c(@Nonnull Opcode opcode, int i3, @Nonnull Ref ref);

    Instruction makeInstruction31i(@Nonnull Opcode opcode, int i3, int i16);

    Instruction makeInstruction31t(@Nonnull Opcode opcode, int i3, int i16);

    Instruction makeInstruction32x(@Nonnull Opcode opcode, int i3, int i16);

    Instruction makeInstruction35c(@Nonnull Opcode opcode, int i3, int i16, int i17, int i18, int i19, int i26, @Nonnull Ref ref);

    Instruction makeInstruction3rc(@Nonnull Opcode opcode, int i3, int i16, @Nonnull Ref ref);

    Instruction makeInstruction51l(@Nonnull Opcode opcode, int i3, long j3);

    Instruction makePackedSwitchPayload(@Nullable List<? extends SwitchElement> list);

    Instruction makeSparseSwitchPayload(@Nullable List<? extends SwitchElement> list);
}
