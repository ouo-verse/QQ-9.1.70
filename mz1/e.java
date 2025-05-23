package mz1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mz1.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0016R\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lmz1/e;", "Lmz1/c;", "", "getItemType", "", "getItemId", "newItem", "", "c", "b", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "tipsContent", "I", "d", "()I", "setMarginTopDp", "(I)V", "marginTopDp", "<init>", "(Ljava/lang/String;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class e implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String tipsContent;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int marginTopDp;

    public e(@NotNull String tipsContent, int i3) {
        Intrinsics.checkNotNullParameter(tipsContent, "tipsContent");
        this.tipsContent = tipsContent;
        this.marginTopDp = i3;
    }

    @Override // mz1.c
    @Nullable
    public Object a(@NotNull c cVar) {
        return c.a.a(this, cVar);
    }

    @Override // mz1.c
    public boolean b(@NotNull c newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof e)) {
            return false;
        }
        e eVar = (e) newItem;
        if (!Intrinsics.areEqual(this.tipsContent, eVar.tipsContent) && this.marginTopDp != eVar.marginTopDp) {
            return false;
        }
        return true;
    }

    @Override // mz1.c
    public boolean c(@NotNull c newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof e)) {
            return false;
        }
        return Intrinsics.areEqual(getItemId(), newItem.getItemId());
    }

    /* renamed from: d, reason: from getter */
    public final int getMarginTopDp() {
        return this.marginTopDp;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getTipsContent() {
        return this.tipsContent;
    }

    public final void f(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tipsContent = str;
    }

    @Override // mz1.c
    @NotNull
    public String getItemId() {
        return "edit_tips_item";
    }

    @Override // mz1.c
    public int getItemType() {
        return 3;
    }
}
