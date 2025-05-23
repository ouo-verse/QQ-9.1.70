package mz1;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H&J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0000H\u0016\u00a8\u0006\u000b"}, d2 = {"Lmz1/c;", "", "", "getItemType", "", "getItemId", "newItem", "", "c", "b", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface c {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class a {
        @Nullable
        public static Object a(@NotNull c cVar, @NotNull c newItem) {
            List emptyList;
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }

    @Nullable
    Object a(@NotNull c newItem);

    boolean b(@NotNull c newItem);

    boolean c(@NotNull c newItem);

    @NotNull
    String getItemId();

    int getItemType();
}
