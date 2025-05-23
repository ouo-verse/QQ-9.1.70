package com.tencent.robot.profile;

import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotFeature;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/robot/profile/RobotProfileMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "OnRobotCoreInfoUpdated", "OnRobotPersonalInfoUpdated", "OnRobotProfileUpdate", "Lcom/tencent/robot/profile/RobotProfileMsgIntent$OnRobotCoreInfoUpdated;", "Lcom/tencent/robot/profile/RobotProfileMsgIntent$OnRobotPersonalInfoUpdated;", "Lcom/tencent/robot/profile/RobotProfileMsgIntent$OnRobotProfileUpdate;", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class RobotProfileMsgIntent implements MsgIntent {

    @AutoEventName
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/profile/RobotProfileMsgIntent$OnRobotCoreInfoUpdated;", "Lcom/tencent/robot/profile/RobotProfileMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "a", "()Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "robotCoreInfo", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class OnRobotCoreInfoUpdated extends RobotProfileMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final RobotCoreInfo robotCoreInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnRobotCoreInfoUpdated(@NotNull RobotCoreInfo robotCoreInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(robotCoreInfo, "robotCoreInfo");
            this.robotCoreInfo = robotCoreInfo;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final RobotCoreInfo getRobotCoreInfo() {
            return this.robotCoreInfo;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof OnRobotCoreInfoUpdated) && Intrinsics.areEqual(this.robotCoreInfo, ((OnRobotCoreInfoUpdated) other).robotCoreInfo)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.robot.profile.RobotProfileMsgIntent.OnRobotCoreInfoUpdated";
        }

        public int hashCode() {
            return this.robotCoreInfo.hashCode();
        }

        @NotNull
        public String toString() {
            return "OnRobotCoreInfoUpdated(robotCoreInfo=" + this.robotCoreInfo + ")";
        }
    }

    @AutoEventName
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/robot/profile/RobotProfileMsgIntent$OnRobotPersonalInfoUpdated;", "Lcom/tencent/robot/profile/RobotProfileMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "robotUin", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotFeature;", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotFeature;", "a", "()Lcom/tencent/qqnt/kernel/nativeinterface/RobotFeature;", "robotFeature", "<init>", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/RobotFeature;)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class OnRobotPersonalInfoUpdated extends RobotProfileMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String robotUin;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final RobotFeature robotFeature;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnRobotPersonalInfoUpdated(@NotNull String robotUin, @NotNull RobotFeature robotFeature) {
            super(null);
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(robotFeature, "robotFeature");
            this.robotUin = robotUin;
            this.robotFeature = robotFeature;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final RobotFeature getRobotFeature() {
            return this.robotFeature;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getRobotUin() {
            return this.robotUin;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnRobotPersonalInfoUpdated)) {
                return false;
            }
            OnRobotPersonalInfoUpdated onRobotPersonalInfoUpdated = (OnRobotPersonalInfoUpdated) other;
            if (Intrinsics.areEqual(this.robotUin, onRobotPersonalInfoUpdated.robotUin) && Intrinsics.areEqual(this.robotFeature, onRobotPersonalInfoUpdated.robotFeature)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.robot.profile.RobotProfileMsgIntent.OnRobotPersonalInfoUpdated";
        }

        public int hashCode() {
            return (this.robotUin.hashCode() * 31) + this.robotFeature.hashCode();
        }

        @NotNull
        public String toString() {
            return "OnRobotPersonalInfoUpdated(robotUin=" + this.robotUin + ", robotFeature=" + this.robotFeature + ")";
        }
    }

    @AutoEventName
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/profile/RobotProfileMsgIntent$OnRobotProfileUpdate;", "Lcom/tencent/robot/profile/RobotProfileMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "a", "()Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class OnRobotProfileUpdate extends RobotProfileMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final GroupRobotProfile robotProfile;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnRobotProfileUpdate(@NotNull GroupRobotProfile robotProfile) {
            super(null);
            Intrinsics.checkNotNullParameter(robotProfile, "robotProfile");
            this.robotProfile = robotProfile;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final GroupRobotProfile getRobotProfile() {
            return this.robotProfile;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof OnRobotProfileUpdate) && Intrinsics.areEqual(this.robotProfile, ((OnRobotProfileUpdate) other).robotProfile)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.robot.profile.RobotProfileMsgIntent.OnRobotProfileUpdate";
        }

        public int hashCode() {
            return this.robotProfile.hashCode();
        }

        @NotNull
        public String toString() {
            return "OnRobotProfileUpdate(robotProfile=" + this.robotProfile + ")";
        }
    }

    public /* synthetic */ RobotProfileMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    RobotProfileMsgIntent() {
    }
}
