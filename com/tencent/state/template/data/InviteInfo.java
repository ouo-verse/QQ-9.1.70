package com.tencent.state.template.data;

import com.tencent.mobileqq.vas.banner.c;
import com.tencent.state.data.UserCommon;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/state/template/data/InviteInfo;", "", "billNo", "", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/data/UserCommon;", "expireTs", "", "motionName", "(Ljava/lang/String;Lcom/tencent/state/data/UserCommon;JLjava/lang/String;)V", "getBillNo", "()Ljava/lang/String;", "getExpireTs", "()J", "getMotionName", "getUser", "()Lcom/tencent/state/data/UserCommon;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class InviteInfo {
    private final String billNo;
    private final long expireTs;
    private final String motionName;
    private final UserCommon user;

    public InviteInfo(String billNo, UserCommon user, long j3, String motionName) {
        Intrinsics.checkNotNullParameter(billNo, "billNo");
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(motionName, "motionName");
        this.billNo = billNo;
        this.user = user;
        this.expireTs = j3;
        this.motionName = motionName;
    }

    /* renamed from: component1, reason: from getter */
    public final String getBillNo() {
        return this.billNo;
    }

    /* renamed from: component2, reason: from getter */
    public final UserCommon getUser() {
        return this.user;
    }

    /* renamed from: component3, reason: from getter */
    public final long getExpireTs() {
        return this.expireTs;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMotionName() {
        return this.motionName;
    }

    public final InviteInfo copy(String billNo, UserCommon user, long expireTs, String motionName) {
        Intrinsics.checkNotNullParameter(billNo, "billNo");
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(motionName, "motionName");
        return new InviteInfo(billNo, user, expireTs, motionName);
    }

    public final String getBillNo() {
        return this.billNo;
    }

    public final long getExpireTs() {
        return this.expireTs;
    }

    public final String getMotionName() {
        return this.motionName;
    }

    public final UserCommon getUser() {
        return this.user;
    }

    public int hashCode() {
        String str = this.billNo;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        UserCommon userCommon = this.user;
        int hashCode2 = (((hashCode + (userCommon != null ? userCommon.hashCode() : 0)) * 31) + c.a(this.expireTs)) * 31;
        String str2 = this.motionName;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "InviteInfo(billNo=" + this.billNo + ", user=" + this.user + ", expireTs=" + this.expireTs + ", motionName=" + this.motionName + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InviteInfo)) {
            return false;
        }
        InviteInfo inviteInfo = (InviteInfo) other;
        return Intrinsics.areEqual(this.billNo, inviteInfo.billNo) && Intrinsics.areEqual(this.user, inviteInfo.user) && this.expireTs == inviteInfo.expireTs && Intrinsics.areEqual(this.motionName, inviteInfo.motionName);
    }

    public static /* synthetic */ InviteInfo copy$default(InviteInfo inviteInfo, String str, UserCommon userCommon, long j3, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = inviteInfo.billNo;
        }
        if ((i3 & 2) != 0) {
            userCommon = inviteInfo.user;
        }
        UserCommon userCommon2 = userCommon;
        if ((i3 & 4) != 0) {
            j3 = inviteInfo.expireTs;
        }
        long j16 = j3;
        if ((i3 & 8) != 0) {
            str2 = inviteInfo.motionName;
        }
        return inviteInfo.copy(str, userCommon2, j16, str2);
    }
}
