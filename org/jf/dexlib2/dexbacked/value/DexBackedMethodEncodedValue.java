package org.jf.dexlib2.dexbacked.value;

import javax.annotation.Nonnull;
import org.jf.dexlib2.base.value.BaseMethodEncodedValue;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.DexReader;
import org.jf.dexlib2.dexbacked.reference.DexBackedMethodReference;
import org.jf.dexlib2.iface.reference.MethodReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedMethodEncodedValue extends BaseMethodEncodedValue {

    @Nonnull
    public final DexBackedDexFile dexFile;
    private final int methodIndex;

    public DexBackedMethodEncodedValue(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull DexReader dexReader, int i3) {
        this.dexFile = dexBackedDexFile;
        this.methodIndex = dexReader.readSizedSmallUint(i3 + 1);
    }

    @Override // org.jf.dexlib2.iface.value.MethodEncodedValue
    @Nonnull
    public MethodReference getValue() {
        return new DexBackedMethodReference(this.dexFile, this.methodIndex);
    }
}
