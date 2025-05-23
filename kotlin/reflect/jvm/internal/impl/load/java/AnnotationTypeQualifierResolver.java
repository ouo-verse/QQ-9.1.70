package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class AnnotationTypeQualifierResolver extends AbstractAnnotationTypeQualifierResolver<AnnotationDescriptor> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnotationTypeQualifierResolver(@NotNull JavaTypeEnhancementState javaTypeEnhancementState) {
        super(javaTypeEnhancementState);
        Intrinsics.checkNotNullParameter(javaTypeEnhancementState, "javaTypeEnhancementState");
    }

    private final List<String> toEnumNames(ConstantValue<?> constantValue) {
        List<String> emptyList;
        List<String> listOf;
        if (constantValue instanceof ArrayValue) {
            List<? extends ConstantValue<?>> value = ((ArrayValue) constantValue).getValue();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, toEnumNames((ConstantValue) it.next()));
            }
            return arrayList;
        }
        if (constantValue instanceof EnumValue) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(((EnumValue) constantValue).getEnumEntryName().getIdentifier());
            return listOf;
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver
    @NotNull
    public Iterable<String> enumArguments(@NotNull AnnotationDescriptor annotationDescriptor, boolean z16) {
        List<String> enumNames;
        Intrinsics.checkNotNullParameter(annotationDescriptor, "<this>");
        Map<Name, ConstantValue<?>> allValueArguments = annotationDescriptor.getAllValueArguments();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Name, ConstantValue<?>> entry : allValueArguments.entrySet()) {
            Name key = entry.getKey();
            ConstantValue<?> value = entry.getValue();
            if (z16 && !Intrinsics.areEqual(key, JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME)) {
                enumNames = CollectionsKt__CollectionsKt.emptyList();
            } else {
                enumNames = toEnumNames(value);
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, enumNames);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver
    @Nullable
    public FqName getFqName(@NotNull AnnotationDescriptor annotationDescriptor) {
        Intrinsics.checkNotNullParameter(annotationDescriptor, "<this>");
        return annotationDescriptor.getFqName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver
    @NotNull
    public Object getKey(@NotNull AnnotationDescriptor annotationDescriptor) {
        Intrinsics.checkNotNullParameter(annotationDescriptor, "<this>");
        ClassDescriptor annotationClass = DescriptorUtilsKt.getAnnotationClass(annotationDescriptor);
        Intrinsics.checkNotNull(annotationClass);
        return annotationClass;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver
    @NotNull
    public Iterable<AnnotationDescriptor> getMetaAnnotations(@NotNull AnnotationDescriptor annotationDescriptor) {
        List emptyList;
        Annotations annotations;
        Intrinsics.checkNotNullParameter(annotationDescriptor, "<this>");
        ClassDescriptor annotationClass = DescriptorUtilsKt.getAnnotationClass(annotationDescriptor);
        if (annotationClass != null && (annotations = annotationClass.getAnnotations()) != null) {
            return annotations;
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }
}
