package d03;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u0014\u0010\u000eR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0017\u0010\u000eR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u001a\u0010\u000eR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001c\u0010\u000e\u00a8\u0006 "}, d2 = {"Ld03/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setUinAndDiyId", "(Ljava/lang/String;)V", "uinAndDiyId", "b", "c", "setDiyText", "diyText", "setBottomLeftId", "bottomLeftId", "d", "setBottomRightId", "bottomRightId", "e", "setTopLeftId", "topLeftId", "setTopRightId", "topRightId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: d03.a, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class BubbleDiyData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String uinAndDiyId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String diyText;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String bottomLeftId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String bottomRightId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String topLeftId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String topRightId;

    public BubbleDiyData(@NotNull String uinAndDiyId, @NotNull String diyText, @NotNull String bottomLeftId, @NotNull String bottomRightId, @NotNull String topLeftId, @NotNull String topRightId) {
        Intrinsics.checkNotNullParameter(uinAndDiyId, "uinAndDiyId");
        Intrinsics.checkNotNullParameter(diyText, "diyText");
        Intrinsics.checkNotNullParameter(bottomLeftId, "bottomLeftId");
        Intrinsics.checkNotNullParameter(bottomRightId, "bottomRightId");
        Intrinsics.checkNotNullParameter(topLeftId, "topLeftId");
        Intrinsics.checkNotNullParameter(topRightId, "topRightId");
        this.uinAndDiyId = uinAndDiyId;
        this.diyText = diyText;
        this.bottomLeftId = bottomLeftId;
        this.bottomRightId = bottomRightId;
        this.topLeftId = topLeftId;
        this.topRightId = topRightId;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getBottomLeftId() {
        return this.bottomLeftId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getBottomRightId() {
        return this.bottomRightId;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getDiyText() {
        return this.diyText;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getTopLeftId() {
        return this.topLeftId;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getTopRightId() {
        return this.topRightId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BubbleDiyData)) {
            return false;
        }
        BubbleDiyData bubbleDiyData = (BubbleDiyData) other;
        if (Intrinsics.areEqual(this.uinAndDiyId, bubbleDiyData.uinAndDiyId) && Intrinsics.areEqual(this.diyText, bubbleDiyData.diyText) && Intrinsics.areEqual(this.bottomLeftId, bubbleDiyData.bottomLeftId) && Intrinsics.areEqual(this.bottomRightId, bubbleDiyData.bottomRightId) && Intrinsics.areEqual(this.topLeftId, bubbleDiyData.topLeftId) && Intrinsics.areEqual(this.topRightId, bubbleDiyData.topRightId)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getUinAndDiyId() {
        return this.uinAndDiyId;
    }

    public int hashCode() {
        return (((((((((this.uinAndDiyId.hashCode() * 31) + this.diyText.hashCode()) * 31) + this.bottomLeftId.hashCode()) * 31) + this.bottomRightId.hashCode()) * 31) + this.topLeftId.hashCode()) * 31) + this.topRightId.hashCode();
    }

    @NotNull
    public String toString() {
        return "BubbleDiyData(uinAndDiyId=" + this.uinAndDiyId + ", diyText=" + this.diyText + ", bottomLeftId=" + this.bottomLeftId + ", bottomRightId=" + this.bottomRightId + ", topLeftId=" + this.topLeftId + ", topRightId=" + this.topRightId + ")";
    }
}
