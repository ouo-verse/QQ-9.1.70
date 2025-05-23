package b64;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u0011\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lb64/a;", "Lb74/a;", "newItemData", "", "a", "b", "", "c", "", "toString", "", "hashCode", "other", "equals", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "<init>", "(Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: b64.a, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class SlashRecentFunctionTitleData implements b74.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    public SlashRecentFunctionTitleData(@NotNull String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.title = title;
    }

    @Override // b74.a
    public boolean a(@NotNull b74.a newItemData) {
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        if (newItemData instanceof SlashRecentFunctionTitleData) {
            return true;
        }
        return false;
    }

    @Override // b74.a
    public boolean b(@NotNull b74.a newItemData) {
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        return Intrinsics.areEqual(this.title, ((SlashRecentFunctionTitleData) newItemData).title);
    }

    @Override // b74.a
    @Nullable
    public Object c(@NotNull b74.a newItemData) {
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        return null;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof SlashRecentFunctionTitleData) && Intrinsics.areEqual(this.title, ((SlashRecentFunctionTitleData) other).title)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.title.hashCode();
    }

    @NotNull
    public String toString() {
        return "SlashRecentFunctionTitleData(title=" + this.title + ")";
    }
}
