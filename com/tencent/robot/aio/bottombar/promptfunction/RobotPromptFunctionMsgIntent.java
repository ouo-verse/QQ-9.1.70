package com.tencent.robot.aio.bottombar.promptfunction;

import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import com.tencent.robot.aio.bottombar.model.RobotBottomBarItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/robot/aio/bottombar/promptfunction/RobotPromptFunctionMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "ShowRobotFunctionDialog", "Lcom/tencent/robot/aio/bottombar/promptfunction/RobotPromptFunctionMsgIntent$ShowRobotFunctionDialog;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class RobotPromptFunctionMsgIntent implements MsgIntent {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/aio/bottombar/promptfunction/RobotPromptFunctionMsgIntent$ShowRobotFunctionDialog;", "Lcom/tencent/robot/aio/bottombar/promptfunction/RobotPromptFunctionMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/robot/aio/bottombar/model/a;", "d", "Lcom/tencent/robot/aio/bottombar/model/a;", "a", "()Lcom/tencent/robot/aio/bottombar/model/a;", "data", "<init>", "(Lcom/tencent/robot/aio/bottombar/model/a;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class ShowRobotFunctionDialog extends RobotPromptFunctionMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final RobotBottomBarItemModel data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowRobotFunctionDialog(@NotNull RobotBottomBarItemModel data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final RobotBottomBarItemModel getData() {
            return this.data;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof ShowRobotFunctionDialog) && Intrinsics.areEqual(this.data, ((ShowRobotFunctionDialog) other).data)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "ShowRobotFunctionDialog(data=" + this.data + ")";
        }
    }

    public /* synthetic */ RobotPromptFunctionMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
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

    RobotPromptFunctionMsgIntent() {
    }
}
