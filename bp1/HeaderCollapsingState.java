package bp1;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u000f\u0012\b\b\u0002\u0010!\u001a\u00020\u000f\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000e\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\"\u0010\u001e\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\"\u0010!\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0015\u00a8\u0006$"}, d2 = {"Lbp1/o;", "Lbp1/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "name", "", "c", UserInfo.SEX_FEMALE, "f", "()F", tl.h.F, "(F)V", "offset", "d", "k", DomainData.DOMAIN_NAME, "remainDistance", "e", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "ratio", "l", "o", "startCollapsingOffset", "<init>", "(Ljava/lang/String;FFFF)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: bp1.o, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class HeaderCollapsingState extends a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float offset;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private float remainDistance;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private float ratio;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private float startCollapsingOffset;

    public HeaderCollapsingState() {
        this(null, 0.0f, 0.0f, 0.0f, 0.0f, 31, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HeaderCollapsingState)) {
            return false;
        }
        HeaderCollapsingState headerCollapsingState = (HeaderCollapsingState) other;
        if (Intrinsics.areEqual(getName(), headerCollapsingState.getName()) && Float.compare(getOffset(), headerCollapsingState.getOffset()) == 0 && Float.compare(this.remainDistance, headerCollapsingState.remainDistance) == 0 && Float.compare(this.ratio, headerCollapsingState.ratio) == 0 && Float.compare(this.startCollapsingOffset, headerCollapsingState.startCollapsingOffset) == 0) {
            return true;
        }
        return false;
    }

    @Override // bp1.a
    /* renamed from: f, reason: from getter */
    public float getOffset() {
        return this.offset;
    }

    @Override // bp1.a
    public void h(float f16) {
        this.offset = f16;
    }

    public int hashCode() {
        return (((((((getName().hashCode() * 31) + Float.floatToIntBits(getOffset())) * 31) + Float.floatToIntBits(this.remainDistance)) * 31) + Float.floatToIntBits(this.ratio)) * 31) + Float.floatToIntBits(this.startCollapsingOffset);
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public String getName() {
        return this.name;
    }

    /* renamed from: j, reason: from getter */
    public final float getRatio() {
        return this.ratio;
    }

    /* renamed from: k, reason: from getter */
    public final float getRemainDistance() {
        return this.remainDistance;
    }

    /* renamed from: l, reason: from getter */
    public final float getStartCollapsingOffset() {
        return this.startCollapsingOffset;
    }

    public final void m(float f16) {
        this.ratio = f16;
    }

    public final void n(float f16) {
        this.remainDistance = f16;
    }

    public final void o(float f16) {
        this.startCollapsingOffset = f16;
    }

    @NotNull
    public String toString() {
        return "HeaderCollapsingState(name=" + getName() + ", offset=" + getOffset() + ", remainDistance=" + this.remainDistance + ", ratio=" + this.ratio + ", startCollapsingOffset=" + this.startCollapsingOffset + ")";
    }

    public /* synthetic */ HeaderCollapsingState(String str, float f16, float f17, float f18, float f19, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "HeaderCollapsing" : str, (i3 & 2) != 0 ? 0.0f : f16, (i3 & 4) != 0 ? 0.0f : f17, (i3 & 8) != 0 ? 0.0f : f18, (i3 & 16) == 0 ? f19 : 0.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderCollapsingState(@NotNull String name, float f16, float f17, float f18, float f19) {
        super(null);
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.offset = f16;
        this.remainDistance = f17;
        this.ratio = f18;
        this.startCollapsingOffset = f19;
    }
}
