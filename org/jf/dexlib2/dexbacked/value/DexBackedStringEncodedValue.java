package org.jf.dexlib2.dexbacked.value;

import javax.annotation.Nonnull;
import org.jf.dexlib2.base.value.BaseStringEncodedValue;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.DexReader;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedStringEncodedValue extends BaseStringEncodedValue {

    @Nonnull
    public final DexBackedDexFile dexFile;
    private final int stringIndex;

    public DexBackedStringEncodedValue(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull DexReader dexReader, int i3) {
        this.dexFile = dexBackedDexFile;
        this.stringIndex = dexReader.readSizedSmallUint(i3 + 1);
    }

    @Override // org.jf.dexlib2.iface.value.StringEncodedValue
    @Nonnull
    public String getValue() {
        return this.dexFile.getStringSection().get(this.stringIndex);
    }
}
