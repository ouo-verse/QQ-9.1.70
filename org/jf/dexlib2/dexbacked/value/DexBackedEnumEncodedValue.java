package org.jf.dexlib2.dexbacked.value;

import javax.annotation.Nonnull;
import org.jf.dexlib2.base.value.BaseEnumEncodedValue;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.DexReader;
import org.jf.dexlib2.dexbacked.reference.DexBackedFieldReference;
import org.jf.dexlib2.iface.reference.FieldReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedEnumEncodedValue extends BaseEnumEncodedValue {

    @Nonnull
    public final DexBackedDexFile dexFile;
    private final int fieldIndex;

    public DexBackedEnumEncodedValue(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull DexReader dexReader, int i3) {
        this.dexFile = dexBackedDexFile;
        this.fieldIndex = dexReader.readSizedSmallUint(i3 + 1);
    }

    @Override // org.jf.dexlib2.iface.value.EnumEncodedValue
    @Nonnull
    public FieldReference getValue() {
        return new DexBackedFieldReference(this.dexFile, this.fieldIndex);
    }
}
