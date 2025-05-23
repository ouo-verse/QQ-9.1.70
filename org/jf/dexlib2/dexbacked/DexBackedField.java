package org.jf.dexlib2.dexbacked;

import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.HiddenApiRestriction;
import org.jf.dexlib2.base.reference.BaseFieldReference;
import org.jf.dexlib2.dexbacked.reference.DexBackedFieldReference;
import org.jf.dexlib2.dexbacked.util.AnnotationsDirectory;
import org.jf.dexlib2.dexbacked.util.EncodedArrayItemIterator;
import org.jf.dexlib2.dexbacked.value.DexBackedEncodedValue;
import org.jf.dexlib2.iface.ClassDef;
import org.jf.dexlib2.iface.Field;
import org.jf.dexlib2.iface.value.EncodedValue;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedField extends BaseFieldReference implements Field {
    public final int accessFlags;
    public final int annotationSetOffset;

    @Nonnull
    public final ClassDef classDef;

    @Nonnull
    public final DexBackedDexFile dexFile;
    private int fieldIdItemOffset;
    public final int fieldIndex;
    private final int hiddenApiRestrictions;

    @Nullable
    public final EncodedValue initialValue;
    private final int initialValueOffset;
    private final int startOffset;

    public DexBackedField(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull DexReader dexReader, @Nonnull DexBackedClassDef dexBackedClassDef, int i3, @Nonnull EncodedArrayItemIterator encodedArrayItemIterator, @Nonnull AnnotationsDirectory.AnnotationIterator annotationIterator, int i16) {
        this.dexFile = dexBackedDexFile;
        this.classDef = dexBackedClassDef;
        this.startOffset = dexReader.getOffset();
        int readLargeUleb128 = dexReader.readLargeUleb128() + i3;
        this.fieldIndex = readLargeUleb128;
        this.accessFlags = dexReader.readSmallUleb128();
        this.annotationSetOffset = annotationIterator.seekTo(readLargeUleb128);
        this.initialValueOffset = encodedArrayItemIterator.getReaderOffset();
        this.initialValue = encodedArrayItemIterator.getNextOrNull();
        this.hiddenApiRestrictions = i16;
    }

    private int getFieldIdItemOffset() {
        if (this.fieldIdItemOffset == 0) {
            this.fieldIdItemOffset = this.dexFile.getFieldSection().getOffset(this.fieldIndex);
        }
        return this.fieldIdItemOffset;
    }

    public static void skipFields(@Nonnull DexReader dexReader, int i3) {
        for (int i16 = 0; i16 < i3; i16++) {
            dexReader.skipUleb128();
            dexReader.skipUleb128();
        }
    }

    @Override // org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Member
    public int getAccessFlags() {
        return this.accessFlags;
    }

    @Override // org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Annotatable
    @Nonnull
    public Set<? extends DexBackedAnnotation> getAnnotations() {
        return AnnotationsDirectory.getAnnotations(this.dexFile, this.annotationSetOffset);
    }

    @Override // org.jf.dexlib2.iface.reference.FieldReference, org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Member
    @Nonnull
    public String getDefiningClass() {
        return this.classDef.getType();
    }

    @Override // org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Member
    @Nonnull
    public Set<HiddenApiRestriction> getHiddenApiRestrictions() {
        int i3 = this.hiddenApiRestrictions;
        if (i3 == 7) {
            return ImmutableSet.of();
        }
        return EnumSet.copyOf((Collection) HiddenApiRestriction.getAllFlags(i3));
    }

    @Override // org.jf.dexlib2.iface.Field
    @Nullable
    public EncodedValue getInitialValue() {
        return this.initialValue;
    }

    @Override // org.jf.dexlib2.iface.reference.FieldReference, org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Member
    @Nonnull
    public String getName() {
        return this.dexFile.getStringSection().get(this.dexFile.getBuffer().readSmallUint(getFieldIdItemOffset() + 4));
    }

    public int getSize() {
        DexReader<? extends DexBuffer> readerAt = this.dexFile.getBuffer().readerAt(this.startOffset);
        readerAt.readLargeUleb128();
        readerAt.readSmallUleb128();
        int offset = (readerAt.getOffset() - this.startOffset) + 0;
        if (!getAnnotations().isEmpty()) {
            offset += 8;
        }
        int i3 = this.initialValueOffset;
        if (i3 > 0) {
            readerAt.setOffset(i3);
            if (this.initialValue != null) {
                DexBackedEncodedValue.skipFrom(readerAt);
                offset += readerAt.getOffset() - this.initialValueOffset;
            }
        }
        return offset + new DexBackedFieldReference(this.dexFile, this.fieldIndex).getSize();
    }

    @Override // org.jf.dexlib2.iface.reference.FieldReference, org.jf.dexlib2.iface.Field
    @Nonnull
    public String getType() {
        return this.dexFile.getTypeSection().get(this.dexFile.getBuffer().readUshort(getFieldIdItemOffset() + 2));
    }

    public DexBackedField(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull DexReader dexReader, @Nonnull DexBackedClassDef dexBackedClassDef, int i3, @Nonnull AnnotationsDirectory.AnnotationIterator annotationIterator, int i16) {
        this.dexFile = dexBackedDexFile;
        this.classDef = dexBackedClassDef;
        this.startOffset = dexReader.getOffset();
        int readLargeUleb128 = dexReader.readLargeUleb128() + i3;
        this.fieldIndex = readLargeUleb128;
        this.accessFlags = dexReader.readSmallUleb128();
        this.annotationSetOffset = annotationIterator.seekTo(readLargeUleb128);
        this.initialValueOffset = 0;
        this.initialValue = null;
        this.hiddenApiRestrictions = i16;
    }
}
