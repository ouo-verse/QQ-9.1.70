package li3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u000e\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lli3/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "uin", "b", "I", "()I", "businessId", "", "J", "()J", "sessionId", "<init>", "(Ljava/lang/String;IJ)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: li3.a, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class BubbleReportData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String uin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int businessId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long sessionId;

    public BubbleReportData(@NotNull String uin, int i3, long j3) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uin = uin;
        this.businessId = i3;
        this.sessionId = j3;
    }

    /* renamed from: a, reason: from getter */
    public final int getBusinessId() {
        return this.businessId;
    }

    /* renamed from: b, reason: from getter */
    public final long getSessionId() {
        return this.sessionId;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BubbleReportData)) {
            return false;
        }
        BubbleReportData bubbleReportData = (BubbleReportData) other;
        if (Intrinsics.areEqual(this.uin, bubbleReportData.uin) && this.businessId == bubbleReportData.businessId && this.sessionId == bubbleReportData.sessionId) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.uin.hashCode() * 31) + this.businessId) * 31) + androidx.fragment.app.a.a(this.sessionId);
    }

    @NotNull
    public String toString() {
        return "BubbleReportData(uin=" + this.uin + ", businessId=" + this.businessId + ", sessionId=" + this.sessionId + ')';
    }
}
