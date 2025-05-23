package org.jf.dexlib2.dexbacked.value;

import javax.annotation.Nonnull;
import org.jf.dexlib2.base.value.BaseTypeEncodedValue;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.DexReader;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedTypeEncodedValue extends BaseTypeEncodedValue {

    @Nonnull
    public final DexBackedDexFile dexFile;
    private final int typeIndex;

    public DexBackedTypeEncodedValue(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull DexReader dexReader, int i3) {
        this.dexFile = dexBackedDexFile;
        this.typeIndex = dexReader.readSizedSmallUint(i3 + 1);
    }

    @Override // org.jf.dexlib2.iface.value.TypeEncodedValue
    @Nonnull
    public String getValue() {
        return this.dexFile.getTypeSection().get(this.typeIndex);
    }
}
