package org.jf.dexlib2.writer.pool;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nonnull;
import org.jf.dexlib2.Opcodes;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.AnnotationElement;
import org.jf.dexlib2.iface.ClassDef;
import org.jf.dexlib2.iface.DexFile;
import org.jf.dexlib2.iface.Field;
import org.jf.dexlib2.iface.reference.CallSiteReference;
import org.jf.dexlib2.iface.reference.FieldReference;
import org.jf.dexlib2.iface.reference.MethodHandleReference;
import org.jf.dexlib2.iface.reference.MethodProtoReference;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.dexlib2.iface.reference.StringReference;
import org.jf.dexlib2.iface.reference.TypeReference;
import org.jf.dexlib2.iface.value.AnnotationEncodedValue;
import org.jf.dexlib2.iface.value.ArrayEncodedValue;
import org.jf.dexlib2.iface.value.BooleanEncodedValue;
import org.jf.dexlib2.iface.value.ByteEncodedValue;
import org.jf.dexlib2.iface.value.CharEncodedValue;
import org.jf.dexlib2.iface.value.DoubleEncodedValue;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.iface.value.EnumEncodedValue;
import org.jf.dexlib2.iface.value.FieldEncodedValue;
import org.jf.dexlib2.iface.value.FloatEncodedValue;
import org.jf.dexlib2.iface.value.IntEncodedValue;
import org.jf.dexlib2.iface.value.LongEncodedValue;
import org.jf.dexlib2.iface.value.MethodEncodedValue;
import org.jf.dexlib2.iface.value.MethodHandleEncodedValue;
import org.jf.dexlib2.iface.value.MethodTypeEncodedValue;
import org.jf.dexlib2.iface.value.ShortEncodedValue;
import org.jf.dexlib2.iface.value.StringEncodedValue;
import org.jf.dexlib2.iface.value.TypeEncodedValue;
import org.jf.dexlib2.writer.DexWriter;
import org.jf.dexlib2.writer.io.DexDataStore;
import org.jf.dexlib2.writer.io.FileDataStore;
import org.jf.dexlib2.writer.pool.TypeListPool;
import org.jf.util.ExceptionWithContext;

/* loaded from: classes29.dex */
public class DexPool extends DexWriter<CharSequence, StringReference, CharSequence, TypeReference, MethodProtoReference, FieldReference, MethodReference, PoolClassDef, CallSiteReference, MethodHandleReference, Annotation, Set<? extends Annotation>, TypeListPool.Key<? extends Collection<? extends CharSequence>>, Field, PoolMethod, ArrayEncodedValue, EncodedValue, AnnotationElement, StringPool, TypePool, ProtoPool, FieldPool, MethodPool, ClassPool, CallSitePool, MethodHandlePool, TypeListPool, AnnotationPool, AnnotationSetPool, EncodedArrayPool> {
    private final BasePool<?, ?>[] sections;

