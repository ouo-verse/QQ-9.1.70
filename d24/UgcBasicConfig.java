package d24;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0011"}, d2 = {"Ld24/m;", "", "", "toString", "", "hashCode", "other", "", "equals", "perRequestMaxImgCount", "I", "a", "()I", "requestMaxCount", "b", "<init>", "(II)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: d24.m, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class UgcBasicConfig {

    @SerializedName("perRequestMaxImgCount")
    private final int perRequestMaxImgCount;

    @SerializedName("requestMaxCount")
    private final int requestMaxCount;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public UgcBasicConfig() {
        this(r2, r2, 3, null);
        int i3 = 0;
    }

    /* renamed from: a, reason: from getter */
    public final int getPerRequestMaxImgCount() {
        return this.perRequestMaxImgCount;
    }

    /* renamed from: b, reason: from getter */
    public final int getRequestMaxCount() {
        return this.requestMaxCount;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UgcBasicConfig)) {
            return false;
        }
        UgcBasicConfig ugcBasicConfig = (UgcBasicConfig) other;
        if (this.perRequestMaxImgCount == ugcBasicConfig.perRequestMaxImgCount && this.requestMaxCount == ugcBasicConfig.requestMaxCount) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.perRequestMaxImgCount * 31) + this.requestMaxCount;
    }

    @NotNull
    public String toString() {
        return "UgcBasicConfig(perRequestMaxImgCount=" + this.perRequestMaxImgCount + ", requestMaxCount=" + this.requestMaxCount + ")";
    }

    public UgcBasicConfig(int i3, int i16) {
        this.perRequestMaxImgCount = i3;
        this.requestMaxCount = i16;
    }

    public /* synthetic */ UgcBasicConfig(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 6 : i3, (i17 & 2) != 0 ? 4 : i16);
    }
}
