package com.tencent.robot.aio.helper.tts.task;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/robot/aio/helper/tts/task/RobotTtsSimpleEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "()V", "OnPickedTtsIdChangedEvent", "StopAllRobotTtsSimpleEvent", "Lcom/tencent/robot/aio/helper/tts/task/RobotTtsSimpleEvent$OnPickedTtsIdChangedEvent;", "Lcom/tencent/robot/aio/helper/tts/task/RobotTtsSimpleEvent$StopAllRobotTtsSimpleEvent;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class RobotTtsSimpleEvent extends SimpleBaseEvent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/robot/aio/helper/tts/task/RobotTtsSimpleEvent$OnPickedTtsIdChangedEvent;", "Lcom/tencent/robot/aio/helper/tts/task/RobotTtsSimpleEvent;", "robotUin", "", "ttsId", "(Ljava/lang/String;Ljava/lang/String;)V", "getRobotUin", "()Ljava/lang/String;", "getTtsId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final /* data */ class OnPickedTtsIdChangedEvent extends RobotTtsSimpleEvent {

        @NotNull
        private final String robotUin;

        @NotNull
        private final String ttsId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnPickedTtsIdChangedEvent(@NotNull String robotUin, @NotNull String ttsId) {
            super(null);
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(ttsId, "ttsId");
            this.robotUin = robotUin;
            this.ttsId = ttsId;
        }

        public static /* synthetic */ OnPickedTtsIdChangedEvent copy$default(OnPickedTtsIdChangedEvent onPickedTtsIdChangedEvent, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = onPickedTtsIdChangedEvent.robotUin;
            }
            if ((i3 & 2) != 0) {
                str2 = onPickedTtsIdChangedEvent.ttsId;
            }
            return onPickedTtsIdChangedEvent.copy(str, str2);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getRobotUin() {
            return this.robotUin;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getTtsId() {
            return this.ttsId;
        }

        @NotNull
        public final OnPickedTtsIdChangedEvent copy(@NotNull String robotUin, @NotNull String ttsId) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(ttsId, "ttsId");
            return new OnPickedTtsIdChangedEvent(robotUin, ttsId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnPickedTtsIdChangedEvent)) {
                return false;
            }
            OnPickedTtsIdChangedEvent onPickedTtsIdChangedEvent = (OnPickedTtsIdChangedEvent) other;
            if (Intrinsics.areEqual(this.robotUin, onPickedTtsIdChangedEvent.robotUin) && Intrinsics.areEqual(this.ttsId, onPickedTtsIdChangedEvent.ttsId)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getRobotUin() {
            return this.robotUin;
        }

        @NotNull
        public final String getTtsId() {
            return this.ttsId;
        }

        public int hashCode() {
            return (this.robotUin.hashCode() * 31) + this.ttsId.hashCode();
        }

        @NotNull
        public String toString() {
            return "OnPickedTtsIdChangedEvent(robotUin=" + this.robotUin + ", ttsId=" + this.ttsId + ")";
        }

        public /* synthetic */ OnPickedTtsIdChangedEvent(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? "" : str2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/robot/aio/helper/tts/task/RobotTtsSimpleEvent$StopAllRobotTtsSimpleEvent;", "Lcom/tencent/robot/aio/helper/tts/task/RobotTtsSimpleEvent;", "source", "", "(Ljava/lang/String;)V", "getSource", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final /* data */ class StopAllRobotTtsSimpleEvent extends RobotTtsSimpleEvent {

        @NotNull
        private final String source;

        public StopAllRobotTtsSimpleEvent() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ StopAllRobotTtsSimpleEvent copy$default(StopAllRobotTtsSimpleEvent stopAllRobotTtsSimpleEvent, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = stopAllRobotTtsSimpleEvent.source;
            }
            return stopAllRobotTtsSimpleEvent.copy(str);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getSource() {
            return this.source;
        }

        @NotNull
        public final StopAllRobotTtsSimpleEvent copy(@NotNull String source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new StopAllRobotTtsSimpleEvent(source);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof StopAllRobotTtsSimpleEvent) && Intrinsics.areEqual(this.source, ((StopAllRobotTtsSimpleEvent) other).source)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getSource() {
            return this.source;
        }

        public int hashCode() {
            return this.source.hashCode();
        }

        @NotNull
        public String toString() {
            return "StopAllRobotTtsSimpleEvent(source=" + this.source + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StopAllRobotTtsSimpleEvent(@NotNull String source) {
            super(null);
            Intrinsics.checkNotNullParameter(source, "source");
            this.source = source;
        }

        public /* synthetic */ StopAllRobotTtsSimpleEvent(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str);
        }
    }

    public /* synthetic */ RobotTtsSimpleEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    RobotTtsSimpleEvent() {
    }
}
