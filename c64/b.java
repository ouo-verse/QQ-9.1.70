package c64;

import g54.SearchItemDataPayload;
import g54.SearchItemTitlePayload;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0016R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lc64/b;", "Lb74/a;", "newItemData", "", "a", "b", "", "c", "", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "title", "d", "callbackData", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b implements b74.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String callbackData;

    public b(@NotNull String title, @NotNull String callbackData) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(callbackData, "callbackData");
        this.title = title;
        this.callbackData = callbackData;
    }

    @Override // b74.a
    public boolean a(@NotNull b74.a newItemData) {
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        if (!(newItemData instanceof b)) {
            return false;
        }
        b bVar = (b) newItemData;
        if (!Intrinsics.areEqual(this.title, bVar.title) || !Intrinsics.areEqual(this.callbackData, bVar.callbackData)) {
            return false;
        }
        return true;
    }

    @Override // b74.a
    public boolean b(@NotNull b74.a newItemData) {
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        b bVar = (b) newItemData;
        if (Intrinsics.areEqual(this.title, bVar.title) && Intrinsics.areEqual(this.callbackData, bVar.callbackData)) {
            return true;
        }
        return false;
    }

    @Override // b74.a
    @Nullable
    public Object c(@NotNull b74.a newItemData) {
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        b bVar = (b) newItemData;
        ArrayList arrayList = new ArrayList();
        if (!Intrinsics.areEqual(this.title, bVar.title)) {
            arrayList.add(new SearchItemTitlePayload(bVar.title));
        }
        if (!Intrinsics.areEqual(this.callbackData, bVar.callbackData)) {
            arrayList.add(new SearchItemDataPayload(bVar.callbackData));
        }
        return arrayList;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getCallbackData() {
        return this.callbackData;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getTitle() {
        return this.title;
    }
}
