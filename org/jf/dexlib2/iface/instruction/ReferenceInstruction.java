package org.jf.dexlib2.iface.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.iface.reference.Reference;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface ReferenceInstruction extends Instruction {
    @Nonnull
    Reference getReference();

    int getReferenceType();
}
