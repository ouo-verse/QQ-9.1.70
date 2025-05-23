package com.tencent.robot.aio.input.inputbar.pttrecord;

import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/pttrecord/RobotInputPttRecordUIState;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "()V", "FullScreenModeChangedState", "InputStyleConfigChangedState", "SetPttRecordModeState", "Lcom/tencent/robot/aio/input/inputbar/pttrecord/RobotInputPttRecordUIState$FullScreenModeChangedState;", "Lcom/tencent/robot/aio/input/inputbar/pttrecord/RobotInputPttRecordUIState$InputStyleConfigChangedState;", "Lcom/tencent/robot/aio/input/inputbar/pttrecord/RobotInputPttRecordUIState$SetPttRecordModeState;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class RobotInputPttRecordUIState implements InputUIState {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/pttrecord/RobotInputPttRecordUIState$FullScreenModeChangedState;", "Lcom/tencent/robot/aio/input/inputbar/pttrecord/RobotInputPttRecordUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "isFullScreenMode", "<init>", "(Z)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class FullScreenModeChangedState extends RobotInputPttRecordUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isFullScreenMode;

        public FullScreenModeChangedState(boolean z16) {
            super(null);
            this.isFullScreenMode = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsFullScreenMode() {
            return this.isFullScreenMode;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof FullScreenModeChangedState) && this.isFullScreenMode == ((FullScreenModeChangedState) other).isFullScreenMode) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.isFullScreenMode;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "FullScreenModeChangedState(isFullScreenMode=" + this.isFullScreenMode + ")";
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/pttrecord/RobotInputPttRecordUIState$InputStyleConfigChangedState;", "Lcom/tencent/robot/aio/input/inputbar/pttrecord/RobotInputPttRecordUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/robot/aio/input/styleconfig/a;", "d", "Lcom/tencent/robot/aio/input/styleconfig/a;", "a", "()Lcom/tencent/robot/aio/input/styleconfig/a;", "inputStyleConfig", "<init>", "(Lcom/tencent/robot/aio/input/styleconfig/a;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class InputStyleConfigChangedState extends RobotInputPttRecordUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final com.tencent.robot.aio.input.styleconfig.a inputStyleConfig;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InputStyleConfigChangedState(@NotNull com.tencent.robot.aio.input.styleconfig.a inputStyleConfig) {
            super(null);
            Intrinsics.checkNotNullParameter(inputStyleConfig, "inputStyleConfig");
            this.inputStyleConfig = inputStyleConfig;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final com.tencent.robot.aio.input.styleconfig.a getInputStyleConfig() {
            return this.inputStyleConfig;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof InputStyleConfigChangedState) && Intrinsics.areEqual(this.inputStyleConfig, ((InputStyleConfigChangedState) other).inputStyleConfig)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.inputStyleConfig.hashCode();
        }

        @NotNull
        public String toString() {
            return "InputStyleConfigChangedState(inputStyleConfig=" + this.inputStyleConfig + ")";
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/pttrecord/RobotInputPttRecordUIState$SetPttRecordModeState;", "Lcom/tencent/robot/aio/input/inputbar/pttrecord/RobotInputPttRecordUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "isPttRecordMode", "<init>", "(Z)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class SetPttRecordModeState extends RobotInputPttRecordUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isPttRecordMode;

        public SetPttRecordModeState(boolean z16) {
            super(null);
            this.isPttRecordMode = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsPttRecordMode() {
            return this.isPttRecordMode;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof SetPttRecordModeState) && this.isPttRecordMode == ((SetPttRecordModeState) other).isPttRecordMode) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.isPttRecordMode;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "SetPttRecordModeState(isPttRecordMode=" + this.isPttRecordMode + ")";
        }
    }

    public /* synthetic */ RobotInputPttRecordUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    RobotInputPttRecordUIState() {
    }
}
