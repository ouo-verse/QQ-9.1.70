package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class MemberScopeKt {
    @Nullable
    public static final Set<Name> flatMapClassifierNamesOrNull(@NotNull Iterable<? extends MemberScope> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        HashSet hashSet = new HashSet();
        Iterator<? extends MemberScope> it = iterable.iterator();
        while (it.hasNext()) {
            Set<Name> classifierNames = it.next().getClassifierNames();
            if (classifierNames != null) {
                CollectionsKt__MutableCollectionsKt.addAll(hashSet, classifierNames);
            } else {
                return null;
            }
        }
        return hashSet;
    }
}
