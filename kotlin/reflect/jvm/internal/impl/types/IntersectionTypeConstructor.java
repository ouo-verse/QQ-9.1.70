package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class IntersectionTypeConstructor implements TypeConstructor, IntersectionTypeConstructorMarker {

    @Nullable
    private KotlinType alternative;
    private final int hashCode;

    @NotNull
    private final LinkedHashSet<KotlinType> intersectedTypes;

    public IntersectionTypeConstructor(@NotNull Collection<? extends KotlinType> typesToIntersect) {
        Intrinsics.checkNotNullParameter(typesToIntersect, "typesToIntersect");
        typesToIntersect.isEmpty();
        LinkedHashSet<KotlinType> linkedHashSet = new LinkedHashSet<>(typesToIntersect);
        this.intersectedTypes = linkedHashSet;
        this.hashCode = linkedHashSet.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String makeDebugNameForIntersectionType$default(IntersectionTypeConstructor intersectionTypeConstructor, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function1 = new Function1<KotlinType, String>() { // from class: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor$makeDebugNameForIntersectionType$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final String invoke(@NotNull KotlinType it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.toString();
                }
            };
        }
        return intersectionTypeConstructor.makeDebugNameForIntersectionType(function1);
    }

    @NotNull
    public final MemberScope createScopeForKotlinType() {
        return TypeIntersectionScope.Companion.create("member scope for intersection type", this.intersectedTypes);
    }

    @NotNull
    public final SimpleType createType() {
        List emptyList;
        TypeAttributes empty = TypeAttributes.Companion.getEmpty();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(empty, this, emptyList, false, createScopeForKotlinType(), new Function1<KotlinTypeRefiner, SimpleType>() { // from class: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor$createType$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final SimpleType invoke(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
                Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
                return IntersectionTypeConstructor.this.refine(kotlinTypeRefiner).createType();
            }
        });
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntersectionTypeConstructor)) {
            return false;
        }
        return Intrinsics.areEqual(this.intersectedTypes, ((IntersectionTypeConstructor) obj).intersectedTypes);
    }

    @Nullable
    public final KotlinType getAlternativeType() {
        return this.alternative;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns builtIns = this.intersectedTypes.iterator().next().getConstructor().getBuiltIns();
        Intrinsics.checkNotNullExpressionValue(builtIns, "intersectedTypes.iterato\u2026xt().constructor.builtIns");
        return builtIns;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @Nullable
    /* renamed from: getDeclarationDescriptor */
    public ClassifierDescriptor mo1779getDeclarationDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public List<TypeParameterDescriptor> getParameters() {
        List<TypeParameterDescriptor> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    /* renamed from: getSupertypes */
    public Collection<KotlinType> mo1780getSupertypes() {
        return this.intersectedTypes;
    }

    public int hashCode() {
        return this.hashCode;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    @NotNull
    public final String makeDebugNameForIntersectionType(@NotNull final Function1<? super KotlinType, ? extends Object> getProperTypeRelatedToStringify) {
        List sortedWith;
        String joinToString$default;
        Intrinsics.checkNotNullParameter(getProperTypeRelatedToStringify, "getProperTypeRelatedToStringify");
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(this.intersectedTypes, new Comparator() { // from class: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor$makeDebugNameForIntersectionType$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t16, T t17) {
                int compareValues;
                KotlinType it = (KotlinType) t16;
                Function1 function1 = Function1.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                String obj = function1.invoke(it).toString();
                KotlinType it5 = (KotlinType) t17;
                Function1 function12 = Function1.this;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(obj, function12.invoke(it5).toString());
                return compareValues;
            }
        });
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(sortedWith, " & ", "{", "}", 0, null, new Function1<KotlinType, CharSequence>() { // from class: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor$makeDebugNameForIntersectionType$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(KotlinType it) {
                Function1<KotlinType, Object> function1 = getProperTypeRelatedToStringify;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                return function1.invoke(it).toString();
            }
        }, 24, null);
        return joinToString$default;
    }

    @NotNull
    public final IntersectionTypeConstructor setAlternative(@Nullable KotlinType kotlinType) {
        return new IntersectionTypeConstructor(this.intersectedTypes, kotlinType);
    }

    @NotNull
    public String toString() {
        return makeDebugNameForIntersectionType$default(this, null, 1, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public IntersectionTypeConstructor refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        Collection<KotlinType> mo1780getSupertypes = mo1780getSupertypes();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(mo1780getSupertypes, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = mo1780getSupertypes.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            arrayList.add(((KotlinType) it.next()).refine(kotlinTypeRefiner));
            z16 = true;
        }
        IntersectionTypeConstructor intersectionTypeConstructor = null;
        if (z16) {
            KotlinType alternativeType = getAlternativeType();
            intersectionTypeConstructor = new IntersectionTypeConstructor(arrayList).setAlternative(alternativeType != null ? alternativeType.refine(kotlinTypeRefiner) : null);
        }
        return intersectionTypeConstructor == null ? this : intersectionTypeConstructor;
    }

    IntersectionTypeConstructor(Collection<? extends KotlinType> collection, KotlinType kotlinType) {
        this(collection);
        this.alternative = kotlinType;
    }
}
