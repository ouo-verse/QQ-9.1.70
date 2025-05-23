package org.jf.dexlib2.iface.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.iface.reference.Reference;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface DualReferenceInstruction extends ReferenceInstruction {
    @Nonnull
    Reference getReference2();

    int getReferenceType2();
}
