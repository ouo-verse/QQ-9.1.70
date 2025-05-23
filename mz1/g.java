package mz1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mz1.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0016\u00a8\u0006\f"}, d2 = {"Lmz1/g;", "Lmz1/c;", "", "getItemType", "", "getItemId", "newItem", "", "c", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class g implements c {
    @Override // mz1.c
    @Nullable
    public Object a(@NotNull c cVar) {
        return c.a.a(this, cVar);
    }

    @Override // mz1.c
    public boolean b(@NotNull c newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return newItem instanceof g;
    }

    @Override // mz1.c
    public boolean c(@NotNull c newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof g)) {
            return false;
        }
        return Intrinsics.areEqual(getItemId(), newItem.getItemId());
    }

    @Override // mz1.c
    @NotNull
    public String getItemId() {
        return "empty_app_show_item";
    }

    @Override // mz1.c
    public int getItemType() {
        return 0;
    }
}
