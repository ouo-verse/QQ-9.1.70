package gk2;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u001a+\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"T", "", "v", "a", "(Ljava/util/List;Ljava/lang/Object;)Ljava/util/List;", "qqvideoedit_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b {
    @NotNull
    public static final <T> List<T> a(@NotNull List<? extends T> list, T t16) {
        List<T> mutableList;
        Intrinsics.checkNotNullParameter(list, "<this>");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        mutableList.add(t16);
        return mutableList;
    }
}
