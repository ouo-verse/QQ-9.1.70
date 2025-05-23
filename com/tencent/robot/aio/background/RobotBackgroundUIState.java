package com.tencent.robot.aio.background;

import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/robot/aio/background/RobotBackgroundUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "EnterAIOAnimationEnd", "OnBackgroundInfoUpdate", "Lcom/tencent/robot/aio/background/RobotBackgroundUIState$EnterAIOAnimationEnd;", "Lcom/tencent/robot/aio/background/RobotBackgroundUIState$OnBackgroundInfoUpdate;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class RobotBackgroundUIState implements MviUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/background/RobotBackgroundUIState$EnterAIOAnimationEnd;", "Lcom/tencent/robot/aio/background/RobotBackgroundUIState;", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class EnterAIOAnimationEnd extends RobotBackgroundUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final EnterAIOAnimationEnd f366845d = new EnterAIOAnimationEnd();

        EnterAIOAnimationEnd() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\b\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/robot/aio/background/RobotBackgroundUIState$OnBackgroundInfoUpdate;", "Lcom/tencent/robot/aio/background/RobotBackgroundUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "a", "()Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", "e", "Z", "b", "()Z", "isStoryAIO", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;Z)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class OnBackgroundInfoUpdate extends RobotBackgroundUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final GroupRobotProfile robotProfile;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isStoryAIO;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnBackgroundInfoUpdate(@NotNull GroupRobotProfile robotProfile, boolean z16) {
            super(null);
            Intrinsics.checkNotNullParameter(robotProfile, "robotProfile");
            this.robotProfile = robotProfile;
            this.isStoryAIO = z16;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final GroupRobotProfile getRobotProfile() {
            return this.robotProfile;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsStoryAIO() {
            return this.isStoryAIO;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnBackgroundInfoUpdate)) {
                return false;
            }
            OnBackgroundInfoUpdate onBackgroundInfoUpdate = (OnBackgroundInfoUpdate) other;
            if (Intrinsics.areEqual(this.robotProfile, onBackgroundInfoUpdate.robotProfile) && this.isStoryAIO == onBackgroundInfoUpdate.isStoryAIO) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.robotProfile.hashCode() * 31;
            boolean z16 = this.isStoryAIO;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            return "OnBackgroundInfoUpdate(robotProfile=" + this.robotProfile + ", isStoryAIO=" + this.isStoryAIO + ")";
        }
    }

    public /* synthetic */ RobotBackgroundUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    RobotBackgroundUIState() {
    }
}
