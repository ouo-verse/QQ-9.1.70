package mz1;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mz1.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0016R\u0017\u0010\u000e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lmz1/d;", "Lmz1/c;", "", "getItemType", "", "getItemId", "newItem", "", "c", "b", "a", "Z", "d", "()Z", "isOverServiceNumber", "<init>", "(Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isOverServiceNumber;

    public d() {
        this(false, 1, null);
    }

    @Override // mz1.c
    @Nullable
    public Object a(@NotNull c cVar) {
        return c.a.a(this, cVar);
    }

    @Override // mz1.c
    public boolean b(@NotNull c newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof d) || this.isOverServiceNumber != ((d) newItem).isOverServiceNumber) {
            return false;
        }
        return true;
    }

    @Override // mz1.c
    public boolean c(@NotNull c newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof d)) {
            return false;
        }
        return Intrinsics.areEqual(getItemId(), newItem.getItemId());
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsOverServiceNumber() {
        return this.isOverServiceNumber;
    }

    @Override // mz1.c
    @NotNull
    public String getItemId() {
        return "custom_service_item";
    }

    @Override // mz1.c
    public int getItemType() {
        return 1;
    }

    public d(boolean z16) {
        this.isOverServiceNumber = z16;
    }

    public /* synthetic */ d(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }
}