    /* loaded from: classes29.dex */
    protected class DexPoolSectionProvider extends DexWriter<CharSequence, StringReference, CharSequence, TypeReference, MethodProtoReference, FieldReference, MethodReference, PoolClassDef, CallSiteReference, MethodHandleReference, Annotation, Set<? extends Annotation>, TypeListPool.Key<? extends Collection<? extends CharSequence>>, Field, PoolMethod, ArrayEncodedValue, EncodedValue, AnnotationElement, StringPool, TypePool, ProtoPool, FieldPool, MethodPool, ClassPool, CallSitePool, MethodHandlePool, TypeListPool, AnnotationPool, AnnotationSetPool, EncodedArrayPool>.SectionProvider {
        protected DexPoolSectionProvider() {
            super();
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        @Nonnull
        public AnnotationPool getAnnotationSection() {
            return new AnnotationPool(DexPool.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        @Nonnull
        public AnnotationSetPool getAnnotationSetSection() {
            return new AnnotationSetPool(DexPool.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        @Nonnull
        public CallSitePool getCallSiteSection() {
            return new CallSitePool(DexPool.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        @Nonnull
        public ClassPool getClassSection() {
            return new ClassPool(DexPool.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        @Nonnull
        public EncodedArrayPool getEncodedArraySection() {
            return new EncodedArrayPool(DexPool.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        @Nonnull
        public FieldPool getFieldSection() {
            return new FieldPool(DexPool.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        @Nonnull
        public MethodHandlePool getMethodHandleSection() {
            return new MethodHandlePool(DexPool.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        @Nonnull
        public MethodPool getMethodSection() {
            return new MethodPool(DexPool.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        @Nonnull
        public ProtoPool getProtoSection() {
            return new ProtoPool(DexPool.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        @Nonnull
        public StringPool getStringSection() {
            return new StringPool(DexPool.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        @Nonnull
        public TypeListPool getTypeListSection() {
            return new TypeListPool(DexPool.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        @Nonnull
        public TypePool getTypeSection() {
            return new TypePool(DexPool.this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DexPool(Opcodes opcodes) {
        super(opcodes);
        this.sections = new BasePool[]{(BasePool) this.stringSection, (BasePool) this.typeSection, (BasePool) this.protoSection, (BasePool) this.fieldSection, (BasePool) this.methodSection, (BasePool) this.classSection, (BasePool) this.callSiteSection, (BasePool) this.methodHandleSection, (BasePool) this.typeListSection, (BasePool) this.annotationSection, (BasePool) this.annotationSetSection, (BasePool) this.encodedArraySection};
    }

    public static void writeTo(@Nonnull DexDataStore dexDataStore, @Nonnull DexFile dexFile) throws IOException {
        DexPool dexPool = new DexPool(dexFile.getOpcodes());
        Iterator<? extends ClassDef> it = dexFile.getClasses().iterator();
        while (it.hasNext()) {
            dexPool.internClass(it.next());
        }
        dexPool.writeTo(dexDataStore);
    }

    @Override // org.jf.dexlib2.writer.DexWriter
    @Nonnull
    protected DexWriter<CharSequence, StringReference, CharSequence, TypeReference, MethodProtoReference, FieldReference, MethodReference, PoolClassDef, CallSiteReference, MethodHandleReference, Annotation, Set<? extends Annotation>, TypeListPool.Key<? extends Collection<? extends CharSequence>>, Field, PoolMethod, ArrayEncodedValue, EncodedValue, AnnotationElement, StringPool, TypePool, ProtoPool, FieldPool, MethodPool, ClassPool, CallSitePool, MethodHandlePool, TypeListPool, AnnotationPool, AnnotationSetPool, EncodedArrayPool>.SectionProvider getSectionProvider() {
        return new DexPoolSectionProvider();
    }

    public void internClass(ClassDef classDef) {
        ((ClassPool) this.classSection).intern(classDef);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void internEncodedValue(@Nonnull EncodedValue encodedValue) {
        switch (encodedValue.getValueType()) {
            case 21:
                ((ProtoPool) this.protoSection).intern(((MethodTypeEncodedValue) encodedValue).getValue());
                return;
            case 22:
                ((MethodHandlePool) this.methodHandleSection).intern(((MethodHandleEncodedValue) encodedValue).getValue());
                return;
            case 23:
                ((StringPool) this.stringSection).intern(((StringEncodedValue) encodedValue).getValue());
                return;
            case 24:
                ((TypePool) this.typeSection).intern(((TypeEncodedValue) encodedValue).getValue());
                return;
            case 25:
                ((FieldPool) this.fieldSection).intern(((FieldEncodedValue) encodedValue).getValue());
                return;
            case 26:
                ((MethodPool) this.methodSection).intern(((MethodEncodedValue) encodedValue).getValue());
                return;
            case 27:
                ((FieldPool) this.fieldSection).intern(((EnumEncodedValue) encodedValue).getValue());
                return;
            case 28:
                Iterator<? extends EncodedValue> it = ((ArrayEncodedValue) encodedValue).getValue().iterator();
                while (it.hasNext()) {
                    internEncodedValue(it.next());
                }
                return;
            case 29:
                AnnotationEncodedValue annotationEncodedValue = (AnnotationEncodedValue) encodedValue;
                ((TypePool) this.typeSection).intern(annotationEncodedValue.getType());
                for (AnnotationElement annotationElement : annotationEncodedValue.getElements()) {
                    ((StringPool) this.stringSection).intern(annotationElement.getName());
                    internEncodedValue(annotationElement.getValue());
                }
                return;
            default:
                return;
        }
    }

    public void mark() {
        for (BasePool<?, ?> basePool : this.sections) {
            basePool.mark();
        }
    }

    public void reset() {
        for (BasePool<?, ?> basePool : this.sections) {
            basePool.reset();
        }
    }

    @Override // org.jf.dexlib2.writer.DexWriter
    protected /* bridge */ /* synthetic */ void writeEncodedValue(@Nonnull DexWriter.InternalEncodedValueWriter internalEncodedValueWriter, @Nonnull EncodedValue encodedValue) throws IOException {
        writeEncodedValue2((DexWriter<CharSequence, StringReference, CharSequence, TypeReference, MethodProtoReference, FieldReference, MethodReference, PoolClassDef, CallSiteReference, MethodHandleReference, Annotation, Set<? extends Annotation>, TypeListPool.Key<? extends Collection<? extends CharSequence>>, Field, PoolMethod, ArrayEncodedValue, EncodedValue, AnnotationElement, StringPool, TypePool, ProtoPool, FieldPool, MethodPool, ClassPool, CallSitePool, MethodHandlePool, TypeListPool, AnnotationPool, AnnotationSetPool, EncodedArrayPool>.InternalEncodedValueWriter) internalEncodedValueWriter, encodedValue);
    }

    /* renamed from: writeEncodedValue, reason: avoid collision after fix types in other method */
    protected void writeEncodedValue2(@Nonnull DexWriter<CharSequence, StringReference, CharSequence, TypeReference, MethodProtoReference, FieldReference, MethodReference, PoolClassDef, CallSiteReference, MethodHandleReference, Annotation, Set<? extends Annotation>, TypeListPool.Key<? extends Collection<? extends CharSequence>>, Field, PoolMethod, ArrayEncodedValue, EncodedValue, AnnotationElement, StringPool, TypePool, ProtoPool, FieldPool, MethodPool, ClassPool, CallSitePool, MethodHandlePool, TypeListPool, AnnotationPool, AnnotationSetPool, EncodedArrayPool>.InternalEncodedValueWriter internalEncodedValueWriter, @Nonnull EncodedValue encodedValue) throws IOException {
        int valueType = encodedValue.getValueType();
        if (valueType == 0) {
            internalEncodedValueWriter.writeByte(((ByteEncodedValue) encodedValue).getValue());
            return;
        }
        if (valueType == 6) {
            internalEncodedValueWriter.writeLong(((LongEncodedValue) encodedValue).getValue());
            return;
        }
        if (valueType == 2) {
            internalEncodedValueWriter.writeShort(((ShortEncodedValue) encodedValue).getValue());
            return;
        }
        if (valueType == 3) {
            internalEncodedValueWriter.writeChar(((CharEncodedValue) encodedValue).getValue());
            return;
        }
        if (valueType == 4) {
            internalEncodedValueWriter.writeInt(((IntEncodedValue) encodedValue).getValue());
            return;
        }
        if (valueType == 16) {
            internalEncodedValueWriter.writeFloat(((FloatEncodedValue) encodedValue).getValue());
            return;
        }
        if (valueType != 17) {
            switch (valueType) {
                case 21:
                    internalEncodedValueWriter.writeMethodType(((MethodTypeEncodedValue) encodedValue).getValue());
                    return;
                case 22:
                    internalEncodedValueWriter.writeMethodHandle(((MethodHandleEncodedValue) encodedValue).getValue());
                    return;
                case 23:
                    internalEncodedValueWriter.writeString(((StringEncodedValue) encodedValue).getValue());
                    return;
                case 24:
                    internalEncodedValueWriter.writeType(((TypeEncodedValue) encodedValue).getValue());
                    return;
                case 25:
                    internalEncodedValueWriter.writeField(((FieldEncodedValue) encodedValue).getValue());
                    return;
                case 26:
                    internalEncodedValueWriter.writeMethod(((MethodEncodedValue) encodedValue).getValue());
                    return;
                case 27:
                    internalEncodedValueWriter.writeEnum(((EnumEncodedValue) encodedValue).getValue());
                    return;
                case 28:
                    internalEncodedValueWriter.writeArray(((ArrayEncodedValue) encodedValue).getValue());
                    return;
                case 29:
                    AnnotationEncodedValue annotationEncodedValue = (AnnotationEncodedValue) encodedValue;
                    internalEncodedValueWriter.writeAnnotation(annotationEncodedValue.getType(), annotationEncodedValue.getElements());
                    return;
                case 30:
                    internalEncodedValueWriter.writeNull();
                    return;
                case 31:
                    internalEncodedValueWriter.writeBoolean(((BooleanEncodedValue) encodedValue).getValue());
                    return;
                default:
                    throw new ExceptionWithContext("Unrecognized value type: %d", Integer.valueOf(encodedValue.getValueType()));
            }
        }
        internalEncodedValueWriter.writeDouble(((DoubleEncodedValue) encodedValue).getValue());
    }

    public static void writeTo(@Nonnull String str, @Nonnull DexFile dexFile) throws IOException {
        DexPool dexPool = new DexPool(dexFile.getOpcodes());
        Iterator<? extends ClassDef> it = dexFile.getClasses().iterator();
        while (it.hasNext()) {
            dexPool.internClass(it.next());
        }
        dexPool.writeTo(new FileDataStore(new File(str)));
    }
}
