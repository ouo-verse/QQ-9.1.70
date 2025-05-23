package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface MemberScope extends ResolutionScope {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final Function1<Name, Boolean> ALL_NAME_FILTER = new Function1<Name, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope$Companion$ALL_NAME_FILTER$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Name it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.TRUE;
            }
        };

        Companion() {
        }

        @NotNull
        public final Function1<Name, Boolean> getALL_NAME_FILTER() {
            return ALL_NAME_FILTER;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class DefaultImpls {
        public static void recordLookup(@NotNull MemberScope memberScope, @NotNull Name name, @NotNull LookupLocation location) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(location, "location");
            ResolutionScope.DefaultImpls.recordLookup(memberScope, name, location);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Empty extends MemberScopeImpl {

        @NotNull
        public static final Empty INSTANCE = new Empty();

        Empty() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<Name> getClassifierNames() {
            Set<Name> emptySet;
            emptySet = SetsKt__SetsKt.emptySet();
            return emptySet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<Name> getFunctionNames() {
            Set<Name> emptySet;
            emptySet = SetsKt__SetsKt.emptySet();
            return emptySet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<Name> getVariableNames() {
            Set<Name> emptySet;
            emptySet = SetsKt__SetsKt.emptySet();
            return emptySet;
        }
    }

    @Nullable
    Set<Name> getClassifierNames();

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation lookupLocation);

    @NotNull
    Collection<? extends PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation lookupLocation);

    @NotNull
    Set<Name> getFunctionNames();

    @NotNull
    Set<Name> getVariableNames();
}
