package org.jf.dexlib2.dexbacked.value;

import java.util.List;
import javax.annotation.Nonnull;
import org.jf.dexlib2.base.value.BaseArrayEncodedValue;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.DexReader;
import org.jf.dexlib2.dexbacked.util.VariableSizeList;
import org.jf.dexlib2.iface.value.EncodedValue;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedArrayEncodedValue extends BaseArrayEncodedValue {

    @Nonnull
    public final DexBackedDexFile dexFile;
    private final int elementCount;
    private final int encodedArrayOffset;

    public DexBackedArrayEncodedValue(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull DexReader dexReader) {
        this.dexFile = dexBackedDexFile;
        int readSmallUleb128 = dexReader.readSmallUleb128();
        this.elementCount = readSmallUleb128;
        this.encodedArrayOffset = dexReader.getOffset();
        skipElementsFrom(dexReader, readSmallUleb128);
    }

    private static void skipElementsFrom(@Nonnull DexReader dexReader, int i3) {
        for (int i16 = 0; i16 < i3; i16++) {
            DexBackedEncodedValue.skipFrom(dexReader);
        }
    }

    public static void skipFrom(@Nonnull DexReader dexReader) {
        skipElementsFrom(dexReader, dexReader.readSmallUleb128());
    }

    @Override // org.jf.dexlib2.iface.value.ArrayEncodedValue
    @Nonnull
    public List<? extends EncodedValue> getValue() {
        return new VariableSizeList<EncodedValue>(this.dexFile.getDataBuffer(), this.encodedArrayOffset, this.elementCount) { // from class: org.jf.dexlib2.dexbacked.value.DexBackedArrayEncodedValue.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jf.dexlib2.dexbacked.util.VariableSizeList
            @Nonnull
            public EncodedValue readNextItem(@Nonnull DexReader dexReader, int i3) {
                return DexBackedEncodedValue.readFrom(DexBackedArrayEncodedValue.this.dexFile, dexReader);
            }
        };
    }
}
