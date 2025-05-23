package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.DynamicTypesKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class IntersectionTypeKt {
    @NotNull
    public static final UnwrappedType intersectTypes(@NotNull List<? extends UnwrappedType> types) {
        Object single;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        SimpleType lowerBound;
        Intrinsics.checkNotNullParameter(types, "types");
        int size = types.size();
        if (size != 0) {
            if (size == 1) {
                single = CollectionsKt___CollectionsKt.single((List<? extends Object>) types);
                return (UnwrappedType) single;
            }
            List<? extends UnwrappedType> list = types;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            boolean z16 = false;
            boolean z17 = false;
            for (UnwrappedType unwrappedType : list) {
                if (!z16 && !KotlinTypeKt.isError(unwrappedType)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (unwrappedType instanceof SimpleType) {
                    lowerBound = (SimpleType) unwrappedType;
                } else if (unwrappedType instanceof FlexibleType) {
                    if (DynamicTypesKt.isDynamic(unwrappedType)) {
                        return unwrappedType;
                    }
                    lowerBound = ((FlexibleType) unwrappedType).getLowerBound();
                    z17 = true;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                arrayList.add(lowerBound);
            }
            if (z16) {
                return ErrorUtils.createErrorType(ErrorTypeKind.INTERSECTION_OF_ERROR_TYPES, types.toString());
            }
            if (z17) {
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(FlexibleTypesKt.upperIfFlexible((UnwrappedType) it.next()));
                }
                TypeIntersector typeIntersector = TypeIntersector.INSTANCE;
                return KotlinTypeFactory.flexibleType(typeIntersector.intersectTypes$descriptors(arrayList), typeIntersector.intersectTypes$descriptors(arrayList2));
            }
            return TypeIntersector.INSTANCE.intersectTypes$descriptors(arrayList);
        }
        throw new IllegalStateException("Expected some types".toString());
    }
}
