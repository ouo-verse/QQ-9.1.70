package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class AbstractTypeConstructor extends ClassifierBasedTypeConstructor {
    private final boolean shouldReportCyclicScopeWithCompanionWarning;

    @NotNull
    private final NotNullLazyValue<Supertypes> supertypes;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public final class ModuleViewTypeConstructor implements TypeConstructor {

        @NotNull
        private final KotlinTypeRefiner kotlinTypeRefiner;

        @NotNull
        private final Lazy refinedSupertypes$delegate;
        final /* synthetic */ AbstractTypeConstructor this$0;

        public ModuleViewTypeConstructor(@NotNull final AbstractTypeConstructor abstractTypeConstructor, KotlinTypeRefiner kotlinTypeRefiner) {
            Lazy lazy;
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            this.this$0 = abstractTypeConstructor;
            this.kotlinTypeRefiner = kotlinTypeRefiner;
            lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<List<? extends KotlinType>>() { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$ModuleViewTypeConstructor$refinedSupertypes$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final List<? extends KotlinType> invoke() {
                    KotlinTypeRefiner kotlinTypeRefiner2;
                    kotlinTypeRefiner2 = AbstractTypeConstructor.ModuleViewTypeConstructor.this.kotlinTypeRefiner;
                    return KotlinTypeRefinerKt.refineTypes(kotlinTypeRefiner2, abstractTypeConstructor.mo1780getSupertypes());
                }
            });
            this.refinedSupertypes$delegate = lazy;
        }

        private final List<KotlinType> getRefinedSupertypes() {
            return (List) this.refinedSupertypes$delegate.getValue();
        }

        public boolean equals(@Nullable Object obj) {
            return this.this$0.equals(obj);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public KotlinBuiltIns getBuiltIns() {
            KotlinBuiltIns builtIns = this.this$0.getBuiltIns();
            Intrinsics.checkNotNullExpressionValue(builtIns, "this@AbstractTypeConstructor.builtIns");
            return builtIns;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        /* renamed from: getDeclarationDescriptor */
        public ClassifierDescriptor mo1779getDeclarationDescriptor() {
            return this.this$0.mo1779getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> parameters = this.this$0.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "this@AbstractTypeConstructor.parameters");
            return parameters;
        }

        public int hashCode() {
            return this.this$0.hashCode();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return this.this$0.isDenotable();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public TypeConstructor refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            return this.this$0.refine(kotlinTypeRefiner);
        }

        @NotNull
        public String toString() {
            return this.this$0.toString();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        /* renamed from: getSupertypes */
        public List<KotlinType> mo1780getSupertypes() {
            return getRefinedSupertypes();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Supertypes {

        @NotNull
        private final Collection<KotlinType> allSupertypes;

        @NotNull
        private List<? extends KotlinType> supertypesWithoutCycles;

        /* JADX WARN: Multi-variable type inference failed */
        public Supertypes(@NotNull Collection<? extends KotlinType> allSupertypes) {
            List<? extends KotlinType> listOf;
            Intrinsics.checkNotNullParameter(allSupertypes, "allSupertypes");
            this.allSupertypes = allSupertypes;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(ErrorUtils.INSTANCE.getErrorTypeForLoopInSupertypes());
            this.supertypesWithoutCycles = listOf;
        }

        @NotNull
        public final Collection<KotlinType> getAllSupertypes() {
            return this.allSupertypes;
        }

        @NotNull
        public final List<KotlinType> getSupertypesWithoutCycles() {
            return this.supertypesWithoutCycles;
        }

        public final void setSupertypesWithoutCycles(@NotNull List<? extends KotlinType> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.supertypesWithoutCycles = list;
        }
    }

    public AbstractTypeConstructor(@NotNull StorageManager storageManager) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        this.supertypes = storageManager.createLazyValueWithPostCompute(new Function0<Supertypes>() { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$supertypes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AbstractTypeConstructor.Supertypes invoke() {
                return new AbstractTypeConstructor.Supertypes(AbstractTypeConstructor.this.computeSupertypes());
            }
        }, new Function1<Boolean, Supertypes>() { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$supertypes$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ AbstractTypeConstructor.Supertypes invoke(Boolean bool) {
                return invoke(bool.booleanValue());
            }

            @NotNull
            public final AbstractTypeConstructor.Supertypes invoke(boolean z16) {
                List listOf;
                listOf = CollectionsKt__CollectionsJVMKt.listOf(ErrorUtils.INSTANCE.getErrorTypeForLoopInSupertypes());
                return new AbstractTypeConstructor.Supertypes(listOf);
            }
        }, new Function1<Supertypes, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$supertypes$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AbstractTypeConstructor.Supertypes supertypes) {
                invoke2(supertypes);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull AbstractTypeConstructor.Supertypes supertypes) {
                Intrinsics.checkNotNullParameter(supertypes, "supertypes");
                SupertypeLoopChecker supertypeLoopChecker = AbstractTypeConstructor.this.getSupertypeLoopChecker();
                AbstractTypeConstructor abstractTypeConstructor = AbstractTypeConstructor.this;
                Collection<KotlinType> allSupertypes = supertypes.getAllSupertypes();
                final AbstractTypeConstructor abstractTypeConstructor2 = AbstractTypeConstructor.this;
                Function1<TypeConstructor, Iterable<? extends KotlinType>> function1 = new Function1<TypeConstructor, Iterable<? extends KotlinType>>() { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$supertypes$3$resultWithoutCycles$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Iterable<KotlinType> invoke(@NotNull TypeConstructor it) {
                        Collection computeNeighbours;
                        Intrinsics.checkNotNullParameter(it, "it");
                        computeNeighbours = AbstractTypeConstructor.this.computeNeighbours(it, false);
                        return computeNeighbours;
                    }
                };
                final AbstractTypeConstructor abstractTypeConstructor3 = AbstractTypeConstructor.this;
                List findLoopsInSupertypesAndDisconnect = supertypeLoopChecker.findLoopsInSupertypesAndDisconnect(abstractTypeConstructor, allSupertypes, function1, new Function1<KotlinType, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$supertypes$3$resultWithoutCycles$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(KotlinType kotlinType) {
                        invoke2(kotlinType);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull KotlinType it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        AbstractTypeConstructor.this.reportSupertypeLoopError(it);
                    }
                });
                if (findLoopsInSupertypesAndDisconnect.isEmpty()) {
                    KotlinType defaultSupertypeIfEmpty = AbstractTypeConstructor.this.defaultSupertypeIfEmpty();
                    List listOf = defaultSupertypeIfEmpty != null ? CollectionsKt__CollectionsJVMKt.listOf(defaultSupertypeIfEmpty) : null;
                    if (listOf == null) {
                        listOf = CollectionsKt__CollectionsKt.emptyList();
                    }
                    findLoopsInSupertypesAndDisconnect = listOf;
                }
                if (AbstractTypeConstructor.this.getShouldReportCyclicScopeWithCompanionWarning()) {
                    SupertypeLoopChecker supertypeLoopChecker2 = AbstractTypeConstructor.this.getSupertypeLoopChecker();
                    final AbstractTypeConstructor abstractTypeConstructor4 = AbstractTypeConstructor.this;
                    Function1<TypeConstructor, Iterable<? extends KotlinType>> function12 = new Function1<TypeConstructor, Iterable<? extends KotlinType>>() { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$supertypes$3.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final Iterable<KotlinType> invoke(@NotNull TypeConstructor it) {
                            Collection computeNeighbours;
                            Intrinsics.checkNotNullParameter(it, "it");
                            computeNeighbours = AbstractTypeConstructor.this.computeNeighbours(it, true);
                            return computeNeighbours;
                        }
                    };
                    final AbstractTypeConstructor abstractTypeConstructor5 = AbstractTypeConstructor.this;
                    supertypeLoopChecker2.findLoopsInSupertypesAndDisconnect(abstractTypeConstructor4, findLoopsInSupertypesAndDisconnect, function12, new Function1<KotlinType, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$supertypes$3.3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(KotlinType kotlinType) {
                            invoke2(kotlinType);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull KotlinType it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            AbstractTypeConstructor.this.reportScopesLoopError(it);
                        }
                    });
                }
                AbstractTypeConstructor abstractTypeConstructor6 = AbstractTypeConstructor.this;
                List<KotlinType> list = findLoopsInSupertypesAndDisconnect instanceof List ? (List) findLoopsInSupertypesAndDisconnect : null;
                if (list == null) {
                    list = CollectionsKt___CollectionsKt.toList(findLoopsInSupertypesAndDisconnect);
                }
                supertypes.setSupertypesWithoutCycles(abstractTypeConstructor6.processSupertypesWithoutCycles(list));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000b, code lost:
    
        r4 = kotlin.collections.CollectionsKt___CollectionsKt.plus((java.util.Collection) r0.supertypes.invoke().getAllSupertypes(), (java.lang.Iterable) r0.getAdditionalNeighboursInSupertypeGraph(r4));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Collection<KotlinType> computeNeighbours(TypeConstructor typeConstructor, boolean z16) {
        AbstractTypeConstructor abstractTypeConstructor;
        List plus;
        if (typeConstructor instanceof AbstractTypeConstructor) {
            abstractTypeConstructor = (AbstractTypeConstructor) typeConstructor;
        } else {
            abstractTypeConstructor = null;
        }
        if (abstractTypeConstructor != null && plus != null) {
            return plus;
        }
        Collection<KotlinType> supertypes = typeConstructor.mo1780getSupertypes();
        Intrinsics.checkNotNullExpressionValue(supertypes, "supertypes");
        return supertypes;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract Collection<KotlinType> computeSupertypes();

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public KotlinType defaultSupertypeIfEmpty() {
        return null;
    }

    @NotNull
    protected Collection<KotlinType> getAdditionalNeighboursInSupertypeGraph(boolean z16) {
        List emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean getShouldReportCyclicScopeWithCompanionWarning() {
        return this.shouldReportCyclicScopeWithCompanionWarning;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract SupertypeLoopChecker getSupertypeLoopChecker();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public List<KotlinType> processSupertypesWithoutCycles(@NotNull List<KotlinType> supertypes) {
        Intrinsics.checkNotNullParameter(supertypes, "supertypes");
        return supertypes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public TypeConstructor refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new ModuleViewTypeConstructor(this, kotlinTypeRefiner);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportScopesLoopError(@NotNull KotlinType type) {
        Intrinsics.checkNotNullParameter(type, "type");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportSupertypeLoopError(@NotNull KotlinType type) {
        Intrinsics.checkNotNullParameter(type, "type");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    /* renamed from: getSupertypes */
    public List<KotlinType> mo1780getSupertypes() {
        return this.supertypes.invoke().getSupertypesWithoutCycles();
    }
}
