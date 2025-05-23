package bp1;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001d\u001a\u00020\b\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000e\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lbp1/n;", "Lbp1/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "name", "", "c", UserInfo.SEX_FEMALE, "f", "()F", tl.h.F, "(F)V", "offset", "d", "Z", "i", "()Z", "k", "(Z)V", "extraStageCollapsed", "<init>", "(Ljava/lang/String;FZ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: bp1.n, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class HeaderCollapsedState extends a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float offset;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean extraStageCollapsed;

    public HeaderCollapsedState() {
        this(null, 0.0f, false, 7, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HeaderCollapsedState)) {
            return false;
        }
        HeaderCollapsedState headerCollapsedState = (HeaderCollapsedState) other;
        if (Intrinsics.areEqual(getName(), headerCollapsedState.getName()) && Float.compare(getOffset(), headerCollapsedState.getOffset()) == 0 && this.extraStageCollapsed == headerCollapsedState.extraStageCollapsed) {
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

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((getName().hashCode() * 31) + Float.floatToIntBits(getOffset())) * 31;
        boolean z16 = this.extraStageCollapsed;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getExtraStageCollapsed() {
        return this.extraStageCollapsed;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public String getName() {
        return this.name;
    }

    public final void k(boolean z16) {
        this.extraStageCollapsed = z16;
    }

    @NotNull
    public String toString() {
        return "HeaderCollapsedState(name=" + getName() + ", offset=" + getOffset() + ", extraStageCollapsed=" + this.extraStageCollapsed + ")";
    }

    public /* synthetic */ HeaderCollapsedState(String str, float f16, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "HeaderCollapsed" : str, (i3 & 2) != 0 ? 0.0f : f16, (i3 & 4) != 0 ? false : z16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderCollapsedState(@NotNull String name, float f16, boolean z16) {
        super(null);
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.offset = f16;
        this.extraStageCollapsed = z16;
    }
}
