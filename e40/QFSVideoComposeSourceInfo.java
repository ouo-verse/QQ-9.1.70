package e40;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0015\u001a\u0004\b\t\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Le40/q;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "endTimeMs", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "posterId", "c", "feedId", "", "J", "()J", WadlProxyConsts.CREATE_TIME, "<init>", "(ILjava/lang/String;Ljava/lang/String;J)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: e40.q, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class QFSVideoComposeSourceInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int endTimeMs;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String posterId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String feedId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long createTime;

    public QFSVideoComposeSourceInfo(int i3, @NotNull String posterId, @NotNull String feedId, long j3) {
        Intrinsics.checkNotNullParameter(posterId, "posterId");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        this.endTimeMs = i3;
        this.posterId = posterId;
        this.feedId = feedId;
        this.createTime = j3;
    }

    /* renamed from: a, reason: from getter */
    public final long getCreateTime() {
        return this.createTime;
    }

    /* renamed from: b, reason: from getter */
    public final int getEndTimeMs() {
        return this.endTimeMs;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getPosterId() {
        return this.posterId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QFSVideoComposeSourceInfo)) {
            return false;
        }
        QFSVideoComposeSourceInfo qFSVideoComposeSourceInfo = (QFSVideoComposeSourceInfo) other;
        if (this.endTimeMs == qFSVideoComposeSourceInfo.endTimeMs && Intrinsics.areEqual(this.posterId, qFSVideoComposeSourceInfo.posterId) && Intrinsics.areEqual(this.feedId, qFSVideoComposeSourceInfo.feedId) && this.createTime == qFSVideoComposeSourceInfo.createTime) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.endTimeMs * 31) + this.posterId.hashCode()) * 31) + this.feedId.hashCode()) * 31) + androidx.fragment.app.a.a(this.createTime);
    }

    @NotNull
    public String toString() {
        return "QFSVideoComposeSourceInfo(endTimeMs=" + this.endTimeMs + ", posterId=" + this.posterId + ", feedId=" + this.feedId + ", createTime=" + this.createTime + ")";
    }
}
