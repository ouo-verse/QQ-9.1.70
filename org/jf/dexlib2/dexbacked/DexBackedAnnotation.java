package org.jf.dexlib2.dexbacked;

import java.util.Set;
import javax.annotation.Nonnull;
import org.jf.dexlib2.base.BaseAnnotation;
import org.jf.dexlib2.dexbacked.util.VariableSizeSet;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedAnnotation extends BaseAnnotation {

    @Nonnull
    public final DexBackedDexFile dexFile;
    private final int elementsOffset;
    public final int typeIndex;
    public final int visibility;

    public DexBackedAnnotation(@Nonnull DexBackedDexFile dexBackedDexFile, int i3) {
        this.dexFile = dexBackedDexFile;
        DexReader<? extends DexBuffer> readerAt = dexBackedDexFile.getDataBuffer().readerAt(i3);
        this.visibility = readerAt.readUbyte();
        this.typeIndex = readerAt.readSmallUleb128();
        this.elementsOffset = readerAt.getOffset();
    }

    @Override // org.jf.dexlib2.iface.Annotation, org.jf.dexlib2.iface.BasicAnnotation
    @Nonnull
    public Set<? extends DexBackedAnnotationElement> getElements() {
        DexReader<? extends DexBuffer> readerAt = this.dexFile.getDataBuffer().readerAt(this.elementsOffset);
        return new VariableSizeSet<DexBackedAnnotationElement>(this.dexFile.getDataBuffer(), readerAt.getOffset(), readerAt.readSmallUleb128()) { // from class: org.jf.dexlib2.dexbacked.DexBackedAnnotation.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jf.dexlib2.dexbacked.util.VariableSizeSet
            @Nonnull
            public DexBackedAnnotationElement readNextItem(@Nonnull DexReader dexReader, int i3) {
                return new DexBackedAnnotationElement(DexBackedAnnotation.this.dexFile, dexReader);
            }
        };
    }

    @Override // org.jf.dexlib2.iface.Annotation, org.jf.dexlib2.iface.BasicAnnotation
    @Nonnull
    public String getType() {
        return this.dexFile.getTypeSection().get(this.typeIndex);
    }

    @Override // org.jf.dexlib2.iface.Annotation
    public int getVisibility() {
        return this.visibility;
    }
}
