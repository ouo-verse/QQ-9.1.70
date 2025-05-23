package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class DefaultTypeAttributeTranslator implements TypeAttributeTranslator {

    @NotNull
    public static final DefaultTypeAttributeTranslator INSTANCE = new DefaultTypeAttributeTranslator();

    DefaultTypeAttributeTranslator() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator
    @NotNull
    public TypeAttributes toAttributes(@NotNull Annotations annotations, @Nullable TypeConstructor typeConstructor, @Nullable DeclarationDescriptor declarationDescriptor) {
        List<? extends TypeAttribute<?>> listOf;
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        if (annotations.isEmpty()) {
            return TypeAttributes.Companion.getEmpty();
        }
        TypeAttributes.Companion companion = TypeAttributes.Companion;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new AnnotationsTypeAttribute(annotations));
        return companion.create(listOf);
    }
}
