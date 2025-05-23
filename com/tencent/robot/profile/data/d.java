package com.tencent.robot.profile.data;

import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.RobotBaseInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u0000 \r2\u00020\u0001:\u0001\tB9\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0018\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001a\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0013\u001a\u0004\b\t\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\"\u0010\u001d\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0017\u00a8\u0006 "}, d2 = {"Lcom/tencent/robot/profile/data/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "f", "(I)V", "robotMemberShip", "c", "setUserMemberShip", "userMemberShip", "Z", "d", "()Z", "e", "(Z)V", IProfileProtocolConst.PARAM_IS_FRIEND, "setAllowAdd2Group", "allowAdd2Group", "getAllowAdd2C2C", "setAllowAdd2C2C", "allowAdd2C2C", "<init>", "(IIZZZ)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final /* data */ class d {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int robotMemberShip;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int userMemberShip;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isFriend;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean allowAdd2Group;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean allowAdd2C2C;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/robot/profile/data/d$a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", "Lcom/tencent/robot/profile/data/d;", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.profile.data.d$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final d a(@NotNull GroupRobotProfile robotProfile) {
            Intrinsics.checkNotNullParameter(robotProfile, "robotProfile");
            int i3 = robotProfile.robotMembership;
            int i16 = robotProfile.userMembership;
            boolean z16 = robotProfile.isFriend;
            RobotBaseInfo robotBaseInfo = robotProfile.robotData;
            return new d(i3, i16, z16, robotBaseInfo.allowedAddGroup, robotBaseInfo.allowedAddC2C);
        }

        Companion() {
        }
    }

    public d() {
        this(0, 0, false, false, false, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getAllowAdd2Group() {
        return this.allowAdd2Group;
    }

    /* renamed from: b, reason: from getter */
    public final int getRobotMemberShip() {
        return this.robotMemberShip;
    }

    /* renamed from: c, reason: from getter */
    public final int getUserMemberShip() {
        return this.userMemberShip;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsFriend() {
        return this.isFriend;
    }

    public final void e(boolean z16) {
        this.isFriend = z16;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof d)) {
            return false;
        }
        d dVar = (d) other;
        if (this.robotMemberShip == dVar.robotMemberShip && this.userMemberShip == dVar.userMemberShip && this.isFriend == dVar.isFriend && this.allowAdd2Group == dVar.allowAdd2Group && this.allowAdd2C2C == dVar.allowAdd2C2C) {
            return true;
        }
        return false;
    }

    public final void f(int i3) {
        this.robotMemberShip = i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = ((this.robotMemberShip * 31) + this.userMemberShip) * 31;
        boolean z16 = this.isFriend;
        int i16 = 1;
        int i17 = z16;
        if (z16 != 0) {
            i17 = 1;
        }
        int i18 = (i3 + i17) * 31;
        boolean z17 = this.allowAdd2Group;
        int i19 = z17;
        if (z17 != 0) {
            i19 = 1;
        }
        int i26 = (i18 + i19) * 31;
        boolean z18 = this.allowAdd2C2C;
        if (!z18) {
            i16 = z18 ? 1 : 0;
        }
        return i26 + i16;
    }

    @NotNull
    public String toString() {
        return "RelationShip=[hashCod:" + hashCode() + " robotMemberShip:" + this.robotMemberShip + " userMemberShip:" + this.userMemberShip + " isFriend:" + this.isFriend + " allowAdd2Group:" + this.allowAdd2Group + " allowAdd2C2C:" + this.allowAdd2C2C + "]";
    }

    public d(int i3, int i16, boolean z16, boolean z17, boolean z18) {
        this.robotMemberShip = i3;
        this.userMemberShip = i16;
        this.isFriend = z16;
        this.allowAdd2Group = z17;
        this.allowAdd2C2C = z18;
    }

    public /* synthetic */ d(int i3, int i16, boolean z16, boolean z17, boolean z18, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? -1 : i3, (i17 & 2) == 0 ? i16 : -1, (i17 & 4) != 0 ? false : z16, (i17 & 8) != 0 ? false : z17, (i17 & 16) != 0 ? false : z18);
    }
}
