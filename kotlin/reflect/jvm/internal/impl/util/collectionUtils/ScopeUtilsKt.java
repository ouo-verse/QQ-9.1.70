package kotlin.reflect.jvm.internal.impl.util.collectionUtils;

import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ScopeUtilsKt {
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static final <T> Collection<T> concat(@Nullable Collection<? extends T> collection, @NotNull Collection<? extends T> collection2) {
        Intrinsics.checkNotNullParameter(collection2, "collection");
        if (collection2.isEmpty()) {
            return collection;
        }
        if (collection == 0) {
            return collection2;
        }
        if (collection instanceof LinkedHashSet) {
            ((LinkedHashSet) collection).addAll(collection2);
            return collection;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        linkedHashSet.addAll(collection2);
        return linkedHashSet;
    }

    @NotNull
    public static final SmartList<MemberScope> listOfNonEmptyScopes(@NotNull Iterable<? extends MemberScope> scopes) {
        boolean z16;
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        SmartList<MemberScope> smartList = new SmartList<>();
        for (MemberScope memberScope : scopes) {
            MemberScope memberScope2 = memberScope;
            if (memberScope2 != null && memberScope2 != MemberScope.Empty.INSTANCE) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                smartList.add(memberScope);
            }
        }
        return smartList;
    }
}
