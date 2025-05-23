package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class CompanionObjectMapping {

    @NotNull
    public static final CompanionObjectMapping INSTANCE = new CompanionObjectMapping();

    @NotNull
    private static final Set<ClassId> classIds;

    static {
        int collectionSizeOrDefault;
        List plus;
        List plus2;
        List plus3;
        Set<PrimitiveType> set = PrimitiveType.NUMBER_TYPES;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(set, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(StandardNames.getPrimitiveFqName((PrimitiveType) it.next()));
        }
        FqName safe = StandardNames.FqNames.string.toSafe();
        Intrinsics.checkNotNullExpressionValue(safe, "string.toSafe()");
        plus = CollectionsKt___CollectionsKt.plus((Collection<? extends FqName>) ((Collection<? extends Object>) arrayList), safe);
        FqName safe2 = StandardNames.FqNames._boolean.toSafe();
        Intrinsics.checkNotNullExpressionValue(safe2, "_boolean.toSafe()");
        plus2 = CollectionsKt___CollectionsKt.plus((Collection<? extends FqName>) ((Collection<? extends Object>) plus), safe2);
        FqName safe3 = StandardNames.FqNames._enum.toSafe();
        Intrinsics.checkNotNullExpressionValue(safe3, "_enum.toSafe()");
        plus3 = CollectionsKt___CollectionsKt.plus((Collection<? extends FqName>) ((Collection<? extends Object>) plus2), safe3);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it5 = plus3.iterator();
        while (it5.hasNext()) {
            linkedHashSet.add(ClassId.topLevel((FqName) it5.next()));
        }
        classIds = linkedHashSet;
    }

    CompanionObjectMapping() {
    }

    @NotNull
    public final Set<ClassId> allClassesWithIntrinsicCompanions() {
        return classIds;
    }

    @NotNull
    public final Set<ClassId> getClassIds() {
        return classIds;
    }
}
