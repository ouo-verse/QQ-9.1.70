package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementUtilsKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class TypeSignatureMappingKt {
    @NotNull
    public static final <T> T boxTypeIfNeeded(@NotNull JvmTypeFactory<T> jvmTypeFactory, @NotNull T possiblyPrimitiveType, boolean z16) {
        Intrinsics.checkNotNullParameter(jvmTypeFactory, "<this>");
        Intrinsics.checkNotNullParameter(possiblyPrimitiveType, "possiblyPrimitiveType");
        if (z16) {
            return jvmTypeFactory.boxType(possiblyPrimitiveType);
        }
        return possiblyPrimitiveType;
    }

    @Nullable
    public static final <T> T mapBuiltInType(@NotNull TypeSystemCommonBackendContext typeSystemCommonBackendContext, @NotNull KotlinTypeMarker type, @NotNull JvmTypeFactory<T> typeFactory, @NotNull TypeMappingMode mode) {
        ClassId classId;
        Intrinsics.checkNotNullParameter(typeSystemCommonBackendContext, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(typeFactory, "typeFactory");
        Intrinsics.checkNotNullParameter(mode, "mode");
        TypeConstructorMarker typeConstructor = typeSystemCommonBackendContext.typeConstructor(type);
        if (!typeSystemCommonBackendContext.isClassTypeConstructor(typeConstructor)) {
            return null;
        }
        PrimitiveType primitiveType = typeSystemCommonBackendContext.getPrimitiveType(typeConstructor);
        boolean z16 = true;
        if (primitiveType != null) {
            T createPrimitiveType = typeFactory.createPrimitiveType(primitiveType);
            if (!typeSystemCommonBackendContext.isNullableType(type) && !TypeEnhancementUtilsKt.hasEnhancedNullability(typeSystemCommonBackendContext, type)) {
                z16 = false;
            }
            return (T) boxTypeIfNeeded(typeFactory, createPrimitiveType, z16);
        }
        PrimitiveType primitiveArrayType = typeSystemCommonBackendContext.getPrimitiveArrayType(typeConstructor);
        if (primitiveArrayType != null) {
            return typeFactory.createFromString('[' + JvmPrimitiveType.get(primitiveArrayType).getDesc());
        }
        if (typeSystemCommonBackendContext.isUnderKotlinPackage(typeConstructor)) {
            FqNameUnsafe classFqNameUnsafe = typeSystemCommonBackendContext.getClassFqNameUnsafe(typeConstructor);
            if (classFqNameUnsafe != null) {
                classId = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(classFqNameUnsafe);
            } else {
                classId = null;
            }
            if (classId != null) {
                if (!mode.getKotlinCollectionsToJavaCollections()) {
                    List<JavaToKotlinClassMap.PlatformMutabilityMapping> mutabilityMappings = JavaToKotlinClassMap.INSTANCE.getMutabilityMappings();
                    if (!(mutabilityMappings instanceof Collection) || !mutabilityMappings.isEmpty()) {
                        Iterator<T> it = mutabilityMappings.iterator();
                        while (it.hasNext()) {
                            if (Intrinsics.areEqual(((JavaToKotlinClassMap.PlatformMutabilityMapping) it.next()).getJavaClass(), classId)) {
                                break;
                            }
                        }
                    }
                    z16 = false;
                    if (z16) {
                        return null;
                    }
                }
                String internalName = JvmClassName.byClassId(classId).getInternalName();
                Intrinsics.checkNotNullExpressionValue(internalName, "byClassId(classId).internalName");
                return typeFactory.createObjectType(internalName);
            }
        }
        return null;
    }
}
