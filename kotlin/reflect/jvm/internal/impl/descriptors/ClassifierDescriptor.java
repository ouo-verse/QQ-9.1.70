package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface ClassifierDescriptor extends DeclarationDescriptorNonRoot {
    @NotNull
    SimpleType getDefaultType();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    ClassifierDescriptor getOriginal();

    @NotNull
    TypeConstructor getTypeConstructor();
}
