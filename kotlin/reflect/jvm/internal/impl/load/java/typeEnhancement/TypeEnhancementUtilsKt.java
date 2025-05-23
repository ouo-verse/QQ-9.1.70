package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class TypeEnhancementUtilsKt {
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d9, code lost:
    
        if (r6 != false) goto L49;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final JavaTypeQualifiers computeQualifiersForOverride(@NotNull JavaTypeQualifiers javaTypeQualifiers, @NotNull Collection<JavaTypeQualifiers> superQualifiers, boolean z16, boolean z17, boolean z18) {
        Set set;
        NullabilityQualifier nullabilityQualifier;
        Set set2;
        boolean z19;
        boolean z26;
        boolean z27;
        Set set3;
        Intrinsics.checkNotNullParameter(javaTypeQualifiers, "<this>");
        Intrinsics.checkNotNullParameter(superQualifiers, "superQualifiers");
        Collection<JavaTypeQualifiers> collection = superQualifiers;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            NullabilityQualifier nullabilityForErrors = getNullabilityForErrors((JavaTypeQualifiers) it.next());
            if (nullabilityForErrors != null) {
                arrayList.add(nullabilityForErrors);
            }
        }
        set = CollectionsKt___CollectionsKt.toSet(arrayList);
        NullabilityQualifier select = select(set, getNullabilityForErrors(javaTypeQualifiers), z16);
        if (select == null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it5 = collection.iterator();
            while (it5.hasNext()) {
                NullabilityQualifier nullability = ((JavaTypeQualifiers) it5.next()).getNullability();
                if (nullability != null) {
                    arrayList2.add(nullability);
                }
            }
            set3 = CollectionsKt___CollectionsKt.toSet(arrayList2);
            nullabilityQualifier = select(set3, javaTypeQualifiers.getNullability(), z16);
        } else {
            nullabilityQualifier = select;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it6 = collection.iterator();
        while (it6.hasNext()) {
            MutabilityQualifier mutability = ((JavaTypeQualifiers) it6.next()).getMutability();
            if (mutability != null) {
                arrayList3.add(mutability);
            }
        }
        set2 = CollectionsKt___CollectionsKt.toSet(arrayList3);
        MutabilityQualifier mutabilityQualifier = (MutabilityQualifier) select(set2, MutabilityQualifier.MUTABLE, MutabilityQualifier.READ_ONLY, javaTypeQualifiers.getMutability(), z16);
        NullabilityQualifier nullabilityQualifier2 = null;
        boolean z28 = true;
        if (nullabilityQualifier != null) {
            if (!z18 && (!z17 || nullabilityQualifier != NullabilityQualifier.NULLABLE)) {
                z27 = false;
            } else {
                z27 = true;
            }
            if (!z27) {
                nullabilityQualifier2 = nullabilityQualifier;
            }
        }
        if (nullabilityQualifier2 == NullabilityQualifier.NOT_NULL) {
            if (!javaTypeQualifiers.getDefinitelyNotNull()) {
                if (!collection.isEmpty()) {
                    Iterator<T> it7 = collection.iterator();
                    while (it7.hasNext()) {
                        if (((JavaTypeQualifiers) it7.next()).getDefinitelyNotNull()) {
                            z26 = true;
                            break;
                        }
                    }
                }
                z26 = false;
            }
            z19 = true;
            if (nullabilityQualifier2 != null || select == nullabilityQualifier) {
                z28 = false;
            }
            return new JavaTypeQualifiers(nullabilityQualifier2, mutabilityQualifier, z19, z28);
        }
        z19 = false;
        if (nullabilityQualifier2 != null) {
        }
        z28 = false;
        return new JavaTypeQualifiers(nullabilityQualifier2, mutabilityQualifier, z19, z28);
    }

    private static final NullabilityQualifier getNullabilityForErrors(JavaTypeQualifiers javaTypeQualifiers) {
        if (javaTypeQualifiers.isNullabilityQualifierForWarning()) {
            return null;
        }
        return javaTypeQualifiers.getNullability();
    }

    public static final boolean hasEnhancedNullability(@NotNull TypeSystemCommonBackendContext typeSystemCommonBackendContext, @NotNull KotlinTypeMarker type) {
        Intrinsics.checkNotNullParameter(typeSystemCommonBackendContext, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        FqName ENHANCED_NULLABILITY_ANNOTATION = JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(ENHANCED_NULLABILITY_ANNOTATION, "ENHANCED_NULLABILITY_ANNOTATION");
        return typeSystemCommonBackendContext.hasAnnotation(type, ENHANCED_NULLABILITY_ANNOTATION);
    }

    private static final <T> T select(Set<? extends T> set, T t16, T t17, T t18, boolean z16) {
        Set plus;
        Set<? extends T> set2;
        Object singleOrNull;
        if (z16) {
            T t19 = set.contains(t16) ? t16 : set.contains(t17) ? t17 : null;
            if (Intrinsics.areEqual(t19, t16) && Intrinsics.areEqual(t18, t17)) {
                return null;
            }
            return t18 == null ? t19 : t18;
        }
        if (t18 != null) {
            plus = SetsKt___SetsKt.plus((Set<? extends Object>) set, t18);
            set2 = CollectionsKt___CollectionsKt.toSet(plus);
            if (set2 != null) {
                set = set2;
            }
        }
        singleOrNull = CollectionsKt___CollectionsKt.singleOrNull(set);
        return (T) singleOrNull;
    }

    private static final NullabilityQualifier select(Set<? extends NullabilityQualifier> set, NullabilityQualifier nullabilityQualifier, boolean z16) {
        NullabilityQualifier nullabilityQualifier2 = NullabilityQualifier.FORCE_FLEXIBILITY;
        return nullabilityQualifier == nullabilityQualifier2 ? nullabilityQualifier2 : (NullabilityQualifier) select(set, NullabilityQualifier.NOT_NULL, NullabilityQualifier.NULLABLE, nullabilityQualifier, z16);
    }
}
