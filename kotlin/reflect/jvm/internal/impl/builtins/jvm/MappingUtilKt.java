package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class MappingUtilKt {
    @NotNull
    public static final TypeConstructorSubstitution createMappedTypeParametersSubstitution(@NotNull ClassDescriptor from, @NotNull ClassDescriptor to5) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        List zip;
        Map map;
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to5, "to");
        from.getDeclaredTypeParameters().size();
        to5.getDeclaredTypeParameters().size();
        TypeConstructorSubstitution.Companion companion = TypeConstructorSubstitution.Companion;
        List<TypeParameterDescriptor> declaredTypeParameters = from.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "from.declaredTypeParameters");
        List<TypeParameterDescriptor> list = declaredTypeParameters;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((TypeParameterDescriptor) it.next()).getTypeConstructor());
        }
        List<TypeParameterDescriptor> declaredTypeParameters2 = to5.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters2, "to.declaredTypeParameters");
        List<TypeParameterDescriptor> list2 = declaredTypeParameters2;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = list2.iterator();
        while (it5.hasNext()) {
            SimpleType defaultType = ((TypeParameterDescriptor) it5.next()).getDefaultType();
            Intrinsics.checkNotNullExpressionValue(defaultType, "it.defaultType");
            arrayList2.add(TypeUtilsKt.asTypeProjection(defaultType));
        }
        zip = CollectionsKt___CollectionsKt.zip(arrayList, arrayList2);
        map = MapsKt__MapsKt.toMap(zip);
        return TypeConstructorSubstitution.Companion.createByConstructorsMap$default(companion, map, false, 2, null);
    }
}
