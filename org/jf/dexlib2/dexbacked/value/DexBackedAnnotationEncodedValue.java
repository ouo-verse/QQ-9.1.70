package org.jf.dexlib2.dexbacked.value;

import java.util.Set;
import javax.annotation.Nonnull;
import org.jf.dexlib2.base.value.BaseAnnotationEncodedValue;
import org.jf.dexlib2.dexbacked.DexBackedAnnotationElement;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.DexReader;
import org.jf.dexlib2.dexbacked.util.VariableSizeSet;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedAnnotationEncodedValue extends BaseAnnotationEncodedValue {

    @Nonnull
    public final DexBackedDexFile dexFile;
    private final int elementCount;
    private final int elementsOffset;

    @Nonnull
    public final String type;

    public DexBackedAnnotationEncodedValue(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull DexReader dexReader) {
        this.dexFile = dexBackedDexFile;
        this.type = dexBackedDexFile.getTypeSection().get(dexReader.readSmallUleb128());
        int readSmallUleb128 = dexReader.readSmallUleb128();
        this.elementCount = readSmallUleb128;
        this.elementsOffset = dexReader.getOffset();
        skipElements(dexReader, readSmallUleb128);
    }

    private static void skipElements(@Nonnull DexReader dexReader, int i3) {
        for (int i16 = 0; i16 < i3; i16++) {
            dexReader.skipUleb128();
            DexBackedEncodedValue.skipFrom(dexReader);
        }
    }

    public static void skipFrom(@Nonnull DexReader dexReader) {
        dexReader.skipUleb128();
        skipElements(dexReader, dexReader.readSmallUleb128());
    }

    @Override // org.jf.dexlib2.iface.value.AnnotationEncodedValue, org.jf.dexlib2.iface.BasicAnnotation
    @Nonnull
    public Set<? extends DexBackedAnnotationElement> getElements() {
        return new VariableSizeSet<DexBackedAnnotationElement>(this.dexFile.getDataBuffer(), this.elementsOffset, this.elementCount) { // from class: org.jf.dexlib2.dexbacked.value.DexBackedAnnotationEncodedValue.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jf.dexlib2.dexbacked.util.VariableSizeSet
            @Nonnull
            public DexBackedAnnotationElement readNextItem(@Nonnull DexReader dexReader, int i3) {
                return new DexBackedAnnotationElement(DexBackedAnnotationEncodedValue.this.dexFile, dexReader);
            }
        };
    }

    @Override // org.jf.dexlib2.iface.value.AnnotationEncodedValue, org.jf.dexlib2.iface.BasicAnnotation
    @Nonnull
    public String getType() {
        return this.type;
    }
}
