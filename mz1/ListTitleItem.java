package mz1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mz1.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0016J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lmz1/h;", "Lmz1/c;", "", "getItemType", "", "getItemId", "newItem", "", "c", "b", "toString", "hashCode", "", "other", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "titleName", "<init>", "(Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: mz1.h, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class ListTitleItem implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String titleName;

    public ListTitleItem(@NotNull String titleName) {
        Intrinsics.checkNotNullParameter(titleName, "titleName");
        this.titleName = titleName;
    }

    @Override // mz1.c
    @Nullable
    public Object a(@NotNull c cVar) {
        return c.a.a(this, cVar);
    }

    @Override // mz1.c
    public boolean b(@NotNull c newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof ListTitleItem)) {
            return false;
        }
        return Intrinsics.areEqual(this.titleName, ((ListTitleItem) newItem).titleName);
    }

    @Override // mz1.c
    public boolean c(@NotNull c newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof ListTitleItem)) {
            return false;
        }
        return Intrinsics.areEqual(getItemId(), newItem.getItemId());
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getTitleName() {
        return this.titleName;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof ListTitleItem) && Intrinsics.areEqual(this.titleName, ((ListTitleItem) other).titleName)) {
            return true;
        }
        return false;
    }

    @Override // mz1.c
    @NotNull
    public String getItemId() {
        return "list_title_item";
    }

    @Override // mz1.c
    public int getItemType() {
        return 2;
    }

    public int hashCode() {
        return this.titleName.hashCode();
    }

    @NotNull
    public String toString() {
        return "ListTitleItem(titleName=" + this.titleName + ")";
    }
}
