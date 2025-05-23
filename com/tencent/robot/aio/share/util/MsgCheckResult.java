package com.tencent.robot.aio.share.util;

import com.tencent.robot.aio.share.RobotSessionShareInfo;
import com.tencent.robot.aio.share.ShareStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0013\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/robot/aio/share/util/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/robot/aio/share/util/RobotMsgCheckResult;", "a", "Lcom/tencent/robot/aio/share/util/RobotMsgCheckResult;", "b", "()Lcom/tencent/robot/aio/share/util/RobotMsgCheckResult;", "robotMsgCheckResult", "Ljava/lang/String;", "()Ljava/lang/String;", "checkMsg", "Lcom/tencent/robot/aio/share/d;", "c", "Lcom/tencent/robot/aio/share/d;", "getShareStatus", "()Lcom/tencent/robot/aio/share/d;", "shareStatus", "Lcom/tencent/robot/aio/share/RobotSessionShareInfo;", "d", "Lcom/tencent/robot/aio/share/RobotSessionShareInfo;", "()Lcom/tencent/robot/aio/share/RobotSessionShareInfo;", "robotSessionShareInfo", "<init>", "(Lcom/tencent/robot/aio/share/util/RobotMsgCheckResult;Ljava/lang/String;Lcom/tencent/robot/aio/share/d;Lcom/tencent/robot/aio/share/RobotSessionShareInfo;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.aio.share.util.b, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class MsgCheckResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final RobotMsgCheckResult robotMsgCheckResult;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String checkMsg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final ShareStatus shareStatus;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final RobotSessionShareInfo robotSessionShareInfo;

    public MsgCheckResult(@NotNull RobotMsgCheckResult robotMsgCheckResult, @NotNull String checkMsg, @Nullable ShareStatus shareStatus, @Nullable RobotSessionShareInfo robotSessionShareInfo) {
        Intrinsics.checkNotNullParameter(robotMsgCheckResult, "robotMsgCheckResult");
        Intrinsics.checkNotNullParameter(checkMsg, "checkMsg");
        this.robotMsgCheckResult = robotMsgCheckResult;
        this.checkMsg = checkMsg;
        this.shareStatus = shareStatus;
        this.robotSessionShareInfo = robotSessionShareInfo;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getCheckMsg() {
        return this.checkMsg;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final RobotMsgCheckResult getRobotMsgCheckResult() {
        return this.robotMsgCheckResult;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final RobotSessionShareInfo getRobotSessionShareInfo() {
        return this.robotSessionShareInfo;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MsgCheckResult)) {
            return false;
        }
        MsgCheckResult msgCheckResult = (MsgCheckResult) other;
        if (this.robotMsgCheckResult == msgCheckResult.robotMsgCheckResult && Intrinsics.areEqual(this.checkMsg, msgCheckResult.checkMsg) && Intrinsics.areEqual(this.shareStatus, msgCheckResult.shareStatus) && Intrinsics.areEqual(this.robotSessionShareInfo, msgCheckResult.robotSessionShareInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.robotMsgCheckResult.hashCode() * 31) + this.checkMsg.hashCode()) * 31;
        ShareStatus shareStatus = this.shareStatus;
        int i3 = 0;
        if (shareStatus == null) {
            hashCode = 0;
        } else {
            hashCode = shareStatus.hashCode();
        }
        int i16 = (hashCode2 + hashCode) * 31;
        RobotSessionShareInfo robotSessionShareInfo = this.robotSessionShareInfo;
        if (robotSessionShareInfo != null) {
            i3 = robotSessionShareInfo.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "MsgCheckResult(robotMsgCheckResult=" + this.robotMsgCheckResult + ", checkMsg=" + this.checkMsg + ", shareStatus=" + this.shareStatus + ", robotSessionShareInfo=" + this.robotSessionShareInfo + ")";
    }
}
