package org.jf.dexlib2.dexbacked.reference;

import javax.annotation.Nonnull;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.iface.reference.Reference;
import org.jf.util.ExceptionWithContext;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class DexBackedReference {
    public static Reference makeReference(@Nonnull DexBackedDexFile dexBackedDexFile, int i3, int i16) {
        switch (i3) {
            case 0:
                return new DexBackedStringReference(dexBackedDexFile, i16);
            case 1:
                return new DexBackedTypeReference(dexBackedDexFile, i16);
            case 2:
                return new DexBackedFieldReference(dexBackedDexFile, i16);
            case 3:
                return new DexBackedMethodReference(dexBackedDexFile, i16);
            case 4:
                return new DexBackedMethodProtoReference(dexBackedDexFile, i16);
            case 5:
                return new DexBackedCallSiteReference(dexBackedDexFile, i16);
            case 6:
                return new DexBackedMethodHandleReference(dexBackedDexFile, i16);
            default:
                throw new ExceptionWithContext("Invalid reference type: %d", Integer.valueOf(i3));
        }
    }
}
