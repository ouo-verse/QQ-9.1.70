package org.jf.dexlib2.dexbacked;

import javax.annotation.Nonnull;
import org.jf.dexlib2.base.BaseAnnotationElement;
import org.jf.dexlib2.dexbacked.value.DexBackedEncodedValue;
import org.jf.dexlib2.iface.value.EncodedValue;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedAnnotationElement extends BaseAnnotationElement {

    @Nonnull
    private final DexBackedDexFile dexFile;
    public final int nameIndex;

    @Nonnull
    public final EncodedValue value;

    public DexBackedAnnotationElement(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull DexReader dexReader) {
        this.dexFile = dexBackedDexFile;
        this.nameIndex = dexReader.readSmallUleb128();
        this.value = DexBackedEncodedValue.readFrom(dexBackedDexFile, dexReader);
    }

    @Override // org.jf.dexlib2.iface.AnnotationElement
    @Nonnull
    public String getName() {
        return this.dexFile.getStringSection().get(this.nameIndex);
    }

    @Override // org.jf.dexlib2.iface.AnnotationElement
    @Nonnull
    public EncodedValue getValue() {
        return this.value;
    }
}
