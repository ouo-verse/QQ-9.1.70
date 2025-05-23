package org.jf.dexlib2.dexbacked.value;

import javax.annotation.Nonnull;
import org.jf.dexlib2.base.value.BaseMethodHandleEncodedValue;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.DexReader;
import org.jf.dexlib2.dexbacked.reference.DexBackedMethodHandleReference;
import org.jf.dexlib2.iface.reference.MethodHandleReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedMethodHandleEncodedValue extends BaseMethodHandleEncodedValue {

    @Nonnull
    public final DexBackedDexFile dexFile;
    private final int methodHandleIndex;

    public DexBackedMethodHandleEncodedValue(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull DexReader dexReader, int i3) {
        this.dexFile = dexBackedDexFile;
        this.methodHandleIndex = dexReader.readSizedSmallUint(i3 + 1);
    }

    @Override // org.jf.dexlib2.iface.value.MethodHandleEncodedValue
    @Nonnull
    public MethodHandleReference getValue() {
        return new DexBackedMethodHandleReference(this.dexFile, this.methodHandleIndex);
    }
}
