package e74;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0016R$\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001c\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Le74/f;", "Lb74/a;", "newItemData", "", "a", "b", "", "c", "", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "title", "", "Le74/b;", "Ljava/util/List;", "e", "()Ljava/util/List;", h.F, "(Ljava/util/List;)V", "itemDataLists", "Le74/b;", "d", "()Le74/b;", "g", "(Le74/b;)V", "defaultData", "<init>", "(Ljava/lang/String;Ljava/util/List;Le74/b;)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class f implements b74.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<ItemData> itemDataLists;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ItemData defaultData;

    public f(@Nullable String str, @Nullable List<ItemData> list, @Nullable ItemData itemData) {
        this.title = str;
        this.itemDataLists = list;
        this.defaultData = itemData;
    }

    @Override // b74.a
    public boolean a(@NotNull b74.a newItemData) {
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        return false;
    }

    @Override // b74.a
    public boolean b(@NotNull b74.a newItemData) {
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        return false;
    }

    @Override // b74.a
    @Nullable
    public Object c(@NotNull b74.a newItemData) {
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        return null;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final ItemData getDefaultData() {
        return this.defaultData;
    }

    @Nullable
    public final List<ItemData> e() {
        return this.itemDataLists;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final void g(@Nullable ItemData itemData) {
        this.defaultData = itemData;
    }

    public final void h(@Nullable List<ItemData> list) {
        this.itemDataLists = list;
    }

    public final void i(@Nullable String str) {
        this.title = str;
    }

    public /* synthetic */ f(String str, List list, ItemData itemData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? null : list, (i3 & 4) != 0 ? null : itemData);
    }
}
