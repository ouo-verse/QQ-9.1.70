package com.tencent.robot.aio.share.event;

import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import com.tencent.robot.aio.share.RobotSessionShareParams;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/robot/aio/share/event/RobotMultiShareMsgFromBar;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "OnShareCancel", "OnShareClick", "Lcom/tencent/robot/aio/share/event/RobotMultiShareMsgFromBar$OnShareCancel;", "Lcom/tencent/robot/aio/share/event/RobotMultiShareMsgFromBar$OnShareClick;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class RobotMultiShareMsgFromBar implements MsgIntent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/share/event/RobotMultiShareMsgFromBar$OnShareCancel;", "Lcom/tencent/robot/aio/share/event/RobotMultiShareMsgFromBar;", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class OnShareCancel extends RobotMultiShareMsgFromBar {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final OnShareCancel f367343d = new OnShareCancel();

        OnShareCancel() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/aio/share/event/RobotMultiShareMsgFromBar$OnShareClick;", "Lcom/tencent/robot/aio/share/event/RobotMultiShareMsgFromBar;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/robot/aio/share/RobotSessionShareParams;", "d", "Lcom/tencent/robot/aio/share/RobotSessionShareParams;", "a", "()Lcom/tencent/robot/aio/share/RobotSessionShareParams;", "params", "<init>", "(Lcom/tencent/robot/aio/share/RobotSessionShareParams;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class OnShareClick extends RobotMultiShareMsgFromBar {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final RobotSessionShareParams params;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnShareClick(@NotNull RobotSessionShareParams params) {
            super(null);
            Intrinsics.checkNotNullParameter(params, "params");
            this.params = params;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final RobotSessionShareParams getParams() {
            return this.params;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof OnShareClick) && Intrinsics.areEqual(this.params, ((OnShareClick) other).params)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.params.hashCode();
        }

        @NotNull
        public String toString() {
            return "OnShareClick(params=" + this.params + ")";
        }
    }

    public /* synthetic */ RobotMultiShareMsgFromBar(DefaultConstructorMarker defaultConstructorMarker) {
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

    RobotMultiShareMsgFromBar() {
    }
}
