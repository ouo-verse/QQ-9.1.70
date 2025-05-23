package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class CapturedTypeConstructorImpl implements CapturedTypeConstructor {

    @Nullable
    private NewCapturedTypeConstructor newTypeConstructor;

    @NotNull
    private final TypeProjection projection;

    public CapturedTypeConstructorImpl(@NotNull TypeProjection projection) {
        Intrinsics.checkNotNullParameter(projection, "projection");
        this.projection = projection;
        getProjection().getProjectionKind();
        Variance variance = Variance.INVARIANT;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns builtIns = getProjection().getType().getConstructor().getBuiltIns();
        Intrinsics.checkNotNullExpressionValue(builtIns, "projection.type.constructor.builtIns");
        return builtIns;
    }

    @Nullable
    public Void getDeclarationDescriptor() {
        return null;
    }

    @Nullable
    public final NewCapturedTypeConstructor getNewTypeConstructor() {
        return this.newTypeConstructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public List<TypeParameterDescriptor> getParameters() {
        List<TypeParameterDescriptor> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor
    @NotNull
    public TypeProjection getProjection() {
        return this.projection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    /* renamed from: getSupertypes */
    public Collection<KotlinType> mo1780getSupertypes() {
        KotlinType nullableAnyType;
        List listOf;
        if (getProjection().getProjectionKind() == Variance.OUT_VARIANCE) {
            nullableAnyType = getProjection().getType();
        } else {
            nullableAnyType = getBuiltIns().getNullableAnyType();
        }
        Intrinsics.checkNotNullExpressionValue(nullableAnyType, "if (projection.projectio\u2026 builtIns.nullableAnyType");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(nullableAnyType);
        return listOf;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    public final void setNewTypeConstructor(@Nullable NewCapturedTypeConstructor newCapturedTypeConstructor) {
        this.newTypeConstructor = newCapturedTypeConstructor;
    }

    @NotNull
    public String toString() {
        return "CapturedTypeConstructor(" + getProjection() + ')';
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* renamed from: getDeclarationDescriptor, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ ClassifierDescriptor mo1779getDeclarationDescriptor() {
        return (ClassifierDescriptor) getDeclarationDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public CapturedTypeConstructorImpl refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        TypeProjection refine = getProjection().refine(kotlinTypeRefiner);
        Intrinsics.checkNotNullExpressionValue(refine, "projection.refine(kotlinTypeRefiner)");
        return new CapturedTypeConstructorImpl(refine);
    }
}
