package dr0;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\t\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Ldr0/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "d", "()I", "packId", "b", "faceId", "c", NodeProps.CUSTOM_PROP_IMAGE_TYPE, "Ljava/lang/String;", "()Ljava/lang/String;", "dsc", "<init>", "(IIILjava/lang/String;)V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: dr0.b, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class MarketSmallFaceInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int packId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int faceId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int imageType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String dsc;

    public MarketSmallFaceInfo(int i3, int i16, int i17, @NotNull String dsc) {
        Intrinsics.checkNotNullParameter(dsc, "dsc");
        this.packId = i3;
        this.faceId = i16;
        this.imageType = i17;
        this.dsc = dsc;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getDsc() {
        return this.dsc;
    }

    /* renamed from: b, reason: from getter */
    public final int getFaceId() {
        return this.faceId;
    }

    /* renamed from: c, reason: from getter */
    public final int getImageType() {
        return this.imageType;
    }

    /* renamed from: d, reason: from getter */
    public final int getPackId() {
        return this.packId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MarketSmallFaceInfo)) {
            return false;
        }
        MarketSmallFaceInfo marketSmallFaceInfo = (MarketSmallFaceInfo) other;
        if (this.packId == marketSmallFaceInfo.packId && this.faceId == marketSmallFaceInfo.faceId && this.imageType == marketSmallFaceInfo.imageType && Intrinsics.areEqual(this.dsc, marketSmallFaceInfo.dsc)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.packId * 31) + this.faceId) * 31) + this.imageType) * 31) + this.dsc.hashCode();
    }

    @NotNull
    public String toString() {
        return "MarketSmallFaceInfo(packId=" + this.packId + ", faceId=" + this.faceId + ", imageType=" + this.imageType + ", dsc=" + this.dsc + ")";
    }
}
