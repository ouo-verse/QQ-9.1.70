package bp1;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0019\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\tBM\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0010\u0012\b\b\u0002\u0010\"\u001a\u00020\u0007\u0012\b\b\u0002\u0010#\u001a\u00020\u0007\u0012\b\b\u0002\u0010&\u001a\u00020\u0004\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\t\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010\u001b\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\"\u0010\"\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010#\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b\u001c\u0010!R\"\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\n\u001a\u0004\b%\u0010\f\"\u0004\b$\u0010\u000e\u00a8\u0006)"}, d2 = {"Lbp1/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getStateType", "()I", "i", "(I)V", "stateType", "", "b", UserInfo.SEX_FEMALE, "()F", tl.h.F, "(F)V", "offset", "c", "d", "collapsingRemainDistance", "getCollapsingRatio", "collapsingRatio", "e", "Z", "getExtraStageCollapsed", "()Z", "f", "(Z)V", "extraStageCollapsed", "isDisplayLoadingView", "g", "getLoadingDistance", "loadingDistance", "<init>", "(IFFFZZI)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: bp1.b, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class SimpleBehaviorState {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int stateType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private float offset;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private float collapsingRemainDistance;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private float collapsingRatio;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean extraStageCollapsed;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isDisplayLoadingView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private int loadingDistance;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lbp1/b$a;", "", "", "stateType", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: bp1.b$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a(int stateType) {
            switch (stateType) {
                case 0:
                    return "NormalState";
                case 1:
                    return "HeaderCollapsingState";
                case 2:
                    return "HeaderCollapsedState";
                case 3:
                    return "CollapsingAnimateState";
                case 4:
                    return "PullDownRefreshingState";
                case 5:
                    return "RefreshAnimateState";
                case 6:
                    return "StartRefreshAnimateState";
                case 7:
                    return "RestorePullRefreshAnimateState";
                default:
                    return "Unknown";
            }
        }

        Companion() {
        }
    }

    public SimpleBehaviorState() {
        this(0, 0.0f, 0.0f, 0.0f, false, false, 0, 127, null);
    }

    /* renamed from: a, reason: from getter */
    public final float getCollapsingRemainDistance() {
        return this.collapsingRemainDistance;
    }

    /* renamed from: b, reason: from getter */
    public final float getOffset() {
        return this.offset;
    }

    public final void c(float f16) {
        this.collapsingRatio = f16;
    }

    public final void d(float f16) {
        this.collapsingRemainDistance = f16;
    }

    public final void e(boolean z16) {
        this.isDisplayLoadingView = z16;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SimpleBehaviorState)) {
            return false;
        }
        SimpleBehaviorState simpleBehaviorState = (SimpleBehaviorState) other;
        if (this.stateType == simpleBehaviorState.stateType && Float.compare(this.offset, simpleBehaviorState.offset) == 0 && Float.compare(this.collapsingRemainDistance, simpleBehaviorState.collapsingRemainDistance) == 0 && Float.compare(this.collapsingRatio, simpleBehaviorState.collapsingRatio) == 0 && this.extraStageCollapsed == simpleBehaviorState.extraStageCollapsed && this.isDisplayLoadingView == simpleBehaviorState.isDisplayLoadingView && this.loadingDistance == simpleBehaviorState.loadingDistance) {
            return true;
        }
        return false;
    }

    public final void f(boolean z16) {
        this.extraStageCollapsed = z16;
    }

    public final void g(int i3) {
        this.loadingDistance = i3;
    }

    public final void h(float f16) {
        this.offset = f16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int floatToIntBits = ((((((this.stateType * 31) + Float.floatToIntBits(this.offset)) * 31) + Float.floatToIntBits(this.collapsingRemainDistance)) * 31) + Float.floatToIntBits(this.collapsingRatio)) * 31;
        boolean z16 = this.extraStageCollapsed;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (floatToIntBits + i16) * 31;
        boolean z17 = this.isDisplayLoadingView;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((i17 + i3) * 31) + this.loadingDistance;
    }

    public final void i(int i3) {
        this.stateType = i3;
    }

    @NotNull
    public String toString() {
        return "SimpleBehaviorState(stateType=" + INSTANCE.a(this.stateType) + ", offset=" + this.offset + ", collapsingRemainDistance=" + this.collapsingRemainDistance + ", collapsingRatio=" + this.collapsingRatio + ", extraStageCollapsed=" + this.extraStageCollapsed + ", isDisplayLoadingView=" + this.isDisplayLoadingView + ", loadingDistance=" + this.loadingDistance + ")";
    }

    public SimpleBehaviorState(int i3, float f16, float f17, float f18, boolean z16, boolean z17, int i16) {
        this.stateType = i3;
        this.offset = f16;
        this.collapsingRemainDistance = f17;
        this.collapsingRatio = f18;
        this.extraStageCollapsed = z16;
        this.isDisplayLoadingView = z17;
        this.loadingDistance = i16;
    }

    public /* synthetic */ SimpleBehaviorState(int i3, float f16, float f17, float f18, boolean z16, boolean z17, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? 0.0f : f16, (i17 & 4) != 0 ? 0.0f : f17, (i17 & 8) == 0 ? f18 : 0.0f, (i17 & 16) != 0 ? false : z16, (i17 & 32) != 0 ? false : z17, (i17 & 64) != 0 ? 0 : i16);
    }
}
