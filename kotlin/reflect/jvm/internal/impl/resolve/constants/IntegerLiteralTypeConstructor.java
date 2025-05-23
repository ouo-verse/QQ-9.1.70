package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class IntegerLiteralTypeConstructor implements TypeConstructor {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final ModuleDescriptor module;

    @NotNull
    private final Set<KotlinType> possibleTypes;

    @NotNull
    private final Lazy supertypes$delegate;

    @NotNull
    private final SimpleType type;
    private final long value;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes28.dex */
        public enum Mode {
            COMMON_SUPER_TYPE,
            INTERSECTION_TYPE
        }

        /* compiled from: P */
        /* loaded from: classes28.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Mode.values().length];
                try {
                    iArr[Mode.COMMON_SUPER_TYPE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Mode.INTERSECTION_TYPE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final SimpleType findCommonSuperTypeOrIntersectionType(Collection<? extends SimpleType> collection, Mode mode) {
            if (collection.isEmpty()) {
                return null;
            }
            Iterator<T> it = collection.iterator();
            if (it.hasNext()) {
                Object next = it.next();
                while (it.hasNext()) {
                    SimpleType simpleType = (SimpleType) it.next();
                    next = IntegerLiteralTypeConstructor.Companion.fold((SimpleType) next, simpleType, mode);
                }
                return (SimpleType) next;
            }
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }

        private final SimpleType fold(SimpleType simpleType, SimpleType simpleType2, Mode mode) {
            if (simpleType == null || simpleType2 == null) {
                return null;
            }
            TypeConstructor constructor = simpleType.getConstructor();
            TypeConstructor constructor2 = simpleType2.getConstructor();
            boolean z16 = constructor instanceof IntegerLiteralTypeConstructor;
            if (z16 && (constructor2 instanceof IntegerLiteralTypeConstructor)) {
                return fold((IntegerLiteralTypeConstructor) constructor, (IntegerLiteralTypeConstructor) constructor2, mode);
            }
            if (z16) {
                return fold((IntegerLiteralTypeConstructor) constructor, simpleType2);
            }
            if (constructor2 instanceof IntegerLiteralTypeConstructor) {
                return fold((IntegerLiteralTypeConstructor) constructor2, simpleType);
            }
            return null;
        }

        @Nullable
        public final SimpleType findIntersectionType(@NotNull Collection<? extends SimpleType> types) {
            Intrinsics.checkNotNullParameter(types, "types");
            return findCommonSuperTypeOrIntersectionType(types, Mode.INTERSECTION_TYPE);
        }

        Companion() {
        }

        private final SimpleType fold(IntegerLiteralTypeConstructor integerLiteralTypeConstructor, IntegerLiteralTypeConstructor integerLiteralTypeConstructor2, Mode mode) {
            Set intersect;
            int i3 = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
            if (i3 == 1) {
                intersect = CollectionsKt___CollectionsKt.intersect(integerLiteralTypeConstructor.getPossibleTypes(), integerLiteralTypeConstructor2.getPossibleTypes());
            } else {
                if (i3 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                intersect = CollectionsKt___CollectionsKt.union(integerLiteralTypeConstructor.getPossibleTypes(), integerLiteralTypeConstructor2.getPossibleTypes());
            }
            return KotlinTypeFactory.integerLiteralType(TypeAttributes.Companion.getEmpty(), new IntegerLiteralTypeConstructor(integerLiteralTypeConstructor.value, integerLiteralTypeConstructor.module, intersect, null), false);
        }

        private final SimpleType fold(IntegerLiteralTypeConstructor integerLiteralTypeConstructor, SimpleType simpleType) {
            if (integerLiteralTypeConstructor.getPossibleTypes().contains(simpleType)) {
                return simpleType;
            }
            return null;
        }
    }

    public /* synthetic */ IntegerLiteralTypeConstructor(long j3, ModuleDescriptor moduleDescriptor, Set set, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, moduleDescriptor, set);
    }

    private final List<KotlinType> getSupertypes() {
        return (List) this.supertypes$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isContainsOnlyUnsignedTypes() {
        Collection<KotlinType> allSignedLiteralTypes = PrimitiveTypeUtilKt.getAllSignedLiteralTypes(this.module);
        if ((allSignedLiteralTypes instanceof Collection) && allSignedLiteralTypes.isEmpty()) {
            return true;
        }
        Iterator<T> it = allSignedLiteralTypes.iterator();
        while (it.hasNext()) {
            if (!(!this.possibleTypes.contains((KotlinType) it.next()))) {
                return false;
            }
        }
        return true;
    }

    private final String valueToString() {
        String joinToString$default;
        StringBuilder sb5 = new StringBuilder();
        sb5.append('[');
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.possibleTypes, ",", null, null, 0, null, new Function1<KotlinType, CharSequence>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor$valueToString$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull KotlinType it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.toString();
            }
        }, 30, null);
        sb5.append(joinToString$default);
        sb5.append(']');
        return sb5.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public KotlinBuiltIns getBuiltIns() {
        return this.module.getBuiltIns();
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

    @NotNull
    public final Set<KotlinType> getPossibleTypes() {
        return this.possibleTypes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public TypeConstructor refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @NotNull
    public String toString() {
        return "IntegerLiteralType" + valueToString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    IntegerLiteralTypeConstructor(long j3, ModuleDescriptor moduleDescriptor, Set<? extends KotlinType> set) {
        Lazy lazy;
        this.type = KotlinTypeFactory.integerLiteralType(TypeAttributes.Companion.getEmpty(), this, false);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<SimpleType>>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor$supertypes$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<SimpleType> invoke() {
                SimpleType simpleType;
                List listOf;
                List<SimpleType> mutableListOf;
                boolean isContainsOnlyUnsignedTypes;
                SimpleType defaultType = IntegerLiteralTypeConstructor.this.getBuiltIns().getComparable().getDefaultType();
                Intrinsics.checkNotNullExpressionValue(defaultType, "builtIns.comparable.defaultType");
                Variance variance = Variance.IN_VARIANCE;
                simpleType = IntegerLiteralTypeConstructor.this.type;
                listOf = CollectionsKt__CollectionsJVMKt.listOf(new TypeProjectionImpl(variance, simpleType));
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(TypeSubstitutionKt.replace$default(defaultType, listOf, null, 2, null));
                isContainsOnlyUnsignedTypes = IntegerLiteralTypeConstructor.this.isContainsOnlyUnsignedTypes();
                if (!isContainsOnlyUnsignedTypes) {
                    mutableListOf.add(IntegerLiteralTypeConstructor.this.getBuiltIns().getNumberType());
                }
                return mutableListOf;
            }
        });
        this.supertypes$delegate = lazy;
        this.value = j3;
        this.module = moduleDescriptor;
        this.possibleTypes = set;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    /* renamed from: getSupertypes, reason: collision with other method in class */
    public Collection<KotlinType> mo1780getSupertypes() {
        return getSupertypes();
    }
}
