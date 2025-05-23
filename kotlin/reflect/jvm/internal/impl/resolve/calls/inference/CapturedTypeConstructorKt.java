package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.DelegatedTypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.IndexedParametersSubstitution;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class CapturedTypeConstructorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final TypeProjection createCapturedIfNeeded(final TypeProjection typeProjection, TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor != null && typeProjection.getProjectionKind() != Variance.INVARIANT) {
            if (typeParameterDescriptor.getVariance() == typeProjection.getProjectionKind()) {
                if (typeProjection.isStarProjection()) {
                    StorageManager NO_LOCKS = LockBasedStorageManager.NO_LOCKS;
                    Intrinsics.checkNotNullExpressionValue(NO_LOCKS, "NO_LOCKS");
                    return new TypeProjectionImpl(new LazyWrappedType(NO_LOCKS, new Function0<KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt$createCapturedIfNeeded$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final KotlinType invoke() {
                            KotlinType type = TypeProjection.this.getType();
                            Intrinsics.checkNotNullExpressionValue(type, "this@createCapturedIfNeeded.type");
                            return type;
                        }
                    }));
                }
                return new TypeProjectionImpl(typeProjection.getType());
            }
            return new TypeProjectionImpl(createCapturedType(typeProjection));
        }
        return typeProjection;
    }

    @NotNull
    public static final KotlinType createCapturedType(@NotNull TypeProjection typeProjection) {
        Intrinsics.checkNotNullParameter(typeProjection, "typeProjection");
        return new CapturedType(typeProjection, null, false, null, 14, null);
    }

    public static final boolean isCaptured(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return kotlinType.getConstructor() instanceof CapturedTypeConstructor;
    }

    @NotNull
    public static final TypeSubstitution wrapWithCapturingSubstitution(@NotNull final TypeSubstitution typeSubstitution, final boolean z16) {
        List zip;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(typeSubstitution, "<this>");
        if (typeSubstitution instanceof IndexedParametersSubstitution) {
            IndexedParametersSubstitution indexedParametersSubstitution = (IndexedParametersSubstitution) typeSubstitution;
            TypeParameterDescriptor[] parameters = indexedParametersSubstitution.getParameters();
            zip = ArraysKt___ArraysKt.zip(indexedParametersSubstitution.getArguments(), indexedParametersSubstitution.getParameters());
            List<Pair> list = zip;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (Pair pair : list) {
                arrayList.add(createCapturedIfNeeded((TypeProjection) pair.getFirst(), (TypeParameterDescriptor) pair.getSecond()));
            }
            Object[] array = arrayList.toArray(new TypeProjection[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return new IndexedParametersSubstitution(parameters, (TypeProjection[]) array, z16);
        }
        return new DelegatedTypeSubstitution(typeSubstitution) { // from class: kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt$wrapWithCapturingSubstitution$2
            @Override // kotlin.reflect.jvm.internal.impl.types.DelegatedTypeSubstitution, kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
            public boolean approximateContravariantCapturedTypes() {
                return z16;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.DelegatedTypeSubstitution, kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
            @Nullable
            /* renamed from: get */
            public TypeProjection mo1784get(@NotNull KotlinType key) {
                TypeProjection createCapturedIfNeeded;
                Intrinsics.checkNotNullParameter(key, "key");
                TypeProjection mo1784get = super.mo1784get(key);
                TypeParameterDescriptor typeParameterDescriptor = null;
                if (mo1784get == null) {
                    return null;
                }
                ClassifierDescriptor mo1779getDeclarationDescriptor = key.getConstructor().mo1779getDeclarationDescriptor();
                if (mo1779getDeclarationDescriptor instanceof TypeParameterDescriptor) {
                    typeParameterDescriptor = (TypeParameterDescriptor) mo1779getDeclarationDescriptor;
                }
                createCapturedIfNeeded = CapturedTypeConstructorKt.createCapturedIfNeeded(mo1784get, typeParameterDescriptor);
                return createCapturedIfNeeded;
            }
        };
    }

    public static /* synthetic */ TypeSubstitution wrapWithCapturingSubstitution$default(TypeSubstitution typeSubstitution, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        return wrapWithCapturingSubstitution(typeSubstitution, z16);
    }
}
