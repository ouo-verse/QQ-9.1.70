package com.tencent.robot.aio.input.inputbar.pttrecord;

import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/pttrecord/RobotInputPttRecordMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "OnPttRecordModeChanged", "SetPttBttBtnState", "SetPttRecordModeMsgIntent", "Lcom/tencent/robot/aio/input/inputbar/pttrecord/RobotInputPttRecordMsgIntent$OnPttRecordModeChanged;", "Lcom/tencent/robot/aio/input/inputbar/pttrecord/RobotInputPttRecordMsgIntent$SetPttBttBtnState;", "Lcom/tencent/robot/aio/input/inputbar/pttrecord/RobotInputPttRecordMsgIntent$SetPttRecordModeMsgIntent;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class RobotInputPttRecordMsgIntent implements MsgIntent {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/pttrecord/RobotInputPttRecordMsgIntent$OnPttRecordModeChanged;", "Lcom/tencent/robot/aio/input/inputbar/pttrecord/RobotInputPttRecordMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "isPttRecordMode", "<init>", "(Z)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class OnPttRecordModeChanged extends RobotInputPttRecordMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isPttRecordMode;

        public OnPttRecordModeChanged(boolean z16) {
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
            if ((other instanceof OnPttRecordModeChanged) && this.isPttRecordMode == ((OnPttRecordModeChanged) other).isPttRecordMode) {
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
            return "OnPttRecordModeChanged(isPttRecordMode=" + this.isPttRecordMode + ")";
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/pttrecord/RobotInputPttRecordMsgIntent$SetPttBttBtnState;", "Lcom/tencent/robot/aio/input/inputbar/pttrecord/RobotInputPttRecordMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "enable", "<init>", "(Z)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class SetPttBttBtnState extends RobotInputPttRecordMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean enable;

        public SetPttBttBtnState(boolean z16) {
            super(null);
            this.enable = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getEnable() {
            return this.enable;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof SetPttBttBtnState) && this.enable == ((SetPttBttBtnState) other).enable) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.enable;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "SetPttBttBtnState(enable=" + this.enable + ")";
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\b\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/pttrecord/RobotInputPttRecordMsgIntent$SetPttRecordModeMsgIntent;", "Lcom/tencent/robot/aio/input/inputbar/pttrecord/RobotInputPttRecordMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "source", "e", "Z", "b", "()Z", "isPttRecordMode", "<init>", "(Ljava/lang/String;Z)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class SetPttRecordModeMsgIntent extends RobotInputPttRecordMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String source;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isPttRecordMode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetPttRecordModeMsgIntent(@NotNull String source, boolean z16) {
            super(null);
            Intrinsics.checkNotNullParameter(source, "source");
            this.source = source;
            this.isPttRecordMode = z16;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getSource() {
            return this.source;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsPttRecordMode() {
            return this.isPttRecordMode;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SetPttRecordModeMsgIntent)) {
                return false;
            }
            SetPttRecordModeMsgIntent setPttRecordModeMsgIntent = (SetPttRecordModeMsgIntent) other;
            if (Intrinsics.areEqual(this.source, setPttRecordModeMsgIntent.source) && this.isPttRecordMode == setPttRecordModeMsgIntent.isPttRecordMode) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.source.hashCode() * 31;
            boolean z16 = this.isPttRecordMode;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            return "SetPttRecordModeMsgIntent(source=" + this.source + ", isPttRecordMode=" + this.isPttRecordMode + ")";
        }
    }

    public /* synthetic */ RobotInputPttRecordMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
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

    RobotInputPttRecordMsgIntent() {
    }
}
