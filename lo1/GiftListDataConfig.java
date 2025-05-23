package lo1;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Llo1/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "panelType", "Ljava/lang/String;", "()Ljava/lang/String;", "anchorId", "c", "source", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: lo1.a, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GiftListDataConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int panelType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String anchorId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String source;

    public GiftListDataConfig(int i3, @NotNull String anchorId, @NotNull String source) {
        Intrinsics.checkNotNullParameter(anchorId, "anchorId");
        Intrinsics.checkNotNullParameter(source, "source");
        this.panelType = i3;
        this.anchorId = anchorId;
        this.source = source;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAnchorId() {
        return this.anchorId;
    }

    /* renamed from: b, reason: from getter */
    public final int getPanelType() {
        return this.panelType;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GiftListDataConfig)) {
            return false;
        }
        GiftListDataConfig giftListDataConfig = (GiftListDataConfig) other;
        if (this.panelType == giftListDataConfig.panelType && Intrinsics.areEqual(this.anchorId, giftListDataConfig.anchorId) && Intrinsics.areEqual(this.source, giftListDataConfig.source)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.panelType * 31) + this.anchorId.hashCode()) * 31) + this.source.hashCode();
    }

    @NotNull
    public String toString() {
        return "GiftListDataConfig(panelType=" + this.panelType + ", anchorId=" + this.anchorId + ", source=" + this.source + ")";
    }

    public /* synthetic */ GiftListDataConfig(int i3, String str, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, (i16 & 4) != 0 ? "0" : str2);
    }
}
