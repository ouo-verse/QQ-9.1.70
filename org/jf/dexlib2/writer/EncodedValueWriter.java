package org.jf.dexlib2.writer;

import com.google.common.collect.Ordering;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nonnull;
import org.jf.dexlib2.base.BaseAnnotationElement;
import org.jf.dexlib2.iface.AnnotationElement;
import org.jf.dexlib2.iface.reference.FieldReference;
import org.jf.dexlib2.iface.reference.MethodHandleReference;
import org.jf.dexlib2.iface.reference.MethodReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class EncodedValueWriter<StringKey, TypeKey, FieldRefKey extends FieldReference, MethodRefKey extends MethodReference, AnnotationElement extends AnnotationElement, ProtoRefKey, MethodHandleKey extends MethodHandleReference, EncodedValue> {

    @Nonnull
    private final AnnotationSection<StringKey, TypeKey, ?, AnnotationElement, EncodedValue> annotationSection;

    @Nonnull
    private final FieldSection<?, ?, FieldRefKey, ?> fieldSection;

    @Nonnull
    private final MethodHandleSection<MethodHandleKey, ?, ?> methodHandleSection;

    @Nonnull
    private final MethodSection<?, ?, ?, MethodRefKey, ?> methodSection;

    @Nonnull
    private final ProtoSection<?, ?, ProtoRefKey, ?> protoSection;

    @Nonnull
    private final StringSection<StringKey, ?> stringSection;

    @Nonnull
    private final TypeSection<?, TypeKey, ?> typeSection;

    @Nonnull
    private final DexDataWriter writer;

    public EncodedValueWriter(@Nonnull DexDataWriter dexDataWriter, @Nonnull StringSection<StringKey, ?> stringSection, @Nonnull TypeSection<?, TypeKey, ?> typeSection, @Nonnull FieldSection<?, ?, FieldRefKey, ?> fieldSection, @Nonnull MethodSection<?, ?, ?, MethodRefKey, ?> methodSection, ProtoSection<?, ?, ProtoRefKey, ?> protoSection, MethodHandleSection<MethodHandleKey, ?, ?> methodHandleSection, @Nonnull AnnotationSection<StringKey, TypeKey, ?, AnnotationElement, EncodedValue> annotationSection) {
        this.writer = dexDataWriter;
        this.stringSection = stringSection;
        this.typeSection = typeSection;
        this.fieldSection = fieldSection;
        this.methodSection = methodSection;
        this.protoSection = protoSection;
        this.methodHandleSection = methodHandleSection;
        this.annotationSection = annotationSection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void writeAnnotation(TypeKey typekey, Collection<? extends AnnotationElement> collection) throws IOException {
        this.writer.writeEncodedValueHeader(29, 0);
        this.writer.writeUleb128(this.typeSection.getItemIndex((TypeSection<?, TypeKey, ?>) typekey));
        this.writer.writeUleb128(collection.size());
        for (AnnotationElement annotationElement : Ordering.from(BaseAnnotationElement.BY_NAME).immutableSortedCopy(collection)) {
            this.writer.writeUleb128(this.stringSection.getItemIndex((StringSection<StringKey, ?>) this.annotationSection.getElementName(annotationElement)));
            writeEncodedValue(this.annotationSection.getElementValue(annotationElement));
        }
    }

    public void writeArray(Collection<? extends EncodedValue> collection) throws IOException {
        this.writer.writeEncodedValueHeader(28, 0);
        this.writer.writeUleb128(collection.size());
        Iterator<? extends EncodedValue> it = collection.iterator();
        while (it.hasNext()) {
            writeEncodedValue(it.next());
        }
    }

    public void writeBoolean(boolean z16) throws IOException {
        this.writer.writeEncodedValueHeader(31, z16 ? 1 : 0);
    }

    public void writeByte(byte b16) throws IOException {
        this.writer.writeEncodedInt(0, b16);
    }

    public void writeChar(char c16) throws IOException {
        this.writer.writeEncodedUint(3, c16);
    }

    public void writeDouble(double d16) throws IOException {
        this.writer.writeEncodedDouble(17, d16);
    }

    protected abstract void writeEncodedValue(@Nonnull EncodedValue encodedvalue) throws IOException;

    public void writeEnum(@Nonnull FieldRefKey fieldrefkey) throws IOException {
        this.writer.writeEncodedUint(27, this.fieldSection.getItemIndex(fieldrefkey));
    }

    public void writeField(@Nonnull FieldRefKey fieldrefkey) throws IOException {
        this.writer.writeEncodedUint(25, this.fieldSection.getItemIndex(fieldrefkey));
    }

    public void writeFloat(float f16) throws IOException {
        this.writer.writeEncodedFloat(16, f16);
    }

    public void writeInt(int i3) throws IOException {
        this.writer.writeEncodedInt(4, i3);
    }

    public void writeLong(long j3) throws IOException {
        this.writer.writeEncodedLong(6, j3);
    }

    public void writeMethod(@Nonnull MethodRefKey methodrefkey) throws IOException {
        this.writer.writeEncodedUint(26, this.methodSection.getItemIndex(methodrefkey));
    }

    public void writeMethodHandle(@Nonnull MethodHandleKey methodhandlekey) throws IOException {
        this.writer.writeEncodedUint(22, this.methodHandleSection.getItemIndex(methodhandlekey));
    }

    public void writeMethodType(@Nonnull ProtoRefKey protorefkey) throws IOException {
        this.writer.writeEncodedUint(21, this.protoSection.getItemIndex(protorefkey));
    }

    public void writeNull() throws IOException {
        this.writer.write(30);
    }

    public void writeShort(int i3) throws IOException {
        this.writer.writeEncodedInt(2, i3);
    }

    public void writeString(@Nonnull StringKey stringkey) throws IOException {
        this.writer.writeEncodedUint(23, this.stringSection.getItemIndex((StringSection<StringKey, ?>) stringkey));
    }

    public void writeType(@Nonnull TypeKey typekey) throws IOException {
        this.writer.writeEncodedUint(24, this.typeSection.getItemIndex((TypeSection<?, TypeKey, ?>) typekey));
    }
}
