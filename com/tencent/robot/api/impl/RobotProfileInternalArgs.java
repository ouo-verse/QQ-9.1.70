package com.tencent.robot.api.impl;

import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback;
import com.tencent.qqnt.kernel.nativeinterface.RobotProfileFetchType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u000e\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/robot/api/impl/q;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "robotUin", "b", "e", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotProfileFetchType;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotProfileFetchType;", "()Lcom/tencent/qqnt/kernel/nativeinterface/RobotProfileFetchType;", "fetchType", "f", "(Ljava/lang/String;)V", "bkn", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupRobotProfileCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupRobotProfileCallback;", "()Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupRobotProfileCallback;", "callback", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/RobotProfileFetchType;Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupRobotProfileCallback;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.api.impl.q, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class RobotProfileInternalArgs {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String robotUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String troopUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final RobotProfileFetchType fetchType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String bkn;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final IGetGroupRobotProfileCallback callback;

    public RobotProfileInternalArgs(@NotNull String robotUin, @Nullable String str, @NotNull RobotProfileFetchType fetchType, @Nullable String str2, @Nullable IGetGroupRobotProfileCallback iGetGroupRobotProfileCallback) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(fetchType, "fetchType");
        this.robotUin = robotUin;
        this.troopUin = str;
        this.fetchType = fetchType;
        this.bkn = str2;
        this.callback = iGetGroupRobotProfileCallback;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getBkn() {
        return this.bkn;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final IGetGroupRobotProfileCallback getCallback() {
        return this.callback;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final RobotProfileFetchType getFetchType() {
        return this.fetchType;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getRobotUin() {
        return this.robotUin;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getTroopUin() {
        return this.troopUin;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RobotProfileInternalArgs)) {
            return false;
        }
        RobotProfileInternalArgs robotProfileInternalArgs = (RobotProfileInternalArgs) other;
        if (Intrinsics.areEqual(this.robotUin, robotProfileInternalArgs.robotUin) && Intrinsics.areEqual(this.troopUin, robotProfileInternalArgs.troopUin) && this.fetchType == robotProfileInternalArgs.fetchType && Intrinsics.areEqual(this.bkn, robotProfileInternalArgs.bkn) && Intrinsics.areEqual(this.callback, robotProfileInternalArgs.callback)) {
            return true;
        }
        return false;
    }

    public final void f(@Nullable String str) {
        this.bkn = str;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = this.robotUin.hashCode() * 31;
        String str = this.troopUin;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int hashCode4 = (((hashCode3 + hashCode) * 31) + this.fetchType.hashCode()) * 31;
        String str2 = this.bkn;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i16 = (hashCode4 + hashCode2) * 31;
        IGetGroupRobotProfileCallback iGetGroupRobotProfileCallback = this.callback;
        if (iGetGroupRobotProfileCallback != null) {
            i3 = iGetGroupRobotProfileCallback.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "RobotProfileInternalArgs(robotUin=" + this.robotUin + ", troopUin=" + this.troopUin + ", fetchType=" + this.fetchType + ", bkn=" + this.bkn + ", callback=" + this.callback + ")";
    }
}
