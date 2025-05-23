package ba4;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qu4.l;
import qu4.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\t\u0010\u0012R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u0010\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lba4/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "d", "()Z", "e", "(Z)V", "isSelected", "b", "I", "()I", "colorIndex", "Lqu4/p;", "c", "Lqu4/p;", "()Lqu4/p;", "singleColor", "Lqu4/l;", "Lqu4/l;", "()Lqu4/l;", "gradientColor", "<init>", "(ZILqu4/p;Lqu4/l;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ba4.c, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class ColorData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isSelected;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int colorIndex;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final p singleColor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final l gradientColor;

    public ColorData(boolean z16, int i3, p pVar, l lVar) {
        this.isSelected = z16;
        this.colorIndex = i3;
        this.singleColor = pVar;
        this.gradientColor = lVar;
    }

    /* renamed from: a, reason: from getter */
    public final int getColorIndex() {
        return this.colorIndex;
    }

    /* renamed from: b, reason: from getter */
    public final l getGradientColor() {
        return this.gradientColor;
    }

    /* renamed from: c, reason: from getter */
    public final p getSingleColor() {
        return this.singleColor;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final void e(boolean z16) {
        this.isSelected = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z16 = this.isSelected;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = ((r06 * 31) + this.colorIndex) * 31;
        p pVar = this.singleColor;
        int hashCode = (i3 + (pVar == null ? 0 : pVar.hashCode())) * 31;
        l lVar = this.gradientColor;
        return hashCode + (lVar != null ? lVar.hashCode() : 0);
    }

    public String toString() {
        return "ColorData(isSelected=" + this.isSelected + ", colorIndex=" + this.colorIndex + ", singleColor=" + this.singleColor + ", gradientColor=" + this.gradientColor + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ColorData)) {
            return false;
        }
        ColorData colorData = (ColorData) other;
        return this.isSelected == colorData.isSelected && this.colorIndex == colorData.colorIndex && Intrinsics.areEqual(this.singleColor, colorData.singleColor) && Intrinsics.areEqual(this.gradientColor, colorData.gradientColor);
    }
}
