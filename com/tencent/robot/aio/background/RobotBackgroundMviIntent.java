package com.tencent.robot.aio.background;

import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0001\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/robot/aio/background/RobotBackgroundMviIntent;", "Lol3/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "<init>", "()V", "InitBackground", "Lcom/tencent/robot/aio/background/RobotBackgroundMviIntent$InitBackground;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class RobotBackgroundMviIntent implements ol3.b, MsgIntent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/aio/background/RobotBackgroundMviIntent$InitBackground;", "Lcom/tencent/robot/aio/background/RobotBackgroundMviIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/robot/aio/background/RobotAIOBackgroundContainer;", "d", "Lcom/tencent/robot/aio/background/RobotAIOBackgroundContainer;", "a", "()Lcom/tencent/robot/aio/background/RobotAIOBackgroundContainer;", "background", "<init>", "(Lcom/tencent/robot/aio/background/RobotAIOBackgroundContainer;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class InitBackground extends RobotBackgroundMviIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final RobotAIOBackgroundContainer background;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InitBackground(@NotNull RobotAIOBackgroundContainer background) {
            super(null);
            Intrinsics.checkNotNullParameter(background, "background");
            this.background = background;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final RobotAIOBackgroundContainer getBackground() {
            return this.background;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof InitBackground) && Intrinsics.areEqual(this.background, ((InitBackground) other).background)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.background.hashCode();
        }

        @NotNull
        public String toString() {
            return "InitBackground(background=" + this.background + ")";
        }
    }

    public /* synthetic */ RobotBackgroundMviIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    RobotBackgroundMviIntent() {
    }
}
