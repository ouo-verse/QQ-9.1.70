package com.tencent.robot.adelie.reddot;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/robot/adelie/reddot/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "revokeId", "", "J", "c", "()J", "robotUin", "redDotText", "d", "I", "getBizType", "()I", "bizType", "<init>", "(Ljava/lang/String;JLjava/lang/String;I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.adelie.reddot.a, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class RedDotInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String revokeId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long robotUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String redDotText;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int bizType;

    public RedDotInfo(@NotNull String revokeId, long j3, @NotNull String redDotText, int i3) {
        Intrinsics.checkNotNullParameter(revokeId, "revokeId");
        Intrinsics.checkNotNullParameter(redDotText, "redDotText");
        this.revokeId = revokeId;
        this.robotUin = j3;
        this.redDotText = redDotText;
        this.bizType = i3;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getRedDotText() {
        return this.redDotText;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getRevokeId() {
        return this.revokeId;
    }

    /* renamed from: c, reason: from getter */
    public final long getRobotUin() {
        return this.robotUin;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RedDotInfo)) {
            return false;
        }
        RedDotInfo redDotInfo = (RedDotInfo) other;
        if (Intrinsics.areEqual(this.revokeId, redDotInfo.revokeId) && this.robotUin == redDotInfo.robotUin && Intrinsics.areEqual(this.redDotText, redDotInfo.redDotText) && this.bizType == redDotInfo.bizType) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.revokeId.hashCode() * 31) + androidx.fragment.app.a.a(this.robotUin)) * 31) + this.redDotText.hashCode()) * 31) + this.bizType;
    }

    @NotNull
    public String toString() {
        return "RedDotInfo(revokeId=" + this.revokeId + ", robotUin=" + this.robotUin + ", redDotText=" + this.redDotText + ", bizType=" + this.bizType + ")";
    }
}
