package com.tencent.mobileqq.aio.robot.inputbar;

import com.tencent.mobileqq.aio.input.AIOInputUIState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/inputbar/RobotInputUIState;", "Lcom/tencent/mobileqq/aio/input/AIOInputUIState;", "()V", "SetMultiSelectBarVisibility", "Lcom/tencent/mobileqq/aio/robot/inputbar/RobotInputUIState$SetMultiSelectBarVisibility;", "aio_ext_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public abstract class RobotInputUIState extends AIOInputUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/inputbar/RobotInputUIState$SetMultiSelectBarVisibility;", "Lcom/tencent/mobileqq/aio/robot/inputbar/RobotInputUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "source", "e", "I", "b", "()I", "visibility", "<init>", "(Ljava/lang/String;I)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class SetMultiSelectBarVisibility extends RobotInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String source;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int visibility;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetMultiSelectBarVisibility(@NotNull String source, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(source, "source");
            this.source = source;
            this.visibility = i3;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getSource() {
            return this.source;
        }

        /* renamed from: b, reason: from getter */
        public final int getVisibility() {
            return this.visibility;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SetMultiSelectBarVisibility)) {
                return false;
            }
            SetMultiSelectBarVisibility setMultiSelectBarVisibility = (SetMultiSelectBarVisibility) other;
            if (Intrinsics.areEqual(this.source, setMultiSelectBarVisibility.source) && this.visibility == setMultiSelectBarVisibility.visibility) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.source.hashCode() * 31) + this.visibility;
        }

        @NotNull
        public String toString() {
            return "SetMultiSelectBarVisibility(source=" + this.source + ", visibility=" + this.visibility + ")";
        }
    }

    public /* synthetic */ RobotInputUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    RobotInputUIState() {
    }
}
