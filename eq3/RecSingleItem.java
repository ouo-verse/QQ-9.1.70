package eq3;

import android.widget.CheckBox;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Leq3/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "type", "Ljava/lang/String;", "()Ljava/lang/String;", "id", "Landroid/widget/CheckBox;", "c", "Landroid/widget/CheckBox;", "getCheckBox", "()Landroid/widget/CheckBox;", "checkBox", "<init>", "(ILjava/lang/String;Landroid/widget/CheckBox;)V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: eq3.b, reason: from toString */
/* loaded from: classes22.dex */
public final /* data */ class RecSingleItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String id;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final CheckBox checkBox;

    public RecSingleItem(int i3, @Nullable String str, @NotNull CheckBox checkBox) {
        Intrinsics.checkNotNullParameter(checkBox, "checkBox");
        this.type = i3;
        this.id = str;
        this.checkBox = checkBox;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: b, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecSingleItem)) {
            return false;
        }
        RecSingleItem recSingleItem = (RecSingleItem) other;
        if (this.type == recSingleItem.type && Intrinsics.areEqual(this.id, recSingleItem.id) && Intrinsics.areEqual(this.checkBox, recSingleItem.checkBox)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i3 = this.type * 31;
        String str = this.id;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return ((i3 + hashCode) * 31) + this.checkBox.hashCode();
    }

    @NotNull
    public String toString() {
        return "RecSingleItem(type=" + this.type + ", id=" + this.id + ", checkBox=" + this.checkBox + ")";
    }
}
