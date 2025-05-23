package d24;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Ld24/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "groupId", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "", "tagList", "Ljava/util/List;", "b", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: d24.k, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class SingleTagConfig {

    @SerializedName("groupID")
    @NotNull
    private final String groupId;

    @SerializedName("tagList")
    @NotNull
    private final List<String> tagList;

    public SingleTagConfig() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    @NotNull
    public final List<String> b() {
        return this.tagList;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SingleTagConfig)) {
            return false;
        }
        SingleTagConfig singleTagConfig = (SingleTagConfig) other;
        if (Intrinsics.areEqual(this.groupId, singleTagConfig.groupId) && Intrinsics.areEqual(this.tagList, singleTagConfig.tagList)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.groupId.hashCode() * 31) + this.tagList.hashCode();
    }

    @NotNull
    public String toString() {
        return "SingleTagConfig(groupId=" + this.groupId + ", tagList=" + this.tagList + ")";
    }

    public SingleTagConfig(@NotNull String groupId, @NotNull List<String> tagList) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(tagList, "tagList");
        this.groupId = groupId;
        this.tagList = tagList;
    }

    public /* synthetic */ SingleTagConfig(String str, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
