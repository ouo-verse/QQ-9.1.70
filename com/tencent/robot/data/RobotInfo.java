package com.tencent.robot.data;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\nH\u00c6\u0003J\t\u0010\"\u001a\u00020\fH\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003Jk\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010%\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010'H\u00d6\u0003J\t\u0010(\u001a\u00020)H\u00d6\u0001J\t\u0010*\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006+"}, d2 = {"Lcom/tencent/robot/data/RobotInfo;", "Ljava/io/Serializable;", "robotAppId", "", "robotName", "robotDesc", "robotAvatarUrl", "robotJumpUrl", "robotUin", "shareState", "Lcom/tencent/robot/data/RobotShareState;", "allowAddC2C", "", "robotUid", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/robot/data/RobotShareState;ZLjava/lang/String;)V", "getAllowAddC2C", "()Z", "getRobotAppId", "()Ljava/lang/String;", "getRobotAvatarUrl", "getRobotDesc", "getRobotJumpUrl", "getRobotName", "getRobotUid", "getRobotUin", "getShareState", "()Lcom/tencent/robot/data/RobotShareState;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final /* data */ class RobotInfo implements Serializable {
    private final boolean allowAddC2C;

    @NotNull
    private final String robotAppId;

    @NotNull
    private final String robotAvatarUrl;

    @Nullable
    private final String robotDesc;

    @Nullable
    private final String robotJumpUrl;

    @NotNull
    private final String robotName;

    @Nullable
    private final String robotUid;

    @Nullable
    private final String robotUin;

    @NotNull
    private final RobotShareState shareState;

    public RobotInfo(@NotNull String robotAppId, @NotNull String robotName, @Nullable String str, @NotNull String robotAvatarUrl, @Nullable String str2, @Nullable String str3, @NotNull RobotShareState shareState, boolean z16, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(robotAppId, "robotAppId");
        Intrinsics.checkNotNullParameter(robotName, "robotName");
        Intrinsics.checkNotNullParameter(robotAvatarUrl, "robotAvatarUrl");
        Intrinsics.checkNotNullParameter(shareState, "shareState");
        this.robotAppId = robotAppId;
        this.robotName = robotName;
        this.robotDesc = str;
        this.robotAvatarUrl = robotAvatarUrl;
        this.robotJumpUrl = str2;
        this.robotUin = str3;
        this.shareState = shareState;
        this.allowAddC2C = z16;
        this.robotUid = str4;
    }

    public static /* synthetic */ RobotInfo copy$default(RobotInfo robotInfo, String str, String str2, String str3, String str4, String str5, String str6, RobotShareState robotShareState, boolean z16, String str7, int i3, Object obj) {
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        RobotShareState robotShareState2;
        boolean z17;
        String str14;
        if ((i3 & 1) != 0) {
            str8 = robotInfo.robotAppId;
        } else {
            str8 = str;
        }
        if ((i3 & 2) != 0) {
            str9 = robotInfo.robotName;
        } else {
            str9 = str2;
        }
        if ((i3 & 4) != 0) {
            str10 = robotInfo.robotDesc;
        } else {
            str10 = str3;
        }
        if ((i3 & 8) != 0) {
            str11 = robotInfo.robotAvatarUrl;
        } else {
            str11 = str4;
        }
        if ((i3 & 16) != 0) {
            str12 = robotInfo.robotJumpUrl;
        } else {
            str12 = str5;
        }
        if ((i3 & 32) != 0) {
            str13 = robotInfo.robotUin;
        } else {
            str13 = str6;
        }
        if ((i3 & 64) != 0) {
            robotShareState2 = robotInfo.shareState;
        } else {
            robotShareState2 = robotShareState;
        }
        if ((i3 & 128) != 0) {
            z17 = robotInfo.allowAddC2C;
        } else {
            z17 = z16;
        }
        if ((i3 & 256) != 0) {
            str14 = robotInfo.robotUid;
        } else {
            str14 = str7;
        }
        return robotInfo.copy(str8, str9, str10, str11, str12, str13, robotShareState2, z17, str14);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getRobotAppId() {
        return this.robotAppId;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getRobotName() {
        return this.robotName;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getRobotDesc() {
        return this.robotDesc;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getRobotAvatarUrl() {
        return this.robotAvatarUrl;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getRobotJumpUrl() {
        return this.robotJumpUrl;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getRobotUin() {
        return this.robotUin;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final RobotShareState getShareState() {
        return this.shareState;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getAllowAddC2C() {
        return this.allowAddC2C;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getRobotUid() {
        return this.robotUid;
    }

    @NotNull
    public final RobotInfo copy(@NotNull String robotAppId, @NotNull String robotName, @Nullable String robotDesc, @NotNull String robotAvatarUrl, @Nullable String robotJumpUrl, @Nullable String robotUin, @NotNull RobotShareState shareState, boolean allowAddC2C, @Nullable String robotUid) {
        Intrinsics.checkNotNullParameter(robotAppId, "robotAppId");
        Intrinsics.checkNotNullParameter(robotName, "robotName");
        Intrinsics.checkNotNullParameter(robotAvatarUrl, "robotAvatarUrl");
        Intrinsics.checkNotNullParameter(shareState, "shareState");
        return new RobotInfo(robotAppId, robotName, robotDesc, robotAvatarUrl, robotJumpUrl, robotUin, shareState, allowAddC2C, robotUid);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RobotInfo)) {
            return false;
        }
        RobotInfo robotInfo = (RobotInfo) other;
        if (Intrinsics.areEqual(this.robotAppId, robotInfo.robotAppId) && Intrinsics.areEqual(this.robotName, robotInfo.robotName) && Intrinsics.areEqual(this.robotDesc, robotInfo.robotDesc) && Intrinsics.areEqual(this.robotAvatarUrl, robotInfo.robotAvatarUrl) && Intrinsics.areEqual(this.robotJumpUrl, robotInfo.robotJumpUrl) && Intrinsics.areEqual(this.robotUin, robotInfo.robotUin) && this.shareState == robotInfo.shareState && this.allowAddC2C == robotInfo.allowAddC2C && Intrinsics.areEqual(this.robotUid, robotInfo.robotUid)) {
            return true;
        }
        return false;
    }

    public final boolean getAllowAddC2C() {
        return this.allowAddC2C;
    }

    @NotNull
    public final String getRobotAppId() {
        return this.robotAppId;
    }

    @NotNull
    public final String getRobotAvatarUrl() {
        return this.robotAvatarUrl;
    }

    @Nullable
    public final String getRobotDesc() {
        return this.robotDesc;
    }

    @Nullable
    public final String getRobotJumpUrl() {
        return this.robotJumpUrl;
    }

    @NotNull
    public final String getRobotName() {
        return this.robotName;
    }

    @Nullable
    public final String getRobotUid() {
        return this.robotUid;
    }

    @Nullable
    public final String getRobotUin() {
        return this.robotUin;
    }

    @NotNull
    public final RobotShareState getShareState() {
        return this.shareState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4 = ((this.robotAppId.hashCode() * 31) + this.robotName.hashCode()) * 31;
        String str = this.robotDesc;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int hashCode5 = (((hashCode4 + hashCode) * 31) + this.robotAvatarUrl.hashCode()) * 31;
        String str2 = this.robotJumpUrl;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i16 = (hashCode5 + hashCode2) * 31;
        String str3 = this.robotUin;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int hashCode6 = (((i16 + hashCode3) * 31) + this.shareState.hashCode()) * 31;
        boolean z16 = this.allowAddC2C;
        int i17 = z16;
        if (z16 != 0) {
            i17 = 1;
        }
        int i18 = (hashCode6 + i17) * 31;
        String str4 = this.robotUid;
        if (str4 != null) {
            i3 = str4.hashCode();
        }
        return i18 + i3;
    }

    @NotNull
    public String toString() {
        return "RobotInfo(robotAppId=" + this.robotAppId + ", robotName=" + this.robotName + ", robotDesc=" + this.robotDesc + ", robotAvatarUrl=" + this.robotAvatarUrl + ", robotJumpUrl=" + this.robotJumpUrl + ", robotUin=" + this.robotUin + ", shareState=" + this.shareState + ", allowAddC2C=" + this.allowAddC2C + ", robotUid=" + this.robotUid + ")";
    }

    public /* synthetic */ RobotInfo(String str, String str2, String str3, String str4, String str5, String str6, RobotShareState robotShareState, boolean z16, String str7, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i3 & 4) != 0 ? "" : str3, str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? "" : str6, (i3 & 64) != 0 ? RobotShareState.NORMAL : robotShareState, (i3 & 128) != 0 ? false : z16, (i3 & 256) != 0 ? "" : str7);
    }
}
