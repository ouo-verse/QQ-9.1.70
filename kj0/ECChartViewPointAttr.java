package kj0;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\t\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0017\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lkj0/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "c", "()Z", "setShouldDraw", "(Z)V", "shouldDraw", "", "b", UserInfo.SEX_FEMALE, "()F", "setInnerCircleRadius", "(F)V", "innerCircleRadius", "setOuterCircleRadius", "outerCircleRadius", "<init>", "(ZFF)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: kj0.c, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class ECChartViewPointAttr {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean shouldDraw;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private float innerCircleRadius;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private float outerCircleRadius;

    public ECChartViewPointAttr() {
        this(false, 0.0f, 0.0f, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final float getInnerCircleRadius() {
        return this.innerCircleRadius;
    }

    /* renamed from: b, reason: from getter */
    public final float getOuterCircleRadius() {
        return this.outerCircleRadius;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getShouldDraw() {
        return this.shouldDraw;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.shouldDraw;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((r06 * 31) + Float.floatToIntBits(this.innerCircleRadius)) * 31) + Float.floatToIntBits(this.outerCircleRadius);
    }

    public String toString() {
        return "ECChartViewPointAttr(shouldDraw=" + this.shouldDraw + ", innerCircleRadius=" + this.innerCircleRadius + ", outerCircleRadius=" + this.outerCircleRadius + ")";
    }

    public ECChartViewPointAttr(boolean z16, float f16, float f17) {
        this.shouldDraw = z16;
        this.innerCircleRadius = f16;
        this.outerCircleRadius = f17;
    }

    public /* synthetic */ ECChartViewPointAttr(boolean z16, float f16, float f17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? 0.0f : f16, (i3 & 4) != 0 ? 0.0f : f17);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECChartViewPointAttr)) {
            return false;
        }
        ECChartViewPointAttr eCChartViewPointAttr = (ECChartViewPointAttr) other;
        return this.shouldDraw == eCChartViewPointAttr.shouldDraw && Float.compare(this.innerCircleRadius, eCChartViewPointAttr.innerCircleRadius) == 0 && Float.compare(this.outerCircleRadius, eCChartViewPointAttr.outerCircleRadius) == 0;
    }
}
