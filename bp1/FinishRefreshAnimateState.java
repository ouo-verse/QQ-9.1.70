package bp1;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001d\u001a\u00020\t\u0012\b\b\u0002\u0010\"\u001a\u00020\u0005\u00a2\u0006\u0004\b#\u0010$J\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001d\u001a\u00020\t8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u000b\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\"\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u0018\u0010 \"\u0004\b\u0011\u0010!\u00a8\u0006%"}, d2 = {"Lbp1/e;", "Lbp1/a;", "Lbp1/w;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "name", "", "c", UserInfo.SEX_FEMALE, "f", "()F", tl.h.F, "(F)V", "offset", "d", "Z", "()Z", "a", "(Z)V", "isDisplayLoadingView", "e", "I", "()I", "(I)V", "loadingDistance", "<init>", "(Ljava/lang/String;FZI)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: bp1.e, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class FinishRefreshAnimateState extends a implements w {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float offset;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isDisplayLoadingView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int loadingDistance;

    public FinishRefreshAnimateState() {
        this(null, 0.0f, false, 0, 15, null);
    }

    @Override // bp1.w
    public void a(boolean z16) {
        this.isDisplayLoadingView = z16;
    }

    @Override // bp1.w
    /* renamed from: b, reason: from getter */
    public boolean getIsDisplayLoadingView() {
        return this.isDisplayLoadingView;
    }

    @Override // bp1.w
    public void c(int i3) {
        this.loadingDistance = i3;
    }

    @Override // bp1.w
    /* renamed from: d, reason: from getter */
    public int getLoadingDistance() {
        return this.loadingDistance;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FinishRefreshAnimateState)) {
            return false;
        }
        FinishRefreshAnimateState finishRefreshAnimateState = (FinishRefreshAnimateState) other;
        if (Intrinsics.areEqual(getName(), finishRefreshAnimateState.getName()) && Float.compare(getOffset(), finishRefreshAnimateState.getOffset()) == 0 && getIsDisplayLoadingView() == finishRefreshAnimateState.getIsDisplayLoadingView() && getLoadingDistance() == finishRefreshAnimateState.getLoadingDistance()) {
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
        int hashCode = ((getName().hashCode() * 31) + Float.floatToIntBits(getOffset())) * 31;
        boolean isDisplayLoadingView = getIsDisplayLoadingView();
        int i3 = isDisplayLoadingView;
        if (isDisplayLoadingView) {
            i3 = 1;
        }
        return ((hashCode + i3) * 31) + getLoadingDistance();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public String getName() {
        return this.name;
    }

    @NotNull
    public String toString() {
        return "FinishRefreshAnimateState(name=" + getName() + ", offset=" + getOffset() + ", isDisplayLoadingView=" + getIsDisplayLoadingView() + ", loadingDistance=" + getLoadingDistance() + ")";
    }

    public /* synthetic */ FinishRefreshAnimateState(String str, float f16, boolean z16, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "FinishRefreshAnimate" : str, (i16 & 2) != 0 ? 0.0f : f16, (i16 & 4) != 0 ? false : z16, (i16 & 8) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FinishRefreshAnimateState(@NotNull String name, float f16, boolean z16, int i3) {
        super(null);
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.offset = f16;
        this.isDisplayLoadingView = z16;
        this.loadingDistance = i3;
    }
}
