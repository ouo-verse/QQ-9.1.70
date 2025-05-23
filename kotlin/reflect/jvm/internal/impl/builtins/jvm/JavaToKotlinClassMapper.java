package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class JavaToKotlinClassMapper {

    @NotNull
    public static final JavaToKotlinClassMapper INSTANCE = new JavaToKotlinClassMapper();

    JavaToKotlinClassMapper() {
    }

    public static /* synthetic */ ClassDescriptor mapJavaToKotlin$default(JavaToKotlinClassMapper javaToKotlinClassMapper, FqName fqName, KotlinBuiltIns kotlinBuiltIns, Integer num, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        return javaToKotlinClassMapper.mapJavaToKotlin(fqName, kotlinBuiltIns, num);
    }

    @NotNull
    public final ClassDescriptor convertMutableToReadOnly(@NotNull ClassDescriptor mutable) {
        Intrinsics.checkNotNullParameter(mutable, "mutable");
        FqName mutableToReadOnly = JavaToKotlinClassMap.INSTANCE.mutableToReadOnly(DescriptorUtils.getFqName(mutable));
        if (mutableToReadOnly != null) {
            ClassDescriptor builtInClassByFqName = DescriptorUtilsKt.getBuiltIns(mutable).getBuiltInClassByFqName(mutableToReadOnly);
            Intrinsics.checkNotNullExpressionValue(builtInClassByFqName, "descriptor.builtIns.getB\u2026Name(oppositeClassFqName)");
            return builtInClassByFqName;
        }
        throw new IllegalArgumentException("Given class " + mutable + " is not a mutable collection");
    }

    @NotNull
    public final ClassDescriptor convertReadOnlyToMutable(@NotNull ClassDescriptor readOnly) {
        Intrinsics.checkNotNullParameter(readOnly, "readOnly");
        FqName readOnlyToMutable = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(DescriptorUtils.getFqName(readOnly));
        if (readOnlyToMutable != null) {
            ClassDescriptor builtInClassByFqName = DescriptorUtilsKt.getBuiltIns(readOnly).getBuiltInClassByFqName(readOnlyToMutable);
            Intrinsics.checkNotNullExpressionValue(builtInClassByFqName, "descriptor.builtIns.getB\u2026Name(oppositeClassFqName)");
            return builtInClassByFqName;
        }
        throw new IllegalArgumentException("Given class " + readOnly + " is not a read-only collection");
    }

    public final boolean isMutable(@NotNull ClassDescriptor mutable) {
        Intrinsics.checkNotNullParameter(mutable, "mutable");
        return JavaToKotlinClassMap.INSTANCE.isMutable(DescriptorUtils.getFqName(mutable));
    }

    public final boolean isReadOnly(@NotNull ClassDescriptor readOnly) {
        Intrinsics.checkNotNullParameter(readOnly, "readOnly");
        return JavaToKotlinClassMap.INSTANCE.isReadOnly(DescriptorUtils.getFqName(readOnly));
    }

    @Nullable
    public final ClassDescriptor mapJavaToKotlin(@NotNull FqName fqName, @NotNull KotlinBuiltIns builtIns, @Nullable Integer num) {
        ClassId mapJavaToKotlin;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        if (num != null && Intrinsics.areEqual(fqName, JavaToKotlinClassMap.INSTANCE.getFUNCTION_N_FQ_NAME())) {
            mapJavaToKotlin = StandardNames.getFunctionClassId(num.intValue());
        } else {
            mapJavaToKotlin = JavaToKotlinClassMap.INSTANCE.mapJavaToKotlin(fqName);
        }
        if (mapJavaToKotlin != null) {
            return builtIns.getBuiltInClassByFqName(mapJavaToKotlin.asSingleFqName());
        }
        return null;
    }

    @NotNull
    public final Collection<ClassDescriptor> mapPlatformClass(@NotNull FqName fqName, @NotNull KotlinBuiltIns builtIns) {
        List listOf;
        Set of5;
        Set emptySet;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        ClassDescriptor mapJavaToKotlin$default = mapJavaToKotlin$default(this, fqName, builtIns, null, 4, null);
        if (mapJavaToKotlin$default == null) {
            emptySet = SetsKt__SetsKt.emptySet();
            return emptySet;
        }
        FqName readOnlyToMutable = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(DescriptorUtilsKt.getFqNameUnsafe(mapJavaToKotlin$default));
        if (readOnlyToMutable == null) {
            of5 = SetsKt__SetsJVMKt.setOf(mapJavaToKotlin$default);
            return of5;
        }
        ClassDescriptor builtInClassByFqName = builtIns.getBuiltInClassByFqName(readOnlyToMutable);
        Intrinsics.checkNotNullExpressionValue(builtInClassByFqName, "builtIns.getBuiltInClass\u2026otlinMutableAnalogFqName)");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ClassDescriptor[]{mapJavaToKotlin$default, builtInClassByFqName});
        return listOf;
    }
}
