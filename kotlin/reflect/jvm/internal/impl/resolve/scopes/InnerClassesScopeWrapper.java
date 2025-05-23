package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class InnerClassesScopeWrapper extends MemberScopeImpl {

    @NotNull
    private final MemberScope workerScope;

    public InnerClassesScopeWrapper(@NotNull MemberScope workerScope) {
        Intrinsics.checkNotNullParameter(workerScope, "workerScope");
        this.workerScope = workerScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @Nullable
    public Set<Name> getClassifierNames() {
        return this.workerScope.getClassifierNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @Nullable
    /* renamed from: getContributedClassifier */
    public ClassifierDescriptor mo1781getContributedClassifier(@NotNull Name name, @NotNull LookupLocation location) {
        ClassDescriptor classDescriptor;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        ClassifierDescriptor mo1781getContributedClassifier = this.workerScope.mo1781getContributedClassifier(name, location);
        if (mo1781getContributedClassifier == null) {
            return null;
        }
        if (mo1781getContributedClassifier instanceof ClassDescriptor) {
            classDescriptor = (ClassDescriptor) mo1781getContributedClassifier;
        } else {
            classDescriptor = null;
        }
        if (classDescriptor != null) {
            return classDescriptor;
        }
        if (!(mo1781getContributedClassifier instanceof TypeAliasDescriptor)) {
            return null;
        }
        return (TypeAliasDescriptor) mo1781getContributedClassifier;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public /* bridge */ /* synthetic */ Collection getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1 function1) {
        return getContributedDescriptors(descriptorKindFilter, (Function1<? super Name, Boolean>) function1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<Name> getFunctionNames() {
        return this.workerScope.getFunctionNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<Name> getVariableNames() {
        return this.workerScope.getVariableNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: recordLookup */
    public void mo1785recordLookup(@NotNull Name name, @NotNull LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        this.workerScope.mo1785recordLookup(name, location);
    }

    @NotNull
    public String toString() {
        return "Classes from " + this.workerScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public List<ClassifierDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
        List<ClassifierDescriptor> emptyList;
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        DescriptorKindFilter restrictedToKindsOrNull = kindFilter.restrictedToKindsOrNull(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK());
        if (restrictedToKindsOrNull == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        Collection<DeclarationDescriptor> contributedDescriptors = this.workerScope.getContributedDescriptors(restrictedToKindsOrNull, nameFilter);
        ArrayList arrayList = new ArrayList();
        for (Object obj : contributedDescriptors) {
            if (obj instanceof ClassifierDescriptorWithTypeParameters) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
