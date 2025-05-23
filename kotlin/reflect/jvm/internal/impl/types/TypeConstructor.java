package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface TypeConstructor extends TypeConstructorMarker {
    @NotNull
    KotlinBuiltIns getBuiltIns();

    @Nullable
    /* renamed from: getDeclarationDescriptor */
    ClassifierDescriptor mo1779getDeclarationDescriptor();

    @NotNull
    List<TypeParameterDescriptor> getParameters();

    @NotNull
    /* renamed from: getSupertypes */
    Collection<KotlinType> mo1780getSupertypes();

    boolean isDenotable();

    @NotNull
    TypeConstructor refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner);
}
