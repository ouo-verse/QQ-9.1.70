package org.jf.dexlib2.immutable;

import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.Opcodes;
import org.jf.dexlib2.iface.ClassDef;
import org.jf.dexlib2.iface.DexFile;
import org.jf.util.ImmutableUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableDexFile implements DexFile {

    @Nonnull
    protected final ImmutableSet<? extends ImmutableClassDef> classes;

    @Nonnull
    private final Opcodes opcodes;

    public ImmutableDexFile(@Nonnull Opcodes opcodes, @Nullable Collection<? extends ClassDef> collection) {
        this.classes = ImmutableClassDef.immutableSetOf(collection);
        this.opcodes = opcodes;
    }

    public static ImmutableDexFile of(DexFile dexFile) {
        if (dexFile instanceof ImmutableDexFile) {
            return (ImmutableDexFile) dexFile;
        }
        return new ImmutableDexFile(dexFile.getOpcodes(), dexFile.getClasses());
    }

    @Override // org.jf.dexlib2.iface.DexFile
    @Nonnull
    public Opcodes getOpcodes() {
        return this.opcodes;
    }

    @Override // org.jf.dexlib2.iface.DexFile
    @Nonnull
    public ImmutableSet<? extends ImmutableClassDef> getClasses() {
        return this.classes;
    }

    public ImmutableDexFile(@Nonnull Opcodes opcodes, @Nullable ImmutableSet<? extends ImmutableClassDef> immutableSet) {
        this.classes = ImmutableUtils.nullToEmptySet(immutableSet);
        this.opcodes = opcodes;
    }
}
