package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class AnnotationsTypeAttributeKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinPackage(AnnotationsTypeAttributeKt.class, "descriptors"), "annotationsAttribute", "getAnnotationsAttribute(Lorg/jetbrains/kotlin/types/TypeAttributes;)Lorg/jetbrains/kotlin/types/AnnotationsTypeAttribute;"))};

    @NotNull
    private static final ReadOnlyProperty annotationsAttribute$delegate;

    static {
        ReadOnlyProperty generateNullableAccessor = TypeAttributes.Companion.generateNullableAccessor(Reflection.getOrCreateKotlinClass(AnnotationsTypeAttribute.class));
        Intrinsics.checkNotNull(generateNullableAccessor, "null cannot be cast to non-null type kotlin.properties.ReadOnlyProperty<org.jetbrains.kotlin.types.TypeAttributes, T of org.jetbrains.kotlin.types.TypeAttributes.Companion.attributeAccessor?>");
        annotationsAttribute$delegate = generateNullableAccessor;
    }

    @NotNull
    public static final Annotations getAnnotations(@NotNull TypeAttributes typeAttributes) {
        Annotations annotations;
        Intrinsics.checkNotNullParameter(typeAttributes, "<this>");
        AnnotationsTypeAttribute annotationsAttribute = getAnnotationsAttribute(typeAttributes);
        if (annotationsAttribute == null || (annotations = annotationsAttribute.getAnnotations()) == null) {
            return Annotations.Companion.getEMPTY();
        }
        return annotations;
    }

    @Nullable
    public static final AnnotationsTypeAttribute getAnnotationsAttribute(@NotNull TypeAttributes typeAttributes) {
        Intrinsics.checkNotNullParameter(typeAttributes, "<this>");
        return (AnnotationsTypeAttribute) annotationsAttribute$delegate.getValue(typeAttributes, $$delegatedProperties[0]);
    }
}
