package com.tencent.robot.aio.input.inputbar.plusbtn;

import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.mvi.base.route.h;
import com.tencent.robot.aio.input.styleconfig.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0006\t\n\u000b\f\r\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/plusbtn/RobotInputPlusBtnUIState;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "()V", "FullScreenModeChangedState", "InputEditTextChangedState", "InputStyleConfigChangedState", "OnPictureNumberChanged", "PanelStateChangedState", "PttRecordModeChangedState", "Lcom/tencent/robot/aio/input/inputbar/plusbtn/RobotInputPlusBtnUIState$FullScreenModeChangedState;", "Lcom/tencent/robot/aio/input/inputbar/plusbtn/RobotInputPlusBtnUIState$InputEditTextChangedState;", "Lcom/tencent/robot/aio/input/inputbar/plusbtn/RobotInputPlusBtnUIState$InputStyleConfigChangedState;", "Lcom/tencent/robot/aio/input/inputbar/plusbtn/RobotInputPlusBtnUIState$OnPictureNumberChanged;", "Lcom/tencent/robot/aio/input/inputbar/plusbtn/RobotInputPlusBtnUIState$PanelStateChangedState;", "Lcom/tencent/robot/aio/input/inputbar/plusbtn/RobotInputPlusBtnUIState$PttRecordModeChangedState;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class RobotInputPlusBtnUIState implements InputUIState {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/plusbtn/RobotInputPlusBtnUIState$FullScreenModeChangedState;", "Lcom/tencent/robot/aio/input/inputbar/plusbtn/RobotInputPlusBtnUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "isFullScreenMode", "<init>", "(Z)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class FullScreenModeChangedState extends RobotInputPlusBtnUIState {

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

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/plusbtn/RobotInputPlusBtnUIState$InputEditTextChangedState;", "Lcom/tencent/robot/aio/input/inputbar/plusbtn/RobotInputPlusBtnUIState;", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class InputEditTextChangedState extends RobotInputPlusBtnUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final InputEditTextChangedState f367200d = new InputEditTextChangedState();

        InputEditTextChangedState() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/plusbtn/RobotInputPlusBtnUIState$InputStyleConfigChangedState;", "Lcom/tencent/robot/aio/input/inputbar/plusbtn/RobotInputPlusBtnUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/robot/aio/input/styleconfig/a;", "d", "Lcom/tencent/robot/aio/input/styleconfig/a;", "a", "()Lcom/tencent/robot/aio/input/styleconfig/a;", "inputStyleConfig", "<init>", "(Lcom/tencent/robot/aio/input/styleconfig/a;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class InputStyleConfigChangedState extends RobotInputPlusBtnUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final a inputStyleConfig;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InputStyleConfigChangedState(@NotNull a inputStyleConfig) {
            super(null);
            Intrinsics.checkNotNullParameter(inputStyleConfig, "inputStyleConfig");
            this.inputStyleConfig = inputStyleConfig;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final a getInputStyleConfig() {
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

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/plusbtn/RobotInputPlusBtnUIState$OnPictureNumberChanged;", "Lcom/tencent/robot/aio/input/inputbar/plusbtn/RobotInputPlusBtnUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "count", "<init>", "(I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class OnPictureNumberChanged extends RobotInputPlusBtnUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int count;

        public OnPictureNumberChanged(int i3) {
            super(null);
            this.count = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof OnPictureNumberChanged) && this.count == ((OnPictureNumberChanged) other).count) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.count;
        }

        @NotNull
        public String toString() {
            return "OnPictureNumberChanged(count=" + this.count + ")";
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/plusbtn/RobotInputPlusBtnUIState$PanelStateChangedState;", "Lcom/tencent/robot/aio/input/inputbar/plusbtn/RobotInputPlusBtnUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "b", "()Z", "isShowPanel", "e", "I", "a", "()I", "panelId", "<init>", "(ZI)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class PanelStateChangedState extends RobotInputPlusBtnUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isShowPanel;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int panelId;

        public PanelStateChangedState(boolean z16, int i3) {
            super(null);
            this.isShowPanel = z16;
            this.panelId = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getPanelId() {
            return this.panelId;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsShowPanel() {
            return this.isShowPanel;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PanelStateChangedState)) {
                return false;
            }
            PanelStateChangedState panelStateChangedState = (PanelStateChangedState) other;
            if (this.isShowPanel == panelStateChangedState.isShowPanel && this.panelId == panelStateChangedState.panelId) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.isShowPanel;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (r06 * 31) + this.panelId;
        }

        @NotNull
        public String toString() {
            return "PanelStateChangedState(isShowPanel=" + this.isShowPanel + ", panelId=" + this.panelId + ")";
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/plusbtn/RobotInputPlusBtnUIState$PttRecordModeChangedState;", "Lcom/tencent/robot/aio/input/inputbar/plusbtn/RobotInputPlusBtnUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "isPttRecordMode", "<init>", "(Z)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class PttRecordModeChangedState extends RobotInputPlusBtnUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isPttRecordMode;

        public PttRecordModeChangedState(boolean z16) {
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
            if ((other instanceof PttRecordModeChangedState) && this.isPttRecordMode == ((PttRecordModeChangedState) other).isPttRecordMode) {
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
            return "PttRecordModeChangedState(isPttRecordMode=" + this.isPttRecordMode + ")";
        }
    }

    public /* synthetic */ RobotInputPlusBtnUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    RobotInputPlusBtnUIState() {
    }
}
