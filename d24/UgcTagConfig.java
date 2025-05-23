package d24;

import com.google.gson.annotations.SerializedName;
import com.tencent.ttpic.openapi.filter.LightConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0017\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R&\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00178\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001e"}, d2 = {"Ld24/n;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Ld24/k;", LightConstants.MALE, "Ljava/util/List;", "c", "()Ljava/util/List;", LightConstants.FEMALE, "b", "d", "Ld24/f;", "emptyConfig", "Ld24/f;", "a", "()Ld24/f;", "", "referMap", "Ljava/util/Map;", "e", "()Ljava/util/Map;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ld24/f;Ljava/util/Map;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: d24.n, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class UgcTagConfig {

    @SerializedName("emptyConfig")
    @NotNull
    private final EmptyConfig emptyConfig;

    @SerializedName(LightConstants.FEMALE)
    @NotNull
    private final List<SingleTagConfig> female;

    @SerializedName(LightConstants.MALE)
    @NotNull
    private final List<SingleTagConfig> male;

    @SerializedName("other")
    @NotNull
    private final List<SingleTagConfig> other;

    @SerializedName("referMap")
    @NotNull
    private final Map<String, String> referMap;

    public UgcTagConfig() {
        this(null, null, null, null, null, 31, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final EmptyConfig getEmptyConfig() {
        return this.emptyConfig;
    }

    @NotNull
    public final List<SingleTagConfig> b() {
        return this.female;
    }

    @NotNull
    public final List<SingleTagConfig> c() {
        return this.male;
    }

    @NotNull
    public final List<SingleTagConfig> d() {
        return this.other;
    }

    @NotNull
    public final Map<String, String> e() {
        return this.referMap;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UgcTagConfig)) {
            return false;
        }
        UgcTagConfig ugcTagConfig = (UgcTagConfig) other;
        if (Intrinsics.areEqual(this.male, ugcTagConfig.male) && Intrinsics.areEqual(this.female, ugcTagConfig.female) && Intrinsics.areEqual(this.other, ugcTagConfig.other) && Intrinsics.areEqual(this.emptyConfig, ugcTagConfig.emptyConfig) && Intrinsics.areEqual(this.referMap, ugcTagConfig.referMap)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.male.hashCode() * 31) + this.female.hashCode()) * 31) + this.other.hashCode()) * 31) + this.emptyConfig.hashCode()) * 31) + this.referMap.hashCode();
    }

    @NotNull
    public String toString() {
        return "UgcTagConfig(male=" + this.male + ", female=" + this.female + ", other=" + this.other + ", emptyConfig=" + this.emptyConfig + ", referMap=" + this.referMap + ")";
    }

    public UgcTagConfig(@NotNull List<SingleTagConfig> male, @NotNull List<SingleTagConfig> female, @NotNull List<SingleTagConfig> other, @NotNull EmptyConfig emptyConfig, @NotNull Map<String, String> referMap) {
        Intrinsics.checkNotNullParameter(male, "male");
        Intrinsics.checkNotNullParameter(female, "female");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(emptyConfig, "emptyConfig");
        Intrinsics.checkNotNullParameter(referMap, "referMap");
        this.male = male;
        this.female = female;
        this.other = other;
        this.emptyConfig = emptyConfig;
        this.referMap = referMap;
    }

    public /* synthetic */ UgcTagConfig(List list, List list2, List list3, EmptyConfig emptyConfig, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i3 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list3, (i3 & 8) != 0 ? new EmptyConfig(null, null, null, 7, null) : emptyConfig, (i3 & 16) != 0 ? MapsKt__MapsKt.emptyMap() : map);
    }
}
