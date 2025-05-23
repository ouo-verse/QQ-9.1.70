package com.tencent.robot.aio.input.inputbar.edittext;

import androidx.annotation.ColorInt;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.mvi.base.route.h;
import com.tencent.robot.aio.input.styleconfig.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/edittext/RobotInputEditTextExtUIState;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "()V", "FullScreenModeChangedState", "InputStyleChangedState", "PostInputEditTextRunnable", "PttRecordModeChangedState", "UpdateBackgroundColor", "Lcom/tencent/robot/aio/input/inputbar/edittext/RobotInputEditTextExtUIState$FullScreenModeChangedState;", "Lcom/tencent/robot/aio/input/inputbar/edittext/RobotInputEditTextExtUIState$InputStyleChangedState;", "Lcom/tencent/robot/aio/input/inputbar/edittext/RobotInputEditTextExtUIState$PostInputEditTextRunnable;", "Lcom/tencent/robot/aio/input/inputbar/edittext/RobotInputEditTextExtUIState$PttRecordModeChangedState;", "Lcom/tencent/robot/aio/input/inputbar/edittext/RobotInputEditTextExtUIState$UpdateBackgroundColor;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class RobotInputEditTextExtUIState implements InputUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/edittext/RobotInputEditTextExtUIState$FullScreenModeChangedState;", "Lcom/tencent/robot/aio/input/inputbar/edittext/RobotInputEditTextExtUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "isFullScreenMode", "<init>", "(Z)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class FullScreenModeChangedState extends RobotInputEditTextExtUIState {

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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/edittext/RobotInputEditTextExtUIState$InputStyleChangedState;", "Lcom/tencent/robot/aio/input/inputbar/edittext/RobotInputEditTextExtUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/robot/aio/input/styleconfig/a;", "d", "Lcom/tencent/robot/aio/input/styleconfig/a;", "a", "()Lcom/tencent/robot/aio/input/styleconfig/a;", "inputStyleConfig", "<init>", "(Lcom/tencent/robot/aio/input/styleconfig/a;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class InputStyleChangedState extends RobotInputEditTextExtUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final a inputStyleConfig;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InputStyleChangedState(@NotNull a inputStyleConfig) {
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
            if ((other instanceof InputStyleChangedState) && Intrinsics.areEqual(this.inputStyleConfig, ((InputStyleChangedState) other).inputStyleConfig)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.inputStyleConfig.hashCode();
        }

        @NotNull
        public String toString() {
            return "InputStyleChangedState(inputStyleConfig=" + this.inputStyleConfig + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/edittext/RobotInputEditTextExtUIState$PostInputEditTextRunnable;", "Lcom/tencent/robot/aio/input/inputbar/edittext/RobotInputEditTextExtUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/Runnable;", "d", "Ljava/lang/Runnable;", "a", "()Ljava/lang/Runnable;", "runnable", "<init>", "(Ljava/lang/Runnable;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class PostInputEditTextRunnable extends RobotInputEditTextExtUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Runnable runnable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostInputEditTextRunnable(@NotNull Runnable runnable) {
            super(null);
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            this.runnable = runnable;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final Runnable getRunnable() {
            return this.runnable;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof PostInputEditTextRunnable) && Intrinsics.areEqual(this.runnable, ((PostInputEditTextRunnable) other).runnable)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.runnable.hashCode();
        }

        @NotNull
        public String toString() {
            return "PostInputEditTextRunnable(runnable=" + this.runnable + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/edittext/RobotInputEditTextExtUIState$PttRecordModeChangedState;", "Lcom/tencent/robot/aio/input/inputbar/edittext/RobotInputEditTextExtUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "isPttRecordMode", "<init>", "(Z)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class PttRecordModeChangedState extends RobotInputEditTextExtUIState {

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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/edittext/RobotInputEditTextExtUIState$UpdateBackgroundColor;", "Lcom/tencent/robot/aio/input/inputbar/edittext/RobotInputEditTextExtUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "color", "e", "Z", "b", "()Z", "needAnim", "<init>", "(IZ)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class UpdateBackgroundColor extends RobotInputEditTextExtUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int color;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean needAnim;

        public UpdateBackgroundColor(@ColorInt int i3, boolean z16) {
            super(null);
            this.color = i3;
            this.needAnim = z16;
        }

        /* renamed from: a, reason: from getter */
        public final int getColor() {
            return this.color;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getNeedAnim() {
            return this.needAnim;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateBackgroundColor)) {
                return false;
            }
            UpdateBackgroundColor updateBackgroundColor = (UpdateBackgroundColor) other;
            if (this.color == updateBackgroundColor.color && this.needAnim == updateBackgroundColor.needAnim) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i3 = this.color * 31;
            boolean z16 = this.needAnim;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            return i3 + i16;
        }

        @NotNull
        public String toString() {
            return "UpdateBackgroundColor(color=" + this.color + ", needAnim=" + this.needAnim + ")";
        }
    }

    public /* synthetic */ RobotInputEditTextExtUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    RobotInputEditTextExtUIState() {
    }
}
