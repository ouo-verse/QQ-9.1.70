package org.jf.dexlib2.writer.builder;

import com.google.common.base.d;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.ab;
import com.google.common.collect.q;
import com.google.common.collect.r;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.HiddenApiRestriction;
import org.jf.dexlib2.Opcodes;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.AnnotationElement;
import org.jf.dexlib2.iface.MethodImplementation;
import org.jf.dexlib2.iface.MethodParameter;
import org.jf.dexlib2.iface.reference.CallSiteReference;
import org.jf.dexlib2.iface.reference.FieldReference;
import org.jf.dexlib2.iface.reference.MethodHandleReference;
import org.jf.dexlib2.iface.reference.MethodProtoReference;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.dexlib2.iface.reference.Reference;
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
import org.jf.dexlib2.util.FieldUtil;
import org.jf.dexlib2.writer.DexWriter;
import org.jf.dexlib2.writer.builder.BuilderEncodedValues;
import org.jf.dexlib2.writer.util.StaticInitializerUtil;
import org.jf.util.ExceptionWithContext;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBuilder extends DexWriter<BuilderStringReference, BuilderStringReference, BuilderTypeReference, BuilderTypeReference, BuilderMethodProtoReference, BuilderFieldReference, BuilderMethodReference, BuilderClassDef, BuilderCallSiteReference, BuilderMethodHandleReference, BuilderAnnotation, BuilderAnnotationSet, BuilderTypeList, BuilderField, BuilderMethod, BuilderEncodedValues.BuilderArrayEncodedValue, BuilderEncodedValues.BuilderEncodedValue, BuilderAnnotationElement, BuilderStringPool, BuilderTypePool, BuilderProtoPool, BuilderFieldPool, BuilderMethodPool, BuilderClassPool, BuilderCallSitePool, BuilderMethodHandlePool, BuilderTypeListPool, BuilderAnnotationPool, BuilderAnnotationSetPool, BuilderEncodedArrayPool> {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    protected class DexBuilderSectionProvider extends DexWriter<BuilderStringReference, BuilderStringReference, BuilderTypeReference, BuilderTypeReference, BuilderMethodProtoReference, BuilderFieldReference, BuilderMethodReference, BuilderClassDef, BuilderCallSiteReference, BuilderMethodHandleReference, BuilderAnnotation, BuilderAnnotationSet, BuilderTypeList, BuilderField, BuilderMethod, BuilderEncodedValues.BuilderArrayEncodedValue, BuilderEncodedValues.BuilderEncodedValue, BuilderAnnotationElement, BuilderStringPool, BuilderTypePool, BuilderProtoPool, BuilderFieldPool, BuilderMethodPool, BuilderClassPool, BuilderCallSitePool, BuilderMethodHandlePool, BuilderTypeListPool, BuilderAnnotationPool, BuilderAnnotationSetPool, BuilderEncodedArrayPool>.SectionProvider {
        protected DexBuilderSectionProvider() {
            super();
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        @Nonnull
        public BuilderAnnotationPool getAnnotationSection() {
            return new BuilderAnnotationPool(DexBuilder.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        @Nonnull
        public BuilderAnnotationSetPool getAnnotationSetSection() {
            return new BuilderAnnotationSetPool(DexBuilder.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        @Nonnull
        public BuilderCallSitePool getCallSiteSection() {
            return new BuilderCallSitePool(DexBuilder.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        @Nonnull
        public BuilderClassPool getClassSection() {
            return new BuilderClassPool(DexBuilder.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        @Nonnull
        public BuilderEncodedArrayPool getEncodedArraySection() {
            return new BuilderEncodedArrayPool(DexBuilder.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        @Nonnull
        public BuilderFieldPool getFieldSection() {
            return new BuilderFieldPool(DexBuilder.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        @Nonnull
        public BuilderMethodHandlePool getMethodHandleSection() {
            return new BuilderMethodHandlePool(DexBuilder.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        @Nonnull
        public BuilderMethodPool getMethodSection() {
            return new BuilderMethodPool(DexBuilder.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        @Nonnull
        public BuilderProtoPool getProtoSection() {
            return new BuilderProtoPool(DexBuilder.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        @Nonnull
        public BuilderStringPool getStringSection() {
            return new BuilderStringPool();
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        @Nonnull
        public BuilderTypeListPool getTypeListSection() {
            return new BuilderTypeListPool(DexBuilder.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        @Nonnull
        public BuilderTypePool getTypeSection() {
            return new BuilderTypePool(DexBuilder.this);
        }
    }

    public DexBuilder(@Nonnull Opcodes opcodes) {
        super(opcodes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nonnull
    public BuilderAnnotationElement internAnnotationElement(@Nonnull AnnotationElement annotationElement) {
        return new BuilderAnnotationElement(((BuilderStringPool) this.stringSection).internString(annotationElement.getName()), internEncodedValue(annotationElement.getValue()));
    }

    @Nonnull
    private BuilderEncodedValues.BuilderAnnotationEncodedValue internAnnotationEncodedValue(@Nonnull AnnotationEncodedValue annotationEncodedValue) {
        return new BuilderEncodedValues.BuilderAnnotationEncodedValue(((BuilderTypePool) this.typeSection).internType(annotationEncodedValue.getType()), internAnnotationElements(annotationEncodedValue.getElements()));
    }

    @Nonnull
    private BuilderEncodedValues.BuilderArrayEncodedValue internArrayEncodedValue(@Nonnull ArrayEncodedValue arrayEncodedValue) {
        return new BuilderEncodedValues.BuilderArrayEncodedValue(ImmutableList.copyOf(r.x(arrayEncodedValue.getValue().iterator(), new d<EncodedValue, BuilderEncodedValues.BuilderEncodedValue>() { // from class: org.jf.dexlib2.writer.builder.DexBuilder.3
            @Override // com.google.common.base.d
            @Nullable
            public BuilderEncodedValues.BuilderEncodedValue apply(EncodedValue encodedValue) {
                return DexBuilder.this.internEncodedValue(encodedValue);
            }
        })));
    }

    @Nonnull
    private BuilderEncodedValues.BuilderEnumEncodedValue internEnumEncodedValue(@Nonnull EnumEncodedValue enumEncodedValue) {
        return new BuilderEncodedValues.BuilderEnumEncodedValue(((BuilderFieldPool) this.fieldSection).internField(enumEncodedValue.getValue()));
    }

    @Nonnull
    private BuilderEncodedValues.BuilderFieldEncodedValue internFieldEncodedValue(@Nonnull FieldEncodedValue fieldEncodedValue) {
        return new BuilderEncodedValues.BuilderFieldEncodedValue(((BuilderFieldPool) this.fieldSection).internField(fieldEncodedValue.getValue()));
    }

    @Nonnull
    private BuilderEncodedValues.BuilderMethodEncodedValue internMethodEncodedValue(@Nonnull MethodEncodedValue methodEncodedValue) {
        return new BuilderEncodedValues.BuilderMethodEncodedValue(((BuilderMethodPool) this.methodSection).internMethod(methodEncodedValue.getValue()));
    }

    @Nonnull
    private BuilderEncodedValues.BuilderMethodHandleEncodedValue internMethodHandleEncodedValue(@Nonnull MethodHandleEncodedValue methodHandleEncodedValue) {
        return new BuilderEncodedValues.BuilderMethodHandleEncodedValue(((BuilderMethodHandlePool) this.methodHandleSection).internMethodHandle(methodHandleEncodedValue.getValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nonnull
    public BuilderMethodParameter internMethodParameter(@Nonnull MethodParameter methodParameter) {
        return new BuilderMethodParameter(((BuilderTypePool) this.typeSection).internType(methodParameter.getType()), ((BuilderStringPool) this.stringSection).internNullableString(methodParameter.getName()), ((BuilderAnnotationSetPool) this.annotationSetSection).internAnnotationSet(methodParameter.getAnnotations()));
    }

    @Nonnull
    private List<BuilderMethodParameter> internMethodParameters(@Nullable List<? extends MethodParameter> list) {
        if (list == null) {
            return ImmutableList.of();
        }
        return ImmutableList.copyOf(r.x(list.iterator(), new d<MethodParameter, BuilderMethodParameter>() { // from class: org.jf.dexlib2.writer.builder.DexBuilder.1
            @Override // com.google.common.base.d
            @Nullable
            public BuilderMethodParameter apply(MethodParameter methodParameter) {
                return DexBuilder.this.internMethodParameter(methodParameter);
            }
        }));
    }

    @Nonnull
    private BuilderEncodedValues.BuilderMethodTypeEncodedValue internMethodTypeEncodedValue(@Nonnull MethodTypeEncodedValue methodTypeEncodedValue) {
        return new BuilderEncodedValues.BuilderMethodTypeEncodedValue(((BuilderProtoPool) this.protoSection).internMethodProto(methodTypeEncodedValue.getValue()));
    }

    @Nonnull
    private BuilderEncodedValues.BuilderStringEncodedValue internStringEncodedValue(@Nonnull StringEncodedValue stringEncodedValue) {
        return new BuilderEncodedValues.BuilderStringEncodedValue(((BuilderStringPool) this.stringSection).internString(stringEncodedValue.getValue()));
    }

    @Nonnull
    private BuilderEncodedValues.BuilderTypeEncodedValue internTypeEncodedValue(@Nonnull TypeEncodedValue typeEncodedValue) {
        return new BuilderEncodedValues.BuilderTypeEncodedValue(((BuilderTypePool) this.typeSection).internType(typeEncodedValue.getValue()));
    }

    @Override // org.jf.dexlib2.writer.DexWriter
    @Nonnull
    protected DexWriter<BuilderStringReference, BuilderStringReference, BuilderTypeReference, BuilderTypeReference, BuilderMethodProtoReference, BuilderFieldReference, BuilderMethodReference, BuilderClassDef, BuilderCallSiteReference, BuilderMethodHandleReference, BuilderAnnotation, BuilderAnnotationSet, BuilderTypeList, BuilderField, BuilderMethod, BuilderEncodedValues.BuilderArrayEncodedValue, BuilderEncodedValues.BuilderEncodedValue, BuilderAnnotationElement, BuilderStringPool, BuilderTypePool, BuilderProtoPool, BuilderFieldPool, BuilderMethodPool, BuilderClassPool, BuilderCallSitePool, BuilderMethodHandlePool, BuilderTypeListPool, BuilderAnnotationPool, BuilderAnnotationSetPool, BuilderEncodedArrayPool>.SectionProvider getSectionProvider() {
        return new DexBuilderSectionProvider();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nonnull
    public Set<? extends BuilderAnnotationElement> internAnnotationElements(@Nonnull Set<? extends AnnotationElement> set) {
        return ImmutableSet.copyOf(r.x(set.iterator(), new d<AnnotationElement, BuilderAnnotationElement>() { // from class: org.jf.dexlib2.writer.builder.DexBuilder.2
            @Override // com.google.common.base.d
            @Nullable
            public BuilderAnnotationElement apply(AnnotationElement annotationElement) {
                return DexBuilder.this.internAnnotationElement(annotationElement);
            }
        }));
    }

    public BuilderCallSiteReference internCallSite(@Nonnull CallSiteReference callSiteReference) {
        return ((BuilderCallSitePool) this.callSiteSection).internCallSite(callSiteReference);
    }

    @Nonnull
    public BuilderClassDef internClassDef(@Nonnull String str, int i3, @Nullable String str2, @Nullable List<String> list, @Nullable String str3, @Nonnull Set<? extends Annotation> set, @Nullable Iterable<? extends BuilderField> iterable, @Nullable Iterable<? extends BuilderMethod> iterable2) {
        List<String> list2;
        ImmutableSortedSet immutableSortedSet;
        ImmutableSortedSet immutableSortedSet2;
        BuilderEncodedValues.BuilderArrayEncodedValue builderArrayEncodedValue;
        if (list == null) {
            list2 = ImmutableList.of();
        } else {
            HashSet e16 = ab.e(list);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!e16.contains(next)) {
                    it.remove();
                } else {
                    e16.remove(next);
                }
            }
            list2 = list;
        }
        BuilderEncodedValues.BuilderArrayEncodedValue builderArrayEncodedValue2 = null;
        if (iterable != null) {
            ImmutableSortedSet copyOf = ImmutableSortedSet.copyOf(q.f(iterable, FieldUtil.FIELD_IS_STATIC));
            ImmutableSortedSet copyOf2 = ImmutableSortedSet.copyOf(q.f(iterable, FieldUtil.FIELD_IS_INSTANCE));
            ArrayEncodedValue staticInitializers = StaticInitializerUtil.getStaticInitializers(copyOf);
            if (staticInitializers != null) {
                builderArrayEncodedValue2 = ((BuilderEncodedArrayPool) this.encodedArraySection).internArrayEncodedValue(staticInitializers);
            }
            immutableSortedSet2 = copyOf2;
            builderArrayEncodedValue = builderArrayEncodedValue2;
            immutableSortedSet = copyOf;
        } else {
            immutableSortedSet = null;
            immutableSortedSet2 = null;
            builderArrayEncodedValue = null;
        }
        return ((BuilderClassPool) this.classSection).internClass(new BuilderClassDef(((BuilderTypePool) this.typeSection).internType(str), i3, ((BuilderTypePool) this.typeSection).internNullableType(str2), ((BuilderTypeListPool) this.typeListSection).internTypeList(list2), ((BuilderStringPool) this.stringSection).internNullableString(str3), ((BuilderAnnotationSetPool) this.annotationSetSection).internAnnotationSet(set), immutableSortedSet, immutableSortedSet2, iterable2, builderArrayEncodedValue));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nonnull
    public BuilderEncodedValues.BuilderEncodedValue internEncodedValue(@Nonnull EncodedValue encodedValue) {
        int valueType = encodedValue.getValueType();
        if (valueType != 0) {
            if (valueType != 6) {
                if (valueType != 2) {
                    if (valueType != 3) {
                        if (valueType != 4) {
                            if (valueType != 16) {
                                if (valueType != 17) {
                                    switch (valueType) {
                                        case 21:
                                            return internMethodTypeEncodedValue((MethodTypeEncodedValue) encodedValue);
                                        case 22:
                                            return internMethodHandleEncodedValue((MethodHandleEncodedValue) encodedValue);
                                        case 23:
                                            return internStringEncodedValue((StringEncodedValue) encodedValue);
                                        case 24:
                                            return internTypeEncodedValue((TypeEncodedValue) encodedValue);
                                        case 25:
                                            return internFieldEncodedValue((FieldEncodedValue) encodedValue);
                                        case 26:
                                            return internMethodEncodedValue((MethodEncodedValue) encodedValue);
                                        case 27:
                                            return internEnumEncodedValue((EnumEncodedValue) encodedValue);
                                        case 28:
                                            return internArrayEncodedValue((ArrayEncodedValue) encodedValue);
                                        case 29:
                                            return internAnnotationEncodedValue((AnnotationEncodedValue) encodedValue);
                                        case 30:
                                            return BuilderEncodedValues.BuilderNullEncodedValue.INSTANCE;
                                        case 31:
                                            if (((BooleanEncodedValue) encodedValue).getValue()) {
                                                return BuilderEncodedValues.BuilderBooleanEncodedValue.TRUE_VALUE;
                                            }
                                            return BuilderEncodedValues.BuilderBooleanEncodedValue.FALSE_VALUE;
                                        default:
                                            throw new ExceptionWithContext("Unexpected encoded value type: %d", Integer.valueOf(encodedValue.getValueType()));
                                    }
                                }
                                return new BuilderEncodedValues.BuilderDoubleEncodedValue(((DoubleEncodedValue) encodedValue).getValue());
                            }
                            return new BuilderEncodedValues.BuilderFloatEncodedValue(((FloatEncodedValue) encodedValue).getValue());
                        }
                        return new BuilderEncodedValues.BuilderIntEncodedValue(((IntEncodedValue) encodedValue).getValue());
                    }
                    return new BuilderEncodedValues.BuilderCharEncodedValue(((CharEncodedValue) encodedValue).getValue());
                }
                return new BuilderEncodedValues.BuilderShortEncodedValue(((ShortEncodedValue) encodedValue).getValue());
            }
            return new BuilderEncodedValues.BuilderLongEncodedValue(((LongEncodedValue) encodedValue).getValue());
        }
        return new BuilderEncodedValues.BuilderByteEncodedValue(((ByteEncodedValue) encodedValue).getValue());
    }

    @Nonnull
    public BuilderField internField(@Nonnull String str, @Nonnull String str2, @Nonnull String str3, int i3, @Nullable EncodedValue encodedValue, @Nonnull Set<? extends Annotation> set, @Nonnull Set<HiddenApiRestriction> set2) {
        return new BuilderField(((BuilderFieldPool) this.fieldSection).internField(str, str2, str3), i3, internNullableEncodedValue(encodedValue), ((BuilderAnnotationSetPool) this.annotationSetSection).internAnnotationSet(set), set2);
    }

    @Nonnull
    public BuilderFieldReference internFieldReference(@Nonnull FieldReference fieldReference) {
        return ((BuilderFieldPool) this.fieldSection).internField(fieldReference);
    }

    @Nonnull
    public BuilderMethod internMethod(@Nonnull String str, @Nonnull String str2, @Nullable List<? extends MethodParameter> list, @Nonnull String str3, int i3, @Nonnull Set<? extends Annotation> set, @Nonnull Set<HiddenApiRestriction> set2, @Nullable MethodImplementation methodImplementation) {
        List<? extends MethodParameter> list2;
        if (list == null) {
            list2 = ImmutableList.of();
        } else {
            list2 = list;
        }
        return new BuilderMethod(((BuilderMethodPool) this.methodSection).internMethod(str, str2, list2, str3), internMethodParameters(list2), i3, ((BuilderAnnotationSetPool) this.annotationSetSection).internAnnotationSet(set), set2, methodImplementation);
    }

    public BuilderMethodHandleReference internMethodHandle(@Nonnull MethodHandleReference methodHandleReference) {
        return ((BuilderMethodHandlePool) this.methodHandleSection).internMethodHandle(methodHandleReference);
    }

    @Nonnull
    public BuilderMethodProtoReference internMethodProtoReference(@Nonnull MethodProtoReference methodProtoReference) {
        return ((BuilderProtoPool) this.protoSection).internMethodProto(methodProtoReference);
    }

    @Nonnull
    public BuilderMethodReference internMethodReference(@Nonnull MethodReference methodReference) {
        return ((BuilderMethodPool) this.methodSection).internMethod(methodReference);
    }

    @Nullable
    BuilderEncodedValues.BuilderEncodedValue internNullableEncodedValue(@Nullable EncodedValue encodedValue) {
        if (encodedValue == null) {
            return null;
        }
        return internEncodedValue(encodedValue);
    }

    @Nullable
    public BuilderStringReference internNullableStringReference(@Nullable String str) {
        if (str != null) {
            return internStringReference(str);
        }
        return null;
    }

    @Nullable
    public BuilderTypeReference internNullableTypeReference(@Nullable String str) {
        if (str != null) {
            return internTypeReference(str);
        }
        return null;
    }

    @Nonnull
    public BuilderReference internReference(@Nonnull Reference reference) {
        if (reference instanceof StringReference) {
            return internStringReference(((StringReference) reference).getString());
        }
        if (reference instanceof TypeReference) {
            return internTypeReference(((TypeReference) reference).getType());
        }
        if (reference instanceof MethodReference) {
            return internMethodReference((MethodReference) reference);
        }
        if (reference instanceof FieldReference) {
            return internFieldReference((FieldReference) reference);
        }
        if (reference instanceof MethodProtoReference) {
            return internMethodProtoReference((MethodProtoReference) reference);
        }
        if (reference instanceof CallSiteReference) {
            return internCallSite((CallSiteReference) reference);
        }
        if (reference instanceof MethodHandleReference) {
            return internMethodHandle((MethodHandleReference) reference);
        }
        throw new IllegalArgumentException("Could not determine type of reference");
    }

    @Nonnull
    public BuilderStringReference internStringReference(@Nonnull String str) {
        return ((BuilderStringPool) this.stringSection).internString(str);
    }

    @Nonnull
    public BuilderTypeReference internTypeReference(@Nonnull String str) {
        return ((BuilderTypePool) this.typeSection).internType(str);
    }

    @Override // org.jf.dexlib2.writer.DexWriter
    protected /* bridge */ /* synthetic */ void writeEncodedValue(@Nonnull DexWriter.InternalEncodedValueWriter internalEncodedValueWriter, @Nonnull BuilderEncodedValues.BuilderEncodedValue builderEncodedValue) throws IOException {
        writeEncodedValue2((DexWriter<BuilderStringReference, BuilderStringReference, BuilderTypeReference, BuilderTypeReference, BuilderMethodProtoReference, BuilderFieldReference, BuilderMethodReference, BuilderClassDef, BuilderCallSiteReference, BuilderMethodHandleReference, BuilderAnnotation, BuilderAnnotationSet, BuilderTypeList, BuilderField, BuilderMethod, BuilderEncodedValues.BuilderArrayEncodedValue, BuilderEncodedValues.BuilderEncodedValue, BuilderAnnotationElement, BuilderStringPool, BuilderTypePool, BuilderProtoPool, BuilderFieldPool, BuilderMethodPool, BuilderClassPool, BuilderCallSitePool, BuilderMethodHandlePool, BuilderTypeListPool, BuilderAnnotationPool, BuilderAnnotationSetPool, BuilderEncodedArrayPool>.InternalEncodedValueWriter) internalEncodedValueWriter, builderEncodedValue);
    }

    /* renamed from: writeEncodedValue, reason: avoid collision after fix types in other method */
    protected void writeEncodedValue2(@Nonnull DexWriter<BuilderStringReference, BuilderStringReference, BuilderTypeReference, BuilderTypeReference, BuilderMethodProtoReference, BuilderFieldReference, BuilderMethodReference, BuilderClassDef, BuilderCallSiteReference, BuilderMethodHandleReference, BuilderAnnotation, BuilderAnnotationSet, BuilderTypeList, BuilderField, BuilderMethod, BuilderEncodedValues.BuilderArrayEncodedValue, BuilderEncodedValues.BuilderEncodedValue, BuilderAnnotationElement, BuilderStringPool, BuilderTypePool, BuilderProtoPool, BuilderFieldPool, BuilderMethodPool, BuilderClassPool, BuilderCallSitePool, BuilderMethodHandlePool, BuilderTypeListPool, BuilderAnnotationPool, BuilderAnnotationSetPool, BuilderEncodedArrayPool>.InternalEncodedValueWriter internalEncodedValueWriter, @Nonnull BuilderEncodedValues.BuilderEncodedValue builderEncodedValue) throws IOException {
        int valueType = builderEncodedValue.getValueType();
        if (valueType == 0) {
            internalEncodedValueWriter.writeByte(((ByteEncodedValue) builderEncodedValue).getValue());
            return;
        }
        if (valueType == 6) {
            internalEncodedValueWriter.writeLong(((LongEncodedValue) builderEncodedValue).getValue());
            return;
        }
        if (valueType == 2) {
            internalEncodedValueWriter.writeShort(((ShortEncodedValue) builderEncodedValue).getValue());
            return;
        }
        if (valueType == 3) {
            internalEncodedValueWriter.writeChar(((CharEncodedValue) builderEncodedValue).getValue());
            return;
        }
        if (valueType == 4) {
            internalEncodedValueWriter.writeInt(((IntEncodedValue) builderEncodedValue).getValue());
            return;
        }
        if (valueType == 16) {
            internalEncodedValueWriter.writeFloat(((FloatEncodedValue) builderEncodedValue).getValue());
            return;
        }
        if (valueType != 17) {
            switch (valueType) {
                case 21:
                    internalEncodedValueWriter.writeMethodType(((BuilderEncodedValues.BuilderMethodTypeEncodedValue) builderEncodedValue).methodProtoReference);
                    return;
                case 22:
                    internalEncodedValueWriter.writeMethodHandle(((BuilderEncodedValues.BuilderMethodHandleEncodedValue) builderEncodedValue).methodHandleReference);
                    return;
                case 23:
                    internalEncodedValueWriter.writeString(((BuilderEncodedValues.BuilderStringEncodedValue) builderEncodedValue).stringReference);
                    return;
                case 24:
                    internalEncodedValueWriter.writeType(((BuilderEncodedValues.BuilderTypeEncodedValue) builderEncodedValue).typeReference);
                    return;
                case 25:
                    internalEncodedValueWriter.writeField(((BuilderEncodedValues.BuilderFieldEncodedValue) builderEncodedValue).fieldReference);
                    return;
                case 26:
                    internalEncodedValueWriter.writeMethod(((BuilderEncodedValues.BuilderMethodEncodedValue) builderEncodedValue).methodReference);
                    return;
                case 27:
                    internalEncodedValueWriter.writeEnum(((BuilderEncodedValues.BuilderEnumEncodedValue) builderEncodedValue).getValue());
                    return;
                case 28:
                    internalEncodedValueWriter.writeArray(((BuilderEncodedValues.BuilderArrayEncodedValue) builderEncodedValue).elements);
                    return;
                case 29:
                    BuilderEncodedValues.BuilderAnnotationEncodedValue builderAnnotationEncodedValue = (BuilderEncodedValues.BuilderAnnotationEncodedValue) builderEncodedValue;
                    internalEncodedValueWriter.writeAnnotation(builderAnnotationEncodedValue.typeReference, builderAnnotationEncodedValue.elements);
                    return;
                case 30:
                    internalEncodedValueWriter.writeNull();
                    return;
                case 31:
                    internalEncodedValueWriter.writeBoolean(((BooleanEncodedValue) builderEncodedValue).getValue());
                    return;
                default:
                    throw new ExceptionWithContext("Unrecognized value type: %d", Integer.valueOf(builderEncodedValue.getValueType()));
            }
        }
        internalEncodedValueWriter.writeDouble(((DoubleEncodedValue) builderEncodedValue).getValue());
    }
}
