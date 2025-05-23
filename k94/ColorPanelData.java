package k94;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uv4.as;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ1\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\t\u0010\f\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012\u00a8\u0006\u001d"}, d2 = {"Lk94/b;", "", "", "slotId", "Lqu4/c;", "colorInfo", "Luv4/as;", "colorConfig", "panelIndex", "a", "", "toString", "hashCode", "other", "", "equals", "I", "f", "()I", "b", "Lqu4/c;", "d", "()Lqu4/c;", "c", "Luv4/as;", "()Luv4/as;", "e", "<init>", "(ILqu4/c;Luv4/as;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: k94.b, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class ColorPanelData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int slotId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final qu4.c colorInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final as colorConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int panelIndex;

    public ColorPanelData(int i3, qu4.c colorInfo, as colorConfig, int i16) {
        Intrinsics.checkNotNullParameter(colorInfo, "colorInfo");
        Intrinsics.checkNotNullParameter(colorConfig, "colorConfig");
        this.slotId = i3;
        this.colorInfo = colorInfo;
        this.colorConfig = colorConfig;
        this.panelIndex = i16;
    }

    public final ColorPanelData a(int slotId, qu4.c colorInfo, as colorConfig, int panelIndex) {
        Intrinsics.checkNotNullParameter(colorInfo, "colorInfo");
        Intrinsics.checkNotNullParameter(colorConfig, "colorConfig");
        return new ColorPanelData(slotId, colorInfo, colorConfig, panelIndex);
    }

    /* renamed from: c, reason: from getter */
    public final as getColorConfig() {
        return this.colorConfig;
    }

    /* renamed from: d, reason: from getter */
    public final qu4.c getColorInfo() {
        return this.colorInfo;
    }

    /* renamed from: e, reason: from getter */
    public final int getPanelIndex() {
        return this.panelIndex;
    }

    /* renamed from: f, reason: from getter */
    public final int getSlotId() {
        return this.slotId;
    }

    public int hashCode() {
        return (((((this.slotId * 31) + this.colorInfo.hashCode()) * 31) + this.colorConfig.hashCode()) * 31) + this.panelIndex;
    }

    public String toString() {
        return "ColorPanelData(slotId=" + this.slotId + ", colorInfo=" + this.colorInfo + ", colorConfig=" + this.colorConfig + ", panelIndex=" + this.panelIndex + ")";
    }

    public static /* synthetic */ ColorPanelData b(ColorPanelData colorPanelData, int i3, qu4.c cVar, as asVar, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = colorPanelData.slotId;
        }
        if ((i17 & 2) != 0) {
            cVar = colorPanelData.colorInfo;
        }
        if ((i17 & 4) != 0) {
            asVar = colorPanelData.colorConfig;
        }
        if ((i17 & 8) != 0) {
            i16 = colorPanelData.panelIndex;
        }
        return colorPanelData.a(i3, cVar, asVar, i16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ColorPanelData)) {
            return false;
        }
        ColorPanelData colorPanelData = (ColorPanelData) other;
        return this.slotId == colorPanelData.slotId && Intrinsics.areEqual(this.colorInfo, colorPanelData.colorInfo) && Intrinsics.areEqual(this.colorConfig, colorPanelData.colorConfig) && this.panelIndex == colorPanelData.panelIndex;
    }
}
