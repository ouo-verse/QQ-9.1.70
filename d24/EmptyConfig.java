package d24;

import com.google.gson.annotations.SerializedName;
import com.tencent.ttpic.openapi.filter.LightConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u00a8\u0006\u0013"}, d2 = {"Ld24/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "", LightConstants.MALE, "Ljava/util/List;", "b", "()Ljava/util/List;", LightConstants.FEMALE, "a", "c", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: d24.f, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class EmptyConfig {

    @SerializedName(LightConstants.FEMALE)
    @NotNull
    private final List<String> female;

    @SerializedName(LightConstants.MALE)
    @NotNull
    private final List<String> male;

    @SerializedName("other")
    @NotNull
    private final List<String> other;

    public EmptyConfig() {
        this(null, null, null, 7, null);
    }

    @NotNull
    public final List<String> a() {
        return this.female;
    }

    @NotNull
    public final List<String> b() {
        return this.male;
    }

    @NotNull
    public final List<String> c() {
        return this.other;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmptyConfig)) {
            return false;
        }
        EmptyConfig emptyConfig = (EmptyConfig) other;
        if (Intrinsics.areEqual(this.male, emptyConfig.male) && Intrinsics.areEqual(this.female, emptyConfig.female) && Intrinsics.areEqual(this.other, emptyConfig.other)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.male.hashCode() * 31) + this.female.hashCode()) * 31) + this.other.hashCode();
    }

    @NotNull
    public String toString() {
        return "EmptyConfig(male=" + this.male + ", female=" + this.female + ", other=" + this.other + ")";
    }

    public EmptyConfig(@NotNull List<String> male, @NotNull List<String> female, @NotNull List<String> other) {
        Intrinsics.checkNotNullParameter(male, "male");
        Intrinsics.checkNotNullParameter(female, "female");
        Intrinsics.checkNotNullParameter(other, "other");
        this.male = male;
        this.female = female;
        this.other = other;
    }

    public /* synthetic */ EmptyConfig(List list, List list2, List list3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i3 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list3);
    }
}
