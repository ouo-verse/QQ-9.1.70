package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class GivenFunctionsMemberScope extends MemberScopeImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(GivenFunctionsMemberScope.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;"))};

    @NotNull
    private final NotNullLazyValue allDescriptors$delegate;

    @NotNull
    private final ClassDescriptor containingClass;

    public GivenFunctionsMemberScope(@NotNull StorageManager storageManager, @NotNull ClassDescriptor containingClass) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(containingClass, "containingClass");
        this.containingClass = containingClass;
        this.allDescriptors$delegate = storageManager.createLazyValue(new Function0<List<? extends DeclarationDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope$allDescriptors$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends DeclarationDescriptor> invoke() {
                List createFakeOverrides;
                List<? extends DeclarationDescriptor> plus;
                List<FunctionDescriptor> computeDeclaredFunctions = GivenFunctionsMemberScope.this.computeDeclaredFunctions();
                List<FunctionDescriptor> list = computeDeclaredFunctions;
                createFakeOverrides = GivenFunctionsMemberScope.this.createFakeOverrides(computeDeclaredFunctions);
                plus = CollectionsKt___CollectionsKt.plus((Collection) list, (Iterable) createFakeOverrides);
                return plus;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final List<DeclarationDescriptor> createFakeOverrides(List<? extends FunctionDescriptor> list) {
        Collection<? extends CallableMemberDescriptor> emptyList;
        final ArrayList arrayList = new ArrayList(3);
        Collection<KotlinType> mo1780getSupertypes = this.containingClass.getTypeConstructor().mo1780getSupertypes();
        Intrinsics.checkNotNullExpressionValue(mo1780getSupertypes, "containingClass.typeConstructor.supertypes");
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = mo1780getSupertypes.iterator();
        while (it.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList2, ResolutionScope.DefaultImpls.getContributedDescriptors$default(((KotlinType) it.next()).getMemberScope(), null, null, 3, null));
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (obj instanceof CallableMemberDescriptor) {
                arrayList3.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList3) {
            Name name = ((CallableMemberDescriptor) obj2).getName();
            Object obj3 = linkedHashMap.get(name);
            if (obj3 == null) {
                obj3 = new ArrayList();
                linkedHashMap.put(name, obj3);
            }
            ((List) obj3).add(obj2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Name name2 = (Name) entry.getKey();
            List list2 = (List) entry.getValue();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj4 : list2) {
                Boolean valueOf = Boolean.valueOf(((CallableMemberDescriptor) obj4) instanceof FunctionDescriptor);
                Object obj5 = linkedHashMap2.get(valueOf);
                if (obj5 == null) {
                    obj5 = new ArrayList();
                    linkedHashMap2.put(valueOf, obj5);
                }
                ((List) obj5).add(obj4);
            }
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                boolean booleanValue = ((Boolean) entry2.getKey()).booleanValue();
                List list3 = (List) entry2.getValue();
                OverridingUtil overridingUtil = OverridingUtil.DEFAULT;
                List list4 = list3;
                if (!booleanValue) {
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                } else {
                    emptyList = new ArrayList<>();
                    for (Object obj6 : list) {
                        if (Intrinsics.areEqual(((FunctionDescriptor) obj6).getName(), name2)) {
                            emptyList.add(obj6);
                        }
                    }
                }
                overridingUtil.generateOverridesInFunctionGroup(name2, list4, emptyList, this.containingClass, new NonReportingOverrideStrategy() { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope$createFakeOverrides$4
                    @Override // kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy
                    public void addFakeOverride(@NotNull CallableMemberDescriptor fakeOverride) {
                        Intrinsics.checkNotNullParameter(fakeOverride, "fakeOverride");
                        OverridingUtil.resolveUnknownVisibilityForMember(fakeOverride, null);
                        arrayList.add(fakeOverride);
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy
                    protected void conflict(@NotNull CallableMemberDescriptor fromSuper, @NotNull CallableMemberDescriptor fromCurrent) {
                        Intrinsics.checkNotNullParameter(fromSuper, "fromSuper");
                        Intrinsics.checkNotNullParameter(fromCurrent, "fromCurrent");
                        throw new IllegalStateException(("Conflict in scope of " + this.getContainingClass() + MsgSummary.STR_COLON + fromSuper + " vs " + fromCurrent).toString());
                    }
                });
            }
        }
        return CollectionsKt.compact(arrayList);
    }

    private final List<DeclarationDescriptor> getAllDescriptors() {
        return (List) StorageKt.getValue(this.allDescriptors$delegate, this, (KProperty<?>) $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract List<FunctionDescriptor> computeDeclaredFunctions();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ClassDescriptor getContainingClass() {
        return this.containingClass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
        List emptyList;
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        if (!kindFilter.acceptsKinds(DescriptorKindFilter.CALLABLES.getKindMask())) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return getAllDescriptors();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        List<DeclarationDescriptor> allDescriptors = getAllDescriptors();
        SmartList smartList = new SmartList();
        for (Object obj : allDescriptors) {
            if ((obj instanceof SimpleFunctionDescriptor) && Intrinsics.areEqual(((SimpleFunctionDescriptor) obj).getName(), name)) {
                smartList.add(obj);
            }
        }
        return smartList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        List<DeclarationDescriptor> allDescriptors = getAllDescriptors();
        SmartList smartList = new SmartList();
        for (Object obj : allDescriptors) {
            if ((obj instanceof PropertyDescriptor) && Intrinsics.areEqual(((PropertyDescriptor) obj).getName(), name)) {
                smartList.add(obj);
            }
        }
        return smartList;
    }
}
