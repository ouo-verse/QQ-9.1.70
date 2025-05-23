package org.jf.dexlib2.iface;

import java.util.Set;
import javax.annotation.Nonnull;
import org.jf.dexlib2.Opcodes;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface DexFile {
    @Nonnull
    Set<? extends ClassDef> getClasses();

    @Nonnull
    Opcodes getOpcodes();
}
