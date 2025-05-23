package cl0;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcl0/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "enablePortal", "Z", "a", "()Z", "recordFrameCount", "I", "b", "()I", "<init>", "(ZI)V", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: cl0.j, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class PortalSceneMonitorConfig {

    @SerializedName("enablePortal")
    private final boolean enablePortal;

    @SerializedName("recordFrameCount")
    private final int recordFrameCount;

    public PortalSceneMonitorConfig() {
        this(false, 0 == true ? 1 : 0, 3, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getEnablePortal() {
        return this.enablePortal;
    }

    /* renamed from: b, reason: from getter */
    public final int getRecordFrameCount() {
        return this.recordFrameCount;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof PortalSceneMonitorConfig) {
                PortalSceneMonitorConfig portalSceneMonitorConfig = (PortalSceneMonitorConfig) other;
                if (this.enablePortal != portalSceneMonitorConfig.enablePortal || this.recordFrameCount != portalSceneMonitorConfig.recordFrameCount) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.enablePortal;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (r06 * 31) + this.recordFrameCount;
    }

    @NotNull
    public String toString() {
        return "PortalSceneMonitorConfig(enablePortal=" + this.enablePortal + ", recordFrameCount=" + this.recordFrameCount + ")";
    }

    public PortalSceneMonitorConfig(boolean z16, int i3) {
        this.enablePortal = z16;
        this.recordFrameCount = i3;
    }

    public /* synthetic */ PortalSceneMonitorConfig(boolean z16, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? false : z16, (i16 & 2) != 0 ? 50 : i3);
    }
}
