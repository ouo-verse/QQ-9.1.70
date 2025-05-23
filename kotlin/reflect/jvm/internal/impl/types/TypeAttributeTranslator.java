package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface TypeAttributeTranslator {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ TypeAttributes toAttributes$default(TypeAttributeTranslator typeAttributeTranslator, Annotations annotations, TypeConstructor typeConstructor, DeclarationDescriptor declarationDescriptor, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    typeConstructor = null;
                }
                if ((i3 & 4) != 0) {
                    declarationDescriptor = null;
                }
                return typeAttributeTranslator.toAttributes(annotations, typeConstructor, declarationDescriptor);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toAttributes");
        }
    }

    @NotNull
    TypeAttributes toAttributes(@NotNull Annotations annotations, @Nullable TypeConstructor typeConstructor, @Nullable DeclarationDescriptor declarationDescriptor);
}
