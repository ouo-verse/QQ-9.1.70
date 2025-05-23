package com.tencent.robot.aio.share;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u000e\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/robot/aio/share/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "c", "()Z", "isSuccess", "b", "I", "()I", "errCode", "Ljava/lang/String;", "()Ljava/lang/String;", "errMsg", "<init>", "(ZILjava/lang/String;)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.aio.share.d, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class ShareStatus {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSuccess;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int errCode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String errMsg;

    public ShareStatus(boolean z16, int i3, @NotNull String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this.isSuccess = z16;
        this.errCode = i3;
        this.errMsg = errMsg;
    }

    /* renamed from: a, reason: from getter */
    public final int getErrCode() {
        return this.errCode;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getErrMsg() {
        return this.errMsg;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShareStatus)) {
            return false;
        }
        ShareStatus shareStatus = (ShareStatus) other;
        if (this.isSuccess == shareStatus.isSuccess && this.errCode == shareStatus.errCode && Intrinsics.areEqual(this.errMsg, shareStatus.errMsg)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.isSuccess;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((r06 * 31) + this.errCode) * 31) + this.errMsg.hashCode();
    }

    @NotNull
    public String toString() {
        return "ShareStatus(isSuccess=" + this.isSuccess + ", errCode=" + this.errCode + ", errMsg=" + this.errMsg + ")";
    }

    public /* synthetic */ ShareStatus(boolean z16, int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? "" : str);
    }
}
