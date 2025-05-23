package lg3;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\u000bR\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\u000bR\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0017\u0010\u000bR\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\u000b\u00a8\u0006\u001e"}, d2 = {"Llg3/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "delay", "b", "getPacketsLost", "packetsLost", "c", "getPacketsReceived", "packetsReceived", "d", "getFrameRate", "frameRate", "e", "getFrameWidth", "frameWidth", "f", "getFrameHeight", "frameHeight", "<init>", "(IIIIII)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: lg3.b, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class CloudNetworkData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int delay;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int packetsLost;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int packetsReceived;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int frameRate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int frameWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int frameHeight;

    public CloudNetworkData(int i3, int i16, int i17, int i18, int i19, int i26) {
        this.delay = i3;
        this.packetsLost = i16;
        this.packetsReceived = i17;
        this.frameRate = i18;
        this.frameWidth = i19;
        this.frameHeight = i26;
    }

    /* renamed from: a, reason: from getter */
    public final int getDelay() {
        return this.delay;
    }

    public int hashCode() {
        return (((((((((this.delay * 31) + this.packetsLost) * 31) + this.packetsReceived) * 31) + this.frameRate) * 31) + this.frameWidth) * 31) + this.frameHeight;
    }

    public String toString() {
        return "CloudNetworkData(delay=" + this.delay + ", packetsLost=" + this.packetsLost + ", packetsReceived=" + this.packetsReceived + ", frameRate=" + this.frameRate + ", frameWidth=" + this.frameWidth + ", frameHeight=" + this.frameHeight + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CloudNetworkData)) {
            return false;
        }
        CloudNetworkData cloudNetworkData = (CloudNetworkData) other;
        return this.delay == cloudNetworkData.delay && this.packetsLost == cloudNetworkData.packetsLost && this.packetsReceived == cloudNetworkData.packetsReceived && this.frameRate == cloudNetworkData.frameRate && this.frameWidth == cloudNetworkData.frameWidth && this.frameHeight == cloudNetworkData.frameHeight;
    }
}
